package superlord.prehistoricfauna.world.feature.triassic;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import superlord.prehistoricfauna.core.world.PHFConfiguredFeatures;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.world.feature.generator.PrehistoricGiantTreeFeatureConfig;
import superlord.prehistoricfauna.world.feature.generator.PrehistoricHugeTree;

import java.util.Random;

public class ProtojuniperTree extends PrehistoricHugeTree {
	
	public final static BlockState PROTOJUNIPER_LOG = BlockInit.PROTOJUNIPER_LOG.getDefaultState();
	public final static BlockState PROTOJUNIPER_LEAVES = BlockInit.PROTOJUNIPER_LEAVES.getDefaultState();

	@Override
	protected ConfiguredFeature<PrehistoricGiantTreeFeatureConfig, ?> getHugeTreeFeature(Random rand) {
		return PHFConfiguredFeatures.PROTO_JUNIPER_TREE;
	}

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
		return null;
	}
	
}
