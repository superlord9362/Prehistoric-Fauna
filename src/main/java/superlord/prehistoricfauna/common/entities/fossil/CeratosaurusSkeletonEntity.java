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

public class CeratosaurusSkeletonEntity extends PrehistoricEntity {

	private static final DataParameter<Boolean> ACTION_POSE = EntityDataManager.createKey(CeratosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> RESTING_POSE = EntityDataManager.createKey(CeratosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> PUSHING = EntityDataManager.createKey(CeratosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALERT_POSE_RIGHT = EntityDataManager.createKey(CeratosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ALERT_POSE_LEFT = EntityDataManager.createKey(CeratosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> LOOKING = EntityDataManager.createKey(CeratosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);

	
	public boolean isAction() {
		return this.dataManager.get(ACTION_POSE);
	}

	private void setAction(boolean isAction) {
		this.dataManager.set(ACTION_POSE, isAction);
	}
	
	public boolean isAlertRight() {
		return this.dataManager.get(ALERT_POSE_RIGHT);
	}

	private void setAlertRight(boolean isAlertRight) {
		this.dataManager.set(ALERT_POSE_RIGHT, isAlertRight);
	}
	
	public boolean isAlertLeft() {
		return this.dataManager.get(ALERT_POSE_LEFT);
	}

	private void setAlertLeft(boolean isAlertLeft) {
		this.dataManager.set(ALERT_POSE_LEFT, isAlertLeft);
	}

	public boolean isResting() {
		return this.dataManager.get(RESTING_POSE);
	}

	private void setResting(boolean isResting) {
		this.dataManager.set(RESTING_POSE, isResting);
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
		this.dataManager.register(ACTION_POSE, false);
		this.dataManager.register(RESTING_POSE, false);
		this.dataManager.register(PUSHING, false);
		this.dataManager.register(ALERT_POSE_RIGHT, false);
		this.dataManager.register(ALERT_POSE_LEFT, false);
		this.dataManager.register(LOOKING, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("IsAction", this.isAction());
		compound.putBoolean("IsResting", this.isResting());
		compound.putBoolean("IsPushable", this.isPushable());
		compound.putBoolean("IsAlertRight", this.isAlertRight());
		compound.putBoolean("IsAlertLeft", this.isAlertLeft());
		compound.putBoolean("IsLooking", this.isLooking());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound); 
		this.setAction(compound.getBoolean("IsAction"));
		this.setResting(compound.getBoolean("IsResting"));
		this.setPushable(compound.getBoolean("IsPushable"));
		this.setAlertRight(compound.getBoolean("IsAlertRight"));
		this.setAlertLeft(compound.getBoolean("IsAlertLeft"));
		this.setLooking(compound.getBoolean("IsLooking"));
	}
	
	public CeratosaurusSkeletonEntity(EntityType<? extends CeratosaurusSkeletonEntity> type, World worldIn) {
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
	    	if (!this.isAlertLeft() && !this.isAlertRight() && !this.isAction() && !this.isResting() && !player.isSneaking()) {
	    		this.setResting(true);
	    	} else if (this.isResting() && !player.isSneaking()) {
	    		this.setResting(false);
	    		this.setAction(true);
	    	} else if (this.isAction() && !player.isSneaking()) {
	    		this.setAction(false);
	    		this.setAlertLeft(true);
	    	} else if (this.isAlertLeft() && !player.isSneaking()) {
	    		this.setAlertLeft(false);
	    		this.setAlertRight(true);
	    	} else if (this.isAlertRight() && !player.isSneaking()) {
	    		this.setAlertRight(false);
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
		Block.spawnAsEntity(this.world, new BlockPos(this.getPositionVec()), new ItemStack(PFItems.CERATOSAURUS_SKELETON.get()));
	}
	
	static class LookAtPlayerGoal extends LookAtGoal {

		CeratosaurusSkeletonEntity entity;
		
		public LookAtPlayerGoal(CeratosaurusSkeletonEntity entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
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
		return new ItemStack(PFItems.CERATOSAURUS_SKELETON.get());
	}

}