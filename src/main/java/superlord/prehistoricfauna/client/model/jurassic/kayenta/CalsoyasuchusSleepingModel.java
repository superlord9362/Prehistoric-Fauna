package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.CalsoyasuchusEntity;

/**
 * Calsoyasuchus - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class CalsoyasuchusSleepingModel extends EntityModel<CalsoyasuchusEntity> {
    public ModelRenderer belly;
    public ModelRenderer FrontL;
    public ModelRenderer BackL;
    public ModelRenderer FrontR;
    public ModelRenderer BackR;
    public ModelRenderer tail;
    public ModelRenderer head;
    public ModelRenderer bodyspikes;
    public ModelRenderer tailspikes;
    public ModelRenderer eyes;
    public ModelRenderer hand;
    public ModelRenderer feet;
    public ModelRenderer hand_1;
    public ModelRenderer feet_1;

    public CalsoyasuchusSleepingModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.tail = new ModelRenderer(this, 15, 1);
        this.tail.setRotationPoint(0.0F, 0.1F, 7.0F);
        this.tail.addBox(-1.0F, -0.9F, -1.0F, 2.0F, 2.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tail, -0.0572467989660713F, 0.3909537457888271F, 0.0F);
        this.tailspikes = new ModelRenderer(this, 14, 18);
        this.tailspikes.setRotationPoint(0.0F, -1.5F, 0.0F);
        this.tailspikes.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.FrontR = new ModelRenderer(this, 0, 0);
        this.FrontR.mirror = true;
        this.FrontR.setRotationPoint(-1.0F, 23.0F, -3.0F);
        this.FrontR.addBox(-1.0F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FrontR, 0.0F, 0.0F, 1.0946705281561322F);
        this.bodyspikes = new ModelRenderer(this, 0, 18);
        this.bodyspikes.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.bodyspikes.addBox(-1.0F, -0.5F, -4.0F, 2.0F, 1.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 34, 0);
        this.head.setRotationPoint(0.0F, 0.1F, -3.5F);
        this.head.addBox(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(head, 0.11728612207217244F, -0.3909537457888271F, 0.0F);
        this.hand = new ModelRenderer(this, 19, 51);
        this.hand.setRotationPoint(0.5F, 3.0F, -1.0F);
        this.hand.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hand, 0.0F, 0.0F, 1.1728612040769677F);
        this.eyes = new ModelRenderer(this, 47, 1);
        this.eyes.setRotationPoint(0.0F, 0.0F, -4.0F);
        this.eyes.addBox(-1.5F, -1.5F, 0.0F, 3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.belly = new ModelRenderer(this, 0, 0);
        this.belly.setRotationPoint(0.0F, 22.0F, -1.0F);
        this.belly.addBox(-1.5F, -1.0F, -4.0F, 3.0F, 3.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.hand_1 = new ModelRenderer(this, 19, 51);
        this.hand_1.mirror = true;
        this.hand_1.setRotationPoint(-0.5F, 3.0F, -1.0F);
        this.hand_1.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hand_1, 0.0F, 0.0F, -1.0946705281561322F);
        this.feet = new ModelRenderer(this, 13, 52);
        this.feet.mirror = true;
        this.feet.setRotationPoint(1.0F, 3.0F, -1.0F);
        this.feet.addBox(-1.0F, 0.0F, -2.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(feet, 0.0F, 0.0F, 0.9382889765773795F);
        this.feet_1 = new ModelRenderer(this, 13, 52);
        this.feet_1.setRotationPoint(-1.0F, 3.0F, -1.0F);
        this.feet_1.addBox(-2.0F, 0.0F, -2.0F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(feet_1, 0.0F, 0.0F, -0.9382889765773795F);
        this.BackR = new ModelRenderer(this, 18, 0);
        this.BackR.mirror = true;
        this.BackR.setRotationPoint(-1.0F, 23.0F, 4.0F);
        this.BackR.addBox(-1.0F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(BackR, 0.0F, 0.0F, 0.9382889765773795F);
        this.BackL = new ModelRenderer(this, 18, 0);
        this.BackL.setRotationPoint(1.0F, 23.0F, 4.0F);
        this.BackL.addBox(0.0F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(BackL, 0.0F, 0.0F, -0.9382889765773795F);
        this.FrontL = new ModelRenderer(this, 0, 0);
        this.FrontL.setRotationPoint(1.0F, 23.3F, -3.0F);
        this.FrontL.addBox(0.0F, -1.0F, -1.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FrontL, 0.0F, 0.0F, -1.1728612040769677F);
        this.belly.addChild(this.tail);
        this.tail.addChild(this.tailspikes);
        this.belly.addChild(this.bodyspikes);
        this.belly.addChild(this.head);
        this.FrontL.addChild(this.hand);
        this.head.addChild(this.eyes);
        this.FrontR.addChild(this.hand_1);
        this.BackL.addChild(this.feet);
        this.BackR.addChild(this.feet_1);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.FrontR, this.belly, this.BackR, this.BackL, this.FrontL).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(CalsoyasuchusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
