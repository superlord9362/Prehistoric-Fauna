package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFItems;

public class NelumboPadBlock extends BushBlock {

	protected static final VoxelShape AABB = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 1.5D, 15.0D);

	public NelumboPadBlock(Properties p_58162_) {
		super(p_58162_);
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.WATER;
	}

	public VoxelShape getShape(BlockState p_58169_, BlockGetter p_58170_, BlockPos p_58171_, CollisionContext p_58172_) {
		return AABB;
	}

	protected boolean mayPlaceOn(BlockState p_58174_, BlockGetter p_58175_, BlockPos p_58176_) {
		FluidState fluidstate = p_58175_.getFluidState(p_58176_);
		FluidState fluidstate1 = p_58175_.getFluidState(p_58176_.above());
		return (fluidstate.getType() == Fluids.WATER || p_58174_.getBlock() instanceof IceBlock) && fluidstate1.getType() == Fluids.EMPTY;
	}

	@SuppressWarnings("deprecation")
	public void entityInside(BlockState p_58164_, Level p_58165_, BlockPos p_58166_, Entity p_58167_) {
		super.entityInside(p_58164_, p_58165_, p_58166_, p_58167_);
		if (p_58165_ instanceof ServerLevel && p_58167_ instanceof Boat) {
			p_58165_.destroyBlock(new BlockPos(p_58166_), true, p_58167_);
		}
	}

	public boolean canSurvive(BlockState p_51028_, LevelReader p_51029_, BlockPos p_51030_) {
		BlockPos blockpos = p_51030_.below();
		return p_51029_.getBlockState(blockpos).is(PFBlocks.NELUMBO_STEM.get());
	}

	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
		return new ItemStack(PFItems.NELUMBO.get().asItem());
	}

}
