package superlord.prehistoricfauna.client.render.layer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.ProtoceratopsBabyModel;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.ProtoceratopsEntity;

public class ProtoceratopsBabyEyeLayer extends LayerRenderer<ProtoceratopsEntity, EntityModel<ProtoceratopsEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/protoceratops/protoceratops_eyeglow.png"));
	private final IEntityRenderer<ProtoceratopsEntity, EntityModel<ProtoceratopsEntity>> protoceratopsRenderer;
	
	public ProtoceratopsBabyEyeLayer(IEntityRenderer<ProtoceratopsEntity, EntityModel<ProtoceratopsEntity>> protoceratopsRenderer) {
		super(protoceratopsRenderer);
		this.protoceratopsRenderer = protoceratopsRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, ProtoceratopsEntity protoceratops, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(protoceratopsRenderer.getEntityModel() instanceof ProtoceratopsBabyModel)) {
			return;
		}
		long roundTime = protoceratops.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos protoceratopsPos = protoceratops.getPosition();
		int i = protoceratops.world.getLightFor(LightType.SKY, protoceratopsPos);
		int j = protoceratops.world.getLightFor(LightType.BLOCK, protoceratopsPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (protoceratops.isAsleep() || protoceratops.ticksExisted % 50 >= 0 && protoceratops.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
