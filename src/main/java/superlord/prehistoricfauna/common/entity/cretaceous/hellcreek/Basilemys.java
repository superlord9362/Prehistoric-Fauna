package superlord.prehistoricfauna.common.entity.cretaceous.hellcreek;

import java.util.Random;

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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.blocks.FeederBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Basilemys extends DinosaurEntity {

	private static final EntityDataAccessor<Boolean> IS_PANICING = SynchedEntityData.defineId(Basilemys.class, EntityDataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(PFBlocks.HORSETAIL.get().asItem());
	private int maxHunger = 20;

	@SuppressWarnings("deprecation")
	public Basilemys(EntityType<? extends Basilemys> type, Level level) {
		super(type, level);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	public boolean isPanicing() {
		return this.entityData.get(IS_PANICING);
	}

	private void setPanicing(boolean isPanicing) {
		this.entityData.set(IS_PANICING, isPanicing);
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.HORSETAIL.get().asItem();
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(IS_PANICING, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsPanicing", this.isPanicing());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setPanicing(compound.getBoolean("IsPanicing"));
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new Basilemys.PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(0, new Basilemys.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Basilemys.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Basilemys.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, TEMPTATION_ITEMS, false));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.BASILEMYS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.BASILEMYS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.BASILEMYS_DEATH;
	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
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
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);;
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1D);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.MOVEMENT_SPEED, 0.1D).add(Attributes.KNOCKBACK_RESISTANCE, 0.0D).add(Attributes.ARMOR, 2.0D).add(Attributes.ARMOR_TOUGHNESS, 2.0D);
	}

	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		super.handleEntityEvent(id);
	}

	class PanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		PanicGoal(Basilemys turtle, double speedIn) {
			super(turtle, speedIn);
		}

		public boolean canUse() {
			if (Basilemys.this.getLastHurtByMob() == null && !Basilemys.this.isOnFire()) {
				return false;
			} else {
				return true;
			}
		}

		public void start() {
			Basilemys.this.setPanicing(true);
			Basilemys.this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(100.0D);
			Basilemys.this.getAttribute(Attributes.ARMOR).setBaseValue(100.0D);
			Basilemys.this.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(100.0D);
		}

		public void stop() {
			Basilemys.this.setPanicing(false);
			Basilemys.this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(0D);
			Basilemys.this.getAttribute(Attributes.ARMOR).setBaseValue(0.0D);
			Basilemys.this.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(0.0D);
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Basilemys basilemys;

		LayEggGoal(Basilemys basilemys, double speedIn) {
			super(basilemys, speedIn, 16);
			this.basilemys = basilemys;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.basilemys.hasBaby() ? super.canUse() : false;
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.basilemys.hasBaby();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.basilemys.blockPosition());
			if (!this.basilemys.isInWater() && this.isReachedTarget()) {
				if (this.basilemys.isBirthing < 1) {
					this.basilemys.setBirthing(true);
				} else if (this.basilemys.isBirthing > 200) {
					Level level = this.basilemys.level;
					level.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);
					level.setBlock(this.blockPos.above(), PFBlocks.BASILEMYS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.basilemys.random.nextInt(4) + 1)), 3);
					this.basilemys.setHasBaby(false);
					this.basilemys.setBirthing(false);
					this.basilemys.setInLoveTime(600);
				}

				if (this.basilemys.isBirthing()) {
					this.basilemys.isBirthing++;
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
		private final Basilemys basilemys;

		MateGoal(Basilemys basilemys, double speed) {
			super(basilemys, speed);
			this.basilemys = basilemys;
		}

		public boolean canUse() {
			return super.canUse() && !this.basilemys.hasBaby() && !this.basilemys.isInLoveNaturally();
		}

		protected void breed() {
			ServerPlayer serverPlayerEntity = this.animal.getLoveCause();
			if (serverPlayerEntity == null && this.partner.getLoveCause() != null) {
				serverPlayerEntity = this.partner.getLoveCause();
			}
			if (serverPlayerEntity != null) {
				serverPlayerEntity.awardStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverPlayerEntity, this.animal, this.partner, (AgeableMob)null);
			}
			this.basilemys.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Basilemys basilemys;

		NaturalMateGoal(Basilemys basilemys, double speed) {
			super(basilemys, speed);
			this.basilemys = basilemys;
		}

		public boolean canUse() {
			return super.canUse() && !this.basilemys.hasBaby() && this.basilemys.getCurrentHunger() >= this.basilemys.getThreeQuartersHunger() && this.basilemys.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.basilemys.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.basilemys.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.basilemys.random.nextFloat() - this.basilemys.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.basilemys.random.nextInt(4);
				if (eggAmount == 0) {
					this.basilemys.spawnAtLocation(PFBlocks.BASILEMYS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.basilemys.spawnAtLocation(PFBlocks.BASILEMYS_EGG.get().asItem());
					this.basilemys.spawnAtLocation(PFBlocks.BASILEMYS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.basilemys.spawnAtLocation(PFBlocks.BASILEMYS_EGG.get().asItem());
					this.basilemys.spawnAtLocation(PFBlocks.BASILEMYS_EGG.get().asItem());
					this.basilemys.spawnAtLocation(PFBlocks.BASILEMYS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.basilemys.spawnAtLocation(PFBlocks.BASILEMYS_EGG.get().asItem());
					this.basilemys.spawnAtLocation(PFBlocks.BASILEMYS_EGG.get().asItem());
					this.basilemys.spawnAtLocation(PFBlocks.BASILEMYS_EGG.get().asItem());
					this.basilemys.spawnAtLocation(PFBlocks.BASILEMYS_EGG.get().asItem());
				}
			} else {
				this.basilemys.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Basilemys entity = new Basilemys(PFEntities.BASILEMYS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}
	
	public class EatFromFeederGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public EatFromFeederGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Basilemys.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
			if (!Basilemys.this.level.getBlockState(blockPos.north()).isCollisionShapeFullBlock(level, blockPos.north())) {
				return this.blockPos.north();
			} else {
				if (!Basilemys.this.level.getBlockState(blockPos.south()).isCollisionShapeFullBlock(level, blockPos.south())) {
					return this.blockPos.south();
				} else {
					if (!Basilemys.this.level.getBlockState(blockPos.east()).isCollisionShapeFullBlock(level, blockPos.east())) {
						return this.blockPos.east();
					} else {
						if (!Basilemys.this.level.getBlockState(blockPos.west()).isCollisionShapeFullBlock(level, blockPos.west())) {
							return this.blockPos.west();
						} else {
							if (!Basilemys.this.level.getBlockState(blockPos.north().east()).isCollisionShapeFullBlock(level, blockPos.north().east())) {
								return this.blockPos.north().east();
							} else {
								if (!Basilemys.this.level.getBlockState(blockPos.north().west()).isCollisionShapeFullBlock(level, blockPos.north().west())) {
									return this.blockPos.north().west();
								} else {
									if (!Basilemys.this.level.getBlockState(blockPos.south().east()).isCollisionShapeFullBlock(level, blockPos.south().east())) {
										return this.blockPos.south().east();
									} else {
										if (!Basilemys.this.level.getBlockState(blockPos.south().west()).isCollisionShapeFullBlock(level, blockPos.south().west())) {
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
					Basilemys.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					Basilemys.this.level.playSound((Player)null, this.blockPos, SoundEvents.GRASS_HIT, SoundSource.NEUTRAL, 1, 1);
				}
			}
			if (Basilemys.this.getCurrentHunger() >= 13) {
				Basilemys.this.setEating(false);
			}
			super.tick();
		}

		protected void eatBerry() {
			int missingHunger = Basilemys.this.maxHunger - Basilemys.this.getCurrentHunger();
			int hunger = Basilemys.this.getCurrentHunger();
			FeederBlock block = (FeederBlock) Basilemys.this.level.getBlockState(this.blockPos).getBlock();
			int foodContained = block.getFoodAmount(Basilemys.this.level, this.blockPos);
			if (missingHunger <= foodContained) {
				block.setFoodAmount(foodContained - missingHunger, level, this.blockPos);
				Basilemys.this.setHunger(Basilemys.this.maxHunger);
				Basilemys.this.setEating(false);
				System.out.println(foodContained);
			} else if (foodContained - missingHunger < 0) {
				block.setFoodAmount(0, level, this.blockPos);
				Basilemys.this.setHunger(hunger + foodContained);
				Basilemys.this.setEating(false);
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Basilemys.this.isAsleep() && super.canUse() && Basilemys.this.getCurrentHunger() < Basilemys.this.getHalfHunger();
		}
		
		public void stop() {
			super.stop();
			Basilemys.this.setEating(false);
		}

		public boolean canContinueToUse() {
			if (Basilemys.this.getCurrentHunger() >= Basilemys.this.maxHunger || Basilemys.this.isAsleep()) {
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
		return new ItemStack(PFItems.BASILEMYS_SPAWN_EGG.get());
	}
}