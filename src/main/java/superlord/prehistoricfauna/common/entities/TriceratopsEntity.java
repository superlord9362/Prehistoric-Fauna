package superlord.prehistoricfauna.common.entities;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.passive.horse.AbstractChestedHorseEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
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
import superlord.prehistoricfauna.common.blocks.TriceratopsEggBlock;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;
import superlord.prehistoricfauna.init.SoundInit;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

public class TriceratopsEntity extends AbstractChestedHorseEntity  {
	private static final DataParameter<Boolean> HAS_EGG = EntityDataManager.createKey(TriceratopsEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_DIGGING = EntityDataManager.createKey(TriceratopsEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IS_JUVENILE = EntityDataManager.createKey(TriceratopsEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALBINO = EntityDataManager.createKey(TriceratopsEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MELANISTIC = EntityDataManager.createKey(TriceratopsEntity.class, DataSerializers.BOOLEAN);
	private int warningSoundTicks;
	private int isDigging;
	public float ridingXZ;
	public float ridingY = 1;
	private boolean allowStandSliding;
	public int attackTick;

	public TriceratopsEntity(EntityType<? extends TriceratopsEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public AgeableEntity createChild(AgeableEntity ageable) {
		TriceratopsEntity entity = new TriceratopsEntity(PFEntities.TRICERATOPS_ENTITY, this.world);
		entity.onInitialSpawn((IServerWorld) this.world, this.world.getDifficultyForLocation(new BlockPos(entity.getPositionVec())), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
		return entity;
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

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == PFBlocks.OSMUNDA.asItem();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new TriceratopsEntity.PanicGoal());
		this.goalSelector.addGoal(4, new TriceratopsFollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(9, new AvoidEntityGoal(this, AnkylosaurusEntity.class, 7F, 1.25D, 1.25D));
		this.targetSelector.addGoal(1, new TriceratopsEntity.HurtByTargetGoal());
		this.targetSelector.addGoal(2, new TriceratopsEntity.AttackPlayerGoal());
		this.goalSelector.addGoal(1, new TriceratopsEntity.MeleeAttackGoal());
		this.goalSelector.addGoal(8, new TriceratopsEntity.LayEggGoal(this, 1.0D));
		this.goalSelector.addGoal(2, new TriceratopsEntity.MateGoal(this, 1.0D));
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 60.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, (double)0.2F).createMutableAttribute(Attributes.ATTACK_DAMAGE, 10.0D).createMutableAttribute(Attributes.FOLLOW_RANGE, 20.0D);
	}

	protected SoundEvent getAmbientSound() {
		return SoundInit.TRICERATOPS_IDLE;
	}

	@Override
	protected void playGallopSound(SoundType p_190680_1_) {
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.TRICERATOPS_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundInit.TRICERATOPS_DEATH;
	}

	protected SoundEvent getAngrySound() {
		return SoundInit.TRICERATOPS_WARN;
	}

	@Override	
	public boolean onLivingFall(float distance, float damageMultiplier) {
		if (distance > 1.0F) {
			this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
		}

		int i = this.calculateFallDamage(distance, damageMultiplier);
		if (i <= 0) {
			return false;
		} else {
			this.attackEntityFrom(DamageSource.FALL, (float)i);
			if (this.isBeingRidden()) {
				for(Entity entity : this.getRecursivePassengers()) {
					entity.attackEntityFrom(DamageSource.FALL, (float)i);
				}
			}

			this.playFallSound();
			return true;
		}
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}

	protected void playWarningSound() {
		if (this.warningSoundTicks <= 0) {
			this.playSound(SoundInit.TRICERATOPS_WARN, 1.0F, this.getSoundPitch());
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
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("HasEgg", this.hasEgg());
		compound.putBoolean("IsAlbino", this.isAlbino());
		compound.putBoolean("IsMelanistic", this.isMelanistic());
		compound.putInt("AttackTick", this.attackTick);
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setHasEgg(compound.getBoolean("HasEgg"));
		this.setAlbino(compound.getBoolean("IsAlbino"));
		this.setMelanistic(compound.getBoolean("IsMelanistic"));
		this.attackTick = compound.getInt("AttackTick");
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

	public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
		World world = p_230254_1_.world;
		ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
		Item item = itemstack.getItem();
		if (!this.isChild()) {
			if (item == PFItems.TRICERATOPS_SPAWN_EGG.get()) {
				TriceratopsEntity triceratopsentity = PFEntities.TRICERATOPS_ENTITY.create(world);
				triceratopsentity.setGrowingAge(-24000);
				triceratopsentity.setLocationAndAngles((double)this.getPosX() + 0.3D * 0.2D, (double)this.getPosY(), (double)this.getPosZ() + 0.3D, 0.0F, 0.0F);
				world.addEntity(triceratopsentity);
				return super.func_230254_b_(p_230254_1_, p_230254_2_);
			}
			if (this.isTame() && p_230254_1_.isSecondaryUseActive()) {
				this.openGUI(p_230254_1_);
				return ActionResultType.func_233537_a_(this.world.isRemote);
			}

			if (this.isBeingRidden()) {
				return super.func_230254_b_(p_230254_1_, p_230254_2_);
			}
		}

		if (!itemstack.isEmpty()) {
			if (this.isBreedingItem(itemstack)) {
				return this.func_241395_b_(p_230254_1_, itemstack);
			}

			if (!this.isTame()) {
				this.makeMad();
				return ActionResultType.func_233537_a_(this.world.isRemote);
			}

			if (!this.hasChest() && itemstack.getItem() == Blocks.CHEST.asItem()) {
				this.setChested(true);
				this.playChestEquipSound();
				if (!p_230254_1_.abilities.isCreativeMode) {
					itemstack.shrink(1);
				}

				this.initHorseChest();
				return ActionResultType.func_233537_a_(this.world.isRemote);
			}

			if (!this.isChild() && !this.isHorseSaddled() && itemstack.getItem() == Items.SADDLE) {
				this.openGUI(p_230254_1_);
				return ActionResultType.func_233537_a_(this.world.isRemote);
			}
		}


		if (this.isChild()) {
			if (item == PFItems.TRICERATOPS_SPAWN_EGG.get()) {
				TriceratopsEntity triceratopsentity = PFEntities.TRICERATOPS_ENTITY.create(world);
				triceratopsentity.setGrowingAge(-24000);
				triceratopsentity.setLocationAndAngles((double)this.getPosX() + 0.3D * 0.2D, (double)this.getPosY(), (double)this.getPosZ() + 0.3D, 0.0F, 0.0F);
				world.addEntity(triceratopsentity);
				return super.func_230254_b_(p_230254_1_, p_230254_2_);
			} else {
				return super.func_230254_b_(p_230254_1_, p_230254_2_);
			}
		} else {
			this.mountTo(p_230254_1_);
			return ActionResultType.func_233537_a_(this.world.isRemote);
		}
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

	@Override
	public void livingTick() {
		super.livingTick();
		if (this.isAlive()) {
			if (this.attackTick > 0) {
				--this.attackTick;
			}
		}
	}

	public PlayerEntity getRidingPlayer() {
		if (this.getControllingPassenger() instanceof PlayerEntity) {
			return (PlayerEntity) getControllingPassenger();
		} else {
			return null;
		}
	}

	@Override
	public void updatePassenger(Entity passenger) {
		super.updatePassenger(passenger);
		if (this.isPassenger(passenger)) {
			renderYawOffset = rotationYaw;
			this.rotationYaw = passenger.rotationYaw;
		}
		if (this.getRidingPlayer() != null && this.getRidingPlayer() instanceof PlayerEntity && this.getAttackTarget() != this.getRidingPlayer()) {
			rotationYaw = renderYawOffset;
			rotationYaw = this.getRidingPlayer().rotationYaw;
			rotationYawHead = this.getRidingPlayer().rotationYaw;
			float radius = ridingXZ * 0.7F * -3;
			float angle = (0.01745329251F * this.renderYawOffset);
			double extraX = radius * MathHelper.sin((float) (Math.PI + angle));
			double extraZ = radius * MathHelper.cos(angle);
			double extraY = ridingY * 4;
			this.getRidingPlayer().setPosition(this.getPosX() + extraX, this.getPosY() + extraY - 1.75F, this.getPosZ() + extraZ);
		}
	}

	public void travel(Vector3d positionIn) {
		if (this.isAlive()) {
			if (this.isBeingRidden() && this.canBeSteered() && this.isHorseSaddled()) {
				LivingEntity livingentity = (LivingEntity)this.getControllingPassenger();
				this.rotationYaw = livingentity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = livingentity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.renderYawOffset = this.rotationYaw;
				this.rotationYawHead = this.renderYawOffset;
				float f = livingentity.moveStrafing * 0.5F;
				float f1 = livingentity.moveForward;
				if (f1 <= 0.0F) {
					f1 *= 0.25F;
					this.gallopTime = 0;
				}

				if (this.onGround && this.jumpPower == 0.0F && this.isRearing() && !this.allowStandSliding) {
					f = 0.0F;
					f1 = 0.0F;
				}

				if (this.jumpPower > 0.0F && !this.isHorseJumping() && this.onGround) {
					double d0 = 0;
					double d1;
					if (this.isPotionActive(Effects.JUMP_BOOST)) {
						d1 = d0 + (double)((float)(this.getActivePotionEffect(Effects.JUMP_BOOST).getAmplifier() + 1) * 0.1F);
					} else {
						d1 = d0;
					}

					Vector3d vec3d = this.getMotion();
					this.setMotion(vec3d.x, d1, vec3d.z);
					this.setHorseJumping(true);
					this.isAirBorne = true;
					net.minecraftforge.common.ForgeHooks.onLivingJump(this);
					if (f1 > 0.0F) {
						float f2 = MathHelper.sin(this.rotationYaw * ((float)Math.PI / 180F));
						float f3 = MathHelper.cos(this.rotationYaw * ((float)Math.PI / 180F));
						this.setMotion(this.getMotion().add((double)(-0.4F * f2 * this.jumpPower), 0.0D, (double)(0.4F * f3 * this.jumpPower)));
					}

					this.jumpPower = 0.0F;
				}

				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
				if (this.canPassengerSteer()) {
					this.setAIMoveSpeed((float)this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
					super.travel(new Vector3d((double)f, positionIn.y, (double)f1));
				} else if (livingentity instanceof PlayerEntity) {
					this.setMotion(Vector3d.ZERO);
				}

				if (this.onGround) {
					this.jumpPower = 0.0F;
					this.setHorseJumping(false);
				}
			} else {
				this.jumpMovementFactor = 0.02F;
				super.travel(positionIn);
			}
		}
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getAttribute(Attributes.ATTACK_DAMAGE).getValue()));
		if (flag) {
			this.applyEnchantments(this, entityIn);
		}

		return flag;
	}	

	@Override
	protected void setOffspringAttributes(AgeableEntity p_190681_1_, AbstractHorseEntity p_190681_2_) {
		double d0 = this.getBaseAttributeValue(Attributes.MAX_HEALTH);
		p_190681_2_.getAttribute(Attributes.MAX_HEALTH).setBaseValue(d0);
		double d2 = this.getBaseAttributeValue(Attributes.MOVEMENT_SPEED);
		p_190681_2_.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(d2);
	}

	class AttackPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
		public AttackPlayerGoal() {
			super(TriceratopsEntity.this, PlayerEntity.class, 20, true, true, (Predicate<LivingEntity>)null);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			if (TriceratopsEntity.this.isChild() && !TriceratopsEntity.this.isJuvenile() || TriceratopsEntity.this.isTame()) {
				return false;
			} else {
				if (super.shouldExecute()) {
					for(TriceratopsEntity triceratops : TriceratopsEntity.this.world.getEntitiesWithinAABB(TriceratopsEntity.class, TriceratopsEntity.this.getBoundingBox().grow(8.0D, 4.0D, 8.0D))) {
						if (triceratops.isChild() && !triceratops.isJuvenile()) {
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

	@Override
	protected float getModifiedMaxHealth() {
		return this.getMaxHealth();
	}

	class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
		public HurtByTargetGoal() {
			super(TriceratopsEntity.this);
		}

		public void startExecuting() {
			super.startExecuting();
			if (TriceratopsEntity.this.isChild() && !TriceratopsEntity.this.isJuvenile()) {
				this.alertOthers();
				this.resetTask();
			}

		}

		protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
			if (mobIn instanceof TriceratopsEntity && !mobIn.isChild()) {
				super.setAttackTarget(mobIn, targetIn);
			}

		}
	}

	class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
		public MeleeAttackGoal() {
			super(TriceratopsEntity.this, 1.25D, true);
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
					TriceratopsEntity.this.playWarningSound();
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
			super(TriceratopsEntity.this, 2.0D);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return !TriceratopsEntity.this.isChild() && !TriceratopsEntity.this.isBurning() ? false : super.shouldExecute();
		}
	}

	static class LayEggGoal extends MoveToBlockGoal {
		private final TriceratopsEntity triceratops;

		LayEggGoal(TriceratopsEntity triceratops, double speedIn) {
			super(triceratops, speedIn, 16);
			this.triceratops = triceratops;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return this.triceratops.hasEgg() ? super.shouldExecute() : false;
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && this.triceratops.hasEgg();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			super.tick();
			BlockPos blockpos = new BlockPos(this.triceratops.getPositionVec());
			if (!this.triceratops.isInWater() && this.getIsAboveDestination()) {
				if (this.triceratops.isDigging < 1) {
					this.triceratops.setDigging(true);
				} else if (this.triceratops.isDigging > 200) {
					World world = this.triceratops.world;
					world.playSound((PlayerEntity)null, blockpos, SoundEvents.ENTITY_TURTLE_LAY_EGG, SoundCategory.BLOCKS, 0.3F, 0.9F + world.rand.nextFloat() * 0.2F);
					world.setBlockState(this.destinationBlock.up(), PFBlocks.TRICERATOPS_EGG.getDefaultState().with(TriceratopsEggBlock.EGGS, Integer.valueOf(this.triceratops.rand.nextInt(4) + 1)), 3);
					this.triceratops.setHasEgg(false);
					this.triceratops.setDigging(false);
					this.triceratops.setInLove(600);
				}

				if (this.triceratops.isDigging()) {
					this.triceratops.isDigging++;
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
				return block == PFBlocks.LOAM || block == PFBlocks.MOSSY_DIRT || block == Blocks.PODZOL;
			}
		}
	}

	static class MateGoal extends BreedGoal {
		private final TriceratopsEntity triceratops;

		MateGoal(TriceratopsEntity triceratops, double speedIn) {
			super(triceratops, speedIn);
			this.triceratops = triceratops;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
		 * method as well.
		 */
		public boolean shouldExecute() {
			return super.shouldExecute() && !this.triceratops.hasEgg();
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

			this.triceratops.setHasEgg(true);
			this.animal.resetInLove();
			this.targetMate.resetInLove();
			Random random = this.animal.getRNG();
			if (this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
				this.world.addEntity(new ExperienceOrbEntity(this.world, this.animal.getPosX(), this.animal.getPosY(), this.animal.getPosZ(), random.nextInt(7) + 1));
			}

		}
	}

	@Override
	protected boolean handleEating(PlayerEntity player, ItemStack stack) {
		boolean flag = false;
		float f = 0.0F;
		int i = 0;
		Item item = stack.getItem();
		if (item == PFBlocks.HORSETAIL.asItem()) {
			f = 2.0F;
			i = 20;
		} else if (item == PFBlocks.TALL_HORSETAIL.asItem()) {
			f = 1.0F;
			i = 30;
		} else if (item == PFBlocks.OSMUNDA.asItem()) {
			f = 20.0F;
			i = 180;
			if (this.getGrowingAge() == 0 && !this.isInLove()) {
				flag = true;
				this.setInLove(player);
			}
		} else if (item == PFBlocks.TALL_OSMUNDA.asItem()) {
			f = 3.0F;
			i = 60;
		} else if (item == PFBlocks.CLUBMOSS.asItem()) {
			f = 4.0F;
			i = 60;
		} else if (item == PFBlocks.MARCHANTIA.asItem()) {
			f = 3.0F;
			i = 80;
		}

		if (this.getHealth() < this.getMaxHealth() && f > 0.0F) {
			this.heal(f);
			flag = true;
		}

		if (this.isChild() && i > 0) {
			this.world.addParticle(ParticleTypes.HAPPY_VILLAGER, this.getPosXRandom(1.0D), this.getPosYRandom() + 0.5D, this.getPosZRandom(1.0D), 0.0D, 0.0D, 0.0D);
			if (!this.world.isRemote) {
				this.addGrowth(i);
			}

			flag = true;
		}

		return flag;
	}

	class TriceratopsFollowParentGoal extends Goal {
		private final TriceratopsEntity babyTriceratopsEntity;
		private TriceratopsEntity parentTriceratopsEntity;
		private final double moveSpeed;
		private int delayCounter;

		public TriceratopsFollowParentGoal(TriceratopsEntity triceratops, double speed) {
			this.babyTriceratopsEntity = triceratops;
			this.moveSpeed = speed;
		}

		public boolean shouldExecute() {
			if (this.babyTriceratopsEntity.isChild() && !this.babyTriceratopsEntity.isJuvenile()) {
				List<TriceratopsEntity> list = this.babyTriceratopsEntity.world.getEntitiesWithinAABB(this.babyTriceratopsEntity.getClass(), this.babyTriceratopsEntity.getBoundingBox().grow(8.0D, 4.0D, 8.0D));
				TriceratopsEntity triceratopsEntity = null;
				double d0 = Double.MAX_VALUE;
				for (TriceratopsEntity triceratopsEntity1 : list) {
					if (!triceratopsEntity1.isChild()) {
						double d1 = this.babyTriceratopsEntity.getDistanceSq(triceratopsEntity1);
						if (!(d1 > d0)) {
							d0 = d1;
							triceratopsEntity = triceratopsEntity1;
						}
					}
				}
				if (triceratopsEntity == null) {
					return false;
				} else if (d0 < 9.0D) {
					return false;
				} else {
					this.parentTriceratopsEntity = triceratopsEntity;
					return true;
				}
			} else {
				return false;
			}
		}

		public boolean shouldContinueExecuting() {
			if (!this.babyTriceratopsEntity.isJuvenile() || !this.babyTriceratopsEntity.isChild()) {
				return false;
			} else if (!this.parentTriceratopsEntity.isAlive()) {
				return false;
			} else  if(this.babyTriceratopsEntity.isChild() && !this.babyTriceratopsEntity.isJuvenile()){
				double d0 = this.babyTriceratopsEntity.getDistanceSq(this.parentTriceratopsEntity);
				return !(d0 < 9.0D) && !(d0 > 256.0D);
			} else {
				return false;
			}
		}

		public void startExecuting() {
			this.delayCounter = 0;
		}

		public void resetTask() {
			this.parentTriceratopsEntity = null;
		}

		public void tick() {
			if (--this.delayCounter <= 0) {
				this.delayCounter = 10;
				this.babyTriceratopsEntity.getNavigator().tryMoveToEntityLiving(this.parentTriceratopsEntity, this.moveSpeed);
			}
		}
	}

}