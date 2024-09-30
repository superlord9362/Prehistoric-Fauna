package superlord.prehistoricfauna.client.model.triassic.ischigualasto;

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
import superlord.prehistoricfauna.common.entity.triassic.ischigualasto.Sillosuchus;

public class SillosuchusModel extends EntityModel<Sillosuchus> {
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart Body;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Jaw;

	public SillosuchusModel(ModelPart root) {
		this.RightThigh = root.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
		this.LeftThigh = root.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
		this.Body = root.getChild("Body");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.LeftArm = Body.getChild("LeftArm");
		this.RightArm = Body.getChild("RightArm");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.Jaw = Head.getChild("Jaw");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeftThigh = partdefinition.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(145, 80).mirror().addBox(-1.0F, -3.0F, -5.0F, 8.0F, 22.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -14.0F, 4.0F, -0.1F, 0.0F, 0.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(145, 116).mirror().addBox(-3.0F, -2.0F, -3.0F, 6.0F, 19.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 19.0F, 0.0F, 0.1F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(178, 122).addBox(-3.5F, -1.0F, -15.5F, 7.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 4.0F));

		PartDefinition RightThigh = partdefinition.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(145, 80).addBox(-7.0F, -3.0F, -5.0F, 8.0F, 22.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -14.0F, 4.0F, -0.1F, 0.0F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(145, 116).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 19.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 19.0F, 0.0F, 0.1F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(178, 122).mirror().addBox(-3.5F, -1.0F, -15.5F, 7.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 16.0F, 4.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.5F, -10.0F, -37.0F, 17.0F, 25.0F, 55.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 2.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(1, 81).addBox(-5.0F, -3.0F, -4.0F, 10.0F, 14.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 15.0F, -0.05F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(3, 142).addBox(-3.5F, -1.0F, -3.0F, 7.0F, 9.0F, 49.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 37.0F, 0.05F, 0.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(152, 18).addBox(-4.0F, -6.5F, -31.0F, 8.0F, 11.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -37.0F, -0.6F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(1, 2).addBox(-4.5F, -2.0F, -12.0F, 9.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.07F, -29.62F, 0.8F, 0.0F, 0.0F));

		PartDefinition beak = Head.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(2, 24).addBox(-3.5F, -2.0F, -8.0F, 7.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -12.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(90, 2).addBox(-4.5F, 0.0F, -12.0F, 9.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition Jaw2 = Jaw.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(2, 40).addBox(-3.5F, 0.0F, -8.0F, 7.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -12.0F));

		PartDefinition throat = Jaw.addOrReplaceChild("throat", CubeListBuilder.create().texOffs(97, 21).addBox(-4.02F, 0.5F, -4.0F, 8.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -1.6534F, 0.0F, 0.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(113, 86).mirror().addBox(-5.0F, -2.0F, -3.0F, 6.0F, 22.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 8.0F, -26.0F, 0.15F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(113, 86).addBox(-1.0F, -2.0F, -3.0F, 6.0F, 22.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 8.0F, -26.0F, 0.15F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Sillosuchus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.09599310885968812F, 0.17802358037447025F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, -0.35185837453889574F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 1.7453292129831807E-4F);
				this.LeftArm.x = Mth.lerp(sleepProgress, 6, 7.0F);
				this.LeftArm.y = Mth.lerp(sleepProgress, 8, 14.0F);
				this.LeftArm.z = Mth.lerp(sleepProgress, -26, -24.0F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.09599310885968812F, -1.3089969389957472F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, 0.03490658503988659F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -1.2217304763960306F);
				this.RightThigh.x = Mth.lerp(sleepProgress, -4, -5.0F);
				this.RightThigh.y = Mth.lerp(sleepProgress, -14, 13.0F);
				this.RightThigh.z = Mth.lerp(sleepProgress, 4, 12.0F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.04991641477611458F, -2.2689280275926285F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, 0.27366763203903305F);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 19, 15.0F);
				this.LeftLeg.z = Mth.lerp(sleepProgress, 0, 6.3F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0.04991641477611458F, 2.356194490192345F);
				this.RightLeg.y = Mth.lerp(sleepProgress, 19, 15.0F);
				this.RightLeg.z = Mth.lerp(sleepProgress, 0, 7.0F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0.05000000058364023F, 2.3038346126325147F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.15707963267948966F, -0.22689280275926282F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, -0.3490658503988659F);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0, 0.03490658503988659F);
				this.LeftFoot.y = Mth.lerp(sleepProgress, 16, 14.0F);
				this.LeftFoot.z = Mth.lerp(sleepProgress, 4, -1.0F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, -0.12217304763960307F);
				this.LeftThigh.x = Mth.lerp(sleepProgress, 4, 5.9F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -14, 11.2F);
				this.LeftThigh.z = Mth.lerp(sleepProgress, 4, 12.0F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.04991641477611458F, -2.234021442552742F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.3127630032889644F);
				this.RightArm.x = Mth.lerp(sleepProgress, -6, -10.0F);
				this.RightArm.y = Mth.lerp(sleepProgress, 8, 12.0F);
				this.RightArm.z = Mth.lerp(sleepProgress, -26, -24.0F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.09599310885968812F, -1.2217304763960306F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.07749261978723364F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, 1.0821041362364843F);
				this.Body.y = Mth.lerp(sleepProgress, -16, 9.0F);
				this.Body.zRot = Mth.lerp(sleepProgress, 0, -0.11728612207217244F);
				this.RightFoot.y = Mth.lerp(sleepProgress, 16, 12.2F);
				this.RightFoot.z = Mth.lerp(sleepProgress, 4, -1.0F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, -0.03490658503988659F);
				this.Neck.x = Mth.lerp(sleepProgress, 0, -2.0F);
				this.Neck.y = Mth.lerp(sleepProgress, 2, 5.0F);
				this.Neck.z = Mth.lerp(sleepProgress, -37, -42.0F);
				this.Neck.xRot = Mth.lerp(sleepProgress, -0.6108652381980153F, 0.1319468904520859F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, 0.5473352640780661F);
				this.Head.y = Mth.lerp(sleepProgress, -5.07F, -3.07F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0.767944870877505F, -0.09005898673974631F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, 0.35185837453889574F);
				this.Head.zRot = Mth.lerp(sleepProgress, 0, 0.0781907508222411F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.17802358037447025F, 0.09599310885968812F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, -0.35185837453889574F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 1.7453292129831807E-4F, 0);
				this.LeftArm.x = Mth.lerp(sleepProgress, 7, 6.0F);
				this.LeftArm.y = Mth.lerp(sleepProgress, 14, 8.0F);
				this.LeftArm.z = Mth.lerp(sleepProgress, -24, -26.0F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.3089969389957472F, 0.09599310885968812F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0.03490658503988659F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -1.2217304763960306F, 0);
				this.RightThigh.x = Mth.lerp(sleepProgress, -5, -4.0F);
				this.RightThigh.y = Mth.lerp(sleepProgress, 13, -14.0F);
				this.RightThigh.z = Mth.lerp(sleepProgress, 12, 4.0F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -2.2689280275926285F, -0.04991641477611458F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0.27366763203903305F, 0);
				this.LeftLeg.y = Mth.lerp(sleepProgress, 15, 19.0F);
				this.LeftLeg.z = Mth.lerp(sleepProgress, 6.3F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 2.356194490192345F, 0.04991641477611458F);
				this.RightLeg.y = Mth.lerp(sleepProgress, 15, 19.0F);
				this.RightLeg.z = Mth.lerp(sleepProgress, 7, 0F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 2.3038346126325147F, 0.05000000058364023F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.22689280275926282F, -0.15707963267948966F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, -0.3490658503988659F, 0);
				this.Tail1.zRot = Mth.lerp(sleepProgress, 0.03490658503988659F, 0);
				this.LeftFoot.y = Mth.lerp(sleepProgress, 14, 16.0F);
				this.LeftFoot.z = Mth.lerp(sleepProgress, -1, 4.0F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, -0.12217304763960307F, 0);
				this.LeftThigh.x = Mth.lerp(sleepProgress, 5.9F, 4);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 11.2F, -14);
				this.LeftThigh.z = Mth.lerp(sleepProgress, 12, 4.0F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -2.234021442552742F, -0.04991641477611458F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.3127630032889644F, 0);
				this.RightArm.x = Mth.lerp(sleepProgress, -10, -6.0F);
				this.RightArm.y = Mth.lerp(sleepProgress, 12, 8.0F);
				this.RightArm.z = Mth.lerp(sleepProgress, -24, -26.0F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.2217304763960306F, 0.09599310885968812F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.07749261978723364F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 1.0821041362364843F, 0);
				this.Body.y = Mth.lerp(sleepProgress, 9, -16.0F);
				this.Body.zRot = Mth.lerp(sleepProgress, -0.11728612207217244F, 0);
				this.RightFoot.y = Mth.lerp(sleepProgress, 12.2F, 16F);
				this.RightFoot.z = Mth.lerp(sleepProgress, -1, 4.0F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, -0.03490658503988659F, 0);
				this.Neck.x = Mth.lerp(sleepProgress, -2, 0.0F);
				this.Neck.y = Mth.lerp(sleepProgress, 5, 2.0F);
				this.Neck.z = Mth.lerp(sleepProgress, -42, -37.0F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.1319468904520859F, -0.6108652381980153F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0.5473352640780661F, 0);
				this.Head.y = Mth.lerp(sleepProgress, -3.07F, -5.07F);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.09005898673974631F, 0.767944870877505F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0.35185837453889574F, 0);
				this.Head.zRot = Mth.lerp(sleepProgress, 0.0781907508222411F, 0);
			} else {
				this.Body.xRot = 0;
				this.Neck.xRot = (Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount - 0.6F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float)Math.toRadians(30F);
				this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
				this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
				this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.15F * limbSwingAmount + 0.05F;
				this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
				this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 1.0F * limbSwingAmount;
				this.Head.xRot = Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount + 0.8F + attackProgress * (float)Math.toRadians(-40F);
				this.Jaw.xRot = attackProgress * (float) Math.toRadians(25F);
				this.Neck.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
				this.Head.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
				this.LeftArm.xRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.RightArm.xRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.05F;
				this.LeftLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.05F;
				this.LeftFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.05F;
				this.RightLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.05F;
				this.RightFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.3F * limbSwingAmount;
				this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.25F) + 0.05F;
					this.Body.xRot = 0.2F;
					this.Jaw.xRot = Math.abs(Mth.sin(0.15F * ageInTicks) * 0.25F);
				}
				if (entity.isInWater()) {
					this.LeftThigh.y = 20;
					this.RightThigh.y = 20;
					this.Body.y = 20;
					this.Body.xRot = -0.125F;
					this.Tail1.xRot = 0.0625F;
					this.Tail2.xRot = 0.0625F;
					this.LeftThigh.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftFoot.xRot = 0.25F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.RightFoot.xRot = 0.25F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.RightArm.xRot = 0.125F;
					this.LeftArm.xRot = 0.125F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Tail2.xRot = 0.09599310885968812F;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftArm.x = 6.0F;
		this.LeftArm.y = 8.0F;
		this.LeftArm.z = -26.0F;
		this.LeftArm.xRot = 0.09599310885968812F;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.RightThigh.x = -4.0F;
		this.RightThigh.y = -14.0F;
		this.RightThigh.z = 4.0F;
		this.RightThigh.xRot = -0.04991641477611458F;
		this.RightThigh.yRot = 0;
		this.LeftLeg.y = 19.0F;
		this.LeftLeg.z = 0.0F;
		this.LeftLeg.xRot = 0.04991641477611458F;
		this.RightLeg.y = 19.0F;
		this.RightLeg.z = 0.0F;
		this.RightLeg.xRot = 0.05000000058364023F;
		this.Tail1.xRot = -0.15707963267948966F;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.LeftFoot.y = 16.0F;
		this.LeftFoot.z = 4.0F;
		this.LeftFoot.xRot = 0;
		this.LeftThigh.x = 4.0F;
		this.LeftThigh.y = -14.0F;
		this.LeftThigh.z = 4.0F;
		this.LeftThigh.xRot = -0.04991641477611458F;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.RightArm.x = -6.0F;
		this.RightArm.y = 8.0F;
		this.RightArm.z = -26.0F;
		this.RightArm.xRot = 0.09599310885968812F;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.Body.y = -16.0F;
		this.Body.xRot = 0;
		this.Body.zRot = 0;
		this.RightFoot.y = 16.0F;
		this.RightFoot.z = 4.0F;
		this.RightFoot.xRot = 0;
		this.Neck.x = 0.0F;
		this.Neck.y = 2.0F;
		this.Neck.z = -37.0F;
		this.Neck.xRot = -0.6108652381980153F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Head.y = -5.07F;
		this.Head.xRot = 0.767944870877505F;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
	}

	public void sleepPose() {
		this.Tail2.xRot = 0.17802358037447025F;
		this.Tail2.yRot = -0.35185837453889574F;
		this.Tail2.zRot = 1.7453292129831807E-4F;
		this.LeftArm.x = 7.0F;
		this.LeftArm.y = 14.0F;
		this.LeftArm.z = -24.0F;
		this.LeftArm.xRot = -1.3089969389957472F;
		this.LeftArm.yRot = 0.03490658503988659F;
		this.LeftArm.zRot = -1.2217304763960306F;
		this.RightThigh.x = -5.0F;
		this.RightThigh.y = 13.0F;
		this.RightThigh.z = 12.0F;
		this.RightThigh.xRot = -2.2689280275926285F;
		this.RightThigh.yRot = 0.27366763203903305F;
		this.LeftLeg.y = 15.0F;
		this.LeftLeg.z = 6.3F;
		this.LeftLeg.xRot = 2.356194490192345F;
		this.RightLeg.y = 15.0F;
		this.RightLeg.z = 7.0F;
		this.RightLeg.xRot = 2.3038346126325147F;
		this.Tail1.xRot = -0.22689280275926282F;
		this.Tail1.yRot = -0.3490658503988659F;
		this.Tail1.zRot = 0.03490658503988659F;
		this.LeftFoot.y = 14.0F;
		this.LeftFoot.z = -1.0F;
		this.LeftFoot.xRot = -0.12217304763960307F;
		this.LeftThigh.x = 5.9F;
		this.LeftThigh.y = 11.2F;
		this.LeftThigh.z = 12.0F;
		this.LeftThigh.xRot = -2.234021442552742F;
		this.LeftThigh.yRot = -0.3127630032889644F;
		this.RightArm.x = -10.0F;
		this.RightArm.y = 12.0F;
		this.RightArm.z = -24.0F;
		this.RightArm.xRot = -1.2217304763960306F;
		this.RightArm.yRot = 0.07749261978723364F;
		this.RightArm.zRot = 1.0821041362364843F;
		this.Body.y = 9.0F;
		this.Body.zRot = -0.11728612207217244F;
		this.RightFoot.y = 12.2F;
		this.RightFoot.z = -1.0F;
		this.RightFoot.xRot = -0.03490658503988659F;
		this.Neck.x = -2.0F;
		this.Neck.y = 5.0F;
		this.Neck.z = -42.0F;
		this.Neck.xRot = 0.1319468904520859F;
		this.Neck.yRot = 0.5473352640780661F;
		this.Head.y = -3.07F;
		this.Head.xRot = -0.09005898673974631F;
		this.Head.yRot = 0.35185837453889574F;
		this.Head.zRot = 0.0781907508222411F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}