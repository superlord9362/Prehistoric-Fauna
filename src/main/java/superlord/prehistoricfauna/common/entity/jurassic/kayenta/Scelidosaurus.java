package superlord.prehistoricfauna.common.entity.jurassic.kayenta;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Pinacosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Plesiohadros;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Ischigualastia;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Sillosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Scelidosaurus extends DinosaurEntity {

	private static final EntityDataAccessor<Boolean> HAS_EGG = SynchedEntityData.defineId(Scelidosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_DIGGING = SynchedEntityData.defineId(Scelidosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALBINO = SynchedEntityData.defineId(Scelidosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MELANISTIC = SynchedEntityData.defineId(Scelidosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> EATING = SynchedEntityData.defineId(Scelidosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_LOVE = SynchedEntityData.defineId(Scelidosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> BIPEDAL = SynchedEntityData.defineId(Scelidosaurus.class, EntityDataSerializers.BOOLEAN);
	private int maxHunger = 38;
	private int lastInLove = 0;
	private int currentHunger = 38;
	int hungerTick = 0;
	private int isDigging;
	int loveTick = 0;
	private int warningSoundTicks;

	@SuppressWarnings("deprecation")
	public Scelidosaurus(EntityType<? extends Scelidosaurus> type, Level worldIn) {
		super(type, worldIn);
		this.maxUpStep = 1.0F;
	}

	public boolean hasEgg() {
		return this.entityData.get(HAS_EGG);
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.4F;
		else return 0.8F;
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

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.CLATHOPTERIS.get().asItem();
	}

	public boolean isAlbino() {
		return this.entityData.get(ALBINO);
	}

	private void setAlbino(boolean isAlbino) {
		this.entityData.set(ALBINO, isAlbino);
	}

	public boolean isBipedal() {
		return this.entityData.get(BIPEDAL);
	}

	private void setBipedal(boolean isBipedal) {
		this.entityData.set(BIPEDAL, isBipedal);
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

	public boolean isEating() {
		return this.entityData.get(EATING);
	}

	private void setEating(boolean isEating) {
		this.entityData.set(EATING, isEating);
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

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(HAS_EGG, false);
		this.entityData.define(IS_DIGGING, false);
		this.entityData.define(ALBINO, false);
		this.entityData.define(MELANISTIC, false);
		this.entityData.define(EATING, false);
		this.entityData.define(NATURAL_LOVE, false);
		this.entityData.define(BIPEDAL, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("IsEating", this.isEating());
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
		compound.putBoolean("IsBipedal", this.isBipedal());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setEating(compound.getBoolean("IsEating"));
		this.setHunger(compound.getInt("MaxHunger"));
		this.setInLoveNaturally(compound.getBoolean("InNaturalLove"));
		this.setBipedal(compound.getBoolean("IsBipedal"));
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(0, new Scelidosaurus.PanicGoal());
		this.goalSelector.addGoal(1, new Scelidosaurus.MeleeAttackGoal());
		this.targetSelector.addGoal(1, new Scelidosaurus.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Scelidosaurus.AttackPlayerGoal());
		this.goalSelector.addGoal(0, new Scelidosaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Scelidosaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Dilophosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Pinacosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Plesiohadros.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Ankylosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Dakotaraptor.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Triceratops.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Tyrannosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Allosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Camarasaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Ceratosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Stegosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Herrerasaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Ischigualastia.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Saurosuchus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Sillosuchus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(0, new Scelidosaurus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(0, new Scelidosaurus.HerbivoreEatGoal((double)1.2F, 12, 2));
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.SCELIDOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.SCELIDOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.SCELIDOSAURUS_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.SCELIDOSAURUS_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
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

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, 0.22D).add(Attributes.ARMOR, 6.0D).add(Attributes.ARMOR_TOUGHNESS, 4.0D).add(Attributes.ATTACK_DAMAGE , 4).add(Attributes.FOLLOW_RANGE, 15);
	}

	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		super.handleEntityEvent(id);
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
			else p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.fullHunger"), true);
		}
		return super.mobInteract(p_230254_1_, p_230254_2_);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.22D);
		}
		if (!this.isNoAi()) {
			List<? extends Scelidosaurus> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
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

	static class LayEggGoal extends MoveToBlockGoal {
		private final Scelidosaurus scelidosaurus;

		LayEggGoal(Scelidosaurus scelidosaurus, double speedIn) {
			super(scelidosaurus, speedIn, 16);
			this.scelidosaurus = scelidosaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.scelidosaurus.hasEgg() ? super.canUse() : false;
		}

		/**
		 * Returns whether an in-progress AIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.scelidosaurus.hasEgg();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.scelidosaurus.position());
			if (!this.scelidosaurus.isInWater() && this.isReachedTarget()) {
				if (this.scelidosaurus.isDigging < 1) {
					this.scelidosaurus.setDigging(true);
				} else if (this.scelidosaurus.isDigging > 200) {
					Level world = this.scelidosaurus.level;
					world.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
					world.setBlock(this.blockPos.above(), PFBlocks.SCELIDOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.scelidosaurus.random.nextInt(4) + 1)), 3);
					this.scelidosaurus.setHasEgg(false);
					this.scelidosaurus.setDigging(false);
					this.scelidosaurus.setInLoveTime(600);
				}

				if (this.scelidosaurus.isDigging()) {
					this.scelidosaurus.isDigging++;
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
		private final Scelidosaurus scelidosaurus;

		MateGoal(Scelidosaurus scelidosaurus, double speed) {
			super(scelidosaurus, speed);
			this.scelidosaurus = scelidosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.scelidosaurus.hasEgg() && !this.scelidosaurus.isInLoveNaturally();
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
			this.scelidosaurus.setHasEgg(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Scelidosaurus scelidosaurus;

		NaturalMateGoal(Scelidosaurus scelidosaurus, double speed) {
			super(scelidosaurus, speed);
			this.scelidosaurus = scelidosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.scelidosaurus.hasEgg() && this.scelidosaurus.getCurrentHunger() >= this.scelidosaurus.getThreeQuartersHunger() && this.scelidosaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.scelidosaurus.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.scelidosaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.scelidosaurus.random.nextFloat() - this.scelidosaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.scelidosaurus.random.nextInt(4);
				if (eggAmount == 0) {
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
				}
			} else {
				this.scelidosaurus.setHasEgg(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Scelidosaurus entity = new Scelidosaurus(PFEntities.SCELIDOSAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.position())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	public class HerbivoreEatGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public HerbivoreEatGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Scelidosaurus.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
					Scelidosaurus.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					Scelidosaurus.this.level.playSound((Player)null, this.blockPos, SoundEvents.GRASS_HIT, SoundSource.NEUTRAL, 1, 1);
				}
			}
			if (Scelidosaurus.this.getCurrentHunger() >= 13) {
				Scelidosaurus.this.setEating(false);
			}
			super.tick();
		}

		protected void eatBerry() {
			BlockState blockstate = Scelidosaurus.this.level.getBlockState(this.blockPos);

			if (blockstate.is(PFTags.PLANTS_2_HUNGER)) {
				int hunger = Scelidosaurus.this.getCurrentHunger();
				if (hunger + 2 >= Scelidosaurus.this.maxHunger) {
					Scelidosaurus.this.setHunger(Scelidosaurus.this.maxHunger);
					Scelidosaurus.this.setEating(false);
				} else {
					Scelidosaurus.this.setHunger(hunger + 2);
					Scelidosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_4_HUNGER)) {
				int hunger = Scelidosaurus.this.getCurrentHunger();
				if (hunger + 4 >= Scelidosaurus.this.maxHunger) {
					Scelidosaurus.this.setHunger(Scelidosaurus.this.maxHunger);
					Scelidosaurus.this.setEating(false);
				} else {
					Scelidosaurus.this.setHunger(hunger + 4);
					Scelidosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_6_HUNGER)) {
				int hunger = Scelidosaurus.this.getCurrentHunger();
				if (hunger + 6 >= Scelidosaurus.this.maxHunger) {
					Scelidosaurus.this.setHunger(Scelidosaurus.this.maxHunger);
					Scelidosaurus.this.setEating(false);
				} else {
					Scelidosaurus.this.setHunger(hunger + 6);
					Scelidosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_8_HUNGER)) {
				int hunger = Scelidosaurus.this.getCurrentHunger();
				if (hunger + 8 >= Scelidosaurus.this.maxHunger) {
					Scelidosaurus.this.setHunger(Scelidosaurus.this.maxHunger);
					Scelidosaurus.this.setEating(false);
				} else {
					Scelidosaurus.this.setHunger(hunger + 8);
					Scelidosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_10_HUNGER)) {
				int hunger = Scelidosaurus.this.getCurrentHunger();
				if (hunger + 10 >= Scelidosaurus.this.maxHunger) {
					Scelidosaurus.this.setHunger(Scelidosaurus.this.maxHunger);
					Scelidosaurus.this.setEating(false);
				} else {
					Scelidosaurus.this.setHunger(hunger + 10);
					Scelidosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_12_HUNGER)) {
				int hunger = Scelidosaurus.this.getCurrentHunger();
				if (hunger + 12 >= Scelidosaurus.this.maxHunger) {
					Scelidosaurus.this.setHunger(Scelidosaurus.this.maxHunger);
					Scelidosaurus.this.setEating(false);
				} else {
					Scelidosaurus.this.setHunger(hunger + 12);
					Scelidosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_15_HUNGER)) {
				int hunger = Scelidosaurus.this.getCurrentHunger();
				if (hunger + 15 >= Scelidosaurus.this.maxHunger) {
					Scelidosaurus.this.setHunger(Scelidosaurus.this.maxHunger);
					Scelidosaurus.this.setEating(false);
				} else {
					Scelidosaurus.this.setHunger(hunger + 15);
					Scelidosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_20_HUNGER)) {
				int hunger = Scelidosaurus.this.getCurrentHunger();
				if (hunger + 20 >= Scelidosaurus.this.maxHunger) {
					Scelidosaurus.this.setHunger(Scelidosaurus.this.maxHunger);
					Scelidosaurus.this.setEating(false);
				} else {
					Scelidosaurus.this.setHunger(hunger + 20);
					Scelidosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_25_HUNGER)) {
				int hunger = Scelidosaurus.this.getCurrentHunger();
				if (hunger + 25 >= Scelidosaurus.this.maxHunger) {
					Scelidosaurus.this.setHunger(Scelidosaurus.this.maxHunger);
					Scelidosaurus.this.setEating(false);
				} else {
					Scelidosaurus.this.setHunger(hunger + 25);
					Scelidosaurus.this.setEating(false);
				}
			}
			if (blockstate.is(PFTags.PLANTS_30_HUNGER)) {
				int hunger = Scelidosaurus.this.getCurrentHunger();
				if (hunger + 30 >= Scelidosaurus.this.maxHunger) {
					Scelidosaurus.this.setHunger(Scelidosaurus.this.maxHunger);
					Scelidosaurus.this.setEating(false);
				} else {
					Scelidosaurus.this.setHunger(hunger + 30);
					Scelidosaurus.this.setEating(false);
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Scelidosaurus.this.isAsleep() && super.canUse() && Scelidosaurus.this.getCurrentHunger() < Scelidosaurus.this.getHalfHunger();
		}

		public boolean canContinueToUse() {
			if (Scelidosaurus.this.getCurrentHunger() >= Scelidosaurus.this.maxHunger || Scelidosaurus.this.isAsleep()) {
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

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Scelidosaurus.this, 1.25D, true);
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
					Scelidosaurus.this.playWarningSound();
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

	class HurtByTargetGoal extends net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(Scelidosaurus.this);
		}

		public void start() {
			super.start();
			if (Scelidosaurus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}
		}

		protected void alertOther(Mob mobIn, LivingEntity targetIn) {
			if (mobIn instanceof Scelidosaurus && !mobIn.isBaby()) {
				super.alertOther(mobIn, targetIn);
			}
		}
	}

	class PanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(Scelidosaurus.this, 2.0D);
		}

		public boolean canUse() {
			return !Scelidosaurus.this.isBaby() && !Scelidosaurus.this.isOnFire() ? false : super.canUse();
		}

	}

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(Scelidosaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean canUse() {
			if (Scelidosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Scelidosaurus scelidosaurus : Scelidosaurus.this.level.getEntitiesOfClass(Scelidosaurus.class, Scelidosaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (scelidosaurus.isBaby()) {
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

	@SuppressWarnings("rawtypes")
	class BipedalAvoidEntityGoal extends AvoidEntityGoal {

		@SuppressWarnings("unchecked")
		public BipedalAvoidEntityGoal(PathfinderMob entityIn, Class classToAvoidIn, float avoidDistanceIn, double farSpeedIn, double nearSpeedIn) {
			super(entityIn, classToAvoidIn, avoidDistanceIn, farSpeedIn, nearSpeedIn);
		}

		public void tick() {
			super.tick();
			Scelidosaurus.this.setBipedal(true);
		}

		public void stop() {
			Scelidosaurus.this.setBipedal(false);
			super.stop();
		}

	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.SCELIDOSAURUS_SPAWN_EGG.get());
	}

}
