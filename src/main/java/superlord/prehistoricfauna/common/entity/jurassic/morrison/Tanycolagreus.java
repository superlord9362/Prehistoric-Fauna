package superlord.prehistoricfauna.common.entity.jurassic.morrison;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.primitives.Ints;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.BabyCarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.CrepuscularSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurOwnerHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurOwnerHurtTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurWaterAvoidingRandomStrollGoal;
import superlord.prehistoricfauna.common.entity.goal.HostileCarnivoreGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.items.PaleopediaItem;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Tanycolagreus extends DinosaurEntity {
	private int maxHunger = 38;
	private int warningSoundTicks;
	private static final EntityDataAccessor<Boolean> TAME_SIT = SynchedEntityData.defineId(Tanycolagreus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> TAME_WANDER = SynchedEntityData.defineId(Tanycolagreus.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> SIT_TICK = SynchedEntityData.defineId(Tanycolagreus.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> ARMORED = SynchedEntityData.defineId(Tanycolagreus.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> ARMOR_DAMAGE = SynchedEntityData.defineId(Tanycolagreus.class, EntityDataSerializers.INT);
	private float sitProgress = 0.0F;
	private float prevSitProgress = 0.0F;
	
	public Tanycolagreus(EntityType<? extends Tanycolagreus> type, Level levelIn) {
		super(type, levelIn);
		this.setMaxUpStep(1.375F);
		super.maxHunger = maxHunger;
	}
	
	public boolean isTameSitting() {
		return this.entityData.get(TAME_SIT);
	}

	private void setTameSitting(boolean isTameSitting) {
		this.entityData.set(TAME_SIT, isTameSitting);
		this.entityData.set(SIT_TICK, 15);
	}

	public boolean isTameWandering() {
		return this.entityData.get(TAME_WANDER);
	}

	private void setTameWandering(boolean isTameWandering) {
		this.entityData.set(TAME_WANDER, isTameWandering);
	}

	public boolean isArmored() {
		return this.entityData.get(ARMORED);
	}

	private void setArmored(boolean isArmored) {
		this.entityData.set(ARMORED, isArmored);
	}

	public int getArmorDamage() {
		return this.entityData.get(ARMOR_DAMAGE);
	}

	private void setArmorDamage(int armorDamage) {
		this.entityData.set(ARMOR_DAMAGE, armorDamage);
	}
	
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(TAME_SIT, false);
		this.entityData.define(TAME_WANDER, false);
		this.entityData.define(SIT_TICK, 0);
		this.entityData.define(ARMORED, false);
		this.entityData.define(ARMOR_DAMAGE, 64);
	}
	
	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_SMALL_ORNITHISCHIAN_MEAT.get();
	}
	
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.targetSelector.addGoal(4, new HuntGoal(this, LivingEntity.class, 10, false, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.TANYCOLAGREUS_HUNTING);
		}));
		this.goalSelector.addGoal(1, new Tanycolagreus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new TanycolagreusWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.targetSelector.addGoal(0, new HostileCarnivoreGoal(this, Player.class, false));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.TANYCOLAGREUS_AVOIDING);
		}));
		this.goalSelector.addGoal(1, new CrepuscularSleepGoal(this));
		this.goalSelector.addGoal(0, new CarnivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.TANYCOLAGREUS_HUNTING);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.TANYCOLAGREUS_BABY_HUNTING);
		}));
		this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
		this.targetSelector.addGoal(0, new DinosaurOwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(0, new DinosaurOwnerHurtTargetGoal(this));
		this.goalSelector.addGoal(0, new TanycolagreusFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, true));
	}
	
	@SuppressWarnings("deprecation")
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem) {
			CompoundTag tag = itemstack.getTag();
            final List<Integer> already = new ArrayList<>(Ints.asList(tag.getIntArray("Pages")));
            if (!already.contains(EnumPaleoPages.TANYCOLAGREUS.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.TANYCOLAGREUS.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.tanycolagreus_added"), true);
				return InteractionResult.SUCCESS;
			} else {
				player.displayClientMessage(Component.translatable("paleopedia.tanycolagreus_already_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		if (this.level().isClientSide()) {
			boolean flag = this.isOwnedBy(player) || this.isTame() || this.isFood(itemstack) && !this.isTame();
			return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.getOwner() == player) {
					if (this.isFood(itemstack)) {
						if (this.getHealth() < this.getMaxHealth()) {
							if (!player.getAbilities().instabuild) {
								itemstack.shrink(1);
							}
							this.heal((float)item.getFoodProperties().getNutrition());
							return InteractionResult.SUCCESS;
						} else {
							if (this.canFallInLove()) {
								this.setInLove(player);
								if (!player.isCreative()) {
									itemstack.shrink(1);
								}
							}
						}
					} else if (!this.isArmored() && item == PFItems.SMALL_DINOSAUR_ARMOR.get()) {
						this.setArmored(true);
						this.setArmorDamage(itemstack.getMaxDamage() - itemstack.getDamageValue());
						if (!player.isCreative()) {
							itemstack.shrink(1);
						}
					} else if (this.isArmored() && item == Items.SHEARS) {
						this.setArmored(false);
						ItemStack armorStack = new ItemStack(PFItems.SMALL_DINOSAUR_ARMOR.get());
						armorStack.setDamageValue(armorStack.getMaxDamage() - this.getArmorDamage());
						this.spawnAtLocation(armorStack);
						if (!player.isCreative()) {
							itemstack.hurtAndBreak(1, player, (p_41007_) -> {
								p_41007_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
							});
						}
					} else {
						if (this.isTameSitting()) {
							this.setTameSitting(false);
							this.setTameWandering(true);
							player.displayClientMessage(Component.translatable("entity.prehistoricfauna.velociraptor.wandering"), true);
						} else if(this.isTameWandering()) {
							this.setTameWandering(false);
							player.displayClientMessage(Component.translatable("entity.prehistoricfauna.velociraptor.following"), true);
						} else {
							this.setTameSitting(true);
							player.displayClientMessage(Component.translatable("entity.prehistoricfauna.velociraptor.sitting"), true);
						}
					}
				} else if ((itemstack.is(PFTags.MEATS_2_HUNGER) || itemstack.is(PFTags.MEATS_4_HUNGER) || itemstack.is(PFTags.MEATS_6_HUNGER) || itemstack.is(PFTags.MEATS_8_HUNGER) || itemstack.is(PFTags.MEATS_10_HUNGER) || itemstack.is(PFTags.MEATS_12_HUNGER))) {
					if (this.getCurrentHunger() < this.maxHunger) {
						if (itemstack.is(PFTags.MEATS_2_HUNGER)) {
							if (this.getCurrentHunger() + 2 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(this.getCurrentHunger() + 2);
							}
							if (!player.isCreative()) {
								itemstack.shrink(1);
							}
						} else if (itemstack.is(PFTags.MEATS_4_HUNGER)) {
							if (this.getCurrentHunger() + 4 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(this.getCurrentHunger() + 4);
							}
							if (!player.isCreative()) {
								itemstack.shrink(1);
							}
						} else if (itemstack.is(PFTags.MEATS_6_HUNGER)) {
							if (this.getCurrentHunger() + 6 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(this.getCurrentHunger() + 6);
							}
							if (!player.isCreative()) {
								itemstack.shrink(1);
							}
						} else if (itemstack.is(PFTags.MEATS_8_HUNGER)) {
							if (this.getCurrentHunger() + 8 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(this.getCurrentHunger() + 8);
							}
							if (!player.isCreative()) {
								itemstack.shrink(1);
							}
						} else if (itemstack.is(PFTags.MEATS_10_HUNGER)) {
							if (this.getCurrentHunger() + 10 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(this.getCurrentHunger() + 10);
							}
							if (!player.isCreative()) {
								itemstack.shrink(1);
							}
						} else if (itemstack.is(PFTags.MEATS_12_HUNGER)) {
							if (this.getCurrentHunger() + 12 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(this.getCurrentHunger() + 12);
							}
							if (!player.isCreative()) {
								itemstack.shrink(1);
							}
						}
					} else {
						player.displayClientMessage(Component.translatable("entity.prehistoricfauna.fullHunger"), true);
					} 
				}
			} else {
				if (this.isFood(itemstack)) {
					if (!player.getAbilities().instabuild) {
						itemstack.shrink(1);
					}

					if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
						this.tame(player);
						this.navigation.stop();
						this.setTarget((LivingEntity)null);
						this.setTameSitting(true);
						this.level().broadcastEntityEvent(this, (byte)7);
					} else {
						this.level().broadcastEntityEvent(this, (byte)6);
					}

					return InteractionResult.SUCCESS;
				}
			}
		}
		return super.mobInteract(player, hand);
	}

	public void aiStep() {
		super.aiStep();
		if (this.isSleeping() || this.isAsleep() || this.isTameSitting()) {
			this.jumping = false;
			this.xxa = 0.0F;
			this.zza = 0.0F;
		}
		boolean flag = this.isInWater();
		if (flag || this.isSleeping()) {
			this.setTameSitting(false);
		}
	}
	
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) {
			this.setProtective(true);
		} else {
			this.setTerritorial(true);
		}
		this.setCarnivorous(true);
		this.setCrepuscular(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(7);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(15);
		}
	}
	
	protected void dropEquipment() {
		super.dropEquipment();
		if (this.isArmored()) {
			if (!this.level().isClientSide()) {
				ItemStack armorStack = new ItemStack(PFItems.SMALL_DINOSAUR_ARMOR.get());
				armorStack.setDamageValue(armorStack.getMaxDamage() - this.getArmorDamage());
				this.spawnAtLocation(armorStack);
			}
		}
	}
	
	@Override	
	public boolean hurt(DamageSource dmg, float i) {
		if (this.isArmored()) {
			if (dmg.is(DamageTypes.DROWN) || dmg.is(DamageTypes.FREEZE) || dmg.is(DamageTypes.IN_WALL) || dmg.is(DamageTypes.MAGIC) || dmg.is(DamageTypes.INDIRECT_MAGIC) || dmg.is(DamageTypes.THORNS) || dmg.is(DamageTypes.WITHER) || dmg.is(DamageTypes.FELL_OUT_OF_WORLD) || dmg.is(DamageTypes.CRAMMING)) {
				return super.hurt(dmg, i);
			} else {
				if (this.getArmorDamage() - i <= 0) {
					this.setArmored(false); 
				}
				else this.setArmorDamage(this.getArmorDamage() - (int) i);
				return super.hurt(dmg, 0);
			}
		}
		return super.hurt(dmg, i);
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.25D);
	}
	
	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.TANYCOLAGREUS_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.TANYCOLAGREUS_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.TANYCOLAGREUS_DEATH.get();
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.TANYCOLAGREUS_WARN.get(), 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
		prevSitProgress = sitProgress;
		if (this.entityData.get(SIT_TICK) > 0) {
			this.entityData.set(SIT_TICK, this.entityData.get(SIT_TICK) - 1);
			if (sitProgress < 1.0F) {
				sitProgress = Math.min(sitProgress + 0.1F, 1.0F);
			}
		} else {
			if (sitProgress > 0F) {
				sitProgress = Math.max(sitProgress - 0.2F, 0.0F);
			}
		}
		if (this.isTameSitting()  || this.isAsleep()) {
			this.getNavigation().stop();
		}
	}

	public float getSitProgress(float partialTick) {
		return prevSitProgress + (sitProgress - prevSitProgress) * partialTick;
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsTamedSitting", this.isTameSitting());
		compound.putBoolean("IsTamedWander", this.isTameWandering());
		compound.putBoolean("IsArmored", this.isArmored());
		compound.putInt("ArmorDamage", this.getArmorDamage());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setTameSitting(compound.getBoolean("IsTamedSitting"));
		this.setTameWandering(compound.getBoolean("IsTamedWander"));
		this.setArmored(compound.getBoolean("IsArmored"));
		this.setArmorDamage(compound.getInt("ArmorDamage"));
	}

	public boolean doHurtTarget(Entity entity) {
		boolean flag = super.doHurtTarget(entity);
		if (flag) {
			this.doEnchantDamageEffects(this, entity);
		}
		return flag;
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Tanycolagreus.this, 1.25D, true);
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
					Tanycolagreus.this.playWarningSound();
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

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Tanycolagreus entity = new Tanycolagreus(PFEntities.TANYCOLAGREUS.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.TANYCOLAGREUS_SPAWN_EGG.get());
	}
	
	public Item getEggItem() {
		return PFItems.TANYCOLAGREUS_EGG.get();
	}
    
	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.TANYCOLAGREUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}

	public class TanycolagreusFollowOwnerGoal extends FollowOwnerGoal {

		public TanycolagreusFollowOwnerGoal(TamableAnimal tameable, double speed, float minDist, float maxDist, boolean teleportToLeaves) {
			super(tameable, speed, minDist, maxDist, teleportToLeaves);
		}

		public boolean canUse() {
			return super.canUse() && !Tanycolagreus.this.isTameSitting() && !Tanycolagreus.this.isTameWandering();
		}

	}
	
	public class TanycolagreusWaterAvoidingRandomStrollGoal extends DinosaurWaterAvoidingRandomStrollGoal {
		Tanycolagreus dinosaur;

		public TanycolagreusWaterAvoidingRandomStrollGoal(Tanycolagreus p_25987_, double p_25988_) {
			super(p_25987_, p_25988_);
			this.dinosaur = p_25987_;
		}
		
		public boolean canUse() {
			return super.canUse() && !(dinosaur.isTameSitting());
		}
		
		public boolean canContinueToUse() {
			return super.canContinueToUse() && !(dinosaur.isTameSitting());
		}
		
		public void tick() {
			super.tick();
			if (dinosaur.isTameSitting()) stop();
		}
	}
	
}
