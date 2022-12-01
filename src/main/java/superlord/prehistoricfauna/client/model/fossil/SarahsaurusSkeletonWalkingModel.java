package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.SarahsaurusSkeletonEntity;

/**
 * Sarahsaurus - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SarahsaurusSkeletonWalkingModel extends EntityModel<SarahsaurusSkeletonEntity> {
	public ModelRenderer Ribs;
    public ModelRenderer RArm;
    public ModelRenderer Tail1Vertabrae;
    public ModelRenderer Vertabrae;
    public ModelRenderer Neck1CervicalRibs;
    public ModelRenderer RLeg1;
    public ModelRenderer LArm;
    public ModelRenderer Shoulders;
    public ModelRenderer LLeg1;
    public ModelRenderer Tail1CaudalRibs;
    public ModelRenderer Tail2Vertabrae;
    public ModelRenderer Tail2CaudalRibs;
    public ModelRenderer Neck;
    public ModelRenderer Neck1Vertabrae;
    public ModelRenderer Skull;
    public ModelRenderer RLeg2;
    public ModelRenderer RFoot;
    public ModelRenderer LLeg2;
    public ModelRenderer LFoot;

    public SarahsaurusSkeletonWalkingModel() {
        this.textureWidth = 64;
        this.textureHeight = 100;
        this.LFoot = new ModelRenderer(this, 19, 27);
        this.LFoot.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.LFoot.addBox(-1.5F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LFoot, 1.9198621771937625F, 0.0F, 0.0F);
        this.Tail2CaudalRibs = new ModelRenderer(this, 18, 28);
        this.Tail2CaudalRibs.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail2CaudalRibs.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.Neck1Vertabrae = new ModelRenderer(this, 2, 27);
        this.Neck1Vertabrae.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.Neck1Vertabrae.addBox(-1.0F, -7.0F, 0.0F, 2.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LLeg2 = new ModelRenderer(this, 27, 31);
        this.LLeg2.mirror = true;
        this.LLeg2.setRotationPoint(0.5F, 8.0F, 4.0F);
        this.LLeg2.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LLeg2, -0.4886921905584123F, 0.0F, 0.0F);
        this.Tail1CaudalRibs = new ModelRenderer(this, 1, 28);
        this.Tail1CaudalRibs.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail1CaudalRibs.addBox(-2.0F, 0.0F, -1.0F, 4.0F, 0.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.Neck1CervicalRibs = new ModelRenderer(this, 46, 3);
        this.Neck1CervicalRibs.setRotationPoint(0.0F, 2.0F, -11.0F);
        this.Neck1CervicalRibs.addBox(-1.0F, 0.0F, -5.0F, 2.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck1CervicalRibs, 0.3434808021188062F, -0.3909537457888271F, 0.0F);
        this.Neck = new ModelRenderer(this, 38, 78);
        this.Neck.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.Neck.addBox(0.0F, -8.0F, -9.0F, 0.0F, 10.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.RLeg1 = new ModelRenderer(this, 41, 28);
        this.RLeg1.mirror = true;
        this.RLeg1.setRotationPoint(-3.0F, 4.7F, 1.5F);
        this.RLeg1.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RLeg1, 0.296705972839036F, 0.2617993877991494F, 0.0F);
        this.Ribs = new ModelRenderer(this, 4, 0);
        this.Ribs.setRotationPoint(0.0F, 7.0F, 2.0F);
        this.Ribs.addBox(-3.5F, 1.0F, -12.0F, 7.0F, 7.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.RArm = new ModelRenderer(this, 22, 52);
        this.RArm.setRotationPoint(-3.0F, 6.5F, -8.5F);
        this.RArm.addBox(-1.1F, -1.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RArm, 0.2617993877991494F, 0.0F, 0.27366763203903305F);
        this.Skull = new ModelRenderer(this, 0, 8);
        this.Skull.setRotationPoint(0.0F, -7.0F, 1.5F);
        this.Skull.addBox(-2.0F, -1.0F, -7.0F, 4.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Skull, -0.35185837453889574F, 0.0F, 0.0F);
        this.LLeg1 = new ModelRenderer(this, 41, 28);
        this.LLeg1.setRotationPoint(3.0F, 4.0F, 1.5F);
        this.LLeg1.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LLeg1, -0.7819074915776542F, -0.3141592653589793F, 0.0F);
        this.Tail2Vertabrae = new ModelRenderer(this, 21, 31);
        this.Tail2Vertabrae.setRotationPoint(0.0F, 0.0F, 12.0F);
        this.Tail2Vertabrae.addBox(0.0F, -1.0F, 0.0F, 0.0F, 4.0F, 17.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2Vertabrae, 0.0F, -0.3127630032889644F, 0.0F);
        this.Tail1Vertabrae = new ModelRenderer(this, 7, 29);
        this.Tail1Vertabrae.setRotationPoint(0.0F, 1.0F, 6.0F);
        this.Tail1Vertabrae.addBox(0.0F, -1.0F, 0.0F, 0.0F, 7.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1Vertabrae, -0.10471975511965977F, -0.27366763203903305F, 0.0F);
        this.RLeg2 = new ModelRenderer(this, 27, 31);
        this.RLeg2.mirror = true;
        this.RLeg2.setRotationPoint(0.5F, 8.0F, 4.0F);
        this.RLeg2.addBox(-2.5F, 0.0F, 0.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.LArm = new ModelRenderer(this, 22, 52);
        this.LArm.mirror = true;
        this.LArm.setRotationPoint(3.0F, 6.0F, -8.5F);
        this.LArm.addBox(-0.9F, -1.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LArm, 0.0F, 0.0F, -0.27366763203903305F);
        this.Vertabrae = new ModelRenderer(this, 7, 67);
        this.Vertabrae.mirror = true;
        this.Vertabrae.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Vertabrae.addBox(0.0F, 0.0F, -12.0F, 0.0F, 10.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.Shoulders = new ModelRenderer(this, 40, 64);
        this.Shoulders.setRotationPoint(0.0F, 1.0F, -5.0F);
        this.Shoulders.addBox(-4.0F, 0.0F, -7.0F, 8.0F, 8.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.RFoot = new ModelRenderer(this, 19, 27);
        this.RFoot.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.RFoot.addBox(-2.5F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RFoot, -0.296705972839036F, 0.0F, 0.0F);
        this.LLeg2.addChild(this.LFoot);
        this.Tail2Vertabrae.addChild(this.Tail2CaudalRibs);
        this.Neck1CervicalRibs.addChild(this.Neck1Vertabrae);
        this.LLeg1.addChild(this.LLeg2);
        this.Tail1Vertabrae.addChild(this.Tail1CaudalRibs);
        this.Ribs.addChild(this.Neck1CervicalRibs);
        this.Neck1CervicalRibs.addChild(this.Neck);
        this.Ribs.addChild(this.RLeg1);
        this.Ribs.addChild(this.RArm);
        this.Neck1Vertabrae.addChild(this.Skull);
        this.Ribs.addChild(this.LLeg1);
        this.Tail1Vertabrae.addChild(this.Tail2Vertabrae);
        this.Ribs.addChild(this.Tail1Vertabrae);
        this.RLeg1.addChild(this.RLeg2);
        this.Ribs.addChild(this.LArm);
        this.Ribs.addChild(this.Vertabrae);
        this.Ribs.addChild(this.Shoulders);
        this.RLeg2.addChild(this.RFoot);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Ribs).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(SarahsaurusSkeletonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
