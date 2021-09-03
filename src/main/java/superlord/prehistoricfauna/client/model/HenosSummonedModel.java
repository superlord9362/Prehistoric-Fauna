package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.TimeGuardianEntity;

/**
 * Henos - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class HenosSummonedModel extends EntityModel<TimeGuardianEntity> {
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
    public ModelRenderer Mouth;

    public HenosSummonedModel() {
        this.textureWidth = 250;
        this.textureHeight = 128;
        this.LOFinger = new ModelRenderer(this, 1, 44);
        this.LOFinger.setRotationPoint(-12.0F, 21.0F, -7.0F);
        this.LOFinger.addBox(0.0F, 0.0F, 0.0F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LArm = new ModelRenderer(this, 4, 46);
        this.LArm.mirror = true;
        this.LArm.setRotationPoint(-2.0F, 9.0F, 11.0F);
        this.LArm.addBox(-12.0F, -4.0F, -7.0F, 12.0F, 24.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.RIFinger = new ModelRenderer(this, 1, 44);
        this.RIFinger.setRotationPoint(0.0F, 21.0F, -7.0F);
        this.RIFinger.addBox(0.0F, 0.0F, 0.0F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LThumb = new ModelRenderer(this, 1, 44);
        this.LThumb.setRotationPoint(1.0F, 16.0F, -5.0F);
        this.LThumb.addBox(0.0F, 0.0F, 0.0F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LLeg = new ModelRenderer(this, 56, 64);
        this.LLeg.mirror = true;
        this.LLeg.setRotationPoint(-4.0F, 7.0F, 0.0F);
        this.LLeg.addBox(-9.0F, -1.0F, -4.0F, 9.0F, 17.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(-17.0F, -20.0F, -11.0F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 34.0F, 21.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.Hips = new ModelRenderer(this, 56, 42);
        this.Hips.setRotationPoint(17.0F, 21.0F, 11.0F);
        this.Hips.addBox(-8.0F, 0.0F, -6.0F, 16.0F, 9.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.RMFinger = new ModelRenderer(this, 1, 44);
        this.RMFinger.setRotationPoint(4.5F, 21.0F, -7.0F);
        this.RMFinger.addBox(0.0F, 0.0F, 0.0F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Mouth = new ModelRenderer(this, 183, 86);
        this.Mouth.setRotationPoint(0.0F, -7.0F, -10.0F);
        this.Mouth.addBox(-8.0F, -3.0F, -4.0F, 16.0F, 15.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.RThumb = new ModelRenderer(this, 1, 44);
        this.RThumb.setRotationPoint(-4.0F, 16.0F, -5.0F);
        this.RThumb.addBox(0.0F, 0.0F, 0.0F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LMFinger = new ModelRenderer(this, 1, 44);
        this.LMFinger.setRotationPoint(-7.5F, 21.0F, -7.0F);
        this.LMFinger.addBox(0.0F, 0.0F, 0.0F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 158, 0);
        this.Head.setRotationPoint(17.0F, 0.0F, 5.0F);
        this.Head.addBox(-7.0F, -27.0F, -12.0F, 14.0F, 32.0F, 32.0F, 0.0F, 0.0F, 0.0F);
        this.RArm = new ModelRenderer(this, 4, 46);
        this.RArm.setRotationPoint(36.0F, 9.0F, 11.0F);
        this.RArm.addBox(0.0F, -4.0F, -7.0F, 12.0F, 24.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.ROFinger = new ModelRenderer(this, 1, 44);
        this.ROFinger.setRotationPoint(9.0F, 21.0F, -7.0F);
        this.ROFinger.addBox(0.0F, 0.0F, 0.0F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LIFinger = new ModelRenderer(this, 1, 44);
        this.LIFinger.setRotationPoint(-3.0F, 21.0F, -7.0F);
        this.LIFinger.addBox(0.0F, 0.0F, 0.0F, 3.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.RLeg = new ModelRenderer(this, 56, 64);
        this.RLeg.setRotationPoint(4.0F, 7.0F, 0.0F);
        this.RLeg.addBox(0.0F, -1.0F, -4.0F, 9.0F, 17.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.LArm.addChild(this.LOFinger);
        this.Body.addChild(this.LArm);
        this.RArm.addChild(this.RIFinger);
        this.LArm.addChild(this.LThumb);
        this.Hips.addChild(this.LLeg);
        this.Body.addChild(this.Hips);
        this.RArm.addChild(this.RMFinger);
        this.Head.addChild(this.Mouth);
        this.RArm.addChild(this.RThumb);
        this.LArm.addChild(this.LMFinger);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.RArm);
        this.RArm.addChild(this.ROFinger);
        this.LArm.addChild(this.LIFinger);
        this.Hips.addChild(this.RLeg);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(TimeGuardianEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.RLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.LLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        float attackRight = entityIn.getMeleeProgress(false, ageInTicks - entityIn.ticksExisted) / 5.0F;
        float attackLeft = entityIn.getMeleeProgress(true, ageInTicks - entityIn.ticksExisted) / 5.0F;
        float attack = Math.max(attackLeft, attackRight);
        float rightFingerCurl = attackRight * (float)Math.toRadians(80);
        float leftFingerCurl = attackLeft * (float)Math.toRadians(80);
        float bodyYaw = attack * (float)Math.toRadians(20);
        this.LArm.rotateAngleX = attackLeft * (float)Math.toRadians(-100) + (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount) * (1.0F - attack);
        this.LArm.rotateAngleY = leftFingerCurl * -0.25F;
        this.LArm.rotateAngleZ = leftFingerCurl * 0.15F;
        this.RArm.rotateAngleX = attackRight * (float)Math.toRadians(-100) + (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount) * (1.0F - attack);
        this.RArm.rotateAngleY = rightFingerCurl * 0.25F;
        this.RArm.rotateAngleZ = rightFingerCurl * -0.15F;
        this.RIFinger.rotateAngleX = rightFingerCurl;
        this.ROFinger.rotateAngleX = rightFingerCurl;
        this.RMFinger.rotateAngleX = rightFingerCurl;
        this.RThumb.rotateAngleX = rightFingerCurl;
        this.LIFinger.rotateAngleX = leftFingerCurl;
        this.LOFinger.rotateAngleX = leftFingerCurl;
        this.LMFinger.rotateAngleX = leftFingerCurl;
        this.LThumb.rotateAngleX = leftFingerCurl;
        this.RArm.rotationPointX = 36.0F + attackRight * -5;
        this.RArm.rotationPointZ = 11.0F + attackRight * -16;
        this.RThumb.rotationPointX = -1.0F + attackRight * 1;
        this.RThumb.rotationPointY = 11.0F + attackRight * 2;
        this.LArm.rotationPointX = -2.0F - attackLeft * -5;
        this.LArm.rotationPointZ = 11.0F + attackLeft * -16;
        this.LThumb.rotationPointX = 1.0F - attackLeft * 1;
        this.LThumb.rotationPointY = 11.0F + attackLeft * 2;
        this.Body.rotateAngleY = attackLeft * (float)Math.toRadians(-20) + attackRight * (float)Math.toRadians(20);
        this.Body.rotationPointY = -20.0F + attack * 5;
        this.Body.rotationPointZ = -11.0F - attack * 8;
        this.Body.rotateAngleX = bodyYaw;
        this.Hips.rotateAngleX = -bodyYaw;
        this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F) - bodyYaw;
        this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F) - this.Body.rotateAngleY;
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
