package superlord.prehistoricfauna.common.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.common.entities.TimeGuardianEntity;
import superlord.prehistoricfauna.common.entities.TrilobiteSentinelEntity;
import superlord.prehistoricfauna.init.PFCustomDamageSource;

public class TrapBlock extends Block {
	protected static final VoxelShape PRESSED_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 15.0D, 15.0D, 15.0D);
	protected static final VoxelShape UNPRESSED_AABB = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);
	protected static final AxisAlignedBB PRESSURE_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.125D, 15.0D, 16.0D, 15.0D);
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	private final TrapBlock.Sensitivity sensitivity;

	public TrapBlock(TrapBlock.Sensitivity sensitivity, Block.Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(POWERED, Boolean.valueOf(false)));
		this.sensitivity = sensitivity;
	}


	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(POWERED);
	}


	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return this.getRedstoneStrength(state) > 0 ? PRESSED_AABB : UNPRESSED_AABB;
	}

	public int tickRate(IWorldReader worldIn) {
		return 20;
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		return facing == Direction.DOWN && !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}	

	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = this.getRedstoneStrength(state);
		System.out.println("Pain");
		if (i > 0) {
			this.updateState(worldIn, pos, state, i);
		}
	}	

	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (!worldIn.isRemote) {
			if (!(entityIn instanceof TrilobiteSentinelEntity) || !(entityIn instanceof TimeGuardianEntity)) {
				int i = this.getRedstoneStrength(state);
				if (i == 0) {
					this.updateState(worldIn, pos, state, i);
				}
				if(state.get(POWERED)) {
					entityIn.attackEntityFrom(PFCustomDamageSource.HENOSTONE_TRAP, 2.0F);
				}
			}
		}
	}

	protected void updateState(World worldIn, BlockPos pos, BlockState state, int oldRedstoneStrength) {
		int i = this.computeRedstoneStrength(worldIn, pos);
		boolean flag = oldRedstoneStrength > 0;
		boolean flag1 = i > 0;
		if (oldRedstoneStrength != i) {
			BlockState blockstate = this.setRedstoneStrength(state, i);
			worldIn.setBlockState(pos, blockstate, 2);
			this.updateNeighbors(worldIn, pos);
			worldIn.markBlockRangeForRenderUpdate(pos, state, blockstate);
		}

		if (!flag1 && flag) {
			this.playClickOffSound(worldIn, pos);
		} else if (flag1 && !flag) {
			this.playClickOnSound(worldIn, pos);
		}

		if (flag1) {
			worldIn.getPendingBlockTicks().scheduleTick(new BlockPos(pos), this, this.tickRate(worldIn));
		}

	}

	protected void playClickOnSound(IWorld worldIn, BlockPos pos) {
		worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.6F);
	}

	protected void playClickOffSound(IWorld worldIn, BlockPos pos) {
		worldIn.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.5F);
	}

	@SuppressWarnings("deprecation")
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (!isMoving && state.getBlock() != newState.getBlock()) {
			if (this.getRedstoneStrength(state) > 0) {
				this.updateNeighbors(worldIn, pos);
			}
			super.onReplaced(state, worldIn, pos, newState, isMoving);
		}
	}

	protected void updateNeighbors(World worldIn, BlockPos pos) {
		worldIn.notifyNeighborsOfStateChange(pos, this);
	}


	protected int getRedstoneStrength(BlockState state) {
		return state.get(POWERED) ? 15 : 0;
	}

	protected BlockState setRedstoneStrength(BlockState state, int strength) {
		return state.with(POWERED, Boolean.valueOf(strength > 0));
	}

	protected int computeRedstoneStrength(World worldIn, BlockPos pos) {
		AxisAlignedBB axisalignedbb = PRESSURE_AABB.offset(pos);
		List<? extends Entity> list;
		switch(this.sensitivity) {
		case MOBS:
			list = worldIn.getEntitiesWithinAABB(LivingEntity.class, axisalignedbb);
			break;
		default:
			return 0;
		}

		if (!list.isEmpty()) {
			for(Entity entity : list) {
				if (!entity.doesEntityNotTriggerPressurePlate()) {
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
