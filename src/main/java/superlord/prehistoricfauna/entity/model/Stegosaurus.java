package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.StegosaurusEntity;

/**
 * StegosaurusModel - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class Stegosaurus extends EntityModel<StegosaurusEntity> {
    public ModelRenderer Body1;
    public ModelRenderer LeftLeg1;
    public ModelRenderer RightLeg1;
    public ModelRenderer Neck1;
    public ModelRenderer Tail1;
    public ModelRenderer RightArm;
    public ModelRenderer LeftArm;
    public ModelRenderer RightBackPlates;
    public ModelRenderer LeftBackPlates;
    public ModelRenderer Head1;
    public ModelRenderer RightNeckPlates;
    public ModelRenderer LeftNeckPlates;
    public ModelRenderer Snout1;
    public ModelRenderer Tail2;
    public ModelRenderer LeftTail1Plates;
    public ModelRenderer RightTail1Plates;
    public ModelRenderer LeftThagomizers;
    public ModelRenderer RightThagomizers;
    public ModelRenderer RightTail2Plates;
    public ModelRenderer LeftTail2Plates;
    public ModelRenderer LeftLeg2;
    public ModelRenderer LeftFoot;
    public ModelRenderer RightLeg2;
    public ModelRenderer RightFoot;

    public Stegosaurus() {
        this.textureWidth = 250;
        this.textureHeight = 300;
        this.RightBackPlates = new ModelRenderer(this, 49, 137);
        this.RightBackPlates.setRotationPoint(-2.0F, -12.0F, -42.0F);
        this.RightBackPlates.addBox(0.0F, -21.0F, 0.0F, 0.0F, 21.0F, 45.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 134, 0);
        this.Tail1.setRotationPoint(0.0F, -8.0F, 6.0F);
        this.Tail1.addBox(-5.0F, -3.0F, 0.0F, 10.0F, 12.0F, 34.0F, 0.0F, 0.0F, 0.0F);
        this.LeftThagomizers = new ModelRenderer(this, 0, 264);
        this.LeftThagomizers.setRotationPoint(3.5F, -1.0F, 16.0F);
        this.LeftThagomizers.addBox(0.0F, 0.0F, 0.0F, 40.0F, 0.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftThagomizers, 0.0F, 0.0F, -0.7539822501773559F);
        this.Neck1 = new ModelRenderer(this, 0, 74);
        this.Neck1.setRotationPoint(0.0F, -4.0F, -39.0F);
        this.Neck1.addBox(-3.5F, -3.0F, -23.0F, 7.0F, 10.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.Snout1 = new ModelRenderer(this, 27, 115);
        this.Snout1.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.Snout1.addBox(-2.0F, -3.0F, -6.0F, 4.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.LeftTail2Plates = new ModelRenderer(this, 146, 190);
        this.LeftTail2Plates.setRotationPoint(1.0F, -2.0F, 1.0F);
        this.LeftTail2Plates.addBox(0.0F, -13.0F, 0.0F, 0.0F, 13.0F, 30.0F, 0.0F, 0.0F, 0.0F);
        this.RightThagomizers = new ModelRenderer(this, 0, 282);
        this.RightThagomizers.setRotationPoint(-2.5F, -1.0F, 16.0F);
        this.RightThagomizers.addBox(0.0F, 0.0F, 0.0F, 40.0F, 0.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightThagomizers, 0.0F, 0.0F, -2.3876104699914644F);
        this.LeftLeg1 = new ModelRenderer(this, 129, 104);
        this.LeftLeg1.setRotationPoint(3.0F, -12.0F, 11.0F);
        this.LeftLeg1.addBox(0.0F, 0.0F, -4.9F, 9.0F, 21.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.RightArm = new ModelRenderer(this, 78, 104);
        this.RightArm.setRotationPoint(-3.0F, 3.0F, -31.0F);
        this.RightArm.addBox(-7.0F, 0.0F, -5.0F, 7.0F, 27.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 134, 52);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 34.0F);
        this.Tail2.addBox(-2.5F, -2.0F, 0.0F, 5.0F, 6.0F, 31.0F, 0.0F, 0.0F, 0.0F);
        this.LeftFoot = new ModelRenderer(this, 187, 136);
        this.LeftFoot.setRotationPoint(4.5F, 12.0F, 0.1F);
        this.LeftFoot.addBox(-3.5F, 0.0F, -7.0F, 7.0F, 3.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.LeftBackPlates = new ModelRenderer(this, 49, 161);
        this.LeftBackPlates.setRotationPoint(2.0F, -12.0F, -39.0F);
        this.LeftBackPlates.addBox(0.0F, -21.0F, 0.0F, 0.0F, 21.0F, 45.0F, 0.0F, 0.0F, 0.0F);
        this.RightTail1Plates = new ModelRenderer(this, 141, 137);
        this.RightTail1Plates.setRotationPoint(-2.0F, -2.0F, 0.0F);
        this.RightTail1Plates.addBox(0.0F, -18.0F, 0.0F, 0.0F, 17.0F, 35.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg2 = new ModelRenderer(this, 187, 110);
        this.LeftLeg2.setRotationPoint(0.0F, 21.0F, 5.0F);
        this.LeftLeg2.addBox(1.6F, 0.0F, -5.0F, 6.0F, 15.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg2 = new ModelRenderer(this, 187, 110);
        this.RightLeg2.setRotationPoint(-6.0F, 21.0F, 5.0F);
        this.RightLeg2.addBox(-1.6F, 0.0F, -5.0F, 6.0F, 15.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Head1 = new ModelRenderer(this, 0, 119);
        this.Head1.setRotationPoint(0.0F, 0.0F, -22.0F);
        this.Head1.addBox(-3.5F, -3.0F, -6.0F, 7.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg1 = new ModelRenderer(this, 129, 104);
        this.RightLeg1.setRotationPoint(-3.0F, -12.0F, 11.0F);
        this.RightLeg1.addBox(-9.0F, 0.0F, -4.9F, 9.0F, 21.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, -7.0F, 17.0F);
        this.Body1.addBox(-9.0F, -12.0F, -39.0F, 18.0F, 26.0F, 45.0F, 0.0F, 0.0F, 0.0F);
        this.LeftNeckPlates = new ModelRenderer(this, 0, 180);
        this.LeftNeckPlates.setRotationPoint(1.0F, -3.0F, -23.0F);
        this.LeftNeckPlates.addBox(0.0F, -11.0F, 0.0F, 0.0F, 11.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 78, 104);
        this.LeftArm.setRotationPoint(3.0F, 3.0F, -31.0F);
        this.LeftArm.addBox(0.0F, 0.0F, -5.0F, 7.0F, 27.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.LeftTail1Plates = new ModelRenderer(this, 146, 161);
        this.LeftTail1Plates.setRotationPoint(2.0F, -2.0F, 0.0F);
        this.LeftTail1Plates.addBox(0.0F, -20.0F, 0.0F, 0.0F, 19.0F, 35.0F, 0.0F, 0.0F, 0.0F);
        this.RightTail2Plates = new ModelRenderer(this, 146, 146);
        this.RightTail2Plates.setRotationPoint(-1.0F, -2.0F, 1.0F);
        this.RightTail2Plates.addBox(0.0F, -13.0F, 0.0F, 0.0F, 13.0F, 30.0F, 0.0F, 0.0F, 0.0F);
        this.RightNeckPlates = new ModelRenderer(this, 0, 164);
        this.RightNeckPlates.setRotationPoint(-1.0F, -3.0F, -21.0F);
        this.RightNeckPlates.addBox(0.0F, -11.0F, 0.0F, 0.0F, 11.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.RightFoot = new ModelRenderer(this, 187, 136);
        this.RightFoot.setRotationPoint(1.5F, 12.0F, 0.1F);
        this.RightFoot.addBox(-3.5F, 0.0F, -7.0F, 7.0F, 3.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Body1.addChild(this.RightBackPlates);
        this.Body1.addChild(this.Tail1);
        this.Tail2.addChild(this.LeftThagomizers);
        this.Body1.addChild(this.Neck1);
        this.Head1.addChild(this.Snout1);
        this.Tail2.addChild(this.LeftTail2Plates);
        this.Tail2.addChild(this.RightThagomizers);
        this.Body1.addChild(this.RightArm);
        this.Tail1.addChild(this.Tail2);
        this.LeftLeg2.addChild(this.LeftFoot);
        this.Body1.addChild(this.LeftBackPlates);
        this.Tail1.addChild(this.RightTail1Plates);
        this.LeftLeg1.addChild(this.LeftLeg2);
        this.RightLeg1.addChild(this.RightLeg2);
        this.Neck1.addChild(this.Head1);
        this.Neck1.addChild(this.LeftNeckPlates);
        this.Body1.addChild(this.LeftArm);
        this.Tail1.addChild(this.LeftTail1Plates);
        this.Tail2.addChild(this.RightTail2Plates);
        this.Neck1.addChild(this.RightNeckPlates);
        this.RightLeg2.addChild(this.RightFoot);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.LeftLeg1, this.RightLeg1, this.Body1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(StegosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	      this.Neck1.rotateAngleX = headPitch * ((float)Math.PI / 180F);
	      this.Neck1.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
	      this.RightLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	      this.LeftLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	      this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	      this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
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
