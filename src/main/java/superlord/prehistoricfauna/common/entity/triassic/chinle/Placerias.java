package superlord.prehistoricfauna.common.entity.triassic.chinle;

import java.util.Random;
import java.util.function.Predicate;

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
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.blocks.FeederBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Placerias extends DinosaurEntity {
	private int maxHunger = 50;
	private int warningSoundTicks;

	@SuppressWarnings("deprecation")
	public Placerias(EntityType<? extends Placerias> type, Level level) {
		super(type, level);
		super.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.PHLEBOPTERIS.get().asItem();
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Placerias.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Placerias.PanicGoal());
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(PFBlocks.PHLEBOPTERIS.get().asItem()), false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new Placerias.HurtByTargetGoal().setAlertOthers());
		this.targetSelector.addGoal(2, new Placerias.AttackPlayerGoal());
		this.goalSelector.addGoal(0, new Placerias.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Placerias.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Placerias.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dilophosaurus>(this, Dilophosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Tyrannosaurus>(this, Tyrannosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dakotaraptor>(this, Dakotaraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Allosaurus>(this, Allosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Ceratosaurus>(this, Ceratosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Camarasaurus>(this, Camarasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Saurosuchus>(this, Saurosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
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

	public void aiStep() {
		super.aiStep();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.22D);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.22D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.25D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.PLACERIAS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.PLACERIAS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.PLACERIAS_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.PLACERIAS_WARN, 1.0F, this.getVoicePitch());
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

	class AttackPlayerGoal extends NearestAttackableTargetGoal<Player> {
		public AttackPlayerGoal() {
			super(Placerias.this, Player.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean canUse() {
			if (Placerias.this.isBaby()) {
				return false;
			} else {
				if (super.canUse()) {
					for(Placerias placerias : Placerias.this.level.getEntitiesOfClass(Placerias.class, Placerias.this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
						if (placerias.isBaby()) {
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
			super(Placerias.this);
		}

		public void start() {
			super.start();
			if (Placerias.this.isBaby()) {
				this.alertOthers();
				this.stop();
			}
		}

		protected void alertOther(Mob mobIn, LivingEntity targetIn) {
			if (mobIn instanceof Placerias && !mobIn.isBaby()) {
				super.alertOther(mobIn, targetIn);
			}
		}
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Placerias.this, 1.25D, true);
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
					Placerias.this.playWarningSound();
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
			return (double)(6.0F + attackTarget.getBbWidth());
		}
	}

	class PanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(Placerias.this, 2.0D);
		}

		public boolean canUse() {
			return !Placerias.this.isBaby() && !Placerias.this.isOnFire() ? false : super.canUse();
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Placerias placerias;

		LayEggGoal(Placerias placerias, double speedIn) {
			super(placerias, speedIn, 16);
			this.placerias = placerias;
		}

		public boolean canUse() {
			return this.placerias.hasBaby() ? super.canUse() : false;
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.placerias.hasBaby();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.placerias.position());
			if (!this.placerias.isInWater() && this.isReachedTarget()) {
				if (this.placerias.isBirthing < 1) {
					this.placerias.setBirthing(true);
				} else if (this.placerias.isBirthing > 200) {
					Level level = this.placerias.level;
					level.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);
					level.setBlock(this.blockPos.above(), PFBlocks.PLACERIAS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.placerias.random.nextInt(4) + 1)), 3);
					this.placerias.setHasBaby(false);
					this.placerias.setBirthing(false);
					this.placerias.setInLoveTime(600);
				}
				if (this.placerias.isBirthing()) {
					this.placerias.isBirthing++;
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
		private final Placerias placerias;

		MateGoal(Placerias placerias, double speedIn) {
			super(placerias, speedIn);
			this.placerias = placerias;
		}

		public boolean canUse() {
			return super.canUse() && !this.placerias.hasBaby() && !this.placerias.isInLoveNaturally();
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

			this.placerias.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Placerias placerias;

		NaturalMateGoal(Placerias placerias, double speed) {
			super(placerias, speed);
			this.placerias = placerias;
		}

		public boolean canUse() {
			return super.canUse() && !this.placerias.hasBaby() && this.placerias.getCurrentHunger() >= this.placerias.getThreeQuartersHunger() && this.placerias.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.placerias.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.placerias.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.placerias.random.nextFloat() - this.placerias.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.placerias.random.nextInt(4);
				if (eggAmount == 0) {
					this.placerias.spawnAtLocation(PFBlocks.PLACERIAS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.placerias.spawnAtLocation(PFBlocks.PLACERIAS_EGG.get().asItem());
					this.placerias.spawnAtLocation(PFBlocks.PLACERIAS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.placerias.spawnAtLocation(PFBlocks.PLACERIAS_EGG.get().asItem());
					this.placerias.spawnAtLocation(PFBlocks.PLACERIAS_EGG.get().asItem());
					this.placerias.spawnAtLocation(PFBlocks.PLACERIAS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.placerias.spawnAtLocation(PFBlocks.PLACERIAS_EGG.get().asItem());
					this.placerias.spawnAtLocation(PFBlocks.PLACERIAS_EGG.get().asItem());
					this.placerias.spawnAtLocation(PFBlocks.PLACERIAS_EGG.get().asItem());
					this.placerias.spawnAtLocation(PFBlocks.PLACERIAS_EGG.get().asItem());
				}
			} else {
				this.placerias.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Placerias entity = new Placerias(PFEntities.PLACERIAS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}
	
	public class EatFromFeederGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public EatFromFeederGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Placerias.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
			if (!Placerias.this.level.getBlockState(blockPos.north()).isCollisionShapeFullBlock(level, blockPos.north())) {
				return this.blockPos.north();
			} else {
				if (!Placerias.this.level.getBlockState(blockPos.south()).isCollisionShapeFullBlock(level, blockPos.south())) {
					return this.blockPos.south();
				} else {
					if (!Placerias.this.level.getBlockState(blockPos.east()).isCollisionShapeFullBlock(level, blockPos.east())) {
						return this.blockPos.east();
					} else {
						if (!Placerias.this.level.getBlockState(blockPos.west()).isCollisionShapeFullBlock(level, blockPos.west())) {
							return this.blockPos.west();
						} else {
							if (!Placerias.this.level.getBlockState(blockPos.north().east()).isCollisionShapeFullBlock(level, blockPos.north().east())) {
								return this.blockPos.north().east();
							} else {
								if (!Placerias.this.level.getBlockState(blockPos.north().west()).isCollisionShapeFullBlock(level, blockPos.north().west())) {
									return this.blockPos.north().west();
								} else {
									if (!Placerias.this.level.getBlockState(blockPos.south().east()).isCollisionShapeFullBlock(level, blockPos.south().east())) {
										return this.blockPos.south().east();
									} else {
										if (!Placerias.this.level.getBlockState(blockPos.south().west()).isCollisionShapeFullBlock(level, blockPos.south().west())) {
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
					Placerias.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					Placerias.this.level.playSound((Player)null, this.blockPos, SoundEvents.GRASS_HIT, SoundSource.NEUTRAL, 1, 1);
				}
			}
			if (Placerias.this.getCurrentHunger() >= 13) {
				Placerias.this.setEating(false);
			}
			super.tick();
		}

		protected void eatBerry() {
			int missingHunger = Placerias.this.maxHunger - Placerias.this.getCurrentHunger();
			int hunger = Placerias.this.getCurrentHunger();
			FeederBlock block = (FeederBlock) Placerias.this.level.getBlockState(this.blockPos).getBlock();
			int foodContained = block.getFoodAmount(Placerias.this.level, this.blockPos);
			if (missingHunger <= foodContained) {
				block.setFoodAmount(foodContained - missingHunger, level, this.blockPos);
				Placerias.this.setHunger(Placerias.this.maxHunger);
				Placerias.this.setEating(false);
				System.out.println(foodContained);
			} else if (foodContained - missingHunger < 0) {
				block.setFoodAmount(0, level, this.blockPos);
				Placerias.this.setHunger(hunger + foodContained);
				Placerias.this.setEating(false);
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Placerias.this.isAsleep() && super.canUse() && Placerias.this.getCurrentHunger() < Placerias.this.getHalfHunger();
		}
		
		public void stop() {
			super.stop();
			Placerias.this.setEating(false);
		}

		public boolean canContinueToUse() {
			if (Placerias.this.getCurrentHunger() >= Placerias.this.maxHunger || Placerias.this.isAsleep()) {
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
		return new ItemStack(PFItems.PLACERIAS_SPAWN_EGG.get());
	}

}
