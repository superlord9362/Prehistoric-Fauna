package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.VelociraptorEntity;

/**
 * Velociraptor - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class VelociraptorModel extends EntityModel<VelociraptorEntity> {
	public ModelRenderer Body;
	public ModelRenderer ThighLeft;
	public ModelRenderer ThighRight;
	public ModelRenderer Neck;
	public ModelRenderer Tail;
	public ModelRenderer WingLeft;
	public ModelRenderer WingRight;
	public ModelRenderer Head;
	public ModelRenderer Mouth;
	public ModelRenderer TailFan;
	public ModelRenderer LegLeft;
	public ModelRenderer FootLeft;
	public ModelRenderer LegRight;
	public ModelRenderer FootRight;

	public VelociraptorModel() {
		this.textureWidth = 64;
        this.textureHeight = 64;
        this.Neck = new ModelRenderer(this, 0, 0);
        this.Neck.setRotationPoint(0.0F, 0.0F, -4.5F);
        this.Neck.addBox(-1.0F, -6.0F, -3.0F, 2, 7, 3, 0.0F);
        this.Tail = new ModelRenderer(this, 23, 7);
        this.Tail.setRotationPoint(0.0F, -0.5F, 5.0F);
        this.Tail.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 15, 0.0F);
        this.ThighRight = new ModelRenderer(this, 46, 0);
        this.ThighRight.mirror = true;
        this.ThighRight.setRotationPoint(-0.5F, 16.0F, 2.0F);
        this.ThighRight.addBox(-2.0F, -1.0F, -1.0F, 2, 5, 3, 0.0F);
        this.LegLeft = new ModelRenderer(this, 55, 11);
        this.LegLeft.setRotationPoint(1.0F, 4.0F, 2.0F);
        this.LegLeft.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 0, 0.0F);
        this.TailFan = new ModelRenderer(this, 0, 15);
        this.TailFan.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.TailFan.addBox(-2.0F, 0.0F, 0.0F, 4, 2, 13, 0.0F);
        this.LegRight = new ModelRenderer(this, 55, 11);
        this.LegRight.mirror = true;
        this.LegRight.setRotationPoint(-1.0F, 4.0F, 2.0F);
        this.LegRight.addBox(-0.5F, 0.0F, 0.0F, 1, 4, 0, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.Body.addBox(-1.5F, -2.0F, -5.0F, 3, 5, 10, 0.0F);
        this.FootRight = new ModelRenderer(this, 46, 10);
        this.FootRight.mirror = true;
        this.FootRight.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.FootRight.addBox(-1.5F, -2.0F, -3.0F, 2, 2, 3, 0.0F);
        this.Mouth = new ModelRenderer(this, 31, 1);
        this.Mouth.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.Mouth.addBox(-1.0F, -1.0F, -3.0F, 2, 2, 3, 0.0F);
        this.ThighLeft = new ModelRenderer(this, 46, 0);
        this.ThighLeft.setRotationPoint(0.5F, 16.0F, 2.0F);
        this.ThighLeft.addBox(0.0F, -1.0F, -1.0F, 2, 5, 3, 0.0F);
        this.Head = new ModelRenderer(this, 16, 0);
        this.Head.setRotationPoint(0.1F, -4.3F, -2.0F);
        this.Head.addBox(-1.5F, -2.0F, -3.0F, 3, 3, 4, 0.0F);
        this.FootLeft = new ModelRenderer(this, 46, 10);
        this.FootLeft.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.FootLeft.addBox(-0.5F, -2.0F, -3.0F, 2, 2, 3, 0.0F);
        this.WingLeft = new ModelRenderer(this, 0, 15);
        this.WingLeft.setRotationPoint(1.5F, 1.0F, -3.0F);
        this.WingLeft.addBox(0.0F, -1.0F, -1.0F, 1, 5, 4, 0.0F);
        this.WingRight = new ModelRenderer(this, 0, 15);
        this.WingRight.mirror = true;
        this.WingRight.setRotationPoint(-1.5F, 1.0F, -3.0F);
        this.WingRight.addBox(-1.0F, -1.0F, -1.0F, 1, 5, 4, 0.0F);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.Tail);
        this.ThighLeft.addChild(this.LegLeft);
        this.Tail.addChild(this.TailFan);
        this.ThighRight.addChild(this.LegRight);
        this.LegRight.addChild(this.FootRight);
        this.Head.addChild(this.Mouth);
        this.Neck.addChild(this.Head);
        this.LegLeft.addChild(this.FootLeft);
        this.Body.addChild(this.WingLeft);
        this.Body.addChild(this.WingRight);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.ThighRight, this.ThighLeft, this.Body).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(VelociraptorEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.ticksExisted;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0f;
		float degree = 1.0f;	
		//Reset all pieces to default rotations and positions
		this.Body.rotationPointY = 15.75F;
		this.ThighLeft.rotationPointY = 15.75F;
		this.ThighRight.rotationPointY = 15.75F;
		this.Body.rotateAngleX = 0;
		this.LegLeft.rotateAngleX = 0;
		this.WingLeft.rotateAngleZ = 0;
		this.WingRight.rotateAngleZ = 0;
		this.ThighLeft.rotateAngleX = 0;
		this.ThighLeft.rotateAngleY = 0;
		this.Tail.rotateAngleX = 0;
		this.Tail.rotateAngleY = 0;
		this.Neck.rotateAngleX = 0;
		this.Neck.rotateAngleY = 0;
		this.Neck.rotateAngleZ = 0;
		this.Head.rotateAngleX = 0;
		this.Head.rotateAngleY = 0;
		this.Head.rotateAngleZ = 0;
		this.ThighRight.rotateAngleX = 0;
		this.ThighRight.rotateAngleY = 0;
		this.LegRight.rotateAngleX = 0;
		this.FootRight.rotateAngleX = 0;
		this.FootRight.rotateAngleZ = 0;
		this.FootLeft.rotateAngleX = 0;
		this.FootLeft.rotateAngleZ = 0;
		if (entity.isAsleep()) {
			this.Body.rotateAngleX = -0.17463292F;
			this.LegLeft.rotateAngleX = -0.87266463F;
			this.WingLeft.rotateAngleZ = (-Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3))) - 0.87266463F;
			this.WingRight.rotateAngleZ = (Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3))) + 0.86266464F;
			this.ThighLeft.rotateAngleX = -0.6981316F;
			this.ThighLeft.rotateAngleY = -0.2443461F;
			this.Tail.rotateAngleX = -0.13962634F;
			this.Tail.rotateAngleY = 1.0471976F;
			this.Neck.rotateAngleX = (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) - 0.41887903F;
			this.Neck.rotateAngleY = -2.268928F;
			this.Neck.rotateAngleZ = 0.83774805F;
			this.Head.rotateAngleX = 0.5934119F + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)));
			this.ThighRight.rotateAngleX = -0.6981317F;
			this.ThighRight.rotateAngleY = 0.2443461F;
			this.LegRight.rotateAngleX = -0.87266463F;
			this.FootRight.rotateAngleX = 1.5707963267948966F;
			this.FootRight.rotateAngleZ = -0.24434609527920614F;
			this.FootLeft.rotateAngleX = 1.5707963267948966F;
			this.FootLeft.rotateAngleZ = 0.24609143118910318F;
			this.Body.rotationPointY = 19.5F;
			this.ThighLeft.rotationPointY = 19.5F;
			this.ThighRight.rotationPointY = 19.5F;
		} else if (entity.isSitting() || entity.isTameSitting()) {
			this.Body.rotationPointY = 19.5F;
			this.ThighLeft.rotationPointY = 19.5F;
			this.ThighRight.rotationPointY = 19.5F;
			//Animation
			this.ThighRight.rotateAngleX = -0.6981317007977318F;
			this.ThighLeft.rotateAngleX = -0.6981317007977318F;
			this.WingLeft.rotateAngleX = 0.4363323129985824F;
			this.WingLeft.rotateAngleZ = -1.0471975511965976F;
			this.Tail.rotateAngleX = -0.17453292519943295F;
			this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			this.Tail.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tail.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.Body.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
			this.Head.rotateAngleX = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)));
			this.WingLeft.rotateAngleZ = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
			this.WingRight.rotateAngleZ = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
		} else {
			//Idle/Walking Animations
			this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			this.ThighLeft.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount + attackProgress * (float) Math.toRadians(-65F);
			this.ThighRight.rotateAngleX = MathHelper.cos(3.0F + limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount + attackProgress * (float) Math.toRadians(-65F);
			this.Tail.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tail.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.Neck.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)) + (MathHelper.cos(limbSwing * speed * 0.1F) * (degree / 2) * 0.3F * limbSwingAmount + 0.1F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(25F);
			this.Body.rotateAngleX = (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.1F) * (degree / 2) * 0.2F * limbSwingAmount) + attackProgress * (float) Math.toRadians(-30F);
			this.Head.rotateAngleX = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)));
			this.WingLeft.rotateAngleZ = (-Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.1F * limbSwingAmount) + attackProgress * (float) Math.toRadians(-85F);
			this.WingRight.rotateAngleZ = (Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3))) + (MathHelper.cos(3.0F + limbSwing * speed * 0.4F) * degree * 0.1F * limbSwingAmount) + attackProgress * (float) Math.toRadians(85F);
			if (entity.isInWater()) {
				this.Body.rotationPointY = 17;
				this.ThighLeft.rotationPointY = 17F;
				this.ThighRight.rotationPointY = 17F;
				this.Body.rotateAngleX = -0.25F;
				this.Tail.rotateAngleX = 0.25F;
				this.Neck.rotateAngleX = 0.25F;
				this.WingLeft.rotateAngleZ = -1.5F + Math.abs(-1F * MathHelper.sin(0.15F * ageInTicks / 2));
				this.WingRight.rotateAngleZ = 1.5F - Math.abs(-1F * MathHelper.sin(0.15F * ageInTicks / 2));
				this.ThighLeft.rotateAngleX = -0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.ThighRight.rotateAngleX = 0.25F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.Tail.rotateAngleY = MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
				this.TailFan.rotateAngleY = MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
				this.LegLeft.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LegRight.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
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
