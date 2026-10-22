package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;

public class MixedHerdGoal extends DinosaurHerdGoal {
    private final TagKey<EntityType<?>> herdTag;
 
    public MixedHerdGoal(Mob mob, TagKey<EntityType<?>> herdTag) {
        super(mob);
        this.herdTag = herdTag;
    }
 
    public MixedHerdGoal(Mob mob, TagKey<EntityType<?>> herdTag, int herdRadius, int maxHerdSize, double speed) {
        super(mob, herdRadius, maxHerdSize, speed);
        this.herdTag = herdTag;
    }
 
    @Override
    protected boolean canFollow(Mob other) {
        return other.getType().is(this.herdTag);
    }
}
 
