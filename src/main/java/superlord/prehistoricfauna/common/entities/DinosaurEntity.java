package superlord.prehistoricfauna.common.entities;

import java.util.Random;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.Tags;

public class DinosaurEntity extends TameableEntity {

	private static final DataParameter<Boolean> ASLEEP = EntityDataManager.createKey(DinosaurEntity.class, DataSerializers.BOOLEAN);

	public boolean isAsleep() {
		return this.dataManager.get(ASLEEP);
	}

	public void setAsleep(boolean isAsleep) {
		this.dataManager.set(ASLEEP, isAsleep);
	}

	public DinosaurEntity(EntityType<? extends TameableEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public static boolean canDinosaurSpawn(EntityType<? extends AnimalEntity> animal, IWorld worldIn, SpawnReason reason, BlockPos pos, Random random) {
		return (worldIn.getBlockState(pos.down()).isIn(Tags.Blocks.DIRT) || worldIn.getBlockState(pos.down()).isIn(Tags.Blocks.SAND)) && worldIn.getLightSubtracted(pos, 0) > 8;
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(ASLEEP, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("IsAsleep", this.isAsleep());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setAsleep(compound.getBoolean("IsAsleep"));
	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		return null;
	}

}
