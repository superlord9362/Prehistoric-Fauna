package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.cretaceous.djadochta.PinacosaurusEntity;

/**
 * Pinacosaurus - Obsolerus
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class PinacosaurusModel extends EntityModel<PinacosaurusEntity> {
    public ModelRenderer Body;
    public ModelRenderer LeftArm;
    public ModelRenderer RightArm;
    public ModelRenderer LeftThigh;
    public ModelRenderer RightThigh;
    public ModelRenderer Body1;
    public ModelRenderer Tail1;
    public ModelRenderer BodySpikes;
    public ModelRenderer Neck;
    public ModelRenderer Body1spikes;
    public ModelRenderer Head;
    public ModelRenderer Snout;
    public ModelRenderer LeftOsteoderm;
    public ModelRenderer RightOsteoderm;
    public ModelRenderer LeftCheekbone;
    public ModelRenderer RightCheekbone;
    public ModelRenderer Tail2;
    public ModelRenderer TailSpikes;
    public ModelRenderer TailSpikes2;
    public ModelRenderer TailClub;
    public ModelRenderer Tailspikes1;
    public ModelRenderer Tailspikes3;
    public ModelRenderer LeftLeg;
    public ModelRenderer LeftFoot;
    public ModelRenderer RightLeg;
    public ModelRenderer RightFoot;

    public PinacosaurusModel() {
        this.textureWidth = 200;
        this.textureHeight = 200;
        this.LeftOsteoderm = new ModelRenderer(this, 166, 0);
        this.LeftOsteoderm.setRotationPoint(2.5F, 0.5F, -2.0F);
        this.LeftOsteoderm.addBox(0.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftOsteoderm, 0.12217304763960307F, 0.24434609527920614F, 0.0F);
        this.BodySpikes = new ModelRenderer(this, -26, 72);
        this.BodySpikes.setRotationPoint(0.0F, -2.5F, -30.0F);
        this.BodySpikes.addBox(-16.0F, 0.0F, 0.0F, 32.0F, 0.0F, 26.0F, 0.0F, 0.0F, 0.0F);
        this.LeftArm = new ModelRenderer(this, 156, 25);
        this.LeftArm.setRotationPoint(7.0F, 14.0F, -12.0F);
        this.LeftArm.addBox(-1.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.RightCheekbone = new ModelRenderer(this, 75, 0);
        this.RightCheekbone.mirror = true;
        this.RightCheekbone.setRotationPoint(-3.0F, 3.0F, -2.0F);
        this.RightCheekbone.addBox(-2.0F, -0.5F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightCheekbone, 0.0F, -0.18849556254433897F, -0.0F);
        this.TailClub = new ModelRenderer(this, 0, 12);
        this.TailClub.setRotationPoint(0.0F, 0.0F, 26.0F);
        this.TailClub.addBox(-2.5F, -1.5F, 0.0F, 5.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.TailSpikes = new ModelRenderer(this, -2, 60);
        this.TailSpikes.setRotationPoint(0.0F, 2.5F, 2.0F);
        this.TailSpikes.addBox(-8.0F, 0.0F, 0.0F, 16.0F, 0.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.Tailspikes3 = new ModelRenderer(this, 56, 53);
        this.Tailspikes3.setRotationPoint(0.0F, -2.5F, 0.0F);
        this.Tailspikes3.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.LeftCheekbone = new ModelRenderer(this, 75, 0);
        this.LeftCheekbone.setRotationPoint(3.0F, 3.0F, -2.0F);
        this.LeftCheekbone.addBox(0.0F, -0.5F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(LeftCheekbone, 0.0F, 0.18849556254433897F, -0.0F);
        this.Snout = new ModelRenderer(this, 183, 0);
        this.Snout.setRotationPoint(0.0F, 0.0F, -6.0F);
        this.Snout.addBox(-2.5F, 0.0F, -3.0F, 5.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.RightOsteoderm = new ModelRenderer(this, 166, 0);
        this.RightOsteoderm.mirror = true;
        this.RightOsteoderm.setRotationPoint(-2.5F, 0.5F, -2.0F);
        this.RightOsteoderm.addBox(-2.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(RightOsteoderm, 0.12217304763960307F, -0.24434609527920614F, -0.0F);
        this.Tailspikes1 = new ModelRenderer(this, -14, 35);
        this.Tailspikes1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Tailspikes1.addBox(-6.5F, 0.0F, 0.0F, 13.0F, 0.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 49, 35);
        this.Tail2.setRotationPoint(0.0F, 2.5F, 14.0F);
        this.Tail2.addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 27.0F, 0.0F, 0.0F, 0.0F);
        this.RightThigh = new ModelRenderer(this, 75, 0);
        this.RightThigh.setRotationPoint(-9.0F, 9.0F, 10.0F);
        this.RightThigh.addBox(-3.0F, -1.0F, -5.0F, 6.0F, 11.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.Body1spikes = new ModelRenderer(this, 1, 100);
        this.Body1spikes.setRotationPoint(0.0F, -2.5F, -1.0F);
        this.Body1spikes.addBox(-10.0F, 0.0F, -5.0F, 20.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.RightArm = new ModelRenderer(this, 156, 25);
        this.RightArm.mirror = true;
        this.RightArm.setRotationPoint(-8.5F, 14.0F, -12.0F);
        this.RightArm.addBox(-1.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.RightLeg = new ModelRenderer(this, 135, 0);
        this.RightLeg.mirror = true;
        this.RightLeg.setRotationPoint(0.0F, 8.0F, 2.0F);
        this.RightLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 82, 32);
        this.Tail1.setRotationPoint(0.0F, -3.0F, -8.0F);
        this.Tail1.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 128, 25);
        this.Head.setRotationPoint(0.0F, -3.0F, -5.0F);
        this.Head.addBox(-4.0F, 0.0F, -6.0F, 8.0F, 5.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.Neck = new ModelRenderer(this, 98, 19);
        this.Neck.setRotationPoint(0.0F, -1.0F, -9.0F);
        this.Neck.addBox(-3.5F, -2.0F, -7.0F, 7.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.RightFoot = new ModelRenderer(this, 95, 0);
        this.RightFoot.mirror = true;
        this.RightFoot.setRotationPoint(0.0F, 6.0F, 2.0F);
        this.RightFoot.addBox(-2.5F, 0.0F, -5.0F, 5.0F, 1.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.TailSpikes2 = new ModelRenderer(this, 48, 35);
        this.TailSpikes2.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.TailSpikes2.addBox(-2.0F, -2.0F, 0.0F, 4.0F, 2.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.LeftThigh = new ModelRenderer(this, 75, 0);
        this.LeftThigh.setRotationPoint(9.0F, 9.0F, 10.0F);
        this.LeftThigh.addBox(-3.0F, -1.0F, -5.0F, 6.0F, 11.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.LeftFoot = new ModelRenderer(this, 95, 0);
        this.LeftFoot.setRotationPoint(0.0F, 6.0F, 2.0F);
        this.LeftFoot.addBox(-2.5F, 0.0F, -5.0F, 5.0F, 1.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 0);
        this.Body.setRotationPoint(0.0F, 11.0F, 24.0F);
        this.Body.addBox(-13.0F, -5.0F, -31.0F, 26.0F, 12.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.Body1 = new ModelRenderer(this, 142, 6);
        this.Body1.setRotationPoint(0.0F, 0.0F, -31.0F);
        this.Body1.addBox(-8.0F, -4.0F, -9.0F, 16.0F, 10.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 135, 0);
        this.LeftLeg.setRotationPoint(0.0F, 8.0F, 2.0F);
        this.LeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.Head.addChild(this.LeftOsteoderm);
        this.Body.addChild(this.BodySpikes);
        this.Head.addChild(this.RightCheekbone);
        this.Tail2.addChild(this.TailClub);
        this.Tail1.addChild(this.TailSpikes);
        this.Tail2.addChild(this.Tailspikes3);
        this.Head.addChild(this.LeftCheekbone);
        this.Head.addChild(this.Snout);
        this.Head.addChild(this.RightOsteoderm);
        this.Tail2.addChild(this.Tailspikes1);
        this.Tail1.addChild(this.Tail2);
        this.Body1.addChild(this.Body1spikes);
        this.RightThigh.addChild(this.RightLeg);
        this.Body.addChild(this.Tail1);
        this.Neck.addChild(this.Head);
        this.Body1.addChild(this.Neck);
        this.RightLeg.addChild(this.RightFoot);
        this.Tail1.addChild(this.TailSpikes2);
        this.LeftLeg.addChild(this.LeftFoot);
        this.Body.addChild(this.Body1);
        this.LeftThigh.addChild(this.LeftLeg);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.LeftArm, this.RightThigh, this.RightArm, this.LeftThigh, this.Body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(PinacosaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    	float speed = 0.9f;
		float degree = 1.0f;
		this.Body1.rotateAngleX = 0F;
		this.LeftArm.rotateAngleZ = -0F;
		this.RightArm.rotateAngleZ = 0F;
		this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
		this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
		this.RightThigh.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
		this.RightFoot.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
		this.LeftThigh.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
		this.LeftFoot.rotateAngleX = MathHelper.cos(limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
		this.Tail1.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
		this.Tail2.rotateAngleY = (-0.12F * MathHelper.sin(0.2F * ageInTicks / 5)) + (MathHelper.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
		this.Tail1.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
		this.Tail2.rotateAngleX = (-Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
		this.Neck.rotateAngleX = (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F);
		this.Head.rotateAngleX = (-Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + (MathHelper.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.05F);
		if (entityIn.isEating()) {
			this.Neck.rotateAngleX = Math.abs(MathHelper.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
			this.Body1.rotateAngleX = 0.1F;
			this.LeftArm.rotateAngleZ = -0.2F;
			this.RightArm.rotateAngleZ = 0.2F;
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
