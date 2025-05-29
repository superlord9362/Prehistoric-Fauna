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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Kayentavenator;

@SuppressWarnings("unused")
public class KayentavenatorModel extends EntityModel<Kayentavenator> {
	private final ModelPart Root;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Dewlap;

	public KayentavenatorModel(ModelPart root) {
		this.Root = root.getChild("Root");
		this.RightThigh = this.Root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftThigh = this.Root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.Body = this.Root.getChild("Body");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Dewlap = this.Head.getChild("Dewlap");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 6.5F, 0.5F));

		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(36, 38).addBox(-1.0F, -2.5F, -4.5F, 4.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 1.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(41, 57).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 6.5F, 2.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(55, 53).addBox(-2.5F, 0.0F, -6.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 9.0F, 1.0F));

		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(36, 38).mirror().addBox(-4.0F, -2.5F, -4.5F, 4.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 0.0F, 1.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(41, 57).mirror().addBox(-1.5F, 0.0F, -1.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 6.5F, 2.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(55, 53).mirror().addBox(-2.5F, 0.0F, -6.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 9.0F, 1.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -4.5F, -16.5F, 7.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(21, 38).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 3.5F, -11.5F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(21, 38).mirror().addBox(-1.0F, -1.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.5F, 3.5F, -11.5F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(66, 10).addBox(-2.5F, -3.975F, 0.0F, 5.0F, 8.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 3.5F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(26, 0).addBox(-1.5F, -1.95F, 0.0F, 3.0F, 4.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 12.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -10.0F, -6.0F, 4.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -14.5F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 63).addBox(-2.0F, -1.001F, -11.0F, 4.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 53).addBox(-2.5F, -1.001F, -4.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -3.0F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 54).addBox(-3.0F, 1.649F, -2.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -5.15F, -8.75F, 0.0436F, 0.0F, 0.0F));

		PartDefinition Dewlap = Head.addOrReplaceChild("Dewlap", CubeListBuilder.create().texOffs(23, 63).addBox(0.0F, 0.0F, -5.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -3.0F));

		return LayerDefinition.create(meshdefinition, 104, 90);
	}

	@Override
	public void setupAnim(Kayentavenator entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 1.0f;
		float walkDegree = 0.5f;
		float idleSpeed = 1.0f;
		float idleDegree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress =  entity.getMeleeProgress(partialTick);
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Head.xRot = Mth.lerp(sleepProgress, -0.20001473294434044F, -0.0781907508222411F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, 0.03874630989361682F);
				this.Head.zRot = Mth.lerp(sleepProgress, 0, 0.19547687289441354F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.05000000058364023F, -0.4300491170387584F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.19547687289441354F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, -0.19547687289441354F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 2.0722294794824117F);
				this.LeftFoot.yRot = Mth.lerp(sleepProgress, 0, 1.7453292129831807E-4F);
				this.LeftFoot.zRot = Mth.lerp(sleepProgress, 0, 0.0373500478236019F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0.10000736647217022F, -1.3685127304046198F);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0, -1.7453292129831807E-4F);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0, 0.4300491170387584F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.34999998744072486F, 0.8418312220247435F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, 0.3122393925291412F);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0, -0.23457224414434488F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.05000000058364023F, -0.27366763203903305F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, -0.0781907508222411F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, 0.0F);
				this.Body.y = Mth.lerp(sleepProgress, 0, 14F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.11728612207217244F);
				this.Body.yRot = Mth.lerp(sleepProgress, 0, -0.039269908169872414F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, -1.2901473511162753F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.149923785409474F, -0.03909537541112055F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.03909537541112055F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.23457224414434488F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.8387043403444152F);
				this.RightFoot.yRot = Mth.lerp(sleepProgress, 0, -0.15725416959943073F);
				this.RightFoot.zRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0.10000736647217022F, -0.4300491170387584F);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0, -0.11728612207217244F);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0, -0.19547687289441354F);
				this.RightThigh.y = Mth.lerp(sleepProgress, 0, 12.0F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.10000736647217022F, -0.1563815016444822F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -1.7453292129831807E-4F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, -1.0555751236166873F);
				this.LeftThigh.x = Mth.lerp(sleepProgress, -1, -0.5F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 0, 14.2F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.10000736647217022F, 0.4300491170387584F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.11728612207217244F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, -1.4467034063254554F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.149923785409474F, 0.2738421523142173F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.4300491170387584F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, 0.7035422454473641F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Head.xRot = Mth.lerp(sleepProgress, -0.0781907508222411F, -0.20001473294434044F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0.03874630989361682F, 0);
				this.Head.zRot = Mth.lerp(sleepProgress, 0.19547687289441354F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, -0.4300491170387584F, 0.05000000058364023F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.19547687289441354F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, -0.19547687289441354F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 2.0722294794824117F, 0);
				this.LeftFoot.yRot = Mth.lerp(sleepProgress, 1.7453292129831807E-4F, 0);
				this.LeftFoot.zRot = Mth.lerp(sleepProgress, 0.0373500478236019F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -1.3685127304046198F, 0.10000736647217022F);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, -1.7453292129831807E-4F, 0);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0.4300491170387584F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.8418312220247435F, 0.34999998744072486F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0.3122393925291412F, 0);
				this.Neck.zRot = Mth.lerp(sleepProgress, -0.23457224414434488F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.27366763203903305F, -0.05000000058364023F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, -0.0781907508222411F, 0);
				this.Body.y = Mth.lerp(sleepProgress, 14F, 0);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.11728612207217244F, 0);
				this.Body.yRot = Mth.lerp(sleepProgress, -0.039269908169872414F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, -1.2901473511162753F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -0.03909537541112055F, 0.149923785409474F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.03909537541112055F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.23457224414434488F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.8387043403444152F, 0);
				this.RightFoot.yRot = Mth.lerp(sleepProgress, -0.15725416959943073F, 0);
				this.RightFoot.zRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.4300491170387584F, 0.10000736647217022F);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, -0.11728612207217244F, 0);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, -0.19547687289441354F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, 12.0F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.1563815016444822F, -0.10000736647217022F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -1.7453292129831807E-4F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, -1.0555751236166873F, 0);
				this.LeftThigh.x = Mth.lerp(sleepProgress, -0.5F, -1F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 14.2F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0.4300491170387584F, -0.10000736647217022F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.11728612207217244F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, -1.4467034063254554F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.2738421523142173F, 0.149923785409474F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.4300491170387584F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0.7035422454473641F, 0);
			} else {
				this.Neck.xRot = (Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount + 0.35F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(35F);
				this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.15F * limbSwingAmount + 0.05F;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 1.0F * limbSwingAmount;
				this.Head.xRot = Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount - 0.2F + attackProgress * (float) Math.toRadians(-35F);
				this.RightArm.xRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.LeftArm.xRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.05F;
				this.LeftLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.05F;
				this.RightFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.05F;
				this.LeftLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.05F;
				this.LeftFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.3F * limbSwingAmount;
				this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isInWater()) {
					this.RightThigh.y = 16;
					this.LeftThigh.y = 16;
					this.Body.y = 16;
					this.Body.xRot = -0.25F;
					this.Tail1.xRot = 0.125F;
					this.Tail2.xRot = 0.125F;
					this.Neck.xRot = 0.5F;
					this.RightThigh.xRot = -0.24271F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.24271F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = 0.25F;
					this.RightArm.xRot = 0.25F;
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Head.y = -9F;
		this.Head.xRot = -0.20001473294434044F;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.Tail2.x = 0.0F;
		this.Tail2.xRot = 0.05000000058364023F;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftFoot.x = 0.5F;
		this.LeftFoot.y = 9.0F;
		this.LeftFoot.z = 1.0F;
		this.LeftFoot.xRot = 0.0F;
		this.LeftFoot.yRot = 0.0F;
		this.LeftFoot.zRot = 0.0F;
		this.RightLeg.y = 6.5F;
		this.RightLeg.z = 2.5F;
		this.RightLeg.xRot = 0.10000736647217022F;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.Neck.x = 0.0F;
		this.Neck.y = 0.5F;
		this.Neck.z = -14.5F;
		this.Neck.xRot = 0.34999998744072486F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Tail1.xRot = -0.05000000058364023F;
		this.Tail1.yRot = 0;
		this.Tail1.yRot = 0;
		this.Body.x = 0;
		this.Body.y = 0.0F;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.LeftArm.x = -3.5F;
		this.LeftArm.y = 3.5F;
		this.LeftArm.xRot = 0.149923785409474F;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.RightFoot.x = 0.5F;
		this.RightFoot.y = 9.0F;
		this.RightFoot.z = 1.0F;
		this.RightFoot.xRot = 0.0F;
		this.RightFoot.yRot = 0.0F;
		this.RightFoot.zRot = 0.0F;
		this.LeftLeg.y = 6.5F;
		this.LeftLeg.xRot = 0.10000736647217022F;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.RightThigh.x = 2.0F;
		this.RightThigh.y = 0.0F;
		this.RightThigh.z = 1.0F;
		this.RightThigh.xRot = -0.10000736647217022F;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.LeftThigh.x = -1.0F;
		this.LeftThigh.y = 0.0F;
		this.LeftThigh.z = 1.0F;
		this.LeftThigh.xRot = -0.10000736647217022F;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.RightArm.x = 3.5F;
		this.RightArm.y = 3.5F;
		this.RightArm.xRot = 0.149923785409474F;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
	}

	public void sleepPose() {
		this.Head.xRot = -0.0781907508222411F;
		this.Head.yRot = 0.03874630989361682F;
		this.Head.zRot = 0.19547687289441354F;
		this.Tail2.xRot = -0.4300491170387584F;
		this.Tail2.yRot = 0.19547687289441354F;
		this.Tail2.zRot = -0.19547687289441354F;
		this.LeftFoot.xRot = 2.0722294794824117F;
		this.LeftFoot.yRot = 1.7453292129831807E-4F;
		this.LeftFoot.zRot = 0.0373500478236019F;
		this.RightLeg.xRot = -1.3685127304046198F;
		this.RightLeg.yRot = -1.7453292129831807E-4F;
		this.RightLeg.zRot = 0.4300491170387584F;
		this.Neck.xRot = 0.8418312220247435F;
		this.Neck.yRot = 0.3122393925291412F;
		this.Neck.zRot = -0.23457224414434488F;
		this.Tail1.xRot = -0.27366763203903305F;
		this.Tail1.yRot = -0.0781907508222411F;
		this.Tail1.zRot = 0.0F;
		this.Body.y = 14F;
		this.Body.xRot = -0.11728612207217244F;
		this.Body.yRot = -0.039269908169872414F;
		this.Body.zRot = -1.2901473511162753F;
		this.LeftArm.xRot = -0.03909537541112055F;
		this.LeftArm.yRot = -0.03909537541112055F;
		this.LeftArm.zRot = -0.23457224414434488F;
		this.RightFoot.xRot = 1.8387043403444152F;
		this.RightFoot.yRot = -0.15725416959943073F;
		this.RightFoot.zRot = -0.1563815016444822F;
		this.LeftLeg.xRot = -0.4300491170387584F;
		this.LeftLeg.yRot = -0.11728612207217244F;
		this.LeftLeg.zRot = -0.19547687289441354F;
		this.RightThigh.y = 12.0F;
		this.RightThigh.xRot = -0.1563815016444822F;
		this.RightThigh.yRot = -1.7453292129831807E-4F;
		this.RightThigh.zRot = -1.0555751236166873F;
		this.LeftThigh.x = -0.5F;
		this.LeftThigh.y = 14.2F;
		this.LeftThigh.xRot = 0.4300491170387584F;
		this.LeftThigh.yRot = -0.11728612207217244F;
		this.LeftThigh.zRot = -1.4467034063254554F;
		this.RightArm.xRot = 0.2738421523142173F;
		this.RightArm.yRot = 0.4300491170387584F;
		this.RightArm.zRot = 0.7035422454473641F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}