package superlord.prehistoricfauna.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.EntityAnkylosaurus;
import superlord.prehistoricfauna.entity.EntityThescelosaurus;
import superlord.prehistoricfauna.entity.EntityTriceratops;
import superlord.prehistoricfauna.entity.EntityTyrannosaurus;
import superlord.prehistoricfauna.entity.PrehistoricBoatEntity;

public class ModEntityTypes {
	
    @SuppressWarnings("unchecked")
	public static final EntityType<EntityThescelosaurus> ENTITY_THESCELOSAURUS = registerEntity(EntityType.Builder.create(EntityThescelosaurus::new, EntityClassification.CREATURE).size(0.55F, 1.0F), "thescelosaurus");
    @SuppressWarnings("unchecked")
	public static final EntityType<EntityTriceratops> ENTITY_TRICERATOPS = registerEntity(EntityType.Builder.create(EntityTriceratops::new, EntityClassification.CREATURE).size(2F, 2.6F), "triceratops");
    public static final EntityType<PrehistoricBoatEntity> BOAT = register(EntityType.Builder.<PrehistoricBoatEntity>create(PrehistoricBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F), "boat");
    @SuppressWarnings("unchecked")
    public static final EntityType<EntityAnkylosaurus> ENTITY_ANKYLOSAURUS = registerEntity(EntityType.Builder.create(EntityAnkylosaurus::new, EntityClassification.CREATURE).size(2F, 2F), "ankylosaurus");
    @SuppressWarnings("unchecked")
    public static final EntityType<EntityTyrannosaurus> ENTITY_TYRANNOSAURUS = registerEntity(EntityType.Builder.create(EntityTyrannosaurus::new, EntityClassification.CREATURE).size(2F, 3.9F), "tyrannosaurus");
    
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
