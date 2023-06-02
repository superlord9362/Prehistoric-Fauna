package superlord.prehistoricfauna.common.blocks;

import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.item.Wearable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockMaterialPredicate;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import superlord.prehistoricfauna.init.PFBlocks;

public class CarvedTuberBlock extends HorizontalDirectionalBlock implements Wearable {
	
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	   @Nullable
	   private BlockPattern snowGolemBase;
	   @Nullable
	   private BlockPattern snowGolemFull;
	   @Nullable
	   private BlockPattern ironGolemBase;
	   @Nullable
	   private BlockPattern ironGolemFull;
	   private static final Predicate<BlockState> TUBER_PREDICATE = (tuber) -> {
	      return tuber != null && (tuber.is(PFBlocks.CARVED_TUBER.get()) || tuber.is(PFBlocks.CARVED_TUBER_LIT.get()) || tuber.is(PFBlocks.CARVED_TUBER_SOUL_LIT.get()) || tuber.is(PFBlocks.CARVED_TUBER_TIME_LIT.get()));
	   };

	   public CarvedTuberBlock(BlockBehaviour.Properties properties) {
	      super(properties);
	      this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	   }

	   public void onPlace(BlockState state, Level world, BlockPos pos, BlockState placeState, boolean p_51391_) {
	      if (!placeState.is(state.getBlock())) {
	         this.trySpawnGolem(world, pos);
	      }
	   }

	   public boolean canSpawnGolem(LevelReader world, BlockPos pos) {
	      return this.getOrCreateSnowGolemBase().find(world, pos) != null || this.getOrCreateIronGolemBase().find(world, pos) != null;
	   }

	   private void trySpawnGolem(Level world, BlockPos pos) {
	      BlockPattern.BlockPatternMatch blockpattern$blockpatternmatch = this.getOrCreateSnowGolemFull().find(world, pos);
	      if (blockpattern$blockpatternmatch != null) {
	         for(int i = 0; i < this.getOrCreateSnowGolemFull().getHeight(); ++i) {
	            BlockInWorld blockinworld = blockpattern$blockpatternmatch.getBlock(0, i, 0);
	            world.setBlock(blockinworld.getPos(), Blocks.AIR.defaultBlockState(), 2);
	            world.levelEvent(2001, blockinworld.getPos(), Block.getId(blockinworld.getState()));
	         }

	         SnowGolem snowgolem = EntityType.SNOW_GOLEM.create(world);
	         BlockPos blockpos1 = blockpattern$blockpatternmatch.getBlock(0, 2, 0).getPos();
	         snowgolem.moveTo((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.05D, (double)blockpos1.getZ() + 0.5D, 0.0F, 0.0F);
	         world.addFreshEntity(snowgolem);

	         for(ServerPlayer serverplayer : world.getEntitiesOfClass(ServerPlayer.class, snowgolem.getBoundingBox().inflate(5.0D))) {
	            CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayer, snowgolem);
	         }

	         for(int l = 0; l < this.getOrCreateSnowGolemFull().getHeight(); ++l) {
	            BlockInWorld blockinworld3 = blockpattern$blockpatternmatch.getBlock(0, l, 0);
	            world.blockUpdated(blockinworld3.getPos(), Blocks.AIR);
	         }
	      } else {
	         blockpattern$blockpatternmatch = this.getOrCreateIronGolemFull().find(world, pos);
	         if (blockpattern$blockpatternmatch != null) {
	            for(int j = 0; j < this.getOrCreateIronGolemFull().getWidth(); ++j) {
	               for(int k = 0; k < this.getOrCreateIronGolemFull().getHeight(); ++k) {
	                  BlockInWorld blockinworld2 = blockpattern$blockpatternmatch.getBlock(j, k, 0);
	                  world.setBlock(blockinworld2.getPos(), Blocks.AIR.defaultBlockState(), 2);
	                  world.levelEvent(2001, blockinworld2.getPos(), Block.getId(blockinworld2.getState()));
	               }
	            }

	            BlockPos blockpos = blockpattern$blockpatternmatch.getBlock(1, 2, 0).getPos();
	            IronGolem irongolem = EntityType.IRON_GOLEM.create(world);
	            irongolem.setPlayerCreated(true);
	            irongolem.moveTo((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.05D, (double)blockpos.getZ() + 0.5D, 0.0F, 0.0F);
	            world.addFreshEntity(irongolem);

	            for(ServerPlayer serverplayer1 : world.getEntitiesOfClass(ServerPlayer.class, irongolem.getBoundingBox().inflate(5.0D))) {
	               CriteriaTriggers.SUMMONED_ENTITY.trigger(serverplayer1, irongolem);
	            }

	            for(int i1 = 0; i1 < this.getOrCreateIronGolemFull().getWidth(); ++i1) {
	               for(int j1 = 0; j1 < this.getOrCreateIronGolemFull().getHeight(); ++j1) {
	                  BlockInWorld blockinworld1 = blockpattern$blockpatternmatch.getBlock(i1, j1, 0);
	                  world.blockUpdated(blockinworld1.getPos(), Blocks.AIR);
	               }
	            }
	         }
	      }

	   }

	   public BlockState getStateForPlacement(BlockPlaceContext context) {
	      return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	   }

	   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		   builder.add(FACING);
	   }

	   private BlockPattern getOrCreateSnowGolemBase() {
	      if (this.snowGolemBase == null) {
	         this.snowGolemBase = BlockPatternBuilder.start().aisle(" ", "#", "#").where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.SNOW_BLOCK))).build();
	      }

	      return this.snowGolemBase;
	   }

	   private BlockPattern getOrCreateSnowGolemFull() {
	      if (this.snowGolemFull == null) {
	         this.snowGolemFull = BlockPatternBuilder.start().aisle("^", "#", "#").where('^', BlockInWorld.hasState(TUBER_PREDICATE)).where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.SNOW_BLOCK))).build();
	      }

	      return this.snowGolemFull;
	   }

	   private BlockPattern getOrCreateIronGolemBase() {
	      if (this.ironGolemBase == null) {
	         this.ironGolemBase = BlockPatternBuilder.start().aisle("~ ~", "###", "~#~").where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.IRON_BLOCK))).where('~', BlockInWorld.hasState(BlockMaterialPredicate.forMaterial(Material.AIR))).build();
	      }

	      return this.ironGolemBase;
	   }

	   private BlockPattern getOrCreateIronGolemFull() {
	      if (this.ironGolemFull == null) {
	         this.ironGolemFull = BlockPatternBuilder.start().aisle("~^~", "###", "~#~").where('^', BlockInWorld.hasState(TUBER_PREDICATE)).where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.IRON_BLOCK))).where('~', BlockInWorld.hasState(BlockMaterialPredicate.forMaterial(Material.AIR))).build();
	      }

	      return this.ironGolemFull;
	   }

}
