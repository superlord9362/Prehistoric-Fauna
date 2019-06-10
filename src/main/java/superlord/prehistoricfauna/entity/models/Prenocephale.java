package superlord.prehistoricfauna.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;

/**
 * Prenocephale2.0 - superlord9362
 * Created using Tabula 7.0.1
 */
public class Prenocephale extends ModelBase {
    public ModelRenderer Body1;
    public ModelRenderer RLeg1;
    public ModelRenderer LLeg1;
    public ModelRenderer Body2;
    public ModelRenderer Shoulders;
    public ModelRenderer RLeg2;
    public ModelRenderer RFoot;
    public ModelRenderer LLeg2;
    public ModelRenderer LFoot;
    public ModelRenderer Tail1;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer RArm1;
    public ModelRenderer LArm1;
    public ModelRenderer Neck1;
    public ModelRenderer RArm2;
    public ModelRenderer LArm2;
    public ModelRenderer Neck2;
    public ModelRenderer shape26;
    public ModelRenderer Head;
    public ModelRenderer Bone1;
    public ModelRenderer Snout1;
    public ModelRenderer Jaw;
    public ModelRenderer Dome1;
    public ModelRenderer Dome2;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public Prenocephale() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, 16.4F, -4.9F);
        this.Body1.addBox(-3.5F, -4.0F, 0.0F, 7, 8, 13, 0.0F);
        this.setRotateAngle(Body1, 0.045553093477052F, 0.0F, 0.0F);
        this.Tail3 = new ModelRenderer(this, 172, 0);
        this.Tail3.setRotationPoint(0.0F, 0.0F, 11.0F);
        this.Tail3.addBox(-1.0F, -1.0F, 0.0F, 1, 2, 12, 0.0F);
        this.setRotateAngle(Tail3, 0.045553093477052F, 0.0F, 0.0F);
        this.RArm2 = new ModelRenderer(this, 55, 12);
        this.RArm2.setRotationPoint(0.0F, 2.5F, 0.0F);
        this.RArm2.addBox(-0.1F, -0.7F, -0.3F, 1, 4, 2, 0.0F);
        this.setRotateAngle(RArm2, -0.6829473363053812F, 0.0F, 0.0F);
        this.Snout1 = new ModelRenderer(this, 37, 0);
        this.Snout1.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.Snout1.addBox(-1.0F, -0.5F, -2.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(Snout1, 0.18203784098300857F, 0.0F, 0.0F);
        this.Shoulders = new ModelRenderer(this, 75, 0);
        this.Shoulders.setRotationPoint(-0.5F, 0.0F, 0.0F);
        this.Shoulders.addBox(-2.5F, -3.5F, -4.0F, 6, 7, 5, 0.0F);
        this.setRotateAngle(Shoulders, 0.091106186954104F, 0.0F, 0.0F);
        this.LArm1 = new ModelRenderer(this, 8, 30);
        this.LArm1.setRotationPoint(-3.0F, 1.5F, -4.3F);
        this.LArm1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(LArm1, 0.4553564018453205F, 0.0F, 0.0F);
        this.RLeg1 = new ModelRenderer(this, 27, 0);
        this.RLeg1.setRotationPoint(3.5F, 1.0F, 10.0F);
        this.RLeg1.addBox(-2.5F, -3.0F, -2.0F, 3, 7, 4, 0.0F);
        this.setRotateAngle(RLeg1, -0.045553093477052F, 0.0F, 0.0F);
        this.Bone1 = new ModelRenderer(this, 169, 0);
        this.Bone1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Bone1.addBox(-2.0F, -0.5F, -0.5F, 4, 1, 3, 0.0F);
        this.Tail2 = new ModelRenderer(this, 144, 0);
        this.Tail2.setRotationPoint(0.5F, -1.0F, 9.0F);
        this.Tail2.addBox(-1.5F, -1.5F, -1.0F, 2, 3, 12, 0.0F);
        this.setRotateAngle(Tail2, 0.045553093477052F, 0.0F, 0.0F);
        this.Neck2 = new ModelRenderer(this, 160, 0);
        this.Neck2.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.Neck2.addBox(-1.0F, -2.0F, -3.0F, 2, 3, 5, 0.0F);
        this.setRotateAngle(Neck2, -0.36425021489121656F, 0.0F, 0.0F);
        this.RArm1 = new ModelRenderer(this, 8, 30);
        this.RArm1.setRotationPoint(3.0F, 1.5F, -4.3F);
        this.RArm1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(RArm1, 0.4553564018453205F, 0.0F, 0.0F);
        this.LArm2 = new ModelRenderer(this, 70, 12);
        this.LArm2.setRotationPoint(0.2F, 2.5F, 0.0F);
        this.LArm2.addBox(-0.1F, -0.7F, -0.3F, 1, 4, 2, 0.0F);
        this.setRotateAngle(LArm2, -0.6829473363053812F, 0.0F, 0.0F);
        this.Dome2 = new ModelRenderer(this, 114, 5);
        this.Dome2.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.Dome2.addBox(-1.0F, 0.0F, -4.0F, 2, 1, 4, 0.0F);
        this.setRotateAngle(Dome2, 1.3203415791337103F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 170, 4);
        this.Head.setRotationPoint(0.0F, -3.0F, -1.8F);
        this.Head.addBox(-1.5F, -1.0F, -2.2F, 3, 3, 4, 0.0F);
        this.Neck1 = new ModelRenderer(this, 134, 0);
        this.Neck1.setRotationPoint(0.5F, 0.0F, -4.0F);
        this.Neck1.addBox(-1.5F, -2.0F, -3.0F, 3, 4, 5, 0.0F);
        this.setRotateAngle(Neck1, -0.6829473363053812F, 0.0F, 0.0F);
        this.Dome1 = new ModelRenderer(this, 186, 0);
        this.Dome1.setRotationPoint(0.0F, -0.8F, 1.5F);
        this.Dome1.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(Dome1, -0.5918411493512771F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 118, 0);
        this.Tail1.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.Tail1.addBox(-1.5F, -3.0F, -1.0F, 3, 4, 10, 0.0F);
        this.RLeg2 = new ModelRenderer(this, 0, 0);
        this.RLeg2.setRotationPoint(-1.0F, 4.0F, 1.0F);
        this.RLeg2.addBox(-1.0F, -1.0F, 0.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(RLeg2, -0.18203784098300857F, 0.0F, 0.0F);
        this.Body2 = new ModelRenderer(this, 55, 0);
        this.Body2.setRotationPoint(0.0F, 0.0F, 13.0F);
        this.Body2.addBox(-2.5F, -3.5F, -1.0F, 5, 7, 5, 0.0F);
        this.setRotateAngle(Body2, -0.18203784098300857F, 0.0F, 0.0F);
        this.LFoot = new ModelRenderer(this, 114, 0);
        this.LFoot.setRotationPoint(0.5F, 7.0F, 0.0F);
        this.LFoot.addBox(-2.0F, 0.0F, -2.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(LFoot, 0.18203784098300857F, 0.0F, 0.0F);
        this.shape26 = new ModelRenderer(this, 0, 0);
        this.shape26.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape26.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape26, 1.0471975511965976F, 0.0F, 0.0F);
        this.Jaw = new ModelRenderer(this, 145, 0);
        this.Jaw.setRotationPoint(0.0F, 1.0F, -1.0F);
        this.Jaw.addBox(-0.5F, 0.0F, -2.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Jaw, 0.136659280431156F, 0.0F, 0.0F);
        this.LLeg2 = new ModelRenderer(this, 106, 0);
        this.LLeg2.setRotationPoint(-1.0F, 4.0F, 1.0F);
        this.LLeg2.addBox(-1.0F, -1.0F, 0.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(LLeg2, -0.18203784098300857F, 0.0F, 0.0F);
        this.RFoot = new ModelRenderer(this, 92, 0);
        this.RFoot.setRotationPoint(0.5F, 7.0F, 0.0F);
        this.RFoot.addBox(-2.0F, 0.0F, -2.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(RFoot, 0.18203784098300857F, -0.004498267542020672F, 0.0F);
        this.LLeg1 = new ModelRenderer(this, 41, 0);
        this.LLeg1.setRotationPoint(-1.5F, 1.0F, 10.0F);
        this.LLeg1.addBox(-2.5F, -3.0F, -2.0F, 3, 7, 4, 0.0F);
        this.setRotateAngle(LLeg1, -0.045553093477052F, 0.0F, 0.0F);
        this.Tail2.addChild(this.Tail3);
        this.RArm1.addChild(this.RArm2);
        this.Head.addChild(this.Snout1);
        this.Body1.addChild(this.Shoulders);
        this.Shoulders.addChild(this.LArm1);
        this.Body1.addChild(this.RLeg1);
        this.Head.addChild(this.Bone1);
        this.Tail1.addChild(this.Tail2);
        this.Neck1.addChild(this.Neck2);
        this.Shoulders.addChild(this.RArm1);
        this.LArm1.addChild(this.LArm2);
        this.Dome1.addChild(this.Dome2);
        this.shape26.addChild(this.Head);
        this.Shoulders.addChild(this.Neck1);
        this.Bone1.addChild(this.Dome1);
        this.Body2.addChild(this.Tail1);
        this.RLeg1.addChild(this.RLeg2);
        this.Body1.addChild(this.Body2);
        this.LLeg2.addChild(this.LFoot);
        this.Neck2.addChild(this.shape26);
        this.Head.addChild(this.Jaw);
        this.LLeg1.addChild(this.LLeg2);
        this.RLeg2.addChild(this.RFoot);
        this.Body1.addChild(this.LLeg1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	if (this.isChild) {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, this.childYOffset * f5, this.childZOffset * f5);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.2F, 0.2F, 0.2F);
            GlStateManager.translate(0.0F, 90.0F * f5, 0.0F);
            this.Body1.render(f5);
            GlStateManager.popMatrix();
        } else {
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Body1.offsetX, this.Body1.offsetY, this.Body1.offsetZ);
        GlStateManager.translate(this.Body1.rotationPointX * f5, this.Body1.rotationPointY * f5, this.Body1.rotationPointZ * f5);
        GlStateManager.scale(0.61D, 0.61D, 0.61D);
        GlStateManager.translate(-this.Body1.offsetX, -this.Body1.offsetY, -this.Body1.offsetZ);
        GlStateManager.translate(-this.Body1.rotationPointX * f5, -this.Body1.rotationPointY * f5, -this.Body1.rotationPointZ * f5);
        this.Body1.render(f5);
        GlStateManager.popMatrix();
        }
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        float XAngle = headPitch / 57.29578F;
        float YAngle = netHeadYaw / 57.29578F;
        this.Head.rotateAngleX = (0.2617794F + XAngle);
        this.Head.rotateAngleY = YAngle;
        this.RLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.LLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
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
