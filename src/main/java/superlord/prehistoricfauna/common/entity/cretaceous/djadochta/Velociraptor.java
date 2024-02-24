package superlord.prehistoricfauna.common.entity.cretaceous.djadochta;

import java.util.EnumSet;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
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
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FleeSunGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.EntityEvent.Size;
import superlord.prehistoricfauna.common.blocks.NestAndEggsBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;
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
import superlord.prehistoricfauna.common.entity.goal.HostileCarnivoreGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.OpportunistAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;
import superlord.prehistoricfauna.common.entity.triassic.chinle.Postosuchus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Velociraptor extends DinosaurEntity {
	private static final EntityDataAccessor<Byte> VELOCIRAPTOR_FLAGS = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.BYTE);
	private static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.BYTE);
	private static final Predicate<LivingEntity> IS_PREY = (p_213498_0_) -> {
		return p_213498_0_.getType().is(PFTags.ANIMALS_3_HUNGER) || p_213498_0_.getType().is(PFTags.ANIMALS_4_HUNGER) || p_213498_0_.getType().is(PFTags.ANIMALS_6_HUNGER) || p_213498_0_.getType().is(PFTags.ANIMALS_8_HUNGER) || p_213498_0_.getType().is(PFTags.ANIMALS_10_HUNGER) || p_213498_0_.getType().is(PFTags.ANIMALS_15_HUNGER) || p_213498_0_.getType().is(PFTags.ANIMALS_20_HUNGER);
	};
	private static final EntityDataAccessor<Boolean> TAME_SIT = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> TAME_WANDER = SynchedEntityData.defineId(Velociraptor.class, EntityDataSerializers.BOOLEAN);
	private int maxHunger = 20;
	private Goal attackAnimals;
	private float interestedAngle;
	private float interestedAngleO;
	private float crouchAmount;
	private float crouchAmountO;
	private int warningSoundTicks;
	private int eatTicks;
	private int climbingTicks = 0;
	private int climbingTickCooldown = 0;

	public boolean isTameSitting() {
		return this.entityData.get(TAME_SIT);
	}

	private void setTameSitting(boolean isTameSitting) {
		this.entityData.set(TAME_SIT, isTameSitting);
	}

	public boolean isTameWandering() {
		return this.entityData.get(TAME_WANDER);
	}

	private void setTameWandering(boolean isTameWandering) {
		this.entityData.set(TAME_WANDER, isTameWandering);
	}

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_SMALL_MARGINOCEPHALIAN_MEAT.get();
	}

	protected PathNavigation createNavigation(Level worldIn) {
		return new WallClimberNavigation(this, worldIn);
	}

	@SuppressWarnings("deprecation")
	public Velociraptor(EntityType<? extends Velociraptor> type, Level worldIn) {
		super(type, worldIn);
		this.lookControl = new Velociraptor.LookHelperController();
		this.moveControl = new Velociraptor.MoveHelperController();
		this.setPathfindingMalus(BlockPathTypes.DANGER_OTHER, 0.0F);
		this.setPathfindingMalus(BlockPathTypes.DAMAGE_OTHER, 0.0F);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	protected float getStandingEyeHeight(Pose poseIn, Size sizeIn) {
		if (this.isBaby()) return 0.4F;
		else return 0.8F;
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(VELOCIRAPTOR_FLAGS, (byte)0);
		this.entityData.define(CLIMBING, (byte)0);
		this.entityData.define(TAME_SIT, false);
		this.entityData.define(TAME_WANDER, false);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void registerGoals() {
		this.attackAnimals = new Velociraptor.TamedHuntGoal(this, Animal.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.VELOCIRAPTOR_HUNTING);
		});
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Velociraptor.JumpGoal());
		this.goalSelector.addGoal(2, new BabyPanicGoal(this));
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(2, new OpportunistAttackGoal(this, Player.class, true));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.goalSelector.addGoal(5, new Velociraptor.FollowTargetGoal());
		this.goalSelector.addGoal(1, new Velociraptor.PounceGoal());
		this.goalSelector.addGoal(6, new Velociraptor.FindShelterGoal(1.25D));
		this.goalSelector.addGoal(7, new Velociraptor.BiteGoal((double)1.2F, true));
		this.goalSelector.addGoal(8, new Velociraptor.FollowGoal(this, 1.25D));
		this.targetSelector.addGoal(1, new DinosaurHurtByTargetGoal(this));
		this.goalSelector.addGoal(10, new LeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(11, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(13, new Velociraptor.SitAndLookGoal());
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Ankylosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Triceratops.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Tyrannosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Camarasaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Stegosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Allosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, Ceratosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Dilophosaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Poposaurus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, Postosuchus.class, 10F, 1.5D, 1.75D));
		this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
		this.targetSelector.addGoal(0, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(0, new OwnerHurtTargetGoal(this));
		this.goalSelector.addGoal(0, new VelociraptorFollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, true));
		this.goalSelector.addGoal(1, new CrepuscularSleepGoal(this));
		this.targetSelector.addGoal(0, new HostileCarnivoreGoal(this, Player.class, false));
		this.goalSelector.addGoal(0, new CarnivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
		this.targetSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.VELOCIRAPTOR_HUNTING);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213487_0_) -> {
			return p_213487_0_.getType().is(PFTags.VELOCIRAPTOR_BABY_HUNTING);
		}));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
	}
	
	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(4);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(8);
		}
	}

	public void aiStep() {
		if (!this.level.isClientSide && this.isAlive()) {
			++this.eatTicks;
			ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
			if (this.canEatItem(itemstack)) {
				if (this.eatTicks > 600) {
					ItemStack itemstack1 = itemstack.finishUsingItem(this.level, this);
					if (!itemstack1.isEmpty()) {
						this.setItemSlot(EquipmentSlot.MAINHAND, itemstack1);
					}

					this.eatTicks = 0;
				} else if (this.eatTicks > 560 && this.random.nextFloat() < 0.1F) {
					this.level.broadcastEntityEvent(this, (byte)45);
				}
			}

			LivingEntity livingentity = this.getTarget();
			if (livingentity == null || !livingentity.isAlive()) {
				this.setCrouching(false);
				this.func_213502_u(false);
			}
		}
		if (this.getTarget() != null) {
			if (this.getVehicle() != null) {
				if (this.getVehicle() == this.getTarget() && this.tickCount % 20 == 0) {
					AttributeInstance iattributeinstance = this.getAttribute(Attributes.ATTACK_DAMAGE);
					this.getTarget().hurt(DamageSource.mobAttack(this), (float) iattributeinstance.getBaseValue());
				}
			}
		}

		if (this.isSleeping() || this.isMovementBlocked()) {
			this.jumping = false;
			this.xxa = 0.0F;
			this.zza = 0.0F;
		}
		super.aiStep();
		if (this.isVelociraptorAggroed() && this.random.nextFloat() < 0.05F) {
		}
	}

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 80) {
			this.setProtective(true);
		} else if (temperment >= 80 && temperment < 95) {
			this.setOpportunist(true);
		} else if (temperment >= 95) {
			this.setTerritorial(true);
		}
		this.setCarnivorous(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@SuppressWarnings("deprecation")
	private boolean canEatItem(ItemStack itemStackIn) {
		return itemStackIn.getItem().isEdible() && itemStackIn.getItem().getFoodProperties().isMeat() && this.getTarget() == null && this.onGround && !this.isSleeping();
	}

	protected boolean isMovementBlocked() {
		return this.getHealth() <= 0.0F;
	}

	public boolean canEquipItem(ItemStack stack) {
		Item item = stack.getItem();
		ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
		return itemstack.isEmpty() || this.eatTicks > 0 && item.isEdible();
	}

	private void spitOutItem(ItemStack stackIn) {
		if (!stackIn.isEmpty() && !this.level.isClientSide) {
			ItemEntity itementity = new ItemEntity(this.level, this.getX() + this.getLookAngle().x, this.getY() + 1.0D, this.getZ() + this.getLookAngle().z, stackIn);
			itementity.setPickUpDelay(40);
			itementity.setThrower(this.getUUID());
			this.level.addFreshEntity(itementity);
		}
	}

	private void dropItemStack(ItemStack stackIn) {
		ItemEntity itementity = new ItemEntity(this.level, this.getX(), this.getY(), this.getZ(), stackIn);
		this.level.addFreshEntity(itementity);
	}

	protected void pickUpItem(ItemEntity item) {
		ItemStack itemstack = item.getItem();
		if (this.canEquipItem(itemstack)) {
			int i = itemstack.getCount();
			if (i > 1) {
				this.dropItemStack(itemstack.split(i - 1));
			}

			this.spitOutItem(this.getItemBySlot(EquipmentSlot.MAINHAND));
			this.setItemSlot(EquipmentSlot.MAINHAND, itemstack.split(1));
			this.handDropChances[EquipmentSlot.MAINHAND.getIndex()] = 2.0F;
			this.take(item, itemstack.getCount());
			item.remove(RemovalReason.DISCARDED);
			this.eatTicks = 0;
		}

	}

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		if (this.random.nextFloat() < 0.2F) {
			float f = this.random.nextFloat();
			ItemStack itemstack;
			if (f < 0.05F) {
				itemstack = new ItemStack(Items.EMERALD);
			} else if (f < 0.2F) {
				itemstack = new ItemStack(Items.EGG);
			} else if (f < 0.4F) {
				itemstack = this.random.nextBoolean() ? new ItemStack(Items.RABBIT_FOOT) : new ItemStack(Items.RABBIT_HIDE);
			} else if (f < 0.6F) {
				itemstack = new ItemStack(Items.WHEAT);
			} else if (f < 0.8F) {
				itemstack = new ItemStack(Items.LEATHER);
			} else {
				itemstack = new ItemStack(Items.FEATHER);
			}

			this.setItemSlot(EquipmentSlot.MAINHAND, itemstack);
		}

	}

	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		if (id == 45) {
			ItemStack itemstack = this.getItemBySlot(EquipmentSlot.MAINHAND);
			if (!itemstack.isEmpty()) {
				for(int i = 0; i < 8; ++i) {
					Vec3 vec3d = (new Vec3(((double)this.random.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D)).xRot(-this.xRot * ((float)Math.PI / 180F)).yRot(-this.yRot * ((float)Math.PI / 180F));
					this.level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, itemstack), this.getX() + this.getLookAngle().x / 2.0D, this.getY(), this.getZ() + this.getLookAngle().z / 2.0D, vec3d.x, vec3d.y + 0.05D, vec3d.z);
				}
			}
		} else {
			super.handleEntityEvent(id);
		}

	}

	@Override
	public void push(Entity entity) {
		super.push(entity);
		if (this.getTarget() != null) {
			if (this.getTarget() == entity && !onGround && this.getVehicle() != entity && !(entity instanceof Player)) {
				this.startRiding(entity);
			}
		}
	}

	@Override
	public boolean hurt(DamageSource dmg, float i) {
		if (this.getVehicle() != null) {
			if (this.getLastHurtMob() != null) {
				if (this.getLastHurtMob() == this.getVehicle()) {
					if (this.getRandom().nextInt(2) == 0) {
						this.stopRiding();
					}
				}
			}
		}
		return super.hurt(dmg, i);
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, this.attackAnimals);
	}

	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsSleeping", this.isSleeping());
		compound.putBoolean("IsSitting", this.isSitting());
		compound.putBoolean("IsCrouching", this.isCrouching());
		compound.putBoolean("IsTamedSitting", this.isTameSitting());
		compound.putBoolean("IsTamedWander", this.isTameWandering());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setSleeping(compound.getBoolean("IsSleeping"));
		this.setSitting(compound.getBoolean("IsSitting"));
		this.setCrouching(compound.getBoolean("IsCrouching"));
		this.setAttackGoals();
		this.setTameSitting(compound.getBoolean("IsTamedSitting"));
		this.setTameWandering(compound.getBoolean("IsTamedWander"));
	}

	public boolean isSitting() {
		return this.getVelociraptorFlag(1);
	}

	public void setSitting(boolean p_213466_1_) {
		this.setVelociraptorFlag(1, p_213466_1_);
	}

	public boolean isStuck() {
		return this.getVelociraptorFlag(64);
	}

	private void setStuck(boolean p_213492_1_) {
		this.setVelociraptorFlag(64, p_213492_1_);
	}

	private boolean isVelociraptorAggroed() {
		return this.getVelociraptorFlag(128);
	}

	private void setVelociraptorAggroed(boolean p_213482_1_) {
		this.setVelociraptorFlag(128, p_213482_1_);
	}

	/**
	 * Returns whether player is sleeping or not
	 */
	public boolean isSleeping() {
		return this.getVelociraptorFlag(32);
	}

	public void setSleeping(boolean p_213485_1_) {
		this.setVelociraptorFlag(32, p_213485_1_);
	}

	private void setVelociraptorFlag(int p_213505_1_, boolean p_213505_2_) {
		if (p_213505_2_) {
			this.entityData.set(VELOCIRAPTOR_FLAGS, (byte)(this.entityData.get(VELOCIRAPTOR_FLAGS) | p_213505_1_));
		} else {
			this.entityData.set(VELOCIRAPTOR_FLAGS, (byte)(this.entityData.get(VELOCIRAPTOR_FLAGS) & ~p_213505_1_));
		}

	}

	private boolean getVelociraptorFlag(int p_213507_1_) {
		return (this.entityData.get(VELOCIRAPTOR_FLAGS) & p_213507_1_) != 0;
	}

	public void tick() {
		super.tick();
		if (this.isEffectiveAi()) {
			boolean flag = this.isInWater();
			if (flag || this.getTarget() != null || this.level.isThundering()) {
				this.func_213454_em();
			}

			if (flag || this.isSleeping()) {
				this.setSitting(false);
			}

			if (this.isStuck() && this.level.random.nextFloat() < 0.2F) {
				BlockPos blockpos = new BlockPos(this.position());
				BlockState blockstate = this.level.getBlockState(blockpos);
				this.level.levelEvent(2001, blockpos, Block.getId(blockstate));
			}
		}

		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}

		this.interestedAngleO = this.interestedAngle;
		if (this.func_213467_eg()) {
			this.interestedAngle += (1.0F - this.interestedAngle) * 0.4F;
		} else {
			this.interestedAngle += (0.0F - this.interestedAngle) * 0.4F;
		}

		this.crouchAmountO = this.crouchAmount;
		if (this.isCrouching()) {
			this.crouchAmount += 0.2F;
			if (this.crouchAmount > 3.0F) {
				this.crouchAmount = 3.0F;
			}
		} else {
			this.crouchAmount = 0.0F;
		}

		if (!this.level.isClientSide) {
			if (this.horizontalCollision) {
				Boolean logBlock;
				BlockPos blockpos1 = new BlockPos(this.position().x() + 1, this.position().y() + 1, this.position().z());
				BlockPos blockpos2 = new BlockPos(this.position().x() - 1, this.position().y() + 1, this.position().z());
				BlockPos blockpos3 = new BlockPos(this.position().x(), this.position().y() + 1, this.position().z() + 1);
				BlockPos blockpos4 = new BlockPos(this.position().x(), this.position().y() + 1, this.position().z() - 1);
				BlockState blockstate1 = this.level.getBlockState(blockpos1);
				BlockState blockstate2 = this.level.getBlockState(blockpos2);
				BlockState blockstate3 = this.level.getBlockState(blockpos3);
				BlockState blockstate4 = this.level.getBlockState(blockpos4);
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

	public boolean func_213480_dY() {
		return this.getVelociraptorFlag(16);
	}

	public void func_213461_s(boolean p_213461_1_) {
		this.setVelociraptorFlag(16, p_213461_1_);
	}

	public boolean func_213490_ee() {
		return this.crouchAmount == 3.0F;
	}

	public void setCrouching(boolean p_213451_1_) {
		this.setVelociraptorFlag(4, p_213451_1_);
	}

	public boolean isCrouching() {
		return this.getVelociraptorFlag(4);
	}

	public void func_213502_u(boolean p_213502_1_) {
		this.setVelociraptorFlag(8, p_213502_1_);
	}

	public boolean func_213467_eg() {
		return this.getVelociraptorFlag(8);
	}

	@OnlyIn(Dist.CLIENT)
	public float func_213475_v(float p_213475_1_) {
		return Mth.lerp(p_213475_1_, this.interestedAngleO, this.interestedAngle) * 0.11F * (float)Math.PI;
	}

	@OnlyIn(Dist.CLIENT)
	public float func_213503_w(float p_213503_1_) {
		return Mth.lerp(p_213503_1_, this.crouchAmountO, this.crouchAmount);
	}

	public void setTarget(@Nullable LivingEntity entitylivingbaseIn) {
		if (this.isVelociraptorAggroed() && entitylivingbaseIn == null) {
			this.setVelociraptorAggroed(false);
		}

		super.setTarget(entitylivingbaseIn);
	}

	protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
		return Mth.ceil((p_225508_1_ - 5.0F) * p_225508_2_);
	}

	private void func_213454_em() {
		this.setSleeping(false);
	}

	private void func_213499_en() {
		this.func_213502_u(false);
		this.setCrouching(false);
		this.setSitting(false);
		this.setSleeping(false);
		this.setVelociraptorAggroed(false);
		this.setStuck(false);
	}

	private boolean func_213478_eo() {
		return !this.isSleeping() && !this.isSitting() && !this.isStuck();
	}

	protected SoundEvent getAmbientSound()  {
		return this.isAsleep() ? null : PFSounds.VELOCIRAPTOR_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.VELOCIRAPTOR_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.VELOCIRAPTOR_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.VELOCIRAPTOR_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.ATTACK_DAMAGE, 6.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.1D);
	}

	public static boolean func_213481_a(Velociraptor p_213481_0_, LivingEntity p_213481_1_) {
		double d0 = p_213481_1_.getZ() - p_213481_0_.getZ();
		double d1 = p_213481_1_.getX() - p_213481_0_.getX();
		double d2 = d0 / d1;
		for(int j = 0; j < 6; ++j) {
			double d3 = d2 == 0.0D ? 0.0D : d0 * (double)((float)j / 6.0F);
			double d4 = d2 == 0.0D ? d1 * (double)((float)j / 6.0F) : d3 / d2;

			for(int k = 1; k < 4; ++k) {
				if (!p_213481_0_.level.getBlockState(new BlockPos(p_213481_0_.getX() + d4, p_213481_0_.getY() + (double)k, p_213481_0_.getZ() + d3)).getMaterial().isReplaceable()) {
					return false;
				}
			}
		}

		return true;
	}

	public class AlertablePredicate implements Predicate<LivingEntity> {
		public boolean test(LivingEntity p_test_1_) {
			if (p_test_1_ instanceof Velociraptor) {
				return false;
			} else if (!(p_test_1_ instanceof Chicken) && !(p_test_1_ instanceof Rabbit) && !(p_test_1_ instanceof Monster)) {
				if (p_test_1_ instanceof TamableAnimal) {
					return !((TamableAnimal)p_test_1_).isTame();
				} else if (!(p_test_1_ instanceof Player) || !p_test_1_.isSpectator() && !((Player)p_test_1_).isCreative()) {
					return !p_test_1_.isSleeping() && !p_test_1_.isDiscrete();
				} else {
					return false;
				}
			} else {
				return true;
			}
		}
	}

	abstract class BaseGoal extends Goal {
		private final TargetingConditions field_220816_b = TargetingConditions.forCombat().range(12.0D).ignoreLineOfSight().selector(Velociraptor.this.new AlertablePredicate());

		private BaseGoal() {
		}

		protected boolean func_220813_g() {
			BlockPos blockpos = new BlockPos(Velociraptor.this.position());
			return !Velociraptor.this.level.canSeeSky(blockpos) && Velociraptor.this.getWalkTargetValue(blockpos) >= 0.0F;
		}

		protected boolean func_220814_h() {
			return !Velociraptor.this.level.getNearbyEntities(LivingEntity.class, this.field_220816_b, Velociraptor.this, Velociraptor.this.getBoundingBox().inflate(12.0D, 6.0D, 12.0D)).isEmpty();
		}
	}

	class BiteGoal extends MeleeAttackGoal {

		public BiteGoal(double p_i50731_2_, boolean p_i50731_4_) {
			super();
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.isTimeToAttack()) {
				this.resetAttackCooldown();
				this.mob.doHurtTarget(enemy);
			}
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse();
		}

		public void start() {
			Velociraptor.this.func_213502_u(false);
			super.start();
		}

		public boolean canUse() {
			return !Velociraptor.this.isSitting() && !Velociraptor.this.isSleeping() && !Velociraptor.this.isCrouching() && !Velociraptor.this.isStuck() && super.canUse();
		}
	}

	class FindShelterGoal extends FleeSunGoal {
		private int cooldown = 100;

		public FindShelterGoal(double p_i50724_2_) {
			super(Velociraptor.this, p_i50724_2_);
		}

		public boolean canUse() {
			if (!Velociraptor.this.isSleeping() && this.mob.getTarget() == null) {
				if (Velociraptor.this.level.isThundering()) {
					return true;
				} else if (this.cooldown > 0) {
					--this.cooldown;
					return false;
				} else {
					this.cooldown = 100;
					BlockPos blockpos = new BlockPos(this.mob.position());
					return Velociraptor.this.level.isDay() && Velociraptor.this.level.canSeeSky(blockpos) && !((ServerLevel)Velociraptor.this.level).isVillage(blockpos) && this.setWantedPos();
				}
			} else {
				return false;
			}
		}

		public void start() {
			Velociraptor.this.func_213499_en();
			super.start();
		}
	}

	class FollowGoal extends FollowParentGoal {
		private final Velociraptor owner;

		public FollowGoal(Velociraptor p_i50735_2_, double p_i50735_3_) {
			super(p_i50735_2_, p_i50735_3_);
			this.owner = p_i50735_2_;
		}

		public boolean canUse() {
			return !this.owner.isVelociraptorAggroed() && super.canUse();
		}

		public boolean canContinueToUse() {
			return !this.owner.isVelociraptorAggroed() && super.canContinueToUse();
		}

		public void start() {
			this.owner.func_213499_en();
			super.start();
		}
	}

	class FollowTargetGoal extends Goal {
		public FollowTargetGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		public boolean canUse() {
			if (Velociraptor.this.isSleeping()) {
				return false;
			} else {
				LivingEntity livingentity = Velociraptor.this.getTarget();
				return livingentity != null && livingentity.isAlive() && Velociraptor.IS_PREY.test(livingentity) && Velociraptor.this.distanceToSqr(livingentity) > 36.0D && !Velociraptor.this.isCrouching() && !Velociraptor.this.func_213467_eg() && !Velociraptor.this.jumping;
			}
		}

		public void start() {
			Velociraptor.this.setSitting(false);
			Velociraptor.this.setStuck(false);
		}

		public void stop() {
			LivingEntity livingentity = Velociraptor.this.getTarget();
			if (livingentity != null && Velociraptor.func_213481_a(Velociraptor.this, livingentity)) {
				Velociraptor.this.func_213502_u(true);
				Velociraptor.this.setCrouching(true);
				Velociraptor.this.getNavigation().stop();
				Velociraptor.this.getLookControl().setLookAt(livingentity, (float)Velociraptor.this.getMaxHeadYRot(), (float)Velociraptor.this.getMaxHeadXRot());
			} else {
				Velociraptor.this.func_213502_u(false);
				Velociraptor.this.setCrouching(false);
			}

		}

		public void tick() {
			LivingEntity livingentity = Velociraptor.this.getTarget();
			Velociraptor.this.getLookControl().setLookAt(livingentity, (float)Velociraptor.this.getMaxHeadYRot(), (float)Velociraptor.this.getMaxHeadXRot());
			if (Velociraptor.this.distanceToSqr(livingentity) <= 36.0D) {
				Velociraptor.this.func_213502_u(true);
				Velociraptor.this.setCrouching(true);
				Velociraptor.this.getNavigation().stop();
			} else {
				Velociraptor.this.getNavigation().moveTo(livingentity, 1.5D);
			}

		}
	}

	class JumpGoal extends Goal {
		int delay;

		public JumpGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.JUMP, Goal.Flag.MOVE));
		}

		public boolean canUse() {
			return Velociraptor.this.isStuck();
		}

		public boolean canContinueToUse() {
			return this.canUse() && this.delay > 0;
		}

		public void start() {
			this.delay = 40;
		}

		public void stop() {
			Velociraptor.this.setStuck(false);
		}

		public void tick() {
			--this.delay;
		}
	}

	public class LookHelperController extends LookControl {
		public LookHelperController() {
			super(Velociraptor.this);
		}

		public void tick() {
			if (!Velociraptor.this.isSleeping()) {
				super.tick();
			}

		}

		protected boolean func_220680_b() {
			return !Velociraptor.this.func_213480_dY() && !Velociraptor.this.isCrouching() && !Velociraptor.this.func_213467_eg() & !Velociraptor.this.isStuck();
		}
	}

	class MoveHelperController extends MoveControl {
		public MoveHelperController() {
			super(Velociraptor.this);
		}

		public void tick() {
			if (Velociraptor.this.func_213478_eo()) {
				super.tick();
			}

		}
	}

	public class PounceGoal extends net.minecraft.world.entity.ai.goal.JumpGoal {
		public boolean canUse() {
			if (!Velociraptor.this.func_213490_ee()) {
				return false;
			} else {
				LivingEntity livingentity = Velociraptor.this.getTarget();
				if (livingentity != null && livingentity.isAlive()) {
					if (livingentity.getMotionDirection() != livingentity.getDirection()) {
						return false;
					} else {
						boolean flag = Velociraptor.func_213481_a(Velociraptor.this, livingentity);
						if (!flag) {
							Velociraptor.this.getNavigation().createPath(livingentity, 0);
							Velociraptor.this.setCrouching(false);
							Velociraptor.this.func_213502_u(false);
						}

						return flag;
					}
				} else {
					return false;
				}
			}
		}

		public boolean canContinueToUse() {
			LivingEntity livingentity = Velociraptor.this.getTarget();
			if (livingentity != null && livingentity.isAlive()) {
				double d0 = Velociraptor.this.getDeltaMovement().y;
				return (!(d0 * d0 < (double)0.05F) || !(Math.abs(Velociraptor.this.xRot) < 15.0F) || !Velociraptor.this.onGround) && !Velociraptor.this.isStuck();
			} else {
				return false;
			}
		}

		public boolean isPreemptible() {
			return false;
		}

		public void start() {
			Velociraptor.this.setJumping(true);
			Velociraptor.this.func_213461_s(true);
			Velociraptor.this.func_213502_u(false);
			LivingEntity livingentity = Velociraptor.this.getTarget();
			Velociraptor.this.getLookControl().setLookAt(livingentity, 60.0F, 30.0F);
			Vec3 vec3d = (new Vec3(livingentity.getX() - Velociraptor.this.getX(), livingentity.getY() - Velociraptor.this.getY(), livingentity.getZ() - Velociraptor.this.getZ())).normalize();
			Velociraptor.this.setDeltaMovement(Velociraptor.this.getDeltaMovement().add(vec3d.x * 0.8D, 0.5D, vec3d.z * 0.8D));
			Velociraptor.this.getNavigation().stop();
		}

		public void stop() {
			Velociraptor.this.setCrouching(false);
			Velociraptor.this.crouchAmount = 0.0F;
			Velociraptor.this.crouchAmountO = 0.0F;
			Velociraptor.this.func_213502_u(false);
			Velociraptor.this.func_213461_s(false);
		}

		public void tick() {
			LivingEntity livingentity = Velociraptor.this.getTarget();
			if (livingentity != null) {
				Velociraptor.this.getLookControl().setLookAt(livingentity, 60.0F, 30.0F);
			}

			if (!Velociraptor.this.isStuck()) {
				Vec3 vec3d = Velociraptor.this.getDeltaMovement();
				if (vec3d.y * vec3d.y < (double)0.03F && Velociraptor.this.xRot != 0.0F) {
					Velociraptor.this.xRot = Mth.rotLerp(Velociraptor.this.xRot, 0.0F, 0.2F);
				} else {
					double d0 = vec3d.horizontalDistance();
					double d1 = Math.signum(-vec3d.y) * Math.acos(d0 / vec3d.length()) * (double)(180F / (float)Math.PI);
					Velociraptor.this.xRot = (float)d1;
				}
			}

			if (livingentity != null && Velociraptor.this.distanceTo(livingentity) <= 2.0F) {
				Velociraptor.this.doHurtTarget(livingentity);
			} else if (Velociraptor.this.xRot > 0.0F && Velociraptor.this.onGround && (float)Velociraptor.this.getDeltaMovement().y != 0.0F && Velociraptor.this.level.getBlockState(new BlockPos(Velociraptor.this.position())).getBlock() == Blocks.SNOW) {
				Velociraptor.this.xRot = 60.0F;
				Velociraptor.this.setTarget((LivingEntity)null);
			}

		}
	}

	class SitAndLookGoal extends Velociraptor.BaseGoal {
		private double field_220819_c;
		private double field_220820_d;
		private int field_220821_e;
		private int field_220822_f;

		public SitAndLookGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		public boolean canUse() {
			return Velociraptor.this.getLastHurtByMob() == null && Velociraptor.this.getRandom().nextFloat() < 0.02F && !Velociraptor.this.isSleeping() && Velociraptor.this.getTarget() == null && Velociraptor.this.getNavigation().isDone() && !this.func_220814_h() && !Velociraptor.this.func_213480_dY() && !Velociraptor.this.isCrouching() && !Velociraptor.this.isAsleep();
		}

		public boolean canContinueToUse() {
			return this.field_220822_f > 0;
		}

		public void start() {
			this.func_220817_j();
			this.field_220822_f = 2 + Velociraptor.this.getRandom().nextInt(3);
			Velociraptor.this.setSitting(true);
			Velociraptor.this.getNavigation().stop();
		}

		public void stop() {
			Velociraptor.this.setSitting(false);
			Velociraptor.this.setWakingTicks(0);
		}

		public void tick() {
			--this.field_220821_e;
			if (this.field_220821_e <= 0) {
				--this.field_220822_f;
				this.func_220817_j();
			}

			Velociraptor.this.getLookControl().setLookAt(Velociraptor.this.getX() + this.field_220819_c, Velociraptor.this.getEyeY(), Velociraptor.this.getZ() + this.field_220820_d, (float)Velociraptor.this.getMaxHeadYRot(), (float)Velociraptor.this.getMaxHeadXRot());
		}

		private void func_220817_j() {
			double d0 = (Math.PI * 2D) * Velociraptor.this.getRandom().nextDouble();
			this.field_220819_c = Math.cos(d0);
			this.field_220820_d = Math.sin(d0);
			this.field_220821_e = 80 + Velociraptor.this.getRandom().nextInt(20);
		}
	}

	class WatchGoal extends LookAtPlayerGoal {
		public WatchGoal(Mob p_i50733_2_, Class<? extends LivingEntity> p_i50733_3_, float p_i50733_4_) {
			super(p_i50733_2_, p_i50733_3_, p_i50733_4_);
		}

		public boolean canUse() {
			return super.canUse() && !Velociraptor.this.isStuck() && !Velociraptor.this.func_213467_eg();
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && !Velociraptor.this.isStuck() && !Velociraptor.this.func_213467_eg();
		}
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Velociraptor.this, 1.25D, true);
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
					Velociraptor.this.playWarningSound();
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
			return (double)(5.0F + attackTarget.getBbWidth());
		}
	}

	public boolean doHurtTarget(Entity entity) {
		boolean flag = super.doHurtTarget(entity);
		if (flag) {
			this.doEnchantDamageEffects(this, entity);
		}
		return flag;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Velociraptor entity = new Velociraptor(PFEntities.VELOCIRAPTOR.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	class TamedHuntGoal extends HuntGoal {
		Predicate<LivingEntity> targetPredicate;

		@SuppressWarnings("rawtypes")
		public TamedHuntGoal(DinosaurEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnlyIn, targetPredicate);
			this.targetPredicate = targetPredicate;
		}

		public boolean canUse() {
			return super.canUse() && Velociraptor.this.isTame() && !PrehistoricFaunaConfig.advancedHunger && !Velociraptor.this.isSleeping() && !targetPredicate.test(Velociraptor.this);
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public InteractionResult mobInteract(Player player, InteractionHand p_230254_2_) {
		ItemStack itemstack = player.getItemInHand(p_230254_2_);
		Item item = itemstack.getItem();
		if (this.level.isClientSide) {
			boolean flag = this.isOwnedBy(player) || this.isTame() || this.isFood(itemstack) && !this.isTame();
			return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.isFood(itemstack)) {
					if (this.getHealth() < this.getMaxHealth()) {
						if (!player.getAbilities().instabuild) {
							itemstack.shrink(1);
						}
						this.heal((float)item.getFoodProperties().getNutrition());
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
						player.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.velociraptor.wandering"), true);
					} else if(this.isTameWandering()) {
						this.setTameWandering(false);
						player.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.velociraptor.following"), true);
					} else {
						this.setTameSitting(true);
						player.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.velociraptor.sitting"), true);
					}
				}
			} else {
				if (this.isFood(itemstack)) {
					if (!player.getAbilities().instabuild) {
						itemstack.shrink(1);
					}

					if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
						this.tame(player);
						this.navigation.stop();
						this.setTarget((LivingEntity)null);
						this.setTameSitting(true);
						this.level.broadcastEntityEvent(this, (byte)7);
					} else {
						this.level.broadcastEntityEvent(this, (byte)6);
					}

					return InteractionResult.SUCCESS;
				}
			}
			return super.mobInteract(player, p_230254_2_);
		}
	}

	public class VelociraptorFollowOwnerGoal extends FollowOwnerGoal {

		public VelociraptorFollowOwnerGoal(TamableAnimal tameable, double speed, float minDist, float maxDist, boolean teleportToLeaves) {
			super(tameable, speed, minDist, maxDist, teleportToLeaves);
		}

		public boolean canUse() {
			return super.canUse();
		}

	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.VELOCIRAPTOR_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.VELOCIRAPTOR_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.VELOCIRAPTOR_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1)).setValue(NestAndEggsBlock.PLANT_LEVEL, Integer.valueOf(this.random.nextInt(3) + 1));
	}

}