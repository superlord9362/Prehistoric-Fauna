package superlord.prehistoricfauna.common.entities.fossil;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.common.entities.PrehistoricEntity;
import superlord.prehistoricfauna.init.PFItems;

public class VelociraptorSkeletonEntity extends PrehistoricEntity {

	private static final DataParameter<Boolean> FLASHING = EntityDataManager.createKey(VelociraptorSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> LAY_FIGHTING = EntityDataManager.createKey(VelociraptorSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> STAND_FIGHTING = EntityDataManager.createKey(VelociraptorSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> RUNNING = EntityDataManager.createKey(VelociraptorSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> SLEEPING = EntityDataManager.createKey(VelociraptorSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> PUSHING = EntityDataManager.createKey(VelociraptorSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> LOOKING = EntityDataManager.createKey(VelociraptorSkeletonEntity.class, DataSerializers.BOOLEAN);

	public boolean isFlashing() {
		return this.dataManager.get(FLASHING);
	}

	private void setFlashing(boolean isFlashing) {
		this.dataManager.set(FLASHING, isFlashing);
	}

	public boolean isLayFighting() {
		return this.dataManager.get(LAY_FIGHTING);
	}

	private void setLayFighting(boolean isLayFighting) {
		this.dataManager.set(LAY_FIGHTING, isLayFighting);
	}

	public boolean isStandFighting() {
		return this.dataManager.get(STAND_FIGHTING);
	}

	private void setStandFighting(boolean isStandFighting) {
		this.dataManager.set(STAND_FIGHTING, isStandFighting);
	}

	public boolean isRunning() {
		return this.dataManager.get(RUNNING);
	}

	private void setRunning(boolean isRunning) {
		this.dataManager.set(RUNNING, isRunning);
	}

	public boolean isSleeping() {
		return this.dataManager.get(SLEEPING);
	}

	private void setSleeping(boolean isSleeping) {
		this.dataManager.set(SLEEPING, isSleeping);
	}

	public boolean isPushable() {
		return this.dataManager.get(PUSHING);
	}

	private void setPushable(boolean isPushable) {
		this.dataManager.set(PUSHING, isPushable);
	}
	
	public boolean isLooking() {
		return this.dataManager.get(LOOKING);
	}

	private void setLooking(boolean isLooking) {
		this.dataManager.set(LOOKING, isLooking);
	}

	public VelociraptorSkeletonEntity(EntityType<? extends VelociraptorSkeletonEntity> type, World worldIn) {
		super(type, worldIn);
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(FLASHING, false);
		this.dataManager.register(LAY_FIGHTING, false);
		this.dataManager.register(STAND_FIGHTING, false);
		this.dataManager.register(RUNNING, false);
		this.dataManager.register(PUSHING, false);
		this.dataManager.register(SLEEPING, false);
		this.dataManager.register(LOOKING, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("isFlashing", this.isFlashing());
		compound.putBoolean("isLayFighting", this.isLayFighting());
		compound.putBoolean("isStandFighting", this.isStandFighting());
		compound.putBoolean("isRunning", this.isRunning());
		compound.putBoolean("isSleeping", this.isSleeping());
		compound.putBoolean("IsPushable", this.isPushable());
		compound.putBoolean("IsLooking", this.isLooking());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound); 
		this.setFlashing(compound.getBoolean("isFlashing"));
		this.setLayFighting(compound.getBoolean("isLayFighting"));
		this.setStandFighting(compound.getBoolean("isStandFighting"));
		this.setRunning(compound.getBoolean("isRunning"));
		this.setSleeping(compound.getBoolean("isSleeping"));
		this.setPushable(compound.getBoolean("IsPushable"));
		this.setLooking(compound.getBoolean("IsLooking"));
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, PlayerEntity.class, 8.0F));
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 1.0D);
	}

	protected int getExperiencePoints(PlayerEntity player) {
		return 0;
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	public boolean canBePushed() {
		return this.isPushable();
	}

	protected void collideWithEntity(Entity entityIn) {
	}

	private void playBrokenSound() {
		this.world.playSound((PlayerEntity)null, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_SKELETON_HURT, this.getSoundCategory(), 1.0F, 1.0F);
	}

	private void playParticles() {
		if (this.world instanceof ServerWorld) {
			((ServerWorld)this.world).spawnParticle(new BlockParticleData(ParticleTypes.BLOCK, Blocks.BONE_BLOCK.getDefaultState()), this.getPosX(), this.getPosYHeight(0.6666666666666666D), this.getPosZ(), 10, (double)(this.getWidth() / 4.0F), (double)(this.getHeight() / 4.0F), (double)(this.getWidth() / 4.0F), 0.05D);
		}
	}

	public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		if (itemstack.getItem() == PFItems.GEOLOGY_HAMMER.get()) {
			if (!this.isSleeping() && !this.isLayFighting() && !this.isStandFighting() && !this.isFlashing() && !this.isRunning() && !player.isSneaking()) {
				this.setFlashing(true);
			} else if (this.isFlashing() && !player.isSneaking()) {
				this.setFlashing(false);
				this.setRunning(true);
			} else if (this.isRunning() && !player.isSneaking()) {
				this.setRunning(false);
				this.setLayFighting(true);
			} else if (this.isLayFighting() && !player.isSneaking()) {
				this.setLayFighting(false);
				this.setStandFighting(true);
			} else if (this.isStandFighting() && !player.isSneaking()) {
				this.setStandFighting(false);
				this.setSleeping(true);
			} else if (this.isSleeping() && !player.isSneaking()) {
				this.setSleeping(false);
			} else if (player.isSneaking() && !this.isPushable() && !this.isLooking()) {
				this.setPushable(true);
			} else if (player.isSneaking() && this.isPushable()) {
				this.setPushable(false);
				this.setLooking(true);
			} else if (player.isSneaking() && this.isLooking()) {
				this.setLooking(false);
			}
		}
		return super.func_230254_b_(player, hand);
	}

	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (source.getTrueSource() instanceof PlayerEntity) {
			if (source.isExplosion()) {
				return super.attackEntityFrom(source, amount);
			} else {
				this.remove();
			}
			this.playBrokenSound();
			this.playParticles();
			PlayerEntity player = (PlayerEntity)source.getTrueSource();
			if (!player.isCreative()) {
				this.spawnFossil(source);
			}
		}
		return false;
	}

	public boolean canBeHitWithPotion() {
		return false;
	}

	public void onKillCommand() {
		this.remove();
	}

	private void spawnFossil(DamageSource p_213815_1_) {
		Block.spawnAsEntity(this.world, new BlockPos(this.getPositionVec()), new ItemStack(PFItems.VELOCIRAPTOR_SKELETON.get()));
	}
	
	static class LookAtPlayerGoal extends LookAtGoal {

		VelociraptorSkeletonEntity entity;
		
		public LookAtPlayerGoal(VelociraptorSkeletonEntity entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
			super(entityIn, watchTargetClass, maxDistance);
			entity = entityIn;
		}
		
		public boolean shouldExecute() {
			if (entity.isLooking()) {
				return super.shouldExecute();
			} else {
				return false;
			}
		}
		
		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting() && entity.isLooking();
		}
		
	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ItemStack getPickedResult(RayTraceResult target) {
		return new ItemStack(PFItems.VELOCIRAPTOR_SKELETON.get());
	}

}