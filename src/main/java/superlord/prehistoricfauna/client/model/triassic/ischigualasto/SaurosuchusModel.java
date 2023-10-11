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

public class SaurosuchusModel extends EntityModel<Saurosuchus> {
	private final ModelPart All;
	private final ModelPart Thigh;
	private final ModelPart Calf;
	private final ModelPart Foot;
	private final ModelPart Arm_1;
	private final ModelPart Thigh_1;
	private final ModelPart Calf_1;
	private final ModelPart Foot_1;
	private final ModelPart Body;
	private final ModelPart Tail;
	private final ModelPart Tail2;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart Arm;

	public SaurosuchusModel(ModelPart root) {
		this.All = root.getChild("All");
		this.Thigh = All.getChild("Thigh");
		this.Calf = Thigh.getChild("Calf");
		this.Foot = Calf.getChild("Foot");
		this.Arm_1 = All.getChild("Arm_1");
		this.Thigh_1 = All.getChild("Thigh_1");
		this.Calf_1 = Thigh_1.getChild("Calf_1");
		this.Foot_1 = Calf_1.getChild("Foot_1");
		this.Body = All.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.Jaw = Head.getChild("Jaw");
		this.Tail = Body.getChild("Tail");
		this.Tail2 = Tail.getChild("Tail2");
		this.Arm = All.getChild("Arm");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition All = partdefinition.addOrReplaceChild("All", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Thigh = All.addOrReplaceChild("Thigh", CubeListBuilder.create().texOffs(59, 0).addBox(-3.0F, -4.0F, -3.5F, 5.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -17.0F, 12.5F));

		PartDefinition Calf = Thigh.addOrReplaceChild("Calf", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 10.0F, 0.5F));

		PartDefinition Foot = Calf.addOrReplaceChild("Foot", CubeListBuilder.create().texOffs(83, 0).addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition Arm_1 = All.addOrReplaceChild("Arm_1", CubeListBuilder.create().texOffs(180, 19).mirror().addBox(-1.0F, 0.0F, -3.5F, 4.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -17.0F, -9.5F, 0.0F, -0.3054F, 0.0F));

		PartDefinition Thigh_1 = All.addOrReplaceChild("Thigh_1", CubeListBuilder.create().texOffs(11, 15).addBox(-2.0F, -4.0F, -3.5F, 5.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -17.0F, 12.5F));

		PartDefinition Calf_1 = Thigh_1.addOrReplaceChild("Calf_1", CubeListBuilder.create().texOffs(59, 19).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 10.0F, 0.5F));

		PartDefinition Foot_1 = Calf_1.addOrReplaceChild("Foot_1", CubeListBuilder.create().texOffs(98, 20).addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition Body = All.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -8.0F, -21.0F, 12.0F, 13.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 6.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(100, 23).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 9.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 14.0F, -0.1F, 0.0F, 0.0F));
		
		PartDefinition Tail2 = Tail.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 6.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 21.0F));

		PartDefinition osteos3 = Tail.addOrReplaceChild("osteos3", CubeListBuilder.create().texOffs(0, 84).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(97, 0).addBox(-4.0F, -4.0F, -10.0F, 8.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -20.0F, 0.0499F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(133, 0).addBox(-3.5F, -4.0F, -8.0F, 7.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -10.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(163, 0).addBox(-2.0F, -3.0F, -8.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -8.0F));

		PartDefinition SnoutTeeth = Snout.addOrReplaceChild("SnoutTeeth", CubeListBuilder.create().texOffs(180, 6).addBox(-1.5F, -1.0F, -8.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.1F, 0.1396F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(75, 12).addBox(-3.5F, 0.0F, -8.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition JawSnout = Jaw.addOrReplaceChild("JawSnout", CubeListBuilder.create().texOffs(125, 13).addBox(-2.0F, -1.0F, -7.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -9.0F));

		PartDefinition JawTeeth = JawSnout.addOrReplaceChild("JawTeeth", CubeListBuilder.create().texOffs(141, 13).addBox(-1.5F, -1.0F, -7.0F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.1F));

		PartDefinition Cheek = Jaw.addOrReplaceChild("Cheek", CubeListBuilder.create().texOffs(161, 13).addBox(-2.5F, -2.0F, -7.01F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.85F, 0.0F));

		PartDefinition Osteos2 = Neck.addOrReplaceChild("Osteos2", CubeListBuilder.create().texOffs(0, 101).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -10.0F));

		PartDefinition Osteos = Body.addOrReplaceChild("Osteos", CubeListBuilder.create().texOffs(0, 65).addBox(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -21.0F));

		PartDefinition Arm = All.addOrReplaceChild("Arm", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 0.0F, -3.5F, 4.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -17.0F, -9.5F, 0.0F, 0.3054F, 0.0F));

		return LayerDefinition.create(meshdefinition, 200, 200);
	}

	@Override
	public void setupAnim(Saurosuchus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		int sleepProgress = entity.getSleepTicks();
		int wakingProgress = entity.getWakingTicks();
		if (!entity.isWakingUp() && !entity.isFallingAsleep()) {
			if (!entity.isAsleep()) {
				resetModel();
			} else {
				this.Arm.y = 21.5F;
				this.Arm.xRot = -1.5707963267948966F;
				this.Arm_1.y = 21.5F;
				this.Arm_1.xRot = -1.5707963267948966F;
				this.Tail.xRot = -0.17453292519943295F;
				this.Tail.yRot = 0.6108652381980153F;
				this.Neck.xRot = 0.17453292519943295F;
				this.Tail2.z = 20;
				this.Tail2.yRot = 0.6108652381980153F;
				this.Body.y = 19.0F;
				this.Thigh.x = 3.5F;
				this.Thigh.y = 20.5F;
				this.Thigh.z = 17;
				this.Thigh.xRot = 1.5707963267948966F;
				this.Thigh.yRot = 0.6981317007977318F;
				this.Thigh_1.x = -3.5F;
				this.Thigh_1.y = 20.5F;
				this.Thigh_1.z = 17;
				this.Thigh_1.xRot = 1.5707963267948966F;
				this.Thigh_1.yRot = -0.6981317007977318F;
			}
		}
		if (wakingProgress != 0) {
			//Arm
//			this.Arm.y = 7.0F;
			if (this.Arm.y > 7) this.Arm.y -= 0.15;
			if (this.Arm.xRot < 0) this.Arm.xRot += 0.05;
			//Arm_1
//			this.Arm_1.y = 7.0F;
			if (this.Arm_1.y > 7) this.Arm_1.y -= 0.15;
			if (this.Arm_1.xRot < 0) this.Arm_1.xRot += 0.05;
			//Tail
			if (this.Tail.xRot < 0) this.Tail.xRot += 0.05;
			if (this.Tail.yRot > 0) this.Tail.yRot -= 0.05;
			//Neck
//			this.Neck.xRot = 0.0499F;
			if (this.Neck.xRot > 0.0499F) this.Neck.xRot -= 0.05;
			//Tail2
//			this.Tail2.z = 21.0F;
			if (this.Tail2.z < 21) this.Tail2.z += 0.15;
			if (this.Tail2.yRot > 0) this.Tail2.yRot -= 0.05;
			//Body
//				this.Body.y = 8.0F;
			if (this.Body.y > 8) this.Body.y -= 0.15;
			//Thigh
//			this.Thigh.x = -4;
//			this.Thigh.y = 7;
//			this.Thigh.z = 12.5F;
			if (this.Thigh.x > -4) this.Thigh.x -= 0.15;
			if (this.Thigh.y > 7) this.Thigh.y -= 0.15;
			if (this.Thigh.z > 12.5) this.Thigh.z -= 0.15;
			if (this.Thigh.xRot > 0) this.Thigh.xRot -= 0.05;
			if (this.Thigh.yRot > 0) this.Thigh.yRot -= 0.05;
			//Thigh_1
//			this.Thigh_1.x = 4;
//			this.Thigh_1.y = 7;
//			this.Thigh_1.z = 12.5F;
			if (this.Thigh_1.x < 4) this.Thigh_1.x += 0.15;
			if (this.Thigh_1.y > 7) this.Thigh_1.y -= 0.15;
			if (this.Thigh_1.z > 12.5) this.Thigh_1.z -= 0.15;
			if (this.Thigh_1.xRot > 0) this.Thigh_1.xRot -= 0.05;
			if (this.Thigh_1.yRot < 0) this.Thigh_1.yRot += 0.05;
		}
		this.Jaw.xRot = Math.abs(-0.1F * Mth.sin(0.1F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(25F);
		if(entity.isAsleep()) {
			if (sleepProgress != 0) {
				//Arm
//				this.Arm.y = 7.0F;
				if (this.Arm.y < 21.5) this.Arm.y += 0.15;
				if (this.Arm.xRot > -1.5707963267948966F) this.Arm.xRot -= 0.05;
				//Arm_1
//				this.Arm_1.y = 7.0F;
				if (this.Arm_1.y < 21.5) this.Arm_1.y += 0.15;
				if (this.Arm_1.xRot > -1.5707963267948966F) this.Arm_1.xRot -= 0.05;
				//Tail
				if (this.Tail.xRot > -0.17453292519943295F) this.Tail.xRot -= 0.05;
				if (this.Tail.yRot < 0.6108652381980153F) this.Tail.yRot += 0.05;
				//Neck
//				this.Neck.xRot = 0.0499F;
				if (this.Neck.xRot < 0.17453292519943295F) this.Neck.xRot += 0.05;
				//Tail2
//				this.Tail2.z = 21.0F;
				if (this.Tail2.z > 20) this.Tail2.z -= 0.15;
				if (this.Tail2.yRot < 0.6108652381980153F) this.Tail2.yRot += 0.05;
				//Body
 //				this.Body.y = 8.0F;
				if (this.Body.y < 19) this.Body.y += 0.15;
				//Thigh
//				this.Thigh.x = -4;
//				this.Thigh.y = 7;
//				this.Thigh.z = 12.5F;
				if (this.Thigh.x < 3.5) this.Thigh.x += 0.15;
				if (this.Thigh.y < 20.5) this.Thigh.y += 0.15;
				if (this.Thigh.z < 17) this.Thigh.z += 0.15;
				if (this.Thigh.xRot < 1.5707963267948966F) this.Thigh.xRot += 0.05;
				if (this.Thigh.yRot < 0.6981317007977318F) this.Thigh.yRot += 0.05;
				//Thigh_1
//				this.Thigh_1.x = 4;
//				this.Thigh_1.y = 7;
//				this.Thigh_1.z = 12.5F;
				if (this.Thigh_1.x > -3.5) this.Thigh_1.x -= 0.15;
				if (this.Thigh_1.y < 20.5) this.Thigh_1.y += 0.15;
				if (this.Thigh_1.z < 17) this.Thigh_1.z += 0.15;
				if (this.Thigh_1.xRot < 1.5707963267948966F) this.Thigh_1.xRot += 0.05;
				if (this.Thigh_1.yRot > -0.6981317007977318F) this.Thigh_1.yRot -= 0.05;
			}
		} else {
			if (entity.getDeltaMovement().x !=  0 && entity.getDeltaMovement().y != 0 && entity.getDeltaMovement().z != 0) {
				this.Head.xRot = 0;
				this.Neck.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.08F * limbSwingAmount;
				this.Head.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount + 0.05F;
				this.Arm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
				this.Arm_1.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
				this.Thigh.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
				this.Calf.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
				this.Foot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
				this.Thigh_1.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
				this.Calf_1.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
				this.Foot_1.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
				this.Tail.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1F;
				this.Tail.yRot = Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * -0.15F * limbSwingAmount;
				this.Tail2.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.05F;
				this.Tail2.yRot = Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * -0.15F * limbSwingAmount;
				this.Body.y = Mth.cos(-1.0F + limbSwing * 0.3F) * 0.5F * limbSwingAmount + 8;
			} else {
				this.Arm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
				this.Arm_1.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
				this.Thigh.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
				this.Calf.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
				this.Foot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
				this.Thigh_1.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
				this.Calf_1.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount;
				this.Foot_1.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount;
				this.Tail.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * -0.15F * limbSwingAmount);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * -0.15F * limbSwingAmount);
				this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1F);
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * -0.15F * limbSwingAmount);
				this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
				this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.08F * limbSwingAmount);
				this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount + 0.05F);
				if (entity.isInWater()) {
					this.Body.y = 20;
					this.Thigh.y = 19;
					this.Thigh_1.y = 19;
					this.Arm.y = 21;
					this.Arm_1.y = 21;
					this.Thigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Thigh_1.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Calf.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Calf_1.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Foot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.Foot_1.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.Arm_1.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Arm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = -0.25F;
					this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Arm.y = 7.0F;
		this.Arm.xRot = 0;
		this.Arm_1.y = 7.0F;
		this.Arm_1.xRot = 0;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Neck.xRot = 0.0499F;
		this.Tail2.z = 21.0F;
		this.Tail2.yRot = 0;
		this.Tail2.xRot = 0;
		this.Body.y = 8.0F;
		this.Body.xRot = 0;
		this.Calf.x = -0.5F;
		this.Calf.z = 0.5F;
		this.Thigh.xRot = 0;
		this.Thigh.yRot = 0;
		this.Thigh_1.xRot = 0;
		this.Thigh_1.yRot = 0;
		this.Thigh_1.x = 4;
		this.Thigh_1.y = 7;
		this.Thigh_1.z = 12.5F;
		this.Thigh.x = -4;
		this.Thigh.y = 7;
		this.Thigh.z = 12.5F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Thigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Arm_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Thigh_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}