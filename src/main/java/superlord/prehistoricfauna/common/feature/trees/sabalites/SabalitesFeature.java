package superlord.prehistoricfauna.common.feature.trees.sabalites;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import superlord.prehistoricfauna.common.blocks.SabalitesLeafBlock;
import superlord.prehistoricfauna.common.feature.util.JohnstoniaConfig;
import superlord.prehistoricfauna.init.PFBlocks;

public class SabalitesFeature extends Feature<JohnstoniaConfig> {
	
	public SabalitesFeature(Codec<JohnstoniaConfig> codec) {
		super(codec);
	}
	
	public static boolean isAir(LevelSimulatedReader level, BlockPos pos) {
		if (level instanceof BlockGetter) 
			return level.isStateAtPosition(pos, state -> state.isAir());
		return level.isStateAtPosition(pos, BlockState::isAir);
	}
	
	@Override
	public boolean place(FeaturePlaceContext<JohnstoniaConfig> context) {
		BlockPos pos = context.origin();
		Random rand = context.random();
		WorldGenLevel level = context.level();
		int height = rand.nextInt(10) + 1;
		if (level.getBlockState(pos.below()).isSolidRender(level, pos.below())) {
			if (height == 1 && isAir(level, pos) && isAir(level, pos.above())) {
				setBlock(level, pos, PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1));
			}
			if (height == 2 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above().north()) && isAir(level, pos.above().south()) && isAir(level, pos.above().east()) && isAir(level, pos.above().west()) && isAir(level, pos.above().north().east()) && isAir(level, pos.above().north().west()) && isAir(level, pos.above().south().east()) && isAir(level, pos.above().south().west())) {
				setBlock(level, pos, PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(2), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1));
				setBlock(level, pos.above().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST));
				setBlock(level, pos.above().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST));
				setBlock(level, pos.above().south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH));
				setBlock(level, pos.above().north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH));
				setBlock(level, pos.above().south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above().south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above().north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above().north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
			}
			if (height == 3 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above(3)) && isAir(level, pos.above(2).north()) && isAir(level, pos.above(2).south()) && isAir(level, pos.above(2).east()) && isAir(level, pos.above(2).west()) && isAir(level, pos.above(2).north().east()) && isAir(level, pos.above(2).north().west()) && isAir(level, pos.above(2).south().east()) && isAir(level, pos.above(2).south().west())) {
				setBlock(level, pos, PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(2), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(3), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1));
				setBlock(level, pos.above(2).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST));
				setBlock(level, pos.above(2).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST));
				setBlock(level, pos.above(2).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH));
				setBlock(level, pos.above(2).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH));
				setBlock(level, pos.above(2).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(2).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(2).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(2).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
			}
			if (height == 4 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above(3)) && isAir(level, pos.above(4)) && isAir(level, pos.above(3).north()) && isAir(level, pos.above(3).south()) && isAir(level, pos.above(3).east()) && isAir(level, pos.above(3).west()) && isAir(level, pos.above(3).north().east()) && isAir(level, pos.above(3).north().west()) && isAir(level, pos.above(3).south().east()) && isAir(level, pos.above(3).south().west())) {
				setBlock(level, pos, PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(2), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(3), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(4), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1));
				setBlock(level, pos.above(3).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST));
				setBlock(level, pos.above(3).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST));
				setBlock(level, pos.above(3).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH));
				setBlock(level, pos.above(3).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH));
				setBlock(level, pos.above(3).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(3).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(3).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(3).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
			}
			if (height == 5 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above(3)) && isAir(level, pos.above(4)) && isAir(level, pos.above(5)) && isAir(level, pos.above(3).north()) && isAir(level, pos.above(3).south()) && isAir(level, pos.above(3).east()) && isAir(level, pos.above(3).west()) && isAir(level, pos.above(3).north().east()) && isAir(level, pos.above(3).north().west()) && isAir(level, pos.above(3).south().east()) && isAir(level, pos.above(3).south().west()) && isAir(level, pos.above(4).north()) && isAir(level, pos.above(4).south()) && isAir(level, pos.above(4).east()) && isAir(level, pos.above(4).west()) && isAir(level, pos.above(4).north().east()) && isAir(level, pos.above(4).north().west()) && isAir(level, pos.above(4).south().east()) && isAir(level, pos.above(4).south().west())) {
				setBlock(level, pos, PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(2), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(3), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(4), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(5), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1));
				setBlock(level, pos.above(3).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST));
				setBlock(level, pos.above(3).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST));
				setBlock(level, pos.above(3).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH));
				setBlock(level, pos.above(3).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH));
				setBlock(level, pos.above(3).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(3).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(3).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(3).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(4).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST));
				setBlock(level, pos.above(4).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST));
				setBlock(level, pos.above(4).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH));
				setBlock(level, pos.above(4).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH));
				setBlock(level, pos.above(4).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(4).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(4).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(4).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
			}
			if (height == 6 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above(3)) && isAir(level, pos.above(4)) && isAir(level, pos.above(5)) && isAir(level, pos.above(6)) && isAir(level, pos.above(4).north()) && isAir(level, pos.above(4).south()) && isAir(level, pos.above(4).east()) && isAir(level, pos.above(4).west()) && isAir(level, pos.above(4).north().east()) && isAir(level, pos.above(4).north().west()) && isAir(level, pos.above(4).south().east()) && isAir(level, pos.above(4).south().west()) && isAir(level, pos.above(5).north()) && isAir(level, pos.above(5).south()) && isAir(level, pos.above(5).east()) && isAir(level, pos.above(5).west()) && isAir(level, pos.above(5).north().east()) && isAir(level, pos.above(5).north().west()) && isAir(level, pos.above(5).south().east()) && isAir(level, pos.above(5).south().west())) {
				setBlock(level, pos, PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(2), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(3), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(4), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(5), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(6), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1));
				setBlock(level, pos.above(4).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST));
				setBlock(level, pos.above(4).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST));
				setBlock(level, pos.above(4).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH));
				setBlock(level, pos.above(4).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH));
				setBlock(level, pos.above(4).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(4).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(4).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(4).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(5).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST));
				setBlock(level, pos.above(5).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST));
				setBlock(level, pos.above(5).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH));
				setBlock(level, pos.above(5).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH));
				setBlock(level, pos.above(5).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(5).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(5).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(5).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
			}
			if (height == 7 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above(3)) && isAir(level, pos.above(4)) && isAir(level, pos.above(5)) && isAir(level, pos.above(6)) && isAir(level, pos.above(7)) && isAir(level, pos.above(5).north()) && isAir(level, pos.above(5).south()) && isAir(level, pos.above(5).east()) && isAir(level, pos.above(5).west()) && isAir(level, pos.above(5).north().east()) && isAir(level, pos.above(5).north().west()) && isAir(level, pos.above(5).south().east()) && isAir(level, pos.above(5).south().west()) && isAir(level, pos.above(6).north()) && isAir(level, pos.above(6).south()) && isAir(level, pos.above(6).east()) && isAir(level, pos.above(6).west()) && isAir(level, pos.above(6).north().east()) && isAir(level, pos.above(6).north().west()) && isAir(level, pos.above(6).south().east()) && isAir(level, pos.above(6).south().west())) {
				setBlock(level, pos, PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(2), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(3), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(4), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(5), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(6), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(7), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1));
				setBlock(level, pos.above(5).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST));
				setBlock(level, pos.above(5).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST));
				setBlock(level, pos.above(5).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH));
				setBlock(level, pos.above(5).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH));
				setBlock(level, pos.above(5).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(5).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(5).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(5).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(6).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST));
				setBlock(level, pos.above(6).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST));
				setBlock(level, pos.above(6).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH));
				setBlock(level, pos.above(6).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH));
				setBlock(level, pos.above(6).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(6).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(6).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(6).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
			}
			if (height == 8 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above(3)) && isAir(level, pos.above(4)) && isAir(level, pos.above(5)) && isAir(level, pos.above(6)) && isAir(level, pos.above(7)) && isAir(level, pos.above(8)) && isAir(level, pos.above(6).north()) && isAir(level, pos.above(6).south()) && isAir(level, pos.above(6).east()) && isAir(level, pos.above(6).west()) && isAir(level, pos.above(6).north().east()) && isAir(level, pos.above(6).north().west()) && isAir(level, pos.above(6).south().east()) && isAir(level, pos.above(6).south().west()) && isAir(level, pos.above(7).north()) && isAir(level, pos.above(7).south()) && isAir(level, pos.above(7).east()) && isAir(level, pos.above(7).west()) && isAir(level, pos.above(7).north().east()) && isAir(level, pos.above(7).north().west()) && isAir(level, pos.above(7).south().east()) && isAir(level, pos.above(7).south().west())) {
				setBlock(level, pos, PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(2), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(3), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(4), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(5), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(6), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(7), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(8), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1));
				setBlock(level, pos.above(6).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST));
				setBlock(level, pos.above(6).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST));
				setBlock(level, pos.above(6).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH));
				setBlock(level, pos.above(6).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH));
				setBlock(level, pos.above(6).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(6).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(6).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(6).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(7).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST));
				setBlock(level, pos.above(7).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST));
				setBlock(level, pos.above(7).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH));
				setBlock(level, pos.above(7).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH));
				setBlock(level, pos.above(7).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(7).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(7).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(7).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
			}
			if (height == 9 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above(3)) && isAir(level, pos.above(4)) && isAir(level, pos.above(5)) && isAir(level, pos.above(6)) && isAir(level, pos.above(7)) && isAir(level, pos.above(8)) && isAir(level, pos.above(9)) && isAir(level, pos.above(7).north()) && isAir(level, pos.above(7).south()) && isAir(level, pos.above(7).east()) && isAir(level, pos.above(7).west()) && isAir(level, pos.above(7).north().east()) && isAir(level, pos.above(7).north().west()) && isAir(level, pos.above(7).south().east()) && isAir(level, pos.above(7).south().west()) && isAir(level, pos.above(8).north()) && isAir(level, pos.above(8).south()) && isAir(level, pos.above(8).east()) && isAir(level, pos.above(8).west()) && isAir(level, pos.above(8).north().east()) && isAir(level, pos.above(8).north().west()) && isAir(level, pos.above(8).south().east()) && isAir(level, pos.above(8).south().west())) {
				setBlock(level, pos, PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(2), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(3), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(4), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(5), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(6), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(7), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(8), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(9), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1));
				setBlock(level, pos.above(7).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST));
				setBlock(level, pos.above(7).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST));
				setBlock(level, pos.above(7).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH));
				setBlock(level, pos.above(7).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH));
				setBlock(level, pos.above(7).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(7).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(7).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(7).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(8).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST));
				setBlock(level, pos.above(8).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST));
				setBlock(level, pos.above(8).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH));
				setBlock(level, pos.above(8).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH));
				setBlock(level, pos.above(8).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(8).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(8).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(8).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
			}
			if (height == 10 && isAir(level, pos) && isAir(level, pos.above()) && isAir(level, pos.above(2)) && isAir(level, pos.above(3)) && isAir(level, pos.above(4)) && isAir(level, pos.above(5)) && isAir(level, pos.above(6)) && isAir(level, pos.above(7)) && isAir(level, pos.above(8)) && isAir(level, pos.above(9)) && isAir(level, pos.above(10)) && isAir(level, pos.above(8).north()) && isAir(level, pos.above(8).south()) && isAir(level, pos.above(8).east()) && isAir(level, pos.above(8).west()) && isAir(level, pos.above(8).north().east()) && isAir(level, pos.above(8).north().west()) && isAir(level, pos.above(8).south().east()) && isAir(level, pos.above(8).south().west()) && isAir(level, pos.above(9).north()) && isAir(level, pos.above(9).south()) && isAir(level, pos.above(9).east()) && isAir(level, pos.above(9).west()) && isAir(level, pos.above(9).north().east()) && isAir(level, pos.above(9).north().west()) && isAir(level, pos.above(9).south().east()) && isAir(level, pos.above(9).south().west())) {
				setBlock(level, pos, PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(2), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(3), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(4), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(5), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(6), PFBlocks.SABALITES_LOG.get().defaultBlockState());
				setBlock(level, pos.above(7), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(8), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(9), PFBlocks.SABALITES_GRASSY_LOG.get().defaultBlockState());
				setBlock(level, pos.above(10), PFBlocks.SABALITES_TOP_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1));
				setBlock(level, pos.above(8).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST));
				setBlock(level, pos.above(8).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST));
				setBlock(level, pos.above(8).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH));
				setBlock(level, pos.above(8).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH));
				setBlock(level, pos.above(8).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(8).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(8).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(8).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(9).east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST));
				setBlock(level, pos.above(9).west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST));
				setBlock(level, pos.above(9).south(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH));
				setBlock(level, pos.above(9).north(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH));
				setBlock(level, pos.above(9).south().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.SOUTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(9).south().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.WEST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(9).north().west(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.NORTH).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
				setBlock(level, pos.above(9).north().east(), PFBlocks.SABALITES_LEAVES.get().defaultBlockState().setValue(SabalitesLeafBlock.FACING, Direction.EAST).setValue(SabalitesLeafBlock.DIRECTION, SabalitesLeafBlock.LeafDirection.CORNER));
			}
			return true;
		} else {
			return false;
		}
	}

}
