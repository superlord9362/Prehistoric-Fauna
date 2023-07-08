package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.common.util.trees.TreeSpawner;
import superlord.prehistoricfauna.init.PFBlocks;

public class PFSaplingBlock extends BushBlock implements BonemealableBlock {
	public static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
	public static final IntegerProperty STAGE = BlockStateProperties.AGE_1;
	private final TreeSpawner tree;

	public PFSaplingBlock(TreeSpawner tree, Block.Properties properties) {
		super(properties);
		this.tree = tree;
		this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, Integer.valueOf(0)));
	}
	
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
	      Block block = state.getBlock();
	      return super.canSurvive(state, worldIn, pos) || block == PFBlocks.HARDENED_SILT.get() || block == PFBlocks.SILT.get() || block == Blocks.SAND;
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

	public void advanceTree(ServerLevel p_55981_, BlockPos p_55982_, BlockState p_55983_, Random p_55984_) {
		if (p_55983_.getValue(STAGE) == 0) {
			p_55981_.setBlock(p_55982_, p_55983_.cycle(STAGE), 4);
		} else {
			this.tree.spawn(p_55981_, p_55981_.getChunkSource().getGenerator(), p_55982_, p_55983_, p_55984_);
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
