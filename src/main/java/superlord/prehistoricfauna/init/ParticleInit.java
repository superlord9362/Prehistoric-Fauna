package superlord.prehistoricfauna.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.particles.CretaceousPortalParticle;
import superlord.prehistoricfauna.particles.JurassicPortalParticle;
import superlord.prehistoricfauna.particles.TriassicPortalParticle;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleInit {
	
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = new DeferredRegister<>(ForgeRegistries.PARTICLE_TYPES, PrehistoricFauna.MODID);
	
	public static final BasicParticleType cretaceous = new BasicParticleType(false);
	public static final BasicParticleType jurassic = new BasicParticleType(false);
	public static final BasicParticleType triassic = new BasicParticleType(false);
	
	public static final RegistryObject<BasicParticleType> CRETACEOUS = PARTICLE_TYPES.register("cretaceous", () -> cretaceous);
	public static final RegistryObject<BasicParticleType> JURASSIC = PARTICLE_TYPES.register("jurassic", () -> jurassic);
	public static final RegistryObject<BasicParticleType> TRIASSIC = PARTICLE_TYPES.register("triassic", () -> triassic);
	
	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void registerFactories(ParticleFactoryRegisterEvent e) {
		ParticleManager particles = Minecraft.getInstance().particles;
		
		particles.registerFactory(cretaceous, CretaceousPortalParticle.Factory::new);
		particles.registerFactory(jurassic, JurassicPortalParticle.Factory::new);
		particles.registerFactory(triassic, TriassicPortalParticle.Factory::new);
	}

}
