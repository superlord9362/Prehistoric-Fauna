package com.superlord.prehistoricfauna.util.handlers;

import com.superlord.prehistoricfauna.util.Reference;

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
    }
	
}
