package superlord.prehistoricfauna.common.entities.cretaceous.djadochta;

import java.util.EnumSet;
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
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.ai.controller.LookController;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FleeSunGoal;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtByTargetGoal;
import net.minecraft.entity.ai.goal.OwnerHurtTargetGoal;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.merchant.villager.WanderingTraderEntity;
import net.minecraft.entity.monster.AbstractIllagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.passive.horse.MuleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.ClimberPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.blocks.VelociraptorEggBlock;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.AnkylosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.BasilemysEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DidelphodonEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.ThescelosaurusEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TriceratopsEntity;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TyrannosaurusEntity;
import superlord.prehistoricfauna.common.entities.goal.CrepuscularSleepGoal;
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
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CamarasaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CeratosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.DryosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.EilenodonEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.HesperornithoidesEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.StegosaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ChromogisaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ExaeretodonEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HyperodapedonEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.SoundInit;

public class VelociraptorEntity extends DinosaurEntity {
	private static final DataParameter<Byte> VELOCIRAPTOR_FLAGS = EntityDataManager.createKey(VelociraptorEntity.class, DataSerializers.BYTE);
	private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(VelociraptorEntity.class, DataSerializers.BYTE);
	private static final Predicate<Entity> IS_PREY = (p_213498_0_) -> {
		return p_213498_0_ instanceof ThescelosaurusEntity || p_213498_0_ instanceof BasilemysEntity || p_213498_0_ instanceof DryosaurusEntity || p_213498_0_ instanceof HesperornithoidesEntity || p_213498_0_ instanceof EilenodonEntity || p_213498_0_ instanceof DidelphodonEntity || p_213498_0_ instanceof HorseEntity || p_213498_0_ instanceof DonkeyEntity || p_213498_0_ instanceof MuleEntity || p_213498_0_ instanceof SheepEntity || p_213498_0_ instanceof CowEntity || p_213498_0_ instanceof PigEntity || p_213498_0_ instanceof OcelotEntity || p_213498_0_ instanceof ProtoceratopsEntity;
	};
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(VelociraptorEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(VelociraptorEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(VelociraptorEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(VelociraptorEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> NATURAL_LOVE = EntityDataManager.createKey(VelociraptorEntity.class, DataSerializers.BOOLEAN);
	private int currentHunger;
	private int maxHunger = 15;
	private int lastInLove = 0;
	int hungerTick = 0;
	private Goal attackAnimals;
	private float interestedAngle;
	private float interestedAngleO;
	private float crouchAmount;
	private float crouchAmountO;
	private int warningSoundTicks;
	private int isDigging;
	private int eatTicks;
	int loveTick = 0;

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
		return stack.getItem() == PFItems.RAW_SMALL_MARGINOCEPHALIAN_MEAT.get();
	}

	protected PathNavigator createNavigator(World worldIn) {
		return new ClimberPathNavigator(this, worldIn);
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

	public boolean isInLoveNaturally() {
		return this.dataManager.get(NATURAL_LOVE);
	}

	private void setInLoveNaturally(boolean isInLoveNaturally) {
		this.dataManager.set(NATURAL_LOVE, isInLoveNaturally);
	}

	public VelociraptorEntity(EntityType<? extends VelociraptorEntity> type, World worldIn) {
		super(type, worldIn);
		this.lookController = new VelociraptorEntity.LookHelperController();
		this.moveController = new VelociraptorEntity.MoveHelperController();
		this.setPathPriority(PathNodeType.DANGER_OTHER, 0.0F);
		this.setPathPriority(PathNodeType.DAMAGE_OTHER, 0.0F);
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(VELOCIRAPTOR_FLAGS, (byte)0);
		this.dataManager.register(CLIMBING, (byte)0);
		this.dataManager.register(ALBINO, false);
		this.dataManager.register(MELANISTIC, false);
		this.dataManager.register(NATURAL_LOVE, false);
	}

	protected void registerGoals() {
		this.attackAnimals = new VelociraptorEntity.TamedHuntGoal(this, AnimalEntity.class, 10, false, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof AepyornithomimusEntity || p_213487_0_ instanceof BasilemysEntity || p_213487_0_ instanceof ChromogisaurusEntity || p_213487_0_ instanceof CitipatiEntity || p_213487_0_ instanceof DidelphodonEntity || p_213487_0_ instanceof DryosaurusEntity || p_213487_0_ instanceof EilenodonEntity || p_213487_0_ instanceof ExaeretodonEntity || p_213487_0_ instanceof HesperornithoidesEntity || p_213487_0_ instanceof HyperodapedonEntity || p_213487_0_ instanceof ProtoceratopsEntity || p_213487_0_ instanceof TelmasaurusEntity || p_213487_0_ instanceof ThescelosaurusEntity || p_213487_0_ instanceof CatEntity || p_213487_0_ instanceof OcelotEntity || p_213487_0_ instanceof ChickenEntity || p_213487_0_ instanceof FoxEntity || p_213487_0_ instanceof ParrotEntity || p_213487_0_ instanceof PigEntity || p_213487_0_ instanceof RabbitEntity || p_213487_0_ instanceof AbstractVillagerEntity || p_213487_0_ instanceof WanderingTraderEntity || p_213487_0_ instanceof AbstractIllagerEntity || p_213487_0_ instanceof PlayerEntity || p_213487_0_ instanceof WolfEntity || p_213487_0_ instanceof TurtleEntity || p_213487_0_ instanceof KayentatheriumEntity || p_213487_0_ instanceof MegapnosaurusEntity || p_213487_0_ instanceof SarahsaurusEntity || p_213487_0_ instanceof ScelidosaurusEntity || p_213487_0_ instanceof ScutellosaurusEntity;
		});
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new VelociraptorEntity.JumpGoal());
		this.goalSelector.addGoal(2, new VelociraptorEntity.PanicGoal());
		this.goalSelector.addGoal(0, new VelociraptorEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new VelociraptorEntity.NaturalMateGoal(this, 1.0D));
		this.targetSelector.addGoal(2, new VelociraptorEntity.AttackPlayerGoal());
		this.goalSelector.addGoal(5, new VelociraptorEntity.FollowTargetGoal());
		this.goalSelector.addGoal(1, new VelociraptorEntity.PounceGoal());
		this.goalSelector.addGoal(6, new VelociraptorEntity.FindShelterGoal(1.25D));
		this.goalSelector.addGoal(7, new VelociraptorEntity.BiteGoal((double)1.2F, true));
		this.goalSelector.addGoal(7, new VelociraptorEntity.SleepGoal());
		this.goalSelector.addGoal(8, new VelociraptorEntity.FollowGoal(this, 1.25D));
		this.targetSelector.addGoal(1, new VelociraptorEntity.HurtByTargetGoal());
		this.goalSelector.addGoal(10, new LeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(11, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(13, new VelociraptorEntity.SitAndLookGoal());
		this.goalSelector.addGoal(0, new VelociraptorEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, AnkylosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, TriceratopsEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, TyrannosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, CamarasaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, StegosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, AllosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(9, new AvoidEntityGoal<>(this, CeratosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<DilophosaurusEntity>(this, DilophosaurusEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(2, new SitGoal(this));
		this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
		this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
		this.goalSelector.addGoal(1, new CrepuscularSleepGoal(this));
		this.targetSelector.addGoal(0, new CarnivoreHuntGoal(this, LivingEntity.class, 10, true, false, (p_213487_0_) -> {
			return p_213487_0_ instanceof AepyornithomimusEntity || p_213487_0_ instanceof BasilemysEntity || p_213487_0_ instanceof ChromogisaurusEntity || p_213487_0_ instanceof CitipatiEntity || p_213487_0_ instanceof DidelphodonEntity || p_213487_0_ instanceof DryosaurusEntity || p_213487_0_ instanceof EilenodonEntity || p_213487_0_ instanceof ExaeretodonEntity || p_213487_0_ instanceof HesperornithoidesEntity || p_213487_0_ instanceof HyperodapedonEntity || p_213487_0_ instanceof ProtoceratopsEntity || p_213487_0_ instanceof TelmasaurusEntity || p_213487_0_ instanceof ThescelosaurusEntity || p_213487_0_ instanceof CatEntity || p_213487_0_ instanceof OcelotEntity || p_213487_0_ instanceof ChickenEntity || p_213487_0_ instanceof FoxEntity || p_213487_0_ instanceof ParrotEntity || p_213487_0_ instanceof PigEntity || p_213487_0_ instanceof RabbitEntity || p_213487_0_ instanceof AbstractVillagerEntity || p_213487_0_ instanceof WanderingTraderEntity || p_213487_0_ instanceof AbstractIllagerEntity || p_213487_0_ instanceof PlayerEntity || p_213487_0_ instanceof WolfEntity || p_213487_0_ instanceof TurtleEntity || p_213487_0_ instanceof KayentatheriumEntity || p_213487_0_ instanceof MegapnosaurusEntity || p_213487_0_ instanceof SarahsaurusEntity || p_213487_0_ instanceof ScelidosaurusEntity || p_213487_0_ instanceof ScutellosaurusEntity || p_213487_0_ instanceof SheepEntity;
		}));
		this.targetSelector.addGoal(0, new BabyCarnivoreHuntGoal(this, LivingEntity.class, 10, true, false, (p_213487_1_) -> {
			return p_213487_1_ instanceof DidelphodonEntity || p_213487_1_ instanceof EilenodonEntity || p_213487_1_ instanceof HyperodapedonEntity || p_213487_1_ instanceof TelmasaurusEntity || p_213487_1_ instanceof RabbitEntity || p_213487_1_ instanceof ChickenEntity || p_213487_1_ instanceof HesperornithoidesEntity || p_213487_1_ instanceof ScutellosaurusEntity;
		}));
	}

	public void livingTick() {
		if (!this.world.isRemote && this.isAlive() && this.isServerWorld()) {
			++this.eatTicks;
			ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
			if (this.canEatItem(itemstack)) {
				if (this.eatTicks > 600) {
					ItemStack itemstack1 = itemstack.onItemUseFinish(this.world, this);
					if (!itemstack1.isEmpty()) {
						this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemstack1);
					}

					this.eatTicks = 0;
				} else if (this.eatTicks > 560 && this.rand.nextFloat() < 0.1F) {
					this.world.setEntityState(this, (byte)45);
				}
			}

			LivingEntity livingentity = this.getAttackTarget();
			if (livingentity == null || !livingentity.isAlive()) {
				this.setCrouching(false);
				this.func_213502_u(false);
			}
		}
		if (this.getAttackTarget() != null) {
			if (this.getRidingEntity() != null) {
				if (this.getRidingEntity() == this.getAttackTarget() && this.ticksExisted % 20 == 0) {
					ModifiableAttributeInstance iattributeinstance = this.getAttribute(Attributes.ATTACK_DAMAGE);
					this.getAttackTarget().attackEntityFrom(DamageSource.causeMobDamage(this), (float) iattributeinstance.getBaseValue());
				}
			}
		}

		if (this.isSleeping() || this.isMovementBlocked()) {
			this.isJumping = false;
			this.moveStrafing = 0.0F;
			this.moveForward = 0.0F;
		}
		
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		}

		super.livingTick();
		if (this.isVelociraptorAggroed() && this.rand.nextFloat() < 0.05F) {
		}
		List<VelociraptorEntity> list = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(20.0D, 20.0D, 20.0D));
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

	private boolean canEatItem(ItemStack itemStackIn) {
		return itemStackIn.getItem().isFood() && itemStackIn.getItem().getFood().isMeat() && this.getAttackTarget() == null && this.onGround && !this.isSleeping();
	}

	protected boolean isMovementBlocked() {
		return this.getHealth() <= 0.0F;
	}

	public boolean canEquipItem(ItemStack stack) {
		Item item = stack.getItem();
		ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
		return itemstack.isEmpty() || this.eatTicks > 0 && item.isFood();
	}

	private void spitOutItem(ItemStack stackIn) {
		if (!stackIn.isEmpty() && !this.world.isRemote) {
			ItemEntity itementity = new ItemEntity(this.world, this.getPosX() + this.getLookVec().x, this.getPosY() + 1.0D, this.getPosZ() + this.getLookVec().z, stackIn);
			itementity.setPickupDelay(40);
			itementity.setThrowerId(this.getUniqueID());
			this.world.addEntity(itementity);
		}
	}

	private void spawnItem(ItemStack stackIn) {
		ItemEntity itementity = new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), stackIn);
		this.world.addEntity(itementity);
	}

	protected void updateEquipmentIfNeeded(ItemEntity itemEntity) {
		ItemStack itemstack = itemEntity.getItem();
		if (this.canEquipItem(itemstack)) {
			int i = itemstack.getCount();
			if (i > 1) {
				this.spawnItem(itemstack.split(i - 1));
			}

			this.spitOutItem(this.getItemStackFromSlot(EquipmentSlotType.MAINHAND));
			this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemstack.split(1));
			this.inventoryHandsDropChances[EquipmentSlotType.MAINHAND.getIndex()] = 2.0F;
			this.onItemPickup(itemEntity, itemstack.getCount());
			itemEntity.remove();
			this.eatTicks = 0;
		}

	}

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		if (this.rand.nextFloat() < 0.2F) {
			float f = this.rand.nextFloat();
			ItemStack itemstack;
			if (f < 0.05F) {
				itemstack = new ItemStack(Items.EMERALD);
			} else if (f < 0.2F) {
				itemstack = new ItemStack(Items.EGG);
			} else if (f < 0.4F) {
				itemstack = this.rand.nextBoolean() ? new ItemStack(Items.RABBIT_FOOT) : new ItemStack(Items.RABBIT_HIDE);
			} else if (f < 0.6F) {
				itemstack = new ItemStack(Items.WHEAT);
			} else if (f < 0.8F) {
				itemstack = new ItemStack(Items.LEATHER);
			} else {
				itemstack = new ItemStack(Items.FEATHER);
			}

			this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemstack);
		}

	}

	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 45) {
			ItemStack itemstack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
			if (!itemstack.isEmpty()) {
				for(int i = 0; i < 8; ++i) {
					Vector3d vec3d = (new Vector3d(((double)this.rand.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D)).rotatePitch(-this.rotationPitch * ((float)Math.PI / 180F)).rotateYaw(-this.rotationYaw * ((float)Math.PI / 180F));
					this.world.addParticle(new ItemParticleData(ParticleTypes.ITEM, itemstack), this.getPosX() + this.getLookVec().x / 2.0D, this.getPosY(), this.getPosZ() + this.getLookVec().z / 2.0D, vec3d.x, vec3d.y + 0.05D, vec3d.z);
				}
			}
		} else {
			super.handleStatusUpdate(id);
		}

	}

	@Override
	public void applyEntityCollision(Entity entity) {
		super.applyEntityCollision(entity);
		if (this.getAttackTarget() != null) {
			if (this.getAttackTarget() == entity && !onGround && this.getRidingEntity() != entity && !(entity instanceof PlayerEntity)) {
				this.startRiding(entity);
			}
		}
	}

	@Override
	public boolean attackEntityFrom(DamageSource dmg, float i) {
		if (this.getRidingEntity() != null) {
			if (this.getLastAttackedEntity() != null) {
				if (this.getLastAttackedEntity() == this.getRidingEntity()) {
					if (this.getRNG().nextInt(2) == 0) {
						this.stopRiding();
					}
				}
			}
		}
		return super.attackEntityFrom(dmg, i);
	}

	private void setAttackGoals() {
		this.targetSelector.addGoal(4, this.attackAnimals);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("IsSleeping", this.isSleeping());
		compound.putBoolean("IsSitting", this.isSitting());
		compound.putBoolean("IsCrouching", this.isCrouching());
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setSleeping(compound.getBoolean("IsSleeping"));
		this.setSitting(compound.getBoolean("IsSitting"));
		this.setCrouching(compound.getBoolean("IsCrouching"));
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
		this.setHunger(20);
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public boolean isSitting() {
		return this.getVelociraptorFlag(1);
	}

	public void setSitting(boolean p_213466_1_) {
		this.setVelociraptorFlag(1, p_213466_1_);
	}

	public boolean isStuck() {
		return this.getVelociraptorFlag(64);
	}

	private void setStuck(boolean p_213492_1_) {
		this.setVelociraptorFlag(64, p_213492_1_);
	}

	private boolean isVelociraptorAggroed() {
		return this.getVelociraptorFlag(128);
	}

	private void setVelociraptorAggroed(boolean p_213482_1_) {
		this.setVelociraptorFlag(128, p_213482_1_);
	}

	/**
	 * Returns whether player is sleeping or not
	 */
	public boolean isSleeping() {
		return this.getVelociraptorFlag(32);
	}

	public void setSleeping(boolean p_213485_1_) {
		this.setVelociraptorFlag(32, p_213485_1_);
	}

	private void setVelociraptorFlag(int p_213505_1_, boolean p_213505_2_) {
		if (p_213505_2_) {
			this.dataManager.set(VELOCIRAPTOR_FLAGS, (byte)(this.dataManager.get(VELOCIRAPTOR_FLAGS) | p_213505_1_));
		} else {
			this.dataManager.set(VELOCIRAPTOR_FLAGS, (byte)(this.dataManager.get(VELOCIRAPTOR_FLAGS) & ~p_213505_1_));
		}

	}

	private boolean getVelociraptorFlag(int p_213507_1_) {
		return (this.dataManager.get(VELOCIRAPTOR_FLAGS) & p_213507_1_) != 0;
	}

	public void tick() {
		super.tick();
		if (this.isServerWorld()) {
			boolean flag = this.isInWater();
			if (flag || this.getAttackTarget() != null || this.world.isThundering()) {
				this.func_213454_em();
			}

			if (flag || this.isSleeping()) {
				this.setSitting(false);
			}

			if (this.isStuck() && this.world.rand.nextFloat() < 0.2F) {
				BlockPos blockpos = new BlockPos(this.getPositionVec());
				BlockState blockstate = this.world.getBlockState(blockpos);
				this.world.playEvent(2001, blockpos, Block.getStateId(blockstate));
			}
		}

		if (this.warningSoundTicks > 0) {
			--this.warningSoundTicks;
		}

		this.interestedAngleO = this.interestedAngle;
		if (this.func_213467_eg()) {
			this.interestedAngle += (1.0F - this.interestedAngle) * 0.4F;
		} else {
			this.interestedAngle += (0.0F - this.interestedAngle) * 0.4F;
		}

		this.crouchAmountO = this.crouchAmount;
		if (this.isCrouching()) {
			this.crouchAmount += 0.2F;
			if (this.crouchAmount > 3.0F) {
				this.crouchAmount = 3.0F;
			}
		} else {
			this.crouchAmount = 0.0F;
		}

		if (!this.world.isRemote) {
			this.setBesideClimbableBlock(this.collidedHorizontally);
		}

	}

	public boolean isOnLadder() {
		return this.isBesideClimbableBlock();
	}

	public boolean isBesideClimbableBlock() {
		return (this.dataManager.get(CLIMBING) & 1) != 0;
	}

	/**
	 * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if par1 is true or 0x00 if it is
	 * false.
	 */
	public void setBesideClimbableBlock(boolean climbing) {
		byte b0 = this.dataManager.get(CLIMBING);
		if (climbing) {
			b0 = (byte)(b0 | 1);
		} else {
			b0 = (byte)(b0 & -2);
		}

		this.dataManager.set(CLIMBING, b0);
	}

	public boolean func_213480_dY() {
		return this.getVelociraptorFlag(16);
	}

	public void func_213461_s(boolean p_213461_1_) {
		this.setVelociraptorFlag(16, p_213461_1_);
	}

	public boolean func_213490_ee() {
		return this.crouchAmount == 3.0F;
	}

	public void setCrouching(boolean p_213451_1_) {
		this.setVelociraptorFlag(4, p_213451_1_);
	}

	public boolean isCrouching() {
		return this.getVelociraptorFlag(4);
	}

	public void func_213502_u(boolean p_213502_1_) {
		this.setVelociraptorFlag(8, p_213502_1_);
	}

	public boolean func_213467_eg() {
		return this.getVelociraptorFlag(8);
	}

	@OnlyIn(Dist.CLIENT)
	public float func_213475_v(float p_213475_1_) {
		return MathHelper.lerp(p_213475_1_, this.interestedAngleO, this.interestedAngle) * 0.11F * (float)Math.PI;
	}

	@OnlyIn(Dist.CLIENT)
	public float func_213503_w(float p_213503_1_) {
		return MathHelper.lerp(p_213503_1_, this.crouchAmountO, this.crouchAmount);
	}

	public void setAttackTarget(@Nullable LivingEntity entitylivingbaseIn) {
		if (this.isVelociraptorAggroed() && entitylivingbaseIn == null) {
			this.setVelociraptorAggroed(false);
		}

		super.setAttackTarget(entitylivingbaseIn);
	}

	protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
		return MathHelper.ceil((p_225508_1_ - 5.0F) * p_225508_2_);
	}

	private void func_213454_em() {
		this.setSleeping(false);
	}

	private void func_213499_en() {
		this.func_213502_u(false);
		this.setCrouching(false);
		this.setSitting(false);
		this.setSleeping(false);
		this.setVelociraptorAggroed(false);
		this.setStuck(false);
	}

	private boolean func_213478_eo() {
		return !this.isSleeping() && !this.isSitting() && !this.isStuck();
	}

	protected SoundEvent getAmbientSound()  {
		return this.isAsleep() ? null : SoundInit.VELOCIRAPTOR_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.VELOCIRAPTOR_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.VELOCIRAPTOR_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundInit.VELOCIRAPTOR_WARN, 1.0F, this.getSoundPitch());
			this.warningSoundTicks = 40;
		}
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 6.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D).createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 6.0D).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.1D);
	}

	public static boolean func_213481_a(VelociraptorEntity p_213481_0_, LivingEntity p_213481_1_) {
		double d0 = p_213481_1_.getPosZ() - p_213481_0_.getPosZ();
		double d1 = p_213481_1_.getPosX() - p_213481_0_.getPosX();
		double d2 = d0 / d1;
		for(int j = 0; j < 6; ++j) {
			double d3 = d2 == 0.0D ? 0.0D : d0 * (double)((float)j / 6.0F);
			double d4 = d2 == 0.0D ? d1 * (double)((float)j / 6.0F) : d3 / d2;

			for(int k = 1; k < 4; ++k) {
				if (!p_213481_0_.world.getBlockState(new BlockPos(p_213481_0_.getPosX() + d4, p_213481_0_.getPosY() + (double)k, p_213481_0_.getPosZ() + d3)).getMaterial().isReplaceable()) {
					return false;
				}
			}
		}

		return true;
	}

	public class AlertablePredicate implements Predicate<LivingEntity> {
		public boolean test(LivingEntity p_test_1_) {
			if (p_test_1_ instanceof VelociraptorEntity) {
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
		private final EntityPredicate field_220816_b = (new EntityPredicate()).setDistance(12.0D).setLineOfSiteRequired().setCustomPredicate(VelociraptorEntity.this.new AlertablePredicate());

		private BaseGoal() {
		}

		protected boolean func_220813_g() {
			BlockPos blockpos = new BlockPos(VelociraptorEntity.this.getPositionVec());
			return !VelociraptorEntity.this.world.canSeeSky(blockpos) && VelociraptorEntity.this.getBlockPathWeight(blockpos) >= 0.0F;
		}

		protected boolean func_220814_h() {
			return !VelociraptorEntity.this.world.getTargettableEntitiesWithinAABB(LivingEntity.class, this.field_220816_b, VelociraptorEntity.this, VelociraptorEntity.this.getBoundingBox().grow(12.0D, 6.0D, 12.0D)).isEmpty();
		}
	}

	class BiteGoal extends MeleeAttackGoal {
		public BiteGoal(double p_i50731_2_, boolean p_i50731_4_) {
			super();
		}

		protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
			double d0 = this.getAttackReachSqr(enemy);
			if (distToEnemySqr <= d0 && this.func_234040_h_()) {
				this.func_234039_g_();
				this.attacker.attackEntityAsMob(enemy);
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

		public void startExecuting() {
			VelociraptorEntity.this.func_213502_u(false);
			super.startExecuting();
		}

		public boolean shouldExecute() {
			return !VelociraptorEntity.this.isSitting() && !VelociraptorEntity.this.isSleeping() && !VelociraptorEntity.this.isCrouching() && !VelociraptorEntity.this.isStuck() && super.shouldExecute();
		}
	}

	class FindShelterGoal extends FleeSunGoal {
		private int cooldown = 100;

		public FindShelterGoal(double p_i50724_2_) {
			super(VelociraptorEntity.this, p_i50724_2_);
		}

		public boolean shouldExecute() {
			if (!VelociraptorEntity.this.isSleeping() && this.creature.getAttackTarget() == null) {
				if (VelociraptorEntity.this.world.isThundering()) {
					return true;
				} else if (this.cooldown > 0) {
					--this.cooldown;
					return false;
				} else {
					this.cooldown = 100;
					BlockPos blockpos = new BlockPos(this.creature.getPositionVec());
					return VelociraptorEntity.this.world.isDaytime() && VelociraptorEntity.this.world.canSeeSky(blockpos) && !((ServerWorld)VelociraptorEntity.this.world).isVillage(blockpos) && this.isPossibleShelter();
				}
			} else {
				return false;
			}
		}

		public void startExecuting() {
			VelociraptorEntity.this.func_213499_en();
			super.startExecuting();
		}
	}

	class FollowGoal extends FollowParentGoal {
		private final VelociraptorEntity owner;

		public FollowGoal(VelociraptorEntity p_i50735_2_, double p_i50735_3_) {
			super(p_i50735_2_, p_i50735_3_);
			this.owner = p_i50735_2_;
		}

		public boolean shouldExecute() {
			return !this.owner.isVelociraptorAggroed() && super.shouldExecute();
		}

		public boolean shouldContinueExecuting() {
			return !this.owner.isVelociraptorAggroed() && super.shouldContinueExecuting();
		}

		public void startExecuting() {
			this.owner.func_213499_en();
			super.startExecuting();
		}
	}

	class FollowTargetGoal extends Goal {
		public FollowTargetGoal() {
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		public boolean shouldExecute() {
			if (VelociraptorEntity.this.isSleeping()) {
				return false;
			} else {
				LivingEntity livingentity = VelociraptorEntity.this.getAttackTarget();
				return livingentity != null && livingentity.isAlive() && VelociraptorEntity.IS_PREY.test(livingentity) && VelociraptorEntity.this.getDistanceSq(livingentity) > 36.0D && !VelociraptorEntity.this.isCrouching() && !VelociraptorEntity.this.func_213467_eg() && !VelociraptorEntity.this.isJumping;
			}
		}

		public void startExecuting() {
			VelociraptorEntity.this.setSitting(false);
			VelociraptorEntity.this.setStuck(false);
		}

		public void resetTask() {
			LivingEntity livingentity = VelociraptorEntity.this.getAttackTarget();
			if (livingentity != null && VelociraptorEntity.func_213481_a(VelociraptorEntity.this, livingentity)) {
				VelociraptorEntity.this.func_213502_u(true);
				VelociraptorEntity.this.setCrouching(true);
				VelociraptorEntity.this.getNavigator().clearPath();
				VelociraptorEntity.this.getLookController().setLookPositionWithEntity(livingentity, (float)VelociraptorEntity.this.getHorizontalFaceSpeed(), (float)VelociraptorEntity.this.getVerticalFaceSpeed());
			} else {
				VelociraptorEntity.this.func_213502_u(false);
				VelociraptorEntity.this.setCrouching(false);
			}

		}

		public void tick() {
			LivingEntity livingentity = VelociraptorEntity.this.getAttackTarget();
			VelociraptorEntity.this.getLookController().setLookPositionWithEntity(livingentity, (float)VelociraptorEntity.this.getHorizontalFaceSpeed(), (float)VelociraptorEntity.this.getVerticalFaceSpeed());
			if (VelociraptorEntity.this.getDistanceSq(livingentity) <= 36.0D) {
				VelociraptorEntity.this.func_213502_u(true);
				VelociraptorEntity.this.setCrouching(true);
				VelociraptorEntity.this.getNavigator().clearPath();
			} else {
				VelociraptorEntity.this.getNavigator().tryMoveToEntityLiving(livingentity, 1.5D);
			}

		}
	}

	class JumpGoal extends Goal {
		int delay;

		public JumpGoal() {
			this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK, Goal.Flag.JUMP, Goal.Flag.MOVE));
		}

		public boolean shouldExecute() {
			return VelociraptorEntity.this.isStuck();
		}

		public boolean shouldContinueExecuting() {
			return this.shouldExecute() && this.delay > 0;
		}

		public void startExecuting() {
			this.delay = 40;
		}

		public void resetTask() {
			VelociraptorEntity.this.setStuck(false);
		}

		public void tick() {
			--this.delay;
		}
	}

	public class LookHelperController extends LookController {
		public LookHelperController() {
			super(VelociraptorEntity.this);
		}

		public void tick() {
			if (!VelociraptorEntity.this.isSleeping()) {
				super.tick();
			}

		}

		protected boolean func_220680_b() {
			return !VelociraptorEntity.this.func_213480_dY() && !VelociraptorEntity.this.isCrouching() && !VelociraptorEntity.this.func_213467_eg() & !VelociraptorEntity.this.isStuck();
		}
	}

	class MoveHelperController extends MovementController {
		public MoveHelperController() {
			super(VelociraptorEntity.this);
		}

		public void tick() {
			if (VelociraptorEntity.this.func_213478_eo()) {
				super.tick();
			}

		}
	}

	public class PounceGoal extends net.minecraft.entity.ai.goal.JumpGoal {
		public boolean shouldExecute() {
			if (!VelociraptorEntity.this.func_213490_ee()) {
				return false;
			} else {
				LivingEntity livingentity = VelociraptorEntity.this.getAttackTarget();
				if (livingentity != null && livingentity.isAlive()) {
					if (livingentity.getAdjustedHorizontalFacing() != livingentity.getHorizontalFacing()) {
						return false;
					} else {
						boolean flag = VelociraptorEntity.func_213481_a(VelociraptorEntity.this, livingentity);
						if (!flag) {
							VelociraptorEntity.this.getNavigator().getPathToEntity(livingentity, 0);
							VelociraptorEntity.this.setCrouching(false);
							VelociraptorEntity.this.func_213502_u(false);
						}

						return flag;
					}
				} else {
					return false;
				}
			}
		}

		public boolean shouldContinueExecuting() {
			LivingEntity livingentity = VelociraptorEntity.this.getAttackTarget();
			if (livingentity != null && livingentity.isAlive()) {
				double d0 = VelociraptorEntity.this.getMotion().y;
				return (!(d0 * d0 < (double)0.05F) || !(Math.abs(VelociraptorEntity.this.rotationPitch) < 15.0F) || !VelociraptorEntity.this.onGround) && !VelociraptorEntity.this.isStuck();
			} else {
				return false;
			}
		}

		public boolean isPreemptible() {
			return false;
		}

		public void startExecuting() {
			VelociraptorEntity.this.setJumping(true);
			VelociraptorEntity.this.func_213461_s(true);
			VelociraptorEntity.this.func_213502_u(false);
			LivingEntity livingentity = VelociraptorEntity.this.getAttackTarget();
			VelociraptorEntity.this.getLookController().setLookPositionWithEntity(livingentity, 60.0F, 30.0F);
			Vector3d vec3d = (new Vector3d(livingentity.getPosX() - VelociraptorEntity.this.getPosX(), livingentity.getPosY() - VelociraptorEntity.this.getPosY(), livingentity.getPosZ() - VelociraptorEntity.this.getPosZ())).normalize();
			VelociraptorEntity.this.setMotion(VelociraptorEntity.this.getMotion().add(vec3d.x * 0.8D, 0.9D, vec3d.z * 0.8D));
			VelociraptorEntity.this.getNavigator().clearPath();
		}

		public void resetTask() {
			VelociraptorEntity.this.setCrouching(false);
			VelociraptorEntity.this.crouchAmount = 0.0F;
			VelociraptorEntity.this.crouchAmountO = 0.0F;
			VelociraptorEntity.this.func_213502_u(false);
			VelociraptorEntity.this.func_213461_s(false);
		}

		@SuppressWarnings("deprecation")
		public void tick() {
			LivingEntity livingentity = VelociraptorEntity.this.getAttackTarget();
			if (livingentity != null) {
				VelociraptorEntity.this.getLookController().setLookPositionWithEntity(livingentity, 60.0F, 30.0F);
			}

			if (!VelociraptorEntity.this.isStuck()) {
				Vector3d vec3d = VelociraptorEntity.this.getMotion();
				if (vec3d.y * vec3d.y < (double)0.03F && VelociraptorEntity.this.rotationPitch != 0.0F) {
					VelociraptorEntity.this.rotationPitch = MathHelper.rotLerp(VelociraptorEntity.this.rotationPitch, 0.0F, 0.2F);
				} else {
					double d0 = Math.sqrt(Entity.horizontalMag(vec3d));
					double d1 = Math.signum(-vec3d.y) * Math.acos(d0 / vec3d.length()) * (double)(180F / (float)Math.PI);
					VelociraptorEntity.this.rotationPitch = (float)d1;
				}
			}

			if (livingentity != null && VelociraptorEntity.this.getDistance(livingentity) <= 2.0F) {
				VelociraptorEntity.this.attackEntityAsMob(livingentity);
			} else if (VelociraptorEntity.this.rotationPitch > 0.0F && VelociraptorEntity.this.onGround && (float)VelociraptorEntity.this.getMotion().y != 0.0F && VelociraptorEntity.this.world.getBlockState(new BlockPos(VelociraptorEntity.this.getPositionVec())).getBlock() == Blocks.SNOW) {
				VelociraptorEntity.this.rotationPitch = 60.0F;
				VelociraptorEntity.this.setAttackTarget((LivingEntity)null);
			}

		}
	}

	class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(VelociraptorEntity.this, 2.0D);
		}

		public boolean shouldExecute() {
			return !VelociraptorEntity.this.isChild() && !VelociraptorEntity.this.isBurning() ? false : super.shouldExecute();
		}

	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final VelociraptorEntity velociraptor;

		LayEggGoal(VelociraptorEntity velociraptor, double speed) {
			super(velociraptor, speed, 16);
			this.velociraptor = velociraptor;
		}

		public boolean shouldExecute() {
			return this.velociraptor.hasEgg() ? super.shouldExecute() : false;
		}

		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && velociraptor.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.velociraptor.getPositionVec());
			if (!this.velociraptor.isInWater() && this.getIsAboveDestination()) {
				if (this.velociraptor.isDigging < 1) {
					this.velociraptor.setDigging(true);
				} else if (this.velociraptor.isDigging > 200) {
					World world = this.velociraptor.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.VELOCIRAPTOR_EGG.getDefaultState().with(VelociraptorEggBlock.EGGS, Integer.valueOf(this.velociraptor.rand.nextInt(4) + 1)), 3);
					this.velociraptor.setHasEgg(false);
					this.velociraptor.setDigging(false);
					this.velociraptor.setInLove(600);
				}
				if (this.velociraptor.isDigging()) {
					this.velociraptor.isDigging++;
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
		private final VelociraptorEntity velociraptor;

		MateGoal(VelociraptorEntity velociraptor, double speed) {
			super(velociraptor, speed);
			this.velociraptor = velociraptor;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.velociraptor.hasEgg() && !this.velociraptor.isInLoveNaturally();
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
			this.velociraptor.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}

	}
	
	static class NaturalMateGoal extends BreedGoal {
		private final VelociraptorEntity velociraptor;

		NaturalMateGoal(VelociraptorEntity velociraptor, double speed) {
			super(velociraptor, speed);
			this.velociraptor = velociraptor;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.velociraptor.hasEgg() && this.velociraptor.getCurrentHunger() >= this.velociraptor.getThreeQuartersHunger() && this.velociraptor.ticksExisted % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.velociraptor.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.velociraptor.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.velociraptor.rand.nextFloat() - this.velociraptor.rand.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.velociraptor.rand.nextInt(4);
				if (eggAmount == 0) {
					this.velociraptor.entityDropItem(PFBlocks.VELOCIRAPTOR_EGG.asItem());
				}
				if (eggAmount == 1) {
					this.velociraptor.entityDropItem(PFBlocks.VELOCIRAPTOR_EGG.asItem());
					this.velociraptor.entityDropItem(PFBlocks.VELOCIRAPTOR_EGG.asItem());
				}
				if (eggAmount == 2) {
					this.velociraptor.entityDropItem(PFBlocks.VELOCIRAPTOR_EGG.asItem());
					this.velociraptor.entityDropItem(PFBlocks.VELOCIRAPTOR_EGG.asItem());
					this.velociraptor.entityDropItem(PFBlocks.VELOCIRAPTOR_EGG.asItem());
				}
				if (eggAmount == 3) {
					this.velociraptor.entityDropItem(PFBlocks.VELOCIRAPTOR_EGG.asItem());
					this.velociraptor.entityDropItem(PFBlocks.VELOCIRAPTOR_EGG.asItem());
					this.velociraptor.entityDropItem(PFBlocks.VELOCIRAPTOR_EGG.asItem());
					this.velociraptor.entityDropItem(PFBlocks.VELOCIRAPTOR_EGG.asItem());
				}
			} else {
				this.velociraptor.setHasEgg(true);
			}
			this.animal.resetInLove();
			this.targetMate.resetInLove();
		}

	}

	class SitAndLookGoal extends VelociraptorEntity.BaseGoal {
		private double field_220819_c;
		private double field_220820_d;
		private int field_220821_e;
		private int field_220822_f;

		public SitAndLookGoal() {
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		public boolean shouldExecute() {
			return VelociraptorEntity.this.getRevengeTarget() == null && VelociraptorEntity.this.getRNG().nextFloat() < 0.02F && !VelociraptorEntity.this.isSleeping() && VelociraptorEntity.this.getAttackTarget() == null && VelociraptorEntity.this.getNavigator().noPath() && !this.func_220814_h() && !VelociraptorEntity.this.func_213480_dY() && !VelociraptorEntity.this.isCrouching() && !VelociraptorEntity.this.isAsleep();
		}

		public boolean shouldContinueExecuting() {
			return this.field_220822_f > 0;
		}

		public void startExecuting() {
			this.func_220817_j();
			this.field_220822_f = 2 + VelociraptorEntity.this.getRNG().nextInt(3);
			VelociraptorEntity.this.setSitting(true);
			VelociraptorEntity.this.getNavigator().clearPath();
		}

		public void resetTask() {
			VelociraptorEntity.this.setSitting(false);
		}

		public void tick() {
			--this.field_220821_e;
			if (this.field_220821_e <= 0) {
				--this.field_220822_f;
				this.func_220817_j();
			}

			VelociraptorEntity.this.getLookController().setLookPosition(VelociraptorEntity.this.getPosX() + this.field_220819_c, VelociraptorEntity.this.getPosYEye(), VelociraptorEntity.this.getPosZ() + this.field_220820_d, (float)VelociraptorEntity.this.getHorizontalFaceSpeed(), (float)VelociraptorEntity.this.getVerticalFaceSpeed());
		}

		private void func_220817_j() {
			double d0 = (Math.PI * 2D) * VelociraptorEntity.this.getRNG().nextDouble();
			this.field_220819_c = Math.cos(d0);
			this.field_220820_d = Math.sin(d0);
			this.field_220821_e = 80 + VelociraptorEntity.this.getRNG().nextInt(20);
		}
	}

	class SleepGoal extends VelociraptorEntity.BaseGoal {
		private int field_220825_c = VelociraptorEntity.this.rand.nextInt(140);

		public SleepGoal() {
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK, Goal.Flag.JUMP));
		}

		public boolean shouldExecute() {
			if (VelociraptorEntity.this.moveStrafing == 0.0F && VelociraptorEntity.this.moveVertical == 0.0F && VelociraptorEntity.this.moveForward == 0.0F && !PrehistoricFaunaConfig.sleeping) {
				return this.func_220823_j() || VelociraptorEntity.this.isSleeping();
			} else {
				return false;
			}
		}

		public boolean shouldContinueExecuting() {
			return this.func_220823_j();
		}

		private boolean func_220823_j() {
			if (this.field_220825_c > 0) {
				--this.field_220825_c;
				return false;
			} else {
				return VelociraptorEntity.this.world.isDaytime() && this.func_220813_g() && !this.func_220814_h();
			}
		}

		public void resetTask() {
			this.field_220825_c = VelociraptorEntity.this.rand.nextInt(140);
			VelociraptorEntity.this.func_213499_en();
		}

		public void startExecuting() {
			VelociraptorEntity.this.setSitting(false);
			VelociraptorEntity.this.setCrouching(false);
			VelociraptorEntity.this.func_213502_u(false);
			VelociraptorEntity.this.setJumping(false);
			VelociraptorEntity.this.setSleeping(true);
			VelociraptorEntity.this.getNavigator().clearPath();
			VelociraptorEntity.this.getMoveHelper().setMoveTo(VelociraptorEntity.this.getPosX(), VelociraptorEntity.this.getPosY(), VelociraptorEntity.this.getPosZ(), 0.0D);
		}
	}

	class WatchGoal extends LookAtGoal {
		public WatchGoal(MobEntity p_i50733_2_, Class<? extends LivingEntity> p_i50733_3_, float p_i50733_4_) {
			super(p_i50733_2_, p_i50733_3_, p_i50733_4_);
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !VelociraptorEntity.this.isStuck() && !VelociraptorEntity.this.func_213467_eg();
		}

		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && !VelociraptorEntity.this.isStuck() && !VelociraptorEntity.this.func_213467_eg();
		}
	}

	class AttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public AttackPlayerGoal() {
			super(VelociraptorEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		@SuppressWarnings({"unused"})
		public boolean shouldExecute() {
			if (VelociraptorEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute() && !VelociraptorEntity.this.isTamed()) {
					for (VelociraptorEntity velociraptor : VelociraptorEntity.this.world.getEntitiesWithinAABB(VelociraptorEntity.class, VelociraptorEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
						if (VelociraptorEntity.this.isChild()) {
							return true;
						}
					}
				}
			}
			return false;
		}

		protected double getTargetDistance() {
			return super.getTargetDistance() * 0.5D;
		}

	}

	class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(VelociraptorEntity.this);
		}

		public void startExecuting() {
			super.startExecuting();
			if(VelociraptorEntity.this.isChild()) {
				this.alertOthers();
				this.resetTask();
			}
		}

		protected void setAttackTarget(MobEntity entity, LivingEntity target) {
			if (entity instanceof VelociraptorEntity && !entity.isChild()) {
				super.setAttackTarget(entity, target);
			}
		}

	}

	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(VelociraptorEntity.this, 1.25D, true);
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
					VelociraptorEntity.this.playWarningSound();
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
			return (double)(5.0F + attackTarget.getWidth());
		}
	}

	public boolean attackEntityAsMob(Entity entity) {
		boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(Attributes.ATTACK_DAMAGE).getValue()));
		if (flag) {
			this.applyEnchantments(this, entity);
		}
		return flag;
	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		VelociraptorEntity entity = new VelociraptorEntity(PFEntities.VELOCIRAPTOR_ENTITY, this.world);
		entity.onInitialSpawn((IServerWorld)this.world, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}

	class TamedHuntGoal extends HuntGoal {

		@SuppressWarnings("rawtypes")
		public TamedHuntGoal(MobEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnlyIn, Predicate targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnlyIn, targetPredicate);
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !VelociraptorEntity.this.isTamed() && !PrehistoricFaunaConfig.advancedHunger && !VelociraptorEntity.this.isSleeping();
		}

	}

	public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
		ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
		Item item = itemstack.getItem();
		if (this.world.isRemote) {
			boolean flag = this.isOwner(p_230254_1_) || this.isTamed() || item == Items.BONE && !this.isTamed() && this.getAttackTarget() == null;
			return flag ? ActionResultType.CONSUME : ActionResultType.PASS;
		} else {
			if (this.isTamed()) {
				if (this.isBreedingItem(itemstack) && this.getHealth() < this.getMaxHealth()) {
					if (!p_230254_1_.abilities.isCreativeMode) {
						itemstack.shrink(1);
					}

					this.heal((float)item.getFood().getHealing());
					return ActionResultType.SUCCESS;
				}
			} else if (item == PFItems.RAW_SMALL_MARGINOCEPHALIAN_MEAT.get()) {
				if (!p_230254_1_.abilities.isCreativeMode) {
					itemstack.shrink(1);
				}

				if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, p_230254_1_)) {
					this.setTamedBy(p_230254_1_);
					this.navigator.clearPath();
					this.setAttackTarget((LivingEntity)null);
					this.func_233687_w_(true);
					this.world.setEntityState(this, (byte)7);
				} else {
					this.world.setEntityState(this, (byte)6);
				}

				return ActionResultType.SUCCESS;
			}

			return super.func_230254_b_(p_230254_1_, p_230254_2_);
		}
	}
	

	@SuppressWarnings("rawtypes")
	public class CarnivoreHuntGoal extends NearestAttackableTargetGoal {

		@SuppressWarnings("unchecked")
		public CarnivoreHuntGoal(MobEntity goalOwnerIn, Class targetClassIn, int targetChanceIn, boolean checkSight, boolean nearbyOnly, @Nullable Predicate<LivingEntity> targetPredicate) {
			super(goalOwnerIn, targetClassIn, targetChanceIn, checkSight, nearbyOnly, targetPredicate);
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && VelociraptorEntity.this.getCurrentHunger() <= VelociraptorEntity.this.getHalfHunger() && !VelociraptorEntity.this.isChild();
		}

		public boolean shouldContinueExecuting() {
			return VelociraptorEntity.this.getCurrentHunger() < VelociraptorEntity.this.maxHunger;
		}

		public void tick() {
			LivingEntity target = VelociraptorEntity.this.getAttackTarget();
			if (target instanceof RabbitEntity) {
				if (target.getHealth() == 0) {
					if (VelociraptorEntity.this.getCurrentHunger() + 3 >= VelociraptorEntity.this.maxHunger) {
						VelociraptorEntity.this.setHunger(VelociraptorEntity.this.maxHunger);
					} else {
						VelociraptorEntity.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof DidelphodonEntity || target instanceof EilenodonEntity || target instanceof HesperornithoidesEntity || target instanceof HyperodapedonEntity || target instanceof ChickenEntity || target instanceof ScutellosaurusEntity) {
				if (target.getHealth() == 0) {
					if (VelociraptorEntity.this.getCurrentHunger() + 4 >= VelociraptorEntity.this.maxHunger) {
						VelociraptorEntity.this.setHunger(VelociraptorEntity.this.maxHunger);
					} else {
						VelociraptorEntity.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof BasilemysEntity || target instanceof ChromogisaurusEntity || target instanceof ExaeretodonEntity || target instanceof TelmasaurusEntity || target instanceof ParrotEntity || target instanceof KayentatheriumEntity || target instanceof MegapnosaurusEntity) {
				if (target.getHealth() == 0) {
					if (VelociraptorEntity.this.getCurrentHunger() + 6 >= VelociraptorEntity.this.maxHunger) {
						VelociraptorEntity.this.setHunger(VelociraptorEntity.this.maxHunger);
					} else {
						VelociraptorEntity.this.setHunger(currentHunger + 6);
					}
				}
			}
			if (target instanceof WolfEntity || target instanceof SheepEntity) {
				if (target.getHealth() == 0) {
					if (VelociraptorEntity.this.getCurrentHunger() + 8 >= VelociraptorEntity.this.maxHunger) {
						VelociraptorEntity.this.setHunger(VelociraptorEntity.this.maxHunger);
					} else {
						VelociraptorEntity.this.setHunger(currentHunger + 8);
					}
				}
			}
			if (target instanceof CatEntity || target instanceof FoxEntity || target instanceof PigEntity || target instanceof OcelotEntity || target instanceof AepyornithomimusEntity || target instanceof DryosaurusEntity || target instanceof ProtoceratopsEntity || target instanceof ThescelosaurusEntity || target instanceof SarahsaurusEntity || target instanceof ScelidosaurusEntity) {
				if (target.getHealth() == 0) {
					if (VelociraptorEntity.this.getCurrentHunger() + 10 >= VelociraptorEntity.this.maxHunger) {
						VelociraptorEntity.this.setHunger(VelociraptorEntity.this.maxHunger);
					} else {
						VelociraptorEntity.this.setHunger(currentHunger + 10);
					}
				}
			}
			if (target instanceof CitipatiEntity) {
				if (target.getHealth() == 0) {
					if (VelociraptorEntity.this.getCurrentHunger() + 15 >= VelociraptorEntity.this.maxHunger) {
						VelociraptorEntity.this.setHunger(VelociraptorEntity.this.maxHunger);
					} else {
						VelociraptorEntity.this.setHunger(currentHunger + 15);
					}
				}
			}
			if (target instanceof WanderingTraderEntity || target instanceof PlayerEntity || target instanceof AbstractVillagerEntity || target instanceof AbstractIllagerEntity) {
				if (target.getHealth() == 0) {
					if (VelociraptorEntity.this.getCurrentHunger() + 20 >= VelociraptorEntity.this.maxHunger) {
						VelociraptorEntity.this.setHunger(VelociraptorEntity.this.maxHunger);
					} else {
						VelociraptorEntity.this.setHunger(currentHunger + 20);
					}
				}
			}
			if (target instanceof TurtleEntity) {
				if (target.getHealth() == 0) {
					if (VelociraptorEntity.this.getCurrentHunger() + 30 >= VelociraptorEntity.this.maxHunger) {
						VelociraptorEntity.this.setHunger(VelociraptorEntity.this.maxHunger);
					} else {
						VelociraptorEntity.this.setHunger(currentHunger + 30);
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
			return super.shouldExecute() && VelociraptorEntity.this.getCurrentHunger() <= VelociraptorEntity.this.getHalfHunger() && VelociraptorEntity.this.isChild();
		}

		public boolean shouldContinueExecuting() {
			return VelociraptorEntity.this.getCurrentHunger() < VelociraptorEntity.this.maxHunger || !VelociraptorEntity.this.isChild();
		}

		public void tick() {
			LivingEntity target = VelociraptorEntity.this.getAttackTarget();
			if (target instanceof RabbitEntity) {
				if (target.getHealth() == 0) {
					if (VelociraptorEntity.this.getCurrentHunger() + 3 >= VelociraptorEntity.this.maxHunger) {
						VelociraptorEntity.this.setHunger(VelociraptorEntity.this.maxHunger);
					} else {
						VelociraptorEntity.this.setHunger(currentHunger + 3);
					}
				}
			}
			if (target instanceof DidelphodonEntity || target instanceof EilenodonEntity || target instanceof HyperodapedonEntity || target instanceof ChickenEntity || target instanceof HesperornithoidesEntity || target instanceof ScutellosaurusEntity) {
				if (target.getHealth() == 0) {
					if (VelociraptorEntity.this.getCurrentHunger() + 4 >= VelociraptorEntity.this.maxHunger) {
						VelociraptorEntity.this.setHunger(VelociraptorEntity.this.maxHunger);
					} else {
						VelociraptorEntity.this.setHunger(currentHunger + 4);
					}
				}
			}
			if (target instanceof TelmasaurusEntity) {
				if (target.getHealth() == 0) {
					if (VelociraptorEntity.this.getCurrentHunger() + 6 >= VelociraptorEntity.this.maxHunger) {
						VelociraptorEntity.this.setHunger(VelociraptorEntity.this.maxHunger);
					} else {
						VelociraptorEntity.this.setHunger(currentHunger + 6);
					}
				}
			}
			super.tick();
		}

	}


}