package superlord.prehistoricfauna.client.model.jurassic.morrison;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.AllosaurusEntity;

/**
 * AllosaurusModel - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class AllosaurusSleepingModel extends EntityModel<AllosaurusEntity> {
    public ModelRenderer Body1;
    public ModelRenderer LeftLeg1;
    public ModelRenderer RightLeg1;
    public ModelRenderer Body2;
    public ModelRenderer Tail1;
    public ModelRenderer Neck;
    public ModelRenderer LeftArm;
    public ModelRenderer RightArm;
    public ModelRenderer Head1;
    public ModelRenderer Snout;
    public ModelRenderer Jaw1;
    public ModelRenderer Snout2;
    public ModelRenderer CrestLeft;
    public ModelRenderer CrestRight;
    public ModelRenderer UpperTeeth;
    public ModelRenderer Jaw2;
    public ModelRenderer Jaw3;
    public ModelRenderer LowerTeeth;
    public ModelRenderer LeftClaw;
    public ModelRenderer RightClaw;
    public ModelRenderer Tail2;
    public ModelRenderer LeftLeg2;
    public ModelRenderer LeftFoot;
    public ModelRenderer RightLeg2;
    public ModelRenderer RightFoot;

    public AllosaurusSleepingModel() {
        this.textureWidth = 250;
        this.textureHeight = 250;
        this.Body2 = new ModelRenderer(this, 81, 0);
        this.Body2.setRotationPoint(0.0F, 1.0F, -11.0F);
        this.Body2.addBox(-8.5F, -5.0F, -20.0F, 17.0F, 21.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body2, 0.0781907508222411F, 0.0F, -0.0F);
        this.LeftLeg2 = new ModelRenderer(this, 93, 192);
        this.LeftLeg2.setRotationPoint(4.0F, 14.0F, 8.0F);
        this.LeftLeg2.addBox(-3.5F, 0.0F, -3.0F, 7.0F, 20.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg2, -0.8991936386169619F, -0.5082398928281348F, 0.46914448828868976F);
        this.RightLeg2 = new ModelRenderer(this, 126, 192);
        this.RightLeg2.setRotationPoint(-4.0F, 13.0F, 8.0F);
        this.RightLeg2.addBox(-3.5F, 0.0F, -3.0F, 7.0F, 20.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg2, -0.8600982340775168F, 0.0F, 0.0F);
        this.LeftClaw = new ModelRenderer(this, 54, 70);
        this.LeftClaw.setRotationPoint(4.0F, 13.0F, 0.0F);
        this.LeftClaw.addBox(0.0F, 0.0F, -3.0F, 0.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 110, 43);
        this.Tail1.setRotationPoint(0.0F, 0.0F, 13.0F);
        this.Tail1.addBox(-6.0F, -4.0F, 0.0F, 12.0F, 14.0F, 32.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.4300491170387584F, 0.19547687289441354F, -0.0F);
        this.Jaw3 = new ModelRenderer(this, 0, 149);
        this.Jaw3.setRotationPoint(0.0F, 1.0F, 0.5F);
        this.Jaw3.addBox(-4.0F, -7.99F, -11.0F, 8.0F, 7.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.UpperTeeth = new ModelRenderer(this, 5, 203);
        this.UpperTeeth.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.UpperTeeth.addBox(-3.0F, -4.01F, -12.5F, 6.0F, 6.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw2 = new ModelRenderer(this, 47, 119);
        this.Jaw2.setRotationPoint(0.0F, 1.0F, -12.0F);
        this.Jaw2.addBox(-3.5F, -1.0F, -13.0F, 7.0F, 3.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.Head1 = new ModelRenderer(this, 0, 94);
        this.Head1.setRotationPoint(0.0F, -14.1F, -7.0F);
        this.Head1.addBox(-5.0F, -7.0F, -12.0F, 10.0F, 7.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head1, -1.7201964681550337F, 0.03909537541112055F, -0.0781907508222411F);
        this.CrestLeft = new ModelRenderer(this, 0, 191);
        this.CrestLeft.setRotationPoint(3.0F, -3.0F, 1.0F);
        this.CrestLeft.addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg1 = new ModelRenderer(this, 128, 153);
        this.RightLeg1.setRotationPoint(1.0F, 10.0F, 9.0F);
        this.RightLeg1.addBox(-8.0F, -3.0F, -6.0F, 8.0F, 21.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg1, -0.7428121536172364F, 0.23457224414434488F, 0.0F);
        this.RightFoot = new ModelRenderer(this, 126, 222);
        this.RightFoot.setRotationPoint(0.0F, 19.0F, -3.0F);
        this.RightFoot.addBox(-4.0F, 0.0F, -11.0F, 8.0F, 3.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightFoot, 1.602910321115726F, 0.0F, -0.0F);
        this.RightClaw = new ModelRenderer(this, 73, 70);
        this.RightClaw.setRotationPoint(-4.0F, 13.0F, 0.0F);
        this.RightClaw.addBox(0.0F, 0.0F, -3.0F, 0.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.LowerTeeth = new ModelRenderer(this, 47, 203);
        this.LowerTeeth.setRotationPoint(0.0F, -1.01F, -0.5F);
        this.LowerTeeth.addBox(-3.0F, -2.0F, -12.0F, 6.0F, 5.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 51);
        this.Neck.setRotationPoint(0.0F, -4.0F, -17.0F);
        this.Neck.addBox(-3.5F, -21.0F, -12.0F, 7.0F, 24.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 1.681101130194616F, 0.03909537541112055F, 0.27366763203903305F);
        this.Tail2 = new ModelRenderer(this, 92, 91);
        this.Tail2.setRotationPoint(0.0F, 1.0F, 32.0F);
        this.Tail2.addBox(-3.0F, -4.0F, 0.0F, 6.0F, 8.0F, 48.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, -0.19547687289441354F, 0.3909537457888271F, -0.0F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, 6.0F, 9.0F);
        this.Body1.addBox(-7.5F, -5.0F, -11.0F, 15.0F, 23.0F, 25.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body1, 0.0781907508222411F, 0.0F, -0.46914448828868976F);
        this.LeftFoot = new ModelRenderer(this, 80, 222);
        this.LeftFoot.setRotationPoint(0.0F, 19.0F, -3.0F);
        this.LeftFoot.addBox(-4.0F, 0.0F, -11.0F, 8.0F, 3.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftFoot, 1.4465288361160007F, 0.27366763203903305F, 0.0F);
        this.RightArm = new ModelRenderer(this, 73, 51);
        this.RightArm.setRotationPoint(-5.0F, 12.0F, -11.0F);
        this.RightArm.addBox(-4.0F, -2.0F, -3.0F, 5.0F, 15.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightArm, -1.4856243072344728F, 0.3909537457888271F, 0.3513347637790725F);
        this.CrestRight = new ModelRenderer(this, 16, 191);
        this.CrestRight.setRotationPoint(-3.0F, -3.0F, 1.0F);
        this.CrestRight.addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 51, 51);
        this.LeftArm.setRotationPoint(5.0F, 12.0F, -11.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -3.0F, 5.0F, 15.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftArm, -0.35185837453889574F, 0.0F, -0.4300491170387584F);
        this.Snout = new ModelRenderer(this, 47, 94);
        this.Snout.setRotationPoint(0.0F, -3.0F, -12.0F);
        this.Snout.addBox(-3.5F, -3.0F, -9.0F, 7.0F, 7.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw1 = new ModelRenderer(this, 0, 119);
        this.Jaw1.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Jaw1.addBox(-5.0F, -1.0F, -12.0F, 10.0F, 5.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg1 = new ModelRenderer(this, 76, 153);
        this.LeftLeg1.setRotationPoint(3.0F, 9.0F, 9.0F);
        this.LeftLeg1.addBox(0.0F, -3.0F, -6.0F, 8.0F, 21.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg1, -0.547160727158125F, -0.35185837453889574F, -0.3909537457888271F);
        this.Snout2 = new ModelRenderer(this, 83, 94);
        this.Snout2.setRotationPoint(0.0F, 1.0F, -9.0F);
        this.Snout2.addBox(-3.5F, -2.0F, -4.0F, 7.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Body1.addChild(this.Body2);
        this.LeftLeg1.addChild(this.LeftLeg2);
        this.RightLeg1.addChild(this.RightLeg2);
        this.LeftArm.addChild(this.LeftClaw);
        this.Body1.addChild(this.Tail1);
        this.Jaw1.addChild(this.Jaw3);
        this.Snout.addChild(this.UpperTeeth);
        this.Jaw1.addChild(this.Jaw2);
        this.Neck.addChild(this.Head1);
        this.Snout.addChild(this.CrestLeft);
        this.RightLeg2.addChild(this.RightFoot);
        this.RightArm.addChild(this.RightClaw);
        this.Jaw2.addChild(this.LowerTeeth);
        this.Body2.addChild(this.Neck);
        this.Tail1.addChild(this.Tail2);
        this.LeftLeg2.addChild(this.LeftFoot);
        this.Body2.addChild(this.RightArm);
        this.Snout.addChild(this.CrestRight);
        this.Body2.addChild(this.LeftArm);
        this.Head1.addChild(this.Snout);
        this.Head1.addChild(this.Jaw1);
        this.Snout.addChild(this.Snout2);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.RightLeg1, this.Body1, this.LeftLeg1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(AllosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
