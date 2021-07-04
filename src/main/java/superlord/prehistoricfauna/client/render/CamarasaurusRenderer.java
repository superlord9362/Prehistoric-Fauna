package superlord.prehistoricfauna.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.Camarasaurus;
import superlord.prehistoricfauna.common.entities.CamarasaurusEntity;

public class CamarasaurusRenderer extends MobRenderer<CamarasaurusEntity, EntityModel<CamarasaurusEntity>> {
	
	private static final ResourceLocation CAMARASAURUS = new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/camarasaurus.png");
	private static final Camarasaurus CAMARASAURUS_MODEL = new Camarasaurus();
	
	public CamarasaurusRenderer() {
		super(Minecraft.getInstance().getRenderManager(), CAMARASAURUS_MODEL, 3.125F);
	}
	
	protected void preRenderCallback(CamarasaurusEntity triceratops, MatrixStack matrixStackIn, float partialTickTime) {
		if(triceratops.isChild()) {
			matrixStackIn.scale(0.5F, 0.5F, 0.5F);
		}
	}
	
	@Override
	public ResourceLocation getEntityTexture(CamarasaurusEntity entity) {
		return CAMARASAURUS;
	}

}
