package superlord.prehistoricfauna.common.entity.triassic.ischigualasto;

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
import net.minecraft.world.entity.ai.goal.PanicGoal;
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
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Herrerasaurus extends DinosaurEntity {
	private int maxHunger = 50;
	private int warningSoundTicks;
	private Goal attackAnimals;

	@SuppressWarnings("deprecation")
	public Herrerasaurus(EntityType<? extends Herrerasaurus> type, Level levelIn) {
		super(type, levelIn);
		super.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) {
			return 0.75F;
		} else return 1.5F;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_SMALL_ARCHOSAUROMORPH_MEAT.get();
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.attackAnimals = new HuntGoal(this, Animal.class, 10, false, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.ANIMALS_3_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_4_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_6_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_8_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_10_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_15_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_20_HUNGER);
		});
		this.goalSelector.addGoal(1, new Herrerasaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new Herrerasaurus.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Herrerasaurus.AttackPlayerGoal());
		this.goalSelector.addGoal(0, new Herrerasaurus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Herrerasaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Herrerasaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Camarasaurus>(this, Camarasaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Ankylosaurus>(this, Ankylosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Triceratops>(this, Triceratops.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Stegosaurus>(this, Stegosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Allosaurus>(this, Allosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Ceratosaurus>(this, Ceratosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Tyrannosaurus>(this, Tyrannosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Ischigualastia>(this, Ischigualastia.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.targetSelector.addGoal(0, new Herrerasaurus.CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.ANIMALS_3_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_4_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_6_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_8_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_10_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_15_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_20_HUNGER);
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
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.ATTACK_DAMAGE, 6.0D);
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, this.attackAnimals);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.HERRERASAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.HERRERASAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.HERRERASAURUS_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.HERRERASAURUS_WARN, 1.0F, this.getVoicePitch());
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

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
		}
		return flag;
	}	

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(Herrerasaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean canUse() {
			if (Herrerasaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Herrerasaurus herrerasaurus : Herrerasaurus.this.level.getEntitiesOfClass(Herrerasaurus.class, Herrerasaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (herrerasaurus.isBaby()) {
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

	class HurtByTargetGoal extends net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(Herrerasaurus.this);
		}

		public void start() {
			super.start();
			if (Herrerasaurus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}
		}

		protected void alertOther(Mob mobIn, LivingEntity targetIn) {
			if (mobIn instanceof Herrerasaurus && !mobIn.isBaby()) {
				super.alertOther(mobIn, targetIn);
			}
		}
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Herrerasaurus.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				Herrerasaurus.this.playSound(PFSounds.HERRERASAURUS_BITE, 1.0F, Herrerasaurus.this.getVoicePitch());
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}

				if (this.getTicksUntilNextAttack() <= 10) {
					Herrerasaurus.this.playWarningSound();
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
	static class LayEggGoal extends MoveToBlockGoal {
		private final Herrerasaurus herrerasaurus;

		LayEggGoal(Herrerasaurus herrerasaurus, double speedIn) {
			super(herrerasaurus, speedIn, 16);
			this.herrerasaurus = herrerasaurus;
		}

		public boolean canUse() {
			return this.herrerasaurus.hasBaby() ? super.canUse() : false;
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.herrerasaurus.hasBaby();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.herrerasaurus.position());
			if (!this.herrerasaurus.isInWater() && this.isReachedTarget()) {
				if (this.herrerasaurus.isBirthing < 1) {
					this.herrerasaurus.setBirthing(true);
				} else if (this.herrerasaurus.isBirthing > 200) {
					Level level = this.herrerasaurus.level;
					level.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);
					level.setBlock(this.blockPos.above(), PFBlocks.HERRERASAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.herrerasaurus.random.nextInt(4) + 1)), 3);
					this.herrerasaurus.setHasBaby(false);
					this.herrerasaurus.setBirthing(false);
					this.herrerasaurus.setInLoveTime(600);
				}
				if (this.herrerasaurus.isBirthing()) {
					this.herrerasaurus.isBirthing++;
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
		private final Herrerasaurus herrerasaurus;

		MateGoal(Herrerasaurus herrerasaurus, double speedIn) {
			super(herrerasaurus, speedIn);
			this.herrerasaurus = herrerasaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.herrerasaurus.hasBaby() && !this.herrerasaurus.isInLoveNaturally();
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
			this.herrerasaurus.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Herrerasaurus herrerasaurus;

		NaturalMateGoal(Herrerasaurus herrerasaurus, double speed) {
			super(herrerasaurus, speed);
			this.herrerasaurus = herrerasaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.herrerasaurus.hasBaby() && this.herrerasaurus.getCurrentHunger() >= this.herrerasaurus.getThreeQuartersHunger() && this.herrerasaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.herrerasaurus.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.herrerasaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.herrerasaurus.random.nextFloat() - this.herrerasaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.herrerasaurus.random.nextInt(4);
				if (eggAmount == 0) {
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
					this.herrerasaurus.spawnAtLocation(PFBlocks.HERRERASAURUS_EGG.get().asItem());
				}
			} else {
				this.herrerasaurus.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Herrerasaurus entity = new Herrerasaurus(PFEntities.HERRERASAURUS.get(), this.level);
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
			return super.canUse() && Herrerasaurus.this.getCurrentHunger() <= Herrerasaurus.this.getHalfHunger() && !Herrerasaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(Herrerasaurus.this);
		}

		public boolean canContinueToUse() {
			return Herrerasaurus.this.getCurrentHunger() < Herrerasaurus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			LivingEntity target = Herrerasaurus.this.getTarget();
			Herrerasaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			if (target.getType().is(PFTags.ANIMALS_3_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 3 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 4 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 6 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 6);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_8_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 8 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 8);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_10_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 10 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 10);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_15_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 15 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 15);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_20_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 20 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 20);
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
			return super.canUse() && Herrerasaurus.this.getCurrentHunger() <= Herrerasaurus.this.getHalfHunger() && Herrerasaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(Herrerasaurus.this);
		}

		public boolean canContinueToUse() {
			return Herrerasaurus.this.getCurrentHunger() < Herrerasaurus.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true || !Herrerasaurus.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Herrerasaurus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Herrerasaurus.this.getTarget();
			if (target.getType().is(PFTags.ANIMALS_3_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 3 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 4 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Herrerasaurus.this.getCurrentHunger() + 6 >= Herrerasaurus.this.maxHunger) {
						Herrerasaurus.this.setHunger(Herrerasaurus.this.maxHunger);
					} else {
						Herrerasaurus.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.HERRERASAURUS_SPAWN_EGG.get());
	}

}
