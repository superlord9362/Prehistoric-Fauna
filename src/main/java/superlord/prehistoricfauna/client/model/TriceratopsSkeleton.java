package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.TriceratopsSkeletonEntity;

/**
 * Triceratops - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class TriceratopsSkeleton extends EntityModel<TriceratopsSkeletonEntity> {
    public ModelRenderer Saddle;
    public ModelRenderer RightHindLeg1;
    public ModelRenderer LeftHindLeg1;
    public ModelRenderer Body;
    public ModelRenderer LeftFrontLeg;
    public ModelRenderer RightFrontLeg;
    public ModelRenderer Saddle2;
    public ModelRenderer Chest1;
    public ModelRenderer Chest2;
    public ModelRenderer Chest4;
    public ModelRenderer Chest3;
    public ModelRenderer RightHindLeg2;
    public ModelRenderer RightHindLeg3;
    public ModelRenderer LeftHindLeg2;
    public ModelRenderer LeftHindLeg3;
    public ModelRenderer Neck;
    public ModelRenderer Tail1;
    public ModelRenderer part27;
    public ModelRenderer Head1;
    public ModelRenderer horn1;
    public ModelRenderer horn1_1;
    public ModelRenderer Snout;
    public ModelRenderer Crest;
    public ModelRenderer nasalhorn;
    public ModelRenderer Beak;
    public ModelRenderer Tail2;
    public ModelRenderer caudalvertebrae;

    public TriceratopsSkeleton() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.LeftHindLeg1 = new ModelRenderer(this, 190, 0);
        this.LeftHindLeg1.setRotationPoint(11.0F, -10.0F, 10.0F);
        this.LeftHindLeg1.addBox(-4.0F, -5.0F, -8.0F, 8.0F, 25.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 169);
        this.Snout.setRotationPoint(0.0F, 1.0F, -12.0F);
        this.Snout.addBox(-4.0F, 0.0F, -14.0F, 8.0F, 13.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.RightHindLeg1 = new ModelRenderer(this, 190, 0);
        this.RightHindLeg1.mirror = true;
        this.RightHindLeg1.setRotationPoint(-11.0F, -10.0F, 10.0F);
        this.RightHindLeg1.addBox(-4.0F, -5.0F, -8.0F, 8.0F, 25.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.Beak = new ModelRenderer(this, 0, 204);
        this.Beak.setRotationPoint(0.0F, 2.0F, -14.0F);
        this.Beak.addBox(-2.0F, 0.0F, -5.0F, 4.0F, 12.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 0, 77);
        this.Tail1.setRotationPoint(0.0F, -1.0F, 19.0F);
        this.Tail1.addBox(-4.0F, -3.0F, -1.0F, 8.0F, 13.0F, 24.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.3186971254089062F, 0.0F, 0.0F);
        this.Chest3 = new ModelRenderer(this, 215, 163);
        this.Chest3.setRotationPoint(12.0F, -2.0F, -15.0F);
        this.Chest3.addBox(0.0F, 0.0F, -3.0F, 3.0F, 7.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Crest = new ModelRenderer(this, 58, 127);
        this.Crest.setRotationPoint(0.0F, 9.0F, -3.0F);
        this.Crest.addBox(-14.0F, -23.0F, -5.0F, 28.0F, 25.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Crest, -0.591841146688116F, 0.0F, 0.0F);
        this.Chest4 = new ModelRenderer(this, 215, 163);
        this.Chest4.mirror = true;
        this.Chest4.setRotationPoint(-12.0F, -2.0F, -15.0F);
        this.Chest4.addBox(-3.0F, 0.0F, -3.0F, 3.0F, 7.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Chest1 = new ModelRenderer(this, 207, 182);
        this.Chest1.setRotationPoint(12.0F, -11.0F, 8.0F);
        this.Chest1.addBox(0.0F, 0.0F, -6.0F, 6.0F, 10.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.LeftHindLeg2 = new ModelRenderer(this, 190, 50);
        this.LeftHindLeg2.setRotationPoint(0.0F, 17.0F, 6.0F);
        this.LeftHindLeg2.addBox(-3.0F, -4.0F, -2.0F, 6.0F, 19.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 109, 8);
        this.Neck.setRotationPoint(0.0F, 1.0F, -22.0F);
        this.Neck.addBox(-1.0F, -4.0F, -13.0F, 2.0F, 11.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 88, 77);
        this.Tail2.setRotationPoint(0.0F, -0.3F, 19.0F);
        this.Tail2.addBox(0.0F, -2.0F, -3.0F, 0.0F, 8.0F, 27.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.0911061832922575F, 0.0F, 0.0F);
        this.part27 = new ModelRenderer(this, 91, 31);
        this.part27.setRotationPoint(0.0F, -8.0F, -24.0F);
        this.part27.addBox(0.0F, 0.0F, 0.0F, 0.0F, 29.0F, 43.0F, 0.0F, 0.0F, 0.0F);
        this.horn1_1 = new ModelRenderer(this, 60, 165);
        this.horn1_1.setRotationPoint(-4.9F, -1.0F, -12.0F);
        this.horn1_1.addBox(-1.0F, -4.0F, -20.0F, 3.0F, 4.0F, 25.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(horn1_1, -0.7285004590772052F, 0.18203784630933073F, 0.0F);
        this.Saddle2 = new ModelRenderer(this, 141, 143);
        this.Saddle2.setRotationPoint(0.0F, -12.0F, 14.0F);
        this.Saddle2.addBox(-14.0F, -4.0F, -4.0F, 28.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.horn1 = new ModelRenderer(this, 60, 165);
        this.horn1.setRotationPoint(4.9F, -1.0F, -12.0F);
        this.horn1.addBox(-2.0F, -4.0F, -20.0F, 3.0F, 4.0F, 25.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(horn1, -0.7285004590772052F, -0.18203784630933073F, 0.0F);
        this.Head1 = new ModelRenderer(this, 0, 130);
        this.Head1.setRotationPoint(0.0F, -3.0F, -16.0F);
        this.Head1.addBox(-6.0F, -3.0F, -12.0F, 12.0F, 18.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head1, 0.500909508638178F, 0.0F, 0.0F);
        this.LeftHindLeg3 = new ModelRenderer(this, 157, 0);
        this.LeftHindLeg3.setRotationPoint(0.0F, 14.0F, 3.0F);
        this.LeftHindLeg3.addBox(-4.0F, 0.0F, -6.0F, 8.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.RightHindLeg3 = new ModelRenderer(this, 157, 0);
        this.RightHindLeg3.setRotationPoint(0.0F, 14.0F, 3.0F);
        this.RightHindLeg3.addBox(-4.0F, 0.0F, -6.0F, 8.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.nasalhorn = new ModelRenderer(this, 0, 0);
        this.nasalhorn.setRotationPoint(0.0F, 1.0F, -12.0F);
        this.nasalhorn.addBox(-1.0F, -5.0F, -3.0F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(nasalhorn, 0.6373942508178124F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, -14.0F, 4.0F);
        this.Body.addBox(-12.0F, -5.0F, -24.0F, 24.0F, 25.0F, 43.0F, 0.0F, 0.0F, 0.0F);
        this.RightFrontLeg = new ModelRenderer(this, 220, 75);
        this.RightFrontLeg.mirror = true;
        this.RightFrontLeg.setRotationPoint(-11.0F, -3.0F, -14.0F);
        this.RightFrontLeg.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 27.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.RightHindLeg2 = new ModelRenderer(this, 190, 50);
        this.RightHindLeg2.mirror = true;
        this.RightHindLeg2.setRotationPoint(0.0F, 17.0F, 6.0F);
        this.RightHindLeg2.addBox(-3.0F, -4.0F, -2.0F, 6.0F, 19.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.caudalvertebrae = new ModelRenderer(this, 0, 90);
        this.caudalvertebrae.setRotationPoint(0.0F, -3.0F, -1.0F);
        this.caudalvertebrae.addBox(0.0F, -2.5F, 0.0F, 0.0F, 9.0F, 24.0F, 0.0F, 0.0F, 0.0F);
        this.Saddle = new ModelRenderer(this, 112, 172);
        this.Saddle.setRotationPoint(0.0F, -14.0F, 4.0F);
        this.Saddle.addBox(-12.0F, -8.0F, -24.0F, 24.0F, 31.0F, 43.0F, 0.39999962F, 0.39999962F, 0.39999962F);
        this.Chest2 = new ModelRenderer(this, 207, 182);
        this.Chest2.mirror = true;
        this.Chest2.setRotationPoint(-12.0F, -11.0F, 8.0F);
        this.Chest2.addBox(-6.0F, 0.0F, -6.0F, 6.0F, 10.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.LeftFrontLeg = new ModelRenderer(this, 220, 75);
        this.LeftFrontLeg.setRotationPoint(11.0F, -3.0F, -14.0F);
        this.LeftFrontLeg.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 27.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Head1.addChild(this.Snout);
        this.Snout.addChild(this.Beak);
        this.Body.addChild(this.Tail1);
        this.Saddle.addChild(this.Chest3);
        this.Head1.addChild(this.Crest);
        this.Saddle.addChild(this.Chest4);
        this.Saddle.addChild(this.Chest1);
        this.LeftHindLeg1.addChild(this.LeftHindLeg2);
        this.Body.addChild(this.Neck);
        this.Tail1.addChild(this.Tail2);
        this.Body.addChild(this.part27);
        this.Head1.addChild(this.horn1_1);
        this.Saddle.addChild(this.Saddle2);
        this.Head1.addChild(this.horn1);
        this.Neck.addChild(this.Head1);
        this.LeftHindLeg2.addChild(this.LeftHindLeg3);
        this.RightHindLeg2.addChild(this.RightHindLeg3);
        this.Snout.addChild(this.nasalhorn);
        this.RightHindLeg1.addChild(this.RightHindLeg2);
        this.Tail1.addChild(this.caudalvertebrae);
        this.Saddle.addChild(this.Chest2);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.LeftHindLeg1, this.RightHindLeg1, this.Body, this.RightFrontLeg, this.Saddle, this.LeftFrontLeg).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(TriceratopsSkeletonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
