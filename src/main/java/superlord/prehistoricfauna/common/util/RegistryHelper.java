package superlord.prehistoricfauna.common.util;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;
import com.mojang.datafixers.util.Pair;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.prehistoricfauna.compat.ChestItemRenderer;
import superlord.prehistoricfauna.compat.FuelBlockItem;
import superlord.prehistoricfauna.compat.PFChestBlock;
import superlord.prehistoricfauna.compat.PFChestTileEntity;
import superlord.prehistoricfauna.compat.PFTrappedChestBlock;
import superlord.prehistoricfauna.compat.PFTrappedChestTileEntity;

public class RegistryHelper {
	
	private final String modId;
	private final DeferredRegister<Item> itemRegister;
	private final DeferredRegister<Block> blockRegister;
	private final DeferredRegister<TileEntityType<?>> tileEntityRegister;
	
	public RegistryHelper(String modId) {
		this.modId = modId;
		this.itemRegister = DeferredRegister.create(ForgeRegistries.ITEMS, modId);
		this.blockRegister = DeferredRegister.create(ForgeRegistries.BLOCKS, modId);
		this.tileEntityRegister = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, modId);
	}
	
	public String getModId() {
		return this.modId;
	}
	
	public DeferredRegister<Item> getDeferredItemRegister() {
		return this.itemRegister;
	}
	
	public DeferredRegister<Block> getDeferredBlockRegister() {
		return this.blockRegister;
	}
	
	public DeferredRegister<TileEntityType<?>> getDeferredTileEntityRegister() {
		return this.tileEntityRegister;
	}
	
	public <B extends Block> RegistryObject<B> createCompatFuelBlock(String modId, String name, Supplier<? extends B> supplier, int burnTime, @Nullable ItemGroup group) {
		ItemGroup determinedGroup = ModList.get().isLoaded(modId) || modId == "indev" ? group : null;
		RegistryObject<B> block = this.blockRegister.register(name, supplier);
		this.itemRegister.register(name, () -> new FuelBlockItem(block.get(), burnTime, new Item.Properties().group(determinedGroup)));
		return block;
	}
	
	public <B extends Block> RegistryObject<B> createCompatBlock(String modId, String name, Supplier<? extends B> supplier, @Nullable ItemGroup group) {
		ItemGroup determinedGroup = ModList.get().isLoaded(modId) || modId == "indev" ? group : null;
		RegistryObject<B> block = this.blockRegister.register(name, supplier);
		this.itemRegister.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(determinedGroup)));
		return block;
	}
	
	public <T extends TileEntity> RegistryObject<TileEntityType<T>> createTileEntity(String name, Supplier<? extends T> tileEntity, Supplier<Block[]> validBlocks) {
		return this.tileEntityRegister.register(name, () -> new TileEntityType<>(tileEntity, Sets.newHashSet(validBlocks.get()), null));
	}
	
	@OnlyIn(Dist.CLIENT)
	private static Callable<ItemStackTileEntityRenderer> chestISTER() {
		return () -> new ChestItemRenderer<TileEntity>(PFChestTileEntity::new);
	}
	
	@OnlyIn(Dist.CLIENT)
	private static Callable<ItemStackTileEntityRenderer> trappedChestISTER() {
		return () -> new ChestItemRenderer<TileEntity>(PFTrappedChestTileEntity::new);
	}
	
	public Pair<RegistryObject<PFChestBlock>, RegistryObject<PFTrappedChestBlock>> createCompatChestBlocks(String name, MaterialColor color) {
		ItemGroup chestGroup = ModList.get().isLoaded("quark") || modId == "indev" ? ItemGroup.DECORATIONS : null;
		ItemGroup trappedChestGroup = ModList.get().isLoaded("quark") || modId == "indev" ? ItemGroup.REDSTONE : null;
		RegistryObject<PFChestBlock> chest = this.blockRegister.register(name + "_chest", () -> new PFChestBlock(this.getModId(), name, Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.5F).sound(SoundType.WOOD)));
		RegistryObject<PFTrappedChestBlock> trappedChest = this.blockRegister.register(name + "_trapped_chest", () -> new PFTrappedChestBlock(this.getModId(), name, Block.Properties.create(Material.WOOD, color).hardnessAndResistance(2.5F).sound(SoundType.WOOD)));
		this.itemRegister.register(name + "_chest", () -> new FuelBlockItem(chest.get(), 300, new Item.Properties().group(chestGroup).setISTER(() -> chestISTER())));
		this.itemRegister.register(name + "_trapped_chest", () -> new FuelBlockItem(trappedChest.get(), 300, new Item.Properties().group(trappedChestGroup).setISTER(() -> trappedChestISTER())));
		return Pair.of(chest, trappedChest);
	}

}
