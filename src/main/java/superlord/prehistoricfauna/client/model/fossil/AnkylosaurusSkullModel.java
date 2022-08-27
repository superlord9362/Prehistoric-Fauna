package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.AnkylosaurusSkullEntity;

/**
 * Ankylosaurus - Bastion
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class AnkylosaurusSkullModel extends EntityModel<AnkylosaurusSkullEntity> {
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer LeftOsteoderm;
    public ModelRenderer LeftCheekbone;
    public ModelRenderer RightOsteoderm;
    public ModelRenderer RightCheekbone;

    public AnkylosaurusSkullModel() {
        this.textureWidth = 90;
        this.textureHeight = 60;
        this.Snout = new ModelRenderer(this, 40, 30);
        this.Snout.setRotationPoint(0.0F, 1.0F, -13.0F);
        this.Snout.addBox(-4.0F, -3.0F, -2.0F, 8.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 30);
        this.Head.setRotationPoint(0.0F, 18.0F, 7.0F);
        this.Head.addBox(-6.0F, -4.0F, -13.0F, 12.0F, 10.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.RightOsteoderm = new ModelRenderer(this, 63, 6);
        this.RightOsteoderm.setRotationPoint(-3.0F, -3.0F, -2.0F);
        this.RightOsteoderm.addBox(-4.0F, -2.0F, 0.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightOsteoderm, 0.12566370281464037F, -0.25132740562928074F, -0.0F);
        this.LeftOsteoderm = new ModelRenderer(this, 41, 6);
        this.LeftOsteoderm.setRotationPoint(3.0F, -3.0F, -2.0F);
        this.LeftOsteoderm.addBox(0.0F, -2.0F, 0.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftOsteoderm, 0.12566370281464037F, 0.25132740562928074F, -0.0F);
        this.LeftCheekbone = new ModelRenderer(this, 45, 21);
        this.LeftCheekbone.setRotationPoint(3.0F, 3.0F, -2.0F);
        this.LeftCheekbone.addBox(0.0F, -2.0F, 0.0F, 4.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftCheekbone, 0.0F, 0.18849556254433897F, -0.0F);
        this.RightCheekbone = new ModelRenderer(this, 63, 22);
        this.RightCheekbone.setRotationPoint(-3.0F, 3.0F, -2.0F);
        this.RightCheekbone.addBox(-4.0F, -2.0F, 0.0F, 4.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightCheekbone, 0.0F, -0.18849556254433897F, -0.0F);
        this.Head.addChild(this.Snout);
        this.Head.addChild(this.RightOsteoderm);
        this.Head.addChild(this.LeftOsteoderm);
        this.Head.addChild(this.LeftCheekbone);
        this.Head.addChild(this.RightCheekbone);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(AnkylosaurusSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
