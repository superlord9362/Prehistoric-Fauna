package superlord.prehistoricfauna.blocks;

import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.tab.PFTabRegistry;
import superlord.prehistoricfauna.util.IHasModel;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBase extends BlockContainer implements IHasModel {

    public BlockBase(String name, Material material) {
        super(material);
        setHardness(3f);
        setResistance(5f);
        setRegistryName(name);
        setTranslationKey(name);
        setCreativeTab(PFTabRegistry.NORMAL);
    }
    
    public BlockBase(String name, Material material, boolean inCreativeTab) {
        super(material);
        setHardness(3f);
        setResistance(5f);
        setRegistryName(name);
        setTranslationKey(name);
        if (inCreativeTab) setCreativeTab(PFTabRegistry.NORMAL); 
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return null;
	}
}
