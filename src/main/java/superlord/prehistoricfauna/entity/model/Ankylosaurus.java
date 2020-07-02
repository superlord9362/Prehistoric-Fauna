package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.EntityAnkylosaurus;

/**
 * Ankylosaurus - Weastian
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class Ankylosaurus extends EntityModel<EntityAnkylosaurus> {
    public ModelRenderer Body;
    public ModelRenderer LeftFrontLeg;
    public ModelRenderer RightFrontLeg;
    public ModelRenderer LeftHindLeg1;
    public ModelRenderer RightHindLeg1;
    public ModelRenderer Neck;
    public ModelRenderer Tail1;
    public ModelRenderer Head1;
    public ModelRenderer Head2;
    public ModelRenderer Spike1;
    public ModelRenderer Spike1_1;
    public ModelRenderer Spike3;
    public ModelRenderer Spike4;
    public ModelRenderer Tail2;
    public ModelRenderer TailClub;
    public ModelRenderer LeftHindLeg2;
    public ModelRenderer LeftHindLeg3;
    public ModelRenderer RightHindLeg2;
    public ModelRenderer RightHindLeg3;

    public Ankylosaurus() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.TailClub = new ModelRenderer(this, 94, 85);
        this.TailClub.setRotationPoint(0.0F, 0.0F, 21.0F);
        this.TailClub.addBox(-5.5F, -4.0F, 0.0F, 11.0F, 8.0F, 17.0F, 0.0F, 0.0F, 0.0F);
        this.Spike1 = new ModelRenderer(this, 0, 33);
        this.Spike1.setRotationPoint(7.0F, -3.0F, 0.0F);
        this.Spike1.addBox(-4.0F, -3.0F, 0.0F, 5.0F, 5.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Spike1, 0.0911061832922575F, 0.27314402127920984F, 0.0F);
        this.Head1 = new ModelRenderer(this, 152, 97);
        this.Head1.setRotationPoint(0.0F, -1.0F, -12.0F);
        this.Head1.addBox(-7.0F, -5.0F, -12.0F, 14.0F, 12.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head1, 0.3186971254089062F, 0.0F, 0.0F);
        this.RightHindLeg3 = new ModelRenderer(this, 157, 0);
        this.RightHindLeg3.setRotationPoint(0.0F, 10.0F, 3.0F);
        this.RightHindLeg3.addBox(-4.0F, 0.0F, -6.0F, 8.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 0, 79);
        this.Tail1.setRotationPoint(0.0F, -1.0F, 18.0F);
        this.Tail1.addBox(-6.0F, -3.0F, -4.0F, 12.0F, 13.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.2275909337942703F, 0.0F, 0.0F);
        this.LeftHindLeg2 = new ModelRenderer(this, 200, 0);
        this.LeftHindLeg2.setRotationPoint(0.0F, 10.0F, 3.0F);
        this.LeftHindLeg2.addBox(-3.5F, -3.0F, -2.0F, 7.0F, 14.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Spike4 = new ModelRenderer(this, 29, 32);
        this.Spike4.setRotationPoint(-7.0F, 2.0F, -2.0F);
        this.Spike4.addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Spike4, 0.0F, -0.9105382388075086F, 0.0F);
        this.Spike1_1 = new ModelRenderer(this, 0, 33);
        this.Spike1_1.setRotationPoint(-7.0F, -3.0F, 0.0F);
        this.Spike1_1.addBox(-1.0F, -3.0F, 0.0F, 5.0F, 5.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Spike1_1, 0.0911061832922575F, -0.27314402127920984F, 0.0F);
        this.LeftHindLeg3 = new ModelRenderer(this, 157, 0);
        this.LeftHindLeg3.setRotationPoint(0.0F, 10.0F, 3.0F);
        this.LeftHindLeg3.addBox(-4.0F, 0.0F, -6.0F, 8.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Head2 = new ModelRenderer(this, 200, 93);
        this.Head2.setRotationPoint(0.0F, 0.0F, -12.0F);
        this.Head2.addBox(-5.5F, -3.0F, -3.0F, 11.0F, 9.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Spike3 = new ModelRenderer(this, 29, 32);
        this.Spike3.setRotationPoint(7.0F, 2.0F, -2.0F);
        this.Spike3.addBox(-4.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Spike3, 0.0F, 0.9105382388075086F, 0.0F);
        this.LeftFrontLeg = new ModelRenderer(this, 0, 0);
        this.LeftFrontLeg.setRotationPoint(12.0F, 7.0F, -17.0F);
        this.LeftFrontLeg.addBox(-3.0F, -3.0F, -4.0F, 7.0F, 20.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.RightHindLeg1 = new ModelRenderer(this, 190, 33);
        this.RightHindLeg1.setRotationPoint(-13.0F, 1.0F, 17.0F);
        this.RightHindLeg1.addBox(-5.0F, -4.0F, -8.0F, 10.0F, 19.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 45, 87);
        this.Tail2.setRotationPoint(0.0F, 3.0F, 17.0F);
        this.Tail2.addBox(-2.5F, -3.0F, -5.0F, 5.0F, 6.0F, 30.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.13665927909957545F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 121, 16);
        this.Neck.setRotationPoint(0.0F, -1.0F, -34.0F);
        this.Neck.addBox(-5.0F, -6.0F, -12.0F, 10.0F, 12.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, -0.18203784630933073F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 1.0F, 9.0F);
        this.Body.addBox(-15.5F, -9.0F, -34.0F, 31.0F, 22.0F, 52.0F, 0.0F, 0.0F, 0.0F);
        this.RightFrontLeg = new ModelRenderer(this, 0, 0);
        this.RightFrontLeg.mirror = true;
        this.RightFrontLeg.setRotationPoint(-12.0F, 7.0F, -17.0F);
        this.RightFrontLeg.addBox(-4.0F, -3.0F, -4.0F, 7.0F, 20.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.LeftHindLeg1 = new ModelRenderer(this, 190, 33);
        this.LeftHindLeg1.setRotationPoint(13.0F, 1.0F, 17.0F);
        this.LeftHindLeg1.addBox(-5.0F, -4.0F, -8.0F, 10.0F, 19.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.RightHindLeg2 = new ModelRenderer(this, 200, 0);
        this.RightHindLeg2.setRotationPoint(0.0F, 10.0F, 3.0F);
        this.RightHindLeg2.addBox(-3.5F, -3.0F, -2.0F, 7.0F, 14.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2.addChild(this.TailClub);
        this.Head1.addChild(this.Spike1);
        this.Neck.addChild(this.Head1);
        this.RightHindLeg2.addChild(this.RightHindLeg3);
        this.Body.addChild(this.Tail1);
        this.LeftHindLeg1.addChild(this.LeftHindLeg2);
        this.Head1.addChild(this.Spike4);
        this.Head1.addChild(this.Spike1_1);
        this.LeftHindLeg2.addChild(this.LeftHindLeg3);
        this.Head1.addChild(this.Head2);
        this.Head1.addChild(this.Spike3);
        this.Tail1.addChild(this.Tail2);
        this.Body.addChild(this.Neck);
        this.RightHindLeg1.addChild(this.RightHindLeg2);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.LeftFrontLeg, this.RightHindLeg1, this.Body, this.RightFrontLeg, this.LeftHindLeg1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(EntityAnkylosaurus entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	      this.Neck.rotateAngleX = headPitch * ((float)Math.PI / 180F);
	      this.Neck.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
	      this.RightHindLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	      this.LeftHindLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	      this.RightFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	      this.LeftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;	
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
