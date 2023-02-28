package superlord.prehistoricfauna.common.blocks;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import superlord.prehistoricfauna.common.entity.block.PaleontologyTableBlockEntity;

public class PaleontologyTableBlock extends BaseEntityBlock {

	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public PaleontologyTableBlock(Properties builder) {
		super(builder);
		this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
	}

	@Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new PaleontologyTableBlockEntity(pos, state);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	   public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		super.setPlacedBy(world, pos, state, placer, stack);
		if(stack.hasCustomHoverName()) {
			BlockEntity tile = world.getBlockEntity(pos);
			if (tile instanceof PaleontologyTableBlockEntity) {
				((PaleontologyTableBlockEntity)tile).setCustomName(stack.getHoverName());
			}
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState state, Level world, BlockPos pos) {
		return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(world.getBlockEntity(pos));
	}

	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (world != null && !world.isClientSide) {
			BlockEntity tile = world.getBlockEntity(pos);
			if(tile instanceof PaleontologyTableBlockEntity) {
				NetworkHooks.openGui((ServerPlayer)player, (MenuProvider)tile, pos);
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.SUCCESS;
	}
	
	@SuppressWarnings("deprecation")
	public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
	      if (!state.is(newState.getBlock())) {
	         BlockEntity tileentity = worldIn.getBlockEntity(pos);
	         if (tileentity instanceof PaleontologyTableBlockEntity) {
	        	 Containers.dropContents(worldIn, pos, ((PaleontologyTableBlockEntity) tileentity).getInventory());
	            worldIn.updateNeighbourForOutputSignal(pos, this);
	         }

	         super.onRemove(state, worldIn, pos, newState, isMoving);
	      }
	   }

}
