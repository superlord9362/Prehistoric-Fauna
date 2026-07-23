package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;
import superlord.prehistoricfauna.init.PFBlocks;

public class HermanophytonTopBlock extends Block implements IPlantable, BonemealableBlock {
	protected static final VoxelShape SHAPE_NORMAL = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 10.0D, 9.0D);
	protected static final VoxelShape SHAPE_COLLISION = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 10.0D, 9.0D);
	public static final BooleanProperty PLAYER_PLACED = BooleanProperty.create("player_placed");
	public static final BooleanProperty CAN_GROW = BooleanProperty.create("can_grow");

	public HermanophytonTopBlock(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.stateDefinition.any().setValue(PLAYER_PLACED, true).setValue(CAN_GROW, true));
	}
	
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (!this.canSurvive(stateIn, worldIn, currentPos)) {
			worldIn.scheduleTick(currentPos, this, 1);
		}
		return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		BlockState blockstate = worldIn.getBlockState(pos.below());
		if (blockstate.canSustainPlant(worldIn, pos.below(), Direction.UP, this) || blockstate.is(Blocks.SAND) || blockstate.is(Blocks.PACKED_MUD) || blockstate.getBlock() == PFBlocks.HERMANOPHYTON.get()) {
			return true;
		} else return false;
	}
    
    @Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		VoxelShape voxelShape = SHAPE_NORMAL;
		Vec3 vector3d = state.getOffset(world, pos);
		return voxelShape.move(vector3d.x, vector3d.y, vector3d.z);
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 vector3d = state.getOffset(world, pos);
		return SHAPE_COLLISION.move(vector3d.x, vector3d.y, vector3d.z);
	}
	
	public void tick(BlockState p_51678_, ServerLevel p_51679_, BlockPos p_51680_, RandomSource p_51681_) {
		if (!p_51678_.canSurvive(p_51679_, p_51680_)) {
			p_51679_.destroyBlock(p_51680_, true);
		}
	}
    
    @Override
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
    	boolean growing = getNumHermanophytonBlocksBelow(world, pos) < random.nextInt(8) + 10;
    	if (world.isEmptyBlock(pos.above()) && canGrow(state) && isPlayerPlaced(state) && growing) {
    		world.setBlock(pos, PFBlocks.HERMANOPHYTON.get().defaultBlockState().setValue(HermanophytonBlock.HAS_LEAVES, true), 2);
    		world.setBlock(pos.above(), this.defaultBlockState(), 2);
    		if (world.getBlockState(pos.below()).is(PFBlocks.HERMANOPHYTON.get())) {
    			world.setBlock(pos.below(), PFBlocks.HERMANOPHYTON.get().defaultBlockState(), 2);
    		}
    	} else if (!growing) world.setBlock(pos, state.setValue(CAN_GROW, false), 2);
    }
    
    public boolean canGrow(BlockState state) {
    	return state.getValue(CAN_GROW);
    }
    
    public boolean isPlayerPlaced(BlockState state) {
    	return state.getValue(PLAYER_PLACED);
    }
    
    public BlockBehaviour.OffsetType getValueOffsetType() {
		return BlockBehaviour.OffsetType.XZ;
	}
    
    @Override
	public BlockState getPlant(BlockGetter world, BlockPos pos) {
		return defaultBlockState();
	}
    
    protected int getNumHermanophytonBlocksBelow(BlockGetter worldIn, BlockPos pos) {
		int i;
		for(i = 0; i < 18 && worldIn.getBlockState(pos.below(i + 1)).is(PFBlocks.HERMANOPHYTON.get()); ++i) {
		}
		return i;
	}
    
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(PLAYER_PLACED, CAN_GROW);
	}
    
    public boolean isValidBonemealTarget(LevelReader p_57325_, BlockPos p_57326_, BlockState p_57327_, boolean p_57328_) {
		return true;
	}

	public boolean isBonemealSuccess(Level p_57330_, RandomSource p_57331_, BlockPos p_57332_, BlockState p_57333_) {
		return true;
	}
	
	@Override
	public void performBonemeal(ServerLevel p_50893_, RandomSource p_50894_, BlockPos p_50895_, BlockState p_50896_) {
	      popResource(p_50893_, p_50895_, new ItemStack(this));
	}

}
