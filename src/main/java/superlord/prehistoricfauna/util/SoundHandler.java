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
	
	//Hell Creek
	public static final SoundEvent TRICERATOPS_IDLE;
	public static final SoundEvent TRICERATOPS_HURT;
	public static final SoundEvent TRICERATOPS_WARN;
	public static final SoundEvent TYRANNOSAURUS_IDLE;
	public static final SoundEvent TYRANNOSAURUS_HURT;
	public static final SoundEvent TYRANNOSAURUS_WARN;
	public static final SoundEvent ANKYLOSAURUS_IDLE;
	public static final SoundEvent ANKYLOSAURUS_HURT;
	public static final SoundEvent ANKYLOSAURUS_WARN;
	public static final SoundEvent DAKOTARAPTOR_IDLE;
	public static final SoundEvent DAKOTARAPTOR_HURT;
	public static final SoundEvent DAKOTARAPTOR_WARN;
	public static final SoundEvent THESCELOSAURUS_IDLE;
	public static final SoundEvent THESCELOSAURUS_HURT;
	public static final SoundEvent DIDELPHODON_IDLE;
	public static final SoundEvent DIDELPHODON_HURT;
	//Morrison
	public static final SoundEvent ALLOSAURUS_IDLE;
	public static final SoundEvent ALLOSAURUS_HURT;
	public static final SoundEvent ALLOSAURUS_WARN;
	public static final SoundEvent STEGOSAURUS_IDLE;
	public static final SoundEvent STEGOSAURUS_HURT;
	public static final SoundEvent STEGOSAURUS_WARN;
	public static final SoundEvent CERATOSAURUS_IDLE;
	public static final SoundEvent CERATOSAURUS_HURT;
	public static final SoundEvent CERATOSAURUS_WARN;
	public static final SoundEvent DRYOSAURUS_IDLE;
	public static final SoundEvent DRYOSAURUS_HURT;
	public static final SoundEvent HESPERORNITHOIDES_IDLE;
	public static final SoundEvent HESPERORNITHOIDES_HURT;
	public static final SoundEvent CAMARASAURUS_IDLE;
	public static final SoundEvent CAMARASAURUS_HURT;
	public static final SoundEvent CAMARASAURUS_WARN;
	public static final SoundEvent EILENODON_IDLE;
	public static final SoundEvent EILENODON_HURT;
	
	@SubscribeEvent
	public static void registerSounds(final RegistryEvent.Register<SoundEvent> evt) {
		//Hell Creek
		evt.getRegistry().register(TRICERATOPS_HURT);
		evt.getRegistry().register(TRICERATOPS_IDLE);
		evt.getRegistry().register(TRICERATOPS_WARN);
		evt.getRegistry().register(TYRANNOSAURUS_HURT);
		evt.getRegistry().register(TYRANNOSAURUS_IDLE);
		evt.getRegistry().register(TYRANNOSAURUS_WARN);
		evt.getRegistry().register(ANKYLOSAURUS_IDLE);
		evt.getRegistry().register(ANKYLOSAURUS_HURT);
		evt.getRegistry().register(ANKYLOSAURUS_WARN);
		evt.getRegistry().register(DAKOTARAPTOR_IDLE);
		evt.getRegistry().register(DAKOTARAPTOR_HURT);
		evt.getRegistry().register(DAKOTARAPTOR_WARN);
		evt.getRegistry().register(THESCELOSAURUS_IDLE);
		evt.getRegistry().register(THESCELOSAURUS_HURT);
		evt.getRegistry().register(DIDELPHODON_IDLE);
		evt.getRegistry().register(DIDELPHODON_HURT);
		//Morrison
		evt.getRegistry().register(ALLOSAURUS_IDLE);
		evt.getRegistry().register(ALLOSAURUS_HURT);
		evt.getRegistry().register(ALLOSAURUS_WARN);
		evt.getRegistry().register(STEGOSAURUS_IDLE);
		evt.getRegistry().register(STEGOSAURUS_HURT);
		evt.getRegistry().register(STEGOSAURUS_WARN);
		evt.getRegistry().register(CERATOSAURUS_IDLE);
		evt.getRegistry().register(CERATOSAURUS_HURT);
		evt.getRegistry().register(CERATOSAURUS_WARN);
		evt.getRegistry().register(DRYOSAURUS_IDLE);
		evt.getRegistry().register(DRYOSAURUS_HURT);
		evt.getRegistry().register(HESPERORNITHOIDES_IDLE);
		evt.getRegistry().register(HESPERORNITHOIDES_HURT);
		evt.getRegistry().register(CAMARASAURUS_IDLE);
		evt.getRegistry().register(CAMARASAURUS_HURT);
		evt.getRegistry().register(CAMARASAURUS_WARN);
		evt.getRegistry().register(EILENODON_IDLE);
		evt.getRegistry().register(EILENODON_HURT);
	}
	
	private static SoundEvent createEvent(final String soundName) {
		final ResourceLocation soundID = new ResourceLocation(PrehistoricFauna.MODID, soundName);
		return new SoundEvent(soundID).setRegistryName(soundID);
	}
	
	static {
		//Hell Creek
		TRICERATOPS_IDLE = createEvent("triceratops_idle");
		TRICERATOPS_HURT = createEvent("triceratops_hurt");
		TRICERATOPS_WARN = createEvent("triceratops_warn");
		TYRANNOSAURUS_IDLE = createEvent("tyrannosaurus_idle");
		TYRANNOSAURUS_HURT = createEvent("tyrannosaurus_hurt");
		TYRANNOSAURUS_WARN = createEvent("tyrannosaurus_warn");
		ANKYLOSAURUS_IDLE = createEvent("anklyosaurus_idle");
		ANKYLOSAURUS_HURT = createEvent("ankylosaurus_hurt");
		ANKYLOSAURUS_WARN = createEvent("ankylosaurus_warn");
		DAKOTARAPTOR_IDLE = createEvent("dakotaraptor_idle");
		DAKOTARAPTOR_HURT = createEvent("dakotaraptor_hurt");
		DAKOTARAPTOR_WARN = createEvent("dakotaraptor_warn");
		THESCELOSAURUS_IDLE = createEvent("thescelosaurus_idle");
		THESCELOSAURUS_HURT = createEvent("thescelosaurus_hurt");
		DIDELPHODON_IDLE = createEvent("didelphodon_idle");
		DIDELPHODON_HURT = createEvent("didelphodon_hurt");
		//Morrison
		ALLOSAURUS_IDLE = createEvent("allosaurus_idle");
		ALLOSAURUS_HURT = createEvent("allosaurus_hurt");
		ALLOSAURUS_WARN = createEvent("allosaurus_warn");
		STEGOSAURUS_IDLE = createEvent("stegosaurus_idle");
		STEGOSAURUS_HURT = createEvent("stegosaurus_hurt");
		STEGOSAURUS_WARN = createEvent("stegosaurus_warn");
		CERATOSAURUS_IDLE = createEvent("ceratosaurus_idle");
		CERATOSAURUS_HURT = createEvent("ceratosaurus_hurt");
		CERATOSAURUS_WARN = createEvent("ceratosaurus_warn");
		DRYOSAURUS_IDLE = createEvent("dryosaurus_idle");
		DRYOSAURUS_HURT = createEvent("dryosaurus_hurt");
		HESPERORNITHOIDES_IDLE = createEvent("hesperornithoides_idle");
		HESPERORNITHOIDES_HURT = createEvent("hesperornithoides_hurt");
		CAMARASAURUS_IDLE = createEvent("camarasaurus_idle");
		CAMARASAURUS_HURT = createEvent("camarasaurus_hurt");
		CAMARASAURUS_WARN = createEvent("camarasaurus_warn");
		EILENODON_IDLE = createEvent("eilenodon_idle");
		EILENODON_HURT = createEvent("eilenodon_hurt");
	}

}
