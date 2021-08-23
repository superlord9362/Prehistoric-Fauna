package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.CamarasaurusEntity;

/**
 * Camarasaurus - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class CamarasaurusBabyModel extends EntityModel<CamarasaurusEntity> {
    public ModelRenderer body;
    public ModelRenderer LeftFrontLeg;
    public ModelRenderer RightFrontLeg;
    public ModelRenderer RightHindLeg1;
    public ModelRenderer LeftHindLeg1;
    public ModelRenderer NeckAngle;
    public ModelRenderer Tail1;
    public ModelRenderer Neck1;
    public ModelRenderer Neck2;
    public ModelRenderer Head;
    public ModelRenderer Spikes;
    public ModelRenderer Head2;
    public ModelRenderer Snout;
    public ModelRenderer Tail2;
    public ModelRenderer LeftThumb;
    public ModelRenderer RightThumb;
    public ModelRenderer RightHindLeg2;
    public ModelRenderer RightHindLeg3;
    public ModelRenderer LeftHindLeg2;
    public ModelRenderer LeftHindLeg3;

    public CamarasaurusBabyModel() {
        this.textureWidth = 384;
        this.textureHeight = 384;
        this.Tail2 = new ModelRenderer(this, 149, 125);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 43.0F);
        this.Tail2.addBox(-4.5F, -3.0F, -5.0F, 9.0F, 10.0F, 46.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.10000736647217022F, 0.0F, 0.0F);
        this.Neck1 = new ModelRenderer(this, 4, 214);
        this.Neck1.setRotationPoint(0.0F, -10.0F, 3.0F);
        this.Neck1.addBox(-6.0F, -33.0F, -12.0F, 12.0F, 37.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck1, 0.2499311435592658F, 0.0F, 0.0F);
        this.LeftHindLeg1 = new ModelRenderer(this, 46, 95);
        this.LeftHindLeg1.setRotationPoint(15.5F, -17.0F, 17.0F);
        this.LeftHindLeg1.addBox(-6.0F, -9.0F, -8.0F, 11.0F, 31.0F, 17.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 136, 51);
        this.Tail1.setRotationPoint(0.0F, -10.0F, 2.5F);
        this.Tail1.addBox(-7.5F, -7.0F, -7.0F, 16.0F, 18.0F, 49.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.20001473294434044F, 0.0F, -0.0F);
        this.LeftFrontLeg = new ModelRenderer(this, 0, 98);
        this.LeftFrontLeg.setRotationPoint(14.5F, -12.0F, -20.0F);
        this.LeftFrontLeg.addBox(-5.0F, -6.0F, -5.0F, 10.0F, 42.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.NeckAngle = new ModelRenderer(this, 0, 0);
        this.NeckAngle.setRotationPoint(0.0F, 10.0F, -49.0F);
        this.NeckAngle.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(NeckAngle, 0.27314400463445304F, 0.0F, 0.0F);
        this.Spikes = new ModelRenderer(this, 43, 0);
        this.Spikes.setRotationPoint(0.0F, -34.0F, 4.0F);
        this.Spikes.addBox(0.0F, 0.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.RightFrontLeg = new ModelRenderer(this, 0, 98);
        this.RightFrontLeg.mirror = true;
        this.RightFrontLeg.setRotationPoint(-14.5F, -12.0F, -20.0F);
        this.RightFrontLeg.addBox(-5.0F, -6.0F, -5.0F, 10.0F, 42.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 38);
        this.Snout.setRotationPoint(0.0F, 6.0F, -11.0F);
        this.Snout.addBox(-3.5F, 0.0F, -7.0F, 7.0F, 6.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Neck2 = new ModelRenderer(this, 73, 210);
        this.Neck2.setRotationPoint(0.0F, -35.0F, -1.0F);
        this.Neck2.addBox(-4.0F, -34.0F, -10.0F, 8.0F, 37.9F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck2, -0.04991641477611458F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 2);
        this.body.setRotationPoint(0.0F, -15.0F, 26.0F);
        this.body.addBox(-17.5F, -20.0F, -54.0F, 35.0F, 34.0F, 56.0F, 0.0F, 0.0F, 0.0F);
        this.LeftThumb = new ModelRenderer(this, 0, 155);
        this.LeftThumb.setRotationPoint(-5.0F, 35.0F, -2.0F);
        this.LeftThumb.addBox(-3.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.RightHindLeg1 = new ModelRenderer(this, 46, 95);
        this.RightHindLeg1.mirror = true;
        this.RightHindLeg1.setRotationPoint(-14.5F, -17.0F, 17.0F);
        this.RightHindLeg1.addBox(-6.0F, -9.0F, -8.0F, 11.0F, 31.0F, 17.0F, 0.0F, 0.0F, 0.0F);
        this.RightHindLeg3 = new ModelRenderer(this, 0, 156);
        this.RightHindLeg3.mirror = true;
        this.RightHindLeg3.setRotationPoint(0.0F, 20.0F, 1.0F);
        this.RightHindLeg3.addBox(-5.5F, 0.0F, -9.0F, 11.0F, 4.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.LeftHindLeg2 = new ModelRenderer(this, 57, 145);
        this.LeftHindLeg2.setRotationPoint(-0.5F, 17.0F, 1.0F);
        this.LeftHindLeg2.addBox(-5.0F, 0.0F, -5.0F, 10.0F, 20.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftHindLeg2, 0.04991641477611458F, 0.0F, 0.0F);
        this.Head2 = new ModelRenderer(this, 27, 28);
        this.Head2.setRotationPoint(0.0F, 6.0F, -11.0F);
        this.Head2.addBox(-2.5F, -6.0F, -5.0F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, -34.0F, -2.0F);
        this.Head.addBox(-4.5F, 0.0F, -11.0F, 9.0F, 12.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -0.10000736647217022F, 0.0F, 0.0F);
        this.RightThumb = new ModelRenderer(this, 0, 155);
        this.RightThumb.mirror = true;
        this.RightThumb.setRotationPoint(5.0F, 35.0F, -2.0F);
        this.RightThumb.addBox(0.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.RightHindLeg2 = new ModelRenderer(this, 57, 145);
        this.RightHindLeg2.mirror = true;
        this.RightHindLeg2.setRotationPoint(-0.5F, 17.0F, 1.0F);
        this.RightHindLeg2.addBox(-5.0F, 0.0F, -5.0F, 10.0F, 20.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightHindLeg2, 0.04991641477611458F, 0.0F, 0.0F);
        this.LeftHindLeg3 = new ModelRenderer(this, 0, 156);
        this.LeftHindLeg3.setRotationPoint(0.0F, 20.0F, 1.0F);
        this.LeftHindLeg3.addBox(-5.5F, 0.0F, -9.0F, 11.0F, 4.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1.addChild(this.Tail2);
        this.NeckAngle.addChild(this.Neck1);
        this.body.addChild(this.Tail1);
        this.body.addChild(this.NeckAngle);
        this.Neck2.addChild(this.Spikes);
        this.Head.addChild(this.Snout);
        this.Neck1.addChild(this.Neck2);
        this.LeftFrontLeg.addChild(this.LeftThumb);
        this.RightHindLeg2.addChild(this.RightHindLeg3);
        this.LeftHindLeg1.addChild(this.LeftHindLeg2);
        this.Head.addChild(this.Head2);
        this.Neck2.addChild(this.Head);
        this.RightFrontLeg.addChild(this.RightThumb);
        this.RightHindLeg1.addChild(this.RightHindLeg2);
        this.LeftHindLeg2.addChild(this.LeftHindLeg3);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.LeftHindLeg1, this.LeftFrontLeg, this.RightFrontLeg, this.body, this.RightHindLeg1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(CamarasaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float speed = 1.0f;
		float degree = 1.0f;
		if (entityIn.getMotion().x !=  0 && entityIn.getMotion().y != 0 && entityIn.getMotion().z != 0) {
			this.LeftFrontLeg.rotateAngleX = 0;
			this.RightFrontLeg.rotateAngleX = 0;
			this.RightHindLeg1.rotateAngleX = 0;
			this.RightHindLeg2.rotateAngleX = 0;
			this.RightHindLeg3.rotateAngleX = 0;
			this.LeftHindLeg1.rotateAngleX = 0;
			this.LeftHindLeg2.rotateAngleX = 0;
			this.LeftHindLeg3.rotateAngleX = 0;
			this.Neck1.rotateAngleX = 0;
			this.Neck1.rotateAngleY = 0;
			this.Neck2.rotateAngleY = 0;
			this.body.rotateAngleZ = 0;
			this.Tail1.rotateAngleX = 0;
			this.Tail1.rotateAngleY = 0;
			this.Tail1.rotateAngleZ = 0;
			this.Tail2.rotateAngleX = 0;
			this.Tail2.rotateAngleY = 0;
			this.Tail2.rotateAngleZ = 0;
			this.body.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
			this.Tail1.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.2F;
			this.Tail1.rotateAngleY = MathHelper.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount;
			this.Tail1.rotateAngleZ = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
			this.Tail2.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.1F;
			this.Tail2.rotateAngleY = MathHelper.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.5F * limbSwingAmount;
			this.LeftHindLeg1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.5F * limbSwingAmount;
			this.LeftHindLeg2.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.05F;
			this.LeftHindLeg3.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
			this.RightHindLeg1.rotateAngleX = MathHelper.cos(4.0F + limbSwing * speed * 0.3F) * degree * 0.5F * limbSwingAmount;
			this.RightHindLeg2.rotateAngleX = MathHelper.cos(4.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.05F;
			this.RightHindLeg3.rotateAngleX = MathHelper.cos(5.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
			this.LeftFrontLeg.rotateAngleX = MathHelper.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
			this.RightFrontLeg.rotateAngleX = MathHelper.cos(5.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
			this.Neck1.rotateAngleX = (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F) + (headPitch * ((float)Math.PI / 180F));
			this.Neck1.rotateAngleY = (MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float)Math.PI / 180F));
			this.Neck2.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.05F;
			this.Neck2.rotateAngleY = MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount;
			this.Head.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1F;
		} else {
			this.LeftFrontLeg.rotateAngleX = 0;
			this.RightFrontLeg.rotateAngleX = 0;
			this.RightHindLeg1.rotateAngleX = 0;
			this.RightHindLeg2.rotateAngleX = 0;
			this.RightHindLeg3.rotateAngleX = 0;
			this.LeftHindLeg1.rotateAngleX = 0;
			this.LeftHindLeg2.rotateAngleX = 0;
			this.LeftHindLeg3.rotateAngleX = 0;
			this.Neck1.rotateAngleX = 0;
			this.Neck1.rotateAngleY = 0;
			this.Neck2.rotateAngleY = 0;
			this.body.rotateAngleZ = 0;
			this.Tail1.rotateAngleX = 0;
			this.Tail1.rotateAngleY = 0;
			this.Tail1.rotateAngleZ = 0;
			this.Tail2.rotateAngleX = 0;
			this.Tail2.rotateAngleY = 0;
			this.Tail2.rotateAngleZ = 0;
			this.body.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
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
			//this.Head1.rotateAngleX = -Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3));
			//this.Neck1.rotateAngleX = headPitch * ((float)Math.PI / 180F);
			//this.Neck1.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
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
