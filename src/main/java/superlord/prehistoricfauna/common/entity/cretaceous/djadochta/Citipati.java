package superlord.prehistoricfauna.common.entity.cretaceous.djadochta;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.OmnivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Citipati extends DinosaurEntity {
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(PFItems.RAW_SMALL_REPTILE_MEAT.get());
	private static final EntityDataAccessor<Boolean> SITTING = SynchedEntityData.defineId(Citipati.class, EntityDataSerializers.BOOLEAN);
	public int maxHunger = 38;
	private Goal attackAnimals;

	@SuppressWarnings("deprecation")
	public Citipati(EntityType<? extends Citipati> type, Level world) {
		super(type, world);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_SMALL_REPTILE_MEAT.get();
	}

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 0.95F;
		else return 1.9F;
	}

	public boolean isSitting() {
		return this.entityData.get(SITTING);
	}

	private void setSitting(boolean isSitting) {
		this.entityData.set(SITTING, isSitting);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.attackAnimals = new HuntGoal(this, LivingEntity.class, 10, false, false, (p_237491_0_) -> {
			return p_237491_0_.getType().is(PFTags.ANIMALS_3_HUNGER) || p_237491_0_.getType().is(PFTags.ANIMALS_4_HUNGER) || p_237491_0_.getType().is(PFTags.ANIMALS_6_HUNGER);
		});
		this.goalSelector.addGoal(1, new Citipati.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, TEMPTATION_ITEMS, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Player.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Allosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Ceratosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Stegosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Camarasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Tyrannosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Triceratops.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Ankylosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Dakotaraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Herrerasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Saurosuchus>(this, Saurosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new OmnivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.targetSelector.addGoal(0, new Citipati.CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_237491_0_) -> {
			return p_237491_0_.getType().is(PFTags.ANIMALS_3_HUNGER) || p_237491_0_.getType().is(PFTags.ANIMALS_4_HUNGER) || p_237491_0_.getType().is(PFTags.ANIMALS_6_HUNGER);
		}));
		this.goalSelector.addGoal(5, new Citipati.SitOnEggGoal((double)1.2F, 12, 2));
	}

	public void aiStep() {
		super.aiStep();
		if (this.isAsleep() || this.isSitting()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.26D);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, 0.26D).add(Attributes.FOLLOW_RANGE, 25.0D).add(Attributes.ATTACK_DAMAGE, 4.0D);
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, attackAnimals);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.CITIPATI_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.CITIPATI_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.CITIPATI_DEATH;
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SITTING, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setAttackGoals();
		this.setSitting(compound.getBoolean("IsSitting"));
	}

	public boolean onLivingFall(float distance, float damageMultiplier) {
		return false;
	}

	public boolean onAttackAnimationFinish(Entity entity) {
		boolean flag = super.onAttackAnimationFinish(entity);
		if (flag) {
			this.doEnchantDamageEffects(this, entity);
		}
		return flag;
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Citipati.this, 1.25D, true);
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
	
	public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {
		ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
		if (PrehistoricFaunaConfig.advancedHunger) {
			int hunger = this.getCurrentHunger();
			if (hunger < this.maxHunger) {
				if (this.isFood(itemstack) && (!this.isInLove() || !this.isInLoveNaturally())) {
					this.setInLove(p_230254_1_);
					itemstack.shrink(1);
				} else {
					if (itemstack.is(PFTags.PLANTS_2_HUNGER_ITEM) || itemstack.is(PFTags.MEATS_2_HUNGER)) {
						if (hunger + 2 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 2);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_4_HUNGER_ITEM) || itemstack.is(PFTags.MEATS_4_HUNGER)) {
						if (hunger + 4 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 4);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_6_HUNGER_ITEM) || itemstack.is(PFTags.MEATS_6_HUNGER)) {
						if (hunger + 6 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 6);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_8_HUNGER_ITEM) || itemstack.is(PFTags.MEATS_8_HUNGER)) {
						if (hunger + 8 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 8);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_10_HUNGER_ITEM) || itemstack.is(PFTags.MEATS_10_HUNGER)) {
						if (hunger + 10 >= this.maxHunger) {
							this.setHunger(this.maxHunger);
						} else {
							this.setHunger(hunger + 10);
						}
						itemstack.shrink(1);
					}
					if (itemstack.is(PFTags.PLANTS_12_HUNGER_ITEM) || itemstack.is(PFTags.MEATS_12_HUNGER)) {
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
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Citipati entity = new Citipati(PFEntities.CITIPATI.get(), this.level);
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
			return super.canUse() && Citipati.this.getCurrentHunger() <= Citipati.this.getHalfHunger() && Citipati.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(Citipati.this);
		}

		public boolean canContinueToUse() {
			return Citipati.this.getCurrentHunger() < Citipati.this.maxHunger || !Citipati.this.isBaby() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			Citipati.this.getNavigation().setSpeedModifier(huntSpeed);
			LivingEntity target = Citipati.this.getTarget();
			if (target.getType().is(PFTags.ANIMALS_3_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Citipati.this.getCurrentHunger() + 3 >= Citipati.this.maxHunger) {
						Citipati.this.setHunger(Citipati.this.maxHunger);
					} else {
						Citipati.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Citipati.this.getCurrentHunger() + 4 >= Citipati.this.maxHunger) {
						Citipati.this.setHunger(Citipati.this.maxHunger);
					} else {
						Citipati.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
				if (target.getHealth() == 0) {
					if (Citipati.this.getCurrentHunger() + 6 >= Citipati.this.maxHunger) {
						Citipati.this.setHunger(Citipati.this.maxHunger);
					} else {
						Citipati.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}

	class SitOnEggGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public SitOnEggGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Citipati.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
			Block egg = blockstate.getBlock();
			return egg instanceof DinosaurEggBlock && blockstate.getValue(DinosaurEggBlock.EGGS) >= 1;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (this.isReachedTarget()) {
				if (this.field_220731_g >= 40) {
					this.eatBerry();
				} else {
					++this.field_220731_g;
				}
			}
			if (Citipati.this.tickCount % 80 != 0) {
				this.stop();
			}
			super.tick();
		}

		public void stop() {
			super.stop();
			Citipati.this.setSitting(false);
		}

		protected void eatBerry() {
			if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(Citipati.this.level, Citipati.this)) {
				BlockState blockstate = Citipati.this.level.getBlockState(this.blockPos);
				level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, blockstate), blockPos.getX(), blockPos.getY(), blockPos.getZ(), 0.0D, 0.0D, 0.0D);
				Block egg = blockstate.getBlock();
				if (egg instanceof DinosaurEggBlock) {
					int eggs = blockstate.getValue(DinosaurEggBlock.EGGS);
					int hatch = blockstate.getValue(DinosaurEggBlock.HATCH);
					blockstate.setValue(DinosaurEggBlock.EGGS, Integer.valueOf(1));
					Citipati.this.level.setBlock(this.blockPos, blockstate.setValue(DinosaurEggBlock.EGGS, eggs).setValue(DinosaurEggBlock.HATCH, hatch).setValue(DinosaurEggBlock.CITIPATIFIED, true), 2);
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean canUse() {
			return !Citipati.this.isSleeping() && super.canUse() && Citipati.this.tickCount % 60 == 0;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void start() {
			this.field_220731_g = 0;
			super.start();
			Citipati.this.setSitting(true);
		}


		public boolean canContinueToUse() {
			return Citipati.this.tickCount % 80 != 0;
		}

	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.CITIPATI_SPAWN_EGG.get());
	}
	
	public Item getEggItem() {
		return PFItems.CITIPATI_EGG.get();
	}
    
    public BlockState getEggBlock() {
    	return PFBlocks.CITIPATI_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
    }

}
