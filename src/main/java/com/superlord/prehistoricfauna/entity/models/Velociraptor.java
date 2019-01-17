package com.superlord.prehistoricfauna.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * VelociraptorV2 - superlord9362
 * Created using Tabula 5.0.0
 */
public class Velociraptor extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape15;
    public ModelRenderer shape31;
    public ModelRenderer shape31_1;
    public ModelRenderer shape45;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape36;
    public ModelRenderer shape36_1;
    public ModelRenderer shape26;
    public ModelRenderer shape27;
    public ModelRenderer shape44;
    public ModelRenderer Head;
    public ModelRenderer shape29;
    public ModelRenderer shape30;
    public ModelRenderer shape32;
    public ModelRenderer shape33;
    public ModelRenderer shape35;
    public ModelRenderer shape34;
    public ModelRenderer shape32_1;
    public ModelRenderer shape33_1;
    public ModelRenderer shape35_1;
    public ModelRenderer shape34_1;
    public ModelRenderer LLeg;
    public ModelRenderer RLeg;
    public ModelRenderer shape6;
    public ModelRenderer shape7;
    public ModelRenderer shape11;
    public ModelRenderer shape12;
    public ModelRenderer shape13;
    public ModelRenderer shape14;
    public ModelRenderer shape6_1;
    public ModelRenderer shape7_1;
    public ModelRenderer shape11_1;
    public ModelRenderer shape12_1;
    public ModelRenderer shape13_1;
    public ModelRenderer shape14_1;

    protected float childYOffset = 8.0F;

    protected float childZOffset = 4.0F;

    public Velociraptor() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.shape12 = new ModelRenderer(this, 0, 14);
        this.shape12.setRotationPoint(0.0F, 1.0F, -1.0F);
        this.shape12.addBox(0.0F, -1.2F, -2.3F, 1, 2, 3, 0.0F);
        this.setRotateAngle(shape12, -1.1383037381507017F, 0.0F, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 17.3F, -4.0F);
        this.shape1.addBox(-4.0F, -5.0F, 0.0F, 8, 10, 20, 0.0F);
        this.setRotateAngle(shape1, -0.091106186954104F, 0.0F, 0.0F);
        this.shape13_1 = new ModelRenderer(this, 13, 0);
        this.shape13_1.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.shape13_1.addBox(0.0F, -1.2F, -1.9F, 1, 1, 2, 0.0F);
        this.setRotateAngle(shape13_1, 0.22759093446006054F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 182, 8);
        this.Head.setRotationPoint(0.0F, -1.0F, -2.8F);
        this.Head.addBox(-2.0F, -2.8F, -3.1F, 4, 5, 4, 0.0F);
        this.shape33 = new ModelRenderer(this, 149, 11);
        this.shape33.setRotationPoint(0.0F, 4.0F, 0.2F);
        this.shape33.addBox(-0.1F, 0.0F, 0.0F, 1, 7, 2, 0.0F);
        this.setRotateAngle(shape33, 0.9560913642424937F, 0.0F, 0.0F);
        this.shape4 = new ModelRenderer(this, 106, 0);
        this.shape4.setRotationPoint(0.0F, -1.0F, 15.0F);
        this.shape4.addBox(-1.0F, -1.0F, 0.0F, 2, 3, 23, 0.0F);
        this.setRotateAngle(shape4, -0.045553093477052F, 0.0F, 0.0F);
        this.shape27 = new ModelRenderer(this, 133, 7);
        this.shape27.setRotationPoint(0.0F, -0.1F, -6.5F);
        this.shape27.addBox(-1.5F, -2.8F, -3.3F, 3, 5, 5, 0.0F);
        this.setRotateAngle(shape27, 0.40980330836826856F, 0.0F, 0.0F);
        this.shape6_1 = new ModelRenderer(this, 114, 0);
        this.shape6_1.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.shape6_1.addBox(-2.5F, -1.0F, -0.5F, 3, 11, 3, 0.0F);
        this.setRotateAngle(shape6_1, -0.27314402793711257F, 0.0F, 0.0F);
        this.shape29 = new ModelRenderer(this, 166, 12);
        this.shape29.setRotationPoint(0.0F, -1.0F, -4.0F);
        this.shape29.addBox(-1.5F, -1.0F, -6.0F, 3, 3, 7, 0.0F);
        this.setRotateAngle(shape29, 0.18203784098300857F, 0.0F, 0.0F);
        this.shape34 = new ModelRenderer(this, 78, 22);
        this.shape34.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape34.addBox(0.0F, 1.0F, 0.0F, 1, 9, 5, 0.0F);
        this.setRotateAngle(shape34, 0.2897246558310587F, 0.0F, 0.0F);
        this.shape13 = new ModelRenderer(this, 65, 0);
        this.shape13.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.shape13.addBox(0.0F, -1.2F, -1.9F, 1, 1, 2, 0.0F);
        this.setRotateAngle(shape13, 0.22759093446006054F, 0.0F, 0.0F);
        this.shape14 = new ModelRenderer(this, 101, 0);
        this.shape14.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.shape14.addBox(0.0F, -1.6F, -0.2F, 1, 2, 1, 0.0F);
        this.setRotateAngle(shape14, -0.8651597102135892F, 0.0F, 0.0F);
        this.shape11 = new ModelRenderer(this, 144, 7);
        this.shape11.setRotationPoint(-1.0F, 0.0F, -2.0F);
        this.shape11.addBox(-2.0F, 0.0F, -2.0F, 3, 2, 2, 0.0F);
        this.shape32 = new ModelRenderer(this, 166, 0);
        this.shape32.setRotationPoint(0.0F, 4.0F, -1.5F);
        this.shape32.addBox(-0.1F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(shape32, 0.8689994345679766F, 0.0F, 0.0F);
        this.shape33_1 = new ModelRenderer(this, 186, 17);
        this.shape33_1.setRotationPoint(-1.0F, 4.0F, 0.2F);
        this.shape33_1.addBox(0.1F, 0.0F, 0.0F, 1, 7, 2, 0.0F);
        this.setRotateAngle(shape33_1, 0.9560913642424937F, 0.0F, 0.0F);
        this.RLeg = new ModelRenderer(this, 0, 0);
        this.RLeg.setRotationPoint(4.0F, 1.0F, 16.0F);
        this.RLeg.addBox(-3.0F, -3.0F, -3.0F, 4, 9, 5, 0.0F);
        this.shape45 = new ModelRenderer(this, 0, 0);
        this.shape45.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape45.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape45, 0.091106186954104F, 0.0F, 0.0F);
        this.LLeg = new ModelRenderer(this, 88, 0);
        this.LLeg.setRotationPoint(-2.0F, 1.0F, 16.0F);
        this.LLeg.addBox(-3.0F, -3.0F, -3.0F, 4, 9, 5, 0.0F);
        this.shape31_1 = new ModelRenderer(this, 58, 0);
        this.shape31_1.setRotationPoint(-4.0F, 3.0F, 5.5F);
        this.shape31_1.addBox(-1.0F, -1.0F, -1.5F, 2, 5, 3, 0.0F);
        this.setRotateAngle(shape31_1, -0.8651597102135892F, 0.0F, 0.0F);
        this.shape14_1 = new ModelRenderer(this, 0, 0);
        this.shape14_1.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.shape14_1.addBox(0.0F, -1.6F, -0.2F, 1, 2, 1, 0.0F);
        this.setRotateAngle(shape14_1, -0.8651597102135892F, 0.0F, 0.0F);
        this.shape7_1 = new ModelRenderer(this, 133, 0);
        this.shape7_1.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.shape7_1.addBox(-3.0F, 0.0F, -2.4F, 4, 2, 5, 0.0F);
        this.setRotateAngle(shape7_1, 0.27314402793711257F, 0.0F, 0.0F);
        this.shape31 = new ModelRenderer(this, 36, 0);
        this.shape31.setRotationPoint(4.0F, 3.0F, 5.5F);
        this.shape31.addBox(-1.0F, -1.0F, -1.5F, 2, 5, 3, 0.0F);
        this.setRotateAngle(shape31, -0.8651597102135892F, 0.0F, 0.0F);
        this.shape26 = new ModelRenderer(this, 166, 0);
        this.shape26.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.shape26.addBox(-1.5F, -3.4F, -6.0F, 3, 5, 7, 0.0F);
        this.setRotateAngle(shape26, -0.31869712141416456F, 0.0F, 0.0F);
        this.shape2 = new ModelRenderer(this, 36, 0);
        this.shape2.setRotationPoint(0.0F, 0.0F, 19.5F);
        this.shape2.addBox(-3.0F, -4.0F, 0.0F, 6, 6, 10, 0.0F);
        this.setRotateAngle(shape2, 0.091106186954104F, 0.0F, 0.0F);
        this.shape6 = new ModelRenderer(this, 56, 16);
        this.shape6.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.shape6.addBox(-2.5F, -1.0F, -0.5F, 3, 11, 3, 0.0F);
        this.setRotateAngle(shape6, -0.27314402793711257F, 0.0F, 0.0F);
        this.shape3 = new ModelRenderer(this, 91, 0);
        this.shape3.setRotationPoint(0.0F, -2.0F, 10.0F);
        this.shape3.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 15, 0.0F);
        this.shape35_1 = new ModelRenderer(this, 90, 19);
        this.shape35_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape35_1.addBox(-1.1F, -3.0F, -1.0F, 1, 7, 6, 0.0F);
        this.setRotateAngle(shape35_1, 0.20053833105414848F, 0.0F, 0.0F);
        this.shape11_1 = new ModelRenderer(this, 82, 0);
        this.shape11_1.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.shape11_1.addBox(-2.0F, 0.0F, -2.0F, 3, 2, 2, 0.0F);
        this.shape36_1 = new ModelRenderer(this, 44, 12);
        this.shape36_1.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.shape36_1.addBox(-3.95F, 0.0F, 0.0F, 5, 1, 24, 0.0F);
        this.setRotateAngle(shape36_1, 0.0F, 0.0F, -0.2897246558310587F);
        this.shape32_1 = new ModelRenderer(this, 78, 12);
        this.shape32_1.setRotationPoint(-1.0F, 4.0F, -1.5F);
        this.shape32_1.addBox(0.1F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(shape32_1, 0.8689994345679766F, 0.0F, 0.0F);
        this.shape7 = new ModelRenderer(this, 179, 0);
        this.shape7.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.shape7.addBox(-3.0F, 0.0F, -2.4F, 4, 2, 5, 0.0F);
        this.setRotateAngle(shape7, 0.27314402793711257F, 0.0F, 0.0F);
        this.shape15 = new ModelRenderer(this, 68, 0);
        this.shape15.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape15.addBox(-2.0F, -3.5F, -5.0F, 4, 6, 6, 0.0F);
        this.setRotateAngle(shape15, -0.27314402793711257F, 0.0F, 0.0F);
        this.shape44 = new ModelRenderer(this, 0, 0);
        this.shape44.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape44.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape44, 0.40980330836826856F, 0.0F, 0.0F);
        this.shape30 = new ModelRenderer(this, 78, 14);
        this.shape30.setRotationPoint(0.0F, 0.9F, -3.0F);
        this.shape30.addBox(-1.0F, 0.0F, -6.5F, 2, 1, 7, 0.0F);
        this.setRotateAngle(shape30, 0.045553093477052F, 0.0F, 0.0F);
        this.shape34_1 = new ModelRenderer(this, 78, 22);
        this.shape34_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape34_1.addBox(0.0F, 1.0F, 0.0F, 1, 9, 5, 0.0F);
        this.setRotateAngle(shape34_1, 0.2897246558310587F, 0.0F, 0.0F);
        this.shape36 = new ModelRenderer(this, 132, 2);
        this.shape36.setRotationPoint(1.0F, 0.0F, 0.0F);
        this.shape36.addBox(-1.05F, 0.0F, 0.0F, 5, 1, 24, 0.0F);
        this.setRotateAngle(shape36, 0.0F, 0.0F, 0.2897246558310587F);
        this.shape35 = new ModelRenderer(this, 90, 19);
        this.shape35.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape35.addBox(0.1F, -3.0F, -1.0F, 1, 7, 6, 0.0F);
        this.setRotateAngle(shape35, 0.20053833105414848F, 0.0F, 0.0F);
        this.shape12_1 = new ModelRenderer(this, 146, 0);
        this.shape12_1.setRotationPoint(-3.0F, 1.0F, -1.0F);
        this.shape12_1.addBox(0.0F, -1.2F, -2.3F, 1, 2, 3, 0.0F);
        this.setRotateAngle(shape12_1, -1.1383037381507017F, 0.0F, 0.0F);
        this.shape7.addChild(this.shape12);
        this.shape12_1.addChild(this.shape13_1);
        this.shape44.addChild(this.Head);
        this.shape31.addChild(this.shape33);
        this.shape3.addChild(this.shape4);
        this.shape26.addChild(this.shape27);
        this.RLeg.addChild(this.shape6_1);
        this.Head.addChild(this.shape29);
        this.shape32.addChild(this.shape34);
        this.shape12.addChild(this.shape13);
        this.shape13.addChild(this.shape14);
        this.shape7.addChild(this.shape11);
        this.shape31.addChild(this.shape32);
        this.shape31_1.addChild(this.shape33_1);
        this.shape45.addChild(this.RLeg);
        this.shape1.addChild(this.shape45);
        this.shape45.addChild(this.LLeg);
        this.shape1.addChild(this.shape31_1);
        this.shape13_1.addChild(this.shape14_1);
        this.shape6_1.addChild(this.shape7_1);
        this.shape1.addChild(this.shape31);
        this.shape15.addChild(this.shape26);
        this.shape1.addChild(this.shape2);
        this.LLeg.addChild(this.shape6);
        this.shape2.addChild(this.shape3);
        this.shape31_1.addChild(this.shape35_1);
        this.shape7_1.addChild(this.shape11_1);
        this.shape4.addChild(this.shape36_1);
        this.shape31_1.addChild(this.shape32_1);
        this.shape6.addChild(this.shape7);
        this.shape1.addChild(this.shape15);
        this.shape27.addChild(this.shape44);
        this.Head.addChild(this.shape30);
        this.shape32_1.addChild(this.shape34_1);
        this.shape4.addChild(this.shape36);
        this.shape31.addChild(this.shape35);
        this.shape7_1.addChild(this.shape12_1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        if (this.isChild) {

            float f6 = 2.0F;

            GlStateManager.pushMatrix();

            GlStateManager.translate(0.0F, this.childYOffset * f5, this.childZOffset * f5);

            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();

            GlStateManager.scale(0.05F, 0.05F, 0.05F);

            GlStateManager.translate(0.0F, 430.0F * f5, 0.0F);

            this.shape1.render(f5);

            GlStateManager.popMatrix();
        } else {
            GlStateManager.pushMatrix();
            GlStateManager.translate(this.shape1.offsetX, this.shape1.offsetY, this.shape1.offsetZ);
            GlStateManager.translate(this.shape1.rotationPointX * f5, this.shape1.rotationPointY * f5, this.shape1.rotationPointZ * f5);
            GlStateManager.scale(0.35D, 0.37D, 0.32D);
            GlStateManager.translate(-this.shape1.offsetX, -this.shape1.offsetY, -this.shape1.offsetZ);
            GlStateManager.translate(-this.shape1.rotationPointX * f5, -this.shape1.rotationPointY * f5, -this.shape1.rotationPointZ * f5);
            this.shape1.render(f5);
            GlStateManager.popMatrix();
        }
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        float XAngle = headPitch / 57.29578F;
        float YAngle = netHeadYaw / 57.29578F;
        this.Head.rotateAngleX = (0.2617794F + XAngle);
        this.Head.rotateAngleY = YAngle;
        this.RLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.LLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
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
