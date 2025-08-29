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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Torvosaurus;

public class TorvosaurusModel extends EntityModel<Torvosaurus> {
	private final ModelPart root;
	private final ModelPart Body;
	private final ModelPart Torso;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public TorvosaurusModel(ModelPart root) {
		this.root = root.getChild("root");
		this.Body = this.root.getChild("Body");
		this.Torso = this.Body.getChild("Torso");
		this.Neck = this.Torso.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
		this.LeftArm = this.Torso.getChild("LeftArm");
		this.RightArm = this.Torso.getChild("RightArm");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.LeftThigh = this.root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = this.root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -20.0F));

		PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(92, 114).addBox(-6.0F, -12.0F, -14.0F, 12.0F, 23.0F, 25.0F, new CubeDeformation(0.0F))
		.texOffs(120, 37).addBox(0.0F, -14.0F, -12.0F, 0.0F, 2.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -35.0F, 18.0F));

		PartDefinition Torso = Body.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(94, 64).addBox(-7.0F, -12.0F, -26.0F, 14.0F, 24.0F, 26.0F, new CubeDeformation(0.0F))
		.texOffs(158, 0).addBox(0.0F, -15.0F, -21.0F, 0.0F, 3.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.875F, -12.0F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(118, 0).addBox(-3.0F, -15.0F, -12.0F, 6.0F, 23.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 163).addBox(0.0F, -19.0F, -12.0F, 0.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -25.0F, 0.35F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(114, 162).addBox(-4.0F, -7.0F, -7.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(52, 120).addBox(-2.0F, -7.0F, -22.0F, 4.0F, 7.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(166, 50).addBox(-2.0F, 0.0F, -20.0F, 4.0F, 1.0F, 11.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -7.0F, -8.0F, -0.2F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(164, 24).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -21.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(164, 39).addBox(-4.0F, 0.0F, -8.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(52, 142).addBox(-2.0F, 0.0F, -23.0F, 4.0F, 3.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(166, 114).addBox(-3.5F, -5.0F, -6.05F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition cube_r2 = Jaw.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(164, 24).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -22.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition LeftArm = Torso.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(146, 162).addBox(-1.0F, -1.0F, -4.0F, 4.0F, 18.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 6.0F, -17.0F, 0.15F, 0.0F, 0.0F));

		PartDefinition RightArm = Torso.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(146, 162).mirror().addBox(-3.0F, -1.0F, -4.0F, 4.0F, 18.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, 6.0F, -17.0F, 0.15F, 0.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 65).addBox(-4.0F, -7.0F, -1.0F, 8.0F, 16.0F, 39.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 10.5F, -0.05F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -1.0F, 4.0F, 9.0F, 56.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 37.5F, 0.05F, 0.0F, 0.0F));

		PartDefinition LeftThigh = root.addOrReplaceChild("LeftThigh", CubeListBuilder.create(), PartPose.offset(7.0F, -37.0F, 17.0F));

		PartDefinition cube_r3 = LeftThigh.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 120).addBox(5.0F, -2.0F, -11.0F, 9.0F, 28.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -6.0F, 4.25F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(51, 160).addBox(-2.5F, -2.0F, -4.0F, 5.0F, 23.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 15.0F, 7.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(76, 162).addBox(-3.5F, -1.0F, -10.0F, 7.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, 0.0F));

		PartDefinition RightThigh = root.addOrReplaceChild("RightThigh", CubeListBuilder.create(), PartPose.offset(-7.0F, -37.0F, 17.0F));

		PartDefinition cube_r4 = RightThigh.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 120).mirror().addBox(-8.0F, -2.0F, -11.0F, 9.0F, 28.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -6.0F, 4.25F, -0.0873F, 0.0F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(51, 160).mirror().addBox(-2.5F, -2.0F, -4.0F, 5.0F, 23.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 15.0F, 7.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(76, 162).mirror().addBox(-3.5F, -1.0F, -10.0F, 7.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 20.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Torvosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 1.0f;
		float walkDegree = 0.5f;
		float idleSpeed = 1.0f;
		float idleDegree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Torso.xRot = Mth.lerp(sleepProgress, 0, 0.0781907508222411F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.7991936386169619F);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0, -0.3082398928281348F);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0, 0.36914448828868976F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.8600982340775168F);
				this.RightLeg.y = Mth.lerp(sleepProgress, 15, 13.0F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.05F, -0.2800491170387584F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.19547687289441354F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -37, -10);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.7428121536172364F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, 0.23457224414434488F);
				this.RightFoot.z = Mth.lerp(sleepProgress, 0, -3F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.602910321115726F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.35F, 0.581101130194616F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, 0.03909537541112055F);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0, 0.17366763203903305F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.05F, -0.29547687289441354F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.Body.y = Mth.lerp(sleepProgress, -35F, -12.0F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, 0.0781907508222411F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, -0.46914448828868976F);
				this.LeftFoot.z = Mth.lerp(sleepProgress, 0, -3.0F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.4265288361160007F);
				this.LeftFoot.yRot = Mth.lerp(sleepProgress, 0, 0.10266763203903305F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.15F, -1.3856243072344728F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, 0.1909537457888271F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.2513347637790725F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.15F, -1.75185837453889574F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.25185837453889574F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, 0.4300491170387584F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -37, -14);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.547160727158125F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.35185837453889574F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, -0.3909537457888271F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Torso.xRot = Mth.lerp(sleepProgress, 0.0781907508222411F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.7991936386169619F, 0);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, -0.3082398928281348F, 0);
				this.LeftLeg.zRot = Mth.lerp(sleepProgress, 0.36914448828868976F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.8600982340775168F, 0);
				this.RightLeg.y = Mth.lerp(sleepProgress, 13.0F, 15);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.2800491170387584F, -0.05F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.19547687289441354F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, -10, -37);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.7428121536172364F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0.23457224414434488F, 0);
				this.RightFoot.z = Mth.lerp(sleepProgress, -3F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.602910321115726F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.581101130194616F, 0.35F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0.03909537541112055F, 0);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0.17366763203903305F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, -0.29547687289441354F, 0.05F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.Body.y = Mth.lerp(sleepProgress, -12.0F, -35);
				this.Body.xRot = Mth.lerp(sleepProgress, 0.0781907508222411F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, -0.46914448828868976F, 0);
				this.LeftFoot.z = Mth.lerp(sleepProgress, -3.0F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.4265288361160007F, 0);
				this.LeftFoot.yRot = Mth.lerp(sleepProgress, 0.10266763203903305F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.3856243072344728F, 0.15F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0.1909537457888271F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.2513347637790725F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.75185837453889574F, 0.15F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.25185837453889574F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0.4300491170387584F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -14, -37);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.547160727158125F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.35185837453889574F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, -0.3909537457888271F, 0);
			} else {
				this.Neck.xRot = (Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount + 0.35F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float)Math.toRadians(30F);
				this.Torso.xRot = Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.01F * limbSwingAmount;
				this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.15F * limbSwingAmount + 0.05F;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 1.0F * limbSwingAmount;
				this.Head.xRot = Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount - 0.2F + attackProgress * (float)Math.toRadians(-40F);
				this.Jaw.xRot = attackProgress * (float) Math.toRadians(25F);
				this.Neck.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
				this.Head.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
				this.RightArm.xRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.LeftArm.xRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.05F;
				this.RightLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.05F;
				this.RightFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.05F;
				this.LeftLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.05F;
				this.LeftFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.3F * limbSwingAmount;
				this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isInWater()) {
					this.RightThigh.y = 20;
					this.LeftThigh.y = 20;
					this.Body.y = 17;
					this.Body.xRot = -0.125F;
					this.Tail1.xRot = 0.0625F;
					this.Tail2.xRot = 0.0625F;
					this.Neck.xRot = 0.25F;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = 0.125F;
					this.RightArm.xRot = 0.125F;
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
		this.Torso.xRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.y = 15.0F;
		this.RightLeg.y = 15.0F;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Head.y = -7;
		this.Head.z = -8;
		this.Head.xRot = -0.2F;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.LeftThigh.x = 7.0F;
		this.LeftThigh.y = -37F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.LeftFoot.z = 0.0F;
		this.LeftFoot.xRot = 0;
		this.LeftFoot.yRot = 0;
		this.Neck.y = -5.0F;
		this.Neck.z = -25.0F;
		this.Neck.xRot = 0.35F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Body.y = -35.0F;
		this.Body.xRot = 0;
		this.Body.zRot = 0;
		this.RightFoot.z = 0.0F;
		this.RightFoot.xRot = 0;
		this.RightFoot.yRot = 0;
		this.LeftArm.xRot = 0.15F;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.RightArm.xRot = 0.15F;
		this.RightArm.zRot = 0;
		this.RightThigh.x = -7.0F;
		this.RightThigh.y = -37F;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.RightArm.yRot = 0;
	}

	public void sleepPose() {
		this.Torso.xRot = 0.0781907508222411F;
		this.LeftLeg.xRot = -0.7991936386169619F;
		this.LeftLeg.yRot = -0.3082398928281348F;
		this.LeftLeg.zRot = 0.36914448828868976F;
		this.RightLeg.xRot = -0.8600982340775168F;
		this.RightLeg.y = 13.0F;
		this.Tail1.xRot = -0.2800491170387584F;
		this.Tail1.yRot = 0.19547687289441354F;
		this.RightThigh.y = -10;
		this.RightThigh.xRot = -0.7428121536172364F;
		this.RightThigh.yRot = 0.23457224414434488F;
		this.RightFoot.z = -3F;
		this.RightFoot.xRot = 1.602910321115726F;
		this.Neck.xRot = 0.581101130194616F;
		this.Neck.yRot = 0.03909537541112055F;
		this.Neck.zRot = 0.17366763203903305F;
		this.Tail2.xRot = -0.29547687289441354F;
		this.Tail2.yRot = 0.3909537457888271F;
		this.Body.y = -12.0F;
		this.Body.xRot = 0.0781907508222411F;
		this.Body.zRot = -0.46914448828868976F;
		this.LeftFoot.z = -3.0F;
		this.LeftFoot.xRot = 1.4265288361160007F;
		this.LeftFoot.yRot = 0.10266763203903305F;
		this.LeftArm.xRot = -1.3856243072344728F;
		this.LeftArm.yRot = 0.1909537457888271F;
		this.LeftArm.zRot = -0.2513347637790725F;
		this.RightArm.xRot = -1.75185837453889574F;
		this.RightArm.yRot = 0.25185837453889574F;
		this.RightArm.zRot = 0.4300491170387584F;
		this.LeftThigh.y = -14;
		this.LeftThigh.xRot = -0.547160727158125F;
		this.LeftThigh.yRot = -0.35185837453889574F;
		this.LeftThigh.zRot = -0.3909537457888271F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
