package superlord.prehistoricfauna.common.entity.jurassic.kayenta;

import java.util.Random;

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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.blocks.FeederBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Citipati;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Pinacosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Plesiohadros;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Velociraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.CrepuscularSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Coelophysis;
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

public class Kayentatherium extends DinosaurEntity {
	private int maxHunger = 15;
	private int warningSoundTicks;

	@SuppressWarnings("deprecation")
	public Kayentatherium(EntityType<? extends Kayentatherium> type, Level worldIn) {
		super(type, worldIn);
		this.moveControl = new Kayentatherium.MoveHelperController(this);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.HORSETAIL.get().asItem();
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.2D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<Player>(this, Player.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dilophosaurus>(this, Dilophosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Citipati>(this, Citipati.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Pinacosaurus>(this, Pinacosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Plesiohadros>(this, Plesiohadros.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Velociraptor>(this, Velociraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Ankylosaurus>(this, Ankylosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dakotaraptor>(this, Dakotaraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Triceratops>(this, Triceratops.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Tyrannosaurus>(this, Tyrannosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Megapnosaurus>(this, Megapnosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Allosaurus>(this, Allosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Camarasaurus>(this, Camarasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Ceratosaurus>(this, Ceratosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Stegosaurus>(this, Stegosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Herrerasaurus>(this, Herrerasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Ischigualastia>(this, Ischigualastia.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Saurosuchus>(this, Saurosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Sillosuchus>(this, Sillosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Coelophysis>(this, Coelophysis.class, 10F, 1.7D, 1.5D));
		this.goalSelector.addGoal(0, new Kayentatherium.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Kayentatherium.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Kayentatherium.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CrepuscularSleepGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
	}

	public int getMaxAir() {
		return 4800;
	}

	protected int determineNextAir(int currentAir) {
		return this.getMaxAir();
	}

	protected float getWaterSlowDown() {
		return 0.8F;
	}

	public void aiStep() {
		super.aiStep();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.23D).add(Attributes.FOLLOW_RANGE, 15);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.KAYENTATHERIUM_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.KAYENTATHERIUM_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.KAYENTATHERIUM_DEATH;
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

	static class LayEggGoal extends MoveToBlockGoal {
		private final Kayentatherium kayentatherium;

		LayEggGoal(Kayentatherium kayentatherium, double speedIn) {
			super(kayentatherium, speedIn, 16);
			this.kayentatherium = kayentatherium;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.kayentatherium.hasBaby() ? super.canUse() : false;
		}

		/**
		 * Returns whether an in-progress AIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.kayentatherium.hasBaby();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.kayentatherium.position());
			if (!this.kayentatherium.isInWater() && this.isReachedTarget()) {
				if (this.kayentatherium.isBirthing < 1) {
					this.kayentatherium.setBirthing(true);
				} else if (this.kayentatherium.isBirthing > 200) {
					Level world = this.kayentatherium.level;
					world.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
					world.setBlock(this.blockPos.above(), PFBlocks.KAYENTATHERIUM_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.kayentatherium.random.nextInt(4) + 1)), 3);
					this.kayentatherium.setHasBaby(false);
					this.kayentatherium.setBirthing(false);
					this.kayentatherium.setInLoveTime(600);
				}

				if (this.kayentatherium.isBirthing()) {
					this.kayentatherium.isBirthing++;
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
		private final Kayentatherium kayentatherium;

		MateGoal(Kayentatherium kayentatherium, double speed) {
			super(kayentatherium, speed);
			this.kayentatherium = kayentatherium;
		}

		public boolean canUse() {
			return super.canUse() && !this.kayentatherium.hasBaby() && !this.kayentatherium.isInLoveNaturally();
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
			this.kayentatherium.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}

	}

	static class NaturalMateGoal extends BreedGoal {
		private final Kayentatherium kayentatherium;

		NaturalMateGoal(Kayentatherium kayentatherium, double speed) {
			super(kayentatherium, speed);
			this.kayentatherium = kayentatherium;
		}

		public boolean canUse() {
			return super.canUse() && !this.kayentatherium.hasBaby() && this.kayentatherium.getCurrentHunger() >= this.kayentatherium.getThreeQuartersHunger() && this.kayentatherium.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.kayentatherium.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.kayentatherium.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.kayentatherium.random.nextFloat() - this.kayentatherium.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.kayentatherium.random.nextInt(4);
				if (eggAmount == 0) {
					this.kayentatherium.spawnAtLocation(PFBlocks.KAYENTATHERIUM_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.kayentatherium.spawnAtLocation(PFBlocks.KAYENTATHERIUM_EGG.get().asItem());
					this.kayentatherium.spawnAtLocation(PFBlocks.KAYENTATHERIUM_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.kayentatherium.spawnAtLocation(PFBlocks.KAYENTATHERIUM_EGG.get().asItem());
					this.kayentatherium.spawnAtLocation(PFBlocks.KAYENTATHERIUM_EGG.get().asItem());
					this.kayentatherium.spawnAtLocation(PFBlocks.KAYENTATHERIUM_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.kayentatherium.spawnAtLocation(PFBlocks.KAYENTATHERIUM_EGG.get().asItem());
					this.kayentatherium.spawnAtLocation(PFBlocks.KAYENTATHERIUM_EGG.get().asItem());
					this.kayentatherium.spawnAtLocation(PFBlocks.KAYENTATHERIUM_EGG.get().asItem());
					this.kayentatherium.spawnAtLocation(PFBlocks.KAYENTATHERIUM_EGG.get().asItem());
				}
			} else {
				this.kayentatherium.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Kayentatherium entity = new Kayentatherium(PFEntities.KAYENTATHERIUM.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}
	
	static class SwimGoal extends RandomSwimmingGoal {
		private final Kayentatherium kayentatherium;

		public SwimGoal(Kayentatherium kayentatherium) {
			super(kayentatherium, 1.0D, 40);
			this.kayentatherium = kayentatherium;
		}

		public boolean canUse() {
			return this.kayentatherium.func_212800_dy() && super.canUse();
		}
	}
	
	protected boolean func_212800_dy() {
		return true;
	}
	
	class WalkAndSwimPathNavigator extends WaterBoundPathNavigation {

		WalkAndSwimPathNavigator(Kayentatherium kayentatherium, Level world) {
			super(kayentatherium, world);
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
		private final Kayentatherium kayentatherium;

		MoveHelperController(Kayentatherium kayentatherium) {
			super(kayentatherium);
			this.kayentatherium = kayentatherium;
		}

		public void tick() {
			if (this.kayentatherium.isEyeInFluid(FluidTags.WATER)) {
				this.kayentatherium.setDeltaMovement(this.kayentatherium.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
			}
			if (this.operation == MoveControl.Operation.MOVE_TO && !this.kayentatherium.getNavigation().isDone()) {
				float f = (float)(this.speedModifier * this.kayentatherium.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.kayentatherium.setSpeed(Mth.lerp(0.125F, this.kayentatherium.getSpeed(), f));
				double d0 = this.wantedX - this.kayentatherium.getX();
				double d1 = this.wantedY - this.kayentatherium.getY();
				double d2 = this.wantedZ - this.kayentatherium.getZ();
				if (d1 != 0.0D) {
					double d3 = (double)Mth.sqrt((float) (d0 * d0 + d1 * d1 + d2 * d2));
					this.kayentatherium.setDeltaMovement(this.kayentatherium.getDeltaMovement().add(0.0D, (double)this.kayentatherium.getSpeed() * (d1 / d3) * 0.1D, 0.0D));
				}
				if (d0 != 0.0D || d2 != 0.0D) {
					float f1 = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
					this.kayentatherium.xRot = this.rotlerp(this.kayentatherium.xRot, f1, 90.0F);
					this.kayentatherium.xRotO = this.kayentatherium.xRot;
				}
			} else {
				this.kayentatherium.setSpeed(0.0F);
			}
		}

	}

	protected PathNavigation createNavigation(Level world) {
		return new Kayentatherium.WalkAndSwimPathNavigator(this, world);
	}
	
	public class EatFromFeederGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public EatFromFeederGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Kayentatherium.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
			if (!Kayentatherium.this.level.getBlockState(blockPos.north()).isCollisionShapeFullBlock(level, blockPos.north())) {
				return this.blockPos.north();
			} else {
				if (!Kayentatherium.this.level.getBlockState(blockPos.south()).isCollisionShapeFullBlock(level, blockPos.south())) {
					return this.blockPos.south();
				} else {
					if (!Kayentatherium.this.level.getBlockState(blockPos.east()).isCollisionShapeFullBlock(level, blockPos.east())) {
						return this.blockPos.east();
					} else {
						if (!Kayentatherium.this.level.getBlockState(blockPos.west()).isCollisionShapeFullBlock(level, blockPos.west())) {
							return this.blockPos.west();
						} else {
							if (!Kayentatherium.this.level.getBlockState(blockPos.north().east()).isCollisionShapeFullBlock(level, blockPos.north().east())) {
								return this.blockPos.north().east();
							} else {
								if (!Kayentatherium.this.level.getBlockState(blockPos.north().west()).isCollisionShapeFullBlock(level, blockPos.north().west())) {
									return this.blockPos.north().west();
								} else {
									if (!Kayentatherium.this.level.getBlockState(blockPos.south().east()).isCollisionShapeFullBlock(level, blockPos.south().east())) {
										return this.blockPos.south().east();
									} else {
										if (!Kayentatherium.this.level.getBlockState(blockPos.south().west()).isCollisionShapeFullBlock(level, blockPos.south().west())) {
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
					Kayentatherium.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					Kayentatherium.this.level.playSound((Player)null, this.blockPos, SoundEvents.GRASS_HIT, SoundSource.NEUTRAL, 1, 1);
				}
			}
			if (Kayentatherium.this.getCurrentHunger() >= 13) {
				Kayentatherium.this.setEating(false);
			}
			super.tick();
		}

		protected void eatBerry() {
			int missingHunger = Kayentatherium.this.maxHunger - Kayentatherium.this.getCurrentHunger();
			int hunger = Kayentatherium.this.getCurrentHunger();
			FeederBlock block = (FeederBlock) Kayentatherium.this.level.getBlockState(this.blockPos).getBlock();
			int foodContained = block.getFoodAmount(Kayentatherium.this.level, this.blockPos);
			if (missingHunger <= foodContained) {
				block.setFoodAmount(foodContained - missingHunger, level, this.blockPos);
				Kayentatherium.this.setHunger(Kayentatherium.this.maxHunger);
				Kayentatherium.this.setEating(false);
				System.out.println(foodContained);
			} else if (foodContained - missingHunger < 0) {
				block.setFoodAmount(0, level, this.blockPos);
				Kayentatherium.this.setHunger(hunger + foodContained);
				Kayentatherium.this.setEating(false);
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Kayentatherium.this.isAsleep() && super.canUse() && Kayentatherium.this.getCurrentHunger() < Kayentatherium.this.getHalfHunger();
		}
		
		public void stop() {
			super.stop();
			Kayentatherium.this.setEating(false);
		}

		public boolean canContinueToUse() {
			if (Kayentatherium.this.getCurrentHunger() >= Kayentatherium.this.maxHunger || Kayentatherium.this.isAsleep()) {
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
		return new ItemStack(PFItems.KAYENTATHERIUM_SPAWN_EGG.get());
	}

}
