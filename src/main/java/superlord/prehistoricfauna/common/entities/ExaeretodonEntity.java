package superlord.prehistoricfauna.common.entities;

import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.stats.Stats;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.common.blocks.ExaeretodonEggBlock;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.SoundInit;

public class ExaeretodonEntity extends AnimalEntity {

	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(ExaeretodonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(ExaeretodonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(ExaeretodonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(ExaeretodonEntity.class, DataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(PFBlocks.CLADOPHLEBIS.asItem());
	private int isDigging;
	private int warningSoundTicks;

	public ExaeretodonEntity(EntityType<? extends ExaeretodonEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public boolean hasEgg() {
		return this.dataManager.get(HAS_EGG);
	}

	private void setHasEgg(boolean hasEgg) {
		this.dataManager.set(HAS_EGG, hasEgg);
	}

	public boolean isDigging() {
		return this.dataManager.get(IS_DIGGING);
	}

	private void setDigging(boolean isDigging) {
		this.isDigging = isDigging ? 1 : 0;
		this.dataManager.set(IS_DIGGING, isDigging);
	}

	public boolean isAlbino() {
		return this.dataManager.get(ALBINO);
	}

	private void setAlbino(boolean isAlbino) {
		this.dataManager.set(ALBINO, isAlbino);
	}

	public boolean isMelanistic() {
		return this.dataManager.get(MELANISTIC);
	}

	private void setMelanistic(boolean isMelanistic) {
		this.dataManager.set(MELANISTIC, isMelanistic);
	}

	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == PFBlocks.CLADOPHLEBIS.asItem();
	}

	protected void registerGoals() {
		super.registerGoals();

		this.goalSelector.addGoal(1, new ExaeretodonEntity.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new ExaeretodonEntity.PanicGoal());
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new ExaeretodonEntity.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new ExaeretodonEntity.AttackPlayerGoal());
		this.goalSelector.addGoal(8, new AvoidEntityGoal<PlayerEntity>(this, PlayerEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<TyrannosaurusEntity>(this, TyrannosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<TriceratopsEntity>(this, TriceratopsEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<AnkylosaurusEntity>(this, AnkylosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<DakotaraptorEntity>(this, DakotaraptorEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<AllosaurusEntity>(this, AllosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<CeratosaurusEntity>(this, CeratosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<CamarasaurusEntity>(this, CamarasaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<StegosaurusEntity>(this, StegosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<SaurosuchusEntity>(this, SaurosuchusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new ExaeretodonEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new ExaeretodonEntity.MateGoal(this, 1.0D));
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 6.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23D).createMutableAttribute(Attributes.FOLLOW_RANGE, 15).createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	protected SoundEvent getAmbientSound() {
		return SoundInit.EXAERETODON_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.EXAERETODON_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.EXAERETODON_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundInit.EXAERETODON_WARN, 1.0F, this.getSoundPitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(ALBINO, false);
		this.dataManager.register(MELANISTIC, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
	}

	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		Random rand = new Random();
		int birthNumber = rand.nextInt(399);
		if (birthNumber >= 0 && birthNumber < 4) {
			this.setAlbino(true);
		} else if (birthNumber >= 4 && birthNumber < 7) {
			this.setMelanistic(true);
		}
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(Attributes.ATTACK_DAMAGE).getValue()));
		if (flag) {
			this.applyEnchantments(this, entityIn);
		}
		return flag;
	}	

	class AttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public AttackPlayerGoal() {
			super(ExaeretodonEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean shouldExecute() {
			if (ExaeretodonEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for(ExaeretodonEntity exaeretodon : ExaeretodonEntity.this.world.getEntitiesWithinAABB(ExaeretodonEntity.class, ExaeretodonEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
						if (exaeretodon.isChild()) {
							return true;
						}
					}
				}
				return false;
			}
		}

		protected double getTargetDistance() {
			return super.getTargetDistance() * 0.5D;
		}
	}

	class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(ExaeretodonEntity.this);
		}

		public void startExecuting() {
			super.startExecuting();
			if (ExaeretodonEntity.this.isChild()) {
				this.alertOthers();
				this.resetTask();
			}
		}

		protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
			if (mobIn instanceof AllosaurusEntity && !mobIn.isChild()) {
				super.setAttackTarget(mobIn, targetIn);
			}
		}
	}

	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(ExaeretodonEntity.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.func_234040_h_()) {
				this.func_234039_g_();
				this.attacker.attackEntityAsMob(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.func_234040_h_()) {
					this.func_234039_g_();
				}

				if (this.func_234041_j_() <= 10) {
					ExaeretodonEntity.this.playWarningSound();
				}
			} else {
				this.func_234039_g_();
			}

		}

		public boolean shouldContinueExecuting() {
			float f = this.attacker.getBrightness();
			if (f >= 0.5F && this.attacker.getRNG().nextInt(100) == 0) {
				this.attacker.setAttackTarget((LivingEntity)null);
				return false;
			} else {
				return super.shouldContinueExecuting();
			}
		}

		public void resetTask() {
			super.resetTask();
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(4.0F + attackTarget.getWidth());
		}
	}

	class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(ExaeretodonEntity.this, 2.0D);
		}

		public boolean shouldExecute() {
			return !ExaeretodonEntity.this.isChild() && !ExaeretodonEntity.this.isBurning() ? false : super.shouldExecute();
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final ExaeretodonEntity exaeretodon;

		LayEggGoal(ExaeretodonEntity exaeretodon, double speed) {
			super(exaeretodon, speed, 16);
			this.exaeretodon = exaeretodon;
		}

		public boolean shouldExecute() {
			return this.exaeretodon.hasEgg() ? super.shouldExecute() : false;
		}

		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && this.exaeretodon.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.exaeretodon.getPositionVec());
			if (this.exaeretodon.isInWater() && this.getIsAboveDestination()) {
				if (this.exaeretodon.isDigging < 1) {
					this.exaeretodon.setDigging(true);
				} else if (this.exaeretodon.isDigging > 200) {
					World world = this.exaeretodon.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.EXAERETODON_EGG.getDefaultState().with(ExaeretodonEggBlock.EGGS, Integer.valueOf(this.exaeretodon.rand.nextInt(4) + 1)), 3);
					this.exaeretodon.setHasEgg(false);
					this.exaeretodon.setDigging(false);
					this.exaeretodon.setInLove(600);
				}
				if (this.exaeretodon.isDigging()) {
					this.exaeretodon.isDigging++;
				}
			}
		}

		protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			if (!worldIn.isAirBlock(pos.up())) {
				return false;
			} else {
				Block block = worldIn.getBlockState(pos).getBlock();
				return block == PFBlocks.LOAM || block == PFBlocks.PACKED_LOAM || block == Blocks.PODZOL;
			}
		}

	}

	static class MateGoal extends BreedGoal {
		private final ExaeretodonEntity exaeretodon;

		MateGoal(ExaeretodonEntity exaeretodon, double speed) {
			super(exaeretodon, speed);
			this.exaeretodon = exaeretodon;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.exaeretodon.hasEgg();
		}

		protected void spawnBaby() {
			ServerPlayerEntity serverPlayerEntity = this.animal.getLoveCause();
			if (serverPlayerEntity == null && this.targetMate.getLoveCause() != null) {
				serverPlayerEntity = this.targetMate.getLoveCause();
			}
			if (serverPlayerEntity != null) {
				serverPlayerEntity.addStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverPlayerEntity, this.animal, this.targetMate, (AgeableEntity)null);
			}
			this.exaeretodon.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}

	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		ExaeretodonEntity entity = new ExaeretodonEntity(PFEntities.EXAERETODON_ENTITY, this.world);
		entity.onInitialSpawn((IServerWorld) this.world, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}

}
