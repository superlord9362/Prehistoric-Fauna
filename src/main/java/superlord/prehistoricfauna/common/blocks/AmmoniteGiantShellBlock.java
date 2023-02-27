package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class AmmoniteGiantShellBlock extends Block {
	
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public AmmoniteGiantShellBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}
	
	public static Direction getDirection(BlockState state) {
		Direction direction = state.getValue(FACING);
		return direction;
	}
	
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Direction direction = context.getHorizontalDirection().getOpposite();
		return this.defaultBlockState().setValue(FACING, direction);
	}
	
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

}
