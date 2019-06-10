package superlord.prehistoricfauna.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.world.World;

public class EntityCladocyclus extends EntityAquatic {

	public EntityCladocyclus(World world) {
		super(world);
		setSize(0.4F, 0.4F);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void initEntityAI() {
        this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.0D, true));
        this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityParadoxides.class, false));
	}
	
	@Override
    public EntityCladocyclus createChild(EntityAgeable entity) {
    	return new EntityCladocyclus(this.world);
    }

	@Override
	public String getTexture() {
		return null;
	}

	@Override
	protected double getSwimSpeed() {
		return 1;
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
