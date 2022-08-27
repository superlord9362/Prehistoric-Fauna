package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.TriceratopsSkullEntity;

/**
 * Triceratops - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class TriceratopsSkullModel extends EntityModel<TriceratopsSkullEntity> {
    public ModelRenderer Head1;
    public ModelRenderer Snout;
    public ModelRenderer horn1;
    public ModelRenderer horn1_1;
    public ModelRenderer Crest;
    public ModelRenderer nasalhorn;
    public ModelRenderer Beak;

    public TriceratopsSkullModel() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.horn1 = new ModelRenderer(this, 60, 165);
        this.horn1.setRotationPoint(4.9F, -1.0F, -12.0F);
        this.horn1.addBox(-2.0F, -4.0F, -20.0F, 3.0F, 4.0F, 25.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(horn1, -0.7285004590772052F, -0.18203784630933073F, 0.0F);
        this.horn1_1 = new ModelRenderer(this, 60, 165);
        this.horn1_1.setRotationPoint(-4.9F, -1.0F, -12.0F);
        this.horn1_1.addBox(-1.0F, -4.0F, -20.0F, 3.0F, 4.0F, 25.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(horn1_1, -0.7285004590772052F, 0.18203784630933073F, 0.0F);
        this.Head1 = new ModelRenderer(this, 0, 130);
        this.Head1.setRotationPoint(0.0F, 9.0F, 8.0F);
        this.Head1.addBox(-6.0F, -3.0F, -12.0F, 12.0F, 18.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.nasalhorn = new ModelRenderer(this, 0, 0);
        this.nasalhorn.setRotationPoint(0.0F, 1.0F, -12.0F);
        this.nasalhorn.addBox(-1.0F, -5.0F, -3.0F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(nasalhorn, 0.6373942508178124F, 0.0F, 0.0F);
        this.Crest = new ModelRenderer(this, 58, 127);
        this.Crest.setRotationPoint(0.0F, 9.0F, -3.0F);
        this.Crest.addBox(-14.0F, -23.0F, -5.0F, 28.0F, 25.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Crest, -0.591841146688116F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 169);
        this.Snout.setRotationPoint(0.0F, 1.0F, -12.0F);
        this.Snout.addBox(-4.0F, 0.0F, -14.0F, 8.0F, 13.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.Beak = new ModelRenderer(this, 0, 204);
        this.Beak.setRotationPoint(0.0F, 2.0F, -14.0F);
        this.Beak.addBox(-2.0F, 0.0F, -5.0F, 4.0F, 12.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Head1.addChild(this.horn1);
        this.Head1.addChild(this.horn1_1);
        this.Snout.addChild(this.nasalhorn);
        this.Head1.addChild(this.Crest);
        this.Head1.addChild(this.Snout);
        this.Snout.addChild(this.Beak);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(TriceratopsSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
