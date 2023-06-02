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
import net.minecraft.world.phys.Vec3;
import superlord.prehistoricfauna.common.entity.henos.Henos;

public class HenosModel extends EntityModel<Henos> {
	private final ModelPart Body;
	private final ModelPart RLeg;
	private final ModelPart LLeg;
	private final ModelPart Head;
	private final ModelPart Hips;
	private final ModelPart LArm;
	private final ModelPart RArm;
	private final ModelPart RThumb;
	private final ModelPart ROFinger;
	private final ModelPart RIFinger;
	private final ModelPart RMFinger;
	private final ModelPart LThumb;
	private final ModelPart LOFinger;
	private final ModelPart LIFinger;
	private final ModelPart LMFinger;

	public HenosModel(ModelPart root, float modelScale) {
		this.Body = root.getChild("Body");
		this.Hips = Body.getChild("Hips");
		this.RLeg = Hips.getChild("RLeg");
		this.LLeg = Hips.getChild("LLeg");
		this.Head = Body.getChild("Head");
		this.LArm = Body.getChild("LArm");
		this.RArm = Body.getChild("RArm");
		this.LIFinger = LArm.getChild("LIFinger");
		this.LMFinger = LArm.getChild("LMFinger");
		this.LOFinger = LArm.getChild("LOFinger");
		this.LThumb = LArm.getChild("LThumb");
		this.RIFinger = RArm.getChild("RIFinger");
		this.RMFinger = RArm.getChild("RMFinger");
		this.ROFinger = RArm.getChild("ROFinger");
		this.RThumb = RArm.getChild("RThumb");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-34.0F, 0.0F, 0.0F, 34.0F, 21.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(17.0F, -20.0F, -11.0F));

		PartDefinition Hips = Body.addOrReplaceChild("Hips", CubeListBuilder.create().texOffs(56, 42).addBox(-8.0F, 0.0F, -6.0F, 16.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(-17.0F, 21.1F, 11.0F));

		PartDefinition RLeg = Hips.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(56, 64).addBox(-9.0F, -1.0F, -4.0F, 9.0F, 17.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 7.0F, 0.0F));

		PartDefinition LLeg = Hips.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(56, 64).addBox(0.0F, -1.0F, -4.0F, 9.0F, 17.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 7.0F, 0.0F));

		PartDefinition RArm = Body.addOrReplaceChild("RArm", CubeListBuilder.create().texOffs(0, 42).addBox(-14.0F, -4.0F, -7.0F, 14.0F, 20.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-36.0F, 13.0F, 11.0F));

		PartDefinition RMFinger = RArm.addOrReplaceChild("RMFinger", CubeListBuilder.create().texOffs(1, 44).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.5F, 17.0F, -5.5F));

		PartDefinition RThumb = RArm.addOrReplaceChild("RThumb", CubeListBuilder.create().texOffs(1, 44).addBox(0.0F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 11.0F, -3.5F));

		PartDefinition RIFinger = RArm.addOrReplaceChild("RIFinger", CubeListBuilder.create().texOffs(1, 44).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 17.0F, -5.5F));

		PartDefinition ROFinger = RArm.addOrReplaceChild("ROFinger", CubeListBuilder.create().texOffs(1, 44).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.5F, 17.0F, -5.5F));

		PartDefinition LArm = Body.addOrReplaceChild("LArm", CubeListBuilder.create().texOffs(0, 42).addBox(0.0F, -4.0F, -7.0F, 14.0F, 20.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 13.0F, 11.0F));

		PartDefinition LMFinger = LArm.addOrReplaceChild("LMFinger", CubeListBuilder.create().texOffs(1, 44).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(7.5F, 17.0F, -5.5F));

		PartDefinition LIFinger = LArm.addOrReplaceChild("LIFinger", CubeListBuilder.create().texOffs(1, 44).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 17.0F, -5.5F));

		PartDefinition LOFinger = LArm.addOrReplaceChild("LOFinger", CubeListBuilder.create().texOffs(1, 44).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(12.5F, 17.0F, -5.5F));

		PartDefinition LThumb = LArm.addOrReplaceChild("LThumb", CubeListBuilder.create().texOffs(1, 44).addBox(-3.0F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 11.0F, -3.5F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 76).addBox(-6.0F, -7.0F, -12.0F, 12.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-17.0F, 1.0F, 5.0F));

		PartDefinition LEar = Head.addOrReplaceChild("LEar", CubeListBuilder.create().texOffs(37, 77).addBox(0.0F, -3.0F, -1.0F, 6.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -3.0F, -7.0F));

		PartDefinition Mouth = Head.addOrReplaceChild("Mouth", CubeListBuilder.create().texOffs(49, 91).addBox(-10.0F, -3.0F, -4.0F, 20.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, -10.0F));

		PartDefinition REar = Head.addOrReplaceChild("REar", CubeListBuilder.create().texOffs(37, 77).mirror().addBox(-6.0F, -3.0F, -1.0F, 6.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, -3.0F, -7.0F));

		return LayerDefinition.create(meshdefinition, 250, 128);
	}

	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	public void setupAnim(Henos entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float f = ageInTicks - entity.tickCount;
		this.RLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		float attackRight = entity.getMeleeProgress(false, f) / 5.0F;
		float attackLeft = entity.getMeleeProgress(true, f) / 5.0F;
		float attack = Math.max(attackLeft, attackRight);
		float rightFingerCurl = attackRight * (float)Math.toRadians(80);
		float leftFingerCurl = attackLeft * (float)Math.toRadians(80);
		float bodyYaw = attack * (float)Math.toRadians(20);
		this.LArm.xRot = attackLeft * (float)Math.toRadians(-100) + (Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount) * (1.0F - attack);
		this.LArm.yRot = leftFingerCurl * 0.25F;
		this.LArm.zRot = leftFingerCurl * 0.15F;
		this.RArm.xRot = attackRight * (float)Math.toRadians(-100) + (Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount) * (1.0F - attack);
		this.RArm.yRot = rightFingerCurl * -0.25F;
		this.RArm.zRot = rightFingerCurl * -0.15F;
		this.RIFinger.xRot = rightFingerCurl;
		this.ROFinger.xRot = rightFingerCurl;
		this.RMFinger.xRot = rightFingerCurl;
		this.RThumb.xRot = rightFingerCurl;
		this.LIFinger.xRot = leftFingerCurl;
		this.LOFinger.xRot = leftFingerCurl;
		this.LMFinger.xRot = leftFingerCurl;
		this.LThumb.xRot = leftFingerCurl;
		this.RArm.x = -36.0F + attackRight * 5;
		this.RArm.z = 11.0F + attackRight * -16;
		this.RThumb.x = 1.0F + attackRight * 1;
		this.RThumb.y = 11.0F + attackRight * 2;
		this.LArm.x = 2.0F - attackLeft * 5;
		this.LArm.z = 11.0F + attackLeft * -16;
		this.LThumb.x = -1.0F - attackLeft * 1;
		this.LThumb.y = 11.0F + attackLeft * 2;
		this.Body.y = -20.0F + attack * 5;
		this.Body.z = -11.0F - attack * 8;
		this.Body.xRot = bodyYaw;
		this.Hips.xRot = -bodyYaw;
		this.Head.xRot = headPitch * ((float)Math.PI / 180F) - bodyYaw;
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F) - this.Body.yRot;
		Vec3 vec = entity.getLaserTargetPos(f);
		double d0 = vec.x - entity.getX();
		double d2 = vec.z - entity.getZ();
		float bossYaw = 90F + Mth.rotlerp(f, entity.yBodyRotO, entity.yBodyRot);
		float laserBodyTwist = Mth.wrapDegrees((float)(Mth.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - bossYaw);
		this.Body.yRot = attackLeft * (float)Math.toRadians(20) + attackRight * (float)Math.toRadians(-20);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
