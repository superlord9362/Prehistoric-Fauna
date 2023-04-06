package superlord.prehistoricfauna.client.model.jurassic.morrison;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.HesperornithoidesEntity;

/**
 * Hesperornithoides - TheDarkTroodon
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class HesperornithoidesModel extends EntityModel<HesperornithoidesEntity> {
	public ModelRenderer Body;
	public ModelRenderer Head;
	public ModelRenderer LeftWing;
	public ModelRenderer RightWing;
	public ModelRenderer LeftLeg;
	public ModelRenderer RightLeg;
	public ModelRenderer Tail;
	public ModelRenderer Snoot;
	public ModelRenderer Fluff;

	public HesperornithoidesModel() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.LeftWing = new ModelRenderer(this, 13, 5);
		this.LeftWing.setRotationPoint(1.5F, 0.0F, 1.0F);
		this.LeftWing.addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Fluff = new ModelRenderer(this, 10, 18);
		this.Fluff.setRotationPoint(0.0F, -4.0F, -1.0F);
		this.Fluff.addBox(-0.5F, -2.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.RightWing = new ModelRenderer(this, 13, 5);
		this.RightWing.mirror = true;
		this.RightWing.setRotationPoint(-1.5F, 0.0F, 1.0F);
		this.RightWing.addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.RightLeg = new ModelRenderer(this, 17, 16);
		this.RightLeg.mirror = true;
		this.RightLeg.setRotationPoint(-0.25F, 3.0F, 4.0F);
		this.RightLeg.addBox(-1.0F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 1, 17);
		this.Head.setRotationPoint(0.0F, 2.0F, 0.0F);
		this.Head.addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.01F, 0.01F);
		this.LeftLeg = new ModelRenderer(this, 17, 16);
		this.LeftLeg.setRotationPoint(0.25F, 3.0F, 4.0F);
		this.LeftLeg.addBox(0.0F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.Tail = new ModelRenderer(this, 19, 5);
		this.Tail.setRotationPoint(0.0F, 0.0F, 5.0F);
		this.Tail.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 1, 8);
		this.Body.setRotationPoint(0.0F, 17.0F, -2.5F);
		this.Body.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.Snoot = new ModelRenderer(this, 1, 24);
		this.Snoot.setRotationPoint(0.0F, -4.0F, -1.0F);
		this.Snoot.addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.Body.addChild(this.LeftWing);
		this.Head.addChild(this.Fluff);
		this.Body.addChild(this.RightWing);
		this.Body.addChild(this.RightLeg);
		this.Body.addChild(this.Head);
		this.Body.addChild(this.LeftLeg);
		this.Body.addChild(this.Tail);
		this.Head.addChild(this.Snoot);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(HesperornithoidesEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress = entityIn.getMeleeProgress(partialTick);
		resetModel();
		if (entityIn.isAsleep()) {
			this.LeftLeg.rotationPointY = 0;
			this.RightLeg.rotationPointY = 0;
			this.LeftWing.rotationPointY = 0.3F;
			this.LeftWing.rotateAngleX = -0.33004175888896664F;
			this.LeftWing.rotateAngleY = -0.21537363235926135F;
			this.RightWing.rotationPointY = 0.3F;
			this.RightWing.rotateAngleX = -0.33004175888896664F;
			this.RightWing.rotateAngleY = 0.21537363235926135F;
			this.Head.rotationPointY = 2.4F;
			this.Head.rotateAngleX = -0.182212366584515F;
			this.Tail.rotationPointY = 0.6F;
			this.Tail.rotateAngleX = -0.21938788164936507F;
			this.Tail.rotateAngleY = -0.1096066806870904F;
			this.Tail.rotateAngleZ = -0.07295475973730675F;
			this.Body.rotationPointY = 20.8F;
			this.Body.rotateAngleX = 0.07278023113974408F;
			this.Fluff.rotateAngleX = -1.058367647756717F;
			this.Fluff.rotationPointY = -4.5F;
			this.Fluff.rotationPointZ = -0.1F;
		} else {
			this.Head.rotateAngleX = (headPitch * ((float) Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
			this.LeftWing.rotateAngleZ = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(-50F);
			this.RightWing.rotateAngleZ = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(50F);
			this.Fluff.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 3));
			this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Tail.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tail.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.LeftWing.rotateAngleY = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
			this.RightWing.rotateAngleY = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
			if (entityIn.isDustBathing()) {
				this.LeftWing.rotateAngleY = Math.abs(-0.25F * MathHelper.sin(0.3F * ageInTicks));
				this.RightWing.rotateAngleY = -Math.abs(-0.25F * MathHelper.sin(0.3F * ageInTicks));
				this.LeftWing.rotateAngleZ = -Math.abs(-0.5F * MathHelper.sin(0.3F * ageInTicks));
				this.RightWing.rotateAngleZ = Math.abs(-0.5F * MathHelper.sin(0.3F * ageInTicks));
			}
			if (entityIn.isInWater()) {
				this.Body.rotationPointY = 17;
				this.Body.rotateAngleX = -0.25F;
				this.Tail.rotateAngleX = 0.25F;
				this.Head.rotateAngleX = 0.25F;
				this.LeftWing.rotateAngleZ = -1.5F + Math.abs(-1F * MathHelper.sin(0.15F * ageInTicks / 2));
				this.RightWing.rotateAngleZ = 1.5F - Math.abs(-1F * MathHelper.sin(0.15F * ageInTicks / 2));
				this.LeftLeg.rotateAngleX = -0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg.rotateAngleX = 0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Tail.rotateAngleY = MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
			}
		}
	}

	public void resetModel() {
		this.LeftLeg.rotationPointY = 3.0F;
		this.RightLeg.rotationPointY = 3.0F;
		this.LeftWing.rotationPointY = 0.0F;
		this.LeftWing.rotateAngleX = 0;
		this.LeftWing.rotateAngleY = 0;
		this.LeftWing.rotateAngleZ = 0;
		this.RightWing.rotationPointY = 0.0F;
		this.RightWing.rotateAngleX = 0;
		this.RightWing.rotateAngleY = 0;
		this.RightWing.rotateAngleZ = 0;
		this.Head.rotationPointY = 2.0F;
		this.Head.rotateAngleX = 0;
		this.Head.rotateAngleY = 0;
		this.Tail.rotationPointY = 0;
		this.Tail.rotateAngleX = 0;
		this.Tail.rotateAngleY = 0;
		this.Tail.rotateAngleZ = 0;
		this.Body.rotationPointY = 17.0F;
		this.Body.rotateAngleX = 0;
		this.Fluff.rotationPointY = -4;
		this.Fluff.rotationPointZ = -1;
		this.Fluff.rotateAngleX = 0;
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
