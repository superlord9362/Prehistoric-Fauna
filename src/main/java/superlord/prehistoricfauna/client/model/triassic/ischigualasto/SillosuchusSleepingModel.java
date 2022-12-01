package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.SillosuchusEntity;

/**
 * SillosuchusSleepingModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SillosuchusSleepingModel extends EntityModel<SillosuchusEntity> {
    public ModelRenderer RightThigh;
    public ModelRenderer LeftThigh;
    public ModelRenderer Body;
    public ModelRenderer RightLeg;
    public ModelRenderer RightFoot;
    public ModelRenderer LeftLeg;
    public ModelRenderer LeftFoot;
    public ModelRenderer Neck;
    public ModelRenderer LeftArm;
    public ModelRenderer RightArm;
    public ModelRenderer Tail1;
    public ModelRenderer Head;
    public ModelRenderer Jaw;
    public ModelRenderer beak;
    public ModelRenderer Jaw2;
    public ModelRenderer throat;
    public ModelRenderer Tail2;

    public SillosuchusSleepingModel() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.Tail2 = new ModelRenderer(this, 3, 142);
        this.Tail2.setRotationPoint(0.0F, -1.0F, 37.0F);
        this.Tail2.addBox(-3.5F, -1.0F, -3.0F, 7.0F, 9.0F, 49.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.17802358037447025F, -0.35185837453889574F, 1.7453292129831807E-4F);
        this.LeftArm = new ModelRenderer(this, 113, 86);
        this.LeftArm.setRotationPoint(7.0F, 14.0F, -24.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -3.0F, 6.0F, 22.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftArm, -1.3089969389957472F, 0.03490658503988659F, -1.2217304763960306F);
        this.RightThigh = new ModelRenderer(this, 145, 80);
        this.RightThigh.setRotationPoint(-5.0F, 13.0F, 12.0F);
        this.RightThigh.addBox(-7.0F, -3.0F, -5.0F, 8.0F, 22.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightThigh, -2.2689280275926285F, 0.27366763203903305F, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 145, 116);
        this.LeftLeg.mirror = true;
        this.LeftLeg.setRotationPoint(3.0F, 15.0F, 6.3F);
        this.LeftLeg.addBox(-3.0F, -2.0F, -3.0F, 6.0F, 19.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftLeg, 2.356194490192345F, 0.0F, 0.0F);
        this.RightLeg = new ModelRenderer(this, 145, 116);
        this.RightLeg.setRotationPoint(-3.0F, 15.0F, 7.0F);
        this.RightLeg.addBox(-3.0F, -2.0F, -3.0F, 6.0F, 19.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightLeg, 2.3038346126325147F, 0.0F, 0.0F);
        this.Jaw2 = new ModelRenderer(this, 2, 40);
        this.Jaw2.setRotationPoint(0.0F, 0.0F, -12.0F);
        this.Jaw2.addBox(-3.5F, 0.0F, -8.0F, 7.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 1, 81);
        this.Tail1.setRotationPoint(0.0F, -5.0F, 15.0F);
        this.Tail1.addBox(-5.0F, -3.0F, -4.0F, 10.0F, 14.0F, 43.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.22689280275926282F, -0.3490658503988659F, 0.03490658503988659F);
        this.LeftFoot = new ModelRenderer(this, 178, 122);
        this.LeftFoot.setRotationPoint(0.0F, 14.0F, -1.0F);
        this.LeftFoot.addBox(-3.5F, -1.0F, -15.5F, 7.0F, 4.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftFoot, -0.12217304763960307F, 0.0F, 0.0F);
        this.LeftThigh = new ModelRenderer(this, 145, 80);
        this.LeftThigh.mirror = true;
        this.LeftThigh.setRotationPoint(5.9F, 11.2F, 12.0F);
        this.LeftThigh.addBox(-1.0F, -3.0F, -5.0F, 8.0F, 22.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftThigh, -2.234021442552742F, -0.3127630032889644F, 0.0F);
        this.RightArm = new ModelRenderer(this, 113, 86);
        this.RightArm.mirror = true;
        this.RightArm.setRotationPoint(-10.0F, 12.0F, -24.0F);
        this.RightArm.addBox(-5.0F, -2.0F, -3.0F, 6.0F, 22.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightArm, -1.2217304763960306F, 0.07749261978723364F, 1.0821041362364843F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 9.0F, 2.0F);
        this.Body.addBox(-8.5F, -10.0F, -37.0F, 17.0F, 25.0F, 55.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, 0.0F, 0.0F, -0.11728612207217244F);
        this.Jaw = new ModelRenderer(this, 90, 2);
        this.Jaw.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.Jaw.addBox(-4.5F, 0.0F, -12.0F, 9.0F, 2.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.throat = new ModelRenderer(this, 97, 21);
        this.throat.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.throat.addBox(-4.02F, 0.5F, -4.0F, 8.04F, 9.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(throat, -1.6533504590037724F, 0.0F, 0.0F);
        this.RightFoot = new ModelRenderer(this, 178, 122);
        this.RightFoot.mirror = true;
        this.RightFoot.setRotationPoint(0.0F, 12.2F, -1.0F);
        this.RightFoot.addBox(-3.5F, -1.0F, -15.5F, 7.0F, 4.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightFoot, -0.03490658503988659F, 0.0F, 0.0F);
        this.beak = new ModelRenderer(this, 2, 24);
        this.beak.setRotationPoint(0.0F, 2.0F, -12.0F);
        this.beak.addBox(-3.5F, -2.0F, -8.0F, 7.0F, 4.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 152, 18);
        this.Neck.setRotationPoint(-2.0F, 5.0F, -42.0F);
        this.Neck.addBox(-4.0F, -6.5F, -31.0F, 8.0F, 11.0F, 38.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.1319468904520859F, 0.5473352640780661F, 0.0F);
        this.Head = new ModelRenderer(this, 1, 2);
        this.Head.setRotationPoint(0.0F, -3.07F, -29.62F);
        this.Head.addBox(-4.5F, -2.0F, -12.0F, 9.0F, 6.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -0.09005898673974631F, 0.35185837453889574F, 0.0781907508222411F);
        this.Tail1.addChild(this.Tail2);
        this.Body.addChild(this.LeftArm);
        this.LeftThigh.addChild(this.LeftLeg);
        this.RightThigh.addChild(this.RightLeg);
        this.Jaw.addChild(this.Jaw2);
        this.Body.addChild(this.Tail1);
        this.LeftLeg.addChild(this.LeftFoot);
        this.Body.addChild(this.RightArm);
        this.Head.addChild(this.Jaw);
        this.Jaw.addChild(this.throat);
        this.RightLeg.addChild(this.RightFoot);
        this.Head.addChild(this.beak);
        this.Body.addChild(this.Neck);
        this.Neck.addChild(this.Head);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.RightThigh, this.LeftThigh, this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(SillosuchusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
