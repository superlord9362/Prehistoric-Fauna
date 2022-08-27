package superlord.prehistoricfauna.common.world;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import superlord.prehistoricfauna.world.surfacebuilder.ChinleFlatsSB;
import superlord.prehistoricfauna.world.surfacebuilder.ChinleSwampSB;
import superlord.prehistoricfauna.world.surfacebuilder.ChinleWoodedMountainsSB;
import superlord.prehistoricfauna.world.surfacebuilder.DjadochtaArroyoSB;
import superlord.prehistoricfauna.world.surfacebuilder.DjadochtaDunesSB;
import superlord.prehistoricfauna.world.surfacebuilder.HellCreekSurfaceBuilder;
import superlord.prehistoricfauna.world.surfacebuilder.IschigualastoSB;
import superlord.prehistoricfauna.world.surfacebuilder.KayentaButtesSB;
import superlord.prehistoricfauna.world.surfacebuilder.KayentaDesertSB;
import superlord.prehistoricfauna.world.surfacebuilder.KayentaDryForestSB;
import superlord.prehistoricfauna.world.surfacebuilder.MorrisonSavannaSB;
import superlord.prehistoricfauna.world.surfacebuilder.PetrifiedForestSB;

public class PFSurfaceBuilders {
	
	public static List<SurfaceBuilder<?>> surfaceBuilders = new ArrayList<>();

    public static final SurfaceBuilder<SurfaceBuilderConfig> HELL_CREEK = WorldGenRegistrationHelper.createSurfaceBuilder("hell_creek", new HellCreekSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> DJADOCHTA_DUNES = WorldGenRegistrationHelper.createSurfaceBuilder("djadochta", new DjadochtaDunesSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> DJADOCHTA_ARROYO = WorldGenRegistrationHelper.createSurfaceBuilder("djadochta_arroyo", new DjadochtaArroyoSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> MORRISON_SAVANNA = WorldGenRegistrationHelper.createSurfaceBuilder("morrison", new MorrisonSavannaSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> KAYENTA_DRY_FOREST = WorldGenRegistrationHelper.createSurfaceBuilder("kayenta_dry_forest", new KayentaDryForestSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> KAYENTA_BUTTES = WorldGenRegistrationHelper.createSurfaceBuilder("kayenta_buttes", new KayentaButtesSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> KAYENTA_DESERT = WorldGenRegistrationHelper.createSurfaceBuilder("kayenta_desert", new KayentaDesertSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> ISCHIGUALASTO = WorldGenRegistrationHelper.createSurfaceBuilder("ischigualasto", new IschigualastoSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CHINLE_SWAMP = WorldGenRegistrationHelper.createSurfaceBuilder("chinle_swamp", new ChinleSwampSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CHINLE_FLATS = WorldGenRegistrationHelper.createSurfaceBuilder("chinle_flats", new ChinleFlatsSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> CHINLE_WOODED_MOUNTAINS = WorldGenRegistrationHelper.createSurfaceBuilder("chinle_wooded_mountains", new ChinleWoodedMountainsSB(SurfaceBuilderConfig.field_237203_a_));
    public static final SurfaceBuilder<SurfaceBuilderConfig> PETRIFIED_FOREST = WorldGenRegistrationHelper.createSurfaceBuilder("petrified_forest", new PetrifiedForestSB(SurfaceBuilderConfig.field_237203_a_));
    
    public static void init(){
    }

}
