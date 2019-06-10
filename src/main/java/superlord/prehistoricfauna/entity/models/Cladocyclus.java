package superlord.prehistoricfauna.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;

/**
 * Cladocyclus - superlord9362
 * Created using Tabula 7.0.1
 */
public class Cladocyclus extends ModelBase {
    public ModelRenderer Body1;
    public ModelRenderer Body2;
    public ModelRenderer RFFin;
    public ModelRenderer LFFin;
    public ModelRenderer Head;
    public ModelRenderer Tail1;
    public ModelRenderer Tail3;
    public ModelRenderer RBFin;
    public ModelRenderer LBFin;
    public ModelRenderer TailFin;
    public ModelRenderer Tail2;
    public ModelRenderer Mouth;
    public ModelRenderer Jaw;
    protected float childYOffset = 8.0F;
    protected float childZOffset = 4.0F;

    public Cladocyclus() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.Body2 = new ModelRenderer(this, 21, 0);
        this.Body2.setRotationPoint(0.0F, 0.5F, 13.0F);
        this.Body2.addBox(-1.5F, -3.0F, 0.0F, 3, 5, 7, 0.0F);
        this.Tail2 = new ModelRenderer(this, 53, 0);
        this.Tail2.setRotationPoint(-0.5F, 1.0F, -0.5F);
        this.Tail2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Tail2, 0.2617993877991494F, 0.0F, 0.0F);
        this.LFFin = new ModelRenderer(this, 6, 0);
        this.LFFin.setRotationPoint(-1.0F, 2.0F, 0.0F);
        this.LFFin.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(LFFin, 0.2792526803190927F, 0.0F, 0.4886921905584123F);
        this.TailFin = new ModelRenderer(this, 71, 0);
        this.TailFin.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.TailFin.addBox(0.0F, -8.0F, -1.0F, 0, 15, 6, 0.0F);
        this.Tail3 = new ModelRenderer(this, 21, 0);
        this.Tail3.setRotationPoint(0.0F, -3.0F, 5.0F);
        this.Tail3.addBox(-0.5F, -4.0F, 0.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(Tail3, -0.3490658503988659F, 0.0F, 0.0F);
        this.LBFin = new ModelRenderer(this, 38, 0);
        this.LBFin.setRotationPoint(-0.5F, 1.0F, 2.0F);
        this.LBFin.addBox(-1.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(LBFin, 0.2792526803190927F, 0.0F, 0.17453292519943295F);
        this.RBFin = new ModelRenderer(this, 34, 0);
        this.RBFin.setRotationPoint(0.5F, 1.0F, 2.0F);
        this.RBFin.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(RBFin, 0.2792526803190927F, 0.0F, -0.17453292519943295F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, 22.5F, -7.0F);
        this.Body1.addBox(-2.0F, -3.0F, 0.0F, 4, 6, 13, 0.0F);
        this.Jaw = new ModelRenderer(this, 64, 0);
        this.Jaw.setRotationPoint(0.0F, 1.0F, -2.0F);
        this.Jaw.addBox(-0.5F, 0.4F, -3.5F, 1, 1, 4, 0.0F);
        this.setRotateAngle(Jaw, -0.7330382858376184F, 0.0F, 0.0F);
        this.RFFin = new ModelRenderer(this, 0, 0);
        this.RFFin.setRotationPoint(1.0F, 2.0F, 0.0F);
        this.RFFin.addBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
        this.setRotateAngle(RFFin, 0.2792526803190927F, 0.0F, -0.4886921905584123F);
        this.Tail1 = new ModelRenderer(this, 53, 0);
        this.Tail1.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.Tail1.addBox(-1.0F, -2.5F, 0.0F, 2, 4, 7, 0.0F);
        this.Mouth = new ModelRenderer(this, 85, 0);
        this.Mouth.setRotationPoint(0.0F, 0.1F, -1.8F);
        this.Mouth.addBox(-1.0F, -2.8F, -1.9F, 2, 4, 3, 0.0F);
        this.setRotateAngle(Mouth, 0.6283185307179586F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 41, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-1.5F, -2.9F, -2.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(Head, 0.02530727415391778F, 0.0F, 0.0F);
        this.Body1.addChild(this.Body2);
        this.Tail1.addChild(this.Tail2);
        this.Body1.addChild(this.LFFin);
        this.Tail1.addChild(this.TailFin);
        this.Body2.addChild(this.Tail3);
        this.Body2.addChild(this.LBFin);
        this.Body2.addChild(this.RBFin);
        this.Head.addChild(this.Jaw);
        this.Body1.addChild(this.RFFin);
        this.Body2.addChild(this.Tail1);
        this.Head.addChild(this.Mouth);
        this.Body1.addChild(this.Head);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	if (this.isChild) {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, this.childYOffset * f5, this.childZOffset * f5);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.2F, 0.2F, 0.2F);
            GlStateManager.translate(0.0F, 95.0F * f5, 0.0F);
            this.Body1.render(f5);
            GlStateManager.popMatrix();
        } else {
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Body1.offsetX, this.Body1.offsetY, this.Body1.offsetZ);
        GlStateManager.translate(this.Body1.rotationPointX * f5, this.Body1.rotationPointY * f5, this.Body1.rotationPointZ * f5);
        GlStateManager.scale(0.5D, 0.5D, 0.5D);
        GlStateManager.translate(-this.Body1.offsetX, -this.Body1.offsetY, -this.Body1.offsetZ);
        GlStateManager.translate(-this.Body1.rotationPointX * f5, -this.Body1.rotationPointY * f5, -this.Body1.rotationPointZ * f5);
        this.Body1.render(f5);
        GlStateManager.popMatrix();
        }
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
    	this.Body2.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
        this.Tail1.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
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
