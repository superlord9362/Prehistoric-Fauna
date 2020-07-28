/**
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

public class CypressTree extends PrehistoricHugeTree {
	
	public final static BlockState CYPRESS_LOG = BlockInit.CYPRESS_LOG.getDefaultState();
	public final static BlockState CYPRESS_LEAVES = BlockInit.CYPRESS_LEAVES.getDefaultState();
	
	public static final PrehistoricGiantTreeFeatureConfig CYPRESS_TREE_CONFIG = (new PrehistoricGiantTreeFeatureConfig.Builder(new SimpleBlockStateProvider(CYPRESS_LOG), new SimpleBlockStateProvider(CYPRESS_LEAVES)).baseHeight(35).heightInterval(5).crownHeight(20)).setSapling((IPlantable)BlockInit.CYPRESS_SAPLING).build();


	@Override
	protected ConfiguredFeature<PrehistoricGiantTreeFeatureConfig, ?> getHugeTreeFeature(Random p_225547_1_) {
		return PrehistoricFeature.CYPRESS_TREE.withConfiguration(CYPRESS_TREE_CONFIG);
	}

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
		return null;
	}

}
*/