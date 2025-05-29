package superlord.prehistoricfauna.client.model.jurassic.shaximiao;

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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Gigantspinosaurus;

@SuppressWarnings("unused")
public class GigantspinosaurusModel extends EntityModel<Gigantspinosaurus> {
	private final ModelPart root;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart ShoulderSpikeRight;
	private final ModelPart ShoulderSpikeLeft;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;

	public GigantspinosaurusModel(ModelPart root) {
		this.root = root.getChild("root");
		this.Body = this.root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.ShoulderSpikeRight = this.Body.getChild("ShoulderSpikeRight");
		this.ShoulderSpikeLeft = this.Body.getChild("ShoulderSpikeLeft");
		this.RightThigh = this.root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftThigh = this.root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightArm = this.root.getChild("RightArm");
		this.LeftArm = this.root.getChild("LeftArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.25F, 9.0F));

		PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 33).addBox(-5.0F, -7.0F, -15.0F, 10.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-7.0F, -8.0F, -3.0F, 14.0F, 16.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -19.0F, -6.0F));

		PartDefinition Box_r1 = Body.addOrReplaceChild("Box_r1", CubeListBuilder.create().texOffs(90, 38).mirror().addBox(0.0F, -4.0F, -7.0F, 0.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -7.0F, -8.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition Box_r2 = Body.addOrReplaceChild("Box_r2", CubeListBuilder.create().texOffs(0, 60).mirror().addBox(0.0F, -5.0F, -9.0F, 0.0F, 5.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -8.0F, 6.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition Box_r3 = Body.addOrReplaceChild("Box_r3", CubeListBuilder.create().texOffs(0, 60).addBox(0.0F, -5.0F, -9.0F, 0.0F, 5.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -8.0F, 6.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition Box_r4 = Body.addOrReplaceChild("Box_r4", CubeListBuilder.create().texOffs(90, 38).addBox(0.0F, -4.0F, -7.0F, 0.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -7.0F, -8.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(96, 0).addBox(-2.0F, -2.0F, -8.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -15.0F));

		PartDefinition Box_r5 = Neck.addOrReplaceChild("Box_r5", CubeListBuilder.create().texOffs(80, 112).mirror().addBox(0.0F, -3.0F, -9.0F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -2.0F, 1.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition Box_r6 = Neck.addOrReplaceChild("Box_r6", CubeListBuilder.create().texOffs(80, 112).addBox(0.0F, -3.0F, -9.0F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.0F, 1.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(112, 91).addBox(-1.0F, -2.0F, -7.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(112, 84).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, -8.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(44, 33).addBox(-4.0F, -3.0F, 0.0F, 8.0F, 7.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.975F, 12.0F));

		PartDefinition Box_r7 = Tail1.addOrReplaceChild("Box_r7", CubeListBuilder.create().texOffs(0, 82).mirror().addBox(0.0F, -5.0F, -9.0F, 0.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -3.025F, 11.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition Box_r8 = Tail1.addOrReplaceChild("Box_r8", CubeListBuilder.create().texOffs(0, 82).addBox(0.0F, -5.0F, -9.0F, 0.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.025F, 11.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(44, 55).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.975F, 13.0F));

		PartDefinition Box_r9 = Tail2.addOrReplaceChild("Box_r9", CubeListBuilder.create().texOffs(64, 102).mirror().addBox(0.0F, -3.0F, -9.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -2.05F, 11.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition Box_r10 = Tail2.addOrReplaceChild("Box_r10", CubeListBuilder.create().texOffs(64, 102).addBox(0.0F, -3.0F, -9.0F, 0.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.05F, 11.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition cube_r1 = Tail2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(36, 102).mirror().addBox(0.0F, -7.0F, -4.0F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5009F, -1.9996F, 15.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r2 = Tail2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(36, 102).addBox(0.0F, -7.0F, -4.0F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5009F, -1.9996F, 15.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition ShoulderSpikeRight = Body.addOrReplaceChild("ShoulderSpikeRight", CubeListBuilder.create().texOffs(112, 47).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(133, 51).addBox(-3.0F, 8.0F, 7.0F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.25F, -0.75F, -13.0F, 0.3648F, 0.524F, -0.925F));

		PartDefinition ShoulderSpikeLeft = Body.addOrReplaceChild("ShoulderSpikeLeft", CubeListBuilder.create().texOffs(112, 47).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(133, 51).mirror().addBox(0.0F, 8.0F, 7.0F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.25F, -0.75F, -13.0F, 0.3648F, -0.524F, 0.925F));

		PartDefinition RightThigh = root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(34, 77).addBox(-2.0F, -4.0F, -4.0F, 5.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -21.0F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 100).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 11.0F, 2.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(62, 22).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.1F));

		PartDefinition LeftThigh = root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(34, 77).mirror().addBox(-3.0F, -4.0F, -4.0F, 5.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-7.0F, -21.0F, 0.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 100).mirror().addBox(-2.0F, 0.0F, -3.0F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 11.0F, 2.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(62, 22).mirror().addBox(-2.5F, 0.0F, -5.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.0F, 0.1F));

		PartDefinition RightArm = root.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(94, 73).addBox(-2.0F, -1.0F, -2.5F, 4.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -14.0F, -16.5F));

		PartDefinition LeftArm = root.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(94, 73).mirror().addBox(-2.0F, -1.0F, -2.5F, 4.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -14.0F, -16.5F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(Gigantspinosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick) * 2.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, -19, -9);
				this.RightThigh.y = Mth.lerp(sleepProgress, -21, -10.5F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -21, -10.5F);
				this.LeftFoot.z = Mth.lerp(sleepProgress, 0.1F, -1F);
				this.RightFoot.z = Mth.lerp(sleepProgress, 0.1F, -1F);
				this.Tail1.z = Mth.lerp(sleepProgress, 12, 11.5F);
				this.Tail2.y = Mth.lerp(sleepProgress, -0.975F, 0);
				this.Tail2.z = Mth.lerp(sleepProgress, 13, 14);
				this.LeftArm.y = Mth.lerp(sleepProgress, -14, -4);
				this.RightArm.y = Mth.lerp(sleepProgress, -14, -4);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.45235987755982988F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -0.3490658503988659F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.7330382858376184F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.5585053606381855F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.7330382858376184F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.5585053606381855F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, -0.174188368183839F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.4330382858376184F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.4575712110370513F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.8377580409572781F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.4962634015954636F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.13962634015954636F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.13962634015954636F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.8377580409572781F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, 0, -0.6585053606381855F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.41887902047863906F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0, 0.41887902047863906F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.593411945678072F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 0.10471975511965977F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, -9, -19);
				this.RightThigh.y = Mth.lerp(sleepProgress, -10.5F, -21);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -10.5F, -21F);
				this.LeftFoot.z = Mth.lerp(sleepProgress, -1F, 0.1F);
				this.RightFoot.z = Mth.lerp(sleepProgress, -1, 0.1F);
				this.Tail1.z = Mth.lerp(sleepProgress, 11.5F, 12);
				this.Tail2.y = Mth.lerp(sleepProgress, 0, -0.975F);
				this.Tail2.z = Mth.lerp(sleepProgress, 14, 13);
				this.LeftArm.y = Mth.lerp(sleepProgress, -4, -14);
				this.RightArm.y = Mth.lerp(sleepProgress, -4, -14);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.45235987755982988F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -0.3490658503988659F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.7330382858376184F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.5585053606381855F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.7330382858376184F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.5585053606381855F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, -0.174188368183839F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.4330382858376184F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.4575712110370513F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.8377580409572781F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.4962634015954636F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.13962634015954636F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.13962634015954636F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.8377580409572781F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.6585053606381855F, 0);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.41887902047863906F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.41887902047863906F, 0);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.593411945678072F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0.10471975511965977F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
			} else {
				this.RightArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.RightFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount) + attackProgress * leftOrRight * (float) Math.toRadians(30F);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount) + attackProgress * leftOrRight * (float) Math.toRadians(30F);
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * -0.15F * limbSwingAmount - 0.15F);
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.3F * limbSwingAmount);
				this.Tail2.zRot = attackProgress * leftOrRight * (float)Math.toRadians(30F);
				this.Body.xRot = -0.0125F * Mth.sin(0.1F * ageInTicks / 3);
				this.Neck.xRot = (-0.0125F * Mth.sin(0.1F * ageInTicks / 3)) + (headPitch * ((float) Math.PI / 180F));
				this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
					this.Body.xRot = 0.2F;
					this.LeftArm.zRot = -0.2F;
					this.RightArm.zRot = 0.2F;
				}
				if (entity.isInWater()) {
					this.LeftThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.RightFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.RightArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = -0.125F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 0.26662F) * 0.7F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 0.26662F) * 0.7F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Body.y = -5;
					this.LeftThigh.y = -7;
					this.RightThigh.y = -7;
					this.RightArm.y = 0;
					this.LeftArm.y = 0;
				}
			}
		}
	}
	
	public void resetModel() {
		this.Body.y = -19F;
		this.RightThigh.z = 0F;
		this.LeftThigh.z = 0F;
		this.LeftThigh.y = -21F;
		this.RightThigh.y = -21F;
		this.LeftFoot.z = 0.1F;
		this.RightFoot.z = 0.1F;
		this.Tail1.z = 12F;
		this.Tail2.y = -0.975F;
		this.Tail2.z = 13;
		this.LeftArm.y = -14;
		this.RightArm.y = -14;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.Head.xRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.RightLeg.xRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftFoot.xRot = 0;
		this.RightFoot.xRot = 0;
	}
	
	public void sleepPose() {
		this.Body.y = -9;
		this.RightThigh.y = -10.5F;
		this.LeftThigh.y = -10.5F;
		this.LeftFoot.z = -1F;
		this.RightFoot.z = -1F;
		this.Tail1.z = 11.5F;
		this.Tail2.y = 0;
		this.Tail2.z = 14;
		this.LeftArm.y = -4;
		this.RightArm.y = -4;
		this.Neck.xRot = 0.45235987755982988F;
		this.Neck.yRot = -0.3490658503988659F;
		this.LeftThigh.xRot = -0.7330382858376184F;
		this.LeftThigh.yRot = 0.5585053606381855F;
		this.RightThigh.xRot = -0.7330382858376184F;
		this.RightThigh.yRot = -0.5585053606381855F;
		this.Head.xRot = -0.174188368183839F;
		this.LeftArm.xRot = -1.4330382858376184F;
		this.LeftArm.zRot = -0.4575712110370513F;
		this.LeftLeg.xRot = -0.8377580409572781F;
		this.RightArm.xRot = -1.4962634015954636F;
		this.RightArm.yRot = 0.13962634015954636F;
		this.RightArm.zRot = -0.13962634015954636F;
		this.RightLeg.xRot = -0.8377580409572781F;
		this.Tail1.xRot = -0.6585053606381855F;
		this.Tail1.yRot = 0.41887902047863906F;
		this.Tail2.xRot = 0.41887902047863906F;
		this.Tail2.yRot = 0.593411945678072F;
		this.Tail2.zRot = 0.10471975511965977F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.RightFoot.xRot = 1.5707963267948966F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}