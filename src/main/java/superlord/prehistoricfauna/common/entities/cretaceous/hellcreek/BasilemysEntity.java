package superlord.prehistoricfauna.common.entities.cretaceous.hellcreek;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.blocks.BasilemysEggBlock;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.common.entities.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entities.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.SoundInit;

public class BasilemysEntity extends DinosaurEntity {

	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(BasilemysEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(BasilemysEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_PANICING = EntityDataManager.createKey(BasilemysEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(BasilemysEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(BasilemysEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> EATING = EntityDataManager.createKey(BasilemysEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> NATURAL_LOVE = EntityDataManager.createKey(BasilemysEntity.class, DataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(PFBlocks.HORSETAIL.asItem());
	private int isDigging;
	private int maxHunger = 20;
	private int currentHunger;
	private int lastInLove = 0;
	int hungerTick = 0;
	int loveTick = 0;

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

	public boolean isInLoveNaturally() {
		return this.dataManager.get(NATURAL_LOVE);
	}

	private void setInLoveNaturally(boolean isInLoveNaturally) {
		this.dataManager.set(NATURAL_LOVE, isInLoveNaturally);
	}

	public int getCurrentHunger() {
		return this.currentHunger;
	}

	private void setHunger(int currentHunger) {
		this.currentHunger = currentHunger;
	}

	public int getHalfHunger() {
		return maxHunger / 2;
	}

	public int getThreeQuartersHunger() {
		return (maxHunger / 4) * 3;
	}

	public boolean isEating() {
		return this.dataManager.get(EATING);
	}

	private void setEating(boolean isEating) {
		this.dataManager.set(EATING, isEating);
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(IS_PANICING, false);
		this.dataManager.register(ALBINO, false);
		this.dataManager.register(MELANISTIC, false);
		this.dataManager.register(EATING, false);
		this.dataManager.register(NATURAL_LOVE, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsPanicing", this.isPanicing());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("IsEating", this.isEating());
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setPanicing(compound.getBoolean("IsPanicing"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setEating(compound.getBoolean("IsEating"));
		this.setHunger(compound.getInt("MaxHunger"));
		this.setInLoveNaturally(compound.getBoolean("InNaturalLove"));
	}

	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		Random rand = new Random();
		int birthNumber = rand.nextInt(799);
		if (birthNumber >= 0 && birthNumber < 4) {
			this.setAlbino(true);
		} else if (birthNumber >= 4 && birthNumber < 7) {
			this.setMelanistic(true);
		}
		this.setHunger(this.maxHunger);
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new BasilemysEntity.PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(0, new BasilemysEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new BasilemysEntity.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new BasilemysEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new BasilemysEntity.HerbivoreEatGoal((double)1.2F, 12, 2));
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : SoundInit.BASILEMYS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.BASILEMYS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.BASILEMYS_DEATH;
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
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);;
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1D);
		}
		if (!this.isAIDisabled()) {
			List<BasilemysEntity> list = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(20.0D, 20.0D, 20.0D));
			if (PrehistoricFaunaConfig.advancedHunger) {
				hungerTick++;
				if (hungerTick == 900 && !this.isChild() || hungerTick == 450 && this.isChild()) {
					hungerTick = 0;
					if (currentHunger != 0 || !this.isAsleep()) {
						this.setHunger(currentHunger - 1);
					}
					if (currentHunger == 0 && PrehistoricFaunaConfig.hungerDamage && this.getHealth() > (this.getMaxHealth() / 2)) {
						this.damageEntity(DamageSource.STARVE, 1);
					}
					if (currentHunger == 0 && PrehistoricFaunaConfig.hungerDamage && world.getDifficulty() == Difficulty.HARD) {
						this.damageEntity(DamageSource.STARVE, 1);
					}
				}
				if (this.getCurrentHunger() >= this.getThreeQuartersHunger() && hungerTick % 150 == 0) {
					if (this.getHealth() < this.getMaxHealth() && this.getHealth() != 0 && this.getAttackTarget() == null && this.getRevengeTarget() == null) {
						float currentHealth = this.getHealth();
						this.setHealth(currentHealth + 1);
					}
				}
				if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
					if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && ticksExisted % 900 == 0 && !this.isChild() && !this.isInLove() && !this.isAsleep() && list.size() < 4) {
						loveTick = 600;
						this.setInLoveNaturally(true);
						this.setInLove(600);
						lastInLove = 28800;
					}
					if (loveTick != 0) {
						loveTick--;
					} else {
						this.setInLoveNaturally(false);
					}
				}
			} else if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
				int naturalBreedingChance = rand.nextInt(1000);
				if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isChild() && !this.isInLove() && !this.isAsleep() && list.size() < 4) {
					loveTick = 600;
					this.setInLoveNaturally(true);
					this.setInLove(600);
					lastInLove = 28800;
				}
				if (loveTick != 0) {
					loveTick--;
				} else {
					this.setInLoveNaturally(false);
				}
			}
			if (lastInLove != 0) {
				lastInLove--;
			}
		}
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 8.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.1D).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.0D).createMutableAttribute(Attributes.ARMOR, 2.0D).createMutableAttribute(Attributes.ARMOR_TOUGHNESS, 2.0D);
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
			BasilemysEntity.this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(100.0D);
			BasilemysEntity.this.getAttribute(Attributes.ARMOR).setBaseValue(100.0D);
			BasilemysEntity.this.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(100.0D);
		}

		public void resetTask() {
			BasilemysEntity.this.setPanicing(false);
			BasilemysEntity.this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(0D);
			BasilemysEntity.this.getAttribute(Attributes.ARMOR).setBaseValue(0.0D);
			BasilemysEntity.this.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(0.0D);
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
			BlockPos blockpos = new BlockPos(this.basilemys.getPositionVec());
			if(this.basilemys.isInWater() && this.getIsAboveDestination()) {
				if (this.basilemys.isDigging < 1) {
					this.basilemys.setDigging(true);
				} else if (this.basilemys.isDigging > 200) {
					World world = this.basilemys.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.BASILEMYS_EGG.getDefaultState().with(BasilemysEggBlock.EGGS, Integer.valueOf(this.basilemys.rand.nextInt(4) + 1)), 3);
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
				return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.MYCELIUM || block == Blocks.SAND || block == Blocks.RED_SAND || block == PFBlocks.MOSSY_DIRT || block == PFBlocks.MOSS_BLOCK || block == PFBlocks.LOAM || block == PFBlocks.PACKED_LOAM || block == PFBlocks.SILT || block == PFBlocks.PACKED_LOAM || block == BlockTags.LEAVES;
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
			return super.shouldExecute() && !this.basilemys.hasEgg() && !this.basilemys.isInLoveNaturally();
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

	static class NaturalMateGoal extends BreedGoal {
		private final BasilemysEntity basilemys;

		NaturalMateGoal(BasilemysEntity basilemys, double speed) {
			super(basilemys, speed);
			this.basilemys = basilemys;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.basilemys.hasEgg() && this.basilemys.getCurrentHunger() >= this.basilemys.getThreeQuartersHunger() && this.basilemys.ticksExisted % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.basilemys.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.basilemys.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.basilemys.rand.nextFloat() - this.basilemys.rand.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.basilemys.rand.nextInt(4);
				if (eggAmount == 0) {
					this.basilemys.entityDropItem(PFBlocks.BASILEMYS_EGG.asItem());
				}
				if (eggAmount == 1) {
					this.basilemys.entityDropItem(PFBlocks.BASILEMYS_EGG.asItem());
					this.basilemys.entityDropItem(PFBlocks.BASILEMYS_EGG.asItem());
				}
				if (eggAmount == 2) {
					this.basilemys.entityDropItem(PFBlocks.BASILEMYS_EGG.asItem());
					this.basilemys.entityDropItem(PFBlocks.BASILEMYS_EGG.asItem());
					this.basilemys.entityDropItem(PFBlocks.BASILEMYS_EGG.asItem());
				}
				if (eggAmount == 3) {
					this.basilemys.entityDropItem(PFBlocks.BASILEMYS_EGG.asItem());
					this.basilemys.entityDropItem(PFBlocks.BASILEMYS_EGG.asItem());
					this.basilemys.entityDropItem(PFBlocks.BASILEMYS_EGG.asItem());
					this.basilemys.entityDropItem(PFBlocks.BASILEMYS_EGG.asItem());
				}
			} else {
				this.basilemys.setHasEgg(true);
			}
			this.animal.resetInLove();
			this.targetMate.resetInLove();
		}

	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		BasilemysEntity entity = new BasilemysEntity(PFEntities.BASILEMYS_ENTITY, this.world);
		entity.onInitialSpawn((IServerWorld) this.world, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}

	public class HerbivoreEatGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public HerbivoreEatGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(BasilemysEntity.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
		}

		public double getTargetDistanceSq() {
			return 2.0D;
		}

		public boolean shouldMove() {
			return this.timeoutCounter % 100 == 0;
		}

		/**
		 * Return true to set given position as destination
		 */
		protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			BlockState blockstate = worldIn.getBlockState(pos);
			return blockstate.isIn(PFBlocks.HORSETAIL) || blockstate.isIn(PFBlocks.TALL_HORSETAIL) || blockstate.isIn(PFBlocks.OSMUNDA) || blockstate.isIn(PFBlocks.TALL_OSMUNDA) || blockstate.isIn(PFBlocks.CLUBMOSS) || blockstate.isIn(PFBlocks.MARCHANTIA) || blockstate.isIn(PFBlocks.CONIOPTERIS) || blockstate.isIn(PFBlocks.OSMUNDACAULIS) || blockstate.isIn(PFBlocks.TALL_OSMUNDACAULIS) || blockstate.isIn(PFBlocks.DICROIDIUM) || blockstate.isIn(PFBlocks.JOHNSTONIA) || blockstate.isIn(PFBlocks.CLADOPHLEBIS) || blockstate.isIn(PFBlocks.SCYTOPHYLLUM) || blockstate.isIn(PFBlocks.MICHELILLOA) || blockstate.isIn(PFBlocks.DEAD_OSMUNDACAULIS) || blockstate.isIn(PFBlocks.COBBANIA) || blockstate.isIn(PFBlocks.OTOZAMITES) || blockstate.isIn(PFBlocks.TALL_OTOZAMITES) || blockstate.isIn(PFBlocks.LAUROZAMITES) || blockstate.isIn(Blocks.GRASS) || blockstate.isIn(Blocks.VINE) || blockstate.isIn(BlockTags.FLOWERS) || blockstate.isIn(Blocks.TALL_GRASS) || blockstate.isIn(Blocks.FERN) || blockstate.isIn(Blocks.LARGE_FERN);
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (this.getIsAboveDestination()) {
				if (this.field_220731_g >= 20) {
					this.eatBerry();
				} else {
					++this.field_220731_g;
					BasilemysEntity.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					BasilemysEntity.this.world.playSound((PlayerEntity)null, this.destinationBlock, SoundEvents.BLOCK_GRASS_HIT, SoundCategory.NEUTRAL, 1, 1);
				}
			}
			super.tick();
		}

		protected void eatBerry() {
			BlockState blockstate = BasilemysEntity.this.world.getBlockState(this.destinationBlock);

			if (blockstate.isIn(PFBlocks.DEAD_OSMUNDACAULIS)) {
				int hunger = BasilemysEntity.this.getCurrentHunger();
				if (hunger + 2 >= BasilemysEntity.this.maxHunger) {
					BasilemysEntity.this.setHunger(BasilemysEntity.this.maxHunger);
					BasilemysEntity.this.setEating(false);
				} else {
					BasilemysEntity.this.setHunger(hunger + 2);
					BasilemysEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(Blocks.GRASS) || blockstate.isIn(Blocks.TALL_GRASS) || blockstate.isIn(BlockTags.FLOWERS)) {
				int hunger = BasilemysEntity.this.getCurrentHunger();
				if (hunger + 4 >= BasilemysEntity.this.maxHunger) {
					BasilemysEntity.this.setHunger(BasilemysEntity.this.maxHunger);
					BasilemysEntity.this.setEating(false);
				} else {
					BasilemysEntity.this.setHunger(hunger + 4);
					BasilemysEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(Blocks.VINE)) {
				int hunger = BasilemysEntity.this.getCurrentHunger();
				if (hunger + 6 >= BasilemysEntity.this.maxHunger) {
					BasilemysEntity.this.setHunger(BasilemysEntity.this.maxHunger);
					BasilemysEntity.this.setEating(false);
				} else {
					BasilemysEntity.this.setHunger(hunger + 6);
					BasilemysEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.MARCHANTIA) || blockstate.isIn(PFBlocks.OSMUNDACAULIS) || blockstate.isIn(PFBlocks.OTOZAMITES)) {
				int hunger = BasilemysEntity.this.getCurrentHunger();
				if (hunger + 8 >= BasilemysEntity.this.maxHunger) {
					BasilemysEntity.this.setHunger(BasilemysEntity.this.maxHunger);
					BasilemysEntity.this.setEating(false);
				} else {
					BasilemysEntity.this.setHunger(hunger + 8);
					BasilemysEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.HORSETAIL) || blockstate.isIn(PFBlocks.CLUBMOSS) || blockstate.isIn(PFBlocks.MICHELILLOA) || blockstate.isIn(PFBlocks.COBBANIA) || blockstate.isIn(PFBlocks.LAUROZAMITES) || blockstate.isIn(PFBlocks.CLATHOPTERIS)) {
				int hunger = BasilemysEntity.this.getCurrentHunger();
				if (hunger + 10 >= BasilemysEntity.this.maxHunger) {
					BasilemysEntity.this.setHunger(BasilemysEntity.this.maxHunger);
					BasilemysEntity.this.setEating(false);
				} else {
					BasilemysEntity.this.setHunger(hunger + 10);
					BasilemysEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_OSMUNDACAULIS) || blockstate.isIn(PFBlocks.TALL_OTOZAMITES)) {
				int hunger = BasilemysEntity.this.getCurrentHunger();
				if (hunger + 12 >= BasilemysEntity.this.maxHunger) {
					BasilemysEntity.this.setHunger(BasilemysEntity.this.maxHunger);
					BasilemysEntity.this.setEating(false);
				} else {
					BasilemysEntity.this.setHunger(hunger + 12);
					BasilemysEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.OSMUNDA) || blockstate.isIn(Blocks.FERN) || blockstate.isIn(PFBlocks.CONIOPTERIS) || blockstate.isIn(PFBlocks.CLADOPHLEBIS)) {
				int hunger = BasilemysEntity.this.getCurrentHunger();
				if (hunger + 15 >= BasilemysEntity.this.maxHunger) {
					BasilemysEntity.this.setHunger(BasilemysEntity.this.maxHunger);
					BasilemysEntity.this.setEating(false);
				} else {
					BasilemysEntity.this.setHunger(hunger + 15);
					BasilemysEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_HORSETAIL) || blockstate.isIn(PFBlocks.SCYTOPHYLLUM)) {
				int hunger = BasilemysEntity.this.getCurrentHunger();
				if (hunger + 20 >= BasilemysEntity.this.maxHunger) {
					BasilemysEntity.this.setHunger(BasilemysEntity.this.maxHunger);
					BasilemysEntity.this.setEating(false);
				} else {
					BasilemysEntity.this.setHunger(hunger + 20);
					BasilemysEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_OSMUNDA) || blockstate.isIn(Blocks.LARGE_FERN) || blockstate.isIn(PFBlocks.JOHNSTONIA)) {
				int hunger = BasilemysEntity.this.getCurrentHunger();
				if (hunger + 25 >= BasilemysEntity.this.maxHunger) {
					BasilemysEntity.this.setHunger(BasilemysEntity.this.maxHunger);
					BasilemysEntity.this.setEating(false);
				} else {
					BasilemysEntity.this.setHunger(hunger + 25);
					BasilemysEntity.this.setEating(false);
				}
			}
			if (blockstate.isIn(PFBlocks.DICROIDIUM)) {
				int hunger = BasilemysEntity.this.getCurrentHunger();
				if (hunger + 30 >= BasilemysEntity.this.maxHunger) {
					BasilemysEntity.this.setHunger(BasilemysEntity.this.maxHunger);
					BasilemysEntity.this.setEating(false);
				} else {
					BasilemysEntity.this.setHunger(hunger + 30);
					BasilemysEntity.this.setEating(false);
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return !BasilemysEntity.this.isAsleep() && super.shouldExecute() && BasilemysEntity.this.getCurrentHunger() < BasilemysEntity.this.getHalfHunger();
		}

		public boolean shouldContinueExecuting() {
			if (BasilemysEntity.this.getCurrentHunger() >= BasilemysEntity.this.maxHunger || BasilemysEntity.this.isAsleep()) {
				return false;
			} else return super.shouldContinueExecuting();
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			this.field_220731_g = 0;
			super.startExecuting();
		}
	}

}