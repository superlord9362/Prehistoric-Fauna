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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Yangchuanosaurus;

public class YangchuanosaurusBabyModel extends EntityModel<Yangchuanosaurus> {
	private final ModelPart root;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;

	public YangchuanosaurusBabyModel(ModelPart root) {
		this.root = root.getChild("root");
		this.Body = this.root.getChild("Body");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.RightThigh = this.root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftThigh = this.root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -6.0F, 4.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.5F, 0.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(24, 19).addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.0F, -4.0F, 0.2618F, 0.0F, -0.1745F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(24, 19).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 1.0F, -4.0F, 0.2618F, 0.0F, 0.1745F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -5.5F, -1.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -7.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(3, 18).addBox(-1.5F, -1.0F, -5.5F, 3.0F, 4.0F, 7.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.0F, -4.5F, -1.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(18, 0).addBox(-1.5F, -0.975F, 0.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 3.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(26, 6).addBox(-1.0F, -0.475F, -2.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.475F, 6.0F));

		PartDefinition RightThigh = root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(31, 19).addBox(-1.0F, -1.0F, -1.525F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, -8.0F, 1.5F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(34, 28).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 1.475F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(21, 28).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition LeftThigh = root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(31, 19).mirror().addBox(-1.0F, -1.0F, -1.525F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.75F, -8.0F, 1.5F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(34, 28).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 1.475F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(21, 28).mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 50, 32);
	}

	@Override
	public void setupAnim(Yangchuanosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Head.xRot = Mth.lerp(sleepProgress, -0.1F, 0.41887902047863906F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5708F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.8726682992F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5708F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.8726682992F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.25F, 0.41887902047863906F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -1.0471975511965976F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.6981317007977318F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.3490658503988659F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.17453292519943295F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.1F, 0.14434609527920614F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.41887902047863906F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 0.17453292519943295F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.6981317007977318F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.5235987755982988F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.25F, 0.7330382858376184F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.5235987755982988F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.24434609527920614F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.15F, -0.27453292519943295F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.593411945678072F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.25F, 0.6283185307179586F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.5235987755982988F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 0.24434609527920614F);
				this.Body.y = Mth.lerp(sleepProgress, -7.5F, -3.5F);
				this.Tail2.x = Mth.lerp(sleepProgress, 0, 0.5F);
				this.Tail2.z = Mth.lerp(sleepProgress, 6, 7);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -8, -4F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -8, -4F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Head.xRot = Mth.lerp(sleepProgress, 0.41887902047863906F, -0.1F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5708F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.8726682992F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5708F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.8726682992F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.41887902047863906F, 0.25F);
				this.Neck.yRot = Mth.lerp(sleepProgress, -1.0471975511965976F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.6981317007977318F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.3490658503988659F, 0);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.17453292519943295F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.14434609527920614F, 0.1F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.41887902047863906F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0.17453292519943295F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.6981317007977318F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.5235987755982988F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.7330382858376184F, 0.25F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.5235987755982988F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.24434609527920614F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.27453292519943295F, -0.15F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.593411945678072F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.6283185307179586F, 0.25F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.5235987755982988F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0.24434609527920614F, 0);
				this.Body.y = Mth.lerp(sleepProgress, -3.5F, -7.5F);
				this.Tail2.x = Mth.lerp(sleepProgress, 0.5F, 0F);
				this.Tail2.z = Mth.lerp(sleepProgress, 7, 6);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -4, -8F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -4, -8F);
			} else {
				float speed = 0.8f;
				float degree = 1.0f;
				this.Neck.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.25F;
				this.Body.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.15F;
				this.Tail2.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.1F;
				this.Tail1.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.2F * limbSwingAmount;
				this.Tail2.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.25F * limbSwingAmount;
				this.Head.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.1F;
				this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
				this.RightArm.xRot = Mth.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
				this.RightFoot.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
				if (entity.isInWater()) {
					this.LeftThigh.y = -4.5F;
					this.RightThigh.y = -4.5F;
					this.Body.y = -4;
					this.Body.xRot = -0.125F;
					this.Tail1.xRot = -0.0625F;
					this.Tail2.xRot = 0.0625F;
					this.Neck.xRot = 0.25F;
					this.LeftThigh.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftFoot.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.125F;
					this.LeftArm.xRot = 0.125F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.LeftFoot.xRot = 0;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.RightFoot.xRot = 0;
		this.RightFoot.yRot = 0;
		this.RightFoot.zRot = -0;
		this.Neck.xRot = 0.1047F;
		this.Neck.yRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.Body.xRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.RightArm.xRot = 0.1396F;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = -0.1047F;
		this.Tail1.xRot = -0.04555309164612875F;
		this.Tail1.yRot = 0;
		this.LeftArm.xRot = 0.1396F;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0.1047F;
		this.Tail1.y = -3;
		this.Body.y = -7.5F;
		this.Tail2.x = 0;
		this.Tail2.z = 6;
		this.Neck.x = 0;
		this.Neck.y = 0;
		this.Neck.z = -7;
		this.Head.x = 0;
		this.Head.y = -4.5F;
		this.Head.z = -1F;
		this.LeftArm.x = -2F;
		this.LeftArm.z = -4F;
		this.RightArm.x = 2F;
		this.RightArm.z = -4F;
		this.LeftThigh.x = -1.75F;
		this.LeftThigh.y = -8F;
		this.LeftFoot.y = 4F;
		this.LeftFoot.z = 0;
		this.RightThigh.x = 1.75F;
		this.RightThigh.y = -8.F;
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
		this.Head.xRot = 0.41887902047863906F;
		this.RightFoot.xRot = 1.5708F;
		this.RightLeg.xRot = -0.8726682992F;
		this.LeftFoot.xRot = 1.5708F;
		this.LeftLeg.xRot = -0.8726682992F;
		this.Neck.xRot = 0.41887902047863906F;
		this.Neck.yRot = -1.0471975511965976F;
		this.RightThigh.xRot = -0.6981317007977318F;
		this.RightThigh.yRot = -0.3490658503988659F;
		this.Body.xRot = -0.17453292519943295F;
		this.Tail2.xRot = 0.14434609527920614F;
		this.Tail2.yRot = 0.41887902047863906F;
		this.Tail2.zRot = 0.17453292519943295F;
		this.LeftThigh.xRot = -0.6981317007977318F;
		this.LeftThigh.yRot = 0.5235987755982988F;
		this.RightArm.xRot = 0.7330382858376184F;
		this.RightArm.yRot = 0.5235987755982988F;
		this.RightArm.zRot = -0.24434609527920614F;
		this.Tail1.xRot = -0.27453292519943295F;
		this.Tail1.yRot = 0.593411945678072F;
		this.LeftArm.xRot = 0.6283185307179586F;
		this.LeftArm.yRot = -0.5235987755982988F;
		this.LeftArm.zRot = 0.24434609527920614F;
		this.Body.y = -3.5F;
		this.Tail2.x = 0.5F;
		this.Tail2.z = 7;
		this.LeftThigh.y = -4F;
		this.RightThigh.y = -4F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
