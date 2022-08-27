package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.PlesiohadrosEntity;

/**
 * Plesiohadros - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class PlesiohadrosModel extends EntityModel<PlesiohadrosEntity> {
    public ModelRenderer Body;
    public ModelRenderer LegFrontL;
    public ModelRenderer LegFrontR;
    public ModelRenderer ThighL;
    public ModelRenderer ThighR;
    public ModelRenderer BodyBack;
    public ModelRenderer Neck;
    public ModelRenderer TailBase;
    public ModelRenderer TailTip;
    public ModelRenderer SpikesTailBese;
    public ModelRenderer SpikesTailTip;
    public ModelRenderer Head;
    public ModelRenderer Beak;
    public ModelRenderer Nose;
    public ModelRenderer LegBackL;
    public ModelRenderer FeetL;
    public ModelRenderer LegBackR;
    public ModelRenderer FeetR;

    public PlesiohadrosModel() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.SpikesTailTip = new ModelRenderer(this, 43, 84);
        this.SpikesTailTip.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.SpikesTailTip.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 28.0F, 0.0F, 0.0F, 0.0F);
        this.Nose = new ModelRenderer(this, 48, 0);
        this.Nose.setRotationPoint(0.0F, -2.0F, -1.0F);
        this.Nose.addBox(-2.5F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.TailBase = new ModelRenderer(this, 54, 30);
        this.TailBase.setRotationPoint(0.0F, -2.0F, 21.0F);
        this.TailBase.addBox(-3.5F, -5.0F, -1.0F, 7.0F, 12.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.SpikesTailBese = new ModelRenderer(this, 48, 100);
        this.SpikesTailBese.setRotationPoint(0.0F, -6.0F, 1.0F);
        this.SpikesTailBese.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.FeetL = new ModelRenderer(this, 130, 20);
        this.FeetL.setRotationPoint(0.0F, 11.0F, 1.1F);
        this.FeetL.addBox(-2.5F, 0.0F, -4.01F, 5.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.LegBackR = new ModelRenderer(this, 130, 0);
        this.LegBackR.mirror = true;
        this.LegBackR.setRotationPoint(-1.5F, 13.0F, 7.0F);
        this.LegBackR.addBox(-2.0F, -1.0F, -1.0F, 4.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.TailTip = new ModelRenderer(this, 34, 70);
        this.TailTip.setRotationPoint(0.0F, -1.0F, 20.0F);
        this.TailTip.addBox(-2.5F, -3.0F, -2.0F, 5.0F, 6.0F, 31.0F, 0.0F, 0.0F, 0.0F);
        this.LegFrontL = new ModelRenderer(this, 89, 70);
        this.LegFrontL.setRotationPoint(4.0F, 5.0F, -8.0F);
        this.LegFrontL.addBox(0.0F, -1.0F, -2.0F, 3.0F, 20.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.ThighR = new ModelRenderer(this, 94, 0);
        this.ThighR.mirror = true;
        this.ThighR.setRotationPoint(-5.0F, -2.0F, 7.0F);
        this.ThighR.addBox(-4.0F, -3.0F, -3.0F, 5.0F, 20.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 49);
        this.Body.setRotationPoint(0.0F, -2.0F, -9.0F);
        this.Body.addBox(-5.0F, -6.0F, -6.0F, 10.0F, 19.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.LegFrontR = new ModelRenderer(this, 89, 70);
        this.LegFrontR.mirror = true;
        this.LegFrontR.setRotationPoint(-4.0F, 5.0F, -8.0F);
        this.LegFrontR.addBox(-3.0F, -1.0F, -2.0F, 3.0F, 20.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.BodyBack = new ModelRenderer(this, 0, 0);
        this.BodyBack.setRotationPoint(0.0F, 0.0F, 10.0F);
        this.BodyBack.addBox(-6.5F, -8.0F, 0.0F, 13.0F, 22.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 56, 0);
        this.Head.setRotationPoint(0.0F, -2.0F, -12.0F);
        this.Head.addBox(-3.0F, -2.01F, -3.0F, 6.0F, 6.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 114, 30);
        this.Neck.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.Neck.addBox(-2.0F, -4.0F, -12.0F, 4.0F, 10.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.LegBackL = new ModelRenderer(this, 130, 0);
        this.LegBackL.setRotationPoint(1.5F, 13.0F, 7.0F);
        this.LegBackL.addBox(-2.0F, -1.0F, -1.0F, 4.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Beak = new ModelRenderer(this, 85, 0);
        this.Beak.setRotationPoint(0.0F, 3.0F, -3.0F);
        this.Beak.addBox(-2.0F, -3.0F, -5.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.FeetR = new ModelRenderer(this, 130, 20);
        this.FeetR.mirror = true;
        this.FeetR.setRotationPoint(0.0F, 11.0F, 1.1F);
        this.FeetR.addBox(-2.5F, 0.0F, -4.0F, 5.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.ThighL = new ModelRenderer(this, 94, 0);
        this.ThighL.setRotationPoint(5.0F, -2.0F, 7.0F);
        this.ThighL.addBox(-1.0F, -3.0F, -3.0F, 5.0F, 20.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.TailTip.addChild(this.SpikesTailTip);
        this.Beak.addChild(this.Nose);
        this.BodyBack.addChild(this.TailBase);
        this.TailBase.addChild(this.SpikesTailBese);
        this.LegBackL.addChild(this.FeetL);
        this.ThighR.addChild(this.LegBackR);
        this.TailBase.addChild(this.TailTip);
        this.Body.addChild(this.BodyBack);
        this.Neck.addChild(this.Head);
        this.Body.addChild(this.Neck);
        this.ThighL.addChild(this.LegBackL);
        this.Head.addChild(this.Beak);
        this.LegBackR.addChild(this.FeetR);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.LegFrontL, this.ThighR, this.Body, this.LegFrontR, this.ThighL).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(PlesiohadrosEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float speed = 0.9f;
		float degree = 1.0f;
		this.Body.rotateAngleX = 0F;
		this.LegFrontL.rotateAngleZ = -0F;
		this.LegFrontR.rotateAngleZ = 0F;
		this.LegFrontL.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
		this.LegFrontR.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
		this.ThighR.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
		this.LegBackR.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
		this.FeetR.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
		this.ThighL.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
		this.LegBackL.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
		this.FeetL.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
		this.TailBase.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
		this.TailTip.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
		this.TailBase.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
		this.TailTip.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
		this.Neck.rotateAngleX = (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F);
		this.Head.rotateAngleX = (-Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.05F);
		if (entityIn.isEating()) {
			this.Neck.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
			this.Body.rotateAngleX = 0.2F;
			this.LegFrontL.rotateAngleZ = -0.2F;
			this.LegFrontR.rotateAngleZ = 0.2F;
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
