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

public class TyrannosaurusSkeleton extends PrehistoricEntity {
	private static final EntityDataAccessor<Boolean> CLASSIC = SynchedEntityData.defineId(TyrannosaurusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> RESTING = SynchedEntityData.defineId(TyrannosaurusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> JURASSIC = SynchedEntityData.defineId(TyrannosaurusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> RUNNING = SynchedEntityData.defineId(TyrannosaurusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> SLEEPING = SynchedEntityData.defineId(TyrannosaurusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> STOMPING = SynchedEntityData.defineId(TyrannosaurusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> STALKING = SynchedEntityData.defineId(TyrannosaurusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> PUSHING = SynchedEntityData.defineId(TyrannosaurusSkeleton.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> LOOKING = SynchedEntityData.defineId(TyrannosaurusSkeleton.class, EntityDataSerializers.BOOLEAN);

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
	
	public boolean isClassical() {
		return this.entityData.get(CLASSIC);
	}

	private void setClassical(boolean isClassical) {
		this.entityData.set(CLASSIC, isClassical);
	}
	
	public boolean isRunning() {
		return this.entityData.get(RUNNING);
	}

	private void setRunning(boolean isRunning) {
		this.entityData.set(RUNNING, isRunning);
	}
	
	public boolean isStomping() {
		return this.entityData.get(STOMPING);
	}

	private void setStomping(boolean isStomping) {
		this.entityData.set(STOMPING, isStomping);
	}
	
	public boolean isSleeping() {
		return this.entityData.get(SLEEPING);
	}

	private void setSleeping(boolean isSleeping) {
		this.entityData.set(SLEEPING, isSleeping);
	}
	
	public boolean isResting() {
		return this.entityData.get(RESTING);
	}

	private void setResting(boolean isResting) {
		this.entityData.set(RESTING, isResting);
	}
	
	public boolean isJurassicParkReference() {
		return this.entityData.get(JURASSIC);
	}

	private void setJurassicParkReference(boolean isJurassicParkReference) {
		this.entityData.set(JURASSIC, isJurassicParkReference);
	}
	
	public boolean isStalking() {
		return this.entityData.get(STALKING);
	}

	private void setStalking(boolean isStalking) {
		this.entityData.set(STALKING, isStalking);
	}
	
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(CLASSIC, false);
		this.entityData.define(RUNNING, false);
		this.entityData.define(SLEEPING, false);
		this.entityData.define(STOMPING, false);
		this.entityData.define(RESTING, false);
		this.entityData.define(JURASSIC, false);
		this.entityData.define(PUSHING, false);
		this.entityData.define(LOOKING, false);
		this.entityData.define(STALKING, false);
	}
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsClassical", this.isClassical());
		compound.putBoolean("IsSleeping", this.isSleeping());
		compound.putBoolean("IsStomping", this.isStomping());
		compound.putBoolean("IsRunning", this.isRunning());
		compound.putBoolean("IsResting", this.isResting());
		compound.putBoolean("IsJurassicParkReference", this.isJurassicParkReference());
		compound.putBoolean("IsPushable", this.isPushableState());
		compound.putBoolean("IsLooking", this.isLooking());
		compound.putBoolean("IsStalking", this.isStalking());
	}
	
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound); 
		this.setClassical(compound.getBoolean("IsClassical"));
		this.setRunning(compound.getBoolean("IsRunning"));
		this.setSleeping(compound.getBoolean("IsSleeping"));
		this.setStomping(compound.getBoolean("IsStomping"));
		this.setResting(compound.getBoolean("IsResting"));
		this.setJurassicParkReference(compound.getBoolean("IsJurassicParkReference"));
		this.setPushable(compound.getBoolean("IsPushable"));
		this.setLooking(compound.getBoolean("IsLooking"));
		this.setStalking(compound.getBoolean("IsStalking"));
	}
	
	public TyrannosaurusSkeleton(EntityType<? extends TyrannosaurusSkeleton> type, Level worldIn) {
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
	    	if (!this.isJurassicParkReference() && !this.isRunning() && !this.isSleeping() && !this.isStomping() && !this.isStalking() && !this.isClassical() && !this.isResting() && !player.isShiftKeyDown()) {
				this.setStalking(true);
			} else if (this.isStalking() && !player.isShiftKeyDown()) {
				this.setStalking(false);
				this.setRunning(true);
			} else if (this.isRunning() && !player.isShiftKeyDown()) {
				this.setRunning(false);
				this.setStomping(true);
			} else if (this.isStomping() && !player.isShiftKeyDown()) {
				this.setStomping(false);
				this.setJurassicParkReference(true);
			} else if (this.isJurassicParkReference() && !player.isShiftKeyDown()) {
				this.setJurassicParkReference(false);
				this.setClassical(true);
			} else if (this.isClassical() && !player.isShiftKeyDown()) {
				this.setClassical(false);
				this.setResting(true);
			} else if (this.isResting() && !player.isShiftKeyDown()) {
				this.setResting(false);
				this.setSleeping(true);
			} else if (this.isSleeping() && !player.isShiftKeyDown()) {
				this.setSleeping(false);
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
	      Block.popResource(this.level, this.blockPosition(), new ItemStack(PFItems.TYRANNOSAURUS_SKELETON.get()));
	}
	
	static class LookAtPlayerGoal extends net.minecraft.world.entity.ai.goal.LookAtPlayerGoal {

		TyrannosaurusSkeleton entity;
		
		public LookAtPlayerGoal(TyrannosaurusSkeleton entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
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
		return new ItemStack(PFItems.TYRANNOSAURUS_SKELETON.get());
	}

}