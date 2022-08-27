package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.SarahsaurusEntity;

/**
 * SarahsaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SarahsaurusSleepingModel extends EntityModel<SarahsaurusEntity> {
    public ModelRenderer Torso;
    public ModelRenderer Leg1Left;
    public ModelRenderer Leg1Right;
    public ModelRenderer ArmRight;
    public ModelRenderer Neck;
    public ModelRenderer Tail;
    public ModelRenderer ArmLeft;
    public ModelRenderer Head;
    public ModelRenderer Tail2;
    public ModelRenderer Leg2Left;
    public ModelRenderer FootLeft;
    public ModelRenderer Leg2Right;
    public ModelRenderer FootRight;

    public SarahsaurusSleepingModel() {
        this.textureWidth = 125;
        this.textureHeight = 75;
        this.Leg1Right = new ModelRenderer(this, 42, 31);
        this.Leg1Right.mirror = true;
        this.Leg1Right.setRotationPoint(-2.0F, 18.0F, 6.0F);
        this.Leg1Right.addBox(-3.0F, -1.0F, -3.0F, 4.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg1Right, -1.0164797856562695F, 0.23457224414434488F, 0.0F);
        this.ArmLeft = new ModelRenderer(this, 22, 32);
        this.ArmLeft.setRotationPoint(2.0F, 3.0F, -16.0F);
        this.ArmLeft.addBox(0.0F, 0.0F, -2.0F, 2.0F, 8.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmLeft, -0.23457224414434488F, 0.0F, -1.2901473511162753F);
        this.Tail2 = new ModelRenderer(this, 58, 0);
        this.Tail2.setRotationPoint(0.0F, 1.0F, 12.0F);
        this.Tail2.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 3.0F, 29.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.0781907508222411F, 0.3909537457888271F, 0.0F);
        this.Leg1Left = new ModelRenderer(this, 42, 31);
        this.Leg1Left.setRotationPoint(2.0F, 18.0F, 6.0F);
        this.Leg1Left.addBox(-1.0F, -1.0F, -3.0F, 4.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg1Left, -1.0164797856562695F, -0.23457224414434488F, 0.0F);
        this.Torso = new ModelRenderer(this, 0, 0);
        this.Torso.setRotationPoint(0.0F, 19.0F, 9.0F);
        this.Torso.addBox(-3.5F, -4.0F, -20.0F, 7.0F, 9.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.ArmRight = new ModelRenderer(this, 22, 32);
        this.ArmRight.mirror = true;
        this.ArmRight.setRotationPoint(-2.0F, 3.0F, -16.0F);
        this.ArmRight.addBox(-2.0F, 0.0F, -2.0F, 2.0F, 8.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmRight, -0.23457224414434488F, 0.0F, 1.2901473511162753F);
        this.Tail = new ModelRenderer(this, 36, 0);
        this.Tail.setRotationPoint(0.0F, -3.0F, 2.0F);
        this.Tail.addBox(-3.0F, 0.0F, -2.0F, 6.0F, 6.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.1563815016444822F, 0.11728612207217244F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 53);
        this.Head.setRotationPoint(0.0F, -13.0F, -0.6F);
        this.Head.addBox(-1.5F, -2.0F, -6.0F, 3.0F, 3.0F, 7.0F, 0.01F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -1.413716694115407F, 0.0F, 0.3909537457888271F);
        this.Leg2Right = new ModelRenderer(this, 42, 50);
        this.Leg2Right.mirror = true;
        this.Leg2Right.setRotationPoint(-1.0F, 5.0F, 1.0F);
        this.Leg2Right.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg2Right, -0.5864306020384839F, 0.0781907508222411F, 0.0781907508222411F);
        this.Neck = new ModelRenderer(this, 0, 31);
        this.Neck.setRotationPoint(0.0F, -1.0F, -18.0F);
        this.Neck.addBox(-1.5F, -14.0F, -3.0F, 3.0F, 17.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 1.7830284277532733F, -0.5473352640780661F, 0.0F);
        this.FootLeft = new ModelRenderer(this, 43, 65);
        this.FootLeft.setRotationPoint(0.0F, 7.5F, 1.0F);
        this.FootLeft.addBox(-1.5F, 0.0F, -4.0F, 3.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FootLeft, 1.8374826151943415F, 0.0F, 0.0F);
        this.Leg2Left = new ModelRenderer(this, 42, 50);
        this.Leg2Left.setRotationPoint(1.0F, 5.0F, 1.0F);
        this.Leg2Left.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg2Left, -0.5864306020384839F, -0.0781907508222411F, -0.0781907508222411F);
        this.FootRight = new ModelRenderer(this, 43, 65);
        this.FootRight.setRotationPoint(0.0F, 7.5F, 1.0F);
        this.FootRight.addBox(-1.5F, 0.0F, -4.0F, 3.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FootRight, 1.8374826151943415F, 0.0F, 0.0F);
        this.Torso.addChild(this.ArmLeft);
        this.Tail.addChild(this.Tail2);
        this.Torso.addChild(this.ArmRight);
        this.Torso.addChild(this.Tail);
        this.Neck.addChild(this.Head);
        this.Leg1Right.addChild(this.Leg2Right);
        this.Torso.addChild(this.Neck);
        this.Leg2Left.addChild(this.FootLeft);
        this.Leg1Left.addChild(this.Leg2Left);
        this.Leg2Right.addChild(this.FootRight);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Leg1Right, this.Leg1Left, this.Torso).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(SarahsaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
