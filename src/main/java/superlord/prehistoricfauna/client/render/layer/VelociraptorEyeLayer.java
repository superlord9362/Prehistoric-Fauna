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
import superlord.prehistoricfauna.client.model.cretaceous.djadochta.VelociraptorModel;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.VelociraptorEntity;

public class VelociraptorEyeLayer extends LayerRenderer<VelociraptorEntity, EntityModel<VelociraptorEntity>> {
	
	private static final RenderType TEXTURE = RenderType.getEyes(new ResourceLocation(PrehistoricFauna.MOD_ID, "textures/entities/velociraptor/velociraptor_eyeglow.png"));
	private final IEntityRenderer<VelociraptorEntity, EntityModel<VelociraptorEntity>> velociraptorRenderer;
	
	public VelociraptorEyeLayer(IEntityRenderer<VelociraptorEntity, EntityModel<VelociraptorEntity>> velociraptorRenderer) {
		super(velociraptorRenderer);
		this.velociraptorRenderer = velociraptorRenderer;
	}
	
	@Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, VelociraptorEntity velociraptor, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(velociraptorRenderer.getEntityModel() instanceof VelociraptorModel)) {
			return;
		}
		long roundTime = velociraptor.world.getDayTime() % 24000;
		boolean night = roundTime >= 13000 && roundTime <= 22000;
		BlockPos velociraptorPos = velociraptor.getPosition();
		int i = velociraptor.world.getLightFor(LightType.SKY, velociraptorPos);
		int j = velociraptor.world.getLightFor(LightType.BLOCK, velociraptorPos);
		int brightness;
		if (night) {
			brightness = j;
		} else {
			brightness = Math.max(i, j);
		}
		if (brightness < 7) {
			RenderType tex = null;
			if (velociraptor.isAsleep() || velociraptor.ticksExisted % 50 >= 0 && velociraptor.ticksExisted % 50 <= 5) {
				tex = null;
			} else tex = TEXTURE;
	        if(tex != null){
	            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(tex);
	            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	        }
		}
	}
	
}
