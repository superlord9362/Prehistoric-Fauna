package superlord.prehistoricfauna.common.entity.triassic.chinle;

import java.util.EnumSet;
import java.util.List;
import java.util.Random;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.blocks.FeederBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.NocturnalSleepGoal;
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

public class Typothorax extends DinosaurEntity {
	private int maxHunger = 25;

	@SuppressWarnings("deprecation")
	public Typothorax(EntityType<? extends TamableAnimal> type, Level levelIn) {
		super(type, levelIn);
		super.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isInWater()) {
			if (this.isBaby()) return 0.25F;
			else return 0.5F;
		} else {
			if (this.isBaby()) {
				return 0.225F;
			}
			else return 0.45F;
		}
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.HORSETAIL.get().asItem();
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.TYPOTHORAX_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.TYPOTHORAX_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.TYPOTHORAX_DEATH;
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(3, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(0, new Typothorax.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Typothorax.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Typothorax.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new NocturnalSleepGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(4, new Typothorax.DiggingGoal(this));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dilophosaurus>(this, Dilophosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Tyrannosaurus>(this, Tyrannosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dakotaraptor>(this, Dakotaraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Allosaurus>(this, Allosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Ceratosaurus>(this, Ceratosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Camarasaurus>(this, Camarasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Saurosuchus>(this, Saurosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
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
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.22D).add(Attributes.ARMOR, 4.0D).add(Attributes.ARMOR_TOUGHNESS, 4.0D);
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Typothorax typothorax;

		LayEggGoal(Typothorax typothorax, double speedIn) {
			super(typothorax, speedIn, 16);
			this.typothorax = typothorax;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.typothorax.hasBaby() ? super.canUse() : false;
		}

		/**
		 * Returns whether an in-progress AIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.typothorax.hasBaby();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.typothorax.position());
			if (!this.typothorax.isInWater() && this.isReachedTarget()) {
				if (this.typothorax.isBirthing < 1) {
					this.typothorax.setBirthing(true);
				} else if (this.typothorax.isBirthing > 200) {
					Level level = this.typothorax.level;
					level.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);
					level.setBlock(this.blockPos.above(), PFBlocks.TYPOTHORAX_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.typothorax.random.nextInt(4) + 1)), 3);
					this.typothorax.setHasBaby(false);
					this.typothorax.setBirthing(false);
					this.typothorax.setInLoveTime(600);
				}

				if (this.typothorax.isBirthing()) {
					this.typothorax.isBirthing++;
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
		private final Typothorax typothorax;

		MateGoal(Typothorax typothorax, double speedIn) {
			super(typothorax, speedIn);
			this.typothorax = typothorax;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return super.canUse() && !this.typothorax.hasBaby() && !this.typothorax.isInLoveNaturally();
		}

		/**
		 * Spawns a baby animal of the same type.
		 */
		protected void breed() {
			ServerPlayer serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.partner.getLoveCause() != null) {
				serverplayerentity = this.partner.getLoveCause();
			}

			if (serverplayerentity != null) {
				serverplayerentity.awardStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.partner, (AgeableMob)null);
			}

			this.typothorax.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}

		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final Typothorax typothorax;

		NaturalMateGoal(Typothorax typothorax, double speed) {
			super(typothorax, speed);
			this.typothorax = typothorax;
		}

		public boolean canUse() {
			return super.canUse() && !this.typothorax.hasBaby() && this.typothorax.getCurrentHunger() >= this.typothorax.getThreeQuartersHunger() && this.typothorax.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.typothorax.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.typothorax.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.typothorax.random.nextFloat() - this.typothorax.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.typothorax.random.nextInt(4);
				if (eggAmount == 0) {
					this.typothorax.spawnAtLocation(PFBlocks.TYPOTHORAX_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.typothorax.spawnAtLocation(PFBlocks.TYPOTHORAX_EGG.get().asItem());
					this.typothorax.spawnAtLocation(PFBlocks.TYPOTHORAX_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.typothorax.spawnAtLocation(PFBlocks.TYPOTHORAX_EGG.get().asItem());
					this.typothorax.spawnAtLocation(PFBlocks.TYPOTHORAX_EGG.get().asItem());
					this.typothorax.spawnAtLocation(PFBlocks.TYPOTHORAX_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.typothorax.spawnAtLocation(PFBlocks.TYPOTHORAX_EGG.get().asItem());
					this.typothorax.spawnAtLocation(PFBlocks.TYPOTHORAX_EGG.get().asItem());
					this.typothorax.spawnAtLocation(PFBlocks.TYPOTHORAX_EGG.get().asItem());
					this.typothorax.spawnAtLocation(PFBlocks.TYPOTHORAX_EGG.get().asItem());
				}
			} else {
				this.typothorax.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Typothorax entity = new Typothorax(PFEntities.TYPOTHORAX.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	static class DiggingGoal extends Goal {
		private static final ResourceLocation DIGGING_LOOT = new ResourceLocation(PrehistoricFauna.MOD_ID, "entities/typothorax_digging");

		private final Typothorax typothorax;
		private int diggingTimer;
		private int digTimer2;

		public DiggingGoal(Typothorax entity) {
			this.typothorax = entity;
			setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
		}

		@Override
		public boolean canUse() {
			if (!typothorax.isAsleep()) {
				if (digTimer2 > 0) {
					--digTimer2;
					return false;
				}
				if (typothorax.getRandom().nextInt(typothorax.isBaby() ? 100 : 1000) != 0) {
					return false;
				} else {
					BlockPos blockpos = typothorax.blockPosition();
					BlockState state = typothorax.level.getBlockState(blockpos);
					if (state.is(BlockTags.DIRT)) {
						return true;
					} else {
						return typothorax.level.getBlockState(blockpos.below()).is(BlockTags.DIRT);
					}
				}
			} else {
				return false;
			}
		}

		@Override
		public void start() {
			diggingTimer = 40;
			digTimer2 = 6000;
			typothorax.level.broadcastEntityEvent(typothorax, (byte) 10);
			typothorax.getNavigation().stop();
		}

		@Override
		public void stop() {
			diggingTimer = 0;
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
				BlockPos blockpos = typothorax.blockPosition();
				BlockPos blockpos1 = blockpos.below();
				if (typothorax.level.getBlockState(blockpos1).is(BlockTags.DIRT)) {
					BlockState state = typothorax.level.getBlockState(blockpos1);
					typothorax.level.levelEvent(2001, blockpos1, Block.getId(state));
					MinecraftServer server = typothorax.level.getServer();
					if (server != null) {
						List<ItemStack> items = server.getLootTables().get(DIGGING_LOOT).getRandomItems(new LootContext.Builder((ServerLevel) typothorax.level).withRandom(typothorax.getRandom()).create(LootContextParamSets.EMPTY));
						Containers.dropContents(typothorax.level, blockpos, NonNullList.of(ItemStack.EMPTY, items.toArray(new ItemStack[0])));
					}
				}
			}
		}

	}
	
	public class EatFromFeederGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public EatFromFeederGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Typothorax.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
			if (!Typothorax.this.level.getBlockState(blockPos.north()).isCollisionShapeFullBlock(level, blockPos.north())) {
				return this.blockPos.north();
			} else {
				if (!Typothorax.this.level.getBlockState(blockPos.south()).isCollisionShapeFullBlock(level, blockPos.south())) {
					return this.blockPos.south();
				} else {
					if (!Typothorax.this.level.getBlockState(blockPos.east()).isCollisionShapeFullBlock(level, blockPos.east())) {
						return this.blockPos.east();
					} else {
						if (!Typothorax.this.level.getBlockState(blockPos.west()).isCollisionShapeFullBlock(level, blockPos.west())) {
							return this.blockPos.west();
						} else {
							if (!Typothorax.this.level.getBlockState(blockPos.north().east()).isCollisionShapeFullBlock(level, blockPos.north().east())) {
								return this.blockPos.north().east();
							} else {
								if (!Typothorax.this.level.getBlockState(blockPos.north().west()).isCollisionShapeFullBlock(level, blockPos.north().west())) {
									return this.blockPos.north().west();
								} else {
									if (!Typothorax.this.level.getBlockState(blockPos.south().east()).isCollisionShapeFullBlock(level, blockPos.south().east())) {
										return this.blockPos.south().east();
									} else {
										if (!Typothorax.this.level.getBlockState(blockPos.south().west()).isCollisionShapeFullBlock(level, blockPos.south().west())) {
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
					Typothorax.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					Typothorax.this.level.playSound((Player)null, this.blockPos, SoundEvents.GRASS_HIT, SoundSource.NEUTRAL, 1, 1);
				}
			}
			if (Typothorax.this.getCurrentHunger() >= 13) {
				Typothorax.this.setEating(false);
			}
			super.tick();
		}

		protected void eatBerry() {
			int missingHunger = Typothorax.this.maxHunger - Typothorax.this.getCurrentHunger();
			int hunger = Typothorax.this.getCurrentHunger();
			FeederBlock block = (FeederBlock) Typothorax.this.level.getBlockState(this.blockPos).getBlock();
			int foodContained = block.getFoodAmount(Typothorax.this.level, this.blockPos);
			if (missingHunger <= foodContained) {
				block.setFoodAmount(foodContained - missingHunger, level, this.blockPos);
				Typothorax.this.setHunger(Typothorax.this.maxHunger);
				Typothorax.this.setEating(false);
				System.out.println(foodContained);
			} else if (foodContained - missingHunger < 0) {
				block.setFoodAmount(0, level, this.blockPos);
				Typothorax.this.setHunger(hunger + foodContained);
				Typothorax.this.setEating(false);
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Typothorax.this.isAsleep() && super.canUse() && Typothorax.this.getCurrentHunger() < Typothorax.this.getHalfHunger();
		}
		
		public void stop() {
			super.stop();
			Typothorax.this.setEating(false);
		}

		public boolean canContinueToUse() {
			if (Typothorax.this.getCurrentHunger() >= Typothorax.this.maxHunger || Typothorax.this.isAsleep()) {
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
		return new ItemStack(PFItems.TYPOTHORAX_SPAWN_EGG.get());
	}

}
