package superlord.prehistoricfauna.common.entity.cretaceous.yixian;

import java.util.Optional;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.NestAndEggsBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.BabyCarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurWaterAvoidingRandomStrollGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.OmnivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Beipiaosaurus extends DinosaurEntity {
	private int maxHunger = 38;
	private int warningSoundTicks;

	public Beipiaosaurus(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.setMaxUpStep(1);
		super.maxHunger = this.maxHunger;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.TAXUS_BERRIES.get();
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Beipiaosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(5, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.BEIPIAOSAURUS_AVOIDING);
		}));
		this.goalSelector.addGoal(0, new OmnivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(5, new Beipiaosaurus.StripLogGoal((double)1.2F, 12, 2));
		this.targetSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.BEIPIAOSAURUS_HUNTING);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.BEIPIAOSAURUS_BABY_HUNTING);
		}));
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) {
			this.setProtective(true);
		} else {
			this.setTerritorial(true);
		}
		this.setOmnivorous(true);
		this.setDiurnal(true);
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

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 3.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.BEIPIAOSAURUS_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.BEIPIAOSAURUS_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.BEIPIAOSAURUS_DEATH.get();
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.BEIPIAOSAURUS_WARN.get(), 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
		}
		return flag;
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Beipiaosaurus entity = new Beipiaosaurus(PFEntities.BEIPIAOSAURUS.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.BEIPIAOSAURUS_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.BEIPIAOSAURUS_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.BEIPIAOSAURUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1)).setValue(NestAndEggsBlock.PLANT_LEVEL, Integer.valueOf(this.random.nextInt(3) + 1));
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Beipiaosaurus.this, 1.25D, true);
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
					Beipiaosaurus.this.playWarningSound();
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

	class StripLogGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public StripLogGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Beipiaosaurus.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
		}
		
		public double acceptedDistance() {
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
			return (blockstate.is(PFBlocks.SPLATTERED_GINKGO.get()) && (worldIn.getBlockState(pos.below()).is(BlockTags.LOGS) || worldIn.getBlockState(pos.above()).is(BlockTags.LOGS) || worldIn.getBlockState(pos.east()).is(BlockTags.LOGS) || worldIn.getBlockState(pos.west()).is(BlockTags.LOGS) || worldIn.getBlockState(pos.north()).is(BlockTags.LOGS) || worldIn.getBlockState(pos.south()).is(BlockTags.LOGS)));
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			ItemStack stack = Beipiaosaurus.this.getMainHandItem();
			if (this.isReachedTarget() && stack.getItem() == Items.AIR) {
				if (this.field_220731_g >= 40) {
					this.stripLog();
				} else {
					++this.field_220731_g;
				}
			}
			super.tick();
		}

		@javax.annotation.Nullable
		public static BlockState getAxeStrippingState(BlockState originalState) {
			Block block = AxeItem.STRIPPABLES.get(originalState.getBlock());
			return block != null ? block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, originalState.getValue(RotatedPillarBlock.AXIS)) : null;
		}

		@SuppressWarnings("unused")
		private Optional<BlockState> getStripped(BlockState newState) {
			return Optional.ofNullable(AxeItem.STRIPPABLES.get(newState.getBlock())).map((p_150689_) -> {
				return p_150689_.defaultBlockState().setValue(RotatedPillarBlock.AXIS, newState.getValue(RotatedPillarBlock.AXIS));
			});
		}

		protected void stripLog() {
			if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(Beipiaosaurus.this.level(), Beipiaosaurus.this)) {
				BlockState blockstate = Beipiaosaurus.this.level().getBlockState(this.blockPos);
				level().addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 0.0D, 0.0D, 0.0D);
				level().removeBlock(this.blockPos, true);
				if (AxeItem.STRIPPABLES.containsKey(level().getBlockState(this.blockPos.east()).getBlock())) {
					level().setBlockAndUpdate(this.blockPos.east(), getAxeStrippingState(level().getBlockState(blockPos.east())));
				}
				if (AxeItem.STRIPPABLES.containsKey(level().getBlockState(this.blockPos.west()).getBlock())) {
					level().setBlockAndUpdate(this.blockPos.west(), getAxeStrippingState(level().getBlockState(blockPos.west())));
				}
				if (AxeItem.STRIPPABLES.containsKey(level().getBlockState(this.blockPos.north()).getBlock())) {
					level().setBlockAndUpdate(this.blockPos.north(), getAxeStrippingState(level().getBlockState(blockPos.north())));
				}
				if (AxeItem.STRIPPABLES.containsKey(level().getBlockState(this.blockPos.south()).getBlock())) {
					level().setBlockAndUpdate(this.blockPos.south(), getAxeStrippingState(level().getBlockState(blockPos.south())));
				}
				if (AxeItem.STRIPPABLES.containsKey(level().getBlockState(this.blockPos.above()).getBlock())) {
					level().setBlockAndUpdate(this.blockPos.above(), getAxeStrippingState(level().getBlockState(blockPos.above())));
				}
				if (AxeItem.STRIPPABLES.containsKey(level().getBlockState(this.blockPos.below()).getBlock())) {
					level().setBlockAndUpdate(this.blockPos.below(), getAxeStrippingState(level().getBlockState(blockPos.below())));
				}
			}
		}

	}
}
