package superlord.prehistoricfauna.common.entity.jurassic.kayenta;

import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.BreathAirGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import superlord.prehistoricfauna.common.blocks.NestAndEggsBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.BabyCarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.HostileCarnivoreGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.OpportunistAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.OpportunistBabyHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.OpportunistHuntingGoal;
import superlord.prehistoricfauna.common.entity.goal.PiscivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.SkittishFleeGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Calsoyasuchus extends DinosaurEntity {
	private int maxHunger = 15;
	private int warningSoundTicks;

	@SuppressWarnings("deprecation")
	public Calsoyasuchus(EntityType<? extends DinosaurEntity> type, Level worldIn) {
		super(type, worldIn);
		this.moveControl = new Calsoyasuchus.CalsoyasuchusMoveControl(this);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.15F;
		else return 0.3F;
	}

	public int getMaxAirSupply() {
	      return 4800;
	   }

	   protected int increaseAirSupply(int p_28389_) {
	      return this.getMaxAirSupply();
	   }

	protected float getWaterSlowDown() {
		return 1F;
	}
	
	public float getWalkTargetValue(BlockPos pos, LevelReader worldIn) {
		return worldIn.getFluidState(pos.below()).isEmpty() && worldIn.getFluidState(pos).is(FluidTags.WATER) ? 10.0F : super.getWalkTargetValue(pos, worldIn);
	}
	
	public void travel(Vec3 travelVector) {
		if (this.isEffectiveAi() && this.isInWater()) {
			this.moveRelative(this.getSpeed(), travelVector);
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().scale(0.5D));
			if (this.getTarget() == null) {
				this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
			}
		} else {
			super.travel(travelVector);
		}
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.CERATODUS.get();
	}

	protected boolean func_212800_dy() {
		return true;
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(1, new Calsoyasuchus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Calsoyasuchus.CalsoyasuchusPanicGoal(this));
		this.goalSelector.addGoal(3, new Calsoyasuchus.CalsoyasuchusGoToWaterGoal(this, 1.0D));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.targetSelector.addGoal(2, new OpportunistAttackGoal(this, Player.class, true));
		this.goalSelector.addGoal(0, new SkittishFleeGoal(this, Player.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new Calsoyasuchus.CalsoyasuchusRandomStrollGoal(this, 1.0D, 100));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new BreathAirGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.targetSelector.addGoal(0, new HostileCarnivoreGoal(this, Player.class, false));
		this.goalSelector.addGoal(0, new PiscivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(3, new Calsoyasuchus.SwimGoal(this));
		this.goalSelector.addGoal(0, new OpportunistHuntingGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.CALSOYASUCHUS_HUNTING);
		}));
		this.goalSelector.addGoal(0, new OpportunistBabyHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.CALSOYASUCHUS_BABY_HUNTING);
		}));
		this.goalSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.CALSOYASUCHUS_HUNTING);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.CALSOYASUCHUS_BABY_HUNTING);
		}));
		this.targetSelector.addGoal(1, new HuntGoal(this, LivingEntity.class, 10, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.CALSOYASUCHUS_HUNTING);
		}));
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 75) {
			this.setTerritorial(true);
		} else if (temperment >= 75 && temperment < 85) {
			this.setOpportunist(true);
		} else if (temperment >= 85 && temperment < 95) {
			this.setProtective(true);
		} else if (temperment >= 95) {
			this.setSkittish(true);
		}
		this.setPiscivorous(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(3);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(6);
		}
	}

	public static boolean canDinosaurSpawn(EntityType<? extends Animal> animal,  LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, Random random) {
		return (worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) || worldIn.getBlockState(pos).is(Blocks.WATER) || worldIn.getBlockState(pos.below()).is(Tags.Blocks.SAND)) && worldIn.getRawBrightness(pos, 0) > 8;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 3.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.CALSOYASUCHUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.CALSOYASUCHUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.CALSOYASUCHUS_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.CALSOYASUCHUS_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}

	public boolean doHurtTarget(Entity entity) {
		boolean flag = super.doHurtTarget(entity);
		if (flag) {
			this.doEnchantDamageEffects(this, entity);
		}
		return flag;
	}

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(Calsoyasuchus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean canUse() {
			if (Calsoyasuchus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for (@SuppressWarnings("unused") Calsoyasuchus calsoyasuchus : Calsoyasuchus.this.level.getEntitiesOfClass(Calsoyasuchus.class, Calsoyasuchus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {	
						if (Calsoyasuchus.this.isBaby()) {
							return true;
						}
					}
				}
				return false;
			}
		}

		protected double getFollowDistance() {
			return super.getFollowDistance() * 0.5D;
		}	

	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Calsoyasuchus.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}

				if (this.getTicksUntilNextAttack() <= 10) {
					Calsoyasuchus.this.playWarningSound();
				}
			} else {
				this.resetAttackCooldown();
			}

		}

		public boolean canContinueToUse() {
			return super.canContinueToUse();
		}

		public void stop() {
			super.stop();
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(4.0F + attackTarget.getBbWidth());
		}
	}

	class PanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(Calsoyasuchus.this, 2.0D);
		}

		public boolean canUse() {
			return !Calsoyasuchus.this.isBaby() && !Calsoyasuchus.this.isOnFire() ? false : super.canUse();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Calsoyasuchus entity = new Calsoyasuchus(PFEntities.CALSOYASUCHUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	static class SwimGoal extends RandomSwimmingGoal {
		private final Calsoyasuchus calsoyasuchus;

		public SwimGoal(Calsoyasuchus calsoyasuchus) {
			super(calsoyasuchus, 1.0D, 40);
			this.calsoyasuchus = calsoyasuchus;
		}

		public boolean canUse() {
			return this.calsoyasuchus.func_212800_dy() && super.canUse();
		}
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.CALSOYASUCHUS_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.CALSOYASUCHUS_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.CALSOYASUCHUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1)).setValue(NestAndEggsBlock.PLANT_LEVEL, Integer.valueOf(this.random.nextInt(3) + 1));
	}
	
	static class CalsoyasuchusGoToWaterGoal extends MoveToBlockGoal {
		private static final int GIVE_UP_TICKS = 1200;
		private final Calsoyasuchus calsoyasuchus;
		
		CalsoyasuchusGoToWaterGoal(Calsoyasuchus calsoyasuchus, double speed) {
			super(calsoyasuchus, calsoyasuchus.isBaby() ? 2.0D : speed, 24);
			this.calsoyasuchus = calsoyasuchus;
			this.verticalSearchStart = -1;
		}
		
		public boolean canContinueToUse() {
			return !this.calsoyasuchus.isInWater() && this.tryTicks <= GIVE_UP_TICKS && this.isValidTarget(this.calsoyasuchus.level, this.blockPos);
		}
		
		public boolean canUse() {
			if (this.calsoyasuchus.isBaby() && !this.calsoyasuchus.isInWater()) {
				return super.canUse();
			} else return !this.calsoyasuchus.isInWater() && !this.calsoyasuchus.hasBaby() ? super.canUse() : false;
		}
		
		public boolean shouldRecalculatePath() {
			return this.tryTicks % 160 == 0;
		}
		
		protected boolean isValidTarget(LevelReader level, BlockPos pos) {
			return level.getBlockState(pos).is(Blocks.WATER);
		}
	}
	
	static class CalsoyasuchusPanicGoal extends BabyPanicGoal {
		CalsoyasuchusPanicGoal(Calsoyasuchus calsoyasuchus) {
			super(calsoyasuchus);
		}
		
		public boolean canUse() {
			if (!this.shouldPanic() || !this.mob.isBaby()) {
				return false;
			} else {
				BlockPos blockpos = this.lookForWater(this.mob.level, this.mob, 7);
				if (blockpos != null) {
					this.posX = (double)blockpos.getX();
					this.posY = (double)blockpos.getY();
					this.posZ = (double)blockpos.getZ();
					return true;
				} else {
					return this.findRandomPosition();
				}
			}
		}
	}
	
	static class CalsoyasuchusRandomStrollGoal extends RandomStrollGoal {
		private final Calsoyasuchus calsoyasuchus;
		
		CalsoyasuchusRandomStrollGoal(Calsoyasuchus calsoyasuchus, double speed, int interval) {
			super(calsoyasuchus, speed, interval);
			this.calsoyasuchus = calsoyasuchus;
		}
		
		public boolean canUse() {
			return !this.mob.isInWater() && !this.calsoyasuchus.hasBaby() ? super.canUse() : false;
		}
	}
	
	static class CalsoyasuchusPathNavigation extends WaterBoundPathNavigation {
		CalsoyasuchusPathNavigation(Calsoyasuchus calsoyasuchus, Level level) {
			super(calsoyasuchus, level);
		}
		
		protected boolean canUpdatePath() {
			return true;
		}
		
		protected PathFinder createPathFinder(int maxNodes) {
			this.nodeEvaluator = new AmphibiousNodeEvaluator(true);
			return new PathFinder(this.nodeEvaluator, maxNodes);
		}
		
		public boolean isStableDestination(BlockPos pos) {
			return !this.level.getBlockState(pos.below()).isAir();
		}
		
	}
	
	static class CalsoyasuchusMoveControl extends MoveControl {
		private final Calsoyasuchus calsoyasuchus;
		
		CalsoyasuchusMoveControl(Calsoyasuchus calsoyasuchus) {
			super(calsoyasuchus);
			this.calsoyasuchus = calsoyasuchus;
		}
		
		public void tick() {
			if (this.operation == MoveControl.Operation.MOVE_TO && !this.calsoyasuchus.getNavigation().isDone()) {
				double d0 = this.wantedX - this.calsoyasuchus.getX();
				double d1 = this.wantedY - this.calsoyasuchus.getY();
				double d2 = this.wantedZ - this.calsoyasuchus.getZ();
				double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 *d2);
				d1 /= d3;
				float f = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
				this.calsoyasuchus.setYRot(this.rotlerp(this.calsoyasuchus.getYRot(), f, 90.0F));
				this.calsoyasuchus.yBodyRot = this.calsoyasuchus.getYRot();
				float f1 = (float)(this.speedModifier * this.calsoyasuchus.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.calsoyasuchus.setSpeed(Mth.lerp(0.125F, this.calsoyasuchus.getSpeed(), f1));
				this.calsoyasuchus.setDeltaMovement(this.calsoyasuchus.getDeltaMovement().add(0.0D, (double)this.calsoyasuchus.getSpeed() * d1 * 0.1D, 0.0D));
			} else {
				this.calsoyasuchus.setSpeed(0.0F);
			}
		}
		
	}
	
	protected PathNavigation createNavigation(Level level) {
		return new Calsoyasuchus.CalsoyasuchusPathNavigation(this, level);
	}

}
