package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.GarEntity;

/**
 * GarSmall - superlord9362
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class GarSmallModel extends EntityModel<GarEntity> {
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer Body;
    public ModelRenderer LeftFin;
    public ModelRenderer RightFin;
    public ModelRenderer Tail;
    public ModelRenderer BottomFin;

    public GarSmallModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(-1.0F, 22.0F, -3.5F);
        this.Head.addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 12, 0);
        this.Body.setRotationPoint(1.0F, 1.0F, 4.0F);
        this.Body.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.LeftFin = new ModelRenderer(this, 0, 0);
        this.LeftFin.setRotationPoint(2.0F, 1.5F, 2.0F);
        this.LeftFin.addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftFin, -0.2617993877991494F, 0.4363323129985824F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 7);
        this.Snout.setRotationPoint(0.5F, 1.0F, 0.0F);
        this.Snout.addBox(0.0F, 0.0F, -4.0F, 1.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.RightFin = new ModelRenderer(this, 0, 0);
        this.RightFin.mirror = true;
        this.RightFin.setRotationPoint(0.0F, 1.5F, 2.0F);
        this.RightFin.addBox(0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightFin, -0.2617993877991494F, -0.4363323129985824F, 0.0F);
        this.BottomFin = new ModelRenderer(this, 0, 1);
        this.BottomFin.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.BottomFin.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 0, 9);
        this.Tail.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.Tail.addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Head.addChild(this.Body);
        this.Head.addChild(this.LeftFin);
        this.Head.addChild(this.Snout);
        this.Head.addChild(this.RightFin);
        this.Body.addChild(this.BottomFin);
        this.Body.addChild(this.Tail);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(GarEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float f = 1.0F;
        if (!entityIn.isInWater()) {
           f = 1.5F;
        }

        this.Body.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
        this.Tail.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
