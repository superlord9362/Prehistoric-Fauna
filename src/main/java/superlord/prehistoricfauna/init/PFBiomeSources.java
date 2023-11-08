package superlord.prehistoricfauna.init;

import com.mojang.serialization.Codec;

import net.minecraft.core.Registry;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.world.biome.biomesource.CretaceousBiomeSource;
import superlord.prehistoricfauna.common.world.biome.biomesource.JurassicBiomeSource;
import superlord.prehistoricfauna.common.world.biome.biomesource.TriassicBiomeSource;

public class PFBiomeSources {
	public static final DeferredRegister<Codec<? extends BiomeSource>> REGISTER = DeferredRegister.create(Registry.BIOME_SOURCE_REGISTRY, PrehistoricFauna.MOD_ID);

    public static final RegistryObject<Codec<TriassicBiomeSource>> TRIASSIC_BIOME_SOURCE = REGISTER.register("triassic_biome_source", () -> TriassicBiomeSource.CODEC);
    public static final RegistryObject<Codec<JurassicBiomeSource>> JURASSIC_BIOME_SOURCE = REGISTER.register("jurassic_biome_source", () -> JurassicBiomeSource.CODEC);
    public static final RegistryObject<Codec<CretaceousBiomeSource>> CRETACEOUS_BIOME_SOURCE = REGISTER.register("cretaceous_biome_source", () -> CretaceousBiomeSource.CODEC);
    
}
