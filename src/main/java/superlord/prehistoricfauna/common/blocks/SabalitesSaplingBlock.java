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
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.init.PFBlocks;

public class SabalitesSaplingBlock extends BushBlock implements BonemealableBlock {
	public static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
	public static final IntegerProperty STAGE = BlockStateProperties.AGE_1;

	public SabalitesSaplingBlock(Block.Properties properties) {
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

	public void advanceTree(ServerLevel level, BlockPos pos, BlockState p_55983_, Random rand) {
		if (p_55983_.getValue(STAGE) == 0) {
			level.setBlock(pos, p_55983_.cycle(STAGE), 4);
		} else {
			int height = rand.nextInt(10) + 1;
			if (level.getBlockState(pos.below()).isSolidRender(level, pos.below())) {
				if (height == 1 && isAir(level, pos) && isAir(level, pos.above())) {
					level.setBlock(pos, PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
				}
				if (height == 2 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above().north()) && isAir(level, pos.above().south()) && isAir(level, pos.above().east()) && isAir(level, pos.above().west()) && isAir(level, pos.above().north().east()) && isAir(level, pos.above().north().west()) && isAir(level, pos.above().south().east()) && isAir(level, pos.above().south().west())) {
					level.setBlock(pos, PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(2), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
					level.setBlock(pos.above().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST), 2);
					level.setBlock(pos.above().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST), 2);
					level.setBlock(pos.above().south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH), 2);
					level.setBlock(pos.above().north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH), 2);
					level.setBlock(pos.above().south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above().south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above().north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above().north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
				}
				if (height == 3 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above(3)) && isAir(level, pos.above(2).north()) && isAir(level, pos.above(2).south()) && isAir(level, pos.above(2).east()) && isAir(level, pos.above(2).west()) && isAir(level, pos.above(2).north().east()) && isAir(level, pos.above(2).north().west()) && isAir(level, pos.above(2).south().east()) && isAir(level, pos.above(2).south().west())) {
					level.setBlock(pos, PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(2), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(3), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
					level.setBlock(pos.above(2).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST), 2);
					level.setBlock(pos.above(2).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST), 2);
					level.setBlock(pos.above(2).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH), 2);
					level.setBlock(pos.above(2).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH), 2);
					level.setBlock(pos.above(2).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(2).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(2).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(2).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
				}
				if (height == 4 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above(3)) && isAir(level, pos.above(4)) && isAir(level, pos.above(3).north()) && isAir(level, pos.above(3).south()) && isAir(level, pos.above(3).east()) && isAir(level, pos.above(3).west()) && isAir(level, pos.above(3).north().east()) && isAir(level, pos.above(3).north().west()) && isAir(level, pos.above(3).south().east()) && isAir(level, pos.above(3).south().west())) {
					level.setBlock(pos, PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(2), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(3), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(4), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
					level.setBlock(pos.above(3).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST), 2);
					level.setBlock(pos.above(3).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST), 2);
					level.setBlock(pos.above(3).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH), 2);
					level.setBlock(pos.above(3).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH), 2);
					level.setBlock(pos.above(3).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(3).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(3).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(3).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
				}
				if (height == 5 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above(3)) && isAir(level, pos.above(4)) && isAir(level, pos.above(5)) && isAir(level, pos.above(3).north()) && isAir(level, pos.above(3).south()) && isAir(level, pos.above(3).east()) && isAir(level, pos.above(3).west()) && isAir(level, pos.above(3).north().east()) && isAir(level, pos.above(3).north().west()) && isAir(level, pos.above(3).south().east()) && isAir(level, pos.above(3).south().west()) && isAir(level, pos.above(4).north()) && isAir(level, pos.above(4).south()) && isAir(level, pos.above(4).east()) && isAir(level, pos.above(4).west()) && isAir(level, pos.above(4).north().east()) && isAir(level, pos.above(4).north().west()) && isAir(level, pos.above(4).south().east()) && isAir(level, pos.above(4).south().west())) {
					level.setBlock(pos, PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(2), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(3), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(4), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(5), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
					level.setBlock(pos.above(3).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST), 2);
					level.setBlock(pos.above(3).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST), 2);
					level.setBlock(pos.above(3).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH), 2);
					level.setBlock(pos.above(3).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH), 2);
					level.setBlock(pos.above(3).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(3).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(3).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(3).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(4).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST), 2);
					level.setBlock(pos.above(4).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST), 2);
					level.setBlock(pos.above(4).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH), 2);
					level.setBlock(pos.above(4).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH), 2);
					level.setBlock(pos.above(4).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(4).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(4).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(4).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
				}
				if (height == 6 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above(3)) && isAir(level, pos.above(4)) && isAir(level, pos.above(5)) && isAir(level, pos.above(6)) && isAir(level, pos.above(4).north()) && isAir(level, pos.above(4).south()) && isAir(level, pos.above(4).east()) && isAir(level, pos.above(4).west()) && isAir(level, pos.above(4).north().east()) && isAir(level, pos.above(4).north().west()) && isAir(level, pos.above(4).south().east()) && isAir(level, pos.above(4).south().west()) && isAir(level, pos.above(5).north()) && isAir(level, pos.above(5).south()) && isAir(level, pos.above(5).east()) && isAir(level, pos.above(5).west()) && isAir(level, pos.above(5).north().east()) && isAir(level, pos.above(5).north().west()) && isAir(level, pos.above(5).south().east()) && isAir(level, pos.above(5).south().west())) {
					level.setBlock(pos, PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(2), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(3), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(4), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(5), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(6), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
					level.setBlock(pos.above(4).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST), 2);
					level.setBlock(pos.above(4).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST), 2);
					level.setBlock(pos.above(4).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH), 2);
					level.setBlock(pos.above(4).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH), 2);
					level.setBlock(pos.above(4).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(4).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(4).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(4).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(5).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST), 2);
					level.setBlock(pos.above(5).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST), 2);
					level.setBlock(pos.above(5).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH), 2);
					level.setBlock(pos.above(5).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH), 2);
					level.setBlock(pos.above(5).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(5).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(5).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(5).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
				}
				if (height == 7 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above(3)) && isAir(level, pos.above(4)) && isAir(level, pos.above(5)) && isAir(level, pos.above(6)) && isAir(level, pos.above(7)) && isAir(level, pos.above(5).north()) && isAir(level, pos.above(5).south()) && isAir(level, pos.above(5).east()) && isAir(level, pos.above(5).west()) && isAir(level, pos.above(5).north().east()) && isAir(level, pos.above(5).north().west()) && isAir(level, pos.above(5).south().east()) && isAir(level, pos.above(5).south().west()) && isAir(level, pos.above(6).north()) && isAir(level, pos.above(6).south()) && isAir(level, pos.above(6).east()) && isAir(level, pos.above(6).west()) && isAir(level, pos.above(6).north().east()) && isAir(level, pos.above(6).north().west()) && isAir(level, pos.above(6).south().east()) && isAir(level, pos.above(6).south().west())) {
					level.setBlock(pos, PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(2), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(3), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(4), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(5), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(6), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(7), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
					level.setBlock(pos.above(5).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST), 2);
					level.setBlock(pos.above(5).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST), 2);
					level.setBlock(pos.above(5).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH), 2);
					level.setBlock(pos.above(5).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH), 2);
					level.setBlock(pos.above(5).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(5).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(5).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(5).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(6).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST), 2);
					level.setBlock(pos.above(6).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST), 2);
					level.setBlock(pos.above(6).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH), 2);
					level.setBlock(pos.above(6).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH), 2);
					level.setBlock(pos.above(6).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(6).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(6).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(6).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
				}
				if (height == 8 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above(3)) && isAir(level, pos.above(4)) && isAir(level, pos.above(5)) && isAir(level, pos.above(6)) && isAir(level, pos.above(7)) && isAir(level, pos.above(8)) && isAir(level, pos.above(6).north()) && isAir(level, pos.above(6).south()) && isAir(level, pos.above(6).east()) && isAir(level, pos.above(6).west()) && isAir(level, pos.above(6).north().east()) && isAir(level, pos.above(6).north().west()) && isAir(level, pos.above(6).south().east()) && isAir(level, pos.above(6).south().west()) && isAir(level, pos.above(7).north()) && isAir(level, pos.above(7).south()) && isAir(level, pos.above(7).east()) && isAir(level, pos.above(7).west()) && isAir(level, pos.above(7).north().east()) && isAir(level, pos.above(7).north().west()) && isAir(level, pos.above(7).south().east()) && isAir(level, pos.above(7).south().west())) {
					level.setBlock(pos, PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(2), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(3), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(4), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(5), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(6), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(7), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(8), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
					level.setBlock(pos.above(6).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST), 2);
					level.setBlock(pos.above(6).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST), 2);
					level.setBlock(pos.above(6).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH), 2);
					level.setBlock(pos.above(6).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH), 2);
					level.setBlock(pos.above(6).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(6).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(6).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(6).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(7).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST), 2);
					level.setBlock(pos.above(7).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST), 2);
					level.setBlock(pos.above(7).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH), 2);
					level.setBlock(pos.above(7).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH), 2);
					level.setBlock(pos.above(7).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(7).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(7).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(7).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
				}
				if (height == 9 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above(3)) && isAir(level, pos.above(4)) && isAir(level, pos.above(5)) && isAir(level, pos.above(6)) && isAir(level, pos.above(7)) && isAir(level, pos.above(8)) && isAir(level, pos.above(9)) && isAir(level, pos.above(7).north()) && isAir(level, pos.above(7).south()) && isAir(level, pos.above(7).east()) && isAir(level, pos.above(7).west()) && isAir(level, pos.above(7).north().east()) && isAir(level, pos.above(7).north().west()) && isAir(level, pos.above(7).south().east()) && isAir(level, pos.above(7).south().west()) && isAir(level, pos.above(8).north()) && isAir(level, pos.above(8).south()) && isAir(level, pos.above(8).east()) && isAir(level, pos.above(8).west()) && isAir(level, pos.above(8).north().east()) && isAir(level, pos.above(8).north().west()) && isAir(level, pos.above(8).south().east()) && isAir(level, pos.above(8).south().west())) {
					level.setBlock(pos, PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(2), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(3), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(4), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(5), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(6), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(7), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(8), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(9), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
					level.setBlock(pos.above(7).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST), 2);
					level.setBlock(pos.above(7).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST), 2);
					level.setBlock(pos.above(7).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH), 2);
					level.setBlock(pos.above(7).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH), 2);
					level.setBlock(pos.above(7).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(7).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(7).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(7).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(8).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST), 2);
					level.setBlock(pos.above(8).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST), 2);
					level.setBlock(pos.above(8).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH), 2);
					level.setBlock(pos.above(8).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH), 2);
					level.setBlock(pos.above(8).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(8).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(8).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(8).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
				}
				if (height == 10 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above(3)) && isAir(level, pos.above(4)) && isAir(level, pos.above(5)) && isAir(level, pos.above(6)) && isAir(level, pos.above(7)) && isAir(level, pos.above(8)) && isAir(level, pos.above(9)) && isAir(level, pos.above(10)) && isAir(level, pos.above(8).north()) && isAir(level, pos.above(8).south()) && isAir(level, pos.above(8).east()) && isAir(level, pos.above(8).west()) && isAir(level, pos.above(8).north().east()) && isAir(level, pos.above(8).north().west()) && isAir(level, pos.above(8).south().east()) && isAir(level, pos.above(8).south().west()) && isAir(level, pos.above(9).north()) && isAir(level, pos.above(9).south()) && isAir(level, pos.above(9).east()) && isAir(level, pos.above(9).west()) && isAir(level, pos.above(9).north().east()) && isAir(level, pos.above(9).north().west()) && isAir(level, pos.above(9).south().east()) && isAir(level, pos.above(9).south().west())) {
					level.setBlock(pos, PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(2), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(3), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(4), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(5), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(6), PFBlocks.SABALITES_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(7), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(8), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(9), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState(), 2);
					level.setBlock(pos.above(10), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
					level.setBlock(pos.above(8).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST), 2);
					level.setBlock(pos.above(8).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST), 2);
					level.setBlock(pos.above(8).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH), 2);
					level.setBlock(pos.above(8).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH), 2);
					level.setBlock(pos.above(8).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(8).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(8).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(8).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(9).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST), 2);
					level.setBlock(pos.above(9).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST), 2);
					level.setBlock(pos.above(9).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH), 2);
					level.setBlock(pos.above(9).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH), 2);
					level.setBlock(pos.above(9).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(9).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(9).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
					level.setBlock(pos.above(9).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER), 2);
				}
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
