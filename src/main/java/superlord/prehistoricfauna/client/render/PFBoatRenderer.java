package superlord.prehistoricfauna.client.render;

import java.util.Map;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.PFBoat;
import superlord.prehistoricfauna.common.entity.PFBoat.PFBoatTypes;

public class PFBoatRenderer extends BoatRenderer {
	private final Map<PFBoatTypes, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

	public PFBoatRenderer(EntityRendererProvider.Context renderContext, boolean isChestBoat) {
		super(renderContext, isChestBoat);
		boatResources = Stream.of(PFBoatTypes.values()).collect(ImmutableMap.toImmutableMap((boatType) -> {
			return boatType;
		}, (boatType) -> {
			return Pair.of(
					new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/boat/" + boatType.getName() + ".png"),
					new BoatModel(renderContext.bakeLayer(
							new ModelLayerLocation(
									new ResourceLocation("boat/oak"),
									"main"
									)
							))
					);
		}));
	}

	public PFBoatRenderer(EntityRendererProvider.Context renderContext) {
		this(renderContext, false);
	}

	@Override
	public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
		PFBoat moddedBoat = (PFBoat) boat;
		return boatResources.get(moddedBoat.getPFBoatType());
	}

}
