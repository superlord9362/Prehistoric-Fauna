package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.CalsoyasuchusEntity;

/**
 * Calsoyasuchus - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class CalsoyasuchusModel extends EntityModel<CalsoyasuchusEntity> {
	public ModelRenderer belly;
	public ModelRenderer FrontL;
	public ModelRenderer BackL;
	public ModelRenderer FrontR;
	public ModelRenderer BackR;
	public ModelRenderer tail;
	public ModelRenderer head;
	public ModelRenderer bodyspikes;
	public ModelRenderer tailspikes;
	public ModelRenderer eyes;
	public ModelRenderer hand;
	public ModelRenderer feet;
	public ModelRenderer hand_1;
	public ModelRenderer feet_1;

	public CalsoyasuchusModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.hand_1 = new ModelRenderer(this, 19, 51);
		this.hand_1.mirror = true;
		this.hand_1.setRotationPoint(-0.5F, 3.0F, -1.0F);
		this.hand_1.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.FrontL = new ModelRenderer(this, 0, 0);
		this.FrontL.setRotationPoint(1.0F, 21.0F, -3.0F);
		this.FrontL.addBox(0.0F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.feet_1 = new ModelRenderer(this, 13, 52);
		this.feet_1.setRotationPoint(-1.0F, 3.0F, -1.0F);
		this.feet_1.addBox(-2.0F, 0.0F, -2.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.BackL = new ModelRenderer(this, 18, 0);
		this.BackL.setRotationPoint(1.0F, 21.0F, 4.0F);
		this.BackL.addBox(0.0F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.tail = new ModelRenderer(this, 15, 1);
		this.tail.setRotationPoint(0.0F, 0.1F, 7.0F);
		this.tail.addBox(-1.0F, -0.9F, -1.0F, 2.0F, 2.0F, 14.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(tail, -0.17453292519943295F, 0.0F, 0.0F);
		this.FrontR = new ModelRenderer(this, 0, 0);
		this.FrontR.mirror = true;
		this.FrontR.setRotationPoint(-1.0F, 21.0F, -3.0F);
		this.FrontR.addBox(-1.0F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.belly = new ModelRenderer(this, 0, 0);
		this.belly.setRotationPoint(0.0F, 20.0F, -1.0F);
		this.belly.addBox(-1.5F, -1.0F, -4.0F, 3.0F, 3.0F, 11.0F, 0.0F, 0.0F, 0.0F);
		this.hand = new ModelRenderer(this, 19, 51);
		this.hand.setRotationPoint(0.5F, 3.0F, -1.0F);
		this.hand.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.eyes = new ModelRenderer(this, 47, 1);
		this.eyes.setRotationPoint(0.0F, 0.0F, -4.0F);
		this.eyes.addBox(-1.5F, -1.5F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.tailspikes = new ModelRenderer(this, 14, 18);
		this.tailspikes.setRotationPoint(0.0F, -1.5F, 0.0F);
		this.tailspikes.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.BackR = new ModelRenderer(this, 18, 0);
		this.BackR.mirror = true;
		this.BackR.setRotationPoint(-1.0F, 21.0F, 4.0F);
		this.BackR.addBox(-1.0F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.bodyspikes = new ModelRenderer(this, 0, 18);
		this.bodyspikes.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.bodyspikes.addBox(-1.0F, -0.5F, -4.0F, 2.0F, 1.0F, 11.0F, 0.0F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 34, 0);
		this.head.setRotationPoint(0.0F, 0.1F, -3.5F);
		this.head.addBox(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.feet = new ModelRenderer(this, 13, 52);
		this.feet.mirror = true;
		this.feet.setRotationPoint(1.0F, 3.0F, -1.0F);
		this.feet.addBox(-1.0F, 0.0F, -2.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.FrontR.addChild(this.hand_1);
		this.BackR.addChild(this.feet_1);
		this.belly.addChild(this.tail);
		this.FrontL.addChild(this.hand);
		this.head.addChild(this.eyes);
		this.tail.addChild(this.tailspikes);
		this.belly.addChild(this.bodyspikes);
		this.belly.addChild(this.head);
		this.BackL.addChild(this.feet);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.FrontL, this.BackL, this.FrontR, this.belly, this.BackR).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(CalsoyasuchusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entityIn.isAsleep()) {
			this.belly.rotationPointY = 22.0F;
			this.belly.rotationPointZ = -1.0F;
			this.FrontL.rotationPointX = 1.0F;
			this.FrontL.rotationPointY = 23.3F;
			this.FrontL.rotationPointZ = -3.0F;
			this.BackL.rotationPointX = 1.0F;
			this.BackL.rotationPointY = 23.0F;
			this.BackL.rotationPointZ = 4.0F;
			this.FrontR.rotationPointX = 1.0F;
			this.FrontR.rotationPointY = 23.3F;
			this.FrontR.rotationPointZ = -3.0F;
			this.BackR.rotationPointX = -1.0F;
			this.BackR.rotationPointY = 23.0F;
			this.BackR.rotationPointZ = 4.0F;
			this.tail.rotateAngleX = -0.0572467989660713F;
			this.tail.rotateAngleY = 0.3909537457888271F;
			this.FrontR.rotateAngleZ = 1.0946705281561322F;
			this.head.rotateAngleX = 0.11728612207217244F;
			this.head.rotateAngleY = -0.3909537457888271F;
			this.hand.rotateAngleZ = 1.1728612040769677F;
			this.hand_1.rotateAngleZ = -1.0946705281561322F;
			this.feet.rotateAngleZ = 0.9382889765773795F;
			this.feet_1.rotateAngleZ = -0.9382889765773795F;
			this.BackR.rotateAngleZ = 0.9382889765773795F;
			this.BackL.rotateAngleZ = -0.9382889765773795F;
			this.FrontL.rotateAngleZ = -1.1728612040769677F;
		} else {
			this.tail.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.BackL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.FrontR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.BackR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.FrontL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.tail.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.head.rotateAngleX = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)));
			this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			if (entityIn.isInWater()) {
				this.hand_1.rotateAngleX = 1.5707963267948966F;
				this.FrontR.rotateAngleX = 0.8726646259971648F;
				this.hand.rotateAngleX = 1.5707963267948966F;
				this.FrontL.rotateAngleX = 0.8726646259971648F;
				this.BackR.rotateAngleX = 1.0471975511965976F;
				this.BackL.rotateAngleX = 1.0471975511965976F;
				this.feet.rotateAngleZ = 1.5707963267948966F;
				this.feet_1.rotateAngleZ = -1.5707963267948966F;
				this.tail.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
				this.tail.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5) + (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
				this.belly.rotateAngleX = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)));
				this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			}
		}
	}

	public void resetModel() {
		this.tail.rotateAngleX = -0.17453292519943295F;
		this.tail.rotateAngleY = 0;
		this.FrontR.rotateAngleX = 0;
		this.FrontR.rotateAngleZ = 0;
		this.FrontL.rotateAngleX = 0;
		this.head.rotateAngleX = 0;
		this.head.rotateAngleY = 0;
		this.hand.rotateAngleZ = 0;
		this.hand_1.rotateAngleX = 0;
		this.hand_1.rotateAngleZ = 0;
		this.feet.rotateAngleZ = 0;
		this.feet_1.rotateAngleZ = 0;
		this.BackR.rotateAngleZ = 0;
		this.BackL.rotateAngleZ = 0;
		this.FrontL.rotateAngleZ = 0;
		this.hand.rotateAngleX = 0;
		this.BackR.rotateAngleX = 0;
		this.BackL.rotateAngleX = 0;
		this.feet.rotateAngleZ = 0;
		this.feet_1.rotateAngleZ = 0;
		this.FrontL.rotationPointX = 1.0F;
		this.FrontL.rotationPointY = 21.0F;
		this.FrontL.rotationPointZ = -3.0F;
		this.BackL.rotationPointX = 1.0F;
		this.BackL.rotationPointY = 21.0F;
		this.BackL.rotationPointZ = 4.0F;
		this.FrontR.rotationPointX = -1.0F;
		this.FrontR.rotationPointY = 21.0F;
		this.FrontR.rotationPointZ = -3.0F;
		this.belly.rotationPointX = 0.0F;
		this.belly.rotationPointY = 20.0F;
		this.belly.rotationPointZ = -1.0F;
		this.BackR.rotationPointX = -1.0F;
		this.BackR.rotationPointY = 21.0F;
		this.BackR.rotationPointZ = 4.0F;
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
