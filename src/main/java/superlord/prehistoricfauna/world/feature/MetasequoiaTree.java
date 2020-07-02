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

public class MetasequoiaTree extends PrehistoricHugeTree {

	public final static BlockState METASEQUOIA_LOG = BlockInit.METASEQUOIA_LOG.getDefaultState();
	public final static BlockState METASEQUOIA_LEAVES = BlockInit.METASEQUOIA_LEAVES.getDefaultState();
	
	public static final PrehistoricGiantTreeFeatureConfig METASEQUOIA_TREE_CONFIG = (new PrehistoricGiantTreeFeatureConfig.Builder(new SimpleBlockStateProvider(METASEQUOIA_LOG), new SimpleBlockStateProvider(METASEQUOIA_LEAVES)).baseHeight(43).heightInterval(2).crownHeight(38)).setSapling((IPlantable)BlockInit.METASEQUOIA_SAPLING).build();

	@Override
	   protected ConfiguredFeature<PrehistoricGiantTreeFeatureConfig, ?> getHugeTreeFeature(Random p_225547_1_) {
	      return PrehistoricFeature.METASEQUOIA_TREE.withConfiguration(METASEQUOIA_TREE_CONFIG);
	   }

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
		return null;
	}
	
	
}
