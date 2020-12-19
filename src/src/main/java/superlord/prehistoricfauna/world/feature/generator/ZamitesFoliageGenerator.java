package superlord.prehistoricfauna.world.feature.generator;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import superlord.prehistoricfauna.world.placement.PrehistoricFoliagePlacerType;

import java.util.Random;
import java.util.Set;

public class ZamitesFoliageGenerator extends FoliagePlacer {
	public ZamitesFoliageGenerator(int radius, int randomRadius) {
		super(radius, randomRadius, PrehistoricFoliagePlacerType.ZAMITES);
	}

	public <T> ZamitesFoliageGenerator(Dynamic<T> config) {
		this(config.get("radius").asInt(0), config.get("radius_random").asInt(0));
	}

	//generates leaves
	public void func_225571_a_(IWorldGenerationReader world, Random random, TreeFeatureConfig treeConfig, int height, int trunkHeight, int radius, BlockPos pos, Set<BlockPos> leavesPos) {
//		for(int i = height; i >= trunkHeight; --i) {
//			int j = 0;
//			this.func_227384_a_(world, random, treeConfig, height, pos, i, j, leavesPos);
//		}
		this.func_227385_a_(world, random, pos, treeConfig, leavesPos);
	}
		   
	//gets radius of the tree
	public int func_225573_a_(Random random, int p_225573_2_, int p_225573_3_, TreeFeatureConfig treeConfig) {
		//returns the radius field with a random extra radius amount. May only just need the radius for this
		return 1;
	}

	//checks if the tree can be placed here?
	protected boolean func_225572_a_(Random random, int height, int xPos, int leavesHeight, int zPos, int radius) {
		return Math.abs(xPos) == radius && Math.abs(zPos) == radius && (random.nextInt(2) == 0 || leavesHeight == 1);
	}

	//checks width of the tree trunk?
	public int func_225570_a_(int trunkHeight, int height, int radius, int leavesHeight) {
		return 1;
	}
}