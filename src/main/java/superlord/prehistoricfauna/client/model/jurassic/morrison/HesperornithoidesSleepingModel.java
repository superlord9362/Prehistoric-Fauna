package superlord.prehistoricfauna.client.model.jurassic.morrison;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.HesperornithoidesEntity;

/**
 * HesperornithoidesModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class HesperornithoidesSleepingModel extends EntityModel<HesperornithoidesEntity> {
    public ModelRenderer Body;
    public ModelRenderer LeftWing;
    public ModelRenderer RightWing;
    public ModelRenderer RightLeg;
    public ModelRenderer Head;
    public ModelRenderer LeftLeg;
    public ModelRenderer Tail;
    public ModelRenderer Fluff;
    public ModelRenderer Snoot;

    public HesperornithoidesSleepingModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.LeftLeg = new ModelRenderer(this, 17, 16);
        this.LeftLeg.setRotationPoint(0.25F, 0.0F, 4.0F);
        this.LeftLeg.addBox(0.0F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg, -0.1459095194746135F, 0.0F, 0.0F);
        this.LeftWing = new ModelRenderer(this, 13, 5);
        this.LeftWing.setRotationPoint(1.5F, 0.3F, 1.0F);
        this.LeftWing.addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftWing, -0.33004175888896664F, -0.21537363235926135F, 0.0F);
        this.Head = new ModelRenderer(this, 1, 17);
        this.Head.setRotationPoint(0.0F, 2.4F, 0.0F);
        this.Head.addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.010000229F, 0.00999999F);
        this.setRotateAngle(Head, -0.182212366584515F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 19, 5);
        this.Tail.setRotationPoint(0.0F, 0.6F, 5.0F);
        this.Tail.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.21938788164936507F, -0.1096066806870904F, -0.07295475973730675F);
        this.Snoot = new ModelRenderer(this, 1, 24);
        this.Snoot.setRotationPoint(0.0F, -4.0F, -1.0F);
        this.Snoot.addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 1, 8);
        this.Body.setRotationPoint(0.0F, 20.8F, -2.5F);
        this.Body.addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, 0.07278023113974408F, 0.0F, 0.0F);
        this.RightWing = new ModelRenderer(this, 13, 5);
        this.RightWing.mirror = true;
        this.RightWing.setRotationPoint(-1.5F, 0.3F, 1.0F);
        this.RightWing.addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightWing, -0.2553416715641412F, 0.18238690350445608F, 0.0F);
        this.RightLeg = new ModelRenderer(this, 17, 16);
        this.RightLeg.mirror = true;
        this.RightLeg.setRotationPoint(-0.25F, 0.0F, 4.0F);
        this.RightLeg.addBox(-1.0F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg, -0.10943214376714933F, 0.0F, 0.0F);
        this.Fluff = new ModelRenderer(this, 10, 18);
        this.Fluff.setRotationPoint(0.0F, -4.5F, -0.1F);
        this.Fluff.addBox(-0.5F, -2.0F, 0.0F, 1.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Fluff, -1.058367647756717F, 0.0F, 0.0F);
        this.Body.addChild(this.LeftLeg);
        this.Body.addChild(this.LeftWing);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.Tail);
        this.Head.addChild(this.Snoot);
        this.Body.addChild(this.RightWing);
        this.Body.addChild(this.RightLeg);
        this.Head.addChild(this.Fluff);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(HesperornithoidesEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
