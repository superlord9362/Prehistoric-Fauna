package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.DilophosaurusSkeletonEntity;

/**
 * DilophosaurusModel - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class DilophosaurusSkeletonSittingModel extends EntityModel<DilophosaurusSkeletonEntity> {
    public ModelRenderer Ribcage;
    public ModelRenderer FemurLeft;
    public ModelRenderer FemurRight;
    public ModelRenderer CervicalRibs;
    public ModelRenderer CaudalRibs;
    public ModelRenderer ArmRight;
    public ModelRenderer ArmLeft;
    public ModelRenderer ThoracicVertebrae;
    public ModelRenderer PectoralGirdle;
    public ModelRenderer Skull;
    public ModelRenderer CervicalVertebrae;
    public ModelRenderer Snout;
    public ModelRenderer Jaw;
    public ModelRenderer Head;
    public ModelRenderer CrestRight;
    public ModelRenderer CrestLeft;
    public ModelRenderer Snout_1;
    public ModelRenderer Mouth;
    public ModelRenderer CaudalVertebrae;
    public ModelRenderer Tail2;
    public ModelRenderer Tail2_1;
    public ModelRenderer Leg2Left;
    public ModelRenderer FootLeft;
    public ModelRenderer Leg2Right;
    public ModelRenderer FootRight;

    public DilophosaurusSkeletonSittingModel() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.FemurRight = new ModelRenderer(this, 72, 51);
        this.FemurRight.mirror = true;
        this.FemurRight.setRotationPoint(-4.0F, 12.0F, 6.5F);
        this.FemurRight.addBox(-2.0F, 0.0F, -3.5F, 6.0F, 14.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FemurRight, -0.9599310885968813F, 0.3490658503988659F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 95, 3);
        this.Tail2.setRotationPoint(0.0F, 0.5F, 18.0F);
        this.Tail2.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 47.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.2792526803190927F, -0.41887902047863906F, 0.0F);
        this.Ribcage = new ModelRenderer(this, 0, 0);
        this.Ribcage.setRotationPoint(0.0F, 10.0F, 9.0F);
        this.Ribcage.addBox(-4.0F, -3.0F, -27.0F, 8.0F, 13.0F, 32.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Ribcage, -0.2617993877991494F, 0.0F, 0.0F);
        this.CaudalVertebrae = new ModelRenderer(this, 56, 4);
        this.CaudalVertebrae.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.CaudalVertebrae.addBox(0.0F, -2.0F, 0.0F, 0.0F, 8.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.FootLeft = new ModelRenderer(this, 72, 94);
        this.FootLeft.setRotationPoint(0.0F, 10.0F, 1.0F);
        this.FootLeft.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FootLeft, 1.5707963267948966F, 0.0F, 0.0F);
        this.Jaw = new ModelRenderer(this, 0, 106);
        this.Jaw.setRotationPoint(0.0F, 4.01F, 0.0F);
        this.Jaw.addBox(-2.0F, 0.0F, -4.99F, 4.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.CervicalVertebrae = new ModelRenderer(this, 35, 58);
        this.CervicalVertebrae.mirror = true;
        this.CervicalVertebrae.setRotationPoint(0.0F, -3.5F, 3.0F);
        this.CervicalVertebrae.addBox(0.0F, -10.0F, -8.0F, 0.0F, 12.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.CrestRight = new ModelRenderer(this, 0, -1);
        this.CrestRight.mirror = true;
        this.CrestRight.setRotationPoint(-1.5F, -2.0F, 0.0F);
        this.CrestRight.addBox(0.0F, -6.0F, -8.0F, 0.0F, 6.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(CrestRight, 0.0F, 0.0F, -0.08726646259971647F);
        this.CervicalRibs = new ModelRenderer(this, 0, 46);
        this.CervicalRibs.setRotationPoint(0.0F, 0.5F, -30.1F);
        this.CervicalRibs.addBox(-2.0F, -13.0F, -6.0F, 4.0F, 7.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(CervicalRibs, -0.6981317007977318F, -0.3839724354387525F, 0.0F);
        this.CrestLeft = new ModelRenderer(this, 0, -1);
        this.CrestLeft.setRotationPoint(1.5F, -2.0F, 0.0F);
        this.CrestLeft.addBox(0.0F, -6.0F, -8.0F, 0.0F, 6.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(CrestLeft, 0.0F, 0.0F, 0.08726646259971647F);
        this.Tail2_1 = new ModelRenderer(this, 98, 3);
        this.Tail2_1.setRotationPoint(0.0F, -0.5F, -1.0F);
        this.Tail2_1.addBox(0.0F, -1.0F, 0.0F, 0.0F, 5.0F, 47.0F, 0.0F, 0.0F, 0.0F);
        this.Leg2Left = new ModelRenderer(this, 72, 75);
        this.Leg2Left.setRotationPoint(-0.5F, 11.5F, 3.0F);
        this.Leg2Left.addBox(-2.0F, -4.0F, 0.0F, 4.0F, 15.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg2Left, -0.6108652381980153F, 0.0F, 0.0F);
        this.FootRight = new ModelRenderer(this, 72, 94);
        this.FootRight.mirror = true;
        this.FootRight.setRotationPoint(0.0F, 10.0F, 1.0F);
        this.FootRight.addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FootRight, 1.5707963267948966F, 0.0F, 0.0F);
        this.Skull = new ModelRenderer(this, 0, 70);
        this.Skull.setRotationPoint(0.0F, -12.5F, -5.0F);
        this.Skull.addBox(-2.5F, -1.0F, -5.0F, 5.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Skull, 0.7155849933176751F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 80);
        this.Snout.setRotationPoint(0.0F, 2.0F, -6.0F);
        this.Snout.addBox(-1.5F, -2.0F, -8.0F, 3.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.CaudalRibs = new ModelRenderer(this, 50, 4);
        this.CaudalRibs.setRotationPoint(0.0F, -2.0F, 5.0F);
        this.CaudalRibs.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(CaudalRibs, -0.13962634015954636F, -0.2617993877991494F, -0.13962634015954636F);
        this.ThoracicVertebrae = new ModelRenderer(this, 100, 48);
        this.ThoracicVertebrae.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ThoracicVertebrae.addBox(0.0F, -4.0F, -27.0F, 0.0F, 15.0F, 32.0F, 0.0F, 0.0F, 0.0F);
        this.Snout_1 = new ModelRenderer(this, -1, 115);
        this.Snout_1.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.Snout_1.addBox(-1.5F, 0.0F, -8.0F, 3.0F, 1.5F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.ArmLeft = new ModelRenderer(this, 41, 46);
        this.ArmLeft.setRotationPoint(4.5F, 6.0F, -23.0F);
        this.ArmLeft.addBox(-2.0F, 0.0F, -2.0F, 3.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmLeft, 1.2217304763960306F, 0.17453292519943295F, 0.3490658503988659F);
        this.Mouth = new ModelRenderer(this, 0, 93);
        this.Mouth.setRotationPoint(0.0F, 0.0F, -5.0F);
        this.Mouth.addBox(-1.0F, -1.0F, -8.99F, 2.0F, 3.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.Leg2Right = new ModelRenderer(this, 72, 75);
        this.Leg2Right.mirror = true;
        this.Leg2Right.setRotationPoint(0.5F, 12.5F, 3.0F);
        this.Leg2Right.addBox(-2.0F, -4.0F, 0.0F, 4.0F, 15.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Leg2Right, -0.6108652381980153F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 25, 119);
        this.Head.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.Head.addBox(-2.5F, -1.0F, -5.0F, 5.0F, 1.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.FemurLeft = new ModelRenderer(this, 72, 51);
        this.FemurLeft.setRotationPoint(4.0F, 12.5F, 6.5F);
        this.FemurLeft.addBox(-4.0F, -1.0F, -3.5F, 6.0F, 14.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FemurLeft, -0.9599310885968813F, -0.3490658503988659F, 0.0F);
        this.ArmRight = new ModelRenderer(this, 41, 46);
        this.ArmRight.mirror = true;
        this.ArmRight.setRotationPoint(-4.5F, 6.0F, -23.0F);
        this.ArmRight.addBox(-1.0F, 0.0F, -2.0F, 3.0F, 13.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(ArmRight, 1.2217304763960306F, -0.17453292519943295F, -0.3490658503988659F);
        this.PectoralGirdle = new ModelRenderer(this, 101, 3);
        this.PectoralGirdle.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.PectoralGirdle.addBox(-4.5F, -3.0F, -27.0F, 9.0F, 11.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.CaudalRibs.addChild(this.Tail2);
        this.CaudalRibs.addChild(this.CaudalVertebrae);
        this.Leg2Left.addChild(this.FootLeft);
        this.Skull.addChild(this.Jaw);
        this.CervicalRibs.addChild(this.CervicalVertebrae);
        this.Snout.addChild(this.CrestRight);
        this.Ribcage.addChild(this.CervicalRibs);
        this.Snout.addChild(this.CrestLeft);
        this.Tail2.addChild(this.Tail2_1);
        this.FemurLeft.addChild(this.Leg2Left);
        this.Leg2Right.addChild(this.FootRight);
        this.CervicalRibs.addChild(this.Skull);
        this.Skull.addChild(this.Snout);
        this.Ribcage.addChild(this.CaudalRibs);
        this.Ribcage.addChild(this.ThoracicVertebrae);
        this.Snout.addChild(this.Snout_1);
        this.Ribcage.addChild(this.ArmLeft);
        this.Jaw.addChild(this.Mouth);
        this.FemurRight.addChild(this.Leg2Right);
        this.Skull.addChild(this.Head);
        this.Ribcage.addChild(this.ArmRight);
        this.Ribcage.addChild(this.PectoralGirdle);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.FemurRight, this.Ribcage, this.FemurLeft).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(DilophosaurusSkeletonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
