package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.DesmatosuchusSkeletonEntity;

/**
 * DesmatosuchusSkeleton - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class DesmatosuchusSkeletonSleepingModel extends EntityModel<DesmatosuchusSkeletonEntity> {
    public ModelRenderer ASS;
    public ModelRenderer Leg_L_1;
    public ModelRenderer Leg_L_1_1;
    public ModelRenderer Arm_R;
    public ModelRenderer Arm_L;
    public ModelRenderer Belly;
    public ModelRenderer Back_spikes;
    public ModelRenderer TailCarapace;
    public ModelRenderer Sacral_Carapace;
    public ModelRenderer Vertebrae;
    public ModelRenderer Belly_spikes;
    public ModelRenderer Neck;
    public ModelRenderer Thoracic_Carapace;
    public ModelRenderer Belly_1;
    public ModelRenderer Neck_spikes;
    public ModelRenderer Head;
    public ModelRenderer NeckCarapace;
    public ModelRenderer Nose;
    public ModelRenderer Head_1;
    public ModelRenderer Dentary;
    public ModelRenderer Tail_tip;
    public ModelRenderer Tail_base;
    public ModelRenderer Tail_tip_1;
    public ModelRenderer Tail_tip_2;
    public ModelRenderer Tail_base_1;
    public ModelRenderer Leg_L_2;
    public ModelRenderer Feet_L;
    public ModelRenderer Leg_L_2_1;
    public ModelRenderer Feet_L_1;

    public DesmatosuchusSkeletonSleepingModel() {
        this.textureWidth = 160;
        this.textureHeight = 160;
        this.Back_spikes = new ModelRenderer(this, 40, 64);
        this.Back_spikes.setRotationPoint(0.0F, -3.0F, 1.0F);
        this.Back_spikes.addBox(-7.5F, 0.0F, -0.5F, 16.0F, 0.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Vertebrae = new ModelRenderer(this, 102, 23);
        this.Vertebrae.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.Vertebrae.addBox(0.0F, 0.0F, 0.0F, 0.0F, 9.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.Thoracic_Carapace = new ModelRenderer(this, 84, 25);
        this.Thoracic_Carapace.setRotationPoint(0.0F, -3.0F, 1.0F);
        this.Thoracic_Carapace.addBox(-4.5F, 0.0F, -11.0F, 9.0F, 2.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.TailCarapace = new ModelRenderer(this, 84, 77);
        this.TailCarapace.setRotationPoint(0.0F, -2.5F, 12.0F);
        this.TailCarapace.addBox(-3.5F, -1.0F, 0.0F, 7.0F, 2.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(TailCarapace, -0.20943951023931953F, 0.19198621771937624F, 0.0F);
        this.Neck = new ModelRenderer(this, 47, 1);
        this.Neck.setRotationPoint(0.0F, -1.5F, -9.5F);
        this.Neck.addBox(0.0F, -0.5F, -6.0F, 0.0F, 5.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.24434609527920614F, -0.2617993877991494F, 0.0F);
        this.Nose = new ModelRenderer(this, 67, 1);
        this.Nose.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.Nose.addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Tail_tip = new ModelRenderer(this, 87, 105);
        this.Tail_tip.setRotationPoint(0.0F, 0.5F, 15.0F);
        this.Tail_tip.addBox(-1.5F, -1.0F, 0.0F, 3.0F, 4.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail_tip, 0.0F, 0.3839724354387525F, 0.0F);
        this.Leg_L_1 = new ModelRenderer(this, 2, 48);
        this.Leg_L_1.setRotationPoint(2.0F, 19.5F, 10.0F);
        this.Leg_L_1.addBox(0.0F, 0.0F, -2.0F, 5.0F, 9.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_L_1, -2.0594885173533086F, -0.3490658503988659F, 0.17453292519943295F);
        this.Arm_R = new ModelRenderer(this, 44, 32);
        this.Arm_R.mirror = true;
        this.Arm_R.setRotationPoint(-2.5F, 21.5F, -5.0F);
        this.Arm_R.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm_R, -1.413716694115407F, -0.17453292519943295F, -0.0F);
        this.Arm_L = new ModelRenderer(this, 44, 32);
        this.Arm_L.setRotationPoint(4.5F, 21.5F, -3.5F);
        this.Arm_L.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm_L, -1.413716694115407F, -0.4886921905584123F, 0.0F);
        this.Tail_base_1 = new ModelRenderer(this, 8, 77);
        this.Tail_base_1.setRotationPoint(0.0F, 2.0F, 1.0F);
        this.Tail_base_1.addBox(0.0F, -3.0F, 0.0F, 0.0F, 5.5F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 65, 11);
        this.Head.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.Head.addBox(-2.0F, -1.0F, -3.0F, 4.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Feet_L = new ModelRenderer(this, 0, 61);
        this.Feet_L.setRotationPoint(0.0F, 5.5F, -1.0F);
        this.Feet_L.addBox(-1.8F, 0.0F, -5.0F, 4.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Feet_L, 0.41887902047863906F, 0.0F, -0.17453292519943295F);
        this.Head_1 = new ModelRenderer(this, 66, 26);
        this.Head_1.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Head_1.addBox(-2.0F, 0.0F, -3.0F, 4.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Belly = new ModelRenderer(this, 0, 24);
        this.Belly.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.Belly.addBox(-4.0F, -2.5F, -10.0F, 8.0F, 7.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Belly, 0.08726646259971647F, -0.2617993877991494F, 0.0F);
        this.Dentary = new ModelRenderer(this, 69, 20);
        this.Dentary.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.Dentary.addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Dentary, 0.0F, 0.001745329278001762F, 0.0F);
        this.Leg_L_2 = new ModelRenderer(this, 24, 51);
        this.Leg_L_2.setRotationPoint(2.9F, 6.0F, 0.0F);
        this.Leg_L_2.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_L_2, 1.5707963267948966F, 0.0F, 0.0F);
        this.Belly_1 = new ModelRenderer(this, 86, 51);
        this.Belly_1.setRotationPoint(0.0F, -1.0F, -4.0F);
        this.Belly_1.addBox(-4.5F, 0.0F, -6.0F, 9.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.ASS = new ModelRenderer(this, 0, 0);
        this.ASS.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.ASS.addBox(-6.0F, -3.0F, 0.0F, 12.0F, 4.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.Feet_L_1 = new ModelRenderer(this, 0, 61);
        this.Feet_L_1.mirror = true;
        this.Feet_L_1.setRotationPoint(-0.4F, 5.5F, -1.0F);
        this.Feet_L_1.addBox(-1.8F, 0.0F, -5.0F, 4.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Feet_L_1, 0.41887902047863906F, 0.0F, 0.17453292519943295F);
        this.Belly_spikes = new ModelRenderer(this, 31, 53);
        this.Belly_spikes.setRotationPoint(0.0F, 0.0F, 0.5F);
        this.Belly_spikes.addBox(-9.5F, -2.5F, -11.0F, 19.0F, 0.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.Sacral_Carapace = new ModelRenderer(this, 84, 0);
        this.Sacral_Carapace.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Sacral_Carapace.addBox(-6.5F, -4.0F, 0.0F, 13.0F, 2.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.Leg_L_2_1 = new ModelRenderer(this, 24, 51);
        this.Leg_L_2_1.mirror = true;
        this.Leg_L_2_1.setRotationPoint(-2.9F, 6.0F, 0.0F);
        this.Leg_L_2_1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_L_2_1, 1.5707963267948966F, 0.0F, 0.0F);
        this.Tail_base = new ModelRenderer(this, 0, 77);
        this.Tail_base.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail_base.addBox(-3.5F, 0.0F, -1.0F, 7.0F, 0.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.Tail_tip_1 = new ModelRenderer(this, 0, 102);
        this.Tail_tip_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail_tip_1.addBox(0.0F, -1.0F, -3.0F, 0.0F, 4.0F, 25.0F, 0.0F, 0.0F, 0.0F);
        this.Leg_L_1_1 = new ModelRenderer(this, 2, 48);
        this.Leg_L_1_1.mirror = true;
        this.Leg_L_1_1.setRotationPoint(-2.0F, 19.5F, 10.0F);
        this.Leg_L_1_1.addBox(-5.0F, 0.0F, -2.0F, 5.0F, 9.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_L_1_1, -2.0594885173533086F, 0.3490658503988659F, -0.17453292519943295F);
        this.NeckCarapace = new ModelRenderer(this, 127, 1);
        this.NeckCarapace.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.NeckCarapace.addBox(-2.0F, -1.0F, -6.0F, 4.0F, 1.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Tail_tip_2 = new ModelRenderer(this, 3, 105);
        this.Tail_tip_2.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Tail_tip_2.addBox(-1.5F, -1.0F, 0.0F, 3.0F, 0.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.Neck_spikes = new ModelRenderer(this, 55, 48);
        this.Neck_spikes.setRotationPoint(0.0F, -0.5F, -2.0F);
        this.Neck_spikes.addBox(-4.5F, 0.0F, -4.0F, 9.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.ASS.addChild(this.Back_spikes);
        this.ASS.addChild(this.Vertebrae);
        this.Belly.addChild(this.Thoracic_Carapace);
        this.ASS.addChild(this.TailCarapace);
        this.Belly.addChild(this.Neck);
        this.Head.addChild(this.Nose);
        this.TailCarapace.addChild(this.Tail_tip);
        this.Tail_base.addChild(this.Tail_base_1);
        this.Neck.addChild(this.Head);
        this.Leg_L_2.addChild(this.Feet_L);
        this.Head.addChild(this.Head_1);
        this.ASS.addChild(this.Belly);
        this.Head_1.addChild(this.Dentary);
        this.Leg_L_1.addChild(this.Leg_L_2);
        this.Belly.addChild(this.Belly_1);
        this.Leg_L_2_1.addChild(this.Feet_L_1);
        this.Belly.addChild(this.Belly_spikes);
        this.ASS.addChild(this.Sacral_Carapace);
        this.Leg_L_1_1.addChild(this.Leg_L_2_1);
        this.TailCarapace.addChild(this.Tail_base);
        this.Tail_tip.addChild(this.Tail_tip_1);
        this.Neck.addChild(this.NeckCarapace);
        this.Tail_tip_1.addChild(this.Tail_tip_2);
        this.Neck.addChild(this.Neck_spikes);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Leg_L_1, this.Arm_R, this.Arm_L, this.ASS, this.Leg_L_1_1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(DesmatosuchusSkeletonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
