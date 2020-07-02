package superlord.prehistoricfauna.util;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import superlord.prehistoricfauna.PrehistoricFauna;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Bus.MOD)
public class SoundHandler {
	
	public static final SoundEvent TRICERATOPS_IDLE;
	public static final SoundEvent TRICERATOPS_HURT;
	public static final SoundEvent TRICERATOPS_WARN;
	public static final SoundEvent TYRANNOSAURUS_IDLE;
	public static final SoundEvent TYRANNOSAURUS_HURT;
	public static final SoundEvent TYRANNOSAURUS_WARN;
	public static final SoundEvent ANKYLOSAURUS_IDLE;
	public static final SoundEvent ANKYLOSAURUS_WARN;
	
	@SubscribeEvent
	public static void registerSounds(final RegistryEvent.Register<SoundEvent> evt) {
		evt.getRegistry().register(SoundHandler.TRICERATOPS_HURT);
		evt.getRegistry().register(SoundHandler.TRICERATOPS_IDLE);
		evt.getRegistry().register(SoundHandler.TRICERATOPS_WARN);
		evt.getRegistry().register(SoundHandler.TYRANNOSAURUS_HURT);
		evt.getRegistry().register(SoundHandler.TYRANNOSAURUS_IDLE);
		evt.getRegistry().register(SoundHandler.TYRANNOSAURUS_WARN);
		evt.getRegistry().register(SoundHandler.ANKYLOSAURUS_IDLE);
		evt.getRegistry().register(SoundHandler.ANKYLOSAURUS_WARN);
	}
	
	private static SoundEvent createEvent(final String soundName) {
		final ResourceLocation soundID = new ResourceLocation(PrehistoricFauna.MODID, soundName);
		return new SoundEvent(soundID).setRegistryName(soundID);
	}
	
	static {
		TRICERATOPS_IDLE = createEvent("triceratops_idle");
		TRICERATOPS_HURT = createEvent("triceratops_hurt");
		TRICERATOPS_WARN = createEvent("triceratops_warn");
		TYRANNOSAURUS_IDLE = createEvent("tyrannosaurus_idle");
		TYRANNOSAURUS_HURT = createEvent("tyrannosaurus_hurt");
		TYRANNOSAURUS_WARN = createEvent("tyrannosaurus_warn");
		ANKYLOSAURUS_IDLE = createEvent("anklyosaurus_idle");
		ANKYLOSAURUS_WARN = createEvent("ankylosaurus_warn");
	}

}
