package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.init.PFBlocks;

public class AncientPlantBlock extends BushBlock implements BonemealableBlock, net.minecraftforge.common.IForgeShearable {
	protected static final float AABB_OFFSET = 6.0F;
	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

	public AncientPlantBlock(BlockBehaviour.Properties p_57318_) {
		super(p_57318_);
	}

	public VoxelShape getShape(BlockState p_57336_, BlockGetter p_57337_, BlockPos p_57338_, CollisionContext p_57339_) {
		return SHAPE;
	}

	public boolean isValidBonemealTarget(LevelReader p_57325_, BlockPos p_57326_, BlockState p_57327_, boolean p_57328_) {
		return true;
	}

	public boolean isBonemealSuccess(Level p_57330_, RandomSource p_57331_, BlockPos p_57332_, BlockState p_57333_) {
		return true;
	}
	
	public boolean isSoilBlock(LevelReader world, BlockPos pos) {
		return (world.getBlockState(pos).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(pos).getBlock() == PFBlocks.PACKED_LOAM.get() || world.getBlockState(pos).getBlock() == PFBlocks.SILT.get() || world.getBlockState(pos).getBlock() == Blocks.SAND || world.getBlockState(pos).getBlock() == Blocks.GRAVEL || world.getBlockState(pos).getBlock() == Blocks.CLAY || world.getBlockState(pos).getBlock() == Blocks.DIRT || world.getBlockState(pos).getBlock() == PFBlocks.MOSSY_DIRT.get() || world.getBlockState(pos).getBlock() == Blocks.PODZOL || world.getBlockState(pos).getBlock() == PFBlocks.HARDENED_SILT.get() || world.getBlockState(pos).getBlock() == PFBlocks.LOAM.get() || world.getBlockState(pos).getBlock() == Blocks.RED_SAND || world.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK);
	}

	public boolean canSurvive(BlockState p_51028_, LevelReader p_51029_, BlockPos p_51030_) {
		BlockPos blockpos = p_51030_.below();
		if (p_51028_.getBlock() == PFBlocks.EPHEDRA.get()) return isSoilBlock(p_51029_, blockpos);
		else return super.canSurvive(p_51028_, p_51029_, p_51030_);
	}

	public BlockBehaviour.OffsetType getOffsetType() {
		return BlockBehaviour.OffsetType.XYZ;
	}

	@Override
	public void performBonemeal(ServerLevel p_50893_, RandomSource p_50894_, BlockPos p_50895_, BlockState p_50896_) {
	      popResource(p_50893_, p_50895_, new ItemStack(this));
	}
}
