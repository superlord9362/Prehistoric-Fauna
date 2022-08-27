package superlord.prehistoricfauna.client.model.fish;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fish.SaurichthysEntity;

/**
 * Saurichthys - Obs&Crimes
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SaurichthysModel extends EntityModel<SaurichthysEntity> {
    public ModelRenderer Body;
    public ModelRenderer Head;
    public ModelRenderer BodyBack;
    public ModelRenderer RightPectoralFin;
    public ModelRenderer LeftPectoralfin;
    public ModelRenderer Snout;
    public ModelRenderer Tailfin;
    public ModelRenderer DorsalAnalfins;
    public ModelRenderer RightPelvicfin;
    public ModelRenderer LeftPelvicfin;

    public SaurichthysModel() {
        this.textureWidth = 48;
        this.textureHeight = 36;
        this.BodyBack = new ModelRenderer(this, 0, 0);
        this.BodyBack.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.BodyBack.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.DorsalAnalfins = new ModelRenderer(this, 23, 3);
        this.DorsalAnalfins.setRotationPoint(0.0F, 0.0F, 6.0F);
        this.DorsalAnalfins.addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LeftPectoralfin = new ModelRenderer(this, 21, 10);
        this.LeftPectoralfin.setRotationPoint(1.0F, -0.5F, 0.0F);
        this.LeftPectoralfin.addBox(0.0F, 0.5F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftPectoralfin, 0.0F, 0.17453292519943295F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 19);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Tailfin = new ModelRenderer(this, 23, -5);
        this.Tailfin.setRotationPoint(0.0F, 0.0F, 8.0F);
        this.Tailfin.addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.LeftPelvicfin = new ModelRenderer(this, 22, 11);
        this.LeftPelvicfin.setRotationPoint(1.0F, 1.0F, 2.0F);
        this.LeftPelvicfin.addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 25);
        this.Snout.setRotationPoint(0.0F, -1.0F, -4.0F);
        this.Snout.addBox(-0.5F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.RightPectoralFin = new ModelRenderer(this, 21, 10);
        this.RightPectoralFin.setRotationPoint(-1.0F, 0.0F, 0.0F);
        this.RightPectoralFin.addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightPectoralFin, 0.0F, -0.17453292519943295F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 10);
        this.Body.setRotationPoint(0.0F, 23.0F, -6.0F);
        this.Body.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.RightPelvicfin = new ModelRenderer(this, 22, 11);
        this.RightPelvicfin.setRotationPoint(-1.0F, 1.0F, 2.0F);
        this.RightPelvicfin.addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.BodyBack);
        this.BodyBack.addChild(this.DorsalAnalfins);
        this.Body.addChild(this.LeftPectoralfin);
        this.Body.addChild(this.Head);
        this.BodyBack.addChild(this.Tailfin);
        this.BodyBack.addChild(this.LeftPelvicfin);
        this.Head.addChild(this.Snout);
        this.Body.addChild(this.RightPectoralFin);
        this.BodyBack.addChild(this.RightPelvicfin);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(SaurichthysEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float f = 1.0F;
        if (!entityIn.isInWater()) {
           f = 1.5F;
        }
        this.Body.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.Body.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.BodyBack.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
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
