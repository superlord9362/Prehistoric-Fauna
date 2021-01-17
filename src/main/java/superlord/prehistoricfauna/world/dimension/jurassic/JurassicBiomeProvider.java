package superlord.prehistoricfauna.world.dimension.jurassic;

import com.google.common.collect.ImmutableSet;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import superlord.prehistoricfauna.core.world.PHFBiomes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JurassicBiomeProvider extends BiomeProvider {

	private final Int2ObjectMap<WeightedList<ResourceLocation>> HILLS = new Int2ObjectArrayMap<>();
	private final Registry<Biome> biomeRegistry;

	
	protected JurassicBiomeProvider(Registry<Biome> biomeRegistry) {
		super(BIOMES.stream().map(Registry.BIOME::getOrDefault).collect(Collectors.toSet()));
		this.biomeRegistry = biomeRegistry;
	}
	
	public static final List<ResourceLocation> BIOMES = new ArrayList<>();

	
	public void fillHillsList() {
		WeightedList<ResourceLocation> morrison_sub_biomes = new WeightedList<>();
		morrison_sub_biomes.func_226313_a_(biomeRegistry.getKey(PHFBiomes.MORRISON_HILLS), 5);

		HILLS.put(getRawIdFromKey(biomeRegistry, biomeRegistry.getKey(PHFBiomes.MORRISON_SAVANNAH)), morrison_sub_biomes);
	}
	
	public static int getRawIdFromKey(Registry<Biome> biomeRegistry, ResourceLocation location) {
		return biomeRegistry.getId(biomeRegistry.getOrDefault(location));
	}
	
	static {
		BIOMES.add(Registry.BIOME.getKey(PHFBiomes.ISCHIGUALASTO_FOREST));
	}
	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return PHFBiomes.MORRISON_SAVANNAH;
	}

}
