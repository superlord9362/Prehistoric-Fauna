package superlord.prehistoricfauna.common.entity.jurassic.shaximiao;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.JumpControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraftforge.common.Tags;
import superlord.prehistoricfauna.common.entity.goal.BugAvoidGoal;
import superlord.prehistoricfauna.common.entity.navigation.DirectPathNavigator;
import superlord.prehistoricfauna.common.entity.navigation.FlightMoveController;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Aboilus extends Animal {
	private static final EntityDataAccessor<Direction> ATTACHED_FACE = SynchedEntityData.defineId(Aboilus.class, EntityDataSerializers.DIRECTION);
	private static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(Aboilus.class, EntityDataSerializers.BYTE);
	private static final Direction[] HORIZONTALS = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
	public float attachChangeProgress = 0F;
	public float prevAttachChangeProgress = 0F;
	private Direction prevAttachDir = Direction.DOWN;
	public boolean isUpsideDownNavigator;
	private int jumpTicks;
	private int jumpDuration;
	private boolean wasOnGround;
	private int jumpDelayTicks;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Aboilus(EntityType type, Level world) {
		super(type, world);
		this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
		this.jumpControl = new Aboilus.AboilusJumpControl(this);
		switchNavigator(true);
	}

	protected SoundEvent getAmbientSound() {
		return PFSounds.ABOILUS_IDLE.get();
	}

	protected void playStepSound(BlockPos p_33543_, BlockState p_33544_) {
	}

	@Override
	public void playAmbientSound() {
		SoundEvent soundevent = this.getAmbientSound();
		if (soundevent != null) {
			this.playSound(soundevent, this.getSoundVolume() * 5, this.getVoicePitch());
		}
	}

	private void switchNavigator(boolean rightsideUp) {
		if (rightsideUp) {
			this.moveControl = new AboilusMoveControl(this);
			this.navigation = new WallClimberNavigation(this, level());
			this.enableJumpControl();
			this.isUpsideDownNavigator = false;
		} else {
			this.moveControl = new FlightMoveController(this, 0.6F, false);
			this.navigation = new DirectPathNavigator(this, level());
			this.disableJumpControl();
			this.isUpsideDownNavigator = true;
		}
	}

	protected float getJumpPower() {
		float f = 0.3F;
		if (this.horizontalCollision || this.moveControl.hasWanted() && this.moveControl.getWantedY() > this.getY() + 0.5D) {
			f = 0.5F;
		}

		Path path = this.navigation.getPath();
		if (path != null && !path.isDone()) {
			Vec3 vec3 = path.getNextEntityPos(this);
			if (vec3.y > this.getY() + 0.5D) {
				f = 0.5F;
			}
		}

		if (this.moveControl.getSpeedModifier() <= 0.6D) {
			f = 0.2F;
		}

		return f + this.getJumpBoostPower();
	}

	public void setSpeedModifier(double p_29726_) {
		this.getNavigation().setSpeedModifier(p_29726_);
		this.moveControl.setWantedPosition(this.moveControl.getWantedX(), this.moveControl.getWantedY(), this.moveControl.getWantedZ(), p_29726_);
	}

	protected void jumpFromGround() {
		super.jumpFromGround();
		double d0 = this.moveControl.getSpeedModifier();
		if (d0 > 0.0D) {
			double d1 = this.getDeltaMovement().horizontalDistanceSqr();
			if (d1 < 0.01D) {
				this.moveRelative(0.1F, new Vec3(0.0D, 0.0D, 1.0D));
			}
		}

		if (!this.level().isClientSide()) {
			this.level().broadcastEntityEvent(this, (byte)1);
		}

	}

	public float getJumpCompletion(float p_29736_) {
		return this.jumpDuration == 0 ? 0.0F : ((float)this.jumpTicks + p_29736_) / (float)this.jumpDuration;
	}

	public void customServerAiStep() {
		if (this.jumpDelayTicks > 0) {
			--this.jumpDelayTicks;
		}
		if (this.onGround()) {
			if (!this.wasOnGround) {
				this.setJumping(false);
				this.checkLandingDelay();
			}
			Aboilus.AboilusJumpControl aboilus$aboilusjumpcontrol = (Aboilus.AboilusJumpControl)this.jumpControl;
			if (!aboilus$aboilusjumpcontrol.wantJump()) {
				if (this.moveControl.hasWanted() && this.jumpDelayTicks == 0) {
					Path path = this.navigation.getPath();
					Vec3 vec3 = new Vec3(this.moveControl.getWantedX(), this.moveControl.getWantedY(), this.moveControl.getWantedZ());
					if (path != null && !path.isDone()) {
						vec3 = path.getNextEntityPos(this);
					}

					this.facePoint(vec3.x, vec3.z);
					this.startJumping();
				}
			} else if (!aboilus$aboilusjumpcontrol.canJump()) {
				this.enableJumpControl();
			}
		}
		this.wasOnGround = this.onGround();
	}

	private void facePoint(double p_29687_, double p_29688_) {
		this.setYRot((float)(Mth.atan2(p_29688_ - this.getZ(), p_29687_ - this.getX()) * (double)(180F / (float)Math.PI)) - 90.0F);
	}

	private void enableJumpControl() {
		((Aboilus.AboilusJumpControl)this.jumpControl).setCanJump(true);
	}

	private void disableJumpControl() {
		((Aboilus.AboilusJumpControl)this.jumpControl).setCanJump(false);
	}

	private void setLandingDelay() {
		if (this.moveControl.getSpeedModifier() < 2.2D) {
			this.jumpDelayTicks = 10;
		} else {
			this.jumpDelayTicks = 1;
		}

	}

	private void checkLandingDelay() {
		this.setLandingDelay();
		this.disableJumpControl();
	}

	public void aiStep() {
		super.aiStep();
		if (this.jumpTicks != this.jumpDuration) {
			++this.jumpTicks;
		} else if (this.jumpDuration != 0) {
			this.jumpTicks = 0;
			this.jumpDuration = 0;
			this.setJumping(false);
		}

	}

	public void handleEntityEvent(byte p_29663_) {
		if (p_29663_ == 1) {
			this.jumpDuration = 10;
			this.jumpTicks = 0;
		} else {
			super.handleEntityEvent(p_29663_);
		}

	}

	static class AboilusMoveControl extends MoveControl {
		private final Aboilus aboilus;
		private double nextJumpSpeed;

		public AboilusMoveControl(Aboilus p_29766_) {
			super(p_29766_);
			this.aboilus = p_29766_;
		}

		public void tick() {
			if (this.aboilus.onGround() && !this.aboilus.jumping && !((Aboilus.AboilusJumpControl)this.aboilus.jumpControl).wantJump()) {
				this.aboilus.setSpeedModifier(0.0D);
			} else if (this.hasWanted()) {
				this.aboilus.setSpeedModifier(this.nextJumpSpeed);
			}

			super.tick();
		}

		public void setWantedPosition(double p_29769_, double p_29770_, double p_29771_, double p_29772_) {
			if (this.aboilus.isInWater()) {
				p_29772_ = 1.5D;
			}

			super.setWantedPosition(p_29769_, p_29770_, p_29771_, p_29772_);
			if (p_29772_ > 0.0D) {
				this.nextJumpSpeed = p_29772_;
			}

		}
	}

	public static class AboilusJumpControl extends JumpControl {
		private final Aboilus aboilus;
		private boolean canJump;

		public AboilusJumpControl(Aboilus p_186229_) {
			super(p_186229_);
			this.aboilus = p_186229_;
		}

		public boolean wantJump() {
			return this.jump;
		}

		public boolean canJump() {
			return this.canJump;
		}

		public void setCanJump(boolean p_29759_) {
			this.canJump = p_29759_;
		}

		public void tick() {
			if (this.jump) {
				this.aboilus.startJumping();
				this.jump = false;
			}

		}
	}

	public void startJumping() {
		this.setJumping(true);
		this.playSound(PFSounds.ABOILUS_HOP.get(), 0.15F, 1.0F);
		this.jumpDuration = 10;
		this.jumpTicks = 0;
	}

	@SuppressWarnings("unused")
	private static boolean isSideSolid(BlockGetter reader, BlockPos pos, Entity entityIn, Direction direction) {
		return Block.isFaceFull(reader.getBlockState(pos).getCollisionShape(reader, pos, CollisionContext.of(entityIn)), direction);
	}

	public boolean causeFallDamage(float distance, float damageMultiplier) {
		return false;
	}

	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	public Direction getAttachmentFacing() {
		return this.entityData.get(ATTACHED_FACE);
	}

	protected PathNavigation createNavigation(Level worldIn) {
		return new WallClimberNavigation(this, worldIn);
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
	    this.goalSelector.addGoal(1, new BugAvoidGoal(this, 7F, 1.5D, 1.75D, PFTags.ABOILUS_AVOIDING));
	}

	public int getMaxAir() {
		return 0;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0D).add(Attributes.MOVEMENT_SPEED, 0.15D);
	}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item == Items.GLASS_BOTTLE) {
			if (!player.isCreative()) {
				itemstack.shrink(1);
			}
			player.addItem(new ItemStack(PFItems.BOTTLED_ABOILUS.get()));
			this.discard();
		}
		return super.mobInteract(player, hand);
	}


	public void tick() {
		super.tick();
		if (attachChangeProgress > 0F) {
			attachChangeProgress -= 0.25F;
		}
		this.setMaxUpStep(1F);
		Vec3 vector3d = this.getDeltaMovement();
		if (!this.level().isClientSide()) {
			this.setBesideClimbableBlock(this.horizontalCollision || this.verticalCollision && !this.onGround());
			if (this.onGround() || this.isInWaterOrBubble() || this.isInLava()) {
				this.entityData.set(ATTACHED_FACE, Direction.DOWN);
			} else  if (this.verticalCollision) {
				this.entityData.set(ATTACHED_FACE, Direction.UP);
			}else {
				Direction closestDirection = Direction.DOWN;
				double closestDistance = 100;
				for (Direction dir : HORIZONTALS) {
					BlockPos antPos = new BlockPos(Mth.floor(this.getX()), Mth.floor(this.getY()), Mth.floor(this.getZ()));
					BlockPos offsetPos = antPos.relative(dir);
					Vec3 offset = Vec3.atCenterOf(offsetPos);
					if (closestDistance > this.position().distanceTo(offset) && level().loadedAndEntityCanStandOnFace(offsetPos, this, dir.getOpposite())) {
						closestDistance = this.position().distanceTo(offset);
						closestDirection = dir;
					}
				}
				this.entityData.set(ATTACHED_FACE, closestDirection);
			}
		}
		boolean flag = false;
		if (this.getAttachmentFacing() != Direction.DOWN) {
			if(this.getAttachmentFacing() == Direction.UP){
				this.setDeltaMovement(this.getDeltaMovement().add(0, 1, 0));
			}else{
				if (!this.horizontalCollision && this.getAttachmentFacing() != Direction.UP) {
					Vec3 vec = Vec3.atLowerCornerOf(this.getAttachmentFacing().getNormal());
					this.setDeltaMovement(this.getDeltaMovement().add(vec.normalize().multiply(0.1F, 0.1F, 0.1F)));
				}
				if (!this.onGround() && vector3d.y < 0.0D) {
					this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.5D, 1.0D));
					flag = true;
				}
			}
		}
		if(this.getAttachmentFacing() == Direction.UP) {
			this.setNoGravity(true);
			this.setDeltaMovement(vector3d.multiply(0.7D, 1D, 0.7D));
		}else{
			this.setNoGravity(false);
		}
		if (!flag) {
			if (this.onClimbable()) {
				this.setDeltaMovement(vector3d.multiply(1.0D, 0.4D, 1.0D));
			}
		}
		if (prevAttachDir != this.getAttachmentFacing()) {
			attachChangeProgress = 1F;
		}
		this.prevAttachDir = this.getAttachmentFacing();
		if (!this.level().isClientSide()) {
			if (this.getAttachmentFacing() == Direction.UP && !this.isUpsideDownNavigator) {
				switchNavigator(false);
			}
			if (this.getAttachmentFacing() != Direction.UP && this.isUpsideDownNavigator) {
				switchNavigator(true);
			}
		}
	}

	@SuppressWarnings("unused")
	private boolean isClimeableFromSide(BlockPos offsetPos, Direction opposite) {
		return false;
	}

	protected void onInsideBlock(BlockState state) {

	}

	public boolean onClimbable() {
		return this.isBesideClimbableBlock();
	}

	public boolean isBesideClimbableBlock() {
		return (this.entityData.get(CLIMBING) & 1) != 0;
	}

	public void setBesideClimbableBlock(boolean climbing) {
		byte b0 = this.entityData.get(CLIMBING);
		if (climbing) {
			b0 = (byte) (b0 | 1);
		} else {
			b0 = (byte) (b0 & -2);
		}

		this.entityData.set(CLIMBING, b0);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(CLIMBING, (byte) 0);
		this.entityData.define(ATTACHED_FACE, Direction.DOWN);
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.entityData.set(ATTACHED_FACE, Direction.from3DDataValue(compound.getByte("AttachFace")));
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putByte("AttachFace", (byte) this.entityData.get(ATTACHED_FACE).get3DDataValue());
	}

	@Nullable
	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageableEntity) {
		return null;
	}

	public static boolean canBugSpawn(EntityType<? extends PathfinderMob> animal, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource random) {
		return (worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) || worldIn.getBlockState(pos.below()).is(PFTags.SOIL) || worldIn.getBlockState(pos.below()).is(Tags.Blocks.SAND) || worldIn.getBlockState(pos.below()).is(BlockTags.LEAVES) || worldIn.getBlockState(pos.below()).is(BlockTags.LOGS_THAT_BURN)) && worldIn.getRawBrightness(pos, 0) > 8;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.ABOILUS_SPAWN_EGG.get());
	}

}