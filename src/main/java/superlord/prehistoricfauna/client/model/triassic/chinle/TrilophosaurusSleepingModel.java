package superlord.prehistoricfauna.client.model.triassic.chinle;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.chinle.TrilophosaurusEntity;

/**
 * Trilophosaurus - Crimes
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class TrilophosaurusSleepingModel extends EntityModel<TrilophosaurusEntity> {
    public ModelRenderer Body;
    public ModelRenderer LeftArm;
    public ModelRenderer RightArm;
    public ModelRenderer LeftLeg;
    public ModelRenderer RightLeg;
    public ModelRenderer Neck;
    public ModelRenderer TailBase;
    public ModelRenderer Head;
    public ModelRenderer Snoot;
    public ModelRenderer TailEnd;
    public ModelRenderer LeftHand;
    public ModelRenderer RightHand;
    public ModelRenderer LeftFoot;
    public ModelRenderer RightFoot;

    public TrilophosaurusSleepingModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Neck = new ModelRenderer(this, 10, 0);
        this.Neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Neck.addBox(-1.0F, -5.0F, -4.0F, 2.0F, 7.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.7037167490777915F, -0.46914448828868976F, 0.0F);
        this.LeftFoot = new ModelRenderer(this, 52, 16);
        this.LeftFoot.setRotationPoint(1.0F, 4.01F, -2.0F);
        this.LeftFoot.addBox(-1.5F, 0.0F, -2.5F, 3.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftFoot, -0.11728612207217244F, 0.03909537541112055F, 1.2510520131558576F);
        this.LeftHand = new ModelRenderer(this, 53, 27);
        this.LeftHand.setRotationPoint(1.0F, 3.01F, -1.0F);
        this.LeftHand.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftHand, 0.0F, 0.0F, 1.3688617376654748F);
        this.RightHand = new ModelRenderer(this, 53, 27);
        this.RightHand.mirror = true;
        this.RightHand.setRotationPoint(-1.0F, 3.01F, -1.0F);
        this.RightHand.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightHand, 0.0F, 0.0F, -1.3683381601951652F);
        this.Body = new ModelRenderer(this, 14, 0);
        this.Body.setRotationPoint(0.0F, 21.0F, -4.0F);
        this.Body.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 0, 10);
        this.LeftArm.setRotationPoint(3.0F, 23.89F, -4.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -1.5F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftArm, -0.46914448828868976F, 0.1563815016444822F, -1.3683381601951652F);
        this.TailBase = new ModelRenderer(this, 38, 0);
        this.TailBase.setRotationPoint(0.0F, 0.2F, 11.0F);
        this.TailBase.addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(TailBase, -0.11728612207217244F, 0.46914448828868976F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 5);
        this.Head.setRotationPoint(0.0F, -2.9F, -3.0F);
        this.Head.addBox(-1.5F, -2.0F, -2.0F, 3.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 0, 18);
        this.LeftLeg.setRotationPoint(3.0F, 22.99F, 6.5F);
        this.LeftLeg.addBox(-1.0F, -2.0F, -1.5F, 2.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg, 0.35185837453889574F, 0.0F, -1.1728612040769677F);
        this.TailEnd = new ModelRenderer(this, 12, 19);
        this.TailEnd.setRotationPoint(0.0F, -0.01F, 9.3F);
        this.TailEnd.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 24.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(TailEnd, 0.0781907508222411F, 0.3909537457888271F, 0.0F);
        this.Snoot = new ModelRenderer(this, 0, 0);
        this.Snoot.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.Snoot.addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg = new ModelRenderer(this, 0, 18);
        this.RightLeg.mirror = true;
        this.RightLeg.setRotationPoint(-3.0F, 22.99F, 6.5F);
        this.RightLeg.addBox(-1.0F, -2.0F, -1.5F, 2.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg, 0.35185837453889574F, 0.0F, 1.1728612040769677F);
        this.RightArm = new ModelRenderer(this, 0, 10);
        this.RightArm.mirror = true;
        this.RightArm.setRotationPoint(-3.0F, 23.99F, -4.0F);
        this.RightArm.addBox(-1.0F, -2.0F, -1.5F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightArm, -0.46914448828868976F, -0.1563815016444822F, 1.3683381601951652F);
        this.RightFoot = new ModelRenderer(this, 52, 16);
        this.RightFoot.mirror = true;
        this.RightFoot.setRotationPoint(-1.0F, 4.01F, -2.0F);
        this.RightFoot.addBox(-1.5F, 0.0F, -2.5F, 3.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightFoot, -0.11728612207217244F, 0.03909537541112055F, -1.2510520131558576F);
        this.Body.addChild(this.Neck);
        this.LeftLeg.addChild(this.LeftFoot);
        this.LeftArm.addChild(this.LeftHand);
        this.RightArm.addChild(this.RightHand);
        this.Body.addChild(this.TailBase);
        this.Neck.addChild(this.Head);
        this.TailBase.addChild(this.TailEnd);
        this.Head.addChild(this.Snoot);
        this.RightLeg.addChild(this.RightFoot);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body, this.LeftArm, this.LeftLeg, this.RightLeg, this.RightArm).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(TrilophosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
