package superlord.prehistoricfauna.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import superlord.prehistoricfauna.entity.EntityPrehistoric;

public class DinoAIWatchClosest extends EntityAIBase {
	protected Entity closestEntity;
	private final EntityPrehistoric prehistoric;
	private float maxDistanceForPlayer;
	private int lookTime;
	private final float chance;
	private final Class watchedClass;
	
	public DinoAIWatchClosest(EntityPrehistoric prehistoric, Class watchedClass, float distance) {
		this.prehistoric = prehistoric;
		this.watchedClass = watchedClass;
		this.maxDistanceForPlayer = distance;
		this.chance = 0.02F;
		this.setMutexBits(2);
	}
	
	public DinoAIWatchClosest(EntityPrehistoric prehistoric, Class watchedClass, float distance, float chance) {
		this.prehistoric = prehistoric;
		this.watchedClass = watchedClass;
		this.maxDistanceForPlayer = distance;
		this.chance = chance;
		this.setMutexBits(2);
	}
	
	@Override
	public boolean shouldExecute() {
		if (this.prehistoric.isSleeping()) {
			return false;
		}
		if (this.prehistoric.getAttackTarget() != null) {
			this.closestEntity = this.prehistoric.getAttackTarget();
		}
		if (this.watchedClass == EntityPlayer.class) {
			this.closestEntity = this.prehistoric.world.getClosestPlayerToEntity(this.prehistoric, (double) this.maxDistanceForPlayer);
		} else {
			this.closestEntity = this.prehistoric.world.findNearestEntityWithinAABB(this.watchedClass, this.prehistoric.getEntityBoundingBox().expand((double) this.maxDistanceForPlayer, 3.0D, (double) this.maxDistanceForPlayer), this.prehistoric);
		}
		return this.closestEntity != null;
 	}
	
	@Override
	public boolean shouldContinueExecuting() {
		return this.closestEntity.isEntityAlive() && (!(this.prehistoric.getDistanceSq(this.closestEntity) > (double) (this.maxDistanceForPlayer * this.maxDistanceForPlayer)) && this.lookTime > 0);
	}
	
	@Override
	public void startExecuting() {
		this.lookTime = 40 + this.prehistoric.getRNG().nextInt(40);
	}
	
	@Override
	public void resetTask() {
		this.closestEntity = null;
	}
	
	@Override
	public void updateTask() {
		this.prehistoric.getLookHelper().setLookPosition(this.closestEntity.posX, this.closestEntity.posY + (double) this.closestEntity.getEyeHeight(), this.closestEntity.posZ, 10.0F, this.prehistoric.getVerticalFaceSpeed());
		--this.lookTime;
	}

}
