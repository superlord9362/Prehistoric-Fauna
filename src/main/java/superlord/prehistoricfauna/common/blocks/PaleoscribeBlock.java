package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.block.PaleoscribeBlockEntity;
import superlord.prehistoricfauna.init.PFBlockEntities;

public class PaleoscribeBlock extends BaseEntityBlock {
	public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
    protected static final VoxelShape AABB = Block.box(4, 0, 4, 12, 19, 12);

    public PaleoscribeBlock() {
        super(
            Properties.of(Material.WOOD).noOcclusion().dynamicShape().strength(2, 5).sound(SoundType.WOOD)
        );

        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return AABB;
    }

    @Override
    public @NotNull BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
        return p_185499_1_.setValue(FACING, p_185499_2_.rotate(p_185499_1_.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
	@Override
    public @NotNull BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
        return p_185471_1_.rotate(p_185471_2_.getRotation(p_185471_1_.getValue(FACING)));
    }

    @Override
    public @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return AABB;
    }


    @SuppressWarnings("deprecation")
	@Override
    public void onRemove(@NotNull BlockState state, Level worldIn, @NotNull BlockPos pos, @NotNull BlockState newState, boolean isMoving) {
        BlockEntity tileentity = worldIn.getBlockEntity(pos);

        if (tileentity instanceof PaleoscribeBlockEntity) {
            Containers.dropContents(worldIn, pos, (PaleoscribeBlockEntity) tileentity);
            worldIn.updateNeighbourForOutputSignal(pos, this);
        }
        super.onRemove(state, worldIn, pos, newState, isMoving);
    }

    @SuppressWarnings("unused")
	public boolean canPlaceBlockAt(Level worldIn, BlockPos pos) {
        BlockState BlockState = worldIn.getBlockState(pos.below());
        Block block = BlockState.getBlock();
        return BlockState.isFaceSturdy(worldIn, pos, Direction.UP);
    }


    public void updateTick(Level worldIn, BlockPos pos, BlockState state, Random rand) {
        this.checkFall(worldIn, pos);
    }

    private boolean checkFall(Level worldIn, BlockPos pos) {
        if (!this.canPlaceBlockAt(worldIn, pos)) {
            worldIn.destroyBlock(pos, true);
            return false;
        } else {
            return true;
        }
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153182_, @NotNull BlockState p_153183_, @NotNull BlockEntityType<T> entityType) {
        return p_153182_.isClientSide ? createTickerHelper(entityType, PFBlockEntities.PALEOSCRIBE.get(), PaleoscribeBlockEntity::bookAnimationTick) : null;
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level worldIn, @NotNull BlockPos pos, Player player, @NotNull InteractionHand handIn, @NotNull BlockHitResult hit) {
        if (!player.isShiftKeyDown()) {
            if (worldIn.isClientSide) {
                PrehistoricFauna.PROXY.setReferencedBE(worldIn.getBlockEntity(pos));
            } else {
                MenuProvider inamedcontainerprovider = this.getMenuProvider(state, worldIn, pos);
                if (inamedcontainerprovider != null) {
                    player.openMenu(inamedcontainerprovider);
                }
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new PaleoscribeBlockEntity(pos, state);
    }

}
