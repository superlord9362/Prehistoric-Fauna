package superlord.prehistoricfauna.common.entities.jurassic.kayenta;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
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
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.BreatheAirGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.pathfinding.WalkAndSwimNodeProcessor;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.Tags;
import superlord.prehistoricfauna.common.blocks.DilophosaurusEggBlock;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.AepyornithomimusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.ProtoceratopsEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.TelmasaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.VelociraptorEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.BasilemysEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DidelphodonEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.ThescelosaurusEntity;
import superlord.prehistoricfauna.common.entities.fish.ArganodusEntity;
import superlord.prehistoricfauna.common.entities.fish.CeratodusEntity;
import superlord.prehistoricfauna.common.entities.fish.ChinleaEntity;
import superlord.prehistoricfauna.common.entities.fish.CyclurusEntity;
import superlord.prehistoricfauna.common.entities.fish.MooreodontusEntity;
import superlord.prehistoricfauna.common.entities.fish.MyledaphusEntity;
import superlord.prehistoricfauna.common.entities.fish.PotamoceratodusEntity;
import superlord.prehistoricfauna.common.entities.fish.SaurichthysEntity;
import superlord.prehistoricfauna.common.entities.goal.CrepuscularSleepGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entities.goal.HuntGoal;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.DryosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.EilenodonEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.HesperornithoidesEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ChromogisaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ExaeretodonEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HyperodapedonEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.SoundInit;

public class CalsoyasuchusEntity extends DinosaurEntity {
	
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(CalsoyasuchusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(CalsoyasuchusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(CalsoyasuchusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(CalsoyasuchusEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> NATURAL_LOVE = EntityDataManager.createKey(CalsoyasuchusEntity.class, DataSerializers.BOOLEAN);
	private int maxHunger = 15;
	private int currentHunger;
	int hungerTick = 0;
	private int lastInLove = 0;
	private int warningSoundTicks;
	private int isDigging;
	int loveTick = 0;

	public CalsoyasuchusEntity(EntityType<? extends TameableEntity> type, World worldIn) {
		super(type, worldIn);
		this.moveController = new CalsoyasuchusEntity.MoveHelperController(this);
		this.stepHeight = 1.0F;
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

	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		Random rand = new Random();
		int birthNumber = rand.nextInt(799);
		if (birthNumber >= 0 && birthNumber < 4) {
			this.setAlbino(true);
		} else if (birthNumber >= 4 && birthNumber < 7) {
			this.setMelanistic(true);
		}
		this.setHunger(50);
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}
	
	public int getMaxAir() {
		return 4800;
	}

	protected int determineNextAir(int currentAir) {
		return this.getMaxAir();
	}
	
	protected float getWaterSlowDown() {
		return 1.1F;
	}

	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == PFItems.CERATODUS.get();
	}
	
	class WalkAndSwimPathNavigator extends SwimmerPathNavigator {
		
		WalkAndSwimPathNavigator(CalsoyasuchusEntity calsoyasuchus, World world) {
			super(calsoyasuchus, world);
		}
		
		protected boolean canNavigate() {
			return true;
		}
		
		protected PathFinder getPathFinder(int uncategorizedNumber) {
			this.nodeProcessor = new WalkAndSwimNodeProcessor();
			return new PathFinder(this.nodeProcessor, uncategorizedNumber);
		}
		
		@SuppressWarnings("deprecation")
		public boolean canEntityStandOnPos(BlockPos pos) {
			return !this.world.getBlockState(pos.down()).isAir();
		}
		
	}
	
	static class MoveHelperController extends MovementController {
		private final CalsoyasuchusEntity calsoyasuchus;
		
		MoveHelperController(CalsoyasuchusEntity calsoyasuchus) {
			super(calsoyasuchus);
			this.calsoyasuchus = calsoyasuchus;
		}
		
		public void tick() {
			if (this.calsoyasuchus.areEyesInFluid(FluidTags.WATER)) {
				this.calsoyasuchus.setMotion(this.calsoyasuchus.getMotion().add(0.0D, 0.005D, 0.0D));
			}
			if (this.action == MovementController.Action.MOVE_TO && !this.calsoyasuchus.getNavigator().noPath()) {
				float f = (float)(this.speed * this.calsoyasuchus.getAttributeValue(Attributes.MOVEMENT_SPEED));
				this.calsoyasuchus.setAIMoveSpeed(MathHelper.lerp(0.125F, this.calsoyasuchus.getAIMoveSpeed(), f));
				double d0 = this.posX - this.calsoyasuchus.getPosX();
				double d1 = this.posY - this.calsoyasuchus.getPosY();
				double d2 = this.posZ - this.calsoyasuchus.getPosZ();
				if (d1 != 0.0D) {
					double d3 = (double)MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
					this.calsoyasuchus.setMotion(this.calsoyasuchus.getMotion().add(0.0D, (double)this.calsoyasuchus.getAIMoveSpeed() * (d1 / d3) * 0.1D, 0.0D));
				}
				if (d0 != 0.0D || d2 != 0.0D) {
					float f1 = (float)(MathHelper.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
					this.calsoyasuchus.rotationYaw = this.limitAngle(this.calsoyasuchus.rotationYaw, f1, 90.0F);
					this.calsoyasuchus.renderYawOffset = this.calsoyasuchus.rotationYaw;
				}
			} else {
				this.calsoyasuchus.setAIMoveSpeed(0.0F);
			}
		}
		
	}
	
	protected PathNavigator createNavigator(World world) {
		return new CalsoyasuchusEntity.WalkAndSwimPathNavigator(this, world);
	}
	
	protected boolean func_212800_dy() {
		return true;
	}
	
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new CrepuscularSleepGoal(this));
		this.goalSelector.addGoal(1, new CalsoyasuchusEntity.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new CalsoyasuchusEntity.PanicGoal());
		this.targetSelector.addGoal(1, new CalsoyasuchusEntity.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new CalsoyasuchusEntity.AttackPlayerGoal());
		this.targetSelector.addGoal(2, new CalsoyasuchusEntity.TerritoryAttackGoal());
		this.goalSelector.addGoal(0, new CalsoyasuchusEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new CalsoyasuchusEntity.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(0, new CalsoyasuchusEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new BreatheAirGoal(this));
		this.goalSelector.addGoal(3, new CalsoyasuchusEntity.SwimGoal(this));
		this.goalSelector.addGoal(0, new CalsoyasuchusEntity.CarnivoreHuntGoal(this, LivingEntity.class, 10, false, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof RabbitEntity || p_213487_1_ instanceof HyperodapedonEntity || p_213487_1_ instanceof HesperornithoidesEntity || p_213487_1_ instanceof EilenodonEntity || p_213487_1_ instanceof ScutellosaurusEntity || p_213487_1_ instanceof ChickenEntity || p_213487_1_ instanceof BasilemysEntity || p_213487_1_ instanceof ChromogisaurusEntity || p_213487_1_ instanceof ExaeretodonEntity || p_213487_1_ instanceof TelmasaurusEntity || p_213487_1_ instanceof KayentatheriumEntity || p_213487_1_ instanceof MegapnosaurusEntity || p_213487_1_ instanceof VelociraptorEntity || p_213487_1_ instanceof WolfEntity || p_213487_1_ instanceof ArganodusEntity || p_213487_1_ instanceof CeratodusEntity || p_213487_1_ instanceof ChinleaEntity || p_213487_1_ instanceof CyclurusEntity || p_213487_1_ instanceof MooreodontusEntity || p_213487_1_ instanceof MyledaphusEntity || p_213487_1_ instanceof PotamoceratodusEntity || p_213487_1_ instanceof SaurichthysEntity || p_213487_1_ instanceof CatEntity || p_213487_1_ instanceof FoxEntity || p_213487_1_ instanceof CowEntity || p_213487_1_ instanceof MooshroomEntity || p_213487_1_ instanceof PigEntity || p_213487_1_ instanceof OcelotEntity || p_213487_1_ instanceof AepyornithomimusEntity || p_213487_1_ instanceof DryosaurusEntity || p_213487_1_ instanceof ProtoceratopsEntity || p_213487_1_ instanceof ThescelosaurusEntity || p_213487_1_ instanceof SarahsaurusEntity;
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, true, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof DidelphodonEntity || p_213487_1_ instanceof EilenodonEntity || p_213487_1_ instanceof HyperodapedonEntity || p_213487_1_ instanceof TelmasaurusEntity || p_213487_1_ instanceof RabbitEntity || p_213487_1_ instanceof ChickenEntity || p_213487_1_ instanceof HesperornithoidesEntity || p_213487_1_ instanceof ScutellosaurusEntity;
		}));
		this.targetSelector.addGoal(1, new HuntGoal(this, AnimalEntity.class, 10, false, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof RabbitEntity || p_213487_1_ instanceof HyperodapedonEntity || p_213487_1_ instanceof HesperornithoidesEntity || p_213487_1_ instanceof EilenodonEntity || p_213487_1_ instanceof ScutellosaurusEntity || p_213487_1_ instanceof ChickenEntity || p_213487_1_ instanceof BasilemysEntity || p_213487_1_ instanceof ChromogisaurusEntity || p_213487_1_ instanceof ExaeretodonEntity || p_213487_1_ instanceof TelmasaurusEntity || p_213487_1_ instanceof KayentatheriumEntity || p_213487_1_ instanceof MegapnosaurusEntity || p_213487_1_ instanceof VelociraptorEntity || p_213487_1_ instanceof WolfEntity || p_213487_1_ instanceof ArganodusEntity || p_213487_1_ instanceof CeratodusEntity || p_213487_1_ instanceof ChinleaEntity || p_213487_1_ instanceof CyclurusEntity || p_213487_1_ instanceof MooreodontusEntity || p_213487_1_ instanceof MyledaphusEntity || p_213487_1_ instanceof PotamoceratodusEntity || p_213487_1_ instanceof SaurichthysEntity || p_213487_1_ instanceof CatEntity || p_213487_1_ instanceof FoxEntity || p_213487_1_ instanceof CowEntity || p_213487_1_ instanceof MooshroomEntity || p_213487_1_ instanceof PigEntity || p_213487_1_ instanceof OcelotEntity || p_213487_1_ instanceof AepyornithomimusEntity || p_213487_1_ instanceof DryosaurusEntity || p_213487_1_ instanceof ProtoceratopsEntity || p_213487_1_ instanceof ThescelosaurusEntity || p_213487_1_ instanceof SarahsaurusEntity;
		}));
	}
	
	public void livingTick() {
		super.livingTick();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		}
		List<CalsoyasuchusEntity> list = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(20.0D, 20.0D, 20.0D));
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
	
	public static boolean canDinosaurSpawn(EntityType<? extends AnimalEntity> animal, IWorld worldIn, SpawnReason reason, BlockPos pos, Random random) {
		return (worldIn.getBlockState(pos.down()).isIn(Tags.Blocks.DIRT) || worldIn.getBlockState(pos).isIn(Blocks.WATER) || worldIn.getBlockState(pos.down()).isIn(Tags.Blocks.SAND)) && worldIn.getLightSubtracted(pos, 0) > 8;
	}
	
	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 6.0D).createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : SoundInit.CALSOYASUCHUS_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.CALSOYASUCHUS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.CALSOYASUCHUS_DEATH;
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
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.setHunger(compound.getInt("MaxHunger"));
		this.setInLoveNaturally(compound.getBoolean("InNaturalLove"));
	}

	public void tick() {
		super.tick();
		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}
	}

	public boolean attackEntityAsMob(Entity entity) {
		boolean flag = super.attackEntityAsMob(entity);
		if (flag) {
			this.applyEnchantments(this, entity);
		}
		return flag;
	}

	class AttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public AttackPlayerGoal() {
			super(CalsoyasuchusEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean shouldExecute() {
			if (CalsoyasuchusEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for (@SuppressWarnings("unused") CalsoyasuchusEntity calsoyasuchus : CalsoyasuchusEntity.this.world.getEntitiesWithinAABB(CalsoyasuchusEntity.class, CalsoyasuchusEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {	
						if (CalsoyasuchusEntity.this.isChild()) {
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
	
	class TerritoryAttackGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public TerritoryAttackGoal() {
			super(CalsoyasuchusEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			if (CalsoyasuchusEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for(@SuppressWarnings("unused") CalsoyasuchusEntity calsoyasuchus : CalsoyasuchusEntity.this.world.getEntitiesWithinAABB(CalsoyasuchusEntity.class, CalsoyasuchusEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
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

	class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(CalsoyasuchusEntity.this);
		}

		public void startExecuting() {
			super.startExecuting();
			if(CalsoyasuchusEntity.this.isChild()) {
				this.alertOthers();
				this.resetTask();
			}
		}

		protected void setAttackTarget(MobEntity entity, LivingEntity target) {
			if (entity instanceof CalsoyasuchusEntity && !entity.isChild()) {
				super.setAttackTarget(entity, target);
			}
		}

	}

	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(CalsoyasuchusEntity.this, 1.25D, true);
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
					CalsoyasuchusEntity.this.playWarningSound();
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
			super(CalsoyasuchusEntity.this, 2.0D);
		}

		public boolean shouldExecute() {
			return !CalsoyasuchusEntity.this.isChild() && !CalsoyasuchusEntity.this.isBurning() ? false : super.shouldExecute();
		}

	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final CalsoyasuchusEntity calsoyasuchus;

		LayEggGoal(CalsoyasuchusEntity calsoyasuchus, double speed) {
			super(calsoyasuchus, speed, 16);
			this.calsoyasuchus = calsoyasuchus;
		}

		public boolean shouldExecute() {
			return this.calsoyasuchus.hasEgg() ? super.shouldExecute() : false;
		}

		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && calsoyasuchus.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.calsoyasuchus.getPositionVec());
			if (!this.calsoyasuchus.isInWater() && this.getIsAboveDestination()) {
				if (this.calsoyasuchus.isDigging < 1) {
					this.calsoyasuchus.setDigging(true);
				} else if (this.calsoyasuchus.isDigging > 200) {
					World world = this.calsoyasuchus.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.CALSOYASUCHUS_EGG.getDefaultState().with(DilophosaurusEggBlock.EGGS, Integer.valueOf(this.calsoyasuchus.rand.nextInt(4) + 1)), 3);
					this.calsoyasuchus.setHasEgg(false);
					this.calsoyasuchus.setDigging(false);
					this.calsoyasuchus.setInLove(600);
				}
				if (this.calsoyasuchus.isDigging()) {
					this.calsoyasuchus.isDigging++;
				}
			}
		}

		public boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
			if (!worldIn.isAirBlock(pos.up())) {
				return false;
			} else {
				Block block = worldIn.getBlockState(pos).getBlock();
				return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.MYCELIUM || block == Blocks.SAND || block == Blocks.RED_SAND || block == PFBlocks.MOSSY_DIRT || block == PFBlocks.MOSS_BLOCK || block == PFBlocks.LOAM || block == PFBlocks.PACKED_LOAM || block == PFBlocks.SILT || block == PFBlocks.PACKED_LOAM || block == BlockTags.LEAVES;
			}
		}

	}

	static class MateGoal extends BreedGoal {
		private final CalsoyasuchusEntity calsoyasuchus;

		MateGoal(CalsoyasuchusEntity calsoyasuchus, double speed) {
			super(calsoyasuchus, speed);
			this.calsoyasuchus = calsoyasuchus;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.calsoyasuchus.hasEgg() && !this.calsoyasuchus.isInLoveNaturally();
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
			this.calsoyasuchus.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}

	}
	
	static class NaturalMateGoal extends BreedGoal {
		private final CalsoyasuchusEntity calsoyasuchus;

		NaturalMateGoal(CalsoyasuchusEntity calsoyasuchus, double speed) {
			super(calsoyasuchus, speed);
			this.calsoyasuchus = calsoyasuchus;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.calsoyasuchus.hasEgg() && this.calsoyasuchus.getCurrentHunger() >= this.calsoyasuchus.getThreeQuartersHunger() && this.calsoyasuchus.ticksExisted % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.calsoyasuchus.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.calsoyasuchus.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.calsoyasuchus.rand.nextFloat() - this.calsoyasuchus.rand.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.calsoyasuchus.rand.nextInt(4);
				if (eggAmount == 0) {
					this.calsoyasuchus.entityDropItem(PFBlocks.CALSOYASUCHUS_EGG.asItem());
				}
				if (eggAmount == 1) {
					this.calsoyasuchus.entityDropItem(PFBlocks.CALSOYASUCHUS_EGG.asItem());
					this.calsoyasuchus.entityDropItem(PFBlocks.CALSOYASUCHUS_EGG.asItem());
				}
				if (eggAmount == 2) {
					this.calsoyasuchus.entityDropItem(PFBlocks.CALSOYASUCHUS_EGG.asItem());
					this.calsoyasuchus.entityDropItem(PFBlocks.CALSOYASUCHUS_EGG.asItem());
					this.calsoyasuchus.entityDropItem(PFBlocks.CALSOYASUCHUS_EGG.asItem());
				}
				if (eggAmount == 3) {
					this.calsoyasuchus.entityDropItem(PFBlocks.CALSOYASUCHUS_EGG.asItem());
					this.calsoyasuchus.entityDropItem(PFBlocks.CALSOYASUCHUS_EGG.asItem());
					this.calsoyasuchus.entityDropItem(PFBlocks.CALSOYASUCHUS_EGG.asItem());
					this.calsoyasuchus.entityDropItem(PFBlocks.CALSOYASUCHUS_EGG.asItem());
				}
			} else {
				this.calsoyasuchus.setHasEgg(true);
			}
			this.animal.resetInLove();
			this.targetMate.resetInLove();
		}

	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		CalsoyasuchusEntity entity = new CalsoyasuchusEntity(PFEntities.CALSOYASUCHUS_ENTITY, this.world);
		entity.onInitialSpawn((IServerWorld) this.world, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}
	
	static class SwimGoal extends RandomSwimmingGoal {
		private final CalsoyasuchusEntity calsoyasuchus;
		
		public SwimGoal(CalsoyasuchusEntity calsoyasuchus) {
			super(calsoyasuchus, 1.0D, 40);
			this.calsoyasuchus = calsoyasuchus;
		}
		
		public boolean shouldExecute() {
			return this.calsoyasuchus.func_212800_dy() && super.shouldExecute();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public class CarnivoreHuntGoal extends NearestAttackableTargetGoal {

		@SuppressWarnings({ "unchecked" })
		public CarnivoreHuntGoal(MobEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && CalsoyasuchusEntity.this.getCurrentHunger() <= CalsoyasuchusEntity.this.getHalfHunger() && !CalsoyasuchusEntity.this.isChild();
		}

		public boolean shouldContinueExecuting() {
			return CalsoyasuchusEntity.this.getCurrentHunger() < CalsoyasuchusEntity.this.maxHunger;
		}
		
		public void tick() {
			LivingEntity target = CalsoyasuchusEntity.this.getAttackTarget();
			if (target instanceof RabbitEntity || target instanceof ArganodusEntity || target instanceof CeratodusEntity || target instanceof ChinleaEntity || target instanceof CyclurusEntity || target instanceof MooreodontusEntity || target instanceof MyledaphusEntity || target instanceof PotamoceratodusEntity || target instanceof SaurichthysEntity) {
				if (target.getHealth() == 0) {
					if (CalsoyasuchusEntity.this.getCurrentHunger() + 3 >= CalsoyasuchusEntity.this.maxHunger) {
						CalsoyasuchusEntity.this.setHunger(CalsoyasuchusEntity.this.maxHunger);
					} else {
						CalsoyasuchusEntity.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof HyperodapedonEntity || target instanceof HesperornithoidesEntity || target instanceof EilenodonEntity || target instanceof ScutellosaurusEntity || target instanceof ChickenEntity) {
				if (target.getHealth() == 0) {
					if (CalsoyasuchusEntity.this.getCurrentHunger() + 4 >= CalsoyasuchusEntity.this.maxHunger) {
						CalsoyasuchusEntity.this.setHunger(CalsoyasuchusEntity.this.maxHunger);
					} else {
						CalsoyasuchusEntity.this.setHunger(currentHunger + 6);
					}
				}
			}
			if (target instanceof BasilemysEntity || target instanceof ChromogisaurusEntity || target instanceof ExaeretodonEntity || target instanceof TelmasaurusEntity || target instanceof KayentatheriumEntity || target instanceof MegapnosaurusEntity) {
				if (target.getHealth() == 0) {
					if (CalsoyasuchusEntity.this.getCurrentHunger() + 6 >= CalsoyasuchusEntity.this.maxHunger) {
						CalsoyasuchusEntity.this.setHunger(CalsoyasuchusEntity.this.maxHunger);
					} else {
						CalsoyasuchusEntity.this.setHunger(currentHunger + 6);
					}
				}
			}
			if (target instanceof VelociraptorEntity || target instanceof WolfEntity) {
				if (target.getHealth() == 0) {
					if (CalsoyasuchusEntity.this.getCurrentHunger() + 8 >= CalsoyasuchusEntity.this.maxHunger) {
						CalsoyasuchusEntity.this.setHunger(CalsoyasuchusEntity.this.maxHunger);
					} else {
						CalsoyasuchusEntity.this.setHunger(currentHunger + 8);
					}
				}
			}
			if (target instanceof CatEntity || target instanceof FoxEntity || target instanceof CowEntity || target instanceof MooshroomEntity || target instanceof PigEntity || target instanceof OcelotEntity || target instanceof AepyornithomimusEntity || target instanceof DryosaurusEntity || target instanceof ProtoceratopsEntity || target instanceof ThescelosaurusEntity || target instanceof SarahsaurusEntity) {
				if (target.getHealth() == 0) {
					if (CalsoyasuchusEntity.this.getCurrentHunger() + 10 >= CalsoyasuchusEntity.this.maxHunger) {
						CalsoyasuchusEntity.this.setHunger(CalsoyasuchusEntity.this.maxHunger);
					} else {
						CalsoyasuchusEntity.this.setHunger(currentHunger + 10);
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
			return super.shouldExecute() && CalsoyasuchusEntity.this.getCurrentHunger() <= CalsoyasuchusEntity.this.getHalfHunger() && CalsoyasuchusEntity.this.isChild();
		}

		public boolean shouldContinueExecuting() {
			return CalsoyasuchusEntity.this.getCurrentHunger() < CalsoyasuchusEntity.this.maxHunger || !CalsoyasuchusEntity.this.isChild();
		}

		public void tick() {
			LivingEntity target = CalsoyasuchusEntity.this.getAttackTarget();
			if (target instanceof RabbitEntity) {
				if (target.getHealth() == 0) {
					if (CalsoyasuchusEntity.this.getCurrentHunger() + 3 >= CalsoyasuchusEntity.this.maxHunger) {
						CalsoyasuchusEntity.this.setHunger(CalsoyasuchusEntity.this.maxHunger);
					} else {
						CalsoyasuchusEntity.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof DidelphodonEntity || target instanceof EilenodonEntity || target instanceof HyperodapedonEntity || target instanceof ChickenEntity || target instanceof HesperornithoidesEntity || target instanceof ScutellosaurusEntity) {
				if (target.getHealth() == 0) {
					if (CalsoyasuchusEntity.this.getCurrentHunger() + 4 >= CalsoyasuchusEntity.this.maxHunger) {
						CalsoyasuchusEntity.this.setHunger(CalsoyasuchusEntity.this.maxHunger);
					} else {
						CalsoyasuchusEntity.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof TelmasaurusEntity) {
				if (target.getHealth() == 0) {
					if (CalsoyasuchusEntity.this.getCurrentHunger() + 6 >= CalsoyasuchusEntity.this.maxHunger) {
						CalsoyasuchusEntity.this.setHunger(CalsoyasuchusEntity.this.maxHunger);
					} else {
						CalsoyasuchusEntity.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}

}
