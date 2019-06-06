package superlord.prehistoricfauna.entity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import superlord.prehistoricfauna.entity.EntityPrehistoric;

public class DinoAILookIdle extends EntityAIBase {
	public final EntityPrehistoric prehistoric;
	private double lookX;
	private double lookZ;
	private int idleTime;
	
	public DinoAILookIdle(EntityPrehistoric prehistoric) {
		this.prehistoric = prehistoric;
		this.setMutexBits(3);
	}
	
	@Override
	public boolean shouldExecute() {
		if(this.prehistoric.isSleeping() ) {
			return false;
		}
		return this.prehistoric.getRNG().nextFloat()< 0.02F;
	}
	
	@Override
	public boolean shouldContinueExecuting() {
		return this.idleTime >= 0;
	}
	
	@Override
	public void startExecuting() {
		double d0 = (Math.PI * 2D) * this.prehistoric.getRNG().nextDouble();
		this.lookX = Math.cos(d0);
		this.lookZ = Math.sin(d0);
		this.idleTime = 20 + this.prehistoric.getRNG().nextInt(20);
	}
	
	@Override
	public void updateTask() {
		--this.idleTime;
		this.prehistoric.getLookHelper().setLookPosition(this.prehistoric.posX + this.lookX, this.prehistoric.posY + (double) this.prehistoric.getEyeHeight(), this.prehistoric.posZ + this.lookZ, 10.0F, (float) this.prehistoric.getVerticalFaceSpeed());
	}

}
