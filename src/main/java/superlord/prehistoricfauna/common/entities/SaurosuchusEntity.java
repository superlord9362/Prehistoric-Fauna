package superlord.prehistoricfauna.common.entities;

import java.util.EnumSet;
import java.util.Random;
import java.util.function.Predicate;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
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
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.passive.horse.MuleEntity;
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
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.common.blocks.SaurosuchusEggBlock;
import superlord.prehistoricfauna.common.entities.goal.HuntGoal;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.SoundInit;

public class SaurosuchusEntity extends AnimalEntity {
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(SaurosuchusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(SaurosuchusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Byte> SAUROSUCHUS_FLAGS = EntityDataManager.createKey(SaurosuchusEntity.class, DataSerializers.BYTE);
	private int warningSoundTicks;
	private Goal attackAnimals;
	private int isDigging;

	public SaurosuchusEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
		super(type, worldIn);
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
		return stack.getItem() == PFItems.RAW_ISCHIGUALASTIA_MEAT.get();
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.attackAnimals = new HuntGoal(this, AnimalEntity.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof ThescelosaurusEntity || p_213487_0_ instanceof DryosaurusEntity || p_213487_0_ instanceof HerrerasaurusEntity || p_213487_0_ instanceof IschigualastiaEntity || p_213487_0_ instanceof SillosuchusEntity || p_213487_0_ instanceof HorseEntity || p_213487_0_ instanceof DonkeyEntity || p_213487_0_ instanceof MuleEntity || p_213487_0_ instanceof SheepEntity || p_213487_0_ instanceof CowEntity || p_213487_0_ instanceof PigEntity || p_213487_0_ instanceof OcelotEntity || p_213487_0_ instanceof PlayerEntity;
		});
		this.goalSelector.addGoal(1, new SaurosuchusEntity.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new SaurosuchusEntity.PanicGoal());
		this.targetSelector.addGoal(1, new SaurosuchusEntity.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new SaurosuchusEntity.AttackPlayerGoal());
		this.goalSelector.addGoal(2, new SaurosuchusEntity.MateGoal(this, 1.0D));
		this.targetSelector.addGoal(1, attackAnimals);
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new SaurosuchusEntity.SleepGoal());
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(8, new SaurosuchusEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<AllosaurusEntity>(this, AllosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<StegosaurusEntity>(this, StegosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<CamarasaurusEntity>(this, CamarasaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<TriceratopsEntity>(this, TriceratopsEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<AnkylosaurusEntity>(this, AnkylosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<TyrannosaurusEntity>(this, TyrannosaurusEntity.class, 7F, 1.25D, 1.25D));
	}
	
	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 20.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D).createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D);
	}
	
	protected SoundEvent getAmbientSound() {
		return SoundInit.SAUROSUCHUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.SAUROSUCHUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.SAUROSUCHUS_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundInit.SAUROSUCHUS_WARN, 1.0F, this.getSoundPitch());
			this.warningSoundTicks = 40;
		}
	}

	public boolean isSleeping() {
		return this.getSaurosuchusFlag(32);
	}

	private void setSleeping(boolean p_213485_1_) {
		this.setSaurosuchusFlag(32, p_213485_1_);
	}
	
	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(SAUROSUCHUS_FLAGS, (byte)0);
	}
	
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("Sleeping", this.isSleeping());
		compound.putBoolean("Crouching", this.isCrouching());
		compound.putBoolean("HasEgg", this.hasEgg());
	}
	
	private void setSaurosuchusFlag(int p_213505_1_, boolean p_213505_2_) {
		if (p_213505_2_) {
			this.dataManager.set(SAUROSUCHUS_FLAGS, (byte)(this.dataManager.get(SAUROSUCHUS_FLAGS) | p_213505_1_));
		} else {
			this.dataManager.set(SAUROSUCHUS_FLAGS, (byte)(this.dataManager.get(SAUROSUCHUS_FLAGS) & ~p_213505_1_));
		}
	}
	
	private boolean getSaurosuchusFlag(int p_213507_1_) {
		return (this.dataManager.get(SAUROSUCHUS_FLAGS) & p_213507_1_) != 0;
	}
	
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setSleeping(compound.getBoolean("Sleeping"));
		this.setHasEgg(compound.getBoolean("HasEgg"));
	}
	
	class AttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public AttackPlayerGoal() {
			super(SaurosuchusEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}
		
		public boolean shouldExecute() {
			if (SaurosuchusEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for (@SuppressWarnings("unused") SaurosuchusEntity saurosuchus : SaurosuchusEntity.this.world.getEntitiesWithinAABB(SaurosuchusEntity.class, SaurosuchusEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {	
						if (SaurosuchusEntity.this.isChild()) {
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
			super(SaurosuchusEntity.this);
		}
		
		public void startExecuting() {
			super.startExecuting();
			if(SaurosuchusEntity.this.isChild()) {
				this.alertOthers();
				this.resetTask();
			}
		}
		
		protected void setAttackTarget(MobEntity entity, LivingEntity target) {
			if (entity instanceof SaurosuchusEntity && !entity.isChild()) {
				super.setAttackTarget(entity, target);
			}
		}
		
	}
	
	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(SaurosuchusEntity.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.func_234040_h_()) {
				this.func_234039_g_();
				this.attacker.attackEntityAsMob(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.func_234040_h_()) {
					this.func_234039_g_();
				}

				if (this.func_234041_j_() <= 10) {
					SaurosuchusEntity.this.playWarningSound();
				}
			} else {
				this.func_234039_g_();
			}

		}

		public boolean shouldContinueExecuting() {
			float f = this.attacker.getBrightness();
			if (f >= 0.5F && this.attacker.getRNG().nextInt(100) == 0) {
				this.attacker.setAttackTarget((LivingEntity)null);
				return false;
			} else {
				return super.shouldContinueExecuting();
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
			super(SaurosuchusEntity.this, 2.0D);
		}
		
		public boolean shouldExecute() {
			return !SaurosuchusEntity.this.isChild() && !SaurosuchusEntity.this.isBurning() ? false : super.shouldExecute();
		}
		
	}
	
	static class LayEggGoal extends MoveToBlockGoal {
		private final SaurosuchusEntity saurosuchus;
		
		LayEggGoal(SaurosuchusEntity saurosuchus, double speed) {
			super(saurosuchus, speed, 16);
			this.saurosuchus = saurosuchus;
		}
		
		public boolean shouldExecute() {
			return this.saurosuchus.hasEgg() ? super.shouldExecute() : false;
		}
		
		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && saurosuchus.hasEgg();
		}
		
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.saurosuchus.getPositionVec());
			if (!this.saurosuchus.isInWater() && this.getIsAboveDestination()) {
				if (this.saurosuchus.isDigging < 1) {
					this.saurosuchus.setDigging(true);
				} else if (this.saurosuchus.isDigging > 200) {
					World world = this.saurosuchus.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.SAUROSUCHUS_EGG.getDefaultState().with(SaurosuchusEggBlock.EGGS, Integer.valueOf(this.saurosuchus.rand.nextInt(4) + 1)), 3);
					this.saurosuchus.setHasEgg(false);
					this.saurosuchus.setDigging(false);
					this.saurosuchus.setInLove(600);
				}
				if (this.saurosuchus.isDigging()) {
					this.saurosuchus.isDigging++;
				}
			}
		}
		
		public boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			if (!worldIn.isAirBlock(pos.up())) {
				return false;
			} else {
				Block block = worldIn.getBlockState(pos).getBlock();
				return block == PFBlocks.LOAM || block == PFBlocks.PACKED_LOAM || block == Blocks.PODZOL;
			}
		}
		
	}
	
	static class MateGoal extends BreedGoal {
		private final SaurosuchusEntity saurosuchus;
		
		MateGoal(SaurosuchusEntity saurosuchus, double speed) {
			super(saurosuchus, speed);
			this.saurosuchus = saurosuchus;
		}
		
		public boolean shouldExecute() {
			return super.shouldExecute() && !this.saurosuchus.hasEgg();
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
			this.saurosuchus.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}
		
	}
	
	abstract class BaseGoal extends Goal {
		private final EntityPredicate field_220816_b = (new EntityPredicate()).setDistance(12.0D).setLineOfSiteRequired().setCustomPredicate(SaurosuchusEntity.this.new AlertablePredicate());
		
		private BaseGoal() {
			
		}
		
		protected boolean func_220813_g() {
			BlockPos blockpos = new BlockPos(SaurosuchusEntity.this.getPositionVec());
			return !SaurosuchusEntity.this.world.canSeeSky(blockpos) && SaurosuchusEntity.this.getBlockPathWeight(blockpos) >= 0.0F;
		}
		
		protected boolean func_220814_h() {
			return !SaurosuchusEntity.this.world.getTargettableEntitiesWithinAABB(LivingEntity.class, this.field_220816_b, SaurosuchusEntity.this, SaurosuchusEntity.this.getBoundingBox().grow(12.0D, 6.0D, 12.0D)).isEmpty();
		}
		
	}
	
	public class AlertablePredicate implements Predicate<LivingEntity> {
		public boolean test(LivingEntity p_test_1_) {
			if (p_test_1_ instanceof SaurosuchusEntity) {
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
	
	class SleepGoal extends SaurosuchusEntity.BaseGoal {
		private int field_220825_c = SaurosuchusEntity.this.rand.nextInt(140);

		public SleepGoal() {
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
		}

		public boolean shouldExecute() {
			if (SaurosuchusEntity.this.moveStrafing == 0.0F && SaurosuchusEntity.this.moveVertical == 0.0F && SaurosuchusEntity.this.moveForward == 0.0F) {
				return this.func_220823_j() || SaurosuchusEntity.this.isSleeping();
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
				return SaurosuchusEntity.this.world.isDaytime() && this.func_220813_g() && !this.func_220814_h();
			}
		}

		public void resetTask() {
			this.field_220825_c = SaurosuchusEntity.this.rand.nextInt(140);
			SaurosuchusEntity.this.setSleeping(false);
		}

		public void startExecuting() {
			SaurosuchusEntity.this.setJumping(false);
			SaurosuchusEntity.this.setSleeping(true);
			SaurosuchusEntity.this.getNavigator().clearPath();
			SaurosuchusEntity.this.getMoveHelper().setMoveTo(SaurosuchusEntity.this.getPosX(), SaurosuchusEntity.this.getPosY(), SaurosuchusEntity.this.getPosZ(), 0.0D);
		}
	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		SaurosuchusEntity entity = new SaurosuchusEntity(PFEntities.SAUROSUCHUS_ENTITY, this.world);
		entity.onInitialSpawn(p_241840_1_, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}     
	
}
