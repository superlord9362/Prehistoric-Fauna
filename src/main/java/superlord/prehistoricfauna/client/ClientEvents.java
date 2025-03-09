package superlord.prehistoricfauna.client;

import java.util.Optional;
import java.util.Set;

import org.joml.Matrix4f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.resource.PathPackResources;
import net.minecraftforge.resource.ResourcePackLoader;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.gui.GuiPaleo;
import superlord.prehistoricfauna.client.gui.GuiPaleontologyTable;
import superlord.prehistoricfauna.client.model.armor.*;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.*;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.*;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.*;
import superlord.prehistoricfauna.client.model.fish.*;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.*;
import superlord.prehistoricfauna.client.model.fossil.jurassic.*;
import superlord.prehistoricfauna.client.model.fossil.triassic.*;
import superlord.prehistoricfauna.client.model.henos.*;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.*;
import superlord.prehistoricfauna.client.model.jurassic.morrison.*;
import superlord.prehistoricfauna.client.model.triassic.chinle.*;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.*;
import superlord.prehistoricfauna.client.render.*;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.*;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.*;
import superlord.prehistoricfauna.client.render.cretaceous.yixian.*;
import superlord.prehistoricfauna.client.render.fish.*;
import superlord.prehistoricfauna.client.render.fossil.cretaceous.*;
import superlord.prehistoricfauna.client.render.fossil.jurassic.*;
import superlord.prehistoricfauna.client.render.fossil.triassic.*;
import superlord.prehistoricfauna.client.render.henos.*;
import superlord.prehistoricfauna.client.render.item.*;
import superlord.prehistoricfauna.client.render.jurassic.kayenta.*;
import superlord.prehistoricfauna.client.render.jurassic.morrison.*;
import superlord.prehistoricfauna.client.render.triassic.chinle.*;
import superlord.prehistoricfauna.client.render.triassic.ischigualasto.*;
import superlord.prehistoricfauna.client.util.PFChestBlockEntityRenderer;
import superlord.prehistoricfauna.common.network.KeyInputMessage;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.*;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
	public static PoseStack lastVanillaMapPoseStack;
	public static MultiBufferSource lastVanillaMapRenderBuffer;
	public static int lastVanillaMapRenderPackedLight;
	private static final RenderType TIME_TEMPLE_MAP_ICONS = RenderType.text(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/misc/time_temple_map_icon.png"));

	@SubscribeEvent
	public static void init(final FMLClientSetupEvent event) {
		if (PrehistoricFaunaConfig.customMenuBackground) {
			Optional<PathPackResources> optionalResourcePack = ResourcePackLoader.getPackFor(PrehistoricFauna.MOD_ID);
			if (optionalResourcePack.isPresent()) {
				PathPackResources resourcePack = optionalResourcePack.get();
				Set<String> folders = PrehistoricFauna.getSubfoldersFromDirectory(resourcePack.getSource(), "assets/" + PrehistoricFauna.MOD_ID + "/panoramas");
				ResourceLocation panoramaLoc = new ResourceLocation(PrehistoricFauna.MOD_ID, "panoramas/yixian/panorama");
				if (folders.size() > 0) {
					ResourceLocation[] ResourceLocationsArray = new ResourceLocation[6];
					for (int i = 0; i < 6; ++i) {
						ResourceLocationsArray[i] = new ResourceLocation(panoramaLoc.getNamespace(), panoramaLoc.getPath() + '_' + i + ".png");
					}
					ObfuscationReflectionHelper.setPrivateValue(CubeMap.class, TitleScreen.CUBE_MAP, ResourceLocationsArray, "images");
				}
			}
		}
		BlockEntityRenderers.register(PFBlockEntities.SIGN.get(), SignRenderer::new);
		BlockEntityRenderers.register(PFBlockEntities.HANGING_SIGN.get(), HangingSignRenderer::new);
//		PrehistoricFauna.trySetRandomPanorama();
		event.enqueueWork(() -> {
			Sheets.addWoodType(PFWoodTypes.METASEQUOIA);
			Sheets.addWoodType(PFWoodTypes.ARAUCARIA);
			Sheets.addWoodType(PFWoodTypes.PROTOPICEOXYLON);
			Sheets.addWoodType(PFWoodTypes.LIRIODENDRITES);
			Sheets.addWoodType(PFWoodTypes.ZAMITES);
			Sheets.addWoodType(PFWoodTypes.PROTOJUNIPEROXYLON);
			Sheets.addWoodType(PFWoodTypes.AGATHOXYLON);
			Sheets.addWoodType(PFWoodTypes.HEIDIPHYLLUM);
			Sheets.addWoodType(PFWoodTypes.GINKGO);
			Sheets.addWoodType(PFWoodTypes.TROCHODENDROIDES);
			Sheets.addWoodType(PFWoodTypes.BRACHYPHYLLUM);
			Sheets.addWoodType(PFWoodTypes.SCHILDERIA);
			Sheets.addWoodType(PFWoodTypes.NEOCALAMITES);
			Sheets.addWoodType(PFWoodTypes.WOODWORTHIA);
			Sheets.addWoodType(PFWoodTypes.DRYOPHYLLUM);
			Sheets.addWoodType(PFWoodTypes.TAXODIUM);
			Sheets.addWoodType(PFWoodTypes.SABALITES);
			Sheets.addWoodType(PFWoodTypes.PLATANITES);
			Sheets.addWoodType(PFWoodTypes.TAXUS);
			Sheets.addWoodType(PFWoodTypes.CZEKANOWSKIA);
			Sheets.addWoodType(PFWoodTypes.SCHIZOLEPIDOPSIS);
			Sheets.addWoodType(PFWoodTypes.PODOZAMITES);
		});
		MenuScreens.register(PFContainers.PALEOSCRIBE.get(), GuiPaleo::new);
		MenuScreens.register(PFContainers.PALEONTOLOGY_TABLE.get(), GuiPaleontologyTable::new);
		ClientProxy.setupBlockRenders();
	}

	//Skulls
	public static ModelLayerLocation GOYOCEPHALE_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "goyocephale_skull"), "goyocephale_skull");
	public static ModelLayerLocation PLESIOHADROS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "plesiohadros_skull"), "plesiohadros_skull");
	public static ModelLayerLocation PROTOCERATOPS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "protoceratops_skull"), "protoceratops_skull");
	public static ModelLayerLocation VELOCIRAPTOR_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "velociraptor_skull"), "velociraptor_skull");
	public static ModelLayerLocation ANKYLOSAURUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ankylosaurus_skull"), "ankylosaurus_skull");
	public static ModelLayerLocation ANZU_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "anzu_skull"), "anzu_skull");
	public static ModelLayerLocation TRICERATOPS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "triceratops_skull"), "triceratops_skull");
	public static ModelLayerLocation TYRANNOSAURUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "tyrannosaurus_skull"), "tyrannosaurus_skull");
	public static ModelLayerLocation DONGBEITITAN_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dongbeititan_skull"), "dongbeititan_skull");
	public static ModelLayerLocation LIAONINGOSAURUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "liaoningosaurus_skull"), "liaoningosaurus_skull");
	public static ModelLayerLocation PSITTACOSAURUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "psittacosaurus_skull"), "psittacosaurus_skull");
	public static ModelLayerLocation YUTYRANNUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "yutyrannus_skull"), "yutyrannus_skull");
	public static ModelLayerLocation DILOPHOSAURUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dilophosaurus_skull"), "dilophosaurus_skull");
	public static ModelLayerLocation SARAHSAURUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "sarahsaurus_skull"), "sarahsaurus_skull");
	public static ModelLayerLocation SCELIDOSAURUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "scelidosaurus_skull"), "scelidosaurus_skull");
	public static ModelLayerLocation ALLOSAURUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "allosaurus_skull"), "allosaurus_skull");
	public static ModelLayerLocation CERATOSAURUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ceratosaurus_skull"), "ceratosaurus_skull");
	public static ModelLayerLocation STEGOSAURUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "stegosaurus_skull"), "stegosaurus_skull");
	public static ModelLayerLocation COELOPHYSIS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "coelophysis_skull"), "coelophysis_skull");
	public static ModelLayerLocation DESMATOSUCHUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "desmatosuchus_skull"), "desmatosuchus_skull");
	public static ModelLayerLocation POSTOSUCHUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "postosuchus_skull"), "postosuchus_skull");
	public static ModelLayerLocation HERRERASAURUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "herrerasaurus_skull"), "herrerasaurus_skull");
	public static ModelLayerLocation ISCHIGUALASTIA_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ischigualastia_skull"), "ischigualastia_skull");
	public static ModelLayerLocation SAUROSUCHUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "saurosuchus_skull"), "saurosuchus_skull");
	//Skeletons
	public static ModelLayerLocation PLESIOHADROS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "plesiohadros_skeleton"), "plesiohadros_skeleton");
	public static ModelLayerLocation PLESIOHADROS_SKELETON_CHARGE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "plesiohadros_skeleton_charge"), "plesiohadros_skeleton_charge");
	public static ModelLayerLocation PLESIOHADROS_SKELETON_DASH_LEFT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "plesiohadros_skeleton_dash_left"), "plesiohadros_skeleton_dash_left");
	public static ModelLayerLocation PLESIOHADROS_SKELETON_DASH_RIGHT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "plesiohadros_skeleton_dash_right"), "plesiohadros_skeleton_dash_right");
	public static ModelLayerLocation PLESIOHADROS_SKELETON_SITTING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "plesiohadros_skeleton_sitting"), "plesiohadros_skeleton_sitting");
	public static ModelLayerLocation PLESIOHADROS_SKELETON_SLEEPING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "plesiohadros_skeleton_sleeping"), "plesiohadros_skeleton_sleeping");
	public static ModelLayerLocation PLESIOHADROS_SKELETON_WALKING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "plesiohadros_skeleton_walking"), "plesiohadros_skeleton_walking");
	public static ModelLayerLocation PROTOCERATOPS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "protoceratops_skeleton"), "protoceratops_skeleton");
	public static ModelLayerLocation PROTOCERATOPS_SKELETON_DISPLAY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "protoceratops_skeleton_display"), "protoceratops_skeleton_display");
	public static ModelLayerLocation PROTOCERATOPS_SKELETON_LAYING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "protoceratops_skeleton_laying"), "protoceratops_skeleton_laying");
	public static ModelLayerLocation PROTOCERATOPS_SKELETON_RUNNING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "protoceratops_skeleton_running"), "protoceratops_skeleton_running");
	public static ModelLayerLocation PROTOCERATOPS_SKELETON_SITTING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "protoceratops_skeleton_sitting"), "protoceratops_skeleton_sitting");
	public static ModelLayerLocation VELOCIRAPTOR_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "velociraptor_skeleton"), "velociraptor_skeleton");
	public static ModelLayerLocation VELOCIRAPTOR_SKELETON_STAND_FIGHTING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "velociraptor_skeleton_stand_fighting"), "velociraptor_skeleton_stand_fighting");
	public static ModelLayerLocation VELOCIRAPTOR_SKELETON_SLEEPING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "velociraptor_skeleton_sleeping"), "velociraptor_skeleton_sleeping");
	public static ModelLayerLocation VELOCIRAPTOR_SKELETON_RUNNING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "velociraptor_skeleton_running"), "velociraptor_skeleton_running");
	public static ModelLayerLocation VELOCIRAPTOR_SKELETON_LAY_FIGHTING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "velociraptor_skeleton_lay_fighting"), "velociraptor_skeleton_lay_fighting");
	public static ModelLayerLocation VELOCIRAPTOR_SKELETON_FLASHING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "velociraptor_skeleton_flashing"), "velociraptor_skeleton_flashing");
	public static ModelLayerLocation ANKYLOSAURUS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ankylosaurus_skeleton"), "ankylosaurus_skeleton");
	public static ModelLayerLocation ANKYLOSAURUS_SKELETON_RESTING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ankylosaurus_skeleton_resting"), "ankylosaurus_skeleton_resting");
	public static ModelLayerLocation ANKYLOSAURUS_SKELETON_ACTION_RIGHT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ankylosaurus_skeleton_action_right"), "ankylosaurus_skeleton_action_right");
	public static ModelLayerLocation ANKYLOSAURUS_SKELETON_ACTION_LEFT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ankylosaurus_skeleton_action_left"), "ankylosaurus_skeleton_action_left");
	public static ModelLayerLocation ANKYLOSAURUS_SKELETON_SQUATTING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ankylosaurus_skeleton_squatting"), "ankylosaurus_skeleton_squatting");
	public static ModelLayerLocation ANZU_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "anzu_skeleton"), "anzu_skeleton");
	public static ModelLayerLocation ANZU_SKELETON_REAR = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "anzu_skeleton_rear"), "anzu_skeleton_rear");
	public static ModelLayerLocation ANZU_SKELETON_ROMP = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "anzu_skeleton_romp"), "anzu_skeleton_romp");
	public static ModelLayerLocation ANZU_SKELETON_FLEE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "anzu_skeleton_flee"), "anzu_skeleton_flee");
	public static ModelLayerLocation ANZU_SKELETON_SKULK = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "anzu_skeleton_skulk"), "anzu_skeleton_skulk");
	public static ModelLayerLocation ANZU_SKELETON_DISPLAY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "anzu_skeleton_display"), "anzu_skeleton_display");
	public static ModelLayerLocation ANZU_SKELETON_BOW = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "anzu_skeleton_bow"), "anzu_skeleton_bow");
	public static ModelLayerLocation ANZU_SKELETON_SIT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "anzu_skeleton_sit"), "anzu_skeleton_sit");
	public static ModelLayerLocation ANZU_SKELETON_SLEEP = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "anzu_skeleton_sleep"), "anzu_skeleton_sleep");
	public static ModelLayerLocation ANZU_SKELETON_DEATH = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "anzu_skeleton_death"), "anzu_skeleton_death");
	public static ModelLayerLocation TRICERATOPS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "triceratops_skeleton"), "triceratops_skeleton");
	public static ModelLayerLocation TRICERATOPS_SKELETON_CHARGING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "triceratops_skeleton_charging"), "triceratops_skeleton_charging");
	public static ModelLayerLocation TRICERATOPS_SKELETON_RETRO = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "triceratops_skeleton_retro"), "triceratops_skeleton_retro");
	public static ModelLayerLocation TRICERATOPS_SKELETON_SLEEPING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "triceratops_skeleton_sleeping"), "triceratops_skeleton_sleeping");
	public static ModelLayerLocation TRICERATOPS_SKELETON_SITTING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "triceratops_skeleton_sitting"), "triceratops_skeleton_sitting");
	public static ModelLayerLocation TRICERATOPS_SKELETON_ACTION_LEFT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "triceratops_skeleton_action_left"), "triceratops_skeleton_action_left");
	public static ModelLayerLocation TRICERATOPS_SKELETON_ACTION_RIGHT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "triceratops_skeleton_action_right"), "triceratops_skeleton_action_right");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "tyrannosaurus_skeleton"), "tyrannosaurus_skeleton");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON_SLEEPING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "tyrannosaurus_skeleton_sleeping"), "tyrannosaurus_skeleton_sleeping");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON_STOMPING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "tyrannosaurus_skeleton_stomping"), "tyrannosaurus_skeleton_stomping");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON_STALKING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "tyrannosaurus_skeleton_stalking"), "tyrannosaurus_skeleton_stalking");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON_RUNNING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "tyrannosaurus_skeleton_running"), "tyrannosaurus_skeleton_running");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON_RETRO = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "tyrannosaurus_skeleton_retro"), "tyrannosaurus_skeleton_retro");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON_SITTING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "tyrannosaurus_skeleton_sitting"), "tyrannosaurus_skeleton_sitting");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON_JP = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "tyrannosaurus_skeleton_jp"), "tyrannosaurus_skeleton_jp");
	public static ModelLayerLocation DILOPHOSAURUS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dilophosaurus_skeleton"), "dilophosaurus_skeleton");
	public static ModelLayerLocation DILOPHOSAURUS_SKELETON_ATTACK = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dilophosaurus_skeleton_attack"), "dilophosaurus_skeleton_attack");
	public static ModelLayerLocation DILOPHOSAURUS_SKELETON_GAZE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dilophosaurus_skeleton_gaze"), "dilophosaurus_skeleton_gaze");
	public static ModelLayerLocation DILOPHOSAURUS_SKELETON_SITTING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dilophosaurus_skeleton_sitting"), "dilophosaurus_skeleton_sitting");
	public static ModelLayerLocation DILOPHOSAURUS_SKELETON_STRUT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dilophosaurus_skeleton_strut"), "dilophosaurus_skeleton_strut");
	public static ModelLayerLocation SARAHSAURUS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "sarahsaurus_skeleton"), "sarahsaurus_skeleton");
	public static ModelLayerLocation SARAHSAURUS_SKELETON_EATING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "sarahsaurus_skeleton_eating"), "sarahsaurus_skeleton_eating");
	public static ModelLayerLocation SARAHSAURUS_SKELETON_SITTING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "sarahsaurus_skeleton_sitting"), "sarahsaurus_skeleton_sitting");
	public static ModelLayerLocation SARAHSAURUS_SKELETON_WALKING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "sarahsaurus_skeleton_walking"), "sarahsaurus_skeleton_walking");
	public static ModelLayerLocation SCELIDOSAURUS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "scelidosaurus_skeleton"), "scelidosaurus_skeleton");
	public static ModelLayerLocation SCELIDOSAURUS_SKELETON_DASHING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "scelidosaurus_skeleton_dashing"), "scelidosaurus_skeleton_dashing");
	public static ModelLayerLocation SCELIDOSAURUS_SKELETON_GRAZING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "scelidosaurus_skeleton_grazing"), "scelidosaurus_skeleton_grazing");
	public static ModelLayerLocation SCELIDOSAURUS_SKELETON_REACHING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "scelidosaurus_skeleton_reaching"), "scelidosaurus_skeleton_reaching");
	public static ModelLayerLocation SCELIDOSAURUS_SKELETON_SLEEPING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "scelidosaurus_skeleton_sleeping"), "scelidosaurus_skeleton_sleeping");
	public static ModelLayerLocation SCELIDOSAURUS_SKELETON_WALKING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "scelidosaurus_skeleton_walking"), "scelidosaurus_skeleton_walking");
	public static ModelLayerLocation ALLOSAURUS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "allosaurus_skeleton"), "allosaurus_skeleton");
	public static ModelLayerLocation ALLOSAURUS_SKELETON_ACTION_LEFT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "allosaurus_skeleton_action_left"), "allosaurus_skeleton_action_left");
	public static ModelLayerLocation ALLOSAURUS_SKELETON_ACTION_RIGHT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "allosaurus_skeleton_action_right"), "allosaurus_skeleton_action_right");
	public static ModelLayerLocation ALLOSAURUS_SKELETON_RETRO = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "allosaurus_skeleton_retro"), "allosaurus_skeleton_retro");
	public static ModelLayerLocation ALLOSAURUS_SKELETON_RESTING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "allosaurus_skeleton_resting"), "allosaurus_skeleton_resting");
	public static ModelLayerLocation CERATOSAURUS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ceratosaurus_skeleton"), "ceratosaurus_skeleton");
	public static ModelLayerLocation CERATOSAURUS_SKELETON_ACTION = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ceratosaurus_skeleton_action"), "ceratosaurus_skeleton_action");
	public static ModelLayerLocation CERATOSAURUS_SKELETON_RESTING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ceratosaurus_skeleton_resting"), "ceratosaurus_skeleton_resting");
	public static ModelLayerLocation CERATOSAURUS_SKELETON_ALERT_RIGHT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ceratosaurus_skeleton_alert_right"), "ceratosaurus_skeleton_alert_right");
	public static ModelLayerLocation CERATOSAURUS_SKELETON_ALERT_LEFT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ceratosaurus_skeleton_alert_left"), "ceratosaurus_skeleton_alert_left");
	public static ModelLayerLocation STEGOSAURUS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "stegosaurus_skeleton"), "stegosaurus_skeleton");
	public static ModelLayerLocation STEGOSAURUS_SKELETON_ACTION_LEFT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "stegosaurus_skeleton_action_left"), "stegosaurus_skeleton_action_left");
	public static ModelLayerLocation STEGOSAURUS_SKELETON_ACTION_RIGHT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "stegosaurus_skeleton_action_right"), "stegosaurus_skeleton_action_right");
	public static ModelLayerLocation STEGOSAURUS_SKELETON_RETRO = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "stegosaurus_skeleton_retro"), "stegosaurus_skeleton_retro");
	public static ModelLayerLocation STEGOSAURUS_SKELETON_SLEEPING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "stegosaurus_skeleton_sleeping"), "stegosaurus_skeleton_sleeping");
	public static ModelLayerLocation COELOPHYSIS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "coelophysis_skeleton"), "coelophysis_skeleton");
	public static ModelLayerLocation COELOPHYSIS_SKELETON_SAUNTER = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "coelophysis_skeleton_saunter"), "coelophysis_skeleton_saunter");
	public static ModelLayerLocation COELOPHYSIS_SKELETON_SEIZE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "coelophysis_skeleton_seize"), "coelophysis_skeleton_seize");
	public static ModelLayerLocation COELOPHYSIS_SKELETON_SLAIN = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "coelophysis_skeleton_slain"), "coelophysis_skeleton_slain");
	public static ModelLayerLocation COELOPHYSIS_SKELETON_SLEEPING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "coelophysis_skeleton_sleeping"), "coelophysis_skeleton_sleeping");
	public static ModelLayerLocation COELOPHYSIS_SKELETON_SLUMP = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "coelophysis_skeleton_slump"), "coelophysis_skeleton_slump");
	public static ModelLayerLocation COELOPHYSIS_SKELETON_STRIDE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "coelophysis_skeleton_stride"), "coelophysis_skeleton_stride");
	public static ModelLayerLocation DESMATOSUCHUS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "desmatosuchus_skeleton"), "desmatosuchus_skeleton");
	public static ModelLayerLocation DESMATOSUCHUS_SKELETON_SLEEPING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "desmatosuchus_skeleton_sleeping"), "desmatosuchus_skeleton_sleeping");
	public static ModelLayerLocation DESMATOSUCHUS_SKELETON_WALKING_RIGHT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "desmatosuchus_skeleton_walking_right"), "desmatosuchus_skeleton_walking_right");
	public static ModelLayerLocation DESMATOSUCHUS_SKELETON_WALKING_LEFT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "desmatosuchus_skeleton_walking_left"), "desmatosuchus_skeleton_walking_left");
	public static ModelLayerLocation POSTOSUCHUS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "postosuchus_skeleton"), "postosuchus_skeleton");
	public static ModelLayerLocation POSTOSUCHUS_SKELETON_ATTACK_LEFT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "postosuchus_skeleton_attack_left"), "postosuchus_skeleton_attack_left");
	public static ModelLayerLocation POSTOSUCHUS_SKELETON_ATTACK = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "postosuchus_skeleton_attack"), "postosuchus_skeleton_attack");
	public static ModelLayerLocation POSTOSUCHUS_SKELETON_CURIOUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "postosuchus_skeleton_curious"), "postosuchus_skeleton_curious");
	public static ModelLayerLocation POSTOSUCHUS_SKELETON_SLEEPING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "postosuchus_skeleton_sleeping"), "postosuchus_skeleton_sleeping");
	public static ModelLayerLocation POSTOSUCHUS_SKELETON_WALKING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "postosuchus_skeleton_walking"), "postosuchus_skeleton_walking");
	public static ModelLayerLocation HERRERASAURUS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "herrerasaurus_skeleton"), "herrerasaurus_skeleton");
	public static ModelLayerLocation HERRERASAURUS_SKELETON_ACTION = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "herrerasaurus_skeleton_action"), "herrerasaurus_skeleton_action");
	public static ModelLayerLocation HERRERASAURUS_SKELETON_RUNNING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "herrerasaurus_skeleton_running"), "herrerasaurus_skeleton_running");
	public static ModelLayerLocation ISCHIGUALASTIA_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ischigualastia_skeleton"), "ischigualastia_skeleton");
	public static ModelLayerLocation ISCHIGUALASTIA_SKELETON_STRETCHING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ischigualastia_skeleton_stretching"), "ischigualastia_skeleton_stretching");
	public static ModelLayerLocation SAUROSUCHUS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "saurosuchus_skeleton"), "saurosuchus_skeleton");
	public static ModelLayerLocation SAUROSUCHUS_SKELETON_ACTION_RIGHT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "saurosuchus_skeleton_action_right"), "saurosuchus_skeleton_action_right");
	public static ModelLayerLocation SAUROSUCHUS_SKELETON_ACTION_LEFT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "saurosuchus_skeleton_action_left"), "saurosuchus_skeleton_action_left");
	public static ModelLayerLocation SAUROSUCHUS_SKELETON_SLEEPING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "saurosuchus_skeleton_sleeping"), "saurosuchus_skeleton_sleeping");
	public static ModelLayerLocation PSITTACOSAURUS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "psittacosaurus_skeleton"), "psittacosaurus_skeleton");
	public static ModelLayerLocation PSITTACOSAURUS_SKELETON_LEFT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "psittacosaurus_skeleton_left"), "psittacosaurus_skeleton_left");
	public static ModelLayerLocation PSITTACOSAURUS_SKELETON_MATING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "psittacosaurus_skeleton_mating"), "psittacosaurus_skeleton_mating");
	public static ModelLayerLocation PSITTACOSAURUS_SKELETON_SAUNTER = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "psittacosaurus_skeleton_saunter"), "psittacosaurus_skeleton_saunter");
	public static ModelLayerLocation PSITTACOSAURUS_SKELETON_SITTING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "psittacosaurus_skeleton_sitting"), "psittacosaurus_skeleton_sitting");
	public static ModelLayerLocation PSITTACOSAURUS_SKELETON_SPRINTING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "psittacosaurus_skeleton_sprinting"), "psittacosaurus_skeleton_sprinting");
	public static ModelLayerLocation YUTYRANNUS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "yutyrannus_skeleton"), "yutyrannus_skeleton");
	public static ModelLayerLocation YUTYRANNUS_SKELETON_SAUNTER = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "yutyrannus_skeleton_saunter"), "yutyrannus_skeleton_saunter");
	public static ModelLayerLocation YUTYRANNUS_SKELETON_ROMP = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "yutyrannus_skeleton_romp"), "yutyrannus_skeleton_romp");
	public static ModelLayerLocation YUTYRANNUS_SKELETON_FROLIC = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "yutyrannus_skeleton_frolic"), "yutyrannus_skeleton_frolic");
	public static ModelLayerLocation YUTYRANNUS_SKELETON_JP = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "yutyrannus_skeleton_jp"), "yutyrannus_skeleton_jp");
	public static ModelLayerLocation YUTYRANNUS_SKELETON_LEAP = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "yutyrannus_skeleton_leap"), "yutyrannus_skeleton_leap");
	public static ModelLayerLocation YUTYRANNUS_SKELETON_SUBDUED = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "yutyrannus_skeleton_subdued"), "yutyrannus_skeleton_subdued");
	public static ModelLayerLocation YUTYRANNUS_SKELETON_SLEEP = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "yutyrannus_skeleton_sleep"), "yutyrannus_skeleton_sleep");
	public static ModelLayerLocation YUTYRANNUS_SKELETON_CARCASS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "yutyrannus_skeleton_carcass"), "yutyrannus_skeleton_carcass");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "goyocephale_skeleton"), "goyocephale_skeleton");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_STEP = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "goyocephale_skeleton_step"), "goyocephale_skeleton_step");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_SLEEP = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "goyocephale_skeleton_sleep"), "goyocephale_skeleton_sleep");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_FEEDING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "goyocephale_skeleton_feeding"), "goyocephale_skeleton_feeding");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_SIT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "goyocephale_skeleton_sit"), "goyocephale_skeleton_sit");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_DEATH = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "goyocephale_skeleton_death"), "goyocephale_skeleton_death");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_HEADBUTT_TWO = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "goyocephale_skeleton_headbutt_two"), "goyocephale_skeleton_headbutt_two");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_HEADBUTT_ONE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "goyocephale_skeleton_headbutt_one"), "goyocephale_skeleton_headbutt_one");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_BRACE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "goyocephale_skeleton_brace"), "goyocephale_skeleton_brace");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_REAR = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "goyocephale_skeleton_rear"), "goyocephale_skeleton_rear");
	public static ModelLayerLocation DONGBEITITAN_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dongbeititan_skeleton"), "dongbeititan_skeleton");
	public static ModelLayerLocation DONGBEITITAN_SKELETON_WALK = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dongbeititan_skeleton_walk"), "dongbeititan_skeleton_walk");
	public static ModelLayerLocation DONGBEITITAN_SKELETON_REAR = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dongbeititan_skeleton_rear"), "dongbeititan_skeleton_rear");
	public static ModelLayerLocation DONGBEITITAN_SKELETON_BROWSE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dongbeititan_skeleton_browse"), "dongbeititan_skeleton_browse");
	public static ModelLayerLocation DONGBEITITAN_SKELETON_GRAZE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dongbeititan_skeleton_graze"), "dongbeititan_skeleton_graze");
	public static ModelLayerLocation DONGBEITITAN_SKELETON_SIT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dongbeititan_skeleton_sit"), "dongbeititan_skeleton_sit");
	public static ModelLayerLocation DONGBEITITAN_SKELETON_SLEEP = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dongbeititan_skeleton_sleep"), "dongbeititan_skeleton_sleep");
	public static ModelLayerLocation DONGBEITITAN_SKELETON_DEATH = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dongbeititan_skeleton_death"), "dongbeititan_skeleton_death");
	public static ModelLayerLocation DONGBEITITAN_SKELETON_REACH = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dongbeititan_skeleton_reach"), "dongbeititan_skeleton_reach");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "liaoningosaurus_skeleton"), "liaoningosaurus_skeleton");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_WALK = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "liaoningosaurus_skeleton_walk"), "liaoningosaurus_skeleton_walk");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_BRACE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "liaoningosaurus_skeleton_brace"), "liaoningosaurus_skeleton_brace");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_SAUNTER = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "liaoningosaurus_skeleton_saunter"), "liaoningosaurus_skeleton_saunter");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_GAZE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "liaoningosaurus_skeleton_gaze"), "liaoningosaurus_skeleton_gaze");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_CLOBBER = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "liaoningosaurus_skeleton_clobber"), "liaoningosaurus_skeleton_clobber");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_DEFENSIVE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "liaoningosaurus_skeleton_defensive"), "liaoningosaurus_skeleton_defensive");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_SIT = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "liaoningosaurus_skeleton_sit"), "liaoningosaurus_skeleton_sit");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_SLEEP = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "liaoningosaurus_skeleton_sleep"), "liaoningosaurus_skeleton_sleep");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_DEATH = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "liaoningosaurus_skeleton_death"), "liaoningosaurus_skeleton_death");
	//Hell Creek
	public static ModelLayerLocation ANKYLOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ankylosaurus"), "ankylosaurus");
	public static ModelLayerLocation ANKYLOSAURUS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ankylosaurus_baby"), "ankylosaurus_baby");
	public static ModelLayerLocation ANZU = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "anzu"), "anzu");
	public static ModelLayerLocation ANZU_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "anzu_baby"), "anzu_baby");
	public static ModelLayerLocation BASILEMYS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "basilemys"), "basilemys");
	public static ModelLayerLocation DAKOTARAPTOR = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dakotaraptor"), "dakotaraptor");
	public static ModelLayerLocation DAKOTARAPTOR_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dakotaraptor_baby"), "dakotaraptor_baby");
	public static ModelLayerLocation DIDELPHODON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "didelphodon"), "didelphodon");
	public static ModelLayerLocation EDMONTOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "edmontosaurus"), "edmontosaurus");
	public static ModelLayerLocation EDMONTOSAURUS_JUVENILE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "edmontosaurus_juvenile"), "edmontosaurus_juvenile");
	public static ModelLayerLocation EDMONTOSAURUS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "edmontosaurus_baby"), "edmontosaurus_baby");
	public static ModelLayerLocation ORNITHOMIMUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ornithomimus"), "ornithomimus");
	public static ModelLayerLocation ORNITHOMIMUS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ornithomimus_baby"), "ornithomimus_baby");
	public static ModelLayerLocation PACHYCEPHALOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "pachycephalosaurus"), "pachycephalosaurus");
	public static ModelLayerLocation PALAEOSANIWA = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "palaeosaniwa"), "palaeosaniwa");
	public static ModelLayerLocation THESCELOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "thescelosaurus"), "thescelosaurus");
	public static ModelLayerLocation BRACHYCHAMPSA = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "brachychampsa"), "brachychampsa");
	public static ModelLayerLocation TRICERATOPS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "triceratops"), "triceratops");
	public static ModelLayerLocation TRICERATOPS_JUVENILE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "triceratops_juvenile"), "triceratops_juvenile");
	public static ModelLayerLocation TRICERATOPS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "triceratops_baby"), "triceratops_baby");
	public static ModelLayerLocation TYRANNOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "tyrannosaurus"), "tyrannosaurus");
	public static ModelLayerLocation TYRANNOSAURUS_JUVENILE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "tyrannosaurus_juvenile"), "tyrannosaurus_juvenile");
	public static ModelLayerLocation TYRANNOSAURUS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "tyrannosaurus_baby"), "tyrannosaurus_baby");
	//Djadochta
	public static ModelLayerLocation AEPYORNITHOMIMUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "aepyornithomimus"), "aepyornithomimus");
	public static ModelLayerLocation BYRONOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "byronosaurus"), "byronosaurus");
	public static ModelLayerLocation CITIPATI = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "citipati"), "citipati");
	public static ModelLayerLocation GOYOCEPHALE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "goyocephale"), "goyocephale");
	public static ModelLayerLocation HALSZKARAPTOR = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "halszkaraptor"), "halszkaraptor");
	public static ModelLayerLocation KOL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "kol"), "kol");
	public static ModelLayerLocation OVIRAPTOR = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "oviraptor"), "oviraptor");
	public static ModelLayerLocation PINACOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "pinacosaurus"), "pinacosaurus");
	public static ModelLayerLocation PINACOSAURUS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "pinacosaurus_baby"), "pinacosaurus_baby");
	public static ModelLayerLocation PLESIOHADROS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "plesiohadros"), "plesiohadros");
	public static ModelLayerLocation PLESIOHADROS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "plesiohadros_baby"), "plesiohadros_baby");
	public static ModelLayerLocation PROTOCERATOPS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "protoceratops"), "protoceratops");
	public static ModelLayerLocation PROTOCERATOPS_JUVENILE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "protoceratops_juvenile"), "protoceratops_juvenile");
	public static ModelLayerLocation TELMASAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "telmasaurus"), "telmasaurus");
	public static ModelLayerLocation UDANOCERATOPS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "udanoceratops"), "udanoceratops");
	public static ModelLayerLocation UDANOCERATOPS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "udanoceratops_baby"), "udanoceratops_baby");
	public static ModelLayerLocation VELOCIRAPTOR = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "velociraptor"), "velociraptor");

	//Bugs
	public static ModelLayerLocation DERMESTID_BEETLE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dermestid_beetle"), "dermestid_beetle");
	public static ModelLayerLocation GOBIULUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "gobiulus"), "gobiulus");
	public static ModelLayerLocation CEPHALOLEICHNITES = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "cephaloleichnites"), "cephaloleichnites");
	public static ModelLayerLocation APOCLION = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "apoclion"), "apoclion");
	public static ModelLayerLocation CRETARANEUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "cretaraneus"), "cretaraneus");
	public static ModelLayerLocation LIAONEMOBIUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "liaonemobius"), "liaonemobius");

	//Yixian
	public static ModelLayerLocation BEIPIAOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "beipiaosaurus"), "beipiaosaurus");
	public static ModelLayerLocation CHANGYURAPTOR = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "changyuraptor"), "changyuraptor");
	public static ModelLayerLocation DILONG = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dilong"), "dilong");
	public static ModelLayerLocation DONGBEITITAN = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dongbeititan"), "dongbeititan");
	public static ModelLayerLocation DONGBEITITAN_JUVENILE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dongbeititan_juvenile"), "dongbeititan_juvenile");
	public static ModelLayerLocation DONGBEITITAN_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dongbeititan_baby"), "dongbeititan_baby");
	public static ModelLayerLocation INCISIVOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "incisivosaurus"), "incisivosaurus");
	public static ModelLayerLocation JINZHOUSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "jinzhousaurus"), "jinzhousaurus");
	public static ModelLayerLocation JINZHOUSAURUS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "jinzhousaurus_baby"), "jinzhousaurus_baby");
	public static ModelLayerLocation LIAONINGOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "liaoningosaurus"), "liaoningosaurus");
	public static ModelLayerLocation PSITTACOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "psittacosaurus"), "psittacosaurus");
	public static ModelLayerLocation REPENOMAMUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "repenomamus"), "repenomamus");
	public static ModelLayerLocation RUIXINIA = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ruixinia"), "ruixinia");
	public static ModelLayerLocation RUIXINIA_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ruixinia_baby"), "ruixinia_baby");
	public static ModelLayerLocation SINOSAUROPTERYX = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "sinosauropteryx"), "sinosauropteryx");
	public static ModelLayerLocation YUTYRANNUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "yutyrannus"), "yutyrannus");
	public static ModelLayerLocation YUTYRANNUS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "yutyrannus_baby"), "yutyrannus_baby");
	public static ModelLayerLocation ZHENYUANLONG = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "zhenyuanlong"), "zhenyuanlong");

	//Kayenta
	public static ModelLayerLocation CALSOYASUCHUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "calsoyasuchus"), "calsoyasuchus");
	public static ModelLayerLocation DILOPHOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dilophosaurus"), "dilophosaurus");
	public static ModelLayerLocation DILOPHOSAURUS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dilophosaurus_baby"), "dilophosaurus_baby");
	public static ModelLayerLocation KAYENTATHERIUM = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "kayentatherium"), "kayentatherium");
	public static ModelLayerLocation MEGAPNOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "megapnosaurus"), "megapnosaurus");
	public static ModelLayerLocation SARAHSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "sarahsaurus"), "sarahsaurus");
	public static ModelLayerLocation SCELIDOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "scelidosaurus"), "scelidosaurus");
	public static ModelLayerLocation SCUTELLOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "scutellosaurus"), "scutellosaurus");
	//Morrison
	public static ModelLayerLocation ALLOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "allosaurus"), "allosaurus");
	public static ModelLayerLocation ALLOSAURUS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "allosaurus_baby"), "allosaurus_baby");
	public static ModelLayerLocation CAMARASAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "camarasaurus"), "camarasaurus");
	public static ModelLayerLocation CAMARASAURUS_JUVENILE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "camarasaurus_juvenile"), "camarasaurus_juvenile");
	public static ModelLayerLocation CAMARASAURUS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "camarasaurus_baby"), "camarasaurus_baby");
	public static ModelLayerLocation CAMARASAURUS_HATCHLING = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "camarasaurus_hatchling"), "camarasaurus_hatchling");
	public static ModelLayerLocation CERATOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ceratosaurus"), "ceratosaurus");
	public static ModelLayerLocation CERATOSAURUS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ceratosaurus_baby"), "ceratosaurus_baby");
	public static ModelLayerLocation DRYOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dryosaurus"), "dryosaurus");
	public static ModelLayerLocation EILENODON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "eilenodon"), "eilenodon");
	public static ModelLayerLocation HESPERORNITHOIDES = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "hesperornithoides"), "hesperornithoides");
	public static ModelLayerLocation STEGOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "stegosaurus"), "stegosaurus");
	public static ModelLayerLocation STEGOSAURUS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "stegosaurus_baby"), "stegosaurus_baby");
	//Chinle
	public static ModelLayerLocation COELOPHYSIS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "coelophysis"), "coelophysis");
	public static ModelLayerLocation DESMATOSUCHUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "desmatosuchus"), "desmatosuchus");
	public static ModelLayerLocation PLACERIAS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "placerias"), "placerias");
	public static ModelLayerLocation POPOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "poposaurus"), "poposaurus");
	public static ModelLayerLocation POSTOSUCHUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "postosuchus"), "postosuchus");
	public static ModelLayerLocation TRILOPHOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "trilophosaurus"), "trilophosaurus");
	public static ModelLayerLocation TYPOTHORAX = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "typothorax"), "typothorax");
	//Ischigualasto
	public static ModelLayerLocation CHROMOGISAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "chromogisaurus"), "chromogisaurus");
	public static ModelLayerLocation EXAERETODON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "exaeretodon"), "exaeretodon");
	public static ModelLayerLocation HERRERASAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "herrerasaurus"), "herrerasaurus");
	public static ModelLayerLocation HYPERODAPEDON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "hyperodapedon"), "hyperodapedon");
	public static ModelLayerLocation ISCHIGUALASTIA = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ischigualastia"), "ischigualastia");
	public static ModelLayerLocation ISCHIGUALASTIA_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ischigualastia_baby"), "ischigualastia_baby");
	public static ModelLayerLocation SAUROSUCHUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "saurosuchus"), "saurosuchus");
	public static ModelLayerLocation SAUROSUCHUS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "saurosuchus_baby"), "saurosuchus_baby");
	public static ModelLayerLocation SILLOSUCHUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "sillosuchus"), "sillosuchus");
	public static ModelLayerLocation SILLOSUCHUS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "sillosuchus_baby"), "sillosuchus_baby");
	//Fish
	public static ModelLayerLocation ACIPENSER = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "acipenser"), "acipenser");
	public static ModelLayerLocation ARGANODUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "arganodous"), "arganodus");
	public static ModelLayerLocation CERATODUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ceratodus"), "ceratodus");
	public static ModelLayerLocation CHINLEA = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "chinlea"), "chinlea");
	public static ModelLayerLocation CYCLURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "cyclurus"), "cyclurus");
	public static ModelLayerLocation GAR = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "gar"), "gar");
	public static ModelLayerLocation HARENAICHTHYS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "harenaichthys"), "harenaichthys");
	public static ModelLayerLocation LONCHIDION = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "lonchidion"), "lonchidion");
	public static ModelLayerLocation MELVIUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "melvius"), "melvius");
	public static ModelLayerLocation MOOREODONTUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "mooreodontus"), "mooreodontus");
	public static ModelLayerLocation MYLEDAPHUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "myledaphus"), "myledaphus");
	public static ModelLayerLocation POTAMOCERATODUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "potamoceratodus"), "potamoceratodus");
	public static ModelLayerLocation PROTOPSEPHURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "protopsephurus"), "protopsephurus");
	public static ModelLayerLocation SAURICHTHYS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "saurichthys"), "saurichthys");
	public static ModelLayerLocation SINAMIA = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "sinamia"), "sinamia");
	public static ModelLayerLocation YANOSTEUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "yanosteus"), "yanosteus");
	public static ModelLayerLocation PARAPSEPHURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "parapsephurus"), "parapsephurus");

	public static ModelLayerLocation ANKYLOSAURUS_HELMET = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ankylosaurus_helmet"), "ankylosaurus_helmet");
	public static ModelLayerLocation DESMATOSUCHUS_CHESTPLATE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "desmatosuchus_chestplate"), "desmatosuchus_chestplate");
	public static ModelLayerLocation EGGSHELL_HELMET = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "eggshell_helmet"), "eggshell_helmet");

	public static ModelLayerLocation LUNGFISH_COCOON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "lungfish_cocoon"), "lungfish_cocoon");
	
	//Henos
	public static ModelLayerLocation HENOS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "henos"), "henos");
	public static ModelLayerLocation SUMMONED_HENOS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "summoned_henos"), "summoned_henos");
	public static ModelLayerLocation CAVE_SENTINEL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "cave_sentinel"), "cave_sentinel");
	public static ModelLayerLocation LAND_SENTINEL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "land_sentinel"), "land_sentinel");
	public static ModelLayerLocation CORRUPTED_THEROPOD = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "corrupted_theropod"), "corrupted_theropod");
	
	@SubscribeEvent
	public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(PFEntities.HERRERASAURUS_SKULL.get(), HerrerasaurusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.HERRERASAURUS_SKELETON.get(), HerrerasaurusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.BOAT.get(), PFBoatRenderer::new);
		event.registerEntityRenderer(PFEntities.CHEST_BOAT.get(), PFChestBoatRenderer::new);
		event.registerEntityRenderer(PFEntities.RAFT.get(), PFRaftRenderer::new);
		event.registerEntityRenderer(PFEntities.PALEOPAINTING.get(), PaleopaintingRenderer::new);
		event.registerEntityRenderer(PFEntities.WALL_FOSSIL.get(), WallFossilRenderer::new);
		event.registerEntityRenderer(PFEntities.HENOS.get(), HenosRenderer::new);
		event.registerEntityRenderer(PFEntities.ANKYLOSAURUS_SKELETON.get(), AnkylosaurusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.ANKYLOSAURUS_SKULL.get(), AnkylosaurusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.ALLOSAURUS_SKELETON.get(), AllosaurusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.ALLOSAURUS_SKULL.get(), AllosaurusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.CERATOSAURUS_SKULL.get(), CeratosaurusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.CERATOSAURUS_SKELETON.get(), CeratosaurusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.COELOPHYSIS_SKELETON.get(), CoelophysisSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.COELOPHYSIS_SKULL.get(), CoelophysisSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.DESMATOSUCHUS_SKELETON.get(), DesmatosuchusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.DESMATOSUCHUS_SKULL.get(), DesmatosuchusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.DILOPHOSAURUS_SKELETON.get(), DilophosaurusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.DILOPHOSAURUS_SKULL.get(), DilophosaurusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.ISCHIGUALASTIA_SKELETON.get(), IschigualastiaSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.ISCHIGUALASTIA_SKULL.get(), IschigualastiaSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.PLESIOHADROS_SKELETON.get(), PlesiohadrosSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.PLESIOHADROS_SKULL.get(), PlesiohadrosSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.POSTOSUCHUS_SKELETON.get(), PostosuchusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.POSTOSUCHUS_SKULL.get(), PostosuchusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.PROTOCERATOPS_SKELETON.get(), ProtoceratopsSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.PROTOCERATOPS_SKULL.get(), ProtoceratopsSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.SARAHSAURUS_SKELETON.get(), SarahsaurusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.SARAHSAURUS_SKULL.get(), SarahsaurusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.SAUROSUCHUS_SKELETON.get(), SaurosuchusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.SAUROSUCHUS_SKULL.get(), SaurosuchusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.SCELIDOSAURUS_SKELETON.get(), ScelidosaurusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.SCELIDOSAURUS_SKULL.get(), ScelidosaurusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.STEGOSAURUS_SKELETON.get(), StegosaurusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.STEGOSAURUS_SKULL.get(), StegosaurusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.TRICERATOPS_SKELETON.get(), TriceratopsSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.TRICERATOPS_SKULL.get(), TriceratopsSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.TYRANNOSAURUS_SKELETON.get(), TyrannosaurusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.TYRANNOSAURUS_SKULL.get(), TyrannosaurusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.VELOCIRAPTOR_SKELETON.get(), VelociraptorSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.VELOCIRAPTOR_SKULL.get(), VelociraptorSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.PSITTACOSAURUS_SKELETON.get(), PsittacosaurusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.PSITTACOSAURUS_SKULL.get(), PsittacosaurusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.YUTYRANNUS_SKULL.get(), YutyrannusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.YUTYRANNUS_SKELETON.get(), YutyrannusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.ARGANODUS.get(), ArganodusRenderer::new);
		event.registerEntityRenderer(PFEntities.CERATODUS.get(), CeratodusRenderer::new);
		event.registerEntityRenderer(PFEntities.CHINLEA.get(), ChinleaRenderer::new);
		event.registerEntityRenderer(PFEntities.CYCLURUS.get(), CyclurusRenderer::new);
		event.registerEntityRenderer(PFEntities.GAR.get(), GarRenderer::new);
		event.registerEntityRenderer(PFEntities.LONCHIDION.get(), LonchidionRenderer::new);
		event.registerEntityRenderer(PFEntities.MOOREODONTUS.get(), MooreodontusRenderer::new);
		event.registerEntityRenderer(PFEntities.MYLEDAPHUS.get(), MyledaphusRenderer::new);
		event.registerEntityRenderer(PFEntities.POTAMOCERATODUS.get(), PotamoceratodusRenderer::new);
		event.registerEntityRenderer(PFEntities.SAURICHTHYS.get(), SaurichthysRenderer::new);
		event.registerEntityRenderer(PFEntities.MELVIUS.get(), MelviusRenderer::new);
		event.registerEntityRenderer(PFEntities.THESCELOSAURUS.get(), ThescelosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.ANKYLOSAURUS.get(), AnkylosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.BASILEMYS.get(), BasilemysRenderer::new);
		event.registerEntityRenderer(PFEntities.DAKOTARAPTOR.get(), DakotaraptorRenderer::new);
		event.registerEntityRenderer(PFEntities.DIDELPHODON.get(), DidelphodonRenderer::new);
		event.registerEntityRenderer(PFEntities.TRICERATOPS.get(), TriceratopsRenderer::new);
		event.registerEntityRenderer(PFEntities.TYRANNOSAURUS.get(), TyrannosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.AEPYORNITHOMIMUS.get(), AepyornithomimusRenderer::new);
		event.registerEntityRenderer(PFEntities.CITIPATI.get(), CitipatiRenderer::new);
		event.registerEntityRenderer(PFEntities.PINACOSAURUS.get(), PinacosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.PLESIOHADROS.get(), PlesiohadrosRenderer::new);
		event.registerEntityRenderer(PFEntities.PROTOCERATOPS.get(), ProtoceratopsRenderer::new);
		event.registerEntityRenderer(PFEntities.TELMASAURUS.get(), TelmasaurusRenderer::new);	
		event.registerEntityRenderer(PFEntities.VELOCIRAPTOR.get(), VelociraptorRenderer::new);
		event.registerEntityRenderer(PFEntities.CALSOYASUCHUS.get(), CalsoyasuchusRenderer::new);
		event.registerEntityRenderer(PFEntities.DILOPHOSAURUS.get(), DilophosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.KAYENTATHERIUM.get(), KayentatheriumRenderer::new);
		event.registerEntityRenderer(PFEntities.MEGAPNOSAURUS.get(), MegapnosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.SARAHSAURUS.get(), SarahsaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.SCELIDOSAURUS.get(), ScelidosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.SCUTELLOSAURUS.get(), ScutellosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.ALLOSAURUS.get(), AllosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.CAMARASAURUS.get(), CamarasaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.CERATOSAURUS.get(), CeratosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.DRYOSAURUS.get(), DryosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.EILENODON.get(), EilenodonRenderer::new);
		event.registerEntityRenderer(PFEntities.HESPERORNITHOIDES.get(), HesperornithoidesRenderer::new);
		event.registerEntityRenderer(PFEntities.STEGOSAURUS.get(), StegosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.COELOPHYSIS.get(), CoelophysisRenderer::new);
		event.registerEntityRenderer(PFEntities.DESMATOSUCHUS.get(), DesmatosuchusRenderer::new);
		event.registerEntityRenderer(PFEntities.PLACERIAS.get(), PlaceriasRenderer::new);
		event.registerEntityRenderer(PFEntities.POPOSAURUS.get(), PoposaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.POSTOSUCHUS.get(), PostosuchusRenderer::new);
		event.registerEntityRenderer(PFEntities.TRILOPHOSAURUS.get(), TrilophosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.TYPOTHORAX.get(), TypothoraxRenderer::new);
		event.registerEntityRenderer(PFEntities.CHROMOGISAURUS.get(), ChromogisaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.EXAERETODON.get(), ExaeretodonRenderer::new);
		event.registerEntityRenderer(PFEntities.HERRERASAURUS.get(), HerrerasaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.HYPERODAPEDON.get(), HyperodapedonRenderer::new);
		event.registerEntityRenderer(PFEntities.ISCHIGUALASTIA.get(), IschigualastiaRenderer::new);
		event.registerEntityRenderer(PFEntities.SAUROSUCHUS.get(), SaurosuchusRenderer::new);
		event.registerEntityRenderer(PFEntities.SILLOSUCHUS.get(), SillosuchusRenderer::new);
		event.registerEntityRenderer(PFEntities.CAVE_SENTINEL.get(), CaveSentinelRenderer::new);
		event.registerEntityRenderer(PFEntities.LAND_SENTINEL.get(), LandSentinelRenderer::new);
		event.registerEntityRenderer(PFEntities.ACIPENSER.get(), AcipenserRenderer::new);
		event.registerEntityRenderer(PFEntities.BRACHYCHAMPSA.get(), BrachychampsaRenderer::new);
		event.registerEntityRenderer(PFEntities.PALAEOSANIWA.get(), PalaeosaniwaRenderer::new);;
		event.registerEntityRenderer(PFEntities.OVIRAPTOR.get(), OviraptorRenderer::new);
		event.registerEntityRenderer(PFEntities.DERMESTID_BEETLE.get(), DermestidBeetleRenderer::new);
		event.registerEntityRenderer(PFEntities.GOBIULUS.get(), GobiulusRenderer::new);
		event.registerEntityRenderer(PFEntities.HARENAICHTHYS.get(), HarenaichthysRenderer::new);
		event.registerEntityRenderer(PFEntities.HALSZKARAPTOR.get(), HalszkaraptorRenderer::new);
		event.registerEntityRenderer(PFEntities.UDANOCERATOPS.get(), UdanoceratopsRenderer::new);
		event.registerEntityRenderer(PFEntities.GOYOCEPHALE.get(), GoyocephaleRenderer::new);
		event.registerEntityRenderer(PFEntities.FERMENTED_GINKGO_BERRY.get(), FermentedGinkgoBerryRenderer::new);
		event.registerEntityRenderer(PFEntities.PACHYCEPHALOSAURUS.get(), PachycephalosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.ORNITHOMIMUS.get(), OrnithomimusRenderer::new);
		event.registerEntityRenderer(PFEntities.KOL.get(), KolRenderer::new);
		event.registerEntityRenderer(PFEntities.YUTYRANNUS.get(), YutyrannusRenderer::new);
		event.registerEntityRenderer(PFEntities.PSITTACOSAURUS.get(), PsittacosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.SINOSAUROPTERYX.get(), SinosauropteryxRenderer::new);
		event.registerEntityRenderer(PFEntities.INCISIVOSAURUS.get(), IncisivosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.CEPHALOLEICHNITES.get(), CephaloleichnitesRenderer::new);
		event.registerEntityRenderer(PFEntities.APOCLION.get(), ApoclionRenderer::new);
		event.registerEntityRenderer(PFEntities.CRETARANEUS.get(), CretaraneusRenderer::new);
		event.registerEntityRenderer(PFEntities.PROTOPSEPHURUS.get(), ProtopsephurusRenderer::new);
		event.registerEntityRenderer(PFEntities.SINAMIA.get(), SinamiaRenderer::new);
		event.registerEntityRenderer(PFEntities.YANOSTEUS.get(), YanosteusRenderer::new);
		event.registerEntityRenderer(PFEntities.EDMONTOSAURUS.get(), EdmontosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.BEIPIAOSAURUS.get(), BeipiaosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.ANZU.get(), AnzuRenderer::new);
		event.registerEntityRenderer(PFEntities.LIAONINGOSAURUS.get(), LiaoningosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.CHANGYURAPTOR.get(), ChangyuraptorRenderer::new);
		event.registerEntityRenderer(PFEntities.PARAPSEPHURUS.get(), ParapsephurusRenderer::new);
		event.registerEntityRenderer(PFEntities.BYRONOSAURUS.get(), ByronosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.REPENOMAMUS.get(), RepenomamusRenderer::new);
		event.registerEntityRenderer(PFEntities.RUIXINIA.get(), RuixiniaRenderer::new);
		event.registerEntityRenderer(PFEntities.DONGBEITITAN.get(), DongbeititanRenderer::new);
		event.registerEntityRenderer(PFEntities.DILONG.get(), DilongRenderer::new);
		event.registerEntityRenderer(PFEntities.LIAONEMOBIUS.get(), LiaonemobiusRenderer::new);
		event.registerEntityRenderer(PFEntities.ZHENYUANLONG.get(), ZhenyuanlongRenderer::new);
		event.registerEntityRenderer(PFEntities.JINZHOUSAURUS.get(), JinzhousaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.CERATODUS_COCOON.get(), CeratodusCocoonRenderer::new);
		event.registerEntityRenderer(PFEntities.POTAMOCERATODUS_COCOON.get(), PotamoceratodusCocoonRenderer::new);
		event.registerEntityRenderer(PFEntities.ARGANODUS_COCOON.get(), ArganodusCocoonRenderer::new);
		event.registerEntityRenderer(PFEntities.CORRUPTED_THEROPOD.get(), CorruptedTheropodRenderer::new);
		event.registerEntityRenderer(PFEntities.GOYOCEPHALE_SKULL.get(), GoyocephaleSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.GOYOCEPHALE_SKELETON.get(), GoyocephaleSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.DONGBEITITAN_SKULL.get(), DongbeititanSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.DONGBEITITAN_SKELETON.get(), DongbeititanSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.ANZU_SKULL.get(), AnzuSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.ANZU_SKELETON.get(), AnzuSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.LIAONINGOSAURUS_SKELETON.get(), LiaoningosaurusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.LIAONINGOSAURUS_SKULL.get(), LiaoningosaurusSkullRenderer::new);
		
		event.registerBlockEntityRenderer(PFBlockEntities.CHEST.get(), PFChestBlockEntityRenderer::new);
		event.registerBlockEntityRenderer(PFBlockEntities.TRAPPED_CHEST.get(), PFChestBlockEntityRenderer::new);
	}

	@SubscribeEvent
	public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(HENOS, HenosModel::createBodyLayer);
		event.registerLayerDefinition(SUMMONED_HENOS, HenosSummonedModel::createBodyLayer);
		event.registerLayerDefinition(CAVE_SENTINEL, CaveSentinelModel::createBodyLayer);
		event.registerLayerDefinition(LAND_SENTINEL, LandSentinelModel::createBodyLayer);
		event.registerLayerDefinition(CORRUPTED_THEROPOD, CorruptedTheropodModel::createBodyLayer);
		event.registerLayerDefinition(ANKYLOSAURUS_HELMET, () -> AnkylosaurusHelmetModel.createArmorLayer(new CubeDeformation(1)));
		event.registerLayerDefinition(DESMATOSUCHUS_CHESTPLATE, () -> DesmatosuchusChestplateModel.createArmorLayer(new CubeDeformation(0)));
		event.registerLayerDefinition(EGGSHELL_HELMET, () -> EggshellHelmetModel.createArmorLayer(new CubeDeformation(0)));

		//Ankylosaurus Skeleton and Skull
		event.registerLayerDefinition(ANKYLOSAURUS_SKELETON, AnkylosaurusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(ANKYLOSAURUS_SKELETON_RESTING, AnkylosaurusSkeletonRestingModel::createBodyLayer);
		event.registerLayerDefinition(ANKYLOSAURUS_SKELETON_SQUATTING, AnkylosaurusSkeletonSquattingModel::createBodyLayer);
		event.registerLayerDefinition(ANKYLOSAURUS_SKELETON_ACTION_LEFT, AnkylosaurusSkeletonActionLeftModel::createBodyLayer);
		event.registerLayerDefinition(ANKYLOSAURUS_SKELETON_ACTION_RIGHT, AnkylosaurusSkeletonActionRightModel::createBodyLayer);
		event.registerLayerDefinition(ANKYLOSAURUS_SKULL, AnkylosaurusSkullModel::createBodyLayer);
		//Allosaurus Skeleton and Skull
		event.registerLayerDefinition(ALLOSAURUS_SKELETON, AllosaurusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(ALLOSAURUS_SKELETON_RESTING, AllosaurusSkeletonRestingModel::createBodyLayer);
		event.registerLayerDefinition(ALLOSAURUS_SKELETON_RETRO, AllosaurusSkeletonRetroModel::createBodyLayer);
		event.registerLayerDefinition(ALLOSAURUS_SKELETON_ACTION_LEFT, AllosaurusSkeletonActionLeftModel::createBodyLayer);
		event.registerLayerDefinition(ALLOSAURUS_SKELETON_ACTION_RIGHT, AllosaurusSkeletonActionRightModel::createBodyLayer);
		event.registerLayerDefinition(ALLOSAURUS_SKULL, AllosaurusSkullModel::createBodyLayer);
		//Ceratosaurus Skeleton and Skull
		event.registerLayerDefinition(CERATOSAURUS_SKELETON, CeratosaurusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(CERATOSAURUS_SKELETON_RESTING, CeratosaurusSkeletonRestingModel::createBodyLayer);
		event.registerLayerDefinition(CERATOSAURUS_SKELETON_ACTION, CeratosaurusSkeletonActionModel::createBodyLayer);
		event.registerLayerDefinition(CERATOSAURUS_SKELETON_ALERT_LEFT, CeratosaurusSkeletonAlertLeftModel::createBodyLayer);
		event.registerLayerDefinition(CERATOSAURUS_SKELETON_ALERT_RIGHT, CeratosaurusSkeletonAlertRightModel::createBodyLayer);
		event.registerLayerDefinition(CERATOSAURUS_SKULL, CeratosaurusSkullModel::createBodyLayer);
		//Coelophysis Skeleton and Skull
		event.registerLayerDefinition(COELOPHYSIS_SKULL, CoelophysisSkullModel::createBodyLayer);
		event.registerLayerDefinition(COELOPHYSIS_SKELETON, CoelophysisSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(COELOPHYSIS_SKELETON_SAUNTER, CoelophysisSkeletonSaunterModel::createBodyLayer);
		event.registerLayerDefinition(COELOPHYSIS_SKELETON_SEIZE, CoelophysisSkeletonSeizeModel::createBodyLayer);
		event.registerLayerDefinition(COELOPHYSIS_SKELETON_SLEEPING, CoelophysisSkeletonSleepingModel::createBodyLayer);
		event.registerLayerDefinition(COELOPHYSIS_SKELETON_SLUMP, CoelophysisSkeletonSlumpModel::createBodyLayer);
		event.registerLayerDefinition(COELOPHYSIS_SKELETON_SLAIN, CoelophysisSkeletonSlainModel::createBodyLayer);
		event.registerLayerDefinition(COELOPHYSIS_SKELETON_STRIDE, CoelophysisSkeletonStrideModel::createBodyLayer);
		//Desmatosuchus Skeleton and Skull
		event.registerLayerDefinition(DESMATOSUCHUS_SKELETON, DesmatosuchusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(DESMATOSUCHUS_SKELETON_WALKING_LEFT, DesmatosuchusSkeletonWalkingLeftModel::createBodyLayer);
		event.registerLayerDefinition(DESMATOSUCHUS_SKELETON_WALKING_RIGHT, DesmatosuchusSkeletonWalkingRightModel::createBodyLayer);
		event.registerLayerDefinition(DESMATOSUCHUS_SKELETON_SLEEPING, DesmatosuchusSkeletonSleepingModel::createBodyLayer);
		event.registerLayerDefinition(DESMATOSUCHUS_SKULL, DesmatosuchusSkullModel::createBodyLayer);
		//Dilophosaurus Skeleton and Skull
		event.registerLayerDefinition(DILOPHOSAURUS_SKELETON, DilophosaurusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(DILOPHOSAURUS_SKELETON_ATTACK, DilophosaurusSkeletonAttackModel::createBodyLayer);
		event.registerLayerDefinition(DILOPHOSAURUS_SKELETON_STRUT, DilophosaurusSkeletonStrutModel::createBodyLayer);
		event.registerLayerDefinition(DILOPHOSAURUS_SKELETON_GAZE, DilophosaurusSkeletonGazeModel::createBodyLayer);
		event.registerLayerDefinition(DILOPHOSAURUS_SKELETON_SITTING, DilophosaurusSkeletonSittingModel::createBodyLayer);
		event.registerLayerDefinition(DILOPHOSAURUS_SKULL, DilophosaurusSkullModel::createBodyLayer);
		//Herrerasaurus Skeleton and Skull
		event.registerLayerDefinition(HERRERASAURUS_SKULL, HerrerasaurusSkullModel::createBodyLayer);
		event.registerLayerDefinition(HERRERASAURUS_SKELETON, HerrerasaurusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(HERRERASAURUS_SKELETON_ACTION, HerrerasaurusSkeletonActionModel::createBodyLayer);
		event.registerLayerDefinition(HERRERASAURUS_SKELETON_RUNNING, HerrerasaurusSkeletonRunningModel::createBodyLayer);
		//Ischigualastia Skeleton and Skull
		event.registerLayerDefinition(ISCHIGUALASTIA_SKULL, IschigualastiaSkullModel::createBodyLayer);
		event.registerLayerDefinition(ISCHIGUALASTIA_SKELETON, IschigualastiaSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(ISCHIGUALASTIA_SKELETON_STRETCHING, IschigualastiaSkeletonStretchingModel::createBodyLayer);
		//Plesiohadros Skeleton and Skull
		event.registerLayerDefinition(PLESIOHADROS_SKELETON, PlesiohadrosSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(PLESIOHADROS_SKELETON_CHARGE, PlesiohadrosSkeletonChargeModel::createBodyLayer);
		event.registerLayerDefinition(PLESIOHADROS_SKELETON_DASH_LEFT, PlesiohadrosSkeletonDashLeftModel::createBodyLayer);
		event.registerLayerDefinition(PLESIOHADROS_SKELETON_DASH_RIGHT, PlesiohadrosSkeletonDashRightModel::createBodyLayer);
		event.registerLayerDefinition(PLESIOHADROS_SKELETON_SITTING, PlesiohadrosSkeletonSittingModel::createBodyLayer);
		event.registerLayerDefinition(PLESIOHADROS_SKELETON_WALKING, PlesiohadrosSkeletonWalkingModel::createBodyLayer);
		event.registerLayerDefinition(PLESIOHADROS_SKELETON_SLEEPING, PlesiohadrosSkeletonSleepingModel::createBodyLayer);
		event.registerLayerDefinition(PLESIOHADROS_SKULL, PlesiohadrosSkullModel::createBodyLayer);
		//Postosuchus Skeleton and Skull
		event.registerLayerDefinition(POSTOSUCHUS_SKELETON, PostosuchusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(POSTOSUCHUS_SKELETON_ATTACK, PostosuchusSkeletonAttackModel::createBodyLayer);
		event.registerLayerDefinition(POSTOSUCHUS_SKELETON_ATTACK_LEFT, PostosuchusSkeletonAttackLeftModel::createBodyLayer);
		event.registerLayerDefinition(POSTOSUCHUS_SKELETON_CURIOUS, PostosuchusSkeletonCuriousModel::createBodyLayer);
		event.registerLayerDefinition(POSTOSUCHUS_SKELETON_WALKING, PostosuchusSkeletonWalkingModel::createBodyLayer);
		event.registerLayerDefinition(POSTOSUCHUS_SKELETON_SLEEPING, PostosuchusSkeletonSleepingModel::createBodyLayer);
		event.registerLayerDefinition(POSTOSUCHUS_SKULL, PostosuchusSkullModel::createBodyLayer);
		//Protoceratops Skeleton and Skull
		event.registerLayerDefinition(PROTOCERATOPS_SKELETON, ProtoceratopsSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(PROTOCERATOPS_SKELETON_DISPLAY, ProtoceratopsSkeletonDisplayModel::createBodyLayer);
		event.registerLayerDefinition(PROTOCERATOPS_SKELETON_LAYING, ProtoceratopsSkeletonLayingModel::createBodyLayer);
		event.registerLayerDefinition(PROTOCERATOPS_SKELETON_RUNNING, ProtoceratopsSkeletonRunningModel::createBodyLayer);
		event.registerLayerDefinition(PROTOCERATOPS_SKELETON_SITTING, ProtoceratopsSkeletonSittingModel::createBodyLayer);
		event.registerLayerDefinition(PROTOCERATOPS_SKULL, ProtoceratopsSkullModel::createBodyLayer);
		//Sarahsaurus Skeleton and Skull
		event.registerLayerDefinition(SARAHSAURUS_SKELETON, SarahsaurusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(SARAHSAURUS_SKELETON_EATING, SarahsaurusSkeletonEatingModel::createBodyLayer);
		event.registerLayerDefinition(SARAHSAURUS_SKELETON_SITTING, SarahsaurusSkeletonSittingModel::createBodyLayer);
		event.registerLayerDefinition(SARAHSAURUS_SKELETON_WALKING, SarahsaurusSkeletonWalkingModel::createBodyLayer);
		event.registerLayerDefinition(SARAHSAURUS_SKULL, SarahsaurusSkullModel::createBodyLayer);
		//Saurosuchus Skeleton and Skull
		event.registerLayerDefinition(SAUROSUCHUS_SKELETON, SaurosuchusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(SAUROSUCHUS_SKELETON_ACTION_RIGHT, SaurosuchusSkeletonActionRightModel::createBodyLayer);
		event.registerLayerDefinition(SAUROSUCHUS_SKELETON_ACTION_LEFT, SaurosuchusSkeletonActionLeftModel::createBodyLayer);
		event.registerLayerDefinition(SAUROSUCHUS_SKELETON_SLEEPING, SaurosuchusSkeletonSleepingModel::createBodyLayer);
		event.registerLayerDefinition(SAUROSUCHUS_SKULL, SaurosuchusSkullModel::createBodyLayer);
		//Scelidosaurus Skeleton and Skull
		event.registerLayerDefinition(SCELIDOSAURUS_SKELETON, ScelidosaurusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(SCELIDOSAURUS_SKELETON_DASHING, ScelidosaurusSkeletonDashingModel::createBodyLayer);
		event.registerLayerDefinition(SCELIDOSAURUS_SKELETON_GRAZING, ScelidosaurusSkeletonGrazingModel::createBodyLayer);
		event.registerLayerDefinition(SCELIDOSAURUS_SKELETON_SLEEPING, ScelidosaurusSkeletonSleepingModel::createBodyLayer);
		event.registerLayerDefinition(SCELIDOSAURUS_SKELETON_REACHING, ScelidosaurusSkeletonReachingModel::createBodyLayer);
		event.registerLayerDefinition(SCELIDOSAURUS_SKELETON_WALKING, ScelidosaurusSkeletonWalkingModel::createBodyLayer);
		event.registerLayerDefinition(SCELIDOSAURUS_SKULL, ScelidosaurusSkullModel::createBodyLayer);
		//Stegosaurus Skeleton and Skull
		event.registerLayerDefinition(STEGOSAURUS_SKELETON, StegosaurusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(STEGOSAURUS_SKELETON_ACTION_LEFT, StegosaurusSkeletonActionLeftModel::createBodyLayer);
		event.registerLayerDefinition(STEGOSAURUS_SKELETON_ACTION_RIGHT, StegosaurusSkeletonActionRightModel::createBodyLayer);
		event.registerLayerDefinition(STEGOSAURUS_SKELETON_SLEEPING, StegosaurusSkeletonSleepingModel::createBodyLayer);
		event.registerLayerDefinition(STEGOSAURUS_SKELETON_RETRO, StegosaurusSkeletonRetroModel::createBodyLayer);
		event.registerLayerDefinition(STEGOSAURUS_SKULL, StegosaurusSkullModel::createBodyLayer);
		//Triceratops Skeleton and Skull
		event.registerLayerDefinition(TRICERATOPS_SKELETON, TriceratopsSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(TRICERATOPS_SKELETON_CHARGING, TriceratopsSkeletonChargingModel::createBodyLayer);
		event.registerLayerDefinition(TRICERATOPS_SKELETON_SLEEPING, TriceratopsSkeletonSleepingModel::createBodyLayer);
		event.registerLayerDefinition(TRICERATOPS_SKELETON_RETRO, TriceratopsSkeletonRetroModel::createBodyLayer);
		event.registerLayerDefinition(TRICERATOPS_SKELETON_SITTING, TriceratopsSkeletonSittingModel::createBodyLayer);
		event.registerLayerDefinition(TRICERATOPS_SKELETON_ACTION_LEFT, TriceratopsSkeletonActionLeftModel::createBodyLayer);
		event.registerLayerDefinition(TRICERATOPS_SKELETON_ACTION_RIGHT, TriceratopsSkeletonActionRightModel::createBodyLayer);
		event.registerLayerDefinition(TRICERATOPS_SKULL, TriceratopsSkullModel::createBodyLayer);
		//Tyrannosaurus Skeleton and Skull
		event.registerLayerDefinition(TYRANNOSAURUS_SKELETON, TyrannosaurusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(TYRANNOSAURUS_SKELETON_STOMPING, TyrannosaurusSkeletonStompingModel::createBodyLayer);
		event.registerLayerDefinition(TYRANNOSAURUS_SKELETON_STALKING, TyrannosaurusSkeletonStalkingModel::createBodyLayer);
		event.registerLayerDefinition(TYRANNOSAURUS_SKELETON_SLEEPING, TyrannosaurusSkeletonSleepingModel::createBodyLayer);
		event.registerLayerDefinition(TYRANNOSAURUS_SKELETON_RUNNING, TyrannosaurusSkeletonRunningModel::createBodyLayer);
		event.registerLayerDefinition(TYRANNOSAURUS_SKELETON_SITTING, TyrannosaurusSkeletonSittingModel::createBodyLayer);
		event.registerLayerDefinition(TYRANNOSAURUS_SKELETON_RETRO, TyrannosaurusSkeletonRetroModel::createBodyLayer);
		event.registerLayerDefinition(TYRANNOSAURUS_SKELETON_JP, TyrannosaurusSkeletonJPModel::createBodyLayer);
		event.registerLayerDefinition(TYRANNOSAURUS_SKULL, TyrannosaurusSkullModel::createBodyLayer);
		//Velociraptor Skeleton and Skull
		event.registerLayerDefinition(VELOCIRAPTOR_SKELETON, VelociraptorSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(VELOCIRAPTOR_SKELETON_FLASHING, VelociraptorSkeletonFlashingModel::createBodyLayer);
		event.registerLayerDefinition(VELOCIRAPTOR_SKELETON_LAY_FIGHTING, VelociraptorSkeletonLayFightingModel::createBodyLayer);
		event.registerLayerDefinition(VELOCIRAPTOR_SKELETON_SLEEPING, VelociraptorSkeletonSleepingModel::createBodyLayer);
		event.registerLayerDefinition(VELOCIRAPTOR_SKELETON_STAND_FIGHTING, VelociraptorSkeletonStandFightingModel::createBodyLayer);
		event.registerLayerDefinition(VELOCIRAPTOR_SKELETON_RUNNING, VelociraptorSkeletonRunningModel::createBodyLayer);
		event.registerLayerDefinition(VELOCIRAPTOR_SKULL, VelociraptorSkullModel::createBodyLayer);
		//Psittacosaurus Skeleton and Skull
		event.registerLayerDefinition(PSITTACOSAURUS_SKELETON, PsittacosaurusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(PSITTACOSAURUS_SKELETON_LEFT, PsittacosaurusSkeletonLeftModel::createBodyLayer);
		event.registerLayerDefinition(PSITTACOSAURUS_SKELETON_MATING, PsittacosaurusSkeletonMatingModel::createBodyLayer);
		event.registerLayerDefinition(PSITTACOSAURUS_SKELETON_SAUNTER, PsittacosaurusSkeletonSaunterModel::createBodyLayer);
		event.registerLayerDefinition(PSITTACOSAURUS_SKELETON_SITTING, PsittacosaurusSkeletonSittingModel::createBodyLayer);
		event.registerLayerDefinition(PSITTACOSAURUS_SKELETON_SPRINTING, PsittacosaurusSkeletonSprintModel::createBodyLayer);
		event.registerLayerDefinition(PSITTACOSAURUS_SKULL, PsittacosaurusSkullModel::createBodyLayer);
		//Yutyrannus Skeleton and Skull
		event.registerLayerDefinition(YUTYRANNUS_SKELETON, YutyrannusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(YUTYRANNUS_SKELETON_SAUNTER, YutyrannusSkeletonSaunterModel::createBodyLayer);
		event.registerLayerDefinition(YUTYRANNUS_SKELETON_ROMP, YutyrannusSkeletonRompModel::createBodyLayer);
		event.registerLayerDefinition(YUTYRANNUS_SKELETON_FROLIC, YutyrannusSkeletonFrolicModel::createBodyLayer);
		event.registerLayerDefinition(YUTYRANNUS_SKELETON_JP, YutyrannusSkeletonJPModel::createBodyLayer);
		event.registerLayerDefinition(YUTYRANNUS_SKELETON_LEAP, YutyrannusSkeletonLeapModel::createBodyLayer);
		event.registerLayerDefinition(YUTYRANNUS_SKELETON_SUBDUED, YutyrannusSkeletonSubduedModel::createBodyLayer);
		event.registerLayerDefinition(YUTYRANNUS_SKELETON_SLEEP, YutyrannusSkeletonSleepModel::createBodyLayer);
		event.registerLayerDefinition(YUTYRANNUS_SKELETON_CARCASS, YutyrannusSkeletonCarcassModel::createBodyLayer);
		event.registerLayerDefinition(YUTYRANNUS_SKULL, YutyrannusSkullModel::createBodyLayer);
		//Goyocephale Skeleton and Skull
		event.registerLayerDefinition(GOYOCEPHALE_SKELETON, GoyocephaleSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(GOYOCEPHALE_SKELETON_STEP, GoyocephaleSkeletonStepModel::createBodyLayer);
		event.registerLayerDefinition(GOYOCEPHALE_SKELETON_SLEEP, GoyocephaleSkeletonSleepModel::createBodyLayer);
		event.registerLayerDefinition(GOYOCEPHALE_SKELETON_FEEDING, GoyocephaleSkeletonFeedingModel::createBodyLayer);
		event.registerLayerDefinition(GOYOCEPHALE_SKELETON_SIT, GoyocephaleSkeletonSitModel::createBodyLayer);
		event.registerLayerDefinition(GOYOCEPHALE_SKELETON_DEATH, GoyocephaleSkeletonDeathModel::createBodyLayer);
		event.registerLayerDefinition(GOYOCEPHALE_SKELETON_HEADBUTT_ONE, GoyocephaleSkeletonHeadbuttOneModel::createBodyLayer);
		event.registerLayerDefinition(GOYOCEPHALE_SKELETON_HEADBUTT_TWO, GoyocephaleSkeletonHeadbuttTwoModel::createBodyLayer);
		event.registerLayerDefinition(GOYOCEPHALE_SKELETON_BRACE, GoyocephaleSkeletonBraceModel::createBodyLayer);
		event.registerLayerDefinition(GOYOCEPHALE_SKELETON_REAR, GoyocephaleSkeletonRearModel::createBodyLayer);
		event.registerLayerDefinition(GOYOCEPHALE_SKULL, GoyocephaleSkullModel::createBodyLayer);
		//Dongbeititan Skeleton and Skull
		event.registerLayerDefinition(DONGBEITITAN_SKELETON, DongbeititanSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(DONGBEITITAN_SKELETON_WALK, DongbeititanSkeletonWalkModel::createBodyLayer);
		event.registerLayerDefinition(DONGBEITITAN_SKELETON_REAR, DongbeititanSkeletonRearModel::createBodyLayer);
		event.registerLayerDefinition(DONGBEITITAN_SKELETON_REACH, DongbeititanSkeletonReachModel::createBodyLayer);
		event.registerLayerDefinition(DONGBEITITAN_SKELETON_BROWSE, DongbeititanSkeletonBrowseModel::createBodyLayer);
		event.registerLayerDefinition(DONGBEITITAN_SKELETON_GRAZE, DongbeititanSkeletonGrazeModel::createBodyLayer);
		event.registerLayerDefinition(DONGBEITITAN_SKELETON_SIT, DongbeititanSkeletonSitModel::createBodyLayer);
		event.registerLayerDefinition(DONGBEITITAN_SKELETON_SLEEP, DongbeititanSkeletonSleepModel::createBodyLayer);
		event.registerLayerDefinition(DONGBEITITAN_SKELETON_DEATH, DongbeititanSkeletonDeathModel::createBodyLayer);
		event.registerLayerDefinition(DONGBEITITAN_SKULL, DongbeititanSkullModel::createBodyLayer);
		//Anzu Skeleton and Skull
		event.registerLayerDefinition(ANZU_SKELETON, AnzuSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(ANZU_SKELETON_REAR, AnzuSkeletonRearModel::createBodyLayer);
		event.registerLayerDefinition(ANZU_SKELETON_ROMP, AnzuSkeletonRompModel::createBodyLayer);
		event.registerLayerDefinition(ANZU_SKELETON_FLEE, AnzuSkeletonFleeModel::createBodyLayer);
		event.registerLayerDefinition(ANZU_SKELETON_SKULK, AnzuSkeletonSkulkModel::createBodyLayer);
		event.registerLayerDefinition(ANZU_SKELETON_DISPLAY, AnzuSkeletonDisplayModel::createBodyLayer);
		event.registerLayerDefinition(ANZU_SKELETON_BOW, AnzuSkeletonBowModel::createBodyLayer);
		event.registerLayerDefinition(ANZU_SKELETON_SIT, AnzuSkeletonSitModel::createBodyLayer);
		event.registerLayerDefinition(ANZU_SKELETON_SLEEP, AnzuSkeletonSleepModel::createBodyLayer);
		event.registerLayerDefinition(ANZU_SKELETON_DEATH, AnzuSkeletonDeathModel::createBodyLayer);
		event.registerLayerDefinition(ANZU_SKULL, AnzuSkullModel::createBodyLayer);
		//Liaoningosaurus Skeleton and Skull
		event.registerLayerDefinition(LIAONINGOSAURUS_SKELETON, LiaoningosaurusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(LIAONINGOSAURUS_SKELETON_WALK, LiaoningosaurusSkeletonWalkModel::createBodyLayer);
		event.registerLayerDefinition(LIAONINGOSAURUS_SKELETON_BRACE, LiaoningosaurusSkeletonBraceModel::createBodyLayer);
		event.registerLayerDefinition(LIAONINGOSAURUS_SKELETON_SAUNTER, LiaoningosaurusSkeletonSaunterModel::createBodyLayer);
		event.registerLayerDefinition(LIAONINGOSAURUS_SKELETON_GAZE, LiaoningosaurusSkeletonGazeModel::createBodyLayer);
		event.registerLayerDefinition(LIAONINGOSAURUS_SKELETON_CLOBBER, LiaoningosaurusSkeletonClobberModel::createBodyLayer);
		event.registerLayerDefinition(LIAONINGOSAURUS_SKELETON_DEFENSIVE, LiaoningosaurusSkeletonDefensiveModel::createBodyLayer);
		event.registerLayerDefinition(LIAONINGOSAURUS_SKELETON_SIT, LiaoningosaurusSkeletonSitModel::createBodyLayer);
		event.registerLayerDefinition(LIAONINGOSAURUS_SKELETON_SLEEP, LiaoningosaurusSkeletonSleepModel::createBodyLayer);
		event.registerLayerDefinition(LIAONINGOSAURUS_SKELETON_DEATH, LiaoningosaurusSkeletonDeathModel::createBodyLayer);
		event.registerLayerDefinition(LIAONINGOSAURUS_SKULL, LiaoningosaurusSkullModel::createBodyLayer);
		//Fish
		event.registerLayerDefinition(ACIPENSER, AcipenserModel::createBodyLayer);
		event.registerLayerDefinition(ARGANODUS, ArganodusModel::createBodyLayer);
		event.registerLayerDefinition(CERATODUS, CeratodusModel::createBodyLayer);
		event.registerLayerDefinition(CHINLEA, ChinleaModel::createBodyLayer);
		event.registerLayerDefinition(CYCLURUS, CyclurusModel::createBodyLayer);
		event.registerLayerDefinition(GAR, GarModel::createBodyLayer);
		event.registerLayerDefinition(HARENAICHTHYS, HarenaichthysModel::createBodyLayer);
		event.registerLayerDefinition(LONCHIDION, LonchidionModel::createBodyLayer);
		event.registerLayerDefinition(MOOREODONTUS, MooreodontusModel::createBodyLayer);
		event.registerLayerDefinition(MELVIUS, MelviusModel::createBodyLayer);
		event.registerLayerDefinition(MYLEDAPHUS, MyledaphusModel::createBodyLayer);
		event.registerLayerDefinition(POTAMOCERATODUS, PotamoceratodusModel::createBodyLayer);
		event.registerLayerDefinition(PROTOPSEPHURUS, ProtopsephurusModel::createBodyLayer);
		event.registerLayerDefinition(SAURICHTHYS, SaurichthysModel::createBodyLayer);
		event.registerLayerDefinition(SINAMIA, SinamiaModel::createBodyLayer);
		event.registerLayerDefinition(YANOSTEUS, YanosteusModel::createBodyLayer);
		event.registerLayerDefinition(PARAPSEPHURUS, ParapsephurusModel::createBodyLayer);
		event.registerLayerDefinition(LUNGFISH_COCOON, LungfishCocoonModel::createBodyLayer);
		//Hell Creek
		event.registerLayerDefinition(THESCELOSAURUS, ThescelosaurusModel::createBodyLayer);
		event.registerLayerDefinition(BASILEMYS, BasilemysModel::createBodyLayer);
		event.registerLayerDefinition(ANKYLOSAURUS, AnkylosaurusModel::createBodyLayer);
		event.registerLayerDefinition(ANKYLOSAURUS_BABY, AnkylosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(DAKOTARAPTOR, DakotaraptorModel::createBodyLayer);
		event.registerLayerDefinition(DAKOTARAPTOR_BABY, DakotaraptorBabyModel::createBodyLayer);
		event.registerLayerDefinition(DIDELPHODON, DidelphodonModel::createBodyLayer);
		event.registerLayerDefinition(EDMONTOSAURUS, EdmontosaurusModel::createHipsLayer);
		event.registerLayerDefinition(EDMONTOSAURUS_JUVENILE, EdmontosaurusJuvenileModel::createBodyLayer);
		event.registerLayerDefinition(EDMONTOSAURUS_BABY, EdmontosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(ORNITHOMIMUS, OrnithomimusModel::createBodyLayer);
		event.registerLayerDefinition(ORNITHOMIMUS_BABY, OrnithomimusBabyModel::createBodyLayer);
		event.registerLayerDefinition(PALAEOSANIWA, PalaeosaniwaModel::createBodyLayer);
		event.registerLayerDefinition(TRICERATOPS, TriceratopsModel::createBodyLayer);
		event.registerLayerDefinition(TRICERATOPS_JUVENILE, TriceratopsJuvenileModel::createBodyLayer);
		event.registerLayerDefinition(TRICERATOPS_BABY, TriceratopsBabyModel::createBodyLayer);
		event.registerLayerDefinition(TYRANNOSAURUS, TyrannosaurusModel::createBodyLayer);
		event.registerLayerDefinition(TYRANNOSAURUS_JUVENILE, TyrannosaurusJuvenileModel::createBodyLayer);
		event.registerLayerDefinition(TYRANNOSAURUS_BABY, TyrannosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(BRACHYCHAMPSA, BrachychampsaModel::createBodyLayer);
		event.registerLayerDefinition(PACHYCEPHALOSAURUS, PachycephalosaurusModel::createBodyLayer);
		event.registerLayerDefinition(CEPHALOLEICHNITES, CephaloleichnitesModel::createBodyLayer);
		event.registerLayerDefinition(ANZU, AnzuModel::createBodyLayer);
		event.registerLayerDefinition(ANZU_BABY, AnzuBabyModel::createBodyLayer);
		//Djadochta
		event.registerLayerDefinition(AEPYORNITHOMIMUS, AepyornithomimusModel::createBodyLayer);
		event.registerLayerDefinition(CITIPATI, CitipatiModel::createBodyLayer);
		event.registerLayerDefinition(OVIRAPTOR, OviraptorModel::createBodyLayer);
		event.registerLayerDefinition(PINACOSAURUS, PinacosaurusModel::createBodyLayer);
		event.registerLayerDefinition(PINACOSAURUS_BABY, PinacosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(PLESIOHADROS, PlesiohadrosModel::createBodyLayer);
		event.registerLayerDefinition(PLESIOHADROS_BABY, PlesiohadrosBabyModel::createBodyLayer);
		event.registerLayerDefinition(PROTOCERATOPS, ProtoceratopsModel::createBodyLayer);
		event.registerLayerDefinition(PROTOCERATOPS_JUVENILE, ProtoceratopsJuvenileModel::createBodyLayer);
		event.registerLayerDefinition(TELMASAURUS, TelmasaurusModel::createBodyLayer);
		event.registerLayerDefinition(VELOCIRAPTOR, VelociraptorModel::createBodyLayer);
		event.registerLayerDefinition(HALSZKARAPTOR, HalszkaraptorModel::createBodyLayer);
		event.registerLayerDefinition(DERMESTID_BEETLE, DermestidBeetleModel::createBodyLayer);
		event.registerLayerDefinition(GOBIULUS, GobiulusModel::createBodyLayer);
		event.registerLayerDefinition(UDANOCERATOPS, UdanoceratopsModel::createBodyLayer);
		event.registerLayerDefinition(UDANOCERATOPS_BABY, UdanoceratopsBabyModel::createBodyLayer);
		event.registerLayerDefinition(GOYOCEPHALE, GoyocephaleModel::createBodyLayer);
		event.registerLayerDefinition(KOL, KolModel::createBodyLayer);
		event.registerLayerDefinition(BYRONOSAURUS, ByronosaurusModel::createBodyLayer);
		//Yixian
		event.registerLayerDefinition(BEIPIAOSAURUS, BeipiaosaurusModel::createBodyLayer);
		event.registerLayerDefinition(CHANGYURAPTOR, ChangyuraptorModel::createBodyLayer);
		event.registerLayerDefinition(DILONG, DilongModel::createBodyLayer);
		event.registerLayerDefinition(DONGBEITITAN, DongbeititanModel::createBodyLayer);
		event.registerLayerDefinition(DONGBEITITAN_JUVENILE, DongbeititanJuvenileModel::createBodyLayer);
		event.registerLayerDefinition(DONGBEITITAN_BABY, DongbeititanBabyModel::createBodyLayer);
		event.registerLayerDefinition(INCISIVOSAURUS, IncisivosaurusModel::createBodyLayer);
		event.registerLayerDefinition(JINZHOUSAURUS, JinzhousaurusModel::createBodyLayer);
		event.registerLayerDefinition(JINZHOUSAURUS_BABY, JinzhousaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(LIAONINGOSAURUS, LiaoningosaurusModel::createBodyLayer);
		event.registerLayerDefinition(PSITTACOSAURUS, PsittacosaurusModel::createBodyLayer);
		event.registerLayerDefinition(REPENOMAMUS, RepenomamusModel::createBodyLayer);
		event.registerLayerDefinition(RUIXINIA, RuixiniaModel::createBodyLayer);
		event.registerLayerDefinition(RUIXINIA_BABY, RuixiniaBabyModel::createBodyLayer);
		event.registerLayerDefinition(SINOSAUROPTERYX, SinosauropteryxModel::createBodyLayer);;
		event.registerLayerDefinition(YUTYRANNUS, YutyrannusModel::createBodyLayer);
		event.registerLayerDefinition(YUTYRANNUS_BABY, YutyrannusBabyModel::createBodyLayer);
		event.registerLayerDefinition(APOCLION, ApoclionModel::createBodyLayer);
		event.registerLayerDefinition(CRETARANEUS, CretaraneusModel::createBodyLayer);
		event.registerLayerDefinition(LIAONEMOBIUS, LiaonemobiusModel::createBodyLayer);
		event.registerLayerDefinition(ZHENYUANLONG, ZhenyuanlongModel::createBodyLayer);
		//Kayenta
		event.registerLayerDefinition(CALSOYASUCHUS, CalsoyasuchusModel::createBodyLayer);
		event.registerLayerDefinition(DILOPHOSAURUS, DilophosaurusModel::createBodyLayer);
		event.registerLayerDefinition(DILOPHOSAURUS_BABY, DilophosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(KAYENTATHERIUM, KayentatheriumModel::createBodyLayer);
		event.registerLayerDefinition(MEGAPNOSAURUS, MegapnosaurusModel::createBodyLayer);
		event.registerLayerDefinition(SARAHSAURUS, SarahsaurusModel::createBodyLayer);
		event.registerLayerDefinition(SCELIDOSAURUS, ScelidosaurusModel::createBodyLayer);
		event.registerLayerDefinition(SCUTELLOSAURUS, ScutellosaurusModel::createBodyLayer);
		//Morrison
		event.registerLayerDefinition(ALLOSAURUS, AllosaurusModel::createBodyLayer);
		event.registerLayerDefinition(ALLOSAURUS_BABY, AllosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(CAMARASAURUS, CamarasaurusModel::createBodyLayer);
		event.registerLayerDefinition(CAMARASAURUS_JUVENILE, CamarasaurusJuvenileModel::createBodyLayer);
		event.registerLayerDefinition(CAMARASAURUS_BABY, CamarasaurusBabyModel::createTorsoLayer);
		event.registerLayerDefinition(CAMARASAURUS_HATCHLING, CamarasaurusHatchlingModel::createBodyLayer);
		event.registerLayerDefinition(CERATOSAURUS, CeratosaurusModel::createBodyLayer);
		event.registerLayerDefinition(CERATOSAURUS_BABY, CeratosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(DRYOSAURUS, DryosaurusModel::createBodyLayer);
		event.registerLayerDefinition(EILENODON, EilenodonModel::createBodyLayer);
		event.registerLayerDefinition(HESPERORNITHOIDES, HesperornithoidesModel::createBodyLayer);
		event.registerLayerDefinition(STEGOSAURUS, StegosaurusModel::createBodyLayer);
		event.registerLayerDefinition(STEGOSAURUS_BABY, StegosaurusBabyModel::createBodyLayer);
		//Chinle
		event.registerLayerDefinition(COELOPHYSIS, CoelophysisModel::createBodyLayer);
		event.registerLayerDefinition(DESMATOSUCHUS, DesmatosuchusModel::createBodyLayer);
		event.registerLayerDefinition(PLACERIAS, PlaceriasModel::createBodyLayer);
		event.registerLayerDefinition(POPOSAURUS, PoposaurusModel::createBodyLayer);
		event.registerLayerDefinition(POSTOSUCHUS, PostosuchusModel::createBodyLayer);
		event.registerLayerDefinition(TRILOPHOSAURUS, TrilophosaurusModel::createBodyLayer);
		event.registerLayerDefinition(TYPOTHORAX, TypothoraxModel::createBodyLayer);
		//Ischigualasto
		event.registerLayerDefinition(CHROMOGISAURUS, ChromogisaurusModel::createBodyLayer);
		event.registerLayerDefinition(EXAERETODON, ExaeretodonModel::createBodyLayer);
		event.registerLayerDefinition(HERRERASAURUS, HerrerasaurusModel::createBodyLayer);
		event.registerLayerDefinition(HYPERODAPEDON, HyperodapedonModel::createBodyLayer);
		event.registerLayerDefinition(ISCHIGUALASTIA, IschigualastiaModel::createBodyLayer);
		event.registerLayerDefinition(ISCHIGUALASTIA_BABY, IschigualastiaBabyModel::createBodyLayer);
		event.registerLayerDefinition(SAUROSUCHUS, SaurosuchusModel::createBodyLayer);
		event.registerLayerDefinition(SAUROSUCHUS_BABY, SaurosuchusBabyModel::createBodyLayer);
		event.registerLayerDefinition(SILLOSUCHUS, SillosuchusModel::createBodyLayer);
		event.registerLayerDefinition(SILLOSUCHUS_BABY, SillosuchusBabyModel::createBodyLayer);
	}

	@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
	public static class ForgeBusEvents {

		@SubscribeEvent
		public static void onKeyPress(InputEvent.Key event) {
			Minecraft mc = Minecraft.getInstance();
			if (mc.level == null) return;
			onInput(mc, event.getKey(), event.getAction());
		}

		@SubscribeEvent
		public static void onMouseClick(InputEvent.MouseButton event) {
			Minecraft mc = Minecraft.getInstance();
			if (mc.level == null) return;
			onInput(mc, event.getButton(), event.getAction());
		}

		private static void onInput(Minecraft mc, int key, int action) {
			if (mc.screen == null && PFKeybinds.sinkKey.consumeClick()) {
				PrehistoricFauna.NETWORK_WRAPPER.sendToServer(new KeyInputMessage(key));
			}
		}
	}


	@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
	public class InputEvents {

		@SubscribeEvent
		public static void onKeyPress(InputEvent.Key event) {
			Minecraft mc = Minecraft.getInstance();
			if (mc.level == null) return;
			onInput(mc, event.getKey(), event.getAction());
		}

		@SubscribeEvent
		public static void onMouseClick(InputEvent.MouseButton event) {
			Minecraft mc = Minecraft.getInstance();
			if (mc.level == null) return;
			onInput(mc, event.getButton(), event.getAction());
		}

		private static void onInput(Minecraft mc, int key, int action) {
			if (mc.screen == null && PFKeybinds.sinkKey.consumeClick()) {
				PrehistoricFauna.NETWORK_WRAPPER.sendToServer(new KeyInputMessage(key));
			}
		}

	}

	@SuppressWarnings({ "resource", "unused" })
	public static void renderVanillaMapDecoration(MapDecoration mapdecoration, int k) {
        if(mapdecoration.getType() == PFMapTypes.TIME_TEMPLE){
            MultiBufferSource multiBufferSource = lastVanillaMapRenderBuffer == null ? Minecraft.getInstance().renderBuffers().bufferSource() : lastVanillaMapRenderBuffer;
            PoseStack poseStack = lastVanillaMapPoseStack == null ? new PoseStack() : lastVanillaMapPoseStack;
            poseStack.pushPose();
            poseStack.translate(0.0F + (float)mapdecoration.getX() / 2.0F + 64.0F, 0.0F + (float)mapdecoration.getY() / 2.0F + 64.0F, -0.02F);
            poseStack.mulPose(Axis.ZP.rotationDegrees((float)(mapdecoration.getRot() * 360) / 16.0F));
            poseStack.scale(4.0F, 4.0F, 3.0F);
            poseStack.translate(-0.125F, 0.125F, 0.0F);
            byte b0 = PFMapTypes.getMapIconRenderOrdinal(mapdecoration.getType());
            float f1 = (float)(b0 % 16 + 0) / 16.0F;
            float f2 = (float)(b0 / 16 + 0) / 16.0F;
            float f3 = (float)(b0 % 16 + 1) / 16.0F;
            float f4 = (float)(b0 / 16 + 1) / 16.0F;
            Matrix4f matrix4f1 = poseStack.last().pose();
            float f5 = -0.001F;
            VertexConsumer vertexconsumer1 = multiBufferSource.getBuffer(TIME_TEMPLE_MAP_ICONS);
            vertexconsumer1.vertex(matrix4f1, -1.0F, 1.0F, (float)k * -0.001F).color(255, 255, 255, 255).uv(f1, f2).uv2(lastVanillaMapRenderPackedLight).endVertex();
            vertexconsumer1.vertex(matrix4f1, 1.0F, 1.0F, (float)k * -0.001F).color(255, 255, 255, 255).uv(f3, f2).uv2(lastVanillaMapRenderPackedLight).endVertex();
            vertexconsumer1.vertex(matrix4f1, 1.0F, -1.0F, (float)k * -0.001F).color(255, 255, 255, 255).uv(f3, f4).uv2(lastVanillaMapRenderPackedLight).endVertex();
            vertexconsumer1.vertex(matrix4f1, -1.0F, -1.0F, (float)k * -0.001F).color(255, 255, 255, 255).uv(f1, f4).uv2(lastVanillaMapRenderPackedLight).endVertex();
            poseStack.popPose();
            if (mapdecoration.getName() != null) {
                Font font = Minecraft.getInstance().font;
                Component component = mapdecoration.getName();
                float f6 = (float)font.width(component);
                float f7 = Mth.clamp(25.0F / f6, 0.0F, 6.0F / 9.0F);
                poseStack.pushPose();
                poseStack.translate(0.0F + (float)mapdecoration.getX() / 2.0F + 64.0F - f6 * f7 / 2.0F, 0.0F + (float)mapdecoration.getY() / 2.0F + 64.0F + 4.0F, -0.025F);
                poseStack.scale(f7, f7, 1.0F);
                poseStack.translate(0.0F, 0.0F, -0.1F);
                font.drawInBatch(component, 0.0F, 0.0F, -1, false, poseStack.last().pose(), multiBufferSource, Font.DisplayMode.NORMAL, Integer.MIN_VALUE, lastVanillaMapRenderPackedLight);
                poseStack.popPose();
            }
        }
    }
}
