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
	public ModelRenderer LeftFrontLeg;
	public ModelRenderer RightFrontLeg;
	public ModelRenderer LeftHindLeg1;
	public ModelRenderer RightHindLeg1;
	public ModelRenderer Tail1;
	public ModelRenderer Neck1;
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
	public ModelRenderer NeckAngle;

	public CamarasaurusModel() {
		this.textureWidth = 384;
		this.textureHeight = 384;
		this.Head = new ModelRenderer(this, 0, 0);
		this.Head.setRotationPoint(0.0F, -47.1F, -2.0F);
		this.Head.addBox(-7.0F, 0.0F, -15.0F, 14.0F, 17.0F, 15.0F, 0.0F, 0.0F, 0.0F);
		this.RightThumb = new ModelRenderer(this, 0, 221);
		this.RightThumb.mirror = true;
		this.RightThumb.setRotationPoint(7.5F, 49.0F, -4.5F);
		this.RightThumb.addBox(0.0F, -1.0F, -1.0F, 4.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 213, 179);
		this.Tail2.setRotationPoint(0.0F, 0.0F, 64.0F);
		this.Tail2.addBox(-7.0F, -3.0F, -5.0F, 14.0F, 15.0F, 65.0F, 0.0F, 0.0F, 0.0F);
		this.LeftHindLeg2 = new ModelRenderer(this, 81, 207);
		this.LeftHindLeg2.setRotationPoint(0.0F, 24.0F, 3.0F);
		this.LeftHindLeg2.addBox(-7.5F, 0.0F, -8.0F, 15.0F, 30.0F, 15.0F, 0.0F, 0.0F, 0.0F);
		this.Neck1 = new ModelRenderer(this, 0, 300);
		this.Neck1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Neck1.addBox(-9.0F, -45.0F, -19.0F, 18.0F, 53.0F, 28.0F, 0.0F, 0.0F, 0.0F);
		this.RightHindLeg2 = new ModelRenderer(this, 81, 207);
		this.RightHindLeg2.setRotationPoint(0.0F, 24.0F, 3.0F);
		this.RightHindLeg2.addBox(-7.5F, 0.0F, -8.0F, 15.0F, 30.0F, 15.0F, 0.0F, 0.0F, 0.0F);
		this.RightHindLeg3 = new ModelRenderer(this, 0, 223);
		this.RightHindLeg3.mirror = true;
		this.RightHindLeg3.setRotationPoint(0.0F, 30.0F, 1.0F);
		this.RightHindLeg3.addBox(-8.0F, 0.0F, -14.0F, 16.0F, 6.0F, 20.0F, 0.0F, 0.0F, 0.0F);
		this.LeftFrontLeg = new ModelRenderer(this, 0, 139);
		this.LeftFrontLeg.setRotationPoint(19.5F, -27.0F, -28.0F);
		this.LeftFrontLeg.addBox(-7.5F, -10.0F, -7.5F, 15.0F, 61.0F, 15.0F, 0.0F, 0.0F, 0.0F);
		this.LeftHindLeg3 = new ModelRenderer(this, 0, 223);
		this.LeftHindLeg3.setRotationPoint(0.0F, 30.0F, 1.0F);
		this.LeftHindLeg3.addBox(-8.0F, 0.0F, -14.0F, 16.0F, 6.0F, 20.0F, 0.0F, 0.0F, 0.0F);
		this.Tail1 = new ModelRenderer(this, 193, 72);
		this.Tail1.setRotationPoint(0.0F, -7.0F, 26.0F);
		this.Tail1.addBox(-12.0F, -7.0F, -7.0F, 24.0F, 25.0F, 71.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Tail1, -0.13665927909957545F, 0.0F, 0.0F);
		this.Spikes = new ModelRenderer(this, 64, 0);
		this.Spikes.setRotationPoint(0.0F, -47.0F, 6.0F);
		this.Spikes.addBox(-1.0F, 0.0F, 0.0F, 1.0F, 20.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.RightHindLeg1 = new ModelRenderer(this, 64, 135);
		this.RightHindLeg1.mirror = true;
		this.RightHindLeg1.setRotationPoint(-20.0F, -36.0F, 26.0F);
		this.RightHindLeg1.addBox(-8.5F, -13.0F, -12.0F, 17.0F, 45.0F, 24.0F, 0.0F, 0.0F, 0.0F);
		this.body = new ModelRenderer(this, 0, 2);
		this.body.setRotationPoint(0.0F, -41.0F, 14.0F);
		this.body.addBox(-25.0F, -20.0F, -54.0F, 50.0F, 50.0F, 80.0F, 0.0F, 0.0F, 0.0F);
		this.LeftHindLeg1 = new ModelRenderer(this, 64, 135);
		this.LeftHindLeg1.setRotationPoint(20.0F, -36.0F, 26.0F);
		this.LeftHindLeg1.addBox(-8.5F, -13.0F, -12.0F, 17.0F, 45.0F, 24.0F, 0.0F, 0.0F, 0.0F);
		this.LeftThumb = new ModelRenderer(this, 0, 221);
		this.LeftThumb.setRotationPoint(-7.5F, 49.0F, -4.5F);
		this.LeftThumb.addBox(-4.0F, -1.0F, -1.0F, 4.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.RightFrontLeg = new ModelRenderer(this, 0, 139);
		this.RightFrontLeg.mirror = true;
		this.RightFrontLeg.setRotationPoint(-19.5F, -27.0F, -28.0F);
		this.RightFrontLeg.addBox(-7.5F, -10.0F, -7.5F, 15.0F, 61.0F, 15.0F, 0.0F, 0.0F, 0.0F);
		this.Neck2 = new ModelRenderer(this, 104, 300);
		this.Neck2.setRotationPoint(0.0F, -45.0F, 0.0F);
		this.Neck2.addBox(-6.0F, -47.0F, -14.0F, 12.0F, 54.0F, 20.0F, 0.0F, 0.0F, 0.0F);
		this.Head2 = new ModelRenderer(this, 37, 39);
		this.Head2.setRotationPoint(1.0F, 8.0F, -15.0F);
		this.Head2.addBox(-5.0F, -8.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Snout = new ModelRenderer(this, 0, 54);
		this.Snout.setRotationPoint(0.0F, 8.0F, -15.0F);
		this.Snout.addBox(-5.0F, 0.0F, -10.0F, 10.0F, 9.0F, 10.0F, 0.0F, 0.0F, 0.0F);
		this.NeckAngle = new ModelRenderer(this, 0, 0);
		this.NeckAngle.setRotationPoint(0.0F, 10.0F, -49.0F);
		this.NeckAngle.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(NeckAngle, 0.27314402127920984F, 0.0F, 0.0F);
		this.Neck2.addChild(this.Head);
		this.RightFrontLeg.addChild(this.RightThumb);
		this.Tail1.addChild(this.Tail2);
		this.LeftHindLeg1.addChild(this.LeftHindLeg2);
		this.body.addChild(this.NeckAngle);
		this.NeckAngle.addChild(this.Neck1);
		this.RightHindLeg1.addChild(this.RightHindLeg2);
		this.RightHindLeg2.addChild(this.RightHindLeg3);
		this.LeftHindLeg2.addChild(this.LeftHindLeg3);
		this.body.addChild(this.Tail1);
		this.Neck2.addChild(this.Spikes);
		this.LeftFrontLeg.addChild(this.LeftThumb);
		this.Neck1.addChild(this.Neck2);
		this.Head.addChild(this.Head2);
		this.Head.addChild(this.Snout);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.LeftFrontLeg, this.RightHindLeg1, this.body, this.LeftHindLeg1, this.RightFrontLeg).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(CamarasaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		this.body.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
		this.body.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
		this.Neck1.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
		this.Tail1.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.05F * ageInTicks / 5))) + (MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.2F);
		this.Tail1.rotateAngleY = (-0.12F * MathHelper.sin(0.05F * ageInTicks / 5)) + (MathHelper.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
		this.Tail1.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
		this.Tail2.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.05F * ageInTicks / 5))) + (MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.1F);
		this.Tail2.rotateAngleY = (-0.12F * MathHelper.sin(0.05F * ageInTicks / 5)) + (MathHelper.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.5F * limbSwingAmount);
		this.Neck1.rotateAngleX = (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F);
		this.Neck1.rotateAngleY = (MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount);
		this.Neck2.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.05F;
		this.Neck2.rotateAngleY = MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount;
		this.Head.rotateAngleX = (-Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1F);
		this.LeftHindLeg1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.5F * limbSwingAmount;
		this.LeftHindLeg2.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.05F;
		this.LeftHindLeg3.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
		this.RightHindLeg1.rotateAngleX = MathHelper.cos(4.0F + limbSwing * speed * 0.3F) * degree * 0.5F * limbSwingAmount;
		this.RightHindLeg2.rotateAngleX = MathHelper.cos(4.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.05F;
		this.RightHindLeg3.rotateAngleX = MathHelper.cos(5.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
		this.LeftFrontLeg.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
		this.RightFrontLeg.rotateAngleX = MathHelper.cos(5.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
		//this.Head1.rotateAngleX = -Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
		//this.Neck1.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		//this.Neck1.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		if (entityIn.isEating()) {
			this.Neck1.rotateAngleX = (Math.abs(MathHelper.sin(0.02F * ageInTicks) * 0.5F) + 0.5F) + ((Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F));
			this.Neck2.rotateAngleX = (Math.abs(MathHelper.sin(0.02F * ageInTicks) * 0.25F) + 0.5F) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.05F);
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
