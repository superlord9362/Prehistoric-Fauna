package superlord.prehistoricfauna.client.model.cretaceous.yixian;

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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Yutyrannus;

@SuppressWarnings("unused")
public class YutyrannusBabyModel extends EntityModel<Yutyrannus> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Snout;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart Tail1;

	public YutyrannusBabyModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.Snout = Head.getChild("Snout");
		this.RightArm = Body.getChild("RightArm");
		this.LeftArm = Body.getChild("LeftArm");
		this.RightThigh = Body.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
		this.LeftThigh = Body.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
		this.Tail1 = Body.getChild("Tail1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 12).addBox(-2.5F, -4.0F, -7.0F, 5.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(23, 0).addBox(-2.5F, -1.0673F, -3.0722F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.0F, -6.0F, 0.0698F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 3.1F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0673F, -1.0722F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 7).addBox(-2.0F, 3.1F, -7.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(14, 0).addBox(-1.5F, 5.2F, -6.01F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(18, 0).addBox(-2.0F, 6.1F, -4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 33).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -2.0F, -5.0F, 0.1745F, 0.0F, -0.1745F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(3, 27).addBox(0.0F, -6.0F, -2.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -2.0F, -5.0F, 0.1745F, 0.0F, 0.1745F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(22, 12).addBox(-1.5F, -4.0F, -1.99F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -1.0F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(27, 31).addBox(-0.5F, -5.0F, 0.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -4.0F, 2.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(20, 29).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -5.0F, 0.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(22, 12).mirror().addBox(-0.5F, -4.0F, -1.99F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -1.0F, 0.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(27, 31).addBox(-0.5F, -5.0F, 0.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -4.0F, 2.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(20, 29).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -5.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 29).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 3.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(21, 36).addBox(-1.5F, -4.0F, 9.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 3.9F, -0.0698F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Yutyrannus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.9F);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0, -0.5082398928281348F);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.8600982340775168F);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 4.3F, 4.5F);
				this.Tail1.y = Mth.lerp(sleepProgress, 1.1F, 1.5F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.4300491170387584F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.19547687289441354F);
				this.Head.y = Mth.lerp(sleepProgress, -3, -4);
				this.Head.z = Mth.lerp(sleepProgress, -2, -1);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, -1.7201964681550337F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, 0.03909537541112055F);
				this.Head.zRot = Mth.lerp(sleepProgress, 0, -0.0781907508222411F);
				this.LeftThigh.x = Mth.lerp(sleepProgress, -2, -1);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 14.5F, 21);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.7428121536172364F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.23457224414434488F);
				this.Neck.y = Mth.lerp(sleepProgress, 2, 1.51F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 1.681101130194616F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, 0.03909537541112055F);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0, 0.27366763203903305F);
				this.Body.y = Mth.lerp(sleepProgress, 11, 18.0F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, 0.0781907508222411F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, -0.46914448828868976F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.4856243072344728F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 0.3513347637790725F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -0.35185837453889574F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.4300491170387584F);
				this.RightThigh.x = Mth.lerp(sleepProgress, 2, 2.5F);
				this.RightThigh.y = Mth.lerp(sleepProgress, 14.5F, 19);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.547160727158125F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.35185837453889574F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, -0.3909537457888271F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.9F, 0);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, -0.5082398928281348F, 0);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.8600982340775168F, 0);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 4.5F, 4.3F);
				this.Tail1.y = Mth.lerp(sleepProgress, 1.5F, 1.1F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.4300491170387584F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.19547687289441354F, 0);
				this.Head.y = Mth.lerp(sleepProgress, -4, -3);
				this.Head.z = Mth.lerp(sleepProgress, -1, -2);
				this.Head.xRot = Mth.lerp(sleepProgress, -1.7201964681550337F, 0);
				this.Head.yRot = Mth.lerp(sleepProgress, 0.03909537541112055F, 0);
				this.Head.zRot = Mth.lerp(sleepProgress, -0.0781907508222411F, 0);
				this.LeftThigh.x = Mth.lerp(sleepProgress, -1, -2);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 21F, 14.5F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.7428121536172364F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.23457224414434488F, 0);
				this.Neck.y = Mth.lerp(sleepProgress, 1.51F, 2F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 1.681101130194616F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0.03909537541112055F, 0);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0.27366763203903305F, 0);
				this.Body.y = Mth.lerp(sleepProgress, 18, 11.0F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0.0781907508222411F, 0);
				this.Body.zRot = Mth.lerp(sleepProgress, -0.46914448828868976F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.4856243072344728F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0.3513347637790725F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -0.35185837453889574F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.4300491170387584F, 0);
				this.RightThigh.x = Mth.lerp(sleepProgress, 2.5F, 2F);
				this.RightThigh.y = Mth.lerp(sleepProgress, 19F, 14.5F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.547160727158125F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.35185837453889574F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, -0.3909537457888271F, 0);
			} else {
				this.Neck.xRot = (Mth.cos(-1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount + 0.35F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float)Math.toRadians(30F);
				this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos((limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos((limbSwing / 3) * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
				this.Head.xRot = Mth.cos(-1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount - 0.2F + attackProgress * (float)Math.toRadians(-40F);
				this.Neck.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
				this.Head.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
				this.RightArm.xRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos((limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.LeftArm.xRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(2.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.RightThigh.xRot = Mth.cos(1.0F + (limbSwing / 3) * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.05F;
				this.RightLeg.xRot = Mth.cos(1.0F + (limbSwing / 3) * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.05F;
				this.LeftThigh.xRot = Mth.cos(1.0F + (limbSwing / 3) * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.05F;
				this.LeftLeg.xRot = Mth.cos(1.0F + (limbSwing / 3) * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + (limbSwing / 3) * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.05F;
				this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isInWater()) {
					this.RightThigh.y = 22;
					this.LeftThigh.y = 22;
					this.Body.y = 17;
					this.Body.xRot = -0.125F;
					this.Tail1.xRot = 0.0625F;
					this.Neck.xRot = 0.25F;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = 0.125F;
					this.RightArm.xRot = 0.125F;
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Tail1.yRot = (Mth.cos((limbSwing / 3) * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Head.y = -3F;
		this.Head.z = -2F;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.RightLeg.y = 4.3F;
		this.RightLeg.z = 2.0F;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.Neck.x = 0F;
		this.Neck.y = 2.0F;
		this.Neck.z = 0.0F;
		this.Neck.xRot = 0.1047F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Tail1.y = 1.1F;
		this.Tail1.xRot = -0.0698F;
		this.Tail1.yRot = 0;
		this.Body.x = 0;
		this.Body.y = 11.0F;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.LeftArm.x = -2F;
		this.LeftArm.y = 4.0F;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0.1047F;
		this.LeftLeg.y = 4.3F;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.LeftLeg.zRot = 0;
		this.RightThigh.x = 2F;
		this.RightThigh.y = 14.5F;
		this.RightThigh.z = 2.0F;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.LeftThigh.x = -2F;
		this.LeftThigh.y = 14.5F;
		this.LeftThigh.z = 2.0F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.RightArm.x = 2F;
		this.RightArm.y = 4.0F;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = -0.1047F;
	}

	public void sleepPose() {
		this.RightLeg.xRot = -0.9F;
		this.RightLeg.yRot = -0.5082398928281348F;
		this.RightLeg.zRot = 0;
		this.LeftLeg.xRot = -0.8600982340775168F;
		this.LeftLeg.y = 4.5F;
		this.Tail1.y = 1.5F;
		this.Tail1.xRot = -0.4300491170387584F;
		this.Tail1.yRot = 0.19547687289441354F;
		this.Head.y = -4;
		this.Head.z = -1;
		this.Head.xRot = -1.7201964681550337F;
		this.Head.yRot = 0.03909537541112055F;
		this.Head.zRot = -0.0781907508222411F;
		this.LeftThigh.x = -1;
		this.LeftThigh.y = 21;
		this.LeftThigh.xRot = -0.7428121536172364F;
		this.LeftThigh.yRot = 0.23457224414434488F;
		this.Neck.y = 1.51F;
		this.Neck.xRot = 1.681101130194616F;
		this.Neck.yRot = 0.03909537541112055F;
		this.Neck.zRot = 0.27366763203903305F;
		this.Body.y = 18.0F;
		this.Body.xRot = 0.0781907508222411F;
		this.Body.zRot = -0.46914448828868976F;
		this.LeftArm.xRot = -1.4856243072344728F;
		this.LeftArm.yRot = 0.3909537457888271F;
		this.LeftArm.zRot = 0.3513347637790725F;
		this.RightArm.xRot = -0.35185837453889574F;
		this.RightArm.zRot = -0.4300491170387584F;
		this.RightThigh.x = 2.5F;
		this.RightThigh.y = 19;
		this.RightThigh.xRot = -0.547160727158125F;
		this.RightThigh.yRot = -0.35185837453889574F;
		this.RightThigh.zRot = -0.3909537457888271F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}