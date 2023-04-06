package superlord.prehistoricfauna.client.model.triassic.chinle;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PlaceriasEntity;

/**
 * Placerias - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class PlaceriasModel extends EntityModel<PlaceriasEntity> {
	public ModelRenderer Body;
	public ModelRenderer Leg_front_left;
	public ModelRenderer Leg_front_right;
	public ModelRenderer Leg_back_right;
	public ModelRenderer Leg_back_right_1;
	public ModelRenderer neck;
	public ModelRenderer tail;
	public ModelRenderer head;
	public ModelRenderer beak;

	public PlaceriasModel() {
		this.textureWidth = 128;
		this.textureHeight = 160;
		this.neck = new ModelRenderer(this, 50, 0);
		this.neck.setRotationPoint(0.0F, -0.5F, -9.0F);
		this.neck.addBox(-2.5F, -3.5F, -5.5F, 5.0F, 11.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 17);
		this.Body.setRotationPoint(0.0F, 8.0F, -3.0F);
		this.Body.addBox(-4.4F, -5.0F, -9.0F, 9.0F, 13.0F, 22.0F, 0.0F, 0.0F, 0.0F);
		this.Leg_front_left = new ModelRenderer(this, 14, 55);
		this.Leg_front_left.mirror = true;
		this.Leg_front_left.setRotationPoint(-3.5F, 12.0F, -9.0F);
		this.Leg_front_left.addBox(-3.0F, 0.0F, 0.0F, 3.0F, 12.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.tail = new ModelRenderer(this, 64, 36);
		this.tail.setRotationPoint(0.0F, -3.0F, 13.0F);
		this.tail.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 11.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(tail, -0.4305727277985816F, 0.0F, 0.0F);
		this.Leg_back_right = new ModelRenderer(this, 34, 54);
		this.Leg_back_right.setRotationPoint(3.0F, 10.0F, 5.0F);
		this.Leg_back_right.addBox(0.0F, 0.0F, -2.0F, 3.0F, 14.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.Leg_back_right_1 = new ModelRenderer(this, 34, 54);
		this.Leg_back_right_1.setRotationPoint(-3.0F, 10.0F, 5.0F);
		this.Leg_back_right_1.addBox(-3.0F, 0.0F, -2.0F, 3.0F, 14.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.beak = new ModelRenderer(this, 0, 0);
		this.beak.setRotationPoint(0.0F, -1.5F, -3.5F);
		this.beak.addBox(-2.0F, 0.0F, -5.0F, 4.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.Leg_front_right = new ModelRenderer(this, 14, 55);
		this.Leg_front_right.setRotationPoint(3.5F, 12.0F, -9.0F);
		this.Leg_front_right.addBox(0.0F, 0.0F, 0.0F, 3.0F, 12.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 24, 0);
		this.head.setRotationPoint(0.0F, 0.0F, -3.0F);
		this.head.addBox(-3.0F, -4.0F, -5.0F, 6.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.Body.addChild(this.neck);
		this.Body.addChild(this.tail);
		this.head.addChild(this.beak);
		this.neck.addChild(this.head);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Body, this.Leg_front_left, this.Leg_back_right, this.Leg_back_right_1, this.Leg_front_right).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(PlaceriasEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress = entityIn.getMeleeProgress(partialTick) * 2.0F;
		resetModel();
		if (entityIn.isAsleep()) {
			this.Leg_back_right_1.rotationPointY = 20.0F;
			this.Leg_back_right_1.rotateAngleX = 1.2906709285865847F;
			this.Leg_back_right_1.rotateAngleY = -0.03909537541112055F;
			this.Leg_back_right_1.rotateAngleZ = 0.1563815016444822F;
			this.Body.rotationPointY = 16.1F;
			this.Body.rotationPointZ = 0.0F;
			this.Body.rotateAngleX = -0.03909537541112055F;
			this.Leg_front_left.rotationPointX = -3.8F;
			this.Leg_front_left.rotationPointY = 19.6F;
			this.Leg_front_left.rotationPointZ = -6;
			this.Leg_front_left.rotateAngleX = -1.1344640137963142F;
			this.Leg_front_left.rotateAngleY = -0.4300491170387584F;
			this.Leg_front_left.rotateAngleZ = -0.1563815016444822F;
			this.Leg_back_right.rotationPointX = 3F;
			this.Leg_back_right.rotationPointY = 21;
			this.Leg_back_right.rotationPointZ = 5;
			this.Leg_back_right.rotateAngleX = 1.3685127304046198F;
			this.Leg_back_right.rotateAngleY = 0.03909537541112055F;
			this.Leg_back_right.rotateAngleZ = -0.19547687289441354F;
			this.neck.rotateAngleX = 0.03909537541112055F;
			this.neck.rotateAngleY = 0.35185837453889574F;
			this.neck.rotateAngleZ = -0.4300491170387584F;
			this.tail.rotateAngleX = -0.3522074483787779F;
			this.tail.rotateAngleY = -0.0781907508222411F;
			this.tail.rotateAngleZ = 0.11728612207217244F;
			this.Leg_front_right.rotationPointX = 4.3F;
			this.Leg_front_right.rotationPointY = 18;
			this.Leg_front_right.rotationPointZ = -6;
			this.Leg_front_right.rotateAngleX = -1.1728612040769677F;
			this.Leg_front_right.rotateAngleY = 0.1563815016444822F;
			this.Leg_front_right.rotateAngleZ = 0.038920842652368684F;
		} else {
			this.neck.rotateAngleX = (-Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.1F) + attackProgress * (float) Math.toRadians(25F);
			this.neck.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			this.Leg_back_right.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
			this.Leg_back_right_1.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount);
			this.Leg_front_left.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
			this.Leg_front_right.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount);
			this.tail.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5));
			this.tail.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) - 0.25F;
			if (entityIn.isEating()) {
				this.neck.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
			}
			if (entityIn.isInWater()) {
				this.Body.rotationPointY = 10;
				this.Body.rotateAngleX = -0.125F;
				this.tail.rotateAngleX = 0.0625F;
				this.Leg_back_right_1.rotationPointY = 13;
				this.Leg_back_right.rotationPointY = 13;
				this.Leg_front_left.rotationPointY = 13;
				this.Leg_front_right.rotationPointY = 13;
				this.Leg_back_right_1.rotateAngleX = -0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Leg_back_right.rotateAngleX = 0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Leg_front_right.rotateAngleX = -0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Leg_front_left.rotateAngleX = 0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.neck.rotateAngleX = 0.25F;
				this.tail.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) - 0.25F;
			}
		}
	}

	public void resetModel() {
		this.Leg_back_right_1.rotationPointY = 10.0F;
		this.Leg_back_right_1.rotateAngleX = 0;
		this.Leg_back_right_1.rotateAngleY = 0;
		this.Leg_back_right_1.rotateAngleZ = 0;
		this.Body.rotationPointY = 8.0F;
		this.Body.rotationPointZ = -3.0F;
		this.Body.rotateAngleX = 0;
		this.Leg_front_left.rotationPointX = -3.5F;
		this.Leg_front_left.rotationPointY = 12;
		this.Leg_front_left.rotationPointZ = -9;
		this.Leg_front_left.rotateAngleX = 0;
		this.Leg_front_left.rotateAngleY = 0;
		this.Leg_front_left.rotateAngleZ = 0;
		this.Leg_back_right.rotationPointX = 3.5F;
		this.Leg_back_right.rotationPointY = 12;
		this.Leg_back_right.rotationPointZ = 5;
		this.Leg_back_right.rotateAngleX = 0;
		this.Leg_back_right.rotateAngleY = 0;
		this.Leg_back_right.rotateAngleZ = 0;
		this.neck.rotateAngleX = 0;
		this.neck.rotateAngleY = 0;
		this.neck.rotateAngleZ = 0;
		this.tail.rotateAngleX = -0.4305727277985816F;
		this.tail.rotateAngleY = 0;
		this.tail.rotateAngleZ = 0;
		this.Leg_front_right.rotationPointX = 3.5F;
		this.Leg_front_right.rotationPointY = 12;
		this.Leg_front_right.rotationPointZ = -9;
		this.Leg_front_right.rotateAngleX = 0;
		this.Leg_front_right.rotateAngleY = 0;
		this.Leg_front_right.rotateAngleZ = 0;
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
