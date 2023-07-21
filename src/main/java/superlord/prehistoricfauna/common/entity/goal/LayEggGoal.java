package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.init.PFBlocks;

public class LayEggGoal  extends MoveToBlockGoal {
	private final DinosaurEntity dinosaur;

	public LayEggGoal(DinosaurEntity dinosaur, double speed) {
		super(dinosaur, speed, 16);
		this.dinosaur = dinosaur;
	}

	public boolean canUse() {
		return this.dinosaur.hasBaby() ? super.canUse() : false;
	}

	public boolean canContinueToUse() {
		return super.canContinueToUse() && this.dinosaur.hasBaby();
	}

	public void tick() {
		super.tick();
		BlockPos blockpos = new BlockPos(this.dinosaur.blockPosition());
		if (this.isReachedTarget()) {
			if (this.dinosaur.isBirthing < 1) {
				this.dinosaur.setBirthing(true);
			} else if (this.dinosaur.isBirthing > 200) {
				Level world = this.dinosaur.level;
				world.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
				world.setBlock(this.blockPos.above(), dinosaur.getEggBlock(), 3);
				this.dinosaur.setHasBaby(false);
				this.dinosaur.setBirthing(false);
				this.dinosaur.setInLoveTime(600);
			}
			if (this.dinosaur.isBirthing()) {
				this.dinosaur.isBirthing++;
			}
		}
	}

	protected boolean isValidTarget(LevelReader worldIn, BlockPos pos) {
		if (!worldIn.isEmptyBlock(pos.above())) {
			return false;
		} else {
			Block block = worldIn.getBlockState(pos).getBlock();
			BlockState state = worldIn.getBlockState(pos);
			return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.MYCELIUM || block == Blocks.SAND || block == Blocks.RED_SAND || block == PFBlocks.MOSSY_DIRT.get() || block == PFBlocks.MOSS_BLOCK.get() || block == PFBlocks.LOAM.get() || block == PFBlocks.PACKED_LOAM.get() || block == PFBlocks.SILT.get() || block == PFBlocks.PACKED_LOAM.get() || state.is(BlockTags.LEAVES);
		}
	}

}
