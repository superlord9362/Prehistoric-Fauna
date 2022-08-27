package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.VelociraptorEntity;

/**
 * VelociraptorModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class VelociraptorSleepingModel extends EntityModel<VelociraptorEntity> {
    public ModelRenderer Thighleft;
    public ModelRenderer Thighright;
    public ModelRenderer Body;
    public ModelRenderer Legleft;
    public ModelRenderer Footleft;
    public ModelRenderer Legright;
    public ModelRenderer Footright;
    public ModelRenderer Wingleft;
    public ModelRenderer Tail;
    public ModelRenderer Wingright;
    public ModelRenderer Neck;
    public ModelRenderer Tailfan;
    public ModelRenderer Head;
    public ModelRenderer Mouth;

    public VelociraptorSleepingModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Tailfan = new ModelRenderer(this, 0, 15);
        this.Tailfan.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.Tailfan.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 2.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.Footleft = new ModelRenderer(this, 46, 10);
        this.Footleft.setRotationPoint(0.0F, 3.9F, 0.0F);
        this.Footleft.addBox(-0.5F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Footleft, 1.5707963267948966F, 0.0F, 0.24609143118910318F);
        this.Wingleft = new ModelRenderer(this, 0, 15);
        this.Wingleft.setRotationPoint(1.5F, 1.0F, -3.0F);
        this.Wingleft.addBox(0.0F, -1.0F, -1.0F, 1.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Wingleft, 0.0F, 0.0F, -0.8726646259971648F);
        this.Wingright = new ModelRenderer(this, 0, 15);
        this.Wingright.mirror = true;
        this.Wingright.setRotationPoint(-1.5F, 1.0F, -3.0F);
        this.Wingright.addBox(-1.0F, -1.0F, -1.0F, 1.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Wingright, 0.0F, 0.0F, 0.8726646259971648F);
        this.Thighleft = new ModelRenderer(this, 46, 0);
        this.Thighleft.setRotationPoint(0.5F, 19.2F, 3.0F);
        this.Thighleft.addBox(0.0F, 0.0F, -1.5F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thighleft, -0.6981317007977318F, -0.24434609527920614F, 0.0F);
        this.Tail = new ModelRenderer(this, 23, 7);
        this.Tail.setRotationPoint(0.0F, -0.5F, 5.0F);
        this.Tail.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.13962634015954636F, 1.0471975511965976F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 0);
        this.Neck.setRotationPoint(-1.0F, 0.0F, -4.5F);
        this.Neck.addBox(-1.0F, -6.0F, -3.0F, 2.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, -0.41887902047863906F, -2.2689280275926285F, 0.8377580409572781F);
        this.Head = new ModelRenderer(this, 16, 0);
        this.Head.setRotationPoint(0.1F, -4.3F, -2.0F);
        this.Head.addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, 0.593411945678072F, 0.0F, 0.0F);
        this.Mouth = new ModelRenderer(this, 31, 1);
        this.Mouth.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.Mouth.addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Thighright = new ModelRenderer(this, 46, 0);
        this.Thighright.mirror = true;
        this.Thighright.setRotationPoint(-0.5F, 19.2F, 3.0F);
        this.Thighright.addBox(-2.0F, 0.0F, -1.5F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Thighright, -0.6981317007977318F, 0.24434609527920614F, 0.0F);
        this.Legleft = new ModelRenderer(this, 55, 11);
        this.Legleft.setRotationPoint(1.0F, 5.0F, 1.5F);
        this.Legleft.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Legleft, -0.8726646259971648F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.Body.addBox(-1.5F, -2.0F, -5.0F, 3.0F, 5.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, -0.17453292519943295F, 0.0F, 0.0F);
        this.Footright = new ModelRenderer(this, 46, 10);
        this.Footright.mirror = true;
        this.Footright.setRotationPoint(0.0F, 3.9F, 0.0F);
        this.Footright.addBox(-1.5F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Footright, 1.5707963267948966F, 0.0F, -0.24434609527920614F);
        this.Legright = new ModelRenderer(this, 55, 11);
        this.Legright.mirror = true;
        this.Legright.setRotationPoint(-1.0F, 5.0F, 1.5F);
        this.Legright.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Legright, -0.8726646259971648F, 0.0F, 0.0F);
        this.Tail.addChild(this.Tailfan);
        this.Legleft.addChild(this.Footleft);
        this.Body.addChild(this.Wingleft);
        this.Body.addChild(this.Wingright);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.Neck);
        this.Neck.addChild(this.Head);
        this.Head.addChild(this.Mouth);
        this.Thighleft.addChild(this.Legleft);
        this.Legright.addChild(this.Footright);
        this.Thighright.addChild(this.Legright);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Thighleft, this.Thighright, this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(VelociraptorEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
