package superlord.prehistoricfauna.client.model.jurassic.morrison;

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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Ceratosaurus;

public class CeratosaurusModel extends EntityModel<Ceratosaurus> {
	private final ModelPart RightLeg1;
	private final ModelPart RightLeg2;
	private final ModelPart RightFoot;
	private final ModelPart LeftLeg1;
	private final ModelPart LeftLeg2;
	private final ModelPart LeftFoot;
	private final ModelPart Body1;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Neck;
	private final ModelPart Head1;
	private final ModelPart Jaw1;

	public CeratosaurusModel(ModelPart root) {
		this.RightLeg1 = root.getChild("RightLeg1");
		this.RightLeg2 = RightLeg1.getChild("RightLeg2");
		this.RightFoot = RightLeg2.getChild("RightFoot");
		this.LeftLeg1 = root.getChild("LeftLeg1");
		this.LeftLeg2 = LeftLeg1.getChild("LeftLeg2");
		this.LeftFoot = LeftLeg2.getChild("LeftFoot");
		this.Body1 = root.getChild("Body1");
		this.RightArm = Body1.getChild("RightArm");
		this.LeftArm = Body1.getChild("LeftArm");
		this.Tail1 = Body1.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.Neck = Body1.getChild("Neck");
		this.Head1 = Neck.getChild("Head1");
		this.Jaw1 = Head1.getChild("Jaw1");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(76, 153).addBox(0.0F, -4.0F, -6.0F, 6.0F, 17.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.0F, 2.0F, -0.0698F, 0.0F, 0.0F));

		PartDefinition RightLeg2 = RightLeg1.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(92, 191).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 11.0F, 5.0F, 0.0698F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLeg2.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(79, 222).mirror().addBox(-2.5F, 0.0F, -7.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition LeftLeg1 = partdefinition.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(76, 153).mirror().addBox(-6.0F, -4.0F, -6.0F, 6.0F, 17.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -1.0F, 2.0F, -0.0698F, 0.0F, 0.0F));

		PartDefinition LeftLeg2 = LeftLeg1.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(92, 191).mirror().addBox(-2.0F, -3.0F, -3.0F, 4.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 11.0F, 5.0F, 0.0698F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLeg2.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(79, 222).addBox(-2.5F, 0.0F, -7.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition Body1 = partdefinition.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(154, 0).addBox(-5.0F, -7.0F, -30.0F, 10.0F, 17.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));

		PartDefinition Tail1 = Body1.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(109, 43).addBox(-3.5F, -4.0F, -1.0F, 7.0F, 11.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, -0.0349F, 0.0F, 0.0F));

		PartDefinition Osteoderm2 = Tail1.addOrReplaceChild("Osteoderm2", CubeListBuilder.create().texOffs(1, 19).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(91, 91).addBox(-2.0F, -4.0F, -1.0F, 4.0F, 7.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 22.0F, -0.0349F, 0.0F, 0.0F));

		PartDefinition Osteoderm3 = Tail2.addOrReplaceChild("Osteoderm3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition LeftArm = Body1.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(52, 51).mirror().addBox(-3.0F, -2.0F, -2.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 6.0F, -24.0F, 0.1484F, 0.0F, 0.0F));

		PartDefinition RightArm = Body1.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(52, 51).addBox(0.0F, -2.0F, -2.0F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 6.0F, -24.0F, 0.1484F, 0.0F, 0.0F));

		PartDefinition Neck = Body1.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 51).addBox(-2.5F, -10.0F, -6.0F, 5.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -31.0F, 0.1047F, 0.0F, 0.0F));

		PartDefinition Head1 = Neck.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(0, 95).addBox(-2.5F, -6.0F, -7.0F, 5.0F, 6.0F, 7.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -4.1F, -3.0F));

		PartDefinition Jaw1 = Head1.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(0, 120).addBox(-2.5F, 0.0F, -7.0F, 5.0F, 3.0F, 7.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Jaw2 = Jaw1.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(47, 120).addBox(-1.5F, 0.0F, -8.0F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, -7.0F));

		PartDefinition LowerTeeth = Jaw2.addOrReplaceChild("LowerTeeth", CubeListBuilder.create().texOffs(49, 207).addBox(-1.0F, -2.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.5F, -0.5F));

		PartDefinition Jaw3 = Jaw1.addOrReplaceChild("Jaw3", CubeListBuilder.create().texOffs(2, 154).addBox(-2.0F, -4.9F, 0.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition Snout = Head1.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(48, 95).addBox(-1.5F, -1.0F, -8.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -4.0F, -7.0F));

		PartDefinition CrestLeft = Snout.addOrReplaceChild("CrestLeft", CubeListBuilder.create().texOffs(0, 191).mirror().addBox(0.0F, -3.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(-1.46F, -0.8F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition CrestRight = Snout.addOrReplaceChild("CrestRight", CubeListBuilder.create().texOffs(0, 191).addBox(-1.0F, -3.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(1.46F, -0.8F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition UpperTeeth = Snout.addOrReplaceChild("UpperTeeth", CubeListBuilder.create().texOffs(8, 208).addBox(-1.0F, 0.0F, -7.0F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 2.5F, -0.5F));

		PartDefinition SnoutHorn = Snout.addOrReplaceChild("SnoutHorn", CubeListBuilder.create().texOffs(0, 22).addBox(-0.5F, -2.0F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -1.0F, -5.5F));

		PartDefinition Osteoderm = Body1.addOrReplaceChild("Osteoderm", CubeListBuilder.create().texOffs(0, -16).addBox(0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -30.0F));

		return LayerDefinition.create(meshdefinition, 250, 250);
	}

	@Override
	public void setupAnim(Ceratosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 1.0f;
		float walkDegree = 0.5f;
		float idleSpeed = 1.0f;
		float idleDegree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		if (entity.getWakingTicks() >= 31 && entity.getFallingAsleepTicks() >= 31) {
			if (entity.isAsleep()) {
				sleepPose();
			} else {
				resetModel();
				this.Neck.xRot = (Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount + 0.35F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(25F);
				this.Body1.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.15F * limbSwingAmount + 0.05F;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 1.0F * limbSwingAmount;
				this.Head1.xRot = Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount - 0.2F + attackProgress * (float) Math.toRadians(-25F);
				this.RightArm.xRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.LeftArm.xRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.RightLeg1.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.05F;
				this.RightLeg2.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.05F;
				this.RightFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount;
				this.LeftLeg1.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.05F;
				this.LeftLeg2.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.05F;
				this.LeftFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.3F * limbSwingAmount;
				this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				this.Jaw1.xRot = attackProgress * (float) Math.toRadians(25F);
				if (entity.isInWater()) {
					this.RightLeg1.y = 20;
					this.LeftLeg1.y = 20;
					this.Body1.y = 20;
					this.Body1.xRot = -0.25F;
					this.Tail1.xRot = 0.125F;
					this.Tail2.xRot = 0.125F;
					this.Neck.xRot = 0.5F;
					this.RightLeg1.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg1.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftArm.xRot = 0.25F;
					this.RightArm.xRot = 0.25F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
		if (entity.getWakingTicks() < 31) {
			//RightArm
			if (this.RightArm.xRot > 0) this.RightArm.xRot -= 0.05;
			if (this.RightArm.yRot > 0) this.RightArm.yRot -= 0.05;
			//Tail2
			if (this.Tail2.xRot > 0) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot < 0) this.Tail2.yRot += 0.05;
			//Body1
			//this.Body1.y = -1.1F;
			if (this.Body1.y > -1.1) this.Body1.y -= 0.15;
			if (this.Body1.xRot < 0) this.Body1.xRot += 0.05;
			//LeftFoot
			//this.LeftFoot.z = 0.0F;
			if (this.LeftFoot.z < 0) this.LeftFoot.z += 0.15;
			if (this.LeftFoot.xRot > 0) this.LeftFoot.xRot -= 0.05;
			//Head1
			//this.Head1.x = 0;
			//this.Head1.z = -3;
			if (this.Head1.x > 0) this.Head1.x -= 0.15;
			if (this.Head1.z < -3) this.Head1.z += 0.15;
			if (this.Head1.xRot < 0) this.Head1.xRot += 0.05;
			if (this.Head1.yRot > 0) this.Head1.yRot -= 0.05;
			if (this.Head1.zRot < 0) this.Head1.zRot += 0.05;
			//Tail1
			//this.Tail1.z = 4.0F;
			if (this.Tail1.z < 4) this.Tail1.z += 0.15;
			if (this.Tail1.xRot < 0) this.Tail1.xRot += 0.05;
			if (this.Tail1.yRot < 0) this.Tail1.yRot += 0.05;
			//RightFoot
			//this.RightFoot.z = 0.0F;
			if (this.RightFoot.z < -0) this.RightFoot.z += 0.15;
			if (this.RightFoot.xRot > 0) this.RightFoot.xRot -= 0.05;
			//RightLeg2
			if (this.RightLeg2.xRot < 0) this.RightLeg2.xRot += 0.05;
			//LeftLeg2
			if (this.LeftLeg2.xRot < 0) this.LeftLeg2.xRot += 0.05;
			//Neck
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot > 0) this.Neck.yRot -= 0.05;
			if (this.Neck.zRot > 0) this.Neck.zRot -= 0.05;
			//LeftLeg1
			//this.LeftLeg1.x = -2;
			//this.LeftLeg1.y = -1;
			//this.LeftLeg1.z = 2;
			if (this.LeftLeg1.x < -2) this.LeftLeg1.x += 0.15;
			if (this.LeftLeg1.y > -1) this.LeftLeg1.y -= 0.15;
			if (this.LeftLeg1.z > 2) this.LeftLeg1.z -= 0.15;
			if (this.LeftLeg1.xRot < 0) this.LeftLeg1.xRot += 0.05;
			if (this.LeftLeg1.yRot > 0) this.LeftLeg1.yRot -= 0.05;
			//RightLeg1
			//this.RightLeg1.x = 2;
			//this.RightLeg1.y = -1;
			if (this.RightLeg1.x > 2) this.RightLeg1.x -= 0.15;
			if (this.RightLeg1.y > -1) this.RightLeg1.y -= 0.15;
			if (this.RightLeg1.xRot < 0) this.RightLeg1.xRot += 0.05;
			if (this.RightLeg1.yRot < 0) this.RightLeg1.yRot += 0.05;
			//LeftArm
			if (this.LeftArm.xRot > 0) this.LeftArm.xRot -= 0.05;
			if (this.LeftArm.yRot > 0) this.LeftArm.yRot -= 0.05;
		}
		if (entity.getFallingAsleepTicks() < 31) {
			//RightArm
			if (this.RightArm.xRot < 0.8932595164970201F) this.RightArm.xRot += 0.05;
			if (this.RightArm.yRot < 0.19547687289441354F) this.RightArm.yRot += 0.05;
			//Tail2
			if (this.Tail2.xRot < 0.20943951023931953F) this.Tail2.xRot += 0.05;
			if (this.Tail2.yRot > -0.5585053606381855F) this.Tail2.yRot -= 0.05;
			//Body1
			//this.Body1.y = -1.1F;
			if (this.Body1.y < 10.5) this.Body1.y += 0.15;
			if (this.Body1.xRot > -0.10471975511965977F) this.Body1.xRot -= 0.05;
			//LeftFoot
			//this.LeftFoot.z = 0.0F;
			if (this.LeftFoot.z > -1) this.LeftFoot.z -= 0.15;
			if (this.LeftFoot.xRot < 1.5707963267948966F) this.LeftFoot.xRot += 0.05;
			//Head1
			//this.Head1.x = 0;
			//this.Head1.z = -3;
			if (this.Head1.x < 2) this.Head1.x += 0.15;
			if (this.Head1.z > -5) this.Head1.z -= 0.15;
			if (this.Head1.xRot > -0.7864453849170947F) this.Head1.xRot -= 0.05;
			if (this.Head1.yRot < 0.6658431362674476F) this.Head1.yRot += 0.05;
			if (this.Head1.zRot > -1.1339404363260046F) this.Head1.zRot -= 0.05;
			//Tail1
			//this.Tail1.z = 4.0F;
			if (this.Tail1.z > 1.5) this.Tail1.z -= 0.15;
			if (this.Tail1.xRot > -0.24434609527920614F) this.Tail1.xRot -= 0.05;
			if (this.Tail1.yRot > -0.3490658503988659F) this.Tail1.yRot -= 0.05;
			//RightFoot
			//this.RightFoot.z = 0.0F;
			if (this.RightFoot.z > -1) this.RightFoot.z -= 0.15;
			if (this.RightFoot.xRot < 1.5707963267948966F) this.RightFoot.xRot += 0.05;
			//RightLeg2
			if (this.RightLeg2.xRot > -0.8377580409572781F) this.RightLeg2.xRot -= 0.05;
			//LeftLeg2
			if (this.LeftLeg2.xRot > -0.8377580409572781F) this.LeftLeg2.xRot -= 0.05;
			//Neck
			if (this.Neck.xRot < 1.0929251589567215F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot < 1.2117821049859852F) this.Neck.yRot += 0.05;
			if (this.Neck.zRot < 0.2350958549041681F) this.Neck.zRot += 0.05;
			//LeftLeg1
			//this.LeftLeg1.x = -2;
			//this.LeftLeg1.y = -1;
			//this.LeftLeg1.z = 2;
			if (this.LeftLeg1.x > -4) this.LeftLeg1.x -= 0.15;
			if (this.LeftLeg1.y < 10.7) this.LeftLeg1.y += 0.15;
			if (this.LeftLeg1.z < 10) this.LeftLeg1.z += 0.15;
			if (this.LeftLeg1.xRot > -0.7330382858376184F) this.LeftLeg1.xRot -= 0.05;
			if (this.LeftLeg1.yRot < 0.24434609527920614F) this.LeftLeg1.yRot += 0.05;
			//RightLeg1
			//this.RightLeg1.x = 2;
			//this.RightLeg1.y = -1;
			if (this.RightLeg1.x < 4) this.RightLeg1.x += 0.15;
			if (this.RightLeg1.y < 10.7) this.RightLeg1.y += 0.15;
			if (this.RightLeg1.xRot > -0.7330382858376184F) this.RightLeg1.xRot -= 0.05;
			if (this.RightLeg1.yRot > -0.24434609527920614F) this.RightLeg1.yRot -= 0.05;
			//LeftArm
			if (this.LeftArm.xRot < 0.6066764186984569F) this.LeftArm.xRot += 0.05;
			if (this.LeftArm.yRot < 0.10471975511965977F) this.LeftArm.yRot += 0.05;
		}
	}

	public void resetModel() {
		this.RightArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Body1.y = -1.1F;
		this.Body1.xRot = 0;
		this.LeftFoot.z = 0.0F;
		this.LeftFoot.xRot = 0;
		this.Head1.x = 0;
		this.Head1.z = -3;
		this.Head1.xRot = 0;
		this.Head1.yRot = 0;
		this.Head1.zRot = 0;
		this.Tail1.z = 4.0F;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.RightFoot.z = 0.0F;
		this.RightFoot.xRot = 0;
		this.RightLeg2.xRot = 0;
		this.LeftLeg2.xRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.LeftLeg1.x = -2;
		this.LeftLeg1.y = -1;
		this.LeftLeg1.z = 2;
		this.LeftLeg1.xRot = 0;
		this.LeftLeg1.yRot = 0;
		this.RightLeg1.x = 2;
		this.RightLeg1.y = -1;
		this.RightLeg1.z = 2;
		this.RightLeg1.xRot = 0;
		this.RightLeg1.yRot = 0;
		this.LeftArm.xRot = 0F;
		this.LeftArm.zRot = 0F;
		this.Neck.z = -29.5F;
	}

	public void sleepPose() {
		this.RightArm.xRot = 0.8932595164970201F;
		this.RightArm.yRot = 0.19547687289441354F;
		this.Tail2.xRot = 0.20943951023931953F;
		this.Tail2.yRot = -0.5585053606381855F;
		this.Body1.y = 10.5F;
		this.Body1.xRot = -0.10471975511965977F;
		this.LeftFoot.z = -1.0F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.Head1.x = 2;
		this.Head1.z = -5;
		this.Head1.xRot = -0.7864453849170947F;
		this.Head1.yRot = 0.6658431362674476F;
		this.Head1.zRot = -1.1339404363260046F;
		this.Tail1.z = 1.5F;
		this.Tail1.xRot = -0.24434609527920614F;
		this.Tail1.yRot = -0.3490658503988659F;
		this.RightFoot.z = -1;
		this.RightFoot.xRot = 1.5707963267948966F;
		this.RightLeg2.xRot = -0.8377580409572781F;
		this.LeftLeg2.xRot = -0.8377580409572781F;
		this.Neck.xRot = 1.0929251589567215F;
		this.Neck.yRot = 1.2117821049859852F;
		this.Neck.zRot = 0.2350958549041681F;
		this.LeftLeg1.x = -4;
		this.LeftLeg1.y = 10.7F;
		this.LeftLeg1.z = 10;
		this.LeftLeg1.xRot = -0.7330382858376184F;
		this.LeftLeg1.yRot = 0.24434609527920614F;
		this.RightLeg1.x = 4;
		this.RightLeg1.y = 10.7F;
		this.RightLeg1.xRot = -0.7330382858376184F;
		this.RightLeg1.yRot = -0.24434609527920614F;
		this.LeftArm.xRot = 0.6066764186984569F;
		this.LeftArm.zRot = 0.10471975511965977F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}