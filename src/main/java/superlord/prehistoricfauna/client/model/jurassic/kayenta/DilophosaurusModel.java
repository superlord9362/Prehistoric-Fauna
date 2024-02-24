package superlord.prehistoricfauna.client.model.jurassic.kayenta;

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
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Dilophosaurus;

public class DilophosaurusModel extends EntityModel<Dilophosaurus> {
	private final ModelPart Torso;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart Tail;
	private final ModelPart Tail2;
	private final ModelPart ArmRight;
	private final ModelPart ArmLeft;
	private final ModelPart Leg1Left;
	private final ModelPart Leg2Left;
	private final ModelPart FootLeft;
	private final ModelPart Leg1Right;
	private final ModelPart Leg2Right;
	private final ModelPart FootRight;

	public DilophosaurusModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.Neck = Torso.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.Jaw = Head.getChild("Jaw");
		this.Tail = Torso.getChild("Tail");
		this.Tail2 = Tail.getChild("Tail2");
		this.ArmLeft = Torso.getChild("ArmLeft");
		this.ArmRight = Torso.getChild("ArmRight");
		this.Leg1Left = root.getChild("Leg1Left");
		this.Leg2Left = Leg1Left.getChild("Leg2Left");
		this.FootLeft = Leg2Left.getChild("FootLeft");
		this.Leg1Right = root.getChild("Leg1Right");
		this.Leg2Right = Leg1Right.getChild("Leg2Right");
		this.FootRight = Leg2Right.getChild("FootRight");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -27.0F, 8.0F, 14.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 9.0F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 46).addBox(-2.0F, -14.0F, -6.0F, 4.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -25.0F, 0.35F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 70).addBox(-2.5F, -5.0F, -6.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.5F, -2.0F, -0.2F, 0.0F, 0.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 81).addBox(-2.0F, -2.0F, -8.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -6.0F));

		PartDefinition CrestLeft = Snout.addOrReplaceChild("CrestLeft", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -6.0F, -8.0F, 1.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, 0.0782F, -0.1047F, 0.0F));

		PartDefinition CrestRight = Snout.addOrReplaceChild("CrestRight", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1.0F, -6.0F, -8.0F, 1.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 1.0F, 0.0782F, 0.1047F, 0.0F));

		PartDefinition Teeth = Snout.addOrReplaceChild("Teeth", CubeListBuilder.create().texOffs(0, 113).addBox(-1.5F, -2.0F, -8.0F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.35F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(0, 103).addBox(-2.5F, 0.0F, -6.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Mouth = Jaw.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(0, 93).addBox(-2.0F, 0.0F, -8.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition BottomTeeth = Mouth.addOrReplaceChild("BottomTeeth", CubeListBuilder.create().texOffs(-1, 132).addBox(-1.0F, 0.0F, -8.0F, 2.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 0.4F));

		PartDefinition Waddle = Jaw.addOrReplaceChild("Waddle", CubeListBuilder.create().texOffs(22, 46).addBox(-1.5F, 0.0F, -6.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -4.0F));

		PartDefinition Cheek = Jaw.addOrReplaceChild("Cheek", CubeListBuilder.create().texOffs(24, 110).addBox(-1.5F, 0.0F, -5.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition QuillsNeck = Neck.addOrReplaceChild("QuillsNeck", CubeListBuilder.create().texOffs(40, 70).addBox(0.0F, -9.0F, 0.0F, 0.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -1.0F));

		PartDefinition Tail = Torso.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(50, 4).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 1.5F, -0.05F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(95, 3).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 47.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 15.0F, 0.05F, 0.0F, 0.0F));

		PartDefinition ArmRight = Torso.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(41, 46).addBox(0.0F, 0.0F, -2.0F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 5.0F, -23.0F, 0.15F, 0.0F, 0.0F));

		PartDefinition ArmLeft = Torso.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(41, 46).mirror().addBox(-3.0F, 0.0F, -2.0F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 5.0F, -23.0F, 0.15F, 0.0F, 0.0F));

		PartDefinition Leg1Left = partdefinition.addOrReplaceChild("Leg1Left", CubeListBuilder.create().texOffs(72, 49).mirror().addBox(-5.0F, -3.0F, -5.0F, 6.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -2.0F, 5.0F, -0.1F, 0.0F, 0.0F));

		PartDefinition Leg2Left = Leg1Left.addOrReplaceChild("Leg2Left", CubeListBuilder.create().texOffs(72, 75).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 10.0F, 2.0F, 0.1F, 0.0F, 0.0F));

		PartDefinition FootLeft = Leg2Left.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(72, 94).mirror().addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 14.0F, 1.0F));

		PartDefinition Leg1Right = partdefinition.addOrReplaceChild("Leg1Right", CubeListBuilder.create().texOffs(72, 49).addBox(-2.0F, -3.0F, -5.0F, 6.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, 5.0F, -0.1F, 0.0F, 0.0F));

		PartDefinition Leg2Right = Leg1Right.addOrReplaceChild("Leg2Right", CubeListBuilder.create().texOffs(72, 75).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 10.0F, 2.0F, 0.1F, 0.0F, 0.0F));

		PartDefinition FootRight = Leg2Right.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(72, 94).addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 200, 200);
	}

	@Override
	public void setupAnim(Dilophosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 1.0f;
		float walkDegree = 0.5f;
		float idleSpeed = 1.0f;
		float idleDegree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress =  entity.getMeleeProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			//Head
			//this.Head.y = -9.5F;
			//this.Head.xRot = -0.20001473294434044F;
			if (this.Head.y > -10) this.Head.y -= 0.15;
			if (this.Head.xRot > -0.0781907508222411F) this.Head.xRot -= 0.05;
			if (this.Head.yRot < 0.03874630989361682F) this.Head.yRot += 0.05;
			if (this.Head.zRot < 0.19547687289441354F) this.Head.zRot += 0.05;
			//Tail2
			//this.Tail2.x = 0.0F;
			//this.Tail2.xRot = 0.05000000058364023F;
			if (this.Tail2.y > -0.5) this.Tail2.y -= 0.15;
			if (this.Tail2.xRot > -0.4300491170387584F) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot < 0.19547687289441354F) this.Tail2.yRot += 0.05;
			if (this.Tail2.zRot > -0.19547687289441354F) this.Tail2.zRot -= 0.05;
			//FootLeft
			//this.FootLeft.y = 14.0F;
			//this.FootLeft.z = 1.0F;
			if (this.FootLeft.y < 15) this.FootLeft.y += 0.15;
			if (this.FootLeft.z > 0) this.FootLeft.z -= 0.15;
			if (this.FootLeft.xRot < 2.0722294794824117F) this.FootLeft.xRot += 0.05;
			if (this.FootLeft.yRot < 1.7453292129831807E-4F) this.FootLeft.yRot += 0.05;
			if (this.FootLeft.zRot < 0.0373500478236019F) this.FootLeft.zRot += 0.05;
			//Leg2Right
			//this.Leg2Right.y = 10.0F;
			//this.Leg2Right.z = 2.0F;
			//this.Leg2Right.xRot = 0.10000736647217022F;
			if (this.Leg2Right.y > 11) this.Leg2Right.y -= 0.15;
			if (this.Leg2Right.z > 5) this.Leg2Right.z -= 0.15;
			if (this.Leg2Right.xRot > -1.3685127304046198F) this.Leg2Right.xRot -= 0.05;
			if (this.Leg2Right.yRot > -1.7453292129831807E-4F) this.Leg2Right.yRot -= 0.05;
			if (this.Leg2Right.zRot < 0.4300491170387584F) this.Leg2Right.zRot += 0.05;
			//Neck
			//this.Neck.x = 0.0F;
			//this.Neck.y = 3.0F;
			//this.Neck.z = -25.0F;
			//this.Neck.xRot = 0.34999998744072486F;
			if (this.Neck.x > -1) this.Neck.x -= 0.15;
			if (this.Neck.y > 1) this.Neck.y -= 0.15;
			if (this.Neck.z < -24) this.Neck.z += 0.15;
			if (this.Neck.xRot < 1.6418312220247435F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot < 0.3122393925291412F) this.Neck.yRot += 0.05;
			if (this.Neck.zRot > -0.23457224414434488F) this.Neck.zRot -= 0.05;
			//Tail
			//this.Tail.xRot = -0.05000000058364023F;
			if (this.Tail.xRot > -0.27366763203903305F) this.Tail.xRot -= 0.05;
			if (this.Tail.yRot > -0.0781907508222411F) this.Tail.yRot -= 0.05;
			//Torso
			//this.Torso.x = 0;
			//this.Torso.y = -3.0F;
			if (this.Torso.x > -3) this.Torso.x -= 0.15;
			if (this.Torso.y < 19) this.Torso.y += 0.15;
			if (this.Torso.xRot > -0.11728612207217244F) this.Torso.xRot -= 0.05;
			if (this.Torso.yRot > -0.039269908169872414F) this.Torso.yRot -= 0.05;
			if (this.Torso.zRot > -1.2901473511162753F) this.Torso.zRot -= 0.05;
			//ArmLeft
			//this.ArmLeft.x = -2.5F;
			//this.ArmLeft.y = 5.0F;
			//this.ArmLeft.xRot = 0.149923785409474F;
			if (this.ArmLeft.x > -3) this.ArmLeft.x -= 0.15;
			if (this.ArmLeft.y > 2) this.ArmLeft.y -= 0.15;
			if (this.ArmLeft.xRot > -0.03909537541112055F) this.ArmLeft.xRot -= 0.05;
			if (this.ArmLeft.yRot > -0.03909537541112055F) this.ArmLeft.yRot -= 0.05;
			if (this.ArmLeft.zRot > -0.23457224414434488F) this.ArmLeft.zRot -= 0.05;
			//FootRight
			//this.FootRight.y = 14.0F;
			//this.FootRight.z = 1.0F;
			if (this.FootRight.y < 15) this.FootRight.y += 0.15;
			if (this.FootRight.z > 0.9) this.FootRight.z -= 0.15;
			if (this.FootRight.xRot < 1.8387043403444152F) this.FootRight.xRot += 0.05;
			if (this.FootRight.yRot > -0.15725416959943073F) this.FootRight.yRot -= 0.05;
			if (this.FootRight.zRot > -0.1563815016444822F) this.FootRight.zRot -= 0.05;
			//Leg2Left
			//this.Leg2Left.y = 10.0F;
			//this.Leg2Left.xRot = 0.10000736647217022F;
			if (this.Leg2Left.y < 11) this.Leg2Left.y += 0.15;
			if (this.Leg2Left.xRot > -0.4300491170387584F) this.Leg2Left.xRot -= 0.05;
			if (this.Leg2Left.yRot > -0.11728612207217244F) this.Leg2Left.yRot -= 0.05;
			if (this.Leg2Left.zRot > -0.19547687289441354F) this.Leg2Left.zRot -= 0.05;
			//Leg1Right
			//this.Leg1Right.x = 2.0F;
			//this.Leg1Right.y = -2.0F;
			//this.Leg1Right.z = 5.0F;
			//this.Leg1Right.xRot = -0.10000736647217022F;
			if (this.Leg1Right.x > 0.5) this.Leg1Right.x -= 0.15;
			if (this.Leg1Right.y < 17) this.Leg1Right.y += 0.15;
			if (this.Leg1Right.z < 7) this.Leg1Right.z += 0.15;
			if (this.Leg1Right.xRot > -0.1563815016444822F) this.Leg1Right.xRot -= 0.05;
			if (this.Leg1Right.yRot > -1.7453292129831807E-4F) this.Leg1Right.yRot -= 0.05;
			if (this.Leg1Right.zRot > -1.0555751236166873F) this.Leg1Right.zRot -= 0.05;
			//Leg1Left
			//this.Leg1Left.x = -3.0F;
			//this.Leg1Left.y = -2.0F;
			//this.Leg1Left.xRot = -0.10000736647217022F;
			if (this.Leg1Left.x < -2.5) this.Leg1Left.x += 0.15;
			if (this.Leg1Left.y < 21.2) this.Leg1Left.y += 0.15;
			if (this.Leg1Left.xRot < 0.4300491170387584F) this.Leg1Left.xRot += 0.05;
			if (this.Leg1Left.yRot > -0.11728612207217244F) this.Leg1Left.yRot -= 0.05;
			if (this.Leg1Left.zRot > -1.4467034063254554F) this.Leg1Left.zRot -= 0.05;
			//ArmRight
			//this.ArmRight.x = 2.5F;
			//this.ArmRight.y = 5.0F;
			//this.ArmRight.xRot = 0.149923785409474F;
			if (this.ArmRight.x < 3) this.ArmRight.x += 0.15;
			if (this.ArmRight.y < 6) this.ArmRight.y += 0.15;
			if (this.ArmRight.xRot < 0.2738421523142173F) this.ArmRight.xRot += 0.05;
			if (this.ArmRight.yRot < 0.4300491170387584F) this.ArmRight.yRot += 0.05;
			if (this.ArmRight.zRot > -1.7035422454473641F) this.ArmRight.zRot -= 0.05;
			sleepPose();
		} else {
			this.Neck.xRot = (Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount + 0.35F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(35F);
			this.Torso.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
			this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
			this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.15F * limbSwingAmount + 0.05F;
			this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
			this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 1.0F * limbSwingAmount;
			this.Head.xRot = Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount - 0.2F + attackProgress * (float) Math.toRadians(-35F);
			this.ArmRight.xRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
			this.ArmLeft.xRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
			this.Leg1Right.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.05F;
			this.Leg2Left.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.05F;
			this.FootRight.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount;
			this.Leg1Left.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.05F;
			this.Leg2Left.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.05F;
			this.FootLeft.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.3F * limbSwingAmount;
			this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
			this.Jaw.xRot = attackProgress * (float) Math.toRadians(25F);
			if (entity.isInWater()) {
				this.Leg1Right.y = 20;
				this.Leg1Left.y = 20;
				this.Torso.y = 20;
				this.Torso.xRot = -0.25F;
				this.Tail.xRot = 0.125F;
				this.Tail2.xRot = 0.125F;
				this.Neck.xRot = 0.5F;
				this.Leg1Right.xRot = -0.24271F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Leg1Left.xRot = 0.24271F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.ArmLeft.xRot = 0.25F;
				this.ArmRight.xRot = 0.25F;
				this.Leg2Right.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Leg2Left.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.FootRight.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.FootLeft.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Head
			//this.Head.y = -9.5F;
			//this.Head.xRot = -0.20001473294434044F;
			if (this.Head.y < -9.5) this.Head.y += 0.15;
			if (this.Head.xRot < -0.020001473294434044F) this.Head.xRot += 0.05;
			if (this.Head.yRot > 0) this.Head.yRot -= 0.05;
			if (this.Head.zRot > 0) this.Head.zRot -= 0.05;
			//Tail2
			//this.Tail2.x = 0.0F;
			//this.Tail2.xRot = 0.05000000058364023F;
			if (this.Tail2.y < 0) this.Tail2.y += 0.15;
			if (this.Tail2.xRot < 0.05000000058364023F) this.Tail2.xRot += 0.05;
			if (this.Tail2.yRot > 0) this.Tail2.yRot -= 0.05;
			if (this.Tail2.zRot < 0) this.Tail2.zRot += 0.05;
			//FootLeft
			//this.FootLeft.y = 14.0F;
			//this.FootLeft.z = 1.0F;
			if (this.FootLeft.y > 14) this.FootLeft.y -= 0.15;
			if (this.FootLeft.z < 1) this.FootLeft.z += 0.15;
			if (this.FootLeft.xRot > 0) this.FootLeft.xRot -= 0.05;
			if (this.FootLeft.yRot > 0) this.FootLeft.yRot -= 0.05;
			if (this.FootLeft.zRot > 0) this.FootLeft.zRot -= 0.05;
			//Leg2Right
			//this.Leg2Right.y = 10.0F;
			//this.Leg2Right.z = 2.0F;
			//this.Leg2Right.xRot = 0.10000736647217022F;
			if (this.Leg2Right.y < 10) this.Leg2Right.y += 0.15;
			if (this.Leg2Right.z < 2) this.Leg2Right.z += 0.15;
			if (this.Leg2Right.xRot < 0.10000736647217022F) this.Leg2Right.xRot += 0.05;
			if (this.Leg2Right.yRot < 0) this.Leg2Right.yRot += 0.05;
			if (this.Leg2Right.zRot > 0) this.Leg2Right.zRot -= 0.05;
			//Neck
			//this.Neck.x = 0.0F;
			//this.Neck.y = 3.0F;
			//this.Neck.z = -25.0F;
			//this.Neck.xRot = 0.34999998744072486F;
			if (this.Neck.x < 0) this.Neck.x += 0.15;
			if (this.Neck.y < 3) this.Neck.y += 0.15;
			if (this.Neck.z > -25) this.Neck.z -= 0.15;
			if (this.Neck.xRot > 0.34999998744072486F) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot > 0) this.Neck.yRot -= 0.05;
			if (this.Neck.zRot < 0) this.Neck.zRot += 0.05;
			//Tail
			//this.Tail.xRot = -0.05000000058364023F;
			if (this.Tail.xRot < -0.05000000058364023F) this.Tail.xRot += 0.05;
			if (this.Tail.yRot < 0) this.Tail.yRot += 0.05;
			//Torso
			//this.Torso.x = 0;
			//this.Torso.y = -3.0F;
			if (this.Torso.x < 0) this.Torso.x += 0.15;
			if (this.Torso.y > -3) this.Torso.y -= 0.15;
			if (this.Torso.xRot < 0) this.Torso.xRot += 0.05;
			if (this.Torso.yRot < 0) this.Torso.yRot += 0.05;
			if (this.Torso.zRot < 0) this.Torso.zRot += 0.05;
			//ArmLeft
			//this.ArmLeft.x = -2.5F;
			//this.ArmLeft.y = 5.0F;
			//this.ArmLeft.xRot = 0.149923785409474F;
			if (this.ArmLeft.x < -2.5) this.ArmLeft.x += 0.15;
			if (this.ArmLeft.y < 5) this.ArmLeft.y += 0.15;
			if (this.ArmLeft.xRot < 0.149923785409474F) this.ArmLeft.xRot += 0.05;
			if (this.ArmLeft.yRot < 0) this.ArmLeft.yRot += 0.05;
			if (this.ArmLeft.zRot < 0) this.ArmLeft.zRot += 0.05;
			//FootRight
			//this.FootRight.y = 14.0F;
			//this.FootRight.z = 1.0F;
			if (this.FootRight.y > 14) this.FootRight.y -= 0.15;
			if (this.FootRight.z < 1) this.FootRight.z += 0.15;
			if (this.FootRight.xRot > 0) this.FootRight.xRot -= 0.05;
			if (this.FootRight.yRot < 0) this.FootRight.yRot += 0.05;
			if (this.FootRight.zRot < 0) this.FootRight.zRot += 0.05;
			//Leg2Left
			//this.Leg2Left.y = 10.0F;
			//this.Leg2Left.xRot = 0.10000736647217022F;
			if (this.Leg2Left.y > 10) this.Leg2Left.y -= 0.15;
			if (this.Leg2Left.xRot < 0.10000736647217022F) this.Leg2Left.xRot += 0.05;
			if (this.Leg2Left.yRot < 0) this.Leg2Left.yRot += 0.05;
			if (this.Leg2Left.zRot < 0) this.Leg2Left.zRot += 0.05;
			//Leg1Right
			//this.Leg1Right.x = 2.0F;
			//this.Leg1Right.y = -2.0F;
			//this.Leg1Right.z = 5.0F;
			//this.Leg1Right.xRot = -0.10000736647217022F;
			if (this.Leg1Right.x < 2) this.Leg1Right.x += 0.15;
			if (this.Leg1Right.y > -2) this.Leg1Right.y -= 0.15;
			if (this.Leg1Right.z > 5) this.Leg1Right.z -= 0.15;
			if (this.Leg1Right.xRot < -0.10000736647217022F) this.Leg1Right.xRot += 0.05;
			if (this.Leg1Right.yRot < 0) this.Leg1Right.yRot += 0.05;
			if (this.Leg1Right.zRot < 0) this.Leg1Right.zRot += 0.05;
			//Leg1Left
			//this.Leg1Left.x = -3.0F;
			//this.Leg1Left.y = -2.0F;
			//this.Leg1Left.xRot = -0.10000736647217022F;
			if (this.Leg1Left.x > -3) this.Leg1Left.x -= 0.15;
			if (this.Leg1Left.y > -2) this.Leg1Left.y -= 0.15;
			if (this.Leg1Left.xRot > -0.10000736647217022F) this.Leg1Left.xRot -= 0.05;
			if (this.Leg1Left.yRot < 0) this.Leg1Left.yRot += 0.05;
			if (this.Leg1Left.zRot < 0) this.Leg1Left.zRot += 0.05;
			//ArmRight
			//this.ArmRight.x = 2.5F;
			//this.ArmRight.y = 5.0F;
			//this.ArmRight.xRot = 0.149923785409474F;
			if (this.ArmRight.x > 2.5) this.ArmRight.x -= 0.15;
			if (this.ArmRight.y > 5) this.ArmRight.y -= 0.15;
			if (this.ArmRight.xRot > 0.149923785409474F) this.ArmRight.xRot -= 0.05;
			if (this.ArmRight.yRot > 0) this.ArmRight.yRot -= 0.05;
			if (this.ArmRight.zRot < 0) this.ArmRight.zRot += 0.05;
		}
	}

	public void resetModel() {
		this.Head.y = -9.5F;
		this.Head.xRot = -0.20001473294434044F;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.Tail2.x = 0.0F;
		this.Tail2.xRot = 0.05000000058364023F;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.FootLeft.x = 0.0F;
		this.FootLeft.y = 14.0F;
		this.FootLeft.z = 1.0F;
		this.FootLeft.xRot = 0.0F;
		this.FootLeft.yRot = 0.0F;
		this.FootLeft.zRot = 0.0F;
		this.Leg2Right.y = 10.0F;
		this.Leg2Right.z = 2.0F;
		this.Leg2Right.xRot = 0.10000736647217022F;
		this.Leg2Right.yRot = 0;
		this.Leg2Right.zRot = 0;
		this.Neck.x = 0.0F;
		this.Neck.y = 3.0F;
		this.Neck.z = -25.0F;
		this.Neck.xRot = 0.34999998744072486F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Tail.xRot = -0.05000000058364023F;
		this.Tail.yRot = 0;
		this.Tail.yRot = 0;
		this.Torso.x = 0;
		this.Torso.y = -3.0F;
		this.Torso.xRot = 0;
		this.Torso.yRot = 0;
		this.Torso.zRot = 0;
		this.ArmLeft.x = -2.5F;
		this.ArmLeft.y = 5.0F;
		this.ArmLeft.xRot = 0.149923785409474F;
		this.ArmLeft.yRot = 0;
		this.ArmLeft.zRot = 0;
		this.FootRight.x = 0.0F;
		this.FootRight.y = 14.0F;
		this.FootRight.z = 1.0F;
		this.FootRight.xRot = 0.0F;
		this.FootRight.yRot = 0.0F;
		this.FootRight.zRot = 0.0F;
		this.Leg2Left.y = 10.0F;
		this.Leg2Left.xRot = 0.10000736647217022F;
		this.Leg2Left.yRot = 0;
		this.Leg2Left.zRot = 0;
		this.Leg1Right.x = 2.0F;
		this.Leg1Right.y = -2.0F;
		this.Leg1Right.z = 5.0F;
		this.Leg1Right.xRot = -0.10000736647217022F;
		this.Leg1Right.yRot = 0;
		this.Leg1Right.zRot = 0;
		this.Leg1Left.x = -3.0F;
		this.Leg1Left.y = -2.0F;
		this.Leg1Left.z = 5.0F;
		this.Leg1Left.xRot = -0.10000736647217022F;
		this.Leg1Left.yRot = 0;
		this.Leg1Left.zRot = 0;
		this.ArmRight.x = 2.5F;
		this.ArmRight.y = 5.0F;
		this.ArmRight.xRot = 0.149923785409474F;
		this.ArmRight.yRot = 0;
		this.ArmRight.zRot = 0;
	}

	public void sleepPose() {
		this.Head.y = -10.0F;
		this.Head.xRot = -0.0781907508222411F;
		this.Head.yRot = 0.03874630989361682F;
		this.Head.zRot = 0.19547687289441354F;
		this.Tail2.x = -0.5F;
		this.Tail2.xRot = -0.4300491170387584F;
		this.Tail2.yRot = 0.19547687289441354F;
		this.Tail2.zRot = -0.19547687289441354F;
		this.FootLeft.y = 15.0F;
		this.FootLeft.z = 0.0F;
		this.FootLeft.xRot = 2.0722294794824117F;
		this.FootLeft.yRot = 1.7453292129831807E-4F;
		this.FootLeft.zRot = 0.0373500478236019F;
		this.Leg2Right.y = 11.0F;
		this.Leg2Right.z = 5.0F;
		this.Leg2Right.xRot = -1.3685127304046198F;
		this.Leg2Right.yRot = -1.7453292129831807E-4F;
		this.Leg2Right.zRot = 0.4300491170387584F;
		this.Neck.x = -1.0F;
		this.Neck.y = 1.0F;
		this.Neck.z = -24.0F;
		this.Neck.xRot = 1.6418312220247435F;
		this.Neck.yRot = 0.3122393925291412F;
		this.Neck.zRot = -0.23457224414434488F;
		this.Tail.xRot = -0.27366763203903305F;
		this.Tail.yRot = -0.0781907508222411F;
		this.Tail.zRot = 0.0F;
		this.Torso.x = -3.0F;
		this.Torso.y = 19F;
		this.Torso.xRot = -0.11728612207217244F;
		this.Torso.yRot = -0.039269908169872414F;
		this.Torso.zRot = -1.2901473511162753F;
		this.ArmLeft.x = -3.0F;
		this.ArmLeft.y = 2.0F;
		this.ArmLeft.xRot = -0.03909537541112055F;
		this.ArmLeft.yRot = -0.03909537541112055F;
		this.ArmLeft.zRot = -0.23457224414434488F;
		this.FootRight.y = 15.0F;
		this.FootRight.z = 0.9F;
		this.FootRight.xRot = 1.8387043403444152F;
		this.FootRight.yRot = -0.15725416959943073F;
		this.FootRight.zRot = -0.1563815016444822F;
		this.Leg2Left.y = 11.0F;
		this.Leg2Left.xRot = -0.4300491170387584F;
		this.Leg2Left.yRot = -0.11728612207217244F;
		this.Leg2Left.zRot = -0.19547687289441354F;
		this.Leg1Right.x = 0.5F;
		this.Leg1Right.y = 17.0F;
		this.Leg1Right.z = 7.0F;
		this.Leg1Right.xRot = -0.1563815016444822F;
		this.Leg1Right.yRot = -1.7453292129831807E-4F;
		this.Leg1Right.zRot = -1.0555751236166873F;
		this.Leg1Left.x = -2.5F;
		this.Leg1Left.y = 21.2F;
		this.Leg1Left.z = 5.0F;
		this.Leg1Left.xRot = 0.4300491170387584F;
		this.Leg1Left.yRot = -0.11728612207217244F;
		this.Leg1Left.zRot = -1.4467034063254554F;
		this.ArmRight.x = 3.0F;
		this.ArmRight.y = 6.0F;
		this.ArmRight.xRot = 0.2738421523142173F;
		this.ArmRight.yRot = 0.4300491170387584F;
		this.ArmRight.zRot = 0.7035422454473641F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg1Left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg1Right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}