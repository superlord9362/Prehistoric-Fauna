package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.pathfinder.PathComputationType;
import superlord.prehistoricfauna.init.PFBlocks;

public class PtilophyllumBlock extends PipeBlock {
   public PtilophyllumBlock(Block.Properties builder) {
      super(0.3125F, builder);
      this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, Boolean.valueOf(false)).setValue(EAST, Boolean.valueOf(false)).setValue(SOUTH, Boolean.valueOf(false)).setValue(WEST, Boolean.valueOf(false)).setValue(UP, Boolean.valueOf(false)).setValue(DOWN, Boolean.valueOf(false)));
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      return this.getStateForPlacement(context.getLevel(), context.getClickedPos());
   }

   public BlockState getStateForPlacement(BlockGetter blockReader, BlockPos pos) {
      Block block = blockReader.getBlockState(pos.below()).getBlock();
      Block block1 = blockReader.getBlockState(pos.above()).getBlock();
      Block block2 = blockReader.getBlockState(pos.north()).getBlock();
      Block block3 = blockReader.getBlockState(pos.east()).getBlock();
      Block block4 = blockReader.getBlockState(pos.south()).getBlock();
      Block block5 = blockReader.getBlockState(pos.west()).getBlock();
      return this.defaultBlockState().setValue(DOWN, Boolean.valueOf(block == this || block == PFBlocks.PTILOPHYLLUM_BASE.get() || block == PFBlocks.SILT.get() || block == PFBlocks.HARDENED_SILT.get() || block == PFBlocks.LOAM.get() || block == PFBlocks.PACKED_LOAM.get() || block == PFBlocks.MOSSY_DIRT.get() || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.GRASS_BLOCK || block == Blocks.PODZOL || block == Blocks.MYCELIUM)).setValue(UP, Boolean.valueOf(block1 == this || block1 == PFBlocks.PTILOPHYLLUM_BASE.get())).setValue(NORTH, Boolean.valueOf(block2 == this || block2 == PFBlocks.PTILOPHYLLUM_BASE.get())).setValue(EAST, Boolean.valueOf(block3 == this || block3 == PFBlocks.PTILOPHYLLUM_BASE.get())).setValue(SOUTH, Boolean.valueOf(block4 == this || block4 == PFBlocks.PTILOPHYLLUM_BASE.get())).setValue(WEST, Boolean.valueOf(block5 == this || block5 == PFBlocks.PTILOPHYLLUM_BASE.get()));
   }

   @SuppressWarnings("deprecation")
   public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
      if (!stateIn.canSurvive(worldIn, currentPos)) {
         worldIn.scheduleTick(currentPos, this, 1);
         return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
      } else {
         Block block = facingState.getBlock();
         boolean flag = block == this || block == PFBlocks.PTILOPHYLLUM_BASE.get() || facing == Direction.DOWN && block == PFBlocks.SILT.get() || facing == Direction.DOWN && block == PFBlocks.HARDENED_SILT.get() || facing == Direction.DOWN && block == PFBlocks.LOAM.get() || facing == Direction.DOWN && block == PFBlocks.PACKED_LOAM.get() || facing == Direction.DOWN && block == PFBlocks.MOSSY_DIRT.get() || facing == Direction.DOWN && block == Blocks.GRASS_BLOCK || facing == Direction.DOWN && block == Blocks.DIRT || facing == Direction.DOWN && block == Blocks.COARSE_DIRT || facing == Direction.DOWN && block == Blocks.PODZOL || facing == Direction.DOWN && block == Blocks.MYCELIUM;
         return stateIn.setValue(PROPERTY_BY_DIRECTION.get(facing), Boolean.valueOf(flag));
      }
   }

   public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
      if (!state.canSurvive(worldIn, pos)) {
         worldIn.destroyBlock(pos, true);
      }

   }

   public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
      BlockState blockstate = worldIn.getBlockState(pos.below());
      boolean flag = !worldIn.getBlockState(pos.above()).isAir() && !blockstate.isAir();

      for(Direction direction : Direction.Plane.HORIZONTAL) {
         BlockPos blockpos = pos.relative(direction);
         Block block = worldIn.getBlockState(blockpos).getBlock();
         if (block == this) {
            if (flag) {
               return false;
            }

            Block block1 = worldIn.getBlockState(blockpos.below()).getBlock();
            if (block1 == this || block1 == PFBlocks.SILT.get() || block1 == PFBlocks.HARDENED_SILT.get() || block1 == PFBlocks.LOAM.get() || block1 == PFBlocks.PACKED_LOAM.get() || block1 == PFBlocks.MOSSY_DIRT.get() || block1 == Blocks.DIRT || block1 == Blocks.COARSE_DIRT || block1 == Blocks.GRASS_BLOCK || block1 == Blocks.MYCELIUM || block1 == Blocks.PODZOL) {
               return true;
            }
         }
      }

      Block block2 = blockstate.getBlock();
      return block2 == this || block2 == PFBlocks.SILT.get() || block2 == PFBlocks.HARDENED_SILT.get() || block2 == PFBlocks.LOAM.get() || block2 == PFBlocks.PACKED_LOAM.get() || block2 == PFBlocks.MOSSY_DIRT.get() || block2 == Blocks.DIRT || block2 == Blocks.COARSE_DIRT || block2 == Blocks.GRASS_BLOCK || block2 == Blocks.PODZOL || block2 == Blocks.MYCELIUM;
   }

   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
      builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
   }

   public boolean allowsMovement(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
      return false;
   }
}