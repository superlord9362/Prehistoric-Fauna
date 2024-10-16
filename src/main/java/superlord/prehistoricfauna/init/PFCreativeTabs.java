package superlord.prehistoricfauna.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import superlord.prehistoricfauna.PrehistoricFauna;

public class PFCreativeTabs {

	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PrehistoricFauna.MOD_ID);

	public static final RegistryObject<CreativeModeTab> BUILDING = REGISTRY.register("prehistoric_building_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(PFBlocks.ARAUCARIA_LOG.get().asItem()))
			.title(Component.translatable("itemGroup.prehistoric_building_tab"))
			.displayItems((pParameters, pOutput) -> {
				for (var block: PFItems.BUILDING_REGISTER.getEntries()) {
					pOutput.accept(block.get());
				}
			}).build());
	
	public static final RegistryObject<CreativeModeTab> DECORATION = REGISTRY.register("prehistoric_decoration_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(PFBlocks.LARGE_AMMONITE_FOSSIL.get().asItem()))
			.title(Component.translatable("itemGroup.prehistoric_decoration_tab"))
			.displayItems((pParameters, pOutput) -> {
				for (var block: PFItems.DECORATION_REGISTER.getEntries()) {
					pOutput.accept(block.get());
				}
			}).build());
	
	public static final RegistryObject<CreativeModeTab> SPAWN_EGGS = REGISTRY.register("prehistoric_eggs_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(PFItems.TYRANNOSAURUS_SPAWN_EGG.get()))
			.title(Component.translatable("itemGroup.prehistoric_eggs_tab"))
			.displayItems((pParameters, pOutput) -> {
				for (var block: PFItems.SPAWN_EGG_REGISTER.getEntries()) {
					pOutput.accept(block.get());
				}
			}).build());
	
	public static final RegistryObject<CreativeModeTab> SKELETON = REGISTRY.register("prehistoric_skeleton_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(PFItems.TYRANNOSAURUS_SKULL.get()))
			.title(Component.translatable("itemGroup.prehistoric_skeleton_tab"))
			.displayItems((pParameters, pOutput) -> {
				for (var block: PFItems.SKELETON_REGISTER.getEntries()) {
					pOutput.accept(block.get());
				}
			}).build());
	
	public static final RegistryObject<CreativeModeTab> MISC = REGISTRY.register("prehistoric_misc_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(PFItems.PALEOPEDIA.get()))
			.title(Component.translatable("itemGroup.prehistoric_misc_tab"))
			.displayItems((pParameters, pOutput) -> {
				for (var block: PFItems.REGISTER.getEntries()) {
					pOutput.accept(block.get());
				}
			}).build());
	
	public static final RegistryObject<CreativeModeTab> FOOD = REGISTRY.register("prehistoric_food_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(PFItems.RAW_LARGE_THEROPOD_MEAT.get()))
			.title(Component.translatable("itemGroup.prehistoric_food_tab"))
			.displayItems((pParameters, pOutput) -> {
				for (var block: PFItems.FOOD_REGISTER.getEntries()) {
					pOutput.accept(block.get());
				}
			}).build());
	
}
