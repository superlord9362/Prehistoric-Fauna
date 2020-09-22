package superlord.prehistoricfauna.entity;

import java.util.EnumSet;
import java.util.Random;
import java.util.function.Predicate;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
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
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.stats.Stats;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import superlord.prehistoricfauna.block.DakotaraptorEggBlock;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.util.SoundHandler;

public class DakotaraptorEntity extends PrehistoricEntity {

	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(DakotaraptorEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(DakotaraptorEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Byte> DAKOTARAPTOR_FLAGS = EntityDataManager.createKey(DakotaraptorEntity.class, DataSerializers.BYTE);
	private static final Predicate<Entity> IS_PREY = (p_213498_0_) -> {
		return p_213498_0_ instanceof BasilemysEntity || p_213498_0_ instanceof ThescelosaurusEntity || p_213498_0_ instanceof DryosaurusEntity || p_213498_0_ instanceof HesperornithoidesEntity || p_213498_0_ instanceof EilenodonEntity || p_213498_0_ instanceof ChromogisaurusEntity || p_213498_0_ instanceof HyperodapedonEntity;
	};
	private int warningSoundTicks;
	private int isDigging;
	private float crouchAmount;
	private Goal attackAnimals;
	
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
		this.goalSelector.addGoal(2, new DakotaraptorEntity.PounceGoal());
		this.goalSelector.addGoal(2, new DakotaraptorEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new DakotaraptorEntity.SitGoal());
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new DakotaraptorEntity.SleepGoal());
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DakotaraptorEntity.FollowTargetGoal());
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(6, new DakotaraptorEntity.PounceGoal());
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(8, new DakotaraptorEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, AnkylosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, TriceratopsEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, TyrannosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, CamarasaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, StegosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, AllosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, CeratosaurusEntity.class, 7F, 1.25D, 1.25D));
	}
	
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	}
	
	private void setAttackGoals() {
		this.targetSelector.addGoal(2, attackAnimals);
	}
	
	protected SoundEvent getAmbientSound()  {
		return SoundHandler.DAKOTARAPTOR_IDLE;
	}
	
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundHandler.DAKOTARAPTOR_HURT;
	}
	
	protected SoundEvent getDeathSound() {
		return SoundHandler.DAKOTARAPTOR_HURT;
	}
	
	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundHandler.DAKOTARAPTOR_WARN, 1.0F, this.getSoundPitch());
			this.warningSoundTicks = 40;
		}
	}
	
	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(DAKOTARAPTOR_FLAGS, (byte)0);
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
	
	public boolean isSitting() {
		return this.getDakotaraptorFlag(1);
	}

	public void setSitting(boolean p_213466_1_) {
		this.setDakotaraptorFlag(1, p_213466_1_);
	}
	
	public boolean func_213480_dY() {
		return this.getDakotaraptorFlag(16);
	}
	
	public void func_213461_s(boolean p_213461_1_) {
		this.setDakotaraptorFlag(16, p_213461_1_);
	}
	
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("Sleeping", this.isSleeping());
		compound.putBoolean("Sitting", this.isSitting());
		compound.putBoolean("Crouching", this.isCrouching());
		compound.putBoolean("HasEgg", this.hasEgg());
	}
	
	public void func_213502_u(boolean p_213502_1_) {
		this.setDakotaraptorFlag(8, p_213502_1_);
	}

	public boolean func_213467_eg() {
		return this.getDakotaraptorFlag(8);
	}
	
	private void func_213499_en() {
		this.setSitting(false);
		this.setSleeping(false);
	}
	
	public boolean isSleeping() {
		return this.getDakotaraptorFlag(32);
	}

	private void setSleeping(boolean p_213485_1_) {
		this.setDakotaraptorFlag(32, p_213485_1_);
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
	
	public boolean isDakotaraptorPouncing() {
		return this.getDakotaraptorFlag(256);
	}
		   
	private void setDakotaraptorPouncing(boolean p_213482_1_) {
		this.setDakotaraptorFlag(256, p_213482_1_);
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
	
	public boolean isStuck() {
		return this.getDakotaraptorFlag(64);
	}

	private void setStuck(boolean p_213492_1_) {
		this.setDakotaraptorFlag(64, p_213492_1_);
	}
	
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setSleeping(compound.getBoolean("Sleeping"));
		this.setSitting(compound.getBoolean("Sitting"));
		this.setCrouching(compound.getBoolean("Crouching"));
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAttackGoals();
	}
	
	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}
	
	public boolean attackEntityAsMob(Entity entity) {
		boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue()));
		if (flag) {
			this.applyEnchantments(this, entity);
		}
		return flag;
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
	
	class SitGoal extends BaseGoal {
		private double field_220819_c;
		private double field_220820_d;
		private double field_220821_e;
		private double field_220822_f;
		
		public SitGoal() {
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
			DakotaraptorEntity.this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0F);
			DakotaraptorEntity.this.getNavigator().clearPath();
		}
		
		public void resetTask() {
			super.resetTask();
			DakotaraptorEntity.this.setSitting(false);
			DakotaraptorEntity.this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
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
			DakotaraptorEntity.this.func_213502_u(false);
			DakotaraptorEntity.this.setJumping(false);
			DakotaraptorEntity.this.setCrouching(false);
			DakotaraptorEntity.this.setSleeping(true);
			DakotaraptorEntity.this.getNavigator().clearPath();
			DakotaraptorEntity.this.getMoveHelper().setMoveTo(DakotaraptorEntity.this.getPosX(), DakotaraptorEntity.this.getPosY(), DakotaraptorEntity.this.getPosZ(), 0.0D);
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
			DakotaraptorEntity.this.func_213502_u(false);
			DakotaraptorEntity.this.func_213461_s(false);
		}

		@SuppressWarnings("deprecation")
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
			DakotaraptorEntity.this.setDakotaraptorPouncing(true);
		}

		public void resetTask() {
			DakotaraptorEntity.this.setStuck(false);
			DakotaraptorEntity.this.setDakotaraptorPouncing(false);
		}

		public void tick() {
			--this.delay;
		}
	}
		
}