package superlord.prehistoricfauna.client.model.henos;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.henos.LandSentinelEntity;

/**
 * Land Sentinel - Ralof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class LandSentinelModel extends EntityModel<LandSentinelEntity> {
    public ModelRenderer Head;
    public ModelRenderer Mid1;
    public ModelRenderer ArmLeft;
    public ModelRenderer ArmRight;
    public ModelRenderer LegLeftFront;
    public ModelRenderer LegLeftMid;
    public ModelRenderer LegLeftBack;
    public ModelRenderer LegRightFront;
    public ModelRenderer LegRightMid;
    public ModelRenderer LegRightBack;
    public ModelRenderer Mid1Plate1;
    public ModelRenderer Mid1Plate2;
    public ModelRenderer Mid1Plate3;
    public ModelRenderer Mid1Plate4;
    public ModelRenderer Mid2;
    public ModelRenderer Mid2Plate1;
    public ModelRenderer Mid2Plate2;
    public ModelRenderer Mid2Plate3;
    public ModelRenderer Tail;
    public ModelRenderer Spike;
    public ModelRenderer Arm2Left;
    public ModelRenderer FlatLeft;
    public ModelRenderer Arm2Right;
    public ModelRenderer FlatRight;

    public LandSentinelModel() {
        this.textureWidth = 100;
        this.textureHeight = 200;
        this.LegRightFront = new ModelRenderer(this, 0, 107);
        this.LegRightFront.mirror = true;
        this.LegRightFront.setRotationPoint(-7.0F, 2.0F, -6.0F);
        this.LegRightFront.addBox(-17.0F, -6.0F, 0.0F, 17.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegRightFront, 0.0F, -0.19198621771937624F, 0.0F);
        this.ArmLeft = new ModelRenderer(this, 55, 54);
        this.ArmLeft.mirror = true;
        this.ArmLeft.setRotationPoint(8.0F, 4.0F, -12.0F);
        this.ArmLeft.addBox(0.0F, -1.0F, -1.0F, 12.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LegRightBack = new ModelRenderer(this, 0, 107);
        this.LegRightBack.mirror = true;
        this.LegRightBack.setRotationPoint(-7.0F, 2.0F, 0.0F);
        this.LegRightBack.addBox(-17.0F, -6.0F, 0.0F, 17.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegRightBack, 0.0F, 1.2217304763960306F, 0.0F);
        this.FlatRight = new ModelRenderer(this, 32, 64);
        this.FlatRight.setRotationPoint(-1.0F, 0.0F, -2.0F);
        this.FlatRight.addBox(0.0F, 0.0F, -15.0F, 10.0F, 0.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.ArmRight = new ModelRenderer(this, 55, 54);
        this.ArmRight.setRotationPoint(-8.0F, 4.0F, -13.0F);
        this.ArmRight.addBox(-12.0F, -1.0F, -1.0F, 12.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmRight, -0.03909537541112055F, 0.0F, 0.0F);
        this.Mid1 = new ModelRenderer(this, 0, 25);
        this.Mid1.setRotationPoint(0.0F, 0.9F, 0.0F);
        this.Mid1.addBox(-6.0F, 0.0F, -1.0F, 12.0F, 5.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.LegLeftFront = new ModelRenderer(this, 0, 107);
        this.LegLeftFront.setRotationPoint(7.0F, 2.0F, -6.0F);
        this.LegLeftFront.addBox(0.0F, -6.0F, 0.0F, 17.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegLeftFront, 0.0F, 0.19198621771937624F, 0.0F);
        this.Mid1Plate4 = new ModelRenderer(this, 55, 0);
        this.Mid1Plate4.setRotationPoint(0.0F, -1.0F, 16.0F);
        this.Mid1Plate4.addBox(-7.0F, 0.0F, 0.0F, 14.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.LegLeftBack = new ModelRenderer(this, 0, 107);
        this.LegLeftBack.setRotationPoint(7.0F, 2.0F, 0.0F);
        this.LegLeftBack.addBox(0.0F, -6.0F, 0.0F, 17.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegLeftBack, 0.0F, -1.2217304763960306F, 0.0F);
        this.Mid1Plate1 = new ModelRenderer(this, 55, 0);
        this.Mid1Plate1.setRotationPoint(0.0F, -1.0F, 1.0F);
        this.Mid1Plate1.addBox(-7.0F, 0.0F, 0.0F, 14.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Mid2Plate1 = new ModelRenderer(this, 55, 30);
        this.Mid2Plate1.setRotationPoint(1.0F, -1.0F, 2.0F);
        this.Mid2Plate1.addBox(-7.0F, 0.0F, 0.0F, 12.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Mid2Plate3 = new ModelRenderer(this, 55, 30);
        this.Mid2Plate3.setRotationPoint(1.0F, -1.0F, 10.0F);
        this.Mid2Plate3.addBox(-7.0F, 0.0F, 0.0F, 12.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 16.5F, 0.0F);
        this.Head.addBox(-7.0F, 0.0F, -17.0F, 14.0F, 6.0F, 17.0F, 0.0F, 0.0F, 0.0F);
        this.Arm2Right = new ModelRenderer(this, 55, 66);
        this.Arm2Right.setRotationPoint(-10.0F, 0.0F, 0.0F);
        this.Arm2Right.addBox(-3.0F, -0.5F, -16.0F, 3.0F, 1.0F, 17.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm2Right, 0.0F, -0.5235987755982988F, 0.0F);
        this.LegRightMid = new ModelRenderer(this, 0, 107);
        this.LegRightMid.mirror = true;
        this.LegRightMid.setRotationPoint(-7.0F, 2.0F, -3.0F);
        this.LegRightMid.addBox(-17.0F, -6.0F, 0.0F, 17.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegRightMid, 0.0F, 0.4363323129985824F, 0.0F);
        this.FlatLeft = new ModelRenderer(this, 32, 64);
        this.FlatLeft.mirror = true;
        this.FlatLeft.setRotationPoint(1.0F, 0.0F, -2.0F);
        this.FlatLeft.addBox(-10.0F, 0.0F, -15.0F, 10.0F, 0.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.Mid1Plate3 = new ModelRenderer(this, 55, 0);
        this.Mid1Plate3.setRotationPoint(0.0F, -1.0F, 11.0F);
        this.Mid1Plate3.addBox(-7.0F, 0.0F, 0.0F, 14.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Spike = new ModelRenderer(this, 54, 86);
        this.Spike.setRotationPoint(0.0F, 2.5F, 14.0F);
        this.Spike.addBox(-5.5F, 0.0F, -5.0F, 11.0F, 0.0F, 24.0F, 0.0F, 0.0F, 0.0F);
        this.LegLeftMid = new ModelRenderer(this, 0, 107);
        this.LegLeftMid.setRotationPoint(7.0F, 2.0F, -3.0F);
        this.LegLeftMid.addBox(0.0F, -6.0F, 0.0F, 17.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegLeftMid, 0.0F, -0.4363323129985824F, 0.0F);
        this.Mid2 = new ModelRenderer(this, 0, 53);
        this.Mid2.setRotationPoint(0.0F, -0.1F, 19.0F);
        this.Mid2.addBox(-5.0F, 0.0F, -1.0F, 10.0F, 5.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.Mid2Plate2 = new ModelRenderer(this, 55, 30);
        this.Mid2Plate2.setRotationPoint(0.0F, -1.0F, 6.0F);
        this.Mid2Plate2.addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Mid1Plate2 = new ModelRenderer(this, 55, 0);
        this.Mid1Plate2.setRotationPoint(0.0F, -1.0F, 6.0F);
        this.Mid1Plate2.addBox(-7.0F, 0.0F, 0.0F, 14.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Arm2Left = new ModelRenderer(this, 55, 66);
        this.Arm2Left.mirror = true;
        this.Arm2Left.setRotationPoint(11.0F, 0.0F, -1.0F);
        this.Arm2Left.addBox(0.0F, -0.5F, -16.0F, 3.0F, 1.0F, 17.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm2Left, 0.0F, 0.5235987755982988F, 0.0F);
        this.Tail = new ModelRenderer(this, 0, 72);
        this.Tail.setRotationPoint(0.0F, -0.1F, 12.0F);
        this.Tail.addBox(-2.5F, 0.0F, -2.0F, 5.0F, 5.0F, 25.0F, 0.0F, 0.0F, 0.0F);
        this.Head.addChild(this.LegRightFront);
        this.Head.addChild(this.ArmLeft);
        this.Head.addChild(this.LegRightBack);
        this.Arm2Right.addChild(this.FlatRight);
        this.Head.addChild(this.ArmRight);
        this.Head.addChild(this.Mid1);
        this.Head.addChild(this.LegLeftFront);
        this.Mid1.addChild(this.Mid1Plate4);
        this.Head.addChild(this.LegLeftBack);
        this.Mid1.addChild(this.Mid1Plate1);
        this.Mid2.addChild(this.Mid2Plate1);
        this.Mid2.addChild(this.Mid2Plate3);
        this.ArmRight.addChild(this.Arm2Right);
        this.Head.addChild(this.LegRightMid);
        this.Arm2Left.addChild(this.FlatLeft);
        this.Mid1.addChild(this.Mid1Plate3);
        this.Tail.addChild(this.Spike);
        this.Head.addChild(this.LegLeftMid);
        this.Mid1.addChild(this.Mid2);
        this.Mid2.addChild(this.Mid2Plate2);
        this.Mid1.addChild(this.Mid1Plate2);
        this.ArmLeft.addChild(this.Arm2Left);
        this.Mid2.addChild(this.Tail);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(LandSentinelEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float walkSpeed = 3.0f;
        float walkDegree = 2.0f;
    	this.Mid1.rotateAngleX = -0.025F * MathHelper.sin(0.1F * ageInTicks);
		this.Mid2.rotateAngleX = -0.025F * MathHelper.sin(0.1F * ageInTicks);
		this.Tail.rotateAngleX = -0.025F * MathHelper.sin(0.1F * ageInTicks);
		this.ArmRight.rotateAngleZ = -0.025F * MathHelper.sin(0.1F * ageInTicks);
		this.ArmRight.rotateAngleY = -0.025F * MathHelper.sin(0.1F * ageInTicks);
		this.Arm2Right.rotateAngleZ = -0.025F * MathHelper.sin(0.1F * ageInTicks);
		this.Arm2Right.rotateAngleY = -0.025F * MathHelper.sin(0.1F * ageInTicks);
		this.ArmLeft.rotateAngleZ = -(-0.025F * MathHelper.sin(0.1F * ageInTicks));
		this.ArmLeft.rotateAngleY = -(-0.025F * MathHelper.sin(0.1F * ageInTicks));
		this.Arm2Left.rotateAngleZ = -(-0.025F * MathHelper.sin(0.1F * ageInTicks));
		this.Arm2Left.rotateAngleY = -(-0.025F * MathHelper.sin(0.1F * ageInTicks));
		this.LegLeftFront.rotateAngleZ = -Math.abs(MathHelper.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 1F * limbSwingAmount);
		this.LegRightFront.rotateAngleZ = Math.abs(-(MathHelper.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 1F * limbSwingAmount));
		this.LegLeftMid.rotateAngleZ = -Math.abs(MathHelper.cos(limbSwing * walkSpeed * 0.15F + 1) * walkDegree * 1F * limbSwingAmount);
		this.LegRightMid.rotateAngleZ = Math.abs(-(MathHelper.cos(limbSwing * walkSpeed * 0.15F + 1) * walkDegree * 1F * limbSwingAmount));
		this.LegLeftBack.rotateAngleZ = -Math.abs(MathHelper.cos(limbSwing * walkSpeed * 0.15F + 2) * walkDegree * 1F * limbSwingAmount);
		this.LegRightBack.rotateAngleZ = Math.abs(-(MathHelper.cos(limbSwing * walkSpeed * 0.15F + 2) * walkDegree * 1F * limbSwingAmount));
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
