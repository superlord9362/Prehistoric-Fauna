package superlord.prehistoricfauna.common.entity.cretaceous.yixian;

import java.util.EnumSet;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.BabyCarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.CrepuscularSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurOwnerHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurOwnerHurtTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurWaterAvoidingRandomStrollGoal;
import superlord.prehistoricfauna.common.entity.goal.HostileCarnivoreGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.OpportunistAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.OpportunistBabyHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.OpportunistHuntingGoal;
import superlord.prehistoricfauna.common.entity.goal.SkittishFleeGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.items.PaleopediaItem;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Sinosauropteryx extends DinosaurEntity {
	private static final EntityDataAccessor<Boolean> TAME_SIT = SynchedEntityData.defineId(Sinosauropteryx.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SITTING = SynchedEntityData.defineId(Sinosauropteryx.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> TAME_WANDER = SynchedEntityData.defineId(Sinosauropteryx.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> SIT_TICK = SynchedEntityData.defineId(Sinosauropteryx.class, EntityDataSerializers.INT);
	private int maxHunger = 10;
	private int warningSoundTicks;
	private float sitProgress = 0.0F;
	private float prevSitProgress = 0.0F;

	public boolean isTameSitting() {
		return this.entityData.get(TAME_SIT);
	}

	private void setTameSitting(boolean isTameSitting) {
		this.entityData.set(SIT_TICK, 15);
		this.entityData.set(TAME_SIT, isTameSitting);
	}
	
	public boolean isSitting() {
		return this.entityData.get(SITTING);
	}

	private void setSitting(boolean isSitting) {
		this.entityData.set(SIT_TICK, 15);
		this.entityData.set(SITTING, isSitting);
	}

	public boolean isTameWandering() {
		return this.entityData.get(TAME_WANDER);
	}

	private void setTameWandering(boolean isTameWandering) {
		this.entityData.set(TAME_WANDER, isTameWandering);
	}

	public Sinosauropteryx(EntityType<? extends Sinosauropteryx> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.setMaxUpStep(1.375F);
		super.maxHunger = maxHunger;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.EPHEDRA_BERRIES.get();
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(0, new Sinosauropteryx.SitAndLookGoal());
		this.goalSelector.addGoal(1, new Sinosauropteryx.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(3, new SkittishFleeGoal(this, Player.class, 10F, 1.5D, 1.75D));
		this.targetSelector.addGoal(2, new OpportunistAttackGoal(this, Player.class, true));
		this.goalSelector.addGoal(1, new CrepuscularSleepGoal(this));
		this.targetSelector.addGoal(0, new HostileCarnivoreGoal(this, Player.class, false));
		this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
		this.targetSelector.addGoal(0, new DinosaurOwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(0, new DinosaurOwnerHurtTargetGoal(this));
		this.targetSelector.addGoal(0, new SinosauropteryxRelaxOnOwnerGoal(this));
		this.targetSelector.addGoal(0, new SinosauropteryxSitOnBedGoal(this, 1.1D, 8));
		this.goalSelector.addGoal(0, new SinosauropteryxFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, true));
		this.goalSelector.addGoal(0, new CarnivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.targetSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.SINOSAUROPTERYX_HUNTING);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.SINOSAUROPTERYX_BABY_HUNTING);
		}));
		this.targetSelector.addGoal(0, new OpportunistHuntingGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.SINOSAUROPTERYX_HUNTING);
		}));
		this.targetSelector.addGoal(0, new OpportunistBabyHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.SINOSAUROPTERYX_BABY_HUNTING);
		}));
		this.targetSelector.addGoal(0, new HuntGoal(this, LivingEntity.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.SINOSAUROPTERYX_HUNTING);
		}));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.SINOSAUROPTERYX_AVOIDING);
		}));
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsTamedSitting", this.isTameSitting());
		compound.putBoolean("IsTamedWander", this.isTameWandering());
		compound.putBoolean("IsSitting", this.isSitting());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setTameSitting(compound.getBoolean("IsTamedSitting"));
		this.setTameWandering(compound.getBoolean("IsTamedWander"));
		this.setSitting(compound.getBoolean("IsSitting"));
	}

	@SuppressWarnings("deprecation")
	@Override
	public InteractionResult mobInteract(Player player, InteractionHand p_230254_2_) {
		ItemStack itemstack = player.getItemInHand(p_230254_2_);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem) {
			if (!itemstack.getTag().contains("Pages", EnumPaleoPages.SINOSAUROPTERYX.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.SINOSAUROPTERYX.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.sinosauropteryx_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		if (this.level().isClientSide()) {
			boolean flag = this.isOwnedBy(player) || this.isTame() || this.isFood(itemstack) && !this.isTame();
			return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.getCurrentHunger() < this.maxHunger && (itemstack.is(PFTags.MEATS_2_HUNGER) || itemstack.is(PFTags.MEATS_4_HUNGER) || itemstack.is(PFTags.MEATS_6_HUNGER) || itemstack.is(PFTags.MEATS_8_HUNGER) || itemstack.is(PFTags.MEATS_10_HUNGER) || itemstack.is(PFTags.MEATS_12_HUNGER))) {
					if (itemstack.is(PFTags.MEATS_2_HUNGER)) {
						if (this.getCurrentHunger() + 2 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(this.getCurrentHunger() + 2);
						}
						if (!player.isCreative()) {
							itemstack.shrink(1);
						}
					}
					if (itemstack.is(PFTags.MEATS_4_HUNGER)) {
						if (this.getCurrentHunger() + 4 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(this.getCurrentHunger() + 4);
						}
						if (!player.isCreative()) {
							itemstack.shrink(1);
						}
					}
					if (itemstack.is(PFTags.MEATS_6_HUNGER)) {
						if (this.getCurrentHunger() + 6 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(this.getCurrentHunger() + 6);
						}
						if (!player.isCreative()) {
							itemstack.shrink(1);
						}
					}
					if (itemstack.is(PFTags.MEATS_8_HUNGER)) {
						if (this.getCurrentHunger() + 8 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(this.getCurrentHunger() + 8);
						}
						if (!player.isCreative()) {
							itemstack.shrink(1);
						}
					}
					if (itemstack.is(PFTags.MEATS_10_HUNGER)) {
						if (this.getCurrentHunger() + 10 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(this.getCurrentHunger() + 10);
						}
						if (!player.isCreative()) {
							itemstack.shrink(1);
						}
					}
					if (itemstack.is(PFTags.MEATS_12_HUNGER)) {
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
				}
			} else {
				if (this.isFood(itemstack)) {
					if (!player.getAbilities().instabuild) {
						itemstack.shrink(1);
					}

					if (this.getRandom().nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
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
			return super.mobInteract(player, p_230254_2_);
		}
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = getRandom().nextInt(100);
		if (temperment < 80) {
			this.setSkittish(true);
		} else if (temperment >= 80 && temperment < 95) {
			this.setPassive(true);
		} else if (temperment >= 95) {
			this.setOpportunist(true);
		}
		this.setCarnivorous(true);
		this.setCrepuscular(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(TAME_SIT, false);
		this.entityData.define(TAME_WANDER, false);
		this.entityData.define(SITTING, false);
		this.entityData.define(SIT_TICK, 0);
	}

	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(2);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(4);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.SINOSAUROPTERYX_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.SINOSAUROPTERYX_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.SINOSAUROPTERYX_DEATH.get();
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.SINOSAUROPTERYX_WARN.get(), 1.0F, this.getVoicePitch());
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
	}
	
	public float getSitProgress(float partialTick) {
		return prevSitProgress + (sitProgress - prevSitProgress) * partialTick;
	}

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
		}
		return flag;
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Sinosauropteryx.this, 1.25D, true);
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
					Sinosauropteryx.this.playWarningSound();
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

	public void aiStep() {
		super.aiStep();
		if (this.isSitting() || this.isTameSitting()) {
			this.getNavigation().stop();
		}
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Sinosauropteryx entity = new Sinosauropteryx(PFEntities.SINOSAUROPTERYX.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.SINOSAUROPTERYX_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.SINOSAUROPTERYX_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.SINOSAUROPTERYX_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}

	public class SinosauropteryxFollowOwnerGoal extends FollowOwnerGoal {

		public SinosauropteryxFollowOwnerGoal(TamableAnimal tameable, double speed, float minDist, float maxDist, boolean teleportToLeaves) {
			super(tameable, speed, minDist, maxDist, teleportToLeaves);
		}

		public boolean canUse() {
			return super.canUse() && !Sinosauropteryx.this.isTameSitting() && !Sinosauropteryx.this.isTameWandering();
		}

	}

	class SitAndLookGoal extends Goal {
		private double field_220819_c;
		private double field_220820_d;
		private int field_220821_e;
		private int field_220822_f;

		public SitAndLookGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		public boolean canUse() {
			return (Sinosauropteryx.this.isTameSitting());
		}

		public boolean canContinueToUse() {
			if (Sinosauropteryx.this.isTameSitting()) {
				return true;
			} else return this.field_220822_f > 0;
		}

		public void start() {
			this.func_220817_j();
			this.field_220822_f = 2 + Sinosauropteryx.this.getRandom().nextInt(3);
			Sinosauropteryx.this.getNavigation().stop();
		}

		public void stop() {
			Sinosauropteryx.this.setTameSitting(false);
		}

		public void tick() {
			Sinosauropteryx.this.getNavigation().stop();

			--this.field_220821_e;
			if (this.field_220821_e <= 0) {
				--this.field_220822_f;
				this.func_220817_j();
			}

			Sinosauropteryx.this.getLookControl().setLookAt(Sinosauropteryx.this.getX() + this.field_220819_c, Sinosauropteryx.this.getEyeY(), Sinosauropteryx.this.getZ() + this.field_220820_d, (float)Sinosauropteryx.this.getMaxHeadYRot(), (float)Sinosauropteryx.this.getMaxHeadXRot());
		}

		private void func_220817_j() {
			double d0 = (Math.PI * 2D) * Sinosauropteryx.this.getRandom().nextDouble();
			this.field_220819_c = Math.cos(d0);
			this.field_220820_d = Math.sin(d0);
			this.field_220821_e = 80 + Sinosauropteryx.this.getRandom().nextInt(20);
		}
	}

	class SinosauropteryxSitOnBedGoal extends MoveToBlockGoal {
		private final Sinosauropteryx sinosauropteryx;

		public SinosauropteryxSitOnBedGoal(Sinosauropteryx sinosauropteryx, double p_25136_, int p_25137_) {
			super(sinosauropteryx, p_25136_, p_25137_, 6);
			this.sinosauropteryx = sinosauropteryx;
			this.verticalSearchStart = -2;
			this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
		}

		public boolean canUse() {
			return this.sinosauropteryx.isTame() && !this.sinosauropteryx.isOrderedToSit() && super.canUse();
		}

		public void start() {
			super.start();
			this.sinosauropteryx.setInSittingPose(false);
		}

		protected int nextStartTick(PathfinderMob p_25140_) {
			return 40;
		}

		public void stop() {
			super.stop();
			this.sinosauropteryx.setSitting(false);
		}

		public void tick() {
			super.tick();
			this.sinosauropteryx.setInSittingPose(false);
			if (!this.isReachedTarget()) {
				this.sinosauropteryx.setSitting(false);
			} else if (!this.sinosauropteryx.isSitting()) {
				this.sinosauropteryx.setSitting(true);
			}

		}

		protected boolean isValidTarget(LevelReader p_25142_, BlockPos p_25143_) {
			return p_25142_.isEmptyBlock(p_25143_.above()) && p_25142_.getBlockState(p_25143_).is(BlockTags.BEDS);
		}
	}
	
	static class SinosauropteryxRelaxOnOwnerGoal extends Goal {
		private static final ResourceLocation GIFT_LOOT = new ResourceLocation(PrehistoricFauna.MOD_ID, "gameplay/sinosauropteryx_gift");
		private final Sinosauropteryx sinosauropteryx;
	      @Nullable
	      private Player ownerPlayer;
	      @Nullable
	      private BlockPos goalPos;
	      private int onBedTicks;

	      public SinosauropteryxRelaxOnOwnerGoal(Sinosauropteryx sinosauropteryx) {
	         this.sinosauropteryx = sinosauropteryx;
	      }

	      public boolean canUse() {
	         if (!this.sinosauropteryx.isTame()) {
	            return false;
	         } else if (this.sinosauropteryx.isOrderedToSit()) {
	            return false;
	         } else {
	            LivingEntity livingentity = this.sinosauropteryx.getOwner();
	            if (livingentity instanceof Player) {
	               this.ownerPlayer = (Player)livingentity;
	               if (!livingentity.isSleeping()) {
	                  return false;
	               }

	               if (this.sinosauropteryx.distanceToSqr(this.ownerPlayer) > 100.0D) {
	                  return false;
	               }

	               BlockPos blockpos = this.ownerPlayer.blockPosition();
	               BlockState blockstate = this.sinosauropteryx.level().getBlockState(blockpos);
	               if (blockstate.is(BlockTags.BEDS)) {
	                  this.goalPos = blockstate.getOptionalValue(BedBlock.FACING).map((p_28209_) -> {
	                     return blockpos.relative(p_28209_.getOpposite());
	                  }).orElseGet(() -> {
	                     return new BlockPos(blockpos);
	                  });
	                  return !this.spaceIsOccupied();
	               }
	            }

	            return false;
	         }
	      }

	      @SuppressWarnings("resource")
		private boolean spaceIsOccupied() {
	         for(Sinosauropteryx sinosauropteryx : this.sinosauropteryx.level().getEntitiesOfClass(Sinosauropteryx.class, (new AABB(this.goalPos)).inflate(2.0D))) {
	            if (sinosauropteryx != this.sinosauropteryx && (sinosauropteryx.isSitting())) {
	               return true;
	            }
	         }

	         return false;
	      }

	      public boolean canContinueToUse() {
	         return this.sinosauropteryx.isTame() && !this.sinosauropteryx.isOrderedToSit() && this.ownerPlayer != null && this.ownerPlayer.isSleeping() && this.goalPos != null && !this.spaceIsOccupied();
	      }

	      public void start() {
	         if (this.goalPos != null) {
	            this.sinosauropteryx.setInSittingPose(false);
	            this.sinosauropteryx.getNavigation().moveTo((double)this.goalPos.getX(), (double)this.goalPos.getY(), (double)this.goalPos.getZ(), (double)1.1F);
	         }

	      }

	      public void stop() {
	         this.sinosauropteryx.setSitting(false);
	         float f = this.sinosauropteryx.level().getTimeOfDay(1.0F);
	         if (this.ownerPlayer.getSleepTimer() >= 100 && (double)f > 0.77D && (double)f < 0.8D && (double)this.sinosauropteryx.level().getRandom().nextFloat() < 0.7D) {
	            this.giveMorningGift();
	         }

	         this.onBedTicks = 0;
	         this.sinosauropteryx.getNavigation().stop();
	      }

	      private void giveMorningGift() {
	         RandomSource randomsource = this.sinosauropteryx.getRandom();
	         BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
	         blockpos$mutableblockpos.set(this.sinosauropteryx.isLeashed() ? this.sinosauropteryx.getLeashHolder().blockPosition() : this.sinosauropteryx.blockPosition());
	         this.sinosauropteryx.randomTeleport((double)(blockpos$mutableblockpos.getX() + randomsource.nextInt(11) - 5), (double)(blockpos$mutableblockpos.getY() + randomsource.nextInt(5) - 2), (double)(blockpos$mutableblockpos.getZ() + randomsource.nextInt(11) - 5), false);
	         blockpos$mutableblockpos.set(this.sinosauropteryx.blockPosition());
	         LootTable loottable = this.sinosauropteryx.level().getServer().getLootData().getLootTable(GIFT_LOOT);
	         LootParams lootparams = (new LootParams.Builder((ServerLevel)this.sinosauropteryx.level())).withParameter(LootContextParams.ORIGIN, this.sinosauropteryx.position()).withParameter(LootContextParams.THIS_ENTITY, this.sinosauropteryx).create(LootContextParamSets.GIFT);

	         for(ItemStack itemstack : loottable.getRandomItems(lootparams)) {
	            this.sinosauropteryx.level().addFreshEntity(new ItemEntity(this.sinosauropteryx.level(), (double)blockpos$mutableblockpos.getX() - (double)Mth.sin(this.sinosauropteryx.yBodyRot * ((float)Math.PI / 180F)), (double)blockpos$mutableblockpos.getY(), (double)blockpos$mutableblockpos.getZ() + (double)Mth.cos(this.sinosauropteryx.yBodyRot * ((float)Math.PI / 180F)), itemstack));
	         }

	      }

	      public void tick() {
	         if (this.ownerPlayer != null && this.goalPos != null) {
	            this.sinosauropteryx.setInSittingPose(false);
	            this.sinosauropteryx.getNavigation().moveTo((double)this.goalPos.getX(), (double)this.goalPos.getY(), (double)this.goalPos.getZ(), (double)1.1F);
	            if (this.sinosauropteryx.distanceToSqr(this.ownerPlayer) < 2.5D) {
	               ++this.onBedTicks;
	               if (this.onBedTicks > this.adjustedTickDelay(16)) {
	                  this.sinosauropteryx.setSitting(true);
	               } else {
	                  this.sinosauropteryx.lookAt(this.ownerPlayer, 45.0F, 45.0F);
	               }
	            } else {
	               this.sinosauropteryx.setSitting(false);
	            }
	         }

	      }
	   }

}
