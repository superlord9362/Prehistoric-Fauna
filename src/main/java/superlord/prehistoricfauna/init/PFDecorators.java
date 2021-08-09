package superlord.prehistoricfauna.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import superlord.prehistoricfauna.common.world.WorldGenRegistrationHelper;
import superlord.prehistoricfauna.world.decorator.AtOceanFloorWithExtra;
import superlord.prehistoricfauna.world.decorator.PtilophyllumPlacement;

public class PFDecorators {

	public static List<Placement<?>> decorators = new ArrayList<>();

	public static final Placement<AtSurfaceWithExtraConfig> OCEAN_FLOOR_COUNT_EXTRA = WorldGenRegistrationHelper.createDecorator("ocean_floor_count_extra", new AtOceanFloorWithExtra(AtSurfaceWithExtraConfig.CODEC));
	public static final Placement<NoPlacementConfig> PTILOPHYLLUM_TREE = WorldGenRegistrationHelper.createDecorator("ptilophyllum_tree", new PtilophyllumPlacement(NoPlacementConfig.CODEC));

	public static void init() {

	}

}
