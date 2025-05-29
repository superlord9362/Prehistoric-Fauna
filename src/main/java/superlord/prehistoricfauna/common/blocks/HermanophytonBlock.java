package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;

public class HermanophytonBlock extends Block implements IPlantable {
	protected static final VoxelShape SHAPE_NORMAL = Block.box(7.0D, 0.0D, 7.0D, 9D, 16.0D, 9D);
	protected static final VoxelShape SHAPE_COLLISION = Block.box(7.0D, 0.0D, 7.0D, 9D, 16.0D, 9D);
	public static final BooleanProperty HAS_LEAVES = BooleanProperty.create("has_leaves");

	public HermanophytonBlock(Properties p_49795_) {
		super(p_49795_);
		this.registerDefaultState(this.stateDefinition.any().setValue(HAS_LEAVES, false));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		VoxelShape voxelShape = SHAPE_NORMAL;
		Vec3 vector3d = state.getOffset(world, pos);
		return voxelShape.move(vector3d.x, vector3d.y, vector3d.z);
	}
	
	public void tick(BlockState p_51678_, ServerLevel p_51679_, BlockPos p_51680_, RandomSource p_51681_) {
		if (!p_51678_.canSurvive(p_51679_, p_51680_)) {
			p_51679_.destroyBlock(p_51680_, true);
		}
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 vector3d = state.getOffset(world, pos);
		return SHAPE_COLLISION.move(vector3d.x, vector3d.y, vector3d.z);
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
		if (blockstate.canSustainPlant(worldIn, pos.below(), Direction.UP, this) || blockstate.is(Blocks.SAND) || blockstate.is(Blocks.PACKED_MUD) || blockstate.getBlock() == this) {
			return true;
		} else return false;
	}
    
    public BlockBehaviour.OffsetType getValueOffsetType() {
		return BlockBehaviour.OffsetType.XZ;
	}
    
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(HAS_LEAVES);
	}

	@Override
	public BlockState getPlant(BlockGetter level, BlockPos pos) {
		return this.defaultBlockState();
	}

}
