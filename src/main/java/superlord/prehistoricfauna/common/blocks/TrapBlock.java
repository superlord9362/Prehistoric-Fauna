package superlord.prehistoricfauna.common.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.init.PFDamageSources;

public class TrapBlock extends Block {
	protected static final VoxelShape PRESSED_AABB = Block.box(0.0D, 0.0D, 0.0D, 15.0D, 15.0D, 15.0D);
	protected static final VoxelShape UNPRESSED_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);
	protected static final AABB PRESSURE_AABB = new AABB(0.125D, 0.0D, 0.125D, 15.0D, 16.0D, 15.0D);
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	private final TrapBlock.Sensitivity sensitivity;

	public TrapBlock(TrapBlock.Sensitivity sensitivity, Block.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, Boolean.valueOf(false)));
		this.sensitivity = sensitivity;
	}


	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(POWERED);
	}


	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return this.getRedstoneStrength(state) > 0 ? PRESSED_AABB : UNPRESSED_AABB;
	}

	public int tickRate() {
		return 20;
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
		return facing == Direction.DOWN && !stateIn.canSurvive(worldIn, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}	

	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
		int i = this.getRedstoneStrength(state);
		if (i > 0) {
			this.updateState(worldIn, pos, state, i);
		}
	}	

	public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
		if (!worldIn.isClientSide) {
//			if (!(entityIn instanceof TrilobiteSentinelEntity) || !(entityIn instanceof TimeGuardianEntity)) {
				int i = this.getRedstoneStrength(state);
				if (i == 0) {
					this.updateState(worldIn, pos, state, i);
				}
				if(state.getValue(POWERED)) {
					entityIn.hurt(PFDamageSources.HENOSTONE_TRAP, 2.0F);
				}
//			}
		}
	}

	protected void updateState(Level worldIn, BlockPos pos, BlockState state, int oldRedstoneStrength) {
		int i = this.computeRedstoneStrength(worldIn, pos);
		boolean flag = oldRedstoneStrength > 0;
		boolean flag1 = i > 0;
		if (oldRedstoneStrength != i) {
			BlockState blockstate = this.setRedstoneStrength(state, i);
			worldIn.setBlock(pos, blockstate, 2);
			this.updateNeighbors(worldIn, pos);
			worldIn.setBlocksDirty(pos, state, blockstate);
		}

		if (!flag1 && flag) {
			this.playClickOffSound(worldIn, pos);
		} else if (flag1 && !flag) {
			this.playClickOnSound(worldIn, pos);
		}

		if (flag1) {
			worldIn.scheduleTick(new BlockPos(pos), this, this.tickRate());
		}

	}

	protected void playClickOnSound(LevelAccessor worldIn, BlockPos pos) {
		worldIn.playSound((Player)null, pos, SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON, SoundSource.BLOCKS, 0.3F, 0.6F);
	}

	protected void playClickOffSound(LevelAccessor worldIn, BlockPos pos) {
		worldIn.playSound((Player)null, pos, SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF, SoundSource.BLOCKS, 0.3F, 0.5F);
	}

	@SuppressWarnings("deprecation")
	public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (!isMoving && state.getBlock() != newState.getBlock()) {
			if (this.getRedstoneStrength(state) > 0) {
				this.updateNeighbors(worldIn, pos);
			}
			super.onRemove(state, worldIn, pos, newState, isMoving);
		}
	}

	protected void updateNeighbors(Level worldIn, BlockPos pos) {
		worldIn.updateNeighborsAt(pos, this);
	}


	protected int getRedstoneStrength(BlockState state) {
		return state.getValue(POWERED) ? 15 : 0;
	}

	protected BlockState setRedstoneStrength(BlockState state, int strength) {
		return state.setValue(POWERED, Boolean.valueOf(strength > 0));
	}

	protected int computeRedstoneStrength(Level worldIn, BlockPos pos) {
		AABB axisalignedbb = PRESSURE_AABB.move(pos);
		List<? extends Entity> list;
		switch(this.sensitivity) {
		case MOBS:
			list = worldIn.getEntitiesOfClass(LivingEntity.class, axisalignedbb);
			break;
		default:
			return 0;
		}

		if (!list.isEmpty()) {
			for(Entity entity : list) {
				if (!entity.isIgnoringBlockTriggers()) {
					return 15;
				}
			}
		}
		return 0;
	}

	public static enum Sensitivity {
		MOBS;
	}

}
