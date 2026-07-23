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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;

public class CamarasaurusModel extends EntityModel<Camarasaurus> {
	private final ModelPart body;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart RightFrontLeg;
	private final ModelPart LeftFrontLeg;
	private final ModelPart RightHindLeg1;
	private final ModelPart RightHindLeg2;
	private final ModelPart RightHindLeg3;
	private final ModelPart LeftHindLeg1;
	private final ModelPart LeftHindLeg2;
	private final ModelPart LeftHindLeg3;

	public CamarasaurusModel(ModelPart root) {
		this.body = root.getChild("body");
		this.RightFrontLeg = body.getChild("RightFrontLeg");
		this.LeftFrontLeg = body.getChild("LeftFrontLeg");
		this.Tail1 = body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.Neck1 = body.getChild("Neck1");
		this.Neck2 = Neck1.getChild("Neck2");
		this.Head = Neck2.getChild("Head");
		this.RightHindLeg1 = root.getChild("RightHindLeg1");
		this.RightHindLeg2 = RightHindLeg1.getChild("RightHindLeg2");
		this.RightHindLeg3 = RightHindLeg2.getChild("RightHindLeg3");
		this.LeftHindLeg1 = root.getChild("LeftHindLeg1");
		this.LeftHindLeg2 = LeftHindLeg1.getChild("LeftHindLeg2");
		this.LeftHindLeg3 = LeftHindLeg2.getChild("LeftHindLeg3");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(-6.5F, -40.0F, 24.0F));

		PartDefinition Box_r1 = body.addOrReplaceChild("Box_r1", CubeListBuilder.create().texOffs(161, 193).addBox(6.0F, -25.0F, -14.0F, 0.0F, 3.0F, 69.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-13.0F, -22.0F, -16.0F, 38.0F, 47.0F, 73.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 3.0F, -38.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Neck1 = body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(158, 208).addBox(1.0F, -28.9938F, 9.9875F, 0.0F, 20.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 209).addBox(-7.0F, -28.9938F, -15.0125F, 16.0F, 49.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -6.0F, -52.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(82, 209).addBox(-1.0F, -47.0F, -10.0F, 7.0F, 50.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, -14).addBox(2.5F, -50.0F, -5.0F, 0.0F, 53.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -28.9938F, -1.0125F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(128, 209).addBox(-4.0F, -3.8535F, -5.994F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(128, 224).addBox(-3.0F, 0.1465F, -11.994F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(232, 113).addBox(-2.5F, 2.6465F, -11.4435F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -43.1468F, -5.9935F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(128, 233).addBox(-4.0F, 0.0F, -7.0F, 8.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(128, 243).addBox(-3.0F, 1.0F, -13.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(209, 120).addBox(-2.0F, 0.0F, -12.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(128, 251).addBox(-3.0F, -4.0F, -5.5F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.1406F, 1.006F));

		PartDefinition Nose = Head.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(253, 112).addBox(2.5F, 3.0F, -5.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -6.8535F, -4.9435F));

		PartDefinition Tail1 = body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 120).addBox(-5.5F, -9.0F, -1.0F, 16.0F, 23.0F, 66.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 4.0F, 18.0F, -0.2094F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(164, 119).addBox(-4.0F, -6.0F, -1.0F, 8.0F, 11.0F, 63.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 2.0F, 65.0F, 0.1F, 0.0F, 0.0F));

		PartDefinition RightFrontLeg = body.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(164, 193).addBox(-6.0F, -6.0F, -5.5F, 10.0F, 46.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(23.5F, 24.0F, -42.0F));

		PartDefinition RightThumb = RightFrontLeg.addOrReplaceChild("RightThumb", CubeListBuilder.create().texOffs(150, 251).addBox(3.0F, -1.0F, 0.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, 38.0F, -2.5F));

		PartDefinition LeftFrontLeg = body.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(164, 193).addBox(-4.0F, -6.0F, -5.5F, 10.0F, 46.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.5F, 24.0F, -42.0F));

		PartDefinition LeftThumb = LeftFrontLeg.addOrReplaceChild("LeftThumb", CubeListBuilder.create().texOffs(150, 256).addBox(1.0F, -1.0F, 0.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 38.0F, -2.5F));

		PartDefinition RightHindLeg1 = partdefinition.addOrReplaceChild("RightHindLeg1", CubeListBuilder.create().texOffs(208, 0).addBox(-5.5F, -5.0F, -14.0F, 14.0F, 38.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(14.5F, -36.0F, 31.0F));

		PartDefinition RightHindLeg2 = RightHindLeg1.addOrReplaceChild("RightHindLeg2", CubeListBuilder.create().texOffs(0, 120).addBox(-4.5F, 6.0F, -10.0F, 12.0F, 24.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -1.0F));

		PartDefinition RightHindLeg3 = RightHindLeg2.addOrReplaceChild("RightHindLeg3", CubeListBuilder.create().texOffs(98, 120).mirror().addBox(-6.5F, 0.0F, -19.0F, 16.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 30.0F, 1.0F));

		PartDefinition LeftHindLeg1 = partdefinition.addOrReplaceChild("LeftHindLeg1", CubeListBuilder.create().texOffs(208, 0).addBox(-8.5F, -5.0F, -14.0F, 14.0F, 38.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.5F, -36.0F, 31.0F));

		PartDefinition LeftHindLeg2 = LeftHindLeg1.addOrReplaceChild("LeftHindLeg2", CubeListBuilder.create().texOffs(0, 120).addBox(-7.5F, 6.0F, -10.0F, 12.0F, 24.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, -1.0F));

		PartDefinition LeftHindLeg3 = LeftHindLeg2.addOrReplaceChild("LeftHindLeg3", CubeListBuilder.create().texOffs(98, 120).addBox(-8.0F, 0.0F, -16.0F, 16.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 30.0F, -2.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(Camarasaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0F;
		float degree = 1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.body.y = Mth.lerp(sleepProgress, -40, -4.8F);
				this.body.yRot = Mth.lerp(sleepProgress, 0, -0.038920842652368684F);
				this.body.zRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.Neck1.x = Mth.lerp(sleepProgress, 5.5F, 7F);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0.6981F, 1.2162978572970231F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0, -0.3294172592861477F);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0, 0.51728612207217244F);
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.1745F, -0.42775073568927633F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.Neck2.zRot = Mth.lerp(sleepProgress, 0, 0.7510520131558576F);
				this.Tail1.z = Mth.lerp(sleepProgress, 18, 17);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.2094F, -0.24260075936930908F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.2864306020384839F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, 0.3127630032889644F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.1F, 0.4518657326886875F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 0.19547687289441354F);
				this.RightFrontLeg.y = Mth.lerp(sleepProgress, 24, 17.0F);
				this.RightFrontLeg.xRot = Mth.lerp(sleepProgress, 0, -1.1405726395466833F);
				this.RightFrontLeg.yRot = Mth.lerp(sleepProgress, 0, 0.069269908169872414F);
				this.LeftFrontLeg.xRot = Mth.lerp(sleepProgress, 0, -1.4189378856769737F);
				this.LeftFrontLeg.yRot = Mth.lerp(sleepProgress, 0, -0.03039819087864056F);
				this.RightHindLeg1.y = Mth.lerp(sleepProgress, -36, -4.25F);
				this.RightHindLeg1.xRot = Mth.lerp(sleepProgress, 0, 0.6472F);
				this.RightHindLeg1.yRot = Mth.lerp(sleepProgress, 0, -0.0018F);
				this.RightHindLeg1.zRot = Mth.lerp(sleepProgress, 0, -0.1531F);
				this.RightHindLeg2.z = Mth.lerp(sleepProgress, -1, -7F);
				this.RightHindLeg2.xRot = Mth.lerp(sleepProgress, 0, 0.9163F);
				this.LeftHindLeg1.y = Mth.lerp(sleepProgress, -36, 0.25F);
				this.LeftHindLeg1.xRot = Mth.lerp(sleepProgress, 0, 0.3748F);
				this.LeftHindLeg1.zRot = Mth.lerp(sleepProgress, 0, 0.2251F);
				this.LeftHindLeg2.z = Mth.lerp(sleepProgress, -1, -5);
				this.LeftHindLeg2.xRot = Mth.lerp(sleepProgress, 0, 1.1345F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.body.y = Mth.lerp(sleepProgress, -4.8F, -40F);
				this.body.yRot = Mth.lerp(sleepProgress, -0.038920842652368684F, 0);
				this.body.zRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.Neck1.x = Mth.lerp(sleepProgress, 7F, 5.5F);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 1.2162978572970231F, 0.6981F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, -0.3294172592861477F, 0);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0.51728612207217244F, 0);
				this.Neck2.xRot = Mth.lerp(sleepProgress, -0.42775073568927633F, -0.1745F);
				this.Neck2.yRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.Neck2.zRot = Mth.lerp(sleepProgress, 0.7510520131558576F, 0);
				this.Tail1.z = Mth.lerp(sleepProgress, 17, 18);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.24260075936930908F, -0.2094F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.2864306020384839F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0.3127630032889644F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.4518657326886875F, 0.1F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0.19547687289441354F, 0);
				this.RightFrontLeg.y = Mth.lerp(sleepProgress, 17.0F, 24);
				this.RightFrontLeg.xRot = Mth.lerp(sleepProgress, -1.1405726395466833F, 0);
				this.RightFrontLeg.yRot = Mth.lerp(sleepProgress, 0.069269908169872414F, 0);
				this.LeftFrontLeg.xRot = Mth.lerp(sleepProgress, -1.4189378856769737F, 0);
				this.LeftFrontLeg.yRot = Mth.lerp(sleepProgress, -0.03039819087864056F, 0);
				this.RightHindLeg1.y = Mth.lerp(sleepProgress, -4.25F, -36);
				this.RightHindLeg1.xRot = Mth.lerp(sleepProgress, 0.6472F, 0);
				this.RightHindLeg1.yRot = Mth.lerp(sleepProgress, -0.0018F, 0);
				this.RightHindLeg1.zRot = Mth.lerp(sleepProgress, -0.1531F, 0);
				this.RightHindLeg2.z = Mth.lerp(sleepProgress, -7, -1);
				this.RightHindLeg2.xRot = Mth.lerp(sleepProgress, 0.9163F, 0);
				this.LeftHindLeg1.y = Mth.lerp(sleepProgress, 0.25F, -36);
				this.LeftHindLeg1.xRot = Mth.lerp(sleepProgress, 0.3748F, 0);
				this.LeftHindLeg1.zRot = Mth.lerp(sleepProgress, 0.2251F, 0);
				this.LeftHindLeg2.z = Mth.lerp(sleepProgress, -5, -1);
				this.LeftHindLeg2.xRot = Mth.lerp(sleepProgress, 1.1345F, 0);
			} else {
				this.body.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.2094F);
				this.Tail1.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.Tail1.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.1F);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.5F * limbSwingAmount);
				this.Neck1.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.6981F) + (headPitch * ((float) Math.PI / 180F)) + (attackProgress * (float)Math.toRadians(50));
				this.Neck1.yRot = (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 270F));
				this.Neck2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1745F;
				this.Neck2.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount;
				this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.3927F);
				this.RightHindLeg1.xRot = Mth.cos(limbSwing * 0.3F) * 0.5F * limbSwingAmount;
				this.RightHindLeg2.xRot = Mth.cos(limbSwing * 0.3F) * 0.2F * limbSwingAmount;
				this.RightHindLeg3.xRot = Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
				this.LeftHindLeg1.xRot = -Mth.cos(limbSwing * 0.3F) * 0.5F * limbSwingAmount;
				this.LeftHindLeg2.xRot = Mth.cos(4.0F + limbSwing * 0.3F) * 0.2F * limbSwingAmount;
				this.LeftHindLeg3.xRot = Mth.cos(5.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
				this.RightFrontLeg.xRot = (Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(40));
				this.LeftFrontLeg.xRot = -(Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(60));
				this.body.xRot = attackProgress * (float)Math.toRadians(-50);
				if (entity.isEating()) {
					this.Neck1.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.5F) + 0.5F) + ((Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F));
					this.Neck2.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.25F) + 0.5F) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.05F);
				}
				if (entity.isInWater()) {
					this.body.y = 30;
//					this.body.xRot = -0.125F;
//					this.Tail1.xRot = 0.125F;
//					this.Tail2.xRot = 0.125F;
					this.RightHindLeg1.y = 36;
					this.LeftHindLeg1.y = 36;
					this.RightHindLeg1.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftHindLeg1.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftFrontLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFrontLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightHindLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftHindLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightHindLeg3.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftHindLeg3.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
//					this.Neck1.xRot = 0.5F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.body.y =  -40.0F;
		this.body.yRot = 0;
		this.body.zRot = 0;
		this.RightFrontLeg.x = 23.5F;
		this.RightFrontLeg.y = 24.0F;
		this.RightFrontLeg.z = -42.0F;
		this.RightFrontLeg.xRot = 0;
		this.RightFrontLeg.yRot = 0;
		this.RightFrontLeg.zRot = 0;
		this.Tail1.z = 18;
		this.Tail1.xRot = -0.2094F;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.LeftFrontLeg.x = -10.5F;
		this.LeftFrontLeg.y = 24F;
		this.LeftFrontLeg.z = -42F;
		this.LeftFrontLeg.xRot = 0;
		this.LeftFrontLeg.yRot = 0;
		this.LeftHindLeg3.y = 30;
		this.LeftHindLeg3.z = -2;
		this.LeftHindLeg3.xRot = 0;
		this.LeftHindLeg3.zRot = 0;
		this.LeftHindLeg2.y = 24.0F;
		this.LeftHindLeg2.z = -1;
		this.LeftHindLeg2.xRot = 0;
		this.LeftHindLeg2.yRot = 0;
		this.LeftHindLeg2.zRot = 0;
		this.Neck2.xRot = -0.1745F;
		this.Neck2.yRot = 0;
		this.Neck2.zRot = 0;
		this.RightHindLeg3.xRot = 0;
		this.RightHindLeg3.y = 30;
		this.RightHindLeg3.z = 1;
		this.RightHindLeg2.y = 24;
		this.RightHindLeg2.z = -1;
		this.RightHindLeg2.xRot = 0;
		this.LeftHindLeg1.x = -14.5F;
		this.LeftHindLeg1.y = -36;
		this.LeftHindLeg1.z = 31;
		this.LeftHindLeg1.xRot = 0;
		this.LeftHindLeg1.yRot = 0;
		this.LeftHindLeg1.zRot = 0;
		this.RightHindLeg1.x = 14.5F;
		this.RightHindLeg1.y = -36;
		this.RightHindLeg1.xRot = 0;
		this.RightHindLeg1.yRot = 0;
		this.Neck1.x = 5.5F;
		this.Neck1.y = -6;
		this.Neck1.z = -52;
		this.Neck1.xRot = 0.6981F;
		this.Neck1.yRot = 0;
		this.Neck1.zRot = 0;
		this.Tail2.xRot = 0.1F;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.Head.x = 2.5F;
		this.Head.z = -5.9935F;
		this.Head.xRot = -0.3927F;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.RightHindLeg1.zRot = 0;
	}

	public void sleepPose() {
		this.body.y = -4.8F;
		this.body.yRot = -0.038920842652368684F;
		this.body.zRot = -0.1563815016444822F;
		this.Neck1.x = 7F;
		this.Neck1.xRot = 1.2162978572970231F;
		this.Neck1.yRot = -0.3294172592861477F;
		this.Neck1.zRot = 0.51728612207217244F;
		this.Neck2.xRot = -0.42775073568927633F;
		this.Neck2.yRot = -0.1563815016444822F;
		this.Neck2.zRot = 0.7510520131558576F;
		this.Tail1.z = 17;
		this.Tail1.xRot = -0.24260075936930908F;
		this.Tail1.yRot = 0.2864306020384839F;
		this.Tail1.zRot = 0.3127630032889644F;
		this.Tail2.xRot = 0.4518657326886875F;
		this.Tail2.yRot = 0.3909537457888271F;
		this.Tail2.zRot = 0.19547687289441354F;
		this.RightFrontLeg.y = 17.0F;
		this.RightFrontLeg.xRot = -1.1405726395466833F;
		this.RightFrontLeg.yRot = 0.069269908169872414F;
		this.LeftFrontLeg.xRot = -1.4189378856769737F;
		this.LeftFrontLeg.yRot = -0.03039819087864056F;
		this.RightHindLeg1.y = -4.25F;
		this.RightHindLeg1.xRot = 0.6472F;
		this.RightHindLeg1.yRot = -0.0018F;
		this.RightHindLeg1.zRot = -0.1531F;
		this.RightHindLeg2.z = -7F;
		this.RightHindLeg2.xRot = 0.9163F;
		this.LeftHindLeg1.y = 0.25F;
		this.LeftHindLeg1.xRot = 0.3748F;
		this.LeftHindLeg1.zRot = 0.2251F;
		this.LeftHindLeg2.z = -5;
		this.LeftHindLeg2.xRot = 1.1345F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightHindLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftHindLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}