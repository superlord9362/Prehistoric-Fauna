package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.TrilobiteSentinelEntity;

/**
 * Sentinel - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SentinelTrilobiteModel<T extends TrilobiteSentinelEntity> extends EntityModel<T> {
	public ModelRenderer Cephalon;
    public ModelRenderer Cranidium;
    public ModelRenderer Thorax;
    public ModelRenderer Antenna;
    public ModelRenderer Antenna2;
    public ModelRenderer AxialLobe;
    public ModelRenderer PleuralSpineLeft;
    public ModelRenderer PleuralSpine2Left;
    public ModelRenderer PleuralSpine3;
    public ModelRenderer PleuralSpineRight;
    public ModelRenderer PleuralSpine2Right;
    public ModelRenderer PleuralSpine3Right;

    public SentinelTrilobiteModel() {
    	this.textureWidth = 200;
        this.textureHeight = 200;
        this.PleuralSpine2Left = new ModelRenderer(this, 20, 19);
        this.PleuralSpine2Left.setRotationPoint(5.0F, 0.0F, 8.0F);
        this.PleuralSpine2Left.addBox(0.0F, -1.0F, -2.0F, 5.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Thorax = new ModelRenderer(this, 106, 0);
        this.Thorax.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Thorax.addBox(-8.0F, 0.0F, 0.0F, 16.0F, 4.0F, 17.0F, 0.0F, 0.0F, 0.0F);
        this.PleuralSpine3Right = new ModelRenderer(this, 21, 19);
        this.PleuralSpine3Right.mirror = true;
        this.PleuralSpine3Right.setRotationPoint(-5.0F, 0.0F, 13.0F);
        this.PleuralSpine3Right.addBox(-4.0F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Antenna = new ModelRenderer(this, -11, 27);
        this.Antenna.setRotationPoint(6.5F, 3.0F, -15.0F);
        this.Antenna.addBox(-0.5F, 0.0F, -3.0F, 11.0F, 0.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.AxialLobe = new ModelRenderer(this, 155, 0);
        this.AxialLobe.setRotationPoint(0.0F, -2.0F, 1.0F);
        this.AxialLobe.addBox(-4.0F, 0.0F, 0.0F, 8.0F, 2.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.PleuralSpineRight = new ModelRenderer(this, 0, 19);
        this.PleuralSpineRight.mirror = true;
        this.PleuralSpineRight.setRotationPoint(-5.0F, 0.0F, 3.0F);
        this.PleuralSpineRight.addBox(-6.0F, -1.0F, -2.0F, 6.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Cephalon = new ModelRenderer(this, 0, 0);
        this.Cephalon.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.Cephalon.addBox(-12.0F, 0.0F, -15.0F, 24.0F, 4.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.PleuralSpine2Right = new ModelRenderer(this, 20, 19);
        this.PleuralSpine2Right.mirror = true;
        this.PleuralSpine2Right.setRotationPoint(-5.0F, 0.0F, 8.0F);
        this.PleuralSpine2Right.addBox(-5.0F, -1.0F, -2.0F, 5.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.PleuralSpineLeft = new ModelRenderer(this, 0, 19);
        this.PleuralSpineLeft.setRotationPoint(5.0F, 0.0F, 3.0F);
        this.PleuralSpineLeft.addBox(0.0F, -1.0F, -2.0F, 6.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Cranidium = new ModelRenderer(this, 63, 0);
        this.Cranidium.setRotationPoint(0.0F, -2.0F, -10.0F);
        this.Cranidium.addBox(-10.0F, 0.0F, 0.0F, 20.0F, 2.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Antenna2 = new ModelRenderer(this, -11, 27);
        this.Antenna2.mirror = true;
        this.Antenna2.setRotationPoint(-6.5F, 3.0F, -15.0F);
        this.Antenna2.addBox(-10.5F, 0.0F, -3.0F, 11.0F, 0.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.PleuralSpine3 = new ModelRenderer(this, 21, 19);
        this.PleuralSpine3.setRotationPoint(5.0F, 0.0F, 13.0F);
        this.PleuralSpine3.addBox(0.0F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Thorax.addChild(this.PleuralSpine2Left);
        this.Cephalon.addChild(this.Thorax);
        this.Thorax.addChild(this.PleuralSpine3Right);
        this.Cephalon.addChild(this.Antenna);
        this.Thorax.addChild(this.AxialLobe);
        this.Thorax.addChild(this.PleuralSpineRight);
        this.Thorax.addChild(this.PleuralSpine2Right);
        this.Thorax.addChild(this.PleuralSpineLeft);
        this.Cephalon.addChild(this.Cranidium);
        this.Cephalon.addChild(this.Antenna2);
        this.Thorax.addChild(this.PleuralSpine3);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Cephalon).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(TrilobiteSentinelEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float walkSpeed = 1.0f;
        float walkDegree = 0.5f;
		this.Antenna.rotateAngleX = -0.025F * MathHelper.sin(0.1F * ageInTicks);
		this.Antenna2.rotateAngleX = -0.025F * MathHelper.sin(0.1F * ageInTicks);
		this.PleuralSpineLeft.rotateAngleZ = MathHelper.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 1F * limbSwingAmount;
		this.PleuralSpineRight.rotateAngleZ = -(MathHelper.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 1F * limbSwingAmount);
		this.PleuralSpine2Left.rotateAngleZ = MathHelper.cos(limbSwing * walkSpeed * 0.3F + 1) * walkDegree * 1F * limbSwingAmount;
		this.PleuralSpine2Right.rotateAngleZ = -(MathHelper.cos(limbSwing * walkSpeed * 0.3F + 1) * walkDegree * 1F * limbSwingAmount);
		this.PleuralSpine3.rotateAngleZ = MathHelper.cos(limbSwing * walkSpeed * 0.3F + 2) * walkDegree * 1F * limbSwingAmount;
		this.PleuralSpine3Right.rotateAngleZ = -(MathHelper.cos(limbSwing * walkSpeed * 0.3F + 2) * walkDegree * 1F * limbSwingAmount);
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
