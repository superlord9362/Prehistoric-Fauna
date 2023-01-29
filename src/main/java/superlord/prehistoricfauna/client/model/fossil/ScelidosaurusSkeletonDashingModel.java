package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.ScelidosaurusSkeletonEntity;

/**
 * ScelidosaurusSkeleton - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ScelidosaurusSkeletonDashingModel extends EntityModel<ScelidosaurusSkeletonEntity> {
    public ModelRenderer LegRight;
    public ModelRenderer LegLeft;
    public ModelRenderer Body;
    public ModelRenderer Leg2Right;
    public ModelRenderer part24;
    public ModelRenderer FootRight;
    public ModelRenderer Leg2Left;
    public ModelRenderer part24_1;
    public ModelRenderer FootLeft;
    public ModelRenderer ArmRight;
    public ModelRenderer Tail;
    public ModelRenderer Neck;
    public ModelRenderer ArmLeft;
    public ModelRenderer Body_1;
    public ModelRenderer Body_2;
    public ModelRenderer Body_3;
    public ModelRenderer part23;
    public ModelRenderer Tail_1;
    public ModelRenderer part25;
    public ModelRenderer Tail2;
    public ModelRenderer Tail2_1;
    public ModelRenderer part27;
    public ModelRenderer part28;
    public ModelRenderer part31;
    public ModelRenderer part26;
    public ModelRenderer part30;
    public ModelRenderer Head;
    public ModelRenderer Neck_1;
    public ModelRenderer Neck_2;
    public ModelRenderer Snout;
    public ModelRenderer part21;
    public ModelRenderer part23_1;
    public ModelRenderer part22;
    public ModelRenderer part29;

    public ScelidosaurusSkeletonDashingModel() {
        this.textureWidth = 160;
        this.textureHeight = 150;
        this.LegLeft = new ModelRenderer(this, 44, 33);
        this.LegLeft.mirror = true;
        this.LegLeft.setRotationPoint(-4.0F, 10.5F, 8.0F);
        this.LegLeft.addBox(-2.0F, 0.0F, -3.0F, 4.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegLeft, 0.0F, 0.3141592653589793F, 0.0F);
        this.Tail = new ModelRenderer(this, 44, 5);
        this.Tail.setRotationPoint(0.0F, -2.0F, 3.0F);
        this.Tail.addBox(-2.5F, 0.0F, 0.0F, 5.0F, 0.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, 0.0F, -0.17453292519943295F, 0.0F);
        this.Leg2Right = new ModelRenderer(this, 44, 47);
        this.Leg2Right.setRotationPoint(0.4F, 7.5F, 3.5F);
        this.Leg2Right.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg2Right, -0.5235987755982988F, 0.0F, 0.0F);
        this.Tail_1 = new ModelRenderer(this, 49, 5);
        this.Tail_1.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.Tail_1.addBox(0.0F, -1.0F, 0.0F, 0.0F, 5.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.part22 = new ModelRenderer(this, 71, 75);
        this.part22.setRotationPoint(-0.5F, 0.5F, -19.0F);
        this.part22.addBox(-8.0F, 0.0F, 0.0F, 16.0F, 0.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.part21 = new ModelRenderer(this, 14, 48);
        this.part21.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.part21.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 4.0F, 0.01F, 0.0F, 0.0F);
        this.FootLeft = new ModelRenderer(this, 42, 57);
        this.FootLeft.mirror = true;
        this.FootLeft.setRotationPoint(0.0F, 5.9F, -1.5F);
        this.FootLeft.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.part25 = new ModelRenderer(this, 43, 78);
        this.part25.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.part25.addBox(-2.5F, 0.0F, 0.0F, 5.0F, 3.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.part31 = new ModelRenderer(this, 122, 20);
        this.part31.setRotationPoint(-0.5F, -0.5F, 0.0F);
        this.part31.addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 12.0F, 8.0F);
        this.Body.addBox(-4.5F, -3.0F, -19.0F, 9.0F, 10.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, -0.2617993877991494F, 0.0F, 0.0F);
        this.part27 = new ModelRenderer(this, 25, 127);
        this.part27.setRotationPoint(-0.5F, -0.5F, 1.0F);
        this.part27.addBox(-1.0F, 0.0F, 0.0F, 3.0F, 2.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.Neck_2 = new ModelRenderer(this, 0, 32);
        this.Neck_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Neck_2.addBox(-1.5F, -2.0F, -6.0F, 3.0F, 1.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.part26 = new ModelRenderer(this, 106, 99);
        this.part26.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.part26.addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(part26, 0.0F, 0.0F, 0.001745329278001762F);
        this.Snout = new ModelRenderer(this, 0, 52);
        this.Snout.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.Snout.addBox(-1.0F, -2.0F, -3.0F, 2.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.ArmRight = new ModelRenderer(this, 28, 34);
        this.ArmRight.setRotationPoint(5.0F, 2.0F, -16.0F);
        this.ArmRight.addBox(-2.0F, 0.0F, -1.0F, 3.0F, 10.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmRight, 0.6108652381980153F, 0.17453292519943295F, 0.3490658503988659F);
        this.part29 = new ModelRenderer(this, 111, 39);
        this.part29.setRotationPoint(-1.5F, -5.0F, -18.0F);
        this.part29.addBox(0.0F, 0.0F, 0.0F, 3.0F, 2.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.Leg2Left = new ModelRenderer(this, 44, 47);
        this.Leg2Left.mirror = true;
        this.Leg2Left.setRotationPoint(-0.4F, 7.5F, 2.0F);
        this.Leg2Left.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Neck_1 = new ModelRenderer(this, 0, 107);
        this.Neck_1.setRotationPoint(-1.5F, -1.3F, 0.0F);
        this.Neck_1.addBox(0.0F, -1.0F, -7.0F, 3.0F, 5.0F, 7.0F, 0.1F, 0.0F, 0.1F);
        this.part30 = new ModelRenderer(this, 0, 120);
        this.part30.setRotationPoint(-1.0F, -2.0F, 0.0F);
        this.part30.addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2_1 = new ModelRenderer(this, 66, 5);
        this.Tail2_1.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.Tail2_1.addBox(0.0F, -1.0F, 0.0F, 0.0F, 4.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.part24 = new ModelRenderer(this, 44, 108);
        this.part24.setRotationPoint(-1.9F, -0.1F, -3.1F);
        this.part24.addBox(0.0F, 0.0F, 0.0F, 4.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.FootRight = new ModelRenderer(this, 42, 57);
        this.FootRight.setRotationPoint(0.0F, 6.0F, -1.0F);
        this.FootRight.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FootRight, 1.5707963267948966F, 0.0F, 0.0F);
        this.part28 = new ModelRenderer(this, 67, 109);
        this.part28.setRotationPoint(0.0F, 1.0F, 1.0F);
        this.part28.addBox(-3.0F, 0.0F, -5.0F, 6.0F, 0.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.ArmLeft = new ModelRenderer(this, 28, 34);
        this.ArmLeft.mirror = true;
        this.ArmLeft.setRotationPoint(-5.0F, 2.0F, -16.0F);
        this.ArmLeft.addBox(-1.0F, 0.0F, -1.0F, 3.0F, 10.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmLeft, 0.6108652381980153F, -0.17453292519943295F, -0.3490658503988659F);
        this.Head = new ModelRenderer(this, 0, 44);
        this.Head.setRotationPoint(0.0F, -0.6F, -6.0F);
        this.Head.addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, 0.24434609527920614F, -0.17453292519943295F, 0.0F);
        this.part24_1 = new ModelRenderer(this, 44, 108);
        this.part24_1.mirror = true;
        this.part24_1.setRotationPoint(-2.1F, -0.1F, -3.1F);
        this.part24_1.addBox(0.0F, 0.0F, 0.0F, 4.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Body_2 = new ModelRenderer(this, 113, 1);
        this.Body_2.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.Body_2.addBox(-5.0F, -3.0F, -19.0F, 10.0F, 10.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 32);
        this.Neck.setRotationPoint(0.0F, 0.0F, -19.0F);
        this.Neck.addBox(-1.5F, -2.0F, -6.0F, 3.0F, 1.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.0F, -0.2617993877991494F, 0.0F);
        this.part23 = new ModelRenderer(this, 28, 109);
        this.part23.setRotationPoint(-1.9F, 0.0F, -1.0F);
        this.part23.addBox(0.0F, 0.0F, 0.0F, 3.0F, 5.0F, 3.0F, 0.0F, 0.1F, 0.1F);
        this.part23_1 = new ModelRenderer(this, 28, 109);
        this.part23_1.mirror = true;
        this.part23_1.setRotationPoint(-1.1F, 0.0F, -1.0F);
        this.part23_1.addBox(0.0F, 0.0F, 0.0F, 3.0F, 6.0F, 3.0F, 0.0F, 0.1F, 0.1F);
        this.LegRight = new ModelRenderer(this, 44, 33);
        this.LegRight.setRotationPoint(4.0F, 10.5F, 8.0F);
        this.LegRight.addBox(-2.0F, 0.0F, -3.0F, 4.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegRight, -0.7330382858376184F, -0.296705972839036F, 0.0F);
        this.Body_1 = new ModelRenderer(this, 51, 37);
        this.Body_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body_1.addBox(0.0F, -4.0F, -19.0F, 0.0F, 10.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.Body_3 = new ModelRenderer(this, 0, 75);
        this.Body_3.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.Body_3.addBox(-5.0F, -3.0F, -19.0F, 10.0F, 10.0F, 22.0F, 0.1F, 0.1F, 0.1F);
        this.Tail2 = new ModelRenderer(this, 65, 5);
        this.Tail2.setRotationPoint(0.0F, 1.0F, 9.0F);
        this.Tail2.addBox(-1.5F, 0.0F, 1.0F, 3.0F, 0.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.17453292519943295F, -0.17453292519943295F, 0.0F);
        this.Body.addChild(this.Tail);
        this.LegRight.addChild(this.Leg2Right);
        this.Tail.addChild(this.Tail_1);
        this.Body_3.addChild(this.part22);
        this.Head.addChild(this.part21);
        this.Leg2Left.addChild(this.FootLeft);
        this.Tail.addChild(this.part25);
        this.part27.addChild(this.part31);
        this.Tail2_1.addChild(this.part27);
        this.Neck.addChild(this.Neck_2);
        this.part25.addChild(this.part26);
        this.Head.addChild(this.Snout);
        this.Body.addChild(this.ArmRight);
        this.Body_3.addChild(this.part29);
        this.LegLeft.addChild(this.Leg2Left);
        this.Neck.addChild(this.Neck_1);
        this.part26.addChild(this.part30);
        this.Tail2.addChild(this.Tail2_1);
        this.LegRight.addChild(this.part24);
        this.Leg2Right.addChild(this.FootRight);
        this.Tail2_1.addChild(this.part28);
        this.Body.addChild(this.ArmLeft);
        this.Neck.addChild(this.Head);
        this.LegLeft.addChild(this.part24_1);
        this.Body.addChild(this.Body_2);
        this.Body.addChild(this.Neck);
        this.ArmRight.addChild(this.part23);
        this.ArmLeft.addChild(this.part23_1);
        this.Body.addChild(this.Body_1);
        this.Body.addChild(this.Body_3);
        this.Tail_1.addChild(this.Tail2);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.LegLeft, this.Body, this.LegRight).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(ScelidosaurusSkeletonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
