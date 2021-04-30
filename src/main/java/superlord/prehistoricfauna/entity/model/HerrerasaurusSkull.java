package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.HerrerasaurusSkullEntity;

/**
 * Herrerasaurus - superlord9362
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class HerrerasaurusSkull extends EntityModel<HerrerasaurusSkullEntity> {
    public ModelRenderer Head;
    public ModelRenderer Snout;

    public HerrerasaurusSkull() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Snout = new ModelRenderer(this, 0, 42);
        this.Snout.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.Snout.addBox(-1.5F, -2.0F, -5.0F, 3.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 49, 9);
        this.Head.setRotationPoint(0.0F, 21.0F, 2.0F);
        this.Head.addBox(-2.0F, -2.0F, -3.0F, 4.0F, 5.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Head.addChild(this.Snout);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(HerrerasaurusSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
