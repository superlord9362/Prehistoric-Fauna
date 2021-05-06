package superlord.prehistoricfauna.util;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import superlord.prehistoricfauna.init.BlockInit;

public interface IPFBlockState {
	
	default BlockState getBlockState()
    {
        return (BlockState)this;
    }
	
	default boolean isPortalFrame(IWorldReader world, BlockPos pos)
    {
        return isPortalFrame(getBlockState(), world, pos);
    }
	
	default boolean isPortalFrame(BlockState state, IWorldReader world, BlockPos pos)
    {
        return state.getBlock() == BlockInit.PORTAL_FRAME;
    }

}
