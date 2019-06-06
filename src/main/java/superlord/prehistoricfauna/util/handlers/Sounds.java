package superlord.prehistoricfauna.util.handlers;

import superlord.prehistoricfauna.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Sounds {

    public static final SoundEvent TRICERATOPS_IDLE;
    public static final SoundEvent TRICERATOPS_HURT;
    public static final SoundEvent VELOCIRAPTOR_IDLE;
    public static final SoundEvent TRICERATOPS_ANGRY;
    public static final SoundEvent VELOCIRAPTOR_HURT;
    public static final SoundEvent GALLIMIMUS_IDLE;
    public static final SoundEvent GALLIMIMUS_HURT;
    public static final SoundEvent TYRANNOSAURUS_IDLE;
    public static final SoundEvent TYRANNOSAURUS_HURT;
    public static final SoundEvent DRYOSAURUS_IDLE;
    public static final SoundEvent DRYOSAURUS_HURT;
    public static final SoundEvent VELOCIRAPTOR_ANGRY;
    public static final SoundEvent TYRANNOSAURUS_ANGRY;
    public static final SoundEvent STEGOSAURUS_IDLE;
    public static final SoundEvent STEGOSAURUS_ANGRY;
    public static final SoundEvent STEGOSAURUS_HURT;
    public static final SoundEvent CAMARASAURUS_IDLE;
    public static final SoundEvent CAMARASAURUS_HURT;
    public static final SoundEvent CAMARASAURUS_ANGRY;
    public static final SoundEvent ALLOSAURUS_IDLE;
    public static final SoundEvent ALLOSAURUS_HURT;
    public static final SoundEvent PARASAUROLOPHUS_IDLE;
    public static final SoundEvent PARASAUROLOPHUS_HURT;
    public static final SoundEvent ANKYLOSAURUS_IDLE;
    public static final SoundEvent ANKYLOSAURUS_ANGRY;

    @SubscribeEvent
    public static void registerSounds(final RegistryEvent.Register<SoundEvent> evt) {
        evt.getRegistry().register(Sounds.TRICERATOPS_IDLE);
        evt.getRegistry().register(Sounds.TRICERATOPS_HURT);
        evt.getRegistry().register(Sounds.VELOCIRAPTOR_IDLE);
        evt.getRegistry().register(Sounds.TRICERATOPS_ANGRY);
        evt.getRegistry().register(Sounds.VELOCIRAPTOR_HURT);
        evt.getRegistry().register(Sounds.GALLIMIMUS_HURT);
        evt.getRegistry().register(Sounds.GALLIMIMUS_IDLE);
        evt.getRegistry().register(Sounds.TYRANNOSAURUS_IDLE);
        evt.getRegistry().register(Sounds.TYRANNOSAURUS_HURT);
        evt.getRegistry().register(Sounds.DRYOSAURUS_IDLE);
        evt.getRegistry().register(Sounds.DRYOSAURUS_HURT);
        evt.getRegistry().register(Sounds.VELOCIRAPTOR_ANGRY);
        evt.getRegistry().register(Sounds.TYRANNOSAURUS_ANGRY);
        evt.getRegistry().register(Sounds.STEGOSAURUS_IDLE);
        evt.getRegistry().register(Sounds.STEGOSAURUS_HURT);
        evt.getRegistry().register(Sounds.STEGOSAURUS_ANGRY);
        evt.getRegistry().register(Sounds.CAMARASAURUS_HURT);
        evt.getRegistry().register(Sounds.CAMARASAURUS_IDLE);
        evt.getRegistry().register(Sounds.CAMARASAURUS_ANGRY);
        evt.getRegistry().register(Sounds.ALLOSAURUS_HURT);
        evt.getRegistry().register(Sounds.ALLOSAURUS_IDLE);
        evt.getRegistry().register(Sounds.PARASAUROLOPHUS_IDLE);
        evt.getRegistry().register(Sounds.PARASAUROLOPHUS_HURT);
        evt.getRegistry().register(Sounds.ANKYLOSAURUS_IDLE);
        evt.getRegistry().register(Sounds.ANKYLOSAURUS_ANGRY);
    }

    private static SoundEvent createEvent(final String soundName) {
        final ResourceLocation soundID = new ResourceLocation(Reference.MOD_ID, soundName);
        return new SoundEvent(soundID).setRegistryName(soundID);
    }

    static {
        TRICERATOPS_IDLE = createEvent("triceratops_idle");
        TRICERATOPS_HURT = createEvent("triceratops_hurt");
        VELOCIRAPTOR_IDLE = createEvent("velociraptor_idle");
        TRICERATOPS_ANGRY = createEvent("triceratops_angry");
        VELOCIRAPTOR_HURT = createEvent("velociraptor_hurt");
        GALLIMIMUS_IDLE = createEvent("gallimimus_idle");
        GALLIMIMUS_HURT = createEvent("gallimimus_hurt");
        TYRANNOSAURUS_IDLE = createEvent("tyrannosaurus_idle");
        TYRANNOSAURUS_HURT = createEvent("tyrannosaurus_hurt");
        DRYOSAURUS_IDLE = createEvent("dryosaurus_idle");
        DRYOSAURUS_HURT = createEvent("dryosaurus_hurt");
        VELOCIRAPTOR_ANGRY = createEvent("velociraptor_angry");
        TYRANNOSAURUS_ANGRY = createEvent("tyrannosaurus_angry");
        STEGOSAURUS_IDLE = createEvent("stegosaurus_idle");
        STEGOSAURUS_ANGRY = createEvent("stegosaurus_angry");
        STEGOSAURUS_HURT = createEvent("stegosaurus_hurt");
        CAMARASAURUS_IDLE = createEvent ("camarasaurus_idle");
        CAMARASAURUS_HURT = createEvent("camarasaurus_hurt");
        CAMARASAURUS_ANGRY = createEvent("camarasaurus_angry");
        ALLOSAURUS_IDLE = createEvent("allosaurus_idle");
        ALLOSAURUS_HURT = createEvent("allosaurus_hurt");
        PARASAUROLOPHUS_IDLE = createEvent("parasaurolophus_idle");
        PARASAUROLOPHUS_HURT = createEvent("parasaurolophus_hurt");
        ANKYLOSAURUS_IDLE = createEvent("ankylosaurus_idle");
        ANKYLOSAURUS_ANGRY = createEvent("ankylosaurus_angry");
    }
}
