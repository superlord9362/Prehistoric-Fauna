package superlord.prehistoricfauna.entity;



import io.netty.util.internal.ThreadLocalRandom;

import net.minecraft.entity.Entity;

import net.minecraft.entity.monster.EntityPolarBear;

import net.minecraft.entity.passive.*;

import net.minecraft.item.Item;

import net.minecraft.world.World;

import java.util.ArrayList;

import java.util.List;

import java.util.Locale;

import java.util.Random;



public enum EntityType {
	DRYOSAURUS(EntityDryosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE, Parameter.NOTHING, 0x412E23, 0x000000, 0.6F),
	CAMARASAURUS(EntityCamarasaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE, Parameter.HERBIVORE, 0x3C3825, 0x000000, 1.3F),
	STEGOSAURUS(EntityStegosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE, Parameter.HERBIVORE, 0x5C4823, 0x000000, 1.0F),
	ALLOSAURUS(EntityAllosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE, Parameter.CARNIVORE, 0x000000, 0x000000, 0.9F),
	TYRANNOSAURUS(EntityTyrannosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE, Parameter.CARNIVORE, 0x000000, 0x000000, 1.2F),
	VELOCIRAPTOR(EntityVelociraptor.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.CARNIVORE, Parameter.CARNIVORE, 0x000000, 0x000000, 0.6F),
	TRICERATOPS(EntityTriceratops.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE, Parameter.HERBIVORE, 0x000000, 0x0000000, 0.8F),
	GALLIMIMUS(EntityGallimimus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.OMNIVORE, Parameter.NOTHING, 0x000000, 0x000000, 0.9F),
	PARASAUROLOPHUS(EntityParasaurolophus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE, Parameter.HERBIVORE, 0x000000, 0x000000, 1.1F),
	PRENOCEPHALE(EntityPrenocephale.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE, Parameter.HERBIVORE, 0x000000, 0x000000, 0.6F),
	BARYONYX(EntityBaryonyx.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.PISCCARNIVORE, Parameter.CARNIVORE, 0x000000, 0x000000, 1F),
	ANKYLOSAURUS(EntityAnkylosaurus.class, MobType.DINOSAUR, TimePeriod.MESOZOIC, Diet.HERBIVORE, Parameter.HERBIVORE, 0x000000, 0x000000, 1.1F);
	




	private final Class<? extends Entity> entity;

	public final MobType mobType;

	public final Diet diet;

	public final TimePeriod timePeriod;

	public int maximimAge = 999;

	public int adultAge = 6;

	public int teenAge = 3;

	public double minHealth = 20;

	public double maxHealth = 20;

	public double minStrength = 2;

	public double maxStrength = 2;

	public double minSpeed = 0.25D;

	public double maxSpeed = 0.3D;

	public int breedTicks = 3000;

	public int ageTicks = 12000;

	public int maxHunger = 100;

	public float hungerLevel = 0.8f;

	public float experience = 1.0f;

	public float experienceIncrement = 0.2f;

	public int parameters = 0;

	public Item orderItem;

	public Item fishItem;

	public Item foodItem;

	public Item cookedFoodItem;

	public Item dnaItem;

	public Item eggItem;

	public Item embryoItem;

	public Item birdEggItem;

	public Item bestBirdEggItem;

	public final int growTime = 10000;

	public final int primaryEggColor;

	public final int secondaryEggColor;

	public final float eggScale;

	public final String friendlyName;

	public final String resourceName;




    EntityType(Class<? extends Entity> entity, MobType mobType, TimePeriod period, Diet diet, int parameters, int primaryEggColor, int secondaryEggColor) {

		this.entity = entity;

		this.mobType = mobType;

		this.timePeriod = period;

		this.diet = diet;

		this.parameters = parameters;

		this.primaryEggColor = primaryEggColor;

		this.secondaryEggColor = secondaryEggColor;

		this.eggScale = 1;

		this.resourceName = this.name().toLowerCase(Locale.ENGLISH);

		this.friendlyName = this.name().toUpperCase(Locale.ENGLISH).substring(0, 1) + this.resourceName.substring(1);

	}



	EntityType(Class<? extends Entity> entity, MobType mobType, TimePeriod period, Diet diet, int parameters, int primaryEggColor, int secondaryEggColor, float eggScale) {

		this.entity = entity;

		this.mobType = mobType;

		this.timePeriod = period;

		this.diet = diet;

		this.parameters = parameters;

		this.primaryEggColor = primaryEggColor;

		this.secondaryEggColor = secondaryEggColor;

		this.eggScale = eggScale;

		this.resourceName = this.name().toLowerCase(Locale.ENGLISH);

		this.friendlyName = this.name().toUpperCase(Locale.ENGLISH).substring(0, 1) + this.resourceName.substring(1);

	}



	



	public static boolean isDNA(Item item) {

		for (EntityType entity : EntityType.values()) {

			if (entity.dnaItem == item) {

				return true;

			}

		}

		return false;

	}



	public static boolean isDinoEgg(Item item) {

		for (EntityType entity : EntityType.values()) {

			if (entity.mobType == MobType.DINOSAUR || entity.mobType == MobType.DINOSAUR_AQUATIC) {

				if (entity.eggItem == item) {

					return true;

				}

			}

		}

		return false;

	}



	public static boolean isFoodItem(Item item) {

		for (EntityType entity : EntityType.values()) {

			if (entity.foodItem == item) {

				return true;

			}

		}

		return false;

	}



	public static Item getDNA(Item item) {

		for (EntityType entity : EntityType.values()) {

			if (entity.bestBirdEggItem == item || entity.birdEggItem == item || entity.embryoItem == item || entity.foodItem == item || entity.eggItem == item) {

				return entity.dnaItem;

			}

		}

		return null;

	}



	public static boolean isEmbryo(Item item) {

		for (EntityType entity : EntityType.values()) {

			if (entity.mobType == MobType.MAMMAL || entity.mobType == MobType.VANILLA) {

				if (entity.embryoItem == item) {

					return true;

				}

			}

		}

		return false;

	}



	public static boolean isBirdEgg(Item item) {

		for (EntityType entity : EntityType.values()) {

			if (entity.mobType == MobType.BIRD) {

				if (entity.birdEggItem == item) {

					return true;

				}

			}

		}

		return false;

	}



	public static boolean isBestBirdEgg(Item item) {

		for (EntityType entity : EntityType.values()) {

			if (entity.mobType == MobType.BIRD || entity.mobType == MobType.CHICKEN) {

				if (entity.bestBirdEggItem == item) {

					return true;

				}

			}

		}

		return false;

	}



	public static Item getFoodItem(Item item) {

		for (EntityType entity : EntityType.values()) {

			if (entity.bestBirdEggItem == item || entity.birdEggItem == item || entity.embryoItem == item || entity.dnaItem == item || entity.eggItem == item) {

				return entity.foodItem;

			}

		}

		return null;

	}



	public static Item getEgg(Item item) {

		for (EntityType entity : EntityType.values()) {

			if (entity.mobType == MobType.DINOSAUR || entity.mobType == MobType.DINOSAUR_AQUATIC) {

				if (entity.foodItem == item || entity.dnaItem == item) {

					return entity.eggItem;

				}

			}

			if (entity.mobType == MobType.FISH) {

				if (entity.dnaItem == item) {

					return entity.eggItem;

				}

			}

		}

		return null;

	}



	public static Item getEmbryo(Item item) {

		for (EntityType entity : EntityType.values()) {

			if (entity.mobType == MobType.MAMMAL || entity.mobType == MobType.VANILLA) {

				if (entity.dnaItem == item || entity.foodItem == item) {

					return entity.embryoItem;

				}

			}

		}

		return null;

	}



	public static Item getBirdEgg(Item item) {

		for (EntityType entity : EntityType.values()) {

			if (entity.mobType == MobType.BIRD) {

				if (entity.bestBirdEggItem == item || entity.dnaItem == item || entity.foodItem == item) {

					return entity.birdEggItem;

				}

			}

		}

		return null;

	}



	public static Item getBestBirdEgg(Item i0) {

		for (EntityType entity : EntityType.values()) {

			if (entity.mobType == MobType.BIRD || entity.mobType == MobType.CHICKEN) {

				if (entity.birdEggItem == i0 || entity.dnaItem == i0 || entity.foodItem == i0) {

					return entity.bestBirdEggItem;

				}

			}

		}

		return null;

	}



	public static int getIndex(Item item) {

		for (int index = 0; index < values().length; index++) {

			EntityType entity = values()[index];

			if (entity.bestBirdEggItem == item || entity.embryoItem == item || entity.birdEggItem == item || entity.dnaItem == item || entity.foodItem == item || entity.eggItem == item) {

				return index;

			}

		}

		return -1;

	}



	public static EntityType getRandomTimePeriod(Random random, TimePeriod... periods) {

		List<EntityType> mesozoic = new ArrayList<>();

		for (EntityType entity : EntityType.values()) {

			for(TimePeriod period : periods){

				if (entity.timePeriod == period) {

					mesozoic.add(entity);

				}

			}

		}

		int index = mesozoic.size() < 1 ? 0 : random.nextInt(mesozoic.size());

		return mesozoic.get(index);

	}



	public static List<EntityType> getTimePeriodList(TimePeriod... periods) {

		List<EntityType> mesozoic = new ArrayList<>();

		for (EntityType entity : EntityType.values()) {

			for(TimePeriod period : periods){

				if (entity.timePeriod == period) {

					mesozoic.add(entity);

				}

			}

		}

		return mesozoic;

	}



	public static Item getRandomDNA(Random random, TimePeriod period) {

		return EntityType.getRandomTimePeriod(random, period).dnaItem;

	}



	public static EntityType getRandomBioFossil(Random random, boolean tar) {

		List<EntityType> entities = new ArrayList<>();

		for (int i = 0; i < values().length; i++) {

			EntityType type = values()[i];

			if (type.mobType != MobType.VANILLA && type.mobType != MobType.CHICKEN && type.mobType != MobType.FISH) {

				if (tar) {

					if (type.timePeriod == TimePeriod.CENOZOIC && EntityExtinct.class.isAssignableFrom(type.entity)) {

						entities.add(type);

					}

				} else {

					if (type.timePeriod == TimePeriod.MESOZOIC || type.timePeriod == TimePeriod.PALEOZOIC) {

						entities.add(type);

					}

				}

			}

		}

		int index = random.nextInt(entities.size());

		return entities.get(index);

	}



	public static EntityType getRandom() {

		int index = ThreadLocalRandom.current().nextInt(EntityType.values().length);

		return EntityType.values()[index];

	}



	public static int getBones() {

		List<EntityType> bones = new ArrayList<>();

		for (EntityType entity : values()) {

			if (entity.timePeriod != TimePeriod.CURRENT || entity.mobType != MobType.FISH) {

				bones.add(entity);

			}

		}

		return bones.size();

	}





	public Entity invokeClass(World world) {

		Entity entity = null;

		if (Entity.class.isAssignableFrom(this.entity)) {

			try {

				entity = this.entity.getDeclaredConstructor(World.class).newInstance(world);

			} catch (ReflectiveOperationException e) {

				e.printStackTrace();

			}

		}

		return entity;

	}



	public boolean isVivariousAquatic() {

		return this.mobType == MobType.DINOSAUR_AQUATIC;

	}



	public Class<? extends Entity> getEntity() {

		return this.entity;

	}



	public boolean isModelable() {

		return (this.parameters & Parameter.MODEL) != 0;

	}



	public boolean isTameable() {

		return (this.parameters & Parameter.TAME) != 0;

	}



	public boolean isRideable() {

		return (this.parameters & Parameter.RIDE) != 0;

	}



	public boolean canCarryItems() {

		return (this.parameters & Parameter.CARRY) != 0;

	}



	public boolean useFeeder() {

		return this.diet != Diet.NONE && this.diet != Diet.INSECTIVORE && this.diet != Diet.PISCIVORE;

	}



	public boolean isHerbivore() {

		return (this.parameters & Parameter.HERBIVORE) != 0;

	}



	public boolean isCarnivore() {

		return (this.parameters & Parameter.CARNIVORE) != 0;

	}



	public String getFriendlyName() {

		return this.friendlyName;

	}



	public static boolean isMammal(Entity entity) {

		String className = entity.getClass().getSimpleName();

		return entity instanceof AbstractHorse || entity instanceof EntityCow || entity instanceof EntityPig || entity instanceof EntitySheep

				|| entity instanceof EntityRabbit || entity instanceof EntityExtinct && ((EntityExtinct) entity).type.mobType == MobType.MAMMAL

				|| entity instanceof EntityPolarBear || entity instanceof EntityWolf || entity instanceof EntityOcelot || entity instanceof EntityBat

				|| className.contains("Cow") || className.contains("Sheep") || className.contains("Pig") || className.contains("Rabbit")

				|| className.contains("Goat") || className.contains("Ferret") || className.contains("Hedgehog") || className.contains("Sow")

				|| className.contains("Hog");

	}



	

	interface Parameter {

		int NOTHING = 0;



		int NO_FEEDER = 0;// Bits 0+1: Dinos Can't use Feeder at all

		int HERBIVORE = 1;// Bit 0: Dino can use Herbivore Part of Feeder

		int CARNIVORE = 2;// Bit 1: Dino can use Carnivore Part of Feeder

		int HERB_CARN = 3;// Bits 0+1: Dinos can use Herbivore and Carnivore Part of

		// Feeder



		int MODEL = 1 << 2; // Bit 2: Dino is Modelable

		int TAME = 1 << 3; // Bit 3: Dino is Tameable

		int RIDE = 1 << 4; // Bit 4: Dino is Rideable

		int CARRY = 1 << 5; // Bit 5: Dino can Carry Items

	}

}