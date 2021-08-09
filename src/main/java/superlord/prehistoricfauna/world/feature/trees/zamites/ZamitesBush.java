package superlord.prehistoricfauna.world.feature.trees.zamites;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import superlord.prehistoricfauna.common.world.PFFeatures;
import superlord.prehistoricfauna.init.PFBlocks;

public class ZamitesBush extends Tree {
	
	public static final BlockState ZAMITES_LOG = PFBlocks.ZAMITES_LOG.getDefaultState();
	public static final BlockState ZAMITES_LEAVES = PFBlocks.ZAMITES_LEAVES.getDefaultState();
	
	public static final BaseTreeFeatureConfig ZAMITES_BUSH_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(ZAMITES_LOG), new SimpleBlockStateProvider(ZAMITES_LEAVES), new BlobFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), 1), new StraightTrunkPlacer(5, 1, 0), new TwoLayerFeature(1, 0, 1)).setIgnoreVines()).build();


	@Override
	protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean largeHive) {
		return PFFeatures.ZAMITES_BUSH.withConfiguration(ZAMITES_BUSH_CONFIG);
	}
	
}
