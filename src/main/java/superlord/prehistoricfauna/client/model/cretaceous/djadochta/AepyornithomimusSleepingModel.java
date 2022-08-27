package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.AepyornithomimusEntity;

/**
 * Aepyornithomimus - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class AepyornithomimusSleepingModel extends EntityModel<AepyornithomimusEntity> {
    public ModelRenderer Body;
    public ModelRenderer Thighleft;
    public ModelRenderer Thighleft_1;
    public ModelRenderer Tailbase;
    public ModelRenderer HeadNeck;
    public ModelRenderer Wingleft;
    public ModelRenderer Wingright;
    public ModelRenderer Tailtip;
    public ModelRenderer part7;
    public ModelRenderer Beak;
    public ModelRenderer Crest;

    public AepyornithomimusSleepingModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.Body.addBox(-2.0F, -3.0F, -10.0F, 4.0F, 6.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.part7 = new ModelRenderer(this, 0, 20);
        this.part7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part7.addBox(-2.0F, 0.0F, 0.5F, 4.0F, 3.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.Crest = new ModelRenderer(this, 23, 6);
        this.Crest.setRotationPoint(0.0F, -8.0F, 0.5F);
        this.Crest.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Thighleft_1 = new ModelRenderer(this, 0, 20);
        this.Thighleft_1.mirror = true;
        this.Thighleft_1.setRotationPoint(-1.5F, 21.0F, 1.0F);
        this.Thighleft_1.addBox(-1.5F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thighleft_1, -0.46931902520863084F, 0.03909537541112055F, 0.0F);
        this.Wingright = new ModelRenderer(this, 44, 0);
        this.Wingright.mirror = true;
        this.Wingright.setRotationPoint(-1.8F, 2.0F, -8.0F);
        this.Wingright.addBox(-1.0F, -1.0F, -1.0F, 1.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Wingright, 0.35185837453889574F, 0.0F, 1.2892747663851107F);
        this.Beak = new ModelRenderer(this, 22, 0);
        this.Beak.setRotationPoint(0.0F, -7.0F, -2.5F);
        this.Beak.addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Tailbase = new ModelRenderer(this, 26, 10);
        this.Tailbase.setRotationPoint(0.0F, -2.0F, 4.5F);
        this.Tailbase.addBox(-1.5F, -1.0F, -1.5F, 3.0F, 4.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tailbase, -0.1563815016444822F, 0.4300491170387584F, 0.0F);
        this.Wingleft = new ModelRenderer(this, 44, 0);
        this.Wingleft.setRotationPoint(1.8F, 2.0F, -8.0F);
        this.Wingleft.addBox(0.0F, -1.0F, -1.0F, 1.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Wingleft, 0.35185837453889574F, 0.0F, -1.2901473511162753F);
        this.HeadNeck = new ModelRenderer(this, 0, 0);
        this.HeadNeck.setRotationPoint(0.0F, -1.0F, -10.0F);
        this.HeadNeck.addBox(-1.0F, -8.0F, -2.5F, 2.0F, 10.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(HeadNeck, 0.5864306020384839F, -1.759291939273506F, 0.3127630032889644F);
        this.Tailtip = new ModelRenderer(this, 30, 25);
        this.Tailtip.setRotationPoint(0.0F, 0.0F, 10.0F);
        this.Tailtip.addBox(-1.0F, -1.0F, -1.5F, 2.0F, 3.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tailtip, 0.0F, 0.5082398928281348F, 0.0F);
        this.Thighleft = new ModelRenderer(this, 0, 20);
        this.Thighleft.setRotationPoint(1.5F, 21.0F, 1.0F);
        this.Thighleft.addBox(-0.5F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thighleft, -0.46914448828868976F, -0.03909537541112055F, 0.0F);
        this.Tailtip.addChild(this.part7);
        this.HeadNeck.addChild(this.Crest);
        this.Body.addChild(this.Wingright);
        this.HeadNeck.addChild(this.Beak);
        this.Body.addChild(this.Tailbase);
        this.Body.addChild(this.Wingleft);
        this.Body.addChild(this.HeadNeck);
        this.Tailbase.addChild(this.Tailtip);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body, this.Thighleft_1, this.Thighleft).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(AepyornithomimusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	
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
