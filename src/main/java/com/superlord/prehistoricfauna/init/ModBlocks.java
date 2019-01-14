package com.superlord.prehistoricfauna.init;

import java.util.ArrayList;
import java.util.List;

import com.superlord.prehistoricfauna.blocks.BlockBase;
import com.superlord.prehistoricfauna.blocks.CretaceousFossil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();

	public static final Block CRETACEOUS_FOSSIL = new CretaceousFossil("cretaceous_fossil", Material.ROCK);
	public static final Block DNA_EXTRACTOR = new BlockBase("dna_extractor", Material.IRON);
	
}
