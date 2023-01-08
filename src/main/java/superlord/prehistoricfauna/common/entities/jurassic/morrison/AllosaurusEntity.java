package superlord.prehistoricfauna.common.entities.jurassic.morrison;

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
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.merchant.villager.WanderingTraderEntity;
import net.minecraft.entity.monster.AbstractIllagerEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
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
import superlord.prehistoricfauna.common.blocks.AllosaurusEggBlock;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.AepyornithomimusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.CitipatiEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.PinacosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.PlesiohadrosEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.ProtoceratopsEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.TelmasaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.AnkylosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DakotaraptorEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DidelphodonEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.ThescelosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TriceratopsEntity;
import superlord.prehistoricfauna.common.entities.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entities.goal.HuntGoal;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.SarahsaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.ScelidosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.ScutellosaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.CoelophysisEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.DesmatosuchusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PlaceriasEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PoposaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PostosuchusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.TrilophosaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.TypothoraxEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HerrerasaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HyperodapedonEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.IschigualastiaEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SaurosuchusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SillosuchusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEffects;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.SoundInit;

public class AllosaurusEntity extends DinosaurEntity {

	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(AllosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(AllosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(AllosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(AllosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> NATURAL_LOVE = EntityDataManager.createKey(AllosaurusEntity.class, DataSerializers.BOOLEAN);
	private int currentHunger;
	private int maxHunger = 150;
	int hungerTick = 0;
	private int warningSoundTicks;
	private int isDigging;
	private int lastInLove = 0;
	int loveTick = 0;
	private Goal attackAnimals;

	public AllosaurusEntity(EntityType<? extends AllosaurusEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public boolean isDigging() {
		return this.dataManager.get(IS_DIGGING);
	}

	public boolean isInLoveNaturally() {
		return this.dataManager.get(NATURAL_LOVE);
	}

	private void setInLoveNaturally(boolean isInLoveNaturally) {
		this.dataManager.set(NATURAL_LOVE, isInLoveNaturally);
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
		return stack.getItem() == PFItems.RAW_LARGE_THYREOPHORAN_MEAT.get();
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

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.attackAnimals = new HuntGoal(this, AnimalEntity.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof AepyornithomimusEntity || p_213487_0_ instanceof AnkylosaurusEntity || p_213487_0_ instanceof CitipatiEntity || p_213487_0_ instanceof DakotaraptorEntity || p_213487_0_ instanceof DryosaurusEntity || p_213487_0_ instanceof HerrerasaurusEntity || p_213487_0_ instanceof IschigualastiaEntity || p_213487_0_ instanceof PinacosaurusEntity || p_213487_0_ instanceof PlesiohadrosEntity || p_213487_0_ instanceof ProtoceratopsEntity || p_213487_0_ instanceof SaurosuchusEntity || p_213487_0_ instanceof SillosuchusEntity || p_213487_0_ instanceof StegosaurusEntity || p_213487_0_ instanceof ThescelosaurusEntity || p_213487_0_ instanceof TriceratopsEntity || p_213487_0_ instanceof CatEntity || p_213487_0_ instanceof OcelotEntity || p_213487_0_ instanceof CowEntity || p_213487_0_ instanceof AbstractHorseEntity || p_213487_0_ instanceof FoxEntity || p_213487_0_ instanceof MooshroomEntity || p_213487_0_ instanceof PigEntity || p_213487_0_ instanceof AbstractVillagerEntity || p_213487_0_ instanceof WanderingTraderEntity || p_213487_0_ instanceof AbstractIllagerEntity || p_213487_0_ instanceof LlamaEntity || p_213487_0_ instanceof PandaEntity || p_213487_0_ instanceof PolarBearEntity || p_213487_0_ instanceof TurtleEntity || p_213487_0_ instanceof PlayerEntity || p_213487_0_ instanceof SarahsaurusEntity || p_213487_0_ instanceof ScelidosaurusEntity || p_213487_0_ instanceof CoelophysisEntity || p_213487_0_ instanceof DesmatosuchusEntity || p_213487_0_ instanceof PlaceriasEntity || p_213487_0_ instanceof PoposaurusEntity || p_213487_0_ instanceof PostosuchusEntity || p_213487_0_ instanceof TypothoraxEntity || p_213487_0_ instanceof TrilophosaurusEntity;
		});
		this.goalSelector.addGoal(1, new AllosaurusEntity.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new AllosaurusEntity.PanicGoal());
		this.targetSelector.addGoal(2, new AllosaurusEntity.TerritoryAttackGoal());
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new AllosaurusEntity.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new AllosaurusEntity.AttackPlayerGoal());
		this.goalSelector.addGoal(0, new AllosaurusEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new AllosaurusEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new AllosaurusEntity.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(8, new AvoidEntityGoal<CamarasaurusEntity>(this, CamarasaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.targetSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, true, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof AepyornithomimusEntity || p_213487_0_ instanceof AnkylosaurusEntity || p_213487_0_ instanceof CitipatiEntity || p_213487_0_ instanceof DakotaraptorEntity || p_213487_0_ instanceof DryosaurusEntity || p_213487_0_ instanceof HerrerasaurusEntity || p_213487_0_ instanceof IschigualastiaEntity || p_213487_0_ instanceof PinacosaurusEntity || p_213487_0_ instanceof PlesiohadrosEntity || p_213487_0_ instanceof ProtoceratopsEntity || p_213487_0_ instanceof SaurosuchusEntity || p_213487_0_ instanceof SillosuchusEntity || p_213487_0_ instanceof StegosaurusEntity || p_213487_0_ instanceof ThescelosaurusEntity || p_213487_0_ instanceof TriceratopsEntity || p_213487_0_ instanceof CatEntity || p_213487_0_ instanceof OcelotEntity || p_213487_0_ instanceof CowEntity || p_213487_0_ instanceof AbstractHorseEntity || p_213487_0_ instanceof FoxEntity || p_213487_0_ instanceof MooshroomEntity || p_213487_0_ instanceof PigEntity || p_213487_0_ instanceof AbstractVillagerEntity || p_213487_0_ instanceof WanderingTraderEntity || p_213487_0_ instanceof AbstractIllagerEntity || p_213487_0_ instanceof LlamaEntity || p_213487_0_ instanceof PandaEntity || p_213487_0_ instanceof PolarBearEntity || p_213487_0_ instanceof TurtleEntity || p_213487_0_ instanceof PlayerEntity || p_213487_0_ instanceof SarahsaurusEntity || p_213487_0_ instanceof ScelidosaurusEntity || p_213487_0_ instanceof CoelophysisEntity || p_213487_0_ instanceof DesmatosuchusEntity || p_213487_0_ instanceof PlaceriasEntity || p_213487_0_ instanceof PoposaurusEntity || p_213487_0_ instanceof PostosuchusEntity || p_213487_0_ instanceof TypothoraxEntity || p_213487_0_ instanceof TrilophosaurusEntity;
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, true, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof DidelphodonEntity || p_213487_1_ instanceof EilenodonEntity || p_213487_1_ instanceof HyperodapedonEntity || p_213487_1_ instanceof TelmasaurusEntity || p_213487_1_ instanceof RabbitEntity || p_213487_1_ instanceof ChickenEntity || p_213487_1_ instanceof HesperornithoidesEntity || p_213487_1_ instanceof ScutellosaurusEntity;
		}));

	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 60.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.25F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 12.0D).createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.6D);
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, this.attackAnimals);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? SoundInit.ALLOSAURUS_SNORES : SoundInit.ALLOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.ALLOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.ALLOSAURUS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundInit.ALLOSAURUS_WARN, 1.0F, this.getSoundPitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(ALBINO, false);
		this.dataManager.register(MELANISTIC, false);
		this.dataManager.register(NATURAL_LOVE, false);
	}

	@Override
	public void livingTick() {
		super.livingTick();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue((double)0.25F);
		}
		if (!this.isAIDisabled()) {
			List<AllosaurusEntity> list = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(20.0D, 20.0D, 20.0D));
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
				}if (this.getCurrentHunger() >= this.getThreeQuartersHunger() && hungerTick % 150 == 0) {
					if (this.getHealth() < this.getMaxHealth() && this.getHealth() != 0 && this.getAttackTarget() == null && this.getRevengeTarget() == null) {
						float currentHealth = this.getHealth();
						this.setHealth(currentHealth + 1);
					}
				}
				if (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) {
					if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && ticksExisted % 900 == 0 && !this.isChild() && !this.isInLove() && !this.isAsleep() && list.size() < 5) {
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
			} else if ((PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && !PrehistoricFaunaConfig.advancedHunger && list.size() < 5) {
				int naturalBreedingChance = rand.nextInt(1000);
				if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isChild() && !this.isInLove() && !this.isAsleep()) {
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

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setAttackGoals();
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

	/**
	 * Called to update the entity's position/logic.
	 */
	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}

	public boolean onAttackAnimationFinish(Entity entityIn) {
		boolean flag = super.onAttackAnimationFinish(entityIn);
		if (flag) {
			this.applyEnchantments(this, entityIn);
			((LivingEntity)entityIn).addPotionEffect(new EffectInstance(PFEffects.BLEEDING.get(), 300, 0, true, false));
		}

		return flag;
	}	



	class AttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public AttackPlayerGoal() {
			super(AllosaurusEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean shouldExecute() {
			if (AllosaurusEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for(AllosaurusEntity allosaurus : AllosaurusEntity.this.world.getEntitiesWithinAABB(AllosaurusEntity.class, AllosaurusEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
						if (allosaurus.isChild()) {
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
			super(AllosaurusEntity.this);
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			super.startExecuting();
			if (AllosaurusEntity.this.isChild()) {
				this.alertOthers();
				this.resetTask();
			}

		}

		protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
			if (mobIn instanceof AllosaurusEntity && !mobIn.isChild()) {
				super.setAttackTarget(mobIn, targetIn);
			}

		}
	}

	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(AllosaurusEntity.this, 1.25D, true);
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
					AllosaurusEntity.this.playWarningSound();
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
			return (double)(8.0F + attackTarget.getWidth());
		}
	}

	class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(AllosaurusEntity.this, 2.0D);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return !AllosaurusEntity.this.isChild() && !AllosaurusEntity.this.isBurning() ? false : super.shouldExecute();
		}
	}

	class TerritoryAttackGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public TerritoryAttackGoal() {
			super(AllosaurusEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			if (AllosaurusEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for(@SuppressWarnings("unused") AllosaurusEntity allosaurus : AllosaurusEntity.this.world.getEntitiesWithinAABB(AllosaurusEntity.class, AllosaurusEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
						return true;
					}
				}

				return false;
			}
		}

		protected double getTargetDistance() {
			return super.getTargetDistance() * 0.5D;
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final AllosaurusEntity allosaurus;

		LayEggGoal(AllosaurusEntity allosaurus, double speedIn) {
			super(allosaurus, speedIn, 16);
			this.allosaurus = allosaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return this.allosaurus.hasEgg() ? super.shouldExecute() : false;
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && this.allosaurus.hasEgg();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.allosaurus.getPositionVec());
			if (!this.allosaurus.isInWater() && this.getIsAboveDestination()) {
				if (this.allosaurus.isDigging < 1) {
					this.allosaurus.setDigging(true);
				} else if (this.allosaurus.isDigging > 200) {
					World world = this.allosaurus.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.ALLOSAURUS_EGG.getDefaultState().with(AllosaurusEggBlock.EGGS, Integer.valueOf(this.allosaurus.rand.nextInt(4) + 1)), 3);
					this.allosaurus.setHasEgg(false);
					this.allosaurus.setDigging(false);
					this.allosaurus.setInLove(600);
				}

				if (this.allosaurus.isDigging()) {
					this.allosaurus.isDigging++;
				}
			}

		}

		/**
		 * Return true to set given position as destination
		 */
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
		private final AllosaurusEntity allosaurus;

		MateGoal(AllosaurusEntity allosaurus, double speedIn) {
			super(allosaurus, speedIn);
			this.allosaurus = allosaurus;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return super.shouldExecute() && !this.allosaurus.hasEgg() && !this.allosaurus.isInLoveNaturally();
		}

		/**
		 * Spawns a baby animal of the same type.
		 */
		protected void spawnBaby() {
			ServerPlayerEntity serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.targetMate.getLoveCause() != null) {
				serverplayerentity = this.targetMate.getLoveCause();
			}

			if (serverplayerentity != null) {
				serverplayerentity.addStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.targetMate, (AgeableEntity)null);
			}

			this.allosaurus.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}

		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final AllosaurusEntity allosaurus;

		NaturalMateGoal(AllosaurusEntity allosaurus, double speed) {
			super(allosaurus, speed);
			this.allosaurus = allosaurus;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.allosaurus.hasEgg() && this.allosaurus.getCurrentHunger() >= this.allosaurus.getThreeQuartersHunger() && this.allosaurus.ticksExisted % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.allosaurus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.allosaurus.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.allosaurus.rand.nextFloat() - this.allosaurus.rand.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.allosaurus.rand.nextInt(4);
				if (eggAmount == 0) {
					this.allosaurus.entityDropItem(PFBlocks.ALLOSAURUS_EGG.asItem());
				}
				if (eggAmount == 1) {
					this.allosaurus.entityDropItem(PFBlocks.ALLOSAURUS_EGG.asItem());
					this.allosaurus.entityDropItem(PFBlocks.ALLOSAURUS_EGG.asItem());
				}
				if (eggAmount == 2) {
					this.allosaurus.entityDropItem(PFBlocks.ALLOSAURUS_EGG.asItem());
					this.allosaurus.entityDropItem(PFBlocks.ALLOSAURUS_EGG.asItem());
					this.allosaurus.entityDropItem(PFBlocks.ALLOSAURUS_EGG.asItem());
				}
				if (eggAmount == 3) {
					this.allosaurus.entityDropItem(PFBlocks.ALLOSAURUS_EGG.asItem());
					this.allosaurus.entityDropItem(PFBlocks.ALLOSAURUS_EGG.asItem());
					this.allosaurus.entityDropItem(PFBlocks.ALLOSAURUS_EGG.asItem());
					this.allosaurus.entityDropItem(PFBlocks.ALLOSAURUS_EGG.asItem());
				}
			} else {
				this.allosaurus.setHasEgg(true);
			}
			this.animal.resetInLove();
			this.targetMate.resetInLove();
		}

	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		AllosaurusEntity entity = new AllosaurusEntity(PFEntities.ALLOSAURUS_ENTITY, this.world);
		entity.onInitialSpawn(p_241840_1_, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}

	@SuppressWarnings("rawtypes")
	public class CarnivoreHuntGoal extends NearestAttackableTargetGoal {

		@SuppressWarnings("unchecked")
		public CarnivoreHuntGoal(MobEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && AllosaurusEntity.this.getCurrentHunger() <= AllosaurusEntity.this.getHalfHunger() && !AllosaurusEntity.this.isChild();
		}

		public boolean shouldContinueExecuting() {
			return AllosaurusEntity.this.getCurrentHunger() > AllosaurusEntity.this.maxHunger;
		}

		public void tick() {
			LivingEntity target = AllosaurusEntity.this.getAttackTarget();
			if (target instanceof CatEntity || target instanceof FoxEntity || target instanceof CowEntity || target instanceof MooshroomEntity || target instanceof PigEntity || target instanceof OcelotEntity || target instanceof AepyornithomimusEntity || target instanceof ProtoceratopsEntity || target instanceof CoelophysisEntity || target instanceof TypothoraxEntity || target instanceof TrilophosaurusEntity) {
				if (target.getHealth() == 0) {
					if (AllosaurusEntity.this.getCurrentHunger() + 10 >= AllosaurusEntity.this.maxHunger) {
						AllosaurusEntity.this.setHunger(AllosaurusEntity.this.maxHunger);
					} else {
						AllosaurusEntity.this.setHunger(currentHunger + 10);
					}
				}
			}
			if (target instanceof CitipatiEntity || target instanceof DryosaurusEntity || target instanceof ThescelosaurusEntity || target instanceof ScelidosaurusEntity || target instanceof SarahsaurusEntity) {
				if (target.getHealth() == 0) {
					if (AllosaurusEntity.this.getCurrentHunger() + 15 >= AllosaurusEntity.this.maxHunger) {
						AllosaurusEntity.this.setHunger(AllosaurusEntity.this.maxHunger);
					} else {
						AllosaurusEntity.this.setHunger(currentHunger + 15);
					}
				}
			}
			if (target instanceof HerrerasaurusEntity || target instanceof PlaceriasEntity || target instanceof PostosuchusEntity || target instanceof AbstractHorseEntity || target instanceof WanderingTraderEntity || target instanceof PlayerEntity || target instanceof AbstractVillagerEntity || target instanceof AbstractIllagerEntity || target instanceof LlamaEntity || target instanceof PandaEntity || target instanceof PoposaurusEntity || target instanceof DesmatosuchusEntity) {
				if (target.getHealth() == 0) {
					if (AllosaurusEntity.this.getCurrentHunger() + 20 >= AllosaurusEntity.this.maxHunger) {
						AllosaurusEntity.this.setHunger(AllosaurusEntity.this.maxHunger);
					} else {
						AllosaurusEntity.this.setHunger(currentHunger + 20);
					}
				}
			}
			if (target instanceof DakotaraptorEntity || target instanceof PolarBearEntity || target instanceof TurtleEntity || target instanceof SaurosuchusEntity) {
				if (target.getHealth() == 0) {
					if (AllosaurusEntity.this.getCurrentHunger() + 30 >= AllosaurusEntity.this.maxHunger) {
						AllosaurusEntity.this.setHunger(AllosaurusEntity.this.maxHunger);
					} else {
						AllosaurusEntity.this.setHunger(currentHunger + 30);
					}
				}
			}
			if (target instanceof IschigualastiaEntity || target instanceof PinacosaurusEntity || target instanceof PlesiohadrosEntity) {
				if (target.getHealth() == 0) {
					if (AllosaurusEntity.this.getCurrentHunger() + 40 >= AllosaurusEntity.this.maxHunger) {
						AllosaurusEntity.this.setHunger(AllosaurusEntity.this.maxHunger);
					} else {
						AllosaurusEntity.this.setHunger(currentHunger + 40);
					}
				}
			}
			if (target instanceof AnkylosaurusEntity || target instanceof SillosuchusEntity || target instanceof StegosaurusEntity || target instanceof TriceratopsEntity) {
				if (target.getHealth() == 0) {
					if (AllosaurusEntity.this.getCurrentHunger() + 60 >= AllosaurusEntity.this.maxHunger) {
						AllosaurusEntity.this.setHunger(AllosaurusEntity.this.maxHunger);
					} else {
						AllosaurusEntity.this.setHunger(currentHunger + 60);
					}
				}
			}
			super.tick();
		}

	}

	@SuppressWarnings("rawtypes")
	public class BabyCarnivoreHuntGoal extends NearestAttackableTargetGoal {

		@SuppressWarnings("unchecked")
		public BabyCarnivoreHuntGoal(MobEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && AllosaurusEntity.this.getCurrentHunger() <= AllosaurusEntity.this.getHalfHunger() && AllosaurusEntity.this.isChild();
		}

		public boolean shouldContinueExecuting() {
			return AllosaurusEntity.this.getCurrentHunger() > AllosaurusEntity.this.maxHunger || !AllosaurusEntity.this.isChild();
		}

		public void tick() {
			LivingEntity target = AllosaurusEntity.this.getAttackTarget();
			if (target instanceof RabbitEntity) {
				if (target.getHealth() == 0) {
					if (AllosaurusEntity.this.getCurrentHunger() + 3 >= AllosaurusEntity.this.maxHunger) {
						AllosaurusEntity.this.setHunger(AllosaurusEntity.this.maxHunger);
					} else {
						AllosaurusEntity.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof DidelphodonEntity || target instanceof EilenodonEntity || target instanceof HyperodapedonEntity || target instanceof ChickenEntity || target instanceof HesperornithoidesEntity || target instanceof ScutellosaurusEntity) {
				if (target.getHealth() == 0) {
					if (AllosaurusEntity.this.getCurrentHunger() + 4 >= AllosaurusEntity.this.maxHunger) {
						AllosaurusEntity.this.setHunger(AllosaurusEntity.this.maxHunger);
					} else {
						AllosaurusEntity.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof TelmasaurusEntity) {
				if (target.getHealth() == 0) {
					if (AllosaurusEntity.this.getCurrentHunger() + 6 >= AllosaurusEntity.this.maxHunger) {
						AllosaurusEntity.this.setHunger(AllosaurusEntity.this.maxHunger);
					} else {
						AllosaurusEntity.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}

}