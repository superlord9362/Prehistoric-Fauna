package superlord.prehistoricfauna.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public abstract class AbstractTrapBlock extends Block {
	protected static final VoxelShape COLLISION_SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
	protected static final VoxelShape OUTLINE_SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
	protected static final AxisAlignedBB PRESSURE_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.25D, 0.875D);

   protected AbstractTrapBlock(Block.Properties properties) {
      super(properties);
   }
   
   public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	   return COLLISION_SHAPE;
   }

   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
	   return OUTLINE_SHAPE;
   }

   public int tickRate(IWorldReader worldIn) {
      return 20;
   }

   public boolean canSpawnInBlock() {
      return true;
   }

   public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
      int i = this.getRedstoneStrength(state);
      if (i > 0) {
         this.updateState(worldIn, pos, state, i);
      }

   }

   public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
      if (!worldIn.isRemote) {
         int i = this.getRedstoneStrength(state);
         if (i == 0) {
            this.updateState(worldIn, pos, state, i);
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

   protected abstract void playClickOnSound(IWorld worldIn, BlockPos pos);

   protected abstract void playClickOffSound(IWorld worldIn, BlockPos pos);

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
      worldIn.notifyNeighborsOfStateChange(pos.down(), this);
   }

   protected abstract int computeRedstoneStrength(World worldIn, BlockPos pos);

   protected abstract int getRedstoneStrength(BlockState state);

   protected abstract BlockState setRedstoneStrength(BlockState state, int strength);
}