package superlord.prehistoricfauna.common.entity.henos;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EnumSet;

import javax.annotation.Nullable;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class Pyrinos extends Animal {

	private static final EntityDataAccessor<Boolean> FLYING = SynchedEntityData.defineId(Pyrinos.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> FIRE_BREATHING = SynchedEntityData.defineId(Pyrinos.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> WING_PUSHING = SynchedEntityData.defineId(Pyrinos.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> TAIL_JABBING = SynchedEntityData.defineId(Pyrinos.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> GLIDE_SHOOTING = SynchedEntityData.defineId(Pyrinos.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> FLAME_CHARGING = SynchedEntityData.defineId(Pyrinos.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> FLAME_BLASTING = SynchedEntityData.defineId(Pyrinos.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> FLY_STARTING = SynchedEntityData.defineId(Pyrinos.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> FLY_STOPPING = SynchedEntityData.defineId(Pyrinos.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> GRAB_PHASE = SynchedEntityData.defineId(Pyrinos.class, EntityDataSerializers.INT);

	private static final int GRAB_NONE = 0;
	private static final int GRAB_SEEKING = 1;
	private static final int GRAB_LIFTING = 2;
	private static final int GRAB_DROPPING = 3;

	private static final int FLYSTART_DURATION = 30;
	private static final int FLYSTOP_DURATION = 20;

	public float ridingXZ;
	public float ridingY = 1F;

	public final AnimationState idleAnimationState = new AnimationState();
	public final AnimationState flappingAnimationState = new AnimationState();
	public final AnimationState meleeAttackAnimationState = new AnimationState();
	public final AnimationState shootAnimationState = new AnimationState();
	public final AnimationState inhaleAnimationState = new AnimationState();
	public final AnimationState blastAnimationState = new AnimationState();
	public final AnimationState flystartAnimationState = new AnimationState();
	public final AnimationState flystopAnimationState = new AnimationState();
	public final AnimationState flyflapAnimationState = new AnimationState();
	public final AnimationState grabstartAnimationState = new AnimationState();
	public final AnimationState grabAnimationState = new AnimationState();
	public final AnimationState grabendAnimationState = new AnimationState();

	private int flyTransitionTicks;
	private int flyflapTicksRemaining;

	private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.GREEN, BossEvent.BossBarOverlay.PROGRESS));

	private final Deque<Long> recentHitTicks = new ArrayDeque<>();

	public Pyrinos(EntityType<? extends Pyrinos> type, Level level) {
		super(type, level);
		super.setMaxUpStep(1.325F);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 300.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.ATTACK_DAMAGE, 10.0D).add(Attributes.FOLLOW_RANGE, 25.0D).add(Attributes.KNOCKBACK_RESISTANCE, 50.0D);
	}

	@Override
	public boolean requiresCustomPersistence() {
		return true;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(FLYING, false);
		this.entityData.define(FIRE_BREATHING, false);
		this.entityData.define(WING_PUSHING, false);
		this.entityData.define(TAIL_JABBING, false);
		this.entityData.define(GLIDE_SHOOTING, false);
		this.entityData.define(FLAME_CHARGING, false);
		this.entityData.define(FLAME_BLASTING, false);
		this.entityData.define(FLY_STARTING, false);
		this.entityData.define(FLY_STOPPING, false);
		this.entityData.define(GRAB_PHASE, GRAB_NONE);
	}

	public boolean isPyrinosFlying() {
		return this.entityData.get(FLYING);
	}

	public void setPyrinosFlying(boolean flying) {
		this.entityData.set(FLYING, flying);
	}

	public boolean isBreathingFire() {
		return this.entityData.get(FIRE_BREATHING);
	}

	public void setBreathingFire(boolean breathing) {
		this.entityData.set(FIRE_BREATHING, breathing);
	}

	public boolean isFlappingWings() {
		return this.entityData.get(WING_PUSHING);
	}

	public void setFlappingWings(boolean isFlappingWings) {
		this.entityData.set(WING_PUSHING, isFlappingWings);
	}

	public boolean isTailJabbing() {
		return this.entityData.get(TAIL_JABBING);
	}

	public void setTailJabbing(boolean jabbing) {
		this.entityData.set(TAIL_JABBING, jabbing);
	}

	public boolean isGlideShooting() {
		return this.entityData.get(GLIDE_SHOOTING);
	}

	public void setGlideShooting(boolean shooting) {
		this.entityData.set(GLIDE_SHOOTING, shooting);
	}

	public boolean isFlameCharging() {
		return this.entityData.get(FLAME_CHARGING);
	}

	public void setFlameCharging(boolean charging) {
		this.entityData.set(FLAME_CHARGING, charging);
	}

	public boolean isFlameBlasting() {
		return this.entityData.get(FLAME_BLASTING);
	}

	public void setFlameBlasting(boolean blasting) {
		this.entityData.set(FLAME_BLASTING, blasting);
	}

	public boolean isFlyStarting() {
		return this.entityData.get(FLY_STARTING);
	}

	private void setFlyStarting(boolean starting) {
		this.entityData.set(FLY_STARTING, starting);
	}

	public boolean isFlyStopping() {
		return this.entityData.get(FLY_STOPPING);
	}

	private void setFlyStopping(boolean stopping) {
		this.entityData.set(FLY_STOPPING, stopping);
	}

	public int getGrabPhase() {
		return this.entityData.get(GRAB_PHASE);
	}

	public void setGrabPhase(int phase) {
		this.entityData.set(GRAB_PHASE, phase);
	}

	/**
	 * All goals should call this instead of {@link #setPyrinosFlying(boolean)} directly.
	 * Requesting flight true triggers flystart first, then flips the real FLYING flag once
	 * it finishes; requesting false immediately drops FLYING but triggers flystop, holding
	 * isNoGravity() true for its duration so the entity doesn't just drop out of the sky.
	 */
	public void requestFlyingState(boolean flying) {
		if (flying) {
			if (!this.isPyrinosFlying() && !this.isFlyStarting()) {
				this.setFlyStopping(false);
				this.setFlyStarting(true);
				this.flyTransitionTicks = 0;
			}
		} else {
			if (this.isFlyStarting()) {
				this.setFlyStarting(false);
			}
			if (this.isPyrinosFlying() && !this.isFlyStopping()) {
				this.setPyrinosFlying(false);
				this.setFlyStopping(true);
				this.flyTransitionTicks = 0;
			}
		}
	}

	@Override
	public void positionRider(Entity passenger, Entity.MoveFunction p_289531_) {
		super.positionRider(passenger, p_289531_);

		float radius = 1;
		float angle = (0.01745329251F * this.yBodyRotO);
		double extraX = radius * Mth.sin((float) (Math.PI + angle));
		double extraZ = radius * Mth.cos(angle);
		double extraY;
		if (this.isInWater()) {
			extraY = ridingY;
		} else {
			extraY = ridingY;
		}
		this.getPassengers().get(0).setPos(this.getX() + extraX, this.getY() + extraY - 2.75F, this.getZ() + extraZ);
	}

	@Override
	public boolean shouldRiderSit() {
		return false;
	}

	@Override
	public boolean isNoGravity() {
		return this.isPyrinosFlying() || this.isFlyStarting() || this.isFlyStopping() || super.isNoGravity();
	}

	protected SoundEvent getAmbientSound() {
		return PFSounds.HENOS_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.HENOS_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.HENOS_DEATH.get();
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new PyrinosGrabDropGoal(this));
		this.goalSelector.addGoal(2, new PyrinosWingPushGoal(this));
		this.goalSelector.addGoal(3, new PyrinosFlamethrowerGoal(this));
		this.goalSelector.addGoal(4, new PyrinosGlideFlameGoal(this));
		this.goalSelector.addGoal(5, new PyrinosTailJabGoal(this));
		targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, 0, true, false,
				target -> {
					double dx = Math.abs(target.getX() - this.getX());
					double dz = Math.abs(target.getZ() - this.getZ());
					double dy = this.getY() - target.getY();

					return dx <= 10.0D && dz <= 10.0D && dy >= 0.0D && dy <= 9.0D;
				}));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
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

	public void aiStep() {
		super.aiStep();
		if (this.getTarget() == null) {
			for (Player player : this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(10, 9, 10))) {
				if (!player.isCreative()) {
					this.setTarget(player);
					break;
				}
			}
		} else {
			if (this.getTarget() instanceof Player player && player.isCreative()) this.setTarget(null);
		}

		if (!this.level().isClientSide()) {
			if (this.isFlyStarting()) {
				this.flyTransitionTicks++;
				if (this.flyTransitionTicks >= FLYSTART_DURATION) {
					this.setFlyStarting(false);
					this.setPyrinosFlying(true);
				}
			} else if (this.isFlyStopping()) {
				this.flyTransitionTicks++;
				if (this.flyTransitionTicks >= FLYSTOP_DURATION) {
					this.setFlyStopping(false);
				}
			}
		}

		if (this.level().isClientSide()) {
			if (this.isAlive()) {
				this.idleAnimationState.startIfStopped(this.tickCount);
			} else {
				this.idleAnimationState.stop();
			}
			if (this.isFlappingWings()) {
				this.flappingAnimationState.startIfStopped(this.tickCount);
			} else {
				this.flappingAnimationState.stop();
			}
			if (this.isTailJabbing()) {
				this.meleeAttackAnimationState.startIfStopped(this.tickCount);
			} else {
				this.meleeAttackAnimationState.stop();
			}
			if (this.isGlideShooting()) {
				this.shootAnimationState.startIfStopped(this.tickCount);
			} else {
				this.shootAnimationState.stop();
			}
			if (this.isFlameCharging()) {
				this.inhaleAnimationState.startIfStopped(this.tickCount);
			} else {
				this.inhaleAnimationState.stop();
			}
			if (this.isFlameBlasting()) {
				this.blastAnimationState.startIfStopped(this.tickCount);
			} else {
				this.blastAnimationState.stop();
			}
			if (this.isFlyStarting()) {
				this.flystartAnimationState.startIfStopped(this.tickCount);
			} else {
				this.flystartAnimationState.stop();
			}
			if (this.isFlyStopping()) {
				this.flystopAnimationState.startIfStopped(this.tickCount);
			} else {
				this.flystopAnimationState.stop();
			}

			int grabPhase = this.getGrabPhase();
			if (grabPhase == GRAB_SEEKING) {
				this.grabstartAnimationState.startIfStopped(this.tickCount);
			} else {
				this.grabstartAnimationState.stop();
			}
			if (grabPhase == GRAB_LIFTING) {
				this.grabAnimationState.startIfStopped(this.tickCount);
			} else {
				this.grabAnimationState.stop();
			}
			if (grabPhase == GRAB_DROPPING) {
				this.grabendAnimationState.startIfStopped(this.tickCount);
			} else {
				this.grabendAnimationState.stop();
			}

			if (this.isPyrinosFlying() && !this.flyflapAnimationState.isStarted() && this.random.nextInt(400) == 0) {
				this.flyflapAnimationState.start(this.tickCount);
				this.flyflapTicksRemaining = 80;
			}
			if (this.flyflapTicksRemaining > 0) {
				this.flyflapTicksRemaining--;
				if (this.flyflapTicksRemaining == 0) {
					this.flyflapAnimationState.stop();
				}
			}
		}
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		return null;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.PYRINOS_SPAWN_EGG.get());
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		boolean hurt = super.hurt(source, amount);
		if (source.is(DamageTypes.ON_FIRE) || source.is(DamageTypes.FALL) || source.is(DamageTypes.DROWN) || source.is(DamageTypes.FIREBALL) || source.is(DamageTypes.UNATTRIBUTED_FIREBALL) || source.is(DamageTypes.SWEET_BERRY_BUSH) || source.is(DamageTypes.CACTUS) || source.is(DamageTypes.FALLING_ANVIL) || source.is(DamageTypes.FALLING_BLOCK) || source.is(DamageTypes.FALLING_STALACTITE) || source.is(DamageTypes.FREEZE) || source.is(DamageTypes.HOT_FLOOR) || source.is(DamageTypes.IN_FIRE) || source.is(DamageTypes.IN_WALL) || source.is(DamageTypes.LAVA) || source.is(DamageTypes.LIGHTNING_BOLT) || source.is(DamageTypes.MAGIC) || source.is(DamageTypes.STALAGMITE)) {
			return false;
		} else {
			if (hurt && !this.level().isClientSide && source.getEntity() instanceof Player) {
				long time = this.level().getGameTime();
				this.recentHitTicks.addLast(time);
				this.pruneOldHits(time);
			}
			return hurt;
		}
	}

	protected boolean isAffectedByFluids() {
		return false;
	}

	private void pruneOldHits(long now) {
		while (!this.recentHitTicks.isEmpty() && now - this.recentHitTicks.peekFirst() > 200) {
			this.recentHitTicks.pollFirst();
		}
	}

	public boolean wasHitFrequently() {
		this.pruneOldHits(this.level().getGameTime());
		return this.recentHitTicks.size() >= 4;
	}

	public void clearRecentHits() {
		this.recentHitTicks.clear();
	}

	public class PyrinosGlideFlameGoal extends Goal {

		private final Pyrinos pyrinos;
		private double angle;
		private int ticksRunning;
		private int cooldown;

		private static final double RADIUS = 7.0D;
		private static final double HEIGHT_OFFSET = 4.0D;
		private static final int DURATION = 140;
		private static final int BURST_INTERVAL = 25;
		private static final int BURST_LENGTH = 8;

		public PyrinosGlideFlameGoal(Pyrinos pyrinos) {
			this.pyrinos = pyrinos;
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		@Override
		public boolean canUse() {
			if (cooldown > 0) {
				cooldown--;
				return false;
			}
			LivingEntity target = pyrinos.getTarget();
			return target != null && target.isAlive() && pyrinos.distanceToSqr(target) < 400.0D;
		}

		@Override
		public boolean canContinueToUse() {
			LivingEntity target = pyrinos.getTarget();
			return target != null && target.isAlive() && ticksRunning < DURATION;
		}

		@Override
		public void start() {
			pyrinos.requestFlyingState(true);
			pyrinos.setGlideShooting(true);
			ticksRunning = 0;
			angle = 0;
		}

		@Override
		public void stop() {
			pyrinos.requestFlyingState(false);
			pyrinos.setGlideShooting(false);
			pyrinos.setBreathingFire(false);
			pyrinos.setDeltaMovement(pyrinos.getDeltaMovement().multiply(0.2, 1.0, 0.2));
			cooldown = 200;
		}

		@Override
		public void tick() {
			LivingEntity target = pyrinos.getTarget();
			if (target == null) return;

			ticksRunning++;
			angle += Math.toRadians(4.0D);

			double x = target.getX() + RADIUS * Math.cos(angle);
			double z = target.getZ() + RADIUS * Math.sin(angle);
			double y = target.getY() + HEIGHT_OFFSET;

			Vec3 toTarget = new Vec3(x - pyrinos.getX(), y - pyrinos.getY(), z - pyrinos.getZ());
			double len = toTarget.length();
			if (len > 0.001D) {
				Vec3 steer = toTarget.scale(1.0D / len).scale(0.35D);
				pyrinos.setDeltaMovement(pyrinos.getDeltaMovement().scale(0.8D).add(steer));
			}
			pyrinos.getLookControl().setLookAt(target, 30.0F, 30.0F);

			int cyclePos = ticksRunning % BURST_INTERVAL;
			pyrinos.setBreathingFire(cyclePos < BURST_LENGTH);
			if (cyclePos == 0) {
				spewFire(target);
			}
		}

		private void spewFire(LivingEntity target) {
			if (!(pyrinos.level() instanceof ServerLevel serverLevel)) return;

			Vec3 look = pyrinos.getViewVector(1.0F).normalize();
			Vec3 origin = pyrinos.getEyePosition();

			for (int i = 1; i <= 12; i++) {
				Vec3 point = origin.add(look.scale(i));
				serverLevel.sendParticles(ParticleTypes.FLAME, point.x, point.y, point.z, 3, 0.15, 0.15, 0.15, 0.01);
			}

			AABB coneBox = pyrinos.getBoundingBox().inflate(6.0D);
			for (LivingEntity entity : serverLevel.getEntitiesOfClass(LivingEntity.class, coneBox,
					e -> e != pyrinos && e.isAlive())) {
				Vec3 toEntity = entity.position().subtract(origin).normalize();
				if (toEntity.dot(look) > 0.85D) {
					boolean damaged = entity.hurt(pyrinos.damageSources().inFire(), 4.0F);
					if (damaged) {
						entity.setSecondsOnFire(4);
					}
				}
			}
		}
	}

	public class PyrinosGrabDropGoal extends Goal {

		private enum State { SEEKING, LIFTING, DROPPING }

		private final Pyrinos pyrinos;
		private State state;
		private double grabStartY;
		private double liftTarget;
		private int cooldown;
		private int safetyTimer;

		public PyrinosGrabDropGoal(Pyrinos pyrinos) {
			this.pyrinos = pyrinos;
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
		}

		@Override
		public boolean canUse() {
			if (cooldown > 0) {
				cooldown--;
				return false;
			}
			LivingEntity target = pyrinos.getTarget();
			return target instanceof Player player && player.isAlive() && !player.isPassenger()
					&& !player.isBlocking() && pyrinos.distanceToSqr(player) < 36.0D;
		}

		@Override
		public boolean canContinueToUse() {
			LivingEntity target = pyrinos.getTarget();
			if (!(target instanceof Player player) || !player.isAlive()) return false;
			if (player.isBlocking() && state == State.SEEKING) return false;
			if (safetyTimer > 200) return false;
			return state != State.DROPPING;
		}

		@Override
		public void start() {
			state = State.SEEKING;
			safetyTimer = 0;
			pyrinos.setGrabPhase(GRAB_SEEKING);
		}

		@Override
		public void stop() {
			LivingEntity target = pyrinos.getTarget();
			if (target instanceof Player player && player.isPassenger() && player.getVehicle() == pyrinos) {
				player.stopRiding();
			}
			pyrinos.requestFlyingState(false);
			pyrinos.setGrabPhase(GRAB_NONE);
			cooldown = 300;
		}

		@Override
		public void tick() {
			safetyTimer++;
			LivingEntity targetLiving = pyrinos.getTarget();
			if (!(targetLiving instanceof Player player)) return;

			switch (state) {
			case SEEKING -> {
				pyrinos.getLookControl().setLookAt(player, 30.0F, 30.0F);
				Vec3 toPlayer = player.position().subtract(pyrinos.position());
				if (toPlayer.length() > 1.5D) {
					pyrinos.setDeltaMovement(pyrinos.getDeltaMovement().scale(0.8D)
							.add(toPlayer.normalize().scale(0.3D)));
				} else {
					player.startRiding(pyrinos, true);
					pyrinos.requestFlyingState(true);
					grabStartY = pyrinos.getY();
					liftTarget = 5.0D + pyrinos.getRandom().nextDouble() * 2.0D;
					state = State.LIFTING;
					pyrinos.setGrabPhase(GRAB_LIFTING);
				}
			}
			case LIFTING -> {
				pyrinos.setDeltaMovement(pyrinos.getDeltaMovement().x * 0.9D, 0.32D, pyrinos.getDeltaMovement().z * 0.9D);
				if (pyrinos.getY() - grabStartY >= liftTarget) {
					state = State.DROPPING;
					pyrinos.setGrabPhase(GRAB_DROPPING);
				}
			}
			case DROPPING -> {
				if (player.isPassenger() && player.getVehicle() == pyrinos) {
					player.stopRiding();
				}
			}
			}
		}
	}

	public class PyrinosFlamethrowerGoal extends Goal {

		private final Pyrinos pyrinos;
		private int chargeTicks;
		private int beamTicks;
		private int cooldown;

		private static final int CHARGE_DURATION = 60;
		private static final int BEAM_DURATION = 30;
		private static final double RANGE = 10.0D;

		public PyrinosFlamethrowerGoal(Pyrinos pyrinos) {
			this.pyrinos = pyrinos;
			this.setFlags(EnumSet.of(Goal.Flag.LOOK));
		}

		@Override
		public boolean canUse() {
			if (cooldown > 0) {
				cooldown--;
				return false;
			}
			LivingEntity target = pyrinos.getTarget();
			return target != null && target.isAlive() && pyrinos.distanceToSqr(target) <= RANGE * RANGE
					&& pyrinos.distanceToSqr(target) > 9.0D;
		}

		@Override
		public boolean canContinueToUse() {
			LivingEntity target = pyrinos.getTarget();
			return target != null && target.isAlive() && chargeTicks + beamTicks < CHARGE_DURATION + BEAM_DURATION;
		}

		@Override
		public void start() {
			chargeTicks = 0;
			beamTicks = 0;
			pyrinos.setFlameCharging(true);
			pyrinos.setFlameBlasting(false);
		}

		@Override
		public void stop() {
			pyrinos.setBreathingFire(false);
			pyrinos.setFlameCharging(false);
			pyrinos.setFlameBlasting(false);
			cooldown = 160;
		}

		@Override
		public void tick() {
			LivingEntity target = pyrinos.getTarget();
			if (target == null) return;
			pyrinos.getLookControl().setLookAt(target, 30.0F, 30.0F);

			if (chargeTicks < CHARGE_DURATION) {
				chargeTicks++;
				if (pyrinos.level() instanceof ServerLevel serverLevel && chargeTicks % 5 == 0) {
					Vec3 mouth = pyrinos.getEyePosition();
					serverLevel.sendParticles(ParticleTypes.SMOKE, mouth.x, mouth.y, mouth.z, 6, 0.1, 0.1, 0.1, 0.01);
				}
				return;
			}

			if (pyrinos.isFlameCharging()) {
				pyrinos.setFlameCharging(false);
				pyrinos.setFlameBlasting(true);
			}

			pyrinos.setBreathingFire(true);
			beamTicks++;
			fireBeam(target);
		}

		private void fireBeam(LivingEntity target) {
			if (!(pyrinos.level() instanceof ServerLevel serverLevel)) return;

			Vec3 origin = pyrinos.getEyePosition();
			Vec3 look = pyrinos.getViewVector(1.0F).normalize();

			for (int i = 1; i <= (int) RANGE; i++) {
				Vec3 point = origin.add(look.scale(i));
				serverLevel.sendParticles(ParticleTypes.FLAME, point.x, point.y, point.z, 4, 0.2, 0.2, 0.2, 0.02);
			}

			AABB coneBox = pyrinos.getBoundingBox().inflate(6.0D);
			for (LivingEntity entity : serverLevel.getEntitiesOfClass(LivingEntity.class, coneBox,
					e -> e != pyrinos && e.isAlive())) {
				Vec3 toEntity = entity.position().subtract(origin).normalize();
				if (toEntity.dot(look) > 0.85D) {
					boolean damaged = entity.hurt(pyrinos.damageSources().inFire(), 4.0F);
					if (damaged) {
						entity.setSecondsOnFire(4);
					}
				}
			}
		}
	}


	public class PyrinosTailJabGoal extends MeleeAttackGoal {
		private final Pyrinos pyrinos;

		public PyrinosTailJabGoal(Pyrinos pyrinos) {
			super(pyrinos, 1.0D, false);
			this.pyrinos = pyrinos;
		}

		@Override
		public void start() {
			super.start();
			pyrinos.setTailJabbing(true);
		}

		@Override
		public void stop() {
			super.stop();
			pyrinos.setTailJabbing(false);
		}
	}

	public class PyrinosWingPushGoal extends Goal {

		private final Pyrinos pyrinos;
		private int cooldown;
		private boolean triggered;
		private int animationTicks;

		private static final int ANIMATION_DURATION = 40;

		public PyrinosWingPushGoal(Pyrinos pyrinos) {
			this.pyrinos = pyrinos;
			this.setFlags(EnumSet.of(Goal.Flag.LOOK));
		}

		@Override
		public boolean canUse() {
			if (cooldown > 0) {
				cooldown--;
				return false;
			}
			LivingEntity target = pyrinos.getTarget();
			return target != null && target.isAlive() && pyrinos.distanceToSqr(target) <= 9.0D
					&& pyrinos.wasHitFrequently();
		}

		@Override
		public boolean canContinueToUse() {
			return animationTicks < ANIMATION_DURATION;
		}

		@Override
		public void start() {
			triggered = false;
			animationTicks = 0;
			pyrinos.setFlappingWings(true);
		}

		@Override
		public void tick() {
			animationTicks++;

			LivingEntity target = pyrinos.getTarget();
			if (target == null) return;

			if (!triggered) {
				Vec3 push = target.position().subtract(pyrinos.position()).normalize().scale(2.2D);
				target.setDeltaMovement(push.x, 0.4D, push.z);
				target.hurtMarked = true;

				pyrinos.clearRecentHits();
				triggered = true;
			}
		}

		@Override
		public void stop() {
			cooldown = 60;
			pyrinos.setFlappingWings(false);
		}
	}
}