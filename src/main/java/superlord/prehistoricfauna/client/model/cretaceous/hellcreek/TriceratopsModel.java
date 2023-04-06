package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TriceratopsEntity;

/**
 * Triceratops - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class TriceratopsModel extends EntityModel<TriceratopsEntity> {
	public ModelRenderer Body;
	public ModelRenderer LeftFrontLeg;
	public ModelRenderer RightFrontLeg;
	public ModelRenderer LeftHindLeg1;
	public ModelRenderer RightHindLeg1;
	public ModelRenderer Neck;
	public ModelRenderer Tail1;
	public ModelRenderer Saddle;
	public ModelRenderer Head1;
	public ModelRenderer Snout;
	public ModelRenderer horn1;
	public ModelRenderer horn1_1;
	public ModelRenderer Crest;
	public ModelRenderer nasalhorn;
	public ModelRenderer Beak;
	public ModelRenderer Tail2;
	public ModelRenderer quills;
	public ModelRenderer Chest1;
	public ModelRenderer Saddle2;
	public ModelRenderer Chest2;
	public ModelRenderer Chest3;
	public ModelRenderer Chest4;
	public ModelRenderer LeftHindLeg2;
	public ModelRenderer LeftHindLeg3;
	public ModelRenderer RightHindLeg2;
	public ModelRenderer RightHindLeg3;

	public TriceratopsModel() {
		this.textureWidth = 256;
		this.textureHeight = 256;
		this.LeftHindLeg1 = new ModelRenderer(this, 190, 0);
		this.LeftHindLeg1.setRotationPoint(11.0F, -10.0F, 10.0F);
		this.LeftHindLeg1.addBox(-4.0F, -5.0F, -8.0F, 8.0F, 25.0F, 19.0F, 0.0F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 98, 0);
		this.Neck.setRotationPoint(0.0F, 1.0F, -22.0F);
		this.Neck.addBox(-5.0F, -5.0F, -16.0F, 10.0F, 19.0F, 19.0F, 0.0F, 0.0F, 0.0F);
		this.RightHindLeg3 = new ModelRenderer(this, 157, 0);
		this.RightHindLeg3.setRotationPoint(0.0F, 14.0F, 3.0F);
		this.RightHindLeg3.addBox(-4.0F, 0.0F, -6.0F, 8.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Chest3 = new ModelRenderer(this, 215, 163);
		this.Chest3.setRotationPoint(12.0F, -2.0F, -15.0F);
		this.Chest3.addBox(0.0F, 0.0F, -3.0F, 3.0F, 7.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Chest4 = new ModelRenderer(this, 215, 163);
		this.Chest4.mirror = true;
		this.Chest4.setRotationPoint(-12.0F, -2.0F, -15.0F);
		this.Chest4.addBox(-3.0F, 0.0F, -3.0F, 3.0F, 7.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Saddle = new ModelRenderer(this, 112, 172);
		this.Saddle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Saddle.addBox(-12.0F, -8.0F, -24.0F, 24.0F, 31.0F, 43.0F, 0.0F, 0.0F, 0.0F);
		this.Crest = new ModelRenderer(this, 58, 127);
		this.Crest.setRotationPoint(0.0F, 9.0F, -3.0F);
		this.Crest.addBox(-14.0F, -23.0F, -5.0F, 28.0F, 25.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Crest, -0.591841146688116F, 0.0F, 0.0F);
		this.Saddle2 = new ModelRenderer(this, 141, 143);
		this.Saddle2.setRotationPoint(0.0F, -12.0F, 14.0F);
		this.Saddle2.addBox(-14.0F, -4.0F, -4.0F, 28.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Head1 = new ModelRenderer(this, 0, 130);
		this.Head1.setRotationPoint(0.0F, -3.0F, -16.0F);
		this.Head1.addBox(-6.0F, -3.0F, -12.0F, 12.0F, 18.0F, 12.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Head1, 0.500909508638178F, 0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 82, 77);
		this.Tail2.setRotationPoint(0.0F, 1.0F, 19.0F);
		this.Tail2.addBox(-3.0F, -2.0F, -3.0F, 6.0F, 8.0F, 27.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Tail2, 0.0911061832922575F, 0.0F, 0.0F);
		this.Chest1 = new ModelRenderer(this, 207, 182);
		this.Chest1.setRotationPoint(12.0F, -11.0F, 8.0F);
		this.Chest1.addBox(0.0F, 0.0F, -6.0F, 6.0F, 10.0F, 11.0F, 0.0F, 0.0F, 0.0F);
		this.RightHindLeg1 = new ModelRenderer(this, 190, 0);
		this.RightHindLeg1.setRotationPoint(-11.0F, -10.0F, 10.0F);
		this.RightHindLeg1.addBox(-4.0F, -5.0F, -8.0F, 8.0F, 25.0F, 19.0F, 0.0F, 0.0F, 0.0F);
		this.horn1 = new ModelRenderer(this, 60, 165);
		this.horn1.setRotationPoint(4.9F, -1.0F, -12.0F);
		this.horn1.addBox(-2.0F, -4.0F, -20.0F, 3.0F, 4.0F, 25.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(horn1, -0.7285004590772052F, -0.18203784630933073F, 0.0F);
		this.quills = new ModelRenderer(this, 48, 77);
		this.quills.setRotationPoint(0.0F, -3.0F, -1.0F);
		this.quills.addBox(-3.0F, -2.0F, 0.0F, 6.0F, 2.0F, 22.0F, 0.0F, 0.0F, 0.0F);
		this.Chest2 = new ModelRenderer(this, 207, 182);
		this.Chest2.mirror = true;
		this.Chest2.setRotationPoint(-12.0F, -11.0F, 8.0F);
		this.Chest2.addBox(-6.0F, 0.0F, -6.0F, 6.0F, 10.0F, 11.0F, 0.0F, 0.0F, 0.0F);
		this.Tail1 = new ModelRenderer(this, 0, 77);
		this.Tail1.setRotationPoint(0.0F, -1.0F, 19.0F);
		this.Tail1.addBox(-6.0F, -3.0F, -2.0F, 12.0F, 13.0F, 24.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Tail1, -0.3186971254089062F, 0.0F, 0.0F);
		this.LeftHindLeg3 = new ModelRenderer(this, 157, 0);
		this.LeftHindLeg3.setRotationPoint(0.0F, 14.0F, 3.0F);
		this.LeftHindLeg3.addBox(-4.0F, 0.0F, -6.0F, 8.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.RightHindLeg2 = new ModelRenderer(this, 190, 50);
		this.RightHindLeg2.setRotationPoint(0.0F, 17.0F, 6.0F);
		this.RightHindLeg2.addBox(-3.0F, -4.0F, -2.0F, 6.0F, 19.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, -14.0F, 4.0F);
		this.Body.addBox(-12.0F, -8.0F, -24.0F, 24.0F, 31.0F, 43.0F, 0.0F, 0.0F, 0.0F);
		this.Beak = new ModelRenderer(this, 0, 204);
		this.Beak.setRotationPoint(0.0F, 2.0F, -14.0F);
		this.Beak.addBox(-2.0F, 0.0F, -5.0F, 4.0F, 12.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.nasalhorn = new ModelRenderer(this, 0, 0);
		this.nasalhorn.setRotationPoint(0.0F, 1.0F, -12.0F);
		this.nasalhorn.addBox(-1.0F, -5.0F, -3.0F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(nasalhorn, 0.6373942508178124F, 0.0F, 0.0F);
		this.RightFrontLeg = new ModelRenderer(this, 220, 75);
		this.RightFrontLeg.mirror = true;
		this.RightFrontLeg.setRotationPoint(-11.0F, -3.0F, -14.0F);
		this.RightFrontLeg.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 27.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.Snout = new ModelRenderer(this, 0, 169);
		this.Snout.setRotationPoint(0.0F, 1.0F, -12.0F);
		this.Snout.addBox(-4.0F, 0.0F, -14.0F, 8.0F, 13.0F, 14.0F, 0.0F, 0.0F, 0.0F);
		this.LeftHindLeg2 = new ModelRenderer(this, 190, 50);
		this.LeftHindLeg2.setRotationPoint(0.0F, 17.0F, 6.0F);
		this.LeftHindLeg2.addBox(-3.0F, -4.0F, -2.0F, 6.0F, 19.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.LeftFrontLeg = new ModelRenderer(this, 220, 75);
		this.LeftFrontLeg.setRotationPoint(11.0F, -3.0F, -14.0F);
		this.LeftFrontLeg.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 27.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.horn1_1 = new ModelRenderer(this, 60, 165);
		this.horn1_1.setRotationPoint(-4.9F, -1.0F, -12.0F);
		this.horn1_1.addBox(-1.0F, -4.0F, -20.0F, 3.0F, 4.0F, 25.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(horn1_1, -0.7285004590772052F, 0.18203784630933073F, 0.0F);
		this.Body.addChild(this.Neck);
		this.RightHindLeg2.addChild(this.RightHindLeg3);
		this.Saddle.addChild(this.Chest3);
		this.Saddle.addChild(this.Chest4);
		this.Body.addChild(this.Saddle);
		this.Head1.addChild(this.Crest);
		this.Saddle.addChild(this.Saddle2);
		this.Neck.addChild(this.Head1);
		this.Tail1.addChild(this.Tail2);
		this.Saddle.addChild(this.Chest1);
		this.Head1.addChild(this.horn1);
		this.Tail1.addChild(this.quills);
		this.Saddle.addChild(this.Chest2);
		this.Body.addChild(this.Tail1);
		this.LeftHindLeg2.addChild(this.LeftHindLeg3);
		this.RightHindLeg1.addChild(this.RightHindLeg2);
		this.Snout.addChild(this.Beak);
		this.Snout.addChild(this.nasalhorn);
		this.Head1.addChild(this.Snout);
		this.LeftHindLeg1.addChild(this.LeftHindLeg2);
		this.Head1.addChild(this.horn1_1);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.LeftHindLeg1, this.RightHindLeg1, this.Body, this.RightFrontLeg, this.LeftFrontLeg).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(TriceratopsEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress = entityIn.getMeleeProgress(partialTick) * 2.0F;
		this.resetModel();
		if (entityIn.isSleeping()) {
			this.LeftHindLeg3.rotateAngleX = 1.5707963267948966F;
			this.RightFrontLeg.rotateAngleX = -1.2915436464758039F;
			this.RightFrontLeg.rotateAngleY = -0.3490658503988659F;
			this.Tail2.rotateAngleX = 0.16929693411449862F;
			this.Tail2.rotateAngleY = 0.35185837453889574F;
			this.Tail2.rotateAngleZ = 0.1563815016444822F;
			this.RightHindLeg1.rotateAngleX = -0.8726646259971648F;
			this.RightHindLeg1.rotateAngleY = 0.23457224414434488F;
			this.Neck.rotateAngleX = 0.27366763203903305F;
			this.Neck.rotateAngleY = -0.5473352640780661F;
			this.LeftHindLeg1.rotateAngleX = -0.8726646259971648F;
			this.LeftHindLeg1.rotateAngleY = -0.23457224414434488F;
			this.RightHindLeg3.rotateAngleX = 1.5707963267948966F;
			this.Head1.rotateAngleX = -0.007330382629510778F;
			this.LeftHindLeg2.rotateAngleX =-0.6981317007977318F;
			this.Tail1.rotateAngleX = -0.5141739816585629F;
			this.Tail1.rotateAngleY = 0.35185837453889574F;
			this.LeftFrontLeg.rotateAngleX = -1.0557496272471145F;
			this.LeftFrontLeg.rotateAngleY = -0.03909537541112055F;
			this.LeftFrontLeg.rotateAngleZ = -0.4300491170387584F;
			this.RightHindLeg2.rotateAngleX = -0.6981317007977318F;
			this.Body.rotationPointY = 1;
			this.LeftHindLeg1.rotationPointY = 4;
			this.LeftHindLeg1.rotationPointZ = 14;
			this.LeftHindLeg2.rotationPointY = 15.3F;
			this.LeftHindLeg2.rotationPointZ = 8;
			this.LeftHindLeg3.rotationPointY = 15;
			this.LeftHindLeg3.rotationPointZ = 1;
			this.RightHindLeg1.rotationPointY = 4;
			this.RightHindLeg1.rotationPointZ = 14;
			this.RightHindLeg2.rotationPointY = 15.3F;
			this.RightHindLeg2.rotationPointZ = 8;
			this.RightHindLeg3.rotationPointY = 15;
			this.RightHindLeg3.rotationPointZ = 1;
			this.RightFrontLeg.rotationPointY = 12;
			this.LeftFrontLeg.rotationPointY = 12;
		} else {
			this.RightFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount + attackProgress * (float) Math.toRadians(15F);
			this.LeftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount + attackProgress * (float) Math.toRadians(15F);
			this.LeftHindLeg1.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + attackProgress * (float) Math.toRadians(7F);
			this.LeftHindLeg2.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
			this.LeftHindLeg3.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
			this.RightHindLeg1.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + attackProgress * (float) Math.toRadians(7F);
			this.RightHindLeg2.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
			this.RightHindLeg3.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
			this.Tail1.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.05F * limbSwingAmount);
			this.Tail2.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.15F * limbSwingAmount);
			this.Tail1.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.3F);
			this.Tail2.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
			this.Body.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
			this.Neck.rotateAngleX = (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.05F);
			this.Head1.rotateAngleX = (-Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.5F) + attackProgress * (float) Math.toRadians(25F);
			this.Body.rotationPointZ = 4.0F + attackProgress * -8F;
			this.RightFrontLeg.rotationPointZ = -14.0F + attackProgress * -6F;
			this.LeftFrontLeg.rotationPointZ = -14.0F + attackProgress * -6F;
			this.RightHindLeg1.rotationPointZ = 10.0F + attackProgress * -6F;
			this.LeftHindLeg1.rotationPointZ = 10.0F + attackProgress * -6F;
			if (entityIn.isEating()) {
				this.Neck.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.25F) + 0.15F;
				this.Body.rotateAngleX = 0.1F;
			}
			if (entityIn.isInWater()) {
				this.Body.rotationPointY = 8;
				this.Body.rotateAngleX = -0.25F;
				this.Tail1.rotateAngleX = 0.125F;
				this.Tail2.rotateAngleX = 0.125F;
				this.LeftHindLeg1.rotationPointY = 14;
				this.RightHindLeg1.rotationPointY = 14;
				this.LeftFrontLeg.rotationPointY = 17;
				this.RightFrontLeg.rotationPointY = 17;
				this.LeftHindLeg1.rotateAngleX = -0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RightHindLeg1.rotateAngleX = 0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RightFrontLeg.rotateAngleX = -0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LeftFrontLeg.rotateAngleX = 0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LeftHindLeg2.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RightHindLeg2.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LeftHindLeg3.rotateAngleX = 0.5F - (0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F));
				this.RightHindLeg3.rotateAngleX = 0.5F + (0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F));
				this.Neck.rotateAngleX = 0.0625F;
				this.Tail1.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}
	
	public void resetModel() {
		this.RightFrontLeg.rotateAngleX = 0;
		this.RightFrontLeg.rotateAngleY = 0;
		this.Head1.rotateAngleX = 0;
		this.LeftFrontLeg.rotateAngleX = 0;
		this.LeftFrontLeg.rotateAngleY = 0;
		this.LeftFrontLeg.rotateAngleZ = 0;
		this.LeftHindLeg3.rotateAngleZ = 0;
		this.RightHindLeg1.rotateAngleX = 0;
		this.RightHindLeg1.rotateAngleY = 0;
		this.LeftHindLeg1.rotateAngleX = 0;
		this.LeftHindLeg1.rotateAngleY = 0;
		this.Neck.rotateAngleX = 0;
		this.Neck.rotateAngleY = 0;
		this.RightHindLeg2.rotateAngleX = 0;
		this.RightHindLeg2.rotateAngleZ = 0;
		this.Tail1.rotateAngleX = 0;
		this.Tail1.rotateAngleY = 0;
		this.Tail2.rotateAngleX = 0;
		this.Tail2.rotateAngleY = 0;
		this.Tail2.rotateAngleZ = 0;
		this.LeftHindLeg2.rotateAngleX = 0;
		this.LeftHindLeg2.rotateAngleZ = 0;
		this.Body.rotationPointY = -14;
		this.LeftHindLeg1.rotationPointY = -10;
		this.LeftHindLeg1.rotationPointZ = 10;
		this.LeftHindLeg2.rotationPointY = 17;
		this.LeftHindLeg2.rotationPointZ = 6;
		this.LeftHindLeg3.rotationPointY = 14;
		this.RightHindLeg1.rotationPointY = -10;
		this.RightHindLeg1.rotationPointZ = 10;
		this.RightHindLeg2.rotationPointY = 17;
		this.RightHindLeg2.rotationPointZ = 6;
		this.RightFrontLeg.rotationPointY = -3;
		this.LeftFrontLeg.rotationPointY = -3;
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
