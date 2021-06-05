package superlord.prehistoricfauna.world.feature.jurassic;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import superlord.prehistoricfauna.init.BlockInit;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class ZamitesBushFeature extends AbstractTreeFeature<TreeFeatureConfig>
{
    public ZamitesBushFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> config) {
        super(config);
    }

    @Override
    protected boolean place(IWorldGenerationReader worldIn, Random rand, BlockPos startPosition, Set<BlockPos> p_225557_4_, Set<BlockPos> p_225557_5_, MutableBoundingBox boundingBoxIn, TreeFeatureConfig configIn) {
        BlockPos pos = startPosition;
        // Moving down until it is on the ground
        while (pos.getY() > 1 && isAirOrLeaves(worldIn, pos)) pos = pos.down();

        if (!isSoil(worldIn, pos, null))
        {
            return false; // this tree is only allowed to grow on soil, but not on water or plant or other thing
        }
        pos = pos.up();
        // Make main trunk
        // Randomize the height
        int height = rand.nextInt(3) + 2;
        int x = pos.getX();
        int z = pos.getZ();
        if (pos.getY() >= 1 && pos.getY() + height + 2 <= worldIn.getMaxHeight())
        {
            for (int j = pos.getY(); j <= pos.getY() + height; j++)
            {
                if (isAir(worldIn, new BlockPos(x, j, z))) setBlockState(worldIn, new BlockPos(x, j, z), BlockInit.ZAMITES_LOG.getDefaultState());
            }
            if (isAir(worldIn, new BlockPos(x, pos.getY() + height + 1, z))) setBlockState(worldIn, new BlockPos(x, startPosition.getY() + height + 1, z), BlockInit.ZAMITES_LEAVES.getDefaultState());
            return true;
        }
        return false;
    }
}
