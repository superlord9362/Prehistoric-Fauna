package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.ProtoceratopsSkullEntity;

/**
 * ProtoceratopsSkeleton - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ProtoceratopsSkullModel extends EntityModel<ProtoceratopsSkullEntity> {
    public ModelRenderer Head;
    public ModelRenderer Beak;
    public ModelRenderer Crest;

    public ProtoceratopsSkullModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Head = new ModelRenderer(this, 39, 12);
        this.Head.setRotationPoint(0.0F, 21.0F, 3.0F);
        this.Head.addBox(-2.5F, -4.0F, -5.0F, 5.0F, 7.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Beak = new ModelRenderer(this, 48, 27);
        this.Beak.setRotationPoint(0.0F, -1.0F, -5.5F);
        this.Beak.addBox(-1.5F, -2.0F, -2.5F, 3.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Crest = new ModelRenderer(this, 34, 0);
        this.Crest.setRotationPoint(0.0F, -2.0F, 0.5F);
        this.Crest.addBox(-5.5F, -7.5F, -1.4F, 11.0F, 9.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Crest, -0.47123889803846897F, 0.0F, 0.0F);
        this.Head.addChild(this.Beak);
        this.Head.addChild(this.Crest);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(ProtoceratopsSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
