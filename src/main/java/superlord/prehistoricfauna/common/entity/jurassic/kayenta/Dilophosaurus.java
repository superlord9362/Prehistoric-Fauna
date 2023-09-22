package superlord.prehistoricfauna.common.entity.jurassic.kayenta;

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
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.BabyCarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreHuntGoal;
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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Sillosuchus;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Dilophosaurus extends DinosaurEntity {
	private int maxHunger = 75;
	private int warningSoundTicks;
	private Goal attackAnimals;

	@SuppressWarnings("deprecation")
	public Dilophosaurus(EntityType<? extends Dilophosaurus> type, Level worldIn) {
		super(type, worldIn);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 1.1F;
		else return 2.2F;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_SMALL_SAUROPOD_MEAT.get();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.attackAnimals = new HuntGoal(this, LivingEntity.class, 10, false, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.DILOPHOSAURUS_HUNTING);
		});
		this.goalSelector.addGoal(1, new Dilophosaurus.MeleeAttackGoal());
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
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Allosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Stegosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Camarasaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Triceratops.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Ankylosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Tyrannosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Sillosuchus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(0, new CarnivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.targetSelector.addGoal(0, new HostileCarnivoreGoal(this, Player.class, false));
		this.goalSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.DILOPHOSAURUS_HUNTING);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.DILOPHOSAURUS_BABY_HUNTING);
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

	public void aiStep() {
		if (this.isBaby()) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(3);
		} else {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(6);
		}
		super.aiStep();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 30.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 6.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.25D);
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, this.attackAnimals);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.DILOPHOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.DILOPHOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.DILOPHOSAURUS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(SoundEvents.COW_STEP, 0.15F, 1F);
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.DILOPHOSAURUS_WARN, 1.0F, this.getVoicePitch());
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

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Dilophosaurus.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				Dilophosaurus.this.playSound(PFSounds.DILOPHOSAURUS_BITE, 1.0F, Dilophosaurus.this.getVoicePitch());
				this.mob.doHurtTarget(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}

				if (this.getTicksUntilNextAttack() <= 10) {
					Dilophosaurus.this.playWarningSound();
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
		Dilophosaurus entity = new Dilophosaurus(PFEntities.DILOPHOSAURUS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.DILOPHOSAURUS_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.DILOPHOSAURUS_EGG.get();
	}

	public BlockState getEggBlock() {
		return PFBlocks.DILOPHOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}

}