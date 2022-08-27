package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.PlesiohadrosEntity;

/**
 * PlesiohadrosModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class PlesiohadrosSleepingModel extends EntityModel<PlesiohadrosEntity> {
    public ModelRenderer LegFrontR;
    public ModelRenderer LegFrontL;
    public ModelRenderer ThighL;
    public ModelRenderer Body;
    public ModelRenderer ThighR;
    public ModelRenderer LegBackL;
    public ModelRenderer FeetL;
    public ModelRenderer BodyBack;
    public ModelRenderer Neck;
    public ModelRenderer TailBase;
    public ModelRenderer SpikesTailBese;
    public ModelRenderer TailTip;
    public ModelRenderer SpikesTailTip;
    public ModelRenderer Head;
    public ModelRenderer Beak;
    public ModelRenderer Nose;
    public ModelRenderer LegBackR;
    public ModelRenderer FeetR;

    public PlesiohadrosSleepingModel() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.Nose = new ModelRenderer(this, 48, 0);
        this.Nose.setRotationPoint(0.0F, -2.0F, -1.0F);
        this.Nose.addBox(-2.5F, -2.0F, -2.0F, 5.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 114, 30);
        this.Neck.setRotationPoint(0.0F, 1.5F, -6.0F);
        this.Neck.addBox(-2.0F, -4.0F, -12.0F, 4.0F, 10.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.5235987755982988F, -0.3490658503988659F, 0.0F);
        this.SpikesTailBese = new ModelRenderer(this, 48, 100);
        this.SpikesTailBese.setRotationPoint(0.0F, -6.0F, 1.0F);
        this.SpikesTailBese.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.ThighR = new ModelRenderer(this, 94, 0);
        this.ThighR.mirror = true;
        this.ThighR.setRotationPoint(-1.0F, 6.0F, 12.0F);
        this.ThighR.addBox(-4.0F, -3.0F, -3.0F, 5.0F, 20.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ThighR, -0.7330382858376184F, 0.5585053606381855F, 0.0F);
        this.Head = new ModelRenderer(this, 56, 0);
        this.Head.setRotationPoint(0.0F, -2.0F, -12.0F);
        this.Head.addBox(-3.0F, -2.01F, -3.0F, 6.0F, 6.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -0.4974188368183839F, 0.0F, 0.0F);
        this.LegFrontL = new ModelRenderer(this, 89, 70);
        this.LegFrontL.setRotationPoint(4.0F, 18.0F, -8.0F);
        this.LegFrontL.addBox(0.0F, -1.0F, -2.0F, 3.0F, 20.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegFrontL, -0.7330382858376184F, 0.0F, -0.9075712110370513F);
        this.LegBackL = new ModelRenderer(this, 130, 0);
        this.LegBackL.setRotationPoint(1.5F, 13.9F, 7.0F);
        this.LegBackL.addBox(-2.0F, -1.0F, -1.0F, 4.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegBackL, -0.8377580409572781F, 0.0F, 0.0F);
        this.BodyBack = new ModelRenderer(this, 0, 0);
        this.BodyBack.setRotationPoint(0.0F, 0.0F, 8.0F);
        this.BodyBack.addBox(-6.5F, -8.0F, 0.0F, 13.0F, 22.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(BodyBack, -0.17453292519943295F, 0.3490658503988659F, 0.0F);
        this.Beak = new ModelRenderer(this, 85, 0);
        this.Beak.setRotationPoint(0.0F, 3.0F, -3.0F);
        this.Beak.addBox(-2.0F, -3.0F, -5.0F, 4.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.LegFrontR = new ModelRenderer(this, 89, 70);
        this.LegFrontR.mirror = true;
        this.LegFrontR.setRotationPoint(-4.0F, 19.0F, -7.5F);
        this.LegFrontR.addBox(-3.0F, -1.0F, -2.0F, 3.0F, 20.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegFrontR, -1.3962634015954636F, 0.13962634015954636F, -0.13962634015954636F);
        this.LegBackR = new ModelRenderer(this, 130, 0);
        this.LegBackR.mirror = true;
        this.LegBackR.setRotationPoint(-1.5F, 13.9F, 7.0F);
        this.LegBackR.addBox(-2.0F, -1.0F, -1.0F, 4.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegBackR, -0.8377580409572781F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 49);
        this.Body.setRotationPoint(0.0F, 10.0F, -9.0F);
        this.Body.addBox(-5.0F, -6.0F, -6.0F, 10.0F, 19.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, 0.17453292519943295F, 0.0F, 0.0F);
        this.TailBase = new ModelRenderer(this, 54, 30);
        this.TailBase.setRotationPoint(0.0F, -2.0F, 20.0F);
        this.TailBase.addBox(-3.5F, -5.0F, -1.0F, 7.0F, 12.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(TailBase, -0.5585053606381855F, 0.41887902047863906F, 0.0F);
        this.TailTip = new ModelRenderer(this, 34, 70);
        this.TailTip.setRotationPoint(0.0F, 0.0F, 20.0F);
        this.TailTip.addBox(-2.5F, -3.0F, -2.0F, 5.0F, 6.0F, 31.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(TailTip, 0.41887902047863906F, 0.593411945678072F, 0.10471975511965977F);
        this.SpikesTailTip = new ModelRenderer(this, 43, 84);
        this.SpikesTailTip.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.SpikesTailTip.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 28.0F, 0.0F, 0.0F, 0.0F);
        this.ThighL = new ModelRenderer(this, 94, 0);
        this.ThighL.setRotationPoint(10.0F, 6.0F, 9.0F);
        this.ThighL.addBox(-1.0F, -3.0F, -3.0F, 5.0F, 20.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ThighL, -0.7330382858376184F, 0.0F, 0.0F);
        this.FeetL = new ModelRenderer(this, 130, 20);
        this.FeetL.setRotationPoint(0.0F, 11.0F, 1.0F);
        this.FeetL.addBox(-2.5F, 0.0F, -4.01F, 5.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FeetL, 1.5707963267948966F, 0.0F, 0.0F);
        this.FeetR = new ModelRenderer(this, 130, 20);
        this.FeetR.mirror = true;
        this.FeetR.setRotationPoint(0.0F, 11.0F, 1.0F);
        this.FeetR.addBox(-2.5F, 0.0F, -4.0F, 5.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FeetR, 1.5707963267948966F, 0.0F, 0.0F);
        this.Beak.addChild(this.Nose);
        this.Body.addChild(this.Neck);
        this.TailBase.addChild(this.SpikesTailBese);
        this.Neck.addChild(this.Head);
        this.ThighL.addChild(this.LegBackL);
        this.Body.addChild(this.BodyBack);
        this.Head.addChild(this.Beak);
        this.ThighR.addChild(this.LegBackR);
        this.BodyBack.addChild(this.TailBase);
        this.TailBase.addChild(this.TailTip);
        this.TailTip.addChild(this.SpikesTailTip);
        this.LegBackL.addChild(this.FeetL);
        this.LegBackR.addChild(this.FeetR);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.ThighR, this.LegFrontL, this.LegFrontR, this.Body, this.ThighL).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(PlesiohadrosEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
