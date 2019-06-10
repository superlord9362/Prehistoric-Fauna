package superlord.prehistoricfauna.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;

/**
 * Ankylosaurus - superlord9362
 * Created using Tabula 7.0.1
 */
public class Ankylosaurus extends ModelBase {
    public ModelRenderer Body1;
    public ModelRenderer Body2;
    public ModelRenderer Neck1;
    public ModelRenderer shape31;
    public ModelRenderer Body3;
    public ModelRenderer RRLeg1;
    public ModelRenderer LRLeg1;
    public ModelRenderer Tail1;
    public ModelRenderer RRLeg2;
    public ModelRenderer RFoot;
    public ModelRenderer LRLeg2;
    public ModelRenderer LFoot;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer Club;
    public ModelRenderer Neck2;
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer Jaw;
    public ModelRenderer RTOrnament;
    public ModelRenderer RBOrnament;
    public ModelRenderer LTOrnament;
    public ModelRenderer LBOrnament;
    public ModelRenderer RFLeg1;
    public ModelRenderer LFLeg1;
    public ModelRenderer RFLeg2;
    public ModelRenderer LFLeg2;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public Ankylosaurus() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.Body2 = new ModelRenderer(this, 26, 0);
        this.Body2.setRotationPoint(0.0F, 0.9F, 8.4F);
        this.Body2.addBox(-9.0F, -7.3F, -0.9F, 18, 13, 20, 0.0F);
        this.Tail2 = new ModelRenderer(this, 0, 24);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 5.5F);
        this.Tail2.addBox(-2.5F, -1.5F, 0.0F, 5, 6, 9, 0.0F);
        this.setRotateAngle(Tail2, 0.01012290966156711F, 0.0F, 0.0F);
        this.Tail3 = new ModelRenderer(this, 110, 25);
        this.Tail3.setRotationPoint(0.5F, 0.6F, 8.5F);
        this.Tail3.addBox(-2.0F, -1.0F, 0.0F, 3, 4, 14, 0.0F);
        this.setRotateAngle(Tail3, 0.005061454830783555F, 0.0F, 0.0F);
        this.LTOrnament = new ModelRenderer(this, 176, 34);
        this.LTOrnament.setRotationPoint(-2.9F, -5.0F, -1.0F);
        this.LTOrnament.addBox(0.3F, 2.5F, -3.0F, 2, 2, 5, 0.0F);
        this.setRotateAngle(LTOrnament, 0.2919935838586513F, -0.40980330836826856F, 0.27314402793711257F);
        this.Jaw = new ModelRenderer(this, 130, 29);
        this.Jaw.setRotationPoint(0.5F, 2.5F, -4.8F);
        this.Jaw.addBox(-2.5F, -0.4F, -3.0F, 4, 1, 4, 0.0F);
        this.setRotateAngle(Jaw, 0.26529004630313807F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 98, 29);
        this.Snout.setRotationPoint(0.5F, -1.5F, -5.8F);
        this.Snout.addBox(-3.0F, -0.4F, -4.0F, 5, 4, 5, 0.0F);
        this.setRotateAngle(Snout, 0.41643555952584704F, 0.0F, 0.0F);
        this.LRLeg2 = new ModelRenderer(this, 138, 18);
        this.LRLeg2.setRotationPoint(0.0F, 5.0F, 0.6F);
        this.LRLeg2.addBox(-2.5F, -1.0F, -0.8F, 3, 7, 4, 0.0F);
        this.RTOrnament = new ModelRenderer(this, 168, 0);
        this.RTOrnament.setRotationPoint(2.9F, 0.0F, 1.0F);
        this.RTOrnament.addBox(-0.3F, -2.5F, -3.0F, 2, 2, 5, 0.0F);
        this.setRotateAngle(RTOrnament, 0.2792526803190927F, 0.40980330836826856F, -0.27314402793711257F);
        this.LFLeg1 = new ModelRenderer(this, 96, 0);
        this.LFLeg1.setRotationPoint(-6.0F, 2.4F, 0.8F);
        this.LFLeg1.addBox(-2.0F, 0.0F, -2.0F, 3, 7, 4, 0.0F);
        this.Club = new ModelRenderer(this, 144, 26);
        this.Club.setRotationPoint(-1.5F, -0.8F, 13.5F);
        this.Club.addBox(-2.0F, -0.5F, 0.0F, 6, 5, 10, 0.0F);
        this.setRotateAngle(Club, -0.06981317007977318F, 0.0F, 0.0F);
        this.Neck1 = new ModelRenderer(this, 110, 0);
        this.Neck1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Neck1.addBox(-4.5F, -3.5F, -4.0F, 9, 8, 4, 0.0F);
        this.LRLeg1 = new ModelRenderer(this, 102, 12);
        this.LRLeg1.setRotationPoint(-4.2F, 0.1F, 2.2F);
        this.LRLeg1.addBox(-3.0F, -4.0F, -2.5F, 4, 10, 7, 0.0F);
        this.RBOrnament = new ModelRenderer(this, 132, 0);
        this.RBOrnament.setRotationPoint(2.2F, 0.4F, -3.0F);
        this.RBOrnament.addBox(-4.0F, -2.0F, -2.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(RBOrnament, 0.8726646259971648F, -3.543018381548489F, 0.8726646259971648F);
        this.RFLeg1 = new ModelRenderer(this, 82, 0);
        this.RFLeg1.setRotationPoint(7.0F, 2.4F, 0.8F);
        this.RFLeg1.addBox(-2.0F, 0.0F, -2.0F, 3, 7, 4, 0.0F);
        this.LFoot = new ModelRenderer(this, 152, 18);
        this.LFoot.setRotationPoint(0.0F, 8.2F, -0.3F);
        this.LFoot.addBox(-3.0F, -2.5F, -2.2F, 4, 2, 6, 0.0F);
        this.RRLeg2 = new ModelRenderer(this, 124, 14);
        this.RRLeg2.setRotationPoint(0.0F, 5.0F, 0.6F);
        this.RRLeg2.addBox(-2.5F, -1.0F, -0.8F, 3, 7, 4, 0.0F);
        this.RFLeg2 = new ModelRenderer(this, 28, 33);
        this.RFLeg2.setRotationPoint(0.0F, 6.4F, -0.8F);
        this.RFLeg2.addBox(-2.05F, -1.0F, -1.5F, 3, 7, 4, 0.0F);
        this.setRotateAngle(RFLeg2, -0.5918411493512771F, 0.0F, 0.0F);
        this.RFoot = new ModelRenderer(this, 82, 11);
        this.RFoot.setRotationPoint(0.0F, 8.2F, -0.3F);
        this.RFoot.addBox(-3.0F, -2.5F, -2.2F, 4, 2, 6, 0.0F);
        this.Body3 = new ModelRenderer(this, 136, 0);
        this.Body3.setRotationPoint(0.0F, -0.3F, 16.0F);
        this.Body3.addBox(-6.0F, -6.2F, 0.0F, 12, 10, 8, 0.0F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, 5.7F, -18.0F);
        this.Body1.addBox(-7.0F, -5.0F, 0.0F, 14, 11, 9, 0.0F);
        this.Tail1 = new ModelRenderer(this, 167, 17);
        this.Tail1.setRotationPoint(0.0F, -3.5F, 7.0F);
        this.Tail1.addBox(-3.5F, -2.0F, -0.5F, 7, 8, 9, 0.0F);
        this.setRotateAngle(Tail1, -0.136659280431156F, 0.0F, 0.0F);
        this.shape31 = new ModelRenderer(this, 0, 0);
        this.shape31.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape31.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape31, 0.5918411493512771F, 0.0F, 0.0F);
        this.LBOrnament = new ModelRenderer(this, 96, 11);
        this.LBOrnament.setRotationPoint(-1.8F, -2.2F, -5.6F);
        this.LBOrnament.addBox(4.0F, 2.0F, -2.0F, 3, 2, 2, 0.0F);
        this.setRotateAngle(LBOrnament, -0.7504915783575618F, 3.543018381548489F, -0.8726646259971648F);
        this.Neck2 = new ModelRenderer(this, 56, 33);
        this.Neck2.setRotationPoint(0.0F, 0.0F, -4.1F);
        this.Neck2.addBox(-3.0F, -2.5F, -4.0F, 6, 6, 5, 0.0F);
        this.Head = new ModelRenderer(this, 78, 33);
        this.Head.setRotationPoint(0.0F, 0.0F, -4.2F);
        this.Head.addBox(-3.5F, -2.4F, -5.0F, 7, 6, 6, 0.0F);
        this.setRotateAngle(Head, 0.25446900494077324F, 0.0F, 0.0F);
        this.LFLeg2 = new ModelRenderer(this, 42, 33);
        this.LFLeg2.setRotationPoint(0.0F, 6.4F, -0.8F);
        this.LFLeg2.addBox(-1.95F, -1.0F, -1.5F, 3, 7, 4, 0.0F);
        this.setRotateAngle(LFLeg2, -0.5918411493512771F, 0.0F, 0.0F);
        this.RRLeg1 = new ModelRenderer(this, 176, 0);
        this.RRLeg1.setRotationPoint(6.3F, 0.0F, 2.2F);
        this.RRLeg1.addBox(-3.0F, -4.0F, -2.5F, 4, 10, 7, 0.0F);
        this.Body1.addChild(this.Body2);
        this.Tail1.addChild(this.Tail2);
        this.Tail2.addChild(this.Tail3);
        this.Head.addChild(this.LTOrnament);
        this.Head.addChild(this.Jaw);
        this.Head.addChild(this.Snout);
        this.LRLeg1.addChild(this.LRLeg2);
        this.Head.addChild(this.RTOrnament);
        this.shape31.addChild(this.LFLeg1);
        this.Tail3.addChild(this.Club);
        this.Body1.addChild(this.Neck1);
        this.Body3.addChild(this.LRLeg1);
        this.Head.addChild(this.RBOrnament);
        this.shape31.addChild(this.RFLeg1);
        this.LRLeg2.addChild(this.LFoot);
        this.RRLeg1.addChild(this.RRLeg2);
        this.RFLeg1.addChild(this.RFLeg2);
        this.RRLeg2.addChild(this.RFoot);
        this.Body2.addChild(this.Body3);
        this.Body3.addChild(this.Tail1);
        this.Body1.addChild(this.shape31);
        this.Head.addChild(this.LBOrnament);
        this.Neck1.addChild(this.Neck2);
        this.Neck2.addChild(this.Head);
        this.LFLeg1.addChild(this.LFLeg2);
        this.Body3.addChild(this.RRLeg1);
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
            GlStateManager.translate(0.0F, 28.0F * f5, 0.0F);
            this.Body1.render(f5);
            GlStateManager.popMatrix();
        }
        else
        {
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Body1.offsetX, this.Body1.offsetY, this.Body1.offsetZ);
        GlStateManager.translate(this.Body1.rotationPointX * f5, this.Body1.rotationPointY * f5, this.Body1.rotationPointZ * f5);
        GlStateManager.scale(1.35D, 1.35D, 1.15D);
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
    	this.RRLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.LRLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
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
