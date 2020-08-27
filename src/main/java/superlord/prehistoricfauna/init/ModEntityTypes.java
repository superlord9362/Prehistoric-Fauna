package superlord.prehistoricfauna.init;

import net.minecraft.entity.Entity;
//import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
//import net.minecraft.util.registry.Registry;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.AllosaurusEntity;
import superlord.prehistoricfauna.entity.AnkylosaurusEntity;
import superlord.prehistoricfauna.entity.BasilemysEntity;
import superlord.prehistoricfauna.entity.CamarasaurusEntity;
import superlord.prehistoricfauna.entity.CeratosaurusEntity;
import superlord.prehistoricfauna.entity.DakotaraptorEntity;
import superlord.prehistoricfauna.entity.DidelphodonEntity;
import superlord.prehistoricfauna.entity.DryosaurusEntity;
import superlord.prehistoricfauna.entity.EilenodonEntity;
import superlord.prehistoricfauna.entity.HesperornithoidesEntity;
import superlord.prehistoricfauna.entity.PrehistoricBoatEntity;
import superlord.prehistoricfauna.entity.StegosaurusEntity;
//import superlord.prehistoricfauna.entity.PrehistoricBoatEntity;
import superlord.prehistoricfauna.entity.ThescelosaurusEntity;
import superlord.prehistoricfauna.entity.TriceratopsEntity;
import superlord.prehistoricfauna.entity.TyrannosaurusEntity;

public class ModEntityTypes {
	
    @SuppressWarnings("unchecked")
	public static final EntityType<ThescelosaurusEntity> THESCELOSAURUS_ENTITY = registerEntity(EntityType.Builder.create(ThescelosaurusEntity::new, EntityClassification.CREATURE).size(0.55F, 1.0F), "thescelosaurus");
    @SuppressWarnings("unchecked")
	public static final EntityType<TriceratopsEntity> TRICERATOPS_ENTITY = registerEntity(EntityType.Builder.create(TriceratopsEntity::new, EntityClassification.CREATURE).size(2F, 2.6F), "triceratops");
    @SuppressWarnings("unchecked")
    public static final EntityType<AnkylosaurusEntity> ANKYLOSAURUS_ENTITY = registerEntity(EntityType.Builder.create(AnkylosaurusEntity::new, EntityClassification.CREATURE).size(2F, 2F), "ankylosaurus");
    @SuppressWarnings("unchecked")
    public static final EntityType<TyrannosaurusEntity> TYRANNOSAURUS_ENTITY = registerEntity(EntityType.Builder.create(TyrannosaurusEntity::new, EntityClassification.CREATURE).size(2F, 3.9F), "tyrannosaurus");
    @SuppressWarnings("unchecked")
    public static final EntityType<BasilemysEntity> BASILEMYS_ENTITY = registerEntity(EntityType.Builder.create(BasilemysEntity::new, EntityClassification.CREATURE).size(0.75F, 0.375F), "basilemys");
    @SuppressWarnings("unchecked")
    public static final EntityType<DakotaraptorEntity> DAKOTARAPTOR_ENTITY = registerEntity(EntityType.Builder.create(DakotaraptorEntity::new, EntityClassification.CREATURE).size(0.875F, 1.6875F), "dakotaraptor");
    public static final EntityType<PrehistoricBoatEntity> BOAT = register(EntityType.Builder.<PrehistoricBoatEntity>create(PrehistoricBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F), "boat");
    @SuppressWarnings("unchecked")
    public static final EntityType<AllosaurusEntity> ALLOSAURUS_ENTITY = registerEntity(EntityType.Builder.create(AllosaurusEntity::new, EntityClassification.CREATURE).size(1.25F, 2.8125F), "allosaurus");
    @SuppressWarnings("unchecked")
    public static final EntityType<StegosaurusEntity> STEGOSAURUS_ENTITY = registerEntity(EntityType.Builder.create(StegosaurusEntity::new, EntityClassification.CREATURE).size(1.25F, 2.6875F), "stegosaurus");
    @SuppressWarnings("unchecked")
    public static final EntityType<CeratosaurusEntity> CERATOSAURUS_ENTITY = registerEntity(EntityType.Builder.create(CeratosaurusEntity::new, EntityClassification.CREATURE).size(0.875F, 2F), "ceratosaurus");
    @SuppressWarnings("unchecked")
    public static final EntityType<DryosaurusEntity> DRYOSAURUS_ENTITY = registerEntity(EntityType.Builder.create(DryosaurusEntity::new, EntityClassification.CREATURE).size(0.375F, 1.1875F), "dryosaurus");
    @SuppressWarnings("unchecked")
    public static final EntityType<HesperornithoidesEntity> HESPERORNITHOIDES_ENTITY = registerEntity(EntityType.Builder.create(HesperornithoidesEntity::new, EntityClassification.CREATURE).size(0.375F, 0.4375F), "hesperornithoides");
    @SuppressWarnings("unchecked")
    public static final EntityType<EilenodonEntity> EILENODON_ENTITY = registerEntity(EntityType.Builder.create(EilenodonEntity::new, EntityClassification.CREATURE).size(0.25F, 0.25F), "eilenodon");
    @SuppressWarnings("unchecked")
    public static final EntityType<CamarasaurusEntity> CAMARASAURUS_ENTITY = registerEntity(EntityType.Builder.create(CamarasaurusEntity::new, EntityClassification.CREATURE).size(3.125F, 5.3125F), "camarasaurus");
    @SuppressWarnings("unchecked")
    public static final EntityType<DidelphodonEntity> DIDELPHODON_ENTITY = registerEntity(EntityType.Builder.create(DidelphodonEntity::new, EntityClassification.CREATURE).size(0.25F, 0.25F), "didelphodon");
    
    @SuppressWarnings("rawtypes")
	private static final EntityType registerEntity(EntityType.Builder builder, String entityName){
        ResourceLocation nameLoc = new ResourceLocation(PrehistoricFauna.MODID, entityName);
        return (EntityType) builder.build(entityName).setRegistryName(nameLoc);
    }
    
    @SuppressWarnings("deprecation")
	private static <T extends Entity> EntityType<T> register(EntityType.Builder<T> builder, String key) {
    	return Registry.register(Registry.ENTITY_TYPE, key, builder.build(key));
    }
    
}
