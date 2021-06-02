package superlord.prehistoricfauna.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.entity.SillosuchusEntity;

/**
 * Sillosuchus - superlord9362
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class Sillosuchus extends EntityModel<SillosuchusEntity> {
    public ModelRenderer Body;
    public ModelRenderer Tail1;
    public ModelRenderer Neck;
    public ModelRenderer LThigh;
    public ModelRenderer LArm;
    public ModelRenderer RArm;
    public ModelRenderer RThigh;
    public ModelRenderer Tail2;
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer LLeg;
    public ModelRenderer LFoot;
    public ModelRenderer RLeg;
    public ModelRenderer RFoot;

    public Sillosuchus() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.LArm = new ModelRenderer(this, 22, 0);
        this.LArm.setRotationPoint(5.0F, 13.0F, 8.5F);
        this.LArm.addBox(-2.0F, -2.0F, -2.5F, 4.0F, 18.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 0, 62);
        this.Tail1.setRotationPoint(0.0F, 7.0F, 43.0F);
        this.Tail1.addBox(-4.0F, -6.0F, 0.0F, 8.0F, 12.0F, 27.0F, 0.0F, 0.0F, 0.0F);
        this.RArm = new ModelRenderer(this, 22, 0);
        this.RArm.mirror = true;
        this.RArm.setRotationPoint(-5.0F, 13.0F, 8.5F);
        this.RArm.addBox(-2.0F, -2.0F, -2.5F, 4.0F, 18.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.LFoot = new ModelRenderer(this, 0, 101);
        this.LFoot.setRotationPoint(0.0F, 9.0F, 1.5F);
        this.LFoot.addBox(-2.5F, 0.0F, -11.0F, 5.0F, 3.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 67, 0);
        this.Neck.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Neck.addBox(-3.0F, -13.0F, -5.0F, 6.0F, 22.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.LLeg = new ModelRenderer(this, 0, 27);
        this.LLeg.setRotationPoint(1.0F, 17.0F, 1.5F);
        this.LLeg.addBox(-2.0F, 0.0F, -3.5F, 4.0F, 9.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.RLeg = new ModelRenderer(this, 0, 27);
        this.RLeg.mirror = true;
        this.RLeg.setRotationPoint(-1.0F, 17.0F, 1.5F);
        this.RLeg.addBox(-2.0F, 0.0F, -3.5F, 4.0F, 9.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.RThigh = new ModelRenderer(this, 78, 62);
        this.RThigh.mirror = true;
        this.RThigh.setRotationPoint(-3.0F, 8.0F, 32.0F);
        this.RThigh.addBox(-4.0F, -5.0F, -7.0F, 6.0F, 22.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.LThigh = new ModelRenderer(this, 78, 62);
        this.LThigh.setRotationPoint(3.0F, 8.0F, 32.0F);
        this.LThigh.addBox(-2.0F, -5.0F, -7.0F, 6.0F, 22.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.Snout = new ModelRenderer(this, 95, 0);
        this.Snout.setRotationPoint(0.0F, 4.0F, -5.0F);
        this.Snout.addBox(-2.5F, -3.0F, -7.0F, 5.0F, 5.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, -13.0F, -31.0F);
        this.Body.addBox(-6.0F, 0.0F, 0.0F, 12.0F, 19.0F, 43.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, -13.0F, -5.0F);
        this.Head.addBox(-3.0F, 0.0F, -5.0F, 6.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.RFoot = new ModelRenderer(this, 0, 101);
        this.RFoot.mirror = true;
        this.RFoot.setRotationPoint(0.0F, 9.0F, 1.5F);
        this.RFoot.addBox(-2.5F, 0.0F, -11.0F, 5.0F, 3.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 28, 62);
        this.Tail2.setRotationPoint(0.0F, -1.0F, 27.0F);
        this.Tail2.addBox(-2.0F, -3.0F, 0.0F, 4.0F, 7.0F, 42.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.LArm);
        this.Body.addChild(this.Tail1);
        this.Body.addChild(this.RArm);
        this.LLeg.addChild(this.LFoot);
        this.Body.addChild(this.Neck);
        this.LThigh.addChild(this.LLeg);
        this.RThigh.addChild(this.RLeg);
        this.Body.addChild(this.RThigh);
        this.Body.addChild(this.LThigh);
        this.Head.addChild(this.Snout);
        this.Neck.addChild(this.Head);
        this.RLeg.addChild(this.RFoot);
        this.Tail1.addChild(this.Tail2);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(SillosuchusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float speed = 1.0f;
    	float degree = 1.0f;
    	float offset = 0.0F;
        this.Neck.rotateAngleX = MathHelper.cos(-offset + limbSwing * speed * 0.3F) * degree * 0.25F * limbSwingAmount;
        this.RArm.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
        this.LArm.rotateAngleX = MathHelper.cos(offset + limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
        this.Tail1.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount;
        this.Tail2.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
        this.Tail1.rotateAngleY = MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.25F * limbSwingAmount;
        this.Tail2.rotateAngleY = MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount;
        this.RThigh.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
        this.RLeg.rotateAngleX = MathHelper.cos(offset + limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
        this.RFoot.rotateAngleX = MathHelper.cos(offset + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount;
        this.LThigh.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
        this.LLeg.rotateAngleX = MathHelper.cos(offset + limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
        this.LFoot.rotateAngleX = MathHelper.cos(offset + limbSwing * speed * 0.3F) * degree * -0.2F * limbSwingAmount;
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
