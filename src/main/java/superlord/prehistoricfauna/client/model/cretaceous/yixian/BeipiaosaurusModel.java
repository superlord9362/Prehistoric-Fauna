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
				//5.9F, -9.0F, -0.4363F
				this.Body.y = Mth.lerp(sleepProgress, 5.9F, 10.3F);
				this.Body.z = Mth.lerp(sleepProgress, -9, -7.3F);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.4363F, -0.6021F);
				//0.0F, 1.9068F, 0.9246F, 0.6807F, 0.0F, 0.0F
				this.Neck.x = Mth.lerp(sleepProgress, 0, -1.1F);
				this.Neck.y = Mth.lerp(sleepProgress, 1.9068F, 3.9F);
				this.Neck.z = Mth.lerp(sleepProgress, 0.9246F, -0.9F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.6807F, 1.8949F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, 0.6996F);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0, -0.1218F);
				//-5.51F, -2.0F, -0.1571F
				this.Head.y = Mth.lerp(sleepProgress, -5.51F, -4.21F);
				this.Head.z = Mth.lerp(sleepProgress, -2, 0.3F);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.1571F, -0.1134F);
				//1.49F, 14.0F, 0.2618F, 0.0F, 0.0F
				this.Tail.y = Mth.lerp(sleepProgress, 1.49F, 0.79F);
				this.Tail.z = Mth.lerp(sleepProgress, 14, 15);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0.2618F, 0.3376F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, -0.2784F);
				this.Tail.zRot = Mth.lerp(sleepProgress, 0, 0.2247F);
				//4.0F, 10.5F, 0.4363F, 0.0F, 0.0F
				this.LeftThigh.y = Mth.lerp(sleepProgress, 4, 2);
				this.LeftThigh.z = Mth.lerp(sleepProgress, 10.5F, 11.5F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0.4363F, 0.4476F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.4248F);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0, 0.0058F);
				//0
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -1.4835F);
				//0
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.7453F);
				//4.0F, 10.5F, 0.4363F, 0.0F, 0.0F
				this.RightThigh.y = Mth.lerp(sleepProgress, 4, 2);
				this.RightThigh.z = Mth.lerp(sleepProgress, 10.5F, 11.5F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0.4363F, 0.4695F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.3893F);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, 0, -0.101F);
				//0
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -1.4399F);
				//0
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.6581F);
				//0.5236F, 0.0F, 0.0F
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.5236F, 1.017F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, 0.1558F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 0.027F);
				//0.5236F, 0, 0
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.5236F, 1.0925F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.0552F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.1587F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				//5.9F, -9.0F, -0.4363F
				this.Body.y = Mth.lerp(sleepProgress, 10.3F, 5.9F);
				this.Body.z = Mth.lerp(sleepProgress, -7.3F, -9);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.6021F, -0.4363F);
				//0.0F, 1.9068F, 0.9246F, 0.6807F, 0.0F, 0.0F
				this.Neck.x = Mth.lerp(sleepProgress, -1.1F, 0);
				this.Neck.y = Mth.lerp(sleepProgress, 3.9F, 1.9068F);
				this.Neck.z = Mth.lerp(sleepProgress, -0.9F, 0.9246F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 1.8949F, 0.6807F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0.6996F, 0);
				this.Neck.zRot = Mth.lerp(sleepProgress, -0.1218F, 0);
				//-5.51F, -2.0F, -0.1571F
				this.Head.y = Mth.lerp(sleepProgress, -4.21F, -5.51F);
				this.Head.z = Mth.lerp(sleepProgress, 0.3F, -2);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.1134F, -0.1571F);
				//1.49F, 14.0F, 0.2618F, 0.0F, 0.0F
				this.Tail.y = Mth.lerp(sleepProgress, 0.79F, 1.49F);
				this.Tail.z = Mth.lerp(sleepProgress, 15, 14);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0.3376F, 0.2618F);
				this.Tail.yRot = Mth.lerp(sleepProgress, -0.2784F, 0);
				this.Tail.zRot = Mth.lerp(sleepProgress, 0.2247F, 0);
				//4.0F, 10.5F, 0.4363F, 0.0F, 0.0F
				this.LeftThigh.y = Mth.lerp(sleepProgress, 2, 4);
				this.LeftThigh.z = Mth.lerp(sleepProgress, 11.5F, 10.5F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0.4476F, 0.4363F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.4248F, 0);
				this.LeftThigh.zRot = Mth.lerp(sleepProgress, 0.0058F, 0);
				//0
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -1.4835F, 0);
				//0
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.7453F, 0);
				//4.0F, 10.5F, 0.4363F, 0.0F, 0.0F
				this.RightThigh.y = Mth.lerp(sleepProgress, 2, 4);
				this.RightThigh.z = Mth.lerp(sleepProgress, 11.5F, 10.5F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0.4695F, 0.4363F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.3893F, 0);
				this.RightThigh.zRot = Mth.lerp(sleepProgress, -0.101F, 0);
				//0
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -1.4399F, 0);
				//0
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.6581F, 0);
				//0.5236F, 0.0F, 0.0F
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 1.017F, 0.5236F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0.1558F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0.027F, 0);
				//0.5236F, 0, 0
				this.RightArm.xRot = Mth.lerp(sleepProgress, 1.0925F, 0.5236F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.0552F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.1587F, 0);
			} else {
				this.LeftThigh.xRot = (Mth.sin(limbSwing * 0.5F) * 0.48F * limbSwingAmount) - Mth.abs(Mth.sin(0.15F * limbSwing) * 0.15F * limbSwingAmount) + 0.4363F;
				this.LeftLeg.xRot = Mth.sin(limbSwing * 0.5F) * 0.5F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.abs(Mth.sin(limbSwing * 0.5F) * 0.75F * limbSwingAmount);
				this.RightThigh.xRot = (Mth.sin(limbSwing * 0.5F) * -0.48F * limbSwingAmount) - Mth.abs(Mth.sin(0.15F * limbSwing) * 0.15F * limbSwingAmount) + 0.4363F;
				this.RightLeg.xRot = Mth.sin(limbSwing * 0.5F) * -0.75F * limbSwingAmount;
				this.RightFoot.xRot = Mth.abs(Mth.sin(limbSwing * 0.5F) * -0.75F * limbSwingAmount);
				this.Body.y = (Mth.sin(0.75F * limbSwing) * 0.45F * limbSwingAmount) + (Mth.sin(0.25F * ageInTicks / 3) * 0.15F) + 5.9F;
				this.Body.xRot = Mth.abs(Mth.sin(0.15F * limbSwing) * 0.15F * limbSwingAmount) - 0.4363F;
				this.RightThigh.y = -((Mth.sin(0.75F * limbSwing) * 0.45F * limbSwingAmount) + (Mth.sin(0.25F * ageInTicks / 3) * 0.15F)) + 4F;
				this.LeftThigh.y = -((Mth.sin(0.75F * limbSwing) * 0.45F * limbSwingAmount) + (Mth.sin(0.25F * ageInTicks / 3) * 0.15F)) + 4F;
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
				if (entity.isInWater()) {
//					this.RightThigh.y = 20;
//					this.LeftThigh.y = 20;
					this.Body.y = 16;
					this.Body.xRot = -0.25F;
					this.Tail.xRot = 0.125F;
					this.Neck.xRot = 0.5F;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftArm.xRot = 0.25F;
					this.RightArm.xRot = 0.25F;
					this.RightArm.zRot = -1.5F + Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.LeftArm.zRot = 1.5F - Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void sleepPose() {
		//5.9F, -9.0F, -0.4363F
		this.Body.y = 10.3F;
		this.Body.z = -7.3F;
		this.Body.xRot = -0.6021F;
		//0.0F, 1.9068F, 0.9246F, 0.6807F, 0.0F, 0.0F
		this.Neck.x = -1.1F;
		this.Neck.y = 3.9F;
		this.Neck.z = -0.9F;
		this.Neck.xRot = 1.8949F;
		this.Neck.yRot = 0.6996F;
		this.Neck.zRot = -0.1218F;
		//-5.51F, -2.0F, -0.1571F
		this.Head.y = -4.21F;
		this.Head.z = 0.3F;
		this.Head.xRot = -0.1134F;
		//1.49F, 14.0F, 0.2618F, 0.0F, 0.0F
		this.Tail.y = 0.79F;
		this.Tail.z = 15;
		this.Tail.xRot = 0.3376F;
		this.Tail.yRot = -0.2784F;
		this.Tail.zRot = 0.2247F;
		//4.0F, 10.5F, 0.4363F, 0.0F, 0.0F
		this.LeftThigh.y = 2;
		this.LeftThigh.z = 11.5F;
		this.LeftThigh.xRot = 0.4476F;
		this.LeftThigh.yRot = 0.4248F;
		this.LeftThigh.zRot = 0.0058F;
		//0
		this.LeftLeg.xRot = -1.4835F;
		//0
		this.LeftFoot.xRot = 1.7453F;
		//4.0F, 10.5F, 0.4363F, 0.0F, 0.0F
		this.RightThigh.y = 2;
		this.RightThigh.z = 11.5F;
		this.RightThigh.xRot = 0.4695F;
		this.RightThigh.yRot = -0.3893F;
		this.RightThigh.zRot = -0.101F;
		//0
		this.RightLeg.xRot = -1.4399F;
		//0
		this.RightFoot.xRot = 1.6581F;
		//0.5236F, 0.0F, 0.0F
		this.LeftArm.xRot = 1.017F;
		this.LeftArm.yRot = 0.1558F;
		this.LeftArm.zRot = 0.027F;
		//0.5236F, 0, 0
		this.RightArm.xRot = 1.0925F;
		this.RightArm.yRot = 0.0552F;
		this.RightArm.zRot = -0.1587F;
	}

	public void resetModel() {
		this.Body.y = 5.9F;
		this.Body.z = -9F;
		this.Body.xRot = -0.4363F;
		this.Neck.x = 0F;
		this.Neck.y = 1.9068F;
		this.Neck.z = 0.9246F;
		this.Neck.xRot = 0.6807F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Head.y = -5.51F;
		this.Head.z = -2F;
		this.Head.xRot = -0.1571F;
		this.Tail.y = 1.49F;
		this.Tail.z = 14;
		this.Tail.xRot = 0.2618F;
		this.Tail.yRot = 0F;
		this.Tail.zRot = 0F;
		this.LeftThigh.y = 4;
		this.LeftThigh.z = 10.5F;
		this.LeftThigh.xRot = 0.4363F;
		this.LeftThigh.yRot = 0F;
		this.LeftThigh.zRot = 0F;
		this.LeftLeg.xRot = 0;
		this.LeftFoot.xRot = 0;
		this.RightThigh.y = 4;
		this.RightThigh.z = 10.5F;
		this.RightThigh.xRot = 0.4363F;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightFoot.xRot = 0;
		this.LeftArm.xRot = 0.5236F;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.RightArm.xRot = 0.5236F;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}