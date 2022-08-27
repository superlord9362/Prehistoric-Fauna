package superlord.prehistoricfauna.client.model.triassic.chinle;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.chinle.CoelophysisEntity;

/**
 * Coelophysis - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class CoelophysisSleepingModel extends EntityModel<CoelophysisEntity> {
    public ModelRenderer Body;
    public ModelRenderer Tail1;
    public ModelRenderer LArm;
    public ModelRenderer RArm;
    public ModelRenderer Neck;
    public ModelRenderer RThigh;
    public ModelRenderer LThigh;
    public ModelRenderer Tail2;
    public ModelRenderer Head;
    public ModelRenderer RLeg;
    public ModelRenderer LLeg;

    public CoelophysisSleepingModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Tail1 = new ModelRenderer(this, 55, 0);
        this.Tail1.setRotationPoint(0.0F, 1.6F, 14.0F);
        this.Tail1.addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.23457224414434488F, 0.5864306020384839F, 0.0F);
        this.Neck = new ModelRenderer(this, 34, 0);
        this.Neck.setRotationPoint(0.0F, 2.0F, 0.5F);
        this.Neck.addBox(-1.0F, -8.0F, -2.0F, 2.0F, 9.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.6646214111173737F, -2.3848178792724077F, 0.0F);
        this.LArm = new ModelRenderer(this, 82, 0);
        this.LArm.mirror = true;
        this.LArm.setRotationPoint(-1.0F, 4.0F, 3.0F);
        this.LArm.addBox(-1.0F, -1.0F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LArm, 0.0F, 0.0F, 1.3292428222347474F);
        this.Tail2 = new ModelRenderer(this, 0, 31);
        this.Tail2.setRotationPoint(0.0F, -0.4F, 6.4F);
        this.Tail2.addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 24.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.11728612207217244F, 0.7037167490777915F, 0.0F);
        this.Head = new ModelRenderer(this, 41, 13);
        this.Head.setRotationPoint(0.0F, -6.0F, -2.0F);
        this.Head.addBox(-1.0F, -2.0F, -6.0F, 2.0F, 2.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 19.0F, -8.0F);
        this.Body.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.LThigh = new ModelRenderer(this, 100, 0);
        this.LThigh.mirror = true;
        this.LThigh.setRotationPoint(-1.0F, 2.5F, 11.0F);
        this.LThigh.addBox(-1.5F, -1.5F, -2.0F, 2.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LThigh, -1.1728612040769677F, 0.46914448828868976F, 0.0F);
        this.RLeg = new ModelRenderer(this, 0, 0);
        this.RLeg.setRotationPoint(0.5F, 4.5F, 2.0F);
        this.RLeg.addBox(-1.0F, -7.1F, -3.0F, 2.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RLeg, 1.1728612040769677F, -0.11728612207217244F, -0.27366763203903305F);
        this.LLeg = new ModelRenderer(this, 0, 0);
        this.LLeg.mirror = true;
        this.LLeg.setRotationPoint(-0.5F, 4.5F, 2.0F);
        this.LLeg.addBox(-1.0F, -7.1F, -3.0F, 2.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LLeg, 1.1728612040769677F, -0.11728612207217244F, -0.27366763203903305F);
        this.RArm = new ModelRenderer(this, 82, 0);
        this.RArm.setRotationPoint(1.0F, 4.0F, 3.0F);
        this.RArm.addBox(0.0F, -1.0F, -1.0F, 1.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RArm, 0.0F, 0.0F, -1.3302899771753667F);
        this.RThigh = new ModelRenderer(this, 100, 0);
        this.RThigh.setRotationPoint(1.0F, 2.5F, 11.0F);
        this.RThigh.addBox(-0.5F, -1.5F, -2.0F, 2.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RThigh, -1.1728612040769677F, -0.46914448828868976F, 0.0F);
        this.Body.addChild(this.Tail1);
        this.Body.addChild(this.Neck);
        this.Body.addChild(this.LArm);
        this.Tail1.addChild(this.Tail2);
        this.Neck.addChild(this.Head);
        this.Body.addChild(this.LThigh);
        this.RThigh.addChild(this.RLeg);
        this.LThigh.addChild(this.LLeg);
        this.Body.addChild(this.RArm);
        this.Body.addChild(this.RThigh);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(CoelophysisEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
