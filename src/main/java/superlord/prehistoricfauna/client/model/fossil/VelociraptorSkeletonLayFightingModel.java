package superlord.prehistoricfauna.client.model.fossil;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fossil.VelociraptorSkeletonEntity;

/**
 * Velociraptor - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class VelociraptorSkeletonLayFightingModel extends EntityModel<VelociraptorSkeletonEntity> {
    public ModelRenderer Body;
    public ModelRenderer Thighright;
    public ModelRenderer Thighleft;
    public ModelRenderer Neck;
    public ModelRenderer Wingleft;
    public ModelRenderer Wingright;
    public ModelRenderer Vertebrae;
    public ModelRenderer Tail;
    public ModelRenderer Iliumtip;
    public ModelRenderer Head;
    public ModelRenderer Mouth;
    public ModelRenderer Tailribs;
    public ModelRenderer Legright;
    public ModelRenderer Footright;
    public ModelRenderer Legleft;
    public ModelRenderer Footleft;

    public VelociraptorSkeletonLayFightingModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Vertebrae = new ModelRenderer(this, 13, 9);
        this.Vertebrae.setRotationPoint(0.0F, -2.0F, -5.0F);
        this.Vertebrae.addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Mouth = new ModelRenderer(this, 31, 1);
        this.Mouth.setRotationPoint(0.0F, 1.0F, -4.0F);
        this.Mouth.addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 1, 0);
        this.Neck.setRotationPoint(0.0F, -1.5F, -5.0F);
        this.Neck.addBox(-0.5F, -4.0F, -3.0F, 1.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.6981317007977318F, -0.3839724354387525F, 0.0F);
        this.Tail = new ModelRenderer(this, 0, 12);
        this.Tail.setRotationPoint(0.0F, -1.0F, 5.0F);
        this.Tail.addBox(0.0F, -0.5F, 0.0F, 0.0F, 2.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, 1.0471975511965976F, 0.0F, -0.13962634015954636F);
        this.Thighleft = new ModelRenderer(this, 46, 0);
        this.Thighleft.setRotationPoint(1.0F, 21.0F, 3.0F);
        this.Thighleft.addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thighleft, -1.0471975511965976F, -0.3141592653589793F, -1.3962634015954636F);
        this.Wingright = new ModelRenderer(this, 0, 15);
        this.Wingright.mirror = true;
        this.Wingright.setRotationPoint(-2.0F, 1.0F, -3.0F);
        this.Wingright.addBox(-1.0F, 0.0F, 0.0F, 1.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Wingright, -1.5707963267948966F, -0.74176493209759F, 2.8797932657906435F);
        this.Wingleft = new ModelRenderer(this, 0, 15);
        this.Wingleft.setRotationPoint(1.0F, 0.5F, -4.0F);
        this.Wingleft.addBox(0.0F, 0.0F, 0.0F, 1.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Wingleft, 0.41887902047863906F, 0.0F, 0.0F);
        this.Legright = new ModelRenderer(this, 55, 11);
        this.Legright.mirror = true;
        this.Legright.setRotationPoint(-0.5F, 5.0F, 1.5F);
        this.Legright.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Legright, -0.4886921905584123F, 0.0F, 0.0F);
        this.Thighright = new ModelRenderer(this, 46, 0);
        this.Thighright.mirror = true;
        this.Thighright.setRotationPoint(0.0F, 23.0F, 2.5F);
        this.Thighright.addBox(-1.0F, 0.0F, -1.5F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thighright, -0.6632251157578453F, 0.0F, -1.5707963267948966F);
        this.Iliumtip = new ModelRenderer(this, 26, 10);
        this.Iliumtip.setRotationPoint(0.0F, -1.0F, 1.0F);
        this.Iliumtip.addBox(-1.5F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.Footleft = new ModelRenderer(this, 46, 10);
        this.Footleft.setRotationPoint(1.0F, 4.0F, 0.0F);
        this.Footleft.addBox(-1.5F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Footleft, 2.3038346126325147F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 21.5F, 0.0F);
        this.Body.addBox(-1.5F, -1.5F, -5.0F, 3.0F, 4.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, -0.41887902047863906F, -0.17453292519943295F, -1.2217304763960306F);
        this.Tailribs = new ModelRenderer(this, 33, 17);
        this.Tailribs.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.Tailribs.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Footright = new ModelRenderer(this, 46, 10);
        this.Footright.mirror = true;
        this.Footright.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.Footright.addBox(-1.5F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Footright, 1.1519173063162573F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 16, 0);
        this.Head.setRotationPoint(0.0F, -4.0F, -1.0F);
        this.Head.addBox(-1.5F, -1.0F, -4.0F, 3.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, 0.8726646259971648F, 0.0F, 0.0F);
        this.Legleft = new ModelRenderer(this, 55, 11);
        this.Legleft.setRotationPoint(0.5F, 5.0F, 1.5F);
        this.Legleft.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Legleft, -0.5235987755982988F, 0.0F, 0.0F);
        this.Body.addChild(this.Vertebrae);
        this.Head.addChild(this.Mouth);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.Wingright);
        this.Body.addChild(this.Wingleft);
        this.Thighright.addChild(this.Legright);
        this.Body.addChild(this.Iliumtip);
        this.Legleft.addChild(this.Footleft);
        this.Tail.addChild(this.Tailribs);
        this.Legright.addChild(this.Footright);
        this.Neck.addChild(this.Head);
        this.Thighleft.addChild(this.Legleft);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Thighleft, this.Thighright, this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(VelociraptorSkeletonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
