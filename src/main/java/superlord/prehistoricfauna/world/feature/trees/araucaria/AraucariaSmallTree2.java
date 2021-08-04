package superlord.prehistoricfauna.world.feature.trees.araucaria;

import java.util.Random;
import java.util.Set;

import com.mojang.serialization.Codec;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import superlord.prehistoricfauna.world.feature.config.PFTreeConfig;
import superlord.prehistoricfauna.world.feature.trees.util.PFAbstractTreeFeature;

public class AraucariaSmallTree2 extends PFAbstractTreeFeature<PFTreeConfig> {

    public AraucariaSmallTree2(Codec<PFTreeConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, ISeedReader world, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, PFTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight()); //6 is default
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < world.getHeight()) {
            if (!isDesiredGroundwDirtTag(world, pos.down(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(world, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(world, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {

                for (int buildTrunk = 0; buildTrunk <= randTreeHeight; buildTrunk++) {
                    placeTrunk(config, rand, changedBlocks, world, mainmutable, boundsIn);
                    mainmutable.move(Direction.UP);
                }
                mainmutable.setPos(pos);

                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 4, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 3, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 3, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 3, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 3, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 3, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 2, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 2, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 2, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 2, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 2, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight + 1, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight + 1, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight + 1, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight + 2, 0), boundsIn);
            }
        }
        return true;
    }
}
