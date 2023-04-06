package superlord.prehistoricfauna.common.entities.cretaceous.hellcreek;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
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
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.WolfEntity;
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
import superlord.prehistoricfauna.common.blocks.DinosaurEggBlock;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.AepyornithomimusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.CitipatiEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.PinacosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.PlesiohadrosEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.ProtoceratopsEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.TelmasaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.VelociraptorEntity;
import superlord.prehistoricfauna.common.entities.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entities.goal.HuntGoal;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.DilophosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.KayentatheriumEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.MegapnosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.SarahsaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.ScelidosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.ScutellosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.AllosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CeratosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.DryosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.EilenodonEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.HesperornithoidesEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.StegosaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.CoelophysisEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.DesmatosuchusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PlaceriasEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PoposaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PostosuchusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.TrilophosaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.chinle.TypothoraxEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ChromogisaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ExaeretodonEntity;
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

public class TyrannosaurusEntity extends DinosaurEntity {
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(TyrannosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(TyrannosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_JUVENILE = EntityDataManager.createKey(TyrannosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(TyrannosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(TyrannosaurusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> NATURAL_LOVE = EntityDataManager.createKey(TyrannosaurusEntity.class, DataSerializers.BOOLEAN);
	private int currentHunger;
	private int maxHunger = 250;
	private int lastInLove = 0;
	int hungerTick = 0;
	private int warningSoundTicks;
	private int isDigging;
	public int attackTick = 0;
	int loveTick = 0;
	private Goal panicGoal;

	public TyrannosaurusEntity(EntityType<? extends TyrannosaurusEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		if (this.isJuvenile()) {
			return 1.4F;
		} else if (this.isJuvenile()) {
			return 2.8F;
		} else return 4.0F;
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

	public boolean isJuvenile() {
		return this.dataManager.get(IS_JUVENILE);
	}

	private void setJuvenile(boolean isJuvenile) {
		this.dataManager.set(IS_JUVENILE, isJuvenile);
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
		return stack.getItem() == PFItems.RAW_LARGE_MARGINOCEPHALIAN_MEAT.get();
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void registerGoals() {
		super.registerGoals();

		panicGoal = new TyrannosaurusEntity.PanicGoal();
		this.goalSelector.addGoal(1, panicGoal);
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(4, new TyrannosaurusEntity.TyrannosaurusFollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, AnkylosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(1, new TyrannosaurusEntity.MeleeAttackGoal());
		this.targetSelector.addGoal(1, new TyrannosaurusEntity.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new TyrannosaurusEntity.AttackPlayerGoal(this));
		this.targetSelector.addGoal(2, new TyrannosaurusEntity.TerritoryAttackGoal());
		this.goalSelector.addGoal(0, new TyrannosaurusEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new TyrannosaurusEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new TyrannosaurusEntity.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.targetSelector.addGoal(1, new JuvenileHuntGoal(this, AnimalEntity.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof AepyornithomimusEntity || p_213487_0_ instanceof BasilemysEntity || p_213487_0_ instanceof ChromogisaurusEntity || p_213487_0_ instanceof CitipatiEntity || p_213487_0_ instanceof DidelphodonEntity || p_213487_0_ instanceof DryosaurusEntity || p_213487_0_ instanceof EilenodonEntity || p_213487_0_ instanceof ExaeretodonEntity || p_213487_0_ instanceof HerrerasaurusEntity || p_213487_0_ instanceof HesperornithoidesEntity || p_213487_0_ instanceof HyperodapedonEntity || p_213487_0_ instanceof ProtoceratopsEntity || p_213487_0_ instanceof TelmasaurusEntity || p_213487_0_ instanceof ThescelosaurusEntity || p_213487_0_ instanceof VelociraptorEntity || p_213487_0_ instanceof CatEntity || p_213487_0_ instanceof OcelotEntity || p_213487_0_ instanceof ChickenEntity || p_213487_0_ instanceof CowEntity || p_213487_0_ instanceof AbstractHorseEntity || p_213487_0_ instanceof FoxEntity || p_213487_0_ instanceof MooshroomEntity || p_213487_0_ instanceof PigEntity || p_213487_0_ instanceof ParrotEntity || p_213487_0_ instanceof RabbitEntity || p_213487_0_ instanceof AbstractVillagerEntity || p_213487_0_ instanceof WanderingTraderEntity || p_213487_0_ instanceof AbstractIllagerEntity || p_213487_0_ instanceof PlayerEntity || p_213487_0_ instanceof LlamaEntity || p_213487_0_ instanceof TurtleEntity || p_213487_0_ instanceof SarahsaurusEntity || p_213487_0_ instanceof ScelidosaurusEntity || p_213487_0_ instanceof MegapnosaurusEntity || p_213487_0_ instanceof KayentatheriumEntity || p_213487_0_ instanceof ScutellosaurusEntity || p_213487_0_ instanceof SheepEntity || p_213487_0_ instanceof CoelophysisEntity || p_213487_0_ instanceof DesmatosuchusEntity || p_213487_0_ instanceof PlaceriasEntity || p_213487_0_ instanceof TypothoraxEntity || p_213487_0_ instanceof TrilophosaurusEntity;
		}));
		this.targetSelector.addGoal(1, new HuntGoal(this, AnimalEntity.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof AepyornithomimusEntity || p_213487_0_ instanceof AnkylosaurusEntity || p_213487_0_ instanceof CitipatiEntity || p_213487_0_ instanceof DakotaraptorEntity || p_213487_0_ instanceof DryosaurusEntity || p_213487_0_ instanceof HerrerasaurusEntity || p_213487_0_ instanceof IschigualastiaEntity || p_213487_0_ instanceof PinacosaurusEntity || p_213487_0_ instanceof PlesiohadrosEntity || p_213487_0_ instanceof ProtoceratopsEntity || p_213487_0_ instanceof SaurosuchusEntity || p_213487_0_ instanceof SillosuchusEntity || p_213487_0_ instanceof StegosaurusEntity || p_213487_0_ instanceof ThescelosaurusEntity || p_213487_0_ instanceof TriceratopsEntity || p_213487_0_ instanceof CatEntity || p_213487_0_ instanceof OcelotEntity || p_213487_0_ instanceof CowEntity || p_213487_0_ instanceof AbstractHorseEntity || p_213487_0_ instanceof FoxEntity || p_213487_0_ instanceof MooshroomEntity || p_213487_0_ instanceof PigEntity || p_213487_0_ instanceof AbstractVillagerEntity || p_213487_0_ instanceof WanderingTraderEntity || p_213487_0_ instanceof AbstractIllagerEntity || p_213487_0_ instanceof LlamaEntity || p_213487_0_ instanceof PandaEntity || p_213487_0_ instanceof PolarBearEntity || p_213487_0_ instanceof TurtleEntity || p_213487_0_ instanceof PlayerEntity || p_213487_0_ instanceof CeratosaurusEntity || p_213487_0_ instanceof AllosaurusEntity || p_213487_0_ instanceof DilophosaurusEntity || p_213487_0_ instanceof SarahsaurusEntity || p_213487_0_ instanceof ScelidosaurusEntity || p_213487_0_ instanceof CoelophysisEntity || p_213487_0_ instanceof DesmatosuchusEntity || p_213487_0_ instanceof PlaceriasEntity || p_213487_0_ instanceof PoposaurusEntity || p_213487_0_ instanceof PostosuchusEntity || p_213487_0_ instanceof TypothoraxEntity || p_213487_0_ instanceof TrilophosaurusEntity;
		}));
		this.targetSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, true, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof AepyornithomimusEntity || p_213487_0_ instanceof AnkylosaurusEntity || p_213487_0_ instanceof CitipatiEntity || p_213487_0_ instanceof DakotaraptorEntity || p_213487_0_ instanceof DryosaurusEntity || p_213487_0_ instanceof HerrerasaurusEntity || p_213487_0_ instanceof IschigualastiaEntity || p_213487_0_ instanceof PinacosaurusEntity || p_213487_0_ instanceof PlesiohadrosEntity || p_213487_0_ instanceof ProtoceratopsEntity || p_213487_0_ instanceof SaurosuchusEntity || p_213487_0_ instanceof SillosuchusEntity || p_213487_0_ instanceof StegosaurusEntity || p_213487_0_ instanceof ThescelosaurusEntity || p_213487_0_ instanceof TriceratopsEntity || p_213487_0_ instanceof CatEntity || p_213487_0_ instanceof OcelotEntity || p_213487_0_ instanceof CowEntity || p_213487_0_ instanceof AbstractHorseEntity || p_213487_0_ instanceof FoxEntity || p_213487_0_ instanceof MooshroomEntity || p_213487_0_ instanceof PigEntity || p_213487_0_ instanceof AbstractVillagerEntity || p_213487_0_ instanceof WanderingTraderEntity || p_213487_0_ instanceof AbstractIllagerEntity || p_213487_0_ instanceof LlamaEntity || p_213487_0_ instanceof PandaEntity || p_213487_0_ instanceof PolarBearEntity || p_213487_0_ instanceof TurtleEntity || p_213487_0_ instanceof PlayerEntity || p_213487_0_ instanceof CeratosaurusEntity || p_213487_0_ instanceof AllosaurusEntity || p_213487_0_ instanceof DilophosaurusEntity || p_213487_0_ instanceof SarahsaurusEntity || p_213487_0_ instanceof ScelidosaurusEntity || p_213487_0_ instanceof CoelophysisEntity || p_213487_0_ instanceof DesmatosuchusEntity || p_213487_0_ instanceof PlaceriasEntity || p_213487_0_ instanceof PoposaurusEntity || p_213487_0_ instanceof PostosuchusEntity || p_213487_0_ instanceof TypothoraxEntity || p_213487_0_ instanceof TrilophosaurusEntity;
		}));
		this.targetSelector.addGoal(0, new JuvenileCarnivoreHuntGoal(this, LivingEntity.class, 10, true, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof AepyornithomimusEntity || p_213487_0_ instanceof BasilemysEntity || p_213487_0_ instanceof ChromogisaurusEntity || p_213487_0_ instanceof CitipatiEntity || p_213487_0_ instanceof DidelphodonEntity || p_213487_0_ instanceof DryosaurusEntity || p_213487_0_ instanceof EilenodonEntity || p_213487_0_ instanceof ExaeretodonEntity || p_213487_0_ instanceof HerrerasaurusEntity || p_213487_0_ instanceof HesperornithoidesEntity || p_213487_0_ instanceof HyperodapedonEntity || p_213487_0_ instanceof ProtoceratopsEntity || p_213487_0_ instanceof TelmasaurusEntity || p_213487_0_ instanceof ThescelosaurusEntity || p_213487_0_ instanceof VelociraptorEntity || p_213487_0_ instanceof CatEntity || p_213487_0_ instanceof OcelotEntity || p_213487_0_ instanceof ChickenEntity || p_213487_0_ instanceof CowEntity || p_213487_0_ instanceof AbstractHorseEntity || p_213487_0_ instanceof FoxEntity || p_213487_0_ instanceof MooshroomEntity || p_213487_0_ instanceof PigEntity || p_213487_0_ instanceof ParrotEntity || p_213487_0_ instanceof RabbitEntity || p_213487_0_ instanceof AbstractVillagerEntity || p_213487_0_ instanceof WanderingTraderEntity || p_213487_0_ instanceof AbstractIllagerEntity || p_213487_0_ instanceof PlayerEntity || p_213487_0_ instanceof LlamaEntity || p_213487_0_ instanceof TurtleEntity || p_213487_0_ instanceof SarahsaurusEntity || p_213487_0_ instanceof ScelidosaurusEntity || p_213487_0_ instanceof MegapnosaurusEntity || p_213487_0_ instanceof KayentatheriumEntity || p_213487_0_ instanceof ScutellosaurusEntity || p_213487_0_ instanceof SheepEntity || p_213487_0_ instanceof CoelophysisEntity || p_213487_0_ instanceof DesmatosuchusEntity || p_213487_0_ instanceof PlaceriasEntity || p_213487_0_ instanceof TypothoraxEntity || p_213487_0_ instanceof TrilophosaurusEntity;
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, true, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof DidelphodonEntity || p_213487_1_ instanceof EilenodonEntity || p_213487_1_ instanceof HyperodapedonEntity || p_213487_1_ instanceof TelmasaurusEntity || p_213487_1_ instanceof RabbitEntity || p_213487_1_ instanceof ChickenEntity || p_213487_1_ instanceof HesperornithoidesEntity || p_213487_1_ instanceof ScutellosaurusEntity;
		}));
	}

	public void livingTick() {
		super.livingTick();
		if (this.isChild() && !this.isJuvenile()) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(25.0D);
		} else if (this.isJuvenile()) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(50.0D);
		} else {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(100.0D);
		}
		if (this.isAsleep()) {
			this.navigator.setSpeed(0);;
		}
		if (!this.isAIDisabled()) {
			List<TyrannosaurusEntity> list = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(20.0D, 20.0D, 20.0D));
			if (PrehistoricFaunaConfig.advancedHunger) {
				hungerTick++;
				if (hungerTick == 600 && !this.isChild() || hungerTick == 300 && this.isChild() && !this.isJuvenile() || hungerTick == 450 && this.isJuvenile()) {
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
					if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && ticksExisted % 900 == 0 && !this.isChild() && !this.isInLove() && !this.isAsleep() && list.size() < 3) {
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
				if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isChild() && !this.isInLove() && !this.isAsleep() && list.size() < 3) {
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
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 100.0D).createMutableAttribute(Attributes.FOLLOW_RANGE, 35.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 14.0D).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.75D);
	}

	@Override
	public void setGrowingAge(int age) {
		super.setGrowingAge(age);
		if (this.getGrowingAge() >= -12000 && this.getGrowingAge() < 0) {
			this.setJuvenile(true);
		} else if(this.getGrowingAge() >= 0) {
			this.setJuvenile(false);
		}
	}

	protected SoundEvent getAmbientSound() {
		if (this.isAsleep() ) {
			if (!this.isChild()) {
				return SoundInit.TYRANNOSAURUS_SNORES;
			} else return null;
		} else return SoundInit.TYRANNOSAURUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.TYRANNOSAURUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.TYRANNOSAURUS_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundInit.TYRANNOSAURUS_WARN, 1.0F, this.getSoundPitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(IS_JUVENILE, false);
		this.dataManager.register(ALBINO, false);
		this.dataManager.register(MELANISTIC, false);
		this.dataManager.register(NATURAL_LOVE, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("inNaturalLove", this.isInLoveNaturally());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
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
		TyrannosaurusEntity tyrannosaurus;
		public AttackPlayerGoal(TyrannosaurusEntity tyrannosaurus) {
			super(TyrannosaurusEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
			this.tyrannosaurus = tyrannosaurus;
		}

		public boolean shouldExecute() {
			if (TyrannosaurusEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for(TyrannosaurusEntity tyrannosaurus : TyrannosaurusEntity.this.world.getEntitiesWithinAABB(TyrannosaurusEntity.class, TyrannosaurusEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
						if (tyrannosaurus.isChild()) {
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
			super(TyrannosaurusEntity.this);
		}

		public void startExecuting() {
			super.startExecuting();
			if (TyrannosaurusEntity.this.isChild()) {
				this.alertOthers();
				this.resetTask();
			}

		}

		protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
			if (mobIn instanceof TyrannosaurusEntity && !mobIn.isChild()) {
				super.setAttackTarget(mobIn, targetIn);
			}

		}
	}

	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(TyrannosaurusEntity.this, 1.25D, true);
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.func_234040_h_()) {
				this.func_234039_g_();
				TyrannosaurusEntity.this.playSound(SoundInit.TYRANNOSAURUS_BITE, 1.0F, TyrannosaurusEntity.this.getSoundPitch());
				this.attacker.attackEntityAsMob(enemy);
			} else if (distToEnemySqr <= d0 * 2.0D) {
				if (this.func_234040_h_()) {
					this.func_234039_g_();
				}

				if (this.func_234041_j_() <= 10) {
					TyrannosaurusEntity.this.playWarningSound();
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
			return (double)(15.0F + attackTarget.getWidth());
		}
	}

	class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(TyrannosaurusEntity.this, 2.0D);
		}

		public boolean shouldExecute() {
			if (!TyrannosaurusEntity.this.isChild() && !TyrannosaurusEntity.this.isBurning()) {
				return false;
			} else if (TyrannosaurusEntity.this.isJuvenile() && !TyrannosaurusEntity.this.isBurning()) {
				return false;
			} else {
				return super.shouldExecute();
			}
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final TyrannosaurusEntity tyrannosaurus;

		LayEggGoal(TyrannosaurusEntity tyrannosaurus, double speedIn) {
			super(tyrannosaurus, speedIn, 16);
			this.tyrannosaurus = tyrannosaurus;
		}

		public boolean shouldExecute() {
			return this.tyrannosaurus.hasEgg() ? super.shouldExecute() : false;
		}

		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && this.tyrannosaurus.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.tyrannosaurus.getPositionVec());
			if (!this.tyrannosaurus.isInWater() && this.getIsAboveDestination()) {
				if (this.tyrannosaurus.isDigging < 1) {
					this.tyrannosaurus.setDigging(true);
				} else if (this.tyrannosaurus.isDigging > 200) {
					World world = this.tyrannosaurus.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.TYRANNOSAURUS_EGG.getDefaultState().with(DinosaurEggBlock.EGGS, Integer.valueOf(this.tyrannosaurus.rand.nextInt(4) + 1)), 3);
					this.tyrannosaurus.setHasEgg(false);
					this.tyrannosaurus.setDigging(false);
					this.tyrannosaurus.setInLove(600);
				}

				if (this.tyrannosaurus.isDigging()) {
					this.tyrannosaurus.isDigging++;
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
		private final TyrannosaurusEntity tyrannosaurus;

		MateGoal(TyrannosaurusEntity tyrannosaurus, double speedIn) {
			super(tyrannosaurus, speedIn);
			this.tyrannosaurus = tyrannosaurus;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.tyrannosaurus.hasEgg() && !this.tyrannosaurus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			ServerPlayerEntity serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.targetMate.getLoveCause() != null) {
				serverplayerentity = this.targetMate.getLoveCause();
			}

			if (serverplayerentity != null) {
				serverplayerentity.addStat(Stats.ANIMALS_BRED);
			}

			this.tyrannosaurus.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}

		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final TyrannosaurusEntity tyrannosaurus;

		NaturalMateGoal(TyrannosaurusEntity tyrannosaurus, double speed) {
			super(tyrannosaurus, speed);
			this.tyrannosaurus = tyrannosaurus;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.tyrannosaurus.hasEgg() && this.tyrannosaurus.getCurrentHunger() >= this.tyrannosaurus.getThreeQuartersHunger() && this.tyrannosaurus.ticksExisted % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.tyrannosaurus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.tyrannosaurus.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.tyrannosaurus.rand.nextFloat() - this.tyrannosaurus.rand.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.tyrannosaurus.rand.nextInt(4);
				if (eggAmount == 0) {
					this.tyrannosaurus.entityDropItem(PFBlocks.TYRANNOSAURUS_EGG.asItem());
				}
				if (eggAmount == 1) {
					this.tyrannosaurus.entityDropItem(PFBlocks.TYRANNOSAURUS_EGG.asItem());
					this.tyrannosaurus.entityDropItem(PFBlocks.TYRANNOSAURUS_EGG.asItem());
				}
				if (eggAmount == 2) {
					this.tyrannosaurus.entityDropItem(PFBlocks.TYRANNOSAURUS_EGG.asItem());
					this.tyrannosaurus.entityDropItem(PFBlocks.TYRANNOSAURUS_EGG.asItem());
					this.tyrannosaurus.entityDropItem(PFBlocks.TYRANNOSAURUS_EGG.asItem());
				}
				if (eggAmount == 3) {
					this.tyrannosaurus.entityDropItem(PFBlocks.TYRANNOSAURUS_EGG.asItem());
					this.tyrannosaurus.entityDropItem(PFBlocks.TYRANNOSAURUS_EGG.asItem());
					this.tyrannosaurus.entityDropItem(PFBlocks.TYRANNOSAURUS_EGG.asItem());
					this.tyrannosaurus.entityDropItem(PFBlocks.TYRANNOSAURUS_EGG.asItem());
				}
			} else {
				this.tyrannosaurus.setHasEgg(true);
			}
			this.animal.resetInLove();
			this.targetMate.resetInLove();
		}

	}

	class TyrannosaurusFollowParentGoal extends Goal {
		private final TyrannosaurusEntity babyTyrannosaurusEntity;
		private TyrannosaurusEntity parentTyrannosaurusEntity;
		private final double moveSpeed;
		private int delayCounter;

		public TyrannosaurusFollowParentGoal(TyrannosaurusEntity tyrannosaurus, double speed) {
			this.babyTyrannosaurusEntity = tyrannosaurus;
			this.moveSpeed = speed;
		}

		public boolean shouldExecute() {
			if (this.babyTyrannosaurusEntity.isChild() && !this.babyTyrannosaurusEntity.isJuvenile()) {
				List<TyrannosaurusEntity> list = this.babyTyrannosaurusEntity.world.getEntitiesWithinAABB(this.babyTyrannosaurusEntity.getClass(), this.babyTyrannosaurusEntity.getBoundingBox().grow(8.0D, 4.0D, 8.0D));
				TyrannosaurusEntity tyrannosaurusEntity = null;
				double d0 = Double.MAX_VALUE;
				for (TyrannosaurusEntity tyrannosaurusEntity1 : list) {
					if (!tyrannosaurusEntity1.isChild()) {
						double d1 = this.babyTyrannosaurusEntity.getDistanceSq(tyrannosaurusEntity1);
						if (!(d1 > d0)) {
							d0 = d1;
							tyrannosaurusEntity = tyrannosaurusEntity1;
						}
					}
				}
				if (tyrannosaurusEntity == null) {
					return false;
				} else if (d0 < 9.0D) {
					return false;
				} else {
					this.parentTyrannosaurusEntity = tyrannosaurusEntity;
					return true;
				}
			} else {
				return false;
			}
		}

		public boolean shouldContinueExecuting() {
			if (!this.babyTyrannosaurusEntity.isJuvenile() || !this.babyTyrannosaurusEntity.isChild()) {
				return false;
			} else if (!this.parentTyrannosaurusEntity.isAlive()) {
				return false;
			} else  if(this.babyTyrannosaurusEntity.isChild() && !this.babyTyrannosaurusEntity.isJuvenile()){
				double d0 = this.babyTyrannosaurusEntity.getDistanceSq(this.parentTyrannosaurusEntity);
				return !(d0 < 9.0D) && !(d0 > 256.0D);
			} else {
				return false;
			}
		}

		public void startExecuting() {
			this.delayCounter = 0;
		}

		public void resetTask() {
			this.parentTyrannosaurusEntity = null;
		}

		public void tick() {
			if (--this.delayCounter <= 0) {
				this.delayCounter = 10;
				this.babyTyrannosaurusEntity.getNavigator().tryMoveToEntityLiving(this.parentTyrannosaurusEntity, this.moveSpeed);
			}
		}
	}

	class TerritoryAttackGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public TerritoryAttackGoal() {
			super(TyrannosaurusEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			if (TyrannosaurusEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for(@SuppressWarnings("unused") TyrannosaurusEntity tyrannosaurus : TyrannosaurusEntity.this.world.getEntitiesWithinAABB(TyrannosaurusEntity.class, TyrannosaurusEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
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

	class JuvenileHuntGoal extends HuntGoal {

		private TyrannosaurusEntity tyrannosaurus;

		@SuppressWarnings("rawtypes")
		public JuvenileHuntGoal(MobEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, Predicate targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnlyIn, targetPredicate);
			this.tyrannosaurus = (TyrannosaurusEntity) goalOwnerIn;
		}

		public boolean shouldExecute() {
			if (super.shouldExecute() && tyrannosaurus.isJuvenile()) {
				return true;
			} else {
				return false;
			}
		}

	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		TyrannosaurusEntity entity = new TyrannosaurusEntity(PFEntities.TYRANNOSAURUS_ENTITY, this.world);
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
			return super.shouldExecute() && TyrannosaurusEntity.this.getCurrentHunger() <= TyrannosaurusEntity.this.getHalfHunger() && !TyrannosaurusEntity.this.isChild() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public boolean shouldContinueExecuting() {
			return TyrannosaurusEntity.this.getCurrentHunger() > TyrannosaurusEntity.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			LivingEntity target = TyrannosaurusEntity.this.getAttackTarget();
			if (target instanceof CatEntity || target instanceof FoxEntity || target instanceof CowEntity || target instanceof MooshroomEntity || target instanceof PigEntity || target instanceof OcelotEntity || target instanceof AepyornithomimusEntity || target instanceof ProtoceratopsEntity || target instanceof CoelophysisEntity || target instanceof TrilophosaurusEntity || target instanceof TypothoraxEntity) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 10 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 10);
					}
				}
			}
			if (target instanceof DryosaurusEntity || target instanceof ThescelosaurusEntity || target instanceof SarahsaurusEntity || target instanceof ScelidosaurusEntity  || target instanceof CitipatiEntity) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 15 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 15);
					}
				}
			}
			if (target instanceof SaurosuchusEntity || target instanceof DesmatosuchusEntity || target instanceof AbstractHorseEntity || target instanceof HerrerasaurusEntity|| target instanceof PlaceriasEntity  || target instanceof WanderingTraderEntity || target instanceof PlayerEntity || target instanceof AbstractVillagerEntity || target instanceof AbstractIllagerEntity || target instanceof LlamaEntity || target instanceof PandaEntity|| target instanceof PoposaurusEntity) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 20 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 20);
					}
				}
			}
			if (target instanceof DakotaraptorEntity || target instanceof PolarBearEntity || target instanceof TurtleEntity || target instanceof DilophosaurusEntity) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 30 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 30);
					}
				}
			}
			if (target instanceof IschigualastiaEntity || target instanceof PinacosaurusEntity || target instanceof PlesiohadrosEntity || target instanceof CeratosaurusEntity ) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 40 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 40);
					}
				}
			}
			if (target instanceof AnkylosaurusEntity || target instanceof SillosuchusEntity || target instanceof StegosaurusEntity || target instanceof TriceratopsEntity || target instanceof AllosaurusEntity) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 60 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 60);
					}
				}
			}
			super.tick();
		}

	}

	@SuppressWarnings("rawtypes")
	public class JuvenileCarnivoreHuntGoal extends NearestAttackableTargetGoal {

		@SuppressWarnings("unchecked")
		public JuvenileCarnivoreHuntGoal(MobEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && TyrannosaurusEntity.this.getCurrentHunger() <= TyrannosaurusEntity.this.getHalfHunger() && TyrannosaurusEntity.this.isJuvenile() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public boolean shouldContinueExecuting() {
			return TyrannosaurusEntity.this.getCurrentHunger() > TyrannosaurusEntity.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true || !TyrannosaurusEntity.this.isJuvenile() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			LivingEntity target = TyrannosaurusEntity.this.getAttackTarget();
			if (target instanceof RabbitEntity) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 3 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof DidelphodonEntity || target instanceof EilenodonEntity || target instanceof HesperornithoidesEntity || target instanceof HyperodapedonEntity || target instanceof ChickenEntity || target instanceof ScutellosaurusEntity) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 4 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof ChromogisaurusEntity || target instanceof TelmasaurusEntity || target instanceof ParrotEntity || target instanceof KayentatheriumEntity || target instanceof MegapnosaurusEntity) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 6 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 6);
					}
				}
			}
			if (target instanceof BasilemysEntity || target instanceof ExaeretodonEntity || target instanceof VelociraptorEntity || target instanceof WolfEntity || target instanceof SheepEntity) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 8 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 8);
					}
				}
			}
			if (target instanceof CatEntity || target instanceof FoxEntity || target instanceof CowEntity || target instanceof MooshroomEntity || target instanceof PigEntity || target instanceof OcelotEntity || target instanceof AepyornithomimusEntity || target instanceof ProtoceratopsEntity || target instanceof CoelophysisEntity || target instanceof TrilophosaurusEntity || target instanceof TypothoraxEntity) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 10 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 10);
					}
				}
			}
			if (target instanceof CitipatiEntity || target instanceof ThescelosaurusEntity || target instanceof SarahsaurusEntity || target instanceof ScelidosaurusEntity || target instanceof DryosaurusEntity ) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 15 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 15);
					}
				}
			}
			if (target instanceof AbstractHorseEntity || target instanceof PlaceriasEntity || target instanceof HerrerasaurusEntity || target instanceof DesmatosuchusEntity || target instanceof WanderingTraderEntity || target instanceof PlayerEntity || target instanceof AbstractVillagerEntity || target instanceof AbstractIllagerEntity || target instanceof LlamaEntity) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 20 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 20);
					}
				}
			}
			if (target instanceof TurtleEntity) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 30 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 30);
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
			return super.shouldExecute() && TyrannosaurusEntity.this.getCurrentHunger() <= TyrannosaurusEntity.this.getHalfHunger() && TyrannosaurusEntity.this.isChild() && !TyrannosaurusEntity.this.isJuvenile() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public boolean shouldContinueExecuting() {
			return TyrannosaurusEntity.this.getCurrentHunger() > TyrannosaurusEntity.this.maxHunger && PrehistoricFaunaConfig.advancedHunger == true || TyrannosaurusEntity.this.isJuvenile() && PrehistoricFaunaConfig.advancedHunger == true;
		}

		public void tick() {
			LivingEntity target = TyrannosaurusEntity.this.getAttackTarget();
			if (target instanceof RabbitEntity) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 3 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof DidelphodonEntity || target instanceof EilenodonEntity || target instanceof HyperodapedonEntity || target instanceof ChickenEntity || target instanceof HesperornithoidesEntity || target instanceof ScutellosaurusEntity) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 4 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof TelmasaurusEntity) {
				if (target.getHealth() == 0) {
					if (TyrannosaurusEntity.this.getCurrentHunger() + 6 >= TyrannosaurusEntity.this.maxHunger) {
						TyrannosaurusEntity.this.setHunger(TyrannosaurusEntity.this.maxHunger);
					} else {
						TyrannosaurusEntity.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}


}