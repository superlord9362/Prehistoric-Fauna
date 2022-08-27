package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.AllosaurusSkeletonEntity;

/**
 * Allosaurus - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class AllosaurusSkeletonRestingModel extends EntityModel<AllosaurusSkeletonEntity> {
    public ModelRenderer LeftLeg1;
    public ModelRenderer RightLeg1;
    public ModelRenderer Body1;
    public ModelRenderer LeftLeg2;
    public ModelRenderer LeftFoot;
    public ModelRenderer RightLeg2;
    public ModelRenderer RightFoot;
    public ModelRenderer Tail1;
    public ModelRenderer Body2;
    public ModelRenderer Body1_1;
    public ModelRenderer Tail2;
    public ModelRenderer Tail1_1;
    public ModelRenderer Tail2_1;
    public ModelRenderer RightArm;
    public ModelRenderer Neck;
    public ModelRenderer LeftArm;
    public ModelRenderer Body2_1;
    public ModelRenderer Head1;
    public ModelRenderer Neck_1;
    public ModelRenderer Snout;
    public ModelRenderer Jaw1;
    public ModelRenderer UpperTeeth;
    public ModelRenderer CrestLeft;
    public ModelRenderer Snout2;
    public ModelRenderer CrestRight;
    public ModelRenderer Jaw3;
    public ModelRenderer Jaw2;
    public ModelRenderer LowerTeeth;

    public AllosaurusSkeletonRestingModel() {
        this.textureWidth = 250;
        this.textureHeight = 250;
        this.LeftFoot = new ModelRenderer(this, 80, 222);
        this.LeftFoot.setRotationPoint(0.0F, 17.0F, -2.0F);
        this.LeftFoot.addBox(-4.0F, 0.0F, -11.0F, 8.0F, 3.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftFoot, 1.2510520131558576F, 0.0F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 51, 51);
        this.LeftArm.setRotationPoint(9.5F, 13.0F, -15.0F);
        this.LeftArm.addBox(-5.0F, -2.0F, -1.5F, 5.0F, 15.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftArm, 0.15707963267948966F, 0.03909537541112055F, 0.0F);
        this.Jaw3 = new ModelRenderer(this, 0, 149);
        this.Jaw3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Jaw3.addBox(-4.0F, -7.99F, -11.0F, 8.0F, 7.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Body1_1 = new ModelRenderer(this, 204, -23);
        this.Body1_1.setRotationPoint(0.0F, -3.0F, 1.0F);
        this.Body1_1.addBox(0.0F, -2.0F, -11.0F, 0.0F, 25.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.Snout2 = new ModelRenderer(this, 83, 94);
        this.Snout2.setRotationPoint(0.0F, 1.0F, -9.0F);
        this.Snout2.addBox(-3.5F, -2.0F, -4.0F, 7.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.LowerTeeth = new ModelRenderer(this, 47, 203);
        this.LowerTeeth.setRotationPoint(0.0F, -1.0F, -1.0F);
        this.LowerTeeth.addBox(-3.0F, -2.0F, -12.0F, 6.0F, 5.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw1 = new ModelRenderer(this, 0, 121);
        this.Jaw1.setRotationPoint(0.0F, 5.5F, 0.0F);
        this.Jaw1.addBox(-5.0F, 0.0F, -10.0F, 10.0F, 4.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.CrestLeft = new ModelRenderer(this, 0, 191);
        this.CrestLeft.setRotationPoint(3.0F, -3.0F, 1.0F);
        this.CrestLeft.addBox(-1.0F, -2.0F, -3.0F, 2.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Body2_1 = new ModelRenderer(this, 169, 5);
        this.Body2_1.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.Body2_1.addBox(0.0F, -3.0F, -20.0F, 0.0F, 19.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.CrestRight = new ModelRenderer(this, 16, 191);
        this.CrestRight.setRotationPoint(-2.5F, -3.0F, 1.0F);
        this.CrestRight.addBox(-1.5F, -2.0F, -3.0F, 2.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.UpperTeeth = new ModelRenderer(this, 5, 203);
        this.UpperTeeth.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.UpperTeeth.addBox(-3.5F, -4.0F, -12.5F, 7.0F, 5.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.RightArm = new ModelRenderer(this, 51, 51);
        this.RightArm.mirror = true;
        this.RightArm.setRotationPoint(-9.5F, 13.0F, -15.0F);
        this.RightArm.addBox(0.0F, -2.0F, -1.5F, 5.0F, 15.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightArm, 0.15707963267948966F, 0.0F, 0.0F);
        this.Head1 = new ModelRenderer(this, 2, 96);
        this.Head1.setRotationPoint(0.0F, -8.5F, -6.0F);
        this.Head1.addBox(-5.0F, -2.5F, -10.0F, 10.0F, 8.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head1, 0.11728612207217244F, 0.0F, 0.0F);
        this.RightFoot = new ModelRenderer(this, 126, 222);
        this.RightFoot.setRotationPoint(0.0F, 17.0F, -2.0F);
        this.RightFoot.addBox(-4.0F, 0.0F, -11.0F, 8.0F, 3.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightFoot, 1.2510520131558576F, 0.0F, 0.0F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, -4.0F, 9.0F);
        this.Body1.addBox(-7.5F, -3.0F, -11.0F, 15.0F, 21.0F, 25.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 51);
        this.Neck.setRotationPoint(0.0F, -3.0F, -20.0F);
        this.Neck.addBox(-3.5F, -9.0F, -7.0F, 7.0F, 12.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.8210028961170991F, -0.5473352640780661F, 0.0F);
        this.Tail2_1 = new ModelRenderer(this, 98, 91);
        this.Tail2_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail2_1.addBox(0.0F, -3.0F, 0.0F, 0.0F, 10.0F, 48.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg1 = new ModelRenderer(this, 76, 153);
        this.LeftLeg1.mirror = true;
        this.LeftLeg1.setRotationPoint(5.5F, 3.5F, 8.5F);
        this.LeftLeg1.addBox(-3.0F, -6.5F, -5.5F, 8.0F, 21.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg1, -0.7428121536172364F, -0.3909537457888271F, 0.0F);
        this.Jaw2 = new ModelRenderer(this, 47, 119);
        this.Jaw2.setRotationPoint(0.0F, 1.0F, -9.0F);
        this.Jaw2.addBox(-3.0F, -1.0F, -13.0F, 6.0F, 3.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg2 = new ModelRenderer(this, 126, 192);
        this.RightLeg2.setRotationPoint(-1.0F, 10.5F, 8.5F);
        this.RightLeg2.addBox(-3.5F, 0.0F, -3.0F, 7.0F, 20.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg2, -0.5082398928281348F, 0.0F, 0.0F);
        this.RightLeg1 = new ModelRenderer(this, 76, 153);
        this.RightLeg1.setRotationPoint(-5.5F, 3.5F, 8.5F);
        this.RightLeg1.addBox(-5.0F, -6.6F, -5.5F, 8.0F, 21.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg1, -0.7428121536172364F, 0.3909537457888271F, 0.0F);
        this.Tail1_1 = new ModelRenderer(this, 122, 43);
        this.Tail1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail1_1.addBox(0.0F, -5.0F, 0.0F, 0.0F, 14.0F, 32.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg2 = new ModelRenderer(this, 93, 192);
        this.LeftLeg2.setRotationPoint(1.0F, 10.5F, 8.5F);
        this.LeftLeg2.addBox(-3.5F, 0.0F, -3.0F, 7.0F, 20.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg2, -0.5082398928281348F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 92, 91);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 32.0F);
        this.Tail2.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 48.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.0F, 0.6646214111173737F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 113, 44);
        this.Tail1.setRotationPoint(0.0F, 1.0F, 13.0F);
        this.Tail1.addBox(-4.0F, 0.0F, 1.0F, 8.0F, 0.0F, 31.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.35185837453889574F, 0.5473352640780661F, 0.0F);
        this.Snout = new ModelRenderer(this, 47, 94);
        this.Snout.setRotationPoint(0.0F, 1.5F, -10.0F);
        this.Snout.addBox(-3.5F, -3.0F, -9.0F, 7.0F, 7.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Neck_1 = new ModelRenderer(this, 210, 52);
        this.Neck_1.setRotationPoint(0.0F, -1.0F, 1.0F);
        this.Neck_1.addBox(0.0F, -9.0F, -7.0F, 0.0F, 12.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Body2 = new ModelRenderer(this, 80, -1);
        this.Body2.setRotationPoint(0.0F, 1.0F, -11.0F);
        this.Body2.addBox(-8.5F, -3.0F, -20.0F, 17.0F, 19.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg2.addChild(this.LeftFoot);
        this.Body2.addChild(this.LeftArm);
        this.Jaw1.addChild(this.Jaw3);
        this.Body1.addChild(this.Body1_1);
        this.Snout.addChild(this.Snout2);
        this.Jaw2.addChild(this.LowerTeeth);
        this.Head1.addChild(this.Jaw1);
        this.Snout.addChild(this.CrestLeft);
        this.Body2.addChild(this.Body2_1);
        this.Snout.addChild(this.CrestRight);
        this.Snout.addChild(this.UpperTeeth);
        this.Body2.addChild(this.RightArm);
        this.Neck.addChild(this.Head1);
        this.RightLeg2.addChild(this.RightFoot);
        this.Body2.addChild(this.Neck);
        this.Tail2.addChild(this.Tail2_1);
        this.Jaw1.addChild(this.Jaw2);
        this.RightLeg1.addChild(this.RightLeg2);
        this.Tail1.addChild(this.Tail1_1);
        this.LeftLeg1.addChild(this.LeftLeg2);
        this.Tail1.addChild(this.Tail2);
        this.Body1.addChild(this.Tail1);
        this.Head1.addChild(this.Snout);
        this.Neck.addChild(this.Neck_1);
        this.Body1.addChild(this.Body2);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body1, this.LeftLeg1, this.RightLeg1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(AllosaurusSkeletonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
