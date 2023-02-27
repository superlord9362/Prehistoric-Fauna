package superlord.prehistoricfauna;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.renderer.CubeMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.resource.PathResourcePack;
import net.minecraftforge.resource.ResourcePackLoader;
import superlord.prehistoricfauna.client.ClientProxy;
import superlord.prehistoricfauna.common.CommonProxy;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFItems;

@Mod(PrehistoricFauna.MOD_ID)
@Mod.EventBusSubscriber(modid = PrehistoricFauna.MOD_ID)
public class PrehistoricFauna {
	
	public static final String MOD_ID = "prehistoricfauna";
	@SuppressWarnings("deprecation")
	public static CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	
	public PrehistoricFauna() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		bus.addListener(this::doClientStuff);
		
		PFBlocks.REGISTER.register(bus);
		PFItems.REGISTER.register(bus);
	}
	
	public final static CreativeModeTab PF_DECORATION = new CreativeModeTab("prehistoric_decoration_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(PFBlocks.HORSETAIL.get());
		}
	};
	
	public final static CreativeModeTab PF_BUILDING = new CreativeModeTab("prehistoric_building_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(PFBlocks.ARAUCARIA_LOG.get());
		}
	};
	
	public final static CreativeModeTab PF_MISC = new CreativeModeTab("prehistoric_misc_tab") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(PFItems.CRASSOSTREA_OYSTER.get());
		}
	};
	
	private void doClientStuff(final FMLClientSetupEvent event) {
		trySetRandomPanorama();
	}
	
	@OnlyIn(Dist.CLIENT)
	public static void trySetRandomPanorama() {
		Optional<PathResourcePack> optionalResourcePack = ResourcePackLoader.getPackFor(MOD_ID);
		if (optionalResourcePack.isPresent()) {
			PathResourcePack resourcePack = optionalResourcePack.get();
			Set<String> folders = getSubfoldersFromDirectory(resourcePack.getSource(), "assets/" + MOD_ID + "/panoramas");
			ResourceLocation panoramaLoc = new ResourceLocation(MOD_ID, "panoramas/djadochta/panorama");
			if (folders.size() > 0) {
				ResourceLocation[] ResourceLocationsArray = new ResourceLocation[6];
				for (int i = 0; i < 6; ++i) {
					ResourceLocationsArray[i] = new ResourceLocation(panoramaLoc.getNamespace(), panoramaLoc.getPath() + '_' + i + ".png");
				}
				ObfuscationReflectionHelper.setPrivateValue(CubeMap.class, TitleScreen.CUBE_MAP, ResourceLocationsArray, "images");
			}
		}
	}

	private static Set<String> getSubfoldersFromDirectory(Path modFile, String directoryName) {
		try {
			Path root = modFile.toAbsolutePath();
			return Files.walk(root, 1)
					.map(path -> root.relativize(path.toAbsolutePath()))
					.filter(path -> path.getNameCount() > 0)
					.map(p -> p.toString().replaceAll("/$", ""))
					.filter(s -> !s.isEmpty())
					.collect(Collectors.toSet());
		} catch (IOException e) {
			return Collections.emptySet();
		}
	}


}
