package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import superlord.prehistoricfauna.init.PFBlocks;

public class PortalFrameBlock extends Block {

	public static final BooleanProperty ACTIVATED = BooleanProperty.create("activated");

	public PortalFrameBlock(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.stateDefinition.any().setValue(ACTIVATED, Boolean.valueOf(false)));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(ACTIVATED);
	}

	public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos pos1, boolean b_1) {
	      if (!level.isClientSide()) {
	          if (!(level.getBlockState(pos.east()).is(PFBlocks.CRETACEOUS_PORTAL.get()) || level.getBlockState(pos.west()).is(PFBlocks.CRETACEOUS_PORTAL.get())|| level.getBlockState(pos.north()).is(PFBlocks.CRETACEOUS_PORTAL.get()) || level.getBlockState(pos.south()).is(PFBlocks.CRETACEOUS_PORTAL.get()) || level.getBlockState(pos.above()).is(PFBlocks.CRETACEOUS_PORTAL.get()) || level.getBlockState(pos.below()).is(PFBlocks.CRETACEOUS_PORTAL.get()))) {
	        	  level.setBlockAndUpdate(pos, state.setValue(ACTIVATED, false));
	          }
	          if ((level.getBlockState(pos.above()).is(this) && level.getBlockState(pos.above()).getValue(ACTIVATED) == false || level.getBlockState(pos.below()).is(this) && level.getBlockState(pos.below()).getValue(ACTIVATED) == false)) {
	        	  level.setBlock(pos, state.setValue(ACTIVATED, false), 18);
	          }
	          if (!(level.getBlockState(pos.east()).is(PFBlocks.JURASSIC_PORTAL.get()) || level.getBlockState(pos.west()).is(PFBlocks.JURASSIC_PORTAL.get())|| level.getBlockState(pos.north()).is(PFBlocks.JURASSIC_PORTAL.get()) || level.getBlockState(pos.south()).is(PFBlocks.JURASSIC_PORTAL.get()) || level.getBlockState(pos.above()).is(PFBlocks.JURASSIC_PORTAL.get()) || level.getBlockState(pos.below()).is(PFBlocks.JURASSIC_PORTAL.get()))) {
	        	  level.setBlockAndUpdate(pos, state.setValue(ACTIVATED, false));
	          }
	          if (!(level.getBlockState(pos.east()).is(PFBlocks.TRIASSIC_PORTAL.get()) || level.getBlockState(pos.west()).is(PFBlocks.TRIASSIC_PORTAL.get())|| level.getBlockState(pos.north()).is(PFBlocks.TRIASSIC_PORTAL.get()) || level.getBlockState(pos.south()).is(PFBlocks.TRIASSIC_PORTAL.get()) || level.getBlockState(pos.above()).is(PFBlocks.TRIASSIC_PORTAL.get()) || level.getBlockState(pos.below()).is(PFBlocks.TRIASSIC_PORTAL.get()))) {
	        	  level.setBlockAndUpdate(pos, state.setValue(ACTIVATED, false));
	          }
	      }
	}

}
