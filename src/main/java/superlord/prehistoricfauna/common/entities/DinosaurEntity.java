package superlord.prehistoricfauna.common.entities;

import java.util.Random;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.Tags;

public class DinosaurEntity extends TameableEntity {
	
	protected DinosaurEntity(EntityType<? extends TameableEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public static boolean canDinosaurSpawn(EntityType<? extends AnimalEntity> animal, IWorld worldIn, SpawnReason reason, BlockPos pos, Random random) {
	      return (worldIn.getBlockState(pos.down()).isIn(Tags.Blocks.DIRT) || worldIn.getBlockState(pos.down()).isIn(Tags.Blocks.SAND)) && worldIn.getLightSubtracted(pos, 0) > 8;
	   }

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		return null;
	}

}
