package superlord.prehistoricfauna.common.entity.item;

import javax.annotation.Nonnull;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;
import superlord.prehistoricfauna.init.PFEffects;
import superlord.prehistoricfauna.init.PFEntities;
import superlord.prehistoricfauna.init.PFItems;

public class FermentedGinkgoBerry extends ThrowableItemProjectile {
	
	public FermentedGinkgoBerry(EntityType<? extends FermentedGinkgoBerry> berry, Level world) {
		super(berry, world);
	}
	
	public FermentedGinkgoBerry(Level world, LivingEntity thrower) {
		super(PFEntities.FERMENTED_GINKGO_BERRY.get(), thrower, world);
	}
	
	public FermentedGinkgoBerry(Level world, double x, double y, double z) {
		super(PFEntities.FERMENTED_GINKGO_BERRY.get(), x, y, z, world);
	}
	
	public Item getDefaultItem() {
		return PFItems.FERMENTED_GINKO_BERRY.get();
	}
	
	@Override
	public float getGravity() {
		return 0.15F;
	}
	
	@Nonnull
	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	public void onHitEntity(EntityHitResult result) {
		super.onHitEntity(result);
		Entity entity = result.getEntity();
		if (entity instanceof LivingEntity livingEntity) {
			livingEntity.hurt(DamageSource.thrown(this, this.getOwner()), 0);
			livingEntity.addEffect(new MobEffectInstance(PFEffects.GINKGO_SPLATTERED.get(), 150, 0, false, false, false));
		}
		this.discard();
	}

}
