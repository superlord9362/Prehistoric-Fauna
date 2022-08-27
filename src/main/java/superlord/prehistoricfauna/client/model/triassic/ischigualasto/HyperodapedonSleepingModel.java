package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HyperodapedonEntity;

/**
 * HyperodapedonModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class HyperodapedonSleepingModel extends EntityModel<HyperodapedonEntity> {
    public ModelRenderer Body;
    public ModelRenderer Head;
    public ModelRenderer RArm;
    public ModelRenderer LArm;
    public ModelRenderer RLeg;
    public ModelRenderer LLeg;
    public ModelRenderer Tail;
    public ModelRenderer Snout;

    public HyperodapedonSleepingModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.1F, 21.0F, -5.0F);
        this.Body.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Body, -0.036477379868653376F, -0.036477379868653376F, -0.8395033435776615F);
        this.LLeg = new ModelRenderer(this, 18, 0);
        this.LLeg.mirror = true;
        this.LLeg.setRotationPoint(-1.4F, 1.3F, 8.0F);
        this.LLeg.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LLeg, -0.07295475973730675F, 0.036477379868653376F, -0.7665485755179764F);
        this.Head = new ModelRenderer(this, 0, 13);
        this.Head.setRotationPoint(0.0F, 1.6F, 0.0F);
        this.Head.addBox(-2.5F, -1.5F, -3.0F, 5.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Head, 0.2556907287592666F, -0.3645992700889711F, 0.6932448001974364F);
        this.RArm = new ModelRenderer(this, 0, 0);
        this.RArm.setRotationPoint(0.7F, 3.0F, 2.41F);
        this.RArm.addBox(0.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RArm, 0.10943214376714933F, 0.0712094321497881F, 0.36477380700891215F);
        this.Snout = new ModelRenderer(this, 0, 19);
        this.Snout.setRotationPoint(-1.0F, 0.0F, -4.0F);
        this.Snout.addBox(-0.5F, -0.5F, 0.0F, 3.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.LArm = new ModelRenderer(this, 0, 0);
        this.LArm.mirror = true;
        this.LArm.setRotationPoint(-1.0F, 1.4F, 0.71F);
        this.LArm.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LArm, -0.18256144042439712F, -0.10978120928465304F, -0.6202900321377512F);
        this.Tail = new ModelRenderer(this, 19, 0);
        this.Tail.setRotationPoint(0.0F, 0.9F, 9.7F);
        this.Tail.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail, -0.1459095194746135F, 0.9482374145664524F, 0.8032005297572737F);
        this.RLeg = new ModelRenderer(this, 18, 0);
        this.RLeg.setRotationPoint(1.0F, 3.1F, 8.0F);
        this.RLeg.addBox(0.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RLeg, 0.583638077898454F, 0.0F, 0.0F);
        this.Body.addChild(this.LLeg);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.RArm);
        this.Head.addChild(this.Snout);
        this.Body.addChild(this.LArm);
        this.Body.addChild(this.Tail);
        this.Body.addChild(this.RLeg);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(HyperodapedonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
