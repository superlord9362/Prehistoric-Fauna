package superlord.prehistoricfauna.client.model.cretaceous.hellcreek;

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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Dakotaraptor;

public class DakotaraptorBabyModel extends EntityModel<Dakotaraptor> {
	private final ModelPart Torso;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart TailBase;
	private final ModelPart LArm;
	private final ModelPart RArm;
	private final ModelPart LLeg;
	private final ModelPart LFoot;
	private final ModelPart RLeg;
	private final ModelPart RFoot;

	public DakotaraptorBabyModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.Neck = Torso.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.TailBase = Torso.getChild("TailBase");
		this.LArm = Torso.getChild("LArm");
		this.RArm = Torso.getChild("RArm");
		this.LLeg = root.getChild("LLeg");
		this.LFoot = LLeg.getChild("LFoot");
		this.RLeg = root.getChild("RLeg");
		this.RFoot = RLeg.getChild("RFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -5.0F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(16, 15).addBox(-1.5F, -6.0F, -3.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.1047F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(18, 0).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.1F, -1.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

		PartDefinition TailBase = Torso.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.1F, 10.0F));

		PartDefinition RArm = Torso.addOrReplaceChild("RArm", CubeListBuilder.create().texOffs(0, 26).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 3.0F, 2.0F, 0.0F, 0.0F, -0.1047F));

		PartDefinition RHand = RArm.addOrReplaceChild("RHand", CubeListBuilder.create().texOffs(1, 33).addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1F, 2.5F, -1.0F));

		PartDefinition LArm = Torso.addOrReplaceChild("LArm", CubeListBuilder.create().texOffs(0, 26).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.1047F));

		PartDefinition LHand = LArm.addOrReplaceChild("LHand", CubeListBuilder.create().texOffs(1, 33).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.1F, 2.5F, -1.0F));

		PartDefinition LLeg = partdefinition.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 15.5F, 2.5F));

		PartDefinition LFoot = LLeg.addOrReplaceChild("LFoot", CubeListBuilder.create().texOffs(5, 30).addBox(-1.5F, 0.0F, -2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.5F, 1.5F));

		PartDefinition RLeg = partdefinition.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 15.5F, 2.5F));

		PartDefinition RFoot = RLeg.addOrReplaceChild("RFoot", CubeListBuilder.create().texOffs(5, 30).mirror().addBox(-0.5F, 0.0F, -2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.5F, 1.5F));

		return LayerDefinition.create(meshdefinition, 36, 40);
	}

	@Override
	public void setupAnim(Dakotaraptor entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		this.resetModel();
		if (entity.isCrouching()) {
			this.Torso.xRot =  0.39269908169872414F;
			this.LArm.zRot = Mth.cos(limbSwing * speed * 0.05F) * degree * 0.6F * limbSwingAmount + 0.4F;
			this.RArm.zRot = Mth.cos(3.0F + limbSwing * speed * 0.05F) * degree * 0.6F * limbSwingAmount - 0.4F;
			this.Torso.xRot = Mth.cos(limbSwing * speed * 0.05F) * degree * 0.2F * limbSwingAmount + 0.5F;
			this.RLeg.xRot = Mth.cos(limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
			this.RFoot.xRot = Mth.cos(limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
			this.LLeg.xRot = Mth.cos(3.0F + limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
			this.LFoot.xRot = Mth.cos(3.0F + limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
			this.TailBase.xRot = -0.08464846705724931F + (Mth.cos(limbSwing * speed * 0.05F) * degree * 0.3F * limbSwingAmount - 0.3F);
		} else if (entity.isSitting() && !entity.isAsleep()) {
			this.LArm.xRot = 0.7740534966278743F;
			this.LArm.zRot = (Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)));
			this.Neck.xRot = 0.6829473549475088F;
			this.RArm.xRot = 0.7740534966278743F;
			this.RArm.zRot = (-Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)));
			this.Torso.xRot = -0.6373942508178124F;
			this.RLeg.xRot = -1.5707963267948966F;
			this.RLeg.yRot = -0.18203784630933073F;
			this.LLeg.xRot = -1.5707963267948966F;
			this.LLeg.yRot = 0.18203784630933073F;
			this.TailBase.xRot = 0.500909508638178F;
			this.Torso.y = 14.9F;
			this.RLeg.y = 22.5F;
			this.RLeg.z = 1;
			this.RFoot.y = 3;
			this.LFoot.y = 3;
			this.LLeg.y = 22.5F;
			this.LLeg.z = 1;
			this.Neck.y = 2;
			this.Neck.z = 1;
			this.Head.z = 0.25F;
			this.TailBase.z = 10;
		}
		else if (entity.isAsleep()) {
			this.LArm.zRot = 1.092750655326294F;
			this.LLeg.xRot = -1.5707963267948966F;
			this.RLeg.xRot = -1.5707963267948966F + (Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)));
			this.RArm.zRot = -1.092750655326294F + (-Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)));
			this.Neck.xRot = 0.13665927909957545F;
			this.Neck.yRot = -1.4570009181544104F;
			this.TailBase.xRot = -0.2275909337942703F;
			this.TailBase.yRot = 1.5707963267948966F;
			this.Torso.y = 18.9F;
			this.Torso.z = -5;
			this.RLeg.x = 2;
			this.RLeg.y = 22.5F;
			this.RLeg.z = 4;
			this.RFoot.y = 2;
			this.LLeg.x = -2;
			this.LLeg.y = 22.5F;
			this.LLeg.z = 4;
			this.LFoot.y = 2;
			this.Neck.y = 1;
			this.Neck.z = 0.5F;
			this.Head.z = 0.25F;
			this.TailBase.x = 0;
		}
		else {
			this.RLeg.xRot = Mth.cos(limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount + attackProgress * (float) Math.toRadians(-65F);
			this.LLeg.xRot = Mth.cos(3.0F + limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount + attackProgress * (float) Math.toRadians(-65F);
			this.TailBase.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.2F) * degree * 0.2F * limbSwingAmount);
			this.TailBase.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.2F) * degree * 0.05F * limbSwingAmount + 0.05F) + attackProgress * (float) Math.toRadians(25F);
			this.Torso.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.1F) * (degree / 2) * 0.2F * limbSwingAmount) + attackProgress * (float) Math.toRadians(-30F);
			this.Neck.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + (Mth.cos(limbSwing * speed * 0.1F) * (degree / 2) * 0.3F * limbSwingAmount + 0.1F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(25F);
			this.Head.xRot = -Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
			this.RArm.zRot = (-Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.4F) * degree * 0.1F * limbSwingAmount) + attackProgress * (float) Math.toRadians(-85F);
			this.LArm.zRot = (Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + (Mth.cos(3.0F + limbSwing * speed * 0.4F) * degree * 0.1F * limbSwingAmount) + attackProgress * (float) Math.toRadians(85F);
			this.RArm.xRot = Mth.cos(limbSwing * speed * 0.2F) * degree * 0.2F * limbSwingAmount;
			this.LArm.xRot = Mth.cos(limbSwing * speed * 0.2F) * degree * 0.2F * limbSwingAmount;
		}
		if (entity.isInWater()) {
			this.RLeg.y = 20;
			this.LLeg.y = 20;
			this.Torso.y = 16;
			this.Torso.xRot = -0.5F;
			this.TailBase.xRot = 0.25F;
			this.Neck.xRot = 0.5F;
			this.RArm.zRot = -1.5F + Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
			this.LArm.zRot = 1.5F - Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
			this.RLeg.xRot = -0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
			this.LLeg.xRot = 0.5F * Mth.sin(0.2F * ageInTicks / 1.5F);
			this.TailBase.yRot = Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount;
			this.RFoot.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
			this.LFoot.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
		}
	}

	public void resetModel() {
		this.Torso.xRot = 0;
		this.Torso.yRot = 0;
		this.Torso.zRot = 0;
		this.RLeg.xRot = 0;
		this.RLeg.yRot = 0;
		this.RLeg.zRot = 0;
		this.LLeg.xRot = 0;
		this.LLeg.yRot = 0;
		this.LLeg.zRot = 0;
		this.RFoot.xRot = 0;
		this.RFoot.yRot = 0;
		this.RFoot.zRot = 0;
		this.LFoot.xRot = 0;
		this.LFoot.yRot = 0;
		this.LFoot.zRot = 0;
		this.LArm.xRot = 0;
		this.LArm.yRot = 0;
		this.LArm.zRot = 0.1047F;
		this.RArm.xRot = 0;
		this.RArm.yRot = 0;
		this.RArm.zRot = -0.1047F;
		this.TailBase.xRot = -0.04555309164612875F;
		this.TailBase.yRot = 0;
		this.TailBase.zRot = 0;
		this.Neck.xRot = 0.1047F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.Torso.x = 0;
		this.Torso.y = 13F;
		this.Torso.z = -5;
		this.Neck.x = 0;
		this.Neck.y = 3;
		this.Neck.z = 0;
		this.Head.x = 0;
		this.Head.y = -5.1F;
		this.Head.z = -1;
		this.RArm.x = 2;
		this.RArm.y = 3;
		this.RArm.z = 2;
		this.LArm.x = -2;
		this.LArm.y = 3;
		this.LArm.z = 2;
		this.TailBase.x = 0;
		this.TailBase.y = 1.1F;
		this.TailBase.z = 10;
		this.RLeg.x = 2;
		this.RLeg.y = 15.5F;
		this.RLeg.z = 2.5F;
		//0.0F, 3.5F, 1.5F
		this.RFoot.x = 0;
		this.RFoot.y = 3.5F;
		this.RFoot.z = 1.5F;
		this.LLeg.x = -2;
		this.LLeg.y = 15.5F;
		this.LLeg.z = 2.5F;
		this.LFoot.x = 0;
		this.LFoot.y = 3.5F;
		this.LFoot.z = 1.5F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
