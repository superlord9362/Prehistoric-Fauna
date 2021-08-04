package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.HesperornithoidesEntity;

/**
 * Hesperornithoides - TheDarkTroodon
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class Hesperornithoides extends EntityModel<HesperornithoidesEntity> {
    public ModelRenderer Body;
    public ModelRenderer Head;
    public ModelRenderer LeftWing;
    public ModelRenderer RightWing;
    public ModelRenderer LeftLeg;
    public ModelRenderer RightLeg;
    public ModelRenderer Tail;
    public ModelRenderer Snoot;
    public ModelRenderer Fluff;

    public Hesperornithoides() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.LeftWing = new ModelRenderer(this, 13, 5);
        this.LeftWing.setRotationPoint(1.5F, 0.0F, 1.0F);
        this.LeftWing.addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Fluff = new ModelRenderer(this, 10, 18);
        this.Fluff.setRotationPoint(0.0F, -4.0F, -1.0F);
        this.Fluff.addBox(-0.5F, -2.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.RightWing = new ModelRenderer(this, 13, 5);
        this.RightWing.mirror = true;
        this.RightWing.setRotationPoint(-1.5F, 0.0F, 1.0F);
        this.RightWing.addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg = new ModelRenderer(this, 17, 16);
        this.RightLeg.mirror = true;
        this.RightLeg.setRotationPoint(-0.25F, 3.0F, 4.0F);
        this.RightLeg.addBox(-1.0F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 1, 17);
        this.Head.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.Head.addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.01F, 0.01F);
        this.LeftLeg = new ModelRenderer(this, 17, 16);
        this.LeftLeg.setRotationPoint(0.25F, 3.0F, 4.0F);
        this.LeftLeg.addBox(0.0F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 19, 5);
        this.Tail.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.Tail.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 1, 8);
        this.Body.setRotationPoint(0.0F, 17.0F, -2.5F);
        this.Body.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Snoot = new ModelRenderer(this, 1, 24);
        this.Snoot.setRotationPoint(0.0F, -4.0F, -1.0F);
        this.Snoot.addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.LeftWing);
        this.Head.addChild(this.Fluff);
        this.Body.addChild(this.RightWing);
        this.Body.addChild(this.RightLeg);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.LeftLeg);
        this.Body.addChild(this.Tail);
        this.Head.addChild(this.Snoot);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(HesperornithoidesEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.rotateAngleX = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 3)));
		this.Fluff.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 3));
    	this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
    	this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.Tail.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
		this.Tail.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
		this.LeftWing.rotateAngleZ = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
		this.RightWing.rotateAngleZ = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
		this.LeftWing.rotateAngleY = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
		this.RightWing.rotateAngleY = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
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
