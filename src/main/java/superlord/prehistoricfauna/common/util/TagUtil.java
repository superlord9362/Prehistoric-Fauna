package superlord.prehistoricfauna.common.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagUtil {
	public static TagKey<Block> blockTag(String modid, String name) {
		return TagKey.create(Registries.BLOCK, new ResourceLocation(modid, name));
	}
	
	public static TagKey<Item> itemTag(String modid, String name) {
		return TagKey.create(Registries.ITEM, new ResourceLocation(modid, name));
	}
}
