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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Beipiaosaurus;

public class BeipiaosaurusModel extends EntityModel<Beipiaosaurus> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftArm;
	private final ModelPart LeftClaw1;
	private final ModelPart LeftClaw2;
	private final ModelPart LeftClaw3;
	private final ModelPart RightArm;
	private final ModelPart RightClaw1;
	private final ModelPart RightClaw2;
	private final ModelPart RightClaw3;

	public BeipiaosaurusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.Tail = Body.getChild("Tail");
		this.LeftThigh = Body.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
		this.RightThigh = Body.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
		this.LeftArm = Body.getChild("LeftArm");
		this.LeftClaw1 = LeftArm.getChild("LeftClaw1");
		this.LeftClaw2 = LeftArm.getChild("LeftClaw2");
		this.LeftClaw3 = LeftArm.getChild("LeftClaw3");
		this.RightArm = Body.getChild("RightArm");
		this.RightClaw1 = RightArm.getChild("RightClaw1");
		this.RightClaw2 = RightArm.getChild("RightClaw2");
		this.RightClaw3 = RightArm.getChild("RightClaw3");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.9F, -9.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -7.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.9068F, 0.9246F, 0.6807F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(24, 0).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -5.51F, -2.0F, -0.1571F, 0.0F, 0.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(44, 3).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -0.5F, -4.0F));

		PartDefinition NeckFeathers = Neck.addOrReplaceChild("NeckFeathers", CubeListBuilder.create().texOffs(44, 0).addBox(-1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -1.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(21, 4).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.49F, 14.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition TailFeathers = Tail.addOrReplaceChild("TailFeathers", CubeListBuilder.create().texOffs(0, 20).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 2.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(34, 24).addBox(-1.5F, -2.0F, -2.5F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 4.0F, 10.5F, 0.4363F, 0.0F, 0.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(29, 28).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 2.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(20, 25).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(34, 24).mirror().addBox(-1.5F, -2.0F, -2.5F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 4.0F, 10.5F, 0.4363F, 0.0F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(29, 28).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 2.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(20, 25).mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 3.0F, 2.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition LeftArmFeathers = LeftArm.addOrReplaceChild("LeftArmFeathers", CubeListBuilder.create().texOffs(11, 22).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 0.0F, 1.5F));

		PartDefinition LeftClaw1 = LeftArm.addOrReplaceChild("LeftClaw1", CubeListBuilder.create().texOffs(24, 6).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 5.0F, -1.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition LeftClaw2 = LeftArm.addOrReplaceChild("LeftClaw2", CubeListBuilder.create().texOffs(28, 6).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 5.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition LeftClaw3 = LeftArm.addOrReplaceChild("LeftClaw3", CubeListBuilder.create().texOffs(32, 6).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 5.0F, 1.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 20).mirror().addBox(-1.0F, -1.0F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 3.0F, 2.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition RightArmFeathers = RightArm.addOrReplaceChild("RightArmFeathers", CubeListBuilder.create().texOffs(11, 22).addBox(0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 1.5F));

		PartDefinition RightClaw1 = RightArm.addOrReplaceChild("RightClaw1", CubeListBuilder.create().texOffs(24, 6).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 5.0F, -1.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition RightClaw2 = RightArm.addOrReplaceChild("RightClaw2", CubeListBuilder.create().texOffs(28, 6).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition RightClaw3 = RightArm.addOrReplaceChild("RightClaw3", CubeListBuilder.create().texOffs(32, 6).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 5.0F, 1.0F, 0.0F, 0.0F, 0.1745F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Beipiaosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {

			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {

			} else {
				this.LeftThigh.xRot = (Mth.sin(limbSwing * 0.5F) * 0.48F * limbSwingAmount) + Mth.abs((Mth.sin(0.15F * limbSwing) * -0.5F * limbSwingAmount)) + 0.4363F;
				this.LeftLeg.xRot = Mth.sin(limbSwing * 0.5F) * 0.5F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.abs(Mth.sin(limbSwing * 0.5F) * 0.75F * limbSwingAmount);
				this.RightThigh.xRot = (Mth.sin(limbSwing * 0.5F) * -0.48F * limbSwingAmount) + Mth.abs((Mth.sin(0.15F * limbSwing) * -0.5F * limbSwingAmount)) + 0.4363F;
				this.RightLeg.xRot = Mth.sin(limbSwing * 0.5F) * -0.75F * limbSwingAmount;
				this.RightFoot.xRot = Mth.abs(Mth.sin(limbSwing * 0.5F) * -0.75F * limbSwingAmount);
				this.Body.y = (Mth.sin(0.75F * limbSwing) * 0.45F * limbSwingAmount) + (Mth.sin(0.25F * ageInTicks / 3) * 0.15F) + 5.9F;
				this.Body.xRot = Mth.abs(Mth.sin(0.15F * limbSwing) * 0.15F * limbSwingAmount) - 0.4363F;
				this.RightThigh.y = (Mth.sin(0.75F * limbSwing) * -0.45F * limbSwingAmount) + (Mth.sin(0.25F * ageInTicks / 3) * -0.15F) + 4F;
				this.LeftThigh.y = (Mth.sin(0.75F * limbSwing) * -0.45F * limbSwingAmount) + (Mth.sin(0.25F * ageInTicks / 3) * -0.15F) + 4F;
				this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Mth.abs(Mth.sin(limbSwing * 0.15F) * -0.1F * limbSwingAmount) + Mth.abs(Mth.sin(0.25F * ageInTicks / 3) * 0.05F)) + 0.6807F;
				this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.Head.xRot = (Mth.abs(Mth.sin(limbSwing * 0.25F) * 0.1F * limbSwingAmount) + Mth.abs(Mth.sin(0.25F * ageInTicks / 3) * -0.05F)) - 0.1571F;
				this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * 0.3F) * 0.3F * limbSwingAmount - 0.15F) + 0.2618F;
				this.Tail.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * 0.15F) * 0.2F * limbSwingAmount);
				this.RightArm.zRot = (-Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + (Mth.cos(limbSwing * 0.4F) * 0.1F * limbSwingAmount) + attackProgress * (float) Math.toRadians(-85F);
				this.RightClaw1.zRot = (Math.abs(-0.15F * Mth.sin(0.2F * ageInTicks / 3)));
				this.RightClaw2.zRot = (Math.abs(-0.3F * Mth.sin(0.2F * ageInTicks / 3)));
				this.RightClaw3.zRot = (Math.abs(-0.15F * Mth.sin(0.2F * ageInTicks / 3)));
				this.LeftClaw1.zRot = (-Math.abs(0.15F * Mth.sin(0.2F * ageInTicks / 3)));
				this.LeftClaw2.zRot = (-Math.abs(0.3F * Mth.sin(0.2F * ageInTicks / 3)));
				this.LeftClaw3.zRot = (-Math.abs(0.15F * Mth.sin(0.2F * ageInTicks / 3)));
				this.LeftArm.zRot = (Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3))) + (Mth.cos(3.0F + limbSwing * 0.4F) * 0.1F * limbSwingAmount) + attackProgress * (float) Math.toRadians(85F);
			}
		}
	}

	public void sleepPose() {

	}

	public void resetModel() {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}