package superlord.prehistoricfauna.common.blocks;

import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import superlord.prehistoricfauna.common.entities.tile.PFSignTileEntity;

public class PFWallSignBlock extends WallSignBlock
{
	public PFWallSignBlock(Properties properties, WoodType type)
	{
		super(properties, type);
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn)
	{
		return new PFSignTileEntity();
	}
}