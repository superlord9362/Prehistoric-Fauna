package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import superlord.prehistoricfauna.common.entity.block.PFSignBlockEntity;

public class PFWallSignBlock extends WallSignBlock {

	public PFWallSignBlock(Properties properties, WoodType type) {
		super(properties, type);
	}
	
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new PFSignBlockEntity(pos, state);
	}
	
}
