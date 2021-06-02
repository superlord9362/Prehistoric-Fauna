package superlord.prehistoricfauna.world.dimension.jurassic;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.ZoomLayer;
import superlord.prehistoricfauna.core.world.PHFBiomes;
import superlord.prehistoricfauna.mixin.access.BiomeSourceAccess;
import superlord.prehistoricfauna.world.dimension.MasterLayer;
import superlord.prehistoricfauna.world.feature.cretaceous.PHFHillsLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongFunction;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class JurassicBiomeProvider extends BiomeProvider {

	private final Int2ObjectMap<WeightedList<ResourceLocation>> hills = new Int2ObjectArrayMap<>();
    private final Registry<Biome> biomeRegistry;
    private final Layer layers;

    protected JurassicBiomeProvider(Registry<Biome> biomeRegistry, long seed) {
        super(BIOMES.stream().map(Registry.BIOME::getOrDefault).collect(Collectors.toSet()));
        this.biomeRegistry = biomeRegistry;
        this.layers = jurassicBiomeLayer(biomeRegistry, seed);

        fillHillsList();
        hills.forEach((integer, resourceLocationWeightedList) -> {
            resourceLocationWeightedList.field_220658_a.forEach(entry -> {
                ResourceLocation resourceLocation = entry.func_220647_b();
                ((BiomeSourceAccess) this).getBiomes().add(biomeRegistry.getOrDefault(resourceLocation));
            });
        });
    }

    public static final List<ResourceLocation> BIOMES = new ArrayList<>();


    public Layer jurassicBiomeLayer(Registry<Biome> biomeRegistry, long seed) {
        LongFunction<IExtendedNoiseRandom<LazyArea>> randomProvider = salt -> new LazyAreaLayerContext(1, seed, salt);

        IAreaFactory<LazyArea> layer = new MasterLayer(biomeRegistry, seed, BIOMES).apply(randomProvider.apply(485868686L));

        int size = 2;
        for (int biomeSize = 0; biomeSize <= size; biomeSize++) {
            layer = ZoomLayer.NORMAL.apply(randomProvider.apply(28585L + biomeSize), layer);
        }

        layer = new PHFHillsLayer(biomeRegistry, hills).apply(randomProvider.apply(19394585865L), layer, layer);
        layer = ZoomLayer.NORMAL.apply(randomProvider.apply(285368899L), layer);
        layer = ZoomLayer.NORMAL.apply(randomProvider.apply(285368899L), layer);
        layer = ZoomLayer.NORMAL.apply(randomProvider.apply(596969L), layer);
        layer = ZoomLayer.NORMAL.apply(randomProvider.apply(183765656L), layer);
        layer = ZoomLayer.FUZZY.apply(randomProvider.apply(958687L), layer);
        layer = ZoomLayer.FUZZY.apply(randomProvider.apply(19375756L), layer);

        return new Layer(layer);
    }

    public void fillHillsList() {
        WeightedList<ResourceLocation> morrison_sub_biomes = new WeightedList<>();
        morrison_sub_biomes.func_226313_a_(biomeRegistry.getKey(PHFBiomes.MORRISON_HILLS), 5);

        hills.put(getRawIdFromKey(biomeRegistry, biomeRegistry.getKey(PHFBiomes.MORRISON_SAVANNAH)), morrison_sub_biomes);
    }

    public static int getRawIdFromKey(Registry<Biome> biomeRegistry, ResourceLocation location) {
        return biomeRegistry.getId(biomeRegistry.getOrDefault(location));
    }

    static {
        BIOMES.add(Registry.BIOME.getKey(PHFBiomes.MORRISON_SAVANNAH));
        BIOMES.add(Registry.BIOME.getKey(PHFBiomes.MORRISON_HILLS));
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {

        return layers.func_215738_a(x, z);
    }
    
}
