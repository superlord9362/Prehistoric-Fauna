package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.SarahsaurusEntity;

/**
 * SarahsaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SarahsaurusSleepingModel extends EntityModel<SarahsaurusEntity> {
	public ModelRenderer Body;
    public ModelRenderer Tail1;
    public ModelRenderer Neck1;
    public ModelRenderer LLeg1;
    public ModelRenderer RLeg1;
    public ModelRenderer LArm;
    public ModelRenderer RArm;
    public ModelRenderer Tail2;
    public ModelRenderer Neck2;
    public ModelRenderer Head;
    public ModelRenderer LLeg2;
    public ModelRenderer LFoot;
    public ModelRenderer RLeg2;
    public ModelRenderer RFoot;

    public SarahsaurusSleepingModel() {
        this.textureWidth = 64;
        this.textureHeight = 80;
        this.RArm = new ModelRenderer(this, 22, 52);
        this.RArm.setRotationPoint(-3.0F, 6.0F, -8.5F);
        this.RArm.addBox(-2.0F, -1.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RArm, -0.23457224414434488F, 0.0F, 0.8210028961170991F);
        this.Head = new ModelRenderer(this, 0, 10);
        this.Head.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.Head.addBox(-2.0F, -0.4F, -3.5F, 4.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, -1.8374826151943415F, 0.0F, 0.0F);
        this.LArm = new ModelRenderer(this, 52, 13);
        this.LArm.mirror = true;
        this.LArm.setRotationPoint(3.0F, 6.0F, -8.5F);
        this.LArm.addBox(1.0F, -1.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LArm, -0.23457224414434488F, 0.0F, -0.8210028961170991F);
        this.LFoot = new ModelRenderer(this, 0, 28);
        this.LFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LFoot.addBox(-1.5F, -2.7F, -10.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LFoot, 1.5707963267948966F, 0.0F, 0.0F);
        this.LLeg1 = new ModelRenderer(this, 40, 27);
        this.LLeg1.setRotationPoint(3.0F, 4.0F, 1.0F);
        this.LLeg1.addBox(-1.0F, -2.0F, -3.0F, 4.0F, 10.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LLeg1, -1.0164797856562695F, -0.23457224414434488F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 0, 27);
        this.Tail1.setRotationPoint(0.0F, 0.01F, 4.0F);
        this.Tail1.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.1563815016444822F, 0.11728612207217244F, 0.0F);
        this.RLeg2 = new ModelRenderer(this, 8, 31);
        this.RLeg2.setRotationPoint(-1.5F, 8.0F, 4.0F);
        this.RLeg2.addBox(-1.5F, 0.0F, -2.7F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RLeg2, -0.5473352640780661F, 0.0781907508222411F, 0.0781907508222411F);
        this.LLeg2 = new ModelRenderer(this, 8, 31);
        this.LLeg2.mirror = true;
        this.LLeg2.setRotationPoint(1.5F, 8.0F, 4.0F);
        this.LLeg2.addBox(-1.5F, 0.0F, -2.7F, 3.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LLeg2, -0.5473352640780661F, -0.0781907508222411F, -0.0781907508222411F);
        this.RLeg1 = new ModelRenderer(this, 0, 48);
        this.RLeg1.setRotationPoint(-3.0F, 4.0F, 1.0F);
        this.RLeg1.addBox(-3.0F, -2.0F, -3.0F, 4.0F, 10.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RLeg1, -1.0164797856562695F, 0.23457224414434488F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 18, 30);
        this.Tail2.setRotationPoint(0.0F, 1.0F, 13.0F);
        this.Tail2.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.0781907508222411F, 0.3909537457888271F, 0.0F);
        this.Neck1 = new ModelRenderer(this, 34, 0);
        this.Neck1.setRotationPoint(0.0F, 1.0F, -11.0F);
        this.Neck1.addBox(-2.0F, 0.0F, -8.0F, 4.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck1, 0.46914448828868976F, -0.4300491170387584F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 15.0F, 3.0F);
        this.Body.addBox(-4.0F, 0.0F, -12.0F, 8.0F, 9.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.Neck2 = new ModelRenderer(this, 0, 0);
        this.Neck2.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.Neck2.addBox(-2.0F, -6.2F, -3.0F, 4.0F, 7.0F, 3.0F, -0.01F, 0.0F, 0.0F);
        this.setRotateAngle(Neck2, 1.3683381601951652F, 0.0F, 0.0F);
        this.RFoot = new ModelRenderer(this, 0, 28);
        this.RFoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RFoot.addBox(-1.5F, -2.7F, -10.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RFoot, 1.5707963267948966F, 0.0F, 0.0F);
        this.Body.addChild(this.RArm);
        this.Neck2.addChild(this.Head);
        this.Body.addChild(this.LArm);
        this.LLeg2.addChild(this.LFoot);
        this.Body.addChild(this.LLeg1);
        this.Body.addChild(this.Tail1);
        this.RLeg1.addChild(this.RLeg2);
        this.LLeg1.addChild(this.LLeg2);
        this.Body.addChild(this.RLeg1);
        this.Tail1.addChild(this.Tail2);
        this.Body.addChild(this.Neck1);
        this.Neck1.addChild(this.Neck2);
        this.RLeg2.addChild(this.RFoot);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }


    @Override
    public void setRotationAngles(SarahsaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
