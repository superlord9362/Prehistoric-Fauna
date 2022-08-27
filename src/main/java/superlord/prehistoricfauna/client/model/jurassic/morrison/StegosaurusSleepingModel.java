package superlord.prehistoricfauna.client.model.jurassic.morrison;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.StegosaurusEntity;

/**
 * StegosaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class StegosaurusSleepingModel extends EntityModel<StegosaurusEntity> {
    public ModelRenderer RightArm;
    public ModelRenderer RightThigh;
    public ModelRenderer LeftThigh;
    public ModelRenderer LeftArm;
    public ModelRenderer Body;
    public ModelRenderer RightLeg;
    public ModelRenderer RightFoot;
    public ModelRenderer LeftLeg;
    public ModelRenderer LeftFoot;
    public ModelRenderer LeftBackPlates;
    public ModelRenderer RightBackPlates;
    public ModelRenderer Neck;
    public ModelRenderer Tail1;
    public ModelRenderer Head;
    public ModelRenderer RightNeckPlates;
    public ModelRenderer LeftNeckPlates;
    public ModelRenderer Snout;
    public ModelRenderer LeftTail1Plates;
    public ModelRenderer RightTail1Plates;
    public ModelRenderer Tail2;
    public ModelRenderer LeftThagomizers;
    public ModelRenderer RightTail2Plates;
    public ModelRenderer RightThagomizers;
    public ModelRenderer LeftTail2Plates;

    public StegosaurusSleepingModel() {
        this.textureWidth = 256;
        this.textureHeight = 148;
        this.Neck = new ModelRenderer(this, 83, 73);
        this.Neck.setRotationPoint(3.0F, 11.0F, 2.0F);
        this.Neck.addBox(-3.5F, -5.0F, -23.0F, 7.0F, 10.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.8025023820775095F, -0.03665191262740524F, 0.0F);
        this.RightFoot = new ModelRenderer(this, 0, 130);
        this.RightFoot.mirror = true;
        this.RightFoot.setRotationPoint(0.0F, 12.0F, 0.1F);
        this.RightFoot.addBox(-3.5F, 0.0F, -6.0F, 7.0F, 3.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightFoot, 0.18256144042439712F, 0.18256144042439712F, -0.036477379868653376F);
        this.LeftBackPlates = new ModelRenderer(this, 157, 50);
        this.LeftBackPlates.setRotationPoint(2.0F, -21.0F, 3.0F);
        this.LeftBackPlates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 22.0F, 46.0F, 0.0F, 0.0F, 0.0F);
        this.LeftTail1Plates = new ModelRenderer(this, 138, 27);
        this.LeftTail1Plates.setRotationPoint(2.0F, -26.0F, 10.0F);
        this.LeftTail1Plates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 20.0F, 24.0F, 0.0F, 0.0F, 0.0F);
        this.RightTail1Plates = new ModelRenderer(this, 120, 38);
        this.RightTail1Plates.mirror = true;
        this.RightTail1Plates.setRotationPoint(-2.0F, -25.0F, -3.0F);
        this.RightTail1Plates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 19.0F, 33.0F, 0.0F, 0.0F, 0.0F);
        this.LeftNeckPlates = new ModelRenderer(this, 70, 113);
        this.LeftNeckPlates.setRotationPoint(-1.0F, -15.0F, -18.0F);
        this.LeftNeckPlates.addBox(2.0F, 0.0F, 0.0F, 0.0F, 10.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.RightThigh = new ModelRenderer(this, 0, 71);
        this.RightThigh.mirror = true;
        this.RightThigh.setRotationPoint(-6.0F, 1.0F, 14.0F);
        this.RightThigh.addBox(-6.0F, -3.0F, -7.5F, 9.0F, 21.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightThigh, -0.14608405639455457F, -0.14625859331449564F, 0.6932448001974364F);
        this.RightNeckPlates = new ModelRenderer(this, 70, 101);
        this.RightNeckPlates.mirror = true;
        this.RightNeckPlates.setRotationPoint(1.0F, -5.0F, -3.0F);
        this.RightNeckPlates.addBox(-2.0F, -10.0F, -18.0F, 0.0F, 10.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 96, 16);
        this.Snout.setRotationPoint(0.0F, -0.5F, -5.0F);
        this.Snout.addBox(-2.0F, -3.0F, -6.0F, 4.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 0, 0);
        this.LeftArm.setRotationPoint(9.0F, 21.2F, -14.0F);
        this.LeftArm.addBox(-3.0F, -4.0F, -4.0F, 7.0F, 27.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftArm, -0.21868975061435758F, -0.036477379868653376F, 1.460491523395177F);
        this.LeftLeg = new ModelRenderer(this, 0, 107);
        this.LeftLeg.setRotationPoint(2.5F, 17.0F, 2.0F);
        this.LeftLeg.addBox(-3.0F, -1.0F, -4.0F, 6.0F, 15.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg, 0.1459095194746135F, 0.0F, 0.07278023113974408F);
        this.Tail1 = new ModelRenderer(this, 28, 73);
        this.Tail1.setRotationPoint(0.0F, 8.0F, 43.0F);
        this.Tail1.addBox(-5.0F, -6.0F, 0.0F, 10.0F, 12.0F, 34.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.4782202083885436F, 0.18238690350445608F, -0.2553416715641412F);
        this.RightBackPlates = new ModelRenderer(this, 106, 77);
        this.RightBackPlates.mirror = true;
        this.RightBackPlates.setRotationPoint(-2.0F, -21.0F, 0.0F);
        this.RightBackPlates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 21.0F, 42.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(17.0F, 6.6F, -21.0F);
        this.Body.addBox(-12.0F, 0.0F, 0.0F, 24.0F, 26.0F, 45.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, -0.03665191262740524F, -0.07312929665724782F, 1.2407545013269026F);
        this.RightTail2Plates = new ModelRenderer(this, 166, 13);
        this.RightTail2Plates.mirror = true;
        this.RightTail2Plates.setRotationPoint(-1.0F, -16.0F, 0.0F);
        this.RightTail2Plates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 13.0F, 25.0F, 0.0F, 0.0F, 0.0F);
        this.LeftThigh = new ModelRenderer(this, 0, 71);
        this.LeftThigh.setRotationPoint(7.0F, 17.7F, 15.0F);
        this.LeftThigh.addBox(-2.0F, -3.0F, -7.5F, 9.0F, 21.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftThigh, 0.4742059590984399F, 0.0F, 1.4606660936046318F);
        this.LeftFoot = new ModelRenderer(this, 0, 130);
        this.LeftFoot.setRotationPoint(0.0F, 12.0F, 0.1F);
        this.LeftFoot.addBox(-3.5F, 0.0F, -6.0F, 7.0F, 3.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftFoot, 0.291993575869168F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 94, 2);
        this.Head.setRotationPoint(0.0F, -1.5F, -23.0F);
        this.Head.addBox(-3.5F, -3.5F, -5.0F, 7.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -0.036477379868653376F, 0.0F, 0.0F);
        this.LeftThagomizers = new ModelRenderer(this, 41, 119);
        this.LeftThagomizers.setRotationPoint(3.0F, -2.0F, 19.0F);
        this.LeftThagomizers.addBox(0.0F, 0.0F, 0.0F, 21.0F, 0.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftThagomizers, 0.0F, 0.0F, -0.7539822501773559F);
        this.LeftTail2Plates = new ModelRenderer(this, 166, 10);
        this.LeftTail2Plates.setRotationPoint(1.0F, -12.0F, 5.0F);
        this.LeftTail2Plates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 9.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 94, 7);
        this.Tail2.setRotationPoint(0.0F, -2.0F, 34.0F);
        this.Tail2.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 7.0F, 30.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, -0.10943214376714933F, -0.4010766541188137F, -0.3282964229790696F);
        this.RightThagomizers = new ModelRenderer(this, 41, 119);
        this.RightThagomizers.mirror = true;
        this.RightThagomizers.setRotationPoint(-3.0F, -2.0F, 19.0F);
        this.RightThagomizers.addBox(-21.0F, 0.0F, 0.0F, 21.0F, 0.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightThagomizers, 0.0F, 0.0F, 0.7539822501773559F);
        this.RightArm = new ModelRenderer(this, 0, 0);
        this.RightArm.setRotationPoint(-8.0F, 5.0F, -14.0F);
        this.RightArm.addBox(-5.0F, -4.0F, -4.0F, 7.0F, 27.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightArm, 0.3282964229790696F, -1.7453292129831807E-4F, 0.36477380700891215F);
        this.RightLeg = new ModelRenderer(this, 0, 107);
        this.RightLeg.mirror = true;
        this.RightLeg.setRotationPoint(-1.5F, 17.0F, 2.0F);
        this.RightLeg.addBox(-3.0F, -1.0F, -4.0F, 6.0F, 15.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg, 0.3282964229790696F, 0.07295475973730675F, 0.07295475973730675F);
        this.Body.addChild(this.Neck);
        this.RightLeg.addChild(this.RightFoot);
        this.Body.addChild(this.LeftBackPlates);
        this.Tail1.addChild(this.LeftTail1Plates);
        this.Tail1.addChild(this.RightTail1Plates);
        this.Neck.addChild(this.LeftNeckPlates);
        this.Neck.addChild(this.RightNeckPlates);
        this.Head.addChild(this.Snout);
        this.LeftThigh.addChild(this.LeftLeg);
        this.Body.addChild(this.Tail1);
        this.Body.addChild(this.RightBackPlates);
        this.Tail2.addChild(this.RightTail2Plates);
        this.LeftLeg.addChild(this.LeftFoot);
        this.Neck.addChild(this.Head);
        this.Tail2.addChild(this.LeftThagomizers);
        this.Tail2.addChild(this.LeftTail2Plates);
        this.Tail1.addChild(this.Tail2);
        this.Tail2.addChild(this.RightThagomizers);
        this.RightThigh.addChild(this.RightLeg);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.RightThigh, this.LeftArm, this.Body, this.LeftThigh, this.RightArm).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(StegosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
