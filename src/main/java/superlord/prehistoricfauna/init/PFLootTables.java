package superlord.prehistoricfauna.init;

import java.util.Collections;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.resources.ResourceLocation;

public class PFLootTables {
	
	private static final Set<ResourceLocation> LOOT_TABLES = Sets.newHashSet();
	private static final Set<ResourceLocation> READ_ONLY_LOOT_TABLES = Collections.unmodifiableSet(LOOT_TABLES);
	
	public static final ResourceLocation TIME_TEMPLE_LOOT_TABLE = register("prehistoricfauna:chests/time_temple");
	public static final ResourceLocation HELL_CREEK_LOOT_TABLE = register("prehistoricfauna:chests/hell_creek_loot_table");
	public static final ResourceLocation MORRISON_LOOT_TABLE = register("prehistoricfauna:chests/morrison_loot_table");
	public static final ResourceLocation ISCHIGUALASTO_LOOT_TABLE = register("prehistoricfauna:chests/ischigualasto_loot_table");
	public static final ResourceLocation GEOLOGIST_CAMP_LOOT_TABLE = register("prehistoricfauna:chests/geologist_camp");
	
	public static final ResourceLocation PREHISTORIC_FISHING = register("prehistoricfauna:fishing");
	public static final ResourceLocation PREHISTORIC_FISHING_JUNK = register("prehistoricfauna:fishing/junk");
	public static final ResourceLocation PREHISTORIC_FISHING_TREASURE = register("prehistoricfauna:fishing/treasure");
	public static final ResourceLocation PREHISTORIC_FISH = register("prehistoricfauna:fishing/fish");

	private static ResourceLocation register(String id) {
		return register(new ResourceLocation(id));
	}
	
	private static ResourceLocation register(ResourceLocation id) {
		if (LOOT_TABLES.add(id)) {
			return id;
		} else {
			throw new IllegalArgumentException(id + " is already a registered built-in loot table");
		}
	}
	
	public static Set<ResourceLocation> func_215796_a() {
		return READ_ONLY_LOOT_TABLES;
	}

}
