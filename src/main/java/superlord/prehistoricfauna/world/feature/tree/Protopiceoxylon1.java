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

public class Protopiceoxylon1 extends PHFAbstractTreeFeature<PHFTreeConfig> {

    public Protopiceoxylon1(Function<Dynamic<?>, ? extends PHFTreeConfig> configIn) {
        super(configIn);
    }

    @SuppressWarnings("unused")
	protected boolean generate(Set<BlockPos> changedBlocks, IWorld worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, PHFTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().setPos(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {
            	buildTrunkBase(pos, changedBlocks, worldIn, config, rand, boundsIn, mainmutable.setPos(pos).move(0, 0, 0).toImmutable());

            	for (int buildTrunk = 0; buildTrunk <= randTreeHeight; buildTrunk++) {
					placeTrunk(config, rand, changedBlocks, worldIn, mainmutable, boundsIn);
					mainmutable.move(Direction.UP);
				}

            	mainmutable.setPos(pos);

				placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 9, 1), boundsIn);
				placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 8, -1), boundsIn);
				placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 7, 0), boundsIn);
				placeBranch(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 5, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 10, -4), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 10, -4), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 10, -4), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 10, -3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 10, -3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 10, -3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 10, -3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 10, -3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 10, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 10, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 10, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 10, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-4, randTreeHeight - 10, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 10, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 10, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(4, randTreeHeight - 10, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-4, randTreeHeight - 10, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 10, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 10, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(4, randTreeHeight - 10, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-4, randTreeHeight - 10, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 10, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 10, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(4, randTreeHeight - 10, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 10, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 10, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 10, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 10, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 10, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 10, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 10, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 10, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 10, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 10, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 10, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 10, 4), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 10, 4), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 10, 4), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 9, -3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 9, -3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 9, -3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 9, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 9, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 9, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 9, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 9, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 9, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 9, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 9, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 9, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 9, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 9, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 9, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 9, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 9, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 9, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 9, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 9, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 9, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 9, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 9, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 9, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 9, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 9, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 9, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 9, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 9, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 9, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 9, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 9, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 9, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 9, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 9, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 8, -3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 8, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 8, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 8, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 8, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 8, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-3, randTreeHeight - 8, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 8, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 8, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 8, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 8, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(3, randTreeHeight - 8, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 8, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 8, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 8, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 8, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 8, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 8, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 8, 3), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 7, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 7, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 7, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 7, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 7, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 7, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 7, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 7, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 7, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 7, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 7, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 7, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 7, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 7, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 7, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 6, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 6, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 6, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 6, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 6, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 6, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 6, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 6, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 5, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 5, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 5, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 5, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 5, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 5, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 5, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 5, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 5, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 5, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 5, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 5, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 5, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 5, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 5, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 5, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 5, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 5, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 5, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 4, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 4, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 4, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 4, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 3, -2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 3, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 3, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-2, randTreeHeight - 3, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 3, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(2, randTreeHeight - 3, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 3, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 3, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 3, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 3, 2), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 2, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 2, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 2, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 2, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 1, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 1, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 1, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 1, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 1, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight - 1, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight - 1, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight - 1, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight, -1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(-1, randTreeHeight, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(1, randTreeHeight, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight, 1), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight + 1, 0), boundsIn);
				placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.setPos(pos).move(0, randTreeHeight + 2, 0), boundsIn);
            }
        }
        return true;
    }
}