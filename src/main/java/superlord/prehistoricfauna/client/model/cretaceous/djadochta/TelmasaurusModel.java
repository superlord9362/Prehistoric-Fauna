package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.TelmasaurusEntity;

/**
 * Telmasaurus - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class TelmasaurusModel extends EntityModel<TelmasaurusEntity> implements IHasArm {
	public ModelRenderer Body;
	public ModelRenderer Frontlegright;
	public ModelRenderer Frontlegleft;
	public ModelRenderer Backlegright;
	public ModelRenderer Backlegleft;
	public ModelRenderer Head;
	public ModelRenderer Tail;
	public ModelRenderer Tongue;
	public ModelRenderer Frontfootright;
	public ModelRenderer Frontfootleft;
	public ModelRenderer Backfootright;
	public ModelRenderer Backfootleft;

	public TelmasaurusModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.Backlegleft = new ModelRenderer(this, 0, 28);
		this.Backlegleft.setRotationPoint(1.0F, 20.7F, 4.0F);
		this.Backlegleft.addBox(0.0F, -0.7F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Frontfootright = new ModelRenderer(this, 0, 0);
		this.Frontfootright.mirror = true;
		this.Frontfootright.setRotationPoint(-1.0F, 3.29F, 1.0F);
		this.Frontfootright.setTextureOffset(17, 26).addBox(0.0F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Frontfootright, 0.0F, 0.7853981633974483F, 0.0F);
		this.Tongue = new ModelRenderer(this, 32, 9);
		this.Tongue.setRotationPoint(0.0F, 0.0F, -5.8F);
		this.Tongue.addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Tongue, 0.11623892551966127F, 0.0F, 0.0F);
		this.Backfootright = new ModelRenderer(this, 0, 0);
		this.Backfootright.mirror = true;
		this.Backfootright.setRotationPoint(0.0F, 3.29F, 0.0F);
		this.Backfootright.setTextureOffset(16, 30).addBox(-3.0F, 0.0F, -3.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 19.7F, -2.0F);
		this.Body.addBox(-1.5F, -1.0F, -4.0F, 3.0F, 3.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.Tail = new ModelRenderer(this, 0, 22);
		this.Tail.setRotationPoint(0.0F, 0.5F, 9.0F);
		this.Tail.addBox(-1.0F, -1.2F, -0.4F, 2.0F, 2.0F, 14.0F, 0.0F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 29, 0);
		this.Head.setRotationPoint(0.0F, 0.0F, -4.2F);
		this.Head.addBox(-1.0F, -1.0F, -5.8F, 2.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.Backlegright = new ModelRenderer(this, 0, 28);
		this.Backlegright.setRotationPoint(-1.0F, 20.7F, 4.0F);
		this.Backlegright.addBox(-1.0F, -0.7F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Backfootleft = new ModelRenderer(this, 0, 0);
		this.Backfootleft.setRotationPoint(0.0F, 3.29F, 0.0F);
		this.Backfootleft.setTextureOffset(16, 30).addBox(0.0F, 0.0F, -3.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Frontlegleft = new ModelRenderer(this, 0, 20);
		this.Frontlegleft.setRotationPoint(1.0F, 20.7F, -4.0F);
		this.Frontlegleft.addBox(0.0F, -0.7F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Frontlegright = new ModelRenderer(this, 0, 20);
		this.Frontlegright.setRotationPoint(-1.0F, 20.7F, -4.0F);
		this.Frontlegright.addBox(-1.0F, -0.7F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Frontfootleft = new ModelRenderer(this, 0, 0);
		this.Frontfootleft.setRotationPoint(1.0F, 3.29F, 1.0F);
		this.Frontfootleft.setTextureOffset(17, 26).addBox(-3.0F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Frontfootleft, 0.0F, -0.7853981633974483F, 0.0F);
		this.Frontlegright.addChild(this.Frontfootright);
		this.Head.addChild(this.Tongue);
		this.Backlegright.addChild(this.Backfootright);
		this.Body.addChild(this.Tail);
		this.Body.addChild(this.Head);
		this.Backlegleft.addChild(this.Backfootleft);
		this.Frontlegleft.addChild(this.Frontfootleft);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Backlegleft, this.Body, this.Backlegright, this.Frontlegleft, this.Frontlegright).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(TelmasaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		this.Tail.rotateAngleX = 0;
		this.Tail.rotateAngleY = 0;
		this.Frontlegright.rotateAngleX = 0;
		this.Frontlegright.rotateAngleY = 0;
		this.Frontlegright.rotateAngleZ = 0;
		this.Backlegleft.rotateAngleX = 0;
		this.Backlegleft.rotateAngleY = 0;
		this.Backlegleft.rotateAngleZ = 0;
		this.Frontfootright.rotateAngleY = 0.7853981633974483F;
		this.Frontlegleft.rotateAngleX = 0;
		this.Frontlegleft.rotateAngleY = 0;
		this.Frontlegleft.rotateAngleZ = 0;
		this.Head.rotateAngleX = 0;
		this.Head.rotateAngleY = 0;
		this.Backlegright.rotateAngleX = 0;
		this.Backlegright.rotateAngleY = 0;
		this.Backlegright.rotateAngleZ = 0;
		this.Body.rotateAngleX = 0;
		this.Body.rotateAngleZ = 0;
		this.Tail.rotateAngleZ = 0;
		this.Body.rotationPointY = 19.7F;
		this.Backlegleft.rotationPointY = 20.7F;
		this.Backlegright.rotationPointY = 20.7F;
		this.Frontlegleft.rotationPointY = 20.7F;
		this.Frontlegright.rotationPointY = 20.7F;
		this.Frontfootleft.rotateAngleZ =  0;
		this.Frontfootright.rotateAngleZ = 0;
		this.Backfootleft.rotateAngleX = 0;
		this.Backfootleft.rotateAngleY = 0;
		this.Backfootleft.rotateAngleZ = 0;
		this.Backfootright.rotateAngleX = 0;
		this.Backfootright.rotateAngleY = 0;
		this.Backfootright.rotateAngleZ = 0;
		if (entityIn.isAsleep()) {
			this.Body.rotationPointY = 22.2F;
			this.Backlegleft.rotationPointY = 23.7F;
			this.Backlegright.rotationPointY = 23.7F;
			this.Frontlegleft.rotationPointY = 23.7F;
			this.Frontlegright.rotationPointY = 23.7F;
			this.Tail.rotateAngleX = -0.01762782527869516F;
			this.Tail.rotateAngleY = 0.583638077898454F;
			this.Frontlegright.rotateAngleX = -0.6215117572878252F;
			this.Frontlegright.rotateAngleY = -0.2546435405291338F;
			this.Frontlegright.rotateAngleZ = 1.4978415587352114F;
			this.Backlegleft.rotateAngleX = 0.6557201946479475F;
			this.Backlegleft.rotateAngleY = -6.981316851932723E-4F;
			this.Backlegleft.rotateAngleZ = -1.459793375715413F;
			this.Frontfootright.rotateAngleY = 0.7853981633974483F;
			this.Frontlegleft.rotateAngleX = -0.5478588415483757F;
			this.Frontlegleft.rotateAngleY = 0.182212366584515F;
			this.Frontlegleft.rotateAngleZ = -1.3870131778651824F;
			this.Head.rotateAngleX = 0.009424778335276407F;
			this.Head.rotateAngleY = -0.40125119103875473F;
			this.Backlegright.rotateAngleX = 0.7668976493578585F;
			this.Backlegright.rotateAngleY = 0.11013027480215679F;
			this.Backlegright.rotateAngleZ = 1.4606660936046318F;
		} else {
			this.Body.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
			this.Body.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
			this.Tail.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.05F * ageInTicks / 5))) + (MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.2F);
			this.Tail.rotateAngleY = (-0.12F * MathHelper.sin(0.05F * ageInTicks / 5)) + (MathHelper.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
			this.Tail.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
			this.Head.rotateAngleX = (-Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1F);
			this.Backlegleft.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.5F * limbSwingAmount;
			this.Backlegright.rotateAngleX = MathHelper.cos(4.0F + limbSwing * speed * 0.3F) * degree * 0.5F * limbSwingAmount;
			this.Frontlegleft.rotateAngleX = MathHelper.cos(4.0F + limbSwing * speed * 0.3F) * degree * 0.5F * limbSwingAmount;
			this.Frontlegright.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.5F * limbSwingAmount;
			if (entityIn.isInWater()) {
				this.Body.rotationPointY = 17.2F;
				this.Backlegleft.rotationPointY  =  18.7F;
				this.Backlegright.rotationPointY = 18.7F;
				this.Frontlegleft.rotationPointY = 18.7F;
				this.Frontlegright.rotationPointY = 18.7F;
				this.Frontlegleft.rotateAngleX = 1.25F;
				this.Frontlegleft.rotateAngleY = 0.25F;
				this.Frontlegright.rotateAngleX = 1.25F;
				this.Frontlegright.rotateAngleY = -0.25F;
				this.Backlegright.rotateAngleX = 1.25F;
				this.Backlegright.rotateAngleY = -0.25F + (0.25F * MathHelper.sin(0.25F * ageInTicks / 1F));
				this.Backlegleft.rotateAngleX = 1.25F;
				this.Backlegleft.rotateAngleY = 0.25F + (0.25F * MathHelper.sin(0.25F * ageInTicks / 1F));
				this.Tail.rotateAngleY = 0.25F * MathHelper.sin(0.25F * ageInTicks / 1F);
				this.Frontfootleft.rotateAngleZ =  1.3688617376654748F;
				this.Frontfootright.rotateAngleZ = -1.3683381601951652F;
				this.Backfootleft.rotateAngleX = -0.11728612207217244F;
				this.Backfootleft.rotateAngleY = 0.03909537541112055F;
				this.Backfootleft.rotateAngleZ = 1.2510520131558576F;
				this.Backfootright.rotateAngleX = -0.11728612207217244F;
				this.Backfootright.rotateAngleY = 0.03909537541112055F;
				this.Backfootright.rotateAngleZ = -1.2510520131558576F;
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

	public void translateHand(HandSide sideIn, MatrixStack matrixStackIn) {
		float f = sideIn == HandSide.RIGHT ? 1.0F : -1.0F;
		ModelRenderer modelrenderer = this.getArmForSide(sideIn);
		modelrenderer.rotationPointX += f;
		modelrenderer.translateRotate(matrixStackIn);
		modelrenderer.rotationPointX -= f;
		matrixStackIn.translate(0, 0.7, 0);
	}

	protected ModelRenderer getArmForSide(HandSide side) {
		return side == HandSide.LEFT ? this.Head : this.Head;
	}
}
