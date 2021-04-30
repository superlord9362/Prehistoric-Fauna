package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.CeratosaurusSkullEntity;

/**
 * CeratosaurusSkull - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class CeratosaurusSkull extends EntityModel<CeratosaurusSkullEntity> {
    public ModelRenderer Head1;
    public ModelRenderer Jaw1;
    public ModelRenderer Snout;
    public ModelRenderer Jaw2;
    public ModelRenderer LowerTeeth;
    public ModelRenderer CrestRight;
    public ModelRenderer UpperTeeth;
    public ModelRenderer CrestLeft;
    public ModelRenderer SnoutHorn;

    public CeratosaurusSkull() {
        this.textureWidth = 250;
        this.textureHeight = 250;
        this.Snout = new ModelRenderer(this, 47, 94);
        this.Snout.setRotationPoint(0.0F, -3.0F, -8.0F);
        this.Snout.addBox(-2.5F, -1.0F, -9.0F, 5.0F, 5.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.CrestLeft = new ModelRenderer(this, 0, 191);
        this.CrestLeft.setRotationPoint(2.0F, -2.0F, 1.0F);
        this.CrestLeft.addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.SnoutHorn = new ModelRenderer(this, 0, 22);
        this.SnoutHorn.setRotationPoint(0.0F, -2.0F, -6.0F);
        this.SnoutHorn.addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw1 = new ModelRenderer(this, 0, 119);
        this.Jaw1.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Jaw1.addBox(-4.0F, 0.0F, -8.0F, 8.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw2 = new ModelRenderer(this, 47, 119);
        this.Jaw2.setRotationPoint(0.0F, 1.0F, -8.0F);
        this.Jaw2.addBox(-2.0F, -1.0F, -9.0F, 4.0F, 3.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.CrestRight = new ModelRenderer(this, 16, 191);
        this.CrestRight.setRotationPoint(-2.0F, -2.0F, 1.0F);
        this.CrestRight.addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LowerTeeth = new ModelRenderer(this, 47, 203);
        this.LowerTeeth.setRotationPoint(0.0F, -2.0F, -0.5F);
        this.LowerTeeth.addBox(-2.0F, -2.0F, -8.0F, 4.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Head1 = new ModelRenderer(this, 0, 94);
        this.Head1.setRotationPoint(0.0F, 18.99F, 8.0F);
        this.Head1.addBox(-4.0F, -5.0F, -8.0F, 8.0F, 6.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.UpperTeeth = new ModelRenderer(this, 5, 203);
        this.UpperTeeth.setRotationPoint(0.0F, 4.2F, -0.51F);
        this.UpperTeeth.addBox(-2.5F, -4.2F, -8.5F, 5.0F, 7.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Head1.addChild(this.Snout);
        this.Snout.addChild(this.CrestLeft);
        this.Snout.addChild(this.SnoutHorn);
        this.Head1.addChild(this.Jaw1);
        this.Jaw1.addChild(this.Jaw2);
        this.Snout.addChild(this.CrestRight);
        this.Jaw2.addChild(this.LowerTeeth);
        this.Snout.addChild(this.UpperTeeth);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(CeratosaurusSkullEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
