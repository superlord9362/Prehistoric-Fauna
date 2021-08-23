package superlord.prehistoricfauna.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.ParticleRegistry;
import superlord.prehistoricfauna.client.particle.PFPortalParticle;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PFParticles {
	
	public static final BasicParticleType PORTAL_PARTICLE = registerBasicParticle("portal_particle");
	
	private static BasicParticleType registerBasicParticle(String name) {
		return ParticleRegistry.registerParticle(name, new BasicParticleType(false));
	}
	
	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void registerFactories(ParticleFactoryRegisterEvent e) {
		ParticleManager particles = Minecraft.getInstance().particles;
		
		particles.registerFactory(PORTAL_PARTICLE, PFPortalParticle.Factory::new);
	}

}
