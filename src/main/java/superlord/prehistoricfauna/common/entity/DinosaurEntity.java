package superlord.prehistoricfauna.common.entity;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFTags;

public class DinosaurEntity extends TamableAnimal {
	private static final EntityDataAccessor<Boolean> HAS_BABY = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_BIRTHING = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ASLEEP = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> ATTACK_TICK = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> ATTACK_DIR = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> EATING = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALBINO = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MELANISTIC = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_LOVE = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SKITTISH = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> PASSIVE = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> PROTECTIVE = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> TERRITORIAL = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> OPPORTUNIST = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> AGGRESSIVE = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HERBIVORE = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> CARNIVORE = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> OMNIVORE = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> OVIVORE = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> PISCIVORE = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MOLLUSCIVORE = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Optional<UUID>> DATA_TRUSTED_ID_0 = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.OPTIONAL_UUID);
	private static final EntityDataAccessor<Optional<UUID>> DATA_TRUSTED_ID_1 = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.OPTIONAL_UUID);
	private static final EntityDataAccessor<Integer> FALLING_ASLEEP_TICKS = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> WAKING_UP_TICKS = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> SITTING_DOWN_TICKS = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> CROUCHING_TICKS = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.INT);
	public static final Predicate<Entity> AVOID_PLAYERS = (p_28463_) -> {
		return !p_28463_.isDiscrete() && EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(p_28463_);
	};
	private float sleepProgress = 0.0F;
	private float prevSleepProgress = 0.0F;
	private float meleeProgress = 0.0F;
	private float prevMeleeProgress = 0.0F;
	public int isBirthing;
	int loveTick = 0;
	public int maxHunger;
	private int lastInLove = 0;
	public int currentHunger;
	public int warryTicks = 0;
	int hungerTick = 0;

	public int fallingAsleepTicks = 31;
	public int wakingUpTicks = 31;
	public int sittingTicks = 31;
	public int crouchingTicks = 31;

	protected DinosaurEntity(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
	}

	public static boolean canDinosaurSpawn(EntityType<? extends Animal> animal, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, Random random) {
		return (worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) || worldIn.getBlockState(pos.below()).is(Tags.Blocks.SAND)) && worldIn.getRawBrightness(pos, 0) > 8;
	}

	public boolean isAsleep() {
		return this.entityData.get(ASLEEP);
	}

	public void setAsleep(boolean isAsleep) {
		this.entityData.set(ASLEEP, isAsleep);
	}

	public boolean isEating() {
		return this.entityData.get(EATING);
	}

	public void setEating(boolean isEating) {
		this.entityData.set(EATING, isEating);
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

	public boolean hasBaby() {
		return this.entityData.get(HAS_BABY);
	}

	public void setHasBaby(boolean hasBaby) {
		this.entityData.set(HAS_BABY, hasBaby);
	}

	public boolean isBirthing() {
		return this.entityData.get(IS_BIRTHING);
	}

	public void setBirthing(boolean isBirthing) {
		this.isBirthing = isBirthing ? 1 : 0;
		this.entityData.set(IS_BIRTHING, isBirthing);
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

	public void setHunger(int currentHunger) {
		this.currentHunger = currentHunger;
	}

	public int getHalfHunger() {
		return maxHunger / 2;
	}

	public int getThreeQuartersHunger() {
		return (maxHunger / 4) * 3;
	}

	public boolean isSkittish() {
		return this.entityData.get(SKITTISH);
	}

	public void setSkittish(boolean isSkittish) {
		this.entityData.set(SKITTISH, isSkittish);
	}

	public boolean isPassive() {
		return this.entityData.get(PASSIVE);
	}

	public void setPassive(boolean isPassive) {
		this.entityData.set(PASSIVE, isPassive);
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

	public boolean isOpportunist() {
		return this.entityData.get(OPPORTUNIST);
	}

	public void setOpportunist(boolean isOpportunist) {
		this.entityData.set(OPPORTUNIST, isOpportunist);
	}

	public boolean isAggressive() {
		return this.entityData.get(AGGRESSIVE);
	}

	public void setAggressive(boolean isAggressive) {
		this.entityData.set(AGGRESSIVE, isAggressive);
	}

	public boolean isHerbivorous() {
		return this.entityData.get(HERBIVORE);
	}

	public void setHerbivorous(boolean isHerbivorous) {
		this.entityData.set(HERBIVORE, isHerbivorous);
	}

	public boolean isCarnivorous() {
		return this.entityData.get(CARNIVORE);
	}

	public void setCarnivorous(boolean isCarnivorous) {
		this.entityData.set(CARNIVORE, isCarnivorous);
	}

	public boolean isOmnivorous() {
		return this.entityData.get(OMNIVORE);
	}

	public void setOmnivorous(boolean isOmnivorous) {
		this.entityData.set(OMNIVORE, isOmnivorous);
	}

	public boolean isOvivorous() {
		return this.entityData.get(OVIVORE);
	}

	public void setOvivorous(boolean isOvivorous) {
		this.entityData.set(OVIVORE, isOvivorous);
	}

	public boolean isMolluscivorous() {
		return this.entityData.get(MOLLUSCIVORE);
	}

	public void setMolluscivorous(boolean isMolluscivorous) {
		this.entityData.set(MOLLUSCIVORE, isMolluscivorous);
	}

	public boolean isPiscivorous() {
		return this.entityData.get(PISCIVORE);
	}

	public void setPiscivorous(boolean isPiscivorous) {
		this.entityData.set(PISCIVORE, isPiscivorous);
	}

	public int getFallingAsleepTicks() {
		return this.entityData.get(FALLING_ASLEEP_TICKS);
	}

	public void setFallingAsleepTicks(int fallingAsleepTicks) {
		this.entityData.set(FALLING_ASLEEP_TICKS, fallingAsleepTicks);
	}

	public int getWakingTicks() {
		return this.entityData.get(WAKING_UP_TICKS);
	}

	public void setWakingTicks(int wakingTicks) {
		this.entityData.set(WAKING_UP_TICKS, wakingTicks);
	}

	public int getSittingTicks() {
		return this.entityData.get(SITTING_DOWN_TICKS);
	}

	public void setSittingTicks(int sittingTicks) {
		this.entityData.set(SITTING_DOWN_TICKS, sittingTicks);
	}

	public int getCrouchingTicks() {
		return this.entityData.get(CROUCHING_TICKS);
	}

	public void setCrouchingTicks(int crouchingTicks) {
		this.entityData.set(CROUCHING_TICKS, crouchingTicks);
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

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ASLEEP, false);
		this.entityData.define(ATTACK_TICK, 0);
		this.entityData.define(ATTACK_DIR, false);
		this.entityData.define(EATING, false);
		this.entityData.define(ALBINO, false);
		this.entityData.define(MELANISTIC, false);
		this.entityData.define(HAS_BABY, false);
		this.entityData.define(IS_BIRTHING, false);
		this.entityData.define(NATURAL_LOVE, false);
		this.entityData.define(DATA_TRUSTED_ID_0, Optional.empty());
		this.entityData.define(DATA_TRUSTED_ID_1, Optional.empty());
		this.entityData.define(SKITTISH, false);
		this.entityData.define(PASSIVE, false);
		this.entityData.define(PROTECTIVE, false);
		this.entityData.define(TERRITORIAL, false);
		this.entityData.define(OPPORTUNIST, false);
		this.entityData.define(AGGRESSIVE, false);
		this.entityData.define(HERBIVORE, false);
		this.entityData.define(CARNIVORE, false);
		this.entityData.define(OMNIVORE, false);
		this.entityData.define(OVIVORE, false);
		this.entityData.define(MOLLUSCIVORE, false);
		this.entityData.define(PISCIVORE, false);
		this.entityData.define(FALLING_ASLEEP_TICKS, 31);
		this.entityData.define(WAKING_UP_TICKS, 31);
		this.entityData.define(SITTING_DOWN_TICKS, 31);
		this.entityData.define(CROUCHING_TICKS, 31);
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
		compound.putBoolean("IsAsleep", this.isAsleep());
		compound.putBoolean("IsEating", this.isEating());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putBoolean("HasBaby", this.hasBaby());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
		compound.putBoolean("IsSkittish", this.isSkittish());
		compound.putBoolean("IsPassive", this.isPassive());
		compound.putBoolean("IsProtective", this.isProtective());
		compound.putBoolean("IsTerritorial", this.isTerritorial());
		compound.putBoolean("IsOpportunist", this.isOpportunist());
		compound.putBoolean("IsAggressive", this.isAggressive());
		compound.putBoolean("IsHerbivorous", this.isHerbivorous());
		compound.putBoolean("IsCarnivorous", this.isCarnivorous());
		compound.putBoolean("IsOmnivorous", this.isOmnivorous());
		compound.putBoolean("IsOvivorous", this.isOvivorous());
		compound.putBoolean("IsMolluscivorous", this.isMolluscivorous());
		compound.putBoolean("IsPiscivorous", this.isPiscivorous());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		ListTag listtag = compound.getList("Trusted", 11);
		for(int i = 0; i < listtag.size(); ++i) {
			this.addTrustedUUID(NbtUtils.loadUUID(listtag.get(i)));
		}
		this.setAsleep(compound.getBoolean("IsAsleep"));
		this.setEating(compound.getBoolean("IsEating"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setHasBaby(compound.getBoolean("HasBaby"));
		this.setHunger(compound.getInt("MaxHunger"));
		this.setInLoveNaturally(compound.getBoolean("InNaturalLove"));
		this.setSkittish(compound.getBoolean("IsSkittish"));
		this.setPassive(compound.getBoolean("IsPassive"));
		this.setProtective(compound.getBoolean("IsProtective"));
		this.setTerritorial(compound.getBoolean("IsTerritorial"));
		this.setOpportunist(compound.getBoolean("IsOpportunist"));
		this.setAggressive(compound.getBoolean("IsAggressive"));
		this.setHerbivorous(compound.getBoolean("IsHerbivorous"));
		this.setCarnivorous(compound.getBoolean("IsCarnivorous"));
		this.setOmnivorous(compound.getBoolean("IsOmniivorous"));
		this.setOvivorous(compound.getBoolean("IsOvivorous"));
		this.setMolluscivorous(compound.getBoolean("IsMolluscivorous"));
		this.setPiscivorous(compound.getBoolean("IsPiscivorous"));
	}

	public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {
		ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
		if (PrehistoricFaunaConfig.advancedHunger) {
			int hunger = this.getCurrentHunger();
			if (hunger < this.maxHunger) {
				if (this.isFood(itemstack) && (!this.isInLove() || !this.isInLoveNaturally())) {
					this.setInLove(p_230254_1_);
					itemstack.shrink(1);
				} else {
					if (this.isHerbivorous() || this.isOmnivorous()) {
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
					if (this.isCarnivorous() || this.isOvivorous() || this.isOmnivorous() || this.isMolluscivorous() || this.isPiscivorous()) {
						if (itemstack.is(PFTags.MEATS_2_HUNGER)) {
							if (hunger + 2 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 2);
							}
							if (!p_230254_1_.isCreative()) {
								itemstack.shrink(1);
							}
						}
						if (itemstack.is(PFTags.MEATS_4_HUNGER)) {
							if (hunger + 4 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 4);
							}
							if (!p_230254_1_.isCreative()) {
								itemstack.shrink(1);
							}
						}
						if (itemstack.is(PFTags.MEATS_6_HUNGER)) {
							if (hunger + 6 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 6);
							}
							if (!p_230254_1_.isCreative()) {
								itemstack.shrink(1);
							}
						}
						if (itemstack.is(PFTags.MEATS_8_HUNGER)) {
							if (hunger + 8 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 8);
							}
							if (!p_230254_1_.isCreative()) {
								itemstack.shrink(1);
							}
						}
						if (itemstack.is(PFTags.MEATS_10_HUNGER)) {
							if (hunger + 10 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 10);
							}
							if (!p_230254_1_.isCreative()) {
								itemstack.shrink(1);
							}
						}
						if (itemstack.is(PFTags.MEATS_12_HUNGER)) {
							if (hunger + 12 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 12);
							}
							if (!p_230254_1_.isCreative()) {
								itemstack.shrink(1);
							}
						}
					}
					if (this.isOvivorous()) {
						if (itemstack.is(PFTags.EGGS_5_HUNGER)) {
							if (this.getCurrentHunger() + 5 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(currentHunger + 5);
							}
							if (!p_230254_1_.isCreative()) {
								itemstack.shrink(1);
							}
						}
						if (itemstack.is(PFTags.EGGS_10_HUNGER)) {
							if (this.getCurrentHunger() + 10 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(currentHunger + 10);
							}
							if (!p_230254_1_.isCreative()) {
								itemstack.shrink(1);
							}
						}
						if (itemstack.is(PFTags.EGGS_15_HUNGER)) {
							if (this.getCurrentHunger() + 15 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(currentHunger + 15);
							}
							if (!p_230254_1_.isCreative()) {
								itemstack.shrink(1);
							}
						}
					}
					if (this.isMolluscivorous()) {
						if (itemstack.is(PFTags.SHELLFISH_3_HUNGER)) {
							if (hunger + 3 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 3);
							}
							if (!p_230254_1_.isCreative()) {
								itemstack.shrink(1);
							}
						}
					}
					if (this.isPiscivorous()) {
						if (itemstack.is(PFTags.FISH_2_HUNGER)) {
							if (hunger + 2 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 2);
							}
							itemstack.shrink(1);
						}
						if (itemstack.is(PFTags.FISH_4_HUNGER)) {
							if (hunger + 4 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 4);
							}
							itemstack.shrink(1);
						}
					}
				}
			} else {
				if (this.isMolluscivorous()) {
					if (itemstack.is(PFTags.SHELLFISH_3_HUNGER)) {
						p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.fullHunger"), true);
					}
				}
				if (this.isOvivorous()) {
					if (itemstack.is(PFTags.EGGS_5_HUNGER) || itemstack.is(PFTags.EGGS_10_HUNGER) || itemstack.is(PFTags.EGGS_15_HUNGER)) {
						p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.fullHunger"), true);
					}
				}
				if (this.isCarnivorous() || this.isOmnivorous() || this.isPiscivorous() || this.isOvivorous() || this.isMolluscivorous()) {
					if (itemstack.is(PFTags.MEATS_2_HUNGER) || itemstack.is(PFTags.MEATS_4_HUNGER) || itemstack.is(PFTags.MEATS_6_HUNGER) || itemstack.is(PFTags.MEATS_8_HUNGER) || itemstack.is(PFTags.MEATS_10_HUNGER) || itemstack.is(PFTags.MEATS_12_HUNGER)) {
						p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.fullHunger"), true);
					}
				}
				if (this.isHerbivorous() || this.isOmnivorous()) {
					if ((itemstack.is(PFTags.PLANTS_2_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_4_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_6_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_8_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_10_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_12_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_15_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_20_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_25_HUNGER_ITEM) || itemstack.is(PFTags.PLANTS_30_HUNGER_ITEM))) {
						p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.fullHunger"), true);
					}
				}
				if (this.isPiscivorous()) {
					if (itemstack.is(PFTags.FISH_2_HUNGER) || itemstack.is(PFTags.FISH_4_HUNGER)) {
						p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.fullHunger"), true);
					}
				}
			}
		}
		return super.mobInteract(p_230254_1_, p_230254_2_);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isAsleep()) this.navigation.setSpeedModifier(0);
		if (!this.isNoAi()) {
			List<? extends DinosaurEntity> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(48.0D, 48.0D, 48.0D));
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
					if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && tickCount % 900 == 0  && !this.isBaby() && !this.isInLove() && !this.isAsleep() && list.size() < 10) {
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
			} else if ((PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && !PrehistoricFaunaConfig.advancedHunger) {
				int naturalBreedingChance = random.nextInt(1000);

				if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isBaby() && !this.isInLove() && !this.isAsleep() && list.size() < 20) {
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
			//System.out.println(warryTicks);
		}
		if (this.getWakingTicks() != 31) this.setWakingTicks(this.getWakingTicks() + 1);
		if (this.getFallingAsleepTicks() != 31) this.setFallingAsleepTicks(this.getFallingAsleepTicks() + 1);
		if (this.getSittingTicks() != 31) this.setSittingTicks(this.getSittingTicks() + 1);
		if (this.getCrouchingTicks() != 31) this.setCrouchingTicks(this.getCrouchingTicks() + 1);
	}

	public void setAwakeTicks(int ticks) {
		if (!this.level.isClientSide) {
			this.warryTicks = ticks;
		}
	}

	public void tick() {
		super.tick();
		prevSleepProgress = sleepProgress;
		prevMeleeProgress = meleeProgress;
		if (this.isAsleep() && sleepProgress < 1.0F) {
			sleepProgress = Math.min(sleepProgress + 0.2F, 1.0F);
		}
		if (!this.isAsleep() && sleepProgress > 0.0F) {
			sleepProgress = Math.max(sleepProgress - 0.2F, 0.0F);
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

	//additional melee range, change this for dinosaurs with longer reach
	public float getMeleeRange() {
		return 1.5F;
	}

	//some dinosaurs(ex. ankylosaurus) have alternate attack patterns that have left/right differences. This boolean is true if the current melee attack is coming from the left and false if from the right.
	public boolean getMeleeDirection() {
		return this.entityData.get(ATTACK_DIR);
	}

	protected void onOffspringSpawnedFromEgg(Player p_28481_, Mob p_28482_) {
		((DinosaurEntity)p_28482_).addTrustedUUID(p_28481_.getUUID());
	}

	public boolean trusts(UUID p_28530_) {
		return this.getTrustedUUIDs().contains(p_28530_);
	}

	public boolean doHurtTarget(Entity entityIn) {
		if(this.entityData.get(ATTACK_TICK) == 0){
			this.entityData.set(ATTACK_DIR, random.nextBoolean());
		}
		//now simply starts counting down till the actual damage is done, starts the animation
		this.entityData.set(ATTACK_TICK, 7);
		return true;
	}

	public boolean onAttackAnimationFinish(Entity target) {
		return target.hurt(DamageSource.mobAttack(this), (float) ((int) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue()));
	}

	//lerped number from 0.0 - 1.0 that determines where in the sleep animation this entity is
	public float getSleepProgress(float partialTick) {
		return prevSleepProgress + (sleepProgress - prevSleepProgress) * partialTick;
	}

	//lerped number from 0.0 - 1.0 that determines where in the melee animation this entity is
	public float getMeleeProgress(float partialTick) {
		return prevMeleeProgress + (meleeProgress - prevMeleeProgress) * partialTick;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		return null;
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
		this.setHunger(maxHunger);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public Item getEggItem() {
		return null;
	}

	public BlockState getEggBlock() {
		return null;
	}

}
