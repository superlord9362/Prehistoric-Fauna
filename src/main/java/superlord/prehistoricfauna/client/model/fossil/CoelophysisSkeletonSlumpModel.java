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
public class CoelophysisSkeletonSlumpModel extends EntityModel<CoelophysisSkeletonEntity> {
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

    public CoelophysisSkeletonSlumpModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.LFemur = new ModelRenderer(this, 101, 1);
        this.LFemur.mirror = true;
        this.LFemur.setRotationPoint(-1.5F, 21.5F, 4.0F);
        this.LFemur.addBox(-1.0F, -0.5F, -1.5F, 2.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LFemur, -1.382300714316287F, 0.0F, 0.0F);
        this.LFoot = new ModelRenderer(this, 0, 0);
        this.LFoot.mirror = true;
        this.LFoot.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.LFoot.addBox(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LFoot, 1.5707963267948966F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 0, 32);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.Tail2.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.32288591161895097F, -0.3490658503988659F, 0.0F);
        this.RArm = new ModelRenderer(this, 82, 0);
        this.RArm.setRotationPoint(2.0F, 2.5F, -10.5F);
        this.RArm.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RArm, -0.649262495057696F, 0.17453292519943295F, -0.5235987755982988F);
        this.Iliumtip = new ModelRenderer(this, 34, 14);
        this.Iliumtip.setRotationPoint(0.0F, -1.0F, -2.0F);
        this.Iliumtip.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.CaudalVertebrae2 = new ModelRenderer(this, 0, 32);
        this.CaudalVertebrae2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.CaudalVertebrae2.addBox(0.0F, -0.5F, 0.0F, 0.0F, 2.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.CervicalVertebrae = new ModelRenderer(this, 44, -1);
        this.CervicalVertebrae.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.CervicalVertebrae.addBox(0.0F, -6.5F, -3.0F, 0.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LArm = new ModelRenderer(this, 82, 0);
        this.LArm.mirror = true;
        this.LArm.setRotationPoint(-2.3F, 1.8F, -10.5F);
        this.LArm.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LArm, -1.5707963267948966F, -0.10471975511965977F, 0.7853981633974483F);
        this.Scapulae = new ModelRenderer(this, 0, 25);
        this.Scapulae.setRotationPoint(0.0F, -1.0F, -12.0F);
        this.Scapulae.addBox(-2.0F, -0.25F, 0.0F, 4.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Skull = new ModelRenderer(this, 55, 10);
        this.Skull.setRotationPoint(0.0F, -5.5F, -2.5F);
        this.Skull.addBox(-1.0F, -0.5F, -7.0F, 2.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Skull, -1.0821041362364843F, 0.3665191429188092F, -0.5235987755982988F);
        this.RFoot = new ModelRenderer(this, 0, 0);
        this.RFoot.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.RFoot.addBox(-1.0F, 0.0F, -3.0F, 2.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RFoot, 1.5707963267948966F, 0.0F, 0.0F);
        this.LLeg = new ModelRenderer(this, 6, 3);
        this.LLeg.mirror = true;
        this.LLeg.setRotationPoint(0.0F, 5.5F, 1.5F);
        this.LLeg.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LLeg, -0.18849556254433897F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 13, 0);
        this.Tail1.setRotationPoint(0.0F, -0.5F, 2.0F);
        this.Tail1.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.3839724354387525F, 0.17453292519943295F, 0.2617993877991494F);
        this.RLeg = new ModelRenderer(this, 6, 3);
        this.RLeg.setRotationPoint(-0.3F, 5.0F, 1.6F);
        this.RLeg.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RLeg, -0.7225663369572632F, -0.6981317007977318F, 0.17453292519943295F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 19.5F, 4.0F);
        this.Body.addBox(-1.5F, -1.0F, -12.0F, 3.0F, 5.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, 0.0F, 0.0F, -0.4363323129985824F);
        this.CaudalVertebrae = new ModelRenderer(this, 54, -8);
        this.CaudalVertebrae.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.CaudalVertebrae.addBox(0.0F, -0.5F, 0.0F, 0.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 34, 0);
        this.Neck.setRotationPoint(0.0F, -1.5F, -13.0F);
        this.Neck.addBox(-1.0F, -5.5F, -2.5F, 2.0F, 9.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 1.064650843716541F, 0.7330382858376184F, 0.0F);
        this.RFemur = new ModelRenderer(this, 101, 1);
        this.RFemur.setRotationPoint(2.0F, 20.0F, 4.0F);
        this.RFemur.addBox(-1.0F, -0.5F, -1.5F, 2.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RFemur, -0.7853981633974483F, 0.0F, -0.6283185307179586F);
        this.Vertebrae = new ModelRenderer(this, 0, 4);
        this.Vertebrae.setRotationPoint(0.0F, -1.0F, -13.0F);
        this.Vertebrae.addBox(0.0F, -0.5F, 0.0F, 0.0F, 6.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.LLeg.addChild(this.LFoot);
        this.Tail1.addChild(this.Tail2);
        this.Body.addChild(this.RArm);
        this.Body.addChild(this.Iliumtip);
        this.Tail2.addChild(this.CaudalVertebrae2);
        this.Neck.addChild(this.CervicalVertebrae);
        this.Body.addChild(this.LArm);
        this.Body.addChild(this.Scapulae);
        this.Neck.addChild(this.Skull);
        this.RLeg.addChild(this.RFoot);
        this.LFemur.addChild(this.LLeg);
        this.Body.addChild(this.Tail1);
        this.RFemur.addChild(this.RLeg);
        this.Tail1.addChild(this.CaudalVertebrae);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.Vertebrae);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.LFemur, this.Body, this.RFemur).forEach((modelRenderer) -> { 
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
