package superlord.prehistoricfauna.core.world;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.ColumnBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.world.feature.PetrifiedTree;

public class PFFeatureRegistration {

	public static final BlockClusterFeatureConfig PETRIFIED_TREE_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.PETRIFIED_WOOD.getDefaultState()), new ColumnBlockPlacer(1, 4))).tries(10).func_227317_b_().build();
	
    public static void addFeatures() {
    	 for (Biome biome : ForgeRegistries.BIOMES) {	
    		 if(biome == PHFOverworldBiomeRegistry.PETRIFIED_FOREST) {
    		      biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(PetrifiedTree.PETRIFIED_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.2F, 1))));
    		 }
    	 }
    }
	
}
