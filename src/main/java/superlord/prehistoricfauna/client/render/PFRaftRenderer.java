package superlord.prehistoricfauna.client.render;

import java.util.Map;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;

import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.RaftModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.common.entity.PFRaft;
import superlord.prehistoricfauna.common.entity.PFRaft.PFRaftTypes;

public class PFRaftRenderer extends BoatRenderer {
	private final Map<PFRaftTypes, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

	public PFRaftRenderer(EntityRendererProvider.Context renderContext, boolean isChestBoat) {
		super(renderContext, isChestBoat);
		System.out.println("Hi");
		boatResources = Stream.of(PFRaftTypes.values()).collect(ImmutableMap.toImmutableMap((boatType) -> {
			return boatType;
		}, (boatType) -> {
			return Pair.of(
					new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entity/boat/" + boatType.getName() + ".png"),
					new RaftModel(renderContext.bakeLayer(
							new ModelLayerLocation(
									new ResourceLocation("boat/bamboo"),
									"main"
									)
							))
					);
		}));
	}

	public PFRaftRenderer(EntityRendererProvider.Context renderContext) {
		this(renderContext, false);
	}

	@Override
	public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
		PFRaft moddedBoat = (PFRaft) boat;
		return boatResources.get(moddedBoat.getPFRaftType());
	}

}
