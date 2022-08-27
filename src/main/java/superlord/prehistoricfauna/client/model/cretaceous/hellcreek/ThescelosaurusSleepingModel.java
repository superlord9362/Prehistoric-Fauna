package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.ThescelosaurusEntity;

/**
 * ThescelosaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ThescelosaurusSleepingModel extends EntityModel<ThescelosaurusEntity> {
    public ModelRenderer RightLeg1;
    public ModelRenderer LeftLeg1;
    public ModelRenderer Body;
    public ModelRenderer RightLeg2;
    public ModelRenderer LeftLeg2;
    public ModelRenderer Head;
    public ModelRenderer RightArm;
    public ModelRenderer Tail1;
    public ModelRenderer LeftArm;
    public ModelRenderer Snout;
    public ModelRenderer Tail2;

    public ThescelosaurusSleepingModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.RightLeg1 = new ModelRenderer(this, 43, 0);
        this.RightLeg1.setRotationPoint(-3.0F, 18.9F, 3.0F);
        this.RightLeg1.addBox(-1.0F, -2.0F, -3.0F, 3.0F, 9.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg1, -1.4076080683650378F, 0.27366763203903305F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 18.5F, 0.0F);
        this.Body.addBox(-3.0F, -5.0F, -12.0F, 6.0F, 10.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, -0.19547687289441354F, 0.0F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 32, 0);
        this.LeftArm.setRotationPoint(3.1F, 1.0F, -10.0F);
        this.LeftArm.addBox(0.0F, -1.0F, -1.0F, 1.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftArm, 0.7688175221876966F, 0.004188790111159634F, 0.0F);
        this.LeftLeg2 = new ModelRenderer(this, 0, 0);
        this.LeftLeg2.setRotationPoint(-1.0F, 3.0F, 3.7F);
        this.LeftLeg2.addBox(-2.0F, 0.0F, -5.0F, 3.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg2, 0.03909537541112055F, 3.141592653589793F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 54);
        this.Snout.setRotationPoint(0.0F, -7.0F, -4.0F);
        this.Snout.addBox(-1.0F, 0.0F, -4.0F, 2.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Snout, 0.05235987755982988F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 28, 44);
        this.Tail2.setRotationPoint(0.0F, 1.0F, 14.0F);
        this.Tail2.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.23457224414434488F, -0.03909537541112055F, -0.0781907508222411F);
        this.RightLeg2 = new ModelRenderer(this, 0, 0);
        this.RightLeg2.setRotationPoint(1.0F, 2.8F, 3.7F);
        this.RightLeg2.addBox(-1.0F, 0.0F, -5.0F, 3.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg2, 0.07801621390230003F, 3.141592653589793F, 0.0F);
        this.RightArm = new ModelRenderer(this, 32, 0);
        this.RightArm.setRotationPoint(-3.1F, 1.0F, -10.0F);
        this.RightArm.addBox(-1.0F, -1.0F, -1.0F, 1.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightArm, 0.6511823678875341F, 0.11746065899211351F, 0.0F);
        this.LeftLeg1 = new ModelRenderer(this, 43, 0);
        this.LeftLeg1.setRotationPoint(3.0F, 18.9F, 3.0F);
        this.LeftLeg1.addBox(-2.0F, -2.0F, -3.0F, 3.0F, 9.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg1, -1.4072589279461283F, -0.35185837453889574F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 29);
        this.Head.setRotationPoint(0.0F, -1.0F, -11.4F);
        this.Head.addBox(-2.0F, -8.0F, -4.0F, 4.0F, 11.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -0.19547687289441354F, 0.7428121536172364F, -0.0781907508222411F);
        this.Tail1 = new ModelRenderer(this, 3, 30);
        this.Tail1.setRotationPoint(0.0F, -3.0F, 6.0F);
        this.Tail1.addBox(-2.0F, -1.0F, -2.0F, 4.0F, 5.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.0781907508222411F, -0.27401668923415834F, -0.1956514098143546F);
        this.Body.addChild(this.LeftArm);
        this.LeftLeg1.addChild(this.LeftLeg2);
        this.Head.addChild(this.Snout);
        this.Tail1.addChild(this.Tail2);
        this.RightLeg1.addChild(this.RightLeg2);
        this.Body.addChild(this.RightArm);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.Tail1);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.RightLeg1, this.Body, this.LeftLeg1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(ThescelosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
