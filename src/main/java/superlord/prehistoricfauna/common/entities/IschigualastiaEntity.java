package superlord.prehistoricfauna.common.entities;

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
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.AnimalEntity;
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
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.common.blocks.IschigualastiaEggBlock;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.SoundInit;

public class IschigualastiaEntity extends AnimalEntity {

	private static final DataParameter<Boolean> SADDLED = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> BOOST_TIME = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(IschigualastiaEntity.class, DataSerializers.BOOLEAN);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(PFBlocks.CLADOPHLEBIS.asItem());
	private int warningSoundTicks;
	private int isDigging;
	private boolean boosting;
	private int boostTime;
	public float ridingXZ;
	public float ridingY = 1;
	private int totalBoostTime;

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
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(1, new IschigualastiaEntity.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new IschigualastiaEntity.AttackPlayerGoal());
		this.goalSelector.addGoal(8, new IschigualastiaEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new IschigualastiaEntity.MateGoal(this, 1.0D));
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 30.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.22D).createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 7.0D);
	}

	protected SoundEvent getAmbientSound() {
		return SoundInit.ISCHIGUALASTIA_IDLE;
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
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("Saddle", this.getSaddled());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setSaddled(compound.getBoolean("Saddle"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
	}
	
	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		Random rand = new Random();
		int birthNumber = rand.nextInt(399);
		if (birthNumber >= 0 && birthNumber < 4) {
			this.setAlbino(true);
		} else if (birthNumber >= 4 && birthNumber < 7) {
			this.setMelanistic(true);
		}
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

	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(Attributes.ATTACK_DAMAGE).getValue()));
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
			return (double)(4.0F + attackTarget.getWidth());
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
				return block == PFBlocks.LOAM || block == PFBlocks.PACKED_LOAM || block == Blocks.PODZOL;
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
			return super.shouldExecute() && !this.ischigualastia.hasEgg();
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

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		IschigualastiaEntity entity = new IschigualastiaEntity(PFEntities.ISCHIGUALASTIA_ENTITY, this.world);
		entity.onInitialSpawn(p_241840_1_, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
	}

}
