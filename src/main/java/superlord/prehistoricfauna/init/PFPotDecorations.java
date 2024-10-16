package superlord.prehistoricfauna.init;

import com.google.common.collect.ImmutableMap;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PFPotDecorations {
	
	public static final DeferredRegister<String> REGISTER = DeferredRegister.create(Registries.DECORATED_POT_PATTERNS, PrehistoricFauna.MOD_ID);
	
	public static final RegistryObject<String> MONKEY = REGISTER.register("monkey_pottery_pattern", () -> PrehistoricFauna.MOD_ID + ":monkey_pottery_pattern");
	public static final RegistryObject<String> HORN = REGISTER.register("horn_pottery_pattern", () -> PrehistoricFauna.MOD_ID + ":horn_pottery_pattern");
	public static final RegistryObject<String> LEAF = REGISTER.register("leaf_pottery_pattern", () -> PrehistoricFauna.MOD_ID + ":leaf_pottery_pattern");
	public static final RegistryObject<String> BOSS = REGISTER.register("boss_pottery_pattern", () -> PrehistoricFauna.MOD_ID + ":boss_pottery_pattern");
	public static final RegistryObject<String> TYRANT = REGISTER.register("tyrant_pottery_pattern", () -> PrehistoricFauna.MOD_ID + ":tyrant_pottery_pattern");
	public static final RegistryObject<String> VINTAGE = REGISTER.register("vintage_pottery_pattern", () -> PrehistoricFauna.MOD_ID + ":vintage_pottery_pattern");
	public static final RegistryObject<String> TRILOBITE = REGISTER.register("trilobite_pottery_pattern", () -> PrehistoricFauna.MOD_ID + ":trilobite_pottery_pattern");

	public static void expandVanillaDefinitions() {
		ImmutableMap.Builder<Item, ResourceKey<String>> itemsToPot = new ImmutableMap.Builder<>();
		itemsToPot.putAll(DecoratedPotPatterns.ITEM_TO_POT_TEXTURE);
		itemsToPot.put(PFItems.MONKEY_SHERD.get(), MONKEY.getKey());
		itemsToPot.put(PFItems.HORN_SHERD.get(), HORN.getKey());
		itemsToPot.put(PFItems.LEAF_SHERD.get(), LEAF.getKey());
		itemsToPot.put(PFItems.BOSS_SHERD.get(), BOSS.getKey());
		itemsToPot.put(PFItems.TYRANT_SHERD.get(), TYRANT.getKey());
		itemsToPot.put(PFItems.VINTAGE_SHERD.get(), VINTAGE.getKey());
		itemsToPot.put(PFItems.TRILOBITE_SHERD.get(), TRILOBITE.getKey());
		DecoratedPotPatterns.ITEM_TO_POT_TEXTURE = itemsToPot.build();
	}
	
}
