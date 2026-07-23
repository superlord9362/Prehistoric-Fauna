package superlord.prehistoricfauna.common.blocks;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
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

public class NilssoniaBlock extends Block implements IPlantable, BonemealableBlock {
	protected static final VoxelShape SHAPE = Block.box(7.0D, 0.0D, 7.0D, 9D, 16.0D, 9D);
	public static final BooleanProperty TOP = BooleanProperty.create("top");
	public static final BooleanProperty CAN_GROW = BooleanProperty.create("can_grow");
	protected static final int MAX_HEIGHT = 3;

	public NilssoniaBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(TOP, true).setValue(CAN_GROW, true));
	}
	
	public boolean isSoilBlock(LevelReader world, BlockPos pos) {
		return (world.getBlockState(pos).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(pos).getBlock() == PFBlocks.PACKED_LOAM.get() || world.getBlockState(pos).getBlock() == PFBlocks.SILT.get() || world.getBlockState(pos).getBlock() == Blocks.SAND || world.getBlockState(pos).getBlock() == Blocks.GRAVEL || world.getBlockState(pos).getBlock() == Blocks.CLAY || world.getBlockState(pos).getBlock() == Blocks.DIRT || world.getBlockState(pos).getBlock() == PFBlocks.MOSSY_DIRT.get() || world.getBlockState(pos).getBlock() == Blocks.PODZOL || world.getBlockState(pos).getBlock() == PFBlocks.HARDENED_SILT.get() || world.getBlockState(pos).getBlock() == PFBlocks.LOAM.get() || world.getBlockState(pos).getBlock() == Blocks.RED_SAND || world.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK);
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
		if (isSoilBlock(worldIn, pos.below()) || blockstate.getBlock() == this) {
			return true;
		} else return false;
	}
	
	public void tick(BlockState p_51678_, ServerLevel p_51679_, BlockPos p_51680_, RandomSource p_51681_) {
		if (!p_51678_.canSurvive(p_51679_, p_51680_)) {
			p_51679_.destroyBlock(p_51680_, true);
		}
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 vector3d = state.getOffset(world, pos);
		return SHAPE.move(vector3d.x, vector3d.y, vector3d.z);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		VoxelShape voxelShape = SHAPE;
		Vec3 vector3d = state.getOffset(world, pos);
		return voxelShape.move(vector3d.x, vector3d.y, vector3d.z);
	}
	
	@Override
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
		if (!isTop(state) || !canGrow(state)) return;
		int numBelow = this.getNumNilssoniaBlocksBelow(world, pos);
		if (numBelow >= MAX_HEIGHT - 1) {
			world.setBlock(pos, state.setValue(CAN_GROW, false), 2);
			return;
		}
		boolean growing = numBelow < random.nextInt(3);
		if (world.isEmptyBlock(pos.above()) && growing) {
			this.growTop(world, pos, state);
		} else if (!growing) {
			world.setBlock(pos, state.setValue(CAN_GROW, false), 2);
		}
	}
	
	public boolean canGrow(BlockState state) {
    	return state.getValue(CAN_GROW);
    }
	
	public boolean isTop(BlockState state) {
    	return state.getValue(TOP);
    }
    
    public BlockBehaviour.OffsetType getValueOffsetType() {
		return BlockBehaviour.OffsetType.XZ;
	}
    
    @Override
	public BlockState getPlant(BlockGetter world, BlockPos pos) {
		return defaultBlockState();
	}

	@Override
	public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		super.setPlacedBy(world, pos, state, placer, stack);
		BlockPos belowPos = pos.below();
		BlockState below = world.getBlockState(belowPos);
		if (below.is(this) && below.getValue(TOP)) {
			world.setBlock(belowPos, below.setValue(TOP, false), 2);
		}
	}
    
    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
		return isTop(state);
	}

	@Override
	public boolean isBonemealSuccess(Level level, RandomSource rand, BlockPos pos, BlockState state) {
		return true;
	}
	
	protected int getNumNilssoniaBlocksBelow(BlockGetter worldIn, BlockPos pos) {
		int i = 0;
		BlockPos p = pos;
		while (worldIn.getBlockState(p.below()).is(this)) {
			p = p.below();
			i++;
		}
		return i;
	}

	protected void growTop(ServerLevel world, BlockPos pos, BlockState state) {
		world.setBlock(pos, state.setValue(TOP, false), 2);
		world.setBlock(pos.above(), this.defaultBlockState(), 2);
	}
	
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(TOP, CAN_GROW);
	}
	
	@Override
	public void performBonemeal(ServerLevel world, RandomSource rand, BlockPos pos, BlockState state) {
		int numBelow = this.getNumNilssoniaBlocksBelow(world, pos);
		boolean canGrowFurther = canGrow(state) && numBelow < MAX_HEIGHT - 1 && world.isEmptyBlock(pos.above());
		if (canGrowFurther) {
			this.growTop(world, pos, state);
		} else {
			popResource(world, pos, new ItemStack(this));
		}
	}
	
}