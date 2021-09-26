package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.MyledaphusEntity;

/**
 * MyledaphusModel - superlord9362
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class MyledaphusModel extends EntityModel<MyledaphusEntity> {
    public ModelRenderer Body;
    public ModelRenderer Fan;
    public ModelRenderer Tail;
    public ModelRenderer TailFin;
    public ModelRenderer TailEnd;

    public MyledaphusModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Fan = new ModelRenderer(this, -13, 10);
        this.Fan.setRotationPoint(2.5F, 0.8F, 0.0F);
        this.Fan.addBox(-5.5F, 0.0F, -3.0F, 11.0F, 0.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 19, 0);
        this.Tail.setRotationPoint(2.5F, 0.5F, 8.0F);
        this.Tail.addBox(-1.5F, -0.5F, 0.0F, 3.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.TailEnd = new ModelRenderer(this, 19, 1);
        this.TailEnd.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.TailEnd.addBox(0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(-2.5F, 23.0F, -6.0F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 5.0F, 1.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.TailFin = new ModelRenderer(this, 0, 0);
        this.TailFin.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.TailFin.addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.Fan);
        this.Body.addChild(this.Tail);
        this.Tail.addChild(this.TailEnd);
        this.Tail.addChild(this.TailFin);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(MyledaphusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float f = 1.0F;
        if (!entityIn.isInWater()) {
           f = 1.5F;
        }

        this.Tail.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
        this.TailEnd.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
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
