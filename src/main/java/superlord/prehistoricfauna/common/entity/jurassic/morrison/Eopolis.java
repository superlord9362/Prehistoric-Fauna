package superlord.prehistoricfauna.common.entity.jurassic.morrison;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.ai.util.AirRandomPos;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraftforge.common.Tags;
import superlord.prehistoricfauna.common.entity.block.EopolisMoundBlockEntity;
import superlord.prehistoricfauna.common.entity.goal.BugAvoidGoal;
import superlord.prehistoricfauna.common.entity.navigation.DirectPathNavigator;
import superlord.prehistoricfauna.common.entity.navigation.FlightMoveController;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFTags;

public class Eopolis extends Animal {
	private static final EntityDataAccessor<Direction> ATTACHED_FACE = SynchedEntityData.defineId(Eopolis.class, EntityDataSerializers.DIRECTION);
	private static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(Eopolis.class, EntityDataSerializers.BYTE);
	private static final Direction[] HORIZONTALS = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
	public float attachChangeProgress = 0F;
	public float prevAttachChangeProgress = 0F;
	private Direction prevAttachDir = Direction.DOWN;
	private boolean isUpsideDownNavigator;

	public static final String TAG_MOUND_POS = "MoundPos";
	private int stayOutOfMoundCountdown;
	@SuppressWarnings("unused")
	private static final int COOLDOWN_BEFORE_LOACTION_NEW_MOUND = 200;
	public int remainingCooldownBeforeLocatingNewMound;
	@Nullable
	public BlockPos moundPos;
	Eopolis.GoToMoundGoal goToMoundGoal;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Eopolis(EntityType type, Level world) {
		super(type, world);
		this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
		switchNavigator(true);
	}

	protected void playStepSound(BlockPos p_33543_, BlockState p_33544_) {
		this.playSound(SoundEvents.SILVERFISH_STEP, 0.15F, 1.0F);
	}

	private void switchNavigator(boolean rightsideUp) {
		if (rightsideUp) {
			this.moveControl = new MoveControl(this);
			this.navigation = new WallClimberNavigation(this, level());
			this.isUpsideDownNavigator = false;
		} else {
			this.moveControl = new FlightMoveController(this, 0.6F, false);
			this.navigation = new DirectPathNavigator(this, level());
			this.isUpsideDownNavigator = true;
		}
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
		this.goToMoundGoal = new GoToMoundGoal();
		this.goalSelector.addGoal(0, this.goToMoundGoal);
		this.goalSelector.addGoal(0, new EopolisEnterMoundGoal());
		this.goalSelector.addGoal(0, new EopolisLocateMoundGoal());
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
	    this.goalSelector.addGoal(1, new BugAvoidGoal(this, 7F, 1.5D, 1.75D, PFTags.EOPOLIS_AVOIDING));
	}

	public int getMaxAir() {
		return 0;
	}

	public void aiStep() {
		if (!this.level().isClientSide()) {
			if (this.stayOutOfMoundCountdown > 0) {
				--this.stayOutOfMoundCountdown;
			}
			if (this.remainingCooldownBeforeLocatingNewMound > 0) {
				--this.remainingCooldownBeforeLocatingNewMound;
			}
			if (this.tickCount % 20 == 0 && !this.isMoundValid()) {
				this.moundPos = null;
			}
		}
		super.aiStep();
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
			player.addItem(new ItemStack(PFItems.BOTTLED_EOPOLIS.get()));
			this.discard();
		}
		return super.mobInteract(player, hand);
	}


	public void tick() {
		super.tick();
		if (attachChangeProgress > 0F) {
			attachChangeProgress -= 0.25F;
		}
		this.setMaxUpStep(0.5F);
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
		if (!!this.level().isClientSide()) {
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
		this.moundPos = null;
		if (compound.contains("MoundPos")) {
			this.moundPos = NbtUtils.readBlockPos(compound.getCompound("MoundPos"));
		}
		this.stayOutOfMoundCountdown = compound.getInt("CannotEnterMoundTicks");
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putByte("AttachFace", (byte) this.entityData.get(ATTACHED_FACE).get3DDataValue());
		if (this.hasMound()) {
			compound.put("MoundPos", NbtUtils.writeBlockPos(this.getMoundPos()));
		}
		compound.putInt("CannotEnterMoundTicks", this.stayOutOfMoundCountdown);
	}

	public boolean wantsToEnterMound() {
		if (this.stayOutOfMoundCountdown <= 0 && this.getTarget() == null) {
			boolean flag = this.level().isRaining() || this.level().isNight();
			return flag && !this.isMoundNearFire();
		} else return false;
	}

	public void setStayOutOfMoundCountdown(int countdown) {
		this.stayOutOfMoundCountdown = countdown;
	}

	private boolean isMoundNearFire() {
		if (this.moundPos == null) return false;
		else {
			BlockEntity blockEntity = this.level().getBlockEntity(this.moundPos);
			return blockEntity instanceof EopolisMoundBlockEntity && ((EopolisMoundBlockEntity)blockEntity).isFireNearby();
		}
	}

	private boolean doesMoundHaveSpace(BlockPos pos) {
		BlockEntity blockEntity = this.level().getBlockEntity(pos);
		if (blockEntity instanceof EopolisMoundBlockEntity) {
			return !((EopolisMoundBlockEntity)blockEntity).isFull();
		} else return false;
	}

	public boolean hasMound() {
		return this.moundPos != null;
	}

	@Nullable
	public BlockPos getMoundPos() {
		return this.moundPos;
	}

	public GoalSelector getGoalSelector() {
		return this.goalSelector;
	}

	boolean isMoundValid() {
		if (!this.hasMound()) {
			return false;
		} else if (this.isTooFarAway(this.moundPos)) {
			return false;
		} else {
			BlockEntity blockEntity = this.level().getBlockEntity(this.moundPos);
			return blockEntity instanceof EopolisMoundBlockEntity;
		}
	}

	public boolean closerThan(BlockPos pos, int distance) {
		return pos.closerThan(this.blockPosition(), (double) distance);
	}

	public boolean isTooFarAway(BlockPos pos) {
		return !this.closerThan(pos, 32);
	}

	class EopolisEnterMoundGoal extends Goal {
		public boolean canUse() {
			if (Eopolis.this.hasMound() && Eopolis.this.wantsToEnterMound() && Eopolis.this.moundPos.closerToCenterThan(Eopolis.this.position(), 2)) {
				BlockEntity blockEntity = Eopolis.this.level().getBlockEntity(Eopolis.this.moundPos);
				if (blockEntity instanceof EopolisMoundBlockEntity moundBlockEntity) {
					if (!moundBlockEntity.isFull()) {
						return true;
					}
					Eopolis.this.moundPos = null;
				}
			}
			return false;
		}

		public boolean canContinueToUse() {
			return false;
		}

		public void start() {
			BlockEntity blockEntity = Eopolis.this.level().getBlockEntity(Eopolis.this.moundPos);
			if (blockEntity instanceof EopolisMoundBlockEntity moundBlockEntity) {
				moundBlockEntity.addOccupant(Eopolis.this, Eopolis.this.level().isNight() || Eopolis.this.level().isRaining());
			}
		}

	}

	public void pathfindRandomlyTowards(BlockPos pos) {
		Vec3 vec3 = Vec3.atBottomCenterOf(pos);
		int i = 0;
		BlockPos blockPos = this.blockPosition();
		int j = (int)vec3.y - blockPos.getY();
		if (j > 2) {
			i = 4;
		} else if (j < -2) {
			i = -4;
		}
		int k = 6;
		int l = 8;
		int i1 = blockPos.distManhattan(pos);
		if (i1 < 15) {
			k = i1 / 2;
			l = i1 / 2;
		}
		Vec3 vec31 = AirRandomPos.getPosTowards(this, k, l, i, vec3, (double)((float)Math.PI / 10));
		if (vec31 != null) {
			this.navigation.setMaxVisitedNodesMultiplier(0.5F);
			this.navigation.moveTo(vec31.x, vec31.y, vec31.z, 1);
		}
	}

	@SuppressWarnings("unused")
	public class GoToMoundGoal extends Goal {
		public static final int MAX_TRAVELLING_TICKS = 600;
		int travellingTicks = Eopolis.this.random.nextInt(10);
		private static final int MAX_BLACKLISTED_TARGETS = 5;
		final List<BlockPos> blacklistedTargets = Lists.newArrayList();
		@Nullable
		private Path lastPath;
		private static final int TICKS_BEFORE_HIVE_DROP = 60;
		private int ticksStuck;

		GoToMoundGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean canUse() {
			return Eopolis.this.moundPos != null && !Eopolis.this.hasRestriction() && Eopolis.this.wantsToEnterMound() && !this.hasReachedTarget(Eopolis.this.moundPos) && Eopolis.this.level().getBlockState(Eopolis.this.moundPos).is(PFBlocks.EOPOLIS_MOUND.get());
		}

		public boolean canContinueToUse() {
			return Eopolis.this.moundPos != null;
		}

		public void start() {
			this.travellingTicks = 0;
			this.ticksStuck = 0;
			super.start();
		}

		public void stop() {
			this.travellingTicks = 0;
			this.ticksStuck = 0;
			Eopolis.this.navigation.stop();
			Eopolis.this.navigation.resetMaxVisitedNodesMultiplier();
		}

		public void tick() {
			if (Eopolis.this.moundPos != null) {
				++this.travellingTicks;
				if (this.travellingTicks > this.adjustedTickDelay(600)) {
					this.dropAndBlacklistMound();
				} else if (!Eopolis.this.navigation.isInProgress()) {
					if (!Eopolis.this.closerThan(Eopolis.this.moundPos, 16)) {
						if (Eopolis.this.isTooFarAway(Eopolis.this.moundPos)) {
							this.dropMound();
						} else {
							Eopolis.this.pathfindRandomlyTowards(Eopolis.this.moundPos);
						}
					} else {
						boolean flag = this.pathfindDirectlyTowards(Eopolis.this.moundPos);
						if (!flag) {
							this.dropAndBlacklistMound();
						} else if (this.lastPath != null && Eopolis.this.navigation.getPath().sameAs(this.lastPath)) {
							++this.ticksStuck;
							if (this.ticksStuck > 60) {
								this.dropMound();
								this.ticksStuck = 0;
							}
						} else {
							this.lastPath = Eopolis.this.navigation.getPath();
						}
					}
				}
			}
		}

		private boolean pathfindDirectlyTowards(BlockPos pos) {
			Eopolis.this.navigation.setMaxVisitedNodesMultiplier(10);
			Eopolis.this.navigation.moveTo((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), 1);
			return Eopolis.this.navigation.getPath() != null && Eopolis.this.navigation.getPath().canReach();
		}

		boolean isTargetBlackListed(BlockPos pos) {
			return this.blacklistedTargets.contains(pos);
		}

		private void blacklistTarget(BlockPos pos) {
			this.blacklistedTargets.add(pos);
			while (this.blacklistedTargets.size() > 5) {
				this.blacklistedTargets.remove(0);
			}
		}

		void clearBlacklist() {
			this.blacklistedTargets.clear();
		}

		private void dropAndBlacklistMound() {
			if (Eopolis.this.moundPos != null) {
				this.blacklistTarget(Eopolis.this.moundPos);
			}
			this.dropMound();
		}

		private void dropMound() {
			Eopolis.this.moundPos = null;
			Eopolis.this.remainingCooldownBeforeLocatingNewMound = 200;
		}

		private boolean hasReachedTarget(BlockPos pos) {
			if (Eopolis.this.closerThan(pos, 2)) {
				return true;
			} else {
				Path path = Eopolis.this.navigation.getPath();
				return path != null && path.getTarget().equals(pos) && path.canReach() && path.isDone();
			}
		}

	}

	class EopolisLocateMoundGoal extends Goal {

		public boolean canUse() {
			return Eopolis.this.remainingCooldownBeforeLocatingNewMound == 0 && !Eopolis.this.hasMound() && Eopolis.this.wantsToEnterMound();
		}

		public boolean canContinueToUse() {
			return false;
		}

		public void start() {
			Eopolis.this.remainingCooldownBeforeLocatingNewMound = 200;
			List<BlockPos> list = this.findNearbyMoundWithSpace();
			if (!list.isEmpty()) {
				for (BlockPos pos : list) {
					if (!Eopolis.this.goToMoundGoal.isTargetBlackListed(pos)) {
						Eopolis.this.moundPos = pos;
						return;
					}
				}
				Eopolis.this.goToMoundGoal.clearBlacklist();
				Eopolis.this.moundPos = list.get(0);
			}
		}

		private List<BlockPos> findNearbyMoundWithSpace() {
			BlockPos pos = Eopolis.this.blockPosition();
			PoiManager poimanager = ((ServerLevel)Eopolis.this.level()).getPoiManager();
			Stream<PoiRecord> stream = poimanager.getInRange((p_218130_) -> {
				return p_218130_.is(PFTags.EOPOLIS_MOUNDS);
			}, pos, 20, PoiManager.Occupancy.ANY);
			return stream.map(PoiRecord::getPos).filter(Eopolis.this::doesMoundHaveSpace).sorted(Comparator.comparingDouble((p_148811_) -> {
				return p_148811_.distSqr(pos);
			})).collect(Collectors.toList());
		}

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
		return new ItemStack(PFItems.EOPOLIS_SPAWN_EGG.get());
	}

}

