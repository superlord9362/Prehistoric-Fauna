package superlord.prehistoricfauna.client.render.fossil;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.fossil.DesmatosuchusSkullModel;
import superlord.prehistoricfauna.common.entities.fossil.DesmatosuchusSkullEntity;

public class DesmatosuchusSkullRenderer extends MobRenderer<DesmatosuchusSkullEntity, DesmatosuchusSkullModel> {

    private static final ResourceLocation SKULL = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/skeleton/desmatosuchus_skull.png");

    public DesmatosuchusSkullRenderer(EntityRendererManager rm) {
        super(rm, new DesmatosuchusSkullModel(), 0F);
    }
    @Override
	public ResourceLocation getEntityTexture(DesmatosuchusSkullEntity entity) {
    	return SKULL;
    }
}