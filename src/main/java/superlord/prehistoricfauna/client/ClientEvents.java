package superlord.prehistoricfauna.client;

import org.joml.Matrix4f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
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
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.gui.*;
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
import superlord.prehistoricfauna.client.model.jurassic.shaximiao.*;
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
import superlord.prehistoricfauna.client.render.jurassic.shaximiao.*;
import superlord.prehistoricfauna.client.render.triassic.chinle.*;
import superlord.prehistoricfauna.client.render.triassic.ischigualasto.*;
import superlord.prehistoricfauna.client.util.PFChestBlockEntityRenderer;
import superlord.prehistoricfauna.common.network.KeyInputMessage;
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
		BlockEntityRenderers.register(PFBlockEntities.SIGN.get(), SignRenderer::new);
		BlockEntityRenderers.register(PFBlockEntities.HANGING_SIGN.get(), HangingSignRenderer::new);
		event.enqueueWork(() -> {
			Sheets.addWoodType(PFWoodTypes.METASEQUOIA);
			Sheets.addWoodType(PFWoodTypes.ARAUCARIA);
			Sheets.addWoodType(PFWoodTypes.PROTOPICEOXYLON);
			Sheets.addWoodType(PFWoodTypes.LIRIODENDRITES);
			Sheets.addWoodType(PFWoodTypes.MONANTHESIA);
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
			Sheets.addWoodType(PFWoodTypes.CUPRESSINOCLADUS);
			Sheets.addWoodType(PFWoodTypes.ELATIDES);
			Sheets.addWoodType(PFWoodTypes.PHOENICOPSIS);
			Sheets.addWoodType(PFWoodTypes.FRENELOPSIS);
			Sheets.addWoodType(PFWoodTypes.BAIERA);
		});
		MenuScreens.register(PFContainers.PALEOSCRIBE.get(), GuiPaleo::new);
		MenuScreens.register(PFContainers.PALEONTOLOGY_TABLE.get(), GuiPaleontologyTable::new);
		MenuScreens.register(PFContainers.SARAHSAURUS.get(), SarahsaurusScreen::new);
		MenuScreens.register(PFContainers.CAMPTOSAURUS.get(), CamptosaurusScreen::new);
		MenuScreens.register(PFContainers.SHUNOSAURUS.get(), ShunosaurusScreen::new);
		ClientProxy.setupBlockRenders();
	}

	//Skulls
	public static ModelLayerLocation GOYOCEPHALE_SKULL = createLayer("goyocephale_skull");
	public static ModelLayerLocation PLESIOHADROS_SKULL = createLayer("plesiohadros_skull");
	public static ModelLayerLocation PROTOCERATOPS_SKULL = createLayer("protoceratops_skull");
	public static ModelLayerLocation VELOCIRAPTOR_SKULL = createLayer("velociraptor_skull");
	public static ModelLayerLocation ANKYLOSAURUS_SKULL = createLayer("ankylosaurus_skull");
	public static ModelLayerLocation ANZU_SKULL = createLayer("anzu_skull");
	public static ModelLayerLocation TRICERATOPS_SKULL = createLayer("triceratops_skull");
	public static ModelLayerLocation TYRANNOSAURUS_SKULL = createLayer("tyrannosaurus_skull");
	public static ModelLayerLocation DONGBEITITAN_SKULL = createLayer("dongbeititan_skull");
	public static ModelLayerLocation LIAONINGOSAURUS_SKULL = createLayer("liaoningosaurus_skull");
	public static ModelLayerLocation PSITTACOSAURUS_SKULL = createLayer("psittacosaurus_skull");
	public static ModelLayerLocation YUTYRANNUS_SKULL = createLayer("yutyrannus_skull");
	public static ModelLayerLocation DILOPHOSAURUS_SKULL = createLayer("dilophosaurus_skull");
	public static ModelLayerLocation KAYENTAVENATOR_SKULL = createLayer("kayentavenator_skull");
	public static ModelLayerLocation SARAHSAURUS_SKULL = createLayer("sarahsaurus_skull");
	public static ModelLayerLocation SCELIDOSAURUS_SKULL = createLayer("scelidosaurus_skull");
	public static ModelLayerLocation ALLOSAURUS_SKULL = createLayer("allosaurus_skull");
	public static ModelLayerLocation BRACHIOSAURUS_SKULL = createLayer("brachiosaurus_skull");
	public static ModelLayerLocation CERATOSAURUS_SKULL = createLayer("ceratosaurus_skull");
	public static ModelLayerLocation STEGOSAURUS_SKULL = createLayer("stegosaurus_skull");
	public static ModelLayerLocation CHUANDONGOCOELURUS_SKULL = createLayer("chuandongocoelurus_skull");
	public static ModelLayerLocation SHUNOSAURUS_SKULL = createLayer("shunosaurus_skull");
	public static ModelLayerLocation YANGCHUANOSAURUS_SKULL = createLayer("yangchuanosaurus_skull");
	public static ModelLayerLocation COELOPHYSIS_SKULL = createLayer("coelophysis_skull");
	public static ModelLayerLocation DESMATOSUCHUS_SKULL = createLayer("desmatosuchus_skull");
	public static ModelLayerLocation POSTOSUCHUS_SKULL = createLayer("postosuchus_skull");
	public static ModelLayerLocation HERRERASAURUS_SKULL = createLayer("herrerasaurus_skull");
	public static ModelLayerLocation ISCHIGUALASTIA_SKULL = createLayer("ischigualastia_skull");
	public static ModelLayerLocation SAUROSUCHUS_SKULL = createLayer("saurosuchus_skull");

	//Skeletons
	public static ModelLayerLocation PLESIOHADROS_SKELETON = createLayer("plesiohadros_skeleton");
	public static ModelLayerLocation PLESIOHADROS_SKELETON_CHARGE = createLayer("plesiohadros_skeleton_charge");
	public static ModelLayerLocation PLESIOHADROS_SKELETON_DASH_LEFT = createLayer("plesiohadros_skeleton_dash_left");
	public static ModelLayerLocation PLESIOHADROS_SKELETON_DASH_RIGHT = createLayer("plesiohadros_skeleton_dash_right");
	public static ModelLayerLocation PLESIOHADROS_SKELETON_SITTING = createLayer("plesiohadros_skeleton_sitting");
	public static ModelLayerLocation PLESIOHADROS_SKELETON_SLEEPING = createLayer("plesiohadros_skeleton_sleeping");
	public static ModelLayerLocation PLESIOHADROS_SKELETON_WALKING = createLayer("plesiohadros_skeleton_walking");
	public static ModelLayerLocation PROTOCERATOPS_SKELETON = createLayer("protoceratops_skeleton");
	public static ModelLayerLocation PROTOCERATOPS_SKELETON_DISPLAY = createLayer("protoceratops_skeleton_display");
	public static ModelLayerLocation PROTOCERATOPS_SKELETON_LAYING = createLayer("protoceratops_skeleton_laying");
	public static ModelLayerLocation PROTOCERATOPS_SKELETON_RUNNING = createLayer("protoceratops_skeleton_running");
	public static ModelLayerLocation PROTOCERATOPS_SKELETON_SITTING = createLayer("protoceratops_skeleton_sitting");
	public static ModelLayerLocation VELOCIRAPTOR_SKELETON = createLayer("velociraptor_skeleton");
	public static ModelLayerLocation VELOCIRAPTOR_SKELETON_STAND_FIGHTING = createLayer("velociraptor_skeleton_stand_fighting");
	public static ModelLayerLocation VELOCIRAPTOR_SKELETON_SLEEPING = createLayer("velociraptor_skeleton_sleeping");
	public static ModelLayerLocation VELOCIRAPTOR_SKELETON_RUNNING = createLayer("velociraptor_skeleton_running");
	public static ModelLayerLocation VELOCIRAPTOR_SKELETON_LAY_FIGHTING = createLayer("velociraptor_skeleton_lay_fighting");
	public static ModelLayerLocation VELOCIRAPTOR_SKELETON_FLASHING = createLayer("velociraptor_skeleton_flashing");
	public static ModelLayerLocation ANKYLOSAURUS_SKELETON = createLayer("ankylosaurus_skeleton");
	public static ModelLayerLocation ANKYLOSAURUS_SKELETON_RESTING = createLayer("ankylosaurus_skeleton_resting");
	public static ModelLayerLocation ANKYLOSAURUS_SKELETON_ACTION_RIGHT = createLayer("ankylosaurus_skeleton_action_right");
	public static ModelLayerLocation ANKYLOSAURUS_SKELETON_ACTION_LEFT = createLayer("ankylosaurus_skeleton_action_left");
	public static ModelLayerLocation ANKYLOSAURUS_SKELETON_SQUATTING = createLayer("ankylosaurus_skeleton_squatting");
	public static ModelLayerLocation ANZU_SKELETON = createLayer("anzu_skeleton");
	public static ModelLayerLocation ANZU_SKELETON_REAR = createLayer("anzu_skeleton_rear");
	public static ModelLayerLocation ANZU_SKELETON_ROMP = createLayer("anzu_skeleton_romp");
	public static ModelLayerLocation ANZU_SKELETON_FLEE = createLayer("anzu_skeleton_flee");
	public static ModelLayerLocation ANZU_SKELETON_SKULK = createLayer("anzu_skeleton_skulk");
	public static ModelLayerLocation ANZU_SKELETON_DISPLAY = createLayer("anzu_skeleton_display");
	public static ModelLayerLocation ANZU_SKELETON_BOW = createLayer("anzu_skeleton_bow");
	public static ModelLayerLocation ANZU_SKELETON_SIT = createLayer("anzu_skeleton_sit");
	public static ModelLayerLocation ANZU_SKELETON_SLEEP = createLayer("anzu_skeleton_sleep");
	public static ModelLayerLocation ANZU_SKELETON_DEATH = createLayer("anzu_skeleton_death");
	public static ModelLayerLocation TRICERATOPS_SKELETON = createLayer("triceratops_skeleton");
	public static ModelLayerLocation TRICERATOPS_SKELETON_CHARGING = createLayer("triceratops_skeleton_charging");
	public static ModelLayerLocation TRICERATOPS_SKELETON_RETRO = createLayer("triceratops_skeleton_retro");
	public static ModelLayerLocation TRICERATOPS_SKELETON_SLEEPING = createLayer("triceratops_skeleton_sleeping");
	public static ModelLayerLocation TRICERATOPS_SKELETON_SITTING = createLayer("triceratops_skeleton_sitting");
	public static ModelLayerLocation TRICERATOPS_SKELETON_ACTION_LEFT = createLayer("triceratops_skeleton_action_left");
	public static ModelLayerLocation TRICERATOPS_SKELETON_ACTION_RIGHT = createLayer("triceratops_skeleton_action_right");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON = createLayer("tyrannosaurus_skeleton");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON_SLEEPING = createLayer("tyrannosaurus_skeleton_sleeping");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON_STOMPING = createLayer("tyrannosaurus_skeleton_stomping");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON_STALKING = createLayer("tyrannosaurus_skeleton_stalking");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON_RUNNING = createLayer("tyrannosaurus_skeleton_running");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON_RETRO = createLayer("tyrannosaurus_skeleton_retro");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON_SITTING = createLayer("tyrannosaurus_skeleton_sitting");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON_JP = createLayer("tyrannosaurus_skeleton_jp");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON_STARGAZING = createLayer("tyrannosaurus_skeleton_stargazing");
	public static ModelLayerLocation TYRANNOSAURUS_SKELETON_CONDESCEND = createLayer("tyrannosaurus_skeleton_condescend");
	public static ModelLayerLocation DILOPHOSAURUS_SKELETON = createLayer("dilophosaurus_skeleton");
	public static ModelLayerLocation DILOPHOSAURUS_SKELETON_ATTACK = createLayer("dilophosaurus_skeleton_attack");
	public static ModelLayerLocation DILOPHOSAURUS_SKELETON_GAZE = createLayer("dilophosaurus_skeleton_gaze");
	public static ModelLayerLocation DILOPHOSAURUS_SKELETON_SITTING = createLayer("dilophosaurus_skeleton_sitting");
	public static ModelLayerLocation DILOPHOSAURUS_SKELETON_STRUT = createLayer("dilophosaurus_skeleton_strut");
	public static ModelLayerLocation SARAHSAURUS_SKELETON = createLayer("sarahsaurus_skeleton");
	public static ModelLayerLocation SARAHSAURUS_SKELETON_EATING = createLayer("sarahsaurus_skeleton_eating");
	public static ModelLayerLocation SARAHSAURUS_SKELETON_SITTING = createLayer("sarahsaurus_skeleton_sitting");
	public static ModelLayerLocation SARAHSAURUS_SKELETON_WALKING = createLayer("sarahsaurus_skeleton_walking");
	public static ModelLayerLocation SCELIDOSAURUS_SKELETON = createLayer("scelidosaurus_skeleton");
	public static ModelLayerLocation SCELIDOSAURUS_SKELETON_DASHING = createLayer("scelidosaurus_skeleton_dashing");
	public static ModelLayerLocation SCELIDOSAURUS_SKELETON_GRAZING = createLayer("scelidosaurus_skeleton_grazing");
	public static ModelLayerLocation SCELIDOSAURUS_SKELETON_REACHING = createLayer("scelidosaurus_skeleton_reaching");
	public static ModelLayerLocation SCELIDOSAURUS_SKELETON_SLEEPING = createLayer("scelidosaurus_skeleton_sleeping");
	public static ModelLayerLocation SCELIDOSAURUS_SKELETON_WALKING = createLayer("scelidosaurus_skeleton_walking");
	public static ModelLayerLocation ALLOSAURUS_SKELETON = createLayer("allosaurus_skeleton");
	public static ModelLayerLocation ALLOSAURUS_SKELETON_ACTION_LEFT = createLayer("allosaurus_skeleton_action_left");
	public static ModelLayerLocation ALLOSAURUS_SKELETON_ACTION_RIGHT = createLayer("allosaurus_skeleton_action_right");
	public static ModelLayerLocation ALLOSAURUS_SKELETON_RETRO = createLayer("allosaurus_skeleton_retro");
	public static ModelLayerLocation ALLOSAURUS_SKELETON_RESTING = createLayer("allosaurus_skeleton_resting");
	public static ModelLayerLocation CERATOSAURUS_SKELETON = createLayer("ceratosaurus_skeleton");
	public static ModelLayerLocation CERATOSAURUS_SKELETON_ACTION = createLayer("ceratosaurus_skeleton_action");
	public static ModelLayerLocation CERATOSAURUS_SKELETON_RESTING = createLayer("ceratosaurus_skeleton_resting");
	public static ModelLayerLocation CERATOSAURUS_SKELETON_ALERT_RIGHT = createLayer("ceratosaurus_skeleton_alert_right");
	public static ModelLayerLocation CERATOSAURUS_SKELETON_ALERT_LEFT = createLayer("ceratosaurus_skeleton_alert_left");
	public static ModelLayerLocation STEGOSAURUS_SKELETON = createLayer("stegosaurus_skeleton");
	public static ModelLayerLocation STEGOSAURUS_SKELETON_ACTION_LEFT = createLayer("stegosaurus_skeleton_action_left");
	public static ModelLayerLocation STEGOSAURUS_SKELETON_ACTION_RIGHT = createLayer("stegosaurus_skeleton_action_right");
	public static ModelLayerLocation STEGOSAURUS_SKELETON_RETRO = createLayer("stegosaurus_skeleton_retro");
	public static ModelLayerLocation STEGOSAURUS_SKELETON_SLEEPING = createLayer("stegosaurus_skeleton_sleeping");
	public static ModelLayerLocation STEGOSAURUS_SKELETON_SITTING = createLayer("stegosaurus_skeleton_sitting");
	public static ModelLayerLocation STEGOSAURUS_SKELETON_DISPLAY = createLayer("stegosaurus_skeleton_display");
	public static ModelLayerLocation COELOPHYSIS_SKELETON = createLayer("coelophysis_skeleton");
	public static ModelLayerLocation COELOPHYSIS_SKELETON_SAUNTER = createLayer("coelophysis_skeleton_saunter");
	public static ModelLayerLocation COELOPHYSIS_SKELETON_SEIZE = createLayer("coelophysis_skeleton_seize");
	public static ModelLayerLocation COELOPHYSIS_SKELETON_SLAIN = createLayer("coelophysis_skeleton_slain");
	public static ModelLayerLocation COELOPHYSIS_SKELETON_SLEEPING = createLayer("coelophysis_skeleton_sleeping");
	public static ModelLayerLocation COELOPHYSIS_SKELETON_SLUMP = createLayer("coelophysis_skeleton_slump");
	public static ModelLayerLocation COELOPHYSIS_SKELETON_STRIDE = createLayer("coelophysis_skeleton_stride");
	public static ModelLayerLocation DESMATOSUCHUS_SKELETON = createLayer("desmatosuchus_skeleton");
	public static ModelLayerLocation DESMATOSUCHUS_SKELETON_SLEEPING = createLayer("desmatosuchus_skeleton_sleeping");
	public static ModelLayerLocation DESMATOSUCHUS_SKELETON_WALKING_RIGHT = createLayer("desmatosuchus_skeleton_walking_right");
	public static ModelLayerLocation DESMATOSUCHUS_SKELETON_WALKING_LEFT = createLayer("desmatosuchus_skeleton_walking_left");
	public static ModelLayerLocation POSTOSUCHUS_SKELETON = createLayer("postosuchus_skeleton");
	public static ModelLayerLocation POSTOSUCHUS_SKELETON_ATTACK_LEFT = createLayer("postosuchus_skeleton_attack_left");
	public static ModelLayerLocation POSTOSUCHUS_SKELETON_ATTACK = createLayer("postosuchus_skeleton_attack");
	public static ModelLayerLocation POSTOSUCHUS_SKELETON_CURIOUS = createLayer("postosuchus_skeleton_curious");
	public static ModelLayerLocation POSTOSUCHUS_SKELETON_SLEEPING = createLayer("postosuchus_skeleton_sleeping");
	public static ModelLayerLocation POSTOSUCHUS_SKELETON_WALKING = createLayer("postosuchus_skeleton_walking");
	public static ModelLayerLocation HERRERASAURUS_SKELETON = createLayer("herrerasaurus_skeleton");
	public static ModelLayerLocation HERRERASAURUS_SKELETON_ACTION = createLayer("herrerasaurus_skeleton_action");
	public static ModelLayerLocation HERRERASAURUS_SKELETON_RUNNING = createLayer("herrerasaurus_skeleton_running");
	public static ModelLayerLocation ISCHIGUALASTIA_SKELETON = createLayer("ischigualastia_skeleton");
	public static ModelLayerLocation ISCHIGUALASTIA_SKELETON_STRETCHING = createLayer("ischigualastia_skeleton_stretching");
	public static ModelLayerLocation SAUROSUCHUS_SKELETON = createLayer("saurosuchus_skeleton");
	public static ModelLayerLocation SAUROSUCHUS_SKELETON_ACTION_RIGHT = createLayer("saurosuchus_skeleton_action_right");
	public static ModelLayerLocation SAUROSUCHUS_SKELETON_ACTION_LEFT = createLayer("saurosuchus_skeleton_action_left");
	public static ModelLayerLocation SAUROSUCHUS_SKELETON_SLEEPING = createLayer("saurosuchus_skeleton_sleeping");
	public static ModelLayerLocation PSITTACOSAURUS_SKELETON = createLayer("psittacosaurus_skeleton");
	public static ModelLayerLocation PSITTACOSAURUS_SKELETON_LEFT = createLayer("psittacosaurus_skeleton_left");
	public static ModelLayerLocation PSITTACOSAURUS_SKELETON_MATING = createLayer("psittacosaurus_skeleton_mating");
	public static ModelLayerLocation PSITTACOSAURUS_SKELETON_SAUNTER = createLayer("psittacosaurus_skeleton_saunter");
	public static ModelLayerLocation PSITTACOSAURUS_SKELETON_SITTING = createLayer("psittacosaurus_skeleton_sitting");
	public static ModelLayerLocation PSITTACOSAURUS_SKELETON_SPRINTING = createLayer("psittacosaurus_skeleton_sprinting");
	public static ModelLayerLocation YUTYRANNUS_SKELETON = createLayer("yutyrannus_skeleton");
	public static ModelLayerLocation YUTYRANNUS_SKELETON_SAUNTER = createLayer("yutyrannus_skeleton_saunter");
	public static ModelLayerLocation YUTYRANNUS_SKELETON_ROMP = createLayer("yutyrannus_skeleton_romp");
	public static ModelLayerLocation YUTYRANNUS_SKELETON_FROLIC = createLayer("yutyrannus_skeleton_frolic");
	public static ModelLayerLocation YUTYRANNUS_SKELETON_JP = createLayer("yutyrannus_skeleton_jp");
	public static ModelLayerLocation YUTYRANNUS_SKELETON_LEAP = createLayer("yutyrannus_skeleton_leap");
	public static ModelLayerLocation YUTYRANNUS_SKELETON_SUBDUED = createLayer("yutyrannus_skeleton_subdued");
	public static ModelLayerLocation YUTYRANNUS_SKELETON_SLEEP = createLayer("yutyrannus_skeleton_sleep");
	public static ModelLayerLocation YUTYRANNUS_SKELETON_CARCASS = createLayer("yutyrannus_skeleton_carcass");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON = createLayer("goyocephale_skeleton");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_STEP = createLayer("goyocephale_skeleton_step");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_SLEEP = createLayer("goyocephale_skeleton_sleep");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_FEEDING = createLayer("goyocephale_skeleton_feeding");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_SIT = createLayer("goyocephale_skeleton_sit");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_DEATH = createLayer("goyocephale_skeleton_death");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_HEADBUTT_TWO = createLayer("goyocephale_skeleton_headbutt_two");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_HEADBUTT_ONE = createLayer("goyocephale_skeleton_headbutt_one");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_BRACE = createLayer("goyocephale_skeleton_brace");
	public static ModelLayerLocation GOYOCEPHALE_SKELETON_REAR = createLayer("goyocephale_skeleton_rear");
	public static ModelLayerLocation DONGBEITITAN_SKELETON = createLayer("dongbeititan_skeleton");
	public static ModelLayerLocation DONGBEITITAN_SKELETON_WALK = createLayer("dongbeititan_skeleton_walk");
	public static ModelLayerLocation DONGBEITITAN_SKELETON_REAR = createLayer("dongbeititan_skeleton_rear");
	public static ModelLayerLocation DONGBEITITAN_SKELETON_BROWSE = createLayer("dongbeititan_skeleton_browse");
	public static ModelLayerLocation DONGBEITITAN_SKELETON_GRAZE = createLayer("dongbeititan_skeleton_graze");
	public static ModelLayerLocation DONGBEITITAN_SKELETON_SIT = createLayer("dongbeititan_skeleton_sit");
	public static ModelLayerLocation DONGBEITITAN_SKELETON_SLEEP = createLayer("dongbeititan_skeleton_sleep");
	public static ModelLayerLocation DONGBEITITAN_SKELETON_DEATH = createLayer("dongbeititan_skeleton_death");
	public static ModelLayerLocation DONGBEITITAN_SKELETON_REACH = createLayer("dongbeititan_skeleton_reach");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON = createLayer("liaoningosaurus_skeleton");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_WALK = createLayer("liaoningosaurus_skeleton_walk");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_BRACE = createLayer("liaoningosaurus_skeleton_brace");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_SAUNTER = createLayer("liaoningosaurus_skeleton_saunter");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_GAZE = createLayer("liaoningosaurus_skeleton_gaze");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_CLOBBER = createLayer("liaoningosaurus_skeleton_clobber");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_DEFENSIVE = createLayer("liaoningosaurus_skeleton_defensive");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_SIT = createLayer("liaoningosaurus_skeleton_sit");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_SLEEP = createLayer("liaoningosaurus_skeleton_sleep");
	public static ModelLayerLocation LIAONINGOSAURUS_SKELETON_DEATH = createLayer("liaoningosaurus_skeleton_death");
	public static ModelLayerLocation KAYENTAVENATOR_SKELETON = createLayer("kayentavenator_skeleton");
	public static ModelLayerLocation KAYENTAVENATOR_SKELETON_ALERT = createLayer("kayentavenator_skeleton_alert");
	public static ModelLayerLocation KAYENTAVENATOR_SKELETON_EATING = createLayer("kayentavenator_skeleton_eating");
	public static ModelLayerLocation KAYENTAVENATOR_SKELETON_ATTACK = createLayer("kayentavenator_skeleton_attack");
	public static ModelLayerLocation KAYENTAVENATOR_SKELETON_WALKING = createLayer("kayentavenator_skeleton_walking");
	public static ModelLayerLocation KAYENTAVENATOR_SKELETON_RUNNING = createLayer("kayentavenator_skeleton_running");
	public static ModelLayerLocation KAYENTAVENATOR_SKELETON_SITTING = createLayer("kayentavenator_skeleton_sitting");
	public static ModelLayerLocation KAYENTAVENATOR_SKELETON_SLEEPING = createLayer("kayentavenator_skeleton_sleeping");
	public static ModelLayerLocation KAYENTAVENATOR_SKELETON_DEAD = createLayer("kayentavenator_skeleton_dead");
	public static ModelLayerLocation CHUANDONGOCOELURUS_SKELETON = createLayer("chuandongocoelurus_skeleton");
	public static ModelLayerLocation CHUANDONGOCOELURUS_SKELETON_ALERT = createLayer("chuandongocoelurus_skeleton_alert");
	public static ModelLayerLocation CHUANDONGOCOELURUS_SKELETON_EATING = createLayer("chuandongocoelurus_skeleton_eating");
	public static ModelLayerLocation CHUANDONGOCOELURUS_SKELETON_ATTACK = createLayer("chuandongocoelurus_skeleton_attack");
	public static ModelLayerLocation CHUANDONGOCOELURUS_SKELETON_WALKING = createLayer("chuandongocoelurus_skeleton_walking");
	public static ModelLayerLocation CHUANDONGOCOELURUS_SKELETON_RUNNING = createLayer("chuandongocoelurus_skeleton_running");
	public static ModelLayerLocation CHUANDONGOCOELURUS_SKELETON_SITTING = createLayer("chuandongocoelurus_skeleton_sitting");
	public static ModelLayerLocation CHUANDONGOCOELURUS_SKELETON_SLEEPING = createLayer("chuandongocoelurus_skeleton_sleeping");
	public static ModelLayerLocation CHUANDONGOCOELURUS_SKELETON_DEAD = createLayer("chuandongocoelurus_skeleton_dead");
	public static ModelLayerLocation YANGCHUANOSAURUS_SKELETON = createLayer("yangchuanosuarus_skeleton");
	public static ModelLayerLocation YANGCHUANOSAURUS_SKELETON_RETRO = createLayer("yangchuanosuarus_skeleton_retro");
	public static ModelLayerLocation YANGCHUANOSAURUS_SKELETON_STALKING = createLayer("yangchuanosuarus_skeleton_stalking");
	public static ModelLayerLocation YANGCHUANOSAURUS_SKELETON_WALKING = createLayer("yangchuanosuarus_skeleton_walking");
	public static ModelLayerLocation YANGCHUANOSAURUS_SKELETON_RUNNING = createLayer("yangchuanosuarus_skeleton_running");
	public static ModelLayerLocation YANGCHUANOSAURUS_SKELETON_ATTACKING = createLayer("yangchuanosuarus_skeleton_attacking");
	public static ModelLayerLocation YANGCHUANOSAURUS_SKELETON_EATING = createLayer("yangchuanosuarus_skeleton_eating");
	public static ModelLayerLocation YANGCHUANOSAURUS_SKELETON_STARGAZING = createLayer("yangchuanosuarus_skeleton_stargazing");
	public static ModelLayerLocation YANGCHUANOSAURUS_SKELETON_SLEEPING = createLayer("yangchuanosuarus_skeleton_sleeping");
	public static ModelLayerLocation YANGCHUANOSAURUS_SKELETON_DEAD = createLayer("yangchuanosuarus_skeleton_dead");
	public static ModelLayerLocation SHUNOSAURUS_SKELETON = createLayer("shunosaurus_skeleton");
	public static ModelLayerLocation SHUNOSAURUS_SKELETON_WALK = createLayer("shunosaurus_skeleton_walk");
	public static ModelLayerLocation SHUNOSAURUS_SKELETON_REAR = createLayer("shunosaurus_skeleton_rear");
	public static ModelLayerLocation SHUNOSAURUS_SKELETON_BROWSE = createLayer("shunosaurus_skeleton_browse");
	public static ModelLayerLocation SHUNOSAURUS_SKELETON_GRAZE = createLayer("shunosaurus_skeleton_graze");
	public static ModelLayerLocation SHUNOSAURUS_SKELETON_SIT = createLayer("shunosaurus_skeleton_sit");
	public static ModelLayerLocation SHUNOSAURUS_SKELETON_SLEEP = createLayer("shunosaurus_skeleton_sleep");
	public static ModelLayerLocation SHUNOSAURUS_SKELETON_DEATH = createLayer("shunosaurus_skeleton_death");
	public static ModelLayerLocation SHUNOSAURUS_SKELETON_REACH = createLayer("shunosaurus_skeleton_reach");
	
	//Hell Creek
	public static ModelLayerLocation ANKYLOSAURUS = createLayer("ankylosaurus");
	public static ModelLayerLocation ANKYLOSAURUS_BABY = createLayer("ankylosaurus_baby");
	public static ModelLayerLocation ANZU = createLayer("anzu");
	public static ModelLayerLocation ANZU_BABY = createLayer("anzu_baby");
	public static ModelLayerLocation BASILEMYS = createLayer("basilemys");
	public static ModelLayerLocation DAKOTARAPTOR = createLayer("dakotaraptor");
	public static ModelLayerLocation DAKOTARAPTOR_BABY = createLayer("dakotaraptor_baby");
	public static ModelLayerLocation DIDELPHODON = createLayer("didelphodon");
	public static ModelLayerLocation EDMONTOSAURUS = createLayer("edmontosaurus");
	public static ModelLayerLocation EDMONTOSAURUS_JUVENILE = createLayer("edmontosaurus_juvenile");
	public static ModelLayerLocation EDMONTOSAURUS_BABY = createLayer("edmontosaurus_baby");
	public static ModelLayerLocation ORNITHOMIMUS = createLayer("ornithomimus");
	public static ModelLayerLocation ORNITHOMIMUS_BABY = createLayer("ornithomimus_baby");
	public static ModelLayerLocation PACHYCEPHALOSAURUS = createLayer("pachycephalosaurus");
	public static ModelLayerLocation PALAEOSANIWA = createLayer("palaeosaniwa");
	public static ModelLayerLocation THESCELOSAURUS = createLayer("thescelosaurus");
	public static ModelLayerLocation BRACHYCHAMPSA = createLayer("brachychampsa");
	public static ModelLayerLocation TRICERATOPS = createLayer("triceratops");
	public static ModelLayerLocation TRICERATOPS_JUVENILE = createLayer("triceratops_juvenile");
	public static ModelLayerLocation TRICERATOPS_BABY = createLayer("triceratops_baby");
	public static ModelLayerLocation TYRANNOSAURUS = createLayer("tyrannosaurus");
	public static ModelLayerLocation TYRANNOSAURUS_JUVENILE = createLayer("tyrannosaurus_juvenile");
	public static ModelLayerLocation TYRANNOSAURUS_BABY = createLayer("tyrannosaurus_baby");

	//Djadochta
	public static ModelLayerLocation AEPYORNITHOMIMUS = createLayer("aepyornithomimus");
	public static ModelLayerLocation BYRONOSAURUS = createLayer("byronosaurus");
	public static ModelLayerLocation CITIPATI = createLayer("citipati");
	public static ModelLayerLocation GOYOCEPHALE = createLayer("goyocephale");
	public static ModelLayerLocation HALSZKARAPTOR = createLayer("halszkaraptor");
	public static ModelLayerLocation KOL = createLayer("kol");
	public static ModelLayerLocation OVIRAPTOR = createLayer("oviraptor");
	public static ModelLayerLocation PINACOSAURUS = createLayer("pinacosaurus");
	public static ModelLayerLocation PINACOSAURUS_BABY = createLayer("pinacosaurus_baby");
	public static ModelLayerLocation PLESIOHADROS = createLayer("plesiohadros");
	public static ModelLayerLocation PLESIOHADROS_BABY = createLayer("plesiohadros_baby");
	public static ModelLayerLocation PROTOCERATOPS = createLayer("protoceratops");
	public static ModelLayerLocation PROTOCERATOPS_JUVENILE = createLayer("protoceratops_juvenile");
	public static ModelLayerLocation TELMASAURUS = createLayer("telmasaurus");
	public static ModelLayerLocation UDANOCERATOPS = createLayer("udanoceratops");
	public static ModelLayerLocation UDANOCERATOPS_BABY = createLayer("udanoceratops_baby");
	public static ModelLayerLocation VELOCIRAPTOR = createLayer("velociraptor");

	//Bugs
	public static ModelLayerLocation DERMESTID_BEETLE = createLayer("dermestid_beetle");
	public static ModelLayerLocation GOBIULUS = createLayer("gobiulus");
	public static ModelLayerLocation CEPHALOLEICHNITES = createLayer("cephaloleichnites");
	public static ModelLayerLocation APOCLION = createLayer("apoclion");
	public static ModelLayerLocation CRETARANEUS = createLayer("cretaraneus");
	public static ModelLayerLocation LIAONEMOBIUS = createLayer("liaonemobius");
	public static ModelLayerLocation DIPLICHNITES = createLayer("diplichnites");
	public static ModelLayerLocation OCTOPODICHNUS = createLayer("octopodichnus");
	public static ModelLayerLocation PALEOHELCURA = createLayer("paleohelcura");
	public static ModelLayerLocation CYLINDRICUM = createLayer("cylindricum");
	public static ModelLayerLocation EOPOLIS = createLayer("eopolis");
	public static ModelLayerLocation PARAPLEURITES = createLayer("parapleurites");
	public static ModelLayerLocation ABOILUS = createLayer("aboilus");
	public static ModelLayerLocation CICADOCORIS = createLayer("cicadocoris");
	public static ModelLayerLocation MESOFORFICULA = createLayer("mesoforficula");
	public static ModelLayerLocation RHIPIDOBLATTINA = createLayer("rhipidoblattina");

	//Yixian
	public static ModelLayerLocation BEIPIAOSAURUS = createLayer("beipiaosaurus");
	public static ModelLayerLocation CHANGYURAPTOR = createLayer("changyuraptor");
	public static ModelLayerLocation DILONG = createLayer("dilong");
	public static ModelLayerLocation DONGBEITITAN = createLayer("dongbeititan");
	public static ModelLayerLocation DONGBEITITAN_JUVENILE = createLayer("dongbeititan_juvenile");
	public static ModelLayerLocation DONGBEITITAN_BABY = createLayer("dongbeititan_baby");
	public static ModelLayerLocation INCISIVOSAURUS = createLayer("incisivosaurus");
	public static ModelLayerLocation JINZHOUSAURUS = createLayer("jinzhousaurus");
	public static ModelLayerLocation JINZHOUSAURUS_BABY = createLayer("jinzhousaurus_baby");
	public static ModelLayerLocation LIAONINGOSAURUS = createLayer("liaoningosaurus");
	public static ModelLayerLocation PSITTACOSAURUS = createLayer("psittacosaurus");
	public static ModelLayerLocation REPENOMAMUS = createLayer("repenomamus");
	public static ModelLayerLocation RUIXINIA = createLayer("ruixinia");
	public static ModelLayerLocation RUIXINIA_BABY = createLayer("ruixinia_baby");
	public static ModelLayerLocation SINOSAUROPTERYX = createLayer("sinosauropteryx");
	public static ModelLayerLocation YUTYRANNUS = createLayer("yutyrannus");
	public static ModelLayerLocation YUTYRANNUS_BABY = createLayer("yutyrannus_baby");
	public static ModelLayerLocation ZHENYUANLONG = createLayer("zhenyuanlong");

	//Kayenta
	public static ModelLayerLocation CALSOYASUCHUS = createLayer("calsoyasuchus");
	public static ModelLayerLocation DILOPHOSAURUS = createLayer("dilophosaurus");
	public static ModelLayerLocation DILOPHOSAURUS_BABY = createLayer("dilophosaurus_baby");
	public static ModelLayerLocation KAYENTACHELYS = createLayer("kayentachelys");
	// public static ModelLayerLocation KAYENTASUCHUS = createLayer("kayentasuchus");
	public static ModelLayerLocation KAYENTATHERIUM = createLayer("kayentatherium");
	public static ModelLayerLocation KAYENTAVENATOR = createLayer("kayentavenator");
	public static ModelLayerLocation MEGAPNOSAURUS = createLayer("megapnosaurus");
	public static ModelLayerLocation SARAHSAURUS = createLayer("sarahsaurus");
	public static ModelLayerLocation SCELIDOSAURUS = createLayer("scelidosaurus");
	public static ModelLayerLocation SCUTELLOSAURUS = createLayer("scutellosaurus");

	//Morrison
	public static ModelLayerLocation ALCOVASAURUS = createLayer("alcovasaurus");
	public static ModelLayerLocation ALCOVASAURUS_BABY = createLayer("alcovasaurus_baby");
	public static ModelLayerLocation ALLOSAURUS = createLayer("allosaurus");
	public static ModelLayerLocation ALLOSAURUS_BABY = createLayer("allosaurus_baby");
	public static ModelLayerLocation BRACHIOSAURUS = createLayer("brachiosaurus");
	public static ModelLayerLocation BRACHIOSAURUS_SUBADULT = createLayer("brachiosaurus_subadult");
	public static ModelLayerLocation BRACHIOSAURUS_JUVENILE = createLayer("brachiosaurus_juvenile");
	public static ModelLayerLocation BRACHIOSAURUS_BABY = createLayer("brachiosaurus_baby");
	public static ModelLayerLocation BRONTOSAURUS = createLayer("brontosaurus");
	public static ModelLayerLocation BRONTOSAURUS_SUBADULT = createLayer("brontosaurus_subadult");
	public static ModelLayerLocation BRONTOSAURUS_JUVENILE = createLayer("brontosaurus_juvenile");
	public static ModelLayerLocation BRONTOSAURUS_BABY = createLayer("brontosaurus_baby");
	public static ModelLayerLocation CAMARASAURUS = createLayer("camarasaurus");
	public static ModelLayerLocation CAMARASAURUS_SUBADULT = createLayer("camarasaurus_subadult");
	public static ModelLayerLocation CAMARASAURUS_JUVENILE = createLayer("camarasaurus_juvenile");
	public static ModelLayerLocation CAMARASAURUS_BABY = createLayer("camarasaurus_baby");
	public static ModelLayerLocation CAMPTOSAURUS = createLayer("camptosaurus");
	public static ModelLayerLocation CAMPTOSAURUS_BABY = createLayer("camptosaurus_baby");
	public static ModelLayerLocation CERATOSAURUS = createLayer("ceratosaurus");
	public static ModelLayerLocation CERATOSAURUS_BABY = createLayer("ceratosaurus_baby");
	public static ModelLayerLocation DIABLOPHIS = createLayer("diablophis");
	public static ModelLayerLocation DIPLODOCUS = createLayer("diplodocus");
	public static ModelLayerLocation DIPLODOCUS_JUVENILE = createLayer("diplodocus_juvenile");
	public static ModelLayerLocation DIPLODOCUS_BABY = createLayer("diplodocus_baby");
	public static ModelLayerLocation DIPLODOCUS_SUBADULT = createLayer("diplodocus_subadult");
	public static ModelLayerLocation DRYOSAURUS = createLayer("dryosaurus");
	public static ModelLayerLocation EILENODON = createLayer("eilenodon");
	public static ModelLayerLocation GARGOYLEOSAURUS = createLayer("gargoyleosaurus");
	public static ModelLayerLocation HESPERORNITHOIDES = createLayer("hesperornithoides");
	public static ModelLayerLocation MACELOGNATHUS = createLayer("macelognathus");
	public static ModelLayerLocation STEGOSAURUS = createLayer("stegosaurus");
	public static ModelLayerLocation STEGOSAURUS_BABY = createLayer("stegosaurus_baby");
	public static ModelLayerLocation SUUWASSEA = createLayer("suuwassea");
	public static ModelLayerLocation SUUWASSEA_BABY = createLayer("suuwassea_baby");
	public static ModelLayerLocation TANYCOLAGREUS = createLayer("tanycolagreus");
	public static ModelLayerLocation TORVOSAURUS = createLayer("torvosaurus");
	public static ModelLayerLocation TORVOSAURUS_BABY = createLayer("torvosaurus_baby");

	//Shaximiao
	public static ModelLayerLocation ABROSAURUS = createLayer("abrosaurus");
	public static ModelLayerLocation ABROSAURUS_JUVENILE = createLayer("abrosaurus_juvenile");
	public static ModelLayerLocation ABROSAURUS_BABY = createLayer("abrosaurus_baby");
	public static ModelLayerLocation AGILISAURUS = createLayer("agilisaurus");
	public static ModelLayerLocation BASHANOSAURUS = createLayer("bashanosaurus");
	public static ModelLayerLocation CHUANDONGOCOELURUS = createLayer("chuandongocoelurus");
	public static ModelLayerLocation GIGANTSPINOSAURUS = createLayer("gigantspinosaurus");
	public static ModelLayerLocation GIGANTSPINOSAURUS_BABY = createLayer("gigantspinosaurus_baby");
	public static ModelLayerLocation HUAYANGOSAURUS = createLayer("huayangosaurus");
	public static ModelLayerLocation MAMENCHISAURUS = createLayer("mamenchisaurus");
	public static ModelLayerLocation MAMENCHISAURUS_SUBADULT = createLayer("mamenchisaurus_subadult");
	public static ModelLayerLocation MAMENCHISAURUS_JUVENILE = createLayer("mamenchisaurus_juvenile");
	public static ModelLayerLocation MAMENCHISAURUS_BABY = createLayer("mamenchisaurus_baby");
	public static ModelLayerLocation OMEISAURUS = createLayer("omeisaurus");
	public static ModelLayerLocation OMEISAURUS_JUVENILE = createLayer("omeisaurus_juvenile");
	public static ModelLayerLocation OMEISAURUS_BABY = createLayer("omeisaurus_baby");
	public static ModelLayerLocation POLISTODON = createLayer("polistodon");
	public static ModelLayerLocation SHUNOSAURUS = createLayer("shunosaurus");
	public static ModelLayerLocation SHUNOSAURUS_BABY = createLayer("shunosaurus_baby");
	public static ModelLayerLocation SINRAPTOR = createLayer("sinraptor");
	public static ModelLayerLocation SINRAPTOR_BABY = createLayer("sinraptor_baby");
	public static ModelLayerLocation TUOJIANGOSAURUS = createLayer("tuojiangosaurus");
	public static ModelLayerLocation TUOJIANGOSAURUS_BABY = createLayer("tuojiangosaurus_baby");
	public static ModelLayerLocation YANDUSAURUS = createLayer("yandusaurus");
	public static ModelLayerLocation YANGCHUANOSAURUS = createLayer("yangchuanosaurus");
	public static ModelLayerLocation YANGCHUANOSAURUS_BABY = createLayer("yangchuanosaurus_baby");

	//Chinle
	public static ModelLayerLocation COELOPHYSIS = createLayer("coelophysis");
	public static ModelLayerLocation DESMATOSUCHUS = createLayer("desmatosuchus");
	public static ModelLayerLocation PLACERIAS = createLayer("placerias");
	public static ModelLayerLocation POPOSAURUS = createLayer("poposaurus");
	public static ModelLayerLocation POSTOSUCHUS = createLayer("postosuchus");
	public static ModelLayerLocation TRILOPHOSAURUS = createLayer("trilophosaurus");
	public static ModelLayerLocation TYPOTHORAX = createLayer("typothorax");

	//Ischigualasto
	public static ModelLayerLocation CHROMOGISAURUS = createLayer("chromogisaurus");
	public static ModelLayerLocation EXAERETODON = createLayer("exaeretodon");
	public static ModelLayerLocation HERRERASAURUS = createLayer("herrerasaurus");
	public static ModelLayerLocation HYPERODAPEDON = createLayer("hyperodapedon");
	public static ModelLayerLocation ISCHIGUALASTIA = createLayer("ischigualastia");
	public static ModelLayerLocation ISCHIGUALASTIA_BABY = createLayer("ischigualastia_baby");
	public static ModelLayerLocation SAUROSUCHUS = createLayer("saurosuchus");
	public static ModelLayerLocation SAUROSUCHUS_BABY = createLayer("saurosuchus_baby");
	public static ModelLayerLocation SILLOSUCHUS = createLayer("sillosuchus");
	public static ModelLayerLocation SILLOSUCHUS_BABY = createLayer("sillosuchus_baby");
	//Fish
	public static ModelLayerLocation ACIPENSER = createLayer("acipenser");
	public static ModelLayerLocation ARGANODUS = createLayer("arganodus");
	public static ModelLayerLocation CERATODUS = createLayer("ceratodus");
	public static ModelLayerLocation CHINLEA = createLayer("chinlea");
	public static ModelLayerLocation CYCLURUS = createLayer("cyclurus");
	public static ModelLayerLocation GAR = createLayer("gar");
	public static ModelLayerLocation HARENAICHTHYS = createLayer("harenaichthys");
	public static ModelLayerLocation LONCHIDION = createLayer("lonchidion");
	public static ModelLayerLocation MELVIUS = createLayer("melvius");
	public static ModelLayerLocation MOOREODONTUS = createLayer("mooreodontus");
	public static ModelLayerLocation MYLEDAPHUS = createLayer("myledaphus");
	public static ModelLayerLocation POTAMOCERATODUS = createLayer("potamoceratodus");
	public static ModelLayerLocation PROTOPSEPHURUS = createLayer("protopsephurus");
	public static ModelLayerLocation SAURICHTHYS = createLayer("saurichthys");
	public static ModelLayerLocation SINAMIA = createLayer("sinamia");
	public static ModelLayerLocation YANOSTEUS = createLayer("yanosteus");
	public static ModelLayerLocation PARAPSEPHURUS = createLayer("parapsephurus");
	public static ModelLayerLocation MORROLEPIS = createLayer("morrolepis");
	public static ModelLayerLocation OPHIOPSIS = createLayer("ophiopsis");
	public static ModelLayerLocation LEPIDOTES = createLayer("lepidotes");
	public static ModelLayerLocation CHUNGKINGICHTHYS = createLayer("chungkingichthys");
	public static ModelLayerLocation TOARCIBATIS = createLayer("toarcibatis");

	public static ModelLayerLocation ANKYLOSAURUS_HELMET = createLayer("ankylosaurus_helmet");
	public static ModelLayerLocation DESMATOSUCHUS_CHESTPLATE = createLayer("desmatosuchus_chestplate");
	public static ModelLayerLocation EGGSHELL_HELMET = createLayer("eggshell_helmet");

	public static ModelLayerLocation LUNGFISH_COCOON = createLayer("lungfish_cocoon");

	//Henos
	public static ModelLayerLocation HENOS = createLayer("henos");
	public static ModelLayerLocation SUMMONED_HENOS = createLayer("summoned_henos");
	public static ModelLayerLocation CAVE_SENTINEL = createLayer("cave_sentinel");
	public static ModelLayerLocation LAND_SENTINEL = createLayer("land_sentinel");
	public static ModelLayerLocation CORRUPTED_THEROPOD = createLayer("corrupted_theropod");
	public static ModelLayerLocation PYRINOS = createLayer("pyrinos");

	public static ModelLayerLocation createLayer(String name) {
		return new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, name), name);
	}

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
		event.registerEntityRenderer(PFEntities.BRACHIOSAURUS_SKULL.get(), BrachiosaurusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.KAYENTAVENATOR_SKULL.get(), KayentavenatorSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.YANGCHUANOSAURUS_SKULL.get(), YangchuanosaurusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.KAYENTAVENATOR_SKELETON.get(), KayentavenatorSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.CHUANDONGOCOELURUS_SKULL.get(), ChuandongocoelurusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.CHUANDONGOCOELURUS_SKELETON.get(), ChuandongocoelurusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.YANGCHUANOSAURUS_SKELETON.get(), YangchuanosaurusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.SHUNOSAURUS_SKELETON.get(), ShunosaurusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.SHUNOSAURUS_SKULL.get(), ShunosaurusSkullRenderer::new);
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
		event.registerEntityRenderer(PFEntities.DIABLOPHIS.get(), DiablophisRenderer::new);
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
		event.registerEntityRenderer(PFEntities.LEPIDOTES.get(), LepidotesRenderer::new);
		event.registerEntityRenderer(PFEntities.CHUNGKINGICHTHYS.get(), ChungkingichthysRenderer::new);
		event.registerEntityRenderer(PFEntities.BASHANOSAURUS.get(), BashanosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.CHUANDONGOCOELURUS.get(), ChuandongocoelurusRenderer::new);
		event.registerEntityRenderer(PFEntities.AGILISAURUS.get(), AgilisaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.GIGANTSPINOSAURUS.get(), GigantspinosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.YANDUSAURUS.get(), YandusaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.YANGCHUANOSAURUS.get(), YangchuanosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.MACELOGNATHUS.get(), MacelognathusRenderer::new);
		event.registerEntityRenderer(PFEntities.TANYCOLAGREUS.get(), TanycolagreusRenderer::new);
		event.registerEntityRenderer(PFEntities.MORROLEPIS.get(), MorrolepisRenderer::new);
		event.registerEntityRenderer(PFEntities.KAYENTACHELYS.get(), KayentachelysRenderer::new);
		//		event.registerEntityRenderer(PFEntities.KAYENTASUCHUS.get(), KayentasuchusRenderer::new);
		event.registerEntityRenderer(PFEntities.KAYENTAVENATOR.get(), KayentavenatorRenderer::new);
		event.registerEntityRenderer(PFEntities.OPHIOPSIS.get(), OphiopsisRenderer::new);
		event.registerEntityRenderer(PFEntities.DIPLICHNITES.get(), DiplichnitesRenderer::new);
		event.registerEntityRenderer(PFEntities.OCTOPODICHNUS.get(), OctopodichnusRenderer::new);
		event.registerEntityRenderer(PFEntities.PALEOHELCURA.get(), PaleohelcuraRenderer::new);
		event.registerEntityRenderer(PFEntities.CYLINDRICUM.get(), CylindricumRenderer::new);
		event.registerEntityRenderer(PFEntities.EOPOLIS.get(), EopolisRenderer::new);
		event.registerEntityRenderer(PFEntities.PARAPLEURITES.get(), ParapleuritesRenderer::new);
		event.registerEntityRenderer(PFEntities.ABOILUS.get(), AboilusRenderer::new);
		event.registerEntityRenderer(PFEntities.CICADOCORIS.get(), CicadocorisRenderer::new);
		event.registerEntityRenderer(PFEntities.MESOFORFICULA.get(), MesoforficulaRenderer::new);
		event.registerEntityRenderer(PFEntities.RHIPIDOBLATTINA.get(), RhipidoblattinaRenderer::new);
		event.registerEntityRenderer(PFEntities.GARGOYLEOSAURUS.get(), GargoyleosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.CAMPTOSAURUS.get(), CamptosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.TORVOSAURUS.get(), TorvosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.ALCOVASAURUS.get(), AlcovasaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.HUAYANGOSAURUS.get(), HuayangosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.TUOJIANGOSAURUS.get(), TuojiangosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.SHUNOSAURUS.get(), ShunosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.ABROSAURUS.get(), AbrosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.SINRAPTOR.get(), SinraptorRenderer::new);
		event.registerEntityRenderer(PFEntities.DIPLODOCUS.get(), DiplodocusRenderer::new);
		event.registerEntityRenderer(PFEntities.OMEISAURUS.get(), OmeisaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.BRONTOSAURUS.get(), BrontosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.SUUWASSEA.get(), SuuwasseaRenderer::new);
		event.registerEntityRenderer(PFEntities.BRACHIOSAURUS.get(), BrachiosaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.POLISTODON.get(), PolistodonRenderer::new);
		event.registerEntityRenderer(PFEntities.TOARCIBATIS.get(), ToarcibatisRenderer::new);
		event.registerEntityRenderer(PFEntities.MAMENCHISAURUS.get(), MamenchisaurusRenderer::new);
		event.registerEntityRenderer(PFEntities.PYRINOS.get(), PyrinosRenderer::new);

		event.registerEntityRenderer(PFEntities.THROWN_SPIKY_JAVELIN.get(), ThrownSpikyJavelinRenderer::new);

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
		event.registerLayerDefinition(PYRINOS, PyrinosModel::createBodyLayer);

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
		//Brachiosaurus Skeleton and Skull
		event.registerLayerDefinition(BRACHIOSAURUS_SKULL, BrachiosaurusSkullModel::createBodyLayer);
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
		event.registerLayerDefinition(STEGOSAURUS_SKELETON_SITTING, StegosaurusSkeletonSittingModel::createBodyLayer);
		event.registerLayerDefinition(STEGOSAURUS_SKELETON_DISPLAY, StegosaurusSkeletonDisplayModel::createBodyLayer);
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
		event.registerLayerDefinition(TYRANNOSAURUS_SKELETON_STARGAZING, TyrannosaurusSkeletonStargazeModel::createBodyLayer);
		event.registerLayerDefinition(TYRANNOSAURUS_SKELETON_CONDESCEND, TyrannosaurusSkeletonCondescendModel::createBodyLayer);
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
		//Kayentavenator Skeleton and Skull
		event.registerLayerDefinition(KAYENTAVENATOR_SKELETON, KayentavenatorSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(KAYENTAVENATOR_SKELETON_ALERT, KayentavenatorSkeletonAlertModel::createBodyLayer);
		event.registerLayerDefinition(KAYENTAVENATOR_SKELETON_EATING, KayentavenatorSkeletonEatingModel::createBodyLayer);
		event.registerLayerDefinition(KAYENTAVENATOR_SKELETON_ATTACK, KayentavenatorSkeletonAttackingModel::createBodyLayer);
		event.registerLayerDefinition(KAYENTAVENATOR_SKELETON_WALKING, KayentavenatorSkeletonWalkingModel::createBodyLayer);
		event.registerLayerDefinition(KAYENTAVENATOR_SKELETON_RUNNING, KayentavenatorSkeletonRunningModel::createBodyLayer);
		event.registerLayerDefinition(KAYENTAVENATOR_SKELETON_SITTING, KayentavenatorSkeletonSittingModel::createBodyLayer);
		event.registerLayerDefinition(KAYENTAVENATOR_SKELETON_SLEEPING, KayentavenatorSkeletonSleepingModel::createBodyLayer);
		event.registerLayerDefinition(KAYENTAVENATOR_SKELETON_DEAD, KayentavenatorSkeletonDeadModel::createBodyLayer);
		event.registerLayerDefinition(KAYENTAVENATOR_SKULL, KayentavenatorSkullModel::createBodyLayer);
		//Chuandongocoelurus Skeleton and Skull
		event.registerLayerDefinition(CHUANDONGOCOELURUS_SKELETON, ChuandongocoelurusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(CHUANDONGOCOELURUS_SKELETON_ALERT, ChuandongocoelurusSkeletonAlertModel::createBodyLayer);
		event.registerLayerDefinition(CHUANDONGOCOELURUS_SKELETON_EATING, ChuandongocoelurusSkeletonEatingModel::createBodyLayer);
		event.registerLayerDefinition(CHUANDONGOCOELURUS_SKELETON_ATTACK, ChuandongocoelurusSkeletonAttackingModel::createBodyLayer);
		event.registerLayerDefinition(CHUANDONGOCOELURUS_SKELETON_WALKING, ChuandongocoelurusSkeletonWalkingModel::createBodyLayer);
		event.registerLayerDefinition(CHUANDONGOCOELURUS_SKELETON_RUNNING, ChuandongocoelurusSkeletonRunningModel::createBodyLayer);
		event.registerLayerDefinition(CHUANDONGOCOELURUS_SKELETON_SITTING, ChuandongocoelurusSkeletonSittingModel::createBodyLayer);
		event.registerLayerDefinition(CHUANDONGOCOELURUS_SKELETON_SLEEPING, ChuandongocoelurusSkeletonSleepingModel::createBodyLayer);
		event.registerLayerDefinition(CHUANDONGOCOELURUS_SKELETON_DEAD, ChuandongocoelurusSkeletonDeadModel::createBodyLayer);
		event.registerLayerDefinition(CHUANDONGOCOELURUS_SKULL, ChuandongocoelurusSkullModel::createBodyLayer);
		//Yangchuanosaurus Skeleton and Skull
		event.registerLayerDefinition(YANGCHUANOSAURUS_SKELETON, YangchuanosaurusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(YANGCHUANOSAURUS_SKELETON_RETRO, YangchuanosaurusSkeletonRetroModel::createBodyLayer);
		event.registerLayerDefinition(YANGCHUANOSAURUS_SKELETON_STALKING, YangchuanosaurusSkeletonStalkingModel::createBodyLayer);
		event.registerLayerDefinition(YANGCHUANOSAURUS_SKELETON_WALKING, YangchuanosaurusSkeletonWalkingModel::createBodyLayer);
		event.registerLayerDefinition(YANGCHUANOSAURUS_SKELETON_RUNNING, YangchuanosaurusSkeletonRunningModel::createBodyLayer);
		event.registerLayerDefinition(YANGCHUANOSAURUS_SKELETON_ATTACKING, YangchuanosaurusSkeletonAttackingModel::createBodyLayer);
		event.registerLayerDefinition(YANGCHUANOSAURUS_SKELETON_EATING, YangchuanosaurusSkeletonEatingModel::createBodyLayer);
		event.registerLayerDefinition(YANGCHUANOSAURUS_SKELETON_STARGAZING, YangchuanosaurusSkeletonStargazingModel::createBodyLayer);
		event.registerLayerDefinition(YANGCHUANOSAURUS_SKELETON_SLEEPING, YangchuanosaurusSkeletonSleepingModel::createBodyLayer);
		event.registerLayerDefinition(YANGCHUANOSAURUS_SKELETON_DEAD, YangchuanosaurusSkeletonDeadModel::createBodyLayer);
		event.registerLayerDefinition(YANGCHUANOSAURUS_SKULL, YangchuanosaurusSkullModel::createBodyLayer);
		//Shunosaurus Skeleton and Skull
		event.registerLayerDefinition(SHUNOSAURUS_SKELETON, ShunosaurusSkeletonModel::createBodyLayer);
		event.registerLayerDefinition(SHUNOSAURUS_SKELETON_WALK, ShunosaurusSkeletonWalkModel::createBodyLayer);
		event.registerLayerDefinition(SHUNOSAURUS_SKELETON_REAR, ShunosaurusSkeletonRearModel::createBodyLayer);
		event.registerLayerDefinition(SHUNOSAURUS_SKELETON_REACH, ShunosaurusSkeletonReachModel::createBodyLayer);
		event.registerLayerDefinition(SHUNOSAURUS_SKELETON_BROWSE, ShunosaurusSkeletonBrowseModel::createBodyLayer);
		event.registerLayerDefinition(SHUNOSAURUS_SKELETON_GRAZE, ShunosaurusSkeletonGrazeModel::createBodyLayer);
		event.registerLayerDefinition(SHUNOSAURUS_SKELETON_SIT, ShunosaurusSkeletonSitModel::createBodyLayer);
		event.registerLayerDefinition(SHUNOSAURUS_SKELETON_SLEEP, ShunosaurusSkeletonSleepModel::createBodyLayer);
		event.registerLayerDefinition(SHUNOSAURUS_SKELETON_DEATH, ShunosaurusSkeletonDeadModel::createBodyLayer);
		event.registerLayerDefinition(SHUNOSAURUS_SKULL, ShunosaurusSkullModel::createBodyLayer);
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
		event.registerLayerDefinition(CHUNGKINGICHTHYS, ChungkingichthysModel::createBodyLayer);
		event.registerLayerDefinition(LEPIDOTES, LepidotesModel::createBodyLayer);
		event.registerLayerDefinition(MORROLEPIS, MorrolepisModel::createBodyLayer);
		event.registerLayerDefinition(OPHIOPSIS, OphiopsisModel::createBodyLayer);
		event.registerLayerDefinition(TOARCIBATIS, ToarcibatisModel::createBodyLayer);
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
		event.registerLayerDefinition(KAYENTACHELYS, KayentachelysModel::createBodyLayer);
		//		event.registerLayerDefinition(KAYENTASUCHUS, KayentasuchusModel::createBodyLayer);
		event.registerLayerDefinition(KAYENTATHERIUM, KayentatheriumModel::createBodyLayer);
		event.registerLayerDefinition(KAYENTAVENATOR, KayentavenatorModel::createBodyLayer);
		event.registerLayerDefinition(MEGAPNOSAURUS, MegapnosaurusModel::createBodyLayer);
		event.registerLayerDefinition(SARAHSAURUS, SarahsaurusModel::createBodyLayer);
		event.registerLayerDefinition(SCELIDOSAURUS, ScelidosaurusModel::createBodyLayer);
		event.registerLayerDefinition(SCUTELLOSAURUS, ScutellosaurusModel::createBodyLayer);
		event.registerLayerDefinition(DIPLICHNITES, DiplichnitesModel::createBodyLayer);
		event.registerLayerDefinition(OCTOPODICHNUS, OctopodichnusModel::createBodyLayer);
		event.registerLayerDefinition(PALEOHELCURA, PaleohelcuraModel::createBodyLayer);
		//Morrison
		event.registerLayerDefinition(ALCOVASAURUS, AlcovasaurusModel::createBodyLayer);;
		event.registerLayerDefinition(ALCOVASAURUS_BABY, AlcovasaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(ALLOSAURUS, AllosaurusModel::createBodyLayer);
		event.registerLayerDefinition(ALLOSAURUS_BABY, AllosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(BRACHIOSAURUS, BrachiosaurusModel::createBodyLayer);
		event.registerLayerDefinition(BRACHIOSAURUS_SUBADULT, BrachiosaurusSubadultModel::createBodyLayer);
		event.registerLayerDefinition(BRACHIOSAURUS_JUVENILE, BrachiosaurusJuvenileModel::createBodyLayer);
		event.registerLayerDefinition(BRACHIOSAURUS_BABY, BrachiosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(BRONTOSAURUS, BrontosaurusModel::createBodyLayer);
		event.registerLayerDefinition(BRONTOSAURUS_SUBADULT, BrontosaurusSubadultModel::createBodyLayer);
		event.registerLayerDefinition(BRONTOSAURUS_JUVENILE, BrontosaurusJuvenileModel::createBodyLayer);
		event.registerLayerDefinition(BRONTOSAURUS_BABY, BrontosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(CAMARASAURUS, CamarasaurusModel::createBodyLayer);
		event.registerLayerDefinition(CAMARASAURUS_SUBADULT, CamarasaurusSubadultModel::createBodyLayer);
		event.registerLayerDefinition(CAMARASAURUS_JUVENILE, CamarasaurusJuvenileModel::createBodyLayer);
		event.registerLayerDefinition(CAMARASAURUS_BABY, CamarasaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(CERATOSAURUS, CeratosaurusModel::createBodyLayer);
		event.registerLayerDefinition(CERATOSAURUS_BABY, CeratosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(DIABLOPHIS, DiablophisModel::createBodyLayer);
		event.registerLayerDefinition(DIPLODOCUS, DiplodocusModel::createBodyLayer);
		event.registerLayerDefinition(DIPLODOCUS_SUBADULT, DiplodocusSubadultModel::createBodyLayer);
		event.registerLayerDefinition(DIPLODOCUS_JUVENILE, DiplodocusJuvenileModel::createBodyLayer);
		event.registerLayerDefinition(DIPLODOCUS_BABY, DiplodocusBabyModel::createBodyLayer);
		event.registerLayerDefinition(DRYOSAURUS, DryosaurusModel::createBodyLayer);
		event.registerLayerDefinition(EILENODON, EilenodonModel::createBodyLayer);
		event.registerLayerDefinition(HESPERORNITHOIDES, HesperornithoidesModel::createBodyLayer);
		event.registerLayerDefinition(MACELOGNATHUS, MacelognathusModel::createBodyLayer);
		event.registerLayerDefinition(STEGOSAURUS, StegosaurusModel::createBodyLayer);
		event.registerLayerDefinition(STEGOSAURUS_BABY, StegosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(SUUWASSEA, SuuwasseaModel::createBodyLayer);
		event.registerLayerDefinition(SUUWASSEA_BABY, SuuwasseaBabyModel::createBodyLayer);
		event.registerLayerDefinition(TANYCOLAGREUS, TanycolagreusModel::createBodyLayer);
		event.registerLayerDefinition(CYLINDRICUM, CylindricumModel::createBodyLayer);
		event.registerLayerDefinition(EOPOLIS, EopolisModel::createBodyLayer);
		event.registerLayerDefinition(PARAPLEURITES, ParapleuritesModel::createBodyLayer);
		event.registerLayerDefinition(GARGOYLEOSAURUS, GargoyleosaurusModel::createBodyLayer);
		event.registerLayerDefinition(CAMPTOSAURUS, CamptosaurusModel::createBodyLayer);
		event.registerLayerDefinition(CAMPTOSAURUS_BABY, CamptosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(TORVOSAURUS, TorvosaurusModel::createBodyLayer);
		event.registerLayerDefinition(TORVOSAURUS_BABY, TorvosaurusBabyModel::createBodyLayer);
		//Shaximiao
		event.registerLayerDefinition(AGILISAURUS, AgilisaurusModel::createBodyLayer);
		event.registerLayerDefinition(BASHANOSAURUS, BashanosaurusModel::createBodyLayer);
		event.registerLayerDefinition(CHUANDONGOCOELURUS, ChuandongocoelurusModel::createBodyLayer);
		event.registerLayerDefinition(GIGANTSPINOSAURUS, GigantspinosaurusModel::createBodyLayer);
		event.registerLayerDefinition(GIGANTSPINOSAURUS_BABY, GigantspinosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(YANDUSAURUS, YandusaurusModel::createBodyLayer);
		event.registerLayerDefinition(YANGCHUANOSAURUS, YangchuanosaurusModel::createBodyLayer);
		event.registerLayerDefinition(YANGCHUANOSAURUS_BABY, YangchuanosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(ABOILUS, AboilusModel::createBodyLayer);
		event.registerLayerDefinition(CICADOCORIS, CicadocorisModel::createBodyLayer);
		event.registerLayerDefinition(MESOFORFICULA, MesoforficulaModel::createBodyLayer);
		event.registerLayerDefinition(RHIPIDOBLATTINA, RhipidoblattinaModel::createBodyLayer);
		event.registerLayerDefinition(HUAYANGOSAURUS, HuayangosaurusModel::createBodyLayer);
		event.registerLayerDefinition(TUOJIANGOSAURUS, TuojiangosaurusModel::createBodyLayer);
		event.registerLayerDefinition(TUOJIANGOSAURUS_BABY, TuojiangosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(SHUNOSAURUS, ShunosaurusModel::createBodyLayer);
		event.registerLayerDefinition(SHUNOSAURUS_BABY, ShunosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(ABROSAURUS, AbrosaurusModel::createBodyLayer);
		event.registerLayerDefinition(ABROSAURUS_JUVENILE, AbrosaurusJuvenileModel::createBodyLayer);
		event.registerLayerDefinition(ABROSAURUS_BABY, AbrosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(SINRAPTOR, SinraptorModel::createBodyLayer);
		event.registerLayerDefinition(SINRAPTOR_BABY, SinraptorBabyModel::createBodyLayer);
		event.registerLayerDefinition(OMEISAURUS, OmeisaurusModel::createBodyLayer);
		event.registerLayerDefinition(OMEISAURUS_JUVENILE, OmeisaurusJuvenileModel::createBodyLayer);
		event.registerLayerDefinition(OMEISAURUS_BABY, OmeisaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(POLISTODON, PolistodonModel::createBodyLayer);
		event.registerLayerDefinition(MAMENCHISAURUS, MamenchisaurusModel::createBodyLayer);
		event.registerLayerDefinition(MAMENCHISAURUS_SUBADULT, MamenchisaurusSubadultModel::createBodyLayer);
		event.registerLayerDefinition(MAMENCHISAURUS_JUVENILE, MamenchisaurusJuvenileModel::createBodyLayer);
		event.registerLayerDefinition(MAMENCHISAURUS_BABY, MamenchisaurusBabyModel::createBodyLayer);
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
			if (mc.screen == null && (PFKeybinds.attackKey.consumeClick())) {
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
			if (mc.screen == null && (PFKeybinds.attackKey.consumeClick())) {
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
