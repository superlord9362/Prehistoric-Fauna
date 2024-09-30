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

public class SillosuchusBabyModel extends EntityModel<Sillosuchus> {
	private final ModelPart Torso;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart TailBase;
	private final ModelPart LArm;
	private final ModelPart RArm;
	private final ModelPart RLeg;
	private final ModelPart RFoot;
	private final ModelPart LLeg;
	private final ModelPart LFoot;

	public SillosuchusBabyModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.Neck = Torso.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.TailBase = Torso.getChild("TailBase");
		this.LArm = Torso.getChild("LArm");
		this.RArm = Torso.getChild("RArm");
		this.RLeg = root.getChild("RLeg");
		this.RFoot = RLeg.getChild("RFoot");
		this.LLeg = root.getChild("LLeg");
		this.LFoot = LLeg.getChild("LFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -7.0F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -7.5F, -2.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.1047F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(16, 18).addBox(-2.0F, -1.0F, -3.5F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.6F, -2.0F));

		PartDefinition Beak = Head.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(16, 25).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -3.5F));

		PartDefinition TailBase = Torso.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 12.0F));

		PartDefinition RArm = Torso.addOrReplaceChild("RArm", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 4.0F, 2.0F, 0.0F, 0.0F, -0.1047F));

		PartDefinition LArm = Torso.addOrReplaceChild("LArm", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 4.0F, 2.0F, 0.0F, 0.0F, 0.1047F));

		PartDefinition RLeg = partdefinition.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(22, 0).addBox(-2.0F, -1.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 16.5F, 1.5F));

		PartDefinition RFoot = RLeg.addOrReplaceChild("RFoot", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.5F, 0.0F, -5.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 7.5F, 0.5F));

		PartDefinition LLeg = partdefinition.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, -1.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 16.5F, 1.5F));

		PartDefinition LFoot = LLeg.addOrReplaceChild("LFoot", CubeListBuilder.create().texOffs(0, 18).addBox(-1.5F, 0.0F, -5.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 7.5F, 0.5F));

		return LayerDefinition.create(meshdefinition, 34, 33);
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
				this.LArm.x = Mth.lerp(sleepProgress, -2.5F, 3.0F);
				this.LArm.y = Mth.lerp(sleepProgress, 4, 5.0F);
				this.LArm.z = Mth.lerp(sleepProgress, 2, 3.0F);
				this.LArm.xRot = Mth.lerp(sleepProgress, 0.09599310885968812F, -1.3089969389957472F);
				this.LArm.yRot = Mth.lerp(sleepProgress, 0, 0.03490658503988659F);
				this.LArm.zRot = Mth.lerp(sleepProgress, 0.1047F, -1.2217304763960306F);
				this.RLeg.x = Mth.lerp(sleepProgress, 2.5F, -2.0F);
				this.RLeg.y = Mth.lerp(sleepProgress, 16.5F, 22.5F);
				this.RLeg.z = Mth.lerp(sleepProgress, 1.5F, 3.0F);
				this.RLeg.xRot = Mth.lerp(sleepProgress, 0, -1.5F);
				this.RLeg.yRot = Mth.lerp(sleepProgress, 0, 0.27366763203903305F);
				this.LFoot.y = Mth.lerp(sleepProgress, 7.5F, 7.0F);
				this.LFoot.z = Mth.lerp(sleepProgress, 0, 1.0F);
				this.LFoot.xRot = Mth.lerp(sleepProgress, 0.04991641477611458F, 1.45F);
				this.RFoot.y = Mth.lerp(sleepProgress, 7.5F, 7.0F);
				this.RFoot.z = Mth.lerp(sleepProgress, 0.5F, 1.0F);
				this.RFoot.xRot = Mth.lerp(sleepProgress, 0.05000000058364023F, 1.45F);
				this.TailBase.xRot = Mth.lerp(sleepProgress, -0.15707963267948966F, -0.22689280275926282F);
				this.TailBase.yRot = Mth.lerp(sleepProgress, 0, -0.3490658503988659F);
				this.TailBase.zRot = Mth.lerp(sleepProgress, 0, 0.03490658503988659F);
				this.LLeg.x = Mth.lerp(sleepProgress, -2.5F, 3.0F);
				this.LLeg.y = Mth.lerp(sleepProgress, 16.5F, 22.5F);
				this.LLeg.z = Mth.lerp(sleepProgress, 1.5F, 3.0F);
				this.LLeg.xRot = Mth.lerp(sleepProgress, 0, -1.5F);
				this.LLeg.yRot = Mth.lerp(sleepProgress, 0, -0.3127630032889644F);
				this.RArm.x = Mth.lerp(sleepProgress, 2.5F, -3.0F);
				this.RArm.y = Mth.lerp(sleepProgress, 4, 5.0F);
				this.RArm.z = Mth.lerp(sleepProgress, 2, 3.0F);
				this.RArm.xRot = Mth.lerp(sleepProgress, 0.09599310885968812F, -1.2217304763960306F);
				this.RArm.yRot = Mth.lerp(sleepProgress, 0, 0.07749261978723364F);
				this.RArm.zRot = Mth.lerp(sleepProgress, -0.1047F, 1.0821041362364843F);
				this.Torso.y = Mth.lerp(sleepProgress, 13, 18.0F);
				this.Torso.zRot = Mth.lerp(sleepProgress, 0, -0.11728612207217244F);
				this.Neck.x = Mth.lerp(sleepProgress, 0, -1.0F);
				this.Neck.y = Mth.lerp(sleepProgress, 2.5F, 2.0F);
				this.Neck.z = Mth.lerp(sleepProgress, 0, 0.0F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.1047F, 1.5F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, 0.5473352640780661F);
				this.Head.y = Mth.lerp(sleepProgress, -6.6F, -7F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, -1.19005898673974631F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, 0.35185837453889574F);
				this.Head.zRot = Mth.lerp(sleepProgress, 0, 0.0781907508222411F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.LArm.x = Mth.lerp(sleepProgress, 3, -2.5F);
				this.LArm.y = Mth.lerp(sleepProgress, 5, 4.0F);
				this.LArm.z = Mth.lerp(sleepProgress, 3, 2.0F);
				this.LArm.xRot = Mth.lerp(sleepProgress, -1.3089969389957472F, 0.09599310885968812F);
				this.LArm.yRot = Mth.lerp(sleepProgress, 0.03490658503988659F, 0);
				this.LArm.zRot = Mth.lerp(sleepProgress, -1.2217304763960306F, 0.1047F);
				this.RLeg.x = Mth.lerp(sleepProgress, -2.0F, 2.5F);
				this.RLeg.y = Mth.lerp(sleepProgress, 22.5F, 16.5F);
				this.RLeg.z = Mth.lerp(sleepProgress, 3F, 1.5F);
				this.RLeg.xRot = Mth.lerp(sleepProgress, -1.5F, 0F);
				this.RLeg.yRot = Mth.lerp(sleepProgress, 0.27366763203903305F, 0);
				this.LFoot.y = Mth.lerp(sleepProgress, 7F, 7.5F);
				this.LFoot.z = Mth.lerp(sleepProgress, 1, 0F);
				this.LFoot.xRot = Mth.lerp(sleepProgress, 1.45F, 0.04991641477611458F);
				this.RFoot.y = Mth.lerp(sleepProgress, 7F, 7.5F);
				this.RFoot.z = Mth.lerp(sleepProgress, 1F, 0.5F);
				this.RFoot.xRot = Mth.lerp(sleepProgress, 1.45F, 0.05000000058364023F);
				this.TailBase.xRot = Mth.lerp(sleepProgress, -0.22689280275926282F, -0.15707963267948966F);
				this.TailBase.yRot = Mth.lerp(sleepProgress, -0.3490658503988659F, 0);
				this.TailBase.zRot = Mth.lerp(sleepProgress, 0.03490658503988659F, 0);
				this.LLeg.x = Mth.lerp(sleepProgress, 3F, -2.5F);
				this.LLeg.y = Mth.lerp(sleepProgress, 22.5F, 16.5F);
				this.LLeg.z = Mth.lerp(sleepProgress, 3F, 1.5F);
				this.LLeg.xRot = Mth.lerp(sleepProgress, -1.5F, 0F);
				this.LLeg.yRot = Mth.lerp(sleepProgress, -0.3127630032889644F, 0);
				this.RArm.x = Mth.lerp(sleepProgress, -3F, 2.5F);
				this.RArm.y = Mth.lerp(sleepProgress, 5, 4.0F);
				this.RArm.z = Mth.lerp(sleepProgress, 3, 2.0F);
				this.RArm.xRot = Mth.lerp(sleepProgress, -1.2217304763960306F, 0.09599310885968812F);
				this.RArm.yRot = Mth.lerp(sleepProgress, 0.07749261978723364F, 0);
				this.RArm.zRot = Mth.lerp(sleepProgress, 1.0821041362364843F, -0.1047F);
				this.Torso.y = Mth.lerp(sleepProgress, 18, 13.0F);
				this.Torso.zRot = Mth.lerp(sleepProgress, -0.11728612207217244F, 0);
				this.Neck.x = Mth.lerp(sleepProgress, -1, 0F);
				this.Neck.y = Mth.lerp(sleepProgress, 2F, 2.5F);
				this.Neck.z = Mth.lerp(sleepProgress, 0, 0.0F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 1.5F, 0.1047F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0.5473352640780661F, 0);
				this.Head.y = Mth.lerp(sleepProgress, -7F, -6.6F);
				this.Head.xRot = Mth.lerp(sleepProgress, -1.19005898673974631F, 0);
				this.Head.yRot = Mth.lerp(sleepProgress, 0.35185837453889574F, 0);
				this.Head.zRot = Mth.lerp(sleepProgress, 0.0781907508222411F, 0);
			} else {
				this.Torso.xRot = 0;
				this.Neck.xRot = (Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount + 0.1047F) + (headPitch * ((float) Math.PI / 180F)) + (attackProgress * (float)Math.toRadians(30F));
				this.Torso.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
				this.TailBase.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
				this.TailBase.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
				this.Head.xRot = Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount + attackProgress * (float)Math.toRadians(-40F);
				this.Neck.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
				this.Head.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
				this.LArm.xRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.RArm.xRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.LLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.05F;
				this.LFoot.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.05F;
				this.RLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.05F;
				this.RFoot.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.05F;
				this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.25F) + 0.05F;
					this.Torso.xRot = 0.2F;
				}
				if (entity.isInWater()) {
					this.LLeg.y = 23;
					this.RLeg.y = 23;
					this.Torso.y = 18;
					this.Torso.xRot = -0.125F;
					this.TailBase.xRot = 0.0625F;
					this.LLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LFoot.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RFoot.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RArm.xRot = 0.125F;
					this.LArm.xRot = 0.125F;
				}
			}
		}
	}

	public void resetModel() {
		this.LArm.x = -2.5F;
		this.LArm.y = 4.0F;
		this.LArm.z = 2.0F;
		this.LArm.xRot = 0.09599310885968812F;
		this.LArm.yRot = 0;
		this.LArm.zRot = 0.1047F;
		this.RLeg.x = 2.5F;
		this.RLeg.y = 16.5F;
		this.RLeg.z = 1.5F;
		this.RLeg.xRot = 0F;
		this.RLeg.yRot = 0;
		this.LFoot.y = 7.5F;
		this.LFoot.z = 0.0F;
		this.LFoot.xRot = 0.04991641477611458F;
		this.RFoot.y = 7.5F;
		this.RFoot.z = 0.5F;
		this.RFoot.xRot = 0.05000000058364023F;
		this.TailBase.xRot = -0.15707963267948966F;
		this.TailBase.yRot = 0;
		this.TailBase.zRot = 0;
		this.LLeg.x = -2.5F;
		this.LLeg.y = 16.5F;
		this.LLeg.z = 1.5F;
		this.LLeg.xRot = 0F;
		this.LLeg.yRot = 0;
		this.LLeg.zRot = 0;
		this.RArm.x = 2.5F;
		this.RArm.y = 4.0F;
		this.RArm.z = 2.0F;
		this.RArm.xRot = 0.09599310885968812F;
		this.RArm.yRot = 0;
		this.RArm.zRot = -0.1047F;
		this.Torso.y = 13.0F;
		this.Torso.xRot = 0;
		this.Torso.zRot = 0;
		this.Neck.x = 0.0F;
		this.Neck.y = 2.5F;
		this.Neck.z = 0.0F;
		this.Neck.xRot = 0.1047F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Head.y = -6.6F;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
	}

	public void sleepPose() {
		this.LArm.x = 3.0F;
		this.LArm.y = 5.0F;
		this.LArm.z = 3.0F;
		this.LArm.xRot = -1.3089969389957472F;
		this.LArm.yRot = 0.03490658503988659F;
		this.LArm.zRot = -1.2217304763960306F;
		this.RLeg.x = -2.0F;
		this.RLeg.y = 22.5F;
		this.RLeg.z = 3.0F;
		this.RLeg.xRot = -1.5F;
		this.RLeg.yRot = 0.27366763203903305F;
		this.LFoot.y = 7.0F;
		this.LFoot.z = 1.0F;
		this.LFoot.xRot = 1.45F;
		this.RFoot.y = 7.0F;
		this.RFoot.z = 1.0F;
		this.RFoot.xRot = 1.45F;
		this.TailBase.xRot = -0.22689280275926282F;
		this.TailBase.yRot = -0.3490658503988659F;
		this.TailBase.zRot = 0.03490658503988659F;
		this.LLeg.x = 3.0F;
		this.LLeg.y = 22.5F;
		this.LLeg.z = 3.0F;
		this.LLeg.xRot = -1.5F;
		this.LLeg.yRot = -0.3127630032889644F;
		this.RArm.x = -3.0F;
		this.RArm.y = 5.0F;
		this.RArm.z = 3.0F;
		this.RArm.xRot = -1.2217304763960306F;
		this.RArm.yRot = 0.07749261978723364F;
		this.RArm.zRot = 1.0821041362364843F;
		this.Torso.y = 18.0F;
		this.Torso.zRot = -0.11728612207217244F;
		this.Neck.x = -1.0F;
		this.Neck.y = 2.0F;
		this.Neck.z = 0.0F;
		this.Neck.xRot = 1.5F;
		this.Neck.yRot = 0.5473352640780661F;
		this.Head.y = -7F;
		this.Head.xRot = -1.19005898673974631F;
		this.Head.yRot = 0.35185837453889574F;
		this.Head.zRot = 0.0781907508222411F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
