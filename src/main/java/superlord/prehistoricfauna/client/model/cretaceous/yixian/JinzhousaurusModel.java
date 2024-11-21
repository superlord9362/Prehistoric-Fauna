package superlord.prehistoricfauna.client.model.cretaceous.yixian;

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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Jinzhousaurus;

public class JinzhousaurusModel extends EntityModel<Jinzhousaurus> {
	private final ModelPart Bone;
	private final ModelPart Body;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart LeftArm;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart RightArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public JinzhousaurusModel(ModelPart root) {
		this.Bone = root.getChild("Bone");
		this.Body = this.Bone.getChild("Body");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftThigh = this.Bone.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = this.Bone.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Bone = partdefinition.addOrReplaceChild("Bone", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = Bone.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -7.5F, -16.5F, 10.0F, 13.0F, 21.0F, new CubeDeformation(0.0F))
		.texOffs(17, 65).addBox(0.0F, -9.5F, -16.5F, 0.0F, 2.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.5F, 7.5F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 56).addBox(-3.0F, -2.75F, -1.0F, 6.0F, 7.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(56, 90).addBox(0.0F, -3.75F, 0.0F, 0.0F, 1.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.5F, 4.5F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(48, 34).addBox(-2.0F, -1.725F, -1.0F, 4.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(11, 95).addBox(0.0F, -2.725F, 0.0F, 0.0F, 1.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 13.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 54).mirror().addBox(-1.5F, -2.0F, -1.25F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(105, 9).mirror().addBox(-0.5F, 6.0F, -3.25F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, 3.5F, -14.25F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(29, 53).addBox(-2.5F, -3.5F, -8.0F, 5.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(86, 83).addBox(0.0F, -4.5F, -6.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -16.5F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(-2.0F, 0.0F, -9.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(25, 34).addBox(-3.0F, 2.0F, -9.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.5F, -6.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 54).addBox(-1.5F, -2.0F, -1.25F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(86, 119).addBox(-0.5F, 6.0F, -3.25F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 3.5F, -14.25F));

		PartDefinition LeftThigh = Bone.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(41, 0).mirror().addBox(-2.5F, -2.5F, -3.5F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.5F, -14.5F, 6.5F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 34).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 6.5F, 3.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(93, 44).mirror().addBox(-2.0F, 0.0F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 6.0F, 0.5F));

		PartDefinition RightThigh = Bone.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(41, 0).addBox(-2.5F, -2.5F, -3.5F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, -14.5F, 6.5F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 34).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.5F, 3.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(93, 44).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Jinzhousaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick) * 2.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, -14.5F, -6);
				this.RightThigh.y = Mth.lerp(sleepProgress, -14.5F, -7);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -14.5F, -7F);
				this.LeftFoot.z = Mth.lerp(sleepProgress, 0.5F, -1F);
				this.RightFoot.z = Mth.lerp(sleepProgress, 0.5F, -1F);
				this.Tail1.z = Mth.lerp(sleepProgress, 4.5F, 2.5F);
				this.Tail2.y = Mth.lerp(sleepProgress, -1, 0);
				this.Tail2.z = Mth.lerp(sleepProgress, 13, 12);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.55235987755982988F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -0.3490658503988659F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.7330382858376184F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.5585053606381855F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.7330382858376184F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.5585053606381855F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, -0.174188368183839F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.2330382858376184F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.4575712110370513F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.8377580409572781F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.3962634015954636F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.13962634015954636F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.13962634015954636F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.8377580409572781F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.5585053606381855F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.41887902047863906F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.41887902047863906F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.593411945678072F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 0.10471975511965977F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, -6F, -14.5F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -7F, -14.5F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -7F, -14.5F);
				this.LeftFoot.z = Mth.lerp(sleepProgress, -1F, 0.5F);
				this.RightFoot.z = Mth.lerp(sleepProgress, -1F, 0.5F);
				this.Tail1.z = Mth.lerp(sleepProgress, 2.5F, 4.5F);
				this.Tail2.y = Mth.lerp(sleepProgress, 0, -1);
				this.Tail2.z = Mth.lerp(sleepProgress, 12, 13);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.55235987755982988F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -0.3490658503988659F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.7330382858376184F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.5585053606381855F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.7330382858376184F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.5585053606381855F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.174188368183839F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.2330382858376184F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.4575712110370513F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.8377580409572781F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.3962634015954636F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.13962634015954636F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.13962634015954636F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.8377580409572781F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.5585053606381855F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.41887902047863906F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.41887902047863906F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.593411945678072F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0.10471975511965977F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
			} else {
				this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount + attackProgress * (float) Math.toRadians(15F);
				this.RightArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount + attackProgress * (float) Math.toRadians(15F);
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + attackProgress * (float) Math.toRadians(7F);
				this.RightLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.RightFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + attackProgress * (float) Math.toRadians(7F);
				this.LeftLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
				this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F);
				this.Head.xRot = attackProgress * (float) Math.toRadians(25F);
				this.Body.z = 7.5F + attackProgress;
				this.RightArm.z = -14.25F + attackProgress * -6F;
				this.LeftArm.z = -14.25F + attackProgress * -6F;
				this.RightThigh.z = 6.5F + attackProgress * -6F;
				this.LeftThigh.z = 6.5F + attackProgress * -6F;
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
					this.Body.xRot = 0.2F;
					this.LeftArm.zRot = -0.2F;
					this.RightArm.zRot = 0.2F;
				}
				if (entity.isInWater()) {
					this.Body.y = 17;
					this.LeftThigh.y = 17;
					this.RightThigh.y = 17;
					this.LeftArm.y = 24;
					this.RightArm.y = 24;
					this.LeftThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.RightFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.RightArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = -0.125F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}
	
	public void resetModel() {
		this.Body.y = -14.5F;
		this.Body.z = 7.5F;
		this.LeftArm.z = -14.25F;
		this.RightArm.z = -14.25F;
		this.RightThigh.z = 6.5F;
		this.LeftThigh.z = 6.5F;
		this.LeftThigh.y = -14.5F;
		this.RightThigh.y = -14.5F;
		this.LeftFoot.z = 0.5F;
		this.RightFoot.z = 0.5F;
		this.Tail1.z = 4.5F;
		this.Tail2.y = -1;
		this.Tail2.z = 13;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.Head.xRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.RightLeg.xRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftFoot.xRot = 0;
		this.RightFoot.xRot = 0;
	}
	
	public void sleepPose() {
		this.Body.y = -6;
		this.RightThigh.y = -7;
		this.LeftThigh.y = -7F;
		this.LeftFoot.z = -1F;
		this.RightFoot.z = -1F;
		this.Tail1.z = 2.5F;
		this.Tail2.y = 0;
		this.Tail2.z = 12;
		this.Neck.xRot = 0.55235987755982988F;
		this.Neck.yRot = -0.3490658503988659F;
		this.LeftThigh.xRot = -0.7330382858376184F;
		this.LeftThigh.yRot = 0.5585053606381855F;
		this.RightThigh.xRot = -0.7330382858376184F;
		this.RightThigh.yRot = -0.5585053606381855F;
		this.Head.xRot = -0.174188368183839F;
		this.LeftArm.xRot = -1.2330382858376184F;
		this.LeftArm.zRot = -0.4575712110370513F;
		this.LeftLeg.xRot = -0.8377580409572781F;
		this.RightArm.xRot = -1.3962634015954636F;
		this.RightArm.yRot = 0.13962634015954636F;
		this.RightArm.zRot = -0.13962634015954636F;
		this.RightLeg.xRot = -0.8377580409572781F;
		this.Tail1.xRot = -0.5585053606381855F;
		this.Tail1.yRot = 0.41887902047863906F;
		this.Tail2.xRot = 0.41887902047863906F;
		this.Tail2.yRot = 0.593411945678072F;
		this.Tail2.zRot = 0.10471975511965977F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.RightFoot.xRot = 1.5707963267948966F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}