package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ChromogisaurusEntity;

/**
 * Chromogi - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ChromogisaurusModel extends EntityModel<ChromogisaurusEntity> {
	public ModelRenderer Body;
	public ModelRenderer LeftThigh;
	public ModelRenderer RightThigh;
	public ModelRenderer LeftArm;
	public ModelRenderer RightArm;
	public ModelRenderer Neck;
	public ModelRenderer Tail;
	public ModelRenderer Head;
	public ModelRenderer LeftLeg;
	public ModelRenderer LeftLeg_1;

	public ChromogisaurusModel() {
		this.textureWidth = 80;
		this.textureHeight = 64;
		this.LeftThigh = new ModelRenderer(this, 30, 0);
		this.LeftThigh.setRotationPoint(1.0F, 15.0F, 2.0F);
		this.LeftThigh.addBox(-0.5F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.RightArm = new ModelRenderer(this, 12, 18);
		this.RightArm.setRotationPoint(-1.5F, 1.0F, -6.0F);
		this.RightArm.addBox(-0.5F, -1.0F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.LeftLeg_1 = new ModelRenderer(this, 60, 0);
		this.LeftLeg_1.setRotationPoint(-0.6F, 5.0F, 1.0F);
		this.LeftLeg_1.addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.LeftLeg = new ModelRenderer(this, 60, 0);
		this.LeftLeg.setRotationPoint(0.6F, 5.0F, 1.0F);
		this.LeftLeg.addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.LeftArm = new ModelRenderer(this, 12, 18);
		this.LeftArm.setRotationPoint(1.5F, 1.0F, -6.0F);
		this.LeftArm.addBox(-0.5F, -1.0F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 0, 18);
		this.Neck.setRotationPoint(0.5F, -1.0F, -8.0F);
		this.Neck.addBox(-1.5F, -3.0F, -2.0F, 2.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Tail = new ModelRenderer(this, 31, 3);
		this.Tail.setRotationPoint(0.0F, -0.9F, 4.0F);
		this.Tail.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.RightThigh = new ModelRenderer(this, 39, 0);
		this.RightThigh.setRotationPoint(-1.0F, 15.0F, 2.0F);
		this.RightThigh.addBox(-1.5F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 0, 28);
		this.Head.setRotationPoint(0.0F, -3.0F, -1.0F);
		this.Head.addBox(-1.5F, -2.0F, -3.0F, 2.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 16.0F, 2.0F);
		this.Body.addBox(-1.5F, -2.0F, -8.0F, 3.0F, 4.0F, 12.0F, 0.0F, 0.0F, 0.0F);
		this.Body.addChild(this.RightArm);
		this.RightThigh.addChild(this.LeftLeg_1);
		this.LeftThigh.addChild(this.LeftLeg);
		this.Body.addChild(this.LeftArm);
		this.Body.addChild(this.Neck);
		this.Body.addChild(this.Tail);
		this.Neck.addChild(this.Head);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.LeftThigh, this.RightThigh, this.Body).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(ChromogisaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entityIn.isAsleep()) {
			this.Body.rotationPointY = 22;
			this.Body.rotateAngleZ =  -0.19547687289441354F;
			this.LeftLeg_1.rotationPointX = -0.5F;
			this.LeftLeg_1.rotationPointY = 3.6F;
			this.LeftLeg_1.rotationPointZ = 0.9F;
			this.LeftLeg_1.rotateAngleX = 0.07836527941980377F;
			this.LeftLeg_1.rotateAngleZ = 0.009250244536227243F;
			this.RightArm.rotationPointX = -2.3F;
			this.RightArm.rotationPointY = 0.9F;
			this.RightArm.rotationPointZ = -5.0F;
			this.RightArm.rotateAngleX = -1.6030848913251807F;
			this.RightArm.rotateAngleY = -0.036477379868653376F;
			this.RightArm.rotateAngleZ = 0.6003932893176602F;
			this.RightThigh.rotationPointY = 23.0F;
			this.RightThigh.rotationPointZ = 5.0F;
			this.RightThigh.rotateAngleX = -1.6041321794238546F;
			this.RightThigh.rotateAngleY = 0.35185837453889574F;
			this.LeftThigh.rotationPointY = 23.0F;
			this.LeftThigh.rotationPointZ = 5.0F;
			this.LeftThigh.rotateAngleX = -1.5653858487242918F;
			this.LeftThigh.rotateAngleY = -0.3127630032889644F;
			this.LeftLeg.rotationPointX = 0.5F;
			this.LeftLeg.rotationPointY = 3.6F;
			this.LeftLeg.rotationPointZ = 0.9F;
			this.LeftLeg.rotateAngleZ = -0.15620696472454113F;
			this.LeftArm.rotationPointX = 1.9F;
			this.LeftArm.rotationPointY = 1.4F;
			this.LeftArm.rotationPointZ = -5.1F;
			this.LeftArm.rotateAngleX = -1.486671462175092F;
			this.LeftArm.rotateAngleY = 0.002617993982021224F;
			this.LeftArm.rotateAngleZ = -0.24015730906916136F;
			this.Neck.rotationPointZ = -7.1F;
			this.Neck.rotateAngleX = 0.23177972000431504F;
			this.Neck.rotateAngleY = -0.39357173300891585F;
			this.Neck.rotateAngleZ = 0.37262780195869205F;
			this.Tail.rotationPointY = -0.4F;
			this.Tail.rotateAngleX = -0.1563815016444822F;
			this.Tail.rotateAngleY = 0.3127630032889644F;
			this.Tail.rotateAngleZ = 0.11903145798206952F;
		} else {
			this.Neck.rotateAngleX = headPitch * ((float)Math.PI / 180F);
			this.Neck.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			this.RightThigh.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LeftThigh.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.LeftArm.rotateAngleZ = MathHelper.cos(0.05F * ageInTicks) * 0.05F;
			this.RightArm.rotateAngleZ = -MathHelper.cos(0.05F * ageInTicks) * 0.05F;
			this.Tail.rotateAngleY = -MathHelper.cos(0.05F * ageInTicks) * 0.05F;
			this.Tail.rotateAngleX = -MathHelper.cos(0.1F * ageInTicks) * 0.1F;
			if (entityIn.isEating()) {
				this.Body.rotateAngleX = 0.2F;
				this.Neck.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
			}
			if (entityIn.isInWater()) {
				this.LeftThigh.rotationPointY = 20;
				this.RightThigh.rotationPointY = 20;
				this.Body.rotationPointY = 20;
				this.Body.rotateAngleX = -0.5F;
				this.Tail.rotateAngleX = 0.25F;
				this.Neck.rotateAngleX = 0.5F;
				this.LeftLeg.rotateAngleX = -0.5F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LeftThigh.rotateAngleX = 0.5F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg_1.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RightArm.rotateAngleX = 0.5F;
				this.LeftArm.rotateAngleX = 0.5F;
				this.Tail.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.Body.rotationPointY = 16;
		this.Body.rotateAngleX = 0;
		this.Body.rotateAngleZ = 0;
		this.LeftLeg_1.rotationPointX = -0.6F;
		this.LeftLeg_1.rotationPointY = 5.0F;
		this.LeftLeg_1.rotationPointZ = 1.0F;
		this.LeftLeg_1.rotateAngleX = 0;
		this.LeftLeg_1.rotateAngleZ = 0;
		this.RightArm.rotationPointX = -1.5F;
		this.RightArm.rotationPointY = 1.0F;
		this.RightArm.rotationPointZ = -6.0F;
		this.RightArm.rotateAngleX = 0;
		this.RightArm.rotateAngleY = 0;
		this.RightArm.rotateAngleZ = 0;
		this.RightThigh.rotationPointY = 15.0F;
		this.RightThigh.rotationPointZ = 2.0F;
		this.RightThigh.rotateAngleX = 0;
		this.RightThigh.rotateAngleY = 0;
		this.LeftThigh.rotationPointY = 15.0F;
		this.LeftThigh.rotationPointZ = 2.0F;
		this.LeftThigh.rotateAngleX = 0;
		this.LeftThigh.rotateAngleY = 0;
		this.LeftLeg.rotationPointX = 0.6F;
		this.LeftLeg.rotationPointY = 5.0F;
		this.LeftLeg.rotationPointZ = 1.0F;
		this.LeftLeg.rotateAngleX = 0;
		this.LeftLeg.rotateAngleZ = 0;
		this.LeftArm.rotationPointX = 1.5F;
		this.LeftArm.rotationPointY = 1.0F;
		this.LeftArm.rotationPointZ = -6.0F;
		this.LeftArm.rotateAngleX = 0;
		this.LeftArm.rotateAngleY = 0;
		this.LeftArm.rotateAngleZ = 0;
		this.Neck.rotationPointZ = -8.0F;
		this.Neck.rotateAngleX = 0;
		this.Neck.rotateAngleY = 0;
		this.Neck.rotateAngleZ = 0;
		this.Tail.rotationPointY = -0.9F;
		this.Tail.rotateAngleX = 0;
		this.Tail.rotateAngleY = 0;
		this.Tail.rotateAngleZ = 0;
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
