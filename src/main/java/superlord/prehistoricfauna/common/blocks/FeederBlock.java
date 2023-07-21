package superlord.prehistoricfauna.common.blocks;

import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.common.entity.block.FeederBlockEntity;
import superlord.prehistoricfauna.init.PFBlockEntities;
import superlord.prehistoricfauna.init.PFTags;

public class FeederBlock extends BaseEntityBlock {

	public static final BooleanProperty MEAT = BooleanProperty.create("meat");
	public static final BooleanProperty PLANT = BooleanProperty.create("plant");
	public static final BooleanProperty EGG = BooleanProperty.create("egg");
	public static final BooleanProperty SHELLFISH = BooleanProperty.create("shellfish");
	public static final BooleanProperty FISH = BooleanProperty.create("fish");
	public static final IntegerProperty FOOD_LEVEL = IntegerProperty.create("food_level", 0, 7);
	private static final VoxelShape OUTER_SHAPE = Shapes.block();
	private static final VoxelShape[] SHAPES = Util.make(new VoxelShape[9], (p_51967_) -> {
		for(int i = 0; i < 8; ++i) {
			p_51967_[i] = Shapes.join(OUTER_SHAPE, Block.box(2.0D, (double)Math.max(2, 1 + i * 2), 2.0D, 14.0D, 16.0D, 14.0D), BooleanOp.ONLY_FIRST);
		}

		p_51967_[8] = p_51967_[7];
	});

	public FeederBlock(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.stateDefinition.any().setValue(MEAT, false).setValue(PLANT, false).setValue(EGG, false).setValue(SHELLFISH, false).setValue(FISH, false).setValue(FOOD_LEVEL, 0));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(MEAT, PLANT, EGG, SHELLFISH, FISH, FOOD_LEVEL);
	}

	@Override
	public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
		return RenderShape.MODEL;
	}

	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		ItemStack stack = player.getItemInHand(hand);
		BlockState foodState = world.getBlockState(pos);
		if (getFoodAmount(world, pos) == 0) {
			if (stack.is(PFTags.MEATS_2_HUNGER) || stack.is(PFTags.MEATS_4_HUNGER) || stack.is(PFTags.MEATS_6_HUNGER) || stack.is(PFTags.MEATS_8_HUNGER) || stack.is(PFTags.MEATS_10_HUNGER) || stack.is(PFTags.MEATS_12_HUNGER)) {
				world.setBlock(pos, foodState.setValue(MEAT, true), 0);
				if (stack.is(PFTags.MEATS_2_HUNGER)) {
					setFoodAmount(getFoodAmount(world, pos) + 2, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.MEATS_4_HUNGER)) {
					setFoodAmount(getFoodAmount(world, pos) + 4, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.MEATS_6_HUNGER)) {
					setFoodAmount(getFoodAmount(world, pos) + 6, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.MEATS_8_HUNGER)) {
					setFoodAmount(getFoodAmount(world, pos) + 8, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.MEATS_10_HUNGER)) {
					setFoodAmount(getFoodAmount(world, pos) + 10, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.MEATS_12_HUNGER)) {
					setFoodAmount(getFoodAmount(world, pos) + 12, world, pos);
					world.getBlockState(pos);
				}
				if (!player.isCreative()) {
					stack.shrink(1);
				}
				return InteractionResult.sidedSuccess(world.isClientSide);
			}
			if (stack.is(PFTags.FISH_2_HUNGER) || stack.is(PFTags.FISH_4_HUNGER)) {
				world.setBlock(pos, foodState.setValue(FISH, true), 0);
				if (stack.is(PFTags.FISH_2_HUNGER)) {
					setFoodAmount(getFoodAmount(world, pos) + 2, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.FISH_4_HUNGER)) {
					setFoodAmount(getFoodAmount(world, pos) + 4, world, pos);
					world.getBlockState(pos);
				}
				if (!player.isCreative()) {
					stack.shrink(1);
				}
				return InteractionResult.sidedSuccess(world.isClientSide);
			}
			if (stack.is(PFTags.SHELLFISH_3_HUNGER)) {
				world.setBlock(pos, foodState.setValue(SHELLFISH, true), 0);
				if (stack.is(PFTags.SHELLFISH_3_HUNGER)) {
					setFoodAmount(getFoodAmount(world, pos) + 3, world, pos);
					world.getBlockState(pos);
				}
				if (!player.isCreative()) {
					stack.shrink(1);
				}
				return InteractionResult.sidedSuccess(world.isClientSide);
			}
			if (stack.is(PFTags.EGGS_5_HUNGER) || stack.is(PFTags.EGGS_10_HUNGER) || stack.is(PFTags.EGGS_15_HUNGER)) {
				world.setBlock(pos, foodState.setValue(EGG, true), 0);
				if (stack.is(PFTags.EGGS_5_HUNGER)) {
					setFoodAmount(getFoodAmount(world, pos) + 5, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.EGGS_10_HUNGER)) {
					setFoodAmount(getFoodAmount(world, pos) + 6, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.EGGS_15_HUNGER)) {
					setFoodAmount(getFoodAmount(world, pos) + 8, world, pos);
					world.getBlockState(pos);
				}
				if (!player.isCreative()) {
					stack.shrink(1);
				}
				return InteractionResult.sidedSuccess(world.isClientSide);
			}
			if (stack.is(PFTags.PLANTS_2_HUNGER_ITEM) || stack.is(PFTags.PLANTS_4_HUNGER_ITEM) || stack.is(PFTags.PLANTS_6_HUNGER_ITEM) || stack.is(PFTags.PLANTS_8_HUNGER_ITEM) || stack.is(PFTags.PLANTS_10_HUNGER_ITEM) || stack.is(PFTags.PLANTS_12_HUNGER_ITEM) || stack.is(PFTags.PLANTS_15_HUNGER_ITEM) || stack.is(PFTags.PLANTS_20_HUNGER_ITEM) || stack.is(PFTags.PLANTS_25_HUNGER_ITEM) || stack.is(PFTags.PLANTS_30_HUNGER_ITEM)) {
				world.setBlock(pos, foodState.setValue(PLANT, true), 0);
				if (stack.is(PFTags.PLANTS_2_HUNGER_ITEM)) {
					setFoodAmount(getFoodAmount(world, pos) + 2, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.PLANTS_4_HUNGER_ITEM)) {
					setFoodAmount(getFoodAmount(world, pos) + 4, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.PLANTS_6_HUNGER_ITEM)) {
					setFoodAmount(getFoodAmount(world, pos) + 6, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.PLANTS_8_HUNGER_ITEM)) {
					setFoodAmount(getFoodAmount(world, pos) + 8, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.PLANTS_10_HUNGER_ITEM)) {
					setFoodAmount(getFoodAmount(world, pos) + 10, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.PLANTS_12_HUNGER_ITEM)) {
					setFoodAmount(getFoodAmount(world, pos) + 12, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.PLANTS_15_HUNGER_ITEM)) {
					setFoodAmount(getFoodAmount(world, pos) + 15, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.PLANTS_20_HUNGER_ITEM)) {
					setFoodAmount(getFoodAmount(world, pos) + 20, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.PLANTS_25_HUNGER_ITEM)) {
					setFoodAmount(getFoodAmount(world, pos) + 25, world, pos);
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.PLANTS_30_HUNGER_ITEM)) {
					setFoodAmount(getFoodAmount(world, pos) + 30, world, pos);
					world.getBlockState(pos);
				}
				if (!player.isCreative()) {
					stack.shrink(1);
				}
				return InteractionResult.sidedSuccess(world.isClientSide);
			}
		}
		if (getFoodAmount(world, pos) < 156) {
			BlockState currentState = world.getBlockState(pos);
			if (hasMeat(currentState)) {
				if (stack.is(PFTags.MEATS_2_HUNGER)) {
					if (getFoodAmount(world, pos) + 2 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 2, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.MEATS_4_HUNGER)) {
					if (getFoodAmount(world, pos) + 4 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 4, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.MEATS_6_HUNGER)) {
					if (getFoodAmount(world, pos) + 6 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 6, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.MEATS_8_HUNGER)) {
					if (getFoodAmount(world, pos) + 8 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 8, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.MEATS_10_HUNGER)) {
					if (getFoodAmount(world, pos) + 10 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 10, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
					world.getBlockState(pos);
				}
				if (stack.is(PFTags.MEATS_12_HUNGER)) {
					if (getFoodAmount(world, pos) + 12 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 12, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
					world.getBlockState(pos);
				}
				if (!player.isCreative()) {
					stack.shrink(1);
				}
				return InteractionResult.sidedSuccess(world.isClientSide);
			}
			if (hasPlants(currentState)) {
				if (stack.is(PFTags.PLANTS_2_HUNGER_ITEM)) {
					if (getFoodAmount(world, pos) + 2 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 2, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
				}
				if (stack.is(PFTags.PLANTS_4_HUNGER_ITEM)) {
					if (getFoodAmount(world, pos) + 4 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 4, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
				}
				if (stack.is(PFTags.PLANTS_6_HUNGER_ITEM)) {
					if (getFoodAmount(world, pos) + 2 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 6, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
				}
				if (stack.is(PFTags.PLANTS_8_HUNGER_ITEM)) {
					if (getFoodAmount(world, pos) + 8 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 8, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
				}
				if (stack.is(PFTags.PLANTS_10_HUNGER_ITEM)) {
					if (getFoodAmount(world, pos) + 10 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 10, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
				}
				if (stack.is(PFTags.PLANTS_12_HUNGER_ITEM)) {
					if (getFoodAmount(world, pos) + 12 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 12, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
				}
				if (stack.is(PFTags.PLANTS_15_HUNGER_ITEM)) {
					if (getFoodAmount(world, pos) + 15 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 15, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
				}
				if (stack.is(PFTags.PLANTS_20_HUNGER_ITEM)) {
					if (getFoodAmount(world, pos) + 20 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 20, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
				}
				if (stack.is(PFTags.PLANTS_25_HUNGER_ITEM)) {
					if (getFoodAmount(world, pos) + 25 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 25, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
				}
				if (stack.is(PFTags.PLANTS_30_HUNGER_ITEM)) {
					if (getFoodAmount(world, pos) + 30 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 30, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
				}
				if (!player.isCreative()) {
					stack.shrink(1);
				}
				return InteractionResult.sidedSuccess(world.isClientSide);
			}
			if (hasEggs(currentState)) {
				if (stack.is(PFTags.EGGS_5_HUNGER)) {
					if (getFoodAmount(world, pos) + 5 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 5, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
				}
				if (stack.is(PFTags.EGGS_10_HUNGER)) {
					if (getFoodAmount(world, pos) + 10 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 10, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
				}
				if (stack.is(PFTags.EGGS_15_HUNGER)) {
					if (getFoodAmount(world, pos) + 15 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 15, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
				}
				if (!player.isCreative()) {
					stack.shrink(1);
				}
				return InteractionResult.sidedSuccess(world.isClientSide);
			}
			if (hasFish(currentState)) {
				if (stack.is(PFTags.FISH_2_HUNGER)) {
					if (getFoodAmount(world, pos) + 2 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 2, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
				}
				if (stack.is(PFTags.FISH_4_HUNGER)) {
					if (getFoodAmount(world, pos) + 4 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 4, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
				}
				if (!player.isCreative()) {
					stack.shrink(1);
				}
				return InteractionResult.sidedSuccess(world.isClientSide);
			}
			if (hasShellfish(currentState)) {
				if(stack.is(PFTags.SHELLFISH_3_HUNGER)) {
					if (getFoodAmount(world, pos) + 3 < 156) {
						setFoodAmount(getFoodAmount(world, pos) + 3, world, pos);
					} else {
						setFoodAmount(156, world, pos);
					}
				}
				if (!player.isCreative()) {
					stack.shrink(1);
				}
				return InteractionResult.sidedSuccess(world.isClientSide);
			}
		}
		return InteractionResult.PASS;
	}

	
	@Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, PFBlockEntities.FEEDER.get(), FeederBlockEntity::tick);
    }

	public int getFoodAmount(Level level, BlockPos pos) {
		BlockEntity blockentity = level.getBlockEntity(pos);
		if (blockentity instanceof FeederBlockEntity) {
			return FeederBlockEntity.getFoodAmount();
		}
		else return 0;
	}

	public void setFoodAmount(int amount, Level level, BlockPos pos) {
		BlockEntity blockentity = level.getBlockEntity(pos);
		if (blockentity instanceof FeederBlockEntity) {
			FeederBlockEntity feederblockentity = (FeederBlockEntity)blockentity;
			feederblockentity.setFoodAmount(amount);
		}
	}

	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new FeederBlockEntity(pos, state);
	}

	public boolean hasMeat(BlockState state) {
		return state.getValue(MEAT);
	}

	public boolean hasPlants(BlockState state) {
		return state.getValue(PLANT);
	}

	public boolean hasEggs(BlockState state) {
		return state.getValue(EGG);
	}

	public boolean hasShellfish(BlockState state) {
		return state.getValue(SHELLFISH);
	}

	public boolean hasFish(BlockState state) {
		return state.getValue(FISH);
	}

	public VoxelShape getShape(BlockState p_51973_, BlockGetter p_51974_, BlockPos p_51975_, CollisionContext p_51976_) {
		return SHAPES[p_51973_.getValue(FOOD_LEVEL)];
	}

	public VoxelShape getInteractionShape(BlockState p_51969_, BlockGetter p_51970_, BlockPos p_51971_) {
		return OUTER_SHAPE;
	}

	public VoxelShape getCollisionShape(BlockState p_51990_, BlockGetter p_51991_, BlockPos p_51992_, CollisionContext p_51993_) {
		return SHAPES[0];
	}

}
