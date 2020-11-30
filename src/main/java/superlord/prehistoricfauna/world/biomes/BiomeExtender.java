package superlord.prehistoricfauna.world.biomes;

import net.minecraft.world.biome.Biome;

public class BiomeExtender extends Biome {

    private final int grassColor;
    private final int foliageColor;
    private final int skyColor;

    public BiomeExtender(Builder biomeBuilder) {
        super(biomeBuilder);
        this.grassColor = -1;
        this.foliageColor = -1;
        this.skyColor = -1;
    }


    public BiomeExtender(Builder biomeBuilder, int grassColor, int foliageColor) {
        super(biomeBuilder);
        this.grassColor = grassColor;
        this.foliageColor = foliageColor;
        this.skyColor = -1;
    }

    public BiomeExtender(Builder biomeBuilder, int grassColor, int foliageColor, int skyColor) {
        super(biomeBuilder);
        this.grassColor = grassColor;
        this.foliageColor = foliageColor;
        this.skyColor = skyColor;
    }

//    @Override
//    public int getFoliageColor() {
//        if (foliageColor == -1)
//            return this.foliageColor;
//        else
//            return super.getFoliageColor();
//    }
//
//    @Override
//    public int getGrassColor(double posX, double posZ) {
//        if (grassColor == -1)
//            return this.grassColor;
//        else
//            return super.getGrassColor(posX, posZ);
//    }
//
//    @Override
//    public int getSkyColor() {
//        if (skyColor == -1)
//            return this.skyColor;
//        else
//            return super.getSkyColor();
//    }
}