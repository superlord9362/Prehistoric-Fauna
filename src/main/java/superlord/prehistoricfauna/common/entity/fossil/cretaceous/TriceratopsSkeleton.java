package superlord.prehistoricfauna.common.entity.fossil.cretaceous;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
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
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.entity.PrehistoricEntity;
import superlord.prehistoricfauna.init.PFItems;

public class TriceratopsSkeleton extends PrehistoricEntity {
	private static final EntityDataAccessor<Boolean> CHARGING = SynchedEntityData.defineId(TriceratopsSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SLEEPING = SynchedEntityData.defineId(TriceratopsSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> CLASSICAL = SynchedEntityData.defineId(TriceratopsSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SITTING = SynchedEntityData.defineId(TriceratopsSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ACTION_LEFT = SynchedEntityData.defineId(TriceratopsSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> ACTION_RIGHT = SynchedEntityData.defineId(TriceratopsSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> PUSHING = SynchedEntityData.defineId(TriceratopsSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> LOOKING = SynchedEntityData.defineId(TriceratopsSkeleton.class, EntityDataSerializers.BOOLEAN);

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
	
	public boolean isCharging() {
		return this.entityData.get(CHARGING);
	}

	private void setCharging(boolean isCharging) {
		this.entityData.set(CHARGING, isCharging);
	}
	
	public boolean isSleeping() {
		return this.entityData.get(SLEEPING);
	}

	private void setSleeping(boolean isSleeping) {
		this.entityData.set(SLEEPING, isSleeping);
	}
	
	public boolean isClassical() {
		return this.entityData.get(CLASSICAL);
	}

	private void setClassical(boolean isClassical) {
		this.entityData.set(CLASSICAL, isClassical);
	}
	
	public boolean isSitting() {
		return this.entityData.get(SITTING);
	}

	private void setSitting(boolean isSitting) {
		this.entityData.set(SITTING, isSitting);
	}
	
	public boolean isActionLeft() {
		return this.entityData.get(ACTION_LEFT);
	}

	private void setActionLeft(boolean isActionLeft) {
		this.entityData.set(ACTION_LEFT, isActionLeft);
	}
	
	public boolean isActionRight() {
		return this.entityData.get(ACTION_RIGHT);
	}

	private void setActionRight(boolean isActionRight) {
		this.entityData.set(ACTION_RIGHT, isActionRight);
	}
	
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(CHARGING, false);
		this.entityData.define(SLEEPING, false);
		this.entityData.define(CLASSICAL, false);
		this.entityData.define(PUSHING, false);
		this.entityData.define(LOOKING, false);
		this.entityData.define(SITTING, false);
		this.entityData.define(ACTION_RIGHT, false);
		this.entityData.define(ACTION_LEFT, false);
	}
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsCharging", this.isCharging());
		compound.putBoolean("IsSleeping", this.isSleeping());
		compound.putBoolean("IsClassical", this.isClassical());
		compound.putBoolean("IsSitting", this.isSitting());
		compound.putBoolean("IsActionRight", this.isActionRight());
		compound.putBoolean("IsActionLeft", this.isActionLeft());
		compound.putBoolean("IsPushable", this.isPushableState());
		compound.putBoolean("IsLooking", this.isLooking());
	}
	
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound); 
		this.setCharging(compound.getBoolean("IsCharging"));
		this.setSleeping(compound.getBoolean("IsSleeping"));
		this.setClassical(compound.getBoolean("IsClassical"));
		this.setSitting(compound.getBoolean("IsSitting"));
		this.setActionLeft(compound.getBoolean("IsActionLeft"));
		this.setActionRight(compound.getBoolean("IsActionRight"));
		this.setPushable(compound.getBoolean("IsPushable"));
		this.setLooking(compound.getBoolean("IsLooking"));
	}
	
	public TriceratopsSkeleton(EntityType<? extends TriceratopsSkeleton> type, Level worldIn) {
		super(type, worldIn);
	}

	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 8.0F));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0D);
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
	    	if (!this.isCharging() && !this.isSleeping() && !this.isClassical() && !this.isSitting() && !this.isActionLeft() && !this.isActionRight() && !player.isShiftKeyDown()) {
				this.setClassical(true);
			} else if (this.isClassical() && !player.isShiftKeyDown()) {
				this.setClassical(false);
				this.setSitting(true);
			} else if (this.isSitting() && !player.isShiftKeyDown()) {
				this.setSitting(false);
				this.setSleeping(true);
			} else if (this.isSleeping() && !player.isShiftKeyDown()) {
				this.setSleeping(false);
				this.setCharging(true);
			} else if (this.isCharging() && !player.isShiftKeyDown()) {
				this.setCharging(false);
				this.setActionLeft(true);
			} else if (this.isActionLeft() && !player.isShiftKeyDown()) {
				this.setActionLeft(false);
				this.setActionRight(true);
			} else if (this.isActionRight() && !player.isShiftKeyDown()) {
				this.setActionRight(false);
	    	} else if (player.isShiftKeyDown() && !this.isPushableState() && !this.isLooking()) {
	    		this.setPushable(true);
				player.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.skeleton.pushable"), true);
	    	} else if (player.isShiftKeyDown() && this.isPushableState()) {
	    		this.setPushable(false);
	    		this.setLooking(true);
				player.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.skeleton.rotating"), true);
	    	} else if (player.isShiftKeyDown() && this.isLooking()) {
	    		this.setLooking(false);
				player.displayClientMessage(new TranslatableComponent("entity.prehistoricfauna.skeleton.neutral"), true);
	    	}
	    }
        return super.mobInteract(player, hand);
	}

	protected void doPush(Entity entityIn) {
	}

	private void playBrokenSound() {
		this.level.playSound((Player)null, this.getX(), this.getY(), this.getZ(), SoundEvents.SKELETON_HURT, this.getSoundSource(), 1.0F, 1.0F);
	}

	private void playParticles() {
		if (this.level instanceof ServerLevel) {
			((ServerLevel)this.level).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.BONE_BLOCK.defaultBlockState()), this.getX(), this.getY(0.6666666666666666D), this.getZ(), 10, (double)(this.getBbWidth() / 4.0F), (double)(this.getBbHeight() / 4.0F), (double)(this.getBbWidth() / 4.0F), 0.05D);
		}
	}


	public boolean hurt(DamageSource source, float amount) {
		if (source.getDirectEntity() instanceof Player) {
			this.playBrokenSound();
			this.playParticles();
			Player player = (Player)source.getDirectEntity();
			if (!player.isCreative()) {
				this.spawnFossil(source);
			}
			this.remove(RemovalReason.KILLED);
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
	      Block.popResource(this.level, this.blockPosition(), new ItemStack(PFItems.TRICERATOPS_SKELETON.get()));
	}
	
	static class LookAtPlayerGoal extends net.minecraft.world.entity.ai.goal.LookAtPlayerGoal {

		TriceratopsSkeleton entity;
		
		public LookAtPlayerGoal(TriceratopsSkeleton entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
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
		return new ItemStack(PFItems.TRICERATOPS_SKELETON.get());
	}

}