package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.block.PaleoscribeBlockEntity;
import superlord.prehistoricfauna.init.PFItems;

public class PaleoscribeBlock extends BaseEntityBlock {

	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty HAS_PALEOPEDIA = BlockStateProperties.HAS_BOOK;
	public static final VoxelShape BASE_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
	public static final VoxelShape POST_SHAPE = Block.box(4.0D, 2.0D, 4.0D, 12.0D, 14.0D, 12.0D);
	public static final VoxelShape COMMON_SHAPE = Shapes.or(BASE_SHAPE, POST_SHAPE);
	public static final VoxelShape TOP_PLATE_SHAPE = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 15.0D, 16.0D);
	public static final VoxelShape COLLISION_SHAPE = Shapes.or(COMMON_SHAPE, TOP_PLATE_SHAPE);
	public static final VoxelShape WEST_SHAPE = Shapes.or(Block.box(1.0D, 10.0D, 0.0D, 5.333333D, 14.0D, 16.0D), Block.box(5.333333D, 12.0D, 0.0D, 9.666667D, 16.0D, 16.0D), Block.box(9.666667D, 14.0D, 0.0D, 14.0D, 18.0D, 16.0D), COMMON_SHAPE);
	public static final VoxelShape NORTH_SHAPE = Shapes.or(Block.box(0.0D, 10.0D, 1.0D, 16.0D, 14.0D, 5.333333D), Block.box(0.0D, 12.0D, 5.333333D, 16.0D, 16.0D, 9.666667D), Block.box(0.0D, 14.0D, 9.666667D, 16.0D, 18.0D, 14.0D), COMMON_SHAPE);
	public static final VoxelShape EAST_SHAPE = Shapes.or(Block.box(15.0D, 10.0D, 0.0D, 10.666667D, 14.0D, 16.0D), Block.box(10.666667D, 12.0D, 0.0D, 6.333333D, 16.0D, 16.0D), Block.box(6.333333D, 14.0D, 0.0D, 2.0D, 18.0D, 16.0D), COMMON_SHAPE);
	public static final VoxelShape SOUTH_SHAPE = Shapes.or(Block.box(0.0D, 10.0D, 15.0D, 16.0D, 14.0D, 10.666667D), Block.box(0.0D, 12.0D, 10.666667D, 16.0D, 16.0D, 6.333333D), Block.box(0.0D, 14.0D, 6.333333D, 16.0D, 18.0D, 2.0D), COMMON_SHAPE);

	public PaleoscribeBlock(Block.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HAS_PALEOPEDIA, false));
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		switch((Direction)state.getValue(FACING)) {
		case NORTH:
			return NORTH_SHAPE;
		case SOUTH:
			return SOUTH_SHAPE;
		case EAST:
			return EAST_SHAPE;
		case WEST:
			return WEST_SHAPE;
		default:
			return COMMON_SHAPE;
		}
	}

	public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return COLLISION_SHAPE;
	}

	public VoxelShape getRenderShape(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return COMMON_SHAPE;
	}

	@SuppressWarnings("deprecation")
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if(tileentity instanceof PaleoscribeBlockEntity) {
			Containers.dropContents(world, pos, (PaleoscribeBlockEntity)tileentity);
			world.updateNeighbourForOutputSignal(pos, this);
		}
		super.onRemove(state, world, pos, newState, isMoving);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	public boolean canPlaceBlockAt(Level world, BlockPos pos) {
		BlockState state = world.getBlockState(pos.below());
		return state.isFaceSturdy(world, pos, Direction.UP);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, HAS_PALEOPEDIA);
	}

	public RenderShape getRenderShape(BlockState p_51567_) {
	      return RenderShape.MODEL;
	   }

	public static boolean tryPlacePaleopedia(Level worldIn, BlockPos pos, BlockState state, ItemStack stack, int i, Inventory playerInventory) {
		if (!state.getValue(HAS_PALEOPEDIA)) {
			if (!worldIn.isClientSide) {
				placePaleopedia(worldIn, pos, state, stack, i, playerInventory);
			}
			return true;
		} else {
			return false;
		}
	}

	private static void placePaleopedia(Level worldIn, BlockPos pos, BlockState state, ItemStack stack, int i, Inventory playerInventory) {
		BlockEntity tileentity = worldIn.getBlockEntity(pos);
		PaleoscribeContainer container = new PaleoscribeContainer(i, playerInventory);
		if (tileentity instanceof PaleoscribeBlockEntity) {
			if (container.getSlot(0).getStack().getItem() == PFItems.PALEOPEDIA.get()) {
				setHasPaleopedia(worldIn, pos, state, true);
				System.out.println("Has Ancient Journal!");
			}
		}
	}

	public static void setHasPaleopedia(Level worldIn, BlockPos pos, BlockState state, boolean hasBook) {
		worldIn.setBlock(pos, state.setValue(HAS_PALEOPEDIA, Boolean.valueOf(hasBook)), 3);
		System.out.println("Has Ancient Journal!");
	}

	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		if (!player.isShiftKeyDown()) {
			if (worldIn.isClientSide) {
				PrehistoricFauna.PROXY.setReferencedBE(worldIn.getBlockEntity(pos));
			} else {
				MenuProvider inamedcontainerprovider = this.getMenuProvider(state, worldIn, pos);
				if (inamedcontainerprovider != null) {
					player.openMenu(inamedcontainerprovider);
				}
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.SUCCESS;
	}


	@Override
	public BlockEntity newBlockEntity(BlockPos p_153573_, BlockState p_153574_) {
		return new PaleoscribeBlockEntity();
	}

}
