package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.CoelophysisSkeletonEntity;

/**
 * Coelophysis Skeleton - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class CoelophysisSkeletonSeizeModel extends EntityModel<CoelophysisSkeletonEntity> {
    public ModelRenderer Body;
    public ModelRenderer RFemur;
    public ModelRenderer LFemur;
    public ModelRenderer Tail1;
    public ModelRenderer LArm;
    public ModelRenderer RArm;
    public ModelRenderer Neck;
    public ModelRenderer Vertebrae;
    public ModelRenderer Iliumtip;
    public ModelRenderer Scapulae;
    public ModelRenderer CaudalVertebrae;
    public ModelRenderer Tail2;
    public ModelRenderer CaudalVertebrae2;
    public ModelRenderer CervicalVertebrae;
    public ModelRenderer Skull;
    public ModelRenderer RLeg;
    public ModelRenderer RFoot;
    public ModelRenderer LLeg;
    public ModelRenderer LFoot;

    public CoelophysisSkeletonSeizeModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Iliumtip = new ModelRenderer(this, 34, 14);
        this.Iliumtip.setRotationPoint(0.0F, -1.0F, -2.0F);
        this.Iliumtip.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 0, 32);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.Tail2.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.10471975511965977F, 0.3490658503988659F, 0.0F);
        this.Skull = new ModelRenderer(this, 55, 10);
        this.Skull.setRotationPoint(0.0F, -6.0F, -2.0F);
        this.Skull.addBox(-1.0F, 0.0F, -7.0F, 2.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Skull, -0.6255260065779288F, 0.17453292519943295F, 0.0F);
        this.LArm = new ModelRenderer(this, 82, 0);
        this.LArm.mirror = true;
        this.LArm.setRotationPoint(-2.0F, 2.5F, -10.5F);
        this.LArm.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LArm, -0.8726646259971648F, 0.0F, 0.6981317007977318F);
        this.Neck = new ModelRenderer(this, 34, 0);
        this.Neck.setRotationPoint(0.0F, -2.0F, -12.7F);
        this.Neck.addBox(-1.0F, -5.5F, -2.5F, 2.0F, 9.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.6981317007977318F, 0.24434609527920614F, 0.0F);
        this.Vertebrae = new ModelRenderer(this, 0, 4);
        this.Vertebrae.setRotationPoint(0.0F, -1.0F, -13.0F);
        this.Vertebrae.addBox(0.0F, -0.5F, 0.0F, 0.0F, 6.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.RFemur = new ModelRenderer(this, 101, 1);
        this.RFemur.setRotationPoint(1.5F, 12.5F, 3.5F);
        this.RFemur.addBox(-1.0F, -0.5F, -1.5F, 2.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RFemur, 0.5235987755982988F, -0.06981317007977318F, -0.3490658503988659F);
        this.RArm = new ModelRenderer(this, 82, 0);
        this.RArm.setRotationPoint(2.0F, 2.5F, -10.5F);
        this.RArm.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RArm, -1.0471975511965976F, 0.0F, -0.5235987755982988F);
        this.CervicalVertebrae = new ModelRenderer(this, 44, -1);
        this.CervicalVertebrae.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.CervicalVertebrae.addBox(0.0F, -6.5F, -3.0F, 0.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.RLeg = new ModelRenderer(this, 6, 3);
        this.RLeg.setRotationPoint(0.0F, 5.5F, 1.5F);
        this.RLeg.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RLeg, 0.5235987755982988F, 0.0F, 0.0F);
        this.LFemur = new ModelRenderer(this, 101, 1);
        this.LFemur.mirror = true;
        this.LFemur.setRotationPoint(-1.5F, 12.5F, 3.5F);
        this.LFemur.addBox(-1.0F, -0.5F, -1.5F, 2.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LFemur, -0.2617993877991494F, 0.3490658503988659F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 12.0F, 4.0F);
        this.Body.addBox(-1.5F, -1.0F, -12.0F, 3.0F, 5.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, 0.10471975511965977F, 0.0F, 0.0F);
        this.LLeg = new ModelRenderer(this, 6, 3);
        this.LLeg.mirror = true;
        this.LLeg.setRotationPoint(0.0F, 5.5F, 1.5F);
        this.LLeg.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.LFoot = new ModelRenderer(this, 0, 0);
        this.LFoot.mirror = true;
        this.LFoot.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.LFoot.addBox(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LFoot, 0.2617993877991494F, 0.0F, 0.0F);
        this.CaudalVertebrae = new ModelRenderer(this, 54, -8);
        this.CaudalVertebrae.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.CaudalVertebrae.addBox(0.0F, -0.5F, 0.0F, 0.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.CaudalVertebrae2 = new ModelRenderer(this, 0, 32);
        this.CaudalVertebrae2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.CaudalVertebrae2.addBox(0.0F, -0.5F, 0.0F, 0.0F, 2.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 13, 0);
        this.Tail1.setRotationPoint(0.0F, -0.5F, 2.0F);
        this.Tail1.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, 0.24434609527920614F, 0.3490658503988659F, 0.0F);
        this.Scapulae = new ModelRenderer(this, 0, 25);
        this.Scapulae.setRotationPoint(0.0F, -1.0F, -12.0F);
        this.Scapulae.addBox(-2.0F, -0.25F, 0.0F, 4.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.RFoot = new ModelRenderer(this, 0, 0);
        this.RFoot.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.RFoot.addBox(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RFoot, 1.0471975511965976F, 0.0F, 0.0F);
        this.Body.addChild(this.Iliumtip);
        this.Tail1.addChild(this.Tail2);
        this.Neck.addChild(this.Skull);
        this.Body.addChild(this.LArm);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.Vertebrae);
        this.Body.addChild(this.RArm);
        this.Neck.addChild(this.CervicalVertebrae);
        this.RFemur.addChild(this.RLeg);
        this.LFemur.addChild(this.LLeg);
        this.LLeg.addChild(this.LFoot);
        this.Tail1.addChild(this.CaudalVertebrae);
        this.Tail2.addChild(this.CaudalVertebrae2);
        this.Body.addChild(this.Tail1);
        this.Body.addChild(this.Scapulae);
        this.RLeg.addChild(this.RFoot);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.RFemur, this.LFemur, this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(CoelophysisSkeletonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
