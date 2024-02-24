package superlord.prehistoricfauna.common.entity.cretaceous.djadochta;

import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.BreathAirGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import superlord.prehistoricfauna.common.blocks.NestAndEggsBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Palaeosaniwa;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
import superlord.prehistoricfauna.common.entity.goal.BabyCarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.PiscivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.SkittishFleeGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Calsoyasuchus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Megapnosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Coelophysis;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Exaeretodon;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Herrerasaurus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Sillosuchus;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Halszkaraptor extends DinosaurEntity {

	public int ticksSinceEaten;

	private int maxHunger = 15;

	@SuppressWarnings("deprecation")
	public Halszkaraptor(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.moveControl = new Halszkaraptor.MoveHelperController(this);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.HARENAICHTHYS.get();
	}

	private void spawnItem(ItemStack stack) {
		ItemEntity itemEntity = new ItemEntity(this.level, this.getX(), this.getY(), this.getZ(), stack);
		this.level.addFreshEntity(itemEntity);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new BreathAirGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new PiscivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(1, new Halszkaraptor.MeleeAttackGoal());
		this.goalSelector.addGoal(3, new Halszkaraptor.HalszkaraptorGoToWaterGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.HALSZKARAPTOR_HUNTING);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.HALSZKARAPTOR_BABY_HUNTING);
		}));
		this.targetSelector.addGoal(1, new HuntGoal(this, LivingEntity.class, 10, true, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.HALSZKARAPTOR_HUNTING);
		}));
		this.goalSelector.addGoal(7, new SkittishFleeGoal(this, Player.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Allosaurus>(this, Allosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Ceratosaurus>(this, Ceratosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Camarasaurus>(this, Camarasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Stegosaurus>(this, Stegosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dakotaraptor>(this, Dakotaraptor.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Tyrannosaurus>(this, Tyrannosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Triceratops>(this, Triceratops.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Ankylosaurus>(this, Ankylosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Palaeosaniwa>(this, Palaeosaniwa.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Exaeretodon>(this, Exaeretodon.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Herrerasaurus>(this, Herrerasaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Saurosuchus>(this, Saurosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Sillosuchus>(this, Sillosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Dilophosaurus>(this, Dilophosaurus.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Calsoyasuchus>(this, Calsoyasuchus.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Megapnosaurus>(this, Megapnosaurus.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Poposaurus>(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Postosuchus>(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Coelophysis>(this, Coelophysis.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<Velociraptor>(this, Velociraptor.class, 10F, 1.2D, 1.5D));
	}

	public int getMaxAirSupply() {
		return 4800;
	}

	protected int increaseAirSupply(int p_28389_) {
		return this.getMaxAirSupply();
	}

	protected float getWaterSlowDown() {
		return 0.8F;
	}
	
	public float getWalkTargetValue(BlockPos pos, LevelReader worldIn) {
		return worldIn.getFluidState(pos.below()).isEmpty() && worldIn.getFluidState(pos).is(FluidTags.WATER) ? 10.0F : super.getWalkTargetValue(pos, worldIn);
	}
	
	public void travel(Vec3 travelVector) {
		if (this.isEffectiveAi() && this.isInWater()) {
			this.moveRelative(this.getSpeed(), travelVector);
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().scale(0.5D));
			if (this.getTarget() == null) {
				this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
			}
		} else {
			super.travel(travelVector);
		}
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

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		this.setPiscivorous(true);
		if (temperment < 85) {
			this.setSkittish(true);
		} else {
			this.setPassive(true);
		}
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}


	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.23D).add(Attributes.FOLLOW_RANGE, 15).add(Attributes.ATTACK_DAMAGE, 1);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.HALSZKARAPTOR_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.HALSZKARAPTOR_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.HALSZKARAPTOR_DEATH;
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
		Halszkaraptor entity = new Halszkaraptor(PFEntities.HALSZKARAPTOR.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	protected void pickUpItem(ItemEntity itemEntity) {
		ItemStack itemstack = itemEntity.getItem();
		if (this.canHoldItem(itemstack)) {
			int i = itemstack.getCount();
			if (i > 1) {
				this.spawnItem(itemstack.split(i - 1));
			}
			this.spitOutItem(this.getItemBySlot(EquipmentSlot.MAINHAND));
			this.onItemPickup(itemEntity);
			this.setItemSlot(EquipmentSlot.MAINHAND, itemstack.split(1));
			this.handDropChances[EquipmentSlot.MAINHAND.getIndex()] = 2.0F;
			this.take(itemEntity, itemstack.getCount());
			itemEntity.discard();
			this.ticksSinceEaten = 0;
		}

	}

	private void spitOutItem(ItemStack p_28602_) {
		if (!p_28602_.isEmpty() && !this.level.isClientSide) {
			ItemEntity itementity = new ItemEntity(this.level, this.getX() + this.getLookAngle().x, this.getY() + 1.0D, this.getZ() + this.getLookAngle().z, p_28602_);
			itementity.setPickUpDelay(40);
			itementity.setThrower(this.getUUID());
			this.level.addFreshEntity(itementity);
		}
	}

	static class SwimGoal extends RandomSwimmingGoal {
		private final Halszkaraptor halszkaraptor;

		public SwimGoal(Halszkaraptor halszkaraptor) {
			super(halszkaraptor, 1.0D, 40);
			this.halszkaraptor = halszkaraptor;
		}

		public boolean canUse() {
			return this.halszkaraptor.func_212800_dy() && super.canUse();
		}
	}

	protected boolean func_212800_dy() {
		return true;
	}

	class WalkAndSwimPathNavigator extends WaterBoundPathNavigation {

		WalkAndSwimPathNavigator(Halszkaraptor halszkaraptor, Level world) {
			super(halszkaraptor, world);
		}

		protected boolean canNavigate() {
			return true;
		}

		protected PathFinder getPathFinder(int uncategorizedNumber) {
			this.nodeEvaluator = new AmphibiousNodeEvaluator(true);
			return new PathFinder(this.nodeEvaluator, uncategorizedNumber);
		}

		public boolean canStandOnPos(BlockPos pos) {
			return !this.level.getBlockState(pos.below()).isAir();
		}

	}

	static class MoveHelperController extends MoveControl {
		private final Halszkaraptor halszkaraptor;

		MoveHelperController(Halszkaraptor halszkaraptor) {
			super(halszkaraptor);
			this.halszkaraptor = halszkaraptor;
		}

		public void tick() {
			if (this.halszkaraptor.isEyeInFluid(FluidTags.WATER)) {
				this.halszkaraptor.setDeltaMovement(this.halszkaraptor.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
			}
			if (this.operation == MoveControl.Operation.MOVE_TO && !this.halszkaraptor.getNavigation().isDone()) {
				float f = (float)(this.speedModifier * this.halszkaraptor.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.halszkaraptor.setSpeed(Mth.lerp(0.125F, this.halszkaraptor.getSpeed(), f));
				double d0 = this.wantedX - this.halszkaraptor.getX();
				double d1 = this.wantedY - this.halszkaraptor.getY();
				double d2 = this.wantedZ - this.halszkaraptor.getZ();
				if (d1 != 0.0D) {
					double d3 = (double)Mth.sqrt((float) (d0 * d0 + d1 * d1 + d2 * d2));
					this.halszkaraptor.setDeltaMovement(this.halszkaraptor.getDeltaMovement().add(0.0D, (double)this.halszkaraptor.getSpeed() * (d1 / d3) * 0.1D, 0.0D));
				}
				if (d0 != 0.0D || d2 != 0.0D) {
					float f1 = (float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
					this.halszkaraptor.xRot = this.rotlerp(this.halszkaraptor.xRot, f1, 90.0F);
					this.halszkaraptor.xRotO = this.halszkaraptor.xRot;
				}
			} else {
				this.halszkaraptor.setSpeed(0.0F);
			}
		}

	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack heldItem = player.getItemInHand(hand);
		if (heldItem.getItem() == PFItems.HARENAICHTHYS.get() && this.isAlive() && this.hasItemInSlot(EquipmentSlot.MAINHAND)) {
			ItemStack halszkaraptorItem = this.getMainHandItem();
			heldItem.shrink(1);
			int dropChance = this.random.nextInt(2);
			if(dropChance == 0) {
				this.spawnItem(halszkaraptorItem);
				this.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(PFItems.HARENAICHTHYS.get()));
			}
		}
		return super.mobInteract(player, hand);
	}

	protected PathNavigation createNavigation(Level world) {
		return new Halszkaraptor.WalkAndSwimPathNavigator(this, world);
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.HALSZKARAPTOR_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.HALSZKARAPTOR_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.HALSZKARAPTOR_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1)).setValue(NestAndEggsBlock.PLANT_LEVEL, Integer.valueOf(this.random.nextInt(3) + 1));
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Halszkaraptor.this, 1.25D, true);
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

	static class HalszkaraptorRandomStrollGoal extends RandomStrollGoal {
		private final Halszkaraptor halszkaraptor;

		HalszkaraptorRandomStrollGoal(Halszkaraptor halszkaraptor, double speed, int interval) {
			super(halszkaraptor, speed, interval);
			this.halszkaraptor = halszkaraptor;
		}

		public boolean canUse() {
			return !this.mob.isInWater() && !this.halszkaraptor.hasBaby() ? super.canUse() : false;
		}
	}

	static class HalszkaraptorGoToWaterGoal extends MoveToBlockGoal {
		private static final int GIVE_UP_TICKS = 1200;
		private final Halszkaraptor halszkaraptor;

		HalszkaraptorGoToWaterGoal(Halszkaraptor halszkaraptor, double speed) {
			super(halszkaraptor, halszkaraptor.isBaby() ? 2.0D : speed, 24);
			this.halszkaraptor = halszkaraptor;
			this.verticalSearchStart = -1;
		}

		public boolean canContinueToUse() {
			return !this.halszkaraptor.isInWater() && this.tryTicks <= GIVE_UP_TICKS && this.isValidTarget(this.halszkaraptor.level, this.blockPos);
		}

		public boolean canUse() {
			if (this.halszkaraptor.isBaby() && !this.halszkaraptor.isInWater()) {
				return super.canUse();
			} else return !this.halszkaraptor.isInWater() && !this.halszkaraptor.hasBaby() ? super.canUse() : false;
		}

		public boolean shouldRecalculatePath() {
			return this.tryTicks % 160 == 0;
		}

		protected boolean isValidTarget(LevelReader level, BlockPos pos) {
			return level.getBlockState(pos).is(Blocks.WATER);
		}
	}

	static class FishingGoal extends Goal {
		private static final ResourceLocation FISHING_LOOT = new ResourceLocation("gameplay/fishing");
		private static final BlockStatePredicate IS_WATER = BlockStatePredicate.forBlock(Blocks.WATER);

		private final Halszkaraptor entity;
		private int fishingTimer;
		private int fishTimer;

		public FishingGoal(Halszkaraptor entity) {
			this.entity = entity;
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.JUMP, Goal.Flag.LOOK));
		}

		@Override
		public boolean canUse() {
			if (fishTimer > 0) {
				--fishTimer;
				return false;
			}
			if (entity.getRandom().nextInt(entity.isBaby() ? 100 : 1000) != 0) {
				return false;
			} else {
				BlockPos blockpos = entity.blockPosition();
				if (IS_WATER.test(entity.level.getBlockState(blockpos))) {
					return true;
				} else {
					return entity.level.getBlockState(blockpos.below()).is(Blocks.WATER);
				}
			}
		}

		@Override
		public void start() {
			fishingTimer = 40;
			fishTimer = 6000;
			entity.level.broadcastEntityEvent(entity, (byte) 10);
			entity.getNavigation().stop();
		}

		@Override
		public void stop() {
			fishingTimer = 0;
		}

		@Override
		public boolean canContinueToUse() {
			return fishingTimer > 0;
		}

		@Override
		public void tick() {
			if (fishTimer > 0) {
				--fishTimer;
			}
			if (fishingTimer > 0) {
				--fishingTimer;
			}
			if (fishingTimer == 25) {
				BlockPos blockpos = entity.blockPosition();
				BlockPos blockpos1 = blockpos.below();
				if (entity.level.getBlockState(blockpos1).is(Blocks.WATER)) {
					MinecraftServer server = entity.level.getServer();
					if (server != null) {
						List<ItemStack> items = server.getLootTables().get(FISHING_LOOT).getRandomItems(new LootContext.Builder((ServerLevel) entity.level).withRandom(entity.getRandom()).create(LootContextParamSet.builder().build()));
						Containers.dropContents(entity.level, blockpos, NonNullList.of(ItemStack.EMPTY, items.toArray(new ItemStack[0])));
					}
				}
			}
		}
	}

	public void aiStep() {
		if (!this.level.isClientSide && this.isAlive() && this.isEffectiveAi()) {
			++this.ticksSinceEaten;
			ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
			if (this.canEatItem(itemstack)) {
				if (this.ticksSinceEaten > 100) {
					ItemStack itemstack1 = itemstack.finishUsingItem(this.level, this);
					if (!itemstack1.isEmpty()) {
						this.setItemSlot(EquipmentSlot.MAINHAND, itemstack1);
					}
					this.ticksSinceEaten = 0;
					itemstack.shrink(1);
				}
			} else {
				if (!itemstack.isEmpty()) {
					if (this.ticksSinceEaten > 100) {
						this.spawnItem(itemstack);
						this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.AIR));
						this.ticksSinceEaten = 0;
						itemstack.shrink(1);
					}
				}
			}

		}
		super.aiStep();
	}

	private boolean canEatItem(ItemStack itemStackIn) {
		return (itemStackIn.is(PFTags.FISH_2_HUNGER) || itemStackIn.is(PFTags.FISH_4_HUNGER));
	}

	public boolean canEquipItem(ItemStack stack) {
		ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
		return itemstack.isEmpty() && !this.isSleeping();
	}

	class FindItemsGoal extends Goal {
		public FindItemsGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean canUse() {
			if (!Halszkaraptor.this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty()) {
				return false;
			} 
			if (Halszkaraptor.this.getRandom().nextInt(reducedTickDelay(10)) != 0) {
				return false;
			} else {
				List<ItemEntity> list = Halszkaraptor.this.level.getEntitiesOfClass(ItemEntity.class, Halszkaraptor.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D));
				return !list.isEmpty() && Halszkaraptor.this.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty();
			}
		}


		public void tick() {
			List<ItemEntity> list = Halszkaraptor.this.level.getEntitiesOfClass(ItemEntity.class, Halszkaraptor.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D));
			ItemStack itemstack = Halszkaraptor.this.getItemBySlot(EquipmentSlot.MAINHAND);
			if (itemstack.isEmpty() && !list.isEmpty()) {
				Halszkaraptor.this.getNavigation().moveTo(list.get(0), (double)1.2F);
			}

		}

		public void start() {
			List<ItemEntity> list = Halszkaraptor.this.level.getEntitiesOfClass(ItemEntity.class, Halszkaraptor.this.getBoundingBox().inflate(8.0D, 8.0D, 8.0D));
			if (!list.isEmpty()) {
				Halszkaraptor.this.getNavigation().moveTo(list.get(0), (double)1.2F);
			}

		}
	}

}
