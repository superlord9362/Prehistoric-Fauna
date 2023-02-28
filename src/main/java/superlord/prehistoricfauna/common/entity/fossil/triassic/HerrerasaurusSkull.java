package superlord.prehistoricfauna.common.entity.fossil.triassic;

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

public class HerrerasaurusSkull extends PrehistoricEntity {

	private static final EntityDataAccessor<Boolean> PUSHING = SynchedEntityData.defineId(HerrerasaurusSkull.class, EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Boolean> LOOKING = SynchedEntityData.defineId(HerrerasaurusSkull.class, EntityDataSerializers.BOOLEAN);

	public boolean isPushable() {
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
	
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(PUSHING, false);
		this.entityData.define(LOOKING, false);
	}
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsPushable", this.isPushable());
		compound.putBoolean("IsLooking", this.isLooking());
	}
	
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound); 
		this.setPushable(compound.getBoolean("IsPushable"));
		this.setLooking(compound.getBoolean("IsLooking"));
	}
	
	public HerrerasaurusSkull(EntityType<? extends HerrerasaurusSkull> type, Level worldIn) {
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

	public boolean canBePushed() {
		return this.isPushable();
	}
	
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
	    if (itemstack.getItem() == PFItems.GEOLOGY_HAMMER.get()) {
	    	if (player.isShiftKeyDown() && !this.isPushable() && !this.isLooking()) {
	    		this.setPushable(true);
				player.sendMessage(new TranslatableComponent("entity.prehistoricfauna.skeleton.pushable"), player.getUUID());
	    	} else if (player.isShiftKeyDown() && this.isPushable()) {
	    		this.setPushable(false);
	    		this.setLooking(true);
				player.sendMessage(new TranslatableComponent("entity.prehistoricfauna.skeleton.rotating"), player.getUUID());
	    	} else if (player.isShiftKeyDown() && this.isLooking()) {
	    		this.setLooking(false);
				player.sendMessage(new TranslatableComponent("entity.prehistoricfauna.skeleton.neutral"), player.getUUID());
	    	}
	    }
        return super.mobInteract(player, hand);
	}

	protected void collideWithEntity(Entity entityIn) {
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
			this.kill();
			this.playBrokenSound();
			this.playParticles();
			Player player = (Player)source.getDirectEntity();
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
		this.kill();
	}

	private void spawnFossil(DamageSource p_213815_1_) {
	      Block.popResource(this.level, this.blockPosition(), new ItemStack(PFItems.HERRERASAURUS_SKULL.get()));
	}
	
	static class LookAtPlayerGoal extends net.minecraft.world.entity.ai.goal.LookAtPlayerGoal {

		HerrerasaurusSkull entity;
		
		public LookAtPlayerGoal(HerrerasaurusSkull entityIn, Class<? extends LivingEntity> watchTargetClass, float maxDistance) {
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
		return new ItemStack(PFItems.HERRERASAURUS_SKULL.get());
	}

}