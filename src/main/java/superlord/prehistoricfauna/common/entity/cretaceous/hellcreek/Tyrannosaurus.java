package superlord.prehistoricfauna.common.entity.cretaceous.hellcreek;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Aepyornithomimus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Citipati;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Pinacosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Plesiohadros;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Protoceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Telmasaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Velociraptor;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Kayentatherium;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Megapnosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Sarahsaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Scelidosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Scutellosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
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
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEffects;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Tyrannosaurus extends DinosaurEntity {
	private static final EntityDataAccessor<Boolean> HAS_EGG = SynchedEntityData.defineId(Tyrannosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_DIGGING = SynchedEntityData.defineId(Tyrannosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_JUVENILE = SynchedEntityData.defineId(Tyrannosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALBINO = SynchedEntityData.defineId(Tyrannosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MELANISTIC = SynchedEntityData.defineId(Tyrannosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_LOVE = SynchedEntityData.defineId(Tyrannosaurus.class, EntityDataSerializers.BOOLEAN);
	private int currentHunger = 250;
	private int maxHunger = 250;
	private int lastInLove = 0;
	int hungerTick = 0;
	private int warningSoundTicks;
	private int isDigging;
	public int attackTick = 0;
	int loveTick = 0;
	private Goal panicGoal;

	@SuppressWarnings("deprecation")
	public Tyrannosaurus(EntityType<? extends Tyrannosaurus> type, Level worldIn) {
		super(type, worldIn);
		this.maxUpStep = 1.0F;
	}

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isJuvenile()) {
			return 1.4F;
		} else if (this.isJuvenile()) {
			return 2.8F;
		} else return 4.0F;
	}

	public boolean isDigging() {
		return this.entityData.get(IS_DIGGING);
	}

	private void setDigging(boolean isDigging) {
		this.isDigging = isDigging ? 1 : 0;
		this.entityData.set(IS_DIGGING, isDigging);
	}

	public boolean hasEgg() {
		return this.entityData.get(HAS_EGG);
	}

	private void setHasEgg(boolean hasEgg) {
		this.entityData.set(HAS_EGG, hasEgg);
	}

	public boolean isJuvenile() {
		return this.entityData.get(IS_JUVENILE);
	}

	private void setJuvenile(boolean isJuvenile) {
		this.entityData.set(IS_JUVENILE, isJuvenile);
	}

	public boolean isAlbino() {
		return this.entityData.get(ALBINO);
	}

	private void setAlbino(boolean isAlbino) {
		this.entityData.set(ALBINO, isAlbino);
	}

	public boolean isMelanistic() {
		return this.entityData.get(MELANISTIC);
	}

	private void setMelanistic(boolean isMelanistic) {
		this.entityData.set(MELANISTIC, isMelanistic);
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_LARGE_MARGINOCEPHALIAN_MEAT.get();
	}

	public boolean isInLoveNaturally() {
		return this.entityData.get(NATURAL_LOVE);
	}

	private void setInLoveNaturally(boolean isInLoveNaturally) {
		this.entityData.set(NATURAL_LOVE, isInLoveNaturally);
	}

	public int getCurrentHunger() {
		return this.currentHunger;
	}

	private void setHunger(int currentHunger) {
		this.currentHunger = currentHunger;
	}

	public int getHalfHunger() {
		return maxHunger / 2;
	}

	public int getThreeQuartersHunger() {
		return (maxHunger / 4) * 3;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void registerGoals() {
		super.registerGoals();

		panicGoal = new Tyrannosaurus.PanicGoal();
		this.goalSelector.addGoal(1, panicGoal);
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(4, new Tyrannosaurus.TyrannosaurusFollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Ankylosaurus.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(1, new Tyrannosaurus.MeleeAttackGoal());
		this.targetSelector.addGoal(1, new Tyrannosaurus.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Tyrannosaurus.AttackPlayerGoal(this));
		this.targetSelector.addGoal(2, new Tyrannosaurus.TerritoryAttackGoal());
		this.goalSelector.addGoal(0, new Tyrannosaurus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Tyrannosaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Tyrannosaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.targetSelector.addGoal(1, new JuvenileHuntGoal(this, Animal.class, 10, true, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof Aepyornithomimus || p_213487_0_ instanceof Basilemys || p_213487_0_ instanceof Chromogisaurus || p_213487_0_ instanceof Citipati || p_213487_0_ instanceof Didelphodon || p_213487_0_ instanceof Dryosaurus || p_213487_0_ instanceof Eilenodon || p_213487_0_ instanceof Exaeretodon || p_213487_0_ instanceof Herrerasaurus || p_213487_0_ instanceof Hesperornithoides || p_213487_0_ instanceof Hyperodapedon || p_213487_0_ instanceof Protoceratops || p_213487_0_ instanceof Telmasaurus || p_213487_0_ instanceof Thescelosaurus || p_213487_0_ instanceof Velociraptor || p_213487_0_ instanceof Cat || p_213487_0_ instanceof Ocelot || p_213487_0_ instanceof Chicken || p_213487_0_ instanceof Cow || p_213487_0_ instanceof AbstractHorse || p_213487_0_ instanceof Fox || p_213487_0_ instanceof MushroomCow || p_213487_0_ instanceof Pig || p_213487_0_ instanceof Parrot || p_213487_0_ instanceof Rabbit || p_213487_0_ instanceof AbstractVillager || p_213487_0_ instanceof WanderingTrader || p_213487_0_ instanceof AbstractIllager || p_213487_0_ instanceof Player || p_213487_0_ instanceof Llama || p_213487_0_ instanceof Turtle || p_213487_0_ instanceof Sarahsaurus || p_213487_0_ instanceof Scelidosaurus || p_213487_0_ instanceof Megapnosaurus || p_213487_0_ instanceof Kayentatherium || p_213487_0_ instanceof Scutellosaurus || p_213487_0_ instanceof Sheep || p_213487_0_ instanceof Coelophysis || p_213487_0_ instanceof Desmatosuchus || p_213487_0_ instanceof Placerias || p_213487_0_ instanceof Typothorax || p_213487_0_ instanceof Trilophosaurus;
		}));
		this.targetSelector.addGoal(1, new HuntGoal(this, Animal.class, 10, true, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof Aepyornithomimus || p_213487_0_ instanceof Ankylosaurus || p_213487_0_ instanceof Citipati || p_213487_0_ instanceof Dakotaraptor || p_213487_0_ instanceof Dryosaurus || p_213487_0_ instanceof Herrerasaurus || p_213487_0_ instanceof Ischigualastia || p_213487_0_ instanceof Pinacosaurus || p_213487_0_ instanceof Plesiohadros || p_213487_0_ instanceof Protoceratops || p_213487_0_ instanceof Saurosuchus || p_213487_0_ instanceof Sillosuchus || p_213487_0_ instanceof Stegosaurus || p_213487_0_ instanceof Thescelosaurus || p_213487_0_ instanceof Triceratops || p_213487_0_ instanceof Cat || p_213487_0_ instanceof Ocelot || p_213487_0_ instanceof Cow || p_213487_0_ instanceof AbstractHorse || p_213487_0_ instanceof Fox || p_213487_0_ instanceof MushroomCow || p_213487_0_ instanceof Pig || p_213487_0_ instanceof AbstractVillager || p_213487_0_ instanceof WanderingTrader || p_213487_0_ instanceof AbstractIllager || p_213487_0_ instanceof Llama || p_213487_0_ instanceof Panda || p_213487_0_ instanceof PolarBear || p_213487_0_ instanceof Turtle || p_213487_0_ instanceof Player || p_213487_0_ instanceof Ceratosaurus || p_213487_0_ instanceof Allosaurus || p_213487_0_ instanceof Dilophosaurus || p_213487_0_ instanceof Sarahsaurus || p_213487_0_ instanceof Scelidosaurus || p_213487_0_ instanceof Coelophysis || p_213487_0_ instanceof Desmatosuchus || p_213487_0_ instanceof Placerias || p_213487_0_ instanceof Poposaurus || p_213487_0_ instanceof Postosuchus || p_213487_0_ instanceof Typothorax || p_213487_0_ instanceof Trilophosaurus;
		}));
		this.targetSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof Aepyornithomimus || p_213487_0_ instanceof Ankylosaurus || p_213487_0_ instanceof Citipati || p_213487_0_ instanceof Dakotaraptor || p_213487_0_ instanceof Dryosaurus || p_213487_0_ instanceof Herrerasaurus || p_213487_0_ instanceof Ischigualastia || p_213487_0_ instanceof Pinacosaurus || p_213487_0_ instanceof Plesiohadros || p_213487_0_ instanceof Protoceratops || p_213487_0_ instanceof Saurosuchus || p_213487_0_ instanceof Sillosuchus || p_213487_0_ instanceof Stegosaurus || p_213487_0_ instanceof Thescelosaurus || p_213487_0_ instanceof Triceratops || p_213487_0_ instanceof Cat || p_213487_0_ instanceof Ocelot || p_213487_0_ instanceof Cow || p_213487_0_ instanceof AbstractHorse || p_213487_0_ instanceof Fox || p_213487_0_ instanceof MushroomCow || p_213487_0_ instanceof Pig || p_213487_0_ instanceof AbstractVillager || p_213487_0_ instanceof WanderingTrader || p_213487_0_ instanceof AbstractIllager || p_213487_0_ instanceof Llama || p_213487_0_ instanceof Panda || p_213487_0_ instanceof PolarBear || p_213487_0_ instanceof Turtle || p_213487_0_ instanceof Player || p_213487_0_ instanceof Ceratosaurus || p_213487_0_ instanceof Allosaurus || p_213487_0_ instanceof Dilophosaurus || p_213487_0_ instanceof Sarahsaurus || p_213487_0_ instanceof Scelidosaurus || p_213487_0_ instanceof Coelophysis || p_213487_0_ instanceof Desmatosuchus || p_213487_0_ instanceof Placerias || p_213487_0_ instanceof Poposaurus || p_213487_0_ instanceof Postosuchus || p_213487_0_ instanceof Typothorax || p_213487_0_ instanceof Trilophosaurus;
		}));
		this.targetSelector.addGoal(0, new JuvenileCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof Aepyornithomimus || p_213487_0_ instanceof Basilemys || p_213487_0_ instanceof Chromogisaurus || p_213487_0_ instanceof Citipati || p_213487_0_ instanceof Didelphodon || p_213487_0_ instanceof Dryosaurus || p_213487_0_ instanceof Eilenodon || p_213487_0_ instanceof Exaeretodon || p_213487_0_ instanceof Herrerasaurus || p_213487_0_ instanceof Hesperornithoides || p_213487_0_ instanceof Hyperodapedon || p_213487_0_ instanceof Protoceratops || p_213487_0_ instanceof Telmasaurus || p_213487_0_ instanceof Thescelosaurus || p_213487_0_ instanceof Velociraptor || p_213487_0_ instanceof Cat || p_213487_0_ instanceof Ocelot || p_213487_0_ instanceof Chicken || p_213487_0_ instanceof Cow || p_213487_0_ instanceof AbstractHorse || p_213487_0_ instanceof Fox || p_213487_0_ instanceof MushroomCow || p_213487_0_ instanceof Pig || p_213487_0_ instanceof Parrot || p_213487_0_ instanceof Rabbit || p_213487_0_ instanceof AbstractVillager || p_213487_0_ instanceof WanderingTrader || p_213487_0_ instanceof AbstractIllager || p_213487_0_ instanceof Player || p_213487_0_ instanceof Llama || p_213487_0_ instanceof Turtle || p_213487_0_ instanceof Sarahsaurus || p_213487_0_ instanceof Scelidosaurus || p_213487_0_ instanceof Megapnosaurus || p_213487_0_ instanceof Kayentatherium || p_213487_0_ instanceof Scutellosaurus || p_213487_0_ instanceof Sheep || p_213487_0_ instanceof Coelophysis || p_213487_0_ instanceof Desmatosuchus || p_213487_0_ instanceof Placerias || p_213487_0_ instanceof Typothorax || p_213487_0_ instanceof Trilophosaurus;
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof Didelphodon || p_213487_1_ instanceof Eilenodon || p_213487_1_ instanceof Hyperodapedon || p_213487_1_ instanceof Telmasaurus || p_213487_1_ instanceof Rabbit || p_213487_1_ instanceof Chicken || p_213487_1_ instanceof Hesperornithoides || p_213487_1_ instanceof Scutellosaurus;
		}));
	}

	public void aiStep() {
		super.aiStep();
		if (this.isBaby() && !this.isJuvenile()) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(25.0D);
		} else if (this.isJuvenile()) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(50.0D);
		} else {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(100.0D);
		}
		if (this.isAsleep()) {
			this.navigation.setSpeedModifier(0);;
		}
		if (!this.isNoAi()) {
			List<? extends Tyrannosaurus> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
			if (PrehistoricFaunaConfig.advancedHunger) {
				hungerTick++;
				if (hungerTick == 600 && !this.isBaby() || hungerTick == 300 && this.isBaby() && !this.isJuvenile() || hungerTick == 450 && this.isJuvenile()) {
					if (!this.isAsleep()) {
						if (currentHunger != 0) {
							this.setHunger(currentHunger - 1);
						}
						if (currentHunger == 0 && PrehistoricFaunaConfig.hungerDamage == true && this.getHealth() > (this.getMaxHealth() / 2)) {
							this.hurt(DamageSource.STARVE, 1);
						}
						if (currentHunger == 0 && PrehistoricFaunaConfig.hungerDamage == true && level.getDifficulty() == Difficulty.HARD && this.getHealth() <= (this.getMaxHealth() / 2)) {
							this.hurt(DamageSource.STARVE, 1);
						}
					}
					hungerTick = 0;
				}
				if (this.getCurrentHunger() >= this.getThreeQuartersHunger() && hungerTick % 150 == 0) {
					if (this.getHealth() < this.getMaxHealth() && this.getHealth() != 0 && this.getTarget() == null && this.getLastHurtByMob() == null) {
						float currentHealth = this.getHealth();
						this.setHealth(currentHealth + 1);
					}
				}
				if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
					if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && tickCount % 900 == 0 && !this.isBaby() && !this.isInLove() && !this.isAsleep() && list.size() < 3) {
						loveTick = 600;
						this.setInLoveNaturally(true);
						this.setInLoveTime(600);
						lastInLove = 28800;
					}
					if (loveTick != 0) {
						loveTick--;
					} else {
						this.setInLoveNaturally(false);
					}
				}
			} else if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
				int naturalBreedingChance = random.nextInt(1000);
				if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isBaby() && !this.isInLove() && !this.isAsleep() && list.size() < 3) {
					loveTick = 600;
					this.setInLoveNaturally(true);
					this.setInLoveTime(600);
					lastInLove = 28800;
				}
				if (loveTick != 0) {
					loveTick--;
				} else {
					this.setInLoveNaturally(false);
				}
			}
			if (lastInLove != 0) {
				lastInLove--;
			}
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0D).add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.MOVEMENT_SPEED, 0.3D).add(Attributes.ATTACK_DAMAGE, 14.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.75D);
	}

	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -12000 && this.getAge() < 0) {
			this.setJuvenile(true);
		} else if(this.getAge() >= 0) {
			this.setJuvenile(false);
		}
	}

	protected SoundEvent getAmbientSound() {
		if (this.isAsleep() ) {
			if (!this.isBaby()) {
				return PFSounds.TYRANNOSAURUS_SNORES;
			} else return null;
		} else return PFSounds.TYRANNOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.TYRANNOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.TYRANNOSAURUS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.TYRANNOSAURUS_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(HAS_EGG, false);
		this.entityData.define(IS_DIGGING, false);
		this.entityData.define(IS_JUVENILE, false);
		this.entityData.define(ALBINO, false);
		this.entityData.define(MELANISTIC, false);
		this.entityData.define(NATURAL_LOVE, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("inNaturalLove", this.isInLoveNaturally());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setHunger(compound.getInt("MaxHunger"));
		this.setInLoveNaturally(compound.getBoolean("InNaturalLove"));
	}

	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		Random random = new Random();
		int birthNumber = random.nextInt(799);
		if (birthNumber >= 0 && birthNumber < 4) {
			this.setAlbino(true);
		} else if (birthNumber >= 4 && birthNumber < 7) {
			this.setMelanistic(true);
		}
		this.setHunger(this.maxHunger);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
			((LivingEntity)entityIn).addEffect(new MobEffectInstance(PFEffects.BLEEDING.get(), 300, 0, true, false));
		}

		return flag;
	}	

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		Tyrannosaurus tyrannosaurus;
		public AttackPlayerGoal(Tyrannosaurus tyrannosaurus) {
			super(Tyrannosaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
			this.tyrannosaurus = tyrannosaurus;
		}

		public boolean canUse() {
			if (Tyrannosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Tyrannosaurus tyrannosaurus : Tyrannosaurus.this.level.getEntitiesOfClass(Tyrannosaurus.class, Tyrannosaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (tyrannosaurus.isBaby()) {
							return true;
						}
					}
				}

				return false;
			}
		}

		protected double getFollowDistance() {
			return super.getFollowDistance() * 0.5D;
		}
	}

	class HurtByTargetGoal extends net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(Tyrannosaurus.this);
		}

		public void start() {
			super.start();
			if (Tyrannosaurus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}

		}

		protected void alertOther(Mob mobIn, LivingEntity targetIn) {
			if (mobIn instanceof Tyrannosaurus && !mobIn.isBaby()) {
				super.alertOther(mobIn, targetIn);
			}

		}
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Tyrannosaurus.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				Tyrannosaurus.this.playSound(PFSounds.TYRANNOSAURUS_BITE, 1.0F, Tyrannosaurus.this.getVoicePitch());
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}

				if (this.getTicksUntilNextAttack() <= 10) {
					Tyrannosaurus.this.playWarningSound();
				}
			} else {
				this.resetAttackCooldown();
			}

		}

		public boolean canContinueToUse() {
			return super.canContinueToUse();
		}

		public void stop() {
			super.stop();
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(15.0F + attackTarget.getBbWidth());
		}
	}

	class PanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(Tyrannosaurus.this, 2.0D);
		}

		public boolean canUse() {
			if (!Tyrannosaurus.this.isBaby() && !Tyrannosaurus.this.isOnFire()) {
				return false;
			} else if (Tyrannosaurus.this.isJuvenile() && !Tyrannosaurus.this.isOnFire()) {
				return false;
			} else {
				return super.canUse();
			}
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Tyrannosaurus tyrannosaurus;

		LayEggGoal(Tyrannosaurus tyrannosaurus, double speedIn) {
			super(tyrannosaurus, speedIn, 16);
			this.tyrannosaurus = tyrannosaurus;
		}

		public boolean canUse() {
			return this.tyrannosaurus.hasEgg() ? super.canUse() : false;
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.tyrannosaurus.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.tyrannosaurus.blockPosition());
			if (!this.tyrannosaurus.isInWater() && this.isReachedTarget()) {
				if (this.tyrannosaurus.isDigging < 1) {
					this.tyrannosaurus.setDigging(true);
				} else if (this.tyrannosaurus.isDigging > 200) {
					Level world = this.tyrannosaurus.level;
					world.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
					world.setBlock(this.blockPos.above(), PFBlocks.TYRANNOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.tyrannosaurus.random.nextInt(4) + 1)), 3);
					this.tyrannosaurus.setHasEgg(false);
					this.tyrannosaurus.setDigging(false);
					this.tyrannosaurus.setInLoveTime(600);
				}

				if (this.tyrannosaurus.isDigging()) {
					this.tyrannosaurus.isDigging++;
				}
			}

		}

		protected boolean isValidTarget(LevelReader worldIn, BlockPos pos) {
			if (!worldIn.isEmptyBlock(pos.above())) {
				return false;
			} else {
				Block block = worldIn.getBlockState(pos).getBlock();
				BlockState state = worldIn.getBlockState(pos);
				return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.MYCELIUM || block == Blocks.SAND || block == Blocks.RED_SAND || block == PFBlocks.MOSSY_DIRT.get() || block == PFBlocks.MOSS_BLOCK.get() || block == PFBlocks.LOAM.get() || block == PFBlocks.PACKED_LOAM.get() || block == PFBlocks.SILT.get() || block == PFBlocks.PACKED_LOAM.get() || state.is(BlockTags.LEAVES);
			}
		}
	}

	static class MateGoal extends BreedGoal {
		private final Tyrannosaurus tyrannosaurus;

		MateGoal(Tyrannosaurus tyrannosaurus, double speedIn) {
			super(tyrannosaurus, speedIn);
			this.tyrannosaurus = tyrannosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.tyrannosaurus.hasEgg() && !this.tyrannosaurus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			ServerPlayer serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.partner.getLoveCause() != null) {
				serverplayerentity = this.partner.getLoveCause();
			}

			if (serverplayerentity != null) {
				serverplayerentity.awardStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.partner, (AgeableMob)null);
			}

			this.tyrannosaurus.setHasEgg(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}

		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Tyrannosaurus tyrannosaurus;

		NaturalMateGoal(Tyrannosaurus tyrannosaurus, double speed) {
			super(tyrannosaurus, speed);
			this.tyrannosaurus = tyrannosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.tyrannosaurus.hasEgg() && this.tyrannosaurus.getCurrentHunger() >= this.tyrannosaurus.getThreeQuartersHunger() && this.tyrannosaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.tyrannosaurus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.tyrannosaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.tyrannosaurus.random.nextFloat() - this.tyrannosaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.tyrannosaurus.random.nextInt(4);
				if (eggAmount == 0) {
					this.tyrannosaurus.spawnAtLocation(PFBlocks.TYRANNOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.tyrannosaurus.spawnAtLocation(PFBlocks.TYRANNOSAURUS_EGG.get().asItem());
					this.tyrannosaurus.spawnAtLocation(PFBlocks.TYRANNOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.tyrannosaurus.spawnAtLocation(PFBlocks.TYRANNOSAURUS_EGG.get().asItem());
					this.tyrannosaurus.spawnAtLocation(PFBlocks.TYRANNOSAURUS_EGG.get().asItem());
					this.tyrannosaurus.spawnAtLocation(PFBlocks.TYRANNOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.tyrannosaurus.spawnAtLocation(PFBlocks.TYRANNOSAURUS_EGG.get().asItem());
					this.tyrannosaurus.spawnAtLocation(PFBlocks.TYRANNOSAURUS_EGG.get().asItem());
					this.tyrannosaurus.spawnAtLocation(PFBlocks.TYRANNOSAURUS_EGG.get().asItem());
					this.tyrannosaurus.spawnAtLocation(PFBlocks.TYRANNOSAURUS_EGG.get().asItem());
				}
			} else {
				this.tyrannosaurus.setHasEgg(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	class TyrannosaurusFollowParentGoal extends Goal {
		private final Tyrannosaurus babyTyrannosaurus;
		private Tyrannosaurus parentTyrannosaurus;
		private final double moveSpeed;
		private int delayCounter;

		public TyrannosaurusFollowParentGoal(Tyrannosaurus tyrannosaurus, double speed) {
			this.babyTyrannosaurus = tyrannosaurus;
			this.moveSpeed = speed;
		}

		public boolean canUse() {
			if (this.babyTyrannosaurus.isBaby() && !this.babyTyrannosaurus.isJuvenile()) {
				List<? extends Tyrannosaurus> list = this.babyTyrannosaurus.level.getEntitiesOfClass(this.babyTyrannosaurus.getClass(), this.babyTyrannosaurus.getBoundingBox().inflate(8.0D, 4.0D, 8.0D));
				Tyrannosaurus tyrannosaurus = null;
				double d0 = Double.MAX_VALUE;
				for (Tyrannosaurus tyrannosaurus1 : list) {
					if (!tyrannosaurus1.isBaby()) {
						double d1 = this.babyTyrannosaurus.distanceToSqr(tyrannosaurus1);
						if (!(d1 > d0)) {
							d0 = d1;
							tyrannosaurus = tyrannosaurus1;
						}
					}
				}
				if (tyrannosaurus == null) {
					return false;
				} else if (d0 < 9.0D) {
					return false;
				} else {
					this.parentTyrannosaurus = tyrannosaurus;
					return true;
				}
			} else {
				return false;
			}
		}

		public boolean canContinueToUse() {
			if (!this.babyTyrannosaurus.isJuvenile() || !this.babyTyrannosaurus.isBaby()) {
				return false;
			} else if (!this.parentTyrannosaurus.isAlive()) {
				return false;
			} else  if(this.babyTyrannosaurus.isBaby() && !this.babyTyrannosaurus.isJuvenile()){
				double d0 = this.babyTyrannosaurus.distanceToSqr(this.parentTyrannosaurus);
				return !(d0 < 9.0D) && !(d0 > 256.0D);
			} else {
				return false;
			}
		}

		public void start() {
			this.delayCounter = 0;
		}

		public void stop() {
			this.parentTyrannosaurus = null;
		}

		public void tick() {
			if (--this.delayCounter <= 0) {
				this.delayCounter = 10;
				this.babyTyrannosaurus.getNavigation().moveTo(this.parentTyrannosaurus, this.moveSpeed);
			}
		}
	}

	class TerritoryAttackGoal extends NearestAttackableTargetGoal<Player> {
		public TerritoryAttackGoal() {
			super(Tyrannosaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			if (Tyrannosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(@SuppressWarnings("unused") Tyrannosaurus tyrannosaurus : Tyrannosaurus.this.level.getEntitiesOfClass(Tyrannosaurus.class, Tyrannosaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						return true;
					}
				}

				return false;
			}
		}

		protected double getFollowDistance() {
			return super.getFollowDistance() * 0.5D;
		}
	}

	class JuvenileHuntGoal extends HuntGoal {

		private Tyrannosaurus tyrannosaurus;

		@SuppressWarnings("rawtypes")
		public JuvenileHuntGoal(Mob goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, Predicate targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnlyIn, targetPredicate);
			this.tyrannosaurus = (Tyrannosaurus) goalOwnerIn;
		}

		public boolean canUse() {
			if (super.canUse() && tyrannosaurus.isJuvenile()) {
				return true;
			} else {
				return false;
			}
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Tyrannosaurus entity = new Tyrannosaurus(PFEntities.TYRANNOSAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@SuppressWarnings("rawtypes")
	public class CarnivoreHuntGoal extends NearestAttackableTargetGoal {
		double huntSpeed;
		@SuppressWarnings("unchecked")
		public CarnivoreHuntGoal(Mob goalOwnerIn, Class targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
			this.huntSpeed = huntSpeed;
		}

		public boolean canUse() {
			return super.canUse() && Tyrannosaurus.this.getCurrentHunger() <= Tyrannosaurus.this.getHalfHunger() && !Tyrannosaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public boolean canContinueToUse() {
			return Tyrannosaurus.this.getCurrentHunger() > Tyrannosaurus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Tyrannosaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Tyrannosaurus.this.getTarget();
			if (target instanceof Cat || target instanceof Fox || target instanceof Cow || target instanceof MushroomCow || target instanceof Pig || target instanceof Ocelot || target instanceof Aepyornithomimus || target instanceof Protoceratops || target instanceof Coelophysis || target instanceof Trilophosaurus || target instanceof Typothorax) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 10 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 10);
					}
				}
			}
			if (target instanceof Dryosaurus || target instanceof Thescelosaurus || target instanceof Sarahsaurus || target instanceof Scelidosaurus  || target instanceof Citipati) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 15 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 15);
					}
				}
			}
			if (target instanceof Saurosuchus || target instanceof Desmatosuchus || target instanceof AbstractHorse || target instanceof Herrerasaurus|| target instanceof Placerias  || target instanceof WanderingTrader || target instanceof Player || target instanceof AbstractVillager || target instanceof AbstractIllager || target instanceof Llama || target instanceof Panda|| target instanceof Poposaurus) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 20 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 20);
					}
				}
			}
			if (target instanceof Dakotaraptor || target instanceof PolarBear || target instanceof Turtle || target instanceof Dilophosaurus) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 30 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 30);
					}
				}
			}
			if (target instanceof Ischigualastia || target instanceof Pinacosaurus || target instanceof Plesiohadros || target instanceof Ceratosaurus ) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 40 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 40);
					}
				}
			}
			if (target instanceof Ankylosaurus || target instanceof Sillosuchus || target instanceof Stegosaurus || target instanceof Triceratops || target instanceof Allosaurus) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 60 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 60);
					}
				}
			}
			super.tick();
		}

	}

	@SuppressWarnings("rawtypes")
	public class JuvenileCarnivoreHuntGoal extends NearestAttackableTargetGoal {
		double huntSpeed;
		@SuppressWarnings("unchecked")
		public JuvenileCarnivoreHuntGoal(Mob goalOwnerIn, Class targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
			this.huntSpeed = huntSpeed;
		}

		public boolean canUse() {
			return super.canUse() && Tyrannosaurus.this.getCurrentHunger() <= Tyrannosaurus.this.getHalfHunger() && Tyrannosaurus.this.isJuvenile() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public boolean canContinueToUse() {
			return Tyrannosaurus.this.getCurrentHunger() > Tyrannosaurus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true || !Tyrannosaurus.this.isJuvenile() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Tyrannosaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Tyrannosaurus.this.getTarget();
			if (target instanceof Rabbit) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 3 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof Didelphodon || target instanceof Eilenodon || target instanceof Hesperornithoides || target instanceof Hyperodapedon || target instanceof Chicken || target instanceof Scutellosaurus) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 4 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof Chromogisaurus || target instanceof Telmasaurus || target instanceof Parrot || target instanceof Kayentatherium || target instanceof Megapnosaurus) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 6 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 6);
					}
				}
			}
			if (target instanceof Basilemys || target instanceof Exaeretodon || target instanceof Velociraptor || target instanceof Wolf || target instanceof Sheep) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 8 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 8);
					}
				}
			}
			if (target instanceof Cat || target instanceof Fox || target instanceof Cow || target instanceof MushroomCow || target instanceof Pig || target instanceof Ocelot || target instanceof Aepyornithomimus || target instanceof Protoceratops || target instanceof Coelophysis || target instanceof Trilophosaurus || target instanceof Typothorax) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 10 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 10);
					}
				}
			}
			if (target instanceof Citipati || target instanceof Thescelosaurus || target instanceof Sarahsaurus || target instanceof Scelidosaurus || target instanceof Dryosaurus ) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 15 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 15);
					}
				}
			}
			if (target instanceof AbstractHorse || target instanceof Placerias || target instanceof Herrerasaurus || target instanceof Desmatosuchus || target instanceof WanderingTrader || target instanceof Player || target instanceof AbstractVillager || target instanceof AbstractIllager || target instanceof Llama) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 20 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 20);
					}
				}
			}
			if (target instanceof Turtle) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 30 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 30);
					}
				}
			}
			super.tick();
		}

	}

	@SuppressWarnings("rawtypes")
	public class BabyCarnivoreHuntGoal extends NearestAttackableTargetGoal {
		double huntSpeed;
		@SuppressWarnings("unchecked")
		public BabyCarnivoreHuntGoal(Mob goalOwnerIn, Class targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
			this.huntSpeed = huntSpeed;
		}

		public boolean canUse() {
			return super.canUse() && Tyrannosaurus.this.getCurrentHunger() <= Tyrannosaurus.this.getHalfHunger() && Tyrannosaurus.this.isBaby() && !Tyrannosaurus.this.isJuvenile() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public boolean canContinueToUse() {
			return Tyrannosaurus.this.getCurrentHunger() > Tyrannosaurus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true || Tyrannosaurus.this.isJuvenile() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Tyrannosaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Tyrannosaurus.this.getTarget();
			if (target instanceof Rabbit) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 3 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof Didelphodon || target instanceof Eilenodon || target instanceof Hyperodapedon || target instanceof Chicken || target instanceof Hesperornithoides || target instanceof Scutellosaurus) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 4 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof Telmasaurus) {
				if (target.getHealth() == 0) {
					if (Tyrannosaurus.this.getCurrentHunger() + 6 >= Tyrannosaurus.this.maxHunger) {
						Tyrannosaurus.this.setHunger(Tyrannosaurus.this.maxHunger);
					} else {
						Tyrannosaurus.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}

	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.TYRANNOSAURUS_SPAWN_EGG.get());
	}
}