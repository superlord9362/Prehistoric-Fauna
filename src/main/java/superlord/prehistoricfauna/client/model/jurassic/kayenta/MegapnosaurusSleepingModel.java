package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.MegapnosaurusEntity;

/**
 * Syntarsus - bastion14
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class MegapnosaurusSleepingModel extends EntityModel<MegapnosaurusEntity> {
	public ModelRenderer Body;
    public ModelRenderer Leg_1;
    public ModelRenderer Leg;
    public ModelRenderer Neck;
    public ModelRenderer ArmLeft;
    public ModelRenderer ArmRight;
    public ModelRenderer Tail;
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer Tail2;
    public ModelRenderer Leg2_1;
    public ModelRenderer Leg2;

    public MegapnosaurusSleepingModel() {
        this.textureWidth = 80;
        this.textureHeight = 50;
        this.Tail = new ModelRenderer(this, 21, 0);
        this.Tail.setRotationPoint(0.0F, -1.0F, 1.0F);
        this.Tail.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.23457224414434488F, 0.3909537457888271F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 32);
        this.Snout.setRotationPoint(0.0F, -1.0F, -0.9F);
        this.Snout.addBox(-0.5F, -1.0F, -2.5F, 1.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Leg2 = new ModelRenderer(this, 14, 27);
        this.Leg2.setRotationPoint(1.2F, 4.5F, 0.5F);
        this.Leg2.addBox(-1.5F, 0.2F, -1.4F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg2, 1.407433498155583F, 0.0F, 0.0F);
        this.Leg_1 = new ModelRenderer(this, 26, 17);
        this.Leg_1.setRotationPoint(0.0F, 22.5F, 2.2F);
        this.Leg_1.addBox(-2.0F, -2.0F, -1.5F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg_1, -1.407433498155583F, 0.3909537457888271F, 0.0F);
        this.ArmLeft = new ModelRenderer(this, 42, 17);
        this.ArmLeft.setRotationPoint(-0.7F, 0.0F, -7.0F);
        this.ArmLeft.addBox(-1.0F, 0.0F, -1.0F, 1.0F, 6.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmLeft, 0.0F, 0.0F, 1.1339404363260046F);
        this.Tail2 = new ModelRenderer(this, 36, 0);
        this.Tail2.setRotationPoint(-0.3F, 0.0F, 6.0F);
        this.Tail2.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.11728612207217244F, 0.6646214111173737F, 0.0F);
        this.Leg2_1 = new ModelRenderer(this, 27, 27);
        this.Leg2_1.setRotationPoint(-1.2F, 4.5F, 0.5F);
        this.Leg2_1.addBox(-1.5F, 0.2F, -1.4F, 3.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg2_1, 1.407433498155583F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 25);
        this.Head.setRotationPoint(0.0F, -4.0F, -2.0F);
        this.Head.addBox(-0.5F, -1.0F, -4.0F, 1.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.ArmRight = new ModelRenderer(this, 37, 17);
        this.ArmRight.setRotationPoint(0.7F, 0.0F, -7.0F);
        this.ArmRight.addBox(0.0F, 0.0F, -1.0F, 1.0F, 6.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmRight, 0.0F, 0.0F, -1.13376586611655F);
        this.Leg = new ModelRenderer(this, 14, 17);
        this.Leg.setRotationPoint(0.0F, 22.5F, 2.2F);
        this.Leg.addBox(0.0F, -2.0F, -1.5F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg, -1.407433498155583F, -0.3909537457888271F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 22.0F, 3.0F);
        this.Body.addBox(-1.5F, -2.0F, -10.0F, 3.0F, 4.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 17);
        this.Neck.setRotationPoint(0.0F, 0.0F, -9.0F);
        this.Neck.addBox(-0.5F, -5.0F, -2.0F, 1.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.0F, -1.2901473511162753F, 0.3127630032889644F);
        this.Body.addChild(this.Tail);
        this.Head.addChild(this.Snout);
        this.Leg.addChild(this.Leg2);
        this.Body.addChild(this.ArmLeft);
        this.Tail.addChild(this.Tail2);
        this.Leg_1.addChild(this.Leg2_1);
        this.Neck.addChild(this.Head);
        this.Body.addChild(this.ArmRight);
        this.Body.addChild(this.Neck);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Leg_1, this.Leg, this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(MegapnosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
