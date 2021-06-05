package superlord.prehistoricfauna.block;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import superlord.prehistoricfauna.entity.DidelphodonEntity;
import superlord.prehistoricfauna.init.BlockInit;

import javax.annotation.Nullable;
import java.util.Random;

public class CrassostreaOysterBlock extends BushBlock implements IGrowable, ILiquidContainer {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_2;
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

	public CrassostreaOysterBlock(Block.Properties builder) {
		super(builder);
		this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)));
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE_BY_AGE[state.get(this.getAgeProperty())];
	}
	
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.isSolidSide(worldIn, pos, Direction.UP) && state.getBlock() == Blocks.SAND;
	}
	
	public IntegerProperty getAgeProperty() {
		return AGE;
	}
	
	public int getMaxAge() {
		return 2;
	}
	
	protected int getAge(BlockState state) {
		return state.get(this.getAgeProperty());
	}
	
	public BlockState withAge(int age) {
		return this.getDefaultState().with(this.getAgeProperty(), Integer.valueOf(age));
	}
	
	public boolean isMaxAge(BlockState state) {
		return state.get(this.getAgeProperty()) >= this.getMaxAge();
	}
	
	@SuppressWarnings("deprecation")
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		super.tick(state, worldIn, pos, rand);
		if(!worldIn.isAreaLoaded(pos, 1)) return;
		if(worldIn.getLightSubtracted(pos, 0) >= 9) {
			int i = this.getAge(state);
			if (i < this.getMaxAge()) {
				float f = getGrowthChance(this, worldIn, pos);
				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0)) {
					worldIn.setBlockState(pos, this.withAge(i + 1), 2);
					net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
				}
			}
		}
	}
	
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState ifluidstate = context.getWorld().getFluidState(context.getPos());
		return ifluidstate.isTagged(FluidTags.WATER) && ifluidstate.getLevel() == 8 ? super.getStateForPlacement(context) : null;
	}
	
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		BlockState blockstate = super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		if (!blockstate.isAir()) {
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}
		return blockstate;
	}
	
	public void grow(World worldIn, BlockPos pos, BlockState state) {
		int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
		int j = this.getMaxAge();
		if (i > j) {
			i = j;
		}
		worldIn.setBlockState(pos, this.withAge(i), 2);
	}
	
	protected int getBonemealAgeIncrease(World worldIn) {
		return MathHelper.nextInt(worldIn.rand, 1, 2);
	}
	
	protected static float getGrowthChance(Block blockIn, IBlockReader worldIn, BlockPos pos) {
		return 1.0f;
	}
	
	@SuppressWarnings("deprecation")
	public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof DidelphodonEntity && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(world, entityIn)) {
			world.destroyBlock(pos, false, entityIn);
		}
		super.onEntityCollision(state, world, pos, entityIn);
	}
	
	protected IItemProvider getSeedsItem() {
		return BlockInit.CRASSOSTREA_OYSTER.asItem();
	}
	
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(this.getSeedsItem());
	}
	
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return !this.isMaxAge(state);
	}
	
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}
	
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		this.grow(worldIn, pos, state);
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}
	
	public IFluidState getFluidState(BlockState state) {
		return Fluids.WATER.getStillFluidState(false);
	}
	
	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
		return false;
	}

	@Override
	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, IFluidState fluidStateIn) {
		return false;
	}
	
}
