package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;
import superlord.prehistoricfauna.init.PFBlocks;

public class NelumboPadBlock extends BushBlock {

	protected static final VoxelShape AABB = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 1.5D, 15.0D);

	public NelumboPadBlock(Properties p_58162_) {
		super(p_58162_);
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.WATER;
	}

	public VoxelShape getShape(BlockState p_58169_, BlockGetter p_58170_, BlockPos p_58171_, CollisionContext p_58172_) {
		return AABB;
	}

	protected boolean mayPlaceOn(BlockState p_58174_, BlockGetter p_58175_, BlockPos p_58176_) {
		FluidState fluidstate = p_58175_.getFluidState(p_58176_);
		FluidState fluidstate1 = p_58175_.getFluidState(p_58176_.above());
		return (fluidstate.getType() == Fluids.WATER || p_58174_.getMaterial() == Material.ICE) && fluidstate1.getType() == Fluids.EMPTY;
	}

	public boolean canSurvive(BlockState p_51028_, LevelReader p_51029_, BlockPos p_51030_) {
		BlockPos blockpos = p_51030_.below();
		return p_51029_.getBlockState(blockpos).is(PFBlocks.NELUMBO_STEM.get());
	}

}
