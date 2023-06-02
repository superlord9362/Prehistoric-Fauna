package superlord.prehistoricfauna.common.entity.jurassic.kayenta;

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
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
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
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.BreathAirGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.animal.Ocelot;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Salmon;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.Tags;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Aepyornithomimus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Protoceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Telmasaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Velociraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Basilemys;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Didelphodon;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Thescelosaurus;
import superlord.prehistoricfauna.common.entity.fish.Arganodus;
import superlord.prehistoricfauna.common.entity.fish.Ceratodus;
import superlord.prehistoricfauna.common.entity.fish.Chinlea;
import superlord.prehistoricfauna.common.entity.fish.Cyclurus;
import superlord.prehistoricfauna.common.entity.fish.Gar;
import superlord.prehistoricfauna.common.entity.fish.Mooreodontus;
import superlord.prehistoricfauna.common.entity.fish.Myledaphus;
import superlord.prehistoricfauna.common.entity.fish.Potamoceratodus;
import superlord.prehistoricfauna.common.entity.fish.Saurichthys;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Dryosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Eilenodon;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Hesperornithoides;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Chromogisaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Exaeretodon;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Hyperodapedon;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Calsoyasuchus extends DinosaurEntity {

	private static final EntityDataAccessor<Boolean> HAS_EGG = SynchedEntityData.defineId(Calsoyasuchus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_DIGGING = SynchedEntityData.defineId(Calsoyasuchus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALBINO = SynchedEntityData.defineId(Calsoyasuchus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MELANISTIC = SynchedEntityData.defineId(Calsoyasuchus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_LOVE = SynchedEntityData.defineId(Calsoyasuchus.class, EntityDataSerializers.BOOLEAN);
	private int maxHunger = 15;
	private int currentHunger = 15;
	int hungerTick = 0;
	private int lastInLove = 0;
	private int warningSoundTicks;
	private int isDigging;
	int loveTick = 0;

	@SuppressWarnings("deprecation")
	public Calsoyasuchus(EntityType<? extends DinosaurEntity> type, Level worldIn) {
		super(type, worldIn);
		this.moveControl = new Calsoyasuchus.MoveHelperController(this);
		this.maxUpStep = 1.0F;
	}

	public boolean isDigging() {
		return this.getEntityData().get(IS_DIGGING);
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.15F;
		else return 0.3F;
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
		this.setHunger(50);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public int getMaxAir() {
		return 4800;
	}

	protected int determineNextAir(int currentAir) {
		return this.getMaxAir();
	}

	protected float getWaterSlowDown() {
		return 1F;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.CERATODUS.get();
	}

	class WalkAndSwimPathNavigator extends WaterBoundPathNavigation {

		WalkAndSwimPathNavigator(Calsoyasuchus calsoyasuchus, Level world) {
			super(calsoyasuchus, world);
		}

		protected boolean canNavigate() {
			return true;
		}

		protected PathFinder getPathFinder(int uncategorizedNumber) {
			this.nodeEvaluator = new AmphibiousNodeEvaluator(true);
			return new PathFinder(this.nodeEvaluator, uncategorizedNumber);
		}

		public boolean canStandOnPos(BlockPos pos) {
			return !this.level.getBlockState(pos.below()).isAir();
		}

	}

	static class MoveHelperController extends MoveControl {
		private final Calsoyasuchus calsoyasuchus;

		MoveHelperController(Calsoyasuchus calsoyasuchus) {
			super(calsoyasuchus);
			this.calsoyasuchus = calsoyasuchus;
		}

		public void tick() {
			if (this.calsoyasuchus.isEyeInFluid(FluidTags.WATER)) {
				this.calsoyasuchus.setDeltaMovement(this.calsoyasuchus.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
			}
			if (this.operation == MoveControl.Operation.MOVE_TO && !this.calsoyasuchus.getNavigation().isDone()) {
				float f = (float)(this.speedModifier * this.calsoyasuchus.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.calsoyasuchus.setSpeed(Mth.lerp(0.125F, this.calsoyasuchus.getSpeed(), f));
				double d0 = this.wantedX - this.calsoyasuchus.getX();
				double d1 = this.wantedY - this.calsoyasuchus.getY();
				double d2 = this.wantedZ - this.calsoyasuchus.getZ();
				if (d1 != 0.0D) {
					double d3 = (double)Mth.sqrt((float) (d0 * d0 + d1 * d1 + d2 * d2));
					this.calsoyasuchus.setDeltaMovement(this.calsoyasuchus.getDeltaMovement().add(0.0D, (double)this.calsoyasuchus.getSpeed() * (d1 / d3) * 0.1D, 0.0D));
				}
				if (d0 != 0.0D || d2 != 0.0D) {
					float f1 = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
					this.calsoyasuchus.xRot = this.rotlerp(this.calsoyasuchus.xRot, f1, 90.0F);
					this.calsoyasuchus.xRotO = this.calsoyasuchus.xRot;
				}
			} else {
				this.calsoyasuchus.setSpeed(0.0F);
			}
		}

	}

	protected PathNavigation createNavigation(Level world) {
		return new Calsoyasuchus.WalkAndSwimPathNavigator(this, world);
	}

	protected boolean func_212800_dy() {
		return true;
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(1, new Calsoyasuchus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Calsoyasuchus.PanicGoal());
		this.targetSelector.addGoal(1, new Calsoyasuchus.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Calsoyasuchus.AttackPlayerGoal());
		this.targetSelector.addGoal(2, new Calsoyasuchus.TerritoryAttackGoal());
		this.goalSelector.addGoal(0, new Calsoyasuchus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Calsoyasuchus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(0, new Calsoyasuchus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new BreathAirGoal(this));
		this.goalSelector.addGoal(3, new Calsoyasuchus.SwimGoal(this));
		this.goalSelector.addGoal(0, new Calsoyasuchus.CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof Rabbit || p_213487_1_ instanceof Hyperodapedon || p_213487_1_ instanceof Hesperornithoides || p_213487_1_ instanceof Eilenodon || p_213487_1_ instanceof Scutellosaurus || p_213487_1_ instanceof Chicken || p_213487_1_ instanceof Basilemys || p_213487_1_ instanceof Chromogisaurus || p_213487_1_ instanceof Exaeretodon || p_213487_1_ instanceof Telmasaurus || p_213487_1_ instanceof Kayentatherium || p_213487_1_ instanceof Megapnosaurus || p_213487_1_ instanceof Velociraptor || p_213487_1_ instanceof Wolf || p_213487_1_ instanceof Arganodus || p_213487_1_ instanceof Ceratodus || p_213487_1_ instanceof Chinlea || p_213487_1_ instanceof Cyclurus || p_213487_1_ instanceof Mooreodontus || p_213487_1_ instanceof Myledaphus || p_213487_1_ instanceof Potamoceratodus || p_213487_1_ instanceof Saurichthys || p_213487_1_ instanceof Cat || p_213487_1_ instanceof Fox || p_213487_1_ instanceof Cow || p_213487_1_ instanceof MushroomCow || p_213487_1_ instanceof Pig || p_213487_1_ instanceof Ocelot || p_213487_1_ instanceof Aepyornithomimus || p_213487_1_ instanceof Dryosaurus || p_213487_1_ instanceof Protoceratops || p_213487_1_ instanceof Thescelosaurus || p_213487_1_ instanceof Sarahsaurus || p_213487_1_ instanceof Cod || p_213487_1_ instanceof Salmon || p_213487_1_ instanceof TropicalFish;
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof Didelphodon || p_213487_1_ instanceof Eilenodon || p_213487_1_ instanceof Hyperodapedon || p_213487_1_ instanceof Telmasaurus || p_213487_1_ instanceof Rabbit || p_213487_1_ instanceof Chicken || p_213487_1_ instanceof Hesperornithoides || p_213487_1_ instanceof Scutellosaurus || p_213487_1_ instanceof Cod || p_213487_1_ instanceof Salmon || p_213487_1_ instanceof TropicalFish || p_213487_1_ instanceof Arganodus || p_213487_1_ instanceof Ceratodus || p_213487_1_ instanceof Chinlea || p_213487_1_ instanceof Cyclurus || p_213487_1_ instanceof Mooreodontus || p_213487_1_ instanceof Myledaphus || p_213487_1_ instanceof Potamoceratodus || p_213487_1_ instanceof Saurichthys;
		}));
		this.targetSelector.addGoal(1, new HuntGoal(this, Animal.class, 10, true, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof Rabbit || p_213487_1_ instanceof Hyperodapedon || p_213487_1_ instanceof Hesperornithoides || p_213487_1_ instanceof Eilenodon || p_213487_1_ instanceof Scutellosaurus || p_213487_1_ instanceof Chicken || p_213487_1_ instanceof Basilemys || p_213487_1_ instanceof Chromogisaurus || p_213487_1_ instanceof Exaeretodon || p_213487_1_ instanceof Telmasaurus || p_213487_1_ instanceof Kayentatherium || p_213487_1_ instanceof Megapnosaurus || p_213487_1_ instanceof Velociraptor || p_213487_1_ instanceof Wolf || p_213487_1_ instanceof Arganodus || p_213487_1_ instanceof Ceratodus || p_213487_1_ instanceof Chinlea || p_213487_1_ instanceof Cyclurus || p_213487_1_ instanceof Mooreodontus || p_213487_1_ instanceof Myledaphus || p_213487_1_ instanceof Potamoceratodus || p_213487_1_ instanceof Saurichthys || p_213487_1_ instanceof Cat || p_213487_1_ instanceof Fox || p_213487_1_ instanceof Cow || p_213487_1_ instanceof MushroomCow || p_213487_1_ instanceof Pig || p_213487_1_ instanceof Ocelot || p_213487_1_ instanceof Aepyornithomimus || p_213487_1_ instanceof Dryosaurus || p_213487_1_ instanceof Protoceratops || p_213487_1_ instanceof Thescelosaurus || p_213487_1_ instanceof Sarahsaurus || p_213487_1_ instanceof Cod || p_213487_1_ instanceof Salmon || p_213487_1_ instanceof TropicalFish;
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
			List<? extends Calsoyasuchus> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
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

	public static boolean canDinosaurSpawn(EntityType<? extends Animal> animal,  LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, Random random) {
		return (worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) || worldIn.getBlockState(pos).is(Blocks.WATER) || worldIn.getBlockState(pos.below()).is(Tags.Blocks.SAND)) && worldIn.getRawBrightness(pos, 0) > 8;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 3.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.CALSOYASUCHUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.CALSOYASUCHUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.CALSOYASUCHUS_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.CALSOYASUCHUS_WARN, 1.0F, this.getVoicePitch());
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
			super(Calsoyasuchus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean canUse() {
			if (Calsoyasuchus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for (@SuppressWarnings("unused") Calsoyasuchus calsoyasuchus : Calsoyasuchus.this.level.getEntitiesOfClass(Calsoyasuchus.class, Calsoyasuchus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {	
						if (Calsoyasuchus.this.isBaby()) {
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
			super(Calsoyasuchus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			if (Calsoyasuchus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(@SuppressWarnings("unused") Calsoyasuchus calsoyasuchus : Calsoyasuchus.this.level.getEntitiesOfClass(Calsoyasuchus.class, Calsoyasuchus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
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
			super(Calsoyasuchus.this);
		}

		public void start() {
			super.start();
			if(Calsoyasuchus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}
		}

		protected void alertOther(Mob entity, LivingEntity target) {
			if (entity instanceof Calsoyasuchus && !entity.isBaby()) {
				super.alertOther(entity, target);
			}
		}

	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Calsoyasuchus.this, 1.25D, true);
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
					Calsoyasuchus.this.playWarningSound();
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
			super(Calsoyasuchus.this, 2.0D);
		}

		public boolean canUse() {
			return !Calsoyasuchus.this.isBaby() && !Calsoyasuchus.this.isOnFire() ? false : super.canUse();
		}

	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Calsoyasuchus calsoyasuchus;

		LayEggGoal(Calsoyasuchus calsoyasuchus, double speed) {
			super(calsoyasuchus, speed, 16);
			this.calsoyasuchus = calsoyasuchus;
		}

		public boolean canUse() {
			return this.calsoyasuchus.hasEgg() ? super.canUse() : false;
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && calsoyasuchus.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.calsoyasuchus.position());
			if (!this.calsoyasuchus.isInWater() && this.isReachedTarget()) {
				if (this.calsoyasuchus.isDigging < 1) {
					this.calsoyasuchus.setDigging(true);
				} else if (this.calsoyasuchus.isDigging > 200) {
					Level world = this.calsoyasuchus.level;
					world.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
					world.setBlock(this.blockPos.above(), PFBlocks.CALSOYASUCHUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.calsoyasuchus.random.nextInt(4) + 1)), 3);
					this.calsoyasuchus.setHasEgg(false);
					this.calsoyasuchus.setDigging(false);
					this.calsoyasuchus.setInLoveTime(600);
				}
				if (this.calsoyasuchus.isDigging()) {
					this.calsoyasuchus.isDigging++;
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
		private final Calsoyasuchus calsoyasuchus;

		MateGoal(Calsoyasuchus calsoyasuchus, double speed) {
			super(calsoyasuchus, speed);
			this.calsoyasuchus = calsoyasuchus;
		}

		public boolean canUse() {
			return super.canUse() && !this.calsoyasuchus.hasEgg() && !this.calsoyasuchus.isInLoveNaturally();
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
			this.calsoyasuchus.setHasEgg(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}

	}

	static class NaturalMateGoal extends BreedGoal {
		private final Calsoyasuchus calsoyasuchus;

		NaturalMateGoal(Calsoyasuchus calsoyasuchus, double speed) {
			super(calsoyasuchus, speed);
			this.calsoyasuchus = calsoyasuchus;
		}

		public boolean canUse() {
			return super.canUse() && !this.calsoyasuchus.hasEgg() && this.calsoyasuchus.getCurrentHunger() >= this.calsoyasuchus.getThreeQuartersHunger() && this.calsoyasuchus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.calsoyasuchus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.calsoyasuchus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.calsoyasuchus.random.nextFloat() - this.calsoyasuchus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.calsoyasuchus.random.nextInt(4);
				if (eggAmount == 0) {
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
				}
			} else {
				this.calsoyasuchus.setHasEgg(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Calsoyasuchus entity = new Calsoyasuchus(PFEntities.CALSOYASUCHUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	static class SwimGoal extends RandomSwimmingGoal {
		private final Calsoyasuchus calsoyasuchus;

		public SwimGoal(Calsoyasuchus calsoyasuchus) {
			super(calsoyasuchus, 1.0D, 40);
			this.calsoyasuchus = calsoyasuchus;
		}

		public boolean canUse() {
			return this.calsoyasuchus.func_212800_dy() && super.canUse();
		}
	}

	@SuppressWarnings("rawtypes")
	public class CarnivoreHuntGoal extends NearestAttackableTargetGoal {
		double huntSpeed;
		@SuppressWarnings({ "unchecked" })
		public CarnivoreHuntGoal(Mob goalOwnerIn, Class targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
			this.huntSpeed = huntSpeed;
		}

		public boolean canUse() {
			return super.canUse() && Calsoyasuchus.this.getCurrentHunger() <= Calsoyasuchus.this.getHalfHunger() && !Calsoyasuchus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public boolean canContinueToUse() {
			return Calsoyasuchus.this.getCurrentHunger() < Calsoyasuchus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Calsoyasuchus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Calsoyasuchus.this.getTarget();
			if (target instanceof Rabbit || target instanceof Arganodus || target instanceof Ceratodus || target instanceof Chinlea || target instanceof Cyclurus || target instanceof Mooreodontus || target instanceof Myledaphus || target instanceof Potamoceratodus || target instanceof Saurichthys || target instanceof Cod || target instanceof Salmon || target instanceof TropicalFish) {
				if (target.getHealth() == 0) {
					if (Calsoyasuchus.this.getCurrentHunger() + 3 >= Calsoyasuchus.this.maxHunger) {
						Calsoyasuchus.this.setHunger(Calsoyasuchus.this.maxHunger);
					} else {
						Calsoyasuchus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof Hyperodapedon || target instanceof Hesperornithoides || target instanceof Eilenodon || target instanceof Scutellosaurus || target instanceof Chicken) {
				if (target.getHealth() == 0) {
					if (Calsoyasuchus.this.getCurrentHunger() + 4 >= Calsoyasuchus.this.maxHunger) {
						Calsoyasuchus.this.setHunger(Calsoyasuchus.this.maxHunger);
					} else {
						Calsoyasuchus.this.setHunger(currentHunger + 6);
					}
				}
			}
			if (target instanceof Basilemys || target instanceof Chromogisaurus || target instanceof Exaeretodon || target instanceof Telmasaurus || target instanceof Kayentatherium || target instanceof Megapnosaurus) {
				if (target.getHealth() == 0) {
					if (Calsoyasuchus.this.getCurrentHunger() + 6 >= Calsoyasuchus.this.maxHunger) {
						Calsoyasuchus.this.setHunger(Calsoyasuchus.this.maxHunger);
					} else {
						Calsoyasuchus.this.setHunger(currentHunger + 6);
					}
				}
			}
			if (target instanceof Velociraptor || target instanceof Wolf) {
				if (target.getHealth() == 0) {
					if (Calsoyasuchus.this.getCurrentHunger() + 8 >= Calsoyasuchus.this.maxHunger) {
						Calsoyasuchus.this.setHunger(Calsoyasuchus.this.maxHunger);
					} else {
						Calsoyasuchus.this.setHunger(currentHunger + 8);
					}
				}
			}
			if (target instanceof Cat || target instanceof Fox || target instanceof Cow || target instanceof MushroomCow || target instanceof Pig || target instanceof Ocelot || target instanceof Aepyornithomimus || target instanceof Dryosaurus || target instanceof Protoceratops || target instanceof Thescelosaurus || target instanceof Sarahsaurus) {
				if (target.getHealth() == 0) {
					if (Calsoyasuchus.this.getCurrentHunger() + 10 >= Calsoyasuchus.this.maxHunger) {
						Calsoyasuchus.this.setHunger(Calsoyasuchus.this.maxHunger);
					} else {
						Calsoyasuchus.this.setHunger(currentHunger + 10);
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
			return super.canUse() && Calsoyasuchus.this.getCurrentHunger() <= Calsoyasuchus.this.getHalfHunger() && Calsoyasuchus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public boolean canContinueToUse() {
			return Calsoyasuchus.this.getCurrentHunger() < Calsoyasuchus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true || !Calsoyasuchus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Calsoyasuchus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Calsoyasuchus.this.getTarget();
			if (target instanceof Rabbit) {
				if (target.getHealth() == 0) {
					if (Calsoyasuchus.this.getCurrentHunger() + 3 >= Calsoyasuchus.this.maxHunger) {
						Calsoyasuchus.this.setHunger(Calsoyasuchus.this.maxHunger);
					} else {
						Calsoyasuchus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof Didelphodon || target instanceof Eilenodon || target instanceof Hyperodapedon || target instanceof Chicken || target instanceof Hesperornithoides || target instanceof Scutellosaurus || target instanceof Arganodus || target instanceof Ceratodus || target instanceof Chinlea || target instanceof Cyclurus || target instanceof Gar || target instanceof Mooreodontus || target instanceof Myledaphus || target instanceof Potamoceratodus || target instanceof Saurichthys) {
				if (target.getHealth() == 0) {
					if (Calsoyasuchus.this.getCurrentHunger() + 4 >= Calsoyasuchus.this.maxHunger) {
						Calsoyasuchus.this.setHunger(Calsoyasuchus.this.maxHunger);
					} else {
						Calsoyasuchus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof Telmasaurus) {
				if (target.getHealth() == 0) {
					if (Calsoyasuchus.this.getCurrentHunger() + 6 >= Calsoyasuchus.this.maxHunger) {
						Calsoyasuchus.this.setHunger(Calsoyasuchus.this.maxHunger);
					} else {
						Calsoyasuchus.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.CALSOYASUCHUS_SPAWN_EGG.get());
	}

}
