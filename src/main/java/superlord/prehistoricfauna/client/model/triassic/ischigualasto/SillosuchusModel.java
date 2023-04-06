package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SillosuchusEntity;

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
		float walkSpeed = 1.0f;
		float walkDegree = 0.5f;
		float idleSpeed = 1.0f;
		float idleDegree = 1.0f;
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress = entityIn.getMeleeProgress(partialTick);
		float leftOrRight = entityIn.getMeleeDirection() ? 1.0F : -1.0F;
		resetModel();
		if (entityIn.isAsleep()) {
			this.Tail2.rotateAngleX = 0.17802358037447025F;
			this.Tail2.rotateAngleY = -0.35185837453889574F;
			this.Tail2.rotateAngleZ = 1.7453292129831807E-4F;
			this.LeftArm.rotationPointX = 7.0F;
			this.LeftArm.rotationPointY = 14.0F;
			this.LeftArm.rotationPointZ = -24.0F;
			this.LeftArm.rotateAngleX = -1.3089969389957472F;
			this.LeftArm.rotateAngleY = 0.03490658503988659F;
			this.LeftArm.rotateAngleZ = -1.2217304763960306F;
			this.RightThigh.rotationPointX = -5.0F;
			this.RightThigh.rotationPointY = 13.0F;
			this.RightThigh.rotationPointZ = 12.0F;
			this.RightThigh.rotateAngleX = -2.2689280275926285F;
			this.RightThigh.rotateAngleY = 0.27366763203903305F;
			this.LeftLeg.rotationPointY = 15.0F;
			this.LeftLeg.rotationPointZ = 6.3F;
			this.LeftLeg.rotateAngleX = 2.356194490192345F;
			this.RightLeg.rotationPointY = 15.0F;
			this.RightLeg.rotationPointZ = 7.0F;
			this.RightLeg.rotateAngleX = 2.3038346126325147F;
			this.Tail1.rotateAngleX = -0.22689280275926282F;
			this.Tail1.rotateAngleY = -0.3490658503988659F;
			this.Tail1.rotateAngleZ = 0.03490658503988659F;
			this.LeftFoot.rotationPointY = 14.0F;
			this.LeftFoot.rotationPointZ = -1.0F;
			this.LeftFoot.rotateAngleX = -0.12217304763960307F;
			this.LeftThigh.rotationPointX = 5.9F;
			this.LeftThigh.rotationPointY = 11.2F;
			this.LeftThigh.rotationPointZ = 12.0F;
			this.LeftThigh.rotateAngleX = -2.234021442552742F;
			this.LeftThigh.rotateAngleY = -0.3127630032889644F;
			this.RightArm.rotationPointX = -10.0F;
			this.RightArm.rotationPointY = 12.0F;
			this.RightArm.rotationPointZ = -24.0F;
			this.RightArm.rotateAngleX = -1.2217304763960306F;
			this.RightArm.rotateAngleY = 0.07749261978723364F;
			this.RightArm.rotateAngleZ = 1.0821041362364843F;
			this.Body.rotationPointY = 9.0F;
			this.Body.rotateAngleZ = -0.11728612207217244F;
			this.RightFoot.rotationPointY = 12.2F;
			this.RightFoot.rotationPointZ = -1.0F;
			this.RightFoot.rotateAngleX = -0.03490658503988659F;
			this.Neck.rotationPointX = -2.0F;
			this.Neck.rotationPointY = 5.0F;
			this.Neck.rotationPointZ = -42.0F;
			this.Neck.rotateAngleX = 0.1319468904520859F;
			this.Neck.rotateAngleY = 0.5473352640780661F;
			this.Head.rotationPointY = -3.07F;
			this.Head.rotateAngleX = -0.09005898673974631F;
			this.Head.rotateAngleY = 0.35185837453889574F;
			this.Head.rotateAngleZ = 0.0781907508222411F;
		} else {
			this.Body.rotateAngleX = 0;
			this.Neck.rotateAngleX = (MathHelper.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount - 0.6F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float)Math.toRadians(30F);
			this.Body.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)) + MathHelper.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
			this.Tail1.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5)) + MathHelper.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
			this.Tail2.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5)) + MathHelper.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.15F * limbSwingAmount + 0.05F;
			this.Tail1.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5) + MathHelper.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
			this.Tail2.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5) + MathHelper.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 1.0F * limbSwingAmount;
			this.Head.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount + 0.8F + attackProgress * (float)Math.toRadians(-40F);
			this.Jaw.rotateAngleX = attackProgress * (float) Math.toRadians(25F);
			this.Neck.rotateAngleZ = attackProgress * leftOrRight * (float) Math.toRadians(15F);
			this.Head.rotateAngleZ = attackProgress * leftOrRight * (float) Math.toRadians(15F);
			this.LeftArm.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3)) + MathHelper.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
			this.RightArm.rotateAngleX = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3)) + MathHelper.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
			this.LeftThigh.rotateAngleX = MathHelper.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount - 0.05F + MathHelper.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.05F;
			this.LeftLeg.rotateAngleX = MathHelper.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + 0.05F + MathHelper.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.05F;
			this.LeftFoot.rotateAngleX = MathHelper.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.3F * limbSwingAmount + MathHelper.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount;
			this.RightThigh.rotateAngleX = MathHelper.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount - 0.05F + MathHelper.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.05F;
			this.RightLeg.rotateAngleX = MathHelper.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + 0.05F + MathHelper.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.05F;
			this.RightFoot.rotateAngleX = MathHelper.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.3F * limbSwingAmount + MathHelper.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.3F * limbSwingAmount;
			this.Neck.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
			if (entityIn.isEating()) {
				this.Neck.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.25F) + 0.05F;
				this.Body.rotateAngleX = 0.2F;
				this.Jaw.rotateAngleX = Math.abs(MathHelper.sin(0.15F * ageInTicks) * 0.25F);
			}
			if (entityIn.isInWater()) {
				this.LeftThigh.rotationPointY = 20;
				this.RightThigh.rotationPointY = 20;
				this.Body.rotationPointY = 20;
				this.Body.rotateAngleX = -0.25F;
				this.Tail1.rotateAngleX = 0.125F;
				this.Tail2.rotateAngleX = 0.125F;
				this.LeftThigh.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RightThigh.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LeftFoot.rotateAngleX = 0.5F - (0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F));
				this.RightFoot.rotateAngleX = 0.5F + (0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F));
				this.RightArm.rotateAngleX = 0.25F;
				this.LeftArm.rotateAngleX = 0.25F;
				this.Tail1.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.Tail2.rotateAngleX = 0.09599310885968812F;
		this.Tail2.rotateAngleY = 0;
		this.Tail2.rotateAngleZ = 0;
		this.LeftArm.rotationPointX = 6.0F;
		this.LeftArm.rotationPointY = 8.0F;
		this.LeftArm.rotationPointZ = -26.0F;
		this.LeftArm.rotateAngleX = 0.09599310885968812F;
		this.LeftArm.rotateAngleY = 0;
		this.LeftArm.rotateAngleZ = 0;
		this.RightThigh.rotationPointX = -4.0F;
		this.RightThigh.rotationPointY = -14.0F;
		this.RightThigh.rotationPointZ = 4.0F;
		this.RightThigh.rotateAngleX = -0.04991641477611458F;
		this.RightThigh.rotateAngleY = 0;
		this.LeftLeg.rotationPointY = 19.0F;
		this.LeftLeg.rotationPointZ = 0.0F;
		this.LeftLeg.rotateAngleX = 0.04991641477611458F;
		this.RightLeg.rotationPointY = 19.0F;
		this.RightLeg.rotationPointZ = 0.0F;
		this.RightLeg.rotateAngleX = 0.05000000058364023F;
		this.Tail1.rotateAngleX = -0.15707963267948966F;
		this.Tail1.rotateAngleY = 0;
		this.Tail1.rotateAngleZ = 0;
		this.LeftFoot.rotationPointY = 16.0F;
		this.LeftFoot.rotationPointZ = 4.0F;
		this.LeftFoot.rotateAngleX = 0;
		this.LeftThigh.rotationPointX = 4.0F;
		this.LeftThigh.rotationPointY = -14.0F;
		this.LeftThigh.rotationPointZ = 4.0F;
		this.LeftThigh.rotateAngleX = -0.04991641477611458F;
		this.LeftThigh.rotateAngleY = 0;
		this.LeftThigh.rotateAngleZ = 0;
		this.RightArm.rotationPointX = -6.0F;
		this.RightArm.rotationPointY = 8.0F;
		this.RightArm.rotationPointZ = -26.0F;
		this.RightArm.rotateAngleX = 0.09599310885968812F;
		this.RightArm.rotateAngleY = 0;
		this.RightArm.rotateAngleZ = 0;
		this.Body.rotationPointY = -16.0F;
		this.Body.rotateAngleX = 0;
		this.Body.rotateAngleZ = 0;
		this.RightFoot.rotationPointY = 16.0F;
		this.RightFoot.rotationPointZ = 4.0F;
		this.RightFoot.rotateAngleX = 0;
		this.Neck.rotationPointX = 0.0F;
		this.Neck.rotationPointY = 2.0F;
		this.Neck.rotationPointZ = -37.0F;
		this.Neck.rotateAngleX = -0.6108652381980153F;
		this.Neck.rotateAngleY = 0;
		this.Neck.rotateAngleZ = 0;
		this.Head.rotationPointY = -5.07F;
		this.Head.rotateAngleX = 0.767944870877505F;
		this.Head.rotateAngleY = 0;
		this.Head.rotateAngleZ = 0;
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
