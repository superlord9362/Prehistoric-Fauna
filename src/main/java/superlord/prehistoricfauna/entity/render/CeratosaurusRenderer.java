package superlord.prehistoricfauna.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.entity.CeratosaurusEntity;
import superlord.prehistoricfauna.entity.model.Ceratosaurus;

public class CeratosaurusRenderer extends MobRenderer<CeratosaurusEntity, EntityModel<CeratosaurusEntity>>{
	
	private static final Ceratosaurus CERATOSAURUS_MODEL = new Ceratosaurus();
	private static final ResourceLocation CERATOSAURUS = new ResourceLocation(PrehistoricFauna.MODID, "textures/entities/ceratosaurus.png");
	
	public CeratosaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), CERATOSAURUS_MODEL, 0.875F);
	}
	
	protected void preRenderCallback(CeratosaurusEntity ceratosaurus, MatrixStack matrixStackIn, float partialTickTime) {
		if(ceratosaurus.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	public ResourceLocation getEntityTexture(CeratosaurusEntity ceratosaurus) {
		return CERATOSAURUS;
	}

}
