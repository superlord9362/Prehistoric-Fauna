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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camarasaurus;

public class CamarasaurusModel extends EntityModel<Camarasaurus> {
	private final ModelPart body;
	private final ModelPart RightFrontLeg;
	private final ModelPart LeftFrontLeg;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Head;
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

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 2).addBox(-25.0F, -20.0F, -54.0F, 50.0F, 50.0F, 80.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -41.0F, 14.0F));

		PartDefinition Neck1 = body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(0, 300).addBox(-9.0F, -45.0F, -19.0F, 18.0F, 53.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, -49.0F, -24.75F, 0.0F, 0.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(104, 300).addBox(-6.0F, -47.0F, -14.0F, 12.0F, 54.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -45.0F, 0.0F, -0.05F, 0.0F, 0.0F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, 0.0F, -15.0F, 14.0F, 17.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -47.1F, -2.0F, -0.1F, 0.0F, 0.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 54).addBox(-5.0F, 0.0F, -10.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, -15.0F));

		PartDefinition Head2 = Head.addOrReplaceChild("Head2", CubeListBuilder.create().texOffs(37, 39).addBox(-3.0F, -8.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 8.0F, -15.0F));

		PartDefinition Spikes = Neck2.addOrReplaceChild("Spikes", CubeListBuilder.create().texOffs(64, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -47.0F, 6.0F));

		PartDefinition Tail1 = body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(193, 72).addBox(-12.0F, -7.0F, -7.0F, 24.0F, 25.0F, 71.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 26.0F, -0.2F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(213, 179).addBox(-7.0F, -3.0F, -5.0F, 14.0F, 15.0F, 65.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 64.0F, 0.1F, 0.0F, 0.0F));

		PartDefinition RightFrontLeg = body.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(0, 139).addBox(-7.5F, -10.0F, -7.5F, 15.0F, 61.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(19.5F, 14.0F, -42.0F));

		PartDefinition RightThumb = RightFrontLeg.addOrReplaceChild("RightThumb", CubeListBuilder.create().texOffs(0, 221).addBox(-4.0F, -1.0F, -1.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.5F, 49.0F, -4.5F));

		PartDefinition LeftFrontLeg = body.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(0, 139).mirror().addBox(-7.5F, -10.0F, -7.5F, 15.0F, 61.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-19.5F, 14.0F, -42.0F));

		PartDefinition LeftThumb = LeftFrontLeg.addOrReplaceChild("LeftThumb", CubeListBuilder.create().texOffs(0, 221).mirror().addBox(0.0F, -1.0F, -1.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(7.5F, 49.0F, -4.5F));

		PartDefinition RightHindLeg1 = partdefinition.addOrReplaceChild("RightHindLeg1", CubeListBuilder.create().texOffs(64, 135).addBox(-8.5F, -13.0F, -12.0F, 17.0F, 45.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(20.0F, -36.0F, 26.0F));

		PartDefinition RightHindLeg2 = RightHindLeg1.addOrReplaceChild("RightHindLeg2", CubeListBuilder.create().texOffs(81, 207).mirror().addBox(-7.5F, 0.0F, -8.0F, 15.0F, 30.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 24.0F, 3.0F, 0.05F, 0.0F, 0.0F));

		PartDefinition RightHindLeg3 = RightHindLeg2.addOrReplaceChild("RightHindLeg3", CubeListBuilder.create().texOffs(0, 223).addBox(-8.0F, 0.0F, -14.0F, 16.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 30.0F, 1.0F));

		PartDefinition LeftHindLeg1 = partdefinition.addOrReplaceChild("LeftHindLeg1", CubeListBuilder.create().texOffs(64, 135).mirror().addBox(-8.5F, -13.0F, -12.0F, 17.0F, 45.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-20.0F, -36.0F, 26.0F));

		PartDefinition LeftHindLeg2 = LeftHindLeg1.addOrReplaceChild("LeftHindLeg2", CubeListBuilder.create().texOffs(81, 207).mirror().addBox(-7.5F, 0.0F, -8.0F, 15.0F, 30.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 24.0F, 3.0F, 0.05F, 0.0F, 0.0F));

		PartDefinition LeftHindLeg3 = LeftHindLeg2.addOrReplaceChild("LeftHindLeg3", CubeListBuilder.create().texOffs(0, 223).mirror().addBox(-8.0F, 0.0F, -14.0F, 16.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 30.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 384, 384);
	}

	@Override
	public void setupAnim(Camarasaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float speed = 1.0F;
		float degree = 1.0F;
		if (entity.getFallingAsleepTicks() >= 31 && entity.getWakingTicks() >= 31) {
			if (entity.isAsleep()) {
				sleepPose();
			} else {
				resetModel();
				this.body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
				this.body.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount - 0.2F);
				this.Tail1.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.Tail1.zRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.1F * limbSwingAmount;
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.05F * ageInTicks / 5))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.2F * limbSwingAmount + 0.1F);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.05F * ageInTicks / 5)) + (Mth.cos(1.0F + limbSwing * speed * 0.15F) * degree * 0.5F * limbSwingAmount);
				this.Neck1.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F) + (headPitch * ((float) Math.PI / 180F)) + (attackProgress * (float)Math.toRadians(50) - 25F);
				this.Neck1.yRot = (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount) + (netHeadYaw * ((float) Math.PI / 180F));
				this.Neck2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.05F;
				this.Neck2.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.1F * limbSwingAmount;
				this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.1F);
				this.RightHindLeg1.xRot = Mth.cos(limbSwing * 0.3F) * 0.5F * limbSwingAmount;
				this.RightHindLeg2.xRot = Mth.cos(limbSwing * 0.3F) * 0.2F * limbSwingAmount + 0.05F;
				this.RightHindLeg3.xRot = Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
				this.LeftHindLeg1.xRot = Mth.cos(4.0F + limbSwing * 0.3F) * 0.5F * limbSwingAmount;
				this.LeftHindLeg2.xRot = Mth.cos(4.0F + limbSwing * 0.3F) * 0.2F * limbSwingAmount + 0.05F;
				this.LeftHindLeg3.xRot = Mth.cos(5.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount;
				this.RightFrontLeg.xRot = (Mth.cos(1.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(40));
				this.LeftFrontLeg.xRot = (Mth.cos(5.0F + limbSwing * 0.3F) * 0.4F * limbSwingAmount) + (attackProgress * (float)Math.toRadians(60));
				this.body.xRot = attackProgress * (float)Math.toRadians(-50);
				if (entity.isEating()) {
					this.Neck1.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.5F) + 0.5F) + ((Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.25F));
					this.Neck2.xRot = (Math.abs(Mth.sin(0.02F * ageInTicks) * 0.25F) + 0.5F) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.05F);
				}
				if (entity.isInWater()) {
					this.body.y = 8;
					this.body.xRot = -0.25F;
					this.Tail1.xRot = 0.125F;
					this.Tail2.xRot = 0.125F;
					this.RightHindLeg1.y = 14;
					this.LeftHindLeg1.y = 14;
					this.RightHindLeg1.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftHindLeg1.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftFrontLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFrontLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightHindLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftHindLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightHindLeg3.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftHindLeg3.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.Neck1.xRot = 0.5F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Body
			//this.body.y =  -41.0F;
			if (this.body.y > -41) this.body.y -= 0.15;
			if (this.body.yRot < 0) this.body.yRot += 0.05;
			if (this.body.zRot < 0) this.body.zRot += 0.05;
			//RightFrontLeg
			//this.RightFrontLeg.x = 19.5F;
			//this.RightFrontLeg.y = 14.0F;
			//this.RightFrontLeg.z = -42.0F;
			if (this.RightFrontLeg.x > 19.5) this.RightFrontLeg.x -= 0.15;
			if (this.RightFrontLeg.y > 14) this.RightFrontLeg.y -= 0.15;
			if (this.RightFrontLeg.z < -42) this.RightFrontLeg.z += 0.15;
			if (this.RightFrontLeg.xRot < 0) this.RightFrontLeg.xRot += 0.05;
			if (this.RightFrontLeg.yRot < 0) this.RightFrontLeg.yRot += 0.05;
			if (this.RightFrontLeg.zRot > 0) this.RightFrontLeg.zRot -= 0.05;
			//Tail1
			//this.Tail1.z = 26;
			if (this.RightFrontLeg.z < 26) this.RightFrontLeg.z += 0.15;
			if (this.RightFrontLeg.xRot < 0) this.RightFrontLeg.xRot += 0.05;
			if (this.RightFrontLeg.yRot > 0) this.RightFrontLeg.yRot -= 0.05;
			if (this.RightFrontLeg.zRot > 0) this.RightFrontLeg.zRot -= 0.05;
			//LeftFrontLeg
			//this.LeftFrontLeg.x = -19.5F;
			//this.LeftFrontLeg.y = 14F;
			//this.LeftFrontLeg.z = -42F;
			if (this.LeftFrontLeg.x < -19.5) this.LeftFrontLeg.x += 0.15;
			if (this.LeftFrontLeg.y < 14) this.LeftFrontLeg.y += 0.15;
			if (this.LeftFrontLeg.z > -42) this.LeftFrontLeg.z -= 0.15;
			if (this.LeftFrontLeg.xRot < 0) this.LeftFrontLeg.xRot += 0.05;
			if (this.LeftFrontLeg.yRot < 0) this.LeftFrontLeg.yRot += 0.05;
			//LeftHindLeg3
			//this.LeftHindLeg3.y = 30;
			//this.LeftHindLeg3.z = 1;
			if (this.LeftHindLeg3.y < 30) this.LeftHindLeg3.y += 0.15;
			if (this.LeftHindLeg3.z < 1) this.LeftHindLeg3.z += 0.15;
			if (this.LeftHindLeg3.xRot > 0) this.LeftHindLeg3.xRot -= 0.05;
			if (this.LeftHindLeg3.zRot < 0) this.LeftHindLeg3.zRot += 0.05;
			//LeftHindLeg2
			//this.LeftHindLeg2.y = 24.0F;
			//this.LeftHindLeg2.z = 3;
			if (this.LeftHindLeg2.y > 24) this.LeftHindLeg2.y -= 0.15;
			if (this.LeftHindLeg2.z < 3) this.LeftHindLeg2.z += 0.15;
			if (this.LeftHindLeg2.xRot > 0) this.LeftHindLeg2.xRot -= 0.05;
			//Neck2
			if (this.LeftHindLeg3.xRot > 0) this.LeftHindLeg3.xRot -= 0.05;
			if (this.LeftHindLeg3.yRot < 0) this.LeftHindLeg3.yRot += 0.05;
			if (this.LeftHindLeg3.zRot > 0) this.LeftHindLeg3.zRot -= 0.05;
			//RightHindLeg3
			//this.RightHindLeg3.y = 30;
			//this.RightHindLeg3.z = 1;
			if (this.RightHindLeg3.y < 30) this.RightHindLeg3.y += 0.15;
			if (this.RightHindLeg3.z < 1) this.RightHindLeg3.z += 0.15;
			if (this.RightHindLeg3.xRot > 0) this.RightHindLeg3.xRot -= 0.05;
			//RightHindLeg2
			//this.RightHindLeg2.y = 24;
			//this.RightHindLeg2.z = 3;
			if (this.RightHindLeg2.y > 24) this.RightHindLeg2.y -= 0.15;
			if (this.RightHindLeg2.z > 3) this.RightHindLeg2.z -= 0.15;
			if (this.RightHindLeg2.xRot > 0) this.RightHindLeg2.xRot -= 0.05;
			//LeftHindLeg1
			//this.LeftHindLeg1.x = -20;
			//this.LeftHindLeg1.y = -36;
			//this.LeftHindLeg1.z = 26;
			if (this.LeftHindLeg1.x < -20) this.LeftHindLeg1.x += 0.15;
			if (this.LeftHindLeg1.y > -36) this.LeftHindLeg1.y -= 0.15;
			if (this.LeftHindLeg1.z < 26) this.LeftHindLeg1.z += 0.15;
			if (this.LeftHindLeg1.xRot < 0) this.LeftHindLeg1.xRot += 0.05;
			if (this.LeftHindLeg1.yRot > 0) this.LeftHindLeg1.yRot -= 0.05;
			if (this.LeftHindLeg1.zRot > 0) this.LeftHindLeg1.zRot -= 0.05;
			//RightHindLeg1
			//this.RightHindLeg1.x = 20;
			//this.RightHindLeg1.y = -36;
			if (this.RightHindLeg1.x > 20) this.RightHindLeg1.x -= 0.15;
			if (this.RightHindLeg1.y > -36) this.RightHindLeg1.y -= 0.15;
			if (this.RightHindLeg1.xRot < 0) this.RightHindLeg1.xRot += 0.05;
			if (this.RightHindLeg1.yRot < 0) this.RightHindLeg1.yRot += 0.05;
			//Neck
			//this.Neck1.x = 0;
			//this.Neck1.y = 10;
			//this.Neck1.z = -49;
			//this.Neck1.xRot = 0.27314402127920984F;
			if (this.Neck1.x < 0) this.Neck1.x += 0.15;
			if (this.Neck1.y < 10) this.Neck1.y += 0.15;
			if (this.Neck1.z < -49) this.Neck1.z += 0.15;
			if (this.Neck1.xRot > 0.27314402127920984F) this.Neck1.xRot -= 0.05;
			if (this.Neck1.yRot < 0) this.Neck1.yRot += 0.05;
			if (this.Neck1.zRot > 0) this.Neck1.zRot -= 0.05;
			//Tail2
			if (this.Tail2.xRot > 0) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot > 0) this.Tail2.yRot -= 0.05;
			if (this.Tail2.zRot > 0) this.Tail2.zRot -= 0.05;
			//Head
			//this.Head.x = 0;
			//this.Head.z = -2;
			if (this.Head.x > 0) this.Head.x -= 0.15;
			if (this.Head.z > -2) this.Head.z -= 0.15;
			if (this.Head.xRot < 0) this.Head.xRot += 0.05;
			if (this.Head.yRot > 0) this.Head.yRot -= 0.05;
			if (this.Head.zRot > 0) this.Head.zRot -= 0.05;
		}
		if (entity.getFallingAsleepTicks() < 31) {
			//Body
			//this.body.y =  -41.0F;
			if (this.body.y < -4.8) this.body.y += 0.15;
			if (this.body.yRot > -0.038920842652368684F) this.body.yRot -= 0.05;
			if (this.body.zRot > -0.1563815016444822F) this.body.zRot -= 0.05;
			//RightFrontLeg
			//this.RightFrontLeg.x = 19.5F;
			//this.RightFrontLeg.y = 14.0F;
			//this.RightFrontLeg.z = -42.0F;
			if (this.RightFrontLeg.x < 25.5) this.RightFrontLeg.x += 0.15;
			if (this.RightFrontLeg.y < 17) this.RightFrontLeg.y += 0.15;
			if (this.RightFrontLeg.z > -43) this.RightFrontLeg.z -= 0.15;
			if (this.RightFrontLeg.xRot > -1.1405726395466833F) this.RightFrontLeg.xRot -= 0.05;
			if (this.RightFrontLeg.yRot > -0.039269908169872414F) this.RightFrontLeg.yRot -= 0.05;
			if (this.RightFrontLeg.zRot < 0.3909537457888271F) this.RightFrontLeg.zRot += 0.05;
			//Tail1
			//this.Tail1.z = 26;
			if (this.RightFrontLeg.z > 21) this.RightFrontLeg.z -= 0.15;
			if (this.RightFrontLeg.xRot > -0.24260075936930908F) this.RightFrontLeg.xRot -= 0.05;
			if (this.RightFrontLeg.yRot < 0.5864306020384839F) this.RightFrontLeg.yRot += 0.05;
			if (this.RightFrontLeg.zRot < 0.3127630032889644F) this.RightFrontLeg.zRot += 0.05;
			//LeftFrontLeg
			//this.LeftFrontLeg.x = -19.5F;
			//this.LeftFrontLeg.y = 14F;
			//this.LeftFrontLeg.z = -42F;
			if (this.LeftFrontLeg.x > -25.5) this.LeftFrontLeg.x -= 0.15;
			if (this.LeftFrontLeg.y > 12) this.LeftFrontLeg.y -= 0.15;
			if (this.LeftFrontLeg.z < -41) this.LeftFrontLeg.z += 0.15;
			if (this.LeftFrontLeg.xRot > -1.2189378856769737F) this.LeftFrontLeg.xRot -= 0.05;
			if (this.LeftFrontLeg.yRot > -0.43039819087864056F) this.LeftFrontLeg.yRot -= 0.05;
			//LeftHindLeg3
			//this.LeftHindLeg3.y = 30;
			//this.LeftHindLeg3.z = 1;
			if (this.LeftHindLeg3.y > 26.2) this.LeftHindLeg3.y -= 0.15;
			if (this.LeftHindLeg3.z > -3) this.LeftHindLeg3.z -= 0.15;
			if (this.LeftHindLeg3.xRot < 0.3874631072585466F) this.LeftHindLeg3.xRot += 0.05;
			if (this.LeftHindLeg3.zRot > -0.10471975511965977F) this.LeftHindLeg3.zRot -= 0.05;
			//LeftHindLeg2
			//this.LeftHindLeg2.y = 24.0F;
			//this.LeftHindLeg2.z = 3;
			if (this.LeftHindLeg2.y < 24.02) this.LeftHindLeg2.y += 0.15;
			if (this.LeftHindLeg2.z > 0) this.LeftHindLeg2.z -= 0.15;
			if (this.LeftHindLeg2.xRot < 1.5707963267948966F) this.LeftHindLeg2.xRot += 0.05;
			//Neck2
			if (this.LeftHindLeg3.xRot < 0.02775073568927633F) this.LeftHindLeg3.xRot += 0.05;
			if (this.LeftHindLeg3.yRot > -0.1563815016444822F) this.LeftHindLeg3.yRot -= 0.05;
			if (this.LeftHindLeg3.zRot < 1.2510520131558576F) this.LeftHindLeg3.zRot += 0.05;
			//RightHindLeg3
			//this.RightHindLeg3.y = 30;
			//this.RightHindLeg3.z = 1;
			if (this.RightHindLeg3.y > 24.6) this.RightHindLeg3.y -= 0.15;
			if (this.RightHindLeg3.z > -2) this.RightHindLeg3.z -= 0.15;
			if (this.RightHindLeg3.xRot < 0.3490658503988659F) this.RightHindLeg3.xRot += 0.05;
			//RightHindLeg2
			//this.RightHindLeg2.y = 24;
			//this.RightHindLeg2.z = 3;
			if (this.RightHindLeg2.y < 24.02) this.RightHindLeg2.y += 0.15;
			if (this.RightHindLeg2.z < 4) this.RightHindLeg2.z += 0.15;
			if (this.RightHindLeg2.xRot < 1.5707963267948966F) this.RightHindLeg2.xRot += 0.05;
			//LeftHindLeg1
			//this.LeftHindLeg1.x = -20;
			//this.LeftHindLeg1.y = -36;
			//this.LeftHindLeg1.z = 26;
			if (this.LeftHindLeg1.x > -24) this.LeftHindLeg1.x -= 0.15;
			if (this.LeftHindLeg1.y < 4) this.LeftHindLeg1.y += 0.15;
			if (this.LeftHindLeg1.z > -24) this.LeftHindLeg1.z -= 0.15;
			if (this.LeftHindLeg1.xRot > -1.9198621771937625F) this.LeftHindLeg1.xRot -= 0.05;
			if (this.LeftHindLeg1.yRot < 0.3839724354387525F) this.LeftHindLeg1.yRot += 0.05;
			if (this.LeftHindLeg1.zRot < 0.10471975511965977F) this.LeftHindLeg1.zRot += 0.05;
			//RightHindLeg1
			//this.RightHindLeg1.x = 20;
			//this.RightHindLeg1.y = -36;
			if (this.RightHindLeg1.x < 24) this.RightHindLeg1.x += 0.15;
			if (this.RightHindLeg1.y < 0) this.RightHindLeg1.y += 0.15;
			if (this.RightHindLeg1.xRot > -1.9198621771937625F) this.RightHindLeg1.xRot -= 0.05;
			if (this.RightHindLeg1.yRot > -0.5082398595386212F) this.RightHindLeg1.yRot -= 0.05;
			//Neck
			//this.Neck1.x = 0;
			//this.Neck1.y = 10;
			//this.Neck1.z = -49;
			//this.Neck1.xRot = 0.27314402127920984F;
			if (this.Neck1.x > -6.2) this.Neck1.x -= 0.15;
			if (this.Neck1.y > -8) this.Neck1.y -= 0.15;
			if (this.Neck1.z > -52) this.Neck1.z -= 0.15;
			if (this.Neck1.xRot < 0.9162978572970231F) this.Neck1.xRot += 0.05;
			if (this.Neck1.yRot > -1.3294172592861477F) this.Neck1.yRot -= 0.05;
			if (this.Neck1.zRot < 0.11728612207217244F) this.Neck1.zRot += 0.05;
			//Tail2
			if (this.Tail2.xRot < 0.4518657326886875F) this.Tail2.xRot += 0.05;
			if (this.Tail2.yRot < 0.3909537457888271F) this.Tail2.yRot += 0.05;
			if (this.Tail2.zRot < 0.19547687289441354F) this.Tail2.zRot += 0.05;
			//Head
			//this.Head.x = 0;
			//this.Head.z = -2;
			if (this.Head.x < 1) this.Head.x += 0.15;
			if (this.Head.z < 0) this.Head.z += 0.15;
			if (this.Head.xRot > -0.5269149104981519F) this.Head.xRot -= 0.05;
			if (this.Head.yRot < 0.03909537541112055F) this.Head.yRot += 0.05;
			if (this.Head.zRot < 0.2562143561638466F) this.Head.zRot += 0.05;
		}
	}

	public void resetModel() {
		this.body.y =  -41.0F;
		this.body.yRot = 0;
		this.body.zRot = 0;
		this.RightFrontLeg.x = 19.5F;
		this.RightFrontLeg.y = 14.0F;
		this.RightFrontLeg.z = -42.0F;
		this.RightFrontLeg.xRot = 0;
		this.RightFrontLeg.yRot = 0;
		this.RightFrontLeg.zRot = 0;
		this.Tail1.z = 26;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.LeftFrontLeg.x = -19.5F;
		this.LeftFrontLeg.y = 14F;
		this.LeftFrontLeg.z = -42F;
		this.LeftFrontLeg.xRot = 0;
		this.LeftFrontLeg.yRot = 0;
		this.LeftHindLeg3.y = 30;
		this.LeftHindLeg3.z = 1;
		this.LeftHindLeg3.xRot = 0;
		this.LeftHindLeg3.zRot = 0;
		this.LeftHindLeg2.y = 24.0F;
		this.LeftHindLeg2.z = 3;
		this.LeftHindLeg2.xRot = 0;
		this.LeftHindLeg2.yRot = 0;
		this.LeftHindLeg2.zRot = 0;
		this.Neck2.xRot = 0;
		this.Neck2.yRot = 0;
		this.Neck2.zRot = 0;
		this.RightHindLeg3.xRot = 0;
		this.RightHindLeg3.y = 30;
		this.RightHindLeg3.z = 1;
		this.RightHindLeg2.y = 24;
		this.RightHindLeg2.z = 3;
		this.RightHindLeg2.xRot = 0;
		this.LeftHindLeg1.x = -20;
		this.LeftHindLeg1.y = -36;
		this.LeftHindLeg1.z = 26;
		this.LeftHindLeg1.xRot = 0;
		this.LeftHindLeg1.yRot = 0;
		this.LeftHindLeg1.zRot = 0;
		this.RightHindLeg1.x = 20;
		this.RightHindLeg1.y = -36;
		this.RightHindLeg1.xRot = 0;
		this.RightHindLeg1.yRot = 0;
		this.Neck1.x = 0;
		this.Neck1.y = 10;
		this.Neck1.z = -49;
		this.Neck1.xRot = 0.27314402127920984F;
		this.Neck1.yRot = 0;
		this.Neck1.zRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.Head.x = 0;
		this.Head.z = -2;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
	}

	public void sleepPose() {
		this.body.y = -4.8F;
		this.body.yRot = -0.038920842652368684F;
		this.body.zRot = -0.1563815016444822F;
		this.RightFrontLeg.x = 25.5F;
		this.RightFrontLeg.y = 17.0F;
		this.RightFrontLeg.z = -43.0F;
		this.RightFrontLeg.xRot = -1.1405726395466833F;
		this.RightFrontLeg.yRot = -0.039269908169872414F;
		this.RightFrontLeg.zRot = 0.3909537457888271F;
		this.Tail1.z = 21;
		this.Tail1.xRot = -0.24260075936930908F;
		this.Tail1.yRot = 0.5864306020384839F;
		this.Tail1.zRot = 0.3127630032889644F;
		this.LeftFrontLeg.x = -25.5F;
		this.LeftFrontLeg.y = 12;
		this.LeftFrontLeg.z = -41;
		this.LeftFrontLeg.xRot = -1.2189378856769737F;
		this.LeftFrontLeg.yRot = -0.43039819087864056F;
		this.LeftHindLeg3.y = 26.2F;
		this.LeftHindLeg3.z = -3.0F;
		this.LeftHindLeg3.xRot = 0.3874631072585466F;
		this.LeftHindLeg3.zRot = -0.10471975511965977F;
		this.LeftHindLeg2.xRot = 1.5707963267948966F;
		this.LeftHindLeg2.y = 24.02F;
		this.LeftHindLeg2.z = 0;
		this.Neck2.xRot = 0.02775073568927633F;
		this.Neck2.yRot = -0.1563815016444822F;
		this.Neck2.zRot = 1.2510520131558576F;
		this.RightHindLeg3.xRot = 0.3490658503988659F;
		this.RightHindLeg3.y = 24.6F;
		this.RightHindLeg3.z = -2F;
		this.RightHindLeg2.y = 24.02F;
		this.RightHindLeg2.z = 4;
		this.RightHindLeg2.xRot = 1.5707963267948966F;
		this.LeftHindLeg1.x = -24;
		this.LeftHindLeg1.y = 4;
		this.LeftHindLeg1.z = 24;
		this.LeftHindLeg1.xRot = -1.9198621771937625F;
		this.LeftHindLeg1.yRot = 0.3839724354387525F;
		this.LeftHindLeg1.zRot = 0.10471975511965977F;
		this.RightHindLeg1.x = 24;
		this.RightHindLeg1.y = 0;
		this.RightHindLeg1.xRot = -1.9198621771937625F;
		this.RightHindLeg1.yRot = -0.5082398595386212F;
		this.Neck1.x = -6.2F;
		this.Neck1.y = -8F;
		this.Neck1.z = -52;
		this.Neck1.xRot = 0.9162978572970231F;
		this.Neck1.yRot = -1.3294172592861477F;
		this.Neck1.zRot = 0.11728612207217244F;
		this.Tail2.xRot = 0.4518657326886875F;
		this.Tail2.yRot = 0.3909537457888271F;
		this.Tail2.zRot = 0.19547687289441354F;
		this.Head.x = 1;
		this.Head.z = 0;
		this.Head.xRot = -0.5269149104981519F;
		this.Head.yRot = 0.03909537541112055F;
		this.Head.zRot = 0.2562143561638466F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightHindLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftHindLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}