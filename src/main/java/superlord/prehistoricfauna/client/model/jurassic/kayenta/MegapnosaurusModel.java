package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.MegapnosaurusEntity;

/**
 * Syntarsus - bastion14
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class MegapnosaurusModel extends EntityModel<MegapnosaurusEntity> {
	public ModelRenderer Body;
	public ModelRenderer Leg;
	public ModelRenderer Leg_1;
	public ModelRenderer Neck;
	public ModelRenderer Tail;
	public ModelRenderer ArmRight;
	public ModelRenderer ArmLeft;
	public ModelRenderer Head;
	public ModelRenderer Snout;
	public ModelRenderer Tail2;
	public ModelRenderer Leg2;
	public ModelRenderer Leg2_1;

	public MegapnosaurusModel() {
		this.textureWidth = 80;
		this.textureHeight = 50;
		this.Head = new ModelRenderer(this, 0, 25);
		this.Head.setRotationPoint(0.0F, -4.0F, -2.0F);
		this.Head.addBox(-0.5F, -1.0F, -4.0F, 1.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 15.0F, 3.0F);
		this.Body.addBox(-1.5F, -2.0F, -10.0F, 3.0F, 4.0F, 12.0F, 0.0F, 0.0F, 0.0F);
		this.Snout = new ModelRenderer(this, 0, 32);
		this.Snout.setRotationPoint(0.0F, -1.0F, -0.9F);
		this.Snout.addBox(-0.5F, -1.0F, -2.5F, 1.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Leg2_1 = new ModelRenderer(this, 27, 27);
		this.Leg2_1.setRotationPoint(-1.5F, 2.5F, 1.49F);
		this.Leg2_1.addBox(-1.0F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.Leg = new ModelRenderer(this, 14, 17);
		this.Leg.setRotationPoint(0.0F, 15.5F, 2.5F);
		this.Leg.addBox(0.0F, -2.0F, -1.5F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 0, 17);
		this.Neck.setRotationPoint(0.0F, 0.0F, -9.0F);
		this.Neck.addBox(-0.5F, -5.0F, -2.0F, 1.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Leg2 = new ModelRenderer(this, 14, 27);
		this.Leg2.setRotationPoint(1.5F, 2.5F, 1.49F);
		this.Leg2.addBox(-2.0F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.Tail = new ModelRenderer(this, 21, 0);
		this.Tail.setRotationPoint(0.0F, -1.0F, 2.0F);
		this.Tail.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 36, 0);
		this.Tail2.setRotationPoint(0.0F, -0.5F, 6.0F);
		this.Tail2.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 12.0F, 0.0F, 0.0F, 0.0F);
		this.ArmLeft = new ModelRenderer(this, 42, 17);
		this.ArmLeft.setRotationPoint(-0.7F, 1.0F, -7.5F);
		this.ArmLeft.addBox(-1.0F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.Leg_1 = new ModelRenderer(this, 26, 17);
		this.Leg_1.setRotationPoint(0.0F, 15.5F, 2.5F);
		this.Leg_1.addBox(-2.0F, -2.0F, -1.5F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.ArmRight = new ModelRenderer(this, 37, 17);
		this.ArmRight.setRotationPoint(0.7F, 1.0F, -7.5F);
		this.ArmRight.addBox(0.0F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.Neck.addChild(this.Head);
		this.Head.addChild(this.Snout);
		this.Leg_1.addChild(this.Leg2_1);
		this.Body.addChild(this.Neck);
		this.Leg.addChild(this.Leg2);
		this.Body.addChild(this.Tail);
		this.Tail.addChild(this.Tail2);
		this.Body.addChild(this.ArmLeft);
		this.Body.addChild(this.ArmRight);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Leg_1, this.Leg, this.Body).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(MegapnosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress =  entityIn.getMeleeProgress(partialTick);
		resetModel();
		if (entityIn.isAsleep()) {
			this.Tail.rotateAngleX = -0.23457224414434488F;
			this.Tail.rotateAngleY = 0.3909537457888271F;
			this.Tail.rotationPointZ = 1.0F;
			this.Leg2.rotateAngleX = 1.407433498155583F;
			this.Leg2.rotationPointX = 1.2F;
			this.Leg2.rotationPointY = 4.5F;
			this.Leg2.rotationPointZ = 1.5F;
			this.Leg_1.rotateAngleX = -1.407433498155583F;
			this.Leg_1.rotateAngleY = 0.3909537457888271F;
			this.Leg_1.rotationPointY = 22.5F;
			this.Leg_1.rotationPointZ = 2.2F;
			this.ArmLeft.rotateAngleZ = 1.1339404363260046F;
			this.ArmLeft.rotationPointY = 0.0F;
			this.ArmLeft.rotationPointZ = -7.0F;
			this.Tail2.rotateAngleX = 0.11728612207217244F;
			this.Tail2.rotateAngleY = 0.6646214111173737F;
			this.Tail2.rotationPointX = -0.3F;
			this.Tail2.rotationPointY = 0.0F;
			this.Leg2_1.rotateAngleX = 1.407433498155583F;
			this.Leg2_1.rotationPointX = -1.2F;
			this.Leg2_1.rotationPointY = 4.5F;
			this.Leg2_1.rotationPointZ = 1.5F;
			this.ArmRight.rotateAngleZ = -1.13376586611655F;
			this.ArmRight.rotationPointY = 0.0F;
			this.ArmRight.rotationPointZ = -7.0F;
			this.Leg.rotateAngleX = -1.407433498155583F;
			this.Leg.rotateAngleY = -0.3909537457888271F;
			this.Leg.rotationPointY = 22.5F;
			this.Leg.rotationPointZ = 2.2F;
			this.Body.rotationPointY = 22.0F;
			this.Neck.rotateAngleX = 0;
			this.Neck.rotateAngleY = -1.2901473511162753F;
			this.Neck.rotateAngleZ = 0.3127630032889644F;
		} else {
			this.Leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.Leg_1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Tail.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tail2.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tail.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.Tail2.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.Neck.rotateAngleX = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
			this.ArmLeft.rotateAngleZ = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
			this.ArmRight.rotateAngleZ = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
			this.Neck.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			this.Head.rotateAngleX = attackProgress * (float) Math.toRadians(-15F);
			if (entityIn.isInWater()) {
				this.Leg.rotationPointY = 22;
				this.Leg_1.rotationPointY = 22;
				this.Body.rotationPointY = 20;
				this.Body.rotateAngleX = -0.25F;
				this.Tail.rotateAngleX = 0.125F;
				this.Tail2.rotateAngleX = 0.125F;
				this.Neck.rotateAngleX = 0.25F;
				this.Leg.rotateAngleX = -0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Leg_1.rotateAngleX = 0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.ArmRight.rotateAngleX = 0.25F;
				this.ArmLeft.rotateAngleX = 0.25F;
				this.Leg2.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Leg2_1.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Tail.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));

			}
		}
	}

	public void resetModel() {
		this.Neck.rotateAngleX = 0;
		this.Neck.rotateAngleY = 0;
		this.Neck.rotateAngleZ = 0;
		this.ArmLeft.rotateAngleX = 0;
		this.ArmLeft.rotateAngleY = 0;
		this.ArmLeft.rotateAngleZ = 0;
		this.ArmRight.rotateAngleX = 0;
		this.ArmRight.rotateAngleY = 0;
		this.ArmRight.rotateAngleZ = 0;
		this.Leg.rotateAngleX = 0;
		this.Leg.rotateAngleY = 0;
		this.Body.rotateAngleX = 0;
		this.Tail.rotateAngleX = 0;
		this.Tail.rotateAngleY = 0;
		this.Leg2.rotateAngleX = 0;
		this.Leg_1.rotateAngleX = 0;
		this.Leg_1.rotateAngleY = 0;
		this.ArmLeft.rotateAngleZ = 0;
		this.Tail2.rotateAngleX = 0;
		this.Tail2.rotateAngleY = 0;
		this.Leg2_1.rotateAngleX = 0;
		this.ArmRight.rotateAngleZ = 0;
		this.Body.rotationPointY = 15.0F;
		this.Leg2_1.rotationPointX = -1.5F;
		this.Leg2_1.rotationPointY = 2.5F;
		this.Leg2_1.rotationPointZ = 1.49F;
		this.Leg.rotationPointY = 15.5F;
		this.Leg.rotationPointZ = 2.5F;
		this.Leg2.rotationPointX = 1.5F;
		this.Leg2.rotationPointY = 2.5F;
		this.Leg2.rotationPointZ = 1.49F;
		this.Tail.rotationPointZ = 2.0F;
		this.Tail2.rotationPointX = 0.0F;
		this.Tail2.rotationPointY = -0.5F;
		this.ArmLeft.rotationPointY = 1.0F;
		this.ArmLeft.rotationPointZ = -7.5F;
		this.Leg_1.rotationPointY = 15.5F;
		this.Leg_1.rotationPointZ = 2.5F;
		this.ArmRight.rotationPointY = 1.0F;
		this.ArmRight.rotationPointZ = -7.5F;
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
