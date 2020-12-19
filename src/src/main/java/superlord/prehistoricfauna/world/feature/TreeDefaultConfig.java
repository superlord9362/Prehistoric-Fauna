package superlord.prehistoricfauna.world.feature;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public abstract class TreeDefaultConfig extends Tree
{
    @Override
    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean hasFlowers)
    {
        return null;
    }

    protected abstract Feature<? extends BaseTreeFeatureConfig> getFeature(Random random);

    @SuppressWarnings("unchecked")
	@Override
    public boolean place(IWorld world, ChunkGenerator<?> generator, BlockPos pos, BlockState state, Random random)
    {
        Feature<BaseTreeFeatureConfig> feature = (Feature<BaseTreeFeatureConfig>)this.getFeature(random);
        if (feature == null)
        {
            return false;
        }
        else
        {
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), 4);
            if (feature.place(world, generator, random, pos, DefaultBiomeFeatures.OAK_TREE_CONFIG))
            {
                return true;
            }
            else
            {
                world.setBlockState(pos, state, 4);
                return false;
            }
        }
    }
}