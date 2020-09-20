package superlord.prehistoricfauna.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.BlockInit;

public class TriassicTimeBlock extends Block {
	
	private static final VoxelShape AABB = Block.makeCuboidShape(4, 4, 4, 12, 12, 12);

	public TriassicTimeBlock() {
		super(Properties.create(Material.IRON).sound(SoundType.METAL).notSolid().variableOpacity().hardnessAndResistance(2.0F, 1000.0F));
		this.setRegistryName(PrehistoricFauna.MODID, "triassic_time_block");
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
		if(world.getBlockState(pos.down()).getBlock() == BlockInit.PORTAL_FRAME) {
			if (world.getBlockState(pos.east()).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.east().up()).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.east().up(2)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.up(3)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.west().up(3)).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.west(2).up(3)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.west(3)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.west(3).up()).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.west(3).up(2)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.west().down()).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.west(2).down()).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.up()).getBlock() == Blocks.AIR && world.getBlockState(pos.up(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.west()).getBlock() == Blocks.AIR && world.getBlockState(pos.west().up()).getBlock() == Blocks.AIR && world.getBlockState(pos.west().up(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.west(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.west(2).up()).getBlock() == Blocks.AIR && world.getBlockState(pos.west(2).up(2)).getBlock() == Blocks.AIR) {
				world.setBlockState(pos, BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.up(), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.west(), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.west().up(), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.west().up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.west(2), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.west(2).up(), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.west(2).up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState());
			} else if (world.getBlockState(pos.west()).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.west().up()).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.west().up(2)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.up(3)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.east().up(3)).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.east(2).up(3)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.east(3)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.east(3).up()).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.east(3).up(2)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.east().down()).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.east(2).down()).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.up()).getBlock() == Blocks.AIR && world.getBlockState(pos.up(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.east()).getBlock() == Blocks.AIR && world.getBlockState(pos.east().up()).getBlock() == Blocks.AIR && world.getBlockState(pos.east().up(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.east(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.east(2).up()).getBlock() == Blocks.AIR && world.getBlockState(pos.east(2).up(2)).getBlock() == Blocks.AIR) {
				world.setBlockState(pos, BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.up(), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.east(), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.east().up(), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.east().up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.east(2), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.east(2).up(), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.east(2).up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState());
			} else if (world.getBlockState(pos.north()).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.north().up()).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.north().up(2)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.up(3)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.south().up(3)).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.south(2).up(3)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.south(3)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.south(3).up()).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.south(3).up(2)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.south().down()).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.south(2).down()).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.up()).getBlock() == Blocks.AIR && world.getBlockState(pos.up(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.south()).getBlock() == Blocks.AIR && world.getBlockState(pos.south().up()).getBlock() == Blocks.AIR && world.getBlockState(pos.south().up(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.south(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.south(2).up()).getBlock() == Blocks.AIR && world.getBlockState(pos.south(2).up(2)).getBlock() == Blocks.AIR) {
				world.setBlockState(pos, BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.up(), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.south(), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.south().up(), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.south().up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.south(2), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.south(2).up(), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.south(2).up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
			} else if (world.getBlockState(pos.south()).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.south().up()).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.south().up(2)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.up(3)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.north().up(3)).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.north(2).up(3)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.north(3)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.north(3).up()).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.north(3).up(2)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.north().down()).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.north(2).down()).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.up()).getBlock() == Blocks.AIR && world.getBlockState(pos.up(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.north()).getBlock() == Blocks.AIR && world.getBlockState(pos.north().up()).getBlock() == Blocks.AIR && world.getBlockState(pos.north().up(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.north(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.north(2).up()).getBlock() == Blocks.AIR && world.getBlockState(pos.north(2).up(2)).getBlock() == Blocks.AIR) {
				world.setBlockState(pos, BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.up(), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.north(), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.north().up(), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.north().up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.north(2), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.north(2).up(), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.north(2).up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
			}
		} else if (world.getBlockState(pos.down()).getBlock() == BlockInit.PORTAL_PROJECTOR) {
			if (world.getBlockState(pos.east().down()).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.east()).getBlock() == Blocks.AIR && world.getBlockState(pos.east().up()).getBlock() == Blocks.AIR && world.getBlockState(pos.east().up(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.east().up(3)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.east(2)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.east(2).up()).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.east(2).up(2)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.up()).getBlock() == Blocks.AIR && world.getBlockState(pos.up(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.up(3)).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.west().down()).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.west()).getBlock() == Blocks.AIR && world.getBlockState(pos.west().up()).getBlock() == Blocks.AIR && world.getBlockState(pos.west().up(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.west().up(3)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.west(2)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.west(2).up()).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.west(2).up(2)).getBlock() == BlockInit.PORTAL_FRAME) {
				world.setBlockState(pos, BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.up(), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.east(), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.east().up(), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.east().up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.west(), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.west().up(), BlockInit.TRIASSIC_PORTAL.getDefaultState());
				world.setBlockState(pos.west().up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState());
			} else if (world.getBlockState(pos.north().down()).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.north()).getBlock() == Blocks.AIR && world.getBlockState(pos.north().up()).getBlock() == Blocks.AIR && world.getBlockState(pos.north().up(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.north().up(3)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.north(2)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.north(2).up()).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.north(2).up(2)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.up()).getBlock() == Blocks.AIR && world.getBlockState(pos.up(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.up(3)).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.south().down()).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.south()).getBlock() == Blocks.AIR && world.getBlockState(pos.south().up()).getBlock() == Blocks.AIR && world.getBlockState(pos.south().up(2)).getBlock() == Blocks.AIR && world.getBlockState(pos.south().up(3)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.south(2)).getBlock() == BlockInit.PORTAL_FRAME && world.getBlockState(pos.south(2).up()).getBlock() == BlockInit.PORTAL_PROJECTOR && world.getBlockState(pos.south(2).up(2)).getBlock() == BlockInit.PORTAL_FRAME) {
				world.setBlockState(pos, BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.up(), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.north(), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.north().up(), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.north().up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.south(), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.south().up(), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
				world.setBlockState(pos.south().up(2), BlockInit.TRIASSIC_PORTAL.getDefaultState().with(TriassicPortalBlock.AXIS, Axis.Z));
			}
		}
	}
	
}
