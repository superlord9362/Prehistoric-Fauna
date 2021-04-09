package superlord.prehistoricfauna.entity;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import superlord.prehistoricfauna.block.IschigualastiaEggBlock;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.util.SoundHandler;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Predicate;

public class IschigualastiaEntity extends AnimalEntity {
	
	private static final DataParameter<Boolean> SADDLED = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> BOOST_TIME = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(BlockInit.CLADOPHLEBIS.asItem());
	private int warningSoundTicks;
	private int isDigging;
	private boolean boosting;
	private int boostTime;
	private int totalBoostTime;
	
	public IschigualastiaEntity(EntityType<? extends IschigualastiaEntity> type, World world) {
		super(type, world);
	}
	
	public AgeableEntity createChild(AgeableEntity ageable) {
		IschigualastiaEntity entity = new IschigualastiaEntity(ModEntityTypes.ISCHIGUALASTIA_ENTITY, this.world);
		entity.onInitialSpawn(world, this.world.getDifficultyForLocation(new BlockPos(entity)), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}
	
	public boolean isDigging() {
		return this.dataManager.get(IS_DIGGING);
	}
	
	private void setDigging(boolean isDigging) {
		this.isDigging = isDigging ? 1 : 0;
		this.dataManager.set(IS_DIGGING, isDigging);
	}
	
	public boolean hasEgg() {
		return this.dataManager.get(HAS_EGG);
	}
	
	private void setHasEgg(boolean hasEgg) {
		this.dataManager.set(HAS_EGG, hasEgg);
	}
	
	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
	}

	public boolean canBeSteered() {
		Entity entity = this.getControllingPassenger();
		if (!(entity instanceof PlayerEntity)) {
			return false;
		} else {
			PlayerEntity playerentity = (PlayerEntity)entity;
			return playerentity.getHeldItemMainhand().getItem() == ItemInit.CLADOPHEBLIS_STICK.get() || playerentity.getHeldItemOffhand().getItem() == ItemInit.CLADOPHEBLIS_STICK.get();
		}
	}
	
	public void notifyDataManagerChange(DataParameter<?> key) {
		if (BOOST_TIME.equals(key) && this.world.isRemote) {
			this.boosting = true;
			this.boostTime = 0;
			this.totalBoostTime = this.dataManager.get(BOOST_TIME);
		}

		super.notifyDataManagerChange(key);
	}
	
	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == BlockInit.CLADOPHLEBIS.asItem();
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new IschigualastiaEntity.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new IschigualastiaEntity.PanicGoal());
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.fromItems(ItemInit.CLADOPHEBLIS_STICK.get()), false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new IschigualastiaEntity.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new IschigualastiaEntity.AttackPlayerGoal());
		this.goalSelector.addGoal(8, new IschigualastiaEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new IschigualastiaEntity.MateGoal(this, 1.0D));
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.22D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
	}
	
	protected SoundEvent getAmbientSound() {
		return SoundHandler.ISCHIGUALASTIA_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundHandler.ISCHIGUALASTIA_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundHandler.ISCHIGUALASTIA_DEATH;
	}
	
	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundHandler.ISCHIGUALASTIA_WARN, 1.0F, this.getSoundPitch());
			this.warningSoundTicks = 40;
		}
	}
	
	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(SADDLED, false);
		this.dataManager.register(BOOST_TIME, 0);
	}
		   
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("Saddle", this.getSaddled());
	}
		   
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setSaddled(compound.getBoolean("Saddle"));
	}
	
	public boolean processInteract(PlayerEntity player, Hand hand) {
		if (super.processInteract(player, hand)) {
			return true;
		} else {
			ItemStack itemstack = player.getHeldItem(hand);
			if (itemstack.getItem() == Items.NAME_TAG) {
				itemstack.interactWithEntity(player, this, hand);
				return true;
			} else if (this.getSaddled() && !this.isBeingRidden()) {
				if (!this.world.isRemote) {
					player.startRiding(this);
				}

				return true;
			} else if (this.isAlive() && !this.getSaddled() && !this.isChild() && itemstack.getItem() == Items.SADDLE) {
				this.setSaddled(true);
				this.world.playSound(player, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_PIG_SADDLE, SoundCategory.NEUTRAL, 0.5F, 1.0F);
				itemstack.shrink(1);
				return true;
			} else {
				return itemstack.getItem() == Items.SADDLE && itemstack.interactWithEntity(player, this, hand);
			}
		}
	}
	
	protected void dropInventory() {
		super.dropInventory();
		if (this.getSaddled()) {
			this.entityDropItem(Items.SADDLE);
		}
	}
	
	public boolean getSaddled() {
		return this.dataManager.get(SADDLED);
	}
	
	public void setSaddled(boolean saddled) {
		if (saddled) {
			this.dataManager.set(SADDLED, true);
		} else {
			this.dataManager.set(SADDLED, false);
		}
	}
	
	public void travel(Vec3d positionIn) {
		if (this.isAlive()) {
			Entity entity = this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
			if (this.isBeingRidden() && this.canBeSteered()) {
				this.rotationYaw = entity.rotationYaw;
	            this.prevRotationYaw = this.rotationYaw;
	            this.rotationPitch = entity.rotationPitch * 0.5F;
	            this.setRotation(this.rotationYaw, this.rotationPitch);
	            this.renderYawOffset = this.rotationYaw;
	            this.rotationYawHead = this.rotationYaw;
	            this.stepHeight = 1.0F;
	            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
	            if (this.boosting && this.boostTime++ > this.totalBoostTime) {
	            	this.boosting = false;
	            }
	            if (this.canPassengerSteer()) {
	            	float f = (float)this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue() * 0.225F;
	            	if (this.boosting) {
	            		f += f * 1.15F * MathHelper.sin((float)this.boostTime / (float)this.totalBoostTime * (float)Math.PI);
	            	}
	            	this.setAIMoveSpeed(f);
	            	super.travel(new Vec3d(0.0D, 0.0D, 1.0D));
	            	this.newPosRotationIncrements = 0;
	            } else {
	            	this.setMotion(Vec3d.ZERO);
	            }
	            this.prevLimbSwingAmount = this.limbSwingAmount;
	            double d1 = this.getPosX() - this.prevPosX;
	            double d0 = this.getPosZ() - this.prevPosZ;
	            float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
	            if (f1 > 1.0F) {
	            	f1 = 1.0F;
	            }
	            this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
	            this.limbSwing += this.limbSwingAmount;
			} else {
				this.stepHeight = 0.5F;
	            this.jumpMovementFactor = 0.02F;
	            super.travel(positionIn);
			}
		}
	}

	public boolean boost() {
		if (this.boosting) {
			return false;
		} else {
			this.boosting = true;
			this.boostTime = 0;
			this.totalBoostTime = this.getRNG().nextInt(841) + 140;
			this.getDataManager().set(BOOST_TIME, this.totalBoostTime);
			return true;
		}
	}
	
	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}
	
	public boolean attackEntityAsMob(Entity entityIn) {
	      boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue()));
	      if (flag) {
	         this.applyEnchantments(this, entityIn);
	      }

	      return flag;
	   }	

	class AttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public AttackPlayerGoal() {
			super(IschigualastiaEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean shouldExecute() {
			if (IschigualastiaEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for(IschigualastiaEntity ischigualastia : IschigualastiaEntity.this.world.getEntitiesWithinAABB(IschigualastiaEntity.class, IschigualastiaEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
						if (ischigualastia.isChild()) {
							return true;
						}
					}
				}
				return false;
			}
		}
		
		protected double getTargetDistance() {
			return super.getTargetDistance() * 0.5D;
		}
	}

	class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(IschigualastiaEntity.this);
		}

		public void startExecuting() {
			super.startExecuting();
			if (IschigualastiaEntity.this.isChild()) {
				this.alertOthers();
				this.resetTask();
			}
		}

		protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
			if (mobIn instanceof IschigualastiaEntity && !mobIn.isChild()) {
				super.setAttackTarget(mobIn, targetIn);
			}
		}
	}

	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(IschigualastiaEntity.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.attackTick <= 0) {
				this.attackTick = 20;
				this.attacker.attackEntityAsMob(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.attackTick <= 0) {
					this.attackTick = 20;
				}
				if (this.attackTick <= 10) {
					IschigualastiaEntity.this.playWarningSound();
				}
			} else {
				this.attackTick = 20;
			}
		}

		public void resetTask() {
			super.resetTask();
		}

		protected double getAttackReachSqr(LivingEntity attackTarget) {
			return (double)(4.0F + attackTarget.getWidth());
		}
	}

	class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(IschigualastiaEntity.this, 2.0D);
		}

		public boolean shouldExecute() {
			return !IschigualastiaEntity.this.isChild() && !IschigualastiaEntity.this.isBurning() ? false : super.shouldExecute();
		}
	}
	   
	static class LayEggGoal extends MoveToBlockGoal {
		private final IschigualastiaEntity ischigualastia;

		LayEggGoal(IschigualastiaEntity ischigualastia, double speedIn) {
			super(ischigualastia, speedIn, 16);
			this.ischigualastia = ischigualastia;
		}

		public boolean shouldExecute() {
			return this.ischigualastia.hasEgg() ? super.shouldExecute() : false;
		}

		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && this.ischigualastia.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.ischigualastia);
			if (!this.ischigualastia.isInWater() && this.getIsAboveDestination()) {
				if (this.ischigualastia.isDigging < 1) {
					this.ischigualastia.setDigging(true);
				} else if (this.ischigualastia.isDigging > 200) {
					World world = this.ischigualastia.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), BlockInit.ISCHIGUALASTIA_EGG.getDefaultState().with(IschigualastiaEggBlock.EGGS, Integer.valueOf(this.ischigualastia.rand.nextInt(4) + 1)), 3);
					this.ischigualastia.setHasEgg(false);
					this.ischigualastia.setDigging(false);
					this.ischigualastia.setInLove(600);
				}
				if (this.ischigualastia.isDigging()) {
					this.ischigualastia.isDigging++;
				}
			}
		}
		
		protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			if (!worldIn.isAirBlock(pos.up())) {
				return false;
			} else {
				Block block = worldIn.getBlockState(pos).getBlock();
				return block == Blocks.COARSE_DIRT;
			}
		}
	}

	static class MateGoal extends BreedGoal {
		private final IschigualastiaEntity ischigualastia;

		MateGoal(IschigualastiaEntity ischigualastia, double speedIn) {
			super(ischigualastia, speedIn);
			this.ischigualastia = ischigualastia;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.ischigualastia.hasEgg();
		}

		protected void spawnBaby() {
			ServerPlayerEntity serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.targetMate.getLoveCause() != null) {
				serverplayerentity = this.targetMate.getLoveCause();
			}

			if (serverplayerentity != null) {
				serverplayerentity.addStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.targetMate, (AgeableEntity)null);
			}

			this.ischigualastia.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}
	}

}
