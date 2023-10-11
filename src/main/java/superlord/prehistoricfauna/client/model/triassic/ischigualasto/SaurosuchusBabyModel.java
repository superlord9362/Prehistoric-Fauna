package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

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
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Saurosuchus;

public class SaurosuchusBabyModel extends EntityModel<Saurosuchus> {
	private final ModelPart Torso;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart TailBase;
	private final ModelPart LArm;
	private final ModelPart RArm;
	private final ModelPart RLeg;
	private final ModelPart RFoot;
	private final ModelPart LLeg;
	private final ModelPart LFoot;

	public SaurosuchusBabyModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.Neck = Torso.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.TailBase = Torso.getChild("TailBase");
		this.LArm = Torso.getChild("LArm");
		this.RArm = Torso.getChild("RArm");
		this.RLeg = root.getChild("RLeg");
		this.RFoot = RLeg.getChild("RFoot");
		this.LLeg = root.getChild("LLeg");
		this.LFoot = LLeg.getChild("LFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, -6.0F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 6).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0698F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(20, 18).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition Beak = Head.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -4.0F));

		PartDefinition TailBase = Torso.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(0, 18).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 12.0F, -0.0698F, 0.0F, 0.0F));

		PartDefinition DorsalOsteoderms = TailBase.addOrReplaceChild("DorsalOsteoderms", CubeListBuilder.create().texOffs(0, 25).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 1.0F));

		PartDefinition RArm = Torso.addOrReplaceChild("RArm", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 4.0F, 2.0F));

		PartDefinition LArm = Torso.addOrReplaceChild("LArm", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 4.0F, 2.0F));

		PartDefinition DorsalOsteoderms_1 = Torso.addOrReplaceChild("DorsalOsteoderms_1", CubeListBuilder.create().texOffs(0, 25).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 1.0F));

		PartDefinition RLeg = partdefinition.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-2.0F, -1.5F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 17.5F, 3.5F));

		PartDefinition RFoot = RLeg.addOrReplaceChild("RFoot", CubeListBuilder.create().texOffs(17, 26).addBox(-1.5F, 0.0F, -5.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 6.5F, 0.5F));

		PartDefinition LLeg = partdefinition.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -1.5F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 17.5F, 3.5F));

		PartDefinition LFoot = LLeg.addOrReplaceChild("LFoot", CubeListBuilder.create().texOffs(17, 26).mirror().addBox(-1.5F, 0.0F, -5.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 6.5F, 0.5F));

		return LayerDefinition.create(meshdefinition, 36, 37);
	}

	@Override
	public void setupAnim(Saurosuchus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		int sleepProgress = entity.getSleepTicks();
		int wakingProgress = entity.getWakingTicks();
		if (!entity.isWakingUp() && !entity.isFallingAsleep()) {
			if (!entity.isAsleep()) {
				resetModel();
			} else {
				this.RArm.y = 5.5F;
				this.RArm.xRot = -1.5707963267948966F;
				this.LArm.y = 5.5F;
				this.LArm.xRot = -1.5707963267948966F;
				this.TailBase.xRot = -0.17453292519943295F;
				this.TailBase.yRot = 0.6108652381980153F;
				this.Neck.xRot = 0.17453292519943295F;
				this.Torso.y = 18F;
				this.LLeg.x = 2.5F;
				this.LLeg.y = 22.5F;
				this.LLeg.z = 4;
				this.LLeg.xRot = 1.5707963267948966F;
				this.LLeg.yRot = 0.6981317007977318F;
				this.RLeg.x = -2.5F;
				this.RLeg.y = 22.5F;
				this.RLeg.z = 4;
				this.RLeg.xRot = 1.5707963267948966F;
				this.RLeg.yRot = -0.6981317007977318F;
			}
		}
		if (wakingProgress != 0) {
			//RArm
//			this.RArm.y = 4.0F;
			if (this.RArm.y > 4) this.RArm.y -= 0.15;
			if (this.RArm.xRot < 0) this.RArm.xRot += 0.05;
			//LArm
//			this.LArm.y = 4.0F;
			if (this.LArm.y > 4) this.LArm.y -= 0.15;
			if (this.LArm.xRot < 0) this.LArm.xRot += 0.05;
			//TailBase
//			this.TailBase.xRot = -0.0698F;
			if (this.TailBase.xRot < -0.0698F) this.TailBase.xRot += -0.05;
			if (this.TailBase.yRot > 0) this.TailBase.yRot -= 0.05;
			//Neck
//			this.Neck.xRot = 0.0698F;
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			//Torso
//			this.Torso.y = 14.0F;
			if (this.Torso.y > 14) this.Torso.y -= 0.15;
			//LLeg
//			this.LLeg.x = -2.5F;
//			this.LLeg.y = 17.5F;
//			this.LLeg.z = 3.5F;
			if (this.LLeg.x > -2.5) this.LLeg.x -= 0.15;
			if (this.LLeg.y > 17.5) this.LLeg.y -= 0.15;
			if (this.LLeg.z > 3.5) this.LLeg.z -= 0.15;
			if (this.LLeg.xRot > 0) this.LLeg.xRot -= 0.05;
			if (this.LLeg.yRot > 0) this.LLeg.yRot -= 0.05;
			//RLeg
//			this.RLeg.x = 2.5F;
//			this.RLeg.y = 17.5F;
//			this.RLeg.z = 3.5F;
			if (this.RLeg.x < 2.5) this.RLeg.x += 0.15;
			if (this.RLeg.y > 17.5) this.RLeg.y -= 0.15;
			if (this.RLeg.z > 3.5) this.RLeg.z -= 0.15;
			if (this.RLeg.xRot > 0) this.RLeg.xRot -= 0.05;
			if (this.RLeg.yRot < 0) this.RLeg.yRot += 0.05;
		}
		if(entity.isAsleep()) {
			if (sleepProgress != 0) {
				//RArm
//				this.RArm.y = 4.0F;
				if (this.RArm.y < 5.5) this.RArm.y += 0.15;
				if (this.RArm.xRot > -1.5707963267948966F) this.RArm.xRot -= 0.05;
				//LArm
//				this.LArm.y = 4.0F;
				if (this.LArm.y < 5.5) this.LArm.y += 0.15;
				if (this.LArm.xRot > -1.5707963267948966F) this.LArm.xRot -= 0.05;
				//TailBase
//				this.TailBase.xRot = -0.0698F;
				if (this.TailBase.xRot > -0.17453292519943295F) this.TailBase.xRot -= -0.05;
				if (this.TailBase.yRot < 0.6108652381980153F) this.TailBase.yRot += 0.05;
				//Neck
//				this.Neck.xRot = 0.0698F;
				if (this.Neck.xRot < 0.17453292519943295F) this.Neck.xRot += 0.05;
				//Torso
//				this.Torso.y = 14.0F;
				if (this.Torso.y < 18) this.Torso.y += 0.15;
				//LLeg
//				this.LLeg.x = -2.5F;
//				this.LLeg.y = 17.5F;
//				this.LLeg.z = 3.5F;
				if (this.LLeg.x < 2.5) this.LLeg.x += 0.15;
				if (this.LLeg.y < 22.5) this.LLeg.y += 0.15;
				if (this.LLeg.z < 4) this.LLeg.z += 0.15;
				if (this.LLeg.xRot < 1.5707963267948966F) this.LLeg.xRot += 0.05;
				if (this.LLeg.yRot < 0.6981317007977318F) this.LLeg.yRot += 0.05;
				//RLeg
//				this.RLeg.x = 2.5F;
//				this.RLeg.y = 17.5F;
//				this.RLeg.z = 3.5F;
				if (this.RLeg.x > -2.5) this.RLeg.x -= 0.15;
				if (this.RLeg.y < 22.5) this.RLeg.y += 0.15;
				if (this.RLeg.z < 4) this.RLeg.z += 0.15;
				if (this.RLeg.xRot < 1.5707963267948966F) this.RLeg.xRot += 0.05;
				if (this.RLeg.yRot > -0.6981317007977318F) this.RLeg.yRot -= 0.05;
			}
		} else {
			if (entity.getDeltaMovement().x !=  0 && entity.getDeltaMovement().y != 0 && entity.getDeltaMovement().z != 0) {
				this.Head.xRot = 0;
				this.Neck.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.08F * limbSwingAmount;
				this.Head.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount + 0.05F;
				this.RArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
				this.LArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
				this.LLeg.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
				this.LFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
				this.RLeg.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
				this.RFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
				this.TailBase.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1F;
				this.TailBase.yRot = Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * -0.15F * limbSwingAmount;
				this.Torso.y = Mth.cos(-1.0F + limbSwing * 0.3F) * 0.5F * limbSwingAmount + 14;
			} else {
				this.RArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
				this.LArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
				this.LLeg.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
				this.LFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
				this.RLeg.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
				this.RFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
				this.TailBase.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * -0.15F * limbSwingAmount);
				this.TailBase.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1F);
				this.Torso.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
				this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.08F * limbSwingAmount);
				this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount + 0.05F);
				if (entity.isInWater()) {
					this.Torso.y = 15;
					this.LLeg.y = 18;
					this.RLeg.y = 18;
					this.RArm.y = 2;
					this.LArm.y = 2;
					this.LLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.RFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = -0.25F;
					this.TailBase.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.LArm.x = -2.5F;
		this.LArm.y = 4.0F;
		this.LArm.z = 2.0F;
		this.LArm.xRot = 0;
		this.LArm.yRot = 0;
		this.LArm.zRot = 0;
		this.RLeg.x = 2.5F;
		this.RLeg.y = 17.5F;
		this.RLeg.z = 3.5F;
		this.RLeg.xRot = 0F;
		this.RLeg.yRot = 0;
		this.LFoot.y = 6.5F;
		this.LFoot.z = 0.0F;
		this.LFoot.xRot = 0.04991641477611458F;
		this.RFoot.y = 6.5F;
		this.RFoot.z = 0.5F;
		this.RFoot.xRot = 0.05000000058364023F;
		this.TailBase.xRot = -0.0698F;
		this.TailBase.yRot = 0;
		this.TailBase.zRot = 0;
		this.LLeg.x = -2.5F;
		this.LLeg.y = 17.5F;
		this.LLeg.z = 3.5F;
		this.LLeg.xRot = 0F;
		this.LLeg.yRot = 0;
		this.LLeg.zRot = 0;
		this.RArm.x = 2.5F;
		this.RArm.y = 4.0F;
		this.RArm.z = 2.0F;
		this.RArm.xRot = 0.0F;
		this.RArm.yRot = 0;
		this.RArm.zRot = 0F;
		this.Torso.y = 14.0F;
		this.Torso.xRot = 0;
		this.Torso.zRot = 0;
		this.Neck.x = 0.0F;
		this.Neck.y = 2.0F;
		this.Neck.z = 0.0F;
		this.Neck.xRot = 0.0698F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Head.y = 0.0F;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
