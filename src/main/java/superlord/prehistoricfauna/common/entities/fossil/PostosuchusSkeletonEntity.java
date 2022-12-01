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

public class PostosuchusSkeletonEntity extends PrehistoricEntity {

	private static final DataParameter<Boolean> ATTACK_RIGHT = EntityDataManager.createKey(PostosuchusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ATTACK_LEFT = EntityDataManager.createKey(PostosuchusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> WALKING = EntityDataManager.createKey(PostosuchusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> CURIOUS = EntityDataManager.createKey(PostosuchusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> SLEEPING = EntityDataManager.createKey(PostosuchusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> PUSHING = EntityDataManager.createKey(PostosuchusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> LOOKING = EntityDataManager.createKey(PostosuchusSkeletonEntity.class, DataSerializers.BOOLEAN);

	public boolean isAttackRight() {
		return this.dataManager.get(ATTACK_RIGHT);
	}

	private void setAttackRight(boolean isAttackRight) {
		this.dataManager.set(ATTACK_RIGHT, isAttackRight);
	}
	
	public boolean isAttackLeft() {
		return this.dataManager.get(ATTACK_LEFT);
	}

	private void setAttackLeft(boolean isAttackLeft) {
		this.dataManager.set(ATTACK_LEFT, isAttackLeft);
	}

	public boolean isWalking() {
		return this.dataManager.get(WALKING);
	}

	private void setWalking(boolean isWalking) {
		this.dataManager.set(WALKING, isWalking);
	}

	public boolean isCurious() {
		return this.dataManager.get(CURIOUS);
	}

	private void setCurious(boolean isCurious) {
		this.dataManager.set(CURIOUS, isCurious);
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
		this.dataManager.register(ATTACK_RIGHT, false);
		this.dataManager.register(ATTACK_LEFT, false);
		this.dataManager.register(WALKING, false);
		this.dataManager.register(CURIOUS, false);
		this.dataManager.register(SLEEPING, false);
		this.dataManager.register(PUSHING, false);
		this.dataManager.register(LOOKING, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("IsAttackRight", this.isAttackRight());
		compound.putBoolean("IsAttackLeft", this.isAttackLeft());
		compound.putBoolean("IsWalking", this.isWalking());
		compound.putBoolean("IsCurious", this.isCurious());
		compound.putBoolean("IsSleeping", this.isSleeping());
		compound.putBoolean("IsPushable", this.isPushable());
		compound.putBoolean("IsLooking", this.isLooking());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound); 
		this.setAttackRight(compound.getBoolean("IsActionRight"));
		this.setAttackLeft(compound.getBoolean("IsActionLeft"));
		this.setWalking(compound.getBoolean("IsWalking"));
		this.setCurious(compound.getBoolean("IsCurious"));
		this.setSleeping(compound.getBoolean("IsSleeping"));
		this.setPushable(compound.getBoolean("IsPushable"));
		this.setLooking(compound.getBoolean("IsLooking"));
	}

	public PostosuchusSkeletonEntity(EntityType<? extends PostosuchusSkeletonEntity> type, World worldIn) {
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
			if (!this.isSleeping() && !this.isCurious() && !this.isWalking() && !this.isAttackLeft() && !this.isAttackRight() && !player.isSneaking()) {
				this.setAttackRight(true);
			} else if (this.isAttackRight() && !player.isSneaking()) {
				this.setAttackRight(false);
				this.setAttackLeft(true);
			} else if (this.isAttackLeft() && !player.isSneaking()) {
				this.setAttackLeft(false);
				this.setWalking(true);
			} else if (this.isWalking() && !player.isSneaking()) {
				this.setWalking(false);
				this.setCurious(true);
			} else if (this.isCurious() && !player.isSneaking()) {
				this.setCurious(false);
				this.setSleeping(true);
			} else if (this.isSleeping() && !player.isSneaking()) {
				this.setSleeping(false);
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
	
	private void spawnFossil(DamageSource p_213815_1_) {
		Block.spawnAsEntity(this.world, new BlockPos(this.getPositionVec()), new ItemStack(PFItems.POSTOSUCHUS_SKELETON.get()));
	}

	public boolean canBeHitWithPotion() {
		return false;
	}

	public void onKillCommand() {
		this.remove();
	}
	static class LookAtPlayerGoal extends LookAtGoal {

		PostosuchusSkeletonEntity entity;

		public LookAtPlayerGoal(PostosuchusSkeletonEntity entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
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
		return null;
	}
	
	@Override
	public ItemStack getPickedResult(RayTraceResult target) {
		return new ItemStack(PFItems.POSTOSUCHUS_SKELETON.get());
	}

}