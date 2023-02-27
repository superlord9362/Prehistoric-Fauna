package superlord.prehistoricfauna.common.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class LiriodendritesLeavesBlock extends LeavesBlock {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_2;

	public LiriodendritesLeavesBlock(Block.Properties builder) {
		super(builder);
		this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)).setValue(DISTANCE, Integer.valueOf(1)).setValue(PERSISTENT, Boolean.valueOf(false)));
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE, DISTANCE, PERSISTENT);
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
				float f = 1.0F;
				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0)) {
					BlockState oldState = worldIn.getBlockState(pos);
					worldIn.setBlock(pos, oldState.setValue(AGE, i + 1), 2);
					net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
				}
			}
		}
	}

}