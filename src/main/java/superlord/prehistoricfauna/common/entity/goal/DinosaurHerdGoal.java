package superlord.prehistoricfauna.common.entity.goal;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;

public class DinosaurHerdGoal extends Goal {
	public static final int HERD_RADIUS = 10;
	public static final int MAX_HERD_SIZE = 5;

	protected final Mob mob;
	private final double speed;
	private int herdRadius;
	private int maxHerdSize;
	private int leaderSearchRadius = 32;

	private boolean elected;
	private Mob leader;
	private final List<Mob> members = new ArrayList<>();
	private boolean returning;
	private int roamCooldown;
	private int catchUpTimer;
	private long panicEndTick;
	private LivingEntity panicThreat;
	private boolean showBorder = true;
	private boolean glowMembers = true;
	private int visualTimer;

	public DinosaurHerdGoal(Mob mob) {
		this(mob, HERD_RADIUS, MAX_HERD_SIZE, 1.0D);
	}

	public DinosaurHerdGoal(Mob mob, int herdRadius, int maxHerdSize, double speed) {
		this.mob = mob;
		this.herdRadius = herdRadius;
		this.maxHerdSize = maxHerdSize;
		this.speed = speed;
		this.setFlags(EnumSet.of(Flag.MOVE));
	}

	public DinosaurHerdGoal setHerdRadius(int herdRadius) {
		this.herdRadius = Math.max(1, herdRadius);
		return this;
	}

	public DinosaurHerdGoal setMaxHerdSize(int maxHerdSize) {
		this.maxHerdSize = Math.max(1, maxHerdSize);
		return this;
	}

	public DinosaurHerdGoal setLeaderSearchRadius(int leaderSearchRadius) {
		this.leaderSearchRadius = leaderSearchRadius;
		return this;
	}

	public DinosaurHerdGoal setShowBorder(boolean showBorder) {
		this.showBorder = showBorder;
		return this;
	}

	public DinosaurHerdGoal setGlowMembers(boolean glowMembers) {
		this.glowMembers = glowMembers;
		return this;
	}

	public boolean isLeader() {
		return this.elected && this.leader == null;
	}

	public List<Mob> getHerd() {
		List<Mob> herd = new ArrayList<>();
		if (this.leader != null) {
			if (!this.leaderValid()) {
				herd.add(this.mob);
				return herd;
			}
			DinosaurHerdGoal leaderGoal = getHerdGoal(this.leader);
			herd.add(this.leader);
			if (leaderGoal != null) {
				leaderGoal.herdSize();
				herd.addAll(leaderGoal.members);
			}
			return herd;
		}
		herd.add(this.mob);
		this.herdSize();
		herd.addAll(this.members);
		return herd;
	}

	public void triggerPanic(int duration, LivingEntity threat) {
		long end = this.mob.level().getGameTime() + duration;
		for (Mob member : this.getHerd()) {
			DinosaurHerdGoal memberGoal = getHerdGoal(member);
			if (memberGoal != null) {
				memberGoal.panicEndTick = end;
				memberGoal.panicThreat = threat;
			}
		}
	}

	public boolean isPanicking() {
		return this.mob.level().getGameTime() < this.panicEndTick;
	}

	public LivingEntity getPanicThreat() {
		return this.panicThreat;
	}

	private int herdSize() {
		this.members.removeIf(m -> !m.isAlive() || m.isRemoved());
		return this.members.size() + 1;
	}

	private static DinosaurHerdGoal getHerdGoal(Mob other) {
		for (WrappedGoal wrapped : other.goalSelector.getAvailableGoals()) {
			if (wrapped.getGoal() instanceof DinosaurHerdGoal herdGoal) {
				return herdGoal;
			}
		}
		return null;
	}

	private void elect() {
		this.elected = true;
		this.leader = null;
		List<Mob> candidates = new ArrayList<>();
		List<? extends Mob> nearby = this.mob.level().getEntitiesOfClass(Mob.class, this.mob.getBoundingBox().inflate(this.leaderSearchRadius), m -> m != this.mob && m.isAlive() && this.canFollow(m));
		for (Mob other : nearby) {
			DinosaurHerdGoal otherGoal = getHerdGoal(other);
			if (otherGoal != null && otherGoal.isLeader() && otherGoal.herdSize() < otherGoal.maxHerdSize) {
				candidates.add(other);
			}
		}
		if (!candidates.isEmpty()) {
			Mob chosen = candidates.get(this.mob.getRandom().nextInt(candidates.size()));
			DinosaurHerdGoal chosenGoal = getHerdGoal(chosen);
			this.leader = chosen;
			chosenGoal.members.add(this.mob);
		}
	}

	protected boolean canFollow(Mob other) {
		return other.getType() == this.mob.getType();
	}

	protected boolean shouldLeaveHerd() {
		return false;
	}

	protected void leaveHerd() {
		if (this.leader != null) {
			DinosaurHerdGoal leaderGoal = getHerdGoal(this.leader);
			if (leaderGoal != null) {
				leaderGoal.members.remove(this.mob);
			}
		}
		this.members.clear();
		this.leader = null;
		this.elected = false;
	}

	public Mob getLeader() {
		return this.leaderValid() ? this.leader : null;
	}

	public void promoteToLeader(Mob winner) {
		DinosaurHerdGoal winnerGoal = getHerdGoal(winner);
		if (winnerGoal == null || !winnerGoal.leaderValid()) {
			return;
		}
		Mob oldLeader = winnerGoal.leader;
		DinosaurHerdGoal oldGoal = getHerdGoal(oldLeader);
		List<Mob> newMembers = new ArrayList<>(oldGoal.members);
		newMembers.remove(winner);
		newMembers.add(oldLeader);
		oldGoal.members.clear();
		winnerGoal.members.clear();
		winnerGoal.members.addAll(newMembers);
		winnerGoal.leader = null;
		for (Mob member : newMembers) {
			DinosaurHerdGoal memberGoal = getHerdGoal(member);
			if (memberGoal != null) {
				memberGoal.leader = winner;
			}
		}
	}

	private boolean leaderValid() {
		if (this.leader == null || !this.leader.isAlive() || this.leader.isRemoved() || this.leader.level() != this.mob.level()) {
			return false;
		}
		DinosaurHerdGoal leaderGoal = getHerdGoal(this.leader);
		return leaderGoal != null && leaderGoal.isLeader() && leaderGoal.members.contains(this.mob) && this.canFollow(this.leader);
	}

	@Override
	public boolean canUse() {
		if (this.elected && this.shouldLeaveHerd()) {
			this.leaveHerd();
		}
		if (!this.elected) {
			this.elect();
		}
		if (this.leader == null) {
			this.tickVisuals();
			return false;
		}
		if (!this.leaderValid()) {
			this.leaveHerd();
			return false;
		}
		return true;
	}

	private void tickVisuals() {
		if (!(this.mob.level() instanceof ServerLevel level) || --this.visualTimer > 0) {
			return;
		}
		this.visualTimer = 10;
		List<Mob> herd = this.getHerd();
		if (herd.size() < 2) {
			return;
		}
//		if (this.glowMembers) {
//			if (this.isLeader()) {
//				this.mob.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 0, false, false));
//			}
//		}
//		if (this.showBorder) {
//			if (this.isLeader()) {
//				this.spawnBorder(level);
//			}
//		}
	}

	@SuppressWarnings("deprecation")
	private void spawnBorder(ServerLevel level) {
		int points = Math.max(12, (int) (2.0D * Math.PI * this.herdRadius / 1.5D));
		for (int i = 0; i < points; i++) {
			double angle = 2.0D * Math.PI * i / points;
			double x = this.mob.getX() + Math.cos(angle) * this.herdRadius;
			double z = this.mob.getZ() + Math.sin(angle) * this.herdRadius;
			BlockPos column = BlockPos.containing(x, 0, z);
			if (!level.hasChunkAt(column)) {
				continue;
			}
			double y = level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, column).getY();
			level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y + 0.1D, z, 0, 0.0D, 1.0D, 0.0D, 0.07D);
		}
	}

	@Override
	public boolean canContinueToUse() {
		return this.leaderValid();
	}

	@Override
	public void start() {
		this.returning = false;
		this.roamCooldown = 0;
		this.catchUpTimer = 0;
	}

	@Override
	public void stop() {
		this.mob.getNavigation().stop();
		if (this.leader != null && !this.leaderValid()) {
			this.leaveHerd();
		}
	}

	@Override
	public boolean requiresUpdateEveryTick() {
		return false;
	}

	@Override
	public void tick() {
		PathNavigation nav = this.mob.getNavigation();
		double distSqr = this.mob.distanceToSqr(this.leader);
		double radiusSqr = (double) this.herdRadius * this.herdRadius;
		double returnedSqr = radiusSqr * 0.36D;

		if (distSqr > radiusSqr) {
			this.returning = true;
		} else if (distSqr < returnedSqr) {
			this.returning = false;
		}

		if (this.returning) {
			if (--this.catchUpTimer <= 0) {
				this.catchUpTimer = this.adjustedTickDelay(10);
				nav.moveTo(this.leader, this.speed * 1.2D);
			}
			return;
		}

		if (nav.isDone() && --this.roamCooldown <= 0) {
			this.roamCooldown = 40 + this.mob.getRandom().nextInt(80);
			Vec3 pos = this.findRoamPos();
			if (pos != null) {
				nav.moveTo(pos.x, pos.y, pos.z, this.speed);
			}
		}
		this.tickVisuals();
	}

	protected Vec3 findRoamPos() {
		double maxDist = this.herdRadius * 0.8D;
		for (int i = 0; i < 10; i++) {
			double x = this.leader.getX() + (this.mob.getRandom().nextDouble() * 2.0D - 1.0D) * maxDist;
			double z = this.leader.getZ() + (this.mob.getRandom().nextDouble() * 2.0D - 1.0D) * maxDist;
			BlockPos ground = this.mob.level().getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BlockPos.containing(x, 0, z));
			Vec3 target = new Vec3(x, ground.getY(), z);
			if (target.distanceToSqr(this.leader.position()) <= (double) this.herdRadius * this.herdRadius && this.mob.getNavigation().createPath(ground, 0) != null) {
				return target;
			}
		}
		return null;
	}

}