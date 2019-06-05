package superlord.prehistoricfauna.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * Baryonyxv2 - superlord9362
 * Created using Tabula 7.0.1
 */
public class Baryonyxv2 extends ModelBase {
    public ModelRenderer Body1;
    public ModelRenderer Chest;
    public ModelRenderer Stomach;
    public ModelRenderer Tail1;
    public ModelRenderer RArm1;
    public ModelRenderer Neck1;
    public ModelRenderer LArm1;
    public ModelRenderer shape35;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer Tail4;
    public ModelRenderer RArm2;
    public ModelRenderer Neck2;
    public ModelRenderer Neck3;
    public ModelRenderer shape36;
    public ModelRenderer Head;
    public ModelRenderer Jaw1;
    public ModelRenderer Snout1;
    public ModelRenderer Jaw2;
    public ModelRenderer Snout2;
    public ModelRenderer Crest;
    public ModelRenderer Larm2;
    public ModelRenderer RLeg1;
    public ModelRenderer LLeg1;
    public ModelRenderer RLeg2;
    public ModelRenderer RFoot;
    public ModelRenderer LLeg2;
    public ModelRenderer LFoot;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public Baryonyxv2() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.LLeg1 = new ModelRenderer(this, 0, 0);
        this.LLeg1.setRotationPoint(-2.4F, -2.0F, 21.5F);
        this.LLeg1.addBox(-3.0F, -1.0F, -3.0F, 4, 12, 7, 0.0F);
        this.Chest = new ModelRenderer(this, 41, 0);
        this.Chest.setRotationPoint(0.0F, 3.0F, 1.0F);
        this.Chest.addBox(-3.5F, -5.0F, 0.0F, 7, 6, 16, 0.0F);
        this.setRotateAngle(Chest, -0.445058959258554F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 129, 0);
        this.Tail1.setRotationPoint(0.0F, 0.0F, 24.0F);
        this.Tail1.addBox(-3.0F, -4.9F, -1.0F, 6, 9, 14, 0.0F);
        this.setRotateAngle(Tail1, -0.18203784098300857F, 0.0F, 0.0F);
        this.Tail3 = new ModelRenderer(this, 53, 22);
        this.Tail3.setRotationPoint(0.0F, 0.0F, 13.0F);
        this.Tail3.addBox(-2.0F, -4.0F, -0.5F, 4, 6, 13, 0.0F);
        this.setRotateAngle(Tail3, 0.091106186954104F, 0.0F, 0.0F);
        this.RArm1 = new ModelRenderer(this, 41, 0);
        this.RArm1.setRotationPoint(4.0F, 3.0F, 4.0F);
        this.RArm1.addBox(-2.0F, -1.0F, -2.0F, 3, 6, 3, 0.0F);
        this.setRotateAngle(RArm1, 0.5462880558742251F, 0.0F, 0.0F);
        this.Crest = new ModelRenderer(this, 21, 0);
        this.Crest.setRotationPoint(-0.5F, -1.0F, -1.0F);
        this.Crest.addBox(0.0F, -1.0F, -1.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(Crest, 0.40980330836826856F, 0.0F, 0.0F);
        this.Jaw1 = new ModelRenderer(this, 14, 34);
        this.Jaw1.setRotationPoint(0.0F, 0.2F, -2.0F);
        this.Jaw1.addBox(-1.0F, 0.0F, -8.0F, 2, 1, 8, 0.0F);
        this.setRotateAngle(Jaw1, 0.22010932174229478F, 0.0F, 0.0F);
        this.shape35 = new ModelRenderer(this, 0, 0);
        this.shape35.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape35.addBox(0.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape35, -0.091106186954104F, 0.0F, 0.0F);
        this.RLeg1 = new ModelRenderer(this, 0, 0);
        this.RLeg1.setRotationPoint(4.4F, -2.0F, 21.5F);
        this.RLeg1.addBox(-3.0F, -1.0F, -3.0F, 4, 12, 7, 0.0F);
        this.shape36 = new ModelRenderer(this, 0, 0);
        this.shape36.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape36.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape36, 0.36425021489121656F, 0.0F, 0.0F);
        this.RFoot = new ModelRenderer(this, 101, 25);
        this.RFoot.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.RFoot.addBox(-3.0F, 0.0F, -4.0F, 4, 2, 8, 0.0F);
        this.setRotateAngle(RFoot, 0.22759093446006054F, 0.0F, 0.0F);
        this.Jaw2 = new ModelRenderer(this, 0, 0);
        this.Jaw2.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.Jaw2.addBox(-1.0F, -0.05F, -0.8F, 2, 1, 1, 0.0F);
        this.setRotateAngle(Jaw2, -0.22759093446006054F, 0.0F, 0.0F);
        this.Stomach = new ModelRenderer(this, 87, 0);
        this.Stomach.setRotationPoint(-0.5F, 0.5F, 13.0F);
        this.Stomach.addBox(-3.0F, -0.5F, -0.3F, 7, 11, 14, 0.0F);
        this.setRotateAngle(Stomach, 0.2181661564992912F, 0.0F, 0.0F);
        this.RLeg2 = new ModelRenderer(this, 0, 34);
        this.RLeg2.setRotationPoint(0.0F, 10.0F, 0.5F);
        this.RLeg2.addBox(-2.5F, -1.0F, 0.0F, 3, 13, 4, 0.0F);
        this.setRotateAngle(RLeg2, -0.22759093446006054F, 0.0F, 0.0F);
        this.Neck2 = new ModelRenderer(this, 179, 19);
        this.Neck2.setRotationPoint(0.0F, 0.4F, -6.0F);
        this.Neck2.addBox(-2.0F, -2.4F, -5.0F, 4, 4, 6, 0.0F);
        this.setRotateAngle(Neck2, -0.31869712141416456F, 0.0F, 0.0F);
        this.Snout1 = new ModelRenderer(this, 34, 34);
        this.Snout1.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.Snout1.addBox(-1.5F, -1.5F, -7.0F, 3, 2, 8, 0.0F);
        this.setRotateAngle(Snout1, 0.31398473243377983F, 0.0F, 0.0F);
        this.Tail4 = new ModelRenderer(this, 113, 23);
        this.Tail4.setRotationPoint(0.0F, -1.0F, 12.0F);
        this.Tail4.addBox(-1.5F, -2.5F, 0.0F, 3, 4, 16, 0.0F);
        this.setRotateAngle(Tail4, -0.045553093477052F, 0.0F, 0.0F);
        this.LFoot = new ModelRenderer(this, 101, 25);
        this.LFoot.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.LFoot.addBox(-3.0F, 0.0F, -4.0F, 4, 2, 8, 0.0F);
        this.setRotateAngle(LFoot, 0.22759093446006054F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 156, 19);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 13.0F);
        this.Tail2.addBox(-2.5F, -4.5F, 0.0F, 5, 8, 13, 0.0F);
        this.RArm2 = new ModelRenderer(this, 155, 0);
        this.RArm2.setRotationPoint(0.0F, 5.0F, 0.2F);
        this.RArm2.addBox(-1.5F, -0.3F, -2.3F, 2, 6, 3, 0.0F);
        this.setRotateAngle(RArm2, -0.4553564018453205F, 0.0F, 0.0F);
        this.Neck3 = new ModelRenderer(this, 135, 23);
        this.Neck3.setRotationPoint(0.0F, -0.1F, -5.1F);
        this.Neck3.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(Neck3, 0.36425021489121656F, 0.0F, 0.0F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, -4.5F, -28.0F);
        this.Body1.addBox(-4.0F, -5.0F, 0.0F, 8, 9, 25, 0.0F);
        this.setRotateAngle(Body1, 0.091106186954104F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 151, 23);
        this.Head.setRotationPoint(0.0F, -0.9F, -2.3F);
        this.Head.addBox(-2.5F, -2.2F, -3.9F, 5, 4, 4, 0.0F);
        this.LArm1 = new ModelRenderer(this, 41, 0);
        this.LArm1.setRotationPoint(-3.0F, 3.0F, 4.0F);
        this.LArm1.addBox(-2.0F, -1.0F, -2.0F, 3, 6, 3, 0.0F);
        this.setRotateAngle(LArm1, 0.5462880558742251F, 0.0F, 0.0F);
        this.LLeg2 = new ModelRenderer(this, 0, 34);
        this.LLeg2.setRotationPoint(0.0F, 10.0F, 0.5F);
        this.LLeg2.addBox(-2.5F, -1.0F, 0.0F, 3, 13, 4, 0.0F);
        this.setRotateAngle(LLeg2, -0.22759093446006054F, 0.0F, 0.0F);
        this.Snout2 = new ModelRenderer(this, 15, 0);
        this.Snout2.setRotationPoint(0.0F, -0.7F, -7.0F);
        this.Snout2.addBox(-1.5F, -0.6F, -1.3F, 3, 1, 2, 0.0F);
        this.setRotateAngle(Snout2, 0.36425021489121656F, 0.0F, 0.0F);
        this.Neck1 = new ModelRenderer(this, 71, 0);
        this.Neck1.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.Neck1.addBox(-3.0F, -2.7F, -6.1F, 6, 6, 8, 0.0F);
        this.setRotateAngle(Neck1, -0.31869712141416456F, 0.0F, 0.0F);
        this.Larm2 = new ModelRenderer(this, 155, 0);
        this.Larm2.mirror = true;
        this.Larm2.setRotationPoint(0.0F, 5.0F, 0.2F);
        this.Larm2.addBox(-1.5F, -0.3F, -2.3F, 2, 6, 3, 0.0F);
        this.setRotateAngle(Larm2, -0.4553564018453205F, 0.0F, 0.0F);
        this.shape35.addChild(this.LLeg1);
        this.Body1.addChild(this.Chest);
        this.Body1.addChild(this.Tail1);
        this.Tail2.addChild(this.Tail3);
        this.Body1.addChild(this.RArm1);
        this.Snout1.addChild(this.Crest);
        this.Head.addChild(this.Jaw1);
        this.Body1.addChild(this.shape35);
        this.shape35.addChild(this.RLeg1);
        this.Neck3.addChild(this.shape36);
        this.RLeg2.addChild(this.RFoot);
        this.Jaw1.addChild(this.Jaw2);
        this.Body1.addChild(this.Stomach);
        this.RLeg1.addChild(this.RLeg2);
        this.Neck1.addChild(this.Neck2);
        this.Head.addChild(this.Snout1);
        this.Tail3.addChild(this.Tail4);
        this.LLeg2.addChild(this.LFoot);
        this.Tail1.addChild(this.Tail2);
        this.RArm1.addChild(this.RArm2);
        this.Neck2.addChild(this.Neck3);
        this.shape36.addChild(this.Head);
        this.Body1.addChild(this.LArm1);
        this.LLeg1.addChild(this.LLeg2);
        this.Snout1.addChild(this.Snout2);
        this.Body1.addChild(this.Neck1);
        this.LArm1.addChild(this.Larm2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	if (this.isChild) {
            float f6 = 2.0F;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, this.childYOffset * f5, this.childZOffset * f5);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.2F, 0.2F, 0.2F);
            GlStateManager.translate(0.0F, 102.0F * f5, 0.0F);
            this.Body1.render(f5);
            GlStateManager.popMatrix();
        } else {
        	GlStateManager.pushMatrix();
        	GlStateManager.translate(this.Body1.offsetX, this.Body1.offsetY, this.Body1.offsetZ);
        	GlStateManager.translate(this.Body1.rotationPointX * f5, this.Body1.rotationPointY * f5, this.Body1.rotationPointZ * f5);
        	GlStateManager.scale(1.25D, 1.3D, 1.5D);
        	GlStateManager.translate(-this.Body1.offsetX, -this.Body1.offsetY, -this.Body1.offsetZ);
        	GlStateManager.translate(-this.Body1.rotationPointX * f5, -this.Body1.rotationPointY * f5, -this.Body1.rotationPointZ * f5);
        	this.Body1.render(f5);
        	GlStateManager.popMatrix();
        }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        float XAngle = headPitch / 57.29578F;
        float YAngle = netHeadYaw / 57.29578F;
        this.Head.rotateAngleX = (XAngle);
        this.Head.rotateAngleY = YAngle;
        this.RLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.LLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
    }
    
}
