package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.PlesiohadrosSkullEntity;

/**
 * PlesiohadrosSkull - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class PlesiohadrosSkullModel extends EntityModel<PlesiohadrosSkullEntity> {
    public ModelRenderer Head;
    public ModelRenderer Beak;
    public ModelRenderer Nose;

    public PlesiohadrosSkullModel() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.Head = new ModelRenderer(this, 56, 0);
        this.Head.setRotationPoint(0.0F, 20.0F, 1.5F);
        this.Head.addBox(-3.0F, -2.0F, -3.0F, 6.0F, 6.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Nose = new ModelRenderer(this, 48, 0);
        this.Nose.setRotationPoint(0.0F, -2.0F, -1.0F);
        this.Nose.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Beak = new ModelRenderer(this, 85, 0);
        this.Beak.setRotationPoint(0.0F, 3.0F, -3.0F);
        this.Beak.addBox(-2.0F, -3.0F, -5.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Beak.addChild(this.Nose);
        this.Head.addChild(this.Beak);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(PlesiohadrosSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
