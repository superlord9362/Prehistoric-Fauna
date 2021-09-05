package superlord.prehistoricfauna.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SixWayBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.init.PFBlocks;

import java.util.Random;

public class PtilophyllumBlock extends SixWayBlock {
   public PtilophyllumBlock(Block.Properties builder) {
      super(0.3125F, builder);
      this.setDefaultState(this.stateContainer.getBaseState().with(NORTH, Boolean.valueOf(false)).with(EAST, Boolean.valueOf(false)).with(SOUTH, Boolean.valueOf(false)).with(WEST, Boolean.valueOf(false)).with(UP, Boolean.valueOf(false)).with(DOWN, Boolean.valueOf(false)));
   }

   public BlockState getStateForPlacement(BlockItemUseContext context) {
      return this.makeConnections(context.getWorld(), context.getPos());
   }

   public BlockState makeConnections(IBlockReader blockReader, BlockPos pos) {
      Block block = blockReader.getBlockState(pos.down()).getBlock();
      Block block1 = blockReader.getBlockState(pos.up()).getBlock();
      Block block2 = blockReader.getBlockState(pos.north()).getBlock();
      Block block3 = blockReader.getBlockState(pos.east()).getBlock();
      Block block4 = blockReader.getBlockState(pos.south()).getBlock();
      Block block5 = blockReader.getBlockState(pos.west()).getBlock();
      return this.getDefaultState().with(DOWN, Boolean.valueOf(block == this || block == PFBlocks.PTILOPHYLLUM_BASE || block == PFBlocks.SILT || block == PFBlocks.HARDENED_SILT || block == PFBlocks.LOAM || block == PFBlocks.PACKED_LOAM || block == PFBlocks.MOSSY_DIRT || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.GRASS_BLOCK || block == Blocks.PODZOL || block == Blocks.MYCELIUM)).with(UP, Boolean.valueOf(block1 == this || block1 == PFBlocks.PTILOPHYLLUM_BASE)).with(NORTH, Boolean.valueOf(block2 == this || block2 == PFBlocks.PTILOPHYLLUM_BASE)).with(EAST, Boolean.valueOf(block3 == this || block3 == PFBlocks.PTILOPHYLLUM_BASE)).with(SOUTH, Boolean.valueOf(block4 == this || block4 == PFBlocks.PTILOPHYLLUM_BASE)).with(WEST, Boolean.valueOf(block5 == this || block5 == PFBlocks.PTILOPHYLLUM_BASE));
   }

   @SuppressWarnings("deprecation")
   public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
      if (!stateIn.isValidPosition(worldIn, currentPos)) {
         worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
         return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
      } else {
         Block block = facingState.getBlock();
         boolean flag = block == this || block == PFBlocks.PTILOPHYLLUM_BASE || facing == Direction.DOWN && block == PFBlocks.SILT || facing == Direction.DOWN && block == PFBlocks.HARDENED_SILT || facing == Direction.DOWN && block == PFBlocks.LOAM || facing == Direction.DOWN && block == PFBlocks.PACKED_LOAM || facing == Direction.DOWN && block == PFBlocks.MOSSY_DIRT || facing == Direction.DOWN && block == Blocks.GRASS_BLOCK || facing == Direction.DOWN && block == Blocks.DIRT || facing == Direction.DOWN && block == Blocks.COARSE_DIRT || facing == Direction.DOWN && block == Blocks.PODZOL || facing == Direction.DOWN && block == Blocks.MYCELIUM;
         return stateIn.with(FACING_TO_PROPERTY_MAP.get(facing), Boolean.valueOf(flag));
      }
   }

   public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
      if (!state.isValidPosition(worldIn, pos)) {
         worldIn.destroyBlock(pos, true);
      }

   }

   @SuppressWarnings("deprecation")
   public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
      BlockState blockstate = worldIn.getBlockState(pos.down());
      boolean flag = !worldIn.getBlockState(pos.up()).isAir() && !blockstate.isAir();

      for(Direction direction : Direction.Plane.HORIZONTAL) {
         BlockPos blockpos = pos.offset(direction);
         Block block = worldIn.getBlockState(blockpos).getBlock();
         if (block == this) {
            if (flag) {
               return false;
            }

            Block block1 = worldIn.getBlockState(blockpos.down()).getBlock();
            if (block1 == this || block1 == PFBlocks.SILT || block1 == PFBlocks.HARDENED_SILT || block1 == PFBlocks.LOAM || block1 == PFBlocks.PACKED_LOAM || block1 == PFBlocks.MOSSY_DIRT || block1 == Blocks.DIRT || block1 == Blocks.COARSE_DIRT || block1 == Blocks.GRASS_BLOCK || block1 == Blocks.MYCELIUM || block1 == Blocks.PODZOL) {
               return true;
            }
         }
      }

      Block block2 = blockstate.getBlock();
      return block2 == this || block2 == PFBlocks.SILT || block2 == PFBlocks.HARDENED_SILT || block2 == PFBlocks.LOAM || block2 == PFBlocks.PACKED_LOAM || block2 == PFBlocks.MOSSY_DIRT || block2 == Blocks.DIRT || block2 == Blocks.COARSE_DIRT || block2 == Blocks.GRASS_BLOCK || block2 == Blocks.PODZOL || block2 == Blocks.MYCELIUM;
   }

   protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
   }

   public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
      return false;
   }
}