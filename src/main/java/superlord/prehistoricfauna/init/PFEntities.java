package superlord.prehistoricfauna.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entities.PaleopaintingEntity;
import superlord.prehistoricfauna.common.entities.PrehistoricBoatEntity;
import superlord.prehistoricfauna.common.entities.WallFossilEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.AepyornithomimusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.CitipatiEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.PinacosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.PlesiohadrosEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.ProtoceratopsEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.TelmasaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.VelociraptorEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.AnkylosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.BasilemysEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DakotaraptorEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DidelphodonEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.ThescelosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TriceratopsEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TyrannosaurusEntity;
import superlord.prehistoricfauna.common.entities.fish.ArganodusEntity;
import superlord.prehistoricfauna.common.entities.fish.CeratodusEntity;
import superlord.prehistoricfauna.common.entities.fish.ChinleaEntity;
import superlord.prehistoricfauna.common.entities.fish.CyclurusEntity;
import superlord.prehistoricfauna.common.entities.fish.GarEntity;
import superlord.prehistoricfauna.common.entities.fish.MooreodontusEntity;
import superlord.prehistoricfauna.common.entities.fish.MyledaphusEntity;
import superlord.prehistoricfauna.common.entities.fish.PotamoceratodusEntity;
import superlord.prehistoricfauna.common.entities.fish.SaurichthysEntity;
import superlord.prehistoricfauna.common.entities.fossil.AllosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.AllosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.AnkylosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.AnkylosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.CeratosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.CeratosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.CoelophysisSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.CoelophysisSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.DesmatosuchusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.DesmatosuchusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.DilophosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.DilophosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.HerrerasaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.HerrerasaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.IschigualastiaSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.IschigualastiaSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.PlesiohadrosSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.PlesiohadrosSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.PostosuchusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.PostosuchusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.ProtoceratopsSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.ProtoceratopsSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.SarahsaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.SarahsaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.SaurosuchusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.SaurosuchusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.ScelidosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.ScelidosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.StegosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.StegosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.TriceratopsSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.TriceratopsSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.TyrannosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.TyrannosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.fossil.VelociraptorSkeletonEntity;
import superlord.prehistoricfauna.common.entities.fossil.VelociraptorSkullEntity;
import superlord.prehistoricfauna.common.entities.henos.LandSentinelEntity;
import superlord.prehistoricfauna.common.entities.henos.TimeGuardianEntity;
import superlord.prehistoricfauna.common.entities.henos.TrilobiteSentinelEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.CalsoyasuchusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.DilophosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.KayentatheriumEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.MegapnosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.SarahsaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.ScelidosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.ScutellosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.AllosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CamarasaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CeratosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.DryosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.EilenodonEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.HesperornithoidesEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.StegosaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.CoelophysisEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.DesmatosuchusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PlaceriasEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PoposaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PostosuchusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.TrilophosaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.TypothoraxEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ChromogisaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ExaeretodonEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HerrerasaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HyperodapedonEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.IschigualastiaEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SaurosuchusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SillosuchusEntity;

public class PFEntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, PrehistoricFauna.MOD_ID);
	
	//Cretaceous
	//Hell Creek
	public static final EntityType<ThescelosaurusEntity> THESCELOSAURUS_ENTITY = register(EntityType.Builder.<ThescelosaurusEntity>create(ThescelosaurusEntity::new, EntityClassification.CREATURE).size(0.55F, 1.0F), "thescelosaurus");
	public static final EntityType<TriceratopsEntity> TRICERATOPS_ENTITY = register(EntityType.Builder.<TriceratopsEntity>create(TriceratopsEntity::new, EntityClassification.CREATURE).size(2F, 2.6F), "triceratops");
	public static final EntityType<AnkylosaurusEntity> ANKYLOSAURUS_ENTITY = register(EntityType.Builder.<AnkylosaurusEntity>create(AnkylosaurusEntity::new, EntityClassification.CREATURE).size(2F, 2F), "ankylosaurus");
	public static final EntityType<TyrannosaurusEntity> TYRANNOSAURUS_ENTITY = register(EntityType.Builder.<TyrannosaurusEntity>create(TyrannosaurusEntity::new, EntityClassification.CREATURE).size(2F, 3.9F), "tyrannosaurus");
	public static final EntityType<BasilemysEntity> BASILEMYS_ENTITY = register(EntityType.Builder.<BasilemysEntity>create(BasilemysEntity::new, EntityClassification.CREATURE).size(0.75F, 0.375F), "basilemys");
	public static final EntityType<DakotaraptorEntity> DAKOTARAPTOR_ENTITY = register(EntityType.Builder.<DakotaraptorEntity>create(DakotaraptorEntity::new, EntityClassification.CREATURE).size(0.875F, 1.6875F), "dakotaraptor");
	public static final EntityType<DidelphodonEntity> DIDELPHODON_ENTITY = register(EntityType.Builder.<DidelphodonEntity>create(DidelphodonEntity::new, EntityClassification.CREATURE).size(0.35F, 0.4F), "didelphodon");
	//Djadochta
	public static final EntityType<ProtoceratopsEntity> PROTOCERATOPS_ENTITY = register(EntityType.Builder.<ProtoceratopsEntity>create(ProtoceratopsEntity::new, EntityClassification.CREATURE).size(0.5F, 0.875F), "protoceratops");
	public static final EntityType<VelociraptorEntity> VELOCIRAPTOR_ENTITY = register(EntityType.Builder.<VelociraptorEntity>create(VelociraptorEntity::new, EntityClassification.CREATURE).size(0.3125F, 0.625F), "velociraptor");
	public static final EntityType<CitipatiEntity> CITIPATI_ENTITY = register(EntityType.Builder.<CitipatiEntity>create(CitipatiEntity::new, EntityClassification.CREATURE).size(0.5625F, 1.3125F), "citipati");
	public static final EntityType<AepyornithomimusEntity> AEPYORNITHOMIMUS_ENTITY = register(EntityType.Builder.<AepyornithomimusEntity>create(AepyornithomimusEntity::new, EntityClassification.CREATURE).size(0.9375F, 1F), "aepyornithomimus");
	public static final EntityType<TelmasaurusEntity> TELMASAURUS_ENTITY = register(EntityType.Builder.<TelmasaurusEntity>create(TelmasaurusEntity::new, EntityClassification.CREATURE).size(1, 0.5F), "telmasaurus");
	public static final EntityType<PinacosaurusEntity> PINACOSAURUS_ENTITY = register(EntityType.Builder.<PinacosaurusEntity>create(PinacosaurusEntity::new, EntityClassification.CREATURE).size(2, 1), "pinacosaurus");
	public static final EntityType<PlesiohadrosEntity> PLESIOHADROS_ENTITY = register(EntityType.Builder.<PlesiohadrosEntity>create(PlesiohadrosEntity::new, EntityClassification.CREATURE).size(1.5F, 2), "plesiohadros");
	//Jurassic
	//Morrison
	public static final EntityType<AllosaurusEntity> ALLOSAURUS_ENTITY = register(EntityType.Builder.<AllosaurusEntity>create(AllosaurusEntity::new, EntityClassification.CREATURE).size(1.25F, 2.8125F), "allosaurus");
	public static final EntityType<StegosaurusEntity> STEGOSAURUS_ENTITY = register(EntityType.Builder.<StegosaurusEntity>create(StegosaurusEntity::new, EntityClassification.CREATURE).size(1.5F, 2.6875F), "stegosaurus");
	public static final EntityType<CeratosaurusEntity> CERATOSAURUS_ENTITY = register(EntityType.Builder.<CeratosaurusEntity>create(CeratosaurusEntity::new, EntityClassification.CREATURE).size(0.875F, 2F), "ceratosaurus");
	public static final EntityType<DryosaurusEntity> DRYOSAURUS_ENTITY = register(EntityType.Builder.<DryosaurusEntity>create(DryosaurusEntity::new, EntityClassification.CREATURE).size(0.45F, 1.1875F), "dryosaurus");
	public static final EntityType<HesperornithoidesEntity> HESPERORNITHOIDES_ENTITY = register(EntityType.Builder.<HesperornithoidesEntity>create(HesperornithoidesEntity::new, EntityClassification.CREATURE).size(0.375F, 0.55F), "hesperornithoides");
	public static final EntityType<EilenodonEntity> EILENODON_ENTITY = register(EntityType.Builder.<EilenodonEntity>create(EilenodonEntity::new, EntityClassification.CREATURE).size(0.25F, 0.25F), "eilenodon");
	public static final EntityType<CamarasaurusEntity> CAMARASAURUS_ENTITY = register(EntityType.Builder.<CamarasaurusEntity>create(CamarasaurusEntity::new, EntityClassification.CREATURE).size(3.125F, 5.3125F), "camarasaurus");
	//Kayenta
	public static final EntityType<CalsoyasuchusEntity> CALSOYASUCHUS_ENTITY = register(EntityType.Builder.<CalsoyasuchusEntity>create(CalsoyasuchusEntity::new, EntityClassification.CREATURE).size(0.5F, 0.25F), "calsoyasuchus");
	public static final EntityType<DilophosaurusEntity> DILOPHOSAURUS_ENTITY = register(EntityType.Builder.<DilophosaurusEntity>create(DilophosaurusEntity::new, EntityClassification.CREATURE).size(1, 2F), "dilophosaurus");
	public static final EntityType<SarahsaurusEntity> SARAHSAURUS_ENTITY = register(EntityType.Builder.<SarahsaurusEntity>create(SarahsaurusEntity::new, EntityClassification.CREATURE).size(1, 1.25F), "sarahsaurus");
	public static final EntityType<ScelidosaurusEntity> SCELIDOSAURUS_ENTITY = register(EntityType.Builder.<ScelidosaurusEntity>create(ScelidosaurusEntity::new, EntityClassification.CREATURE).size(1, 1), "scelidosaurus");
	public static final EntityType<ScutellosaurusEntity> SCUTELLOSAURUS_ENTITY = register(EntityType.Builder.<ScutellosaurusEntity>create(ScutellosaurusEntity::new, EntityClassification.CREATURE).size(0.6F, 0.5F), "scutellosaurus");
	public static final EntityType<MegapnosaurusEntity> MEGAPNOSAURUS_ENTITY = register(EntityType.Builder.<MegapnosaurusEntity>create(MegapnosaurusEntity::new, EntityClassification.CREATURE).size(0.75F, 0.75F), "megapnosaurus");
	public static final EntityType<KayentatheriumEntity> KAYENTATHERIUM_ENTITY = register(EntityType.Builder.<KayentatheriumEntity>create(KayentatheriumEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F), "kayentatherium");
	//Triassic
	//Chinle
	public static final EntityType<PostosuchusEntity> POSTOSUCHUS_ENTITY = register(EntityType.Builder.<PostosuchusEntity>create(PostosuchusEntity::new, EntityClassification.CREATURE).size(1, 1.5F), "postosuchus");
	public static final EntityType<DesmatosuchusEntity> DESMATOSUCHUS_ENTITY = register(EntityType.Builder.<DesmatosuchusEntity>create(DesmatosuchusEntity::new, EntityClassification.CREATURE).size(1.25F, 1.25F), "desmatosuchus");
	public static final EntityType<TrilophosaurusEntity> TRILOPHOSAURUS_ENTITY = register(EntityType.Builder.<TrilophosaurusEntity>create(TrilophosaurusEntity::new, EntityClassification.CREATURE).size(0.5F, 0.75F), "trilophosaurus");
	public static final EntityType<SaurichthysEntity> SAURICHTHYS_ENTITY = register(EntityType.Builder.<SaurichthysEntity>create(SaurichthysEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F), "saurichthys");
	public static final EntityType<ArganodusEntity> ARGANODUS_ENTITY = register(EntityType.Builder.<ArganodusEntity>create(ArganodusEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F), "arganodus");
	public static final EntityType<MooreodontusEntity> MOOREODONTUS_ENTITY = register(EntityType.Builder.<MooreodontusEntity>create(MooreodontusEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F), "mooreodontus");
	public static final EntityType<ChinleaEntity> CHINLEA_ENTITY = register(EntityType.Builder.<ChinleaEntity>create(ChinleaEntity::new, EntityClassification.CREATURE).size(0.5F, 0.5F), "chinlea");
	public static final EntityType<PlaceriasEntity> PLACERIAS_ENTITY = register(EntityType.Builder.<PlaceriasEntity>create(PlaceriasEntity::new, EntityClassification.CREATURE).size(1, 1.25F), "placerias");
	public static final EntityType<CoelophysisEntity> COELOPHYSIS_ENTITY = register(EntityType.Builder.<CoelophysisEntity>create(CoelophysisEntity::new, EntityClassification.CREATURE).size(0.75F, 1.25F), "coelophysis");
	public static final EntityType<PoposaurusEntity> POPOSAURUS_ENTITY = register(EntityType.Builder.<PoposaurusEntity>create(PoposaurusEntity::new, EntityClassification.CREATURE).size(1, 1.5F), "poposaurus");
	public static final EntityType<TypothoraxEntity> TYPOTHORAX_ENTITY = register(EntityType.Builder.<TypothoraxEntity>create(TypothoraxEntity::new, EntityClassification.CREATURE).size(1, 0.75F), "typothorax");
	//Ischigualasto
	public static final EntityType<ExaeretodonEntity> EXAERETODON_ENTITY = register(EntityType.Builder.<ExaeretodonEntity>create(ExaeretodonEntity::new, EntityClassification.CREATURE).size(0.75F, 0.5625F), "exaeretodon");
	public static final EntityType<ChromogisaurusEntity> CHROMOGISAURUS_ENTITY = register(EntityType.Builder.<ChromogisaurusEntity>create(ChromogisaurusEntity::new, EntityClassification.CREATURE).size(0.375F, 0.625F), "chromogisaurus");
	public static final EntityType<HerrerasaurusEntity> HERRERASAURUS_ENTITY = register(EntityType.Builder.<HerrerasaurusEntity>create(HerrerasaurusEntity::new, EntityClassification.CREATURE).size(0.625F, 1.375F), "herrerasaurus");
	public static final EntityType<HyperodapedonEntity> HYPERODAPEDON_ENTITY = register(EntityType.Builder.<HyperodapedonEntity>create(HyperodapedonEntity::new, EntityClassification.CREATURE).size(0.375F, 0.3125F), "hyperodapedon");
	public static final EntityType<SillosuchusEntity> SILLOSUCHUS_ENTITY = register(EntityType.Builder.<SillosuchusEntity>create(SillosuchusEntity::new, EntityClassification.CREATURE).size(1.5F, 3.5F), "sillosuchus");
	public static final EntityType<SaurosuchusEntity> SAUROSUCHUS_ENTITY = register(EntityType.Builder.<SaurosuchusEntity>create(SaurosuchusEntity::new, EntityClassification.CREATURE).size(0.75F, 1.5F), "saurosuchus");
	public static final EntityType<IschigualastiaEntity> ISCHIGUALASTIA_ENTITY = register(EntityType.Builder.<IschigualastiaEntity>create(IschigualastiaEntity::new, EntityClassification.CREATURE).size(1.25F, 1.9375F), "ischigualastia");
    
    //Henos & Related
	public static final EntityType<TimeGuardianEntity> TIME_GUARDIAN_ENTITY = register(EntityType.Builder.<TimeGuardianEntity>create(TimeGuardianEntity::new, EntityClassification.CREATURE).immuneToFire().size(1.3125F, 3.125F), "henos");
    public static final EntityType<TrilobiteSentinelEntity> TRILOBITE_SENTINEL_ENTITY = register(EntityType.Builder.<TrilobiteSentinelEntity>create(TrilobiteSentinelEntity::new, EntityClassification.MONSTER).immuneToFire().size(1.5F, 0.75F), "trilobite_sentinel");
    public static final EntityType<LandSentinelEntity> LAND_SENTINEL_ENTITY = register(EntityType.Builder.<LandSentinelEntity>create(LandSentinelEntity::new, EntityClassification.MONSTER).immuneToFire().size(2F, 0.75F), "land_sentinel");

    //Skeletons and Skulls
    public static final EntityType<AnkylosaurusSkullEntity> ANKYLOSAURUS_SKULL = register(EntityType.Builder.<AnkylosaurusSkullEntity>create(AnkylosaurusSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "ankylosaurus_skull");
	public static final EntityType<TriceratopsSkullEntity> TRICERATOPS_SKULL = register(EntityType.Builder.<TriceratopsSkullEntity>create(TriceratopsSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "triceratops_skull");
	public static final EntityType<SaurosuchusSkullEntity> SAUROSUCHUS_SKULL = register(EntityType.Builder.<SaurosuchusSkullEntity>create(SaurosuchusSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "saurosuchus_skull");
	public static final EntityType<HerrerasaurusSkullEntity> HERRERASAURUS_SKULL = register(EntityType.Builder.<HerrerasaurusSkullEntity>create(HerrerasaurusSkullEntity::new, EntityClassification.MISC).size(0.6875F, 0.6875F), "herrerasaurus_skull");
	public static final EntityType<StegosaurusSkullEntity> STEGOSAURUS_SKULL = register(EntityType.Builder.<StegosaurusSkullEntity>create(StegosaurusSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "stegosaurus_skull");
	public static final EntityType<CeratosaurusSkullEntity> CERATOSAURUS_SKULL = register(EntityType.Builder.<CeratosaurusSkullEntity>create(CeratosaurusSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "ceratosaurus_skull");
	public static final EntityType<TriceratopsSkeletonEntity> TRICERATOPS_SKELETON = register(EntityType.Builder.<TriceratopsSkeletonEntity>create(TriceratopsSkeletonEntity::new, EntityClassification.MISC).size(2F, 2.6F), "triceratops_skeleton");
	public static final EntityType<AnkylosaurusSkeletonEntity> ANKYLOSAURUS_SKELETON = register(EntityType.Builder.<AnkylosaurusSkeletonEntity>create(AnkylosaurusSkeletonEntity::new, EntityClassification.MISC).size(2F, 2F), "ankylosaurus_skeleton");
	public static final EntityType<CeratosaurusSkeletonEntity> CERATOSAURUS_SKELETON = register(EntityType.Builder.<CeratosaurusSkeletonEntity>create(CeratosaurusSkeletonEntity::new, EntityClassification.MISC).size(0.875F, 2F), "ceratosaurus_skeleton");
	public static final EntityType<HerrerasaurusSkeletonEntity> HERRERASAURUS_SKELETON = register(EntityType.Builder.<HerrerasaurusSkeletonEntity>create(HerrerasaurusSkeletonEntity::new, EntityClassification.MISC).size(0.625F, 1.375F), "herrerasaurus_skeleton");
	public static final EntityType<IschigualastiaSkeletonEntity> ISCHIGUALASTIA_SKELETON = register(EntityType.Builder.<IschigualastiaSkeletonEntity>create(IschigualastiaSkeletonEntity::new, EntityClassification.MISC).size(1.25F, 1.9375F), "ischigualastia_skeleton");
	public static final EntityType<AllosaurusSkeletonEntity> ALLOSAURUS_SKELETON = register(EntityType.Builder.<AllosaurusSkeletonEntity>create(AllosaurusSkeletonEntity::new, EntityClassification.MISC).size(1.25F, 2.8125F), "allosaurus_skeleton");
	public static final EntityType<SaurosuchusSkeletonEntity> SAUROSUCHUS_SKELETON = register(EntityType.Builder.<SaurosuchusSkeletonEntity>create(SaurosuchusSkeletonEntity::new, EntityClassification.MISC).size(0.75F, 1.5F), "saurosuchus_skeleton");
	public static final EntityType<StegosaurusSkeletonEntity> STEGOSAURUS_SKELETON = register(EntityType.Builder.<StegosaurusSkeletonEntity>create(StegosaurusSkeletonEntity::new, EntityClassification.MISC).size(1.5F, 2.6875F), "stegosaurus_skeleton");
	public static final EntityType<AllosaurusSkullEntity> ALLOSAURUS_SKULL = register(EntityType.Builder.<AllosaurusSkullEntity>create(AllosaurusSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "allosaurus_skull");
	public static final EntityType<IschigualastiaSkullEntity> ISCHIGUALASTIA_SKULL = register(EntityType.Builder.<IschigualastiaSkullEntity>create(IschigualastiaSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "ischigualastia_skull");
	public static final EntityType<TyrannosaurusSkullEntity> TYRANNOSAURUS_SKULL = register(EntityType.Builder.<TyrannosaurusSkullEntity>create(TyrannosaurusSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "tyrannosaurus_skull");
	public static final EntityType<TyrannosaurusSkeletonEntity> TYRANNOSAURUS_SKELETON = register(EntityType.Builder.<TyrannosaurusSkeletonEntity>create(TyrannosaurusSkeletonEntity::new, EntityClassification.MISC).size(2F, 3.9F), "tyrannosaurus_skeleton");
	public static final EntityType<VelociraptorSkullEntity> VELOCIRAPTOR_SKULL = register(EntityType.Builder.<VelociraptorSkullEntity>create(VelociraptorSkullEntity::new, EntityClassification.MISC).size(0.4375F, 0.4375F), "velociraptor_skull");
	public static final EntityType<VelociraptorSkeletonEntity> VELOCIRAPTOR_SKELETON = register(EntityType.Builder.<VelociraptorSkeletonEntity>create(VelociraptorSkeletonEntity::new, EntityClassification.MISC).size(1F, 1F), "velociraptor_skeleton");
	public static final EntityType<ProtoceratopsSkullEntity> PROTOCERATOPS_SKULL = register(EntityType.Builder.<ProtoceratopsSkullEntity>create(ProtoceratopsSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "protoceratops_skull");
	public static final EntityType<ProtoceratopsSkeletonEntity> PROTOCERATOPS_SKELETON = register(EntityType.Builder.<ProtoceratopsSkeletonEntity>create(ProtoceratopsSkeletonEntity::new, EntityClassification.MISC).size(0.8125F, 0.8125F), "protoceratops_skeleton");
	public static final EntityType<PostosuchusSkullEntity> POSTOSUCHUS_SKULL = register(EntityType.Builder.<PostosuchusSkullEntity>create(PostosuchusSkullEntity::new, EntityClassification.MISC).size(0.75F, 0.75F), "postosuchus_skull");
	public static final EntityType<PlesiohadrosSkullEntity> PLESIOHADROS_SKULL = register(EntityType.Builder.<PlesiohadrosSkullEntity>create(PlesiohadrosSkullEntity::new, EntityClassification.MISC).size(0.8125F, 0.8125F), "plesiohadros_skull");
	public static final EntityType<ScelidosaurusSkullEntity> SCELIDOSAURUS_SKULL = register(EntityType.Builder.<ScelidosaurusSkullEntity>create(ScelidosaurusSkullEntity::new, EntityClassification.MISC).size(0.5625F, 0.5625F), "scelidosaurus_skull");
	public static final EntityType<CoelophysisSkullEntity> COELOPHYSIS_SKULL = register(EntityType.Builder.<CoelophysisSkullEntity>create(CoelophysisSkullEntity::new, EntityClassification.MISC).size(0.4375F, 0.4375F), "coelophysis_skull");
	public static final EntityType<CoelophysisSkeletonEntity> COELOPHYSIS_SKELETON = register(EntityType.Builder.<CoelophysisSkeletonEntity>create(CoelophysisSkeletonEntity::new, EntityClassification.MISC).size(0.75F, 1.25F), "coelophysis_skeleton");
	public static final EntityType<DilophosaurusSkullEntity> DILOPHOSAURUS_SKULL = register(EntityType.Builder.<DilophosaurusSkullEntity>create(DilophosaurusSkullEntity::new, EntityClassification.MISC).size(0.875F, 0.875F), "dilophosaurus_skull");
	public static final EntityType<DesmatosuchusSkullEntity> DESMATOSUCHUS_SKULL = register(EntityType.Builder.<DesmatosuchusSkullEntity>create(DesmatosuchusSkullEntity::new, EntityClassification.MISC).size(0.4375F, 0.4375F), "desmatosuchus_skull");
	public static final EntityType<PlesiohadrosSkeletonEntity> PLESIOHADROS_SKELETON = register(EntityType.Builder.<PlesiohadrosSkeletonEntity>create(PlesiohadrosSkeletonEntity::new, EntityClassification.MISC).size(1.5F, 2), "plesiohadros_skeleton");
	public static final EntityType<DesmatosuchusSkeletonEntity> DESMATOSUCHUS_SKELETON = register(EntityType.Builder.<DesmatosuchusSkeletonEntity>create(DesmatosuchusSkeletonEntity::new, EntityClassification.MISC).size(1.25F, 1.25F), "desmatosuchus_skeleton");
	public static final EntityType<PostosuchusSkeletonEntity> POSTOSUCHUS_SKELETON = register(EntityType.Builder.<PostosuchusSkeletonEntity>create(PostosuchusSkeletonEntity::new, EntityClassification.MISC).size(1F, 1.5F), "postosuchus_skeleton");
	public static final EntityType<SarahsaurusSkullEntity> SARAHSAURUS_SKULL = register(EntityType.Builder.<SarahsaurusSkullEntity>create(SarahsaurusSkullEntity::new, EntityClassification.MISC).size(0.4375F, 0.4375F), "sarahsaurus_skull");
	public static final EntityType<SarahsaurusSkeletonEntity> SARAHSAURUS_SKELETON = register(EntityType.Builder.<SarahsaurusSkeletonEntity>create(SarahsaurusSkeletonEntity::new, EntityClassification.MISC).size(1, 1.25F), "sarahsaurus_skeleton");
	public static final EntityType<DilophosaurusSkeletonEntity> DILOPHOSAURUS_SKELETON = register(EntityType.Builder.<DilophosaurusSkeletonEntity>create(DilophosaurusSkeletonEntity::new, EntityClassification.MISC).size(1, 2F), "dilophosaurus_skeleton");
	public static final EntityType<ScelidosaurusSkeletonEntity> SCELIDOSAURUS_SKELETON = register(EntityType.Builder.<ScelidosaurusSkeletonEntity>create(ScelidosaurusSkeletonEntity:: new, EntityClassification.MISC).size(1, 1), "scelidosaurus_skeleton");
	//Fish
	public static final EntityType<MyledaphusEntity> MYLEDAPHUS = register(EntityType.Builder.<MyledaphusEntity>create(MyledaphusEntity::new, EntityClassification.WATER_AMBIENT).size(0.6875F, 0.2F), "myledaphus");
	public static final EntityType<GarEntity> GAR = register(EntityType.Builder.<GarEntity>create(GarEntity::new, EntityClassification.WATER_AMBIENT).size(0.6875F, 0.2F), "gar");
	public static final EntityType<CyclurusEntity> CYCLURUS = register(EntityType.Builder.<CyclurusEntity>create(CyclurusEntity::new, EntityClassification.WATER_AMBIENT).size(0.6875F, 0.2F), "cyclurus");
	public static final EntityType<CeratodusEntity> CERATODUS = register(EntityType.Builder.<CeratodusEntity>create(CeratodusEntity::new, EntityClassification.WATER_AMBIENT).size(0.6875F, 0.2F), "ceratodus");
	public static final EntityType<PotamoceratodusEntity> POTAMOCERATODUS = register(EntityType.Builder.<PotamoceratodusEntity>create(PotamoceratodusEntity::new, EntityClassification.WATER_AMBIENT).size(0.6875F, 0.2F), "potamoceratodus");
	
    //Misc
	public static final EntityType<WallFossilEntity> WALL_FOSSIL = register(EntityType.Builder.<WallFossilEntity>create(WallFossilEntity::new, EntityClassification.MISC).size(0.5F, 0.5F), "wall_fossil");
	public static final EntityType<PrehistoricBoatEntity> BOAT = register(EntityType.Builder.<PrehistoricBoatEntity>create(PrehistoricBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F), "boat");
	public static final EntityType<PaleopaintingEntity> PALEOPAINTING = register(EntityType.Builder.<PaleopaintingEntity>create(PaleopaintingEntity::new, EntityClassification.MISC).size(0.5F, 0.5F), "paleopainting");

    private static <T extends Entity> EntityType<T> register(EntityType.Builder<T> builder, String entityName){
        EntityType<T> type = builder.build(entityName);
        ENTITY_TYPES.register(entityName, () -> type);
        return type;
	}
    
    
    
}
