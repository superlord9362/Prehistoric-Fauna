package superlord.prehistoricfauna.client.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LightLayer;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.ProtoceratopsModel;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Protoceratops;

public class ProtoceratopsEyeLayer extends RenderLayer<Protoceratops, EntityModel<Protoceratops>> {
	
	private static final RenderType TEXTURE = RenderType.eyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/protoceratops_eyeglow.png"));
	private final RenderLayerParent<Protoceratops, EntityModel<Protoceratops>> protoceratopsRenderer;
	
	public ProtoceratopsEyeLayer(RenderLayerParent<Protoceratops, EntityModel<Protoceratops>> rendererIn) {
		super(rendererIn);
		this.protoceratopsRenderer = rendererIn;
	}
	
	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Protoceratops protoceratops, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(protoceratopsRenderer.getModel() instanceof ProtoceratopsModel)) {
			return;
		}
		long roundTime = protoceratops.level.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos protoceratopsPos = protoceratops.blockPosition();
		int i = protoceratops.level.getBrightness(LightLayer.SKY, protoceratopsPos);
		int j = protoceratops.level.getBrightness(LightLayer.BLOCK, protoceratopsPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (protoceratops.isSleeping() || protoceratops.tickCount % 50 >= 0 && protoceratops.tickCount % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	        	VertexConsumer ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
