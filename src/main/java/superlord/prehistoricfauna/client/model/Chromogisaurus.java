package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.ChromogisaurusEntity;

/**
 * Chromogi - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class Chromogisaurus extends EntityModel<ChromogisaurusEntity> {
    public ModelRenderer Body;
    public ModelRenderer LeftThigh;
    public ModelRenderer RightThigh;
    public ModelRenderer LeftArm;
    public ModelRenderer RightArm;
    public ModelRenderer Neck;
    public ModelRenderer Tail;
    public ModelRenderer Head;
    public ModelRenderer LeftLeg;
    public ModelRenderer LeftLeg_1;

    public Chromogisaurus() {
        this.textureWidth = 80;
        this.textureHeight = 64;
        this.LeftThigh = new ModelRenderer(this, 30, 0);
        this.LeftThigh.setRotationPoint(1.0F, 15.0F, 2.0F);
        this.LeftThigh.addBox(-0.5F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.RightArm = new ModelRenderer(this, 12, 18);
        this.RightArm.setRotationPoint(-1.5F, 1.0F, -6.0F);
        this.RightArm.addBox(-0.5F, -1.0F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg_1 = new ModelRenderer(this, 60, 0);
        this.LeftLeg_1.setRotationPoint(-0.6F, 5.0F, 1.0F);
        this.LeftLeg_1.addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 60, 0);
        this.LeftLeg.setRotationPoint(0.6F, 5.0F, 1.0F);
        this.LeftLeg.addBox(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 12, 18);
        this.LeftArm.setRotationPoint(1.5F, 1.0F, -6.0F);
        this.LeftArm.addBox(-0.5F, -1.0F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 18);
        this.Neck.setRotationPoint(0.5F, -1.0F, -8.0F);
        this.Neck.addBox(-1.5F, -3.0F, -2.0F, 2.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 31, 3);
        this.Tail.setRotationPoint(0.0F, -0.9F, 4.0F);
        this.Tail.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.RightThigh = new ModelRenderer(this, 39, 0);
        this.RightThigh.setRotationPoint(-1.0F, 15.0F, 2.0F);
        this.RightThigh.addBox(-1.5F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 28);
        this.Head.setRotationPoint(0.0F, -3.0F, -1.0F);
        this.Head.addBox(-1.5F, -2.0F, -3.0F, 2.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 16.0F, 2.0F);
        this.Body.addBox(-1.5F, -2.0F, -8.0F, 3.0F, 4.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.RightArm);
        this.RightThigh.addChild(this.LeftLeg_1);
        this.LeftThigh.addChild(this.LeftLeg);
        this.Body.addChild(this.LeftArm);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.Tail);
        this.Neck.addChild(this.Head);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.LeftThigh, this.RightThigh, this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(ChromogisaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	this.Neck.rotateAngleX = headPitch * ((float)Math.PI / 180F);
    	this.Neck.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
    	this.RightThigh.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.LeftThigh.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
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
