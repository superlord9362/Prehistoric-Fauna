package superlord.prehistoricfauna.common.entity.henos;

import java.util.EnumSet;
import java.util.Optional;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFParticles;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Henos extends Animal {
	private static final EntityDataAccessor<Boolean> ACTIVE = SynchedEntityData.defineId(Henos.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> USE_BEAM = SynchedEntityData.defineId(Henos.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> USE_REGULAR_ATTACK = SynchedEntityData.defineId(Henos.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> CHARGING_BEAM = SynchedEntityData.defineId(Henos.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> USING_BEAM = SynchedEntityData.defineId(Henos.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> LASER_TARGET_ENTITY = SynchedEntityData.defineId(Henos.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Float> LASER_X = SynchedEntityData.defineId(Henos.class, EntityDataSerializers.FLOAT);
	private static final EntityDataAccessor<Float> LASER_Y = SynchedEntityData.defineId(Henos.class, EntityDataSerializers.FLOAT);
	private static final EntityDataAccessor<Float> LASER_Z = SynchedEntityData.defineId(Henos.class, EntityDataSerializers.FLOAT);
	private static final EntityDataAccessor<Boolean> IS_SUMMONED = SynchedEntityData.defineId(Henos.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> MELEE_TICK = SynchedEntityData.defineId(Henos.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> LASER_TICK = SynchedEntityData.defineId(Henos.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> SHIELD_LEVEL = SynchedEntityData.defineId(Henos.class, EntityDataSerializers.INT);
	private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.GREEN, BossEvent.BossBarOverlay.PROGRESS));
	public boolean inWall;
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

	public Henos(EntityType<? extends Henos> type, Level level) {
		super(type, level);
	}

	protected boolean isAffectedByFluids() {
		return false;
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 300.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 10.0D).add(Attributes.FOLLOW_RANGE, 25.0D).add(Attributes.KNOCKBACK_RESISTANCE, 50.0D);
	}

	public boolean isSummoned() {
		return this.entityData.get(IS_SUMMONED);
	}

	public void setSummoned(boolean isSummoned) {
		this.entityData.set(IS_SUMMONED, isSummoned);
	}

	protected SoundEvent getAmbientSound() {
		return PFSounds.HENOS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.HENOS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.HENOS_DEATH;
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(1, new Henos.BeamAttackAI(this));
		goalSelector.addGoal(0, new Henos.MeleeAttackGoal(this, 1.0D, true));
		targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, 0, true, false, null));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	private boolean checkWalls(AABB p_31140_) {
		int i = Mth.floor(p_31140_.minX);
		int j = Mth.floor(p_31140_.minY);
		int k = Mth.floor(p_31140_.minZ);
		int l = Mth.floor(p_31140_.maxX);
		int i1 = Mth.floor(p_31140_.maxY);
		int j1 = Mth.floor(p_31140_.maxZ);
		boolean flag = false;
		boolean flag1 = false;

		for(int k1 = i; k1 <= l; ++k1) {
			for(int l1 = j; l1 <= i1; ++l1) {
				for(int i2 = k; i2 <= j1; ++i2) {
					BlockPos blockpos = new BlockPos(k1, l1, i2);
					BlockState blockstate = this.level.getBlockState(blockpos);
					if (!blockstate.isAir() && blockstate.getMaterial() != Material.FIRE) {
						if (net.minecraftforge.common.ForgeHooks.canEntityDestroy(this.level, blockpos, this) && !blockstate.is(BlockTags.DRAGON_IMMUNE) && !blockstate.is(PFTags.HENOSTONE)) {
							flag1 = this.level.removeBlock(blockpos, false) || flag1;
						} else {
							flag = true;
						}
					}
				}
			}
		}

		if (flag1) {
			BlockPos blockpos1 = new BlockPos(i + this.random.nextInt(l - i + 1), j + this.random.nextInt(i1 - j + 1), k + this.random.nextInt(j1 - k + 1));
			this.level.levelEvent(2008, blockpos1, 0);
		}

		return flag;
	}

	public void aiStep() {

		if (!this.level.isClientSide) {
			this.inWall = this.checkWalls(this.getBoundingBox());
		}

		super.aiStep();
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
		if (getTarget() != null) {
			targetDistance = distanceTo(getTarget()) - getTarget().getBbWidth() / 2f;
			targetAngle = (float) getAngleBetweenEntities(this, getTarget());
		}
		if (getTarget() != null && (!getTarget().isAlive() || getTarget().getHealth() <= 0))
			setTarget(null);
		if (!level.isClientSide) {
			if (!isNoAi()) {
				if (isActive()) {
					if (getTarget() == null) {
						setActive(false);
					}
				} else if (getTarget() != null && targetDistance <= 30 || getTarget() != null && targetDistance <= 30) {
					setActive(true);
				}
				if(this.getHealthRatio() < 0.5F && shieldCooldown == 0 && !this.hasHealingShield()){
					shieldCooldown = 300 + random.nextInt(300);
					this.setHealingShield(3);
				}
			}
		}
		if (!isActive()) {
			setDeltaMovement(0, getDeltaMovement().y, 0);
			yRot = yRotO;
			if (this.getHealth() < this.getMaxHealth()) {
				this.setHealingShield(1);
			}
			if (this.getHealth() == this.getMaxHealth()) {
				this.setHealingShield(0);
			}
		}
		yBodyRot = yHeadRot;
		if (!level.isClientSide && hasHealingShield()){
			if(this.getTarget() == null){
				this.heal(0.3F);
			}else{
				double dist = this.distanceTo(this.getTarget());
				if(dist > 16.0F){
					this.heal(3F);
				}else{
					this.heal((float)Mth.clamp(dist * 0.085F, 0.2F, 3F));
				}
			}
		}
		if (this.entityData.get(MELEE_TICK) > 0 && isUsingRegularAttack()) {
			if (Math.max(rightPunchProgress, leftPunchProgress) == 5 && this.getTarget() != null && this.distanceTo(this.getTarget()) < this.getTarget().getBbWidth() + this.getBbWidth() + 2.0F) {
				this.getTarget().hurt(DamageSource.mobAttack(this), 2);
				if (this.getTarget().isBlocking()) {
					((Player)this.getTarget()).getCooldowns().addCooldown(Items.SHIELD, 100);
					((Player)this.getTarget()).stopUsingItem();
					this.level.broadcastEntityEvent(((Player)this.getTarget()), (byte)30);
				}
			}
			this.entityData.set(MELEE_TICK, this.entityData.get(MELEE_TICK) - 1);
			if (this.entityData.get(MELEE_TICK) == 0) {
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
			double d0 = this.getLaserX() - this.getX();
			double d1 = this.getLaserY() - this.getY(1);
			double d2 = this.getLaserZ() - this.getZ();
			double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
			d0 = d0 / d3;
			d1 = d1 / d3;
			d2 = d2 / d3;
			double d4 = this.random.nextDouble();
			while (d4 < d3) {
				d4 += 3.0D - this.random.nextDouble() * 2.5D;
				this.level.addParticle(PFParticles.BOSS_LASER, this.getX() + d0 * d4, this.getEyeY() + d1 * d4, this.getZ() + d2 * d4, (random.nextFloat() - 0.5F) * 0.1F, random.nextFloat() * 0.2F, (random.nextFloat() - 0.5F) * 0.1F);
			}
		}
		if(this.hasHealingShield() && level.isClientSide){
			for(int i = 0; i < 2 + random.nextInt(2); i++){
				this.level.addParticle(PFParticles.BOSS_HEAL, this.getRandomX(2.0D), this.getY(), this.getRandomZ(2.0D), this.getX(), this.getY(0.75F), this.getZ());
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
	public boolean isPushable() {
		return isActive();
	}

	@Override
	public boolean requiresCustomPersistence() {
		return true;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		getEntityData().define(ACTIVE, false);
		getEntityData().define(USE_BEAM, false);
		getEntityData().define(USE_REGULAR_ATTACK, false);
		getEntityData().define(CHARGING_BEAM, false);
		getEntityData().define(USING_BEAM, false);
		getEntityData().define(LASER_X, (float) 0);
		getEntityData().define(LASER_Y, (float) 0);
		getEntityData().define(LASER_Z, (float) 0);
		getEntityData().define(MELEE_TICK, 0);
		getEntityData().define(LASER_TICK, 0);
		getEntityData().define(LASER_TARGET_ENTITY, -1);
		getEntityData().define(IS_SUMMONED, false);
		getEntityData().define(SHIELD_LEVEL, 0);
	}

	public boolean isUsingBeamAttack() {
		return getEntityData().get(USE_BEAM);
	}

	public void useBeam(boolean isUsingBeam) {
		getEntityData().set(USE_BEAM, isUsingBeam);
	}

	public boolean hasHealingShield() {
		return getShieldLevel() > 0;
	}


	public int getShieldLevel() {
		return getEntityData().get(SHIELD_LEVEL);
	}

	public void setHealingShield(int shield) {
		getEntityData().set(SHIELD_LEVEL, shield);
	}

	public boolean isUsingRegularAttack() {
		return getEntityData().get(USE_REGULAR_ATTACK);
	}

	public void useRegularAttack(boolean isUsingRegularAttack) {
		getEntityData().set(USE_REGULAR_ATTACK, isUsingRegularAttack);
	}

	public boolean isActive() {
		return getEntityData().get(ACTIVE);
	}

	public void setActive(boolean isActive) {
		getEntityData().set(ACTIVE, isActive);
	}

	public float getHealthRatio() {
		return this.getHealth() / this.getMaxHealth();
	}

	public float getLaserX() {
		return this.entityData.get(LASER_X);
	}

	public void setLaserX(float laser) {
		this.entityData.set(LASER_X, laser);
	}

	public float getLaserY() {
		return this.entityData.get(LASER_Y);
	}

	public void setLaserY(float laser) {
		this.entityData.set(LASER_Y, laser);
	}

	public float getLaserZ() {
		return this.entityData.get(LASER_Z);
	}

	public void setLaserZ(float laser) {
		this.entityData.set(LASER_Z, laser);
	}

	public boolean isUsingBeam() {
		return this.entityData.get(USING_BEAM);
	}

	private void setUsingBeam(boolean isUsingBeam) {
		this.entityData.set(USING_BEAM, isUsingBeam);
	}

	public boolean isChargingBeam() {
		return this.entityData.get(CHARGING_BEAM);
	}

	private void setChargingBeam(boolean isChargingBeam) {
		this.entityData.set(CHARGING_BEAM, isChargingBeam);
	}

	public float getMeleeProgress(boolean left, float partialTick) {
		if (left) {
			return prevLeftPunchProgress + (leftPunchProgress - prevLeftPunchProgress) * partialTick;
		} else {
			return prevRightPunchProgress + (rightPunchProgress - prevRightPunchProgress) * partialTick;
		}
	}

	public boolean hasLaserTarget() {
		return this.entityData.get(LASER_TARGET_ENTITY) != -1;
	}

	private void setLaserEntity(@Nullable Entity entity) {
		this.entityData.set(LASER_TARGET_ENTITY, entity == null ? -1 : entity.getId());
	}

	@Nullable
	public LivingEntity getLaserTarget() {
		if (!this.hasLaserTarget()) {
			return this.getTarget();
		} else {
			return (LivingEntity)this.level.getEntity(this.entityData.get(LASER_TARGET_ENTITY));
		}
	}

	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(SoundEvents.COW_STEP, 0.15F, 1F);
	}

	public int getLaserTick() {
		return getEntityData().get(LASER_TICK);
	}

	public void setLaserTick(int tick) {
		getEntityData().set(LASER_TICK, tick);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("active", isActive());
		compound.putBoolean("summoned", isSummoned());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		setActive(compound.getBoolean("active"));
		setSummoned(compound.getBoolean("summoned"));
		if (this.hasCustomName()) {
			this.bossEvent.setName(this.getDisplayName());
		}
	}

	public void setCustomName(@Nullable Component name) {
		super.setCustomName(name);
		this.bossEvent.setName(this.getDisplayName());
	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
		this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
	}

	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossEvent.addPlayer(player);
	}

	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.bossEvent.removePlayer(player);
	}

	public boolean doHurtTarget(Entity entityIn) {
		this.getEntityData().set(MELEE_TICK, 10);
		return true;
	}

	protected float nextStep() {
		return this.moveDist + 0.3F;
	}

	public double getAngleBetweenEntities(Entity first, Entity second) {
		return Math.atan2(second.getZ() - first.getZ(), second.getX() - first.getX()) * (180 / Math.PI) + 90;
	}

	public Vec3 getLaserTargetPos(float partialTicks) {
		float x = this.prevLaserX + (this.getLaserX() - this.prevLaserX) * partialTicks;
		float y = this.prevLaserY + (this.getLaserY() - this.prevLaserY) * partialTicks;
		float z = this.prevLaserZ + (this.getLaserZ() - this.prevLaserZ) * partialTicks;
		return new Vec3(x, y, z);
	}

	public float getLaserTargetProgress(float partialTicks) {
		return this.prevLaserProgress + (this.laserProgress - this.prevLaserProgress) * partialTicks;
	}

	public boolean hurt(DamageSource source, float amount) {
		if(this.hasHealingShield()){
			float pitchMod = Mth.clamp(4 - this.getShieldLevel(), 1, 3);
			this.playSound(SoundEvents.GENERIC_BURN, this.getSoundVolume(), this.getVoicePitch() * pitchMod);
			this.setHealingShield(Math.max(0, this.getShieldLevel() - 1));
			return false;
		}else{
			return super.hurt(source, amount);
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
		private Henos henos;
		private float laserYaw;
		private float laserPitch;
		private int laserSoundTick = 0;

		public BeamAttackAI(Henos henos) {
			this.henos = henos;
			this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
		}

		public static boolean canSeeEntity(Vec3 observer, Entity subject) {
			if (observer == null || subject == null) return false;
			AABB axisalignedbb = subject.getBoundingBox().inflate(0.30000001192092896D);
			Vec3 subjectLocation = new Vec3(subject.getX(), subject.getY() + subject.getEyeHeight(), subject.getZ());
			HitResult traceToBlocks = subject.level.clip(new ClipContext(observer, subjectLocation, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, subject));
			if (traceToBlocks.getType() != HitResult.Type.MISS) subjectLocation = traceToBlocks.getLocation();
			Optional<Vec3> traceToEntity = axisalignedbb.clip(observer, subjectLocation);
			return traceToEntity.isPresent();
		}

		@Override
		public boolean canUse() {
			return henos.getHealth() <= (henos.getMaxHealth() / 2) && !henos.isUsingRegularAttack() && henos.getLaserTick() >= 0;
		}

		@Override
		public boolean canContinueToUse() {
			if(henos.tickCount > 0 && henos.tickCount % 20 == 0 && !canSeeEntity(henos.position(), henos.getTarget())){
				this.henos.setChargingBeam(false);
				this.henos.setUsingBeam(false);
				this.henos.setLaserTick(-120);
				return false;
			}
			if (henos.getLaserTick() <= 0 || !super.canContinueToUse()) {
				this.henos.setChargingBeam(false);
				this.henos.setUsingBeam(false);
				return false;
			}
			return super.canContinueToUse();
		}

		public void start() {
			this.laserSoundTick = 0;
			this.henos.setChargingBeam(true);
			this.henos.setLaserEntity(henos.getTarget());
			this.henos.getNavigation().stop();
			this.laserYaw = Mth.wrapDegrees(henos.yRot);
			this.laserPitch = Mth.wrapDegrees(henos.xRot + 90);
			this.henos.hasImpulse = true;
			this.henos.setLaserTick(TIME);
			henos.setLaserX((float) henos.getX());
			henos.setLaserY((float) henos.getY());
			henos.setLaserZ((float) henos.getZ());
			this.henos.useBeam(true);
		}

		@SuppressWarnings("unused")
		private float updateRotation(float currentAngle, float targetAngle, float maxChange) {
			float change = Mth.wrapDegrees(targetAngle - currentAngle);
			return Mth.wrapDegrees(currentAngle + henos.random.nextFloat() * 1.5F - 0.75F + change / maxChange);
		}

		private void updateLaser() {
			if (this.henos.level != null) {
				if (henos.getTarget() != null) {
					double targetX = henos.getTarget().getX();
					double targetY = henos.getTarget().getY() + henos.getTarget().getEyeHeight() * 0.5F;
					double targetZ = henos.getTarget().getZ();
					double rot = henos.yBodyRot * 0.01745329238474369D + (Math.PI / 2D);
					double lureX = Math.cos(rot) * (double) (henos.getBbWidth() + 1f) + henos.getX();
					double lureY = henos.getY(0.65F);
					double lureZ = Math.sin(rot) * (double) (henos.getBbWidth() + 1f) + henos.getZ();
					Vec3 lureVec = new Vec3(lureX, lureY, lureZ);
					double d0 = targetX - lureX;
					double d1 = targetY - lureY;
					double d2 = targetZ - lureZ;
					double d3 = Math.sqrt(d0 * d0 + d2 * d2);
					float targetYaw = (float) (Mth.atan2(d2, d0) * (180D / Math.PI)) - 90.0F;
					float targetPitch = (float) (-(Mth.atan2(d1, d3) * (180D / Math.PI)));
					float laserProg = 1F - (Mth.clamp(henos.getLaserTick(), 0, TIME) / (float) TIME);
					float baseYaw = Mth.wrapDegrees(henos.yRot);
					float basePitch = Mth.wrapDegrees(henos.xRot + 120);
					this.laserYaw = baseYaw + Mth.wrapDegrees(targetYaw - baseYaw) * laserProg;
					this.laserPitch = basePitch + (targetPitch - basePitch) * laserProg;
					Vec3 laserAngle = Vec3.directionFromRotation(laserPitch, laserYaw);
					double range = 30d;
					Vec3 hitVec = lureVec.add(laserAngle.scale(range));

					HitResult trace = henos.level.clip(new ClipContext(lureVec, hitVec, ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, henos));
					if (trace.getType() != HitResult.Type.MISS) {
						hitVec = trace.getLocation();
					}
					henos.setLaserX((float) hitVec.x);
					henos.setLaserY((float) hitVec.y);
					henos.setLaserZ((float) hitVec.z);
					float f = 1.0F;
					if (this.henos.level.getDifficulty() == Difficulty.HARD) {
						f += 2.0F;
					}

					LivingEntity base = null;
					for (LivingEntity entity : henos.level.getEntitiesOfClass(LivingEntity.class, henos.getBoundingBox().inflate(30))) {
						AABB axisalignedbb = entity.getBoundingBox().inflate(0.30000001192092896D);
						Optional<Vec3> traceToEntity = axisalignedbb.clip(lureVec, hitVec);
						if (traceToEntity.isPresent() && canSeeEntity(lureVec, entity) && entity != henos && (base == null || henos.distanceTo(entity) < henos.distanceTo(base)))
							base = entity;
					}

					if (base != null) {
						base.hurt(DamageSource.mobAttack(this.henos), (float) this.henos.getAttribute(Attributes.ATTACK_DAMAGE).getValue() / 2);
						if (!base.isBlocking()) {
							base.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 140 * (int) f, 2));
							base.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 140 * (int) f, 2));
						}
					}
				}
			}
		}

		public void tick() {
			this.henos.getNavigation().stop();
			if (henos.getLaserTick() > 0) {
				henos.setLaserTick(henos.getLaserTick() - 1);
			}
			if (henos.getLaserTick() == 0) {
				this.henos.setChargingBeam(false);
				this.henos.setUsingBeam(true);
				this.henos.playSound(PFSounds.HENOS_LASER, 1.0F, this.henos.getVoicePitch());
			} else if (henos.getLaserTick() > 0) {
				this.updateLaser();
				if(laserSoundTick % 17 == 0){
					this.henos.playSound(PFSounds.HENOS_LASER_LOOP, 1.0F, this.henos.getVoicePitch());
				}
				laserSoundTick++;
			}
			super.tick();
		}

		@Override
		public void stop() {
			henos.setLaserEntity(null);
			henos.setLaserTick(-50);
			henos.setLaserX((float) henos.getX());
			henos.setLaserY((float) henos.getY());
			henos.setLaserZ((float) henos.getZ());
			henos.useBeam(false);
		}

	}

	public class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		Henos henos;

		public MeleeAttackGoal(Henos henos, double speedIn, boolean useLongMemory) {
			super(henos, speedIn, useLongMemory);
			this.henos = henos;
		}

		@Override
		public boolean canUse() {
			if (henos.getHealth() >= (henos.getMaxHealth() / 2) || henos.getLaserTick() < 0) {
				return super.canUse();
			} else if (henos.getHealth() <= (henos.getMaxHealth() / 2) && !henos.isUsingBeamAttack()) {
				if (henos.getTarget() != null) {
					if (henos.distanceToSqr(henos.getTarget()) <= 14D) {
						return super.canUse();
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
			return this.mob.getBbWidth() * 3.0F * this.mob.getBbWidth() * 3.0F + attackTarget.getBbWidth();
		}

		@Override
		public boolean canContinueToUse() {
			if(henos.getLaserTick() < 0){
				return super.canContinueToUse();
			}
			if (henos.getHealth() <= (henos.getMaxHealth() / 2) && !henos.isUsingBeamAttack()) {
				if (henos.getTarget() != null) {
					if (henos.distanceToSqr(henos.getTarget()) <= 10D) {
						return super.canContinueToUse();
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else if (henos.getHealth() > (henos.getMaxHealth() / 2) || henos.getLaserTick() < 0) {
				return super.canContinueToUse();
			} else {
				return false;
			}
		}

		@Override
		public void start() {
			super.start();
			henos.useRegularAttack(true);
		}

		@Override
		public void stop() {
			super.stop();
			henos.useRegularAttack(false);
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		return null;
	}
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.HENOS_SPAWN_EGG.get());
	}

}
