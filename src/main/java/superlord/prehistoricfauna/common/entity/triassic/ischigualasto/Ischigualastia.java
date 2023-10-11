package superlord.prehistoricfauna.common.entity.triassic.ischigualasto;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
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
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
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
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Ischigualastia extends DinosaurEntity {

	private static final EntityDataAccessor<Boolean> SADDLED = SynchedEntityData.defineId(Ischigualastia.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> BOOST_TIME = SynchedEntityData.defineId(Ischigualastia.class, EntityDataSerializers.INT);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(PFBlocks.CLADOPHLEBIS.get().asItem());
	private int maxHunger = 100;
	private int warningSoundTicks;
	private boolean boosting;
	private int boostTime;
	public float ridingXZ;
	public float ridingY = 1;
	private int totalBoostTime;

	@SuppressWarnings("deprecation")
	public Ischigualastia(EntityType<? extends Ischigualastia> type, Level level) {
		super(type, level);
		super.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) {
			return 0.65F;
		} return 1.3F;
	}

	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
	}

	public boolean canBeControlledByRider() {
		Entity entity = this.getControllingPassenger();
		if (!(entity instanceof Player)) {
			return false;
		} else {
			Player playerentity = (Player)entity;
			return playerentity.getMainHandItem().getItem() == PFItems.CLADOPHLEBIS_STICK.get() || playerentity.getOffhandItem().getItem() == PFItems.CLADOPHLEBIS_STICK.get();
		}
	}

	@Override
	public void positionRider(Entity passenger) {
		super.positionRider(passenger);

		float radius = ridingXZ * 0.7F * -3;
		float angle = (0.01745329251F * this.yBodyRotO);
		double extraX = radius * Mth.sin((float) (Math.PI + angle));
		double extraZ = radius * Mth.cos(angle);
		double extraY = ridingY * 4;
		this.getRidingPlayer().setPos(this.getX() + extraX, this.getY() + extraY - 2.75F, this.getZ() + extraZ);
	}

	public Player getRidingPlayer() {
		if (this.getControllingPassenger() instanceof Player) {
			return (Player) getControllingPassenger();
		} else {
			return null;
		}
	}

	public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
		if (BOOST_TIME.equals(key) && this.level.isClientSide) {
			this.boosting = true;
			this.boostTime = 0;
			this.totalBoostTime = this.entityData.get(BOOST_TIME);
		}

		super.onSyncedDataUpdated(key);
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.CLADOPHLEBIS.get().asItem();
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Ischigualastia.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(PFItems.CLADOPHLEBIS_STICK.get()), false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, TEMPTATION_ITEMS, false));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dilophosaurus>(this, Dilophosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Tyrannosaurus>(this, Tyrannosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dakotaraptor>(this, Dakotaraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Allosaurus>(this, Allosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Ceratosaurus>(this, Ceratosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Camarasaurus>(this, Camarasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Saurosuchus>(this, Saurosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
	}
	
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) {
			this.setProtective(true);
		} else {
			this.setTerritorial(true);
		}
		this.setHerbivorous(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(15);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30);
		}
	}

	public void aiStep() {
		super.aiStep();
		if (this.isAsleep() || this.getWakingTicks() != 0) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.22D);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.MOVEMENT_SPEED, 0.22D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.ATTACK_DAMAGE, 7.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.25D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.ISCHIGUALASTIA_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.ISCHIGUALASTIA_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.ISCHIGUALASTIA_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.ISCHIGUALASTIA_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SADDLED, false);
		this.entityData.define(BOOST_TIME, 0);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("Saddle", this.getSaddled());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setSaddled(compound.getBoolean("Saddle"));
	}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (itemstack.getItem() == Items.NAME_TAG) {
			itemstack.interactLivingEntity(player, this, hand);
		} else if (this.getSaddled() && !this.isVehicle()) {
			if (!this.level.isClientSide) {
				player.startRiding(this);
			}
		} else if (this.isAlive() && !this.getSaddled() && !this.isBaby() && itemstack.getItem() == Items.SADDLE) {
			this.setSaddled(true);
			this.level.playSound(player, this.getX(), this.getY(), this.getZ(), SoundEvents.PIG_SADDLE, SoundSource.NEUTRAL, 0.5F, 1.0F);
			itemstack.shrink(1);
		}
		return super.mobInteract(player, hand);
	}

	protected void dropEquipment() {
		super.dropEquipment();
		if (this.getSaddled()) {
			this.spawnAtLocation(Items.SADDLE);
		}
	}

	public boolean getSaddled() {
		return this.entityData.get(SADDLED);
	}

	public void setSaddled(boolean saddled) {
		if (saddled) {
			this.entityData.set(SADDLED, true);
		} else {
			this.entityData.set(SADDLED, false);
		}
	}

	@SuppressWarnings("deprecation")
	public void travel(Vec3 positionIn) {
		if (this.isAlive()) {
			Entity entity = this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
			if (this.isVehicle() && this.canBeControlledByRider()) {
				this.setYRot(entity.getYRot());
				this.yRotO = this.getYRot();
				this.setXRot(entity.getXRot() * 0.5F);
				this.setRot(this.getYRot(), this.getXRot());
				this.yBodyRot = this.getYRot();
				this.yHeadRot = this.yBodyRot;
				this.maxUpStep = 1.0F;
				this.flyingSpeed = this.getSpeed() * 0.1F;
				if (this.boosting && this.boostTime++ > this.totalBoostTime) {
					this.boosting = false;
				}
				if (this.canBeControlledByRider()) {
					float f = (float)this.getAttribute(Attributes.MOVEMENT_SPEED).getValue() * 0.225F;
					if (this.boosting) {
						f += f * 1.15F * Mth.sin((float)this.boostTime / (float)this.totalBoostTime * (float)Math.PI);
					}
					this.setSpeed(f);
					super.travel(new Vec3(0.0D, 0.0D, 1.0D));
					this.lerpSteps = 0;
				} else {
					this.setDeltaMovement(Vec3.ZERO);
				}
				this.animationSpeedOld = this.animationSpeed;
				double d1 = this.getX() - this.xo;
				double d0 = this.getZ() - this.zo;
				float f1 = Mth.sqrt((float) (d1 * d1 + d0 * d0)) * 4.0F;
				if (f1 > 1.0F) {
					f1 = 1.0F;
				}
				this.animationSpeed += (f1 - this.animationSpeed) * 0.4F;
				this.animationPosition += this.animationSpeed;
			} else {
				this.maxUpStep = 0.5F;
				this.flyingSpeed = 0.02F;
				super.travel(positionIn);
			}
		}
	}

	public boolean boost() {
		if (this.boosting) {
			return false;
		} else {
			this.boosting = true;
			this.boostTime = 0;
			this.totalBoostTime = this.getRandom().nextInt(841) + 140;
			this.entityData.set(BOOST_TIME, this.totalBoostTime);
			return true;
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

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Ischigualastia.this, 1.25D, true);
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
					Ischigualastia.this.playWarningSound();
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

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Ischigualastia entity = new Ischigualastia(PFEntities.ISCHIGUALASTIA.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.ISCHIGUALASTIA_SPAWN_EGG.get());
	}
	
	public Item getEggItem() {
		return PFItems.ISCHIGUALASTIA_EGG.get();
	}
    
    public BlockState getEggBlock() {
    	return PFBlocks.ISCHIGUALASTIA_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
    }

}
