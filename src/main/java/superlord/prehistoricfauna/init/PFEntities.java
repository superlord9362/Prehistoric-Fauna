package superlord.prehistoricfauna.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.PFBoat;
import superlord.prehistoricfauna.common.entity.Paleopainting;
import superlord.prehistoricfauna.common.entity.WallFossil;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Aepyornithomimus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Citipati;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Pinacosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Plesiohadros;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Protoceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Telmasaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Velociraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Basilemys;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Didelphodon;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Thescelosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.fish.Arganodus;
import superlord.prehistoricfauna.common.entity.fish.Ceratodus;
import superlord.prehistoricfauna.common.entity.fish.Chinlea;
import superlord.prehistoricfauna.common.entity.fish.Cyclurus;
import superlord.prehistoricfauna.common.entity.fish.Gar;
import superlord.prehistoricfauna.common.entity.fish.Melvius;
import superlord.prehistoricfauna.common.entity.fish.Mooreodontus;
import superlord.prehistoricfauna.common.entity.fish.Myledaphus;
import superlord.prehistoricfauna.common.entity.fish.Potamoceratodus;
import superlord.prehistoricfauna.common.entity.fish.Saurichthys;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.AnkylosaurusSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.AnkylosaurusSkull;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.PlesiohadrosSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.PlesiohadrosSkull;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.ProtoceratopsSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.ProtoceratopsSkull;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.TriceratopsSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.TriceratopsSkull;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.TyrannosaurusSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.TyrannosaurusSkull;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.VelociraptorSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.VelociraptorSkull;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.AllosaurusSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.AllosaurusSkull;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.CeratosaurusSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.CeratosaurusSkull;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.DilophosaurusSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.DilophosaurusSkull;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.SarahsaurusSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.SarahsaurusSkull;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.ScelidosaurusSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.ScelidosaurusSkull;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.StegosaurusSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.jurassic.StegosaurusSkull;
import superlord.prehistoricfauna.common.entity.fossil.triassic.CoelophysisSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.triassic.CoelophysisSkull;
import superlord.prehistoricfauna.common.entity.fossil.triassic.DesmatosuchusSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.triassic.DesmatosuchusSkull;
import superlord.prehistoricfauna.common.entity.fossil.triassic.HerrerasaurusSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.triassic.HerrerasaurusSkull;
import superlord.prehistoricfauna.common.entity.fossil.triassic.IschigualastiaSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.triassic.IschigualastiaSkull;
import superlord.prehistoricfauna.common.entity.fossil.triassic.PostosuchusSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.triassic.PostosuchusSkull;
import superlord.prehistoricfauna.common.entity.fossil.triassic.SaurosuchusSkeleton;
import superlord.prehistoricfauna.common.entity.fossil.triassic.SaurosuchusSkull;
import superlord.prehistoricfauna.common.entity.henos.Henos;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Calsoyasuchus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Kayentatherium;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Megapnosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Sarahsaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Scelidosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Scutellosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Dryosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Eilenodon;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Hesperornithoides;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Coelophysis;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Desmatosuchus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Placerias;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Trilophosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Typothorax;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Chromogisaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Exaeretodon;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Hyperodapedon;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Ischigualastia;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Sillosuchus;

public class PFEntities {
	
	public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, PrehistoricFauna.MOD_ID);
	
	public static final RegistryObject<EntityType<PlesiohadrosSkull>> PLESIOHADROS_SKULL = REGISTER.register("plesiohadros_skull", () -> EntityType.Builder.<PlesiohadrosSkull>of(PlesiohadrosSkull::new, MobCategory.MISC).sized(0.8125F, 0.8125F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "plesiohadros_skull").toString()));
	public static final RegistryObject<EntityType<ProtoceratopsSkull>> PROTOCERATOPS_SKULL = REGISTER.register("protoceratops_skull", () -> EntityType.Builder.<ProtoceratopsSkull>of(ProtoceratopsSkull::new, MobCategory.MISC).sized(1.0F, 1.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "protoceratops_skull").toString()));
	public static final RegistryObject<EntityType<VelociraptorSkull>> VELOCIRAPTOR_SKULL = REGISTER.register("velociraptor_skull", () -> EntityType.Builder.<VelociraptorSkull>of(VelociraptorSkull::new, MobCategory.MISC).sized(0.4375F, 0.4375F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "velociraptor_skull").toString()));
	public static final RegistryObject<EntityType<AnkylosaurusSkull>> ANKYLOSAURUS_SKULL = REGISTER.register("ankylosaurus_skull", () -> EntityType.Builder.<AnkylosaurusSkull>of(AnkylosaurusSkull::new, MobCategory.MISC).sized(1.0F, 1.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "ankylosaurus_skull").toString()));
	public static final RegistryObject<EntityType<TriceratopsSkull>> TRICERATOPS_SKULL = REGISTER.register("triceratops_skull", () -> EntityType.Builder.<TriceratopsSkull>of(TriceratopsSkull::new, MobCategory.MISC).sized(1.0F, 1.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "triceratops_skull").toString()));
	public static final RegistryObject<EntityType<TyrannosaurusSkull>> TYRANNOSAURUS_SKULL = REGISTER.register("tyrannosaurus_skull", () -> EntityType.Builder.<TyrannosaurusSkull>of(TyrannosaurusSkull::new, MobCategory.MISC).sized(1.0F, 1.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "tyrannosaurus_skull").toString()));
	public static final RegistryObject<EntityType<DilophosaurusSkull>> DILOPHOSAURUS_SKULL = REGISTER.register("dilophosaurus_skull", () -> EntityType.Builder.<DilophosaurusSkull>of(DilophosaurusSkull::new, MobCategory.MISC).sized(0.875F, 0.875F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "dilophosaurus_skull").toString()));
	public static final RegistryObject<EntityType<SarahsaurusSkull>> SARAHSAURUS_SKULL = REGISTER.register("sarahsaurus_skull", () -> EntityType.Builder.<SarahsaurusSkull>of(SarahsaurusSkull::new, MobCategory.MISC).sized(0.4375F, 0.4375F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "sarahsaurus_skull").toString()));
	public static final RegistryObject<EntityType<ScelidosaurusSkull>> SCELIDOSAURUS_SKULL = REGISTER.register("scelidosaurus_skull", () -> EntityType.Builder.<ScelidosaurusSkull>of(ScelidosaurusSkull::new, MobCategory.MISC).sized(0.5625F, 0.5625F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "scelidosaurus_skull").toString()));
	public static final RegistryObject<EntityType<AllosaurusSkull>> ALLOSAURUS_SKULL = REGISTER.register("allosaurus_skull", () -> EntityType.Builder.<AllosaurusSkull>of(AllosaurusSkull::new, MobCategory.MISC).sized(1.0F, 1.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "allosaurus_skull").toString()));
	public static final RegistryObject<EntityType<CeratosaurusSkull>> CERATOSAURUS_SKULL = REGISTER.register("ceratosaurus_skull", () -> EntityType.Builder.<CeratosaurusSkull>of(CeratosaurusSkull::new, MobCategory.MISC).sized(1.0F, 1.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "ceratosaurus_skull").toString()));
	public static final RegistryObject<EntityType<StegosaurusSkull>> STEGOSAURUS_SKULL = REGISTER.register("stegosaurus_skull", () -> EntityType.Builder.<StegosaurusSkull>of(StegosaurusSkull::new, MobCategory.MISC).sized(1.0F, 1.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "stegosaurus_skull").toString()));
	public static final RegistryObject<EntityType<CoelophysisSkull>> COELOPHYSIS_SKULL = REGISTER.register("coelophysis_skull", () -> EntityType.Builder.<CoelophysisSkull>of(CoelophysisSkull::new, MobCategory.MISC).sized(0.4375F, 0.4375F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "coelophysis_skull").toString()));
	public static final RegistryObject<EntityType<DesmatosuchusSkull>> DESMATOSUCHUS_SKULL = REGISTER.register("desmatosuchus_skull", () -> EntityType.Builder.<DesmatosuchusSkull>of(DesmatosuchusSkull::new, MobCategory.MISC).sized(0.4375F, 0.4375F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "desmatosuchus_skull").toString()));
	public static final RegistryObject<EntityType<PostosuchusSkull>> POSTOSUCHUS_SKULL = REGISTER.register("postosuchus_skull", () -> EntityType.Builder.<PostosuchusSkull>of(PostosuchusSkull::new, MobCategory.MISC).sized(0.75F, 0.75F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "postosuchus_skull").toString()));
	public static final RegistryObject<EntityType<HerrerasaurusSkull>> HERRERASAURUS_SKULL = REGISTER.register("herrerasaurus_skull", () -> EntityType.Builder.<HerrerasaurusSkull>of(HerrerasaurusSkull::new, MobCategory.MISC).sized(0.6875F, 0.6875F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "herrerasaurus_skull").toString()));
	public static final RegistryObject<EntityType<IschigualastiaSkull>> ISCHIGUALASTIA_SKULL = REGISTER.register("ischigualastia_skull", () -> EntityType.Builder.<IschigualastiaSkull>of(IschigualastiaSkull::new, MobCategory.MISC).sized(1.0F, 1.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "ischigualastia_skull").toString()));
	public static final RegistryObject<EntityType<SaurosuchusSkull>> SAUROSUCHUS_SKULL = REGISTER.register("saurosuchus_skull", () -> EntityType.Builder.<SaurosuchusSkull>of(SaurosuchusSkull::new, MobCategory.MISC).sized(1.0F, 1.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "saurosuchus_skull").toString()));

	public static final RegistryObject<EntityType<PlesiohadrosSkeleton>> PLESIOHADROS_SKELETON = REGISTER.register("plesiohadros_skeleton", () -> EntityType.Builder.<PlesiohadrosSkeleton>of(PlesiohadrosSkeleton::new, MobCategory.MISC).sized(1.5F, 2.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "plesiohadros_skeleton").toString()));
	public static final RegistryObject<EntityType<ProtoceratopsSkeleton>> PROTOCERATOPS_SKELETON = REGISTER.register("protoceratops_skeleton", () -> EntityType.Builder.<ProtoceratopsSkeleton>of(ProtoceratopsSkeleton::new, MobCategory.MISC).sized(0.8125F, 0.8125F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "protoceratops_skeleton").toString()));
	public static final RegistryObject<EntityType<VelociraptorSkeleton>> VELOCIRAPTOR_SKELETON = REGISTER.register("velociraptor_skeleton", () -> EntityType.Builder.<VelociraptorSkeleton>of(VelociraptorSkeleton::new, MobCategory.MISC).sized(1.0F, 1.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "velociraptor_skeleton").toString()));
	public static final RegistryObject<EntityType<AnkylosaurusSkeleton>> ANKYLOSAURUS_SKELETON = REGISTER.register("ankylosaurus_skeleton", () -> EntityType.Builder.<AnkylosaurusSkeleton>of(AnkylosaurusSkeleton::new, MobCategory.MISC).sized(2.0F, 2.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "ankylosaurus_skeleton").toString()));
	public static final RegistryObject<EntityType<TriceratopsSkeleton>> TRICERATOPS_SKELETON = REGISTER.register("triceratops_skeleton", () -> EntityType.Builder.<TriceratopsSkeleton>of(TriceratopsSkeleton::new, MobCategory.MISC).sized(2.0F, 2.6F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "triceratops_skeleton").toString()));
	public static final RegistryObject<EntityType<TyrannosaurusSkeleton>> TYRANNOSAURUS_SKELETON = REGISTER.register("tyrannosaurus_skeleton", () -> EntityType.Builder.<TyrannosaurusSkeleton>of(TyrannosaurusSkeleton::new, MobCategory.MISC).sized(2.0F, 3.9F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "tyrannosaurus_skeleton").toString()));
	public static final RegistryObject<EntityType<DilophosaurusSkeleton>> DILOPHOSAURUS_SKELETON = REGISTER.register("dilophosaurus_skeleton", () -> EntityType.Builder.<DilophosaurusSkeleton>of(DilophosaurusSkeleton::new, MobCategory.MISC).sized(1.0F, 2.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "dilophosaurus_skeleton").toString()));
	public static final RegistryObject<EntityType<SarahsaurusSkeleton>> SARAHSAURUS_SKELETON = REGISTER.register("sarahsaurus_skeleton", () -> EntityType.Builder.<SarahsaurusSkeleton>of(SarahsaurusSkeleton::new, MobCategory.MISC).sized(1.0F, 1.25F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "sarahsaurus_skeleton").toString()));
	public static final RegistryObject<EntityType<ScelidosaurusSkeleton>> SCELIDOSAURUS_SKELETON = REGISTER.register("scelidosaurus_skeleton", () -> EntityType.Builder.<ScelidosaurusSkeleton>of(ScelidosaurusSkeleton::new, MobCategory.MISC).sized(1.0F, 1.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "scelidosaurus_skeleton").toString()));
	public static final RegistryObject<EntityType<AllosaurusSkeleton>> ALLOSAURUS_SKELETON = REGISTER.register("allosaurus_skeleton", () -> EntityType.Builder.<AllosaurusSkeleton>of(AllosaurusSkeleton::new, MobCategory.MISC).sized(1.25F, 2.8125F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "allosaurus_skeleton").toString()));
	public static final RegistryObject<EntityType<CeratosaurusSkeleton>> CERATOSAURUS_SKELETON = REGISTER.register("ceratosaurus_skeleton", () -> EntityType.Builder.<CeratosaurusSkeleton>of(CeratosaurusSkeleton::new, MobCategory.MISC).sized(0.875F, 2.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "ceratosaurus_skeleton").toString()));
	public static final RegistryObject<EntityType<StegosaurusSkeleton>> STEGOSAURUS_SKELETON = REGISTER.register("stegosaurus_skeleton", () -> EntityType.Builder.<StegosaurusSkeleton>of(StegosaurusSkeleton::new, MobCategory.MISC).sized(1.5F, 2.6875F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "stegosaurus_skeleton").toString()));
	public static final RegistryObject<EntityType<CoelophysisSkeleton>> COELOPHYSIS_SKELETON = REGISTER.register("coelophysis_skeleton", () -> EntityType.Builder.<CoelophysisSkeleton>of(CoelophysisSkeleton::new, MobCategory.MISC).sized(0.75F, 1.25F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "coelophysis_skeleton").toString()));
	public static final RegistryObject<EntityType<DesmatosuchusSkeleton>> DESMATOSUCHUS_SKELETON = REGISTER.register("desmatosuchus_skeleton", () -> EntityType.Builder.<DesmatosuchusSkeleton>of(DesmatosuchusSkeleton::new, MobCategory.MISC).sized(1.25F, 1.25F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "desmatosuchus_skeleton").toString()));
	public static final RegistryObject<EntityType<PostosuchusSkeleton>> POSTOSUCHUS_SKELETON = REGISTER.register("postosuchus_skeleton", () -> EntityType.Builder.<PostosuchusSkeleton>of(PostosuchusSkeleton::new, MobCategory.MISC).sized(1.0F, 1.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "postosuchus_skeleton").toString()));
	public static final RegistryObject<EntityType<HerrerasaurusSkeleton>> HERRERASAURUS_SKELETON = REGISTER.register("herrerasaurus_skeleton", () -> EntityType.Builder.<HerrerasaurusSkeleton>of(HerrerasaurusSkeleton::new, MobCategory.MISC).sized(0.625F, 1.375F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "herrerasaurus_skeleton").toString()));
	public static final RegistryObject<EntityType<IschigualastiaSkeleton>> ISCHIGUALASTIA_SKELETON = REGISTER.register("ischigualastia_skeleton", () -> EntityType.Builder.<IschigualastiaSkeleton>of(IschigualastiaSkeleton::new, MobCategory.MISC).sized(1.25F, 1.9375F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "ischigualastia_skeleton").toString()));
	public static final RegistryObject<EntityType<SaurosuchusSkeleton>> SAUROSUCHUS_SKELETON = REGISTER.register("saurosuchus_skeleton", () -> EntityType.Builder.<SaurosuchusSkeleton>of(SaurosuchusSkeleton::new, MobCategory.MISC).sized(0.75F, 1.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "saurosuchus_skeleton").toString()));
	
	//Fish
	public static final RegistryObject<EntityType<Arganodus>> ARGANODUS = REGISTER.register("arganodus", () -> EntityType.Builder.<Arganodus>of(Arganodus::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "arganodus").toString()));
	public static final RegistryObject<EntityType<Ceratodus>> CERATODUS = REGISTER.register("ceratodus", () -> EntityType.Builder.<Ceratodus>of(Ceratodus::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "ceratodus").toString()));
	public static final RegistryObject<EntityType<Chinlea>> CHINLEA = REGISTER.register("chinlea", () -> EntityType.Builder.<Chinlea>of(Chinlea::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "chinlea").toString()));
	public static final RegistryObject<EntityType<Cyclurus>> CYCLURUS = REGISTER.register("cyclurus", () -> EntityType.Builder.<Cyclurus>of(Cyclurus::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "cyclurus").toString()));
	public static final RegistryObject<EntityType<Gar>> GAR = REGISTER.register("gar", () -> EntityType.Builder.<Gar>of(Gar::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "gar").toString()));
	public static final RegistryObject<EntityType<Melvius>> MELVIUS = REGISTER.register("melvius", () -> EntityType.Builder.<Melvius>of(Melvius::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "melvius").toString()));
	public static final RegistryObject<EntityType<Mooreodontus>> MOOREODONTUS = REGISTER.register("mooreodontus", () -> EntityType.Builder.<Mooreodontus>of(Mooreodontus::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "mooreodontus").toString()));
	public static final RegistryObject<EntityType<Myledaphus>> MYLEDAPHUS = REGISTER.register("myledaphus", () -> EntityType.Builder.<Myledaphus>of(Myledaphus::new, MobCategory.WATER_AMBIENT).sized(0.6875F, 0.2F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "myledaphus").toString()));
	public static final RegistryObject<EntityType<Potamoceratodus>> POTAMOCERATODUS = REGISTER.register("potamoceratodus", () -> EntityType.Builder.<Potamoceratodus>of(Potamoceratodus::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "potamoceratodus").toString()));
	public static final RegistryObject<EntityType<Saurichthys>> SAURICHTHYS = REGISTER.register("saurichthys", () -> EntityType.Builder.<Saurichthys>of(Saurichthys::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "saurichthys").toString()));

	//Hell Creek
	public static final RegistryObject<EntityType<Ankylosaurus>> ANKYLOSAURUS = REGISTER.register("ankylosaurus", () -> EntityType.Builder.<Ankylosaurus>of(Ankylosaurus::new, MobCategory.CREATURE).sized(2F, 2F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "ankylosaurus").toString()));
	public static final RegistryObject<EntityType<Basilemys>> BASILEMYS = REGISTER.register("basilemys", () -> EntityType.Builder.<Basilemys>of(Basilemys::new, MobCategory.CREATURE).sized(0.75F, 0.375F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "basilemys").toString()));
	public static final RegistryObject<EntityType<Dakotaraptor>> DAKOTARAPTOR = REGISTER.register("dakotaraptor", () -> EntityType.Builder.<Dakotaraptor>of(Dakotaraptor::new, MobCategory.CREATURE).sized(0.875F, 2.15F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "dakotaraptor").toString()));
	public static final RegistryObject<EntityType<Didelphodon>> DIDELPHODON = REGISTER.register("didelphodon", () -> EntityType.Builder.<Didelphodon>of(Didelphodon::new, MobCategory.CREATURE).sized(0.35F, 0.4F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "didelphodon").toString()));
	public static final RegistryObject<EntityType<Thescelosaurus>> THESCELOSAURUS = REGISTER.register("thescelosaurus", () -> EntityType.Builder.<Thescelosaurus>of(Thescelosaurus::new, MobCategory.CREATURE).sized(0.55F, 1.25F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "thescelosaurus").toString()));
	public static final RegistryObject<EntityType<Triceratops>> TRICERATOPS = REGISTER.register("triceratops", () -> EntityType.Builder.<Triceratops>of(Triceratops::new, MobCategory.CREATURE).sized(2F, 2.6F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "triceratops").toString()));
	public static final RegistryObject<EntityType<Tyrannosaurus>> TYRANNOSAURUS = REGISTER.register("tyrannosaurus", () -> EntityType.Builder.<Tyrannosaurus>of(Tyrannosaurus::new, MobCategory.CREATURE).sized(2F, 4F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "tyrannosaurus").toString()));
	
	//Djadochta
	public static final RegistryObject<EntityType<Aepyornithomimus>> AEPYORNITHOMIMUS = REGISTER.register("aepyornithomimus", () -> EntityType.Builder.<Aepyornithomimus>of(Aepyornithomimus::new, MobCategory.CREATURE).sized(0.9375F, 1.25F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "aepyornithomimus").toString()));
	public static final RegistryObject<EntityType<Citipati>> CITIPATI = REGISTER.register("citipati", () -> EntityType.Builder.<Citipati>of(Citipati::new, MobCategory.CREATURE).sized(0.5625F, 1.9F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "citipati").toString()));
	public static final RegistryObject<EntityType<Pinacosaurus>> PINACOSAURUS = REGISTER.register("pinacosaurus", () -> EntityType.Builder.<Pinacosaurus>of(Pinacosaurus::new, MobCategory.CREATURE).sized(2, 1.1F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "pinacosaurus").toString()));
	public static final RegistryObject<EntityType<Plesiohadros>> PLESIOHADROS = REGISTER.register("plesiohadros", () -> EntityType.Builder.<Plesiohadros>of(Plesiohadros::new, MobCategory.CREATURE).sized(1.5F, 2).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "plesiohadros").toString()));
	public static final RegistryObject<EntityType<Protoceratops>> PROTOCERATOPS = REGISTER.register("protoceratops", () -> EntityType.Builder.<Protoceratops>of(Protoceratops::new, MobCategory.CREATURE).sized(0.5F, 0.875F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "protoceratops").toString()));
	public static final RegistryObject<EntityType<Telmasaurus>> TELMASAURUS = REGISTER.register("telmasaurus", () -> EntityType.Builder.<Telmasaurus>of(Telmasaurus::new, MobCategory.CREATURE).sized(1, 0.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "telmasaurus").toString()));
	public static final RegistryObject<EntityType<Velociraptor>> VELOCIRAPTOR = REGISTER.register("velociraptor", () -> EntityType.Builder.<Velociraptor>of(Velociraptor::new, MobCategory.CREATURE).sized(0.3125F, 0.8F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "velociraptor").toString()));
	
	//Kayenta
	public static final RegistryObject<EntityType<Calsoyasuchus>> CALSOYASUCHUS = REGISTER.register("calsoyasuchus", () -> EntityType.Builder.<Calsoyasuchus>of(Calsoyasuchus::new, MobCategory.CREATURE).sized(0.5F, 0.3F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "calsoyasuchus").toString()));
	public static final RegistryObject<EntityType<Dilophosaurus>> DILOPHOSAURUS = REGISTER.register("dilophosaurus", () -> EntityType.Builder.<Dilophosaurus>of(Dilophosaurus::new, MobCategory.CREATURE).sized(1, 2.2F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "dilophosaurus").toString()));
	public static final RegistryObject<EntityType<Kayentatherium>> KAYENTATHERIUM = REGISTER.register("kayentatherium", () -> EntityType.Builder.<Kayentatherium>of(Kayentatherium::new, MobCategory.CREATURE).sized(0.5F, 0.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "kayentatherium").toString()));
	public static final RegistryObject<EntityType<Megapnosaurus>> MEGAPNOSAURUS = REGISTER.register("megapnosaurus", () -> EntityType.Builder.<Megapnosaurus>of(Megapnosaurus::new, MobCategory.CREATURE).sized(0.75F, 0.85F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "megapnosaurus").toString()));
	public static final RegistryObject<EntityType<Sarahsaurus>> SARAHSAURUS = REGISTER.register("sarahsaurus", () -> EntityType.Builder.<Sarahsaurus>of(Sarahsaurus::new, MobCategory.CREATURE).sized(1, 1.45F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "sarahsaurus").toString()));
	public static final RegistryObject<EntityType<Scelidosaurus>> SCELIDOSAURUS = REGISTER.register("scelidosaurus", () -> EntityType.Builder.<Scelidosaurus>of(Scelidosaurus::new, MobCategory.CREATURE).sized(1, 1).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "scelidosaurus").toString()));
	public static final RegistryObject<EntityType<Scutellosaurus>> SCUTELLOSAURUS = REGISTER.register("scutellosaurus", () -> EntityType.Builder.<Scutellosaurus>of(Scutellosaurus::new, MobCategory.CREATURE).sized(0.6F, 0.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "scutellosaurus").toString()));
	
	//Morrison
	public static final RegistryObject<EntityType<Allosaurus>> ALLOSAURUS = REGISTER.register("allosaurus", () -> EntityType.Builder.<Allosaurus>of(Allosaurus::new, MobCategory.CREATURE).sized(1.25F, 3.0F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "allosaurus").toString()));
	public static final RegistryObject<EntityType<Camarasaurus>> CAMARASAURUS = REGISTER.register("camarasaurus", () -> EntityType.Builder.<Camarasaurus>of(Camarasaurus::new, MobCategory.CREATURE).sized(3.125F, 8.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "camarasaurus").toString()));
	public static final RegistryObject<EntityType<Ceratosaurus>> CERATOSAURUS = REGISTER.register("ceratosaurus", () -> EntityType.Builder.<Ceratosaurus>of(Ceratosaurus::new, MobCategory.CREATURE).sized(0.875F, 2F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "ceratosaurus").toString()));
	public static final RegistryObject<EntityType<Dryosaurus>> DRYOSAURUS = REGISTER.register("dryosaurus", () -> EntityType.Builder.<Dryosaurus>of(Dryosaurus::new, MobCategory.CREATURE).sized(0.875F, 2F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "dryosaurus").toString()));
	public static final RegistryObject<EntityType<Eilenodon>> EILENODON = REGISTER.register("eilenodon", () -> EntityType.Builder.<Eilenodon>of(Eilenodon::new, MobCategory.CREATURE).sized(0.25F, 0.25F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "eilenodon").toString()));
	public static final RegistryObject<EntityType<Hesperornithoides>> HESPERORNITHOIDES = REGISTER.register("hesperornithoides", () -> EntityType.Builder.<Hesperornithoides>of(Hesperornithoides::new, MobCategory.CREATURE).sized(0.375F, 0.55F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "hesperornithoides").toString()));
	public static final RegistryObject<EntityType<Stegosaurus>> STEGOSAURUS = REGISTER.register("stegosaurus", () -> EntityType.Builder.<Stegosaurus>of(Stegosaurus::new, MobCategory.CREATURE).sized(1.5F, 2.6875F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "stegosaurus").toString()));
	
	//Chinle
	public static final RegistryObject<EntityType<Coelophysis>> COELOPHYSIS = REGISTER.register("coelophysis", () -> EntityType.Builder.<Coelophysis>of(Coelophysis::new, MobCategory.CREATURE).sized(0.75F, 1.25F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "coelophysis").toString()));
	public static final RegistryObject<EntityType<Desmatosuchus>> DESMATOSUCHUS = REGISTER.register("desmatosuchus", () -> EntityType.Builder.<Desmatosuchus>of(Desmatosuchus::new, MobCategory.CREATURE).sized(1.25F, 1.25F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "desmatosuchus").toString()));
	public static final RegistryObject<EntityType<Placerias>> PLACERIAS = REGISTER.register("placerias", () -> EntityType.Builder.<Placerias>of(Placerias::new, MobCategory.CREATURE).sized(1, 1.25F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "placerias").toString()));
	public static final RegistryObject<EntityType<Poposaurus>> POPOSAURUS = REGISTER.register("poposaurus", () -> EntityType.Builder.<Poposaurus>of(Poposaurus::new, MobCategory.CREATURE).sized(1, 1.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "poposaurus").toString()));
	public static final RegistryObject<EntityType<Postosuchus>> POSTOSUCHUS = REGISTER.register("postosuchus", () -> EntityType.Builder.<Postosuchus>of(Postosuchus::new, MobCategory.CREATURE).sized(1, 1.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "postosuchus").toString()));
	public static final RegistryObject<EntityType<Trilophosaurus>> TRILOPHOSAURUS = REGISTER.register("trilophosaurus", () -> EntityType.Builder.<Trilophosaurus>of(Trilophosaurus::new, MobCategory.CREATURE).sized(0.5F, 0.75F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "trilophosaurus").toString()));
	public static final RegistryObject<EntityType<Typothorax>> TYPOTHORAX = REGISTER.register("typothorax", () -> EntityType.Builder.<Typothorax>of(Typothorax::new, MobCategory.CREATURE).sized(1, 0.75F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "typothorax").toString()));
	
	//Ischigualasto
	public static final RegistryObject<EntityType<Chromogisaurus>> CHROMOGISAURUS = REGISTER.register("chromogisaurus", () -> EntityType.Builder.<Chromogisaurus>of(Chromogisaurus::new, MobCategory.CREATURE).sized(0.375F, 0.8F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "chromogisaurus").toString()));
	public static final RegistryObject<EntityType<Exaeretodon>> EXAERETODON = REGISTER.register("exaeretodon", () -> EntityType.Builder.<Exaeretodon>of(Exaeretodon::new, MobCategory.CREATURE).sized(0.75F, 0.5625F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "exaeretodon").toString()));
	public static final RegistryObject<EntityType<Herrerasaurus>> HERRERASAURUS = REGISTER.register("herrerasaurus", () -> EntityType.Builder.<Herrerasaurus>of(Herrerasaurus::new, MobCategory.CREATURE).sized(0.625F, 1.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "herrerasaurus").toString()));
	public static final RegistryObject<EntityType<Hyperodapedon>> HYPERODAPEDON = REGISTER.register("hyperodapedon", () -> EntityType.Builder.<Hyperodapedon>of(Hyperodapedon::new, MobCategory.CREATURE).sized(0.375F, 0.3125F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "hyperodapedon").toString()));
	public static final RegistryObject<EntityType<Ischigualastia>> ISCHIGUALASTIA = REGISTER.register("ischigualastia", () -> EntityType.Builder.<Ischigualastia>of(Ischigualastia::new, MobCategory.CREATURE).sized(1.25F, 1.9375F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "ischigualastia").toString()));
	public static final RegistryObject<EntityType<Saurosuchus>> SAUROSUCHUS = REGISTER.register("saurosuchus", () -> EntityType.Builder.<Saurosuchus>of(Saurosuchus::new, MobCategory.CREATURE).sized(0.75F, 1.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "saurosuchus").toString()));
	public static final RegistryObject<EntityType<Sillosuchus>> SILLOSUCHUS = REGISTER.register("sillosuchus", () -> EntityType.Builder.<Sillosuchus>of(Sillosuchus::new, MobCategory.CREATURE).sized(1.5F, 3.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "sillosuchus").toString()));
	
	public static final RegistryObject<EntityType<Henos>> HENOS = REGISTER.register("henos", () -> EntityType.Builder.<Henos>of(Henos::new, MobCategory.MONSTER).sized(1.3125F, 3.125F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "henos").toString()));
	
	public static final RegistryObject<EntityType<PFBoat>> BOAT = REGISTER.register("boat", () -> EntityType.Builder.<PFBoat>of(PFBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "boat").toString()));
	public static final RegistryObject<EntityType<Paleopainting>> PALEOPAINTING = REGISTER.register("paleopainting", () -> EntityType.Builder.<Paleopainting>of(Paleopainting::new, MobCategory.MISC).sized(0.5F, 0.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "paleopainting").toString()));
	public static final RegistryObject<EntityType<WallFossil>> WALL_FOSSIL = REGISTER.register("wall_fossil", () -> EntityType.Builder.<WallFossil>of(WallFossil::new, MobCategory.MISC).sized(0.5F, 0.5F).build(new ResourceLocation(PrehistoricFauna.MOD_ID, "wall_fossil").toString()));

}
