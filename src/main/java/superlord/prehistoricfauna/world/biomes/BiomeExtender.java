package superlord.prehistoricfauna.world.biomes;

import net.minecraft.world.biome.Biome;

public class BiomeExtender extends Biome {

    private final int grassColor;
    private final int foliageColor;
    private final int skyColor;

    public BiomeExtender(Builder biomeBuilder) {
        super(biomeBuilder);
        this.grassColor = 0;
        this.foliageColor = 0;
        this.skyColor = 0;
    }


    public BiomeExtender(Builder biomeBuilder, int grassColor, int foliageColor) {
        super(biomeBuilder);
        this.grassColor = grassColor;
        this.foliageColor = foliageColor;
        this.skyColor = 0;
    }

    public BiomeExtender(Builder biomeBuilder, int grassColor, int foliageColor, int skyColor) {
        super(biomeBuilder);
        this.grassColor = grassColor;
        this.foliageColor = foliageColor;
        this.skyColor = skyColor;
    }

    @Override
    public int getFoliageColor() {
        return this.foliageColor;
    }

    @Override
    public int getGrassColor(double posX, double posZ) {
        return this.grassColor;
    }

    @Override
    public int getSkyColor() {
        if (skyColor == 0)
            return super.getSkyColor();
        else
            return this.skyColor;
    }
}