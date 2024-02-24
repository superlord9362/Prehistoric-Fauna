package superlord.prehistoricfauna.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.particle.BossHealParticle;
import superlord.prehistoricfauna.common.particle.BossLaserParticle;
import superlord.prehistoricfauna.common.particle.PFPortalParticle;
import superlord.prehistoricfauna.common.particle.ParticleRegistry;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PFParticles {
	
	public static final SimpleParticleType PORTAL_PARTICLE = registerBasicParticle("portal_particle");
	public static final SimpleParticleType BOSS_LASER = registerBasicParticle("boss_laser");
	public static final SimpleParticleType BOSS_HEAL = registerBasicParticle("boss_heal");

	private static SimpleParticleType registerBasicParticle(String name) {
		return ParticleRegistry.registerParticle(name, new SimpleParticleType(false));
	}
	
	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void registerFactories(ParticleFactoryRegisterEvent e) {
		ParticleEngine particles = Minecraft.getInstance().particleEngine;
		particles.register(PORTAL_PARTICLE, PFPortalParticle.Provider::new);
		particles.register(BOSS_LASER, BossLaserParticle.Provider::new);
		particles.register(BOSS_HEAL, BossHealParticle.Provider::new);
	}

}
