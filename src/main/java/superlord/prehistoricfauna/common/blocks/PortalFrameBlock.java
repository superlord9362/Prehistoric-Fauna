package superlord.prehistoricfauna.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import superlord.prehistoricfauna.init.PFBlocks;

public class PortalFrameBlock extends Block {

	public static final BooleanProperty ACTIVATED = BooleanProperty.create("activated");

	public PortalFrameBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(ACTIVATED, Boolean.valueOf(false)));
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(ACTIVATED);
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (worldIn.getBlockState(currentPos.up()).getBlock() == PFBlocks.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.down()).getBlock() == PFBlocks.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.east()).getBlock() == PFBlocks.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.west()).getBlock() == PFBlocks.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.north()).getBlock() == PFBlocks.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.south()).getBlock() == PFBlocks.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.up().north()).getBlock() == PFBlocks.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.up().south()).getBlock() == PFBlocks.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.up().east()).getBlock() == PFBlocks.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.up().west()).getBlock() == PFBlocks.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.down().north()).getBlock() == PFBlocks.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.down().south()).getBlock() == PFBlocks.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.down().east()).getBlock() == PFBlocks.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.down().west()).getBlock() == PFBlocks.CRETACEOUS_PORTAL.get()) {
			worldIn.setBlockState(currentPos, this.getDefaultState().with(ACTIVATED, true), 2);
			System.out.println("Coolio");
		} else if (worldIn.getBlockState(currentPos.up()).getBlock() == PFBlocks.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.down()).getBlock() == PFBlocks.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.east()).getBlock() == PFBlocks.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.west()).getBlock() == PFBlocks.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.north()).getBlock() == PFBlocks.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.south()).getBlock() == PFBlocks.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.up().north()).getBlock() == PFBlocks.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.up().south()).getBlock() == PFBlocks.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.up().east()).getBlock() == PFBlocks.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.up().west()).getBlock() == PFBlocks.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.down().north()).getBlock() == PFBlocks.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.down().south()).getBlock() == PFBlocks.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.down().east()).getBlock() == PFBlocks.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.down().west()).getBlock() == PFBlocks.JURASSIC_PORTAL.get()) {
			worldIn.setBlockState(currentPos, this.getDefaultState().with(ACTIVATED, true), 2);
		} else if (worldIn.getBlockState(currentPos.up()).getBlock() == PFBlocks.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.down()).getBlock() == PFBlocks.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.east()).getBlock() == PFBlocks.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.west()).getBlock() == PFBlocks.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.north()).getBlock() == PFBlocks.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.south()).getBlock() == PFBlocks.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.up().north()).getBlock() == PFBlocks.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.up().south()).getBlock() == PFBlocks.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.up().east()).getBlock() == PFBlocks.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.up().west()).getBlock() == PFBlocks.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.down().north()).getBlock() == PFBlocks.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.down().south()).getBlock() == PFBlocks.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.down().east()).getBlock() == PFBlocks.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.down().west()).getBlock() == PFBlocks.TRIASSIC_PORTAL.get()) {
			worldIn.setBlockState(currentPos, this.getDefaultState().with(ACTIVATED, true), 2);
		} else {
			worldIn.setBlockState(currentPos, this.getDefaultState().with(ACTIVATED, false), 2);
		}
		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}


}
