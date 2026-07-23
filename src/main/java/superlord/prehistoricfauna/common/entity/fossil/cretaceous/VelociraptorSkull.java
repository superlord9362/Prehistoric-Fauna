package superlord.prehistoricfauna.common.entity.fossil.cretaceous;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.HitResult;
import superlord.prehistoricfauna.common.entity.fossil.FossilEntity;
import superlord.prehistoricfauna.init.PFItems;

public class VelociraptorSkull extends FossilEntity {

	public VelociraptorSkull(EntityType<? extends VelociraptorSkull> type, Level worldIn) {
		super(type, worldIn);
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 1.0D);
	}

	@Override
	public void spawnFossil(DamageSource p_213815_1_) {
	      Block.popResource(this.level(), this.blockPosition(), new ItemStack(PFItems.VELOCIRAPTOR_SKULL.get()));
	}
	
	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(PFItems.VELOCIRAPTOR_SKULL.get());
	}

	@Override
	protected String defaultPoseName() {
		return "IDLE";
	}

	@Override
	protected String nextPoseName(String current) {
		return "IDLE";
	}

}