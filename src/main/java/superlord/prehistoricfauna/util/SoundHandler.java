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
	public static final SoundEvent TRICERATOPS_DEATH;
	public static final SoundEvent TYRANNOSAURUS_IDLE; 
	public static final SoundEvent TYRANNOSAURUS_HURT; 
	public static final SoundEvent TYRANNOSAURUS_WARN; 
	public static final SoundEvent TYRANNOSAURUS_DEATH;
	public static final SoundEvent ANKYLOSAURUS_IDLE; 
	public static final SoundEvent ANKYLOSAURUS_HURT; 
	public static final SoundEvent ANKYLOSAURUS_WARN; 
	public static final SoundEvent ANKYLOSAURUS_DEATH;
	public static final SoundEvent DAKOTARAPTOR_IDLE; 
	public static final SoundEvent DAKOTARAPTOR_HURT; 
	public static final SoundEvent DAKOTARAPTOR_WARN; 
	public static final SoundEvent DAKOTARAPTOR_DEATH;
	public static final SoundEvent THESCELOSAURUS_IDLE;
	public static final SoundEvent THESCELOSAURUS_HURT;
	public static final SoundEvent THESCELOSAURUS_DEATH;
	public static final SoundEvent DIDELPHODON_IDLE;
	public static final SoundEvent DIDELPHODON_HURT;
	public static final SoundEvent DIDELPHODON_DEATH;
	public static final SoundEvent BASILEMYS_IDLE;
	public static final SoundEvent BASILEMYS_HURT;
	public static final SoundEvent BASILEMYS_DEATH;
	//Morrison
	public static final SoundEvent ALLOSAURUS_IDLE;
	public static final SoundEvent ALLOSAURUS_HURT;
	public static final SoundEvent ALLOSAURUS_WARN;
	public static final SoundEvent ALLOSAURUS_DEATH;
	public static final SoundEvent STEGOSAURUS_IDLE; 
	public static final SoundEvent STEGOSAURUS_HURT; 
	public static final SoundEvent STEGOSAURUS_WARN;
	public static final SoundEvent STEGOSAURUS_DEATH;
	public static final SoundEvent CERATOSAURUS_IDLE; 
	public static final SoundEvent CERATOSAURUS_HURT; 
	public static final SoundEvent CERATOSAURUS_WARN;
	public static final SoundEvent CERATOSAURUS_DEATH;
	public static final SoundEvent DRYOSAURUS_IDLE; 
	public static final SoundEvent DRYOSAURUS_HURT; 
	public static final SoundEvent DRYOSAURUS_DEATH;
	public static final SoundEvent HESPERORNITHOIDES_IDLE;
	public static final SoundEvent HESPERORNITHOIDES_HURT;
	public static final SoundEvent HESPERORNITHOIDES_DEATH;
	public static final SoundEvent CAMARASAURUS_IDLE; 
	public static final SoundEvent CAMARASAURUS_HURT; 
	public static final SoundEvent CAMARASAURUS_WARN; 
	public static final SoundEvent CAMARASAURUS_DEATH;
	public static final SoundEvent EILENODON_HURT;
	public static final SoundEvent EILENODON_DEATH;
	//Ischigualasto
	public static final SoundEvent EXAERETODON_IDLE;
	public static final SoundEvent EXAERETODON_HURT;
	public static final SoundEvent EXAERETODON_WARN;
	public static final SoundEvent EXAERETODON_DEATH;
	public static final SoundEvent CHROMOGISAURUS_IDLE;
	public static final SoundEvent CHROMOGISAURUS_HURT;
	public static final SoundEvent CHROMOGISAURUS_DEATH;
	public static final SoundEvent HERRERASAURUS_IDLE;
	public static final SoundEvent HERRERASAURUS_HURT;
	public static final SoundEvent HERRERASAURUS_WARN;
	public static final SoundEvent HERRERASAURUS_DEATH;
	public static final SoundEvent HYPERODAPEDON_IDLE;
	public static final SoundEvent HYPERODAPEDON_HURT;
	public static final SoundEvent HYPERODAPEDON_DEATH;
	public static final SoundEvent SILLOSUCHUS_IDLE;
	public static final SoundEvent SILLOSUCHUS_HURT;
	public static final SoundEvent SILLOSUCHUS_WARN;
	public static final SoundEvent SILLOSUCHUS_DEATH;
	public static final SoundEvent SAUROSUCHUS_IDLE;
	public static final SoundEvent SAUROSUCHUS_HURT;
	public static final SoundEvent SAUROSUCHUS_WARN;
	public static final SoundEvent SAUROSUCHUS_DEATH;
	public static final SoundEvent ISCHIGUALASTIA_IDLE;
	public static final SoundEvent ISCHIGUALASTIA_HURT;
	public static final SoundEvent ISCHIGUALASTIA_WARN;
	public static final SoundEvent ISCHIGUALASTIA_DEATH;
	//Overworld
	public static final SoundEvent HENOS_IDLE;
	public static final SoundEvent HENOS_HURT;
	public static final SoundEvent HENOS_DEATH;
	public static final SoundEvent HENOS_LASER;
	
	@SubscribeEvent
	public static void registerSounds(final RegistryEvent.Register<SoundEvent> evt) {
		//Hell Creek
		evt.getRegistry().register(TRICERATOPS_HURT);
		evt.getRegistry().register(TRICERATOPS_IDLE);
		evt.getRegistry().register(TRICERATOPS_WARN);
		evt.getRegistry().register(TRICERATOPS_DEATH);
		evt.getRegistry().register(TYRANNOSAURUS_HURT);
		evt.getRegistry().register(TYRANNOSAURUS_IDLE);
		evt.getRegistry().register(TYRANNOSAURUS_WARN);
		evt.getRegistry().register(TYRANNOSAURUS_DEATH);
		evt.getRegistry().register(ANKYLOSAURUS_IDLE);
		evt.getRegistry().register(ANKYLOSAURUS_HURT);
		evt.getRegistry().register(ANKYLOSAURUS_WARN);
		evt.getRegistry().register(ANKYLOSAURUS_DEATH);
		evt.getRegistry().register(DAKOTARAPTOR_IDLE);
		evt.getRegistry().register(DAKOTARAPTOR_HURT);
		evt.getRegistry().register(DAKOTARAPTOR_WARN);
		evt.getRegistry().register(DAKOTARAPTOR_DEATH);
		evt.getRegistry().register(THESCELOSAURUS_IDLE);
		evt.getRegistry().register(THESCELOSAURUS_HURT);
		evt.getRegistry().register(THESCELOSAURUS_DEATH);
		evt.getRegistry().register(DIDELPHODON_IDLE);
		evt.getRegistry().register(DIDELPHODON_HURT);
		evt.getRegistry().register(DIDELPHODON_DEATH);
		evt.getRegistry().register(BASILEMYS_IDLE);
		evt.getRegistry().register(BASILEMYS_HURT);
		evt.getRegistry().register(BASILEMYS_DEATH);
		//Morrison
		evt.getRegistry().register(ALLOSAURUS_IDLE);
		evt.getRegistry().register(ALLOSAURUS_HURT);
		evt.getRegistry().register(ALLOSAURUS_WARN);
		evt.getRegistry().register(ALLOSAURUS_DEATH);
		evt.getRegistry().register(STEGOSAURUS_IDLE);
		evt.getRegistry().register(STEGOSAURUS_HURT);
		evt.getRegistry().register(STEGOSAURUS_WARN);
		evt.getRegistry().register(STEGOSAURUS_DEATH);
		evt.getRegistry().register(CERATOSAURUS_IDLE);
		evt.getRegistry().register(CERATOSAURUS_HURT);
		evt.getRegistry().register(CERATOSAURUS_WARN);
		evt.getRegistry().register(CERATOSAURUS_DEATH);
		evt.getRegistry().register(DRYOSAURUS_IDLE);
		evt.getRegistry().register(DRYOSAURUS_HURT);
		evt.getRegistry().register(DRYOSAURUS_DEATH);
		evt.getRegistry().register(HESPERORNITHOIDES_IDLE);
		evt.getRegistry().register(HESPERORNITHOIDES_HURT);
		evt.getRegistry().register(HESPERORNITHOIDES_DEATH);
		evt.getRegistry().register(CAMARASAURUS_IDLE);
		evt.getRegistry().register(CAMARASAURUS_HURT);
		evt.getRegistry().register(CAMARASAURUS_DEATH);
		evt.getRegistry().register(CAMARASAURUS_WARN);
		evt.getRegistry().register(EILENODON_HURT);
		evt.getRegistry().register(EILENODON_DEATH);
		//Ischigualasto
		evt.getRegistry().register(EXAERETODON_IDLE);
		evt.getRegistry().register(EXAERETODON_HURT);
		evt.getRegistry().register(EXAERETODON_WARN);
		evt.getRegistry().register(EXAERETODON_DEATH);
		evt.getRegistry().register(CHROMOGISAURUS_IDLE);
		evt.getRegistry().register(CHROMOGISAURUS_HURT);
		evt.getRegistry().register(CHROMOGISAURUS_DEATH);
		evt.getRegistry().register(HERRERASAURUS_IDLE);
		evt.getRegistry().register(HERRERASAURUS_HURT);
		evt.getRegistry().register(HERRERASAURUS_WARN);
		evt.getRegistry().register(HERRERASAURUS_DEATH);
		evt.getRegistry().register(HYPERODAPEDON_IDLE);
		evt.getRegistry().register(HYPERODAPEDON_HURT);
		evt.getRegistry().register(HYPERODAPEDON_DEATH);
		evt.getRegistry().register(SILLOSUCHUS_IDLE);
		evt.getRegistry().register(SILLOSUCHUS_HURT);
		evt.getRegistry().register(SILLOSUCHUS_DEATH);
		evt.getRegistry().register(SILLOSUCHUS_WARN);
		evt.getRegistry().register(SAUROSUCHUS_IDLE);
		evt.getRegistry().register(SAUROSUCHUS_HURT);
		evt.getRegistry().register(SAUROSUCHUS_WARN);
		evt.getRegistry().register(SAUROSUCHUS_DEATH);
		evt.getRegistry().register(ISCHIGUALASTIA_IDLE);
		evt.getRegistry().register(ISCHIGUALASTIA_HURT);
		evt.getRegistry().register(ISCHIGUALASTIA_WARN);
		evt.getRegistry().register(ISCHIGUALASTIA_DEATH);
		//Overworld
		evt.getRegistry().register(HENOS_IDLE);
		evt.getRegistry().register(HENOS_HURT);
		evt.getRegistry().register(HENOS_DEATH);
		evt.getRegistry().register(HENOS_LASER);
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
		TRICERATOPS_DEATH = createEvent("triceratops_death");
		TYRANNOSAURUS_IDLE = createEvent("tyrannosaurus_idle");
		TYRANNOSAURUS_HURT = createEvent("tyrannosaurus_hurt");
		TYRANNOSAURUS_WARN = createEvent("tyrannosaurus_warn");
		TYRANNOSAURUS_DEATH = createEvent("tyrannosaurus_death");
		ANKYLOSAURUS_IDLE = createEvent("anklyosaurus_idle");
		ANKYLOSAURUS_HURT = createEvent("ankylosaurus_hurt");
		ANKYLOSAURUS_WARN = createEvent("ankylosaurus_warn");
		ANKYLOSAURUS_DEATH = createEvent("ankylosaurus_death");
		DAKOTARAPTOR_IDLE = createEvent("dakotaraptor_idle");
		DAKOTARAPTOR_HURT = createEvent("dakotaraptor_hurt");
		DAKOTARAPTOR_WARN = createEvent("dakotaraptor_warn");
		DAKOTARAPTOR_DEATH = createEvent("dakotaraptor_death");
		THESCELOSAURUS_IDLE = createEvent("thescelosaurus_idle");
		THESCELOSAURUS_HURT = createEvent("thescelosaurus_hurt");
		THESCELOSAURUS_DEATH = createEvent("thescelosaurus_death");
		DIDELPHODON_IDLE = createEvent("didelphodon_idle");
		DIDELPHODON_HURT = createEvent("didelphodon_hurt");
		DIDELPHODON_DEATH = createEvent("didelphodon_death");
		BASILEMYS_IDLE = createEvent("basilemys_idle");
		BASILEMYS_HURT = createEvent("basilemys_hurt");
		BASILEMYS_DEATH = createEvent("basilemys_death");
		//Morrison
		ALLOSAURUS_IDLE = createEvent("allosaurus_idle");
		ALLOSAURUS_HURT = createEvent("allosaurus_hurt");
		ALLOSAURUS_WARN = createEvent("allosaurus_warn");
		ALLOSAURUS_DEATH = createEvent("allosaurus_death");
		STEGOSAURUS_IDLE = createEvent("stegosaurus_idle");
		STEGOSAURUS_HURT = createEvent("stegosaurus_hurt");
		STEGOSAURUS_WARN = createEvent("stegosaurus_warn");
		STEGOSAURUS_DEATH = createEvent("stegosaurus_death");
		CERATOSAURUS_IDLE = createEvent("ceratosaurus_idle");
		CERATOSAURUS_HURT = createEvent("ceratosaurus_hurt");
		CERATOSAURUS_WARN = createEvent("ceratosaurus_warn");
		CERATOSAURUS_DEATH = createEvent("ceratosaurus_death");
		DRYOSAURUS_IDLE = createEvent("dryosaurus_idle");
		DRYOSAURUS_HURT = createEvent("dryosaurus_hurt");
		DRYOSAURUS_DEATH = createEvent("dryosaurus_death");
		HESPERORNITHOIDES_IDLE = createEvent("hesperornithoides_idle");
		HESPERORNITHOIDES_HURT = createEvent("hesperornithoides_hurt");
		HESPERORNITHOIDES_DEATH = createEvent("hesperornithoides_death");
		CAMARASAURUS_IDLE = createEvent("camarasaurus_idle");
		CAMARASAURUS_HURT = createEvent("camarasaurus_hurt");
		CAMARASAURUS_WARN = createEvent("camarasaurus_warn");
		CAMARASAURUS_DEATH = createEvent("camarasaurus_death");
		EILENODON_HURT = createEvent("eilenodon_hurt");
		EILENODON_DEATH = createEvent("eilenodon_death");
		//Ischigualasto
		EXAERETODON_IDLE = createEvent("exaeretodon_idle");
		EXAERETODON_HURT = createEvent("exaeretodon_hurt");
		EXAERETODON_WARN = createEvent("exaeretodon_warn");
		EXAERETODON_DEATH = createEvent("exaeretodon_death");
		CHROMOGISAURUS_IDLE = createEvent("chromogisaurus_idle");
		CHROMOGISAURUS_HURT = createEvent("chromogisaurus_hurt");
		CHROMOGISAURUS_DEATH = createEvent("chromogisaurus_death");
		HERRERASAURUS_IDLE = createEvent("herrerasaurus_idle");
		HERRERASAURUS_HURT = createEvent("herrerasaurus_hurt");
		HERRERASAURUS_WARN = createEvent("herrerasaurus_warn");
		HERRERASAURUS_DEATH = createEvent("herrerasaurus_death");
		HYPERODAPEDON_IDLE = createEvent("hyperodapedon_idle");
		HYPERODAPEDON_HURT = createEvent("hyperodapedon_hurt");
		HYPERODAPEDON_DEATH = createEvent("hyperodapedon_death");
		SILLOSUCHUS_IDLE = createEvent("sillosuchus_idle");
		SILLOSUCHUS_HURT = createEvent("sillosuchus_hurt");
		SILLOSUCHUS_WARN = createEvent("sillosuchus_warn");
		SILLOSUCHUS_DEATH = createEvent("sillosuchus_death");
		SAUROSUCHUS_IDLE = createEvent("saurosuchus_idle");
		SAUROSUCHUS_HURT = createEvent("saurosuchus_hurt");
		SAUROSUCHUS_WARN = createEvent("saurosuchus_warn");
		SAUROSUCHUS_DEATH = createEvent("saurosuchus_death");
		ISCHIGUALASTIA_IDLE = createEvent("ischigualastia_idle");
		ISCHIGUALASTIA_HURT = createEvent("ischigualastia_hurt");
		ISCHIGUALASTIA_WARN = createEvent("ischigualastia_warn");
		ISCHIGUALASTIA_DEATH = createEvent("ischigualastia_death");
		//Overworld
		HENOS_IDLE = createEvent("henos_idle");
		HENOS_HURT = createEvent("henos_hurt");
		HENOS_DEATH = createEvent("henos_death");
		HENOS_LASER = createEvent("henos_laser");
	}

}
