package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.SaurosuchusEntity;

/**
 * Saurosuchus - Undefined
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SaurosuchusSleeping extends EntityModel<SaurosuchusEntity> {
    public ModelRenderer Body;
    public ModelRenderer Neck;
    public ModelRenderer Arm;
    public ModelRenderer Arm_1;
    public ModelRenderer Thigh;
    public ModelRenderer Thigh_1;
    public ModelRenderer Tail;
    public ModelRenderer Osteos;
    public ModelRenderer Head;
    public ModelRenderer Osteos2;
    public ModelRenderer Snout;
    public ModelRenderer Jaw;
    public ModelRenderer SnoutTeeth;
    public ModelRenderer JawSnout;
    public ModelRenderer Cheek;
    public ModelRenderer JawTeeth;
    public ModelRenderer Calf;
    public ModelRenderer Foot;
    public ModelRenderer Calf_1;
    public ModelRenderer Foot_1;
    public ModelRenderer Tail2;
    public ModelRenderer osteos3;

    public SaurosuchusSleeping() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.Thigh = new ModelRenderer(this, 79, 45);
        this.Thigh.setRotationPoint(1.5F, 3.0F, -2.0F);
        this.Thigh.addBox(0.0F, 0.0F, -2.0F, 5.0F, 11.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thigh, 1.5707963267948966F, 0.6981317007977318F, -0.0F);
        this.JawSnout = new ModelRenderer(this, 34, 93);
        this.JawSnout.setRotationPoint(0.0F, 0.0F, -7.0F);
        this.JawSnout.addBox(-2.5F, -1.0F, -7.0F, 5.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Cheek = new ModelRenderer(this, 64, 94);
        this.Cheek.setRotationPoint(0.0F, -3.7F, 2.7F);
        this.Cheek.addBox(-3.0F, -2.0F, -7.0F, 6.0F, 6.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 74);
        this.Head.setRotationPoint(0.0F, 0.0F, -10.0F);
        this.Head.addBox(-3.5F, -4.0F, -8.0F, 7.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.JawTeeth = new ModelRenderer(this, 67, 114);
        this.JawTeeth.setRotationPoint(0.0F, -1.3F, 0.1F);
        this.JawTeeth.addBox(-2.0F, -1.0F, -7.0F, 4.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Osteos = new ModelRenderer(this, 1, 13);
        this.Osteos.setRotationPoint(0.0F, -9.0F, -21.0F);
        this.Osteos.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 27.0F, 0.0F, 0.0F, 0.0F);
        this.Osteos2 = new ModelRenderer(this, 1, 31);
        this.Osteos2.setRotationPoint(0.0F, -5.0F, -10.0F);
        this.Osteos2.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 47);
        this.Neck.setRotationPoint(0.0F, -3.0F, -20.0F);
        this.Neck.addBox(-4.0F, -4.0F, -10.0F, 8.0F, 10.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.17453292519943295F, 0.0F, -0.0F);
        this.Tail = new ModelRenderer(this, 103, 0);
        this.Tail.setRotationPoint(0.0F, -4.0F, 6.0F);
        this.Tail.addBox(-4.0F, -3.0F, -1.0F, 8.0F, 9.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.17453292519943295F, 0.6108652381980153F, -0.0F);
        this.Jaw = new ModelRenderer(this, 40, 74);
        this.Jaw.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.Jaw.addBox(-3.5F, -2.0F, -7.0F, 7.0F, 3.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.osteos3 = new ModelRenderer(this, 2, 20);
        this.osteos3.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.osteos3.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.Calf = new ModelRenderer(this, 79, 64);
        this.Calf.setRotationPoint(2.5F, 10.0F, 1.9F);
        this.Calf.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Thigh_1 = new ModelRenderer(this, 79, 45);
        this.Thigh_1.setRotationPoint(-1.5F, 3.0F, -2.0F);
        this.Thigh_1.addBox(-5.0F, 0.0F, -2.0F, 5.0F, 11.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thigh_1, 1.5707963267948966F, -0.6981317007977318F, 0.0F);
        this.Calf_1 = new ModelRenderer(this, 79, 64);
        this.Calf_1.setRotationPoint(-2.5F, 10.0F, 1.9F);
        this.Calf_1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 103, 37);
        this.Tail2.setRotationPoint(0.0F, 1.0F, 20.0F);
        this.Tail2.addBox(-2.5F, -3.0F, -1.0F, 5.0F, 5.0F, 40.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.0F, 0.6108652381980153F, -0.0F);
        this.Arm = new ModelRenderer(this, 43, 45);
        this.Arm.setRotationPoint(2.0F, -1.0F, -17.0F);
        this.Arm.addBox(1.0F, 0.0F, 1.0F, 4.0F, 17.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm, -1.5707963267948966F, 0.0F, 0.0F);
        this.Arm_1 = new ModelRenderer(this, 61, 45);
        this.Arm_1.setRotationPoint(-3.0F, -1.0F, -17.0F);
        this.Arm_1.addBox(-4.0F, 0.0F, 1.0F, 4.0F, 17.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm_1, -1.5707963267948966F, 0.0F, 0.0F);
        this.Foot_1 = new ModelRenderer(this, 79, 78);
        this.Foot_1.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.Foot_1.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Foot = new ModelRenderer(this, 79, 78);
        this.Foot.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.Foot.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 93);
        this.Snout.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.Snout.addBox(-2.5F, -3.0F, -7.0F, 5.0F, 5.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.SnoutTeeth = new ModelRenderer(this, 34, 116);
        this.SnoutTeeth.setRotationPoint(0.0F, 1.1F, 0.1F);
        this.SnoutTeeth.addBox(-2.0F, -1.0F, -7.0F, 4.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(SnoutTeeth, 0.12566370281464037F, 0.0F, -0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 19.0F, 9.0F);
        this.Body.addBox(-6.0F, -8.0F, -21.0F, 12.0F, 13.0F, 27.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.Thigh);
        this.Jaw.addChild(this.JawSnout);
        this.Jaw.addChild(this.Cheek);
        this.Neck.addChild(this.Head);
        this.JawSnout.addChild(this.JawTeeth);
        this.Body.addChild(this.Osteos);
        this.Neck.addChild(this.Osteos2);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.Tail);
        this.Head.addChild(this.Jaw);
        this.Tail.addChild(this.osteos3);
        this.Thigh.addChild(this.Calf);
        this.Body.addChild(this.Thigh_1);
        this.Thigh_1.addChild(this.Calf_1);
        this.Tail.addChild(this.Tail2);
        this.Body.addChild(this.Arm);
        this.Body.addChild(this.Arm_1);
        this.Calf_1.addChild(this.Foot_1);
        this.Calf.addChild(this.Foot);
        this.Head.addChild(this.Snout);
        this.Snout.addChild(this.SnoutTeeth);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(SaurosuchusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
