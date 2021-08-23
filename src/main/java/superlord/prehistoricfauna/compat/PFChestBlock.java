package superlord.prehistoricfauna.compat;

import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import superlord.prehistoricfauna.init.PFTileEntities;

public class PFChestBlock extends ChestBlock implements IChestBlock {
	public final String modid;
	public final String type;
	
	public PFChestBlock(String modid, String type, Properties props) {
		super(props, () -> PFTileEntities.CHEST.get());	
		this.modid = modid;
		this.type = type;
	}
	
	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new PFChestTileEntity();
	}

	@Override
	public String getChestName() {
		return type;
	}
	
	@Override
	public String getModid() {
		return modid;
	}

	@Override
	public boolean isTrapped() {
		return false;
	}
}