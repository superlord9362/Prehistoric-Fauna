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

public class YutyrannusSkeleton extends PrehistoricEntity {
	private static final EntityDataAccessor<Boolean> SAUNTER = SynchedEntityData.defineId(YutyrannusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ROMP = SynchedEntityData.defineId(YutyrannusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> FROLIC = SynchedEntityData.defineId(YutyrannusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> JP = SynchedEntityData.defineId(YutyrannusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> LEAP = SynchedEntityData.defineId(YutyrannusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SUBDUED = SynchedEntityData.defineId(YutyrannusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SLEEP = SynchedEntityData.defineId(YutyrannusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> CARCASS = SynchedEntityData.defineId(YutyrannusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> PUSHING = SynchedEntityData.defineId(YutyrannusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> LOOKING = SynchedEntityData.defineId(YutyrannusSkeleton.class, EntityDataSerializers.BOOLEAN);

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

	public boolean isSaunter() {
		return this.entityData.get(SAUNTER);
	}

	private void setSaunter(boolean isSaunter) {
		this.entityData.set(SAUNTER, isSaunter);
	}

	public boolean isRomp() {
		return this.entityData.get(ROMP);
	}

	private void setRomp(boolean isRomp) {
		this.entityData.set(ROMP, isRomp);
	}

	public boolean isFrolic() {
		return this.entityData.get(FROLIC);
	}

	private void setFrolic(boolean isFrolic) {
		this.entityData.set(FROLIC, isFrolic);
	}

	public boolean isJP() {
		return this.entityData.get(JP);
	}

	private void setJP(boolean isJP) {
		this.entityData.set(JP, isJP);
	}
	
	public boolean isLeap() {
		return this.entityData.get(LEAP);
	}

	private void setLeap(boolean isLeap) {
		this.entityData.set(LEAP, isLeap);
	}
	
	public boolean isSubdued() {
		return this.entityData.get(SUBDUED);
	}

	private void setSubdued(boolean isSubdued) {
		this.entityData.set(SUBDUED, isSubdued);
	}
	
	public boolean isSleep() {
		return this.entityData.get(SLEEP);
	}

	private void setSleep(boolean isSleep) {
		this.entityData.set(SLEEP, isSleep);
	}
	
	public boolean isCarcass() {
		return this.entityData.get(CARCASS);
	}

	private void setCarcass(boolean isCarcass) {
		this.entityData.set(CARCASS, isCarcass);
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SAUNTER, false);
		this.entityData.define(ROMP, false);
		this.entityData.define(FROLIC, false);
		this.entityData.define(JP, false);
		this.entityData.define(LEAP, false);
		this.entityData.define(SUBDUED, false);
		this.entityData.define(SLEEP, false);
		this.entityData.define(CARCASS, false);
		this.entityData.define(PUSHING, false);
		this.entityData.define(LOOKING, false);
	}
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsSaunter", this.isSaunter());
		compound.putBoolean("IsRomp", this.isRomp());
		compound.putBoolean("IsFrolic", this.isFrolic());
		compound.putBoolean("IsJP", this.isJP());
		compound.putBoolean("IsLeap", this.isLeap());
		compound.putBoolean("IsSubdued", this.isSubdued());
		compound.putBoolean("IsSleep", this.isSleep());
		compound.putBoolean("IsCarcass", this.isCarcass());
		compound.putBoolean("IsPushable", this.isPushableState());
		compound.putBoolean("IsLooking", this.isLooking());
	}

	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound); 
		this.setSaunter(compound.getBoolean("IsSaunter"));
		this.setRomp(compound.getBoolean("IsRomp"));
		this.setFrolic(compound.getBoolean("IsFrolic"));
		this.setJP(compound.getBoolean("IsJP"));
		this.setLeap(compound.getBoolean("IsLeap"));
		this.setSubdued(compound.getBoolean("IsSubdued"));
		this.setSleep(compound.getBoolean("IsSleep"));
		this.setCarcass(compound.getBoolean("IsCarcass"));
		this.setPushable(compound.getBoolean("IsPushable"));
		this.setLooking(compound.getBoolean("IsLooking"));
	}

	public YutyrannusSkeleton(EntityType<? extends YutyrannusSkeleton> type, Level worldIn) {
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
			if (!this.isSaunter() && !this.isRomp() && !this.isFrolic() && !this.isJP() && !this.isLeap() && !this.isSubdued() && !this.isSleep() && !this.isCarcass() && !player.isShiftKeyDown()) {
				this.setSaunter(true);
			} else if (this.isSaunter() && !player.isShiftKeyDown()) {
				this.setSaunter(false);
				this.setRomp(true);
			} else if (this.isRomp() && !player.isShiftKeyDown()) {
				this.setRomp(false);
				this.setFrolic(true);
			} else if (this.isFrolic() && !player.isShiftKeyDown()) {
				this.setFrolic(false);
				this.setJP(true);
			} else if (this.isJP() && !player.isShiftKeyDown()) {
				this.setJP(false);
				this.setLeap(true);
			} else if (this.isLeap() && !player.isShiftKeyDown()) {
				this.setLeap(false);
				this.setSubdued(true);
			} else if (this.isSubdued() && !player.isShiftKeyDown()) {
				this.setSubdued(false);
				this.setSleep(true);
			} else if (this.isSleep() && !player.isShiftKeyDown()) {
				this.setSleep(false);
				this.setCarcass(true);
			} else if (this.isCarcass() && !player.isShiftKeyDown()) {
				this.setCarcass(false);
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
		Block.popResource(this.level(), this.blockPosition(), new ItemStack(PFItems.ANKYLOSAURUS_SKELETON.get()));
	}

	static class LookAtPlayerGoal extends net.minecraft.world.entity.ai.goal.LookAtPlayerGoal {

		YutyrannusSkeleton entity;

		public LookAtPlayerGoal(YutyrannusSkeleton entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
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
		return new ItemStack(PFItems.YUTYRANNUS_SKELETON.get());
	}

}