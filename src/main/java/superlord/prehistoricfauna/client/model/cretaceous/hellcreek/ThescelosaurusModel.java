package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.ThescelosaurusEntity;

/**
 * Thescelosaurus - Weastian
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ThescelosaurusModel extends EntityModel<ThescelosaurusEntity> {
	public ModelRenderer Body;
	public ModelRenderer RightLeg1;
	public ModelRenderer LeftLeg1;
	public ModelRenderer Head;
	public ModelRenderer Tail1;
	public ModelRenderer LeftArm;
	public ModelRenderer RightArm;
	public ModelRenderer Snout;
	public ModelRenderer Tail2;
	public ModelRenderer RightLeg2;
	public ModelRenderer LeftLeg2;

	public ThescelosaurusModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.Head = new ModelRenderer(this, 0, 29);
		this.Head.setRotationPoint(0.0F, -1.0F, -12.0F);
		this.Head.addBox(-2.0F, -8.0F, -4.0F, 4.0F, 11.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Head, 0.13665927909957545F, 0.0F, 0.0F);
		this.RightArm = new ModelRenderer(this, 32, 0);
		this.RightArm.setRotationPoint(-2.1F, 3.0F, -9.0F);
		this.RightArm.addBox(-1.0F, -1.0F, -1.0F, 1.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(RightArm, 0.18203784630933073F, 0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 28, 44);
		this.Tail2.setRotationPoint(0.0F, 1.0F, 14.0F);
		this.Tail2.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.Tail1 = new ModelRenderer(this, 3, 30);
		this.Tail1.setRotationPoint(0.0F, -3.0F, 6.0F);
		this.Tail1.addBox(-2.0F, -1.0F, -2.0F, 4.0F, 5.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Tail1, -0.04555309164612875F, 0.0F, 0.0F);
		this.LeftArm = new ModelRenderer(this, 32, 0);
		this.LeftArm.setRotationPoint(2.1F, 3.0F, -9.0F);
		this.LeftArm.addBox(0.0F, -1.0F, -1.0F, 1.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(LeftArm, 0.18203784630933073F, 0.0F, 0.0F);
		this.Snout = new ModelRenderer(this, 0, 54);
		this.Snout.setRotationPoint(0.0F, -7.0F, -4.0F);
		this.Snout.addBox(-1.0F, 0.0F, -4.0F, 2.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.LeftLeg2 = new ModelRenderer(this, 0, 0);
		this.LeftLeg2.setRotationPoint(0.0F, 7.0F, 4.0F);
		this.LeftLeg2.addBox(-2.0F, 0.0F, -5.0F, 3.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.RightLeg2 = new ModelRenderer(this, 0, 0);
		this.RightLeg2.setRotationPoint(0.0F, 7.0F, 4.0F);
		this.RightLeg2.addBox(-1.0F, 0.0F, -5.0F, 3.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.LeftLeg1 = new ModelRenderer(this, 43, 0);
		this.LeftLeg1.setRotationPoint(3.0F, 10.9F, 0.0F);
		this.LeftLeg1.addBox(-2.0F, -2.0F, -3.0F, 3.0F, 9.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.RightLeg1 = new ModelRenderer(this, 43, 0);
		this.RightLeg1.setRotationPoint(-3.0F, 10.9F, 0.0F);
		this.RightLeg1.addBox(-1.0F, -2.0F, -3.0F, 3.0F, 9.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 10.9F, 0.0F);
		this.Body.addBox(-3.0F, -5.0F, -12.0F, 6.0F, 10.0F, 18.0F, 0.0F, 0.0F, 0.0F);
		this.Body.addChild(this.Head);
		this.Body.addChild(this.RightArm);
		this.Tail1.addChild(this.Tail2);
		this.Body.addChild(this.Tail1);
		this.Body.addChild(this.LeftArm);
		this.Head.addChild(this.Snout);
		this.LeftLeg1.addChild(this.LeftLeg2);
		this.RightLeg1.addChild(this.RightLeg2);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		ImmutableList.of(this.LeftLeg1, this.RightLeg1, this.Body).forEach((modelRenderer) -> {
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(ThescelosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress = entityIn.getMeleeProgress(partialTick);
		resetModel();
		if (entityIn.isAsleep()) {
			this.RightLeg1.rotateAngleX = -1.4076080683650378F;
			this.RightLeg1.rotateAngleY = 0.27366763203903305F;
			this.Body.rotateAngleX = -0.19547687289441354F;
			this.LeftArm.rotateAngleX = 0.7688175221876966F;
			this.LeftArm.rotateAngleY = 0.004188790111159634F;
			this.LeftLeg2.rotateAngleX = 0.03909537541112055F;
			this.LeftLeg2.rotateAngleY = 3.141592653589793F;
			this.Snout.rotateAngleX = 0.05235987755982988F;
			this.Tail2.rotateAngleX = 0.23457224414434488F;
			this.Tail2.rotateAngleY = -0.03909537541112055F;
			this.Tail2.rotateAngleZ = -0.0781907508222411F;
			this.RightLeg2.rotateAngleX = 0.07801621390230003F;
			this.RightLeg2.rotateAngleY = 3.141592653589793F;
			this.RightArm.rotateAngleX = 0.6511823678875341F;
			this.RightArm.rotateAngleY = 0.11746065899211351F;
			this.LeftLeg1.rotateAngleX = -1.4072589279461283F;
			this.LeftLeg1.rotateAngleY = -0.35185837453889574F;
			this.Head.rotateAngleX = -0.19547687289441354F;
			this.Head.rotateAngleY = 0.7428121536172364F;
			this.Head.rotateAngleZ = -0.0781907508222411F;
			this.Tail1.rotateAngleX = -0.0781907508222411F;
			this.Tail1.rotateAngleY = -0.27401668923415834F;
			this.Tail1.rotateAngleZ = -0.1956514098143546F;
			this.Body.rotationPointY = 18.9F;
			this.RightLeg1.rotationPointY = 18.9F;
			this.RightLeg1.rotationPointZ = 3;
			this.RightLeg2.rotationPointX = 1;
			this.RightLeg2.rotationPointY = 2.8F;
			this.RightLeg2.rotationPointZ = 3.7F;
			this.LeftLeg1.rotationPointY = 18.9F;
			this.LeftLeg1.rotationPointZ = 3;
			this.LeftLeg2.rotationPointX = -1;
			this.LeftLeg2.rotationPointY = 3;
			this.LeftLeg2.rotationPointZ = 3.7F;
			this.Head.rotationPointZ = -11.4F;
			this.RightArm.rotationPointX = -3.1F;
			this.RightArm.rotationPointY = 1;
			this.RightArm.rotationPointZ = -10;
			this.LeftArm.rotationPointX = 3.1F;
			this.LeftArm.rotationPointY = 1;
			this.LeftArm.rotationPointZ = -10;
		} else {
			this.Head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
			this.RightLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LeftLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.Tail1.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tail2.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tail1.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.Tail2.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.Body.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
			this.Head.rotateAngleX = (headPitch * ((float) Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
			this.LeftArm.rotateAngleZ = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(-50F);
			this.RightArm.rotateAngleZ = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(50F);
			if (entityIn.isEating()) {
				this.Head.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
				this.Body.rotateAngleX = 0.2F;
			}
			if (entityIn.isInWater()) {
				this.LeftLeg1.rotationPointY = 20;
				this.RightLeg1.rotationPointY = 20;
				this.Body.rotationPointY = 20;
				this.Body.rotateAngleX = -0.5F;
				this.Tail1.rotateAngleX = 0.25F;
				this.Tail2.rotateAngleX = 0.25F;
				this.Head.rotateAngleX = 0.5F;
				this.LeftLeg1.rotateAngleX = -0.5F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg1.rotateAngleX = 0.5F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg2.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg2.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RightArm.rotateAngleX = 0.5F;
				this.LeftArm.rotateAngleX = 0.5F;
				this.Tail1.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.RightLeg1.rotateAngleX = 0;
		this.RightLeg1.rotateAngleY = 0;
		this.Body.rotateAngleX = 0;
		this.LeftArm.rotateAngleX = 0;
		this.LeftArm.rotateAngleY = 0;
		this.LeftArm.rotateAngleZ = 0;
		this.LeftLeg2.rotateAngleX = 0;
		this.LeftLeg2.rotateAngleY = 0;
		this.Snout.rotateAngleX = 0;
		this.Tail2.rotateAngleX = 0;
		this.Tail2.rotateAngleY = 0;
		this.Tail2.rotateAngleZ = 0;
		this.RightLeg2.rotateAngleX = 0;
		this.RightLeg2.rotateAngleY = 0;
		this.RightArm.rotateAngleZ = 0;
		this.RightArm.rotateAngleX = 0;
		this.RightArm.rotateAngleY = 0;
		this.LeftLeg1.rotateAngleX = 0;
		this.LeftLeg1.rotateAngleY = 0;
		this.Head.rotateAngleX = 0.13665927909957545F;
		this.Head.rotateAngleY = 0;
		this.Head.rotateAngleZ = 0;
		this.Tail1.rotateAngleX = 0;
		this.Tail1.rotateAngleY = 0;
		this.Tail1.rotateAngleZ = 0F;
		this.Body.rotationPointY = 10.9F;
		this.RightLeg1.rotationPointY = 10.9F;
		this.RightLeg1.rotationPointZ = 0;
		this.RightLeg2.rotationPointX = 0;
		this.RightLeg2.rotationPointY = 7F;
		this.RightLeg2.rotationPointZ = 4F;
		this.LeftLeg1.rotationPointY = 10.9F;
		this.LeftLeg1.rotationPointZ = 0;
		this.LeftLeg2.rotationPointX = 0;
		this.LeftLeg2.rotationPointY = 7;
		this.LeftLeg2.rotationPointZ = 4;
		this.Head.rotationPointZ = -12;
		this.RightArm.rotationPointX = -2.1F;
		this.RightArm.rotationPointY = 3;
		this.RightArm.rotationPointZ = -9;
		this.LeftArm.rotationPointX = 2.1F;
		this.LeftArm.rotationPointY = 3;
		this.LeftArm.rotationPointZ = -9;
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
