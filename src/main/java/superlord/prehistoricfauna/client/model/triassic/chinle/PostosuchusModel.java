package superlord.prehistoricfauna.client.model.triassic.chinle;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PostosuchusEntity;

/**
 * Postosuchus - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class PostosuchusModel extends EntityModel<PostosuchusEntity> {
    public ModelRenderer Body;
    public ModelRenderer Thigh;
    public ModelRenderer Thigh_1;
    public ModelRenderer Neck;
    public ModelRenderer Tail;
    public ModelRenderer Arm;
    public ModelRenderer Arm_1;
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer Jaw;
    public ModelRenderer SnoutTeeth;
    public ModelRenderer JawSnout;
    public ModelRenderer Cheek;
    public ModelRenderer JawTeeth;
    public ModelRenderer Tail2;
    public ModelRenderer Calf;
    public ModelRenderer Foot;
    public ModelRenderer Calf_1;
    public ModelRenderer Foot_1;

    public PostosuchusModel() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.Arm_1 = new ModelRenderer(this, 54, 46);
        this.Arm_1.setRotationPoint(-4.0F, 2.0F, -19.0F);
        this.Arm_1.addBox(-2.0F, 0.0F, -1.5F, 3.0F, 11.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm_1, 0.3490658503988659F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 0, 80);
        this.Tail2.setRotationPoint(0.0F, 1.0F, 21.0F);
        this.Tail2.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 38.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, -0.06981317007977318F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 107, 3);
        this.Head.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.Head.addBox(-2.5F, -4.0F, -5.0F, 5.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.JawSnout = new ModelRenderer(this, 131, 24);
        this.JawSnout.setRotationPoint(0.0F, 1.0F, -5.0F);
        this.JawSnout.addBox(-1.5F, -1.0F, -7.0F, 3.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw = new ModelRenderer(this, 106, 26);
        this.Jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Jaw.addBox(-2.5F, 0.0F, -5.0F, 5.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.JawTeeth = new ModelRenderer(this, 159, 20);
        this.JawTeeth.setRotationPoint(0.0F, -1.0F, 0.5F);
        this.JawTeeth.addBox(-1.0F, -1.0F, -7.0F, 2.0F, 1.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Foot = new ModelRenderer(this, 78, 38);
        this.Foot.mirror = true;
        this.Foot.setRotationPoint(0.0F, 7.0F, 2.0F);
        this.Foot.addBox(-2.5F, 0.0F, -7.0F, 5.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Thigh = new ModelRenderer(this, 79, 1);
        this.Thigh.mirror = true;
        this.Thigh.setRotationPoint(2.0F, 6.0F, 8.0F);
        this.Thigh.addBox(-1.0F, 0.0F, -5.0F, 5.0F, 11.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thigh, -0.3490658503988659F, -0.17453292519943295F, 0.0F);
        this.Thigh_1 = new ModelRenderer(this, 79, 1);
        this.Thigh_1.setRotationPoint(-2.0F, 6.0F, 8.0F);
        this.Thigh_1.addBox(-4.0F, 0.0F, -5.0F, 5.0F, 11.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thigh_1, -0.3490658503988659F, 0.17453292519943295F, 0.0F);
        this.Cheek = new ModelRenderer(this, 108, 16);
        this.Cheek.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Cheek.addBox(-2.0F, -3.0F, -4.0F, 4.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Foot_1 = new ModelRenderer(this, 78, 38);
        this.Foot_1.setRotationPoint(0.0F, 7.0F, 2.0F);
        this.Foot_1.addBox(-2.5F, 0.0F, -7.0F, 5.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Calf_1 = new ModelRenderer(this, 82, 23);
        this.Calf_1.setRotationPoint(-1.5F, 11.0F, -4.0F);
        this.Calf_1.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Calf_1, 0.3490658503988659F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 1, 2);
        this.Neck.setRotationPoint(0.0F, -3.0F, -23.0F);
        this.Neck.addBox(-3.0F, -4.0F, -5.0F, 6.0F, 9.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Arm = new ModelRenderer(this, 54, 46);
        this.Arm.mirror = true;
        this.Arm.setRotationPoint(4.0F, 2.0F, -19.0F);
        this.Arm.addBox(-1.0F, 0.0F, -1.5F, 3.0F, 11.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm, 0.3490658503988659F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 130, 1);
        this.Snout.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.Snout.addBox(-1.5F, -4.0F, -7.0F, 3.0F, 4.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 0, 44);
        this.Tail.setRotationPoint(0.0F, -5.0F, 5.0F);
        this.Tail.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 8.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.10471975511965977F, 0.0F, 0.0F);
        this.Calf = new ModelRenderer(this, 82, 23);
        this.Calf.mirror = true;
        this.Calf.setRotationPoint(1.5F, 11.0F, -4.0F);
        this.Calf.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Calf, 0.3490658503988659F, 0.0F, 0.0F);
        this.SnoutTeeth = new ModelRenderer(this, 156, 6);
        this.SnoutTeeth.setRotationPoint(0.0F, 1.0F, 0.01F);
        this.SnoutTeeth.addBox(-1.0F, -1.01F, -7.0F, 2.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 9.0F, 5.0F);
        this.Body.addBox(-5.0F, -6.0F, -23.0F, 10.0F, 11.0F, 28.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, 0.03490658503988659F, 0.0F, 0.0F);
        this.Body.addChild(this.Arm_1);
        this.Tail.addChild(this.Tail2);
        this.Neck.addChild(this.Head);
        this.Jaw.addChild(this.JawSnout);
        this.Head.addChild(this.Jaw);
        this.JawSnout.addChild(this.JawTeeth);
        this.Calf.addChild(this.Foot);
        this.Jaw.addChild(this.Cheek);
        this.Calf_1.addChild(this.Foot_1);
        this.Thigh_1.addChild(this.Calf_1);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.Arm);
        this.Head.addChild(this.Snout);
        this.Body.addChild(this.Tail);
        this.Thigh.addChild(this.Calf);
        this.Snout.addChild(this.SnoutTeeth);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Thigh, this.Thigh_1, this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(PostosuchusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float speed = 0.9f;
		float degree = 1.0f;
        float partialTick = ageInTicks - entityIn.ticksExisted;
        float attackProgress = entityIn.getMeleeProgress(partialTick);
        float leftOrRight = entityIn.getMeleeDirection() ? 1.0F : -1.0F;

        this.Jaw.rotateAngleX = Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)) +  attackProgress * (float) Math.toRadians(25F);
		this.Arm.rotateAngleZ = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
		this.Arm_1.rotateAngleZ = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
		this.Body.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.1F) * degree * 0.15F * limbSwingAmount;
		this.Neck.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.1F) * degree * -0.15F * limbSwingAmount;
		this.Tail.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.2F * limbSwingAmount);
        this.Tail2.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (Tail2.rotateAngleY = MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.25F * limbSwingAmount);
        this.Tail.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.15F);
        this.Tail2.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.1F);
        this.Thigh.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.2F) * degree * 1F * limbSwingAmount - 0.35F;
		this.Calf.rotateAngleX = Math.abs(MathHelper.cos(limbSwing * speed * 0.2F) * degree * 1.0F * limbSwingAmount) + 0.35F;
		this.Foot.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.2F) * degree * 1F * limbSwingAmount;
		this.Thigh_1.rotateAngleX = MathHelper.cos(3.0F + limbSwing * speed * 0.2F) * degree * 1F * limbSwingAmount - 0.35F;
		this.Calf_1.rotateAngleX = Math.abs(MathHelper.cos(3.0F + limbSwing * speed * 0.2F) * degree * 1.0F * limbSwingAmount) + 0.35F;
		this.Foot_1.rotateAngleX = MathHelper.cos(3.0F + limbSwing * speed * 0.2F) * degree * 1F * limbSwingAmount;
        this.Neck.rotateAngleZ = attackProgress * leftOrRight * (float) Math.toRadians(15F);
        this.Head.rotateAngleZ = attackProgress * leftOrRight * (float) Math.toRadians(5F);
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
