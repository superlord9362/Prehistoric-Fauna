package superlord.prehistoricfauna.client.model.jurassic.morrison;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CeratosaurusEntity;

/**
 * CeratosaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class CeratosaurusSleepingModel extends EntityModel<CeratosaurusEntity> {
    public ModelRenderer RightLeg1;
    public ModelRenderer LeftLeg1;
    public ModelRenderer Body1;
    public ModelRenderer RightLeg2;
    public ModelRenderer RightFoot;
    public ModelRenderer LeftLeg2;
    public ModelRenderer LeftFoot;
    public ModelRenderer Tail1;
    public ModelRenderer LeftArm;
    public ModelRenderer RightArm;
    public ModelRenderer Neck;
    public ModelRenderer Osteoderm;
    public ModelRenderer Osteoderm2;
    public ModelRenderer Tail2;
    public ModelRenderer Osteoderm3;
    public ModelRenderer Head1;
    public ModelRenderer Jaw1;
    public ModelRenderer Snout;
    public ModelRenderer Jaw2;
    public ModelRenderer Jaw3;
    public ModelRenderer LowerTeeth;
    public ModelRenderer CrestLeft;
    public ModelRenderer CrestRight;
    public ModelRenderer UpperTeeth;
    public ModelRenderer SnoutHorn;

    public CeratosaurusSleepingModel() {
        this.textureWidth = 250;
        this.textureHeight = 250;
        this.LeftArm = new ModelRenderer(this, 51, 51);
        this.LeftArm.setRotationPoint(4.0F, 6.0F, -26.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftArm, 0.8932595164970201F, 0.19547687289441354F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 92, 91);
        this.Tail2.setRotationPoint(0.0F, 2.0F, 22.0F);
        this.Tail2.addBox(-3.0F, -4.0F, 0.0F, 6.0F, 8.0F, 35.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.20943951023931953F, -0.5585053606381855F, 0.0F);
        this.Body1 = new ModelRenderer(this, 154, 0);
        this.Body1.setRotationPoint(0.0F, 10.5F, 14.0F);
        this.Body1.addBox(-6.5F, -7.0F, -30.0F, 13.0F, 17.0F, 34.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body1, -0.10471975511965977F, 0.0F, 0.0F);
        this.CrestLeft = new ModelRenderer(this, 0, 191);
        this.CrestLeft.setRotationPoint(2.0F, -2.0F, 1.0F);
        this.CrestLeft.addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.RightFoot = new ModelRenderer(this, 126, 222);
        this.RightFoot.setRotationPoint(0.0F, 12.0F, -1.0F);
        this.RightFoot.addBox(-2.0F, 0.0F, -7.0F, 5.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightFoot, 1.5707963267948966F, 0.0F, 0.0F);
        this.Head1 = new ModelRenderer(this, 0, 94);
        this.Head1.setRotationPoint(2.0F, -5.0F, -5.0F);
        this.Head1.addBox(-4.0F, -5.0F, -8.0F, 8.0F, 6.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head1, -0.7864453849170947F, 0.6658431362674476F, -1.1339404363260046F);
        this.Jaw3 = new ModelRenderer(this, 0, 149);
        this.Jaw3.setRotationPoint(0.0F, 1.1F, -5.1F);
        this.Jaw3.addBox(-3.5F, -6.69F, -1.0F, 7.0F, 7.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.UpperTeeth = new ModelRenderer(this, 5, 203);
        this.UpperTeeth.setRotationPoint(0.0F, 4.2F, 0.0F);
        this.UpperTeeth.addBox(-2.0F, -4.2F, -8.5F, 4.0F, 7.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Jaw2 = new ModelRenderer(this, 47, 119);
        this.Jaw2.setRotationPoint(0.0F, 1.0F, -8.0F);
        this.Jaw2.addBox(-2.5F, -2.0F, -9.0F, 5.0F, 3.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 47, 94);
        this.Snout.setRotationPoint(0.0F, -3.0F, -8.0F);
        this.Snout.addBox(-2.5F, -1.0F, -9.0F, 5.0F, 5.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 110, 43);
        this.Tail1.setRotationPoint(0.0F, -2.0F, 1.5F);
        this.Tail1.addBox(-4.5F, -4.0F, 0.0F, 9.0F, 13.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.24434609527920614F, -0.3490658503988659F, 0.0F);
        this.LeftFoot = new ModelRenderer(this, 80, 222);
        this.LeftFoot.setRotationPoint(0.0F, 12.0F, -1.0F);
        this.LeftFoot.addBox(-3.0F, 0.0F, -7.0F, 5.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftFoot, 1.5707963267948966F, 0.0F, 0.0F);
        this.CrestRight = new ModelRenderer(this, 16, 191);
        this.CrestRight.setRotationPoint(-2.0F, -2.0F, 1.0F);
        this.CrestRight.addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Osteoderm3 = new ModelRenderer(this, 0, 0);
        this.Osteoderm3.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.Osteoderm3.addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 35.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg2 = new ModelRenderer(this, 93, 192);
        this.LeftLeg2.setRotationPoint(4.0F, 12.0F, 5.0F);
        this.LeftLeg2.addBox(-2.5F, -3.0F, -3.0F, 4.0F, 16.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg2, -0.8377580409572781F, 0.0F, 0.0F);
        this.Osteoderm = new ModelRenderer(this, 0, -16);
        this.Osteoderm.setRotationPoint(0.0F, -9.0F, -30.0F);
        this.Osteoderm.addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 34.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg2 = new ModelRenderer(this, 126, 192);
        this.RightLeg2.setRotationPoint(-4.0F, 12.0F, 5.0F);
        this.RightLeg2.addBox(-1.5F, -3.0F, -3.0F, 4.0F, 16.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg2, -0.8377580409572781F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 51);
        this.Neck.setRotationPoint(0.0F, 0.0F, -30.0F);
        this.Neck.addBox(-3.0F, -10.0F, -6.0F, 6.0F, 15.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 1.0929251589567215F, 1.2117821049859852F, 0.2350958549041681F);
        this.Jaw1 = new ModelRenderer(this, 0, 119);
        this.Jaw1.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.Jaw1.addBox(-4.0F, -1.0F, -8.0F, 8.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.LowerTeeth = new ModelRenderer(this, 47, 203);
        this.LowerTeeth.setRotationPoint(0.0F, -3.01F, -0.5F);
        this.LowerTeeth.addBox(-2.0F, -2.0F, -8.0F, 4.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Osteoderm2 = new ModelRenderer(this, 0, 19);
        this.Osteoderm2.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.Osteoderm2.addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.SnoutHorn = new ModelRenderer(this, 0, 21);
        this.SnoutHorn.setRotationPoint(0.0F, -2.0F, -6.0F);
        this.SnoutHorn.addBox(-1.0F, -3.0F, -2.0F, 2.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg1 = new ModelRenderer(this, 128, 153);
        this.RightLeg1.setRotationPoint(-4.0F, 10.7F, 10.0F);
        this.RightLeg1.addBox(-6.0F, -4.0F, -6.0F, 6.0F, 17.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg1, -0.7330382858376184F, 0.24434609527920614F, 0.0F);
        this.LeftLeg1 = new ModelRenderer(this, 76, 153);
        this.LeftLeg1.setRotationPoint(4.0F, 10.7F, 9.0F);
        this.LeftLeg1.addBox(0.0F, -4.0F, -6.0F, 6.0F, 17.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg1, -0.7330382858376184F, -0.24434609527920614F, 0.0F);
        this.RightArm = new ModelRenderer(this, 73, 51);
        this.RightArm.setRotationPoint(-4.0F, 6.0F, -26.0F);
        this.RightArm.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightArm, 0.6066764186984569F, 0.0F, 0.10471975511965977F);
        this.Body1.addChild(this.LeftArm);
        this.Tail1.addChild(this.Tail2);
        this.Snout.addChild(this.CrestLeft);
        this.RightLeg2.addChild(this.RightFoot);
        this.Neck.addChild(this.Head1);
        this.Jaw1.addChild(this.Jaw3);
        this.Snout.addChild(this.UpperTeeth);
        this.Jaw1.addChild(this.Jaw2);
        this.Head1.addChild(this.Snout);
        this.Body1.addChild(this.Tail1);
        this.LeftLeg2.addChild(this.LeftFoot);
        this.Snout.addChild(this.CrestRight);
        this.Tail2.addChild(this.Osteoderm3);
        this.LeftLeg1.addChild(this.LeftLeg2);
        this.Body1.addChild(this.Osteoderm);
        this.RightLeg1.addChild(this.RightLeg2);
        this.Body1.addChild(this.Neck);
        this.Head1.addChild(this.Jaw1);
        this.Jaw2.addChild(this.LowerTeeth);
        this.Tail1.addChild(this.Osteoderm2);
        this.Snout.addChild(this.SnoutHorn);
        this.Body1.addChild(this.RightArm);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body1, this.RightLeg1, this.LeftLeg1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(CeratosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
