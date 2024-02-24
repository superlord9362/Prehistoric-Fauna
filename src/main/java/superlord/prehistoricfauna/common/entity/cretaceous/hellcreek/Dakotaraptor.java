package superlord.prehistoricfauna.common.entity.cretaceous.hellcreek;

import java.util.EnumSet;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
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
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
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
import superlord.prehistoricfauna.common.blocks.NestAndEggsBlock;
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.goal.AggressiveTempermentAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.BabyCarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreEatFromFeederGoal;
import superlord.prehistoricfauna.common.entity.goal.CarnivoreHuntGoal;
import superlord.prehistoricfauna.common.entity.goal.CrepuscularSleepGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurMateGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entity.goal.DinosaurTerritorialAttackGoal;
import superlord.prehistoricfauna.common.entity.goal.HostileCarnivoreGoal;
import superlord.prehistoricfauna.common.entity.goal.HuntGoal;
import superlord.prehistoricfauna.common.entity.goal.LayEggGoal;
import superlord.prehistoricfauna.common.entity.goal.NaturalMateGoal;
import superlord.prehistoricfauna.common.entity.goal.ProtectBabyGoal;
import superlord.prehistoricfauna.common.entity.goal.UnscheduledSleepingGoal;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.PFSounds;
import superlord.prehistoricfauna.init.PFTags;

public class Dakotaraptor extends DinosaurEntity {
	private static final EntityDataAccessor<Byte> DAKOTARAPTOR_FLAGS = SynchedEntityData.defineId(Dakotaraptor.class, EntityDataSerializers.BYTE);
	private static final EntityDataAccessor<Byte> CLIMBING = SynchedEntityData.defineId(Dakotaraptor.class, EntityDataSerializers.BYTE);
	private static final Predicate<LivingEntity> IS_PREY = (p_213498_0_) -> {
		return p_213498_0_.getType().is(PFTags.ANIMALS_3_HUNGER) || p_213498_0_.getType().is(PFTags.ANIMALS_4_HUNGER) || p_213498_0_.getType().is(PFTags.ANIMALS_6_HUNGER) || p_213498_0_.getType().is(PFTags.ANIMALS_8_HUNGER) || p_213498_0_.getType().is(PFTags.ANIMALS_10_HUNGER) || p_213498_0_.getType().is(PFTags.ANIMALS_15_HUNGER) || p_213498_0_.getType().is(PFTags.ANIMALS_20_HUNGER) || p_213498_0_.getType().is(PFTags.ANIMALS_30_HUNGER);
	};
	private Goal attackAnimals;
	private float interestedAngle;
	private float interestedAngleO;
	private float crouchAmount;
	private float crouchAmountO;
	private int warningSoundTicks;
	private int eatTicks;
	private int maxHunger = 75;
	private int climbingTicks = 0;
	private int climbingTickCooldown = 0;

	public boolean isFood(ItemStack stack) {
		return stack.getItem() == PFItems.RAW_SMALL_ORNITHISCHIAN_MEAT.get();
	}

	@Override
	protected PathNavigation createNavigation(Level worldIn) {
		return new WallClimberNavigation(this, worldIn);
	}

	@SuppressWarnings("deprecation")
	public Dakotaraptor(EntityType<? extends Dakotaraptor> type, Level worldIn) {
		super(type, worldIn);
		this.lookControl = new Dakotaraptor.LookHelperController();
		this.moveControl = new Dakotaraptor.MoveHelperController();
		this.setPathfindingMalus(BlockPathTypes.DANGER_OTHER, 0.0F);
		this.setPathfindingMalus(BlockPathTypes.DAMAGE_OTHER, 0.0F);
		this.maxUpStep = 1.0F;
		super.maxHunger = maxHunger;
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DAKOTARAPTOR_FLAGS, (byte)0);
		this.entityData.define(CLIMBING, (byte)0);
	}

	protected void registerGoals() {
		this.attackAnimals = new HuntGoal(this, LivingEntity.class, 10, false, false, (p_213498_0_) -> {
			return p_213498_0_.getType().is(PFTags.DAKOTARAPTOR_HUNTING);
		});
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new Dakotaraptor.JumpGoal());
		this.goalSelector.addGoal(2, new Dakotaraptor.PanicGoal());
		this.goalSelector.addGoal(0, new DinosaurMateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new NaturalMateGoal(this, 1.0D));
		this.targetSelector.addGoal(2, new ProtectBabyGoal(this));
		this.targetSelector.addGoal(2, new DinosaurTerritorialAttackGoal(this));
		this.targetSelector.addGoal(2, new AggressiveTempermentAttackGoal(this));
		this.goalSelector.addGoal(5, new Dakotaraptor.FollowTargetGoal());
		this.goalSelector.addGoal(1, new Dakotaraptor.PounceGoal());
		this.goalSelector.addGoal(6, new Dakotaraptor.FindShelterGoal(1.25D));
		this.goalSelector.addGoal(7, new Dakotaraptor.BiteGoal((double)1.2F, true));
		this.goalSelector.addGoal(7, new Dakotaraptor.SleepGoal());
		this.goalSelector.addGoal(8, new Dakotaraptor.FollowGoal(this, 1.25D));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(10, new LeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(11, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(13, new Dakotaraptor.SitAndLookGoal());
		this.targetSelector.addGoal(0, new HostileCarnivoreGoal(this, Player.class, false));
		this.goalSelector.addGoal(0, new LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, Ankylosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, Triceratops.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, Tyrannosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, Camarasaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, Stegosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, Allosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, Ceratosaurus.class, 7F, 1.5D, 1.75D));
		this.goalSelector.addGoal(1, new CrepuscularSleepGoal(this));
		this.goalSelector.addGoal(1, new UnscheduledSleepingGoal(this));
		this.targetSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213498_0_) -> {
			return p_213498_0_.getType().is(PFTags.DAKOTARAPTOR_HUNTING);
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, 1.75D, true, false, (p_213498_0_) -> {
			return p_213498_0_.getType().is(PFTags.DAKOTARAPTOR_HUNTING);
		}));
		this.goalSelector.addGoal(0, new CarnivoreEatFromFeederGoal(this, (double)1.2F, 12, 2));
	}
	
	@Override
	public void setAge(int age) {
		super.setAge(age);
		if (this.getAge() >= -24000 && this.getAge() < 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(15);
		} else if(this.getAge() >= 0) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30);
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
		if (!this.isNoAi()) {

			if (this.isSleeping() || this.isMovementBlocked()) {
				this.jumping = false;
				this.xxa = 0.0F;
				this.zza = 0.0F;
			}
			super.aiStep();
			if (this.isDakotaraptorAggroed() && this.random.nextFloat() < 0.05F) {
			}
		}
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

	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		int temperment = random.nextInt(100);
		if (temperment < 80) {
			this.setProtective(true);
		} else if (temperment >= 80 && temperment < 95) {
			this.setAggressive(true);
		} else if (temperment >= 95) {
			this.setTerritorial(true);
		}
		this.setCarnivorous(true);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
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
	}

	public boolean isSitting() {
		return this.getDakotaraptorFlag(1);
	}

	public void setSitting(boolean p_213466_1_) {
		this.setDakotaraptorFlag(1, p_213466_1_);
	}

	public boolean isStuck() {
		return this.getDakotaraptorFlag(64);
	}

	private void setStuck(boolean p_213492_1_) {
		this.setDakotaraptorFlag(64, p_213492_1_);
	}

	private boolean isDakotaraptorAggroed() {
		return this.getDakotaraptorFlag(128);
	}

	private void setDakotaraptorAggroed(boolean p_213482_1_) {
		this.setDakotaraptorFlag(128, p_213482_1_);
	}

	/**
	 * Returns whether player is sleeping or not
	 */
	public boolean isSleeping() {
		return this.getDakotaraptorFlag(32);
	}

	public void setSleeping(boolean p_213485_1_) {
		this.setDakotaraptorFlag(32, p_213485_1_);
	}

	private void setDakotaraptorFlag(int p_213505_1_, boolean p_213505_2_) {
		if (p_213505_2_) {
			this.entityData.set(DAKOTARAPTOR_FLAGS, (byte)(this.entityData.get(DAKOTARAPTOR_FLAGS) | p_213505_1_));
		} else {
			this.entityData.set(DAKOTARAPTOR_FLAGS, (byte)(this.entityData.get(DAKOTARAPTOR_FLAGS) & ~p_213505_1_));
		}

	}

	private boolean getDakotaraptorFlag(int p_213507_1_) {
		return (this.entityData.get(DAKOTARAPTOR_FLAGS) & p_213507_1_) != 0;
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
		return this.getDakotaraptorFlag(16);
	}

	public void func_213461_s(boolean p_213461_1_) {
		this.setDakotaraptorFlag(16, p_213461_1_);
	}

	public boolean func_213490_ee() {
		return this.crouchAmount == 3.0F;
	}

	public void setCrouching(boolean p_213451_1_) {
		this.setDakotaraptorFlag(4, p_213451_1_);
	}

	public boolean isCrouching() {
		return this.getDakotaraptorFlag(4);
	}

	public void func_213502_u(boolean p_213502_1_) {
		this.setDakotaraptorFlag(8, p_213502_1_);
	}

	public boolean func_213467_eg() {
		return this.getDakotaraptorFlag(8);
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
		if (this.isDakotaraptorAggroed() && entitylivingbaseIn == null) {
			this.setDakotaraptorAggroed(false);
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
		this.setDakotaraptorAggroed(false);
		this.setStuck(false);
	}

	private boolean func_213478_eo() {
		return !this.isSleeping() && !this.isSitting() && !this.isStuck();
	}

	protected SoundEvent getAmbientSound()  {
		return this.isAsleep() ? null : PFSounds.DAKOTARAPTOR_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return PFSounds.DAKOTARAPTOR_HURT;
	}

	protected SoundEvent getDeathSound() {
		return PFSounds.DAKOTARAPTOR_DEATH;
	}

	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		if (this.isBaby()) return 1.075F;
		else return 2.15F;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(PFSounds.DAKOTARAPTOR_WARN, 1.0F, this.getVoicePitch());
			this.warningSoundTicks = 40;
		}
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 30.0D).add(Attributes.MOVEMENT_SPEED, 0.25D).add(Attributes.FOLLOW_RANGE, 20.0D).add(Attributes.ATTACK_DAMAGE, 6.0D).add(Attributes.KNOCKBACK_RESISTANCE, 0.1D);
	}

	public static boolean func_213481_a(Dakotaraptor p_213481_0_, LivingEntity p_213481_1_) {
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
			if (p_test_1_ instanceof Dakotaraptor) {
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
		private final TargetingConditions field_220816_b = TargetingConditions.forCombat().range(12.0D).ignoreLineOfSight().selector(Dakotaraptor.this.new AlertablePredicate());

		private BaseGoal() {
		}

		protected boolean hasShelter() {
			BlockPos blockpos = new BlockPos(Dakotaraptor.this.position());
			return !Dakotaraptor.this.level.canSeeSky(blockpos) && Dakotaraptor.this.getWalkTargetValue(blockpos) >= 0.0F;
		}

		protected boolean alertable() {
			return !Dakotaraptor.this.level.getNearbyEntities(LivingEntity.class, this.field_220816_b, Dakotaraptor.this, Dakotaraptor.this.getBoundingBox().inflate(12.0D, 6.0D, 12.0D)).isEmpty();
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
			Dakotaraptor.this.func_213502_u(false);
			super.start();
		}

		public boolean canUse() {
			return !Dakotaraptor.this.isSitting() && !Dakotaraptor.this.isSleeping() && !Dakotaraptor.this.isCrouching() && !Dakotaraptor.this.isStuck() && super.canUse();
		}
	}

	class FindShelterGoal extends FleeSunGoal {
		private int cooldown = 100;

		public FindShelterGoal(double p_i50724_2_) {
			super(Dakotaraptor.this, p_i50724_2_);
		}

		public boolean canUse() {
			if (!Dakotaraptor.this.isSleeping() && this.mob.getTarget() == null) {
				if (Dakotaraptor.this.level.isThundering()) {
					return true;
				} else if (this.cooldown > 0) {
					--this.cooldown;
					return false;
				} else {
					this.cooldown = 100;
					BlockPos blockpos = new BlockPos(this.mob.position());
					return Dakotaraptor.this.level.isDay() && Dakotaraptor.this.level.canSeeSky(blockpos) && !((ServerLevel)Dakotaraptor.this.level).isVillage(blockpos) && this.setWantedPos();
				}
			} else {
				return false;
			}
		}

		public void start() {
			Dakotaraptor.this.func_213499_en();
			super.start();
		}
	}

	class FollowGoal extends FollowParentGoal {
		private final Dakotaraptor owner;

		public FollowGoal(Dakotaraptor p_i50735_2_, double p_i50735_3_) {
			super(p_i50735_2_, p_i50735_3_);
			this.owner = p_i50735_2_;
		}

		public boolean canUse() {
			return !this.owner.isDakotaraptorAggroed() && super.canUse();
		}

		public boolean canContinueToUse() {
			return !this.owner.isDakotaraptorAggroed() && super.canContinueToUse();
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
			if (Dakotaraptor.this.isSleeping()) {
				return false;
			} else {
				LivingEntity livingentity = Dakotaraptor.this.getTarget();
				return livingentity != null && livingentity.isAlive() && Dakotaraptor.IS_PREY.test(livingentity) && Dakotaraptor.this.distanceToSqr(livingentity) > 36.0D && !Dakotaraptor.this.isCrouching() && !Dakotaraptor.this.func_213467_eg() && !Dakotaraptor.this.jumping;
			}
		}

		public void start() {
			Dakotaraptor.this.setSitting(false);
			Dakotaraptor.this.setStuck(false);
		}

		public void stop() {
			LivingEntity livingentity = Dakotaraptor.this.getTarget();
			if (livingentity != null && Dakotaraptor.func_213481_a(Dakotaraptor.this, livingentity)) {
				Dakotaraptor.this.func_213502_u(true);
				Dakotaraptor.this.setCrouching(true);
				Dakotaraptor.this.setCrouchingTicks(0);
				Dakotaraptor.this.getNavigation().stop();
				Dakotaraptor.this.getLookControl().setLookAt(livingentity, (float)Dakotaraptor.this.getMaxHeadYRot(), (float)Dakotaraptor.this.getMaxHeadXRot());
			} else {
				Dakotaraptor.this.func_213502_u(false);
				Dakotaraptor.this.setCrouching(false);
				Dakotaraptor.this.setCrouchingTicks(31);
				Dakotaraptor.this.setWakingTicks(0);
			}

		}

		public void tick() {
			LivingEntity livingentity = Dakotaraptor.this.getTarget();
			Dakotaraptor.this.getLookControl().setLookAt(livingentity, (float)Dakotaraptor.this.getMaxHeadYRot(), (float)Dakotaraptor.this.getMaxHeadXRot());
			if (Dakotaraptor.this.distanceToSqr(livingentity) <= 36.0D) {
				Dakotaraptor.this.func_213502_u(true);
				Dakotaraptor.this.setCrouching(true);
				Dakotaraptor.this.setCrouchingTicks(0);
				Dakotaraptor.this.getNavigation().stop();
			} else {
				Dakotaraptor.this.getNavigation().moveTo(livingentity, 1.5D);
			}

		}
	}

	class JumpGoal extends Goal {
		int delay;

		public JumpGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.JUMP, Goal.Flag.MOVE));
		}

		public boolean canUse() {
			return Dakotaraptor.this.isStuck();
		}

		public boolean canContinueToUse() {
			return this.canUse() && this.delay > 0;
		}

		public void start() {
			this.delay = 40;
		}

		public void stop() {
			Dakotaraptor.this.setStuck(false);
		}

		public void tick() {
			--this.delay;
		}
	}

	public class LookHelperController extends LookControl {
		public LookHelperController() {
			super(Dakotaraptor.this);
		}

		public void tick() {
			if (!Dakotaraptor.this.isSleeping()) {
				super.tick();
			}

		}

		protected boolean func_220680_b() {
			return !Dakotaraptor.this.func_213480_dY() && !Dakotaraptor.this.isCrouching() && !Dakotaraptor.this.func_213467_eg() & !Dakotaraptor.this.isStuck();
		}
	}

	class MoveHelperController extends MoveControl {
		public MoveHelperController() {
			super(Dakotaraptor.this);
		}

		public void tick() {
			if (Dakotaraptor.this.func_213478_eo()) {
				super.tick();
			}

		}
	}

	public class PounceGoal extends net.minecraft.world.entity.ai.goal.JumpGoal {
		public boolean canUse() {
			if (!Dakotaraptor.this.func_213490_ee()) {
				return false;
			} else {
				LivingEntity livingentity = Dakotaraptor.this.getTarget();
				if (livingentity != null && livingentity.isAlive()) {
					if (livingentity.getMotionDirection() != livingentity.getDirection()) {
						return false;
					} else {
						boolean flag = Dakotaraptor.func_213481_a(Dakotaraptor.this, livingentity);
						if (!flag) {
							Dakotaraptor.this.getNavigation().createPath(livingentity, 0);
							Dakotaraptor.this.setCrouching(false);
							Dakotaraptor.this.func_213502_u(false);
						}

						return flag;
					}
				} else {
					return false;
				}
			}
		}

		public boolean canContinueToUse() {
			LivingEntity livingentity = Dakotaraptor.this.getTarget();
			if (livingentity != null && livingentity.isAlive()) {
				double d0 = Dakotaraptor.this.getDeltaMovement().y;
				return (!(d0 * d0 < (double)0.05F) || !(Math.abs(Dakotaraptor.this.xRot) < 15.0F) || !Dakotaraptor.this.onGround) && !Dakotaraptor.this.isStuck();
			} else {
				return false;
			}
		}

		public boolean isPreemptible() {
			return false;
		}

		public void start() {
			Dakotaraptor.this.setJumping(true);
			Dakotaraptor.this.func_213461_s(true);
			Dakotaraptor.this.func_213502_u(false);
			LivingEntity livingentity = Dakotaraptor.this.getTarget();
			Dakotaraptor.this.getLookControl().setLookAt(livingentity, 60.0F, 30.0F);
			Vec3 vec3d = (new Vec3(livingentity.getX() - Dakotaraptor.this.getX(), livingentity.getY() - Dakotaraptor.this.getY(), livingentity.getZ() - Dakotaraptor.this.getZ())).normalize();
			Dakotaraptor.this.setDeltaMovement(Dakotaraptor.this.getDeltaMovement().add(vec3d.x * 0.8D, 0.9D, vec3d.z * 0.8D));
			Dakotaraptor.this.getNavigation().stop();
		}

		public void stop() {
			Dakotaraptor.this.setCrouching(false);
			Dakotaraptor.this.crouchAmount = 0.0F;
			Dakotaraptor.this.crouchAmountO = 0.0F;
			Dakotaraptor.this.func_213502_u(false);
			Dakotaraptor.this.func_213461_s(false);
		}

		public void tick() {
			LivingEntity livingentity = Dakotaraptor.this.getTarget();
			if (livingentity != null) {
				Dakotaraptor.this.getLookControl().setLookAt(livingentity, 60.0F, 30.0F);
			}

			if (!Dakotaraptor.this.isStuck()) {
				Vec3 vec3d = Dakotaraptor.this.getDeltaMovement();
				if (vec3d.y * vec3d.y < (double)0.03F && Dakotaraptor.this.xRot != 0.0F) {
					Dakotaraptor.this.xRot = Mth.rotLerp(Dakotaraptor.this.xRot, 0.0F, 0.2F);
				} else {
					double d0 = vec3d.horizontalDistance();
					double d1 = Math.signum(-vec3d.y) * Math.acos(d0 / vec3d.length()) * (double)(180F / (float)Math.PI);
					Dakotaraptor.this.xRot = (float)d1;
				}
			}

			if (livingentity != null && Dakotaraptor.this.distanceTo(livingentity) <= 2.0F) {
				Dakotaraptor.this.doHurtTarget(livingentity);
			} else if (Dakotaraptor.this.xRot > 0.0F && Dakotaraptor.this.onGround && (float)Dakotaraptor.this.getDeltaMovement().y != 0.0F && Dakotaraptor.this.level.getBlockState(new BlockPos(Dakotaraptor.this.position())).getBlock() == Blocks.SNOW) {
				Dakotaraptor.this.xRot = 60.0F;
				Dakotaraptor.this.setTarget((LivingEntity)null);
			}

		}
	}

	class PanicGoal extends net.minecraft.world.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(Dakotaraptor.this, 2.0D);
		}

		public boolean canUse() {
			return !Dakotaraptor.this.isBaby() && !Dakotaraptor.this.isOnFire() ? false : super.canUse();
		}

	}

	class SitAndLookGoal extends Dakotaraptor.BaseGoal {
		private double field_220819_c;
		private double field_220820_d;
		private int field_220821_e;
		private int field_220822_f;

		public SitAndLookGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		public boolean canUse() {
			return Dakotaraptor.this.getLastHurtByMob() == null && Dakotaraptor.this.getRandom().nextFloat() < 0.02F && !Dakotaraptor.this.isSleeping() && Dakotaraptor.this.getTarget() == null && Dakotaraptor.this.getNavigation().isDone() && !this.alertable() && !Dakotaraptor.this.func_213480_dY() && !Dakotaraptor.this.isCrouching();
		}

		public boolean canContinueToUse() {
			return this.field_220822_f > 0;
		}

		public void start() {
			this.func_220817_j();
			this.field_220822_f = 2 + Dakotaraptor.this.getRandom().nextInt(3);
			Dakotaraptor.this.setSitting(true);
			Dakotaraptor.this.getNavigation().stop();
		}

		public void stop() {
			Dakotaraptor.this.setSitting(false);
			Dakotaraptor.this.setWakingTicks(0);
		}

		public void tick() {
			--this.field_220821_e;
			if (this.field_220821_e <= 0) {
				--this.field_220822_f;
				this.func_220817_j();
			}

			Dakotaraptor.this.getLookControl().setLookAt(Dakotaraptor.this.getX() + this.field_220819_c, Dakotaraptor.this.getEyeY(), Dakotaraptor.this.getZ() + this.field_220820_d, (float)Dakotaraptor.this.getMaxHeadYRot(), (float)Dakotaraptor.this.getMaxHeadXRot());
		}

		private void func_220817_j() {
			double d0 = (Math.PI * 2D) * Dakotaraptor.this.getRandom().nextDouble();
			this.field_220819_c = Math.cos(d0);
			this.field_220820_d = Math.sin(d0);
			this.field_220821_e = 80 + Dakotaraptor.this.getRandom().nextInt(20);
		}
	}

	class SleepGoal extends Dakotaraptor.BaseGoal {
		private static final int WAIT_TIME_BEFORE_SLEEP = reducedTickDelay(140);
		private int countdown = Dakotaraptor.this.random.nextInt(WAIT_TIME_BEFORE_SLEEP);

		public SleepGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
		}

		public boolean canUse() {
			if (Dakotaraptor.this.xxa == 0.0F && Dakotaraptor.this.yya == 0.0F && Dakotaraptor.this.zza == 0.0F && !PrehistoricFaunaConfig.sleeping) {
				return this.canSleep() || Dakotaraptor.this.isSleeping();
			} else {
				return false;
			}
		}

		public boolean canContinueToUse() {
			return this.canSleep();
		}

		private boolean canSleep() {
			if (this.countdown > 0) {
				--this.countdown;
				return false;
			} else {
				return Dakotaraptor.this.level.isDay() && this.hasShelter() && !this.alertable() && !Dakotaraptor.this.isInPowderSnow;
			}
		}

		public void stop() {
			this.countdown = Dakotaraptor.this.random.nextInt(WAIT_TIME_BEFORE_SLEEP);
			Dakotaraptor.this.func_213499_en();
			Dakotaraptor.this.setWakingTicks(0);
		}

		public void start() {
			Dakotaraptor.this.setSitting(false);
			Dakotaraptor.this.setCrouching(false);
			Dakotaraptor.this.func_213502_u(false);
			Dakotaraptor.this.setJumping(false);
			Dakotaraptor.this.setSleeping(true);
			Dakotaraptor.this.getNavigation().stop();
			Dakotaraptor.this.getMoveControl().setWantedPosition(Dakotaraptor.this.getX(), Dakotaraptor.this.getY(), Dakotaraptor.this.getZ(), 0.0D);
		}
	}

	class WatchGoal extends LookAtPlayerGoal {
		public WatchGoal(Mob p_i50733_2_, Class<? extends LivingEntity> p_i50733_3_, float p_i50733_4_) {
			super(p_i50733_2_, p_i50733_3_, p_i50733_4_);
		}

		public boolean canUse() {
			return super.canUse() && !Dakotaraptor.this.isStuck() && !Dakotaraptor.this.func_213467_eg();
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && !Dakotaraptor.this.isStuck() && !Dakotaraptor.this.func_213467_eg();
		}
	}

	class MeleeAttackGoal extends net.minecraft.world.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(Dakotaraptor.this, 1.25D, true);
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
					Dakotaraptor.this.playWarningSound();
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
		if(this.isOnGround()){
			Vec3 vector3d = this.getDeltaMovement();
			Vec3 vector3d1 = new Vec3(entity.getX() - this.getX(), 0.0D, entity.getZ() - this.getZ());
			if (vector3d1.lengthSqr() > 1.0E-7D) {
				vector3d1 = vector3d1.normalize().scale(0.5D).add(vector3d.scale(0.2D));
			}
			this.lookAt(EntityAnchorArgument.Anchor.EYES, entity.getEyePosition(1.0F));
			this.setDeltaMovement(vector3d1.x, 0.4D, vector3d1.z);
		}
		return flag;
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		Dakotaraptor entity = new Dakotaraptor(PFEntities.DAKOTARAPTOR.get(), this.level);
		entity.finalizeSpawn(p_241840_1_, this.level.getCurrentDifficultyAt(new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ())), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
		return entity;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.DAKOTARAPTOR_SPAWN_EGG.get());
	}

	public Item getEggItem() {
		return PFItems.DAKOTARAPTOR_EGG.get();
	}

	public BlockState getEggBlock(Level world, BlockPos pos) {
		return PFBlocks.DAKOTARAPTOR_NEST.get().defaultBlockState().setValue(NestAndEggsBlock.EGGS, Integer.valueOf(this.random.nextInt(4) + 1)).setValue(NestAndEggsBlock.PLANT_LEVEL, Integer.valueOf(this.random.nextInt(3) + 1));
	}
}