package superlord.prehistoricfauna.common.effect;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import superlord.prehistoricfauna.init.PFDamageSources;

public class BleedingEffect extends MobEffect {
    
    public BleedingEffect(MobEffectCategory type, int liquidColor) {
        super(type, liquidColor);
    }

    private static final Map<LivingEntity, BlockPos> previousPositions = new HashMap<>();

    @Override
    public void applyEffectTick(LivingEntity entityLivingBase, int amplifier) {
        BlockPos currentPosition = new BlockPos((int) entityLivingBase.position().x(), (int) entityLivingBase.position().y(), (int) entityLivingBase.position().z());
        BlockPos previousPosition = previousPositions.getOrDefault(entityLivingBase, currentPosition);
        if (!previousPosition.equals(currentPosition)) {
            entityLivingBase.hurt(PFDamageSources.causeBleedingDamage(entityLivingBase.level().registryAccess()), 1.0F);
        }
        previousPositions.put(entityLivingBase, currentPosition);
        previousPositions.entrySet().removeIf(entry -> !entry.getKey().isAlive());
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