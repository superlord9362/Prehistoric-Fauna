package superlord.prehistoricfauna.init;

import java.util.List;

import org.apache.commons.compress.utils.Lists;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.particle.BossHealParticle;
import superlord.prehistoricfauna.common.particle.BossLaserParticle;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PFParticles {
	
	public static final SimpleParticleType BOSS_LASER = registerBasicParticle("boss_laser");
	public static final SimpleParticleType BOSS_HEAL = registerBasicParticle("boss_heal");

	private static SimpleParticleType registerBasicParticle(String name) {
		return ParticleRegistry.registerParticle(name, new SimpleParticleType(false));
	}
	
	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void registerFactories(ParticleFactoryRegisterEvent e) {
		ParticleEngine particles = Minecraft.getInstance().particleEngine;
		particles.register(BOSS_LASER, BossLaserParticle.Provider::new);
		particles.register(BOSS_HEAL, BossHealParticle.Provider::new);
	}
	
	@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public class ParticleRegistry {
		
		public static final List<ParticleType<?>> PARTICLE_TYPES = Lists.newArrayList();
		
		public static <T extends ParticleType<?>> T registerParticle(String name, T particle) {
			particle.setRegistryName(new ResourceLocation(PrehistoricFauna.MOD_ID, name));
			PARTICLE_TYPES.add(particle);
			return particle;
		}
		
		@SubscribeEvent
		public static void registerParticles(RegistryEvent.Register<ParticleType<?>> event) {
			IForgeRegistry<ParticleType<?>> registry = event.getRegistry();
			for (ParticleType<?> particle : PARTICLE_TYPES) {
				registry.register(particle);
			}
		}
		
	}

}
