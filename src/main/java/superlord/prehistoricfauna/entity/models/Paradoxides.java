package superlord.prehistoricfauna.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;

/**
 * Paradoxides - superlord9362
 * Created using Tabula 7.0.1
 */
public class Paradoxides extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape3_1;
    public ModelRenderer shape6;
    public ModelRenderer shape6_1;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public Paradoxides() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape6 = new ModelRenderer(this, 14, 5);
        this.shape6.setRotationPoint(3.0F, 0.0F, 0.0F);
        this.shape6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.shape3 = new ModelRenderer(this, 28, 0);
        this.shape3.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.shape3.addBox(-1.2F, 0.0F, -0.5F, 2, 1, 6, 0.0F);
        this.setRotateAngle(shape3, 0.0F, -0.24434609527920614F, 0.0F);
        this.shape6_1 = new ModelRenderer(this, 20, 6);
        this.shape6_1.setRotationPoint(-3.0F, 0.0F, 0.0F);
        this.shape6_1.addBox(-1.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 23.4F, -0.4F);
        this.shape1.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 6, 0.0F);
        this.shape3_1 = new ModelRenderer(this, 44, 0);
        this.shape3_1.setRotationPoint(-1.6F, 0.0F, 0.0F);
        this.shape3_1.addBox(-1.2F, 0.0F, -0.5F, 2, 1, 6, 0.0F);
        this.setRotateAngle(shape3_1, 0.0F, 0.24434609527920614F, 0.0F);
        this.shape4 = new ModelRenderer(this, 38, 0);
        this.shape4.setRotationPoint(0.0F, 0.0F, 6.0F);
        this.shape4.addBox(-1.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.shape2 = new ModelRenderer(this, 12, 0);
        this.shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape2.addBox(-4.0F, -1.0F, -3.0F, 8, 2, 3, 0.0F);
        this.shape2.addChild(this.shape6);
        this.shape1.addChild(this.shape3);
        this.shape2.addChild(this.shape6_1);
        this.shape1.addChild(this.shape3_1);
        this.shape1.addChild(this.shape4);
        this.shape1.addChild(this.shape2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	if (this.isChild)
        {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, this.childYOffset * f5, this.childZOffset * f5);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.2F, 0.2F, 0.2F);
            GlStateManager.translate(0.0F, 96.0F * f5, 0.0F);
            this.shape1.render(f5);
            GlStateManager.popMatrix();
        }
        else
        {
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.shape1.offsetX, this.shape1.offsetY, this.shape1.offsetZ);
        GlStateManager.translate(this.shape1.rotationPointX * f5, this.shape1.rotationPointY * f5, this.shape1.rotationPointZ * f5);
        GlStateManager.scale(0.56D, 0.55D, 0.55D);
        GlStateManager.translate(-this.shape1.offsetX, -this.shape1.offsetY, -this.shape1.offsetZ);
        GlStateManager.translate(-this.shape1.rotationPointX * f5, -this.shape1.rotationPointY * f5, -this.shape1.rotationPointZ * f5);
        this.shape1.render(f5);
        GlStateManager.popMatrix();
        }
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
