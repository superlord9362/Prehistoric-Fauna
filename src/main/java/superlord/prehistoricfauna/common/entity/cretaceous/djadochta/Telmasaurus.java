package superlord.prehistoricfauna.common.entity.cretaceous.djadochta;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
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
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TurtleEggBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Thescelosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Dryosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Coelophysis;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Exaeretodon;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Sillosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Telmasaurus extends DinosaurEntity {

	@SuppressWarnings("deprecation")
	public Telmasaurus(EntityType<? extends TamableAnimal> type, Level worldIn) {
		super(type, worldIn);
		this.maxUpStep = 1.0F;
	}

	private static final EntityDataAccessor<Boolean> HAS_EGG = SynchedEntityData.defineId(Telmasaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_DIGGING = SynchedEntityData.defineId(Telmasaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALBINO = SynchedEntityData.defineId(Telmasaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> MELANISTIC = SynchedEntityData.defineId(Telmasaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> NATURAL_LOVE = SynchedEntityData.defineId(Telmasaurus.class, EntityDataSerializers.BOOLEAN);
	private int currentHunger = 15;
	private int maxHunger = 15;
	private int lastInLove = 0;
	int hungerTick = 0;
	int timer = 0;
	private int isDigging;
	int loveTick = 0;

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

	public boolean isFood(ItemStack stack) {
		return (stack.getItem() == PFBlocks.AEPYORNITHOMIMUS_EGG.get().asItem() || stack.getItem() == PFBlocks.CITIPATI_EGG.get().asItem() || stack.getItem() == PFBlocks.PINACOSAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.PLESIOHADROS_EGG.get().asItem() || stack.getItem() == PFBlocks.PROTOCERATOPS_EGG.get().asItem() || stack.getItem() == PFBlocks.VELOCIRAPTOR_EGG.get().asItem() || stack.getItem() == PFBlocks.ANKYLOSAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.BASILEMYS_EGG.get().asItem() || stack.getItem() == PFBlocks.DAKOTARAPTOR_EGG.get().asItem() || stack.getItem() == PFBlocks.THESCELOSAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.TRICERATOPS_EGG.get().asItem() || stack.getItem() == PFBlocks.TYRANNOSAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.CALSOYASUCHUS_EGG.get().asItem() || stack.getItem() == PFBlocks.DILOPHOSAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.KAYENTATHERIUM_EGG.get().asItem() || stack.getItem() == PFBlocks.MEGAPNOSAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.SARAHSAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.SCELIDOSAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.SCUTELLOSAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.ALLOSAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.CAMARASAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.CERATOSAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.DRYOSAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.EILENODON_EGG.get().asItem() || stack.getItem() == PFBlocks.HESPERORNITHOIDES_EGG.get().asItem() || stack.getItem() == PFBlocks.STEGOSAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.DESMATOSUCHUS_EGG.get().asItem() || stack.getItem() == PFBlocks.PLACERIAS_EGG.get().asItem() || stack.getItem() == PFBlocks.POSTOSUCHUS_EGG.get().asItem() || stack.getItem() == PFBlocks.TRILOPHOSAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.CHROMOGISAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.EXAERETODON_EGG.get().asItem() || stack.getItem() == PFBlocks.HERRERASAURUS_EGG.get().asItem() || stack.getItem() == PFBlocks.HYPERODAPEDON_EGG.get().asItem() || stack.getItem() == PFBlocks.ISCHIGUALASTIA_EGG.get().asItem() || stack.getItem() == PFBlocks.SAUROSUCHUS_EGG.get().asItem() || stack.getItem() == PFBlocks.SILLOSUCHUS_EGG.get().asItem());
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

	private void spawnItem(ItemStack stack) {
		ItemEntity itemEntity = new ItemEntity(this.level, this.getX(), this.getY(), this.getZ(), stack);
		this.level.addFreshEntity(itemEntity);
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.25F;
		else return 0.5F;
	}

	public void aiStep() {
		super.aiStep();
		ItemStack stack = this.getMainHandItem();
		ItemStack newStack = new ItemStack(Items.AIR);
		if (stack.getItem() != Items.AIR) {
			timer++;
			if (timer == 600) {
				if (PrehistoricFaunaConfig.advancedHunger) {
					if (stack.is(PFTags.EGGS_5_HUNGER)) {
						if (this.getCurrentHunger() + 5 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(currentHunger + 5);
						}
					}
					if (stack.is(PFTags.EGGS_10_HUNGER)) {
						if (this.getCurrentHunger() + 10 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(currentHunger + 10);
						}
					}
					if (stack.is(PFTags.EGGS_15_HUNGER)) {
						if (this.getCurrentHunger() + 15 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(currentHunger + 15);
						}
					}
				}
				this.setItemInHand(InteractionHand.MAIN_HAND, newStack);
			}
			if (this.getLastHurtByMob() != null && timer < 600) {
				this.spawnItem(stack);
				this.setItemInHand(InteractionHand.MAIN_HAND, newStack);
			}
		}
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double)0.25F);
		}
		if (!this.isNoAi()) {
			List<? extends Telmasaurus> list = this.level.getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(20.0D, 20.0D, 20.0D));
			if (PrehistoricFaunaConfig.advancedHunger) {
				hungerTick++;
				if (hungerTick == 900 && !this.isBaby() || hungerTick == 450 && this.isBaby()) {
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
	
	public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {
		ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
		if (PrehistoricFaunaConfig.advancedHunger) {
			int hunger = this.getCurrentHunger();
			if (hunger < this.maxHunger) {
				if (this.isFood(itemstack) && (!this.isInLove() || !this.isInLoveNaturally())) {
					this.setInLove(p_230254_1_);
					itemstack.shrink(1);
				} else {
					if (itemstack.is(PFTags.EGGS_5_HUNGER)) {
						if (this.getCurrentHunger() + 5 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(currentHunger + 5);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.EGGS_10_HUNGER)) {
						if (this.getCurrentHunger() + 10 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(currentHunger + 10);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.EGGS_15_HUNGER)) {
						if (this.getCurrentHunger() + 15 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(currentHunger + 15);
						}
						itemstack.shrink(1);
					}
				}
			}
			else p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.fullHunger"), true);
		}
		return super.mobInteract(p_230254_1_, p_230254_2_);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Telmasaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Telmasaurus.PanicGoal());
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new Telmasaurus.HurtByTargetGoal());
		this.goalSelector.addGoal(0, new Telmasaurus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new Telmasaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new Telmasaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new Telmasaurus.EatEggGoal((double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new Telmasaurus.HungerEatEggGoal((double)1.2F, 12, 2));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Camarasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Allosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Player.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Citipati.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Tyrannosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Velociraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Aepyornithomimus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Protoceratops.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Triceratops.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Thescelosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Ankylosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Dakotaraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Stegosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Dryosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Exaeretodon.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Herrerasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Sillosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal(this, Saurosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Dilophosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Coelophysis.class, 10F, 1.7D, 1.5D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, (double)0.25F).add(Attributes.ATTACK_DAMAGE, 1.0D).add(Attributes.FOLLOW_RANGE, 20.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.TELMASAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.TELMASAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.TELMASAURUS_DEATH;
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
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setHunger(compound.getInt("MaxHunger"));
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
			((LivingEntity)entityIn).addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0, false, false));
		}

		return flag;
	}

	class HurtByTargetGoal extends net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(Telmasaurus.this);
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			super.start();
			if (Telmasaurus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}

		}

		protected void alertOther(Mob mobIn, LivingEntity targetIn) {
			if (mobIn instanceof Telmasaurus && !mobIn.isBaby()) {
				super.alertOther(mobIn, targetIn);
			}

		}
	}

	class EatEggGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public EatEggGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Telmasaurus.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
			Block eggs = blockstate.getBlock();
			return (blockstate.is(Blocks.TURTLE_EGG) && blockstate.getValue(TurtleEggBlock.EGGS) >= 1) || (eggs instanceof DinosaurEggBlock && blockstate.getValue(DinosaurEggBlock.EGGS) >= 1 && blockstate.getBlock() != PFBlocks.TELMASAURUS_EGG.get());
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			ItemStack stack = Telmasaurus.this.getMainHandItem();
			if (this.isReachedTarget() && stack.getItem() == Items.AIR) {
				if (this.field_220731_g >= 40) {
					this.eatBerry();
				} else {
					++this.field_220731_g;
				}
			}
			super.tick();
		}

		protected void eatBerry() {
			if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(Telmasaurus.this.level, Telmasaurus.this)) {
				BlockState blockstate = Telmasaurus.this.level.getBlockState(this.blockPos);
				level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 0.0D, 0.0D, 0.0D);
				if (blockstate.is(Blocks.TURTLE_EGG)) {
					int i = blockstate.getValue(TurtleEggBlock.EGGS);
					blockstate.setValue(TurtleEggBlock.EGGS, Integer.valueOf(1));
					ItemStack itemstack = Telmasaurus.this.getItemBySlot(EquipmentSlot.MAINHAND);
					if (itemstack.isEmpty()) {
						Telmasaurus.this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.TURTLE_EGG));
					}
					if (i > 1) {
						Telmasaurus.this.level.setBlockAndUpdate(this.blockPos, blockstate.setValue(TurtleEggBlock.EGGS, i - 1));
						level.playSound((Player)null, this.blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 1, 1);
					} else {
						Telmasaurus.this.level.setBlockAndUpdate(this.blockPos, Blocks.AIR.defaultBlockState());
						level.playSound((Player)null, this.blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 1, 1);
					}
				}
				Block eggs = blockstate.getBlock();
				if (eggs instanceof DinosaurEggBlock) {
					int i = blockstate.getValue(DinosaurEggBlock.EGGS);
					blockstate.setValue(DinosaurEggBlock.EGGS, Integer.valueOf(1));
					ItemStack itemstack = Telmasaurus.this.getItemBySlot(EquipmentSlot.MAINHAND);
					if (itemstack.isEmpty()) {
						Telmasaurus.this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(eggs.asItem()));
					}
					if (i > 1) {
						Telmasaurus.this.level.setBlockAndUpdate(this.blockPos, blockstate.setValue(DinosaurEggBlock.EGGS, i - 1));
						level.playSound((Player)null, this.blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 1, 1);
					} else {
						Telmasaurus.this.level.setBlockAndUpdate(this.blockPos, Blocks.AIR.defaultBlockState());
						level.playSound((Player)null, this.blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 1, 1);
					}
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			ItemStack stack = Telmasaurus.this.getMainHandItem();
			return !Telmasaurus.this.isSleeping() && super.canUse() && stack.getItem() == Items.AIR && !PrehistoricFaunaConfig.advancedHunger;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			this.field_220731_g = 0;
			super.start();
		}


		public boolean canContinueToUse() {
			ItemStack stack = new ItemStack(Items.AIR);
			return Telmasaurus.this.getMainHandItem() == stack;
		}

	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Telmasaurus.this, 1.25D, true);
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
			super(Telmasaurus.this, 2.0D);
		}

		public boolean canUse() {
			return !Telmasaurus.this.isBaby() && !Telmasaurus.this.isOnFire() ? false : super.canUse();
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Telmasaurus telmasaurus;

		LayEggGoal(Telmasaurus telmasaurus, double speedIn) {
			super(telmasaurus, speedIn, 16);
			this.telmasaurus = telmasaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.telmasaurus.hasEgg() ? super.canUse() : false;
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.telmasaurus.hasEgg();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.telmasaurus.blockPosition());
			if (this.isReachedTarget()) {
				if (this.telmasaurus.isDigging < 1) {
					this.telmasaurus.setDigging(true);
				} else if (this.telmasaurus.isDigging > 200) {
					Level world = this.telmasaurus.level;
					world.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
					world.setBlock(this.blockPos.above(), PFBlocks.TELMASAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.telmasaurus.random.nextInt(4) + 1)), 3);
					this.telmasaurus.setHasEgg(false);
					this.telmasaurus.setDigging(false);
					this.telmasaurus.setInLoveTime(600);
				}

				if (this.telmasaurus.isDigging()) {
					this.telmasaurus.isDigging++;
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
		private final Telmasaurus telmasaurus;

		MateGoal(Telmasaurus telmasaurus, double speedIn) {
			super(telmasaurus, speedIn);
			this.telmasaurus = telmasaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return super.canUse() && !this.telmasaurus.hasEgg() && !this.telmasaurus.isInLoveNaturally();
		}

		/**
		 * Spawns a baby animal of the same type.
		 */
		protected void breed() {
			ServerPlayer serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.partner.getLoveCause() != null) {
				serverplayerentity = this.partner.getLoveCause();
			}

			if (serverplayerentity != null) {
				serverplayerentity.awardStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.partner, (AgeableMob)null);
			}

			this.telmasaurus.setHasEgg(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}

		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Telmasaurus telmasaurus;

		NaturalMateGoal(Telmasaurus telmasaurus, double speed) {
			super(telmasaurus, speed);
			this.telmasaurus = telmasaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.telmasaurus.hasEgg() && this.telmasaurus.getCurrentHunger() >= this.telmasaurus.getThreeQuartersHunger() && this.telmasaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.telmasaurus.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.telmasaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.telmasaurus.random.nextFloat() - this.telmasaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.telmasaurus.random.nextInt(4);
				if (eggAmount == 0) {
					this.telmasaurus.spawnAtLocation(PFBlocks.TELMASAURUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.telmasaurus.spawnAtLocation(PFBlocks.TELMASAURUS_EGG.get().asItem());
					this.telmasaurus.spawnAtLocation(PFBlocks.TELMASAURUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.telmasaurus.spawnAtLocation(PFBlocks.TELMASAURUS_EGG.get().asItem());
					this.telmasaurus.spawnAtLocation(PFBlocks.TELMASAURUS_EGG.get().asItem());
					this.telmasaurus.spawnAtLocation(PFBlocks.TELMASAURUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.telmasaurus.spawnAtLocation(PFBlocks.TELMASAURUS_EGG.get().asItem());
					this.telmasaurus.spawnAtLocation(PFBlocks.TELMASAURUS_EGG.get().asItem());
					this.telmasaurus.spawnAtLocation(PFBlocks.TELMASAURUS_EGG.get().asItem());
					this.telmasaurus.spawnAtLocation(PFBlocks.TELMASAURUS_EGG.get().asItem());
				}
			} else {
				this.telmasaurus.setHasEgg(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Telmasaurus entity = new Telmasaurus(PFEntities.TELMASAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	class HungerEatEggGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public HungerEatEggGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Telmasaurus.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
			Block eggs = blockstate.getBlock();
			return (blockstate.is(Blocks.TURTLE_EGG) && blockstate.getValue(TurtleEggBlock.EGGS) >= 1) || (eggs instanceof DinosaurEggBlock && blockstate.getValue(DinosaurEggBlock.EGGS) >= 1 && blockstate.getBlock() != PFBlocks.TELMASAURUS_EGG.get());
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			ItemStack stack = Telmasaurus.this.getMainHandItem();
			if (this.isReachedTarget() && stack.getItem() == Items.AIR) {
				if (this.field_220731_g >= 40) {
					this.eatBerry();
				} else {
					++this.field_220731_g;
				}
			}
			super.tick();
		}

		protected void eatBerry() {
			if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(Telmasaurus.this.level, Telmasaurus.this)) {
				BlockState blockstate = Telmasaurus.this.level.getBlockState(this.blockPos);
				level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 0.0D, 0.0D, 0.0D);
				if (blockstate.is(Blocks.TURTLE_EGG)) {
					int i = blockstate.getValue(TurtleEggBlock.EGGS);
					blockstate.setValue(TurtleEggBlock.EGGS, Integer.valueOf(1));
					ItemStack itemstack = Telmasaurus.this.getItemBySlot(EquipmentSlot.MAINHAND);
					if (itemstack.isEmpty()) {
						Telmasaurus.this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.TURTLE_EGG));
					}
					if (i > 1) {
						Telmasaurus.this.level.setBlockAndUpdate(this.blockPos, blockstate.setValue(TurtleEggBlock.EGGS, i - 1));
						level.playSound((Player)null, this.blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 1, 1);
					} else {
						Telmasaurus.this.level.setBlockAndUpdate(this.blockPos, Blocks.AIR.defaultBlockState());
						level.playSound((Player)null, this.blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 1, 1);
					}
				}
				Block eggs = blockstate.getBlock();
				if (eggs instanceof DinosaurEggBlock) {
					int i = blockstate.getValue(DinosaurEggBlock.EGGS);
					blockstate.setValue(DinosaurEggBlock.EGGS, Integer.valueOf(1));
					ItemStack itemstack = Telmasaurus.this.getItemBySlot(EquipmentSlot.MAINHAND);
					if (itemstack.isEmpty()) {
						Telmasaurus.this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(eggs.asItem()));
					}
					if (i > 1) {
						Telmasaurus.this.level.setBlockAndUpdate(this.blockPos, blockstate.setValue(DinosaurEggBlock.EGGS, i - 1));
						level.playSound((Player)null, this.blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 1, 1);
					} else {
						Telmasaurus.this.level.setBlockAndUpdate(this.blockPos, Blocks.AIR.defaultBlockState());
						level.playSound((Player)null, this.blockPos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.NEUTRAL, 1, 1);
					}
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			ItemStack stack = Telmasaurus.this.getMainHandItem();
			return !Telmasaurus.this.isSleeping() && super.canUse() && stack.getItem() == Items.AIR && PrehistoricFaunaConfig.advancedHunger && Telmasaurus.this.getCurrentHunger() <= Telmasaurus.this.getHalfHunger();
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			this.field_220731_g = 0;
			super.start();
		}

		public boolean canContinueToUse() {
			ItemStack stack = new ItemStack(Items.AIR);
			return Telmasaurus.this.getMainHandItem() == stack || Telmasaurus.this.getCurrentHunger() <= Telmasaurus.this.maxHunger;
		}
	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.TELMASAURUS_SPAWN_EGG.get());
	}


}
