package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.KayentatheriumEntity;

/**
 * Kayentatherium - Crimes
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class KayentatheriumModel extends EntityModel<KayentatheriumEntity> {
	public ModelRenderer Body;
	public ModelRenderer Head;
	public ModelRenderer RightArm;
	public ModelRenderer LeftArm;
	public ModelRenderer RightLeg;
	public ModelRenderer LeftLeg;
	public ModelRenderer Tail;

	public KayentatheriumModel() {
		this.textureWidth = 35;
		this.textureHeight = 50;
		this.Head = new ModelRenderer(this, 0, 0);
		this.Head.setRotationPoint(0.0F, 1.0F, 1.0F);
		this.Head.setTextureOffset(10, 0).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.RightArm = new ModelRenderer(this, 0, 0);
		this.RightArm.setRotationPoint(1.5F, 3.0F, 2.0F);
		this.RightArm.setTextureOffset(27, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.01F, 0.01F, 0.01F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 18.0F, -7.0F);
		this.Body.setTextureOffset(1, 8).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 12.0F, 0.0F, 0.0F, 0.0F);
		this.LeftLeg = new ModelRenderer(this, 0, 0);
		this.LeftLeg.mirror = true;
		this.LeftLeg.setRotationPoint(-1.5F, 3.0F, 10.5F);
		this.LeftLeg.setTextureOffset(25, 5).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F, 0.01F, 0.01F, 0.01F);
		this.RightLeg = new ModelRenderer(this, 0, 0);
		this.RightLeg.setRotationPoint(1.5F, 3.0F, 10.5F);
		this.RightLeg.setTextureOffset(25, 5).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F, 0.01F, 0.01F, 0.01F);
		this.Tail = new ModelRenderer(this, 0, 0);
		this.Tail.setRotationPoint(0.0F, 2.0F, 12.0F);
		this.Tail.setTextureOffset(1, 24).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.LeftArm = new ModelRenderer(this, 0, 0);
		this.LeftArm.mirror = true;
		this.LeftArm.setRotationPoint(-1.5F, 3.0F, 2.0F);
		this.LeftArm.setTextureOffset(27, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.01F, 0.01F, 0.01F);
		this.Body.addChild(this.Head);
		this.Body.addChild(this.RightArm);
		this.Body.addChild(this.LeftLeg);
		this.Body.addChild(this.RightLeg);
		this.Body.addChild(this.Tail);
		this.Body.addChild(this.LeftArm);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(KayentatheriumEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entityIn.isAsleep()) {
			this.Body.rotationPointY = 20;
			this.Body.rotationPointZ = -6.0F;
			this.Head.rotateAngleX = 0.46931902520863084F;
			this.RightLeg.rotateAngleX = 1.602910321115726F;
			this.RightLeg.rotateAngleY = 0.3909537457888271F;
			this.Tail.rotateAngleX = -0.23457224414434488F;
			this.RightArm.rotateAngleX = -1.0164797856562695F;
			this.RightArm.rotateAngleY = -0.8991936386169619F;
			this.LeftArm.rotateAngleX = -1.0164797856562695F;
			this.LeftArm.rotateAngleY = 0.8991936386169619F;
			this.LeftLeg.rotateAngleX = 1.6030848913251807F;
			this.LeftLeg.rotateAngleY = -0.3909537457888271F;
		} else {
			this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
			this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			if (entityIn.isEating()) {
				this.Head.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
			}
			if (entityIn.isInWater()) {
				this.RightArm.rotateAngleX = 0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.LeftArm.rotateAngleX = -0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.RightLeg.rotateAngleX = -0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.LeftLeg.rotateAngleX = 0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.Tail.rotateAngleX = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}
	
	public void resetModel() {
		this.Body.rotationPointY = 18.0F;
		this.Body.rotationPointZ = -7.0F;
		this.Head.rotateAngleX = 0;
		this.Head.rotateAngleY = 0;
		this.Head.rotateAngleZ = 0;
		this.RightLeg.rotateAngleX = 0;
		this.RightLeg.rotateAngleY = 0;
		this.Tail.rotateAngleX = 0;
		this.RightArm.rotateAngleX = 0;
		this.RightArm.rotateAngleY = 0;
		this.LeftArm.rotateAngleX = 0;
		this.LeftArm.rotateAngleY = 0;
		this.LeftLeg.rotateAngleX = 0;
		this.LeftLeg.rotateAngleY = 0;
		this.Tail.rotateAngleX = -0.25F;
		this.Tail.rotationPointZ = 11.75F;
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
