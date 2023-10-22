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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Stegosaurus;

public class StegosaurusModel extends EntityModel<Stegosaurus> {
	private final ModelPart RightArm;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart LeftArm;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;

	public StegosaurusModel(ModelPart root) {
		this.RightArm = root.getChild("RightArm");
		this.RightThigh = root.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
		this.LeftThigh = root.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
		this.LeftArm = root.getChild("LeftArm");
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-2.0F, -4.0F, -4.0F, 7.0F, 27.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, 1.0F, -14.0F));

		PartDefinition RightThigh = partdefinition.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 71).mirror().addBox(-3.0F, -3.0F, -7.0F, 9.0F, 21.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, -8.0F, 13.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 107).mirror().addBox(-3.0F, -1.0F, -4.0F, 6.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, 17.0F, 2.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(0, 130).mirror().addBox(-3.5F, 0.0F, -6.0F, 7.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 12.0F, 0.1F));

		PartDefinition LeftThigh = partdefinition.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 71).addBox(-7.0F, -3.0F, -7.0F, 9.0F, 21.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -8.0F, 13.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 107).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 17.0F, 2.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(0, 130).addBox(-3.5F, 0.0F, -6.0F, 7.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.1F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 7.0F, 27.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, 1.0F, -14.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, 0.0F, 0.0F, 24.0F, 26.0F, 45.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.0F, -21.0F));

		PartDefinition LeftBackPlates = Body.addOrReplaceChild("LeftBackPlates", CubeListBuilder.create().texOffs(153, 24).mirror().addBox(0.0F, -21.0F, -1.0F, 0.0F, 22.0F, 46.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, 4.0F, 0.0F, 0.0F, -0.1396F));

		PartDefinition InsideLeftBackPlates = LeftBackPlates.addOrReplaceChild("InsideLeftBackPlates", CubeListBuilder.create().texOffs(153, 47).mirror().addBox(0.0F, -21.0F, -1.0F, 0.0F, 22.0F, 46.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.1F, 0.0F, 0.0F));

		PartDefinition RightBackPlates = Body.addOrReplaceChild("RightBackPlates", CubeListBuilder.create().texOffs(153, 74).addBox(0.0F, -21.0F, 0.0F, 0.0F, 21.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1396F));

		PartDefinition InsideRightBackPlates = RightBackPlates.addOrReplaceChild("InsideRightBackPlates", CubeListBuilder.create().texOffs(153, 96).addBox(0.0F, -21.0F, 0.0F, 0.0F, 21.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1F, 0.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(83, 73).addBox(-3.5F, -5.0F, -23.0F, 7.0F, 10.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(94, 2).addBox(-3.5F, -3.5F, -5.0F, 7.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -23.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(96, 16).addBox(-2.0F, -3.0F, -6.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -5.0F));

		PartDefinition RightNeckPlates = Neck.addOrReplaceChild("RightNeckPlates", CubeListBuilder.create().texOffs(137, -18).addBox(0.0F, -11.0F, -18.0F, 0.0F, 11.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.0F, -3.0F, 0.0F, 0.0F, 0.0698F));

		PartDefinition InsideRightNeckPlates = RightNeckPlates.addOrReplaceChild("InsideRightNeckPlates", CubeListBuilder.create().texOffs(137, -6).addBox(0.0F, -11.0F, -18.0F, 0.0F, 11.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1F, 0.0F, 0.0F));

		PartDefinition LeftNeckPlates = Neck.addOrReplaceChild("LeftNeckPlates", CubeListBuilder.create().texOffs(40, 120).mirror().addBox(0.0F, -10.0F, 0.0F, 0.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -5.0F, -18.0F, 0.0F, 0.0F, -0.0698F));

		PartDefinition InsideLeftNeckPlates = LeftNeckPlates.addOrReplaceChild("InsideLeftNeckPlates", CubeListBuilder.create().texOffs(40, 131).mirror().addBox(0.0F, -10.0F, 0.0F, 0.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.1F, 0.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(28, 73).addBox(-5.0F, -6.0F, 0.0F, 10.0F, 12.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.5F, 44.0F, -0.0698F, 0.0F, 0.0F));

		PartDefinition LeftTail1Plates = Tail1.addOrReplaceChild("LeftTail1Plates", CubeListBuilder.create().texOffs(172, 4).mirror().addBox(0.0F, -20.0F, 0.0F, 0.0F, 20.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -6.0F, 9.0F, 0.0F, 0.0F, -0.1396F));

		PartDefinition InsideLeftTail1Plates = LeftTail1Plates.addOrReplaceChild("InsideLeftTail1Plates", CubeListBuilder.create().texOffs(172, 25).mirror().addBox(0.0F, -20.0F, 0.0F, 0.0F, 20.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.1F, 0.0F, 0.0F));

		PartDefinition RightTail1Plates = Tail1.addOrReplaceChild("RightTail1Plates", CubeListBuilder.create().texOffs(88, 87).addBox(0.0F, -19.0F, -5.0F, 0.0F, 19.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -6.0F, 1.0F, 0.0F, 0.0F, 0.1396F));

		PartDefinition InsideRightTail1Plates = RightTail1Plates.addOrReplaceChild("InsideRightTail1Plates", CubeListBuilder.create().texOffs(85, 107).addBox(0.0F, -19.0F, 0.0F, 0.0F, 19.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(94, 7).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 7.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 33.0F, -0.0698F, 0.0F, 0.0F));

		PartDefinition RightTail2Plates = Tail2.addOrReplaceChild("RightTail2Plates", CubeListBuilder.create().texOffs(174, -25).addBox(0.0F, -13.0F, 0.0F, 0.0F, 13.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0698F));

		PartDefinition InsideRightTail2Plates = RightTail2Plates.addOrReplaceChild("InsideRightTail2Plates", CubeListBuilder.create().texOffs(174, -11).addBox(0.0F, -13.0F, 0.0F, 0.0F, 13.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1F, 0.0F, 0.0F));

		PartDefinition LeftTail2Plates = Tail2.addOrReplaceChild("LeftTail2Plates", CubeListBuilder.create().texOffs(139, 29).mirror().addBox(0.0F, -9.0F, 0.0F, 0.0F, 9.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -3.0F, 5.0F, 0.0F, 0.0F, -0.0698F));

		PartDefinition InsideLeftTail2Plates = LeftTail2Plates.addOrReplaceChild("InsideLeftTail2Plates", CubeListBuilder.create().texOffs(139, 39).mirror().addBox(0.0F, -9.0F, 0.0F, 0.0F, 9.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.1F, 0.0F, 0.0F));

		PartDefinition RightThagomizers = Tail2.addOrReplaceChild("RightThagomizers", CubeListBuilder.create().texOffs(39, 119).addBox(0.0F, 0.0F, 0.0F, 21.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, 20.0F, 0.0F, 0.0F, -0.6632F));

		PartDefinition LeftThagomizers = Tail2.addOrReplaceChild("LeftThagomizers", CubeListBuilder.create().texOffs(39, 119).mirror().addBox(-21.0F, 0.0F, 0.0F, 21.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -2.0F, 20.0F, 0.0F, 0.0F, 0.6632F));

		return LayerDefinition.create(meshdefinition, 256, 160);
	}

	@Override
	public void setupAnim(Stegosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		if (entity.getWakingTicks() >= 31 && entity.getFallingAsleepTicks() >= 31) {
			if (entity.isAsleep()) {
				sleepPose();
			} else {
				resetModel();
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
				this.Body.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
				this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (headPitch * ((float) Math.PI / 180F));
				this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
					this.Body.xRot = 0.2F;
					this.LeftArm.zRot = 0.3F;
					this.RightArm.zRot = -0.3F;
				}
				if (entity.isInWater()) {
					this.Body.y = 3;
					this.Body.xRot = -0.125F;
					this.Tail1.xRot = 0.0625F;
					this.Tail2.xRot = 0.0625F;
					this.RightThigh.y = 19;
					this.LeftThigh.y = 19;
					this.RightArm.y = 23;
					this.LeftArm.y = 23;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = 0.125F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Neck
			//this.Neck.x = 0;
			//this.Neck.y = 10;
			//this.Neck.z = 0;
			if (this.Neck.x > 0) this.Neck.x -= 0.15;
			if (this.Neck.y > 10) this.Neck.y -= 0.15;
			if (this.Neck.z > 0) this.Neck.z -= 0.15;
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot < 0) this.Neck.yRot += 0.05;
			//LeftFoot 
			if (this.LeftFoot.xRot > 0) this.LeftFoot.xRot -= 0.05;
			if (this.LeftFoot.yRot > 0) this.LeftFoot.yRot -= 0.05;
			if (this.LeftFoot.zRot < 0) this.LeftFoot.zRot += 0.05;
			//LeftThigh
			//this.LeftThigh.x = -8;
			//this.LeftThigh.y = -8;
			//this.LeftThigh.z = 15;
			if (this.LeftThigh.x > -8) this.LeftThigh.x -= 0.15;
			if (this.LeftThigh.y > -8) this.LeftThigh.y -= 0.15;
			if (this.LeftThigh.z < 15) this.LeftThigh.z += 0.15;
			if (this.LeftThigh.xRot < 0) this.LeftThigh.xRot += 0.05;
			if (this.LeftThigh.yRot < 0) this.LeftThigh.yRot += 0.05;
			if (this.LeftThigh.zRot > 0) this.LeftThigh.zRot -= 0.05;
			//RightArm
			//this.RightArm.y = 1.0F;
			if (this.RightArm.y > 1) this.RightArm.y -= 0.15;
			if (this.RightArm.xRot < 0) this.RightArm.xRot += 0.05;
			if (this.RightArm.yRot < 0) this.RightArm.yRot += 0.05;
			if (this.RightArm.zRot > 0) this.RightArm.zRot -= 0.05;
			//RightLeg
			if (this.RightLeg.xRot > 0) this.RightLeg.xRot -= 0.05;
			if (this.RightLeg.zRot > 0) this.RightLeg.zRot -= 0.05;
			//Tail1
			//this.Tail1.y = 7.0F;
			//this.Tail1.z = 44;
			if (this.Tail1.y > 7) this.Tail1.y -= 0.15;
			if (this.Tail1.z < 44) this.Tail1.z += 0.15;
			if (this.Tail1.xRot < 0) this.Tail1.xRot += 0.05;
			if (this.Tail1.yRot > 0) this.Tail1.yRot -= 0.05;
			if (this.Tail1.zRot < 0) this.Tail1.zRot += 0.05;
			//Body
			//this.Body.x = 0;
			//this.Body.y = -18;
			if (this.Body.x > 0) this.Body.x -= 0.15;
			if (this.Body.y > -18) this.Body.y -= 0.15;
			if (this.Body.xRot < 0) this.Body.xRot += 0.05;
			if (this.Body.yRot < 0) this.Body.yRot += 0.05;
			if (this.Body.zRot > 0) this.Body.zRot -= 0.05;
			//RightThigh
			//this.RightThigh.y = -8.0F;
			if (this.RightThigh.y > -8) this.RightThigh.y -= 0.15;
			if (this.RightThigh.xRot > 0) this.RightThigh.xRot -= 0.05;
			if (this.RightThigh.zRot > 0) this.RightThigh.zRot -= 0.05;
			//Head
			if (this.Head.xRot < 0) this.Head.xRot += 0.05;
			//Tail2
			if (this.Tail2.xRot < 0) this.Tail2.xRot += 0.05;
			if (this.Tail2.yRot < 0) this.Tail2.yRot += 0.05;
			if (this.Tail2.zRot < 0) this.Tail2.zRot += 0.05;
			//LeftArm
			//this.LeftArm.y = 1.0F;
			if (this.LeftArm.y > 1) this.LeftArm.y -= 0.15;
			if (this.LeftArm.xRot > 0) this.LeftArm.xRot -= 0.05;
			if (this.LeftArm.yRot < 0) this.LeftArm.yRot += 0.05;
			if (this.LeftArm.zRot > 0) this.LeftArm.zRot -= 0.05;
		}
		if (entity.getFallingAsleepTicks() < 31) {
			//Neck
			//this.Neck.x = 0;
			//this.Neck.y = 10;
			//this.Neck.z = 0;
			if (this.Neck.x < 3) this.Neck.x += 0.15;
			if (this.Neck.y < 11) this.Neck.y += 0.15;
			if (this.Neck.z < 2) this.Neck.z += 0.15;
			if (this.Neck.xRot < 0.8025023820775095F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot > -0.03665191262740524F) this.Neck.yRot -= 0.05;
			//LeftFoot 
			if (this.LeftFoot.xRot < 0.18256144042439712F) this.LeftFoot.xRot += 0.05;
			if (this.LeftFoot.yRot < 0.18256144042439712F) this.LeftFoot.yRot += 0.05;
			if (this.LeftFoot.zRot > -0.036477379868653376F) this.LeftFoot.zRot -= 0.05;
			//LeftThigh
			//this.LeftThigh.x = -8;
			//this.LeftThigh.y = -8;
			//this.LeftThigh.z = 15;
			if (this.LeftThigh.x < -6) this.LeftThigh.x += 0.15;
			if (this.LeftThigh.y < 1) this.LeftThigh.y += 0.15;
			if (this.LeftThigh.z > 14) this.LeftThigh.z -= 0.15;
			if (this.LeftThigh.xRot > -0.14608405639455457F) this.LeftThigh.xRot -= 0.05;
			if (this.LeftThigh.yRot > -0.14625859331449564F) this.LeftThigh.yRot -= 0.05;
			if (this.LeftThigh.zRot < 0.6932448001974364F) this.LeftThigh.zRot += 0.05;
			//RightArm
			//this.RightArm.y = 1.0F;
			if (this.RightArm.y < 21.2) this.RightArm.y += 0.15;
			if (this.RightArm.xRot > -0.21868975061435758F) this.RightArm.xRot -= 0.05;
			if (this.RightArm.yRot > -0.036477379868653376F) this.RightArm.yRot -= 0.05;
			if (this.RightArm.zRot < 1.460491523395177F) this.RightArm.zRot += 0.05;
			//RightLeg
			if (this.RightLeg.xRot < 0.1459095194746135F) this.RightLeg.xRot += 0.05;
			if (this.RightLeg.zRot < 0.07278023113974408F) this.RightLeg.zRot += 0.05;
			//Tail1
			//this.Tail1.y = 7.0F;
			//this.Tail1.z = 44;
			if (this.Tail1.y < 8) this.Tail1.y += 0.15;
			if (this.Tail1.z > 43) this.Tail1.z -= 0.15;
			if (this.Tail1.xRot > -0.4782202083885436F) this.Tail1.xRot -= 0.05;
			if (this.Tail1.yRot < 0.18238690350445608F) this.Tail1.yRot += 0.05;
			if (this.Tail1.zRot > -0.2553416715641412F) this.Tail1.zRot -= 0.05;
			//Body
			//this.Body.x = 0;
			//this.Body.y = -18;
			if (this.Body.x < 17) this.Body.x += 0.15;
			if (this.Body.y < 6.6) this.Body.y += 0.15;
			if (this.Body.xRot > -0.03665191262740524F) this.Body.xRot -= 0.05;
			if (this.Body.yRot > -0.07312929665724782F) this.Body.yRot -= 0.05;
			if (this.Body.zRot < 1.2407545013269026F) this.Body.zRot += 0.05;
			//RightThigh
			//this.RightThigh.y = -8.0F;
			if (this.RightThigh.y < 17.7) this.RightThigh.y += 0.15;
			if (this.RightThigh.xRot < 0.4742059590984399F) this.RightThigh.xRot += 0.05;
			if (this.RightThigh.zRot < 1.4606660936046318F) this.RightThigh.zRot += 0.05;
			//Head
			if (this.Head.xRot > -0.036477379868653376F) this.Head.xRot -= 0.05;
			//Tail2
			if (this.Tail2.xRot > -0.10943214376714933F) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot > -0.4010766541188137F) this.Tail2.yRot -= 0.05;
			if (this.Tail2.zRot > -0.3282964229790696F) this.Tail2.zRot -= 0.05;
			//LeftArm
			//this.LeftArm.y = 1.0F;
			if (this.LeftArm.y < 5) this.LeftArm.y += 0.15;
			if (this.LeftArm.xRot < 0.3282964229790696F) this.LeftArm.xRot += 0.05;
			if (this.LeftArm.yRot > -1.7453292129831807E-4F) this.LeftArm.yRot -= 0.05;
			if (this.LeftArm.zRot < 0.36477380700891215F) this.LeftArm.zRot += 0.05;
		}
	}

	public void resetModel() {
		this.Neck.x = 0;
		this.Neck.y = 10;
		this.Neck.z = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.LeftFoot.xRot = 0;
		this.LeftFoot.yRot = 0;
		this.LeftFoot.zRot = 0;
		this.LeftThigh.x = -8;
		this.LeftThigh.y = -8;
		this.LeftThigh.z = 15;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftThigh.zRot = 0;
		this.RightArm.y = 1.0F;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.zRot = 0;
		this.Tail1.y = 7.0F;
		this.Tail1.z = 44;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail1.zRot = 0;
		this.Body.x = 0;
		this.Body.y = -18;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Body.zRot = 0;
		this.RightThigh.y = -8.0F;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightThigh.zRot = 0;
		this.Head.xRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftArm.y = 1.0F;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
	}

	public void sleepPose() {
		this.Neck.x = 3;
		this.Neck.y = 11;
		this.Neck.z = 2;
		this.Neck.xRot = 0.8025023820775095F;
		this.Neck.yRot = -0.03665191262740524F;
		this.LeftFoot.xRot = 0.18256144042439712F;
		this.LeftFoot.yRot = 0.18256144042439712F;
		this.LeftFoot.zRot = -0.036477379868653376F;
		this.LeftThigh.x = -6;
		this.LeftThigh.y = 1;
		this.LeftThigh.z = 14;
		this.LeftThigh.xRot = -0.14608405639455457F;
		this.LeftThigh.yRot = -0.14625859331449564F;
		this.LeftThigh.zRot = 0.6932448001974364F;
		this.RightArm.y = 21.2F;
		this.RightArm.xRot = -0.21868975061435758F;
		this.RightArm.yRot = -0.036477379868653376F;
		this.RightArm.zRot = 1.460491523395177F;
		this.RightLeg.xRot = 0.1459095194746135F;
		this.RightLeg.zRot = 0.07278023113974408F;
		this.Tail1.y = 8.0F;
		this.Tail1.z = 43;
		this.Tail1.xRot = -0.4782202083885436F;
		this.Tail1.yRot = 0.18238690350445608F;
		this.Tail1.zRot = -0.2553416715641412F;
		this.Body.x = 17;
		this.Body.y = 6.6F;
		this.Body.xRot = -0.03665191262740524F;
		this.Body.yRot = -0.07312929665724782F;
		this.Body.zRot = 1.2407545013269026F;
		this.RightThigh.y = 17.7F;
		this.RightThigh.xRot = 0.4742059590984399F;
		this.RightThigh.zRot = 1.4606660936046318F;
		this.Head.xRot = -0.036477379868653376F;
		this.Tail2.xRot = -0.10943214376714933F;
		this.Tail2.yRot = -0.4010766541188137F;
		this.Tail2.zRot = -0.3282964229790696F;
		this.LeftArm.y = 5.0F;
		this.LeftArm.xRot = 0.3282964229790696F;
		this.LeftArm.yRot = -1.7453292129831807E-4F;
		this.LeftArm.zRot = 0.36477380700891215F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}