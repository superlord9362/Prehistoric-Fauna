package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.AnkylosaurusSkeletonEntity;

/**
 * Ankylosaurus - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class AnkylosaurusSkeleton extends EntityModel<AnkylosaurusSkeletonEntity> {
    public ModelRenderer Body;
    public ModelRenderer LeftThigh;
    public ModelRenderer RightThigh;
    public ModelRenderer Neck;
    public ModelRenderer LeftArm;
    public ModelRenderer Tail1;
    public ModelRenderer RightArm;
    public ModelRenderer Osteoderms;
    public ModelRenderer Vertebrae;
    public ModelRenderer LeftLeg;
    public ModelRenderer LeftFoot;
    public ModelRenderer RightLeg;
    public ModelRenderer RightFoot;
    public ModelRenderer Head;
    public ModelRenderer NeckVertebrae;
    public ModelRenderer Snout;
    public ModelRenderer LeftOsteoderm;
    public ModelRenderer RightOsteoderm;
    public ModelRenderer LeftCheekbone;
    public ModelRenderer RightCheekbone;
    public ModelRenderer Tail2;
    public ModelRenderer TailOsteoderms;
    public ModelRenderer TailVertebrae;
    public ModelRenderer TailClub;
    public ModelRenderer Tail2Vertebrae;

    public AnkylosaurusSkeleton() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.RightCheekbone = new ModelRenderer(this, 136, 78);
        this.RightCheekbone.setRotationPoint(-3.0F, 3.0F, -2.0F);
        this.RightCheekbone.addBox(-4.0F, -2.0F, 0.0F, 4.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightCheekbone, 0.0F, -0.18849556254433897F, -0.0F);
        this.RightOsteoderm = new ModelRenderer(this, 132, 63);
        this.RightOsteoderm.setRotationPoint(-3.0F, -3.0F, -2.0F);
        this.RightOsteoderm.addBox(-4.0F, -2.0F, 0.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightOsteoderm, 0.12566369449226195F, -0.2513273889845239F, -0.0F);
        this.TailVertebrae = new ModelRenderer(this, 65, 156);
        this.TailVertebrae.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.TailVertebrae.addBox(0.0F, -2.0F, 0.0F, 0.0F, 5.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.RightArm = new ModelRenderer(this, 35, 167);
        this.RightArm.mirror = true;
        this.RightArm.setRotationPoint(-8.5F, 9.0F, -26.0F);
        this.RightArm.addBox(-6.0F, -1.0F, -3.0F, 6.0F, 15.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 101, 0);
        this.Tail1.setRotationPoint(0.0F, -1.0F, 10.0F);
        this.Tail1.addBox(-5.0F, -0.5F, 0.0F, 10.0F, 10.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.LeftFoot = new ModelRenderer(this, 6, 188);
        this.LeftFoot.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.LeftFoot.addBox(-3.5F, 0.0F, -5.0F, 7.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.RightFoot = new ModelRenderer(this, 6, 188);
        this.RightFoot.mirror = true;
        this.RightFoot.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.RightFoot.addBox(-3.5F, 0.0F, -5.0F, 7.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 1.0F, 12.0F);
        this.Body.addBox(-14.0F, -3.0F, -31.0F, 28.0F, 17.0F, 41.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 6, 167);
        this.LeftLeg.setRotationPoint(2.0F, 14.0F, 4.0F);
        this.LeftLeg.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 7.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.LeftThigh = new ModelRenderer(this, 6, 136);
        this.LeftThigh.setRotationPoint(9.5F, 1.0F, 1.0F);
        this.LeftThigh.addBox(-2.0F, 0.0F, -5.0F, 8.0F, 14.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.Vertebrae = new ModelRenderer(this, 40, 26);
        this.Vertebrae.setRotationPoint(0.0F, 0.0F, -31.0F);
        this.Vertebrae.addBox(0.0F, -5.0F, 0.0F, 0.0F, 19.0F, 43.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 91);
        this.Head.setRotationPoint(0.0F, 1.2F, -6.0F);
        this.Head.addBox(-6.0F, -4.0F, -13.0F, 12.0F, 10.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2Vertebrae = new ModelRenderer(this, 163, 36);
        this.Tail2Vertebrae.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail2Vertebrae.addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.LeftCheekbone = new ModelRenderer(this, 154, 79);
        this.LeftCheekbone.setRotationPoint(3.0F, 3.0F, -2.0F);
        this.LeftCheekbone.addBox(0.0F, -2.0F, 0.0F, 4.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftCheekbone, 0.0F, 0.18849556254433897F, -0.0F);
        this.Snout = new ModelRenderer(this, 57, 91);
        this.Snout.setRotationPoint(0.0F, 1.0F, -13.0F);
        this.Snout.addBox(-4.0F, -3.0F, -2.0F, 8.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Osteoderms = new ModelRenderer(this, 57, 103);
        this.Osteoderms.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Osteoderms.addBox(-15.0F, -4.0F, -32.0F, 30.0F, 17.0F, 43.0F, 0.0F, 0.0F, 0.0F);
        this.TailClub = new ModelRenderer(this, 157, 13);
        this.TailClub.setRotationPoint(0.0F, 0.0F, 15.0F);
        this.TailClub.addBox(-5.0F, -1.0F, 0.0F, 10.0F, 6.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.LeftOsteoderm = new ModelRenderer(this, 154, 63);
        this.LeftOsteoderm.setRotationPoint(3.0F, -3.0F, -2.0F);
        this.LeftOsteoderm.addBox(0.0F, -2.0F, 0.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftOsteoderm, 0.12566369449226195F, 0.2513273889845239F, -0.0F);
        this.Tail2 = new ModelRenderer(this, 157, 31);
        this.Tail2.setRotationPoint(0.0F, -1.0F, 18.0F);
        this.Tail2.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 4.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 63);
        this.Neck.setRotationPoint(0.0F, -3.0F, -31.0F);
        this.Neck.addBox(-5.0F, 0.0F, -10.0F, 10.0F, 10.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.NeckVertebrae = new ModelRenderer(this, 75, 59);
        this.NeckVertebrae.setRotationPoint(0.0F, 3.0F, -6.0F);
        this.NeckVertebrae.addBox(0.0F, -5.0F, 0.0F, 0.0F, 10.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg = new ModelRenderer(this, 6, 167);
        this.RightLeg.mirror = true;
        this.RightLeg.setRotationPoint(-2.0F, 14.0F, 4.0F);
        this.RightLeg.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 7.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.RightThigh = new ModelRenderer(this, 6, 136);
        this.RightThigh.mirror = true;
        this.RightThigh.setRotationPoint(-9.5F, 1.0F, 1.0F);
        this.RightThigh.addBox(-6.0F, 0.0F, -5.0F, 8.0F, 14.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 35, 167);
        this.LeftArm.setRotationPoint(8.5F, 9.0F, -26.0F);
        this.LeftArm.addBox(0.0F, -1.0F, -3.0F, 6.0F, 15.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.TailOsteoderms = new ModelRenderer(this, 40, 110);
        this.TailOsteoderms.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.TailOsteoderms.addBox(-6.0F, -0.5F, 0.0F, 12.0F, 10.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.Head.addChild(this.RightCheekbone);
        this.Head.addChild(this.RightOsteoderm);
        this.Tail1.addChild(this.TailVertebrae);
        this.Body.addChild(this.RightArm);
        this.Body.addChild(this.Tail1);
        this.LeftLeg.addChild(this.LeftFoot);
        this.RightLeg.addChild(this.RightFoot);
        this.LeftThigh.addChild(this.LeftLeg);
        this.Body.addChild(this.LeftThigh);
        this.Body.addChild(this.Vertebrae);
        this.Neck.addChild(this.Head);
        this.Tail2.addChild(this.Tail2Vertebrae);
        this.Head.addChild(this.LeftCheekbone);
        this.Head.addChild(this.Snout);
        this.Body.addChild(this.Osteoderms);
        this.Tail2.addChild(this.TailClub);
        this.Head.addChild(this.LeftOsteoderm);
        this.Tail1.addChild(this.Tail2);
        this.Body.addChild(this.Neck);
        this.Neck.addChild(this.NeckVertebrae);
        this.RightThigh.addChild(this.RightLeg);
        this.Body.addChild(this.RightThigh);
        this.Body.addChild(this.LeftArm);
        this.Tail1.addChild(this.TailOsteoderms);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
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
