package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.DidelphodonEntity;

/**
 * Didelphodon - Weastian
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class DidelphodonModel extends EntityModel<DidelphodonEntity> implements IHasArm {
    public ModelRenderer Body;
    public ModelRenderer Frontlegright;
    public ModelRenderer Frontlegleft;
    public ModelRenderer Hindlegleft;
    public ModelRenderer Hindlegright;
    public ModelRenderer Head;
    public ModelRenderer Tail;
    public ModelRenderer Snout;
    public ModelRenderer EarRight;
    public ModelRenderer EarLeft;
    public ModelRenderer Nose;

    public DidelphodonModel() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.Head = new ModelRenderer(this, 9, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.Head.addBox(-1.5F, -1.0F, -4.0F, 3.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Hindlegright = new ModelRenderer(this, 16, 8);
        this.Hindlegright.setRotationPoint(-0.9F, 21.0F, 2.9F);
        this.Hindlegright.addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 0, 7);
        this.Tail.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.Tail.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.13665927909957545F, 0.0F, 0.0F);
        this.Frontlegright = new ModelRenderer(this, 16, 8);
        this.Frontlegright.setRotationPoint(-0.9F, 21.0F, -2.9F);
        this.Frontlegright.addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Frontlegleft = new ModelRenderer(this, 16, 8);
        this.Frontlegleft.setRotationPoint(0.9F, 21.0F, -2.9F);
        this.Frontlegleft.addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 2, 0);
        this.Snout.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.Snout.addBox(-1.5F, -1.0F, -2.0F, 3.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Nose = new ModelRenderer(this, 0, 0);
        this.Nose.setRotationPoint(0.0F, -1.0F, -2.0F);
        this.Nose.addBox(-0.5F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.Hindlegleft = new ModelRenderer(this, 16, 8);
        this.Hindlegleft.setRotationPoint(0.9F, 21.0F, 2.9F);
        this.Hindlegleft.addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.EarRight = new ModelRenderer(this, 21, 2);
        this.EarRight.setRotationPoint(-1.5F, -1.0F, -1.0F);
        this.EarRight.addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.EarLeft = new ModelRenderer(this, 21, 2);
        this.EarLeft.setRotationPoint(1.5F, -1.0F, -1.0F);
        this.EarLeft.addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 20);
        this.Body.setRotationPoint(0.0F, 19.0F, 2.0F);
        this.Body.addBox(-2.0F, -1.0F, -6.0F, 4.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.Tail);
        this.Head.addChild(this.Snout);
        this.Snout.addChild(this.Nose);
        this.Head.addChild(this.EarRight);
        this.Head.addChild(this.EarLeft);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Hindlegright, this.Frontlegright, this.Frontlegleft, this.Hindlegleft, this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(DidelphodonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.rotateAngleX = 0;
    	this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.Hindlegright.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.Hindlegleft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.Frontlegright.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.Frontlegleft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    public void translateHand(HandSide sideIn, MatrixStack matrixStackIn) {
		float f = sideIn == HandSide.RIGHT ? 1.0F : -1.0F;
		ModelRenderer modelrenderer = this.getArmForSide(sideIn);
		modelrenderer.rotationPointX += f;
		modelrenderer.translateRotate(matrixStackIn);
		modelrenderer.rotationPointX -= f;
		matrixStackIn.translate(0, 0.7, 0);
	}

	protected ModelRenderer getArmForSide(HandSide side) {
		return side == HandSide.LEFT ? this.Head : this.Head;
	}
	
}
