package superlord.prehistoricfauna.client;

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
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.render.PaleopaintingRenderer;
import superlord.prehistoricfauna.client.render.PrehistoricBoatRenderer;
import superlord.prehistoricfauna.client.render.WallFossilRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.AepyornithomimusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.CitipatiRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.PinacosaurusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.PlesiohadrosRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.ProtoceratopsRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.TelmasaurusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.VelociraptorRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.AnkylosaurusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.BasilemysRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.DakotaraptorRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.DidelphodonRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.ThescelosaurusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.TriceratopsRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.TyrannosaurusRenderer;
import superlord.prehistoricfauna.client.render.fish.ArganodusRenderer;
import superlord.prehistoricfauna.client.render.fish.CeratodusRenderer;
import superlord.prehistoricfauna.client.render.fish.ChinleaRenderer;
import superlord.prehistoricfauna.client.render.fish.CyclurusRenderer;
import superlord.prehistoricfauna.client.render.fish.GarRenderer;
import superlord.prehistoricfauna.client.render.fish.MooreodontusRenderer;
import superlord.prehistoricfauna.client.render.fish.MyledaphusRenderer;
import superlord.prehistoricfauna.client.render.fish.PotamoceratodusRenderer;
import superlord.prehistoricfauna.client.render.fish.SaurichthysRenderer;
import superlord.prehistoricfauna.client.render.fossil.AllosaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.AllosaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.AnkylosaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.AnkylosaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.CeratosaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.CeratosaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.CoelophysisSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.CoelophysisSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.DesmatosuchusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.DesmatosuchusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.DilophosaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.DilophosaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.HerrerasaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.HerrerasaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.IschigualastiaSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.IschigualastiaSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.PlesiohadrosSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.PlesiohadrosSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.PostosuchusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.PostosuchusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.ProtoceratopsSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.ProtoceratopsSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.SarahsaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.SarahsaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.SaurosuchusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.SaurosuchusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.ScelidosaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.ScelidosaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.StegosaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.StegosaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.TriceratopsSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.TriceratopsSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.TyrannosaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.TyrannosaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.VelociraptorSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.VelociraptorSkullRenderer;
import superlord.prehistoricfauna.client.render.henos.BossRenderer;
import superlord.prehistoricfauna.client.render.henos.LandSentinelRenderer;
import superlord.prehistoricfauna.client.render.henos.TrilobiteSentinelRenderer;
import superlord.prehistoricfauna.client.render.jurassic.kayenta.CalsoyasuchusRenderer;
import superlord.prehistoricfauna.client.render.jurassic.kayenta.DilophosaurusRenderer;
import superlord.prehistoricfauna.client.render.jurassic.kayenta.KayentatheriumRenderer;
import superlord.prehistoricfauna.client.render.jurassic.kayenta.MegapnosaurusRenderer;
import superlord.prehistoricfauna.client.render.jurassic.kayenta.SarahsaurusRenderer;
import superlord.prehistoricfauna.client.render.jurassic.kayenta.ScelidosaurusRenderer;
import superlord.prehistoricfauna.client.render.jurassic.kayenta.ScutellosaurusRenderer;
import superlord.prehistoricfauna.client.render.jurassic.morrison.AllosaurusRenderer;
import superlord.prehistoricfauna.client.render.jurassic.morrison.CamarasaurusRenderer;
import superlord.prehistoricfauna.client.render.jurassic.morrison.CeratosaurusRenderer;
import superlord.prehistoricfauna.client.render.jurassic.morrison.DryosaurusRenderer;
import superlord.prehistoricfauna.client.render.jurassic.morrison.EilenodonRenderer;
import superlord.prehistoricfauna.client.render.jurassic.morrison.HesperornithoidesRenderer;
import superlord.prehistoricfauna.client.render.jurassic.morrison.StegosaurusRenderer;
import superlord.prehistoricfauna.client.render.tileentity.PFSignTileEntityRenderer;
import superlord.prehistoricfauna.client.render.tileentity.gui.PaleontologyTableScreen;
import superlord.prehistoricfauna.client.render.tileentity.gui.PaleoscribeScreen;
import superlord.prehistoricfauna.client.render.triassic.chinle.CoelophysisRenderer;
import superlord.prehistoricfauna.client.render.triassic.chinle.DesmatosuchusRenderer;
import superlord.prehistoricfauna.client.render.triassic.chinle.PlaceriasRenderer;
import superlord.prehistoricfauna.client.render.triassic.chinle.PoposaurusRenderer;
import superlord.prehistoricfauna.client.render.triassic.chinle.PostosuchusRenderer;
import superlord.prehistoricfauna.client.render.triassic.chinle.TrilophosaurusRenderer;
import superlord.prehistoricfauna.client.render.triassic.chinle.TypothoraxRenderer;
import superlord.prehistoricfauna.client.render.triassic.ischigualasto.ChromogisaurusRenderer;
import superlord.prehistoricfauna.client.render.triassic.ischigualasto.ExaeretodonRenderer;
import superlord.prehistoricfauna.client.render.triassic.ischigualasto.HerrerasaurusRenderer;
import superlord.prehistoricfauna.client.render.triassic.ischigualasto.HyperodapedonRenderer;
import superlord.prehistoricfauna.client.render.triassic.ischigualasto.IschigualastiaRenderer;
import superlord.prehistoricfauna.client.render.triassic.ischigualasto.SaurosuchusRenderer;
import superlord.prehistoricfauna.client.render.triassic.ischigualasto.SillosuchusRenderer;
import superlord.prehistoricfauna.common.util.PFWoodTypes;
import superlord.prehistoricfauna.compat.PFChestTileEntityRenderer;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFContainers;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFKeybinds;
import superlord.prehistoricfauna.init.PFTileEntities;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
		
	@SuppressWarnings("unchecked")
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		PFKeybinds.register(event);
		BlockColors blockcolors = Minecraft.getInstance().getBlockColors();
		ItemColors itemcolors = Minecraft.getInstance().getItemColors();
		blockcolors.register((p_228064_0_, p_228064_1_, p_228064_2_, p_228064_3_) -> {
			return p_228064_1_ != null && p_228064_2_ != null ? BiomeColors.getGrassColor(p_228064_1_, p_228064_2_) : GrassColors.get(0.5D, 1.0D);
		}, PFBlocks.CONIOPTERIS);
		blockcolors.register((p_228061_0_, p_228061_1_, p_228061_2_, p_228061_3_) -> {
			return p_228061_1_ != null && p_228061_2_ != null ? BiomeColors.getFoliageColor(p_228061_1_, p_228061_2_) : FoliageColors.getDefault();
		}, PFBlocks.METASEQUOIA_LEAVES, PFBlocks.PROTOPICEOXYLON_LEAVES, PFBlocks.PROTOJUNIPEROXYLON_LEAVES, PFBlocks.METASEQUOIA_LEAF_CARPET.get(), PFBlocks.PROTOPICEOXYLON_LEAF_CARPET.get(), PFBlocks.PROTOJUNIPEROXYLON_LEAF_CARPET.get());
		blockcolors.register((p_228063_0_, p_228063_1_, p_228063_2_, p_228063_3_) -> {
			return 0x45AF45;
		}, PFBlocks.ARAUCARIA_LEAVES, PFBlocks.ARAUCARIA_LEAF_CARPET.get(), PFBlocks.ARAUCARIA_HEDGE.get());
		blockcolors.register((state, reader, pos, color) -> {
			return reader != null && pos != null ? BiomeColors.getFoliageColor(reader, pos) : FoliageColors.getDefault();
		}, PFBlocks.ARAUCARIA_LEAVES, PFBlocks.METASEQUOIA_LEAVES, PFBlocks.CONIOPTERIS, PFBlocks.PROTOPICEOXYLON_LEAVES, PFBlocks.PROTOJUNIPEROXYLON_LEAVES, PFBlocks.CLADOPHLEBIS, PFBlocks.ARAUCARIA_LEAF_CARPET.get(), PFBlocks.METASEQUOIA_LEAF_CARPET.get(), PFBlocks.PROTOPICEOXYLON_LEAF_CARPET.get(), PFBlocks.PROTOJUNIPEROXYLON_LEAF_CARPET.get(), PFBlocks.METASEQUOIA_HEDGE.get(), PFBlocks.PROTOPICEOXYLON_HEDGE.get(), PFBlocks.LIRIODENDRITES_HEDGE.get(), PFBlocks.PROTOJUNIPEROXYLON_HEDGE.get(), PFBlocks.HEIDIPHYLLUM_HEDGE.get(), PFBlocks.AGATHOXYLON_LEAF_CARPET.get(), PFBlocks.AGATHOXYLON_LEAVES, PFBlocks.AGATHOXYLON_HEDGE.get(), PFBlocks.CLADOPHLEBIS);
		itemcolors.register((p_210235_1_, p_210235_2_) -> {
			BlockState blockstate = ((BlockItem) p_210235_1_.getItem()).getBlock().getDefaultState();
			return blockcolors.getColor(blockstate, (IBlockDisplayReader) null, (BlockPos) null, p_210235_2_);
		}, PFBlocks.ARAUCARIA_LEAVES, PFBlocks.METASEQUOIA_LEAVES, PFBlocks.CONIOPTERIS, PFBlocks.PROTOPICEOXYLON_LEAVES, PFBlocks.PROTOJUNIPEROXYLON_LEAVES, PFBlocks.CLADOPHLEBIS, PFBlocks.ARAUCARIA_LEAF_CARPET.get(), PFBlocks.METASEQUOIA_LEAF_CARPET.get(), PFBlocks.PROTOPICEOXYLON_LEAF_CARPET.get(), PFBlocks.PROTOJUNIPEROXYLON_LEAF_CARPET.get(), PFBlocks.METASEQUOIA_HEDGE.get(), PFBlocks.PROTOPICEOXYLON_HEDGE.get(), PFBlocks.LIRIODENDRITES_HEDGE.get(), PFBlocks.PROTOJUNIPEROXYLON_HEDGE.get(), PFBlocks.HEIDIPHYLLUM_HEDGE.get(), PFBlocks.ARAUCARIA_HEDGE.get(), PFBlocks.AGATHOXYLON_LEAF_CARPET.get(), PFBlocks.AGATHOXYLON_LEAVES, PFBlocks.AGATHOXYLON_HEDGE.get(), PFBlocks.CLADOPHLEBIS);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.THESCELOSAURUS_ENTITY, ThescelosaurusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.TRICERATOPS_ENTITY, manager -> new TriceratopsRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.ANKYLOSAURUS_ENTITY, AnkylosaurusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.PINACOSAURUS_ENTITY, PinacosaurusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.PLESIOHADROS_ENTITY, PlesiohadrosRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.TYRANNOSAURUS_ENTITY, manager -> new TyrannosaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.BASILEMYS_ENTITY, manager -> new BasilemysRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.DAKOTARAPTOR_ENTITY, manager -> new DakotaraptorRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.VELOCIRAPTOR_ENTITY, manager -> new VelociraptorRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.ALLOSAURUS_ENTITY, manager -> new AllosaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.STEGOSAURUS_ENTITY, StegosaurusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.CERATOSAURUS_ENTITY, manager -> new CeratosaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.DRYOSAURUS_ENTITY, DryosaurusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.CITIPATI_ENTITY, CitipatiRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.HESPERORNITHOIDES_ENTITY, manager -> new HesperornithoidesRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.EILENODON_ENTITY, manager -> new EilenodonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.CAMARASAURUS_ENTITY, manager -> new CamarasaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.DIDELPHODON_ENTITY, DidelphodonRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.PROTOCERATOPS_ENTITY, ProtoceratopsRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.AEPYORNITHOMIMUS_ENTITY, manager -> new AepyornithomimusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.TRILOPHOSAURUS_ENTITY, manager -> new TrilophosaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.DESMATOSUCHUS_ENTITY, manager -> new DesmatosuchusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.POSTOSUCHUS_ENTITY, manager -> new PostosuchusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.BOAT, PrehistoricBoatRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.EXAERETODON_ENTITY, manager -> new ExaeretodonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.KAYENTATHERIUM_ENTITY, manager -> new KayentatheriumRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.CHROMOGISAURUS_ENTITY, manager -> new ChromogisaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.SCUTELLOSAURUS_ENTITY, manager -> new ScutellosaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.HERRERASAURUS_ENTITY, manager -> new HerrerasaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.MEGAPNOSAURUS_ENTITY, manager -> new MegapnosaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.HYPERODAPEDON_ENTITY, manager -> new HyperodapedonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.SILLOSUCHUS_ENTITY, manager -> new SillosuchusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.TIME_GUARDIAN_ENTITY, BossRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.COELOPHYSIS_ENTITY, manager -> new CoelophysisRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.TYPOTHORAX_ENTITY, manager -> new TypothoraxRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.SAUROSUCHUS_ENTITY, manager -> new SaurosuchusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.ISCHIGUALASTIA_ENTITY, manager -> new IschigualastiaRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.POPOSAURUS_ENTITY, manager -> new PoposaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.PLACERIAS_ENTITY, manager -> new PlaceriasRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.WALL_FOSSIL, WallFossilRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.TYRANNOSAURUS_SKULL, TyrannosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.ANKYLOSAURUS_SKULL, AnkylosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.TRICERATOPS_SKULL, TriceratopsSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.DESMATOSUCHUS_SKULL, DesmatosuchusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.HERRERASAURUS_SKULL, HerrerasaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.SAUROSUCHUS_SKULL, SaurosuchusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.STEGOSAURUS_SKULL, StegosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.CERATOSAURUS_SKULL, CeratosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.TYRANNOSAURUS_SKELETON, manager -> new TyrannosaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.TRICERATOPS_SKELETON, manager -> new TriceratopsSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.ANKYLOSAURUS_SKELETON, manager -> new AnkylosaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.CERATOSAURUS_SKELETON, manager -> new CeratosaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.ALLOSAURUS_SKELETON, manager -> new AllosaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.HERRERASAURUS_SKELETON, manager -> new HerrerasaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.ISCHIGUALASTIA_SKELETON, manager -> new IschigualastiaSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.SAUROSUCHUS_SKELETON, manager -> new SaurosuchusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.STEGOSAURUS_SKELETON, manager -> new StegosaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.VELOCIRAPTOR_SKELETON, manager -> new VelociraptorSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.PROTOCERATOPS_SKELETON, manager -> new ProtoceratopsSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.COELOPHYSIS_SKELETON, manager -> new CoelophysisSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.POSTOSUCHUS_SKELETON, manager -> new PostosuchusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.SARAHSAURUS_SKELETON, manager -> new SarahsaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.ALLOSAURUS_SKULL, AllosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.ISCHIGUALASTIA_SKULL, IschigualastiaSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.DILOPHOSAURUS_SKULL, DilophosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.VELOCIRAPTOR_SKULL, VelociraptorSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.PALEOPAINTING, PaleopaintingRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.TRILOBITE_SENTINEL_ENTITY, manager -> new TrilobiteSentinelRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.LAND_SENTINEL_ENTITY, manager -> new LandSentinelRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.MYLEDAPHUS, MyledaphusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.GAR, manager -> new GarRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.CYCLURUS, manager -> new CyclurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.CERATODUS, manager -> new CeratodusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.POTAMOCERATODUS, manager -> new PotamoceratodusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.TELMASAURUS_ENTITY, manager -> new TelmasaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.PROTOCERATOPS_SKULL, ProtoceratopsSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.POSTOSUCHUS_SKULL, PostosuchusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.PLESIOHADROS_SKULL, PlesiohadrosSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.COELOPHYSIS_SKULL, CoelophysisSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.DILOPHOSAURUS_ENTITY, manager -> new DilophosaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.CALSOYASUCHUS_ENTITY, manager -> new CalsoyasuchusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.SARAHSAURUS_ENTITY, manager -> new SarahsaurusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.SCELIDOSAURUS_ENTITY, ScelidosaurusRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.SCELIDOSAURUS_SKULL, ScelidosaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.SARAHSAURUS_SKULL, SarahsaurusSkullRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.PLESIOHADROS_SKELETON, manager -> new PlesiohadrosSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.DESMATOSUCHUS_SKELETON, manager -> new DesmatosuchusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.DILOPHOSAURUS_SKELETON, manager -> new DilophosaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.SCELIDOSAURUS_SKELETON, manager -> new ScelidosaurusSkeletonRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.ARGANODUS_ENTITY, manager -> new ArganodusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.CHINLEA_ENTITY, manager -> new ChinleaRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.MOOREODONTUS_ENTITY, manager -> new MooreodontusRenderer());
		RenderingRegistry.registerEntityRenderingHandler(PFEntities.SAURICHTHYS_ENTITY, manager -> new SaurichthysRenderer());
		ScreenManager.registerFactory(PFContainers.PALEONTOLOGY_TABLE.get(), PaleontologyTableScreen::new);
		ScreenManager.registerFactory(PFContainers.PALEOSCRIBE_CONTAINER, PaleoscribeScreen::new);
		ClientRegistry.bindTileEntityRenderer(PFTileEntities.CHEST.get(), PFChestTileEntityRenderer::new);
		ClientRegistry.bindTileEntityRenderer(PFTileEntities.TRAPPED_CHEST.get(), PFChestTileEntityRenderer::new);
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		ClientRegistry.bindTileEntityRenderer(PFTileEntities.PF_SIGNS.get(), PFSignTileEntityRenderer::new);
	}

	@SubscribeEvent
	public static void onStitchEvent(TextureStitchEvent.Pre event)
	{
		ResourceLocation stitching = event.getMap().getTextureLocation();
		if (!stitching.equals(Atlases.SIGN_ATLAS))
			return;

		PFWoodTypes.getValues().forEach(woodType -> event.addSprite(new ResourceLocation(PrehistoricFauna.MOD_ID, "entity/signs/" + woodType.getName())));
	}

}
