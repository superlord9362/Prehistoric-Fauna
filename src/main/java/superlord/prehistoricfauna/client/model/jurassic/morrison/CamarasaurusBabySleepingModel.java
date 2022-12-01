package superlord.prehistoricfauna.client.model.jurassic.morrison;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.morrison.CamarasaurusEntity;

/**
 * Camarasaurus - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class CamarasaurusBabySleepingModel extends EntityModel<CamarasaurusEntity> {
    public ModelRenderer body;
    public ModelRenderer LeftFrontLeg;
    public ModelRenderer RightFrontLeg;
    public ModelRenderer RightHindLeg1;
    public ModelRenderer LeftHindLeg1;
    public ModelRenderer NeckAngle;
    public ModelRenderer Tail1;
    public ModelRenderer Neck1;
    public ModelRenderer Neck2;
    public ModelRenderer Head;
    public ModelRenderer Spikes;
    public ModelRenderer Head2;
    public ModelRenderer Snout;
    public ModelRenderer Tail2;
    public ModelRenderer LeftThumb;
    public ModelRenderer RightThumb;
    public ModelRenderer RightHindLeg2;
    public ModelRenderer RightHindLeg3;
    public ModelRenderer LeftHindLeg2;
    public ModelRenderer LeftHindLeg3;

    public CamarasaurusBabySleepingModel() {
        this.textureWidth = 384;
        this.textureHeight = 384;
        this.LeftHindLeg1 = new ModelRenderer(this, 46, 95);
        this.LeftHindLeg1.setRotationPoint(16.5F, 9.0F, 17.0F);
        this.LeftHindLeg1.addBox(-6.0F, -9.0F, -8.0F, 11.0F, 31.0F, 17.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftHindLeg1, -1.9198621771937625F, -0.3839724354387525F, 0.0F);
        this.RightHindLeg3 = new ModelRenderer(this, 0, 156);
        this.RightHindLeg3.mirror = true;
        this.RightHindLeg3.setRotationPoint(0.0F, 17.0F, 1.0F);
        this.RightHindLeg3.addBox(-5.5F, 0.0F, -9.0F, 11.0F, 4.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightHindLeg3, 0.3490658503988659F, 0.0F, 0.0F);
        this.RightFrontLeg = new ModelRenderer(this, 0, 98);
        this.RightFrontLeg.mirror = true;
        this.RightFrontLeg.setRotationPoint(-16.5F, 13.0F, -20.0F);
        this.RightFrontLeg.addBox(-5.0F, -6.0F, -5.0F, 10.0F, 42.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightFrontLeg, -1.2189378856769737F, -0.43039819087864056F, 0.0F);
        this.NeckAngle = new ModelRenderer(this, 0, 0);
        this.NeckAngle.setRotationPoint(0.0F, 10.0F, -49.0F);
        this.NeckAngle.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(NeckAngle, 0.27314400463445304F, 0.0F, 0.0F);
        this.LeftFrontLeg = new ModelRenderer(this, 0, 98);
        this.LeftFrontLeg.setRotationPoint(18.5F, 14.0F, -20.0F);
        this.LeftFrontLeg.addBox(-5.0F, -6.0F, -5.0F, 10.0F, 42.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftFrontLeg, -1.1405726395466833F, -0.039269908169872414F, 0.3909537457888271F);
        this.RightHindLeg1 = new ModelRenderer(this, 46, 95);
        this.RightHindLeg1.mirror = true;
        this.RightHindLeg1.setRotationPoint(-16.5F, 9.0F, 17.0F);
        this.RightHindLeg1.addBox(-6.0F, -9.0F, -8.0F, 11.0F, 31.0F, 17.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightHindLeg1, -1.9198621771937625F, 0.3839724354387525F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 136, 51);
        this.Tail1.setRotationPoint(0.0F, -10.0F, 2.5F);
        this.Tail1.addBox(-7.5F, -7.0F, -7.0F, 16.0F, 18.0F, 49.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.24260075936930908F, 0.5864306020384839F, 0.3127630032889644F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, -34.0F, -2.0F);
        this.Head.addBox(-4.5F, 0.0F, -11.0F, 9.0F, 12.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -0.5269149104981519F, 0.03909537541112055F, 0.25621433951908973F);
        this.LeftHindLeg3 = new ModelRenderer(this, 0, 156);
        this.LeftHindLeg3.setRotationPoint(0.0F, 17.0F, 1.0F);
        this.LeftHindLeg3.addBox(-5.5F, 0.0F, -9.0F, 11.0F, 4.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftHindLeg3, 0.3490658503988659F, 0.0F, 0.0F);
        this.Spikes = new ModelRenderer(this, 43, 0);
        this.Spikes.setRotationPoint(0.0F, -34.0F, 4.0F);
        this.Spikes.addBox(0.0F, 0.0F, 0.0F, 0.0F, 20.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.LeftHindLeg2 = new ModelRenderer(this, 57, 145);
        this.LeftHindLeg2.setRotationPoint(-0.5F, 17.2F, 1.0F);
        this.LeftHindLeg2.addBox(-5.0F, 0.0F, -5.0F, 10.0F, 20.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftHindLeg2, 1.5707963267948966F, 0.0F, 0.0F);
        this.RightHindLeg2 = new ModelRenderer(this, 57, 145);
        this.RightHindLeg2.mirror = true;
        this.RightHindLeg2.setRotationPoint(-0.5F, 17.1F, 1.0F);
        this.RightHindLeg2.addBox(-5.0F, 0.0F, -5.0F, 10.0F, 20.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightHindLeg2, 1.5707963267948966F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 149, 125);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 43.0F);
        this.Tail2.addBox(-4.5F, -3.0F, -5.0F, 9.0F, 10.0F, 46.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.4518657326886875F, 0.3909537457888271F, 0.19547687289441354F);
        this.Neck1 = new ModelRenderer(this, 4, 214);
        this.Neck1.setRotationPoint(-6.0F, -10.0F, 3.0F);
        this.Neck1.addBox(-6.0F, -33.0F, -12.0F, 12.0F, 37.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck1, 0.9162978572970231F, -1.3294172592861477F, 0.11728612207217244F);
        this.RightThumb = new ModelRenderer(this, 0, 155);
        this.RightThumb.mirror = true;
        this.RightThumb.setRotationPoint(5.0F, 35.0F, -2.0F);
        this.RightThumb.addBox(0.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Head2 = new ModelRenderer(this, 27, 28);
        this.Head2.setRotationPoint(0.0F, 6.0F, -11.0F);
        this.Head2.addBox(-2.5F, -6.0F, -5.0F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.LeftThumb = new ModelRenderer(this, 0, 155);
        this.LeftThumb.setRotationPoint(-5.0F, 35.0F, -2.0F);
        this.LeftThumb.addBox(-3.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 38);
        this.Snout.setRotationPoint(0.0F, 6.0F, -11.0F);
        this.Snout.addBox(-3.5F, 0.0F, -7.0F, 7.0F, 6.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 2);
        this.body.setRotationPoint(0.0F, 10.0F, 26.0F);
        this.body.addBox(-17.5F, -20.0F, -54.0F, 35.0F, 34.0F, 56.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(body, 0.0F, -0.038920842652368684F, -0.1563815016444822F);
        this.Neck2 = new ModelRenderer(this, 73, 210);
        this.Neck2.setRotationPoint(0.0F, -35.0F, -1.0F);
        this.Neck2.addBox(-4.0F, -34.0F, -10.0F, 8.0F, 37.9F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck2, 0.02775073568927633F, -0.1563815016444822F, 1.2510520131558576F);
        this.RightHindLeg2.addChild(this.RightHindLeg3);
        this.body.addChild(this.NeckAngle);
        this.body.addChild(this.Tail1);
        this.Neck2.addChild(this.Head);
        this.LeftHindLeg2.addChild(this.LeftHindLeg3);
        this.Neck2.addChild(this.Spikes);
        this.LeftHindLeg1.addChild(this.LeftHindLeg2);
        this.RightHindLeg1.addChild(this.RightHindLeg2);
        this.Tail1.addChild(this.Tail2);
        this.NeckAngle.addChild(this.Neck1);
        this.RightFrontLeg.addChild(this.RightThumb);
        this.Head.addChild(this.Head2);
        this.LeftFrontLeg.addChild(this.LeftThumb);
        this.Head.addChild(this.Snout);
        this.Neck1.addChild(this.Neck2);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.LeftHindLeg1, this.RightFrontLeg, this.LeftFrontLeg, this.RightHindLeg1, this.body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(CamarasaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
