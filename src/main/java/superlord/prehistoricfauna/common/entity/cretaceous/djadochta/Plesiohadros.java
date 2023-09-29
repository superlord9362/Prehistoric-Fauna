package superlord.prehistoricfauna.common.entity.cretaceous.djadochta;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.HerdDinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Plesiohadros extends HerdDinosaurEntity {
	private static final EntityDataAccessor<Boolean> DEOXIDATED = SynchedEntityData.defineId(Plesiohadros.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SADDLED = SynchedEntityData.defineId(Plesiohadros.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> BOOST_TIME = SynchedEntityData.defineId(Plesiohadros.class, EntityDataSerializers.INT);
	private int maxHunger = 100;
	private int warningSoundTicks;
	public float ridingXZ;
	public float ridingY = 1F;

	@SuppressWarnings("deprecation")
	public Plesiohadros(EntityType<? extends Plesiohadros> type, Level worldIn) {
		super(type, worldIn);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Plesiohadros entity = new Plesiohadros(PFEntities.PLESIOHADROS.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	public void thunderHit(ServerLevel p_241841_1_, LightningBolt p_241841_2_) {
		super.thunderHit(p_241841_1_, p_241841_2_);
		this.setDeoxidated(true);
	}

	public boolean isSaddled() {
		return this.entityData.get(SADDLED);
	}

	private void setSaddled(boolean isSaddled) {
		this.entityData.set(SADDLED, isSaddled);
	}

	public boolean isDeoxidated() {
		return this.entityData.get(DEOXIDATED);
	}

	private void setDeoxidated(boolean isDeoxidated) {
		this.entityData.set(DEOXIDATED, isDeoxidated);
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.TROCHODENDROIDES_SAPLING.get().asItem();
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new Plesiohadros.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(3, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(3, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 8.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.5D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.PLESIOHADROS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.PLESIOHADROS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.PLESIOHADROS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		if (this.isBaby()) {
			if (!blockIn.getMaterial().isLiquid()) {
				BlockState blockstate = this.level.getBlockState(pos.above());
				SoundType soundtype = blockstate.is(Blocks.SNOW) ? blockstate.getSoundType(level, pos, this) : blockIn.getSoundType(level, pos, this);
				this.playSound(soundtype.getStepSound(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
		} else {
			this.playSound(SoundEvents.COW_STEP, 0.15F, 1F);
		}
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.PLESIOHADROS_WARNING, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DEOXIDATED, false);
		this.entityData.define(SADDLED, false);
		this.entityData.define(BOOST_TIME, 0);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsDeoxidated", this.isDeoxidated());
		compound.putBoolean("IsSaddled", this.isSaddled());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setDeoxidated(compound.getBoolean("IsDeoxidated"));
		this.setSaddled(compound.getBoolean("IsSaddled"));
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}
	
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) {
			this.setProtective(true);
		} else {
			this.setTerritorial(true);
		}
		this.setHerbivorous(blocksBuilding);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public void aiStep() {
		if (this.isBaby()) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);
		} else {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(40);
		}
		super.aiStep();
		int ticks = 0;
		if (this.isDeoxidated()) {
			ticks++;
			if (ticks == 12000) {
				ticks = 0;
				this.setDeoxidated(false);
			}
		}
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		}
	}

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
		}

		return flag;
	}	

	public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {
		ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
		Item item = itemstack.getItem();
		if (!this.isTame()) {
			if (item == PFBlocks.COBBANIA.get().asItem()) {
				if (!p_230254_1_.getAbilities().instabuild) {
					itemstack.shrink(1);
				}

				if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_230254_1_)) {
					this.tame(p_230254_1_);
					this.navigation.stop();
					this.setTarget((LivingEntity)null);
					this.setOrderedToSit(true);
					this.level.broadcastEntityEvent(this, (byte)7);
				} else {
					this.level.broadcastEntityEvent(this, (byte)6);
				}
				return InteractionResult.SUCCESS;
			}
		} 
		if (!this.isSaddled() && !this.isBaby() && this.isTame()) {
			if (item == Items.SADDLE) {
				if (!p_230254_1_.getAbilities().instabuild) {
					itemstack.shrink(1);
				}
				this.setSaddled(true);
				this.level.playSound(p_230254_1_, this.getX(), this.getY(), this.getZ(), SoundEvents.PIG_SADDLE, SoundSource.NEUTRAL, 0.5F, 1.0F);
				return InteractionResult.SUCCESS;
			}
		}
		if (this.isSaddled() && !this.isVehicle() && !this.isBaby()) {
			p_230254_1_.startRiding(this);
		}
		return super.mobInteract(p_230254_1_, p_230254_2_);
	}

	protected void dropEquipment() {
		super.dropEquipment();
		if (this.isSaddled()) {
			this.spawnAtLocation(Items.SADDLE);
		}
	}

	@SuppressWarnings("deprecation")
	public void travel(Vec3 travelVector) {
		if (this.isAlive()) {
			if (this.isVehicle() && this.canBeControlledByRider() && this.isSaddled()) {
				LivingEntity livingentity = (LivingEntity)this.getControllingPassenger();
	            this.setYRot(livingentity.getYRot());
	            this.yRotO = this.getYRot();
	            this.setXRot(livingentity.getXRot() * 0.5F);
	            this.setRot(this.getYRot(), this.getXRot());
	            this.yBodyRot = this.getYRot();
	            this.yHeadRot = this.yBodyRot;
				float f = livingentity.xxa * 0.5F;
				float f1 = livingentity.zza;
				this.maxUpStep = 1.0F;

				if (this.canBeControlledByRider()) {
					this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
					super.travel(new Vec3((double)f, travelVector.y, (double)f1));
				} else if (livingentity instanceof Player) {
					this.setDeltaMovement(Vec3.ZERO);
				}

				if (this.onGround) {
				}

				this.calculateEntityAnimation(this, false);
			} else {
				super.travel(travelVector);
			}
		}
	}

	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
	}

	public boolean canBeControlledByRider() {
		return this.getControllingPassenger() instanceof LivingEntity;
	}

	@Override
	public void positionRider(Entity passenger) {
		super.positionRider(passenger);

		float radius = ridingXZ * 0.7F * -3 + 0.5F;
		float angle = (0.01745329251F * this.yBodyRotO);
		double extraX = radius * Mth.sin((float) (Math.PI + angle));
		double extraZ = radius * Mth.cos(angle);
		double extraY;
		if (this.isInWater()) {
			extraY = ridingY * 3;
		} else {
			extraY = ridingY * 4.1F;
		}
		this.getRidingPlayer().setPos(this.getX() + extraX, this.getY() + extraY - 2.75F, this.getZ() + extraZ);
	}

	protected void func_230273_eI_() {
	}

	public Player getRidingPlayer() {
		if (this.getControllingPassenger() instanceof Player) {
			return (Player) getControllingPassenger();
		} else {
			return null;
		}
	}

	@Nullable
	private Vec3 func_234236_a_(Vec3 p_234236_1_, LivingEntity p_234236_2_) {
		double d0 = this.getX() + p_234236_1_.x;
		double d1 = this.getBoundingBox().minY;
		double d2 = this.getZ() + p_234236_1_.z;
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

		for(Pose pose : p_234236_2_.getDismountPoses()) {
			blockpos$mutable.set(d0, d1, d2);
			double d3 = this.getBoundingBox().maxY + 0.75D;

			while(true) {
				double d4 = this.level.getBlockFloorHeight(blockpos$mutable);
				if ((double)blockpos$mutable.getY() + d4 > d3) {
					break;
				}

				if (DismountHelper.isBlockFloorValid(d4)) {
					AABB axisalignedbb = p_234236_2_.getLocalBoundsForPose(pose);
					Vec3 vector3d = new Vec3(d0, (double)blockpos$mutable.getY() + d4, d2);
					if (DismountHelper.canDismountTo(this.level, p_234236_2_, axisalignedbb.move(vector3d))) {
						p_234236_2_.setPose(pose);
						return vector3d;
					}
				}

				blockpos$mutable.move(Direction.UP);
				if (!((double)blockpos$mutable.getY() < d3)) {
					break;
				}
			}
		}

		return null;
	}

	public Vec3 getDismountLocationForPassenger(LivingEntity living) {
		Vec3 vector3d = getCollisionHorizontalEscapeVector((double)this.getBbWidth(), (double)living.getBbWidth(), this.yRot + (living.getMainArm() == HumanoidArm.RIGHT ? 90.0F : -90.0F));
		Vec3 vector3d1 = this.func_234236_a_(vector3d, living);
		if (vector3d1 != null) {
			return vector3d1;
		} else {
			Vec3 vector3d2 = getCollisionHorizontalEscapeVector((double)this.getBbWidth(), (double)living.getBbWidth(), this.yRot + (living.getMainArm() == HumanoidArm.LEFT ? 90.0F : -90.0F));
			Vec3 vector3d3 = this.func_234236_a_(vector3d2, living);
			return vector3d3 != null ? vector3d3 : this.position();
		}
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Plesiohadros.this, 1.25D, true);
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
					Plesiohadros.this.playWarningSound();
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
			return (double)(8.0F + attackTarget.getBbWidth());
		}
	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.PLESIOHADROS_SPAWN_EGG.get());
	}
	
	public Item getEggItem() {
		return PFItems.PLESIOHADROS_EGG.get();
	}
    
    public BlockState getEggBlock() {
    	return PFBlocks.PLESIOHADROS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
    }

}