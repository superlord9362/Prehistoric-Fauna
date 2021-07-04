package superlord.prehistoricfauna.init;

import java.lang.reflect.Field;

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

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PFTileEntities {
	
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, PrehistoricFauna.MOD_ID);

	public static final RegistryObject<TileEntityType<PaleontologyTableTileEntity>> PALEONTOLOGY_TABLE = TILE_ENTITY_TYPES.register("paleontology_table_tile_entity", () -> TileEntityType.Builder.create(PaleontologyTableTileEntity::new, PFBlocks.PALEONTOLOGY_TABLE).build(null));
	public static final RegistryObject<TileEntityType<PaleoscribeTileEntity>> PALEOSCRIBE = TILE_ENTITY_TYPES.register("paleoscribe_tile_entity", () -> TileEntityType.Builder.create(PaleoscribeTileEntity::new, PFBlocks.PALEOSCRIBE).build(null));
	public static final RegistryObject<TileEntityType<PFSignTileEntity>> PF_SIGNS = PFTileEntities.TILE_ENTITY_TYPES.register("pf_sign_tile", () -> TileEntityType.Builder.create(PFSignTileEntity::new, PFBlocks.ARAUCARIA_SIGN, PFBlocks.ARAUCARIA_WALL_SIGN, PFBlocks.METASEQUOIA_SIGN, PFBlocks.METASEQUOIA_WALL_SIGN, PFBlocks.HEIDIPHYLLUM_SIGN, PFBlocks.HEIDIPHYLLUM_WALL_SIGN, PFBlocks.LIRIODENDRITES_SIGN, PFBlocks.LIRIODENDRITES_WALL_SIGN, PFBlocks.PROTOJUNIPEROXYLON_SIGN, PFBlocks.PROTOJUNIPEROXYLON_WALL_SIGN, PFBlocks.PROTOPICEOXYLON_SIGN, PFBlocks.PROTOPICEOXYLON_WALL_SIGN, PFBlocks.ZAMITES_SIGN, PFBlocks.ZAMITES_WALL_SIGN).build(null));

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

}
