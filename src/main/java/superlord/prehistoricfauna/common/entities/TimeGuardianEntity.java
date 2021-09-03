package superlord.prehistoricfauna.common.entities;

import java.util.EnumSet;
import java.util.Optional;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import superlord.prehistoricfauna.init.SoundInit;

public class TimeGuardianEntity extends MonsterEntity {
	private static final DataParameter<Boolean> ACTIVE = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> USE_BEAM = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> USE_REGULAR_ATTACK = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> CHARGING_BEAM = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> USING_BEAM = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Float> LASER_PITCH = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.FLOAT);
	private static final DataParameter<Float> LASER_YAW = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.FLOAT);
	private static final DataParameter<Float> PREV_LASER_PITCH = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.FLOAT);
	private static final DataParameter<Float> PREV_LASER_YAW = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.FLOAT);
	private static final DataParameter<Boolean> IS_SUMMONED = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> MELEE_TICK = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.VARINT);
	private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS));

	public float targetDistance;
	public float targetAngle;
	private float meleeProgress;
	private float prevMeleeProgress;

	public TimeGuardianEntity(EntityType<? extends MonsterEntity> type, World world) {
		super(type, world);
	}

	public boolean isSummoned() {
		return this.dataManager.get(IS_SUMMONED);
	}

	public void setSummoned(boolean isSummoned) {
		this.dataManager.set(IS_SUMMONED, isSummoned);
	}

	protected SoundEvent getAmbientSound() {
		return SoundInit.HENOS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.HENOS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.HENOS_DEATH;
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(1, new TimeGuardianEntity.BeamAttackAI(this));
		goalSelector.addGoal(0, new TimeGuardianEntity.MeleeAttackGoal(this, 1.0D, true));
		targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, 0, true, false, null));
		targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 0, true, false, null));
	}
	
	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 300.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 10.0D).createMutableAttribute(Attributes.FOLLOW_RANGE, 25.0D).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 50.0D);
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public void tick() {
		super.tick();
		prevMeleeProgress = meleeProgress;
		if (getAttackTarget() != null) {
			targetDistance = getDistance(getAttackTarget()) - getAttackTarget().getWidth() / 2f;
			targetAngle = (float) getAngleBetweenEntities(this, getAttackTarget());
		}
		if(getAttackTarget() != null && (!getAttackTarget().isAlive() || getAttackTarget().getHealth() <= 0)) setAttackTarget(null);
		if (!world.isRemote) {
			if (!isAIDisabled()) {
				if (isActive()) {
					if (getAttackTarget() == null) {
						setActive(false);
					}
				} else if (getAttackTarget() != null && targetDistance <= 30) {
					setActive(true);
				}
			}
		}
		if (!isActive()) {
			setMotion(0, getMotion().y, 0);
			rotationYaw = prevRotationYaw;
		}
		renderYawOffset = rotationYaw;
		if (!isActive() && !world.isRemote) heal(0.3f);
		if(this.dataManager.get(MELEE_TICK) > 0 && isUsingRegularAttack()){
			if(this.dataManager.get(MELEE_TICK) == 2 && this.getAttackTarget() != null && this.getDistance(this.getAttackTarget()) < this.getAttackTarget().getWidth() + this.getWidth() + 2.0F){
				this.getAttackTarget().attackEntityFrom(DamageSource.causeMobDamage(this), 2);
			}
			this.dataManager.set(MELEE_TICK, this.dataManager.get(MELEE_TICK) - 1);
			if(meleeProgress < 5F){
				meleeProgress++;
			}
		}else{
			if(meleeProgress > 0F){
				meleeProgress--;
			}
		}
	}

	@Override
	public boolean canBePushed() {
		return isActive();
	}

	@Override
	public boolean preventDespawn() {
		return true;
	}

	@Override
	protected void registerData() {
		super.registerData();
		getDataManager().register(ACTIVE, false);
		getDataManager().register(USE_BEAM, false);
		getDataManager().register(USE_REGULAR_ATTACK, false);
		getDataManager().register(CHARGING_BEAM, false);
		getDataManager().register(USING_BEAM, false);
		getDataManager().register(LASER_PITCH, (float) 0);
		getDataManager().register(LASER_YAW, (float) 0);
		getDataManager().register(PREV_LASER_PITCH, (float) 0);
		getDataManager().register(PREV_LASER_YAW, (float) 0);
		getDataManager().register(MELEE_TICK, 0);
		getDataManager().register(IS_SUMMONED, false);
	}	

	public boolean isUsingBeamAttack() {
		return getDataManager().get(USE_BEAM);
	}

	public void useBeam(boolean isUsingBeam) {
		getDataManager().set(USE_BEAM, isUsingBeam);
	}


	public boolean isUsingRegularAttack() {
		return getDataManager().get(USE_REGULAR_ATTACK);
	}

	public void useRegularAttack(boolean isUsingRegularAttack) {
		getDataManager().set(USE_REGULAR_ATTACK, isUsingRegularAttack);
	}

	public boolean isActive() {
		return getDataManager().get(ACTIVE);
	}

	public void setActive(boolean isActive) {
		getDataManager().set(ACTIVE, isActive);
	}

	public float getHealthRatio() {
		return this.getHealth() / this.getMaxHealth();
	}

	public float getLaserPitch() {
		return this.dataManager.get(LASER_PITCH);
	}

	private void setLaserPitch(float laserPitch) {
		this.dataManager.set(LASER_PITCH, laserPitch);
	}

	public float getLaserYaw() {
		return this.dataManager.get(LASER_YAW);
	}

	private void setLaserYaw(float laserYaw) {
		this.dataManager.set(LASER_YAW, laserYaw);
	}

	public float getPrevLaserPitch() {
		return this.dataManager.get(PREV_LASER_PITCH);
	}

	private void setPrevLaserPitch(float prevLaserPitch) {
		this.dataManager.set(PREV_LASER_PITCH, prevLaserPitch);
	}

	public float getPrevLaserYaw() {
		return this.dataManager.get(PREV_LASER_YAW);
	}

	private void setPrevLaserYaw(float prevLaserYaw) {
		this.dataManager.set(PREV_LASER_YAW, prevLaserYaw);
	}

	public boolean isUsingBeam() {
		return this.dataManager.get(USING_BEAM);
	}

	private void setUsingBeam(boolean isUsingBeam) {
		this.dataManager.set(USING_BEAM, isUsingBeam);
	}

	public boolean isChargingBeam() {
		return this.dataManager.get(CHARGING_BEAM);
	}

	private void setChargingBeam(boolean isChargingBeam) {
		this.dataManager.set(CHARGING_BEAM, isChargingBeam);
	}

	public float getMeleeProgress(float partialTick){
		return prevMeleeProgress + (meleeProgress - prevMeleeProgress) * partialTick;
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("active", isActive());
		compound.putBoolean("summoned", isSummoned());
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		setActive(compound.getBoolean("active"));
		setSummoned(compound.getBoolean("summoned"));
		if (this.hasCustomName()) {
			this.bossInfo.setName(this.getDisplayName());
		}
	}

	public void setCustomName(@Nullable ITextComponent name) {
		super.setCustomName(name);
		this.bossInfo.setName(this.getDisplayName());
	}

	@Override
	protected void updateAITasks() {
		super.updateAITasks();
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
	}

	public void addTrackingPlayer(ServerPlayerEntity player) {
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	public void removeTrackingPlayer(ServerPlayerEntity player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public boolean isNonBoss() {
		return false;
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		this.getDataManager().set(MELEE_TICK, 6);
		return true;
	}

	public double getAngleBetweenEntities(Entity first, Entity second) {
		return Math.atan2(second.getPosZ() - first.getPosZ(), second.getPosX() - first.getPosX()) * (180 / Math.PI) + 90;
	}

	public class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		TimeGuardianEntity timeGuardian;

		public MeleeAttackGoal(TimeGuardianEntity timeGuardian, double speedIn, boolean useLongMemory) {
			super(timeGuardian, speedIn, useLongMemory);
			this.timeGuardian = timeGuardian;
		}

		@Override
		public boolean shouldExecute() {
			if(timeGuardian.getHealth() >= (timeGuardian.getMaxHealth() / 2)) {
				return super.shouldExecute();
			} else if (timeGuardian.getHealth() <= (timeGuardian.getMaxHealth() / 2) && !timeGuardian.isUsingBeamAttack()) {
				if (timeGuardian.getAttackTarget() != null) {
					if (timeGuardian.getDistanceSq(timeGuardian.getAttackTarget()) <= 10D) {
						return super.shouldExecute();
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

		@Override
		public boolean shouldContinueExecuting() {
			if (timeGuardian.getHealth() <= (timeGuardian.getMaxHealth() / 2) && !timeGuardian.isUsingBeamAttack()) {
				if (timeGuardian.getAttackTarget() != null) {
					if (timeGuardian.getDistanceSq(timeGuardian.getAttackTarget()) <= 10D) {
						return super.shouldContinueExecuting();
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else if(timeGuardian.getHealth() > (timeGuardian.getMaxHealth() / 2)) {
				return super.shouldContinueExecuting();
			} else {
				return false;
			}
		}

		@Override
		public void startExecuting() {
			super.resetTask();
			timeGuardian.useRegularAttack(true);
		}

		@Override
		public void resetTask() {
			super.resetTask();
			timeGuardian.useRegularAttack(false);
		}

	}

	public static class BeamAttackAI extends Goal {
		private TimeGuardianEntity timeGuardian;
		private int tickCounter;
		private int attackTick = 300;

		public BeamAttackAI(TimeGuardianEntity timeGuardian) {
			this.timeGuardian = timeGuardian;
			this.setMutexFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
		}

		public static boolean canSeeEntity(Vector3d observer, Entity subject) {
			if (observer == null || subject == null) return false;
			AxisAlignedBB axisalignedbb = subject.getBoundingBox().grow(0.30000001192092896D);
			Vector3d subjectLocation = new Vector3d(subject.getPosX(), subject.getPosY() + subject.getEyeHeight(), subject.getPosZ());
			RayTraceResult traceToBlocks = subject.world.rayTraceBlocks(new RayTraceContext(observer, subjectLocation, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, subject));
			if (traceToBlocks.getType() != RayTraceResult.Type.MISS) subjectLocation = traceToBlocks.getHitVec();
			Optional<Vector3d> traceToEntity = axisalignedbb.rayTrace(observer, subjectLocation);
			return traceToEntity.isPresent();
		}

		@Override
		public boolean shouldExecute() {
			if (timeGuardian.getHealth() <= (timeGuardian.getMaxHealth() / 2) && !timeGuardian.isUsingRegularAttack()) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public boolean shouldContinueExecuting() {
			if (tickCounter > this.attackTick || !super.shouldContinueExecuting()) {
				this.timeGuardian.setChargingBeam(false);
				this.timeGuardian.setUsingBeam(false);
				return false;
			}
			return super.shouldContinueExecuting();
		}

		public void startExecuting() {
			this.tickCounter = -45;
			this.timeGuardian.setChargingBeam(true);
			this.timeGuardian.getNavigator().clearPath();
			this.timeGuardian.isAirBorne = true;
			this.timeGuardian.useBeam(true);
		}

		private float updateRotation(float currentAngle, float targetAngle, float maxChange) {
			float change = MathHelper.wrapDegrees(targetAngle - currentAngle);
			return MathHelper.wrapDegrees(currentAngle + timeGuardian.rand.nextFloat() * 1.5F - 0.75F + change / maxChange);
		}

		private void updateLaser() {
			if (this.timeGuardian.world != null) {
				if (timeGuardian.getAttackTarget() != null) {
					timeGuardian.setPrevLaserPitch(timeGuardian.getLaserPitch());
					timeGuardian.setPrevLaserYaw(timeGuardian.getLaserYaw());
					double targetX = timeGuardian.getAttackTarget().getPosX();
					double targetY = timeGuardian.getAttackTarget().getPosY() + timeGuardian.getAttackTarget().getHeight() / 2d;
					double targetZ = timeGuardian.getAttackTarget().getPosZ();
					double rot = timeGuardian.renderYawOffset * 0.01745329238474369D + (Math.PI / 2D);
					double lureX = Math.cos(rot) * (double) (timeGuardian.getWidth() + 1f) + timeGuardian.getPosX();
					double lureY = timeGuardian.getHeight() + 1f + timeGuardian.getPosY();
					double lureZ = Math.sin(rot) * (double) (timeGuardian.getWidth() + 1f) + timeGuardian.getPosZ();
					Vector3d lureVec = new Vector3d(lureX, lureY, lureZ);

					double d0 = targetX - lureX;
					double d1 = targetY - lureY;
					double d2 = targetZ - lureZ;
					double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
					float targetYaw = (float) (MathHelper.atan2(d2, d0) * (180D / Math.PI)) - 90.0F;
					float targetPitch = (float) (-(MathHelper.atan2(d1, d3) * (180D / Math.PI)));
					timeGuardian.setLaserPitch(this.updateRotation(timeGuardian.getLaserPitch(), targetPitch, 35f - this.timeGuardian.world.getDifficulty().getId() * 2f));
					timeGuardian.setLaserYaw(this.updateRotation(timeGuardian.getLaserYaw(), targetYaw, 20f - this.timeGuardian.world.getDifficulty().getId() * 2f));

					Vector3d laserAngle = Vector3d.fromPitchYaw(timeGuardian.getLaserPitch(), timeGuardian.getLaserYaw());
					double range = 30d;
					Vector3d hitVec = lureVec.add(laserAngle.scale(range));

					RayTraceResult trace = timeGuardian.world.rayTraceBlocks(new RayTraceContext(lureVec, hitVec, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, timeGuardian));
					if (trace.getType() != RayTraceResult.Type.MISS) {
						hitVec = trace.getHitVec();
					}

					float f = 1.0F;
					if (this.timeGuardian.world.getDifficulty() == Difficulty.HARD) {
						f += 2.0F;
					}

					LivingEntity base = null;
					for (LivingEntity entity : timeGuardian.world.getEntitiesWithinAABB(LivingEntity.class, timeGuardian.getBoundingBox().grow(30))) {
						AxisAlignedBB axisalignedbb = entity.getBoundingBox().grow(0.30000001192092896D);
						Optional<Vector3d> traceToEntity = axisalignedbb.rayTrace(lureVec, hitVec);
						if (traceToEntity.isPresent() && canSeeEntity(lureVec, entity) && entity != timeGuardian && (base == null || timeGuardian.getDistance(entity) < timeGuardian.getDistance(base)))
							base = entity;
					}

					if (base != null) {
						base.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this.timeGuardian, this.timeGuardian), f);
						base.attackEntityFrom(DamageSource.causeMobDamage(this.timeGuardian), (float) this.timeGuardian.getAttribute(Attributes.ATTACK_DAMAGE).getValue() / 2);
						((LivingEntity)base).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 140 * (int)f, 2));
						((LivingEntity)base).addPotionEffect(new EffectInstance(Effects.WEAKNESS, 140 * (int)f, 2));
					}
				}
			}
		}

		public void tick() {
			this.timeGuardian.getNavigator().clearPath();

			if (this.tickCounter == 0) {
				this.timeGuardian.setChargingBeam(false);
				this.timeGuardian.setUsingBeam(true);
				this.timeGuardian.playSound(SoundInit.HENOS_LASER, 1.0F, this.timeGuardian.getSoundPitch());
			} else if (this.tickCounter < attackTick) {
				this.updateLaser();
			}

			++this.tickCounter;
			super.tick();
		}

		@Override
		public void resetTask() {
			timeGuardian.useBeam(false);
		}

	}

}
