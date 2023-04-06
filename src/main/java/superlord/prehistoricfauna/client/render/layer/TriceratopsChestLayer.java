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
import superlord.prehistoricfauna.PrehistoricFauna;
import superlord.prehistoricfauna.client.model.cretaceous.hellcreek.TriceratopsModel;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TriceratopsEntity;

public class TriceratopsChestLayer extends LayerRenderer<TriceratopsEntity, EntityModel<TriceratopsEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEntityCutoutNoCull(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/triceratops/triceratops_chest_layer.png"));
	private final IEntityRenderer<TriceratopsEntity, EntityModel<TriceratopsEntity>> triceratopsRenderer;
	
	public TriceratopsChestLayer(IEntityRenderer<TriceratopsEntity, EntityModel<TriceratopsEntity>> triceratopsRenderer) {
		super(triceratopsRenderer);
		this.triceratopsRenderer = triceratopsRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, TriceratopsEntity triceratops, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(triceratopsRenderer.getEntityModel() instanceof TriceratopsModel)) {
			return;
		}
		if (triceratops.hasChest()) {
			RenderType tex = null;
			tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
