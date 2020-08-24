package superlord.prehistoricfauna.init;

import java.lang.reflect.Field;

import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.tile.TileEntityPaleoscribe;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TileEntityRegistry {
	
	@SuppressWarnings("unchecked")
	public static final TileEntityType<TileEntityPaleoscribe> PALEOSCRIBE = registerTileEntity(TileEntityType.Builder.create(TileEntityPaleoscribe::new, BlockInit.PALEOSCRIBE), "paleoscribe");
	
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
