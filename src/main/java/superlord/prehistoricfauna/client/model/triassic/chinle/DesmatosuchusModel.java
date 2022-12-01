package superlord.prehistoricfauna.client.model.triassic.chinle;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.chinle.DesmatosuchusEntity;

/**
 * desmatosuchus - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class DesmatosuchusModel extends EntityModel<DesmatosuchusEntity> {
    public ModelRenderer ASS;
    public ModelRenderer Arm_L;
    public ModelRenderer Arm_R;
    public ModelRenderer Leg_L_1;
    public ModelRenderer Leg_L_1_1;
    public ModelRenderer Belly;
    public ModelRenderer Tail_base;
    public ModelRenderer Back_spikes;
    public ModelRenderer Neck;
    public ModelRenderer Belly_spikes;
    public ModelRenderer Head;
    public ModelRenderer Neck_spikes;
    public ModelRenderer Nose;
    public ModelRenderer part8;
    public ModelRenderer Tail_tip;
    public ModelRenderer Leg_L_2;
    public ModelRenderer Feet_L;
    public ModelRenderer Leg_L_2_1;
    public ModelRenderer Feet_L_1;

    public DesmatosuchusModel() {
    	this.textureWidth = 80;
        this.textureHeight = 160;
        this.Leg_L_1 = new ModelRenderer(this, 0, 45);
        this.Leg_L_1.setRotationPoint(2.5F, 8.0F, 10.0F);
        this.Leg_L_1.addBox(0.0F, 0.0F, -2.0F, 5.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Belly_spikes = new ModelRenderer(this, 32, 53);
        this.Belly_spikes.setRotationPoint(0.0F, 0.0F, 0.5F);
        this.Belly_spikes.addBox(-9.0F, -2.5F, -11.0F, 18.0F, 0.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.Neck_spikes = new ModelRenderer(this, 55, 48);
        this.Neck_spikes.setRotationPoint(0.0F, -0.5F, -2.0F);
        this.Neck_spikes.addBox(-4.5F, 0.0F, -4.0F, 9.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Tail_tip = new ModelRenderer(this, 0, 102);
        this.Tail_tip.setRotationPoint(0.0F, -1.5F, 13.0F);
        this.Tail_tip.addBox(-1.5F, -1.0F, 0.0F, 3.0F, 4.0F, 25.0F, 0.0F, 0.0F, 0.0F);
        this.Feet_L_1 = new ModelRenderer(this, 0, 61);
        this.Feet_L_1.mirror = true;
        this.Feet_L_1.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.Feet_L_1.addBox(-1.8F, 0.0F, -5.0F, 4.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.ASS = new ModelRenderer(this, 0, 0);
        this.ASS.setRotationPoint(0.0F, 11.0F, 0.0F);
        this.ASS.addBox(-6.5F, -4.0F, 0.0F, 13.0F, 10.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 65, 11);
        this.Head.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.Head.addBox(-2.0F, -1.0F, -4.0F, 4.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Nose = new ModelRenderer(this, 67, 1);
        this.Nose.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.Nose.addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Arm_R = new ModelRenderer(this, 44, 32);
        this.Arm_R.mirror = true;
        this.Arm_R.setRotationPoint(-4.0F, 11.0F, -7.5F);
        this.Arm_R.addBox(-2.0F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Feet_L = new ModelRenderer(this, 0, 61);
        this.Feet_L.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.Feet_L.addBox(-1.8F, 0.0F, -5.0F, 4.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.part8 = new ModelRenderer(this, 68, 19);
        this.part8.setRotationPoint(0.0F, 1.0F, 1.0F);
        this.part8.addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(part8, 0.0F, 0.001745329278001762F, 0.0F);
        this.Leg_L_2 = new ModelRenderer(this, 24, 51);
        this.Leg_L_2.setRotationPoint(2.8F, 9.0F, 1.0F);
        this.Leg_L_2.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Belly = new ModelRenderer(this, 0, 25);
        this.Belly.setRotationPoint(0.0F, -0.5F, -1.0F);
        this.Belly.addBox(-4.5F, -3.0F, -10.0F, 9.0F, 9.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.Back_spikes = new ModelRenderer(this, 40, 64);
        this.Back_spikes.setRotationPoint(0.0F, -3.0F, 1.0F);
        this.Back_spikes.addBox(-8.0F, 0.0F, -0.5F, 16.0F, 0.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Leg_L_2_1 = new ModelRenderer(this, 24, 51);
        this.Leg_L_2_1.mirror = true;
        this.Leg_L_2_1.setRotationPoint(-2.9F, 9.0F, 1.0F);
        this.Leg_L_2_1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Leg_L_1_1 = new ModelRenderer(this, 0, 45);
        this.Leg_L_1_1.mirror = true;
        this.Leg_L_1_1.setRotationPoint(-2.5F, 8.0F, 10.0F);
        this.Leg_L_1_1.addBox(-5.0F, 0.0F, -2.0F, 5.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 43, 1);
        this.Neck.setRotationPoint(0.0F, -1.5F, -9.5F);
        this.Neck.addBox(-2.0F, -1.0F, -6.0F, 4.0F, 5.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Arm_L = new ModelRenderer(this, 44, 32);
        this.Arm_L.setRotationPoint(4.0F, 11.0F, -7.5F);
        this.Arm_L.addBox(-1.0F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Tail_base = new ModelRenderer(this, 0, 77);
        this.Tail_base.setRotationPoint(0.0F, -0.5F, 12.0F);
        this.Tail_base.addBox(-3.5F, -3.0F, 0.0F, 7.0F, 7.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.Belly.addChild(this.Belly_spikes);
        this.Neck.addChild(this.Neck_spikes);
        this.Tail_base.addChild(this.Tail_tip);
        this.Leg_L_2_1.addChild(this.Feet_L_1);
        this.Neck.addChild(this.Head);
        this.Head.addChild(this.Nose);
        this.Leg_L_2.addChild(this.Feet_L);
        this.Nose.addChild(this.part8);
        this.Leg_L_1.addChild(this.Leg_L_2);
        this.ASS.addChild(this.Belly);
        this.ASS.addChild(this.Back_spikes);
        this.Leg_L_1_1.addChild(this.Leg_L_2_1);
        this.Belly.addChild(this.Neck);
        this.ASS.addChild(this.Tail_base);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Leg_L_1, this.ASS, this.Arm_R, this.Leg_L_1_1, this.Arm_L).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(DesmatosuchusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress = entityIn.getMeleeProgress(partialTick) * 2.0F;
		this.Belly.rotateAngleX = 0F;
		this.Leg_L_1.rotateAngleX = -0F;
		this.Leg_L_1_1.rotateAngleX = -0F;
		this.Arm_L.rotateAngleX = -0F;
		this.Arm_R.rotateAngleX = -0F;
		this.Arm_L.rotateAngleZ = 0F;
		this.Arm_R.rotateAngleZ = -0F;
		this.Arm_L.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
		this.Arm_R.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
		this.Leg_L_1_1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
		this.Leg_L_2_1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
		this.Feet_L_1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
		this.Leg_L_1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
		this.Leg_L_2.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
		this.Feet_L.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
		this.Tail_base.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
		this.Tail_tip.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
		this.Tail_base.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
		this.Tail_tip.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
		this.Neck.rotateAngleX = (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F);
		this.Head.rotateAngleX = (-Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.05F) + attackProgress * (float) Math.toRadians(25F);
		if (entityIn.isEating()) {
			this.Neck.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
			this.Belly.rotateAngleX = 0.1F;
			this.Leg_L_1.rotateAngleX = -0.1F;
			this.Leg_L_1_1.rotateAngleX = -0.1F;
			this.Arm_R.rotateAngleX = -0.1F;
			this.Arm_L.rotateAngleX = -0.1F;
			this.Arm_R.rotateAngleZ = 0.3F;
			this.Arm_L.rotateAngleZ = -0.3F;
		}
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
