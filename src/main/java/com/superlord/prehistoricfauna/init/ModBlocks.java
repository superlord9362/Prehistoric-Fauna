package com.superlord.prehistoricfauna.init;

import com.superlord.prehistoricfauna.blocks.BlockCretaceousFossil;
import com.superlord.prehistoricfauna.blocks.BlockDNAExtractor;
import com.superlord.prehistoricfauna.blocks.BlockEggIncubator;
import com.superlord.prehistoricfauna.blocks.tile.TileEntityEggIncubator;
import com.superlord.prehistoricfauna.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.superlord.prehistoricfauna.util.Reference.MOD_ID;

@Mod.EventBusSubscriber
public class ModBlocks {
    public static final Block CRETACEOUS_FOSSIL = new BlockCretaceousFossil("cretaceous_fossil", Material.ROCK);
    public static final Block DNA_EXTRACTOR = new BlockDNAExtractor("dna_extractor", Material.IRON);
    public static final Block EGG_INCUBATOR = new BlockEggIncubator("egg_incubator", Material.IRON);

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                CRETACEOUS_FOSSIL,
                DNA_EXTRACTOR,
                EGG_INCUBATOR
        );
        GameRegistry.registerTileEntity(TileEntityEggIncubator.class, new ResourceLocation(MOD_ID, "tile_egg_incubator"));
    }

    @SubscribeEvent
    public static void onItemBlockRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new ItemBlock(CRETACEOUS_FOSSIL).setRegistryName(CRETACEOUS_FOSSIL.getRegistryName()),
                new ItemBlock(DNA_EXTRACTOR).setRegistryName(DNA_EXTRACTOR.getRegistryName()),
                new ItemBlock(EGG_INCUBATOR).setRegistryName(EGG_INCUBATOR.getRegistryName())
        );
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        registerModel(CRETACEOUS_FOSSIL);
        registerModel(DNA_EXTRACTOR);
        registerModel(EGG_INCUBATOR);
    }

    private static void registerModel(Block block) {
        if (block instanceof IHasModel) {
            ((IHasModel) block).registerModels();
        }
    }
}
