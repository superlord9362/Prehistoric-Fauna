package superlord.prehistoricfauna.common.entities.triassic.ischigualasto;

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
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
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
import superlord.prehistoricfauna.common.blocks.IschigualastiaEggBlock;
import superlord.prehistoricfauna.common.entities.DinosaurEntity;
import superlord.prehistoricfauna.common.entities.goal.CathemeralSleepGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurLookAtGoal;
import superlord.prehistoricfauna.common.entities.goal.DinosaurRandomLookGoal;
import superlord.prehistoricfauna.config.PrehistoricFaunaConfig;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.SoundInit;

public class IschigualastiaEntity extends DinosaurEntity {

	private static final DataParameter<Boolean> SADDLED = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> BOOST_TIME = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(PFBlocks.CLADOPHLEBIS.asItem());
	private static final DataParameter<Boolean> EATING = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> NATURAL_LOVE = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.BOOLEAN);
	private int maxHunger = 75;
	private int lastInLove = 0;
	private int currentHunger;
	int hungerTick = 0;
	private int warningSoundTicks;
	private int isDigging;
	private boolean boosting;
	private int boostTime;
	public float ridingXZ;
	public float ridingY = 1;
	private int totalBoostTime;
	int loveTick = 0;

	public IschigualastiaEntity(EntityType<? extends IschigualastiaEntity> type, World world) {
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

	public boolean isEating() {
		return this.dataManager.get(EATING);
	}

	private void setEating(boolean isEating) {
		this.dataManager.set(EATING, isEating);
	}

	public int getThreeQuartersHunger() {
		return (maxHunger / 4) * 3;
	}

	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
	}

	public boolean canBeSteered() {
		Entity entity = this.getControllingPassenger();
		if (!(entity instanceof PlayerEntity)) {
			return false;
		} else {
			PlayerEntity playerentity = (PlayerEntity)entity;
			return playerentity.getHeldItemMainhand().getItem() == PFItems.CLADOPHEBLIS_STICK.get() || playerentity.getHeldItemOffhand().getItem() == PFItems.CLADOPHEBLIS_STICK.get();
		}
	}

	@Override
	public void updatePassenger(Entity passenger) {
		super.updatePassenger(passenger);

		float radius = ridingXZ * 0.7F * -3;
		float angle = (0.01745329251F * this.renderYawOffset);
		double extraX = radius * MathHelper.sin((float) (Math.PI + angle));
		double extraZ = radius * MathHelper.cos(angle);
		double extraY = ridingY * 4;
		this.getRidingPlayer().setPosition(this.getPosX() + extraX, this.getPosY() + extraY - 2.75F, this.getPosZ() + extraZ);
	}

	public PlayerEntity getRidingPlayer() {
		if (this.getControllingPassenger() instanceof PlayerEntity) {
			return (PlayerEntity) getControllingPassenger();
		} else {
			return null;
		}
	}

	public void notifyDataManagerChange(DataParameter<?> key) {
		if (BOOST_TIME.equals(key) && this.world.isRemote) {
			this.boosting = true;
			this.boostTime = 0;
			this.totalBoostTime = this.dataManager.get(BOOST_TIME);
		}

		super.notifyDataManagerChange(key);
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == PFBlocks.CLADOPHLEBIS.asItem();
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new IschigualastiaEntity.MeleeAttackGoal());
		this.goalSelector.addGoal(1, new IschigualastiaEntity.PanicGoal());
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.fromItems(PFItems.CLADOPHEBLIS_STICK.get()), false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new DinosaurLookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(6, new DinosaurRandomLookGoal(this));
		this.targetSelector.addGoal(1, new IschigualastiaEntity.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new IschigualastiaEntity.AttackPlayerGoal());
		this.goalSelector.addGoal(0, new IschigualastiaEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new IschigualastiaEntity.MateGoal(this, 1.0D));
		this.goalSelector.addGoal(0, new IschigualastiaEntity.NaturalMateGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new CathemeralSleepGoal(this));
		this.goalSelector.addGoal(0, new IschigualastiaEntity.HerbivoreEatGoal((double)1.2F, 12, 2));
	}
	
	public void livingTick() {
		super.livingTick();
		if (this.isAsleep()) {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
		} else {
			this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.22D);
		}
		List<IschigualastiaEntity> list = this.world.getEntitiesWithinAABB(this.getClass(), this.getBoundingBox().grow(20.0D, 20.0D, 20.0D));
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
				if (lastInLove == 0 && currentHunger >= getThreeQuartersHunger() && ticksExisted % 900 == 0 && !this.isChild() && !this.isInLove() && !this.isAsleep() && list.size() < 10) {
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
			if (lastInLove == 0 && naturalBreedingChance == 0 && !this.isChild() && !this.isInLove() && !this.isAsleep() && list.size() < 10) {
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
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 30.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.22D).createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 7.0D).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.25D);
	}

	protected SoundEvent getAmbientSound() {
		return this.isAsleep() ? null : SoundInit.ISCHIGUALASTIA_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.ISCHIGUALASTIA_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.ISCHIGUALASTIA_DEATH;
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundInit.ISCHIGUALASTIA_WARN, 1.0F, this.getSoundPitch());
			this.warningSoundTicks = 40;
		}
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(HAS_EGG, false);
		this.dataManager.register(IS_DIGGING, false);
		this.dataManager.register(SADDLED, false);
		this.dataManager.register(BOOST_TIME, 0);
		this.dataManager.register(ALBINO, false);
		this.dataManager.register(MELANISTIC, false);
		this.dataManager.register(EATING, false);
		this.dataManager.register(NATURAL_LOVE, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("Saddle", this.getSaddled());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("MaxHunger", this.currentHunger);
		compound.putBoolean("IsEating", this.isEating());
		compound.putBoolean("InNaturalLove", this.isInLoveNaturally());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setSaddled(compound.getBoolean("Saddle"));
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
		this.setHunger(75);
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		if (itemstack.getItem() == Items.NAME_TAG) {
			itemstack.interactWithEntity(player, this, hand);
		} else if (this.getSaddled() && !this.isBeingRidden()) {
			if (!this.world.isRemote) {
				player.startRiding(this);
			}
		} else if (this.isAlive() && !this.getSaddled() && !this.isChild() && itemstack.getItem() == Items.SADDLE) {
			this.setSaddled(true);
			this.world.playSound(player, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_PIG_SADDLE, SoundCategory.NEUTRAL, 0.5F, 1.0F);
			itemstack.shrink(1);
		}
		return super.func_230254_b_(player, hand);
	}

	protected void dropInventory() {
		super.dropInventory();
		if (this.getSaddled()) {
			this.entityDropItem(Items.SADDLE);
		}
	}

	public boolean getSaddled() {
		return this.dataManager.get(SADDLED);
	}

	public void setSaddled(boolean saddled) {
		if (saddled) {
			this.dataManager.set(SADDLED, true);
		} else {
			this.dataManager.set(SADDLED, false);
		}
	}

	public void travel(Vector3d positionIn) {
		if (this.isAlive()) {
			Entity entity = this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
			if (this.isBeingRidden() && this.canBeSteered()) {
				this.rotationYaw = entity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = entity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.renderYawOffset = this.rotationYaw;
				this.rotationYawHead = this.rotationYaw;
				this.stepHeight = 1.0F;
				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
				if (this.boosting && this.boostTime++ > this.totalBoostTime) {
					this.boosting = false;
				}
				if (this.canPassengerSteer()) {
					float f = (float)this.getAttribute(Attributes.MOVEMENT_SPEED).getValue() * 0.225F;
					if (this.boosting) {
						f += f * 1.15F * MathHelper.sin((float)this.boostTime / (float)this.totalBoostTime * (float)Math.PI);
					}
					this.setAIMoveSpeed(f);
					super.travel(new Vector3d(0.0D, 0.0D, 1.0D));
					this.newPosRotationIncrements = 0;
				} else {
					this.setMotion(Vector3d.ZERO);
				}
				this.prevLimbSwingAmount = this.limbSwingAmount;
				double d1 = this.getPosX() - this.prevPosX;
				double d0 = this.getPosZ() - this.prevPosZ;
				float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
				if (f1 > 1.0F) {
					f1 = 1.0F;
				}
				this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
				this.limbSwing += this.limbSwingAmount;
			} else {
				this.stepHeight = 0.5F;
				this.jumpMovementFactor = 0.02F;
				super.travel(positionIn);
			}
		}
	}

	public boolean boost() {
		if (this.boosting) {
			return false;
		} else {
			this.boosting = true;
			this.boostTime = 0;
			this.totalBoostTime = this.getRNG().nextInt(841) + 140;
			this.getDataManager().set(BOOST_TIME, this.totalBoostTime);
			return true;
		}
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
		}

		return flag;
	}	

	class AttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public AttackPlayerGoal() {
			super(IschigualastiaEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		public boolean shouldExecute() {
			if (IschigualastiaEntity.this.isChild()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for(IschigualastiaEntity ischigualastia : IschigualastiaEntity.this.world.getEntitiesWithinAABB(IschigualastiaEntity.class, IschigualastiaEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
						if (ischigualastia.isChild()) {
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
			super(IschigualastiaEntity.this);
		}

		public void startExecuting() {
			super.startExecuting();
			if (IschigualastiaEntity.this.isChild()) {
				this.alertOthers();
				this.resetTask();
			}
		}

		protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
			if (mobIn instanceof IschigualastiaEntity && !mobIn.isChild()) {
				super.setAttackTarget(mobIn, targetIn);
			}
		}
	}

	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(IschigualastiaEntity.this, 1.25D, true);
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
					IschigualastiaEntity.this.playWarningSound();
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
			return (double)(6.0F + attackTarget.getWidth());
		}
	}

	class PanicGoal extends net.minecraft.entity.ai.goal.PanicGoal {
		public PanicGoal() {
			super(IschigualastiaEntity.this, 2.0D);
		}

		public boolean shouldExecute() {
			return !IschigualastiaEntity.this.isChild() && !IschigualastiaEntity.this.isBurning() ? false : super.shouldExecute();
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final IschigualastiaEntity ischigualastia;

		LayEggGoal(IschigualastiaEntity ischigualastia, double speedIn) {
			super(ischigualastia, speedIn, 16);
			this.ischigualastia = ischigualastia;
		}

		public boolean shouldExecute() {
			return this.ischigualastia.hasEgg() ? super.shouldExecute() : false;
		}

		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && this.ischigualastia.hasEgg();
		}

		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.ischigualastia.getPositionVec());
			if (!this.ischigualastia.isInWater() && this.getIsAboveDestination()) {
				if (this.ischigualastia.isDigging < 1) {
					this.ischigualastia.setDigging(true);
				} else if (this.ischigualastia.isDigging > 200) {
					World world = this.ischigualastia.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.ISCHIGUALASTIA_EGG.getDefaultState().with(IschigualastiaEggBlock.EGGS, Integer.valueOf(this.ischigualastia.rand.nextInt(4) + 1)), 3);
					this.ischigualastia.setHasEgg(false);
					this.ischigualastia.setDigging(false);
					this.ischigualastia.setInLove(600);
				}
				if (this.ischigualastia.isDigging()) {
					this.ischigualastia.isDigging++;
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
		private final IschigualastiaEntity ischigualastia;

		MateGoal(IschigualastiaEntity ischigualastia, double speedIn) {
			super(ischigualastia, speedIn);
			this.ischigualastia = ischigualastia;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.ischigualastia.hasEgg() && !this.ischigualastia.isInLoveNaturally();
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

			this.ischigualastia.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}
		}
	}

	static class NaturalMateGoal extends BreedGoal {
		private final IschigualastiaEntity ischigualastia;

		NaturalMateGoal(IschigualastiaEntity ischigualastia, double speed) {
			super(ischigualastia, speed);
			this.ischigualastia = ischigualastia;
		}

		public boolean shouldExecute() {
			return super.shouldExecute() && !this.ischigualastia.hasEgg() && this.ischigualastia.getCurrentHunger() >= this.ischigualastia.getThreeQuartersHunger() && this.ischigualastia.ticksExisted % 60 == 0 && (PrehistoricFaunaConfig.naturalEggBlockLaying || PrehistoricFaunaConfig.naturalEggItemLaying) && this.ischigualastia.isInLoveNaturally();
		}

		protected void spawnBaby() {
			if (PrehistoricFaunaConfig.naturalEggItemLaying) {
				this.ischigualastia.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.ischigualastia.rand.nextFloat() - this.ischigualastia.rand.nextFloat()) * 0.2F + 1.0F);
				int eggAmount = this.ischigualastia.rand.nextInt(4);
				if (eggAmount == 0) {
					this.ischigualastia.entityDropItem(PFBlocks.ISCHIGUALASTIA_EGG.asItem());
				}
				if (eggAmount == 1) {
					this.ischigualastia.entityDropItem(PFBlocks.ISCHIGUALASTIA_EGG.asItem());
					this.ischigualastia.entityDropItem(PFBlocks.ISCHIGUALASTIA_EGG.asItem());
				}
				if (eggAmount == 2) {
					this.ischigualastia.entityDropItem(PFBlocks.ISCHIGUALASTIA_EGG.asItem());
					this.ischigualastia.entityDropItem(PFBlocks.ISCHIGUALASTIA_EGG.asItem());
					this.ischigualastia.entityDropItem(PFBlocks.ISCHIGUALASTIA_EGG.asItem());
				}
				if (eggAmount == 3) {
					this.ischigualastia.entityDropItem(PFBlocks.ISCHIGUALASTIA_EGG.asItem());
					this.ischigualastia.entityDropItem(PFBlocks.ISCHIGUALASTIA_EGG.asItem());
					this.ischigualastia.entityDropItem(PFBlocks.ISCHIGUALASTIA_EGG.asItem());
					this.ischigualastia.entityDropItem(PFBlocks.ISCHIGUALASTIA_EGG.asItem());
				}
			} else {
				this.ischigualastia.setHasEgg(true);
			}
			this.animal.resetInLove();
			this.targetMate.resetInLove();
		}

	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		IschigualastiaEntity entity = new IschigualastiaEntity(PFEntities.ISCHIGUALASTIA_ENTITY, this.world);
		entity.onInitialSpawn(p_241840_1_, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}
	
	public class HerbivoreEatGoal extends MoveToBlockGoal {
		protected int field_220731_g;

		public HerbivoreEatGoal(double p_i50737_2_, int p_i50737_4_, int p_i50737_5_) {
			super(IschigualastiaEntity.this, p_i50737_2_, p_i50737_4_, p_i50737_5_);
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
					IschigualastiaEntity.this.setEating(true);
				}
				if (this.field_220731_g % 5 == 1) {
					IschigualastiaEntity.this.world.playSound((PlayerEntity)null, this.destinationBlock, SoundEvents.BLOCK_GRASS_HIT, SoundCategory.NEUTRAL, 1, 1);
				}
			}
			super.tick();
		}

		protected void eatBerry() {
			BlockState blockstate = IschigualastiaEntity.this.world.getBlockState(this.destinationBlock);
			int hunger = IschigualastiaEntity.this.getCurrentHunger();

			if (blockstate.isIn(PFBlocks.DEAD_OSMUNDACAULIS)) {
				if (hunger + 2 >= IschigualastiaEntity.this.maxHunger) {
					IschigualastiaEntity.this.setHunger(IschigualastiaEntity.this.maxHunger);
				} else {
					IschigualastiaEntity.this.setHunger(hunger + 2);
				}
			}
			if (blockstate.isIn(Blocks.GRASS) || blockstate.isIn(Blocks.TALL_GRASS) || blockstate.isIn(BlockTags.FLOWERS)) {
				if (hunger + 4 >= IschigualastiaEntity.this.maxHunger) {
					IschigualastiaEntity.this.setHunger(IschigualastiaEntity.this.maxHunger);
				} else {
					IschigualastiaEntity.this.setHunger(hunger + 4);
				}
			}
			if (blockstate.isIn(Blocks.VINE)) {
				if (hunger + 6 >= IschigualastiaEntity.this.maxHunger) {
					IschigualastiaEntity.this.setHunger(IschigualastiaEntity.this.maxHunger);
				} else {
					IschigualastiaEntity.this.setHunger(hunger + 6);
				}
			}
			if (blockstate.isIn(PFBlocks.MARCHANTIA) || blockstate.isIn(PFBlocks.OSMUNDACAULIS) || blockstate.isIn(PFBlocks.OTOZAMITES)) {
				if (hunger + 8 >= IschigualastiaEntity.this.maxHunger) {
					IschigualastiaEntity.this.setHunger(IschigualastiaEntity.this.maxHunger);
				} else {
					IschigualastiaEntity.this.setHunger(hunger + 8);
				}
			}
			if (blockstate.isIn(PFBlocks.HORSETAIL) || blockstate.isIn(PFBlocks.CLUBMOSS) || blockstate.isIn(PFBlocks.MICHELILLOA) || blockstate.isIn(PFBlocks.COBBANIA) || blockstate.isIn(PFBlocks.LAUROZAMITES) || blockstate.isIn(PFBlocks.CLATHOPTERIS)) {
				if (hunger + 10 >= IschigualastiaEntity.this.maxHunger) {
					IschigualastiaEntity.this.setHunger(IschigualastiaEntity.this.maxHunger);
				} else {
					IschigualastiaEntity.this.setHunger(hunger + 10);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_OSMUNDACAULIS) || blockstate.isIn(PFBlocks.TALL_OTOZAMITES)) {
				if (hunger + IschigualastiaEntity.this.maxHunger >= 25) {
					IschigualastiaEntity.this.setHunger(IschigualastiaEntity.this.maxHunger);
				} else {
					IschigualastiaEntity.this.setHunger(hunger + 12);
				}
			}
			if (blockstate.isIn(PFBlocks.OSMUNDA) || blockstate.isIn(Blocks.FERN) || blockstate.isIn(PFBlocks.CONIOPTERIS) || blockstate.isIn(PFBlocks.CLADOPHLEBIS)) {
				if (hunger + 15 >= IschigualastiaEntity.this.maxHunger) {
					IschigualastiaEntity.this.setHunger(IschigualastiaEntity.this.maxHunger);
				} else {
					IschigualastiaEntity.this.setHunger(hunger + 15);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_HORSETAIL) || blockstate.isIn(PFBlocks.SCYTOPHYLLUM)) {
				if (hunger + 20 >= IschigualastiaEntity.this.maxHunger) {
					IschigualastiaEntity.this.setHunger(IschigualastiaEntity.this.maxHunger);
				} else {
					IschigualastiaEntity.this.setHunger(hunger + 20);
				}
			}
			if (blockstate.isIn(PFBlocks.TALL_OSMUNDA) || blockstate.isIn(Blocks.LARGE_FERN) || blockstate.isIn(PFBlocks.JOHNSTONIA)) {
				if (hunger + 25 >= IschigualastiaEntity.this.maxHunger) {
					IschigualastiaEntity.this.setHunger(IschigualastiaEntity.this.maxHunger);
				} else {
					IschigualastiaEntity.this.setHunger(hunger + 25);
				}
			}
			if (blockstate.isIn(PFBlocks.DICROIDIUM)) {
				if (hunger + 30 >= IschigualastiaEntity.this.maxHunger) {
					IschigualastiaEntity.this.setHunger(IschigualastiaEntity.this.maxHunger);
				} else {
					IschigualastiaEntity.this.setHunger(hunger + 30);
				}
			}
			IschigualastiaEntity.this.setEating(false);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return !IschigualastiaEntity.this.isAsleep() && super.shouldExecute() && IschigualastiaEntity.this.getCurrentHunger() < IschigualastiaEntity.this.getHalfHunger();
		}

		public boolean shouldContinueExecuting() {
			if (IschigualastiaEntity.this.getCurrentHunger() >= IschigualastiaEntity.this.maxHunger || IschigualastiaEntity.this.isAsleep()) {
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
