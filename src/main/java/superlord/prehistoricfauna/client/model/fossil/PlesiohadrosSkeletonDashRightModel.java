package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.PlesiohadrosSkeletonEntity;

/**
 * PlesiohadrosSkeleton - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class PlesiohadrosSkeletonDashRightModel extends EntityModel<PlesiohadrosSkeletonEntity> {
    public ModelRenderer LegFrontR;
    public ModelRenderer LegFrontL;
    public ModelRenderer ThighL;
    public ModelRenderer Ribs;
    public ModelRenderer ThighR;
    public ModelRenderer LegBackL;
    public ModelRenderer FeetL;
    public ModelRenderer Pelvis;
    public ModelRenderer Neck;
    public ModelRenderer PectoralGirdle;
    public ModelRenderer ThoracicVertebrae;
    public ModelRenderer PosteriorRibs;
    public ModelRenderer SacralVertebrae;
    public ModelRenderer CaudalVertebrae;
    public ModelRenderer CaudalRibs;
    public ModelRenderer TailTip;
    public ModelRenderer TailTip_1;
    public ModelRenderer Head;
    public ModelRenderer CervicalRibs;
    public ModelRenderer Beak;
    public ModelRenderer Jaw;
    public ModelRenderer Jugal;
    public ModelRenderer Nose;
    public ModelRenderer Beak_1;
    public ModelRenderer Jaw_1;
    public ModelRenderer LegBackR;
    public ModelRenderer FeetR;

    public PlesiohadrosSkeletonDashRightModel() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.LegFrontL = new ModelRenderer(this, 89, 70);
        this.LegFrontL.setRotationPoint(4.0F, 0.0F, -16.0F);
        this.LegFrontL.addBox(0.0F, -1.0F, -2.0F, 3.0F, 20.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegFrontL, 0.7330382858376184F, 0.0F, -0.0F);
        this.CaudalRibs = new ModelRenderer(this, 56, 32);
        this.CaudalRibs.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.CaudalRibs.addBox(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.Ribs = new ModelRenderer(this, 0, 50);
        this.Ribs.setRotationPoint(0.0F, -7.3F, -12.0F);
        this.Ribs.addBox(-5.0F, -5.0F, -6.0F, 10.0F, 18.0F, 17.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Ribs, -0.2617993877991494F, 0.0F, 0.0F);
        this.ThighR = new ModelRenderer(this, 98, 4);
        this.ThighR.mirror = true;
        this.ThighR.setRotationPoint(-7.0F, -1.5F, 8.5F);
        this.ThighR.addBox(-2.0F, -1.5F, -3.0F, 5.0F, 15.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ThighR, -0.5061454830783556F, 0.2792526803190927F, 0.0F);
        this.ThoracicVertebrae = new ModelRenderer(this, 106, 53);
        this.ThoracicVertebrae.setRotationPoint(0.0F, -7.0F, -7.0F);
        this.ThoracicVertebrae.addBox(0.0F, 0.0F, 0.0F, 0.0F, 7.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.LegBackL = new ModelRenderer(this, 130, 0);
        this.LegBackL.setRotationPoint(0.0F, 13.5F, 3.0F);
        this.LegBackL.addBox(-2.0F, -1.0F, -1.0F, 4.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegBackL, 0.19198621771937624F, 0.0F, 0.0F);
        this.FeetL = new ModelRenderer(this, 130, 20);
        this.FeetL.setRotationPoint(0.0F, 11.0F, -0.5F);
        this.FeetL.addBox(-2.5F, 0.0F, -4.01F, 5.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FeetL, -0.19198621771937624F, 0.0F, 0.0F);
        this.Jaw = new ModelRenderer(this, 151, 0);
        this.Jaw.setRotationPoint(0.0F, 2.5F, 0.0F);
        this.Jaw.addBox(-2.5F, -1.0F, -8.0F, 5.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Jaw, 0.2617993877991494F, 0.0F, 0.0F);
        this.LegBackR = new ModelRenderer(this, 130, 0);
        this.LegBackR.mirror = true;
        this.LegBackR.setRotationPoint(0.0F, 12.5F, 4.5F);
        this.LegBackR.addBox(-2.0F, -1.0F, -1.0F, 4.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegBackR, -0.43039819087864056F, 0.0F, 0.0F);
        this.CaudalVertebrae = new ModelRenderer(this, 62, 31);
        this.CaudalVertebrae.setRotationPoint(0.0F, -8.0F, 22.0F);
        this.CaudalVertebrae.addBox(0.0F, -1.0F, 0.0F, 0.0F, 9.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(CaudalVertebrae, 0.19547687289441354F, 0.4886921905584123F, 0.0F);
        this.TailTip = new ModelRenderer(this, 34, 70);
        this.TailTip.setRotationPoint(0.0F, 2.0F, 20.0F);
        this.TailTip.addBox(0.0F, -2.0F, -4.0F, 0.0F, 6.0F, 32.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(TailTip, 0.0781907508222411F, 0.3490658503988659F, 0.0F);
        this.Jaw_1 = new ModelRenderer(this, 180, 0);
        this.Jaw_1.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.Jaw_1.addBox(-1.5F, 0.0F, -4.99F, 3.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.PosteriorRibs = new ModelRenderer(this, -1, 114);
        this.PosteriorRibs.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.PosteriorRibs.addBox(-4.5F, 0.0F, 0.0F, 9.0F, 4.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Beak_1 = new ModelRenderer(this, 229, 3);
        this.Beak_1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Beak_1.addBox(-2.0F, 0.0F, -5.0F, 4.0F, 1.1F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.CervicalRibs = new ModelRenderer(this, 123, 39);
        this.CervicalRibs.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.CervicalRibs.addBox(-2.0F, 0.0F, -7.0F, 4.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.TailTip_1 = new ModelRenderer(this, 41, 74);
        this.TailTip_1.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.TailTip_1.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 26.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 56, 0);
        this.Head.setRotationPoint(0.0F, -0.6F, -7.5F);
        this.Head.addBox(-3.0F, -1.5F, -8.0F, 6.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, 0.4886921905584123F, 0.0F, 0.0F);
        this.PectoralGirdle = new ModelRenderer(this, 159, 19);
        this.PectoralGirdle.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.PectoralGirdle.addBox(-5.5F, -5.0F, -6.0F, 11.0F, 15.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.SacralVertebrae = new ModelRenderer(this, 21, 5);
        this.SacralVertebrae.setRotationPoint(0.0F, -10.0F, -1.0F);
        this.SacralVertebrae.addBox(0.0F, 0.0F, 0.0F, 0.0F, 22.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.Nose = new ModelRenderer(this, 48, 0);
        this.Nose.setRotationPoint(0.0F, -2.0F, -1.0F);
        this.Nose.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.FeetR = new ModelRenderer(this, 130, 20);
        this.FeetR.mirror = true;
        this.FeetR.setRotationPoint(0.0F, 11.0F, 0.0F);
        this.FeetR.addBox(-2.5F, 0.0F, -4.0F, 5.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FeetR, 1.117010721276371F, 0.0F, 0.0F);
        this.ThighL = new ModelRenderer(this, 98, 4);
        this.ThighL.setRotationPoint(4.5F, -2.5F, 9.0F);
        this.ThighL.addBox(-3.0F, -1.5F, -3.0F, 5.0F, 15.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ThighL, 0.0F, -0.2792526803190927F, 0.0F);
        this.Pelvis = new ModelRenderer(this, 0, 0);
        this.Pelvis.setRotationPoint(0.0F, 2.0F, 9.3F);
        this.Pelvis.addBox(-6.5F, -8.0F, 0.0F, 13.0F, 6.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Pelvis, -0.08726646259971647F, -0.17453292519943295F, 0.0F);
        this.Beak = new ModelRenderer(this, 85, 0);
        this.Beak.setRotationPoint(0.0F, 3.5F, -8.0F);
        this.Beak.addBox(-2.0F, -3.0F, -5.0F, 4.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Jugal = new ModelRenderer(this, 199, 2);
        this.Jugal.setRotationPoint(0.0F, 2.5F, -4.0F);
        this.Jugal.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 125, 47);
        this.Neck.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.Neck.addBox(0.0F, -2.0F, -8.0F, 0.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.0F, 0.3490658503988659F, 0.0F);
        this.LegFrontR = new ModelRenderer(this, 89, 70);
        this.LegFrontR.mirror = true;
        this.LegFrontR.setRotationPoint(-4.0F, 0.0F, -16.0F);
        this.LegFrontR.addBox(-3.0F, -1.0F, -2.0F, 3.0F, 20.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LegFrontR, 0.8726646259971648F, 0.0F, 0.0F);
        this.CaudalVertebrae.addChild(this.CaudalRibs);
        this.Ribs.addChild(this.ThoracicVertebrae);
        this.ThighL.addChild(this.LegBackL);
        this.LegBackL.addChild(this.FeetL);
        this.Head.addChild(this.Jaw);
        this.ThighR.addChild(this.LegBackR);
        this.Pelvis.addChild(this.CaudalVertebrae);
        this.CaudalVertebrae.addChild(this.TailTip);
        this.Jaw.addChild(this.Jaw_1);
        this.Pelvis.addChild(this.PosteriorRibs);
        this.Beak.addChild(this.Beak_1);
        this.Neck.addChild(this.CervicalRibs);
        this.TailTip.addChild(this.TailTip_1);
        this.Neck.addChild(this.Head);
        this.Ribs.addChild(this.PectoralGirdle);
        this.Pelvis.addChild(this.SacralVertebrae);
        this.Beak.addChild(this.Nose);
        this.LegBackR.addChild(this.FeetR);
        this.Ribs.addChild(this.Pelvis);
        this.Head.addChild(this.Beak);
        this.Head.addChild(this.Jugal);
        this.Ribs.addChild(this.Neck);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.LegFrontL, this.Ribs, this.ThighR, this.ThighL, this.LegFrontR).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(PlesiohadrosSkeletonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
