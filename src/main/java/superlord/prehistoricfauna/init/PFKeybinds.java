package superlord.prehistoricfauna.init;

import java.awt.event.KeyEvent;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PFKeybinds {

	public static KeyMapping sinkKey;
	
	@SubscribeEvent
	public static void register(final RegisterKeyMappingsEvent event) {
		sinkKey = create("sink_key", KeyEvent.VK_CONTROL);
		
		event.register(sinkKey);
	}
	
	private static KeyMapping create(String name, int key) {
		return new KeyMapping("key." + PrehistoricFauna.MOD_ID + "." + name, key, "key.category." + PrehistoricFauna.MOD_ID);
	}
	
}
