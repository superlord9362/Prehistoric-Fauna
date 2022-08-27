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
 * TyrannosaurusrexjuvenileModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class TyrannosaurusrexjuvenileSleepingModel extends EntityModel<TyrannosaurusEntity> {
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
    public ModelRenderer Neck;
    public ModelRenderer LeftArm;
    public ModelRenderer RightArm;
    public ModelRenderer Head1;
    public ModelRenderer Snout;

    public TyrannosaurusrexjuvenileSleepingModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.LeftLeg2 = new ModelRenderer(this, 42, 38);
        this.LeftLeg2.setRotationPoint(0.0F, 14.0F, 4.0F);
        this.LeftLeg2.addBox(-2.0F, -4.0F, -1.0F, 4.0F, 20.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg2, -0.8761552978169589F, 0.0F, 0.0F);
        this.LeftFeet = new ModelRenderer(this, 69, 41);
        this.LeftFeet.setRotationPoint(0.0F, 16.0F, 1.0F);
        this.LeftFeet.addBox(-3.0F, -1.0F, -8.0F, 6.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftFeet, 1.5707963267948966F, 0.0F, 0.0F);
        this.RightFeet = new ModelRenderer(this, 69, 41);
        this.RightFeet.setRotationPoint(0.0F, 16.0F, 1.0F);
        this.RightFeet.addBox(-3.0F, -1.0F, -8.0F, 6.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightFeet, 1.5707963267948966F, 0.0F, 0.0F);
        this.Head1 = new ModelRenderer(this, 0, 81);
        this.Head1.setRotationPoint(-2.0F, -11.0F, -6.7F);
        this.Head1.addBox(-3.0F, -4.0F, -8.0F, 6.0F, 9.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head1, 0.41887902047863906F, -1.0471975511965976F, 0.0F);
        this.RightLeg2 = new ModelRenderer(this, 42, 38);
        this.RightLeg2.mirror = true;
        this.RightLeg2.setRotationPoint(0.0F, 14.0F, 4.0F);
        this.RightLeg2.addBox(-2.0F, -4.0F, -1.0F, 4.0F, 20.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg2, -0.8639379797371932F, -0.17453292519943295F, -0.17453292519943295F);
        this.Neck = new ModelRenderer(this, 104, 59);
        this.Neck.setRotationPoint(-2.0F, 1.0F, -17.0F);
        this.Neck.addBox(-2.0F, -15.0F, -7.0F, 4.0F, 20.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.41887902047863906F, -1.0471975511965976F, 0.0F);
        this.RightLeg1 = new ModelRenderer(this, 0, 43);
        this.RightLeg1.setRotationPoint(-6.0F, 8.8F, -1.0F);
        this.RightLeg1.addBox(-3.0F, -6.0F, -5.0F, 6.0F, 20.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg1, -0.6981317007977318F, 0.3490658503988659F, 0.0F);
        this.Body2 = new ModelRenderer(this, 63, 0);
        this.Body2.setRotationPoint(-2.0F, -3.0F, -6.0F);
        this.Body2.addBox(-5.0F, -5.0F, -19.0F, 10.0F, 15.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body2, 0.17453292519943295F, -0.5235987755982988F, 0.0F);
        this.Body1 = new ModelRenderer(this, 0, 0);
        this.Body1.setRotationPoint(0.0F, 12.6F, -1.0F);
        this.Body1.addBox(-4.0F, -7.0F, -11.0F, 8.0F, 17.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body1, -0.17453292519943295F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 56, 61);
        this.Tail2.setRotationPoint(0.0F, -1.0F, 33.0F);
        this.Tail2.addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 31.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.24434609527920614F, 0.41887902047863906F, 0.17453292519943295F);
        this.Snout = new ModelRenderer(this, 58, 67);
        this.Snout.setRotationPoint(0.0F, -3.0F, -8.0F);
        this.Snout.addBox(-2.0F, 0.0F, -9.0F, 4.0F, 7.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg1 = new ModelRenderer(this, 0, 43);
        this.LeftLeg1.setRotationPoint(6.0F, 8.8F, -1.0F);
        this.LeftLeg1.addBox(-3.0F, -6.0F, -5.0F, 6.0F, 20.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg1, -0.6981317007977318F, -0.5235987755982988F, 0.0F);
        this.RightArm = new ModelRenderer(this, 59, 0);
        this.RightArm.mirror = true;
        this.RightArm.setRotationPoint(-5.0F, 8.0F, -14.5F);
        this.RightArm.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 9.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightArm, 0.7330382858376184F, 0.24434609527920614F, 0.24434609527920614F);
        this.Tail1 = new ModelRenderer(this, 8, 69);
        this.Tail1.setRotationPoint(-1.0F, -3.0F, 6.0F);
        this.Tail1.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 11.0F, 33.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.17453292519943295F, 0.593411945678072F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 59, 0);
        this.LeftArm.setRotationPoint(4.5F, 8.0F, -14.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -1.0F, 2.0F, 9.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftArm, 0.6283185307179586F, 0.0F, -0.24434609527920614F);
        this.LeftLeg1.addChild(this.LeftLeg2);
        this.LeftLeg2.addChild(this.LeftFeet);
        this.RightLeg2.addChild(this.RightFeet);
        this.Neck.addChild(this.Head1);
        this.RightLeg1.addChild(this.RightLeg2);
        this.Body2.addChild(this.Neck);
        this.Body1.addChild(this.Body2);
        this.Tail1.addChild(this.Tail2);
        this.Head1.addChild(this.Snout);
        this.Body2.addChild(this.RightArm);
        this.Body1.addChild(this.Tail1);
        this.Body2.addChild(this.LeftArm);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.RightLeg1, this.Body1, this.LeftLeg1).forEach((modelRenderer) -> { 
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
