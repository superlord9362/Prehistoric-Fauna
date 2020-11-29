package superlord.prehistoricfauna.world.feature.cretaceous;

import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import superlord.prehistoricfauna.core.world.PHFConfiguredFeatures;
import superlord.prehistoricfauna.world.feature.generator.PrehistoricGiantTreeFeatureConfig;
import superlord.prehistoricfauna.world.feature.generator.PrehistoricHugeTree;

import java.util.Random;

public class MetasequoiaTree extends PrehistoricHugeTree {

	@Override
	protected ConfiguredFeature<PrehistoricGiantTreeFeatureConfig, ?> getHugeTreeFeature(Random p_225547_1_) {
		return PHFConfiguredFeatures.METASEQUOIA_TREE;
	}

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
		return null;
	}
	
}
