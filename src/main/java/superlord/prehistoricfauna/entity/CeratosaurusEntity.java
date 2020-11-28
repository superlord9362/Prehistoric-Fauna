package superlord.prehistoricfauna.entity;

import java.util.Random;
import java.util.function.Predicate;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
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
import net.minecraft.entity.passive.AnimalEntity;
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
import superlord.prehistoricfauna.block.CeratosaurusEggBlock;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ItemInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.util.SoundHandler;

public class CeratosaurusEntity extends PrehistoricEntity {
	
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(CeratosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(CeratosaurusEntity.class, DataSerializers.BOOLEAN);
	private int warningSoundTicks;
	private int isDigging;
	private Goal attackAnimals;
	
	public CeratosaurusEntity(EntityType<? extends CeratosaurusEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	public AgeableEntity createChild(AgeableEntity ageable) {
		CeratosaurusEntity entity = new CeratosaurusEntity(ModEntityTypes.CERATOSAURUS_ENTITY, this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}
	
	public boolean isDigging() {
		return this.getDataManager().get(IS_DIGGING);
	}
	
	private void setDigging(boolean isDigging) {
		this.isDigging = isDigging ? 1 : 0;
		this.dataManager.set(IS_DIGGING, isDigging);
	}
	
	public boolean hasEgg() {
		return this.getDataManager().get(HAS_EGG);
	}
	
	private void setHasEgg(boolean hasEgg) {
		this.dataManager.set(HAS_EGG, hasEgg);
	}
	
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == ItemInit.RAW_DRYOSAURUS_MEAT.get();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.attackAnimals = new NearestAttackableTargetGoal<>(this, AnimalEntity.class, 10, false, false, (p_213487_0_) -> {
	         return p_213487_0_ instanceof DryosaurusEntity || p_213487_0_ instanceof ThescelosaurusEntity;
		});
		this.goalSelector.addGoal(1, new CeratosaurusEntity.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new CeratosaurusEntity.PanicGoal());
		this.targetSelector.addGoal(1, new CeratosaurusEntity.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new CeratosaurusEntity.AttackPlayerGoal());
		this.goalSelector.addGoal(2, new CeratosaurusEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(8, new CeratosaurusEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, AllosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, StegosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, CamarasaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, TriceratopsEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, AnkylosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, TyrannosaurusEntity.class, 7F, 1.25D, 1.25D));
	}
	
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30D);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5D);
	}
	
	private void setAttackGoals() {
		this.targetSelector.addGoal(4, this.attackAnimals);
	}
	
	protected SoundEvent getAmbientSound() {
		return SoundHandler.CERATOSAURUS_IDLE;
	}
	
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundHandler.CERATOSAURUS_HURT;
	}
	
	protected SoundEvent getDeathSound() {
		return SoundHandler.CERATOSAURUS_DEATH;
	}
	
	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1F);
	}
	
	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundHandler.CERATOSAURUS_WARN, 1.0F, this.getSoundPitch());
			this.warningSoundTicks = 40;
		}
	}
	
	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
	}
	
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
	}
	
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
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
			super(CeratosaurusEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}
		
		public boolean shouldExecute() {
			if (CeratosaurusEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for (@SuppressWarnings("unused") CeratosaurusEntity ceratosaurus : CeratosaurusEntity.this.world.getEntitiesWithinAABB(CeratosaurusEntity.class, CeratosaurusEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {	
						if (CeratosaurusEntity.this.isChild()) {
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
			super(CeratosaurusEntity.this);
		}
		
		public void startExecuting() {
			super.startExecuting();
			if(CeratosaurusEntity.this.isChild()) {
				this.alertOthers();
				this.resetTask();
			}
		}
		
		protected void setAttackTarget(MobEntity entity, LivingEntity target) {
			if (entity instanceof CeratosaurusEntity && !entity.isChild()) {
				super.setAttackTarget(entity, target);
			}
		}
		
	}
	
	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(CeratosaurusEntity.this, 1.25D, true);
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
					CeratosaurusEntity.this.playWarningSound();
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
			super(CeratosaurusEntity.this, 2.0D);
		}
		
		public boolean shouldExecute() {
			return !CeratosaurusEntity.this.isChild() && !CeratosaurusEntity.this.isBurning() ? false : super.shouldExecute();
		}
		
	}
	
	static class LayEggGoal extends MoveToBlockGoal {
		private final CeratosaurusEntity ceratosaurus;
		
		LayEggGoal(CeratosaurusEntity ceratosaurus, double speed) {
			super(ceratosaurus, speed, 16);
			this.ceratosaurus = ceratosaurus;
		}
		
		public boolean shouldExecute() {
			return this.ceratosaurus.hasEgg() ? super.shouldExecute() : false;
		}
		
		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && ceratosaurus.hasEgg();
		}
		
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.ceratosaurus);
			if (!this.ceratosaurus.isInWater() && this.getIsAboveDestination()) {
				if (this.ceratosaurus.isDigging < 1) {
					this.ceratosaurus.setDigging(true);
				} else if (this.ceratosaurus.isDigging > 200) {
					World world = this.ceratosaurus.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), BlockInit.CERATOSAURUS_EGG.getDefaultState().with(CeratosaurusEggBlock.EGGS, Integer.valueOf(this.ceratosaurus.rand.nextInt(4) + 1)), 3);
					this.ceratosaurus.setHasEgg(false);
					this.ceratosaurus.setDigging(false);
					this.ceratosaurus.setInLove(600);
				}
				if (this.ceratosaurus.isDigging()) {
					this.ceratosaurus.isDigging++;
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
		private final CeratosaurusEntity ceratosaurus;
		
		MateGoal(CeratosaurusEntity ceratosaurus, double speed) {
			super(ceratosaurus, speed);
			this.ceratosaurus = ceratosaurus;
		}
		
		public boolean shouldExecute() {
			return super.shouldExecute() && !this.ceratosaurus.hasEgg();
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
			this.ceratosaurus.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}
		
	}
	
}
