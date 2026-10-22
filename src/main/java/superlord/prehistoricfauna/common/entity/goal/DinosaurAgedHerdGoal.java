package superlord.prehistoricfauna.common.entity.goal;

import net.minecraft.world.entity.Mob;

public class DinosaurAgedHerdGoal extends DinosaurHerdGoal {
    private Boolean wasBaby;
 
    public DinosaurAgedHerdGoal(Mob mob) {
        super(mob);
    }
 
    public DinosaurAgedHerdGoal(Mob mob, int herdRadius, int maxHerdSize, double speed) {
        super(mob, herdRadius, maxHerdSize, speed);
    }
 
    @Override
    protected boolean canFollow(Mob other) {
        return super.canFollow(other) && other.isBaby() == this.mob.isBaby();
    }
 
    @Override
    protected boolean shouldLeaveHerd() {
        boolean baby = this.mob.isBaby();
        if (this.wasBaby != null && this.wasBaby == baby) {
            return false;
        }
        boolean changed = this.wasBaby != null;
        this.wasBaby = baby;
        return changed;
    }
 
    @Override
    public boolean canUse() {
        if (this.wasBaby == null) {
            this.wasBaby = this.mob.isBaby();
        }
        return super.canUse();
    }
}
