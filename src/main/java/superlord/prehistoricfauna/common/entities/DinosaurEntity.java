package superlord.prehistoricfauna.common.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.Tags;

import java.util.Random;

public class DinosaurEntity extends TameableEntity {

    private static final DataParameter<Boolean> ASLEEP = EntityDataManager.createKey(DinosaurEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> ATTACK_TICK = EntityDataManager.createKey(DinosaurEntity.class, DataSerializers.VARINT);
    private float sleepProgress = 0.0F;
    private float prevSleepProgress = 0.0F;
    private float meleeProgress = 0.0F;
    private float prevMeleeProgress = 0.0F;

    public DinosaurEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static boolean canDinosaurSpawn(EntityType<? extends AnimalEntity> animal, IWorld worldIn, SpawnReason reason, BlockPos pos, Random random) {
        return (worldIn.getBlockState(pos.down()).isIn(Tags.Blocks.DIRT) || worldIn.getBlockState(pos.down()).isIn(Tags.Blocks.SAND)) && worldIn.getLightSubtracted(pos, 0) > 8;
    }

    public boolean isAsleep() {
        return this.dataManager.get(ASLEEP);
    }

    public void setAsleep(boolean isAsleep) {
        this.dataManager.set(ASLEEP, isAsleep);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(ASLEEP, false);
        this.dataManager.register(ATTACK_TICK, 0);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean("IsAsleep", this.isAsleep());
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setAsleep(compound.getBoolean("IsAsleep"));
    }

    public void tick() {
        super.tick();
        prevSleepProgress = sleepProgress;
        prevMeleeProgress = meleeProgress;
        if (this.isAsleep() && sleepProgress < 1.0F) {
            sleepProgress += 0.2F;
        }
        if (!this.isAsleep() && sleepProgress > 0.0F) {
            sleepProgress -= 0.2F;
        }
        if (this.dataManager.get(ATTACK_TICK) > 0) {
            LivingEntity target = this.getAttackTarget();
            if (this.dataManager.get(ATTACK_TICK) == 1 && target != null && this.canEntityBeSeen(target) && this.getDistance(target) < this.getMeleeRange() + this.getWidth() + target.getWidth()) {
                this.onAttackAnimationFinish(target);
            }
            this.dataManager.set(ATTACK_TICK, this.dataManager.get(ATTACK_TICK) - 1);
            if (meleeProgress < 1.0F) {
                meleeProgress += 0.2F;
            }
        } else {
            if (meleeProgress > 0F) {
                meleeProgress -= 0.2F;
            }
        }
    }

    //additional melee range, change this for dinosaurs with longer reach
    public float getMeleeRange() {
        return 1.5F;
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        //now simply starts counting down till the actual damage is done, starts the animation
        this.dataManager.set(ATTACK_TICK, 7);
        return true;
    }

    public boolean onAttackAnimationFinish(Entity target) {
        return target.attackEntityFrom(DamageSource.causeMobDamage(this), (float) ((int) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue()));
    }

    //lerped number from 0.0 - 1.0 that determines where in the sleep animation this entity is
    public float getSleepProgress(float partialTick) {
        return prevSleepProgress + (sleepProgress - prevSleepProgress) * partialTick;
    }

    //lerped number from 0.0 - 1.0 that determines where in the melee animation this entity is
    public float getMeleeProgress(float partialTick) {
        return prevMeleeProgress + (meleeProgress - prevMeleeProgress) * partialTick;
    }

    @Override
    public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }

}
