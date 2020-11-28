package superlord.prehistoricfauna.core.world;

import net.minecraft.world.biome.Biome;
import superlord.prehistoricfauna.core.world.util.WorldGenRegistrationHelper;
import superlord.prehistoricfauna.world.biomes.CretaceousBiomes;
import superlord.prehistoricfauna.world.biomes.JurassicBiomes;
import superlord.prehistoricfauna.world.biomes.PHFOverworldBiomes;
import superlord.prehistoricfauna.world.biomes.TriassicBiomes;

import java.util.ArrayList;
import java.util.List;

public class PHFBiomes {
    public static List<PreserveBiomeOrder> biomes = new ArrayList<>();

    public static final Biome DUMMY = WorldGenRegistrationHelper.createBiome("dummy", PHFOverworldBiomes.dummy(), 2000);

    //Cretaceous Biomes
    public static final Biome HELL_CREEK = WorldGenRegistrationHelper.createBiome("hell_creek", CretaceousBiomes.hellCreek(), 1);

    //Jurassic Biomes
    public static final Biome MORRISON_SAVANNAH = WorldGenRegistrationHelper.createBiome("morrison_savannah", JurassicBiomes.morrisonSavannah(), 2);

    //Triassic Biomes
    public static final Biome ISCHIGUALASTO_FOREST = WorldGenRegistrationHelper.createBiome("ischigualasto_forest", TriassicBiomes.ischigualastoForest(), 3);

    //Overworld biomes
    public static final Biome PETRIFIED_FOREST = WorldGenRegistrationHelper.createBiome("petrified_forest", PHFOverworldBiomes.petrifiedForest(), 4);


    public static void init(){
    }


    //Only important in 1.16 due to the world gen changes brought by Mojang's datapackable biomes.
    public static class PreserveBiomeOrder {
        private final Biome biome;
        private final int orderPosition;

        public PreserveBiomeOrder(Biome biome, int orderPosition) {
            this.biome = biome;
            this.orderPosition = orderPosition;
        }

        public Biome getBiome() {
            return biome;
        }

        public int getOrderPosition() {
            return orderPosition;
        }
    }
}
