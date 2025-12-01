package superlord.prehistoricfauna.client.model.jurassic.shaximiao;

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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Huayangosaurus;

public class HuayangosaurusModel extends EntityModel<Huayangosaurus> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart LeftArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart RightArm;

	public HuayangosaurusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.LeftThigh = this.Body.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = this.Body.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.RightArm = this.Body.getChild("RightArm");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -5.0F, -3.0F, 10.0F, 10.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(0, 30).addBox(-2.0F, -9.0F, -1.0F, 4.0F, 4.0F, 19.0F, new CubeDeformation(0.0F))
				.texOffs(-8, 30).addBox(5.0F, -1.0F, -2.0F, 4.0F, 0.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(-8, 30).mirror().addBox(-9.0F, -1.0F, -2.0F, 4.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 9.0F, -7.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(40, 7).addBox(-1.5F, -2.0F, -8.0F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(0, 41).addBox(-1.0F, -4.0F, -7.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -3.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 14).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -8.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(64, 0).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 5.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(27, 34).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 17.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(57, 20).addBox(-1.0F, -0.99F, -1.0F, 2.0F, 3.0F, 21.0F, new CubeDeformation(0.0F))
				.texOffs(43, 32).addBox(-0.5F, -3.0F, 2.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 11.0F));

		PartDefinition cube_r1 = Tail2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(22, 30).mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, 14.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r2 = Tail2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(22, 30).addBox(0.0F, 0.0F, 0.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 14.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(61, 17).addBox(-2.0F, -1.0F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 3.0F, -0.5F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 53).addBox(-3.0F, -2.0F, -3.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -1.0F, 13.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(43, 32).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 7.0F, 0.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(58, 36).addBox(-2.5F, 0.0F, -2.501F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 53).mirror().addBox(-1.0F, -2.0F, -3.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -1.0F, 13.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(43, 32).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 7.0F, 0.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(58, 36).mirror().addBox(-2.5F, 0.0F, -2.501F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(61, 17).mirror().addBox(-1.0F, -1.0F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, 3.0F, -0.5F));

		return LayerDefinition.create(meshdefinition, 103, 68);
	}

	@Override
	public void setupAnim(Huayangosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 9, 18.5F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.45235987755982988F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -0.3490658503988659F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, 0.3748F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.2585053606381855F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, 0.3748F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.2585053606381855F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, -0.174188368183839F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.4330382858376184F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.4575712110370513F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, 1.1345F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.4962634015954636F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.13962634015954636F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.13962634015954636F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 1.1345F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.15F, -0.4585053606381855F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.41887902047863906F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.31887902047863906F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.493411945678072F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 0.10471975511965977F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 18.5F, 9);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.45235987755982988F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -0.3490658503988659F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0.3748F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.2585053606381855F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0.3748F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.2585053606381855F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.174188368183839F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.4330382858376184F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.4575712110370513F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 1.1345F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.4962634015954636F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.13962634015954636F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.13962634015954636F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 1.1345F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.4585053606381855F, -0.15F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.41887902047863906F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.31887902047863906F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.493411945678072F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0.10471975511965977F, 0);
			} else {
				this.RightArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.RightFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount) + attackProgress * leftOrRight * (float) Math.toRadians(30F);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount) + attackProgress * leftOrRight * (float) Math.toRadians(30F);
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * -0.15F * limbSwingAmount - 0.15F);
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount);
				this.Tail2.zRot = attackProgress * leftOrRight * (float)Math.toRadians(30F);
				this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (headPitch * ((float) Math.PI / 180F));
				this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
					this.Body.xRot = 0.2F;
					this.LeftArm.zRot = 0.3F;
					this.RightArm.zRot = -0.3F;
				}
				if (entity.isInWater()) {
					this.Body.y = 18;
					this.Body.xRot = -0.125F;
					this.Tail1.xRot = 0.0625F;
					this.Tail2.xRot = 0.0625F;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = 0.125F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Neck.x = 0;
		this.Neck.y = -1F;
		this.Neck.z = -3;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.LeftFoot.xRot = 0;
		this.LeftFoot.yRot = 0;
		this.LeftFoot.zRot = 0;
		this.LeftThigh.x = 5F;
		this.LeftThigh.y = -1;
		this.LeftThigh.z = 13F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.RightArm.y = 3;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.zRot = 0;
		this.Tail1.y = -3;
		this.Tail1.z = 17;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Body.x = 0;
		this.Body.y = 9;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.RightThigh.y = -1.0F;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.Head.xRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftArm.y = 3.0F;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
	}

	public void sleepPose() {
		this.Body.y = 18.5F;
		this.Neck.xRot = 0.45235987755982988F;
		this.Neck.yRot = -0.3490658503988659F;
		this.LeftThigh.xRot = 0.3748F;
		this.LeftThigh.yRot = 0.2585053606381855F;
		this.RightThigh.xRot = 0.3748F;
		this.RightThigh.yRot = -0.2585053606381855F;
		this.Head.xRot = -0.174188368183839F;
		this.LeftArm.xRot = -1.4330382858376184F;
		this.LeftArm.zRot = -0.4575712110370513F;
		this.LeftLeg.xRot = 1.1345F;
		this.RightArm.xRot = -1.4962634015954636F;
		this.RightArm.yRot = 0.13962634015954636F;
		this.RightArm.zRot = -0.13962634015954636F;
		this.RightLeg.xRot = 1.1345F;
		this.Tail1.xRot = -0.4585053606381855F;
		this.Tail1.yRot = 0.41887902047863906F;
		this.Tail2.xRot = 0.31887902047863906F;
		this.Tail2.yRot = 0.493411945678072F;
		this.Tail2.zRot = 0.10471975511965977F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
