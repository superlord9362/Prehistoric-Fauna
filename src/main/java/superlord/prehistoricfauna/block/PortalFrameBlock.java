package superlord.prehistoricfauna.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import superlord.prehistoricfauna.init.BlockInit;

public class PortalFrameBlock extends DirectionalBlock {
	
	public static final BooleanProperty TRIGGERED = BlockStateProperties.TRIGGERED;

	public PortalFrameBlock(Properties builder) {
		super(builder);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.UP).with(TRIGGERED, false));
	}
	
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.with(FACING, mirrorIn.mirror(state.get(FACING)));
	}
	
	public BlockState getStateForPlacement(BlockItemUseContext context) {
	      return this.getDefaultState().with(FACING, context.getNearestLookingDirection().getOpposite());
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, TRIGGERED);
	}
	
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
	    if(worldIn.getBlockState(currentPos.up()).getBlock() == BlockInit.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.down()).getBlock() == BlockInit.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.east()).getBlock() == BlockInit.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.west()).getBlock() == BlockInit.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.north()).getBlock() == BlockInit.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.south()).getBlock() == BlockInit.TRIASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.up()).getBlock() == BlockInit.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.down()).getBlock() == BlockInit.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.east()).getBlock() == BlockInit.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.west()).getBlock() == BlockInit.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.north()).getBlock() == BlockInit.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.south()).getBlock() == BlockInit.JURASSIC_PORTAL.get() || worldIn.getBlockState(currentPos.up()).getBlock() == BlockInit.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.down()).getBlock() == BlockInit.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.east()).getBlock() == BlockInit.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.west()).getBlock() == BlockInit.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.north()).getBlock() == BlockInit.CRETACEOUS_PORTAL.get() || worldIn.getBlockState(currentPos.south()).getBlock() == BlockInit.CRETACEOUS_PORTAL.get()) {
	    	this.getDefaultState().with(TRIGGERED, true);
	    } else {
	    	this.getDefaultState();
	    }
		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}
	
}
