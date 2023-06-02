package superlord.prehistoricfauna.common.entity.jurassic.morrison;

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
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Turtle;
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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Didelphodon;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Thescelosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Sarahsaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Scelidosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Scutellosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Coelophysis;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Desmatosuchus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Placerias;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Trilophosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Typothorax;
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

public class Allosaurus extends DinosaurEntity {

	private static final EntityDataAccessor<Boolean> HAS_EGG = SynchedEntityData.defineId(Allosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_DIGGING = SynchedEntityData.defineId(Allosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALBINO = SynchedEntityData.defineId(Allosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MELANISTIC = SynchedEntityData.defineId(Allosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_LOVE = SynchedEntityData.defineId(Allosaurus.class, EntityDataSerializers.BOOLEAN);
	private int currentHunger = 150;
	private int maxHunger = 150;
	int hungerTick = 0;
	private int warningSoundTicks;
	private int isDigging;
	private int lastInLove = 0;
	int loveTick = 0;
	private Goal attackAnimals;

	@SuppressWarnings("deprecation")
	public Allosaurus(EntityType<? extends Allosaurus> type, Level worldIn) {
		super(type, worldIn);
		this.maxUpStep = 1.0F;
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 1.5F;
		else return 3.0F;
	}

	public boolean isDigging() {
		return this.entityData.get(IS_DIGGING);
	}

	public boolean isInLoveNaturally() {
		return this.entityData.get(NATURAL_LOVE);
	}

	private void setInLoveNaturally(boolean isInLoveNaturally) {
		this.entityData.set(NATURAL_LOVE, isInLoveNaturally);
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
		return stack.getItem() == PFItems.RAW_LARGE_THYREOPHORAN_MEAT.get();
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
		this.attackAnimals = new HuntGoal(this, Animal.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof Aepyornithomimus || p_213487_0_ instanceof Ankylosaurus || p_213487_0_ instanceof Citipati || p_213487_0_ instanceof Dakotaraptor || p_213487_0_ instanceof Dryosaurus || p_213487_0_ instanceof Herrerasaurus || p_213487_0_ instanceof Ischigualastia || p_213487_0_ instanceof Pinacosaurus || p_213487_0_ instanceof Plesiohadros || p_213487_0_ instanceof Protoceratops || p_213487_0_ instanceof Saurosuchus || p_213487_0_ instanceof Sillosuchus || p_213487_0_ instanceof Stegosaurus || p_213487_0_ instanceof Thescelosaurus || p_213487_0_ instanceof Triceratops || p_213487_0_ instanceof Cat || p_213487_0_ instanceof Ocelot || p_213487_0_ instanceof Cow || p_213487_0_ instanceof AbstractHorse || p_213487_0_ instanceof Fox || p_213487_0_ instanceof MushroomCow || p_213487_0_ instanceof Pig || p_213487_0_ instanceof AbstractVillager || p_213487_0_ instanceof WanderingTrader || p_213487_0_ instanceof AbstractIllager || p_213487_0_ instanceof Llama || p_213487_0_ instanceof Panda || p_213487_0_ instanceof PolarBear || p_213487_0_ instanceof Turtle || p_213487_0_ instanceof Player || p_213487_0_ instanceof Sarahsaurus || p_213487_0_ instanceof Scelidosaurus || p_213487_0_ instanceof Coelophysis || p_213487_0_ instanceof Desmatosuchus || p_213487_0_ instanceof Placerias || p_213487_0_ instanceof Poposaurus || p_213487_0_ instanceof Postosuchus || p_213487_0_ instanceof Typothorax || p_213487_0_ instanceof Trilophosaurus;
		});
		this.goalSelector.addGoal(1, new Allosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Allosaurus.PanicGoal());
		this.targetSelector.addGoal(2, new Allosaurus.TerritoryAttackGoal());
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new Allosaurus.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Allosaurus.AttackPlayerGoal());
		this.goalSelector.addGoal(0, new Allosaurus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new Allosaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new Allosaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Camarasaurus>(this, Camarasaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.targetSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof Aepyornithomimus || p_213487_0_ instanceof Ankylosaurus || p_213487_0_ instanceof Citipati || p_213487_0_ instanceof Dakotaraptor || p_213487_0_ instanceof Dryosaurus || p_213487_0_ instanceof Herrerasaurus || p_213487_0_ instanceof Ischigualastia || p_213487_0_ instanceof Pinacosaurus || p_213487_0_ instanceof Plesiohadros || p_213487_0_ instanceof Protoceratops || p_213487_0_ instanceof Saurosuchus || p_213487_0_ instanceof Sillosuchus || p_213487_0_ instanceof Stegosaurus || p_213487_0_ instanceof Thescelosaurus || p_213487_0_ instanceof Triceratops || p_213487_0_ instanceof Cat || p_213487_0_ instanceof Ocelot || p_213487_0_ instanceof Cow || p_213487_0_ instanceof AbstractHorse || p_213487_0_ instanceof Fox || p_213487_0_ instanceof MushroomCow || p_213487_0_ instanceof Pig || p_213487_0_ instanceof AbstractVillager || p_213487_0_ instanceof WanderingTrader || p_213487_0_ instanceof AbstractIllager || p_213487_0_ instanceof Llama || p_213487_0_ instanceof Panda || p_213487_0_ instanceof PolarBear || p_213487_0_ instanceof Turtle || p_213487_0_ instanceof Player || p_213487_0_ instanceof Sarahsaurus || p_213487_0_ instanceof Scelidosaurus || p_213487_0_ instanceof Coelophysis || p_213487_0_ instanceof Desmatosuchus || p_213487_0_ instanceof Placerias || p_213487_0_ instanceof Poposaurus || p_213487_0_ instanceof Postosuchus || p_213487_0_ instanceof Typothorax || p_213487_0_ instanceof Trilophosaurus;
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof Didelphodon || p_213487_1_ instanceof Eilenodon || p_213487_1_ instanceof Hyperodapedon || p_213487_1_ instanceof Telmasaurus || p_213487_1_ instanceof Rabbit || p_213487_1_ instanceof Chicken || p_213487_1_ instanceof Hesperornithoides || p_213487_1_ instanceof Scutellosaurus;
		}));

	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 60.0D).add(Attributes.MOVEMENT_SPEED, (double)0.25F).add(Attributes.ATTACK_DAMAGE, 12.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.6D);
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, this.attackAnimals);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? PFSounds.ALLOSAURUS_SNORES : PFSounds.ALLOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.ALLOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.ALLOSAURUS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.ALLOSAURUS_WARN, 1.0F, this.getVoicePitch());
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

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double)0.25F);
		}
		if (!this.isNoAi()) {
			List<? extends Allosaurus> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
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
				}if (this.getCurrentHunger() >= this.getThreeQuartersHunger() && hungerTick % 150 == 0) {
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
			} else if ((PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && !PrehistoricFaunaConfig.advancedHunger && list.size() < 5) {
				int naturalBreedingChance = random.nextInt(1000);
				if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isBaby() && !this.isInLove() && !this.isAsleep()) {
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

	/**
	 * Called to update the entity's position/logic.
	 */
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
		public AttackPlayerGoal() {
			super(Allosaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean canUse() {
			if (Allosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Allosaurus allosaurus : Allosaurus.this.level.getEntitiesOfClass(Allosaurus.class, Allosaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (allosaurus.isBaby()) {
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
			super(Allosaurus.this);
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			super.start();
			if (Allosaurus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}

		}

		protected void alertOther(Mob mobIn, LivingEntity targetIn) {
			if (mobIn instanceof Allosaurus && !mobIn.isBaby()) {
				super.alertOther(mobIn, targetIn);
			}

		}
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Allosaurus.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				Allosaurus.this.playSound(PFSounds.ALLOSAURUS_BITE, 1.0F, Allosaurus.this.getVoicePitch());
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}

				if (this.getTicksUntilNextAttack() <= 10) {
					Allosaurus.this.playWarningSound();
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
			return (double)(8.0F + attackTarget.getBbWidth());
		}
	}

	class PanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(Allosaurus.this, 2.0D);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Allosaurus.this.isBaby() && !Allosaurus.this.isOnFire() ? false : super.canUse();
		}
	}

	class TerritoryAttackGoal extends NearestAttackableTargetGoal<Player> {
		public TerritoryAttackGoal() {
			super(Allosaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			if (Allosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(@SuppressWarnings("unused") Allosaurus allosaurus : Allosaurus.this.level.getEntitiesOfClass(Allosaurus.class, Allosaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
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

	static class LayEggGoal extends MoveToBlockGoal {
		private final Allosaurus allosaurus;

		LayEggGoal(Allosaurus allosaurus, double speedIn) {
			super(allosaurus, speedIn, 16);
			this.allosaurus = allosaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.allosaurus.hasEgg() ? super.canUse() : false;
		}

		/**
		 * Returns whether an in-progress AIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.allosaurus.hasEgg();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.allosaurus.position());
			if (!this.allosaurus.isInWater() && this.isReachedTarget()) {
				if (this.allosaurus.isDigging < 1) {
					this.allosaurus.setDigging(true);
				} else if (this.allosaurus.isDigging > 200) {
					Level world = this.allosaurus.level;
					world.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
					world.setBlock(this.blockPos.above(), PFBlocks.ALLOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.allosaurus.random.nextInt(4) + 1)), 3);
					this.allosaurus.setHasEgg(false);
					this.allosaurus.setDigging(false);
					this.allosaurus.setInLoveTime(600);
				}

				if (this.allosaurus.isDigging()) {
					this.allosaurus.isDigging++;
				}
			}

		}

		/**
		 * Return true to set given position as destination
		 */
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
		private final Allosaurus allosaurus;

		MateGoal(Allosaurus allosaurus, double speedIn) {
			super(allosaurus, speedIn);
			this.allosaurus = allosaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return super.canUse() && !this.allosaurus.hasEgg() && !this.allosaurus.isInLoveNaturally();
		}

		/**
		 * Spawns a baby animal of the same type.
		 */
		protected void spawnBaby() {
			ServerPlayer serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.partner.getLoveCause() != null) {
				serverplayerentity = this.partner.getLoveCause();
			}

			if (serverplayerentity != null) {
				serverplayerentity.awardStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.partner, (AgeableMob)null);
			}

			this.allosaurus.setHasEgg(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}

		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Allosaurus allosaurus;

		NaturalMateGoal(Allosaurus allosaurus, double speed) {
			super(allosaurus, speed);
			this.allosaurus = allosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.allosaurus.hasEgg() && this.allosaurus.getCurrentHunger() >= this.allosaurus.getThreeQuartersHunger() && this.allosaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.allosaurus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.allosaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.allosaurus.random.nextFloat() - this.allosaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.allosaurus.random.nextInt(4);
				if (eggAmount == 0) {
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
					this.allosaurus.spawnAtLocation(PFBlocks.ALLOSAURUS_EGG.get().asItem());
				}
			} else {
				this.allosaurus.setHasEgg(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Allosaurus entity = new Allosaurus(PFEntities.ALLOSAURUS.get(), this.level);
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
			return super.canUse() && Allosaurus.this.getCurrentHunger() <= Allosaurus.this.getHalfHunger() && !Allosaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public boolean canContinueToUse() {
			return Allosaurus.this.getCurrentHunger() > Allosaurus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Allosaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Allosaurus.this.getTarget();
			if (target instanceof Cat || target instanceof Fox || target instanceof Cow || target instanceof MushroomCow || target instanceof Pig || target instanceof Ocelot || target instanceof Aepyornithomimus || target instanceof Protoceratops || target instanceof Coelophysis || target instanceof Typothorax || target instanceof Trilophosaurus) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 10 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 10);
					}
				}
			}
			if (target instanceof Citipati || target instanceof Dryosaurus || target instanceof Thescelosaurus || target instanceof Scelidosaurus || target instanceof Sarahsaurus) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 15 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 15);
					}
				}
			}
			if (target instanceof Herrerasaurus || target instanceof Placerias || target instanceof Postosuchus || target instanceof AbstractHorse || target instanceof WanderingTrader || target instanceof Player || target instanceof AbstractVillager || target instanceof AbstractIllager || target instanceof Llama || target instanceof Panda || target instanceof Poposaurus || target instanceof Desmatosuchus) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 20 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 20);
					}
				}
			}
			if (target instanceof Dakotaraptor || target instanceof PolarBear || target instanceof Turtle || target instanceof Saurosuchus) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 30 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 30);
					}
				}
			}
			if (target instanceof Ischigualastia || target instanceof Pinacosaurus || target instanceof Plesiohadros) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 40 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 40);
					}
				}
			}
			if (target instanceof Ankylosaurus || target instanceof Sillosuchus || target instanceof Stegosaurus || target instanceof Triceratops) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 60 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 60);
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
			return super.canUse() && Allosaurus.this.getCurrentHunger() <= Allosaurus.this.getHalfHunger() && Allosaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public boolean canContinueToUse() {
			return Allosaurus.this.getCurrentHunger() > Allosaurus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true || !Allosaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Allosaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Allosaurus.this.getTarget();
			if (target instanceof Rabbit) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 3 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof Didelphodon || target instanceof Eilenodon || target instanceof Hyperodapedon || target instanceof Chicken || target instanceof Hesperornithoides || target instanceof Scutellosaurus) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 4 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof Telmasaurus) {
				if (target.getHealth() == 0) {
					if (Allosaurus.this.getCurrentHunger() + 6 >= Allosaurus.this.maxHunger) {
						Allosaurus.this.setHunger(Allosaurus.this.maxHunger);
					} else {
						Allosaurus.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.ALLOSAURUS_SPAWN_EGG.get());
	}

}