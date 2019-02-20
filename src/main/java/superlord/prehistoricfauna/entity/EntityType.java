package superlord.prehistoricfauna.entity;

import net.minecraft.entity.Entity;

public enum EntityType {
	TYRANNOSAURUS(EntityTyrannosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE),
	TRICERATOPS(EntityTriceratops.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE),
	VELOCIRAPTOR(EntityVelociraptor.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE),
	GALLIMIMUS(EntityGallimimus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.OMNIVORE),
	DRYOSAURUS(EntityDryosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE);
	
	
	private final Class<? extends Entity> entity;
	public MobType type;
	public Diet diet;
	public TimePeriod period;
	
	EntityType(Class <? extends Entity> entity, MobType type, TimePeriod period, Diet diet) {
		this.entity = entity;
		this.type = type;
		this.period = period;
		this.diet = diet;
	}
}
