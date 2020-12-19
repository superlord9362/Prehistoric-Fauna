package superlord.prehistoricfauna.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IShearable;

import java.util.Random;

@SuppressWarnings("deprecation")
public class PrehistoricPlantBlock extends BushBlock implements IGrowable, IShearable {
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
	
	public PrehistoricPlantBlock(Block.Properties properties) {
		super(properties);
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
      return SHAPE;
   }
	
	public boolean canGrow(IBlockReader world, BlockPos pos, BlockState state, boolean isCleint) {
		return false;
	}
	
	@Override
	public boolean canUseBonemeal(World world, Random rand, BlockPos pos, BlockState state) {
		return false;
	}
	
	public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {

	}
	
	public Block.OffsetType getOffsetType() {
		return Block.OffsetType.XYZ;
	}
	
}
