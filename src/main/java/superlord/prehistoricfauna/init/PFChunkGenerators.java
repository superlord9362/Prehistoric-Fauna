package superlord.prehistoricfauna.init;

import com.mojang.serialization.Codec;

import net.minecraft.core.Registry;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.world.chunkgen.CretaceousChunkGenerator;
import superlord.prehistoricfauna.common.world.chunkgen.JurassicChunkGenerator;
import superlord.prehistoricfauna.common.world.chunkgen.TriassicChunkGenerator;

public class PFChunkGenerators {
    public static final DeferredRegister<Codec<? extends ChunkGenerator>> REGISTER = DeferredRegister.create(Registry.CHUNK_GENERATOR_REGISTRY, PrehistoricFauna.MOD_ID);

    public static final RegistryObject<Codec<TriassicChunkGenerator>> TRIASSIC_CHUNK_GENERATOR = REGISTER.register("triassic_chunk_generator", () -> TriassicChunkGenerator.CODEC);
    public static final RegistryObject<Codec<JurassicChunkGenerator>> JURASSIC_CHUNK_GENERATOR = REGISTER.register("jurassic_chunk_generator", () -> JurassicChunkGenerator.CODEC);
    public static final RegistryObject<Codec<CretaceousChunkGenerator>> CRETACEOUS_CHUNK_GENERATOR = REGISTER.register("cretaceous_chunk_generator", () -> CretaceousChunkGenerator.CODEC);
    
}