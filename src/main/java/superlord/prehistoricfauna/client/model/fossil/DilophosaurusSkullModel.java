package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.DilophosaurusSkullEntity;

/**
 * Dilophosaurus Skull - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class DilophosaurusSkullModel extends EntityModel<DilophosaurusSkullEntity> {
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer Jaw;
    public ModelRenderer Head_1;
    public ModelRenderer CrestRight;
    public ModelRenderer CrestRight_1;
    public ModelRenderer Snout_1;
    public ModelRenderer Mouth;

    public DilophosaurusSkullModel() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.Snout_1 = new ModelRenderer(this, -1, 115);
        this.Snout_1.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.Snout_1.addBox(-1.5F, 0.0F, -8.0F, 3.0F, 1.5F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 80);
        this.Snout.setRotationPoint(0.0F, -2.0F, -6.0F);
        this.Snout.addBox(-1.5F, -2.0F, -8.0F, 3.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.CrestRight = new ModelRenderer(this, -2, -2);
        this.CrestRight.mirror = true;
        this.CrestRight.setRotationPoint(-1.5F, -2.0F, 1.0F);
        this.CrestRight.addBox(0.0F, -6.0F, -10.0F, 0.0F, 6.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(CrestRight, 0.0F, 0.0F, -0.08726646259971647F);
        this.Jaw = new ModelRenderer(this, 0, 106);
        this.Jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Jaw.addBox(-2.0F, 0.0F, -4.99F, 4.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 70);
        this.Head.setRotationPoint(0.0F, 21.0F, 7.0F);
        this.Head.addBox(-2.5F, -5.0F, -5.0F, 5.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Head_1 = new ModelRenderer(this, 25, 119);
        this.Head_1.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Head_1.addBox(-2.5F, -1.0F, -5.0F, 5.0F, 1.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.CrestRight_1 = new ModelRenderer(this, -2, -2);
        this.CrestRight_1.setRotationPoint(1.5F, -2.0F, 1.0F);
        this.CrestRight_1.addBox(0.0F, -6.0F, -10.0F, 0.0F, 6.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(CrestRight_1, 0.0F, 0.0F, 0.08726646259971647F);
        this.Mouth = new ModelRenderer(this, 0, 93);
        this.Mouth.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.Mouth.addBox(-1.0F, -1.0F, -8.99F, 2.0F, 3.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Snout.addChild(this.Snout_1);
        this.Head.addChild(this.Snout);
        this.Snout.addChild(this.CrestRight);
        this.Head.addChild(this.Jaw);
        this.Head.addChild(this.Head_1);
        this.Snout.addChild(this.CrestRight_1);
        this.Jaw.addChild(this.Mouth);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(DilophosaurusSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
