package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.IschigualastiaSkullEntity;

/**
 * Diictodont - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class IschigualastiaSkull extends EntityModel<IschigualastiaSkullEntity> {
    public ModelRenderer Neck;
    public ModelRenderer Face;

    public IschigualastiaSkull() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.Neck = new ModelRenderer(this, 0, 64);
        this.Neck.setRotationPoint(0.0F, 16.0F, 8.0F);
        this.Neck.addBox(-6.0F, -6.0F, -13.0F, 12.0F, 14.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.Face = new ModelRenderer(this, 0, 99);
        this.Face.setRotationPoint(0.0F, 2.0F, -13.0F);
        this.Face.addBox(-4.5F, -6.0F, -8.0F, 9.0F, 12.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Neck.addChild(this.Face);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Neck).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(IschigualastiaSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
