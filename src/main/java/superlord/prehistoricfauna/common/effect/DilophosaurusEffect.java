package superlord.prehistoricfauna.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.phys.Vec3;

public class DilophosaurusEffect extends MobEffect {
	   protected double posX;
	   protected double posY;
	   protected double posZ;

	public DilophosaurusEffect(MobEffectCategory p_19451_, int p_19452_) {
		super(p_19451_, p_19452_);
	}
	
	@Override
    public void applyEffectTick(LivingEntity entityLivingBase, int amplifier) {
    	if (entityLivingBase instanceof PathfinderMob mob && mob.getMaxHealth() <= 15) {
    	      mob.getNavigation().moveTo(this.posX, this.posY, this.posZ, 1.2D);
    	}
    }
    
    protected boolean findRandomPosition(PathfinderMob entity) {
        Vec3 vec3 = DefaultRandomPos.getPos(entity, 5, 4);
        if (vec3 == null) {
           return false;
        } else {
           this.posX = vec3.x;
           this.posY = vec3.y;
           this.posZ = vec3.z;
           return true;
        }
     }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        int k = 25 >> amplifier;
        if (k > 0) {
            return duration % k == 0;
        } else {
            return true;
        }
    }

}
