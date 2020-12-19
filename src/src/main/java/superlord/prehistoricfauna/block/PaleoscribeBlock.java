package superlord.prehistoricfauna.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.tile.TileEntityPaleoscribe;

import java.util.Random;

public class PaleoscribeBlock extends ContainerBlock {
	
	public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	protected static final VoxelShape AABB = Block.makeCuboidShape(4, 0, 4, 12, 19, 12);
	
	public PaleoscribeBlock() {
		super(Properties.create(Material.WOOD).notSolid().variableOpacity().hardnessAndResistance(2, 5).sound(SoundType.WOOD));
		this.setDefaultState(this.getStateContainer().getBaseState().with(FACING, Direction.NORTH));
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		return AABB;
	}
	
	public VoxelShape getCollisionShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		return AABB;
	}
	
	@SuppressWarnings("deprecation")
	public void onReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
		TileEntity tileentity = world.getTileEntity(pos);
		
		if(tileentity instanceof TileEntityPaleoscribe) {
			InventoryHelper.dropInventoryItems(world, pos, (TileEntityPaleoscribe) tileentity);
			world.updateComparatorOutputLevel(pos, this);
		}
		super.onReplaced(state, world, pos, newState, isMoving);
	}
	
	@SuppressWarnings("unused")
	public boolean canPlaceBlockAt(World world, BlockPos pos) {
		BlockState blockstate = world.getBlockState(pos.down());
		Block block = blockstate.getBlock();
		return blockstate.isSolidSide(world, pos, Direction.UP);
	}
	
	@Deprecated
	public void neighborChanged(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		
	}
	
	public void updateTick(World world, BlockPos pos, BlockState state, Random rand) {
		this.checkFall(world, pos);
	}
	
	private boolean checkFall(World world, BlockPos pos) {
		if (!this.canPlaceBlockAt(world, pos)) {
			world.destroyBlock(pos, true);
			return false;
		} else {
			return true;
		}
	}
	
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	public void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
	
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}
	
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!player.isCrouching()) {
			if(world.isRemote) {
				PrehistoricFauna.PROXY.setReferencedTE(world.getTileEntity(pos));
			} else {
				INamedContainerProvider inamedcontainerprovider = this.getContainer(state, world, pos);
				if (inamedcontainerprovider != null) {
					player.openContainer(inamedcontainerprovider);
				}
			}
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.FAIL;
	}
	
	@Override
	public TileEntity createNewTileEntity(IBlockReader world) {
		return new TileEntityPaleoscribe();
	}

}
