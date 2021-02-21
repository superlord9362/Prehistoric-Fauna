package superlord.prehistoricfauna.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class IschigualastiaSkullEntity extends PrehistoricEntity {
	
	public IschigualastiaSkullEntity(EntityType<? extends IschigualastiaSkullEntity> type, World worldIn) {
		super(type, worldIn);
	}
	
	protected void registerGoals() {
		super.registerGoals();
	}

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
	}

	protected int getExperiencePoints(PlayerEntity player) {
		return 0;
	}
	
	public boolean canBreatheUnderwater() {
		return true;
	}
	
}