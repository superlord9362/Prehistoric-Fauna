package superlord.prehistoricfauna.entity;

import java.util.EnumSet;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.controller.LookController;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FleeSunGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.stats.Stats;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.block.DakotaraptorEggBlock;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.util.SoundHandler;

public class DakotaraptorEntity extends PrehistoricEntity {
	private static final DataParameter<Byte> DAKOTARAPTOR_FLAGS = EntityDataManager.createKey(DakotaraptorEntity.class, DataSerializers.BYTE);
	private static final Predicate<Entity> IS_PREY = (p_213498_0_) -> {
		return p_213498_0_ instanceof ThescelosaurusEntity || p_213498_0_ instanceof BasilemysEntity || p_213498_0_ instanceof DryosaurusEntity || p_213498_0_ instanceof HesperornithoidesEntity || p_213498_0_ instanceof EilenodonEntity || p_213498_0_ instanceof DidelphodonEntity;
	};
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(DakotaraptorEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(DakotaraptorEntity.class, DataSerializers.BOOLEAN);
	private Goal attackAnimals;
	private float interestedAngle;
	private float interestedAngleO;
	private float crouchAmount;
	private float crouchAmountO;
	private int warningSoundTicks;
	private int isDigging;

	public boolean hasEgg() {
		return this.dataManager.get(HAS_EGG);
	}

	private void setHasEgg(boolean hasEgg) {
		this.dataManager.set(HAS_EGG, hasEgg);
	}

	public boolean isDigging() {
		return this.dataManager.get(IS_DIGGING);
	}

	private void setDigging(boolean isDigging) {
		this.isDigging = isDigging ? 1 : 0;
		this.dataManager.set(IS_DIGGING, isDigging);
	}

	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == ItemInit.RAW_THESCELOSAURUS_MEAT.get();
	}


	public DakotaraptorEntity(EntityType<? extends DakotaraptorEntity> type, World worldIn) {
		super(type, worldIn);
		this.lookController = new DakotaraptorEntity.LookHelperController();
		this.moveController = new DakotaraptorEntity.MoveHelperController();
		this.setPathPriority(PathNodeType.DANGER_OTHER, 0.0F);
		this.setPathPriority(PathNodeType.DAMAGE_OTHER, 0.0F);
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(DAKOTARAPTOR_FLAGS, (byte)0);
	}

	protected void registerGoals() {
		this.attackAnimals = new NearestAttackableTargetGoal<>(this, AnimalEntity.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof ThescelosaurusEntity || p_213487_0_ instanceof BasilemysEntity || p_213487_0_ instanceof DryosaurusEntity || p_213487_0_ instanceof HesperornithoidesEntity || p_213487_0_ instanceof EilenodonEntity || p_213487_0_ instanceof DidelphodonEntity;
		});
		this.goalSelector.addGoal(0, new DakotaraptorEntity.SwimGoal());
		this.goalSelector.addGoal(1, new DakotaraptorEntity.JumpGoal());
		this.goalSelector.addGoal(2, new DakotaraptorEntity.PanicGoal());
		this.goalSelector.addGoal(3, new DakotaraptorEntity.MateGoal(this, 1.0D));
		this.targetSelector.addGoal(2, new DakotaraptorEntity.AttackPlayerGoal());
		this.goalSelector.addGoal(5, new DakotaraptorEntity.FollowTargetGoal());
		this.goalSelector.addGoal(6, new DakotaraptorEntity.PounceGoal());
		this.goalSelector.addGoal(6, new DakotaraptorEntity.FindShelterGoal(1.25D));
		this.goalSelector.addGoal(7, new DakotaraptorEntity.BiteGoal((double)1.2F, true));
		this.goalSelector.addGoal(7, new DakotaraptorEntity.SleepGoal());
		this.goalSelector.addGoal(8, new DakotaraptorEntity.FollowGoal(this, 1.25D));
		this.targetSelector.addGoal(1, new DakotaraptorEntity.HurtByTargetGoal());
		this.goalSelector.addGoal(10, new LeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(11, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(12, new DakotaraptorEntity.WatchGoal(this, PlayerEntity.class, 24.0F));
		this.goalSelector.addGoal(13, new DakotaraptorEntity.SitAndLookGoal());
		this.goalSelector.addGoal(8, new DakotaraptorEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, AnkylosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, TriceratopsEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, TyrannosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, CamarasaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, StegosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, AllosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, CeratosaurusEntity.class, 7F, 1.25D, 1.25D));
	}

	public void livingTick() {
		if (!this.world.isRemote && this.isAlive() && this.isServerWorld()) {
			LivingEntity livingentity = this.getAttackTarget();
			if (livingentity == null || !livingentity.isAlive()) {
				this.setCrouching(false);
				this.func_213502_u(false);
			}
		}
		if (this.getAttackTarget() != null) {
			if (this.getRidingEntity() != null) {
				if (this.getRidingEntity() == this.getAttackTarget() && this.ticksExisted % 20 == 0) {
					IAttributeInstance iattributeinstance = this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
					this.getAttackTarget().attackEntityFrom(DamageSource.causeMobDamage(this), (float) iattributeinstance.getBaseValue());
				}
			}
		}

		if (this.isSleeping() || this.isMovementBlocked()) {
			this.isJumping = false;
			this.moveStrafing = 0.0F;
			this.moveForward = 0.0F;
		}

		super.livingTick();
		if (this.isDakotaraptorAggroed() && this.rand.nextFloat() < 0.05F) {
		}

	}

	protected boolean isMovementBlocked() {
		return this.getHealth() <= 0.0F;
	}

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		if (this.rand.nextFloat() < 0.2F) {
			float f = this.rand.nextFloat();
			ItemStack itemstack;
			if (f < 0.05F) {
				itemstack = new ItemStack(Items.EMERALD);
			} else if (f < 0.2F) {
				itemstack = new ItemStack(Items.EGG);
			} else if (f < 0.4F) {
				itemstack = this.rand.nextBoolean() ? new ItemStack(Items.RABBIT_FOOT) : new ItemStack(Items.RABBIT_HIDE);
			} else if (f < 0.6F) {
				itemstack = new ItemStack(Items.WHEAT);
			} else if (f < 0.8F) {
				itemstack = new ItemStack(Items.LEATHER);
			} else {
				itemstack = new ItemStack(Items.FEATHER);
			}

			this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemstack);
		}

	}

	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 45) {
			ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
			if (!itemstack.isEmpty()) {
				for(int i = 0; i < 8; ++i) {
					Vec3d vec3d = (new Vec3d(((double)this.rand.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D)).rotatePitch(-this.rotationPitch * ((float)Math.PI / 180F)).rotateYaw(-this.rotationYaw * ((float)Math.PI / 180F));
					this.world.addParticle(new ItemParticleData(ParticleTypes.ITEM, itemstack), this.getPosX() + this.getLookVec().x / 2.0D, this.getPosY(), this.getPosZ() + this.getLookVec().z / 2.0D, vec3d.x, vec3d.y + 0.05D, vec3d.z);
				}
			}
		} else {
			super.handleStatusUpdate(id);
		}

	}
	
	@Override
    public void applyEntityCollision(Entity entity) {
        super.applyEntityCollision(entity);
        if (this.getAttackTarget() != null) {
             if (this.getAttackTarget() == entity && !onGround && this.getRidingEntity() != entity) {
                this.startRiding(entity);
            }
        }
    }
	
	 @Override
	    public boolean attackEntityFrom(DamageSource dmg, float i) {
	        if (this.getRidingEntity() != null) {
	            if (this.getLastAttackedEntity() != null) {
	                if (this.getLastAttackedEntity() == this.getRidingEntity()) {
	                    if (this.getRNG().nextInt(2) == 0) {
	                        this.stopRiding();
	                    }
	                }
	            }
	        }
	        return super.attackEntityFrom(dmg, i);
	    }

	public AgeableEntity createChild(AgeableEntity ageable) {
		DakotaraptorEntity entity = new DakotaraptorEntity(ModEntityTypes.DAKOTARAPTOR_ENTITY, this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, this.attackAnimals);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("Sleeping", this.isSleeping());
		compound.putBoolean("Sitting", this.isSitting());
		compound.putBoolean("Crouching", this.isCrouching());
		compound.putBoolean("HasEgg", this.hasEgg());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setSleeping(compound.getBoolean("Sleeping"));
		this.setSitting(compound.getBoolean("Sitting"));
		this.setCrouching(compound.getBoolean("Crouching"));
		this.setHasEgg(compound.getBoolean("HasEgg"));
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

	private void setSleeping(boolean p_213485_1_) {
		this.setDakotaraptorFlag(32, p_213485_1_);
	}

	private void setDakotaraptorFlag(int p_213505_1_, boolean p_213505_2_) {
		if (p_213505_2_) {
			this.dataManager.set(DAKOTARAPTOR_FLAGS, (byte)(this.dataManager.get(DAKOTARAPTOR_FLAGS) | p_213505_1_));
		} else {
			this.dataManager.set(DAKOTARAPTOR_FLAGS, (byte)(this.dataManager.get(DAKOTARAPTOR_FLAGS) & ~p_213505_1_));
		}

	}

	private boolean getDakotaraptorFlag(int p_213507_1_) {
		return (this.dataManager.get(DAKOTARAPTOR_FLAGS) & p_213507_1_) != 0;
	}

	public void tick() {
		super.tick();
		if (this.isServerWorld()) {
			boolean flag = this.isInWater();
			if (flag || this.getAttackTarget() != null || this.world.isThundering()) {
				this.func_213454_em();
			}

			if (flag || this.isSleeping()) {
				this.setSitting(false);
			}

			if (this.isStuck() && this.world.rand.nextFloat() < 0.2F) {
				BlockPos blockpos = new BlockPos(this);
				BlockState blockstate = this.world.getBlockState(blockpos);
				this.world.playEvent(2001, blockpos, Block.getStateId(blockstate));
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
		return MathHelper.lerp(p_213475_1_, this.interestedAngleO, this.interestedAngle) * 0.11F * (float)Math.PI;
	}

	@OnlyIn(Dist.CLIENT)
	public float func_213503_w(float p_213503_1_) {
		return MathHelper.lerp(p_213503_1_, this.crouchAmountO, this.crouchAmount);
	}

	public void setAttackTarget(@Nullable LivingEntity entitylivingbaseIn) {
		if (this.isDakotaraptorAggroed() && entitylivingbaseIn == null) {
			this.setDakotaraptorAggroed(false);
		}

		super.setAttackTarget(entitylivingbaseIn);
	}

	protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
		return MathHelper.ceil((p_225508_1_ - 5.0F) * p_225508_2_);
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
		return SoundHandler.DAKOTARAPTOR_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundHandler.DAKOTARAPTOR_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundHandler.DAKOTARAPTOR_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundHandler.DAKOTARAPTOR_WARN, 1.0F, this.getSoundPitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	}

	public static boolean func_213481_a(DakotaraptorEntity p_213481_0_, LivingEntity p_213481_1_) {
		double d0 = p_213481_1_.getPosZ() - p_213481_0_.getPosZ();
		double d1 = p_213481_1_.getPosX() - p_213481_0_.getPosX();
		double d2 = d0 / d1;
		for(int j = 0; j < 6; ++j) {
			double d3 = d2 == 0.0D ? 0.0D : d0 * (double)((float)j / 6.0F);
			double d4 = d2 == 0.0D ? d1 * (double)((float)j / 6.0F) : d3 / d2;

			for(int k = 1; k < 4; ++k) {
				if (!p_213481_0_.world.getBlockState(new BlockPos(p_213481_0_.getPosX() + d4, p_213481_0_.getPosY() + (double)k, p_213481_0_.getPosZ() + d3)).getMaterial().isReplaceable()) {
					return false;
				}
			}
		}

		return true;
	}

	public class AlertablePredicate implements Predicate<LivingEntity> {
		public boolean test(LivingEntity p_test_1_) {
			if (p_test_1_ instanceof DakotaraptorEntity) {
				return false;
			} else if (!(p_test_1_ instanceof ChickenEntity) && !(p_test_1_ instanceof RabbitEntity) && !(p_test_1_ instanceof MonsterEntity)) {
				if (p_test_1_ instanceof TameableEntity) {
					return !((TameableEntity)p_test_1_).isTamed();
				} else if (!(p_test_1_ instanceof PlayerEntity) || !p_test_1_.isSpectator() && !((PlayerEntity)p_test_1_).isCreative()) {
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
		private final EntityPredicate field_220816_b = (new EntityPredicate()).setDistance(12.0D).setLineOfSiteRequired().setCustomPredicate(DakotaraptorEntity.this.new AlertablePredicate());

		private BaseGoal() {
		}

		protected boolean func_220813_g() {
			BlockPos blockpos = new BlockPos(DakotaraptorEntity.this);
			return !DakotaraptorEntity.this.world.canSeeSky(blockpos) && DakotaraptorEntity.this.getBlockPathWeight(blockpos) >= 0.0F;
		}

		protected boolean func_220814_h() {
			return !DakotaraptorEntity.this.world.getTargettableEntitiesWithinAABB(LivingEntity.class, this.field_220816_b, DakotaraptorEntity.this, DakotaraptorEntity.this.getBoundingBox().grow(12.0D, 6.0D, 12.0D)).isEmpty();
		}
	}

	class BiteGoal extends MeleeAttackGoal {
		public BiteGoal(double p_i50731_2_, boolean p_i50731_4_) {
			super();
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.attackTick <= 0) {
				this.attackTick = 20;
				this.attacker.attackEntityAsMob(enemy);
			}

		}

		public void startExecuting() {
			DakotaraptorEntity.this.func_213502_u(false);
			super.startExecuting();
		}

		public boolean shouldExecute() {
			return !DakotaraptorEntity.this.isSitting() && !DakotaraptorEntity.this.isSleeping() && !DakotaraptorEntity.this.isCrouching() && !DakotaraptorEntity.this.isStuck() && super.shouldExecute();
		}
	}

	class FindShelterGoal extends FleeSunGoal {
		private int cooldown = 100;

		public FindShelterGoal(double p_i50724_2_) {
			super(DakotaraptorEntity.this, p_i50724_2_);
		}

		public boolean shouldExecute() {
			if (!DakotaraptorEntity.this.isSleeping() && this.creature.getAttackTarget() == null) {
				if (DakotaraptorEntity.this.world.isThundering()) {
					return true;
				} else if (this.cooldown > 0) {
					--this.cooldown;
					return false;
				} else {
					this.cooldown = 100;
					BlockPos blockpos = new BlockPos(this.creature);
					return DakotaraptorEntity.this.world.isDaytime() && DakotaraptorEntity.this.world.canSeeSky(blockpos) && !((ServerWorld)DakotaraptorEntity.this.world).isVillage(blockpos) && this.isPossibleShelter();
				}
			} else {
				return false;
			}
		}

		public void startExecuting() {
			DakotaraptorEntity.this.func_213499_en();
			super.startExecuting();
		}
	}

	class FollowGoal extends FollowParentGoal {
		private final DakotaraptorEntity owner;

		public FollowGoal(DakotaraptorEntity p_i50735_2_, double p_i50735_3_) {
			super(p_i50735_2_, p_i50735_3_);
			this.owner = p_i50735_2_;
		}

		public boolean shouldExecute() {
			return !this.owner.isDakotaraptorAggroed() && super.shouldExecute();
		}

		public boolean shouldContinueExecuting() {
			return !this.owner.isDakotaraptorAggroed() && super.shouldContinueExecuting();
		}

		public void startExecuting() {
			this.owner.func_213499_en();
			super.startExecuting();
		}
	}

	class FollowTargetGoal extends Goal {
		public FollowTargetGoal() {
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		public boolean shouldExecute() {
			if (DakotaraptorEntity.this.isSleeping()) {
				return false;
			} else {
				LivingEntity livingentity = DakotaraptorEntity.this.getAttackTarget();
				return livingentity != null && livingentity.isAlive() && DakotaraptorEntity.IS_PREY.test(livingentity) && DakotaraptorEntity.this.getDistanceSq(livingentity) > 36.0D && !DakotaraptorEntity.this.isCrouching() && !DakotaraptorEntity.this.func_213467_eg() && !DakotaraptorEntity.this.isJumping;
			}
		}

		public void startExecuting() {
			DakotaraptorEntity.this.setSitting(false);
			DakotaraptorEntity.this.setStuck(false);
		}

		public void resetTask() {
			LivingEntity livingentity = DakotaraptorEntity.this.getAttackTarget();
			if (livingentity != null && DakotaraptorEntity.func_213481_a(DakotaraptorEntity.this, livingentity)) {
				DakotaraptorEntity.this.func_213502_u(true);
				DakotaraptorEntity.this.setCrouching(true);
				DakotaraptorEntity.this.getNavigator().clearPath();
				DakotaraptorEntity.this.getLookController().setLookPositionWithEntity(livingentity, (float)DakotaraptorEntity.this.getHorizontalFaceSpeed(), (float)DakotaraptorEntity.this.getVerticalFaceSpeed());
			} else {
				DakotaraptorEntity.this.func_213502_u(false);
				DakotaraptorEntity.this.setCrouching(false);
			}

		}

		public void tick() {
			LivingEntity livingentity = DakotaraptorEntity.this.getAttackTarget();
			DakotaraptorEntity.this.getLookController().setLookPositionWithEntity(livingentity, (float)DakotaraptorEntity.this.getHorizontalFaceSpeed(), (float)DakotaraptorEntity.this.getVerticalFaceSpeed());
			if (DakotaraptorEntity.this.getDistanceSq(livingentity) <= 36.0D) {
				DakotaraptorEntity.this.func_213502_u(true);
				DakotaraptorEntity.this.setCrouching(true);
				DakotaraptorEntity.this.getNavigator().clearPath();
			} else {
				DakotaraptorEntity.this.getNavigator().tryMoveToEntityLiving(livingentity, 1.5D);
			}

		}
	}

	class JumpGoal extends Goal {
		int delay;

		public JumpGoal() {
			this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.JUMP, Goal.Flag.MOVE));
		}

		public boolean shouldExecute() {
			return DakotaraptorEntity.this.isStuck();
		}

		public boolean shouldContinueExecuting() {
			return this.shouldExecute() && this.delay > 0;
		}

		public void startExecuting() {
			this.delay = 40;
		}

		public void resetTask() {
			DakotaraptorEntity.this.setStuck(false);
		}

		public void tick() {
			--this.delay;
		}
	}

	public class LookHelperController extends LookController {
		public LookHelperController() {
			super(DakotaraptorEntity.this);
		}

		public void tick() {
			if (!DakotaraptorEntity.this.isSleeping()) {
				super.tick();
			}

		}

		protected boolean func_220680_b() {
			return !DakotaraptorEntity.this.func_213480_dY() && !DakotaraptorEntity.this.isCrouching() && !DakotaraptorEntity.this.func_213467_eg() & !DakotaraptorEntity.this.isStuck();
		}
	}

	class MoveHelperController extends MovementController {
		public MoveHelperController() {
			super(DakotaraptorEntity.this);
		}

		public void tick() {
			if (DakotaraptorEntity.this.func_213478_eo()) {
				super.tick();
			}

		}
	}

	public class PounceGoal extends net.minecraft.entity.ai.goal.JumpGoal {
		public boolean shouldExecute() {
			if (!DakotaraptorEntity.this.func_213490_ee()) {
				return false;
			} else {
				LivingEntity livingentity = DakotaraptorEntity.this.getAttackTarget();
				if (livingentity != null && livingentity.isAlive()) {
					if (livingentity.getAdjustedHorizontalFacing() != livingentity.getHorizontalFacing()) {
						return false;
					} else {
						boolean flag = DakotaraptorEntity.func_213481_a(DakotaraptorEntity.this, livingentity);
						if (!flag) {
							DakotaraptorEntity.this.getNavigator().getPathToEntity(livingentity, 0);
							DakotaraptorEntity.this.setCrouching(false);
							DakotaraptorEntity.this.func_213502_u(false);
						}

						return flag;
					}
				} else {
					return false;
				}
			}
		}

		public boolean shouldContinueExecuting() {
			LivingEntity livingentity = DakotaraptorEntity.this.getAttackTarget();
			if (livingentity != null && livingentity.isAlive()) {
				double d0 = DakotaraptorEntity.this.getMotion().y;
				return (!(d0 * d0 < (double)0.05F) || !(Math.abs(DakotaraptorEntity.this.rotationPitch) < 15.0F) || !DakotaraptorEntity.this.onGround) && !DakotaraptorEntity.this.isStuck();
			} else {
				return false;
			}
		}

		public boolean isPreemptible() {
			return false;
		}

		public void startExecuting() {
			DakotaraptorEntity.this.setJumping(true);
			DakotaraptorEntity.this.func_213461_s(true);
			DakotaraptorEntity.this.func_213502_u(false);
			LivingEntity livingentity = DakotaraptorEntity.this.getAttackTarget();
			DakotaraptorEntity.this.getLookController().setLookPositionWithEntity(livingentity, 60.0F, 30.0F);
			Vec3d vec3d = (new Vec3d(livingentity.getPosX() - DakotaraptorEntity.this.getPosX(), livingentity.getPosY() - DakotaraptorEntity.this.getPosY(), livingentity.getPosZ() - DakotaraptorEntity.this.getPosZ())).normalize();
			DakotaraptorEntity.this.setMotion(DakotaraptorEntity.this.getMotion().add(vec3d.x * 0.8D, 0.9D, vec3d.z * 0.8D));
			DakotaraptorEntity.this.getNavigator().clearPath();
		}

		public void resetTask() {
			DakotaraptorEntity.this.setCrouching(false);
			DakotaraptorEntity.this.crouchAmount = 0.0F;
			DakotaraptorEntity.this.crouchAmountO = 0.0F;
			DakotaraptorEntity.this.func_213502_u(false);
			DakotaraptorEntity.this.func_213461_s(false);
		}

		public void tick() {
			LivingEntity livingentity = DakotaraptorEntity.this.getAttackTarget();
			if (livingentity != null) {
				DakotaraptorEntity.this.getLookController().setLookPositionWithEntity(livingentity, 60.0F, 30.0F);
			}

			if (!DakotaraptorEntity.this.isStuck()) {
				Vec3d vec3d = DakotaraptorEntity.this.getMotion();
				if (vec3d.y * vec3d.y < (double)0.03F && DakotaraptorEntity.this.rotationPitch != 0.0F) {
					DakotaraptorEntity.this.rotationPitch = MathHelper.rotLerp(DakotaraptorEntity.this.rotationPitch, 0.0F, 0.2F);
				} else {
					double d0 = Math.sqrt(Entity.horizontalMag(vec3d));
					double d1 = Math.signum(-vec3d.y) * Math.acos(d0 / vec3d.length()) * (double)(180F / (float)Math.PI);
					DakotaraptorEntity.this.rotationPitch = (float)d1;
				}
			}

			if (livingentity != null && DakotaraptorEntity.this.getDistance(livingentity) <= 2.0F) {
				DakotaraptorEntity.this.attackEntityAsMob(livingentity);
			} else if (DakotaraptorEntity.this.rotationPitch > 0.0F && DakotaraptorEntity.this.onGround && (float)DakotaraptorEntity.this.getMotion().y != 0.0F && DakotaraptorEntity.this.world.getBlockState(new BlockPos(DakotaraptorEntity.this)).getBlock() == Blocks.SNOW) {
				DakotaraptorEntity.this.rotationPitch = 60.0F;
				DakotaraptorEntity.this.setAttackTarget((LivingEntity)null);
				DakotaraptorEntity.this.setStuck(true);
			}

		}
	}

	class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(DakotaraptorEntity.this, 2.0D);
		}

		public boolean shouldExecute() {
			return !DakotaraptorEntity.this.isChild() && !DakotaraptorEntity.this.isBurning() ? false : super.shouldExecute();
		}

	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final DakotaraptorEntity dakotaraptor;

		LayEggGoal(DakotaraptorEntity dakotaraptor, double speed) {
			super(dakotaraptor, speed, 16);
			this.dakotaraptor = dakotaraptor;
		}

		public boolean shouldExecute() {
			return this.dakotaraptor.hasEgg() ? super.shouldExecute() : false;
		}

		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && dakotaraptor.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.dakotaraptor);
			if (!this.dakotaraptor.isInWater() && this.getIsAboveDestination()) {
				if (this.dakotaraptor.isDigging < 1) {
					this.dakotaraptor.setDigging(true);
				} else if (this.dakotaraptor.isDigging > 200) {
					World world = this.dakotaraptor.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), BlockInit.DAKOTARAPTOR_EGG.getDefaultState().with(DakotaraptorEggBlock.EGGS, Integer.valueOf(this.dakotaraptor.rand.nextInt(4) + 1)), 3);
					this.dakotaraptor.setHasEgg(false);
					this.dakotaraptor.setDigging(false);
					this.dakotaraptor.setInLove(600);
				}
				if (this.dakotaraptor.isDigging()) {
					this.dakotaraptor.isDigging++;
				}
			}
		}

		public boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			if (!worldIn.isAirBlock(pos.up())) {
				return false;
			} else {
				Block block = worldIn.getBlockState(pos).getBlock();
				return block == Blocks.COARSE_DIRT;
			}
		}

	}

	static class MateGoal extends BreedGoal {
		private final DakotaraptorEntity dakotaraptor;

		MateGoal(DakotaraptorEntity dakotaraptor, double speed) {
			super(dakotaraptor, speed);
			this.dakotaraptor = dakotaraptor;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.dakotaraptor.hasEgg();
		}

		protected void spawnBaby() {
			ServerPlayerEntity serverPlayerEntity = this.animal.getLoveCause();
			if (serverPlayerEntity == null && this.targetMate.getLoveCause() == null) {
				serverPlayerEntity = this.targetMate.getLoveCause();
			}
			if (serverPlayerEntity != null) {
				serverPlayerEntity.addStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverPlayerEntity, this.animal, this.targetMate, (AgeableEntity)null);
			}
			this.dakotaraptor.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}

	}

	class SitAndLookGoal extends DakotaraptorEntity.BaseGoal {
		private double field_220819_c;
		private double field_220820_d;
		private int field_220821_e;
		private int field_220822_f;

		public SitAndLookGoal() {
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		public boolean shouldExecute() {
			return DakotaraptorEntity.this.getRevengeTarget() == null && DakotaraptorEntity.this.getRNG().nextFloat() < 0.02F && !DakotaraptorEntity.this.isSleeping() && DakotaraptorEntity.this.getAttackTarget() == null && DakotaraptorEntity.this.getNavigator().noPath() && !this.func_220814_h() && !DakotaraptorEntity.this.func_213480_dY() && !DakotaraptorEntity.this.isCrouching();
		}

		public boolean shouldContinueExecuting() {
			return this.field_220822_f > 0;
		}

		public void startExecuting() {
			this.func_220817_j();
			this.field_220822_f = 2 + DakotaraptorEntity.this.getRNG().nextInt(3);
			DakotaraptorEntity.this.setSitting(true);
			DakotaraptorEntity.this.getNavigator().clearPath();
		}

		public void resetTask() {
			DakotaraptorEntity.this.setSitting(false);
		}

		public void tick() {
			--this.field_220821_e;
			if (this.field_220821_e <= 0) {
				--this.field_220822_f;
				this.func_220817_j();
			}

			DakotaraptorEntity.this.getLookController().setLookPosition(DakotaraptorEntity.this.getPosX() + this.field_220819_c, DakotaraptorEntity.this.getPosYEye(), DakotaraptorEntity.this.getPosZ() + this.field_220820_d, (float)DakotaraptorEntity.this.getHorizontalFaceSpeed(), (float)DakotaraptorEntity.this.getVerticalFaceSpeed());
		}

		private void func_220817_j() {
			double d0 = (Math.PI * 2D) * DakotaraptorEntity.this.getRNG().nextDouble();
			this.field_220819_c = Math.cos(d0);
			this.field_220820_d = Math.sin(d0);
			this.field_220821_e = 80 + DakotaraptorEntity.this.getRNG().nextInt(20);
		}
	}

	class SleepGoal extends DakotaraptorEntity.BaseGoal {
		private int field_220825_c = DakotaraptorEntity.this.rand.nextInt(140);

		public SleepGoal() {
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
		}

		public boolean shouldExecute() {
			if (DakotaraptorEntity.this.moveStrafing == 0.0F && DakotaraptorEntity.this.moveVertical == 0.0F && DakotaraptorEntity.this.moveForward == 0.0F) {
				return this.func_220823_j() || DakotaraptorEntity.this.isSleeping();
			} else {
				return false;
			}
		}

		public boolean shouldContinueExecuting() {
			return this.func_220823_j();
		}

		private boolean func_220823_j() {
			if (this.field_220825_c > 0) {
				--this.field_220825_c;
				return false;
			} else {
				return DakotaraptorEntity.this.world.isDaytime() && this.func_220813_g() && !this.func_220814_h();
			}
		}

		public void resetTask() {
			this.field_220825_c = DakotaraptorEntity.this.rand.nextInt(140);
			DakotaraptorEntity.this.func_213499_en();
		}

		public void startExecuting() {
			DakotaraptorEntity.this.setSitting(false);
			DakotaraptorEntity.this.setCrouching(false);
			DakotaraptorEntity.this.func_213502_u(false);
			DakotaraptorEntity.this.setJumping(false);
			DakotaraptorEntity.this.setSleeping(true);
			DakotaraptorEntity.this.getNavigator().clearPath();
			DakotaraptorEntity.this.getMoveHelper().setMoveTo(DakotaraptorEntity.this.getPosX(), DakotaraptorEntity.this.getPosY(), DakotaraptorEntity.this.getPosZ(), 0.0D);
		}
	}

	class SwimGoal extends net.minecraft.entity.ai.goal.SwimGoal {
		public SwimGoal() {
			super(DakotaraptorEntity.this);
		}

		public void startExecuting() {
			super.startExecuting();
			DakotaraptorEntity.this.func_213499_en();
		}

		public boolean shouldExecute() {
			return DakotaraptorEntity.this.isInWater() && DakotaraptorEntity.this.getSubmergedHeight() > 0.25D || DakotaraptorEntity.this.isInLava();
		}
	}

	class WatchGoal extends LookAtGoal {
		public WatchGoal(MobEntity p_i50733_2_, Class<? extends LivingEntity> p_i50733_3_, float p_i50733_4_) {
			super(p_i50733_2_, p_i50733_3_, p_i50733_4_);
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !DakotaraptorEntity.this.isStuck() && !DakotaraptorEntity.this.func_213467_eg();
		}

		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && !DakotaraptorEntity.this.isStuck() && !DakotaraptorEntity.this.func_213467_eg();
		}
	}

	class AttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public AttackPlayerGoal() {
			super(DakotaraptorEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		@SuppressWarnings({"unused"})
		public boolean shouldExecute() {
			if (DakotaraptorEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for (DakotaraptorEntity dakotaraptor : DakotaraptorEntity.this.world.getEntitiesWithinAABB(DakotaraptorEntity.class, DakotaraptorEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
						if (DakotaraptorEntity.this.isChild()) {
							return true;
						}
					}
				}
			}
			return false;
		}

		protected double getTargetDistance() {
			return super.getTargetDistance() * 0.5D;
		}

	}

	class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(DakotaraptorEntity.this);
		}

		public void startExecuting() {
			super.startExecuting();
			if(DakotaraptorEntity.this.isChild()) {
				this.alertOthers();
				this.resetTask();
			}
		}

		protected void setAttackTarget(MobEntity entity, LivingEntity target) {
			if (entity instanceof DakotaraptorEntity && !entity.isChild()) {
				super.setAttackTarget(entity, target);
			}
		}

	}

	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(DakotaraptorEntity.this, 1.25D, true);
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
					DakotaraptorEntity.this.playWarningSound();
				}
			}else {
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

	public boolean attackEntityAsMob(Entity entity) {
		boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue()));
		if (flag) {
			this.applyEnchantments(this, entity);
		}
		return flag;
	}

	/**

	public DakotaraptorEntity(EntityType<? extends DakotaraptorEntity> type, World world) {
		super(type, world);
	}

	public AgeableEntity createChild(AgeableEntity ageable) {
		DakotaraptorEntity entity = new DakotaraptorEntity(ModEntityTypes.DAKOTARAPTOR_ENTITY, this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}

	public boolean hasEgg() {
		return this.dataManager.get(HAS_EGG);
	}

	private void setHasEgg(boolean hasEgg) {
		this.dataManager.set(HAS_EGG, hasEgg);
	}

	public boolean isDigging() {
		return this.dataManager.get(IS_DIGGING);
	}

	private void setDigging(boolean isDigging) {
		this.isDigging = isDigging ? 1 : 0;
		this.dataManager.set(IS_DIGGING, isDigging);
	}

	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == ItemInit.RAW_THESCELOSAURUS_MEAT.get();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.attackAnimals = new NearestAttackableTargetGoal<>(this, AnimalEntity.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof ThescelosaurusEntity || p_213487_0_ instanceof BasilemysEntity || p_213487_0_ instanceof DryosaurusEntity || p_213487_0_ instanceof HesperornithoidesEntity || p_213487_0_ instanceof EilenodonEntity;
		});
		this.goalSelector.addGoal(1, new DakotaraptorEntity.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new DakotaraptorEntity.PanicGoal());
		this.targetSelector.addGoal(1, new DakotaraptorEntity.HurtByTargetGoal());
		this.goalSelector.addGoal(1, new DakotaraptorEntity.JumpGoal());
		this.targetSelector.addGoal(2, new DakotaraptorEntity.AttackPlayerGoal());
	}

	 **/
}