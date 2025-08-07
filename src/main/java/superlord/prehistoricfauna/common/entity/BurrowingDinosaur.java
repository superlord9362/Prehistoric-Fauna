package superlord.prehistoricfauna.common.entity;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.ai.util.AirRandomPos;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import superlord.prehistoricfauna.common.blocks.BurrowBlock;
import superlord.prehistoricfauna.common.entity.block.BurrowBlockEntity;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFTags;

@SuppressWarnings("unused")
public class BurrowingDinosaur extends DinosaurEntity {
	private static final int TOO_FAR_DISTANCE = 32;
	private static final int PATHFIND_TO_BURROW_WHEN_CLOSER_THAN = 16;
	private static final int BURROW_SEARCH_DISTANCE = 20;
	public static final String TAG_BURROW_POS = "BurrowPos";
	private int stayOutOfBurrowCountdown;
	private static final int COOLDOWN_BEFORE_LOCATING_NEW_BURROW = 200;
	public int remainingCooldownBeforeLocatingNewBurrow;
	@Nullable
	public BlockPos burrowPos;
	BurrowingDinosaur.GoToBurrowGoal goToBurrowGoal;

	public BurrowingDinosaur(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
	}

	protected void registerGoals() {
		this.goToBurrowGoal = new GoToBurrowGoal();
		this.goalSelector.addGoal(5, this.goToBurrowGoal);
		this.goalSelector.addGoal(1, new BurrowingDinosaurEnterBurrowGoal());
		this.goalSelector.addGoal(5, new BurrowingDinosaurLocateBurrowGoal());
		this.goalSelector.addGoal(0, new BurrowingDinosaurCreateBurrowGoal());
	}

	public void addAdditionalSaveData(CompoundTag p_27823_) {
		super.addAdditionalSaveData(p_27823_);
		if (this.hasBurrow()) {
			p_27823_.put("BurrowPos", NbtUtils.writeBlockPos(this.getBurrowPos()));
		}
		p_27823_.putInt("CannotEnterBurrowTicks", this.stayOutOfBurrowCountdown);
	}

	public void readAdditionalSaveData(CompoundTag p_27793_) {
		this.burrowPos = null;
		if (p_27793_.contains("BurrowPos")) {
			this.burrowPos = NbtUtils.readBlockPos(p_27793_.getCompound("BurrowPos"));
		}
		super.readAdditionalSaveData(p_27793_);
		this.stayOutOfBurrowCountdown = p_27793_.getInt("CannotEnterBurrowTicks");
	}

	public boolean wantsToEnterBurrow() {
		if (this.stayOutOfBurrowCountdown <= 0 && this.getTarget() == null) {
			boolean flag = false;
			if (this.isDiurnal()) {
				flag = this.level().isRaining() || this.level().isNight();
			}
			if (this.isNocturnal()) {
				flag = this.level().isRaining() || !this.level().isNight();
			}
			if (this.isCrepuscular()) {
				flag = this.level().isRaining() || this.level().getDayTime() % 24000 >= 2000 && this.level().getDayTime() % 24000 <= 9000 || this.level().getDayTime() % 24000 >= 14000 && this.level().getDayTime() % 24000 <= 21000;
			}
			return flag && !this.isBurrowNearFire();
		} else {
			return false;
		}
	}

	public void setStayOutOfBurrowCountdown(int p_27916_) {
		this.stayOutOfBurrowCountdown = p_27916_;
	}

	private boolean isBurrowNearFire() {
		if (this.burrowPos == null) {
			return false;
		} else {
			BlockEntity blockentity = this.level().getBlockEntity(this.burrowPos);
			return blockentity instanceof BurrowBlockEntity && ((BurrowBlockEntity)blockentity).isFireNearby();
		}
	}

	private boolean doesBurrowHaveSpace(BlockPos p_27885_) {
		BlockEntity blockentity = this.level().getBlockEntity(p_27885_);
		if (blockentity instanceof BurrowBlockEntity) {
			return !((BurrowBlockEntity)blockentity).isFull();
		} else {
			return false;
		}
	}

	@VisibleForDebug
	public boolean hasBurrow() {
		return this.burrowPos != null;
	}

	@Nullable
	@VisibleForDebug
	public BlockPos getBurrowPos() {
		return this.burrowPos;
	}

	@VisibleForDebug
	public GoalSelector getGoalSelector() {
		return this.goalSelector;
	}

	public void aiStep() {
		super.aiStep();
		if (!this.level().isClientSide()) {
			if (this.stayOutOfBurrowCountdown > 0) {
				--this.stayOutOfBurrowCountdown;
			}
			if (this.remainingCooldownBeforeLocatingNewBurrow > 0) {
				--this.remainingCooldownBeforeLocatingNewBurrow;
			}
			if (this.tickCount % 20 == 0 && !this.isBurrowValid()) {
				this.burrowPos = null;
			}
		}
	}

	boolean isBurrowValid() {
		if (!this.hasBurrow()) {
			return false;
		} else if (this.isTooFarAway(this.burrowPos)) {
			return false;
		} else {
			BlockEntity blockentity = this.level().getBlockEntity(this.burrowPos);
			return blockentity instanceof BurrowBlockEntity;
		}
	}

	public boolean closerThan(BlockPos p_27817_, int p_27818_) {
		return p_27817_.closerThan(this.blockPosition(), (double)p_27818_);
	}

	public boolean isTooFarAway(BlockPos p_27890_) {
		return !this.closerThan(p_27890_, 32);
	}

	class BurrowingDinosaurEnterBurrowGoal extends BurrowingDinosaur.BaseBurrowerGoal {
		public boolean canBurrowingDinosaurUse() {
			if (BurrowingDinosaur.this.hasBurrow() && BurrowingDinosaur.this.wantsToEnterBurrow() && BurrowingDinosaur.this.burrowPos.closerToCenterThan(BurrowingDinosaur.this.position(), 2.0D)) {
				BlockEntity blockentity = BurrowingDinosaur.this.level().getBlockEntity(BurrowingDinosaur.this.burrowPos);
				if (blockentity instanceof BurrowBlockEntity) {
					BurrowBlockEntity beeburrowblockentity = (BurrowBlockEntity)blockentity;
					if (!beeburrowblockentity.isFull()) {
						return true;
					}

					BurrowingDinosaur.this.burrowPos = null;
				}
			}

			return false;
		}

		public boolean canBurrowingDinosaurContinueToUse() {
			return false;
		}

		public void start() {
			BlockEntity blockentity = BurrowingDinosaur.this.level().getBlockEntity(BurrowingDinosaur.this.burrowPos);
			if (blockentity instanceof BurrowBlockEntity burrowblockentity) {
				burrowblockentity.addOccupant(BurrowingDinosaur.this);
			}

		}
	}

	abstract class BaseBurrowerGoal extends Goal {
		public abstract boolean canBurrowingDinosaurUse();

		public abstract boolean canBurrowingDinosaurContinueToUse();

		public boolean canUse() {
			return this.canBurrowingDinosaurUse();
		}

		public boolean canContinueToUse() {
			return this.canBurrowingDinosaurContinueToUse();
		}
	}

	public void pathfindRandomlyTowards(BlockPos p_27881_) {
		Vec3 vec3 = Vec3.atBottomCenterOf(p_27881_);
		int i = 0;
		BlockPos blockpos = this.blockPosition();
		int j = (int)vec3.y - blockpos.getY();
		if (j > 2) {
			i = 4;
		} else if (j < -2) {
			i = -4;
		}

		int k = 6;
		int l = 8;
		int i1 = blockpos.distManhattan(p_27881_);
		if (i1 < 15) {
			k = i1 / 2;
			l = i1 / 2;
		}

		Vec3 vec31 = AirRandomPos.getPosTowards(this, k, l, i, vec3, (double)((float)Math.PI / 10F));
		if (vec31 != null) {
			this.navigation.setMaxVisitedNodesMultiplier(0.5F);
			this.navigation.moveTo(vec31.x, vec31.y, vec31.z, 1.0D);
		}
	}

	class BurrowingDinosaurCreateBurrowGoal extends Goal {
		private int digTicks = 0;

		@Override
		public boolean canUse() {
			return BurrowingDinosaur.this.burrowPos == null && BurrowingDinosaur.this.wantsToEnterBurrow() && BurrowingDinosaur.this.getBlockStateOn().is(PFTags.SOIL) && !BurrowingDinosaur.this.level().getBlockState(BurrowingDinosaur.this.getOnPos().above()).is(Blocks.WATER);
		}
		
		@Override
		public boolean canContinueToUse() {
			return BurrowingDinosaur.this.burrowPos == null && BurrowingDinosaur.this.wantsToEnterBurrow() && BurrowingDinosaur.this.getBlockStateOn().is(PFTags.SOIL) && !BurrowingDinosaur.this.level().getBlockState(BurrowingDinosaur.this.getOnPos().above()).is(Blocks.WATER);
		}

		@Override
		public void tick() {
			super.tick();
			if (digTicks == 51) {
				BurrowingDinosaur.this.level().setBlockAndUpdate(BurrowingDinosaur.this.getOnPos().above(), PFBlocks.BURROW.get().defaultBlockState().setValue(BurrowBlock.getFaceProperty(Direction.DOWN), Boolean.valueOf(true)));
				stop();
			} else {
				digTicks++;
				double d0 = (double)BurrowingDinosaur.this.blockPosition().getX() + random.nextDouble();
				double d1 = (double)BurrowingDinosaur.this.blockPosition().getY() + 0.5F;
				double d2 = (double)BurrowingDinosaur.this.blockPosition().getZ() + random.nextDouble();
				if (digTicks % 10 == 0) {
					BurrowingDinosaur.this.level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, BurrowingDinosaur.this.level().getBlockState(BurrowingDinosaur.this.blockPosition().below())), d0, d1, d2, 0.0D, 0.0D, 0.0D);
					BurrowingDinosaur.this.level().playSound((Player)null, BurrowingDinosaur.this.blockPosition(), SoundEvents.GRAVEL_HIT, SoundSource.NEUTRAL, 0.4F, 1);
				}
			}
		}

		public void stop() {
			digTicks = 0;
		}

		public void start() {
//			digTicks = 0;
		}
		
		BurrowingDinosaurCreateBurrowGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

	}

	@VisibleForDebug
	public class GoToBurrowGoal extends BurrowingDinosaur.BaseBurrowerGoal {
		public static final int MAX_TRAVELLING_TICKS = 600;
		int travellingTicks = BurrowingDinosaur.this.getRandom().nextInt(10);
		private static final int MAX_BLACKLISTED_TARGETS = 3;
		final List<BlockPos> blacklistedTargets = Lists.newArrayList();
		@Nullable
		private Path lastPath;
		private static final int TICKS_BEFORE_HIVE_DROP = 60;
		private int ticksStuck;

		GoToBurrowGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean canBurrowingDinosaurUse() {
			return BurrowingDinosaur.this.burrowPos != null && !BurrowingDinosaur.this.hasRestriction() && BurrowingDinosaur.this.wantsToEnterBurrow() && !this.hasReachedTarget(BurrowingDinosaur.this.burrowPos) && BurrowingDinosaur.this.level().getBlockState(BurrowingDinosaur.this.burrowPos).is(PFTags.BURROW_BLOCKS);
		}

		public boolean canBurrowingDinosaurContinueToUse() {
			return this.canBurrowingDinosaurUse();
		}

		public void start() {
			this.travellingTicks = 0;
			this.ticksStuck = 0;
			super.start();
		}

		public void stop() {
			this.travellingTicks = 0;
			this.ticksStuck = 0;
			BurrowingDinosaur.this.navigation.stop();
			BurrowingDinosaur.this.navigation.resetMaxVisitedNodesMultiplier();
		}

		public void tick() {
			if (BurrowingDinosaur.this.burrowPos != null) {
				++this.travellingTicks;
				if (this.travellingTicks > this.adjustedTickDelay(600)) {
					this.dropAndBlacklistBurrow();
				} else if (!BurrowingDinosaur.this.navigation.isInProgress()) {
					if (!BurrowingDinosaur.this.closerThan(BurrowingDinosaur.this.burrowPos, 16)) {
						if (BurrowingDinosaur.this.isTooFarAway(BurrowingDinosaur.this.burrowPos)) {
							this.dropBurrow();
						} else {
							BurrowingDinosaur.this.pathfindRandomlyTowards(BurrowingDinosaur.this.burrowPos);
						}
					} else {
						boolean flag = this.pathfindDirectlyTowards(BurrowingDinosaur.this.burrowPos);
						if (!flag) {
							this.dropAndBlacklistBurrow();
						} else if (this.lastPath != null && BurrowingDinosaur.this.navigation.getPath().sameAs(this.lastPath)) {
							++this.ticksStuck;
							if (this.ticksStuck > 60) {
								this.dropBurrow();
								this.ticksStuck = 0;
							}
						} else {
							this.lastPath = BurrowingDinosaur.this.navigation.getPath();
						}

					}
				}
			}
		}

		private boolean pathfindDirectlyTowards(BlockPos p_27991_) {
			BurrowingDinosaur.this.navigation.setMaxVisitedNodesMultiplier(10.0F);
			BurrowingDinosaur.this.navigation.moveTo((double)p_27991_.getX(), (double)p_27991_.getY(), (double)p_27991_.getZ(), 1.0D);
			return BurrowingDinosaur.this.navigation.getPath() != null && BurrowingDinosaur.this.navigation.getPath().canReach();
		}

		boolean isTargetBlacklisted(BlockPos p_27994_) {
			return this.blacklistedTargets.contains(p_27994_);
		}

		private void blacklistTarget(BlockPos p_27999_) {
			this.blacklistedTargets.add(p_27999_);

			while(this.blacklistedTargets.size() > 3) {
				this.blacklistedTargets.remove(0);
			}

		}

		void clearBlacklist() {
			this.blacklistedTargets.clear();
		}

		private void dropAndBlacklistBurrow() {
			if (BurrowingDinosaur.this.burrowPos != null) {
				this.blacklistTarget(BurrowingDinosaur.this.burrowPos);
			}

			this.dropBurrow();
		}

		private void dropBurrow() {
			BurrowingDinosaur.this.burrowPos = null;
			BurrowingDinosaur.this.remainingCooldownBeforeLocatingNewBurrow = 200;
		}

		private boolean hasReachedTarget(BlockPos p_28002_) {
			if (BurrowingDinosaur.this.closerThan(p_28002_, 2)) {
				return true;
			} else {
				Path path = BurrowingDinosaur.this.navigation.getPath();
				return path != null && path.getTarget().equals(p_28002_) && path.canReach() && path.isDone();
			}
		}
	}

	class BurrowingDinosaurLocateBurrowGoal extends BaseBurrowerGoal {
		public boolean canBurrowingDinosaurUse() {
			return BurrowingDinosaur.this.remainingCooldownBeforeLocatingNewBurrow == 0 && !BurrowingDinosaur.this.hasBurrow() && BurrowingDinosaur.this.wantsToEnterBurrow();
		}

		public boolean canBurrowingDinosaurContinueToUse() {
			return false;
		}

		public void start() {
			BurrowingDinosaur.this.remainingCooldownBeforeLocatingNewBurrow = 200;
			List<BlockPos> list = this.findNearbyBurrowsWithSpace();
			if (!list.isEmpty()) {
				for(BlockPos blockpos : list) {
					if (!BurrowingDinosaur.this.goToBurrowGoal.isTargetBlacklisted(blockpos)) {
						BurrowingDinosaur.this.burrowPos = blockpos;
						return;
					}
				}

				BurrowingDinosaur.this.goToBurrowGoal.clearBlacklist();
				BurrowingDinosaur.this.burrowPos = list.get(0);
			}
		}

		private List<BlockPos> findNearbyBurrowsWithSpace() {
			BlockPos blockpos = BurrowingDinosaur.this.blockPosition();
			PoiManager poimanager = ((ServerLevel)BurrowingDinosaur.this.level()).getPoiManager();
			Stream<PoiRecord> stream = poimanager.getInRange((p_218130_) -> {
				return p_218130_.is(PFTags.BURROWS);
			}, blockpos, 20, PoiManager.Occupancy.ANY);
			return stream.map(PoiRecord::getPos).filter(BurrowingDinosaur.this::doesBurrowHaveSpace).sorted(Comparator.comparingDouble((p_148811_) -> {
				return p_148811_.distSqr(blockpos);
			})).collect(Collectors.toList());
		}
	}

}
