package superlord.prehistoricfauna.entity;

import java.util.Random;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.AnimalEntity;
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
import net.minecraft.world.GameRules;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.block.BasilemysEggBlock;
import superlord.prehistoricfauna.init.BlockInit;
import superlord.prehistoricfauna.init.ModEntityTypes;
import superlord.prehistoricfauna.util.SoundHandler;

public class BasilemysEntity extends AnimalEntity {

	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(BasilemysEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(BasilemysEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_PANICING = EntityDataManager.createKey(BasilemysEntity.class, DataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(BlockInit.HORSETAIL.asItem());
	private int isDigging;

	public BasilemysEntity(EntityType<? extends BasilemysEntity> type, World world) {
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

	public boolean isPanicing() {
		return this.dataManager.get(IS_PANICING);
	}

	private void setPanicing(boolean isPanicing) {
		this.dataManager.set(IS_PANICING, isPanicing);
	}

	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == BlockInit.HORSETAIL.asItem();
	}

	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		BasilemysEntity entity = new BasilemysEntity(ModEntityTypes.BASILEMYS_ENTITY, this.world);
		entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(IS_PANICING, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsPanicing", this.isPanicing());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setPanicing(compound.getBoolean("IsPanicing"));
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new BasilemysEntity.PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(1, new BasilemysEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new BasilemysEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
	}

	protected SoundEvent getAmbientSound() {
		return SoundHandler.BASILEMYS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundHandler.BASILEMYS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundHandler.BASILEMYS_DEATH;
	}

	public boolean canBreed() {
		return super.canBreed() && !this.hasEgg();
	}

	@Override
	protected void updateAITasks() {
		super.updateAITasks();
	}

	@Override
	public void livingTick() {
		super.livingTick();
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1D);
	}

	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		super.handleStatusUpdate(id);
	}

	class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
		PanicGoal(BasilemysEntity turtle, double speedIn) {
			super(turtle, speedIn);
		}

		public boolean shouldExecute() {
			if (this.creature.getRevengeTarget() == null && !this.creature.isBurning()) {
				return false;
			} else {
				return true;
			}
		}

		public void startExecuting() {
			BasilemysEntity.this.setPanicing(true);
			BasilemysEntity.this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(100.0D);
			BasilemysEntity.this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(100.0D);
			BasilemysEntity.this.getAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(100.0D);
		}

		public void resetTask() {
			BasilemysEntity.this.setPanicing(false);
			BasilemysEntity.this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0D);
			BasilemysEntity.this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0.0D);
			BasilemysEntity.this.getAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(0.0D);
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final BasilemysEntity basilemys;

		LayEggGoal(BasilemysEntity basilemys, double speed) {
			super(basilemys, speed, 16);
			this.basilemys = basilemys;
		}

		public boolean shouldExecute() {
			return this.basilemys.hasEgg() ? super.shouldExecute() : false;
		}

		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting()  && this.basilemys.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.basilemys);
			if(this.basilemys.isInWater() && this.getIsAboveDestination()) {
				if (this.basilemys.isDigging < 1) {
					this.basilemys.setDigging(true);
				} else if (this.basilemys.isDigging > 200) {
					World world = this.basilemys.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), BlockInit.BASILEMYS_EGG.getDefaultState().with(BasilemysEggBlock.EGGS, Integer.valueOf(this.basilemys.rand.nextInt(4) + 1)), 3);
					this.basilemys.setHasEgg(false);
					this.basilemys.setDigging(false);
					this.basilemys.setInLove(600);
				}
				if(this.basilemys.isDigging()) {
					this.basilemys.isDigging++;
				}
			}
		}

		protected boolean shouldMoveTo(IWorldReader world, BlockPos pos) {
			if (!world.isAirBlock(pos.up())) {
				return false;
			} else {
				Block block = world.getBlockState(pos).getBlock();
				return block == BlockInit.LOAM || block == BlockInit.MOSSY_DIRT || block == Blocks.PODZOL;
			}
		}

	}

	static class MateGoal extends BreedGoal {
		private final BasilemysEntity basilemys;

		MateGoal(BasilemysEntity basilemys, double speed) {
			super(basilemys, speed);
			this.basilemys = basilemys;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.basilemys.hasEgg();
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
			this.basilemys.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}
	}

}