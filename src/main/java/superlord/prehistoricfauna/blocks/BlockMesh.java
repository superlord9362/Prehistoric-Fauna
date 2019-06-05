package superlord.prehistoricfauna.blocks;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.util.IHasModel;

public class BlockMesh extends BlockBreakable implements IHasModel {

	public BlockMesh(Material materialIn, boolean ignoreSimilarityIn, String name) {
		super(materialIn, ignoreSimilarityIn);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(Main.tabPrehistoric);

        setHardness(3f);
        setResistance(5f);
	}
	
	public boolean isFullCube(IBlockState state) {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
	
	@Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
