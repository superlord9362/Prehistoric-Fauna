package superlord.prehistoricfauna.entity.egg;

import superlord.prehistoricfauna.entity.EntityCamarasaurus;
import superlord.prehistoricfauna.entity.EntityGallimimus;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityIncCamarasaurus extends EntityThrowable {
    public EntityIncCamarasaurus(World worldIn) {
        super(worldIn);
    }

    public EntityIncCamarasaurus(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    public EntityIncCamarasaurus(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public static void registerFixesEgg(DataFixer fixer) {
        EntityThrowable.registerFixesThrowable(fixer, "ThrownEgg");
    }

    /**
     * Handler for {@link World#setEntityState}
     */
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 3) {
            double d0 = 0.08D;

            for (int i = 0; i < 8; ++i) {
                this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double) this.rand.nextFloat() - 0.5D) * 0.08D, ((double) this.rand.nextFloat() - 0.5D) * 0.08D, ((double) this.rand.nextFloat() - 0.5D) * 0.08D, Item.getIdFromItem(Items.EGG));
            }
        }
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }
        if (!this.world.isRemote) {
            EntityCamarasaurus entitychicken = new EntityCamarasaurus(this.world);
            entitychicken.setGrowingAge(-24000);
            entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
            this.world.spawnEntity(entitychicken);
            this.world.setEntityState(this, (byte) 3);
            this.setDead();
        }
    }
}