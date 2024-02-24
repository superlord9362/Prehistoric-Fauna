package superlord.prehistoricfauna.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.gui.GuiPaleo;
import superlord.prehistoricfauna.client.gui.GuiPaleontologyTable;
import superlord.prehistoricfauna.client.model.armor.AnkylosaurusHelmetModel;
import superlord.prehistoricfauna.client.model.armor.DesmatosuchusChestplateModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.AepyornithomimusModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.CitipatiModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.DermestidBeetleModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.GobiulusModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.GoyocephaleModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.HalszkaraptorModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.KolModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.OviraptorModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.PinacosaurusBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.PinacosaurusModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.PlesiohadrosBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.PlesiohadrosModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.ProtoceratopsJuvenileModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.ProtoceratopsModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.TelmasaurusModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.UdanoceratopsModel;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.VelociraptorModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.AnkylosaurusBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.AnkylosaurusModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.BasilemysModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.DakotaraptorBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.DakotaraptorModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.DidelphodonModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.OrnithomimusModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.PachycephalosaurusModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.PalaeosaniwaModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.ThescelosaurusModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.ThoracosaurusModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TriceratopsBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TriceratopsJuvenileModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TriceratopsModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TyrannosaurusBabyModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TyrannosaurusJuvenileModel;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TyrannosaurusModel;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.IncisivosaurusModel;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.PsittacosaurusModel;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.SinosauropteryxModel;
import superlord.prehistoricfauna.client.model.cretaceous.yixian.YutyrannusModel;
import superlord.prehistoricfauna.client.model.fish.AcipenserModel;
import superlord.prehistoricfauna.client.model.fish.ArganodusModel;
import superlord.prehistoricfauna.client.model.fish.CeratodusModel;
import superlord.prehistoricfauna.client.model.fish.ChinleaModel;
import superlord.prehistoricfauna.client.model.fish.CyclurusModel;
import superlord.prehistoricfauna.client.model.fish.GarModel;
import superlord.prehistoricfauna.client.model.fish.HarenaichthysModel;
import superlord.prehistoricfauna.client.model.fish.LonchidionModel;
import superlord.prehistoricfauna.client.model.fish.MelviusModel;
import superlord.prehistoricfauna.client.model.fish.MooreodontusModel;
import superlord.prehistoricfauna.client.model.fish.MyledaphusModel;
import superlord.prehistoricfauna.client.model.fish.PotamoceratodusModel;
import superlord.prehistoricfauna.client.model.fish.SaurichthysModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.AnkylosaurusSkeletonActionLeftModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.AnkylosaurusSkeletonActionRightModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.AnkylosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.AnkylosaurusSkeletonRestingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.AnkylosaurusSkeletonSquattingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.AnkylosaurusSkullModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PlesiohadrosSkeletonChargeModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PlesiohadrosSkeletonDashLeftModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PlesiohadrosSkeletonDashRightModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PlesiohadrosSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PlesiohadrosSkeletonSittingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PlesiohadrosSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PlesiohadrosSkeletonWalkingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.PlesiohadrosSkullModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.ProtoceratopsSkeletonDisplayModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.ProtoceratopsSkeletonLayingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.ProtoceratopsSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.ProtoceratopsSkeletonRunningModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.ProtoceratopsSkeletonSittingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.ProtoceratopsSkullModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TriceratopsSkeletonActionLeftModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TriceratopsSkeletonActionRightModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TriceratopsSkeletonChargingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TriceratopsSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TriceratopsSkeletonRetroModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TriceratopsSkeletonSittingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TriceratopsSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TriceratopsSkullModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TyrannosaurusSkeletonJPModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TyrannosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TyrannosaurusSkeletonRetroModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TyrannosaurusSkeletonRunningModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TyrannosaurusSkeletonSittingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TyrannosaurusSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TyrannosaurusSkeletonStalkingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TyrannosaurusSkeletonStompingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.TyrannosaurusSkullModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.VelociraptorSkeletonFlashingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.VelociraptorSkeletonLayFightingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.VelociraptorSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.VelociraptorSkeletonRunningModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.VelociraptorSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.VelociraptorSkeletonStandFightingModel;
import superlord.prehistoricfauna.client.model.fossil.cretaceous.VelociraptorSkullModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.AllosaurusSkeletonActionLeftModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.AllosaurusSkeletonActionRightModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.AllosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.AllosaurusSkeletonRestingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.AllosaurusSkeletonRetroModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.AllosaurusSkullModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.CeratosaurusSkeletonActionModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.CeratosaurusSkeletonAlertLeftModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.CeratosaurusSkeletonAlertRightModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.CeratosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.CeratosaurusSkeletonRestingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.CeratosaurusSkullModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.DilophosaurusSkeletonAttackModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.DilophosaurusSkeletonGazeModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.DilophosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.DilophosaurusSkeletonSittingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.DilophosaurusSkeletonStrutModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.DilophosaurusSkullModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.SarahsaurusSkeletonEatingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.SarahsaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.SarahsaurusSkeletonSittingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.SarahsaurusSkeletonWalkingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.SarahsaurusSkullModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ScelidosaurusSkeletonDashingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ScelidosaurusSkeletonGrazingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ScelidosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ScelidosaurusSkeletonReachingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ScelidosaurusSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ScelidosaurusSkeletonWalkingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.ScelidosaurusSkullModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.StegosaurusSkeletonActionLeftModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.StegosaurusSkeletonActionRightModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.StegosaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.StegosaurusSkeletonRetroModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.StegosaurusSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.jurassic.StegosaurusSkullModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.CoelophysisSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.CoelophysisSkeletonSaunterModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.CoelophysisSkeletonSeizeModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.CoelophysisSkeletonSlainModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.CoelophysisSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.CoelophysisSkeletonSlumpModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.CoelophysisSkeletonStrideModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.CoelophysisSkullModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.DesmatosuchusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.DesmatosuchusSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.DesmatosuchusSkeletonWalkingLeftModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.DesmatosuchusSkeletonWalkingRightModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.DesmatosuchusSkullModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.HerrerasaurusSkeletonActionModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.HerrerasaurusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.HerrerasaurusSkeletonRunningModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.HerrerasaurusSkullModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.IschigualastiaSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.IschigualastiaSkeletonStretchingModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.IschigualastiaSkullModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.PostosuchusSkeletonAttackLeftModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.PostosuchusSkeletonAttackModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.PostosuchusSkeletonCuriousModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.PostosuchusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.PostosuchusSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.PostosuchusSkeletonWalkingModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.PostosuchusSkullModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.SaurosuchusSkeletonActionLeftModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.SaurosuchusSkeletonActionRightModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.SaurosuchusSkeletonModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.SaurosuchusSkeletonSleepingModel;
import superlord.prehistoricfauna.client.model.fossil.triassic.SaurosuchusSkullModel;
import superlord.prehistoricfauna.client.model.henos.CaveSentinelModel;
import superlord.prehistoricfauna.client.model.henos.HenosModel;
import superlord.prehistoricfauna.client.model.henos.HenosSummonedModel;
import superlord.prehistoricfauna.client.model.henos.LandSentinelModel;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.CalsoyasuchusModel;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.DilophosaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.DilophosaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.KayentatheriumModel;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.MegapnosaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.SarahsaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.ScelidosaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.kayenta.ScutellosaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.AllosaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.AllosaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamarasaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamarasaurusHatchlingModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamarasaurusJuvenileModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CamarasaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CeratosaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.CeratosaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.DryosaurusModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.EilenodonModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.HesperornithoidesModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.StegosaurusBabyModel;
import superlord.prehistoricfauna.client.model.jurassic.morrison.StegosaurusModel;
import superlord.prehistoricfauna.client.model.triassic.chinle.CoelophysisModel;
import superlord.prehistoricfauna.client.model.triassic.chinle.DesmatosuchusModel;
import superlord.prehistoricfauna.client.model.triassic.chinle.PlaceriasModel;
import superlord.prehistoricfauna.client.model.triassic.chinle.PoposaurusModel;
import superlord.prehistoricfauna.client.model.triassic.chinle.PostosuchusModel;
import superlord.prehistoricfauna.client.model.triassic.chinle.TrilophosaurusModel;
import superlord.prehistoricfauna.client.model.triassic.chinle.TypothoraxModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.ChromogisaurusModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.ExaeretodonModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.HerrerasaurusModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.HyperodapedonModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.IschigualastiaBabyModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.IschigualastiaModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.SaurosuchusBabyModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.SaurosuchusModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.SillosuchusBabyModel;
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.SillosuchusModel;
import superlord.prehistoricfauna.client.render.PFBoatRenderer;
import superlord.prehistoricfauna.client.render.PaleopaintingRenderer;
import superlord.prehistoricfauna.client.render.WallFossilRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.AepyornithomimusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.CitipatiRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.DermestidBeetleRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.GobiulusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.GoyocephaleRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.HalszkaraptorRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.KolRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.OviraptorRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.PinacosaurusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.PlesiohadrosRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.ProtoceratopsRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.TelmasaurusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.UdanoceratopsRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.djadochta.VelociraptorRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.AnkylosaurusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.BasilemysRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.DakotaraptorRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.DidelphodonRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.OrnithomimusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.PachycephalosaurusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.PalaeosaniwaRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.ThescelosaurusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.ThoracosaurusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.TriceratopsRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.hellcreek.TyrannosaurusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.yixian.IncisivosaurusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.yixian.PsittacosaurusRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.yixian.SinosauropteryxRenderer;
import superlord.prehistoricfauna.client.render.cretaceous.yixian.YutyrannusRenderer;
import superlord.prehistoricfauna.client.render.fish.AcipenserRenderer;
import superlord.prehistoricfauna.client.render.fish.ArganodusRenderer;
import superlord.prehistoricfauna.client.render.fish.CeratodusRenderer;
import superlord.prehistoricfauna.client.render.fish.ChinleaRenderer;
import superlord.prehistoricfauna.client.render.fish.CyclurusRenderer;
import superlord.prehistoricfauna.client.render.fish.GarRenderer;
import superlord.prehistoricfauna.client.render.fish.HarenaichthysRenderer;
import superlord.prehistoricfauna.client.render.fish.LonchidionRenderer;
import superlord.prehistoricfauna.client.render.fish.MelviusRenderer;
import superlord.prehistoricfauna.client.render.fish.MooreodontusRenderer;
import superlord.prehistoricfauna.client.render.fish.MyledaphusRenderer;
import superlord.prehistoricfauna.client.render.fish.PotamoceratodusRenderer;
import superlord.prehistoricfauna.client.render.fish.SaurichthysRenderer;
import superlord.prehistoricfauna.client.render.fossil.cretaceous.AnkylosaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.cretaceous.AnkylosaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.cretaceous.PlesiohadrosSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.cretaceous.PlesiohadrosSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.cretaceous.ProtoceratopsSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.cretaceous.ProtoceratopsSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.cretaceous.TriceratopsSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.cretaceous.TriceratopsSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.cretaceous.TyrannosaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.cretaceous.TyrannosaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.cretaceous.VelociraptorSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.cretaceous.VelociraptorSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.jurassic.AllosaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.jurassic.AllosaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.jurassic.CeratosaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.jurassic.CeratosaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.jurassic.DilophosaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.jurassic.DilophosaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.jurassic.SarahsaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.jurassic.SarahsaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.jurassic.ScelidosaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.jurassic.ScelidosaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.jurassic.StegosaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.jurassic.StegosaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.triassic.CoelophysisSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.triassic.CoelophysisSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.triassic.DesmatosuchusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.triassic.DesmatosuchusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.triassic.HerrerasaurusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.triassic.HerrerasaurusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.triassic.IschigualastiaSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.triassic.IschigualastiaSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.triassic.PostosuchusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.triassic.PostosuchusSkullRenderer;
import superlord.prehistoricfauna.client.render.fossil.triassic.SaurosuchusSkeletonRenderer;
import superlord.prehistoricfauna.client.render.fossil.triassic.SaurosuchusSkullRenderer;
import superlord.prehistoricfauna.client.render.henos.CaveSentinelRenderer;
import superlord.prehistoricfauna.client.render.henos.HenosRenderer;
import superlord.prehistoricfauna.client.render.henos.LandSentinelRenderer;
import superlord.prehistoricfauna.client.render.item.FermentedGinkgoBerryRenderer;
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
import superlord.prehistoricfauna.common.items.PFSpawnEggItem;
import superlord.prehistoricfauna.common.network.KeyInputMessage;
import superlord.prehistoricfauna.init.PFBlockEntities;
import superlord.prehistoricfauna.init.PFContainers;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFKeybinds;
import superlord.prehistoricfauna.init.PFWoodTypes;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

	@SubscribeEvent
	public static void init(final FMLClientSetupEvent event) {
		PFKeybinds.register(event);
		BlockEntityRenderers.register(PFBlockEntities.SIGN.get(), SignRenderer::new);
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
	public static ModelLayerLocation PLESIOHADROS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "plesiohadros_skull"), "plesiohadros_skull");
	public static ModelLayerLocation PROTOCERATOPS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "protoceratops_skull"), "protoceratops_skull");
	public static ModelLayerLocation VELOCIRAPTOR_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "velociraptor_skull"), "velociraptor_skull");
	public static ModelLayerLocation ANKYLOSAURUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ankylosaurus_skull"), "ankylosaurus_skull");
	public static ModelLayerLocation TRICERATOPS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "triceratops_skull"), "triceratops_skull");
	public static ModelLayerLocation TYRANNOSAURUS_SKULL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "tyrannosaurus_skull"), "tyrannosaurus_skull");
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
	//Hell Creek
	public static ModelLayerLocation ANKYLOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ankylosaurus"), "ankylosaurus");
	public static ModelLayerLocation ANKYLOSAURUS_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ankylosaurus_baby"), "ankylosaurus_baby");
	public static ModelLayerLocation ANZU = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "anzu"), "anzu");
	public static ModelLayerLocation BASILEMYS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "basilemys"), "basilemys");
	public static ModelLayerLocation DAKOTARAPTOR = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dakotaraptor"), "dakotaraptor");
	public static ModelLayerLocation DAKOTARAPTOR_BABY = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dakotaraptor_baby"), "dakotaraptor_baby");
	public static ModelLayerLocation DIDELPHODON = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "didelphodon"), "didelphodon");
	public static ModelLayerLocation EDMONTOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "edmontosaurus"), "edmontosaurus");
	public static ModelLayerLocation ORNITHOMIMUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ornithomimus"), "ornithomimus");
	public static ModelLayerLocation PACHYCEPHALOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "pachycephalosaurus"), "pachycephalosaurus");
	public static ModelLayerLocation PALAEOSANIWA = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "palaeosaniwa"), "palaeosaniwa");
	public static ModelLayerLocation THESCELOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "thescelosaurus"), "thescelosaurus");
	public static ModelLayerLocation THORACOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "thoracosaurus"), "thoracosaurus");
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
	public static ModelLayerLocation VELOCIRAPTOR = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "velociraptor"), "velociraptor");
	
	public static ModelLayerLocation DERMESTID_BEETLE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dermestid_beetle"), "dermestid_beetle");
	public static ModelLayerLocation GOBIULUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "gobiulus"), "gobiulus");
	
	//Yixian
	public static ModelLayerLocation BEIPIAOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "beipiaosaurus"), "beipiaosaurus");
	public static ModelLayerLocation CHANGYURAPTOR = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "changyuraptor"), "changyuraptor");
	public static ModelLayerLocation DILONG = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dilong"), "dilong");
	public static ModelLayerLocation DONGBEITITAN = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "dongbeititan"), "dongbeititan");
	public static ModelLayerLocation INCISIVOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "incisivosaurus"), "incisivosaurus");
	public static ModelLayerLocation JINZHOUSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "jinzhousaurus"), "jinzhousaurus");
	public static ModelLayerLocation LIAONINGOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "liaoningosaurus"), "liaoningosaurus");
	public static ModelLayerLocation PSITTACOSAURUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "psittacosaurus"), "psittacosaurus");
	public static ModelLayerLocation REPENOMAMUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "repenomamus"), "repenomamus");
	public static ModelLayerLocation RUIXINIA = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ruixinia"), "ruixinia");
	public static ModelLayerLocation SINOSAUROPTERYX = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "sinosauropteryx"), "sinosauropteryx");
	public static ModelLayerLocation YUTYRANNUS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "yutyrannus"), "yutyrannus");
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
	public static ModelLayerLocation SAURICHTHYS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "saurichthys"), "saurichthys");

	public static ModelLayerLocation ANKYLOSAURUS_HELMET = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "ankylosaurus_helmet"), "ankylosaurus_helmet");
	public static ModelLayerLocation DESMATOSUCHUS_CHESTPLATE = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "desmatosuchus_chestplate"), "desmatosuchus_chestplate");

	//Henos
	public static ModelLayerLocation HENOS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "henos"), "henos");
	public static ModelLayerLocation SUMMONED_HENOS = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "summoned_henos"), "summoned_henos");
	public static ModelLayerLocation CAVE_SENTINEL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "cave_sentinel"), "cave_sentinel");
	public static ModelLayerLocation LAND_SENTINEL = new ModelLayerLocation(new ResourceLocation(PrehistoricFauna.MOD_ID, "land_sentinel"), "land_sentinel");

	@SubscribeEvent
	public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(PFEntities.HERRERASAURUS_SKULL.get(), HerrerasaurusSkullRenderer::new);
		event.registerEntityRenderer(PFEntities.HERRERASAURUS_SKELETON.get(), HerrerasaurusSkeletonRenderer::new);
		event.registerEntityRenderer(PFEntities.BOAT.get(), PFBoatRenderer::new);
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
		event.registerEntityRenderer(PFEntities.THORACOSAURUS.get(), ThoracosaurusRenderer::new);
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
	}

	@SubscribeEvent
	public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(HENOS, HenosModel::createBodyLayer);
		event.registerLayerDefinition(SUMMONED_HENOS, HenosSummonedModel::createBodyLayer);
		event.registerLayerDefinition(CAVE_SENTINEL, CaveSentinelModel::createBodyLayer);
		event.registerLayerDefinition(LAND_SENTINEL, LandSentinelModel::createBodyLayer);
		event.registerLayerDefinition(ANKYLOSAURUS_HELMET, () -> AnkylosaurusHelmetModel.createArmorLayer(new CubeDeformation(1)));
		event.registerLayerDefinition(DESMATOSUCHUS_CHESTPLATE, () -> DesmatosuchusChestplateModel.createArmorLayer(new CubeDeformation(0)));

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
		event.registerLayerDefinition(SAURICHTHYS, SaurichthysModel::createBodyLayer);
		//Hell Creek
		event.registerLayerDefinition(THESCELOSAURUS, ThescelosaurusModel::createBodyLayer);
		event.registerLayerDefinition(BASILEMYS, BasilemysModel::createBodyLayer);
		event.registerLayerDefinition(ANKYLOSAURUS, AnkylosaurusModel::createBodyLayer);
		event.registerLayerDefinition(ANKYLOSAURUS_BABY, AnkylosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(DAKOTARAPTOR, DakotaraptorModel::createBodyLayer);
		event.registerLayerDefinition(DAKOTARAPTOR_BABY, DakotaraptorBabyModel::createBodyLayer);
		event.registerLayerDefinition(DIDELPHODON, DidelphodonModel::createBodyLayer);
		event.registerLayerDefinition(ORNITHOMIMUS, OrnithomimusModel::createBodyLayer);
		event.registerLayerDefinition(PALAEOSANIWA, PalaeosaniwaModel::createBodyLayer);
		event.registerLayerDefinition(TRICERATOPS, TriceratopsModel::createBodyLayer);
		event.registerLayerDefinition(TRICERATOPS_JUVENILE, TriceratopsJuvenileModel::createBodyLayer);
		event.registerLayerDefinition(TRICERATOPS_BABY, TriceratopsBabyModel::createBodyLayer);
		event.registerLayerDefinition(TYRANNOSAURUS, TyrannosaurusModel::createBodyLayer);
		event.registerLayerDefinition(TYRANNOSAURUS_JUVENILE, TyrannosaurusJuvenileModel::createBodyLayer);
		event.registerLayerDefinition(TYRANNOSAURUS_BABY, TyrannosaurusBabyModel::createBodyLayer);
		event.registerLayerDefinition(THORACOSAURUS, ThoracosaurusModel::createBodyLayer);
		event.registerLayerDefinition(PACHYCEPHALOSAURUS, PachycephalosaurusModel::createBodyLayer);
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
		event.registerLayerDefinition(GOYOCEPHALE, GoyocephaleModel::createBodyLayer);
		event.registerLayerDefinition(KOL, KolModel::createBodyLayer);
		//Yixian
		event.registerLayerDefinition(INCISIVOSAURUS, IncisivosaurusModel::createBodyLayer);
		event.registerLayerDefinition(PSITTACOSAURUS, PsittacosaurusModel::createBodyLayer);
		event.registerLayerDefinition(SINOSAUROPTERYX, SinosauropteryxModel::createBodyLayer);;
		event.registerLayerDefinition(YUTYRANNUS, YutyrannusModel::createBodyLayer);
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

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void itemColors(ColorHandlerEvent.Item event) {
		ItemColors handler = event.getItemColors();
		ItemColor eggColor = (stack, tintIndex) -> ((PFSpawnEggItem) stack.getItem()).getColor(tintIndex);
		for (PFSpawnEggItem e : PFSpawnEggItem.UNADDED_EGGS) handler.register(eggColor, e);
	}

	@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
	public static class ForgeBusEvents {

		@SubscribeEvent
		public static void onKeyPress(InputEvent.KeyInputEvent event) {
			Minecraft mc = Minecraft.getInstance();
			if (mc.level == null) return;
			onInput(mc, event.getKey(), event.getAction());
		}

		@SubscribeEvent
		public static void onMouseClick(InputEvent.MouseInputEvent event) {
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
		public static void onKeyPress(InputEvent.KeyInputEvent event) {
			Minecraft mc = Minecraft.getInstance();
			if (mc.level == null) return;
			onInput(mc, event.getKey(), event.getAction());
		}
		
		@SubscribeEvent
		public static void onMouseClick(InputEvent.MouseInputEvent event) {
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

}
