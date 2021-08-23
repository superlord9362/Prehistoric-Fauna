package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.HyperodapedonEntity;

/**
 * Hyperodapedon - superlord9362
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class HyperodapedonModel extends EntityModel<HyperodapedonEntity> {
    public ModelRenderer Body;
    public ModelRenderer Head;
    public ModelRenderer RArm;
    public ModelRenderer LArm;
    public ModelRenderer RLeg;
    public ModelRenderer LLeg;
    public ModelRenderer Tail;
    public ModelRenderer Snout;

    public HyperodapedonModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 19.0F, -5.0F);
        this.Body.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 13);
        this.Head.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Head.addBox(-2.5F, -1.5F, -3.0F, 5.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.RArm = new ModelRenderer(this, 0, 0);
        this.RArm.setRotationPoint(1.0F, 3.0F, 1.01F);
        this.RArm.addBox(0.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 19);
        this.Snout.setRotationPoint(-1.0F, 0.0F, -4.0F);
        this.Snout.addBox(-0.5F, -0.5F, 0.0F, 3.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.LArm = new ModelRenderer(this, 0, 0);
        this.LArm.mirror = true;
        this.LArm.setRotationPoint(-1.0F, 3.0F, 1.01F);
        this.LArm.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.RLeg = new ModelRenderer(this, 18, 0);
        this.RLeg.setRotationPoint(1.0F, 2.0F, 8.0F);
        this.RLeg.addBox(0.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.LLeg = new ModelRenderer(this, 18, 0);
        this.LLeg.mirror = true;
        this.LLeg.setRotationPoint(-1.0F, 2.0F, 8.0F);
        this.LLeg.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 19, 0);
        this.Tail.setRotationPoint(0.0F, 2.0F, 10.0F);
        this.Tail.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.RArm);
        this.Head.addChild(this.Snout);
        this.Body.addChild(this.LArm);
        this.Body.addChild(this.RLeg);
        this.Body.addChild(this.LLeg);
        this.Body.addChild(this.Tail);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(HyperodapedonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
    	this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
    	this.RLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.LLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.RArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.LArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
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
