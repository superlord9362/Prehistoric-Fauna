package superlord.prehistoricfauna.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.tab.PFTabRegistry;
import superlord.prehistoricfauna.util.IHasModel;

public class BlockPrehistoricPlant extends BlockBush implements IHasModel {

	public BlockPrehistoricPlant(String name, Material material) {
		super(material);
		setTranslationKey(name);
		setRegistryName(name);
        setCreativeTab(PFTabRegistry.NORMAL);
		setSoundType(SoundType.PLANT);
	}
	
	public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XYZ;
    }
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	

}
