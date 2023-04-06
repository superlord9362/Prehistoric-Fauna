package superlord.prehistoricfauna.client.model.jurassic.morrison;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CamarasaurusEntity;

/**
 * Camarasaurus - Weastian
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class CamarasaurusModel extends EntityModel<CamarasaurusEntity> {
	public ModelRenderer body;
	public ModelRenderer LeftHindLeg1;
	public ModelRenderer RightHindLeg1;
	public ModelRenderer Tail1;
	public ModelRenderer Neck1;
	public ModelRenderer LeftFrontLeg;
	public ModelRenderer RightFrontLeg;
	public ModelRenderer Tail2;
	public ModelRenderer Neck2;
	public ModelRenderer Head;
	public ModelRenderer Spikes;
	public ModelRenderer Snout;
	public ModelRenderer Head2;
	public ModelRenderer LeftThumb;
	public ModelRenderer RightThumb;
	public ModelRenderer LeftHindLeg2;
	public ModelRenderer LeftHindLeg3;
	public ModelRenderer RightHindLeg2;
	public ModelRenderer RightHindLeg3;

	public CamarasaurusModel() {
		this.textureWidth = 384;
		this.textureHeight = 384;
		this.Head = new ModelRenderer(this, 0, 0);
		this.Head.setRotationPoint(0.0F, -47.1F, -2.0F);
		this.Head.addBox(-7.0F, 0.0F, -15.0F, 14.0F, 17.0F, 15.0F, 0.0F, 0.0F, 0.0F);
		this.LeftHindLeg3 = new ModelRenderer(this, 0, 223);
		this.LeftHindLeg3.setRotationPoint(0.0F, 30.0F, 1.0F);
		this.LeftHindLeg3.addBox(-8.0F, 0.0F, -14.0F, 16.0F, 6.0F, 20.0F, 0.0F, 0.0F, 0.0F);
		this.Snout = new ModelRenderer(this, 0, 54);
		this.Snout.setRotationPoint(0.0F, 8.0F, -15.0F);
		this.Snout.addBox(-5.0F, 0.0F, -10.0F, 10.0F, 9.0F, 10.0F, 0.0F, 0.0F, 0.0F);
		this.LeftThumb = new ModelRenderer(this, 0, 221);
		this.LeftThumb.setRotationPoint(-7.5F, 49.0F, -4.5F);
		this.LeftThumb.addBox(-4.0F, -1.0F, -1.0F, 4.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.LeftHindLeg2 = new ModelRenderer(this, 81, 207);
		this.LeftHindLeg2.setRotationPoint(0.0F, 24.0F, 3.0F);
		this.LeftHindLeg2.addBox(-7.5F, 0.0F, -8.0F, 15.0F, 30.0F, 15.0F, 0.0F, 0.0F, 0.0F);
		this.RightHindLeg1 = new ModelRenderer(this, 64, 135);
		this.RightHindLeg1.mirror = true;
		this.RightHindLeg1.setRotationPoint(-20.0F, -36.0F, 26.0F);
		this.RightHindLeg1.addBox(-8.5F, -13.0F, -12.0F, 17.0F, 45.0F, 24.0F, 0.0F, 0.0F, 0.0F);
		this.Head2 = new ModelRenderer(this, 37, 39);
		this.Head2.setRotationPoint(1.0F, 8.0F, -15.0F);
		this.Head2.addBox(-5.0F, -8.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 213, 179);
		this.Tail2.setRotationPoint(0.0F, 0.0F, 64.0F);
		this.Tail2.addBox(-7.0F, -3.0F, -5.0F, 14.0F, 15.0F, 65.0F, 0.0F, 0.0F, 0.0F);
		this.body = new ModelRenderer(this, 0, 2);
		this.body.setRotationPoint(0.0F, -41.0F, 14.0F);
		this.body.addBox(-25.0F, -20.0F, -54.0F, 50.0F, 50.0F, 80.0F, 0.0F, 0.0F, 0.0F);
		this.Neck2 = new ModelRenderer(this, 104, 300);
		this.Neck2.setRotationPoint(0.0F, -45.0F, 0.0F);
		this.Neck2.addBox(-6.0F, -47.0F, -14.0F, 12.0F, 54.0F, 20.0F, 0.0F, 0.0F, 0.0F);
		this.RightHindLeg2 = new ModelRenderer(this, 81, 207);
		this.RightHindLeg2.setRotationPoint(0.0F, 24.0F, 3.0F);
		this.RightHindLeg2.addBox(-7.5F, 0.0F, -8.0F, 15.0F, 30.0F, 15.0F, 0.0F, 0.0F, 0.0F);
		this.Spikes = new ModelRenderer(this, 64, 0);
		this.Spikes.setRotationPoint(0.0F, -47.0F, 6.0F);
		this.Spikes.addBox(-1.0F, 0.0F, 0.0F, 1.0F, 20.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Neck1 = new ModelRenderer(this, 0, 300);
		this.Neck1.setRotationPoint(0.0F, 10.0F, -49.0F);
		this.Neck1.addBox(-9.0F, -45.0F, -19.0F, 18.0F, 53.0F, 28.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Neck1, 0.27314402127920984F, 0.0F, 0.0F);
		this.Tail1 = new ModelRenderer(this, 193, 72);
		this.Tail1.setRotationPoint(0.0F, -7.0F, 26.0F);
		this.Tail1.addBox(-12.0F, -7.0F, -7.0F, 24.0F, 25.0F, 71.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Tail1, -0.13665927909957545F, 0.0F, 0.0F);
		this.LeftHindLeg1 = new ModelRenderer(this, 64, 135);
		this.LeftHindLeg1.setRotationPoint(20.0F, -36.0F, 26.0F);
		this.LeftHindLeg1.addBox(-8.5F, -13.0F, -12.0F, 17.0F, 45.0F, 24.0F, 0.0F, 0.0F, 0.0F);
		this.RightFrontLeg = new ModelRenderer(this, 0, 139);
		this.RightFrontLeg.mirror = true;
		this.RightFrontLeg.setRotationPoint(-19.5F, 14.0F, -42.0F);
		this.RightFrontLeg.addBox(-7.5F, -10.0F, -7.5F, 15.0F, 61.0F, 15.0F, 0.0F, 0.0F, 0.0F);
		this.RightThumb = new ModelRenderer(this, 0, 221);
		this.RightThumb.mirror = true;
		this.RightThumb.setRotationPoint(7.5F, 49.0F, -4.5F);
		this.RightThumb.addBox(0.0F, -1.0F, -1.0F, 4.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.RightHindLeg3 = new ModelRenderer(this, 0, 223);
		this.RightHindLeg3.mirror = true;
		this.RightHindLeg3.setRotationPoint(0.0F, 30.0F, 1.0F);
		this.RightHindLeg3.addBox(-8.0F, 0.0F, -14.0F, 16.0F, 6.0F, 20.0F, 0.0F, 0.0F, 0.0F);
		this.LeftFrontLeg = new ModelRenderer(this, 0, 139);
		this.LeftFrontLeg.setRotationPoint(19.5F, 14.0F, -42.0F);
		this.LeftFrontLeg.addBox(-7.5F, -10.0F, -7.5F, 15.0F, 61.0F, 15.0F, 0.0F, 0.0F, 0.0F);
		this.Neck2.addChild(this.Head);
		this.LeftHindLeg2.addChild(this.LeftHindLeg3);
		this.Head.addChild(this.Snout);
		this.LeftFrontLeg.addChild(this.LeftThumb);
		this.LeftHindLeg1.addChild(this.LeftHindLeg2);
		this.Head.addChild(this.Head2);
		this.Tail1.addChild(this.Tail2);
		this.Neck1.addChild(this.Neck2);
		this.RightHindLeg1.addChild(this.RightHindLeg2);
		this.Neck2.addChild(this.Spikes);
		this.body.addChild(this.Neck1);
		this.body.addChild(this.Tail1);
		this.body.addChild(this.RightFrontLeg);
		this.RightFrontLeg.addChild(this.RightThumb);
		this.RightHindLeg2.addChild(this.RightHindLeg3);
		this.body.addChild(this.LeftFrontLeg);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.RightHindLeg1, this.body, this.LeftHindLeg1).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(CamarasaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress = entityIn.getMeleeProgress(partialTick);
		float speed = 1.0F;
		float degree = 1.0F;
		resetModel();
		if (entityIn.isAsleep()) {
			this.body.rotationPointY = -4.8F;
			this.body.rotateAngleY = -0.038920842652368684F;
			this.body.rotateAngleZ = -0.1563815016444822F;
			this.LeftFrontLeg.rotationPointX = 25.5F;
			this.LeftFrontLeg.rotationPointY = 17.0F;
			this.LeftFrontLeg.rotationPointZ = -43.0F;
			this.LeftFrontLeg.rotateAngleX = -1.1405726395466833F;
			this.LeftFrontLeg.rotateAngleY = -0.039269908169872414F;
			this.LeftFrontLeg.rotateAngleZ = 0.3909537457888271F;
			this.Tail1.rotationPointZ = 21;
			this.Tail1.rotateAngleX = -0.24260075936930908F;
			this.Tail1.rotateAngleY = 0.5864306020384839F;
			this.Tail1.rotateAngleZ = 0.3127630032889644F;
			this.RightFrontLeg.rotationPointX = -25.5F;
			this.RightFrontLeg.rotationPointY = 12;
			this.RightFrontLeg.rotationPointZ = -41;
			this.RightFrontLeg.rotateAngleX = -1.2189378856769737F;
			this.RightFrontLeg.rotateAngleY = -0.43039819087864056F;
			this.RightHindLeg3.rotationPointY = 26.2F;
			this.RightHindLeg3.rotationPointZ = -3.0F;
			this.RightHindLeg3.rotateAngleX = 0.3874631072585466F;
			this.RightHindLeg3.rotateAngleZ = -0.10471975511965977F;
			this.RightHindLeg2.rotateAngleX = 1.5707963267948966F;
			this.RightHindLeg2.rotationPointY = 24.02F;
			this.RightHindLeg2.rotationPointZ = 0;
			this.Neck2.rotateAngleX = 0.02775073568927633F;
			this.Neck2.rotateAngleY = -0.1563815016444822F;
			this.Neck2.rotateAngleZ = 1.2510520131558576F;
			this.LeftHindLeg3.rotateAngleX = 0.3490658503988659F;
			this.LeftHindLeg3.rotationPointY = 24.6F;
			this.LeftHindLeg3.rotationPointZ = -2F;
			this.LeftHindLeg2.rotationPointY = 24.02F;
			this.LeftHindLeg2.rotationPointZ = 4;
			this.LeftHindLeg2.rotateAngleX = 1.5707963267948966F;
			this.RightHindLeg1.rotationPointX = -24;
			this.RightHindLeg1.rotationPointY = 4;
			this.RightHindLeg1.rotationPointZ = 24;
			this.RightHindLeg1.rotateAngleX = -1.9198621771937625F;
			this.RightHindLeg1.rotateAngleY = 0.3839724354387525F;
			this.RightHindLeg1.rotateAngleZ = 0.10471975511965977F;
			this.LeftHindLeg1.rotationPointX = 24;
			this.LeftHindLeg1.rotationPointY = 0;
			this.LeftHindLeg1.rotateAngleX = -1.9198621771937625F;
			this.LeftHindLeg1.rotateAngleY = -0.5082398595386212F;
			this.Neck1.rotationPointX = -6.2F;
			this.Neck1.rotationPointY = -8F;
			this.Neck1.rotationPointZ = -52;
			this.Neck1.rotateAngleX = 0.9162978572970231F;
			this.Neck1.rotateAngleY = -1.3294172592861477F;
			this.Neck1.rotateAngleZ = 0.11728612207217244F;
			this.Tail2.rotateAngleX = 0.4518657326886875F;
			this.Tail2.rotateAngleY = 0.3909537457888271F;
			this.Tail2.rotateAngleZ = 0.19547687289441354F;
			this.Head.rotationPointX = 1;
			this.Head.rotationPointZ = 0;
			this.Head.rotateAngleX = -0.5269149104981519F;
			this.Head.rotateAngleY = 0.03909537541112055F;
			this.Head.rotateAngleZ = 0.2562143561638466F;
		} else {
			this.body.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
			this.body.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
			this.Tail1.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.05F * ageInTicks / 5))) + (MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.2F);
			this.Tail1.rotateAngleY = (-0.12F * MathHelper.sin(0.05F * ageInTicks / 5)) + (MathHelper.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
			this.Tail1.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
			this.Tail2.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.05F * ageInTicks / 5))) + (MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.1F);
			this.Tail2.rotateAngleY = (-0.12F * MathHelper.sin(0.05F * ageInTicks / 5)) + (MathHelper.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.5F * limbSwingAmount);
			this.Neck1.rotateAngleX = (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F) + (headPitch * ((float) Math.PI / 180F)) + (attackProgress * (float)Math.toRadians(50) - 25F);
			this.Neck1.rotateAngleY = (MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 180F));
			this.Neck2.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.05F;
			this.Neck2.rotateAngleY = MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount;
			this.Head.rotateAngleX = (-Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1F);
			this.LeftHindLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.3F) * 0.5F * limbSwingAmount;
			this.LeftHindLeg2.rotateAngleX = MathHelper.cos(limbSwing * 0.3F) * 0.2F * limbSwingAmount + 0.05F;
			this.LeftHindLeg3.rotateAngleX = MathHelper.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
			this.RightHindLeg1.rotateAngleX = MathHelper.cos(4.0F + limbSwing * 0.3F) * 0.5F * limbSwingAmount;
			this.RightHindLeg2.rotateAngleX = MathHelper.cos(4.0F + limbSwing * 0.3F) * 0.2F * limbSwingAmount + 0.05F;
			this.RightHindLeg3.rotateAngleX = MathHelper.cos(5.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
			this.LeftFrontLeg.rotateAngleX = (MathHelper.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(40));
			this.RightFrontLeg.rotateAngleX = (MathHelper.cos(5.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(60));
			this.body.rotateAngleX = attackProgress * (float)Math.toRadians(-50);
			if (entityIn.isEating()) {
				this.Neck1.rotateAngleX = (Math.abs(MathHelper.sin(0.02F * ageInTicks) * 0.5F) + 0.5F) + ((Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F));
				this.Neck2.rotateAngleX = (Math.abs(MathHelper.sin(0.02F * ageInTicks) * 0.25F) + 0.5F) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.05F);
			}
			if (entityIn.isInWater()) {
				this.body.rotationPointY = 8;
				this.body.rotateAngleX = -0.25F;
				this.Tail1.rotateAngleX = 0.125F;
				this.Tail2.rotateAngleX = 0.125F;
				this.LeftHindLeg1.rotationPointY = 14;
				this.RightHindLeg1.rotationPointY = 14;
				this.LeftHindLeg1.rotateAngleX = -0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RightHindLeg1.rotateAngleX = 0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RightFrontLeg.rotateAngleX = -0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LeftFrontLeg.rotateAngleX = 0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LeftHindLeg2.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RightHindLeg2.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LeftHindLeg3.rotateAngleX = 0.5F - (0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F));
				this.RightHindLeg3.rotateAngleX = 0.5F + (0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F));
				this.Neck1.rotateAngleX = 0.5F;
				this.Tail1.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.body.rotationPointY =  -41.0F;
		this.body.rotateAngleY = 0;
		this.body.rotateAngleZ = 0;
		this.LeftFrontLeg.rotationPointX = 19.5F;
		this.LeftFrontLeg.rotationPointY = 14.0F;
		this.LeftFrontLeg.rotationPointZ = -42.0F;
		this.LeftFrontLeg.rotateAngleX = 0;
		this.LeftFrontLeg.rotateAngleY = 0;
		this.LeftFrontLeg.rotateAngleZ = 0;
		this.Tail1.rotationPointZ = 26;
		this.Tail1.rotateAngleX = 0;
		this.Tail1.rotateAngleY = 0;
		this.Tail1.rotateAngleZ = 0;
		this.RightFrontLeg.rotationPointX = -19.5F;
		this.RightFrontLeg.rotationPointY = 14F;
		this.RightFrontLeg.rotationPointZ = -42F;
		this.RightFrontLeg.rotateAngleX = 0;
		this.RightFrontLeg.rotateAngleY = 0;
		this.RightHindLeg3.rotationPointY = 30;
		this.RightHindLeg3.rotationPointZ = 1;
		this.RightHindLeg3.rotateAngleX = 0;
		this.RightHindLeg3.rotateAngleZ = 0;
		this.RightHindLeg2.rotationPointY = 24.0F;
		this.RightHindLeg2.rotationPointZ = 3;
		this.RightHindLeg2.rotateAngleX = 0;
		this.RightHindLeg2.rotateAngleY = 0;
		this.RightHindLeg2.rotateAngleZ = 0;
		this.Neck2.rotateAngleX = 0;
		this.Neck2.rotateAngleY = 0;
		this.Neck2.rotateAngleZ = 0;
		this.LeftHindLeg3.rotateAngleX = 0;
		this.LeftHindLeg3.rotationPointY = 30;
		this.LeftHindLeg3.rotationPointZ = 1;
		this.LeftHindLeg2.rotationPointY = 24;
		this.LeftHindLeg2.rotationPointZ = 3;
		this.LeftHindLeg2.rotateAngleX = 0;
		this.RightHindLeg1.rotationPointX = -20;
		this.RightHindLeg1.rotationPointY = -36;
		this.RightHindLeg1.rotationPointZ = 26;
		this.RightHindLeg1.rotateAngleX = 0;
		this.RightHindLeg1.rotateAngleY = 0;
		this.RightHindLeg1.rotateAngleZ = 0;
		this.LeftHindLeg1.rotationPointX = 20;
		this.LeftHindLeg1.rotationPointY = -36;
		this.LeftHindLeg1.rotateAngleX = 0;
		this.LeftHindLeg1.rotateAngleY = 0;
		this.Neck1.rotationPointX = 0;
		this.Neck1.rotationPointY = 10;
		this.Neck1.rotationPointZ = -49;
		this.Neck1.rotateAngleX = 0.27314402127920984F;
		this.Neck1.rotateAngleY = 0;
		this.Neck1.rotateAngleZ = 0;
		this.Tail2.rotateAngleX = 0;
		this.Tail2.rotateAngleY = 0;
		this.Tail2.rotateAngleZ = 0;
		this.Head.rotationPointX = 0;
		this.Head.rotationPointZ = -2;
		this.Head.rotateAngleX = 0;
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
