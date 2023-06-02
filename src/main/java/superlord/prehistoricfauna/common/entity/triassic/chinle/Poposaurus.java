package superlord.prehistoricfauna.common.entity.triassic.chinle;

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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Plesiohadros;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Protoceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Telmasaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Velociraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Basilemys;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Didelphodon;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Thescelosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Kayentatherium;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Megapnosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Sarahsaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Scelidosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Scutellosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Dryosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Eilenodon;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Hesperornithoides;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Chromogisaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Exaeretodon;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Hyperodapedon;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Ischigualastia;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Sillosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Poposaurus extends DinosaurEntity {
	private static final EntityDataAccessor<Boolean> HAS_EGG = SynchedEntityData.defineId(Poposaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_DIGGING = SynchedEntityData.defineId(Poposaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALBINO = SynchedEntityData.defineId(Poposaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MELANISTIC = SynchedEntityData.defineId(Poposaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_LOVE = SynchedEntityData.defineId(Poposaurus.class, EntityDataSerializers.BOOLEAN);
	private int maxHunger = 50;
	private int currentHunger = 50;
	int hungerTick = 0;
	private int lastInLove = 0;
	private int warningSoundTicks;
	private int isDigging;
	private Goal attackAnimals;
	int loveTick = 0;

	public Poposaurus(EntityType<? extends Poposaurus> type, Level levelIn) {
		super(type, levelIn);
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.725F;
		else return 1.45F;
	}

	public boolean isDigging() {
		return this.getEntityData().get(IS_DIGGING);
	}

	private void setDigging(boolean isDigging) {
		this.isDigging = isDigging ? 1 : 0;
		this.entityData.set(IS_DIGGING, isDigging);
	}

	public boolean hasEgg() {
		return this.getEntityData().get(HAS_EGG);
	}

	private void setHasEgg(boolean hasEgg) {
		this.entityData.set(HAS_EGG, hasEgg);
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

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_LARGE_SYNAPSID_MEAT.get();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.attackAnimals = new HuntGoal(this, Animal.class, 10, false, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof Aepyornithomimus || p_213487_1_ instanceof Basilemys || p_213487_1_ instanceof Chromogisaurus || p_213487_1_ instanceof Citipati || p_213487_1_ instanceof Dryosaurus || p_213487_1_ instanceof Exaeretodon || p_213487_1_ instanceof Herrerasaurus || p_213487_1_ instanceof Ischigualastia || p_213487_1_ instanceof Plesiohadros || p_213487_1_ instanceof Protoceratops || p_213487_1_ instanceof Saurosuchus || p_213487_1_ instanceof Telmasaurus || p_213487_1_ instanceof Thescelosaurus || p_213487_1_ instanceof Velociraptor || p_213487_1_ instanceof Cat || p_213487_1_ instanceof Ocelot || p_213487_1_ instanceof Cow || p_213487_1_ instanceof AbstractHorse || p_213487_1_ instanceof Fox || p_213487_1_ instanceof MushroomCow || p_213487_1_ instanceof Pig || p_213487_1_ instanceof AbstractVillager || p_213487_1_ instanceof WanderingTrader || p_213487_1_ instanceof AbstractIllager || p_213487_1_ instanceof Llama || p_213487_1_ instanceof Panda || p_213487_1_ instanceof Wolf || p_213487_1_ instanceof Turtle || p_213487_1_ instanceof Player || p_213487_1_ instanceof Rabbit || p_213487_1_ instanceof Chicken || p_213487_1_ instanceof Kayentatherium || p_213487_1_ instanceof Megapnosaurus || p_213487_1_ instanceof Scelidosaurus || p_213487_1_ instanceof Scutellosaurus || p_213487_1_ instanceof Eilenodon || p_213487_1_ instanceof Hesperornithoides || p_213487_1_ instanceof Hyperodapedon || p_213487_1_ instanceof Sheep;
		});
		this.goalSelector.addGoal(1, new Poposaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Poposaurus.PanicGoal());
		this.targetSelector.addGoal(1, new Poposaurus.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Poposaurus.AttackPlayerGoal());
		this.targetSelector.addGoal(2, new Poposaurus.TerritoryAttackGoal());
		this.goalSelector.addGoal(0, new Poposaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Poposaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(0, new Poposaurus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Allosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Stegosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Camarasaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Triceratops.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Ankylosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Tyrannosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Sillosuchus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(0, new Poposaurus.CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof Aepyornithomimus || p_213487_1_ instanceof Citipati || p_213487_1_ instanceof Protoceratops || p_213487_1_ instanceof Telmasaurus || p_213487_1_ instanceof Velociraptor || p_213487_1_ instanceof Basilemys || p_213487_1_ instanceof Didelphodon || p_213487_1_ instanceof Thescelosaurus || p_213487_1_ instanceof Kayentatherium || p_213487_1_ instanceof Megapnosaurus || p_213487_1_ instanceof Sarahsaurus || p_213487_1_ instanceof Scelidosaurus || p_213487_1_ instanceof Scutellosaurus || p_213487_1_ instanceof Dryosaurus || p_213487_1_ instanceof Eilenodon || p_213487_1_ instanceof Hesperornithoides || p_213487_1_ instanceof Chromogisaurus || p_213487_1_ instanceof Exaeretodon || p_213487_1_ instanceof Herrerasaurus || p_213487_1_ instanceof Hyperodapedon || p_213487_1_ instanceof Coelophysis || p_213487_1_ instanceof Desmatosuchus || p_213487_1_ instanceof Placerias || p_213487_1_ instanceof Trilophosaurus || p_213487_1_ instanceof Typothorax || p_213487_1_ instanceof Cat || p_213487_1_ instanceof Chicken || p_213487_1_ instanceof Cow || p_213487_1_ instanceof Fox || p_213487_1_ instanceof MushroomCow || p_213487_1_ instanceof Ocelot || p_213487_1_ instanceof Parrot || p_213487_1_ instanceof Pig || p_213487_1_ instanceof Rabbit || p_213487_1_ instanceof Sheep || p_213487_1_ instanceof Wolf;
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
			List<? extends Poposaurus> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
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
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 5.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.25D);
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, this.attackAnimals);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.POPOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.POPOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.POPOSAURUS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(SoundEvents.COW_STEP, 0.15F, 1F);
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.CERATOSAURUS_WARN, 1.0F, this.getVoicePitch());
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

	public boolean doHurtTarget(Entity entity) {
		boolean flag = super.doHurtTarget(entity);
		if (flag) {
			this.doEnchantDamageEffects(this, entity);
		}
		return flag;
	}

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(Poposaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean canUse() {
			if (Poposaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for (@SuppressWarnings("unused") Poposaurus poposaurus : Poposaurus.this.level.getEntitiesOfClass(Poposaurus.class, Poposaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {	
						if (Poposaurus.this.isBaby()) {
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

	class TerritoryAttackGoal extends NearestAttackableTargetGoal<Player> {
		public TerritoryAttackGoal() {
			super(Poposaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			if (Poposaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(@SuppressWarnings("unused") Poposaurus poposaurus : Poposaurus.this.level.getEntitiesOfClass(Poposaurus.class, Poposaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
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

	class HurtByTargetGoal extends net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(Poposaurus.this);
		}

		public void start() {
			super.start();
			if(Poposaurus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}
		}

		protected void alertOther(Mob entity, LivingEntity target) {
			if (entity instanceof Poposaurus && !entity.isBaby()) {
				super.alertOther(entity, target);
			}
		}

	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Poposaurus.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				Poposaurus.this.playSound(PFSounds.POPOSAURUS_BITE, 1.0F, Poposaurus.this.getVoicePitch());
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}

				if (this.getTicksUntilNextAttack() <= 10) {
					Poposaurus.this.playWarningSound();
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

	class PanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(Poposaurus.this, 2.0D);
		}

		public boolean canUse() {
			return !Poposaurus.this.isBaby() && !Poposaurus.this.isOnFire() ? false : super.canUse();
		}

	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Poposaurus poposaurus;

		LayEggGoal(Poposaurus poposaurus, double speed) {
			super(poposaurus, speed, 16);
			this.poposaurus = poposaurus;
		}

		public boolean canUse() {
			return this.poposaurus.hasEgg() ? super.canUse() : false;
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && poposaurus.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.poposaurus.position());
			if (!this.poposaurus.isInWater() && this.isReachedTarget()) {
				if (this.poposaurus.isDigging < 1) {
					this.poposaurus.setDigging(true);
				} else if (this.poposaurus.isDigging > 200) {
					Level level = this.poposaurus.level;
					level.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);
					level.setBlock(this.blockPos.above(), PFBlocks.POPOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.poposaurus.random.nextInt(4) + 1)), 3);
					this.poposaurus.setHasEgg(false);
					this.poposaurus.setDigging(false);
					this.poposaurus.setInLoveTime(600);
				}
				if (this.poposaurus.isDigging()) {
					this.poposaurus.isDigging++;
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
		private final Poposaurus poposaurus;

		MateGoal(Poposaurus poposaurus, double speed) {
			super(poposaurus, speed);
			this.poposaurus = poposaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.poposaurus.hasEgg() && !this.poposaurus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			ServerPlayer serverPlayer = this.animal.getLoveCause();
			if (serverPlayer == null && this.partner.getLoveCause() == null) {
				serverPlayer = this.partner.getLoveCause();
			}
			if (serverPlayer != null) {
				serverPlayer.awardStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverPlayer, this.animal, this.partner, (AgeableMob)null);
			}
			this.poposaurus.setHasEgg(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}

	}

	static class NaturalMateGoal extends BreedGoal {
		private final Poposaurus poposaurus;

		NaturalMateGoal(Poposaurus poposaurus, double speed) {
			super(poposaurus, speed);
			this.poposaurus = poposaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.poposaurus.hasEgg() && this.poposaurus.getCurrentHunger() >= this.poposaurus.getThreeQuartersHunger() && this.poposaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.poposaurus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.poposaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.poposaurus.random.nextFloat() - this.poposaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.poposaurus.random.nextInt(4);
				if (eggAmount == 0) {
					this.poposaurus.spawnAtLocation(PFBlocks.POPOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.poposaurus.spawnAtLocation(PFBlocks.POPOSAURUS_EGG.get().asItem());
					this.poposaurus.spawnAtLocation(PFBlocks.POPOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.poposaurus.spawnAtLocation(PFBlocks.POPOSAURUS_EGG.get().asItem());
					this.poposaurus.spawnAtLocation(PFBlocks.POPOSAURUS_EGG.get().asItem());
					this.poposaurus.spawnAtLocation(PFBlocks.POPOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.poposaurus.spawnAtLocation(PFBlocks.POPOSAURUS_EGG.get().asItem());
					this.poposaurus.spawnAtLocation(PFBlocks.POPOSAURUS_EGG.get().asItem());
					this.poposaurus.spawnAtLocation(PFBlocks.POPOSAURUS_EGG.get().asItem());
					this.poposaurus.spawnAtLocation(PFBlocks.POPOSAURUS_EGG.get().asItem());
				}
			} else {
				this.poposaurus.setHasEgg(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Poposaurus entity = new Poposaurus(PFEntities.POPOSAURUS.get(), this.level);
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
			return super.canUse() && Poposaurus.this.getCurrentHunger() <= Poposaurus.this.getHalfHunger() && !Poposaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public boolean canContinueToUse() {
			return Poposaurus.this.getCurrentHunger() < Poposaurus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Poposaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Poposaurus.this.getTarget();
			if (target instanceof Rabbit) {
				if (target.getHealth() == 0) {
					if (Poposaurus.this.getCurrentHunger() + 3 >= Poposaurus.this.maxHunger) {
						Poposaurus.this.setHunger(Poposaurus.this.maxHunger);
					} else {
						Poposaurus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof Didelphodon || target instanceof Scutellosaurus || target instanceof Eilenodon || target instanceof Hesperornithoides || target instanceof Hyperodapedon || target instanceof Chicken) {
				if (target.getHealth() == 0) {
					if (Poposaurus.this.getCurrentHunger() + 4 >= Poposaurus.this.maxHunger) {
						Poposaurus.this.setHunger(Poposaurus.this.maxHunger);
					} else {
						Poposaurus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof Telmasaurus || target instanceof Kayentatherium || target instanceof Megapnosaurus || target instanceof Chromogisaurus || target instanceof Parrot) {
				if (target.getHealth() == 0) {
					if (Poposaurus.this.getCurrentHunger() + 6 >= Poposaurus.this.maxHunger) {
						Poposaurus.this.setHunger(Poposaurus.this.maxHunger);
					} else {
						Poposaurus.this.setHunger(currentHunger + 6);
					}
				}
			}
			if (target instanceof Velociraptor || target instanceof Basilemys || target instanceof Exaeretodon || target instanceof Sheep || target instanceof Wolf) {
				if (target.getHealth() == 0) {
					if (Poposaurus.this.getCurrentHunger() + 8 >= Poposaurus.this.maxHunger) {
						Poposaurus.this.setHunger(Poposaurus.this.maxHunger);
					} else {
						Poposaurus.this.setHunger(currentHunger + 8);
					}
				}
			}
			if (target instanceof Aepyornithomimus || target instanceof Protoceratops || target instanceof Trilophosaurus || target instanceof Typothorax || target instanceof Coelophysis || target instanceof Cat || target instanceof Cow || target instanceof Fox || target instanceof MushroomCow || target instanceof Ocelot || target instanceof Pig) {
				if (target.getHealth() == 0) {
					if (Poposaurus.this.getCurrentHunger() + 10 >= Poposaurus.this.maxHunger) {
						Poposaurus.this.setHunger(Poposaurus.this.maxHunger);
					} else {
						Poposaurus.this.setHunger(currentHunger + 10);
					}
				}
			}
			if (target instanceof Thescelosaurus || target instanceof Sarahsaurus || target instanceof Scelidosaurus || target instanceof Dryosaurus || target instanceof Citipati) {
				if (target.getHealth() == 0) {
					if (Poposaurus.this.getCurrentHunger() + 15 >= Poposaurus.this.maxHunger) {
						Poposaurus.this.setHunger(Poposaurus.this.maxHunger);
					} else {
						Poposaurus.this.setHunger(currentHunger + 15);
					}
				}
			}
			if (target instanceof Desmatosuchus || target instanceof Placerias || target instanceof Herrerasaurus) {
				if (target.getHealth() == 0) {
					if (Poposaurus.this.getCurrentHunger() + 20 >= Poposaurus.this.maxHunger) {
						Poposaurus.this.setHunger(Poposaurus.this.maxHunger);
					} else {
						Poposaurus.this.setHunger(currentHunger + 20);
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
			return super.canUse() && Poposaurus.this.getCurrentHunger() <= Poposaurus.this.getHalfHunger() && Poposaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public boolean canContinueToUse() {
			return Poposaurus.this.getCurrentHunger() < Poposaurus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true || !Poposaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Poposaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Poposaurus.this.getTarget();
			if (target instanceof Rabbit) {
				if (target.getHealth() == 0) {
					if (Poposaurus.this.getCurrentHunger() + 3 >= Poposaurus.this.maxHunger) {
						Poposaurus.this.setHunger(Poposaurus.this.maxHunger);
					} else {
						Poposaurus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof Didelphodon || target instanceof Eilenodon || target instanceof Hyperodapedon || target instanceof Chicken || target instanceof Hesperornithoides || target instanceof Scutellosaurus) {
				if (target.getHealth() == 0) {
					if (Poposaurus.this.getCurrentHunger() + 4 >= Poposaurus.this.maxHunger) {
						Poposaurus.this.setHunger(Poposaurus.this.maxHunger);
					} else {
						Poposaurus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof Telmasaurus) {
				if (target.getHealth() == 0) {
					if (Poposaurus.this.getCurrentHunger() + 6 >= Poposaurus.this.maxHunger) {
						Poposaurus.this.setHunger(Poposaurus.this.maxHunger);
					} else {
						Poposaurus.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.POPOSAURUS_SPAWN_EGG.get());
	}

}