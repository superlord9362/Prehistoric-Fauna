package superlord.prehistoricfauna.common.entity.goal;

import java.util.EnumSet;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class HerdChallengeGoal extends Goal {
    private final Mob mob;
    private final DinosaurHerdGoal herdGoal;
    private double speed = 1.2D;
    private float giveUpFraction = 0.10F;
    private int challengeInterval = 6000;
    private int cooldown = 1200;
    private int attackInterval = 20;
    private int maxDuelTicks = 1200;
    private float fallbackDamage = 2.0F;

    private Mob opponent;
    private int duelTicks;
    private int attackTimer;
    private int pathTimer;
    private long cooldownUntil;

    public HerdChallengeGoal(Mob mob, DinosaurHerdGoal herdGoal) {
        this.mob = mob;
        this.herdGoal = herdGoal;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    public HerdChallengeGoal setGiveUpFraction(float giveUpFraction) {
        this.giveUpFraction = giveUpFraction;
        return this;
    }

    public HerdChallengeGoal setChallengeInterval(int challengeInterval) {
        this.challengeInterval = Math.max(2, challengeInterval);
        return this;
    }

    public HerdChallengeGoal setCooldown(int cooldown) {
        this.cooldown = cooldown;
        return this;
    }

    public HerdChallengeGoal setAttackInterval(int attackInterval) {
        this.attackInterval = Math.max(10, attackInterval);
        return this;
    }

    public HerdChallengeGoal setFallbackDamage(float fallbackDamage) {
        this.fallbackDamage = fallbackDamage;
        return this;
    }

    public HerdChallengeGoal setMaxDuelTicks(int maxDuelTicks) {
        this.maxDuelTicks = maxDuelTicks;
        return this;
    }

    public boolean isDueling() {
        return this.opponent != null;
    }

    private static HerdChallengeGoal getChallengeGoal(Mob other) {
        for (WrappedGoal wrapped : other.goalSelector.getAvailableGoals()) {
            if (wrapped.getGoal() instanceof HerdChallengeGoal challengeGoal) {
                return challengeGoal;
            }
        }
        return null;
    }

    private static boolean isDuelingPair(Mob first, Mob second) {
        HerdChallengeGoal goal = getChallengeGoal(first);
        return goal != null && goal.opponent == second;
    }

    public static void onChangeTarget(LivingChangeTargetEvent event) {
        if (event.getEntity() instanceof Mob mob && event.getNewTarget() instanceof Mob target && isDuelingPair(mob, target)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof Mob victim && event.getSource().getEntity() instanceof Mob attacker && isDuelingPair(victim, attacker)) {
            float amount = Math.min(event.getAmount(), victim.getHealth() - 0.5F);
            if (amount <= 0.0F) {
                event.setCanceled(true);
            } else {
                event.setAmount(amount);
            }
        }
    }

    private boolean isBeaten(Mob fighter) {
        return fighter.getHealth() < fighter.getMaxHealth() * this.giveUpFraction || fighter.getHealth() <= 1.0F;
    }

    private boolean isReady(Mob fighter) {
        return fighter.isAlive() && !fighter.isBaby() && fighter.getHealth() > fighter.getMaxHealth() * 0.5F;
    }

    private boolean opponentValid() {
        return this.opponent != null && this.opponent.isAlive() && !this.opponent.isRemoved() && this.opponent.level() == this.mob.level();
    }

    @Override
    public boolean canUse() {
        if (this.opponent != null) {
            if (this.opponentValid()) {
                return true;
            }
            this.opponent = null;
        }
        long now = this.mob.level().getGameTime();
        if (now < this.cooldownUntil || this.herdGoal.isPanicking() || !this.isReady(this.mob)) {
            return false;
        }
        Mob leader = this.herdGoal.getLeader();
        if (leader == null || !this.isReady(leader) || this.mob.distanceToSqr(leader) > 32.0D * 32.0D) {
            return false;
        }
        if (this.mob.getRandom().nextInt(Math.max(1, this.challengeInterval / 2)) != 0) {
            return false;
        }
        HerdChallengeGoal leaderGoal = getChallengeGoal(leader);
        if (leaderGoal == null || leaderGoal.isDueling() || now < leaderGoal.cooldownUntil || leaderGoal.herdGoal.isPanicking()) {
            return false;
        }
        this.beginDuel(leader);
        leaderGoal.beginDuel(this.mob);
        return true;
    }

    private void beginDuel(Mob target) {
        this.opponent = target;
        this.duelTicks = 0;
        this.attackTimer = this.attackInterval;
        this.pathTimer = 0;
    }

    @Override
    public boolean canContinueToUse() {
        return this.opponentValid();
    }

    @Override
    public void stop() {
        this.mob.getNavigation().stop();
        if (this.opponent != null) {
            this.endDuel(null);
        }
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public void tick() {
        Mob target = this.opponent;
        if (target == null) {
            return;
        }
        this.duelTicks++;
        if (this.mob.getTarget() == target) {
            this.mob.setTarget(null);
        }
        if (this.isBeaten(this.mob)) {
            this.endDuel(target);
            return;
        }
        if (this.isBeaten(target)) {
            this.endDuel(this.mob);
            return;
        }
        if (this.duelTicks >= this.maxDuelTicks) {
            float mine = this.mob.getHealth() / this.mob.getMaxHealth();
            float theirs = target.getHealth() / target.getMaxHealth();
            this.endDuel(mine >= theirs ? this.mob : target);
            return;
        }

        this.mob.getLookControl().setLookAt(target, 30.0F, 30.0F);
        if (--this.pathTimer <= 0) {
            this.pathTimer = this.adjustedTickDelay(10);
            this.mob.getNavigation().moveTo(target, this.speed);
        }
        this.attackTimer = Math.max(this.attackTimer - 1, 0);
        double reach = this.mob.getBbWidth() * 2.0F * this.mob.getBbWidth() * 2.0F + target.getBbWidth();
        if (this.attackTimer <= 0 && this.mob.distanceToSqr(target) <= reach) {
            this.attackTimer = this.attackInterval;
            this.performAttack(target);
        }
    }

    protected void performAttack(Mob target) {
        float damage = this.mob.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? (float) this.mob.getAttributeValue(Attributes.ATTACK_DAMAGE) : this.fallbackDamage;
        damage = Math.min(damage, target.getHealth() - 0.5F);
        if (damage <= 0.0F) {
            return;
        }
        this.mob.swing(InteractionHand.MAIN_HAND);
        target.hurt(this.mob.damageSources().mobAttack(this.mob), damage);
    }

    private void endDuel(Mob winner) {
        Mob other = this.opponent;
        this.finish();
        if (other != null) {
            HerdChallengeGoal otherGoal = getChallengeGoal(other);
            if (otherGoal != null) {
                otherGoal.finish();
            }
        }
        if (winner != null) {
            this.herdGoal.promoteToLeader(winner);
        }
    }

    private void finish() {
        this.opponent = null;
        this.cooldownUntil = this.mob.level().getGameTime() + this.cooldown;
        this.mob.setTarget(null);
        this.mob.setLastHurtByMob(null);
        this.mob.getNavigation().stop();
    }
}