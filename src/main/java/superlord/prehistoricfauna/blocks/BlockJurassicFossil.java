package superlord.prehistoricfauna.blocks;

import superlord.prehistoricfauna.init.ModItems;
import superlord.prehistoricfauna.util.IHasModel;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockJurassicFossil extends BlockBase implements IHasModel {

    public BlockJurassicFossil(String name, Material material) {
        super(name, material);
        setHardness(3f);
        setResistance(5f);
        setSoundType(SoundType.STONE);
        setUnlocalizedName(name);
        setHarvestLevel("pickaxe", 2);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        int i = rand.nextInt(1800);
        if (i < 150) {
            return ModItems.CAMARASAURUS_SKULL;
        } else if (i < 350) {
            return ModItems.ALLOSAURUS_SKULL;
        } else if (i < 550) {
            return Items.BONE;
        } else if (i < 750) {
            return ModItems.DRYOSAURUS_SKULL;
        } else if (i < 950) {
            return ModItems.STEGOSAURUS_THAGOMIZER;
        }
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