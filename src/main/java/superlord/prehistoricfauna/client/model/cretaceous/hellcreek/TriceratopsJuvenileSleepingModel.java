package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TriceratopsEntity;

/**
 * Triceratops juvenile - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class TriceratopsJuvenileSleepingModel extends EntityModel<TriceratopsEntity> {
    public ModelRenderer Body;
    public ModelRenderer LeftFrontLeg;
    public ModelRenderer LeftHindLeg1;
    public ModelRenderer RightFrontLeg;
    public ModelRenderer RightHindLeg1;
    public ModelRenderer Neck;
    public ModelRenderer Tail1;
    public ModelRenderer Head1;
    public ModelRenderer Snout;
    public ModelRenderer horn1;
    public ModelRenderer Crest;
    public ModelRenderer horn1_1;
    public ModelRenderer nasalhorn;
    public ModelRenderer Beak;
    public ModelRenderer Tail2;
    public ModelRenderer LeftHindLeg2;
    public ModelRenderer LeftHindLeg3;
    public ModelRenderer RightHindLeg2;
    public ModelRenderer RightHindLeg3;

    public TriceratopsJuvenileSleepingModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Snout = new ModelRenderer(this, 37, 88);
        this.Snout.setRotationPoint(0.0F, 1.0F, -9.0F);
        this.Snout.addBox(-2.0F, 0.0F, -7.0F, 4.0F, 8.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 0, 48);
        this.Tail1.setRotationPoint(0.0F, -3.0F, 12.0F);
        this.Tail1.addBox(-3.0F, -3.0F, -2.0F, 6.0F, 7.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.43598323915870024F, 0.11728612207217244F, 0.0F);
        this.RightHindLeg2 = new ModelRenderer(this, 100, 28);
        this.RightHindLeg2.setRotationPoint(-1.0F, 5.0F, 5.0F);
        this.RightHindLeg2.addBox(-2.0F, -4.0F, -2.0F, 4.0F, 14.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightHindLeg2, 2.5413739344815873F, 0.0F, -0.3127630032889644F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.Body.addBox(-7.0F, -8.0F, -12.0F, 14.0F, 17.0F, 24.0F, 0.0F, 0.0F, 0.0F);
        this.RightHindLeg1 = new ModelRenderer(this, 92, 0);
        this.RightHindLeg1.setRotationPoint(-6.0F, 15.0F, 5.0F);
        this.RightHindLeg1.addBox(-3.0F, -4.0F, -5.0F, 6.0F, 14.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightHindLeg1, -1.13376586611655F, 0.19547687289441354F, 0.0F);
        this.Beak = new ModelRenderer(this, 0, 106);
        this.Beak.setRotationPoint(0.0F, 3.0F, -7.0F);
        this.Beak.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.LeftFrontLeg = new ModelRenderer(this, 96, 79);
        this.LeftFrontLeg.setRotationPoint(6.0F, 19.0F, -8.0F);
        this.LeftFrontLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 17.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftFrontLeg, -1.2119566751954398F, -0.27366763203903305F, 0.0F);
        this.Neck = new ModelRenderer(this, 58, 0);
        this.Neck.setRotationPoint(0.0F, -1.0F, -10.0F);
        this.Neck.addBox(-3.0F, -5.0F, -10.0F, 6.0F, 11.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.1563815016444822F, -0.46914448828868976F, 0.0F);
        this.Head1 = new ModelRenderer(this, 0, 79);
        this.Head1.setRotationPoint(0.0F, -5.0F, -10.0F);
        this.Head1.addBox(-4.0F, -3.0F, -9.0F, 8.0F, 13.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head1, 0.14905111745452548F, -0.1563815016444822F, 0.0F);
        this.RightHindLeg3 = new ModelRenderer(this, 98, 61);
        this.RightHindLeg3.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.RightHindLeg3.addBox(-2.5F, 0.0F, -4.0F, 5.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.nasalhorn = new ModelRenderer(this, 0, 0);
        this.nasalhorn.setRotationPoint(0.0F, 1.0F, -5.0F);
        this.nasalhorn.addBox(-0.5F, -3.0F, -2.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(nasalhorn, 0.6373942508178124F, 0.0F, 0.0F);
        this.RightFrontLeg = new ModelRenderer(this, 96, 79);
        this.RightFrontLeg.mirror = true;
        this.RightFrontLeg.setRotationPoint(-6.0F, 19.0F, -8.0F);
        this.RightFrontLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 17.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightFrontLeg, -1.291369076266349F, -0.23457224414434488F, 0.0F);
        this.Crest = new ModelRenderer(this, 48, 67);
        this.Crest.setRotationPoint(0.0F, 1.0F, -3.0F);
        this.Crest.addBox(-6.0F, -9.0F, -2.0F, 12.0F, 11.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Crest, -0.956091342937205F, 0.0F, 0.0F);
        this.horn1_1 = new ModelRenderer(this, 66, 90);
        this.horn1_1.setRotationPoint(-2.9F, -1.0F, -9.0F);
        this.horn1_1.addBox(-1.0F, -2.0F, -7.0F, 2.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(horn1_1, -0.7285004590772052F, 0.18203784630933073F, 0.0F);
        this.LeftHindLeg3 = new ModelRenderer(this, 98, 61);
        this.LeftHindLeg3.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.LeftHindLeg3.addBox(-2.5F, 0.0F, -4.0F, 5.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.LeftHindLeg1 = new ModelRenderer(this, 92, 0);
        this.LeftHindLeg1.setRotationPoint(6.0F, 15.0F, 5.0F);
        this.LeftHindLeg1.addBox(-3.0F, -4.0F, -5.0F, 6.0F, 14.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftHindLeg1, -1.13376586611655F, -0.19547687289441354F, 0.0F);
        this.horn1 = new ModelRenderer(this, 66, 90);
        this.horn1.setRotationPoint(2.9F, -1.0F, -9.0F);
        this.horn1.addBox(-1.0F, -2.0F, -7.0F, 2.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(horn1, -0.7285004590772052F, -0.18203784630933073F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 66, 37);
        this.Tail2.setRotationPoint(0.0F, -1.0F, 12.0F);
        this.Tail2.addBox(-2.0F, -1.0F, -2.0F, 4.0F, 5.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.13020156286456727F, 0.3127630032889644F, 0.0F);
        this.LeftHindLeg2 = new ModelRenderer(this, 100, 28);
        this.LeftHindLeg2.setRotationPoint(1.0F, 5.0F, 5.0F);
        this.LeftHindLeg2.addBox(-2.0F, -4.0F, -2.0F, 4.0F, 14.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftHindLeg2, 2.5411994974301875F, 0.0F, 0.3127630032889644F);
        this.Head1.addChild(this.Snout);
        this.Body.addChild(this.Tail1);
        this.RightHindLeg1.addChild(this.RightHindLeg2);
        this.Snout.addChild(this.Beak);
        this.Body.addChild(this.Neck);
        this.Neck.addChild(this.Head1);
        this.RightHindLeg2.addChild(this.RightHindLeg3);
        this.Snout.addChild(this.nasalhorn);
        this.Head1.addChild(this.Crest);
        this.Head1.addChild(this.horn1_1);
        this.LeftHindLeg2.addChild(this.LeftHindLeg3);
        this.Head1.addChild(this.horn1);
        this.Tail1.addChild(this.Tail2);
        this.LeftHindLeg1.addChild(this.LeftHindLeg2);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body, this.RightHindLeg1, this.LeftFrontLeg, this.RightFrontLeg, this.LeftHindLeg1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(TriceratopsEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
