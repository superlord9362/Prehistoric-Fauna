package superlord.prehistoricfauna.init;

import net.minecraft.core.Registry;
import net.minecraft.world.level.chunk.ChunkStatus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.world.chunkgen.PrehistoricChunkStatus;

public class PFChunkStatus {
	
    public static final DeferredRegister<ChunkStatus> REGISTER = DeferredRegister.create(Registry.CHUNK_STATUS_REGISTRY, PrehistoricFauna.MOD_ID);

    public static final RegistryObject<ChunkStatus> PF_CHUNK_STATUS = REGISTER.register("pf_chunk_status", () -> new PrehistoricChunkStatus());

}
