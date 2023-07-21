package superlord.prehistoricfauna.common.entity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import superlord.prehistoricfauna.common.blocks.FeederBlock;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class FeederBlockEntity extends BlockEntity {

	public static int foodAmount = 0;
	
	public FeederBlockEntity(BlockEntityType<?> blockEntity, BlockPos pos, BlockState state) {
		super(PFBlockEntities.FEEDER.get(), pos, state);
	}

	public FeederBlockEntity(BlockPos pos, BlockState state) {
		super(PFBlockEntities.FEEDER.get(), pos, state);
	}

	protected void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
		tag.putInt("foodAmount", foodAmount);
	}

	public void load(CompoundTag tag) {
		super.load(tag);
		foodAmount = tag.getInt("foodAmount");
	}
	
	public void setFoodAmount(int amount) {
		foodAmount = amount;
	}
	
	public static int getFoodAmount() {
		return foodAmount;
	}
	
	public static void tick(Level world, BlockPos pos, BlockState state, FeederBlockEntity blockEntity) {
		BlockState currentState = world.getBlockState(pos);
		if (getFoodAmount() == 0) {
			world.setBlock(pos, currentState.setValue(FeederBlock.FOOD_LEVEL, 0).setValue(FeederBlock.EGG, false).setValue(FeederBlock.FISH, false).setValue(FeederBlock.MEAT, false).setValue(FeederBlock.PLANT, false).setValue(FeederBlock.SHELLFISH, false), 0);
		}
		if (getFoodAmount() <= 26 && getFoodAmount() > 0) {
			world.setBlock(pos, currentState.setValue(FeederBlock.FOOD_LEVEL, 1), 0);
		}
		if (getFoodAmount() <= 52 && getFoodAmount() > 26) {
			world.setBlock(pos, currentState.setValue(FeederBlock.FOOD_LEVEL, 2), 0);
		}
		if (getFoodAmount() <= 78 && getFoodAmount() > 52) {
			world.setBlock(pos, currentState.setValue(FeederBlock.FOOD_LEVEL, 3), 0);
		}
		if (getFoodAmount() <= 104 && getFoodAmount() > 78) {
			world.setBlock(pos, currentState.setValue(FeederBlock.FOOD_LEVEL, 4), 0);
		}
		if (getFoodAmount() <= 130 && getFoodAmount() > 104) {
			world.setBlock(pos, currentState.setValue(FeederBlock.FOOD_LEVEL, 5), 0);
		}
		if (getFoodAmount() < 156 && getFoodAmount() > 130) {
			world.setBlock(pos, currentState.setValue(FeederBlock.FOOD_LEVEL, 6), 0);
		}
		if (getFoodAmount() == 156) {
			world.setBlock(pos, currentState.setValue(FeederBlock.FOOD_LEVEL, 7), 0);
		}
	}

}
