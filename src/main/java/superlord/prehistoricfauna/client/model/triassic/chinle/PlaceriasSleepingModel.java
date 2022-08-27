package superlord.prehistoricfauna.client.model.triassic.chinle;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PlaceriasEntity;

/**
 * Placerias - PedroRalof
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class PlaceriasSleepingModel extends EntityModel<PlaceriasEntity> {
    public ModelRenderer Body;
    public ModelRenderer Leg_front_left;
    public ModelRenderer Leg_front_right;
    public ModelRenderer Leg_back_right;
    public ModelRenderer Leg_back_right_1;
    public ModelRenderer neck;
    public ModelRenderer tail;
    public ModelRenderer head;
    public ModelRenderer beak;

    public PlaceriasSleepingModel() {
        this.textureWidth = 128;
        this.textureHeight = 160;
        this.Leg_back_right_1 = new ModelRenderer(this, 34, 54);
        this.Leg_back_right_1.setRotationPoint(-3.0F, 20.0F, 5.0F);
        this.Leg_back_right_1.addBox(-3.0F, 0.0F, -2.0F, 3.0F, 14.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_back_right_1, 1.2906709285865847F, -0.03909537541112055F, 0.1563815016444822F);
        this.Body = new ModelRenderer(this, 0, 17);
        this.Body.setRotationPoint(0.0F, 16.1F, 0.0F);
        this.Body.addBox(-4.4F, -5.0F, -9.0F, 9.0F, 13.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, -0.03909537541112055F, 0.0F, 0.0F);
        this.Leg_front_left = new ModelRenderer(this, 14, 55);
        this.Leg_front_left.mirror = true;
        this.Leg_front_left.setRotationPoint(-3.8F, 19.6F, -6.0F);
        this.Leg_front_left.addBox(-3.0F, -3.0F, -1.0F, 3.0F, 12.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_front_left, -1.1344640137963142F, -0.4300491170387584F, -0.1563815016444822F);
        this.beak = new ModelRenderer(this, 0, 0);
        this.beak.setRotationPoint(0.0F, -1.5F, -3.5F);
        this.beak.addBox(-2.0F, 0.0F, -5.0F, 4.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Leg_back_right = new ModelRenderer(this, 34, 54);
        this.Leg_back_right.setRotationPoint(3.0F, 21.0F, 5.0F);
        this.Leg_back_right.addBox(0.0F, 0.0F, -2.0F, 3.0F, 14.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_back_right, 1.3685127304046198F, 0.03909537541112055F, -0.19547687289441354F);
        this.neck = new ModelRenderer(this, 50, 0);
        this.neck.setRotationPoint(0.0F, -0.5F, -9.0F);
        this.neck.addBox(-2.5F, -3.5F, -5.5F, 5.0F, 11.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(neck, 0.03909537541112055F, 0.35185837453889574F, -0.4300491170387584F);
        this.tail = new ModelRenderer(this, 64, 36);
        this.tail.setRotationPoint(0.0F, -3.0F, 13.0F);
        this.tail.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tail, -0.3522074483787779F, -0.0781907508222411F, 0.11728612207217244F);
        this.Leg_front_right = new ModelRenderer(this, 14, 55);
        this.Leg_front_right.setRotationPoint(4.3F, 18.0F, -6.0F);
        this.Leg_front_right.addBox(0.0F, 0.0F, -1.0F, 3.0F, 12.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_front_right, -1.1728612040769677F, 0.1563815016444822F, 0.038920842652368684F);
        this.head = new ModelRenderer(this, 24, 0);
        this.head.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.head.addBox(-3.0F, -4.0F, -5.0F, 6.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(head, 0.11728612207217244F, 0.1563815016444822F, -0.03909537541112055F);
        this.head.addChild(this.beak);
        this.Body.addChild(this.neck);
        this.Body.addChild(this.tail);
        this.neck.addChild(this.head);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Leg_back_right_1, this.Body, this.Leg_front_left, this.Leg_back_right, this.Leg_front_right).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(PlaceriasEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
