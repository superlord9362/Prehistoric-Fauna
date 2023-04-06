package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HyperodapedonEntity;

/**
 * Hyperodapedon - superlord9362
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class HyperodapedonModel extends EntityModel<HyperodapedonEntity> {
	public ModelRenderer Body;
	public ModelRenderer Head;
	public ModelRenderer RArm;
	public ModelRenderer LArm;
	public ModelRenderer RLeg;
	public ModelRenderer LLeg;
	public ModelRenderer Tail;
	public ModelRenderer Snout;

	public HyperodapedonModel() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 19.0F, -5.0F);
		this.Body.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 10.0F, 0.0F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 0, 13);
		this.Head.setRotationPoint(0.0F, 1.5F, 0.0F);
		this.Head.addBox(-2.5F, -1.5F, -3.0F, 5.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.RArm = new ModelRenderer(this, 0, 0);
		this.RArm.setRotationPoint(1.0F, 3.0F, 1.01F);
		this.RArm.addBox(0.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Snout = new ModelRenderer(this, 0, 19);
		this.Snout.setRotationPoint(-1.0F, 0.0F, -4.0F);
		this.Snout.addBox(-0.5F, -0.5F, 0.0F, 3.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.LArm = new ModelRenderer(this, 0, 0);
		this.LArm.mirror = true;
		this.LArm.setRotationPoint(-1.0F, 3.0F, 1.01F);
		this.LArm.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.RLeg = new ModelRenderer(this, 18, 0);
		this.RLeg.setRotationPoint(1.0F, 2.0F, 8.0F);
		this.RLeg.addBox(0.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.LLeg = new ModelRenderer(this, 18, 0);
		this.LLeg.mirror = true;
		this.LLeg.setRotationPoint(-1.0F, 2.0F, 8.0F);
		this.LLeg.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.Tail = new ModelRenderer(this, 19, 0);
		this.Tail.setRotationPoint(0.0F, 2.0F, 10.0F);
		this.Tail.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Body.addChild(this.Head);
		this.Body.addChild(this.RArm);
		this.Head.addChild(this.Snout);
		this.Body.addChild(this.LArm);
		this.Body.addChild(this.RLeg);
		this.Body.addChild(this.LLeg);
		this.Body.addChild(this.Tail);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(HyperodapedonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		resetModel();
		if (entityIn.isAsleep()) {
			this.Body.rotationPointX = 0.1F;
			this.Body.rotationPointY = 21.0F;
			this.Body.rotateAngleX = -0.036477379868653376F;
			this.Body.rotateAngleY = -0.036477379868653376F;
			this.Body.rotateAngleZ = -0.8395033435776615F;
			this.LLeg.rotationPointX = -1.4F;
			this.LLeg.rotationPointY = 1.3F;
			this.LLeg.rotateAngleX = -0.07295475973730675F;
			this.LLeg.rotateAngleY = 0.036477379868653376F;
			this.LLeg.rotateAngleZ = -0.7665485755179764F;
			this.Head.rotationPointY = 1.6F;
			this.Head.rotateAngleX = 0.2556907287592666F;
			this.Head.rotateAngleY = -0.3645992700889711F;
			this.Head.rotateAngleZ = 0.6932448001974364F;
			this.RArm.rotationPointX = 0.7F;
			this.RArm.rotationPointZ = 2.41F;
			this.RArm.rotateAngleX = 0.10943214376714933F;
			this.RArm.rotateAngleY = 0.0712094321497881F;
			this.RArm.rotateAngleZ = 0.36477380700891215F;
			this.LArm.rotationPointY = 1.4F;
			this.LArm.rotationPointZ = 0.71F;
			this.LArm.rotateAngleX = -0.18256144042439712F;
			this.LArm.rotateAngleY = -0.10978120928465304F;
			this.LArm.rotateAngleZ = -0.6202900321377512F;
			this.Tail.rotationPointY = 0.9F;
			this.Tail.rotationPointZ = 9.7F;
			this.Tail.rotateAngleX = -0.1459095194746135F;
			this.Tail.rotateAngleY = 0.9482374145664524F;
			this.Tail.rotateAngleZ = 0.8032005297572737F;
			this.RLeg.rotationPointY = 3.1F;
			this.RArm.rotateAngleX = 0.583638077898454F;
		} else {
			this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
			this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			this.RLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.RArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.LArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			if (entityIn.isEating()) {
				this.Head.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
			}
			if (entityIn.isInWater()) {
				this.LLeg.rotateAngleX = 0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.RLeg.rotateAngleX = 0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.RArm.rotateAngleX = -0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.LArm.rotateAngleX = -0.25F * MathHelper.sin(0.15F * ageInTicks / 1.5F);
				this.Tail.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.Body.rotationPointX = 0F;
		this.Body.rotationPointY = 19.0F;
		this.Body.rotateAngleX = 0;
		this.Body.rotateAngleY = 0;
		this.Body.rotateAngleZ = 0;
		this.LLeg.rotationPointX = -1.0F;
		this.LLeg.rotationPointY = 2.0F;
		this.LLeg.rotateAngleX = 0;
		this.LLeg.rotateAngleY = 0;
		this.LLeg.rotateAngleZ = 0;
		this.Head.rotationPointY = 1.5F;
		this.Head.rotateAngleX = 0;
		this.Head.rotateAngleY = 0;
		this.Head.rotateAngleZ = 0;
		this.RArm.rotationPointX = 1.0F;
		this.RArm.rotationPointZ = 1.01F;
		this.RArm.rotateAngleX = 0;
		this.RArm.rotateAngleY = 0;
		this.RArm.rotateAngleZ = 0;
		this.LArm.rotationPointY = 3.0F;
		this.LArm.rotationPointZ = 1.01F;
		this.LArm.rotateAngleX = 0;
		this.LArm.rotateAngleY = 0;
		this.LArm.rotateAngleZ = 0;
		this.Tail.rotationPointY = 2.0F;
		this.Tail.rotationPointZ = 10.0F;
		this.Tail.rotateAngleX = 0;
		this.Tail.rotateAngleY = 0;
		this.Tail.rotateAngleZ = 0;
		this.RLeg.rotationPointY = 2.0F;
		this.RArm.rotateAngleX = 0;
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
