package superlord.prehistoricfauna.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entities.*;

public class PFEntities {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, PrehistoricFauna.MOD_ID);
	public static final EntityType<ThescelosaurusEntity> THESCELOSAURUS_ENTITY = register(EntityType.Builder.<ThescelosaurusEntity>create(ThescelosaurusEntity::new, EntityClassification.CREATURE).size(0.55F, 1.0F), "thescelosaurus");
	public static final EntityType<TriceratopsEntity> TRICERATOPS_ENTITY = register(EntityType.Builder.<TriceratopsEntity>create(TriceratopsEntity::new, EntityClassification.CREATURE).size(2F, 2.6F), "triceratops");
	public static final EntityType<AnkylosaurusEntity> ANKYLOSAURUS_ENTITY = register(EntityType.Builder.<AnkylosaurusEntity>create(AnkylosaurusEntity::new, EntityClassification.CREATURE).size(2F, 2F), "ankylosaurus");
	public static final EntityType<TyrannosaurusEntity> TYRANNOSAURUS_ENTITY = register(EntityType.Builder.<TyrannosaurusEntity>create(TyrannosaurusEntity::new, EntityClassification.CREATURE).size(2F, 3.9F), "tyrannosaurus");
	public static final EntityType<BasilemysEntity> BASILEMYS_ENTITY = register(EntityType.Builder.<BasilemysEntity>create(BasilemysEntity::new, EntityClassification.CREATURE).size(0.75F, 0.375F), "basilemys");
	public static final EntityType<DakotaraptorEntity> DAKOTARAPTOR_ENTITY = register(EntityType.Builder.<DakotaraptorEntity>create(DakotaraptorEntity::new, EntityClassification.CREATURE).size(0.875F, 1.6875F), "dakotaraptor");
	public static final EntityType<PrehistoricBoatEntity> BOAT = register(EntityType.Builder.<PrehistoricBoatEntity>create(PrehistoricBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F), "boat");
	public static final EntityType<AllosaurusEntity> ALLOSAURUS_ENTITY = register(EntityType.Builder.<AllosaurusEntity>create(AllosaurusEntity::new, EntityClassification.CREATURE).size(1.25F, 2.8125F), "allosaurus");
	public static final EntityType<StegosaurusEntity> STEGOSAURUS_ENTITY = register(EntityType.Builder.<StegosaurusEntity>create(StegosaurusEntity::new, EntityClassification.CREATURE).size(1.5F, 2.6875F), "stegosaurus");
	public static final EntityType<CeratosaurusEntity> CERATOSAURUS_ENTITY = register(EntityType.Builder.<CeratosaurusEntity>create(CeratosaurusEntity::new, EntityClassification.CREATURE).size(0.875F, 2F), "ceratosaurus");
	public static final EntityType<DryosaurusEntity> DRYOSAURUS_ENTITY = register(EntityType.Builder.<DryosaurusEntity>create(DryosaurusEntity::new, EntityClassification.CREATURE).size(0.375F, 1.1875F), "dryosaurus");
	public static final EntityType<HesperornithoidesEntity> HESPERORNITHOIDES_ENTITY = register(EntityType.Builder.<HesperornithoidesEntity>create(HesperornithoidesEntity::new, EntityClassification.CREATURE).size(0.375F, 0.4375F), "hesperornithoides");
	public static final EntityType<EilenodonEntity> EILENODON_ENTITY = register(EntityType.Builder.<EilenodonEntity>create(EilenodonEntity::new, EntityClassification.CREATURE).size(0.25F, 0.25F), "eilenodon");
	public static final EntityType<CamarasaurusEntity> CAMARASAURUS_ENTITY = register(EntityType.Builder.<CamarasaurusEntity>create(CamarasaurusEntity::new, EntityClassification.CREATURE).size(3.125F, 5.3125F), "camarasaurus");
	public static final EntityType<DidelphodonEntity> DIDELPHODON_ENTITY = register(EntityType.Builder.<DidelphodonEntity>create(DidelphodonEntity::new, EntityClassification.CREATURE).size(0.25F, 0.25F), "didelphodon");
	public static final EntityType<ExaeretodonEntity> EXAERETODON_ENTITY = register(EntityType.Builder.<ExaeretodonEntity>create(ExaeretodonEntity::new, EntityClassification.CREATURE).size(0.75F, 0.5625F), "exaeretodon");
	public static final EntityType<ChromogisaurusEntity> CHROMOGISAURUS_ENTITY = register(EntityType.Builder.<ChromogisaurusEntity>create(ChromogisaurusEntity::new, EntityClassification.CREATURE).size(0.375F, 0.625F), "chromogisaurus");
	public static final EntityType<HerrerasaurusEntity> HERRERASAURUS_ENTITY = register(EntityType.Builder.<HerrerasaurusEntity>create(HerrerasaurusEntity::new, EntityClassification.CREATURE).size(0.625F, 1.375F), "herrerasaurus");
	public static final EntityType<HyperodapedonEntity> HYPERODAPEDON_ENTITY = register(EntityType.Builder.<HyperodapedonEntity>create(HyperodapedonEntity::new, EntityClassification.CREATURE).size(0.375F, 0.3125F), "hyperodapedon");
	public static final EntityType<SillosuchusEntity> SILLOSUCHUS_ENTITY = register(EntityType.Builder.<SillosuchusEntity>create(SillosuchusEntity::new, EntityClassification.CREATURE).size(1.0F, 2.3125F), "sillosuchus");
	public static final EntityType<TimeGuardianEntity> TIME_GUARDIAN_ENTITY = register(EntityType.Builder.<TimeGuardianEntity>create(TimeGuardianEntity::new, EntityClassification.CREATURE).immuneToFire().size(1.3125F, 3.125F), "henos");
	public static final EntityType<SaurosuchusEntity> SAUROSUCHUS_ENTITY = register(EntityType.Builder.<SaurosuchusEntity>create(SaurosuchusEntity::new, EntityClassification.CREATURE).size(0.75F, 1.5F), "saurosuchus");
	public static final EntityType<IschigualastiaEntity> ISCHIGUALASTIA_ENTITY = register(EntityType.Builder.<IschigualastiaEntity>create(IschigualastiaEntity::new, EntityClassification.CREATURE).size(1.25F, 1.9375F), "ischigualastia");
	public static final EntityType<TyrannosaurusSkullEntity> TYRANNOSAURUS_SKULL = register(EntityType.Builder.<TyrannosaurusSkullEntity>create(TyrannosaurusSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "tyrannosaurus_skull");
	public static final EntityType<TyrannosaurusSkeletonEntity> TYRANNOSAURUS_SKELETON = register(EntityType.Builder.<TyrannosaurusSkeletonEntity>create(TyrannosaurusSkeletonEntity::new, EntityClassification.MISC).size(2F, 3.9F), "tyrannosaurus_skeleton");
	public static final EntityType<PaleopaintingEntity> PALEOPAINTING = register(EntityType.Builder.<PaleopaintingEntity>create(PaleopaintingEntity::new, EntityClassification.MISC).size(0.5F, 0.5F), "paleopainting");
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
    public static final EntityType<WallFossilEntity> WALL_FOSSIL = register(EntityType.Builder.<WallFossilEntity>create(WallFossilEntity::new, EntityClassification.MISC).size(0.5F, 0.5F), "wall_fossil");

	private static <T extends Entity> EntityType<T> register(EntityType.Builder<T> builder, String entityName){
        EntityType<T> type = builder.build(entityName);
        ENTITY_TYPES.register(entityName, () -> type);
        return type;
	}

}
