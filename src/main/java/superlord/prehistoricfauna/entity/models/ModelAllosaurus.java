package superlord.prehistoricfauna.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * Allosaurus - superlord9362
 * Created using Tabula 5.0.0
 */
public class ModelAllosaurus extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Tail1;
    public ModelRenderer RLeg1;
    public ModelRenderer LLeg1;
    public ModelRenderer Body2;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer Tail4;
    public ModelRenderer RLeg2;
    public ModelRenderer RFoot;
    public ModelRenderer LLeg2;
    public ModelRenderer LFoot;
    public ModelRenderer RArm1;
    public ModelRenderer LArm1;
    public ModelRenderer Neck1;
    public ModelRenderer RArm2;
    public ModelRenderer LArm2;
    public ModelRenderer Neck2;
    public ModelRenderer HeadConnector;
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer Jaw;
    public ModelRenderer RCrest;
    public ModelRenderer LCrest;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public ModelAllosaurus() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.LFoot = new ModelRenderer(this, 164, 29);
        this.LFoot.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.LFoot.addBox(-2.5F, 0.0F, -4.0F, 4, 2, 9, 0.0F);
        this.Neck1 = new ModelRenderer(this, 28, 39);
        this.Neck1.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.Neck1.addBox(-3.0F, -5.0F, -7.0F, 6, 9, 9, 0.0F);
        this.setRotateAngle(Neck1, -0.36425021489121656F, 0.0F, 0.0F);
        this.Tail3 = new ModelRenderer(this, 124, 20);
        this.Tail3.setRotationPoint(0.0F, 0.0F, 12.0F);
        this.Tail3.addBox(-2.5F, -4.0F, 0.0F, 5, 7, 15, 0.0F);
        this.Head = new ModelRenderer(this, 158, 40);
        this.Head.setRotationPoint(0.0F, -2.5F, -6.7F);
        this.Head.addBox(-2.5F, -4.7F, -4.0F, 5, 8, 6, 0.0F);
        this.RLeg2 = new ModelRenderer(this, 0, 0);
        this.RLeg2.setRotationPoint(-1.0F, 10.0F, 0.0F);
        this.RLeg2.addBox(-2.0F, 0.0F, 0.0F, 3, 12, 5, 0.0F);
        this.RArm1 = new ModelRenderer(this, 0, 39);
        this.RArm1.setRotationPoint(4.0F, 2.0F, -3.0F);
        this.RArm1.addBox(0.0F, 0.0F, -2.0F, 3, 7, 4, 0.0F);
        this.setRotateAngle(RArm1, 0.8196066167365371F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, -10.0F, -23.0F);
        this.Body.addBox(-6.0F, -8.0F, 0.0F, 12, 16, 23, 0.0F);
        this.Jaw = new ModelRenderer(this, 128, 42);
        this.Jaw.setRotationPoint(0.0F, 2.0F, -4.0F);
        this.Jaw.addBox(-1.5F, 0.0F, -7.5F, 3, 1, 8, 0.0F);
        this.LArm2 = new ModelRenderer(this, 187, 37);
        this.LArm2.setRotationPoint(0.1F, 5.0F, -0.5F);
        this.LArm2.addBox(0.0F, 0.0F, 0.0F, 3, 11, 3, 0.0F);
        this.setRotateAngle(LArm2, -0.5462880558742251F, 0.0F, 0.0F);
        this.Body2 = new ModelRenderer(this, 139, 0);
        this.Body2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body2.addBox(-4.5F, -6.5F, -6.0F, 9, 13, 7, 0.0F);
        this.setRotateAngle(Body2, -0.18203784098300857F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 159, 8);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 7.5F);
        this.Tail2.addBox(-4.0F, -5.0F, 0.0F, 8, 9, 12, 0.0F);
        this.setRotateAngle(Tail2, 0.045553093477052F, 0.0F, 0.0F);
        this.LLeg1 = new ModelRenderer(this, 111, 0);
        this.LLeg1.setRotationPoint(-3.0F, 0.0F, 18.0F);
        this.LLeg1.addBox(-4.0F, -5.0F, -5.0F, 5, 17, 9, 0.0F);
        this.LLeg2 = new ModelRenderer(this, 102, 26);
        this.LLeg2.setRotationPoint(-1.0F, 10.0F, 0.0F);
        this.LLeg2.addBox(-2.0F, 0.0F, 0.0F, 3, 12, 5, 0.0F);
        this.RLeg1 = new ModelRenderer(this, 83, 0);
        this.RLeg1.setRotationPoint(6.0F, 0.0F, 18.0F);
        this.RLeg1.addBox(-4.0F, -5.0F, -5.0F, 5, 17, 9, 0.0F);
        this.LArm1 = new ModelRenderer(this, 0, 39);
        this.LArm1.setRotationPoint(-7.0F, 2.0F, -3.0F);
        this.LArm1.addBox(0.0F, 0.0F, -2.0F, 3, 7, 4, 0.0F);
        this.setRotateAngle(LArm1, 0.8196066167365371F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 111, 42);
        this.Snout.setRotationPoint(0.0F, -2.0F, -4.0F);
        this.Snout.addBox(-2.0F, -2.0F, -8.5F, 4, 6, 9, 0.0F);
        this.setRotateAngle(Snout, 0.045553093477052F, 0.0F, 0.0F);
        this.RCrest = new ModelRenderer(this, 75, 0);
        this.RCrest.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.RCrest.addBox(1.0F, -2.0F, -4.0F, 1, 2, 5, 0.0F);
        this.setRotateAngle(RCrest, 0.4553564018453205F, 0.136659280431156F, 0.136659280431156F);
        this.LCrest = new ModelRenderer(this, 102, 0);
        this.LCrest.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.LCrest.addBox(-2.0F, -2.0F, -4.0F, 1, 2, 5, 0.0F);
        this.setRotateAngle(LCrest, 0.4553564018453205F, -0.136659280431156F, -0.136659280431156F);
        this.Tail1 = new ModelRenderer(this, 47, 0);
        this.Tail1.setRotationPoint(0.0F, -1.0F, 23.0F);
        this.Tail1.addBox(-5.0F, -6.5F, 0.0F, 10, 13, 8, 0.0F);
        this.RArm2 = new ModelRenderer(this, 187, 0);
        this.RArm2.setRotationPoint(-0.1F, 5.0F, -0.5F);
        this.RArm2.addBox(0.0F, 0.0F, 0.0F, 3, 11, 3, 0.0F);
        this.setRotateAngle(RArm2, -0.5462880558742251F, 0.0F, 0.0F);
        this.HeadConnector = new ModelRenderer(this, 0, 0);
        this.HeadConnector.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HeadConnector.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(HeadConnector, 0.36425021489121656F, 0.0F, 0.0F);
        this.Neck2 = new ModelRenderer(this, 85, 37);
        this.Neck2.setRotationPoint(0.0F, 0.5F, -7.0F);
        this.Neck2.addBox(-2.0F, -5.0F, -7.0F, 4, 8, 9, 0.0F);
        this.setRotateAngle(Neck2, 0.31869712141416456F, 0.0F, 0.0F);
        this.Tail4 = new ModelRenderer(this, 52, 21);
        this.Tail4.setRotationPoint(0.0F, 0.0F, 14.5F);
        this.Tail4.addBox(-1.5F, -3.0F, 0.0F, 3, 5, 18, 0.0F);
        this.setRotateAngle(Tail4, -0.091106186954104F, 0.0F, 0.0F);
        this.RFoot = new ModelRenderer(this, 76, 26);
        this.RFoot.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.RFoot.addBox(-2.5F, 0.0F, -4.0F, 4, 2, 9, 0.0F);
        this.LLeg2.addChild(this.LFoot);
        this.Body2.addChild(this.Neck1);
        this.Tail2.addChild(this.Tail3);
        this.HeadConnector.addChild(this.Head);
        this.RLeg1.addChild(this.RLeg2);
        this.Body2.addChild(this.RArm1);
        this.Head.addChild(this.Jaw);
        this.LArm1.addChild(this.LArm2);
        this.Body.addChild(this.Body2);
        this.Tail1.addChild(this.Tail2);
        this.Body.addChild(this.LLeg1);
        this.LLeg1.addChild(this.LLeg2);
        this.Body.addChild(this.RLeg1);
        this.Body2.addChild(this.LArm1);
        this.Head.addChild(this.Snout);
        this.Snout.addChild(this.RCrest);
        this.Snout.addChild(this.LCrest);
        this.Body.addChild(this.Tail1);
        this.RArm1.addChild(this.RArm2);
        this.Neck2.addChild(this.HeadConnector);
        this.Neck1.addChild(this.Neck2);
        this.Tail3.addChild(this.Tail4);
        this.RLeg2.addChild(this.RFoot);
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
            GlStateManager.translate(0.0F, 105.0F * f5, 0.0F);
            this.Body.render(f5);
            GlStateManager.popMatrix();
        } else {
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Body.offsetX, this.Body.offsetY, this.Body.offsetZ);
        GlStateManager.translate(this.Body.rotationPointX * f5, this.Body.rotationPointY * f5, this.Body.rotationPointZ * f5);
        GlStateManager.scale(1.37D, 1.4D, 1.33D);
        GlStateManager.translate(-this.Body.offsetX, -this.Body.offsetY, -this.Body.offsetZ);
        GlStateManager.translate(-this.Body.rotationPointX * f5, -this.Body.rotationPointY * f5, -this.Body.rotationPointZ * f5);
        this.Body.render(f5);
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
