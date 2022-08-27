package superlord.prehistoricfauna.client.model.fish;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.fish.ChinleaEntity;

/**
 * ChinleaModel - superlord9362
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ChinleaModel extends EntityModel<ChinleaEntity> {
    public ModelRenderer Head;
    public ModelRenderer Body;
    public ModelRenderer Snout;
    public ModelRenderer FrontRightFin;
    public ModelRenderer FrontLeftFin;
    public ModelRenderer Tail;
    public ModelRenderer FrontTopFin;
    public ModelRenderer BackTopFin;
    public ModelRenderer FrontBottomLeftFin;
    public ModelRenderer BackBottomFin;
    public ModelRenderer FrontBottomRightFin;

    public ChinleaModel() {
        this.textureWidth = 22;
        this.textureHeight = 32;
        this.FrontBottomLeftFin = new ModelRenderer(this, 0, 4);
        this.FrontBottomLeftFin.setRotationPoint(-1.0F, 2.0F, 2.0F);
        this.FrontBottomLeftFin.addBox(0.0F, 0.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FrontBottomLeftFin, 0.0F, 0.0F, 0.17453292519943295F);
        this.Head = new ModelRenderer(this, 0, 12);
        this.Head.setRotationPoint(0.0F, 22.0F, -2.0F);
        this.Head.addBox(-1.5F, -2.0F, -5.0F, 3.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.BackBottomFin = new ModelRenderer(this, 0, 10);
        this.BackBottomFin.setRotationPoint(0.0F, 2.0F, 4.5F);
        this.BackBottomFin.addBox(0.0F, -0.2F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.FrontTopFin = new ModelRenderer(this, 0, 22);
        this.FrontTopFin.setRotationPoint(0.0F, -2.0F, 1.0F);
        this.FrontTopFin.addBox(0.0F, -2.0F, -2.0F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.BackTopFin = new ModelRenderer(this, 0, 25);
        this.BackTopFin.setRotationPoint(0.0F, -2.0F, 4.0F);
        this.BackTopFin.addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 14, 0);
        this.Snout.setRotationPoint(0.0F, 1.0F, -5.0F);
        this.Snout.addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.FrontBottomRightFin = new ModelRenderer(this, 0, 4);
        this.FrontBottomRightFin.setRotationPoint(1.0F, 2.0F, 2.0F);
        this.FrontBottomRightFin.addBox(0.0F, 0.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FrontBottomRightFin, 0.0F, 0.0F, -0.17453292519943295F);
        this.FrontLeftFin = new ModelRenderer(this, 0, -2);
        this.FrontLeftFin.setRotationPoint(-1.5F, 1.0F, -1.0F);
        this.FrontLeftFin.addBox(0.0F, 0.0F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FrontLeftFin, 0.0F, 0.0F, 0.4363323129985824F);
        this.Tail = new ModelRenderer(this, 6, 15);
        this.Tail.setRotationPoint(0.0F, -0.5F, 8.0F);
        this.Tail.addBox(0.0F, -3.5F, -2.0F, 0.0F, 8.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.FrontRightFin = new ModelRenderer(this, 0, -2);
        this.FrontRightFin.mirror = true;
        this.FrontRightFin.setRotationPoint(1.5F, 1.0F, -1.0F);
        this.FrontRightFin.addBox(0.0F, 0.0F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(FrontRightFin, 0.0F, 0.0F, -0.4363323129985824F);
        this.Body.addChild(this.FrontBottomLeftFin);
        this.Body.addChild(this.BackBottomFin);
        this.Head.addChild(this.Body);
        this.Body.addChild(this.FrontTopFin);
        this.Body.addChild(this.BackTopFin);
        this.Head.addChild(this.Snout);
        this.Body.addChild(this.FrontBottomRightFin);
        this.Head.addChild(this.FrontLeftFin);
        this.Body.addChild(this.Tail);
        this.Head.addChild(this.FrontRightFin);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Head).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(ChinleaEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float f = 1.0F;
        if (!entityIn.isInWater()) {
           f = 1.5F;
        }
        this.Head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.Head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
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
