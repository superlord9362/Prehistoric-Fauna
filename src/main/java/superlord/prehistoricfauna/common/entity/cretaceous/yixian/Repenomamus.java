package superlord.prehistoricfauna.common.entity.cretaceous.yixian;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
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
import superlord.prehistoricfauna.common.entity.BurrowingDinosaur;
import superlord.prehistoricfauna.common.entity.goal.AvoidHealthyAdultGoal;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurWaterAvoidingRandomStrollGoal;
import superlord.prehistoricfauna.common.entity.goal.LowHealthOrBabyHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Repenomamus extends BurrowingDinosaur {
	private int maxHunger = 20;

	public Repenomamus(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.setMaxUpStep(1.0F);
		super.maxHunger = maxHunger;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_SMALL_MARGINOCEPHALIAN_MEAT.get();
	}
	
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(4);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(8);
		}
	}
	
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(4, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(3, new DinosaurTerritorialAttackGoal(this));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(0, new Repenomamus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Repenomamus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Repenomamus.CarryYoungGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.goalSelector.addGoal(8, new AvoidHealthyAdultGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.REPENOMAMUS_AVOIDING);
		}));
		this.goalSelector.addGoal(0, new CarnivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new LowHealthOrBabyHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_237491_0_) -> {
			return p_237491_0_.getType().is(PFTags.REPENOMAMUS_HUNTING);
		}));
		this.goalSelector.addGoal(1, new Repenomamus.MeleeAttackGoal());
	}
	
	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.REPENOMAMUS_IDLE.get();
	}
	
	protected SoundEvent getHurtSound(DamageSource source) {
		return PFSounds.REPENOMAMUS_HURT.get();
	}
	
	protected SoundEvent getDeathSound() {
		return PFSounds.REPENOMAMUS_DEATH.get();
	}
	
	static class MateGoal extends BreedGoal {
		private final Repenomamus repenomamus;

		MateGoal(Repenomamus repenomamus, double speed) {
			super(repenomamus, speed);
			this.repenomamus = repenomamus;
		}

		public boolean canUse() {
			return super.canUse() && !this.repenomamus.hasBaby() && !this.repenomamus.isInLoveNaturally();
		}

		protected void breed() {
			ServerPlayer serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.partner.getLoveCause() != null) {
				serverplayerentity = this.partner.getLoveCause();
			}
			if (serverplayerentity != null) {
				serverplayerentity.awardStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.partner, (AgeableMob)null);
			}
			this.repenomamus.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			RandomSource random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Repenomamus repenomamus;

		NaturalMateGoal(Repenomamus repenomamus, double speed) {
			super(repenomamus, speed);
			this.repenomamus = repenomamus;
		}

		public boolean canUse() {
			return super.canUse() && !this.repenomamus.hasBaby() && this.repenomamus.getCurrentHunger() >= this.repenomamus.getThreeQuartersHunger() && this.repenomamus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.repenomamus.isInLoveNaturally();
		}

		protected void breed() {
			this.repenomamus.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}
	
	static class CarryYoungGoal extends MoveToBlockGoal {
		private final Repenomamus repenomamus;

		CarryYoungGoal(Repenomamus repenomamus, double speedIn) {
			super(repenomamus, speedIn, 16);
			this.repenomamus = repenomamus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.repenomamus.hasBaby() ? super.canUse() : false;
		}

		/**
		 * Returns whether an in-progress AIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.repenomamus.hasBaby();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			if (!this.repenomamus.isInWater() && this.isReachedTarget()) {
				if (this.repenomamus.isBirthing < 1) {
					this.repenomamus.setBirthing(true);
				} else if (this.repenomamus.isBirthing > 200) {
					Level level = this.repenomamus.level();
					int amount = level.random.nextInt(4) + 1;
					for (int i = 0; i < amount; i++) {
						Repenomamus baby = new Repenomamus(PFEntities.REPENOMAMUS.get(), level);
						baby.setAge(-24000);
						baby.setPos(repenomamus.getX(), repenomamus.getY(), repenomamus.getZ());
						level.addFreshEntity(baby);
					}
					this.repenomamus.setHasBaby(false);
					this.repenomamus.setBirthing(false);
					this.repenomamus.setInLoveTime(600);
				}

				if (this.repenomamus.isBirthing()) {
					this.repenomamus.isBirthing++;
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

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 80) {
			this.setOpportunist(true);
		} else if (temperment >= 80 && temperment < 95) {
			this.setTerritorial(true);
		} else if (temperment >= 95) {
			this.setProtective(true);
		}
		this.setCarnivorous(true);
		this.setNocturnal(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 3.0D);
	}
	
	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Repenomamus entity = new Repenomamus(PFEntities.REPENOMAMUS.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.REPENOMAMUS_SPAWN_EGG.get());
	}
	
	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Repenomamus.this, 1.25D, true);
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

}
