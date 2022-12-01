package superlord.prehistoricfauna.client.model.triassic.chinle;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.chinle.PostosuchusEntity;

/**
 * PostosuchusSleepingModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class PostosuchusSleepingModel extends EntityModel<PostosuchusEntity> {
    public ModelRenderer Thigh;
    public ModelRenderer Thigh_1;
    public ModelRenderer Body;
    public ModelRenderer Calf;
    public ModelRenderer Foot;
    public ModelRenderer Calf_1;
    public ModelRenderer Foot_1;
    public ModelRenderer Arm_1;
    public ModelRenderer Arm;
    public ModelRenderer Tail;
    public ModelRenderer Neck;
    public ModelRenderer Tail2;
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer Jaw;
    public ModelRenderer SnoutTeeth;
    public ModelRenderer JawSnout;
    public ModelRenderer Cheek;
    public ModelRenderer JawTeeth;

    public PostosuchusSleepingModel() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.Head = new ModelRenderer(this, 107, 3);
        this.Head.setRotationPoint(0.0F, 0.6F, -5.0F);
        this.Head.addBox(-2.5F, -4.0F, -5.0F, 5.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -0.5235987755982988F, 0.0F, 0.0F);
        this.Jaw = new ModelRenderer(this, 106, 26);
        this.Jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Jaw.addBox(-2.5F, 0.0F, -5.0F, 5.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Jaw, 0.5235987755982988F, 0.0F, 0.0F);
        this.Foot_1 = new ModelRenderer(this, 78, 38);
        this.Foot_1.setRotationPoint(0.0F, 7.0F, 2.0F);
        this.Foot_1.addBox(-2.5F, 0.0F, -7.0F, 5.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Foot_1, 0.41887902047863906F, 0.0F, 0.0F);
        this.SnoutTeeth = new ModelRenderer(this, 156, 6);
        this.SnoutTeeth.setRotationPoint(0.0F, 1.0F, 0.01F);
        this.SnoutTeeth.addBox(-1.0F, -1.01F, -7.0F, 2.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Cheek = new ModelRenderer(this, 108, 16);
        this.Cheek.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Cheek.addBox(-2.0F, -3.0F, -4.0F, 4.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 0, 80);
        this.Tail2.setRotationPoint(0.0F, 1.0F, 21.0F);
        this.Tail2.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 38.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.0F, 0.27366763203903305F, 0.03909537541112055F);
        this.Arm_1 = new ModelRenderer(this, 54, 46);
        this.Arm_1.setRotationPoint(-4.0F, 2.0F, -19.0F);
        this.Arm_1.addBox(-2.0F, 0.0F, -1.5F, 3.0F, 11.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm_1, -0.8203047484373349F, 0.0F, 1.5707963267948966F);
        this.Neck = new ModelRenderer(this, 1, 2);
        this.Neck.setRotationPoint(0.0F, -1.0F, -23.5F);
        this.Neck.addBox(-3.0F, -4.0F, -5.0F, 6.0F, 9.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, -0.10471975511965977F, -0.3490658503988659F, 0.0F);
        this.Foot = new ModelRenderer(this, 78, 38);
        this.Foot.mirror = true;
        this.Foot.setRotationPoint(0.0F, 7.0F, 2.0F);
        this.Foot.addBox(-2.5F, 0.0F, -7.0F, 5.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Foot, 0.41887902047863906F, 0.0F, 0.0F);
        this.Thigh = new ModelRenderer(this, 79, 1);
        this.Thigh.mirror = true;
        this.Thigh.setRotationPoint(2.0F, 21.5F, 7.0F);
        this.Thigh.addBox(-1.0F, 0.0F, -5.0F, 5.0F, 11.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thigh, -1.9198621771937625F, -0.45378560551852565F, 0.0F);
        this.Tail = new ModelRenderer(this, 0, 44);
        this.Tail.setRotationPoint(0.4F, -4.0F, 5.0F);
        this.Tail.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 8.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.17453292519943295F, 0.41887902047863906F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 19.0F, 5.0F);
        this.Body.addBox(-5.0F, -6.0F, -23.0F, 10.0F, 11.0F, 28.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, 0.10471975511965977F, 0.0F, 0.0F);
        this.Arm = new ModelRenderer(this, 54, 46);
        this.Arm.mirror = true;
        this.Arm.setRotationPoint(4.0F, 2.0F, -19.0F);
        this.Arm.addBox(-1.0F, 0.0F, -1.5F, 3.0F, 11.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Arm, -0.8203047484373349F, 0.0F, -1.5707963267948966F);
        this.JawSnout = new ModelRenderer(this, 131, 24);
        this.JawSnout.setRotationPoint(0.0F, 1.0F, -5.0F);
        this.JawSnout.addBox(-1.5F, -1.0F, -7.0F, 3.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.JawTeeth = new ModelRenderer(this, 159, 20);
        this.JawTeeth.setRotationPoint(0.0F, -1.0F, 0.5F);
        this.JawTeeth.addBox(-1.0F, -1.0F, -7.0F, 2.0F, 1.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Calf_1 = new ModelRenderer(this, 82, 23);
        this.Calf_1.setRotationPoint(-1.5F, 11.0F, -2.6F);
        this.Calf_1.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Calf_1, 1.5009831567151235F, 0.0F, 0.0F);
        this.Thigh_1 = new ModelRenderer(this, 79, 1);
        this.Thigh_1.setRotationPoint(-2.5F, 21.5F, 7.0F);
        this.Thigh_1.addBox(-4.0F, 0.0F, -5.0F, 5.0F, 11.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thigh_1, -1.9198621771937625F, 0.41887902047863906F, 0.0F);
        this.Calf = new ModelRenderer(this, 82, 23);
        this.Calf.mirror = true;
        this.Calf.setRotationPoint(1.5F, 11.0F, -2.6F);
        this.Calf.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Calf, 1.5009831567151235F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 130, 1);
        this.Snout.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.Snout.addBox(-1.5F, -4.0F, -7.0F, 3.0F, 4.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Neck.addChild(this.Head);
        this.Head.addChild(this.Jaw);
        this.Calf_1.addChild(this.Foot_1);
        this.Snout.addChild(this.SnoutTeeth);
        this.Jaw.addChild(this.Cheek);
        this.Tail.addChild(this.Tail2);
        this.Body.addChild(this.Arm_1);
        this.Body.addChild(this.Neck);
        this.Calf.addChild(this.Foot);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.Arm);
        this.Jaw.addChild(this.JawSnout);
        this.JawSnout.addChild(this.JawTeeth);
        this.Thigh_1.addChild(this.Calf_1);
        this.Thigh.addChild(this.Calf);
        this.Head.addChild(this.Snout);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Thigh, this.Body, this.Thigh_1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(PostosuchusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
