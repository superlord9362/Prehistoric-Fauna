package superlord.prehistoricfauna.common.entity.cretaceous.hellcreek;

import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Containers;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.AggressiveTempermentAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
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

public class Ankylosaurus extends DinosaurEntity {
	private static final EntityDataAccessor<Boolean> TUBER_DIGGING = SynchedEntityData.defineId(Ankylosaurus.class, EntityDataSerializers.BOOLEAN);
	private int warningSoundTicks = 200;
	private int maxHunger = 200;

	@SuppressWarnings("deprecation")
	public Ankylosaurus(EntityType<? extends Ankylosaurus> type, Level worldIn) {
		super(type, worldIn);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Ankylosaurus entity = new Ankylosaurus(PFEntities.ANKYLOSAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	public int getMaxAir() {
		return 0;
	}
	
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 80) {
			this.setTerritorial(true);
		} else if (temperment >= 80 && temperment < 95) {
			this.setProtective(true);
		} else if (temperment >= 95) {
			this.setAggressive(true);
		}
		this.setHerbivorous(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public boolean isTuberDigging() {
		return this.entityData.get(TUBER_DIGGING);
	}

	private void setTuberDigging(boolean isTuberDigging) {
		this.entityData.set(TUBER_DIGGING, isTuberDigging);
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.CLUBMOSS.get().asItem();
	}

	public int getCurrentHunger() {
		return this.currentHunger;
	}

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.76F;
		else return 1.5F;
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isBaby()) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(40);
		} else {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(80);
		}
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		}
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new Ankylosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(6, new DiggingGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.targetSelector.addGoal(2, new AggressiveTempermentAttackGoal(this));
		this.targetSelector.addGoal(3, new ProtectBabyGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 80.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ARMOR, 10D).add(Attributes.ATTACK_DAMAGE, 14.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.5D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? PFSounds.ANKYLOSAURUS_SNORES : PFSounds.ANKYLOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.ANKYLOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.ANKYLOSAURUS_DEATH;
	}

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
			this.playSound(PFSounds.ANKYLOSAURUS_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(TUBER_DIGGING, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("TuberDigging", this.isTuberDigging());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setTuberDigging(compound.getBoolean("TuberDigging"));
	}

	/**
	 * Called to update the entity's position/logic.
	 */
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

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Ankylosaurus.this, 1.25D, true);
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
					Ankylosaurus.this.playWarningSound();
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

	static class DiggingGoal extends Goal {
		private static final ResourceLocation DIGGING_LOOT = new ResourceLocation(PrehistoricFauna.MOD_ID, "entities/ankylosaurus_digging");

		private final Ankylosaurus ankylosaurus;
		private int diggingTimer;
		private int digTimer2;

		public DiggingGoal(Ankylosaurus entity) {
			this.ankylosaurus = entity;
			setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
		}

		@Override
		public boolean canUse() {
			if (digTimer2 > 0) {
				--digTimer2;
				return false;
			}
			if (ankylosaurus.getRandom().nextInt(ankylosaurus.isBaby() ? 100 : 1000) != 0) {
				return false;
			} else {
				BlockPos blockpos = ankylosaurus.blockPosition();
				BlockState state = ankylosaurus.level.getBlockState(blockpos);
				if (state.is(BlockTags.DIRT)) {
					return true;
				} else {
					return ankylosaurus.level.getBlockState(blockpos.below()).is(BlockTags.DIRT);
				}
			}
		}

		@Override
		public void start() {
			diggingTimer = 40;
			digTimer2 = 6000;
			ankylosaurus.level.broadcastEntityEvent(ankylosaurus, (byte) 10);
			ankylosaurus.setTuberDigging(true);
			ankylosaurus.getNavigation().stop();
		}

		@Override
		public void stop() {
			diggingTimer = 0;
			ankylosaurus.setTuberDigging(false);
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
				BlockPos blockpos = ankylosaurus.blockPosition();
				BlockPos blockpos1 = blockpos.below();
				if (ankylosaurus.level.getBlockState(blockpos1).is(BlockTags.DIRT)) {
					BlockState state = ankylosaurus.level.getBlockState(blockpos1);
					ankylosaurus.level.levelEvent(2001, blockpos1, Block.getId(state));
					MinecraftServer server = ankylosaurus.level.getServer();
					if (server != null) {
						List<ItemStack> items = server.getLootTables().get(DIGGING_LOOT).getRandomItems(new LootContext.Builder((ServerLevel) ankylosaurus.level).withRandom(ankylosaurus.getRandom()).create(LootContextParamSets.EMPTY));
						Containers.dropContents(ankylosaurus.level, blockpos, NonNullList.of(ItemStack.EMPTY, items.toArray(new ItemStack[0])));
					}
				}
			}
		}

	}

	public boolean hurt(DamageSource p_33421_, float p_33422_) {
		Entity entity = p_33421_.getDirectEntity();
		if (entity instanceof AbstractArrow) {
			return false;
		}
		return super.hurt(p_33421_, p_33422_);
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.ANKYLOSAURUS_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.ANKYLOSAURUS_EGG.get();
	}

	public BlockState getEggBlock() {
		return PFBlocks.ANKYLOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}
}