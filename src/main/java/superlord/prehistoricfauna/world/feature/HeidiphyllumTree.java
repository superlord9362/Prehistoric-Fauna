package superlord.prehistoricfauna.world.feature;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraftforge.common.IPlantable;
import superlord.prehistoricfauna.init.BlockInit;

public class HeidiphyllumTree extends Tree {
	
	public final static BlockState HEIDIPHYLLUM_LOG = BlockInit.HEIDIPHYLLUM_LOG.getDefaultState();
	public final static BlockState HEIDIPHYLLUM_LEAVES = BlockInit.HEIDIPHYLLUM_LEAVES.getDefaultState();
	
	public static final TreeFeatureConfig HEIDIPHYLLUM_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(HEIDIPHYLLUM_LOG), new SimpleBlockStateProvider(HEIDIPHYLLUM_LEAVES), new SpruceFoliagePlacer(2, 1)).baseHeight(13).heightRandA(2).trunkHeight(1).trunkHeightRandom(2).trunkTopOffset(2).ignoreVines()).setSapling((IPlantable)BlockInit.HEIDIPHYLLUM_SAPLING).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
		return Feature.NORMAL_TREE.withConfiguration(HEIDIPHYLLUM_TREE_CONFIG);
	}
	
}
