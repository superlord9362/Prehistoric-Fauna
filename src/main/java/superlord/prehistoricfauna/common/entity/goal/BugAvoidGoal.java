package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

public class BugAvoidGoal extends Goal {

    private final Mob mob;
    private final float range;
    private final double slowSpeed;
    private final double fastSpeed;
    private final TagKey<EntityType<?>> avoidTag;
    private LivingEntity threat;

    public BugAvoidGoal(Mob mob, float range, double slowSpeed, double fastSpeed, TagKey<EntityType<?>> avoidTag) {
        this.mob = mob;
        this.range = range;
        this.slowSpeed = slowSpeed;
        this.fastSpeed = fastSpeed;
        this.avoidTag = avoidTag;
        this.setFlags(java.util.EnumSet.of(Goal.Flag.MOVE));
    }

    private LivingEntity findNearestThreat() {
        return mob.level().getEntitiesOfClass(LivingEntity.class,
            mob.getBoundingBox().inflate(range),
            e -> e.isAlive() && !e.isSpectator() && e.getType().is(avoidTag)
            && !(e instanceof net.minecraft.world.entity.player.Player player
                && player.isCreative())
        ).stream()
            .min(java.util.Comparator.comparingDouble(e -> e.distanceToSqr(mob)))
            .orElse(null);
    }

    @Override
    public boolean canUse() {
        threat = findNearestThreat();
        return threat != null;
    }

    @Override
    public boolean canContinueToUse() {
        threat = findNearestThreat();
        return threat != null;
    }

    @Override
    public void start() {
        mob.getNavigation().stop();
    }

    @Override
    public void tick() {
        threat = findNearestThreat();
        if (threat == null) return;

        Vec3 threatPos = threat.position();
        Vec3 mobPos = mob.position();
        Vec3 away = mobPos.subtract(threatPos).normalize();

        for (int dist = 10; dist >= 3; dist--) {
            double fleeX = mobPos.x + away.x * dist;
            double fleeY = mobPos.y;
            double fleeZ = mobPos.z + away.z * dist;

            BlockPos fleePos = new BlockPos((int)fleeX, (int)fleeY, (int)fleeZ);
            for (int dy = 0; dy >= -3; dy--) {
                BlockPos check = fleePos.above(dy);
                if (!mob.level().isEmptyBlock(check.below()) && mob.level().isEmptyBlock(check)) {
                    fleeY = check.getY();
                    fleePos = check;
                    break;
                }
            }

            double speed = threat.distanceTo(mob) < 4.0 ? fastSpeed : slowSpeed;
            if (mob.getNavigation().moveTo(fleeX, fleeY, fleeZ, speed)) {
                return;
            }
        }

        mob.setDeltaMovement(mob.getDeltaMovement().add(
            away.x * 0.2, 0, away.z * 0.2
        ));
    }
}