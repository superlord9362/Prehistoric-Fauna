package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.HesperornithoidesEntity;
import superlord.prehistoricfauna.entity.model.Hesperornithoides;

public class HesperornithoidesRenderer extends MobRenderer<HesperornithoidesEntity, EntityModel<HesperornithoidesEntity>> {

	private static final ResourceLocation HESPERORNITHOIDES = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/hesperornithoides.png");
	private static final Hesperornithoides HESPERORNITHOIDES_MODEL = new Hesperornithoides();
	
	public HesperornithoidesRenderer() {
		super(Minecraft.getInstance().getRenderManager(), HESPERORNITHOIDES_MODEL, 0.375F);
	}
	
	protected void preRenderCallback(HesperornithoidesEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
		if(entity.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	@Override
	public ResourceLocation getEntityTexture(HesperornithoidesEntity entity) {
		return HESPERORNITHOIDES;
	}
	
}
