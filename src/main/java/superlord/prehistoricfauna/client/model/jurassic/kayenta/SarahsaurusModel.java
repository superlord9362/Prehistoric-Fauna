package superlord.prehistoricfauna.client.model.jurassic.kayenta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.jurassic.kayenta.SarahsaurusEntity;

/**
 * SarahsaurusModel - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SarahsaurusModel extends EntityModel<SarahsaurusEntity> {
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
    public ModelRenderer RLeg2;

    public SarahsaurusModel() {
        this.textureWidth = 64;
        this.textureHeight = 80;
        this.RArm = new ModelRenderer(this, 22, 52);
        this.RArm.setRotationPoint(-3.0F, 6.0F, -8.5F);
        this.RArm.addBox(-2.0F, -1.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 18, 30);
        this.Tail2.setRotationPoint(0.0F, 1.0F, 13.0F);
        this.Tail2.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail2, 0.06981317007977318F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 0, 27);
        this.Tail1.setRotationPoint(0.0F, 0.01F, 4.0F);
        this.Tail1.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Tail1, -0.10471975511965977F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 6.0F, 3.0F);
        this.Body.addBox(-4.0F, 0.0F, -12.0F, 8.0F, 9.0F, 18.0F, 0.0F, 0.0F, 0.0F);
        this.LLeg1 = new ModelRenderer(this, 40, 27);
        this.LLeg1.setRotationPoint(3.0F, 4.0F, 1.0F);
        this.LLeg1.addBox(-1.0F, -2.0F, -3.0F, 4.0F, 10.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.LLeg2 = new ModelRenderer(this, 0, 27);
        this.LLeg2.setRotationPoint(0.5F, 8.0F, 4.0F);
        this.LLeg2.addBox(-1.5F, 0.0F, -4.0F, 3.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Neck1 = new ModelRenderer(this, 34, 0);
        this.Neck1.setRotationPoint(0.0F, 1.0F, -11.0F);
        this.Neck1.addBox(-2.0F, 0.0F, -8.0F, 4.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(Neck1, 0.06981317007977318F, 0.0F, 0.0F);
        this.LArm = new ModelRenderer(this, 52, 13);
        this.LArm.mirror = true;
        this.LArm.setRotationPoint(3.0F, 6.0F, -8.5F);
        this.LArm.addBox(0.0F, -1.0F, -1.5F, 2.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Neck2 = new ModelRenderer(this, 0, 0);
        this.Neck2.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.Neck2.addBox(-2.0F, -7.0F, 0.0F, 4.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 10);
        this.Head.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.Head.addBox(-2.0F, 0.0F, -5.0F, 4.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.RLeg1 = new ModelRenderer(this, 0, 48);
        this.RLeg1.setRotationPoint(-3.0F, 4.0F, 1.0F);
        this.RLeg1.addBox(-3.0F, -2.0F, -3.0F, 4.0F, 10.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.RLeg2 = new ModelRenderer(this, 0, 27);
        this.RLeg2.mirror = true;
        this.RLeg2.setRotationPoint(-0.5F, 8.0F, 4.0F);
        this.RLeg2.addBox(-1.5F, 0.0F, -4.0F, 3.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Body.addChild(this.RArm);
        this.Tail1.addChild(this.Tail2);
        this.Body.addChild(this.Tail1);
        this.Body.addChild(this.LLeg1);
        this.LLeg1.addChild(this.LLeg2);
        this.Body.addChild(this.Neck1);
        this.Body.addChild(this.LArm);
        this.Neck1.addChild(this.Neck2);
        this.Neck2.addChild(this.Head);
        this.Body.addChild(this.RLeg1);
        this.RLeg1.addChild(this.RLeg2);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(SarahsaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float partialTick = ageInTicks - entityIn.ticksExisted;
        float attackProgress = entityIn.getMeleeProgress(partialTick);
        this.RLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.Tail1.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
		this.Tail2.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
		this.Tail1.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
		this.Tail2.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
		this.Neck1.rotateAngleX = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(45F);
		this.LArm.rotateAngleZ = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
		this.RArm.rotateAngleZ = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
		this.Neck1.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.Head.rotateAngleX = attackProgress * (float) Math.toRadians(-15F);
        if (entityIn.isEating()) {
			this.Neck1.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.75F) + 1.2F;
		}
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
