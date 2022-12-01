package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.PostosuchusSkeletonEntity;

/**
 * PostosuchusSkeletonModel - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class PostosuchusCuriousSkeletonModel extends EntityModel<PostosuchusSkeletonEntity> {
    public ModelRenderer Thigh;
    public ModelRenderer Thigh_1;
    public ModelRenderer Body;
    public ModelRenderer Calf;
    public ModelRenderer Foot;
    public ModelRenderer Calf_1;
    public ModelRenderer Foot_1;
    public ModelRenderer Arm_1;
    public ModelRenderer Neck;
    public ModelRenderer Arm;
    public ModelRenderer Tail;
    public ModelRenderer Body_1;
    public ModelRenderer Body_2;
    public ModelRenderer Head;
    public ModelRenderer Neck_1;
    public ModelRenderer Jaw;
    public ModelRenderer Snout;
    public ModelRenderer JawSnout;
    public ModelRenderer JawTeeth;
    public ModelRenderer SnoutTeeth;
    public ModelRenderer Tail2;
    public ModelRenderer Tail_1;
    public ModelRenderer Tail2_1;

    public PostosuchusCuriousSkeletonModel() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.Tail2 = new ModelRenderer(this, 0, 80);
        this.Tail2.setRotationPoint(0.0F, 0.5F, 21.0F);
        this.Tail2.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 0.0F, 38.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.17453292519943295F, 0.13962634015954636F, 0.0F);
        this.Calf = new ModelRenderer(this, 82, 23);
        this.Calf.mirror = true;
        this.Calf.setRotationPoint(0.5F, 10.0F, -1.0F);
        this.Calf.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Calf, 0.3490658503988659F, 0.0F, 0.0F);
        this.JawTeeth = new ModelRenderer(this, 140, 3);
        this.JawTeeth.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.JawTeeth.addBox(-1.0F, -1.0F, -7.0F, 2.0F, 1.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Thigh = new ModelRenderer(this, 79, 1);
        this.Thigh.mirror = true;
        this.Thigh.setRotationPoint(3.5F, 6.0F, 5.0F);
        this.Thigh.addBox(-2.0F, -1.0F, -2.0F, 5.0F, 11.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thigh, -0.3490658503988659F, -0.17453292519943295F, 0.0F);
        this.Head = new ModelRenderer(this, 107, 3);
        this.Head.setRotationPoint(0.0F, 0.0F, -7.5F);
        this.Head.addBox(-2.5F, -1.5F, -5.0F, 5.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, 0.20943951023931953F, 0.0F, -0.13962634015954636F);
        this.Jaw = new ModelRenderer(this, 160, 3);
        this.Jaw.setRotationPoint(0.0F, 3.5F, 0.0F);
        this.Jaw.addBox(-2.5F, 0.0F, -5.0F, 5.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 5, 0);
        this.Neck.setRotationPoint(0.0F, -5.5F, -22.0F);
        this.Neck.addBox(0.0F, -2.5F, -8.0F, 0.0F, 9.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.20943951023931953F, 0.06981317007977318F, 0.0F);
        this.Tail2_1 = new ModelRenderer(this, 6, 82);
        this.Tail2_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail2_1.addBox(0.0F, -1.0F, 0.0F, 0.0F, 5.0F, 36.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 127, 3);
        this.Snout.setRotationPoint(0.0F, 2.5F, -5.0F);
        this.Snout.addBox(-1.5F, -4.0F, -7.0F, 3.0F, 4.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Arm_1 = new ModelRenderer(this, 54, 46);
        this.Arm_1.setRotationPoint(-5.0F, 1.5F, -19.5F);
        this.Arm_1.addBox(-1.0F, 0.0F, -1.0F, 3.0F, 11.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm_1, 0.8726646259971648F, 0.0F, -0.06981317007977318F);
        this.Foot = new ModelRenderer(this, 79, 39);
        this.Foot.mirror = true;
        this.Foot.setRotationPoint(0.0F, 7.0F, 2.0F);
        this.Foot.addBox(-2.5F, 0.0F, -7.0F, 5.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Arm = new ModelRenderer(this, 54, 46);
        this.Arm.mirror = true;
        this.Arm.setRotationPoint(5.0F, 1.5F, -19.5F);
        this.Arm.addBox(-2.0F, 0.0F, -1.0F, 3.0F, 11.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm, 0.8726646259971648F, 0.0F, 0.06981317007977318F);
        this.Tail_1 = new ModelRenderer(this, 8, 44);
        this.Tail_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tail_1.addBox(0.0F, -2.0F, 0.0F, 0.0F, 8.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.Neck_1 = new ModelRenderer(this, 128, 33);
        this.Neck_1.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.Neck_1.addBox(-2.0F, 0.0F, -7.0F, 4.0F, 9.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.JawSnout = new ModelRenderer(this, 163, 11);
        this.JawSnout.setRotationPoint(0.0F, 0.0F, -4.99F);
        this.JawSnout.addBox(-1.0F, -1.0F, -7.0F, 2.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.SnoutTeeth = new ModelRenderer(this, 145, 3);
        this.SnoutTeeth.setRotationPoint(0.0F, 1.0F, 0.01F);
        this.SnoutTeeth.addBox(-1.5F, -1.0F, -7.01F, 3.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 10.0F, 5.0F);
        this.Body.addBox(-4.5F, -6.0F, -23.0F, 9.0F, 10.0F, 28.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, -0.2792526803190927F, 0.0F, 0.0F);
        this.Foot_1 = new ModelRenderer(this, 79, 39);
        this.Foot_1.setRotationPoint(0.0F, 7.0F, 2.0F);
        this.Foot_1.addBox(-2.5F, 0.0F, -7.0F, 5.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Body_1 = new ModelRenderer(this, 136, 27);
        this.Body_1.mirror = true;
        this.Body_1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Body_1.addBox(0.0F, -7.0F, -23.0F, 0.0F, 12.0F, 28.0F, 0.0F, 0.0F, 0.0F);
        this.Thigh_1 = new ModelRenderer(this, 79, 1);
        this.Thigh_1.setRotationPoint(-3.5F, 6.0F, 5.0F);
        this.Thigh_1.addBox(-3.0F, -1.0F, -2.0F, 5.0F, 11.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thigh_1, -0.3490658503988659F, 0.17453292519943295F, 0.0F);
        this.Calf_1 = new ModelRenderer(this, 82, 23);
        this.Calf_1.setRotationPoint(-0.5F, 10.0F, -1.0F);
        this.Calf_1.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Calf_1, 0.3490658503988659F, 0.0F, 0.0F);
        this.Body_2 = new ModelRenderer(this, 137, 78);
        this.Body_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body_2.addBox(-5.0F, -6.0F, -23.0F, 10.0F, 11.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 2, 46);
        this.Tail.setRotationPoint(0.0F, -5.0F, 5.0F);
        this.Tail.addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.08726646259971647F, 0.13962634015954636F, 0.0F);
        this.Tail.addChild(this.Tail2);
        this.Thigh.addChild(this.Calf);
        this.JawSnout.addChild(this.JawTeeth);
        this.Neck.addChild(this.Head);
        this.Head.addChild(this.Jaw);
        this.Body.addChild(this.Neck);
        this.Tail2.addChild(this.Tail2_1);
        this.Head.addChild(this.Snout);
        this.Body.addChild(this.Arm_1);
        this.Calf.addChild(this.Foot);
        this.Body.addChild(this.Arm);
        this.Tail.addChild(this.Tail_1);
        this.Neck.addChild(this.Neck_1);
        this.Jaw.addChild(this.JawSnout);
        this.Snout.addChild(this.SnoutTeeth);
        this.Calf_1.addChild(this.Foot_1);
        this.Body.addChild(this.Body_1);
        this.Thigh_1.addChild(this.Calf_1);
        this.Body.addChild(this.Body_2);
        this.Body.addChild(this.Tail);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Thigh, this.Body, this.Thigh_1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(PostosuchusSkeletonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
