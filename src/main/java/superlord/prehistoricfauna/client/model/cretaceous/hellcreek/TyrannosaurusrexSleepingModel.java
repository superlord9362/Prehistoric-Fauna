package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.hellcreek.TyrannosaurusEntity;

/**
 * TyrannosaurusrexModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class TyrannosaurusrexSleepingModel extends EntityModel<TyrannosaurusEntity> {
    public ModelRenderer LeftLeg1;
    public ModelRenderer RightLeg1;
    public ModelRenderer Body1;
    public ModelRenderer LeftLeg2;
    public ModelRenderer LeftFeet;
    public ModelRenderer RightLeg2;
    public ModelRenderer RightFeet;
    public ModelRenderer Tail1;
    public ModelRenderer Body2;
    public ModelRenderer Tail2;
    public ModelRenderer RightArm;
    public ModelRenderer LeftArm;
    public ModelRenderer Neck;
    public ModelRenderer Head1;
    public ModelRenderer Snout;
    public ModelRenderer Jaw1;
    public ModelRenderer UpperTeeth;
    public ModelRenderer Jaw3;
    public ModelRenderer Jaw2;
    public ModelRenderer LowerTeeth;

    public TyrannosaurusrexSleepingModel() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.Body2 = new ModelRenderer(this, 146, 0);
        this.Body2.setRotationPoint(4.0F, -1.0F, -20.0F);
        this.Body2.addBox(-11.0F, -5.0F, -23.0F, 22.0F, 28.0F, 31.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body2, 0.41887902047863906F, -0.5235987755982988F, 0.0F);
        this.Neck = new ModelRenderer(this, 167, 66);
        this.Neck.setRotationPoint(0.0F, 10.0F, -20.0F);
        this.Neck.addBox(-5.0F, -21.0F, -13.0F, 10.0F, 29.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.8203047484373349F, -0.3490658503988659F, -0.10471975511965977F);
        this.Jaw2 = new ModelRenderer(this, 5, 212);
        this.Jaw2.setRotationPoint(0.0F, 1.0F, -11.0F);
        this.Jaw2.addBox(-4.0F, 0.0F, -16.0F, 8.0F, 5.0F, 17.0F, 0.0F, 0.0F, 0.0F);
        this.RightFeet = new ModelRenderer(this, 98, 50);
        this.RightFeet.setRotationPoint(0.0F, 22.0F, 5.0F);
        this.RightFeet.addBox(-4.0F, -1.0F, -13.0F, 8.0F, 3.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightFeet, 1.5707963267948966F, 0.0F, 0.0F);
        this.RightLeg2 = new ModelRenderer(this, 96, 72);
        this.RightLeg2.mirror = true;
        this.RightLeg2.setRotationPoint(-2.0F, 22.0F, 8.0F);
        this.RightLeg2.addBox(-3.0F, -4.0F, -1.0F, 6.0F, 30.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg2, -0.8726646259971648F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 92, 61);
        this.Tail2.setRotationPoint(0.6F, -2.0F, 50.0F);
        this.Tail2.addBox(-3.0F, -1.0F, -7.0F, 6.0F, 11.0F, 54.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.24434609527920614F, 0.41887902047863906F, 0.0F);
        this.UpperTeeth = new ModelRenderer(this, 106, 150);
        this.UpperTeeth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.UpperTeeth.addBox(-3.5F, 0.0F, -15.99F, 7.0F, 12.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg2 = new ModelRenderer(this, 96, 72);
        this.LeftLeg2.setRotationPoint(2.0F, 22.0F, 8.0F);
        this.LeftLeg2.addBox(-3.0F, -4.0F, -1.0F, 6.0F, 30.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg2, -0.8726646259971648F, 0.0F, 0.0F);
        this.LowerTeeth = new ModelRenderer(this, 45, 201);
        this.LowerTeeth.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.LowerTeeth.addBox(-3.0F, -3.0F, -15.0F, 6.0F, 7.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg1 = new ModelRenderer(this, 0, 69);
        this.LeftLeg1.setRotationPoint(6.0F, -5.0F, 3.0F);
        this.LeftLeg1.addBox(-3.0F, -6.0F, -9.0F, 10.0F, 34.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg1, -0.6981317007977318F, -0.5235987755982988F, 0.0F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, -1.6F, 0.0F);
        this.Body1.addBox(-7.5F, -10.0F, -16.0F, 15.0F, 33.0F, 33.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body1, -0.17453292519943295F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 8, 69);
        this.Tail1.setRotationPoint(3.0F, -3.0F, 19.5F);
        this.Tail1.addBox(-5.0F, -5.0F, -8.0F, 10.0F, 18.0F, 58.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.24434609527920614F, 0.593411945678072F, 0.0F);
        this.Head1 = new ModelRenderer(this, 0, 157);
        this.Head1.setRotationPoint(-1.0F, -15.0F, -6.0F);
        this.Head1.addBox(-7.0F, -4.0F, -11.0F, 14.0F, 11.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head1, -0.9075712110370513F, -0.06981317007977318F, 0.3490658503988659F);
        this.LeftArm = new ModelRenderer(this, 69, 0);
        this.LeftArm.setRotationPoint(10.1F, 19.0F, -13.0F);
        this.LeftArm.addBox(-2.0F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftArm, -1.3264502315156905F, -0.13962634015954636F, -0.0F);
        this.Jaw1 = new ModelRenderer(this, 0, 186);
        this.Jaw1.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.Jaw1.addBox(-7.0F, 0.0F, -11.0F, 14.0F, 7.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.RightArm = new ModelRenderer(this, 69, 0);
        this.RightArm.mirror = true;
        this.RightArm.setRotationPoint(-11.0F, 19.0F, -14.0F);
        this.RightArm.addBox(-1.0F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightArm, -1.0878637547259988F, 0.296705972839036F, -0.13962634015954636F);
        this.Jaw3 = new ModelRenderer(this, 47, 181);
        this.Jaw3.setRotationPoint(0.0F, 0.0F, -9.0F);
        this.Jaw3.addBox(-5.5F, -5.0F, 0.0F, 11.0F, 5.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 57, 150);
        this.Snout.setRotationPoint(0.0F, -2.0F, -11.0F);
        this.Snout.addBox(-4.0F, 0.0F, -16.0F, 8.0F, 10.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg1 = new ModelRenderer(this, 0, 69);
        this.RightLeg1.setRotationPoint(-7.0F, -5.0F, 2.0F);
        this.RightLeg1.addBox(-7.0F, -6.0F, -9.0F, 10.0F, 34.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg1, -0.6981317007977318F, 0.2792526803190927F, 0.0F);
        this.LeftFeet = new ModelRenderer(this, 98, 50);
        this.LeftFeet.setRotationPoint(0.0F, 22.0F, 5.0F);
        this.LeftFeet.addBox(-4.0F, -1.0F, -13.0F, 8.0F, 3.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftFeet, 1.5707963267948966F, 0.0F, 0.0F);
        this.Body1.addChild(this.Body2);
        this.Body2.addChild(this.Neck);
        this.Jaw1.addChild(this.Jaw2);
        this.RightLeg2.addChild(this.RightFeet);
        this.RightLeg1.addChild(this.RightLeg2);
        this.Tail1.addChild(this.Tail2);
        this.Snout.addChild(this.UpperTeeth);
        this.LeftLeg1.addChild(this.LeftLeg2);
        this.Jaw2.addChild(this.LowerTeeth);
        this.Body1.addChild(this.Tail1);
        this.Neck.addChild(this.Head1);
        this.Body2.addChild(this.LeftArm);
        this.Head1.addChild(this.Jaw1);
        this.Body2.addChild(this.RightArm);
        this.Jaw1.addChild(this.Jaw3);
        this.Head1.addChild(this.Snout);
        this.LeftLeg2.addChild(this.LeftFeet);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.LeftLeg1, this.Body1, this.RightLeg1).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(TyrannosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
