package superlord.prehistoricfauna.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Triceratops - superlord9362
 * Created using Tabula 5.0.0
 */
public class Triceratops extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Body2;
    public ModelRenderer Neck1;
    public ModelRenderer shape49;
    public ModelRenderer Tail1;
    public ModelRenderer RLeg1;
    public ModelRenderer LLeg1;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer RLeg2;
    public ModelRenderer RFoot;
    public ModelRenderer LLeg2;
    public ModelRenderer LFoot;
    public ModelRenderer shape50;
    public ModelRenderer Neck2;
    public ModelRenderer Head;
    public ModelRenderer AFrill1;
    public ModelRenderer ASnout1;
    public ModelRenderer AMouth;
    public ModelRenderer ARHorn1;
    public ModelRenderer ALHorn1;
    public ModelRenderer JFrill1;
    public ModelRenderer HFrill1;
    public ModelRenderer HSnout1;
    public ModelRenderer HMouth;
    public ModelRenderer AFrill2;
    public ModelRenderer AFrill3;
    public ModelRenderer AJugal1;
    public ModelRenderer AJugal2;
    public ModelRenderer ASnout2;
    public ModelRenderer ANosehorn;
    public ModelRenderer ARHorn2;
    public ModelRenderer JRHorn2;
    public ModelRenderer ALHorn2;
    public ModelRenderer JLHorn2;
    public ModelRenderer JFrill2;
    public ModelRenderer JFrill3;
    public ModelRenderer JJugal1;
    public ModelRenderer JJugal2;
    public ModelRenderer HFrill2;
    public ModelRenderer HFrill3;
    public ModelRenderer HSnout2;
    public ModelRenderer HNasalhorn;
    public ModelRenderer FRLeg1;
    public ModelRenderer FLLeg1;
    public ModelRenderer FRLeg2;
    public ModelRenderer FLLeg2;

    protected float childYOffset = 8.0F;

    protected float childZOffset = 4.0F;

    public Triceratops() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.AFrill3 = new ModelRenderer(this, 48, 40);
        this.AFrill3.setRotationPoint(-3.0F, 0.0F, 0.0F);
        this.AFrill3.addBox(-6.0F, -9.0F, 0.0F, 6, 11, 1, 0.0F);
        this.setRotateAngle(AFrill3, 0.0F, 0.7285004297824331F, 0.0F);
        this.ALHorn1 = new ModelRenderer(this, 95, 0);
        this.ALHorn1.mirror = true;
        this.ALHorn1.setRotationPoint(-3.4F, -4.5F, -2.5F);
        this.ALHorn1.addBox(0.0F, -2.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(ALHorn1, 0.4886921905584123F, 0.0F, -0.24434609527920614F);
        this.LLeg2 = new ModelRenderer(this, 76, 26);
        this.LLeg2.setRotationPoint(0.0F, 11.0F, 4.0F);
        this.LLeg2.addBox(-4.0F, -1.0F, -3.0F, 4, 10, 4, 0.0F);
        this.setRotateAngle(LLeg2, 0.18203784098300857F, 0.0F, 0.0F);
        this.shape49 = new ModelRenderer(this, 0, 0);
        this.shape49.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape49.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape49, 0.4553564018453205F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 138, 0);
        this.Tail1.setRotationPoint(0.0F, 0.0F, 8.1F);
        this.Tail1.addBox(-4.0F, -5.0F, -0.5F, 8, 11, 4, 0.0F);
        this.setRotateAngle(Tail1, -0.18203784098300857F, 0.0F, 0.0F);
        this.LFoot = new ModelRenderer(this, 0, 32);
        this.LFoot.setRotationPoint(0.0F, 9.2F, 0.1F);
        this.LFoot.addBox(-4.5F, -2.0F, -5.0F, 5, 2, 6, 0.0F);
        this.ANosehorn = new ModelRenderer(this, 162, 0);
        this.ANosehorn.setRotationPoint(-1.0F, -1.0F, -8.0F);
        this.ANosehorn.addBox(0.0F, -3.0F, 0.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(ANosehorn, 0.8098327729253689F, 0.0F, 0.0F);
        this.AMouth = new ModelRenderer(this, 144, 37);
        this.AMouth.setRotationPoint(0.5F, 2.7F, -3.5F);
        this.AMouth.addBox(-2.5F, -0.5F, -7.0F, 4, 2, 7, 0.0F);
        this.setRotateAngle(AMouth, -0.045553093477052F, 0.0F, 0.0F);
        this.JFrill2 = new ModelRenderer(this, 129, 61);
        this.JFrill2.setRotationPoint(3.0F, 0.01F, 0.0F);
        this.JFrill2.addBox(0.0F, -9.0F, 0.0F, 6, 11, 1, 0.0F);
        this.setRotateAngle(JFrill2, 0.0F, -0.7285004297824331F, 0.0F);
        this.HSnout2 = new ModelRenderer(this, 58, 48);
        this.HSnout2.setRotationPoint(0.0F, 0.4F, -5.6F);
        this.HSnout2.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(HSnout2, 0.5009094953223726F, 0.0F, 0.0F);
        this.Tail3 = new ModelRenderer(this, 157, 21);
        this.Tail3.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.Tail3.addBox(-2.0F, -3.0F, -0.5F, 4, 5, 11, 0.0F);
        this.setRotateAngle(Tail3, 0.091106186954104F, 0.0F, 0.0F);
        this.ALHorn2 = new ModelRenderer(this, 157, 23);
        this.ALHorn2.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.ALHorn2.addBox(0.0F, -5.5F, -1.1F, 2, 6, 2, 0.0F);
        this.setRotateAngle(ALHorn2, 0.4553564018453205F, 0.0F, 0.0F);
        this.JLHorn2 = new ModelRenderer(this, 187, 29);
        this.JLHorn2.setRotationPoint(0.0F, -2.2F, 0.18F);
        this.JLHorn2.addBox(0.0F, -5.5F, -1.1F, 2, 6, 2, 0.0F);
        this.setRotateAngle(JLHorn2, -0.26354471705114374F, 0.0F, 0.0F);
        this.JJugal2 = new ModelRenderer(this, 162, 6);
        this.JJugal2.setRotationPoint(-1.7F, 4.2F, 1.7F);
        this.JJugal2.addBox(-3.0F, -1.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(JJugal2, 0.0F, -0.04537856055185257F, -0.4468042885105484F);
        this.HNasalhorn = new ModelRenderer(this, 190, 15);
        this.HNasalhorn.setRotationPoint(-1.0F, -0.3F, -6.1F);
        this.HNasalhorn.addBox(0.0F, -2.0F, 0.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(HNasalhorn, 0.6323327879975454F, 0.0F, 0.0F);
        this.JFrill3 = new ModelRenderer(this, 20, 47);
        this.JFrill3.setRotationPoint(-3.0F, 0.01F, 0.0F);
        this.JFrill3.addBox(-6.0F, -9.0F, 0.0F, 6, 11, 1, 0.0F);
        this.setRotateAngle(JFrill3, 0.0F, 0.7285004297824331F, 0.0F);
        this.FRLeg2 = new ModelRenderer(this, 74, 44);
        this.FRLeg2.setRotationPoint(-0.1F, 8.0F, 0.0F);
        this.FRLeg2.addBox(-2.0F, -0.4F, -1.87F, 3, 8, 4, 0.0F);
        this.setRotateAngle(FRLeg2, -0.593411945678072F, 0.0F, 0.0F);
        this.FRLeg1 = new ModelRenderer(this, 0, 0);
        this.FRLeg1.setRotationPoint(7.0F, 2.0F, 0.0F);
        this.FRLeg1.addBox(-2.0F, 0.0F, -2.0F, 3, 9, 4, 0.0F);
        this.ARHorn1 = new ModelRenderer(this, 58, 0);
        this.ARHorn1.setRotationPoint(1.4F, -5.1F, -2.5F);
        this.ARHorn1.addBox(0.0F, -2.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(ARHorn1, 0.4886921905584123F, 0.0F, 0.24434609527920614F);
        this.RLeg2 = new ModelRenderer(this, 60, 26);
        this.RLeg2.setRotationPoint(0.0F, 11.0F, 4.0F);
        this.RLeg2.addBox(-4.0F, -1.0F, -3.0F, 4, 10, 4, 0.0F);
        this.setRotateAngle(RLeg2, 0.18203784098300857F, 0.0F, 0.0F);
        this.Neck2 = new ModelRenderer(this, 22, 32);
        this.Neck2.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.Neck2.addBox(-3.0F, -4.5F, -7.0F, 6, 8, 7, 0.0F);
        this.setRotateAngle(Neck2, -0.091106186954104F, 0.0F, 0.0F);
        this.ASnout1 = new ModelRenderer(this, 120, 36);
        this.ASnout1.setRotationPoint(0.0F, -0.4F, -3.5F);
        this.ASnout1.addBox(-2.5F, -2.0F, -7.0F, 5, 5, 7, 0.0F);
        this.setRotateAngle(ASnout1, 0.045553093477052F, 0.0F, 0.0F);
        this.JFrill1 = new ModelRenderer(this, 166, 37);
        this.JFrill1.setRotationPoint(0.0F, -3.0F, 1.0F);
        this.JFrill1.addBox(-3.0F, -9.0F, 0.0F, 6, 9, 1, 0.0F);
        this.setRotateAngle(JFrill1, -0.8960520379738889F, 0.0F, 0.0F);
        this.Body2 = new ModelRenderer(this, 60, 0);
        this.Body2.setRotationPoint(0.0F, 0.0F, 16.0F);
        this.Body2.addBox(-6.0F, -7.0F, -2.5F, 12, 15, 11, 0.0F);
        this.setRotateAngle(Body2, -0.31869712141416456F, 0.0F, 0.0F);
        this.ARHorn2 = new ModelRenderer(this, 190, 7);
        this.ARHorn2.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.ARHorn2.addBox(0.0F, -5.5F, -1.1F, 2, 6, 2, 0.0F);
        this.setRotateAngle(ARHorn2, 0.4553564018453205F, 0.0F, 0.0F);
        this.FLLeg2 = new ModelRenderer(this, 109, 44);
        this.FLLeg2.setRotationPoint(0.1F, 8.0F, 0.0F);
        this.FLLeg2.addBox(-2.0F, -0.4F, -1.87F, 3, 8, 4, 0.0F);
        this.setRotateAngle(FLLeg2, -0.593411945678072F, 0.0F, 0.0F);
        this.RFoot = new ModelRenderer(this, 176, 21);
        this.RFoot.setRotationPoint(0.0F, 9.2F, 0.15F);
        this.RFoot.addBox(-4.5F, -2.0F, -5.0F, 5, 2, 6, 0.0F);
        this.ASnout2 = new ModelRenderer(this, 62, 40);
        this.ASnout2.setRotationPoint(0.0F, 0.6F, -7.0F);
        this.ASnout2.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(ASnout2, 0.5009094953223726F, 0.0F, 0.0F);
        this.JJugal1 = new ModelRenderer(this, 103, 3);
        this.JJugal1.setRotationPoint(1.7F, 4.2F, 1.7F);
        this.JJugal1.addBox(0.0F, -1.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(JJugal1, 0.0F, -0.04537856055185257F, 0.4468042885105484F);
        this.AFrill1 = new ModelRenderer(this, 113, 33);
        this.AFrill1.setRotationPoint(0.0F, -3.0F, 1.0F);
        this.AFrill1.addBox(-3.0F, -9.0F, 0.0F, 6, 9, 1, 0.0F);
        this.setRotateAngle(AFrill1, -1.0016444577195458F, 0.0F, 0.0F);
        this.Neck1 = new ModelRenderer(this, 106, 0);
        this.Neck1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Neck1.addBox(-5.0F, -6.0F, -4.0F, 10, 11, 6, 0.0F);
        this.setRotateAngle(Neck1, -0.31869712141416456F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 99, 19);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.Tail2.addBox(-3.0F, -4.0F, 0.0F, 6, 7, 7, 0.0F);
        this.setRotateAngle(Tail2, -0.136659280431156F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, -6.2F, -22.0F);
        this.Body.addBox(-7.0F, -8.0F, 0.0F, 14, 16, 16, 0.0F);
        this.setRotateAngle(Body, 0.136659280431156F, 0.0F, 0.0F);
        this.RLeg1 = new ModelRenderer(this, 162, 0);
        this.RLeg1.setRotationPoint(7.0F, -3.0F, 3.0F);
        this.RLeg1.addBox(-4.5F, -1.0F, -5.0F, 5, 12, 9, 0.0F);
        this.AFrill2 = new ModelRenderer(this, 180, 37);
        this.AFrill2.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.AFrill2.addBox(0.0F, -9.0F, 0.0F, 6, 11, 1, 0.0F);
        this.setRotateAngle(AFrill2, 0.0F, -0.7285004297824331F, 0.0F);
        this.AJugal1 = new ModelRenderer(this, 103, 0);
        this.AJugal1.setRotationPoint(1.0F, 5.0F, 1.0F);
        this.AJugal1.addBox(0.0F, -1.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(AJugal1, 0.0F, -0.04537856055185257F, 0.5916666164260777F);
        this.FLLeg1 = new ModelRenderer(this, 44, 0);
        this.FLLeg1.setRotationPoint(-6.0F, 2.0F, 0.0F);
        this.FLLeg1.addBox(-2.0F, 0.0F, -2.0F, 3, 9, 4, 0.0F);
        this.LLeg1 = new ModelRenderer(this, 129, 15);
        this.LLeg1.setRotationPoint(-3.0F, -3.0F, 3.0F);
        this.LLeg1.addBox(-4.5F, -1.0F, -5.0F, 5, 12, 9, 0.0F);
        this.HSnout1 = new ModelRenderer(this, 0, 40);
        this.HSnout1.setRotationPoint(0.0F, -1.0F, -2.0F);
        this.HSnout1.addBox(-2.5F, -2.0F, -6.0F, 5, 5, 5, 0.0F);
        this.setRotateAngle(HSnout1, 0.2762856205907024F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 85, 33);
        this.Head.setRotationPoint(0.0F, 0.0F, -7.0F);
        this.Head.addBox(-3.5F, -3.3F, -3.9F, 7, 8, 7, 0.0F);
        this.setRotateAngle(Head, 0.7285004297824331F, 0.0F, 0.0F);
        this.HMouth = new ModelRenderer(this, 148, 15);
        this.HMouth.setRotationPoint(0.5F, 2.7F, -1.9F);
        this.HMouth.addBox(-2.5F, -0.5F, -5.6F, 4, 2, 6, 0.0F);
        this.setRotateAngle(HMouth, 0.10437068926926091F, 0.0F, 0.0F);
        this.HFrill3 = new ModelRenderer(this, 160, 47);
        this.HFrill3.setRotationPoint(-3.0F, 0.01F, 0.0F);
        this.HFrill3.addBox(-5.0F, -6.0F, 0.0F, 5, 8, 1, 0.0F);
        this.setRotateAngle(HFrill3, 0.0F, 0.7285004297824331F, 0.0F);
        this.shape50 = new ModelRenderer(this, 0, 0);
        this.shape50.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape50.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(shape50, 0.091106186954104F, 0.0F, 0.0F);
        this.AJugal2 = new ModelRenderer(this, 132, 0);
        this.AJugal2.setRotationPoint(-1.0F, 5.0F, 1.0F);
        this.AJugal2.addBox(-3.0F, -1.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(AJugal2, 0.0F, -0.04537856055185257F, -0.5916666164260777F);
        this.JRHorn2 = new ModelRenderer(this, 118, 17);
        this.JRHorn2.setRotationPoint(0.0F, -2.2F, 0.18F);
        this.JRHorn2.addBox(0.0F, -5.5F, -1.1F, 2, 6, 2, 0.0F);
        this.setRotateAngle(JRHorn2, -0.26354471705114374F, 0.0F, 0.0F);
        this.HFrill2 = new ModelRenderer(this, 34, 47);
        this.HFrill2.setRotationPoint(3.0F, 0.01F, 0.0F);
        this.HFrill2.addBox(0.0F, -6.0F, 0.0F, 5, 8, 1, 0.0F);
        this.setRotateAngle(HFrill2, 0.0F, -0.7285004297824331F, 0.0F);
        this.HFrill1 = new ModelRenderer(this, 181, 0);
        this.HFrill1.setRotationPoint(0.0F, -3.0F, 1.0F);
        this.HFrill1.addBox(-3.0F, -6.0F, 0.0F, 6, 6, 1, 0.0F);
        this.setRotateAngle(HFrill1, -1.3203415791337103F, 0.0F, 0.0F);
        this.AFrill1.addChild(this.AFrill3);
        this.Head.addChild(this.ALHorn1);
        this.LLeg1.addChild(this.LLeg2);
        this.Body.addChild(this.shape49);
        this.Body2.addChild(this.Tail1);
        this.LLeg2.addChild(this.LFoot);
        this.ASnout1.addChild(this.ANosehorn);
        this.Head.addChild(this.AMouth);
        this.JFrill1.addChild(this.JFrill2);
        this.HSnout1.addChild(this.HSnout2);
        this.Tail2.addChild(this.Tail3);
        this.ALHorn1.addChild(this.ALHorn2);
        this.ALHorn1.addChild(this.JLHorn2);
        this.JFrill3.addChild(this.JJugal2);
        this.HSnout1.addChild(this.HNasalhorn);
        this.JFrill1.addChild(this.JFrill3);
        this.FRLeg1.addChild(this.FRLeg2);
        this.shape49.addChild(this.FRLeg1);
        this.Head.addChild(this.ARHorn1);
        this.RLeg1.addChild(this.RLeg2);
        this.shape50.addChild(this.Neck2);
        this.Head.addChild(this.ASnout1);
        this.Head.addChild(this.JFrill1);
        this.Body.addChild(this.Body2);
        this.ARHorn1.addChild(this.ARHorn2);
        this.FLLeg1.addChild(this.FLLeg2);
        this.RLeg2.addChild(this.RFoot);
        this.ASnout1.addChild(this.ASnout2);
        this.JFrill2.addChild(this.JJugal1);
        this.Head.addChild(this.AFrill1);
        this.Body.addChild(this.Neck1);
        this.Tail1.addChild(this.Tail2);
        this.Body2.addChild(this.RLeg1);
        this.AFrill1.addChild(this.AFrill2);
        this.AFrill2.addChild(this.AJugal1);
        this.shape49.addChild(this.FLLeg1);
        this.Body2.addChild(this.LLeg1);
        this.Head.addChild(this.HSnout1);
        this.Neck2.addChild(this.Head);
        this.Head.addChild(this.HMouth);
        this.HFrill1.addChild(this.HFrill3);
        this.Neck1.addChild(this.shape50);
        this.AFrill3.addChild(this.AJugal2);
        this.ARHorn1.addChild(this.JRHorn2);
        this.HFrill1.addChild(this.HFrill2);
        this.Head.addChild(this.HFrill1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float scale) {
        if (this.isChild) {

            float f6 = 2.0F;

            GlStateManager.pushMatrix();

            GlStateManager.translate(0.0F, this.childYOffset * scale, this.childZOffset * scale);

            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();

            GlStateManager.scale(0.5F, 0.5F, 0.5F);

            GlStateManager.translate(0.0F, 38.0F * scale, 0.0F);

            this.Body.render(scale);

            GlStateManager.popMatrix();
        } else {
            GlStateManager.pushMatrix();
            GlStateManager.translate(this.Body.offsetX, this.Body.offsetY, this.Body.offsetZ);
            GlStateManager.translate(this.Body.rotationPointX * scale, this.Body.rotationPointY * scale, this.Body.rotationPointZ * scale);
            GlStateManager.scale(1.85D, 1.8D, 1.9D);
            GlStateManager.translate(-this.Body.offsetX, -this.Body.offsetY, -this.Body.offsetZ);
            GlStateManager.translate(-this.Body.rotationPointX * scale, -this.Body.rotationPointY * scale, -this.Body.rotationPointZ * scale);
            this.Body.render(scale);
            GlStateManager.popMatrix();
        }
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        float XAngle = headPitch / 57.29578F;
        float YAngle = netHeadYaw / 57.29578F;
        this.Neck2.rotateAngleX = (0.2617794F + XAngle);
        this.Neck2.rotateAngleY = YAngle;
        this.FRLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.FLLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
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
