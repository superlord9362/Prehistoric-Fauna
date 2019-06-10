package superlord.prehistoricfauna.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;

public class EntityEusthenopteron extends EntityAquatic {

	public EntityEusthenopteron(World world) {
		super(world);
		this.setSize(0.4F, 0.4F);
	}
	
	@Override
    public EntityEusthenopteron createChild(EntityAgeable entity) {
    	return new EntityEusthenopteron(this.world);
    }

	@Override
	public String getTexture() {
		return null;
	}

	@Override
	protected double getSwimSpeed() {
		return 1.0;
	}

	@Override
	public int getAdultAge() {
		return 1;
	}

	@Override
	public boolean doesFlock() {
		return false;
	}

}
