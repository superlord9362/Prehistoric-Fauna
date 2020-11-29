package superlord.prehistoricfauna.util;

import net.minecraft.block.BlockState;
import net.minecraft.state.IProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;

import java.util.Collection;

public class BlockUtil {
	
	@SuppressWarnings("rawtypes")
	public static IProperty getAxisProperty(BlockState log) {
		for(IProperty property : log.getProperties()) {
			Collection allowedValues = property.getAllowedValues();
			if(allowedValues.contains(Direction.Axis.X) && allowedValues.contains(Direction.Axis.Y) && allowedValues.contains(Direction.Axis.Z)) {
				return property;
			}
		}
		return null;
	}
	
	public static BlockPos getTopSolidOrLiquidBlock(IWorld world, int x, int z) {
		IChunk chunk = world.getChunk(x >> 4, z >> 4, ChunkStatus.FULL);
        return new BlockPos(x, chunk.getHeight(), z);
	}

}
