package superlord.prehistoricfauna.common.entities;

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
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.init.PFItems;

public class TyrannosaurusSkeletonEntity extends PrehistoricEntity {

	private static final DataParameter<Boolean> CLASSIC_POSE = EntityDataManager.createKey(TyrannosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ACTION_LEFT_POSE = EntityDataManager.createKey(TyrannosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> ACTION_RIGHT_POSE = EntityDataManager.createKey(TyrannosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> RESTING_POSE = EntityDataManager.createKey(TyrannosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> JURASSIC_POSE = EntityDataManager.createKey(TyrannosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> PUSHING = EntityDataManager.createKey(TyrannosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> LOOKING = EntityDataManager.createKey(TyrannosaurusSkeletonEntity.class, DataSerializers.BOOLEAN);

	public boolean isClassical() {
		return this.dataManager.get(CLASSIC_POSE);
	}

	private void setClassical(boolean isClassical) {
		this.dataManager.set(CLASSIC_POSE, isClassical);
	}

	public boolean isActionLeft() {
		return this.dataManager.get(ACTION_LEFT_POSE);
	}

	private void setActionLeft(boolean isActionLeft) {
		this.dataManager.set(ACTION_LEFT_POSE, isActionLeft);
	}

	public boolean isActionRight() {
		return this.dataManager.get(ACTION_RIGHT_POSE);
	}

	private void setActionRight(boolean isActionRight) {
		this.dataManager.set(ACTION_RIGHT_POSE, isActionRight);
	}

	public boolean isResting() {
		return this.dataManager.get(RESTING_POSE);
	}

	private void setResting(boolean isResting) {
		this.dataManager.set(RESTING_POSE, isResting);
	}

	public boolean isJurassicParkReference() {
		return this.dataManager.get(JURASSIC_POSE);
	}

	private void setJurassicParkReference(boolean isJurassicParkReference) {
		this.dataManager.set(JURASSIC_POSE, isJurassicParkReference);
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

	public TyrannosaurusSkeletonEntity(EntityType<? extends TyrannosaurusSkeletonEntity> type, World worldIn) {
		super(type, worldIn);
	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(CLASSIC_POSE, false);
		this.dataManager.register(ACTION_LEFT_POSE, false);
		this.dataManager.register(ACTION_RIGHT_POSE, false);
		this.dataManager.register(RESTING_POSE, false);
		this.dataManager.register(PUSHING, false);
		this.dataManager.register(JURASSIC_POSE, false);
		this.dataManager.register(LOOKING, false);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("IsClassical", this.isClassical());
		compound.putBoolean("IsActionLeft", this.isActionLeft());
		compound.putBoolean("IsActionRight", this.isActionRight());
		compound.putBoolean("IsResting", this.isResting());
		compound.putBoolean("IsJurassicParkReference", this.isJurassicParkReference());
		compound.putBoolean("IsPushable", this.isPushable());
		compound.putBoolean("IsLooking", this.isLooking());
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound); 
		this.setClassical(compound.getBoolean("IsClassical"));
		this.setActionLeft(compound.getBoolean("IsActionLeft"));
		this.setActionRight(compound.getBoolean("IsActionRight"));
		this.setResting(compound.getBoolean("IsResting"));
		this.setJurassicParkReference(compound.getBoolean("IsJurassicParkReference"));
		this.setPushable(compound.getBoolean("IsPushable"));
		this.setLooking(compound.getBoolean("IsLooking"));
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, PlayerEntity.class, 8.0F));
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 100.0D);
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
		this.world.playSound((PlayerEntity)null, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_SKELETON_DEATH, this.getSoundCategory(), 1.0F, 1.0F);
	}

	private void playParticles() {
		if (this.world instanceof ServerWorld) {
			((ServerWorld)this.world).spawnParticle(new BlockParticleData(ParticleTypes.BLOCK, Blocks.BONE_BLOCK.getDefaultState()), this.getPosX(), this.getPosYHeight(0.6666666666666666D), this.getPosZ(), 10, (double)(this.getWidth() / 4.0F), (double)(this.getHeight() / 4.0F), (double)(this.getWidth() / 4.0F), 0.05D);
		}
	}

	public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		if (itemstack.getItem() == PFItems.GEOLOGY_HAMMER.get()) {
			if (!this.isJurassicParkReference() && !this.isActionLeft() && !this.isActionRight() && !this.isClassical() && !this.isResting() && !player.isSneaking()) {
				this.setClassical(true);
			} else if (this.isClassical() && !player.isSneaking()) {
				this.setClassical(false);
				this.setResting(true);
			} else if (this.isResting() && !player.isSneaking()) {
				this.setResting(false);
				this.setActionLeft(true);
			} else if (this.isActionLeft() && !player.isSneaking()) {
				this.setActionLeft(false);
				this.setActionRight(true);
			} else if (this.isActionRight() && !player.isSneaking()) {
				this.setActionRight(false);
				this.setJurassicParkReference(true);
			} else if (this.isJurassicParkReference() && !player.isSneaking()) {
				this.setJurassicParkReference(false);
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
		Block.spawnAsEntity(this.world, new BlockPos(this.getPositionVec()), new ItemStack(PFItems.TYRANNOSAURUS_SKELETON.get()));
	}
	
	static class LookAtPlayerGoal extends LookAtGoal {

		TyrannosaurusSkeletonEntity entity;
		
		public LookAtPlayerGoal(TyrannosaurusSkeletonEntity entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
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

}