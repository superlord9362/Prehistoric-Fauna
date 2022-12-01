package superlord.prehistoricfauna.init;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entities.tile.PFSignTileEntity;
import superlord.prehistoricfauna.common.entities.tile.PaleontologyTableTileEntity;
import superlord.prehistoricfauna.common.entities.tile.PaleoscribeTileEntity;
import superlord.prehistoricfauna.common.util.RegistryHelper;
import superlord.prehistoricfauna.compat.PFBeehiveBlock;
import superlord.prehistoricfauna.compat.PFBeehiveTileEntity;
import superlord.prehistoricfauna.compat.PFChestBlock;
import superlord.prehistoricfauna.compat.PFChestTileEntity;
import superlord.prehistoricfauna.compat.PFTrappedChestBlock;
import superlord.prehistoricfauna.compat.PFTrappedChestTileEntity;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PFTileEntities {
	
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, PrehistoricFauna.MOD_ID);
	public static final RegistryHelper HELPER = PrehistoricFauna.REGISTRY_HELPER;
	
	public static final RegistryObject<TileEntityType<PaleontologyTableTileEntity>> PALEONTOLOGY_TABLE = TILE_ENTITY_TYPES.register("paleontology_table_tile_entity", () -> TileEntityType.Builder.create(PaleontologyTableTileEntity::new, PFBlocks.PALEONTOLOGY_TABLE).build(null));
	public static final RegistryObject<TileEntityType<PaleoscribeTileEntity>> PALEOSCRIBE = TILE_ENTITY_TYPES.register("paleoscribe_tile_entity", () -> TileEntityType.Builder.create(PaleoscribeTileEntity::new, PFBlocks.PALEOSCRIBE).build(null));
	public static final RegistryObject<TileEntityType<PFSignTileEntity>> PF_SIGNS = TILE_ENTITY_TYPES.register("pf_sign_tile", () -> TileEntityType.Builder.create(PFSignTileEntity::new, PFBlocks.ARAUCARIA_SIGN, PFBlocks.ARAUCARIA_WALL_SIGN, PFBlocks.METASEQUOIA_SIGN, PFBlocks.METASEQUOIA_WALL_SIGN, PFBlocks.HEIDIPHYLLUM_SIGN, PFBlocks.HEIDIPHYLLUM_WALL_SIGN, PFBlocks.LIRIODENDRITES_SIGN, PFBlocks.LIRIODENDRITES_WALL_SIGN, PFBlocks.PROTOJUNIPEROXYLON_SIGN, PFBlocks.PROTOJUNIPEROXYLON_WALL_SIGN, PFBlocks.PROTOPICEOXYLON_SIGN, PFBlocks.PROTOPICEOXYLON_WALL_SIGN, PFBlocks.ZAMITES_SIGN, PFBlocks.ZAMITES_WALL_SIGN, PFBlocks.GINKGO_SIGN, PFBlocks.GINKGO_WALL_SIGN, PFBlocks.TROCHODENDROIDES_SIGN, PFBlocks.TROCHODENDROIDES_WALL_SIGN, PFBlocks.BRACHYPHYLLUM_SIGN, PFBlocks.BRACHYPHYLLUM_WALL_SIGN, PFBlocks.AGATHOXYLON_SIGN, PFBlocks.AGATHOXYLON_WALL_SIGN, PFBlocks.WOODWORTHIA_SIGN, PFBlocks.WOODWORTHIA_WALL_SIGN, PFBlocks.SCHILDERIA_SIGN, PFBlocks.SCHILDERIA_WALL_SIGN, PFBlocks.NEOCALAMITES_SIGN, PFBlocks.NEOCALAMITES_WALL_SIGN).build(null));
	public static final RegistryObject<TileEntityType<PFBeehiveTileEntity>> BEEHIVE = HELPER.createTileEntity("beehive", PFBeehiveTileEntity::new, () -> collectBlocks(PFBeehiveBlock.class));
	public static final RegistryObject<TileEntityType<PFChestTileEntity>> CHEST = HELPER.createTileEntity("chest", PFChestTileEntity::new, () -> collectBlocks(PFChestBlock.class));
	public static final RegistryObject<TileEntityType<PFTrappedChestTileEntity>> TRAPPED_CHEST = HELPER.createTileEntity("trapped_chest", PFTrappedChestTileEntity::new, () -> collectBlocks(PFTrappedChestBlock.class));

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static TileEntityType registerTileEntity(TileEntityType.Builder builder, String entityName) {
		ResourceLocation nameLoc = new ResourceLocation(PrehistoricFauna.MOD_ID, entityName);
		return (TileEntityType) builder.build(null).setRegistryName(nameLoc);
	}

	@SuppressWarnings("rawtypes")
	@SubscribeEvent
	public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event) {
		try {
			for (Field f : PFTileEntities.class.getDeclaredFields()) {
				Object obj = f.get(null);
				if (obj instanceof TileEntityType) {
					event.getRegistry().register((TileEntityType) obj);
				} else if (obj instanceof TileEntityType[]) {
					for (TileEntityType te : (TileEntityType[]) obj) {
						event.getRegistry().register(te);
					}
				}
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static Block[] collectBlocks(Class<?> blockClass) {
		return ForgeRegistries.BLOCKS.getValues().stream().filter(blockClass::isInstance).toArray(Block[]::new);
	}

}
