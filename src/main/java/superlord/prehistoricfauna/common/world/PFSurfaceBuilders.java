package superlord.prehistoricfauna.common.world;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import superlord.prehistoricfauna.world.surfacebuilder.DjadochtaArroyoSB;
import superlord.prehistoricfauna.world.surfacebuilder.DjadochtaDunesSB;
import superlord.prehistoricfauna.world.surfacebuilder.HellCreekSurfaceBuilder;
import superlord.prehistoricfauna.world.surfacebuilder.IschigualastoSB;
import superlord.prehistoricfauna.world.surfacebuilder.MorrisonSavannaSB;
import superlord.prehistoricfauna.world.surfacebuilder.PetrifiedForestSB;

public class PFSurfaceBuilders {
	
	public static List<SurfaceBuilder<?>> surfaceBuilders = new ArrayList<>();

    public static final SurfaceBuilder<SurfaceBuilderConfig> HELL_CREEK = WorldGenRegistrationHelper.createSurfaceBuilder("hell_creek", new HellCreekSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> DJADOCHTA_DUNES = WorldGenRegistrationHelper.createSurfaceBuilder("djadochta", new DjadochtaDunesSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> DJADOCHTA_ARROYO = WorldGenRegistrationHelper.createSurfaceBuilder("djadochta_arroyo", new DjadochtaArroyoSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> MORRISON_SAVANNA = WorldGenRegistrationHelper.createSurfaceBuilder("morrison", new MorrisonSavannaSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ISCHIGUALASTO = WorldGenRegistrationHelper.createSurfaceBuilder("ischigualasto", new IschigualastoSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> PETRIFIED_FOREST = WorldGenRegistrationHelper.createSurfaceBuilder("petrified_forest", new PetrifiedForestSB(SurfaceBuilderConfig.field_237203_a_));

    public static void init(){
    }

}
