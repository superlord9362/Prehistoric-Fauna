package superlord.prehistoricfauna.client.model.triassic.chinle;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.chinle.DesmatosuchusEntity;

/**
 * DesmatosuchusSleepingModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class DesmatosuchusSleepingModel extends EntityModel<DesmatosuchusEntity> {
    public ModelRenderer Arm_L;
    public ModelRenderer ASS;
    public ModelRenderer Arm_R;
    public ModelRenderer Leg_L_1;
    public ModelRenderer Leg_L_1_1;
    public ModelRenderer Back_spikes;
    public ModelRenderer Tail_base;
    public ModelRenderer Belly;
    public ModelRenderer Tail_tip;
    public ModelRenderer Neck;
    public ModelRenderer Belly_spikes;
    public ModelRenderer Head;
    public ModelRenderer Neck_spikes;
    public ModelRenderer Nose;
    public ModelRenderer part8;
    public ModelRenderer Leg_L_2;
    public ModelRenderer Feet_L;
    public ModelRenderer Leg_L_2_1;
    public ModelRenderer Feet_L_1;

    public DesmatosuchusSleepingModel() {
        this.textureWidth = 80;
        this.textureHeight = 160;
        this.Back_spikes = new ModelRenderer(this, 40, 64);
        this.Back_spikes.setRotationPoint(0.0F, -3.0F, 1.0F);
        this.Back_spikes.addBox(-8.0F, 0.0F, -0.5F, 16.0F, 0.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Feet_L_1 = new ModelRenderer(this, 0, 61);
        this.Feet_L_1.mirror = true;
        this.Feet_L_1.setRotationPoint(0.0F, 5.2F, -1.0F);
        this.Feet_L_1.addBox(-1.8F, 0.0F, -5.0F, 4.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Feet_L_1, 0.41887902047863906F, 0.0F, 0.17453292519943295F);
        this.Leg_L_1 = new ModelRenderer(this, 0, 45);
        this.Leg_L_1.setRotationPoint(3.5F, 20.4F, 10.0F);
        this.Leg_L_1.addBox(0.0F, -2.0F, -3.0F, 5.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_L_1, -2.234021442552742F, -0.3490658503988659F, 0.17453292519943295F);
        this.Neck_spikes = new ModelRenderer(this, 55, 48);
        this.Neck_spikes.setRotationPoint(0.0F, -0.5F, -2.0F);
        this.Neck_spikes.addBox(-4.5F, 0.0F, -4.0F, 9.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.part8 = new ModelRenderer(this, 68, 19);
        this.part8.setRotationPoint(0.0F, 1.0F, 1.0F);
        this.part8.addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(part8, 0.0F, 0.001745329278001762F, 0.0F);
        this.Belly_spikes = new ModelRenderer(this, 32, 53);
        this.Belly_spikes.setRotationPoint(0.0F, 0.0F, 0.5F);
        this.Belly_spikes.addBox(-9.0F, -2.5F, -11.0F, 18.0F, 0.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.Nose = new ModelRenderer(this, 67, 1);
        this.Nose.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.Nose.addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Arm_L = new ModelRenderer(this, 44, 32);
        this.Arm_L.setRotationPoint(4.5F, 21.5F, -3.5F);
        this.Arm_L.addBox(-1.0F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm_L, -1.48352986419518F, -0.4886921905584123F, 0.0F);
        this.Belly = new ModelRenderer(this, 0, 25);
        this.Belly.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.Belly.addBox(-4.5F, -3.0F, -10.0F, 9.0F, 9.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Belly, 0.08726646259971647F, -0.2617993877991494F, 0.0F);
        this.Neck = new ModelRenderer(this, 43, 1);
        this.Neck.setRotationPoint(0.0F, -1.5F, -9.5F);
        this.Neck.addBox(-2.0F, -1.0F, -6.0F, 4.0F, 5.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.24434609527920614F, -0.2617993877991494F, 0.0F);
        this.Arm_R = new ModelRenderer(this, 44, 32);
        this.Arm_R.mirror = true;
        this.Arm_R.setRotationPoint(-3.0F, 21.5F, -5.0F);
        this.Arm_R.addBox(-2.0F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm_R, -1.48352986419518F, -0.17453292519943295F, 0.0F);
        this.Tail_tip = new ModelRenderer(this, 0, 102);
        this.Tail_tip.setRotationPoint(0.0F, -1.5F, 13.0F);
        this.Tail_tip.addBox(-1.5F, -1.0F, 0.0F, 3.0F, 4.0F, 25.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail_tip, 0.0F, 0.3839724354387525F, 0.0F);
        this.ASS = new ModelRenderer(this, 0, 0);
        this.ASS.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.ASS.addBox(-6.5F, -4.0F, 0.0F, 13.0F, 10.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.Leg_L_1_1 = new ModelRenderer(this, 0, 45);
        this.Leg_L_1_1.mirror = true;
        this.Leg_L_1_1.setRotationPoint(-3.5F, 20.4F, 10.0F);
        this.Leg_L_1_1.addBox(-5.0F, -2.0F, -3.0F, 5.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_L_1_1, -2.234021442552742F, 0.3490658503988659F, -0.17453292519943295F);
        this.Head = new ModelRenderer(this, 65, 11);
        this.Head.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.Head.addBox(-2.0F, -1.0F, -4.0F, 4.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Leg_L_2 = new ModelRenderer(this, 24, 51);
        this.Leg_L_2.setRotationPoint(2.8F, 6.0F, 0.3F);
        this.Leg_L_2.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_L_2, 1.7453292519943295F, 0.0F, 0.0F);
        this.Feet_L = new ModelRenderer(this, 0, 61);
        this.Feet_L.setRotationPoint(0.0F, 5.2F, -1.0F);
        this.Feet_L.addBox(-1.8F, 0.0F, -5.0F, 4.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Feet_L, 0.41887902047863906F, 0.0F, -0.17453292519943295F);
        this.Leg_L_2_1 = new ModelRenderer(this, 24, 51);
        this.Leg_L_2_1.mirror = true;
        this.Leg_L_2_1.setRotationPoint(-2.8F, 6.0F, 0.3F);
        this.Leg_L_2_1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_L_2_1, 1.7453292519943295F, 0.0F, 0.0F);
        this.Tail_base = new ModelRenderer(this, 0, 77);
        this.Tail_base.setRotationPoint(0.0F, -0.5F, 12.0F);
        this.Tail_base.addBox(-3.5F, -3.0F, 0.0F, 7.0F, 7.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail_base, -0.17453292519943295F, 0.19198621771937624F, 0.0F);
        this.ASS.addChild(this.Back_spikes);
        this.Leg_L_2_1.addChild(this.Feet_L_1);
        this.Neck.addChild(this.Neck_spikes);
        this.Nose.addChild(this.part8);
        this.Belly.addChild(this.Belly_spikes);
        this.Head.addChild(this.Nose);
        this.ASS.addChild(this.Belly);
        this.Belly.addChild(this.Neck);
        this.Tail_base.addChild(this.Tail_tip);
        this.Neck.addChild(this.Head);
        this.Leg_L_1.addChild(this.Leg_L_2);
        this.Leg_L_2.addChild(this.Feet_L);
        this.Leg_L_1_1.addChild(this.Leg_L_2_1);
        this.ASS.addChild(this.Tail_base);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Leg_L_1, this.Arm_L, this.Arm_R, this.ASS, this.Leg_L_1_1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(DesmatosuchusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
