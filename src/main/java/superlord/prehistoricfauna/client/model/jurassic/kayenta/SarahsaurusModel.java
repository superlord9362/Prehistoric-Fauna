package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.SarahsaurusEntity;

/**
 * SarahsaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SarahsaurusModel extends EntityModel<SarahsaurusEntity> {
    public ModelRenderer Torso;
    public ModelRenderer Leg1Left;
    public ModelRenderer Leg1Right;
    public ModelRenderer ArmRight;
    public ModelRenderer Neck;
    public ModelRenderer Tail;
    public ModelRenderer ArmLeft;
    public ModelRenderer Head;
    public ModelRenderer Tail2;
    public ModelRenderer Leg2Left;
    public ModelRenderer FootLeft;
    public ModelRenderer Leg2Right;
    public ModelRenderer FootRight;

    public SarahsaurusModel() {
        this.textureWidth = 125;
        this.textureHeight = 75;
        this.ArmLeft = new ModelRenderer(this, 22, 32);
        this.ArmLeft.setRotationPoint(2.0F, 1.0F, -16.0F);
        this.ArmLeft.addBox(0.0F, 0.0F, -2.0F, 2.0F, 8.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 58, 0);
        this.Tail2.setRotationPoint(0.0F, 1.0F, 12.0F);
        this.Tail2.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 3.0F, 29.0F, 0.0F, 0.0F, 0.0F);
        this.Leg2Right = new ModelRenderer(this, 42, 50);
        this.Leg2Right.mirror = true;
        this.Leg2Right.setRotationPoint(-1.0F, 8.0F, 1.0F);
        this.Leg2Right.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Leg1Left = new ModelRenderer(this, 42, 31);
        this.Leg1Left.setRotationPoint(2.0F, 7.5F, 6.0F);
        this.Leg1Left.addBox(-1.0F, -1.0F, -3.0F, 4.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Leg1Right = new ModelRenderer(this, 42, 31);
        this.Leg1Right.mirror = true;
        this.Leg1Right.setRotationPoint(-2.0F, 7.5F, 6.0F);
        this.Leg1Right.addBox(-3.0F, -1.0F, -3.0F, 4.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 36, 0);
        this.Tail.setRotationPoint(0.0F, -3.0F, 2.0F);
        this.Tail.addBox(-3.0F, 0.0F, -2.0F, 6.0F, 6.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.FootLeft = new ModelRenderer(this, 43, 65);
        this.FootLeft.setRotationPoint(0.0F, 7.5F, 2.0F);
        this.FootLeft.addBox(-1.5F, 0.0F, -4.0F, 3.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 53);
        this.Head.setRotationPoint(0.0F, -13.0F, -0.6F);
        this.Head.addBox(-1.5F, -2.0F, -6.0F, 3.0F, 3.0F, 7.0F, 0.01F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -0.4363323129985824F, 0.0F, 0.0F);
        this.FootRight = new ModelRenderer(this, 43, 65);
        this.FootRight.setRotationPoint(0.0F, 7.5F, 2.0F);
        this.FootRight.addBox(-1.5F, 0.0F, -4.0F, 3.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Torso = new ModelRenderer(this, 0, 0);
        this.Torso.setRotationPoint(0.0F, 8.5F, 9.0F);
        this.Torso.addBox(-3.5F, -4.0F, -20.0F, 7.0F, 9.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 31);
        this.Neck.setRotationPoint(0.0F, -2.0F, -18.0F);
        this.Neck.addBox(-1.5F, -14.0F, -3.0F, 3.0F, 17.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.45378560551852565F, 0.0F, 0.0F);
        this.Leg2Left = new ModelRenderer(this, 42, 50);
        this.Leg2Left.setRotationPoint(1.0F, 8.0F, 1.0F);
        this.Leg2Left.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.ArmRight = new ModelRenderer(this, 22, 32);
        this.ArmRight.mirror = true;
        this.ArmRight.setRotationPoint(-2.0F, 1.0F, -16.0F);
        this.ArmRight.addBox(-2.0F, 0.0F, -2.0F, 2.0F, 8.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Torso.addChild(this.ArmLeft);
        this.Tail.addChild(this.Tail2);
        this.Leg1Right.addChild(this.Leg2Right);
        this.Torso.addChild(this.Tail);
        this.Leg2Left.addChild(this.FootLeft);
        this.Neck.addChild(this.Head);
        this.Leg2Right.addChild(this.FootRight);
        this.Torso.addChild(this.Neck);
        this.Leg1Left.addChild(this.Leg2Left);
        this.Torso.addChild(this.ArmRight);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Leg1Left, this.Leg1Right, this.Torso).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(SarahsaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float partialTick = ageInTicks - entityIn.ticksExisted;
        float attackProgress = entityIn.getMeleeProgress(partialTick);
        this.Leg1Right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.Leg1Left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.Tail.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
		this.Tail2.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
		this.Tail.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
		this.Tail2.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
		this.Neck.rotateAngleX = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + 0.45F + attackProgress * (float) Math.toRadians(45F);
		this.ArmLeft.rotateAngleZ = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
		this.ArmRight.rotateAngleZ = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
		this.Neck.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.Head.rotateAngleX = attackProgress * (float) Math.toRadians(-15F);
        if (entityIn.isEating()) {
			this.Neck.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.75F) + 1.2F;
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
