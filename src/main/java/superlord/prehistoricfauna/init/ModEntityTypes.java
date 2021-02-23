package superlord.prehistoricfauna.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.AllosaurusEntity;
import superlord.prehistoricfauna.entity.AllosaurusSkullEntity;
import superlord.prehistoricfauna.entity.AnkylosaurusEntity;
import superlord.prehistoricfauna.entity.AnkylosaurusSkeletonEntity;
import superlord.prehistoricfauna.entity.AnkylosaurusSkullEntity;
import superlord.prehistoricfauna.entity.BasilemysEntity;
import superlord.prehistoricfauna.entity.CamarasaurusEntity;
import superlord.prehistoricfauna.entity.CeratosaurusEntity;
import superlord.prehistoricfauna.entity.CeratosaurusSkullEntity;
import superlord.prehistoricfauna.entity.ChromogisaurusEntity;
import superlord.prehistoricfauna.entity.DakotaraptorEntity;
import superlord.prehistoricfauna.entity.DidelphodonEntity;
import superlord.prehistoricfauna.entity.DryosaurusEntity;
import superlord.prehistoricfauna.entity.EilenodonEntity;
import superlord.prehistoricfauna.entity.ExaeretodonEntity;
import superlord.prehistoricfauna.entity.HerrerasaurusEntity;
import superlord.prehistoricfauna.entity.HerrerasaurusSkeletonEntity;
import superlord.prehistoricfauna.entity.HerrerasaurusSkullEntity;
import superlord.prehistoricfauna.entity.HesperornithoidesEntity;
import superlord.prehistoricfauna.entity.HyperodapedonEntity;
import superlord.prehistoricfauna.entity.IschigualastiaEntity;
import superlord.prehistoricfauna.entity.IschigualastiaSkullEntity;
import superlord.prehistoricfauna.entity.PrehistoricBoatEntity;
import superlord.prehistoricfauna.entity.SaurosuchusEntity;
import superlord.prehistoricfauna.entity.SaurosuchusSkullEntity;
import superlord.prehistoricfauna.entity.SillosuchusEntity;
import superlord.prehistoricfauna.entity.StegosaurusEntity;
import superlord.prehistoricfauna.entity.StegosaurusSkullEntity;
import superlord.prehistoricfauna.entity.ThescelosaurusEntity;
import superlord.prehistoricfauna.entity.TimeGuardianEntity;
import superlord.prehistoricfauna.entity.TriceratopsEntity;
import superlord.prehistoricfauna.entity.TriceratopsSkeletonEntity;
import superlord.prehistoricfauna.entity.TriceratopsSkullEntity;
import superlord.prehistoricfauna.entity.TyrannosaurusEntity;
import superlord.prehistoricfauna.entity.TyrannosaurusSkeletonEntity;
import superlord.prehistoricfauna.entity.TyrannosaurusSkullEntity;

public class ModEntityTypes {

	public static final EntityType<ThescelosaurusEntity> THESCELOSAURUS_ENTITY = registerEntity(EntityType.Builder.<ThescelosaurusEntity>create(ThescelosaurusEntity::new, EntityClassification.CREATURE).size(0.55F, 1.0F), "thescelosaurus");
	public static final EntityType<TriceratopsEntity> TRICERATOPS_ENTITY = registerEntity(EntityType.Builder.<TriceratopsEntity>create(TriceratopsEntity::new, EntityClassification.CREATURE).size(2F, 2.6F), "triceratops");
	public static final EntityType<AnkylosaurusEntity> ANKYLOSAURUS_ENTITY = registerEntity(EntityType.Builder.<AnkylosaurusEntity>create(AnkylosaurusEntity::new, EntityClassification.CREATURE).size(2F, 2F), "ankylosaurus");
	public static final EntityType<TyrannosaurusEntity> TYRANNOSAURUS_ENTITY = registerEntity(EntityType.Builder.<TyrannosaurusEntity>create(TyrannosaurusEntity::new, EntityClassification.CREATURE).size(2F, 3.9F), "tyrannosaurus");
	public static final EntityType<BasilemysEntity> BASILEMYS_ENTITY = registerEntity(EntityType.Builder.<BasilemysEntity>create(BasilemysEntity::new, EntityClassification.CREATURE).size(0.75F, 0.375F), "basilemys");
	public static final EntityType<DakotaraptorEntity> DAKOTARAPTOR_ENTITY = registerEntity(EntityType.Builder.<DakotaraptorEntity>create(DakotaraptorEntity::new, EntityClassification.CREATURE).size(0.875F, 1.6875F), "dakotaraptor");
	public static final EntityType<PrehistoricBoatEntity> BOAT = register(EntityType.Builder.<PrehistoricBoatEntity>create(PrehistoricBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F), "boat");
	public static final EntityType<AllosaurusEntity> ALLOSAURUS_ENTITY = registerEntity(EntityType.Builder.<AllosaurusEntity>create(AllosaurusEntity::new, EntityClassification.CREATURE).size(1.25F, 2.8125F), "allosaurus");
	public static final EntityType<StegosaurusEntity> STEGOSAURUS_ENTITY = registerEntity(EntityType.Builder.<StegosaurusEntity>create(StegosaurusEntity::new, EntityClassification.CREATURE).size(1.25F, 2.6875F), "stegosaurus");
	public static final EntityType<CeratosaurusEntity> CERATOSAURUS_ENTITY = registerEntity(EntityType.Builder.<CeratosaurusEntity>create(CeratosaurusEntity::new, EntityClassification.CREATURE).size(0.875F, 2F), "ceratosaurus");
	public static final EntityType<DryosaurusEntity> DRYOSAURUS_ENTITY = registerEntity(EntityType.Builder.<DryosaurusEntity>create(DryosaurusEntity::new, EntityClassification.CREATURE).size(0.375F, 1.1875F), "dryosaurus");
	public static final EntityType<HesperornithoidesEntity> HESPERORNITHOIDES_ENTITY = registerEntity(EntityType.Builder.<HesperornithoidesEntity>create(HesperornithoidesEntity::new, EntityClassification.CREATURE).size(0.375F, 0.4375F), "hesperornithoides");
	public static final EntityType<EilenodonEntity> EILENODON_ENTITY = registerEntity(EntityType.Builder.<EilenodonEntity>create(EilenodonEntity::new, EntityClassification.CREATURE).size(0.25F, 0.25F), "eilenodon");
	public static final EntityType<CamarasaurusEntity> CAMARASAURUS_ENTITY = registerEntity(EntityType.Builder.<CamarasaurusEntity>create(CamarasaurusEntity::new, EntityClassification.CREATURE).size(3.125F, 5.3125F), "camarasaurus");
	public static final EntityType<DidelphodonEntity> DIDELPHODON_ENTITY = registerEntity(EntityType.Builder.<DidelphodonEntity>create(DidelphodonEntity::new, EntityClassification.CREATURE).size(0.25F, 0.25F), "didelphodon");
	public static final EntityType<ExaeretodonEntity> EXAERETODON_ENTITY = registerEntity(EntityType.Builder.<ExaeretodonEntity>create(ExaeretodonEntity::new, EntityClassification.CREATURE).size(0.75F, 0.5625F), "exaerertodon");
	public static final EntityType<ChromogisaurusEntity> CHROMOGISAURUS_ENTITY = registerEntity(EntityType.Builder.<ChromogisaurusEntity>create(ChromogisaurusEntity::new, EntityClassification.CREATURE).size(0.375F, 0.625F), "chromogisaurus");
	public static final EntityType<HerrerasaurusEntity> HERRERASAURUS_ENTITY = registerEntity(EntityType.Builder.<HerrerasaurusEntity>create(HerrerasaurusEntity::new, EntityClassification.CREATURE).size(0.625F, 1.375F), "herrerasaurus");
	public static final EntityType<HyperodapedonEntity> HYPERODAPEDON_ENTITY = registerEntity(EntityType.Builder.<HyperodapedonEntity>create(HyperodapedonEntity::new, EntityClassification.CREATURE).size(0.375F, 0.3125F), "hyperodapedon");
	public static final EntityType<SillosuchusEntity> SILLOSUCHUS_ENTITY = registerEntity(EntityType.Builder.<SillosuchusEntity>create(SillosuchusEntity::new, EntityClassification.CREATURE).size(1.0F, 2.3125F), "sillosuchus");
	public static final EntityType<TimeGuardianEntity> TIME_GUARDIAN_ENTITY = registerEntity(EntityType.Builder.<TimeGuardianEntity>create(TimeGuardianEntity::new, EntityClassification.CREATURE).size(1.3125F, 3.125F), "henos");
	public static final EntityType<SaurosuchusEntity> SAUROSUCHUS_ENTITY = registerEntity(EntityType.Builder.<SaurosuchusEntity>create(SaurosuchusEntity::new, EntityClassification.CREATURE).size(0.75F, 1.5F), "saurosuchus");
	public static final EntityType<IschigualastiaEntity> ISCHIGUALASTIA_ENTITY = registerEntity(EntityType.Builder.<IschigualastiaEntity>create(IschigualastiaEntity::new, EntityClassification.CREATURE).size(1.25F, 1.9375F), "ischigualastia");
	public static final EntityType<TyrannosaurusSkullEntity> TYRANNOSAURUS_SKULL = registerEntity(EntityType.Builder.<TyrannosaurusSkullEntity>create(TyrannosaurusSkullEntity::new, EntityClassification.MISC).size(0.5F, 0.5F), "tyrannosaurus_skull");
	public static final EntityType<TyrannosaurusSkeletonEntity> TYRANNOSAURUS_SKELETON = registerEntity(EntityType.Builder.<TyrannosaurusSkeletonEntity>create(TyrannosaurusSkeletonEntity::new, EntityClassification.MISC).size(2F, 3.9F), "tyrannosaurus_skeleton");
	//public static final EntityType<PaleopaintingEntity> PALEOPAINTING = registerEntity(EntityType.Builder.<PaleopaintingEntity>create(PaleopaintingEntity::new, EntityClassification.MISC).size(0.5F, 0.5F), "paleopainting");
	public static final EntityType<AnkylosaurusSkullEntity> ANKYLOSAURUS_SKULL = registerEntity(EntityType.Builder.<AnkylosaurusSkullEntity>create(AnkylosaurusSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "ankylosaurus_skull");
	public static final EntityType<TriceratopsSkullEntity> TRICERATOPS_SKULL = registerEntity (EntityType.Builder.<TriceratopsSkullEntity>create(TriceratopsSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "triceratops_skull");
	public static final EntityType<SaurosuchusSkullEntity> SAUROSUCHUS_SKULL = registerEntity(EntityType.Builder.<SaurosuchusSkullEntity>create(SaurosuchusSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "saurosuchus_skull");
	public static final EntityType<HerrerasaurusSkullEntity> HERRERASAURUS_SKULL = registerEntity(EntityType.Builder.<HerrerasaurusSkullEntity>create(HerrerasaurusSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "herrerasaurus_skull");
	public static final EntityType<StegosaurusSkullEntity> STEGOSAURUS_SKULL = registerEntity(EntityType.Builder.<StegosaurusSkullEntity>create(StegosaurusSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "stegosaurus_skull");
	public static final EntityType<CeratosaurusSkullEntity> CERATOSAURUS_SKULL = registerEntity(EntityType.Builder.<CeratosaurusSkullEntity>create(CeratosaurusSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "ceratosaurus_skull");
	public static final EntityType<TriceratopsSkeletonEntity> TRICERATOPS_SKELETON = registerEntity(EntityType.Builder.<TriceratopsSkeletonEntity>create(TriceratopsSkeletonEntity::new, EntityClassification.MISC).size(1F, 1F), "triceratops_skeleton");
	public static final EntityType<AnkylosaurusSkeletonEntity> ANKYLOSAURUS_SKELETON = registerEntity(EntityType.Builder.<AnkylosaurusSkeletonEntity>create(AnkylosaurusSkeletonEntity::new, EntityClassification.MISC).size(1F, 1F), "ankylosaurus_skeleton");
	public static final EntityType<HerrerasaurusSkeletonEntity> HERRERASAURUS_SKELETON = registerEntity(EntityType.Builder.<HerrerasaurusSkeletonEntity>create(HerrerasaurusSkeletonEntity::new, EntityClassification.MISC).size(1F, 1F), "herrerasaurus_skeleton");
	public static final EntityType<AllosaurusSkullEntity> ALLOSAURUS_SKULL = registerEntity(EntityType.Builder.<AllosaurusSkullEntity>create(AllosaurusSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "allosaurus_skull");
	public static final EntityType<IschigualastiaSkullEntity> ISCHIGUALASTIA_SKULL = registerEntity(EntityType.Builder.<IschigualastiaSkullEntity>create(IschigualastiaSkullEntity::new, EntityClassification.MISC).size(1F, 1F), "ischigualastia_skull");

	@SuppressWarnings("unchecked")
	private static final <T extends Entity> EntityType<T> registerEntity(EntityType.Builder<T> builder, String entityName){
		ResourceLocation nameLoc = new ResourceLocation(PrehistoricFauna.MODID, entityName);
		return (EntityType<T>) builder.build(entityName).setRegistryName(nameLoc);
	}

	@SuppressWarnings("deprecation")
	private static <T extends Entity> EntityType<T> register(EntityType.Builder<T> builder, String key) {
		return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
	}

}
