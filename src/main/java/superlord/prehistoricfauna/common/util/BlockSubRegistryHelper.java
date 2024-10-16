package superlord.prehistoricfauna.common.util;

import com.google.common.base.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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

	public <B extends Block> RegistryObject<B> createBlock(String name, Supplier<? extends B> supplier) {
		RegistryObject<B> block = this.deferredRegister.register(name, supplier);
		this.itemRegister.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
		return block;
	}

	public <B extends Block> RegistryObject<B> createBlock(String name, Supplier<? extends B> supplier, Item.Properties properties) {
		RegistryObject<B> block = this.deferredRegister.register(name, supplier);
		this.itemRegister.register(name, () -> new BlockItem(block.get(), properties));
		return block;
	}

	public RegistryObject<PFChestBlock> createChestBlock(String name, String materialName, Block.Properties properties) {
		String modId = this.parent.getModId();
		String chestMaterialsName = ChestManager.registerMaterials(modId, materialName, false);
		RegistryObject<PFChestBlock> block = this.deferredRegister.register(name, () -> new PFChestBlock(chestMaterialsName, properties));
		this.itemRegister.register(name, () -> new BEWLRFuelBlockItem(block.get(), new Item.Properties(), () -> () -> chestBEWLR(false), 300));
		return block;
	}

	public RegistryObject<PFChestBlock> createChestBlock(String materialName, Block.Properties properties) {
		return createChestBlock(materialName + "_chest", materialName, properties);
	}

	@SuppressWarnings("unused")
	public RegistryObject<PFTrappedChestBlock> createTrappedChestBlock(String name, String materialName, Block.Properties properties) {
		String modId = this.parent.getModId();
		RegistryObject<PFTrappedChestBlock> block = this.deferredRegister.register(name, () -> new PFTrappedChestBlock(modId + ":" + materialName + "_trapped", properties));
		String chestMaterialsName = ChestManager.registerMaterials(modId, materialName, true);
		this.itemRegister.register(name, () -> new BEWLRFuelBlockItem(block.get(), new Item.Properties(), () -> () -> chestBEWLR(true), 300));
		return block;
	}
	
	public RegistryObject<PFTrappedChestBlock> createTrappedChestBlock(String materialName, Block.Properties properties) {
		return createTrappedChestBlock(materialName + "_trapped_chest", materialName, properties);
	}

	public RegistryObject<PFTrappedChestBlock> createTrappedChestBlockNamed(String materialName, Block.Properties properties) {
		return createTrappedChestBlock("trapped_" + materialName + "_chest", materialName, properties);
	}

}
