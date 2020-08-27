package superlord.prehistoricfauna.world.feature;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraftforge.common.IPlantable;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.world.PrehistoricFeature;
import superlord.prehistoricfauna.world.feature.generator.PrehistoricGiantTreeFeatureConfig;
import superlord.prehistoricfauna.world.feature.generator.PrehistoricHugeTree;

public class ProtojuniperTree extends PrehistoricHugeTree {
	
	public final static BlockState PROTOJUNIPER_LOG = BlockInit.PROTOJUNIPER_LOG.getDefaultState();
	public final static BlockState PROTOJUNIPER_LEAVES = BlockInit.PROTOJUNIPER_LEAVES.getDefaultState();

	public static final PrehistoricGiantTreeFeatureConfig PROTOJUNIPER_TREE_CONFIG = (new PrehistoricGiantTreeFeatureConfig.Builder(new SimpleBlockStateProvider(PROTOJUNIPER_LOG), new SimpleBlockStateProvider(PROTOJUNIPER_LEAVES)).baseHeight(38).heightInterval(2).crownHeight(30)).setSapling((IPlantable)BlockInit.PROTOJUNIPER_SAPLING).build();

	@Override
	protected ConfiguredFeature<PrehistoricGiantTreeFeatureConfig, ?> getHugeTreeFeature(Random p_225547_1_) {
		return PrehistoricFeature.PROTOJUNIPER_TREE.withConfiguration(PROTOJUNIPER_TREE_CONFIG);
	}

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
		return null;
	}
	
}
