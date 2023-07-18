package superlord.prehistoricfauna.common.entity.triassic.ischigualasto;

import java.util.EnumSet;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Containers;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.NocturnalSleepGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Exaeretodon extends DinosaurEntity {

	private static final EntityDataAccessor<Boolean> HAS_EGG = SynchedEntityData.defineId(Exaeretodon.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_DIGGING = SynchedEntityData.defineId(Exaeretodon.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALBINO = SynchedEntityData.defineId(Exaeretodon.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MELANISTIC = SynchedEntityData.defineId(Exaeretodon.class, EntityDataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(PFBlocks.CLADOPHLEBIS.get().asItem());
	private static final EntityDataAccessor<Boolean> EATING = SynchedEntityData.defineId(Exaeretodon.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_LOVE = SynchedEntityData.defineId(Exaeretodon.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DIGGING_ROOTS = SynchedEntityData.defineId(Exaeretodon.class, EntityDataSerializers.BOOLEAN);
	private int maxHunger = 20;
	private int currentHunger = 20;
	private int lastInLove = 0;
	int hungerTick = 0;
	private int isDigging;
	private int warningSoundTicks;
	int loveTick = 0;

	public Exaeretodon(EntityType<? extends Exaeretodon> type, Level levelIn) {
		super(type, levelIn);
	}

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

	public boolean isDiggingForRoots() {
		return this.entityData.get(DIGGING_ROOTS);
	}

	private void setDiggingForRoots(boolean isDiggingForRoots) {
		this.entityData.set(DIGGING_ROOTS, isDiggingForRoots);
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.CLADOPHLEBIS.get().asItem();
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

	public boolean isEating() {
		return this.entityData.get(EATING);
	}

	private void setEating(boolean isEating) {
		this.entityData.set(EATING, isEating);
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Exaeretodon.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Exaeretodon.PanicGoal());
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, TEMPTATION_ITEMS, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new Exaeretodon.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Exaeretodon.AttackPlayerGoal());
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Player>(this, Player.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Tyrannosaurus>(this, Tyrannosaurus.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Triceratops>(this, Triceratops.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Ankylosaurus>(this, Ankylosaurus.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Dakotaraptor>(this, Dakotaraptor.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Allosaurus>(this, Allosaurus.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Ceratosaurus>(this, Ceratosaurus.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Camarasaurus>(this, Camarasaurus.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Stegosaurus>(this, Stegosaurus.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Saurosuchus>(this, Saurosuchus.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dilophosaurus>(this, Dilophosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(0, new Exaeretodon.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Exaeretodon.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Exaeretodon.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new NocturnalSleepGoal(this));
		this.goalSelector.addGoal(0, new Exaeretodon.HerbivoreEatGoal((double)1.2F, 12, 2));
		this.goalSelector.addGoal(5, new Exaeretodon.DiggingGoal(this));
	}

	public void aiStep() {
		super.aiStep();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		}
		if (!this.isNoAi()) {
			List<? extends Exaeretodon> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
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
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.MOVEMENT_SPEED, 0.23D).add(Attributes.FOLLOW_RANGE, 15).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.EXAERETODON_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.EXAERETODON_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.EXAERETODON_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.EXAERETODON_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(HAS_EGG, false);
		this.entityData.define(IS_DIGGING, false);
		this.entityData.define(ALBINO, false);
		this.entityData.define(MELANISTIC, false);
		this.entityData.define(EATING, false);
		this.entityData.define(NATURAL_LOVE, false);
		this.entityData.define(DIGGING_ROOTS, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("IsEating", this.isEating());
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
		compound.putBoolean("DiggingRoots", this.isDiggingForRoots());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setEating(compound.getBoolean("IsEating"));
		this.setHunger(compound.getInt("MaxHunger"));
		this.setInLoveNaturally(compound.getBoolean("InNaturalLove"));
		this.setDiggingForRoots(compound.getBoolean("DiggingRoots"));
	}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (level.isClientSide) {
			return InteractionResult.PASS;
		} else {
			ItemStack stack = player.getItemInHand(hand);
			Item item = stack.getItem();
			if (item == PFBlocks.MICHELILLOA.get().asItem()) {
				if (!player.isCreative()) {
					stack.shrink(1);
				}
				this.setDiggingForRoots(true);
				return InteractionResult.SUCCESS;
			}
			ItemStack itemstack = player.getItemInHand(hand);
			if (PrehistoricFaunaConfig.advancedHunger) {
				int hunger = this.getCurrentHunger();
				if (hunger < this.maxHunger) {
					if (this.isFood(itemstack) && (!this.isInLove() || !this.isInLoveNaturally())) {
						this.setInLove(player);
						itemstack.shrink(1);
					} else {
						if (itemstack.is(PFTags.PLANTS_2_HUNGER_ITEM)) {
							if (hunger + 2 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 2);
							}
							itemstack.shrink(1);
						}
						if (itemstack.is(PFTags.PLANTS_4_HUNGER_ITEM)) {
							if (hunger + 4 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 4);
							}
							itemstack.shrink(1);
						}
						if (itemstack.is(PFTags.PLANTS_6_HUNGER_ITEM)) {
							if (hunger + 6 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 6);
							}
							itemstack.shrink(1);
						}
						if (itemstack.is(PFTags.PLANTS_8_HUNGER_ITEM)) {
							if (hunger + 8 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 8);
							}
							itemstack.shrink(1);
						}
						if (itemstack.is(PFTags.PLANTS_10_HUNGER_ITEM)) {
							if (hunger + 10 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 10);
							}
							itemstack.shrink(1);
						}
						if (itemstack.is(PFTags.PLANTS_12_HUNGER_ITEM)) {
							if (hunger + 12 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 12);
							}
							itemstack.shrink(1);
						}
						if (itemstack.is(PFTags.PLANTS_15_HUNGER_ITEM)) {
							if (hunger + 15 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 15);
							}
							itemstack.shrink(1);
						}
						if (itemstack.is(PFTags.PLANTS_20_HUNGER_ITEM)) {
							if (hunger + 20 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 20);
							}
							itemstack.shrink(1);
						}
						if (itemstack.is(PFTags.PLANTS_25_HUNGER_ITEM)) {
							if (hunger + 25 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 25);
							}
							itemstack.shrink(1);
						}
						if (itemstack.is(PFTags.PLANTS_30_HUNGER_ITEM)) {
							if (hunger + 30 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(hunger + 30);
							}
							itemstack.shrink(1);
						}
					}
				}
				else player.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.fullHunger"), true);
			}
			return super.mobInteract(player, hand);
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
		}
		return flag;
	}	

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(Exaeretodon.this, Player.class, true, true);
		}

		public boolean canUse() {
			if (Exaeretodon.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Exaeretodon exaeretodon : Exaeretodon.this.level.getEntitiesOfClass(Exaeretodon.class, Exaeretodon.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (exaeretodon.isBaby()) {
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
			super(Exaeretodon.this);
		}

		public void start() {
			super.start();
			if (Exaeretodon.this.isBaby()) {
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
			super(Exaeretodon.this, 1.25D, true);
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
					Exaeretodon.this.playWarningSound();
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
			super(Exaeretodon.this, 2.0D);
		}

		public boolean canUse() {
			return !Exaeretodon.this.isBaby() && !Exaeretodon.this.isOnFire() ? false : super.canUse();
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Exaeretodon exaeretodon;

		LayEggGoal(Exaeretodon exaeretodon, double speedIn) {
			super(exaeretodon, speedIn, 16);
			this.exaeretodon = exaeretodon;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.exaeretodon.hasEgg() ? super.canUse() : false;
		}

		/**
		 * Returns whether an in-progress AIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.exaeretodon.hasEgg();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.exaeretodon.position());
			if (!this.exaeretodon.isInWater() && this.isReachedTarget()) {
				if (this.exaeretodon.isDigging < 1) {
					this.exaeretodon.setDigging(true);
				} else if (this.exaeretodon.isDigging > 200) {
					Level level = this.exaeretodon.level;
					level.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);
					level.setBlock(this.blockPos.above(), PFBlocks.EXAERETODON_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.exaeretodon.random.nextInt(4) + 1)), 3);
					this.exaeretodon.setHasEgg(false);
					this.exaeretodon.setDigging(false);
					this.exaeretodon.setInLoveTime(600);
				}

				if (this.exaeretodon.isDigging()) {
					this.exaeretodon.isDigging++;
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
		private final Exaeretodon exaeretodon;

		MateGoal(Exaeretodon exaeretodon, double speed) {
			super(exaeretodon, speed);
			this.exaeretodon = exaeretodon;
		}

		public boolean canUse() {
			return super.canUse() && !this.exaeretodon.hasEgg() && !this.exaeretodon.isInLoveNaturally();
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
			this.exaeretodon.setHasEgg(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}

	}

	static class NaturalMateGoal extends BreedGoal {
		private final Exaeretodon exaeretodon;

		NaturalMateGoal(Exaeretodon exaeretodon, double speed) {
			super(exaeretodon, speed);
			this.exaeretodon = exaeretodon;
		}

		public boolean canUse() {
			return super.canUse() && !this.exaeretodon.hasEgg() && this.exaeretodon.getCurrentHunger() >= this.exaeretodon.getThreeQuartersHunger() && this.exaeretodon.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.exaeretodon.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.exaeretodon.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.exaeretodon.random.nextFloat() - this.exaeretodon.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.exaeretodon.random.nextInt(4);
				if (eggAmount == 0) {
					this.exaeretodon.spawnAtLocation(PFBlocks.EXAERETODON_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.exaeretodon.spawnAtLocation(PFBlocks.EXAERETODON_EGG.get().asItem());
					this.exaeretodon.spawnAtLocation(PFBlocks.EXAERETODON_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.exaeretodon.spawnAtLocation(PFBlocks.EXAERETODON_EGG.get().asItem());
					this.exaeretodon.spawnAtLocation(PFBlocks.EXAERETODON_EGG.get().asItem());
					this.exaeretodon.spawnAtLocation(PFBlocks.EXAERETODON_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.exaeretodon.spawnAtLocation(PFBlocks.EXAERETODON_EGG.get().asItem());
					this.exaeretodon.spawnAtLocation(PFBlocks.EXAERETODON_EGG.get().asItem());
					this.exaeretodon.spawnAtLocation(PFBlocks.EXAERETODON_EGG.get().asItem());
					this.exaeretodon.spawnAtLocation(PFBlocks.EXAERETODON_EGG.get().asItem());
				}
			} else {
				this.exaeretodon.setHasEgg(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Exaeretodon entity = new Exaeretodon(PFEntities.EXAERETODON.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	public class HerbivoreEatGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public HerbivoreEatGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Exaeretodon.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
					Exaeretodon.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					Exaeretodon.this.level.playSound((Player)null, this.blockPos, SoundEvents.GRASS_HIT, SoundSource.NEUTRAL, 1, 1);
				}
			}
			if (Exaeretodon.this.getCurrentHunger() >= 13) {
				Exaeretodon.this.setEating(false);
			}
			super.tick();
		}

		protected void eatBerry() {
			BlockState blockstate = Exaeretodon.this.level.getBlockState(this.blockPos);

			if (blockstate.is(PFTags.PLANTS_2_HUNGER)) {
				int hunger = Exaeretodon.this.getCurrentHunger();
				if (hunger + 2 >= Exaeretodon.this.maxHunger) {
					Exaeretodon.this.setHunger(Exaeretodon.this.maxHunger);
					Exaeretodon.this.setEating(false);
				} else {
					Exaeretodon.this.setHunger(hunger + 2);
					Exaeretodon.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_4_HUNGER)) {
				int hunger = Exaeretodon.this.getCurrentHunger();
				if (hunger + 4 >= Exaeretodon.this.maxHunger) {
					Exaeretodon.this.setHunger(Exaeretodon.this.maxHunger);
					Exaeretodon.this.setEating(false);
				} else {
					Exaeretodon.this.setHunger(hunger + 4);
					Exaeretodon.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_6_HUNGER)) {
				int hunger = Exaeretodon.this.getCurrentHunger();
				if (hunger + 6 >= Exaeretodon.this.maxHunger) {
					Exaeretodon.this.setHunger(Exaeretodon.this.maxHunger);
					Exaeretodon.this.setEating(false);
				} else {
					Exaeretodon.this.setHunger(hunger + 6);
					Exaeretodon.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_8_HUNGER)) {
				int hunger = Exaeretodon.this.getCurrentHunger();
				if (hunger + 8 >= Exaeretodon.this.maxHunger) {
					Exaeretodon.this.setHunger(Exaeretodon.this.maxHunger);
					Exaeretodon.this.setEating(false);
				} else {
					Exaeretodon.this.setHunger(hunger + 8);
					Exaeretodon.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_10_HUNGER)) {
				int hunger = Exaeretodon.this.getCurrentHunger();
				if (hunger + 10 >= Exaeretodon.this.maxHunger) {
					Exaeretodon.this.setHunger(Exaeretodon.this.maxHunger);
					Exaeretodon.this.setEating(false);
				} else {
					Exaeretodon.this.setHunger(hunger + 10);
					Exaeretodon.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_12_HUNGER)) {
				int hunger = Exaeretodon.this.getCurrentHunger();
				if (hunger + 12 >= Exaeretodon.this.maxHunger) {
					Exaeretodon.this.setHunger(Exaeretodon.this.maxHunger);
					Exaeretodon.this.setEating(false);
				} else {
					Exaeretodon.this.setHunger(hunger + 12);
					Exaeretodon.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_15_HUNGER)) {
				int hunger = Exaeretodon.this.getCurrentHunger();
				if (hunger + 15 >= Exaeretodon.this.maxHunger) {
					Exaeretodon.this.setHunger(Exaeretodon.this.maxHunger);
					Exaeretodon.this.setEating(false);
				} else {
					Exaeretodon.this.setHunger(hunger + 15);
					Exaeretodon.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_20_HUNGER)) {
				int hunger = Exaeretodon.this.getCurrentHunger();
				if (hunger + 20 >= Exaeretodon.this.maxHunger) {
					Exaeretodon.this.setHunger(Exaeretodon.this.maxHunger);
					Exaeretodon.this.setEating(false);
				} else {
					Exaeretodon.this.setHunger(hunger + 20);
					Exaeretodon.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_25_HUNGER)) {
				int hunger = Exaeretodon.this.getCurrentHunger();
				if (hunger + 25 >= Exaeretodon.this.maxHunger) {
					Exaeretodon.this.setHunger(Exaeretodon.this.maxHunger);
					Exaeretodon.this.setEating(false);
				} else {
					Exaeretodon.this.setHunger(hunger + 25);
					Exaeretodon.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_30_HUNGER)) {
				int hunger = Exaeretodon.this.getCurrentHunger();
				if (hunger + 30 >= Exaeretodon.this.maxHunger) {
					Exaeretodon.this.setHunger(Exaeretodon.this.maxHunger);
					Exaeretodon.this.setEating(false);
				} else {
					Exaeretodon.this.setHunger(hunger + 30);
					Exaeretodon.this.setEating(false);
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Exaeretodon.this.isAsleep() && super.canUse() && Exaeretodon.this.getCurrentHunger() < Exaeretodon.this.getHalfHunger();
		}

		public boolean canContinueToUse() {
			if (Exaeretodon.this.getCurrentHunger() >= Exaeretodon.this.maxHunger || Exaeretodon.this.isAsleep()) {
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

	static class DiggingGoal extends Goal {
		private static final ResourceLocation DIGGING_LOOT = new ResourceLocation(PrehistoricFauna.MOD_ID, "entities/exaeretodon_digging");

		private final Exaeretodon exaeretodon;
		private int diggingTimer;
		private int digTimer2;

		public DiggingGoal(Exaeretodon entity) {
			this.exaeretodon = entity;
			setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
		}

		@Override
		public boolean canUse() {
			if (digTimer2 > 0) {
				--digTimer2;
				return false;
			}
			BlockPos blockpos = exaeretodon.blockPosition();
			BlockState state = exaeretodon.level.getBlockState(blockpos);
			if (state.is(BlockTags.DIRT) && exaeretodon.isDiggingForRoots()) {
				return true;
			} else {
				return exaeretodon.level.getBlockState(blockpos.below()).is(BlockTags.DIRT)&& exaeretodon.isDiggingForRoots();
			}
		}

		@Override
		public void start() {
			diggingTimer = 40;
			digTimer2 = 6000;
			exaeretodon.level.broadcastEntityEvent(exaeretodon, (byte) 10);
			exaeretodon.getNavigation().stop();
		}

		@Override
		public void stop() {
			diggingTimer = 0;
			exaeretodon.setDiggingForRoots(false);
		}

		@Override
		public boolean canContinueToUse() {
			return diggingTimer > 0;
		}

		@Override
		public void tick() {
			if (digTimer2 > 0) {
				--digTimer2;
			}
			if (diggingTimer > 0) {
				--diggingTimer;
			}
			if (diggingTimer == 25) {
				BlockPos blockpos = exaeretodon.blockPosition();
				BlockPos blockpos1 = blockpos.below();
				if (exaeretodon.level.getBlockState(blockpos1).is(BlockTags.DIRT)) {
					BlockState state = exaeretodon.level.getBlockState(blockpos1);
					exaeretodon.level.levelEvent(2001, blockpos1, Block.getId(state));
					MinecraftServer server = exaeretodon.level.getServer();
					if (server != null) {
						List<ItemStack> items = server.getLootTables().get(DIGGING_LOOT).getRandomItems(new LootContext.Builder((ServerLevel) exaeretodon.level).withRandom(exaeretodon.getRandom()).create(LootContextParamSets.EMPTY));
						Containers.dropContents(exaeretodon.level, blockpos, NonNullList.of(ItemStack.EMPTY, items.toArray(new ItemStack[0])));
					}
				}
			}
		}



	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.EXAERETODON_SPAWN_EGG.get());
	}

}
