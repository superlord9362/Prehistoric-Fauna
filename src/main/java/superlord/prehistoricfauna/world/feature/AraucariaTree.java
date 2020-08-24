package superlord.prehistoricfauna.world.feature;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraftforge.common.IPlantable;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.world.PrehistoricFeature;
import superlord.prehistoricfauna.world.feature.generator.PrehistoricGiantTreeFeatureConfig;
import superlord.prehistoricfauna.world.feature.generator.PrehistoricHugeTree;

public class AraucariaTree extends PrehistoricHugeTree {
	
	public final static BlockState ARAUCARIA_LOG = BlockInit.ARAUCARIA_LOG.getDefaultState();
	public final static BlockState ARAUCARIA_LEAVES = BlockInit.ARAUCARIA_LEAVES.getDefaultState();
	
	public static final PrehistoricGiantTreeFeatureConfig ARAUCARIA_TREE_CONFIG = (new PrehistoricGiantTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ARAUCARIA_LOG), new SimpleBlockStateProvider(ARAUCARIA_LEAVES)).baseHeight(35).heightInterval(5).crownHeight(20)).setSapling((IPlantable)BlockInit.ARAUCARIA_SAPLING).build();
	public static final TreeFeatureConfig ARAUCARIA_YOUNG_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ARAUCARIA_LOG), new SimpleBlockStateProvider(ARAUCARIA_LEAVES), new SpruceFoliagePlacer(2, 1)).baseHeight(10).heightRandA(2).trunkHeight(1).trunkHeightRandom(2).trunkTopOffset(2).ignoreVines()).setSapling((IPlantable)BlockInit.ARAUCARIA_SAPLING).build();

	@Override
	protected ConfiguredFeature<PrehistoricGiantTreeFeatureConfig, ?> getHugeTreeFeature(Random p_225547_1_) {
		return PrehistoricFeature.ARAUCARIA_TREE.withConfiguration(ARAUCARIA_TREE_CONFIG);
	}

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
		return Feature.NORMAL_TREE.withConfiguration(ARAUCARIA_YOUNG_TREE_CONFIG);
	}

}
