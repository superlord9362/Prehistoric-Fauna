package superlord.prehistoricfauna.world.feature.jurassic;

import net.minecraft.block.BlockState;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;
import superlord.prehistoricfauna.core.world.PHFFeatures;
import superlord.prehistoricfauna.init.BlockInit;

import java.util.Random;

public class ZamitesBush extends Tree {
	
	public static final BlockState ZAMITES_LOG = BlockInit.ZAMITES_LOG.get().getDefaultState();
	public static final BlockState ZAMITES_LEAVES = BlockInit.ZAMITES_LEAVES.get().getDefaultState();
	
	public static final TreeFeatureConfig ZAMITES_BUSH_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(ZAMITES_LOG), new SimpleBlockStateProvider(ZAMITES_LEAVES), new BlobFoliagePlacer(1, 1)).baseHeight(5).heightRandA(1).trunkHeight(1).trunkHeightRandom(1).trunkTopOffset(2).ignoreVines()).setSapling((IPlantable)BlockInit.ZAMITES_SAPLING.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean p_225546_2_) {
		return PHFFeatures.ZAMITES_BUSH.withConfiguration(ZAMITES_BUSH_CONFIG);
	}
	
}
