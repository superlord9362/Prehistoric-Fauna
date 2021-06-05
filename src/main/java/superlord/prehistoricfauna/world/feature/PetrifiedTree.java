package superlord.prehistoricfauna.world.feature;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import superlord.prehistoricfauna.init.BlockInit;

import java.util.Random;

public class PetrifiedTree extends Tree {

	public final static BlockState PETRIFIED_WOOD = BlockInit.PETRIFIED_WOOD.getDefaultState();
	public final static BlockState AIR = Blocks.AIR.getDefaultState();
	
	public static final TreeFeatureConfig PETRIFIED_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(PETRIFIED_WOOD), new SimpleBlockStateProvider(AIR), new SpruceFoliagePlacer(2, 1)).baseHeight(2).heightRandA(3).trunkHeight(4).trunkHeightRandom(1).trunkTopOffset(1).ignoreVines()).build();

	
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
		return Feature.NORMAL_TREE.withConfiguration(PETRIFIED_TREE_CONFIG);
	}

}
