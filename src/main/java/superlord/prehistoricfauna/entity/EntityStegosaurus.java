package superlord.prehistoricfauna.entity;

import com.google.common.base.Predicate;
import superlord.prehistoricfauna.init.ModItems;
import superlord.prehistoricfauna.util.handlers.LootTableHandler;
import superlord.prehistoricfauna.util.handlers.Sounds;

import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityStegosaurus extends EntityAnimal
{
    private static final DataParameter<Boolean> IS_STANDING = EntityDataManager.<Boolean>createKey(EntityStegosaurus.class, DataSerializers.BOOLEAN);
    private float clientSideStandAnimation0;
    private float clientSideStandAnimation;
    private int warningSoundTicks;
    public int timeUntilNextEgg;

    public EntityStegosaurus(World worldIn)
    {
        super(worldIn);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        this.setSize(2.0F, 3.0F);
    }
    
    public EntityAgeable createChild(EntityAgeable ageable)
    {
        return new EntityStegosaurus(this.world);
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack stack)
    {
        return false;
    }
    
    private int sheepTimer;
    private EntityAIEatGrass entityAIEatGrass;

    protected void initEntityAI()
    {
        super.initEntityAI();
        this.entityAIEatGrass = new EntityAIEatGrass(this);
        this.tasks.addTask(5, this.entityAIEatGrass);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityStegosaurus.AIMeleeAttack());
        this.tasks.addTask(1, new EntityStegosaurus.AIPanic());
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityStegosaurus.AIHurtByTarget());
        this.targetTasks.addTask(2, new EntityStegosaurus.AIAttackPlayer());
    }
    
    public void onLivingUpdate()
    {
        if (this.world.isRemote)
        {
            this.sheepTimer = Math.max(0, this.sheepTimer - 1);
        }
        if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextEgg <= 0)
        {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(ModItems.STEGOSAURUS_EGG, 1);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }

        super.onLivingUpdate();
    }
    
    protected void updateAITasks()
    {
        this.sheepTimer = this.entityAIEatGrass.getEatingGrassTimer();
        super.updateAITasks();
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(142.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
    }

    protected SoundEvent getAmbientSound()
    {
    	return Sounds.TRICERATOPS_IDLE;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_)
    {
        return Sounds.TRICERATOPS_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return Sounds.TRICERATOPS_HURT;
    }

    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
    }

    protected void playWarningSound()
    {
        if (this.warningSoundTicks <= 0)
        {
            this.playSound(Sounds.TRICERATOPS_ANGRY, 1.0F, 1.0F);
            this.warningSoundTicks = 40;
        }
    }

    @Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableHandler.STEGOSAURUS;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(IS_STANDING, Boolean.valueOf(false));
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        if (this.world.isRemote)
        {
            this.clientSideStandAnimation0 = this.clientSideStandAnimation;

            if (this.isStanding())
            {
                this.clientSideStandAnimation = MathHelper.clamp(this.clientSideStandAnimation + 1.0F, 0.0F, 6.0F);
            }
            else
            {
                this.clientSideStandAnimation = MathHelper.clamp(this.clientSideStandAnimation - 1.0F, 0.0F, 6.0F);
            }
        }

        if (this.warningSoundTicks > 0)
        {
            --this.warningSoundTicks;
        }
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));

        if (flag)
        {
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    public boolean isStanding()
    {
        return ((Boolean)this.dataManager.get(IS_STANDING)).booleanValue();
    }

    public void setStanding(boolean standing)
    {
        this.dataManager.set(IS_STANDING, Boolean.valueOf(standing));
    }

    @SideOnly(Side.CLIENT)
    public float getStandingAnimationScale(float p_189795_1_)
    {
        return (this.clientSideStandAnimation0 + (this.clientSideStandAnimation - this.clientSideStandAnimation0) * p_189795_1_) / 6.0F;
    }

    protected float getWaterSlowDown()
    {
        return 0.98F;
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata)
    {
        if (livingdata instanceof EntityStegosaurus.GroupData)
        {
            if (((EntityStegosaurus.GroupData)livingdata).madeParent)
            {
                this.setGrowingAge(-24000);
            }
        }
        else
        {
            EntityStegosaurus.GroupData entitypolarbear$groupdata = new EntityStegosaurus.GroupData();
            entitypolarbear$groupdata.madeParent = true;
            livingdata = entitypolarbear$groupdata;
        }

        return livingdata;
    }

    class AIAttackPlayer extends EntityAINearestAttackableTarget<EntityPlayer>
    {
        public AIAttackPlayer()
        {
            super(EntityStegosaurus.this, EntityPlayer.class, 20, true, true, (Predicate)null);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            if (EntityStegosaurus.this.isChild())
            {
                return false;
            }
            else
            {
                if (super.shouldExecute())
                {
                    for (EntityStegosaurus entitypolarbear : EntityStegosaurus.this.world.getEntitiesWithinAABB(EntityStegosaurus.class, EntityStegosaurus.this.getEntityBoundingBox().grow(8.0D, 4.0D, 8.0D)))
                    {
                        if (entitypolarbear.isChild())
                        {
                            return true;
                        }
                    }
                }

                EntityStegosaurus.this.setAttackTarget((EntityLivingBase)null);
                return false;
            }
        }

        protected double getTargetDistance()
        {
            return super.getTargetDistance() * 0.5D;
        }
    }

    class AIHurtByTarget extends EntityAIHurtByTarget
    {
        public AIHurtByTarget()
        {
            super(EntityStegosaurus.this, false);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            super.startExecuting();

            if (EntityStegosaurus.this.isChild())
            {
                this.alertOthers();
                this.resetTask();
            }
        }

        protected void setEntityAttackTarget(EntityCreature creatureIn, EntityLivingBase entityLivingBaseIn)
        {
            if (creatureIn instanceof EntityStegosaurus && !creatureIn.isChild())
            {
                super.setEntityAttackTarget(creatureIn, entityLivingBaseIn);
            }
        }
    }

    class AIMeleeAttack extends EntityAIAttackMelee
    {
        public AIMeleeAttack()
        {
            super(EntityStegosaurus.this, 1.25D, true);
        }

        protected void checkAndPerformAttack(EntityLivingBase p_190102_1_, double p_190102_2_)
        {
            double d0 = this.getAttackReachSqr(p_190102_1_);

            if (p_190102_2_ <= d0 && this.attackTick <= 0)
            {
                this.attackTick = 20;
                this.attacker.attackEntityAsMob(p_190102_1_);
                EntityStegosaurus.this.setStanding(false);
            }
            else if (p_190102_2_ <= d0 * 2.0D)
            {
                if (this.attackTick <= 0)
                {
                    EntityStegosaurus.this.setStanding(false);
                    this.attackTick = 20;
                }

                if (this.attackTick <= 10)
                {
                    EntityStegosaurus.this.setStanding(true);
                    EntityStegosaurus.this.playWarningSound();
                }
            }
            else
            {
                this.attackTick = 20;
                EntityStegosaurus.this.setStanding(false);
            }
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask()
        {
            EntityStegosaurus.this.setStanding(false);
            super.resetTask();
        }

        protected double getAttackReachSqr(EntityLivingBase attackTarget)
        {
            return (double)(4.0F + attackTarget.width);
        }
    }

    class AIPanic extends EntityAIPanic
    {
        public AIPanic()
        {
            super(EntityStegosaurus.this, 2.0D);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            return !EntityStegosaurus.this.isChild() && !EntityStegosaurus.this.isBurning() ? false : super.shouldExecute();
        }
    }

    static class GroupData implements IEntityLivingData
        {
            public boolean madeParent;

            private GroupData()
            {
            }
        }
}