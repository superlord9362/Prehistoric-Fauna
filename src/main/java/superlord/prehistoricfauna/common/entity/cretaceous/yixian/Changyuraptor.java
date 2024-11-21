package superlord.prehistoricfauna.common.entity.cretaceous.yixian;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
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
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import superlord.prehistoricfauna.common.blocks.NestAndEggsBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.BabyCarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.CrepuscularSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurWaterAvoidingRandomStrollGoal;
import superlord.prehistoricfauna.common.entity.goal.InsectivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.SkittishFleeGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Changyuraptor extends DinosaurEntity {
	public static final EntityDataAccessor<Integer> FALLING_TICK = SynchedEntityData.defineId(Changyuraptor.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> STEALING = SynchedEntityData.defineId(Changyuraptor.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(Changyuraptor.class, EntityDataSerializers.BYTE);
	@Nullable
	private BlockPos targetPosition;
	int timer = 0;
	int tryStealing = 0;

	public Changyuraptor(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.setMaxUpStep(1);
		this.navigation = new WallClimberNavigation(this, level());
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.DEAD_SPIDER.get();
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new Changyuraptor.MeleeAttackGoal());
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(3, new SkittishFleeGoal(this, Player.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(3, new SkittishFleeGoal(this, Player.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(1, new CrepuscularSleepGoal(this));
		this.goalSelector.addGoal(0, new InsectivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.targetSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.CHANGYURAPTOR_HUNTING);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.CHANGYURAPTOR_BABY_HUNTING);
		}));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.CHANGYURAPTOR_AVOIDING);
		}));
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) {
			this.setPassive(true);
		} else {
			this.setSkittish(true);
		}
		this.setInsectivorous(true);
		this.setCrepuscular(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
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

	@SuppressWarnings("unused")
	private static boolean isSideSolid(BlockGetter reader, BlockPos pos, Entity entityIn, Direction direction) {
		return Block.isFaceFull(reader.getBlockState(pos).getCollisionShape(reader, pos, CollisionContext.of(entityIn)), direction);
	}

	protected PathNavigation createNavigation(Level worldIn) {
		return new WallClimberNavigation(this, worldIn);
	}

	@SuppressWarnings("unused")
	private boolean isClimeableFromSide(BlockPos offsetPos, Direction opposite) {
		return false;
	}

	public boolean onClimbable() {
		return this.isBesideClimbableBlock();
	}
	
	public boolean isStealing() {
		return this.entityData.get(STEALING);
	}

	public void setStealing(boolean isStealing) {
		this.entityData.set(STEALING, isStealing);
	}

	public boolean isBesideClimbableBlock() {
		return (this.entityData.get(CLIMBING) & 1) != 0;
	}

	public void setBesideClimbableBlock(boolean climbing) {
		byte b0 = this.entityData.get(CLIMBING);
		if (climbing) {
			b0 = (byte) (b0 | 1);
		} else {
			b0 = (byte) (b0 & -2);
		}

		this.entityData.set(CLIMBING, b0);
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Changyuraptor.this, 1.25D, true);
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

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 6.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.CHANGYURAPTOR_IDLE.get();
	}

	public void tick() {
		super.tick();
		if (!this.level().isClientSide()) {
			this.setClimbing(this.horizontalCollision);
		}

	}

	public boolean isClimbing() {
		return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
	}

	public void setClimbing(boolean p_33820_) {
		byte b0 = this.entityData.get(DATA_FLAGS_ID);
		if (p_33820_) {
			b0 = (byte)(b0 | 1);
		} else {
			b0 = (byte)(b0 & -2);
		}

		this.entityData.set(DATA_FLAGS_ID, b0);
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.CHANGYURAPTOR_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.CHANGYURAPTOR_DEATH.get();
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
		Changyuraptor entity = new Changyuraptor(PFEntities.CHANGYURAPTOR.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.CHANGYURAPTOR_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.CHANGYURAPTOR_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.CHANGYURAPTOR_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1)).setValue(NestAndEggsBlock.PLANT_LEVEL, Integer.valueOf(this.random.nextInt(3) + 1));
	}

	public boolean causeFallDamage(float p_148875_, float p_148876_, DamageSource p_148877_) {
		return false;
	}

	private void spawnItem(ItemStack stack) {
		ItemEntity itemEntity = new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), stack);
		this.level().addFreshEntity(itemEntity);
	}

	public void aiStep() {
		super.aiStep();
		ItemStack stack = this.getMainHandItem();
		ItemStack newStack = new ItemStack(Items.AIR);
		if (stack.getItem() != Items.AIR) {
			timer++;
			if (timer == 600) {
				this.spawnItem(stack);
				this.setItemInHand(InteractionHand.MAIN_HAND, newStack);
				timer = 0;
			}
			if (this.getLastHurtByMob() != null && timer < 600) {
				this.spawnItem(stack);
				this.setItemInHand(InteractionHand.MAIN_HAND, newStack);
				timer = 0;
			}
		}
		if (this.tickCount > 1000 && this.random.nextInt(1000) == 213) {
			this.setStealing(true);
		}
		if (this.isStealing()) {
			tryStealing++;
			if (this.tryStealing == 600) {
				this.setStealing(false);
				tryStealing = 0;
			}
			for (Player entity : this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(8, 8, 8))) {
				if (entity.getMainHandItem() != new ItemStack(Items.AIR) && !entity.isCreative() && this.getMainHandItem().isEmpty()) {
					this.getNavigation().moveTo(entity, 1);
					for (Player closePlayer : this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(1, 2, 1))) {
						if (this.getMainHandItem().isEmpty() && !closePlayer.getMainHandItem().isEmpty()) {
							ItemStack stack1 = closePlayer.getItemInHand(InteractionHand.MAIN_HAND);
							if (closePlayer.getItemInHand(InteractionHand.MAIN_HAND).getCount() > 1) {
								stack1.shrink(1);
								closePlayer.setItemInHand(InteractionHand.MAIN_HAND, stack1);
							} else {
								ItemStack airStack = new ItemStack(Items.AIR);
								closePlayer.setItemInHand(InteractionHand.MAIN_HAND, airStack);
							}
							this.setItemInHand(InteractionHand.MAIN_HAND, stack1);
							tryStealing = 0;
						}
					}
				}
			}
		}
		Vec3 vec3 = this.getDeltaMovement();
		if (!this.onGround() && this.level().getBlockState(this.blockPosition().below()).isAir() && !this.isClimbing()) {
			this.setFallingTicks(this.getFallingTicks() + 1);
			if (this.getFallingTicks() < 10) {
				this.setDeltaMovement(vec3.multiply(1.0D, 0.75D, 1.0D));
			} else {
				this.setDeltaMovement(vec3.multiply(vec3.x * 2.5D, 0.5D, vec3.z * 2.5D));
			}
		} else {
			this.setFallingTicks(0);
		}
	}

	public InteractionResult mobInteract(Player p_230254_1_, InteractionHand p_230254_2_) {
		ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
		if (!this.getMainHandItem().isEmpty() && itemstack.is(PFTags.INSECTS_2_HUNGER_ITEM)) {
			this.spawnItem(this.getMainHandItem());
			this.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Items.AIR));
			itemstack.shrink(1);
		}
		return super.mobInteract(p_230254_1_, p_230254_2_);
	}

	protected void customServerAiStep() {
		super.customServerAiStep();
		if (this.getFallingTicks() != 0) {
			if (this.targetPosition == null || this.targetPosition.closerToCenterThan(this.position(), 2.0D)) {
				this.targetPosition = new BlockPos((int) this.getX() + this.random.nextInt(7) - this.random.nextInt(7), (int) this.getY() + this.random.nextInt(6) - 2, (int) this.getZ() + this.random.nextInt(7) - this.random.nextInt(7));
			}

			double d2 = (double)this.targetPosition.getX() + 0.5D - this.getX();
			double d1 = (double)this.targetPosition.getZ() + 0.5D - this.getZ();
			Vec3 vec3 = this.getDeltaMovement();
			Vec3 vec31 = vec3.add((Math.signum(d2) * 0.5D - vec3.x) * (double)0.3F, 0, (Math.signum(d1) * 0.5D - vec3.z) * (double)0.3F);
			this.setDeltaMovement(vec31);
			float f = (float)(Mth.atan2(vec31.z, vec31.x) * (double)(180F / (float)Math.PI)) - 90.0F;
			float f1 = Mth.wrapDegrees(f - this.getYRot());
			//			this.zza = 0.5F;
			this.setYRot(this.getYRot() + f1);
		}
	}

	public int getFallingTicks() {
		return this.entityData.get(FALLING_TICK);
	}

	public void setFallingTicks(int fallingTick) {
		this.entityData.set(FALLING_TICK, fallingTick);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(FALLING_TICK, 0);
		this.entityData.define(STEALING, false);
		this.entityData.define(CLIMBING, (byte) 0);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("FallingTick", this.getFallingTicks());
		compound.putBoolean("Stealing", this.isStealing());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setFallingTicks(compound.getInt("FallingTick"));
		this.setStealing(compound.getBoolean("Stealing"));
	}

}
