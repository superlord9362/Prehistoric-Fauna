package superlord.prehistoricfauna.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;

/**
 * Camarasaurus - superlord9362
 * Created using Tabula 5.0.0
 */
public class ModelCamarasaurus extends ModelBase {
    public ModelRenderer Body1;
    public ModelRenderer Body2;
    public ModelRenderer Neck1;
    public ModelRenderer shape27;
    public ModelRenderer Tail1;
    public ModelRenderer shape26;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer BLLeg1;
    public ModelRenderer BRLeg1;
    public ModelRenderer BLLeg2;
    public ModelRenderer LFoot;
    public ModelRenderer BRLeg2;
    public ModelRenderer RFoot;
    public ModelRenderer Neck2;
    public ModelRenderer Neck3;
    public ModelRenderer Neck4;
    public ModelRenderer shape28;
    public ModelRenderer Head;
    public ModelRenderer UJaw1;
    public ModelRenderer BJaw;
    public ModelRenderer UJaw2;
    public ModelRenderer FRLeg1;
    public ModelRenderer FLLeg1;
    public ModelRenderer FRLeg2;
    public ModelRenderer FLLeg2;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public ModelCamarasaurus() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.Tail1 = new ModelRenderer(this, 105, 24);
        this.Tail1.setRotationPoint(0.0F, -4.0F, 15.0F);
        this.Tail1.addBox(-4.0F, -3.9F, -0.8F, 8, 10, 11, 0.0F);
        this.setRotateAngle(Tail1, -0.091106186954104F, 0.0F, 0.0F);
        this.FLLeg2 = new ModelRenderer(this, 143, 34);
        this.FLLeg2.setRotationPoint(0.0F, 12.2F, 0.0F);
        this.FLLeg2.addBox(-3.0F, -0.8F, -2.1F, 4, 10, 5, 0.0F);
        this.setRotateAngle(FLLeg2, -0.18203784098300857F, 0.0F, 0.0F);
        this.shape27 = new ModelRenderer(this, 0, 0);
        this.shape27.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape27.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape27, 0.36425021489121656F, 0.0F, 0.0F);
        this.BRLeg2 = new ModelRenderer(this, 62, 0);
        this.BRLeg2.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.BRLeg2.addBox(-2.5F, 0.0F, -1.5F, 3, 10, 5, 0.0F);
        this.Body2 = new ModelRenderer(this, 64, 0);
        this.Body2.setRotationPoint(0.0F, 0.2F, 18.0F);
        this.Body2.addBox(-5.5F, -8.0F, 0.0F, 11, 16, 15, 0.0F);
        this.setRotateAngle(Body2, 0.091106186954104F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 50, 31);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 10.0F);
        this.Tail2.addBox(-3.0F, -3.0F, -0.5F, 6, 8, 14, 0.0F);
        this.setRotateAngle(Tail2, -0.091106186954104F, 0.0F, 0.0F);
        this.Neck4 = new ModelRenderer(this, 177, 39);
        this.Neck4.setRotationPoint(0.02F, 0.0F, -7.0F);
        this.Neck4.addBox(-2.0F, -3.5F, -5.0F, 4, 6, 7, 0.0F);
        this.setRotateAngle(Neck4, 0.4553564018453205F, 0.0F, 0.0F);
        this.shape28 = new ModelRenderer(this, 0, 0);
        this.shape28.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.shape28.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape28, 0.36425021489121656F, 0.0F, 0.0F);
        this.shape26 = new ModelRenderer(this, 0, 0);
        this.shape26.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape26.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape26, 0.091106186954104F, 0.0F, 0.0F);
        this.Neck2 = new ModelRenderer(this, 0, 36);
        this.Neck2.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.Neck2.addBox(-3.0F, -5.0F, -10.0F, 6, 8, 10, 0.0F);
        this.setRotateAngle(Neck2, -0.045553093477052F, 0.0F, 0.0F);
        this.UJaw1 = new ModelRenderer(this, 116, 0);
        this.UJaw1.setRotationPoint(0.0F, 0.0F, -3.4F);
        this.UJaw1.addBox(-2.0F, -3.0F, -2.0F, 4, 5, 2, 0.0F);
        this.setRotateAngle(UJaw1, 0.091106186954104F, 0.0F, 0.0F);
        this.LFoot = new ModelRenderer(this, 101, 0);
        this.LFoot.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.LFoot.addBox(-3.0F, -0.6F, -3.5F, 4, 2, 7, 0.0F);
        this.Tail3 = new ModelRenderer(this, 68, 31);
        this.Tail3.setRotationPoint(0.0F, 0.0F, 13.0F);
        this.Tail3.addBox(-2.0F, -2.0F, 0.0F, 4, 6, 22, 0.0F);
        this.setRotateAngle(Tail3, -0.045553093477052F, 0.0F, 0.0F);
        this.BRLeg1 = new ModelRenderer(this, 175, 12);
        this.BRLeg1.setRotationPoint(5.0F, -1.3F, 9.0F);
        this.BRLeg1.addBox(-3.0F, 0.0F, -3.0F, 4, 12, 7, 0.0F);
        this.Head = new ModelRenderer(this, 120, 45);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-2.5F, -3.2F, -3.7F, 5, 6, 5, 0.0F);
        this.Neck3 = new ModelRenderer(this, 32, 45);
        this.Neck3.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.Neck3.addBox(-2.0F, -4.0F, -7.0F, 4, 6, 8, 0.0F);
        this.setRotateAngle(Neck3, 0.091106186954104F, 0.0F, 0.0F);
        this.FRLeg1 = new ModelRenderer(this, 0, 0);
        this.FRLeg1.setRotationPoint(5.5F, 5.3F, 3.0F);
        this.FRLeg1.addBox(-3.0F, 0.0F, -2.0F, 4, 12, 5, 0.0F);
        this.RFoot = new ModelRenderer(this, 101, 0);
        this.RFoot.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.RFoot.addBox(-3.0F, -0.6F, -3.5F, 4, 2, 7, 0.0F);
        this.FRLeg2 = new ModelRenderer(this, 143, 34);
        this.FRLeg2.setRotationPoint(0.0F, 12.2F, 0.0F);
        this.FRLeg2.addBox(-3.0F, -0.8F, -2.1F, 4, 10, 5, 0.0F);
        this.setRotateAngle(FRLeg2, -0.18203784098300857F, 0.0F, 0.0F);
        this.BLLeg2 = new ModelRenderer(this, 62, 0);
        this.BLLeg2.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.BLLeg2.addBox(-2.5F, 0.0F, -1.5F, 3, 10, 5, 0.0F);
        this.BJaw = new ModelRenderer(this, 57, 0);
        this.BJaw.setRotationPoint(0.0F, 2.0F, -4.0F);
        this.BJaw.addBox(-1.5F, -0.2F, -1.7F, 3, 1, 2, 0.0F);
        this.setRotateAngle(BJaw, 0.045553093477052F, 0.0F, 0.0F);
        this.UJaw2 = new ModelRenderer(this, 146, 0);
        this.UJaw2.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.UJaw2.addBox(-2.0F, -2.0F, -1.0F, 4, 4, 1, 0.0F);
        this.Neck1 = new ModelRenderer(this, 116, 0);
        this.Neck1.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.Neck1.addBox(-4.0F, -6.0F, -11.0F, 8, 10, 14, 0.0F);
        this.setRotateAngle(Neck1, -0.5918411493512771F, 0.0F, 0.0F);
        this.BLLeg1 = new ModelRenderer(this, 175, 12);
        this.BLLeg1.setRotationPoint(-3.0F, -1.3F, 9.0F);
        this.BLLeg1.addBox(-3.0F, 0.0F, -3.0F, 4, 12, 7, 0.0F);
        this.FLLeg1 = new ModelRenderer(this, 0, 0);
        this.FLLeg1.setRotationPoint(-3.5F, 5.3F, 3.0F);
        this.FLLeg1.addBox(-3.0F, 0.0F, -2.0F, 4, 12, 5, 0.0F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, -44.5F, -22.0F);
        this.Body1.addBox(-6.0F, -8.0F, 0.0F, 12, 16, 20, 0.0F);
        this.setRotateAngle(Body1, -0.18203784098300857F, 0.0F, 0.0F);
        this.Body2.addChild(this.Tail1);
        this.FLLeg1.addChild(this.FLLeg2);
        this.Body1.addChild(this.shape27);
        this.BRLeg1.addChild(this.BRLeg2);
        this.Body1.addChild(this.Body2);
        this.Tail1.addChild(this.Tail2);
        this.Neck3.addChild(this.Neck4);
        this.Neck4.addChild(this.shape28);
        this.Body2.addChild(this.shape26);
        this.Neck1.addChild(this.Neck2);
        this.Head.addChild(this.UJaw1);
        this.BLLeg2.addChild(this.LFoot);
        this.Tail2.addChild(this.Tail3);
        this.shape26.addChild(this.BRLeg1);
        this.shape28.addChild(this.Head);
        this.Neck2.addChild(this.Neck3);
        this.shape27.addChild(this.FRLeg1);
        this.BRLeg2.addChild(this.RFoot);
        this.FRLeg1.addChild(this.FRLeg2);
        this.BLLeg1.addChild(this.BLLeg2);
        this.Head.addChild(this.BJaw);
        this.UJaw1.addChild(this.UJaw2);
        this.Body1.addChild(this.Neck1);
        this.shape26.addChild(this.BLLeg1);
        this.shape27.addChild(this.FLLeg1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float scale) { 
    	if (this.isChild)
        {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, this.childYOffset * scale, this.childZOffset * scale);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            GlStateManager.translate(0.0F, 65.0F * scale, 0.0F);
            this.Body1.render(scale);
            GlStateManager.popMatrix();
        }
        else
        {
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Body1.offsetX, this.Body1.offsetY, this.Body1.offsetZ);
        GlStateManager.translate(this.Body1.rotationPointX * scale, this.Body1.rotationPointY * scale, this.Body1.rotationPointZ * scale);
        GlStateManager.scale(3.0D, 2.65D, 2.7D);
        GlStateManager.translate(-this.Body1.offsetX, -this.Body1.offsetY, -this.Body1.offsetZ);
        GlStateManager.translate(-this.Body1.rotationPointX * scale, -this.Body1.rotationPointY * scale, -this.Body1.rotationPointZ * scale);
        this.Body1.render(scale);
        GlStateManager.popMatrix();
        }
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
    	float XAngle = headPitch / 57.29578F;
    	float YAngle = netHeadYaw / 57.29578F;
    	this.Head.rotateAngleX= (0.2617794F + XAngle);
    	this.Head.rotateAngleY= YAngle;
    	this.FRLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.FLLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.BRLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.BLLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
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
