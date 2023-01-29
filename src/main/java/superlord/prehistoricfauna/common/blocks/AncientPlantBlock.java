package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AncientPlantBlock extends BushBlock implements BonemealableBlock, net.minecraftforge.common.IForgeShearable {
	protected static final float AABB_OFFSET = 6.0F;
	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

	public AncientPlantBlock(BlockBehaviour.Properties p_57318_) {
		super(p_57318_);
	}

	public VoxelShape getShape(BlockState p_57336_, BlockGetter p_57337_, BlockPos p_57338_, CollisionContext p_57339_) {
		return SHAPE;
	}

	public boolean isValidBonemealTarget(BlockGetter p_57325_, BlockPos p_57326_, BlockState p_57327_, boolean p_57328_) {
		return false;
	}

	public boolean isBonemealSuccess(Level p_57330_, Random p_57331_, BlockPos p_57332_, BlockState p_57333_) {
		return false;
	}

	public BlockBehaviour.OffsetType getOffsetType() {
		return BlockBehaviour.OffsetType.XYZ;
	}

	@Override
	public void performBonemeal(ServerLevel p_50893_, Random p_50894_, BlockPos p_50895_, BlockState p_50896_) {

	}
}
