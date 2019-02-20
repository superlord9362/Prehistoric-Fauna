package superlord.prehistoricfauna.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import superlord.prehistoricfauna.entity.EntityDryosaurus;
import superlord.prehistoricfauna.entity.ai.EntityExtinct;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * Dryosaurus - superlord9362
 * Created using Tabula 5.0.0
 */
public class Dryosaurus extends ModelBase {
    public ModelRenderer Body1;
    public ModelRenderer Hips;
    public ModelRenderer RArm1;
    public ModelRenderer LArm1;
    public ModelRenderer Neck1;
    public ModelRenderer Tail1;
    public ModelRenderer RLeg1;
    public ModelRenderer LLeg1;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer RLeg2;
    public ModelRenderer RFoot;
    public ModelRenderer LLeg2;
    public ModelRenderer LFoot;
    public ModelRenderer RArm2;
    public ModelRenderer LArm2;
    public ModelRenderer Neck2;
    public ModelRenderer shape24;
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer Jaw;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;
    
    public Dryosaurus() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.LArm1 = new ModelRenderer(this, 0, 0);
        this.LArm1.setRotationPoint(-5.0F, 1.5F, 1.0F);
        this.LArm1.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2, 0.0F);
        this.setRotateAngle(LArm1, 0.7285004297824331F, 0.0F, 0.0F);
        this.Hips = new ModelRenderer(this, 50, 0);
        this.Hips.setRotationPoint(0.0F, 0.0F, 17.0F);
        this.Hips.addBox(-3.5F, -4.8F, -1.0F, 7, 10, 8, 0.0F);
        this.setRotateAngle(Hips, -0.136659280431156F, 0.0F, 0.0F);
        this.LArm2 = new ModelRenderer(this, 72, 0);
        this.LArm2.setRotationPoint(1.0F, 5.0F, -1.0F);
        this.LArm2.addBox(-1.0F, -2.0F, -0.5F, 2, 6, 2, 0.0F);
        this.setRotateAngle(LArm2, -0.8651597102135892F, 0.0F, 0.0F);
        this.Tail3 = new ModelRenderer(this, 67, 12);
        this.Tail3.setRotationPoint(0.0F, -0.5F, 9.5F);
        this.Tail3.addBox(-1.0F, -1.5F, 0.0F, 2, 3, 13, 0.0F);
        this.setRotateAngle(Tail3, 0.091106186954104F, 0.0F, 0.0F);
        this.shape24 = new ModelRenderer(this, 4, 0);
        this.shape24.setRotationPoint(0.0F, 0.0F, -9.5F);
        this.shape24.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape24, 0.6373942428283291F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 100, 0);
        this.Tail1.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.Tail1.addBox(-2.0F, -3.5F, -0.5F, 4, 7, 7, 0.0F);
        this.RArm2 = new ModelRenderer(this, 43, 0);
        this.RArm2.setRotationPoint(0.0F, 5.0F, -1.0F);
        this.RArm2.addBox(-1.0F, -2.0F, -0.5F, 2, 6, 2, 0.0F);
        this.setRotateAngle(RArm2, -0.8651597102135892F, 0.0F, 0.0F);
        this.Neck2 = new ModelRenderer(this, 97, 14);
        this.Neck2.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.Neck2.addBox(-2.0F, -2.0F, -9.0F, 4, 5, 9, 0.0F);
        this.setRotateAngle(Neck2, -0.36425021489121656F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 115, 0);
        this.Snout.setRotationPoint(0.0F, 0.0F, -1.5F);
        this.Snout.addBox(-1.5F, -1.0F, -4.0F, 3, 3, 4, 0.0F);
        this.setRotateAngle(Snout, 0.36425021489121656F, 0.0F, 0.0F);
        this.RLeg2 = new ModelRenderer(this, 33, 0);
        this.RLeg2.setRotationPoint(0.0F, 6.0F, 3.0F);
        this.RLeg2.addBox(-1.5F, 0.0F, -1.0F, 2, 9, 3, 0.0F);
        this.setRotateAngle(RLeg2, 0.091106186954104F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 162, 0);
        this.Tail2.setRotationPoint(0.0F, 0.5F, 6.0F);
        this.Tail2.addBox(-1.5F, -3.0F, 0.0F, 3, 5, 10, 0.0F);
        this.setRotateAngle(Tail2, 0.091106186954104F, 0.0F, 0.0F);
        this.RLeg1 = new ModelRenderer(this, 142, 0);
        this.RLeg1.setRotationPoint(3.5F, 0.0F, 0.0F);
        this.RLeg1.addBox(-2.0F, -4.0F, -3.0F, 3, 11, 7, 0.0F);
        this.RFoot = new ModelRenderer(this, 155, 0);
        this.RFoot.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.RFoot.addBox(-2.0F, 0.0F, -3.0F, 3, 1, 5, 0.0F);
        this.setRotateAngle(RFoot, 0.091106186954104F, 0.0F, 0.0F);
        this.LFoot = new ModelRenderer(this, 155, 0);
        this.LFoot.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.LFoot.addBox(-2.0F, 0.0F, -3.0F, 3, 1, 5, 0.0F);
        this.setRotateAngle(LFoot, 0.091106186954104F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 84, 12);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-2.5F, -1.3F, -2.5F, 5, 5, 4, 0.0F);
        this.LLeg1 = new ModelRenderer(this, 142, 0);
        this.LLeg1.setRotationPoint(-2.5F, 0.0F, 0.0F);
        this.LLeg1.addBox(-2.0F, -4.0F, -3.0F, 3, 11, 7, 0.0F);
        this.Jaw = new ModelRenderer(this, 96, 0);
        this.Jaw.setRotationPoint(0.0F, 2.6F, -2.0F);
        this.Jaw.addBox(-1.0F, 0.0F, -2.0F, 2, 1, 2, 0.0F);
        this.RArm1 = new ModelRenderer(this, 0, 0);
        this.RArm1.setRotationPoint(4.0F, 1.5F, 1.0F);
        this.RArm1.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2, 0.0F);
        this.setRotateAngle(RArm1, 0.7285004297824331F, 0.0F, 0.0F);
        this.Neck1 = new ModelRenderer(this, 80, 0);
        this.Neck1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Neck1.addBox(-3.0F, -4.0F, -2.0F, 6, 8, 4, 0.0F);
        this.setRotateAngle(Neck1, -0.27314402793711257F, 0.0F, 0.0F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, 11.4F, -13.0F);
        this.Body1.addBox(-4.0F, -5.0F, 0.0F, 8, 10, 17, 0.0F);
        this.setRotateAngle(Body1, -0.045553093477052F, 0.0F, 0.0F);
        this.LLeg2 = new ModelRenderer(this, 33, 0);
        this.LLeg2.setRotationPoint(0.0F, 6.0F, 3.0F);
        this.LLeg2.addBox(-1.5F, 0.0F, -1.0F, 2, 9, 3, 0.0F);
        this.setRotateAngle(LLeg2, 0.091106186954104F, 0.0F, 0.0F);
        this.Body1.addChild(this.LArm1);
        this.Body1.addChild(this.Hips);
        this.LArm1.addChild(this.LArm2);
        this.Tail2.addChild(this.Tail3);
        this.Neck2.addChild(this.shape24);
        this.Hips.addChild(this.Tail1);
        this.RArm1.addChild(this.RArm2);
        this.Neck1.addChild(this.Neck2);
        this.Head.addChild(this.Snout);
        this.RLeg1.addChild(this.RLeg2);
        this.Tail1.addChild(this.Tail2);
        this.Hips.addChild(this.RLeg1);
        this.RLeg2.addChild(this.RFoot);
        this.LLeg2.addChild(this.LFoot);
        this.shape24.addChild(this.Head);
        this.Hips.addChild(this.LLeg1);
        this.Head.addChild(this.Jaw);
        this.Body1.addChild(this.RArm1);
        this.Body1.addChild(this.Neck1);
        this.LLeg1.addChild(this.LLeg2);
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
            GlStateManager.translate(0.0F, 90.0F * f5, 0.0F);
            this.Body1.render(f5);
            GlStateManager.popMatrix();
        } else {
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Body1.offsetX, this.Body1.offsetY, this.Body1.offsetZ);
        GlStateManager.translate(this.Body1.rotationPointX * f5, this.Body1.rotationPointY * f5, this.Body1.rotationPointZ * f5);
        GlStateManager.scale(0.73D, 0.73D, 0.73D);
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
