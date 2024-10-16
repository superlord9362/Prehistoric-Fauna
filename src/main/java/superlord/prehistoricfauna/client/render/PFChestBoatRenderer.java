package superlord.prehistoricfauna.client.render;

import java.util.Map;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;

import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ChestRaftModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.PFBoat.PFBoatTypes;
import superlord.prehistoricfauna.common.entity.PFChestBoat;

public class PFChestBoatRenderer extends BoatRenderer {
	private final Map<PFBoatTypes, Pair<ResourceLocation, ListModel<Boat>>> modChestBoatResources;

	public PFChestBoatRenderer(EntityRendererProvider.Context renderContext, boolean isChestBoot) {
		super(renderContext, isChestBoot);

		modChestBoatResources = Stream.of(PFBoatTypes.values()).collect(ImmutableMap.toImmutableMap((boatType) -> {
			return boatType;
		}, (boatType) -> {
			if (boatType == PFBoatTypes.NEOCALAMITES) {
				return Pair.of(
						new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/chest_boat/" + boatType.getName() + ".png"),
						new ChestRaftModel(renderContext.bakeLayer(
								new ModelLayerLocation(
										new ResourceLocation("chest_boat/bamboo"),
										"main"
										)
								))
						);
			} else {
				return Pair.of(
						new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/chest_boat/" + boatType.getName() + ".png"),
						new ChestBoatModel(renderContext.bakeLayer(
								new ModelLayerLocation(
										new ResourceLocation("chest_boat/oak"),
										"main"
										)
								))
						);
			}
		}));
	}

	public PFChestBoatRenderer(EntityRendererProvider.Context renderContext) {
		this(renderContext, true);
	}

	@Override
	public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
		PFChestBoat moddedBoat = (PFChestBoat) boat;
		return modChestBoatResources.get(moddedBoat.getPFChestBoatType());
	}
}
