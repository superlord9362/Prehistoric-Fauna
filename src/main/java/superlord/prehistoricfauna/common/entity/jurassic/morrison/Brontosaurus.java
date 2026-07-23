package superlord.prehistoricfauna.common.entity.jurassic.morrison;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.primitives.Ints;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.AgedHerdDinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.AgedFollowHerdLeaderGoal;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurWaterAvoidingRandomStrollGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.items.PaleopediaItem;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFDamageSources;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Brontosaurus extends AgedHerdDinosaurEntity {
	private static final EntityDataAccessor<Boolean> IS_SUBADULT = SynchedEntityData.defineId(Brontosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> IS_JUVENILE = SynchedEntityData.defineId(Brontosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final Map<LivingEntity, BlockPos> previousPositions = new HashMap<>();
	private int maxHunger = 500;
	private int warningSoundTicks;
	
	public Brontosaurus(EntityType<? extends Brontosaurus> type, Level level) {
		super(type, level);
		this.setMaxUpStep(1.375F);
		super.maxHunger = maxHunger;
	}
	
	@Override
	public double moveToRange() {
		return 20;
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby() && !this.isJuvenile()) {
			return 2.75F;
		} else if (this.isJuvenile()) {
			return 5.5F;
		} else return 6.8125F;
	}
	
	public boolean isJuvenile() {
		return this.entityData.get(IS_JUVENILE);
	}
	
	public void setJuvenile(boolean isJuvenile) {
		this.entityData.set(IS_JUVENILE, isJuvenile);
	}
	
	public boolean isSubadult() {
		return this.entityData.get(IS_SUBADULT);
	}
	
	public void setSubadult(boolean isSubadult) {
		this.entityData.set(IS_SUBADULT, isSubadult);
	}
	
	@Override
	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.HERMANOPHYTON_CROWN.get();
	}
	
	@Override
	public void playAmbientSound() {
		SoundEvent soundEvent = this.getAmbientSound();
		if (soundEvent != null) {
			if (!this.isAsleep() || !this.isBaby()) this.playSound(soundEvent, this.getSoundVolume() * 8, this.getVoicePitch());
			else this.playSound(soundEvent, this.getSoundVolume(), this.getVoicePitch());
		}
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Brontosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.goalSelector.addGoal(5, new DinosaurWaterAvoidingRandomStrollGoal(this, 1));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1));
		this.goalSelector.addGoal(1, new AgedFollowHerdLeaderGoal(this));
		this.goalSelector.addGoal(1, new AgedFollowHerdLeaderGoal(this));
		this.goalSelector.addGoal(0, new Brontosaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Brontosaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.BRONTOSAURUS_AVOIDING);
		}));
	}
	
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem) {
			CompoundTag tag = itemstack.getTag();
            final List<Integer> already = new ArrayList<>(Ints.asList(tag.getIntArray("Pages")));
            if (!already.contains(EnumPaleoPages.BRONTOSAURUS.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.BRONTOSAURUS.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.brontosaurus_added"), true);
				return InteractionResult.SUCCESS;
			} else {
				player.displayClientMessage(Component.translatable("paleopedia.brontosaurus_already_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		return super.mobInteract(player, hand);
	}
	
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) {
			this.setProtective(true);
		} else {
			this.setTerritorial(true);
		}
		this.setHerbivorous(true);
		this.setDiurnal(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	@SuppressWarnings("deprecation")
	protected void playStepSound(BlockPos pos, BlockState state) {
		if (this.isBaby()) {
			if (!state.liquid()) {
				BlockState blockstate = this.level().getBlockState(pos.above());
				SoundType soundtype = blockstate.is(Blocks.SNOW) ? blockstate.getSoundType(level(), pos, this) : state.getSoundType(level(), pos, this);
				this.playSound(soundtype.getStepSound(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
		} else {
			this.playSound(SoundEvents.COW_STEP, 0.15F, 1F);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 200.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.22D).add(Attributes.ATTACK_DAMAGE, 12.0D).add(Attributes.KNOCKBACK_RESISTANCE, 1.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? PFSounds.BRONTOSAURUS_SNORES.get() : PFSounds.BRONTOSAURUS_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.BRONTOSAURUS_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.BRONTOSAURUS_DEATH.get();
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.BRONTOSAURUS_WARN.get(), 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(IS_JUVENILE, false);
		this.entityData.define(IS_SUBADULT, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
		compound.putBoolean("IsJuvenile", this.isJuvenile());
		compound.putBoolean("IsSubadult", isSubadult());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setJuvenile(compound.getBoolean("IsJuvenile"));
		this.setSubadult(compound.getBoolean("IsSubadult"));
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}
	
	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() < -48000) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(25);
		} else if (this.getAge() >= -48000 && this.getAge() < -24000) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(50);
			this.setJuvenile(true);
		} else if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(100);
			this.setJuvenile(false);
			this.setSubadult(true);
		} else if(this.getAge() >= 0) {
			this.setSubadult(false);
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(200);
		}
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.getDeltaMovement().x == 0 && this.getDeltaMovement().y == 0 && this.getDeltaMovement().z == 0) {
			
		} else {
			if (!this.isBaby() && PrehistoricFaunaConfig.sauropodTrampling) {
				if (PrehistoricFaunaConfig.sauropodTrampling) {
					BlockPos currentPosition = new BlockPos((int) this.position().x(), (int) this.position().y(), (int) this.position().z());
			        BlockPos previousPosition = previousPositions.getOrDefault(this, currentPosition);
					if (!previousPosition.equals(currentPosition)) {
						for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1, 0, 1))) {
							if (!(entity instanceof Brontosaurus) && entity.getMaxHealth() < 60) {
								entity.hurt(PFDamageSources.causeSauropodTramplingDamage(entity.level().registryAccess(), this), (float) 5.0D);
							}
						}
					}
					previousPositions.clear();
			        previousPositions.put(this, currentPosition);
				}
			}
		}
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
			super(Brontosaurus.this, 1.25D, true);
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
					Brontosaurus.this.playWarningSound();
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
			return (double)(15.0F + attackTarget.getBbWidth());
		}
	}

	static class MateGoal extends BreedGoal {
		private final Brontosaurus brontosaurus;
		private static final TargetingConditions PARTNER_TARGETING = TargetingConditions.forNonCombat().range(8.0D).ignoreLineOfSight();
		private int breedDelay;
		private final double moveSpeed;

		MateGoal(Brontosaurus brontosaurus, double speed) {
			super(brontosaurus, speed);
			this.brontosaurus = brontosaurus;
			this.moveSpeed = speed;
		}

		@Nullable
		private Animal getNearbyMate() {
			List<Brontosaurus> list = this.level.getNearbyEntities(Brontosaurus.class, PARTNER_TARGETING, this.animal, this.animal.getBoundingBox().inflate(24.0D));
			double d0 = Double.MAX_VALUE;
			Animal animalentity = null;

			for(Animal animalentity1 : list) {
				if (this.animal.canMate(animalentity1) && this.animal.distanceToSqr(animalentity1) < d0) {
					animalentity = animalentity1;
					d0 = this.animal.distanceToSqr(animalentity1);
				}
			}

			return animalentity;
		}

		public boolean canUse() {
			return super.canUse() && !this.brontosaurus.hasBaby() && !this.brontosaurus.isInLoveNaturally();
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
			this.brontosaurus.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			RandomSource random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Brontosaurus brontosaurus;

		NaturalMateGoal(Brontosaurus brontosaurus, double speed) {
			super(brontosaurus, speed);
			this.brontosaurus = brontosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.brontosaurus.hasBaby() && this.brontosaurus.getCurrentHunger() >= this.brontosaurus.getThreeQuartersHunger() && this.brontosaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.brontosaurus.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.brontosaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.brontosaurus.random.nextFloat() - this.brontosaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.brontosaurus.random.nextInt(4);
				for (int i = 0; i <= eggAmount; i++) {
					this.brontosaurus.spawnAtLocation(PFBlocks.BRONTOSAURUS_EGG.get().asItem());
				}
			} else {
				this.brontosaurus.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Brontosaurus entity = new Brontosaurus(PFEntities.BRONTOSAURUS.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		entity.setAge(-72000);
		return entity;
	}

	class BrontosaurusFollowParentGoal extends Goal {
		private final Brontosaurus babyBrontosaurus;
		private Brontosaurus parentBrontosaurus;
		private final double moveSpeed;
		private int delayCounter;

		public BrontosaurusFollowParentGoal(Brontosaurus brontosaurus, double speed) {
			this.babyBrontosaurus = brontosaurus;
			this.moveSpeed = speed;
		}

		public boolean canUse() {
			if (this.babyBrontosaurus.isBaby() && !this.babyBrontosaurus.isJuvenile()) {
				List<? extends Brontosaurus> list = this.babyBrontosaurus.level().getEntitiesOfClass(this.babyBrontosaurus.getClass(), this.babyBrontosaurus.getBoundingBox().inflate(8.0D, 4.0D, 8.0D));
				Brontosaurus brontosaurus = null;
				double d0 = Double.MAX_VALUE;
				for (Brontosaurus tyrannosaurus1 : list) {
					if (!tyrannosaurus1.isBaby()) {
						double d1 = this.babyBrontosaurus.distanceToSqr(tyrannosaurus1);
						if (!(d1 > d0)) {
							d0 = d1;
							brontosaurus = tyrannosaurus1;
						}
					}
				}
				if (brontosaurus == null) {
					return false;
				} else if (d0 < 9.0D) {
					return false;
				} else {
					this.parentBrontosaurus = brontosaurus;
					return true;
				}
			} else {
				return false;
			}
		}

		public boolean canContinueToUse() {
			if (!this.babyBrontosaurus.isJuvenile() || !this.babyBrontosaurus.isBaby()) {
				return false;
			} else if (!this.parentBrontosaurus.isAlive()) {
				return false;
			} else  if(this.babyBrontosaurus.isBaby() && !this.babyBrontosaurus.isJuvenile()){
				double d0 = this.babyBrontosaurus.distanceToSqr(this.parentBrontosaurus);
				return !(d0 < 9.0D) && !(d0 > 256.0D);
			} else {
				return false;
			}
		}

		public void start() {
			this.delayCounter = 0;
		}

		public void stop() {
			this.parentBrontosaurus = null;
		}

		public void tick() {
			if (--this.delayCounter <= 0) {
				this.delayCounter = 10;
				this.babyBrontosaurus.getNavigation().moveTo(this.parentBrontosaurus, this.moveSpeed);
			}
		}
	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.BRONTOSAURUS_SPAWN_EGG.get());
	}
    
	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.BRONTOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}
	
	public Item getEggItem() {
		return PFItems.BRONTOSAURUS_EGG.get();
	}

}
