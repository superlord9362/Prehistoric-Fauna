package superlord.prehistoricfauna.client.model.triassic.chinle;

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
import superlord.prehistoricfauna.common.entity.triassic.chinle.Desmatosuchus;

public class DesmatosuchusModel extends EntityModel<Desmatosuchus> {
	private final ModelPart Arm_L;
	private final ModelPart ASS;
	private final ModelPart Belly;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail_base;
	private final ModelPart Tail_tip;
	private final ModelPart Arm_R;
	private final ModelPart Leg_L_1;
	private final ModelPart Leg_L_2;
	private final ModelPart Feet_L;
	private final ModelPart Leg_L_1_1;
	private final ModelPart Leg_L_2_1;
	private final ModelPart Feet_L_1;

	public DesmatosuchusModel(ModelPart root) {
		this.Arm_L = root.getChild("Arm_L");
		this.ASS = root.getChild("ASS");
		this.Belly = ASS.getChild("Belly");
		this.Neck = Belly.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.Tail_base = ASS.getChild("Tail_base");
		this.Tail_tip = Tail_base.getChild("Tail_tip");
		this.Arm_R = root.getChild("Arm_R");
		this.Leg_L_1 = root.getChild("Leg_L_1");
		this.Leg_L_2 = Leg_L_1.getChild("Leg_L_2");
		this.Feet_L = Leg_L_2.getChild("Feet_L");
		this.Leg_L_1_1 = root.getChild("Leg_L_1_1");
		this.Leg_L_2_1 = Leg_L_1_1.getChild("Leg_L_2_1");
		this.Feet_L_1 = Leg_L_2_1.getChild("Feet_L_1");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Arm_L = partdefinition.addOrReplaceChild("Arm_L", CubeListBuilder.create().texOffs(44, 32).mirror().addBox(-2.0F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 11.0F, -7.5F));

		PartDefinition ASS = partdefinition.addOrReplaceChild("ASS", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, -4.0F, 0.0F, 13.0F, 10.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition Belly = ASS.addOrReplaceChild("Belly", CubeListBuilder.create().texOffs(0, 25).addBox(-4.5F, -3.0F, -10.0F, 9.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -1.0F));

		PartDefinition Belly_spikes = Belly.addOrReplaceChild("Belly_spikes", CubeListBuilder.create().texOffs(32, 53).addBox(-9.0F, -2.5F, -11.0F, 18.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition Neck = Belly.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(43, 1).addBox(-2.0F, -1.0F, -6.0F, 4.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -9.5F, 0.15F, 0.0F, 0.0F));

		PartDefinition Neck_spikes = Neck.addOrReplaceChild("Neck_spikes", CubeListBuilder.create().texOffs(55, 48).addBox(-4.5F, 0.0F, -4.0F, 9.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -2.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(65, 11).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.05F, 0.0F, 0.0F));

		PartDefinition Nose = Head.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(67, 1).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

		PartDefinition part8 = Nose.addOrReplaceChild("part8", CubeListBuilder.create().texOffs(68, 19).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 1.0F, 0.0F, -0.0017F, 0.0F));

		PartDefinition Back_spikes = ASS.addOrReplaceChild("Back_spikes", CubeListBuilder.create().texOffs(40, 64).addBox(-8.0F, 0.0F, -0.5F, 16.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 1.0F));

		PartDefinition Tail_base = ASS.addOrReplaceChild("Tail_base", CubeListBuilder.create().texOffs(0, 77).addBox(-3.5F, -3.0F, 0.0F, 7.0F, 7.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 12.0F, -0.15F, 0.0F, 0.0F));

		PartDefinition Tail_tip = Tail_base.addOrReplaceChild("Tail_tip", CubeListBuilder.create().texOffs(0, 102).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 4.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 13.0F, 0.15F, 0.0F, 0.0F));

		PartDefinition Arm_R = partdefinition.addOrReplaceChild("Arm_R", CubeListBuilder.create().texOffs(44, 32).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 11.0F, -7.5F));

		PartDefinition Leg_L_1 = partdefinition.addOrReplaceChild("Leg_L_1", CubeListBuilder.create().texOffs(0, 45).mirror().addBox(-5.0F, 0.0F, -2.0F, 5.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, 8.0F, 10.0F));

		PartDefinition Leg_L_2 = Leg_L_1.addOrReplaceChild("Leg_L_2", CubeListBuilder.create().texOffs(24, 51).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.8F, 9.0F, 1.0F));

		PartDefinition Feet_L = Leg_L_2.addOrReplaceChild("Feet_L", CubeListBuilder.create().texOffs(0, 61).mirror().addBox(-2.2F, 0.0F, -5.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition Leg_L_1_1 = partdefinition.addOrReplaceChild("Leg_L_1_1", CubeListBuilder.create().texOffs(0, 45).addBox(0.0F, 0.0F, -2.0F, 5.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 8.0F, 10.0F));

		PartDefinition Leg_L_2_1 = Leg_L_1_1.addOrReplaceChild("Leg_L_2_1", CubeListBuilder.create().texOffs(24, 51).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.9F, 9.0F, 1.0F));

		PartDefinition Feet_L_1 = Leg_L_2_1.addOrReplaceChild("Feet_L_1", CubeListBuilder.create().texOffs(0, 61).addBox(-2.2F, 0.0F, -5.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 80, 160);
	}

	@Override
	public void setupAnim(Desmatosuchus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick) * 2.0F;
		int sleepProgress = entity.getSleepTicks();
		int wakingProgress = entity.getWakingTicks();
		if (!entity.isWakingUp() && !entity.isFallingAsleep()) {
			if (!entity.isAsleep()) {
				resetModel();
			} else {
				this.Feet_L.y = 5.2F;
				this.Feet_L.z = -1;
				this.Feet_L.xRot = 0.41887902047863906F;
				this.Feet_L.zRot = 0.17453292519943295F;
				this.Leg_L_1_1.x = 3.5F;
				this.Leg_L_1_1.y = 20.4F;
				this.Leg_L_1_1.xRot = -2.234021442552742F;
				this.Leg_L_1_1.yRot = -0.3490658503988659F;
				this.Leg_L_1_1.zRot = 0.17453292519943295F;
				this.Arm_R.x = 4.5F;
				this.Arm_R.y = 21.5F;
				this.Arm_R.z = -3.5F;
				this.Arm_R.xRot = -1.48352986419518F;
				this.Arm_R.yRot = -0.4886921905584123F;
				this.Belly.z = 0.0F;
				this.Belly.xRot = 0.08726646259971647F;
				this.Belly.yRot = -0.2617993877991494F;
				this.Neck.xRot = 0.24434609527920614F;
				this.Neck.yRot = -0.2617993877991494F;
				this.Arm_L.x = -3;
				this.Arm_L.y = 21.5F;
				this.Arm_L.z = -5F;
				this.Arm_L.xRot = -1.48352986419518F;
				this.Arm_L.yRot = -0.17453292519943295F;
				this.Tail_tip.yRot = 0.3839724354387525F;
				this.ASS.y = 18.0F;
				this.Leg_L_1.x = -3.5F;
				this.Leg_L_1.y = 20.4F;
				this.Leg_L_1.xRot = -2.234021442552742F;
				this.Leg_L_1.yRot = 0.3490658503988659F;
				this.Leg_L_1.zRot = -0.17453292519943295F;
				this.Leg_L_2_1.y = 6;
				this.Leg_L_2_1.z = 0.3F;
				this.Leg_L_2_1.xRot = 1.7453292519943295F;
				this.Feet_L_1.y = 5.2F;
				this.Feet_L_1.z = -1;
				this.Feet_L_1.xRot = 0.41887902047863906F;
				this.Feet_L_1.zRot = -0.17453292519943295F;
				this.Leg_L_2.x = -2.8F;
				this.Leg_L_2.y = 6;
				this.Leg_L_2.z = 0.3F;
				this.Leg_L_2.xRot = 1.7453292519943295F;
				this.Tail_base.xRot = -0.17453292519943295F;
				this.Tail_base.yRot = 0.19198621771937624F;
			}
		}
		if (wakingProgress != 0) {
			//Feet_L
//			this.Feet_L.y = 5;
//			this.Feet_L.z = 0;
			if (this.Feet_L.y > 5) this.Feet_L.y -= 0.15;
			if (this.Feet_L.z < 0) this.Feet_L.z += 0.15;
			if (this.Feet_L.xRot > 0) this.Feet_L.xRot -= 0.05;
			if (this.Feet_L.zRot > 0) this.Feet_L.zRot -= 0.05;
			//Leg_L_1_1
//			this.Leg_L_1_1.x = 2.5F;
//			this.Leg_L_1_1.y = 8;
			if (this.Leg_L_1_1.x > 2.5) this.Leg_L_1_1.x -= 0.15;
			if (this.Leg_L_1_1.y > 8) this.Leg_L_1_1.y -= 0.15;
			if (this.Leg_L_1_1.xRot < 0) this.Leg_L_1_1.xRot += 0.05;
			if (this.Leg_L_1_1.yRot < 0) this.Leg_L_1_1.yRot += 0.05;
			if (this.Leg_L_1_1.zRot > 0) this.Leg_L_1_1.zRot -= 0.05;
			//Arm_R
//			this.Arm_R.x = 4;
//			this.Arm_R.y = 11;
//			this.Arm_R.z = -7.5F;
			if (this.Arm_R.x > 4) this.Arm_R.x -= 0.15;
			if (this.Arm_R.y > 11) this.Arm_R.y -= 0.15;
			if (this.Arm_R.z > -7.5) this.Arm_R.z -= 0.15;
			if (this.Arm_R.xRot < 0) this.Arm_R.xRot += 0.05;
			if (this.Arm_R.yRot < 0) this.Arm_R.yRot += 0.05;
			//Belly
//			this.Belly.z = -1.0F;
			if (this.Belly.z > -1) this.Belly.z -= 0.15;
			if (this.Belly.xRot > 0) this.Belly.xRot -= 0.05;
			if (this.Belly.yRot < 0) this.Belly.yRot += 0.05;
			//Neck
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot < 0) this.Neck.yRot += 0.05;
			//Arm_L
//			this.Arm_L.x = -4;
//			this.Arm_L.y = 11;
//			this.Arm_L.z = -7.5F;
			if (this.Arm_L.x > -4) this.Arm_L.x -= 0.15;
			if (this.Arm_L.y > 11) this.Arm_L.y -= 0.15;
			if (this.Arm_L.z > -7.5) this.Arm_L.z -= 0.15;
			if (this.Arm_L.xRot < 0) this.Arm_L.xRot += 0.05;
			if (this.Arm_L.yRot < 0) this.Arm_L.yRot += 0.05;
			//Tail_tip
			if (this.Tail_tip.yRot > 0) this.Tail_tip.yRot -= 0.05;
			//ASS
//			this.ASS.y = 11.0F;
			if (this.ASS.y > 11) this.ASS.y -= 0.15;
			//Leg_L_1
//			this.Leg_L_1.x = -2.5F;
//			this.Leg_L_1.y = 8;
			if (this.Leg_L_1.x < -2.5) this.Leg_L_1.x -= 0.15;
			if (this.Leg_L_1.y > 8) this.Leg_L_1.y -= 0.15;
			if (this.Leg_L_1.xRot < 0) this.Leg_L_1.xRot += 0.05;
			if (this.Leg_L_1.yRot > 0) this.Leg_L_1.yRot -= 0.05;
			if (this.Leg_L_1.zRot < 0) this.Leg_L_1.zRot += 0.05;
			//Leg_L_2_1
//			this.Leg_L_2_1.y = 9;
//			this.Leg_L_2_1.z = 1;
			if (this.Leg_L_2_1.y < 9) this.Leg_L_2_1.y += 0.15;
			if (this.Leg_L_2_1.z < 1) this.Leg_L_2_1.z += 0.15;
			if (this.Leg_L_2_1.xRot > 0) this.Leg_L_2_1.xRot -= 0.05;
			//Feet_L_1
//			this.Feet_L_1.y = 5;
//			this.Feet_L_1.z = 0;
			if (this.Feet_L_1.y > 5) this.Feet_L_1.y -= 0.15;
			if (this.Feet_L_1.z < 0) this.Feet_L_1.z += 0.15;
			if (this.Feet_L_1.xRot > 0) this.Feet_L_1.xRot -= 0.05;
			if (this.Feet_L_1.zRot < 0) this.Feet_L_1.zRot += 0.05;
			//Leg_L_2
//			this.Leg_L_2.x = -2.9F;
//			this.Leg_L_2.y = 9;
//			this.Leg_L_2.z = 1;
			if (this.Leg_L_2.x > -2.9) this.Leg_L_2.x -= 0.15;
			if (this.Leg_L_2.y < 9) this.Leg_L_2.y += 0.15;
			if (this.Leg_L_2.z < 1) this.Leg_L_2.z += 0.15;
			if (this.Leg_L_2.xRot > 0) this.Leg_L_2.xRot -= 0.05;
			//Tail_base
			if (this.Tail_base.xRot < 0) this.Tail_base.xRot += 0.05;
			if (this.Tail_base.yRot > 0) this.Tail_base.yRot -= 0.05;
		}
		if (entity.isAsleep()) {
			if(sleepProgress != 0) {
				//Feet_L
//				this.Feet_L.y = 5;
//				this.Feet_L.z = 0;
				if (this.Feet_L.y < 5.2) this.Feet_L.y += 0.15;
				if (this.Feet_L.z > -1) this.Feet_L.z -= 0.15;
				if (this.Feet_L.xRot < 0.41887902047863906F) this.Feet_L.xRot += 0.05;
				if (this.Feet_L.zRot < 0.17453292519943295F) this.Feet_L.zRot += 0.05;
				//Leg_L_1_1
//				this.Leg_L_1_1.x = 2.5F;
//				this.Leg_L_1_1.y = 8;
				if (this.Leg_L_1_1.x < 3.5) this.Leg_L_1_1.x += 0.15;
				if (this.Leg_L_1_1.y < 20.4) this.Leg_L_1_1.y += 0.15;
				if (this.Leg_L_1_1.xRot > -2.234021442552742F) this.Leg_L_1_1.xRot -= 0.05;
				if (this.Leg_L_1_1.yRot > -0.3490658503988659F) this.Leg_L_1_1.yRot -= 0.05;
				if (this.Leg_L_1_1.zRot < 0.17453292519943295F) this.Leg_L_1_1.zRot += 0.05;
				//Arm_R
//				this.Arm_R.x = 4;
//				this.Arm_R.y = 11;
//				this.Arm_R.z = -7.5F;
				if (this.Arm_R.x < 4.5) this.Arm_R.x += 0.15;
				if (this.Arm_R.y < 21.5) this.Arm_R.y += 0.15;
				if (this.Arm_R.z < -3.5) this.Arm_R.z += 0.15;
				if (this.Arm_R.xRot > -1.48352986419518F) this.Arm_R.xRot -= 0.05;
				if (this.Arm_R.yRot > -0.4886921905584123F) this.Arm_R.yRot -= 0.05;
				//Belly
//				this.Belly.z = -1.0F;
				if (this.Belly.z < 0) this.Belly.z += 0.15;
				if (this.Belly.xRot < 0.08726646259971647F) this.Belly.xRot += 0.05;
				if (this.Belly.yRot > -0.2617993877991494F) this.Belly.yRot -= 0.05;
				//Neck
				if (this.Neck.xRot < 0.24434609527920614F) this.Neck.xRot += 0.05;
				if (this.Neck.yRot > -0.2617993877991494F) this.Neck.yRot -= 0.05;
				//Arm_L
//				this.Arm_L.x = -4;
//				this.Arm_L.y = 11;
//				this.Arm_L.z = -7.5F;
				if (this.Arm_L.x < -3) this.Arm_L.x += 0.15;
				if (this.Arm_L.y < 21.5) this.Arm_L.y += 0.15;
				if (this.Arm_L.z < -5) this.Arm_L.z += 0.15;
				if (this.Arm_L.xRot > -1.48352986419518F) this.Arm_L.xRot -= 0.05;
				if (this.Arm_L.yRot > -0.17453292519943295F) this.Arm_L.yRot -= 0.05;
				//Tail_tip
				if (this.Tail_tip.yRot < 0.3839724354387525F) this.Tail_tip.yRot += 0.05;
				//ASS
//				this.ASS.y = 11.0F;
				if (this.ASS.y < 18) this.ASS.y += 0.15;
				//Leg_L_1
//				this.Leg_L_1.x = -2.5F;
//				this.Leg_L_1.y = 8;
				if (this.Leg_L_1.x > -3.5) this.Leg_L_1.x += 0.15;
				if (this.Leg_L_1.y < 20.4) this.Leg_L_1.y += 0.15;
				if (this.Leg_L_1.xRot > -2.234021442552742F) this.Leg_L_1.xRot -= 0.05;
				if (this.Leg_L_1.yRot < 0.3490658503988659F) this.Leg_L_1.yRot += 0.05;
				if (this.Leg_L_1.zRot > -0.17453292519943295F) this.Leg_L_1.zRot -= 0.05;
				//Leg_L_2_1
//				this.Leg_L_2_1.y = 9;
//				this.Leg_L_2_1.z = 1;
				if (this.Leg_L_2_1.y > 6) this.Leg_L_2_1.y -= 0.15;
				if (this.Leg_L_2_1.z > 0.3) this.Leg_L_2_1.z -= 0.15;
				if (this.Leg_L_2_1.xRot < 1.7453292519943295F) this.Leg_L_2_1.xRot += 0.05;
				//Feet_L_1
//				this.Feet_L_1.y = 5;
//				this.Feet_L_1.z = 0;
				if (this.Feet_L_1.y < 5.2) this.Feet_L_1.y += 0.15;
				if (this.Feet_L_1.z > -1) this.Feet_L_1.z -= 0.15;
				if (this.Feet_L_1.xRot < 0.41887902047863906F) this.Feet_L_1.xRot += 0.05;
				if (this.Feet_L_1.zRot > -0.17453292519943295F) this.Feet_L_1.zRot -= 0.05;
				//Leg_L_2
//				this.Leg_L_2.x = -2.9F;
//				this.Leg_L_2.y = 9;
//				this.Leg_L_2.z = 1;
				if (this.Leg_L_2.x < -2.8) this.Leg_L_2.x += 0.15;
				if (this.Leg_L_2.y > 6) this.Leg_L_2.y -= 0.15;
				if (this.Leg_L_2.z > 0.3) this.Leg_L_2.z -= 0.15;
				if (this.Leg_L_2.xRot < 1.7453292519943295F) this.Leg_L_2.xRot += 0.05;
				//Tail_base
				if (this.Tail_base.xRot > -0.17453292519943295F) this.Tail_base.xRot -= 0.05;
				if (this.Tail_base.yRot < 0.19198621771937624F) this.Tail_base.yRot += 0.05;
			}
		} else {
			this.Arm_R.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.Arm_L.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
			this.Leg_L_1.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.Leg_L_2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.Feet_L.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
			this.Leg_L_1_1.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
			this.Leg_L_2_1.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
			this.Feet_L_1.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
			this.Tail_base.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
			this.Tail_tip.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
			this.Tail_base.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
			this.Tail_tip.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
			this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F);
			this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.05F) + attackProgress * (float) Math.toRadians(25F);
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
				this.Belly.xRot = 0.1F;
				this.Leg_L_1_1.xRot = -0.1F;
				this.Leg_L_1.xRot = -0.1F;
				this.Arm_L.xRot = -0.1F;
				this.Arm_R.xRot = -0.1F;
				this.Arm_L.zRot = 0.3F;
				this.Arm_R.zRot = -0.3F;
			}
			if (entity.isInWater()) {
				this.ASS.y = 20;
				this.Leg_L_1.y = 17;
				this.Leg_L_1_1.y = 17;
				this.Arm_R.y = 19;
				this.Arm_L.y = 19;
				this.Leg_L_1.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Leg_L_1_1.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Leg_L_2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Leg_L_2_1.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Feet_L.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.Feet_L_1.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.Arm_R.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Arm_L.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Neck.xRot = -0.25F;
			}
		}
	}

	public void resetModel() {
		this.Feet_L.y = 5;
		this.Feet_L.z = 0;
		this.Feet_L.xRot = 0;
		this.Feet_L.zRot = 0;
		this.Leg_L_1_1.x = 2.5F;
		this.Leg_L_1_1.y = 8;
		this.Leg_L_1_1.xRot = 0;
		this.Leg_L_1_1.yRot = 0;
		this.Leg_L_1_1.zRot = 0;
		this.Arm_R.x = 4;
		this.Arm_R.y = 11;
		this.Arm_R.z = -7.5F;
		this.Arm_R.xRot = 0;
		this.Arm_R.yRot = 0;
		this.Arm_R.zRot = 0;
		this.Belly.z = -1.0F;
		this.Belly.xRot = 0;
		this.Belly.yRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Arm_L.x = -4;
		this.Arm_L.y = 11;
		this.Arm_L.z = -7.5F;
		this.Arm_L.xRot = 0;
		this.Arm_L.yRot = 0;
		this.Arm_L.zRot = 0;
		this.Tail_tip.xRot = 0;
		this.Tail_tip.yRot = 0;
		this.ASS.y = 11.0F;
		this.Leg_L_1.x = -2.5F;
		this.Leg_L_1.y = 8;
		this.Leg_L_1.xRot = -0F;
		this.Leg_L_1.yRot = 0;
		this.Leg_L_1.zRot = 0;
		this.Leg_L_2_1.y = 9;
		this.Leg_L_2_1.z = 1;
		this.Leg_L_2_1.xRot = 0;
		this.Feet_L_1.y = 5;
		this.Feet_L_1.z = 0;
		this.Feet_L_1.xRot = 0;
		this.Feet_L_1.zRot = 0;
		this.Leg_L_2.x = -2.9F;
		this.Leg_L_2.y = 9;
		this.Leg_L_2.z = 1;
		this.Leg_L_2.xRot = 0;
		this.Tail_base.xRot = 0;
		this.Tail_base.yRot = 0;
		this.ASS.xRot = 0;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Arm_L.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		ASS.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Arm_R.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg_L_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg_L_1_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}