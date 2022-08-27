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
 * CamarasaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class CamarasaurusSleepingModel extends EntityModel<CamarasaurusEntity> {
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

    public CamarasaurusSleepingModel() {
        this.textureWidth = 384;
        this.textureHeight = 384;
        this.LeftHindLeg2 = new ModelRenderer(this, 81, 207);
        this.LeftHindLeg2.setRotationPoint(-1.0F, 14.0F, 13.0F);
        this.LeftHindLeg2.addBox(-7.5F, 0.0F, -8.0F, 15.0F, 30.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftHindLeg2, -0.3019419472792136F, 0.0F, 0.0F);
        this.Neck2 = new ModelRenderer(this, 104, 300);
        this.Neck2.setRotationPoint(0.0F, -45.0F, 0.0F);
        this.Neck2.addBox(-6.0F, -47.0F, -14.0F, 12.0F, 54.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck2, 0.02775073568927633F, -0.1563815016444822F, 1.2510520131558576F);
        this.RightHindLeg3 = new ModelRenderer(this, 0, 223);
        this.RightHindLeg3.mirror = true;
        this.RightHindLeg3.setRotationPoint(0.0F, 30.0F, -4.0F);
        this.RightHindLeg3.addBox(-8.0F, 0.0F, -14.0F, 16.0F, 6.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightHindLeg3, 1.6432275173842723F, 0.0F, 0.0F);
        this.LeftFrontLeg = new ModelRenderer(this, 0, 139);
        this.LeftFrontLeg.setRotationPoint(28.5F, 11.0F, -28.0F);
        this.LeftFrontLeg.addBox(-7.5F, -10.0F, -7.5F, 15.0F, 61.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftFrontLeg, -1.1405726395466833F, -0.039269908169872414F, 0.3909537457888271F);
        this.Tail2 = new ModelRenderer(this, 213, 179);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 64.0F);
        this.Tail2.addBox(-7.0F, -3.0F, -5.0F, 14.0F, 15.0F, 65.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.4518657326886875F, 0.3909537457888271F, 0.19547687289441354F);
        this.LeftThumb = new ModelRenderer(this, 0, 221);
        this.LeftThumb.setRotationPoint(-7.5F, 49.0F, -4.5F);
        this.LeftThumb.addBox(-4.0F, -1.0F, -1.0F, 4.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LeftHindLeg3 = new ModelRenderer(this, 0, 223);
        this.LeftHindLeg3.setRotationPoint(0.0F, 31.0F, -5.0F);
        this.LeftHindLeg3.addBox(-8.0F, 0.0F, -14.0F, 16.0F, 6.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftHindLeg3, 1.3683381601951652F, 0.0F, 0.0F);
        this.LeftHindLeg1 = new ModelRenderer(this, 64, 135);
        this.LeftHindLeg1.setRotationPoint(24.0F, 0.0F, 26.0F);
        this.LeftHindLeg1.addBox(-8.5F, -13.0F, -12.0F, 17.0F, 45.0F, 24.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftHindLeg1, -1.0625564672562755F, -0.5082398928281348F, 0.0F);
        this.NeckAngle = new ModelRenderer(this, 0, 0);
        this.NeckAngle.setRotationPoint(0.0F, 10.0F, -49.0F);
        this.NeckAngle.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(NeckAngle, 0.27314400463445304F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 193, 72);
        this.Tail1.setRotationPoint(0.0F, -7.0F, 21.0F);
        this.Tail1.addBox(-12.0F, -7.0F, -7.0F, 24.0F, 25.0F, 71.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.24260075936930908F, 0.5864306020384839F, 0.3127630032889644F);
        this.Spikes = new ModelRenderer(this, 64, 0);
        this.Spikes.setRotationPoint(0.0F, -47.0F, 6.0F);
        this.Spikes.addBox(-1.0F, 0.0F, 0.0F, 1.0F, 20.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Neck1 = new ModelRenderer(this, 0, 300);
        this.Neck1.setRotationPoint(-6.2F, -8.0F, 0.0F);
        this.Neck1.addBox(-9.0F, -45.0F, -19.0F, 18.0F, 53.0F, 28.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck1, 0.9162978572970231F, -1.3294172592861477F, 0.11728612207217244F);
        this.Head2 = new ModelRenderer(this, 37, 39);
        this.Head2.setRotationPoint(1.0F, 8.0F, -15.0F);
        this.Head2.addBox(-5.0F, -8.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.RightHindLeg2 = new ModelRenderer(this, 81, 207);
        this.RightHindLeg2.setRotationPoint(1.0F, 13.0F, 11.0F);
        this.RightHindLeg2.addBox(-7.5F, 0.0F, -8.0F, 15.0F, 30.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightHindLeg2, -0.37646751432885467F, 0.1389282091245389F, 0.0F);
        this.RightHindLeg1 = new ModelRenderer(this, 64, 135);
        this.RightHindLeg1.mirror = true;
        this.RightHindLeg1.setRotationPoint(-24.0F, 4.0F, 21.0F);
        this.RightHindLeg1.addBox(-8.5F, -13.0F, -12.0F, 17.0F, 45.0F, 24.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightHindLeg1, -1.0534807471564218F, 0.3909537457888271F, 0.11728612207217244F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(1.0F, -47.1F, 0.0F);
        this.Head.addBox(-7.0F, 0.0F, -15.0F, 14.0F, 17.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -0.5269149104981519F, 0.03909537541112055F, 0.25621433951908973F);
        this.body = new ModelRenderer(this, 0, 2);
        this.body.setRotationPoint(0.0F, -4.8F, 14.0F);
        this.body.addBox(-25.0F, -20.2F, -54.0F, 50.0F, 50.0F, 80.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(body, 0.0F, -0.038920842652368684F, -0.1563815016444822F);
        this.Snout = new ModelRenderer(this, 0, 54);
        this.Snout.setRotationPoint(0.0F, 8.0F, -15.0F);
        this.Snout.addBox(-5.0F, 0.0F, -10.0F, 10.0F, 9.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.RightFrontLeg = new ModelRenderer(this, 0, 139);
        this.RightFrontLeg.mirror = true;
        this.RightFrontLeg.setRotationPoint(-21.5F, 10.0F, -28.0F);
        this.RightFrontLeg.addBox(-7.5F, -10.0F, -7.5F, 15.0F, 61.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightFrontLeg, -1.2189378856769737F, -0.43039819087864056F, 0.0F);
        this.RightThumb = new ModelRenderer(this, 0, 221);
        this.RightThumb.mirror = true;
        this.RightThumb.setRotationPoint(7.5F, 49.0F, -4.5F);
        this.RightThumb.addBox(0.0F, -1.0F, -1.0F, 4.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LeftHindLeg1.addChild(this.LeftHindLeg2);
        this.Neck1.addChild(this.Neck2);
        this.RightHindLeg2.addChild(this.RightHindLeg3);
        this.Tail1.addChild(this.Tail2);
        this.LeftFrontLeg.addChild(this.LeftThumb);
        this.LeftHindLeg2.addChild(this.LeftHindLeg3);
        this.body.addChild(this.NeckAngle);
        this.body.addChild(this.Tail1);
        this.Neck2.addChild(this.Spikes);
        this.NeckAngle.addChild(this.Neck1);
        this.Head.addChild(this.Head2);
        this.RightHindLeg1.addChild(this.RightHindLeg2);
        this.Neck2.addChild(this.Head);
        this.Head.addChild(this.Snout);
        this.RightFrontLeg.addChild(this.RightThumb);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.LeftFrontLeg, this.LeftHindLeg1, this.RightHindLeg1, this.body, this.RightFrontLeg).forEach((modelRenderer) -> { 
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
