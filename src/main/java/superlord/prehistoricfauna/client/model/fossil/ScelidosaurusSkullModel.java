package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.ScelidosaurusSkullEntity;

/**
 * ScelidosaurusSkull - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ScelidosaurusSkullModel extends EntityModel<ScelidosaurusSkullEntity> {
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer part21;

    public ScelidosaurusSkullModel() {
        this.textureWidth = 160;
        this.textureHeight = 150;
        this.Snout = new ModelRenderer(this, 0, 52);
        this.Snout.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.Snout.addBox(-1.0F, -2.0F, -3.0F, 2.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.part21 = new ModelRenderer(this, 15, 49);
        this.part21.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.part21.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 3.0F, 0.00999999F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 44);
        this.Head.setRotationPoint(0.0F, 22.0F, 3.0F);
        this.Head.addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Head.addChild(this.Snout);
        this.Head.addChild(this.part21);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(ScelidosaurusSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
