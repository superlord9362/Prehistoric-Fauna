package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HerrerasaurusEntity;

/**
 * HerrerasaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class HerrerasaurusSleepingModel extends EntityModel<HerrerasaurusEntity> {
    public ModelRenderer Body;
    public ModelRenderer RThigh;
    public ModelRenderer LThigh;
    public ModelRenderer Tail1;
    public ModelRenderer LArm;
    public ModelRenderer RArm;
    public ModelRenderer Neck;
    public ModelRenderer BodySpikes;
    public ModelRenderer Tail2;
    public ModelRenderer Tail1Spikes;
    public ModelRenderer Tail2Spikes;
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer RLeg;
    public ModelRenderer LLeg;

    public HerrerasaurusSleepingModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.Tail1 = new ModelRenderer(this, 56, 0);
        this.Tail1.setRotationPoint(0.0F, 4.0F, 22.0F);
        this.Tail1.addBox(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, 0.06981317007977318F, -0.593411945678072F, -0.03490658503988659F);
        this.LThigh = new ModelRenderer(this, 100, 0);
        this.LThigh.mirror = true;
        this.LThigh.setRotationPoint(-3.0F, 14.8F, 1.0F);
        this.LThigh.addBox(-1.0F, -2.0F, -3.5F, 3.0F, 12.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LThigh, -0.8726646259971648F, 0.296705972839036F, 0.0F);
        this.RThigh = new ModelRenderer(this, 100, 0);
        this.RThigh.setRotationPoint(3.0F, 14.8F, 1.5F);
        this.RThigh.addBox(-2.0F, -2.0F, -3.5F, 3.0F, 12.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RThigh, -0.8726646259971648F, -0.296705972839036F, 0.0F);
        this.LArm = new ModelRenderer(this, 82, 0);
        this.LArm.mirror = true;
        this.LArm.setRotationPoint(-2.0F, 8.0F, 3.0F);
        this.LArm.addBox(-2.0F, -2.0F, -1.0F, 2.0F, 11.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LArm, 0.8726646259971648F, 0.0F, 0.0F);
        this.BodySpikes = new ModelRenderer(this, 0, 36);
        this.BodySpikes.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BodySpikes.addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2Spikes = new ModelRenderer(this, 0, 35);
        this.Tail2Spikes.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Tail2Spikes.addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 52, 0);
        this.Head.setRotationPoint(0.0F, -6.0F, -5.0F);
        this.Head.addBox(-2.0F, -2.0F, -3.0F, 4.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 0, 32);
        this.Snout.setRotationPoint(0.0F, 0.0F, -3.0F);
        this.Snout.addBox(-1.5F, -2.0F, -5.0F, 3.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.RLeg = new ModelRenderer(this, 10, 0);
        this.RLeg.setRotationPoint(0.0F, 10.0F, 3.5F);
        this.RLeg.addBox(-2.0F, 0.0F, 0.0F, 3.0F, 13.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RLeg, -0.6981317007977318F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 7.0F, -15.0F);
        this.Body.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 10.0F, 22.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, -0.3490658503988659F, 0.0F, 0.0F);
        this.Tail1Spikes = new ModelRenderer(this, 0, 39);
        this.Tail1Spikes.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.Tail1Spikes.addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.RArm = new ModelRenderer(this, 82, 0);
        this.RArm.setRotationPoint(2.0F, 8.0F, 3.0F);
        this.RArm.addBox(0.0F, -2.0F, -1.0F, 2.0F, 11.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RArm, 0.8726646259971648F, 0.0F, -0.0F);
        this.Tail2 = new ModelRenderer(this, 0, 32);
        this.Tail2.setRotationPoint(0.0F, -1.0F, 18.0F);
        this.Tail2.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 21.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.13962634015954636F, -0.593411945678072F, -0.10471975511965977F);
        this.Neck = new ModelRenderer(this, 34, 0);
        this.Neck.setRotationPoint(-0.3F, 2.5F, 0.0F);
        this.Neck.addBox(-2.0F, -8.0F, -5.0F, 4.0F, 10.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck, 0.5585053606381855F, 2.3387411976724017F, 0.03490658503988659F);
        this.LLeg = new ModelRenderer(this, 10, 0);
        this.LLeg.mirror = true;
        this.LLeg.setRotationPoint(-1.0F, 10.0F, 3.5F);
        this.LLeg.addBox(0.0F, 0.0F, 0.0F, 3.0F, 13.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LLeg, -0.6981317007977318F, 0.0F, 0.0F);
        this.Body.addChild(this.Tail1);
        this.Body.addChild(this.LArm);
        this.Body.addChild(this.BodySpikes);
        this.Tail2.addChild(this.Tail2Spikes);
        this.Neck.addChild(this.Head);
        this.Head.addChild(this.Snout);
        this.RThigh.addChild(this.RLeg);
        this.Tail1.addChild(this.Tail1Spikes);
        this.Body.addChild(this.RArm);
        this.Tail1.addChild(this.Tail2);
        this.Body.addChild(this.Neck);
        this.LThigh.addChild(this.LLeg);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.LThigh, this.RThigh, this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(HerrerasaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
