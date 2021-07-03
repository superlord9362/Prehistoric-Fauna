package superlord.prehistoricfauna.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class TriassicTimeBlock extends Block {

	private static final VoxelShape AABB = Block.makeCuboidShape(4, 4, 4, 12, 12, 12);

	public TriassicTimeBlock() {
		super(Properties.create(Material.IRON).sound(SoundType.METAL).notSolid().variableOpacity().hardnessAndResistance(2.0F, 1000.0F));
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB;
	}

	public boolean isOpaqueCube(BlockState state) {
		return false;
	}

	public boolean isFullCube(BlockState state) {
		return false;
	}

	public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (oldState.getBlock() != state.getBlock()) {
			/*if (!BlockInit.TRIASSIC_PORTAL.get().tryToCreatePortal(world, pos)) {
				if (!state.isValidPosition(world, pos)) {
					world.removeBlock(pos, false);
				}
				Add back later
			}*/
		}
	}

}
