package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.TyrannosaurusSkullEntity;

/**
 * Tyrannosaurus_skull - Weastian
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class TyrannosaurusskullModel extends EntityModel<TyrannosaurusSkullEntity> {
    public ModelRenderer Jaw1;
    public ModelRenderer Jaw2;
    public ModelRenderer Head;
    public ModelRenderer Snout;

    public TyrannosaurusskullModel() {
        this.textureWidth = 64;
        this.textureHeight = 128;
        this.Snout = new ModelRenderer(this, 0, 44);
        this.Snout.setRotationPoint(0.0F, -9.0F, -11.0F);
        this.Snout.addBox(-3.5F, 0.0F, -15.99F, 7.0F, 12.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw2 = new ModelRenderer(this, 0, 76);
        this.Jaw2.setRotationPoint(0.0F, 1.0F, -6.0F);
        this.Jaw2.addBox(-3.0F, -2.0F, -15.0F, 6.0F, 7.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.Head.addBox(-7.0F, -11.0F, -11.0F, 14.0F, 11.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw1 = new ModelRenderer(this, 0, 23);
        this.Jaw1.setRotationPoint(0.0F, 17.0F, 3.0F);
        this.Jaw1.addBox(-7.0F, 0.0F, -6.0F, 14.0F, 7.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.Head.addChild(this.Snout);
        this.Jaw1.addChild(this.Jaw2);
        this.Jaw1.addChild(this.Head);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Jaw1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(TyrannosaurusSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
