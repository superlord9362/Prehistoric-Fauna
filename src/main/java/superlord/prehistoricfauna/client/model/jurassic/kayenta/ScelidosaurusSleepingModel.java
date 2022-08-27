package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.ScelidosaurusEntity;

/**
 * ScelidosaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ScelidosaurusSleepingModel extends EntityModel<ScelidosaurusEntity> {
    public ModelRenderer LegRight;
    public ModelRenderer LegLeft;
    public ModelRenderer Body;
    public ModelRenderer Leg2Right;
    public ModelRenderer FootRight;
    public ModelRenderer Leg2Left;
    public ModelRenderer FootLeft;
    public ModelRenderer Tail;
    public ModelRenderer BodyOsteoderms;
    public ModelRenderer ArmRight;
    public ModelRenderer ArmLeft;
    public ModelRenderer Neck;
    public ModelRenderer Tail2;
    public ModelRenderer TailOsteoderms;
    public ModelRenderer Tail2Osteoderms;
    public ModelRenderer BodyOsteoderms_1;
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer part21;

    public ScelidosaurusSleepingModel() {
        this.textureWidth = 160;
        this.textureHeight = 75;
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 17.3F, 8.0F);
        this.Body.addBox(-4.5F, -4.0F, -19.0F, 9.0F, 10.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.BodyOsteoderms = new ModelRenderer(this, 71, 0);
        this.BodyOsteoderms.setRotationPoint(0.0F, -3.5F, 0.0F);
        this.BodyOsteoderms.addBox(-8.0F, 0.0F, -19.0F, 16.0F, 0.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.ArmLeft = new ModelRenderer(this, 28, 34);
        this.ArmLeft.mirror = true;
        this.ArmLeft.setRotationPoint(-6.0F, 3.0F, -16.0F);
        this.ArmLeft.addBox(-1.0F, 0.0F, -1.0F, 3.0F, 10.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmLeft, -1.407433498155583F, -0.5082398928281348F, 0.1563815016444822F);
        this.TailOsteoderms = new ModelRenderer(this, 104, 24);
        this.TailOsteoderms.setRotationPoint(0.0F, 0.2F, 8.0F);
        this.TailOsteoderms.addBox(-6.0F, 0.0F, -8.0F, 12.0F, 0.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 44);
        this.Head.setRotationPoint(0.0F, -0.5F, -5.0F);
        this.Head.addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, 0.35185837453889574F, 0.0F, 0.0F);
        this.part21 = new ModelRenderer(this, 15, 49);
        this.part21.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.part21.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 3.0F, 0.01F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 41, 2);
        this.Tail.setRotationPoint(0.0F, -3.5F, 3.0F);
        this.Tail.addBox(-2.5F, 0.0F, -1.0F, 5.0F, 5.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.3909537457888271F, 0.19547687289441354F, 0.03909537541112055F);
        this.Leg2Left = new ModelRenderer(this, 44, 47);
        this.Leg2Left.mirror = true;
        this.Leg2Left.setRotationPoint(-2.3F, 7.0F, 1.9F);
        this.Leg2Left.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg2Left, -0.9782570324270162F, 0.0F, 0.0F);
        this.Leg2Right = new ModelRenderer(this, 44, 47);
        this.Leg2Right.setRotationPoint(2.3F, 7.0F, 1.9F);
        this.Leg2Right.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg2Right, -1.0953686092568693F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 32);
        this.Neck.setRotationPoint(0.0F, 0.0F, -19.0F);
        this.Neck.addBox(-1.5F, -2.0F, -6.0F, 3.0F, 5.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.35185837453889574F, -0.19547687289441354F, 0.3127630032889644F);
        this.Tail2Osteoderms = new ModelRenderer(this, 67, 35);
        this.Tail2Osteoderms.setRotationPoint(0.0F, 0.4F, 6.0F);
        this.Tail2Osteoderms.addBox(-6.0F, 0.0F, -8.0F, 12.0F, 0.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.LegLeft = new ModelRenderer(this, 44, 33);
        this.LegLeft.mirror = true;
        this.LegLeft.setRotationPoint(-1.0F, 15.5F, 7.0F);
        this.LegLeft.addBox(-4.0F, 0.0F, -3.0F, 4.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegLeft, 0.0F, -0.03909537541112055F, 0.27366763203903305F);
        this.FootRight = new ModelRenderer(this, 43, 57);
        this.FootRight.setRotationPoint(0.0F, 4.5F, -0.3F);
        this.FootRight.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FootRight, 1.3685127304046198F, -0.4300491170387584F, -0.3127630032889644F);
        this.FootLeft = new ModelRenderer(this, 43, 57);
        this.FootLeft.mirror = true;
        this.FootLeft.setRotationPoint(-0.5F, 3.5F, -0.3F);
        this.FootLeft.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FootLeft, 1.0555751236166873F, 0.3909537457888271F, 0.1558579075294158F);
        this.ArmRight = new ModelRenderer(this, 28, 34);
        this.ArmRight.setRotationPoint(2.7F, 3.0F, -16.0F);
        this.ArmRight.addBox(0.0F, 0.0F, -1.0F, 3.0F, 10.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmRight, -1.2906709285865847F, 0.19547687289441354F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 64, 4);
        this.Tail2.setRotationPoint(0.0F, 0.5F, 10.0F);
        this.Tail2.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 3.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.1563815016444822F, 0.35185837453889574F, 0.0F);
        this.BodyOsteoderms_1 = new ModelRenderer(this, 111, 35);
        this.BodyOsteoderms_1.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.BodyOsteoderms_1.addBox(-1.0F, 0.0F, -18.0F, 2.0F, 2.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(BodyOsteoderms_1, 0.0F, 0.0F, 0.001745329278001762F);
        this.Snout = new ModelRenderer(this, 0, 52);
        this.Snout.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.Snout.addBox(-1.0F, -2.0F, -3.0F, 2.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LegRight = new ModelRenderer(this, 44, 33);
        this.LegRight.setRotationPoint(1.0F, 15.5F, 7.0F);
        this.LegRight.addBox(0.0F, 0.0F, -3.0F, 4.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegRight, -0.0781907508222411F, 0.0781907508222411F, -0.35185837453889574F);
        this.Body.addChild(this.BodyOsteoderms);
        this.Body.addChild(this.ArmLeft);
        this.Tail.addChild(this.TailOsteoderms);
        this.Neck.addChild(this.Head);
        this.Head.addChild(this.part21);
        this.Body.addChild(this.Tail);
        this.LegLeft.addChild(this.Leg2Left);
        this.LegRight.addChild(this.Leg2Right);
        this.Body.addChild(this.Neck);
        this.Tail2.addChild(this.Tail2Osteoderms);
        this.Leg2Right.addChild(this.FootRight);
        this.Leg2Left.addChild(this.FootLeft);
        this.Body.addChild(this.ArmRight);
        this.Tail.addChild(this.Tail2);
        this.BodyOsteoderms.addChild(this.BodyOsteoderms_1);
        this.Head.addChild(this.Snout);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body, this.LegLeft, this.LegRight).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(ScelidosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
