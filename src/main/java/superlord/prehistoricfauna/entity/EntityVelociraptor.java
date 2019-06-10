package superlord.prehistoricfauna.entity;

import superlord.prehistoricfauna.init.ModItems;
import superlord.prehistoricfauna.util.handlers.LootTableHandler;
import superlord.prehistoricfauna.util.handlers.Sounds;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

import java.util.Random;
import java.util.UUID;

public class EntityVelociraptor extends EntityExtinct {
    private static final DataParameter<Integer> VELOCIRAPTOR_VARIANT = EntityDataManager.<Integer>createKey(EntityVelociraptor.class, DataSerializers.VARINT);
    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.<Float>createKey(EntityVelociraptor.class, DataSerializers.FLOAT);
    public int timeUntilNextEgg;

    public EntityVelociraptor(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 0.85F);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        this.setTamed(false);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	protected void initEntityAI() {
        this.aiSit = new EntityAISit(this);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityVelociraptor.AIAvoidEntity(this, EntityLlama.class, 24.0F, 1.5D, 1.5D));
        this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(6, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(7, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(10, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityDryosaurus.class, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);

        if (this.isTamed()) {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12.0D);
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12.0D);
        }

        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
    }

    /**
     * Sets the active target the Task system uses for tracking
     */
    public void setAttackTarget(@Nullable EntityLivingBase entitylivingbaseIn) {
        super.setAttackTarget(entitylivingbaseIn);

        if (entitylivingbaseIn == null) {
            this.setAngry(false);
        } else if (!this.isTamed()) {
            this.setAngry(true);
        }
    }

    protected void updateAITasks() {
        this.dataManager.set(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
    }

    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
        this.dataManager.register(VELOCIRAPTOR_VARIANT, Integer.valueOf(0));
    }
    
    public int getVelociraptorSkin()
    {
        return ((Integer)this.dataManager.get(VELOCIRAPTOR_VARIANT)).intValue();
    }

    public void setVelociraptorSkin(int skinId)
    {
        this.dataManager.set(VELOCIRAPTOR_VARIANT, Integer.valueOf(skinId));
    }

    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
    }

    public static void registerFixesWolf(DataFixer fixer) {
        EntityLiving.registerFixesMob(fixer, EntityVelociraptor.class);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setBoolean("Angry", this.isAngry());
        compound.setInteger("VelociraptorVariant", this.getVelociraptorSkin());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setAngry(compound.getBoolean("Angry"));
        this.setVelociraptorSkin(compound.getInteger("VelociraptorVariant"));
    }

    protected SoundEvent getAmbientSound() {
        if (this.isAngry()) {
            return Sounds.VELOCIRAPTOR_ANGRY;
        } else {
            return Sounds.VELOCIRAPTOR_IDLE;
        }
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return Sounds.VELOCIRAPTOR_HURT;
    }

    protected SoundEvent getDeathSound() {
        return Sounds.VELOCIRAPTOR_HURT;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return LootTableHandler.VELOCIRAPTOR;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextEgg <= 0) {
            this.dropItem(ModItems.VELOCIRAPTOR_EGG_ENTITY, 1);
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }

        if (!this.world.isRemote && this.getAttackTarget() == null && this.isAngry()) {
            this.setAngry(false);
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate() {
        super.onUpdate();
    }

    /**
     * True if the wolf is wet
     */

    /**
     * Used when calculating the amount of shading to apply while the wolf is wet.
     */

    public float getEyeHeight() {
        return this.height * 0.8F;
    }

    /**
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int getVerticalFaceSpeed() {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable(source)) {
            return false;
        } else {
            Entity entity = source.getTrueSource();

            if (this.aiSit != null) {
                this.aiSit.setSitting(false);
            }

            if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
                amount = (amount + 1.0F) / 2.0F;
            }

            return super.attackEntityFrom(source, amount);
        }
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) ((int) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));

        if (flag) {
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    public void setTamed(boolean tamed) {
        super.setTamed(tamed);

        if (tamed) {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        }

        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (this.isTamed()) {
            if (!itemstack.isEmpty()) {
                if (itemstack.getItem() instanceof ItemFood) {
                    ItemFood itemfood = (ItemFood) itemstack.getItem();

                    if (itemfood.isWolfsFavoriteMeat() && dataManager.get(DATA_HEALTH_ID) < 20.0F) {
                        if (!player.capabilities.isCreativeMode) {
                            itemstack.shrink(1);
                        }

                        this.heal((float) itemfood.getHealAmount(itemstack));
                        return true;
                    }
                } else if (itemstack.getItem() == Items.DYE) {
                    {

                        if (!player.capabilities.isCreativeMode) {
                            itemstack.shrink(1);
                        }

                        return true;
                    }
                }
            }

            if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(itemstack)) {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.navigator.clearPath();
                this.setAttackTarget((EntityLivingBase) null);
            }
        } else if (itemstack.getItem() == Items.COMMAND_BLOCK_MINECART && !this.isAngry()) {
            if (!player.capabilities.isCreativeMode) {
                itemstack.shrink(1);
            }

            if (!this.world.isRemote) {
                if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.setTamedBy(player);
                    this.navigator.clearPath();
                    this.setAttackTarget((EntityLivingBase) null);
                    this.aiSit.setSitting(true);
                    this.setHealth(20.0F);
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte) 7);
                } else {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte) 6);
                }
            }

            return true;
        }

        return super.processInteract(player, hand);
    }

    /**
     * Handler for {@link World#setEntityState}
     */

    @SideOnly(Side.CLIENT)
    public float getTailRotation() {
        if (this.isAngry()) {
            return 1.5393804F;
        } else {
            return this.isTamed() ? (0.55F - (this.getMaxHealth() - dataManager.get(DATA_HEALTH_ID)) * 0.02F) * (float) Math.PI : ((float) Math.PI / 5F);
        }
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() instanceof ItemFood && ((ItemFood) stack.getItem()).isWolfsFavoriteMeat();
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    public int getMaxSpawnedInChunk() {
        return 8;
    }

    /**
     * Determines whether this wolf is angry or not.
     */
    public boolean isAngry() {
        return (dataManager.get(TAMED) & 2) != 0;
    }

    /**
     * Sets whether this wolf is angry or not.
     */
    public void setAngry(boolean angry) {
        byte b0 = dataManager.get(TAMED);

        if (angry) {
            this.dataManager.set(TAMED, (byte) (b0 | 2));
        } else {
            this.dataManager.set(TAMED, (byte) (b0 & -3));
        }
    }

    public EntityVelociraptor createChild(EntityAgeable ageable) {
        EntityVelociraptor entitywolf = new EntityVelociraptor(this.world);
        UUID uuid = this.getOwnerId();

        if (uuid != null) {
            entitywolf.setOwnerId(uuid);
            entitywolf.setTamed(true);
        }

        return entitywolf;
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean canMateWith(EntityAnimal otherAnimal) {
        if (otherAnimal == this) {
            return false;
        } else if (!this.isTamed()) {
            return false;
        } else if (!(otherAnimal instanceof EntityVelociraptor)) {
            return false;
        } else {
            EntityVelociraptor entitywolf = (EntityVelociraptor) otherAnimal;

            if (!entitywolf.isTamed()) {
                return false;
            } else if (entitywolf.isSitting()) {
                return false;
            } else {
                return this.isInLove() && entitywolf.isInLove();
            }
        }
    }

    public boolean shouldAttackEntity(EntityLivingBase target, EntityLivingBase owner) {
        if (!(target instanceof EntityCreeper) && !(target instanceof EntityGhast)) {
            if (target instanceof EntityVelociraptor) {
                EntityVelociraptor entitywolf = (EntityVelociraptor) target;

                if (entitywolf.isTamed() && entitywolf.getOwner() == owner) {
                    return false;
                }
            }

            if (target instanceof EntityPlayer && owner instanceof EntityPlayer && !((EntityPlayer) owner).canAttackPlayer((EntityPlayer) target)) {
                return false;
            } else {
                return !(target instanceof AbstractHorse) || !((AbstractHorse) target).isTame();
            }
        } else {
            return false;
        }
    }

    public boolean canBeLeashedTo(EntityPlayer player) {
        return !this.isAngry() && super.canBeLeashedTo(player);
    }

    class AIAvoidEntity<T extends Entity> extends EntityAIAvoidEntity<T> {
        private final EntityVelociraptor wolf;

        public AIAvoidEntity(EntityVelociraptor wolfIn, Class<T> p_i47251_3_, float p_i47251_4_, double p_i47251_5_, double p_i47251_7_) {
            super(wolfIn, p_i47251_3_, p_i47251_4_, p_i47251_5_, p_i47251_7_);
            this.wolf = wolfIn;
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute() {
            if (super.shouldExecute() && this.closestLivingEntity instanceof EntityLlama) {
                return !this.wolf.isTamed() && this.avoidLlama((EntityLlama) this.closestLivingEntity);
            } else {
                return false;
            }
        }

        private boolean avoidLlama(EntityLlama p_190854_1_) {
            return p_190854_1_.getStrength() >= EntityVelociraptor.this.rand.nextInt(5);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            EntityVelociraptor.this.setAttackTarget((EntityLivingBase) null);
            super.startExecuting();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask() {
            EntityVelociraptor.this.setAttackTarget((EntityLivingBase) null);
            super.updateTask();
        }
    }

	@Override
	public int getAdultAge() {
		return 1;
	}

	@Override
	public boolean doesFlock() {
		return false;
	}
	
	@Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        Random rand = new Random();
        setVelociraptorSkin(rand.nextInt(100));
        return livingdata;
    }
}