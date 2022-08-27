package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.ScutellosaurusEntity;

/**
 * Scutellosaurus - bastion14
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ScutellosaurusSleepingModel extends EntityModel<ScutellosaurusEntity> {
    public ModelRenderer Body;
    public ModelRenderer Leg;
    public ModelRenderer Leg_1;
    public ModelRenderer Neck;
    public ModelRenderer Tail;
    public ModelRenderer ArmRight;
    public ModelRenderer ArmLeft;
    public ModelRenderer part6;
    public ModelRenderer part6_1;
    public ModelRenderer Head;
    public ModelRenderer Tail2;
    public ModelRenderer TailOsteoderms;
    public ModelRenderer Tail2Osteoderms;
    public ModelRenderer Leg2;
    public ModelRenderer Leg2_1;

    public ScutellosaurusSleepingModel() {
        this.textureWidth = 70;
        this.textureHeight = 45;
        this.Leg_1 = new ModelRenderer(this, 7, 20);
        this.Leg_1.mirror = true;
        this.Leg_1.setRotationPoint(-0.6F, 20.3F, 3.0F);
        this.Leg_1.addBox(-1.0F, 0.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_1, -0.5082398928281348F, 0.4300491170387584F, 0.0F);
        this.Tail = new ModelRenderer(this, 21, 0);
        this.Tail.setRotationPoint(0.0F, -1.8F, 0.0F);
        this.Tail.addBox(-0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.3125884663690233F, 0.27366763203903305F, -0.1563815016444822F);
        this.Leg = new ModelRenderer(this, 7, 20);
        this.Leg.setRotationPoint(0.4F, 20.0F, 3.6F);
        this.Leg.addBox(0.0F, 0.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg, -0.3914773565486503F, -0.46914448828868976F, 0.0F);
        this.part6_1 = new ModelRenderer(this, 42, 5);
        this.part6_1.setRotationPoint(0.0F, -1.9F, -6.5F);
        this.part6_1.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 21.7F, 4.0F);
        this.Body.addBox(-1.0F, -2.0F, -8.0F, 2.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.ArmLeft = new ModelRenderer(this, 0, 20);
        this.ArmLeft.mirror = true;
        this.ArmLeft.setRotationPoint(-0.5F, 1.0F, -7.0F);
        this.ArmLeft.addBox(-1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmLeft, 1.2510520131558576F, -0.6257005102083563F, 0.0F);
        this.Leg2 = new ModelRenderer(this, 14, 21);
        this.Leg2.setRotationPoint(0.5F, 1.5F, -1.0F);
        this.Leg2.addBox(-0.5F, 0.0F, -2.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg2, 0.35185837453889574F, 0.0F, 0.0F);
        this.part6 = new ModelRenderer(this, 32, 4);
        this.part6.setRotationPoint(0.0F, -1.9F, -8.0F);
        this.part6.addBox(-1.5F, 0.0F, -1.0F, 3.0F, 0.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 31, -12);
        this.Tail2.setRotationPoint(0.0F, 0.2F, 5.0F);
        this.Tail2.addBox(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, -0.03909537541112055F, 0.46914448828868976F, 0.0F);
        this.ArmRight = new ModelRenderer(this, 0, 20);
        this.ArmRight.setRotationPoint(0.5F, 1.0F, -7.0F);
        this.ArmRight.addBox(0.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmRight, 1.1728612040769677F, 0.5473352640780661F, 0.0F);
        this.Tail2Osteoderms = new ModelRenderer(this, 25, 4);
        this.Tail2Osteoderms.setRotationPoint(0.0F, 0.5F, 5.9F);
        this.Tail2Osteoderms.addBox(-0.5F, 0.0F, -7.9F, 1.0F, 0.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.TailOsteoderms = new ModelRenderer(this, 21, 9);
        this.TailOsteoderms.setRotationPoint(0.0F, 0.2F, -0.1F);
        this.TailOsteoderms.addBox(-1.0F, 0.0F, 0.1F, 2.0F, 0.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 12, 13);
        this.Head.setRotationPoint(0.0F, -0.1F, -2.5F);
        this.Head.addBox(-0.5F, -1.5F, -3.5F, 1.0F, 2.0F, 4.0F, 0.01F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -0.19547687289441354F, 0.0F, 0.0F);
        this.Leg2_1 = new ModelRenderer(this, 14, 21);
        this.Leg2_1.setRotationPoint(-0.5F, 1.0F, -0.5F);
        this.Leg2_1.addBox(-0.5F, 0.0F, -2.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg2_1, 0.5473352640780661F, 0.3127630032889644F, 0.19547687289441354F);
        this.Neck = new ModelRenderer(this, 0, 13);
        this.Neck.setRotationPoint(0.0F, 0.2F, -8.0F);
        this.Neck.addBox(-0.5F, -1.5F, -2.8F, 1.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.46914448828868976F, -0.3909537457888271F, -0.03909537541112055F);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.part6_1);
        this.Body.addChild(this.ArmLeft);
        this.Leg.addChild(this.Leg2);
        this.Body.addChild(this.part6);
        this.Tail.addChild(this.Tail2);
        this.Body.addChild(this.ArmRight);
        this.Tail2.addChild(this.Tail2Osteoderms);
        this.Tail.addChild(this.TailOsteoderms);
        this.Neck.addChild(this.Head);
        this.Leg_1.addChild(this.Leg2_1);
        this.Body.addChild(this.Neck);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Leg_1, this.Leg, this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(ScutellosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
