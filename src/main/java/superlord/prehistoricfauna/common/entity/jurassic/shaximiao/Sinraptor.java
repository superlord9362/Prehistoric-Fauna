package superlord.prehistoricfauna.common.entity.jurassic.shaximiao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.primitives.Ints;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
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
import superlord.prehistoricfauna.common.entity.goal.DinosaurWaterAvoidingRandomStrollGoal;
import superlord.prehistoricfauna.common.entity.goal.HostileCarnivoreGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.items.PaleopediaItem;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEffects;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

import java.util.EnumSet;

public class Sinraptor extends DinosaurEntity {
	private int warningSoundTicks = 200;
	private int maxHunger = 150;

	public Sinraptor(EntityType<? extends Sinraptor> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.setMaxUpStep(1.375F);
		super.maxHunger = maxHunger;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Sinraptor entity = new Sinraptor(PFEntities.SINRAPTOR.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData) null, (CompoundTag) null);
		return entity;
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) {
			this.setTerritorial(true);
		} else {
			this.setProtective(true);
		}
		this.setCarnivorous(true);
		this.setCathemeral(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_LARGE_SAUROPOD_MEAT.get();
	}

	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30);
		} else if (this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(60);
		}
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.targetSelector.addGoal(4, new HuntGoal(this, LivingEntity.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.SINRAPTOR_HUNTING);
		}));
		this.goalSelector.addGoal(1, new CircleAndDashAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.targetSelector.addGoal(0, new HostileCarnivoreGoal(this, Player.class, false));
		this.goalSelector.addGoal(2, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.SINRAPTOR_AVOIDING);
		}));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(0, new CarnivoreEatFromFeederGoal(this, (double) 1.2F, 12, 2));
		this.targetSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.SINRAPTOR_HUNTING);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.SINRAPTOR_BABY_HUNTING);
		}));
	}

	class CircleAndDashAttackGoal extends Goal {

		private enum Phase { 
			APPROACH, 
			CIRCLING, 
			DASHING, 
			RETREATING 
		}

		private static final double ORBIT_RADIUS = 9.0;
		private static final double MIN_ORBIT_RADIUS = 7.5;
		private static final double LOOKAHEAD_ANGLE = 0.45;
		private static final double APPROACH_THRESH = ORBIT_RADIUS + 1.5;
		private static final double RETREAT_THRESH = ORBIT_RADIUS - 0.5;
		private static final double STRIKE_RADIUS = 2.8;

		private static final double APPROACH_SPEED = 1.4;
		private static final double CIRCLE_SPEED = 0.9;
		private static final double DASH_SPEED = 2.0;
		private static final double RETREAT_SPEED = 1.9;

		private static final int CIRCLE_TICKS = 200;
		private static final int MAX_HITS = 2;
		private static final int HIT_COOLDOWN = 12;
		private static final int WARN_INTERVAL = 60;

		private Phase phase = Phase.APPROACH;
		private int phaseTimer = 0;
		private int hitCount = 0;
		private int hitsThisDash = 1;
		private int hitCooldown = 0;
		private double circleAngle = 0.0;
		private double circleDir = 1.0;
		private LivingEntity pinnedTarget = null;

		public CircleAndDashAttackGoal() {
			this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
		}

		@Override
		public boolean canUse() {
			LivingEntity target = Sinraptor.this.getTarget();
			return target != null && target.isAlive() && !Sinraptor.this.isBaby();
		}

		@Override
		public boolean canContinueToUse() {
			if (phase == Phase.RETREATING) return true;
			LivingEntity target = Sinraptor.this.getTarget();
			return target != null && target.isAlive();
		}

		@Override
		public void start() {
			pinnedTarget = Sinraptor.this.getTarget();
			circleAngle = angleToTarget(pinnedTarget);
			circleDir = Sinraptor.this.random.nextBoolean() ? 1.0 : -1.0;
			phase = Phase.APPROACH;
			phaseTimer = 0;
			hitCount = 0;
			hitsThisDash = 1 + Sinraptor.this.random.nextInt(MAX_HITS);
			hitCooldown = 0;
		}

		@Override
		public void stop() {
			Sinraptor.this.getNavigation().stop();
			pinnedTarget = null;
		}

		@Override
		public void tick() {
			LivingEntity currentTarget = Sinraptor.this.getTarget();
			if (currentTarget != null && currentTarget.isAlive()) {
				pinnedTarget = currentTarget;
			}
			if (pinnedTarget == null) return;

			Sinraptor.this.getLookControl().setLookAt(pinnedTarget, 30.0F, 30.0F);
			double dist = Sinraptor.this.distanceTo(pinnedTarget);

			switch (phase) {
			case APPROACH -> tickApproach(dist);
			case CIRCLING -> tickCircling(dist);
			case DASHING -> tickDashing(dist);
			case RETREATING -> tickRetreating(dist);
			}
		}

		private void tickApproach(double dist) {
			Sinraptor.this.getNavigation().moveTo(pinnedTarget, APPROACH_SPEED);
			if (dist <= APPROACH_THRESH) {
				beginCircle();
			}
		}

		private void tickCircling(double dist) {
			phaseTimer++;
			if (phaseTimer % WARN_INTERVAL == 0) {
				Sinraptor.this.playWarningSound();
			}
			circleAngle += circleDir * 0.035;
			if (dist < MIN_ORBIT_RADIUS) {
				Vec3 away = Sinraptor.this.position().subtract(pinnedTarget.position()).normalize();
				double ox = Sinraptor.this.getX() + away.x * ORBIT_RADIUS;
				double oz = Sinraptor.this.getZ() + away.z * ORBIT_RADIUS;
				Sinraptor.this.getNavigation().moveTo(ox, pinnedTarget.getY(), oz, CIRCLE_SPEED);
			} else {
				double targetAngle = circleAngle + circleDir * LOOKAHEAD_ANGLE;
				double wx = pinnedTarget.getX() + Math.cos(targetAngle) * ORBIT_RADIUS;
				double wz = pinnedTarget.getZ() + Math.sin(targetAngle) * ORBIT_RADIUS;
				Sinraptor.this.getNavigation().moveTo(wx, pinnedTarget.getY(), wz, CIRCLE_SPEED);
			}

			if (phaseTimer >= CIRCLE_TICKS) {
				beginDash();
			}
		}

		private void tickDashing(double dist) {
			Sinraptor.this.getNavigation().moveTo(pinnedTarget, DASH_SPEED);
			if (hitCooldown > 0) hitCooldown--;
			double strikeDist = STRIKE_RADIUS + pinnedTarget.getBbWidth() * 0.5;
			if (dist <= strikeDist && hitCooldown == 0 && hitCount < hitsThisDash) {
				performStrike(pinnedTarget);
				hitCount++;
				hitCooldown = HIT_COOLDOWN;
			}
			if (hitCount >= hitsThisDash) {
				beginRetreat();
			}
		}

		private void tickRetreating(double dist) {
			if (Sinraptor.this.getTarget() == null && pinnedTarget.isAlive()) {
				Sinraptor.this.setTarget(pinnedTarget);
			}
			Vec3 away = Sinraptor.this.position().subtract(pinnedTarget.position()).normalize();
			double rx = pinnedTarget.getX() + away.x * ORBIT_RADIUS;
			double rz = pinnedTarget.getZ() + away.z * ORBIT_RADIUS;
			Sinraptor.this.getNavigation().moveTo(rx, Sinraptor.this.getY(), rz, RETREAT_SPEED);
			if (dist >= RETREAT_THRESH) {
				beginCircle();
			}
		}

		private void beginCircle() {
			phase = Phase.CIRCLING;
			phaseTimer = 0;
			circleAngle = angleToTarget(pinnedTarget);
			circleDir = Sinraptor.this.random.nextBoolean() ? 1.0 : -1.0;
			Sinraptor.this.getNavigation().stop();
		}

		private void beginDash() {
			phase = Phase.DASHING;
			phaseTimer = 0;
			hitCount = 0;
			hitsThisDash = 1 + Sinraptor.this.random.nextInt(MAX_HITS);
			hitCooldown = 0;
			Sinraptor.this.getNavigation().stop();
		}

		private void beginRetreat() {
			phase = Phase.RETREATING;
			phaseTimer = 0;
			Sinraptor.this.getNavigation().stop();
		}

		private double angleToTarget(LivingEntity target) {
			double dx = Sinraptor.this.getX() - target.getX();
			double dz = Sinraptor.this.getZ() - target.getZ();
			return Math.atan2(dz, dx);
		}

		private void performStrike(LivingEntity target) {
			Sinraptor.this.playSound(PFSounds.SINRAPTOR_BITE.get(), 1.0F, Sinraptor.this.getVoicePitch());
			boolean hit = Sinraptor.this.doHurtTarget(target);
			if (hit) {
				target.addEffect(new MobEffectInstance(PFEffects.BLEEDING.get(), 200, 0, true, false));
			}
		}
	}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem) {
			CompoundTag tag = itemstack.getTag();
			final List<Integer> already = new ArrayList<>(Ints.asList(tag.getIntArray("Pages")));
			if (!already.contains(EnumPaleoPages.SINRAPTOR.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.SINRAPTOR.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.sinraptor_added"), true);
				return InteractionResult.SUCCESS;
			} else {
				player.displayClientMessage(Component.translatable("paleopedia.sinraptor_already_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		return super.mobInteract(player, hand);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 60.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.25F).add(Attributes.ATTACK_DAMAGE, 12.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.6D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? PFSounds.SINRAPTOR_SNORES.get() : PFSounds.SINRAPTOR_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.SINRAPTOR_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.SINRAPTOR_DEATH.get();
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
			this.playSound(SoundEvents.COW_STEP, 0.15F, 1F);
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

	public boolean doHurtTarget(Entity entity) {
		boolean flag = super.doHurtTarget(entity);
		if (flag) {
			this.doEnchantDamageEffects(this, entity);
		}
		return flag;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.SINRAPTOR_WARN.get(), 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.SINRAPTOR_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.SINRAPTOR_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.SINRAPTOR_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}
}