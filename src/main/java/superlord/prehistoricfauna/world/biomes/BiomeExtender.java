package superlord.prehistoricfauna.world.biomes;

import net.minecraft.world.biome.Biome;

public class BiomeExtender extends Biome {

    private int grassColor = -1;
    private int foliageColor = -1;
    private int skyColor = -1;

    public BiomeExtender(Builder biomeBuilder) {
        super(biomeBuilder);
    }

    public BiomeExtender setFoliageColor(int foliageColor) {
        this.foliageColor = foliageColor;
        return this;
    }

    public BiomeExtender setGrassColor(int grassColor) {
        this.grassColor = grassColor;
        return this;
    }

    public BiomeExtender setSkyColor(int skyColor) {
        this.skyColor = skyColor;
        return this;
    }

    @Override
    public int getFoliageColor() {
        if (foliageColor == -1)
            return super.getFoliageColor();
        else
            return this.foliageColor;
    }

    @Override
    public int getGrassColor(double posX, double posZ) {
        if (grassColor == -1)
            return super.getGrassColor(posX, posZ);
        else
            return this.grassColor;
    }

    @Override
    public int getSkyColor() {
        if (skyColor == -1)
            return super.getSkyColor();
        else
            return skyColor;
    }


}