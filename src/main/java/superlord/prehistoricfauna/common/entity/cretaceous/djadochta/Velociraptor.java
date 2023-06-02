package superlord.prehistoricfauna.common.entity.cretaceous.djadochta;

import java.util.EnumSet;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
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
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FleeSunGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Mule;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.EntityEvent.Size;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Basilemys;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Didelphodon;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Thescelosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.CrepuscularSleepGoal;
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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Dryosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Eilenodon;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Hesperornithoides;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Coelophysis;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Desmatosuchus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Trilophosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Typothorax;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Chromogisaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Exaeretodon;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Hyperodapedon;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Velociraptor extends DinosaurEntity {
	private static final EntityDataAccessor<Byte> VELOCIRAPTOR_FLAGS = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.BYTE);
	private static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.BYTE);
	private static final Predicate<Entity> IS_PREY = (p_213498_0_) -> {
		return p_213498_0_ instanceof Thescelosaurus || p_213498_0_ instanceof Basilemys || p_213498_0_ instanceof Dryosaurus || p_213498_0_ instanceof Hesperornithoides || p_213498_0_ instanceof Eilenodon || p_213498_0_ instanceof Didelphodon || p_213498_0_ instanceof Horse || p_213498_0_ instanceof Donkey || p_213498_0_ instanceof Mule || p_213498_0_ instanceof Sheep || p_213498_0_ instanceof Cow || p_213498_0_ instanceof Pig || p_213498_0_ instanceof Ocelot || p_213498_0_ instanceof Protoceratops;
	};
	private static final EntityDataAccessor<Boolean> HAS_EGG = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_DIGGING = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALBINO = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MELANISTIC = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_LOVE = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> TAME_SIT = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> TAME_WANDER = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.BOOLEAN);
	private int currentHunger = 20;
	private int maxHunger = 20;
	private int lastInLove = 0;
	int hungerTick = 0;
	private Goal attackAnimals;
	private float interestedAngle;
	private float interestedAngleO;
	private float crouchAmount;
	private float crouchAmountO;
	private int warningSoundTicks;
	private int isDigging;
	private int eatTicks;
	int loveTick = 0;
	private int climbingTicks = 0;
	private int climbingTickCooldown = 0;

	public boolean hasEgg() {
		return this.entityData.get(HAS_EGG);
	}

	private void setHasEgg(boolean hasEgg) {
		this.entityData.set(HAS_EGG, hasEgg);
	}

	public boolean isDigging() {
		return this.entityData.get(IS_DIGGING);
	}

	private void setDigging(boolean isDigging) {
		this.isDigging = isDigging ? 1 : 0;
		this.entityData.set(IS_DIGGING, isDigging);
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

	public boolean isTameSitting() {
		return this.entityData.get(TAME_SIT);
	}

	private void setTameSitting(boolean isTameSitting) {
		this.entityData.set(TAME_SIT, isTameSitting);
	}

	public boolean isTameWandering() {
		return this.entityData.get(TAME_WANDER);
	}

	private void setTameWandering(boolean isTameWandering) {
		this.entityData.set(TAME_WANDER, isTameWandering);
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_SMALL_MARGINOCEPHALIAN_MEAT.get();
	}

	protected PathNavigation createNavigation(Level worldIn) {
		return new WallClimberNavigation(this, worldIn);
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

	public boolean isInLoveNaturally() {
		return this.entityData.get(NATURAL_LOVE);
	}

	private void setInLoveNaturally(boolean isInLoveNaturally) {
		this.entityData.set(NATURAL_LOVE, isInLoveNaturally);
	}

	@SuppressWarnings("deprecation")
	public Velociraptor(EntityType<? extends Velociraptor> type, Level worldIn) {
		super(type, worldIn);
		this.lookControl = new Velociraptor.LookHelperController();
		this.moveControl = new Velociraptor.MoveHelperController();
		this.setPathfindingMalus(BlockPathTypes.DANGER_OTHER, 0.0F);
		this.setPathfindingMalus(BlockPathTypes.DAMAGE_OTHER, 0.0F);
		this.maxUpStep = 1.0F;
	}

	protected float getStandingEyeHeight(Pose poseIn, Size sizeIn) {
		if (this.isBaby()) return 0.4F;
		else return 0.8F;
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(HAS_EGG, false);
		this.entityData.define(IS_DIGGING, false);
		this.entityData.define(VELOCIRAPTOR_FLAGS, (byte)0);
		this.entityData.define(CLIMBING, (byte)0);
		this.entityData.define(ALBINO, false);
		this.entityData.define(MELANISTIC, false);
		this.entityData.define(NATURAL_LOVE, false);
		this.entityData.define(TAME_SIT, false);
		this.entityData.define(TAME_WANDER, false);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void registerGoals() {
		this.attackAnimals = new Velociraptor.TamedHuntGoal(this, Animal.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof Aepyornithomimus || p_213487_0_ instanceof Basilemys || p_213487_0_ instanceof Chromogisaurus || p_213487_0_ instanceof Citipati || p_213487_0_ instanceof Didelphodon || p_213487_0_ instanceof Dryosaurus || p_213487_0_ instanceof Eilenodon || p_213487_0_ instanceof Exaeretodon || p_213487_0_ instanceof Hesperornithoides || p_213487_0_ instanceof Hyperodapedon || p_213487_0_ instanceof Protoceratops || p_213487_0_ instanceof Telmasaurus || p_213487_0_ instanceof Thescelosaurus || p_213487_0_ instanceof Cat || p_213487_0_ instanceof Ocelot || p_213487_0_ instanceof Chicken || p_213487_0_ instanceof Fox || p_213487_0_ instanceof Parrot || p_213487_0_ instanceof Pig || p_213487_0_ instanceof Rabbit || p_213487_0_ instanceof AbstractVillager || p_213487_0_ instanceof WanderingTrader || p_213487_0_ instanceof AbstractIllager || p_213487_0_ instanceof Player || p_213487_0_ instanceof Wolf || p_213487_0_ instanceof Turtle || p_213487_0_ instanceof Kayentatherium || p_213487_0_ instanceof Megapnosaurus || p_213487_0_ instanceof Sarahsaurus || p_213487_0_ instanceof Scelidosaurus || p_213487_0_ instanceof Scutellosaurus || p_213487_0_ instanceof Sheep || p_213487_0_ instanceof Coelophysis || p_213487_0_ instanceof Desmatosuchus || p_213487_0_ instanceof Trilophosaurus || p_213487_0_ instanceof Typothorax;
		});
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Velociraptor.JumpGoal());
		this.goalSelector.addGoal(2, new Velociraptor.PanicGoal());
		this.goalSelector.addGoal(0, new Velociraptor.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Velociraptor.NaturalMateGoal(this, 1.0D));
		this.targetSelector.addGoal(2, new Velociraptor.AttackPlayerGoal());
		this.goalSelector.addGoal(5, new Velociraptor.FollowTargetGoal());
		this.goalSelector.addGoal(1, new Velociraptor.PounceGoal());
		this.goalSelector.addGoal(6, new Velociraptor.FindShelterGoal(1.25D));
		this.goalSelector.addGoal(7, new Velociraptor.BiteGoal((double)1.2F, true));
		this.goalSelector.addGoal(7, new Velociraptor.SleepGoal());
		this.goalSelector.addGoal(8, new Velociraptor.FollowGoal(this, 1.25D));
		this.targetSelector.addGoal(1, new Velociraptor.HurtByTargetGoal());
		this.goalSelector.addGoal(10, new LeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(11, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(13, new Velociraptor.SitAndLookGoal());
		this.goalSelector.addGoal(0, new Velociraptor.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Ankylosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Triceratops.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Tyrannosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Camarasaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Stegosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Allosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Ceratosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Dilophosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.goalSelector.addGoal(6, new VelociraptorFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
		this.goalSelector.addGoal(1, new CrepuscularSleepGoal(this));
		this.targetSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof Aepyornithomimus || p_213487_0_ instanceof Basilemys || p_213487_0_ instanceof Chromogisaurus || p_213487_0_ instanceof Citipati || p_213487_0_ instanceof Didelphodon || p_213487_0_ instanceof Dryosaurus || p_213487_0_ instanceof Eilenodon || p_213487_0_ instanceof Exaeretodon || p_213487_0_ instanceof Hesperornithoides || p_213487_0_ instanceof Hyperodapedon || p_213487_0_ instanceof Protoceratops || p_213487_0_ instanceof Telmasaurus || p_213487_0_ instanceof Thescelosaurus || p_213487_0_ instanceof Cat || p_213487_0_ instanceof Ocelot || p_213487_0_ instanceof Chicken || p_213487_0_ instanceof Fox || p_213487_0_ instanceof Parrot || p_213487_0_ instanceof Pig || p_213487_0_ instanceof Rabbit || p_213487_0_ instanceof AbstractVillager || p_213487_0_ instanceof WanderingTrader || p_213487_0_ instanceof AbstractIllager || p_213487_0_ instanceof Player || p_213487_0_ instanceof Wolf || p_213487_0_ instanceof Turtle || p_213487_0_ instanceof Kayentatherium || p_213487_0_ instanceof Megapnosaurus || p_213487_0_ instanceof Sarahsaurus || p_213487_0_ instanceof Scelidosaurus || p_213487_0_ instanceof Scutellosaurus || p_213487_0_ instanceof Sheep || p_213487_0_ instanceof Coelophysis || p_213487_0_ instanceof Desmatosuchus || p_213487_0_ instanceof Trilophosaurus || p_213487_0_ instanceof Typothorax;
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof Didelphodon || p_213487_1_ instanceof Eilenodon || p_213487_1_ instanceof Hyperodapedon || p_213487_1_ instanceof Telmasaurus || p_213487_1_ instanceof Rabbit || p_213487_1_ instanceof Chicken || p_213487_1_ instanceof Hesperornithoides || p_213487_1_ instanceof Scutellosaurus;
		}));
	}

	public void aiStep() {
		if (!this.level.isClientSide && this.isAlive()) {
			++this.eatTicks;
			ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
			if (this.canEatItem(itemstack)) {
				if (this.eatTicks > 600) {
					ItemStack itemstack1 = itemstack.finishUsingItem(this.level, this);
					if (!itemstack1.isEmpty()) {
						this.setItemSlot(EquipmentSlot.MAINHAND, itemstack1);
					}

					this.eatTicks = 0;
				} else if (this.eatTicks > 560 && this.random.nextFloat() < 0.1F) {
					this.level.broadcastEntityEvent(this, (byte)45);
				}
			}

			LivingEntity livingentity = this.getTarget();
			if (livingentity == null || !livingentity.isAlive()) {
				this.setCrouching(false);
				this.func_213502_u(false);
			}
		}
		if (this.getTarget() != null) {
			if (this.getVehicle() != null) {
				if (this.getVehicle() == this.getTarget() && this.tickCount % 20 == 0) {
					AttributeInstance iattributeinstance = this.getAttribute(Attributes.ATTACK_DAMAGE);
					this.getTarget().hurt(DamageSource.mobAttack(this), (float) iattributeinstance.getBaseValue());
				}
			}
		}

		if (this.isSleeping() || this.isMovementBlocked()) {
			this.jumping = false;
			this.xxa = 0.0F;
			this.zza = 0.0F;
		}

		if (this.isAsleep() || this.isTameSitting()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		}
		super.aiStep();
		if (this.isVelociraptorAggroed() && this.random.nextFloat() < 0.05F) {
		}
		if (!this.isNoAi()) {
			List<? extends Velociraptor> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
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
				} if (this.getCurrentHunger() >= this.getThreeQuartersHunger() && hungerTick % 150 == 0) {
					if (this.getHealth() < this.getMaxHealth() && this.getHealth() != 0 && this.getTarget() == null && this.getLastHurtByMob() == null) {
						float currentHealth = this.getHealth();
						this.setHealth(currentHealth + 1);
					}
				}
				if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
					if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && tickCount % 900 == 0 && !this.isBaby() && !this.isInLove() && !this.isAsleep() && list.size() < 4) {
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
				if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isBaby() && !this.isInLove() && !this.isAsleep() && list.size() < 4) {
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

	@SuppressWarnings("deprecation")
	private boolean canEatItem(ItemStack itemStackIn) {
		return itemStackIn.getItem().isEdible() && itemStackIn.getItem().getFoodProperties().isMeat() && this.getTarget() == null && this.onGround && !this.isSleeping();
	}

	protected boolean isMovementBlocked() {
		return this.getHealth() <= 0.0F;
	}

	public boolean canEquipItem(ItemStack stack) {
		Item item = stack.getItem();
		ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
		return itemstack.isEmpty() || this.eatTicks > 0 && item.isEdible();
	}

	private void spitOutItem(ItemStack stackIn) {
		if (!stackIn.isEmpty() && !this.level.isClientSide) {
			ItemEntity itementity = new ItemEntity(this.level, this.getX() + this.getLookAngle().x, this.getY() + 1.0D, this.getZ() + this.getLookAngle().z, stackIn);
			itementity.setPickUpDelay(40);
			itementity.setThrower(this.getUUID());
			this.level.addFreshEntity(itementity);
		}
	}

	private void dropItemStack(ItemStack stackIn) {
		ItemEntity itementity = new ItemEntity(this.level, this.getX(), this.getY(), this.getZ(), stackIn);
		this.level.addFreshEntity(itementity);
	}

	protected void pickUpItem(ItemEntity item) {
		ItemStack itemstack = item.getItem();
		if (this.canEquipItem(itemstack)) {
			int i = itemstack.getCount();
			if (i > 1) {
				this.dropItemStack(itemstack.split(i - 1));
			}

			this.spitOutItem(this.getItemBySlot(EquipmentSlot.MAINHAND));
			this.setItemSlot(EquipmentSlot.MAINHAND, itemstack.split(1));
			this.handDropChances[EquipmentSlot.MAINHAND.getIndex()] = 2.0F;
			this.take(item, itemstack.getCount());
			item.remove(RemovalReason.DISCARDED);
			this.eatTicks = 0;
		}

	}

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		if (this.random.nextFloat() < 0.2F) {
			float f = this.random.nextFloat();
			ItemStack itemstack;
			if (f < 0.05F) {
				itemstack = new ItemStack(Items.EMERALD);
			} else if (f < 0.2F) {
				itemstack = new ItemStack(Items.EGG);
			} else if (f < 0.4F) {
				itemstack = this.random.nextBoolean() ? new ItemStack(Items.RABBIT_FOOT) : new ItemStack(Items.RABBIT_HIDE);
			} else if (f < 0.6F) {
				itemstack = new ItemStack(Items.WHEAT);
			} else if (f < 0.8F) {
				itemstack = new ItemStack(Items.LEATHER);
			} else {
				itemstack = new ItemStack(Items.FEATHER);
			}

			this.setItemSlot(EquipmentSlot.MAINHAND, itemstack);
		}

	}

	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		if (id == 45) {
			ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
			if (!itemstack.isEmpty()) {
				for(int i = 0; i < 8; ++i) {
					Vec3 vec3d = (new Vec3(((double)this.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D)).xRot(-this.xRot * ((float)Math.PI / 180F)).yRot(-this.yRot * ((float)Math.PI / 180F));
					this.level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, itemstack), this.getX() + this.getLookAngle().x / 2.0D, this.getY(), this.getZ() + this.getLookAngle().z / 2.0D, vec3d.x, vec3d.y + 0.05D, vec3d.z);
				}
			}
		} else {
			super.handleEntityEvent(id);
		}

	}

	@Override
	public void push(Entity entity) {
		super.push(entity);
		if (this.getTarget() != null) {
			if (this.getTarget() == entity && !onGround && this.getVehicle() != entity && !(entity instanceof Player)) {
				this.startRiding(entity);
			}
		}
	}

	@Override
	public boolean hurt(DamageSource dmg, float i) {
		if (this.getVehicle() != null) {
			if (this.getLastHurtMob() != null) {
				if (this.getLastHurtMob() == this.getVehicle()) {
					if (this.getRandom().nextInt(2) == 0) {
						this.stopRiding();
					}
				}
			}
		}
		return super.hurt(dmg, i);
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, this.attackAnimals);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsSleeping", this.isSleeping());
		compound.putBoolean("IsSitting", this.isSitting());
		compound.putBoolean("IsCrouching", this.isCrouching());
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
		compound.putBoolean("IsTamedSitting", this.isTameSitting());
		compound.putBoolean("IsTamedWander", this.isTameWandering());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setSleeping(compound.getBoolean("IsSleeping"));
		this.setSitting(compound.getBoolean("IsSitting"));
		this.setCrouching(compound.getBoolean("IsCrouching"));
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setAttackGoals();
		this.setHunger(compound.getInt("MaxHunger"));
		this.setInLoveNaturally(compound.getBoolean("InNaturalLove"));
		this.setTameSitting(compound.getBoolean("IsTamedSitting"));
		this.setTameWandering(compound.getBoolean("IsTamedWander"));
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

	public boolean isSitting() {
		return this.getVelociraptorFlag(1);
	}

	public void setSitting(boolean p_213466_1_) {
		this.setVelociraptorFlag(1, p_213466_1_);
	}

	public boolean isStuck() {
		return this.getVelociraptorFlag(64);
	}

	private void setStuck(boolean p_213492_1_) {
		this.setVelociraptorFlag(64, p_213492_1_);
	}

	private boolean isVelociraptorAggroed() {
		return this.getVelociraptorFlag(128);
	}

	private void setVelociraptorAggroed(boolean p_213482_1_) {
		this.setVelociraptorFlag(128, p_213482_1_);
	}

	/**
	 * Returns whether player is sleeping or not
	 */
	public boolean isSleeping() {
		return this.getVelociraptorFlag(32);
	}

	public void setSleeping(boolean p_213485_1_) {
		this.setVelociraptorFlag(32, p_213485_1_);
	}

	private void setVelociraptorFlag(int p_213505_1_, boolean p_213505_2_) {
		if (p_213505_2_) {
			this.entityData.set(VELOCIRAPTOR_FLAGS, (byte)(this.entityData.get(VELOCIRAPTOR_FLAGS) | p_213505_1_));
		} else {
			this.entityData.set(VELOCIRAPTOR_FLAGS, (byte)(this.entityData.get(VELOCIRAPTOR_FLAGS) & ~p_213505_1_));
		}

	}

	private boolean getVelociraptorFlag(int p_213507_1_) {
		return (this.entityData.get(VELOCIRAPTOR_FLAGS) & p_213507_1_) != 0;
	}

	public void tick() {
		super.tick();
		if (this.isEffectiveAi()) {
			boolean flag = this.isInWater();
			if (flag || this.getTarget() != null || this.level.isThundering()) {
				this.func_213454_em();
			}

			if (flag || this.isSleeping()) {
				this.setSitting(false);
			}

			if (this.isStuck() && this.level.random.nextFloat() < 0.2F) {
				BlockPos blockpos = new BlockPos(this.position());
				BlockState blockstate = this.level.getBlockState(blockpos);
				this.level.levelEvent(2001, blockpos, Block.getId(blockstate));
			}
		}

		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}

		this.interestedAngleO = this.interestedAngle;
		if (this.func_213467_eg()) {
			this.interestedAngle += (1.0F - this.interestedAngle) * 0.4F;
		} else {
			this.interestedAngle += (0.0F - this.interestedAngle) * 0.4F;
		}

		this.crouchAmountO = this.crouchAmount;
		if (this.isCrouching()) {
			this.crouchAmount += 0.2F;
			if (this.crouchAmount > 3.0F) {
				this.crouchAmount = 3.0F;
			}
		} else {
			this.crouchAmount = 0.0F;
		}

		if (!this.level.isClientSide) {
			if (this.horizontalCollision) {
				Boolean logBlock;
				BlockPos blockpos1 = new BlockPos(this.position().x() + 1, this.position().y() + 1, this.position().z());
				BlockPos blockpos2 = new BlockPos(this.position().x() - 1, this.position().y() + 1, this.position().z());
				BlockPos blockpos3 = new BlockPos(this.position().x(), this.position().y() + 1, this.position().z() + 1);
				BlockPos blockpos4 = new BlockPos(this.position().x(), this.position().y() + 1, this.position().z() - 1);
				BlockState blockstate1 = this.level.getBlockState(blockpos1);
				BlockState blockstate2 = this.level.getBlockState(blockpos2);
				BlockState blockstate3 = this.level.getBlockState(blockpos3);
				BlockState blockstate4 = this.level.getBlockState(blockpos4);
				if (blockstate1.is(BlockTags.LOGS) || blockstate1.is(BlockTags.PLANKS) || blockstate1.is(BlockTags.WOODEN_DOORS) || blockstate1.is(BlockTags.WOODEN_FENCES) || blockstate1.is(BlockTags.WOODEN_SLABS) || blockstate1.is(BlockTags.WOODEN_STAIRS) || blockstate2.is(BlockTags.LOGS) || blockstate2.is(BlockTags.PLANKS) || blockstate2.is(BlockTags.WOODEN_DOORS) || blockstate2.is(BlockTags.WOODEN_FENCES) || blockstate2.is(BlockTags.WOODEN_SLABS) || blockstate2.is(BlockTags.WOODEN_STAIRS)  || blockstate3.is(BlockTags.LOGS) || blockstate3.is(BlockTags.PLANKS) || blockstate3.is(BlockTags.WOODEN_DOORS) || blockstate3.is(BlockTags.WOODEN_FENCES) || blockstate3.is(BlockTags.WOODEN_SLABS) || blockstate3.is(BlockTags.WOODEN_STAIRS) || blockstate4.is(BlockTags.LOGS) || blockstate4.is(BlockTags.PLANKS) || blockstate4.is(BlockTags.WOODEN_DOORS) || blockstate4.is(BlockTags.WOODEN_FENCES) || blockstate4.is(BlockTags.WOODEN_SLABS) || blockstate4.is(BlockTags.WOODEN_STAIRS)) {
					logBlock = true;
					if (climbingTickCooldown == 0 && climbingTicks < 600) {
						this.setBesideClimbableBlock(logBlock);
						climbingTicks++;
					}
					if (climbingTicks >= 599 && climbingTickCooldown <= 300) {
						climbingTickCooldown++;
					}
					if (climbingTickCooldown == 300) {
						climbingTicks = 0;
						climbingTickCooldown = 0;
					}
				}
			}
		}
	}

	public boolean isOnLadder() {
		return this.isBesideClimbableBlock();
	}

	public boolean isBesideClimbableBlock() {
		return (this.entityData.get(CLIMBING) & 1) != 0;
	}

	/**
	 * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if par1 is true or 0x00 if it is
	 * false.
	 */
	public void setBesideClimbableBlock(boolean climbing) {
		byte b0 = this.entityData.get(CLIMBING);
		if (climbing) {
			b0 = (byte)(b0 | 1);
		} else {
			b0 = (byte)(b0 & -2);
		}

		this.entityData.set(CLIMBING, b0);
	}

	public boolean func_213480_dY() {
		return this.getVelociraptorFlag(16);
	}

	public void func_213461_s(boolean p_213461_1_) {
		this.setVelociraptorFlag(16, p_213461_1_);
	}

	public boolean func_213490_ee() {
		return this.crouchAmount == 3.0F;
	}

	public void setCrouching(boolean p_213451_1_) {
		this.setVelociraptorFlag(4, p_213451_1_);
	}

	public boolean isCrouching() {
		return this.getVelociraptorFlag(4);
	}

	public void func_213502_u(boolean p_213502_1_) {
		this.setVelociraptorFlag(8, p_213502_1_);
	}

	public boolean func_213467_eg() {
		return this.getVelociraptorFlag(8);
	}

	@OnlyIn(Dist.CLIENT)
	public float func_213475_v(float p_213475_1_) {
		return Mth.lerp(p_213475_1_, this.interestedAngleO, this.interestedAngle) * 0.11F * (float)Math.PI;
	}

	@OnlyIn(Dist.CLIENT)
	public float func_213503_w(float p_213503_1_) {
		return Mth.lerp(p_213503_1_, this.crouchAmountO, this.crouchAmount);
	}

	public void setTarget(@Nullable LivingEntity entitylivingbaseIn) {
		if (this.isVelociraptorAggroed() && entitylivingbaseIn == null) {
			this.setVelociraptorAggroed(false);
		}

		super.setTarget(entitylivingbaseIn);
	}

	protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
		return Mth.ceil((p_225508_1_ - 5.0F) * p_225508_2_);
	}

	private void func_213454_em() {
		this.setSleeping(false);
	}

	private void func_213499_en() {
		this.func_213502_u(false);
		this.setCrouching(false);
		this.setSitting(false);
		this.setSleeping(false);
		this.setVelociraptorAggroed(false);
		this.setStuck(false);
	}

	private boolean func_213478_eo() {
		return !this.isSleeping() && !this.isSitting() && !this.isStuck();
	}

	protected SoundEvent getAmbientSound()  {
		return this.isAsleep() ? null : PFSounds.VELOCIRAPTOR_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.VELOCIRAPTOR_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.VELOCIRAPTOR_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.VELOCIRAPTOR_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.ATTACK_DAMAGE, 6.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.1D);
	}

	public static boolean func_213481_a(Velociraptor p_213481_0_, LivingEntity p_213481_1_) {
		double d0 = p_213481_1_.getZ() - p_213481_0_.getZ();
		double d1 = p_213481_1_.getX() - p_213481_0_.getX();
		double d2 = d0 / d1;
		for(int j = 0; j < 6; ++j) {
			double d3 = d2 == 0.0D ? 0.0D : d0 * (double)((float)j / 6.0F);
			double d4 = d2 == 0.0D ? d1 * (double)((float)j / 6.0F) : d3 / d2;

			for(int k = 1; k < 4; ++k) {
				if (!p_213481_0_.level.getBlockState(new BlockPos(p_213481_0_.getX() + d4, p_213481_0_.getY() + (double)k, p_213481_0_.getZ() + d3)).getMaterial().isReplaceable()) {
					return false;
				}
			}
		}

		return true;
	}

	public class AlertablePredicate implements Predicate<LivingEntity> {
		public boolean test(LivingEntity p_test_1_) {
			if (p_test_1_ instanceof Velociraptor) {
				return false;
			} else if (!(p_test_1_ instanceof Chicken) && !(p_test_1_ instanceof Rabbit) && !(p_test_1_ instanceof Monster)) {
				if (p_test_1_ instanceof TamableAnimal) {
					return !((TamableAnimal)p_test_1_).isTame();
				} else if (!(p_test_1_ instanceof Player) || !p_test_1_.isSpectator() && !((Player)p_test_1_).isCreative()) {
					return !p_test_1_.isSleeping() && !p_test_1_.isDiscrete();
				} else {
					return false;
				}
			} else {
				return true;
			}
		}
	}

	abstract class BaseGoal extends Goal {
		private final TargetingConditions field_220816_b = TargetingConditions.forCombat().range(12.0D).ignoreLineOfSight().selector(Velociraptor.this.new AlertablePredicate());

		private BaseGoal() {
		}

		protected boolean func_220813_g() {
			BlockPos blockpos = new BlockPos(Velociraptor.this.position());
			return !Velociraptor.this.level.canSeeSky(blockpos) && Velociraptor.this.getWalkTargetValue(blockpos) >= 0.0F;
		}

		protected boolean func_220814_h() {
			return !Velociraptor.this.level.getNearbyEntities(LivingEntity.class, this.field_220816_b, Velociraptor.this, Velociraptor.this.getBoundingBox().inflate(12.0D, 6.0D, 12.0D)).isEmpty();
		}
	}

	class BiteGoal extends MeleeAttackGoal {

		public BiteGoal(double p_i50731_2_, boolean p_i50731_4_) {
			super();
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				this.mob.doHurtTarget(enemy);
			}
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse();
		}

		public void start() {
			Velociraptor.this.func_213502_u(false);
			super.start();
		}

		public boolean canUse() {
			return !Velociraptor.this.isSitting() && !Velociraptor.this.isSleeping() && !Velociraptor.this.isCrouching() && !Velociraptor.this.isStuck() && super.canUse();
		}
	}

	class FindShelterGoal extends FleeSunGoal {
		private int cooldown = 100;

		public FindShelterGoal(double p_i50724_2_) {
			super(Velociraptor.this, p_i50724_2_);
		}

		public boolean canUse() {
			if (!Velociraptor.this.isSleeping() && this.mob.getTarget() == null) {
				if (Velociraptor.this.level.isThundering()) {
					return true;
				} else if (this.cooldown > 0) {
					--this.cooldown;
					return false;
				} else {
					this.cooldown = 100;
					BlockPos blockpos = new BlockPos(this.mob.position());
					return Velociraptor.this.level.isDay() && Velociraptor.this.level.canSeeSky(blockpos) && !((ServerLevel)Velociraptor.this.level).isVillage(blockpos) && this.setWantedPos();
				}
			} else {
				return false;
			}
		}

		public void start() {
			Velociraptor.this.func_213499_en();
			super.start();
		}
	}

	class FollowGoal extends FollowParentGoal {
		private final Velociraptor owner;

		public FollowGoal(Velociraptor p_i50735_2_, double p_i50735_3_) {
			super(p_i50735_2_, p_i50735_3_);
			this.owner = p_i50735_2_;
		}

		public boolean canUse() {
			return !this.owner.isVelociraptorAggroed() && super.canUse();
		}

		public boolean canContinueToUse() {
			return !this.owner.isVelociraptorAggroed() && super.canContinueToUse();
		}

		public void start() {
			this.owner.func_213499_en();
			super.start();
		}
	}

	class FollowTargetGoal extends Goal {
		public FollowTargetGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		public boolean canUse() {
			if (Velociraptor.this.isSleeping()) {
				return false;
			} else {
				LivingEntity livingentity = Velociraptor.this.getTarget();
				return livingentity != null && livingentity.isAlive() && Velociraptor.IS_PREY.test(livingentity) && Velociraptor.this.distanceToSqr(livingentity) > 36.0D && !Velociraptor.this.isCrouching() && !Velociraptor.this.func_213467_eg() && !Velociraptor.this.jumping;
			}
		}

		public void start() {
			Velociraptor.this.setSitting(false);
			Velociraptor.this.setStuck(false);
		}

		public void stop() {
			LivingEntity livingentity = Velociraptor.this.getTarget();
			if (livingentity != null && Velociraptor.func_213481_a(Velociraptor.this, livingentity)) {
				Velociraptor.this.func_213502_u(true);
				Velociraptor.this.setCrouching(true);
				Velociraptor.this.getNavigation().stop();
				Velociraptor.this.getLookControl().setLookAt(livingentity, (float)Velociraptor.this.getMaxHeadYRot(), (float)Velociraptor.this.getMaxHeadXRot());
			} else {
				Velociraptor.this.func_213502_u(false);
				Velociraptor.this.setCrouching(false);
			}

		}

		public void tick() {
			LivingEntity livingentity = Velociraptor.this.getTarget();
			Velociraptor.this.getLookControl().setLookAt(livingentity, (float)Velociraptor.this.getMaxHeadYRot(), (float)Velociraptor.this.getMaxHeadXRot());
			if (Velociraptor.this.distanceToSqr(livingentity) <= 36.0D) {
				Velociraptor.this.func_213502_u(true);
				Velociraptor.this.setCrouching(true);
				Velociraptor.this.getNavigation().stop();
			} else {
				Velociraptor.this.getNavigation().moveTo(livingentity, 1.5D);
			}

		}
	}

	class JumpGoal extends Goal {
		int delay;

		public JumpGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.JUMP, Goal.Flag.MOVE));
		}

		public boolean canUse() {
			return Velociraptor.this.isStuck();
		}

		public boolean canContinueToUse() {
			return this.canUse() && this.delay > 0;
		}

		public void start() {
			this.delay = 40;
		}

		public void stop() {
			Velociraptor.this.setStuck(false);
		}

		public void tick() {
			--this.delay;
		}
	}

	public class LookHelperController extends LookControl {
		public LookHelperController() {
			super(Velociraptor.this);
		}

		public void tick() {
			if (!Velociraptor.this.isSleeping()) {
				super.tick();
			}

		}

		protected boolean func_220680_b() {
			return !Velociraptor.this.func_213480_dY() && !Velociraptor.this.isCrouching() && !Velociraptor.this.func_213467_eg() & !Velociraptor.this.isStuck();
		}
	}

	class MoveHelperController extends MoveControl {
		public MoveHelperController() {
			super(Velociraptor.this);
		}

		public void tick() {
			if (Velociraptor.this.func_213478_eo()) {
				super.tick();
			}

		}
	}

	public class PounceGoal extends net.minecraft.world.entity.ai.goal.JumpGoal {
		public boolean canUse() {
			if (!Velociraptor.this.func_213490_ee()) {
				return false;
			} else {
				LivingEntity livingentity = Velociraptor.this.getTarget();
				if (livingentity != null && livingentity.isAlive()) {
					if (livingentity.getMotionDirection() != livingentity.getDirection()) {
						return false;
					} else {
						boolean flag = Velociraptor.func_213481_a(Velociraptor.this, livingentity);
						if (!flag) {
							Velociraptor.this.getNavigation().createPath(livingentity, 0);
							Velociraptor.this.setCrouching(false);
							Velociraptor.this.func_213502_u(false);
						}

						return flag;
					}
				} else {
					return false;
				}
			}
		}

		public boolean canContinueToUse() {
			LivingEntity livingentity = Velociraptor.this.getTarget();
			if (livingentity != null && livingentity.isAlive()) {
				double d0 = Velociraptor.this.getDeltaMovement().y;
				return (!(d0 * d0 < (double)0.05F) || !(Math.abs(Velociraptor.this.xRot) < 15.0F) || !Velociraptor.this.onGround) && !Velociraptor.this.isStuck();
			} else {
				return false;
			}
		}

		public boolean isPreemptible() {
			return false;
		}

		public void start() {
			Velociraptor.this.setJumping(true);
			Velociraptor.this.func_213461_s(true);
			Velociraptor.this.func_213502_u(false);
			LivingEntity livingentity = Velociraptor.this.getTarget();
			Velociraptor.this.getLookControl().setLookAt(livingentity, 60.0F, 30.0F);
			Vec3 vec3d = (new Vec3(livingentity.getX() - Velociraptor.this.getX(), livingentity.getY() - Velociraptor.this.getY(), livingentity.getZ() - Velociraptor.this.getZ())).normalize();
			Velociraptor.this.setDeltaMovement(Velociraptor.this.getDeltaMovement().add(vec3d.x * 0.8D, 0.5D, vec3d.z * 0.8D));
			Velociraptor.this.getNavigation().stop();
		}

		public void stop() {
			Velociraptor.this.setCrouching(false);
			Velociraptor.this.crouchAmount = 0.0F;
			Velociraptor.this.crouchAmountO = 0.0F;
			Velociraptor.this.func_213502_u(false);
			Velociraptor.this.func_213461_s(false);
		}

		public void tick() {
			LivingEntity livingentity = Velociraptor.this.getTarget();
			if (livingentity != null) {
				Velociraptor.this.getLookControl().setLookAt(livingentity, 60.0F, 30.0F);
			}

			if (!Velociraptor.this.isStuck()) {
				Vec3 vec3d = Velociraptor.this.getDeltaMovement();
				if (vec3d.y * vec3d.y < (double)0.03F && Velociraptor.this.xRot != 0.0F) {
					Velociraptor.this.xRot = Mth.rotLerp(Velociraptor.this.xRot, 0.0F, 0.2F);
				} else {
					double d0 = vec3d.horizontalDistance();
					double d1 = Math.signum(-vec3d.y) * Math.acos(d0 / vec3d.length()) * (double)(180F / (float)Math.PI);
					Velociraptor.this.xRot = (float)d1;
				}
			}

			if (livingentity != null && Velociraptor.this.distanceTo(livingentity) <= 2.0F) {
				Velociraptor.this.doHurtTarget(livingentity);
			} else if (Velociraptor.this.xRot > 0.0F && Velociraptor.this.onGround && (float)Velociraptor.this.getDeltaMovement().y != 0.0F && Velociraptor.this.level.getBlockState(new BlockPos(Velociraptor.this.position())).getBlock() == Blocks.SNOW) {
				Velociraptor.this.xRot = 60.0F;
				Velociraptor.this.setTarget((LivingEntity)null);
			}

		}
	}

	class PanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(Velociraptor.this, 2.0D);
		}

		public boolean canUse() {
			return !Velociraptor.this.isBaby() && !Velociraptor.this.isOnFire() ? false : super.canUse();
		}

	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Velociraptor velociraptor;

		LayEggGoal(Velociraptor velociraptor, double speed) {
			super(velociraptor, speed, 16);
			this.velociraptor = velociraptor;
		}

		public boolean canUse() {
			return this.velociraptor.hasEgg() ? super.canUse() : false;
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && velociraptor.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.velociraptor.position());
			if (!this.velociraptor.isInWater() && this.isReachedTarget()) {
				if (this.velociraptor.isDigging < 1) {
					this.velociraptor.setDigging(true);
				} else if (this.velociraptor.isDigging > 200) {
					Level world = this.velociraptor.level;
					world.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
					world.setBlock(this.blockPos.above(), PFBlocks.VELOCIRAPTOR_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.velociraptor.random.nextInt(4) + 1)), 3);
					this.velociraptor.setHasEgg(false);
					this.velociraptor.setDigging(false);
					this.velociraptor.setInLoveTime(600);
				}
				if (this.velociraptor.isDigging()) {
					this.velociraptor.isDigging++;
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
		private final Velociraptor velociraptor;

		MateGoal(Velociraptor velociraptor, double speed) {
			super(velociraptor, speed);
			this.velociraptor = velociraptor;
		}

		public boolean canUse() {
			return super.canUse() && !this.velociraptor.hasEgg() && !this.velociraptor.isInLoveNaturally();
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
			this.velociraptor.setHasEgg(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}

	}

	static class NaturalMateGoal extends BreedGoal {
		private final Velociraptor velociraptor;

		NaturalMateGoal(Velociraptor velociraptor, double speed) {
			super(velociraptor, speed);
			this.velociraptor = velociraptor;
		}

		public boolean canUse() {
			return super.canUse() && !this.velociraptor.hasEgg() && this.velociraptor.getCurrentHunger() >= this.velociraptor.getThreeQuartersHunger() && this.velociraptor.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.velociraptor.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.velociraptor.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.velociraptor.random.nextFloat() - this.velociraptor.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.velociraptor.random.nextInt(4);
				if (eggAmount == 0) {
					this.velociraptor.spawnAtLocation(PFBlocks.VELOCIRAPTOR_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.velociraptor.spawnAtLocation(PFBlocks.VELOCIRAPTOR_EGG.get().asItem());
					this.velociraptor.spawnAtLocation(PFBlocks.VELOCIRAPTOR_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.velociraptor.spawnAtLocation(PFBlocks.VELOCIRAPTOR_EGG.get().asItem());
					this.velociraptor.spawnAtLocation(PFBlocks.VELOCIRAPTOR_EGG.get().asItem());
					this.velociraptor.spawnAtLocation(PFBlocks.VELOCIRAPTOR_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.velociraptor.spawnAtLocation(PFBlocks.VELOCIRAPTOR_EGG.get().asItem());
					this.velociraptor.spawnAtLocation(PFBlocks.VELOCIRAPTOR_EGG.get().asItem());
					this.velociraptor.spawnAtLocation(PFBlocks.VELOCIRAPTOR_EGG.get().asItem());
					this.velociraptor.spawnAtLocation(PFBlocks.VELOCIRAPTOR_EGG.get().asItem());
				}
			} else {
				this.velociraptor.setHasEgg(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	class SitAndLookGoal extends Velociraptor.BaseGoal {
		private double field_220819_c;
		private double field_220820_d;
		private int field_220821_e;
		private int field_220822_f;

		public SitAndLookGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		public boolean canUse() {
			return Velociraptor.this.getLastHurtByMob() == null && Velociraptor.this.getRandom().nextFloat() < 0.02F && !Velociraptor.this.isSleeping() && Velociraptor.this.getTarget() == null && Velociraptor.this.getNavigation().isDone() && !this.func_220814_h() && !Velociraptor.this.func_213480_dY() && !Velociraptor.this.isCrouching() && !Velociraptor.this.isAsleep();
		}

		public boolean canContinueToUse() {
			return this.field_220822_f > 0;
		}

		public void start() {
			this.func_220817_j();
			this.field_220822_f = 2 + Velociraptor.this.getRandom().nextInt(3);
			Velociraptor.this.setSitting(true);
			Velociraptor.this.getNavigation().stop();
		}

		public void stop() {
			Velociraptor.this.setSitting(false);
		}

		public void tick() {
			--this.field_220821_e;
			if (this.field_220821_e <= 0) {
				--this.field_220822_f;
				this.func_220817_j();
			}

			Velociraptor.this.getLookControl().setLookAt(Velociraptor.this.getX() + this.field_220819_c, Velociraptor.this.getEyeY(), Velociraptor.this.getZ() + this.field_220820_d, (float)Velociraptor.this.getMaxHeadYRot(), (float)Velociraptor.this.getMaxHeadXRot());
		}

		private void func_220817_j() {
			double d0 = (Math.PI * 2D) * Velociraptor.this.getRandom().nextDouble();
			this.field_220819_c = Math.cos(d0);
			this.field_220820_d = Math.sin(d0);
			this.field_220821_e = 80 + Velociraptor.this.getRandom().nextInt(20);
		}
	}

	class SleepGoal extends Velociraptor.BaseGoal {
		private int field_220825_c = Velociraptor.this.random.nextInt(140);

		public SleepGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
		}

		public boolean canUse() {
			if (Velociraptor.this.xxa == 0.0F && Velociraptor.this.yya == 0.0F && Velociraptor.this.zza == 0.0F && !PrehistoricFaunaConfig.sleeping) {
				return this.func_220823_j() || Velociraptor.this.isSleeping();
			} else {
				return false;
			}
		}

		public boolean canContinueToUse() {
			return this.func_220823_j();
		}

		private boolean func_220823_j() {
			if (this.field_220825_c > 0) {
				--this.field_220825_c;
				return false;
			} else {
				return Velociraptor.this.level.isDay() && this.func_220813_g() && !this.func_220814_h();
			}
		}

		public void stop() {
			this.field_220825_c = Velociraptor.this.random.nextInt(140);
			Velociraptor.this.func_213499_en();
		}

		public void start() {
			Velociraptor.this.setSitting(false);
			Velociraptor.this.setCrouching(false);
			Velociraptor.this.func_213502_u(false);
			Velociraptor.this.setJumping(false);
			Velociraptor.this.setSleeping(true);
			Velociraptor.this.getNavigation().stop();
			Velociraptor.this.getMoveControl().setWantedPosition(Velociraptor.this.getX(), Velociraptor.this.getY(), Velociraptor.this.getZ(), 0.0D);
		}
	}

	class WatchGoal extends LookAtPlayerGoal {
		public WatchGoal(Mob p_i50733_2_, Class<? extends LivingEntity> p_i50733_3_, float p_i50733_4_) {
			super(p_i50733_2_, p_i50733_3_, p_i50733_4_);
		}

		public boolean canUse() {
			return super.canUse() && !Velociraptor.this.isStuck() && !Velociraptor.this.func_213467_eg();
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && !Velociraptor.this.isStuck() && !Velociraptor.this.func_213467_eg();
		}
	}

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(Velociraptor.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		@SuppressWarnings({"unused"})
		public boolean canUse() {
			if (Velociraptor.this.isBaby()) {
				return false;
			} else {
				if (super.canUse() && !Velociraptor.this.isTame()) {
					for (Velociraptor velociraptor : Velociraptor.this.level.getEntitiesOfClass(Velociraptor.class, Velociraptor.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (Velociraptor.this.isBaby()) {
							return true;
						}
					}
				}
			}
			return false;
		}

		protected double getFollowDistance() {
			return super.getFollowDistance() * 0.5D;
		}

	}

	class HurtByTargetGoal extends net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(Velociraptor.this);
		}

		public void start() {
			super.start();
			if(Velociraptor.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}
		}

		protected void alertOther(Mob entity, LivingEntity target) {
			if (entity instanceof Velociraptor && !entity.isBaby()) {
				super.alertOther(entity, target);
			}
		}

	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Velociraptor.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}

				if (this.getTicksUntilNextAttack() <= 10) {
					Velociraptor.this.playWarningSound();
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
			return (double)(5.0F + attackTarget.getBbWidth());
		}
	}

	public boolean doHurtTarget(Entity entity) {
		boolean flag = super.doHurtTarget(entity);
		if (flag) {
			this.doEnchantDamageEffects(this, entity);
		}
		return flag;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Velociraptor entity = new Velociraptor(PFEntities.VELOCIRAPTOR.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	class TamedHuntGoal extends HuntGoal {

		@SuppressWarnings("rawtypes")
		public TamedHuntGoal(Mob goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, Predicate targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnlyIn, targetPredicate);
		}

		public boolean canUse() {
			return super.canUse() && !Velociraptor.this.isTame() && !PrehistoricFaunaConfig.advancedHunger && !Velociraptor.this.isSleeping();
		}

	}

	@SuppressWarnings("deprecation")
	public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {
		ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
		Item item = itemstack.getItem();
		if (this.level.isClientSide) {
			boolean flag = this.isOwnedBy(p_230254_1_) || this.isTame() || item == Items.BONE && !this.isTame() && this.getTarget() == null;
			return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
					if (!p_230254_1_.getAbilities().instabuild) {
						itemstack.shrink(1);
					}

					this.heal((float)item.getFoodProperties().getNutrition());
					return InteractionResult.SUCCESS;
				} else if (this.isFood(itemstack) && this.getHealth() >= this.getMaxHealth()) {
					return InteractionResult.PASS;
				} else if (this.isTameSitting()) {
					this.setTameSitting(false);
					this.setTameWandering(true);
					p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.velociraptor.wandering"), true);
				} else if(this.isTameWandering()) {
					this.setTameWandering(false);
					p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.velociraptor.following"), true);
				} else {
					this.setTameSitting(true);
					p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.velociraptor.sitting"), true);
				}
			} else if (item == PFItems.RAW_SMALL_MARGINOCEPHALIAN_MEAT.get()) {
				if (!p_230254_1_.getAbilities().instabuild) {
					itemstack.shrink(1);
				}

				if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_230254_1_)) {
					this.tame(p_230254_1_);
					this.navigation.stop();
					this.setTarget((LivingEntity)null);
					this.setOrderedToSit(true);
					this.level.broadcastEntityEvent(this, (byte)7);
				} else {
					this.level.broadcastEntityEvent(this, (byte)6);
				}

				return InteractionResult.SUCCESS;
			}

			return super.mobInteract(p_230254_1_, p_230254_2_);
		}
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
			return super.canUse() && Velociraptor.this.getCurrentHunger() <= Velociraptor.this.getHalfHunger() && !Velociraptor.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public boolean canContinueToUse() {
			return Velociraptor.this.getCurrentHunger() < Velociraptor.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Velociraptor.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Velociraptor.this.getTarget();
			if (target instanceof Rabbit) {
				if (target.getHealth() == 0) {
					if (Velociraptor.this.getCurrentHunger() + 3 >= Velociraptor.this.maxHunger) {
						Velociraptor.this.setHunger(Velociraptor.this.maxHunger);
					} else {
						Velociraptor.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof Didelphodon || target instanceof Eilenodon || target instanceof Hesperornithoides || target instanceof Hyperodapedon || target instanceof Chicken || target instanceof Scutellosaurus) {
				if (target.getHealth() == 0) {
					if (Velociraptor.this.getCurrentHunger() + 4 >= Velociraptor.this.maxHunger) {
						Velociraptor.this.setHunger(Velociraptor.this.maxHunger);
					} else {
						Velociraptor.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof Chromogisaurus || target instanceof Telmasaurus || target instanceof Parrot || target instanceof Kayentatherium || target instanceof Megapnosaurus) {
				if (target.getHealth() == 0) {
					if (Velociraptor.this.getCurrentHunger() + 6 >= Velociraptor.this.maxHunger) {
						Velociraptor.this.setHunger(Velociraptor.this.maxHunger);
					} else {
						Velociraptor.this.setHunger(currentHunger + 6);
					}
				}
			}
			if (target instanceof Basilemys || target instanceof Exaeretodon || target instanceof Wolf || target instanceof Sheep) {
				if (target.getHealth() == 0) {
					if (Velociraptor.this.getCurrentHunger() + 8 >= Velociraptor.this.maxHunger) {
						Velociraptor.this.setHunger(Velociraptor.this.maxHunger);
					} else {
						Velociraptor.this.setHunger(currentHunger + 8);
					}
				}
			}
			if (target instanceof Cat || target instanceof Fox || target instanceof Pig || target instanceof Ocelot || target instanceof Trilophosaurus || target instanceof Typothorax || target instanceof Aepyornithomimus || target instanceof Protoceratops || target instanceof Coelophysis) {
				if (target.getHealth() == 0) {
					if (Velociraptor.this.getCurrentHunger() + 10 >= Velociraptor.this.maxHunger) {
						Velociraptor.this.setHunger(Velociraptor.this.maxHunger);
					} else {
						Velociraptor.this.setHunger(currentHunger + 10);
					}
				}
			}
			if (target instanceof Citipati || target instanceof Dryosaurus || target instanceof Thescelosaurus || target instanceof Sarahsaurus || target instanceof Scelidosaurus) {
				if (target.getHealth() == 0) {
					if (Velociraptor.this.getCurrentHunger() + 15 >= Velociraptor.this.maxHunger) {
						Velociraptor.this.setHunger(Velociraptor.this.maxHunger);
					} else {
						Velociraptor.this.setHunger(currentHunger + 15);
					}
				}
			}
			if (target instanceof WanderingTrader || target instanceof Player || target instanceof AbstractVillager || target instanceof AbstractIllager || target instanceof Desmatosuchus) {
				if (target.getHealth() == 0) {
					if (Velociraptor.this.getCurrentHunger() + 20 >= Velociraptor.this.maxHunger) {
						Velociraptor.this.setHunger(Velociraptor.this.maxHunger);
					} else {
						Velociraptor.this.setHunger(currentHunger + 20);
					}
				}
			}
			if (target instanceof Turtle) {
				if (target.getHealth() == 0) {
					if (Velociraptor.this.getCurrentHunger() + 30 >= Velociraptor.this.maxHunger) {
						Velociraptor.this.setHunger(Velociraptor.this.maxHunger);
					} else {
						Velociraptor.this.setHunger(currentHunger + 30);
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
			return super.canUse() && Velociraptor.this.getCurrentHunger() <= Velociraptor.this.getHalfHunger() && Velociraptor.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public boolean canContinueToUse() {
			return Velociraptor.this.getCurrentHunger() < Velociraptor.this.maxHunger || !Velociraptor.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Velociraptor.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Velociraptor.this.getTarget();
			if (target instanceof Rabbit) {
				if (target.getHealth() == 0) {
					if (Velociraptor.this.getCurrentHunger() + 3 >= Velociraptor.this.maxHunger) {
						Velociraptor.this.setHunger(Velociraptor.this.maxHunger);
					} else {
						Velociraptor.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof Didelphodon || target instanceof Eilenodon || target instanceof Hyperodapedon || target instanceof Chicken || target instanceof Hesperornithoides || target instanceof Scutellosaurus) {
				if (target.getHealth() == 0) {
					if (Velociraptor.this.getCurrentHunger() + 4 >= Velociraptor.this.maxHunger) {
						Velociraptor.this.setHunger(Velociraptor.this.maxHunger);
					} else {
						Velociraptor.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof Telmasaurus) {
				if (target.getHealth() == 0) {
					if (Velociraptor.this.getCurrentHunger() + 6 >= Velociraptor.this.maxHunger) {
						Velociraptor.this.setHunger(Velociraptor.this.maxHunger);
					} else {
						Velociraptor.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}

	public class VelociraptorFollowOwnerGoal extends FollowOwnerGoal {

		public VelociraptorFollowOwnerGoal(TamableAnimal tameable, double speed, float minDist, float maxDist,
				boolean teleportToLeaves) {
			super(tameable, speed, minDist, maxDist, teleportToLeaves);
		}

		public boolean canUse() {
			return super.canUse() && !Velociraptor.this.isTameWandering() && !Velociraptor.this.isTameSitting();
		}

	}

	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.VELOCIRAPTOR_SPAWN_EGG.get());
	}

}