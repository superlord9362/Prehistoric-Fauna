package superlord.prehistoricfauna.common.entity.cretaceous.hellcreek;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RunAroundLikeCrazyGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractChestedHorse;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
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
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.blocks.FeederBlock;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Triceratops extends AbstractChestedHorse  {
	private static final EntityDataAccessor<Boolean> HAS_EGG = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_DIGGING = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_JUVENILE = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALBINO = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MELANISTIC = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SLEEPING = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> EATING = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_LOVE = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> ATTACK_TICK = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Optional<UUID>> DATA_TRUSTED_ID_0 = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.OPTIONAL_UUID);
	private static final EntityDataAccessor<Optional<UUID>> DATA_TRUSTED_ID_1 = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.OPTIONAL_UUID);
	private static final EntityDataAccessor<Boolean> PROTECTIVE = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> TERRITORIAL = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> AGGRESSIVE = SynchedEntityData.defineId(Triceratops.class, EntityDataSerializers.BOOLEAN);
	private int maxHunger = 200;
	private int currentHunger = 200;
	int hungerTick = 0;
	private int lastInLove = 0;
	private int warningSoundTicks;
	private int isDigging;
	public float ridingXZ;
	public float ridingY = 1;
	private boolean allowStandSliding;
	public int attackTick;
	int loveTick = 0;
	private float meleeProgress = 0.0F;
	private float prevMeleeProgress = 0.0F;
	public int warryTicks = 0;

	@SuppressWarnings("deprecation")
	public Triceratops(EntityType<? extends Triceratops> type, Level worldIn) {
		super(type, worldIn);
		this.maxUpStep = 1.0F;
	}

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.75F;
		else return 2.2F;
	}

	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Triceratops entity = new Triceratops(PFEntities.TRICERATOPS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
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

	public boolean isSleeping() {
		return this.entityData.get(SLEEPING);
	}

	private void setSleeping(boolean isSleeping) {
		this.entityData.set(SLEEPING, isSleeping);
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

	@Override
	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.OSMUNDA.get().asItem();
	}

	public boolean isLoveNaturally() {
		return this.entityData.get(NATURAL_LOVE);
	}

	private void setInLoveNaturally(boolean isLoveNaturally) {
		this.entityData.set(NATURAL_LOVE, isLoveNaturally);
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

	public boolean isEating() {
		return this.entityData.get(EATING);
	}

	private void setTriceratopsEating(boolean isEating) {
		this.entityData.set(EATING, isEating);
	}

	public boolean isProtective() {
		return this.entityData.get(PROTECTIVE);
	}

	public void setProtective(boolean isProtective) {
		this.entityData.set(PROTECTIVE, isProtective);
	}

	public boolean isTerritorial() {
		return this.entityData.get(TERRITORIAL);
	}

	public void setTerritorial(boolean isTerritorial) {
		this.entityData.set(TERRITORIAL, isTerritorial);
	}

	public boolean isAggressive() {
		return this.entityData.get(AGGRESSIVE);
	}

	public void setAggressive(boolean isAggressive) {
		this.entityData.set(AGGRESSIVE, isAggressive);
	}

	List<UUID> getTrustedUUIDs() {
		List<UUID> list = Lists.newArrayList();
		list.add(this.entityData.get(DATA_TRUSTED_ID_0).orElse((UUID)null));
		list.add(this.entityData.get(DATA_TRUSTED_ID_1).orElse((UUID)null));
		return list;
	}

	public void addTrustedUUID(@Nullable UUID p_28516_) {
		if (this.entityData.get(DATA_TRUSTED_ID_0).isPresent()) {
			this.entityData.set(DATA_TRUSTED_ID_1, Optional.ofNullable(p_28516_));
		} else {
			this.entityData.set(DATA_TRUSTED_ID_0, Optional.ofNullable(p_28516_));
		}
	}

	public void removeTrustedUUID(@Nullable UUID p_28516_) {
		this.entityData.set(DATA_TRUSTED_ID_1, null);
		this.entityData.set(DATA_TRUSTED_ID_0, null);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Triceratops.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Triceratops.PanicGoal());
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new TriceratopsLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new TriceratopsRandomLookGoal(this));
		this.targetSelector.addGoal(1, new Triceratops.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Triceratops.AttackPlayerGoal());
		this.targetSelector.addGoal(2, new Triceratops.TriceratopsTerritorialAttackGoal(this));
		this.targetSelector.addGoal(2, new Triceratops.TriceratopsAggressiveTempermentAttackGoal(this));
		this.goalSelector.addGoal(0, new Triceratops.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Triceratops.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Triceratops.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(0, new Triceratops.HerbivoreEatGoal((double)1.2F, 12, 2));
		this.goalSelector.addGoal(1, new RunAroundLikeCrazyGoal(this, 1.2F));
	}



	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 80.0D).add(Attributes.MOVEMENT_SPEED, (double)0.2F).add(Attributes.ATTACK_DAMAGE, 10.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.5D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isSleeping() ? PFSounds.TRICERATOPS_SNORES : PFSounds.TRICERATOPS_IDLE;
	}

	@Override
	protected void playGallopSound(SoundType p_190680_1_) {
		this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.TRICERATOPS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.TRICERATOPS_DEATH;
	}

	protected SoundEvent getAngrySound() {
		return PFSounds.TRICERATOPS_WARN;
	}

	@Override	
	public boolean causeFallDamage(float distance, float damageMultiplier, DamageSource p_149501_) {
		if (distance > 1.0F) {
			this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
		}

		int i = this.calculateFallDamage(distance, damageMultiplier);
		if (i <= 0) {
			return false;
		} else {
			this.hurt(DamageSource.FALL, (float)i);
			if (this.isVehicle()) {
				for(Entity entity : this.getIndirectPassengers()) {
					entity.hurt(DamageSource.FALL, (float)i);
				}
			}

			this.playBlockFallSound();
			return true;
		}
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState state) {
		if (this.isBaby()) {
			if (!state.getMaterial().isLiquid()) {
				BlockState blockstate = this.level.getBlockState(pos.above());
				SoundType soundtype = blockstate.is(Blocks.SNOW) ? blockstate.getSoundType(level, pos, this) : state.getSoundType(level, pos, this);
				this.playSound(soundtype.getStepSound(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
		} else {
			this.playSound(SoundEvents.COW_STEP, 0.15F, 1F);
		}
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.TRICERATOPS_WARN, 1.0F, this.getVoicePitch());
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
		this.entityData.define(SLEEPING, false);
		this.entityData.define(EATING, false);
		this.entityData.define(NATURAL_LOVE, false);
		this.entityData.define(ATTACK_TICK, 0);
		this.entityData.define(DATA_TRUSTED_ID_0, Optional.empty());
		this.entityData.define(DATA_TRUSTED_ID_1, Optional.empty());
		this.entityData.define(PROTECTIVE, false);
		this.entityData.define(TERRITORIAL, false);
		this.entityData.define(AGGRESSIVE, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		List<UUID> list = this.getTrustedUUIDs();
		ListTag listtag = new ListTag();
		for(UUID uuid : list) {
			if (uuid != null) {
				listtag.add(NbtUtils.createUUID(uuid));
			}
		}
		compound.put("Trusted", listtag);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putBoolean("IsSleeping", this.isSleeping());
		compound.putInt("AttackTick", this.attackTick);
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("IsEating", this.isEating());
		compound.putBoolean("InNaturalLove", this.isLoveNaturally());
		compound.putBoolean("IsProtective", this.isProtective());
		compound.putBoolean("IsTerritorial", this.isTerritorial());
		compound.putBoolean("IsAggressive", this.isAggressive());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		ListTag listtag = compound.getList("Trusted", 11);
		for(int i = 0; i < listtag.size(); ++i) {
			this.addTrustedUUID(NbtUtils.loadUUID(listtag.get(i)));
		}
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setSleeping(compound.getBoolean("IsSleeping"));
		this.attackTick = compound.getInt("AttackTick");
		this.setTriceratopsEating(compound.getBoolean("IsEating"));
		this.setHunger(compound.getInt("MaxHunger"));
		this.setInLoveNaturally(compound.getBoolean("InNaturalLove"));
		this.setProtective(compound.getBoolean("IsProtective"));
		this.setTerritorial(compound.getBoolean("IsTerritorial"));
		this.setAggressive(compound.getBoolean("IsAggressive"));
	}

	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		Random random = new Random();
		int birthNumber = random.nextInt(799);
		int temperment = random.nextInt(100);
		if (temperment < 80) {
			this.setProtective(true);
		} else if (temperment >= 80 && temperment < 95) {
			this.setTerritorial(true);
		} else {
			this.setAggressive(true);
		}
		if (birthNumber >= 0 && birthNumber < 4) {
			this.setAlbino(true);
		} else if (birthNumber >= 4 && birthNumber < 7) {
			this.setMelanistic(true);
		}
		this.setHunger(this.maxHunger);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@Override
	protected boolean canParent() {
		return !this.isVehicle() && !this.isPassenger() && !this.isBaby() && this.isInLove();
	}

	public boolean canMate(Animal otherAnimal) {
		return this.canParent() && ((Triceratops)otherAnimal).canParent();
	}

	public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {
		Level world = p_230254_1_.level;
		ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
		Item item = itemstack.getItem();
		if (this.isFood(itemstack)) {
			int i = this.getAge();
			if (!this.level.isClientSide && i == 0 && this.canFallInLove()) {
				this.usePlayerItem(p_230254_1_, p_230254_2_, itemstack);
				this.setInLove(p_230254_1_);
				return InteractionResult.SUCCESS;
			}
		}
		if (!this.isBaby()) {
			if (item == PFItems.TRICERATOPS_SPAWN_EGG.get()) {
				Triceratops triceratopsentity = PFEntities.TRICERATOPS.get().create(world);
				triceratopsentity.setAge(-24000);
				triceratopsentity.moveTo((double)this.getX() + 0.3D * 0.2D, (double)this.getY(), (double)this.getZ() + 0.3D, 0.0F, 0.0F);
				world.addFreshEntity(triceratopsentity);
				return super.mobInteract(p_230254_1_, p_230254_2_);
			}
			if (this.isTamed() && p_230254_1_.isSecondaryUseActive()) {
				this.openInventory(p_230254_1_);
				return InteractionResult.sidedSuccess(this.level.isClientSide);
			}

			if (this.isVehicle()) {
				return super.mobInteract(p_230254_1_, p_230254_2_);
			}
		}

		if (!itemstack.isEmpty()) {

			if (!this.isTamed()) {
				this.makeMad();
				return InteractionResult.sidedSuccess(this.level.isClientSide);
			}

			if (!this.hasChest() && itemstack.getItem() == Blocks.CHEST.asItem()) {
				this.setChest(true);
				this.playChestEquipsSound();
				if (!p_230254_1_.getAbilities().instabuild) {
					itemstack.shrink(1);
				}

				this.createInventory();
				return InteractionResult.sidedSuccess(this.level.isClientSide);
			}

			if (!this.isBaby() && !this.isSaddled() && itemstack.getItem() == Items.SADDLE) {
				this.openInventory(p_230254_1_);
				return InteractionResult.sidedSuccess(this.level.isClientSide);
			}
		}
		if (PrehistoricFaunaConfig.advancedHunger) {
			int hunger = this.getCurrentHunger();
			if (hunger < this.maxHunger) {
				if (this.isFood(itemstack) && (!this.isInLove() || !this.isLoveNaturally())) {
					this.setInLove(p_230254_1_);
					if (!p_230254_1_.isCreative()) {
						itemstack.shrink(1);
					}
				} else {
					if (itemstack.is(PFTags.PLANTS_2_HUNGER_ITEM)) {
						if (hunger + 2 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 2);
						}
						if (!p_230254_1_.isCreative()) {
							itemstack.shrink(1);
						}
					}
					if (itemstack.is(PFTags.PLANTS_4_HUNGER_ITEM)) {
						if (hunger + 4 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 4);
						}
						if (!p_230254_1_.isCreative()) {
							itemstack.shrink(1);
						}
					}
					if (itemstack.is(PFTags.PLANTS_6_HUNGER_ITEM)) {
						if (hunger + 6 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 6);
						}
						if (!p_230254_1_.isCreative()) {
							itemstack.shrink(1);
						}
					}
					if (itemstack.is(PFTags.PLANTS_8_HUNGER_ITEM)) {
						if (hunger + 8 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 8);
						}
						if (!p_230254_1_.isCreative()) {
							itemstack.shrink(1);
						}
					}
					if (itemstack.is(PFTags.PLANTS_10_HUNGER_ITEM)) {
						if (hunger + 10 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 10);
						}
						if (!p_230254_1_.isCreative()) {
							itemstack.shrink(1);
						}
					}
					if (itemstack.is(PFTags.PLANTS_12_HUNGER_ITEM)) {
						if (hunger + 12 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 12);
						}
						if (!p_230254_1_.isCreative()) {
							itemstack.shrink(1);
						}
					}
					if (itemstack.is(PFTags.PLANTS_15_HUNGER_ITEM)) {
						if (hunger + 15 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 15);
						}
						if (!p_230254_1_.isCreative()) {
							itemstack.shrink(1);
						}
					}
					if (itemstack.is(PFTags.PLANTS_20_HUNGER_ITEM)) {
						if (hunger + 20 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 20);
						}
						if (!p_230254_1_.isCreative()) {
							itemstack.shrink(1);
						}
					}
					if (itemstack.is(PFTags.PLANTS_25_HUNGER_ITEM)) {
						if (hunger + 25 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 25);
						}
						if (!p_230254_1_.isCreative()) {
							itemstack.shrink(1);
						}
					}
					if (itemstack.is(PFTags.PLANTS_30_HUNGER_ITEM)) {
						if (hunger + 30 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 30);
						}
						if (!p_230254_1_.isCreative()) {
							itemstack.shrink(1);
						}
					}
					if (itemstack.is(PFItems.MARMARTHIA_BERRIES.get())) {
						if (hunger + 2 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 2);
						}
						if (!p_230254_1_.isCreative()) {
							itemstack.shrink(1);
						}
						this.addEffect(new MobEffectInstance(MobEffects.POISON, 300));
					}
				}
			}
			if ((itemstack.is(PFTags.PLANTS_2_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_4_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_6_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_8_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_10_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_12_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_15_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_20_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_25_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_30_HUNGER_ITEM))) {
				p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.fullHunger"), true);
			}
		}
		if (this.isBaby()) {
			if (item == PFItems.TRICERATOPS_SPAWN_EGG.get()) {
				Triceratops triceratopsentity = PFEntities.TRICERATOPS.get().create(world);
				triceratopsentity.setAge(-24000);
				triceratopsentity.moveTo((double)this.getX() + 0.3D * 0.2D, (double)this.getY(), (double)this.getZ() + 0.3D, 0.0F, 0.0F);
				world.addFreshEntity(triceratopsentity);
				return super.mobInteract(p_230254_1_, p_230254_2_);
			} else {
				return super.mobInteract(p_230254_1_, p_230254_2_);
			}
		} else {
			this.doPlayerRide(p_230254_1_);
			return InteractionResult.sidedSuccess(this.level.isClientSide);
		}
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick() {
		super.tick();
		prevMeleeProgress = meleeProgress;
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
		if (this.entityData.get(ATTACK_TICK) > 0) {
			LivingEntity target = this.getTarget();
			if (this.entityData.get(ATTACK_TICK) == 1 && target != null && this.hasLineOfSight(target) && this.distanceTo(target) < this.getMeleeRange() + this.getBbWidth() + target.getBbWidth()) {
				this.onAttackAnimationFinish(target);
			}
			this.entityData.set(ATTACK_TICK, this.entityData.get(ATTACK_TICK) - 1);
			if (meleeProgress < 1.0F) {
				meleeProgress = Math.min(meleeProgress + 0.2F, 1.0F);
			}
		} else {
			if (meleeProgress > 0F) {
				meleeProgress = Math.max(meleeProgress - 0.2F, 0.0F);
			}
		}
	}

	public float getMeleeRange() {
		return 2.5F;
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		this.entityData.set(ATTACK_TICK, 7);
		return true;
	}

	public boolean onAttackAnimationFinish(Entity target) {
		return target.hurt(DamageSource.mobAttack(this), (float) ((int) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue()));
	}

	public float getMeleeProgress(float partialTick) {
		return prevMeleeProgress + (meleeProgress - prevMeleeProgress) * partialTick;
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isBaby() && !this.isJuvenile()) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20.0D);
		} else if (this.isJuvenile()) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(40.0D);
		} else {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(80.0D);
		}
		if (this.isAlive()) {
			if (this.attackTick > 0) {
				--this.attackTick;
			}
		}
		if (this.isSleeping()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double) 0.2F);
		}
		if (!this.isNoAi()) {
			List<? extends Triceratops> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
			if (PrehistoricFaunaConfig.advancedHunger) {
				hungerTick++;
				if (hungerTick == 600 && !this.isBaby() || hungerTick == 300 && this.isBaby() && !this.isJuvenile() || hungerTick == 450 && this.isJuvenile()) {
					if (!this.isSleeping()) {
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
				if (currentHunger == 0 && !this.isBaby()) {
					if (!this.getTrustedUUIDs().isEmpty()) {
						this.getTrustedUUIDs().clear();
					}
				}
				if (this.getCurrentHunger() >= this.getThreeQuartersHunger() && hungerTick % 150 == 0) {
					if (this.getHealth() < this.getMaxHealth() && this.getHealth() != 0 && this.getTarget() == null && this.getLastHurtByMob() == null) {
						float currentHealth = this.getHealth();
						this.setHealth(currentHealth + 1);
					}
				}
				if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
					if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && tickCount % 900 == 0 && !this.isBaby() && !this.isInLove() && !this.isSleeping() && list.size() < 10) {
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
				if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isBaby() && !this.isInLove() && !this.isSleeping() && list.size() < 10) {
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
		if (!this.level.isClientSide) {
			if (this.warryTicks != 0) warryTicks--;
		}
	}
	
	public void setAwakeTicks(int ticks) {
		this.warryTicks = ticks;
	}

	protected void onOffspringSpawnedFromEgg(Player p_28481_, Mob p_28482_) {
		((Triceratops)p_28482_).addTrustedUUID(p_28481_.getUUID());
	}

	public boolean trusts(UUID p_28530_) {
		return this.getTrustedUUIDs().contains(p_28530_);
	}

	public Player getRidingPlayer() {
		if (this.getControllingPassenger() instanceof Player) {
			return (Player) getControllingPassenger();
		} else {
			return null;
		}
	}

	public void positionRider(Entity p_30642_) {
		super.positionRider(p_30642_);
		if (p_30642_ instanceof Mob) {
			Mob mob = (Mob)p_30642_;
			this.yBodyRot = mob.yBodyRot;
		}
		float radius = ridingXZ * 0.7F * -3;
		float angle = (0.01745329251F * this.yBodyRotO);
		double extraX = radius * Mth.sin((float) (Math.PI + angle));
		double extraZ = radius * Mth.cos(angle);
		double extraY = ridingY * 4;
		p_30642_.setPos(this.getX() + extraX, this.getY() + extraY - 1.75F, this.getZ() + extraZ);
	}

	public void travel(Vec3 p_30633_) {
		if (this.isAlive()) {
			if (this.isVehicle() && this.canBeControlledByRider() && this.isSaddled()) {
				LivingEntity livingentity = (LivingEntity)this.getControllingPassenger();
				this.setYRot(livingentity.getYRot());
				this.yRotO = this.getYRot();
				this.setXRot(livingentity.getXRot() * 0.5F);
				this.setRot(this.getYRot(), this.getXRot());
				this.yBodyRot = this.getYRot();
				this.yHeadRot = this.yBodyRot;
				float f = livingentity.xxa * 0.5F;
				float f1 = livingentity.zza;
				if (f1 <= 0.0F) {
					f1 *= 0.25F;
					this.gallopSoundCounter = 0;
				}

				if (this.onGround && this.playerJumpPendingScale == 0.0F && this.isStanding() && !this.allowStandSliding) {
					f = 0.0F;
					f1 = 0.0F;
				}

				if (this.playerJumpPendingScale > 0.0F && !this.isJumping() && this.onGround) {
					double d1 = 0;
					Vec3 vec3 = this.getDeltaMovement();
					this.setDeltaMovement(vec3.x, d1, vec3.z);
					this.hasImpulse = true;
					if (f1 > 0.0F) {
						float f2 = Mth.sin(this.getYRot() * ((float)Math.PI / 180F));
						float f3 = Mth.cos(this.getYRot() * ((float)Math.PI / 180F));
						this.setDeltaMovement(this.getDeltaMovement().add((double)(-0.4F * f2 * this.playerJumpPendingScale), 0.0D, (double)(0.4F * f3 * this.playerJumpPendingScale)));
					}

					this.playerJumpPendingScale = 0.0F;
				}

				this.flyingSpeed = this.getSpeed() * 0.1F;
				if (this.isControlledByLocalInstance()) {
					this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
					super.travel(new Vec3((double)f, p_30633_.y, (double)f1));
				} else if (livingentity instanceof Player) {
					this.setDeltaMovement(Vec3.ZERO);
				}

				if (this.onGround) {
					this.playerJumpPendingScale = 0.0F;
					this.setIsJumping(false);
				}

				this.calculateEntityAnimation(this, false);
				this.tryCheckInsideBlocks();
			} else {
				this.flyingSpeed = 0.02F;
				super.travel(p_30633_);
			}
		}
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.TRICERATOPS_SPAWN_EGG.get());
	}

	@Override
	protected void setOffspringAttributes(AgeableMob p_190681_1_, AbstractHorse p_190681_2_) {
		double d0 = this.getAttributeValue(Attributes.MAX_HEALTH);
		p_190681_2_.getAttribute(Attributes.MAX_HEALTH).setBaseValue(d0);
		double d2 = this.getAttributeValue(Attributes.MOVEMENT_SPEED);
		p_190681_2_.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(d2);
	}

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(Triceratops.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			if (Triceratops.this.isBaby() && !Triceratops.this.isJuvenile() || Triceratops.this.isTamed()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Triceratops triceratops : Triceratops.this.level.getEntitiesOfClass(Triceratops.class, Triceratops.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (!triceratops.trusts(this.target.getUUID()) && (triceratops.isProtective() || triceratops.isTerritorial())) {
							if (triceratops.isBaby() && !triceratops.isJuvenile()) {
								return true;
							}
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

	@Override
	protected float generateRandomMaxHealth() {
		return this.getMaxHealth();
	}

	class HurtByTargetGoal extends net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(Triceratops.this);
		}

		public void start() {
			super.start();
			if (Triceratops.this.isBaby() && !Triceratops.this.isJuvenile()) {
				this.alertOthers();
				this.stop();
			}
			if (Triceratops.this.trusts(this.targetMob.getUUID())) {
				Triceratops.this.removeTrustedUUID(this.targetMob.getUUID());
			}
		}

		protected void alertOther(Mob mobIn, LivingEntity targetIn) {
			if (mobIn instanceof Triceratops && !mobIn.isBaby()) {
				super.alertOther(mobIn, targetIn);
			}

		}
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Triceratops.this, 1.25D, true);
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
					Triceratops.this.playWarningSound();
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
			return (double)(10.0F + attackTarget.getBbWidth());
		}
	}

	class PanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(Triceratops.this, 2.0D);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Triceratops.this.isBaby() && !Triceratops.this.isOnFire() ? false : super.canUse();
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Triceratops triceratops;

		LayEggGoal(Triceratops triceratops, double speedIn) {
			super(triceratops, speedIn, 16);
			this.triceratops = triceratops;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.triceratops.hasEgg() ? super.canUse() : false;
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.triceratops.hasEgg();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.triceratops.blockPosition());
			if (!this.triceratops.isInWater() && this.isReachedTarget()) {
				if (this.triceratops.isDigging < 1) {
					this.triceratops.setDigging(true);
				} else if (this.triceratops.isDigging > 200) {
					Level world = this.triceratops.level;
					world.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
					world.setBlock(this.blockPos.above(), PFBlocks.TRICERATOPS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.triceratops.random.nextInt(4) + 1)), 3);
					this.triceratops.setHasEgg(false);
					this.triceratops.setDigging(false);
					this.triceratops.setInLoveTime(600);
				}

				if (this.triceratops.isDigging()) {
					this.triceratops.isDigging++;
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
		private final Triceratops triceratops;
		private static final TargetingConditions PARTNER_TARGETING = TargetingConditions.forNonCombat().range(8.0D).ignoreLineOfSight();
		private int breedDelay;
		private final double moveSpeed;

		MateGoal(Triceratops triceratops, double speed) {
			super(triceratops, speed);
			this.triceratops = triceratops;
			this.moveSpeed = speed;
		}

		@Nullable
		private Triceratops getNearbyMate() {
			List<Triceratops> list = this.level.getNearbyEntities(Triceratops.class, PARTNER_TARGETING, this.animal, this.animal.getBoundingBox().inflate(24.0D));
			double d0 = Double.MAX_VALUE;
			Triceratops animalentity = null;

			for(Triceratops animalentity1 : list) {
				if (this.animal.canMate(animalentity1) && this.animal.distanceToSqr(animalentity1) < d0) {
					animalentity = animalentity1;
					d0 = this.animal.distanceToSqr(animalentity1);
				}
			}

			return animalentity;
		}

		public boolean canUse() {
			return super.canUse() && !this.triceratops.hasEgg() && !this.triceratops.isLoveNaturally();
		}

		public void stop() {
			this.partner = null;
			this.breedDelay = 0;
		}

		public void tick() {
			super.tick();
			this.animal.getLookControl().setLookAt(this.partner, 10.0F, (float)this.animal.getMaxHeadXRot());
			this.animal.getNavigation().moveTo(this.partner, this.moveSpeed);
			++this.breedDelay;
			if (this.breedDelay >= 60 && this.animal.distanceToSqr(this.partner) < 20.0D) {
				this.breed();
			}
		}

		protected void breed() {
			ServerPlayer serverPlayer = this.animal.getLoveCause();
			if (serverPlayer == null && this.partner.getLoveCause() != null) {
				serverPlayer = this.partner.getLoveCause();
			}
			if (serverPlayer != null) {
				serverPlayer.awardStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverPlayer, this.animal, this.partner, (AgeableMob)null);
			}
			this.triceratops.setHasEgg(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random randomom = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), randomom.nextInt(7) + 1));
			}
		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Triceratops triceratops;

		NaturalMateGoal(Triceratops triceratops, double speed) {
			super(triceratops, speed);
			this.triceratops = triceratops;
		}

		public boolean canUse() {
			return super.canUse() && !this.triceratops.hasEgg() && this.triceratops.getCurrentHunger() >= this.triceratops.getThreeQuartersHunger() && this.triceratops.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.triceratops.isLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.triceratops.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.triceratops.random.nextFloat() - this.triceratops.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.triceratops.random.nextInt(4);
				if (eggAmount == 0) {
					this.triceratops.spawnAtLocation(PFBlocks.TRICERATOPS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.triceratops.spawnAtLocation(PFBlocks.TRICERATOPS_EGG.get().asItem());
					this.triceratops.spawnAtLocation(PFBlocks.TRICERATOPS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.triceratops.spawnAtLocation(PFBlocks.TRICERATOPS_EGG.get().asItem());
					this.triceratops.spawnAtLocation(PFBlocks.TRICERATOPS_EGG.get().asItem());
					this.triceratops.spawnAtLocation(PFBlocks.TRICERATOPS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.triceratops.spawnAtLocation(PFBlocks.TRICERATOPS_EGG.get().asItem());
					this.triceratops.spawnAtLocation(PFBlocks.TRICERATOPS_EGG.get().asItem());
					this.triceratops.spawnAtLocation(PFBlocks.TRICERATOPS_EGG.get().asItem());
					this.triceratops.spawnAtLocation(PFBlocks.TRICERATOPS_EGG.get().asItem());
				}
			} else {
				this.triceratops.setHasEgg(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	protected boolean handleEating(Player player, ItemStack stack) {
		boolean flag = false;
		float f = 0.0F;
		int i = 0;
		Item item = stack.getItem();
		if (item == PFBlocks.HORSETAIL.get().asItem()) {
			f = 2.0F;
			i = 20;
		} else if (item == PFBlocks.TALL_HORSETAIL.get().asItem()) {
			f = 1.0F;
			i = 30;
		} else if (item == PFBlocks.OSMUNDA.get().asItem()) {
			f = 20.0F;
			i = 180;
			if (this.getAge() == 0 && !this.isInLove()) {
				flag = true;
				this.setInLove(player);
			}
		} else if (item == PFBlocks.TALL_OSMUNDA.get().asItem()) {
			f = 3.0F;
			i = 60;
		} else if (item == PFBlocks.CLUBMOSS.get().asItem()) {
			f = 4.0F;
			i = 60;
		} else if (item == PFBlocks.MARCHANTIA.get().asItem()) {
			f = 3.0F;
			i = 80;
		}

		if (this.getHealth() < this.getMaxHealth() && f > 0.0F) {
			this.heal(f);
			flag = true;
		}

		if (this.isBaby() && i > 0) {
			this.level.addParticle(ParticleTypes.HAPPY_VILLAGER, this.getRandomX(1.0D), this.getRandomY() + 0.5D, this.getRandomZ(1.0D), 0.0D, 0.0D, 0.0D);
			if (!this.level.isClientSide) {
				this.ageUp(i);
			}

			flag = true;
		}

		return flag;
	}

	class TriceratopsFollowParentGoal extends Goal {
		private final Triceratops babyTriceratops;
		private Triceratops parentTriceratops;
		private final double moveSpeed;
		private int delayCounter;

		public TriceratopsFollowParentGoal(Triceratops triceratops, double speed) {
			this.babyTriceratops = triceratops;
			this.moveSpeed = speed;
		}

		public boolean canUse() {
			if (this.babyTriceratops.isBaby() && !this.babyTriceratops.isJuvenile()) {
				List<? extends Triceratops> list = this.babyTriceratops.level.getEntitiesOfClass(this.babyTriceratops.getClass(), this.babyTriceratops.getBoundingBox().inflate(8.0D, 4.0D, 8.0D));
				Triceratops triceratopsEntity = null;
				double d0 = Double.MAX_VALUE;
				for (Triceratops triceratopsEntity1 : list) {
					if (!triceratopsEntity1.isBaby()) {
						double d1 = this.babyTriceratops.distanceToSqr(triceratopsEntity1);
						if (!(d1 > d0)) {
							d0 = d1;
							triceratopsEntity = triceratopsEntity1;
						}
					}
				}
				if (triceratopsEntity == null) {
					return false;
				} else if (d0 < 9.0D) {
					return false;
				} else {
					this.parentTriceratops = triceratopsEntity;
					return true;
				}
			} else {
				return false;
			}
		}

		public boolean canContinueToUse() {
			if (!this.babyTriceratops.isJuvenile() || !this.babyTriceratops.isBaby()) {
				return false;
			} else if (!this.parentTriceratops.isAlive()) {
				return false;
			} else  if(this.babyTriceratops.isBaby() && !this.babyTriceratops.isJuvenile()){
				double d0 = this.babyTriceratops.distanceToSqr(this.parentTriceratops);
				return !(d0 < 9.0D) && !(d0 > 256.0D);
			} else {
				return false;
			}
		}

		public void start() {
			this.delayCounter = 0;
		}

		public void stop() {
			this.parentTriceratops = null;
		}

		public void tick() {
			if (--this.delayCounter <= 0) {
				this.delayCounter = 10;
				this.babyTriceratops.getNavigation().moveTo(this.parentTriceratops, this.moveSpeed);
			}
		}
	}

	public class UnscheduledSleepingGoal extends Goal {

		public Triceratops entity;
		private int sleepTimer = 0;

		public UnscheduledSleepingGoal(Triceratops sleeper) {
			super();
			this.entity = sleeper;
		}

		@Override
		public boolean canUse() {
			Level level = entity.level;
			List<? extends Player> list = level.getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D));
			if (PrehistoricFaunaConfig.unscheduledSleeping = true && entity.getRandom().nextInt(1000) == 0 && entity.getLastHurtByMob() == null && entity.getTarget() == null && !entity.isInWater() && !entity.isInLava() && !list.isEmpty()) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public boolean canContinueToUse() {
			Level level = entity.level;
			List<? extends Player> list = level.getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D));
			if (sleepTimer >= 6000 || entity.getLastHurtByMob() != null || entity.getTarget() != null || super.canContinueToUse() || entity.isInWater() || entity.isInLava() || !list.isEmpty()) {
				entity.setSleeping(false);
				sleepTimer = 0;
				stop();
				return false;
			} else return true;
		}

		public void tick() {
			super.tick();
			Level level = entity.level;
			List<? extends Player> list = level.getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D));
			sleepTimer++;
			if (sleepTimer >= 6000 || entity.getLastHurtByMob() != null || entity.getTarget() != null || entity.isInWater() || entity.isInLava() || !list.isEmpty()) {
				entity.setSleeping(false);
				sleepTimer = 0;
				stop();
			}
		}

		@Override
		public void start() {
			sleepTimer = 0;
			entity.setSleeping(true);
			entity.xxa = 0.0F;
			entity.yya = 0.0F;
			entity.zza = 0.0F;
			entity.getNavigation().stop();
			entity.lerpMotion(0.0D, 0.0D, 0.0D);
		}

		@Override
		public void stop() {
			sleepTimer = 0;
			entity.setSleeping(false);
		}

	}

	public class CathemeralSleepGoal extends Goal {

		public Triceratops entity;
		private int sleepTimer = 0;

		public CathemeralSleepGoal(Triceratops sleeper) {
			super();
			this.entity = sleeper;
		}

		@Override
		public boolean canUse() {
			for(Player player : entity.level.getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
				if (!player.isShiftKeyDown()) return false;
			}
			return (PrehistoricFaunaConfig.sleeping = true && entity.getRandom().nextInt(1000) == 0 && entity.getLastHurtByMob() == null && !entity.isTamed() && entity.getRidingPlayer() == null && !entity.isInWater() && !entity.isInLava() && !PrehistoricFaunaConfig.unscheduledSleeping && entity.warryTicks == 0);
		}

		@Override
		public boolean canContinueToUse() {
			for(Player player : entity.level.getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
				if (!player.isShiftKeyDown()) {
					stop();
					return false;
				} else return (sleepTimer >= 6000 || entity.getLastHurtByMob() != null || entity.isTamed() || entity.getRidingPlayer() != null || !super.canContinueToUse() || entity.isInWater() || entity.isInLava());
			}
			if (sleepTimer >= 6000 || entity.getLastHurtByMob() != null || entity.isTamed() || entity.getRidingPlayer() != null || !super.canContinueToUse() || entity.isInWater() || entity.isInLava()) {
				stop();
				return false;
			} else return true;
		}

		public void tick() {
			super.tick();
			sleepTimer++;
			for(Player player : entity.level.getEntitiesOfClass(Player.class, entity.getBoundingBox().inflate(1.0D, 1.0D, 1.0D))) {
				if (!player.isShiftKeyDown()) {
					stop();
				}
			}
			if (sleepTimer >= 6000 || entity.getLastHurtByMob() != null || entity.isTamed() || entity.getRidingPlayer() != null || super.canContinueToUse() || entity.isInWater() || entity.isInLava()) {
				stop();
			}
		}

		@Override
		public void start() {
			sleepTimer = 0;
			entity.setSleeping(true);
			entity.xxa = 0.0F;
			entity.yya = 0.0F;
			entity.zza = 0.0F;
			entity.getNavigation().stop();
			entity.setDeltaMovement(0.0D, 0.0D, 0.0D);
		}

		@Override
		public void stop() {
			sleepTimer = 0;
			entity.setAwakeTicks(100);
			entity.setSleeping(false);
		}

	}

	public class HerbivoreEatGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public HerbivoreEatGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Triceratops.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
		}

		public double getTargetDistanceSq() {
			return 2.0D;
		}

		public boolean shouldMove() {
			return this.tryTicks % 100 == 0;
		}

		/**
		 * Return true to set given position as destination
		 */
		protected boolean isValidTarget(LevelReader worldIn, BlockPos pos) {
			BlockState blockstate = worldIn.getBlockState(pos);
			return blockstate.is(PFTags.PLANTS_2_HUNGER) || blockstate.is(PFTags.PLANTS_4_HUNGER) || blockstate.is(PFTags.PLANTS_6_HUNGER) || blockstate.is(PFTags.PLANTS_8_HUNGER) || blockstate.is(PFTags.PLANTS_10_HUNGER) || blockstate.is(PFTags.PLANTS_12_HUNGER) || blockstate.is(PFTags.PLANTS_15_HUNGER) || blockstate.is(PFTags.PLANTS_20_HUNGER) || blockstate.is(PFTags.PLANTS_25_HUNGER) || blockstate.is(PFTags.PLANTS_30_HUNGER);
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (this.isReachedTarget()) {
				if (this.field_220731_g >= 20) {
					this.eatBerry();
				} else {
					++this.field_220731_g;
					Triceratops.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					Triceratops.this.level.playSound((Player)null, this.blockPos, SoundEvents.GRASS_HIT, SoundSource.NEUTRAL, 1, 1);
				}
			}
			if (Triceratops.this.getCurrentHunger() >= 13) {
				Triceratops.this.setEating(false);
			}
			super.tick();
		}

		protected void eatBerry() {
			BlockState blockstate = Triceratops.this.level.getBlockState(this.blockPos);

			if (blockstate.is(PFTags.PLANTS_2_HUNGER)) {
				int hunger = Triceratops.this.getCurrentHunger();
				if (hunger + 2 >= Triceratops.this.maxHunger) {
					Triceratops.this.setHunger(Triceratops.this.maxHunger);
					Triceratops.this.setEating(false);
				} else {
					Triceratops.this.setHunger(hunger + 2);
					Triceratops.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_4_HUNGER)) {
				int hunger = Triceratops.this.getCurrentHunger();
				if (hunger + 4 >= Triceratops.this.maxHunger) {
					Triceratops.this.setHunger(Triceratops.this.maxHunger);
					Triceratops.this.setEating(false);
				} else {
					Triceratops.this.setHunger(hunger + 4);
					Triceratops.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_6_HUNGER)) {
				int hunger = Triceratops.this.getCurrentHunger();
				if (hunger + 6 >= Triceratops.this.maxHunger) {
					Triceratops.this.setHunger(Triceratops.this.maxHunger);
					Triceratops.this.setEating(false);
				} else {
					Triceratops.this.setHunger(hunger + 6);
					Triceratops.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_8_HUNGER)) {
				int hunger = Triceratops.this.getCurrentHunger();
				if (hunger + 8 >= Triceratops.this.maxHunger) {
					Triceratops.this.setHunger(Triceratops.this.maxHunger);
					Triceratops.this.setEating(false);
				} else {
					Triceratops.this.setHunger(hunger + 8);
					Triceratops.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_10_HUNGER)) {
				int hunger = Triceratops.this.getCurrentHunger();
				if (hunger + 10 >= Triceratops.this.maxHunger) {
					Triceratops.this.setHunger(Triceratops.this.maxHunger);
					Triceratops.this.setEating(false);
				} else {
					Triceratops.this.setHunger(hunger + 10);
					Triceratops.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_12_HUNGER)) {
				int hunger = Triceratops.this.getCurrentHunger();
				if (hunger + 12 >= Triceratops.this.maxHunger) {
					Triceratops.this.setHunger(Triceratops.this.maxHunger);
					Triceratops.this.setEating(false);
				} else {
					Triceratops.this.setHunger(hunger + 12);
					Triceratops.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_15_HUNGER)) {
				int hunger = Triceratops.this.getCurrentHunger();
				if (hunger + 15 >= Triceratops.this.maxHunger) {
					Triceratops.this.setHunger(Triceratops.this.maxHunger);
					Triceratops.this.setEating(false);
				} else {
					Triceratops.this.setHunger(hunger + 15);
					Triceratops.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_20_HUNGER)) {
				int hunger = Triceratops.this.getCurrentHunger();
				if (hunger + 20 >= Triceratops.this.maxHunger) {
					Triceratops.this.setHunger(Triceratops.this.maxHunger);
					Triceratops.this.setEating(false);
				} else {
					Triceratops.this.setHunger(hunger + 20);
					Triceratops.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_25_HUNGER)) {
				int hunger = Triceratops.this.getCurrentHunger();
				if (hunger + 25 >= Triceratops.this.maxHunger) {
					Triceratops.this.setHunger(Triceratops.this.maxHunger);
					Triceratops.this.setEating(false);
				} else {
					Triceratops.this.setHunger(hunger + 25);
					Triceratops.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_30_HUNGER)) {
				int hunger = Triceratops.this.getCurrentHunger();
				if (hunger + 30 >= Triceratops.this.maxHunger) {
					Triceratops.this.setHunger(Triceratops.this.maxHunger);
					Triceratops.this.setEating(false);
				} else {
					Triceratops.this.setHunger(hunger + 30);
					Triceratops.this.setEating(false);
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Triceratops.this.isSleeping() && super.canUse() && Triceratops.this.getCurrentHunger() < Triceratops.this.getHalfHunger();
		}

		public boolean canContinueToUse() {
			if (Triceratops.this.getCurrentHunger() >= Triceratops.this.maxHunger || Triceratops.this.isSleeping()) {
				return false;
			} else return super.canContinueToUse();
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			this.field_220731_g = 0;
			super.start();
		}
	}

	public class TriceratopsLookAtGoal extends LookAtPlayerGoal {

		Triceratops triceratops;

		public TriceratopsLookAtGoal(Triceratops entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
			super(entityIn, watchTargetClass, maxDistance);
			triceratops = entityIn;
		}

		public boolean canUse() {
			return super.canUse() && !triceratops.isSleeping();
		}

	}

	public class TriceratopsRandomLookGoal extends RandomLookAroundGoal {

		Triceratops dinosaur;

		public TriceratopsRandomLookGoal(Triceratops entitylivingIn) {
			super(entitylivingIn);
			dinosaur = entitylivingIn;
		}

		public boolean canUse() {
			return super.canUse() && !dinosaur.isSleeping();
		}


	}

	public class EatFromFeederGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public EatFromFeederGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Triceratops.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
		}

		public double getTargetDistanceSq() {
			return 2.0D;
		}

		public boolean shouldMove() {
			return this.tryTicks % 100 == 0;
		}

		/**
		 * Return true to set given position as destination
		 */
		protected boolean isValidTarget(LevelReader worldIn, BlockPos pos) {
			BlockState blockstate = worldIn.getBlockState(pos);
			return blockstate.getBlock() instanceof FeederBlock && blockstate.getValue(FeederBlock.PLANT) == true;
		}

		protected BlockPos getMoveToTarget() {
			if (!Triceratops.this.level.getBlockState(blockPos.north()).isCollisionShapeFullBlock(level, blockPos.north())) {
				return this.blockPos.north();
			} else {
				if (!Triceratops.this.level.getBlockState(blockPos.south()).isCollisionShapeFullBlock(level, blockPos.south())) {
					return this.blockPos.south();
				} else {
					if (!Triceratops.this.level.getBlockState(blockPos.east()).isCollisionShapeFullBlock(level, blockPos.east())) {
						return this.blockPos.east();
					} else {
						if (!Triceratops.this.level.getBlockState(blockPos.west()).isCollisionShapeFullBlock(level, blockPos.west())) {
							return this.blockPos.west();
						} else {
							if (!Triceratops.this.level.getBlockState(blockPos.north().east()).isCollisionShapeFullBlock(level, blockPos.north().east())) {
								return this.blockPos.north().east();
							} else {
								if (!Triceratops.this.level.getBlockState(blockPos.north().west()).isCollisionShapeFullBlock(level, blockPos.north().west())) {
									return this.blockPos.north().west();
								} else {
									if (!Triceratops.this.level.getBlockState(blockPos.south().east()).isCollisionShapeFullBlock(level, blockPos.south().east())) {
										return this.blockPos.south().east();
									} else {
										if (!Triceratops.this.level.getBlockState(blockPos.south().west()).isCollisionShapeFullBlock(level, blockPos.south().west())) {
											return this.blockPos.south().west();
										} else return blockPos.above();
									}
								}
							}
						}
					}
				}
			} 
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (this.isReachedTarget()) {
				if (this.field_220731_g >= 20) {
					this.eatBerry();
				} else {
					++this.field_220731_g;
					Triceratops.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					Triceratops.this.level.playSound((Player)null, this.blockPos, SoundEvents.GRASS_HIT, SoundSource.NEUTRAL, 1, 1);
				}
			}
			if (Triceratops.this.getCurrentHunger() >= 13) {
				Triceratops.this.setEating(false);
			}
			super.tick();
		}

		protected void eatBerry() {
			int missingHunger = Triceratops.this.maxHunger - Triceratops.this.getCurrentHunger();
			int hunger = Triceratops.this.getCurrentHunger();
			FeederBlock block = (FeederBlock) Triceratops.this.level.getBlockState(this.blockPos).getBlock();
			int foodContained = block.getFoodAmount(Triceratops.this.level, this.blockPos);
			if (missingHunger <= foodContained) {
				block.setFoodAmount(foodContained - missingHunger, level, this.blockPos);
				Triceratops.this.setHunger(Triceratops.this.maxHunger);
				Triceratops.this.setEating(false);
				System.out.println(foodContained);
			} else if (foodContained - missingHunger < 0) {
				block.setFoodAmount(0, level, this.blockPos);
				Triceratops.this.setHunger(hunger + foodContained);
				Triceratops.this.setEating(false);
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Triceratops.this.isSleeping() && super.canUse() && Triceratops.this.getCurrentHunger() < Triceratops.this.getHalfHunger();
		}

		public void stop() {
			super.stop();
			Triceratops.this.setEating(false);
		}

		public boolean canContinueToUse() {
			if (Triceratops.this.getCurrentHunger() >= Triceratops.this.maxHunger || Triceratops.this.isSleeping()) {
				return false;
			} else return super.canContinueToUse();
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			this.field_220731_g = 0;
			super.start();
		}
	}

	public class TriceratopsTerritorialAttackGoal extends NearestAttackableTargetGoal<Player> {
		Triceratops dinosaur;

		public TriceratopsTerritorialAttackGoal(Triceratops dinosaur) {
			super(dinosaur, Player.class, true, true);
			this.dinosaur = dinosaur;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			if (dinosaur.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Triceratops dinosaur : dinosaur.level.getEntitiesOfClass(Triceratops.class, dinosaur.getBoundingBox().inflate(24.0D, 4.0D, 24.0D))) {
						if (!dinosaur.trusts(this.target.getUUID()) && dinosaur.isTerritorial() && !dinosaur.isTamed()) {
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

	public class TriceratopsAggressiveTempermentAttackGoal extends NearestAttackableTargetGoal<Player> {
		Triceratops dinosaur;

		public TriceratopsAggressiveTempermentAttackGoal(Triceratops dinosaur) {
			super(dinosaur, Player.class, true, true);
			this.dinosaur = dinosaur;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			if (dinosaur.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					if (!dinosaur.trusts(this.target.getUUID()) && dinosaur.isAggressive() && !dinosaur.isTamed()) {
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


}