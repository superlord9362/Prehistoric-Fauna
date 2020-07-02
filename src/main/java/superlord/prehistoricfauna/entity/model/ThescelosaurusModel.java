package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import superlord.prehistoricfauna.entity.EntityThescelosaurus;

/**
 * Thescelosaurus - Weastian
 * Created using Tabula 7.0.1
 */
public class ThescelosaurusModel extends EntityModel<EntityThescelosaurus> {
    public ModelRenderer Body;
    public ModelRenderer RightLeg1;
    public ModelRenderer LeftLeg1;
    public ModelRenderer Head;
    public ModelRenderer Tail1;
    public ModelRenderer LeftArm;
    public ModelRenderer RightArm;
    public ModelRenderer Snout;
    public ModelRenderer Tail2;
    public ModelRenderer RightLeg2;
    public ModelRenderer LeftLeg2;

    public ThescelosaurusModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.RightLeg2 = new ModelRenderer(this, 0, 0);
        this.RightLeg2.setRotationPoint(0.0F, 7.0F, 4.0F);
        this.RightLeg2.addBox(-1.0F, 0.0F, -5.0F, 3, 6, 5, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 10.9F, 0.0F);
        this.Body.addBox(-3.0F, -5.0F, -12.0F, 6, 10, 18, 0.0F);
        this.Tail2 = new ModelRenderer(this, 28, 44);
        this.Tail2.setRotationPoint(0.0F, 1.0F, 14.0F);
        this.Tail2.addBox(-1.0F, -1.0F, -1.0F, 2, 3, 16, 0.0F);
        this.Head = new ModelRenderer(this, 0, 29);
        this.Head.setRotationPoint(0.0F, -1.0F, -12.0F);
        this.Head.addBox(-2.0F, -8.0F, -4.0F, 4, 11, 5, 0.0F);
        this.setRotateAngle(Head, 0.136659280431156F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 54);
        this.Snout.setRotationPoint(0.0F, -7.0F, -4.0F);
        this.Snout.addBox(-1.0F, 0.0F, -4.0F, 2, 3, 4, 0.0F);
        this.LeftArm = new ModelRenderer(this, 32, 0);
        this.LeftArm.setRotationPoint(2.1F, 3.0F, -9.0F);
        this.LeftArm.addBox(0.0F, -1.0F, -1.0F, 1, 8, 3, 0.0F);
        this.setRotateAngle(LeftArm, 0.18203784098300857F, 0.0F, 0.0F);
        this.RightArm = new ModelRenderer(this, 32, 0);
        this.RightArm.setRotationPoint(-2.1F, 3.0F, -9.0F);
        this.RightArm.addBox(-1.0F, -1.0F, -1.0F, 1, 8, 3, 0.0F);
        this.setRotateAngle(RightArm, 0.18203784098300857F, 0.0F, 0.0F);
        this.LeftLeg1 = new ModelRenderer(this, 43, 0);
        this.LeftLeg1.setRotationPoint(3.0F, 10.9F, 0.0F);
        this.LeftLeg1.addBox(-2.0F, -2.0F, -3.0F, 3, 9, 7, 0.0F);
        this.LeftLeg2 = new ModelRenderer(this, 0, 0);
        this.LeftLeg2.setRotationPoint(0.0F, 7.0F, 4.0F);
        this.LeftLeg2.addBox(-2.0F, 0.0F, -5.0F, 3, 6, 5, 0.0F);
        this.RightLeg1 = new ModelRenderer(this, 43, 0);
        this.RightLeg1.setRotationPoint(-3.0F, 10.9F, 0.0F);
        this.RightLeg1.addBox(-1.0F, -2.0F, -3.0F, 3, 9, 7, 0.0F);
        this.Tail1 = new ModelRenderer(this, 3, 30);
        this.Tail1.setRotationPoint(0.0F, -3.0F, 6.0F);
        this.Tail1.addBox(-2.0F, -1.0F, -2.0F, 4, 5, 16, 0.0F);
        this.setRotateAngle(Tail1, -0.045553093477052F, 0.0F, 0.0F);
        this.RightLeg1.addChild(this.RightLeg2);
        this.Tail1.addChild(this.Tail2);
        this.Body.addChild(this.Head);
        this.Head.addChild(this.Snout);
        this.Body.addChild(this.LeftArm);
        this.Body.addChild(this.RightArm);
        this.LeftLeg1.addChild(this.LeftLeg2);
        this.Body.addChild(this.Tail1);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

	@Override
	public void setRotationAngles(EntityThescelosaurus entityIn, float limbSwing, float limbSwingAmount,
			float ageInTicks, float netHeadYaw, float headPitch) {
		      this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
		      this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		      this.RightLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		      this.LeftLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;		
	}

    private final float childBodyScale = 4F;
    private final float childBodyOffsetY = 70;
	
	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
    	if (this.isChild) {
            matrixStackIn.push();
            matrixStackIn.pop();
            matrixStackIn.push();
            float f1 = 1.0F / this.childBodyScale;
            matrixStackIn.scale(f1, f1, f1);
            matrixStackIn.translate(0.0D, (double)(this.childBodyOffsetY / 16.0F), 0.0D);
            this.getBodyParts().forEach((p_228229_8_) -> {
               p_228229_8_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
            });
            matrixStackIn.pop();
         } else {
        this.Body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.LeftLeg1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        this.RightLeg1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
         }
	}
	
    protected Iterable<ModelRenderer> getBodyParts() {
    	return ImmutableList.of(this.Body, this.LeftLeg1, this.RightLeg1);
    }
    
}
