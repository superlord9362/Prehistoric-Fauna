package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.IschigualastiaEntity;

/**
 * Diictodont - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class Ischigualastia extends EntityModel<IschigualastiaEntity> {
    public ModelRenderer Body;
    public ModelRenderer Tail;
    public ModelRenderer Neck;
    public ModelRenderer ArmL;
    public ModelRenderer ArmR;
    public ModelRenderer LegL;
    public ModelRenderer LegR;
    public ModelRenderer Face;

    public Ischigualastia() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.Neck = new ModelRenderer(this, 0, 64);
        this.Neck.setRotationPoint(0.0F, -6.0F, -23.0F);
        this.Neck.addBox(-6.0F, -6.0F, -13.0F, 12.0F, 14.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.LegL = new ModelRenderer(this, 62, 63);
        this.LegL.setRotationPoint(7.0F, -2.0F, 3.0F);
        this.LegL.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 17.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.LegR = new ModelRenderer(this, 62, 63);
        this.LegR.setRotationPoint(-7.0F, -2.0F, 3.0F);
        this.LegR.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 17.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.ArmR = new ModelRenderer(this, 62, 99);
        this.ArmR.setRotationPoint(-7.0F, -2.0F, -18.0F);
        this.ArmR.addBox(-4.0F, 0.0F, -4.0F, 6.0F, 17.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 100, 0);
        this.Tail.setRotationPoint(0.0F, -9.0F, 9.0F);
        this.Tail.addBox(-4.5F, -3.0F, 0.0F, 9.0F, 7.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.ArmL = new ModelRenderer(this, 62, 99);
        this.ArmL.setRotationPoint(7.0F, -2.0F, -18.0F);
        this.ArmL.addBox(-2.0F, 0.0F, -4.0F, 6.0F, 17.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Face = new ModelRenderer(this, 0, 99);
        this.Face.setRotationPoint(0.0F, 2.0F, -13.0F);
        this.Face.addBox(-4.5F, -6.0F, -8.0F, 9.0F, 12.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 9.0F, 8.0F);
        this.Body.addBox(-10.0F, -16.0F, -24.0F, 20.0F, 22.0F, 34.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.LegL);
        this.Body.addChild(this.LegR);
        this.Body.addChild(this.ArmR);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.ArmL);
        this.Neck.addChild(this.Face);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(IschigualastiaEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	this.Neck.rotateAngleX = headPitch * ((float)Math.PI / 180F);
    	this.Neck.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
    	this.LegR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.LegL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.ArmR.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.ArmL.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
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
