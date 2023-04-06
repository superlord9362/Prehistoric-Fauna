package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.SarahsaurusEntity;

/**
 * SarahsaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SarahsaurusModel extends EntityModel<SarahsaurusEntity> {
	public ModelRenderer Body;
	public ModelRenderer RArm;
	public ModelRenderer Tail1;
	public ModelRenderer LLeg1;
	public ModelRenderer Neck1;
	public ModelRenderer LArm;
	public ModelRenderer RLeg1;
	public ModelRenderer Tail2;
	public ModelRenderer LLeg2;
	public ModelRenderer LFoot;
	public ModelRenderer Neck2;
	public ModelRenderer Head;
	public ModelRenderer Collar;
	public ModelRenderer Feathers;
	public ModelRenderer RLeg2;
	public ModelRenderer RFoot;

	public SarahsaurusModel() {
		this.textureWidth = 64;
		this.textureHeight = 80;
		this.Collar = new ModelRenderer(this, 32, 67);
		this.Collar.setRotationPoint(-2.0F, -2.0F, -0.5F);
		this.Collar.addBox(0.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F, 0.1F, 0.0F, 0.0F);
		this.Tail1 = new ModelRenderer(this, 0, 27);
		this.Tail1.setRotationPoint(0.0F, 0.01F, 4.0F);
		this.Tail1.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 14.0F, 0.0F, 0.0F, 0.0F);
		this.RLeg1 = new ModelRenderer(this, 0, 48);
		this.RLeg1.setRotationPoint(-3.0F, 4.0F, 1.0F);
		this.RLeg1.addBox(-3.0F, -2.0F, -3.0F, 4.0F, 10.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 0, 10);
		this.Head.setRotationPoint(0.0F, -7.0F, 0.0F);
		this.Head.addBox(-2.0F, 0.0F, -5.0F, 4.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 6.0F, 3.0F);
		this.Body.addBox(-4.0F, 0.0F, -12.0F, 8.0F, 9.0F, 18.0F, 0.0F, 0.0F, 0.0F);
		this.LArm = new ModelRenderer(this, 52, 13);
		this.LArm.mirror = true;
		this.LArm.setRotationPoint(3.0F, 6.0F, -8.5F);
		this.LArm.addBox(0.0F, -1.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.RLeg2 = new ModelRenderer(this, 8, 31);
		this.RLeg2.mirror = true;
		this.RLeg2.setRotationPoint(-0.5F, 8.0F, 4.0F);
		this.RLeg2.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.RArm = new ModelRenderer(this, 22, 52);
		this.RArm.setRotationPoint(-3.0F, 6.0F, -8.5F);
		this.RArm.addBox(-2.0F, -1.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.LLeg1 = new ModelRenderer(this, 40, 27);
		this.LLeg1.setRotationPoint(3.0F, 4.0F, 1.0F);
		this.LLeg1.addBox(-1.0F, -2.0F, -3.0F, 4.0F, 10.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Neck2 = new ModelRenderer(this, 0, 0);
		this.Neck2.setRotationPoint(0.0F, 0.0F, -8.0F);
		this.Neck2.addBox(-2.0F, -7.0F, 0.0F, 4.0F, 7.0F, 3.0F, -0.01F, 0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 18, 30);
		this.Tail2.setRotationPoint(0.0F, 1.0F, 13.0F);
		this.Tail2.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 18.0F, 0.0F, 0.0F, 0.0F);
		this.LFoot = new ModelRenderer(this, 0, 27);
		this.LFoot.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.LFoot.addBox(-1.4F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.LLeg2 = new ModelRenderer(this, 8, 31);
		this.LLeg2.setRotationPoint(0.5F, 8.0F, 4.0F);
		this.LLeg2.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.Neck1 = new ModelRenderer(this, 34, 0);
		this.Neck1.setRotationPoint(0.0F, 1.0F, -11.0F);
		this.Neck1.addBox(-2.0F, 0.0F, -8.0F, 4.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.Feathers = new ModelRenderer(this, 37, 48);
		this.Feathers.mirror = true;
		this.Feathers.setRotationPoint(0.0F, -5.0F, -1.0F);
		this.Feathers.addBox(0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.RFoot = new ModelRenderer(this, 0, 27);
		this.RFoot.mirror = true;
		this.RFoot.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.RFoot.addBox(-1.4F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Neck2.addChild(this.Collar);
		this.Body.addChild(this.Tail1);
		this.Body.addChild(this.RLeg1);
		this.Neck2.addChild(this.Head);
		this.Body.addChild(this.LArm);
		this.RLeg1.addChild(this.RLeg2);
		this.Body.addChild(this.RArm);
		this.Body.addChild(this.LLeg1);
		this.Neck1.addChild(this.Neck2);
		this.Tail1.addChild(this.Tail2);
		this.LLeg2.addChild(this.LFoot);
		this.LLeg1.addChild(this.LLeg2);
		this.Body.addChild(this.Neck1);
		this.Head.addChild(this.Feathers);
		this.RLeg2.addChild(this.RFoot);
	}

	@Override
	public void setRotationAngles(SarahsaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress = entityIn.getMeleeProgress(partialTick);
		resetModel();
		if (entityIn.isAsleep()) {
			this.RArm.rotateAngleX = -0.23457224414434488F;
			this.RArm.rotateAngleZ = 0.8210028961170991F;
			this.Head.rotateAngleX = -1.8374826151943415F;
			this.LArm.rotateAngleX = -0.23457224414434488F;
			this.LArm.rotateAngleZ = -0.8210028961170991F;
			this.LFoot.rotateAngleX = 1.5707963267948966F;
			this.LLeg1.rotateAngleX = -1.0164797856562695F;
			this.LLeg1.rotateAngleY = -0.23457224414434488F;
			this.Tail1.rotateAngleX = -0.1563815016444822F;
			this.Tail1.rotateAngleY = 0.11728612207217244F;
			this.RLeg2.rotateAngleX = -0.5473352640780661F;
			this.RLeg2.rotateAngleY = 0.0781907508222411F;
			this.RLeg2.rotateAngleZ = 0.0781907508222411F;
			this.RLeg2.rotationPointX = -1.5F;
			this.LLeg2.rotateAngleX = -0.5473352640780661F;
			this.LLeg2.rotateAngleY = -0.0781907508222411F;
			this.LLeg2.rotateAngleZ = -0.0781907508222411F;
			this.LLeg2.rotationPointX = 1.5F;
			this.RLeg1.rotateAngleX = -1.0164797856562695F;
			this.RLeg1.rotateAngleY = 0.23457224414434488F;
			this.Tail2.rotateAngleX = 0.0781907508222411F;
			this.Tail2.rotateAngleY = 0.3909537457888271F;
			this.Neck1.rotateAngleX = 0.46914448828868976F;
			this.Neck1.rotateAngleY = -0.4300491170387584F;
			this.Neck2.rotateAngleX = 1.3683381601951652F;
			this.Neck2.rotationPointY = 3F;
			this.RFoot.rotateAngleX = 1.5707963267948966F;
			this.Body.rotationPointY = 15;
			this.Head.rotationPointZ = 3F;
			this.Head.rotationPointY = -6F;
			this.LLeg2.rotationPointZ = 0.8F;
			this.RLeg2.rotationPointZ = 0.8F;
			this.LArm.rotationPointY = 5.5F;
			this.RArm.rotationPointY = 5.5F;	
		} else {
			this.RLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Tail1.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tail2.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tail1.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.Tail2.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.Neck1.rotateAngleX = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(45F);
			this.LArm.rotateAngleZ = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
			this.RArm.rotateAngleZ = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
			this.Neck1.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			this.Head.rotateAngleX = attackProgress * (float) Math.toRadians(-15F);
			if (entityIn.isEating()) {
				this.Neck1.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.75F) + 1.2F;
			}
			if (entityIn.isInWater()) {
				this.Body.rotationPointY = 15;
				this.Body.rotateAngleX = -0.25F;
				this.Tail1.rotateAngleX = 0.125F;
				this.Tail2.rotateAngleX = 0.125F;
				this.Neck1.rotateAngleX = 0.25F;
				this.LLeg1.rotateAngleX = -0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RLeg1.rotateAngleX = 0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RArm.rotateAngleX = 0.25F;
				this.LArm.rotateAngleX = 0.25F;
				this.LLeg2.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RLeg2.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Tail1.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	public void resetModel() {
		this.RArm.rotateAngleX = 0;
		this.RArm.rotateAngleZ = 0;
		this.Head.rotateAngleX = 0;
		this.LArm.rotateAngleX = 0;
		this.LArm.rotateAngleZ = 0;
		this.LFoot.rotateAngleX = 0;
		this.LFoot.rotationPointY = 6.0F;
		this.LLeg1.rotateAngleX = 0;
		this.LLeg1.rotateAngleY = 0;
		this.Tail1.rotateAngleX = 0;
		this.Tail1.rotateAngleY = 0;
		this.RLeg2.rotateAngleX = 0;
		this.RLeg2.rotateAngleY = 0;
		this.RLeg2.rotateAngleZ = 0;
		this.LLeg2.rotateAngleX = 0;
		this.LLeg2.rotateAngleY = 0;
		this.LLeg2.rotateAngleZ = 0;
		this.RLeg2.rotationPointX = -0.5F;
		this.LLeg2.rotationPointX = 0.5F;
		this.RLeg1.rotateAngleX = 0;
		this.RLeg1.rotateAngleY = 0;
		this.Tail2.rotateAngleX = 0;
		this.Tail2.rotateAngleY = 0;
		this.Neck1.rotateAngleX = 0;
		this.Neck1.rotateAngleY = 0;
		this.Neck2.rotateAngleX = 0;
		this.Neck2.rotationPointY = 0;
		this.RFoot.rotateAngleX = 0;
		this.Body.rotationPointY = 6.0F;
		this.Head.rotationPointZ = 0.0F;
		this.Head.rotationPointY = -7.0F;
		this.LLeg2.rotationPointZ = 4.0F;
		this.RLeg2.rotationPointZ = 4.0F;
		this.LArm.rotationPointY = 6;
		this.RArm.rotationPointY = 6;	
		this.Body.rotateAngleX = 0;
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
