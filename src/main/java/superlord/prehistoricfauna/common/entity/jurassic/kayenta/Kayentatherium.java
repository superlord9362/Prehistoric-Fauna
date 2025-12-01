package superlord.prehistoricfauna.common.entity.jurassic.kayenta;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.BurrowingDinosaur;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.SkittishFleeGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.items.PaleopediaItem;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Kayentatherium extends BurrowingDinosaur {
	private int maxHunger = 15;
	private int warningSoundTicks;

	public Kayentatherium(EntityType<? extends Kayentatherium> type, Level worldIn) {
		super(type, worldIn);
		this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
		this.moveControl = new Kayentatherium.KayentatheriumMoveControl(this);
		this.setMaxUpStep(1.375F);
		super.maxHunger = maxHunger;
	}

	public float getWalkTargetValue(BlockPos pos, LevelReader worldIn) {
		return worldIn.getFluidState(pos.below()).isEmpty() && worldIn.getFluidState(pos).is(FluidTags.WATER) ? 10.0F : super.getWalkTargetValue(pos, worldIn);
	}
	
	public void travel(Vec3 travelVector) {
		if (this.isAlive()) {
			if (this.isEffectiveAi() && this.isInWater()) {
				this.moveRelative(this.getSpeed(), travelVector);
				this.move(MoverType.SELF, this.getDeltaMovement());
				this.setDeltaMovement(this.getDeltaMovement().scale(0.5D));
				if (this.getTarget() == null) {
					this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
				}
				if (this.getAirSupply() < this.getMaxAirSupply() / 3) {
					this.setDeltaMovement(this.getDeltaMovement().add(0.0D, 0.05D, 0.0D));
				}
			} else {
				super.travel(travelVector);
			}
		}
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.HORSETAIL.get().asItem();
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(3, new Kayentatherium.SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.2D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new Kayentatherium.KayentatheriumRandomStrollGoal(this, 1.0D, 100));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(8, new SkittishFleeGoal(this, Player.class, 7F, 1.25D, 1.25D));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.goalSelector.addGoal(1, new Kayentatherium.MeleeAttackGoal());
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.KAYENTATHERIUM_AVOIDING);
		}));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		//		this.goalSelector.addGoal(1, new CrepuscularSleepGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 80) {
			this.setSkittish(true);
		} else if (temperment >= 80 && temperment < 95) {
			this.setProtective(true);
		} else if (temperment >= 95) {
			this.setPassive(true);
		}
		this.setHerbivorous(true);
		this.setCrepuscular(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem) {
			if (!itemstack.getTag().contains("Pages", EnumPaleoPages.KAYENTATHERIUM.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.KAYENTATHERIUM.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.kayentatherium_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		return super.mobInteract(player, hand);
	}

	public int getMaxAir() {
		return 4800;
	}

	protected int determineNextAir(int currentAir) {
		return this.getMaxAir();
	}

	protected float getWaterSlowDown() {
		return 0.8F;
	}

	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(3);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(6);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.23D).add(Attributes.FOLLOW_RANGE, 15).add(Attributes.ATTACK_DAMAGE, 1);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.KAYENTATHERIUM_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.KAYENTATHERIUM_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.KAYENTATHERIUM_DEATH.get();
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
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Kayentatherium entity = new Kayentatherium(PFEntities.KAYENTATHERIUM.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	static class SwimGoal extends RandomSwimmingGoal {
		private final Kayentatherium kayentatherium;

		public SwimGoal(Kayentatherium kayentatherium) {
			super(kayentatherium, 1.0D, 40);
			this.kayentatherium = kayentatherium;
		}

		public boolean canUse() {
			return this.kayentatherium.func_212800_dy() && super.canUse();
		}
	}

	protected boolean func_212800_dy() {
		return true;
	}

	static class KayentatheriumPathNavigation extends WaterBoundPathNavigation {
		KayentatheriumPathNavigation(Kayentatherium kayentatherium, Level level) {
			super(kayentatherium, level);
		}

		protected boolean canUpdatePath() {
			return true;
		}

		protected PathFinder createPathFinder(int maxNodes) {
			this.nodeEvaluator = new AmphibiousNodeEvaluator(true);
			return new PathFinder(this.nodeEvaluator, maxNodes);
		}

		public boolean isStableDestination(BlockPos pos) {
			return !this.level.getBlockState(pos.below()).isAir();
		}

	}
	
	static class KayentatheriumGoToWaterGoal extends MoveToBlockGoal {
		private static final int GIVE_UP_TICKS = 1200;
		private final Kayentatherium kayentatherium;

		KayentatheriumGoToWaterGoal(Kayentatherium kayentatherium, double speed) {
			super(kayentatherium, kayentatherium.isBaby() ? 2.0D : speed, 24);
			this.kayentatherium = kayentatherium;
			this.verticalSearchStart = -1;
		}

		public boolean canContinueToUse() {
			return !this.kayentatherium.isInWater() && this.tryTicks <= GIVE_UP_TICKS && this.isValidTarget(this.kayentatherium.level(), this.blockPos);
		}

		public boolean canUse() {
			if (this.kayentatherium.isBaby() && !this.kayentatherium.isInWater()) {
				return super.canUse();
			} else return !this.kayentatherium.isInWater() && !this.kayentatherium.hasBaby() ? super.canUse() : false;
		}

		public boolean shouldRecalculatePath() {
			return this.tryTicks % 160 == 0;
		}

		protected boolean isValidTarget(LevelReader level, BlockPos pos) {
			return level.getBlockState(pos).is(Blocks.WATER);
		}
	}

	static class KayentatheriumMoveControl extends MoveControl {
		private final Kayentatherium kayentatherium;

		KayentatheriumMoveControl(Kayentatherium kayentatherium) {
			super(kayentatherium);
			this.kayentatherium = kayentatherium;
		}

		public void tick() {
			if (this.operation == MoveControl.Operation.MOVE_TO && !this.kayentatherium.getNavigation().isDone()) {
				double d0 = this.wantedX - this.kayentatherium.getX();
				double d1 = this.wantedY - this.kayentatherium.getY();
				double d2 = this.wantedZ - this.kayentatherium.getZ();
				double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 *d2);
				d1 /= d3;
				float f = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
				this.kayentatherium.setYRot(this.rotlerp(this.kayentatherium.getYRot(), f, 90.0F));
				this.kayentatherium.yBodyRot = this.kayentatherium.getYRot();
				float f1 = (float)(this.speedModifier * this.kayentatherium.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.kayentatherium.setSpeed(Mth.lerp(0.125F, this.kayentatherium.getSpeed(), f1));
				this.kayentatherium.setDeltaMovement(this.kayentatherium.getDeltaMovement().add(0.0D, (double)this.kayentatherium.getSpeed() * d1 * 0.1D, 0.0D));
			} else {
				this.kayentatherium.setSpeed(0.0F);
			}
		}

	}
	
	static class KayentatheriumRandomStrollGoal extends RandomStrollGoal {
		private final Kayentatherium kayentatherium;

		KayentatheriumRandomStrollGoal(Kayentatherium kayentatherium, double speed, int interval) {
			super(kayentatherium, speed, interval);
			this.kayentatherium = kayentatherium;
		}

		public boolean canUse() {
			return !this.mob.isInWater() && !this.kayentatherium.hasBaby() ? super.canUse() : false;
		}
	}

	protected PathNavigation createNavigation(Level level) {
		return new Kayentatherium.KayentatheriumPathNavigation(this, level);
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.KAYENTATHERIUM_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.KAYENTATHERIUM_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.KAYENTATHERIUM_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Kayentatherium.this, 1.25D, true);
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

}
