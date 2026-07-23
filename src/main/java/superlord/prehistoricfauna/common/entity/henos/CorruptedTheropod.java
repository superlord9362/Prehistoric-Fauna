package superlord.prehistoricfauna.common.entity.henos;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import superlord.prehistoricfauna.init.PFEffects;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;

public class CorruptedTheropod extends Animal {
	private static final EntityDataAccessor<Integer> HEAD_ONE_HEALTH = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> HEAD_TWO_HEALTH = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> HEAD_THREE_HEALTH = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> HEAD_FOUR_HEALTH = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> HEAD_FIVE_HEALTH = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> HEAD_SIX_HEALTH = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> ATTACK_TICK = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> SLEEP_TICK = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.INT);

	private static final EntityDataAccessor<Boolean> HEAD_ONE_ATTACK = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HEAD_TWO_ATTACK = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HEAD_THREE_ATTACK = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HEAD_FOUR_ATTACK = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HEAD_FIVE_ATTACK = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HEAD_SIX_ATTACK = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ALL_HEAD_ATTACK = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> KNOCKBACK_ROAR_ATTACK = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> CHARGE_ATTACK = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);

	private static final EntityDataAccessor<Boolean> HEAD_ONE_DEAD = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HEAD_TWO_DEAD = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HEAD_THREE_DEAD = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HEAD_FOUR_DEAD = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HEAD_FIVE_DEAD = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HEAD_SIX_DEAD = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);

	private static final EntityDataAccessor<Boolean> HEAD_ONE_PARTICLES = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HEAD_TWO_PARTICLES = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HEAD_THREE_PARTICLES = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HEAD_FOUR_PARTICLES = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HEAD_FIVE_PARTICLES = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HEAD_SIX_PARTICLES = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);

	private static final EntityDataAccessor<Boolean> START_ATTACKING = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);

	private static final EntityDataAccessor<Boolean> AWAKE = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);
	
	private static final EntityDataAccessor<Boolean> PLAYED_DEATH_SOUND = SynchedEntityData.defineId(CorruptedTheropod.class, EntityDataSerializers.BOOLEAN);

	public int headOneAttackCooldown = 0;
	public int headTwoAttackCooldown = 0;
	public int headThreeAttackCooldown = 0;
	public int headFourAttackCooldown = 500;
	public int headFiveAttackCooldown = 0;
	public int headSixAttackCooldown = 0;
	public int allHeadAttackCooldown = 0;
	public int knockbackRoarAttackCooldown = 0;
	public int chargeAttackCooldown = 0;
	public int attackTimer = 75;
	private float sleepProgress = 0.0F;
	private float prevSleepProgress = 0.0F;
	private float meleeProgress = 0.0F;
	private float prevMeleeProgress = 0.0F;
	private int grabTicks = 0;
	public float ridingXZ;
	public float ridingY = 1F;
	public float targetDistance;

	private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.GREEN, BossEvent.BossBarOverlay.PROGRESS));
	private final CorruptedTheropodPart[] subEntities;
	private final CorruptedTheropodPart body;
	private final CorruptedTheropodPart head1;
	private final CorruptedTheropodPart snout1P1;
	private final CorruptedTheropodPart snout1P2;
	private final CorruptedTheropodPart head2;
	private final CorruptedTheropodPart snout2P1;
	private final CorruptedTheropodPart snout2P2;
	private final CorruptedTheropodPart snout2P3;
	private final CorruptedTheropodPart head3;
	private final CorruptedTheropodPart snout3P1;
	private final CorruptedTheropodPart snout3P2;
	private final CorruptedTheropodPart head4;
	private final CorruptedTheropodPart snout4P1;
	private final CorruptedTheropodPart snout4P2;
	private final CorruptedTheropodPart head5;
	private final CorruptedTheropodPart snout5P1;
	private final CorruptedTheropodPart head6;
	private final CorruptedTheropodPart snout6P1;
	private final CorruptedTheropodPart snout6P2;
	private final CorruptedTheropodPart tail1P1;
	private final CorruptedTheropodPart tail1P2;
	private final CorruptedTheropodPart tail1P3;
	private final CorruptedTheropodPart tail2P1;
	private final CorruptedTheropodPart tail2P2;
	private final CorruptedTheropodPart tail2P3;
	private final CorruptedTheropodPart tail2P4;

	public CorruptedTheropod(EntityType<? extends CorruptedTheropod> type, Level level) {
		super(type, level);
		this.body = new CorruptedTheropodPart(this, "body", 1.625F, 2);
		this.head1 = new CorruptedTheropodPart(this, "head1", 0.5625F, 0.8125F);
		this.snout1P1 = new CorruptedTheropodPart(this, "snout1P1", 0.5F, 0.6875F);
		this.snout1P2 = new CorruptedTheropodPart(this, "snout1P2", 0.5F, 0.6875F);
		this.head2 = new CorruptedTheropodPart(this, "head2", 0.5625F, 0.9375F);
		this.snout2P1 = new CorruptedTheropodPart(this, "snout2P1", 0.3125F, 0.8125F);
		this.snout2P2 = new CorruptedTheropodPart(this, "snout2P2", 0.3125F, 0.8125F);
		this.snout2P3 = new CorruptedTheropodPart(this, "snout2P3", 0.3125F, 0.8125F);
		this.head3 = new CorruptedTheropodPart(this, "head3", 0.75F, 0.9375F);
		this.snout3P1 = new CorruptedTheropodPart(this, "snout3P1", 0.5F, 0.8125F);
		this.snout3P2 = new CorruptedTheropodPart(this, "snout3P2", 0.5F, 0.8125F);
		this.head4 = new CorruptedTheropodPart(this, "head4", 0.3125F, 0.5F);
		this.snout4P1 = new CorruptedTheropodPart(this, "snout4P1", 0.3125F, 0.5F);
		this.snout4P2 = new CorruptedTheropodPart(this, "snout4P2", 0.3125F, 0.5F);
		this.head5 = new CorruptedTheropodPart(this, "head5", 0.625F, 0.9375F);
		this.snout5P1 = new CorruptedTheropodPart(this, "snout5P1", 0.625F, 0.9375F);
		this.head6 = new CorruptedTheropodPart(this, "head6", 0.3125F, 0.5F);
		this.snout6P1 = new CorruptedTheropodPart(this, "snout6P1", 0.3125F, 0.5F);
		this.snout6P2 = new CorruptedTheropodPart(this, "snout6P2", 0.3125F, 0.5F);
		this.tail1P1 = new CorruptedTheropodPart(this, "tail1P1", 0.75F, 1);
		this.tail1P2 = new CorruptedTheropodPart(this, "tail1P2", 0.75F, 1);
		this.tail1P3 = new CorruptedTheropodPart(this, "tail1P3", 0.75F, 1);
		this.tail2P1 = new CorruptedTheropodPart(this, "tail2P1", 0.5F, 0.5625F);
		this.tail2P2 = new CorruptedTheropodPart(this, "tail2P2", 0.5F, 0.5625F);
		this.tail2P3 = new CorruptedTheropodPart(this, "tail2P3", 0.5F, 0.5625F);
		this.tail2P4 = new CorruptedTheropodPart(this, "tail2P4", 0.5F, 0.5625F);
		this.subEntities = new CorruptedTheropodPart[] {this.body, this.head1, this.snout1P1, this.snout1P2, this.head2, this.snout2P1, this.snout2P2, this.snout2P3, this.head3, this.snout3P1, this.snout3P2, this.head4, this.snout4P1, this.snout4P2, this.head5, this.snout5P1, this.head6, this.snout6P1, this.snout6P2, this.tail1P1, this.tail1P2, this.tail1P3, this.tail2P1, this.tail2P2, this.tail2P3, this.tail2P4};
		this.setId(ENTITY_COUNTER.getAndAdd(this.subEntities.length + 1) + 1);
		super.setMaxUpStep(1);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 300).add(Attributes.ATTACK_DAMAGE, 8).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.KNOCKBACK_RESISTANCE, 200).add(Attributes.FOLLOW_RANGE, 70.0D);
	}

	@Override
	public boolean isPushable() {
		return isAwake();
	}

	public int getHeadOneHealth() {
		return entityData.get(HEAD_ONE_HEALTH);
	}

	public void setHeadOneHealth(int headOneHealth) {
		entityData.set(HEAD_ONE_HEALTH, headOneHealth);
	}

	public int getHeadTwoHealth() {
		return entityData.get(HEAD_TWO_HEALTH);
	}

	public void setHeadTwoHealth(int headTwoHealth) {
		entityData.set(HEAD_TWO_HEALTH, headTwoHealth);
	}

	public int getHeadThreeHealth() {
		return entityData.get(HEAD_THREE_HEALTH);
	}

	public void setHeadThreeHealth(int headThreeHealth) {
		entityData.set(HEAD_THREE_HEALTH, headThreeHealth);
	}

	public int getHeadFourHealth() {
		return entityData.get(HEAD_FOUR_HEALTH);
	}

	public void setHeadFourHealth(int headFourHealth) {
		entityData.set(HEAD_FOUR_HEALTH, headFourHealth);
	}

	public int getHeadFiveHealth() {
		return entityData.get(HEAD_FIVE_HEALTH);
	}

	public void setHeadFiveHealth(int headFiveHealth) {
		entityData.set(HEAD_FIVE_HEALTH, headFiveHealth);
	}

	public int getHeadSixHealth() {
		return entityData.get(HEAD_SIX_HEALTH);
	}

	public void setHeadSixHealth(int headSixHealth) {
		entityData.set(HEAD_SIX_HEALTH, headSixHealth);
	}

	public boolean isDoingHeadOneAttack() {
		return entityData.get(HEAD_ONE_ATTACK);
	}

	public void setDoingHeadOneAttack(boolean headOneAttack) {
		entityData.set(HEAD_ONE_ATTACK, headOneAttack);
	}

	public boolean isDoingHeadTwoAttack() {
		return entityData.get(HEAD_TWO_ATTACK);
	}

	public void setDoingHeadTwoAttack(boolean headTwoAttack) {
		entityData.set(HEAD_TWO_ATTACK, headTwoAttack);
	}

	public boolean isDoingHeadThreeAttack() {
		return entityData.get(HEAD_THREE_ATTACK);
	}

	public void setDoingHeadThreeAttack(boolean headThreeAttack) {
		entityData.set(HEAD_THREE_ATTACK, headThreeAttack);
	}

	public boolean isDoingHeadFourAttack() {
		return entityData.get(HEAD_FOUR_ATTACK);
	}

	public void setDoingHeadFourAttack(boolean headFourAttack) {
		entityData.set(HEAD_FOUR_ATTACK, headFourAttack);
	}

	public boolean isDoingHeadFiveAttack() {
		return entityData.get(HEAD_FIVE_ATTACK);
	}

	public void setDoingHeadFiveAttack(boolean headFiveAttack) {
		entityData.set(HEAD_FIVE_ATTACK, headFiveAttack);
	}

	public boolean isDoingHeadSixAttack() {
		return entityData.get(HEAD_SIX_ATTACK);
	}

	public void setDoingHeadSixAttack(boolean headSixAttack) {
		entityData.set(HEAD_SIX_ATTACK, headSixAttack);
	}

	public boolean isDoingAllHeadAttack() {
		return entityData.get(ALL_HEAD_ATTACK);
	}

	public void setDoingAllHeadAttack(boolean allHeadAttack) {
		entityData.set(ALL_HEAD_ATTACK, allHeadAttack);
	}

	public boolean isDoingKnockbackRoarAttack() {
		return entityData.get(KNOCKBACK_ROAR_ATTACK);
	}

	public void setDoingKnockbackRoarAttack(boolean knockbackRoarAttack) {
		entityData.set(KNOCKBACK_ROAR_ATTACK, knockbackRoarAttack);
	}

	public boolean isDoingChargeAttack() {
		return entityData.get(CHARGE_ATTACK);
	}

	public void setDoingChargeAttack(boolean chargeAttack) {
		entityData.set(CHARGE_ATTACK, chargeAttack);
	}

	public boolean isHeadOneDead() {
		return entityData.get(HEAD_ONE_DEAD);
	}

	public void setHeadOneDead(boolean headOneDead) {
		entityData.set(HEAD_ONE_DEAD, headOneDead);
	}

	public boolean isHeadTwoDead() {
		return entityData.get(HEAD_TWO_DEAD);
	}

	public void setHeadTwoDead(boolean headTwoDead) {
		entityData.set(HEAD_TWO_DEAD, headTwoDead);
	}

	public boolean isHeadThreeDead() {
		return entityData.get(HEAD_THREE_DEAD);
	}

	public void setHeadThreeDead(boolean headThreeDead) {
		entityData.set(HEAD_THREE_DEAD, headThreeDead);
	}

	public boolean isHeadFourDead() {
		return entityData.get(HEAD_FOUR_DEAD);
	}

	public void setHeadFourDead(boolean headFourDead) {
		entityData.set(HEAD_FOUR_DEAD, headFourDead);
	}

	public boolean isHeadFiveDead() {
		return entityData.get(HEAD_FIVE_DEAD);
	}

	public void setHeadFiveDead(boolean headFiveDead) {
		entityData.set(HEAD_FIVE_DEAD, headFiveDead);
	}

	public boolean isHeadSixDead() {
		return entityData.get(HEAD_SIX_DEAD);
	}

	public void setHeadSixDead(boolean headSixDead) {
		entityData.set(HEAD_SIX_DEAD, headSixDead);
	}

	public boolean isAwake() {
		return entityData.get(AWAKE);
	}

	public void setAwake(boolean isAwake) {
		entityData.set(AWAKE, isAwake);
	}
	
	public boolean playedDeathSound() {
		return entityData.get(PLAYED_DEATH_SOUND);
	}

	public void setPlayedDeathSound(boolean playedDeathSound) {
		entityData.set(PLAYED_DEATH_SOUND, playedDeathSound);
	}

	public boolean hasFiredHeadOneParticles() {
		return entityData.get(HEAD_ONE_PARTICLES);
	}

	public void setFiringHeadOneParticles(boolean firingHeadOneParticles) {
		entityData.set(HEAD_ONE_PARTICLES, firingHeadOneParticles);
	}

	public boolean hasFiredHeadTwoParticles() {
		return entityData.get(HEAD_TWO_PARTICLES);
	}

	public void setFiringHeadTwoParticles(boolean firingHeadTwoParticles) {
		entityData.set(HEAD_TWO_PARTICLES, firingHeadTwoParticles);
	}

	public boolean hasFiredHeadThreeParticles() {
		return entityData.get(HEAD_THREE_PARTICLES);
	}

	public void setFiringHeadThreeParticles(boolean firingHeadThreeParticles) {
		entityData.set(HEAD_THREE_PARTICLES, firingHeadThreeParticles);
	}

	public boolean hasFiredHeadFourParticles() {
		return entityData.get(HEAD_FOUR_PARTICLES);
	}

	public void setFiringHeadFourParticles(boolean firingHeadFourParticles) {
		entityData.set(HEAD_FOUR_PARTICLES, firingHeadFourParticles);
	}

	public boolean hasFiredHeadFiveParticles() {
		return entityData.get(HEAD_FIVE_PARTICLES);
	}

	public void setFiringHeadFiveParticles(boolean firingHeadFiveParticles) {
		entityData.set(HEAD_FIVE_PARTICLES, firingHeadFiveParticles);
	}

	public boolean hasFiredHeadSixParticles() {
		return entityData.get(HEAD_SIX_PARTICLES);
	}

	public void setFiringHeadSixParticles(boolean firingHeadSixParticles) {
		entityData.set(HEAD_SIX_PARTICLES, firingHeadSixParticles);
	}

	public boolean canStartAttacking() {
		return entityData.get(START_ATTACKING);
	}

	public void setStartAttacking(boolean canStartAttacking) {
		entityData.set(START_ATTACKING, canStartAttacking);
	}

	public void setTransititionToPose() {
		this.entityData.set(SLEEP_TICK, 15);
	}
	
	protected SoundEvent getAmbientSound() {
		if (!this.isAwake() ) {
			return null;
		} else return PFSounds.BOSS_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.BOSS_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.BOSS_DEATH.get();
	}

	@SuppressWarnings("deprecation")
	protected void playStepSound(BlockPos pos, BlockState state) {
		if (this.isBaby()) {
			if (!state.liquid()) {
				BlockState blockstate = this.level().getBlockState(pos.above());
				SoundType soundtype = blockstate.is(Blocks.SNOW) ? blockstate.getSoundType(level(), pos, this) : state.getSoundType(level(), pos, this);
				this.playSound(soundtype.getStepSound(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
		} else {
			this.playSound(PFSounds.BOSS_WALK.get(), 0.15F, 1F);
		}
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, 0, true, false, null));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(0, new HeadOneAttackGoal());
		this.goalSelector.addGoal(0, new HeadTwoAttackGoal());
		this.goalSelector.addGoal(0, new HeadThreeAttackGoal());
		this.goalSelector.addGoal(0, new HeadFourAttackGoal());
		this.goalSelector.addGoal(0, new HeadFiveAttackGoal());
		this.goalSelector.addGoal(0, new HeadSixAttackGoal());
		this.goalSelector.addGoal(0, new HeadAllAttackGoal());
		this.goalSelector.addGoal(0, new KnockbackRoarAttackGoal());
		this.goalSelector.addGoal(0, new ChargeAttackGoal());
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean requiresCustomPersistence() {
		return true;
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		entityData.define(HEAD_ONE_HEALTH, 50);
		entityData.define(HEAD_TWO_HEALTH, 50);
		entityData.define(HEAD_THREE_HEALTH, 50);
		entityData.define(HEAD_FOUR_HEALTH, 50);
		entityData.define(HEAD_FIVE_HEALTH, 50);
		entityData.define(HEAD_SIX_HEALTH, 50);
		entityData.define(HEAD_ONE_ATTACK, false);
		entityData.define(HEAD_TWO_ATTACK, false);
		entityData.define(HEAD_THREE_ATTACK, false);
		entityData.define(HEAD_FOUR_ATTACK, false);
		entityData.define(HEAD_FIVE_ATTACK, false);
		entityData.define(HEAD_SIX_ATTACK, false);
		entityData.define(ALL_HEAD_ATTACK, false);
		entityData.define(KNOCKBACK_ROAR_ATTACK, false);
		entityData.define(CHARGE_ATTACK, false);
		entityData.define(HEAD_ONE_DEAD, false);
		entityData.define(HEAD_TWO_DEAD, false);
		entityData.define(HEAD_THREE_DEAD, false);
		entityData.define(HEAD_FOUR_DEAD, false);
		entityData.define(HEAD_FIVE_DEAD, false);
		entityData.define(HEAD_SIX_DEAD, false);
		entityData.define(AWAKE, false);
		entityData.define(HEAD_ONE_PARTICLES, false);
		entityData.define(HEAD_TWO_PARTICLES, false);
		entityData.define(HEAD_THREE_PARTICLES, false);
		entityData.define(HEAD_FOUR_PARTICLES, false);
		entityData.define(HEAD_FIVE_PARTICLES, false);
		entityData.define(HEAD_SIX_PARTICLES, false);
		entityData.define(START_ATTACKING, false);
		entityData.define(PLAYED_DEATH_SOUND, false);
		this.entityData.define(ATTACK_TICK, 0);
		this.entityData.define(SLEEP_TICK, 0);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("HeadOneHealth", this.getHeadOneHealth());
		compound.putInt("HeadTwoHealth", this.getHeadTwoHealth());
		compound.putInt("HeadThreeHealth", this.getHeadThreeHealth());
		compound.putInt("HeadFourHealth", this.getHeadFourHealth());
		compound.putInt("HeadFiveHealth", this.getHeadFiveHealth());
		compound.putInt("HeadSixHealth", this.getHeadSixHealth());
		compound.putBoolean("HeadOneDead", this.isHeadOneDead());
		compound.putBoolean("HeadTwoDead", this.isHeadTwoDead());
		compound.putBoolean("HeadThreeDead", this.isHeadThreeDead());
		compound.putBoolean("HeadFourDead", this.isHeadFourDead());
		compound.putBoolean("HeadFiveDead", this.isHeadFiveDead());
		compound.putBoolean("HeadSixDead", this.isHeadSixDead());
		compound.putBoolean("HeadOneParticles", hasFiredHeadOneParticles());
		compound.putBoolean("HeadTwoParticles", hasFiredHeadTwoParticles());
		compound.putBoolean("HeadThreeParticles", hasFiredHeadThreeParticles());
		compound.putBoolean("HeadFourParticles", hasFiredHeadFourParticles());
		compound.putBoolean("HeadFiveParticles", hasFiredHeadFiveParticles());
		compound.putBoolean("HeadSixParticles", hasFiredHeadSixParticles());
		compound.putBoolean("IsAwake", this.isAwake());
		compound.putBoolean("PlayedDeathSound", playedDeathSound());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (this.hasCustomName()) {
			this.bossEvent.setName(this.getDisplayName());
		}
		this.setHeadOneHealth(compound.getInt("HeadOneHealth"));
		this.setHeadTwoHealth(compound.getInt("HeadTwoHealth"));
		this.setHeadThreeHealth(compound.getInt("HeadThreeHealth"));
		this.setHeadFourHealth(compound.getInt("HeadFourHealth"));
		this.setHeadFiveHealth(compound.getInt("HeadFiveHealth"));
		this.setHeadSixHealth(compound.getInt("HeadSixHealth"));
		this.setHeadOneDead(compound.getBoolean("HeadOneDead"));
		this.setHeadTwoDead(compound.getBoolean("HeadTwoDead"));
		this.setHeadThreeDead(compound.getBoolean("HeadThreeDead"));
		this.setHeadFourDead(compound.getBoolean("HeadFourDead"));
		this.setHeadFiveDead(compound.getBoolean("HeadFiveDead"));
		this.setHeadSixDead(compound.getBoolean("HeadSixDead"));
		setFiringHeadOneParticles(compound.getBoolean("HeadOneParticles"));
		setFiringHeadTwoParticles(compound.getBoolean("HeadTwoParticles"));
		setFiringHeadThreeParticles(compound.getBoolean("HeadThreeParticles"));
		setFiringHeadFourParticles(compound.getBoolean("HeadFourParticles"));
		setFiringHeadFiveParticles(compound.getBoolean("HeadFiveParticles"));
		setFiringHeadSixParticles(compound.getBoolean("HeadSixParticles"));
		this.setAwake(compound.getBoolean("IsAwake"));
		setPlayedDeathSound(compound.getBoolean("PlayedDeathSound"));
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

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
		return null;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.CORRUPTED_THEROPOD_SPAWN_EGG.get());
	}

	@Override
	public void setId(int pId) {
		super.setId(pId);
		for (int i = 0; i < this.subEntities.length; i++) this.subEntities[i].setId(pId + i + 1);
	}

	@Override
	public void recreateFromPacket(ClientboundAddEntityPacket packet) {
		super.recreateFromPacket(packet);
		CorruptedTheropodPart[] parts = this.getSubEntities();
		for (int i = 0; i < parts.length; ++i) {
			parts[i].setId(i + packet.getId());
		}
	}

	@Override
	public boolean isMultipartEntity() {
		return true;
	}

	@Override
	public PartEntity<?>[] getParts() {
		return this.subEntities;
	}

	public CorruptedTheropodPart[] getSubEntities() {
		return this.subEntities;
	}

	protected void movePart(CorruptedTheropodPart part, double dX, double dY, double dZ) {
		Vec3 lastPos = new Vec3(part.getX(), part.getY(), part.getZ());
		part.setPos(this.getX() + dX, this.getY() + dY, this.getZ() + dZ);
		part.xo = lastPos.x;
		part.yo = lastPos.y;
		part.zo = lastPos.z;
		part.xOld = lastPos.x;
		part.yOld = lastPos.y;
		part.zOld = lastPos.z;
	}

	protected void updateParts() {
		Vec3 body = new Vec3(0, 2.2, 2).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head1 = new Vec3(-0.7, 3.6, 3.5).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout1P1 = new Vec3(-0.8, 3.65, 4).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout1P2 = new Vec3(-0.85, 3.65, 4.5).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head2 = new Vec3(-0.55, 2.55, 3.8).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout2P1 = new Vec3(-0.6, 2.65, 4.2).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout2P2 = new Vec3(-0.65, 2.65, 4.55).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout2P3 = new Vec3(-0.7, 2.65, 4.85).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head3 = new Vec3(0.18, 3.17, 4.02).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout3P1 = new Vec3(0.18, 3.17, 4.6).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout3P2 = new Vec3(0.18, 3.17, 5).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head4 = new Vec3(0.03, 2.43, 3.7).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout4P1 = new Vec3(0.03, 2.43, 4).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout4P2 = new Vec3(0.03, 2.43, 4.3).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head5 = new Vec3(0.7, 3.27, 3.5).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout5P1 = new Vec3(1, 3.27, 4.1).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head6 = new Vec3(0.45, 2.62, 3.3).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout6P1 = new Vec3(0.55, 2.62, 3.62).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout6P2 = new Vec3(0.65, 2.62, 3.94).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 tail1P1 = new Vec3(0, 3.1, -1.3).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 tail1P2 = new Vec3(0, 3, -2.05).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 tail1P3 = new Vec3(0, 2.9, -2.45).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 tail2P1 = new Vec3(0, 3.1, -3.1).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 tail2P2 = new Vec3(0, 3.05, -3.6).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 tail2P3 = new Vec3(0, 3, -4.1).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 tail2P4 = new Vec3(0, 2.95, -4.6).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 defaultLocation = Vec3.ZERO;
		Vec3 bodySleeping = new Vec3(0, 1.2, 2).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head1Sleeping = new Vec3(-0.2, 1.7, 4).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout1P1Sleeping = new Vec3(-0.1, 1.5, 4.5).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout1P2Sleeping = new Vec3(-0.1, 1.3, 4.7).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head2Sleeping = new Vec3(-0.25, 0.8, 3.6).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout2P1Sleeping = new Vec3(-0, 0.6, 4).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout2P2Sleeping = new Vec3(-0, 0.4, 4.4).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout2P3Sleeping = new Vec3(0, 0, 0).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head3Sleeping = new Vec3(0, 0, 0).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout3P1Sleeping = new Vec3(0.8, 1.17, 4).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout3P2Sleeping = new Vec3(1, 0.87, 4.5).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head4Sleeping = new Vec3(0.3, 0.73, 3).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout4P1Sleeping = new Vec3(0.4, 0.53, 3.3).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout4P2Sleeping = new Vec3(0, 0, 0).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head5Sleeping = new Vec3(1, 1.77, 3).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout5P1Sleeping = new Vec3(1.6, 1.47, 3.6).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head6Sleeping = new Vec3(0.8, 1.12, 2.8).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout6P1Sleeping = new Vec3(1, 0.9, 3.1).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 snout6P2Sleeping = new Vec3(0, 0, 0).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 tail1P1Sleeping = new Vec3(0.5, 1.1, -1.3).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 tail1P2Sleeping = new Vec3(0.9, 0.8, -2.05).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 tail1P3Sleeping = new Vec3(0, 0, 0).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 tail2P1Sleeping = new Vec3(1.6, 0.6, -2.4).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 tail2P2Sleeping = new Vec3(2.1, 0.2, -2.6).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 tail2P3Sleeping = new Vec3(2.6, 0.1, -2.9).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 tail2P4Sleeping = new Vec3(0, 0, 0).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		if (isAwake()) {
			if (isHeadOneDead()) {
				movePart(this.head1, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout1P1, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout1P2, defaultLocation.x, defaultLocation.y, defaultLocation.z);
			} else {
				movePart(this.head1, head1.x, head1.y, head1.z);
				movePart(this.snout1P1, snout1P1.x, snout1P1.y, snout1P1.z);
				movePart(this.snout1P2, snout1P2.x, snout1P2.y, snout1P2.z);
			}
			if (isHeadTwoDead()) {
				movePart(this.head2, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout2P1, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout2P2, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout2P3, defaultLocation.x, defaultLocation.y, defaultLocation.z);
			} else {
				movePart(this.head2, head2.x, head2.y, head2.z);
				movePart(this.snout2P1, snout2P1.x, snout2P1.y, snout2P1.z);
				movePart(this.snout2P2, snout2P2.x, snout2P2.y, snout2P2.z);
				movePart(this.snout2P3, snout2P3.x, snout2P3.y, snout2P3.z);
			}
			if (isHeadThreeDead()) {
				movePart(this.head3, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout3P1, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout3P2, defaultLocation.x, defaultLocation.y, defaultLocation.z);
			} else {
				movePart(this.head3, head3.x, head3.y, head3.z);
				movePart(this.snout3P1, snout3P1.x, snout3P1.y, snout3P1.z);
				movePart(this.snout3P2, snout3P2.x, snout3P2.y, snout3P2.z);
			}
			if (isHeadFourDead()) {
				movePart(this.head4, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout4P1, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout4P2, defaultLocation.x, defaultLocation.y, defaultLocation.z);
			} else {
				movePart(this.head4, head4.x, head4.y, head4.z);
				movePart(this.snout4P1, snout4P1.x, snout4P1.y, snout4P1.z);
				movePart(this.snout4P2, snout4P2.x, snout4P2.y, snout4P2.z);
			}
			if (isHeadFiveDead()) {
				movePart(this.head5, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout5P1, defaultLocation.x, defaultLocation.y, defaultLocation.z);
			} else {
				movePart(this.head5, head5.x, head5.y, head5.z);
				movePart(this.snout5P1, snout5P1.x, snout5P1.y, snout5P1.z);
			}
			if (isHeadSixDead()) {
				movePart(this.head6, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout6P1, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout6P2, defaultLocation.x, defaultLocation.y, defaultLocation.z);
			} else {
				movePart(this.head6, head6.x, head6.y, head6.z);
				movePart(this.snout6P1, snout6P1.x, snout6P1.y, snout6P1.z);
				movePart(this.snout6P2, snout6P2.x, snout6P2.y, snout6P2.z);
			}
			movePart(this.body, body.x, body.y, body.z);
			movePart(this.tail1P1, tail1P1.x, tail1P1.y, tail1P1.z);
			movePart(this.tail1P2, tail1P2.x, tail1P2.y, tail1P2.z);
			movePart(this.tail1P3, tail1P3.x, tail1P3.y, tail1P3.z);
			movePart(this.tail2P1, tail2P1.x, tail2P1.y, tail2P1.z);
			movePart(this.tail2P2, tail2P2.x, tail2P2.y, tail2P2.z);
			movePart(this.tail2P3, tail2P3.x, tail2P3.y, tail2P3.z);
			movePart(this.tail2P4, tail2P4.x, tail2P4.y, tail2P4.z);
		} else {
			if (isHeadOneDead()) {
				movePart(this.head1, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout1P1, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout1P2, defaultLocation.x, defaultLocation.y, defaultLocation.z);
			} else {
				movePart(this.head1, head1Sleeping.x, head1Sleeping.y, head1Sleeping.z);
				movePart(this.snout1P1, snout1P1Sleeping.x, snout1P1Sleeping.y, snout1P1Sleeping.z);
				movePart(this.snout1P2, snout1P2Sleeping.x, snout1P2Sleeping.y, snout1P2Sleeping.z);
			}
			if (isHeadTwoDead()) {
				movePart(this.head2, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout2P1, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout2P2, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout2P3, defaultLocation.x, defaultLocation.y, defaultLocation.z);
			} else {
				movePart(this.head2, head2Sleeping.x, head2Sleeping.y, head2Sleeping.z);
				movePart(this.snout2P1, snout2P1Sleeping.x, snout2P1Sleeping.y, snout2P1Sleeping.z);
				movePart(this.snout2P2, snout2P2Sleeping.x, snout2P2Sleeping.y, snout2P2Sleeping.z);
				movePart(this.snout2P3, snout2P3Sleeping.x, snout2P3Sleeping.y, snout2P3Sleeping.z);
			}
			if (isHeadThreeDead()) {
				movePart(this.head3, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout3P1, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout3P2, defaultLocation.x, defaultLocation.y, defaultLocation.z);
			} else {
				movePart(this.head3, head3Sleeping.x, head3Sleeping.y, head3Sleeping.z);
				movePart(this.snout3P1, snout3P1Sleeping.x, snout3P1Sleeping.y, snout3P1Sleeping.z);
				movePart(this.snout3P2, snout3P2Sleeping.x, snout3P2Sleeping.y, snout3P2Sleeping.z);
			}
			if (isHeadFourDead()) {
				movePart(this.head4, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout4P1, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout4P2, defaultLocation.x, defaultLocation.y, defaultLocation.z);
			} else {
				movePart(this.head4, head4Sleeping.x, head4Sleeping.y, head4Sleeping.z);
				movePart(this.snout4P1, snout4P1Sleeping.x, snout4P1Sleeping.y, snout4P1Sleeping.z);
				movePart(this.snout4P2, snout4P2Sleeping.x, snout4P2Sleeping.y, snout4P2Sleeping.z);
			}
			if (isHeadFiveDead()) {
				movePart(this.head5, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout5P1, defaultLocation.x, defaultLocation.y, defaultLocation.z);
			} else {
				movePart(this.head5, head5Sleeping.x, head5Sleeping.y, head5Sleeping.z);
				movePart(this.snout5P1, snout5P1Sleeping.x, snout5P1Sleeping.y, snout5P1Sleeping.z);
			}
			if (isHeadSixDead()) {
				movePart(this.head6, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout6P1, defaultLocation.x, defaultLocation.y, defaultLocation.z);
				movePart(this.snout6P2, defaultLocation.x, defaultLocation.y, defaultLocation.z);
			} else {
				movePart(this.head6, head6Sleeping.x, head6Sleeping.y, head6Sleeping.z);
				movePart(this.snout6P1, snout6P1Sleeping.x, snout6P1Sleeping.y, snout6P1Sleeping.z);
				movePart(this.snout6P2, snout6P2Sleeping.x, snout6P2Sleeping.y, snout6P2Sleeping.z);
			}
			movePart(this.body, bodySleeping.x, bodySleeping.y, bodySleeping.z);
			movePart(this.tail1P1, tail1P1Sleeping.x, tail1P1Sleeping.y, tail1P1Sleeping.z);
			movePart(this.tail1P2, tail1P2Sleeping.x, tail1P2Sleeping.y, tail1P2Sleeping.z);
			movePart(this.tail1P3, tail1P3Sleeping.x, tail1P3Sleeping.y, tail1P3Sleeping.z);
			movePart(this.tail2P1, tail2P1Sleeping.x, tail2P1Sleeping.y, tail2P1Sleeping.z);
			movePart(this.tail2P2, tail2P2Sleeping.x, tail2P2Sleeping.y, tail2P2Sleeping.z);
			movePart(this.tail2P3, tail2P3Sleeping.x, tail2P3Sleeping.y, tail2P3Sleeping.z);
			movePart(this.tail2P4, tail2P4Sleeping.x, tail2P4Sleeping.y, tail2P4Sleeping.z);
		}
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (this.isVehicle()) {
			this.ejectPassengers();
		}
		return super.hurt(source, amount);
	}

	public boolean damagePart(CorruptedTheropodPart part, DamageSource source, float damage) {
		if (part == this.head1 || part == this.snout1P1 || part == this.snout1P2) {
			if (!isHeadOneDead()) {
				if (this.getHeadOneHealth() - (int) damage < 0) {
					float overflow = damage - this.getHeadOneHealth();
					this.setHeadOneHealth(0);
					this.setHeadOneDead(true);
					return hurt(source, overflow);
				} else {
					this.setHeadOneHealth(this.getHeadOneHealth() - (int) damage);
					return hurt(source, damage);
				}
			} else return false;
		} else if (part == this.head2 || part == this.snout2P1 || part == this.snout2P2 || part == this.snout2P3) {
			if (!isHeadTwoDead()) {
				if (this.getHeadTwoHealth() - (int) damage < 0) {
					float overflow = damage - this.getHeadTwoHealth();
					this.setHeadTwoHealth(0);
					this.setHeadTwoDead(true);
					return hurt(source, overflow);
				} else {
					this.setHeadTwoHealth(this.getHeadTwoHealth() - (int) damage);
					return hurt(source, damage);
				}
			} else return false;
		} else if (part == this.head3 || part == this.snout3P1 || part == this.snout3P2) {
			if (!isHeadThreeDead()) {
				if (this.getHeadThreeHealth() - (int) damage < 0) {
					float overflow = damage - this.getHeadThreeHealth();
					this.setHeadThreeHealth(0);
					this.setHeadThreeDead(true);
					return hurt(source, overflow);
				} else {
					this.setHeadThreeHealth(this.getHeadThreeHealth() - (int) damage);
					return hurt(source, damage);
				}
			} else return false;
		} else if (part == this.head4 || part == this.snout4P1 || part == this.snout4P2) {
			if (!isHeadFourDead()) {
				if (this.getHeadFourHealth() - (int) damage < 0) {
					float overflow = damage - this.getHeadFourHealth();
					this.setHeadFourHealth(0);
					this.setHeadFourDead(true);
					return hurt(source, overflow);
				} else {
					this.setHeadFourHealth(this.getHeadFourHealth() - (int) damage);
					return hurt(source, damage);
				}
			} else return false;
		} else if (part == this.head5 || part == this.snout5P1) {
			if (!isHeadFiveDead()) {
				if (this.getHeadFiveHealth() - (int) damage < 0) {
					float overflow = damage - this.getHeadFiveHealth();
					this.setHeadFiveHealth(0);
					this.setHeadFiveDead(true);
					return hurt(source, overflow);
				} else {
					this.setHeadFiveHealth(this.getHeadFiveHealth() - (int) damage);
					return hurt(source, damage);
				}
			} else return false;
		} else if (part == this.head6 || part == this.snout6P1 || part == this.snout6P2) {
			if (!isHeadSixDead()) {
				if (this.getHeadSixHealth() - (int) damage < 0) {
					float overflow = damage - this.getHeadSixHealth();
					this.setHeadSixHealth(0);
					this.setHeadSixDead(true);
					return hurt(source, overflow);
				} else {
					this.setHeadSixHealth(this.getHeadSixHealth() - (int) damage);
					return hurt(source, damage);
				}
			} else return false;
		} else {
			return hurt(source, damage);
		}
	}

	@Override
	public void aiStep() {
		super.aiStep();
		updateParts();
		if (this.getFirstPassenger() != null) {
			grabTicks++;
			if (grabTicks == 75) {
				this.getFirstPassenger().stopRiding();
				this.headThreeAttackCooldown = 25;
				this.grabTicks = 0;
			}
		}
		if (this.isDeadOrDying() && !playedDeathSound()) {
            this.playSound(PFSounds.BOSS_SPEECH.get(), 1.0F, 1.0F);
            setPlayedDeathSound(true);
		}
		Vec3 head1 = new Vec3(-0.7, 3.6, 3.5).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head2 = new Vec3(-0.55, 2.55, 3.8).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head3 = new Vec3(0.18, 3.17, 4.02).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head4 = new Vec3(0.03, 2.43, 3.7).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head5 = new Vec3(0.7, 3.27, 3.5).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		Vec3 head6 = new Vec3(0.45, 2.62, 3.3).xRot(-getXRot() * ((float) Math.PI / 180f)).yRot(-yBodyRot * ((float) Math.PI / 180f));
		if (isHeadOneDead() && !hasFiredHeadOneParticles()) {
			level().addParticle(ParticleTypes.EXPLOSION, this.getX() + head1.x, this.getY() + head1.y, this.getZ() + head1.z, 0, 0, 0);
			setFiringHeadOneParticles(true);
		}
		if (isHeadTwoDead() && !hasFiredHeadTwoParticles()) {
			level().addParticle(ParticleTypes.EXPLOSION, this.getX() + head2.x, this.getY() + head2.y, this.getZ() + head2.z, 0, 0, 0);
			setFiringHeadTwoParticles(true);
		}
		if (isHeadThreeDead() && !hasFiredHeadThreeParticles()) {
			level().addParticle(ParticleTypes.EXPLOSION, this.getX() + head3.x, this.getY() + head3.y, this.getZ() + head3.z, 0, 0, 0);
			setFiringHeadThreeParticles(true);
		}
		if (isHeadFourDead() && !hasFiredHeadFourParticles()) {
			level().addParticle(ParticleTypes.EXPLOSION, this.getX() + head4.x, this.getY() + head4.y, this.getZ() + head4.z, 0, 0, 0);
			setFiringHeadFourParticles(true);
		}
		if (isHeadFiveDead() && !hasFiredHeadFiveParticles()) {
			level().addParticle(ParticleTypes.EXPLOSION, this.getX() + head5.x, this.getY() + head5.y, this.getZ() + head5.z, 0, 0, 0);
			setFiringHeadFiveParticles(true);
		}
		if (isHeadSixDead() && !hasFiredHeadSixParticles()) {
			level().addParticle(ParticleTypes.EXPLOSION, this.getX() + head6.x, this.getY() + head6.y, this.getZ() + head6.z, 0, 0, 0);
			setFiringHeadSixParticles(true);
		}
		if (this.getTarget() != null) {
			if (!this.canStartAttacking() && !this.isDoingAllHeadAttack() && !isDoingHeadOneAttack() && !isDoingHeadTwoAttack() && !isDoingHeadThreeAttack() && !isDoingHeadFourAttack() && !isDoingHeadFiveAttack() && !isDoingHeadSixAttack()) attackTimer--;
			if (attackTimer == 0) {
				setStartAttacking(true);
			}
			if (this.getTarget().getY() > this.getY()) {
				setDoingKnockbackRoarAttack(true);
			}
			if (headFourAttackCooldown == 0 && !isHeadFourDead()) {
				setDoingHeadFourAttack(true);
				headFourAttackCooldown = 500;
			}
			if (this.getTarget().distanceTo(this) > 10 && this.chargeAttackCooldown == 0) {
				this.setDoingChargeAttack(true);
				chargeAttackCooldown = 500;
			}
			if (this.canStartAttacking()) {
				int attack = random.nextInt(7);
				if (attack == 0) {
					if (allHeadAttackCooldown == 0 && !isHeadOneDead() && !isHeadTwoDead() && !isHeadThreeDead() && !isHeadFourDead() && !isHeadFiveDead() && !isHeadSixDead()) {
						setDoingAllHeadAttack(true);
						attackTimer = 25;
						this.setStartAttacking(false);
					} else {
						attack = 1;
					}
				} else if (attack == 1) {
					if (headOneAttackCooldown == 0 && !isHeadOneDead()) {
						setDoingHeadOneAttack(true);
						attackTimer = 25;
						this.setStartAttacking(false);
					} else attack = 2;
				} else if (attack == 2) {
					if (headTwoAttackCooldown == 0 && !isHeadTwoDead()) {
						setDoingHeadTwoAttack(true);
						attackTimer = 25;
						this.setStartAttacking(false);
					} else attack = 3;
				} else if (attack == 3) {
					if (headThreeAttackCooldown == 0 && !isHeadThreeDead()) {
						setDoingHeadThreeAttack(true);
						attackTimer = 25;
						this.setStartAttacking(false);
					} else attack = 4;
				} else if (attack == 4) {
					if (headFourAttackCooldown == 0 && !isHeadFourDead()) {
						setDoingHeadFourAttack(true);
						attackTimer = 25;
						this.setStartAttacking(false);
					} else attack = 5;
				} else if (attack == 5) {
					if (headFiveAttackCooldown == 0 && !isHeadFiveDead()) {
						setDoingHeadFiveAttack(true);
						attackTimer = 25;
						this.setStartAttacking(false);
					} else attack = 6;
				} else if (attack == 6) {
					if (headSixAttackCooldown == 0 && !isHeadSixDead()) {
						setDoingHeadSixAttack(true);
						attackTimer = 25;
						this.setStartAttacking(false);
					} else attack = 0;
				}
			}
			if (attackTimer < -10) attackTimer = 25;
		}
		if (this.getTarget() == null) {
			if (attackTimer != 25 || attackTimer < -10) {
				attackTimer = 25;		
			}
		}
		if (!isAwake()) {
			setDeltaMovement(0, getDeltaMovement().y, 0);
			yRot = yRotO;
			//			if (this.getHealth() < this.getMaxHealth()) {
			//				if ((this.getHealth() + 2) > this.getMaxHealth()) {
			//					this.setHealth(this.getMaxHealth());
			//				} else this.setHealth(this.getHealth() + 2);
			//			}
		}
		if (allHeadAttackCooldown > 0) {
			allHeadAttackCooldown--;
		}
		if (allHeadAttackCooldown < 0) {
			allHeadAttackCooldown = 0;
		}
		if (headOneAttackCooldown > 0) {
			headOneAttackCooldown--;
		}
		if (headOneAttackCooldown < 0) {
			headOneAttackCooldown = 0;
		}
		if (headTwoAttackCooldown > 0) {
			headTwoAttackCooldown--;
		}
		if (headTwoAttackCooldown < 0) {
			headTwoAttackCooldown = 0;
		}
		if (headThreeAttackCooldown > 0) {
			headThreeAttackCooldown--;
		}
		if (headThreeAttackCooldown < 0) {
			headThreeAttackCooldown = 0;
		}
		if (headFourAttackCooldown > 0 && !this.isDoingHeadFourAttack()) {
			headFourAttackCooldown--;
		}
		if (headFourAttackCooldown < 0) {
			headFourAttackCooldown = 500;
		}
		if (chargeAttackCooldown > 0 && !this.isDoingChargeAttack()) {
			chargeAttackCooldown--;
		}
		if (chargeAttackCooldown < 0) {
			chargeAttackCooldown = 500;
		}
		if (headFiveAttackCooldown > 0) {
			headFiveAttackCooldown--;
		}
		if (headFiveAttackCooldown < 0) {
			headFiveAttackCooldown = 0;
		}
		if (headSixAttackCooldown > 0) {
			headSixAttackCooldown--;
		}
		if (headSixAttackCooldown < 0) {
			headSixAttackCooldown = 0;
		}
	}

	class HeadTwoAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public HeadTwoAttackGoal() {
			super(CorruptedTheropod.this, 1.25D, true);
		}

		public boolean canUse() {
			return super.canUse() && CorruptedTheropod.this.isDoingHeadTwoAttack();
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				CorruptedTheropod.this.playSound(PFSounds.BOSS_BITE.get(), 1.0F, CorruptedTheropod.this.getVoicePitch());
				this.mob.doHurtTarget(enemy);
				CorruptedTheropod.this.setDoingHeadTwoAttack(false);
				enemy.addEffect(new MobEffectInstance(PFEffects.BLEEDING.get(), 300, 0, true, false));
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}
			} else {
				this.resetAttackCooldown();
			}

		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && CorruptedTheropod.this.isDoingHeadTwoAttack() && !CorruptedTheropod.this.isHeadTwoDead();
		}

		public void stop() {
			super.stop();
			CorruptedTheropod.this.setDoingHeadTwoAttack(false);
			CorruptedTheropod.this.headTwoAttackCooldown = 25;
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(50.0F + attackTarget.getBbWidth());
		}
	}

	public boolean doHurtTarget(Entity entityIn) {
		this.entityData.set(ATTACK_TICK, 7);
		return true;
	}

	public boolean onAttackAnimationFinish(Entity target) {
		return target.hurt(this.damageSources().mobAttack(this), (float) ((int) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue()));
	}

	public boolean onAttackAnimationFinishExtraDamage(Entity target) {
		return target.hurt(this.damageSources().mobAttack(this), (float) ((int) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue() + 4));
	}

	public boolean onAttackAnimationFinishMassiveDamage(Entity target) {
		return target.hurt(this.damageSources().mobAttack(this), (float) ((int) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue() * 2));
	}

	public boolean onAttackAnimationFinishLessDamage(Entity target) {
		return target.hurt(this.damageSources().mobAttack(this), (float) ((int) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue() - 3));
	}

	public float getSleepProgress(float partialTick) {
		return prevSleepProgress + (sleepProgress - prevSleepProgress) * partialTick;
	}

	//lerped number from 0.0 - 1.0 that determines where in the melee animation this entity is
	public float getMeleeProgress(float partialTick) {
		return prevMeleeProgress + (meleeProgress - prevMeleeProgress) * partialTick;
	}

	@Override
	public void tick() {
		super.tick();
		if (getTarget() != null) {
			targetDistance = distanceTo(getTarget()) - getTarget().getBbWidth() / 2f;
		}
		if (!level().isClientSide()) {
			if (!isNoAi()) {
				if (isAwake()) {
					if (getTarget() == null) {
						setAwake(false);
						this.setTransititionToPose();
					} else {
					}
				} else if (getTarget() != null && targetDistance <= 90) {
					setAwake(true);
					this.setTransititionToPose();
				}
			}
		}
		prevSleepProgress = sleepProgress;
		prevMeleeProgress = meleeProgress;
		if (this.entityData.get(SLEEP_TICK) > 0) {
			this.entityData.set(SLEEP_TICK, this.entityData.get(SLEEP_TICK) - 1);
			if (sleepProgress < 1.0F) {
				sleepProgress = Math.min(sleepProgress + 0.1F, 1.0F);
			}
		} else {
			if (sleepProgress > 0F) {
				sleepProgress = Math.max(sleepProgress - 0.2F, 0.0F);
			}
		}

		if (this.entityData.get(ATTACK_TICK) > 0) {
			LivingEntity target = this.getTarget();
			if (this.entityData.get(ATTACK_TICK) == 1 && target != null && this.hasLineOfSight(target) && this.distanceTo(target) < this.getMeleeRange() + this.getBbWidth() + target.getBbWidth()) {
				this.onAttackAnimationFinish(target);
			}
			this.entityData.set(ATTACK_TICK, this.entityData.get(ATTACK_TICK) - 1);
			if (meleeProgress < 1.0F) {
				meleeProgress = Math.min(meleeProgress + 0.2F, 1.0F);
			}
		} else {
			if (meleeProgress > 0F) {
				meleeProgress = Math.max(meleeProgress - 0.2F, 0.0F);
			}
		}
	}

	public float getMeleeRange() {
		return 16;
	}

	class HeadOneAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public HeadOneAttackGoal() {
			super(CorruptedTheropod.this, 1.25D, true);
		}

		public boolean canUse() {
			return super.canUse() && CorruptedTheropod.this.isDoingHeadOneAttack();
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				CorruptedTheropod.this.playSound(PFSounds.BOSS_BITE.get(), 1.0F, CorruptedTheropod.this.getVoicePitch());
				this.mob.doHurtTarget(enemy);
				this.mob.knockback(2, 1, 1);
				CorruptedTheropod.this.setDoingHeadOneAttack(false);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}
			} else {
				this.resetAttackCooldown();
			}

		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && CorruptedTheropod.this.isDoingHeadOneAttack() && !CorruptedTheropod.this.isHeadOneDead();
		}

		public void stop() {
			super.stop();
			CorruptedTheropod.this.setDoingHeadOneAttack(false);
			CorruptedTheropod.this.headOneAttackCooldown = 25;
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(50.0F + attackTarget.getBbWidth());
		}
	}

	class HeadThreeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public HeadThreeAttackGoal() {
			super(CorruptedTheropod.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				this.mob.doHurtTarget(enemy);
				CorruptedTheropod.this.playSound(PFSounds.BOSS_BITE.get(), 1.0F, CorruptedTheropod.this.getVoicePitch());
				CorruptedTheropod.this.setDoingHeadThreeAttack(false);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack() ) {
					this.resetAttackCooldown();
				}
			} else {
				this.resetAttackCooldown();
			}
			if (enemy.getBbWidth() <= 2 && CorruptedTheropod.this.getPassengers().isEmpty()) {
				enemy.startRiding(this.mob);
			}
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && !CorruptedTheropod.this.isVehicle() && !CorruptedTheropod.this.isHeadThreeDead();
		}

		public boolean canUse() {
			return super.canUse() && !CorruptedTheropod.this.isVehicle() && CorruptedTheropod.this.isDoingHeadThreeAttack();
		}

		public void tick() {
			super.tick();
			if (mob.getTarget() != null && mob.getTarget().getBbWidth() < 2 && !mob.isVehicle() && mob.distanceTo(mob.getTarget()) < 4) {
				mob.getTarget().startRiding(mob);
			}
		}

		public void stop() {
			super.stop();
			CorruptedTheropod.this.setDoingHeadThreeAttack(false);
			CorruptedTheropod.this.headThreeAttackCooldown = 25;
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(10 + attackTarget.getBbWidth());
		}
	}

	class HeadFourAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public HeadFourAttackGoal() {
			super(CorruptedTheropod.this, 1.25D, true);
		}

		public boolean canUse() {
			return super.canUse() && CorruptedTheropod.this.isDoingHeadFourAttack();
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				CorruptedTheropod.this.setDeltaMovement(0, getDeltaMovement().y, 0);
				enemy.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 300, 2, true, false, true));
				enemy.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 2, true, false, true));
				CorruptedTheropod.this.setDoingHeadFourAttack(false);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}
			} else {
				this.resetAttackCooldown();
			}

		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && CorruptedTheropod.this.isDoingHeadFourAttack() && !CorruptedTheropod.this.isHeadFourDead();
		}

		public void stop() {
			super.stop();
			CorruptedTheropod.this.playSound(PFSounds.BOSS_ROAR.get(), 1.0F, CorruptedTheropod.this.getVoicePitch());
			CorruptedTheropod.this.setDoingHeadFourAttack(false);
			CorruptedTheropod.this.headFourAttackCooldown = 500;
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(80 + attackTarget.getBbWidth());
		}
	}

	class HeadFiveAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public HeadFiveAttackGoal() {
			super(CorruptedTheropod.this, 1.25D, true);
		}

		public boolean canUse() {
			return super.canUse() && CorruptedTheropod.this.isDoingHeadFiveAttack();
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				CorruptedTheropod.this.playSound(PFSounds.BOSS_BITE.get(), 1.0F, CorruptedTheropod.this.getVoicePitch());
				CorruptedTheropod.this.onAttackAnimationFinishExtraDamage(enemy);
				CorruptedTheropod.this.setDoingHeadFiveAttack(false);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}
			} else {
				this.resetAttackCooldown();
			}

		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && CorruptedTheropod.this.isDoingHeadFiveAttack() && !CorruptedTheropod.this.isHeadFiveDead();
		}

		public void stop() {
			super.stop();
			CorruptedTheropod.this.setDoingHeadFiveAttack(false);
			CorruptedTheropod.this.headFiveAttackCooldown = 25;
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(50 + attackTarget.getBbWidth());
		}
	}

	class HeadSixAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public HeadSixAttackGoal() {
			super(CorruptedTheropod.this, 1.25D, true);
		}

		public boolean canUse() {
			return super.canUse() && CorruptedTheropod.this.isDoingHeadSixAttack();
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				CorruptedTheropod.this.playSound(PFSounds.BOSS_BITE.get(), 1.0F, CorruptedTheropod.this.getVoicePitch());
				CorruptedTheropod.this.onAttackAnimationFinishLessDamage(enemy);
				CorruptedTheropod.this.setDoingHeadSixAttack(false);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}
			} else {
				this.resetAttackCooldown();
			}

		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && CorruptedTheropod.this.isDoingHeadSixAttack() && !CorruptedTheropod.this.isHeadSixDead();
		}

		public void stop() {
			super.stop();
			CorruptedTheropod.this.setDoingHeadSixAttack(false);
			CorruptedTheropod.this.headSixAttackCooldown = 25;
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(50 + attackTarget.getBbWidth());
		}
	}

	class HeadAllAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public HeadAllAttackGoal() {
			super(CorruptedTheropod.this, 1.25D, true);
		}

		public boolean canUse() {
			return super.canUse() && CorruptedTheropod.this.isDoingAllHeadAttack();
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				CorruptedTheropod.this.playSound(PFSounds.BOSS_BITE_ALL.get(), 1.0F, CorruptedTheropod.this.getVoicePitch());
				CorruptedTheropod.this.onAttackAnimationFinishMassiveDamage(enemy);
				CorruptedTheropod.this.setDoingAllHeadAttack(false);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.isTimeToAttack()) {
					this.resetAttackCooldown();
				}
			} else {
				this.resetAttackCooldown();
			}

		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && CorruptedTheropod.this.isDoingAllHeadAttack() && !CorruptedTheropod.this.isHeadFourDead() && !CorruptedTheropod.this.isHeadFiveDead() && !CorruptedTheropod.this.isHeadSixDead() && !CorruptedTheropod.this.isHeadOneDead() && !CorruptedTheropod.this.isHeadTwoDead() && !CorruptedTheropod.this.isHeadThreeDead();
		}

		public void stop() {
			super.stop();
			CorruptedTheropod.this.setDoingAllHeadAttack(false);
			CorruptedTheropod.this.allHeadAttackCooldown = 25;
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(50.0F + attackTarget.getBbWidth());
		}
	}

	class KnockbackRoarAttackGoal extends Goal {
		public KnockbackRoarAttackGoal() {
			super();
		}

		public boolean canUse() {
			return CorruptedTheropod.this.getTarget() != null && CorruptedTheropod.this.isDoingKnockbackRoarAttack();
		}

		public void tick() {
			super.tick();
			LivingEntity entity = CorruptedTheropod.this.getTarget();
			entity.knockback((double)((float)6 * 0.5F), (double)Mth.sin(CorruptedTheropod.this.getYRot() * ((float)Math.PI / 180F)), (double)(-Mth.cos(CorruptedTheropod.this.getYRot() * ((float)Math.PI / 180F))));
			CorruptedTheropod.this.setDoingKnockbackRoarAttack(false);
		}


		public boolean canContinueToUse() {
			return super.canContinueToUse() && CorruptedTheropod.this.isDoingKnockbackRoarAttack();
		}

		public void stop() {
			super.stop();
			CorruptedTheropod.this.playSound(PFSounds.BOSS_ROAR.get(), 1.0F, CorruptedTheropod.this.getVoicePitch());
			CorruptedTheropod.this.setDoingKnockbackRoarAttack(false);
		}
	}

	class ChargeAttackGoal extends Goal {
		int chargeAttackLength = 100;
		
		public ChargeAttackGoal() {
			super();
		}

		public boolean canUse() {
			return CorruptedTheropod.this.getTarget() != null && CorruptedTheropod.this.isDoingChargeAttack();
		}

		public void tick() {
			if (chargeAttackLength != 0) chargeAttackLength--;
			if (chargeAttackLength == 0) {
				CorruptedTheropod.this.setDoingChargeAttack(false);
				CorruptedTheropod.this.chargeAttackCooldown = 500;
				CorruptedTheropod.this.getNavigation().setSpeedModifier(1D);
			} else CorruptedTheropod.this.getNavigation().setSpeedModifier(2D);
		}
		
		public boolean canContinueToUse() {
			return CorruptedTheropod.this.getTarget() != null && CorruptedTheropod.this.isDoingChargeAttack();
		}
		
		public void stop() {
			CorruptedTheropod.this.setDoingChargeAttack(false);
			CorruptedTheropod.this.chargeAttackCooldown = 500;
			chargeAttackLength = 100;
			CorruptedTheropod.this.getNavigation().setSpeedModifier(1D);
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
				double d4 = this.level().getBlockFloorHeight(blockpos$mutable);
				if ((double)blockpos$mutable.getY() + d4 > d3) {
					break;
				}

				if (DismountHelper.isBlockFloorValid(d4)) {
					AABB axisalignedbb = p_234236_2_.getLocalBoundsForPose(pose);
					Vec3 vector3d = new Vec3(d0, (double)blockpos$mutable.getY() + d4, d2);
					if (DismountHelper.canDismountTo(this.level(), p_234236_2_, axisalignedbb.move(vector3d))) {
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

	protected boolean func_212800_dy() {
		return true;
	}

	@Override
	public void positionRider(Entity passenger, Entity.MoveFunction p_289531_) {
		super.positionRider(passenger, p_289531_);
		float radius = ridingXZ * 0.7F * -3 + 4.5F;
		float angle = (0.01745329251F * this.yBodyRotO);
		double extraX = radius * Mth.sin((float) (Math.PI + angle));
		double extraZ = radius * Mth.cos(angle);
		double extraY;
		extraY = ridingY * 6.5F;
		this.getPassengers().get(0).setPos(this.getX() + extraX, this.getY() + extraY - 3.75F, this.getZ() + extraZ);
	}

	public Player getRidingPlayer() {
		if (this.getControllingPassenger() instanceof Player) {
			return (Player) getControllingPassenger();
		} else {
			return null;
		}
	}

	@Nullable
	public LivingEntity getControllingPassenger() {
		Entity entity = this.getFirstPassenger();
		if (entity instanceof Mob) {
			return (Mob)entity;
		} else {
			return null;
		}
	}

	public boolean canBeControlledByRider() {
		return false;
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		this.setHeadOneHealth(50);
		this.setHeadTwoHealth(50);
		this.setHeadThreeHealth(50);
		this.setHeadFourHealth(50);
		this.setHeadFiveHealth(50);
		this.setHeadSixHealth(50);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

}
