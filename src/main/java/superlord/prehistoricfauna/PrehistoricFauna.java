package superlord.prehistoricfauna;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.ILightReader;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import superlord.prehistoricfauna.entity.render.AnkylosaurusRenderer;
import superlord.prehistoricfauna.entity.render.RenderEntityThescelosaurus;
import superlord.prehistoricfauna.entity.render.RenderEntityTriceratops;
import superlord.prehistoricfauna.entity.render.RenderPrehistoricBoat;
import superlord.prehistoricfauna.entity.render.TyrannosaurusRenderer;
import superlord.prehistoricfauna.init.BiomeInit;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.util.CommonEvents;
import superlord.prehistoricfauna.util.PrehistoricColors;

@Mod(PrehistoricFauna.MODID)
public class PrehistoricFauna {

	public final static String MODID = "prehistoricfauna";
	public static PrehistoricFauna instance;
	
	public PrehistoricFauna() {
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::doClientStuff);
		BiomeInit.BIOMES.register(modEventBus);
		ItemInit.ITEMS.register(modEventBus);
		instance = this;
		MinecraftForge.EVENT_BUS.register(this);
	}
	private void setup(final FMLCommonSetupEvent event) {
		CommonEvents.setup();
	}
	
	private void doClientStuff(final FMLClientSetupEvent event) {
		BlockColors blockcolors = Minecraft.getInstance().getBlockColors();
		ItemColors itemcolors = Minecraft.getInstance().getItemColors();
		blockcolors.register((p_228061_0_, p_228061_1_, p_228061_2_, p_228061_3_) -> {
	         return p_228061_1_ != null && p_228061_2_ != null ? BiomeColors.getFoliageColor(p_228061_1_, p_228061_2_) : FoliageColors.getDefault();
		}, BlockInit.METASEQUOIA_LEAVES, BlockInit.CYPRESS_LEAVES);
		blockcolors.register((p_228063_0_, p_228063_1_, p_228063_2_, p_228063_3_) -> {
	         return PrehistoricColors.getAraucaria();
	      }, BlockInit.ARAUCARIA_LEAVES);
		itemcolors.register((p_210235_1_, p_210235_2_) -> {
	         BlockState blockstate = ((BlockItem)p_210235_1_.getItem()).getBlock().getDefaultState();
	         return blockcolors.getColor(blockstate, (ILightReader)null, (BlockPos)null, p_210235_2_);
	      }, BlockInit.ARAUCARIA_LEAVES, BlockInit.METASEQUOIA_LEAVES, BlockInit.CYPRESS_LEAVES);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ENTITY_THESCELOSAURUS, RenderEntityThescelosaurus::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ENTITY_TRICERATOPS, RenderEntityTriceratops::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ENTITY_ANKYLOSAURUS, AnkylosaurusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BOAT, RenderPrehistoricBoat::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ENTITY_TYRANNOSAURUS, manager -> new TyrannosaurusRenderer());
	}
	
	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
		
	}
	
	public static class PFPlants extends ItemGroup {
		public static final PFPlants instance = new PFPlants(ItemGroup.GROUPS.length, "prehistoric_plants_tab");
		
		private PFPlants(int index, String label) {
			super(index, label);
		}
		
		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.HORSETAIL);
		}
		
	}
	
	public static class PFWood extends ItemGroup {
		public static final PFWood instance = new PFWood(ItemGroup.GROUPS.length, "prehistoric_wood_tab");
		
		private PFWood(int index, String label) {
			super(index, label);
		}
		
		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.ARAUCARIA_LOG);
		}
	}
	
	public static class PFEntities extends ItemGroup {
		public static final PFEntities instance = new PFEntities(ItemGroup.GROUPS.length, "prehistoric_entities_tab");
		
		private PFEntities(int index, String label) {
			super(index, label);
		}
		
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemInit.THESCELOSAURUS_SPAWN_EGG.get());
		}
	}

}
