package superlord.prehistoricfauna.common.entity.jurassic.morrison;

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
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.CrepuscularSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Ceratosaurus extends DinosaurEntity {
	private int maxHunger = 100;
	private int warningSoundTicks;
	private Goal attackAnimals;

	@SuppressWarnings("deprecation")
	public Ceratosaurus(EntityType<? extends Ceratosaurus> type, Level levelIn) {
		super(type, levelIn);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.95F;
		else return 1.9F;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_SMALL_ORNITHISCHIAN_MEAT.get();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.attackAnimals = new HuntGoal(this, Animal.class, 10, false, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.ANIMALS_6_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_8_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_10_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_15_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_20_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_30_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_40_HUNGER);
		});
		this.goalSelector.addGoal(1, new Ceratosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Ceratosaurus.PanicGoal());
		this.targetSelector.addGoal(1, new Ceratosaurus.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Ceratosaurus.AttackPlayerGoal());
		this.targetSelector.addGoal(2, new Ceratosaurus.TerritoryAttackGoal());
		this.goalSelector.addGoal(0, new Ceratosaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Ceratosaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(0, new Ceratosaurus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Allosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Stegosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Camarasaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Triceratops.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Ankylosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Tyrannosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(1, new CrepuscularSleepGoal(this));
		this.goalSelector.addGoal(0, new Ceratosaurus.CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.ANIMALS_6_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_8_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_10_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_15_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_20_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_30_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_40_HUNGER);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.ANIMALS_3_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_4_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_6_HUNGER);
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
					if (itemstack.is(PFTags.MEATS_2_HUNGER)) {
						if (hunger + 2 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 2);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.MEATS_4_HUNGER)) {
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

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 8.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.25D);
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, this.attackAnimals);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.CERATOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.CERATOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.CERATOSAURUS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(SoundEvents.COW_STEP, 0.15F, 1F);
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.CERATOSAURUS_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setAttackGoals();
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
			super(Ceratosaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean canUse() {
			if (Ceratosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for (@SuppressWarnings("unused") Ceratosaurus ceratosaurus : Ceratosaurus.this.level.getEntitiesOfClass(Ceratosaurus.class, Ceratosaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {	
						if (Ceratosaurus.this.isBaby()) {
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
			super(Ceratosaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			if (Ceratosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(@SuppressWarnings("unused") Ceratosaurus ceratosaurus : Ceratosaurus.this.level.getEntitiesOfClass(Ceratosaurus.class, Ceratosaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
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
			super(Ceratosaurus.this);
		}

		public void start() {
			super.start();
			if(Ceratosaurus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}
		}

		protected void alertOther(Mob entity, LivingEntity target) {
			if (entity instanceof Ceratosaurus && !entity.isBaby()) {
				super.alertOther(entity, target);
			}
		}

	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Ceratosaurus.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				Ceratosaurus.this.playSound(PFSounds.CERATOSAURUS_BITE, 1.0F, Ceratosaurus.this.getVoicePitch());
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}

				if (this.getTicksUntilNextAttack() <= 10) {
					Ceratosaurus.this.playWarningSound();
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
			super(Ceratosaurus.this, 2.0D);
		}

		public boolean canUse() {
			return !Ceratosaurus.this.isBaby() && !Ceratosaurus.this.isOnFire() ? false : super.canUse();
		}

	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Ceratosaurus ceratosaurus;

		LayEggGoal(Ceratosaurus ceratosaurus, double speed) {
			super(ceratosaurus, speed, 16);
			this.ceratosaurus = ceratosaurus;
		}

		public boolean canUse() {
			return this.ceratosaurus.hasBaby() ? super.canUse() : false;
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && ceratosaurus.hasBaby();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.ceratosaurus.position());
			if (!this.ceratosaurus.isInWater() && this.isReachedTarget()) {
				if (this.ceratosaurus.isBirthing < 1) {
					this.ceratosaurus.setBirthing(true);
				} else if (this.ceratosaurus.isBirthing > 200) {
					Level level = this.ceratosaurus.level;
					level.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);
					level.setBlock(this.blockPos.above(), PFBlocks.CERATOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.ceratosaurus.random.nextInt(4) + 1)), 3);
					this.ceratosaurus.setHasBaby(false);
					this.ceratosaurus.setBirthing(false);
					this.ceratosaurus.setInLoveTime(600);
				}
				if (this.ceratosaurus.isBirthing()) {
					this.ceratosaurus.isBirthing++;
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
		private final Ceratosaurus ceratosaurus;

		MateGoal(Ceratosaurus ceratosaurus, double speed) {
			super(ceratosaurus, speed);
			this.ceratosaurus = ceratosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.ceratosaurus.hasBaby() && !this.ceratosaurus.isInLoveNaturally();
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
			this.ceratosaurus.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}

	}

	static class NaturalMateGoal extends BreedGoal {
		private final Ceratosaurus ceratosaurus;

		NaturalMateGoal(Ceratosaurus ceratosaurus, double speed) {
			super(ceratosaurus, speed);
			this.ceratosaurus = ceratosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.ceratosaurus.hasBaby() && this.ceratosaurus.getCurrentHunger() >= this.ceratosaurus.getThreeQuartersHunger() && this.ceratosaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.ceratosaurus.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.ceratosaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.ceratosaurus.random.nextFloat() - this.ceratosaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.ceratosaurus.random.nextInt(4);
				if (eggAmount == 0) {
					this.ceratosaurus.spawnAtLocation(PFBlocks.CERATOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.ceratosaurus.spawnAtLocation(PFBlocks.CERATOSAURUS_EGG.get().asItem());
					this.ceratosaurus.spawnAtLocation(PFBlocks.CERATOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.ceratosaurus.spawnAtLocation(PFBlocks.CERATOSAURUS_EGG.get().asItem());
					this.ceratosaurus.spawnAtLocation(PFBlocks.CERATOSAURUS_EGG.get().asItem());
					this.ceratosaurus.spawnAtLocation(PFBlocks.CERATOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.ceratosaurus.spawnAtLocation(PFBlocks.CERATOSAURUS_EGG.get().asItem());
					this.ceratosaurus.spawnAtLocation(PFBlocks.CERATOSAURUS_EGG.get().asItem());
					this.ceratosaurus.spawnAtLocation(PFBlocks.CERATOSAURUS_EGG.get().asItem());
					this.ceratosaurus.spawnAtLocation(PFBlocks.CERATOSAURUS_EGG.get().asItem());
				}
			} else {
				this.ceratosaurus.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Ceratosaurus entity = new Ceratosaurus(PFEntities.CERATOSAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@SuppressWarnings("rawtypes")
	public class CarnivoreHuntGoal extends NearestAttackableTargetGoal {
		Predicate<LivingEntity> targetPredicate;
		double huntSpeed;

		@SuppressWarnings("unchecked")
		public CarnivoreHuntGoal(Mob goalOwnerIn, Class targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
			this.huntSpeed = huntSpeed;
			this.targetPredicate = targetPredicate;
		}

		public boolean canUse() {
			return super.canUse() && Ceratosaurus.this.getCurrentHunger() <= Ceratosaurus.this.getHalfHunger() && !Ceratosaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(Ceratosaurus.this);
		}

		public boolean canContinueToUse() {
			return Ceratosaurus.this.getCurrentHunger() < Ceratosaurus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Ceratosaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Ceratosaurus.this.getTarget();
			if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Ceratosaurus.this.getCurrentHunger() + 6 >= Ceratosaurus.this.maxHunger) {
						Ceratosaurus.this.setHunger(Ceratosaurus.this.maxHunger);
					} else {
						Ceratosaurus.this.setHunger(currentHunger + 6);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_8_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Ceratosaurus.this.getCurrentHunger() + 8 >= Ceratosaurus.this.maxHunger) {
						Ceratosaurus.this.setHunger(Ceratosaurus.this.maxHunger);
					} else {
						Ceratosaurus.this.setHunger(currentHunger + 8);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_10_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Ceratosaurus.this.getCurrentHunger() + 10 >= Ceratosaurus.this.maxHunger) {
						Ceratosaurus.this.setHunger(Ceratosaurus.this.maxHunger);
					} else {
						Ceratosaurus.this.setHunger(currentHunger + 10);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_15_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Ceratosaurus.this.getCurrentHunger() + 15 >= Ceratosaurus.this.maxHunger) {
						Ceratosaurus.this.setHunger(Ceratosaurus.this.maxHunger);
					} else {
						Ceratosaurus.this.setHunger(currentHunger + 15);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_20_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Ceratosaurus.this.getCurrentHunger() + 20 >= Ceratosaurus.this.maxHunger) {
						Ceratosaurus.this.setHunger(Ceratosaurus.this.maxHunger);
					} else {
						Ceratosaurus.this.setHunger(currentHunger + 20);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_30_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Ceratosaurus.this.getCurrentHunger() + 30 >= Ceratosaurus.this.maxHunger) {
						Ceratosaurus.this.setHunger(Ceratosaurus.this.maxHunger);
					} else {
						Ceratosaurus.this.setHunger(currentHunger + 30);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_40_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Ceratosaurus.this.getCurrentHunger() + 40 >= Ceratosaurus.this.maxHunger) {
						Ceratosaurus.this.setHunger(Ceratosaurus.this.maxHunger);
					} else {
						Ceratosaurus.this.setHunger(currentHunger + 40);
					}
				}
			}
			super.tick();
		}

	}

	@SuppressWarnings("rawtypes")
	public class BabyCarnivoreHuntGoal extends NearestAttackableTargetGoal {
		Predicate<LivingEntity> targetPredicate;
		double huntSpeed;
		
		@SuppressWarnings("unchecked")
		public BabyCarnivoreHuntGoal(Mob goalOwnerIn, Class targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
			this.huntSpeed = huntSpeed;
			this.targetPredicate = targetPredicate;
		}

		public boolean canUse() {
			return super.canUse() && Ceratosaurus.this.getCurrentHunger() <= Ceratosaurus.this.getHalfHunger() && Ceratosaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(Ceratosaurus.this);
		}

		public boolean canContinueToUse() {
			return Ceratosaurus.this.getCurrentHunger() < Ceratosaurus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true || !Ceratosaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Ceratosaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Ceratosaurus.this.getTarget();
			if (target.getType().is(PFTags.ANIMALS_3_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Ceratosaurus.this.getCurrentHunger() + 3 >= Ceratosaurus.this.maxHunger) {
						Ceratosaurus.this.setHunger(Ceratosaurus.this.maxHunger);
					} else {
						Ceratosaurus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Ceratosaurus.this.getCurrentHunger() + 4 >= Ceratosaurus.this.maxHunger) {
						Ceratosaurus.this.setHunger(Ceratosaurus.this.maxHunger);
					} else {
						Ceratosaurus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Ceratosaurus.this.getCurrentHunger() + 6 >= Ceratosaurus.this.maxHunger) {
						Ceratosaurus.this.setHunger(Ceratosaurus.this.maxHunger);
					} else {
						Ceratosaurus.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.CERATOSAURUS_SPAWN_EGG.get());
	}


}
