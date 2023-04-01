package superlord.prehistoricfauna.common.entities.cretaceous.djadochta;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

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
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
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
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.AnkylosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DakotaraptorEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DidelphodonEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TriceratopsEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TyrannosaurusEntity;
import superlord.prehistoricfauna.common.entities.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entities.goal.DiurnalSleepingGoal;
import superlord.prehistoricfauna.common.entities.goal.HuntGoal;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.KayentatheriumEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.MegapnosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.ScutellosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.AllosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CamarasaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CeratosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.EilenodonEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.HesperornithoidesEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.StegosaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ChromogisaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HerrerasaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HyperodapedonEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SaurosuchusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.SoundInit;

public class CitipatiEntity extends DinosaurEntity {

	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(CitipatiEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(CitipatiEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(CitipatiEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(CitipatiEntity.class, DataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(PFItems.RAW_SMALL_REPTILE_MEAT.get());
	private static final DataParameter<Boolean> EATING = EntityDataManager.createKey(CitipatiEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> SITTING = EntityDataManager.createKey(CitipatiEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> NATURAL_LOVE = EntityDataManager.createKey(CitipatiEntity.class, DataSerializers.BOOLEAN);
	private int maxHunger = 38;
	private int currentHunger;
	private int lastInLove = 0;
	int hungerTick = 0;
	private int isDigging;
	private Goal attackAnimals;
	int loveTick = 0;

	public CitipatiEntity(EntityType<? extends CitipatiEntity> type, World world) {
		super(type, world);
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
		return stack.getItem() == PFItems.RAW_SMALL_REPTILE_MEAT.get();
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

	public boolean isSitting() {
		return this.dataManager.get(SITTING);
	}

	private void setSitting(boolean isSitting) {
		this.dataManager.set(SITTING, isSitting);
	}

	public boolean isInLoveNaturally() {
		return this.dataManager.get(NATURAL_LOVE);
	}

	private void setInLoveNaturally(boolean isInLoveNaturally) {
		this.dataManager.set(NATURAL_LOVE, isInLoveNaturally);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.attackAnimals = new HuntGoal(this, AnimalEntity.class, 10, false, false, (p_237491_0_) -> {
			return p_237491_0_ instanceof ChromogisaurusEntity || p_237491_0_ instanceof EilenodonEntity || p_237491_0_ instanceof DidelphodonEntity || p_237491_0_ instanceof HesperornithoidesEntity || p_237491_0_ instanceof HyperodapedonEntity || p_237491_0_ instanceof TelmasaurusEntity || p_237491_0_ instanceof CatEntity || p_237491_0_ instanceof OcelotEntity || p_237491_0_ instanceof ChickenEntity || p_237491_0_ instanceof ParrotEntity || p_237491_0_ instanceof RabbitEntity || p_237491_0_ instanceof KayentatheriumEntity || p_237491_0_ instanceof MegapnosaurusEntity || p_237491_0_ instanceof ScutellosaurusEntity;
		});
		this.goalSelector.addGoal(1, new CitipatiEntity.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(0, new CitipatiEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new CitipatiEntity.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, PlayerEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, AllosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, CeratosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, StegosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, CamarasaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, TyrannosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, TriceratopsEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, AnkylosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, DakotaraptorEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, HerrerasaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, HyperodapedonEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<SaurosuchusEntity>(this, SaurosuchusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(0, new CitipatiEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new DiurnalSleepingGoal(this));
		this.goalSelector.addGoal(0, new CitipatiEntity.HerbivoreEatGoal((double)1.2F, 12, 2));
		this.targetSelector.addGoal(0, new CitipatiEntity.CarnivoreHuntGoal(this, LivingEntity.class, 10, true, false, (p_237491_0_) -> {
			return p_237491_0_ instanceof ChromogisaurusEntity || p_237491_0_ instanceof EilenodonEntity || p_237491_0_ instanceof DidelphodonEntity || p_237491_0_ instanceof HesperornithoidesEntity || p_237491_0_ instanceof HyperodapedonEntity || p_237491_0_ instanceof TelmasaurusEntity || p_237491_0_ instanceof CatEntity || p_237491_0_ instanceof OcelotEntity || p_237491_0_ instanceof ChickenEntity || p_237491_0_ instanceof ParrotEntity || p_237491_0_ instanceof RabbitEntity || p_237491_0_ instanceof KayentatheriumEntity || p_237491_0_ instanceof MegapnosaurusEntity || p_237491_0_ instanceof ScutellosaurusEntity;
		}));
		this.goalSelector.addGoal(5, new CitipatiEntity.SitOnEggGoal((double)1.2F, 12, 2));
	}

	public void livingTick() {
		super.livingTick();
		if (this.isAsleep() || this.isSitting()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.26D);
		}
		if (!this.isAIDisabled()) {
			List<CitipatiEntity> list = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(20.0D, 20.0D, 20.0D));
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
					if (this.getHealth() < this.getMaxHealth() && this.getHealth() != 0 && this.getAttackTarget() == null && this.getRevengeTarget() == null) {
						float currentHealth = this.getHealth();
						this.setHealth(currentHealth + 1);
					}
				}
				if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
					if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && ticksExisted % 900 == 0 && !this.isChild() && !this.isInLove() && !this.isAsleep() && list.size() < 6) {
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
				if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isChild() && !this.isInLove() && !this.isAsleep() && list.size() < 6) {
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
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 15.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.26D).createMutableAttribute(Attributes.FOLLOW_RANGE, 25.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.0D);
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, attackAnimals);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : SoundInit.CITIPATI_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.CITIPATI_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.CITIPATI_DEATH;
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(ALBINO, false);
		this.dataManager.register(MELANISTIC, false);
		this.dataManager.register(EATING, false);
		this.dataManager.register(SITTING, false);
		this.dataManager.register(NATURAL_LOVE, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("IsEating", this.isEating());
		compound.putBoolean("IsSitting", this.isSitting());
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setAttackGoals();
		this.setEating(compound.getBoolean("IsEating"));
		this.setHunger(compound.getInt("MaxHunger"));
		this.setSitting(compound.getBoolean("IsSitting"));
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

	public boolean onLivingFall(float distance, float damageMultiplier) {
		return false;
	}

	public boolean attackEntityAsMob(Entity entity) {
		boolean flag = super.attackEntityAsMob(entity);
		if (flag) {
			this.applyEnchantments(this, entity);
		}
		return flag;
	}

	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(CitipatiEntity.this, 1.25D, true);
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

	class LayEggGoal extends MoveToBlockGoal {
		private final CitipatiEntity citipati;

		public LayEggGoal(CitipatiEntity citipati, double speed) {
			super(citipati, speed, 16);
			this.citipati = citipati;
		}

		public boolean shouldExecute() {
			return this.citipati.hasEgg() ? super.shouldExecute() : false;
		}

		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && this.citipati.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.citipati.getPositionVec());
			if (!this.citipati.isInWater() && this.getIsAboveDestination()) {
				if(this.citipati.isDigging < 1) {
					this.citipati.setDigging(true);
				} else if (this.citipati.isDigging > 200) {
					World world = this.citipati.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.CITIPATI_EGG.getDefaultState().with(DinosaurEggBlock.EGGS, Integer.valueOf(this.citipati.rand.nextInt(4) + 1)), 3);
					this.citipati.setHasEgg(false);
					this.citipati.setDigging(false);
					this.citipati.setInLove(600);
				}
				if(this.citipati.isDigging()) {
					this.citipati.isDigging++;
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
		private final CitipatiEntity citipati;

		public MateGoal(CitipatiEntity citipati, double speed) {
			super(citipati, speed);
			this.citipati = citipati;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.citipati.hasEgg() && !this.citipati.isInLoveNaturally();
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
			this.citipati.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}

	}

	static class NaturalMateGoal extends BreedGoal {
		private final CitipatiEntity citipati;

		NaturalMateGoal(CitipatiEntity citipati, double speed) {
			super(citipati, speed);
			this.citipati = citipati;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.citipati.hasEgg() && this.citipati.getCurrentHunger() >= this.citipati.getThreeQuartersHunger() && this.citipati.ticksExisted % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.citipati.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.citipati.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.citipati.rand.nextFloat() - this.citipati.rand.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.citipati.rand.nextInt(4);
				if (eggAmount == 0) {
					this.citipati.entityDropItem(PFBlocks.CITIPATI_EGG.asItem());
				}
				if (eggAmount == 1) {
					this.citipati.entityDropItem(PFBlocks.CITIPATI_EGG.asItem());
					this.citipati.entityDropItem(PFBlocks.CITIPATI_EGG.asItem());
				}
				if (eggAmount == 2) {
					this.citipati.entityDropItem(PFBlocks.CITIPATI_EGG.asItem());
					this.citipati.entityDropItem(PFBlocks.CITIPATI_EGG.asItem());
					this.citipati.entityDropItem(PFBlocks.CITIPATI_EGG.asItem());
				}
				if (eggAmount == 3) {
					this.citipati.entityDropItem(PFBlocks.CITIPATI_EGG.asItem());
					this.citipati.entityDropItem(PFBlocks.CITIPATI_EGG.asItem());
					this.citipati.entityDropItem(PFBlocks.CITIPATI_EGG.asItem());
					this.citipati.entityDropItem(PFBlocks.CITIPATI_EGG.asItem());
				}
			} else {
				this.citipati.setHasEgg(true);
			}
			this.animal.resetInLove();
			this.targetMate.resetInLove();
		}

	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		CitipatiEntity entity = new CitipatiEntity(PFEntities.CITIPATI_ENTITY, this.world);
		entity.onInitialSpawn((IServerWorld) this.world, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}

	public class HerbivoreEatGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public HerbivoreEatGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(CitipatiEntity.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
					CitipatiEntity.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					CitipatiEntity.this.world.playSound((PlayerEntity)null, this.destinationBlock, SoundEvents.BLOCK_GRASS_HIT, SoundCategory.NEUTRAL, 1, 1);
				}
			}
			super.tick();
		}

		protected void eatBerry() {
			BlockState blockstate = CitipatiEntity.this.world.getBlockState(this.destinationBlock);
			int hunger = CitipatiEntity.this.getCurrentHunger();

			if (blockstate.isIn(PFBlocks.DEAD_OSMUNDACAULIS)) {
				if (hunger + 2 >= CitipatiEntity.this.maxHunger) {
					CitipatiEntity.this.setHunger(25);
				} else {
					CitipatiEntity.this.setHunger(hunger + 2);
				}
			}
			if (blockstate.isIn(Blocks.GRASS) || blockstate.isIn(Blocks.TALL_GRASS) || blockstate.isIn(BlockTags.FLOWERS)) {
				if (hunger + 4 >= CitipatiEntity.this.maxHunger) {
					CitipatiEntity.this.setHunger(CitipatiEntity.this.maxHunger);
				} else {
					CitipatiEntity.this.setHunger(hunger + 4);
				}
			}
			if (blockstate.isIn(Blocks.VINE)) {
				if (hunger + 6 >= CitipatiEntity.this.maxHunger) {
					CitipatiEntity.this.setHunger(CitipatiEntity.this.maxHunger);
				} else {
					CitipatiEntity.this.setHunger(hunger + 6);
				}
			}
			if (blockstate.isIn(PFBlocks.MARCHANTIA) || blockstate.isIn(PFBlocks.OSMUNDACAULIS) || blockstate.isIn(PFBlocks.OTOZAMITES)) {
				if (hunger + 8 >= CitipatiEntity.this.maxHunger) {
					CitipatiEntity.this.setHunger(CitipatiEntity.this.maxHunger);
				} else {
					CitipatiEntity.this.setHunger(hunger + 8);
				}
			}
			if (blockstate.isIn(PFBlocks.HORSETAIL) || blockstate.isIn(PFBlocks.CLUBMOSS) || blockstate.isIn(PFBlocks.MICHELILLOA) || blockstate.isIn(PFBlocks.COBBANIA) || blockstate.isIn(PFBlocks.LAUROZAMITES) || blockstate.isIn(PFBlocks.CLATHOPTERIS)) {
				if (hunger + 10 >= CitipatiEntity.this.maxHunger) {
					CitipatiEntity.this.setHunger(CitipatiEntity.this.maxHunger);
				} else {
					CitipatiEntity.this.setHunger(hunger + 10);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_OSMUNDACAULIS) || blockstate.isIn(PFBlocks.TALL_OTOZAMITES)) {
				if (hunger + 12 >= CitipatiEntity.this.maxHunger) {
					CitipatiEntity.this.setHunger(CitipatiEntity.this.maxHunger);
				} else {
					CitipatiEntity.this.setHunger(hunger + 12);
				}
			}
			if (blockstate.isIn(PFBlocks.OSMUNDA) || blockstate.isIn(Blocks.FERN) || blockstate.isIn(PFBlocks.CONIOPTERIS) || blockstate.isIn(PFBlocks.CLADOPHLEBIS)) {
				if (hunger + 15 >= CitipatiEntity.this.maxHunger) {
					CitipatiEntity.this.setHunger(CitipatiEntity.this.maxHunger);
				} else {
					CitipatiEntity.this.setHunger(hunger + 15);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_HORSETAIL) || blockstate.isIn(PFBlocks.SCYTOPHYLLUM)) {
				if (hunger + 20 >= CitipatiEntity.this.maxHunger) {
					CitipatiEntity.this.setHunger(CitipatiEntity.this.maxHunger);
				} else {
					CitipatiEntity.this.setHunger(hunger + 20);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_OSMUNDA) || blockstate.isIn(Blocks.LARGE_FERN) || blockstate.isIn(PFBlocks.JOHNSTONIA)) {
				if (hunger + 25 >= CitipatiEntity.this.maxHunger) {
					CitipatiEntity.this.setHunger(CitipatiEntity.this.maxHunger);
				} else {
					CitipatiEntity.this.setHunger(hunger + 25);
				}
			}
			if (blockstate.isIn(PFBlocks.DICROIDIUM)) {
				if (hunger + 30 >= CitipatiEntity.this.maxHunger) {
					CitipatiEntity.this.setHunger(CitipatiEntity.this.maxHunger);
				} else {
					CitipatiEntity.this.setHunger(hunger + 30);
				}
			}
			CitipatiEntity.this.setEating(false);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return !CitipatiEntity.this.isAsleep() && super.shouldExecute() && CitipatiEntity.this.getCurrentHunger() < CitipatiEntity.this.getHalfHunger();
		}

		public boolean shouldContinueExecuting() {
			if (CitipatiEntity.this.getCurrentHunger() >= CitipatiEntity.this.maxHunger || CitipatiEntity.this.isAsleep()) {
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

	@SuppressWarnings("rawtypes")
	public class CarnivoreHuntGoal extends NearestAttackableTargetGoal {

		@SuppressWarnings("unchecked")
		public CarnivoreHuntGoal(MobEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && CitipatiEntity.this.getCurrentHunger() <= CitipatiEntity.this.getHalfHunger() && CitipatiEntity.this.isChild();
		}

		public boolean shouldContinueExecuting() {
			return CitipatiEntity.this.getCurrentHunger() < CitipatiEntity.this.maxHunger || !CitipatiEntity.this.isChild();
		}

		public void tick() {
			LivingEntity target = CitipatiEntity.this.getAttackTarget();
			if (target instanceof RabbitEntity) {
				if (target.getHealth() == 0) {
					if (CitipatiEntity.this.getCurrentHunger() + 3 >= CitipatiEntity.this.maxHunger) {
						CitipatiEntity.this.setHunger(CitipatiEntity.this.maxHunger);
					} else {
						CitipatiEntity.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof DidelphodonEntity || target instanceof EilenodonEntity || target instanceof HyperodapedonEntity || target instanceof ChickenEntity || target instanceof HesperornithoidesEntity || target instanceof ScutellosaurusEntity) {
				if (target.getHealth() == 0) {
					if (CitipatiEntity.this.getCurrentHunger() + 4 >= CitipatiEntity.this.maxHunger) {
						CitipatiEntity.this.setHunger(CitipatiEntity.this.maxHunger);
					} else {
						CitipatiEntity.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof TelmasaurusEntity || target instanceof ChromogisaurusEntity || target instanceof KayentatheriumEntity || target instanceof MegapnosaurusEntity) {
				if (target.getHealth() == 0) {
					if (CitipatiEntity.this.getCurrentHunger() + 6 >= CitipatiEntity.this.maxHunger) {
						CitipatiEntity.this.setHunger(CitipatiEntity.this.maxHunger);
					} else {
						CitipatiEntity.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}

	class SitOnEggGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public SitOnEggGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(CitipatiEntity.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
			Block egg = blockstate.getBlock();
			return egg instanceof DinosaurEggBlock && blockstate.get(DinosaurEggBlock.EGGS) >= 1;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (this.getIsAboveDestination()) {
				if (this.field_220731_g >= 40) {
					this.eatBerry();
				} else {
					++this.field_220731_g;
				}
			}
			if (CitipatiEntity.this.ticksExisted % 80 != 0) {
				this.resetTask();
			}
			super.tick();
		}

		public void resetTask() {
			super.resetTask();
			CitipatiEntity.this.setSitting(false);
		}

		protected void eatBerry() {
			if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(CitipatiEntity.this.world, CitipatiEntity.this)) {
				BlockState blockstate = CitipatiEntity.this.world.getBlockState(this.destinationBlock);
				world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, blockstate), destinationBlock.getX(), destinationBlock.getY(), destinationBlock.getZ(), 0.0D, 0.0D, 0.0D);
				Block egg = blockstate.getBlock();
				if (egg instanceof DinosaurEggBlock) {
					int eggs = blockstate.get(DinosaurEggBlock.EGGS);
					int hatch = blockstate.get(DinosaurEggBlock.HATCH);
					blockstate.with(DinosaurEggBlock.EGGS, Integer.valueOf(1));
					CitipatiEntity.this.world.setBlockState(this.destinationBlock, blockstate.with(DinosaurEggBlock.EGGS, eggs).with(DinosaurEggBlock.HATCH, hatch).with(DinosaurEggBlock.CITIPATIFIED, true));
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return !CitipatiEntity.this.isSleeping() && super.shouldExecute() && CitipatiEntity.this.ticksExisted % 60 == 0;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			this.field_220731_g = 0;
			super.startExecuting();
			CitipatiEntity.this.setSitting(true);
		}


		public boolean shouldContinueExecuting() {
			return CitipatiEntity.this.ticksExisted % 80 != 0;
		}

	}

}
