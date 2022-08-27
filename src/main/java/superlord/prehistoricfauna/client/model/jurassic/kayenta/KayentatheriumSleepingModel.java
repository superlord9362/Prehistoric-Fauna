package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.KayentatheriumEntity;

/**
 * Kayentatherium - Crimes
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class KayentatheriumSleepingModel extends EntityModel<KayentatheriumEntity> {
    public ModelRenderer Body;
    public ModelRenderer Head;
    public ModelRenderer RightArm;
    public ModelRenderer LeftArm;
    public ModelRenderer RightLeg;
    public ModelRenderer LeftLeg;
    public ModelRenderer Tail;

    public KayentatheriumSleepingModel() {
        this.textureWidth = 35;
        this.textureHeight = 50;
        this.RightLeg = new ModelRenderer(this, 0, 0);
        this.RightLeg.setRotationPoint(1.5F, 3.0F, 10.5F);
        this.RightLeg.setTextureOffset(25, 5).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F, 0.01F, 0.01F, 0.01F);
        this.setRotateAngle(RightLeg, 1.602910321115726F, 0.3909537457888271F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 1.0F, 1.0F);
        this.Head.setTextureOffset(10, 0).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, 0.46931902520863084F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 20.0F, -6.0F);
        this.Body.setTextureOffset(1, 8).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 0, 0);
        this.Tail.setRotationPoint(0.0F, 2.0F, 12.0F);
        this.Tail.setTextureOffset(1, 24).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.23457224414434488F, 0.0F, 0.0F);
        this.RightArm = new ModelRenderer(this, 0, 0);
        this.RightArm.setRotationPoint(1.5F, 3.0F, 2.0F);
        this.RightArm.setTextureOffset(27, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.01F, 0.01F, 0.01F);
        this.setRotateAngle(RightArm, -1.0164797856562695F, -0.8991936386169619F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 0, 0);
        this.LeftArm.mirror = true;
        this.LeftArm.setRotationPoint(-1.5F, 3.0F, 2.0F);
        this.LeftArm.setTextureOffset(27, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.01F, 0.01F, 0.01F);
        this.setRotateAngle(LeftArm, -1.0164797856562695F, 0.8991936386169619F, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 0, 0);
        this.LeftLeg.mirror = true;
        this.LeftLeg.setRotationPoint(-1.5F, 3.0F, 10.5F);
        this.LeftLeg.setTextureOffset(25, 5).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 3.0F, 3.0F, 0.01F, 0.01F, 0.01F);
        this.setRotateAngle(LeftLeg, 1.6030848913251807F, -0.3909537457888271F, 0.0F);
        this.Body.addChild(this.RightLeg);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.RightArm);
        this.Body.addChild(this.LeftArm);
        this.Body.addChild(this.LeftLeg);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(KayentatheriumEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
