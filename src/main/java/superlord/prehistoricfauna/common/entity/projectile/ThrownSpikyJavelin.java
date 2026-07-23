package superlord.prehistoricfauna.common.entity.projectile;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import superlord.prehistoricfauna.init.PFEffects;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;

public class ThrownSpikyJavelin extends AbstractArrow {

    private static final float PROJECTILE_DAMAGE = 6.0f;
    private static final int BLEED_DURATION = 100;
    private static final EntityDataAccessor<ItemStack> DATA_JAVELIN_STACK = SynchedEntityData.defineId(ThrownSpikyJavelin.class, EntityDataSerializers.ITEM_STACK);

    public ThrownSpikyJavelin(EntityType<? extends ThrownSpikyJavelin> type, Level level) {
        super(type, level);
        this.pickup = Pickup.ALLOWED;
    }

    public ThrownSpikyJavelin(Level level, LivingEntity thrower, ItemStack stack) {
        super(PFEntities.THROWN_SPIKY_JAVELIN.get(), thrower, level);
        this.entityData.set(DATA_JAVELIN_STACK, stack.copy());
        this.setBaseDamage(PROJECTILE_DAMAGE);
        this.setCritArrow(false);
        this.pickup = Pickup.ALLOWED;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_JAVELIN_STACK, new ItemStack(PFItems.SPIKY_JAVELIN.get()));
    }

    public ItemStack getJavelinStack() {
        return this.entityData.get(DATA_JAVELIN_STACK);
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        Entity target = hitResult.getEntity();
        Entity owner = this.getOwner();
        DamageSource source = owner instanceof Player p ? this.level().damageSources().trident(this, p) : this.level().damageSources().trident(this, this);
        target.hurt(source, PROJECTILE_DAMAGE);

        if (target instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(PFEffects.BLEEDING.get(), BLEED_DURATION, 0, true, false));
        }

        this.playSound(SoundEvents.TRIDENT_HIT, 1.0F, 1.0F);
        Vec3 currentMotion = this.getDeltaMovement();
        this.setDeltaMovement(currentMotion.x * -0.2, currentMotion.y * 0.4, currentMotion.z * -0.2);
        this.hasImpulse = true;
        this.inGround = false;
    }

    @Override
    protected void onHitBlock(BlockHitResult hitResult) {
        super.onHitBlock(hitResult);
        this.playSound(SoundEvents.TRIDENT_HIT_GROUND, 1.0F, 1.0F);
    }

    @Override
    protected ItemStack getPickupItem() {
        return getJavelinStack().copy();
    }
    
    @Override
    public void playerTouch(Player pPlayer) {
        if (!this.level().isClientSide() && (this.inGround || this.isNoPhysics()) && this.shakeTime <= 0) {
            boolean canPickup;

            if (pPlayer.getAbilities().instabuild) {
                canPickup = true;
            } else {
                canPickup = pPlayer.getInventory().add(this.getPickupItem());
            }

            if (canPickup) {
                this.playSound(SoundEvents.ARROW_HIT, 1.0F, 1.0F);
                pPlayer.take(this, 1);
                this.discard();
            }
        }
    }

    @Override
    protected float getWaterInertia() {
        return 0.5F;
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        CompoundTag itemTag = new CompoundTag();
        getJavelinStack().save(itemTag);
        tag.put("JavelinStack", itemTag);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("JavelinStack")) this.entityData.set(DATA_JAVELIN_STACK, ItemStack.of(tag.getCompound("JavelinStack")));
    }
}