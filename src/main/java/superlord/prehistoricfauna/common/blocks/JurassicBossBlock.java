package superlord.prehistoricfauna.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import superlord.prehistoricfauna.common.entity.block.JurassicBossBlockEntity;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class JurassicBossBlock extends BaseEntityBlock {

	public JurassicBossBlock(Properties p_49795_) {
		super(p_49795_);
	}
    
    public RenderShape getRenderShape(BlockState p_49653_) {
		return RenderShape.MODEL;
	}

    @Nullable
	public BlockEntity newBlockEntity(BlockPos p_152184_, BlockState p_152185_) {
		return new JurassicBossBlockEntity(p_152184_, p_152185_);
	}

	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152180_, BlockState p_152181_, BlockEntityType<T> p_152182_) {
		return p_152180_.isClientSide ? null : createTickerHelper(p_152182_, PFBlockEntities.JURASSIC_BOSS.get(), JurassicBossBlockEntity::serverTick);
	}

}
