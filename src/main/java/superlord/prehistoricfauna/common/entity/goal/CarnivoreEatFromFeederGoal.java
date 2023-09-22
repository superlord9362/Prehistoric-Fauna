package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import superlord.prehistoricfauna.common.blocks.FeederBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.init.PFSounds;

public class CarnivoreEatFromFeederGoal extends MoveToBlockGoal {
	DinosaurEntity dinosaur;
	protected int field_220731_g;

	public CarnivoreEatFromFeederGoal(DinosaurEntity dinosaur, double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
		super(dinosaur, p_i50737_2_, p_i50737_4_, p_i50737_5_);
		this.dinosaur = dinosaur;
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
		return blockstate.getBlock() instanceof FeederBlock && blockstate.getValue(FeederBlock.MEAT) == true;
	}

	protected BlockPos getMoveToTarget() {
		if (!dinosaur.level.getBlockState(blockPos.north()).isCollisionShapeFullBlock(dinosaur.level, blockPos.north())) {
			return this.blockPos.north();
		} else {
			if (!dinosaur.level.getBlockState(blockPos.south()).isCollisionShapeFullBlock(dinosaur.level, blockPos.south())) {
				return this.blockPos.south();
			} else {
				if (!dinosaur.level.getBlockState(blockPos.east()).isCollisionShapeFullBlock(dinosaur.level, blockPos.east())) {
					return this.blockPos.east();
				} else {
					if (!dinosaur.level.getBlockState(blockPos.west()).isCollisionShapeFullBlock(dinosaur.level, blockPos.west())) {
						return this.blockPos.west();
					} else {
						if (!dinosaur.level.getBlockState(blockPos.north().east()).isCollisionShapeFullBlock(dinosaur.level, blockPos.north().east())) {
							return this.blockPos.north().east();
						} else {
							if (!dinosaur.level.getBlockState(blockPos.north().west()).isCollisionShapeFullBlock(dinosaur.level, blockPos.north().west())) {
								return this.blockPos.north().west();
							} else {
								if (!dinosaur.level.getBlockState(blockPos.south().east()).isCollisionShapeFullBlock(dinosaur.level, blockPos.south().east())) {
									return this.blockPos.south().east();
								} else {
									if (!dinosaur.level.getBlockState(blockPos.south().west()).isCollisionShapeFullBlock(dinosaur.level, blockPos.south().west())) {
										return this.blockPos.south().west();
									} else return blockPos.above();
								}
							}
						}
					}
				}
			}
		} 
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
				dinosaur.level.playSound((Player)null, this.blockPos, PFSounds.MEAT_EATING, SoundSource.NEUTRAL, 1, 1);
			}
		}
		if (dinosaur.getCurrentHunger() >= 13) {
			dinosaur.setEating(false);
		}
		super.tick();
	}

	protected void eatBerry() {
		int missingHunger = dinosaur.maxHunger - dinosaur.getCurrentHunger();
		int hunger = dinosaur.getCurrentHunger();
		FeederBlock block = (FeederBlock) dinosaur.level.getBlockState(this.blockPos).getBlock();
		int foodContained = block.getFoodAmount(dinosaur.level, this.blockPos);
		if (missingHunger <= foodContained) {
			block.setFoodAmount(foodContained - missingHunger, dinosaur.level, this.blockPos);
			dinosaur.setHunger(dinosaur.maxHunger);
			dinosaur.setEating(false);
		} else if (foodContained - missingHunger < 0) {
			block.setFoodAmount(0, dinosaur.level, this.blockPos);
			dinosaur.setHunger(hunger + foodContained);
			dinosaur.setEating(false);
			dinosaur.level.setBlock(blockPos, block.defaultBlockState(), 0);
		}
		if (dinosaur.getBbHeight() >= 1.5F) {
			dinosaur.level.playSound((Player)null, this.blockPos, PFSounds.LARGE_MEAT_GULP, SoundSource.NEUTRAL, 1, 1);
		} else {
			dinosaur.level.playSound((Player)null, this.blockPos, PFSounds.SMALL_MEAT_GULP, SoundSource.NEUTRAL, 1, 1);
		}
	}

	/**
	 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
	 * method as well.
	 */
	public boolean canUse() {
		return !dinosaur.isAsleep() && super.canUse() && dinosaur.getCurrentHunger() < dinosaur.getHalfHunger();
	}
	
	public void stop() {
		super.stop();
		dinosaur.setEating(false);
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