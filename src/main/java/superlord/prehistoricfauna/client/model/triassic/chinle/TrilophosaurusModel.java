package superlord.prehistoricfauna.client.model.triassic.chinle;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.chinle.TrilophosaurusEntity;

/**
 * Trilophosaurus - Crimes
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class TrilophosaurusModel extends EntityModel<TrilophosaurusEntity> {
	public ModelRenderer Body;
    public ModelRenderer LeftArm;
    public ModelRenderer RightArm;
    public ModelRenderer LeftLeg;
    public ModelRenderer RightLeg;
    public ModelRenderer Neck;
    public ModelRenderer TailBase;
    public ModelRenderer Head;
    public ModelRenderer Snoot;
    public ModelRenderer TailEnd;
    public ModelRenderer LeftHand;
    public ModelRenderer RightHand;
    public ModelRenderer LeftFoot;
    public ModelRenderer RightFoot;

    public TrilophosaurusModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.RightArm = new ModelRenderer(this, 0, 10);
        this.RightArm.mirror = true;
        this.RightArm.setRotationPoint(-3.0F, 20.99F, -4.0F);
        this.RightArm.addBox(-1.0F, -2.0F, -1.5F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LeftHand = new ModelRenderer(this, 53, 27);
        this.LeftHand.setRotationPoint(1.0F, 3.01F, -1.0F);
        this.LeftHand.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 5);
        this.Head.setRotationPoint(0.0F, -2.9F, -3.0F);
        this.Head.addBox(-1.5F, -2.0F, -2.0F, 3.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.LeftFoot = new ModelRenderer(this, 52, 16);
        this.LeftFoot.setRotationPoint(1.0F, 4.01F, -2.0F);
        this.LeftFoot.addBox(-1.5F, 0.0F, -2.5F, 3.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 0, 10);
        this.LeftArm.setRotationPoint(3.0F, 20.89F, -4.0F);
        this.LeftArm.addBox(-1.0F, -2.0F, -1.5F, 2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.RightFoot = new ModelRenderer(this, 52, 16);
        this.RightFoot.mirror = true;
        this.RightFoot.setRotationPoint(-1.0F, 4.01F, -2.0F);
        this.RightFoot.addBox(-1.5F, 0.0F, -2.5F, 3.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Snoot = new ModelRenderer(this, 0, 0);
        this.Snoot.setRotationPoint(0.0F, 0.0F, -2.0F);
        this.Snoot.addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 10, 0);
        this.Neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Neck.addBox(-1.0F, -5.0F, -4.0F, 2.0F, 7.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.TailEnd = new ModelRenderer(this, 12, 19);
        this.TailEnd.setRotationPoint(0.0F, -0.01F, 9.3F);
        this.TailEnd.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 24.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(TailEnd, 0.11728612207217244F, 0.0F, 0.0F);
        this.RightHand = new ModelRenderer(this, 53, 27);
        this.RightHand.mirror = true;
        this.RightHand.setRotationPoint(-1.0F, 3.01F, -1.0F);
        this.RightHand.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg = new ModelRenderer(this, 0, 18);
        this.RightLeg.mirror = true;
        this.RightLeg.setRotationPoint(-3.0F, 19.99F, 6.5F);
        this.RightLeg.addBox(-1.0F, -2.0F, -1.5F, 2.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 14, 0);
        this.Body.setRotationPoint(0.0F, 18.0F, -4.0F);
        this.Body.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.TailBase = new ModelRenderer(this, 38, 0);
        this.TailBase.setRotationPoint(0.0F, 0.2F, 11.0F);
        this.TailBase.addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(TailBase, -0.27366763203903305F, 0.0F, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 0, 18);
        this.LeftLeg.setRotationPoint(3.0F, 19.99F, 6.5F);
        this.LeftLeg.addBox(-1.0F, -2.0F, -1.5F, 2.0F, 6.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.LeftArm.addChild(this.LeftHand);
        this.Neck.addChild(this.Head);
        this.LeftLeg.addChild(this.LeftFoot);
        this.RightLeg.addChild(this.RightFoot);
        this.Head.addChild(this.Snoot);
        this.Body.addChild(this.Neck);
        this.TailBase.addChild(this.TailEnd);
        this.RightArm.addChild(this.RightHand);
        this.Body.addChild(this.TailBase);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.RightArm, this.LeftArm, this.RightLeg, this.Body, this.LeftLeg).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(TrilophosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.TailBase.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
		this.TailEnd.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
		this.TailBase.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
		this.TailEnd.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
		this.Neck.rotateAngleX = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3)));
		this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;		this.Neck.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		if (entityIn.isEating()) {
			this.Neck.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
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
