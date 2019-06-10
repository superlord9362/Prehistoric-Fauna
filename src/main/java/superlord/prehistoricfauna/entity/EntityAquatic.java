package superlord.prehistoricfauna.entity;

import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import javax.annotation.Nullable;
import java.util.List;

public abstract class EntityAquatic extends EntityExtinct {

    public BlockPos currentTarget;
    @SideOnly(Side.CLIENT)
    public EntityAquatic(World world) {
        super(world);
        this.spawnableBlock = Blocks.WATER;
        this.moveHelper = new EntityAquatic.SwimmingMoveHelper();
        this.navigator = new PathNavigateSwimmer(this, world);
    }

    protected void initEntityAI() {
    	this.tasks.addTask(1, new EntityAIWander(this, 3.0D));
        this.tasks.addTask(1, new EntityAILookIdle(this));
        this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.0D, true));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
    }
    
    @Override
    public boolean isAIDisabled() {
        return false;
    }
    
    public abstract String getTexture();

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
    }
    
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
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    public void swimTowardsTarget() {
        if (currentTarget != null && isTargetInWater() && this.inWater) {
            double targetX = currentTarget.getX() + 0.5D - posX;
            double targetY = currentTarget.getY() + 1D - posY;
            double targetZ = currentTarget.getZ() + 0.5D - posZ;
            motionX += (Math.signum(targetX) * 0.5D - motionX) * 0.100000000372529 * getSwimSpeed(); // 0.10000000149011612D
            motionY += (Math.signum(targetY) * 0.5D - motionY) * 0.100000000372529 * getSwimSpeed();// 0.10000000149011612D
            motionZ += (Math.signum(targetZ) * 0.5D - motionZ) * 0.100000000372529 * getSwimSpeed(); // 0.10000000149011612D
            float angle = (float) (Math.atan2(motionZ, motionX) * 180.0D / Math.PI) - 90.0F;
            float rotation = MathHelper.wrapDegrees(angle - rotationYaw);
            moveForward = 0.5F;
            rotationYaw += rotation;
        }
    }

    protected abstract double getSwimSpeed();

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.height != 0.95F) {
            this.height = 0.95F;
        }
        if (this.isInWater() && this.getClosestMate() != null && this.getGrowingAge() == 0 && this.getClosestMate().getGrowingAge() == 0 && !this.world.isRemote) {
            this.setGrowingAge(12000);
            this.getClosestMate().setGrowingAge(12000);
        }
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        this.setGrowingAge(12000);
        return super.onInitialSpawn(difficulty, livingdata);
    }

    public EntityAquatic getClosestMate() {
        EntityAINearestAttackableTarget.Sorter theNearestAttackableTargetSorter = new EntityAINearestAttackableTarget.Sorter(this);
        List<EntityAquatic> list = world.getEntitiesWithinAABB(EntityAquatic.class, this.getEntityBoundingBox().expand(2.0D, 2.0D, 2.0D), null);
        list.sort(theNearestAttackableTargetSorter);
        if (list.isEmpty()) {
            return null;
            } else {
            return null;
        }
    }
    @Override
    public boolean isInWater() {
        return super.isInWater() || this.isInsideOfMaterial(Material.WATER) || this.isInsideOfMaterial(Material.CORAL);
    }
    protected boolean isTargetInWater() {
        return currentTarget != null && (world.getBlockState(new BlockPos(currentTarget.getX(), currentTarget.getY(), currentTarget.getZ())).getMaterial() == Material.WATER && world.getBlockState(new BlockPos(currentTarget.getX(), currentTarget.getY() + 1, currentTarget.getZ())).getMaterial() == Material.WATER);
    }
    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }
    @Override
    public boolean getCanSpawnHere() {
    	return this.posY < (double)this.world.getSeaLevel() && this.isInWater();
    }
    public boolean isNotColliding() {
        return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this);
    }
    @Override
    public int getTalkInterval() {
        return 120;
    }
    @Override
    protected int getExperiencePoints(EntityPlayer player) {
    	return 1 + this.world.rand.nextInt(3);
    }
    @Override
    public void onEntityUpdate()
    {
        int i = this.getAir();
        super.onEntityUpdate();
        if (this.isEntityAlive() && !this.isInWater())
        {
            --i;
            this.setAir(i);
            if (this.getAir() == -20)
            {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.DROWN, 2.0F);
            }
        }
        else
        {
            this.setAir(300);
        }
    }
    @Override
    public boolean isOnLadder() {
        return false;
        }
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.renderYawOffset = this.rotationYaw;
    }
    @Override
    public EntityAgeable createChild(EntityAgeable entity) {
    	return null;
    }
    public boolean isDirectPathBetweenPoints(Vec3d vec1, Vec3d vec2) {
        RayTraceResult movingobjectposition = this.world.rayTraceBlocks(vec1, new Vec3d(vec2.x, vec2.y, vec2.z), false, true, false);
        return movingobjectposition == null || movingobjectposition.typeOfHit != RayTraceResult.Type.BLOCK;
    }
    @Override
    public boolean shouldDismountInWater(Entity rider) {
        return false;
    }
    @Override
    public void travel(float strafe, float vertical, float forward) {
        float f4;
        if (this.isBeingRidden() && this.canBeSteered()) {
            EntityLivingBase controller = (EntityLivingBase) this.getControllingPassenger();
            if (controller != null) {
                strafe = controller.moveStrafing * 0.5F;
                forward = controller.moveForward;
                if (forward <= 0.0F) {
                    forward *= 0.25F;
                }
                this.fallDistance = 0;
                if (this.isInWater()) {
                    this.moveRelative(strafe, vertical, forward, 1F);
                    f4 = 0.8F;
                    float d0 = 3;
                    if (!this.onGround) {
                        d0 *= 0.5F;
                    }
                    if (d0 > 0.0F) {
                        f4 += (0.54600006F - f4) * d0 / 3.0F;
                    }
                    this.motionX *= (double) f4;
                    this.motionX *= 0.900000011920929D;
                    this.motionY *= 0.900000011920929D;
                    this.motionY *= (double) f4;
                    this.motionZ *= 0.900000011920929D;
                    this.motionZ *= (double) f4;
                    motionY += 0.01185D;
                } else {
                    forward = controller.moveForward * 0.25F;
                    strafe = controller.moveStrafing * 0.125F;
                    this.setAIMoveSpeed(2);
                    super.travel(strafe, vertical, forward);
                    return;
                }
                this.setAIMoveSpeed(2);
                super.travel(strafe, vertical = 0, forward);
                this.prevLimbSwingAmount = this.limbSwingAmount;
                double deltaX = this.posX - this.prevPosX;
                double deltaZ = this.posZ - this.prevPosZ;
                double deltaY = this.posY - this.prevPosY;
                float delta = MathHelper.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ) * 4.0F;
                if (delta > 1.0F) {
                    delta = 1.0F;
                }
                this.limbSwingAmount += (delta - this.limbSwingAmount) * 0.4F;
                this.limbSwing += this.limbSwingAmount;
                return;
            }
        }
        if (this.isServerWorld()) {
            if (this.isInWater()) {
                this.moveRelative(strafe, vertical, forward, 0.1F);                f4 = 0.8F;
                float speedModifier = (float) EnchantmentHelper.getDepthStriderModifier(this);
                if (speedModifier > 3.0F) {
                    speedModifier = 3.0F;
                }
                if (!this.onGround) {
                    speedModifier *= 0.5F;
                }
                if (speedModifier > 0.0F) {
                    f4 += (0.54600006F - f4) * speedModifier / 3.0F;
                }
                this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
                this.motionX *= (double) f4;
                this.motionX *= 0.9;
                this.motionY *= 0.9;
                this.motionY *= (double) f4;
                this.motionZ *= 0.9;
                this.motionZ *= (double) f4;
            } else {
                super.travel(strafe, vertical, forward);
            }
        }
        this.prevLimbSwingAmount = this.limbSwingAmount;
        double deltaX = this.posX - this.prevPosX;
        double deltaZ = this.posZ - this.prevPosZ;
        double deltaY = this.posY - this.prevPosY;
        float delta = MathHelper.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ) * 4.0F;
        if (delta > 1.0F) {
            delta = 1.0F;
        }
        this.limbSwingAmount += (delta - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;
    }

    class SwimmingMoveHelper extends EntityMoveHelper {
        private final EntityAquatic dinosaur = EntityAquatic.this;
        public SwimmingMoveHelper() {
            super(EntityAquatic.this);
        }
        
        @Override
        public void onUpdateMoveHelper() {
            if (this.action == EntityMoveHelper.Action.MOVE_TO && !this.dinosaur.getNavigator().noPath() && !this.dinosaur.isBeingRidden()) {
                if (this.action == EntityMoveHelper.Action.MOVE_TO && !this.dinosaur.getNavigator().noPath()) {
                    double distanceX = this.posX - this.dinosaur.posX;
                    double distanceY = this.posY - this.dinosaur.posY;
                    double distanceZ = this.posZ - this.dinosaur.posZ;
                    double distance = Math.abs(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ);
                    distance = (double) MathHelper.sqrt(distance);
                    distanceY /= distance;
                    float angle = (float) (Math.atan2(distanceZ, distanceX) * 180.0D / Math.PI) - 90.0F;
                    this.dinosaur.rotationYaw = this.limitAngle(this.dinosaur.rotationYaw, angle, 30.0F);
                    this.dinosaur.setAIMoveSpeed(0.65F);
                    this.dinosaur.motionY += (double) this.dinosaur.getAIMoveSpeed() * distanceY * 0.1D;
                } else {
                    this.dinosaur.setAIMoveSpeed(0.0F);
                }
            }
        }
    }
}