package superlord.prehistoricfauna.common.entity.jurassic.kayenta;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Pinacosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Plesiohadros;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
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
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

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
		this.goalSelector.addGoal(0, new BabyPanicGoal(this));
		this.goalSelector.addGoal(1, new Scelidosaurus.MeleeAttackGoal());
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
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
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
	}
	
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 80) {
			this.setProtective(true);
		} else if (temperment >= 80 && temperment < 95) {
			this.setTerritorial(true);
		} else if (temperment >= 95) {
			this.setPassive(true);
		}
		this.setHerbivorous(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
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
	
	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(7);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(15);
		}
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.isAsleep() || this.getWakingTicks() != 0) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.22D);
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

	@SuppressWarnings("rawtypes")
	class BipedalAvoidEntityGoal extends AvoidEntityGoal {

		@SuppressWarnings("unchecked")
		public BipedalAvoidEntityGoal(PathfinderMob entityIn, Class classToAvoidIn, float avoidDistanceIn, double farSpeedIn, double nearSpeedIn) {
			super(entityIn, classToAvoidIn, avoidDistanceIn, farSpeedIn, nearSpeedIn);
		}

		public void tick() {
			super.tick();
			Scelidosaurus.this.setBipedal(true);
			Scelidosaurus.this.setCrouchingTicks(0);
		}

		public void stop() {
			Scelidosaurus.this.setBipedal(false);
			Scelidosaurus.this.setCrouchingTicks(31);
			Scelidosaurus.this.setWakingTicks(0);
			super.stop();
		}

	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.SCELIDOSAURUS_SPAWN_EGG.get());
	}
	
	public Item getEggItem() {
		return PFItems.SCELIDOSAURUS_EGG.get();
	}
    
    public BlockState getEggBlock() {
    	return PFBlocks.SCELIDOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
    }

}
