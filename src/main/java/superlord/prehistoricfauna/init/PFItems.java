package superlord.prehistoricfauna.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PFItems {
	
	public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, PrehistoricFauna.MOD_ID);
	
	//Blocks
	public static final RegistryObject<BlockItem> HORSETAIL = REGISTER.register("horsetail", () -> new BlockItem(PFBlocks.HORSETAIL.get(), new Item.Properties().tab(PrehistoricFauna.PF_DECORATION)));
	public static final RegistryObject<BlockItem> TALL_HORSETAIL = REGISTER.register("tall_horsetail", () -> new BlockItem(PFBlocks.TALL_HORSETAIL.get(), new Item.Properties().tab(PrehistoricFauna.PF_DECORATION)));
	public static final RegistryObject<BlockItem> OSMUNDA = REGISTER.register("osmunda", () -> new BlockItem(PFBlocks.OSMUNDA.get(), new Item.Properties().tab(PrehistoricFauna.PF_DECORATION)));
	public static final RegistryObject<BlockItem> TALL_OSMUNDA = REGISTER.register("tall_osmunda", () -> new BlockItem(PFBlocks.TALL_OSMUNDA.get(), new Item.Properties().tab(PrehistoricFauna.PF_DECORATION)));
	public static final RegistryObject<BlockItem> CLUBMOSS = REGISTER.register("clubmoss", () -> new BlockItem(PFBlocks.CLUBMOSS.get(), new Item.Properties().tab(PrehistoricFauna.PF_DECORATION)));
	public static final RegistryObject<BlockItem> MARCHANTIA = REGISTER.register("marchantia", () -> new BlockItem(PFBlocks.MARCHANTIA.get(), new Item.Properties().tab(PrehistoricFauna.PF_DECORATION)));
	public static final RegistryObject<BlockItem> MOSS_CARPET = REGISTER.register("moss_carpet", () -> new BlockItem(PFBlocks.MOSS_CARPET.get(), new Item.Properties().tab(PrehistoricFauna.PF_DECORATION)));
	
	public static final RegistryObject<BlockItem> METASEQUOIA_PLANKS = REGISTER.register("metasequoia_planks", () -> new BlockItem(PFBlocks.METASEQUOIA_PLANKS.get(), new Item.Properties().tab(PrehistoricFauna.PF_BUILDING)));
	public static final RegistryObject<BlockItem> METASEQUOIA_LOG = REGISTER.register("metasequoia_log", () -> new BlockItem(PFBlocks.METASEQUOIA_LOG.get(), new Item.Properties().tab(PrehistoricFauna.PF_BUILDING)));
	public static final RegistryObject<BlockItem> STRIPPED_METASEQUOIA_LOG = REGISTER.register("stripped_metasequoia_log", () -> new BlockItem(PFBlocks.STRIPPED_METASEQUOIA_LOG.get(), new Item.Properties().tab(PrehistoricFauna.PF_BUILDING)));
	public static final RegistryObject<BlockItem> METASEQUOIA_WOOD = REGISTER.register("metasequoia_wood", () -> new BlockItem(PFBlocks.METASEQUOIA_WOOD.get(), new Item.Properties().tab(PrehistoricFauna.PF_BUILDING)));
	public static final RegistryObject<BlockItem> STRIPPED_METASEQUOIA_WOOD = REGISTER.register("stripped_metasequoia_wood", () -> new BlockItem(PFBlocks.STRIPPED_METASEQUOIA_WOOD.get(), new Item.Properties().tab(PrehistoricFauna.PF_BUILDING)));
	public static final RegistryObject<BlockItem> METASEQUOIA_LEAVES = REGISTER.register("metasequoia_leaves", () -> new BlockItem(PFBlocks.METASEQUOIA_LEAVES.get(), new Item.Properties().tab(PrehistoricFauna.PF_BUILDING)));
	public static final RegistryObject<BlockItem> METASEQUOIA_SAPLING = REGISTER.register("metasequoia_sapling", () -> new BlockItem(PFBlocks.METASEQUOIA_SAPLING.get(), new Item.Properties().tab(PrehistoricFauna.PF_BUILDING)));
	public static final RegistryObject<BlockItem> METASEQUOIA_DOOR = REGISTER.register("metasequoia_door", () -> new BlockItem(PFBlocks.METASEQUOIA_DOOR.get(), new Item.Properties().tab(PrehistoricFauna.PF_BUILDING)));
	public static final RegistryObject<BlockItem> METASEQUOIA_PRESSURE_PLATE = REGISTER.register("metasequoia_pressure_plate", () -> new BlockItem(PFBlocks.METASEQUOIA_PRESSURE_PLATE.get(), new Item.Properties().tab(PrehistoricFauna.PF_BUILDING)));
	public static final RegistryObject<BlockItem> METASEQUOIA_FENCE = REGISTER.register("metasequoia_fence", () -> new BlockItem(PFBlocks.METASEQUOIA_FENCE.get(), new Item.Properties().tab(PrehistoricFauna.PF_BUILDING)));
	public static final RegistryObject<BlockItem> METASEQUOIA_TRAPDOOR = REGISTER.register("metasequoia_trapdoor", () -> new BlockItem(PFBlocks.METASEQUOIA_TRAPDOOR.get(), new Item.Properties().tab(PrehistoricFauna.PF_BUILDING)));
	public static final RegistryObject<BlockItem> METASEQUOIA_FENCE_GATE = REGISTER.register("metasequoia_fence_gate", () -> new BlockItem(PFBlocks.METASEQUOIA_FENCE_GATE.get(), new Item.Properties().tab(PrehistoricFauna.PF_BUILDING)));
	public static final RegistryObject<BlockItem> METASEQUOIA_BUTTON = REGISTER.register("metasequoia_button", () -> new BlockItem(PFBlocks.METASEQUOIA_BUTTON.get(), new Item.Properties().tab(PrehistoricFauna.PF_BUILDING)));
	public static final RegistryObject<BlockItem> METASEQUOIA_SLAB = REGISTER.register("metasequoia_slab", () -> new BlockItem(PFBlocks.METASEQUOIA_SLAB.get(), new Item.Properties().tab(PrehistoricFauna.PF_BUILDING)));
	public static final RegistryObject<BlockItem> ARAUCARIA_LOG = REGISTER.register("araucaria_log", () -> new BlockItem(PFBlocks.ARAUCARIA_LOG.get(), new Item.Properties().tab(PrehistoricFauna.PF_BUILDING)));

	
}
