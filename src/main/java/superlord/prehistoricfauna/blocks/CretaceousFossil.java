package superlord.prehistoricfauna.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import superlord.prehistoricfauna.Main;
import superlord.prehistoricfauna.init.ModItems;
import superlord.prehistoricfauna.tab.PFTabRegistry;
import superlord.prehistoricfauna.util.IHasModel;

public class CretaceousFossil extends BlockBase implements IHasModel {

    private int randomMeta;
    
    public CretaceousFossil(String name, Material material) {
    	super(name, material);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setSoundType(SoundType.STONE);
        this.setCreativeTab(PFTabRegistry.NORMAL);
        this.setHarvestLevel("pickaxe", 2);
        this.randomMeta = 0;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        int i = rand.nextInt(1100);
        if (i < 150) {
        this.randomMeta = 0;
        return ModItems.GALLIMIMUS_SKULL;
       } else if (i < 350) {
            this.randomMeta = 0;
            return ModItems.TRICERATOPS_HORN;
        } else if (i < 550) {
            this.randomMeta = 0;
            return Items.BONE;
        } else if (i < 750) {
            this.randomMeta = 0;
            return ModItems.TYRANNOSAURUS_TOOTH;
        } else if (i < 950) {
        	this.randomMeta = 0;
        	return ModItems.VELOCIRAPTOR_CLAW;
        }
        this.randomMeta = 0;
        return Item.getItemFromBlock(Blocks.COBBLESTONE);
    }


    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        Random rand = world instanceof World ? ((World)world).rand : RANDOM;
        int count = quantityDropped(state, fortune, rand);
        for (int i = 0; i < count; i++) {
            Item item = this.getItemDropped(state, rand, fortune);
            if (item != Items.AIR) {
                drops.add(new ItemStack(item, 1));
            }
        }
    }

	
}