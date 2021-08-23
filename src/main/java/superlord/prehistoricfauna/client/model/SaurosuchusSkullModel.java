package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.SaurosuchusSkullEntity;

/**
 * SaurosuchusSkull - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SaurosuchusSkullModel extends EntityModel<SaurosuchusSkullEntity> {
    public ModelRenderer Head;
    public ModelRenderer Jaw;
    public ModelRenderer Snout;
    public ModelRenderer JawSnout;
    public ModelRenderer JawTeeth;
    public ModelRenderer SnoutTeeth;

    public SaurosuchusSkullModel() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.JawSnout = new ModelRenderer(this, 125, 13);
        this.JawSnout.setRotationPoint(1.0F, 2.0F, -9.0F);
        this.JawSnout.addBox(-2.5F, -1.0F, -7.0F, 3.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 133, 0);
        this.Head.setRotationPoint(0.0F, 20.0F, 8.0F);
        this.Head.addBox(-3.5F, -4.0F, -8.0F, 7.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.SnoutTeeth = new ModelRenderer(this, 180, 8);
        this.SnoutTeeth.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.SnoutTeeth.addBox(-2.5F, 0.0F, -7.0F, 4.0F, 1.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw = new ModelRenderer(this, 75, 12);
        this.Jaw.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Jaw.addBox(-3.5F, 0.0F, -8.0F, 7.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 163, 0);
        this.Snout.setRotationPoint(0.5F, 0.0F, -9.0F);
        this.Snout.addBox(-2.5F, -3.0F, -7.0F, 4.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.JawTeeth = new ModelRenderer(this, 142, 12);
        this.JawTeeth.setRotationPoint(0.0F, -1.0F, 0.01F);
        this.JawTeeth.addBox(-2.5F, -2.0F, -7.0F, 3.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw.addChild(this.JawSnout);
        this.Snout.addChild(this.SnoutTeeth);
        this.Head.addChild(this.Jaw);
        this.Head.addChild(this.Snout);
        this.JawSnout.addChild(this.JawTeeth);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(SaurosuchusSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
