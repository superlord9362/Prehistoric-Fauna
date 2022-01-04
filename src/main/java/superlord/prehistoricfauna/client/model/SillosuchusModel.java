package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.SillosuchusEntity;

/**
 * Sillosuchus - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SillosuchusModel extends EntityModel<SillosuchusEntity> {
	public ModelRenderer RightThigh;
	public ModelRenderer LeftThigh;
	public ModelRenderer Body;
	public ModelRenderer RightLeg;
	public ModelRenderer RightFoot;
	public ModelRenderer LeftLeg;
	public ModelRenderer LeftFoot;
	public ModelRenderer Tail1;
	public ModelRenderer Neck;
	public ModelRenderer RightArm;
	public ModelRenderer LeftArm;
	public ModelRenderer Tail2;
	public ModelRenderer Head;
	public ModelRenderer beak;
	public ModelRenderer Jaw;
	public ModelRenderer Jaw2;
	public ModelRenderer throat;

	public SillosuchusModel() {
		this.textureWidth = 256;
		this.textureHeight = 256;
		this.Tail2 = new ModelRenderer(this, 3, 142);
		this.Tail2.setRotationPoint(0.0F, -1.0F, 37.0F);
		this.Tail2.addBox(-3.5F, -1.0F, -3.0F, 7.0F, 9.0F, 49.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Tail2, 0.09599310885968812F, 0.0F, 0.0F);
		this.Jaw2 = new ModelRenderer(this, 2, 40);
		this.Jaw2.setRotationPoint(0.0F, 0.0F, -12.0F);
		this.Jaw2.addBox(-3.5F, 0.0F, -8.0F, 7.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.RightThigh = new ModelRenderer(this, 145, 80);
		this.RightThigh.setRotationPoint(-4.0F, -14.0F, 4.0F);
		this.RightThigh.addBox(-7.0F, -3.0F, -5.0F, 8.0F, 22.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(RightThigh, -0.04991641477611458F, 0.0F, 0.0F);
		this.RightLeg = new ModelRenderer(this, 145, 116);
		this.RightLeg.setRotationPoint(-3.0F, 19.0F, 0.0F);
		this.RightLeg.addBox(-3.0F, -2.0F, -3.0F, 6.0F, 19.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(RightLeg, 0.05000000058364023F, 0.0F, 0.0F);
		this.throat = new ModelRenderer(this, 97, 21);
		this.throat.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.throat.addBox(-4.02F, 0.5F, -4.0F, 8.04F, 9.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(throat, -1.6533504590037724F, 0.0F, 0.0F);
		this.beak = new ModelRenderer(this, 2, 24);
		this.beak.setRotationPoint(0.0F, 2.0F, -12.0F);
		this.beak.addBox(-3.5F, -2.0F, -8.0F, 7.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Tail1 = new ModelRenderer(this, 1, 81);
		this.Tail1.setRotationPoint(0.0F, -5.0F, 15.0F);
		this.Tail1.addBox(-5.0F, -3.0F, -4.0F, 10.0F, 14.0F, 43.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Tail1, -0.15707963267948966F, 0.0F, 0.0F);
		this.Jaw = new ModelRenderer(this, 90, 2);
		this.Jaw.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.Jaw.addBox(-4.5F, 0.0F, -12.0F, 9.0F, 2.0F, 12.0F, 0.0F, 0.0F, 0.0F);
		this.LeftLeg = new ModelRenderer(this, 145, 116);
		this.LeftLeg.mirror = true;
		this.LeftLeg.setRotationPoint(3.0F, 19.0F, 0.0F);
		this.LeftLeg.addBox(-3.0F, -2.0F, -3.0F, 6.0F, 19.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(LeftLeg, 0.04991641477611458F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 152, 18);
		this.Neck.setRotationPoint(0.0F, 2.0F, -37.0F);
		this.Neck.addBox(-4.0F, -6.5F, -31.0F, 8.0F, 11.0F, 38.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Neck, -0.6108652381980153F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, -16.0F, 2.0F);
		this.Body.addBox(-8.5F, -10.0F, -37.0F, 17.0F, 25.0F, 55.0F, 0.0F, 0.0F, 0.0F);
		this.LeftFoot = new ModelRenderer(this, 178, 122);
		this.LeftFoot.setRotationPoint(0.0F, 16.0F, 4.0F);
		this.LeftFoot.addBox(-3.5F, -1.0F, -15.5F, 7.0F, 4.0F, 18.0F, 0.0F, 0.0F, 0.0F);
		this.LeftThigh = new ModelRenderer(this, 145, 80);
		this.LeftThigh.mirror = true;
		this.LeftThigh.setRotationPoint(4.0F, -14.0F, 4.0F);
		this.LeftThigh.addBox(-1.0F, -3.0F, -5.0F, 8.0F, 22.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(LeftThigh, -0.04991641477611458F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 1, 2);
		this.Head.setRotationPoint(0.0F, -5.07F, -29.62F);
		this.Head.addBox(-4.5F, -2.0F, -12.0F, 9.0F, 6.0F, 12.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Head, 0.767944870877505F, 0.0F, 0.0F);
		this.RightFoot = new ModelRenderer(this, 178, 122);
		this.RightFoot.mirror = true;
		this.RightFoot.setRotationPoint(0.0F, 16.0F, 4.0F);
		this.RightFoot.addBox(-3.5F, -1.0F, -15.5F, 7.0F, 4.0F, 18.0F, 0.0F, 0.0F, 0.0F);
		this.LeftArm = new ModelRenderer(this, 113, 86);
		this.LeftArm.setRotationPoint(6.0F, 8.0F, -26.0F);
		this.LeftArm.addBox(-1.0F, -2.0F, -3.0F, 6.0F, 22.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(LeftArm, 0.09599310885968812F, 0.0F, 0.0F);
		this.RightArm = new ModelRenderer(this, 113, 86);
		this.RightArm.mirror = true;
		this.RightArm.setRotationPoint(-6.0F, 8.0F, -26.0F);
		this.RightArm.addBox(-5.0F, -2.0F, -3.0F, 6.0F, 22.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(RightArm, 0.09599310885968812F, 0.0F, 0.0F);
		this.Tail1.addChild(this.Tail2);
		this.Jaw.addChild(this.Jaw2);
		this.RightThigh.addChild(this.RightLeg);
		this.Jaw.addChild(this.throat);
		this.Head.addChild(this.beak);
		this.Body.addChild(this.Tail1);
		this.Head.addChild(this.Jaw);
		this.LeftThigh.addChild(this.LeftLeg);
		this.Body.addChild(this.Neck);
		this.LeftLeg.addChild(this.LeftFoot);
		this.Neck.addChild(this.Head);
		this.RightLeg.addChild(this.RightFoot);
		this.Body.addChild(this.LeftArm);
		this.Body.addChild(this.RightArm);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.RightThigh, this.Body, this.LeftThigh).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(SillosuchusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.8f;
		float degree = 1.0f;
		this.LeftThigh.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount - 0.05F;
		this.LeftLeg.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.05F;
		this.LeftFoot.rotateAngleX = MathHelper.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
		this.RightThigh.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount - 0.05F;
		this.RightLeg.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + 0.05F;
		this.RightFoot.rotateAngleX = MathHelper.cos(2.0F + limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
		this.Tail1.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.2F * limbSwingAmount);
		this.Tail2.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (Tail2.rotateAngleY = MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.25F * limbSwingAmount);
		this.Tail1.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) +(MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.15F);
		this.Tail2.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.1F);
		this.Body.rotateAngleX = (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount);
		this.Neck.rotateAngleX = (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.65F) + (headPitch * ((float)Math.PI / 180F));
		this.Head.rotateAngleX = (-Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)) + 0.65F) + (MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.55F);
		this.Jaw.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
		this.LeftArm.rotateAngleZ = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
		this.RightArm.rotateAngleZ = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
		this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
		this.RightArm.rotateAngleX = MathHelper.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
		this.Neck.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
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
