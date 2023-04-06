package superlord.prehistoricfauna.client.model.jurassic.morrison;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.StegosaurusEntity;

/**
 * Stegosaurus - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class StegosaurusModel extends EntityModel<StegosaurusEntity> {
	public ModelRenderer Body;
	public ModelRenderer LeftArm;
	public ModelRenderer RightArm;
	public ModelRenderer LeftThigh;
	public ModelRenderer RightThigh;
	public ModelRenderer Tail1;
	public ModelRenderer LeftBackPlates;
	public ModelRenderer Neck;
	public ModelRenderer RightBackPlates;
	public ModelRenderer Tail2;
	public ModelRenderer LeftTail1Plates;
	public ModelRenderer RightTail1Plates;
	public ModelRenderer RightThagomizers;
	public ModelRenderer RightTail2Plates;
	public ModelRenderer LeftThagomizers;
	public ModelRenderer LeftTail2Plates;
	public ModelRenderer LeftNeckPlates;
	public ModelRenderer Head;
	public ModelRenderer RightNeckPlates;
	public ModelRenderer Snout;
	public ModelRenderer LeftLeg;
	public ModelRenderer LeftFoot;
	public ModelRenderer RightLeg;
	public ModelRenderer RightFoot;

	public StegosaurusModel() {
		this.textureWidth = 256;
		this.textureHeight = 148;
		this.Head = new ModelRenderer(this, 94, 2);
		this.Head.setRotationPoint(0.0F, -1.5F, -23.0F);
		this.Head.addBox(-3.5F, -3.5F, -5.0F, 7.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, -18.0F, -21.0F);
		this.Body.addBox(-12.0F, 0.0F, 0.0F, 24.0F, 26.0F, 45.0F, 0.0F, 0.0F, 0.0F);
		this.RightArm = new ModelRenderer(this, 0, 0);
		this.RightArm.setRotationPoint(-8.0F, 1.0F, -14.0F);
		this.RightArm.addBox(-5.0F, -4.0F, -4.0F, 7.0F, 27.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.RightNeckPlates = new ModelRenderer(this, 70, 101);
		this.RightNeckPlates.mirror = true;
		this.RightNeckPlates.setRotationPoint(1.0F, -5.0F, -3.0F);
		this.RightNeckPlates.addBox(-2.0F, -10.0F, -18.0F, 0.0F, 10.0F, 18.0F, 0.0F, 0.0F, 0.0F);
		this.LeftLeg = new ModelRenderer(this, 0, 107);
		this.LeftLeg.setRotationPoint(2.5F, 17.0F, 2.0F);
		this.LeftLeg.addBox(-3.0F, -1.0F, -4.0F, 6.0F, 15.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.LeftBackPlates = new ModelRenderer(this, 157, 50);
		this.LeftBackPlates.setRotationPoint(2.0F, -21.0F, 3.0F);
		this.LeftBackPlates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 22.0F, 46.0F, 0.0F, 0.0F, 0.0F);
		this.LeftNeckPlates = new ModelRenderer(this, 70, 113);
		this.LeftNeckPlates.setRotationPoint(-1.0F, -15.0F, -18.0F);
		this.LeftNeckPlates.addBox(2.0F, 0.0F, 0.0F, 0.0F, 10.0F, 18.0F, 0.0F, 0.0F, 0.0F);
		this.LeftTail1Plates = new ModelRenderer(this, 138, 27);
		this.LeftTail1Plates.setRotationPoint(2.0F, -26.0F, 10.0F);
		this.LeftTail1Plates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 20.0F, 24.0F, 0.0F, 0.0F, 0.0F);
		this.LeftFoot = new ModelRenderer(this, 0, 130);
		this.LeftFoot.setRotationPoint(0.0F, 12.0F, 0.1F);
		this.LeftFoot.addBox(-3.5F, 0.0F, -6.0F, 7.0F, 3.0F, 10.0F, 0.0F, 0.0F, 0.0F);
		this.LeftThagomizers = new ModelRenderer(this, 41, 119);
		this.LeftThagomizers.setRotationPoint(3.0F, -2.0F, 19.0F);
		this.LeftThagomizers.addBox(0.0F, 0.0F, 0.0F, 21.0F, 0.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(LeftThagomizers, 0.0F, 0.0F, -0.7539822501773559F);
		this.RightFoot = new ModelRenderer(this, 0, 130);
		this.RightFoot.mirror = true;
		this.RightFoot.setRotationPoint(0.0F, 12.0F, 0.1F);
		this.RightFoot.addBox(-3.5F, 0.0F, -6.0F, 7.0F, 3.0F, 10.0F, 0.0F, 0.0F, 0.0F);
		this.RightTail1Plates = new ModelRenderer(this, 120, 38);
		this.RightTail1Plates.mirror = true;
		this.RightTail1Plates.setRotationPoint(-2.0F, -25.0F, -3.0F);
		this.RightTail1Plates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 19.0F, 33.0F, 0.0F, 0.0F, 0.0F);
		this.LeftThigh = new ModelRenderer(this, 0, 71);
		this.LeftThigh.setRotationPoint(7.0F, -8.0F, 15.0F);
		this.LeftThigh.addBox(-2.0F, -3.0F, -7.5F, 9.0F, 21.0F, 15.0F, 0.0F, 0.0F, 0.0F);
		this.RightTail2Plates = new ModelRenderer(this, 166, 13);
		this.RightTail2Plates.mirror = true;
		this.RightTail2Plates.setRotationPoint(-1.0F, -16.0F, 0.0F);
		this.RightTail2Plates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 13.0F, 25.0F, 0.0F, 0.0F, 0.0F);
		this.RightBackPlates = new ModelRenderer(this, 106, 77);
		this.RightBackPlates.mirror = true;
		this.RightBackPlates.setRotationPoint(-2.0F, -21.0F, 0.0F);
		this.RightBackPlates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 21.0F, 42.0F, 0.0F, 0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 94, 7);
		this.Tail2.setRotationPoint(0.0F, -2.0F, 34.0F);
		this.Tail2.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 7.0F, 30.0F, 0.0F, 0.0F, 0.0F);
		this.RightLeg = new ModelRenderer(this, 0, 107);
		this.RightLeg.mirror = true;
		this.RightLeg.setRotationPoint(-1.5F, 17.0F, 2.0F);
		this.RightLeg.addBox(-3.0F, -1.0F, -4.0F, 6.0F, 15.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Snout = new ModelRenderer(this, 96, 16);
		this.Snout.setRotationPoint(0.0F, -0.5F, -5.0F);
		this.Snout.addBox(-2.0F, -3.0F, -6.0F, 4.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 83, 73);
		this.Neck.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.Neck.addBox(-3.5F, -5.0F, -23.0F, 7.0F, 10.0F, 23.0F, 0.0F, 0.0F, 0.0F);
		this.RightThagomizers = new ModelRenderer(this, 41, 119);
		this.RightThagomizers.mirror = true;
		this.RightThagomizers.setRotationPoint(-3.0F, -2.0F, 19.0F);
		this.RightThagomizers.addBox(-21.0F, 0.0F, 0.0F, 21.0F, 0.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(RightThagomizers, 0.0F, 0.0F, 0.7539822501773559F);
		this.LeftTail2Plates = new ModelRenderer(this, 166, 10);
		this.LeftTail2Plates.setRotationPoint(1.0F, -12.0F, 5.0F);
		this.LeftTail2Plates.addBox(0.0F, 0.0F, 0.0F, 0.0F, 9.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.Tail1 = new ModelRenderer(this, 28, 73);
		this.Tail1.setRotationPoint(0.0F, 7.0F, 45.0F);
		this.Tail1.addBox(-5.0F, -6.0F, 0.0F, 10.0F, 12.0F, 34.0F, 0.0F, 0.0F, 0.0F);
		this.RightThigh = new ModelRenderer(this, 0, 71);
		this.RightThigh.mirror = true;
		this.RightThigh.setRotationPoint(-8.0F, -8.0F, 15.0F);
		this.RightThigh.addBox(-6.0F, -3.0F, -7.5F, 9.0F, 21.0F, 15.0F, 0.0F, 0.0F, 0.0F);
		this.LeftArm = new ModelRenderer(this, 0, 0);
		this.LeftArm.setRotationPoint(9.0F, 1.0F, -14.0F);
		this.LeftArm.addBox(-3.0F, -4.0F, -4.0F, 7.0F, 27.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Neck.addChild(this.Head);
		this.Neck.addChild(this.RightNeckPlates);
		this.LeftThigh.addChild(this.LeftLeg);
		this.Body.addChild(this.LeftBackPlates);
		this.Neck.addChild(this.LeftNeckPlates);
		this.Tail1.addChild(this.LeftTail1Plates);
		this.LeftLeg.addChild(this.LeftFoot);
		this.Tail2.addChild(this.LeftThagomizers);
		this.RightLeg.addChild(this.RightFoot);
		this.Tail1.addChild(this.RightTail1Plates);
		this.Tail2.addChild(this.RightTail2Plates);
		this.Body.addChild(this.RightBackPlates);
		this.Tail1.addChild(this.Tail2);
		this.RightThigh.addChild(this.RightLeg);
		this.Head.addChild(this.Snout);
		this.Body.addChild(this.Neck);
		this.Tail2.addChild(this.RightThagomizers);
		this.Tail2.addChild(this.LeftTail2Plates);
		this.Body.addChild(this.Tail1);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		ImmutableList.of(this.Body, this.RightArm, this.LeftThigh, this.RightThigh, this.LeftArm).forEach((modelRenderer) -> {
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(StegosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress = entityIn.getMeleeProgress(partialTick);
		float leftOrRight = entityIn.getMeleeDirection() ? 1.0F : -1.0F;
		resetModel();
		if (entityIn.isAsleep()) {
			this.Neck.rotationPointX = 3;
			this.Neck.rotationPointY = 11;
			this.Neck.rotationPointZ = 2;
			this.Neck.rotateAngleX = 0.8025023820775095F;
			this.Neck.rotateAngleY = -0.03665191262740524F;
			this.RightFoot.rotateAngleX = 0.18256144042439712F;
			this.RightFoot.rotateAngleY = 0.18256144042439712F;
			this.RightFoot.rotateAngleZ = -0.036477379868653376F;
			this.RightThigh.rotationPointX = -6;
			this.RightThigh.rotationPointY = 1;
			this.RightThigh.rotationPointZ = 14;
			this.RightThigh.rotateAngleX = -0.14608405639455457F;
			this.RightThigh.rotateAngleY = -0.14625859331449564F;
			this.RightThigh.rotateAngleZ = 0.6932448001974364F;
			this.LeftArm.rotationPointY = 21.2F;
			this.LeftArm.rotateAngleX = -0.21868975061435758F;
			this.LeftArm.rotateAngleY = -0.036477379868653376F;
			this.LeftArm.rotateAngleZ = 1.460491523395177F;
			this.LeftLeg.rotateAngleX = 0.1459095194746135F;
			this.LeftLeg.rotateAngleZ = 0.07278023113974408F;
			this.Tail1.rotationPointY = 8.0F;
			this.Tail1.rotationPointZ = 43;
			this.Tail1.rotateAngleX = -0.4782202083885436F;
			this.Tail1.rotateAngleY = 0.18238690350445608F;
			this.Tail1.rotateAngleZ = -0.2553416715641412F;
			this.Body.rotationPointX = 17;
			this.Body.rotationPointY = 6.6F;
			this.Body.rotateAngleX = -0.03665191262740524F;
			this.Body.rotateAngleY = -0.07312929665724782F;
			this.Body.rotateAngleZ = 1.2407545013269026F;
			this.LeftThigh.rotationPointY = 17.7F;
			this.LeftThigh.rotateAngleX = 0.4742059590984399F;
			this.LeftThigh.rotateAngleZ = 1.4606660936046318F;
			this.Head.rotateAngleX = -0.036477379868653376F;
			this.Tail2.rotateAngleX = -0.10943214376714933F;
			this.Tail2.rotateAngleY = -0.4010766541188137F;
			this.Tail2.rotateAngleZ = -0.3282964229790696F;
			this.RightArm.rotationPointY = 5.0F;
			this.RightArm.rotateAngleX = 0.3282964229790696F;
			this.RightArm.rotateAngleY = -1.7453292129831807E-4F;
			this.RightArm.rotateAngleZ = 0.36477380700891215F;
		} else {
			this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
			this.LeftThigh.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
			this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
			this.LeftFoot.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
			this.RightThigh.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
			this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
			this.RightFoot.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
			this.Tail1.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount) + attackProgress * leftOrRight * (float) Math.toRadians(30F);
			this.Tail2.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount) + attackProgress * leftOrRight * (float) Math.toRadians(30F);
			this.Tail1.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.15F * limbSwingAmount - 0.15F);
			this.Tail2.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount);
			this.Tail2.rotateAngleZ = attackProgress * leftOrRight * (float)Math.toRadians(30F);
			this.Body.rotateAngleX = (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)));
			this.Neck.rotateAngleX = (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (headPitch * ((float) Math.PI / 180F));
			this.Neck.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
			if (entityIn.isEating()) {
				this.Neck.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
				this.Body.rotateAngleX = 0.2F;
				this.RightArm.rotateAngleZ = 0.3F;
				this.LeftArm.rotateAngleZ = -0.3F;
			}
			if (entityIn.isInWater()) {
				this.Body.rotationPointY = 3;
				this.Body.rotateAngleX = -0.125F;
				this.Tail1.rotateAngleX = 0.0625F;
				this.Tail2.rotateAngleX = 0.0625F;
				this.LeftThigh.rotationPointY = 19;
				this.RightThigh.rotationPointY = 19;
				this.LeftArm.rotationPointY = 23;
				this.RightArm.rotationPointY = 23;
				this.LeftThigh.rotateAngleX = -0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RightThigh.rotateAngleX = 0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LeftFoot.rotateAngleX = 0.5F - (0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F));
				this.RightFoot.rotateAngleX = 0.5F + (0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F));
				this.RightArm.rotateAngleX = -0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LeftArm.rotateAngleX = 0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Neck.rotateAngleX = 0.125F;
				this.Tail1.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.Neck.rotationPointX = 0;
		this.Neck.rotationPointY = 10;
		this.Neck.rotationPointZ = 0;
		this.Neck.rotateAngleX = 0;
		this.Neck.rotateAngleY = 0;
		this.RightFoot.rotateAngleX = 0;
		this.RightFoot.rotateAngleY = 0;
		this.RightFoot.rotateAngleZ = 0;
		this.RightThigh.rotationPointX = -8;
		this.RightThigh.rotationPointY = -8;
		this.RightThigh.rotationPointZ = 15;
		this.RightThigh.rotateAngleX = 0;
		this.RightThigh.rotateAngleY = 0;
		this.RightThigh.rotateAngleZ = 0;
		this.LeftArm.rotationPointY = 1.0F;
		this.LeftArm.rotateAngleX = 0;
		this.LeftArm.rotateAngleY = 0;
		this.LeftArm.rotateAngleZ = 0;
		this.LeftLeg.rotateAngleX = 0;
		this.LeftLeg.rotateAngleZ = 0;
		this.Tail1.rotationPointY = 7.0F;
		this.Tail1.rotationPointZ = 45;
		this.Tail1.rotateAngleX = 0;
		this.Tail1.rotateAngleY = 0;
		this.Tail1.rotateAngleZ = 0;
		this.Body.rotationPointX = 0;
		this.Body.rotationPointY = -18;
		this.Body.rotateAngleX = 0;
		this.Body.rotateAngleY = 0;
		this.Body.rotateAngleZ = 0;
		this.LeftThigh.rotationPointY = -8.0F;
		this.LeftThigh.rotateAngleX = 0;
		this.LeftThigh.rotateAngleY = 0;
		this.LeftThigh.rotateAngleZ = 0;
		this.Head.rotateAngleX = 0;
		this.Tail2.rotateAngleX = 0;
		this.Tail2.rotateAngleY = 0;
		this.Tail2.rotateAngleZ = 0;
		this.RightArm.rotationPointY = 1.0F;
		this.RightArm.rotateAngleX = 0;
		this.RightArm.rotateAngleY = 0;
		this.RightArm.rotateAngleZ = 0;
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
