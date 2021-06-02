package superlord.prehistoricfauna.entity;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.init.ItemInit;

public class TriceratopsSkeletonEntity extends PrehistoricEntity {
	private static final DataParameter<Boolean> CHARGING_POSE = EntityDataManager.createKey(TriceratopsSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> SLEEPING_POSE = EntityDataManager.createKey(TriceratopsSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> CLASSICAL_POSE = EntityDataManager.createKey(TriceratopsSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> PUSHING = EntityDataManager.createKey(TriceratopsSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> LOOKING = EntityDataManager.createKey(TriceratopsSkeletonEntity.class, DataSerializers.BOOLEAN);

	public boolean isCharging() {
		return this.dataManager.get(CHARGING_POSE);
	}

	private void setCharging(boolean isCharging) {
		this.dataManager.set(CHARGING_POSE, isCharging);
	}

	public boolean isSleeping() {
		return this.dataManager.get(SLEEPING_POSE);
	}

	private void setSleeping(boolean isSleeping) {
		this.dataManager.set(SLEEPING_POSE, isSleeping);
	}
	
	public boolean isClassical() {
		return this.dataManager.get(CLASSICAL_POSE);
	}

	private void setClassical(boolean isClassical) {
		this.dataManager.set(CLASSICAL_POSE, isClassical);
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
	
	protected void registerData() {
		super.registerData();
		this.dataManager.register(CHARGING_POSE, false);
		this.dataManager.register(SLEEPING_POSE, false);
		this.dataManager.register(CLASSICAL_POSE, false);
		this.dataManager.register(PUSHING, false);
		this.dataManager.register(LOOKING, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("IsCharging", this.isCharging());
		compound.putBoolean("IsSleeping", this.isSleeping());
		compound.putBoolean("IsClassical", this.isClassical());
		compound.putBoolean("IsPushable", this.isPushable());
		compound.putBoolean("IsLooking", this.isLooking());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound); 
		this.setCharging(compound.getBoolean("IsCharging"));
		this.setSleeping(compound.getBoolean("IsSleeping"));
		this.setClassical(compound.getBoolean("IsClassical"));
		this.setPushable(compound.getBoolean("IsPushable"));
		this.setLooking(compound.getBoolean("IsLooking"));
	}

	public TriceratopsSkeletonEntity(EntityType<? extends TriceratopsSkeletonEntity> type, World worldIn) {
		super(type, worldIn);
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, PlayerEntity.class, 8.0F));
	}

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
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
	
	public boolean processInteract(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
	    if (itemstack.getItem() == ItemInit.GEOLOGY_HAMMER.get()) {
	    	if (!this.isCharging() && !this.isSleeping() && !this.isClassical() && !player.isSneaking()) {
	    		this.setClassical(true);
	    	} else if (this.isClassical() && !player.isSneaking()) {
	    		this.setClassical(false);
	    		this.setSleeping(true);
	    	} else if (this.isSleeping() && !player.isSneaking()) {
	    		this.setSleeping(false);
	    		this.setCharging(true);
	    	} else if (this.isCharging() && !player.isSneaking()) {
	    		this.setCharging(false);
	    	} else if (player.isSneaking() && !this.isPushable() && !this.isLooking()) {
				this.setPushable(true);
			} else if (player.isSneaking() && this.isPushable()) {
				this.setPushable(false);
				this.setLooking(true);
			} else if (player.isSneaking() && this.isLooking()) {
				this.setLooking(false);
			}
	    }
        return super.processInteract(player, hand);
	}

	protected void collideWithEntity(Entity entityIn) {
	}

	private void playBrokenSound() {
		this.world.playSound((PlayerEntity)null, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_SKELETON_DEATH, this.getSoundCategory(), 1.0F, 1.0F);
	}

	private void playParticles() {
		if (this.world instanceof ServerWorld) {
			((ServerWorld)this.world).spawnParticle(new BlockParticleData(ParticleTypes.BLOCK, Blocks.BONE_BLOCK.getDefaultState()), this.getPosX(), this.getPosYHeight(0.6666666666666666D), this.getPosZ(), 10, (double)(this.getWidth() / 4.0F), (double)(this.getHeight() / 4.0F), (double)(this.getWidth() / 4.0F), 0.05D);
		}
	}


	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (source.getTrueSource() instanceof PlayerEntity) {
			this.remove();
			this.playBrokenSound();
			this.playParticles();
			this.spawnFossil(source);
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
		Block.spawnAsEntity(this.world, new BlockPos(this), new ItemStack(ItemInit.TRICERATOPS_SKELETON.get()));
	}
	
	static class LookAtPlayerGoal extends LookAtGoal {

		TriceratopsSkeletonEntity entity;
		
		public LookAtPlayerGoal(TriceratopsSkeletonEntity entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
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

}