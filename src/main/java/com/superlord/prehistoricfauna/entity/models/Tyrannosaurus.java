package com.superlord.prehistoricfauna.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * TyrannosaurusA - superlord9362 Created using Tabula 5.0.0
 */
public class Tyrannosaurus extends ModelBase {
    public ModelRenderer ABody1;
    public ModelRenderer JBody;
    public ModelRenderer ATail1;
    public ModelRenderer ABody2;
    public ModelRenderer shape46;
    public ModelRenderer ATail2;
    public ModelRenderer ATail3;
    public ModelRenderer ATail4;
    public ModelRenderer ARArm1;
    public ModelRenderer ALArm1;
    public ModelRenderer ANeck1;
    public ModelRenderer ARArm2;
    public ModelRenderer ALArm2;
    public ModelRenderer shape47;
    public ModelRenderer AHead;
    public ModelRenderer ASnout;
    public ModelRenderer AMouth;
    public ModelRenderer AHorn1;
    public ModelRenderer AHorn2;
    public ModelRenderer ARLeg1;
    public ModelRenderer ALLeg1;
    public ModelRenderer ARLeg2;
    public ModelRenderer ARFoot;
    public ModelRenderer ALLeg2;
    public ModelRenderer ALFoot1;
    public ModelRenderer JTail1;
    public ModelRenderer JRLeg1;
    public ModelRenderer JLLeg1;
    public ModelRenderer JNeck1;
    public ModelRenderer JTail2;
    public ModelRenderer JTail3;
    public ModelRenderer JTail4;
    public ModelRenderer JRLeg1_1;
    public ModelRenderer JRFoot;
    public ModelRenderer JLLeg2;
    public ModelRenderer JLFoot;
    public ModelRenderer JRArm1;
    public ModelRenderer JLArm1;
    public ModelRenderer JNeck2;
    public ModelRenderer JRArm2;
    public ModelRenderer JLArm2;
    public ModelRenderer shape48;
    public ModelRenderer JHead;
    public ModelRenderer JSnout;
    public ModelRenderer JMouth;
    public ModelRenderer JOrn1;
    public ModelRenderer JOrn2;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public Tyrannosaurus() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.ATail3 = new ModelRenderer(this, 58, 29);
        this.ATail3.setRotationPoint(0.0F, -1.5F, 9.0F);
        this.ATail3.addBox(-2.0F, -3.0F, 0.0F, 4, 6, 10, 0.0F);
        this.setRotateAngle(ATail3, 0.045553093477052F, 0.0F, 0.0F);
        this.ATail1 = new ModelRenderer(this, 122, 0);
        this.ATail1.setRotationPoint(0.0F, 0.0F, 21.5F);
        this.ATail1.addBox(-4.0F, -6.0F, 0.0F, 8, 10, 8, 0.0F);
        this.setRotateAngle(ATail1, -0.045553093477052F, 0.0F, 0.0F);
        this.ARFoot = new ModelRenderer(this, 86, 29);
        this.ARFoot.setRotationPoint(0.5F, 9.0F, 0.0F);
        this.ARFoot.addBox(-4.0F, -1.0F, -6.0F, 5, 3, 8, 0.0F);
        this.setRotateAngle(ARFoot, 0.136659280431156F, 0.0F, 0.0F);
        this.ATail2 = new ModelRenderer(this, 46, 0);
        this.ATail2.setRotationPoint(0.0F, 0.0F, 7.5F);
        this.ATail2.addBox(-3.0F, -5.0F, 0.0F, 6, 7, 9, 0.0F);
        this.setRotateAngle(ATail2, 0.091106186954104F, 0.0F, 0.0F);
        this.ALArm1 = new ModelRenderer(this, 67, 0);
        this.ALArm1.setRotationPoint(-5.5F, 2.0F, -3.0F);
        this.ALArm1.addBox(0.0F, 0.0F, -2.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(ALArm1, 0.9105382707654417F, 0.0F, 0.0F);
        this.JOrn2 = new ModelRenderer(this, 73, 0);
        this.JOrn2.setRotationPoint(-2.0F, 0.0F, -5.0F);
        this.JOrn2.addBox(0.6F, -3.2F, -0.1F, 1, 1, 1, 0.0F);
        this.setRotateAngle(JOrn2, -0.7285004297824331F, 0.0F, -0.27314402793711257F);
        this.ARArm2 = new ModelRenderer(this, 75, 0);
        this.ARArm2.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.ARArm2.addBox(0.0F, 0.0F, -2.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(ARArm2, -0.8651597102135892F, 0.0F, 0.0F);
        this.JTail2 = new ModelRenderer(this, 52, 45);
        this.JTail2.setRotationPoint(0.0F, -2.0F, 4.0F);
        this.JTail2.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 8, 0.0F);
        this.JLLeg1 = new ModelRenderer(this, 104, 43);
        this.JLLeg1.setRotationPoint(-3.0F, 0.0F, 15.0F);
        this.JLLeg1.addBox(-3.0F, -4.0F, -3.0F, 4, 13, 6, 0.0F);
        this.setRotateAngle(JLLeg1, 0.091106186954104F, 0.0F, 0.0F);
        this.JLLeg2 = new ModelRenderer(this, 186, 23);
        this.JLLeg2.setRotationPoint(0.0F, 8.0F, 2.0F);
        this.JLLeg2.addBox(-2.5F, 0.0F, -1.0F, 3, 11, 3, 0.0F);
        this.setRotateAngle(JLLeg2, -0.091106186954104F, 0.0F, 0.0F);
        this.JLFoot = new ModelRenderer(this, 0, 55);
        this.JLFoot.setRotationPoint(0.0F, 10.5F, 0.0F);
        this.JLFoot.addBox(-3.0F, 0.0F, -5.0F, 4, 2, 7, 0.0F);
        this.setRotateAngle(JLFoot, 0.091106186954104F, 0.0F, 0.0F);
        this.JLArm1 = new ModelRenderer(this, 154, 0);
        this.JLArm1.setRotationPoint(-5.5F, 2.0F, -1.0F);
        this.JLArm1.addBox(0.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(JLArm1, 1.1838568316277536F, 0.0F, 0.0F);
        this.JRArm1 = new ModelRenderer(this, 146, 0);
        this.JRArm1.setRotationPoint(3.5F, 2.0F, -1.0F);
        this.JRArm1.addBox(0.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(JRArm1, 1.1838568316277536F, 0.0F, 0.0F);
        this.JBody = new ModelRenderer(this, 68, 0);
        this.JBody.setRotationPoint(0.0F, -26.2F, -32.0F);
        this.JBody.addBox(-5.0F, -6.0F, 0.0F, 10, 12, 17, 0.0F);
        this.setRotateAngle(JBody, -0.091106186954104F, 0.0F, 0.0F);
        this.ATail4 = new ModelRenderer(this, 167, 27);
        this.ATail4.setRotationPoint(0.0F, 0.0F, 9.5F);
        this.ATail4.addBox(-1.5F, -2.0F, 0.0F, 3, 4, 13, 0.0F);
        this.setRotateAngle(ATail4, -0.091106186954104F, 0.0F, 0.0F);
        this.JLArm2 = new ModelRenderer(this, 76, 6);
        this.JLArm2.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.JLArm2.addBox(0.0F, -0.7F, -1.3F, 2, 5, 2, 0.0F);
        this.setRotateAngle(JLArm2, -0.8651597102135892F, 0.0F, 0.0F);
        this.JNeck1 = new ModelRenderer(this, 171, 44);
        this.JNeck1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.JNeck1.addBox(-4.0F, -4.5F, -3.0F, 8, 9, 4, 0.0F);
        this.setRotateAngle(JNeck1, -0.136659280431156F, 0.0F, 0.0F);
        this.ARLeg1 = new ModelRenderer(this, 154, 0);
        this.ARLeg1.setRotationPoint(6.0F, -4.0F, 15.0F);
        this.ARLeg1.addBox(-4.0F, 0.0F, -4.0F, 5, 13, 9, 0.0F);
        this.JTail4 = new ModelRenderer(this, 62, 53);
        this.JTail4.setRotationPoint(0.0F, 0.0F, 14.0F);
        this.JTail4.addBox(-1.5F, -2.0F, 0.0F, 3, 3, 18, 0.0F);
        this.ARArm1 = new ModelRenderer(this, 46, 0);
        this.ARArm1.setRotationPoint(4.5F, 2.0F, -3.0F);
        this.ARArm1.addBox(0.0F, 0.0F, -2.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(ARArm1, 0.9105382707654417F, 0.0F, 0.0F);
        this.ALLeg2 = new ModelRenderer(this, 105, 0);
        this.ALLeg2.setRotationPoint(-0.5F, 13.0F, 4.0F);
        this.ALLeg2.addBox(-3.0F, -1.0F, -2.0F, 4, 10, 4, 0.0F);
        this.setRotateAngle(ALLeg2, -0.136659280431156F, 0.0F, 0.0F);
        this.JHead = new ModelRenderer(this, 166, 57);
        this.JHead.setRotationPoint(0.0F, -5.4F, -7.5F);
        this.JHead.addBox(-2.5F, -2.4F, -3.1F, 5, 5, 5, 0.0F);
        this.JRArm2 = new ModelRenderer(this, 188, 0);
        this.JRArm2.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.JRArm2.addBox(0.0F, -0.7F, -1.3F, 2, 5, 2, 0.0F);
        this.setRotateAngle(JRArm2, -0.8651597102135892F, 0.0F, 0.0F);
        this.ABody2 = new ModelRenderer(this, 150, 22);
        this.ABody2.setRotationPoint(0.0F, 0.0F, 0.5F);
        this.ABody2.addBox(-4.0F, -6.5F, -6.0F, 9, 12, 6, 0.0F);
        this.setRotateAngle(ABody2, 0.045553093477052F, 0.0F, 0.0F);
        this.AHorn2 = new ModelRenderer(this, 12, 0);
        this.AHorn2.setRotationPoint(-3.0F, -4.0F, -1.0F);
        this.AHorn2.addBox(-0.3F, -0.4F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(AHorn2, 0.0F, 0.0F, 0.4553564018453205F);
        this.ALArm2 = new ModelRenderer(this, 121, 0);
        this.ALArm2.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.ALArm2.addBox(0.0F, 0.0F, -2.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(ALArm2, -0.8651597102135892F, 0.0F, 0.0F);
        this.ABody1 = new ModelRenderer(this, 0, 0);
        this.ABody1.setRotationPoint(0.0F, -22.0F, -34.0F);
        this.ABody1.addBox(-6.0F, -7.0F, 0.0F, 12, 14, 22, 0.0F);
        this.setRotateAngle(ABody1, -0.045553093477052F, 0.0F, 0.0F);
        this.JMouth = new ModelRenderer(this, 0, 14);
        this.JMouth.setRotationPoint(0.5F, 1.0F, -3.0F);
        this.JMouth.addBox(-2.0F, -0.5F, -4.5F, 3, 2, 5, 0.0F);
        this.setRotateAngle(JMouth, 0.091106186954104F, 0.0F, 0.0F);
        this.shape48 = new ModelRenderer(this, 0, 0);
        this.shape48.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape48.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape48, 0.6373942428283291F, 0.0F, 0.0F);
        this.ALFoot1 = new ModelRenderer(this, 104, 32);
        this.ALFoot1.setRotationPoint(0.5F, 9.0F, 0.0F);
        this.ALFoot1.addBox(-4.0F, -1.0F, -6.0F, 5, 3, 8, 0.0F);
        this.setRotateAngle(ALFoot1, 0.136659280431156F, 0.0F, 0.0F);
        this.AHead = new ModelRenderer(this, 36, 40);
        this.AHead.setRotationPoint(0.0F, -5.0F, -6.5F);
        this.AHead.addBox(-3.0F, -4.1F, -2.3F, 7, 8, 5, 0.0F);
        this.JTail3 = new ModelRenderer(this, 21, 53);
        this.JTail3.setRotationPoint(0.0F, 0.0F, 8.0F);
        this.JTail3.addBox(-2.0F, -2.5F, -0.5F, 4, 4, 15, 0.0F);
        this.setRotateAngle(JTail3, 0.045553093477052F, 0.0F, 0.0F);
        this.ALLeg1 = new ModelRenderer(this, 122, 18);
        this.ALLeg1.setRotationPoint(-3.0F, -4.0F, 15.0F);
        this.ALLeg1.addBox(-4.0F, 0.0F, -4.0F, 5, 13, 9, 0.0F);
        this.JRFoot = new ModelRenderer(this, 124, 54);
        this.JRFoot.setRotationPoint(0.0F, 10.5F, 0.0F);
        this.JRFoot.addBox(-3.0F, 0.0F, -5.0F, 4, 2, 7, 0.0F);
        this.setRotateAngle(JRFoot, 0.091106186954104F, 0.0F, 0.0F);
        this.JOrn1 = new ModelRenderer(this, 16, 0);
        this.JOrn1.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.JOrn1.addBox(0.4F, -3.6F, -0.4F, 1, 1, 1, 0.0F);
        this.setRotateAngle(JOrn1, -0.7285004297824331F, 0.0F, 0.27314402793711257F);
        this.JNeck2 = new ModelRenderer(this, 86, 53);
        this.JNeck2.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.JNeck2.addBox(-2.0F, -3.0F, -9.0F, 4, 6, 10, 0.0F);
        this.setRotateAngle(JNeck2, -0.27314402793711257F, 0.0F, 0.0F);
        this.shape46 = new ModelRenderer(this, 0, 0);
        this.shape46.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape46.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape46, 0.045553093477052F, 0.0F, 0.0F);
        this.AHorn1 = new ModelRenderer(this, 0, 0);
        this.AHorn1.setRotationPoint(4.0F, -4.0F, -1.0F);
        this.AHorn1.addBox(-0.7F, -0.4F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(AHorn1, 0.0F, 0.0F, -0.4553564018453205F);
        this.JSnout = new ModelRenderer(this, 16, 58);
        this.JSnout.setRotationPoint(-1.0F, 0.0F, -3.0F);
        this.JSnout.addBox(-1.0F, -2.0F, -5.0F, 4, 3, 6, 0.0F);
        this.setRotateAngle(JSnout, 0.091106186954104F, 0.0F, 0.0F);
        this.ARLeg2 = new ModelRenderer(this, 0, 0);
        this.ARLeg2.setRotationPoint(-0.5F, 13.0F, 4.0F);
        this.ARLeg2.addBox(-3.0F, -1.0F, -2.0F, 4, 10, 4, 0.0F);
        this.setRotateAngle(ARLeg2, -0.136659280431156F, 0.0F, 0.0F);
        this.JRLeg1 = new ModelRenderer(this, 151, 40);
        this.JRLeg1.setRotationPoint(5.0F, 0.0F, 15.0F);
        this.JRLeg1.addBox(-3.0F, -4.0F, -3.0F, 4, 13, 6, 0.0F);
        this.setRotateAngle(JRLeg1, 0.091106186954104F, 0.0F, 0.0F);
        this.JRLeg1_1 = new ModelRenderer(this, 182, 9);
        this.JRLeg1_1.setRotationPoint(0.0F, 8.0F, 2.0F);
        this.JRLeg1_1.addBox(-2.5F, 0.0F, -1.0F, 3, 11, 3, 0.0F);
        this.setRotateAngle(JRLeg1_1, -0.091106186954104F, 0.0F, 0.0F);
        this.JTail1 = new ModelRenderer(this, 125, 40);
        this.JTail1.setRotationPoint(0.0F, 0.0F, 17.0F);
        this.JTail1.addBox(-4.0F, -5.5F, -0.5F, 8, 9, 5, 0.0F);
        this.setRotateAngle(JTail1, 0.045553093477052F, 0.0F, 0.0F);
        this.ANeck1 = new ModelRenderer(this, 0, 36);
        this.ANeck1.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.ANeck1.addBox(-2.5F, -5.0F, -8.0F, 6, 7, 12, 0.0F);
        this.setRotateAngle(ANeck1, -0.5462880558742251F, 0.0F, 0.0F);
        this.shape47 = new ModelRenderer(this, 0, 0);
        this.shape47.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape47.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape47, 0.5918411493512771F, 0.0F, 0.0F);
        this.ASnout = new ModelRenderer(this, 78, 40);
        this.ASnout.setRotationPoint(0.0F, -2.0F, -2.0F);
        this.ASnout.addBox(-2.0F, -1.5F, -8.0F, 5, 5, 8, 0.0F);
        this.setRotateAngle(ASnout, 0.091106186954104F, 0.0F, 0.0F);
        this.AMouth = new ModelRenderer(this, 173, 0);
        this.AMouth.setRotationPoint(0.0F, 2.0F, -2.0F);
        this.AMouth.addBox(-1.5F, -0.5F, -7.0F, 4, 2, 7, 0.0F);
        this.setRotateAngle(AMouth, 0.045553093477052F, 0.0F, 0.0F);
        this.ATail2.addChild(this.ATail3);
        this.ABody1.addChild(this.ATail1);
        this.ARLeg2.addChild(this.ARFoot);
        this.ATail1.addChild(this.ATail2);
        this.ABody2.addChild(this.ALArm1);
        this.JHead.addChild(this.JOrn2);
        this.ARArm1.addChild(this.ARArm2);
        this.JTail1.addChild(this.JTail2);
        this.JBody.addChild(this.JLLeg1);
        this.JLLeg1.addChild(this.JLLeg2);
        this.JLLeg2.addChild(this.JLFoot);
        this.JNeck1.addChild(this.JLArm1);
        this.JNeck1.addChild(this.JRArm1);
        this.ATail3.addChild(this.ATail4);
        this.JLArm1.addChild(this.JLArm2);
        this.JBody.addChild(this.JNeck1);
        this.shape46.addChild(this.ARLeg1);
        this.JTail3.addChild(this.JTail4);
        this.ABody2.addChild(this.ARArm1);
        this.ALLeg1.addChild(this.ALLeg2);
        this.shape48.addChild(this.JHead);
        this.JRArm1.addChild(this.JRArm2);
        this.ABody1.addChild(this.ABody2);
        this.AHead.addChild(this.AHorn2);
        this.ALArm1.addChild(this.ALArm2);
        this.JHead.addChild(this.JMouth);
        this.JNeck2.addChild(this.shape48);
        this.ALLeg2.addChild(this.ALFoot1);
        this.shape47.addChild(this.AHead);
        this.JTail2.addChild(this.JTail3);
        this.shape46.addChild(this.ALLeg1);
        this.JRLeg1_1.addChild(this.JRFoot);
        this.JHead.addChild(this.JOrn1);
        this.JNeck1.addChild(this.JNeck2);
        this.ABody1.addChild(this.shape46);
        this.AHead.addChild(this.AHorn1);
        this.JHead.addChild(this.JSnout);
        this.ARLeg1.addChild(this.ARLeg2);
        this.JBody.addChild(this.JRLeg1);
        this.JRLeg1.addChild(this.JRLeg1_1);
        this.JBody.addChild(this.JTail1);
        this.ABody2.addChild(this.ANeck1);
        this.ANeck1.addChild(this.shape47);
        this.AHead.addChild(this.ASnout);
        this.AHead.addChild(this.AMouth);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        if (this.isChild) {

            float f6 = 2.0F;

            GlStateManager.pushMatrix();

            GlStateManager.translate(0.0F, this.childYOffset * f5, this.childZOffset * f5);

            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();

            GlStateManager.scale(0.5F, 0.5F, 0.5F);

            GlStateManager.translate(0.0F, 53.0F * f5, 0.0F);

            this.JBody.render(f5);

            GlStateManager.popMatrix();
        } else {
            GlStateManager.pushMatrix();
            GlStateManager.translate(this.JBody.offsetX, this.JBody.offsetY, this.JBody.offsetZ);
            GlStateManager.translate(this.JBody.rotationPointX * f5, this.JBody.rotationPointY * f5,
                    this.JBody.rotationPointZ * f5);
            GlStateManager.scale(2.1D, 2.3D, 2.3D);
            GlStateManager.translate(-this.JBody.offsetX, -this.JBody.offsetY, -this.JBody.offsetZ);
            GlStateManager.translate(-this.JBody.rotationPointX * f5, -this.JBody.rotationPointY * f5,
                    -this.JBody.rotationPointZ * f5);
            this.JBody.render(f5);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.translate(this.ABody1.offsetX, this.ABody1.offsetY, this.ABody1.offsetZ);
            GlStateManager.translate(this.ABody1.rotationPointX * f5, this.ABody1.rotationPointY * f5,
                    this.ABody1.rotationPointZ * f5);
            GlStateManager.scale(2.3D, 2.3D, 2.3D);
            GlStateManager.translate(-this.ABody1.offsetX, -this.ABody1.offsetY, -this.ABody1.offsetZ);
            GlStateManager.translate(-this.ABody1.rotationPointX * f5, -this.ABody1.rotationPointY * f5,
                    -this.ABody1.rotationPointZ * f5);
            this.ABody1.render(f5);
            GlStateManager.popMatrix();
        }
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                                  float headPitch, float scaleFactor, Entity entity) {
        float XAngle = headPitch / 57.29578F;
        float YAngle = netHeadYaw / 57.29578F;
        this.AHead.rotateAngleX = (0.2617794F + XAngle);
        this.AHead.rotateAngleY = YAngle;
        this.JHead.rotateAngleX = (0.2617794F + XAngle);
        this.JHead.rotateAngleY = YAngle;
        this.ARLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.ALLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.JLLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.JRLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
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
