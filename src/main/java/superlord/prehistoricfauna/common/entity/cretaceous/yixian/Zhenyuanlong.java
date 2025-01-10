package superlord.prehistoricfauna.common.entity.cretaceous.yixian;

import java.util.EnumSet;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
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
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.blocks.NestAndEggsBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.BabyCarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.BabyPanicGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.CrepuscularSleepGoal;
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
import superlord.prehistoricfauna.common.entity.goal.OpportunistAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.OpportunistBabyHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.OpportunistHuntingGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.items.PaleopediaItem;
import superlord.prehistoricfauna.common.util.EnumPaleoPages;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Zhenyuanlong extends DinosaurEntity {
	private static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(Zhenyuanlong.class, EntityDataSerializers.BYTE);
	private static final EntityDataAccessor<Boolean> DISPLAYING = SynchedEntityData.defineId(Zhenyuanlong.class, EntityDataSerializers.BOOLEAN);
	private int maxHunger = 38;
	private int climbingTicks = 0;
	private int climbingTickCooldown = 0;

	public Zhenyuanlong(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
		this.setMaxUpStep(1.0F);
		super.maxHunger = maxHunger;
	}
	
	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_SMALL_THEROPOD_MEAT.get();
	}
	
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new BabyPanicGoal(this));
		this.goalSelector.addGoal(4, new DinosaurWaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(0, new HostileCarnivoreGoal(this, Player.class, false));
		this.goalSelector.addGoal(0, new CarnivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.targetSelector.addGoal(3, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(2, new DisplayGoal());
		this.targetSelector.addGoal(2, new OpportunistAttackGoal(this, Player.class, true));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.goalSelector.addGoal(1, new CrepuscularSleepGoal(this));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 7F, 1.5D, 1.75D, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.ZHENYUANLONG_AVOIDING);
		}));
		this.goalSelector.addGoal(1, new MeleeAttackGoal());
		this.targetSelector.addGoal(0, new HuntGoal(this, LivingEntity.class, 10, false, false, (p_213487_1_) -> {
			return p_213487_1_.getType().is(PFTags.ZHENYUANLONG_HUNTING);
		}));
		this.targetSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.ZHENYUANLONG_HUNTING);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.ZHENYUANLONG_BABY_HUNTING);
		}));
		this.targetSelector.addGoal(0, new OpportunistHuntingGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.ZHENYUANLONG_HUNTING);
		}));
		this.targetSelector.addGoal(0, new OpportunistBabyHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.ZHENYUANLONG_BABY_HUNTING);
		}));
	}
	
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		Item item = itemstack.getItem();
		if (item instanceof PaleopediaItem paleopedia) {
			if (!itemstack.getTag().contains("Pages", EnumPaleoPages.ZHENYUANLONG.ordinal())) {
				EnumPaleoPages.addPage(EnumPaleoPages.fromInt(EnumPaleoPages.ZHENYUANLONG.ordinal()), itemstack);
				player.displayClientMessage(Component.translatable("paleopedia.zhenyuanlong_added"), true);
				return InteractionResult.SUCCESS;
			}
		}
		return super.mobInteract(player, hand);
	}
	
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 80) {
			this.setProtective(true);
		} else if (temperment >= 80 && temperment < 95) {
			this.setTerritorial(true);
		} else if (temperment >= 95) {
			this.setOpportunist(true);
		}
		this.setCarnivorous(true);
		this.setCrepuscular(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(8);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(15);
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 15.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}
	
	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : PFSounds.ZHENYUANLONG_IDLE.get();
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.ZHENYUANLONG_HURT.get();
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.ZHENYUANLONG_DEATH.get();
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(CLIMBING, (byte)0);
		this.entityData.define(DISPLAYING, false);
	}
	
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("Displaying", this.isDisplaying());
	}

	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		this.setDisplaying(tag.getBoolean("Displaying"));
	}

	public boolean onLivingFall(float distance, float damageMultiplier) {
		return false;
	}

	public boolean doHurtTarget(Entity entity) {
		boolean flag = super.doHurtTarget(entity);
		if (flag) {
			this.doEnchantDamageEffects(this, entity);
		}
		return flag;
	}
	
	public boolean isDisplaying() {
		return this.entityData.get(DISPLAYING);
	}

	public void setDisplaying(boolean displaying) {
		this.entityData.set(DISPLAYING, displaying);
	}

	public void tick() {
		super.tick();
		if (!this.level().isClientSide()) {
			if (this.horizontalCollision) {
				if (this.horizontalCollision) {
					Boolean logBlock;
					BlockPos blockpos1 = new BlockPos(this.blockPosition().getX() + 1, this.blockPosition().getY() + 1, this.blockPosition().getZ());
					BlockPos blockpos2 = new BlockPos(this.blockPosition().getX() - 1, this.blockPosition().getY() + 1, this.blockPosition().getZ());
					BlockPos blockpos3 = new BlockPos(this.blockPosition().getX(), this.blockPosition().getY() + 1, this.blockPosition().getZ() + 1);
					BlockPos blockpos4 = new BlockPos(this.blockPosition().getX(), this.blockPosition().getY() + 1, this.blockPosition().getZ() - 1);
					BlockState blockstate1 = this.level().getBlockState(blockpos1);
					BlockState blockstate2 = this.level().getBlockState(blockpos2);
					BlockState blockstate3 = this.level().getBlockState(blockpos3);
					BlockState blockstate4 = this.level().getBlockState(blockpos4);
					if (blockstate1.is(BlockTags.LOGS) || blockstate1.is(BlockTags.PLANKS) || blockstate1.is(BlockTags.WOODEN_DOORS) || blockstate1.is(BlockTags.WOODEN_FENCES) || blockstate1.is(BlockTags.WOODEN_SLABS) || blockstate1.is(BlockTags.WOODEN_STAIRS) || blockstate2.is(BlockTags.LOGS) || blockstate2.is(BlockTags.PLANKS) || blockstate2.is(BlockTags.WOODEN_DOORS) || blockstate2.is(BlockTags.WOODEN_FENCES) || blockstate2.is(BlockTags.WOODEN_SLABS) || blockstate2.is(BlockTags.WOODEN_STAIRS)  || blockstate3.is(BlockTags.LOGS) || blockstate3.is(BlockTags.PLANKS) || blockstate3.is(BlockTags.WOODEN_DOORS) || blockstate3.is(BlockTags.WOODEN_FENCES) || blockstate3.is(BlockTags.WOODEN_SLABS) || blockstate3.is(BlockTags.WOODEN_STAIRS) || blockstate4.is(BlockTags.LOGS) || blockstate4.is(BlockTags.PLANKS) || blockstate4.is(BlockTags.WOODEN_DOORS) || blockstate4.is(BlockTags.WOODEN_FENCES) || blockstate4.is(BlockTags.WOODEN_SLABS) || blockstate4.is(BlockTags.WOODEN_STAIRS)) {
						logBlock = true;
						if (climbingTickCooldown == 0 && climbingTicks < 600) {
							this.setBesideClimbableBlock(logBlock);
							climbingTicks++;
						}
						if (climbingTicks >= 599 && climbingTickCooldown <= 300) {
							climbingTickCooldown++;
						}
						if (climbingTickCooldown == 300) {
							climbingTicks = 0;
							climbingTickCooldown = 0;
						}
					}
				}
			}
		}
	}

	public boolean isOnLadder() {
		return this.isBesideClimbableBlock();
	}

	public boolean isBesideClimbableBlock() {
		return (this.entityData.get(CLIMBING) & 1) != 0;
	}

	/**
	 * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if par1 is true or 0x00 if it is
	 * false.
	 */
	public void setBesideClimbableBlock(boolean climbing) {
		byte b0 = this.entityData.get(CLIMBING);
		if (climbing) {
			b0 = (byte)(b0 | 1);
		} else {
			b0 = (byte)(b0 & -2);
		}

		this.entityData.set(CLIMBING, b0);
	}

	protected PathNavigation createNavigation(Level worldIn) {
		return new WallClimberNavigation(this, worldIn);
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Zhenyuanlong.this, 1.25D, true);
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

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Zhenyuanlong entity = new Zhenyuanlong(PFEntities.ZHENYUANLONG.get(), this.level());
		entity.finalizeSpawn(p_241840_1_, this.level().getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}
	
	class DisplayGoal extends Goal {
		public DisplayGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.TARGET));
		}

		@SuppressWarnings("resource")
		public boolean canUse() {
			for (Player player : Zhenyuanlong.this.level().getEntitiesOfClass(Player.class, Zhenyuanlong.this.getBoundingBox().inflate(4, 4, 4))) {
				return Zhenyuanlong.this.trusts(player.getUUID()) && player.getLastAttacker() != null;
			}
			return (Zhenyuanlong.this.getLastAttacker() != null);
		}

		public void start() {
			Zhenyuanlong.this.setDisplaying(true);
			if (Zhenyuanlong.this.getRandom().nextInt(2) == 0) {
				LivingEntity attacker = Zhenyuanlong.this.getLastAttacker();
				if (attacker instanceof Mob mob) {
					mob.setTarget(null);
				}
			}
		}

		public void stop() {
			Zhenyuanlong.this.setDisplaying(false);
		}

		public boolean canContinueToUse() {
			return !Zhenyuanlong.this.getNavigation().isDone();
		}
	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.ZHENYUANLONG_SPAWN_EGG.get());
	}
	
	public Item getEggItem() {
		return PFItems.ZHENYUANLONG_EGG.get();
	}
    
	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.ZHENYUANLONG_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1)).setValue(NestAndEggsBlock.PLANT_LEVEL, Integer.valueOf(this.random.nextInt(3) + 1));
	}
	
}
