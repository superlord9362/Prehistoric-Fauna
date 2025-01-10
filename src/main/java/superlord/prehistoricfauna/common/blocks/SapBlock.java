package superlord.prehistoricfauna.common.blocks;

import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.init.PFItems;

public class SapBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	private static final Map<Direction, VoxelShape> AABBS = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.box(0D, 0D, 0D, 16D, 16D, 1.0D), Direction.SOUTH, Block.box(0D, 0D, 15.0D, 16D, 16.0D, 16.0D), Direction.WEST, Block.box(0.0D, 0.0D, 0D, 1.0D, 16.0D, 16D), Direction.EAST, Block.box(15.0D, 0.0D, 0D, 16.0D, 16.0D, 16D)));

	public SapBlock(BlockBehaviour.Properties p_58123_) {
		super(p_58123_);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	public VoxelShape getShape(BlockState p_58152_, BlockGetter p_58153_, BlockPos p_58154_, CollisionContext p_58155_) {
		return getShape(p_58152_);
	}

	public static VoxelShape getShape(BlockState p_58157_) {
		return AABBS.get(p_58157_.getValue(FACING));
	}

	public boolean canSurvive(BlockState p_58133_, LevelReader p_58134_, BlockPos p_58135_) {
		Direction direction = p_58133_.getValue(FACING);
		BlockPos blockpos = p_58135_.relative(direction.getOpposite());
		BlockState blockstate = p_58134_.getBlockState(blockpos);
		return blockstate.isFaceSturdy(p_58134_, blockpos, direction);
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext p_58126_) {
		BlockState blockstate = this.defaultBlockState();
		LevelReader levelreader = p_58126_.getLevel();
		BlockPos blockpos = p_58126_.getClickedPos();
		Direction[] adirection = p_58126_.getNearestLookingDirections();

		for(Direction direction : adirection) {
			if (direction.getAxis().isHorizontal()) {
				Direction direction1 = direction.getOpposite();
				blockstate = blockstate.setValue(FACING, direction1);
				if (blockstate.canSurvive(levelreader, blockpos)) {
					return blockstate;
				}
			}
		}

		return null;
	}
	
	public boolean isRandomlyTicking(BlockState p_51696_) {
		return true;
	}
	
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		int grow = random.nextInt(4);
		if (grow == 0) {
			world.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
		}
	}

	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult p_51093_) {
		ItemStack stack = player.getItemInHand(hand);
		if (stack.is(Items.GLASS_BOTTLE)) {
			if (!player.isCreative()) {
				stack.shrink(1);
			}
			player.addItem(new ItemStack(PFItems.BOTTLED_SAP.get()));
			level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
			return InteractionResult.sidedSuccess(level.isClientSide());
		}
		return InteractionResult.PASS;
	}

	public BlockState updateShape(BlockState p_58143_, Direction p_58144_, BlockState p_58145_, LevelAccessor p_58146_, BlockPos p_58147_, BlockPos p_58148_) {
		return p_58144_.getOpposite() == p_58143_.getValue(FACING) && !p_58143_.canSurvive(p_58146_, p_58147_) ? Blocks.AIR.defaultBlockState() : p_58143_;
	}

	public BlockState rotate(BlockState p_58140_, Rotation p_58141_) {
		return p_58140_.setValue(FACING, p_58141_.rotate(p_58140_.getValue(FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState p_58137_, Mirror p_58138_) {
		return p_58137_.rotate(p_58138_.getRotation(p_58137_.getValue(FACING)));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_58150_) {
		p_58150_.add(FACING);
	}

}
