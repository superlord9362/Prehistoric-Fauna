package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.AnkylosaurusEntity;

/**
 * AnkylosaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class AnkylosaurusSleepingModel extends EntityModel<AnkylosaurusEntity> {
    public ModelRenderer Body;
    public ModelRenderer LeftThigh;
    public ModelRenderer RightThigh;
    public ModelRenderer Neck;
    public ModelRenderer LeftArm;
    public ModelRenderer Tail1;
    public ModelRenderer RightArm;
    public ModelRenderer LeftLeg;
    public ModelRenderer LeftFoot;
    public ModelRenderer RightLeg;
    public ModelRenderer RightFoot;
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer LeftOsteoderm;
    public ModelRenderer RightOsteoderm;
    public ModelRenderer LeftCheekbone;
    public ModelRenderer RightCheekbone;
    public ModelRenderer Tail2;
    public ModelRenderer TailClub;

    public AnkylosaurusSleepingModel() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.LeftCheekbone = new ModelRenderer(this, 154, 79);
        this.LeftCheekbone.setRotationPoint(3.0F, 3.0F, -2.0F);
        this.LeftCheekbone.addBox(0.0F, -2.0F, 0.0F, 4.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftCheekbone, 0.0F, 0.18849556254433897F, -0.0F);
        this.RightLeg = new ModelRenderer(this, 92, 167);
        this.RightLeg.setRotationPoint(-2.0F, 13.0F, 1.0F);
        this.RightLeg.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg, -1.453510179755589F, 0.33021629580890766F, 0.017453292519943295F);
        this.LeftThigh = new ModelRenderer(this, 64, 136);
        this.LeftThigh.setRotationPoint(10.5F, -1.0F, 1.0F);
        this.LeftThigh.addBox(-2.0F, -1.0F, -5.0F, 8.0F, 15.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftThigh, 0.0F, -0.15707963267948966F, 0.0F);
        this.LeftFoot = new ModelRenderer(this, 64, 188);
        this.LeftFoot.setRotationPoint(0.0F, 10.0F, -0.7F);
        this.LeftFoot.addBox(-3.5F, 0.0F, -5.0F, 7.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftFoot, 1.5247196451948906F, 0.0F, 0.0F);
        this.RightCheekbone = new ModelRenderer(this, 136, 78);
        this.RightCheekbone.setRotationPoint(-3.0F, 3.0F, -2.0F);
        this.RightCheekbone.addBox(-4.0F, -2.0F, 0.0F, 4.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightCheekbone, 0.0F, -0.18849556254433897F, -0.0F);
        this.RightThigh = new ModelRenderer(this, 105, 136);
        this.RightThigh.setRotationPoint(-11.5F, -1.0F, 1.0F);
        this.RightThigh.addBox(-6.0F, -1.0F, -5.0F, 8.0F, 15.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightThigh, 0.017453292519943295F, 0.15707963267948966F, 0.0F);
        this.RightOsteoderm = new ModelRenderer(this, 132, 63);
        this.RightOsteoderm.setRotationPoint(-3.0F, -3.0F, -2.0F);
        this.RightOsteoderm.addBox(-4.0F, -2.0F, 0.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightOsteoderm, 0.12566369449226195F, -0.2513273889845239F, -0.0F);
        this.TailClub = new ModelRenderer(this, 157, 13);
        this.TailClub.setRotationPoint(0.0F, 0.0F, 15.0F);
        this.TailClub.addBox(-5.0F, -1.0F, 0.0F, 10.0F, 6.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(TailClub, 0.1171115934746098F, -0.5082398928281348F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 64, 110);
        this.LeftArm.setRotationPoint(11.5F, 9.0F, -26.0F);
        this.LeftArm.addBox(0.0F, -1.0F, -3.0F, 6.0F, 15.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftArm, -0.8990190684075072F, 0.31293754020890546F, 0.07644542323472245F);
        this.RightArm = new ModelRenderer(this, 91, 110);
        this.RightArm.setRotationPoint(-11.5F, 9.0F, -25.0F);
        this.RightArm.addBox(-6.0F, -1.0F, -3.0F, 6.0F, 15.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightArm, -0.8208283259076444F, -0.3909537457888271F, -0.31293754020890546F);
        this.Snout = new ModelRenderer(this, 57, 91);
        this.Snout.setRotationPoint(0.0F, 1.0F, -13.0F);
        this.Snout.addBox(-4.0F, -3.0F, -2.0F, 8.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 10.0F, 12.0F);
        this.Body.addBox(-14.0F, -5.0F, -31.0F, 28.0F, 19.0F, 41.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, -0.0781907508222411F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 101, 0);
        this.Tail1.setRotationPoint(0.0F, -3.0F, 10.0F);
        this.Tail1.addBox(-5.0F, 0.0F, 0.0F, 10.0F, 10.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.18901915665940536F, -0.27366763203903305F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 91);
        this.Head.setRotationPoint(0.0F, 3.7F, -7.0F);
        this.Head.addBox(-6.0F, -4.0F, -13.0F, 12.0F, 10.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -0.02827433396553192F, 0.11728612207217244F, -0.11746065899211351F);
        this.Tail2 = new ModelRenderer(this, 157, 31);
        this.Tail2.setRotationPoint(0.0F, 4.0F, 16.0F);
        this.Tail2.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.03263765709551775F, -0.11728612207217244F, 0.0F);
        this.LeftOsteoderm = new ModelRenderer(this, 154, 63);
        this.LeftOsteoderm.setRotationPoint(3.0F, -3.0F, -2.0F);
        this.LeftOsteoderm.addBox(0.0F, -2.0F, 0.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftOsteoderm, 0.12566369449226195F, 0.2513273889845239F, -0.0F);
        this.LeftLeg = new ModelRenderer(this, 64, 167);
        this.LeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.LeftLeg.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg, -1.3683381601951652F, -0.2738421523142173F, 0.0F);
        this.RightFoot = new ModelRenderer(this, 95, 188);
        this.RightFoot.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.RightFoot.addBox(-3.5F, 0.0F, -5.0F, 7.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightFoot, 1.5645131308350726F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 63);
        this.Neck.setRotationPoint(0.0F, 1.0F, -31.0F);
        this.Neck.addBox(-5.0F, 0.0F, -10.0F, 10.0F, 10.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.46443212460833544F, 0.11728612207217244F, -0.1563815016444822F);
        this.Head.addChild(this.LeftCheekbone);
        this.RightThigh.addChild(this.RightLeg);
        this.Body.addChild(this.LeftThigh);
        this.LeftLeg.addChild(this.LeftFoot);
        this.Head.addChild(this.RightCheekbone);
        this.Body.addChild(this.RightThigh);
        this.Head.addChild(this.RightOsteoderm);
        this.Tail2.addChild(this.TailClub);
        this.Body.addChild(this.LeftArm);
        this.Body.addChild(this.RightArm);
        this.Head.addChild(this.Snout);
        this.Body.addChild(this.Tail1);
        this.Neck.addChild(this.Head);
        this.Tail1.addChild(this.Tail2);
        this.Head.addChild(this.LeftOsteoderm);
        this.LeftThigh.addChild(this.LeftLeg);
        this.RightLeg.addChild(this.RightFoot);
        this.Body.addChild(this.Neck);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(AnkylosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
