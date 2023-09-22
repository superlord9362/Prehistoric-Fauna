package superlord.prehistoricfauna.common.entity.block;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import superlord.prehistoricfauna.common.blocks.FeederBlock;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class FeederBlockEntity extends BlockEntity {

	int foodAmount = 0;

	public FeederBlockEntity(BlockEntityType<?> blockEntity, BlockPos pos, BlockState state) {
		super(PFBlockEntities.FEEDER.get(), pos, state);
	}

	public FeederBlockEntity(BlockPos pos, BlockState state) {
		super(PFBlockEntities.FEEDER.get(), pos, state);
	}

	public void load(CompoundTag p_155616_) {
		super.load(p_155616_);
		this.setFoodAmount(p_155616_.getInt("FoodAmount"));
	}

	protected void saveAdditional(CompoundTag p_187507_) {
		super.saveAdditional(p_187507_);
		p_187507_.putInt("FoodAmount", this.getFoodAmount());

	}

	public int getFoodAmount() {
		return this.foodAmount;
	}

	public void setFoodAmount(int p_59518_) {
		this.foodAmount = p_59518_;
		this.setChanged();
	}

	public static void tick(Level world, BlockPos pos, BlockState state, FeederBlockEntity blockEntity) {
		if (!world.isClientSide) {
			int foodAmount = blockEntity.foodAmount;
			if (foodAmount <= 0) {
				blockEntity.changeFoodLevelTo0((ServerLevel) world, state, pos);
				blockEntity.setChanged();
			}
			if (foodAmount <= 143 && foodAmount > 0) {
				blockEntity.changeFoodLevelTo1((ServerLevel) world, state, pos);
				blockEntity.setChanged();
			}
			if (foodAmount <= 286 && foodAmount > 143) {
				blockEntity.changeFoodLevelTo2((ServerLevel) world, state, pos);
				blockEntity.setChanged();
			}
			if (foodAmount <= 429 && foodAmount > 286) {
				blockEntity.changeFoodLevelTo3((ServerLevel) world, state, pos);
				blockEntity.setChanged();
			}
			if (foodAmount <= 572 && foodAmount > 429) {
				blockEntity.changeFoodLevelTo4((ServerLevel) world, state, pos);
				blockEntity.setChanged();
			}
			if (foodAmount <= 715 && foodAmount > 572) {
				blockEntity.changeFoodLevelTo5((ServerLevel) world, state, pos);
				blockEntity.setChanged();
			}
			if (foodAmount < 1001 && foodAmount > 715) {
				blockEntity.changeFoodLevelTo6((ServerLevel) world, state, pos);
				blockEntity.setChanged();
			}
			if (foodAmount == 1001) {
				blockEntity.changeFoodLevelTo7((ServerLevel) world, state, pos);
				blockEntity.setChanged();
			}
		}
	}
	
	public void changeFoodLevelTo0(ServerLevel world, BlockState state, BlockPos pos) {
		world.setBlockAndUpdate(pos, state.setValue(FeederBlock.FOOD_LEVEL, 0).setValue(FeederBlock.EGG, false).setValue(FeederBlock.FISH, false).setValue(FeederBlock.MEAT, false).setValue(FeederBlock.PLANT, false).setValue(FeederBlock.SHELLFISH, false));
	}
	
	public void changeFoodLevelTo1(ServerLevel world, BlockState state, BlockPos pos) {
		BlockState currentState = world.getBlockState(pos);
		world.setBlockAndUpdate(pos, currentState.setValue(FeederBlock.FOOD_LEVEL, 1));
	}
	
	public void changeFoodLevelTo2(ServerLevel world, BlockState state, BlockPos pos) {
		BlockState currentState = world.getBlockState(pos);
		world.setBlockAndUpdate(pos, currentState.setValue(FeederBlock.FOOD_LEVEL, 2));
	}
	
	public void changeFoodLevelTo3(ServerLevel world, BlockState state, BlockPos pos) {
		BlockState currentState = world.getBlockState(pos);
		world.setBlockAndUpdate(pos, currentState.setValue(FeederBlock.FOOD_LEVEL, 3));
	}
	
	public void changeFoodLevelTo4(ServerLevel world, BlockState state, BlockPos pos) {
		BlockState currentState = world.getBlockState(pos);
		world.setBlockAndUpdate(pos, currentState.setValue(FeederBlock.FOOD_LEVEL, 4));
	}
	
	public void changeFoodLevelTo5(ServerLevel world, BlockState state, BlockPos pos) {
		BlockState currentState = world.getBlockState(pos);
		world.setBlockAndUpdate(pos, currentState.setValue(FeederBlock.FOOD_LEVEL, 5));
	}

	public void changeFoodLevelTo6(ServerLevel world, BlockState state, BlockPos pos) {
		BlockState currentState = world.getBlockState(pos);
		world.setBlockAndUpdate(pos, currentState.setValue(FeederBlock.FOOD_LEVEL, 6));
	}
	
	public void changeFoodLevelTo7(ServerLevel world, BlockState state, BlockPos pos) {
		BlockState currentState = world.getBlockState(pos);
		world.setBlockAndUpdate(pos, currentState.setValue(FeederBlock.FOOD_LEVEL, 7));
	}

}
