package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ExaeretodonEntity;

/**
 * ExaeretodonModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ExaeretodonSleepingModel extends EntityModel<ExaeretodonEntity> {
    public ModelRenderer Body;
    public ModelRenderer LeftBackLeg;
    public ModelRenderer LeftFrontLeg;
    public ModelRenderer Head;
    public ModelRenderer RightFrontLeg;
    public ModelRenderer RightBackLeg;
    public ModelRenderer Tail;
    public ModelRenderer Snoot;

    public ExaeretodonSleepingModel() {
        this.textureWidth = 48;
        this.textureHeight = 48;
        this.RightBackLeg = new ModelRenderer(this, 28, 0);
        this.RightBackLeg.mirror = true;
        this.RightBackLeg.setRotationPoint(-3.0F, -1.5F, 8.5F);
        this.RightBackLeg.addBox(-3.0F, -1.5F, -1.51F, 3.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightBackLeg, 1.6816247076649256F, -0.40125119103875473F, 0.0F);
        this.Tail = new ModelRenderer(this, 16, 22);
        this.Tail.setRotationPoint(0.0F, -5.0F, 9.1F);
        this.Tail.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.07295475973730675F, 0.36477380700891215F, 0.01902408942930468F);
        this.Head = new ModelRenderer(this, 0, 18);
        this.Head.setRotationPoint(0.0F, -2.6F, 0.0F);
        this.Head.addBox(-2.5F, -3.0F, -6.0F, 5.0F, 4.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, 0.3284709598990106F, -0.40194933871851896F, -0.291819038949227F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 23.6F, -4.0F);
        this.Body.addBox(-4.0F, -6.0F, -2.0F, 8.0F, 6.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, -0.1459095194746135F, 0.0F, 0.0F);
        this.RightFrontLeg = new ModelRenderer(this, 30, 18);
        this.RightFrontLeg.mirror = true;
        this.RightFrontLeg.setRotationPoint(-2.6F, -0.1F, -0.6F);
        this.RightFrontLeg.addBox(-3.0F, -1.5F, -1.51F, 3.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightFrontLeg, -1.314407417066352F, -1.1299261204568736F, -0.2556907287592666F);
        this.Snoot = new ModelRenderer(this, 0, 28);
        this.Snoot.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.Snoot.addBox(-1.5F, -3.0F, -4.0F, 3.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.LeftBackLeg = new ModelRenderer(this, 28, 0);
        this.LeftBackLeg.setRotationPoint(3.0F, -1.5F, 8.5F);
        this.LeftBackLeg.addBox(0.0F, -1.5F, -1.51F, 3.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftBackLeg, 1.605702911834783F, 0.291819038949227F, 0.0F);
        this.LeftFrontLeg = new ModelRenderer(this, 30, 18);
        this.LeftFrontLeg.setRotationPoint(3.0F, -0.5F, -0.5F);
        this.LeftFrontLeg.addBox(0.0F, -1.5F, -1.51F, 3.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftFrontLeg, -0.8030259595478191F, 1.1311478456069475F, 0.6201154619282966F);
        this.Body.addChild(this.RightBackLeg);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.RightFrontLeg);
        this.Head.addChild(this.Snoot);
        this.Body.addChild(this.LeftBackLeg);
        this.Body.addChild(this.LeftFrontLeg);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(ExaeretodonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
