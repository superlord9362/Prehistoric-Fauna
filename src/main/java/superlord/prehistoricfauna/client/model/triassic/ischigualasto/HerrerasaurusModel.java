package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.prehistoricfauna.common.entities.triassic.ischigualasto.HerrerasaurusEntity;

/**
 * Herrerasaurus - superlord9362
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class HerrerasaurusModel extends EntityModel<HerrerasaurusEntity> {
	public ModelRenderer Body;
	public ModelRenderer Tail1;
	public ModelRenderer Neck;
	public ModelRenderer RArm;
	public ModelRenderer LArm;
	public ModelRenderer RThigh;
	public ModelRenderer LThigh;
	public ModelRenderer BodySpikes;
	public ModelRenderer Tail2;
	public ModelRenderer Tail1Spikes;
	public ModelRenderer Tail2Spikes;
	public ModelRenderer Head;
	public ModelRenderer Snout;
	public ModelRenderer RLeg;
	public ModelRenderer RFoot;
	public ModelRenderer LLeg;
	public ModelRenderer LFoot;

	public HerrerasaurusModel() {
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.LArm = new ModelRenderer(this, 82, 0);
		this.LArm.mirror = true;
		this.LArm.setRotationPoint(-2.0F, 7.0F, 3.0F);
		this.LArm.addBox(-2.0F, -2.0F, -1.0F, 2.0F, 11.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.LFoot = new ModelRenderer(this, 0, 0);
		this.LFoot.mirror = true;
		this.LFoot.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.LFoot.addBox(0.0F, 0.0F, -5.0F, 3.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.LThigh = new ModelRenderer(this, 100, 0);
		this.LThigh.mirror = true;
		this.LThigh.setRotationPoint(-3.0F, 4.0F, 15.5F);
		this.LThigh.addBox(-1.0F, -2.0F, -3.5F, 3.0F, 12.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.Snout = new ModelRenderer(this, 0, 32);
		this.Snout.setRotationPoint(0.0F, 0.0F, -3.0F);
		this.Snout.addBox(-1.5F, -2.0F, -5.0F, 3.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.Neck = new ModelRenderer(this, 34, 0);
		this.Neck.setRotationPoint(0.0F, 4.0F, 1.0F);
		this.Neck.addBox(-2.0F, -8.0F, -5.0F, 4.0F, 10.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.LLeg = new ModelRenderer(this, 10, 5);
		this.LLeg.mirror = true;
		this.LLeg.setRotationPoint(-1.0F, 10.0F, 3.5F);
		this.LLeg.addBox(0.0F, 0.0F, 0.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.RThigh = new ModelRenderer(this, 100, 0);
		this.RThigh.setRotationPoint(3.0F, 4.0F, 15.5F);
		this.RThigh.addBox(-2.0F, -2.0F, -3.5F, 3.0F, 12.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.BodySpikes = new ModelRenderer(this, 0, 36);
		this.BodySpikes.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BodySpikes.addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 22.0F, 0.0F, 0.0F, 0.0F);
		this.RArm = new ModelRenderer(this, 82, 0);
		this.RArm.setRotationPoint(2.0F, 7.0F, 3.0F);
		this.RArm.addBox(0.0F, -2.0F, -1.0F, 2.0F, 11.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 0, 32);
		this.Tail2.setRotationPoint(0.0F, -1.0F, 18.0F);
		this.Tail2.addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 21.0F, 0.0F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 52, 0);
		this.Head.setRotationPoint(0.0F, -6.0F, -5.0F);
		this.Head.addBox(-2.0F, -2.0F, -3.0F, 4.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.Tail1 = new ModelRenderer(this, 56, 0);
		this.Tail1.setRotationPoint(0.0F, 4.0F, 22.0F);
		this.Tail1.addBox(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 18.0F, 0.0F, 0.0F, 0.0F);
		this.Tail1Spikes = new ModelRenderer(this, 0, 39);
		this.Tail1Spikes.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.Tail1Spikes.addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 18.0F, 0.0F, 0.0F, 0.0F);
		this.RLeg = new ModelRenderer(this, 10, 5);
		this.RLeg.setRotationPoint(-2.0F, 10.0F, 3.5F);
		this.RLeg.addBox(0.0F, 0.0F, 0.0F, 3.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.RFoot = new ModelRenderer(this, 0, 0);
		this.RFoot.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.RFoot.addBox(0.0F, 0.0F, -5.0F, 3.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 2.0F, -15.0F);
		this.Body.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 10.0F, 22.0F, 0.0F, 0.0F, 0.0F);
		this.Tail2Spikes = new ModelRenderer(this, 0, 35);
		this.Tail2Spikes.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.Tail2Spikes.addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 21.0F, 0.0F, 0.0F, 0.0F);
		this.Body.addChild(this.LArm);
		this.LLeg.addChild(this.LFoot);
		this.Body.addChild(this.LThigh);
		this.Head.addChild(this.Snout);
		this.Body.addChild(this.Neck);
		this.LThigh.addChild(this.LLeg);
		this.Body.addChild(this.RThigh);
		this.Body.addChild(this.BodySpikes);
		this.Body.addChild(this.RArm);
		this.Tail1.addChild(this.Tail2);
		this.Neck.addChild(this.Head);
		this.Body.addChild(this.Tail1);
		this.Tail1.addChild(this.Tail1Spikes);
		this.RThigh.addChild(this.RLeg);
		this.RLeg.addChild(this.RFoot);
		this.Tail2.addChild(this.Tail2Spikes);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
		ImmutableList.of(this.Body).forEach((modelRenderer) -> { 
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(HerrerasaurusEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entityIn.ticksExisted;
		float attackProgress =  entityIn.getMeleeProgress(partialTick);
		resetModel();
		if (entityIn.isAsleep()) {
			this.RLeg.rotateAngleX = -0.6981317007977318F;
			this.Body.rotationPointY = 7.0F;
			this.Body.rotateAngleX = -0.3490658503988659F;
			this.Tail2.rotateAngleX = 0.13962634015954636F;
			this.Tail2.rotateAngleY = -0.593411945678072F;
			this.Tail2.rotateAngleZ = -0.10471975511965977F;
			this.LArm.rotateAngleX = 0.8726646259971648F;
			this.RThigh.rotationPointY = 1.7F;
			this.RThigh.rotationPointZ = 18.5F;
			this.RThigh.rotateAngleX = -0.5235987755982988F;
			this.RThigh.rotateAngleY = -0.296705972839036F;
			this.RThigh.rotateAngleZ = -0.12217304763960307F;
			this.RFoot.rotateAngleX = 1.5707963267948966F;
			this.LLeg.rotateAngleX = -0.6981317007977318F;
			this.RArm.rotateAngleX = 0.8726646259971648F;
			this.LThigh.rotationPointY = 1.7F;
			this.LThigh.rotationPointZ = 18.5F;
			this.LThigh.rotateAngleX = -0.5235987755982988F;
			this.LThigh.rotateAngleY = 0.296705972839036F;
			this.LThigh.rotateAngleZ = 0.12217304763960307F;
			this.LFoot.rotateAngleX = 1.5707963267948966F;
			this.Tail1.rotateAngleX = 0.06981317007977318F;
			this.Tail1.rotateAngleY = -0.593411945678072F;
			this.Tail1.rotateAngleZ = -0.03490658503988659F;
			this.Neck.rotationPointX = -0.3F;
			this.Neck.rotationPointY = 2.5F;
			this.Neck.rotationPointZ = 0.0F;
			this.Neck.rotateAngleX = 0.5585053606381855F;
			this.Neck.rotateAngleY = 2.3387411976724017F;
			this.Neck.rotateAngleZ = 0.03490658503988659F;
		} else {
			this.RThigh.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LThigh.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Tail1.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tail2.rotateAngleY = -0.12F * MathHelper.sin(0.2F * ageInTicks / 5);
			this.Tail1.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.Tail2.rotateAngleX = -Math.abs(-0.05F * MathHelper.sin(0.1F * ageInTicks / 5));
			this.Neck.rotateAngleX = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * MathHelper.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
			this.LArm.rotateAngleZ = Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
			this.RArm.rotateAngleZ = -Math.abs(-0.05F * MathHelper.sin(0.15F * ageInTicks / 3));
			this.Neck.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
			this.Head.rotateAngleX = attackProgress * (float) Math.toRadians(-15F);
			if (entityIn.isInWater()) {
				this.LThigh.rotationPointY = 4;
				this.RThigh.rotationPointY = 4;
				this.Body.rotationPointY = 10;
				this.Body.rotateAngleX = -0.25F;
				this.Tail1.rotateAngleX = 0.125F;
				this.Tail2.rotateAngleX = 0.125F;
				this.Neck.rotateAngleX = 0.25F;
				this.LThigh.rotateAngleX = -0.5F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RThigh.rotateAngleX = 0.5F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.LLeg.rotateAngleX = -0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RLeg.rotateAngleX = 0.3F * MathHelper.sin(0.2F * ageInTicks / 1.5F);
				this.RArm.rotateAngleX = 0.25F;
				this.LArm.rotateAngleX = 0.25F;
				this.Tail1.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.rotateAngleY = (MathHelper.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * MathHelper.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.RLeg.rotateAngleX = 0;
		this.Body.rotationPointY = 2.0F;
		this.Body.rotateAngleX = 0;
		this.Tail2.rotateAngleX = 0;
		this.Tail2.rotateAngleY = 0;
		this.Tail2.rotateAngleZ = 0;
		this.LArm.rotateAngleX = 0;
		this.RThigh.rotationPointY = 4.0F;
		this.RThigh.rotationPointZ = 15.5F;
		this.RThigh.rotateAngleX = 0;
		this.RThigh.rotateAngleY = 0;
		this.RThigh.rotateAngleZ = 0;
		this.RFoot.rotateAngleX = 0;
		this.LLeg.rotateAngleX = 0;
		this.RArm.rotateAngleX = 0;
		this.LThigh.rotationPointY = 4.0F;
		this.LThigh.rotationPointZ = 15.5F;
		this.LThigh.rotateAngleX = 0;
		this.LThigh.rotateAngleY = 0;
		this.LThigh.rotateAngleZ = 0;
		this.LFoot.rotateAngleX = 0;
		this.Tail1.rotateAngleX = 0;
		this.Tail1.rotateAngleY = 0;
		this.Tail1.rotateAngleZ = 0;
		this.Neck.rotationPointX = 0.0F;
		this.Neck.rotationPointY = 4.0F;
		this.Neck.rotationPointZ = 1.0F;
		this.Neck.rotateAngleX = 0;
		this.Neck.rotateAngleY = 0;
		this.Neck.rotateAngleZ = 0;
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
