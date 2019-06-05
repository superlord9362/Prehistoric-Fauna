package superlord.prehistoricfauna.blocks;

import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockBase extends Block implements IHasModel {

    public BlockBase(String name, Material material) {
        super(material);

        setHardness(3f);
        setResistance(5f);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(Main.tabPrehistoric);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
