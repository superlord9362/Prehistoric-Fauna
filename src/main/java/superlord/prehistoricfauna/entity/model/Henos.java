package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.TimeGuardianEntity;

/**
 * Henos - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class Henos extends EntityModel<TimeGuardianEntity> {
    public ModelRenderer Body;
    public ModelRenderer RArm;
    public ModelRenderer LArm;
    public ModelRenderer Hips;
    public ModelRenderer Head;
    public ModelRenderer ROFinger;
    public ModelRenderer RIFinger;
    public ModelRenderer RMFinger;
    public ModelRenderer RThumb;
    public ModelRenderer LThumb;
    public ModelRenderer LOFinger;
    public ModelRenderer LMFinger;
    public ModelRenderer LIFinger;
    public ModelRenderer LLeg;
    public ModelRenderer RLeg;
    public ModelRenderer REar;
    public ModelRenderer Mouth;
    public ModelRenderer LEar;

    public Henos() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.RArm = new ModelRenderer(this, 0, 42);
        this.RArm.setRotationPoint(36.0F, 13.0F, 11.0F);
        this.RArm.addBox(0.0F, -4.0F, -7.0F, 14.0F, 20.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.LThumb = new ModelRenderer(this, 1, 44);
        this.LThumb.setRotationPoint(1.0F, 11.0F, -3.5F);
        this.LThumb.addBox(0.0F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 76);
        this.Head.setRotationPoint(17.0F, 1.0F, 5.0F);
        this.Head.addBox(-6.0F, -7.0F, -12.0F, 12.0F, 14.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.RMFinger = new ModelRenderer(this, 1, 44);
        this.RMFinger.setRotationPoint(7.5F, 17.0F, -5.5F);
        this.RMFinger.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(-17.0F, -20.0F, -11.0F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 34.0F, 21.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.ROFinger = new ModelRenderer(this, 1, 44);
        this.ROFinger.setRotationPoint(12.5F, 17.0F, -5.5F);
        this.ROFinger.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Hips = new ModelRenderer(this, 56, 42);
        this.Hips.setRotationPoint(17.0F, 21.0F, 11.0F);
        this.Hips.addBox(-8.0F, 0.0F, -6.0F, 16.0F, 9.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.LIFinger = new ModelRenderer(this, 1, 44);
        this.LIFinger.setRotationPoint(-2.5F, 17.0F, -5.5F);
        this.LIFinger.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LEar = new ModelRenderer(this, 37, 77);
        this.LEar.mirror = true;
        this.LEar.setRotationPoint(-6.0F, -3.0F, -7.0F);
        this.LEar.addBox(-6.0F, -3.0F, -1.0F, 6.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.RLeg = new ModelRenderer(this, 56, 64);
        this.RLeg.setRotationPoint(4.0F, 7.0F, 0.0F);
        this.RLeg.addBox(0.0F, -1.0F, -4.0F, 9.0F, 17.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Mouth = new ModelRenderer(this, 49, 91);
        this.Mouth.setRotationPoint(0.0F, 5.0F, -12.0F);
        this.Mouth.addBox(-10.0F, -3.0F, -4.0F, 20.0F, 7.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.LOFinger = new ModelRenderer(this, 1, 44);
        this.LOFinger.setRotationPoint(-12.5F, 17.0F, -5.5F);
        this.LOFinger.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LLeg = new ModelRenderer(this, 56, 64);
        this.LLeg.setRotationPoint(-4.0F, 7.0F, 0.0F);
        this.LLeg.addBox(-9.0F, -1.0F, -4.0F, 9.0F, 17.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.LArm = new ModelRenderer(this, 0, 42);
        this.LArm.setRotationPoint(-2.0F, 13.0F, 11.0F);
        this.LArm.addBox(-14.0F, -4.0F, -7.0F, 14.0F, 20.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.RThumb = new ModelRenderer(this, 1, 44);
        this.RThumb.setRotationPoint(-1.0F, 11.0F, -3.5F);
        this.RThumb.addBox(-3.0F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.RIFinger = new ModelRenderer(this, 1, 44);
        this.RIFinger.setRotationPoint(2.5F, 17.0F, -5.5F);
        this.RIFinger.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.REar = new ModelRenderer(this, 37, 77);
        this.REar.setRotationPoint(6.0F, -3.0F, -7.0F);
        this.REar.addBox(0.0F, -3.0F, -1.0F, 6.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LMFinger = new ModelRenderer(this, 1, 44);
        this.LMFinger.setRotationPoint(-7.5F, 17.0F, -5.5F);
        this.LMFinger.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.RArm);
        this.LArm.addChild(this.LThumb);
        this.Body.addChild(this.Head);
        this.RArm.addChild(this.RMFinger);
        this.RArm.addChild(this.ROFinger);
        this.Body.addChild(this.Hips);
        this.LArm.addChild(this.LIFinger);
        this.Head.addChild(this.LEar);
        this.Hips.addChild(this.RLeg);
        this.Head.addChild(this.Mouth);
        this.LArm.addChild(this.LOFinger);
        this.Hips.addChild(this.LLeg);
        this.Body.addChild(this.LArm);
        this.RArm.addChild(this.RThumb);
        this.RArm.addChild(this.RIFinger);
        this.Head.addChild(this.REar);
        this.LArm.addChild(this.LMFinger);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(TimeGuardianEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
    	this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
    	this.RLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.LLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;		
    	this.LArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.RArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;	
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
