package superlord.prehistoricfauna.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import superlord.prehistoricfauna.entity.EntityTriceratops;

/**
 * Triceratops - Undefined
 * Created using Tabula 7.0.1
 */
public class Triceratops extends EntityModel<EntityTriceratops> {
    public ModelRenderer Body;
    public ModelRenderer LeftFrontLeg;
    public ModelRenderer RightFrontLeg;
    public ModelRenderer LeftHindLeg1;
    public ModelRenderer RightHindLeg1;
    public ModelRenderer Neck;
    public ModelRenderer Tail1;
    public ModelRenderer Head1;
    public ModelRenderer Snout;
    public ModelRenderer horn1;
    public ModelRenderer horn1_1;
    public ModelRenderer Crest;
    public ModelRenderer nasalhorn;
    public ModelRenderer Beak;
    public ModelRenderer Tail2;
    public ModelRenderer shape22;
    public ModelRenderer LeftHindLeg2;
    public ModelRenderer LeftHindLeg3;
    public ModelRenderer RightHindLeg2;
    public ModelRenderer RightHindLeg3;
    
    public Triceratops() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.LeftHindLeg3 = new ModelRenderer(this, 157, 0);
        this.LeftHindLeg3.setRotationPoint(0.0F, 14.0F, 3.0F);
        this.LeftHindLeg3.addBox(-4.0F, 0.0F, -6.0F, 8, 3, 8, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 169);
        this.Snout.setRotationPoint(0.0F, 1.0F, -12.0F);
        this.Snout.addBox(-4.0F, 0.0F, -14.0F, 8, 13, 14, 0.0F);
        this.RightHindLeg3 = new ModelRenderer(this, 157, 0);
        this.RightHindLeg3.setRotationPoint(0.0F, 14.0F, 3.0F);
        this.RightHindLeg3.addBox(-4.0F, 0.0F, -6.0F, 8, 3, 8, 0.0F);
        this.RightHindLeg1 = new ModelRenderer(this, 190, 0);
        this.RightHindLeg1.setRotationPoint(-11.0F, -10.0F, 10.0F);
        this.RightHindLeg1.addBox(-4.0F, -5.0F, -8.0F, 8, 25, 19, 0.0F);
        this.Tail1 = new ModelRenderer(this, 0, 77);
        this.Tail1.setRotationPoint(0.0F, -1.0F, 19.0F);
        this.Tail1.addBox(-6.0F, -3.0F, -2.0F, 12, 13, 24, 0.0F);
        this.setRotateAngle(Tail1, -0.31869712141416456F, 0.0F, 0.0F);
        this.LeftHindLeg2 = new ModelRenderer(this, 190, 50);
        this.LeftHindLeg2.setRotationPoint(0.0F, 17.0F, 6.0F);
        this.LeftHindLeg2.addBox(-3.0F, -4.0F, -2.0F, 6, 19, 8, 0.0F);
        this.horn1_1 = new ModelRenderer(this, 60, 165);
        this.horn1_1.setRotationPoint(-4.9F, -1.0F, -12.0F);
        this.horn1_1.addBox(-1.0F, -4.0F, -20.0F, 3, 4, 25, 0.0F);
        this.setRotateAngle(horn1_1, -0.7285004297824331F, 0.18203784098300857F, 0.0F);
        this.horn1 = new ModelRenderer(this, 60, 165);
        this.horn1.setRotationPoint(4.9F, -1.0F, -12.0F);
        this.horn1.addBox(-2.0F, -4.0F, -20.0F, 3, 4, 25, 0.0F);
        this.setRotateAngle(horn1, -0.7285004297824331F, -0.18203784098300857F, 0.0F);
        this.Crest = new ModelRenderer(this, 58, 127);
        this.Crest.setRotationPoint(0.0F, 9.0F, -3.0F);
        this.Crest.addBox(-14.0F, -23.0F, -5.0F, 28, 25, 5, 0.0F);
        this.setRotateAngle(Crest, -0.5918411493512771F, 0.0F, 0.0F);
        this.shape22 = new ModelRenderer(this, 48, 77);
        this.shape22.setRotationPoint(0.0F, -3.0F, -1.0F);
        this.shape22.addBox(-3.0F, -2.0F, 0.0F, 6, 2, 22, 0.0F);
        this.RightFrontLeg = new ModelRenderer(this, 220, 75);
        this.RightFrontLeg.mirror = true;
        this.RightFrontLeg.setRotationPoint(-11.0F, -3.0F, -14.0F);
        this.RightFrontLeg.addBox(-3.0F, 0.0F, -3.0F, 6, 27, 8, 0.0F);
        this.LeftHindLeg1 = new ModelRenderer(this, 190, 0);
        this.LeftHindLeg1.setRotationPoint(11.0F, -10.0F, 10.0F);
        this.LeftHindLeg1.addBox(-4.0F, -5.0F, -8.0F, 8, 25, 19, 0.0F);
        this.Beak = new ModelRenderer(this, 0, 204);
        this.Beak.setRotationPoint(0.0F, 2.0F, -14.0F);
        this.Beak.addBox(-2.0F, 0.0F, -5.0F, 4, 12, 5, 0.0F);
        this.LeftFrontLeg = new ModelRenderer(this, 220, 75);
        this.LeftFrontLeg.setRotationPoint(11.0F, -3.0F, -14.0F);
        this.LeftFrontLeg.addBox(-3.0F, 0.0F, -3.0F, 6, 27, 8, 0.0F);
        this.Tail2 = new ModelRenderer(this, 82, 77);
        this.Tail2.setRotationPoint(0.0F, 1.0F, 19.0F);
        this.Tail2.addBox(-3.0F, -2.0F, -3.0F, 6, 8, 27, 0.0F);
        this.setRotateAngle(Tail2, 0.091106186954104F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, -14.0F, 4.0F);
        this.Body.addBox(-12.0F, -8.0F, -24.0F, 24, 31, 43, 0.0F);
        this.RightHindLeg2 = new ModelRenderer(this, 190, 50);
        this.RightHindLeg2.setRotationPoint(0.0F, 17.0F, 6.0F);
        this.RightHindLeg2.addBox(-3.0F, -4.0F, -2.0F, 6, 19, 8, 0.0F);
        this.nasalhorn = new ModelRenderer(this, 0, 0);
        this.nasalhorn.setRotationPoint(0.0F, 1.0F, -12.0F);
        this.nasalhorn.addBox(-1.0F, -5.0F, -3.0F, 2, 5, 3, 0.0F);
        this.setRotateAngle(nasalhorn, 0.6373942428283291F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 98, 0);
        this.Neck.setRotationPoint(0.0F, 1.0F, -22.0F);
        this.Neck.addBox(-5.0F, -5.0F, -16.0F, 10, 19, 19, 0.0F);
        this.Head1 = new ModelRenderer(this, 0, 130);
        this.Head1.setRotationPoint(0.0F, -3.0F, -16.0F);
        this.Head1.addBox(-6.0F, -3.0F, -12.0F, 12, 18, 12, 0.0F);
        this.setRotateAngle(Head1, 0.5009094953223726F, 0.0F, 0.0F);
        this.LeftHindLeg2.addChild(this.LeftHindLeg3);
        this.Head1.addChild(this.Snout);
        this.RightHindLeg2.addChild(this.RightHindLeg3);
        this.Body.addChild(this.Tail1);
        this.LeftHindLeg1.addChild(this.LeftHindLeg2);
        this.Head1.addChild(this.horn1_1);
        this.Head1.addChild(this.horn1);
        this.Head1.addChild(this.Crest);
        this.Tail1.addChild(this.shape22);
        this.Snout.addChild(this.Beak);
        this.Tail1.addChild(this.Tail2);
        this.RightHindLeg1.addChild(this.RightHindLeg2);
        this.Snout.addChild(this.nasalhorn);
        this.Body.addChild(this.Neck);
        this.Neck.addChild(this.Head1);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        this.RightHindLeg1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.RightFrontLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.LeftHindLeg1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.LeftFrontLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.Body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
	public void setRotationAngles(EntityTriceratops entityIn, float limbSwing, float limbSwingAmount,
			float ageInTicks, float netHeadYaw, float headPitch) {
		      this.Neck.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		      this.Neck.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		      this.RightHindLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		      this.LeftHindLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		      this.RightFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		      this.LeftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;		
	}
}
