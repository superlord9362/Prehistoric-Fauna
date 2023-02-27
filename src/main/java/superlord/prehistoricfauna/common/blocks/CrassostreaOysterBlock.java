package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.init.PFBlocks;

public class CrassostreaOysterBlock extends BushBlock implements BonemealableBlock, LiquidBlockContainer {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_2;
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

	public CrassostreaOysterBlock(Block.Properties builder) {
		super(builder);
		this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)));
	}

	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
	}

	protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return state.isFaceSturdy(worldIn, pos, Direction.UP) && state.getBlock() == Blocks.SAND;
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	public int getMaxAge() {
		return 2;
	}

	protected int getAge(BlockState state) {
		return state.getValue(this.getAgeProperty());
	}

	public BlockState withAge(int age) {
		return this.defaultBlockState().setValue(this.getAgeProperty(), Integer.valueOf(age));
	}

	public boolean isMaxAge(BlockState state) {
		return state.getValue(this.getAgeProperty()) >= this.getMaxAge();
	}

	@SuppressWarnings("deprecation")
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
		super.tick(state, worldIn, pos, rand);
		if(!worldIn.isAreaLoaded(pos, 1)) return;
		if(worldIn.getRawBrightness(pos, 0) >= 9) {
			int i = this.getAge(state);
			if (i < this.getMaxAge()) {
				float f = getGrowthChance(this, worldIn, pos);
				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0)) {
					worldIn.setBlock(pos, this.withAge(i + 1), 2);
					net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
				}
			}
		}
	}

	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
		return ifluidstate.is(FluidTags.WATER) && ifluidstate.getAmount() == 8 ? super.getStateForPlacement(context) : null;
	}

	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
		BlockState blockstate = super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		if (!blockstate.isAir()) {
			worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}
		return blockstate;
	}

	public void grow(Level worldIn, BlockPos pos, BlockState state) {
		int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
		int j = this.getMaxAge();
		if (i > j) {
			i = j;
		}
		worldIn.setBlock(pos, this.withAge(i), 2);
	}

	protected int getBonemealAgeIncrease(Level worldIn) {
		return Mth.nextInt(worldIn.random, 1, 2);
	}

	protected static float getGrowthChance(Block blockIn, LevelReader worldIn, BlockPos pos) {
		return 1.0f;
	}

//	@SuppressWarnings("deprecation")
//	public void onEntityCollision(BlockState state, Level world, BlockPos pos, Entity entityIn) {
//		if (entityIn instanceof DidelphodonEntity && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(world, entityIn)) {
//			world.destroyBlock(pos, false, entityIn);
//		}
//		super.onEntityCollision(state, world, pos, entityIn);
//	}

	   protected ItemLike getBaseSeedId() {
		return PFBlocks.CRASSOSTREA_OYSTER.get().asItem();
	}

	public ItemStack getItem(LevelReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(this.getBaseSeedId());
	}

	public boolean isValidBonemealTarget(BlockGetter p_52258_, BlockPos p_52259_, BlockState state, boolean p_52261_) {
		return !this.isMaxAge(state);
	}

	public boolean isBonemealSuccess(Level p_52268_, Random p_52269_, BlockPos p_52270_, BlockState p_52271_) {
		return true;
	}
	public void performBonemeal(ServerLevel worldIn, Random rand, BlockPos pos, BlockState state) {
		this.grow(worldIn, pos, state);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}

	public FluidState getFluidState(BlockState state) {
		return Fluids.WATER.getSource(false);
	}

	   public boolean canPlaceLiquid(BlockGetter p_154505_, BlockPos p_154506_, BlockState p_154507_, Fluid p_154508_) {
		return false;
	}

	@Override
	   public boolean placeLiquid(LevelAccessor p_154520_, BlockPos p_154521_, BlockState p_154522_, FluidState p_154523_) {
		return false;
	}

}
