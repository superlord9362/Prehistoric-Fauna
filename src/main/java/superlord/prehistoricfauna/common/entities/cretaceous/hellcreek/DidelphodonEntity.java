package superlord.prehistoricfauna.common.entities.cretaceous.hellcreek;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
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
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
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
import superlord.prehistoricfauna.common.blocks.CrassostreaOysterBlock;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.common.entities.goal.CrepuscularSleepGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.DilophosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.MegapnosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.AllosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CamarasaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CeratosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.DryosaurusEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.HesperornithoidesEntity;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.StegosaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ExaeretodonEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HerrerasaurusEntity;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SaurosuchusEntity;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.SoundInit;

public class DidelphodonEntity extends DinosaurEntity {

	private static final DataParameter<Boolean> IS_PREGNANT = EntityDataManager.createKey(DidelphodonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_READY = EntityDataManager.createKey(DidelphodonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(DidelphodonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(DidelphodonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> NATURAL_LOVE = EntityDataManager.createKey(DidelphodonEntity.class, DataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(PFBlocks.CRASSOSTREA_OYSTER.asItem());
	private int currentHunger;
	private int maxHunger = 10;
	private int lastInLove = 0;
	int hungerTick = 0;
	private int isReady;
	public int eatTicks;
	private float interestedAngle;
	private float interestedAngleO;
	int loveTick = 0;

	public DidelphodonEntity(EntityType<? extends DidelphodonEntity> type, World world) {
		super(type, world);
		this.setCanPickUpLoot(true);
	}

	private void spawnItem(ItemStack stack) {
		ItemEntity itemEntity = new ItemEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), stack);
		this.world.addEntity(itemEntity);
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

	protected void updateEquipmentIfNeeded(ItemEntity itemEntity) {
		ItemStack itemstack = itemEntity.getItem();
		if (this.canEquipItem(itemstack)) {
			int i = itemstack.getCount();
			if (i > 1) {
				this.spawnItem(itemstack.split(i - 1));
			}
			this.triggerItemPickupTrigger(itemEntity);
			this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemstack.split(1));
			this.inventoryHandsDropChances[EquipmentSlotType.MAINHAND.getIndex()] = 2.0F;
			this.onItemPickup(itemEntity, itemstack.getCount());
			itemEntity.remove();
			this.eatTicks = 0;
		}
	}

	public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
		ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
		Item item = itemstack.getItem();
		if (this.world.isRemote) {
			boolean flag = this.isOwner(p_230254_1_) || this.isTamed() || item == Items.BONE && !this.isTamed();
			return flag ? ActionResultType.CONSUME : ActionResultType.PASS;
		} else {
			if (!this.isTamed()) {
				if (item == PFItems.CRASSOSTREA_OYSTER.get()) {
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
				}
				return ActionResultType.SUCCESS;
			}

			return super.func_230254_b_(p_230254_1_, p_230254_2_);
		}

	}

	@OnlyIn(Dist.CLIENT)
	public float func_213475_v(float p_213475_1_) {
		return MathHelper.lerp(p_213475_1_, this.interestedAngleO, this.interestedAngle) * 0.11F * (float)Math.PI;
	}

	public void livingTick() {
		if (!this.world.isRemote && this.isAlive() && this.isServerWorld()) {
			++this.eatTicks;
			ItemStack stack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
			if (this.canEatItem(stack)) {
				if (this.eatTicks > 100) {
					if (this.isTamed()) {
						ItemStack itemStack = stack.onItemUseFinish(world, this);
						ItemStack openedStack = PFItems.RAW_OYSTER.get().getDefaultInstance();
						if (!itemStack.isEmpty()) {
							this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemStack);
						}
						this.eatTicks = 0;
						Random rand = new Random();
						int dropChance = rand.nextInt(99);
						if (dropChance >=24) {
							this.spawnItem(openedStack);
						} else {
							if (PrehistoricFaunaConfig.advancedHunger) {
								if (this.getCurrentHunger() + 5 >= this.maxHunger) {
									this.setHunger(this.maxHunger);
								} else {
									this.setHunger(currentHunger + 5);
								}
							}
						}
						itemStack.shrink(1);
					} else {
						ItemStack itemStack = stack.onItemUseFinish(world, this);
						if (PrehistoricFaunaConfig.advancedHunger) {
							if (this.getCurrentHunger() + 5 >= this.maxHunger) {
								this.setHunger(this.maxHunger);
							} else {
								this.setHunger(currentHunger + 5);
							}
						}
						if (!itemStack.isEmpty()) {
							this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemStack);
						}
						itemStack.shrink(1);
					}
				}
			}
		}
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		}
		if (!this.isAIDisabled()) {
			List<DidelphodonEntity> list = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(20.0D, 20.0D, 20.0D));
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
		super.livingTick();
	}

	public boolean canEatItem(ItemStack stack) {
		return stack.getItem() == PFItems.CRASSOSTREA_OYSTER.get();
	}

	public boolean canEquipItem(ItemStack stack) {
		if (this.canEatItem(stack)) {
			return true;
		} else {
			return false;
		}
	}

	public int getMaxAir() {
		return 4800;
	}

	protected int determineNextAir(int currentAir) {
		return this.getMaxAir();
	}

	public boolean isPregnant() {
		return this.dataManager.get(IS_PREGNANT);
	}

	private void setPregnant(boolean isPregnant) {
		this.dataManager.set(IS_PREGNANT, isPregnant);
	}

	public boolean isReady() {
		return this.dataManager.get(IS_READY);
	}

	private void setReady(boolean isReady) {
		this.isReady = isReady ? 1 : 0;
		this.dataManager.set(IS_READY, isReady);
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
		return stack.getItem() == PFBlocks.CRASSOSTREA_OYSTER.asItem();
	}

	public void registerData() {
		super.registerData();
		this.dataManager.register(IS_PREGNANT, false);
		this.dataManager.register(IS_READY, false);
		this.dataManager.register(ALBINO, false);
		this.dataManager.register(MELANISTIC, false);
		this.dataManager.register(NATURAL_LOVE, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("IsPregnant", this.isPregnant());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setPregnant(compound.getBoolean("IsPregnant"));
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
		} else if (birthNumber == 4) {
			this.setMelanistic(true);
		}
		this.setHunger(this.maxHunger);
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new DidelphodonEntity.SwimGoal());
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.25F));
		this.goalSelector.addGoal(0, new DidelphodonEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new DidelphodonEntity.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, PlayerEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, TyrannosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, DakotaraptorEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, AllosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, CeratosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, CamarasaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, TriceratopsEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, AnkylosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, StegosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(10, new EatBerriesGoal((double)1.2F, 12, 2));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, ThescelosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, DryosaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, HesperornithoidesEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, HerrerasaurusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal(this, ExaeretodonEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<SaurosuchusEntity>(this, SaurosuchusEntity.class, 10F, 2D, 2D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<DilophosaurusEntity>(this, DilophosaurusEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(7, new AvoidEntityGoal<MegapnosaurusEntity>(this, MegapnosaurusEntity.class, 10F, 1.2D, 1.5D));
		this.goalSelector.addGoal(0, new DidelphodonEntity.CarryYoungGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CrepuscularSleepGoal(this));
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : SoundInit.DIDELPHODON_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSource) {
		return SoundInit.DIDELPHODON_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.DIDELPHODON_DEATH;
	}

	@Override
	protected void updateAITasks() {
		super.updateAITasks();
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 4.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.23D);
	}

	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 45) {
			ItemStack itemStack = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
			if (!itemStack.isEmpty()) {
				for (int i = 0; i < 8; i++) {
					Vector3d vector3d = (new Vector3d(((double)this.rand.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D)).rotatePitch(-this.rotationPitch * ((float)Math.PI / 180F)).rotateYaw(-this.rotationYaw * ((float)Math.PI / 180F));
					this.world.addParticle(new ItemParticleData(ParticleTypes.ITEM, itemStack), this.getPosX() + this.getLookVec().x / 2.0D,  this.getPosY(), this.getPosZ() + this.getLookVec().z / 2.0D, vector3d.x, vector3d.y + 0.05D, vector3d.z);
				}
			}
		} else {
			super.handleStatusUpdate(id);
		}
	}

	public void tick() {
		super.tick();
		this.interestedAngleO = this.interestedAngle;
		this.interestedAngle += (0.0F - this.interestedAngle) * 0.4F;
	}

	static class MateGoal extends BreedGoal {
		private final DidelphodonEntity didelphodon;

		MateGoal(DidelphodonEntity didelphodon, double speed) {
			super(didelphodon, speed);
			this.didelphodon = didelphodon;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.didelphodon.isPregnant() && !this.didelphodon.isInLoveNaturally();
		}

		protected void spawnBaby() {
			ServerPlayerEntity serverplayerentity = this.animal.getLoveCause();
			if (serverplayerentity == null && this.targetMate.getLoveCause() != null) {
				serverplayerentity = this.targetMate.getLoveCause();
			}
			if (serverplayerentity != null) {
				serverplayerentity.addStat(Stats.ANIMALS_BRED);
				CriteriaTriggers.BRED_ANIMALS.trigger(serverplayerentity, this.animal, this.targetMate, (AgeableEntity)null);
			}
			this.didelphodon.setPregnant(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final DidelphodonEntity didelphodon;

		NaturalMateGoal(DidelphodonEntity didelphodon, double speed) {
			super(didelphodon, speed);
			this.didelphodon = didelphodon;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.didelphodon.isPregnant() && this.didelphodon.getCurrentHunger() >= this.didelphodon.getThreeQuartersHunger() && this.didelphodon.ticksExisted % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.didelphodon.isInLoveNaturally();
		}

		protected void spawnBaby() {
			this.didelphodon.setPregnant(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
		}

	}

	abstract class PassiveGoal extends Goal {
		private PassiveGoal() {
		}

		public abstract boolean canDidelphodonStart();

		public abstract boolean canDidelphodonContinue();

		public boolean shouldExecute() {
			return this.canDidelphodonStart();
		}

		public boolean shouldContinueExecuting() {
			return this.canDidelphodonContinue();
		}
	}

	static class CarryYoungGoal extends Goal {
		private final DidelphodonEntity didelphodon;

		CarryYoungGoal(DidelphodonEntity didelphodon, double speed) {
			super();
			this.didelphodon = didelphodon;
		}

		public boolean shouldExecute() {
			return this.didelphodon.isPregnant();
		}

		public boolean shouldContinueExecuting() {
			return this.didelphodon.isPregnant();
		}

		public void tick() {
			super.tick();
			if (!this.didelphodon.isInWater()) {
				if (this.didelphodon.isReady < 1) {
					this.didelphodon.setReady(true);
				} else if (this.didelphodon.isReady > 200) {
					World world = this.didelphodon.world;
					AgeableEntity ageable = new DidelphodonEntity(PFEntities.DIDELPHODON_ENTITY, world);
					ageable.setGrowingAge(-24000);
					world.addEntity(ageable);
					this.didelphodon.setPregnant(false);
					this.didelphodon.setReady(false);
					this.didelphodon.setInLove(600);
				}
				if (this.didelphodon.isReady()) {
					this.didelphodon.isReady++;
				}
			}
		}

	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		DidelphodonEntity entity = new DidelphodonEntity(PFEntities.DIDELPHODON_ENTITY, this.world);
		entity.onInitialSpawn((IServerWorld)this.world, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}

	class SwimGoal extends net.minecraft.entity.ai.goal.SwimGoal {
		public SwimGoal() {
			super(DidelphodonEntity.this);
		}

		public void startExecuting() {
			super.startExecuting();
		}

		public boolean shouldExecute() {
			return DidelphodonEntity.this.isInWater() && DidelphodonEntity.this.func_233571_b_(FluidTags.WATER) > 0.25D || DidelphodonEntity.this.isInLava();
		}
	}

	public class EatBerriesGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public EatBerriesGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(DidelphodonEntity.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
			return blockstate.isIn(PFBlocks.CRASSOSTREA_OYSTER) && blockstate.get(CrassostreaOysterBlock.AGE) >= 2;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (this.getIsAboveDestination()) {
				if (this.field_220731_g >= 40) {
					this.eatOyster();
				} else {
					++this.field_220731_g;
				}
			} else if (!this.getIsAboveDestination() && DidelphodonEntity.this.rand.nextFloat() < 0.05F) {
			}

			super.tick();
		}

		protected void eatOyster() {
			if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(DidelphodonEntity.this.world, DidelphodonEntity.this)) {
				BlockState blockstate = DidelphodonEntity.this.world.getBlockState(this.destinationBlock);
				if (blockstate.isIn(PFBlocks.CRASSOSTREA_OYSTER)) {
					int i = blockstate.get(CrassostreaOysterBlock.AGE);
					blockstate.with(CrassostreaOysterBlock.AGE, Integer.valueOf(0));
					int j = 1 + DidelphodonEntity.this.world.rand.nextInt(2) + (i == 3 ? 1 : 0);
					ItemStack itemstack = DidelphodonEntity.this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
					if (itemstack.isEmpty()) {
						DidelphodonEntity.this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(PFItems.CRASSOSTREA_OYSTER.get()));
						--j;
					}

					if (j > 0) {
						Block.spawnAsEntity(DidelphodonEntity.this.world, this.destinationBlock, new ItemStack(PFItems.CRASSOSTREA_OYSTER.get(), j));
					}
					DidelphodonEntity.this.world.setBlockState(this.destinationBlock, blockstate.with(CrassostreaOysterBlock.AGE, Integer.valueOf(0)), 2);
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return !DidelphodonEntity.this.isSleeping() && super.shouldExecute();
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
