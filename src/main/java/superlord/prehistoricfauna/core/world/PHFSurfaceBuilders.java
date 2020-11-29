package superlord.prehistoricfauna.core.world;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import superlord.prehistoricfauna.world.feature.cretaceous.HellCreekSurfaceBuilder;
import superlord.prehistoricfauna.world.surfacebuilder.IschigualastoSB;
import superlord.prehistoricfauna.world.surfacebuilder.MorrisonSavannaSB;

import java.util.ArrayList;
import java.util.List;

import static superlord.prehistoricfauna.core.world.util.WorldGenRegistrationHelper.createSurfaceBuilder;

public class PHFSurfaceBuilders {

    public static List<SurfaceBuilder<?>> surfaceBuilders = new ArrayList<>();

    public static final SurfaceBuilder<SurfaceBuilderConfig> HELL_CREEK = createSurfaceBuilder("hell_creek", new HellCreekSurfaceBuilder(SurfaceBuilderConfig::deserialize));
    public static final SurfaceBuilder<SurfaceBuilderConfig> MORRISON_SAVANNA = createSurfaceBuilder("morrison", new MorrisonSavannaSB(SurfaceBuilderConfig::deserialize));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ISCHIGUALASTO = createSurfaceBuilder("ischigualasto", new IschigualastoSB(SurfaceBuilderConfig::deserialize));

    public static void init(){
    }
}
