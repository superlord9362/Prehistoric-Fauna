package superlord.prehistoricfauna.common.entity.triassic.chinle;

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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.OcelotAttackGoal;
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
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Sillosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Postosuchus extends DinosaurEntity {
	private int maxHunger = 50;
	private int warningSoundTicks;
	private Goal attackAnimals;

	@SuppressWarnings("deprecation")
	public Postosuchus(EntityType<? extends Postosuchus> type, Level levelIn) {
		super(type, levelIn);
		super.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_LARGE_ARCHOSAUROMORPH_MEAT.get();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.attackAnimals = new HuntGoal(this, Animal.class, 10, false, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.ANIMALS_3_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_4_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_6_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_8_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_10_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_15_HUNGER) || p_213487_1_.getType().is(PFTags.ANIMALS_20_HUNGER);
		});
		this.goalSelector.addGoal(1, new OcelotAttackGoal(this));
		this.goalSelector.addGoal(1, new Postosuchus.PanicGoal());
		this.targetSelector.addGoal(1, new Postosuchus.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Postosuchus.AttackPlayerGoal());
		this.targetSelector.addGoal(2, new Postosuchus.TerritoryAttackGoal());
		this.goalSelector.addGoal(0, new Postosuchus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Postosuchus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(0, new Postosuchus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new AvoidEntityGoal(this, Allosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(5, new AvoidEntityGoal(this, Stegosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(5, new AvoidEntityGoal(this, Camarasaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(5, new AvoidEntityGoal(this, Triceratops.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(5, new AvoidEntityGoal(this, Ankylosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(5, new AvoidEntityGoal(this, Tyrannosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(5, new AvoidEntityGoal(this, Sillosuchus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(0, new Postosuchus.CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
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
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 6.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.25D);
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, this.attackAnimals);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.POSTOSUCHUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.POSTOSUCHUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.POSTOSUCHUS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(SoundEvents.COW_STEP, 0.15F, 1F);
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.POSTOSUCHUS_WARN, 1.0F, this.getVoicePitch());
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
			super(Postosuchus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean canUse() {
			if (Postosuchus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for (@SuppressWarnings("unused") Postosuchus postosuchus : Postosuchus.this.level.getEntitiesOfClass(Postosuchus.class, Postosuchus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {	
						if (Postosuchus.this.isBaby()) {
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
			super(Postosuchus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			if (Postosuchus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(@SuppressWarnings("unused") Postosuchus postosuchus : Postosuchus.this.level.getEntitiesOfClass(Postosuchus.class, Postosuchus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
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
			super(Postosuchus.this);
		}

		public void start() {
			super.start();
			if(Postosuchus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}
		}

		protected void alertOther(Mob entity, LivingEntity target) {
			if (entity instanceof Postosuchus && !entity.isBaby()) {
				super.alertOther(entity, target);
			}
		}

	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Postosuchus.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				Postosuchus.this.playSound(PFSounds.POSTOSUCHUS_BITE, 1.0F, Postosuchus.this.getVoicePitch());
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}

				if (this.getTicksUntilNextAttack() <= 10) {
					Postosuchus.this.playWarningSound();
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
			super(Postosuchus.this, 2.0D);
		}

		public boolean canUse() {
			return !Postosuchus.this.isBaby() && !Postosuchus.this.isOnFire() ? false : super.canUse();
		}

	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Postosuchus postosuchus;

		LayEggGoal(Postosuchus postosuchus, double speed) {
			super(postosuchus, speed, 16);
			this.postosuchus = postosuchus;
		}

		public boolean canUse() {
			return this.postosuchus.hasBaby() ? super.canUse() : false;
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && postosuchus.hasBaby();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.postosuchus.position());
			if (!this.postosuchus.isInWater() && this.isReachedTarget()) {
				if (this.postosuchus.isBirthing < 1) {
					this.postosuchus.setBirthing(true);
				} else if (this.postosuchus.isBirthing > 200) {
					Level level = this.postosuchus.level;
					level.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);
					level.setBlock(this.blockPos.above(), PFBlocks.POSTOSUCHUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.postosuchus.random.nextInt(4) + 1)), 3);
					this.postosuchus.setHasBaby(false);
					this.postosuchus.setBirthing(false);
					this.postosuchus.setInLoveTime(600);
				}
				if (this.postosuchus.isBirthing()) {
					this.postosuchus.isBirthing++;
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
		private final Postosuchus postosuchus;

		MateGoal(Postosuchus postosuchus, double speed) {
			super(postosuchus, speed);
			this.postosuchus = postosuchus;
		}

		public boolean canUse() {
			return super.canUse() && !this.postosuchus.hasBaby() && !this.postosuchus.isInLoveNaturally();
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
			this.postosuchus.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}

	}

	static class NaturalMateGoal extends BreedGoal {
		private final Postosuchus postosuchus;

		NaturalMateGoal(Postosuchus postosuchus, double speed) {
			super(postosuchus, speed);
			this.postosuchus = postosuchus;
		}

		public boolean canUse() {
			return super.canUse() && !this.postosuchus.hasBaby() && this.postosuchus.getCurrentHunger() >= this.postosuchus.getThreeQuartersHunger() && this.postosuchus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.postosuchus.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.postosuchus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.postosuchus.random.nextFloat() - this.postosuchus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.postosuchus.random.nextInt(4);
				if (eggAmount == 0) {
					this.postosuchus.spawnAtLocation(PFBlocks.POSTOSUCHUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.postosuchus.spawnAtLocation(PFBlocks.POSTOSUCHUS_EGG.get().asItem());
					this.postosuchus.spawnAtLocation(PFBlocks.POSTOSUCHUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.postosuchus.spawnAtLocation(PFBlocks.POSTOSUCHUS_EGG.get().asItem());
					this.postosuchus.spawnAtLocation(PFBlocks.POSTOSUCHUS_EGG.get().asItem());
					this.postosuchus.spawnAtLocation(PFBlocks.POSTOSUCHUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.postosuchus.spawnAtLocation(PFBlocks.POSTOSUCHUS_EGG.get().asItem());
					this.postosuchus.spawnAtLocation(PFBlocks.POSTOSUCHUS_EGG.get().asItem());
					this.postosuchus.spawnAtLocation(PFBlocks.POSTOSUCHUS_EGG.get().asItem());
					this.postosuchus.spawnAtLocation(PFBlocks.POSTOSUCHUS_EGG.get().asItem());
				}
			} else {
				this.postosuchus.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Postosuchus entity = new Postosuchus(PFEntities.POSTOSUCHUS.get(), this.level);
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
			return super.canUse() && Postosuchus.this.getCurrentHunger() <= Postosuchus.this.getHalfHunger() && !Postosuchus.this.isBaby() && !targetPredicate.test(Postosuchus.this);
		}

		public boolean canContinueToUse() {
			return Postosuchus.this.getCurrentHunger() < Postosuchus.this.maxHunger;
		}

		public void tick() {
			Postosuchus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Postosuchus.this.getTarget();
			if (target.getType().is(PFTags.ANIMALS_3_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Postosuchus.this.getCurrentHunger() + 3 >= Postosuchus.this.maxHunger) {
						Postosuchus.this.setHunger(Postosuchus.this.maxHunger);
					} else {
						Postosuchus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Postosuchus.this.getCurrentHunger() + 4 >= Postosuchus.this.maxHunger) {
						Postosuchus.this.setHunger(Postosuchus.this.maxHunger);
					} else {
						Postosuchus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Postosuchus.this.getCurrentHunger() + 6 >= Postosuchus.this.maxHunger) {
						Postosuchus.this.setHunger(Postosuchus.this.maxHunger);
					} else {
						Postosuchus.this.setHunger(currentHunger + 6);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_8_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Postosuchus.this.getCurrentHunger() + 8 >= Postosuchus.this.maxHunger) {
						Postosuchus.this.setHunger(Postosuchus.this.maxHunger);
					} else {
						Postosuchus.this.setHunger(currentHunger + 8);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_10_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Postosuchus.this.getCurrentHunger() + 10 >= Postosuchus.this.maxHunger) {
						Postosuchus.this.setHunger(Postosuchus.this.maxHunger);
					} else {
						Postosuchus.this.setHunger(currentHunger + 10);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_15_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Postosuchus.this.getCurrentHunger() + 15 >= Postosuchus.this.maxHunger) {
						Postosuchus.this.setHunger(Postosuchus.this.maxHunger);
					} else {
						Postosuchus.this.setHunger(currentHunger + 15);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_20_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Postosuchus.this.getCurrentHunger() + 20 >= Postosuchus.this.maxHunger) {
						Postosuchus.this.setHunger(Postosuchus.this.maxHunger);
					} else {
						Postosuchus.this.setHunger(currentHunger + 20);
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
			return super.canUse() && Postosuchus.this.getCurrentHunger() <= Postosuchus.this.getHalfHunger() && Postosuchus.this.isBaby() && !targetPredicate.test(Postosuchus.this);
		}

		public boolean canContinueToUse() {
			return Postosuchus.this.getCurrentHunger() < Postosuchus.this.maxHunger || !Postosuchus.this.isBaby();
		}

		public void tick() {
			Postosuchus.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Postosuchus.this.getTarget();
			if (target.getType().is(PFTags.ANIMALS_3_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Postosuchus.this.getCurrentHunger() + 3 >= Postosuchus.this.maxHunger) {
						Postosuchus.this.setHunger(Postosuchus.this.maxHunger);
					} else {
						Postosuchus.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Postosuchus.this.getCurrentHunger() + 4 >= Postosuchus.this.maxHunger) {
						Postosuchus.this.setHunger(Postosuchus.this.maxHunger);
					} else {
						Postosuchus.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Postosuchus.this.getCurrentHunger() + 6 >= Postosuchus.this.maxHunger) {
						Postosuchus.this.setHunger(Postosuchus.this.maxHunger);
					} else {
						Postosuchus.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}

	public void customServerAiStep() {
		if (this.getMoveControl().hasWanted()) {
			double d0 = this.getMoveControl().getSpeedModifier();
			if (d0 == 0.6D) {
				this.setSprinting(false);
			} else if (d0 == 1.33D) {
				this.setSprinting(true);
			} else {
				this.setSprinting(false);
			}
		} else {
			this.setSprinting(false);
		}

	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.POSTOSUCHUS_SPAWN_EGG.get());
	}

}