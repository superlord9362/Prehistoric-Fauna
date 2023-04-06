package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TyrannosaurusEntity;

/**
 * Tyrannosaurus rex juvenile - Weastian
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class TyrannosaurusrexjuvenileModel extends EntityModel<TyrannosaurusEntity> {
	public ModelRenderer Body1;
	public ModelRenderer LeftLeg1;
	public ModelRenderer RightLeg1;
	public ModelRenderer Body2;
	public ModelRenderer Tail1;
	public ModelRenderer Neck;
	public ModelRenderer LeftArm;
	public ModelRenderer RightArm;
	public ModelRenderer Head1;
	public ModelRenderer Snout;
	public ModelRenderer Tail2;
	public ModelRenderer LeftLeg2;
	public ModelRenderer LeftFeet;
	public ModelRenderer RightLeg2;
	public ModelRenderer RightFeet;

	public TyrannosaurusrexjuvenileModel() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.Tail1 = new ModelRenderer(this, 8, 69);
		this.Tail1.setRotationPoint(0.0F, -3.0F, 6.0F);
		this.Tail1.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 11.0F, 33.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Tail1, -0.04555309164612875F, 0.0F, 0.0F);
		this.Snout = new ModelRenderer(this, 58, 67);
		this.Snout.setRotationPoint(0.0F, -3.0F, -8.0F);
		this.Snout.addBox(-2.0F, 0.0F, -9.0F, 4.0F, 7.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.LeftLeg1 = new ModelRenderer(this, 0, 43);
		this.LeftLeg1.setRotationPoint(4.0F, -7.0F, -1.0F);
		this.LeftLeg1.addBox(-3.0F, -6.0F, -5.0F, 6.0F, 20.0F, 12.0F, 0.0F, 0.0F, 0.0F);
		this.LeftFeet = new ModelRenderer(this, 69, 41);
		this.LeftFeet.setRotationPoint(0.0F, 16.0F, 2.0F);
		this.LeftFeet.addBox(-3.0F, -1.0F, -8.0F, 6.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.Body2 = new ModelRenderer(this, 63, 0);
		this.Body2.setRotationPoint(0.0F, -1.0F, -5.0F);
		this.Body2.addBox(-5.0F, -5.0F, -19.0F, 10.0F, 15.0F, 19.0F, 0.0F, 0.0F, 0.0F);
		this.Head1 = new ModelRenderer(this, 0, 81);
		this.Head1.setRotationPoint(0.0F, -11.1F, -4.0F);
		this.Head1.addBox(-3.0F, -4.0F, -8.0F, 6.0F, 9.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 56, 61);
		this.Tail2.setRotationPoint(0.0F, -1.0F, 33.0F);
		this.Tail2.addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 31.0F, 0.0F, 0.0F, 0.0F);
		this.Body1 = new ModelRenderer(this, 0, 0);
		this.Body1.setRotationPoint(0.0F, -10.0F, -1.0F);
		this.Body1.addBox(-4.0F, -7.0F, -11.0F, 8.0F, 17.0F, 20.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Body1, 0.0F, 0.006283185556850939F, 0.0F);
		this.LeftLeg2 = new ModelRenderer(this, 42, 38);
		this.LeftLeg2.setRotationPoint(0.0F, 14.0F, 5.0F);
		this.LeftLeg2.addBox(-2.0F, -4.0F, -1.0F, 4.0F, 20.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.RightLeg2 = new ModelRenderer(this, 42, 38);
		this.RightLeg2.mirror = true;
		this.RightLeg2.setRotationPoint(0.0F, 14.0F, 5.0F);
		this.RightLeg2.addBox(-2.0F, -4.0F, -1.0F, 4.0F, 20.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.RightLeg1 = new ModelRenderer(this, 0, 43);
		this.RightLeg1.setRotationPoint(-4.0F, -7.0F, -1.0F);
		this.RightLeg1.addBox(-3.0F, -6.0F, -5.0F, 6.0F, 20.0F, 12.0F, 0.0F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 104, 59);
		this.Neck.setRotationPoint(0.0F, 1.0F, -17.0F);
		this.Neck.addBox(-2.0F, -15.0F, -7.0F, 4.0F, 20.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Neck, 0.2275909337942703F, 0.0F, 0.0F);
		this.LeftArm = new ModelRenderer(this, 59, 0);
		this.LeftArm.setRotationPoint(4.1F, 8.0F, -14.0F);
		this.LeftArm.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 9.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(LeftArm, 0.27314402127920984F, 0.0F, 0.0F);
		this.RightArm = new ModelRenderer(this, 59, 0);
		this.RightArm.mirror = true;
		this.RightArm.setRotationPoint(-4.1F, 8.0F, -14.0F);
		this.RightArm.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 9.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(RightArm, 0.27314402127920984F, 0.0F, 0.0F);
		this.RightFeet = new ModelRenderer(this, 69, 41);
		this.RightFeet.setRotationPoint(0.0F, 16.0F, 2.0F);
		this.RightFeet.addBox(-3.0F, -1.0F, -8.0F, 6.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.Body1.addChild(this.Tail1);
		this.Head1.addChild(this.Snout);
		this.LeftLeg2.addChild(this.LeftFeet);
		this.Body1.addChild(this.Body2);
		this.Neck.addChild(this.Head1);
		this.Tail1.addChild(this.Tail2);
		this.LeftLeg1.addChild(this.LeftLeg2);
		this.RightLeg1.addChild(this.RightLeg2);
		this.Body2.addChild(this.Neck);
		this.Body2.addChild(this.LeftArm);
		this.Body2.addChild(this.RightArm);
		this.RightLeg2.addChild(this.RightFeet);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.LeftLeg1, this.Body1, this.RightLeg1).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(TyrannosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.resetModel();
		if (entityIn.isAsleep()) {
			this.LeftLeg2.rotateAngleX = -0.8761552978169589F;
			this.LeftFeet.rotateAngleX = 1.5707963267948966F;
			this.RightFeet.rotateAngleX = 1.5707963267948966F;
			this.Head1.rotateAngleX = 0.41887902047863906F;
			this.Head1.rotateAngleY = -1.0471975511965976F;
			this.RightLeg2.rotateAngleX = -0.8639379797371932F;
			this.RightLeg2.rotateAngleY = -0.17453292519943295F;
			this.RightLeg2.rotateAngleZ = -0.17453292519943295F;
			this.Neck.rotateAngleX = 0.41887902047863906F;
			this.Neck.rotateAngleY = -1.0471975511965976F;
			this.RightLeg1.rotateAngleX = -0.6981317007977318F;
			this.RightLeg1.rotateAngleY = 0.3490658503988659F;
			this.Body2.rotateAngleX = 0.17453292519943295F;
			this.Body2.rotateAngleY = -0.5235987755982988F;
			this.Body1.rotateAngleX = -0.17453292519943295F;
			this.Tail2.rotateAngleX = 0.24434609527920614F;
			this.Tail2.rotateAngleY = 0.41887902047863906F;
			this.Tail2.rotateAngleZ = 0.17453292519943295F;
			this.LeftLeg1.rotateAngleX = -0.6981317007977318F;
			this.LeftLeg1.rotateAngleY = -0.5235987755982988F;
			this.RightArm.rotateAngleX = 0.7330382858376184F;
			this.RightArm.rotateAngleY = 0.24434609527920614F;
			this.RightArm.rotateAngleZ = 0.24434609527920614F;
			this.Tail1.rotateAngleX = -0.17453292519943295F;
			this.Tail1.rotateAngleY = 0.593411945678072F;
			this.LeftArm.rotateAngleX = 0.6283185307179586F;
			this.LeftArm.rotateAngleZ = -0.24434609527920614F;
			this.Body1.rotationPointY = 12.6F;
			this.Tail2.rotationPointX = -1;
			this.Body2.rotationPointX = -2;
			this.Body2.rotationPointY = -3;
			this.Body2.rotationPointZ = -6;
			this.Neck.rotationPointX = -2;
			this.Head1.rotationPointX = -2;
			this.Head1.rotationPointY = -11;
			this.Head1.rotationPointZ = -6.7F;
			this.LeftArm.rotationPointX = 4.5F;
			this.RightArm.rotationPointX = -5F;
			this.RightArm.rotationPointZ = -14.5F;
			this.LeftLeg1.rotationPointX = 6;
			this.LeftLeg1.rotationPointY = 8.8F;
			this.LeftLeg2.rotationPointZ = 4;
			this.LeftFeet.rotationPointZ = 1;
			this.RightLeg1.rotationPointX = -6;
			this.RightLeg1.rotationPointY = 8.8F;
			this.RightLeg2.rotationPointZ = 4;
			this.RightFeet.rotationPointZ = 1;
		} else {
			if (entityIn.isJuvenile()) {
				float speed = 0.8f;
				float degree = 1.0f;
				this.Neck.rotateAngleX = MathHelper.cos(-1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.25F;
				this.Body2.rotateAngleX = MathHelper.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.01F * limbSwingAmount;
				this.Body1.rotateAngleX = MathHelper.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.Tail1.rotateAngleX = MathHelper.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.15F;
				this.Tail2.rotateAngleX = MathHelper.cos(-1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.1F;
				this.Tail1.rotateAngleY = MathHelper.cos((limbSwing / 3) * speed * 0.15F) * degree * 0.2F * limbSwingAmount;
				this.Tail2.rotateAngleY = MathHelper.cos((limbSwing / 3) * speed * 0.15F) * degree * 0.25F * limbSwingAmount;
				this.Head1.rotateAngleX = MathHelper.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.1F;
				this.LeftArm.rotateAngleX = MathHelper.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
				this.RightArm.rotateAngleX = MathHelper.cos(2.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
				this.LeftLeg1.rotateAngleX = MathHelper.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.6F * limbSwingAmount - 0.05F;
				this.LeftLeg2.rotateAngleX = MathHelper.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.05F;
				this.LeftFeet.rotateAngleX = MathHelper.cos(2.0F + (limbSwing / 3) * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.RightLeg1.rotateAngleX = MathHelper.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * -0.6F * limbSwingAmount - 0.05F;
				this.RightLeg2.rotateAngleX = MathHelper.cos(1.0F + (limbSwing / 3) * speed * 0.3F) * degree * -0.4F * limbSwingAmount + 0.05F;
				this.RightFeet.rotateAngleX = MathHelper.cos(2.0F + (limbSwing / 3) * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				if (entityIn.isInWater()) {
					this.LeftLeg1.rotationPointY = 20;
					this.RightLeg1.rotationPointY = 20;
					this.Body1.rotationPointY = 20;
					this.Body1.rotateAngleX = -0.25F;
					this.Tail1.rotateAngleX = 0.125F;
					this.Tail2.rotateAngleX = 0.125F;
					this.Neck.rotateAngleX = 0.25F;
					this.LeftLeg1.rotateAngleX = -0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
					this.RightLeg1.rotateAngleX = 0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
					this.RightArm.rotateAngleX = 0.25F;
					this.LeftArm.rotateAngleX = 0.25F;
					this.Tail1.rotateAngleY = (MathHelper.cos((limbSwing / 3) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.rotateAngleY = (MathHelper.cos((limbSwing / 3) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
					this.LeftLeg2.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg2.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
					this.LeftFeet.rotateAngleX = 0.5F - (0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F));
					this.RightFeet.rotateAngleX = 0.5F + (0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F));
				}
			} else {
				float speed = 0.8f;
				float degree = 1.0f;
				this.Neck.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.25F;
				this.Body2.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.01F * limbSwingAmount;
				this.Body1.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.Tail1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.15F;
				this.Tail2.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.1F;
				this.Tail1.rotateAngleY = MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.2F * limbSwingAmount;
				this.Tail2.rotateAngleY = MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.25F * limbSwingAmount;
				this.Head1.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.1F;
				this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
				this.RightArm.rotateAngleX = MathHelper.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
				this.LeftLeg1.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount - 0.05F;
				this.LeftLeg2.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.05F;
				this.LeftFeet.rotateAngleX = MathHelper.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.RightLeg1.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount - 0.05F;
				this.RightLeg2.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + 0.05F;
				this.RightFeet.rotateAngleX = MathHelper.cos(2.0F + limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				if (entityIn.isInWater()) {
					this.LeftLeg1.rotationPointY = 20;
					this.RightLeg1.rotationPointY = 20;
					this.Body1.rotationPointY = 20;
					this.Body1.rotateAngleX = -0.25F;
					this.Tail1.rotateAngleX = 0.125F;
					this.Tail2.rotateAngleX = 0.125F;
					this.Neck.rotateAngleX = 0.25F;
					this.LeftLeg1.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg1.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg2.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg2.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
					this.LeftFeet.rotateAngleX = 0.5F - (0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F));
					this.RightFeet.rotateAngleX = 0.5F + (0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F));
					this.RightArm.rotateAngleX = 0.25F;
					this.LeftArm.rotateAngleX = 0.25F;
					this.Tail1.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
				}
			}
			
		}
	}
	
	public void resetModel() {
		this.LeftLeg2.rotateAngleX = 0;
		this.LeftFeet.rotateAngleX = 0;
		this.RightFeet.rotateAngleX = 0;
		this.Head1.rotateAngleX = 0;
		this.Head1.rotateAngleY = 0;
		this.RightLeg2.rotateAngleX = 0;
		this.RightLeg2.rotateAngleY = 0;
		this.RightLeg2.rotateAngleZ = -0;
		this.Neck.rotateAngleX = 0.2275909337942703F;
		this.Neck.rotateAngleY = 0;
		this.RightLeg1.rotateAngleX = 0;
		this.RightLeg1.rotateAngleY = 0;
		this.Body2.rotateAngleX = 0;
		this.Body2.rotateAngleY = 0;
		this.Body1.rotateAngleX = 0;
		this.Tail2.rotateAngleX = 0;
		this.Tail2.rotateAngleY = 0;
		this.Tail2.rotateAngleZ = 0;
		this.LeftLeg1.rotateAngleX = 0;
		this.LeftLeg1.rotateAngleY = 0;
		this.RightArm.rotateAngleX = 0.27314402127920984F;
		this.RightArm.rotateAngleY = 0;
		this.RightArm.rotateAngleZ = 0;
		this.Tail1.rotateAngleX = -0.04555309164612875F;
		this.Tail1.rotateAngleY = 0;
		this.LeftArm.rotateAngleX = 0.6283185307179586F;
		this.LeftArm.rotateAngleZ = 0;
		this.Body1.rotationPointY = -10;
		this.Tail2.rotationPointX = 0;
		this.Body2.rotationPointX = 0;
		this.Body2.rotationPointY = -1;
		this.Body2.rotationPointZ = -5;
		this.Neck.rotationPointX = 0;
		this.Head1.rotationPointX = 0;
		this.Head1.rotationPointY = -11.1F;
		this.Head1.rotationPointZ = -4F;
		this.LeftArm.rotationPointX = 4.1F;
		this.RightArm.rotationPointX = -4.1F;
		this.RightArm.rotationPointZ = -14F;
		this.LeftLeg1.rotationPointX = 4;
		this.LeftLeg1.rotationPointY = -7F;
		this.LeftLeg2.rotationPointZ = 5;
		this.LeftFeet.rotationPointZ = 2;
		this.RightLeg1.rotationPointX = -4;
		this.RightLeg1.rotationPointY = -7;
		this.RightLeg2.rotationPointZ = 5;
		this.RightFeet.rotationPointZ = 2;
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
