package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DakotaraptorEntity;

/**
 * Dakotaraptor - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class DakotaraptorModel extends EntityModel<DakotaraptorEntity> {
	public ModelRenderer Body;
	public ModelRenderer LeftLeg1;
	public ModelRenderer RightLeg1;
	public ModelRenderer Neck;
	public ModelRenderer LeftWing;
	public ModelRenderer RightWing;
	public ModelRenderer Tail1;
	public ModelRenderer Head1;
	public ModelRenderer Snout;
	public ModelRenderer Tail2;
	public ModelRenderer Feathers;
	public ModelRenderer LeftLeg2;
	public ModelRenderer RightLeg2;

	public DakotaraptorModel() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.Snout = new ModelRenderer(this, 0, 102);
		this.Snout.setRotationPoint(0.0F, -2.0F, -9.0F);
		this.Snout.addBox(-2.0F, 0.0F, -10.0F, 4.0F, 7.0F, 10.0F, 0.0F, 0.0F, 0.0F);
		this.Feathers = new ModelRenderer(this, 55, 30);
		this.Feathers.setRotationPoint(0.0F, 0.0F, 1.0F);
		this.Feathers.addBox(-5.0F, 0.0F, 0.0F, 10.0F, 7.0F, 26.0F, 0.0F, 0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 73, 0);
		this.Tail2.setRotationPoint(0.0F, 0.0F, 23.0F);
		this.Tail2.addBox(-2.0F, -1.0F, -1.0F, 4.0F, 5.0F, 23.0F, 0.0F, 0.0F, 0.0F);
		this.LeftLeg2 = new ModelRenderer(this, 70, 71);
		this.LeftLeg2.setRotationPoint(-1.0F, 9.0F, 5.0F);
		this.LeftLeg2.addBox(-2.0F, 0.0F, -6.0F, 5.0F, 11.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 0, 84);
		this.Neck.setRotationPoint(0.0F, -6.0F, -14.0F);
		this.Neck.addBox(-3.0F, -2.0F, -6.0F, 6.0F, 10.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Neck, 0.13962634015954636F, 0.0F, 0.0F);
		this.RightWing = new ModelRenderer(this, 0, 0);
		this.RightWing.mirror = true;
		this.RightWing.setRotationPoint(-5.0F, 1.0F, -14.0F);
		this.RightWing.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.RightLeg1 = new ModelRenderer(this, 94, 71);
		this.RightLeg1.setRotationPoint(-5.0F, 3.9F, 1.0F);
		this.RightLeg1.addBox(-2.0F, -3.0F, -4.0F, 5.0F, 12.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.Head1 = new ModelRenderer(this, 30, 77);
		this.Head1.setRotationPoint(0.0F, -8.0F, 1.0F);
		this.Head1.addBox(-3.0F, -3.0F, -9.0F, 6.0F, 9.0F, 11.0F, 0.0F, 0.0F, 0.0F);
		this.RightLeg2 = new ModelRenderer(this, 70, 71);
		this.RightLeg2.mirror = true;
		this.RightLeg2.setRotationPoint(1.0F, 9.0F, 5.0F);
		this.RightLeg2.addBox(-3.0F, 0.0F, -6.0F, 5.0F, 11.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.LeftWing = new ModelRenderer(this, 0, 0);
		this.LeftWing.setRotationPoint(5.0F, 1.0F, -14.0F);
		this.LeftWing.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 11.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.Tail1 = new ModelRenderer(this, 0, 42);
		this.Tail1.setRotationPoint(0.0F, -4.0F, 5.0F);
		this.Tail1.addBox(-3.0F, -2.0F, 0.0F, 6.0F, 8.0F, 24.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Tail1, -0.04555309164612875F, 0.0F, 0.0F);
		this.LeftLeg1 = new ModelRenderer(this, 94, 71);
		this.LeftLeg1.setRotationPoint(5.0F, 3.9F, 1.0F);
		this.LeftLeg1.addBox(-3.0F, -3.0F, -4.0F, 5.0F, 12.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 3, 2);
		this.Body.setRotationPoint(0.0F, 3.9F, 1.0F);
		this.Body.addBox(-5.0F, -7.0F, -16.0F, 10.0F, 14.0F, 22.0F, 0.0F, 0.0F, 0.0F);
		this.Head1.addChild(this.Snout);
		this.Tail2.addChild(this.Feathers);
		this.Tail1.addChild(this.Tail2);
		this.LeftLeg1.addChild(this.LeftLeg2);
		this.Body.addChild(this.Neck);
		this.Body.addChild(this.RightWing);
		this.Neck.addChild(this.Head1);
		this.RightLeg1.addChild(this.RightLeg2);
		this.Body.addChild(this.LeftWing);
		this.Body.addChild(this.Tail1);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		ImmutableList.of(this.RightLeg1, this.LeftLeg1, this.Body).forEach((modelRenderer) -> {
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(DakotaraptorEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress = entityIn.getMeleeProgress(partialTick);
		this.resetModel();
		if (entityIn.isCrouching()) {
			this.Body.rotateAngleX =  0.39269908169872414F;
			this.RightWing.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.05F) * degree * 0.6F * limbSwingAmount + 0.4F;
	    	this.LeftWing.rotateAngleZ = MathHelper.cos(3.0F + limbSwing * speed * 0.05F) * degree * 0.6F * limbSwingAmount - 0.4F;
	    	this.Body.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.05F) * degree * 0.2F * limbSwingAmount + 0.5F;
	    	this.LeftLeg1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
	    	this.LeftLeg2.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
	    	this.RightLeg1.rotateAngleX = MathHelper.cos(3.0F + limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
	    	this.RightLeg2.rotateAngleX = MathHelper.cos(3.0F + limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
	    	this.Tail1.rotateAngleX = -0.08464846705724931F + (MathHelper.cos(limbSwing * speed * 0.05F) * degree * 0.3F * limbSwingAmount - 0.3F);
	    	this.Tail2.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.1F) * degree * 0.1F * limbSwingAmount - 0.1F;
	    	this.Tail2.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.1F) * degree * 0.4F * limbSwingAmount;
		}
		else if (entityIn.isSitting()) {
			this.Tail2.rotateAngleX = 0.13665927909957545F;
			this.RightWing.rotateAngleX = 0.7740534966278743F;
			this.RightWing.rotateAngleZ = (Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3)));
			this.Neck.rotateAngleX = 0.6829473549475088F;
			this.LeftWing.rotateAngleX = 0.7740534966278743F;
			this.LeftWing.rotateAngleZ = (-Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3)));
			this.Body.rotateAngleX = -0.6373942508178124F;
			this.LeftLeg1.rotateAngleX = -1.5707963267948966F;
			this.LeftLeg1.rotateAngleY = -0.18203784630933073F;
			this.RightLeg1.rotateAngleX = -1.5707963267948966F;
			this.RightLeg1.rotateAngleY = 0.18203784630933073F;
			this.Tail1.rotateAngleX = 0.500909508638178F;
			this.Body.rotationPointY = 14.9F;
			this.LeftLeg1.rotationPointY = 18.9F;
			this.LeftLeg1.rotationPointZ = 3;
			this.LeftLeg2.rotationPointY = 7;
			this.RightLeg2.rotationPointY = 7;
			this.RightLeg1.rotationPointY = 18.9F;
			this.RightLeg1.rotationPointZ = 3;
			this.Neck.rotationPointY = -4;
			this.Neck.rotationPointZ = -16;
			this.Head1.rotationPointZ = 0;
			this.Tail1.rotationPointZ = 3;
		}
		else if (entityIn.isAsleep()) {
			this.RightWing.rotateAngleZ = 1.092750655326294F;
			this.RightLeg1.rotateAngleX = -1.5707963267948966F;
			this.LeftLeg1.rotateAngleX = -1.5707963267948966F + (Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3)));
			this.LeftWing.rotateAngleZ = -1.092750655326294F + (-Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3)));
			this.Neck.rotateAngleX = 0.13665927909957545F;
			this.Neck.rotateAngleY = -1.4570009181544104F;
			this.Tail1.rotateAngleX = -0.2275909337942703F;
			this.Tail1.rotateAngleY = 1.5707963267948966F;
			this.Tail2.rotateAngleX = -0.04555309164612875F;
			this.Tail2.rotateAngleY = 1.8668041519541685F;
			this.Body.rotationPointY = 16.9F;
			this.Body.rotationPointZ = 5;
			this.LeftLeg1.rotationPointX = 5;
			this.LeftLeg1.rotationPointY = 18.9F;
			this.LeftLeg1.rotationPointZ = 6;
			this.LeftLeg2.rotationPointY = 2;
			this.RightLeg1.rotationPointX = -5;
			this.RightLeg1.rotationPointY = 18.9F;
			this.RightLeg1.rotationPointZ = 6;
			this.RightLeg2.rotationPointY = 2;
			this.Neck.rotationPointY = 1;
			this.Neck.rotationPointZ = -16;
			this.Head1.rotationPointZ = 0;
			this.Tail1.rotationPointX = -3;
		}
		else {
			this.LeftLeg1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount + attackProgress * (float) Math.toRadians(-65F);
			this.RightLeg1.rotateAngleX = MathHelper.cos(3.0F + limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount + attackProgress * (float) Math.toRadians(-65F);
			this.Tail1.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(limbSwing * speed * 0.2F) * degree * 0.2F * limbSwingAmount);
			this.Tail2.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tail1.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(limbSwing * speed * 0.2F) * degree * 0.05F * limbSwingAmount + 0.05F) + attackProgress * (float) Math.toRadians(25F);
			this.Tail2.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(limbSwing * speed * 0.1F) * degree * 0.1F * limbSwingAmount - 0.05F);
			this.Tail2.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.1F) * degree * 0.1F * limbSwingAmount;
			this.Body.rotateAngleX = (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.1F) * (degree / 2) * 0.2F * limbSwingAmount) + attackProgress * (float) Math.toRadians(-30F);
			this.Neck.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)) + (MathHelper.cos(limbSwing * speed * 0.1F) * (degree / 2) * 0.3F * limbSwingAmount + 0.1F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(25F);
			this.Neck.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
			this.Head1.rotateAngleX = -Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
			this.LeftWing.rotateAngleZ = (-Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.1F * limbSwingAmount) + attackProgress * (float) Math.toRadians(-85F);
			this.RightWing.rotateAngleZ = (Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3))) + (MathHelper.cos(3.0F + limbSwing * speed * 0.4F) * degree * 0.1F * limbSwingAmount) + attackProgress * (float) Math.toRadians(85F);
			this.Head1.rotateAngleX = headPitch * ((float) Math.PI / 180F);
			this.LeftWing.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.2F) * degree * 0.2F * limbSwingAmount;
			this.RightWing.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.2F) * degree * 0.2F * limbSwingAmount;
		}
	}
	
	public void resetModel() {
		this.Body.rotateAngleX = 0;
		this.Body.rotateAngleY = 0;
		this.Body.rotateAngleZ = 0;
		this.LeftLeg1.rotateAngleX = 0;
		this.LeftLeg1.rotateAngleY = 0;
		this.LeftLeg1.rotateAngleZ = 0;
		this.RightLeg1.rotateAngleX = 0;
		this.RightLeg1.rotateAngleY = 0;
		this.RightLeg1.rotateAngleZ = 0;
		this.LeftLeg2.rotateAngleX = 0;
		this.LeftLeg2.rotateAngleY = 0;
		this.LeftLeg2.rotateAngleZ = 0;
		this.RightLeg2.rotateAngleX = 0;
		this.RightLeg2.rotateAngleY = 0;
		this.RightLeg2.rotateAngleZ = 0;
		this.RightWing.rotateAngleX = 0;
		this.RightWing.rotateAngleY = 0;
		this.RightWing.rotateAngleZ = 0;
		this.LeftWing.rotateAngleX = 0;
		this.LeftWing.rotateAngleY = 0;
		this.LeftWing.rotateAngleZ = 0;
		this.Tail1.rotateAngleX = -0.04555309164612875F;
		this.Tail1.rotateAngleY = 0;
		this.Tail1.rotateAngleZ = 0;
		this.Neck.rotateAngleX = 0.13962634015954636F;
		this.Neck.rotateAngleY = 0;
		this.Neck.rotateAngleZ = 0;
		this.Tail2.rotateAngleX = 0;
		this.Tail2.rotateAngleY = 0;
		this.Tail2.rotateAngleZ = 0;
		this.Feathers.rotateAngleX = 0;
		this.Feathers.rotateAngleY = 0;
		this.Feathers.rotateAngleZ = 0;
		this.Head1.rotateAngleX = 0;
		this.Head1.rotateAngleY = 0;
		this.Head1.rotateAngleZ = 0;
		this.Snout.rotateAngleX = 0;
		this.Snout.rotateAngleY = 0;
		this.Snout.rotateAngleZ = 0;
		this.Body.rotationPointX = 0;
		this.Body.rotationPointY = 3.9F;
		this.Body.rotationPointZ = 1;
		this.Neck.rotationPointX = 0;
		this.Neck.rotationPointY = -6;
		this.Neck.rotationPointZ = -14;
		this.Head1.rotationPointX = 0;
		this.Head1.rotationPointY = -8;
		this.Head1.rotationPointZ = 1;
		this.LeftWing.rotationPointX = 5;
		this.LeftWing.rotationPointY = 1;
		this.LeftWing.rotationPointZ = -14;
		this.RightWing.rotationPointX = -5;
		this.RightWing.rotationPointY = 1;
		this.RightWing.rotationPointZ = -14;
		this.Tail1.rotationPointX = 0;
		this.Tail1.rotationPointY = -4;
		this.Tail1.rotationPointZ = 5;
		this.Tail2.rotationPointX = 0;
		this.Tail2.rotationPointY = 0;
		this.Tail2.rotationPointZ = 23;
		this.LeftLeg1.rotationPointX = 5;
		this.LeftLeg1.rotationPointY = 3.9F;
		this.LeftLeg1.rotationPointZ = 1;
		this.LeftLeg2.rotationPointX = -1;
		this.LeftLeg2.rotationPointY = 9;
		this.LeftLeg2.rotationPointZ = 5;
		this.RightLeg1.rotationPointX = -5;
		this.RightLeg1.rotationPointY = 3.9F;
		this.RightLeg1.rotationPointZ = 1;
		this.RightLeg2.rotationPointX = 1;
		this.RightLeg2.rotationPointY = 9;
		this.RightLeg2.rotationPointZ = 5;
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
