package superlord.prehistoricfauna.common.entity.block.compat;

import javax.annotation.Nonnull;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class PFBeehiveBlockEntity extends BeehiveBlockEntity {

	public PFBeehiveBlockEntity(BlockPos pos, BlockState state) {
		super(pos, state);
	}

	@Nonnull
	@Override
	public BlockEntityType<?> getType() {
		return PFBlockEntities.BEEHIVE.get();
	}
}
