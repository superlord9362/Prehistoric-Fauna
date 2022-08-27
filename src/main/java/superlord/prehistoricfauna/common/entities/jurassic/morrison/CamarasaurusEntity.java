package superlord.prehistoricfauna.common.entities.jurassic.morrison;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.common.blocks.CamarasaurusEggBlock;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.common.entities.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entities.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFCustomDamageSource;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.SoundInit;

public class CamarasaurusEntity extends DinosaurEntity {

	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(CamarasaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(CamarasaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_JUVENILE = EntityDataManager.createKey(CamarasaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(CamarasaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(CamarasaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> EATING = EntityDataManager.createKey(CamarasaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> NATURAL_LOVE = EntityDataManager.createKey(CamarasaurusEntity.class, DataSerializers.BOOLEAN);
	private int maxHunger = 500;
	private int currentHunger;
	private int lastInLove = 0;
	int hungerTick = 0;
	private int warningSoundTicks;
	private int isDigging;
	int loveTick = 0;

	public CamarasaurusEntity(EntityType<? extends CamarasaurusEntity> type, World world) {
		super(type, world);
	}

	public boolean isDigging() {
		return this.dataManager.get(IS_DIGGING);
	}

	private void setDigging(boolean isDigging) {
		this.isDigging = isDigging ? 1 : 0;
		this.dataManager.set(IS_DIGGING, isDigging);
	}
	
	public boolean isJuvenile() {
		return this.dataManager.get(IS_JUVENILE);
	}

	private void setJuvenile(boolean isJuvenile) {
		this.dataManager.set(IS_JUVENILE, isJuvenile);
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

	public boolean isInLoveNaturally() {
		return this.dataManager.get(NATURAL_LOVE);
	}

	private void setInLoveNaturally(boolean isInLoveNaturally) {
		this.dataManager.set(NATURAL_LOVE, isInLoveNaturally);
	}
	
	public int getCurrentHunger() {
		return this.currentHunger;
	}

	private void setHunger(int currentHunger) {
		this.currentHunger = currentHunger;
	}

	public int getHalfHunger() {
		return maxHunger / 2;
	}

	public int getThreeQuartersHunger() {
		return (maxHunger / 4) * 3;
	}

	public boolean isEating() {
		return this.dataManager.get(EATING);
	}

	private void setEating(boolean isEating) {
		this.dataManager.set(EATING, isEating);
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == PFItems.PTILOPHYLLUM_FRONDS.get();
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new CamarasaurusEntity.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new CamarasaurusEntity.PanicGoal());
		this.goalSelector.addGoal(4, new CamarasaurusEntity.CamarasaurusFollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new CamarasaurusEntity.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new CamarasaurusEntity.AttackPlayerGoal());
		this.goalSelector.addGoal(0, new CamarasaurusEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new CamarasaurusEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new CamarasaurusEntity.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new CamarasaurusEntity.HerbivoreEatGoal((double)1.2F, 12, 2));
	}
	
	@Override
	public void setGrowingAge(int age) {
		super.setGrowingAge(age);
		if (this.getGrowingAge() >= -12000 && this.getGrowingAge() < 0) {
			this.setJuvenile(true);
		} else if(this.getGrowingAge() >= 0) {
			this.setJuvenile(false);
		}
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 200.0D).createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.22D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 12.0D).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : SoundInit.CAMARASAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.CAMARASAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.CAMARASAURUS_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundInit.CAMARASAURUS_WARN, 1.0F, this.getSoundPitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(ALBINO, false);
		this.dataManager.register(MELANISTIC, false);
		this.dataManager.register(IS_JUVENILE, false);
		this.dataManager.register(EATING, false);
		this.dataManager.register(NATURAL_LOVE, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("IsEating", this.isEating());
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setEating(compound.getBoolean("IsEating"));
		this.setHunger(compound.getInt("MaxHunger"));
		this.setInLoveNaturally(compound.getBoolean("InNaturalLove"));
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}
	
	@Override
	public void livingTick() {
		super.livingTick();
		if (this.getMotion().x != 0 && !this.isChild() || this.getMotion().z != 0  && !this.isChild() || this.getMotion().y != 0 && !this.isChild() ) {
			for (Entity entity : this.world.getEntitiesWithinAABB(LivingEntity.class, this.getBoundingBox().grow(1, 0, 1))) {
				if (!(entity instanceof CamarasaurusEntity)) {
					entity.attackEntityFrom(PFCustomDamageSource.SAUROPOD_TRAMPLING, (float) 5.0D);
				}
			}
		}
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.22D);
		}
		List<CamarasaurusEntity> list = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(20.0D, 20.0D, 20.0D));
		if (PrehistoricFaunaConfig.advancedHunger) {
			hungerTick++;
			if (hungerTick == 600 && !this.isChild() || hungerTick == 300 && this.isChild()) {
				hungerTick = 0;
				if (currentHunger != 0 || !this.isAsleep()) {
					this.setHunger(currentHunger - 1);
				}
				if (currentHunger == 0 && PrehistoricFaunaConfig.hungerDamage && this.getHealth() > (this.getMaxHealth() / 2)) {
					this.damageEntity(DamageSource.STARVE, 1);
				}
				if (currentHunger == 0 && PrehistoricFaunaConfig.hungerDamage && world.getDifficulty() == Difficulty.HARD) {
					this.damageEntity(DamageSource.STARVE, 1);
				}
			}
			if (this.getCurrentHunger() >= this.getThreeQuartersHunger() && hungerTick % 150 == 0) {
				if (this.getHealth() < this.getMaxHealth()) {
					float currentHealth = this.getHealth();
					this.setHealth(currentHealth + 1);
				}
			}
			if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
				if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && ticksExisted % 900 == 0 && !this.isChild() && !this.isInLove() && !this.isAsleep() && list.size() < 10) {
					loveTick = 600;
					this.setInLoveNaturally(true);
					this.setInLove(600);
					lastInLove = 28800;
				}
				if (loveTick != 0) {
					loveTick--;
				} else {
					this.setInLoveNaturally(false);
				}
			}
		} else if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
			int naturalBreedingChance = rand.nextInt(1000);
			if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isChild() && !this.isInLove() && !this.isAsleep() && list.size() < 10) {
				loveTick = 600;
				this.setInLoveNaturally(true);
				this.setInLove(600);
				lastInLove = 28800;
			}
			if (loveTick != 0) {
				loveTick--;
			} else {
				this.setInLoveNaturally(false);
			}
		}
		if (lastInLove != 0) {
			lastInLove--;
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
			super(CamarasaurusEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean shouldExecute() {
			if (CamarasaurusEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for(CamarasaurusEntity camarasaurus : CamarasaurusEntity.this.world.getEntitiesWithinAABB(CamarasaurusEntity.class, CamarasaurusEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
						if (camarasaurus.isChild()) {
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

	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		Random rand = new Random();
		int birthNumber = rand.nextInt(799);
		if (birthNumber >= 0 && birthNumber < 4) {
			this.setAlbino(true);
		} else if (birthNumber >= 4 && birthNumber < 7) {
			this.setMelanistic(true);
		}
		this.setHunger(500);
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(CamarasaurusEntity.this);
		}

		public void startExecuting() {
			super.startExecuting();
			if (CamarasaurusEntity.this.isChild()) {
				this.alertOthers();
				this.resetTask();
			}
		}

		protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
			if (mobIn instanceof CamarasaurusEntity && !mobIn.isChild()) {
				super.setAttackTarget(mobIn, targetIn);
			}
		}
	}

	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(CamarasaurusEntity.this, 1.25D, true);
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
					CamarasaurusEntity.this.playWarningSound();
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
			return (double)(15.0F + attackTarget.getWidth());
		}
	}

	class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(CamarasaurusEntity.this, 2.0D);
		}

		public boolean shouldExecute() {
			return !CamarasaurusEntity.this.isChild() && !CamarasaurusEntity.this.isBurning() ? false : super.shouldExecute();
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final CamarasaurusEntity camarasaurus;

		LayEggGoal(CamarasaurusEntity camarasaurus, double speedIn) {
			super(camarasaurus, speedIn, 16);
			this.camarasaurus = camarasaurus;
		}

		public boolean shouldExecute() {
			return this.camarasaurus.hasEgg() ? super.shouldExecute() : false;
		}

		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && this.camarasaurus.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.camarasaurus.getPositionVec());
			if (!this.camarasaurus.isInWater() && this.getIsAboveDestination()) {
				if (this.camarasaurus.isDigging < 1) {
					this.camarasaurus.setDigging(true);
				} else if (this.camarasaurus.isDigging > 200) {
					World world = this.camarasaurus.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.CAMARASAURUS_EGG.getDefaultState().with(CamarasaurusEggBlock.EGGS, Integer.valueOf(this.camarasaurus.rand.nextInt(4) + 1)), 3);
					this.camarasaurus.setHasEgg(false);
					this.camarasaurus.setDigging(false);
					this.camarasaurus.setInLove(600);
				}
				if (this.camarasaurus.isDigging()) {
					this.camarasaurus.isDigging++;
				}
			}
		}

		protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			if (!worldIn.isAirBlock(pos.up())) {
				return false;
			} else {
				Block block = worldIn.getBlockState(pos).getBlock();
				return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.MYCELIUM || block == Blocks.SAND || block == Blocks.RED_SAND || block == PFBlocks.MOSSY_DIRT || block == PFBlocks.MOSS_BLOCK || block == PFBlocks.LOAM || block == PFBlocks.PACKED_LOAM || block == PFBlocks.SILT || block == PFBlocks.PACKED_LOAM || block == BlockTags.LEAVES;
			}
		}
	}

	static class MateGoal extends BreedGoal {
		private final CamarasaurusEntity camarasaurus;

		MateGoal(CamarasaurusEntity camarasaurus, double speedIn) {
			super(camarasaurus, speedIn);
			this.camarasaurus = camarasaurus;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.camarasaurus.hasEgg() && !this.camarasaurus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			ServerPlayerEntity serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.targetMate.getLoveCause() != null) {
				serverplayerentity = this.targetMate.getLoveCause();
			}

			if (serverplayerentity != null) {
				serverplayerentity.addStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.targetMate, (AgeableEntity)null);
			}

			this.camarasaurus.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}
	}
	
	static class NaturalMateGoal extends BreedGoal {
		private final CamarasaurusEntity camarasaurus;

		NaturalMateGoal(CamarasaurusEntity camarasaurus, double speed) {
			super(camarasaurus, speed);
			this.camarasaurus = camarasaurus;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.camarasaurus.hasEgg() && this.camarasaurus.getCurrentHunger() >= this.camarasaurus.getThreeQuartersHunger() && this.camarasaurus.ticksExisted % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.camarasaurus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.camarasaurus.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.camarasaurus.rand.nextFloat() - this.camarasaurus.rand.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.camarasaurus.rand.nextInt(4);
				if (eggAmount == 0) {
					this.camarasaurus.entityDropItem(PFBlocks.CAMARASAURUS_EGG.asItem());
				}
				if (eggAmount == 1) {
					this.camarasaurus.entityDropItem(PFBlocks.CAMARASAURUS_EGG.asItem());
					this.camarasaurus.entityDropItem(PFBlocks.CAMARASAURUS_EGG.asItem());
				}
				if (eggAmount == 2) {
					this.camarasaurus.entityDropItem(PFBlocks.CAMARASAURUS_EGG.asItem());
					this.camarasaurus.entityDropItem(PFBlocks.CAMARASAURUS_EGG.asItem());
					this.camarasaurus.entityDropItem(PFBlocks.CAMARASAURUS_EGG.asItem());
				}
				if (eggAmount == 3) {
					this.camarasaurus.entityDropItem(PFBlocks.CAMARASAURUS_EGG.asItem());
					this.camarasaurus.entityDropItem(PFBlocks.CAMARASAURUS_EGG.asItem());
					this.camarasaurus.entityDropItem(PFBlocks.CAMARASAURUS_EGG.asItem());
					this.camarasaurus.entityDropItem(PFBlocks.CAMARASAURUS_EGG.asItem());
				}
			} else {
				this.camarasaurus.setHasEgg(true);
			}
			this.animal.resetInLove();
			this.targetMate.resetInLove();
		}

	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		CamarasaurusEntity entity = new CamarasaurusEntity(PFEntities.CAMARASAURUS_ENTITY, this.world);
		entity.onInitialSpawn((IServerWorld) world, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}
	
	class CamarasaurusFollowParentGoal extends Goal {
		private final CamarasaurusEntity babyCamarasaurusEntity;
		private CamarasaurusEntity parentCamarasaurusEntity;
		private final double moveSpeed;
		private int delayCounter;

		public CamarasaurusFollowParentGoal(CamarasaurusEntity camarasaurus, double speed) {
			this.babyCamarasaurusEntity = camarasaurus;
			this.moveSpeed = speed;
		}

		public boolean shouldExecute() {
			if (this.babyCamarasaurusEntity.isChild() && !this.babyCamarasaurusEntity.isJuvenile()) {
				List<CamarasaurusEntity> list = this.babyCamarasaurusEntity.world.getEntitiesWithinAABB(this.babyCamarasaurusEntity.getClass(), this.babyCamarasaurusEntity.getBoundingBox().grow(8.0D, 4.0D, 8.0D));
				CamarasaurusEntity camarasaurusEntity = null;
				double d0 = Double.MAX_VALUE;
				for (CamarasaurusEntity tyrannosaurusEntity1 : list) {
					if (!tyrannosaurusEntity1.isChild()) {
						double d1 = this.babyCamarasaurusEntity.getDistanceSq(tyrannosaurusEntity1);
						if (!(d1 > d0)) {
							d0 = d1;
							camarasaurusEntity = tyrannosaurusEntity1;
						}
					}
				}
				if (camarasaurusEntity == null) {
					return false;
				} else if (d0 < 9.0D) {
					return false;
				} else {
					this.parentCamarasaurusEntity = camarasaurusEntity;
					return true;
				}
			} else {
				return false;
			}
		}

		public boolean shouldContinueExecuting() {
			if (!this.babyCamarasaurusEntity.isJuvenile() || !this.babyCamarasaurusEntity.isChild()) {
				return false;
			} else if (!this.parentCamarasaurusEntity.isAlive()) {
				return false;
			} else  if(this.babyCamarasaurusEntity.isChild() && !this.babyCamarasaurusEntity.isJuvenile()){
				double d0 = this.babyCamarasaurusEntity.getDistanceSq(this.parentCamarasaurusEntity);
				return !(d0 < 9.0D) && !(d0 > 256.0D);
			} else {
				return false;
			}
		}

		public void startExecuting() {
			this.delayCounter = 0;
		}

		public void resetTask() {
			this.parentCamarasaurusEntity = null;
		}

		public void tick() {
			if (--this.delayCounter <= 0) {
				this.delayCounter = 10;
				this.babyCamarasaurusEntity.getNavigator().tryMoveToEntityLiving(this.parentCamarasaurusEntity, this.moveSpeed);
			}
		}
	}
	
	public class HerbivoreEatGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public HerbivoreEatGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(CamarasaurusEntity.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
		}

		public double getTargetDistanceSq() {
			return 2.0D;
		}

		public boolean shouldMove() {
			return this.timeoutCounter % 100 == 0;
		}

		/**
		 * Return true to set given position as destination
		 */
		protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			BlockState blockstate = worldIn.getBlockState(pos);
			return blockstate.isIn(PFBlocks.HORSETAIL) || blockstate.isIn(PFBlocks.TALL_HORSETAIL) || blockstate.isIn(PFBlocks.OSMUNDA) || blockstate.isIn(PFBlocks.TALL_OSMUNDA) || blockstate.isIn(PFBlocks.CLUBMOSS) || blockstate.isIn(PFBlocks.MARCHANTIA) || blockstate.isIn(PFBlocks.CONIOPTERIS) || blockstate.isIn(PFBlocks.OSMUNDACAULIS) || blockstate.isIn(PFBlocks.TALL_OSMUNDACAULIS) || blockstate.isIn(PFBlocks.DICROIDIUM) || blockstate.isIn(PFBlocks.JOHNSTONIA) || blockstate.isIn(PFBlocks.CLADOPHLEBIS) || blockstate.isIn(PFBlocks.SCYTOPHYLLUM) || blockstate.isIn(PFBlocks.MICHELILLOA) || blockstate.isIn(PFBlocks.DEAD_OSMUNDACAULIS) || blockstate.isIn(PFBlocks.COBBANIA) || blockstate.isIn(PFBlocks.OTOZAMITES) || blockstate.isIn(PFBlocks.TALL_OTOZAMITES) || blockstate.isIn(PFBlocks.LAUROZAMITES) || blockstate.isIn(Blocks.GRASS) || blockstate.isIn(Blocks.VINE) || blockstate.isIn(BlockTags.FLOWERS) || blockstate.isIn(Blocks.TALL_GRASS) || blockstate.isIn(Blocks.FERN) || blockstate.isIn(Blocks.LARGE_FERN);
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (this.getIsAboveDestination()) {
				if (this.field_220731_g >= 20) {
					this.eatBerry();
				} else {
					++this.field_220731_g;
					CamarasaurusEntity.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					CamarasaurusEntity.this.world.playSound((PlayerEntity)null, this.destinationBlock, SoundEvents.BLOCK_GRASS_HIT, SoundCategory.NEUTRAL, 1, 1);
				}
			}
			super.tick();
		}

		protected void eatBerry() {
			BlockState blockstate = CamarasaurusEntity.this.world.getBlockState(this.destinationBlock);

			if (blockstate.isIn(PFBlocks.DEAD_OSMUNDACAULIS)) {
				int hunger = CamarasaurusEntity.this.getCurrentHunger();
				if (hunger + 2 >= CamarasaurusEntity.this.maxHunger) {
					CamarasaurusEntity.this.setHunger(CamarasaurusEntity.this.maxHunger);
					CamarasaurusEntity.this.setEating(false);
				} else {
					CamarasaurusEntity.this.setHunger(hunger + 2);
					CamarasaurusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(Blocks.GRASS) || blockstate.isIn(Blocks.TALL_GRASS) || blockstate.isIn(BlockTags.FLOWERS)) {
				int hunger = CamarasaurusEntity.this.getCurrentHunger();
				if (hunger + 4 >= CamarasaurusEntity.this.maxHunger) {
					CamarasaurusEntity.this.setHunger(CamarasaurusEntity.this.maxHunger);
					CamarasaurusEntity.this.setEating(false);
				} else {
					CamarasaurusEntity.this.setHunger(hunger + 4);
					CamarasaurusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(Blocks.VINE)) {
				int hunger = CamarasaurusEntity.this.getCurrentHunger();
				if (hunger + 6 >= CamarasaurusEntity.this.maxHunger) {
					CamarasaurusEntity.this.setHunger(CamarasaurusEntity.this.maxHunger);
					CamarasaurusEntity.this.setEating(false);
				} else {
					CamarasaurusEntity.this.setHunger(hunger + 6);
					CamarasaurusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.MARCHANTIA) || blockstate.isIn(PFBlocks.OSMUNDACAULIS) || blockstate.isIn(PFBlocks.OTOZAMITES)) {
				int hunger = CamarasaurusEntity.this.getCurrentHunger();
				if (hunger + 8 >= CamarasaurusEntity.this.maxHunger) {
					CamarasaurusEntity.this.setHunger(CamarasaurusEntity.this.maxHunger);
					CamarasaurusEntity.this.setEating(false);
				} else {
					CamarasaurusEntity.this.setHunger(hunger + 8);
					CamarasaurusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.HORSETAIL) || blockstate.isIn(PFBlocks.CLUBMOSS) || blockstate.isIn(PFBlocks.MICHELILLOA) || blockstate.isIn(PFBlocks.COBBANIA) || blockstate.isIn(PFBlocks.LAUROZAMITES) || blockstate.isIn(PFBlocks.CLATHOPTERIS)) {
				int hunger = CamarasaurusEntity.this.getCurrentHunger();
				if (hunger + 10 >= CamarasaurusEntity.this.maxHunger) {
					CamarasaurusEntity.this.setHunger(CamarasaurusEntity.this.maxHunger);
					CamarasaurusEntity.this.setEating(false);
				} else {
					CamarasaurusEntity.this.setHunger(hunger + 10);
					CamarasaurusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_OSMUNDACAULIS) || blockstate.isIn(PFBlocks.TALL_OTOZAMITES)) {
				int hunger = CamarasaurusEntity.this.getCurrentHunger();
				if (hunger + 12 >= CamarasaurusEntity.this.maxHunger) {
					CamarasaurusEntity.this.setHunger(CamarasaurusEntity.this.maxHunger);
					CamarasaurusEntity.this.setEating(false);
				} else {
					CamarasaurusEntity.this.setHunger(hunger + 12);
					CamarasaurusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.OSMUNDA) || blockstate.isIn(Blocks.FERN) || blockstate.isIn(PFBlocks.CONIOPTERIS) || blockstate.isIn(PFBlocks.CLADOPHLEBIS)) {
				int hunger = CamarasaurusEntity.this.getCurrentHunger();
				if (hunger + 15 >= CamarasaurusEntity.this.maxHunger) {
					CamarasaurusEntity.this.setHunger(CamarasaurusEntity.this.maxHunger);
					CamarasaurusEntity.this.setEating(false);
				} else {
					CamarasaurusEntity.this.setHunger(hunger + 15);
					CamarasaurusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_HORSETAIL) || blockstate.isIn(PFBlocks.SCYTOPHYLLUM)) {
				int hunger = CamarasaurusEntity.this.getCurrentHunger();
				if (hunger + 20 >= CamarasaurusEntity.this.maxHunger) {
					CamarasaurusEntity.this.setHunger(CamarasaurusEntity.this.maxHunger);
					CamarasaurusEntity.this.setEating(false);
				} else {
					CamarasaurusEntity.this.setHunger(hunger + 20);
					CamarasaurusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_OSMUNDA) || blockstate.isIn(Blocks.LARGE_FERN) || blockstate.isIn(PFBlocks.JOHNSTONIA)) {
				int hunger = CamarasaurusEntity.this.getCurrentHunger();
				if (hunger + 25 >= CamarasaurusEntity.this.maxHunger) {
					CamarasaurusEntity.this.setHunger(CamarasaurusEntity.this.maxHunger);
					CamarasaurusEntity.this.setEating(false);
				} else {
					CamarasaurusEntity.this.setHunger(hunger + 25);
					CamarasaurusEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.DICROIDIUM)) {
				int hunger = CamarasaurusEntity.this.getCurrentHunger();
				if (hunger + 30 >= CamarasaurusEntity.this.maxHunger) {
					CamarasaurusEntity.this.setHunger(CamarasaurusEntity.this.maxHunger);
					CamarasaurusEntity.this.setEating(false);
				} else {
					CamarasaurusEntity.this.setHunger(hunger + 30);
					CamarasaurusEntity.this.setEating(false);
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return !CamarasaurusEntity.this.isAsleep() && super.shouldExecute() && CamarasaurusEntity.this.getCurrentHunger() < CamarasaurusEntity.this.getHalfHunger();
		}

		public boolean shouldContinueExecuting() {
			if (CamarasaurusEntity.this.getCurrentHunger() >= CamarasaurusEntity.this.maxHunger || CamarasaurusEntity.this.isAsleep()) {
				return false;
			} else return super.shouldContinueExecuting();
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			this.field_220731_g = 0;
			super.startExecuting();
		}
	}

}
