package superlord.prehistoricfauna.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;

/**
 * Parasaurolophus - superlord9362
 * Created using Tabula 7.0.1
 */
public class Parasaurolophus extends ModelBase {
    public ModelRenderer Body1;
    public ModelRenderer Body2;
    public ModelRenderer Stomach;
    public ModelRenderer Neck1;
    public ModelRenderer shape45;
    public ModelRenderer Tail1;
    public ModelRenderer shape47;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer RBLeg1;
    public ModelRenderer LBLeg1;
    public ModelRenderer RBLeg2;
    public ModelRenderer RFoot;
    public ModelRenderer LBLeg2;
    public ModelRenderer LFoot;
    public ModelRenderer Neck2;
    public ModelRenderer shape46;
    public ModelRenderer Head;
    public ModelRenderer Snout1;
    public ModelRenderer Jaw1;
    public ModelRenderer Snout2;
    public ModelRenderer ACrest1;
    public ModelRenderer JCrest;
    public ModelRenderer ACrest2;
    public ModelRenderer Jaw2;
    public ModelRenderer LArm1;
    public ModelRenderer RArm1;
    public ModelRenderer LArm2;
    public ModelRenderer RArm2;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public Parasaurolophus() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.Body2 = new ModelRenderer(this, 18, 0);
        this.Body2.setRotationPoint(0.0F, -2.9F, 13.5F);
        this.Body2.addBox(-4.5F, -7.0F, -10.9F, 9, 15, 30, 0.0F);
        this.setRotateAngle(Body2, 0.045553093477052F, 0.0F, 0.0F);
        this.shape47 = new ModelRenderer(this, 4, 0);
        this.shape47.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape47.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape47, -0.136659280431156F, 0.0F, 0.0F);
        this.LBLeg2 = new ModelRenderer(this, 34, 0);
        this.LBLeg2.setRotationPoint(0.0F, 10.0F, 3.5F);
        this.LBLeg2.addBox(0.5F, -1.0F, -2.0F, 3, 10, 3, 0.0F);
        this.setRotateAngle(LBLeg2, -0.136659280431156F, 0.0F, 0.0F);
        this.Snout1 = new ModelRenderer(this, 185, 0);
        this.Snout1.setRotationPoint(0.0F, -2.0F, -3.0F);
        this.Snout1.addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(Snout1, 0.36425021489121656F, 0.0F, 0.0F);
        this.Jaw2 = new ModelRenderer(this, 116, 0);
        this.Jaw2.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.Jaw2.addBox(-1.5F, 0.0F, -1.0F, 3, 1, 2, 0.0F);
        this.Jaw1 = new ModelRenderer(this, 75, 0);
        this.Jaw1.setRotationPoint(0.0F, 2.7F, -2.9F);
        this.Jaw1.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(Jaw1, 0.22759093446006054F, 0.0F, 0.0F);
        this.RFoot = new ModelRenderer(this, 142, 0);
        this.RFoot.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.RFoot.addBox(0.0F, -2.0F, -4.8F, 4, 2, 6, 0.0F);
        this.setRotateAngle(RFoot, 0.18203784098300857F, 0.0F, 0.0F);
        this.LArm2 = new ModelRenderer(this, 0, 29);
        this.LArm2.setRotationPoint(-0.4F, 5.8F, 0.5F);
        this.LArm2.addBox(-2.0F, -1.0F, -2.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(LArm2, -0.5009094953223726F, 0.0F, 0.0F);
        this.Tail3 = new ModelRenderer(this, 169, 6);
        this.Tail3.setRotationPoint(0.0F, 1.0F, 11.0F);
        this.Tail3.addBox(-1.0F, -2.0F, 0.0F, 2, 4, 12, 0.0F);
        this.LFoot = new ModelRenderer(this, 142, 0);
        this.LFoot.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.LFoot.addBox(0.0F, -2.0F, -4.8F, 4, 2, 6, 0.0F);
        this.setRotateAngle(LFoot, 0.18203784098300857F, 0.0F, 0.0F);
        this.RArm1 = new ModelRenderer(this, 130, 20);
        this.RArm1.setRotationPoint(6.0F, 3.5F, -2.0F);
        this.RArm1.addBox(-2.5F, 0.0F, -1.5F, 2, 5, 3, 0.0F);
        this.RBLeg1 = new ModelRenderer(this, 145, 18);
        this.RBLeg1.setRotationPoint(1.0F, 1.0F, 7.0F);
        this.RBLeg1.addBox(0.0F, 0.0F, -2.0F, 4, 10, 6, 0.0F);
        this.Snout2 = new ModelRenderer(this, 0, 2);
        this.Snout2.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.Snout2.addBox(-2.0F, 0.0F, -3.0F, 4, 4, 3, 0.0F);
        this.setRotateAngle(Snout2, 0.18203784098300857F, 0.0F, 0.0F);
        this.ACrest1 = new ModelRenderer(this, 96, 27);
        this.ACrest1.setRotationPoint(0.0F, -0.2F, 0.5F);
        this.ACrest1.addBox(-1.0F, -0.7F, -3.0F, 2, 2, 9, 0.0F);
        this.setRotateAngle(ACrest1, 0.27314402793711257F, 0.0F, 0.0F);
        this.Stomach = new ModelRenderer(this, 66, 0);
        this.Stomach.setRotationPoint(0.0F, 5.0F, 13.5F);
        this.Stomach.addBox(-4.0F, -3.0F, 0.0F, 8, 5, 17, 0.0F);
        this.setRotateAngle(Stomach, 0.136659280431156F, 0.0F, 0.0F);
        this.LBLeg1 = new ModelRenderer(this, 145, 18);
        this.LBLeg1.setRotationPoint(-5.0F, 1.0F, 7.0F);
        this.LBLeg1.addBox(0.0F, 0.0F, -2.0F, 4, 10, 6, 0.0F);
        this.RArm2 = new ModelRenderer(this, 0, 29);
        this.RArm2.setRotationPoint(-0.6F, 5.8F, 0.5F);
        this.RArm2.addBox(-2.0F, -1.0F, -2.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(RArm2, -0.5009094953223726F, 0.0F, 0.0F);
        this.Neck2 = new ModelRenderer(this, 165, 22);
        this.Neck2.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.Neck2.addBox(-2.0F, -3.0F, -7.0F, 4, 7, 9, 0.0F);
        this.setRotateAngle(Neck2, -0.4553564018453205F, 0.0F, 0.0F);
        this.shape46 = new ModelRenderer(this, 8, 0);
        this.shape46.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape46.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape46, 0.6829473363053812F, 0.0F, 0.0F);
        this.shape45 = new ModelRenderer(this, 0, 0);
        this.shape45.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape45.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape45, 0.4553564018453205F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 130, 29);
        this.Head.setRotationPoint(0.0F, -4.4F, -5.5F);
        this.Head.addBox(-2.5F, -2.3F, -3.0F, 5, 6, 5, 0.0F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, -7.0F, -7.0F);
        this.Body1.addBox(-5.0F, -8.0F, 0.0F, 10, 15, 14, 0.0F);
        this.setRotateAngle(Body1, 0.045553093477052F, 0.0F, 0.0F);
        this.ACrest2 = new ModelRenderer(this, 86, 22);
        this.ACrest2.setRotationPoint(0.0F, 0.3F, 5.6F);
        this.ACrest2.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 5, 0.0F);
        this.setRotateAngle(ACrest2, -0.36425021489121656F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 121, 0);
        this.Tail1.setRotationPoint(0.0F, -3.9F, 18.5F);
        this.Tail1.addBox(-3.0F, -3.0F, 0.0F, 6, 11, 9, 0.0F);
        this.setRotateAngle(Tail1, -0.091106186954104F, 0.0F, 0.0F);
        this.RBLeg2 = new ModelRenderer(this, 34, 0);
        this.RBLeg2.setRotationPoint(0.0F, 10.0F, 3.5F);
        this.RBLeg2.addBox(0.5F, -1.0F, -2.0F, 3, 10, 3, 0.0F);
        this.setRotateAngle(RBLeg2, -0.136659280431156F, 0.0F, 0.0F);
        this.JCrest = new ModelRenderer(this, 170, 0);
        this.JCrest.setRotationPoint(0.0F, -0.2F, 0.5F);
        this.JCrest.addBox(-1.0F, -0.7F, -3.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(JCrest, 0.27314402793711257F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 151, 0);
        this.Tail2.setRotationPoint(0.0F, -0.5F, 9.0F);
        this.Tail2.addBox(-2.0F, -2.0F, 0.0F, 4, 7, 11, 0.0F);
        this.LArm1 = new ModelRenderer(this, 130, 20);
        this.LArm1.setRotationPoint(-3.0F, 3.5F, -2.0F);
        this.LArm1.addBox(-2.5F, 0.0F, -1.5F, 2, 5, 3, 0.0F);
        this.Neck1 = new ModelRenderer(this, 99, 0);
        this.Neck1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Neck1.addBox(-3.0F, -4.0F, -4.0F, 6, 9, 5, 0.0F);
        this.setRotateAngle(Neck1, -0.18203784098300857F, 0.0F, 0.0F);
        this.Body1.addChild(this.Body2);
        this.Body2.addChild(this.shape47);
        this.LBLeg1.addChild(this.LBLeg2);
        this.Head.addChild(this.Snout1);
        this.Jaw1.addChild(this.Jaw2);
        this.Head.addChild(this.Jaw1);
        this.RBLeg2.addChild(this.RFoot);
        this.LArm1.addChild(this.LArm2);
        this.Tail2.addChild(this.Tail3);
        this.LBLeg2.addChild(this.LFoot);
        this.shape45.addChild(this.RArm1);
        this.shape47.addChild(this.RBLeg1);
        this.Snout1.addChild(this.Snout2);
        this.Snout1.addChild(this.ACrest1);
        this.Body1.addChild(this.Stomach);
        this.shape47.addChild(this.LBLeg1);
        this.RArm1.addChild(this.RArm2);
        this.Neck1.addChild(this.Neck2);
        this.Neck2.addChild(this.shape46);
        this.Body1.addChild(this.shape45);
        this.shape46.addChild(this.Head);
        this.ACrest1.addChild(this.ACrest2);
        this.Body2.addChild(this.Tail1);
        this.RBLeg1.addChild(this.RBLeg2);
        this.Snout1.addChild(this.JCrest);
        this.Tail1.addChild(this.Tail2);
        this.shape45.addChild(this.LArm1);
        this.Body1.addChild(this.Neck1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	if (this.isChild)
        {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, this.childYOffset * f5, this.childZOffset * f5);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            GlStateManager.translate(0.0F, 38.0F * f5, 0.0F);
            this.Body1.render(f5);
            GlStateManager.popMatrix();
        }
        else
        {
        	GlStateManager.pushMatrix();
        	GlStateManager.translate(this.Body1.offsetX, this.Body1.offsetY, this.Body1.offsetZ);
        	GlStateManager.translate(this.Body1.rotationPointX * f5, this.Body1.rotationPointY * f5, this.Body1.rotationPointZ * f5);
        	GlStateManager.scale(1.85D, 1.85D, 1.85D);
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
    	this.RArm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.LArm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
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
