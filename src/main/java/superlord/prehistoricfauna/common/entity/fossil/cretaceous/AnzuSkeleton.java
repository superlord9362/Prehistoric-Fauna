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

public class AnzuSkeleton extends PrehistoricEntity {
	private static final EntityDataAccessor<Boolean> REAR = SynchedEntityData.defineId(AnzuSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ROMP = SynchedEntityData.defineId(AnzuSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> FLEE = SynchedEntityData.defineId(AnzuSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SKULK = SynchedEntityData.defineId(AnzuSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DISPLAY = SynchedEntityData.defineId(AnzuSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> BOW = SynchedEntityData.defineId(AnzuSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SIT = SynchedEntityData.defineId(AnzuSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SLEEP = SynchedEntityData.defineId(AnzuSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DEATH = SynchedEntityData.defineId(AnzuSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> PUSHING = SynchedEntityData.defineId(AnzuSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> LOOKING = SynchedEntityData.defineId(AnzuSkeleton.class, EntityDataSerializers.BOOLEAN);

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

	public boolean isRear() {
		return this.entityData.get(REAR);
	}

	private void setRear(boolean isRear) {
		this.entityData.set(REAR, isRear);
	}

	public boolean isRomp() {
		return this.entityData.get(ROMP);
	}

	private void setRomp(boolean isRomp) {
		this.entityData.set(ROMP, isRomp);
	}

	public boolean isFlee() {
		return this.entityData.get(FLEE);
	}

	private void setFlee(boolean isFlee) {
		this.entityData.set(FLEE, isFlee);
	}

	public boolean isSkulk() {
		return this.entityData.get(SKULK);
	}

	private void setSkulk(boolean isSkulk) {
		this.entityData.set(SKULK, isSkulk);
	}

	public boolean isDisplay() {
		return this.entityData.get(DISPLAY);
	}

	private void setDisplay(boolean isDisplay) {
		this.entityData.set(DISPLAY, isDisplay);
	}

	public boolean isBow() {
		return this.entityData.get(BOW);
	}

	private void setBow(boolean isBow) {
		this.entityData.set(BOW, isBow);
	}

	public boolean isSit() {
		return this.entityData.get(SIT);
	}

	private void setSit(boolean isSit) {
		this.entityData.set(SIT, isSit);
	}

	public boolean isSleep() {
		return this.entityData.get(SLEEP);
	}

	private void setSleep(boolean isSleep) {
		this.entityData.set(SLEEP, isSleep);
	}

	public boolean isDeath() {
		return this.entityData.get(DEATH);
	}

	private void setDeath(boolean isDeath) {
		this.entityData.set(DEATH, isDeath);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(REAR, false);
		this.entityData.define(ROMP, false);
		this.entityData.define(FLEE, false);
		this.entityData.define(SKULK, false);
		this.entityData.define(DISPLAY, false);
		this.entityData.define(BOW, false);
		this.entityData.define(SIT, false);
		this.entityData.define(SLEEP, false);
		this.entityData.define(DEATH, false);
		this.entityData.define(PUSHING, false);
		this.entityData.define(LOOKING, false);
	}
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsRear", this.isRear());
		compound.putBoolean("IsRomp", this.isRomp());
		compound.putBoolean("IsFlee", this.isFlee());
		compound.putBoolean("IsSkulk", this.isSkulk());
		compound.putBoolean("IsDisplay", this.isDisplay());
		compound.putBoolean("IsBow", this.isBow());
		compound.putBoolean("IsSit", this.isSit());
		compound.putBoolean("IsSleep", this.isSleep());
		compound.putBoolean("IsDeath", this.isDeath());
		compound.putBoolean("IsPushable", this.isPushableState());
		compound.putBoolean("IsLooking", this.isLooking());
		compound.putFloat("Rotation", this.getYHeadRot());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound); 
		this.setRear(compound.getBoolean("IsRear"));
		this.setRomp(compound.getBoolean("IsRomp"));
		this.setFlee(compound.getBoolean("IsFlee"));
		this.setSkulk(compound.getBoolean("IsSkulk"));
		this.setDisplay(compound.getBoolean("IsDisplay"));
		this.setBow(compound.getBoolean("IsBow"));
		this.setSit(compound.getBoolean("IsSit"));
		this.setSleep(compound.getBoolean("IsSleep"));
		this.setDeath(compound.getBoolean("IsDeath"));
		this.setPushable(compound.getBoolean("IsPushable"));
		this.setLooking(compound.getBoolean("IsLooking"));
		this.setYBodyRot(compound.getFloat("Rotation"));
		this.setYHeadRot(compound.getFloat("Rotation"));
	}

	public AnzuSkeleton(EntityType<? extends AnzuSkeleton> type, Level worldIn) {
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
			if (!this.isShiftKeyDown()) {
				if (!this.isRear() && !this.isRomp() && !this.isFlee() && !this.isSkulk() && !this.isDisplay() && !this.isBow() && !this.isSit() && !this.isSleep() && !this.isDeath()) {
					this.setRear(true);
				} else if (this.isRear()) {
					this.setRear(false);
					this.setRomp(true);
				} else if (this.isRomp()) {
					this.setRomp(false);
					this.setFlee(true);
				} else if (this.isFlee()) {
					this.setFlee(false);
					this.setSkulk(true);
				} else if (this.isSkulk()) {
					this.setSkulk(false);
					this.setDisplay(true);
				} else if (this.isDisplay()) {
					this.setDisplay(false);
					this.setBow(true);
				} else if (this.isBow()) {
					this.setBow(false);
					this.setSit(true);
				} else if (this.isSit()) {
					this.setSit(false);
					this.setSleep(true);
				} else if (this.isSleep()) {
					this.setSleep(false);
					this.setDeath(true);
				} else if (this.isDeath()) {
					this.setDeath(false);
				}
			} else {
				if (!this.isPushableState() && !this.isLooking()) {
					this.setPushable(true);
					player.displayClientMessage(Component.translatable("entity.prehistoricfauna.skeleton.pushable"), true);
				} else if (this.isPushableState()) {
					this.setPushable(false);
					this.setLooking(true);
					player.displayClientMessage(Component.translatable("entity.prehistoricfauna.skeleton.rotating"), true);
				} else if (this.isLooking()) {
					this.setLooking(false);
					player.displayClientMessage(Component.translatable("entity.prehistoricfauna.skeleton.neutral"), true);
				}
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
		Block.popResource(this.level(), this.blockPosition(), new ItemStack(PFItems.ANZU_SKELETON.get()));
	}

	static class LookAtPlayerGoal extends net.minecraft.world.entity.ai.goal.LookAtPlayerGoal {

		AnzuSkeleton entity;

		public LookAtPlayerGoal(AnzuSkeleton entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
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
		return new ItemStack(PFItems.ANZU_SKELETON.get());
	}

}