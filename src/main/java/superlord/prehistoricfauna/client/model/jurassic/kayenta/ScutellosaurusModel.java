package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.ScutellosaurusEntity;

/**
 * Scutellosaurus - bastion14
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ScutellosaurusModel extends EntityModel<ScutellosaurusEntity> {
    public ModelRenderer Body;
    public ModelRenderer Leg;
    public ModelRenderer Leg_1;
    public ModelRenderer Neck;
    public ModelRenderer Tail;
    public ModelRenderer ArmRight;
    public ModelRenderer ArmLeft;
    public ModelRenderer part6;
    public ModelRenderer part6_1;
    public ModelRenderer Head;
    public ModelRenderer Tail2;
    public ModelRenderer TailOsteoderms;
    public ModelRenderer Tail2Osteoderms;
    public ModelRenderer Leg2;
    public ModelRenderer Leg2_1;

    public ScutellosaurusModel() {
        this.textureWidth = 70;
        this.textureHeight = 45;
        this.ArmRight = new ModelRenderer(this, 0, 20);
        this.ArmRight.setRotationPoint(0.5F, 1.0F, -7.0F);
        this.ArmRight.addBox(0.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.TailOsteoderms = new ModelRenderer(this, 21, 9);
        this.TailOsteoderms.setRotationPoint(0.0F, 0.2F, -0.1F);
        this.TailOsteoderms.addBox(-1.0F, 0.0F, 0.1F, 2.0F, 0.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Leg = new ModelRenderer(this, 7, 20);
        this.Leg.setRotationPoint(0.4F, 17.0F, 3.0F);
        this.Leg.addBox(0.0F, 0.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 21, 0);
        this.Tail.setRotationPoint(0.0F, -1.8F, 0.0F);
        this.Tail.addBox(-0.5F, 0.0F, -1.0F, 1.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 18.4F, 4.0F);
        this.Body.addBox(-1.0F, -2.0F, -8.0F, 2.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.part6 = new ModelRenderer(this, 32, 4);
        this.part6.setRotationPoint(0.0F, -1.9F, -8.0F);
        this.part6.addBox(-1.5F, 0.0F, -1.0F, 3.0F, 0.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Leg2_1 = new ModelRenderer(this, 14, 21);
        this.Leg2_1.setRotationPoint(-0.5F, 4.0F, 0.0F);
        this.Leg2_1.addBox(-0.5F, 0.0F, -2.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2Osteoderms = new ModelRenderer(this, 25, 4);
        this.Tail2Osteoderms.setRotationPoint(0.0F, 0.5F, 5.9F);
        this.Tail2Osteoderms.addBox(-0.5F, 0.0F, -7.9F, 1.0F, 0.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 12, 13);
        this.Head.setRotationPoint(0.0F, -0.1F, -2.5F);
        this.Head.addBox(-0.5F, -1.5F, -3.5F, 1.0F, 2.0F, 4.0F, 0.01F, 0.0F, 0.0F);
        this.Leg2 = new ModelRenderer(this, 14, 21);
        this.Leg2.setRotationPoint(0.5F, 4.0F, 0.0F);
        this.Leg2.addBox(-0.5F, 0.0F, -2.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Leg_1 = new ModelRenderer(this, 7, 20);
        this.Leg_1.mirror = true;
        this.Leg_1.setRotationPoint(-0.6F, 17.0F, 3.0F);
        this.Leg_1.addBox(-1.0F, 0.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 31, -12);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 5.0F);
        this.Tail2.addBox(0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.part6_1 = new ModelRenderer(this, 42, 5);
        this.part6_1.setRotationPoint(0.0F, -1.9F, -6.5F);
        this.part6_1.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 13);
        this.Neck.setRotationPoint(0.0F, -0.3F, -8.0F);
        this.Neck.addBox(-0.5F, -1.5F, -2.8F, 1.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.ArmLeft = new ModelRenderer(this, 0, 20);
        this.ArmLeft.mirror = true;
        this.ArmLeft.setRotationPoint(-0.5F, 1.0F, -7.0F);
        this.ArmLeft.addBox(-1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.ArmRight);
        this.Tail.addChild(this.TailOsteoderms);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.part6);
        this.Leg_1.addChild(this.Leg2_1);
        this.Tail2.addChild(this.Tail2Osteoderms);
        this.Neck.addChild(this.Head);
        this.Leg.addChild(this.Leg2);
        this.Tail.addChild(this.Tail2);
        this.Body.addChild(this.part6_1);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.ArmLeft);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Leg, this.Body, this.Leg_1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(ScutellosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	this.Body.rotateAngleX = 0;
    	this.Neck.rotateAngleX = headPitch * ((float)Math.PI / 180F);
    	this.Neck.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
    	this.Leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.Leg_1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.ArmLeft.rotateAngleZ = MathHelper.cos(0.05F * ageInTicks) * 0.05F;
    	this.ArmRight.rotateAngleZ = -MathHelper.cos(0.05F * ageInTicks) * 0.05F;
    	this.Tail.rotateAngleY = -MathHelper.cos(0.1F * ageInTicks) * 0.1F;
    	this.Tail.rotateAngleX = -MathHelper.cos(0.025F * ageInTicks) * 0.025F;
		if (entityIn.isEating()) {
			this.Body.rotateAngleX = 0.2F;
			this.Neck.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
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
