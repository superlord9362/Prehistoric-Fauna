package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DidelphodonEntity;

/**
 * Didelphodon - Weastian
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class DidelphodonModel extends EntityModel<DidelphodonEntity> implements IHasArm {
	public ModelRenderer Body;
	public ModelRenderer Frontlegright;
	public ModelRenderer Frontlegleft;
	public ModelRenderer Hindlegleft;
	public ModelRenderer Hindlegright;
	public ModelRenderer Head;
	public ModelRenderer Tail;
	public ModelRenderer Snout;
	public ModelRenderer EarRight;
	public ModelRenderer EarLeft;
	public ModelRenderer Nose;

	public DidelphodonModel() {
		this.textureWidth = 32;
		this.textureHeight = 32;
		this.Head = new ModelRenderer(this, 9, 0);
		this.Head.setRotationPoint(0.0F, 0.0F, -6.0F);
		this.Head.addBox(-1.5F, -1.0F, -4.0F, 3.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Hindlegright = new ModelRenderer(this, 16, 8);
		this.Hindlegright.setRotationPoint(-0.9F, 21.0F, 2.9F);
		this.Hindlegright.addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Tail = new ModelRenderer(this, 0, 7);
		this.Tail.setRotationPoint(0.0F, 0.0F, 2.0F);
		this.Tail.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Tail, -0.13665927909957545F, 0.0F, 0.0F);
		this.Frontlegright = new ModelRenderer(this, 16, 8);
		this.Frontlegright.setRotationPoint(-0.9F, 21.0F, -2.9F);
		this.Frontlegright.addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Frontlegleft = new ModelRenderer(this, 16, 8);
		this.Frontlegleft.setRotationPoint(0.9F, 21.0F, -2.9F);
		this.Frontlegleft.addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Snout = new ModelRenderer(this, 2, 0);
		this.Snout.setRotationPoint(0.0F, 0.0F, -4.0F);
		this.Snout.addBox(-1.5F, -1.0F, -2.0F, 3.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Nose = new ModelRenderer(this, 0, 0);
		this.Nose.setRotationPoint(0.0F, -1.0F, -2.0F);
		this.Nose.addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.Hindlegleft = new ModelRenderer(this, 16, 8);
		this.Hindlegleft.setRotationPoint(0.9F, 21.0F, 2.9F);
		this.Hindlegleft.addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.EarRight = new ModelRenderer(this, 21, 2);
		this.EarRight.setRotationPoint(-1.5F, -1.0F, -1.0F);
		this.EarRight.addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.EarLeft = new ModelRenderer(this, 21, 2);
		this.EarLeft.setRotationPoint(1.5F, -1.0F, -1.0F);
		this.EarLeft.addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 20);
		this.Body.setRotationPoint(0.0F, 19.0F, 2.0F);
		this.Body.addBox(-2.0F, -1.0F, -6.0F, 4.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Body.addChild(this.Head);
		this.Body.addChild(this.Tail);
		this.Head.addChild(this.Snout);
		this.Snout.addChild(this.Nose);
		this.Head.addChild(this.EarRight);
		this.Head.addChild(this.EarLeft);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Hindlegright, this.Frontlegright, this.Frontlegleft, this.Hindlegleft, this.Body).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(DidelphodonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetModel();
		if (entityIn.isAsleep()) {
			this.Frontlegright.rotateAngleZ = -0.8210028961170991F;
			this.Body.rotateAngleZ = -1.5707963267948966F;
			this.Frontlegleft.rotateAngleX = 0.17453292519943295F;
			this.Frontlegleft.rotateAngleZ = -1.5707963267948966F;
			this.Head.rotateAngleX = 0.9075712110370513F;
			this.Head.rotateAngleY = -0.5585053606381855F;
			this.Head.rotateAngleZ = 0.6981317007977318F;
			this.Hindlegleft.rotateAngleX = -0.24434609527920614F;
			this.Hindlegleft.rotateAngleZ = -1.5707963267948966F;
			this.Hindlegright.rotateAngleZ = -0.7037167490777915F;
			this.Tail.rotateAngleX = -0.6283185307179586F;
			this.Tail.rotateAngleY = 0.22689280275926282F;
			this.Tail.rotateAngleZ = 0.5235987755982988F;
			this.Frontlegleft.rotationPointY = 24;
			this.Hindlegright.rotationPointX = 2;
			this.Hindlegright.rotationPointY = 20;
			this.Hindlegleft.rotationPointY = 24;
			this.Frontlegright.rotationPointX = 1.9F;
			this.Frontlegright.rotationPointY = 20.5F;
			this.Frontlegright.rotationPointZ = -3;
			this.Body.rotationPointX = -1;
			this.Body.rotationPointY = 22;
			this.Head.rotationPointX = 0.4F;
		}
		else {
			this.Head.rotateAngleX = (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)));
			this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			this.Hindlegright.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.Hindlegleft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Frontlegright.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Frontlegleft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.Tail.rotateAngleY = -0.25F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tail.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5)) - 0.2F;
			if (entityIn.isInWater()) {
				this.Frontlegleft.rotateAngleX = 0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.Hindlegright.rotateAngleX = 0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.Frontlegright.rotateAngleX = -0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.Hindlegleft.rotateAngleX = -0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.Tail.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}
	
	public void resetModel() {
		this.Frontlegright.rotateAngleX = 0;
		this.Frontlegright.rotateAngleZ = 0;
		this.Body.rotateAngleZ = 0;
		this.Frontlegleft.rotateAngleX = 0;
		this.Frontlegleft.rotateAngleZ = 0;
		this.Head.rotateAngleX = 0;
		this.Head.rotateAngleY = 0;
		this.Head.rotateAngleZ = 0;
		this.Hindlegleft.rotateAngleX = 0;
		this.Hindlegleft.rotateAngleZ = 0;
		this.Hindlegright.rotateAngleX = 0;
		this.Hindlegright.rotateAngleZ = 0;
		this.Tail.rotateAngleX = -0.13665927909957545F;
		this.Tail.rotateAngleY = 0;
		this.Tail.rotateAngleZ = 0;
		this.Frontlegleft.rotationPointY = 21;
		this.Hindlegright.rotationPointX = -0.9F;
		this.Hindlegright.rotationPointY = 21;
		this.Hindlegleft.rotationPointY = 21;
		this.Body.rotationPointX = 0;
		this.Body.rotationPointY = 19;
		this.Head.rotationPointX = 0;
		this.Frontlegright.rotationPointX = -0.9F;
		this.Frontlegright.rotationPointY = 21;
		this.Frontlegright.rotationPointZ = -2.9F;
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void translateHand(HandSide sideIn, MatrixStack matrixStackIn) {
		float f = sideIn == HandSide.RIGHT ? 1.0F : -1.0F;
		ModelRenderer modelrenderer = this.getArmForSide(sideIn);
		modelrenderer.rotationPointX += f;
		modelrenderer.translateRotate(matrixStackIn);
		modelrenderer.rotationPointX -= f;
		matrixStackIn.translate(0, 0.7, 0);
	}

	protected ModelRenderer getArmForSide(HandSide side) {
		return side == HandSide.LEFT ? this.Head : this.Head;
	}

}
