package superlord.prehistoricfauna.common.entity.jurassic.kayenta;

import java.util.List;
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
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Citipati;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Pinacosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Plesiohadros;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Telmasaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Velociraptor;
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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Hesperornithoides;
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

public class Scutellosaurus extends DinosaurEntity {
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(PFBlocks.CLATHOPTERIS.get().asItem());
	private int maxHunger = 10;

	@SuppressWarnings("deprecation")
	public Scutellosaurus(EntityType<? extends Scutellosaurus> type, Level world) {
		super(type, world);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.CLATHOPTERIS.get().asItem();
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.25F;
		else return 0.5F;
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.10F));
		this.goalSelector.addGoal(0, new Scutellosaurus.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Scutellosaurus.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, TEMPTATION_ITEMS, false));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dilophosaurus>(this, Dilophosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Citipati>(this, Citipati.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Telmasaurus>(this, Telmasaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Velociraptor>(this, Velociraptor.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dakotaraptor>(this, Dakotaraptor.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Triceratops>(this, Triceratops.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Tyrannosaurus>(this, Tyrannosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Megapnosaurus>(this, Megapnosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Allosaurus>(this, Allosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Camarasaurus>(this, Camarasaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Ceratosaurus>(this, Ceratosaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Hesperornithoides>(this, Hesperornithoides.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Herrerasaurus>(this, Herrerasaurus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Ischigualastia>(this, Ischigualastia.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Saurosuchus>(this, Saurosuchus.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Player>(this, Player.class, 10, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Coelophysis>(this, Coelophysis.class, 10F, 1.7D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(0, new Scutellosaurus.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(8, new Scutellosaurus.FollowHerbivoreGoal(Ankylosaurus.class, this));
		this.goalSelector.addGoal(8, new Scutellosaurus.FollowHerbivoreGoal(Pinacosaurus.class, this));
		this.goalSelector.addGoal(8, new Scutellosaurus.FollowHerbivoreGoal(Plesiohadros.class, this));
		this.goalSelector.addGoal(8, new Scutellosaurus.FollowHerbivoreGoal(Stegosaurus.class, this));
		this.goalSelector.addGoal(8, new Scutellosaurus.FollowHerbivoreGoal(Sillosuchus.class, this));
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.SCUTELLOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.SCUTELLOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.SCUTELLOSAURUS_DEATH;
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
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.22D);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, 0.22D).add(Attributes.ARMOR, 3);
	}

	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		super.handleEntityEvent(id);
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final Scutellosaurus scutellosaurus;

		LayEggGoal(Scutellosaurus scutellosaurus, double speedIn) {
			super(scutellosaurus, speedIn, 16);
			this.scutellosaurus = scutellosaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return this.scutellosaurus.hasBaby() ? super.canUse() : false;
		}

		/**
		 * Returns whether an in-progress AIBase should continue executing
		 */
		public boolean canContinueToUse() {
			return super.canContinueToUse() && this.scutellosaurus.hasBaby();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.scutellosaurus.position());
			if (!this.scutellosaurus.isInWater() && this.isReachedTarget()) {
				if (this.scutellosaurus.isBirthing < 1) {
					this.scutellosaurus.setBirthing(true);
				} else if (this.scutellosaurus.isBirthing > 200) {
					Level world = this.scutellosaurus.level;
					world.playSound((Player)null, blockpos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + world.random.nextFloat() * 0.2F);
					world.setBlock(this.blockPos.above(), PFBlocks.SCUTELLOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.scutellosaurus.random.nextInt(4) + 1)), 3);
					this.scutellosaurus.setHasBaby(false);
					this.scutellosaurus.setBirthing(false);
					this.scutellosaurus.setInLoveTime(600);
				}

				if (this.scutellosaurus.isBirthing()) {
					this.scutellosaurus.isBirthing++;
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
		private final Scutellosaurus scutellosaurus;

		MateGoal(Scutellosaurus scutellosaurus, double speed) {
			super(scutellosaurus, speed);
			this.scutellosaurus = scutellosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.scutellosaurus.hasBaby() && !this.scutellosaurus.isInLoveNaturally();
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
			this.scutellosaurus.setHasBaby(true);
			this.animal.resetLove();
			this.partner.resetLove();
			Random random = this.animal.getRandom();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
				this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), random.nextInt(7) + 1));
			}
		}

	}

	static class NaturalMateGoal extends BreedGoal {
		private final Scutellosaurus scutellosaurus;

		NaturalMateGoal(Scutellosaurus scutellosaurus, double speed) {
			super(scutellosaurus, speed);
			this.scutellosaurus = scutellosaurus;
		}

		public boolean canUse() {
			return super.canUse() && !this.scutellosaurus.hasBaby() && this.scutellosaurus.getCurrentHunger() >= this.scutellosaurus.getThreeQuartersHunger() && this.scutellosaurus.tickCount % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.scutellosaurus.isInLoveNaturally();
		}

		protected void breed() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.scutellosaurus.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.scutellosaurus.random.nextFloat() - this.scutellosaurus.random.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.scutellosaurus.random.nextInt(4);
				if (eggAmount == 0) {
					this.scutellosaurus.spawnAtLocation(PFBlocks.SCUTELLOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 1) {
					this.scutellosaurus.spawnAtLocation(PFBlocks.SCUTELLOSAURUS_EGG.get().asItem());
					this.scutellosaurus.spawnAtLocation(PFBlocks.SCUTELLOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 2) {
					this.scutellosaurus.spawnAtLocation(PFBlocks.SCUTELLOSAURUS_EGG.get().asItem());
					this.scutellosaurus.spawnAtLocation(PFBlocks.SCUTELLOSAURUS_EGG.get().asItem());
					this.scutellosaurus.spawnAtLocation(PFBlocks.SCUTELLOSAURUS_EGG.get().asItem());
				}
				if (eggAmount == 3) {
					this.scutellosaurus.spawnAtLocation(PFBlocks.SCUTELLOSAURUS_EGG.get().asItem());
					this.scutellosaurus.spawnAtLocation(PFBlocks.SCUTELLOSAURUS_EGG.get().asItem());
					this.scutellosaurus.spawnAtLocation(PFBlocks.SCUTELLOSAURUS_EGG.get().asItem());
					this.scutellosaurus.spawnAtLocation(PFBlocks.SCUTELLOSAURUS_EGG.get().asItem());
				}
			} else {
				this.scutellosaurus.setHasBaby(true);
			}
			this.animal.resetLove();
			this.partner.resetLove();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Scutellosaurus entity = new Scutellosaurus(PFEntities.SCUTELLOSAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	public class FollowHerbivoreGoal extends Goal {
		private final Class<? extends DinosaurEntity> followCreature;
		private final Scutellosaurus scutellosaurus;

		public FollowHerbivoreGoal(Class<? extends DinosaurEntity> followCreature, Scutellosaurus scutellosaurus) {
			this.followCreature = followCreature;
			this.scutellosaurus = scutellosaurus;
		}


		public boolean canUse() {
			List<DinosaurEntity> list = this.scutellosaurus.level.getEntitiesOfClass(DinosaurEntity.class, this.scutellosaurus.getBoundingBox().inflate(10.0D));
			boolean flag = false;
			for (DinosaurEntity dinosaur : list) {
				if (dinosaur.getClass() == this.followCreature) {
					if (dinosaur.getBbWidth() >= 1.5F) {
						flag = true;
						break;
					}
				}
			}
			return flag;
		}

		public boolean isPreemptible() {
			return true;
		}

		public boolean canContinueToUse() {
			return scutellosaurus.getLastHurtByMob() != null;
		}

		public void startExecuting() {

		}

		public void tick() {
			List<DinosaurEntity> list = this.scutellosaurus.level.getEntitiesOfClass(DinosaurEntity.class, this.scutellosaurus.getBoundingBox().inflate(10.0D));
			for (DinosaurEntity dinosaur : list) {
				this.scutellosaurus.getNavigation().moveTo(dinosaur, 1.0D);
			}
		}

	}
	
	public class EatFromFeederGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public EatFromFeederGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Scutellosaurus.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
			if (!Scutellosaurus.this.level.getBlockState(blockPos.north()).isCollisionShapeFullBlock(level, blockPos.north())) {
				return this.blockPos.north();
			} else {
				if (!Scutellosaurus.this.level.getBlockState(blockPos.south()).isCollisionShapeFullBlock(level, blockPos.south())) {
					return this.blockPos.south();
				} else {
					if (!Scutellosaurus.this.level.getBlockState(blockPos.east()).isCollisionShapeFullBlock(level, blockPos.east())) {
						return this.blockPos.east();
					} else {
						if (!Scutellosaurus.this.level.getBlockState(blockPos.west()).isCollisionShapeFullBlock(level, blockPos.west())) {
							return this.blockPos.west();
						} else {
							if (!Scutellosaurus.this.level.getBlockState(blockPos.north().east()).isCollisionShapeFullBlock(level, blockPos.north().east())) {
								return this.blockPos.north().east();
							} else {
								if (!Scutellosaurus.this.level.getBlockState(blockPos.north().west()).isCollisionShapeFullBlock(level, blockPos.north().west())) {
									return this.blockPos.north().west();
								} else {
									if (!Scutellosaurus.this.level.getBlockState(blockPos.south().east()).isCollisionShapeFullBlock(level, blockPos.south().east())) {
										return this.blockPos.south().east();
									} else {
										if (!Scutellosaurus.this.level.getBlockState(blockPos.south().west()).isCollisionShapeFullBlock(level, blockPos.south().west())) {
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
					Scutellosaurus.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					Scutellosaurus.this.level.playSound((Player)null, this.blockPos, SoundEvents.GRASS_HIT, SoundSource.NEUTRAL, 1, 1);
				}
			}
			if (Scutellosaurus.this.getCurrentHunger() >= 13) {
				Scutellosaurus.this.setEating(false);
			}
			super.tick();
		}

		protected void eatBerry() {
			int missingHunger = Scutellosaurus.this.maxHunger - Scutellosaurus.this.getCurrentHunger();
			int hunger = Scutellosaurus.this.getCurrentHunger();
			FeederBlock block = (FeederBlock) Scutellosaurus.this.level.getBlockState(this.blockPos).getBlock();
			int foodContained = block.getFoodAmount(Scutellosaurus.this.level, this.blockPos);
			if (missingHunger <= foodContained) {
				block.setFoodAmount(foodContained - missingHunger, level, this.blockPos);
				Scutellosaurus.this.setHunger(Scutellosaurus.this.maxHunger);
				Scutellosaurus.this.setEating(false);
				System.out.println(foodContained);
			} else if (foodContained - missingHunger < 0) {
				block.setFoodAmount(0, level, this.blockPos);
				Scutellosaurus.this.setHunger(hunger + foodContained);
				Scutellosaurus.this.setEating(false);
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Scutellosaurus.this.isAsleep() && super.canUse() && Scutellosaurus.this.getCurrentHunger() < Scutellosaurus.this.getHalfHunger();
		}
		
		public void stop() {
			super.stop();
			Scutellosaurus.this.setEating(false);
		}

		public boolean canContinueToUse() {
			if (Scutellosaurus.this.getCurrentHunger() >= Scutellosaurus.this.maxHunger || Scutellosaurus.this.isAsleep()) {
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
		return new ItemStack(PFItems.SCUTELLOSAURUS_SPAWN_EGG.get());
	}

}
