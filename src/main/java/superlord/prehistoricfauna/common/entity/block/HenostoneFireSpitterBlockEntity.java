package superlord.prehistoricfauna.common.entity.block;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import superlord.prehistoricfauna.common.blocks.HenostoneFireSpitterBlock;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class HenostoneFireSpitterBlockEntity extends BlockEntity {

	private enum FireState { IDLE, WARNING_1, WARNING_2, WARNING_3, FIRING, COOLDOWN }

	private static final int WARNING_1_TICKS = 0;
	private static final int WARNING_2_TICKS = 20;
	private static final int WARNING_3A_TICKS = 40;
	private static final int WARNING_3B_TICKS = 47;
	private static final int WARNING_3C_TICKS = 54;
	private static final int FIRE_START_TICKS = 60;
	private static final int FIRE_END_TICKS = 120;
	private static final int COOLDOWN_TICKS = 100;

	private FireState state = FireState.IDLE;
	private int timer = 0;
	private double rangeLen = 8.0;

	public HenostoneFireSpitterBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
		super(PFBlockEntities.HENOSTONE_FIRE_SPITTER.get(), pos, blockState);
	}

	public HenostoneFireSpitterBlockEntity(BlockPos pos, BlockState blockState) {
		super(PFBlockEntities.HENOSTONE_FIRE_SPITTER.get(), pos, blockState);
	}

	@Override
	public void load(CompoundTag tag) {
		super.load(tag);
		state  = FireState.values()[tag.getInt("FireState")];
		timer  = tag.getInt("FireTimer");
	}

	@Override
	protected void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
		tag.putInt("FireState", state.ordinal());
		tag.putInt("FireTimer", timer);
	}

	public static void tick(Level level, BlockPos pos, BlockState blockState,
			HenostoneFireSpitterBlockEntity be) {
		be.doTick(level, pos, blockState);
	}

	private void doTick(Level level, BlockPos pos, BlockState blockState) {
		if (!(blockState.getBlock() instanceof HenostoneFireSpitterBlock fireSpitter)) return;

		Direction dir = fireSpitter.getDirection(blockState);

		rangeLen = raycastRange(level, pos, dir, 8.0);

		AABB detectionAABB = buildAABB(pos, dir, rangeLen);

		switch (state) {

		case IDLE -> {
			List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, detectionAABB);
			if (!entities.isEmpty()) {
				boolean hasValidTarget = entities.stream().anyMatch(e ->
				!(e instanceof Player player && player.isCreative()));
				if (hasValidTarget) {
					transitionTo(FireState.WARNING_1, level, pos);
				}
			}
			setPowered(level, pos, blockState, false);
		}

		case WARNING_1 -> {
			timer++;
			if (timer == WARNING_1_TICKS + 1) {
				playWarningSound(level, pos);
			}
			if (timer >= WARNING_2_TICKS) {
				transitionTo(FireState.WARNING_2, level, pos);
			}
		}

		case WARNING_2 -> {
			timer++;
			if (timer == WARNING_1_TICKS + 1) {
				playWarningSound(level, pos);
			}
			if (timer >= WARNING_2_TICKS) {
				transitionTo(FireState.WARNING_3, level, pos);
			}
		}

		case WARNING_3 -> {
			timer++;
			if (timer == WARNING_3A_TICKS - WARNING_3A_TICKS + 1) playWarningSound(level, pos);
			if (timer == WARNING_3B_TICKS - WARNING_3A_TICKS + 1) playWarningSound(level, pos);
			if (timer == WARNING_3C_TICKS - WARNING_3A_TICKS + 1) playWarningSound(level, pos);
			if (timer >= FIRE_START_TICKS - WARNING_3A_TICKS) {
				transitionTo(FireState.FIRING, level, pos);
			}
		}

		case FIRING -> {
			timer++;
			setPowered(level, pos, blockState, true);

			List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class, detectionAABB);
			double ox = pos.getX() + 0.5;
			double oy = pos.getY() + 0.5;
			double oz = pos.getZ() + 0.5;
			level.addParticle(ParticleTypes.FLAME, ox, oy, oz, dir.getStepX() * 0.5, 0, dir.getStepZ() * 0.5);
			for (LivingEntity entity : targets) {
				if (!entity.fireImmune()) {
					entity.setSecondsOnFire(8);
					entity.hurt(level.damageSources().inFire(), 1);
				}
			}

			if (timer >= FIRE_END_TICKS - FIRE_START_TICKS) {
				transitionTo(FireState.COOLDOWN, level, pos);
			}
		}

		case COOLDOWN -> {
			timer++;
			setPowered(level, pos, blockState, false);
			if (timer >= COOLDOWN_TICKS) {
				transitionTo(FireState.IDLE, level, pos);
			}
		}
		}
	}

	private double raycastRange(Level level, BlockPos pos, Direction dir, double maxRange) {
		Vec3 origin = new Vec3(pos.getX() + 0.5 + dir.getStepX() * 0.5, pos.getY(), pos.getZ() + 0.5 + dir.getStepZ() * 0.5);
		Vec3 target = origin.add(dir.getStepX() * maxRange, 0, dir.getStepZ() * maxRange);

		BlockHitResult hit = level.clip(new ClipContext(origin, target, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, null));

		if (hit.getType() == HitResult.Type.BLOCK) {
			return hit.getLocation().distanceTo(origin);
		}
		return maxRange;
	}

	private AABB buildAABB(BlockPos pos, Direction dir, double range) {
		double startX = pos.getX() + 0.5 + dir.getStepX() * 0.5;
		double startY = pos.getY();
		double startZ = pos.getZ() + 0.5 + dir.getStepZ() * 0.5;

		double endX = startX + dir.getStepX() * range;
		double endZ = startZ + dir.getStepZ() * range;

		return new AABB(Math.min(startX, endX), startY, Math.min(startZ, endZ), Math.max(startX, endX), startY + 1, Math.max(startZ, endZ)).inflate(0.5, 0, 0.5);
	}

	private void playWarningSound(Level level, BlockPos pos) {
		if (!level.isClientSide) {
			level.playSound(null, pos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 1.0f, 1.5f);
		}
	}

	private void setPowered(Level level, BlockPos pos, BlockState state, boolean powered) {
		boolean current = state.getValue(HenostoneFireSpitterBlock.POWERED);
		if (current != powered) {
			level.setBlockAndUpdate(pos, state.setValue(HenostoneFireSpitterBlock.POWERED, powered));
		}
	}

	private void transitionTo(FireState next, Level level, BlockPos pos) {
		state = next;
		timer = 0;
		setChanged();
	}
}