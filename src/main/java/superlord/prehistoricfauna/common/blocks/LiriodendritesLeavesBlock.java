package superlord.prehistoricfauna.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class LiriodendritesLeavesBlock extends LeavesBlock {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_2;

	public LiriodendritesLeavesBlock(Block.Properties builder) {
		super(builder);
		this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)).with(DISTANCE, Integer.valueOf(1)).with(PERSISTENT, Boolean.valueOf(false)));
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE, DISTANCE, PERSISTENT);
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

	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		super.tick(state, worldIn, pos, rand);
		if(!worldIn.isAreaLoaded(pos, 1)) return;
		if(worldIn.getLightSubtracted(pos, 0) >= 9) {
			int i = this.getAge(state);
			if (i < this.getMaxAge()) {
				float f = 1.0F;
				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0)) {
					BlockState oldState = worldIn.getBlockState(pos);
					worldIn.setBlockState(pos, oldState.with(AGE, i + 1));
					net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
				}
			}
		}
	}

}