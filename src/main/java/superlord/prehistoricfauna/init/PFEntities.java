package superlord.prehistoricfauna.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entities.AepyornithomimusEntity;
import superlord.prehistoricfauna.common.entities.AllosaurusEntity;
import superlord.prehistoricfauna.common.entities.AllosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.AllosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.AnkylosaurusEntity;
import superlord.prehistoricfauna.common.entities.AnkylosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.AnkylosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.BasilemysEntity;
import superlord.prehistoricfauna.common.entities.CamarasaurusEntity;
import superlord.prehistoricfauna.common.entities.CeratodusEntity;
import superlord.prehistoricfauna.common.entities.CeratosaurusEntity;
import superlord.prehistoricfauna.common.entities.CeratosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.CeratosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.ChromogisaurusEntity;
import superlord.prehistoricfauna.common.entities.CitipatiEntity;
import superlord.prehistoricfauna.common.entities.CyclurusEntity;
import superlord.prehistoricfauna.common.entities.DakotaraptorEntity;
import superlord.prehistoricfauna.common.entities.DidelphodonEntity;
import superlord.prehistoricfauna.common.entities.DryosaurusEntity;
import superlord.prehistoricfauna.common.entities.EilenodonEntity;
import superlord.prehistoricfauna.common.entities.ExaeretodonEntity;
import superlord.prehistoricfauna.common.entities.GarEntity;
import superlord.prehistoricfauna.common.entities.HerrerasaurusEntity;
import superlord.prehistoricfauna.common.entities.HerrerasaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.HerrerasaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.HesperornithoidesEntity;
import superlord.prehistoricfauna.common.entities.HyperodapedonEntity;
import superlord.prehistoricfauna.common.entities.IschigualastiaEntity;
import superlord.prehistoricfauna.common.entities.IschigualastiaSkeletonEntity;
import superlord.prehistoricfauna.common.entities.IschigualastiaSkullEntity;
import superlord.prehistoricfauna.common.entities.LandSentinelEntity;
import superlord.prehistoricfauna.common.entities.MyledaphusEntity;
import superlord.prehistoricfauna.common.entities.PaleopaintingEntity;
import superlord.prehistoricfauna.common.entities.PotamoceratodusEntity;
import superlord.prehistoricfauna.common.entities.PrehistoricBoatEntity;
import superlord.prehistoricfauna.common.entities.ProtoceratopsEntity;
import superlord.prehistoricfauna.common.entities.SaurosuchusEntity;
import superlord.prehistoricfauna.common.entities.SaurosuchusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.SaurosuchusSkullEntity;
import superlord.prehistoricfauna.common.entities.SillosuchusEntity;
import superlord.prehistoricfauna.common.entities.StegosaurusEntity;
import superlord.prehistoricfauna.common.entities.StegosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.StegosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.ThescelosaurusEntity;
import superlord.prehistoricfauna.common.entities.TimeGuardianEntity;
import superlord.prehistoricfauna.common.entities.TriceratopsEntity;
import superlord.prehistoricfauna.common.entities.TriceratopsSkeletonEntity;
import superlord.prehistoricfauna.common.entities.TriceratopsSkullEntity;
import superlord.prehistoricfauna.common.entities.TrilobiteSentinelEntity;
import superlord.prehistoricfauna.common.entities.TyrannosaurusEntity;
import superlord.prehistoricfauna.common.entities.TyrannosaurusSkeletonEntity;
import superlord.prehistoricfauna.common.entities.TyrannosaurusSkullEntity;
import superlord.prehistoricfauna.common.entities.VelociraptorEntity;
import superlord.prehistoricfauna.common.entities.WallFossilEntity;

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
	public static final EntityType<DidelphodonEntity> DIDELPHODON_ENTITY = register(EntityType.Builder.<DidelphodonEntity>create(DidelphodonEntity::new, EntityClassification.CREATURE).size(0.25F, 0.25F), "didelphodon");
	//Djadochta
	public static final EntityType<ProtoceratopsEntity> PROTOCERATOPS_ENTITY = register(EntityType.Builder.<ProtoceratopsEntity>create(ProtoceratopsEntity::new, EntityClassification.CREATURE).size(0.4375F, 0.875F), "protoceratops");
	public static final EntityType<VelociraptorEntity> VELOCIRAPTOR_ENTITY = register(EntityType.Builder.<VelociraptorEntity>create(VelociraptorEntity::new, EntityClassification.CREATURE).size(0.3125F, 0.625F), "velociraptor");
	public static final EntityType<CitipatiEntity> CITIPATI_ENTITY = register(EntityType.Builder.<CitipatiEntity>create(CitipatiEntity::new, EntityClassification.CREATURE).size(0.5625F, 1.3125F), "citipati");
	public static final EntityType<AepyornithomimusEntity> AEPYORNITHOMIMUS_ENTITY = register(EntityType.Builder.<AepyornithomimusEntity>create(AepyornithomimusEntity::new, EntityClassification.CREATURE).size(0.9375F, 0.5F), "aepyornithomimus");
	//Jurassic
	//Morrison
	public static final EntityType<AllosaurusEntity> ALLOSAURUS_ENTITY = register(EntityType.Builder.<AllosaurusEntity>create(AllosaurusEntity::new, EntityClassification.CREATURE).size(1.25F, 2.8125F), "allosaurus");
	public static final EntityType<StegosaurusEntity> STEGOSAURUS_ENTITY = register(EntityType.Builder.<StegosaurusEntity>create(StegosaurusEntity::new, EntityClassification.CREATURE).size(1.5F, 2.6875F), "stegosaurus");
	public static final EntityType<CeratosaurusEntity> CERATOSAURUS_ENTITY = register(EntityType.Builder.<CeratosaurusEntity>create(CeratosaurusEntity::new, EntityClassification.CREATURE).size(0.875F, 2F), "ceratosaurus");
	public static final EntityType<DryosaurusEntity> DRYOSAURUS_ENTITY = register(EntityType.Builder.<DryosaurusEntity>create(DryosaurusEntity::new, EntityClassification.CREATURE).size(0.375F, 1.1875F), "dryosaurus");
	public static final EntityType<HesperornithoidesEntity> HESPERORNITHOIDES_ENTITY = register(EntityType.Builder.<HesperornithoidesEntity>create(HesperornithoidesEntity::new, EntityClassification.CREATURE).size(0.375F, 0.4375F), "hesperornithoides");
	public static final EntityType<EilenodonEntity> EILENODON_ENTITY = register(EntityType.Builder.<EilenodonEntity>create(EilenodonEntity::new, EntityClassification.CREATURE).size(0.25F, 0.25F), "eilenodon");
	public static final EntityType<CamarasaurusEntity> CAMARASAURUS_ENTITY = register(EntityType.Builder.<CamarasaurusEntity>create(CamarasaurusEntity::new, EntityClassification.CREATURE).size(3.125F, 5.3125F), "camarasaurus");
	
	//Triassic
	//Ischigualasto
	public static final EntityType<ExaeretodonEntity> EXAERETODON_ENTITY = register(EntityType.Builder.<ExaeretodonEntity>create(ExaeretodonEntity::new, EntityClassification.CREATURE).size(0.75F, 0.5625F), "exaeretodon");
	public static final EntityType<ChromogisaurusEntity> CHROMOGISAURUS_ENTITY = register(EntityType.Builder.<ChromogisaurusEntity>create(ChromogisaurusEntity::new, EntityClassification.CREATURE).size(0.375F, 0.625F), "chromogisaurus");
	public static final EntityType<HerrerasaurusEntity> HERRERASAURUS_ENTITY = register(EntityType.Builder.<HerrerasaurusEntity>create(HerrerasaurusEntity::new, EntityClassification.CREATURE).size(0.625F, 1.375F), "herrerasaurus");
	public static final EntityType<HyperodapedonEntity> HYPERODAPEDON_ENTITY = register(EntityType.Builder.<HyperodapedonEntity>create(HyperodapedonEntity::new, EntityClassification.CREATURE).size(0.375F, 0.3125F), "hyperodapedon");
	public static final EntityType<SillosuchusEntity> SILLOSUCHUS_ENTITY = register(EntityType.Builder.<SillosuchusEntity>create(SillosuchusEntity::new, EntityClassification.CREATURE).size(1.0F, 2.3125F), "sillosuchus");
	public static final EntityType<SaurosuchusEntity> SAUROSUCHUS_ENTITY = register(EntityType.Builder.<SaurosuchusEntity>create(SaurosuchusEntity::new, EntityClassification.CREATURE).size(0.75F, 1.5F), "saurosuchus");
	public static final EntityType<IschigualastiaEntity> ISCHIGUALASTIA_ENTITY = register(EntityType.Builder.<IschigualastiaEntity>create(IschigualastiaEntity::new, EntityClassification.CREATURE).size(1.25F, 1.9375F), "ischigualastia");
    
    //Henos & Related
	public static final EntityType<TimeGuardianEntity> TIME_GUARDIAN_ENTITY = register(EntityType.Builder.<TimeGuardianEntity>create(TimeGuardianEntity::new, EntityClassification.CREATURE).immuneToFire().size(1.3125F, 3.125F), "henos");
    public static final EntityType<TrilobiteSentinelEntity> TRILOBITE_SENTINEL_ENTITY = register(EntityType.Builder.<TrilobiteSentinelEntity>create(TrilobiteSentinelEntity::new, EntityClassification.MONSTER).immuneToFire().size(1.25F, 0.375F), "trilobite_sentinel");
    public static final EntityType<LandSentinelEntity> LAND_SENTINEL_ENTITY = register(EntityType.Builder.<LandSentinelEntity>create(LandSentinelEntity::new, EntityClassification.MONSTER).immuneToFire().size(0.875F, 0.4375F), "land_sentinel");

    //Skeletons and Skulls
    public static final EntityType<AnkylosaurusSkullEntity> ANKYLOSAURUS_SKULL = register(EntityType.Builder.<AnkylosaurusSkullEntity>create(AnkylosaurusSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "ankylosaurus_skull");
	public static final EntityType<TriceratopsSkullEntity> TRICERATOPS_SKULL = register(EntityType.Builder.<TriceratopsSkullEntity>create(TriceratopsSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "triceratops_skull");
	public static final EntityType<SaurosuchusSkullEntity> SAUROSUCHUS_SKULL = register(EntityType.Builder.<SaurosuchusSkullEntity>create(SaurosuchusSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "saurosuchus_skull");
	public static final EntityType<HerrerasaurusSkullEntity> HERRERASAURUS_SKULL = register(EntityType.Builder.<HerrerasaurusSkullEntity>create(HerrerasaurusSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "herrerasaurus_skull");
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

	//Fish
	public static final EntityType<MyledaphusEntity> MYLEDAPHUS = register(EntityType.Builder.<MyledaphusEntity>create(MyledaphusEntity::new, EntityClassification.WATER_AMBIENT).size(0.6875F, 0.0625F), "myledaphus");
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
