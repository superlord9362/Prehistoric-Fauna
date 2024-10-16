package superlord.prehistoricfauna.common.entity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class PFHangingSignBlockEntity extends HangingSignBlockEntity {

	public PFHangingSignBlockEntity(BlockPos pos, BlockState state) {
		super(pos, state);
	}
	
	@Override
	public BlockEntityType<?> getType() {
		return PFBlockEntities.HANGING_SIGN.get();
	}
	
}
