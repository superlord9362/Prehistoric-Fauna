package superlord.prehistoricfauna.client.render.fossil;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.ProtoceratopsSkullModel;
import superlord.prehistoricfauna.common.entities.fossil.ProtoceratopsSkullEntity;

public class ProtoceratopsSkullRenderer extends MobRenderer<ProtoceratopsSkullEntity, ProtoceratopsSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/protoceratops_skeleton.png");

    public ProtoceratopsSkullRenderer(EntityRendererManager rm) {
        super(rm, new ProtoceratopsSkullModel(), 0F);
    }
    @Override
	public ResourceLocation getEntityTexture(ProtoceratopsSkullEntity entity) {
    	return SKULL;
    }
}