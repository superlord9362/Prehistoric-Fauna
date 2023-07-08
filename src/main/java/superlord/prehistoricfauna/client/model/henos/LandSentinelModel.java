package superlord.prehistoricfauna.client.model.henos;

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
import superlord.prehistoricfauna.common.entity.henos.LandSentinel;

public class LandSentinelModel extends EntityModel<LandSentinel> {
	private final ModelPart Head;
	private final ModelPart Mid1;
	private final ModelPart Mid2;
	private final ModelPart Tail;
	private final ModelPart ArmRight;
	private final ModelPart Arm2Right;
	private final ModelPart ArmLeft;
	private final ModelPart Arm2Left;
	private final ModelPart LegLeftFront;
	private final ModelPart LegRightFront;
	private final ModelPart LegLeftMid;
	private final ModelPart LegRightMid;
	private final ModelPart LegLeftBack;
	private final ModelPart LegRightBack;

	public LandSentinelModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Mid1 = Head.getChild("Mid1");
		this.Mid2 = Mid1.getChild("Mid2");
		this.Tail = Mid2.getChild("Tail");
		this.ArmLeft = Head.getChild("ArmLeft");
		this.Arm2Left = ArmLeft.getChild("Arm2Left");
		this.ArmRight = Head.getChild("ArmRight");
		this.Arm2Right = ArmRight.getChild("Arm2Right");
		this.LegLeftFront = Head.getChild("LegLeftFront");
		this.LegLeftMid = Head.getChild("LegLeftMid");
		this.LegRightFront = Head.getChild("LegRightFront");
		this.LegRightMid = Head.getChild("LegRightMid");
		this.LegLeftBack = Head.getChild("LegLeftBack");
		this.LegRightBack = Head.getChild("LegRightBack");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, 0.0F, -17.0F, 14.0F, 6.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.5F, 0.0F));

		PartDefinition LegRightFront = Head.addOrReplaceChild("LegRightFront", CubeListBuilder.create().texOffs(0, 107).addBox(0.0F, -6.0F, 0.0F, 17.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 2.0F, -6.0F, 0.0F, 0.192F, 0.0F));

		PartDefinition ArmLeft = Head.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(55, 54).mirror().addBox(-12.0F, -1.0F, -1.0F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 4.0F, -12.0F));

		PartDefinition Arm2Left = ArmLeft.addOrReplaceChild("Arm2Left", CubeListBuilder.create().texOffs(55, 66).mirror().addBox(-3.0F, -0.5F, -16.0F, 3.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-11.0F, 0.0F, -1.0F));

		PartDefinition FlatLeft = Arm2Left.addOrReplaceChild("FlatLeft", CubeListBuilder.create().texOffs(32, 64).addBox(0.0F, 0.0F, -15.0F, 10.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, -2.0F));

		PartDefinition LegRightBack = Head.addOrReplaceChild("LegRightBack", CubeListBuilder.create().texOffs(0, 107).addBox(0.0F, -6.0F, 0.0F, 17.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 2.0F, 0.0F, 0.0F, -1.2217F, 0.0F));

		PartDefinition ArmRight = Head.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(55, 54).addBox(0.0F, -1.0F, -1.0F, 12.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 4.0F, -13.0F, -0.0391F, 0.0F, 0.0F));

		PartDefinition Arm2Right = ArmRight.addOrReplaceChild("Arm2Right", CubeListBuilder.create().texOffs(55, 66).addBox(0.0F, -0.5F, -16.0F, 3.0F, 1.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 0.0F, 0.0F));

		PartDefinition FlatRight = Arm2Right.addOrReplaceChild("FlatRight", CubeListBuilder.create().texOffs(32, 64).mirror().addBox(-10.0F, 0.0F, -15.0F, 10.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 0.0F, -2.0F));

		PartDefinition Mid1 = Head.addOrReplaceChild("Mid1", CubeListBuilder.create().texOffs(0, 25).addBox(-6.0F, 0.0F, -1.0F, 12.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.9F, 0.0F));

		PartDefinition Mid1Plate4 = Mid1.addOrReplaceChild("Mid1Plate4", CubeListBuilder.create().texOffs(55, 0).addBox(-7.0F, 0.0F, 0.0F, 14.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 16.0F));

		PartDefinition Mid1Plate1 = Mid1.addOrReplaceChild("Mid1Plate1", CubeListBuilder.create().texOffs(55, 0).addBox(-7.0F, 0.0F, 0.0F, 14.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 1.0F));

		PartDefinition Mid1Plate3 = Mid1.addOrReplaceChild("Mid1Plate3", CubeListBuilder.create().texOffs(55, 0).addBox(-7.0F, 0.0F, 0.0F, 14.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 11.0F));

		PartDefinition Mid2 = Mid1.addOrReplaceChild("Mid2", CubeListBuilder.create().texOffs(0, 52).addBox(-5.0F, 0.0F, -1.0F, 10.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.1F, 19.0F));

		PartDefinition Mid2Plate1 = Mid2.addOrReplaceChild("Mid2Plate1", CubeListBuilder.create().texOffs(55, 30).addBox(-5.0F, 0.0F, 0.0F, 12.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, 2.0F));

		PartDefinition Mid2Plate3 = Mid2.addOrReplaceChild("Mid2Plate3", CubeListBuilder.create().texOffs(55, 30).addBox(-5.0F, 0.0F, 0.0F, 12.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, 10.0F));

		PartDefinition Mid2Plate2 = Mid2.addOrReplaceChild("Mid2Plate2", CubeListBuilder.create().texOffs(55, 30).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 6.0F));

		PartDefinition Tail = Mid2.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 72).addBox(-2.5F, 0.0F, -2.0F, 5.0F, 5.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.1F, 12.0F));

		PartDefinition Spike = Tail.addOrReplaceChild("Spike", CubeListBuilder.create().texOffs(54, 86).addBox(-5.5F, 0.0F, -5.0F, 11.0F, 0.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.5F, 14.0F));

		PartDefinition Mid1Plate2 = Mid1.addOrReplaceChild("Mid1Plate2", CubeListBuilder.create().texOffs(55, 0).addBox(-7.0F, 0.0F, 0.0F, 14.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 6.0F));

		PartDefinition LegLeftFront = Head.addOrReplaceChild("LegLeftFront", CubeListBuilder.create().texOffs(0, 107).mirror().addBox(-17.0F, -6.0F, 0.0F, 17.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 2.0F, -6.0F, 0.0F, -0.192F, 0.0F));

		PartDefinition LegLeftBack = Head.addOrReplaceChild("LegLeftBack", CubeListBuilder.create().texOffs(0, 107).mirror().addBox(-17.0F, -6.0F, 0.0F, 17.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 2.0F, 0.0F, 0.0F, 1.2217F, 0.0F));

		PartDefinition LegRightMid = Head.addOrReplaceChild("LegRightMid", CubeListBuilder.create().texOffs(0, 107).addBox(0.0F, -6.0F, 0.0F, 17.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 2.0F, -3.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition LegLeftMid = Head.addOrReplaceChild("LegLeftMid", CubeListBuilder.create().texOffs(0, 107).mirror().addBox(-17.0F, -6.0F, 0.0F, 17.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 2.0F, -3.0F, 0.0F, 0.4363F, 0.0F));

		return LayerDefinition.create(meshdefinition, 100, 200);
	}

	@Override
	public void setupAnim(LandSentinel entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 3.0f;
		float walkDegree = 2.0f;
		this.Mid1.xRot = -0.025F * Mth.sin(0.1F * ageInTicks);
		this.Mid2.xRot = -0.025F * Mth.sin(0.1F * ageInTicks);
		this.Tail.xRot = -0.025F * Mth.sin(0.1F * ageInTicks);
		this.ArmRight.zRot = -0.025F * Mth.sin(0.1F * ageInTicks);
		this.ArmRight.yRot = -0.025F * Mth.sin(0.1F * ageInTicks);
		this.Arm2Right.zRot = -0.025F * Mth.sin(0.1F * ageInTicks);
		this.Arm2Right.yRot = -0.025F * Mth.sin(0.1F * ageInTicks);
		this.ArmLeft.zRot = -(-0.025F * Mth.sin(0.1F * ageInTicks));
		this.ArmLeft.yRot = -(-0.025F * Mth.sin(0.1F * ageInTicks));
		this.Arm2Left.zRot = -(-0.025F * Mth.sin(0.1F * ageInTicks));
		this.Arm2Left.yRot = -(-0.025F * Mth.sin(0.1F * ageInTicks));
		this.LegLeftFront.zRot = -Math.abs(Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 1F * limbSwingAmount);
		this.LegRightFront.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 1F * limbSwingAmount));
		this.LegLeftMid.zRot = -Math.abs(Mth.cos(limbSwing * walkSpeed * 0.15F + 1) * walkDegree * 1F * limbSwingAmount);
		this.LegRightMid.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.15F + 1) * walkDegree * 1F * limbSwingAmount));
		this.LegLeftBack.zRot = -Math.abs(Mth.cos(limbSwing * walkSpeed * 0.15F + 2) * walkDegree * 1F * limbSwingAmount);
		this.LegRightBack.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.15F + 2) * walkDegree * 1F * limbSwingAmount));
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}