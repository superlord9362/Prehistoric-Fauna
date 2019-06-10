package superlord.prehistoricfauna.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;

/**
 * Eusthenopteron - superlord9362
 * Created using Tabula 7.0.1
 */
public class Eusthenopteron extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape6;
    public ModelRenderer shape7;
    public ModelRenderer shape7_1;
    public ModelRenderer shape7_2;
    public ModelRenderer shape7_3;
    public ModelRenderer shape11;
    public ModelRenderer shape12;
    public ModelRenderer shape14;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape5;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public Eusthenopteron() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.shape2 = new ModelRenderer(this, 123, 0);
        this.shape2.setRotationPoint(1.0F, 0.0F, 3.0F);
        this.shape2.addBox(-2.0F, -2.5F, 0.0F, 4, 4, 10, 0.0F);
        this.shape4 = new ModelRenderer(this, 141, 0);
        this.shape4.setRotationPoint(-0.5F, -2.0F, 2.0F);
        this.shape4.addBox(0.0F, -6.0F, 0.0F, 1, 6, 3, 0.0F);
        this.setRotateAngle(shape4, -0.5009094953223726F, 0.0F, 0.0F);
        this.shape5 = new ModelRenderer(this, 0, 0);
        this.shape5.setRotationPoint(-0.5F, 0.5F, 5.0F);
        this.shape5.addBox(0.0F, 0.0F, -1.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(shape5, 0.4553564018453205F, 0.0F, 0.0F);
        this.shape7_1 = new ModelRenderer(this, 0, 0);
        this.shape7_1.setRotationPoint(-1.0F, 3.0F, 0.0F);
        this.shape7_1.addBox(-1.0F, -1.5F, 0.0F, 1, 2, 6, 0.0F);
        this.setRotateAngle(shape7_1, -0.22759093446006054F, 0.0F, 0.31869712141416456F);
        this.shape7_2 = new ModelRenderer(this, 0, 0);
        this.shape7_2.setRotationPoint(2.5F, 3.0F, 13.0F);
        this.shape7_2.addBox(0.0F, -1.8F, 0.0F, 1, 2, 5, 0.0F);
        this.setRotateAngle(shape7_2, -0.22759093446006054F, 0.0F, -0.31869712141416456F);
        this.shape7_3 = new ModelRenderer(this, 0, 0);
        this.shape7_3.setRotationPoint(-0.5F, 3.0F, 13.0F);
        this.shape7_3.addBox(-1.0F, -1.8F, 0.0F, 1, 2, 5, 0.0F);
        this.setRotateAngle(shape7_3, -0.22759093446006054F, 0.0F, 0.31869712141416456F);
        this.shape11 = new ModelRenderer(this, 69, 0);
        this.shape11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape11.addBox(-1.5F, -3.0F, -7.5F, 5, 4, 8, 0.0F);
        this.setRotateAngle(shape11, 0.091106186954104F, 0.0F, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 25);
        this.shape1.setRotationPoint(0.0F, 21.0F, -5.9F);
        this.shape1.addBox(-2.0F, -3.0F, 0.0F, 6, 6, 13, 0.0F);
        this.shape12 = new ModelRenderer(this, 95, 0);
        this.shape12.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.shape12.addBox(-1.0F, -1.0F, -7.0F, 4, 2, 7, 0.0F);
        this.setRotateAngle(shape12, -0.136659280431156F, 0.0F, 0.0F);
        this.shape3 = new ModelRenderer(this, 151, 0);
        this.shape3.setRotationPoint(1.0F, 0.0F, 10.0F);
        this.shape3.addBox(-1.0F, -7.0F, -2.0F, 0, 13, 9, 0.0F);
        this.setRotateAngle(shape3, 0.0F, 0.014660765716752367F, 0.0F);
        this.shape6 = new ModelRenderer(this, 0, 0);
        this.shape6.setRotationPoint(0.5F, -2.5F, 12.5F);
        this.shape6.addBox(0.0F, -4.0F, 0.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(shape6, -0.5009094953223726F, 0.0F, 0.0F);
        this.shape14 = new ModelRenderer(this, 117, 0);
        this.shape14.setRotationPoint(0.0F, 0.0F, 13.0F);
        this.shape14.addBox(-1.5F, -2.5F, 0.0F, 5, 5, 3, 0.0F);
        this.shape7 = new ModelRenderer(this, 0, 0);
        this.shape7.setRotationPoint(3.0F, 3.0F, 0.0F);
        this.shape7.addBox(0.0F, -1.5F, 0.0F, 1, 2, 6, 0.0F);
        this.setRotateAngle(shape7, -0.22759093446006054F, 0.0F, -0.31869712141416456F);
        this.shape14.addChild(this.shape2);
        this.shape2.addChild(this.shape4);
        this.shape2.addChild(this.shape5);
        this.shape1.addChild(this.shape7_1);
        this.shape1.addChild(this.shape7_2);
        this.shape1.addChild(this.shape7_3);
        this.shape1.addChild(this.shape11);
        this.shape1.addChild(this.shape12);
        this.shape2.addChild(this.shape3);
        this.shape1.addChild(this.shape6);
        this.shape1.addChild(this.shape14);
        this.shape1.addChild(this.shape7);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	 if (this.isChild) {
             GlStateManager.pushMatrix();
             GlStateManager.translate(0.0F, this.childYOffset * f5, this.childZOffset * f5);
             GlStateManager.popMatrix();
             GlStateManager.pushMatrix();
             GlStateManager.scale(0.2F, 0.2F, 0.2F);
             GlStateManager.translate(0.0F, 95.0F * f5, 0.0F);
             this.shape1.render(f5);
             GlStateManager.popMatrix();
         } else {
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.shape1.offsetX, this.shape1.offsetY, this.shape1.offsetZ);
        GlStateManager.translate(this.shape1.rotationPointX * f5, this.shape1.rotationPointY * f5, this.shape1.rotationPointZ * f5);
        GlStateManager.scale(0.69D, 0.69D, 0.69D);
        GlStateManager.translate(-this.shape1.offsetX, -this.shape1.offsetY, -this.shape1.offsetZ);
        GlStateManager.translate(-this.shape1.rotationPointX * f5, -this.shape1.rotationPointY * f5, -this.shape1.rotationPointZ * f5);
        this.shape1.render(f5);
        GlStateManager.popMatrix();
         }
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
    	this.shape14.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
        this.shape2.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
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
