package superlord.prehistoricfauna.common.entity.triassic.ischigualasto;

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
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.animal.Pig;
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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Protoceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Telmasaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Velociraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Basilemys;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Didelphodon;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Thescelosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Kayentatherium;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Megapnosaurus;
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
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Herrerasaurus extends DinosaurEntity {

	private static final EntityDataAccessor<Boolean> HAS_EGG = SynchedEntityData.defineId(Herrerasaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_DIGGING = SynchedEntityData.defineId(Herrerasaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALBINO = SynchedEntityData.defineId(Herrerasaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MELANISTIC = SynchedEntityData.defineId(Herrerasaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_LOVE = SynchedEntityData.defineId(Herrerasaurus.class, EntityDataSerializers.BOOLEAN);
	private int currentHunger = 50;
	private int maxHunger = 50;
	private int lastInLove = 0;
	int hungerTick = 0;
	private int warningSoundTicks;
	private int isDigging;
	private Goal attackAnimals;
	int loveTick = 0;

	public Herrerasaurus(EntityType<? extends Herrerasaurus> type, Level levelIn) {
		super(type, levelIn);
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) {
			return 0.75F;
		} else return 1.5F;
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

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_SMALL_ARCHOSAUROMORPH_MEAT.get();
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

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.attackAnimals = new HuntGoal(this, Animal.class, 10, false, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof Aepyornithomimus || p_213487_1_ instanceof Basilemys || p_213487_1_ instanceof Chromogisaurus || p_213487_1_ instanceof Citipati || p_213487_1_ instanceof Didelphodon || p_213487_1_ instanceof Dryosaurus || p_213487_1_ instanceof Eilenodon || p_213487_1_ instanceof Exaeretodon || p_213487_1_ instanceof Hesperornithoides || p_213487_1_ instanceof Hyperodapedon || p_213487_1_ instanceof Protoceratops || p_213487_1_ instanceof Telmasaurus || p_213487_1_ instanceof Thescelosaurus || p_213487_1_ instanceof Velociraptor || p_213487_1_ instanceof Cat || p_213487_1_ instanceof Ocelot || p_213487_1_ instanceof Chicken || p_213487_1_ instanceof Cow || p_213487_1_ instanceof AbstractHorse || p_213487_1_ instanceof Fox || p_213487_1_ instanceof MushroomCow || p_213487_1_ instanceof Parrot || p_213487_1_ instanceof Pig || p_213487_1_ instanceof Rabbit || p_213487_1_ instanceof AbstractVillager || p_213487_1_ instanceof AbstractIllager || p_213487_1_ instanceof WanderingTrader || p_213487_1_ instanceof Player || p_213487_1_ instanceof Llama || p_213487_1_ instanceof Wolf || p_213487_1_ instanceof Turtle || p_213487_1_ instanceof Scutellosaurus || p_213487_1_ instanceof Megapnosaurus || p_213487_1_ instanceof Kayentatherium || p_213487_1_ instanceof Sheep || p_213487_1_ instanceof Coelophysis || p_213487_1_ instanceof Desmatosuchus || p_213487_1_ instanceof Placerias || p_213487_1_ instanceof Trilophosaurus || p_213487_1_ instanceof Typothorax;
		});
		this.goalSelector.addGoal(1, new Herrerasaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new Herrerasaurus.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Herrerasaurus.AttackPlayerGoal());
		this.goalSelector.addGoal(0, new Herrerasaurus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Herrerasaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Herrerasaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Camarasaurus>(this, Camarasaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Ankylosaurus>(this, Ankylosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Triceratops>(this, Triceratops.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Stegosaurus>(this, Stegosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Allosaurus>(this, Allosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Ceratosaurus>(this, Ceratosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Tyrannosaurus>(this, Tyrannosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Ischigualastia>(this, Ischigualastia.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.targetSelector.addGoal(0, new Herrerasaurus.CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof Aepyornithomimus || p_213487_1_ instanceof Basilemys || p_213487_1_ instanceof Chromogisaurus || p_213487_1_ instanceof Citipati || p_213487_1_ instanceof Didelphodon || p_213487_1_ instanceof Dryosaurus || p_213487_1_ instanceof Eilenodon || p_213487_1_ instanceof Exaeretodon || p_213487_1_ instanceof Hesperornithoides || p_213487_1_ instanceof Hyperodapedon || p_213487_1_ instanceof Protoceratops || p_213487_1_ instanceof Telmasaurus || p_213487_1_ instanceof Thescelosaurus || p_213487_1_ instanceof Velociraptor || p_213487_1_ instanceof Cat || p_213487_1_ instanceof Ocelot || p_213487_1_ instanceof Chicken || p_213487_1_ instanceof Cow || p_213487_1_ instanceof AbstractHorse || p_213487_1_ instanceof Fox || p_213487_1_ instanceof MushroomCow || p_213487_1_ instanceof Parrot || p_213487_1_ instanceof Pig || p_213487_1_ instanceof Rabbit || p_213487_1_ instanceof AbstractVillager || p_213487_1_ instanceof AbstractIllager || p_213487_1_ instanceof WanderingTrader || p_213487_1_ instanceof Player || p_213487_1_ instanceof Llama || p_213487_1_ instanceof Wolf || p_213487_1_ instanceof Turtle || p_213487_1_ instanceof Scutellosaurus || p_213487_1_ instanceof Megapnosaurus || p_213487_1_ instanceof Kayentatherium || p_213487_1_ instanceof Sheep || p_213487_1_ instanceof Coelophysis || p_213487_1_ instanceof Desmatosuchus || p_213487_1_ instanceof Placerias || p_213487_1_ instanceof Trilophosaurus || p_213487_1_ instanceof Typothorax;
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof Didelphodon || p_213487_1_ instanceof Eilenodon || p_213487_1_ instanceof Hyperodapedon || p_213487_1_ instanceof Telmasaurus || p_213487_1_ instanceof Rabbit || p_213487_1_ instanceof Chicken || p_213487_1_ instanceof Hesperornithoides || p_213487_1_ instanceof Scutellosaurus;
		}));
	}

	public void aiStep() {
		super.aiStep();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		}
		if (!this.isNoAi()) {
			List<? extends Herrerasaurus> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
			if (PrehistoricFaunaConfig.advancedHunger) {
				hungerTick++;
				if (hungerTick == 600 && !this.isBaby() || hungerTick == 300 && this.isBaby()) {
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
					if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && tickCount % 900 == 0 && !this.isBaby() && !this.isInLove() && !this.isAsleep() && list.size() < 5) {
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
				if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isBaby() && !this.isInLove() && !this.isAsleep() && list.size() < 5) {
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
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.ATTACK_DAMAGE, 6.0D);
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, this.attackAnimals);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.HERRERASAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.HERRERASAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.HERRERASAURUS_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.HERRERASAURUS_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(HAS_EGG, false);
		this.entityData.define(IS_DIGGING, false);
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
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setAttackGoals();
		this.setHunger(compound.getInt("MaxHunger"));
		this.setInLoveNaturally(compound.getBoolean("InNaturalLove"));
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
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

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
		}
		return flag;
	}	

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(Herrerasaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean canUse() {
			if (Herrerasaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Herrerasaurus herrerasaurus : Herrerasaurus.this.level.getEntitiesOfClass(Herrerasaurus.class, Herrerasaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (herrerasaurus.isBaby()) {
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
			super(Herrerasaurus.this);
		}

		public void start() {
			super.start();
			if (Herrerasaurus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}
		}

		protected void alertOther(Mob mobIn, LivingEntity targetIn) {
			if (mobIn instanceof Herrerasaurus && !mobIn.isBaby()) {
				super.alertOther(mobIn, targetIn);
			}
		}
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Herrerasaurus.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				Herrerasaurus.this.playSound(PFSounds.HERRERASAURUS_BITE, 1.0F, Herrerasaurus.this.getVoicePitch());
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}

				if (this.getTicksUntilNextAttack() <= 10) {
					Herrerasaurus.this.playWarningSound();
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
			return (double)(4.0F + attackTarget.getBbWidth());
		}
	}
	static class LayEggGoal extends MoveToBlockGoal {
		private final Herrerasaurus herrerasaurus;

		LayEggGoal(Herrerasaurus herrerasaurus, double speedIn) {
			super(herrerasaurus, speedIn, 16);
			this.herrerasaurus = herrerasaurus;
		}

		public boolean canUse() {
			return this.herrerasaurus.hasEgg() ? super.canUse() : false;
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.herrerasaurus.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.herrerasaurus.position());
			if (!this.herrerasaurus.isInWater() && this.isReachedTarget()) {
				if (this.herrerasaurus.isDigging < 1) {
					this.herrerasaurus.setDigging(true);
				} else if (this.herrerasaurus.isDigging > 200) {
					Level level = this.herrerasaurus.level;
					level.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);
					level.setBlock(this.blockPos.above(), PFBlocks.HERRERASAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.herrerasaurus.random.nextInt(4) + 1)), 3);
					this.herrerasaurus.setHasEgg(false);
					this.herrerasaurus.setDigging(false);
					this.herrerasaurus.setInLoveTime(600);
				}
				if (this.herrerasaurus.isDigging()) {
					this.herrerasaurus.isDigging++;
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
		private final Herrerasaurus herrerasaurus;

		MateGoal(Herrerasaurus herrerasaurus, double speedIn) {
			super(herrerasaurus, speedIn);
			this.herrerasaurus = herrerasaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.herrerasaurus.hasEgg() && !this.herrerasaurus.isInLoveNaturally();
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
			this.herrerasaurus.setHasEgg(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Herrerasaurus herrerasaurus;

		NaturalMateGoal(Herrerasaurus herrerasaurus, double speed) {
			super(herrerasaurus, speed);
			this.herrerasaurus = herrerasaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.herrerasaurus.hasEgg() && this.herrerasaurus.getCurrentHunger() >= this.herrerasaurus.getThreeQuartersHunger() && this.herrerasaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.herrerasaurus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.herrerasaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.herrerasaurus.random.nextFloat() - this.herrerasaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.herrerasaurus.random.nextInt(4);
				if (eggAmount == 0) {
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
				}
			} else {
				this.herrerasaurus.setHasEgg(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Herrerasaurus entity = new Herrerasaurus(PFEntities.HERRERASAURUS.get(), this.level);
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
			return super.canUse() && Herrerasaurus.this.getCurrentHunger() <= Herrerasaurus.this.getHalfHunger() && !Herrerasaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public boolean canContinueToUse() {
			return Herrerasaurus.this.getCurrentHunger() < Herrerasaurus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			LivingEntity target = Herrerasaurus.this.getTarget();
			Herrerasaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			if (target instanceof Rabbit) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 3 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof Didelphodon || target instanceof Eilenodon || target instanceof Hesperornithoides || target instanceof Hyperodapedon || target instanceof Chicken || target instanceof Scutellosaurus) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 4 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof Chromogisaurus || target instanceof Telmasaurus || target instanceof Parrot || target instanceof Megapnosaurus || target instanceof Kayentatherium) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 6 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 6);
					}
				}
			}
			if (target instanceof Basilemys || target instanceof Exaeretodon || target instanceof Velociraptor || target instanceof Wolf || target instanceof Sheep) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 8 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 8);
					}
				}
			}
			if (target instanceof Cat || target instanceof Fox || target instanceof Cow || target instanceof MushroomCow || target instanceof Pig || target instanceof Ocelot || target instanceof Aepyornithomimus || target instanceof Protoceratops || target instanceof Coelophysis || target instanceof Trilophosaurus || target instanceof Typothorax) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 10 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 10);
					}
				}
			}
			if (target instanceof Citipati || target instanceof Dryosaurus || target instanceof Thescelosaurus) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 15 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 15);
					}
				}
			}
			if (target instanceof AbstractHorse || target instanceof Desmatosuchus || target instanceof WanderingTrader || target instanceof Player || target instanceof AbstractVillager || target instanceof AbstractIllager || target instanceof Llama || target instanceof Placerias) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 20 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 20);
					}
				}
			}
			if (target instanceof Turtle) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 30 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 30);
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
			return super.canUse() && Herrerasaurus.this.getCurrentHunger() <= Herrerasaurus.this.getHalfHunger() && Herrerasaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public boolean canContinueToUse() {
			return Herrerasaurus.this.getCurrentHunger() < Herrerasaurus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true || !Herrerasaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Herrerasaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Herrerasaurus.this.getTarget();
			if (target instanceof Rabbit) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 3 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof Didelphodon || target instanceof Eilenodon || target instanceof Hyperodapedon || target instanceof Chicken || target instanceof Hesperornithoides || target instanceof Scutellosaurus) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 4 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof Telmasaurus) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 6 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.HERRERASAURUS_SPAWN_EGG.get());
	}

}
