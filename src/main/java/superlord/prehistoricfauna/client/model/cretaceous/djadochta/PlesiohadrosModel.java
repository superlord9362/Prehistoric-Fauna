package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Plesiohadros;

public class PlesiohadrosModel extends EntityModel<Plesiohadros> {
	private final ModelPart LegFrontR;
	private final ModelPart LegFrontL;
	private final ModelPart ThighL;
	private final ModelPart Body;
	private final ModelPart ThighR;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart TailTip;
	private final ModelPart TailBase;
	private final ModelPart BodyBack;
	private final ModelPart LegBackL;
	private final ModelPart LegBackR;
	private final ModelPart FeetL;
	private final ModelPart FeetR;

	public PlesiohadrosModel(ModelPart root) {
		this.LegFrontR = root.getChild("LegFrontR");
		this.LegFrontL = root.getChild("LegFrontL");
		this.ThighL = root.getChild("ThighL");
		this.Body = root.getChild("Body");
		this.ThighR = root.getChild("ThighR");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.BodyBack = Body.getChild("BodyBack");
		this.TailBase = BodyBack.getChild("TailBase");
		this.TailTip = TailBase.getChild("TailTip");
		this.LegBackL = ThighL.getChild("LegBackL");
		this.FeetL = LegBackL.getChild("FeetL");
		this.LegBackR = ThighR.getChild("LegBackR");
		this.FeetR = LegBackR.getChild("FeetR");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LegFrontR = partdefinition.addOrReplaceChild("LegFrontR", CubeListBuilder.create().texOffs(89, 70).addBox(0.0F, -1.0F, -2.0F, 3.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 5.0F, -9.0F));

		PartDefinition LegFrontL = partdefinition.addOrReplaceChild("LegFrontL", CubeListBuilder.create().texOffs(89, 70).mirror().addBox(-3.0F, -1.0F, -2.0F, 3.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 5.0F, -9.0F));

		PartDefinition ThighL = partdefinition.addOrReplaceChild("ThighL", CubeListBuilder.create().texOffs(94, 0).mirror().addBox(-4.0F, -3.0F, -3.0F, 5.0F, 20.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -2.0F, 6.0F));

		PartDefinition LegBackL = ThighL.addOrReplaceChild("LegBackL", CubeListBuilder.create().texOffs(130, 0).mirror().addBox(-2.0F, -1.0F, -1.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 13.0F, 7.0F));

		PartDefinition FeetL = LegBackL.addOrReplaceChild("FeetL", CubeListBuilder.create().texOffs(130, 20).mirror().addBox(-2.5F, 0.0F, -4.01F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 11.0F, 1.1F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 49).addBox(-5.0F, -6.0F, -6.0F, 10.0F, 19.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -10.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(114, 30).addBox(-2.0F, -4.0F, -12.0F, 4.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, 0.15F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(56, 0).addBox(-3.0F, -2.01F, -3.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -12.0F));

		PartDefinition Beak = Head.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(85, 0).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -3.0F));

		PartDefinition Nose = Beak.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(48, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -1.0F));

		PartDefinition ReinsRight = Head.addOrReplaceChild("ReinsRight", CubeListBuilder.create().texOffs(175, 37).mirror().addBox(0.0F, -7.0F, -0.5F, 0.0F, 15.0F, 30.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.08F, 3.0F, 2.5F, 0.0698F, 0.192F, -0.1396F));

		PartDefinition ReinsLeft = Head.addOrReplaceChild("ReinsLeft", CubeListBuilder.create().texOffs(175, 37).addBox(0.0F, -7.0F, -0.5F, 0.0F, 15.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.08F, 3.0F, 2.5F, 0.0698F, -0.192F, 0.1396F));

		PartDefinition BodyBack = Body.addOrReplaceChild("BodyBack", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, -8.0F, 0.0F, 13.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 10.0F));

		PartDefinition TailBase = BodyBack.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(54, 30).addBox(-3.5F, -5.0F, -1.0F, 7.0F, 12.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 21.0F, -0.15F, 0.0F, 0.0F));

		PartDefinition SpikesTailBese = TailBase.addOrReplaceChild("SpikesTailBese", CubeListBuilder.create().texOffs(48, 100).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 1.0F));

		PartDefinition TailTip = TailBase.addOrReplaceChild("TailTip", CubeListBuilder.create().texOffs(34, 70).addBox(-2.5F, -3.0F, -2.0F, 5.0F, 6.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 20.0F, 0.15F, 0.0F, 0.0F));

		PartDefinition SpikesTailTip = TailTip.addOrReplaceChild("SpikesTailTip", CubeListBuilder.create().texOffs(43, 84).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition Saddle = Body.addOrReplaceChild("Saddle", CubeListBuilder.create().texOffs(157, 6).addBox(-5.5F, 0.0F, -4.0F, 11.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.5F, 0.0F));

		PartDefinition Sadle = Saddle.addOrReplaceChild("Sadle", CubeListBuilder.create().texOffs(164, 37).addBox(-5.5F, -1.5F, -4.0F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 9.0F));

		PartDefinition ThighR = partdefinition.addOrReplaceChild("ThighR", CubeListBuilder.create().texOffs(94, 0).addBox(-1.0F, -3.0F, -3.0F, 5.0F, 20.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -2.0F, 6.0F));

		PartDefinition LegBackR = ThighR.addOrReplaceChild("LegBackR", CubeListBuilder.create().texOffs(130, 0).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 13.0F, 7.0F));

		PartDefinition FeetR = LegBackR.addOrReplaceChild("FeetR", CubeListBuilder.create().texOffs(130, 20).addBox(-2.5F, 0.0F, -4.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 1.1F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}


	@Override
	public void setupAnim(Plesiohadros entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick) * 2.0F;
		//Reset
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.ThighR.xRot = 0;
		this.ThighR.yRot = 0;
		this.Head.xRot = 0;
		this.LegFrontL.xRot = 0;
		this.LegFrontL.zRot = 0;
		this.LegBackL.xRot = 0;
		this.BodyBack.xRot = 0;
		this.BodyBack.yRot = 0;
		this.LegFrontR.xRot = 0;
		this.LegFrontR.yRot = 0;
		this.LegFrontR.zRot = 0;
		this.LegBackR.xRot = 0;
		this.Body.xRot = 0;
		this.TailBase.xRot = 0;
		this.TailBase.yRot = 0;
		this.TailTip.xRot = 0;
		this.TailTip.yRot = 0;
		this.TailTip.zRot = 0;
		this.ThighL.xRot = 0;
		this.FeetL.xRot = 0;
		this.FeetR.xRot = 0;
		this.Body.y = -2;
		this.ThighL.y = -2;
		this.ThighL.x = -5;
		this.ThighL.z = 7;
		this.ThighR.y = -2;
		this.ThighR.x = 5;
		this.ThighR.z = 7;
		this.LegBackL.y = 13;
		this.LegBackR.y = 13;
		this.LegFrontL.y = 5;
		this.LegFrontR.y = 5;
		this.FeetL.z = 1.1F;
		this.FeetR.z = 1.1F;
		this.TailBase.z = 21;
		this.TailTip.y = -1;
		this.BodyBack.z = 10;
		this.Neck.y = 0;
		//End Reset
		if (entity.isAsleep()) {
			this.Body.y = 10;
			this.ThighL.y = 6;
			this.ThighL.x = 10;
			this.ThighL.z = 9;
			this.ThighR.y = 6;
			this.ThighR.x = -1;
			this.ThighR.z = 12;
			this.LegFrontL.y = 18;
			this.LegFrontR.y = 18;
			this.LegBackL.y = 13.9F;
			this.LegBackR.y = 13.9F;
			this.FeetL.z = 1F;
			this.FeetR.z = 1F;
			this.TailBase.z = 20;
			this.TailTip.y = 0;
			this.BodyBack.z = 8;
			this.Neck.y = 1.5F;
			this.Neck.xRot = 0.5235987755982988F;
			this.Neck.yRot = -0.3490658503988659F;
			this.ThighR.xRot = -0.7330382858376184F;
			this.ThighR.yRot = 0.5585053606381855F;
			this.Head.xRot = -0.4974188368183839F;
			this.LegFrontL.xRot = -0.7330382858376184F;
			this.LegFrontL.zRot = -0.9075712110370513F;
			this.LegBackL.xRot = -0.8377580409572781F;
			this.BodyBack.xRot = -0.17453292519943295F;
			this.BodyBack.yRot = 0.3490658503988659F;
			this.LegFrontR.xRot = -1.3962634015954636F;
			this.LegFrontR.yRot = 0.13962634015954636F;
			this.LegFrontR.zRot = -0.13962634015954636F;
			this.LegBackR.xRot = -0.8377580409572781F;
			this.Body.xRot = 0.17453292519943295F;
			this.TailBase.xRot = -0.5585053606381855F;
			this.TailBase.yRot = 0.41887902047863906F;
			this.TailTip.xRot = 0.41887902047863906F;
			this.TailTip.yRot = 0.593411945678072F;
			this.TailTip.zRot = 0.10471975511965977F;
			this.ThighL.xRot = -0.7330382858376184F;
			this.FeetL.xRot = 1.5707963267948966F;
			this.FeetR.xRot = 1.5707963267948966F;
		} else {
			this.LegFrontL.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount + attackProgress * (float) Math.toRadians(15F);
			this.LegFrontR.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount + attackProgress * (float) Math.toRadians(15F);
			this.ThighR.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + attackProgress * (float) Math.toRadians(7F);
			this.LegBackR.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
			this.FeetR.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
			this.ThighL.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + attackProgress * (float) Math.toRadians(7F);
			this.LegBackL.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
			this.FeetL.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
			this.TailBase.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
			this.TailTip.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
			this.TailBase.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
			this.TailTip.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
			this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F);
			this.Head.xRot = attackProgress * (float) Math.toRadians(25F);
			this.Body.z = -10.0F + attackProgress * -8F;
			this.LegFrontR.z = -9.0F + attackProgress * -6F;
			this.LegFrontL.z = -9.0F + attackProgress * -6F;
			this.ThighR.z = 6.0F + attackProgress * -6F;
			this.ThighL.z = 6.0F + attackProgress * -6F;
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
				this.Body.xRot = 0.2F;
				this.LegFrontL.zRot = -0.2F;
				this.LegFrontR.zRot = 0.2F;
			}
			if (entity.isInWater()) {
				this.Body.y = 17;
				this.ThighL.y = 17;
				this.ThighR.y = 17;
				this.LegFrontL.y = 24;
				this.LegFrontR.y = 24;
				this.ThighL.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.ThighR.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LegBackL.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LegBackR.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.FeetL.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.FeetR.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.LegFrontR.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LegFrontL.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Neck.xRot = -0.125F;
				this.TailBase.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.TailTip.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LegFrontR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LegFrontL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		ThighL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		ThighR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}