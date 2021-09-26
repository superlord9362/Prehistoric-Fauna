package superlord.prehistoricfauna.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.CyclurusEntity;

/**
 * Cyclurus - superlord9362
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class CyclurusModel extends EntityModel<CyclurusEntity> {
    public ModelRenderer Head;
    public ModelRenderer Body;
    public ModelRenderer LFin;
    public ModelRenderer RFin;
    public ModelRenderer Bowfin;
    public ModelRenderer Underfin;
    public ModelRenderer Tail;

    public CyclurusModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.LFin = new ModelRenderer(this, 10, 0);
        this.LFin.mirror = true;
        this.LFin.setRotationPoint(0.0F, 2.0F, 4.0F);
        this.LFin.addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LFin, 0.0F, 0.0F, 0.7853981633974483F);
        this.Tail = new ModelRenderer(this, 0, 14);
        this.Tail.setRotationPoint(0.0F, 0.0F, 6.0F);
        this.Tail.addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.RFin = new ModelRenderer(this, 10, 0);
        this.RFin.setRotationPoint(2.0F, 2.0F, 4.0F);
        this.RFin.addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RFin, 0.0F, 0.0F, -0.7853981633974483F);
        this.Bowfin = new ModelRenderer(this, 16, 0);
        this.Bowfin.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Bowfin.addBox(0.0F, -3.5F, -1.0F, 0.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(-1.0F, 21.0F, -8.0F);
        this.Head.addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 9);
        this.Body.setRotationPoint(1.0F, 1.5F, 6.0F);
        this.Body.addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Underfin = new ModelRenderer(this, 0, 0);
        this.Underfin.setRotationPoint(0.0F, 1.5F, 3.0F);
        this.Underfin.addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.Head.addChild(this.LFin);
        this.Body.addChild(this.Tail);
        this.Head.addChild(this.RFin);
        this.Body.addChild(this.Bowfin);
        this.Head.addChild(this.Body);
        this.Body.addChild(this.Underfin);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(CyclurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float f = 1.0F;
        if (!entityIn.isInWater()) {
           f = 1.5F;
        }

        this.Tail.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
        this.Body.rotateAngleY = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
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
