package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SaurosuchusEntity;

/**
 * Saurosuchus - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SaurosuchusModel extends EntityModel<SaurosuchusEntity> {
	public ModelRenderer Body;
	public ModelRenderer Thigh_1;
	public ModelRenderer Thigh;
	public ModelRenderer Arm;
	public ModelRenderer Arm_1;
	public ModelRenderer Tail;
	public ModelRenderer Osteos;
	public ModelRenderer Neck;
	public ModelRenderer Tail2;
	public ModelRenderer osteos3;
	public ModelRenderer Osteos2;
	public ModelRenderer Head;
	public ModelRenderer Snout;
	public ModelRenderer Jaw;
	public ModelRenderer SnoutTeeth;
	public ModelRenderer Cheek;
	public ModelRenderer JawSnout;
	public ModelRenderer JawTeeth;
	public ModelRenderer Calf_1;
	public ModelRenderer Foot_1;
	public ModelRenderer Calf;
	public ModelRenderer Foot;

	public SaurosuchusModel() {
		this.textureWidth = 200;
		this.textureHeight = 200;
		this.Thigh = new ModelRenderer(this, 58, 0);
		this.Thigh.setRotationPoint(4.0F, 7.0F, 12.5F);
		this.Thigh.addBox(-2.0F, -2.0F, -3.5F, 5.0F, 12.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Arm_1 = new ModelRenderer(this, 180, 19);
		this.Arm_1.mirror = true;
		this.Arm_1.setRotationPoint(-2.5F, 9.0F, -10.5F);
		this.Arm_1.addBox(-4.0F, -2.0F, -2.5F, 4.0F, 17.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.JawTeeth = new ModelRenderer(this, 141, 13);
		this.JawTeeth.setRotationPoint(0.0F, -1.0F, 0.1F);
		this.JawTeeth.addBox(-1.5F, -1.0F, -7.0F, 3.0F, 1.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 8.0F, 6.0F);
		this.Body.addBox(-6.0F, -8.0F, -21.0F, 12.0F, 13.0F, 35.0F, 0.0F, 0.0F, 0.0F);
		this.Calf = new ModelRenderer(this, 18, 0);
		this.Calf.setRotationPoint(0.5F, 10.0F, 0.5F);
		this.Calf.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Foot_1 = new ModelRenderer(this, 98, 20);
		this.Foot_1.setRotationPoint(0.0F, 5.0F, 0.0F);
		this.Foot_1.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Tail = new ModelRenderer(this, 101, 23);
		this.Tail.setRotationPoint(0.0F, -4.0F, 14.0F);
		this.Tail.addBox(-4.0F, -3.0F, 0.0F, 8.0F, 9.0F, 21.0F, 0.0F, 0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 0, 48);
		this.Tail2.setRotationPoint(0.0F, 1.0F, 21.0F);
		this.Tail2.addBox(-2.0F, -3.0F, 0.0F, 4.0F, 5.0F, 40.0F, 0.0F, 0.0F, 0.0F);
		this.Foot = new ModelRenderer(this, 83, 0);
		this.Foot.setRotationPoint(0.0F, 5.0F, 0.0F);
		this.Foot.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Snout = new ModelRenderer(this, 163, 0);
		this.Snout.setRotationPoint(0.0F, 0.0F, -8.0F);
		this.Snout.addBox(-2.0F, -3.0F, -8.0F, 4.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Thigh_1 = new ModelRenderer(this, 11, 15);
		this.Thigh_1.setRotationPoint(-4.0F, 7.0F, 12.5F);
		this.Thigh_1.addBox(-3.0F, -2.0F, -3.5F, 5.0F, 12.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 133, 0);
		this.Head.setRotationPoint(0.0F, 0.0F, -10.0F);
		this.Head.addBox(-3.5F, -4.0F, -8.0F, 7.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.SnoutTeeth = new ModelRenderer(this, 180, 6);
		this.SnoutTeeth.setRotationPoint(0.0F, 1.0F, 0.1F);
		this.SnoutTeeth.addBox(-1.5F, -1.0F, -8.0F, 3.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(SnoutTeeth, 0.13962634015954636F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 97, 0);
		this.Neck.setRotationPoint(0.0F, -3.0F, -20.0F);
		this.Neck.addBox(-4.0F, -4.0F, -10.0F, 8.0F, 10.0F, 10.0F, 0.0F, 0.0F, 0.0F);
		this.Osteos = new ModelRenderer(this, 0, 65);
		this.Osteos.setRotationPoint(0.0F, -9.0F, -21.0F);
		this.Osteos.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 35.0F, 0.0F, 0.0F, 0.0F);
		this.Arm = new ModelRenderer(this, 0, 0);
		this.Arm.setRotationPoint(3.0F, 9.0F, -10.5F);
		this.Arm.addBox(-0.5F, -2.0F, -2.5F, 4.0F, 17.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.Osteos2 = new ModelRenderer(this, 0, 101);
		this.Osteos2.setRotationPoint(0.0F, -5.0F, -10.0F);
		this.Osteos2.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.Jaw = new ModelRenderer(this, 75, 12);
		this.Jaw.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.Jaw.addBox(-3.5F, 0.0F, -8.0F, 7.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Calf_1 = new ModelRenderer(this, 58, 19);
		this.Calf_1.setRotationPoint(-0.5F, 10.0F, 0.5F);
		this.Calf_1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.osteos3 = new ModelRenderer(this, 0, 84);
		this.osteos3.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.osteos3.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 21.0F, 0.0F, 0.0F, 0.0F);
		this.JawSnout = new ModelRenderer(this, 125, 13);
		this.JawSnout.setRotationPoint(0.0F, 2.0F, -9.0F);
		this.JawSnout.addBox(-2.0F, -1.0F, -7.0F, 4.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Cheek = new ModelRenderer(this, 161, 13);
		this.Cheek.setRotationPoint(0.0F, -1.85F, 0.0F);
		this.Cheek.addBox(-2.5F, -2.0F, -7.01F, 5.0F, 4.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.JawSnout.addChild(this.JawTeeth);
		this.Thigh.addChild(this.Calf);
		this.Calf_1.addChild(this.Foot_1);
		this.Body.addChild(this.Tail);
		this.Tail.addChild(this.Tail2);
		this.Calf.addChild(this.Foot);
		this.Head.addChild(this.Snout);
		this.Neck.addChild(this.Head);
		this.Snout.addChild(this.SnoutTeeth);
		this.Body.addChild(this.Neck);
		this.Body.addChild(this.Osteos);
		this.Neck.addChild(this.Osteos2);
		this.Head.addChild(this.Jaw);
		this.Thigh_1.addChild(this.Calf_1);
		this.Tail.addChild(this.osteos3);
		this.Jaw.addChild(this.JawSnout);
		this.Jaw.addChild(this.Cheek);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Thigh, this.Arm_1, this.Body, this.Thigh_1, this.Arm).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(SaurosuchusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress = entityIn.getMeleeProgress(partialTick);
		this.Jaw.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(25F);
		if (entityIn.getMotion().x !=  0 && entityIn.getMotion().y != 0 && entityIn.getMotion().z != 0) {
			this.Head.rotateAngleX = 0;
			this.Neck.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.08F * limbSwingAmount;
			this.Head.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount + 0.05F;
			this.Arm.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
			this.Arm_1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
			this.Thigh.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
			this.Calf.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
			this.Foot.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
			this.Thigh_1.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
			this.Calf_1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
			this.Foot_1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
			this.Tail.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1F;
			this.Tail.rotateAngleY = MathHelper.cos(-1.0F + limbSwing * speed * 0.15F) * degree * -0.15F * limbSwingAmount;
			this.Tail2.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.05F;
			this.Tail2.rotateAngleY = MathHelper.cos(-1.0F + limbSwing * speed * 0.15F) * degree * -0.15F * limbSwingAmount;
			this.Body.rotationPointY = MathHelper.cos(-1.0F + limbSwing * 0.3F) * 0.5F * limbSwingAmount + 8;
		} else {
			this.Arm.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
			this.Arm_1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
			this.Thigh.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
			this.Calf.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
			this.Foot.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
			this.Thigh_1.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
			this.Calf_1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
			this.Foot_1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
			this.Tail.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.15F) * degree * -0.15F * limbSwingAmount);
			this.Tail2.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.15F) * degree * -0.15F * limbSwingAmount);
			this.Tail.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1F);
			this.Tail2.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.15F) * degree * -0.15F * limbSwingAmount);
			this.Body.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
			this.Neck.rotateAngleX = (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.08F * limbSwingAmount);
			this.Head.rotateAngleX = (-Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount + 0.05F);
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
