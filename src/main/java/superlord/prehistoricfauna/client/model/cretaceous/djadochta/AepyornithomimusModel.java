package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.AepyornithomimusEntity;

/**
 * Aepyornithomimus - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class AepyornithomimusModel extends EntityModel<AepyornithomimusEntity> {
	public ModelRenderer Body;
	public ModelRenderer Thighleft;
	public ModelRenderer Thighleft_1;
	public ModelRenderer Tailbase;
	public ModelRenderer HeadNeck;
	public ModelRenderer Wingleft;
	public ModelRenderer Wingright;
	public ModelRenderer Tailtip;
	public ModelRenderer part7;
	public ModelRenderer Beak;
	public ModelRenderer Crest;
	public ModelRenderer legleft;
	public ModelRenderer legleft_1;

	public AepyornithomimusModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.Wingright = new ModelRenderer(this, 44, 0);
		this.Wingright.mirror = true;
		this.Wingright.setRotationPoint(-1.8F, 2.0F, -8.0F);
		this.Wingright.addBox(-1.0F, -1.0F, -1.0F, 1.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.Tailtip = new ModelRenderer(this, 30, 25);
		this.Tailtip.setRotationPoint(0.0F, 0.0F, 10.0F);
		this.Tailtip.addBox(-1.0F, -1.0F, -1.5F, 2.0F, 3.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 12.0F, 0.0F);
		this.Body.addBox(-2.0F, -3.0F, -10.0F, 4.0F, 6.0F, 14.0F, 0.0F, 0.0F, 0.0F);
		this.Beak = new ModelRenderer(this, 22, 0);
		this.Beak.setRotationPoint(0.0F, -7.0F, -2.5F);
		this.Beak.addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.legleft_1 = new ModelRenderer(this, 0, 38);
		this.legleft_1.mirror = true;
		this.legleft_1.setRotationPoint(-0.5F, 5.0F, 2.0F);
		this.legleft_1.addBox(-1.0F, 0.0F, -3.0F, 2.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.Thighleft = new ModelRenderer(this, 0, 20);
		this.Thighleft.setRotationPoint(1.5F, 12.0F, 1.0F);
		this.Thighleft.addBox(-0.5F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.part7 = new ModelRenderer(this, 0, 20);
		this.part7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.part7.addBox(-2.0F, 0.0F, 0.5F, 4.0F, 3.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.Tailbase = new ModelRenderer(this, 26, 10);
		this.Tailbase.setRotationPoint(0.0F, -2.0F, 4.5F);
		this.Tailbase.addBox(-1.5F, -1.0F, -1.5F, 3.0F, 4.0F, 11.0F, 0.0F, 0.0F, 0.0F);
		this.legleft = new ModelRenderer(this, 0, 38);
		this.legleft.setRotationPoint(0.5F, 5.0F, 2.0F);
		this.legleft.addBox(-1.0F, 0.0F, -3.0F, 2.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.Crest = new ModelRenderer(this, 23, 6);
		this.Crest.setRotationPoint(0.0F, -8.0F, 0.5F);
		this.Crest.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Thighleft_1 = new ModelRenderer(this, 0, 20);
		this.Thighleft_1.mirror = true;
		this.Thighleft_1.setRotationPoint(-1.5F, 12.0F, 1.0F);
		this.Thighleft_1.addBox(-1.5F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.HeadNeck = new ModelRenderer(this, 0, 0);
		this.HeadNeck.setRotationPoint(0.0F, -1.0F, -10.0F);
		this.HeadNeck.addBox(-1.0F, -8.0F, -2.5F, 2.0F, 10.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.Wingleft = new ModelRenderer(this, 44, 0);
		this.Wingleft.setRotationPoint(1.8F, 2.0F, -8.0F);
		this.Wingleft.addBox(0.0F, -1.0F, -1.0F, 1.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Wingleft, 0.0F, 0.0787143532596859F, 0.0F);
		this.Body.addChild(this.Wingright);
		this.Tailbase.addChild(this.Tailtip);
		this.HeadNeck.addChild(this.Beak);
		this.Thighleft_1.addChild(this.legleft_1);
		this.Tailtip.addChild(this.part7);
		this.Body.addChild(this.Tailbase);
		this.Thighleft.addChild(this.legleft);
		this.HeadNeck.addChild(this.Crest);
		this.Body.addChild(this.HeadNeck);
		this.Body.addChild(this.Wingleft);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Body, this.Thighleft, this.Thighleft_1).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(AepyornithomimusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Thighleft_1.rotateAngleX = 0;
		this.Thighleft_1.rotateAngleY = 0;
		this.Wingright.rotateAngleX = 0;
		this.Wingright.rotateAngleZ = 0;
		this.Tailbase.rotateAngleX = 0;
		this.Tailbase.rotateAngleY = 0;
		this.Wingleft.rotateAngleX = 0;
		this.Wingleft.rotateAngleZ = 0;
		this.HeadNeck.rotateAngleX = 0;
		this.HeadNeck.rotateAngleY = 0;
		this.HeadNeck.rotateAngleZ = 0;
		this.Tailtip.rotateAngleY = 0;
		this.Tailtip.rotateAngleX = 0;
		this.Thighleft.rotateAngleX = 0;
		this.Thighleft.rotateAngleZ = 0;
		this.Thighleft.rotateAngleY = 0;
		this.Body.rotationPointY = 12;
		this.Thighleft.rotationPointY = 12;
		this.Thighleft_1.rotationPointY = 12;
		this.Body.rotateAngleX = 0;
		this.legleft.rotateAngleX = 0;
		this.legleft_1.rotateAngleX = 0;
		if (entityIn.isAsleep()) {
			this.Body.rotationPointY = 21;
			this.Thighleft.rotationPointY = 21;
			this.Thighleft_1.rotationPointY = 21;
			this.Thighleft_1.rotateAngleX = -0.46931902520863084F;
			this.Thighleft_1.rotateAngleY = 0.03909537541112055F;
			this.Wingright.rotateAngleX = 0.35185837453889574F;
			this.Wingright.rotateAngleZ = 1.2892747663851107F;
			this.Tailbase.rotateAngleX = -0.1563815016444822F;
			this.Tailbase.rotateAngleY = 0.4300491170387584F;
			this.Wingleft.rotateAngleX = 0.35185837453889574F;
			this.Wingleft.rotateAngleZ = -1.2901473511162753F;
			this.HeadNeck.rotateAngleX = 0.5864306020384839F;
			this.HeadNeck.rotateAngleY = -1.759291939273506F;
			this.HeadNeck.rotateAngleZ = 0.3127630032889644F;
			this.Tailtip.rotateAngleY = 0.5082398928281348F;
			this.Thighleft.rotateAngleX = -0.46914448828868976F;
			this.Thighleft.rotateAngleY = -0.03909537541112055F;
		} else {
			this.Thighleft_1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.Thighleft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Tailbase.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tailtip.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tailbase.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.Tailtip.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.HeadNeck.rotateAngleX = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)));
			this.Wingleft.rotateAngleZ = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
			this.Wingright.rotateAngleZ = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
			this.HeadNeck.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			if (entityIn.isEating()) {
				this.HeadNeck.rotateAngleX = Math.abs(MathHelper.sin(0.15F * ageInTicks) * 0.75F) + 1.5F;
			}
			if (entityIn.isInWater()) {
				this.Thighleft.rotationPointY = 17;
				this.Thighleft_1.rotationPointY = 17;
				this.Body.rotationPointY = 17;
				this.Body.rotateAngleX = -0.5F;
				this.Tailbase.rotateAngleX = 0.25F;
				this.Tailtip.rotateAngleX = 0.25F;
				this.HeadNeck.rotateAngleX = 0.5F;
				this.Wingleft.rotateAngleZ = -1.5F + Math.abs(-1F * MathHelper.sin(0.2F * ageInTicks / 2));
				this.Wingright.rotateAngleZ = 1.5F - Math.abs(-1F * MathHelper.sin(0.2F * ageInTicks / 2));
				this.Thighleft.rotateAngleX = -0.5F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.Thighleft_1.rotateAngleX = 0.5F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.Tailbase.rotateAngleY = MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
				this.Tailtip.rotateAngleY = MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
				this.legleft_1.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.legleft.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
			}
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
