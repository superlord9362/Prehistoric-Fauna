package superlord.prehistoricfauna.common.entity.cretaceous.hellcreek;

import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreathAirGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.item.ItemEntity;
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
import superlord.prehistoricfauna.common.entity.goal.CarnivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.HostileCarnivoreGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.PiscivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.items.PaleopediaItem;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Brachychampsa extends DinosaurEntity {
	private int maxHunger = 50;
	private int warningSoundTicks;
	private int grabTicks = 0;
	private int grabCooldownTicks = 0;
	public float ridingXZ;
	public float ridingY = 1F;

	public Brachychampsa(EntityType<? extends DinosaurEntity> type, Level world) {
		super(type, world);
		this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
		this.moveControl = new Brachychampsa.BrachychampsaMoveControl(this);
		this.setMaxUpStep(1.0F);
		super.maxHunger = maxHunger;
	}

	public float getWalkTargetValue(BlockPos pos, LevelReader worldIn) {
		return worldIn.getFluidState(pos.below()).isEmpty() && worldIn.getFluidState(pos).is(FluidTags.WATER) ? 10.0F : super.getWalkTargetValue(pos, worldIn);
	}

	public void travel(Vec3 travelVector) {
		if (this.isAlive()) {
			if (this.isEffectiveAi() && this.isInWater()) {
				this.moveRelative(this.getSpeed(), travelVector);
				this.move(MoverType.SELF, this.getDeltaMovement());
				this.setDeltaMovement(this.getDeltaMovement().scale(0.5D));
				if (this.getTarget() == null) {
					this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
				}
				if (this.getAirSupply() < this.getMaxAirSupply() / 3) {
					this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0.05D, 0.0D));
				}
			} else {
				super.travel(travelVector);
			}
		}
	}

	@Override
	public boolean dismountsUnderwater() {
		return false;
	}
	
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem) {
			if (!itemstack.getTag().contains("Pages", EnumPaleoPages.BRACHYCHAMPSA.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.BRACHYCHAMPSA.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.brachychampsa_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		return super.mobInteract(player, hand);
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
				double d4 = this.level().getBlockFloorHeight(blockpos$mutable);
				if ((double)blockpos$mutable.getY() + d4 > d3) {
					break;
				}

				if (DismountHelper.isBlockFloorValid(d4)) {
					AABB axisalignedbb = p_234236_2_.getLocalBoundsForPose(pose);
					Vec3 vector3d = new Vec3(d0, (double)blockpos$mutable.getY() + d4, d2);
					if (DismountHelper.canDismountTo(this.level(), p_234236_2_, axisalignedbb.move(vector3d))) {
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
		this.goalSelector.addGoal(1, new Brachychampsa.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Brachychampsa.GrabAttackGoal());
		this.goalSelector.addGoal(1, new Brachychampsa.BrachychampsaPanicGoal(this));
		this.goalSelector.addGoal(3, new Brachychampsa.BrachychampsaGoToWaterGoal(this, 1.0D));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new Brachychampsa.BrachychampsaRandomStrollGoal(this, 1.0D, 100));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new BreathAirGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.targetSelector.addGoal(0, new HostileCarnivoreGoal(this, Player.class, false));
		this.goalSelector.addGoal(0, new PiscivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new CarnivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(3, new Brachychampsa.SwimGoal(this));
		this.goalSelector.addGoal(0, new BrachychampsaHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.BRACHYCHAMPSA_HUNTING);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.BRACHYCHAMPSA_BABY_HUNTING);
		}));
		this.targetSelector.addGoal(1, new BrachychampsaNoHungerHuntGoal(this, LivingEntity.class, 10, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.BRACHYCHAMPSA_HUNTING);
		}));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.BRACHYCHAMPSA_AVOIDING);
		}));
		this.targetSelector.addGoal(2, new AggressiveTempermentAttackGoal(this));
	}

	public boolean isPushedByFluid() {
		return false;
	}

	public static boolean canDinosaurSpawn(EntityType<? extends Animal> animal,  LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource random) {
		return (worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) || worldIn.getBlockState(pos).is(Blocks.WATER) || worldIn.getBlockState(pos.below()).is(Tags.Blocks.SAND)) && worldIn.getRawBrightness(pos, 0) > 8;
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.BRACHYCHAMPSA_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.BRACHYCHAMPSA_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.BRACHYCHAMPSA_DEATH.get();
	}

	@SuppressWarnings("deprecation")
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		if (this.isBaby()) {
			if (!blockIn.liquid()) {
				BlockState blockstate = this.level().getBlockState(pos.above());
				SoundType soundtype = blockstate.is(Blocks.SNOW) ? blockstate.getSoundType(level(), pos, this) : blockIn.getSoundType(level(), pos, this);
				this.playSound(soundtype.getStepSound(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
		} else {
			this.playSound(SoundEvents.COW_STEP, 0.15F, 1F);
		}
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.BRACHYCHAMPSA_WARN.get(), 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
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
		return stack.getItem() == PFItems.CRASSOSTREA_OYSTER.get();
	}

	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10);
		} else if (this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);
		}
	}

	protected void handleAirSupply(int p_28326_) {
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 80) {
			this.setTerritorial(true);
		} else if (temperment >= 80) {
			this.setAggressive(true);
		}
		this.setCarnivorous(true);
		this.setPiscivorous(true);
		this.setAirSupply(this.getMaxAirSupply());
		return super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20D).add(Attributes.ARMOR, 2D).add(Attributes.FOLLOW_RANGE, 20D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 5D);
	}

	static class SwimGoal extends RandomSwimmingGoal {
		private final Brachychampsa brachychampsa;

		public SwimGoal(Brachychampsa brachychampsa) {
			super(brachychampsa, 1.0D, 40);
			this.brachychampsa = brachychampsa;
		}

		public boolean canUse() {
			return brachychampsa.func_212800_dy() && super.canUse();
		}

	}

	@Override
	public void positionRider(Entity passenger, Entity.MoveFunction p_289531_) {
		super.positionRider(passenger, p_289531_);
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

	public Player getRidingPlayer() {
		if (this.getControllingPassenger() instanceof Player) {
			return (Player) getControllingPassenger();
		} else {
			return null;
		}
	}

	@Nullable
	public LivingEntity getControllingPassenger() {
		Entity entity = this.getFirstPassenger();
		if (entity instanceof Mob) {
			return (Mob)entity;
		} else {
			return null;
		}
	}

	public boolean canBeControlledByRider() {
		return this.getControllingPassenger() instanceof Player && this.isTame();
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Brachychampsa.this, 1.25D, true);
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
			return super.canUse() && (Brachychampsa.this.isVehicle() || Brachychampsa.this.grabCooldownTicks != 0);
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

	public void aiStep() {
		super.aiStep();
		if (!this.isTame() && this.getFirstPassenger() != null) {
			grabTicks++;
			if (grabTicks == 100) {
				this.getFirstPassenger().stopRiding();
				this.grabCooldownTicks = 500;
				this.grabTicks = 0;
			}
		}
		if (this.grabCooldownTicks != 0) {
			grabCooldownTicks--;
		}
	}

	class GrabAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public GrabAttackGoal() {
			super(Brachychampsa.this, 1.25D, true);
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
			if (enemy.getBbWidth() <= 2 && Brachychampsa.this.getPassengers().isEmpty()) {
				enemy.startRiding(this.mob);
			}
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && !Brachychampsa.this.isVehicle();
		}

		public boolean canUse() {
			return super.canUse() && !Brachychampsa.this.isVehicle() && Brachychampsa.this.grabCooldownTicks == 0;
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
		Brachychampsa entity = new Brachychampsa(PFEntities.BRACHYCHAMPSA.get(), this.level());
		entity.finalizeSpawn(level, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.BRACHYCHAMPSA_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.BRACHYCHAMPSA_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.BRACHYCHAMPSA_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}

	static class BrachychampsaGoToWaterGoal extends MoveToBlockGoal {
		private static final int GIVE_UP_TICKS = 1200;
		private final Brachychampsa brachychampsa;

		BrachychampsaGoToWaterGoal(Brachychampsa brachychampsa, double speed) {
			super(brachychampsa, brachychampsa.isBaby() ? 2.0D : speed, 24);
			this.brachychampsa = brachychampsa;
			this.verticalSearchStart = -1;
		}

		public boolean canContinueToUse() {
			return !this.brachychampsa.isInWater() && this.tryTicks <= GIVE_UP_TICKS && this.isValidTarget(this.brachychampsa.level(), this.blockPos);
		}

		public boolean canUse() {
			if (this.brachychampsa.isBaby() && !this.brachychampsa.isInWater()) {
				return super.canUse();
			} else return !this.brachychampsa.isInWater() && !this.brachychampsa.hasBaby() ? super.canUse() : false;
		}

		public boolean shouldRecalculatePath() {
			return this.tryTicks % 160 == 0;
		}

		protected boolean isValidTarget(LevelReader level, BlockPos pos) {
			return level.getBlockState(pos).is(Blocks.WATER);
		}
	}

	static class BrachychampsaPanicGoal extends BabyPanicGoal {
		BrachychampsaPanicGoal(Brachychampsa brachychampsa) {
			super(brachychampsa);
		}

		public boolean canUse() {
			if (!this.shouldPanic() || !this.mob.isBaby()) {
				return false;
			} else {
				BlockPos blockpos = this.lookForWater(this.mob.level(), this.mob, 7);
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

	static class BrachychampsaRandomStrollGoal extends RandomStrollGoal {
		private final Brachychampsa brachychampsa;

		BrachychampsaRandomStrollGoal(Brachychampsa brachychampsa, double speed, int interval) {
			super(brachychampsa, speed, interval);
			this.brachychampsa = brachychampsa;
		}

		public boolean canUse() {
			return !this.mob.isInWater() && !this.brachychampsa.hasBaby() ? super.canUse() : false;
		}
	}

	static class BrachychampsaPathNavigation extends WaterBoundPathNavigation {
		BrachychampsaPathNavigation(Brachychampsa brachychampsa, Level level) {
			super(brachychampsa, level);
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

	static class BrachychampsaMoveControl extends MoveControl {
		private final Brachychampsa brachychampsa;

		BrachychampsaMoveControl(Brachychampsa brachychampsa) {
			super(brachychampsa);
			this.brachychampsa = brachychampsa;
		}

		public void tick() {
			if (this.operation == MoveControl.Operation.MOVE_TO && !this.brachychampsa.getNavigation().isDone()) {
				double d0 = this.wantedX - this.brachychampsa.getX();
				double d1 = this.wantedY - this.brachychampsa.getY();
				double d2 = this.wantedZ - this.brachychampsa.getZ();
				double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 *d2);
				d1 /= d3;
				float f = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
				this.brachychampsa.setYRot(this.rotlerp(this.brachychampsa.getYRot(), f, 90.0F));
				this.brachychampsa.yBodyRot = this.brachychampsa.getYRot();
				float f1 = (float)(this.speedModifier * this.brachychampsa.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.brachychampsa.setSpeed(Mth.lerp(0.125F, this.brachychampsa.getSpeed(), f1));
				this.brachychampsa.setDeltaMovement(this.brachychampsa.getDeltaMovement().add(0.0D, (double)this.brachychampsa.getSpeed() * d1 * 0.1D, 0.0D));
			} else {
				this.brachychampsa.setSpeed(0.0F);
			}
		}

	}

	protected PathNavigation createNavigation(Level level) {
		return new Brachychampsa.BrachychampsaPathNavigation(this, level);
	}
	
	@SuppressWarnings("rawtypes")
	class BrachychampsaHuntGoal extends NearestAttackableTargetGoal {
		double huntSpeed;
		Predicate<LivingEntity> targetPredicate;
		DinosaurEntity dinosaur;

		@SuppressWarnings("unchecked")
		public BrachychampsaHuntGoal(DinosaurEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
			this.huntSpeed = huntSpeed;
			this.targetPredicate = targetPredicate;
			this.dinosaur = goalOwnerIn;
		}

		public boolean canUse() {
			return super.canUse() && dinosaur.getCurrentHunger() <= dinosaur.getHalfHunger() && !dinosaur.isBaby() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(dinosaur) && !dinosaur.trusts(target.getUUID()) && !dinosaur.isOpportunist();
		}

		public boolean canContinueToUse() {
			return dinosaur.getCurrentHunger() < dinosaur.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			dinosaur.getNavigation().setSpeedModifier(huntSpeed);
			if (dinosaur.getTarget() != null) {
				LivingEntity target = dinosaur.getTarget();
				if (!target.is(null)) {
					if (target.getType().is(PFTags.INSECTS_2_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 2 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 2);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_3_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 3 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 3);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 4 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 4);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 6 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 6);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_8_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 8 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 8);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_10_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 10 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 10);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_15_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 15 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 15);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_20_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 20 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 20);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_30_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 30 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 30);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_40_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 40 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 40);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_60_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 60 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 60);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_80_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 80 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 80);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_100_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 100 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 100);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_200_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 200 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 200);
							}
						}
					}
					if (target instanceof Turtle || target instanceof Basilemys) {
						if (target.getHealth() == 0) {
							ItemEntity item = new ItemEntity(target.level(), target.getX(), target.getY(), target.getZ(), new ItemStack(Items.SCUTE));
							item.setPos(target.getX(), target.getY(), target.getZ());
							dinosaur.level().addFreshEntity(item);
						}
					}
				} else stop();
			} else stop();
			super.tick();
		}

	}
	
	@SuppressWarnings("rawtypes")
	class BrachychampsaNoHungerHuntGoal extends NearestAttackableTargetGoal {
		Predicate<LivingEntity> targetPredicate;
		DinosaurEntity dinosaur;
		
		@SuppressWarnings("unchecked")
		public BrachychampsaNoHungerHuntGoal(DinosaurEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnlyIn, targetPredicate);
			this.targetPredicate = targetPredicate;
			this.dinosaur = goalOwnerIn;
		}
		
		public boolean canUse() {
			if (super.canUse() && this.mob.getRandom().nextInt(249) == 0 && !this.mob.isBaby() && !PrehistoricFaunaConfig.advancedHunger && !targetPredicate.test(this.mob) && !dinosaur.trusts(target.getUUID())) {
				return true;
			} else {
				return false;
			}
		}
		
		public void tick() {
			super.tick();
			if (target instanceof Turtle || target instanceof Basilemys) {
				if (target.getHealth() == 0) {
					ItemEntity item = new ItemEntity(target.level(), target.getX(), target.getY(), target.getZ(), new ItemStack(Items.SCUTE));
					item.setPos(target.getX(), target.getY(), target.getZ());
					dinosaur.level().addFreshEntity(item);
				}
			}
		}
		
		public void stop() {
			super.stop();
		}
		
		public boolean canContinueToUse() {
			if (super.canContinueToUse() && this.mob.getRandom().nextInt(500) != 0 || this.mob.getTarget() != null && this.mob.getRandom().nextInt(500) != 0) {
				return true;
			} else {
				return false;
			}
		}

	}



}
