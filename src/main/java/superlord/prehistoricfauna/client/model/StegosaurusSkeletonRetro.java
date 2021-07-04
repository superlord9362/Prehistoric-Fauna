package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.StegosaurusSkeletonEntity;

/**
 * Stegosaurus - superlord9362
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class StegosaurusSkeletonRetro extends EntityModel<StegosaurusSkeletonEntity> {
    public ModelRenderer Body;
    public ModelRenderer Neck;
    public ModelRenderer LeftArm;
    public ModelRenderer RightArm;
    public ModelRenderer LeftThigh;
    public ModelRenderer RightThigh;
    public ModelRenderer Tail1;
    public ModelRenderer RightBackPlates;
    public ModelRenderer LeftBackPlates;
    public ModelRenderer Body_1;
    public ModelRenderer Head;
    public ModelRenderer RightNeckPlates;
    public ModelRenderer LeftNeckPlates;
    public ModelRenderer Neck_1;
    public ModelRenderer Snout;
    public ModelRenderer LeftLeg;
    public ModelRenderer LeftFoot;
    public ModelRenderer RightLeg;
    public ModelRenderer RightFoot;
    public ModelRenderer Tail2;
    public ModelRenderer LeftTail1Plates;
    public ModelRenderer RightTail1Plates;
    public ModelRenderer Tail1_1;
    public ModelRenderer LeftThagomizers;
    public ModelRenderer RightThagomizers;
    public ModelRenderer RightTail2Plates;
    public ModelRenderer LeftTail2Plates;
    public ModelRenderer Tail2_1;

    public StegosaurusSkeletonRetro() {
        this.textureWidth = 256;
        this.textureHeight = 148;
        this.RightTail2Plates = new ModelRenderer(this, 166, 14);
        this.RightTail2Plates.mirror = true;
        this.RightTail2Plates.setRotationPoint(-1.0F, -13.0F, 0.0F);
        this.RightTail2Plates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 13.0F, 25.0F, 0.0F, 0.0F, 0.0F);
        this.RightArm = new ModelRenderer(this, 0, 0);
        this.RightArm.mirror = true;
        this.RightArm.setRotationPoint(-8.0F, 19.0F, 7.0F);
        this.RightArm.addBox(-5.0F, -4.0F, -4.0F, 7.0F, 27.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 87, 77);
        this.Neck.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.Neck.addBox(-3.5F, 0.0F, -19.0F, 7.0F, 10.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.35185837453889574F, 0.0F, 0.0F);
        this.LeftTail1Plates = new ModelRenderer(this, 138, 28);
        this.LeftTail1Plates.setRotationPoint(2.0F, -20.0F, 10.0F);
        this.LeftTail1Plates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 20.0F, 24.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 28, 73);
        this.Tail1.setRotationPoint(0.0F, 5.0F, 45.0F);
        this.Tail1.addBox(-5.0F, 0.0F, 0.0F, 10.0F, 0.0F, 34.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.4300491170387584F, 0.0F, 0.0F);
        this.RightNeckPlates = new ModelRenderer(this, 70, 101);
        this.RightNeckPlates.mirror = true;
        this.RightNeckPlates.setRotationPoint(1.0F, 0.0F, -3.0F);
        this.RightNeckPlates.addBox(-2.0F, -10.0F, -18.0F, 0.0F, 10.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.LeftNeckPlates = new ModelRenderer(this, 70, 113);
        this.LeftNeckPlates.setRotationPoint(-1.0F, -10.0F, -18.0F);
        this.LeftNeckPlates.addBox(2.0F, 0.0F, 0.0F, 0.0F, 10.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.RightTail1Plates = new ModelRenderer(this, 120, 39);
        this.RightTail1Plates.mirror = true;
        this.RightTail1Plates.setRotationPoint(-2.0F, -19.0F, -3.0F);
        this.RightTail1Plates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 19.0F, 33.0F, 0.0F, 0.0F, 0.0F);
        this.RightBackPlates = new ModelRenderer(this, 106, 77);
        this.RightBackPlates.mirror = true;
        this.RightBackPlates.setRotationPoint(-2.0F, -18.0F, 0.0F);
        this.RightBackPlates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 22.0F, 42.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 93, 0);
        this.Head.setRotationPoint(0.0F, 0.5F, -19.0F);
        this.Head.addBox(-3.5F, -1.5F, -9.0F, 7.0F, 7.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -0.23457224414434488F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, -18.0F, -21.0F);
        this.Body.addBox(-12.0F, 4.0F, 0.0F, 24.0F, 22.0F, 45.0F, 0.0F, 0.0F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 0, 0);
        this.LeftArm.setRotationPoint(9.0F, 19.0F, 7.0F);
        this.LeftArm.addBox(-3.0F, -4.0F, -4.0F, 7.0F, 27.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.LeftFoot = new ModelRenderer(this, 0, 130);
        this.LeftFoot.setRotationPoint(0.5F, 12.0F, 0.1F);
        this.LeftFoot.addBox(-3.5F, 0.0F, -6.0F, 7.0F, 3.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.RightFoot = new ModelRenderer(this, 0, 130);
        this.RightFoot.mirror = true;
        this.RightFoot.setRotationPoint(-0.5F, 12.0F, 0.1F);
        this.RightFoot.addBox(-3.5F, 0.0F, -6.0F, 7.0F, 3.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2_1 = new ModelRenderer(this, 101, 7);
        this.Tail2_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail2_1.addBox(0.0F, -1.0F, 0.0F, 0.0F, 5.0F, 30.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg = new ModelRenderer(this, 0, 107);
        this.RightLeg.mirror = true;
        this.RightLeg.setRotationPoint(2.5F, 17.0F, 6.0F);
        this.RightLeg.addBox(-3.0F, -1.0F, -4.0F, 6.0F, 15.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.LeftThagomizers = new ModelRenderer(this, 41, 119);
        this.LeftThagomizers.setRotationPoint(1.0F, 0.0F, 19.0F);
        this.LeftThagomizers.addBox(0.0F, 0.0F, 0.0F, 21.0F, 0.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftThagomizers, 0.0F, 0.0F, -0.7539822501773559F);
        this.Tail2 = new ModelRenderer(this, 95, 7);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 34.0F);
        this.Tail2.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 30.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.19547687289441354F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 97, 16);
        this.Snout.setRotationPoint(0.0F, 1.5F, -9.0F);
        this.Snout.addBox(-2.0F, -3.0F, -6.0F, 4.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.LeftBackPlates = new ModelRenderer(this, 157, 50);
        this.LeftBackPlates.setRotationPoint(2.0F, -18.0F, 3.0F);
        this.LeftBackPlates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 22.0F, 46.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1_1 = new ModelRenderer(this, 188, 52);
        this.Tail1_1.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Tail1_1.addBox(0.0F, -5.0F, 0.0F, 0.0F, 10.0F, 34.0F, 0.0F, 0.0F, 0.0F);
        this.LeftThigh = new ModelRenderer(this, 0, 71);
        this.LeftThigh.setRotationPoint(12.0F, 10.0F, 32.0F);
        this.LeftThigh.addBox(-7.0F, -3.0F, -2.0F, 9.0F, 21.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.RightThigh = new ModelRenderer(this, 0, 71);
        this.RightThigh.mirror = true;
        this.RightThigh.setRotationPoint(-12.0F, 10.0F, 32.0F);
        this.RightThigh.addBox(-2.0F, -3.0F, -2.0F, 9.0F, 21.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.LeftTail2Plates = new ModelRenderer(this, 166, 10);
        this.LeftTail2Plates.setRotationPoint(1.0F, -10.0F, 5.0F);
        this.LeftTail2Plates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 10.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 0, 107);
        this.LeftLeg.setRotationPoint(-2.5F, 17.0F, 6.0F);
        this.LeftLeg.addBox(-3.0F, -1.0F, -4.0F, 6.0F, 15.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.RightThagomizers = new ModelRenderer(this, 41, 119);
        this.RightThagomizers.mirror = true;
        this.RightThagomizers.setRotationPoint(-1.0F, 0.0F, 19.0F);
        this.RightThagomizers.addBox(-21.0F, 0.0F, 0.0F, 21.0F, 0.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightThagomizers, 0.0F, 0.0F, 0.7539822501773559F);
        this.Body_1 = new ModelRenderer(this, 166, -45);
        this.Body_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body_1.addBox(0.0F, 0.0F, 0.0F, 0.0F, 20.0F, 45.0F, 0.0F, 0.0F, 0.0F);
        this.Neck_1 = new ModelRenderer(this, 218, 6);
        this.Neck_1.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.Neck_1.addBox(0.0F, -5.0F, -19.0F, 0.0F, 5.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2.addChild(this.RightTail2Plates);
        this.Body.addChild(this.RightArm);
        this.Body.addChild(this.Neck);
        this.Tail1.addChild(this.LeftTail1Plates);
        this.Body.addChild(this.Tail1);
        this.Neck.addChild(this.RightNeckPlates);
        this.Neck.addChild(this.LeftNeckPlates);
        this.Tail1.addChild(this.RightTail1Plates);
        this.Body.addChild(this.RightBackPlates);
        this.Neck.addChild(this.Head);
        this.Body.addChild(this.LeftArm);
        this.LeftLeg.addChild(this.LeftFoot);
        this.RightLeg.addChild(this.RightFoot);
        this.Tail2.addChild(this.Tail2_1);
        this.RightThigh.addChild(this.RightLeg);
        this.Tail2.addChild(this.LeftThagomizers);
        this.Tail1.addChild(this.Tail2);
        this.Head.addChild(this.Snout);
        this.Body.addChild(this.LeftBackPlates);
        this.Tail1.addChild(this.Tail1_1);
        this.Body.addChild(this.LeftThigh);
        this.Body.addChild(this.RightThigh);
        this.Tail2.addChild(this.LeftTail2Plates);
        this.LeftThigh.addChild(this.LeftLeg);
        this.Tail2.addChild(this.RightThagomizers);
        this.Body.addChild(this.Body_1);
        this.Neck.addChild(this.Neck_1);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(StegosaurusSkeletonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
