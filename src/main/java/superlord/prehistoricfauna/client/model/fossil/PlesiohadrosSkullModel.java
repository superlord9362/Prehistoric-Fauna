package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.PlesiohadrosSkullEntity;

/**
 * PlesiohadrosSkull - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class PlesiohadrosSkullModel extends EntityModel<PlesiohadrosSkullEntity> {
	public ModelRenderer Head;
    public ModelRenderer Beak;
    public ModelRenderer Jaw;
    public ModelRenderer Jugal;
    public ModelRenderer Nose;
    public ModelRenderer Beak_1;
    public ModelRenderer Jaw_1;

    public PlesiohadrosSkullModel() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.Beak = new ModelRenderer(this, 85, 0);
        this.Beak.setRotationPoint(0.0F, 3.5F, -8.0F);
        this.Beak.addBox(-2.0F, -3.0F, -5.0F, 4.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 56, 0);
        this.Head.setRotationPoint(0.0F, 19.5F, 6.5F);
        this.Head.addBox(-3.0F, -1.5F, -8.0F, 6.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Jugal = new ModelRenderer(this, 199, 2);
        this.Jugal.setRotationPoint(0.0F, 2.5F, -4.0F);
        this.Jugal.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Nose = new ModelRenderer(this, 48, 0);
        this.Nose.setRotationPoint(0.0F, -2.0F, -1.0F);
        this.Nose.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw_1 = new ModelRenderer(this, 180, 0);
        this.Jaw_1.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.Jaw_1.addBox(-1.5F, 0.0F, -4.99F, 3.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Beak_1 = new ModelRenderer(this, 229, 3);
        this.Beak_1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Beak_1.addBox(-2.0F, 0.0F, -5.0F, 4.0F, 1.1F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw = new ModelRenderer(this, 151, 0);
        this.Jaw.setRotationPoint(0.0F, 2.5F, 0.0F);
        this.Jaw.addBox(-2.5F, -1.0F, -8.0F, 5.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Head.addChild(this.Beak);
        this.Head.addChild(this.Jugal);
        this.Beak.addChild(this.Nose);
        this.Jaw.addChild(this.Jaw_1);
        this.Beak.addChild(this.Beak_1);
        this.Head.addChild(this.Jaw);
    }


    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(PlesiohadrosSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
