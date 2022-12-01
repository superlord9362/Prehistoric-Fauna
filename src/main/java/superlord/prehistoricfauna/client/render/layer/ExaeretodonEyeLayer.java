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
import superlord.prehistoricfauna.client.model.triassic.ischigualasto.ExaeretodonModel;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ExaeretodonEntity;

public class ExaeretodonEyeLayer extends LayerRenderer<ExaeretodonEntity, EntityModel<ExaeretodonEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/exaeretodon/exaeretodon_eyeglow.png"));
	private final IEntityRenderer<ExaeretodonEntity, EntityModel<ExaeretodonEntity>> exaeretodonRenderer;
	
	public ExaeretodonEyeLayer(IEntityRenderer<ExaeretodonEntity, EntityModel<ExaeretodonEntity>> exaeretodonRenderer) {
		super(exaeretodonRenderer);
		this.exaeretodonRenderer = exaeretodonRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, ExaeretodonEntity exaeretodon, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(exaeretodonRenderer.getEntityModel() instanceof ExaeretodonModel)) {
			return;
		}
		long roundTime = exaeretodon.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos exaeretodonPos = exaeretodon.getPosition();
		int i = exaeretodon.world.getLightFor(LightType.SKY, exaeretodonPos);
		int j = exaeretodon.world.getLightFor(LightType.BLOCK, exaeretodonPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (exaeretodon.isAsleep() || exaeretodon.ticksExisted % 50 >= 0 && exaeretodon.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
