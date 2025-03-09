package superlord.prehistoricfauna.common.entity.fossil.cretaceous;

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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.entity.PrehistoricEntity;
import superlord.prehistoricfauna.init.PFItems;

public class DongbeititanSkeleton extends PrehistoricEntity {
	private static final EntityDataAccessor<Boolean> WALK_POSE = SynchedEntityData.defineId(DongbeititanSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> REAR_POSE = SynchedEntityData.defineId(DongbeititanSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> REACH_POSE = SynchedEntityData.defineId(DongbeititanSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> BROWSE_POSE = SynchedEntityData.defineId(DongbeititanSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> GRAZE_POSE = SynchedEntityData.defineId(DongbeititanSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SIT_POSE = SynchedEntityData.defineId(DongbeititanSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SLEEP_POSE = SynchedEntityData.defineId(DongbeititanSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DEATH_POSE = SynchedEntityData.defineId(DongbeititanSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> PUSHING = SynchedEntityData.defineId(DongbeititanSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> LOOKING = SynchedEntityData.defineId(DongbeititanSkeleton.class, EntityDataSerializers.BOOLEAN);

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

	public boolean isWalk() {
		return this.entityData.get(WALK_POSE);
	}

	private void setWalk(boolean isWalk) {
		this.entityData.set(WALK_POSE, isWalk);
	}

	public boolean isRear() {
		return this.entityData.get(REAR_POSE);
	}

	private void setRear(boolean isRear) {
		this.entityData.set(REAR_POSE, isRear);
	}

	public boolean isBrowse() {
		return this.entityData.get(BROWSE_POSE);
	}

	private void setBrowse(boolean isBrowse) {
		this.entityData.set(BROWSE_POSE, isBrowse);
	}

	public boolean isGraze() {
		return this.entityData.get(GRAZE_POSE);
	}

	private void setGraze(boolean isGraze) {
		this.entityData.set(GRAZE_POSE, isGraze);
	}
	
	public boolean isSit() {
		return this.entityData.get(SIT_POSE);
	}
	
	private void setSit(boolean isSit) {
		this.entityData.set(SIT_POSE, isSit);
	}
	
	public boolean isSleep() {
		return this.entityData.get(SLEEP_POSE);
	}
	
	private void setSleep(boolean isSleep) {
		this.entityData.set(SLEEP_POSE, isSleep);
	}
	
	public boolean isDeath() {
		return this.entityData.get(DEATH_POSE);
	}
	
	private void setDeath(boolean isDeath) {
		this.entityData.set(DEATH_POSE, isDeath);
	}
	
	public boolean isReach() {
		return this.entityData.get(REACH_POSE);
	}
	
	private void setReach(boolean isReach) {
		this.entityData.set(REACH_POSE, isReach);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(WALK_POSE, false);
		this.entityData.define(REAR_POSE, false);
		this.entityData.define(BROWSE_POSE, false);
		this.entityData.define(GRAZE_POSE, false);
		this.entityData.define(SIT_POSE, false);
		this.entityData.define(SLEEP_POSE, false);
		this.entityData.define(PUSHING, false);
		this.entityData.define(LOOKING, false);
		this.entityData.define(DEATH_POSE, false);
		this.entityData.define(REACH_POSE, false);
	}
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsWalk", this.isWalk());
		compound.putBoolean("IsRear", this.isRear());
		compound.putBoolean("IsBrowse", this.isBrowse());
		compound.putBoolean("IsGraze", this.isGraze());
		compound.putBoolean("IsSit", this.isSit());
		compound.putBoolean("IsSleep", this.isSleep());
		compound.putBoolean("IsPushable", this.isPushableState());
		compound.putBoolean("IsLooking", this.isLooking());
		compound.putFloat("Rotation", this.getYHeadRot());
		compound.putBoolean("IsDeath", this.isDeath());
		compound.putBoolean("IsReach", this.isReach());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound); 
		this.setWalk(compound.getBoolean("IsWalk"));
		this.setRear(compound.getBoolean("IsRear"));
		this.setBrowse(compound.getBoolean("IsBrowse"));
		this.setGraze(compound.getBoolean("IsGraze"));
		this.setSit(compound.getBoolean("IsSit"));
		this.setSleep(compound.getBoolean("IsSleep"));
		this.setPushable(compound.getBoolean("IsPushable"));
		this.setLooking(compound.getBoolean("IsLooking"));
		this.setYBodyRot(compound.getFloat("Rotation"));
		this.setYHeadRot(compound.getFloat("Rotation"));
		this.setDeath(compound.getBoolean("IsDeath"));
		this.setReach(compound.getBoolean("IsReach"));
	}

	public DongbeititanSkeleton(EntityType<? extends DongbeititanSkeleton> type, Level worldIn) {
		super(type, worldIn);
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 8.0F));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0D);
	}

	protected int getExperiencePoints(Player player) {
		return 0;
	}

	public boolean canBreatheUnderwater() {
		return true;
	}

	public boolean isPushable() {
		return this.isPushableState();
	}

	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (itemstack.getItem() == PFItems.GEOLOGY_HAMMER.get()) {
			if (!this.isWalk() && !this.isReach() && !this.isRear() && !this.isDeath() && !this.isBrowse() && !this.isGraze() && !this.isSit() && !this.isSleep() && !player.isShiftKeyDown()) {
				this.setWalk(true);
			} else if (this.isWalk() && !player.isShiftKeyDown()) {
				this.setWalk(false);
				this.setRear(true);
			} else if (this.isRear() && !player.isShiftKeyDown()) {
				this.setRear(false);
				this.setReach(true);
			} else if (this.isReach() && !player.isShiftKeyDown()) {
				this.setReach(false);
				this.setBrowse(true);
			} else if (this.isBrowse() && !player.isShiftKeyDown()) {
				this.setBrowse(false);
				this.setGraze(true);
			} else if (this.isGraze() && !player.isShiftKeyDown()) {
				this.setGraze(false);
				this.setSit(true);
			} else if (this.isSit() && !player.isShiftKeyDown()) {
				this.setSit(false);
				this.setSleep(true);
			} else if (this.isSleep() && !player.isShiftKeyDown()) {
				this.setSleep(false);
				this.setDeath(true);
			} else if (this.isDeath() && !player.isShiftKeyDown()) {
				this.setDeath(false);
			} else if (player.isShiftKeyDown() && !this.isPushableState() && !this.isLooking()) {
				this.setPushable(true);
				player.displayClientMessage(Component.translatable("entity.prehistoricfauna.skeleton.pushable"), true);
			} else if (player.isShiftKeyDown() && this.isPushableState()) {
				this.setPushable(false);
				this.setLooking(true);
				player.displayClientMessage(Component.translatable("entity.prehistoricfauna.skeleton.rotating"), true);
			} else if (player.isShiftKeyDown() && this.isLooking()) {
				this.setLooking(false);
				player.displayClientMessage(Component.translatable("entity.prehistoricfauna.skeleton.neutral"), true);
			}
		}
		return super.mobInteract(player, hand);
	}

	protected void doPush(Entity entityIn) {
	}

	private void playBrokenSound() {
		this.level().playSound((Player)null, this.getX(), this.getY(), this.getZ(), SoundEvents.SKELETON_HURT, this.getSoundSource(), 1.0F, 1.0F);
	}

	private void playParticles() {
		if (this.level() instanceof ServerLevel) {
			((ServerLevel)this.level()).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.BONE_BLOCK.defaultBlockState()), this.getX(), this.getY(0.6666666666666666D), this.getZ(), 10, (double)(this.getBbWidth() / 4.0F), (double)(this.getBbHeight() / 4.0F), (double)(this.getBbWidth() / 4.0F), 0.05D);
		}
	}


	public boolean hurt(DamageSource source, float amount) {
		if (source.is(DamageTypeTags.IS_EXPLOSION)) {
			this.playBrokenSound();
			this.playParticles();
			this.spawnFossil(source);
			this.remove(RemovalReason.KILLED);
			this.gameEvent(GameEvent.ENTITY_DIE);
			return true;
		}
		if (source.getDirectEntity() instanceof Player) {
			this.playBrokenSound();
			this.playParticles();
			Player player = (Player)source.getDirectEntity();
			if (!player.isCreative()) {
				this.spawnFossil(source);
			}
			this.remove(RemovalReason.KILLED);
			this.gameEvent(GameEvent.ENTITY_DIE);
		}
		return false;
	}

	public boolean canBeHitWithPotion() {
		return false;
	}

	public void onKillCommand() {
		this.kill();
	}

	private void spawnFossil(DamageSource p_213815_1_) {
		Block.popResource(this.level(), this.blockPosition(), new ItemStack(PFItems.DONGBEITITAN_SKELETON.get()));
	}

	static class LookAtPlayerGoal extends net.minecraft.world.entity.ai.goal.LookAtPlayerGoal {

		DongbeititanSkeleton entity;

		public LookAtPlayerGoal(DongbeititanSkeleton entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
			super(entityIn, watchTargetClass, maxDistance);
			entity = entityIn;
		}

		public boolean canUse() {
			if (entity.isLooking()) {
				return super.canUse();
			} else {
				return false;
			}
		}

		public boolean canContinueToUse() {
			return super.canContinueToUse() && entity.isLooking();
		}

	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		return null;
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.DONGBEITITAN_SKELETON.get());
	}

}