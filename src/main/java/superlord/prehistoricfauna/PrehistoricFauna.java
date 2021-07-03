package superlord.prehistoricfauna;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.renderer.RenderSkyboxCube;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.moddiscovery.ModFile;
import net.minecraftforge.fml.packs.ModFileResourcePack;
import net.minecraftforge.fml.packs.ResourcePackLoader;
import superlord.prehistoricfauna.common.util.RegistryHelper;
import superlord.prehistoricfauna.init.PFBlocks;
import superlord.prehistoricfauna.init.PFItems;

@Mod(PrehistoricFauna.MOD_ID)
public class PrehistoricFauna {
	
	public static final String MOD_ID = "prehistoricfauna";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);
	
	public PrehistoricFauna() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::registerCommon);
		bus.addListener(this::doClientStuff);
		bus.addListener(this::setup);
		
		PFBlocks.REGISTER.register(bus);
		PFItems.REGISTER.register(bus);
		
	}
	
	private void registerCommon(FMLCommonSetupEvent event) {
		registerEntityAttributes();
	}
	
	public void setup(final FMLCommonSetupEvent event) {
		
	}
	
	private void doClientStuff(final FMLClientSetupEvent event) {
        trySetRandomPanorama();
	}
	
	private void registerEntityAttributes() {
		
	}
	
	@OnlyIn(Dist.CLIENT)
    public static void trySetRandomPanorama() {
        Optional<ModFileResourcePack> optionalResourcePack = ResourcePackLoader.getResourcePackFor(MOD_ID);
        if (optionalResourcePack.isPresent()) {
            ModFileResourcePack resourcePack = optionalResourcePack.get();
            Set<String> folders = getSubfoldersFromDirectory(resourcePack.getModFile(), "assets/" + MOD_ID + "/panoramas");
            if (folders.size() > 0) {
                String chosenPanorama = (String) folders.toArray()[new Random().nextInt(folders.size())];
                ResourceLocation panoramaLoc = new ResourceLocation(MOD_ID, "panoramas/" + chosenPanorama + "/panorama");
                ResourceLocation[] ResourceLocationsArray = new ResourceLocation[6];
                for (int i = 0; i < 6; ++i) {
                    ResourceLocationsArray[i] = new ResourceLocation(panoramaLoc.getNamespace(), panoramaLoc.getPath() + '_' + i + ".png");
                }
                ObfuscationReflectionHelper.setPrivateValue(RenderSkyboxCube.class, MainMenuScreen.PANORAMA_RESOURCES, ResourceLocationsArray, "field_209143_a");
            }
        }
    }

    private static Set<String> getSubfoldersFromDirectory(ModFile modFile, String directoryName) {
        try {
            Path root = modFile.getLocator().findPath(modFile, directoryName).toAbsolutePath();
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
    
    public static class PFMisc extends ItemGroup {
		public static final PFMisc instance = new PFMisc(ItemGroup.GROUPS.length, "prehistoric_misc_tab");

		private PFMisc(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(PFItems.PALEOPEDIA.get());
		}

	}

	public static class PFBuilding extends ItemGroup {
		public static final PFBuilding instance = new PFBuilding(ItemGroup.GROUPS.length, "prehistoric_building_tab");

		private PFBuilding(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(PFBlocks.ARAUCARIA_LOG);
		}
	}

	public static class PFFood extends ItemGroup {
		public static final PFFood instance = new PFFood(ItemGroup.GROUPS.length, "prehistoric_food_tab");

		private PFFood(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(PFItems.RAW_THESCELOSAURUS_MEAT.get());
		}
	}

	public static class PFEggs extends ItemGroup {
		public static final PFEggs instance = new PFEggs(ItemGroup.GROUPS.length, "prehistoric_eggs_tab");

		private PFEggs(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(PFItems.ALLOSAURUS_SPAWN_EGG.get());
		}
	}

	public static class PFDecoration extends ItemGroup {
		public static final PFDecoration instance = new PFDecoration(ItemGroup.GROUPS.length, "prehistoric_decoration_tab");

		private PFDecoration(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(PFBlocks.LARGE_AMMONITE_FOSSIL.asItem());
		}

	}

	public static class PFSkeleton extends ItemGroup {
		public static final PFSkeleton instance = new PFSkeleton(ItemGroup.GROUPS.length, "prehistoric_skeleton_tab");

		private PFSkeleton(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(PFItems.TYRANNOSAURUS_SKULL.get());
		}

	}

}
