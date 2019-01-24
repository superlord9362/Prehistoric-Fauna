package superlord.prehistoricfauna.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Gallimimus - superlord9362
 * Created using Tabula 5.0.0
 */
public class Gallimimus extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Hips;
    public ModelRenderer Neck1;
    public ModelRenderer RArm1;
    public ModelRenderer LArm1;
    public ModelRenderer Tail1;
    public ModelRenderer RLeg1;
    public ModelRenderer LLeg1;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer TFan1;
    public ModelRenderer TFan2;
    public ModelRenderer RLeg2;
    public ModelRenderer RFoot;
    public ModelRenderer LLeg2;
    public ModelRenderer LLeg3;
    public ModelRenderer Neck2;
    public ModelRenderer Neck3;
    public ModelRenderer NeckHead;
    public ModelRenderer Head;
    public ModelRenderer UJaw1;
    public ModelRenderer UJaw2;
    public ModelRenderer LJaw;
    public ModelRenderer UJaw3;
    public ModelRenderer RArm2;
    public ModelRenderer RWing1;
    public ModelRenderer RWing2;
    public ModelRenderer LArm2;
    public ModelRenderer LWing1;
    public ModelRenderer LWing2;

    protected float childYOffset = 8.0F;

    protected float childZOffset = 4.0F;

    public Gallimimus() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.LLeg2 = new ModelRenderer(this, 96, 15);
        this.LLeg2.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.LLeg2.addBox(-2.5F, -1.0F, 0.0F, 3, 12, 3, 0.0F);
        this.setRotateAngle(LLeg2, -0.31869712141416456F, 0.0F, 0.0F);
        this.NeckHead = new ModelRenderer(this, 8, 58);
        this.NeckHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.NeckHead.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(NeckHead, -0.5009094953223726F, 0.0F, 0.0F);
        this.TFan2 = new ModelRenderer(this, 0, 21);
        this.TFan2.setRotationPoint(-0.1F, 0.0F, 0.0F);
        this.TFan2.addBox(-6.0F, 0.0F, -5.0F, 6, 1, 23, 0.0F);
        this.setRotateAngle(TFan2, -0.045553093477052F, 0.0F, -0.18203784098300857F);
        this.LLeg1 = new ModelRenderer(this, 128, 0);
        this.LLeg1.setRotationPoint(-2.0F, -3.0F, 9.0F);
        this.LLeg1.addBox(-3.0F, 0.0F, -2.5F, 4, 10, 5, 0.0F);
        this.RWing2 = new ModelRenderer(this, 47, 24);
        this.RWing2.setRotationPoint(0.0F, -1.0F, 0.5F);
        this.RWing2.addBox(-0.2F, 1.0F, -0.8F, 1, 8, 5, 0.0F);
        this.setRotateAngle(RWing2, -0.091106186954104F, 0.0F, 0.0F);
        this.LWing2 = new ModelRenderer(this, 71, 24);
        this.LWing2.setRotationPoint(-0.6F, -1.0F, 0.5F);
        this.LWing2.addBox(-0.2F, 1.0F, -0.8F, 1, 8, 5, 0.0F);
        this.setRotateAngle(LWing2, -0.091106186954104F, 0.0F, 0.0F);
        this.LWing1 = new ModelRenderer(this, 59, 24);
        this.LWing1.setRotationPoint(-0.6F, 7.0F, 0.0F);
        this.LWing1.addBox(-0.7F, -4.0F, -1.7F, 1, 9, 5, 0.0F);
        this.setRotateAngle(LWing1, -0.31869712141416456F, 0.0F, 0.0F);
        this.RLeg1 = new ModelRenderer(this, 110, 0);
        this.RLeg1.setRotationPoint(4.0F, -3.0F, 9.0F);
        this.RLeg1.addBox(-3.0F, 0.0F, -2.5F, 4, 10, 5, 0.0F);
        this.LLeg3 = new ModelRenderer(this, 176, 8);
        this.LLeg3.setRotationPoint(0.0F, 11.0F, 0.0F);
        this.LLeg3.addBox(-3.0F, 0.0F, -3.0F, 4, 2, 6, 0.0F);
        this.setRotateAngle(LLeg3, 0.31869712141416456F, 0.0F, 0.0F);
        this.Neck1 = new ModelRenderer(this, 28, 0);
        this.Neck1.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.Neck1.addBox(-3.0F, -4.0F, -4.0F, 6, 7, 5, 0.0F);
        this.setRotateAngle(Neck1, -0.136659280431156F, 0.0F, 0.0F);
        this.Neck3 = new ModelRenderer(this, 127, 21);
        this.Neck3.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.Neck3.addBox(-1.5F, -2.5F, -8.7F, 3, 3, 9, 0.0F);
        this.setRotateAngle(Neck3, -0.4553564018453205F, 0.0F, 0.0F);
        this.TFan1 = new ModelRenderer(this, 61, 15);
        this.TFan1.setRotationPoint(0.1F, 0.0F, 0.0F);
        this.TFan1.addBox(0.0F, 0.0F, -5.0F, 6, 1, 23, 0.0F);
        this.setRotateAngle(TFan1, -0.045553093477052F, 0.0F, 0.18203784098300857F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, -2.6F, -19.0F);
        this.Body.addBox(-4.0F, -5.0F, 0.0F, 8, 9, 12, 0.0F);
        this.setRotateAngle(Body, -0.091106186954104F, 0.0F, 0.0F);
        this.RWing1 = new ModelRenderer(this, 35, 24);
        this.RWing1.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.RWing1.addBox(-0.7F, -4.0F, -1.7F, 1, 9, 5, 0.0F);
        this.setRotateAngle(RWing1, -0.31869712141416456F, 0.0F, 0.0F);
        this.LJaw = new ModelRenderer(this, 103, 0);
        this.LJaw.setRotationPoint(0.0F, 0.0F, 0.3F);
        this.LJaw.addBox(-1.0F, -0.4F, 0.0F, 2, 5, 1, 0.0F);
        this.setRotateAngle(LJaw, -0.091106186954104F, 0.0F, 0.0F);
        this.RArm2 = new ModelRenderer(this, 14, 21);
        this.RArm2.setRotationPoint(-0.5F, 8.5F, -0.5F);
        this.RArm2.addBox(-1.0F, -0.5F, -1.5F, 2, 10, 2, 0.0F);
        this.setRotateAngle(RArm2, -1.0016444577195458F, 0.0F, 0.0F);
        this.LArm1 = new ModelRenderer(this, 71, 0);
        this.LArm1.setRotationPoint(-3.0F, 0.0F, 0.0F);
        this.LArm1.addBox(-1.5F, -0.2F, -1.9F, 2, 9, 2, 0.0F);
        this.setRotateAngle(LArm1, 1.0471975511965976F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 84, 0);
        this.Tail1.setRotationPoint(0.0F, 0.5F, 12.0F);
        this.Tail1.addBox(-3.0F, -5.5F, -0.5F, 6, 8, 7, 0.0F);
        this.setRotateAngle(Tail1, -0.136659280431156F, 0.0F, 0.0F);
        this.UJaw3 = new ModelRenderer(this, 123, 0);
        this.UJaw3.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.UJaw3.addBox(-1.5F, -0.1F, -0.4F, 3, 2, 1, 0.0F);
        this.setRotateAngle(UJaw3, -0.18203784098300857F, 0.0F, 0.0F);
        this.Hips = new ModelRenderer(this, 40, 0);
        this.Hips.setRotationPoint(0.0F, 0.0F, 11.0F);
        this.Hips.addBox(-4.5F, -5.5F, 0.0F, 9, 11, 13, 0.0F);
        this.setRotateAngle(Hips, 0.091106186954104F, 0.0F, 0.0F);
        this.RArm1 = new ModelRenderer(this, 0, 0);
        this.RArm1.setRotationPoint(4.0F, 0.0F, 0.0F);
        this.RArm1.addBox(-1.5F, -0.2F, -1.9F, 2, 9, 2, 0.0F);
        this.setRotateAngle(RArm1, 1.0471975511965976F, 0.0F, 0.0F);
        this.Neck2 = new ModelRenderer(this, 108, 15);
        this.Neck2.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.Neck2.addBox(-2.0F, -3.0F, -8.0F, 4, 4, 10, 0.0F);
        this.setRotateAngle(Neck2, -0.18203784098300857F, 0.0F, 0.0F);
        this.RLeg2 = new ModelRenderer(this, 154, 0);
        this.RLeg2.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.RLeg2.addBox(-2.5F, -1.0F, 0.0F, 3, 12, 3, 0.0F);
        this.setRotateAngle(RLeg2, -0.31869712141416456F, 0.0F, 0.0F);
        this.UJaw2 = new ModelRenderer(this, 45, 0);
        this.UJaw2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.UJaw2.addBox(-1.5F, 0.0F, -0.3F, 3, 3, 1, 0.0F);
        this.Tail2 = new ModelRenderer(this, 130, 0);
        this.Tail2.setRotationPoint(0.0F, -3.5F, 6.0F);
        this.Tail2.addBox(-2.0F, -1.0F, 0.0F, 4, 5, 16, 0.0F);
        this.setRotateAngle(Tail2, 0.091106186954104F, 0.0F, 0.0F);
        this.LArm2 = new ModelRenderer(this, 191, 23);
        this.LArm2.setRotationPoint(-0.5F, 8.5F, -0.5F);
        this.LArm2.addBox(-1.0F, -0.5F, -1.5F, 2, 10, 2, 0.0F);
        this.setRotateAngle(LArm2, -1.0016444577195458F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 21);
        this.Head.setRotationPoint(0.0F, 4.4F, -7.6F);
        this.Head.addBox(-2.0F, -2.6F, -1.4F, 4, 3, 3, 0.0F);
        this.Tail3 = new ModelRenderer(this, 153, 4);
        this.Tail3.setRotationPoint(0.0F, 0.0F, 15.0F);
        this.Tail3.addBox(-1.5F, -0.7F, -0.5F, 3, 4, 17, 0.0F);
        this.setRotateAngle(Tail3, 0.045553093477052F, 0.0F, 0.0F);
        this.RFoot = new ModelRenderer(this, 176, 0);
        this.RFoot.setRotationPoint(0.0F, 11.0F, 0.0F);
        this.RFoot.addBox(-3.0F, 0.0F, -3.0F, 4, 2, 6, 0.0F);
        this.setRotateAngle(RFoot, 0.31869712141416456F, 0.0F, 0.0F);
        this.UJaw1 = new ModelRenderer(this, 79, 0);
        this.UJaw1.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.UJaw1.addBox(-1.5F, 0.0F, 0.0F, 3, 5, 1, 0.0F);
        this.LLeg1.addChild(this.LLeg2);
        this.Neck3.addChild(this.NeckHead);
        this.Tail3.addChild(this.TFan2);
        this.Hips.addChild(this.LLeg1);
        this.RArm2.addChild(this.RWing2);
        this.LArm2.addChild(this.LWing2);
        this.LArm1.addChild(this.LWing1);
        this.Hips.addChild(this.RLeg1);
        this.LLeg2.addChild(this.LLeg3);
        this.Body.addChild(this.Neck1);
        this.Neck2.addChild(this.Neck3);
        this.Tail3.addChild(this.TFan1);
        this.RArm1.addChild(this.RWing1);
        this.Head.addChild(this.LJaw);
        this.RArm1.addChild(this.RArm2);
        this.Body.addChild(this.LArm1);
        this.Hips.addChild(this.Tail1);
        this.UJaw2.addChild(this.UJaw3);
        this.Body.addChild(this.Hips);
        this.Body.addChild(this.RArm1);
        this.Neck1.addChild(this.Neck2);
        this.RLeg1.addChild(this.RLeg2);
        this.Head.addChild(this.UJaw2);
        this.Tail1.addChild(this.Tail2);
        this.LArm1.addChild(this.LArm2);
        this.NeckHead.addChild(this.Head);
        this.Tail2.addChild(this.Tail3);
        this.RLeg2.addChild(this.RFoot);
        this.Head.addChild(this.UJaw1);
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

            GlStateManager.translate(0.0F, 100.0F * f5, 0.0F);

            this.Body.render(f5);

            GlStateManager.popMatrix();
        } else {
            GlStateManager.pushMatrix();
            GlStateManager.translate(this.Body.offsetX, this.Body.offsetY, this.Body.offsetZ);
            GlStateManager.translate(this.Body.rotationPointX * f5, this.Body.rotationPointY * f5, this.Body.rotationPointZ * f5);
            GlStateManager.scale(1.0D, 1.3D, 1.15D);
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
