package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.init.PFBlocks;

public class NeocalamitesTopBlock extends Block {
	
	protected static final VoxelShape SHAPE_NORMAL = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
	protected static final VoxelShape SHAPE_COLLISION = Block.box(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);
	public static final IntegerProperty PROPERTY_NEOCALAMITES_LEAVES = IntegerProperty.create("leaves", 0, 2);
	public static final IntegerProperty PROPERTY_STAGE = IntegerProperty.create("stage", 0, 2);

	public NeocalamitesTopBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(PROPERTY_NEOCALAMITES_LEAVES, 0).setValue(PROPERTY_STAGE, Integer.valueOf(0)));
	}
	
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (!this.canSurvive(worldIn, currentPos)) {
			worldIn.scheduleTick(currentPos, this, 1);
		}
		return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

    public boolean canSurvive(LevelReader worldIn, BlockPos pos) {
		BlockState blockstate = worldIn.getBlockState(pos.below());
		if (blockstate.getBlock() == this || blockstate.getBlock() == PFBlocks.NEOCALAMITES.get()) {
			return true;
		} else return false;
	}
	
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		VoxelShape voxelShape = SHAPE_NORMAL;
		Vec3 vector3d = state.getOffset(world, pos);
		return voxelShape.move(vector3d.x, vector3d.y, vector3d.z);
	}
	
	public void tick(BlockState state, ServerLevel world, BlockPos pos, Random rand) {
		if (!this.canSurvive(world, pos)) {
			world.destroyBlock(pos, true);
		}
	}

	public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 vector3d = state.getOffset(world, pos);
		return SHAPE_COLLISION.move(vector3d.x, vector3d.y, vector3d.z);
	}
	
	public BlockBehaviour.OffsetType getValueOffsetType() {
		return BlockBehaviour.OffsetType.XZ;
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(PROPERTY_NEOCALAMITES_LEAVES, PROPERTY_STAGE);
	}
	
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
		return new ItemStack(PFBlocks.NEOCALAMITES.get().asItem());
	}
	
	
}
