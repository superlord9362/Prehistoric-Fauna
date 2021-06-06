package superlord.prehistoricfauna.util;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.GrassColors;
import net.minecraft.world.ILightReader;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.render.AllosaurusRenderer;
import superlord.prehistoricfauna.entity.render.AllosaurusSkeletonRenderer;
import superlord.prehistoricfauna.entity.render.AllosaurusSkullRenderer;
import superlord.prehistoricfauna.entity.render.AnkylosaurusRenderer;
import superlord.prehistoricfauna.entity.render.AnkylosaurusSkeletonRenderer;
import superlord.prehistoricfauna.entity.render.AnkylosaurusSkullRenderer;
import superlord.prehistoricfauna.entity.render.BasilemysRenderer;
import superlord.prehistoricfauna.entity.render.BossRenderer;
import superlord.prehistoricfauna.entity.render.CamarasaurusRenderer;
import superlord.prehistoricfauna.entity.render.CeratosaurusRenderer;
import superlord.prehistoricfauna.entity.render.CeratosaurusSkeletonRenderer;
import superlord.prehistoricfauna.entity.render.CeratosaurusSkullRenderer;
import superlord.prehistoricfauna.entity.render.ChromogisaurusRenderer;
import superlord.prehistoricfauna.entity.render.DakotaraptorRenderer;
import superlord.prehistoricfauna.entity.render.DidelphodonRenderer;
import superlord.prehistoricfauna.entity.render.DryosaurusRenderer;
import superlord.prehistoricfauna.entity.render.EilenodonRenderer;
import superlord.prehistoricfauna.entity.render.ExaeretodonRenderer;
import superlord.prehistoricfauna.entity.render.HerrerasaurusRenderer;
import superlord.prehistoricfauna.entity.render.HerrerasaurusSkeletonRenderer;
import superlord.prehistoricfauna.entity.render.HerrerasaurusSkullRenderer;
import superlord.prehistoricfauna.entity.render.HesperornithoidesRenderer;
import superlord.prehistoricfauna.entity.render.HyperodapedonRenderer;
import superlord.prehistoricfauna.entity.render.IschigualastiaRenderer;
import superlord.prehistoricfauna.entity.render.IschigualastiaSkeletonRenderer;
import superlord.prehistoricfauna.entity.render.IschigualastiaSkullRenderer;
import superlord.prehistoricfauna.entity.render.PaleontologyTableScreen;
import superlord.prehistoricfauna.entity.render.PaleopaintingRenderer;
import superlord.prehistoricfauna.entity.render.PaleoscribeScreen;
import superlord.prehistoricfauna.entity.render.PrehistoricBoatRenderer;
import superlord.prehistoricfauna.entity.render.SaurosuchusRenderer;
import superlord.prehistoricfauna.entity.render.SaurosuchusSkeletonRenderer;
import superlord.prehistoricfauna.entity.render.SaurosuchusSkullRenderer;
import superlord.prehistoricfauna.entity.render.SillosuchusRenderer;
import superlord.prehistoricfauna.entity.render.StegosaurusRenderer;
import superlord.prehistoricfauna.entity.render.StegosaurusSkeletonRenderer;
import superlord.prehistoricfauna.entity.render.StegosaurusSkullRenderer;
import superlord.prehistoricfauna.entity.render.ThescelosaurusRenderer;
import superlord.prehistoricfauna.entity.render.TriceratopsRenderer;
import superlord.prehistoricfauna.entity.render.TriceratopsSkeletonRenderer;
import superlord.prehistoricfauna.entity.render.TriceratopsSkullRenderer;
import superlord.prehistoricfauna.entity.render.TyrannosaurusRenderer;
import superlord.prehistoricfauna.entity.render.TyrannosaurusSkeletonRenderer;
import superlord.prehistoricfauna.entity.render.TyrannosaurusSkullRenderer;
import superlord.prehistoricfauna.entity.render.WallFossilRenderer;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ContainerRegistry;
import superlord.prehistoricfauna.init.ModEntityTypes;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
	
	@SuppressWarnings("unchecked")
	@SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
		BlockColors blockcolors = Minecraft.getInstance().getBlockColors();
		ItemColors itemcolors = Minecraft.getInstance().getItemColors();
		blockcolors.register((p_228064_0_, p_228064_1_, p_228064_2_, p_228064_3_) -> {
			return p_228064_1_ != null && p_228064_2_ != null ? BiomeColors.getGrassColor(p_228064_1_, p_228064_2_) : GrassColors.get(0.5D, 1.0D);
		}, BlockInit.CONIOPTERIS, BlockInit.CLADOPHLEBIS, BlockInit.POTTED_CLADOPHLEBIS);
		blockcolors.register((p_228061_0_, p_228061_1_, p_228061_2_, p_228061_3_) -> {
			return p_228061_1_ != null && p_228061_2_ != null ? BiomeColors.getFoliageColor(p_228061_1_, p_228061_2_) : FoliageColors.getDefault();
		}, BlockInit.METASEQUOIA_LEAVES, BlockInit.PROTOPICEOXYLON_LEAVES, BlockInit.PROTOJUNIPEROXYLON_LEAVES, BlockInit.METASEQUOIA_LEAF_CARPET.get(), BlockInit.PROTOPICEOXYLON_LEAF_CARPET.get(), BlockInit.PROTOJUNIPEROXYLON_LEAF_CARPET.get());
		blockcolors.register((p_228063_0_, p_228063_1_, p_228063_2_, p_228063_3_) -> {
			return PrehistoricColors.getAraucaria();
		}, BlockInit.ARAUCARIA_LEAVES, BlockInit.ARAUCARIA_LEAF_CARPET.get());
		itemcolors.register((p_210235_1_, p_210235_2_) -> {
			BlockState blockstate = ((BlockItem) p_210235_1_.getItem()).getBlock().getDefaultState();
			return blockcolors.getColor(blockstate, (ILightReader) null, (BlockPos) null, p_210235_2_);
		}, BlockInit.ARAUCARIA_LEAVES, BlockInit.METASEQUOIA_LEAVES, BlockInit.CONIOPTERIS, BlockInit.PROTOPICEOXYLON_LEAVES, BlockInit.PROTOJUNIPEROXYLON_LEAVES, BlockInit.CLADOPHLEBIS, BlockInit.ARAUCARIA_LEAF_CARPET.get(), BlockInit.METASEQUOIA_LEAF_CARPET.get(), BlockInit.PROTOPICEOXYLON_LEAF_CARPET.get(), BlockInit.PROTOJUNIPEROXYLON_LEAF_CARPET.get());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.THESCELOSAURUS_ENTITY, ThescelosaurusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TRICERATOPS_ENTITY, manager -> new TriceratopsRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ANKYLOSAURUS_ENTITY, AnkylosaurusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TYRANNOSAURUS_ENTITY, manager -> new TyrannosaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BASILEMYS_ENTITY, manager -> new BasilemysRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DAKOTARAPTOR_ENTITY, manager -> new DakotaraptorRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ALLOSAURUS_ENTITY, manager -> new AllosaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.STEGOSAURUS_ENTITY, StegosaurusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CERATOSAURUS_ENTITY, manager -> new CeratosaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DRYOSAURUS_ENTITY, DryosaurusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HESPERORNITHOIDES_ENTITY, manager -> new HesperornithoidesRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.EILENODON_ENTITY, manager -> new EilenodonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CAMARASAURUS_ENTITY, manager -> new CamarasaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DIDELPHODON_ENTITY, manager -> new DidelphodonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BOAT, PrehistoricBoatRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.EXAERETODON_ENTITY, manager -> new ExaeretodonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CHROMOGISAURUS_ENTITY, manager -> new ChromogisaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HERRERASAURUS_ENTITY, manager -> new HerrerasaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HYPERODAPEDON_ENTITY, manager -> new HyperodapedonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SILLOSUCHUS_ENTITY, manager -> new SillosuchusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TIME_GUARDIAN_ENTITY, BossRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SAUROSUCHUS_ENTITY, manager -> new SaurosuchusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ISCHIGUALASTIA_ENTITY, manager -> new IschigualastiaRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.WALL_FOSSIL, WallFossilRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TYRANNOSAURUS_SKULL, TyrannosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ANKYLOSAURUS_SKULL, AnkylosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TRICERATOPS_SKULL, TriceratopsSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HERRERASAURUS_SKULL, HerrerasaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SAUROSUCHUS_SKULL, SaurosuchusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.STEGOSAURUS_SKULL, StegosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CERATOSAURUS_SKULL, CeratosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TYRANNOSAURUS_SKELETON, manager -> new TyrannosaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TRICERATOPS_SKELETON, manager -> new TriceratopsSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ANKYLOSAURUS_SKELETON, manager -> new AnkylosaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.CERATOSAURUS_SKELETON, manager -> new CeratosaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ALLOSAURUS_SKELETON, manager -> new AllosaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HERRERASAURUS_SKELETON, manager -> new HerrerasaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ISCHIGUALASTIA_SKELETON, manager -> new IschigualastiaSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SAUROSUCHUS_SKELETON, manager -> new SaurosuchusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.STEGOSAURUS_SKELETON, manager -> new StegosaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ALLOSAURUS_SKULL, AllosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ISCHIGUALASTIA_SKULL, IschigualastiaSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PALEOPAINTING, PaleopaintingRenderer::new);
		ScreenManager.registerFactory(ContainerRegistry.PALEONTOLOGY_TABLE.get(), PaleontologyTableScreen::new);
		ScreenManager.registerFactory(ContainerRegistry.PALEOSCRIBE_CONTAINER, PaleoscribeScreen::new);
	}
	
	@SubscribeEvent
	public static void onStitchEvent(TextureStitchEvent.Pre event) {
		ResourceLocation stitching = event.getMap().getTextureLocation();
		if (!stitching.equals(Atlases.SIGN_ATLAS))
			return;

		PFWoodTypes.getValues().forEach(woodType -> event.addSprite(new ResourceLocation(PrehistoricFauna.MODID, "entities/signs/" + woodType.getName())));
	}

}
