package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.DryosaurusEntity;

/**
 * Dryosaurus - superlord9362
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class Dryosaurus extends EntityModel<DryosaurusEntity> {
    public ModelRenderer Body;
    public ModelRenderer Tail1;
    public ModelRenderer RLeg1;
    public ModelRenderer RArm;
    public ModelRenderer LLeg1;
    public ModelRenderer LArm;
    public ModelRenderer Neck;
    public ModelRenderer Tail2;
    public ModelRenderer RLeg2;
    public ModelRenderer LLeg2;
    public ModelRenderer Head;
    public ModelRenderer Snout;

    public Dryosaurus() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.RLeg2 = new ModelRenderer(this, 0, 0);
        this.RLeg2.setRotationPoint(-0.5F, 6.0F, 3.0F);
        this.RLeg2.addBox(-1.0F, 0.0F, -3.0F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 47);
        this.Head.setRotationPoint(0.0F, -3.0F, -1.0F);
        this.Head.addBox(-1.5F, -3.0F, -4.0F, 3.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.RArm = new ModelRenderer(this, 49, 0);
        this.RArm.setRotationPoint(3.0F, 7.0F, 3.0F);
        this.RArm.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 50, 0);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 15.0F);
        this.Tail2.addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 0, 27);
        this.Tail1.setRotationPoint(0.0F, 3.5F, 19.0F);
        this.Tail1.addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 11);
        this.Snout.setRotationPoint(0.0F, -1.0F, -4.0F);
        this.Snout.addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 27);
        this.Neck.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.Neck.addBox(-1.5F, -3.0F, -3.0F, 3.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LLeg2 = new ModelRenderer(this, 0, 0);
        this.LLeg2.mirror = true;
        this.LLeg2.setRotationPoint(0.5F, 6.0F, 3.0F);
        this.LLeg2.addBox(-1.0F, 0.0F, -3.0F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 5.0F, -10.0F);
        this.Body.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 8.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.LLeg1 = new ModelRenderer(this, 31, 0);
        this.LLeg1.mirror = true;
        this.LLeg1.setRotationPoint(-3.0F, 5.0F, 14.0F);
        this.LLeg1.addBox(-1.0F, -3.0F, -3.0F, 3.0F, 9.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.LArm = new ModelRenderer(this, 49, 0);
        this.LArm.mirror = true;
        this.LArm.setRotationPoint(-3.0F, 7.0F, 3.0F);
        this.LArm.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.RLeg1 = new ModelRenderer(this, 31, 0);
        this.RLeg1.setRotationPoint(3.0F, 5.0F, 14.0F);
        this.RLeg1.addBox(-2.0F, -3.0F, -3.0F, 3.0F, 9.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.RLeg1.addChild(this.RLeg2);
        this.Neck.addChild(this.Head);
        this.Body.addChild(this.RArm);
        this.Tail1.addChild(this.Tail2);
        this.Body.addChild(this.Tail1);
        this.Head.addChild(this.Snout);
        this.Body.addChild(this.Neck);
        this.LLeg1.addChild(this.LLeg2);
        this.Body.addChild(this.LLeg1);
        this.Body.addChild(this.LArm);
        this.Body.addChild(this.RLeg1);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(DryosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.RLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.Tail1.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
		this.Tail2.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
		this.Tail1.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
		this.Tail2.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
		this.Neck.rotateAngleX = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)));
		this.LArm.rotateAngleZ = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
		this.RArm.rotateAngleZ = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
		this.Neck.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
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
