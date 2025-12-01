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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Sinraptor;

public class SinraptorBabyModel extends EntityModel<Sinraptor> {
	private final ModelPart Body;
	private final ModelPart Tail;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;

	public SinraptorBabyModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Tail = this.Body.getChild("Tail");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.LeftThigh = this.Body.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = this.Body.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 19).addBox(-2.5F, -6.0F, -5.0F, 5.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(1, 1).addBox(-1.0F, -0.9F, 0.0F, 2.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 6.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(34, 19).addBox(-1.0F, -4.75F, -4.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.25F, -4.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(36, 9).mirror().addBox(-1.0F, -2.0F, -1.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(36, 0).addBox(-0.5F, -2.0F, -6.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -2.75F, -4.5F, -0.0436F, 0.0F, 0.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(34, 30).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -3.0F, 4.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(1, 2).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 2.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(37, 16).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(34, 30).mirror().addBox(-1.0F, -2.0F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, -3.0F, 4.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(1, 2).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 2.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(37, 16).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(12, 38).addBox(0.0F, 0.0F, -1.75F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -1.0F, -3.25F, 0.0F, 0.0F, -0.2182F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(12, 38).mirror().addBox(0.0F, 0.0F, -1.5F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, -1.0F, -3.5F, 0.0F, 0.0F, 0.2182F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Sinraptor entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5708F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.7226682992F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5708F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.7226682992F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.3491F, 0.61887902047863906F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -1.0471975511965976F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.6981317007977318F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, 0.3490658503988659F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.17453292519943295F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.6981317007977318F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.5235987755982988F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, 0.4330382858376184F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0.0873F, 0.24434609527920614F);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0, -0.22453292519943295F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, 0.593411945678072F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, 0.4283185307179586F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.0873F, -0.24434609527920614F);
				this.Body.y = Mth.lerp(sleepProgress, 18, 21.4F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5708F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.7226682992F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5708F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.7226682992F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.61887902047863906F, 0.3491F);
				this.Neck.yRot = Mth.lerp(sleepProgress, -1.0471975511965976F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.6981317007977318F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0.3490658503988659F, 0);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.17453292519943295F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.6981317007977318F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.5235987755982988F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.4330382858376184F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0.24434609527920614F, 0.0873F);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.22453292519943295F, 0);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0.593411945678072F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.4283185307179586F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.24434609527920614F, -0.0873F);
				this.Body.y = Mth.lerp(sleepProgress, 21.4F, 18);
			} else {
				float speed = 0.8f;
				float degree = 1.0f;
				this.Neck.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.0873F;
				this.Body.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.Tail.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.15F;
				this.Tail.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.2F * limbSwingAmount;
				this.Head.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.0436F;
				this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
				this.RightArm.xRot = Mth.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
				this.RightFoot.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
				if (entity.isInWater()) {
					this.Body.y = 23;
					this.Body.xRot = -0.125F;
					this.Tail.xRot = 0.0625F;
					this.Neck.xRot = 0.125F;
					this.LeftThigh.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftFoot.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.125F;
					this.LeftArm.xRot = 0.125F;
					this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.LeftFoot.xRot = 0;
		this.Head.xRot = -0.0436F;
		this.Head.yRot = 0;
		this.RightFoot.xRot = 0;
		this.RightFoot.yRot = 0;
		this.RightFoot.zRot = -0;
		this.Neck.xRot = 0.0873F;
		this.Neck.yRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.Body.xRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0.2182F;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = -0.2182F;
		this.Tail.y = -5;
		this.Body.y = 18F;
		this.Neck.x = 0;
		this.Neck.y = -3.25F;
		this.Neck.z = -4;
		this.Head.x = -0.5F;
		this.Head.y = -2.75F;
		this.Head.z = -4.5F;
		this.LeftArm.x = 2.5F;
		this.LeftArm.z = -3.25F;
		this.RightArm.x = -2.5F;
		this.RightArm.z = -3.25F;
		this.LeftThigh.x = 2.5F;
		this.LeftThigh.y = -3F;
		this.LeftFoot.y = 4F;
		this.LeftFoot.z = 0;
		this.RightThigh.x = -2.5F;
		this.RightThigh.y = -3F;
		this.RightFoot.y = 4F;
		this.RightFoot.z = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
	}

	public void sleepPose() {
		this.RightFoot.xRot = 1.5708F;
		this.RightLeg.xRot = -0.7226682992F;
		this.LeftFoot.xRot = 1.5708F;
		this.LeftLeg.xRot = -0.7226682992F;
		this.Neck.xRot = 0.61887902047863906F;
		this.Neck.yRot = -1.0471975511965976F;
		this.RightThigh.xRot = -0.6981317007977318F;
		this.RightThigh.yRot = 0.3490658503988659F;
		this.Body.xRot = -0.17453292519943295F;
		this.LeftThigh.xRot = -0.6981317007977318F;
		this.LeftThigh.yRot = -0.5235987755982988F;
		this.RightArm.xRot = 0.4330382858376184F;
		this.RightArm.zRot = 0.24434609527920614F;
		this.Tail.xRot = -0.22453292519943295F;
		this.Tail.yRot = 0.593411945678072F;
		this.LeftArm.xRot = 0.4283185307179586F;
		this.LeftArm.zRot = -0.24434609527920614F;
		this.Body.y = 21.4F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
