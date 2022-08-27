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
		this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.RightBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LeftBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.RightFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.LeftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		if (entityIn.isEating()) {
			this.Head.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
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
