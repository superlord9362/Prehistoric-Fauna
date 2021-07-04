package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.BasilemysEntity;

/**
 * Basilemys - Superlord and Crimes
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class Basilemys extends EntityModel<BasilemysEntity> {
    public ModelRenderer Body;
    public ModelRenderer Neck;
    public ModelRenderer LeftFrontLeg;
    public ModelRenderer RightFrontLeg;
    public ModelRenderer LeftBackLeg;
    public ModelRenderer RightBackLeg;
    public ModelRenderer Tail;
    public ModelRenderer Head;

    public Basilemys() {
        this.textureWidth = 128;
        this.textureHeight = 48;
        this.LeftBackLeg = new ModelRenderer(this, 33, 23);
        this.LeftBackLeg.setRotationPoint(3.0F, 3.1F, -2.0F);
        this.LeftBackLeg.addBox(0.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.RightBackLeg = new ModelRenderer(this, 33, 23);
        this.RightBackLeg.mirror = true;
        this.RightBackLeg.setRotationPoint(-3.0F, 3.1F, -2.0F);
        this.RightBackLeg.addBox(-2.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 4, 22);
        this.Neck.setRotationPoint(0.0F, 1.3F, -12.0F);
        this.Neck.addBox(-1.0F, 0.0F, -6.0F, 2.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 47, 7);
        this.Tail.setRotationPoint(0.0F, 1.6F, -0.7F);
        this.Tail.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 4, 31);
        this.Head.setRotationPoint(0.0F, 1.2F, -5.0F);
        this.Head.addBox(-1.5F, -2.0F, -4.0F, 3.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.LeftFrontLeg = new ModelRenderer(this, 22, 23);
        this.LeftFrontLeg.setRotationPoint(3.0F, 2.1F, -12.9F);
        this.LeftFrontLeg.addBox(0.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 2, 2);
        this.Body.setRotationPoint(0.0F, 18.0F, 8.0F);
        this.Body.addBox(-6.0F, 0.0F, -14.0F, 12.0F, 4.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.RightFrontLeg = new ModelRenderer(this, 22, 23);
        this.RightFrontLeg.mirror = true;
        this.RightFrontLeg.setRotationPoint(-3.0F, 2.1F, -12.9F);
        this.RightFrontLeg.addBox(-2.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.LeftBackLeg);
        this.Body.addChild(this.RightBackLeg);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.Tail);
        this.Neck.addChild(this.Head);
        this.Body.addChild(this.LeftFrontLeg);
        this.Body.addChild(this.RightFrontLeg);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(BasilemysEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
    	this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
    	this.RightBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.LeftBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.RightFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.LeftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;	
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
