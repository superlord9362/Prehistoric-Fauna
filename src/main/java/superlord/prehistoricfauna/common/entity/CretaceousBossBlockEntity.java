package superlord.prehistoricfauna.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import superlord.prehistoricfauna.common.entity.henos.CorruptedTheropod;
import superlord.prehistoricfauna.init.PFBlockEntities;
import superlord.prehistoricfauna.init.PFEntities;

public class CretaceousBossBlockEntity extends BlockEntity {

	public CretaceousBossBlockEntity(BlockPos p_155134_, BlockState p_155135_) {
		super(PFBlockEntities.CRETACEOUS_BOSS.get(), p_155134_, p_155135_);
	}

	public static void serverTick(Level level, BlockPos pos, BlockState state, CretaceousBossBlockEntity p_155148_) {
		level.removeBlock(pos, false);
		spawnEntity(level, pos);
	}

	private static void spawnEntity(Level level, BlockPos pos) {
		Entity entity = new CorruptedTheropod(PFEntities.CORRUPTED_THEROPOD.get(), level);
		entity.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
		level.addFreshEntity(entity);
	}

}
