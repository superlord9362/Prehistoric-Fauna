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
	public static final SoundEvent TRICERATOPS_IDLE; //Done
	public static final SoundEvent TRICERATOPS_HURT; //Done
	public static final SoundEvent TRICERATOPS_WARN; //Done
	public static final SoundEvent TYRANNOSAURUS_IDLE; //Done
	public static final SoundEvent TYRANNOSAURUS_HURT; //Done
	public static final SoundEvent TYRANNOSAURUS_WARN; //Done
	public static final SoundEvent ANKYLOSAURUS_IDLE; //Done
	public static final SoundEvent ANKYLOSAURUS_HURT; //Done
	public static final SoundEvent ANKYLOSAURUS_WARN; //Done
	public static final SoundEvent DAKOTARAPTOR_IDLE; //Done
	public static final SoundEvent DAKOTARAPTOR_HURT; //Done
	public static final SoundEvent DAKOTARAPTOR_WARN; //Done
	public static final SoundEvent THESCELOSAURUS_IDLE;
	public static final SoundEvent THESCELOSAURUS_HURT;
	public static final SoundEvent DIDELPHODON_IDLE;
	public static final SoundEvent DIDELPHODON_HURT;
	//Morrison
	public static final SoundEvent ALLOSAURUS_IDLE;
	public static final SoundEvent ALLOSAURUS_HURT;
	public static final SoundEvent ALLOSAURUS_WARN;
	public static final SoundEvent STEGOSAURUS_IDLE; //Done
	public static final SoundEvent STEGOSAURUS_HURT; //Done
	public static final SoundEvent STEGOSAURUS_WARN; //Done
	public static final SoundEvent CERATOSAURUS_IDLE; //Done
	public static final SoundEvent CERATOSAURUS_HURT; //Done
	public static final SoundEvent CERATOSAURUS_WARN; //Done
	public static final SoundEvent DRYOSAURUS_IDLE; //Done
	public static final SoundEvent DRYOSAURUS_HURT; //Done
	public static final SoundEvent HESPERORNITHOIDES_IDLE;
	public static final SoundEvent HESPERORNITHOIDES_HURT;
	public static final SoundEvent CAMARASAURUS_IDLE; //Done
	public static final SoundEvent CAMARASAURUS_HURT; //Done
	public static final SoundEvent CAMARASAURUS_WARN; //Done
	public static final SoundEvent EILENODON_IDLE;
	public static final SoundEvent EILENODON_HURT;
	//Ischigualasto
	public static final SoundEvent EXAERETODON_IDLE;
	public static final SoundEvent EXAERETODON_HURT;
	public static final SoundEvent EXAERETODON_WARN;
	public static final SoundEvent CHROMOGISAURUS_IDLE;
	public static final SoundEvent CHROMOGISAURUS_HURT;
	public static final SoundEvent HERRERASAURUS_IDLE;
	public static final SoundEvent HERRERASAURUS_HURT;
	public static final SoundEvent HERRERASAURUS_WARN;
	public static final SoundEvent HYPERODAPEDON_IDLE;
	public static final SoundEvent HYPERODAPEDON_HURT;
	public static final SoundEvent SILLOSUCHUS_IDLE;
	public static final SoundEvent SILLOSUCHUS_HURT;
	public static final SoundEvent SILLOSUCHUS_WARN;
	public static final SoundEvent SAUROSUCHUS_IDLE;
	public static final SoundEvent SAUROSUCHUS_HURT;
	public static final SoundEvent SAUROSUCHUS_WARN;
	public static final SoundEvent ISCHIGUALASTIA_IDLE;
	public static final SoundEvent ISCHIGUALASTIA_HURT;
	public static final SoundEvent ISCHIGUALASTIA_WARN;
	
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
		//Ischigualasto
		evt.getRegistry().register(EXAERETODON_IDLE);
		evt.getRegistry().register(EXAERETODON_HURT);
		evt.getRegistry().register(EXAERETODON_WARN);
		evt.getRegistry().register(CHROMOGISAURUS_IDLE);
		evt.getRegistry().register(CHROMOGISAURUS_HURT);
		evt.getRegistry().register(HERRERASAURUS_IDLE);
		evt.getRegistry().register(HERRERASAURUS_HURT);
		evt.getRegistry().register(HERRERASAURUS_WARN);
		evt.getRegistry().register(HYPERODAPEDON_IDLE);
		evt.getRegistry().register(HYPERODAPEDON_HURT);
		evt.getRegistry().register(SILLOSUCHUS_IDLE);
		evt.getRegistry().register(SILLOSUCHUS_HURT);
		evt.getRegistry().register(SILLOSUCHUS_WARN);
		evt.getRegistry().register(SAUROSUCHUS_IDLE);
		evt.getRegistry().register(SAUROSUCHUS_HURT);
		evt.getRegistry().register(SAUROSUCHUS_WARN);
		evt.getRegistry().register(ISCHIGUALASTIA_IDLE);
		evt.getRegistry().register(ISCHIGUALASTIA_HURT);
		evt.getRegistry().register(ISCHIGUALASTIA_WARN);
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
		//Ischigualasto
		EXAERETODON_IDLE = createEvent("exaeretodon_idle");
		EXAERETODON_HURT = createEvent("exaeretodon_hurt");
		EXAERETODON_WARN = createEvent("exaeretodon_warn");
		CHROMOGISAURUS_IDLE = createEvent("chromogisaurus_idle");
		CHROMOGISAURUS_HURT = createEvent("chromogisaurus_hurt");
		HERRERASAURUS_IDLE = createEvent("herrerasaurus_idle");
		HERRERASAURUS_HURT = createEvent("herrerasaurus_hurt");
		HERRERASAURUS_WARN = createEvent("herrerasaurus_warn");
		HYPERODAPEDON_IDLE = createEvent("hyperodapedon_idle");
		HYPERODAPEDON_HURT = createEvent("hyperodapedon_hurt");
		SILLOSUCHUS_IDLE = createEvent("sillosuchus_idle");
		SILLOSUCHUS_HURT = createEvent("sillosuchus_hurt");
		SILLOSUCHUS_WARN = createEvent("sillosuchus_warn");
		SAUROSUCHUS_IDLE = createEvent("saurosuchus_idle");
		SAUROSUCHUS_HURT = createEvent("saurosuchus_hurt");
		SAUROSUCHUS_WARN = createEvent("saurosuchus_warn");
		ISCHIGUALASTIA_IDLE = createEvent("ischigualastia_idle");
		ISCHIGUALASTIA_HURT = createEvent("ischigualastia_hurt");
		ISCHIGUALASTIA_WARN = createEvent("ischigualastia_warn");
	}

}
