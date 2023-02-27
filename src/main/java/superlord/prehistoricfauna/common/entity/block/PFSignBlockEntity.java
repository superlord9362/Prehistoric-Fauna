package superlord.prehistoricfauna.common.entity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class PFSignBlockEntity extends SignBlockEntity {
	
	public PFSignBlockEntity(BlockPos pos, BlockState state) {
		super(pos, state);
	}
	
	@Override
	public BlockEntityType<?> getType() {
		return PFBlockEntities.SIGN.get();
	}

}
