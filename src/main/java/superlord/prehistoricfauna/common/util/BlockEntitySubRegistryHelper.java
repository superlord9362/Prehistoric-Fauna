package superlord.prehistoricfauna.common.util;

import java.util.function.Supplier;

import com.google.common.collect.Sets;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntitySubRegistryHelper extends AbstractSubRegistryHelper<BlockEntityType<?>> {
	public BlockEntitySubRegistryHelper(RegistryHelper parent, DeferredRegister<BlockEntityType<?>> deferredRegister) {
		super(parent, deferredRegister);
	}

	public BlockEntitySubRegistryHelper(RegistryHelper parent) {
		super(parent, DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, parent.getModId()));
	}

	public static Block[] collectBlocks(Class<?> blockClass) {
		return ForgeRegistries.BLOCKS.getValues().stream().filter(blockClass::isInstance).toArray(Block[]::new);
	}

	public <T extends BlockEntity> RegistryObject<BlockEntityType<T>> createBlockEntity(String name, BlockEntitySupplier<? extends T> blockEntity, Supplier<Block[]> validBlocks) {
		return this.deferredRegister.register(name, () -> new BlockEntityType<>(blockEntity, Sets.newHashSet(validBlocks.get()), null));
	}

	public <T extends BlockEntity> RegistryObject<BlockEntityType<T>> createBlockEntity(String name, BlockEntitySupplier<? extends T> blockEntity, Class<? extends Block> blockClass) {
		return this.deferredRegister.register(name, () -> new BlockEntityType<>(blockEntity, Sets.newHashSet(collectBlocks(blockClass)), null));
	}

}
