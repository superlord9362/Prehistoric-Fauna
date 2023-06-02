package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.init.PFBlocks;

public class ZamitesSaplingBlock extends BushBlock implements BonemealableBlock {
	public static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
	public static final IntegerProperty STAGE = BlockStateProperties.AGE_1;

	public ZamitesSaplingBlock(Block.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, Integer.valueOf(0)));
	}

	public VoxelShape getShape(BlockState p_56008_, BlockGetter p_56009_, BlockPos p_56010_, CollisionContext p_56011_) {
		return SHAPE;
	}

	@SuppressWarnings("deprecation")
	public void randomTick(BlockState p_56003_, ServerLevel p_56004_, BlockPos p_56005_, Random p_56006_) {
		if (p_56004_.getMaxLocalRawBrightness(p_56005_.above()) >= 9 && p_56006_.nextInt(7) == 0) {
			if (!p_56004_.isAreaLoaded(p_56005_, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
			this.advanceTree(p_56004_, p_56005_, p_56003_, p_56006_);
		}

	}
	
	public static boolean isAir(LevelSimulatedReader worldgenlevel, BlockPos pos) {
		if (worldgenlevel instanceof BlockGetter) // FORGE: Redirect to state method when possible
			return worldgenlevel.isStateAtPosition(pos, state -> state.isAir());
		return worldgenlevel.isStateAtPosition(pos, BlockState::isAir);
	}

	public void advanceTree(ServerLevel level, BlockPos pos, BlockState p_55983_, Random p_55984_) {
		if (p_55983_.getValue(STAGE) == 0) {
			level.setBlock(pos, p_55983_.cycle(STAGE), 4);
		} else {
			Random rand = new Random();
			int height = rand.nextInt(3) + 2;
			int frondsChance = rand.nextInt(2);
			int secondFrondsChance = rand.nextInt(2);
			int secondFrondsHeight = rand.nextInt(3) + 1;
			int secondFrondsDirection = rand.nextInt(4);
			int frondsHeight = rand.nextInt(3) + 1;
			int frondsDirection = rand.nextInt(4);
			int x = pos.getX();
			int z = pos.getZ();
			for (int i = pos.getY(); i <= pos.getY() + height; i++) {
				level.setBlock(new BlockPos(x, i, z), PFBlocks.ZAMITES_LOG.get().defaultBlockState(), 2);
				if (frondsChance == 0) {
					if (frondsDirection == 0) {
						if (isAir(level, new BlockPos(x + 1, pos.getY() + frondsHeight, z))) level.setBlock(new BlockPos(x + 1, pos.getY() + frondsHeight, z), PFBlocks.ZAMITES_FROND.get().defaultBlockState().setValue(ZamitesFrondsBlock.FACING, Direction.WEST), 2);
					}
					if (frondsDirection == 1) {
						if (isAir(level, new BlockPos(x + 0, pos.getY() + frondsHeight, z + 1))) level.setBlock(new BlockPos(x + 0, pos.getY() + frondsHeight, z + 1), PFBlocks.ZAMITES_FROND.get().defaultBlockState().setValue(ZamitesFrondsBlock.FACING, Direction.NORTH), 2);
					}
					if (frondsDirection == 2) {
						if (isAir(level, new BlockPos(x + 0, pos.getY() + frondsHeight, z - 1))) level.setBlock(new BlockPos(x + 0, pos.getY() + frondsHeight, z - 1), PFBlocks.ZAMITES_FROND.get().defaultBlockState().setValue(ZamitesFrondsBlock.FACING, Direction.SOUTH), 2);
					}
					if (frondsDirection == 3) {
						if (isAir(level, new BlockPos(x - 1, pos.getY() + frondsHeight, z - 0))) level.setBlock(new BlockPos(x - 1, pos.getY() + frondsHeight, z - 0), PFBlocks.ZAMITES_FROND.get().defaultBlockState().setValue(ZamitesFrondsBlock.FACING, Direction.EAST), 2);
					}
				}
				if (secondFrondsChance == 2) {
					if (secondFrondsDirection == 0) {
						if (isAir(level, new BlockPos(x + 1, pos.getY() + secondFrondsHeight, z))) level.setBlock(new BlockPos(x + 1, pos.getY() + secondFrondsHeight, z), PFBlocks.ZAMITES_FROND.get().defaultBlockState().setValue(ZamitesFrondsBlock.FACING, Direction.WEST), 2);
					}
					if (secondFrondsDirection == 1) {
						if (isAir(level, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z + 1))) level.setBlock(new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z + 1), PFBlocks.ZAMITES_FROND.get().defaultBlockState().setValue(ZamitesFrondsBlock.FACING, Direction.NORTH), 2);
					}
					if (secondFrondsDirection == 2) {
						if (isAir(level, new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z - 1))) level.setBlock(new BlockPos(x + 0, pos.getY() + secondFrondsHeight, z - 1), PFBlocks.ZAMITES_FROND.get().defaultBlockState().setValue(ZamitesFrondsBlock.FACING, Direction.SOUTH), 2);
					}
					if (secondFrondsDirection == 3) {
						if (isAir(level, new BlockPos(x - 1, pos.getY() + secondFrondsHeight, z - 0))) level.setBlock(new BlockPos(x - 1, pos.getY() + secondFrondsHeight, z - 0), PFBlocks.ZAMITES_FROND.get().defaultBlockState().setValue(ZamitesFrondsBlock.FACING, Direction.EAST), 2);
					}
				}
				if (isAir(level, new BlockPos(x, pos.getY() + height + 1, z))) level.setBlock(new BlockPos(x, pos.getY() + height + 1, z), PFBlocks.ZAMITES_LEAVES.get().defaultBlockState(), 2);
			}
			}

	}

	public boolean isValidBonemealTarget(BlockGetter p_55991_, BlockPos p_55992_, BlockState p_55993_, boolean p_55994_) {
		return true;
	}

	public boolean isBonemealSuccess(Level p_55996_, Random p_55997_, BlockPos p_55998_, BlockState p_55999_) {
		return (double)p_55996_.random.nextFloat() < 0.45D;
	}

	public void performBonemeal(ServerLevel p_55986_, Random p_55987_, BlockPos p_55988_, BlockState p_55989_) {
		this.advanceTree(p_55986_, p_55988_, p_55989_, p_55987_);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_56001_) {
		p_56001_.add(STAGE);
	}

}
