package superlord.prehistoricfauna.block;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IShearable;
import superlord.prehistoricfauna.init.BlockInit;

import java.util.Random;

@SuppressWarnings("deprecation")
public class PrehistoricPlant extends BushBlock implements IGrowable, IShearable {
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
	
	public PrehistoricPlant(Block.Properties properties) {
		super(properties);
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
      return SHAPE;
   }
	
	public boolean canGrow(IBlockReader world, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}
	
	@Override
	public boolean canUseBonemeal(World world, Random rand, BlockPos pos, BlockState state) {
		return true;
	}
	
	@SuppressWarnings("static-access")
	public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
		DoublePlantBlock doubleplantblock = (DoublePlantBlock)(this == BlockInit.HORSETAIL.get() ? BlockInit.TALL_HORSETAIL.get() : BlockInit.TALL_OSMUNDA.get());
		if (doubleplantblock.getDefaultState().isValidPosition(world, pos) && world.isValid(pos.up())) {
			doubleplantblock.placeAt(world, pos, 2);
		}
	}
	
	public Block.OffsetType getOffsetType() {
		return Block.OffsetType.XYZ;
	}

}
