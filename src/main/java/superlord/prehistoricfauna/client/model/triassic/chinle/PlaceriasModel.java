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
		this.neck.rotateAngleX = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 3)));
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
