package superlord.prehistoricfauna.entity;

import superlord.prehistoricfauna.init.ModItems;
import superlord.prehistoricfauna.util.handlers.LootTableHandler;
import superlord.prehistoricfauna.util.handlers.Sounds;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOcelotAttack;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityGallimimus extends EntityTameable {
    private EntityAIAvoidEntity<EntityPlayer> avoidEntity;
    private EntityAIAvoidEntity<EntityTyrannosaurus> avoidEntity1;
    /**
     * The tempt AI task for this mob, used to prevent taming while it is fleeing.
     */
    private EntityAITempt aiTempt;
    public int timeUntilNextEgg;

    public EntityGallimimus(World worldIn) {
        super(worldIn);
        this.setSize(1.0F, 2.7F);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
    }

    @Override
    protected void initEntityAI() {
        this.aiTempt = new EntityAITempt(this, 0.6D, Items.FISH, true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(3, this.aiTempt);
        this.tasks.addTask(7, new EntityAILeapAtTarget(this, 0.3F));
        this.tasks.addTask(8, new EntityAIOcelotAttack(this));
        this.tasks.addTask(9, new EntityAIMate(this, 0.8D));
        this.tasks.addTask(10, new EntityAIWanderAvoidWater(this, 0.8D, 1.0000001E-5F));
        this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.tasks.addTask(1, new EntityAIAvoidEntity<>(this, EntityTyrannosaurus.class, 24.0F, 1.5D, 1.5D));
    }

    protected void entityInit() {
        super.entityInit();
    }

    @Override
    public void updateAITasks() {
        if (this.getMoveHelper().isUpdating()) {
            double d0 = this.getMoveHelper().getSpeed();

            if (d0 == 0.6D) {
                this.setSneaking(true);
                this.setSprinting(false);
            } else if (d0 == 1.33D) {
                this.setSneaking(false);
                this.setSprinting(true);
            } else {
                this.setSneaking(false);
                this.setSprinting(false);
            }
        } else {
            this.setSneaking(false);
            this.setSprinting(false);
        }
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn() {
        return false;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(45.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
    }

    public void fall(float distance, float damageMultiplier) {
    }

    public static void registerFixesOcelot(DataFixer fixer) {
        EntityLiving.registerFixesMob(fixer, EntityGallimimus.class);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound) {

    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return Sounds.GALLIMIMUS_IDLE;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return Sounds.GALLIMIMUS_HURT;
    }

    protected SoundEvent getDeathSound() {
        return Sounds.GALLIMIMUS_HURT;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume() {
        return 0.4F;
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 3.0F);
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isEntityInvulnerable(source)) {
            return false;
        } else {
            if (this.aiSit != null) {
                this.aiSit.setSitting(false);
            }

            return super.attackEntityFrom(source, amount);
        }
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return LootTableHandler.GALLIMIMUS;
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (this.isTamed()) {
            if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(itemstack)) {
                this.aiSit.setSitting(!this.isSitting());
            }
        } else if ((this.aiTempt == null || this.aiTempt.isRunning()) && itemstack.getItem() == Items.FISH && player.getDistance(this) < 9.0D) {
            if (!player.capabilities.isCreativeMode) {
                itemstack.shrink(1);
            }

            if (!this.world.isRemote) {
                if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.setTamedBy(player);
                    this.playTameEffect(true);
                    this.aiSit.setSitting(true);
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

    public EntityGallimimus createChild(EntityAgeable ageable) {
        EntityGallimimus entityocelot = new EntityGallimimus(this.world);

        if (this.isTamed()) {
            entityocelot.setOwnerId(this.getOwnerId());
            entityocelot.setTamed(true);
        }

        return entityocelot;
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == Items.FISH;
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean canMateWith(EntityAnimal otherAnimal) {
        if (otherAnimal == this) {
            return false;
        } else if (!this.isTamed()) {
            return false;
        } else if (!(otherAnimal instanceof EntityGallimimus)) {
            return false;
        } else {
            EntityGallimimus entityocelot = (EntityGallimimus) otherAnimal;

            if (!entityocelot.isTamed()) {
                return false;
            } else {
                return this.isInLove() && entityocelot.isInLove();
            }
        }
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere() {
        return this.world.rand.nextInt(3) != 0;
    }

    /**
     * Checks that the entity is not colliding with any blocks / liquids
     */
    public boolean isNotColliding() {
        if (this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox())) {
            BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

            if (blockpos.getY() < this.world.getSeaLevel()) {
                return false;
            }

            IBlockState iblockstate = this.world.getBlockState(blockpos.down());
            Block block = iblockstate.getBlock();

            if (block == Blocks.GRASS || block.isLeaves(iblockstate, this.world, blockpos.down())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Get the name of this object. For players this returns their username
     */
    public String getName() {
        if (this.hasCustomName()) {
            return this.getCustomNameTag();
        } else {
            return this.isTamed() ? I18n.translateToLocal("entity.Cat.name") : super.getName();
        }
    }

    protected void setupTamedAI() {
        if (this.avoidEntity == null) {
            this.avoidEntity = new EntityAIAvoidEntity<EntityPlayer>(this, EntityPlayer.class, 16.0F, 0.8D, 1.33D);
        }

        if (this.avoidEntity1 == null) {
            this.avoidEntity1 = new EntityAIAvoidEntity<EntityTyrannosaurus>(this, EntityTyrannosaurus.class, 350.0F, 0.8D, 1.33D);
        }
        this.tasks.removeTask(this.avoidEntity);

        if (!this.isTamed()) {
            this.tasks.addTask(4, this.avoidEntity);
        }
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (!this.world.isRemote && !this.isChild() && --this.timeUntilNextEgg <= 0) {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(ModItems.GALLIMIMUS_EGG, 1);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);

        return livingdata;
    }
}