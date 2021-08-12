package superlord.prehistoricfauna.common.entities;

import java.util.EnumSet;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

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
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
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
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.blocks.EilenodonEggBlock;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.SoundInit;

public class EilenodonEntity extends DinosaurEntity {
	
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(EilenodonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(EilenodonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(EilenodonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(EilenodonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Byte> EILENODON_FLAGS = EntityDataManager.createKey(EilenodonEntity.class, DataSerializers.BYTE);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(PFBlocks.HORSETAIL.asItem());
	private int isDigging;
	
	public EilenodonEntity(EntityType<? extends EilenodonEntity> type, World world) {
		super(type, world);
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
	
	public boolean isAlbino() {
		return this.dataManager.get(ALBINO);
	}

	private void setAlbino(boolean isAlbino) {
		this.dataManager.set(ALBINO, isAlbino);
	}

	public boolean isMelanistic() {
		return this.dataManager.get(MELANISTIC);
	}

	private void setMelanistic(boolean isMelanistic) {
		this.dataManager.set(MELANISTIC, isMelanistic);
	}
	
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == PFBlocks.HORSETAIL.asItem();
	}
	
	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(EILENODON_FLAGS, (byte)0);
		this.dataManager.register(ALBINO, false);
		this.dataManager.register(MELANISTIC, false);
	}
	
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("Sitting", this.isSitting());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
	}
	
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setSitting(compound.getBoolean("Sitting"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
	}
	
	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		Random rand = new Random();
		int birthNumber = rand.nextInt(399);
		if (birthNumber >= 0 && birthNumber < 4) {
			this.setAlbino(true);
		} else if (birthNumber >= 4 && birthNumber < 7) {
			this.setMelanistic(true);
		}
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	private void setEilenodonFlag(int p_213505_1_, boolean p_213505_2_) {
		if (p_213505_2_) {
			this.dataManager.set(EILENODON_FLAGS, (byte)(this.dataManager.get(EILENODON_FLAGS) | p_213505_1_));
		} else {
			this.dataManager.set(EILENODON_FLAGS, (byte)(this.dataManager.get(EILENODON_FLAGS) & ~p_213505_1_));
		}
	}
	
	private boolean getEilenodonFlag(int p_213507_1_) {
		return (this.dataManager.get(EILENODON_FLAGS) & p_213507_1_) != 0;
	}
	
	public boolean isSitting() {
		return this.getEilenodonFlag(1);
	}

	public void setSitting(boolean p_213466_1_) {
		this.setEilenodonFlag(1, p_213466_1_);
	}
	
	public boolean func_213480_dY() {
		return this.getEilenodonFlag(16);
	}
	
	public void func_213461_s(boolean p_213461_1_) {
		this.setEilenodonFlag(16, p_213461_1_);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(2, new EilenodonEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, PlayerEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, AllosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, CeratosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, StegosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, DryosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, HesperornithoidesEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, CamarasaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, TyrannosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, TriceratopsEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, AnkylosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, ThescelosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, DakotaraptorEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, HerrerasaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, ExaeretodonEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<SaurosuchusEntity>(this, SaurosuchusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(8, new EilenodonEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new EilenodonEntity.SitAndLookGoal());
	}
	
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.EILENODON_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.EILENODON_DEATH;
	}

	@Override
	public void livingTick() {
		super.livingTick();
	}
	
	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 4.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
	}
	
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		super.handleStatusUpdate(id);
	}
	
	static class LayEggGoal extends MoveToBlockGoal {
		private final EilenodonEntity eilenodon;
		
		LayEggGoal(EilenodonEntity eilenodon, double speed) {
			super(eilenodon, speed, 16);
			this.eilenodon = eilenodon;
		}
		
		public boolean shouldExecute() {
			return this.eilenodon.hasEgg() ? super.shouldExecute() : false;
		}
		
		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && this.eilenodon.hasEgg();
		}
		
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.eilenodon.getPositionVec());
			if (this.eilenodon.isInWater() && this.getIsAboveDestination()) {
				if (this.eilenodon.isDigging < 1) {
					this.eilenodon.setDigging(true);
				} else if (this.eilenodon.isDigging > 200) {
					World world = this.eilenodon.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.EILENODON_EGG.getDefaultState().with(EilenodonEggBlock.EGGS, Integer.valueOf(this.eilenodon.rand.nextInt(4) + 1)), 3);
					this.eilenodon.setHasEgg(false);
					this.eilenodon.setDigging(false);
					this.eilenodon.setInLove(600);
				}
				if (this.eilenodon.isDigging()) {
					this.eilenodon.isDigging++;
				}
			}
		}
		
		protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			if (!worldIn.isAirBlock(pos.up())) {
				return false;
			} else {
				Block block = worldIn.getBlockState(pos).getBlock();
				return block == PFBlocks.SILT || block == PFBlocks.HARDENED_SILT || block == Blocks.SAND;
			}
		}
		
	}
	
	static class MateGoal extends BreedGoal {
		private final EilenodonEntity eilenodon;
		
		MateGoal(EilenodonEntity eilenodon, double speed) {
			super(eilenodon, speed);
			this.eilenodon = eilenodon;
		}
		
		public boolean shouldExecute() {
			return super.shouldExecute() && !this.eilenodon.hasEgg();
		}
		
		protected void spawnBaby() {
			ServerPlayerEntity serverPlayerEntity = this.animal.getLoveCause();
			if (serverPlayerEntity == null && this.targetMate.getLoveCause() != null) {
				serverPlayerEntity = this.targetMate.getLoveCause();
			}
			if (serverPlayerEntity != null) {
				serverPlayerEntity.addStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverPlayerEntity, this.animal, this.targetMate, (AgeableEntity)null);
			}
			this.eilenodon.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}
		
	}
	
	public class AlertablePredicate implements Predicate<LivingEntity> {
		public boolean test(LivingEntity p_test_1_) {
			if (p_test_1_ instanceof EilenodonEntity) {
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
		private final EntityPredicate field_220816_b = (new EntityPredicate()).setDistance(12.0D).setLineOfSiteRequired().setCustomPredicate(EilenodonEntity.this.new AlertablePredicate());
		
		private BaseGoal() {
			
		}
		
		protected boolean func_220813_g() {
			BlockPos blockpos = new BlockPos(EilenodonEntity.this.getPositionVec());
			return !EilenodonEntity.this.world.canSeeSky(blockpos) && EilenodonEntity.this.getBlockPathWeight(blockpos) >= 0.0F;
		}
		
		protected boolean func_220814_h() {
			return !EilenodonEntity.this.world.getTargettableEntitiesWithinAABB(LivingEntity.class, this.field_220816_b, EilenodonEntity.this, EilenodonEntity.this.getBoundingBox().grow(12.0D, 6.0D, 12.0D)).isEmpty();
		}
		
	}
	
	class SitAndLookGoal extends EilenodonEntity.BaseGoal {
		private double field_220819_c;
		private double field_220820_d;
		private int field_220821_e;
		private int field_220822_f;
		
		public SitAndLookGoal() {
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		public boolean shouldExecute() {
			return EilenodonEntity.this.getRevengeTarget() == null && EilenodonEntity.this.getRNG().nextFloat() < 0.02F && !EilenodonEntity.this.isSleeping() && EilenodonEntity.this.getAttackTarget() == null && EilenodonEntity.this.getNavigator().noPath() && !this.func_220814_h() && !EilenodonEntity.this.func_213480_dY() && !EilenodonEntity.this.isCrouching() && world.getDayTime() <= 500 || EilenodonEntity.this.getRevengeTarget() == null && EilenodonEntity.this.getRNG().nextFloat() < 0.02F && !EilenodonEntity.this.isSleeping() && EilenodonEntity.this.getAttackTarget() == null && EilenodonEntity.this.getNavigator().noPath() && !this.func_220814_h() && !EilenodonEntity.this.func_213480_dY() && !EilenodonEntity.this.isCrouching() && world.getDayTime() >= 11500 && world.getDayTime() <= 13500 || EilenodonEntity.this.getRevengeTarget() == null && EilenodonEntity.this.getRNG().nextFloat() < 0.02F && !EilenodonEntity.this.isSleeping() && EilenodonEntity.this.getAttackTarget() == null && EilenodonEntity.this.getNavigator().noPath() && !this.func_220814_h() && !EilenodonEntity.this.func_213480_dY() && !EilenodonEntity.this.isCrouching() && world.getDayTime() >= 22500;
		}

		public boolean shouldContinueExecuting() {
			return this.field_220822_f == 4;
		}

		public void startExecuting() {
			this.func_220817_j();
			this.field_220822_f = 2 + EilenodonEntity.this.getRNG().nextInt(3);
			EilenodonEntity.this.setSitting(true);
			EilenodonEntity.this.getNavigator().clearPath();
		}

		public void resetTask() {
			EilenodonEntity.this.setSitting(false);
		}

		public void tick() {
			--this.field_220821_e;
			if (this.field_220821_e <= 0) {
				--this.field_220822_f;
				this.func_220817_j();
			}
			EilenodonEntity.this.getLookController().setLookPosition(EilenodonEntity.this.getPosX() + this.field_220819_c, EilenodonEntity.this.getPosYEye(), EilenodonEntity.this.getPosZ() + this.field_220820_d, (float)EilenodonEntity.this.getHorizontalFaceSpeed(), (float)EilenodonEntity.this.getVerticalFaceSpeed());
		}

		private void func_220817_j() {
			double d0 = (Math.PI * 2D) * EilenodonEntity.this.getRNG().nextDouble();
			this.field_220819_c = Math.cos(d0);
			this.field_220820_d = Math.sin(d0);
			this.field_220821_e = 80 + EilenodonEntity.this.getRNG().nextInt(20);
		}
	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		EilenodonEntity entity = new EilenodonEntity(PFEntities.EILENODON_ENTITY, this.world);
		entity.onInitialSpawn((IServerWorld) world, world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}
	
}
