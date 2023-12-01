package superlord.prehistoricfauna.init;

import java.awt.event.KeyEvent;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import superlord.prehistoricfauna.PrehistoricFauna;

@OnlyIn(Dist.CLIENT)
public class PFKeybinds {

	public static KeyMapping sinkKey;
	
	public static void register(final FMLClientSetupEvent event) {
		sinkKey = create("sink_key", KeyEvent.VK_CONTROL);
		
		ClientRegistry.registerKeyBinding(sinkKey);
	}
	
	private static KeyMapping create(String name, int key) {
		return new KeyMapping("key." + PrehistoricFauna.MOD_ID + "." + name, key, "key.category." + PrehistoricFauna.MOD_ID);
	}
	
}
