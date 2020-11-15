package superlord.prehistoricfauna.entity;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SEntityVelocityPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.Constants.NBT;

public class TimeGuardianEntity extends MonsterEntity {
	private static final DataParameter<Boolean> ACTIVE = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> USE_SLAM = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> USE_BEAM = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> USE_REGULAR_ATTACK = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Optional<BlockPos>> REST_POSITION = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.OPTIONAL_BLOCK_POS);
	private static final DataParameter<Boolean> CHARGING_BEAM = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> USING_BEAM = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Float> LASER_PITCH = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.FLOAT);
	private static final DataParameter<Float> LASER_YAW = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.FLOAT);
	private static final DataParameter<Float> PREV_LASER_PITCH = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.FLOAT);
	private static final DataParameter<Float> PREV_LASER_YAW = EntityDataManager.createKey(TimeGuardianEntity.class, DataSerializers.FLOAT);
	private final ServerBossInfo bossInfo = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS));

	public float targetDistance;
	public float targetAngle;

	public TimeGuardianEntity(EntityType<? extends MonsterEntity> type, World world) {
		super(type, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		goalSelector.addGoal(1, new TimeGuardianEntity.SlamAttackAI(this));
		goalSelector.addGoal(1, new TimeGuardianEntity.BeamAttackAI(this));
		goalSelector.addGoal(1, new TimeGuardianEntity.MeleeAttackGoal(this, 1.0D, false));
		goalSelector.addGoal(2, new TimeGuardianEntity.AttackAI(this));
		targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 0, true, false, null));
	}

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10.0D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(24.0D);
	}


	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		Entity entitySource = source.getTrueSource();
		if(entitySource != null) {
			if ((!isActive() || getAttackTarget() == null) && entitySource instanceof LivingEntity && !(entitySource instanceof PlayerEntity && ((PlayerEntity)entitySource).isCreative()) && !(entitySource instanceof TimeGuardianEntity)) setAttackTarget((LivingEntity)entitySource);
			if(isActive()) {
				return super.attackEntityFrom(source, amount);
			}
		} else if (source.canHarmInCreative()) {
			return super.attackEntityFrom(source, amount);
		}
		return false;
	}

	@Override
	public void tick() {
		super.tick();
		if (getAttackTarget() != null) {
			targetDistance = getDistance(getAttackTarget()) - getAttackTarget().getWidth() / 2f;
			targetAngle = (float) getAngleBetweenEntities(this, getAttackTarget());
		}
		if(getAttackTarget() != null && (!getAttackTarget().isAlive() || getAttackTarget().getHealth() <= 0)) setAttackTarget(null);
		if (!world.isRemote) {
			if (!isAIDisabled()) {
				if (isActive()) {
					if (getAttackTarget() == null && moveForward == 0 && isAtRestPos()) {
						setActive(false);
					}
				} else if (getAttackTarget() != null && targetDistance <= 4.5) {
					setActive(true);
				}
			}
		}
		if (!isActive()) {
			setMotion(0, getMotion().y, 0);
			rotationYaw = prevRotationYaw;
		}
		renderYawOffset = rotationYaw;
		if(getAttackTarget() == null && getNavigator().noPath() && !isAtRestPos() && isActive()) updateRestPos();
		if (!isActive() && !world.isRemote) heal(0.3f);
	}

	@Override
	public boolean canBePushed() {
		return isActive();
	}

	private boolean isAtRestPos() {
		Optional<BlockPos> restPos = getRestPos();
		if (restPos.isPresent()) {
			return restPos.get().distanceSq(getPosition()) < 36;
		}
		return false;
	}

	private void updateRestPos() {
		boolean reassign = true;
		if(getRestPos().isPresent()) {
			BlockPos pos = getRestPos().get();
			if(getNavigator().tryMoveToXYZ(pos.getX(), pos.getY(), pos.getZ(), 0.2)) {
				reassign = false;
			}
		}
		if (reassign) {
			setRestPos(getPosition());
		}
	}

	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingData, @Nullable CompoundNBT compound) {
		setRestPos(getPosition());
		return super.onInitialSpawn(world, difficulty, reason, livingData, compound);
	}

	@Override
	public boolean preventDespawn() {
		return true;
	}

	@Override
	protected void registerData() {
		super.registerData();
		getDataManager().register(REST_POSITION, Optional.empty());
		getDataManager().register(ACTIVE, false);
		getDataManager().register(USE_BEAM, false);
		getDataManager().register(USE_SLAM, false);
		getDataManager().register(USE_REGULAR_ATTACK, false);
		getDataManager().register(CHARGING_BEAM, false);
		getDataManager().register(USING_BEAM, false);
		getDataManager().register(LASER_PITCH, (float) 0);
		getDataManager().register(LASER_YAW, (float) 0);
		getDataManager().register(PREV_LASER_PITCH, (float) 0);
		getDataManager().register(PREV_LASER_YAW, (float) 0);
	}	

	public Optional<BlockPos> getRestPos() {
		return getDataManager().get(REST_POSITION);
	}

	public void setRestPos(BlockPos pos) {
		getDataManager().set(REST_POSITION, Optional.of(pos));
	}

	public boolean isUsingBeamAttack() {
		return getDataManager().get(USE_BEAM);
	}

	public void useBeam(boolean isUsingBeam) {
		getDataManager().set(USE_BEAM, isUsingBeam);
	}

	public boolean isSlamming() {
		return getDataManager().get(USE_SLAM);
	}

	public void useSlam(boolean isSlamming) {
		getDataManager().set(USE_SLAM, isSlamming);
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

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		Optional<BlockPos> restPos = getRestPos();
		if(restPos.isPresent()) {
			compound.put("restPos", NBTUtil.writeBlockPos(getRestPos().get()));
		}
		compound.putBoolean("active", isActive());
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		if(compound.contains("restPos", NBT.TAG_COMPOUND)) {
			setRestPos(NBTUtil.readBlockPos(compound.getCompound("restPos")));
		}
		setActive(compound.getBoolean("active"));
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
			if(timeGuardian.isUsingRegularAttack()) {
				return super.shouldExecute();
			} else {
				return false;
			}
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

		public static boolean canSeeEntity(Vec3d observer, Entity subject) {
			if (observer == null || subject == null) return false;
			AxisAlignedBB axisalignedbb = subject.getBoundingBox().grow(0.30000001192092896D);
			Vec3d subjectLocation = new Vec3d(subject.getPosX(), subject.getPosY() + subject.getEyeHeight(), subject.getPosZ());
			RayTraceResult traceToBlocks = subject.world.rayTraceBlocks(new RayTraceContext(observer, subjectLocation, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, subject));
			if (traceToBlocks.getType() != RayTraceResult.Type.MISS) subjectLocation = traceToBlocks.getHitVec();
			Optional<Vec3d> traceToEntity = axisalignedbb.rayTrace(observer, subjectLocation);
			return traceToEntity.isPresent();
		}

		@Override
		public boolean shouldExecute() {
			return timeGuardian.isUsingBeamAttack();
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
					Vec3d lureVec = new Vec3d(lureX, lureY, lureZ);

					double d0 = targetX - lureX;
					double d1 = targetY - lureY;
					double d2 = targetZ - lureZ;
					double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
					float targetYaw = (float) (MathHelper.atan2(d2, d0) * (180D / Math.PI)) - 90.0F;
					float targetPitch = (float) (-(MathHelper.atan2(d1, d3) * (180D / Math.PI)));
					timeGuardian.setLaserPitch(this.updateRotation(timeGuardian.getLaserPitch(), targetPitch, 35f - this.timeGuardian.world.getDifficulty().getId() * 2f));
					timeGuardian.setLaserYaw(this.updateRotation(timeGuardian.getLaserYaw(), targetYaw, 20f - this.timeGuardian.world.getDifficulty().getId() * 2f));

					Vec3d laserAngle = Vec3d.fromPitchYaw(timeGuardian.getLaserPitch(), timeGuardian.getLaserYaw());
					double range = 30d;
					Vec3d hitVec = lureVec.add(laserAngle.scale(range));

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
						Optional<Vec3d> traceToEntity = axisalignedbb.rayTrace(lureVec, hitVec);
						if (traceToEntity.isPresent() && canSeeEntity(lureVec, entity) && entity != timeGuardian && (base == null || timeGuardian.getDistance(entity) < timeGuardian.getDistance(base)))
							base = entity;
					}

					if (base != null) {
						base.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this.timeGuardian, this.timeGuardian), f);
						base.attackEntityFrom(DamageSource.causeMobDamage(this.timeGuardian), (float) this.timeGuardian.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue());
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

	public class SlamAttackAI extends Goal {

		private TimeGuardianEntity timeGuardian;
		private int tickCounter;
		public SlamAttackAI(TimeGuardianEntity timeGuardian) {
			this.timeGuardian = timeGuardian;
		}

		@Override
		public boolean shouldExecute() {
			return timeGuardian.isSlamming();
		}

		@Override
		public void startExecuting() {
			this.tickCounter = 0;
		}

		@Override
		public void tick() {
			if(this.tickCounter == 0) {
				stomp();
			}
			++this.tickCounter;
			super.tick();
		}

		public void stomp() {
			timeGuardian.setMotion(0, timeGuardian.getMotion().y, 0);
			double perpFacing = timeGuardian.renderYawOffset * (Math.PI / 180);
			double facingAngle = perpFacing + Math.PI / 2;int hitY = MathHelper.floor(timeGuardian.getBoundingBox().minY - 0.5);
			final int maxDistance = 6;
			ServerWorld world = (ServerWorld) timeGuardian.world; if (tickCounter > 9 && tickCounter < 17) {
				if (tickCounter == 10) {
					final double infront = 1.47, side = -0.21;
					double vx = Math.cos(facingAngle) * infront;
					double vz = Math.sin(facingAngle) * infront;
					double perpX = Math.cos(perpFacing);
					double perpZ = Math.sin(perpFacing);
					double fx = timeGuardian.getPosX() + vx + perpX * side;
					double fy = timeGuardian.getBoundingBox().minY + 0.1;
					double fz = timeGuardian.getPosZ() + vz + perpZ * side;
					MathHelper.floor(fx);
					MathHelper.floor(fz);
					int amount = 16 + world.rand.nextInt(8);
					while (amount-- > 0) {
						double theta = world.rand.nextDouble() * Math.PI * 2;
						double dist = world.rand.nextDouble() * 0.1 + 0.25;
						double sx = Math.cos(theta);
						double sz = Math.sin(theta);
						double px = fx + sx * dist;
						double py = fy + world.rand.nextDouble() * 0.1;
						double pz = fz + sz * dist;
						world.spawnParticle(ParticleTypes.LARGE_SMOKE, px, py, pz, 0, sx * 0.065, 0, sz * 0.065, 1);
					}
				} else if (tickCounter == 12) {
					timeGuardian.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 2, 1F + timeGuardian.getRNG().nextFloat() * 0.1F);
				}
				if (tickCounter % 2 == 0) {
					int distance = tickCounter / 2 - 2;
					double spread = Math.PI * 2;
					int arcLen = MathHelper.ceil(distance * spread);
					double minY = timeGuardian.getBoundingBox().minY;
					double maxY = timeGuardian.getBoundingBox().maxY;
					for (int i = 0; i < arcLen; i++) {
						double theta = (i / (arcLen - 1.0) - 0.5) * spread + facingAngle;
						double vx = Math.cos(theta);
						double vz = Math.sin(theta);
						double px = timeGuardian.getPosX() + vx * distance;
						double pz = timeGuardian.getPosZ() + vz * distance;
						float factor = 1 - distance / (float) maxDistance;
						AxisAlignedBB selection = new AxisAlignedBB(px - 1.5, minY, pz - 1.5, px + 1.5, maxY, pz + 1.5);
						List<Entity> hit = world.getEntitiesWithinAABB(Entity.class, selection);
						for (Entity entity : hit) {
							if (entity == this.timeGuardian || entity instanceof FallingBlockEntity) {
								continue;
							}
							float knockbackResistance = 0;
							if (entity instanceof LivingEntity) {
								entity.attackEntityFrom(DamageSource.causeMobDamage(this.timeGuardian), (float)timeGuardian.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue());
								knockbackResistance = (float) ((LivingEntity)entity).getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).getValue();
							}
							double magnitude = world.rand.nextDouble() * 0.15 + 0.1;
							float x = 0, y = 0, z = 0;
							x += vx * factor * magnitude * (1 - knockbackResistance);
							if (entity.onGround) {
								y += 0.1 * (1 - knockbackResistance) + factor * 0.15 * (1 - knockbackResistance);
							}
							z += vz * factor * magnitude * (1 - knockbackResistance);
							entity.setMotion(entity.getMotion().add(x, y, z));
							if (entity instanceof ServerPlayerEntity) {
								((ServerPlayerEntity) entity).connection.sendPacket(new SEntityVelocityPacket(entity));
							}
						}
						if (world.rand.nextBoolean()) {
							int hitX = MathHelper.floor(px);
							int hitZ = MathHelper.floor(pz);
							BlockPos pos = new BlockPos(hitX, hitY, hitZ);
							BlockPos abovePos = new BlockPos(pos).up();
							BlockPos belowPos = new BlockPos(pos).down();
							if (world.isAirBlock(abovePos) && !world.isAirBlock(belowPos)) {
								BlockState block = world.getBlockState(pos);
								if (block.getMaterial() != Material.AIR && block.isNormalCube(world, pos) && block.getBlock() != Blocks.BEDROCK && !block.getBlock().hasTileEntity(block)) {
									FallingBlockEntity fallingBlock = new FallingBlockEntity(world, hitX + 0.5, hitY + 0.5, hitZ + 0.5, block);
									fallingBlock.setMotion(0, 0.4 + factor * 0.2, 0);
									fallingBlock.fallTime = 2;
									world.addEntity(fallingBlock);
									world.removeBlock(pos, false);
									int amount = 6 + world.rand.nextInt(10);
									Block.getStateId(block);
									while (amount --> 0) {
										double cx = px + world.rand.nextFloat() * 2 - 1;
										double cy = timeGuardian.getBoundingBox().minY + 0.1 + world.rand.nextFloat() * 0.3;
										double cz = pz + world.rand.nextFloat() * 2 - 1;
										world.spawnParticle(ParticleTypes.EXPLOSION, cx, cy, cz, 0, vx, 0.4 + world.rand.nextFloat() * 0.2F, vz, 1);
									}
								}
							}
						}
						if (world.rand.nextBoolean()) {
							int amount = world.rand.nextInt(5);
							while (amount-- > 0) {
								double velX = vx * 0.075;
								double velY = factor * 0.3 + 0.025;
								double velZ = vz * 0.075;
								world.spawnParticle(ParticleTypes.CLOUD, px + world.rand.nextFloat() * 2 - 1, timeGuardian.getBoundingBox().minY + 0.1 + world.rand.nextFloat() * 1.5, pz + world.rand.nextFloat() * 2 - 1, 0, velX, velY, velZ, 1);
							}
						}
					}
				}
			}
		}

	}

	public class AttackAI extends Goal {
		private final TimeGuardianEntity timeGuardian;

		private int repath;
		private double targetX, targetY, targetZ;

		private int attacksSinceBeam, timeSinceSlam;

		public AttackAI(TimeGuardianEntity timeGuardian) {
			this.timeGuardian = timeGuardian;
			this.setMutexFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
		}

		@Override
		public boolean shouldExecute() {
			LivingEntity target = this.timeGuardian.getAttackTarget();
			return target != null && target.isAlive() && this.timeGuardian.isActive();
		}

		@Override
		public void startExecuting() {
			this.repath = 0;
			this.timeSinceSlam = 0;
		}

		@Override
		public void resetTask() {
			this.timeGuardian.getNavigator().clearPath();
		}

		@Override
		public void tick() {
			LivingEntity target = this.timeGuardian.getAttackTarget();
			if (target == null) {
				return;
			}
			double dist = this.timeGuardian.getDistanceSq(this.targetX, this.targetY, this.targetZ);
			if (--this.repath <= 0 && (this.targetX == 0.0D && this.targetY == 0.0D && this.targetZ == 0.0D || target.getDistanceSq(this.targetX, this.targetY, this.targetZ) >= 1.0D) || this.timeGuardian.getNavigator().noPath()) {
				this.targetX = target.getPosX();
				this.targetY = target.getPosY();
				this.targetZ = target.getPosZ();
				this.repath = 4 + this.timeGuardian.getRNG().nextInt(7);
				if (dist > 32.0D * 32.0D) {
					this.repath += 10;
				} else if (dist > 16.0D * 16.0D) {
					this.repath += 5;
				}
				if (this.timeGuardian.getNavigator().tryMoveToEntityLiving(target, 0.2D)) {
					this.repath += 15;
				}
			}
			dist = this.timeGuardian.getDistanceSq(this.targetX, this.targetY, this.targetZ);
			if(target.getPosY() - this.timeGuardian.getPosY() >= -1 && target.getPosY() - this.timeGuardian.getPosY() <= 3) {
				boolean couldSlam = dist < 6.0D * 6.0D && this.timeSinceSlam > 200;
				if(dist < 3.5D * 3.5D && Math.abs(MathHelper.wrapDegrees(this.timeGuardian.getAngleBetweenEntities(target, this.timeGuardian) - this.timeGuardian.rotationYaw)) < 35.0D && (!couldSlam || this.timeGuardian.getRNG().nextFloat() < 0.667F)) {
					if(this.attacksSinceBeam > 3 + 2 * (1 - timeGuardian.getHealthRatio()) || this.timeGuardian.getRNG().nextFloat() < 0.18F) {
						timeGuardian.useBeam(true);
						this.attacksSinceBeam = 0;
					} else if(couldSlam) {
						timeGuardian.useSlam(true);
						this.timeSinceSlam = 0;
						this.attacksSinceBeam++;
					} 
				} 
			} else {
				timeGuardian.useRegularAttack(true);
				this.attacksSinceBeam++;
			}
			this.timeSinceSlam++;
		}

	}

}
