package superlord.prehistoricfauna.item.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * AnkyHelmet - superlord9362
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class AnkyHelmet extends BipedModel<LivingEntity> {
    public ModelRenderer Helmet;
    public ModelRenderer LHorn;
    public ModelRenderer RHorn;
    public ModelRenderer NHorn;

    public AnkyHelmet(float size) {
    	super(size);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.NHorn = new ModelRenderer(this, 56, 26);
        this.NHorn.setRotationPoint(-1.0F, -3.5F, -5.0F);
        this.NHorn.addBox(0.0F, -2.5F, 0.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(NHorn, 1.2154472804362069F, 0.0F, 0.0F);
        this.Helmet = new ModelRenderer(this, 0, 0);
        this.Helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Helmet.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 7.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.LHorn = new ModelRenderer(this, 48, 20);
        this.LHorn.setRotationPoint(2.0F, -7.0F, -5.0F);
        this.LHorn.addBox(-0.5F, -8.0F, 0.0F, 2.0F, 10.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LHorn, 0.7853981633974483F, 0.0F, 0.0F);
        this.RHorn = new ModelRenderer(this, 48, 20);
        this.RHorn.setRotationPoint(-4.0F, -7.0F, -5.0F);
        this.RHorn.addBox(0.5F, -8.0F, 0.0F, 2.0F, 10.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RHorn, 0.7853981633974483F, 0.0F, 0.0F);
        
        this.bipedHead.addChild(this.Helmet);
        this.bipedHead.addChild(this.NHorn);
        this.bipedHead.addChild(this.LHorn);
        this.bipedHead.addChild(this.RHorn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        super.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
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
