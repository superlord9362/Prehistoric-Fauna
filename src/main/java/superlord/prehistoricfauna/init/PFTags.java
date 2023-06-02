package superlord.prehistoricfauna.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PFTags {

    public static final TagKey<Item> FOSSILS = registerItemTag("fossils");
    public static final TagKey<Block> HENOSTONE = registerBlockTag("henostone");
    public static final TagKey<Item> HENOSTONE_ITEM = registerItemTag("henostone");

	private static TagKey<Item> registerItemTag(String name) {
		return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(PrehistoricFauna.MOD_ID, name));
	}
	
	private static TagKey<Block> registerBlockTag(String name) {
		return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(PrehistoricFauna.MOD_ID, name));
	}

}
