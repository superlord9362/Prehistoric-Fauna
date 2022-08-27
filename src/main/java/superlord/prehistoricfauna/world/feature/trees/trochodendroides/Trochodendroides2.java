package superlord.prehistoricfauna.world.feature.trees.trochodendroides;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import superlord.prehistoricfauna.world.feature.config.PFTreeConfig;
import superlord.prehistoricfauna.world.feature.trees.util.PFAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

import com.mojang.serialization.Codec;

public class Trochodendroides2 extends PFAbstractTreeFeature<PFTreeConfig> {

    public Trochodendroides2(Codec<PFTreeConfig> configIn) {
        super(configIn);
    }

	protected boolean generate(Set<BlockPos> changedBlocks, ISeedReader world, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, PFTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < world.getHeight()) {
            if (!isDesiredGroundwDirtTag(world, pos.down(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(world, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(world, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {
            	buildTrunkBase(pos, changedBlocks, world, config, rand, boundsIn, mainmutable.setPos(pos).move(0, 0, 0).toImmutable(), mainmutable.setPos(pos).move(0, 0, 1).toImmutable());
            	for (int buildTrunk = 0; buildTrunk <= randTreeHeight; buildTrunk++) {
					mainmutable.move(Direction.UP);
				}
				
            	mainmutable.setPos(pos);
				
				placeTrunk(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, 0, 0), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 5, 1), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 4, -1), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, 1), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 4, 1), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 4, 2), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 3, -1), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 3, 0), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, 1), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 3, 1), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 3, 2), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, 3), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 2, 1), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 2, 1), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, 3), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 1, 1), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 1, 1), boundsIn);
				placeBranch(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 5, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight - 5, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 5, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 4, -3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 4, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 4, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 4, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 4, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(4, randTreeHeight - 4, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-4, randTreeHeight - 4, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 4, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 4, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight - 4, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 4, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 4, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight - 4, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 4, 4), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 4, 4), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 3, -3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 3, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 3, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 3, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 3, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight - 3, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-3, randTreeHeight - 3, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 3, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 3, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight - 3, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(4, randTreeHeight - 3, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-4, randTreeHeight - 3, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 3, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 3, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 3, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight - 3, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(4, randTreeHeight - 3, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 3, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 3, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 3, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight - 3, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-3, randTreeHeight - 3, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 3, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 3, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight - 3, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 3, 4), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 3, 4), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, 5), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 2, -3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 2, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 2, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 2, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 2, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 2, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 2, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-3, randTreeHeight - 2, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 2, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 2, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 2, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 2, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight - 2, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-4, randTreeHeight - 2, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 2, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 2, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(4, randTreeHeight - 2, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-3, randTreeHeight - 2, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 2, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 2, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 2, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 2, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight - 2, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(4, randTreeHeight - 2, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-3, randTreeHeight - 2, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 2, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 2, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 2, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 2, 4), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, 4), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 2, 4), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 2, 4), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, 5), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 1, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 1, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 1, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 1, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 1, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-3, randTreeHeight - 1, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 1, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 1, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 1, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 1, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 1, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-4, randTreeHeight - 1, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-3, randTreeHeight - 1, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 1, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 1, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 1, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight - 1, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(4, randTreeHeight - 1, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-3, randTreeHeight - 1, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 1, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 1, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 1, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 1, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight - 1, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(4, randTreeHeight - 1, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight - 1, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 1, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 1, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 1, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight - 1, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight - 1, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 1, 4), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-3, randTreeHeight, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(4, randTreeHeight, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight + 1, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight + 1, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-2, randTreeHeight + 1, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight + 1, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight + 1, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(3, randTreeHeight + 1, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight + 1, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(2, randTreeHeight + 2, 1), boundsIn);

            }
        }
        return true;
    }
}