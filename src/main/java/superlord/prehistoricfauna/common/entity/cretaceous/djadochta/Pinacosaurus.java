package superlord.prehistoricfauna.common.entity.cretaceous.djadochta;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Pinacosaurus extends DinosaurEntity {
	private int maxHunger = 100;
	private int warningSoundTicks;

	@SuppressWarnings("deprecation")
	public Pinacosaurus(EntityType<? extends Pinacosaurus> type, Level worldIn) {
		super(type, worldIn);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Pinacosaurus entity = new Pinacosaurus(PFEntities.PINACOSAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.HORSETAIL.get().asItem();
	}

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.425F;
		else return 1.1F;
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new Pinacosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(3, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(3, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(10, new Pinacosaurus.RidePinacosaurusGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
	}

	public boolean hurt(DamageSource p_33421_, float p_33422_) {
		Entity entity = p_33421_.getDirectEntity();
		if (entity instanceof AbstractArrow) {
			return false;
		}
		return super.hurt(p_33421_, p_33422_);
	}

	public void aiStep() {
		super.aiStep();
		if (this.isBaby()) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);
		} else {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(40);
		}
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ARMOR, 10D).add(Attributes.ATTACK_DAMAGE, 8.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.5D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.PINACOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.PINACOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.PINACOSAURUS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		if (this.isBaby()) {
			if (!blockIn.getMaterial().isLiquid()) {
				BlockState blockstate = this.level.getBlockState(pos.above());
				SoundType soundtype = blockstate.is(Blocks.SNOW) ? blockstate.getSoundType(level, pos, this) : blockIn.getSoundType(level, pos, this);
				this.playSound(soundtype.getStepSound(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
		} else {
			this.playSound(SoundEvents.COW_STEP, 0.15F, 1F);
		}
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.PINACOSAURUS_WARNING, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		this.setHerbivorous(true);
		if (temperment < 85) {
			this.setProtective(true);
		} else {
			this.setTerritorial(true);
		}
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (!this.isVehicle() && !player.isSecondaryUseActive() && !this.isBaby() && !this.isSleeping()) {
			boolean flag = this.isFood(player.getItemInHand(hand));
			if (!flag && !this.isVehicle() && !player.isSecondaryUseActive()) {
				if (!this.level.isClientSide) {
					player.startRiding(this);
				}
				return InteractionResult.sidedSuccess(this.level.isClientSide);
			}
		} else if (!this.getPassengers().isEmpty()) {
			this.ejectPassengers();
		}
		return super.mobInteract(player, hand);
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
		if (this.getPassengers().isEmpty()) {
			for (Entity e : level.getEntities(this, getBoundingBox().inflate(0.5))) {
				if (e instanceof Mob && e.getBbWidth() <= 0.75F && e.getBbHeight() <= 0.75F && !this.isBaby() && ((Mob)e).getMobType() != MobType.WATER && !this.isInWater()) {
					e.startRiding(this);
				}
			}
		} else if (!getPassengers().isEmpty() && this.isInWater()) {
			this.ejectPassengers();
		}
	}

	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
	}

	@Override
	public boolean canBeControlledByRider() {
		return false;
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
			super(Pinacosaurus.this, 1.25D, true);
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
					Pinacosaurus.this.playWarningSound();
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

	public class RidePinacosaurusGoal extends Goal {
		private final Mob entity;

		public RidePinacosaurusGoal(Mob entity) {
			this.entity = entity;
		}

		@Override
		public boolean canUse() {
			return entity.tickCount % 60 == 0 && entity.getPassengers().isEmpty();
		}

		@Override
		public boolean canContinueToUse() {
			return entity.tickCount % 80 != 0;
		}

		@Override
		public void start() {
			super.start();
			for (Mob mob : entity.level.getEntitiesOfClass(Mob.class, entity.getBoundingBox().inflate(5), e -> e != entity && e.getVehicle() == null)) {
				if (mob.getBbWidth() <= 0.75F && mob.getBbHeight() <= 0.75F) {
					mob.getNavigation().moveTo(entity, mob.getSpeed() + 0.4);
				}
			}
		}
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.PINACOSAURUS_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.PINACOSAURUS_EGG.get();
	}

	public BlockState getEggBlock() {
		return PFBlocks.PINACOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}

}