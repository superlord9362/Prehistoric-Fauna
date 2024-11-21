package superlord.prehistoricfauna.init;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PFParticles {
	
    public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, PrehistoricFauna.MOD_ID);
    
    public static final RegistryObject<SimpleParticleType> PORTAL_PARTICLE = REGISTRY.register("portal_particle", ()-> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> BOSS_LASER = REGISTRY.register("boss_laser", ()-> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> BOSS_HEAL = REGISTRY.register("boss_heal", ()-> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> GINKGO_LEAVES = REGISTRY.register("ginkgo_leaves", ()-> new SimpleParticleType(false));

}
