package superlord.prehistoricfauna.world.feature.tree;

import com.mojang.datafixers.Dynamic;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import superlord.prehistoricfauna.world.feature.config.PHFTreeConfig;
import superlord.prehistoricfauna.world.feature.util.PHFAbstractTreeFeature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class Protopiceoxylon2 extends PHFAbstractTreeFeature<PHFTreeConfig> {

    public Protopiceoxylon2(Function<Dynamic<?>, ? extends PHFTreeConfig> configIn) {
        super(configIn);
    }

	protected boolean generate(Set<BlockPos> changedBlocks, IWorld world, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, PHFTreeConfig config) {

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
            	buildTrunkBase(pos, changedBlocks, world, config, rand, boundsIn, mainmutable.setPos(pos).move(0, 0, 0).toImmutable());
            	for (int buildTrunk = 0; buildTrunk <= randTreeHeight; buildTrunk++) {
					placeTrunk(config, rand, changedBlocks, world, mainmutable, boundsIn);
					mainmutable.move(Direction.UP);
				}
				
            	mainmutable.setPos(pos);
				
				placeTrunk(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, 0, 0), boundsIn);
				placeTrunk(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, 1, 0), boundsIn);
				placeTrunk(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, 2, 0), boundsIn);
				placeTrunk(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, 3, 0), boundsIn);
				placeTrunk(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, 4, 0), boundsIn);
				placeTrunk(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, 5, 0), boundsIn);
				placeTrunk(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, 6, 0), boundsIn);
				placeTrunk(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, 7, 0), boundsIn);
				placeTrunk(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, 8, 0), boundsIn);
				placeTrunk(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, 9, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 5, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 5, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 5, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 5, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 3, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight - 3, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight - 3, 1), boundsIn);
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
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight + 1, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight + 1, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight + 2, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight + 2, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight + 2, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight + 2, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight + 2, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight + 2, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight + 2, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight + 2, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight + 2, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight + 3, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(-1, randTreeHeight + 3, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight + 3, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(1, randTreeHeight + 3, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight + 3, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight + 4, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, world, mainmutable.setPos(pos).move(0, randTreeHeight + 5, 0), boundsIn);
            }
        }
        return true;
    }
}