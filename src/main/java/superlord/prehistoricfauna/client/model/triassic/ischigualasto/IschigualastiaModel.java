package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.IschigualastiaEntity;

/**
 * Diictodont - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class IschigualastiaModel extends EntityModel<IschigualastiaEntity> {
	public ModelRenderer Body;
	public ModelRenderer Tail;
	public ModelRenderer Neck;
	public ModelRenderer ArmL;
	public ModelRenderer ArmR;
	public ModelRenderer LegL;
	public ModelRenderer LegR;
	public ModelRenderer Face;

	public IschigualastiaModel() {
		this.textureWidth = 200;
		this.textureHeight = 200;
		this.Neck = new ModelRenderer(this, 0, 64);
		this.Neck.setRotationPoint(0.0F, -6.0F, -23.0F);
		this.Neck.addBox(-6.0F, -6.0F, -13.0F, 12.0F, 14.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.LegL = new ModelRenderer(this, 62, 63);
		this.LegL.setRotationPoint(7.0F, -2.0F, 3.0F);
		this.LegL.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 17.0F, 10.0F, 0.0F, 0.0F, 0.0F);
		this.LegR = new ModelRenderer(this, 62, 63);
		this.LegR.setRotationPoint(-7.0F, -2.0F, 3.0F);
		this.LegR.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 17.0F, 10.0F, 0.0F, 0.0F, 0.0F);
		this.ArmR = new ModelRenderer(this, 62, 99);
		this.ArmR.setRotationPoint(-7.0F, -2.0F, -18.0F);
		this.ArmR.addBox(-4.0F, 0.0F, -4.0F, 6.0F, 17.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Tail = new ModelRenderer(this, 100, 0);
		this.Tail.setRotationPoint(0.0F, -9.0F, 9.0F);
		this.Tail.addBox(-4.5F, -3.0F, 0.0F, 9.0F, 7.0F, 14.0F, 0.0F, 0.0F, 0.0F);
		this.ArmL = new ModelRenderer(this, 62, 99);
		this.ArmL.setRotationPoint(7.0F, -2.0F, -18.0F);
		this.ArmL.addBox(-2.0F, 0.0F, -4.0F, 6.0F, 17.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Face = new ModelRenderer(this, 0, 99);
		this.Face.setRotationPoint(0.0F, 2.0F, -13.0F);
		this.Face.addBox(-4.5F, -6.0F, -8.0F, 9.0F, 12.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 9.0F, 8.0F);
		this.Body.addBox(-10.0F, -16.0F, -24.0F, 20.0F, 22.0F, 34.0F, 0.0F, 0.0F, 0.0F);
		this.Body.addChild(this.Neck);
		this.Body.addChild(this.LegL);
		this.Body.addChild(this.LegR);
		this.Body.addChild(this.ArmR);
		this.Body.addChild(this.Tail);
		this.Body.addChild(this.ArmL);
		this.Neck.addChild(this.Face);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(IschigualastiaEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress = entityIn.getMeleeProgress(partialTick) * 2.0F;
		resetModel();
		if (entityIn.isAsleep()) {
			this.Body.rotationPointY = 14;
			this.Body.rotateAngleZ = -1.5707963267948966F;
			this.LegL.rotationPointX = 10.4F;
			this.LegL.rotateAngleZ = 0.5235987755982988F;
			this.ArmR.rotateAngleX = 0.5235987755982988F;
			this.LegR.rotateAngleX = 0.41887902047863906F;
			this.Neck.rotateAngleX = 0.593411945678072F;
			this.Neck.rotateAngleY = -0.13962634015954636F;
			this.Neck.rotateAngleZ = 0.8377580409572781F;
			this.Tail.rotateAngleX = -0.24434609527920614F;
			this.Tail.rotateAngleY = -0.10471975511965977F;
			this.Tail.rotateAngleZ = 0.593411945678072F;
			this.ArmL.rotationPointX = 11.0F;
			this.ArmL.rotateAngleX = 0.45378560551852565F;
			this.ArmL.rotateAngleY = 0.24434609527920614F;
			this.ArmL.rotateAngleZ = 0.5235987755982988F;
		} else {
			this.Neck.rotateAngleX = (-Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.1F) + attackProgress * (float) Math.toRadians(25F);
			this.Neck.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			this.LegR.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
			this.LegL.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount);
			this.ArmL.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
			this.ArmR.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount);
			this.Tail.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5));
			this.Tail.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) - 0.25F;
			if (entityIn.isEating()) {
				this.Neck.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
			}
			if (entityIn.isInWater()) {
				this.Body.rotationPointY = 20;
				this.Body.rotateAngleX = -0.125F;
				this.Tail.rotateAngleX = 0.0625F;
				this.LegL.rotateAngleX = -0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LegR.rotateAngleX = 0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.ArmR.rotateAngleX = -0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.ArmL.rotateAngleX = 0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Neck.rotateAngleX = 0.0625F;
				this.Tail.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) - 0.25F;
			}
		}
	}

	public void resetModel() {
		this.Body.rotationPointY = 9;
		this.Body.rotateAngleX = 0;
		this.Body.rotateAngleZ = 0;
		this.LegL.rotationPointX = 7.0F;
		this.LegL.rotateAngleX = 0;
		this.LegL.rotateAngleZ = 0;
		this.ArmR.rotateAngleX = 0;
		this.LegR.rotateAngleX = 0;
		this.Neck.rotateAngleX = 0;
		this.Neck.rotateAngleY = 0;
		this.Neck.rotateAngleZ = 0;
		this.Tail.rotateAngleX = 0;
		this.Tail.rotateAngleY = 0;
		this.Tail.rotateAngleZ = 0;
		this.ArmL.rotationPointX = 7.0F;
		this.ArmL.rotateAngleX = 0;
		this.ArmL.rotateAngleY = 0;
		this.ArmL.rotateAngleZ = 0;
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
