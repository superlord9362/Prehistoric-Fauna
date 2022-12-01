package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.AnkylosaurusEntity;

/**
 * Ankylosaurus - Weastian
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class AnkylosaurusModel extends EntityModel<AnkylosaurusEntity> {
	public ModelRenderer Body;
	public ModelRenderer LeftFrontLeg;
	public ModelRenderer RightFrontLeg;
	public ModelRenderer LeftHindLeg1;
	public ModelRenderer RightHindLeg1;
	public ModelRenderer Neck;
	public ModelRenderer Tail1;
	public ModelRenderer Head1;
	public ModelRenderer Head2;
	public ModelRenderer Spike1;
	public ModelRenderer Spike1_1;
	public ModelRenderer Spike3;
	public ModelRenderer Spike4;
	public ModelRenderer Tail2;
	public ModelRenderer TailClub;
	public ModelRenderer LeftHindLeg2;
	public ModelRenderer LeftHindLeg3;
	public ModelRenderer RightHindLeg2;
	public ModelRenderer RightHindLeg3;

	public AnkylosaurusModel() {
		this.textureWidth = 256;
		this.textureHeight = 128;
		this.Spike1 = new ModelRenderer(this, 0, 33);
		this.Spike1.setRotationPoint(7.0F, -3.0F, 0.0F);
		this.Spike1.addBox(-4.0F, -3.0F, 0.0F, 5.0F, 5.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Spike1, 0.0911061832922575F, 0.27314402127920984F, 0.0F);
		this.Tail1 = new ModelRenderer(this, 0, 79);
		this.Tail1.setRotationPoint(0.0F, -1.0F, 18.0F);
		this.Tail1.addBox(-6.0F, -3.0F, -4.0F, 12.0F, 13.0F, 21.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Tail1, -0.2275909337942703F, 0.0F, 0.0F);
		this.LeftHindLeg3 = new ModelRenderer(this, 157, 0);
		this.LeftHindLeg3.setRotationPoint(0.0F, 10.0F, 3.0F);
		this.LeftHindLeg3.addBox(-4.0F, 0.0F, -6.0F, 8.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.LeftHindLeg2 = new ModelRenderer(this, 200, 0);
		this.LeftHindLeg2.setRotationPoint(0.0F, 10.0F, 3.0F);
		this.LeftHindLeg2.addBox(-3.5F, -3.0F, -2.0F, 7.0F, 14.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.TailClub = new ModelRenderer(this, 94, 85);
		this.TailClub.setRotationPoint(0.0F, 0.0F, 21.0F);
		this.TailClub.addBox(-5.5F, -4.0F, 0.0F, 11.0F, 8.0F, 17.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 1.0F, 9.0F);
		this.Body.addBox(-15.5F, -9.0F, -34.0F, 31.0F, 22.0F, 52.0F, 0.0F, 0.0F, 0.0F);
		this.Spike1_1 = new ModelRenderer(this, 0, 33);
		this.Spike1_1.setRotationPoint(-7.0F, -3.0F, 0.0F);
		this.Spike1_1.addBox(-1.0F, -3.0F, 0.0F, 5.0F, 5.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Spike1_1, 0.0911061832922575F, -0.27314402127920984F, 0.0F);
		this.RightHindLeg3 = new ModelRenderer(this, 157, 0);
		this.RightHindLeg3.setRotationPoint(0.0F, 10.0F, 3.0F);
		this.RightHindLeg3.addBox(-4.0F, 0.0F, -6.0F, 8.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 121, 16);
		this.Neck.setRotationPoint(0.0F, -1.0F, -34.0F);
		this.Neck.addBox(-5.0F, -6.0F, -12.0F, 10.0F, 12.0F, 14.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Neck, -0.18203784630933073F, 0.0F, 0.0F);
		this.Head1 = new ModelRenderer(this, 152, 97);
		this.Head1.setRotationPoint(0.0F, -1.0F, -12.0F);
		this.Head1.addBox(-7.0F, -5.0F, -12.0F, 14.0F, 12.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Head1, 0.3186971254089062F, 0.0F, 0.0F);
		this.RightHindLeg1 = new ModelRenderer(this, 190, 33);
		this.RightHindLeg1.setRotationPoint(-13.0F, 0.0F, 8.0F);
		this.RightHindLeg1.addBox(-5.0F, -4.0F, -8.0F, 10.0F, 19.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.RightFrontLeg = new ModelRenderer(this, 0, 0);
		this.RightFrontLeg.mirror = true;
		this.RightFrontLeg.setRotationPoint(-12.0F, 6.0F, -26.0F);
		this.RightFrontLeg.addBox(-4.0F, -3.0F, -4.0F, 7.0F, 20.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.LeftHindLeg1 = new ModelRenderer(this, 190, 33);
		this.LeftHindLeg1.setRotationPoint(13.0F, 0.0F, 8.0F);
		this.LeftHindLeg1.addBox(-5.0F, -4.0F, -8.0F, 10.0F, 19.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 45, 87);
		this.Tail2.setRotationPoint(0.0F, 3.0F, 17.0F);
		this.Tail2.addBox(-2.5F, -3.0F, -5.0F, 5.0F, 6.0F, 30.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Tail2, 0.13665927909957545F, 0.0F, 0.0F);
		this.Spike4 = new ModelRenderer(this, 29, 32);
		this.Spike4.setRotationPoint(-7.0F, 2.0F, -2.0F);
		this.Spike4.addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Spike4, 0.0F, -0.9105382388075086F, 0.0F);
		this.LeftFrontLeg = new ModelRenderer(this, 0, 0);
		this.LeftFrontLeg.setRotationPoint(12.0F, 6.0F, -26.0F);
		this.LeftFrontLeg.addBox(-3.0F, -3.0F, -4.0F, 7.0F, 20.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.RightHindLeg2 = new ModelRenderer(this, 200, 0);
		this.RightHindLeg2.setRotationPoint(0.0F, 10.0F, 3.0F);
		this.RightHindLeg2.addBox(-3.5F, -3.0F, -2.0F, 7.0F, 14.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Head2 = new ModelRenderer(this, 200, 93);
		this.Head2.setRotationPoint(0.0F, 0.0F, -12.0F);
		this.Head2.addBox(-5.5F, -3.0F, -3.0F, 11.0F, 9.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.Spike3 = new ModelRenderer(this, 29, 32);
		this.Spike3.setRotationPoint(7.0F, 2.0F, -2.0F);
		this.Spike3.addBox(-4.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Spike3, 0.0F, 0.9105382388075086F, 0.0F);
		this.Head1.addChild(this.Spike1);
		this.Body.addChild(this.Tail1);
		this.LeftHindLeg2.addChild(this.LeftHindLeg3);
		this.LeftHindLeg1.addChild(this.LeftHindLeg2);
		this.Tail2.addChild(this.TailClub);
		this.Head1.addChild(this.Spike1_1);
		this.RightHindLeg2.addChild(this.RightHindLeg3);
		this.Body.addChild(this.Neck);
		this.Neck.addChild(this.Head1);
		this.Body.addChild(this.RightHindLeg1);
		this.Body.addChild(this.RightFrontLeg);
		this.Body.addChild(this.LeftHindLeg1);
		this.Tail1.addChild(this.Tail2);
		this.Head1.addChild(this.Spike4);
		this.Body.addChild(this.LeftFrontLeg);
		this.RightHindLeg1.addChild(this.RightHindLeg2);
		this.Head1.addChild(this.Head2);
		this.Head1.addChild(this.Spike3);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(AnkylosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress = entityIn.getMeleeProgress(partialTick);
		float leftOrRight = entityIn.getMeleeDirection() ? 1.0F : -1.0F;
		this.Head1.rotateAngleX = 0.3186971254089062F;
		this.Head1.rotateAngleY = 0;
		this.Head1.rotateAngleZ = 0;
		this.TailClub.rotateAngleX = 0;
		this.TailClub.rotateAngleY = 0;
		this.RightHindLeg3.rotateAngleX = 0;
		this.LeftHindLeg1.rotateAngleY = 0;
		this.RightHindLeg1.rotateAngleX = 0;
		this.RightHindLeg1.rotateAngleY = 0;
		this.Body.rotateAngleX = 0;
		this.RightFrontLeg.rotateAngleX = 0;
		this.RightFrontLeg.rotateAngleY = 0;
		this.RightFrontLeg.rotateAngleZ = 0;
		this.Tail2.rotateAngleX = 0.13665927909957545F;
		this.Tail2.rotateAngleY = 0;
		this.RightHindLeg2.rotateAngleX = 0;
		this.RightHindLeg2.rotateAngleY = 0;
		this.RightHindLeg2.rotateAngleZ = 0;
		this.LeftHindLeg3.rotateAngleX = 0;
		this.LeftFrontLeg.rotateAngleX = 0;
		this.LeftFrontLeg.rotateAngleY = 0;
		this.LeftFrontLeg.rotateAngleZ = 0;
		this.LeftHindLeg2.rotateAngleX = 0;
		this.LeftHindLeg2.rotateAngleY = 0;
		this.Neck.rotateAngleX = -0.18203784630933073F;
		this.Neck.rotateAngleY = 0;
		this.Neck.rotateAngleZ = 0;
		this.Tail1.rotateAngleX = -0.2275909337942703F;
		this.Tail1.rotateAngleY = 0;
		this.Body.rotationPointY = 1;
		this.Head1.rotationPointY = -1;
		this.RightFrontLeg.rotationPointX = -13F;
		this.LeftFrontLeg.rotationPointX = 13F;
		if (entityIn.isAsleep()) {
			this.Body.rotationPointY = 9;
			this.Head1.rotateAngleX = 0.02827433396553192F;
			this.Head1.rotateAngleY = 0.11728612207217244F;
			this.Head1.rotateAngleZ = -0.11746065899211351F;
			this.RightHindLeg3.rotateAngleX = 1.5645131308350726F;
			this.LeftHindLeg1.rotateAngleY = -0.15707963267948966F;
			this.RightHindLeg1.rotateAngleX = 0.017453292519943295F;
			this.RightHindLeg1.rotateAngleY = 0.15707963267948966F;
			this.Body.rotateAngleX = -0.03909537541112055F;
			this.RightFrontLeg.rotateAngleX = -0.8208283259076444F;
			this.RightFrontLeg.rotateAngleY = -0.3909537457888271F;
			this.RightFrontLeg.rotateAngleZ = -0.31293754020890546F;
			this.Tail2.rotateAngleX = 0.03263765709551775F;
			this.Tail2.rotateAngleY = -0.11728612207217244F;
			this.RightHindLeg2.rotateAngleX = -1.5317009888344788F;
			this.RightHindLeg2.rotateAngleY = 0.33021629580890766F;
			this.RightHindLeg2.rotateAngleZ = 0.017453292519943295F;
			this.LeftHindLeg3.rotateAngleX = 1.5247196451948906F;
			this.LeftFrontLeg.rotateAngleX = -0.8990190684075072F;
			this.LeftFrontLeg.rotateAngleY = 0.31293754020890546F;
			this.LeftFrontLeg.rotateAngleZ = 0.07644542323472245F;
			this.LeftHindLeg2.rotateAngleX = -1.5247196451948906F;
			this.LeftHindLeg2.rotateAngleY = -0.2738421523142173F;
			this.Neck.rotateAngleX = 0.3862413488189591F;
			this.Neck.rotateAngleY = 0.11728612207217244F;
			this.Neck.rotateAngleZ = -0.1563815016444822F;
			this.Tail1.rotateAngleX = -0.18901915665940536F;
			this.Tail1.rotateAngleY = -0.27366763203903305F;
			this.Head1.rotationPointY = -1.5F;
			this.RightFrontLeg.rotationPointX = -16.75F; 
			this.LeftFrontLeg.rotationPointX = 14.5F; 
			this.RightHindLeg1.rotateAngleX = 0;
			this.LeftHindLeg1.rotateAngleX = 0;
		} else {
			this.Body.rotateAngleX = 0F;
			this.LeftHindLeg1.rotateAngleX = -0F;
			this.RightHindLeg1.rotateAngleX = -0F;
			this.RightFrontLeg.rotateAngleX = -0F;
			this.LeftFrontLeg.rotateAngleX = -0F;
			this.RightFrontLeg.rotateAngleZ = 0F;
			this.LeftFrontLeg.rotateAngleZ = -0F;
			this.LeftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.RightFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
			this.RightHindLeg1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.RightHindLeg2.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.RightHindLeg3.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
			this.LeftHindLeg1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
			this.LeftHindLeg2.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
			this.LeftHindLeg3.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
			this.Tail1.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount) + attackProgress * leftOrRight * (float)Math.toRadians(-15);
			this.Tail2.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount) + attackProgress * leftOrRight * (float)Math.toRadians(-25);
			this.Tail1.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
			this.Tail2.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
			this.Neck.rotateAngleX = (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F);
			this.Head1.rotateAngleX = (-Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.05F);
			this.Body.rotateAngleY = attackProgress * leftOrRight * (float)Math.toRadians(-200);
			this.Tail1.rotateAngleZ = attackProgress * leftOrRight * (float)Math.toRadians(15);
			this.Body.rotationPointZ = 12.0F + attackProgress * -22;
			if (entityIn.isEating() || entityIn.isTuberDigging()) {
				this.Neck.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
				this.Body.rotateAngleX = 0.1F;
				this.LeftHindLeg1.rotateAngleX = -0.1F;
				this.RightHindLeg1.rotateAngleX = -0.1F;
				this.RightFrontLeg.rotateAngleX = -0.1F;
				this.LeftFrontLeg.rotateAngleX = -0.1F;
				this.RightFrontLeg.rotateAngleZ = 0.3F;
				this.LeftFrontLeg.rotateAngleZ = -0.3F;
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
