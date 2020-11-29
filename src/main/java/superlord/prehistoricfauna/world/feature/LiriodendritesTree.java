package superlord.prehistoricfauna.world.feature;

import net.minecraft.block.BlockState;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;
import superlord.prehistoricfauna.init.BlockInit;

import java.util.Random;

public class LiriodendritesTree extends Tree {
	
	public final static BlockState LIRIODENDRITES_LOG = BlockInit.LIRIODENDRITES_LOG.getDefaultState();
	public final static BlockState LIRIODENDRITES_LEAVES = BlockInit.LIRIODENDRITES_LEAVES.getDefaultState();
	
	public static final TreeFeatureConfig LIRIODENDRITES_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(LIRIODENDRITES_LOG), new SimpleBlockStateProvider(LIRIODENDRITES_LEAVES), new BlobFoliagePlacer(0, 0))).setSapling((IPlantable)BlockInit.LIRIODENDRITES_SAPLING).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
		return Feature.FANCY_TREE.withConfiguration(LIRIODENDRITES_TREE_CONFIG);
	}
	
}