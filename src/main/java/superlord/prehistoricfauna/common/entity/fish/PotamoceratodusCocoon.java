package superlord.prehistoricfauna.common.entity.fish;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import superlord.prehistoricfauna.init.PFEntities;

public class PotamoceratodusCocoon extends PathfinderMob {

	public PotamoceratodusCocoon(EntityType<? extends PathfinderMob> p_20966_, Level p_20967_) {
		super(p_20966_, p_20967_);
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0D);
	}
	
	public void aiStep() {
		super.aiStep();
		if (this.isInWaterOrRain()) {
			Potamoceratodus potamoceratodus = new Potamoceratodus(PFEntities.POTAMOCERATODUS.get(), this.level());
			potamoceratodus.setPos(this.getX(), this.getY(), this.getZ());
			this.level().addFreshEntity(potamoceratodus);
			if (this.hasCustomName()) {
				potamoceratodus.setCustomName(getCustomName());
			}
			this.level().playSound((Player)null, new BlockPos((int) this.getX(), (int) this.getY(), (int) this.getZ()), SoundEvents.FROG_TONGUE, SoundSource.NEUTRAL);
			this.remove(RemovalReason.DISCARDED);
		}
	}

}
