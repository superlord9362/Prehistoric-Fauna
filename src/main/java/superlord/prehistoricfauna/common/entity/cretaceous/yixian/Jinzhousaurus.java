package superlord.prehistoricfauna.common.entity.cretaceous.yixian;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
import net.minecraft.tags.BlockTags;
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
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.blocks.SapBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.DinosaurHurtByTargetGoal;
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

public class Jinzhousaurus extends DinosaurEntity {
	private static final EntityDataAccessor<Boolean> BIPEDAL = SynchedEntityData.defineId(Jinzhousaurus.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> BIPEDAL_TICK = SynchedEntityData.defineId(Jinzhousaurus.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> SCRATCHING = SynchedEntityData.defineId(Jinzhousaurus.class, EntityDataSerializers.BOOLEAN);
	private int maxHunger = 100;
	private int warningSoundTicks;
	int scratchTick = 3000;
	private float bipedalProgress = 0.0F;
	private float prevBipedalProgress = 0.0F;
	
	public Jinzhousaurus(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.setMaxUpStep(1.375F);
		super.maxHunger = maxHunger;
	}

	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Jinzhousaurus entity = new Jinzhousaurus(PFEntities.JINZHOUSAURUS.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	public boolean isBipedal() {
		return this.entityData.get(BIPEDAL);
	}

	private void setBipedal(boolean isBipedal) {
		this.entityData.set(BIPEDAL_TICK, 15);
		this.entityData.set(BIPEDAL, isBipedal);
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.RUFFORDIA.get().asItem();
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.goalSelector.addGoal(1, new Jinzhousaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new Jinzhousaurus.StripLogGoal((double)1.2F, 12, 2));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.targetSelector.addGoal(3, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(3, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(8, new BipedalAvoidEntityGoal(this, this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.JINZHOUSAURUS_AVOIDING);
		}));
	}
	
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem) {
			CompoundTag tag = itemstack.getTag();
            final List<Integer> already = new ArrayList<>(Ints.asList(tag.getIntArray("Pages")));
            if (!already.contains(EnumPaleoPages.JINZHOUSAURUS.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.JINZHOUSAURUS.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.jinzhousaurus_added"), true);
				return InteractionResult.SUCCESS;
			} else {
				player.displayClientMessage(Component.translatable("paleopedia.jinzhousaurus_already_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		return super.mobInteract(player, hand);
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 40.0D).add(Attributes.MOVEMENT_SPEED, 0.2D).add(Attributes.ATTACK_DAMAGE, 3.0D).add(Attributes.FOLLOW_RANGE, 20.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.JINZHOUSAURUS_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.JINZHOUSAURUS_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.JINZHOUSAURUS_DEATH.get();
	}

	@SuppressWarnings("deprecation")
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		if (this.isBaby()) {
			if (!blockIn.liquid()) {
				BlockState blockstate = this.level().getBlockState(pos.above());
				SoundType soundtype = blockstate.is(Blocks.SNOW) ? blockstate.getSoundType(level(), pos, this) : blockIn.getSoundType(level(), pos, this);
				this.playSound(soundtype.getStepSound(), soundtype.getVolume() * 0.15F, soundtype.getPitch());
			}
		} else {
			this.playSound(SoundEvents.COW_STEP, 0.15F, 1F);
		}
	}

	public boolean isScratching() {
		return this.entityData.get(SCRATCHING);
	}

	public void setScratching(boolean scratching) {
		this.entityData.set(SCRATCHING, scratching);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SCRATCHING, false);
		this.entityData.define(BIPEDAL, false);
		this.entityData.define(BIPEDAL_TICK, 0);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("Scratching", this.isScratching());
		compound.putBoolean("IsBipedal", this.isBipedal());
	}

	public void setAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setScratching(compound.getBoolean("Scratching"));
		this.setBipedal(compound.getBoolean("IsBipedal"));
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.JINZHOUSAURUS_WARN.get(), 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
		prevBipedalProgress = bipedalProgress;
		if (this.entityData.get(BIPEDAL_TICK) > 0) {
			this.entityData.set(BIPEDAL_TICK, this.entityData.get(BIPEDAL_TICK) - 1);
			if (bipedalProgress < 1.0F) {
				bipedalProgress = Math.min(bipedalProgress + 0.1F, 1.0F);
			}
		} else {
			if (bipedalProgress > 0F) {
				bipedalProgress = Math.max(bipedalProgress - 0.2F, 0.0F);
			}
		}
	}
	
	public float getBipedalProgress(float partialTick) {
		return prevBipedalProgress + (bipedalProgress - prevBipedalProgress) * partialTick;
	}

	public void aiStep() {
		super.aiStep();
		if (scratchTick != 0 && !this.isScratching()) {
			scratchTick--;
		}
		if (scratchTick == 0) {
			this.setScratching(true);
			scratchTick = 3000;
		}
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 85) {
			this.setProtective(true);
		} else {
			this.setTerritorial(true);
		}
		this.setHerbivorous(blocksBuilding);
		this.setDiurnal(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(40);
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
			super(Jinzhousaurus.this, 1.25D, true);
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
					Jinzhousaurus.this.playWarningSound();
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
			return (double)(8.0F + attackTarget.getBbWidth());
		}
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.JINZHOUSAURUS_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.JINZHOUSAURUS_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.JINZHOUSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}

	class StripLogGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public StripLogGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(Jinzhousaurus.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
		}
		
		public boolean canUse() {
			return super.canUse() && Jinzhousaurus.this.isScratching();
		}
		
		public boolean canContinueToUse() {
			return super.canContinueToUse() && Jinzhousaurus.this.isScratching();
		}
		
		public void stop() {
			Jinzhousaurus.this.setScratching(false);
		}

		public double acceptedDistance() {
			return 3.0D;
		}

		public boolean shouldMove() {
			return this.tryTicks % 100 == 0;
		}

		/**
		 * Return true to set given position as destination
		 */
		protected boolean isValidTarget(LevelReader worldIn, BlockPos pos) {
			BlockState blockstate = worldIn.getBlockState(pos);
			return (blockstate.is(BlockTags.LOGS));
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (this.isReachedTarget()) {
				if (this.field_220731_g >= 40) {
					this.causeSap();
				} else {
					++this.field_220731_g;
				}
			}
			super.tick();
		}
		
		public void causeSap() {
			if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(Jinzhousaurus.this.level(), Jinzhousaurus.this)) {
				if (level().getBlockState(this.blockPos.relative(Jinzhousaurus.this.getDirection().getOpposite())).isAir()) {
					level().setBlockAndUpdate(this.blockPos.relative(Jinzhousaurus.this.getDirection().getOpposite()), PFBlocks.SAP.get().defaultBlockState().setValue(SapBlock.FACING, Jinzhousaurus.this.getDirection()));
					stop();
				}
			}
		}

	}
	
	@SuppressWarnings("rawtypes")
	class BipedalAvoidEntityGoal extends AvoidEntityGoal {
		Jinzhousaurus jinzhousaurus;

		@SuppressWarnings("unchecked")
		public BipedalAvoidEntityGoal(Jinzhousaurus jinzhousaurus, PathfinderMob entityIn, Class classToAvoidIn, float avoidDistanceIn, double farSpeedIn, double nearSpeedIn, Predicate<LivingEntity> predicate) {
			super(entityIn, classToAvoidIn, avoidDistanceIn, farSpeedIn, nearSpeedIn, predicate);
			this.jinzhousaurus = jinzhousaurus;
		}

		public void start() {
			super.start();
			jinzhousaurus.setBipedal(true);
		}
		
		public void tick() {
			super.tick();
			if (!jinzhousaurus.isBipedal()) {
				jinzhousaurus.setBipedal(true);
			}
		}

		public void stop() {
			jinzhousaurus.setBipedal(false);
			super.stop();
		}

	}
	
	public class BabyPanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		Jinzhousaurus dinosaur;
		
		public BabyPanicGoal(Jinzhousaurus dinosaur) {
			super(dinosaur, 2.0D);
			this.dinosaur = dinosaur;
		}

		public boolean canUse() {
			return !dinosaur.isBaby() && !dinosaur.isOnFire() ? false : super.canUse();
		}
		
		public void start() {
			super.start();
			dinosaur.setBipedal(true);
		}
		
		public void tick() {
			super.tick();
			if (!dinosaur.isBipedal()) {
				dinosaur.setBipedal(true);
			}
		}

		public void stop() {
			dinosaur.setBipedal(false);
			super.stop();
		}
	}

}
