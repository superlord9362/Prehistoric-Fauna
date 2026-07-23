package superlord.prehistoricfauna.common.entity.jurassic.morrison;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.annotation.Nullable;

import com.google.common.primitives.Ints;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurWaterAvoidingRandomStrollGoal;
import superlord.prehistoricfauna.common.entity.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.HerbivoreEatGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.items.PaleopediaItem;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Gargoyleosaurus extends DinosaurEntity {
	private static final EntityDataAccessor<Boolean> TAME_SIT = SynchedEntityData.defineId(Gargoyleosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> TAME_WANDER = SynchedEntityData.defineId(Gargoyleosaurus.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> TAME_PATROL = SynchedEntityData.defineId(Gargoyleosaurus.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> SIT_TICK = SynchedEntityData.defineId(Gargoyleosaurus.class, EntityDataSerializers.INT);
	private float sitProgress = 0.0F;
	private float prevSitProgress = 0.0F;
	private int warningSoundTicks = 200;
	private int maxHunger = 50;
	private int patrolChunkX = Integer.MIN_VALUE;
	private int patrolChunkZ = Integer.MIN_VALUE;

	public Gargoyleosaurus(EntityType<? extends Gargoyleosaurus> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.setMaxUpStep(1.375F);
		super.maxHunger = maxHunger;
	}

	public boolean isTameSitting() {
		return this.entityData.get(TAME_SIT);
	}

	private void setTameSitting(boolean isTameSitting) {
		this.entityData.set(SIT_TICK, 15);
		this.entityData.set(TAME_SIT, isTameSitting);
	}

	public boolean isTameWandering() {
		return this.entityData.get(TAME_WANDER);
	}

	private void setTameWandering(boolean isTameWandering) {
		this.entityData.set(TAME_WANDER, isTameWandering);
	}

	public boolean isTamePatrolling() {
		return this.entityData.get(TAME_PATROL);
	}

	private void setTamePatrolling(boolean isTamePatrolling) {
		this.entityData.set(TAME_PATROL, isTamePatrolling);
	}

	public boolean hasPatrolChunk() {
		return patrolChunkX != Integer.MIN_VALUE;
	}

	public int getPatrolChunkX() {
		return patrolChunkX;
	}

	public int getPatrolChunkZ() {
		return patrolChunkZ;
	}

	private void saveCurrentChunkAsPatrol() {
		patrolChunkX = this.blockPosition().getX() >> 4;
		patrolChunkZ = this.blockPosition().getZ() >> 4;
	}

	public int getPatrolMinBlockX() { 
		return patrolChunkX << 4; 
		}
	
	public int getPatrolMaxBlockX() {
		return (patrolChunkX << 4) + 15; 
		}
	
	public int getPatrolMinBlockZ() { 
		return patrolChunkZ << 4; 
		}
	
	public int getPatrolMaxBlockZ() { 
		return (patrolChunkZ << 4) + 15; 
		}

	public boolean isInsidePatrolChunk() {
		if (!hasPatrolChunk()) return false;
		int bx = this.blockPosition().getX();
		int bz = this.blockPosition().getZ();
		return bx >= getPatrolMinBlockX() && bx <= getPatrolMaxBlockX() && bz >= getPatrolMinBlockZ() && bz <= getPatrolMaxBlockZ();
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.ANOMOZAMITES.get().asItem();
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new Gargoyleosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.goalSelector.addGoal(2, new PatrolChunkWanderGoal(this));
		this.goalSelector.addGoal(5, new PatrolAwareFreeStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.targetSelector.addGoal(3, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(4, new PatrolChunkAttackGoal(this));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double) 1.2F, 12, 2));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double) 1.2F, 12, 2));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.GARGOYLEOSAURUS_AVOIDING);
		}));
		this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
		this.goalSelector.addGoal(0, new GargoyleosaurusFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, true));
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 75) {
			this.setProtective(true);
		} else {
			this.setPassive(true);
		}
		this.setHerbivorous(true);
		this.setDiurnal(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(10);
		} else if (this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);
		}
	}

	@SuppressWarnings("deprecation")
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem) {
			CompoundTag tag = itemstack.getTag();
			final List<Integer> already = new ArrayList<>(Ints.asList(tag.getIntArray("Pages")));
			if (!already.contains(EnumPaleoPages.GARGOYLEOSAURUS.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.GARGOYLEOSAURUS.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.gargoyleosaurus_added"), true);
				return InteractionResult.SUCCESS;
			} else {
				player.displayClientMessage(Component.translatable("paleopedia.gargoyleosaurus_already_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		if (this.level().isClientSide()) {
			boolean flag = this.isOwnedBy(player) || this.isTame() || this.isFood(itemstack) && !this.isTame();
			return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.getOwner() == player) {
					if (this.isFood(itemstack)) {
						if (this.getHealth() < this.getMaxHealth()) {
							if (!player.getAbilities().instabuild) {
								itemstack.shrink(1);
							}
							this.heal((float) item.getFoodProperties().getNutrition());
							return InteractionResult.SUCCESS;
						} else {
							if (this.canFallInLove()) {
								this.setInLove(player);
								if (!player.isCreative()) {
									itemstack.shrink(1);
								}
							}
						}
					} else {
						if (this.isTameSitting()) {
							this.setTameSitting(false);
							this.setTameWandering(true);
							player.displayClientMessage(Component.translatable("entity.prehistoricfauna.velociraptor.wandering"), true);
						} else if (this.isTameWandering()) {
							this.setTameWandering(false);
							this.setTamePatrolling(true);
							this.saveCurrentChunkAsPatrol();
							player.displayClientMessage(Component.translatable("entity.prehistoricfauna.gargoyleosaurus.patrolling"), true);
						} else if (this.isTamePatrolling()) {
							this.setTamePatrolling(false);
							player.displayClientMessage(Component.translatable("entity.prehistoricfauna.velociraptor.following"), true);
						} else {
							this.setTameSitting(true);
							player.displayClientMessage(Component.translatable("entity.prehistoricfauna.velociraptor.sitting"), true);
						}
					}
				}
			} else {
				if (this.isFood(itemstack)) {
					if (!player.getAbilities().instabuild) {
						itemstack.shrink(1);
					}

					if (this.getRandom().nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
						this.tame(player);
						this.navigation.stop();
						this.setTarget((LivingEntity) null);
						this.setTameSitting(true);
						this.level().broadcastEntityEvent(this, (byte) 7);
					} else {
						this.level().broadcastEntityEvent(this, (byte) 6);
					}

					return InteractionResult.SUCCESS;
				}
			}
		}
		return super.mobInteract(player, hand);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ARMOR, 5D).add(Attributes.ATTACK_DAMAGE, 4.0D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.5D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.GARGOYLEOSAURUS_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.GARGOYLEOSAURUS_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.GARGOYLEOSAURUS_DEATH.get();
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

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.GARGOYLEOSAURUS_WARN.get(), 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsTamedSitting", this.isTameSitting());
		compound.putBoolean("IsTamedWander", this.isTameWandering());
		compound.putBoolean("IsTamedPatrol", this.isTamePatrolling());
		compound.putInt("PatrolChunkX", this.patrolChunkX);
		compound.putInt("PatrolChunkZ", this.patrolChunkZ);
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setTameSitting(compound.getBoolean("IsTamedSitting"));
		this.setTameWandering(compound.getBoolean("IsTamedWander"));
		this.setTamePatrolling(compound.getBoolean("IsTamedPatrol"));
		this.patrolChunkX = compound.contains("PatrolChunkX") ? compound.getInt("PatrolChunkX") : Integer.MIN_VALUE;
		this.patrolChunkZ = compound.contains("PatrolChunkZ") ? compound.getInt("PatrolChunkZ") : Integer.MIN_VALUE;
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(TAME_SIT, false);
		this.entityData.define(TAME_WANDER, false);
		this.entityData.define(SIT_TICK, 0);
		this.entityData.define(TAME_PATROL, false);
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
		prevSitProgress = sitProgress;
		if (this.entityData.get(SIT_TICK) > 0) {
			this.entityData.set(SIT_TICK, this.entityData.get(SIT_TICK) - 1);
			if (sitProgress < 1.0F) {
				sitProgress = Math.min(sitProgress + 0.1F, 1.0F);
			}
		} else {
			if (sitProgress > 0F) {
				sitProgress = Math.max(sitProgress - 0.2F, 0.0F);
			}
		}
	}

	public float getSitProgress(float partialTick) {
		return prevSitProgress + (sitProgress - prevSitProgress) * partialTick;
	}

	public void aiStep() {
		super.aiStep();
		if (this.isTameSitting()) {
			this.getNavigation().stop();
		}
	}

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.doEnchantDamageEffects(this, entityIn);
		}
		return flag;
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Gargoyleosaurus.this, 1.25D, true);
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
				if (this.getTicksUntilNextAttack() <= 10) {
					Gargoyleosaurus.this.playWarningSound();
				}
			} else {
				this.resetAttackCooldown();
			}
		}

		public boolean canContinueToUse() { return super.canContinueToUse(); }
		public void stop() { super.stop(); }

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double) (8.0F + attackTarget.getBbWidth());
		}
	}

	public boolean hurt(DamageSource p_33421_, float p_33422_) {
		Entity entity = p_33421_.getDirectEntity();
		if (entity instanceof AbstractArrow) {
			return false;
		}
		return super.hurt(p_33421_, p_33422_);
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.GARGOYLEOSAURUS_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.GARGOYLEOSAURUS_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.GARGOYLEOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Gargoyleosaurus entity = new Gargoyleosaurus(PFEntities.GARGOYLEOSAURUS.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData) null, (CompoundTag) null);
		return entity;
	}

	public class GargoyleosaurusFollowOwnerGoal extends FollowOwnerGoal {
		public GargoyleosaurusFollowOwnerGoal(TamableAnimal tameable, double speed, float minDist, float maxDist, boolean teleportToLeaves) {
			super(tameable, speed, minDist, maxDist, teleportToLeaves);
		}

		public boolean canUse() {
			return super.canUse() && !Gargoyleosaurus.this.isTameSitting() && !Gargoyleosaurus.this.isTameWandering() && !Gargoyleosaurus.this.isTamePatrolling();
		}
	}

	static class PatrolAwareFreeStrollGoal extends DinosaurWaterAvoidingRandomStrollGoal {
		private final Gargoyleosaurus mob;

		PatrolAwareFreeStrollGoal(Gargoyleosaurus mob, double speed) {
			super(mob, speed);
			this.mob = mob;
		}

		@Override
		public boolean canUse() {
			if (mob.isTamePatrolling()) return false;
			return super.canUse();
		}
	}

	static class PatrolChunkWanderGoal extends Goal {

		private static final int MIN_INTERVAL = 100;
		private static final int MAX_INTERVAL = 200;

		private final Gargoyleosaurus mob;
		private int cooldown = 0;

		PatrolChunkWanderGoal(Gargoyleosaurus mob) {
			this.mob = mob;
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		@Override
		public boolean canUse() {
			if (!mob.isTamePatrolling()) return false;
			if (mob.isTameSitting()) return false;
			if (!mob.hasPatrolChunk()) return false;

			if (!mob.isInsidePatrolChunk()) return true;

			if (--cooldown > 0) return false;
			return true;
		}

		@Override
		public boolean canContinueToUse() {
			return mob.getNavigation().isInProgress();
		}

		@Override
		public void start() {
			cooldown = MIN_INTERVAL + mob.getRandom().nextInt(MAX_INTERVAL - MIN_INTERVAL);

			int minX = mob.getPatrolMinBlockX();
			int maxX = mob.getPatrolMaxBlockX();
			int minZ = mob.getPatrolMinBlockZ();
			int maxZ = mob.getPatrolMaxBlockZ();

			int targetX, targetZ;
			if (!mob.isInsidePatrolChunk()) {
				targetX = (minX + maxX) / 2;
				targetZ = (minZ + maxZ) / 2;
			} else {
				targetX = minX + mob.getRandom().nextInt(16);
				targetZ = minZ + mob.getRandom().nextInt(16);
			}

			BlockPos candidate = new BlockPos(targetX, (int) mob.getY(), targetZ);
			BlockPos groundPos = findGround(mob.level(), candidate);
			if (groundPos != null) {
				mob.getNavigation().moveTo(groundPos.getX() + 0.5, groundPos.getY(), groundPos.getZ() + 0.5, 1.0D);
			}
		}

		@SuppressWarnings("deprecation")
		@Nullable
		private BlockPos findGround(Level level, BlockPos start) {
			for (int dy = 0; dy >= -5; dy--) {
				BlockPos check = start.offset(0, dy, 0);
				if (level.getBlockState(check).isSolid() && level.getBlockState(check.above()).isAir()) {
					return check.above();
				}
			}
			for (int dy = 1; dy <= 5; dy++) {
				BlockPos check = start.offset(0, dy, 0);
				if (level.getBlockState(check).isSolid() && level.getBlockState(check.above()).isAir()) {
					return check.above();
				}
			}
			return null;
		}
	}

	static class PatrolChunkAttackGoal extends Goal {

		private static final int SCAN_INTERVAL = 20;

		private final Gargoyleosaurus mob;
		private int scanCooldown = 0;

		PatrolChunkAttackGoal(Gargoyleosaurus mob) {
			this.mob = mob;
			this.setFlags(EnumSet.of(Goal.Flag.TARGET));
		}

		@Override
		public boolean canUse() {
			if (!mob.isTamePatrolling()) return false;
			if (mob.isTameSitting()) return false;
			if (!mob.hasPatrolChunk()) return false;
			if (--scanCooldown > 0) return false;
			scanCooldown = SCAN_INTERVAL;

			LivingEntity found = findTarget();
			if (found == null) return false;
			mob.setTarget(found);
			return true;
		}

		@Override
		public boolean canContinueToUse() {
			LivingEntity target = mob.getTarget();
			if (target == null || !target.isAlive()) return false;
			return isInsidePatrolChunk(target);
		}

		@Override
		public void stop() {
			mob.setTarget(null);
		}

		@Nullable
		private LivingEntity findTarget() {
			double range = mob.getAttributeValue(Attributes.FOLLOW_RANGE);
			List<LivingEntity> nearby = mob.level().getEntitiesOfClass(
				LivingEntity.class,
				mob.getBoundingBox().inflate(range),
				(e) -> e != mob
					&& e.isAlive()
					&& e.getType().is(PFTags.GARGOYLEOSAURUS_ATTACK)
					&& isInsidePatrolChunk(e)
			);
			if (nearby.isEmpty()) return null;
			LivingEntity closest = null;
			double closestDist = Double.MAX_VALUE;
			for (LivingEntity candidate : nearby) {
				double d = mob.distanceToSqr(candidate);
				if (d < closestDist) {
					closestDist = d;
					closest = candidate;
				}
			}
			return closest;
		}

		private boolean isInsidePatrolChunk(LivingEntity entity) {
			int bx = entity.blockPosition().getX();
			int bz = entity.blockPosition().getZ();
			return bx >= mob.getPatrolMinBlockX() && bx <= mob.getPatrolMaxBlockX() && bz >= mob.getPatrolMinBlockZ() && bz <= mob.getPatrolMaxBlockZ();
		}
	}
}