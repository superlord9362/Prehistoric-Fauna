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
	private final ModelPart Main;
	private final ModelPart Hips;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Chest;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;


	public JinzhousaurusModel(ModelPart root) {
		this.Main = root.getChild("Main");
		this.Hips = this.Main.getChild("Hips");
		this.Tail1 = this.Hips.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.Chest = this.Hips.getChild("Chest");
		this.Neck = this.Chest.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.RightArm = this.Chest.getChild("RightArm");
		this.LeftArm = this.Chest.getChild("LeftArm");
		this.RightThigh = this.Main.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftThigh = this.Main.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");

	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Main = partdefinition.addOrReplaceChild("Main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Hips = Main.addOrReplaceChild("Hips", CubeListBuilder.create().texOffs(67, 64).addBox(-7.0F, -22.5F, -10.5F, 14.0F, 21.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(67, 87).addBox(0.0F, -25.5F, -10.5F, 0.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.5F, 7.5F));

		PartDefinition Tail1 = Hips.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(123, 47).addBox(-3.5F, -5.0F, -1.0F, 7.0F, 10.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(123, 60).addBox(0.0F, -8.0F, 0.0F, 0.0F, 3.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -15.5F, 13.5F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(125, 10).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(125, 19).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 23.0F));

		PartDefinition Chest = Hips.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(6, 74).addBox(-6.0F, -7.001F, -17.0F, 12.0F, 18.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(7, 94).addBox(0.0F, -10.0F, -17.0F, 0.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.5F, -9.5F));

		PartDefinition Neck = Chest.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(18, 113).addBox(-2.5F, -4.5F, -13.0F, 5.0F, 9.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(21, 126).addBox(0.0F, -6.5F, -11.0F, 0.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -17.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(26, 141).addBox(-3.0F, -1.001F, -4.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(25, 153).addBox(-2.0F, -1.001F, -11.0F, 4.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(30, 166).addBox(-2.5F, 1.999F, -11.001F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.5F, -12.0F));

		PartDefinition RightArm = Chest.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(89, 121).mirror().addBox(-1.5F, -3.0F, -2.5F, 4.0F, 21.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(93, 149).addBox(0.5F, 13.0F, -4.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 9.0F, -12.5F));

		PartDefinition LeftArm = Chest.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(66, 121).mirror().addBox(-2.5F, -3.0F, -2.5F, 4.0F, 21.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(70, 149).addBox(-1.5F, 13.0F, -4.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 9.0F, -12.5F));

		PartDefinition RightThigh = Main.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(43, 37).addBox(-4.0F, -4.5F, -6.5F, 7.0F, 19.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -27.5F, 10.5F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(50, 15).addBox(-3.5F, -1.0F, -4.0F, 5.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 12.5F, 4.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(48, 4).addBox(-3.0F, 0.0F, -6.0F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 12.0F, -1.0F));

		PartDefinition LeftThigh = Main.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(2, 37).addBox(-3.0F, -4.5F, -6.5F, 7.0F, 19.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -27.5F, 10.5F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(9, 14).addBox(-1.5F, -1.0F, -4.0F, 5.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 12.5F, 4.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(7, 2).addBox(-3.0F, 0.0F, -6.0F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 12.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 185, 191);

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
				this.Hips.y = Mth.lerp(sleepProgress, -14.5F, -3);
				this.RightThigh.y = Mth.lerp(sleepProgress, -27.5F, -17);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -27.5F, -17F);
				this.Tail1.z = Mth.lerp(sleepProgress, 13.5F, 10.5F);
				this.Tail2.y = Mth.lerp(sleepProgress, -2, 0);
				this.Tail2.z = Mth.lerp(sleepProgress, 23, 24);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.15F, 0.35235987755982988F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -0.3490658503988659F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, 0.3748F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.1591F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, 0.3748F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, 0.1591F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, -0.174188368183839F);
				this.Chest.xRot = Mth.lerp(sleepProgress, 0, 0.16F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.4330382858376184F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.4575712110370513F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, 1.1345F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.5962634015954636F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.13962634015954636F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.13962634015954636F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, 1.1345F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.15F, -0.5585053606381855F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.41887902047863906F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.15F, 0.41887902047863906F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.593411945678072F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 0.10471975511965977F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Hips.y = Mth.lerp(sleepProgress, -3, -14.5F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -17, -27.5F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -17, -27.5F);
				this.Tail1.z = Mth.lerp(sleepProgress, 10.5F, 13.5F);
				this.Tail2.y = Mth.lerp(sleepProgress, 0, -2);
				this.Tail2.z = Mth.lerp(sleepProgress, 24, 23);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.35235987755982988F, 0.15F);
				this.Neck.yRot = Mth.lerp(sleepProgress, -0.3490658503988659F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0.3748F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.1591F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0.3748F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0.1591F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.174188368183839F, 0);
				this.Chest.xRot = Mth.lerp(sleepProgress, 0.16F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.4330382858376184F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.4575712110370513F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 1.1345F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.5962634015954636F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.13962634015954636F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.13962634015954636F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 1.1345F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.5585053606381855F, -0.15F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.41887902047863906F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.41887902047863906F, 0.15F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.593411945678072F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0.10471975511965977F, 0);
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
				this.Hips.z = 7.5F + attackProgress;
				this.RightArm.z = -12.5F + attackProgress * -6F;
				this.LeftArm.z = -12.5F + attackProgress * -6F;
				this.RightThigh.z = 10.5F + attackProgress * -6F;
				this.LeftThigh.z = 10.5F + attackProgress * -6F;
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
					this.Hips.xRot = 0.2F;
					this.LeftArm.zRot = -0.2F;
					this.RightArm.zRot = 0.2F;
				}
				if (entity.isInWater()) {
					this.Main.y = 43;
					this.LeftThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.RightFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.RightArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = -0.125F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 0.26662F) * 0.7F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 0.26662F) * 0.7F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}
	
	public void resetModel() {
		this.Main.y = 24;
		this.Hips.y = -14.5F;
		this.Hips.z = 7.5F;
		this.LeftArm.z = -12.5F;
		this.RightArm.z = -12.5F;
		this.RightThigh.z = 10.5F;
		this.LeftThigh.z = 10.5F;
		this.LeftThigh.y = -27.5F;
		this.RightThigh.y = -27.5F;
		this.LeftFoot.z = -1F;
		this.RightFoot.z = -1F;
		this.Tail1.z = 13.5F;
		this.Tail2.y = -2;
		this.Tail2.z = 23;
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
		this.Chest.xRot = 0;
	}
	
	public void sleepPose() {
		this.Hips.y = -3;
		this.RightThigh.y = -17;
		this.LeftThigh.y = -17F;
		this.Tail1.z = 10.5F;
		this.Tail2.y = 0;
		this.Tail2.z = 24;
		this.Neck.xRot = 0.35235987755982988F;
		this.Neck.yRot = -0.3490658503988659F;
		this.LeftThigh.xRot = 0.3748F;
		this.LeftThigh.yRot = -0.1591F;
		this.RightThigh.xRot = 0.3748F;
		this.RightThigh.yRot = 0.1591F;
		this.Head.xRot = -0.174188368183839F;
		this.Chest.xRot = 0.16F;
		this.LeftArm.xRot = -1.4330382858376184F;
		this.LeftArm.zRot = -0.4575712110370513F;
		this.LeftLeg.xRot = 1.1345F;
		this.RightArm.xRot = -1.5962634015954636F;
		this.RightArm.yRot = 0.13962634015954636F;
		this.RightArm.zRot = -0.13962634015954636F;
		this.RightLeg.xRot = 1.1345F;
		this.Tail1.xRot = -0.5585053606381855F;
		this.Tail1.yRot = 0.41887902047863906F;
		this.Tail2.xRot = 0.41887902047863906F;
		this.Tail2.yRot = 0.593411945678072F;
		this.Tail2.zRot = 0.10471975511965977F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}