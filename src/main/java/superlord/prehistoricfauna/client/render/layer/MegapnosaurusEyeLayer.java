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
import superlord.prehistoricfauna.client.model.jurassic.kayenta.MegapnosaurusModel;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.MegapnosaurusEntity;

public class MegapnosaurusEyeLayer extends LayerRenderer<MegapnosaurusEntity, EntityModel<MegapnosaurusEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/megapnosaurus/megapnosaurus_eyeglow.png"));
	private final IEntityRenderer<MegapnosaurusEntity, EntityModel<MegapnosaurusEntity>> megapnosaurusRenderer;
	
	public MegapnosaurusEyeLayer(IEntityRenderer<MegapnosaurusEntity, EntityModel<MegapnosaurusEntity>> megapnosaurusRenderer) {
		super(megapnosaurusRenderer);
		this.megapnosaurusRenderer = megapnosaurusRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, MegapnosaurusEntity megapnosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(megapnosaurusRenderer.getEntityModel() instanceof MegapnosaurusModel)) {
			return;
		}
		long roundTime = megapnosaurus.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos megapnosaurusPos = megapnosaurus.getPosition();
		int i = megapnosaurus.world.getLightFor(LightType.SKY, megapnosaurusPos);
		int j = megapnosaurus.world.getLightFor(LightType.BLOCK, megapnosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (megapnosaurus.isAsleep() || megapnosaurus.ticksExisted % 50 >= 0 && megapnosaurus.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
