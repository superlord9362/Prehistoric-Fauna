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
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TriceratopsModel;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TriceratopsEntity;

public class TriceratopsEyeLayer extends LayerRenderer<TriceratopsEntity, EntityModel<TriceratopsEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_eyeglow.png"));
	private final IEntityRenderer<TriceratopsEntity, EntityModel<TriceratopsEntity>> triceratopsRenderer;
	
	public TriceratopsEyeLayer(IEntityRenderer<TriceratopsEntity, EntityModel<TriceratopsEntity>> triceratopsRenderer) {
		super(triceratopsRenderer);
		this.triceratopsRenderer = triceratopsRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, TriceratopsEntity triceratops, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(triceratopsRenderer.getEntityModel() instanceof TriceratopsModel)) {
			return;
		}
		long roundTime = triceratops.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos triceratopsPos = triceratops.getPosition();
		int i = triceratops.world.getLightFor(LightType.SKY, triceratopsPos);
		int j = triceratops.world.getLightFor(LightType.BLOCK, triceratopsPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (triceratops.isSleeping() || triceratops.ticksExisted % 50 >= 0 && triceratops.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
