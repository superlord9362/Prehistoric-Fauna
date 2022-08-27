package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.DilophosaurusEntity;

/**
 * DilophosaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class DilophosaurusModel extends EntityModel<DilophosaurusEntity> {
    public ModelRenderer Torso;
    public ModelRenderer Leg1Left;
    public ModelRenderer Leg1Right;
    public ModelRenderer Neck;
    public ModelRenderer Tail;
    public ModelRenderer ArmRight;
    public ModelRenderer ArmLeft;
    public ModelRenderer Head;
    public ModelRenderer QuillsNeck;
    public ModelRenderer QuillsHead;
    public ModelRenderer Jaw;
    public ModelRenderer Snout;
    public ModelRenderer Cheek;
    public ModelRenderer Waddle;
    public ModelRenderer Mouth;
    public ModelRenderer BottomTeeth;
    public ModelRenderer CrestLeft;
    public ModelRenderer CrestRight;
    public ModelRenderer Teeth;
    public ModelRenderer Tail2;
    public ModelRenderer Leg2Left;
    public ModelRenderer FootLeft;
    public ModelRenderer Leg2Right;
    public ModelRenderer FootRight;

    public DilophosaurusModel() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.Torso = new ModelRenderer(this, 0, 0);
        this.Torso.setRotationPoint(0.0F, -3.0F, 9.0F);
        this.Torso.addBox(-4.0F, -4.0F, -27.0F, 8.0F, 14.0F, 32.0F, 0.0F, 0.0F, 0.0F);
        this.BottomTeeth = new ModelRenderer(this, 0, 132);
        this.BottomTeeth.setRotationPoint(0.0F, -2.4F, 0.4F);
        this.BottomTeeth.addBox(-1.0F, 0.0F, -8.0F, 2.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Leg2Left = new ModelRenderer(this, 72, 75);
        this.Leg2Left.setRotationPoint(2.5F, 11.0F, 2.0F);
        this.Leg2Left.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 15.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 95, 3);
        this.Tail2.setRotationPoint(0.0F, 0.5F, 15.0F);
        this.Tail2.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 47.0F, 0.0F, 0.0F, 0.0F);
        this.FootRight = new ModelRenderer(this, 72, 94);
        this.FootRight.mirror = true;
        this.FootRight.setRotationPoint(0.0F, 14.0F, 1.0F);
        this.FootRight.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.ArmLeft = new ModelRenderer(this, 40, 46);
        this.ArmLeft.setRotationPoint(1.0F, 5.0F, -23.0F);
        this.ArmLeft.addBox(0.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Leg2Right = new ModelRenderer(this, 72, 75);
        this.Leg2Right.setRotationPoint(-1.5F, 11.0F, 2.0F);
        this.Leg2Right.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 15.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.CrestLeft = new ModelRenderer(this, 0, 0);
        this.CrestLeft.setRotationPoint(0.8F, -2.0F, 1.0F);
        this.CrestLeft.addBox(0.0F, -6.0F, -8.0F, 1.0F, 6.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(CrestLeft, 0.0781907508222411F, 0.0781907508222411F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 81);
        this.Snout.setRotationPoint(0.0F, -2.0F, -6.0F);
        this.Snout.addBox(-2.0F, -2.0F, -8.0F, 4.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 46);
        this.Neck.setRotationPoint(0.0F, 3.0F, -25.0F);
        this.Neck.addBox(-2.0F, -14.0F, -6.0F, 4.0F, 17.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.ArmRight = new ModelRenderer(this, 40, 46);
        this.ArmRight.mirror = true;
        this.ArmRight.setRotationPoint(-1.0F, 5.0F, -23.0F);
        this.ArmRight.addBox(-4.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.CrestRight = new ModelRenderer(this, 0, 0);
        this.CrestRight.setRotationPoint(-0.8F, -2.0F, 1.0F);
        this.CrestRight.addBox(-1.0F, -6.0F, -8.0F, 1.0F, 6.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(CrestRight, 0.0781907508222411F, -0.0781907508222411F, 0.0F);
        this.Waddle = new ModelRenderer(this, 22, 46);
        this.Waddle.setRotationPoint(0.0F, 2.0F, -4.0F);
        this.Waddle.addBox(-1.5F, 0.0F, -6.0F, 3.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw = new ModelRenderer(this, 0, 103);
        this.Jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Jaw.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Leg1Left = new ModelRenderer(this, 72, 49);
        this.Leg1Left.setRotationPoint(1.5F, -3.0F, 5.0F);
        this.Leg1Left.addBox(-1.0F, -3.0F, -5.0F, 6.0F, 16.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 70);
        this.Head.setRotationPoint(0.0F, -10.0F, -2.0F);
        this.Head.addBox(-2.5F, -5.0F, -6.0F, 5.0F, 5.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Cheek = new ModelRenderer(this, 24, 110);
        this.Cheek.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.Cheek.addBox(-1.5F, 0.0F, -6.0F, 3.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.QuillsNeck = new ModelRenderer(this, 40, 70);
        this.QuillsNeck.setRotationPoint(0.0F, -8.5F, -1.0F);
        this.QuillsNeck.addBox(0.0F, -9.0F, 0.0F, 0.0F, 9.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Mouth = new ModelRenderer(this, 0, 93);
        this.Mouth.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.Mouth.addBox(-2.0F, 0.0F, -8.0F, 4.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Teeth = new ModelRenderer(this, 0, 113);
        this.Teeth.setRotationPoint(0.0F, 2.0F, 0.35F);
        this.Teeth.addBox(-1.5F, -2.0F, -8.0F, 3.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.FootLeft = new ModelRenderer(this, 72, 94);
        this.FootLeft.setRotationPoint(0.0F, 14.0F, 1.0F);
        this.FootLeft.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Leg1Right = new ModelRenderer(this, 72, 49);
        this.Leg1Right.mirror = true;
        this.Leg1Right.setRotationPoint(-2.5F, -3.0F, 5.0F);
        this.Leg1Right.addBox(-4.0F, -3.0F, -5.0F, 6.0F, 16.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 50, 4);
        this.Tail.setRotationPoint(0.0F, -3.5F, 1.5F);
        this.Tail.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 9.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.QuillsHead = new ModelRenderer(this, 40, 90);
        this.QuillsHead.setRotationPoint(0.0F, -6.3F, -4.4F);
        this.QuillsHead.addBox(0.0F, -2.0F, 0.0F, 0.0F, 5.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Mouth.addChild(this.BottomTeeth);
        this.Leg1Left.addChild(this.Leg2Left);
        this.Tail.addChild(this.Tail2);
        this.Leg2Right.addChild(this.FootRight);
        this.Torso.addChild(this.ArmLeft);
        this.Leg1Right.addChild(this.Leg2Right);
        this.Snout.addChild(this.CrestLeft);
        this.Head.addChild(this.Snout);
        this.Torso.addChild(this.Neck);
        this.Torso.addChild(this.ArmRight);
        this.Snout.addChild(this.CrestRight);
        this.Jaw.addChild(this.Waddle);
        this.Head.addChild(this.Jaw);
        this.Neck.addChild(this.Head);
        this.Jaw.addChild(this.Cheek);
        this.Neck.addChild(this.QuillsNeck);
        this.Jaw.addChild(this.Mouth);
        this.Snout.addChild(this.Teeth);
        this.Leg2Left.addChild(this.FootLeft);
        this.Torso.addChild(this.Tail);
        this.Head.addChild(this.QuillsHead);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Torso, this.Leg1Left, this.Leg1Right).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(DilophosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float walkSpeed = 1.0f;
		float walkDegree = 0.5f;
		float idleSpeed = 1.0f;
		float idleDegree = 1.0f;
		this.Neck.rotateAngleX = (MathHelper.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount + 0.35F) + (headPitch * ((float) Math.PI / 180F));
		this.Torso.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)) + MathHelper.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
		this.Tail.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5)) + MathHelper.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
		this.Tail2.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5)) + MathHelper.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.15F * limbSwingAmount + 0.05F;
		this.Tail.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5) + MathHelper.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
		this.Tail2.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5) + MathHelper.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 1.0F * limbSwingAmount;
		this.Head.rotateAngleX = MathHelper.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount - 0.2F;
		this.ArmLeft.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3)) + MathHelper.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
		this.ArmRight.rotateAngleX = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3)) + MathHelper.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
		this.Leg1Left.rotateAngleX = MathHelper.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount - 0.05F + MathHelper.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.05F;
		this.Leg2Left.rotateAngleX = MathHelper.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + 0.05F + MathHelper.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.05F;
		this.FootLeft.rotateAngleX = MathHelper.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.3F * limbSwingAmount + MathHelper.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount;
		this.Leg1Right.rotateAngleX = MathHelper.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount - 0.05F + MathHelper.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.05F;
		this.Leg2Right.rotateAngleX = MathHelper.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + 0.05F + MathHelper.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.05F;
		this.FootRight.rotateAngleX = MathHelper.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.3F * limbSwingAmount + MathHelper.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.3F * limbSwingAmount;
		this.Neck.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);

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
