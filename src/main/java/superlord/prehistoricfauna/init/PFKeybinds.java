package superlord.prehistoricfauna.init;

import java.awt.event.KeyEvent;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import superlord.prehistoricfauna.PrehistoricFauna;

@OnlyIn(Dist.CLIENT)
public class PFKeybinds {
	
	public static KeyBinding attackKey;
	
	public static void register(final FMLClientSetupEvent event) {
		attackKey = create("attack_key", KeyEvent.VK_R);
		
		ClientRegistry.registerKeyBinding(attackKey);
	}
	
	private static KeyBinding create(String name, int key) {
		return new KeyBinding("key." + PrehistoricFauna.MOD_ID + "." + name, key, "key.category." + PrehistoricFauna.MOD_ID);
	}

}
