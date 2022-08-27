package superlord.prehistoricfauna.client.model.jurassic.morrison;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.EilenodonEntity;

/**
 * EilenodonBasking - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class EilenodonSleepingModel extends EntityModel<EilenodonEntity> {
    public ModelRenderer Body;
    public ModelRenderer LegL;
    public ModelRenderer LegR;
    public ModelRenderer ArmL;
    public ModelRenderer Neck;
    public ModelRenderer ArmR;
    public ModelRenderer Tail;
    public ModelRenderer BackSpine;
    public ModelRenderer Head;
    public ModelRenderer HeadSpine;
    public ModelRenderer Dewlap;

    public EilenodonSleepingModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.LegR = new ModelRenderer(this, 35, 5);
        this.LegR.setRotationPoint(-2.0F, 1.0F, 1.0F);
        this.LegR.addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegR, 0.0F, 0.0F, 1.5707963267948966F);
        this.LegL = new ModelRenderer(this, 35, 0);
        this.LegL.setRotationPoint(2.0F, 1.0F, 1.0F);
        this.LegL.addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegL, 0.0F, 0.0F, -1.5707963267948966F);
        this.Tail = new ModelRenderer(this, 18, 11);
        this.Tail.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.Tail.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.03909537541112055F, 0.3127630032889644F, -0.0781907508222411F);
        this.ArmR = new ModelRenderer(this, 28, 5);
        this.ArmR.setRotationPoint(-2.0F, 1.0F, -4.0F);
        this.ArmR.addBox(-1.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmR, 0.0F, 0.0F, 1.5707963267948966F);
        this.BackSpine = new ModelRenderer(this, 0, 17);
        this.BackSpine.setRotationPoint(0.0F, -2.5F, -4.0F);
        this.BackSpine.addBox(0.0F, -0.5F, -1.0F, 0.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Dewlap = new ModelRenderer(this, 9, 11);
        this.Dewlap.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.Dewlap.addBox(0.0F, -1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.HeadSpine = new ModelRenderer(this, 9, 17);
        this.HeadSpine.setRotationPoint(0.0F, -2.5F, -1.0F);
        this.HeadSpine.addBox(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.ArmL = new ModelRenderer(this, 28, 0);
        this.ArmL.setRotationPoint(2.0F, 1.0F, -4.0F);
        this.ArmL.addBox(0.0F, 0.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmL, 0.0F, 0.0F, -1.5707963267948966F);
        this.Head = new ModelRenderer(this, 0, 18);
        this.Head.setRotationPoint(0.0F, -1.0F, -2.0F);
        this.Head.addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 23.0F, 2.0F);
        this.Body.addBox(-2.0F, -2.0F, -5.0F, 4.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 12);
        this.Neck.setRotationPoint(0.0F, -1.0F, -4.8F);
        this.Neck.addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.19547687289441354F, 0.27366763203903305F, -1.2901473511162753F);
        this.Body.addChild(this.LegR);
        this.Body.addChild(this.LegL);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.ArmR);
        this.Body.addChild(this.BackSpine);
        this.Head.addChild(this.Dewlap);
        this.Neck.addChild(this.HeadSpine);
        this.Body.addChild(this.ArmL);
        this.Neck.addChild(this.Head);
        this.Body.addChild(this.Neck);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(EilenodonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
