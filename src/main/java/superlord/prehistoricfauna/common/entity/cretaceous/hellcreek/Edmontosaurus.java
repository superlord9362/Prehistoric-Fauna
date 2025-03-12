package superlord.prehistoricfauna.common.entity.cretaceous.hellcreek;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.HerdDinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.AggressiveTempermentAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
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
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFDamageSources;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Edmontosaurus extends HerdDinosaurEntity {
	private static final EntityDataAccessor<Boolean> IS_JUVENILE = SynchedEntityData.defineId(Edmontosaurus.class, EntityDataSerializers.BOOLEAN);
	private int warningSoundTicks = 200;
	private static final Map<LivingEntity, BlockPos> previousPositions = new HashMap<>();
	public int maxHunger = 250;

	public Edmontosaurus(EntityType<? extends Edmontosaurus> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.setMaxUpStep(1);
		super.maxHunger = this.maxHunger;
	}

	@Override
	public double moveToRange() {
		return 15;
	}

	public boolean isJuvenile() {
		return this.entityData.get(IS_JUVENILE);
	}

	public void setJuvenile(boolean isJuvenile) {
		this.entityData.set(IS_JUVENILE, isJuvenile);
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFBlocks.OSMUNDA.get().asItem();
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(0, new DinosaurHurtByTargetGoal(this).setAlertOthers(Edmontosaurus.class));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.targetSelector.addGoal(2, new AggressiveTempermentAttackGoal(this));
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new Edmontosaurus.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new HerbivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.EDMONTOSAURUS_AVOIDING);
		}));
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.EDMONTOSAURUS_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.EDMONTOSAURUS_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.EDMONTOSAURUS_DEATH.get();
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0D).add(Attributes.MOVEMENT_SPEED, 0.22D).add(Attributes.ATTACK_DAMAGE, 6);
	}

	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() < -24000) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(25);
		} else if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.setJuvenile(true);
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(50);
		} else if(this.getAge() >= 0) {
			this.setJuvenile(false);
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(100);
		}
	}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem) {
			if (!itemstack.getTag().contains("Pages", EnumPaleoPages.EDMONTOSAURUS.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.EDMONTOSAURUS.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.edmontosaurus_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		return super.mobInteract(player, hand);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(IS_JUVENILE, false);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsJuvenile", this.isJuvenile());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setJuvenile(compound.getBoolean("IsJuvenile"));
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		this.setHerbivorous(true);
		if (temperment < 80) {
			this.setProtective(true);
		} else if (temperment >  95) { 
			this.setAggressive(true);
		} else {
			this.setTerritorial(true);
		}
		this.setDiurnal(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public Item getEggItem() {
		return PFItems.EDMONTOSAURUS_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.EDMONTOSAURUS_EGG.get().defaultBlockState().setValue(DinosaurEggBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1));
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Edmontosaurus entity = new Edmontosaurus(PFEntities.EDMONTOSAURUS.get(), this.level());
		entity.setAge(-48000);
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.EDMONTOSAURUS_SPAWN_EGG.get());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (!this.isBaby()) {
			for (Player player : this.level().getEntitiesOfClass(Player.class, getBoundingBox().inflate(6, 0, 6))) {
				List<Edmontosaurus> edmontosaurus = this.level().getEntitiesOfClass(Edmontosaurus.class, getBoundingBox().inflate(6, 0, 6));
				if (edmontosaurus.isEmpty()) this.setTarget(player);
			}
			for (DinosaurEntity dinosaur : this.level().getEntitiesOfClass(DinosaurEntity.class, getBoundingBox().inflate(6, 0, 6))) {
				if (dinosaur.isCarnivorous()) {
					this.playWarningSound();
				}
			}
			if (PrehistoricFaunaConfig.sauropodTrampling) {
				BlockPos currentPosition = new BlockPos((int) this.position().x(), (int) this.position().y(), (int) this.position().z());
		        BlockPos previousPosition = previousPositions.getOrDefault(this, currentPosition);
				if (!previousPosition.equals(currentPosition)) {
					for (LivingEntity entity : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(1, 0, 1))) {
						if (!(entity instanceof Edmontosaurus) && entity.getMaxHealth() < 60) {
							entity.hurt(PFDamageSources.causeSauropodTramplingDamage(entity.level().registryAccess(), this), (float) 5.0D);
						}
					}
				}
				previousPositions.clear();
		        previousPositions.put(this, currentPosition);
			}
		}
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.EDMONTOSAURUS_WARN.get(), 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Edmontosaurus.this, 1.25D, true);
		}

		public boolean canUse() {
			return super.canUse();
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
			return (double)(8.0F + attackTarget.getBbWidth());
		}
	}

}
