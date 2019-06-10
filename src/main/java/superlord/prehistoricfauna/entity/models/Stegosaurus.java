package superlord.prehistoricfauna.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;

/**
 * Stegosaurus - superlord9362
 * Created using Tabula 5.0.0
 */
public class Stegosaurus extends ModelBase {
    public ModelRenderer Body1;
    public ModelRenderer Body2;
    public ModelRenderer Tail1;
    public ModelRenderer RBLeg1;
    public ModelRenderer LBLeg1;
    public ModelRenderer RPlates4;
    public ModelRenderer LPlates4;
    public ModelRenderer RFLeg1;
    public ModelRenderer LFLeg1;
    public ModelRenderer Neck1;
    public ModelRenderer RPlates3;
    public ModelRenderer LPlates3;
    public ModelRenderer RFLeg2;
    public ModelRenderer LFLeg2;
    public ModelRenderer Neck2;
    public ModelRenderer RPlates2;
    public ModelRenderer LPlates2;
    public ModelRenderer Head;
    public ModelRenderer RPlates1;
    public ModelRenderer LPlates1;
    public ModelRenderer Snout;
    public ModelRenderer Jaw;
    public ModelRenderer Tail2;
    public ModelRenderer RPlates5;
    public ModelRenderer LPlates5;
    public ModelRenderer Tail3;
    public ModelRenderer RPlates6;
    public ModelRenderer LPlates6;
    public ModelRenderer RThag1;
    public ModelRenderer RThag2;
    public ModelRenderer LThag1;
    public ModelRenderer LThag2;
    public ModelRenderer LPlates7;
    public ModelRenderer RPlates7;
    public ModelRenderer RBLeg2;
    public ModelRenderer RBFoot;
    public ModelRenderer LBLeg2;
    public ModelRenderer LBFoot;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public Stegosaurus() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.RFLeg2 = new ModelRenderer(this, 52, 0);
        this.RFLeg2.setRotationPoint(-1.1F, 3.0F, -0.1F);
        this.RFLeg2.addBox(-1.0F, -0.5F, -1.0F, 3, 6, 3, 0.0F);
        this.setRotateAngle(RFLeg2, -0.22759093446006054F, 0.0F, 0.0F);
        this.RPlates6 = new ModelRenderer(this, 44, 30);
        this.RPlates6.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.RPlates6.addBox(0.0F, -5.0F, 0.0F, 1, 5, 8, 0.0F);
        this.setRotateAngle(RPlates6, 0.0F, 0.0F, 0.136659280431156F);
        this.Snout = new ModelRenderer(this, 122, 0);
        this.Snout.setRotationPoint(0.0F, -1.0F, -2.2F);
        this.Snout.addBox(-2.0F, -0.8F, -3.0F, 3, 2, 3, 0.0F);
        this.Tail2 = new ModelRenderer(this, 150, 27);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 9.5F);
        this.Tail2.addBox(-3.0F, -2.0F, 0.0F, 6, 7, 9, 0.0F);
        this.setRotateAngle(Tail2, -0.091106186954104F, 0.0F, 0.0F);
        this.Tail3 = new ModelRenderer(this, 22, 30);
        this.Tail3.setRotationPoint(0.0F, 0.0F, 9.0F);
        this.Tail3.addBox(-2.0F, -1.0F, 0.0F, 4, 4, 14, 0.0F);
        this.setRotateAngle(Tail3, -0.06492624817418906F, 0.0F, 0.0F);
        this.LPlates3 = new ModelRenderer(this, 87, 19);
        this.LPlates3.setRotationPoint(-1.0F, -5.0F, 0.0F);
        this.LPlates3.addBox(0.0F, -8.0F, -7.0F, 1, 8, 9, 0.0F);
        this.setRotateAngle(LPlates3, 0.0F, 0.0F, -0.136659280431156F);
        this.Head = new ModelRenderer(this, 0, 8);
        this.Head.setRotationPoint(0.0F, 0.0F, -5.9F);
        this.Head.addBox(-2.5F, -1.9F, -2.4F, 4, 3, 3, 0.0F);
        this.setRotateAngle(Head, 0.40980330836826856F, 0.0F, 0.0F);
        this.RPlates1 = new ModelRenderer(this, 40, 8);
        this.RPlates1.setRotationPoint(-0.5F, -2.0F, -1.5F);
        this.RPlates1.addBox(0.0F, -3.0F, -4.0F, 1, 3, 5, 0.0F);
        this.LPlates1 = new ModelRenderer(this, 70, 22);
        this.LPlates1.setRotationPoint(-1.5F, -2.0F, -2.0F);
        this.LPlates1.addBox(0.0F, -3.0F, -4.0F, 1, 3, 5, 0.0F);
        this.LPlates6 = new ModelRenderer(this, 99, 33);
        this.LPlates6.setRotationPoint(-1.0F, -2.0F, -1.0F);
        this.LPlates6.addBox(0.0F, -5.0F, 0.0F, 1, 5, 8, 0.0F);
        this.setRotateAngle(LPlates6, 0.0F, 0.0F, -0.136659280431156F);
        this.RFLeg1 = new ModelRenderer(this, 0, 0);
        this.RFLeg1.setRotationPoint(4.5F, 6.5F, -5.5F);
        this.RFLeg1.addBox(-2.0F, -2.0F, -1.0F, 3, 5, 3, 0.0F);
        this.Neck1 = new ModelRenderer(this, 170, 0);
        this.Neck1.setRotationPoint(0.5F, 0.0F, -7.0F);
        this.Neck1.addBox(-3.0F, -3.0F, -7.0F, 5, 5, 8, 0.0F);
        this.setRotateAngle(Neck1, -0.136659280431156F, 0.0F, 0.0F);
        this.RPlates4 = new ModelRenderer(this, 152, 0);
        this.RPlates4.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.RPlates4.addBox(0.0F, -11.0F, 0.0F, 1, 11, 16, 0.0F);
        this.setRotateAngle(RPlates4, 0.0F, 0.0F, 0.136659280431156F);
        this.RThag1 = new ModelRenderer(this, 12, 0);
        this.RThag1.setRotationPoint(2.0F, -2.0F, 9.0F);
        this.RThag1.addBox(0.0F, -4.0F, 0.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(RThag1, -0.5918411493512771F, 0.0F, 0.5918411493512771F);
        this.Neck2 = new ModelRenderer(this, 134, 14);
        this.Neck2.setRotationPoint(0.0F, 0.0F, -7.0F);
        this.Neck2.addBox(-2.0F, -2.0F, -6.0F, 3, 3, 6, 0.0F);
        this.setRotateAngle(Neck2, -0.18203784098300857F, 0.0F, 0.0F);
        this.LBLeg2 = new ModelRenderer(this, 180, 35);
        this.LBLeg2.setRotationPoint(-1.0F, 9.0F, 0.0F);
        this.LBLeg2.addBox(-2.0F, 0.0F, -2.3F, 3, 6, 4, 0.0F);
        this.LBLeg1 = new ModelRenderer(this, 150, 0);
        this.LBLeg1.setRotationPoint(-3.0F, 0.0F, 13.0F);
        this.LBLeg1.addBox(-3.5F, 0.0F, -3.0F, 4, 9, 5, 0.0F);
        this.RPlates7 = new ModelRenderer(this, 40, 8);
        this.RPlates7.setRotationPoint(0.0F, -1.0F, 5.5F);
        this.RPlates7.addBox(0.0F, -3.0F, -4.0F, 1, 3, 5, 0.0F);
        this.setRotateAngle(RPlates7, 0.0F, 0.0F, 0.136659280431156F);
        this.LThag2 = new ModelRenderer(this, 170, 0);
        this.LThag2.setRotationPoint(-2.9F, -1.5F, 13.0F);
        this.LThag2.addBox(0.0F, -2.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(LThag2, -0.8651597102135892F, 0.0F, -0.5462880558742251F);
        this.LFLeg1 = new ModelRenderer(this, 40, 0);
        this.LFLeg1.setRotationPoint(-3.5F, 6.5F, -5.5F);
        this.LFLeg1.addBox(-2.0F, -2.0F, -1.0F, 3, 5, 3, 0.0F);
        this.LPlates7 = new ModelRenderer(this, 70, 22);
        this.LPlates7.setRotationPoint(-1.0F, -4.0F, 1.0F);
        this.LPlates7.addBox(0.0F, 0.0F, 0.0F, 1, 3, 5, 0.0F);
        this.setRotateAngle(LPlates7, 0.0F, 0.0F, -0.136659280431156F);
        this.RBFoot = new ModelRenderer(this, 134, 23);
        this.RBFoot.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.RBFoot.addBox(-2.5F, 0.5F, -3.5F, 4, 2, 5, 0.0F);
        this.LPlates4 = new ModelRenderer(this, 116, 14);
        this.LPlates4.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.LPlates4.addBox(-1.0F, -11.0F, 0.0F, 1, 11, 16, 0.0F);
        this.setRotateAngle(LPlates4, 0.0F, 0.0F, -0.136659280431156F);
        this.Jaw = new ModelRenderer(this, 145, 0);
        this.Jaw.setRotationPoint(-0.5F, 0.0F, -2.0F);
        this.Jaw.addBox(-1.0F, 0.0F, -2.8F, 2, 1, 3, 0.0F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, -5.5F, -4.0F);
        this.Body1.addBox(-6.0F, -7.0F, 0.0F, 12, 14, 16, 0.0F);
        this.LPlates5 = new ModelRenderer(this, 0, 30);
        this.LPlates5.setRotationPoint(-1.0F, -3.0F, -2.5F);
        this.LPlates5.addBox(0.0F, -8.0F, 0.0F, 1, 8, 10, 0.0F);
        this.setRotateAngle(LPlates5, 0.0F, 0.0F, -0.136659280431156F);
        this.LPlates2 = new ModelRenderer(this, 56, 22);
        this.LPlates2.setRotationPoint(-2.0F, -3.0F, -2.0F);
        this.LPlates2.addBox(0.0F, -5.0F, -5.0F, 1, 5, 6, 0.0F);
        this.setRotateAngle(LPlates2, 0.0F, 0.0F, -0.136659280431156F);
        this.RPlates5 = new ModelRenderer(this, 72, 26);
        this.RPlates5.setRotationPoint(0.0F, -3.0F, -1.0F);
        this.RPlates5.addBox(0.0F, -8.0F, 0.0F, 1, 8, 10, 0.0F);
        this.setRotateAngle(RPlates5, 0.0F, 0.0F, 0.136659280431156F);
        this.Body2 = new ModelRenderer(this, 56, 0);
        this.Body2.setRotationPoint(0.0F, -0.5F, -1.0F);
        this.Body2.addBox(-5.0F, -5.0F, -7.0F, 10, 12, 10, 0.0F);
        this.setRotateAngle(Body2, 0.22759093446006054F, 0.0F, 0.0F);
        this.LBFoot = new ModelRenderer(this, 58, 39);
        this.LBFoot.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.LBFoot.addBox(-2.5F, -0.5F, -3.5F, 4, 2, 5, 0.0F);
        this.RPlates2 = new ModelRenderer(this, 107, 19);
        this.RPlates2.setRotationPoint(0.0F, -3.0F, -1.5F);
        this.RPlates2.addBox(0.0F, -5.0F, -5.0F, 1, 5, 6, 0.0F);
        this.setRotateAngle(RPlates2, 0.0F, 0.0F, 0.136659280431156F);
        this.RBLeg2 = new ModelRenderer(this, 12, 30);
        this.RBLeg2.setRotationPoint(-1.0F, 9.0F, 0.0F);
        this.RBLeg2.addBox(-2.0F, 0.0F, -2.3F, 3, 6, 4, 0.0F);
        this.LThag1 = new ModelRenderer(this, 102, 0);
        this.LThag1.setRotationPoint(-2.8F, -1.4F, 9.0F);
        this.LThag1.addBox(0.0F, -4.0F, 0.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(LThag1, -0.5918411493512771F, 0.0F, -0.5918411493512771F);
        this.Tail1 = new ModelRenderer(this, 96, 0);
        this.Tail1.setRotationPoint(0.0F, -3.5F, 15.5F);
        this.Tail1.addBox(-4.0F, -3.0F, 0.0F, 8, 9, 10, 0.0F);
        this.setRotateAngle(Tail1, -0.045553093477052F, -6.200655107570901E-17F, 0.0F);
        this.RBLeg1 = new ModelRenderer(this, 132, 0);
        this.RBLeg1.setRotationPoint(6.0F, 0.0F, 13.0F);
        this.RBLeg1.addBox(-3.5F, 0.0F, -3.0F, 4, 9, 5, 0.0F);
        this.RPlates3 = new ModelRenderer(this, 177, 18);
        this.RPlates3.setRotationPoint(0.0F, -5.0F, 0.5F);
        this.RPlates3.addBox(0.0F, -8.0F, -7.0F, 1, 8, 9, 0.0F);
        this.setRotateAngle(RPlates3, 0.0F, 0.0F, 0.136659280431156F);
        this.RThag2 = new ModelRenderer(this, 98, 0);
        this.RThag2.setRotationPoint(2.1F, -2.0F, 13.0F);
        this.RThag2.addBox(0.0F, -2.0F, 0.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(RThag2, -0.8651597102135892F, 0.0F, 0.5462880558742251F);
        this.LFLeg2 = new ModelRenderer(this, 86, 0);
        this.LFLeg2.setRotationPoint(-0.9F, 3.0F, -0.1F);
        this.LFLeg2.addBox(-1.0F, -0.5F, -1.0F, 3, 6, 3, 0.0F);
        this.setRotateAngle(LFLeg2, -0.22759093446006054F, 0.0F, 0.0F);
        this.RFLeg1.addChild(this.RFLeg2);
        this.Tail2.addChild(this.RPlates6);
        this.Head.addChild(this.Snout);
        this.Tail1.addChild(this.Tail2);
        this.Tail2.addChild(this.Tail3);
        this.Body2.addChild(this.LPlates3);
        this.Neck2.addChild(this.Head);
        this.Neck2.addChild(this.RPlates1);
        this.Neck2.addChild(this.LPlates1);
        this.Tail2.addChild(this.LPlates6);
        this.Body2.addChild(this.RFLeg1);
        this.Body2.addChild(this.Neck1);
        this.Body1.addChild(this.RPlates4);
        this.Tail3.addChild(this.RThag1);
        this.Neck1.addChild(this.Neck2);
        this.LBLeg1.addChild(this.LBLeg2);
        this.Body1.addChild(this.LBLeg1);
        this.Tail3.addChild(this.RPlates7);
        this.Tail3.addChild(this.LThag2);
        this.Body2.addChild(this.LFLeg1);
        this.Tail3.addChild(this.LPlates7);
        this.RBLeg2.addChild(this.RBFoot);
        this.Body1.addChild(this.LPlates4);
        this.Head.addChild(this.Jaw);
        this.Tail1.addChild(this.LPlates5);
        this.Neck1.addChild(this.LPlates2);
        this.Tail1.addChild(this.RPlates5);
        this.Body1.addChild(this.Body2);
        this.LBLeg2.addChild(this.LBFoot);
        this.Neck1.addChild(this.RPlates2);
        this.RBLeg1.addChild(this.RBLeg2);
        this.Tail3.addChild(this.LThag1);
        this.Body1.addChild(this.Tail1);
        this.Body1.addChild(this.RBLeg1);
        this.Body2.addChild(this.RPlates3);
        this.Tail3.addChild(this.RThag2);
        this.LFLeg1.addChild(this.LFLeg2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	if (this.isChild) {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, this.childYOffset * f5, this.childZOffset * f5);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.2F, 0.2F, 0.2F);
            GlStateManager.translate(0.0F, 110.0F * f5, 0.0F);
            this.Body1.render(f5);
            GlStateManager.popMatrix();
        } else {
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Body1.offsetX, this.Body1.offsetY, this.Body1.offsetZ);
        GlStateManager.translate(this.Body1.rotationPointX * f5, this.Body1.rotationPointY * f5, this.Body1.rotationPointZ * f5);
        GlStateManager.scale(1.9D, 1.9D, 1.9D);
        GlStateManager.translate(-this.Body1.offsetX, -this.Body1.offsetY, -this.Body1.offsetZ);
        GlStateManager.translate(-this.Body1.rotationPointX * f5, -this.Body1.rotationPointY * f5, -this.Body1.rotationPointZ * f5);
        this.Body1.render(f5);
        GlStateManager.popMatrix();
        }
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
    	float XAngle = headPitch / 57.29578F;
    	float YAngle = netHeadYaw / 57.29578F;
    	this.Head.rotateAngleX= (0.2617794F + XAngle);
    	this.Head.rotateAngleY= YAngle;
    	this.RFLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.LFLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.RBLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.LBLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
