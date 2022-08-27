package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.ChromogisaurusEntity;

/**
 * ChromogisaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ChromogisaurusSleepingModel extends EntityModel<ChromogisaurusEntity> {
    public ModelRenderer RightThigh;
    public ModelRenderer LeftThigh;
    public ModelRenderer Body;
    public ModelRenderer LeftLeg_1;
    public ModelRenderer LeftLeg;
    public ModelRenderer RightArm;
    public ModelRenderer LeftArm;
    public ModelRenderer Neck;
    public ModelRenderer Tail;
    public ModelRenderer Head;

    public ChromogisaurusSleepingModel() {
        this.textureWidth = 80;
        this.textureHeight = 64;
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 22.0F, 2.0F);
        this.Body.addBox(-1.5F, -2.0F, -8.0F, 3.0F, 4.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, 0.0F, 0.0F, -0.19547687289441354F);
        this.LeftLeg_1 = new ModelRenderer(this, 63, -4);
        this.LeftLeg_1.setRotationPoint(-0.5F, 3.6F, 0.9F);
        this.LeftLeg_1.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg_1, 0.07836527941980377F, 0.0F, 0.009250244536227243F);
        this.RightArm = new ModelRenderer(this, 12, 18);
        this.RightArm.setRotationPoint(-2.3F, 0.9F, -5.0F);
        this.RightArm.addBox(-0.5F, -1.0F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightArm, -1.6030848913251807F, -0.036477379868653376F, 0.6003932893176602F);
        this.RightThigh = new ModelRenderer(this, 39, 0);
        this.RightThigh.setRotationPoint(-1.0F, 23.0F, 5.0F);
        this.RightThigh.addBox(-1.5F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightThigh, -1.6041321794238546F, 0.35185837453889574F, 0.0F);
        this.LeftThigh = new ModelRenderer(this, 30, 0);
        this.LeftThigh.setRotationPoint(1.0F, 23.0F, 5.0F);
        this.LeftThigh.addBox(-0.5F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftThigh, -1.5653858487242918F, -0.3127630032889644F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 28);
        this.Head.setRotationPoint(0.0F, -3.0F, -1.0F);
        this.Head.addBox(-1.5F, -2.0F, -3.0F, 2.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 63, -4);
        this.LeftLeg.setRotationPoint(0.5F, 3.6F, 0.9F);
        this.LeftLeg.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg, 0.0F, 0.0F, -0.15620696472454113F);
        this.LeftArm = new ModelRenderer(this, 12, 18);
        this.LeftArm.setRotationPoint(1.9F, 1.4F, -5.1F);
        this.LeftArm.addBox(-0.5F, -1.0F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftArm, -1.486671462175092F, 0.002617993982021224F, -0.24015730906916136F);
        this.Neck = new ModelRenderer(this, 0, 18);
        this.Neck.setRotationPoint(0.5F, -1.0F, -7.1F);
        this.Neck.addBox(-1.5F, -3.0F, -2.0F, 2.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.23177972000431504F, -0.39357173300891585F, 0.37262780195869205F);
        this.Tail = new ModelRenderer(this, 31, 3);
        this.Tail.setRotationPoint(0.0F, -0.4F, 4.0F);
        this.Tail.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.1563815016444822F, 0.3127630032889644F, 0.11903145798206952F);
        this.RightThigh.addChild(this.LeftLeg_1);
        this.Body.addChild(this.RightArm);
        this.Neck.addChild(this.Head);
        this.LeftThigh.addChild(this.LeftLeg);
        this.Body.addChild(this.LeftArm);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.Tail);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body, this.RightThigh, this.LeftThigh).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(ChromogisaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
