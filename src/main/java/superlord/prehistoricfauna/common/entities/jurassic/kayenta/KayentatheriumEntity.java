package superlord.prehistoricfauna.common.entities.jurassic.kayenta;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
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
import superlord.prehistoricfauna.common.blocks.KayentatheriumEggBlock;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.CitipatiEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.PinacosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.PlesiohadrosEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.VelociraptorEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.AnkylosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DakotaraptorEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TriceratopsEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TyrannosaurusEntity;
import superlord.prehistoricfauna.common.entities.goal.CrepuscularSleepGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.AllosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CamarasaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CeratosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.StegosaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HerrerasaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.IschigualastiaEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SaurosuchusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SillosuchusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.SoundInit;

public class KayentatheriumEntity extends DinosaurEntity {

	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(KayentatheriumEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(KayentatheriumEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(KayentatheriumEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(KayentatheriumEntity.class, DataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(PFBlocks.HORSETAIL.asItem());
	private static final DataParameter<Boolean> EATING = EntityDataManager.createKey(KayentatheriumEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> NATURAL_LOVE = EntityDataManager.createKey(KayentatheriumEntity.class, DataSerializers.BOOLEAN);
	private int maxHunger = 15;
	private int currentHunger;
	private int lastInLove = 0;
	int hungerTick = 0;
	private int isDigging;
	private int warningSoundTicks;
	int loveTick = 0;

	public KayentatheriumEntity(EntityType<? extends KayentatheriumEntity> type, World worldIn) {
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

	protected void registerGoals() {
		super.registerGoals();

		this.goalSelector.addGoal(1, new PanicGoal(this, 1.2D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<PlayerEntity>(this, PlayerEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<DilophosaurusEntity>(this, DilophosaurusEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<CitipatiEntity>(this, CitipatiEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<PinacosaurusEntity>(this, PinacosaurusEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<PlesiohadrosEntity>(this, PlesiohadrosEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<VelociraptorEntity>(this, VelociraptorEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<AnkylosaurusEntity>(this, AnkylosaurusEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<DakotaraptorEntity>(this, DakotaraptorEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<TriceratopsEntity>(this, TriceratopsEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<TyrannosaurusEntity>(this, TyrannosaurusEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<MegapnosaurusEntity>(this, MegapnosaurusEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<AllosaurusEntity>(this, AllosaurusEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<CamarasaurusEntity>(this, CamarasaurusEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<CeratosaurusEntity>(this, CeratosaurusEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<StegosaurusEntity>(this, StegosaurusEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<HerrerasaurusEntity>(this, HerrerasaurusEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<IschigualastiaEntity>(this, IschigualastiaEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<SaurosuchusEntity>(this, SaurosuchusEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<SillosuchusEntity>(this, SillosuchusEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(0, new KayentatheriumEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new KayentatheriumEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new KayentatheriumEntity.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CrepuscularSleepGoal(this));
		this.goalSelector.addGoal(0, new KayentatheriumEntity.HerbivoreEatGoal((double)1.2F, 12, 2));
	}
	
	public void livingTick() {
		super.livingTick();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		}
		List<KayentatheriumEntity> list = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(20.0D, 20.0D, 20.0D));
		if (PrehistoricFaunaConfig.advancedHunger) {
			hungerTick++;
			if (hungerTick == 600 && !this.isChild() || hungerTick == 300 && this.isChild()) {
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
				if (this.getHealth() < this.getMaxHealth()) {
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

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 6.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23D).createMutableAttribute(Attributes.FOLLOW_RANGE, 15);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : SoundInit.KAYENTATHERIUM_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.KAYENTATHERIUM_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.KAYENTATHERIUM_DEATH;
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(ALBINO, false);
		this.dataManager.register(MELANISTIC, false);
		this.dataManager.register(EATING, false);
		this.dataManager.register(NATURAL_LOVE, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("IsEating", this.isEating());
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
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
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(Attributes.ATTACK_DAMAGE).getValue()));
		if (flag) {
			this.applyEnchantments(this, entityIn);
		}
		return flag;
	}	

	static class LayEggGoal extends MoveToBlockGoal {
		private final KayentatheriumEntity kayentatherium;

		LayEggGoal(KayentatheriumEntity kayentatherium, double speed) {
			super(kayentatherium, speed, 16);
			this.kayentatherium = kayentatherium;
		}

		public boolean shouldExecute() {
			return this.kayentatherium.hasEgg() ? super.shouldExecute() : false;
		}

		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && this.kayentatherium.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.kayentatherium.getPositionVec());
			if (this.kayentatherium.isInWater() && this.getIsAboveDestination()) {
				if (this.kayentatherium.isDigging < 1) {
					this.kayentatherium.setDigging(true);
				} else if (this.kayentatherium.isDigging > 200) {
					World world = this.kayentatherium.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.KAYENTATHERIUM_EGG.getDefaultState().with(KayentatheriumEggBlock.EGGS, Integer.valueOf(this.kayentatherium.rand.nextInt(4) + 1)), 3);
					this.kayentatherium.setHasEgg(false);
					this.kayentatherium.setDigging(false);
					this.kayentatherium.setInLove(600);
				}
				if (this.kayentatherium.isDigging()) {
					this.kayentatherium.isDigging++;
				}
			}
		}

		protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			if (!worldIn.isAirBlock(pos.up())) {
				return false;
			} else {
				Block block = worldIn.getBlockState(pos).getBlock();
				return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.MYCELIUM || block == Blocks.SAND || block == Blocks.RED_SAND || block == PFBlocks.MOSSY_DIRT || block == PFBlocks.MOSS_BLOCK || block == PFBlocks.LOAM || block == PFBlocks.PACKED_LOAM || block == PFBlocks.SILT || block == PFBlocks.PACKED_LOAM || block == BlockTags.LEAVES;
			}
		}

	}

	static class MateGoal extends BreedGoal {
		private final KayentatheriumEntity kayentatherium;

		MateGoal(KayentatheriumEntity kayentatherium, double speed) {
			super(kayentatherium, speed);
			this.kayentatherium = kayentatherium;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.kayentatherium.hasEgg() && !this.kayentatherium.isInLoveNaturally();
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
			this.kayentatherium.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}

	}

	static class NaturalMateGoal extends BreedGoal {
		private final KayentatheriumEntity kayentatherium;

		NaturalMateGoal(KayentatheriumEntity kayentatherium, double speed) {
			super(kayentatherium, speed);
			this.kayentatherium = kayentatherium;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.kayentatherium.hasEgg() && this.kayentatherium.getCurrentHunger() >= this.kayentatherium.getThreeQuartersHunger() && this.kayentatherium.ticksExisted % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.kayentatherium.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.kayentatherium.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.kayentatherium.rand.nextFloat() - this.kayentatherium.rand.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.kayentatherium.rand.nextInt(4);
				if (eggAmount == 0) {
					this.kayentatherium.entityDropItem(PFBlocks.KAYENTATHERIUM_EGG.asItem());
				}
				if (eggAmount == 1) {
					this.kayentatherium.entityDropItem(PFBlocks.KAYENTATHERIUM_EGG.asItem());
					this.kayentatherium.entityDropItem(PFBlocks.KAYENTATHERIUM_EGG.asItem());
				}
				if (eggAmount == 2) {
					this.kayentatherium.entityDropItem(PFBlocks.KAYENTATHERIUM_EGG.asItem());
					this.kayentatherium.entityDropItem(PFBlocks.KAYENTATHERIUM_EGG.asItem());
					this.kayentatherium.entityDropItem(PFBlocks.KAYENTATHERIUM_EGG.asItem());
				}
				if (eggAmount == 3) {
					this.kayentatherium.entityDropItem(PFBlocks.KAYENTATHERIUM_EGG.asItem());
					this.kayentatherium.entityDropItem(PFBlocks.KAYENTATHERIUM_EGG.asItem());
					this.kayentatherium.entityDropItem(PFBlocks.KAYENTATHERIUM_EGG.asItem());
					this.kayentatherium.entityDropItem(PFBlocks.KAYENTATHERIUM_EGG.asItem());
				}
			} else {
				this.kayentatherium.setHasEgg(true);
			}
			this.animal.resetInLove();
			this.targetMate.resetInLove();
		}

	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		KayentatheriumEntity entity = new KayentatheriumEntity(PFEntities.KAYENTATHERIUM_ENTITY, this.world);
		entity.onInitialSpawn((IServerWorld) this.world, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}
	
	public class HerbivoreEatGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public HerbivoreEatGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(KayentatheriumEntity.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
					KayentatheriumEntity.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					KayentatheriumEntity.this.world.playSound((PlayerEntity)null, this.destinationBlock, SoundEvents.BLOCK_GRASS_HIT, SoundCategory.NEUTRAL, 1, 1);
				}
			}
			if (KayentatheriumEntity.this.getCurrentHunger() >= 13) {
				KayentatheriumEntity.this.setEating(false);
			}
			super.tick();
		}

		protected void eatBerry() {
			BlockState blockstate = KayentatheriumEntity.this.world.getBlockState(this.destinationBlock);
			int hunger = KayentatheriumEntity.this.getCurrentHunger();

			if (blockstate.isIn(PFBlocks.DEAD_OSMUNDACAULIS)) {
				if (hunger + 2 >= KayentatheriumEntity.this.maxHunger) {
					KayentatheriumEntity.this.setHunger(KayentatheriumEntity.this.maxHunger);
				} else {
					KayentatheriumEntity.this.setHunger(hunger + 2);
				}
			}
			if (blockstate.isIn(Blocks.GRASS) || blockstate.isIn(Blocks.TALL_GRASS) || blockstate.isIn(BlockTags.FLOWERS)) {
				if (hunger + 4 >= KayentatheriumEntity.this.maxHunger) {
					KayentatheriumEntity.this.setHunger(KayentatheriumEntity.this.maxHunger);
				} else {
					KayentatheriumEntity.this.setHunger(hunger + 4);
				}
			}
			if (blockstate.isIn(Blocks.VINE)) {
				if (hunger + 6 >= KayentatheriumEntity.this.maxHunger) {
					KayentatheriumEntity.this.setHunger(KayentatheriumEntity.this.maxHunger);
				} else {
					KayentatheriumEntity.this.setHunger(hunger + 6);
				}
			}
			if (blockstate.isIn(PFBlocks.MARCHANTIA) || blockstate.isIn(PFBlocks.OSMUNDACAULIS) || blockstate.isIn(PFBlocks.OTOZAMITES)) {
				if (hunger + 8 >= KayentatheriumEntity.this.maxHunger) {
					KayentatheriumEntity.this.setHunger(KayentatheriumEntity.this.maxHunger);
				} else {
					KayentatheriumEntity.this.setHunger(hunger + 8);
				}
			}
			if (blockstate.isIn(PFBlocks.HORSETAIL) || blockstate.isIn(PFBlocks.CLUBMOSS) || blockstate.isIn(PFBlocks.MICHELILLOA) || blockstate.isIn(PFBlocks.COBBANIA) || blockstate.isIn(PFBlocks.LAUROZAMITES) || blockstate.isIn(PFBlocks.CLATHOPTERIS)) {
				if (hunger + 10 >= KayentatheriumEntity.this.maxHunger) {
					KayentatheriumEntity.this.setHunger(KayentatheriumEntity.this.maxHunger);
				} else {
					KayentatheriumEntity.this.setHunger(hunger + 10);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_OSMUNDACAULIS) || blockstate.isIn(PFBlocks.TALL_OTOZAMITES)) {
				if (hunger + 12 >= KayentatheriumEntity.this.maxHunger) {
					KayentatheriumEntity.this.setHunger(KayentatheriumEntity.this.maxHunger);
				} else {
					KayentatheriumEntity.this.setHunger(hunger + 12);
				}
			}
			if (blockstate.isIn(PFBlocks.OSMUNDA) || blockstate.isIn(Blocks.FERN) || blockstate.isIn(PFBlocks.CONIOPTERIS) || blockstate.isIn(PFBlocks.CLADOPHLEBIS)) {
				if (hunger + 15 >= KayentatheriumEntity.this.maxHunger) {
					KayentatheriumEntity.this.setHunger(KayentatheriumEntity.this.maxHunger);
				} else {
					KayentatheriumEntity.this.setHunger(hunger + 15);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_HORSETAIL) || blockstate.isIn(PFBlocks.SCYTOPHYLLUM)) {
				if (hunger + 20 >= KayentatheriumEntity.this.maxHunger) {
					KayentatheriumEntity.this.setHunger(KayentatheriumEntity.this.maxHunger);
				} else {
					KayentatheriumEntity.this.setHunger(hunger + 20);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_OSMUNDA) || blockstate.isIn(Blocks.LARGE_FERN) || blockstate.isIn(PFBlocks.JOHNSTONIA)) {
				if (hunger + 25 >= KayentatheriumEntity.this.maxHunger) {
					KayentatheriumEntity.this.setHunger(KayentatheriumEntity.this.maxHunger);
				} else {
					KayentatheriumEntity.this.setHunger(hunger + 25);
				}
			}
			if (blockstate.isIn(PFBlocks.DICROIDIUM)) {
				if (hunger + 30 >= KayentatheriumEntity.this.maxHunger) {
					KayentatheriumEntity.this.setHunger(KayentatheriumEntity.this.maxHunger);
				} else {
					KayentatheriumEntity.this.setHunger(hunger + 30);
				}
			}
			KayentatheriumEntity.this.setEating(false);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return !KayentatheriumEntity.this.isAsleep() && super.shouldExecute() && KayentatheriumEntity.this.getCurrentHunger() < KayentatheriumEntity.this.getHalfHunger();
		}

		public boolean shouldContinueExecuting() {
			if (KayentatheriumEntity.this.getCurrentHunger() >= KayentatheriumEntity.this.maxHunger || KayentatheriumEntity.this.isAsleep()) {
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
