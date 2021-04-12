package superlord.prehistoricfauna.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.passive.horse.MuleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
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
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import superlord.prehistoricfauna.block.TyrannosaurusEggBlock;
import superlord.prehistoricfauna.entity.goal.HuntGoal;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.util.SoundHandler;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class TyrannosaurusEntity extends AnimalEntity {
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(TyrannosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(TyrannosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_JUVENILE = EntityDataManager.createKey(TyrannosaurusEntity.class, DataSerializers.BOOLEAN);
	private int warningSoundTicks;
	private int isDigging;
	private Goal panicGoal;

	public TyrannosaurusEntity(EntityType<? extends TyrannosaurusEntity> type, World worldIn) {
		super(type, worldIn);
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

	public boolean isJuvenile() {
		return this.dataManager.get(IS_JUVENILE);
	}

	private void setJuvenile(boolean isJuvenile) {
		this.dataManager.set(IS_JUVENILE, isJuvenile);
	}

	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == ItemInit.RAW_TRICERATOPS_MEAT.get();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void registerGoals() {
		super.registerGoals();

		panicGoal = new TyrannosaurusEntity.PanicGoal();
		this.goalSelector.addGoal(1, panicGoal);
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(4, new TyrannosaurusEntity.TyrannosaurusFollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, AnkylosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(1, new TyrannosaurusEntity.MeleeAttackGoal());
		this.targetSelector.addGoal(1, new TyrannosaurusEntity.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new TyrannosaurusEntity.AttackPlayerGoal());
		this.goalSelector.addGoal(8, new TyrannosaurusEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new TyrannosaurusEntity.MateGoal(this, 1.0D));
		this.targetSelector.addGoal(1, new JuvenileHuntGoal(this, AnimalEntity.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof ThescelosaurusEntity || p_213487_0_ instanceof DryosaurusEntity || p_213487_0_ instanceof IschigualastiaEntity || p_213487_0_ instanceof CowEntity || p_213487_0_ instanceof SheepEntity || p_213487_0_ instanceof HorseEntity || p_213487_0_ instanceof DonkeyEntity || p_213487_0_ instanceof MuleEntity;
		}));
		this.targetSelector.addGoal(1, new HuntGoal(this, AnimalEntity.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof ThescelosaurusEntity || p_213487_0_ instanceof TriceratopsEntity || p_213487_0_ instanceof StegosaurusEntity || p_213487_0_ instanceof DryosaurusEntity || p_213487_0_ instanceof CowEntity || p_213487_0_ instanceof SheepEntity || p_213487_0_ instanceof HorseEntity || p_213487_0_ instanceof DonkeyEntity || p_213487_0_ instanceof MuleEntity || p_213487_0_ instanceof PolarBearEntity || p_213487_0_ instanceof PandaEntity;
		}));
	}

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
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

	protected SoundEvent getAmbientSound() {
		return SoundHandler.TYRANNOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundHandler.TYRANNOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundHandler.TYRANNOSAURUS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundHandler.TYRANNOSAURUS_WARN, 1.0F, this.getSoundPitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(IS_JUVENILE, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue()));
		if (flag) {
			this.applyEnchantments(this, entityIn);
		}

		return flag;
	}	

	class AttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public AttackPlayerGoal() {
			super(TyrannosaurusEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean shouldExecute() {
			if (TyrannosaurusEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for(TyrannosaurusEntity tyrannosaurus : TyrannosaurusEntity.this.world.getEntitiesWithinAABB(TyrannosaurusEntity.class, TyrannosaurusEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
						if (tyrannosaurus.isChild()) {
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
			super(TyrannosaurusEntity.this);
		}

		public void startExecuting() {
			super.startExecuting();
			if (TyrannosaurusEntity.this.isChild()) {
				this.alertOthers();
				this.resetTask();
			}

		}

		protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
			if (mobIn instanceof TyrannosaurusEntity && !mobIn.isChild()) {
				super.setAttackTarget(mobIn, targetIn);
			}

		}
	}

	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(TyrannosaurusEntity.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.attackTick <= 0) {
				this.attackTick = 20;
				this.attacker.attackEntityAsMob(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.attackTick <= 0) {
					this.attackTick = 20;
				}

				if (this.attackTick <= 10) {
					TyrannosaurusEntity.this.playWarningSound();
				}
			} else {
				this.attackTick = 20;
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
			super(TyrannosaurusEntity.this, 2.0D);
		}

		public boolean shouldExecute() {
			if (!TyrannosaurusEntity.this.isChild() && !TyrannosaurusEntity.this.isBurning()) {
				return false;
			} else if (TyrannosaurusEntity.this.isJuvenile() && !TyrannosaurusEntity.this.isBurning()) {
				return false;
			} else {
				return super.shouldExecute();
			}
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final TyrannosaurusEntity tyrannosaurus;

		LayEggGoal(TyrannosaurusEntity tyrannosaurus, double speedIn) {
			super(tyrannosaurus, speedIn, 16);
			this.tyrannosaurus = tyrannosaurus;
		}

		public boolean shouldExecute() {
			return this.tyrannosaurus.hasEgg() ? super.shouldExecute() : false;
		}

		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && this.tyrannosaurus.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.tyrannosaurus);
			if (!this.tyrannosaurus.isInWater() && this.getIsAboveDestination()) {
				if (this.tyrannosaurus.isDigging < 1) {
					this.tyrannosaurus.setDigging(true);
				} else if (this.tyrannosaurus.isDigging > 200) {
					World world = this.tyrannosaurus.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), BlockInit.TYRANNOSAURUS_EGG.getDefaultState().with(TyrannosaurusEggBlock.EGGS, Integer.valueOf(this.tyrannosaurus.rand.nextInt(4) + 1)), 3);
					this.tyrannosaurus.setHasEgg(false);
					this.tyrannosaurus.setDigging(false);
					this.tyrannosaurus.setInLove(600);
				}

				if (this.tyrannosaurus.isDigging()) {
					this.tyrannosaurus.isDigging++;
				}
			}

		}

		protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			if (!worldIn.isAirBlock(pos.up())) {
				return false;
			} else {
				Block block = worldIn.getBlockState(pos).getBlock();
				return block == Blocks.COARSE_DIRT;
			}
		}
	}

	static class MateGoal extends BreedGoal {
		private final TyrannosaurusEntity tyrannosaurus;

		MateGoal(TyrannosaurusEntity tyrannosaurus, double speedIn) {
			super(tyrannosaurus, speedIn);
			this.tyrannosaurus = tyrannosaurus;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.tyrannosaurus.hasEgg();
		}

		protected void spawnBaby() {
			ServerPlayerEntity serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.targetMate.getLoveCause() != null) {
				serverplayerentity = this.targetMate.getLoveCause();
			}

			if (serverplayerentity != null) {
				serverplayerentity.addStat(Stats.ANIMALS_BRED);
			}

			this.tyrannosaurus.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}

		}
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		TyrannosaurusEntity entity = new TyrannosaurusEntity(ModEntityTypes.TYRANNOSAURUS_ENTITY, this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}

	class TyrannosaurusFollowParentGoal extends Goal {
		private final TyrannosaurusEntity babyTyrannosaurusEntity;
		private TyrannosaurusEntity parentTyrannosaurusEntity;
		private final double moveSpeed;
		private int delayCounter;

		public TyrannosaurusFollowParentGoal(TyrannosaurusEntity tyrannosaurus, double speed) {
			this.babyTyrannosaurusEntity = tyrannosaurus;
			this.moveSpeed = speed;
		}

		public boolean shouldExecute() {
			if (this.babyTyrannosaurusEntity.isChild() && !this.babyTyrannosaurusEntity.isJuvenile()) {
				List<TyrannosaurusEntity> list = this.babyTyrannosaurusEntity.world.getEntitiesWithinAABB(this.babyTyrannosaurusEntity.getClass(), this.babyTyrannosaurusEntity.getBoundingBox().grow(8.0D, 4.0D, 8.0D));
				TyrannosaurusEntity tyrannosaurusEntity = null;
				double d0 = Double.MAX_VALUE;
				for (TyrannosaurusEntity tyrannosaurusEntity1 : list) {
					if (!tyrannosaurusEntity1.isChild()) {
						double d1 = this.babyTyrannosaurusEntity.getDistanceSq(tyrannosaurusEntity1);
						if (!(d1 > d0)) {
							d0 = d1;
							tyrannosaurusEntity = tyrannosaurusEntity1;
						}
					}
				}
				if (tyrannosaurusEntity == null) {
					return false;
				} else if (d0 < 9.0D) {
					return false;
				} else {
					this.parentTyrannosaurusEntity = tyrannosaurusEntity;
					return true;
				}
			} else {
				return false;
			}
		}

		public boolean shouldContinueExecuting() {
			if (!this.babyTyrannosaurusEntity.isJuvenile() || !this.babyTyrannosaurusEntity.isChild()) {
				return false;
			} else if (!this.parentTyrannosaurusEntity.isAlive()) {
				return false;
			} else  if(this.babyTyrannosaurusEntity.isChild() && !this.babyTyrannosaurusEntity.isJuvenile()){
				double d0 = this.babyTyrannosaurusEntity.getDistanceSq(this.parentTyrannosaurusEntity);
				return !(d0 < 9.0D) && !(d0 > 256.0D);
			} else {
				return false;
			}
		}

		public void startExecuting() {
			this.delayCounter = 0;
		}

		public void resetTask() {
			this.parentTyrannosaurusEntity = null;
		}

		public void tick() {
			if (--this.delayCounter <= 0) {
				this.delayCounter = 10;
				this.babyTyrannosaurusEntity.getNavigator().tryMoveToEntityLiving(this.parentTyrannosaurusEntity, this.moveSpeed);
			}
		}
	}

	class JuvenileHuntGoal extends HuntGoal {

		private TyrannosaurusEntity tyrannosaurus;

		@SuppressWarnings("rawtypes")
		public JuvenileHuntGoal(MobEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, Predicate targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnlyIn, targetPredicate);
			this.tyrannosaurus = (TyrannosaurusEntity) goalOwnerIn;
		}

		public boolean shouldExecute() {
			if (super.shouldExecute() && tyrannosaurus.isJuvenile()) {
				return true;
			} else {
				return false;
			}
		}

	}

}