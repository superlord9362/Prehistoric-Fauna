package superlord.prehistoricfauna.common.entity.fossil;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.entity.PrehistoricEntity;
import superlord.prehistoricfauna.init.PFItems;

public abstract class FossilEntity extends PrehistoricEntity {
	private static final EntityDataAccessor<Boolean> PUSHING = SynchedEntityData.defineId(FossilEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> LOOKING = SynchedEntityData.defineId(FossilEntity.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<String> POSE = SynchedEntityData.defineId(FossilEntity.class, EntityDataSerializers.STRING);

	public boolean isPushableState() { 
		return this.entityData.get(PUSHING); 
	}

	private void setPushable(boolean isPushable) { 
		this.entityData.set(PUSHING, isPushable); 
	}

	public boolean isLooking() { 
		return this.entityData.get(LOOKING);
	}

	private void setLooking(boolean isLooking) { 
		this.entityData.set(LOOKING, isLooking);
	}

	protected abstract String defaultPoseName();

	protected abstract String nextPoseName(String current);

	public String getPoseName() {
		return this.entityData.get(POSE);
	}

	private void setPoseName(String name) {
		this.entityData.set(POSE, name);
	}

	protected void cyclePose() {
		setPoseName(nextPoseName(getPoseName()));
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(PUSHING, false);
		this.entityData.define(LOOKING, false);
		this.entityData.define(POSE, defaultPoseName());
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsPushable", this.isPushableState());
		compound.putBoolean("IsLooking", this.isLooking());
		compound.putFloat("Rotation", this.getYHeadRot());
		compound.putString("SkeletonPose", getPoseName());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.setPushable(compound.getBoolean("IsPushable"));
		this.setLooking(compound.getBoolean("IsLooking"));
		this.setYBodyRot(compound.getFloat("Rotation"));
		this.setYHeadRot(compound.getFloat("Rotation"));
		if (compound.contains("SkeletonPose")) {
			setPoseName(compound.getString("SkeletonPose"));
		}
	}

	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (itemstack.getItem() == PFItems.GEOLOGY_HAMMER.get()) {
			if (!player.isShiftKeyDown()) cyclePose();
			else cycleDisplayState(player);
			return InteractionResult.sidedSuccess(this.level().isClientSide());
		}
		return InteractionResult.PASS;
	}

	public FossilEntity(EntityType<? extends FossilEntity> type, Level worldIn) {
		super(type, worldIn);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 8.0F));
	}

	protected void cycleDisplayState(Player player) {
		if (!isPushableState() && !isLooking()) {
			setPushable(true);
			player.displayClientMessage(Component.translatable("entity.prehistoricfauna.skeleton.pushable"), true);
		} else if (isPushableState()) {
			setPushable(false);
			setLooking(true);
			player.displayClientMessage(Component.translatable("entity.prehistoricfauna.skeleton.rotating"), true);
		} else {
			setLooking(false);
			player.displayClientMessage(Component.translatable("entity.prehistoricfauna.skeleton.neutral"), true);
		}
	}



	protected int getExperiencePoints(Player player) {
		return 0;
	}

	@Override
	public boolean canBreatheUnderwater() { 
		return true;
	}

	@Override
	public boolean isPushable() {
		return this.isPushableState();
	}

	@Override
	protected void doPush(Entity entityIn) {
	}

	public boolean canBeHitWithPotion() {
		return false;
	}

	public void onKillCommand() {
		this.kill();
	}

	private void playBrokenSound() {
		this.level().playSound((Player) null, this.getX(), this.getY(), this.getZ(), SoundEvents.SKELETON_HURT, this.getSoundSource(), 1.0F, 1.0F);
	}

	private void playParticles() {
		if (this.level() instanceof ServerLevel serverLevel) {
			serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.BONE_BLOCK.defaultBlockState()), this.getX(), this.getY(0.6666666666666666D), this.getZ(), 10, (double) (this.getBbWidth() / 4.0F), (double) (this.getBbHeight() / 4.0F), (double) (this.getBbWidth() / 4.0F), 0.05D);
		}
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source.is(DamageTypeTags.IS_EXPLOSION)) {
			this.playBrokenSound();
			this.playParticles();
			this.spawnFossil(source);
			this.remove(RemovalReason.KILLED);
			this.gameEvent(GameEvent.ENTITY_DIE);
		}
		if (source.getDirectEntity() instanceof Player player) {
			if (!(player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof SwordItem)) {
				this.playBrokenSound();
				this.playParticles();
				if (!player.isCreative()) {
					this.spawnFossil(source);
				}
				this.remove(RemovalReason.KILLED);
				this.gameEvent(GameEvent.ENTITY_DIE);
			}
		}
		return false;
	}

	public abstract void spawnFossil(DamageSource source);

	@Override
	public abstract ItemStack getPickedResult(HitResult target);

	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob other) {
		return null;
	}

	static class LookAtPlayerGoal extends net.minecraft.world.entity.ai.goal.LookAtPlayerGoal {

		private final FossilEntity entity;

		public LookAtPlayerGoal(FossilEntity entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
			super(entityIn, watchTargetClass, maxDistance);
			this.entity = entityIn;
		}

		@Override
		public boolean canUse() {
			return entity.isLooking() && super.canUse();
		}

		@Override
		public boolean canContinueToUse() {
			return entity.isLooking() && super.canContinueToUse();
		}
	}

}
