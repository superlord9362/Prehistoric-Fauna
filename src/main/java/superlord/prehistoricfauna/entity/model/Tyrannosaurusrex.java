package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.TyrannosaurusEntity;

/**
 * Tyrannosaurus rex - Weastian
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class Tyrannosaurusrex extends EntityModel<TyrannosaurusEntity> {
    public ModelRenderer Body1;
    public ModelRenderer LeftLeg1;
    public ModelRenderer RightLeg1;
    public ModelRenderer Body2;
    public ModelRenderer Tail1;
    public ModelRenderer Neck;
    public ModelRenderer LeftArm;
    public ModelRenderer RightArm;
    public ModelRenderer Head1;
    public ModelRenderer Snout;
    public ModelRenderer Jaw1;
    public ModelRenderer UpperTeeth;
    public ModelRenderer Jaw2;
    public ModelRenderer Jaw3;
    public ModelRenderer LowerTeeth;
    public ModelRenderer Tail2;
    public ModelRenderer LeftLeg2;
    public ModelRenderer LeftFeet;
    public ModelRenderer RightLeg2;
    public ModelRenderer RightFeet;

    public Tyrannosaurusrex() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.LeftLeg1 = new ModelRenderer(this, 0, 69);
        this.LeftLeg1.setRotationPoint(6.0F, -26.0F, -1.0F);
        this.LeftLeg1.addBox(-3.0F, -6.0F, -9.0F, 10.0F, 34.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 8, 69);
        this.Tail1.setRotationPoint(0.0F, -3.0F, 17.0F);
        this.Tail1.addBox(-5.0F, -5.0F, -8.0F, 10.0F, 18.0F, 58.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.04555309164612875F, 0.0F, 0.0F);
        this.LeftLeg2 = new ModelRenderer(this, 96, 72);
        this.LeftLeg2.setRotationPoint(2.0F, 26.0F, 9.0F);
        this.LeftLeg2.addBox(-3.0F, -8.0F, -1.0F, 6.0F, 30.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.RightArm = new ModelRenderer(this, 69, 0);
        this.RightArm.mirror = true;
        this.RightArm.setRotationPoint(-10.1F, 19.0F, -13.0F);
        this.RightArm.addBox(-1.0F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightArm, 0.27314402127920984F, 0.0F, 0.0F);
        this.LeftFeet = new ModelRenderer(this, 98, 50);
        this.LeftFeet.setRotationPoint(0.0F, 22.0F, 5.0F);
        this.LeftFeet.addBox(-4.0F, -1.0F, -13.0F, 8.0F, 3.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.RightFeet = new ModelRenderer(this, 98, 50);
        this.RightFeet.setRotationPoint(0.0F, 22.0F, 5.0F);
        this.RightFeet.addBox(-4.0F, -1.0F, -13.0F, 8.0F, 3.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg1 = new ModelRenderer(this, 0, 69);
        this.RightLeg1.setRotationPoint(-6.0F, -26.0F, -1.0F);
        this.RightLeg1.addBox(-7.0F, -6.0F, -9.0F, 10.0F, 34.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg1, -2.4802620430283604E-16F, 0.0F, 0.0F);
        this.Body2 = new ModelRenderer(this, 146, 0);
        this.Body2.setRotationPoint(0.0F, -3.0F, -16.0F);
        this.Body2.addBox(-11.0F, -5.0F, -23.0F, 22.0F, 28.0F, 31.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 92, 61);
        this.Tail2.setRotationPoint(0.0F, -2.0F, 50.0F);
        this.Tail2.addBox(-3.0F, -1.0F, -7.0F, 6.0F, 11.0F, 54.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw3 = new ModelRenderer(this, 47, 181);
        this.Jaw3.setRotationPoint(0.0F, 0.0F, -9.0F);
        this.Jaw3.addBox(-5.5F, -5.0F, 0.0F, 11.0F, 5.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, -29.0F, 0.0F);
        this.Body1.addBox(-7.5F, -10.0F, -16.0F, 15.0F, 33.0F, 33.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body1, 0.0F, 0.006283185556850939F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 69, 0);
        this.LeftArm.setRotationPoint(10.1F, 19.0F, -13.0F);
        this.LeftArm.addBox(-2.0F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftArm, 0.27314402127920984F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 57, 150);
        this.Snout.setRotationPoint(0.0F, -2.0F, -11.0F);
        this.Snout.addBox(-4.0F, 0.0F, -16.0F, 8.0F, 10.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.Head1 = new ModelRenderer(this, 0, 157);
        this.Head1.setRotationPoint(0.0F, -17.1F, -7.0F);
        this.Head1.addBox(-7.0F, -4.0F, -11.0F, 14.0F, 11.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.UpperTeeth = new ModelRenderer(this, 106, 150);
        this.UpperTeeth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.UpperTeeth.addBox(-3.5F, 0.0F, -15.99F, 7.0F, 12.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.LowerTeeth = new ModelRenderer(this, 45, 201);
        this.LowerTeeth.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.LowerTeeth.addBox(-3.0F, -3.0F, -15.0F, 6.0F, 7.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw2 = new ModelRenderer(this, 5, 212);
        this.Jaw2.setRotationPoint(0.0F, 1.0F, -11.0F);
        this.Jaw2.addBox(-4.0F, 0.0F, -16.0F, 8.0F, 5.0F, 17.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 167, 66);
        this.Neck.setRotationPoint(0.0F, 6.0F, -21.0F);
        this.Neck.addBox(-5.0F, -21.0F, -13.0F, 10.0F, 29.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.2275909337942703F, 0.0F, 0.0F);
        this.RightLeg2 = new ModelRenderer(this, 96, 72);
        this.RightLeg2.mirror = true;
        this.RightLeg2.setRotationPoint(-2.0F, 26.0F, 9.0F);
        this.RightLeg2.addBox(-3.0F, -8.0F, -1.0F, 6.0F, 30.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw1 = new ModelRenderer(this, 0, 186);
        this.Jaw1.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.Jaw1.addBox(-7.0F, 0.0F, -11.0F, 14.0F, 7.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.Body1.addChild(this.Tail1);
        this.LeftLeg1.addChild(this.LeftLeg2);
        this.Body2.addChild(this.RightArm);
        this.LeftLeg2.addChild(this.LeftFeet);
        this.RightLeg2.addChild(this.RightFeet);
        this.Body1.addChild(this.Body2);
        this.Tail1.addChild(this.Tail2);
        this.Jaw1.addChild(this.Jaw3);
        this.Body2.addChild(this.LeftArm);
        this.Head1.addChild(this.Snout);
        this.Neck.addChild(this.Head1);
        this.Snout.addChild(this.UpperTeeth);
        this.Jaw2.addChild(this.LowerTeeth);
        this.Jaw1.addChild(this.Jaw2);
        this.Body2.addChild(this.Neck);
        this.RightLeg1.addChild(this.RightLeg2);
        this.Head1.addChild(this.Jaw1);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.LeftLeg1, this.RightLeg1, this.Body1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(TyrannosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float speed = 0.8f;
    	float degree = 1.0f;
    	this.Neck.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.25F;
    	this.Body2.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.01F * limbSwingAmount;
    	this.Body1.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
    	this.Tail1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.15F;
    	this.Tail2.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.1F;
    	this.Tail1.rotateAngleY = MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.2F * limbSwingAmount;
    	this.Tail2.rotateAngleY = MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.25F * limbSwingAmount;
    	this.Head1.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.1F;
    	this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
    	this.RightArm.rotateAngleX = MathHelper.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
    	this.LeftLeg1.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount - 0.05F;
    	this.LeftLeg2.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.05F;
    	this.LeftFeet.rotateAngleX = MathHelper.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
    	this.RightLeg1.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount - 0.05F;
    	this.RightLeg2.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + 0.05F;
    	this.RightFeet.rotateAngleX = MathHelper.cos(2.0F + limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;

    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
