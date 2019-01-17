package com.superlord.prehistoricfauna.blocks;

import com.superlord.prehistoricfauna.Main;
import com.superlord.prehistoricfauna.init.ModItems;
import com.superlord.prehistoricfauna.util.IHasModel;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CretaceousFossil extends BlockBase implements IHasModel {

    private int randomMeta;

    public CretaceousFossil(String name, Material material) {
        super(name, material);
        setHardness(3.0F);
        setResistance(5.0F);
        setSoundType(SoundType.STONE);
        setTranslationKey(name);
        setCreativeTab(Main.tabPrehistoric);
        setHarvestLevel("pickaxe", 2);
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
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<>();
        Random random = new Random();
        int count = this.quantityDropped(state, fortune, random);
        for (int i = 0; i < count; i++) {
            Item item = this.getItemDropped(state, random, fortune);
            if (item != null) {
                drops.add(new ItemStack(item, 1, this.randomMeta));
            }
        }
        return drops;
    }
}