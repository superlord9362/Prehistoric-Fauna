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

public class DilophosaurusBabyModel extends EntityModel<Dilophosaurus> {
	private final ModelPart Torso;
	private final ModelPart LLeg;
	private final ModelPart LFoot;
	private final ModelPart RLeg;
	private final ModelPart RFoot;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart RForeleg;
	private final ModelPart LForeleg;
	private final ModelPart TailBase;

	public DilophosaurusBabyModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.LLeg = root.getChild("LLeg");
		this.LFoot = LLeg.getChild("LFoot");
		this.RLeg = root.getChild("RLeg");
		this.RFoot = RLeg.getChild("RFoot");
		this.RForeleg = Torso.getChild("RForeleg");
		this.LForeleg = Torso.getChild("LForeleg");
		this.Neck = Torso.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.TailBase = Torso.getChild("TailBase");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -6.0F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(27, 0).addBox(-1.0F, -5.0F, -2.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.1047F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(17, 0).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.01F, 0.0F, 0.0F)), PartPose.offset(0.0F, -4.0F, -1.5F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(17, 5).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition Nose = Snout.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(0, 28).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition Quills = Neck.addOrReplaceChild("Quills", CubeListBuilder.create().texOffs(20, 14).addBox(0.0F, -4.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.5F));

		PartDefinition TailBase = Torso.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(0, 16).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.1F, 11.0F));

		PartDefinition RForeleg = Torso.addOrReplaceChild("RForeleg", CubeListBuilder.create().texOffs(0, -3).addBox(0.0F, 0.0F, -1.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 3.0F, 2.0F, 0.0F, 0.0F, -0.1047F));

		PartDefinition LForeleg = Torso.addOrReplaceChild("LForeleg", CubeListBuilder.create().texOffs(0, -3).addBox(0.0F, 0.0F, -1.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 3.0F, 2.0F, 0.0F, 0.0F, 0.1047F));

		PartDefinition LLeg = partdefinition.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -1.5F, -2.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 15.5F, 2.0F));

		PartDefinition LFoot = LLeg.addOrReplaceChild("LFoot", CubeListBuilder.create().texOffs(23, 17).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 4.5F, 1.0F));

		PartDefinition RLeg = partdefinition.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-0.5F, -1.5F, -2.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 15.5F, 2.0F));

		PartDefinition RFoot = RLeg.addOrReplaceChild("RFoot", CubeListBuilder.create().texOffs(23, 17).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 4.5F, 1.0F));

		return LayerDefinition.create(meshdefinition, 37, 36);
	}

	@Override
	public void setupAnim(Dilophosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 1.0f;
		float walkDegree = 0.5f;
		float idleSpeed = 1.0f;
		float idleDegree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress =  entity.getMeleeProgress(partialTick);
		if (entity.getWakingTicks() >= 31 && entity.getFallingAsleepTicks() >= 31) {
			if (entity.isAsleep()) {
				sleepPose();
			} else {
				resetModel();
				this.Neck.xRot = (Mth.cos(-1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount + 0.35F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(35F);
				this.Torso.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
				this.TailBase.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos((limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
				this.TailBase.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos((limbSwing / 3) * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
				this.Head.xRot = Mth.cos(-1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount - 0.2F + attackProgress * (float) Math.toRadians(-35F);
				this.RForeleg.xRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos((limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.LForeleg.xRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(2.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.RLeg.xRot = Mth.cos(1.0F + (limbSwing / 3) * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.05F;
				this.LFoot.xRot = Mth.cos(1.0F + (limbSwing / 3) * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.05F;
				this.LLeg.xRot = Mth.cos(1.0F + (limbSwing / 3) * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.05F;
				this.LFoot.xRot = Mth.cos(1.0F + (limbSwing / 3) * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.05F;
				this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isInWater()) {
					this.RLeg.y = 20;
					this.LLeg.y = 20;
					this.Torso.y = 15;
					this.Torso.xRot = -0.25F;
					this.TailBase.xRot = 0.125F;
					this.Neck.xRot = 0.5F;
					this.RLeg.xRot = -0.24271F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LLeg.xRot = 0.24271F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LForeleg.xRot = 0.25F;
					this.RForeleg.xRot = 0.25F;
					this.RFoot.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LFoot.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.TailBase.yRot = (Mth.cos((limbSwing / 3) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Head
			//this.Head.y = -4.0F;
			if (this.Head.y < -4) this.Head.y += 0.15;
			if (this.Head.xRot < 0) this.Head.xRot += 0.05;
			if (this.Head.yRot > 0) this.Head.yRot -= 0.05;
			if (this.Head.zRot > 0) this.Head.zRot -= 0.05;
			//RFoot
			//this.RFoot.xRot = 0.10000736647217022F;
			if (this.RFoot.xRot < 0.10000736647217022F) this.RFoot.xRot += 0.05;
			if (this.RFoot.yRot < 0) this.RFoot.yRot += 0.05;
			if (this.RFoot.zRot > 0) this.RFoot.zRot -= 0.05;
			//Neck
			//this.Neck.y = 2.0F;
			//this.Neck.xRot = 0.1047F;
			if (this.Neck.y < 2) this.Neck.y += 0.15;
			if (this.Neck.xRot > 0.1047) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot > 0) this.Neck.yRot -= 0.05;
			if (this.Neck.zRot < 0) this.Neck.zRot += 0.05;
			//TailBase
			//this.TailBase.y = 1.1F;
			if (this.TailBase.y > 1.1) this.TailBase.y -= 0.15;
			if (this.TailBase.xRot < 0) this.TailBase.xRot += 0.05;
			if (this.TailBase.yRot < 0) this.TailBase.yRot += 0.05;
			//Torso
			//this.Torso.y = 13.0F;
			if (this.Torso.y > 13) this.Torso.y -= 0.15;
			if (this.Torso.xRot < 0) this.Torso.xRot += 0.05;
			if (this.Torso.yRot < 0) this.Torso.yRot += 0.05;
			if (this.Torso.zRot < 0) this.Torso.zRot += 0.05;
			//LForeleg
			//this.LForeleg.x = -1.5F;
			//this.LForeleg.y = 3.0F;
			//this.LForeleg.zRot = 0.1047F;
			if (this.LForeleg.x < -1.5) this.LForeleg.x += 0.15;
			if (this.LForeleg.y < 3) this.LForeleg.y += 0.15;
			if (this.LForeleg.xRot < 0) this.LForeleg.xRot += 0.05;
			if (this.LForeleg.yRot < 0) this.LForeleg.yRot += 0.05;
			if (this.LForeleg.zRot < 0.1047) this.LForeleg.zRot += 0.05;
			//LFoot
			if (this.LFoot.xRot < 0) this.LFoot.xRot += 0.05;
			if (this.LFoot.yRot < 0) this.LFoot.yRot += 0.05;
			if (this.LFoot.zRot < 0) this.LFoot.zRot += 0.05;
			//RLeg
			//this.RLeg.x = 1.0F;
			//this.RLeg.y = 15.5F;
			//this.RLeg.z = 2.0F;
			if (this.RLeg.x < 1) this.RLeg.x += 0.15;
			if (this.RLeg.y > 15.5) this.RLeg.y -= 0.15;
			if (this.RLeg.z > 2) this.RLeg.z -= 0.15;
			if (this.RLeg.xRot < 0) this.RLeg.xRot += 0.05;
			if (this.RLeg.yRot < 0) this.RLeg.yRot += 0.05;
			if (this.RLeg.zRot < 0) this.RLeg.zRot += 0.05;
			//LLeg
			//this.LLeg.x = -1.5F;
			//this.LLeg.y = 15.5F;
			if (this.LLeg.x > -1.5) this.LLeg.x -= 0.15;
			if (this.LLeg.y > 15.5) this.LLeg.y -= 0.15;
			if (this.LLeg.xRot > 0) this.LLeg.xRot -= 0.05;
			if (this.LLeg.yRot < 0) this.LLeg.yRot += 0.05;
			if (this.LLeg.zRot < 0) this.LLeg.zRot += 0.05;
			//RForeleg
			//this.RForeleg.y = 3.0F;
			//this.RForeleg.zRot = -0.1047F;
			if (this.RForeleg.y > 3) this.RForeleg.y -= 0.15;
			if (this.RForeleg.xRot > -0.1047) this.RForeleg.xRot -= 0.05;
			if (this.RForeleg.zRot > 0) this.RForeleg.zRot -= 0.05;
		}
		if (entity.getFallingAsleepTicks() < 31) {
			//Head
			//this.Head.y = -4.0F;
			if (this.Head.y > -5) this.Head.y -= 0.15;
			if (this.Head.xRot > -0.0781907508222411F) this.Head.xRot -= 0.05;
			if (this.Head.yRot < 0.03874630989361682F) this.Head.yRot += 0.05;
			if (this.Head.zRot < 0.19547687289441354F) this.Head.zRot += 0.05;
			//RFoot
			//this.RFoot.xRot = 0.10000736647217022F;
			if (this.RFoot.xRot > 0) this.RFoot.xRot -= 0.05;
			if (this.RFoot.yRot > -1.7453292129831807E-4F) this.RFoot.yRot -= 0.05;
			if (this.RFoot.zRot < 0.4300491170387584F) this.RFoot.zRot += 0.05;
			//Neck
			//this.Neck.y = 2.0F;
			//this.Neck.xRot = 0.1047F;
			if (this.Neck.y > 1) this.Neck.y -= 0.15;
			if (this.Neck.xRot < 1.6418312220247435F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot < 0.3122393925291412F) this.Neck.yRot += 0.05;
			if (this.Neck.zRot > -0.23457224414434488F) this.Neck.zRot -= 0.05;
			//TailBase
			//this.TailBase.y = 1.1F;
			if (this.TailBase.y < 2.1) this.TailBase.y += 0.15;
			if (this.TailBase.xRot > -0.27366763203903305F) this.TailBase.xRot -= 0.05;
			if (this.TailBase.yRot > -0.0781907508222411F) this.TailBase.yRot -= 0.05;
			//Torso
			//this.Torso.y = 13.0F;
			if (this.Torso.y < 19) this.Torso.y += 0.15;
			if (this.Torso.xRot > -0.11728612207217244F) this.Torso.xRot -= 0.05;
			if (this.Torso.yRot > -0.039269908169872414F) this.Torso.yRot -= 0.05;
			if (this.Torso.zRot > -1.2901473511162753F) this.Torso.zRot -= 0.05;
			//LForeleg
			//this.LForeleg.x = -1.5F;
			//this.LForeleg.y = 3.0F;
			//this.LForeleg.zRot = 0.1047F;
			if (this.LForeleg.x > -3) this.LForeleg.x -= 0.15;
			if (this.LForeleg.y > 2) this.LForeleg.y -= 0.15;
			if (this.LForeleg.xRot > -0.03909537541112055F) this.LForeleg.xRot -= 0.05;
			if (this.LForeleg.yRot > -0.03909537541112055F) this.LForeleg.yRot -= 0.05;
			if (this.LForeleg.zRot > -0.23457224414434488F) this.LForeleg.zRot -= 0.05;
			//LFoot
			if (this.LFoot.xRot > -0.4300491170387584F) this.LFoot.xRot -= 0.05;
			if (this.LFoot.yRot > -0.11728612207217244F) this.LFoot.yRot -= 0.05;
			if (this.LFoot.zRot > -0.19547687289441354F) this.LFoot.zRot -= 0.05;
			//RLeg
			//this.RLeg.x = 1.0F;
			//this.RLeg.y = 15.5F;
			//this.RLeg.z = 2.0F;
			if (this.RLeg.x > 0.5) this.RLeg.x -= 0.15;
			if (this.RLeg.y < 19) this.RLeg.y += 0.15;
			if (this.RLeg.z < 2.5) this.RLeg.z += 0.15;
			if (this.RLeg.xRot > -0.1563815016444822F) this.RLeg.xRot -= 0.05;
			if (this.RLeg.yRot > -1.7453292129831807E-4F) this.RLeg.yRot -= 0.05;
			if (this.RLeg.zRot > -1.0555751236166873F) this.RLeg.zRot -= 0.05;
			//LLeg
			//this.LLeg.x = -1.5F;
			//this.LLeg.y = 15.5F;
			if (this.LLeg.x < -0.5) this.LLeg.x += 0.15;
			if (this.LLeg.y < 21.2) this.LLeg.y += 0.15;
			if (this.LLeg.xRot < 0.4300491170387584F) this.LLeg.xRot += 0.05;
			if (this.LLeg.yRot > -0.11728612207217244F) this.LLeg.yRot -= 0.05;
			if (this.LLeg.zRot > -1.4467034063254554F) this.LLeg.zRot -= 0.05;
			//RForeleg
			//this.RForeleg.y = 3.0F;
			//this.RForeleg.zRot = -0.1047F;
			if (this.RForeleg.y < 5) this.RForeleg.y += 0.15;
			if (this.RForeleg.xRot < 0.2738421523142173F) this.RForeleg.xRot += 0.05;
			if (this.RForeleg.zRot < 0.7035422454473641F) this.RForeleg.zRot += 0.05;
		}
	}

	public void resetModel() {
		this.Head.y = -4.0F;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.RFoot.y = 4.4F;
		this.RFoot.z = 1.0F;
		this.RFoot.xRot = 0.10000736647217022F;
		this.RFoot.yRot = 0;
		this.RFoot.zRot = 0;
		this.Neck.x = 0.0F;
		this.Neck.y = 2.0F;
		this.Neck.z = 0.0F;
		this.Neck.xRot = 0.1047F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.TailBase.y = 1.1F;
		this.TailBase.xRot = 0;
		this.TailBase.yRot = 0;
		this.TailBase.yRot = 0;
		this.Torso.x = 0;
		this.Torso.y = 13.0F;
		this.Torso.xRot = 0;
		this.Torso.yRot = 0;
		this.Torso.zRot = 0;
		this.LForeleg.x = -1.5F;
		this.LForeleg.y = 3.0F;
		this.LForeleg.xRot = 0;
		this.LForeleg.yRot = 0;
		this.LForeleg.zRot = 0.1047F;
		this.LFoot.y = 4.4F;
		this.LFoot.xRot = 0;
		this.LFoot.yRot = 0;
		this.LFoot.zRot = 0;
		this.RLeg.x = 1.0F;
		this.RLeg.y = 15.5F;
		this.RLeg.z = 2.0F;
		this.RLeg.xRot = 0;
		this.RLeg.yRot = 0;
		this.RLeg.zRot = 0;
		this.LLeg.x = -1.5F;
		this.LLeg.y = 15.5F;
		this.LLeg.z = 2.0F;
		this.LLeg.xRot = 0;
		this.LLeg.yRot = 0;
		this.LLeg.zRot = 0;
		this.RForeleg.x = 1.5F;
		this.RForeleg.y = 3.0F;
		this.RForeleg.xRot = 0;
		this.RForeleg.yRot = 0;
		this.RForeleg.zRot = -0.1047F;
	}

	public void sleepPose() {
		this.Head.y = -5.0F;
		this.Head.xRot = -0.0781907508222411F;
		this.Head.yRot = 0.03874630989361682F;
		this.Head.zRot = 0.19547687289441354F;
		this.RFoot.y = 4.4F;
		this.RFoot.z = 1.0F;
		this.RFoot.xRot = 0;
		this.RFoot.yRot = -1.7453292129831807E-4F;
		this.RFoot.zRot = 0.4300491170387584F;
		this.Neck.x = -1.0F;
		this.Neck.y = 1.0F;
		this.Neck.z = 1.0F;
		this.Neck.xRot = 1.6418312220247435F;
		this.Neck.yRot = 0.3122393925291412F;
		this.Neck.zRot = -0.23457224414434488F;
		this.TailBase.y = 2.1F;
		this.TailBase.xRot = -0.27366763203903305F;
		this.TailBase.yRot = -0.0781907508222411F;
		this.TailBase.zRot = 0.0F;
		this.Torso.x = -3.0F;
		this.Torso.y = 19F;
		this.Torso.xRot = -0.11728612207217244F;
		this.Torso.yRot = -0.039269908169872414F;
		this.Torso.zRot = -1.2901473511162753F;
		this.LForeleg.x = -3.0F;
		this.LForeleg.y = 2.0F;
		this.LForeleg.xRot = -0.03909537541112055F;
		this.LForeleg.yRot = -0.03909537541112055F;
		this.LForeleg.zRot = -0.23457224414434488F;
		this.LFoot.y = 4.4F;
		this.LFoot.xRot = -0.4300491170387584F;
		this.LFoot.yRot = -0.11728612207217244F;
		this.LFoot.zRot = -0.19547687289441354F;
		this.RLeg.x = 0.5F;
		this.RLeg.y = 19.0F;
		this.RLeg.z = 2.5F;
		this.RLeg.xRot = -0.1563815016444822F;
		this.RLeg.yRot = -1.7453292129831807E-4F;
		this.RLeg.zRot = -1.0555751236166873F;
		this.LLeg.x = -0.5F;
		this.LLeg.y = 21.2F;
		this.LLeg.z = 2.0F;
		this.LLeg.xRot = 0.4300491170387584F;
		this.LLeg.yRot = -0.11728612207217244F;
		this.LLeg.zRot = -1.4467034063254554F;
		this.RForeleg.x = 1.5F;
		this.RForeleg.y = 5.0F;
		this.RForeleg.xRot = 0.2738421523142173F;
		this.RForeleg.yRot = 0;
		this.RForeleg.zRot = 0.7035422454473641F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
