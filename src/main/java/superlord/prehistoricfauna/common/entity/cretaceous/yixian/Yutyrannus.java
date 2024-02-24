package superlord.prehistoricfauna.common.entity.cretaceous.yixian;

import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.NestAndEggsBlock;
import superlord.prehistoricfauna.common.entity.HuntingDinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.BabyCarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.HostileCarnivoreGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Yutyrannus extends HuntingDinosaurEntity {
	private int maxHunger = 150;
	private int warningSoundTicks;
	public int attackTick = 0;
	
	@SuppressWarnings("deprecation")
	public Yutyrannus(EntityType<? extends Yutyrannus> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}
	
	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_SMALL_MARGINOCEPHALIAN_MEAT.get(); 
		//To-Do: Large Raw Sauropodomorph
	}
	
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Yutyrannus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.targetSelector.addGoal(0, new HostileCarnivoreGoal(this, Player.class, false));
		this.targetSelector.addGoal(4, new HuntGoal(this, LivingEntity.class, 10, false, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.CERATOSAURUS_HUNTING);
		}));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<Camarasaurus>(this, Camarasaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<Tyrannosaurus>(this, Tyrannosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<Triceratops>(this, Triceratops.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<Ankylosaurus>(this, Ankylosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<Stegosaurus>(this, Stegosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(0, new CarnivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new YutyrannusCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.YUTYRANNUS_HUNTING);
		}));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.YUTYRANNUS_BABY_HUNTING);
		}));
	}
	
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) {
			this.setProtective(true);
		} else {
			this.setTerritorial(true);
		}
		this.setCarnivorous(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 60.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 10.0D);
	}
	
	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.YUTYRANNUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.YUTYRANNUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.YUTYRANNUS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState state) {
		if (this.isBaby()) {
			if (!state.getMaterial().isLiquid()) {
				BlockState blockstate = this.level.getBlockState(pos.above());
				SoundType soundtype = blockstate.is(Blocks.SNOW) ? blockstate.getSoundType(level, pos, this) : state.getSoundType(level, pos, this);
				this.playSound(soundtype.getStepSound(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
		} else {
			this.playSound(SoundEvents.COW_STEP, 0.15F, 1F);
		}
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.YUTYRANNUS_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
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
	
	public void aiStep() {
		super.aiStep();
		if (this.isHunting()) {
			for(Yutyrannus yutyrannus : this.level.getEntitiesOfClass(Yutyrannus.class, this.getBoundingBox().inflate(8.0D, 4.0D, 8.0D))) {
				if (!yutyrannus.isBaby()) yutyrannus.setHunting(true);
			}
		}
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Yutyrannus.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				Yutyrannus.this.playSound(PFSounds.YUTYRANNUS_BITE, 1.0F, Yutyrannus.this.getVoicePitch());
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}

				if (this.getTicksUntilNextAttack() <= 10) {
					Yutyrannus.this.playWarningSound();
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

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Yutyrannus entity = new Yutyrannus(PFEntities.YUTYRANNUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.YUTYRANNUS_SPAWN_EGG.get());
	}
	
	public Item getEggItem() {
		return PFItems.YUTYRANNUS_EGG.get();
	}
    
	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.YUTYRANNUS_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1)).setValue(NestAndEggsBlock.PLANT_LEVEL, Integer.valueOf(this.random.nextInt(3) + 1));
	}
	
	@SuppressWarnings("rawtypes")
	public class YutyrannusCarnivoreHuntGoal extends NearestAttackableTargetGoal {
		double huntSpeed;
		Predicate<LivingEntity> targetPredicate;
		Yutyrannus dinosaur;

		@SuppressWarnings("unchecked")
		public YutyrannusCarnivoreHuntGoal(Yutyrannus goalOwnerIn, Class<?> targetClassIn, int targetChanceIn, double huntSpeed, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
			this.huntSpeed = huntSpeed;
			this.targetPredicate = targetPredicate;
			this.dinosaur = goalOwnerIn;
		}

		public boolean canUse() {
			return super.canUse() && dinosaur.getCurrentHunger() <= dinosaur.getHalfHunger() && !dinosaur.isBaby() && PrehistoricFaunaConfig.advancedHunger == true && !targetPredicate.test(dinosaur) && !dinosaur.trusts(target.getUUID()) && !dinosaur.isOpportunist() || dinosaur.isHunting();
		}

		public boolean canContinueToUse() {
			return dinosaur.getCurrentHunger() < dinosaur.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			dinosaur.getNavigation().setSpeedModifier(huntSpeed);
			if (dinosaur.getTarget() != null) {
				LivingEntity target = dinosaur.getTarget();
				if (!target.is(null)) {
					if (target.getType().is(PFTags.ANIMALS_3_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 3 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 3);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_4_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 4 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 4);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_6_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 6 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 6);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_8_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 8 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 8);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_10_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 10 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 10);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_15_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 15 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 15);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_20_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 20 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 20);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_30_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 30 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 30);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_40_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 40 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 40);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_60_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 60 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 60);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_80_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 80 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 80);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_100_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 100 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 100);
							}
						}
					}
					if (target.getType().is(PFTags.ANIMALS_200_HUNGER)) {
						if (target.getHealth() == 0) {
							if (dinosaur.getCurrentHunger() + 200 >= dinosaur.maxHunger) {
								dinosaur.setHunger(dinosaur.maxHunger);
							} else {
								dinosaur.setHunger(dinosaur.currentHunger + 200);
							}
						}
					}
				} else stop();
			} else stop();
			super.tick();
		}

	}


}
