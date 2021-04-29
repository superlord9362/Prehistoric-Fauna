package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.CeratosaurusSkeletonEntity;

/**
 * Ceratosaurus - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class CeratosaurusSkeletonAlertLeft extends EntityModel<CeratosaurusSkeletonEntity> {
    public ModelRenderer Body1;
    public ModelRenderer Neck;
    public ModelRenderer LeftArm;
    public ModelRenderer RightArm;
    public ModelRenderer BodyVertebrae;
    public ModelRenderer TailVetebrae;
    public ModelRenderer LeftLeg1;
    public ModelRenderer RightLeg1;
    public ModelRenderer Head1;
    public ModelRenderer Snout;
    public ModelRenderer Jaw1;
    public ModelRenderer CrestLeft;
    public ModelRenderer SnoutHorn;
    public ModelRenderer CrestRight;
    public ModelRenderer UpperTeeth;
    public ModelRenderer Jaw2;
    public ModelRenderer LowerTeeth;
    public ModelRenderer BodyRibcage;
    public ModelRenderer BodyOsteoderms;
    public ModelRenderer TailVertebrae2;
    public ModelRenderer TailOsteoderms;
    public ModelRenderer Tail1;
    public ModelRenderer Tail2;
    public ModelRenderer LeftLeg2;
    public ModelRenderer LeftFoot;
    public ModelRenderer RightLeg2;
    public ModelRenderer RightFoot;

    public CeratosaurusSkeletonAlertLeft() {
        this.textureWidth = 250;
        this.textureHeight = 250;
        this.Jaw2 = new ModelRenderer(this, 37, 119);
        this.Jaw2.setRotationPoint(0.0F, 1.0F, -8.0F);
        this.Jaw2.addBox(-2.0F, -1.0F, -9.0F, 4.0F, 3.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.LowerTeeth = new ModelRenderer(this, 47, 150);
        this.LowerTeeth.setRotationPoint(0.0F, -1.0F, -0.99F);
        this.LowerTeeth.addBox(-2.0F, -1.0F, -8.0F, 4.0F, 1.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.RightArm = new ModelRenderer(this, 73, 51);
        this.RightArm.setRotationPoint(-4.0F, 6.0F, -26.0F);
        this.RightArm.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightArm, 0.5864306020384839F, 0.0F, 0.0F);
        this.LeftLeg1 = new ModelRenderer(this, 76, 153);
        this.LeftLeg1.setRotationPoint(2.0F, -1.0F, -5.0F);
        this.LeftLeg1.addBox(0.0F, -4.0F, -6.0F, 6.0F, 17.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg1, 0.27366763203903305F, 0.0F, 0.0F);
        this.UpperTeeth = new ModelRenderer(this, 5, 152);
        this.UpperTeeth.setRotationPoint(0.0F, 4.0F, -1.01F);
        this.UpperTeeth.addBox(-2.5F, 0.0F, -8.0F, 5.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg1 = new ModelRenderer(this, 128, 153);
        this.RightLeg1.setRotationPoint(-2.0F, -1.0F, -5.0F);
        this.RightLeg1.addBox(-6.0F, -4.0F, -6.0F, 6.0F, 17.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg1, 0.27366763203903305F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 37, 94);
        this.Snout.setRotationPoint(0.0F, 0.5F, -8.0F);
        this.Snout.addBox(-2.5F, -1.0F, -9.0F, 5.0F, 5.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.TailVetebrae = new ModelRenderer(this, 169, 124);
        this.TailVetebrae.setRotationPoint(0.0F, -2.0F, 4.0F);
        this.TailVetebrae.addBox(0.0F, -4.0F, 0.0F, 0.0F, 13.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(TailVetebrae, 0.1563815016444822F, 0.0F, 0.0F);
        this.Jaw1 = new ModelRenderer(this, 0, 119);
        this.Jaw1.setRotationPoint(0.0F, 4.5F, 0.0F);
        this.Jaw1.addBox(-4.0F, 0.0F, -8.0F, 8.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.BodyOsteoderms = new ModelRenderer(this, 44, 4);
        this.BodyOsteoderms.mirror = true;
        this.BodyOsteoderms.setRotationPoint(0.0F, -6.1F, -26.0F);
        this.BodyOsteoderms.addBox(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 30.0F, 0.0F, 0.0F, 0.0F);
        this.CrestRight = new ModelRenderer(this, 16, 140);
        this.CrestRight.setRotationPoint(-2.0F, -2.0F, 1.0F);
        this.CrestRight.addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.SnoutHorn = new ModelRenderer(this, 0, 81);
        this.SnoutHorn.setRotationPoint(0.0F, -2.0F, -6.0F);
        this.SnoutHorn.addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 111, 43);
        this.Tail1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail1.addBox(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg2 = new ModelRenderer(this, 126, 192);
        this.RightLeg2.setRotationPoint(-4.0F, 12.0F, 5.0F);
        this.RightLeg2.addBox(-1.5F, -3.0F, -3.0F, 4.0F, 16.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 4, 55);
        this.Neck.setRotationPoint(0.0F, 4.0F, -30.0F);
        this.Neck.addBox(-3.0F, -13.0F, -4.0F, 6.0F, 9.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.1563815016444822F, 0.3909537457888271F, 0.0F);
        this.Body1 = new ModelRenderer(this, 155, 56);
        this.Body1.setRotationPoint(0.0F, 0.0F, 8.0F);
        this.Body1.addBox(-6.0F, -5.0F, -30.0F, 12.0F, 12.0F, 34.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body1, -0.27366763203903305F, 0.0F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 51, 51);
        this.LeftArm.setRotationPoint(4.0F, 6.0F, -26.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftArm, 0.5864306020384839F, 0.0F, 0.0F);
        this.BodyRibcage = new ModelRenderer(this, 155, 1);
        this.BodyRibcage.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.BodyRibcage.addBox(-5.5F, -6.0F, -30.0F, 11.0F, 15.0F, 34.0F, 0.0F, 0.0F, 0.0F);
        this.BodyVertebrae = new ModelRenderer(this, 171, 72);
        this.BodyVertebrae.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BodyVertebrae.addBox(0.0F, -7.0F, -30.0F, 0.0F, 18.0F, 34.0F, 0.0F, 0.0F, 0.0F);
        this.Head1 = new ModelRenderer(this, 0, 94);
        this.Head1.setRotationPoint(0.0F, -12.5F, -4.0F);
        this.Head1.addBox(-4.0F, -1.5F, -8.0F, 8.0F, 6.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head1, 0.0F, 0.6255260065779288F, 0.0F);
        this.TailOsteoderms = new ModelRenderer(this, 0, 16);
        this.TailOsteoderms.setRotationPoint(0.0F, -3.1F, 0.0F);
        this.TailOsteoderms.addBox(-0.5F, 0.0F, -1.0F, 1.0F, 0.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 92, 90);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.Tail2.addBox(-2.5F, 0.0F, 0.0F, 6.0F, 0.0F, 35.0F, 0.0F, 0.0F, 0.0F);
        this.TailVertebrae2 = new ModelRenderer(this, 177, 126);
        this.TailVertebrae2.setRotationPoint(0.0F, 0.0F, 22.0F);
        this.TailVertebrae2.addBox(0.0F, -2.0F, 0.0F, 0.0F, 7.0F, 36.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(TailVertebrae2, 0.11728612207217244F, 0.0F, 0.0F);
        this.LeftLeg2 = new ModelRenderer(this, 93, 192);
        this.LeftLeg2.setRotationPoint(4.0F, 12.0F, 5.0F);
        this.LeftLeg2.addBox(-2.5F, -3.0F, -3.0F, 4.0F, 16.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.RightFoot = new ModelRenderer(this, 126, 222);
        this.RightFoot.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.RightFoot.addBox(-2.0F, 0.0F, -7.0F, 5.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.CrestLeft = new ModelRenderer(this, 0, 140);
        this.CrestLeft.setRotationPoint(2.0F, -2.0F, 1.0F);
        this.CrestLeft.addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LeftFoot = new ModelRenderer(this, 80, 222);
        this.LeftFoot.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.LeftFoot.addBox(-3.0F, 0.0F, -7.0F, 5.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw1.addChild(this.Jaw2);
        this.Jaw2.addChild(this.LowerTeeth);
        this.Body1.addChild(this.RightArm);
        this.Body1.addChild(this.LeftLeg1);
        this.Snout.addChild(this.UpperTeeth);
        this.Body1.addChild(this.RightLeg1);
        this.Head1.addChild(this.Snout);
        this.Body1.addChild(this.TailVetebrae);
        this.Head1.addChild(this.Jaw1);
        this.BodyVertebrae.addChild(this.BodyOsteoderms);
        this.Snout.addChild(this.CrestRight);
        this.Snout.addChild(this.SnoutHorn);
        this.TailVetebrae.addChild(this.Tail1);
        this.RightLeg1.addChild(this.RightLeg2);
        this.Body1.addChild(this.Neck);
        this.Body1.addChild(this.LeftArm);
        this.BodyVertebrae.addChild(this.BodyRibcage);
        this.Body1.addChild(this.BodyVertebrae);
        this.Neck.addChild(this.Head1);
        this.TailVetebrae.addChild(this.TailOsteoderms);
        this.TailVertebrae2.addChild(this.Tail2);
        this.TailVetebrae.addChild(this.TailVertebrae2);
        this.LeftLeg1.addChild(this.LeftLeg2);
        this.RightLeg2.addChild(this.RightFoot);
        this.Snout.addChild(this.CrestLeft);
        this.LeftLeg2.addChild(this.LeftFoot);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(CeratosaurusSkeletonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
