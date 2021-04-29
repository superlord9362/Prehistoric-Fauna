package superlord.prehistoricfauna.init;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import superlord.prehistoricfauna.PrehistoricFauna;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = PrehistoricFauna.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PrehistoricPointofInterest {
	private static final List<PointOfInterestType> POINTS_OF_INTEREST = new ArrayList<>();
    //public static final PointOfInterestType BURROWS = register("burrows", getAllStates(BlockInit.DIDELPHODON_BURROW), 0, 1);

    public static PointOfInterestType register(String name, Set<BlockState> states, int maxFreeTickets, int i) {
        ResourceLocation id = new ResourceLocation(PrehistoricFauna.MODID, name);
        PointOfInterestType pointOfInterestType = PointOfInterestType.registerBlockStates(new PointOfInterestType(id.toString(), states, maxFreeTickets, i));
        pointOfInterestType.setRegistryName(id);
        POINTS_OF_INTEREST.add(pointOfInterestType);
        return pointOfInterestType;
    }

    @SuppressWarnings("unused")
	private static Set<BlockState> getAllStates(Block block) {
        return ImmutableSet.copyOf(block.getStateContainer().getValidStates());
    }

    @SubscribeEvent
    public static void registerRecipeSerializers(RegistryEvent.Register<PointOfInterestType> event) {
        for (PointOfInterestType pointOfInterest : POINTS_OF_INTEREST) {
            event.getRegistry().register(pointOfInterest);
        }
    }
}
