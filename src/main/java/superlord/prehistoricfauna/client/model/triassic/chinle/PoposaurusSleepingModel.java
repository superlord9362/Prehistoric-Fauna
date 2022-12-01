package superlord.prehistoricfauna.client.model.triassic.chinle;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PoposaurusEntity;

/**
 * PoposaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class PoposaurusSleepingModel extends EntityModel<PoposaurusEntity> {
    public ModelRenderer Thigh_R;
    public ModelRenderer Thigh_L;
    public ModelRenderer Body;
    public ModelRenderer Leg_R;
    public ModelRenderer Foot_R;
    public ModelRenderer Leg_L;
    public ModelRenderer Foot_L;
    public ModelRenderer Arm_L;
    public ModelRenderer Arm_R;
    public ModelRenderer Tail_1;
    public ModelRenderer Neck;
    public ModelRenderer Tail_2;
    public ModelRenderer Tail_3;
    public ModelRenderer Head;
    public ModelRenderer Jaw_base;
    public ModelRenderer Snoot;
    public ModelRenderer Throat;
    public ModelRenderer Jaw_tip;
    public ModelRenderer Teeth_bot;
    public ModelRenderer Teeth_top;

    public PoposaurusSleepingModel() {
        this.textureWidth = 120;
        this.textureHeight = 160;
        this.Thigh_L = new ModelRenderer(this, 60, 40);
        this.Thigh_L.setRotationPoint(3.0F, 12.0F, 4.0F);
        this.Thigh_L.addBox(0.0F, 0.0F, 0.0F, 4.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thigh_L, -0.8726646259971648F, -0.3490658503988659F, 0.0F);
        this.Foot_R = new ModelRenderer(this, 39, 57);
        this.Foot_R.mirror = true;
        this.Foot_R.setRotationPoint(0.0F, 9.0F, 2.0F);
        this.Foot_R.addBox(-2.0F, 0.0F, -6.0F, 4.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Foot_R, 1.5707963267948966F, 0.0F, -0.0781907508222411F);
        this.Jaw_tip = new ModelRenderer(this, 75, 12);
        this.Jaw_tip.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.Jaw_tip.addBox(-1.5F, 0.0F, -7.0F, 3.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Jaw_tip, 0.001745329278001762F, 0.0F, 0.0F);
        this.Throat = new ModelRenderer(this, 1, 19);
        this.Throat.setRotationPoint(0.0F, -0.9F, -0.01F);
        this.Throat.addBox(-2.01F, -2.0F, -4.0F, 4.02F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Teeth_bot = new ModelRenderer(this, 98, 12);
        this.Teeth_bot.setRotationPoint(0.0F, 0.0F, 0.2F);
        this.Teeth_bot.addBox(-1.0F, -1.0F, -6.7F, 2.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Snoot = new ModelRenderer(this, 75, 0);
        this.Snoot.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.Snoot.addBox(-1.5F, 0.0F, -7.0F, 3.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Arm_L = new ModelRenderer(this, 45, 40);
        this.Arm_L.setRotationPoint(3.5F, 9.0F, -14.0F);
        this.Arm_L.addBox(0.0F, 0.0F, 0.0F, 2.0F, 10.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm_L, -1.13376586611655F, 0.0F, -1.524545074985436F);
        this.Leg_R = new ModelRenderer(this, 85, 40);
        this.Leg_R.mirror = true;
        this.Leg_R.setRotationPoint(-2.0F, 7.0F, 5.0F);
        this.Leg_R.addBox(-1.5F, -1.0F, 0.0F, 3.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_R, -0.6981317007977318F, 0.0F, 0.0F);
        this.Foot_L = new ModelRenderer(this, 39, 57);
        this.Foot_L.setRotationPoint(0.0F, 9.0F, 2.0F);
        this.Foot_L.addBox(-2.0F, 0.0F, -6.0F, 4.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Foot_L, 1.5707963267948966F, 0.0F, 0.0F);
        this.Tail_3 = new ModelRenderer(this, 0, 89);
        this.Tail_3.setRotationPoint(0.0F, -0.5F, 16.0F);
        this.Tail_3.addBox(-0.5F, -2.0F, 0.0F, 1.0F, 4.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail_3, -0.03490658503988659F, 0.35185837453889574F, -0.0781907508222411F);
        this.Neck = new ModelRenderer(this, 0, 0);
        this.Neck.setRotationPoint(-1.0F, 1.0F, -18.0F);
        this.Neck.addBox(-2.0F, -3.0F, -9.0F, 4.0F, 7.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.5864306020384839F, -0.6646214111173737F, 0.0F);
        this.Arm_R = new ModelRenderer(this, 45, 40);
        this.Arm_R.mirror = true;
        this.Arm_R.setRotationPoint(-3.5F, 7.0F, -15.0F);
        this.Arm_R.addBox(-2.0F, 0.0F, 0.0F, 2.0F, 10.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm_R, -1.0555751236166873F, -0.11728612207217244F, 1.2901473511162753F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 16.0F, 1.0F);
        this.Body.addBox(-4.5F, -3.0F, -20.0F, 9.0F, 11.0F, 28.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, -0.03909537541112055F, 0.03909537541112055F, 0.0F);
        this.Jaw_base = new ModelRenderer(this, 50, 12);
        this.Jaw_base.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.Jaw_base.addBox(-2.5F, 0.0F, -5.0F, 5.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Jaw_base, 0.3127630032889644F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 50, 0);
        this.Head.setRotationPoint(0.0F, -1.6F, -8.0F);
        this.Head.addBox(-2.5F, 0.0F, -5.0F, 5.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -0.8600982340775168F, -0.3909537457888271F, 0.19547687289441354F);
        this.Teeth_top = new ModelRenderer(this, 98, 0);
        this.Teeth_top.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.Teeth_top.addBox(-1.0F, 0.0F, -6.7F, 2.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Teeth_top, -0.001745329278001762F, 0.0F, 0.0F);
        this.Leg_L = new ModelRenderer(this, 85, 40);
        this.Leg_L.setRotationPoint(2.0F, 7.0F, 5.0F);
        this.Leg_L.addBox(-1.5F, -1.0F, 0.0F, 3.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_L, -0.6981317007977318F, 0.0F, 0.0F);
        this.Tail_1 = new ModelRenderer(this, 0, 40);
        this.Tail_1.setRotationPoint(-1.0F, 1.0F, 5.0F);
        this.Tail_1.addBox(-3.0F, -5.0F, 0.0F, 6.0F, 8.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail_1, -0.15707963267948966F, 0.5082398928281348F, 0.0781907508222411F);
        this.Tail_2 = new ModelRenderer(this, 0, 63);
        this.Tail_2.setRotationPoint(0.0F, -1.5F, 13.0F);
        this.Tail_2.addBox(-1.5F, -3.0F, -1.0F, 3.0F, 6.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail_2, -0.03490658503988659F, 0.5082398928281348F, -0.19547687289441354F);
        this.Thigh_R = new ModelRenderer(this, 60, 40);
        this.Thigh_R.mirror = true;
        this.Thigh_R.setRotationPoint(-2.7F, 12.0F, 4.2F);
        this.Thigh_R.addBox(-4.0F, 0.0F, 0.0F, 4.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thigh_R, -0.8726646259971648F, 0.3490658503988659F, 0.0F);
        this.Leg_R.addChild(this.Foot_R);
        this.Jaw_base.addChild(this.Jaw_tip);
        this.Jaw_base.addChild(this.Throat);
        this.Jaw_tip.addChild(this.Teeth_bot);
        this.Head.addChild(this.Snoot);
        this.Body.addChild(this.Arm_L);
        this.Thigh_R.addChild(this.Leg_R);
        this.Leg_L.addChild(this.Foot_L);
        this.Tail_2.addChild(this.Tail_3);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.Arm_R);
        this.Head.addChild(this.Jaw_base);
        this.Neck.addChild(this.Head);
        this.Snoot.addChild(this.Teeth_top);
        this.Thigh_L.addChild(this.Leg_L);
        this.Body.addChild(this.Tail_1);
        this.Tail_1.addChild(this.Tail_2);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Thigh_L, this.Body, this.Thigh_R).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(PoposaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
