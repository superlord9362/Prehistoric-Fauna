package superlord.prehistoricfauna.init;

import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.tile.DidelphodonBurrowTileEntity;
import superlord.prehistoricfauna.entity.tile.PaleontologyTableTileEntity;
import superlord.prehistoricfauna.entity.tile.TileEntityPaleoscribe;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TileEntityRegistry {
	
	@SuppressWarnings("deprecation")
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, PrehistoricFauna.MODID);

	public static final RegistryObject<TileEntityType<PaleontologyTableTileEntity>> PALEONTOLOGY_TABLE = TILE_ENTITY_TYPES.register("paleontology_table_tile_entity", () -> TileEntityType.Builder.create(PaleontologyTableTileEntity::new, BlockInit.PALEONTOLOGY_TABLE).build(null));
	
	@SuppressWarnings("unchecked")
	public static final TileEntityType<TileEntityPaleoscribe> PALEOSCRIBE = registerTileEntity(TileEntityType.Builder.create(TileEntityPaleoscribe::new, BlockInit.PALEOSCRIBE), "paleoscribe");
	@SuppressWarnings("unchecked")
	public static final TileEntityType<DidelphodonBurrowTileEntity> DIDELPHODON_BURROW = registerTileEntity(TileEntityType.Builder.create(DidelphodonBurrowTileEntity::new, BlockInit.DIDELPHODON_BURROW), "didelphodon_burrow");

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static TileEntityType registerTileEntity(TileEntityType.Builder builder, String entityName) {
		ResourceLocation nameLoc = new ResourceLocation(PrehistoricFauna.MODID, entityName);
		return (TileEntityType) builder.build(null).setRegistryName(nameLoc);
	}

	@SuppressWarnings("rawtypes")
	@SubscribeEvent
	public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event) {
		try {
			for (Field f : TileEntityRegistry.class.getDeclaredFields()) {
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
