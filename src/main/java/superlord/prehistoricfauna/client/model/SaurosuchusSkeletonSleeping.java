package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.SaurosuchusSkeletonEntity;

/**
 * Saurosuchus - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SaurosuchusSkeletonSleeping extends EntityModel<SaurosuchusSkeletonEntity> {
    public ModelRenderer Body;
    public ModelRenderer Osteos;
    public ModelRenderer Arm;
    public ModelRenderer Thigh;
    public ModelRenderer Neck;
    public ModelRenderer Arm_1;
    public ModelRenderer Thigh_1;
    public ModelRenderer Tail;
    public ModelRenderer Body_1;
    public ModelRenderer Hips;
    public ModelRenderer Calf;
    public ModelRenderer Foot;
    public ModelRenderer Osteos2;
    public ModelRenderer Head;
    public ModelRenderer Neck_1;
    public ModelRenderer Snout;
    public ModelRenderer Jaw;
    public ModelRenderer SnoutTeeth;
    public ModelRenderer JawSnout;
    public ModelRenderer JawTeeth;
    public ModelRenderer Calf_1;
    public ModelRenderer Foot_1;
    public ModelRenderer Tail2;
    public ModelRenderer osteos3;
    public ModelRenderer Tail_1;
    public ModelRenderer Tail2_1;

    public SaurosuchusSkeletonSleeping() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.SnoutTeeth = new ModelRenderer(this, 180, 6);
        this.SnoutTeeth.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.SnoutTeeth.addBox(-2.0F, -1.0F, -8.0F, 4.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.JawSnout = new ModelRenderer(this, 125, 13);
        this.JawSnout.setRotationPoint(0.0F, 2.0F, -9.0F);
        this.JawSnout.addBox(-1.5F, -1.0F, -7.0F, 3.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 11, 11);
        this.Body.setRotationPoint(0.0F, 19.0F, 6.0F);
        this.Body.addBox(-6.0F, -7.0F, -21.0F, 12.0F, 12.0F, 24.0F, 0.0F, 0.0F, 0.0F);
        this.Body_1 = new ModelRenderer(this, 126, 26);
        this.Body_1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Body_1.addBox(0.0F, -7.0F, -21.0F, 0.0F, 13.0F, 35.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 101, 23);
        this.Tail.setRotationPoint(0.0F, -5.0F, 14.0F);
        this.Tail.addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.17453292519943295F, 0.6108652381980153F, 0.0F);
        this.Hips = new ModelRenderer(this, 161, 77);
        this.Hips.setRotationPoint(0.0F, -6.0F, 1.0F);
        this.Hips.addBox(-5.0F, 0.0F, 0.0F, 10.0F, 8.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.Arm = new ModelRenderer(this, -1, 0);
        this.Arm.setRotationPoint(6.0F, 1.0F, -17.0F);
        this.Arm.addBox(-3.0F, 0.0F, -2.0F, 4.0F, 15.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm, -1.4926055177160067F, 0.0F, 0.0F);
        this.Foot_1 = new ModelRenderer(this, 99, 21);
        this.Foot_1.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.Foot_1.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Thigh = new ModelRenderer(this, 62, 3);
        this.Thigh.setRotationPoint(4.0F, -1.0F, 6.0F);
        this.Thigh.addBox(-2.0F, -2.0F, -2.0F, 5.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thigh, 1.453510179755589F, 0.6981317007977318F, 0.0F);
        this.Neck = new ModelRenderer(this, 97, -1);
        this.Neck.setRotationPoint(0.0F, -5.0F, -21.0F);
        this.Neck.addBox(-3.0F, -1.0F, -8.0F, 6.0F, 10.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.17453292519943295F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 163, 0);
        this.Snout.setRotationPoint(0.0F, 2.5F, -8.0F);
        this.Snout.addBox(-2.0F, -3.0F, -8.0F, 4.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Foot = new ModelRenderer(this, 99, 21);
        this.Foot.mirror = true;
        this.Foot.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.Foot.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw = new ModelRenderer(this, 75, 12);
        this.Jaw.setRotationPoint(0.0F, 3.5F, 0.0F);
        this.Jaw.addBox(-3.5F, 0.0F, -8.0F, 7.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.JawTeeth = new ModelRenderer(this, 142, 13);
        this.JawTeeth.setRotationPoint(0.5F, -1.0F, 0.01F);
        this.JawTeeth.addBox(-2.0F, -1.0F, -7.0F, 3.0F, 1.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Arm_1 = new ModelRenderer(this, -1, 0);
        this.Arm_1.mirror = true;
        this.Arm_1.setRotationPoint(-6.0F, 1.0F, -17.0F);
        this.Arm_1.addBox(-1.0F, 0.0F, -2.0F, 4.0F, 15.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm_1, -1.4926055177160067F, 0.03944444092862428F, 0.0F);
        this.Thigh_1 = new ModelRenderer(this, 62, 3);
        this.Thigh_1.mirror = true;
        this.Thigh_1.setRotationPoint(-4.0F, -1.0F, 6.0F);
        this.Thigh_1.addBox(-3.0F, -2.0F, -2.0F, 5.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thigh_1, 1.453510179755589F, -0.6981317007977318F, 0.0F);
        this.Osteos = new ModelRenderer(this, 95, 83);
        this.Osteos.setRotationPoint(0.0F, -8.0F, -18.5F);
        this.Osteos.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 31.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2_1 = new ModelRenderer(this, 2, 47);
        this.Tail2_1.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.Tail2_1.addBox(0.0F, -2.0F, -1.0F, 0.0F, 6.0F, 41.0F, 0.0F, 0.0F, 0.0F);
        this.Neck_1 = new ModelRenderer(this, 180, 42);
        this.Neck_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Neck_1.addBox(0.0F, -2.0F, -9.0F, 0.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.osteos3 = new ModelRenderer(this, 114, 93);
        this.osteos3.setRotationPoint(0.0F, -2.1F, 0.0F);
        this.osteos3.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 0, 48);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 20.0F);
        this.Tail2.addBox(-2.0F, 0.0F, 1.0F, 4.0F, 0.0F, 40.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.0F, 0.6108652381980153F, 0.0F);
        this.Calf_1 = new ModelRenderer(this, 20, 2);
        this.Calf_1.mirror = true;
        this.Calf_1.setRotationPoint(-1.0F, 10.0F, 2.0F);
        this.Calf_1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Tail_1 = new ModelRenderer(this, 109, 23);
        this.Tail_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail_1.addBox(0.0F, -2.0F, 0.0F, 0.0F, 7.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.Osteos2 = new ModelRenderer(this, 129, 105);
        this.Osteos2.setRotationPoint(0.0F, -2.1F, -7.0F);
        this.Osteos2.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Calf = new ModelRenderer(this, 20, 2);
        this.Calf.setRotationPoint(1.0F, 10.0F, 2.0F);
        this.Calf.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 133, 0);
        this.Head.setRotationPoint(0.0F, -0.5F, -8.0F);
        this.Head.addBox(-3.5F, -1.5F, -8.0F, 7.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Snout.addChild(this.SnoutTeeth);
        this.Jaw.addChild(this.JawSnout);
        this.Body.addChild(this.Body_1);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.Hips);
        this.Body.addChild(this.Arm);
        this.Calf_1.addChild(this.Foot_1);
        this.Body.addChild(this.Thigh);
        this.Body.addChild(this.Neck);
        this.Head.addChild(this.Snout);
        this.Calf.addChild(this.Foot);
        this.Head.addChild(this.Jaw);
        this.JawSnout.addChild(this.JawTeeth);
        this.Body.addChild(this.Arm_1);
        this.Body.addChild(this.Thigh_1);
        this.Body.addChild(this.Osteos);
        this.Tail2.addChild(this.Tail2_1);
        this.Neck.addChild(this.Neck_1);
        this.Tail.addChild(this.osteos3);
        this.Tail.addChild(this.Tail2);
        this.Thigh_1.addChild(this.Calf_1);
        this.Tail.addChild(this.Tail_1);
        this.Neck.addChild(this.Osteos2);
        this.Thigh.addChild(this.Calf);
        this.Neck.addChild(this.Head);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(SaurosuchusSkeletonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
