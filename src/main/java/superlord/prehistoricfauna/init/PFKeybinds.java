package superlord.prehistoricfauna.init;

import java.awt.event.KeyEvent;

import net.minecraft.client.KeyMapping;

//import java.awt.event.KeyEvent;

//import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PFKeybinds {

	public static KeyMapping attackKey;
	
	@SubscribeEvent
	public static void register(final RegisterKeyMappingsEvent event) {
		attackKey = create("attack_key", KeyEvent.VK_G);
		
		event.register(attackKey);
	}
	
	private static KeyMapping create(String name, int key) {
		return new KeyMapping("key." + PrehistoricFauna.MOD_ID + "." + name, key, "key.category." + PrehistoricFauna.MOD_ID);
	}
	
}
