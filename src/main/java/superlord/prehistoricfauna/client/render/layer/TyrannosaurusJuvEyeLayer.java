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
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TyrannosaurusrexjuvenileModel;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TyrannosaurusEntity;

public class TyrannosaurusJuvEyeLayer extends LayerRenderer<TyrannosaurusEntity, EntityModel<TyrannosaurusEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/tyrannosaurus/tyrannosaurusrexjuv_eyeglow.png"));

	private final IEntityRenderer<TyrannosaurusEntity, EntityModel<TyrannosaurusEntity>> tyrannosaurusRenderer;
	
	public TyrannosaurusJuvEyeLayer(IEntityRenderer<TyrannosaurusEntity, EntityModel<TyrannosaurusEntity>> tyrannosaurusRenderer) {
		super(tyrannosaurusRenderer);
		this.tyrannosaurusRenderer = tyrannosaurusRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, TyrannosaurusEntity tyrannosaurus, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(tyrannosaurusRenderer.getEntityModel() instanceof TyrannosaurusrexjuvenileModel)) {
			return;
		}
		long roundTime = tyrannosaurus.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos tyrannosaurusPos = tyrannosaurus.getPosition();
		int i = tyrannosaurus.world.getLightFor(LightType.SKY, tyrannosaurusPos);
		int j = tyrannosaurus.world.getLightFor(LightType.BLOCK, tyrannosaurusPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (tyrannosaurus.isAsleep() || tyrannosaurus.ticksExisted % 50 >= 0 && tyrannosaurus.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
