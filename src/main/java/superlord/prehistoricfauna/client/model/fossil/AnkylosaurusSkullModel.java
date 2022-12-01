package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.AnkylosaurusSkullEntity;

/**
 * Ankylosaurus - Bastion
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class AnkylosaurusSkullModel extends EntityModel<AnkylosaurusSkullEntity> {
	public ModelRenderer Head1;
    public ModelRenderer Head2;
    public ModelRenderer Spike1;
    public ModelRenderer Spike1_1;
    public ModelRenderer Spike3;
    public ModelRenderer Spike4;

    public AnkylosaurusSkullModel() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.Head1 = new ModelRenderer(this, 152, 97);
        this.Head1.setRotationPoint(0.0F, 17.0F, 4.0F);
        this.Head1.addBox(-7.0F, -5.0F, -12.0F, 14.0F, 12.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.Head2 = new ModelRenderer(this, 200, 93);
        this.Head2.setRotationPoint(0.0F, 0.0F, -12.0F);
        this.Head2.addBox(-5.5F, -3.0F, -3.0F, 11.0F, 9.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Spike4 = new ModelRenderer(this, 29, 32);
        this.Spike4.setRotationPoint(-7.0F, 2.0F, -2.0F);
        this.Spike4.addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Spike4, 0.0F, -0.9105382388075086F, 0.0F);
        this.Spike3 = new ModelRenderer(this, 29, 32);
        this.Spike3.setRotationPoint(7.0F, 2.0F, -2.0F);
        this.Spike3.addBox(-4.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Spike3, 0.0F, 0.9105382388075086F, 0.0F);
        this.Spike1 = new ModelRenderer(this, 0, 33);
        this.Spike1.setRotationPoint(7.0F, -3.0F, 0.0F);
        this.Spike1.addBox(-4.0F, -3.0F, 0.0F, 5.0F, 5.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Spike1, 0.0911061832922575F, 0.27314402127920984F, 0.0F);
        this.Spike1_1 = new ModelRenderer(this, 0, 33);
        this.Spike1_1.setRotationPoint(-7.0F, -3.0F, 0.0F);
        this.Spike1_1.addBox(-1.0F, -3.0F, 0.0F, 5.0F, 5.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Spike1_1, 0.0911061832922575F, -0.27314402127920984F, 0.0F);
        this.Head1.addChild(this.Head2);
        this.Head1.addChild(this.Spike4);
        this.Head1.addChild(this.Spike3);
        this.Head1.addChild(this.Spike1);
        this.Head1.addChild(this.Spike1_1);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(AnkylosaurusSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
