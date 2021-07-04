package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.StegosaurusSkullEntity;

/**
 * StegosaurusSkull - Crimes
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class StegosaurusSkull extends EntityModel<StegosaurusSkullEntity> {
    public ModelRenderer Head1;
    public ModelRenderer Snout1;

    public StegosaurusSkull() {
        this.textureWidth = 80;
        this.textureHeight = 60;
        this.Snout1 = new ModelRenderer(this, 5, 3);
        this.Snout1.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.Snout1.addBox(-2.0F, -3.0F, -6.0F, 4.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Head1 = new ModelRenderer(this, 0, 19);
        this.Head1.setRotationPoint(0.0F, 20.0F, 4.0F);
        this.Head1.addBox(-3.5F, -3.0F, -6.0F, 7.0F, 7.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Head1.addChild(this.Snout1);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(StegosaurusSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
