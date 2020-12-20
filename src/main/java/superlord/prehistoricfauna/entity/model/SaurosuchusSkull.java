package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.SaurosuchusSkullEntity;

/**
 * Saurosuchus - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SaurosuchusSkull extends EntityModel<SaurosuchusSkullEntity> {
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer Jaw;
    public ModelRenderer SnoutTeeth;
    public ModelRenderer JawSnout;
    public ModelRenderer JawTeeth;

    public SaurosuchusSkull() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.Jaw = new ModelRenderer(this, 75, 12);
        this.Jaw.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.Jaw.addBox(-3.5F, -2.0F, -7.0F, 7.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.JawSnout = new ModelRenderer(this, 125, 13);
        this.JawSnout.setRotationPoint(0.5F, 0.0F, -8.0F);
        this.JawSnout.addBox(-2.5F, -1.0F, -7.0F, 4.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.JawTeeth = new ModelRenderer(this, 67, 114);
        this.JawTeeth.setRotationPoint(0.0F, -1.3F, 1.0F);
        this.JawTeeth.addBox(-2.0F, -1.0F, -7.0F, 4.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 163, 0);
        this.Snout.setRotationPoint(0.5F, 0.0F, -9.0F);
        this.Snout.addBox(-2.5F, -3.0F, -7.0F, 4.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.SnoutTeeth = new ModelRenderer(this, 34, 116);
        this.SnoutTeeth.setRotationPoint(0.0F, 1.1F, 0.1F);
        this.SnoutTeeth.addBox(-2.0F, -1.0F, -7.0F, 4.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(SnoutTeeth, 0.12566370281464037F, 0.0F, -0.0F);
        this.Head = new ModelRenderer(this, 133, 0);
        this.Head.setRotationPoint(0.0F, 20.0F, 8.0F);
        this.Head.addBox(-3.5F, -4.0F, -8.0F, 7.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Head.addChild(this.Jaw);
        this.Jaw.addChild(this.JawSnout);
        this.JawSnout.addChild(this.JawTeeth);
        this.Head.addChild(this.Snout);
        this.Snout.addChild(this.SnoutTeeth);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(SaurosuchusSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
