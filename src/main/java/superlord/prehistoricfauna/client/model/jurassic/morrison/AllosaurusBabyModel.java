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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;

public class AllosaurusBabyModel extends EntityModel<Allosaurus> {
	private final ModelPart Torso;
	private final ModelPart LLeg;
	private final ModelPart LFoot;
	private final ModelPart RLeg;
	private final ModelPart RFoot;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart RArm;
	private final ModelPart LArm;
	private final ModelPart TailBase;

	public AllosaurusBabyModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.LLeg = root.getChild("LLeg");
		this.LFoot = LLeg.getChild("LFoot");
		this.RLeg = root.getChild("RLeg");
		this.RFoot = RLeg.getChild("RFoot");
		this.RArm = Torso.getChild("RArm");
		this.LArm = Torso.getChild("LArm");
		this.Neck = Torso.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.TailBase = Torso.getChild("TailBase");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, -7.0F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(20, 19).addBox(-1.0F, -5.0F, -3.0F, 2.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.1047F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(21, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.01F, 0.0F, 0.0F)), PartPose.offset(0.0F, -3.0F, -2.0F));

		PartDefinition Forehead = Head.addOrReplaceChild("Forehead", CubeListBuilder.create().texOffs(15, 38).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 1.0F));

		PartDefinition Crests = Head.addOrReplaceChild("Crests", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -3.0F));

		PartDefinition TailBase = Torso.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.1F, 13.0F, -0.0698F, 0.0F, 0.0F));

		PartDefinition RArm = Torso.addOrReplaceChild("RArm", CubeListBuilder.create().texOffs(0, -3).addBox(0.0F, 0.0F, -1.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 4.0F, 2.0F, 0.0F, 0.0F, -0.1047F));

		PartDefinition LArm = Torso.addOrReplaceChild("LArm", CubeListBuilder.create().texOffs(0, -3).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.1047F));

		PartDefinition LLeg = partdefinition.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -1.5F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 14.5F, 2.0F));

		PartDefinition LFoot = LLeg.addOrReplaceChild("LFoot", CubeListBuilder.create().texOffs(5, 38).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.5F, 2.0F));

		PartDefinition RLeg = partdefinition.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -1.5F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 14.5F, 2.0F));

		PartDefinition RFoot = RLeg.addOrReplaceChild("RFoot", CubeListBuilder.create().texOffs(5, 38).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.5F, 2.0F));

		return LayerDefinition.create(meshdefinition, 39, 45);
	}


	@Override
	public void setupAnim(Allosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 1.0f;
		float walkDegree = 0.5f;
		float idleSpeed = 1.0f;
		float idleDegree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		int sleepProgress = entity.getSleepTicks();
		int wakingProgress = entity.getWakingTicks();
		if (!entity.isWakingUp() && !entity.isFallingAsleep()) {
			if (!entity.isAsleep()) {
				resetModel();
			} else {
				this.RFoot.xRot = -0.9F;
				this.RFoot.yRot = -0.5082398928281348F;
				this.RFoot.zRot = 0;
				this.LFoot.xRot = -0.8600982340775168F;
				this.LFoot.y = 4.5F;
				this.TailBase.y = 1.5F;
				this.TailBase.xRot = -0.4300491170387584F;
				this.TailBase.yRot = 0.19547687289441354F;
				this.Head.y = -4;
				this.Head.z = -1;
				this.Head.xRot = -1.7201964681550337F;
				this.Head.yRot = 0.03909537541112055F;
				this.Head.zRot = -0.0781907508222411F;
				this.LLeg.x = -1;
				this.LLeg.y = 21;
				this.LLeg.xRot = -0.7428121536172364F;
				this.LLeg.yRot = 0.23457224414434488F;
				this.Neck.y = 1.51F;
				this.Neck.xRot = 1.681101130194616F;
				this.Neck.yRot = 0.03909537541112055F;
				this.Neck.zRot = 0.27366763203903305F;
				this.Torso.y = 18.0F;
				this.Torso.xRot = 0.0781907508222411F;
				this.Torso.zRot = -0.46914448828868976F;
				this.LArm.xRot = -1.4856243072344728F;
				this.LArm.yRot = 0.3909537457888271F;
				this.LArm.zRot = 0.3513347637790725F;
				this.RArm.xRot = -0.35185837453889574F;
				this.RArm.zRot = -0.4300491170387584F;
				this.RLeg.x = 2.5F;
				this.RLeg.y = 19;
				this.RLeg.xRot = -0.547160727158125F;
				this.RLeg.yRot = -0.35185837453889574F;
				this.RLeg.zRot = -0.3909537457888271F;
			}
		}
		if (wakingProgress != 0) {
			//RFoot
			if (this.RFoot.xRot < 0) this.RFoot.xRot += 0.05;
			if (this.RFoot.yRot < 0) this.RFoot.yRot += 0.05;
			//LFoot
//			this.LFoot.y = 4.3F;
			if (this.LFoot.y > 4.3) this.LFoot.y -= 0.15;
			if (this.RFoot.xRot < 0) this.RFoot.xRot += 0.05;
			//TailBase
//			this.TailBase.y = 1.1F;
//			this.TailBase.xRot = -0.0698F;
			if (this.TailBase.y > 1.1) this.TailBase.y -= 0.15;
			if (this.TailBase.xRot < -0.0698F) this.TailBase.xRot += 0.05;
			if (this.TailBase.yRot > 0) this.TailBase.yRot -= 0.05;
			//Head
//			this.Head.y = -3F;
//			this.Head.z = -2F;
			if (this.Head.y < -3) this.Head.y += 0.15;
			if (this.Head.z > -2) this.Head.z -= 0.15;
			if (this.Head.xRot < 0) this.Head.xRot += 0.05;
			if (this.Head.yRot > 0) this.Head.yRot -= 0.05;
			if (this.Head.zRot < 0) this.Head.zRot += 0.05;
			//LLeg
//			this.LLeg.x = -2F;
//			this.LLeg.y = 14.5F;
			if (this.LLeg.x > -2) this.LLeg.x -= 0.15;
			if (this.LLeg.y > 14.5) this.LLeg.y -= 0.15;
			if (this.LLeg.xRot < 0) this.LLeg.xRot += 0.05;
			if (this.LLeg.yRot > 0) this.LLeg.yRot -= 0.05;
			//Neck
//			this.Neck.y = 2.0F;
			if (this.Neck.y < 2) this.Neck.y += 0.15;
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot > 0) this.Neck.yRot -= 0.05;
			if (this.Neck.zRot > 0) this.Neck.zRot -= 0.05;
			//Torso
//			this.Torso.y = 11.0F;
			if (this.Torso.y > 11) this.Torso.y -= 0.15;
			if (this.Torso.xRot > 0) this.Torso.xRot -= 0.05;
			if (this.Torso.zRot < 0) this.Torso.zRot += 0.05;
			//LArm
//			this.LArm.zRot = 0.1047F;
			if (this.LArm.xRot < 0) this.LArm.xRot += 0.05;
			if (this.LArm.yRot > 0) this.LArm.yRot -= 0.05;
			if (this.LArm.zRot > 0.1047F) this.LArm.zRot -= 0.05;
			//RArm
//			this.RArm.zRot = -0.1047F;
			if (this.RArm.xRot < 0) this.RArm.xRot += 0.05;
			if (this.RArm.zRot < -0.1047F) this.RArm.zRot += 0.05;
			//RLeg
//			this.RLeg.x = 2F;
//			this.RLeg.y = 14.5F;
			if (this.RLeg.x > 2) this.RLeg.x -= 0.15;
			if (this.RLeg.y > 14.5) this.RLeg.y -= 0.15;
			if (this.RLeg.xRot < 0) this.RLeg.xRot += 0.05;
			if (this.RLeg.yRot < 0) this.RLeg.yRot += 0.05;
			if (this.RLeg.zRot < 0) this.RLeg.zRot += 0.05;
		}
		if (entity.isAsleep()) {
			if (sleepProgress != 0) {
				//RFoot
				if (this.RFoot.xRot > -0.9) this.RFoot.xRot -= 0.05;
				if (this.RFoot.yRot > -0.5082398928281348F) this.RFoot.yRot -= 0.05;
				//LFoot
//				this.LFoot.y = 4.3F;
				if (this.LFoot.y < 4.5) this.LFoot.y += 0.15;
				if (this.RFoot.xRot > -0.8600982340775168F) this.RFoot.xRot -= 0.05;
				//TailBase
//				this.TailBase.y = 1.1F;
//				this.TailBase.xRot = -0.0698F;
				if (this.TailBase.y < 1.5) this.TailBase.y += 0.15;
				if (this.TailBase.xRot > -0.4300491170387584F) this.TailBase.xRot -= 0.05;
				if (this.TailBase.yRot < 0.19547687289441354F) this.TailBase.yRot += 0.05;
				//Head
//				this.Head.y = -3F;
//				this.Head.z = -2F;
				if (this.Head.y > -4) this.Head.y -= 0.15;
				if (this.Head.z < -1) this.Head.z += 0.15;
				if (this.Head.xRot > -1.7201964681550337F) this.Head.xRot -= 0.05;
				if (this.Head.yRot < 0.03909537541112055F) this.Head.yRot += 0.05;
				if (this.Head.zRot > -0.0781907508222411F) this.Head.zRot -= 0.05;
				//LLeg
//				this.LLeg.x = -2F;
//				this.LLeg.y = 14.5F;
				if (this.LLeg.x < -1) this.LLeg.x += 0.15;
				if (this.LLeg.y < 21) this.LLeg.y += 0.15;
				if (this.LLeg.xRot > -0.7428121536172364F) this.LLeg.xRot -= 0.05;
				if (this.LLeg.yRot < 0.23457224414434488F) this.LLeg.yRot += 0.05;
				//Neck
//				this.Neck.y = 2.0F;
				if (this.Neck.y > 1.51) this.Neck.y -= 0.15;
				if (this.Neck.xRot < 1.681101130194616F) this.Neck.xRot += 0.05;
				if (this.Neck.yRot < 0.03909537541112055F) this.Neck.yRot += 0.05;
				if (this.Neck.zRot < 0.27366763203903305F) this.Neck.zRot += 0.05;
				//Torso
//				this.Torso.y = 11.0F;
				if (this.Torso.y < 18) this.Torso.y += 0.15;
				if (this.Torso.xRot < 0.0781907508222411F) this.Torso.xRot += 0.05;
				if (this.Torso.zRot > -0.46914448828868976F) this.Torso.zRot -= 0.05;
				//LArm
//				this.LArm.x = -2F;
//				this.LArm.y = 4.0F;
//				this.LArm.zRot = 0.1047F;
				if (this.LArm.xRot > -1.4856243072344728F) this.LArm.xRot -= 0.05;
				if (this.LArm.yRot < 0.3909537457888271F) this.LArm.yRot += 0.05;
				if (this.LArm.zRot < 0.3513347637790725F) this.LArm.zRot += 0.05;
				//RArm
//				this.RArm.x = 2F;
//				this.RArm.y = 4.0F;
//				this.RArm.zRot = -0.1047F;
				if (this.RArm.xRot > -0.35185837453889574F) this.RArm.xRot -= 0.05;
				if (this.RArm.zRot > -0.4300491170387584F) this.RArm.zRot -= 0.05;
				//RLeg
//				this.RLeg.x = 2F;
//				this.RLeg.y = 14.5F;
//				this.RLeg.z = 2.0F;
				if (this.RLeg.x < 2.5) this.RLeg.x += 0.15;
				if (this.RLeg.y < 19) this.RLeg.y += 0.15;
				if (this.RLeg.xRot > -0.547160727158125F) this.RLeg.xRot -= 0.05;
				if (this.RLeg.yRot > -0.35185837453889574F) this.RLeg.yRot -= 0.05;
				if (this.RLeg.zRot > -0.3909537457888271F) this.RLeg.zRot -= 0.05;
			}
		} else {
			this.Neck.xRot = (Mth.cos(-1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount + 0.35F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float)Math.toRadians(30F);
			this.Torso.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
			this.TailBase.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos((limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
			this.TailBase.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos((limbSwing / 3) * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
			this.Head.xRot = Mth.cos(-1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount - 0.2F + attackProgress * (float)Math.toRadians(-40F);
			this.Neck.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
			this.Head.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
			this.RArm.xRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos((limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
			this.LArm.xRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(2.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
			this.RLeg.xRot = Mth.cos(1.0F + (limbSwing / 3) * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.05F;
			this.RFoot.xRot = Mth.cos(1.0F + (limbSwing / 3) * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.05F;
			this.LLeg.xRot = Mth.cos(1.0F + (limbSwing / 3) * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.05F;
			this.LFoot.xRot = Mth.cos(1.0F + (limbSwing / 3) * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.05F;
			this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
			if (entity.isInWater()) {
				this.RLeg.y = 22;
				this.LLeg.y = 22;
				this.Torso.y = 17;
				this.Torso.xRot = -0.125F;
				this.TailBase.xRot = 0.0625F;
				this.Neck.xRot = 0.25F;
				this.RLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LArm.xRot = 0.125F;
				this.RArm.xRot = 0.125F;
				this.RFoot.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LFoot.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.TailBase.yRot = (Mth.cos((limbSwing / 3) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.Head.y = -3F;
		this.Head.z = -2F;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.RFoot.y = 4.3F;
		this.RFoot.z = 2.0F;
		this.RFoot.xRot = 0;
		this.RFoot.yRot = 0;
		this.RFoot.zRot = 0;
		this.Neck.x = 0F;
		this.Neck.y = 2.0F;
		this.Neck.z = 0.0F;
		this.Neck.xRot = 0.1047F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.TailBase.y = 1.1F;
		this.TailBase.xRot = -0.0698F;
		this.TailBase.yRot = 0;
		this.Torso.x = 0;
		this.Torso.y = 11.0F;
		this.Torso.xRot = 0;
		this.Torso.yRot = 0;
		this.Torso.zRot = 0;
		this.LArm.x = -2F;
		this.LArm.y = 4.0F;
		this.LArm.xRot = 0;
		this.LArm.yRot = 0;
		this.LArm.zRot = 0.1047F;
		this.LFoot.y = 4.3F;
		this.LFoot.xRot = 0;
		this.LFoot.yRot = 0;
		this.LFoot.zRot = 0;
		this.RLeg.x = 2F;
		this.RLeg.y = 14.5F;
		this.RLeg.z = 2.0F;
		this.RLeg.xRot = 0;
		this.RLeg.yRot = 0;
		this.RLeg.zRot = 0;
		this.LLeg.x = -2F;
		this.LLeg.y = 14.5F;
		this.LLeg.z = 2.0F;
		this.LLeg.xRot = 0;
		this.LLeg.yRot = 0;
		this.LLeg.zRot = 0;
		this.RArm.x = 2F;
		this.RArm.y = 4.0F;
		this.RArm.xRot = 0;
		this.RArm.yRot = 0;
		this.RArm.zRot = -0.1047F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
