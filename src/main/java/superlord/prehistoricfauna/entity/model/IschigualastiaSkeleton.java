package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.IschigualastiaSkeletonEntity;

/**
 * Ischigualastia - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class IschigualastiaSkeleton extends EntityModel<IschigualastiaSkeletonEntity> {
    public ModelRenderer Body;
    public ModelRenderer Neck;
    public ModelRenderer LegL;
    public ModelRenderer ArmR;
    public ModelRenderer Tail;
    public ModelRenderer ArmL;
    public ModelRenderer Vertebrae;
    public ModelRenderer LegR;
    public ModelRenderer Face;
    public ModelRenderer FootL;
    public ModelRenderer part10;
    public ModelRenderer FootR;

    public IschigualastiaSkeleton() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.LegL = new ModelRenderer(this, 65, 57);
        this.LegL.setRotationPoint(7.0F, -10.0F, 5.0F);
        this.LegL.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 22.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 9.0F, 8.0F);
        this.Body.addBox(-10.0F, -13.0F, -24.0F, 20.0F, 18.0F, 34.0F, 0.0F, 0.0F, 0.0F);
        this.Vertebrae = new ModelRenderer(this, 111, 22);
        this.Vertebrae.setRotationPoint(0.0F, -10.0F, -25.0F);
        this.Vertebrae.addBox(0.0F, -6.0F, 0.0F, 0.0F, 18.0F, 35.0F, 0.0F, 0.0F, 0.0F);
        this.part10 = new ModelRenderer(this, 134, 64);
        this.part10.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.part10.addBox(0.0F, -1.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.FootR = new ModelRenderer(this, 70, 90);
        this.FootR.mirror = true;
        this.FootR.setRotationPoint(-2.0F, 22.0F, -5.0F);
        this.FootR.addBox(-3.5F, 0.0F, 0.0F, 7.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.ArmL = new ModelRenderer(this, 62, 99);
        this.ArmL.setRotationPoint(7.0F, -2.0F, -18.0F);
        this.ArmL.addBox(-2.0F, 0.0F, -4.0F, 6.0F, 17.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.ArmR = new ModelRenderer(this, 62, 99);
        this.ArmR.mirror = true;
        this.ArmR.setRotationPoint(-7.0F, -2.0F, -18.0F);
        this.ArmR.addBox(-4.0F, 0.0F, -4.0F, 6.0F, 17.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 103, 0);
        this.Tail.setRotationPoint(0.0F, -13.0F, 10.0F);
        this.Tail.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 0.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -1.0471975511965976F, 0.0F, 0.0F);
        this.FootL = new ModelRenderer(this, 70, 90);
        this.FootL.setRotationPoint(2.0F, 22.0F, -5.0F);
        this.FootL.addBox(-3.5F, 0.0F, 0.0F, 7.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 64);
        this.Neck.setRotationPoint(0.0F, -6.0F, -25.0F);
        this.Neck.addBox(-6.0F, -6.0F, -13.0F, 12.0F, 14.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.LegR = new ModelRenderer(this, 65, 57);
        this.LegR.mirror = true;
        this.LegR.setRotationPoint(-7.0F, -10.0F, 5.0F);
        this.LegR.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 22.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Face = new ModelRenderer(this, 0, 99);
        this.Face.setRotationPoint(0.0F, 2.0F, -13.0F);
        this.Face.addBox(-4.5F, -6.0F, -8.0F, 9.0F, 12.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.LegL);
        this.Body.addChild(this.Vertebrae);
        this.Tail.addChild(this.part10);
        this.LegR.addChild(this.FootR);
        this.Body.addChild(this.ArmL);
        this.Body.addChild(this.ArmR);
        this.Body.addChild(this.Tail);
        this.LegL.addChild(this.FootL);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.LegR);
        this.Neck.addChild(this.Face);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(IschigualastiaSkeletonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
