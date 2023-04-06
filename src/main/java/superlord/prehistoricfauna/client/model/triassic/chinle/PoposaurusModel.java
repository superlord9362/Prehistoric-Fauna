package superlord.prehistoricfauna.client.model.triassic.chinle;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PoposaurusEntity;

/**
 * Poposaurus - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class PoposaurusModel extends EntityModel<PoposaurusEntity> {
	public ModelRenderer Body;
	public ModelRenderer Thigh_L;
	public ModelRenderer Thigh_R;
	public ModelRenderer Tail_1;
	public ModelRenderer Neck;
	public ModelRenderer Arm_L;
	public ModelRenderer Arm_R;
	public ModelRenderer Tail_2;
	public ModelRenderer Tail_3;
	public ModelRenderer Head;
	public ModelRenderer Jaw_base;
	public ModelRenderer Snoot;
	public ModelRenderer Jaw_tip;
	public ModelRenderer Throat;
	public ModelRenderer Teeth_bot;
	public ModelRenderer Teeth_top;
	public ModelRenderer Leg_L;
	public ModelRenderer Foot_L;
	public ModelRenderer Leg_R;
	public ModelRenderer Foot_R;

	public PoposaurusModel() {
		this.textureWidth = 120;
		this.textureHeight = 160;
		this.Foot_R = new ModelRenderer(this, 39, 57);
		this.Foot_R.mirror = true;
		this.Foot_R.setRotationPoint(0.0F, 10.0F, 2.0F);
		this.Foot_R.addBox(-2.0F, 0.0F, -6.0F, 4.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Leg_R = new ModelRenderer(this, 85, 40);
		this.Leg_R.mirror = true;
		this.Leg_R.setRotationPoint(-2.0F, 9.0F, 3.0F);
		this.Leg_R.addBox(-1.5F, -1.0F, 0.0F, 3.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Teeth_top = new ModelRenderer(this, 98, 0);
		this.Teeth_top.setRotationPoint(0.0F, 2.0F, 0.0F);
		this.Teeth_top.addBox(-1.0F, 0.0F, -6.7F, 2.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Teeth_top, -0.001745329278001762F, 0.0F, 0.0F);
		this.Teeth_bot = new ModelRenderer(this, 98, 12);
		this.Teeth_bot.setRotationPoint(0.0F, 0.0F, 0.2F);
		this.Teeth_bot.addBox(-1.0F, -1.0F, -6.7F, 2.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Tail_3 = new ModelRenderer(this, 0, 89);
		this.Tail_3.setRotationPoint(0.0F, -0.5F, 16.0F);
		this.Tail_3.addBox(-0.5F, -2.0F, 0.0F, 1.0F, 4.0F, 22.0F, 0.0F, 0.0F, 0.0F);
		this.Jaw_base = new ModelRenderer(this, 50, 12);
		this.Jaw_base.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.Jaw_base.addBox(-2.5F, 0.0F, -5.0F, 5.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.Arm_L = new ModelRenderer(this, 45, 40);
		this.Arm_L.setRotationPoint(3.5F, 5.0F, -16.0F);
		this.Arm_L.addBox(0.0F, 0.0F, 0.0F, 2.0F, 10.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.Leg_L = new ModelRenderer(this, 85, 40);
		this.Leg_L.setRotationPoint(2.0F, 9.0F, 3.0F);
		this.Leg_L.addBox(-1.5F, -1.0F, 0.0F, 3.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Foot_L = new ModelRenderer(this, 39, 57);
		this.Foot_L.setRotationPoint(0.0F, 10.0F, 2.0F);
		this.Foot_L.addBox(-2.0F, 0.0F, -6.0F, 4.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Thigh_L = new ModelRenderer(this, 60, 40);
		this.Thigh_L.setRotationPoint(2.0F, 3.0F, -1.0F);
		this.Thigh_L.addBox(0.0F, 0.0F, 0.0F, 4.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.Throat = new ModelRenderer(this, 1, 19);
		this.Throat.setRotationPoint(0.0F, -0.9F, -0.01F);
		this.Throat.addBox(-2.01F, -2.0F, -4.0F, 4.02F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Arm_R = new ModelRenderer(this, 45, 40);
		this.Arm_R.mirror = true;
		this.Arm_R.setRotationPoint(-3.5F, 5.0F, -16.0F);
		this.Arm_R.addBox(-2.0F, 0.0F, 0.0F, 2.0F, 10.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.Thigh_R = new ModelRenderer(this, 60, 40);
		this.Thigh_R.mirror = true;
		this.Thigh_R.setRotationPoint(-2.0F, 3.0F, -1.0F);
		this.Thigh_R.addBox(-4.0F, 0.0F, 0.0F, 4.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 50, 0);
		this.Head.setRotationPoint(0.0F, -2.5F, -9.0F);
		this.Head.addBox(-2.5F, 0.0F, -5.0F, 5.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 3.0F, 1.0F);
		this.Body.addBox(-4.5F, -3.0F, -20.0F, 9.0F, 11.0F, 28.0F, 0.0F, 0.0F, 0.0F);
		this.Tail_2 = new ModelRenderer(this, 0, 63);
		this.Tail_2.setRotationPoint(0.0F, -1.5F, 13.0F);
		this.Tail_2.addBox(-1.5F, -3.0F, -1.0F, 3.0F, 6.0F, 19.0F, 0.0F, 0.0F, 0.0F);
		this.Snoot = new ModelRenderer(this, 75, 0);
		this.Snoot.setRotationPoint(0.0F, 0.0F, -5.0F);
		this.Snoot.addBox(-1.5F, 0.0F, -7.0F, 3.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Tail_1 = new ModelRenderer(this, 0, 40);
		this.Tail_1.setRotationPoint(0.0F, 1.0F, 7.0F);
		this.Tail_1.addBox(-3.0F, -5.0F, 0.0F, 6.0F, 8.0F, 14.0F, 0.0F, 0.0F, 0.0F);
		this.Jaw_tip = new ModelRenderer(this, 75, 12);
		this.Jaw_tip.setRotationPoint(0.0F, 0.0F, -5.0F);
		this.Jaw_tip.addBox(-1.5F, 0.0F, -7.0F, 3.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Jaw_tip, 0.001745329278001762F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 0, 0);
		this.Neck.setRotationPoint(0.0F, -1.0F, -18.0F);
		this.Neck.addBox(-2.0F, -3.0F, -9.0F, 4.0F, 7.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.Leg_R.addChild(this.Foot_R);
		this.Thigh_R.addChild(this.Leg_R);
		this.Snoot.addChild(this.Teeth_top);
		this.Jaw_tip.addChild(this.Teeth_bot);
		this.Tail_2.addChild(this.Tail_3);
		this.Head.addChild(this.Jaw_base);
		this.Body.addChild(this.Arm_L);
		this.Thigh_L.addChild(this.Leg_L);
		this.Leg_L.addChild(this.Foot_L);
		this.Jaw_base.addChild(this.Throat);
		this.Body.addChild(this.Arm_R);
		this.Neck.addChild(this.Head);
		this.Tail_1.addChild(this.Tail_2);
		this.Head.addChild(this.Snoot);
		this.Body.addChild(this.Tail_1);
		this.Jaw_base.addChild(this.Jaw_tip);
		this.Body.addChild(this.Neck);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Thigh_L, this.Thigh_R, this.Body).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(PoposaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress = entityIn.getMeleeProgress(partialTick);
		float leftOrRight = entityIn.getMeleeDirection() ? 1.0F : -1.0F;
		resetModel();
		if (entityIn.isAsleep()) {
			this.Thigh_L.rotationPointX = 3;
			this.Thigh_L.rotationPointY = 12;
			this.Thigh_L.rotationPointZ = 4;
			this.Thigh_L.rotateAngleX = -0.8726646259971648F;
			this.Thigh_L.rotateAngleY = -0.3490658503988659F;
			this.Foot_R.rotationPointY = 9.0F;
			this.Foot_R.rotateAngleX = 1.5707963267948966F;
			this.Foot_R.rotateAngleZ = -0.0781907508222411F;
			this.Arm_L.rotationPointY = 9.0F;
			this.Arm_L.rotationPointZ = -14.0F;
			this.Arm_L.rotateAngleX = -1.13376586611655F;
			this.Arm_L.rotateAngleZ = -1.524545074985436F;
			this.Leg_R.rotationPointY = 7.0F;
			this.Leg_R.rotationPointZ = 5.0F;
			this.Leg_R.rotateAngleX = -0.6981317007977318F;
			this.Foot_L.rotationPointY = 9.0F;
			this.Foot_L.rotateAngleX = 1.5707963267948966F;
			this.Tail_3.rotateAngleX = -0.03490658503988659F;
			this.Tail_3.rotateAngleY = 0.35185837453889574F;
			this.Tail_3.rotateAngleZ = -0.0781907508222411F;
			this.Neck.rotationPointX = -1.0F;
			this.Neck.rotationPointY = 1.0F;
			this.Neck.rotateAngleX = 0.5864306020384839F;
			this.Neck.rotateAngleY = -0.6646214111173737F;
			this.Arm_R.rotationPointY = 7.0F;
			this.Arm_R.rotationPointZ = -15.0F;
			this.Arm_R.rotateAngleX = -1.0555751236166873F;
			this.Arm_R.rotateAngleY = -0.11728612207217244F;
			this.Arm_R.rotateAngleZ = 1.2901473511162753F;
			this.Body.rotationPointY = 16.0F;
			this.Body.rotateAngleX = -0.03909537541112055F;
			this.Body.rotateAngleY = 0.03909537541112055F;
			this.Jaw_base.rotateAngleX = 0.3127630032889644F;
			this.Head.rotationPointY = -1.6F;
			this.Head.rotationPointZ = -8.0F;
			this.Head.rotateAngleX = -0.8600982340775168F;
			this.Head.rotateAngleY = -0.3909537457888271F;
			this.Head.rotateAngleZ = 0.19547687289441354F;
			this.Leg_L.rotationPointY = 7.0F;
			this.Leg_L.rotationPointZ = 5.0F;
			this.Leg_L.rotateAngleX = -0.6981317007977318F;
			this.Tail_1.rotationPointX = -1.0F;
			this.Tail_1.rotationPointZ = 5.0F;
			this.Tail_1.rotateAngleX = -0.15707963267948966F;
			this.Tail_1.rotateAngleY = 0.5082398928281348F;
			this.Tail_1.rotateAngleZ = 0.0781907508222411F;
			this.Tail_2.rotateAngleX = -0.03490658503988659F;
			this.Tail_2.rotateAngleY = 0.5082398928281348F;
			this.Tail_2.rotateAngleZ = -0.19547687289441354F;
			this.Thigh_R.rotationPointX = -2.7F;
			this.Thigh_R.rotationPointY = 12.0F;
			this.Thigh_R.rotationPointZ = 4.2F;
			this.Thigh_R.rotateAngleX = -0.8726646259971648F;
			this.Thigh_R.rotateAngleY = 0.3490658503988659F;
		} else {
			this.Jaw_base.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * partialTick / 3)) + attackProgress * (float) Math.toRadians(25F);
			this.Arm_L.rotateAngleZ = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
			this.Arm_R.rotateAngleZ = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
			this.Body.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.1F) * degree * 0.15F * limbSwingAmount;
			this.Neck.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.1F) * degree * -0.15F * limbSwingAmount;
			this.Tail_1.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.2F * limbSwingAmount);
			this.Tail_2.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (Tail_2.rotateAngleY = MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.25F * limbSwingAmount);
			this.Tail_3.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (Tail_3.rotateAngleY = MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.25F * limbSwingAmount);
			this.Tail_1.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.Tail_2.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.1F);
			this.Tail_3.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.1F);
			this.Thigh_L.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount - 0.05F;
			this.Leg_L.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.05F;
			this.Foot_L.rotateAngleX = MathHelper.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
			this.Thigh_R.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount - 0.05F;
			this.Leg_R.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + 0.05F;
			this.Foot_R.rotateAngleX = MathHelper.cos(2.0F + limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
			this.Neck.rotateAngleZ = attackProgress * leftOrRight * (float) Math.toRadians(15F);
			this.Head.rotateAngleZ = attackProgress * leftOrRight * (float) Math.toRadians(5F);
			if (entityIn.isInWater()) {
				this.Thigh_L.rotationPointY = 21;
				this.Thigh_R.rotationPointY = 21;
				this.Body.rotationPointY = 20;
				this.Body.rotateAngleX = -0.25F;
				this.Tail_1.rotateAngleX = 0.125F;
				this.Tail_2.rotateAngleX = 0.125F;
				this.Neck.rotateAngleX = 0.25F;
				this.Thigh_L.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Thigh_R.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Leg_L.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Leg_R.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Foot_L.rotateAngleX = 0.5F - (0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F));
				this.Foot_R.rotateAngleX = 0.5F + (0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F));
				this.Arm_R.rotateAngleX = 0.25F;
				this.Arm_L.rotateAngleX = 0.25F;
				this.Tail_1.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
				this.Tail_2.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
				this.Tail_3.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.Thigh_L.rotationPointX = 2;
		this.Thigh_L.rotationPointY = 3;
		this.Thigh_L.rotationPointZ = -1;
		this.Thigh_L.rotateAngleX = 0;
		this.Thigh_L.rotateAngleY = 0;
		this.Foot_R.rotationPointY = 10.0F;
		this.Foot_R.rotateAngleX = 0;
		this.Foot_R.rotateAngleZ = 0;
		this.Arm_L.rotationPointY = 5.0F;
		this.Arm_L.rotationPointZ = -16.0F;
		this.Arm_L.rotateAngleX = 0;
		this.Arm_L.rotateAngleZ = 0;
		this.Leg_R.rotationPointY = 9.0F;
		this.Leg_R.rotationPointZ = 3.0F;
		this.Leg_R.rotateAngleX = 0;
		this.Foot_L.rotationPointY = 10.0F;
		this.Foot_L.rotateAngleX = 0;
		this.Tail_3.rotateAngleX = 0;
		this.Tail_3.rotateAngleY = 0;
		this.Tail_3.rotateAngleZ = 0;
		this.Neck.rotationPointX = 0.0F;
		this.Neck.rotationPointY = -1.0F;
		this.Neck.rotateAngleX = 0;
		this.Neck.rotateAngleY = 0;
		this.Arm_R.rotationPointY = 5.0F;
		this.Arm_R.rotationPointZ = -16.0F;
		this.Arm_R.rotateAngleX = 0;
		this.Arm_R.rotateAngleY = 0;
		this.Arm_R.rotateAngleZ = 0;
		this.Body.rotationPointY = 3.0F;
		this.Body.rotateAngleX = 0;
		this.Body.rotateAngleY = 0;
		this.Jaw_base.rotateAngleX = 0;
		this.Head.rotationPointY = -2.5F;
		this.Head.rotationPointZ = -9.0F;
		this.Head.rotateAngleX = 0;
		this.Head.rotateAngleY = 0;
		this.Head.rotateAngleZ = 0;
		this.Leg_L.rotationPointY = 9.0F;
		this.Leg_L.rotationPointZ = 3.0F;
		this.Leg_L.rotateAngleX = 0;
		this.Tail_1.rotationPointX = 0.0F;
		this.Tail_1.rotationPointZ = 7.0F;
		this.Tail_1.rotateAngleX = 0;
		this.Tail_1.rotateAngleY = 0;
		this.Tail_1.rotateAngleZ = 0;
		this.Tail_2.rotateAngleX = 0;
		this.Tail_2.rotateAngleY = 0;
		this.Tail_2.rotateAngleZ = 0;
		this.Thigh_R.rotationPointX = -2.0F;
		this.Thigh_R.rotationPointY = 3.0F;
		this.Thigh_R.rotationPointZ = -1.0F;
		this.Thigh_R.rotateAngleX = 0.0F;
		this.Thigh_R.rotateAngleY = 0.0F;
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
