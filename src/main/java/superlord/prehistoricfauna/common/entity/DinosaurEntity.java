package superlord.prehistoricfauna.common.entity;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.Tags;

public class DinosaurEntity extends TamableAnimal {
	
	private static final EntityDataAccessor<Boolean> ASLEEP = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> ATTACK_TICK = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> ATTACK_DIR = SynchedEntityData.defineId(DinosaurEntity.class, EntityDataSerializers.BOOLEAN);
    private float sleepProgress = 0.0F;
    private float prevSleepProgress = 0.0F;
    private float meleeProgress = 0.0F;
    private float prevMeleeProgress = 0.0F;
    
	protected DinosaurEntity(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
		super(p_21803_, p_21804_);
	}
	
	public static boolean canDinosaurSpawn(EntityType<? extends Animal> animal, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, Random random) {
        return (worldIn.getBlockState(pos.below()).is(BlockTags.DIRT) || worldIn.getBlockState(pos.below()).is(Tags.Blocks.SAND)) && worldIn.getRawBrightness(pos, 0) > 8;
    }

    public boolean isAsleep() {
        return this.entityData.get(ASLEEP);
    }

    public void setAsleep(boolean isAsleep) {
        this.entityData.set(ASLEEP, isAsleep);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ASLEEP, false);
        this.entityData.define(ATTACK_TICK, 0);
        this.entityData.define(ATTACK_DIR, false);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("IsAsleep", this.isAsleep());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setAsleep(compound.getBoolean("IsAsleep"));
    }
    
    public void tick() {
        super.tick();
        prevSleepProgress = sleepProgress;
        prevMeleeProgress = meleeProgress;
        if (this.isAsleep() && sleepProgress < 1.0F) {
            sleepProgress = Math.min(sleepProgress + 0.2F, 1.0F);
        }
        if (!this.isAsleep() && sleepProgress > 0.0F) {
            sleepProgress = Math.max(sleepProgress - 0.2F, 0.0F);
        }
        if (this.entityData.get(ATTACK_TICK) > 0) {
            LivingEntity target = this.getTarget();
            if (this.entityData.get(ATTACK_TICK) == 1 && target != null && this.hasLineOfSight(target) && this.distanceTo(target) < this.getMeleeRange() + this.getBbWidth() + target.getBbWidth()) {
                this.onAttackAnimationFinish(target);
            }
            this.entityData.set(ATTACK_TICK, this.entityData.get(ATTACK_TICK) - 1);
            if (meleeProgress < 1.0F) {
                meleeProgress = Math.min(meleeProgress + 0.2F, 1.0F);
            }
        } else {
            if (meleeProgress > 0F) {
                meleeProgress = Math.max(meleeProgress - 0.2F, 0.0F);
            }
        }
    }

    //additional melee range, change this for dinosaurs with longer reach
    public float getMeleeRange() {
        return 1.5F;
    }

    //some dinosaurs(ex. ankylosaurus) have alternate attack patterns that have left/right differences. This boolean is true if the current melee attack is coming from the left and false if from the right.
    public boolean getMeleeDirection() {
        return this.entityData.get(ATTACK_DIR);
    }

    public boolean doHurtTarget(Entity entityIn) {
        if(this.entityData.get(ATTACK_TICK) == 0){
            this.entityData.set(ATTACK_DIR, random.nextBoolean());
        }
        //now simply starts counting down till the actual damage is done, starts the animation
        this.entityData.set(ATTACK_TICK, 7);
        return true;
    }

    public boolean onAttackAnimationFinish(Entity target) {
        return target.hurt(DamageSource.mobAttack(this), (float) ((int) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue()));
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
    public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
        return null;
    }

}
