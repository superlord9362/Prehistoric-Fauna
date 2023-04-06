package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ExaeretodonEntity;

/**
 * Exaeretodon - TheDarkTroodon
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ExaeretodonModel extends EntityModel<ExaeretodonEntity> {
	public ModelRenderer Body;
	public ModelRenderer Head;
	public ModelRenderer LeftFrontLeg;
	public ModelRenderer RightFrontLeg;
	public ModelRenderer LeftBackLeg;
	public ModelRenderer RightBackLeg;
	public ModelRenderer Tail;
	public ModelRenderer Snoot;

	public ExaeretodonModel() {
		this.textureWidth = 48;
		this.textureHeight = 48;
		this.LeftBackLeg = new ModelRenderer(this, 28, 0);
		this.LeftBackLeg.setRotationPoint(3.0F, -1.5F, 8.5F);
		this.LeftBackLeg.addBox(0.0F, -1.5F, -1.51F, 3.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.LeftFrontLeg = new ModelRenderer(this, 30, 18);
		this.LeftFrontLeg.setRotationPoint(3.0F, -0.5F, -0.5F);
		this.LeftFrontLeg.addBox(0.0F, -1.5F, -1.51F, 3.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 0, 18);
		this.Head.setRotationPoint(0.0F, -3.0F, -2.0F);
		this.Head.addBox(-2.5F, -3.0F, -6.0F, 5.0F, 4.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.Snoot = new ModelRenderer(this, 0, 28);
		this.Snoot.setRotationPoint(0.0F, 0.0F, -6.0F);
		this.Snoot.addBox(-1.5F, -3.0F, -4.0F, 3.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.RightFrontLeg = new ModelRenderer(this, 30, 18);
		this.RightFrontLeg.mirror = true;
		this.RightFrontLeg.setRotationPoint(-3.0F, -0.5F, -0.5F);
		this.RightFrontLeg.addBox(-3.0F, -1.5F, -1.51F, 3.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.RightBackLeg = new ModelRenderer(this, 28, 0);
		this.RightBackLeg.mirror = true;
		this.RightBackLeg.setRotationPoint(-3.0F, -1.5F, 8.5F);
		this.RightBackLeg.addBox(-3.0F, -1.5F, -1.51F, 3.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 21.0F, -4.0F);
		this.Body.addBox(-4.0F, -6.0F, -2.0F, 8.0F, 6.0F, 12.0F, 0.0F, 0.0F, 0.0F);
		this.Tail = new ModelRenderer(this, 16, 22);
		this.Tail.setRotationPoint(0.0F, -5.0F, 10.0F);
		this.Tail.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.Body.addChild(this.LeftBackLeg);
		this.Body.addChild(this.LeftFrontLeg);
		this.Body.addChild(this.Head);
		this.Head.addChild(this.Snoot);
		this.Body.addChild(this.RightFrontLeg);
		this.Body.addChild(this.RightBackLeg);
		this.Body.addChild(this.Tail);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(ExaeretodonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entityIn.isAsleep()) {
			this.RightBackLeg.rotateAngleX = 1.6816247076649256F;
			this.RightBackLeg.rotateAngleY = -0.40125119103875473F;
			this.Tail.rotationPointZ = 9.1F;
			this.Tail.rotateAngleX = -0.07295475973730675F;
			this.Tail.rotateAngleY = 0.36477380700891215F;
			this.Tail.rotateAngleZ = 0.01902408942930468F;
			this.Head.rotationPointY = -2.6F;
			this.Head.rotationPointZ = 0.0F;
			this.Head.rotateAngleX = 0.3284709598990106F;
			this.Head.rotateAngleY = -0.40194933871851896F;
			this.Head.rotateAngleZ = -0.291819038949227F;
			this.Body.rotationPointY = 23.6F;
			this.Body.rotateAngleX = -0.1459095194746135F;
			this.RightFrontLeg.rotationPointX = -2.6F;
			this.RightFrontLeg.rotationPointY = -0.1F;
			this.RightFrontLeg.rotationPointZ = -0.6F;
			this.RightFrontLeg.rotateAngleX = -1.314407417066352F;
			this.RightFrontLeg.rotateAngleY = -1.1299261204568736F;
			this.RightFrontLeg.rotateAngleZ = -0.2556907287592666F;
			this.LeftBackLeg.rotateAngleX = 1.605702911834783F;
			this.LeftBackLeg.rotateAngleY = 0.291819038949227F;
			this.LeftFrontLeg.rotateAngleX = -0.8030259595478191F;
			this.LeftFrontLeg.rotateAngleY = 1.1311478456069475F;
			this.LeftFrontLeg.rotateAngleZ = 0.6201154619282966F;
		} else {
			this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
			this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			this.RightBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LeftBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.RightFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.LeftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			if (entityIn.isEating()) {
				this.Head.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
			}
			if (entityIn.isInWater()) {
				this.RightFrontLeg.rotateAngleX = 0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.LeftFrontLeg.rotateAngleX = -0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.RightBackLeg.rotateAngleX = -0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.LeftBackLeg.rotateAngleX = 0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.Tail.rotateAngleX = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.RightBackLeg.rotateAngleX = 0;
		this.RightBackLeg.rotateAngleY = 0;
		this.Tail.rotationPointZ = 10.0F;
		this.Tail.rotateAngleX = 0;
		this.Tail.rotateAngleY = 0;
		this.Tail.rotateAngleZ = 0;
		this.Head.rotationPointY = -3.0F;
		this.Head.rotationPointZ = -2.0F;
		this.Head.rotateAngleX = 0;
		this.Head.rotateAngleY = 0;
		this.Head.rotateAngleZ = 0;
		this.Body.rotationPointY = 21.0F;
		this.Body.rotateAngleX = 0;
		this.RightFrontLeg.rotationPointX = -3.0F;
		this.RightFrontLeg.rotationPointY = -0.5F;
		this.RightFrontLeg.rotationPointZ = -0.5F;
		this.RightFrontLeg.rotateAngleX = 0;
		this.RightFrontLeg.rotateAngleY = 0;
		this.RightFrontLeg.rotateAngleZ = 0;
		this.LeftBackLeg.rotateAngleX = 0;
		this.LeftBackLeg.rotateAngleY = 0;
		this.LeftFrontLeg.rotateAngleX = 0;
		this.LeftFrontLeg.rotateAngleY = 0;
		this.LeftFrontLeg.rotateAngleZ = 0;
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
