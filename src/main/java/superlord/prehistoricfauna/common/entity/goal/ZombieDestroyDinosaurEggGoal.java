package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.RemoveBlockGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class ZombieDestroyDinosaurEggGoal extends RemoveBlockGoal {
	public ZombieDestroyDinosaurEggGoal(Block p_25840_, PathfinderMob p_34344_, double p_34345_, int p_34346_) {
		super(p_25840_, p_34344_, p_34345_, p_34346_);
	}

	public void playDestroyProgressSound(LevelAccessor p_34351_, BlockPos p_34352_) {
		p_34351_.playSound((Player)null, p_34352_, SoundEvents.ZOMBIE_DESTROY_EGG, SoundSource.HOSTILE, 0.5F, 0.9F + p_34351_.getRandom().nextFloat() * 0.2F);
	}

	public void playBreakSound(Level p_34348_, BlockPos p_34349_) {
		p_34348_.playSound((Player)null, p_34349_, SoundEvents.TURTLE_EGG_BREAK, SoundSource.BLOCKS, 0.7F, 0.9F + p_34348_.random.nextFloat() * 0.2F);
	}
	
	public double acceptedDistance() {
		return 1.14D;
	}
}
