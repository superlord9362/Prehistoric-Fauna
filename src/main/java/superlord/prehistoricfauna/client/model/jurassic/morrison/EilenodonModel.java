package superlord.prehistoricfauna.client.model.jurassic.morrison;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.EilenodonEntity;

/**
 * EilenodonModel - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class EilenodonModel extends EntityModel<EilenodonEntity> {
	public ModelRenderer Body;
	public ModelRenderer BackSpine;
	public ModelRenderer ArmL;
	public ModelRenderer ArmR;
	public ModelRenderer LegL;
	public ModelRenderer LegR;
	public ModelRenderer Tail;
	public ModelRenderer Neck;
	public ModelRenderer Head;
	public ModelRenderer HeadSpine;
	public ModelRenderer Dewlap;

	public EilenodonModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 22.0F, 2.0F);
		this.Body.addBox(-2.0F, -2.0F, -5.0F, 4.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.ArmR = new ModelRenderer(this, 28, 5);
		this.ArmR.setRotationPoint(-2.0F, -1.0F, -4.0F);
		this.ArmR.addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.HeadSpine = new ModelRenderer(this, 9, 17);
		this.HeadSpine.setRotationPoint(0.0F, -2.5F, -1.0F);
		this.HeadSpine.addBox(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.LegR = new ModelRenderer(this, 35, 5);
		this.LegR.setRotationPoint(-2.0F, -1.0F, 1.0F);
		this.LegR.addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 0, 12);
		this.Neck.setRotationPoint(0.0F, -1.0F, -5.0F);
		this.Neck.addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Tail = new ModelRenderer(this, 18, 11);
		this.Tail.setRotationPoint(0.0F, 0.0F, 2.0F);
		this.Tail.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.BackSpine = new ModelRenderer(this, 0, 17);
		this.BackSpine.setRotationPoint(0.0F, -2.5F, -4.0F);
		this.BackSpine.addBox(0.0F, -0.5F, -1.0F, 0.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.LegL = new ModelRenderer(this, 35, 0);
		this.LegL.setRotationPoint(2.0F, -1.0F, 1.0F);
		this.LegL.addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 0, 18);
		this.Head.setRotationPoint(0.0F, -1.0F, -2.0F);
		this.Head.addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.ArmL = new ModelRenderer(this, 28, 0);
		this.ArmL.setRotationPoint(2.0F, -1.0F, -4.0F);
		this.ArmL.addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Dewlap = new ModelRenderer(this, 9, 11);
		this.Dewlap.setRotationPoint(0.0F, 2.0F, 0.0F);
		this.Dewlap.addBox(0.0F, -1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Body.addChild(this.ArmR);
		this.Neck.addChild(this.HeadSpine);
		this.Body.addChild(this.LegR);
		this.Body.addChild(this.Neck);
		this.Body.addChild(this.Tail);
		this.Body.addChild(this.BackSpine);
		this.Body.addChild(this.LegL);
		this.Neck.addChild(this.Head);
		this.Body.addChild(this.ArmL);
		this.Head.addChild(this.Dewlap);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(EilenodonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entityIn.isSitting() && !entityIn.isAsleep()) {
			this.Body.rotationPointY = 23;
			this.LegL.rotationPointY = 1;
			this.LegL.rotateAngleZ = -1.5707963267948966F;
			this.ArmL.rotationPointY = 1;
			this.ArmL.rotateAngleZ = -1.5707963267948966F;
			this.LegR.rotationPointY = 1;
			this.LegR.rotateAngleZ = 1.5707963267948966F;
			this.ArmR.rotationPointY = 1;
			this.ArmR.rotateAngleZ = 1.5707963267948966F;
			this.Tail.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tail.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.Neck.rotateAngleX = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
		} else if (entityIn.isAsleep()) {
			this.Body.rotationPointY = 23;
			this.LegL.rotationPointY = 1;
			this.LegL.rotateAngleZ = -1.5707963267948966F;
			this.ArmL.rotationPointY = 1;
			this.ArmL.rotateAngleZ = -1.5707963267948966F;
			this.LegR.rotationPointY = 1;
			this.LegR.rotateAngleZ = 1.5707963267948966F;
			this.ArmR.rotationPointY = 1;
			this.ArmR.rotateAngleZ = 1.5707963267948966F;
			this.Neck.rotationPointZ = -4.8F;
			this.Neck.rotateAngleX = 0.19547687289441354F;
			this.Neck.rotateAngleY = 0.27366763203903305F;
			this.Neck.rotateAngleZ = -1.2901473511162753F;
		} else {
			this.Neck.rotateAngleX = headPitch * ((float)Math.PI / 180F);
			this.Neck.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			this.LegR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LegL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.ArmR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.ArmL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.Tail.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tail.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.Neck.rotateAngleX = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			if (entityIn.isEating()) {
				this.Neck.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.45F) + 0.5F;
			}
			if (entityIn.isInWater()) {
				this.ArmL.rotateAngleX = 0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.ArmR.rotateAngleX = 0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.LegR.rotateAngleX = -0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.LegL.rotateAngleX = -0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.Tail.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.Body.rotationPointY = 22;
		this.LegL.rotationPointY = -1.0F;
		this.LegL.rotateAngleZ = 0;
		this.LegL.rotateAngleX = 0;
		this.LegL.rotateAngleY = 0;
		this.ArmL.rotationPointY = -1.0F;
		this.ArmL.rotateAngleZ = 0;
		this.ArmL.rotateAngleX = 0;
		this.ArmL.rotateAngleY = 0;
		this.LegR.rotationPointY = -1.0F;
		this.LegR.rotateAngleZ = 0;
		this.LegR.rotateAngleX = 0;
		this.LegR.rotateAngleY = 0;
		this.ArmR.rotationPointY = -1.0F;
		this.ArmR.rotateAngleZ = 0;
		this.ArmR.rotateAngleX = 0;
		this.ArmR.rotateAngleY = 0;
		this.Neck.rotateAngleX = 0;
		this.Tail.rotateAngleX = 0;
		this.Tail.rotateAngleY = 0;
		this.Neck.rotateAngleX = 0;
		this.Neck.rotateAngleY = 0;
		this.Neck.rotateAngleZ = 0;
		this.Neck.rotationPointZ = -5.0F;
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
