package superlord.prehistoricfauna.common.entities;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
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
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.common.blocks.CeratosaurusEggBlock;
import superlord.prehistoricfauna.common.entities.goal.HuntGoal;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.SoundInit;

import java.util.Random;
import java.util.function.Predicate;

public class CeratosaurusEntity extends AnimalEntity {
	
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(CeratosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(CeratosaurusEntity.class, DataSerializers.BOOLEAN);
	private int warningSoundTicks;
	private int isDigging;
	private Goal attackAnimals;
	
	public CeratosaurusEntity(EntityType<? extends CeratosaurusEntity> type, World worldIn) {
		super(type, worldIn);
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
		return stack.getItem() == PFItems.RAW_DRYOSAURUS_MEAT.get();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.attackAnimals = new HuntGoal(this, AnimalEntity.class, 10, false, false, (p_213487_0_) -> {
	         return p_213487_0_ instanceof DryosaurusEntity || p_213487_0_ instanceof ThescelosaurusEntity || p_213487_0_ instanceof HorseEntity || p_213487_0_ instanceof DonkeyEntity || p_213487_0_ instanceof MuleEntity || p_213487_0_ instanceof SheepEntity || p_213487_0_ instanceof CowEntity || p_213487_0_ instanceof PigEntity || p_213487_0_ instanceof PandaEntity || p_213487_0_ instanceof OcelotEntity || p_213487_0_ instanceof PlayerEntity;
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
	
	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 30.0D).createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 5.0D);
	}
	
	private void setAttackGoals() {
		this.targetSelector.addGoal(4, this.attackAnimals);
	}
	
	protected SoundEvent getAmbientSound() {
		return SoundInit.CERATOSAURUS_IDLE;
	}
	
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.CERATOSAURUS_HURT;
	}
	
	protected SoundEvent getDeathSound() {
		return SoundInit.CERATOSAURUS_DEATH;
	}
	
	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1F);
	}
	
	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundInit.CERATOSAURUS_WARN, 1.0F, this.getSoundPitch());
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
		boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(Attributes.ATTACK_DAMAGE).getValue()));
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
			if (distToEnemySqr <= d0 && this.func_234040_h_()) {
				this.func_234039_g_();
				this.attacker.attackEntityAsMob(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.func_234040_h_()) {
					this.func_234039_g_();
				}

				if (this.func_234041_j_() <= 10) {
					CeratosaurusEntity.this.playWarningSound();
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
			BlockPos blockpos = new BlockPos(this.ceratosaurus.getPositionVec());
			if (!this.ceratosaurus.isInWater() && this.getIsAboveDestination()) {
				if (this.ceratosaurus.isDigging < 1) {
					this.ceratosaurus.setDigging(true);
				} else if (this.ceratosaurus.isDigging > 200) {
					World world = this.ceratosaurus.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.CERATOSAURUS_EGG.getDefaultState().with(CeratosaurusEggBlock.EGGS, Integer.valueOf(this.ceratosaurus.rand.nextInt(4) + 1)), 3);
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
				return block == PFBlocks.SILT || block == PFBlocks.HARDENED_SILT || block == Blocks.SAND;
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

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		CeratosaurusEntity entity = new CeratosaurusEntity(PFEntities.CERATOSAURUS_ENTITY, this.world);
		entity.onInitialSpawn((IServerWorld) this.world, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}
	
}
