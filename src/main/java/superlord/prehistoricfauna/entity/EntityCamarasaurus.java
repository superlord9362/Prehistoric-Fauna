package superlord.prehistoricfauna.entity;



import com.google.common.base.Predicate;



import superlord.prehistoricfauna.entity.ai.EntityExtinct;

import superlord.prehistoricfauna.init.ModItems;

import superlord.prehistoricfauna.util.handlers.LootTableHandler;

import superlord.prehistoricfauna.util.handlers.Sounds;

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

import net.minecraftforge.fml.relauncher.Side;

import net.minecraftforge.fml.relauncher.SideOnly;



import javax.annotation.Nullable;



public class EntityCamarasaurus extends EntityExtinct {

    private static final DataParameter<Boolean> IS_STANDING = EntityDataManager.createKey(EntityCamarasaurus.class, DataSerializers.BOOLEAN);

    private static final DataParameter<Integer> MODEL_TYPE = EntityDataManager.createKey(EntityCamarasaurus.class, DataSerializers.VARINT);

    private float clientSideStandAnimation0;

    private float clientSideStandAnimation;

    private int warningSoundTicks;

    public int timeUntilNextEgg;

    public int result;



    public EntityCamarasaurus(World worldIn) {

        super(worldIn);

        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;

        this.setSize(2.0F, 3.0F);

        this.result = rand.nextInt(100);

    }



    @Override

    public EntityAgeable createChild(EntityAgeable ageable) {

        return new EntityCamarasaurus(this.world);

    }



    /**

     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on

     * the animal type)

     */

    @Override

    public boolean isBreedingItem(ItemStack stack) {

        return stack.getItem() == Items.WHEAT;

    }



    private int sheepTimer;

    private EntityAIEatGrass entityAIEatGrass;



    @Override

    protected void initEntityAI() {

        super.initEntityAI();

        this.entityAIEatGrass = new EntityAIEatGrass(this);

        this.tasks.addTask(5, this.entityAIEatGrass);

        this.tasks.addTask(0, new EntityAISwimming(this));

        this.tasks.addTask(1, new EntityCamarasaurus.AIMeleeAttack());

        this.tasks.addTask(1, new EntityCamarasaurus.AIPanic());

        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));

        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));

        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));

        this.tasks.addTask(7, new EntityAILookIdle(this));

        this.targetTasks.addTask(1, new EntityCamarasaurus.AIHurtByTarget());

        this.targetTasks.addTask(2, new EntityCamarasaurus.AIAttackPlayer());

    }



    @Override

    public void onLivingUpdate() {

        if (this.world.isRemote) {

            this.sheepTimer = Math.max(0, this.sheepTimer - 1);

        }

        if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextEgg <= 0) {

            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;

        }



        super.onLivingUpdate();

    }



    @Override

    protected void updateAITasks() {

        this.sheepTimer = this.entityAIEatGrass.getEatingGrassTimer();

        super.updateAITasks();

    }



    @Override

    protected void applyEntityAttributes() {

        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(600.0D);

        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);

        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);

        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);

        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);

    }



    @Override

    protected SoundEvent getAmbientSound() {

        return Sounds.CAMARASAURUS_IDLE;

    }



    @Override

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {

        return Sounds.CAMARASAURUS_HURT;

    }



    @Override

    protected SoundEvent getDeathSound() {

        return Sounds.CAMARASAURUS_HURT;

    }



    @Override

    protected void playStepSound(BlockPos pos, Block blockIn) {

        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);

    }



    protected void playWarningSound() {

        if (this.warningSoundTicks <= 0) {

            this.playSound(Sounds.CAMARASAURUS_ANGRY, 1.0F, 1.0F);

            this.warningSoundTicks = 40;

        }

    }



    @Override

    @Nullable

    protected ResourceLocation getLootTable() {

        return LootTableHandler.CAMARASAURUS;

    }



    @Override

    protected void entityInit() {

        super.entityInit();

        dataManager.register(IS_STANDING, false);

        dataManager.register(MODEL_TYPE, 0);

    }



    public int getModelType() {

        return dataManager.get(MODEL_TYPE);

    }



    public void setModelType(int modelType) {

        dataManager.set(MODEL_TYPE, modelType);

    }



    @Override

    public void readEntityFromNBT(NBTTagCompound compound) {

        super.readEntityFromNBT(compound);

        dataManager.set(IS_STANDING, compound.getBoolean("isStanding"));

        dataManager.set(MODEL_TYPE, compound.getInteger("modelType"));

    }



    @Override

    public void writeEntityToNBT(NBTTagCompound compound) {

        super.writeEntityToNBT(compound);

        compound.setBoolean("isStanding", dataManager.get(IS_STANDING));

        compound.setInteger("modelType", dataManager.get(MODEL_TYPE));

    }



    /**

     * Called to update the entity's position/logic.

     */

    @Override

    public void onUpdate() {

        super.onUpdate();



        if (this.world.isRemote) {

            this.clientSideStandAnimation0 = this.clientSideStandAnimation;



            if (this.isStanding()) {

                this.clientSideStandAnimation = MathHelper.clamp(this.clientSideStandAnimation + 1.0F, 0.0F, 6.0F);

            } else {

                this.clientSideStandAnimation = MathHelper.clamp(this.clientSideStandAnimation - 1.0F, 0.0F, 6.0F);

            }

        }



        if (this.warningSoundTicks > 0) {

            --this.warningSoundTicks;

        }

    }



    @Override

    public boolean attackEntityAsMob(Entity entityIn) {

        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) ((int) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));



        if (flag) {

            this.applyEnchantments(this, entityIn);

        }



        return flag;

    }



    public boolean isStanding() {

        return this.dataManager.get(IS_STANDING);

    }



    public void setStanding(boolean standing) {

        this.dataManager.set(IS_STANDING, standing);

    }



    @SideOnly(Side.CLIENT)

    public float getStandingAnimationScale(float p_189795_1_) {

        return (this.clientSideStandAnimation0 + (this.clientSideStandAnimation - this.clientSideStandAnimation0) * p_189795_1_) / 6.0F;

    }



    @Override

    protected float getWaterSlowDown() {

        return 0.98F;

    }



    /**

     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called

     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory

     */

    @Override

    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {

        if (livingdata instanceof EntityCamarasaurus.GroupData) {

            if (((EntityCamarasaurus.GroupData) livingdata).madeParent) {

                this.setGrowingAge(-24000);

            }

        } else {

            EntityCamarasaurus.GroupData entitypolarbear$groupdata = new EntityCamarasaurus.GroupData();

            entitypolarbear$groupdata.madeParent = true;

            livingdata = entitypolarbear$groupdata;

        }

        // the 1% of chance to have the model

        setModelType(world.rand.nextInt(99) == 0 ? 1 : 0);



        return livingdata;

    }



    class AIAttackPlayer extends EntityAINearestAttackableTarget<EntityPlayer> {

        public AIAttackPlayer() {

            super(EntityCamarasaurus.this, EntityPlayer.class, 20, true, true, (Predicate) null);

        }



        /**

         * Returns whether the EntityAIBase should begin execution.

         */

        public boolean shouldExecute() {

            if (EntityCamarasaurus.this.isChild()) {

                return false;

            } else {

                if (super.shouldExecute()) {

                    for (EntityCamarasaurus entitypolarbear : EntityCamarasaurus.this.world.getEntitiesWithinAABB(EntityCamarasaurus.class, EntityCamarasaurus.this.getEntityBoundingBox().grow(8.0D, 4.0D, 8.0D))) {

                        if (entitypolarbear.isChild()) {

                            return true;

                        }

                    }

                }



                EntityCamarasaurus.this.setAttackTarget((EntityLivingBase) null);

                return false;

            }

        }



        protected double getTargetDistance() {

            return super.getTargetDistance() * 0.5D;

        }

    }



    class AIHurtByTarget extends EntityAIHurtByTarget {

        public AIHurtByTarget() {

            super(EntityCamarasaurus.this, false);

        }



        /**

         * Execute a one shot task or start executing a continuous task

         */

        public void startExecuting() {

            super.startExecuting();



            if (EntityCamarasaurus.this.isChild()) {

                this.alertOthers();

                this.resetTask();

            }

        }



        protected void setEntityAttackTarget(EntityCreature creatureIn, EntityLivingBase entityLivingBaseIn) {

            if (creatureIn instanceof EntityCamarasaurus && !creatureIn.isChild()) {

                super.setEntityAttackTarget(creatureIn, entityLivingBaseIn);

            }

        }

    }



    class AIMeleeAttack extends EntityAIAttackMelee {

        public AIMeleeAttack() {

            super(EntityCamarasaurus.this, 1.25D, true);

        }



        protected void checkAndPerformAttack(EntityLivingBase p_190102_1_, double p_190102_2_) {

            double d0 = this.getAttackReachSqr(p_190102_1_);



            if (p_190102_2_ <= d0 && this.attackTick <= 0) {

                this.attackTick = 20;

                this.attacker.attackEntityAsMob(p_190102_1_);

                EntityCamarasaurus.this.setStanding(false);

            } else if (p_190102_2_ <= d0 * 2.0D) {

                if (this.attackTick <= 0) {

                    EntityCamarasaurus.this.setStanding(false);

                    this.attackTick = 20;

                }



                if (this.attackTick <= 10) {

                    EntityCamarasaurus.this.setStanding(true);

                    EntityCamarasaurus.this.playWarningSound();

                }

            } else {

                this.attackTick = 20;

                EntityCamarasaurus.this.setStanding(false);

            }

        }



        /**

         * Reset the task's internal state. Called when this task is interrupted by another one

         */

        public void resetTask() {

            EntityCamarasaurus.this.setStanding(false);

            super.resetTask();

        }



        protected double getAttackReachSqr(EntityLivingBase attackTarget) {

            return (double) (4.0F + attackTarget.width);

        }

    }



    class AIPanic extends EntityAIPanic {

        public AIPanic() {

            super(EntityCamarasaurus.this, 2.0D);

        }



        /**

         * Returns whether the EntityAIBase should begin execution.

         */

        public boolean shouldExecute() {

            return (EntityCamarasaurus.this.isChild() || EntityCamarasaurus.this.isBurning()) && super.shouldExecute();

        }

    }



    static class GroupData implements IEntityLivingData {

        public boolean madeParent;



        private GroupData() {

        }

    }



	@Override

	public int getAdultAge() {

		return 13;

	}



	@Override

	public boolean doesFlock() {

		return true;

	}

}