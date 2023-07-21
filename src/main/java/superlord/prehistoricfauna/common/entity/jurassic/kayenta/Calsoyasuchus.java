package superlord.prehistoricfauna.common.entity.jurassic.kayenta;

import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
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
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.BreathAirGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.Tags;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Calsoyasuchus extends DinosaurEntity {
	private int maxHunger = 15;
	private int warningSoundTicks;

	@SuppressWarnings("deprecation")
	public Calsoyasuchus(EntityType<? extends DinosaurEntity> type, Level worldIn) {
		super(type, worldIn);
		this.moveControl = new Calsoyasuchus.MoveHelperController(this);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.15F;
		else return 0.3F;
	}

	public int getMaxAir() {
		return 4800;
	}

	protected int determineNextAir(int currentAir) {
		return this.getMaxAir();
	}

	protected float getWaterSlowDown() {
		return 1F;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.CERATODUS.get();
	}

	class WalkAndSwimPathNavigator extends WaterBoundPathNavigation {

		WalkAndSwimPathNavigator(Calsoyasuchus calsoyasuchus, Level world) {
			super(calsoyasuchus, world);
		}

		protected boolean canNavigate() {
			return true;
		}

		protected PathFinder getPathFinder(int uncategorizedNumber) {
			this.nodeEvaluator = new AmphibiousNodeEvaluator(true);
			return new PathFinder(this.nodeEvaluator, uncategorizedNumber);
		}

		public boolean canStandOnPos(BlockPos pos) {
			return !this.level.getBlockState(pos.below()).isAir();
		}

	}

	static class MoveHelperController extends MoveControl {
		private final Calsoyasuchus calsoyasuchus;

		MoveHelperController(Calsoyasuchus calsoyasuchus) {
			super(calsoyasuchus);
			this.calsoyasuchus = calsoyasuchus;
		}

		public void tick() {
			if (this.calsoyasuchus.isEyeInFluid(FluidTags.WATER)) {
				this.calsoyasuchus.setDeltaMovement(this.calsoyasuchus.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
			}
			if (this.operation == MoveControl.Operation.MOVE_TO && !this.calsoyasuchus.getNavigation().isDone()) {
				float f = (float)(this.speedModifier * this.calsoyasuchus.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.calsoyasuchus.setSpeed(Mth.lerp(0.125F, this.calsoyasuchus.getSpeed(), f));
				double d0 = this.wantedX - this.calsoyasuchus.getX();
				double d1 = this.wantedY - this.calsoyasuchus.getY();
				double d2 = this.wantedZ - this.calsoyasuchus.getZ();
				if (d1 != 0.0D) {
					double d3 = (double)Mth.sqrt((float) (d0 * d0 + d1 * d1 + d2 * d2));
					this.calsoyasuchus.setDeltaMovement(this.calsoyasuchus.getDeltaMovement().add(0.0D, (double)this.calsoyasuchus.getSpeed() * (d1 / d3) * 0.1D, 0.0D));
				}
				if (d0 != 0.0D || d2 != 0.0D) {
					float f1 = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
					this.calsoyasuchus.xRot = this.rotlerp(this.calsoyasuchus.xRot, f1, 90.0F);
					this.calsoyasuchus.xRotO = this.calsoyasuchus.xRot;
				}
			} else {
				this.calsoyasuchus.setSpeed(0.0F);
			}
		}

	}

	protected PathNavigation createNavigation(Level world) {
		return new Calsoyasuchus.WalkAndSwimPathNavigator(this, world);
	}

	protected boolean func_212800_dy() {
		return true;
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(1, new Calsoyasuchus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Calsoyasuchus.PanicGoal());
		this.targetSelector.addGoal(1, new Calsoyasuchus.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Calsoyasuchus.AttackPlayerGoal());
		this.targetSelector.addGoal(2, new Calsoyasuchus.TerritoryAttackGoal());
		this.goalSelector.addGoal(0, new Calsoyasuchus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Calsoyasuchus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(0, new Calsoyasuchus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new BreathAirGoal(this));
		this.goalSelector.addGoal(3, new Calsoyasuchus.SwimGoal(this));
		this.goalSelector.addGoal(0, new Calsoyasuchus.CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.ANIMALS_3_HUNGER) || p_213487_1_.getType().is(PFTags.FISH_3_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_4_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_6_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_10_HUNGER);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.ANIMALS_3_HUNGER) || p_213487_1_.getType().is(PFTags.FISH_3_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_4_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_6_HUNGER);
		}));
		this.targetSelector.addGoal(1, new HuntGoal(this, Animal.class, 10, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.ANIMALS_3_HUNGER) || p_213487_1_.getType().is(PFTags.FISH_3_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_4_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_6_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_10_HUNGER);
		}));
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
					if (itemstack.is(PFTags.MEATS_2_HUNGER) || itemstack.is(PFTags.FISH_2_HUNGER)) {
						if (hunger + 2 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 2);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.MEATS_4_HUNGER) || itemstack.is(PFTags.FISH_4_HUNGER)) {
						if (hunger + 4 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 4);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.MEATS_6_HUNGER)) {
						if (hunger + 6 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 6);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.MEATS_8_HUNGER)) {
						if (hunger + 8 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 8);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.MEATS_10_HUNGER)) {
						if (hunger + 10 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 10);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.MEATS_12_HUNGER)) {
						if (hunger + 12 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 12);
						}
						itemstack.shrink(1);
					}
				}
			}
			else p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.fullHunger"), true);
		}
		return super.mobInteract(p_230254_1_, p_230254_2_);
	}

	public void aiStep() {
		super.aiStep();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		}
	}

	public static boolean canDinosaurSpawn(EntityType<? extends Animal> animal,  LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, Random random) {
		return (worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) || worldIn.getBlockState(pos).is(Blocks.WATER) || worldIn.getBlockState(pos.below()).is(Tags.Blocks.SAND)) && worldIn.getRawBrightness(pos, 0) > 8;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 3.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.CALSOYASUCHUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.CALSOYASUCHUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.CALSOYASUCHUS_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.CALSOYASUCHUS_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}

	public boolean doHurtTarget(Entity entity) {
		boolean flag = super.doHurtTarget(entity);
		if (flag) {
			this.doEnchantDamageEffects(this, entity);
		}
		return flag;
	}

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(Calsoyasuchus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean canUse() {
			if (Calsoyasuchus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for (@SuppressWarnings("unused") Calsoyasuchus calsoyasuchus : Calsoyasuchus.this.level.getEntitiesOfClass(Calsoyasuchus.class, Calsoyasuchus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {	
						if (Calsoyasuchus.this.isBaby()) {
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

	class TerritoryAttackGoal extends NearestAttackableTargetGoal<Player> {
		public TerritoryAttackGoal() {
			super(Calsoyasuchus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			if (Calsoyasuchus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(@SuppressWarnings("unused") Calsoyasuchus calsoyasuchus : Calsoyasuchus.this.level.getEntitiesOfClass(Calsoyasuchus.class, Calsoyasuchus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						return true;
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
			super(Calsoyasuchus.this);
		}

		public void start() {
			super.start();
			if(Calsoyasuchus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}
		}

		protected void alertOther(Mob entity, LivingEntity target) {
			if (entity instanceof Calsoyasuchus && !entity.isBaby()) {
				super.alertOther(entity, target);
			}
		}

	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Calsoyasuchus.this, 1.25D, true);
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
					Calsoyasuchus.this.playWarningSound();
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
			super(Calsoyasuchus.this, 2.0D);
		}

		public boolean canUse() {
			return !Calsoyasuchus.this.isBaby() && !Calsoyasuchus.this.isOnFire() ? false : super.canUse();
		}

	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Calsoyasuchus calsoyasuchus;

		LayEggGoal(Calsoyasuchus calsoyasuchus, double speed) {
			super(calsoyasuchus, speed, 16);
			this.calsoyasuchus = calsoyasuchus;
		}

		public boolean canUse() {
			return this.calsoyasuchus.hasBaby() ? super.canUse() : false;
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && calsoyasuchus.hasBaby();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.calsoyasuchus.position());
			if (!this.calsoyasuchus.isInWater() && this.isReachedTarget()) {
				if (this.calsoyasuchus.isBirthing < 1) {
					this.calsoyasuchus.setBirthing(true);
				} else if (this.calsoyasuchus.isBirthing > 200) {
					Level world = this.calsoyasuchus.level;
					world.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
					world.setBlock(this.blockPos.above(), PFBlocks.CALSOYASUCHUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.calsoyasuchus.random.nextInt(4) + 1)), 3);
					this.calsoyasuchus.setHasBaby(false);
					this.calsoyasuchus.setBirthing(false);
					this.calsoyasuchus.setInLoveTime(600);
				}
				if (this.calsoyasuchus.isBirthing()) {
					this.calsoyasuchus.isBirthing++;
				}
			}
		}

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
		private final Calsoyasuchus calsoyasuchus;

		MateGoal(Calsoyasuchus calsoyasuchus, double speed) {
			super(calsoyasuchus, speed);
			this.calsoyasuchus = calsoyasuchus;
		}

		public boolean canUse() {
			return super.canUse() && !this.calsoyasuchus.hasBaby() && !this.calsoyasuchus.isInLoveNaturally();
		}

		protected void breed() {
			ServerPlayer serverPlayer = this.animal.getLoveCause();
			if (serverPlayer == null && this.partner.getLoveCause() == null) {
				serverPlayer = this.partner.getLoveCause();
			}
			if (serverPlayer != null) {
				serverPlayer.awardStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverPlayer, this.animal, this.partner, (AgeableMob)null);
			}
			this.calsoyasuchus.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}

	}

	static class NaturalMateGoal extends BreedGoal {
		private final Calsoyasuchus calsoyasuchus;

		NaturalMateGoal(Calsoyasuchus calsoyasuchus, double speed) {
			super(calsoyasuchus, speed);
			this.calsoyasuchus = calsoyasuchus;
		}

		public boolean canUse() {
			return super.canUse() && !this.calsoyasuchus.hasBaby() && this.calsoyasuchus.getCurrentHunger() >= this.calsoyasuchus.getThreeQuartersHunger() && this.calsoyasuchus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.calsoyasuchus.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.calsoyasuchus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.calsoyasuchus.random.nextFloat() - this.calsoyasuchus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.calsoyasuchus.random.nextInt(4);
				if (eggAmount == 0) {
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
					this.calsoyasuchus.spawnAtLocation(PFBlocks.CALSOYASUCHUS_EGG.get().asItem());
				}
			} else {
				this.calsoyasuchus.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Calsoyasuchus entity = new Calsoyasuchus(PFEntities.CALSOYASUCHUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	static class SwimGoal extends RandomSwimmingGoal {
		private final Calsoyasuchus calsoyasuchus;

		public SwimGoal(Calsoyasuchus calsoyasuchus) {
			super(calsoyasuchus, 1.0D, 40);
			this.calsoyasuchus = calsoyasuchus;
		}

		public boolean canUse() {
			return this.calsoyasuchus.func_212800_dy() && super.canUse();
		}
	}

	@SuppressWarnings("rawtypes")
	public class CarnivoreHuntGoal extends NearestAttackableTargetGoal {
		double huntSpeed;
		Predicate<LivingEntity> targetPredicate;
		@SuppressWarnings({ "unchecked" })
		public CarnivoreHuntGoal(Mob goalOwnerIn, Class targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
			this.huntSpeed = huntSpeed;
			this.targetPredicate = targetPredicate;
		}

		public boolean canUse() {
			return super.canUse() && Calsoyasuchus.this.getCurrentHunger() <= Calsoyasuchus.this.getHalfHunger() && !Calsoyasuchus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(Calsoyasuchus.this);
		}

		public boolean canContinueToUse() {
			return Calsoyasuchus.this.getCurrentHunger() < Calsoyasuchus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Calsoyasuchus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Calsoyasuchus.this.getTarget();
			if (target.getType().is(PFTags.ANIMALS_3_HUNGER) || target.getType().is(PFTags.FISH_3_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Calsoyasuchus.this.getCurrentHunger() + 3 >= Calsoyasuchus.this.maxHunger) {
						Calsoyasuchus.this.setHunger(Calsoyasuchus.this.maxHunger);
					} else {
						Calsoyasuchus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Calsoyasuchus.this.getCurrentHunger() + 4 >= Calsoyasuchus.this.maxHunger) {
						Calsoyasuchus.this.setHunger(Calsoyasuchus.this.maxHunger);
					} else {
						Calsoyasuchus.this.setHunger(currentHunger + 6);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Calsoyasuchus.this.getCurrentHunger() + 6 >= Calsoyasuchus.this.maxHunger) {
						Calsoyasuchus.this.setHunger(Calsoyasuchus.this.maxHunger);
					} else {
						Calsoyasuchus.this.setHunger(currentHunger + 6);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_8_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Calsoyasuchus.this.getCurrentHunger() + 8 >= Calsoyasuchus.this.maxHunger) {
						Calsoyasuchus.this.setHunger(Calsoyasuchus.this.maxHunger);
					} else {
						Calsoyasuchus.this.setHunger(currentHunger + 8);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_10_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Calsoyasuchus.this.getCurrentHunger() + 10 >= Calsoyasuchus.this.maxHunger) {
						Calsoyasuchus.this.setHunger(Calsoyasuchus.this.maxHunger);
					} else {
						Calsoyasuchus.this.setHunger(currentHunger + 10);
					}
				}
			}
			super.tick();
		}
	}

	@SuppressWarnings("rawtypes")
	public class BabyCarnivoreHuntGoal extends NearestAttackableTargetGoal {
		double huntSpeed;
		Predicate<LivingEntity> targetPredicate;
		@SuppressWarnings("unchecked")
		public BabyCarnivoreHuntGoal(Mob goalOwnerIn, Class targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
			this.huntSpeed = huntSpeed;
			this.targetPredicate = targetPredicate;
		}

		public boolean canUse() {
			return super.canUse() && Calsoyasuchus.this.getCurrentHunger() <= Calsoyasuchus.this.getHalfHunger() && Calsoyasuchus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(Calsoyasuchus.this);
		}

		public boolean canContinueToUse() {
			return Calsoyasuchus.this.getCurrentHunger() < Calsoyasuchus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true || !Calsoyasuchus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Calsoyasuchus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Calsoyasuchus.this.getTarget();
			if (target.getType().is(PFTags.ANIMALS_3_HUNGER) || target.getType().is(PFTags.FISH_3_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Calsoyasuchus.this.getCurrentHunger() + 3 >= Calsoyasuchus.this.maxHunger) {
						Calsoyasuchus.this.setHunger(Calsoyasuchus.this.maxHunger);
					} else {
						Calsoyasuchus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Calsoyasuchus.this.getCurrentHunger() + 4 >= Calsoyasuchus.this.maxHunger) {
						Calsoyasuchus.this.setHunger(Calsoyasuchus.this.maxHunger);
					} else {
						Calsoyasuchus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Calsoyasuchus.this.getCurrentHunger() + 6 >= Calsoyasuchus.this.maxHunger) {
						Calsoyasuchus.this.setHunger(Calsoyasuchus.this.maxHunger);
					} else {
						Calsoyasuchus.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.CALSOYASUCHUS_SPAWN_EGG.get());
	}

}
