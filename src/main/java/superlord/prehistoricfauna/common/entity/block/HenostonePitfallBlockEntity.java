package superlord.prehistoricfauna.common.entity.block;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import superlord.prehistoricfauna.common.blocks.HenostonePitfallBlock;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class HenostonePitfallBlockEntity extends BlockEntity {

	private enum TrapState { IDLE, WARNING_1, WARNING_2, WARNING_3, OPEN, COOLDOWN }

	private static final int WARNING_1_DURATION  = 20;
	private static final int WARNING_2_DURATION  = 20;
	private static final int WARNING_3_BEEP_B    = 7;
	private static final int WARNING_3_BEEP_C    = 14;
	private static final int WARNING_3_DURATION  = 20;
	private static final int OPEN_HOLD_TICKS     = 40;
	private static final int COOLDOWN_DURATION   = 100;

	private TrapState state = TrapState.IDLE;
	private int       timer = 0;

	public HenostonePitfallBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
		super(PFBlockEntities.HENOSTONE_PITFALL.get(), pos, blockState);
	}

	public HenostonePitfallBlockEntity(BlockPos pos, BlockState blockState) {
		super(PFBlockEntities.HENOSTONE_PITFALL.get(), pos, blockState);
	}

	@Override
	public void load(CompoundTag tag) {
		super.load(tag);
		state = TrapState.values()[tag.getInt("TrapState")];
		timer = tag.getInt("TrapTimer");
	}

	@Override
	protected void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
		tag.putInt("TrapState", state.ordinal());
		tag.putInt("TrapTimer", timer);
	}

	public static void tick(Level level, BlockPos pos, BlockState blockState, HenostonePitfallBlockEntity be) {
		be.doTick(level, pos, blockState);
	}

	private void doTick(Level level, BlockPos pos, BlockState blockState) {
		if (!(blockState.getBlock() instanceof HenostonePitfallBlock)) return;

		AABB detectionAABB = new AABB(pos.getX(), pos.getY() + 0.9, pos.getZ(), pos.getX() + 1, pos.getY() + 2.0, pos.getZ() + 1);

		switch (state) {

		case IDLE -> {
			if (!blockState.getValue(HenostonePitfallBlock.OPEN)) {
				List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, detectionAABB);
				if (!entities.isEmpty()) {
					transitionTo(TrapState.WARNING_1);
					playWarningSound(level, pos);
				}
			}
		}

		case WARNING_1 -> {
			timer++;
			if (timer >= WARNING_1_DURATION) {
				transitionTo(TrapState.WARNING_2);
				playWarningSound(level, pos);
			}
		}

		case WARNING_2 -> {
			timer++;
			if (timer >= WARNING_2_DURATION) {
				transitionTo(TrapState.WARNING_3);
				playWarningSound(level, pos);
			}
		}

		case WARNING_3 -> {
			timer++;
			if (timer == WARNING_3_BEEP_B) playWarningSound(level, pos);
			if (timer == WARNING_3_BEEP_C) playWarningSound(level, pos);
			if (timer >= WARNING_3_DURATION) {
				setOpen(level, pos, blockState, true);
				transitionTo(TrapState.OPEN);
			}
		}

		case OPEN -> {
			timer++;
			if (timer >= OPEN_HOLD_TICKS) {
				setOpen(level, pos, level.getBlockState(pos), false);
				transitionTo(TrapState.COOLDOWN);
			}
		}

		case COOLDOWN -> {
			timer++;
			if (timer >= COOLDOWN_DURATION) {
				transitionTo(TrapState.IDLE);
			}
		}
		}
	}

	private void setOpen(Level level, BlockPos pos, BlockState state, boolean open) {
		boolean current = state.getValue(HenostonePitfallBlock.OPEN);
		if (current != open) {
			level.setBlockAndUpdate(pos, state.setValue(HenostonePitfallBlock.OPEN, open));
			level.playSound(null, pos, SoundEvents.IRON_TRAPDOOR_OPEN, SoundSource.BLOCKS, 1.0f, 1f);
		}
	}

	private void playWarningSound(Level level, BlockPos pos) {
		if (!level.isClientSide) {
			level.playSound(null, pos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 1.0f, 1.5f);
		}
	}

	private void transitionTo(TrapState next) {
		state = next;
		timer = 0;
		setChanged();
	}
}