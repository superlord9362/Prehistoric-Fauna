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
import superlord.prehistoricfauna.client.model.triassic.chinle.TypothoraxModel;
import superlord.prehistoricfauna.common.entities.triassic.chinle.TypothoraxEntity;

public class TypothoraxEyeLayer extends LayerRenderer<TypothoraxEntity, EntityModel<TypothoraxEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/typothorax/typothorax_eyeglow.png"));
	private final IEntityRenderer<TypothoraxEntity, EntityModel<TypothoraxEntity>> typothoraxRenderer;
	
	public TypothoraxEyeLayer(IEntityRenderer<TypothoraxEntity, EntityModel<TypothoraxEntity>> typothoraxRenderer) {
		super(typothoraxRenderer);
		this.typothoraxRenderer = typothoraxRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, TypothoraxEntity typothorax, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(typothoraxRenderer.getEntityModel() instanceof TypothoraxModel)) {
			return;
		}
		long roundTime = typothorax.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos typothoraxPos = typothorax.getPosition();
		int i = typothorax.world.getLightFor(LightType.SKY, typothoraxPos);
		int j = typothorax.world.getLightFor(LightType.BLOCK, typothoraxPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (typothorax.isAsleep() || typothorax.ticksExisted % 50 >= 0 && typothorax.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
