package superlord.prehistoricfauna.common.entity;
import java.util.EnumSet;
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
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.common.Tags;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Psittacosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Diplodocus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFTags;
public class DinosaurEntity extends TamableAnimal {
	public enum ActivityPattern {
		DIURNAL, NOCTURNAL, CREPUSCULAR, CATHEMERAL;
		
		public static ActivityPattern fromNbt(String name) {
			try { return valueOf(name); }
			catch (IllegalArgumentException e) { return DIURNAL; }
		}
	}

	public enum Temperament {
		SKITTISH, PASSIVE, PROTECTIVE, TERRITORIAL, OPPORTUNIST, AGGRESSIVE;
		
		public static Temperament fromNbt(String name) {
			try { return valueOf(name); }
			catch (IllegalArgumentException e) { return PASSIVE; }
		}
	}

	public enum DietType {
		HERBIVORE, CARNIVORE, OMNIVORE, OVIVORE, PISCIVORE, MOLLUSCIVORE, INSECTIVORE;
		
		public static int toNbt(EnumSet<DietType> set) {
			int mask = 0;
			for (DietType d : set) mask |= (1 << d.ordinal());
			return mask;
		}
		
		public static EnumSet<DietType> fromNbt(int mask) {
			EnumSet<DietType> set = EnumSet.noneOf(DietType.class);
			for (DietType d : values()) {
				if ((mask & (1 << d.ordinal())) != 0) set.add(d);
			}
			return set;
		}
	}

	private static final EntityDataAccessor<Boolean> HAS_BABY = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_BIRTHING = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ASLEEP = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> ATTACK_TICK = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> SLEEP_TICK = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> ATTACK_DIR = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> EATING = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALBINO = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MELANISTIC = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_LOVE = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<String> ACTIVITY = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.STRING);
	private static final EntityDataAccessor<String> TEMPERAMENT = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.STRING);
	private static final EntityDataAccessor<Integer> DIET_MASK = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Optional<UUID>> DATA_TRUSTED_ID_0 = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.OPTIONAL_UUID);
	private static final EntityDataAccessor<Optional<UUID>> DATA_TRUSTED_ID_1 = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.OPTIONAL_UUID);
	public static final Predicate<Entity> AVOID_PLAYERS = (p) -> !p.isDiscrete() && EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(p);
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
	int healTick = 0;

	public DinosaurEntity(EntityType<? extends TamableAnimal> type, Level level) {
		super(type, level);
	}

	public static boolean canDinosaurSpawn(EntityType<? extends Animal> animal, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource random) {
		return (world.getBlockState(pos.below()).is(BlockTags.DIRT) || world.getBlockState(pos.below()).is(PFBlocks.SALT.get()) || world.getBlockState(pos.below()).is(PFBlocks.LOAM.get()) || world.getBlockState(pos.below()).is(PFBlocks.PACKED_LOAM.get()) || world.getBlockState(pos.below()).is(PFBlocks.SILT.get()) || world.getBlockState(pos.below()).is(PFBlocks.HARDENED_SILT.get()) || world.getBlockState(pos.below()).is(Blocks.PACKED_MUD) || world.getBlockState(pos.below()).is(Tags.Blocks.SAND)) && world.getRawBrightness(pos, 0) > 8;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ASLEEP, false);
		this.entityData.define(ATTACK_TICK, 0);
		this.entityData.define(SLEEP_TICK, 0);
		this.entityData.define(ATTACK_DIR, false);
		this.entityData.define(EATING, false);
		this.entityData.define(ALBINO, false);
		this.entityData.define(MELANISTIC, false);
		this.entityData.define(HAS_BABY, false);
		this.entityData.define(IS_BIRTHING, false);
		this.entityData.define(NATURAL_LOVE,false);
		this.entityData.define(DATA_TRUSTED_ID_0, Optional.empty());
		this.entityData.define(DATA_TRUSTED_ID_1, Optional.empty());
		this.entityData.define(ACTIVITY, ActivityPattern.DIURNAL.name());
		this.entityData.define(TEMPERAMENT, Temperament.PASSIVE.name());
		this.entityData.define(DIET_MASK, 0);
	}

	public boolean isAsleep() { 
		return this.entityData.get(ASLEEP); 
	}

	public void setAsleep(boolean v) { 
		this.entityData.set(ASLEEP, v); 
	}

	public boolean isEating() { 
		return this.entityData.get(EATING); 
	}

	public void setEating(boolean v) { 
		this.entityData.set(EATING, v); 
	}

	public boolean isAlbino() { 
		return this.entityData.get(ALBINO); 
	}

	private void setAlbino(boolean v) { 
		this.entityData.set(ALBINO, v); 
	}

	public boolean isMelanistic() { 
		return this.entityData.get(MELANISTIC); 
	}

	private void setMelanistic(boolean v){ 
		this.entityData.set(MELANISTIC, v); 
	}

	public boolean hasBaby() { 
		return this.entityData.get(HAS_BABY); 
	}

	public void setHasBaby(boolean v) { 
		this.entityData.set(HAS_BABY, v); 
	}

	public boolean isBirthing() { 
		return this.entityData.get(IS_BIRTHING); 
	}

	public void setBirthing(int ticks) {
		this.isBirthing = ticks;
		this.entityData.set(IS_BIRTHING, ticks > 0);
	}

	public boolean isInLoveNaturally() { 
		return this.entityData.get(NATURAL_LOVE);
	}

	private void setInLoveNaturally(boolean v) { 
		this.entityData.set(NATURAL_LOVE, v); 
	}

	public ActivityPattern getActivityPattern() {
		return ActivityPattern.fromNbt(this.entityData.get(ACTIVITY));
	}

	public void setActivityPattern(ActivityPattern pattern) {
		this.entityData.set(ACTIVITY, pattern.name());
	}

	public boolean isDiurnal() { 
		return getActivityPattern() == ActivityPattern.DIURNAL; 
	}

	public boolean isNocturnal() { 
		return getActivityPattern() == ActivityPattern.NOCTURNAL;
	}

	public boolean isCrepuscular() { 
		return getActivityPattern() == ActivityPattern.CREPUSCULAR; 
	}

	public boolean isCathemeral() {
		return getActivityPattern() == ActivityPattern.CATHEMERAL;
	}

	public void setDiurnal(boolean v) { 
		if (v) setActivityPattern(ActivityPattern.DIURNAL); 
	}

	public void setNocturnal(boolean v) { 
		if (v) setActivityPattern(ActivityPattern.NOCTURNAL); 
	}

	public void setCrepuscular(boolean v) { 
		if (v) setActivityPattern(ActivityPattern.CREPUSCULAR); 
	}

	public void setCathemeral(boolean v) {
		if (v) setActivityPattern(ActivityPattern.CATHEMERAL);
	}

	public Temperament getTemperament() {
		return Temperament.fromNbt(this.entityData.get(TEMPERAMENT));
	}

	public void setTemperament(Temperament t) {
		this.entityData.set(TEMPERAMENT, t.name());
	}

	public boolean isSkittish() { 
		return getTemperament() == Temperament.SKITTISH; 
	}

	public boolean isPassive() {
		return getTemperament() == Temperament.PASSIVE; 
	}

	public boolean isProtective() { 
		return getTemperament() == Temperament.PROTECTIVE; 
	}

	public boolean isTerritorial() {
		return getTemperament() == Temperament.TERRITORIAL; 
	}

	public boolean isOpportunist() { 
		return getTemperament() == Temperament.OPPORTUNIST; 
	}

	public boolean isAggressive() { 
		return getTemperament() == Temperament.AGGRESSIVE; 
	}

	public void setSkittish(boolean v) { 
		if (v) setTemperament(Temperament.SKITTISH); 
	}

	public void setPassive(boolean v) { 
		if (v) setTemperament(Temperament.PASSIVE); 
	}

	public void setProtective(boolean v) { 
		if (v) setTemperament(Temperament.PROTECTIVE); 
	}

	public void setTerritorial(boolean v) { 
		if (v) setTemperament(Temperament.TERRITORIAL); 
	}

	public void setOpportunist(boolean v) { 
		if (v) setTemperament(Temperament.OPPORTUNIST); 
	}

	public void setAggressive(boolean v) { 
		if (v) setTemperament(Temperament.AGGRESSIVE); 
	}

	public EnumSet<DietType> getDiet() {
		return DietType.fromNbt(this.entityData.get(DIET_MASK));
	}

	public void setDiet(EnumSet<DietType> diet) {
		this.entityData.set(DIET_MASK, DietType.toNbt(diet));
	}

	public void addDiet(DietType type) {
		EnumSet<DietType> diet = getDiet();
		diet.add(type);
		setDiet(diet);
	}

	public boolean hasDiet(DietType type) {
		return getDiet().contains(type);
	}

	public boolean isHerbivorous() { 
		return hasDiet(DietType.HERBIVORE); 
	}

	public boolean isCarnivorous() { 
		return hasDiet(DietType.CARNIVORE); 
	}

	public boolean isOmnivorous() { 
		return hasDiet(DietType.OMNIVORE); 
	}

	public boolean isOvivorous() { 
		return hasDiet(DietType.OVIVORE); 
	}

	public boolean isPiscivorous() { 
		return hasDiet(DietType.PISCIVORE); 
	}

	public boolean isMolluscivorous() { 
		return hasDiet(DietType.MOLLUSCIVORE); 
	}

	public boolean isInsectivorous() { 
		return hasDiet(DietType.INSECTIVORE); 
	}

	public void setHerbivorous(boolean v) { 
		if (v) addDiet(DietType.HERBIVORE); 
	}

	public void setCarnivorous(boolean v) { 
		if (v) addDiet(DietType.CARNIVORE); 
	}
	public void setOmnivorous(boolean v) { 
		if (v) addDiet(DietType.OMNIVORE); 
	}

	public void setOvivorous(boolean v) { 
		if (v) addDiet(DietType.OVIVORE); 
	}

	public void setPiscivorous(boolean v) { 
		if (v) addDiet(DietType.PISCIVORE); 
	}

	public void setMolluscivorous(boolean v) { 
		if (v) addDiet(DietType.MOLLUSCIVORE); 
	}

	public void setInsectivorous(boolean v) { 
		if (v) addDiet(DietType.INSECTIVORE); 
	}

	public int getCurrentHunger() { 
		return this.currentHunger; 
	}

	public void setHunger(int hunger) { 
		this.currentHunger = hunger; 
	}

	public int getHalfHunger() { 
		return maxHunger / 2; 
	}

	public int getThreeQuartersHunger() { 
		return (maxHunger / 4) * 3; 
	}

	List<UUID> getTrustedUUIDs() {
		List<UUID> list = Lists.newArrayList();
		list.add(this.entityData.get(DATA_TRUSTED_ID_0).orElse(null));
		list.add(this.entityData.get(DATA_TRUSTED_ID_1).orElse(null));
		return list;
	}

	public void addTrustedUUID(@Nullable UUID uuid) {
		if (this.entityData.get(DATA_TRUSTED_ID_0).isPresent()) {
			this.entityData.set(DATA_TRUSTED_ID_1, Optional.ofNullable(uuid));
		} else {
			this.entityData.set(DATA_TRUSTED_ID_0, Optional.ofNullable(uuid));
		}
	}

	public void removeTrustedUUID(@Nullable UUID uuid) {
		if (this.entityData.get(DATA_TRUSTED_ID_0).equals(Optional.ofNullable(uuid))) {
			this.entityData.set(DATA_TRUSTED_ID_0, Optional.empty());
		} else if (this.entityData.get(DATA_TRUSTED_ID_1).equals(Optional.ofNullable(uuid))) {
			this.entityData.set(DATA_TRUSTED_ID_1, Optional.empty());
		}
	}
	public boolean trusts(UUID uuid) {
		return this.getTrustedUUIDs().contains(uuid);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		ListTag listtag = new ListTag();
		for (UUID uuid : this.getTrustedUUIDs()) {
			if (uuid != null) listtag.add(NbtUtils.createUUID(uuid));
		}
		compound.put("Trusted", listtag);
		compound.putBoolean("IsAsleep", this.isAsleep());
		compound.putBoolean("IsEating", this.isEating());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putBoolean("HasBaby", this.hasBaby());
		compound.putInt("CurrentHunger", this.currentHunger);
		compound.putBoolean("InNaturalLove",this.isInLoveNaturally());
		compound.putInt("IsBirthingTick", this.isBirthing);
		compound.putString("ActivityPattern", this.getActivityPattern().name());
		compound.putString("Temperament", this.getTemperament().name());
		compound.putInt("DietMask", DietType.toNbt(this.getDiet()));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		ListTag listtag = compound.getList("Trusted", 11);
		for (int i = 0; i < listtag.size(); ++i) {
			this.addTrustedUUID(NbtUtils.loadUUID(listtag.get(i)));
		}
		this.setAsleep(compound.getBoolean("IsAsleep"));
		this.setEating(compound.getBoolean("IsEating"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setHasBaby(compound.getBoolean("HasBaby"));
		this.setHunger(compound.getInt("CurrentHunger"));
		this.setInLoveNaturally(compound.getBoolean("InNaturalLove"));
		this.isBirthing = compound.getInt("IsBirthingTick");
		this.entityData.set(IS_BIRTHING, this.isBirthing > 0);
		this.setActivityPattern(ActivityPattern.fromNbt(compound.getString("ActivityPattern")));
		this.setTemperament(Temperament.fromNbt(compound.getString("Temperament")));
		this.setDiet(DietType.fromNbt(compound.getInt("DietMask")));
	}

	private boolean tryFeed(ItemStack stack, net.minecraft.tags.TagKey<Item> tag, int amount, Player player) {
		if (!stack.is(tag)) return false;
		this.setHunger(Math.min(currentHunger + amount, maxHunger));
		if (!player.isCreative()) stack.shrink(1);
		return true;
	}

	@SuppressWarnings("unused")
	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);
		if (PrehistoricFaunaConfig.advancedHunger) {
			if (currentHunger < maxHunger) {
				if (this.isFood(stack) && (!this.isInLove() || !this.isInLoveNaturally()) && !this.isBaby()) {
					this.setInLove(player);
					if (!player.isCreative()) stack.shrink(1);
					return super.mobInteract(player, hand);
				}
				boolean fed = false;
				if (isInsectivorous()) {
					fed |= tryFeed(stack, PFTags.INSECTS_2_HUNGER_ITEM, 2, player);
				}
				if (isHerbivorous() || isOmnivorous()) {
					fed |= tryFeed(stack, PFTags.PLANTS_2_HUNGER_ITEM, 2, player);
					fed |= tryFeed(stack, PFTags.PLANTS_4_HUNGER_ITEM, 4, player);
					fed |= tryFeed(stack, PFTags.PLANTS_6_HUNGER_ITEM, 6, player);
					fed |= tryFeed(stack, PFTags.PLANTS_8_HUNGER_ITEM, 8, player);
					fed |= tryFeed(stack, PFTags.PLANTS_10_HUNGER_ITEM, 10, player);
					fed |= tryFeed(stack, PFTags.PLANTS_12_HUNGER_ITEM, 12, player);
					fed |= tryFeed(stack, PFTags.PLANTS_15_HUNGER_ITEM, 15, player);
					fed |= tryFeed(stack, PFTags.PLANTS_20_HUNGER_ITEM, 20, player);
					fed |= tryFeed(stack, PFTags.PLANTS_25_HUNGER_ITEM, 25, player);
					fed |= tryFeed(stack, PFTags.PLANTS_30_HUNGER_ITEM, 30, player);
					if (stack.is(PFTags.PLANTS_6_HUNGER_ITEM) && stack.is(ItemTags.LEAVES) && this instanceof Diplodocus && stack.getItem() instanceof BlockItem blockItem) {
						if (!this.level().isClientSide() && this.level() instanceof ServerLevel serverLevel) {
							BlockState state = blockItem.getBlock().defaultBlockState();
							LootParams.Builder builder = new LootParams.Builder(serverLevel).withParameter(LootContextParams.ORIGIN, this.position()).withParameter(LootContextParams.TOOL, ItemStack.EMPTY);
							state.getDrops(builder).forEach(this::spawnAtLocation);
						}
					}
					if (stack.is(PFItems.MARMARTHIA_BERRIES.get().asItem())) {
						this.setHunger(Math.min(currentHunger + 2, maxHunger));
						if (!player.isCreative()) stack.shrink(1);
						this.addEffect(new MobEffectInstance(MobEffects.POISON, 300));
						fed = true;
					}
				}
				if (isCarnivorous() || isOvivorous() || isOmnivorous() || isMolluscivorous() || isPiscivorous()) {
					fed |= tryFeed(stack, PFTags.MEATS_2_HUNGER, 2, player);
					fed |= tryFeed(stack, PFTags.MEATS_4_HUNGER, 4, player);
					fed |= tryFeed(stack, PFTags.MEATS_6_HUNGER, 6, player);
					fed |= tryFeed(stack, PFTags.MEATS_8_HUNGER, 8, player);
					fed |= tryFeed(stack, PFTags.MEATS_10_HUNGER, 10, player);
					fed |= tryFeed(stack, PFTags.MEATS_12_HUNGER, 12, player);
				}
				if (isOvivorous()) {
					fed |= tryFeed(stack, PFTags.EGGS_5_HUNGER, 5, player);
					fed |= tryFeed(stack, PFTags.EGGS_10_HUNGER, 10, player);
					fed |= tryFeed(stack, PFTags.EGGS_15_HUNGER, 15, player);
				}
				if (isMolluscivorous()) {
					fed |= tryFeed(stack, PFTags.SHELLFISH_3_HUNGER, 3, player);
				}
				if (isPiscivorous()) {
					fed |= tryFeed(stack, PFTags.FISH_2_HUNGER, 2, player);
					fed |= tryFeed(stack, PFTags.FISH_4_HUNGER, 4, player);
				}
			} else {
				if (isRelevantFood(stack)) {
					player.displayClientMessage(Component.translatable("entity.prehistoricfauna.fullHunger"), true);
				}
			}
		}
		return super.mobInteract(player, hand);
	}

	private boolean isRelevantFood(ItemStack stack) {
		if (isInsectivorous() && stack.is(PFTags.INSECTS_2_HUNGER_ITEM)) return true;
		if (isHerbivorous() || isOmnivorous()) {
			if (stack.is(PFTags.PLANTS_2_HUNGER_ITEM) || stack.is(PFTags.PLANTS_4_HUNGER_ITEM) || stack.is(PFTags.PLANTS_6_HUNGER_ITEM) || stack.is(PFTags.PLANTS_8_HUNGER_ITEM) || stack.is(PFTags.PLANTS_10_HUNGER_ITEM) || stack.is(PFTags.PLANTS_12_HUNGER_ITEM) || stack.is(PFTags.PLANTS_15_HUNGER_ITEM) || stack.is(PFTags.PLANTS_20_HUNGER_ITEM) || stack.is(PFTags.PLANTS_25_HUNGER_ITEM) || stack.is(PFTags.PLANTS_30_HUNGER_ITEM)) return true;
		}
		if ((isCarnivorous() || isOmnivorous() || isPiscivorous() || isOvivorous() || isMolluscivorous()) && (stack.is(PFTags.MEATS_2_HUNGER) || stack.is(PFTags.MEATS_4_HUNGER) || stack.is(PFTags.MEATS_6_HUNGER) || stack.is(PFTags.MEATS_8_HUNGER) || stack.is(PFTags.MEATS_10_HUNGER) || stack.is(PFTags.MEATS_12_HUNGER))) return true;
		if (isOvivorous() && (stack.is(PFTags.EGGS_5_HUNGER) || stack.is(PFTags.EGGS_10_HUNGER) || stack.is(PFTags.EGGS_15_HUNGER))) return true;
		if (isMolluscivorous() && stack.is(PFTags.SHELLFISH_3_HUNGER)) return true;
		if (isPiscivorous() && (stack.is(PFTags.FISH_2_HUNGER) || stack.is(PFTags.FISH_4_HUNGER))) return true;
		return false;
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isAsleep()) {
			this.getNavigation().stop();
		}
		if (!this.isNoAi()) {
			if (this.isAsleep()) tickSleepWakeChecks();
			tickPsittacosaurusGrowth();
			if (PrehistoricFaunaConfig.advancedHunger) {
				tickHunger();
				if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
					tickNaturalBreeding(true);
				}
			} else if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
				tickNaturalBreeding(false);
			}
			if (lastInLove != 0) lastInLove--;
		}
		if (!this.level().isClientSide()) {
			if (this.warryTicks != 0) warryTicks--;
		}
	}

	private void tickSleepWakeChecks() {
		long timeOfDay = this.level().getDayTime() % 24000;
		boolean shouldWake = false;
		switch (getActivityPattern()) {
		case DIURNAL -> shouldWake = timeOfDay > 0 && timeOfDay < 12000;
		case NOCTURNAL -> shouldWake = timeOfDay > 12000 && timeOfDay < 24000;
		case CREPUSCULAR -> shouldWake = timeOfDay < 2000 || (timeOfDay > 9000 && timeOfDay < 14000) || timeOfDay > 21000;
		case CATHEMERAL  -> shouldWake = true;
		}
		if (!shouldWake) {
			shouldWake = this.getLastHurtByMob() != null || this.isInWater() || this.isInLava() || this.isOnFire() || this.isInWall() || this.isInPowderSnow;
			if (!shouldWake) {
				for (Player p : this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(2D, 2D, 2D))) {
					if (!p.isShiftKeyDown()) { shouldWake = true; break; }
				}
			}
		}
		if (shouldWake) wakeUp();
	}

	private void wakeUp() {
		this.setAsleep(false);
		this.setAwakeTicks(100);
		this.setFallingAsleep();
	}

	private void tickPsittacosaurusGrowth() {
		if (!this.isBaby()) return;
		for (Psittacosaurus p : this.level().getEntitiesOfClass(Psittacosaurus.class, this.getBoundingBox().inflate(5))) {
			if (!p.isBaby()) {
				int age = this.getAge();
				if (age < -1) this.setAge(age + 2);
			}
		}
	}

	private void tickHunger() {
		hungerTick++;
		int threshold = this.isBaby() ? 300 : 600;
		if (hungerTick >= threshold) {
			if (!this.isAsleep()) {
				if (currentHunger != 0) {
					this.setHunger(currentHunger - 1);
				} else if (PrehistoricFaunaConfig.hungerDamage) {
					boolean hardMode = level().getDifficulty() == Difficulty.HARD;
					if (this.getHealth() > (this.getMaxHealth() / 2) || hardMode) {
						this.hurt(this.damageSources().starve(), 1);
					}
				}
			}
			hungerTick = 0;
		}
		if (currentHunger == 0 && !this.isBaby()) {
			List<UUID> trusted = this.getTrustedUUIDs();
			for (UUID uuid : trusted) {
				if (uuid != null) this.removeTrustedUUID(uuid);
			}
		}
		if (this.getCurrentHunger() >= this.getThreeQuartersHunger()) {
			healTick++;
			if (healTick >= 150) {
				if (this.getHealth() < this.getMaxHealth() && this.getHealth() != 0 && this.getTarget() == null && this.getLastHurtByMob() == null) {
					this.setHealth(this.getHealth() + 1);
				}
				healTick = 0;
			}
		} else {
			healTick = 0;
		}
	}

	private void tickNaturalBreeding(boolean requireHunger) {
		List<? extends DinosaurEntity> nearby = this.level().getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(48.0D, 48.0D, 48.0D));
		int maxPop = requireHunger ? 10 : 20;
		if (requireHunger) {
			if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && tickCount % 900 == 0 && !this.isBaby() && !this.isInLove() && !this.isAsleep() && nearby.size() < maxPop) {
				startNaturalLove();
			}
		} else {
			if (lastInLove == 0 && random.nextInt(1000) == 0 && !this.isBaby() && !this.isInLove() && !this.isAsleep() && nearby.size() < maxPop) {
				startNaturalLove();
			}
		}
		if (loveTick != 0) {
			loveTick--;
		} else {
			this.setInLoveNaturally(false);
		}
	}

	private void startNaturalLove() {
		loveTick = 600;
		this.setInLoveNaturally(true);
		this.setInLoveTime(600);
		lastInLove = 28800;
	}

	@Override
	public void tick() {
		super.tick();
		prevSleepProgress = sleepProgress;
		prevMeleeProgress = meleeProgress;
		if (this.entityData.get(SLEEP_TICK) > 0) {
			this.entityData.set(SLEEP_TICK, this.entityData.get(SLEEP_TICK) - 1);
			sleepProgress = Math.min(sleepProgress + 0.1F, 1.0F);
		} else {
			if (sleepProgress > 0F) sleepProgress = Math.max(sleepProgress - 0.2F, 0.0F);
		}
		if (this.entityData.get(ATTACK_TICK) > 0) {
			LivingEntity target = this.getTarget();
			if (this.entityData.get(ATTACK_TICK) == 1 && target != null && this.hasLineOfSight(target) && this.distanceTo(target) < this.getMeleeRange() + this.getBbWidth() + target.getBbWidth()) {
			    this.onAttackAnimationFinish(target);
			}
			this.entityData.set(ATTACK_TICK, this.entityData.get(ATTACK_TICK) - 1);
			meleeProgress = Math.min(meleeProgress + 0.2F, 1.0F);
		} else {
			if (meleeProgress > 0F) meleeProgress = Math.max(meleeProgress - 0.2F, 0.0F);
		}
	}

	public float getMeleeRange() { 
		return 1.5F; 
	}

	public boolean getMeleeDirection() {
		return this.entityData.get(ATTACK_DIR); 
	}

	@Override
	public boolean doHurtTarget(Entity target) {
		if (this.entityData.get(ATTACK_TICK) == 0) {
			this.entityData.set(ATTACK_DIR, random.nextBoolean());
		}
		this.entityData.set(ATTACK_TICK, 7);
		return true;
	}

	public boolean onAttackAnimationFinish(Entity target) {
		return target.hurt(this.damageSources().mobAttack(this), (float) ((int) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue()));
	}

	public float getSleepProgress(float partialTick) {
		return prevSleepProgress + (sleepProgress - prevSleepProgress) * partialTick;
	}

	public float getMeleeProgress(float partialTick) {
		return prevMeleeProgress + (meleeProgress - prevMeleeProgress) * partialTick;
	}

	public void setFallingAsleep() { 
		this.entityData.set(SLEEP_TICK, 15); 
	}

	public void setAwakeTicks(int ticks) {
		if (!this.level().isClientSide()) this.warryTicks = ticks;
	}

	@Override
	protected void onOffspringSpawnedFromEgg(Player player, Mob offspring) {
		((DinosaurEntity) offspring).addTrustedUUID(player.getUUID());
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob other) { 
		return null; 
	}

	@Nullable
	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag tag) {
		int roll = new Random().nextInt(799);
		if (roll < 4) this.setAlbino(true);
		else if (roll < 7) this.setMelanistic(true);
		this.setHunger(maxHunger);
		return super.finalizeSpawn(world, difficulty, reason, spawnData, tag);
	}

	public Item getEggItem() { 
		return null; 
	}

	public BlockState getEggBlock(Level world, BlockPos pos) { 
		return null; 
	}
}