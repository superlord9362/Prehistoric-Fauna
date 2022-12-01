package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.AnkylosaurusSkeletonEntity;

/**
 * Ankylosaurus - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class AnkylosaurusSkeletonRestingModel extends EntityModel<AnkylosaurusSkeletonEntity> {
	public ModelRenderer Body;
    public ModelRenderer LeftFrontLeg;
    public ModelRenderer RightFrontLeg;
    public ModelRenderer LeftHindLeg1;
    public ModelRenderer RightHindLeg1;
    public ModelRenderer Neck;
    public ModelRenderer Tail1;
    public ModelRenderer Osteoderms_Body;
    public ModelRenderer PectoralGirdle;
    public ModelRenderer Vertebrae_Body;
    public ModelRenderer Head1;
    public ModelRenderer Neck_1;
    public ModelRenderer Head2;
    public ModelRenderer Spike1;
    public ModelRenderer Spike1_1;
    public ModelRenderer Spike3;
    public ModelRenderer Spike4;
    public ModelRenderer Tail2;
    public ModelRenderer Tail1_1;
    public ModelRenderer Tail1_2;
    public ModelRenderer TailClub;
    public ModelRenderer Tail2_1;
    public ModelRenderer LeftHindLeg2;
    public ModelRenderer LeftHindLeg3;
    public ModelRenderer RightHindLeg2;
    public ModelRenderer RightHindLeg3;

    public AnkylosaurusSkeletonRestingModel() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.Tail1 = new ModelRenderer(this, 0, 76);
        this.Tail1.setRotationPoint(0.0F, -2.0F, 18.0F);
        this.Tail1.addBox(-6.0F, -2.0F, 1.0F, 12.0F, 0.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.18901915665940536F, -0.27366763203903305F, 0.0F);
        this.Head2 = new ModelRenderer(this, 200, 93);
        this.Head2.setRotationPoint(0.0F, 0.0F, -12.0F);
        this.Head2.addBox(-5.5F, -3.0F, -3.0F, 11.0F, 9.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.LeftHindLeg2 = new ModelRenderer(this, 201, 8);
        this.LeftHindLeg2.setRotationPoint(0.0F, 17.0F, -6.0F);
        this.LeftHindLeg2.addBox(-3.0F, 0.0F, -2.0F, 6.0F, 6.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftHindLeg2, -1.5247196451948906F, -0.27855454928408524F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 45, 87);
        this.Tail2.setRotationPoint(0.0F, -2.0F, 16.5F);
        this.Tail2.addBox(0.0F, -1.0F, -5.0F, 0.0F, 9.0F, 30.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.03263765709551775F, -0.11728612207217244F, 0.0F);
        this.RightFrontLeg = new ModelRenderer(this, 0, 0);
        this.RightFrontLeg.mirror = true;
        this.RightFrontLeg.setRotationPoint(-16.0F, 15.0F, -17.0F);
        this.RightFrontLeg.addBox(-4.0F, -3.0F, -4.0F, 6.0F, 20.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightFrontLeg, -0.8208283259076444F, -0.3909537457888271F, -0.31293754020890546F);
        this.Tail2_1 = new ModelRenderer(this, 45, 214);
        this.Tail2_1.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Tail2_1.addBox(-2.5F, -3.0F, -5.0F, 5.0F, 6.0F, 30.0F, 0.0F, 0.0F, 0.0F);
        this.Spike1 = new ModelRenderer(this, 0, 33);
        this.Spike1.setRotationPoint(7.0F, -3.0F, 0.0F);
        this.Spike1.addBox(-4.0F, -3.0F, 0.0F, 5.0F, 5.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Spike1, 0.0911061832922575F, 0.27314402127920984F, 0.0F);
        this.RightHindLeg3 = new ModelRenderer(this, 157, 0);
        this.RightHindLeg3.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.RightHindLeg3.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightHindLeg3, 1.5351915940752459F, 0.0F, 0.0F);
        this.Spike3 = new ModelRenderer(this, 29, 32);
        this.Spike3.setRotationPoint(7.0F, 2.0F, -2.0F);
        this.Spike3.addBox(-4.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Spike3, 0.0F, 0.9105382388075086F, 0.0F);
        this.RightHindLeg2 = new ModelRenderer(this, 201, 8);
        this.RightHindLeg2.mirror = true;
        this.RightHindLeg2.setRotationPoint(0.0F, 17.0F, -6.0F);
        this.RightHindLeg2.addBox(-3.0F, 0.0F, -2.0F, 6.0F, 6.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightHindLeg2, -1.5247196451948906F, 0.27855454928408524F, 0.0F);
        this.Vertebrae_Body = new ModelRenderer(this, 84, 158);
        this.Vertebrae_Body.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.Vertebrae_Body.addBox(0.0F, -8.0F, -34.0F, 0.0F, 24.0F, 52.0F, 0.0F, 0.0F, 0.0F);
        this.Spike1_1 = new ModelRenderer(this, 0, 33);
        this.Spike1_1.setRotationPoint(-7.0F, -3.0F, 0.0F);
        this.Spike1_1.addBox(-1.0F, -3.0F, 0.0F, 5.0F, 5.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Spike1_1, 0.0911061832922575F, -0.27314402127920984F, 0.0F);
        this.Tail1_1 = new ModelRenderer(this, 0, 206);
        this.Tail1_1.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.Tail1_1.addBox(-6.0F, -3.0F, -4.0F, 12.0F, 13.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.LeftFrontLeg = new ModelRenderer(this, 0, 0);
        this.LeftFrontLeg.setRotationPoint(15.0F, 14.0F, -17.0F);
        this.LeftFrontLeg.addBox(-2.0F, -3.0F, -4.0F, 6.0F, 20.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftFrontLeg, -0.8990190684075072F, 0.31293754020890546F, 0.07644542323472245F);
        this.LeftHindLeg1 = new ModelRenderer(this, 190, 33);
        this.LeftHindLeg1.setRotationPoint(16.0F, 4.0F, 22.0F);
        this.LeftHindLeg1.addBox(-8.0F, 0.0F, -8.0F, 10.0F, 18.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftHindLeg1, 0.0F, -0.15707963267948966F, 0.0F);
        this.LeftHindLeg3 = new ModelRenderer(this, 157, 0);
        this.LeftHindLeg3.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.LeftHindLeg3.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftHindLeg3, 1.5351915940752459F, 0.0F, 0.0F);
        this.RightHindLeg1 = new ModelRenderer(this, 190, 33);
        this.RightHindLeg1.mirror = true;
        this.RightHindLeg1.setRotationPoint(-16.0F, 4.0F, 22.0F);
        this.RightHindLeg1.addBox(-2.0F, 0.0F, -8.0F, 10.0F, 19.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightHindLeg1, 0.0F, 0.15707963267948966F, 0.0F);
        this.Spike4 = new ModelRenderer(this, 29, 32);
        this.Spike4.setRotationPoint(-7.0F, 2.0F, -2.0F);
        this.Spike4.addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Spike4, 0.0F, -0.9105382388075086F, 0.0F);
        this.Neck_1 = new ModelRenderer(this, 103, 103);
        this.Neck_1.mirror = true;
        this.Neck_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Neck_1.addBox(0.0F, -6.0F, -12.0F, 0.0F, 6.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.TailClub = new ModelRenderer(this, 94, 85);
        this.TailClub.setRotationPoint(0.0F, 2.0F, 21.0F);
        this.TailClub.addBox(-5.5F, -4.0F, 0.0F, 11.0F, 8.0F, 17.0F, 0.0F, 0.0F, 0.0F);
        this.PectoralGirdle = new ModelRenderer(this, 169, 140);
        this.PectoralGirdle.setRotationPoint(0.0F, 4.01F, -0.5F);
        this.PectoralGirdle.addBox(-16.0F, -8.0F, -34.0F, 32.0F, 16.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.Osteoderms_Body = new ModelRenderer(this, 0, 126);
        this.Osteoderms_Body.setRotationPoint(0.0F, -1.0F, -1.0F);
        this.Osteoderms_Body.addBox(-16.5F, -8.0F, -34.0F, 33.0F, 14.0F, 53.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1_2 = new ModelRenderer(this, 13, 81);
        this.Tail1_2.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.Tail1_2.addBox(0.0F, -1.0F, 0.0F, 0.0F, 11.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 9.0F, 9.0F);
        this.Body.addBox(-15.5F, -8.0F, -34.0F, 31.0F, 20.0F, 52.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, -0.03909537541112055F, 0.0F, 0.0F);
        this.Head1 = new ModelRenderer(this, 152, 97);
        this.Head1.setRotationPoint(0.0F, -1.0F, -12.0F);
        this.Head1.addBox(-7.0F, -5.0F, -12.0F, 14.0F, 12.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head1, 0.02827433396553192F, 0.11728612207217244F, -0.11746065899211351F);
        this.Neck = new ModelRenderer(this, 121, 142);
        this.Neck.setRotationPoint(0.0F, 1.0F, -34.0F);
        this.Neck.addBox(-5.0F, -6.0F, -12.0F, 10.0F, 12.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.3862413488189591F, 0.11728612207217244F, -0.1563815016444822F);
        this.Body.addChild(this.Tail1);
        this.Head1.addChild(this.Head2);
        this.LeftHindLeg1.addChild(this.LeftHindLeg2);
        this.Tail1.addChild(this.Tail2);
        this.Tail2.addChild(this.Tail2_1);
        this.Head1.addChild(this.Spike1);
        this.RightHindLeg2.addChild(this.RightHindLeg3);
        this.Head1.addChild(this.Spike3);
        this.RightHindLeg1.addChild(this.RightHindLeg2);
        this.Body.addChild(this.Vertebrae_Body);
        this.Head1.addChild(this.Spike1_1);
        this.Tail1.addChild(this.Tail1_1);
        this.LeftHindLeg2.addChild(this.LeftHindLeg3);
        this.Head1.addChild(this.Spike4);
        this.Neck.addChild(this.Neck_1);
        this.Tail2.addChild(this.TailClub);
        this.Body.addChild(this.PectoralGirdle);
        this.Body.addChild(this.Osteoderms_Body);
        this.Tail1.addChild(this.Tail1_2);
        this.Neck.addChild(this.Head1);
        this.Body.addChild(this.Neck);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.RightFrontLeg, this.LeftFrontLeg, this.LeftHindLeg1, this.RightHindLeg1, this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(AnkylosaurusSkeletonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
