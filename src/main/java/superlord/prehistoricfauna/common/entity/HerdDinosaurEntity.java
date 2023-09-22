package superlord.prehistoricfauna.common.entity;

import java.util.List;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class HerdDinosaurEntity extends DinosaurEntity {
	private HerdDinosaurEntity groupLeader;
	private int groupSize = 1;

	protected HerdDinosaurEntity(EntityType<? extends HerdDinosaurEntity> type, Level worldIn) {
		super(type, worldIn);
	}

	public int getMaxSpawnClusterSize() {
		return this.getMaxGroupSize();
	}

	public int getMaxGroupSize() {
		return super.getMaxSpawnClusterSize();
	}

	protected boolean canRandomWalk() {
		return !this.isFollower();
	}

	   public boolean isFollower() {
		return this.groupLeader != null && this.groupLeader.isAlive();
	}

	public HerdDinosaurEntity startFollowing(HerdDinosaurEntity groupLeaderIn) {
		this.groupLeader = groupLeaderIn;
		groupLeaderIn.increaseGroupSize();
		return groupLeaderIn;
	}

	public void stopFollowing() {
		this.groupLeader.decreaseGroupSize();
		this.groupLeader = null;
	}

	private void increaseGroupSize() {
		++this.groupSize;
	}

	private void decreaseGroupSize() {
		--this.groupSize;
	}

	public boolean canBeFollowed() {
		return this.hasFollowers() && this.groupSize < this.getMaxGroupSize();
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick() {
		super.tick();
		if (this.hasFollowers() && this.level.random.nextInt(200) == 1) {
			List<? extends HerdDinosaurEntity> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D));
			if (list.size() <= 1) {
				this.groupSize = 1;
			}
		}
	}

	public boolean hasFollowers() {
		return this.groupSize > 1;
	}

	public boolean inRangeOfLeader() {
		return this.distanceToSqr(this.groupLeader) <= 121.0D;
	}

	public void pathToLeader() {
		if (this.isFollower()) {
			this.getNavigation().moveTo(this.groupLeader, 1.0D);
		}

	}

	public void addFollowers(Stream<? extends HerdDinosaurEntity> p_212810_1_) {
		p_212810_1_.limit((long)(this.getMaxGroupSize() - this.groupSize)).filter((p_212801_1_) -> {
			return p_212801_1_ != this;
		}).forEach((p_212804_1_) -> {
			p_212804_1_.startFollowing(this);
		});
	}

	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_27528_, DifficultyInstance p_27529_, MobSpawnType p_27530_, @Nullable SchoolSpawnGroupData p_27531_, @Nullable CompoundTag p_27532_) {
		super.finalizeSpawn(p_27528_, p_27529_, p_27530_, p_27531_, p_27532_);
		if (p_27531_ == null) {
			p_27531_ = new HerdDinosaurEntity.SchoolSpawnGroupData(this);
		} else {
			this.startFollowing(((HerdDinosaurEntity.SchoolSpawnGroupData)p_27531_).leader);
		}

		return p_27531_;
	}

	public static class SchoolSpawnGroupData implements SpawnGroupData {
		public final HerdDinosaurEntity leader;

		public SchoolSpawnGroupData(HerdDinosaurEntity p_27553_) {
			this.leader = p_27553_;
		}
	}

}
