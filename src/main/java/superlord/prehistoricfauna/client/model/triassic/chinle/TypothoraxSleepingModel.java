package superlord.prehistoricfauna.client.model.triassic.chinle;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.chinle.TypothoraxEntity;

/**
 * typothorax_model - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class TypothoraxSleepingModel extends EntityModel<TypothoraxEntity> {
	public ModelRenderer belly;
    public ModelRenderer Leg_L_front;
    public ModelRenderer Leg_R_front;
    public ModelRenderer Thigh_L;
    public ModelRenderer Thigh_R;
    public ModelRenderer armor;
    public ModelRenderer neck;
    public ModelRenderer Belly_spikes;
    public ModelRenderer tail_base;
    public ModelRenderer armor_spikes;
    public ModelRenderer tail_tip;
    public ModelRenderer Tail_spikes;
    public ModelRenderer Spikes_tail_bottom;
    public ModelRenderer head;
    public ModelRenderer neck_spikes;
    public ModelRenderer snoot;
    public ModelRenderer Leg_L_back;
    public ModelRenderer Foot_L;
    public ModelRenderer Leg_R_back;
    public ModelRenderer Foot;

    public TypothoraxSleepingModel() {
        this.textureWidth = 96;
        this.textureHeight = 64;
        this.head = new ModelRenderer(this, 1, 8);
        this.head.setRotationPoint(0.0F, 0.5F, -3.0F);
        this.head.addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.tail_base = new ModelRenderer(this, 2, 43);
        this.tail_base.setRotationPoint(0.0F, -0.5F, 9.0F);
        this.tail_base.addBox(-2.5F, -1.0F, -1.0F, 5.0F, 4.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tail_base, -0.17121680694433672F, 0.2932153010192419F, 0.048869218223603385F);
        this.armor = new ModelRenderer(this, 0, 23);
        this.armor.setRotationPoint(0.0F, 0.5F, 3.0F);
        this.armor.addBox(-5.0F, -2.0F, -1.0F, 10.0F, 6.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(armor, -0.07330382525481048F, 0.09773843644720677F, 0.0F);
        this.neck = new ModelRenderer(this, 0, 0);
        this.neck.setRotationPoint(0.0F, 1.5F, -4.0F);
        this.neck.addBox(-2.0F, -1.0F, -3.0F, 4.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(neck, 0.5133013303483712F, -0.17104227002439565F, -0.12217304763960307F);
        this.Belly_spikes = new ModelRenderer(this, 63, 10);
        this.Belly_spikes.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Belly_spikes.addBox(-4.5F, 0.0F, -5.0F, 9.0F, 0.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Tail_spikes = new ModelRenderer(this, 64, 30);
        this.Tail_spikes.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail_spikes.addBox(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Foot = new ModelRenderer(this, 43, 11);
        this.Foot.setRotationPoint(0.0F, 4.0F, 1.0F);
        this.Foot.setTextureOffset(9, 0).addBox(-1.5F, -0.01F, -4.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Foot, 1.4903366376253135F, -0.024260076353049827F, -0.048869218223603385F);
        this.Leg_L_back = new ModelRenderer(this, 20, 9);
        this.Leg_L_back.setRotationPoint(1.6F, 2.0F, 2.0F);
        this.Leg_L_back.setTextureOffset(23, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_L_back, -0.7819074915776542F, -0.2200860126843725F, -0.2686061778740398F);
        this.Leg_R_back = new ModelRenderer(this, 43, 9);
        this.Leg_R_back.mirror = true;
        this.Leg_R_back.setRotationPoint(-1.6F, 2.0F, 2.0F);
        this.Leg_R_back.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_R_back, -0.6590362962582867F, 0.19547687289441354F, 0.1464331302344367F);
        this.Leg_R_front = new ModelRenderer(this, 19, 0);
        this.Leg_R_front.mirror = true;
        this.Leg_R_front.setRotationPoint(-3.0F, 22.0F, -7.0F);
        this.Leg_R_front.setTextureOffset(15, 0).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_R_front, -1.1494738560161097F, -0.36634460599886814F, 0.0F);
        this.belly = new ModelRenderer(this, 0, 0);
        this.belly.setRotationPoint(0.0F, 19.0F, -4.0F);
        this.belly.addBox(-4.0F, -1.0F, -5.0F, 8.0F, 6.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(belly, 0.03909537541112055F, 0.0F, 0.0F);
        this.Thigh_R = new ModelRenderer(this, 43, 0);
        this.Thigh_R.mirror = true;
        this.Thigh_R.setRotationPoint(-2.5F, 19.0F, 6.0F);
        this.Thigh_R.addBox(-3.0F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thigh_R, -0.7087782198875415F, 0.19547687289441354F, 0.0F);
        this.Leg_L_front = new ModelRenderer(this, 34, 0);
        this.Leg_L_front.setRotationPoint(3.0F, 22.0F, -7.0F);
        this.Leg_L_front.addBox(0.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_L_front, -1.07634451774697F, 0.2932153010192419F, 0.0F);
        this.Spikes_tail_bottom = new ModelRenderer(this, 70, 41);
        this.Spikes_tail_bottom.setRotationPoint(0.0F, 3.0F, 2.0F);
        this.Spikes_tail_bottom.addBox(-2.5F, 0.0F, 0.0F, 5.0F, 1.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Foot_L = new ModelRenderer(this, 33, 11);
        this.Foot_L.mirror = true;
        this.Foot_L.setRotationPoint(0.0F, 4.0F, 1.0F);
        this.Foot_L.setTextureOffset(19, 0).addBox(-1.5F, -0.01F, -4.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Foot_L, 1.7608626716844347F, 0.0F, 0.293389837939183F);
        this.armor_spikes = new ModelRenderer(this, 59, 19);
        this.armor_spikes.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armor_spikes.addBox(-5.5F, 0.0F, 0.0F, 11.0F, 0.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.snoot = new ModelRenderer(this, 3, 14);
        this.snoot.setRotationPoint(-1.0F, 0.0F, -3.0F);
        this.snoot.addBox(0.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.Thigh_L = new ModelRenderer(this, 43, 0);
        this.Thigh_L.setRotationPoint(3.5F, 19.1F, 6.0F);
        this.Thigh_L.addBox(0.0F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thigh_L, -0.7333873596775006F, -0.2200860126843725F, 0.0F);
        this.neck_spikes = new ModelRenderer(this, 73, 6);
        this.neck_spikes.setRotationPoint(0.0F, 0.0F, -2.5F);
        this.neck_spikes.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.tail_tip = new ModelRenderer(this, 37, 44);
        this.tail_tip.setRotationPoint(0.0F, 0.5F, 9.0F);
        this.tail_tip.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tail_tip, 0.048869218223603385F, 0.24434609527920614F, -0.07330382525481048F);
        this.neck.addChild(this.head);
        this.armor.addChild(this.tail_base);
        this.belly.addChild(this.armor);
        this.belly.addChild(this.neck);
        this.belly.addChild(this.Belly_spikes);
        this.tail_base.addChild(this.Tail_spikes);
        this.Leg_R_back.addChild(this.Foot);
        this.Thigh_L.addChild(this.Leg_L_back);
        this.Thigh_R.addChild(this.Leg_R_back);
        this.tail_base.addChild(this.Spikes_tail_bottom);
        this.Leg_L_back.addChild(this.Foot_L);
        this.armor.addChild(this.armor_spikes);
        this.head.addChild(this.snoot);
        this.neck.addChild(this.neck_spikes);
        this.tail_base.addChild(this.tail_tip);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Leg_R_front, this.belly, this.Thigh_R, this.Leg_L_front, this.Thigh_L).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(TypothoraxEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
