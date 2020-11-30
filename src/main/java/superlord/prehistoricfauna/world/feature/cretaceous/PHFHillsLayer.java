package superlord.prehistoricfauna.world.feature.cretaceous;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset1Transformer;
import superlord.prehistoricfauna.util.LayerRandomWeightedListUtil;

import javax.annotation.Nullable;

public class PHFHillsLayer implements IAreaTransformer2, IDimOffset1Transformer {

    private final Int2ObjectMap<WeightedList<ResourceLocation>> hillMap;
    private final Registry<Biome> biomeRegistry;

    public PHFHillsLayer(Registry<Biome> biomeRegistry, Int2ObjectMap<WeightedList<ResourceLocation>> hillMap) {
        this.hillMap = hillMap;
        this.biomeRegistry = biomeRegistry;
    }


    public int apply(INoiseRandom rand, IArea area1, IArea area2, int x, int z) {
        int i = area1.getValue(this.getOffsetX(x + 1), this.getOffsetZ(z + 1));
        int j = area2.getValue(this.getOffsetX(x + 1), this.getOffsetZ(z + 1));

        if (hillMap.size() > 0) {
            if (rand.random(4) == 0) {
                int l = i;
                if (hillMap.containsKey(i)) {
                    Biome hill = getHillBiomeValue(hillMap.get(i), rand);
                    if (hill != null) {
                        l = biomeRegistry.getId(hill);
                    }
                }
                return l;
            }
        }
        return i;
    }

    @Nullable
    private Biome getHillBiomeValue(WeightedList<ResourceLocation> biomeHolder, INoiseRandom layerRandom) {
        if (biomeHolder.field_220658_a.size() > 0) {
            return biomeRegistry.getOrDefault(LayerRandomWeightedListUtil.getBiome(biomeHolder, layerRandom));
        }
        else {
            return null;
        }
    }
}
