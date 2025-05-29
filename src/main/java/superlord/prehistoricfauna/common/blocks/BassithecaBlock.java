package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFItems;

public class BassithecaBlock extends BushBlock implements BonemealableBlock, net.minecraftforge.common.IForgeShearable {
	public static final BooleanProperty HAS_BERRIES = BooleanProperty.create("has_berries");
	protected static final float AABB_OFFSET = 6.0F;
	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

	public BassithecaBlock(Properties p_51021_) {
		super(p_51021_);
		this.registerDefaultState(this.stateDefinition.any().setValue(HAS_BERRIES, false));
	}
	
	public boolean isSoilBlock(LevelReader world, BlockPos pos) {
		return (world.getBlockState(pos).getBlock() == Blocks.COARSE_DIRT || world.getBlockState(pos).getBlock() == PFBlocks.PACKED_LOAM.get() || world.getBlockState(pos).getBlock() == PFBlocks.SILT.get() || world.getBlockState(pos).getBlock() == Blocks.SAND || world.getBlockState(pos).getBlock() == Blocks.GRAVEL || world.getBlockState(pos).getBlock() == Blocks.CLAY || world.getBlockState(pos).getBlock() == Blocks.DIRT || world.getBlockState(pos).getBlock() == PFBlocks.MOSSY_DIRT.get() || world.getBlockState(pos).getBlock() == Blocks.PODZOL || world.getBlockState(pos).getBlock() == PFBlocks.HARDENED_SILT.get() || world.getBlockState(pos).getBlock() == PFBlocks.LOAM.get() || world.getBlockState(pos).getBlock() == Blocks.RED_SAND || world.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK);
	}

	public boolean canSurvive(BlockState p_51028_, LevelReader p_51029_, BlockPos p_51030_) {
		BlockPos blockpos = p_51030_.below();
		return isSoilBlock(p_51029_, blockpos);
	}

	public BlockBehaviour.OffsetType getOffsetType() {
		return BlockBehaviour.OffsetType.XYZ;
	}

	public VoxelShape getShape(BlockState p_57336_, BlockGetter p_57337_, BlockPos p_57338_, CollisionContext p_57339_) {
		return SHAPE;
	}

	public boolean isValidBonemealTarget(LevelReader p_57325_, BlockPos p_57326_, BlockState p_57327_, boolean p_57328_) {
		return !p_57327_.getValue(HAS_BERRIES);
	}

	public boolean isBonemealSuccess(Level p_57330_, RandomSource p_57331_, BlockPos p_57332_, BlockState p_57333_) {
		return true;
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(HAS_BERRIES);
	}
	
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {
		if (random.nextInt(3) == 2) {
			worldIn.setBlock(pos, state.setValue(HAS_BERRIES, true), 2);
		}
	}
	
	@SuppressWarnings("deprecation")
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		Random random = new Random();
		if (state.getValue(HAS_BERRIES)) {
			popResource(worldIn, pos, new ItemStack(PFItems.BASSITHECA_BERRIES.get(), random.nextInt(3) + 1));
			worldIn.playSound((Player)null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + worldIn.random.nextFloat() * 0.4F);
			worldIn.setBlock(pos, state.setValue(HAS_BERRIES, false), 2);
			return InteractionResult.sidedSuccess(worldIn.isClientSide);
		} else {
			return super.use(state, worldIn, pos, player, handIn, hit);
		}
	}
	
	@Override
	public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		if (random.nextInt(3) == 2) {
			level.setBlock(pos, state.setValue(HAS_BERRIES, true), 2);
		}
	}

}
