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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Yutyrannus;

public class YutyrannusModel extends EntityModel<Yutyrannus> {
	private final ModelPart LeftLeg1;
	private final ModelPart LeftLeg2;
	private final ModelPart LeftFoot;
	private final ModelPart RightLeg1;
	private final ModelPart RightLeg2;
	private final ModelPart RightFoot;
	private final ModelPart Back;
	private final ModelPart Chest;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Neck;
	private final ModelPart Head1;
	private final ModelPart Jaw1;

	public YutyrannusModel(ModelPart root) {
		this.LeftLeg1 = root.getChild("LeftLeg1");
		this.LeftLeg2 = LeftLeg1.getChild("LeftLeg2");
		this.LeftFoot = LeftLeg2.getChild("LeftFoot");
		this.RightLeg1 = root.getChild("RightLeg1");
		this.RightLeg2 = RightLeg1.getChild("RightLeg2");
		this.RightFoot = RightLeg2.getChild("RightFoot");
		this.Back = root.getChild("Back");
		this.Tail1 = Back.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.Chest = Back.getChild("Chest");
		this.RightArm = Chest.getChild("RightArm");
		this.LeftArm = Chest.getChild("LeftArm");
		this.Neck = Chest.getChild("Neck");
		this.Head1 = Neck.getChild("Head1");
		this.Jaw1 = Head1.getChild("Jaw1");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeftLeg1 = partdefinition.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(0, 110).mirror().addBox(-6.0F, -3.0F, -6.0F, 6.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -5.2F, 3.0F));

		PartDefinition LeftLeg2 = LeftLeg1.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(0, 139).mirror().addBox(-2.5F, 0.0F, -3.0F, 5.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 11.0F, 3.0F));

		PartDefinition LeftFoot = LeftLeg2.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(33, 166).mirror().addBox(-3.0F, 0.0F, -6.0F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 16.0F, -1.0F));

		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(34, 110).addBox(0.0F, -3.0F, -6.0F, 6.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -5.2F, 3.0F));

		PartDefinition RightLeg2 = RightLeg1.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(24, 139).addBox(-2.5F, 0.0F, -3.0F, 5.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 11.0F, 3.0F));

		PartDefinition RightFoot = RightLeg2.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(0, 166).addBox(-3.0F, 0.0F, -6.0F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, -1.0F));

		PartDefinition Back = partdefinition.addOrReplaceChild("Back", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -5.0F, -11.0F, 12.0F, 17.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 3.0F));

		PartDefinition Tail1 = Back.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 74).addBox(-4.0F, -4.0F, -1.0F, 8.0F, 10.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, -0.0349F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(59, 58).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 7.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 19.0F, 0.0349F, 0.0F, 0.0F));

		PartDefinition Tail2Floof = Tail2.addOrReplaceChild("Tail2Floof", CubeListBuilder.create().texOffs(113, 51).addBox(-2.0F, 2.0F, -2.0F, 4.0F, 4.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition Tail1Floof = Tail1.addOrReplaceChild("Tail1Floof", CubeListBuilder.create().texOffs(163, 66).addBox(-4.0F, 0.0F, -1.0F, 8.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition Chest = Back.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -5.0F, -16.0F, 10.0F, 15.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -11.0F));

		PartDefinition RightArm = Chest.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(72, 50).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 6.0F, -10.0F, 0.0698F, 0.0F, 0.0F));

		PartDefinition Neck = Chest.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(65, 12).addBox(-2.5F, -7.0F, -9.0F, 5.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -13.0F, 0.0698F, 0.0F, 0.0F));

		PartDefinition Head1 = Neck.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(94, 0).addBox(-3.0F, -3.9F, -5.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.2F, -6.0F));

		PartDefinition Snout = Head1.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(121, 0).addBox(-2.0F, -3.9F, -10.0F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -5.0F));

		PartDefinition UpperTeeth = Snout.addOrReplaceChild("UpperTeeth", CubeListBuilder.create().texOffs(124, 31).addBox(-1.5F, -1.4F, -9.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -0.5F));

		PartDefinition CrestLeft = Snout.addOrReplaceChild("CrestLeft", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(-0.5F, -1.9F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, -5.0F, -1.0F));

		PartDefinition CrestCenter = Snout.addOrReplaceChild("CrestCenter", CubeListBuilder.create().texOffs(151, 0).addBox(-1.0F, -2.8F, -8.7F, 2.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.8F, 0.0F, 0.1951F, 0.0F, 0.0F));

		PartDefinition CrestRight = Snout.addOrReplaceChild("CrestRight", CubeListBuilder.create().texOffs(50, 0).addBox(-0.5F, -1.9F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -5.0F, -1.0F));

		PartDefinition Jaw1 = Head1.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(94, 14).addBox(-3.0F, 0.1F, -5.0F, 6.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition Jaw2 = Jaw1.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(121, 16).addBox(-2.0F, -0.9F, -10.0F, 4.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -5.0F));

		PartDefinition LowerTeeth = Jaw2.addOrReplaceChild("LowerTeeth", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -0.5F));

		PartDefinition _r1 = LowerTeeth.addOrReplaceChild("_r1", CubeListBuilder.create().texOffs(124, 43).addBox(-1.0F, -2.0F, 0.5F, 2.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9F, -9.0F, -0.1047F, 0.0F, 0.0F));

		PartDefinition goatiee = Jaw2.addOrReplaceChild("goatiee", CubeListBuilder.create().texOffs(3, 4).addBox(-1.5F, 0.1F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -9.6F, 0.1564F, 0.0F, 0.0F));

		PartDefinition Throat = Jaw1.addOrReplaceChild("Throat", CubeListBuilder.create().texOffs(98, 25).addBox(-2.5F, -2.9F, -4.1F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition neckfloof = Neck.addOrReplaceChild("neckfloof", CubeListBuilder.create().texOffs(177, 5).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, -9.0F));

		PartDefinition LeftArm = Chest.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(55, 50).mirror().addBox(-2.0F, -2.0F, -2.0F, 3.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 6.0F, -10.0F, 0.0698F, 0.0F, 0.0F));

		PartDefinition ChestFloof = Chest.addOrReplaceChild("ChestFloof", CubeListBuilder.create().texOffs(165, 47).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 2.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -16.0F));

		return LayerDefinition.create(meshdefinition, 250, 250);
	}

	@Override
	public void setupAnim(Yutyrannus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.8f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			//Chest
			//this.Chest.x = 0;
			//this.Chest.y = -3;
			//this.Chest.z = -16;
			if (this.Chest.x < 4) this.Chest.x += 0.15;
			if (this.Chest.y < -1) this.Chest.y += 0.15;
			if (this.Chest.z > -20) this.Chest.z -= 0.15;
			if (this.Chest.xRot < 0.41887902047863906F) this.Chest.xRot += 0.05;
			if (this.Chest.yRot > -0.5235987755982988F) this.Chest.yRot -= 0.05;
			//Neck
			//this.Neck.y = 6;
			//this.Neck.z = -22;
			//this.Neck.xRot = 0.2275909337942703F;
			if (this.Neck.y < 10) this.Neck.y += 0.15;
			if (this.Neck.z < -20) this.Neck.z += 0.15;
			if (this.Neck.xRot < 0.8203047484373349F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot > -0.3490658503988659F) this.Neck.yRot -= 0.05;
			if (this.Neck.zRot > -0.10471975511965977F) this.Neck.zRot -= 0.05;
			//RightFoot
			if (this.RightFoot.xRot < 1.5707963267948966F) this.RightFoot.xRot += 0.05;
			//RightLeg2
			//this.RightLeg2.y = 26;
			//this.RightLeg2.z = 9;
			if (this.RightLeg2.y > 22) this.RightLeg2.y -= 0.15;
			if (this.RightLeg2.z > 8) this.RightLeg2.z -= 0.15;
			if (this.RightLeg2.xRot > -0.8726646259971648F) this.RightLeg2.xRot -= 0.05;
			//Tail2
			//this.Tail2.x = 0F;
			if (this.Tail2.x < 0.6) this.Tail2.x += 0.15;
			if (this.Tail2.xRot < 0.24434609527920614F) this.Tail2.xRot += 0.05;
			if (this.Tail2.yRot < 0.41887902047863906F) this.Tail2.yRot += 0.05;
			//LeftLeg2
			//this.LeftLeg2.y = 26;
			//this.LeftLeg2.z = 9;
			if (this.LeftLeg2.y > 22) this.LeftLeg2.y -= 0.15;
			if (this.LeftLeg2.z > 8) this.LeftLeg2.z -= 0.15;
			if (this.LeftLeg2.xRot > -0.8726646259971648F) this.LeftLeg2.xRot -= 0.05;
			//LeftLeg1
			//this.LeftLeg1.y = -26;
			//this.LeftLeg1.z = -1;
			if (this.LeftLeg1.y < -5) this.LeftLeg1.y += 0.15;
			if (this.LeftLeg1.z < 3) this.LeftLeg1.z += 0.15;
			if (this.LeftLeg1.xRot > -0.6981317007977318F) this.LeftLeg1.xRot -= 0.05;
			if (this.LeftLeg1.yRot < 0.5235987755982988F) this.LeftLeg1.yRot += 0.05;
			//Back
			//this.Back.y = -29F;
			if (this.Back.y < -1.6) this.Back.y += 0.15;
			if (this.Back.xRot > -0.17453292519943295F) this.Back.xRot -= 0.05;
			//Tail1
			//this.Tail1.x = 0;
			//this.Tail1.z = 17F;
			//this.Tail1.xRot = -0.04555309164612875F;
			if (this.Tail1.x < 3) this.Tail1.x += 0.15;
			if (this.Tail1.z < 19.5) this.Tail1.z += 0.15;
			if (this.Tail1.xRot > -0.24434609527920614F) this.Tail1.xRot -= 0.05;
			if (this.Tail1.yRot < 0.593411945678072F) this.Tail1.yRot += 0.05;
			//Head1
			//this.Head1.x = 0;
			//this.Head1.y = -17.1F;
			//this.Head1.z = -7;
			if (this.Head1.x > -1) this.Head1.x -= 0.15;
			if (this.Head1.y < -15) this.Head1.y += 0.15;
			if (this.Head1.z < -6) this.Head1.z += 0.15;
			if (this.Head1.xRot > -0.9075712110370513F) this.Head1.xRot -= 0.05;
			if (this.Head1.yRot > -0.06981317007977318F) this.Head1.yRot -= 0.05;
			if (this.Head1.zRot < 0.3490658503988659F) this.Head1.zRot += 0.05;
			//LeftArm
			//this.LeftArm.xRot = 0.27314402127920984F;
			if (this.LeftArm.xRot < 1.3264502315156905F) this.LeftArm.xRot += 0.05;
			if (this.LeftArm.yRot > -0.13962634015954636F) this.LeftArm.yRot -= 0.05;
			//RightArm
			//this.RightArm.x = 10.1F;
			//this.RightArm.z = -13;
			//this.RightArm.xRot = 0.27314402127920984F;
			if (this.Head1.x < 11) this.Head1.x += 0.15;
			if (this.Head1.z > -14) this.Head1.z -= 0.15;
			if (this.Head1.xRot < 1.0878637547259988F) this.Head1.xRot += 0.05;
			if (this.Head1.yRot < 0.296705972839036F) this.Head1.yRot += 0.05;
			if (this.Head1.zRot > -0.13962634015954636F) this.Head1.zRot -= 0.05;
			//RightLeg1
			//this.RightLeg1.x = 6;
			//this.RightLeg1.y = -26;
			//this.RightLeg1.z = -1;
			if (this.RightLeg1.x < 7) this.RightLeg1.x -= 0.15;
			if (this.RightLeg1.y < -5) this.RightLeg1.y += 0.15;
			if (this.RightLeg1.z < 2) this.RightLeg1.z += 0.15;
			if (this.RightLeg1.xRot > -0.6981317007977318F) this.RightLeg1.xRot -= 0.05;
			if (this.RightLeg1.yRot > -0.2792526803190927F) this.RightLeg1.yRot -= 0.05;
			//LeftFoot
			if (this.LeftFoot.xRot < 1.5707963267948966F) this.LeftFoot.xRot += 0.05;
			sleepPose();
		} else {
			resetModel();
			this.LeftLeg1.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount - 0.05F;
			this.LeftLeg2.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.05F;
			this.LeftFoot.xRot = Mth.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
			this.RightLeg1.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount - 0.05F;
			this.RightLeg2.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + 0.05F;
			this.RightFoot.xRot = Mth.cos(2.0F + limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
			this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.2F * limbSwingAmount);
			this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Tail2.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.25F * limbSwingAmount);
			this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.15F);
			this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.1F);
			this.Back.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount);
			this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.25F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(70F);
			this.Head1.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.1F)  + attackProgress * (float)Math.toRadians(-80F);
			this.Jaw1.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + attackProgress * (float) Math.toRadians(30F);
			this.LeftArm.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.RightArm.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
			this.RightArm.xRot = Mth.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
			this.Neck.yRot = (netHeadYaw * ((float) Math.PI / 180F));
			this.Chest.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.01F * limbSwingAmount;
			this.Head1.y = -3.2F + attackProgress * -3;
			this.Head1.z = -7F + attackProgress * 5;
			if (entity.attackTick < 0) {
				this.Back.xRot = Math.abs(-0.25F * Mth.sin(0.15F * ageInTicks));
				this.Tail1.xRot = -Math.abs(-0.2F * Mth.sin(0.15F * ageInTicks));
				this.Neck.xRot = Math.abs(-0.25F * Mth.sin(0.15F * ageInTicks));
				this.Jaw1.xRot = Math.abs(-0.45F * Mth.sin(0.15F * ageInTicks));
				this.LeftArm.xRot = Math.abs(-0.35F * Mth.sin(0.15F * ageInTicks));
				this.RightArm.xRot = Math.abs(-0.35F * Mth.sin(0.15F * ageInTicks));
			}
			if (entity.isInWater()) {
				this.LeftLeg1.y = 20;
				this.RightLeg1.y = 20;
				this.Back.y = 20;
				this.Back.xRot = -0.125F;
				this.Tail1.xRot = 0.0625F;
				this.Tail2.xRot = 0.06125F;
				this.Neck.xRot = 0.125F;
				this.LeftLeg1.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg1.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.RightFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.RightArm.xRot = 0.125F;
				this.LeftArm.xRot = 0.125F;
				this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Chest
			//this.Chest.x = 0;
			//this.Chest.y = -3;
			//this.Chest.z = -16;
			if (this.Chest.x > 0) this.Chest.x -= 0.15;
			if (this.Chest.y > -3) this.Chest.y -= 0.15;
			if (this.Chest.z < -16) this.Chest.z += 0.15;
			if (this.Chest.xRot > 0) this.Chest.xRot -= 0.05;
			if (this.Chest.yRot < 0) this.Chest.yRot += 0.05;
			//Neck
			//this.Neck.y = 6;
			//this.Neck.z = -22;
			//this.Neck.xRot = 0.2275909337942703F;
			if (this.Neck.y > 6) this.Neck.y -= 0.15;
			if (this.Neck.z > -22) this.Neck.z -= 0.15;
			if (this.Neck.xRot > 0.2275909337942703F) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot < 0) this.Neck.yRot += 0.05;
			if (this.Neck.zRot < 0) this.Neck.zRot += 0.05;
			//RightFoot
			if (this.RightFoot.xRot > 0) this.RightFoot.xRot -= 0.05;
			//RightLeg2
			//this.RightLeg2.y = 26;
			//this.RightLeg2.z = 9;
			if (this.RightLeg2.y < 26) this.RightLeg2.y += 0.15;
			if (this.RightLeg2.z < 9) this.RightLeg2.z += 0.15;
			if (this.RightLeg2.xRot < 0) this.RightLeg2.xRot += 0.05;
			//Tail2
			//this.Tail2.x = 0F;
			if (this.Tail2.x > 0) this.Tail2.x -= 0.15;
			if (this.Tail2.xRot > 0) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot > 0) this.Tail2.yRot -= 0.05;
			//LeftLeg2
			//this.LeftLeg2.y = 26;
			//this.LeftLeg2.z = 9;
			if (this.LeftLeg2.y < 26) this.LeftLeg2.y += 0.15;
			if (this.LeftLeg2.z < 9) this.LeftLeg2.z += 0.15;
			if (this.LeftLeg2.xRot < 0) this.LeftLeg2.xRot += 0.05;
			//LeftLeg1
			//this.LeftLeg1.y = -26;
			//this.LeftLeg1.z = -1;
			if (this.LeftLeg1.y > -26) this.LeftLeg1.y -= 0.15;
			if (this.LeftLeg1.z > -1) this.LeftLeg1.z -= 0.15;
			if (this.LeftLeg1.xRot < 0) this.LeftLeg1.xRot += 0.05;
			if (this.LeftLeg1.yRot > 0) this.LeftLeg1.yRot -= 0.05;
			//Back
			//this.Back.y = -29F;
			if (this.Back.y > -29) this.Back.y -= 0.15;
			if (this.Back.xRot < 0) this.Back.xRot += 0.05;
			//Tail1
			//this.Tail1.x = 0;
			//this.Tail1.z = 17F;
			//this.Tail1.xRot = -0.04555309164612875F;
			if (this.Tail1.x > 0) this.Tail1.x -= 0.15;
			if (this.Tail1.z > 17) this.Tail1.z -= 0.15;
			if (this.Tail1.xRot < -0.04555309164612875F) this.Tail1.xRot += 0.05;
			if (this.Tail1.yRot > 0) this.Tail1.yRot -= 0.05;
			//Head1
			//this.Head1.x = 0;
			//this.Head1.y = -17.1F;
			//this.Head1.z = -7;
			if (this.Head1.x < 0) this.Head1.x += 0.15;
			if (this.Head1.y > -17.1) this.Head1.y -= 0.15;
			if (this.Head1.z > -7) this.Head1.z -= 0.15;
			if (this.Head1.xRot < 0) this.Head1.xRot += 0.05;
			if (this.Head1.yRot < 0) this.Head1.yRot += 0.05;
			if (this.Head1.zRot > 0) this.Head1.zRot -= 0.05;
			//LeftArm
			//this.LeftArm.xRot = 0.27314402127920984F;
			if (this.LeftArm.xRot > 0.27314402127920984F) this.LeftArm.xRot -= 0.05;
			if (this.LeftArm.yRot < 0) this.LeftArm.yRot += 0.05;
			//RightArm
			//this.RightArm.x = 10.1F;
			//this.RightArm.z = -13;
			//this.RightArm.xRot = 0.27314402127920984F;
			if (this.Head1.x > 10.1) this.Head1.x -= 0.15;
			if (this.Head1.z < -13) this.Head1.z += 0.15;
			if (this.Head1.xRot > 0.27314402127920984F) this.Head1.xRot -= 0.05;
			if (this.Head1.yRot > 0) this.Head1.yRot -= 0.05;
			if (this.Head1.zRot < 0) this.Head1.zRot += 0.05;
			//RightLeg1
			//this.RightLeg1.x = 6;
			//this.RightLeg1.y = -26;
			//this.RightLeg1.z = -1;
			if (this.RightLeg1.x > 6) this.RightLeg1.x += 0.15;
			if (this.RightLeg1.y > -26) this.RightLeg1.y -= 0.15;
			if (this.RightLeg1.z > -1) this.RightLeg1.z -= 0.15;
			if (this.RightLeg1.xRot < 0) this.RightLeg1.xRot += 0.05;
			if (this.RightLeg1.yRot < 0) this.RightLeg1.yRot += 0.05;
			//LeftFoot
			if (this.LeftFoot.xRot > 0) this.LeftFoot.xRot -= 0.05;
		}
	}

	public void resetModel() {
		this.Chest.xRot = 0;
		this.Chest.yRot = 0;
		this.Neck.xRot = 0.0698F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.RightFoot.xRot = 0;
		this.RightLeg2.xRot = 0;
		this.Tail2.xRot = 0.0349F;
		this.Tail2.yRot = 0;
		this.LeftLeg2.xRot = 0;
		this.LeftLeg1.xRot = 0;
		this.LeftLeg1.yRot = 0;
		this.Back.xRot = -0;
		this.Tail1.xRot = -0.0349F;
		this.Tail1.yRot = 0;
		this.Head1.xRot = 0;
		this.Head1.yRot = 0;
		this.Head1.zRot = 0;
		this.LeftArm.xRot = 0.0698F;
		this.LeftArm.yRot = 0;
		this.RightArm.xRot = 0.0698F;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.RightLeg1.xRot = 0;
		this.RightLeg1.yRot = 0;
		this.LeftFoot.xRot = 0;
		this.Back.y = -7F;
		this.Chest.x = 0;
		this.Chest.y = 1;
		this.Chest.z = -11;
		this.RightArm.x = 5F;
		this.RightArm.z = -10;
		this.Neck.y = -3;
		this.Neck.z = -13;
		//0.0F, -3.2F, -6.0F
		this.Head1.x = 0;
		this.Head1.y = -3.2F;
		this.Head1.z = -6;
		this.Tail1.x = 0;
		this.Tail1.z = 7F;
		this.Tail2.x = 0F;
		this.LeftLeg1.y = -5.2F;
		this.LeftLeg1.z = 3;
		this.LeftLeg2.y = 11;
		this.LeftLeg2.z = 3;
		this.RightLeg1.x = 2;
		this.RightLeg1.y = -5.2F;
		this.RightLeg1.z = 3;
		this.RightLeg2.y = 11;
		this.RightLeg2.z = 3;
	}

	public void sleepPose() {
		this.Chest.xRot = 0.41887902047863906F;
		this.Chest.yRot = -0.5235987755982988F;
		this.Neck.xRot = 0.8203047484373349F;
		this.Neck.yRot = -0.3490658503988659F;
		this.Neck.zRot = -0.10471975511965977F;
		this.RightFoot.xRot = 1.5707963267948966F;
		this.RightLeg2.xRot = -0.8726646259971648F;
		this.Tail2.xRot = 0.24434609527920614F;
		this.Tail2.yRot = 0.41887902047863906F;
		this.LeftLeg2.xRot = -0.8726646259971648F;
		this.LeftLeg1.xRot = -0.6981317007977318F;
		this.LeftLeg1.yRot = 0.5235987755982988F;
		this.Back.xRot = -0.17453292519943295F;
		this.Tail1.xRot = -0.24434609527920614F;
		this.Tail1.yRot = 0.593411945678072F;
		this.Head1.xRot = -0.9075712110370513F;
		this.Head1.yRot = -0.06981317007977318F;
		this.Head1.zRot = 0.3490658503988659F;
		this.LeftArm.xRot = 1.3264502315156905F;
		this.LeftArm.yRot = -0.13962634015954636F;
		this.RightArm.xRot = 1.0878637547259988F;
		this.RightArm.yRot = 0.296705972839036F;
		this.RightArm.zRot = -0.13962634015954636F;
		this.RightLeg1.xRot = -0.6981317007977318F;
		this.RightLeg1.yRot = -0.2792526803190927F;
		this.LeftFoot.xRot = 1.5707963267948966F;
		this.Back.y = -1.6F;
		this.Chest.x = 4;
		this.Chest.y = -1;
		this.Chest.z = -20;
		this.RightArm.x = 11;
		this.RightArm.z = -14;
		this.Neck.y = 10;
		this.Neck.z = -20;
		this.Head1.x = -1;
		this.Head1.y = -15;
		this.Head1.z = -6;
		this.Tail1.x = 3;
		this.Tail1.z = 19.5F;
		this.Tail2.x = 0.6F;
		this.LeftLeg1.y = -5;
		this.LeftLeg1.z = 3;
		this.LeftLeg2.y = 22;
		this.LeftLeg2.z = 8;
		this.RightLeg1.x = 7;
		this.RightLeg1.y = -5;
		this.RightLeg1.z = 2;
		this.RightLeg2.y = 22;
		this.RightLeg2.z = 8;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LeftLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Back.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}