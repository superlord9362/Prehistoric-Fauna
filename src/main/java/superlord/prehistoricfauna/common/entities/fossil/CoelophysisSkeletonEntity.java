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
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.common.entities.PrehistoricEntity;
import superlord.prehistoricfauna.init.PFItems;

public class CoelophysisSkeletonEntity extends PrehistoricEntity {

	private static final DataParameter<Boolean> SLAIN = EntityDataManager.createKey(CoelophysisSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> SEIZING = EntityDataManager.createKey(CoelophysisSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> PUSHING = EntityDataManager.createKey(CoelophysisSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> LOOKING = EntityDataManager.createKey(CoelophysisSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> SAUNTERING = EntityDataManager.createKey(CoelophysisSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> SLEEPING = EntityDataManager.createKey(CoelophysisSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> SLUMP = EntityDataManager.createKey(CoelophysisSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> STRIDE = EntityDataManager.createKey(CoelophysisSkeletonEntity.class, DataSerializers.BOOLEAN);

	public boolean isSlain() {
		return this.dataManager.get(SLAIN);
	}

	private void setSlain(boolean isStrolling) {
		this.dataManager.set(SLAIN, isStrolling);
	}
	
	public boolean isSlump() {
		return this.dataManager.get(SLUMP);
	}

	private void setSlump(boolean isSlump) {
		this.dataManager.set(SLUMP, isSlump);
	}
	
	public boolean isStride() {
		return this.dataManager.get(STRIDE);
	}

	private void setStride(boolean isStride) {
		this.dataManager.set(STRIDE, isStride);
	}
	
	public boolean isSeizing() {
		return this.dataManager.get(SEIZING);
	}

	private void setSeizing(boolean isSeizing) {
		this.dataManager.set(SEIZING, isSeizing);
	}
	
	public boolean isSauntering() {
		return this.dataManager.get(SAUNTERING);
	}

	private void setSauntering(boolean isSauntering) {
		this.dataManager.set(SAUNTERING, isSauntering);
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
	
	protected void registerData() {
		super.registerData();
		this.dataManager.register(SAUNTERING, false);
		this.dataManager.register(SEIZING, false);
		this.dataManager.register(PUSHING, false);
		this.dataManager.register(SLAIN, false);
		this.dataManager.register(LOOKING, false);
		this.dataManager.register(SLEEPING, false);
		this.dataManager.register(SLUMP, false);
		this.dataManager.register(STRIDE, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("IsSauntering", this.isSauntering());
		compound.putBoolean("IsSeizing", this.isSeizing());
		compound.putBoolean("IsPushable", this.isPushable());
		compound.putBoolean("IsSlain", this.isSlain());
		compound.putBoolean("IsLooking", this.isLooking());
		compound.putBoolean("IsSleeping", this.isSleeping());
		compound.putBoolean("IsSlump", this.isSlump());
		compound.putBoolean("IsStride", this.isStride());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound); 
		this.setSauntering(compound.getBoolean("IsSauntering"));
		this.setSeizing(compound.getBoolean("IsSeizing"));
		this.setPushable(compound.getBoolean("IsPushable"));
		this.setSlain(compound.getBoolean("IsSlain"));
		this.setLooking(compound.getBoolean("IsLooking"));
		this.setSleeping(compound.getBoolean("IsSleeping"));
		this.setSlump(compound.getBoolean("IsSlump"));
		this.setStride(compound.getBoolean("IsStride"));
	}
	
	public CoelophysisSkeletonEntity(EntityType<? extends CoelophysisSkeletonEntity> type, World worldIn) {
		super(type, worldIn);
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
	    	if (!this.isSauntering() && !this.isSeizing() && !this.isSlain() && !this.isSleeping() && !this.isSlump() && !this.isStride() && !player.isSneaking()) {
	    		this.setSauntering(true);
	    	} else if (this.isSauntering() && !player.isSneaking()) {
	    		this.setSauntering(false);
	    		this.setSeizing(true);
	    	} else if (this.isSeizing() && !player.isSneaking()) {
	    		this.setSeizing(false);
	    		this.setStride(true);
	    	} else if (this.isStride() && !player.isSneaking()) {
	    		this.setStride(false);
	    		this.setSleeping(true);
	    	} else if (this.isSleeping() && !player.isSneaking()) {
	    		this.setSleeping(false);
	    		this.setSlump(true);
	    	} else if (this.isSlump() && !player.isSneaking()) {
	    		this.setSlump(false);
	    		this.setSlain(true);
	    	} else if (this.isSlain() && !player.isSneaking()) {
	    		this.setSlain(false);
	    	} else if (player.isSneaking() && !this.isPushable() && !this.isLooking()) {
	    		this.setPushable(true);
				player.sendStatusMessage(new TranslationTextComponent("entity.prehistoricfauna.skeleton.pushable"), true);
	    	} else if (player.isSneaking() && this.isPushable()) {
	    		this.setPushable(false);
	    		this.setLooking(true);
				player.sendStatusMessage(new TranslationTextComponent("entity.prehistoricfauna.skeleton.rotating"), true);
	    	} else if (player.isSneaking() && this.isLooking()) {
	    		this.setLooking(false);
				player.sendStatusMessage(new TranslationTextComponent("entity.prehistoricfauna.skeleton.neutral"), true);
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
		Block.spawnAsEntity(this.world, new BlockPos(this.getPositionVec()), new ItemStack(PFItems.COELOPHYSIS_SKELETON.get()));
	}
	
	static class LookAtPlayerGoal extends LookAtGoal {

		CoelophysisSkeletonEntity entity;
		
		public LookAtPlayerGoal(CoelophysisSkeletonEntity entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
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
		return new ItemStack(PFItems.COELOPHYSIS_SKELETON.get());
	}

}