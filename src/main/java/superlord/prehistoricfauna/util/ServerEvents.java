package superlord.prehistoricfauna.util;

import java.lang.reflect.Field;

import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.init.ModEntityTypes;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ServerEvents {
	
	@SuppressWarnings("rawtypes")
	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
		try {
			for(Field f : ModEntityTypes.class.getDeclaredFields()) {
				Object obj = f.get(null);
				if(obj instanceof EntityType) {
					event.getRegistry().register((EntityType)obj);
				} else if(obj instanceof EntityType[]) {
					for (EntityType type : ((EntityType[]) obj)) {
						event.getRegistry().register(type);
					}
				}
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

}
