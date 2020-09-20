package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.HerrerasaurusEntity;
import superlord.prehistoricfauna.entity.model.Herrerasaurus;

public class HerrerasaurusRenderer extends MobRenderer<HerrerasaurusEntity, EntityModel<HerrerasaurusEntity>>{
	
	private static final ResourceLocation HERRERASAURUS = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/herrerasaurus.png");
	private static final Herrerasaurus HERRERASAURUS_MODEL = new Herrerasaurus();

	public HerrerasaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), HERRERASAURUS_MODEL, 0.625F);
	}
	
	public void render (HerrerasaurusEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		entityModel = HERRERASAURUS_MODEL;
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
	
	protected void preRenderCallBack(HerrerasaurusEntity herrerasaurus, MatrixStack matrixStackIn, float partialTickTime) {
		if (herrerasaurus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	@Override
	public ResourceLocation getEntityTexture(HerrerasaurusEntity entity) {
		return HERRERASAURUS;
	}
	
}
