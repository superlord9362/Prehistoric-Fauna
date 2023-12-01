package superlord.prehistoricfauna.common.entity.cretaceous.hellcreek;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HumanoidArm;
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
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.AggressiveTempermentAttackGoal;
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
import superlord.prehistoricfauna.common.entity.goal.PiscivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Thoracosaurus extends DinosaurEntity {
	private static final EntityDataAccessor<Boolean> SADDLED = SynchedEntityData.defineId(Thoracosaurus.class, EntityDataSerializers.BOOLEAN);
	private int maxHunger = 90;
	private int warningSoundTicks;
	public float ridingXZ;
	public float ridingY = 1F;

	@SuppressWarnings("deprecation")
	public Thoracosaurus(EntityType<? extends DinosaurEntity> type, Level world) {
		super(type, world);
	      this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
		this.moveControl = new Thoracosaurus.ThoracosaurusMoveControl(this);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}
	
	public boolean isSaddled() {
		return this.entityData.get(SADDLED);
	}
	
	private void setSaddled(boolean isSaddled) {
		this.entityData.set(SADDLED, isSaddled);
	}
	
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SADDLED, false);
	}
	
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsSaddled", this.isSaddled());
	}
	
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setSaddled(compound.getBoolean("IsSaddled"));
	}
	
	public float getWalkTargetValue(BlockPos pos, LevelReader worldIn) {
		return worldIn.getFluidState(pos.below()).isEmpty() && worldIn.getFluidState(pos).is(FluidTags.WATER) ? 10.0F : super.getWalkTargetValue(pos, worldIn);
	}
	
	@SuppressWarnings("deprecation")
	public void travel(Vec3 travelVector) {
		if (this.isAlive()) {
			if (this.isVehicle() && this.canBeControlledByRider() && this.isSaddled()) {
				LivingEntity livingEntity = (LivingEntity)this.getControllingPassenger();
				this.setYRot(livingEntity.getYRot());
				this.yRotO = this.getYRot();
				this.setXRot(livingEntity.getXRot() * 0.5F);
				this.setRot(this.getYRot(), this.getXRot());
				this.yBodyRot = this.getYRot();
				this.yHeadRot = this.yBodyRot;
				float f = livingEntity.xxa * 0.5F;
				float f1 = livingEntity.zza;
				this.maxUpStep = 1.0F;
				if (this.canBeControlledByRider()) {
					if (this.isInWater()) { 
						if (this.getRidingPlayer().jumping) this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0.05D, 0.0D));
						this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED) / 3);
					}
					else this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED) / 3);
					super.travel(new Vec3((double)f, travelVector.y, (double)f1));
				} else if (livingEntity instanceof Player) {
					this.setDeltaMovement(Vec3.ZERO);
				}
				if (this.onGround) {
				}
				this.calculateEntityAnimation(this, false);
			} else {
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
		}
	}
	
	@Override
	public boolean canBeRiddenInWater(Entity entity) {
		return true;
	}
	
	@Nullable
	private Vec3 func_234236_a_(Vec3 p_234236_1_, LivingEntity p_234236_2_) {
		double d0 = this.getX() + p_234236_1_.x;
		double d1 = this.getBoundingBox().minY;
		double d2 = this.getZ() + p_234236_1_.z;
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

		for(Pose pose : p_234236_2_.getDismountPoses()) {
			blockpos$mutable.set(d0, d1, d2);
			double d3 = this.getBoundingBox().maxY + 0.75D;

			while(true) {
				double d4 = this.level.getBlockFloorHeight(blockpos$mutable);
				if ((double)blockpos$mutable.getY() + d4 > d3) {
					break;
				}

				if (DismountHelper.isBlockFloorValid(d4)) {
					AABB axisalignedbb = p_234236_2_.getLocalBoundsForPose(pose);
					Vec3 vector3d = new Vec3(d0, (double)blockpos$mutable.getY() + d4, d2);
					if (DismountHelper.canDismountTo(this.level, p_234236_2_, axisalignedbb.move(vector3d))) {
						p_234236_2_.setPose(pose);
						return vector3d;
					}
				}

				blockpos$mutable.move(Direction.UP);
				if (!((double)blockpos$mutable.getY() < d3)) {
					break;
				}
			}
		}

		return null;
	}

	public Vec3 getDismountLocationForPassenger(LivingEntity living) {
		Vec3 vector3d = getCollisionHorizontalEscapeVector((double)this.getBbWidth(), (double)living.getBbWidth(), this.yRot + (living.getMainArm() == HumanoidArm.RIGHT ? 90.0F : -90.0F));
		Vec3 vector3d1 = this.func_234236_a_(vector3d, living);
		if (vector3d1 != null) {
			return vector3d1;
		} else {
			Vec3 vector3d2 = getCollisionHorizontalEscapeVector((double)this.getBbWidth(), (double)living.getBbWidth(), this.yRot + (living.getMainArm() == HumanoidArm.LEFT ? 90.0F : -90.0F));
			Vec3 vector3d3 = this.func_234236_a_(vector3d2, living);
			return vector3d3 != null ? vector3d3 : this.position();
		}
	}

	protected boolean func_212800_dy() {
		return true;
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(1, new Thoracosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Thoracosaurus.GrabAttackGoal());
		this.goalSelector.addGoal(1, new Thoracosaurus.ThoracosaurusPanicGoal(this));
		this.goalSelector.addGoal(3, new Thoracosaurus.ThoracosaurusGoToWaterGoal(this, 1.0D));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new Thoracosaurus.ThoracosaurusRandomStrollGoal(this, 1.0D, 100));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new BreathAirGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.targetSelector.addGoal(0, new HostileCarnivoreGoal(this, Player.class, false));
		this.goalSelector.addGoal(0, new PiscivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(3, new Thoracosaurus.SwimGoal(this));
		this.goalSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.THORACOSAURUS_HUNTING);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.THORACOSAURUS_BABY_HUNTING);
		}));
		this.targetSelector.addGoal(1, new HuntGoal(this, LivingEntity.class, 10, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.THORACOSAURUS_HUNTING);
		}));
		this.targetSelector.addGoal(2, new AggressiveTempermentAttackGoal(this));
	}
	
	public boolean isPushedByFluid() {
	      return false;
	   }

	public static boolean canDinosaurSpawn(EntityType<? extends Animal> animal,  LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, Random random) {
		return (worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) || worldIn.getBlockState(pos).is(Blocks.WATER) || worldIn.getBlockState(pos.below()).is(Tags.Blocks.SAND)) && worldIn.getRawBrightness(pos, 0) > 8;
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.THORACOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.THORACOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.THORACOSAURUS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		if (this.isBaby()) {
			if (!blockIn.getMaterial().isLiquid()) {
				BlockState blockstate = this.level.getBlockState(pos.above());
				SoundType soundtype = blockstate.is(Blocks.SNOW) ? blockstate.getSoundType(level, pos, this) : blockIn.getSoundType(level, pos, this);
				this.playSound(soundtype.getStepSound(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
		} else {
			this.playSound(SoundEvents.COW_STEP, 0.15F, 1F);
		}
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.THORACOSAURUS_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}
	
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);
		Item item = stack.getItem();
		if (!this.isTame()) {
			if (item == PFItems.CYCLURUS.get() || item == PFItems.LEPISOSTEUS.get() || item == PFItems.LONCHIDION.get() || item == PFItems.MELVIUS.get() || item == PFItems.MYLEDAPHUS.get() || item == PFItems.ARGANODUS.get() || item == PFItems.CERATODUS.get() || item == PFItems.CHINLEA.get() || item == PFItems.MOOREODONTUS.get() || item == PFItems.POTAMOCERATODUS.get() || item == PFItems.SAURICHTHYS.get()) {
				if (!player.getAbilities().instabuild) {
					stack.shrink(1);
				}
				if (this.random.nextInt(5) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
					this.tame(player);
					this.navigation.stop();
					this.setTarget((LivingEntity)null);
					this.setOrderedToSit(true);
					this.level.broadcastEntityEvent(this, (byte)7);
				} else {
					this.level.broadcastEntityEvent(this, (byte)6);
				}
				return InteractionResult.SUCCESS;
			}
		}
		if (!this.isSaddled() && !this.isBaby() && this.isTame()) {
			if (item == Items.SADDLE) {
				if (!player.getAbilities().instabuild) {
					stack.shrink(1);
				}
				this.setSaddled(true);
				this.level.playSound(player, this.getX(), this.getY(), this.getZ(), SoundEvents.HORSE_SADDLE, SoundSource.NEUTRAL, 0.5F, 1.0F);
				return InteractionResult.SUCCESS;
			}
		}
		if (this.isSaddled() && !this.isVehicle() && !this.isBaby()) {
			player.startRiding(this);
		}
		return super.mobInteract(player, hand);
	}
	
	protected void dropEquipment() {
		super.dropEquipment();
		if (this.isSaddled()) {
			this.spawnAtLocation(Items.SADDLE);
		}
	}

	@Override
	public int getMaxAirSupply() {
		return 4800;
	}

	protected int increaseAirSupply(int p_28389_) {
		return this.getMaxAirSupply();
	}

	protected float getWaterSlowDown() {
		return 0.95F;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.ACIPENSER.get();
	}

	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(15);
		} else if (this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30);
		}
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 80) {
			this.setTerritorial(true);
		} else if (temperment >= 80) {
			this.setAggressive(true);
		}
		this.setPiscivorous(true);
		return super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 30D).add(Attributes.FOLLOW_RANGE, 20D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 5D);
	}

	static class SwimGoal extends RandomSwimmingGoal {
		private final Thoracosaurus thoracosaurus;

		public SwimGoal(Thoracosaurus thoracosaurus) {
			super(thoracosaurus, 1.0D, 40);
			this.thoracosaurus = thoracosaurus;
		}

		public boolean canUse() {
			return thoracosaurus.func_212800_dy() && super.canUse();
		}

	}

	@Override
	public void positionRider(Entity passenger) {
		super.positionRider(passenger);
		if (this.isTame()) {
			float radius = ridingXZ * 0.7F * -3;
			float angle = (0.01745329251F * this.yBodyRotO);
			double extraX = radius * Mth.sin((float) (Math.PI + angle));
			double extraZ = radius * Mth.cos(angle);
			double extraY;
			if (this.isInWater()) {
				extraY = ridingY * 4.1F;
			} else {
				if (this.getDeltaMovement().x() == 0 && this.getDeltaMovement().z() == 0) {
					extraY = ridingY * 3.7F;
				} else extraY = ridingY * 4.1F;
			}
			this.getRidingPlayer().setPos(this.getX() + extraX, this.getY() + extraY - 3.5F, this.getZ() + extraZ);	
		} else {

			float radius = ridingXZ * 0.7F * -3 + 2F;
			float angle = (0.01745329251F * this.yBodyRotO);
			double extraX = radius * Mth.sin((float) (Math.PI + angle));
			double extraZ = radius * Mth.cos(angle);
			double extraY;
			if (this.isInWater()) {
				extraY = ridingY * 3;
			} else {
				extraY = ridingY * 4.1F;
			}
			this.getPassengers().get(0).setPos(this.getX() + extraX, this.getY() + extraY - 3.75F, this.getZ() + extraZ);
		}
	}

	public Player getRidingPlayer() {
		if (this.getControllingPassenger() instanceof Player) {
			return (Player) getControllingPassenger();
		} else {
			return null;
		}
	}

	@Nullable
	public Entity getControllingPassenger() {
		if (this.isTame()) return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
		else return null;
	}

	public boolean canBeControlledByRider() {
		return this.getControllingPassenger() instanceof Player && this.isTame();
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Thoracosaurus.this, 1.25D, true);
		}

		protected void CheckAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack() ) {
					this.resetAttackCooldown();
				}
			} else {
				this.resetAttackCooldown();
			}
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && mob.isVehicle();
		}

		public void tick() {
			super.tick();
		}

		public boolean canUse() {
			return super.canUse() && Thoracosaurus.this.isVehicle();
		}

		public void stop() {
			super.stop();
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(4.0F + attackTarget.getBbWidth());
		}

	}

	@Override
	public boolean hurt(DamageSource dmg, float i) {
		if (this.isVehicle()) {
			this.ejectPassengers();
		}
		return super.hurt(dmg, i);
	}

	class GrabAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public GrabAttackGoal() {
			super(Thoracosaurus.this, 1.25D, true);
		}

		protected void CheckAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack() ) {
					this.resetAttackCooldown();
				}
			} else {
				this.resetAttackCooldown();
			}
			if (enemy.getBbWidth() <= 2 && Thoracosaurus.this.getPassengers().isEmpty()) {
				enemy.startRiding(this.mob);
			}
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && !Thoracosaurus.this.isVehicle();
		}

		public boolean canUse() {
			return super.canUse() && !Thoracosaurus.this.isVehicle();
		}

		public void tick() {
			super.tick();
			if (mob.getTarget().getBbWidth() < 2 && !mob.isVehicle()) {
				mob.getTarget().startRiding(mob);
			}
		}

		public void stop() {
			super.stop();
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(4.0F + attackTarget.getBbWidth());
		}
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
		Thoracosaurus entity = new Thoracosaurus(PFEntities.THORACOSAURUS.get(), this.level);
		entity.finalizeSpawn(level, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.THORACOSAURUS_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.THORACOSAURUS_EGG.get();
	}

	public BlockState getEggBlock() {
		return PFBlocks.THORACOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}
	
	static class ThoracosaurusGoToWaterGoal extends MoveToBlockGoal {
		private static final int GIVE_UP_TICKS = 1200;
		private final Thoracosaurus thoracosaurus;
		
		ThoracosaurusGoToWaterGoal(Thoracosaurus thoracosaurus, double speed) {
			super(thoracosaurus, thoracosaurus.isBaby() ? 2.0D : speed, 24);
			this.thoracosaurus = thoracosaurus;
			this.verticalSearchStart = -1;
		}
		
		public boolean canContinueToUse() {
			return !this.thoracosaurus.isInWater() && this.tryTicks <= GIVE_UP_TICKS && this.isValidTarget(this.thoracosaurus.level, this.blockPos);
		}
		
		public boolean canUse() {
			if (this.thoracosaurus.isBaby() && !this.thoracosaurus.isInWater()) {
				return super.canUse();
			} else return !this.thoracosaurus.isInWater() && !this.thoracosaurus.hasBaby() ? super.canUse() : false;
		}
		
		public boolean shouldRecalculatePath() {
			return this.tryTicks % 160 == 0;
		}
		
		protected boolean isValidTarget(LevelReader level, BlockPos pos) {
			return level.getBlockState(pos).is(Blocks.WATER);
		}
	}
	
	static class ThoracosaurusPanicGoal extends BabyPanicGoal {
		ThoracosaurusPanicGoal(Thoracosaurus thoracosaurus) {
			super(thoracosaurus);
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
	
	static class ThoracosaurusRandomStrollGoal extends RandomStrollGoal {
		private final Thoracosaurus thoracosaurus;
		
		ThoracosaurusRandomStrollGoal(Thoracosaurus thoracosaurus, double speed, int interval) {
			super(thoracosaurus, speed, interval);
			this.thoracosaurus = thoracosaurus;
		}
		
		public boolean canUse() {
			return !this.mob.isInWater() && !this.thoracosaurus.hasBaby() ? super.canUse() : false;
		}
	}
	
	static class ThoracosaurusPathNavigation extends WaterBoundPathNavigation {
		ThoracosaurusPathNavigation(Thoracosaurus thoracosaurus, Level level) {
			super(thoracosaurus, level);
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
	
	static class ThoracosaurusMoveControl extends MoveControl {
		private final Thoracosaurus thoracosaurus;
		
		ThoracosaurusMoveControl(Thoracosaurus thoracosaurus) {
			super(thoracosaurus);
			this.thoracosaurus = thoracosaurus;
		}
		
		public void tick() {
			if (this.operation == MoveControl.Operation.MOVE_TO && !this.thoracosaurus.getNavigation().isDone()) {
				double d0 = this.wantedX - this.thoracosaurus.getX();
				double d1 = this.wantedY - this.thoracosaurus.getY();
				double d2 = this.wantedZ - this.thoracosaurus.getZ();
				double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 *d2);
				d1 /= d3;
				float f = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
				this.thoracosaurus.setYRot(this.rotlerp(this.thoracosaurus.getYRot(), f, 90.0F));
				this.thoracosaurus.yBodyRot = this.thoracosaurus.getYRot();
				float f1 = (float)(this.speedModifier * this.thoracosaurus.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.thoracosaurus.setSpeed(Mth.lerp(0.125F, this.thoracosaurus.getSpeed(), f1));
				this.thoracosaurus.setDeltaMovement(this.thoracosaurus.getDeltaMovement().add(0.0D, (double)this.thoracosaurus.getSpeed() * d1 * 0.1D, 0.0D));
			} else {
				this.thoracosaurus.setSpeed(0.0F);
			}
		}
		
	}
	
	protected PathNavigation createNavigation(Level level) {
		return new Thoracosaurus.ThoracosaurusPathNavigation(this, level);
	}

}
