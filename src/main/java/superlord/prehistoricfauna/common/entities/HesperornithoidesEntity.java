package superlord.prehistoricfauna.common.entities;

import java.util.Random;

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
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.RabbitEntity;
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
import superlord.prehistoricfauna.common.blocks.HesperornithoidesEggBlock;
import superlord.prehistoricfauna.common.entities.goal.HuntGoal;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.SoundInit;

public class HesperornithoidesEntity extends AnimalEntity {
	
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(HesperornithoidesEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(HesperornithoidesEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(HesperornithoidesEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(HesperornithoidesEntity.class, DataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(PFItems.RAW_EILENODON_MEAT.get());
	private int isDigging;
	private Goal attackAnimals;
	
	public HesperornithoidesEntity(EntityType<? extends HesperornithoidesEntity> type, World world) {
		super(type, world);
	}
	
	public boolean isDigging() {
		return this.dataManager.get(IS_DIGGING);
	}
	
	private void setDigging(boolean isDigging) {
		this.isDigging = isDigging ? 1 : 0;
		this.dataManager.set(IS_DIGGING, isDigging);
	}
	
	public boolean hasEgg() {
		return this.dataManager.get(HAS_EGG);
	}
	
	private void setHasEgg(boolean hasEgg) {
		this.dataManager.set(HAS_EGG, hasEgg);
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
		return stack.getItem() == PFItems.RAW_EILENODON_MEAT.get();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.attackAnimals = new HuntGoal(this, AnimalEntity.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof EilenodonEntity || p_213487_0_ instanceof RabbitEntity || p_213487_0_ instanceof ChickenEntity || p_213487_0_ instanceof ParrotEntity;
		});
		this.goalSelector.addGoal(1, new HesperornithoidesEntity.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(2, new HesperornithoidesEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, PlayerEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, AllosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, CeratosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, StegosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, CamarasaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, TyrannosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, TriceratopsEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, AnkylosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, DakotaraptorEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, HerrerasaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, ExaeretodonEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, HyperodapedonEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<SaurosuchusEntity>(this, SaurosuchusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(8, new HesperornithoidesEntity.LayEggGoal(this, 1.0D));
	}
	
	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 4.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.26D).createMutableAttribute(Attributes.FOLLOW_RANGE, 25.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D);
	}
	
	private void setAttackGoals() {
		this.targetSelector.addGoal(4, attackAnimals);
	}
	
	protected SoundEvent getAmbientSound() {
		return SoundInit.HESPERORNITHOIDES_IDLE;
	}
	
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.HESPERORNITHOIDES_HURT;
	}
	
	protected SoundEvent getDeathSound() {
		return SoundInit.HESPERORNITHOIDES_DEATH;
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
		compound.putBoolean("hasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
	}
	
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("hasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setAttackGoals();
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
	
	public boolean onLivingFall(float distance, float damageMultiplier) {
		return false;
	}
	
	public boolean attackEntityAsMob(Entity entity) {
		boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(Attributes.ATTACK_DAMAGE).getValue()));
		if (flag) {
			this.applyEnchantments(this, entity);
		}
		return flag;
	}
	
	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(HesperornithoidesEntity.this, 1.25D, true);
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
	
	class LayEggGoal extends MoveToBlockGoal {
		private final HesperornithoidesEntity hesperornithoides;
		
		public LayEggGoal(HesperornithoidesEntity hesperornithoides, double speed) {
			super(hesperornithoides, speed, 16);
			this.hesperornithoides = hesperornithoides;
		}
		
		public boolean shouldExecute() {
			return this.hesperornithoides.hasEgg() ? super.shouldExecute() : false;
		}
		
		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && this.hesperornithoides.hasEgg();
		}
		
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.hesperornithoides.getPositionVec());
			if (!this.hesperornithoides.isInWater() && this.getIsAboveDestination()) {
				if(this.hesperornithoides.isDigging < 1) {
					this.hesperornithoides.setDigging(true);
				} else if (this.hesperornithoides.isDigging > 200) {
					World world = this.hesperornithoides.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.HESPERORNITHOIDES_EGG.getDefaultState().with(HesperornithoidesEggBlock.EGGS, Integer.valueOf(this.hesperornithoides.rand.nextInt(4) + 1)), 3);
					this.hesperornithoides.setHasEgg(false);
					this.hesperornithoides.setDigging(false);
					this.hesperornithoides.setInLove(600);
				}
				if(this.hesperornithoides.isDigging()) {
					this.hesperornithoides.isDigging++;
				}
			}
		}
		
		protected boolean shouldMoveTo(IWorldReader world, BlockPos pos) {
			if (!world.isAirBlock(pos.up())) {
				return false;
			} else {
				Block block = world.getBlockState(pos).getBlock();
				return block == PFBlocks.SILT || block == PFBlocks.HARDENED_SILT || block == Blocks.SAND;
			}
		}
		
	}
	
	static class MateGoal extends BreedGoal {
		private final HesperornithoidesEntity hesperornithoides;
		
		public MateGoal(HesperornithoidesEntity hesperornithoides, double speed) {
			super(hesperornithoides, speed);
			this.hesperornithoides = hesperornithoides;
		}
		
		public boolean shouldExecute() {
			return super.shouldExecute() && !this.hesperornithoides.hasEgg();
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
			this.hesperornithoides.setHasEgg(true);
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
		HesperornithoidesEntity entity = new HesperornithoidesEntity(PFEntities.HESPERORNITHOIDES_ENTITY, this.world);
		entity.onInitialSpawn((IServerWorld) this.world, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}
	
}
