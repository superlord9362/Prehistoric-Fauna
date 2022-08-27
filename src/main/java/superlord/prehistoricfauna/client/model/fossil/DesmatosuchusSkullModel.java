package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.DesmatosuchusSkullEntity;

/**
 * DesmatosuchusSkull - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class DesmatosuchusSkullModel extends EntityModel<DesmatosuchusSkullEntity> {
    public ModelRenderer Head;
    public ModelRenderer Nose;
    public ModelRenderer Head_1;
    public ModelRenderer part8;

    public DesmatosuchusSkullModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Nose = new ModelRenderer(this, 14, 0);
        this.Nose.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.Nose.addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.part8 = new ModelRenderer(this, 40, 0);
        this.part8.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.part8.addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(part8, 0.0F, 0.001745329278001762F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 21.0F, 3.0F);
        this.Head.addBox(-2.0F, -1.0F, -3.0F, 4.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Head_1 = new ModelRenderer(this, 26, 0);
        this.Head_1.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Head_1.addBox(-2.0F, 0.0F, -3.0F, 4.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Head.addChild(this.Nose);
        this.Head_1.addChild(this.part8);
        this.Head.addChild(this.Head_1);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(DesmatosuchusSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
