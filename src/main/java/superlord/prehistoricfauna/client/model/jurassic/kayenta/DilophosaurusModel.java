package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.DilophosaurusEntity;

/**
 * DilophosaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class DilophosaurusModel extends EntityModel<DilophosaurusEntity> {
	public ModelRenderer Torso;
	public ModelRenderer Leg1Left;
	public ModelRenderer Leg1Right;
	public ModelRenderer ArmLeft;
	public ModelRenderer Neck;
	public ModelRenderer ArmRight;
	public ModelRenderer Tail;
	public ModelRenderer Head;
	public ModelRenderer QuillsNeck;
	public ModelRenderer Snout;
	public ModelRenderer Jaw;
	public ModelRenderer CrestLeft;
	public ModelRenderer CrestRight;
	public ModelRenderer Teeth;
	public ModelRenderer Waddle;
	public ModelRenderer Cheek;
	public ModelRenderer Mouth;
	public ModelRenderer BottomTeeth;
	public ModelRenderer Tail2;
	public ModelRenderer Leg2Left;
	public ModelRenderer FootLeft;
	public ModelRenderer Leg2Right;
	public ModelRenderer FootRight;

	public DilophosaurusModel() {
		this.textureWidth = 200;
		this.textureHeight = 200;
		this.Head = new ModelRenderer(this, 0, 70);
		this.Head.setRotationPoint(0.0F, -9.5F, -2.0F);
		this.Head.addBox(-2.5F, -5.0F, -6.0F, 5.0F, 5.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Head, -0.20001473294434044F, 0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 95, 3);
		this.Tail2.setRotationPoint(0.0F, 0.5F, 15.0F);
		this.Tail2.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 47.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Tail2, 0.05000000058364023F, 0.0F, 0.0F);
		this.CrestLeft = new ModelRenderer(this, 0, 0);
		this.CrestLeft.setRotationPoint(0.0F, -2.0F, 1.0F);
		this.CrestLeft.addBox(1.0F, -6.0F, -8.0F, 1.0F, 6.0F, 11.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(CrestLeft, 0.0781907508222411F, 0.10471975511965977F, 0.0F);
		this.FootRight = new ModelRenderer(this, 72, 94);
		this.FootRight.mirror = true;
		this.FootRight.setRotationPoint(0.0F, 14.0F, 1.0F);
		this.FootRight.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.CrestRight = new ModelRenderer(this, 0, 0);
		this.CrestRight.mirror = true;
		this.CrestRight.setRotationPoint(0.0F, -2.0F, 1.0F);
		this.CrestRight.addBox(-2.0F, -6.0F, -8.0F, 1.0F, 6.0F, 11.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(CrestRight, 0.0781907508222411F, -0.10471975511965977F, 0.0F);
		this.Leg2Left = new ModelRenderer(this, 72, 75);
		this.Leg2Left.setRotationPoint(2.5F, 10.0F, 2.0F);
		this.Leg2Left.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 15.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Leg2Left, 0.10000736647217022F, 0.0F, 0.0F);
		this.Mouth = new ModelRenderer(this, 0, 93);
		this.Mouth.setRotationPoint(0.0F, 0.0F, -6.0F);
		this.Mouth.addBox(-2.0F, 0.0F, -8.0F, 4.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Teeth = new ModelRenderer(this, 0, 113);
		this.Teeth.setRotationPoint(0.0F, 2.0F, 0.35F);
		this.Teeth.addBox(-1.5F, -2.0F, -8.0F, 3.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 0, 46);
		this.Neck.setRotationPoint(0.0F, 3.0F, -25.0F);
		this.Neck.addBox(-2.0F, -14.0F, -6.0F, 4.0F, 17.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Neck, 0.34999998744072486F, 0.0F, 0.0F);
		this.Tail = new ModelRenderer(this, 50, 4);
		this.Tail.setRotationPoint(0.0F, -3.5F, 1.5F);
		this.Tail.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 9.0F, 18.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Tail, -0.05000000058364023F, 0.0F, 0.0F);
		this.Snout = new ModelRenderer(this, 0, 81);
		this.Snout.setRotationPoint(0.0F, -2.0F, -6.0F);
		this.Snout.addBox(-2.0F, -2.0F, -8.0F, 4.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Torso = new ModelRenderer(this, 0, 0);
		this.Torso.setRotationPoint(0.0F, -3.0F, 9.0F);
		this.Torso.addBox(-4.0F, -4.0F, -27.0F, 8.0F, 14.0F, 32.0F, 0.0F, 0.0F, 0.0F);
		this.ArmRight = new ModelRenderer(this, 41, 46);
		this.ArmRight.mirror = true;
		this.ArmRight.setRotationPoint(-2.5F, 5.0F, -23.0F);
		this.ArmRight.addBox(-3.0F, 0.0F, -2.0F, 3.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(ArmRight, 0.149923785409474F, 0.0F, 0.0F);
		this.FootLeft = new ModelRenderer(this, 72, 94);
		this.FootLeft.setRotationPoint(0.0F, 14.0F, 1.0F);
		this.FootLeft.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.BottomTeeth = new ModelRenderer(this, -1, 132);
		this.BottomTeeth.setRotationPoint(0.0F, -1.5F, 0.4F);
		this.BottomTeeth.addBox(-1.0F, 0.0F, -8.0F, 2.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.Leg2Right = new ModelRenderer(this, 72, 75);
		this.Leg2Right.mirror = true;
		this.Leg2Right.setRotationPoint(-1.5F, 10.0F, 2.0F);
		this.Leg2Right.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 15.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Leg2Right, 0.10000736647217022F, 0.0F, 0.0F);
		this.Waddle = new ModelRenderer(this, 22, 46);
		this.Waddle.setRotationPoint(0.0F, 2.0F, -4.0F);
		this.Waddle.addBox(-1.5F, 0.0F, -6.0F, 3.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.Leg1Left = new ModelRenderer(this, 72, 49);
		this.Leg1Left.setRotationPoint(2.0F, -2.0F, 5.0F);
		this.Leg1Left.addBox(-1.0F, -3.0F, -5.0F, 6.0F, 16.0F, 10.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Leg1Left, -0.10000736647217022F, 0.0F, 0.0F);
		this.Jaw = new ModelRenderer(this, 0, 103);
		this.Jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Jaw.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.Leg1Right = new ModelRenderer(this, 72, 49);
		this.Leg1Right.mirror = true;
		this.Leg1Right.setRotationPoint(-3.0F, -2.0F, 5.0F);
		this.Leg1Right.addBox(-4.0F, -3.0F, -5.0F, 6.0F, 16.0F, 10.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Leg1Right, -0.10000736647217022F, 0.0F, 0.0F);
		this.Cheek = new ModelRenderer(this, 24, 110);
		this.Cheek.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.Cheek.addBox(-1.5F, 0.0F, -5.0F, 3.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.ArmLeft = new ModelRenderer(this, 41, 46);
		this.ArmLeft.setRotationPoint(2.5F, 5.0F, -23.0F);
		this.ArmLeft.addBox(0.0F, 0.0F, -2.0F, 3.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(ArmLeft, 0.149923785409474F, 0.0F, 0.0F);
		this.QuillsNeck = new ModelRenderer(this, 40, 70);
		this.QuillsNeck.setRotationPoint(0.0F, -9.0F, -1.0F);
		this.QuillsNeck.addBox(0.0F, -9.0F, 0.0F, 0.0F, 9.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Neck.addChild(this.Head);
		this.Tail.addChild(this.Tail2);
		this.Snout.addChild(this.CrestLeft);
		this.Leg2Right.addChild(this.FootRight);
		this.Snout.addChild(this.CrestRight);
		this.Leg1Left.addChild(this.Leg2Left);
		this.Jaw.addChild(this.Mouth);
		this.Snout.addChild(this.Teeth);
		this.Torso.addChild(this.Neck);
		this.Torso.addChild(this.Tail);
		this.Head.addChild(this.Snout);
		this.Torso.addChild(this.ArmRight);
		this.Leg2Left.addChild(this.FootLeft);
		this.Mouth.addChild(this.BottomTeeth);
		this.Leg1Right.addChild(this.Leg2Right);
		this.Jaw.addChild(this.Waddle);
		this.Head.addChild(this.Jaw);
		this.Jaw.addChild(this.Cheek);
		this.Torso.addChild(this.ArmLeft);
		this.Neck.addChild(this.QuillsNeck);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Torso, this.Leg1Left, this.Leg1Right).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(DilophosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 1.0f;
		float walkDegree = 0.5f;
		float idleSpeed = 1.0f;
		float idleDegree = 1.0f;
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress =  entityIn.getMeleeProgress(partialTick);
		resetModel();
		if (entityIn.isAsleep()) {
			this.Head.rotationPointY = -10.0F;
			this.Head.rotateAngleX = -0.0781907508222411F;
			this.Head.rotateAngleY = 0.03874630989361682F;
			this.Head.rotateAngleZ = 0.19547687289441354F;
			this.Tail2.rotationPointX = -0.5F;
			this.Tail2.rotateAngleX = -0.4300491170387584F;
			this.Tail2.rotateAngleY = 0.19547687289441354F;
			this.Tail2.rotateAngleZ = -0.19547687289441354F;
			this.FootRight.rotationPointY = 15.0F;
			this.FootRight.rotationPointZ = 0.0F;
			this.FootRight.rotateAngleX = 2.0722294794824117F;
			this.FootRight.rotateAngleY = 1.7453292129831807E-4F;
			this.FootRight.rotateAngleZ = 0.0373500478236019F;
			this.Leg2Left.rotationPointY = 11.0F;
			this.Leg2Left.rotationPointZ = 5.0F;
			this.Leg2Left.rotateAngleX = -1.3685127304046198F;
			this.Leg2Left.rotateAngleY = -1.7453292129831807E-4F;
			this.Leg2Left.rotateAngleZ = 0.4300491170387584F;
			this.Neck.rotationPointX = -1.0F;
			this.Neck.rotationPointY = 1.0F;
			this.Neck.rotationPointZ = -24.0F;
			this.Neck.rotateAngleX = 1.6418312220247435F;
			this.Neck.rotateAngleY = 0.3122393925291412F;
			this.Neck.rotateAngleZ = -0.23457224414434488F;
			this.Tail.rotateAngleX = -0.27366763203903305F;
			this.Tail.rotateAngleY = -0.0781907508222411F;
			this.Tail.rotateAngleZ = 0.0F;
			this.Torso.rotationPointX = -3.0F;
			this.Torso.rotationPointY = 19F;
			this.Torso.rotateAngleX = -0.11728612207217244F;
			this.Torso.rotateAngleY = -0.039269908169872414F;
			this.Torso.rotateAngleZ = -1.2901473511162753F;
			this.ArmRight.rotationPointX = -3.0F;
			this.ArmRight.rotationPointY = 2.0F;
			this.ArmRight.rotateAngleX = -0.03909537541112055F;
			this.ArmRight.rotateAngleY = -0.03909537541112055F;
			this.ArmRight.rotateAngleZ = -0.23457224414434488F;
			this.FootLeft.rotationPointY = 15.0F;
			this.FootLeft.rotationPointZ = 0.9F;
			this.FootLeft.rotateAngleX = 1.8387043403444152F;
			this.FootLeft.rotateAngleY = -0.15725416959943073F;
			this.FootLeft.rotateAngleZ = -0.1563815016444822F;
			this.Leg2Right.rotationPointY = 11.0F;
			this.Leg2Right.rotateAngleX = -0.4300491170387584F;
			this.Leg2Right.rotateAngleY = -0.11728612207217244F;
			this.Leg2Right.rotateAngleZ = -0.19547687289441354F;
			this.Leg1Left.rotationPointX = 0.5F;
			this.Leg1Left.rotationPointY = 17.0F;
			this.Leg1Left.rotationPointZ = 7.0F;
			this.Leg1Left.rotateAngleX = -0.1563815016444822F;
			this.Leg1Left.rotateAngleY = -1.7453292129831807E-4F;
			this.Leg1Left.rotateAngleZ = -1.0555751236166873F;
			this.Leg1Right.rotationPointX = -2.5F;
			this.Leg1Right.rotationPointY = 21.2F;
			this.Leg1Right.rotationPointZ = 5.0F;
			this.Leg1Right.rotateAngleX = 0.4300491170387584F;
			this.Leg1Right.rotateAngleY = -0.11728612207217244F;
			this.Leg1Right.rotateAngleZ = -1.4467034063254554F;
			this.ArmLeft.rotationPointX = 3.0F;
			this.ArmLeft.rotationPointY = 6.0F;
			this.ArmLeft.rotateAngleX = 0.2738421523142173F;
			this.ArmLeft.rotateAngleY = 0.4300491170387584F;
			this.ArmLeft.rotateAngleZ = 0.7035422454473641F;
		} else {
			this.Neck.rotateAngleX = (MathHelper.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount + 0.35F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(35F);
			this.Torso.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)) + MathHelper.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
			this.Tail.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5)) + MathHelper.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
			this.Tail2.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5)) + MathHelper.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.15F * limbSwingAmount + 0.05F;
			this.Tail.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5) + MathHelper.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
			this.Tail2.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5) + MathHelper.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 1.0F * limbSwingAmount;
			this.Head.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount - 0.2F + attackProgress * (float) Math.toRadians(-35F);
			this.ArmLeft.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3)) + MathHelper.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
			this.ArmRight.rotateAngleX = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3)) + MathHelper.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
			this.Leg1Left.rotateAngleX = MathHelper.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount - 0.05F + MathHelper.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.05F;
			this.Leg2Left.rotateAngleX = MathHelper.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + 0.05F + MathHelper.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.05F;
			this.FootLeft.rotateAngleX = MathHelper.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.3F * limbSwingAmount + MathHelper.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount;
			this.Leg1Right.rotateAngleX = MathHelper.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount - 0.05F + MathHelper.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.05F;
			this.Leg2Right.rotateAngleX = MathHelper.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + 0.05F + MathHelper.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.05F;
			this.FootRight.rotateAngleX = MathHelper.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.3F * limbSwingAmount + MathHelper.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.3F * limbSwingAmount;
			this.Neck.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
			this.Jaw.rotateAngleX = attackProgress * (float) Math.toRadians(25F);
			if (entityIn.isInWater()) {
				this.Leg1Left.rotationPointY = 20;
				this.Leg1Right.rotationPointY = 20;
				this.Torso.rotationPointY = 20;
				this.Torso.rotateAngleX = -0.25F;
				this.Tail.rotateAngleX = 0.125F;
				this.Tail2.rotateAngleX = 0.125F;
				this.Neck.rotateAngleX = 0.5F;
				this.Leg1Left.rotateAngleX = -0.24271F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Leg1Right.rotateAngleX = 0.24271F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.ArmRight.rotateAngleX = 0.25F;
				this.ArmLeft.rotateAngleX = 0.25F;
				this.Leg2Left.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Leg2Right.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.FootLeft.rotateAngleX = 0.5F - (0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F));
				this.FootRight.rotateAngleX = 0.5F + (0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F));
				this.Tail.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.Head.rotationPointY = -9.5F;
		this.Head.rotateAngleX = -0.20001473294434044F;
		this.Head.rotateAngleY = 0;
		this.Head.rotateAngleZ = 0;
		this.Tail2.rotationPointX = 0.0F;
		this.Tail2.rotateAngleX = 0.05000000058364023F;
		this.Tail2.rotateAngleY = 0;
		this.Tail2.rotateAngleZ = 0;
		this.FootRight.rotationPointX = 0.0F;
		this.FootRight.rotationPointY = 14.0F;
		this.FootRight.rotationPointZ = 1.0F;
		this.FootRight.rotateAngleX = 0.0F;
		this.FootRight.rotateAngleY = 0.0F;
		this.FootRight.rotateAngleZ = 0.0F;
		this.Leg2Left.rotationPointY = 10.0F;
		this.Leg2Left.rotationPointZ = 2.0F;
		this.Leg2Left.rotateAngleX = 0.10000736647217022F;
		this.Leg2Left.rotateAngleY = 0;
		this.Leg2Left.rotateAngleZ = 0;
		this.Neck.rotationPointX = 0.0F;
		this.Neck.rotationPointY = 3.0F;
		this.Neck.rotationPointZ = -25.0F;
		this.Neck.rotateAngleX = 0.34999998744072486F;
		this.Neck.rotateAngleY = 0;
		this.Neck.rotateAngleZ = 0;
		this.Tail.rotateAngleX = -0.05000000058364023F;
		this.Tail.rotateAngleY = 0;
		this.Tail.rotateAngleY = 0;
		this.Torso.rotationPointX = 0;
		this.Torso.rotationPointY = -3.0F;
		this.Torso.rotateAngleX = 0;
		this.Torso.rotateAngleY = 0;
		this.Torso.rotateAngleZ = 0;
		this.ArmRight.rotationPointX = -2.5F;
		this.ArmRight.rotationPointY = 5.0F;
		this.ArmRight.rotateAngleX = 0.149923785409474F;
		this.ArmRight.rotateAngleY = 0;
		this.ArmRight.rotateAngleZ = 0;
		this.FootLeft.rotationPointX = 0.0F;
		this.FootLeft.rotationPointY = 14.0F;
		this.FootLeft.rotationPointZ = 1.0F;
		this.FootLeft.rotateAngleX = 0.0F;
		this.FootLeft.rotateAngleY = 0.0F;
		this.FootLeft.rotateAngleZ = 0.0F;
		this.Leg2Right.rotationPointY = 10.0F;
		this.Leg2Right.rotateAngleX = 0.10000736647217022F;
		this.Leg2Right.rotateAngleY = 0;
		this.Leg2Right.rotateAngleZ = 0;
		this.Leg1Left.rotationPointX = 2.0F;
		this.Leg1Left.rotationPointY = -2.0F;
		this.Leg1Left.rotationPointZ = 5.0F;
		this.Leg1Left.rotateAngleX = -0.10000736647217022F;
		this.Leg1Left.rotateAngleY = 0;
		this.Leg1Left.rotateAngleZ = 0;
		this.Leg1Right.rotationPointX = -3.0F;
		this.Leg1Right.rotationPointY = -2.0F;
		this.Leg1Right.rotationPointZ = 5.0F;
		this.Leg1Right.rotateAngleX = -0.10000736647217022F;
		this.Leg1Right.rotateAngleY = 0;
		this.Leg1Right.rotateAngleZ = 0;
		this.ArmLeft.rotationPointX = 2.5F;
		this.ArmLeft.rotationPointY = 5.0F;
		this.ArmLeft.rotateAngleX = 0.149923785409474F;
		this.ArmLeft.rotateAngleY = 0;
		this.ArmLeft.rotateAngleZ = 0;
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
