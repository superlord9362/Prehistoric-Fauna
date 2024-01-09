package superlord.prehistoricfauna.common.util;

import javax.annotation.Nullable;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.base.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.client.util.ChestBlockEntityWithoutLevelRenderer;
import superlord.prehistoricfauna.client.util.ChestManager;
import superlord.prehistoricfauna.common.blocks.compat.BEWLRFuelBlockItem;
import superlord.prehistoricfauna.common.blocks.compat.PFChestBlock;
import superlord.prehistoricfauna.common.blocks.compat.PFTrappedChestBlock;
import superlord.prehistoricfauna.common.entity.block.compat.PFChestBlockEntity;
import superlord.prehistoricfauna.common.entity.block.compat.PFTrappedChestBlockEntity;

public class BlockSubRegistryHelper extends AbstractSubRegistryHelper<Block> {
	protected final DeferredRegister<Item> itemRegister;

	public BlockSubRegistryHelper(RegistryHelper parent) {
		this(parent, parent.getSubHelper(ForgeRegistries.ITEMS).getDeferredRegister(), DeferredRegister.create(ForgeRegistries.BLOCKS, parent.getModId()));
	}

	public BlockSubRegistryHelper(RegistryHelper parent, ISubRegistryHelper<Item> itemHelper) {
		this(parent, itemHelper.getDeferredRegister(), DeferredRegister.create(ForgeRegistries.BLOCKS, parent.getModId()));
	}

	public BlockSubRegistryHelper(RegistryHelper parent, DeferredRegister<Item> itemRegister, DeferredRegister<Block> deferredRegister) {
		super(parent, deferredRegister);
		this.itemRegister = itemRegister;
	}

	@OnlyIn(Dist.CLIENT)
	private static BEWLRBlockItem.LazyBEWLR chestBEWLR(boolean trapped) {
		return trapped ? new BEWLRBlockItem.LazyBEWLR((dispatcher, entityModelSet) -> {
			return new ChestBlockEntityWithoutLevelRenderer<>(dispatcher, entityModelSet, new PFTrappedChestBlockEntity(BlockPos.ZERO, Blocks.TRAPPED_CHEST.defaultBlockState()));
		}) : new BEWLRBlockItem.LazyBEWLR((dispatcher, entityModelSet) -> {
			return new ChestBlockEntityWithoutLevelRenderer<>(dispatcher, entityModelSet, new PFChestBlockEntity(BlockPos.ZERO, Blocks.CHEST.defaultBlockState()));
		});
	}
	
	public <B extends Block> RegistryObject<B> createCompatBlock(String modId, String name, Supplier<? extends B> supplier, @Nullable CreativeModeTab group) {
		RegistryObject<B> block = this.deferredRegister.register(name, supplier);
		this.itemRegister.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(areModsLoaded(modId) ? group : null)));
		return block;
	}
	
	public <B extends Block> RegistryObject<B> createCompatBlock(String name, Supplier<? extends B> supplier, @Nullable CreativeModeTab group, String... modIds) {
		RegistryObject<B> block = this.deferredRegister.register(name, supplier);
		this.itemRegister.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(areModsLoaded(modIds) ? group : null)));
		return block;
	}
	
	public Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> createCompatChestBlocks(String compatModId, String name, MaterialColor color) {
		boolean isModLoaded = areModsLoaded(compatModId);
		CreativeModeTab chestGroup = isModLoaded ? CreativeModeTab.TAB_DECORATIONS : null;
		CreativeModeTab trappedChestGroup = isModLoaded ? CreativeModeTab.TAB_REDSTONE : null;
		String modId = this.parent.getModId();
		String chestName = name + "_chest";
		String trappedChestName = name + "_trapped_chest";
		RegistryObject<PFChestBlock> chest = this.deferredRegister.register(chestName, () -> new PFChestBlock(modId + ":" + name, Block.Properties.of(Material.WOOD, color).strength(2.5F).sound(SoundType.WOOD)));
		RegistryObject<PFTrappedChestBlock> trappedChest = this.deferredRegister.register(trappedChestName, () -> new PFTrappedChestBlock(modId + ":" + name + "_trapped", Block.Properties.of(Material.WOOD, color).strength(2.5F).sound(SoundType.WOOD)));
		this.itemRegister.register(chestName, () -> new BEWLRFuelBlockItem(chest.get(), new Item.Properties().tab(chestGroup), () -> () -> chestBEWLR(false), 300));
		this.itemRegister.register(trappedChestName, () -> new BEWLRFuelBlockItem(trappedChest.get(), new Item.Properties().tab(trappedChestGroup), () -> () -> chestBEWLR(true), 300));
		ChestManager.putChestInfo(modId, name, false);
		ChestManager.putChestInfo(modId, name, true);
		return Pair.of(chest, trappedChest);
	}
	
	public Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> createCompatChestBlocks(String name, MaterialColor color, String... modIds) {
		boolean isInGroup = areModsLoaded(modIds);
		CreativeModeTab chestGroup = isInGroup ? CreativeModeTab.TAB_DECORATIONS : null;
		CreativeModeTab trappedChestGroup = isInGroup ? CreativeModeTab.TAB_REDSTONE : null;
		String modId = this.parent.getModId();
		String chestName = name + "_chest";
		String trappedChestName = name + "_trapped_chest";
		RegistryObject<PFChestBlock> chest = this.deferredRegister.register(chestName, () -> new PFChestBlock(modId + ":" + name, Block.Properties.of(Material.WOOD, color).strength(2.5F).sound(SoundType.WOOD)));
		RegistryObject<PFTrappedChestBlock> trappedChest = this.deferredRegister.register(trappedChestName, () -> new PFTrappedChestBlock(modId + ":" + name + "_trapped", Block.Properties.of(Material.WOOD, color).strength(2.5F).sound(SoundType.WOOD)));
		this.itemRegister.register(chestName, () -> new BEWLRFuelBlockItem(chest.get(), new Item.Properties().tab(chestGroup), () -> () -> chestBEWLR(false), 300));
		this.itemRegister.register(trappedChestName, () -> new BEWLRFuelBlockItem(trappedChest.get(), new Item.Properties().tab(trappedChestGroup), () -> () -> chestBEWLR(true), 300));
		ChestManager.putChestInfo(modId, name, false);
		ChestManager.putChestInfo(modId, name, true);
		return Pair.of(chest, trappedChest);
	}
	
}
