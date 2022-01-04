package superlord.prehistoricfauna.common.entities;

import java.util.List;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class HerdDinosaurEntity extends DinosaurEntity {

	private HerdDinosaurEntity groupLeader;
	private int groupSize = 1;

	protected HerdDinosaurEntity(EntityType<? extends TameableEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public int getMaxSpawnedInChunk() {
		return this.getMaxGroupSize();
	}

	public int getMaxGroupSize() {
		return super.getMaxSpawnedInChunk();
	}

	protected boolean func_212800_dy() {
		return !this.hasGroupLeader();
	}

	public boolean hasGroupLeader() {
		return this.groupLeader != null && this.groupLeader.isAlive();
	}

	public HerdDinosaurEntity func_212803_a(HerdDinosaurEntity groupLeaderIn) {
		this.groupLeader = groupLeaderIn;
		groupLeaderIn.increaseGroupSize();
		return groupLeaderIn;
	}

	public void leaveGroup() {
		this.groupLeader.decreaseGroupSize();
		this.groupLeader = null;
	}

	private void increaseGroupSize() {
		++this.groupSize;
	}

	private void decreaseGroupSize() {
		--this.groupSize;
	}

	public boolean canGroupGrow() {
		return this.isGroupLeader() && this.groupSize < this.getMaxGroupSize();
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick() {
		super.tick();
		if (this.isGroupLeader() && this.world.rand.nextInt(200) == 1) {
			List<HerdDinosaurEntity> list = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(8.0D, 8.0D, 8.0D));
			if (list.size() <= 1) {
				this.groupSize = 1;
			}
		}

	}

	public boolean isGroupLeader() {
		return this.groupSize > 1;
	}

	public boolean inRangeOfGroupLeader() {
		return this.getDistanceSq(this.groupLeader) <= 121.0D;
	}

	public void moveToGroupLeader() {
		if (this.hasGroupLeader()) {
			this.getNavigator().tryMoveToEntityLiving(this.groupLeader, 1.0D);
		}

	}

	public void func_212810_a(Stream<HerdDinosaurEntity> p_212810_1_) {
		p_212810_1_.limit((long)(this.getMaxGroupSize() - this.groupSize)).filter((p_212801_1_) -> {
			return p_212801_1_ != this;
		}).forEach((p_212804_1_) -> {
			p_212804_1_.func_212803_a(this);
		});
	}

	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		if (this.groupLeader == null) {
			this.groupLeader = this;
		}
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

}
