package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.DilophosaurusEntity;

/**
 * DilophosaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class DilophosaurusSleepingModel extends EntityModel<DilophosaurusEntity> {
    public ModelRenderer Torso;
    public ModelRenderer Leg1Left;
    public ModelRenderer Leg1Right;
    public ModelRenderer Neck;
    public ModelRenderer Tail;
    public ModelRenderer ArmRight;
    public ModelRenderer ArmLeft;
    public ModelRenderer Head;
    public ModelRenderer QuillsNeck;
    public ModelRenderer QuillsHead;
    public ModelRenderer Jaw;
    public ModelRenderer Snout;
    public ModelRenderer Cheek;
    public ModelRenderer Waddle;
    public ModelRenderer Mouth;
    public ModelRenderer BottomTeeth;
    public ModelRenderer CrestLeft;
    public ModelRenderer CrestRight;
    public ModelRenderer Teeth;
    public ModelRenderer Tail2;
    public ModelRenderer Leg2Left;
    public ModelRenderer FootLeft;
    public ModelRenderer Leg2Right;
    public ModelRenderer FootRight;

    public DilophosaurusSleepingModel() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.ArmRight = new ModelRenderer(this, 40, 46);
        this.ArmRight.mirror = true;
        this.ArmRight.setRotationPoint(-3.0F, 2.0F, -23.0F);
        this.ArmRight.addBox(-4.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmRight, -0.03909537541112055F, -0.03909537541112055F, -0.23457224414434488F);
        this.Teeth = new ModelRenderer(this, 0, 113);
        this.Teeth.setRotationPoint(0.0F, 2.0F, 0.35F);
        this.Teeth.addBox(-1.5F, -2.0F, -8.0F, 3.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Leg2Left = new ModelRenderer(this, 72, 75);
        this.Leg2Left.setRotationPoint(2.5F, 11.0F, 5.0F);
        this.Leg2Left.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 15.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg2Left, -1.3685127304046198F, -1.7453292129831807E-4F, 0.4300491170387584F);
        this.Leg1Right = new ModelRenderer(this, 72, 49);
        this.Leg1Right.mirror = true;
        this.Leg1Right.setRotationPoint(-2.5F, 21.2F, 5.0F);
        this.Leg1Right.addBox(-4.0F, -3.0F, -5.0F, 6.0F, 16.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg1Right, 0.4300491170387584F, -0.11728612207217244F, -1.4467034063254554F);
        this.CrestLeft = new ModelRenderer(this, 0, 0);
        this.CrestLeft.setRotationPoint(0.8F, -2.0F, 1.0F);
        this.CrestLeft.addBox(0.0F, -6.0F, -8.0F, 1.0F, 6.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(CrestLeft, 0.0781907508222411F, 0.0781907508222411F, 0.0F);
        this.Leg2Right = new ModelRenderer(this, 72, 75);
        this.Leg2Right.setRotationPoint(-1.5F, 11.0F, 2.0F);
        this.Leg2Right.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 15.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg2Right, -0.4300491170387584F, -0.11728612207217244F, -0.19547687289441354F);
        this.FootRight = new ModelRenderer(this, 72, 94);
        this.FootRight.mirror = true;
        this.FootRight.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.FootRight.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FootRight, 2.0722294794824117F, 1.7453292129831807E-4F, 0.0373500478236019F);
        this.BottomTeeth = new ModelRenderer(this, 0, 132);
        this.BottomTeeth.setRotationPoint(0.0F, -2.4F, 0.4F);
        this.BottomTeeth.addBox(-1.0F, 0.0F, -8.0F, 2.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.ArmLeft = new ModelRenderer(this, 40, 46);
        this.ArmLeft.setRotationPoint(3.0F, 6.0F, -23.0F);
        this.ArmLeft.addBox(0.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmLeft, 0.2738421523142173F, 0.4300491170387584F, 0.7035422454473641F);
        this.Neck = new ModelRenderer(this, 0, 46);
        this.Neck.setRotationPoint(-1.0F, 1.0F, -24.0F);
        this.Neck.addBox(-2.0F, -14.0F, -6.0F, 4.0F, 17.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 1.6418312220247435F, 0.3122393925291412F, -0.23457224414434488F);
        this.CrestRight = new ModelRenderer(this, 0, 0);
        this.CrestRight.setRotationPoint(-0.8F, -2.0F, 1.0F);
        this.CrestRight.addBox(-1.0F, -6.0F, -8.0F, 1.0F, 6.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(CrestRight, 0.0781907508222411F, -0.0781907508222411F, 0.0F);
        this.Tail = new ModelRenderer(this, 50, 4);
        this.Tail.setRotationPoint(0.0F, -3.5F, 1.5F);
        this.Tail.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 9.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.27366763203903305F, -0.0781907508222411F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 81);
        this.Snout.setRotationPoint(0.0F, -2.0F, -6.0F);
        this.Snout.addBox(-2.0F, -2.0F, -8.0F, 4.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 70);
        this.Head.setRotationPoint(0.0F, -10.0F, -2.0F);
        this.Head.addBox(-2.5F, -5.0F, -6.0F, 5.0F, 5.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -0.0781907508222411F, 0.03874630989361682F, 0.19547687289441354F);
        this.QuillsHead = new ModelRenderer(this, 40, 90);
        this.QuillsHead.setRotationPoint(0.0F, -6.3F, -4.4F);
        this.QuillsHead.addBox(0.0F, -2.0F, 0.0F, 0.0F, 5.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw = new ModelRenderer(this, 0, 103);
        this.Jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Jaw.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Jaw, 0.010471975928084897F, 0.0F, 0.0F);
        this.Mouth = new ModelRenderer(this, 0, 93);
        this.Mouth.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.Mouth.addBox(-2.0F, 0.0F, -8.0F, 4.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 95, 3);
        this.Tail2.setRotationPoint(-0.5F, 0.5F, 15.0F);
        this.Tail2.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 47.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, -0.4300491170387584F, 0.19547687289441354F, -0.19547687289441354F);
        this.Cheek = new ModelRenderer(this, 24, 110);
        this.Cheek.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.Cheek.addBox(-1.5F, 0.0F, -6.0F, 3.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Leg1Left = new ModelRenderer(this, 72, 49);
        this.Leg1Left.setRotationPoint(0.5F, 17.0F, 7.0F);
        this.Leg1Left.addBox(-1.0F, -3.0F, -5.0F, 6.0F, 16.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg1Left, -0.1563815016444822F, -1.7453292129831807E-4F, -1.0555751236166873F);
        this.Waddle = new ModelRenderer(this, 22, 46);
        this.Waddle.setRotationPoint(0.0F, 2.0F, -4.0F);
        this.Waddle.addBox(-1.5F, 0.0F, -6.0F, 3.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Waddle, -0.23457224414434488F, 0.0F, 0.0F);
        this.Torso = new ModelRenderer(this, 0, 0);
        this.Torso.setRotationPoint(-3.0F, 19.0F, 9.0F);
        this.Torso.addBox(-4.0F, -4.0F, -27.0F, 8.0F, 14.0F, 32.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Torso, -0.11728612207217244F, -0.039269908169872414F, -1.2901473511162753F);
        this.QuillsNeck = new ModelRenderer(this, 40, 70);
        this.QuillsNeck.setRotationPoint(0.0F, -8.5F, -1.0F);
        this.QuillsNeck.addBox(0.0F, -9.0F, 0.0F, 0.0F, 9.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.FootLeft = new ModelRenderer(this, 72, 94);
        this.FootLeft.setRotationPoint(0.0F, 15.0F, 0.9F);
        this.FootLeft.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FootLeft, 1.8387043403444152F, -0.15725416959943073F, -0.1563815016444822F);
        this.Torso.addChild(this.ArmRight);
        this.Snout.addChild(this.Teeth);
        this.Leg1Left.addChild(this.Leg2Left);
        this.Snout.addChild(this.CrestLeft);
        this.Leg1Right.addChild(this.Leg2Right);
        this.Leg2Right.addChild(this.FootRight);
        this.Mouth.addChild(this.BottomTeeth);
        this.Torso.addChild(this.ArmLeft);
        this.Torso.addChild(this.Neck);
        this.Snout.addChild(this.CrestRight);
        this.Torso.addChild(this.Tail);
        this.Head.addChild(this.Snout);
        this.Neck.addChild(this.Head);
        this.Head.addChild(this.QuillsHead);
        this.Head.addChild(this.Jaw);
        this.Jaw.addChild(this.Mouth);
        this.Tail.addChild(this.Tail2);
        this.Jaw.addChild(this.Cheek);
        this.Jaw.addChild(this.Waddle);
        this.Neck.addChild(this.QuillsNeck);
        this.Leg2Left.addChild(this.FootLeft);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Leg1Right, this.Leg1Left, this.Torso).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(DilophosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
