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
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.AepyornithomimusModel;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.AepyornithomimusEntity;

public class AepyornithomimusEyeLayer extends LayerRenderer<AepyornithomimusEntity, EntityModel<AepyornithomimusEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/aepyornithomimus/aepyornithomimus_eyeglow.png"));
	private final IEntityRenderer<AepyornithomimusEntity, EntityModel<AepyornithomimusEntity>> aepyornithomimusRenderer;
	
	public AepyornithomimusEyeLayer(IEntityRenderer<AepyornithomimusEntity, EntityModel<AepyornithomimusEntity>> aepyornithomimusRenderer) {
		super(aepyornithomimusRenderer);
		this.aepyornithomimusRenderer = aepyornithomimusRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, AepyornithomimusEntity aepyornithomimus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(aepyornithomimusRenderer.getEntityModel() instanceof AepyornithomimusModel)) {
			return;
		}
		long roundTime = aepyornithomimus.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos aepyornithomimusPos = aepyornithomimus.getPosition();
		int i = aepyornithomimus.world.getLightFor(LightType.SKY, aepyornithomimusPos);
		int j = aepyornithomimus.world.getLightFor(LightType.BLOCK, aepyornithomimusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (aepyornithomimus.isAsleep() || aepyornithomimus.ticksExisted % 50 >= 0 && aepyornithomimus.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
