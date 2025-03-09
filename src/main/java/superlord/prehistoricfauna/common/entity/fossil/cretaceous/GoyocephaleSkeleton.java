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

public class GoyocephaleSkeleton extends PrehistoricEntity {
	private static final EntityDataAccessor<Boolean> HEADBUTT_ONE = SynchedEntityData.defineId(GoyocephaleSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> HEADBUTT_TWO = SynchedEntityData.defineId(GoyocephaleSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> BRACE = SynchedEntityData.defineId(GoyocephaleSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> REAR = SynchedEntityData.defineId(GoyocephaleSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> STEP = SynchedEntityData.defineId(GoyocephaleSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> FEEDING = SynchedEntityData.defineId(GoyocephaleSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SIT = SynchedEntityData.defineId(GoyocephaleSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SLEEP = SynchedEntityData.defineId(GoyocephaleSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> DEATH = SynchedEntityData.defineId(GoyocephaleSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> PUSHING = SynchedEntityData.defineId(GoyocephaleSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> LOOKING = SynchedEntityData.defineId(GoyocephaleSkeleton.class, EntityDataSerializers.BOOLEAN);

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

	public boolean isHeadbuttOne() {
		return this.entityData.get(HEADBUTT_ONE);
	}

	private void setHeadbuttOne(boolean isHeadbuttOne) {
		this.entityData.set(HEADBUTT_ONE, isHeadbuttOne);
	}

	public boolean isHeadbuttTwo() {
		return this.entityData.get(HEADBUTT_TWO);
	}

	private void setHeadbuttTwo(boolean isHeadbuttTwo) {
		this.entityData.set(HEADBUTT_TWO, isHeadbuttTwo);
	}

	public boolean isBrace() {
		return this.entityData.get(BRACE);
	}

	private void setBrace(boolean isBrace) {
		this.entityData.set(BRACE, isBrace);
	}

	public boolean isRear() {
		return this.entityData.get(REAR);
	}

	private void setRear(boolean isRear) {
		this.entityData.set(REAR, isRear);
	}

	public boolean isStep() {
		return this.entityData.get(STEP);
	}

	private void setStep(boolean isStep) {
		this.entityData.set(STEP, isStep);
	}

	public boolean isFeeding() {
		return this.entityData.get(FEEDING);
	}

	private void setFeeding(boolean isFeeding) {
		this.entityData.set(FEEDING, isFeeding);
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
		this.entityData.define(FEEDING, false);
		this.entityData.define(SLEEP, false);
		this.entityData.define(SIT, false);
		this.entityData.define(DEATH, false);
		this.entityData.define(HEADBUTT_ONE, false);
		this.entityData.define(HEADBUTT_TWO, false);
		this.entityData.define(BRACE, false);
		this.entityData.define(REAR, false);
		this.entityData.define(STEP, false);
		this.entityData.define(PUSHING, false);
		this.entityData.define(LOOKING, false);
	}
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsFeeding", this.isFeeding());
		compound.putBoolean("IsSleep", this.isSleep());
		compound.putBoolean("IsSit", this.isSit());
		compound.putBoolean("IsDeath", this.isDeath());
		compound.putBoolean("IsHeadbuttOne", this.isHeadbuttOne());
		compound.putBoolean("IsHeadbuttTwo", this.isHeadbuttTwo());
		compound.putBoolean("IsBrace", this.isBrace());
		compound.putBoolean("IsRear", this.isRear());
		compound.putBoolean("IsStep", this.isStep());
		compound.putBoolean("IsPushable", this.isPushableState());
		compound.putBoolean("IsLooking", this.isLooking());
		compound.putFloat("Rotation", this.getYHeadRot());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound); 
		this.setFeeding(compound.getBoolean("IsFeeding"));
		this.setSleep(compound.getBoolean("IsSleep"));
		this.setSit(compound.getBoolean("IsSit"));
		this.setDeath(compound.getBoolean("IsDeath"));
		this.setHeadbuttOne(compound.getBoolean("IsHeadbuttTwo"));
		this.setHeadbuttTwo(compound.getBoolean("IsHeadbuttOne"));
		this.setBrace(compound.getBoolean("IsBrace"));
		this.setRear(compound.getBoolean("IsRear"));
		this.setStep(compound.getBoolean("IsStep"));
		this.setPushable(compound.getBoolean("IsPushable"));
		this.setLooking(compound.getBoolean("IsLooking"));
		this.setYBodyRot(compound.getFloat("Rotation"));
		this.setYHeadRot(compound.getFloat("Rotation"));
	}

	public GoyocephaleSkeleton(EntityType<? extends GoyocephaleSkeleton> type, Level worldIn) {
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
		//HeadbuttOne, HeadbuttTwo, Brace, Rear, Step, Feeding, Sit, Sleep, Death
		if (itemstack.getItem() == PFItems.GEOLOGY_HAMMER.get()) {
			if (!this.isHeadbuttOne() && !this.isHeadbuttTwo() && !this.isBrace() && !this.isRear() && !this.isStep() && !this.isFeeding() && !this.isSit() && !this.isSleep() && !this.isDeath() && !player.isShiftKeyDown()) {
				this.setHeadbuttOne(true);
			} else if (this.isHeadbuttOne() && !player.isShiftKeyDown()) {
				this.setHeadbuttOne(false);
				this.setHeadbuttTwo(true);
			} else if (this.isHeadbuttTwo() && !player.isShiftKeyDown()) {
				this.setHeadbuttTwo(false);
				this.setBrace(true);
			} else if (this.isBrace() && !player.isShiftKeyDown()) {
				this.setBrace(false);
				this.setRear(true);
			} else if (this.isRear() && !player.isShiftKeyDown()) {
				this.setRear(false);
				this.setStep(true);
			} else if (this.isStep() && !player.isShiftKeyDown()) {
				this.setStep(false);
				this.setFeeding(true);
			} else if (this.isFeeding() && !player.isShiftKeyDown()) {
				this.setFeeding(false);
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
		Block.popResource(this.level(), this.blockPosition(), new ItemStack(PFItems.GOYOCEPHALE_SKELETON.get()));
	}

	static class LookAtPlayerGoal extends net.minecraft.world.entity.ai.goal.LookAtPlayerGoal {

		GoyocephaleSkeleton entity;

		public LookAtPlayerGoal(GoyocephaleSkeleton entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
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
		return new ItemStack(PFItems.GOYOCEPHALE_SKELETON.get());
	}

}