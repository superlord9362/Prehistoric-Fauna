package superlord.prehistoricfauna.common.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
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
import net.minecraft.util.SoundEvents;
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
import superlord.prehistoricfauna.init.PFParticles;
import superlord.prehistoricfauna.init.SoundInit;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.Optional;

public class TimeGuardianEntity extends MonsterEntity {
	private static final DataParameter<Boolean> ACTIVE = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> USE_BEAM = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> USE_REGULAR_ATTACK = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> CHARGING_BEAM = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> USING_BEAM = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> LASER_TARGET_ENTITY = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Float> LASER_X = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.FLOAT);
	private static final DataParameter<Float> LASER_Y = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.FLOAT);
	private static final DataParameter<Float> LASER_Z = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.FLOAT);
	private static final DataParameter<Boolean> IS_SUMMONED = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> MELEE_TICK = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> LASER_TICK = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> SHIELD_LEVEL = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.VARINT);
	private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS);

	public float targetDistance;
	public float targetAngle;
	public float prevLaserX;
	public float prevLaserY;
	public float prevLaserZ;
	private float leftPunchProgress;
	private float prevLeftPunchProgress;
	private float rightPunchProgress;
	private float prevRightPunchProgress;
	private float laserProgress;
	private float prevLaserProgress;
	private boolean usingLeftHand;
	private int shieldCooldown = 0;

	public TimeGuardianEntity(EntityType<? extends MonsterEntity> type, World world) {
		super(type, world);
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 300.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 10.0D).createMutableAttribute(Attributes.FOLLOW_RANGE, 25.0D).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 50.0D);
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
		targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 0, true, false, null));
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public void tick() {
		super.tick();
		prevRightPunchProgress = rightPunchProgress;
		prevLeftPunchProgress = leftPunchProgress;
		prevLaserX = this.getLaserX();
		prevLaserY = this.getLaserY();
		prevLaserZ = this.getLaserZ();
		prevLaserProgress = laserProgress;
		if (laserProgress < 1.0F && this.isUsingBeamAttack() && !this.isUsingRegularAttack()) {
			laserProgress += 0.1F;
		}
		if (laserProgress > 0.0F && (!this.isUsingBeamAttack() || this.isUsingRegularAttack())) {
			laserProgress -= 0.1F;
		}
		if (getAttackTarget() != null) {
			targetDistance = getDistance(getAttackTarget()) - getAttackTarget().getWidth() / 2f;
			targetAngle = (float) getAngleBetweenEntities(this, getAttackTarget());
		}
		if (getAttackTarget() != null && (!getAttackTarget().isAlive() || getAttackTarget().getHealth() <= 0))
			setAttackTarget(null);
		if (!world.isRemote) {
			if (!isAIDisabled()) {
				if (isActive()) {
					if (getAttackTarget() == null) {
						setActive(false);
					}
				} else if (getAttackTarget() != null && targetDistance <= 30) {
					setActive(true);
				}
				if(this.getHealthRatio() < 0.5F && shieldCooldown == 0 && !this.hasHealingShield()){
					shieldCooldown = 300 + rand.nextInt(300);
					this.setHealingShield(3);
				}
			}
		}
		if (!isActive()) {
			setMotion(0, getMotion().y, 0);
			rotationYaw = prevRotationYaw;
		}
		renderYawOffset = rotationYaw;
		if (!world.isRemote && hasHealingShield()){
			if(this.getAttackTarget() == null){
				this.heal(0.3F);
			}else{
				double dist = this.getDistance(this.getAttackTarget());
				if(dist > 16.0F){
					this.heal(3F);
				}else{
					this.heal((float)MathHelper.clamp(dist * 0.085F, 0.2F, 3F));
				}
			}
		}
		if (this.dataManager.get(MELEE_TICK) > 0 && isUsingRegularAttack()) {
			if (Math.max(rightPunchProgress, leftPunchProgress) == 5 && this.getAttackTarget() != null && this.getDistance(this.getAttackTarget()) < this.getAttackTarget().getWidth() + this.getWidth() + 2.0F) {
				this.getAttackTarget().attackEntityFrom(DamageSource.causeMobDamage(this), 2);
			}
			this.dataManager.set(MELEE_TICK, this.dataManager.get(MELEE_TICK) - 1);
			if (this.dataManager.get(MELEE_TICK) == 0) {
				usingLeftHand = !usingLeftHand;
			}
			if (!usingLeftHand && rightPunchProgress < 5F) {
				rightPunchProgress += 2.5F;
			}
			if (usingLeftHand && leftPunchProgress < 5F) {
				leftPunchProgress += 2.5F;
			}
		} else {
			if (leftPunchProgress > 0F) {
				leftPunchProgress -= Math.min(0.5F, leftPunchProgress);
			}
			if (rightPunchProgress > 0F) {
				rightPunchProgress -= Math.min(0.5F, rightPunchProgress);
			}
		}
		if (usingLeftHand) {
			if (rightPunchProgress > 0F) {
				rightPunchProgress--;
			}
		} else {
			if (leftPunchProgress > 0F) {
				leftPunchProgress--;
			}
		}
		if (this.isUsingBeamAttack()) {
			double d0 = this.getLaserX() - this.getPosX();
			double d1 = this.getLaserY() - this.getPosYHeight(1);
			double d2 = this.getLaserZ() - this.getPosZ();
			double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
			d0 = d0 / d3;
			d1 = d1 / d3;
			d2 = d2 / d3;
			double d4 = this.rand.nextDouble();
			while (d4 < d3) {
				d4 += 3.0D - this.rand.nextDouble() * 2.5D;
				this.world.addParticle(PFParticles.BOSS_LASER, this.getPosX() + d0 * d4, this.getPosYEye() + d1 * d4, this.getPosZ() + d2 * d4, (rand.nextFloat() - 0.5F) * 0.1F, rand.nextFloat() * 0.2F, (rand.nextFloat() - 0.5F) * 0.1F);
			}
		}
		if(this.hasHealingShield() && world.isRemote){
            for(int i = 0; i < 2 + rand.nextInt(2); i++){
                this.world.addParticle(PFParticles.BOSS_HEAL, this.getPosXRandom(2.0D), this.getPosY(), this.getPosZRandom(2.0D), this.getPosX(), this.getPosYHeight(0.75F), this.getPosZ());
            }
        }
		if (this.getLaserTick() < 0) {
			this.setLaserTick(this.getLaserTick() + 1);
		}
		if(shieldCooldown > 0 && !this.hasHealingShield()){
            shieldCooldown--;
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
		getDataManager().register(LASER_X, (float) 0);
		getDataManager().register(LASER_Y, (float) 0);
		getDataManager().register(LASER_Z, (float) 0);
		getDataManager().register(MELEE_TICK, 0);
		getDataManager().register(LASER_TICK, 0);
		getDataManager().register(LASER_TARGET_ENTITY, -1);
		getDataManager().register(IS_SUMMONED, false);
        getDataManager().register(SHIELD_LEVEL, 0);
	}

	public boolean isUsingBeamAttack() {
		return getDataManager().get(USE_BEAM);
	}

	public void useBeam(boolean isUsingBeam) {
		getDataManager().set(USE_BEAM, isUsingBeam);
	}

	public boolean hasHealingShield() {
        return getShieldLevel() > 0;
    }


    public int getShieldLevel() {
        return getDataManager().get(SHIELD_LEVEL);
    }


    public void setHealingShield(int shield) {
        getDataManager().set(SHIELD_LEVEL, shield);
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

	public float getLaserX() {
		return this.dataManager.get(LASER_X);
	}

	public void setLaserX(float laser) {
		this.dataManager.set(LASER_X, laser);
	}

	public float getLaserY() {
		return this.dataManager.get(LASER_Y);
	}

	public void setLaserY(float laser) {
		this.dataManager.set(LASER_Y, laser);
	}

	public float getLaserZ() {
		return this.dataManager.get(LASER_Z);
	}

	public void setLaserZ(float laser) {
		this.dataManager.set(LASER_Z, laser);
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

	public float getMeleeProgress(boolean left, float partialTick) {
		if (left) {
			return prevLeftPunchProgress + (leftPunchProgress - prevLeftPunchProgress) * partialTick;
		} else {
			return prevRightPunchProgress + (rightPunchProgress - prevRightPunchProgress) * partialTick;
		}
	}

	public boolean hasLaserTarget() {
		return this.dataManager.get(LASER_TARGET_ENTITY) != -1;
	}

	private void setLaserEntity(@Nullable Entity entity) {
		this.dataManager.set(LASER_TARGET_ENTITY, entity == null ? -1 : entity.getEntityId());
	}

	@Nullable
	public Entity getLaserTarget() {
		if (!this.hasLaserTarget()) {
			return this.getAttackTarget();
		} else {
			return this.world.getEntityByID(this.dataManager.get(LASER_TARGET_ENTITY));
		}
	}

	public int getLaserTick() {
		return getDataManager().get(LASER_TICK);
	}

	public void setLaserTick(int tick) {
		getDataManager().set(LASER_TICK, tick);
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
		this.getDataManager().set(MELEE_TICK, 10);
		return true;
	}

	protected float determineNextStepDistance() {
		return this.distanceWalkedOnStepModified + 0.3F;
	}

	public double getAngleBetweenEntities(Entity first, Entity second) {
		return Math.atan2(second.getPosZ() - first.getPosZ(), second.getPosX() - first.getPosX()) * (180 / Math.PI) + 90;
	}

	public Vector3d getLaserTargetPos(float partialTicks) {
		float x = this.prevLaserX + (this.getLaserX() - this.prevLaserX) * partialTicks;
		float y = this.prevLaserY + (this.getLaserY() - this.prevLaserY) * partialTicks;
		float z = this.prevLaserZ + (this.getLaserZ() - this.prevLaserZ) * partialTicks;
		return new Vector3d(x, y, z);
	}

	public float getLaserTargetProgress(float partialTicks) {
		return this.prevLaserProgress + (this.laserProgress - this.prevLaserProgress) * partialTicks;
	}
	
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if(this.hasHealingShield()){
            float pitchMod = MathHelper.clamp(4 - this.getShieldLevel(), 1, 3);
            this.playSound(SoundEvents.ENTITY_GENERIC_BURN, this.getSoundVolume(), this.getSoundPitch() * pitchMod);
            this.setHealingShield(Math.max(0, this.getShieldLevel() - 1));
            return false;
        }else{
            return super.attackEntityFrom(source, amount);
        }
    }

    public float getShieldThickness() {
        switch(this.getShieldLevel()){
            case 1:
                return 0.15F;
            case 2:
                return 0.5F;
            case 3:
                return 1.0F;
            default:
                return 0.0F;
        }
    }

	public static class BeamAttackAI extends Goal {
		private static final int TIME = 40;
		private TimeGuardianEntity timeGuardian;
		private float laserYaw;
		private float laserPitch;
        private int laserSoundTick = 0;

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
			return timeGuardian.getHealth() <= (timeGuardian.getMaxHealth() / 2) && !timeGuardian.isUsingRegularAttack() && timeGuardian.getLaserTick() >= 0;
		}

		@Override
		public boolean shouldContinueExecuting() {
			if(timeGuardian.ticksExisted > 0 && timeGuardian.ticksExisted % 20 == 0 && !canSeeEntity(timeGuardian.getPositionVec(), timeGuardian.getAttackTarget())){
				this.timeGuardian.setChargingBeam(false);
				this.timeGuardian.setUsingBeam(false);
				this.timeGuardian.setLaserTick(-120);
				return false;
			}
			if (timeGuardian.getLaserTick() <= 0 || !super.shouldContinueExecuting()) {
				this.timeGuardian.setChargingBeam(false);
				this.timeGuardian.setUsingBeam(false);
				return false;
			}
			return super.shouldContinueExecuting();
		}

		public void startExecuting() {
            this.laserSoundTick = 0;
			this.timeGuardian.setChargingBeam(true);
			this.timeGuardian.setLaserEntity(timeGuardian.getAttackTarget());
			this.timeGuardian.getNavigator().clearPath();
			this.laserYaw = MathHelper.wrapDegrees(timeGuardian.rotationYaw);
			this.laserPitch = MathHelper.wrapDegrees(timeGuardian.rotationPitch + 90);
			this.timeGuardian.isAirBorne = true;
			this.timeGuardian.setLaserTick(TIME);
			timeGuardian.setLaserX((float) timeGuardian.getPosX());
			timeGuardian.setLaserY((float) timeGuardian.getPosY());
			timeGuardian.setLaserZ((float) timeGuardian.getPosZ());
			this.timeGuardian.useBeam(true);
		}

		@SuppressWarnings("unused")
		private float updateRotation(float currentAngle, float targetAngle, float maxChange) {
			float change = MathHelper.wrapDegrees(targetAngle - currentAngle);
			return MathHelper.wrapDegrees(currentAngle + timeGuardian.rand.nextFloat() * 1.5F - 0.75F + change / maxChange);
		}

		private void updateLaser() {
			if (this.timeGuardian.world != null) {
				if (timeGuardian.getAttackTarget() != null) {
					double targetX = timeGuardian.getAttackTarget().getPosX();
                    double targetY = timeGuardian.getAttackTarget().getPosY() + timeGuardian.getAttackTarget().getEyeHeight() * 0.5F;
					double targetZ = timeGuardian.getAttackTarget().getPosZ();
					double rot = timeGuardian.renderYawOffset * 0.01745329238474369D + (Math.PI / 2D);
					double lureX = Math.cos(rot) * (double) (timeGuardian.getWidth() + 1f) + timeGuardian.getPosX();
                    double lureY = timeGuardian.getPosYHeight(0.65F);
					double lureZ = Math.sin(rot) * (double) (timeGuardian.getWidth() + 1f) + timeGuardian.getPosZ();
					Vector3d lureVec = new Vector3d(lureX, lureY, lureZ);
					double d0 = targetX - lureX;
					double d1 = targetY - lureY;
					double d2 = targetZ - lureZ;
					double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
					float targetYaw = (float) (MathHelper.atan2(d2, d0) * (180D / Math.PI)) - 90.0F;
					float targetPitch = (float) (-(MathHelper.atan2(d1, d3) * (180D / Math.PI)));
					float laserProg = 1F - (MathHelper.clamp(timeGuardian.getLaserTick(), 0, TIME) / (float) TIME);
					float baseYaw = MathHelper.wrapDegrees(timeGuardian.rotationYaw);
                    float basePitch = MathHelper.wrapDegrees(timeGuardian.rotationPitch + 120);
					this.laserYaw = baseYaw + MathHelper.wrapDegrees(targetYaw - baseYaw) * laserProg;
					this.laserPitch = basePitch + (targetPitch - basePitch) * laserProg;

					Vector3d laserAngle = Vector3d.fromPitchYaw(laserPitch, laserYaw);
					double range = 30d;
					Vector3d hitVec = lureVec.add(laserAngle.scale(range));

					RayTraceResult trace = timeGuardian.world.rayTraceBlocks(new RayTraceContext(lureVec, hitVec, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, timeGuardian));
					if (trace.getType() != RayTraceResult.Type.MISS) {
						hitVec = trace.getHitVec();
					}
					timeGuardian.setLaserX((float) hitVec.x);
					timeGuardian.setLaserY((float) hitVec.y);
					timeGuardian.setLaserZ((float) hitVec.z);
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
						base.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 140 * (int) f, 2));
						base.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 140 * (int) f, 2));
					}
				}
			}
		}

		public void tick() {
			this.timeGuardian.getNavigator().clearPath();
			if (timeGuardian.getLaserTick() > 0) {
				timeGuardian.setLaserTick(timeGuardian.getLaserTick() - 1);
			}
			if (timeGuardian.getLaserTick() == 0) {
				this.timeGuardian.setChargingBeam(false);
				this.timeGuardian.setUsingBeam(true);
				this.timeGuardian.playSound(SoundInit.HENOS_LASER, 1.0F, this.timeGuardian.getSoundPitch());
			} else if (timeGuardian.getLaserTick() > 0) {
				this.updateLaser();
				if(laserSoundTick % 17 == 0){
                    this.timeGuardian.playSound(SoundInit.HENOS_LASER_LOOP, 1.0F, this.timeGuardian.getSoundPitch());
                }
                laserSoundTick++;
			}
			super.tick();
		}

		@Override
		public void resetTask() {
			timeGuardian.setLaserEntity(null);
			timeGuardian.setLaserTick(-50);
			timeGuardian.setLaserX((float) timeGuardian.getPosX());
			timeGuardian.setLaserY((float) timeGuardian.getPosY());
			timeGuardian.setLaserZ((float) timeGuardian.getPosZ());
			timeGuardian.useBeam(false);
		}

	}

	public class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		TimeGuardianEntity timeGuardian;

		public MeleeAttackGoal(TimeGuardianEntity timeGuardian, double speedIn, boolean useLongMemory) {
			super(timeGuardian, speedIn, useLongMemory);
			this.timeGuardian = timeGuardian;
		}

		@Override
		public boolean shouldExecute() {
			if (timeGuardian.getHealth() >= (timeGuardian.getMaxHealth() / 2) || timeGuardian.getLaserTick() < 0) {
				return super.shouldExecute();
			} else if (timeGuardian.getHealth() <= (timeGuardian.getMaxHealth() / 2) && !timeGuardian.isUsingBeamAttack()) {
				if (timeGuardian.getAttackTarget() != null) {
					if (timeGuardian.getDistanceSq(timeGuardian.getAttackTarget()) <= 14D) {
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

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return this.attacker.getWidth() * 3.0F * this.attacker.getWidth() * 3.0F + attackTarget.getWidth();
		}

		@Override
		public boolean shouldContinueExecuting() {
			if(timeGuardian.getLaserTick() < 0){
				return super.shouldContinueExecuting();
			}
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
			} else if (timeGuardian.getHealth() > (timeGuardian.getMaxHealth() / 2) || timeGuardian.getLaserTick() < 0) {
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

}
