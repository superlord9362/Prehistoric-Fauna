package superlord.prehistoricfauna.common.entity.jurassic.kayenta;

import java.util.Random;
import java.util.function.Predicate;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.blocks.FeederBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Pinacosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Plesiohadros;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Ischigualastia;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Sillosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Scelidosaurus extends DinosaurEntity {
	private static final EntityDataAccessor<Boolean> BIPEDAL = SynchedEntityData.defineId(Scelidosaurus.class, EntityDataSerializers.BOOLEAN);
	private int maxHunger = 38;
	private int warningSoundTicks;

	@SuppressWarnings("deprecation")
	public Scelidosaurus(EntityType<? extends Scelidosaurus> type, Level worldIn) {
		super(type, worldIn);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.4F;
		else return 0.8F;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.CLATHOPTERIS.get().asItem();
	}

	public boolean isBipedal() {
		return this.entityData.get(BIPEDAL);
	}

	private void setBipedal(boolean isBipedal) {
		this.entityData.set(BIPEDAL, isBipedal);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(BIPEDAL, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsBipedal", this.isBipedal());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setBipedal(compound.getBoolean("IsBipedal"));
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(0, new Scelidosaurus.PanicGoal());
		this.goalSelector.addGoal(1, new Scelidosaurus.MeleeAttackGoal());
		this.targetSelector.addGoal(1, new Scelidosaurus.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new Scelidosaurus.AttackPlayerGoal());
		this.goalSelector.addGoal(0, new Scelidosaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Scelidosaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Dilophosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Pinacosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Plesiohadros.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Ankylosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Dakotaraptor.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Triceratops.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Tyrannosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Allosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Camarasaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Ceratosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Stegosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Herrerasaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Ischigualastia.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Saurosuchus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Sillosuchus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new BipedalAvoidEntityGoal(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(0, new Scelidosaurus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.SCELIDOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.SCELIDOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.SCELIDOSAURUS_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.SCELIDOSAURUS_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
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

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, 0.22D).add(Attributes.ARMOR, 6.0D).add(Attributes.ARMOR_TOUGHNESS, 4.0D).add(Attributes.ATTACK_DAMAGE , 4).add(Attributes.FOLLOW_RANGE, 15);
	}

	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		super.handleEntityEvent(id);
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
					if (itemstack.is(PFTags.PLANTS_2_HUNGER_ITEM)) {
						if (hunger + 2 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 2);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_4_HUNGER_ITEM)) {
						if (hunger + 4 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 4);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_6_HUNGER_ITEM)) {
						if (hunger + 6 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 6);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_8_HUNGER_ITEM)) {
						if (hunger + 8 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 8);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_10_HUNGER_ITEM)) {
						if (hunger + 10 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 10);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_12_HUNGER_ITEM)) {
						if (hunger + 12 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 12);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_15_HUNGER_ITEM)) {
						if (hunger + 15 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 15);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_20_HUNGER_ITEM)) {
						if (hunger + 20 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 20);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_25_HUNGER_ITEM)) {
						if (hunger + 25 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 25);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_30_HUNGER_ITEM)) {
						if (hunger + 30 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 30);
						}
						itemstack.shrink(1);
					}
				}
			}
			else p_230254_1_.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.fullHunger"), true);
		}
		return super.mobInteract(p_230254_1_, p_230254_2_);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.22D);
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Scelidosaurus scelidosaurus;

		LayEggGoal(Scelidosaurus scelidosaurus, double speedIn) {
			super(scelidosaurus, speedIn, 16);
			this.scelidosaurus = scelidosaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.scelidosaurus.hasBaby() ? super.canUse() : false;
		}

		/**
		 * Returns whether an in-progress AIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.scelidosaurus.hasBaby();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.scelidosaurus.position());
			if (!this.scelidosaurus.isInWater() && this.isReachedTarget()) {
				if (this.scelidosaurus.isBirthing < 1) {
					this.scelidosaurus.setBirthing(true);
				} else if (this.scelidosaurus.isBirthing > 200) {
					Level world = this.scelidosaurus.level;
					world.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
					world.setBlock(this.blockPos.above(), PFBlocks.SCELIDOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.scelidosaurus.random.nextInt(4) + 1)), 3);
					this.scelidosaurus.setHasBaby(false);
					this.scelidosaurus.setBirthing(false);
					this.scelidosaurus.setInLoveTime(600);
				}

				if (this.scelidosaurus.isBirthing()) {
					this.scelidosaurus.isBirthing++;
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

	static class MateGoal extends BreedGoal {
		private final Scelidosaurus scelidosaurus;

		MateGoal(Scelidosaurus scelidosaurus, double speed) {
			super(scelidosaurus, speed);
			this.scelidosaurus = scelidosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.scelidosaurus.hasBaby() && !this.scelidosaurus.isInLoveNaturally();
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
			this.scelidosaurus.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Scelidosaurus scelidosaurus;

		NaturalMateGoal(Scelidosaurus scelidosaurus, double speed) {
			super(scelidosaurus, speed);
			this.scelidosaurus = scelidosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.scelidosaurus.hasBaby() && this.scelidosaurus.getCurrentHunger() >= this.scelidosaurus.getThreeQuartersHunger() && this.scelidosaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.scelidosaurus.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.scelidosaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.scelidosaurus.random.nextFloat() - this.scelidosaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.scelidosaurus.random.nextInt(4);
				if (eggAmount == 0) {
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
					this.scelidosaurus.spawnAtLocation(PFBlocks.SCELIDOSAURUS_EGG.get().asItem());
				}
			} else {
				this.scelidosaurus.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Scelidosaurus entity = new Scelidosaurus(PFEntities.SCELIDOSAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.position())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Scelidosaurus.this, 1.25D, true);
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
					Scelidosaurus.this.playWarningSound();
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

	class HurtByTargetGoal extends net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(Scelidosaurus.this);
		}

		public void start() {
			super.start();
			if (Scelidosaurus.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}
		}

		protected void alertOther(Mob mobIn, LivingEntity targetIn) {
			if (mobIn instanceof Scelidosaurus && !mobIn.isBaby()) {
				super.alertOther(mobIn, targetIn);
			}
		}
	}

	class PanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(Scelidosaurus.this, 2.0D);
		}

		public boolean canUse() {
			return !Scelidosaurus.this.isBaby() && !Scelidosaurus.this.isOnFire() ? false : super.canUse();
		}

	}

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(Scelidosaurus.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean canUse() {
			if (Scelidosaurus.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Scelidosaurus scelidosaurus : Scelidosaurus.this.level.getEntitiesOfClass(Scelidosaurus.class, Scelidosaurus.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (scelidosaurus.isBaby()) {
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

	@SuppressWarnings("rawtypes")
	class BipedalAvoidEntityGoal extends AvoidEntityGoal {

		@SuppressWarnings("unchecked")
		public BipedalAvoidEntityGoal(PathfinderMob entityIn, Class classToAvoidIn, float avoidDistanceIn, double farSpeedIn, double nearSpeedIn) {
			super(entityIn, classToAvoidIn, avoidDistanceIn, farSpeedIn, nearSpeedIn);
		}

		public void tick() {
			super.tick();
			Scelidosaurus.this.setBipedal(true);
		}

		public void stop() {
			Scelidosaurus.this.setBipedal(false);
			super.stop();
		}

	}
	
	public class EatFromFeederGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public EatFromFeederGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Scelidosaurus.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
		}

		public double getTargetDistanceSq() {
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
			return blockstate.getBlock() instanceof FeederBlock && blockstate.getValue(FeederBlock.PLANT) == true;
		}

		protected BlockPos getMoveToTarget() {
			if (!Scelidosaurus.this.level.getBlockState(blockPos.north()).isCollisionShapeFullBlock(level, blockPos.north())) {
				return this.blockPos.north();
			} else {
				if (!Scelidosaurus.this.level.getBlockState(blockPos.south()).isCollisionShapeFullBlock(level, blockPos.south())) {
					return this.blockPos.south();
				} else {
					if (!Scelidosaurus.this.level.getBlockState(blockPos.east()).isCollisionShapeFullBlock(level, blockPos.east())) {
						return this.blockPos.east();
					} else {
						if (!Scelidosaurus.this.level.getBlockState(blockPos.west()).isCollisionShapeFullBlock(level, blockPos.west())) {
							return this.blockPos.west();
						} else {
							if (!Scelidosaurus.this.level.getBlockState(blockPos.north().east()).isCollisionShapeFullBlock(level, blockPos.north().east())) {
								return this.blockPos.north().east();
							} else {
								if (!Scelidosaurus.this.level.getBlockState(blockPos.north().west()).isCollisionShapeFullBlock(level, blockPos.north().west())) {
									return this.blockPos.north().west();
								} else {
									if (!Scelidosaurus.this.level.getBlockState(blockPos.south().east()).isCollisionShapeFullBlock(level, blockPos.south().east())) {
										return this.blockPos.south().east();
									} else {
										if (!Scelidosaurus.this.level.getBlockState(blockPos.south().west()).isCollisionShapeFullBlock(level, blockPos.south().west())) {
											return this.blockPos.south().west();
										} else return blockPos.above();
									}
								}
							}
						}
					}
				}
			} 
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (this.isReachedTarget()) {
				if (this.field_220731_g >= 20) {
					this.eatBerry();
				} else {
					++this.field_220731_g;
					Scelidosaurus.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					Scelidosaurus.this.level.playSound((Player)null, this.blockPos, SoundEvents.GRASS_HIT, SoundSource.NEUTRAL, 1, 1);
				}
			}
			if (Scelidosaurus.this.getCurrentHunger() >= 13) {
				Scelidosaurus.this.setEating(false);
			}
			super.tick();
		}

		protected void eatBerry() {
			int missingHunger = Scelidosaurus.this.maxHunger - Scelidosaurus.this.getCurrentHunger();
			int hunger = Scelidosaurus.this.getCurrentHunger();
			FeederBlock block = (FeederBlock) Scelidosaurus.this.level.getBlockState(this.blockPos).getBlock();
			int foodContained = block.getFoodAmount(Scelidosaurus.this.level, this.blockPos);
			if (missingHunger <= foodContained) {
				block.setFoodAmount(foodContained - missingHunger, level, this.blockPos);
				Scelidosaurus.this.setHunger(Scelidosaurus.this.maxHunger);
				Scelidosaurus.this.setEating(false);
				System.out.println(foodContained);
			} else if (foodContained - missingHunger < 0) {
				block.setFoodAmount(0, level, this.blockPos);
				Scelidosaurus.this.setHunger(hunger + foodContained);
				Scelidosaurus.this.setEating(false);
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Scelidosaurus.this.isAsleep() && super.canUse() && Scelidosaurus.this.getCurrentHunger() < Scelidosaurus.this.getHalfHunger();
		}
		
		public void stop() {
			super.stop();
			Scelidosaurus.this.setEating(false);
		}

		public boolean canContinueToUse() {
			if (Scelidosaurus.this.getCurrentHunger() >= Scelidosaurus.this.maxHunger || Scelidosaurus.this.isAsleep()) {
				return false;
			} else return super.canContinueToUse();
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			this.field_220731_g = 0;
			super.start();
		}
	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.SCELIDOSAURUS_SPAWN_EGG.get());
	}

}
