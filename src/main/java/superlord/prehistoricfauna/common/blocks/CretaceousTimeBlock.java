package superlord.prehistoricfauna.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import superlord.prehistoricfauna.init.PFBlocks;

public class CretaceousTimeBlock extends Block {

	private static final VoxelShape AABB = Block.box(4, 4, 4, 12, 12, 12);

	public CretaceousTimeBlock() {
		super(Properties.of(Material.METAL).sound(SoundType.METAL).noOcclusion().dynamicShape().strength(2.0F, 1000.0F));
	}

	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return AABB;
	}

	public boolean isOpaqueCube(BlockState state) {
		return false;
	}

	public boolean isFullCube(BlockState state) {
		return false;
	}

    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean flag) {
		if (oldState.getBlock() != state.getBlock()) {
			if (!PFBlocks.CRETACEOUS_PORTAL.get().tryToCreatePortal(world, pos)) {
				world.removeBlock(pos, false);
			}
		}
	}
}
