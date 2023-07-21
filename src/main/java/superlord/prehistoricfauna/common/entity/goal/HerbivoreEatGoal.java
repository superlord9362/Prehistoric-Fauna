package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.init.PFTags;

public class HerbivoreEatGoal extends MoveToBlockGoal {
	protected int field_220731_g;
	DinosaurEntity dinosaur;

	public HerbivoreEatGoal(DinosaurEntity entity, double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
		super(entity, p_i50737_2_, p_i50737_4_, p_i50737_5_);
		this.dinosaur = entity;
	}

	public double getTargetDistanceSq() {
		return 2.0D;
	}

	public boolean shouldMove() {
		return this.tryTicks % 100 == 0;
	}

	/**
	 * Return true to set given position as destination
	 */
	protected boolean isValidTarget(LevelReader worldIn, BlockPos pos) {
		BlockState blockstate = worldIn.getBlockState(pos);
		return blockstate.is(PFTags.PLANTS_2_HUNGER) || blockstate.is(PFTags.PLANTS_4_HUNGER) || blockstate.is(PFTags.PLANTS_6_HUNGER) || blockstate.is(PFTags.PLANTS_8_HUNGER) || blockstate.is(PFTags.PLANTS_10_HUNGER) || blockstate.is(PFTags.PLANTS_12_HUNGER) || blockstate.is(PFTags.PLANTS_15_HUNGER) || blockstate.is(PFTags.PLANTS_20_HUNGER) || blockstate.is(PFTags.PLANTS_25_HUNGER) || blockstate.is(PFTags.PLANTS_30_HUNGER);
	}

	/**
	 * Keep ticking a continuous task that has already been started
	 */
	public void tick() {
		if (this.isReachedTarget()) {
			if (this.field_220731_g >= 20) {
				this.eatBerry();
			} else {
				++this.field_220731_g;
				dinosaur.setEating(true);
			}
			if (this.field_220731_g % 5 == 1) {
				dinosaur.level.playSound((Player)null, this.blockPos, SoundEvents.GRASS_HIT, SoundSource.NEUTRAL, 1, 1);
			}
		}
		if (dinosaur.getCurrentHunger() >= 13) {
			dinosaur.setEating(false);
		}
		super.tick();
	}

	protected void eatBerry() {
		BlockState blockstate = dinosaur.level.getBlockState(this.blockPos);

		if (blockstate.is(PFTags.PLANTS_2_HUNGER)) {
			int hunger = dinosaur.getCurrentHunger();
			if (hunger + 2 >= dinosaur.maxHunger) {
				dinosaur.setHunger(dinosaur.maxHunger);
				dinosaur.setEating(false);
			} else {
				dinosaur.setHunger(hunger + 2);
				dinosaur.setEating(false);
			}
		}
		if (blockstate.is(PFTags.PLANTS_4_HUNGER)) {
			int hunger = dinosaur.getCurrentHunger();
			if (hunger + 4 >= dinosaur.maxHunger) {
				dinosaur.setHunger(dinosaur.maxHunger);
				dinosaur.setEating(false);
			} else {
				dinosaur.setHunger(hunger + 4);
				dinosaur.setEating(false);
			}
		}
		if (blockstate.is(PFTags.PLANTS_6_HUNGER)) {
			int hunger = dinosaur.getCurrentHunger();
			if (hunger + 6 >= dinosaur.maxHunger) {
				dinosaur.setHunger(dinosaur.maxHunger);
				dinosaur.setEating(false);
			} else {
				dinosaur.setHunger(hunger + 6);
				dinosaur.setEating(false);
			}
		}
		if (blockstate.is(PFTags.PLANTS_8_HUNGER)) {
			int hunger = dinosaur.getCurrentHunger();
			if (hunger + 8 >= dinosaur.maxHunger) {
				dinosaur.setHunger(dinosaur.maxHunger);
				dinosaur.setEating(false);
			} else {
				dinosaur.setHunger(hunger + 8);
				dinosaur.setEating(false);
			}
		}
		if (blockstate.is(PFTags.PLANTS_10_HUNGER)) {
			int hunger = dinosaur.getCurrentHunger();
			if (hunger + 10 >= dinosaur.maxHunger) {
				dinosaur.setHunger(dinosaur.maxHunger);
				dinosaur.setEating(false);
			} else {
				dinosaur.setHunger(hunger + 10);
				dinosaur.setEating(false);
			}
		}
		if (blockstate.is(PFTags.PLANTS_12_HUNGER)) {
			int hunger = dinosaur.getCurrentHunger();
			if (hunger + 12 >= dinosaur.maxHunger) {
				dinosaur.setHunger(dinosaur.maxHunger);
				dinosaur.setEating(false);
			} else {
				dinosaur.setHunger(hunger + 12);
				dinosaur.setEating(false);
			}
		}
		if (blockstate.is(PFTags.PLANTS_15_HUNGER)) {
			int hunger = dinosaur.getCurrentHunger();
			if (hunger + 15 >= dinosaur.maxHunger) {
				dinosaur.setHunger(dinosaur.maxHunger);
				dinosaur.setEating(false);
			} else {
				dinosaur.setHunger(hunger + 15);
				dinosaur.setEating(false);
			}
		}
		if (blockstate.is(PFTags.PLANTS_20_HUNGER)) {
			int hunger = dinosaur.getCurrentHunger();
			if (hunger + 20 >= dinosaur.maxHunger) {
				dinosaur.setHunger(dinosaur.maxHunger);
				dinosaur.setEating(false);
			} else {
				dinosaur.setHunger(hunger + 20);
				dinosaur.setEating(false);
			}
		}
		if (blockstate.is(PFTags.PLANTS_25_HUNGER)) {
			int hunger = dinosaur.getCurrentHunger();
			if (hunger + 25 >= dinosaur.maxHunger) {
				dinosaur.setHunger(dinosaur.maxHunger);
				dinosaur.setEating(false);
			} else {
				dinosaur.setHunger(hunger + 25);
				dinosaur.setEating(false);
			}
		}
		if (blockstate.is(PFTags.PLANTS_30_HUNGER)) {
			int hunger = dinosaur.getCurrentHunger();
			if (hunger + 30 >= dinosaur.maxHunger) {
				dinosaur.setHunger(dinosaur.maxHunger);
				dinosaur.setEating(false);
			} else {
				dinosaur.setHunger(hunger + 30);
				dinosaur.setEating(false);
			}
		}
	}

	/**
	 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	 * method as well.
	 */
	public boolean canUse() {
		return !dinosaur.isAsleep() && super.canUse() && dinosaur.getCurrentHunger() < dinosaur.getHalfHunger();
	}

	public boolean canContinueToUse() {
		if (dinosaur.getCurrentHunger() >= dinosaur.maxHunger || dinosaur.isAsleep()) {
			return false;
		} else return super.canContinueToUse();
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void start() {
		this.field_220731_g = 0;
		super.start();
	}
}
