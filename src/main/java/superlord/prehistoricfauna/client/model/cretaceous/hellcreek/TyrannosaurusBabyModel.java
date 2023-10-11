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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Tyrannosaurus;

public class TyrannosaurusBabyModel extends EntityModel<Tyrannosaurus> {
	private final ModelPart Torso;
	private final ModelPart Chest;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart TailBase;
	private final ModelPart Tail;
	private final ModelPart RArm;
	private final ModelPart LArm;
	private final ModelPart LLeg;
	private final ModelPart LFoot;
	private final ModelPart RLeg;
	private final ModelPart RFoot;

	public TyrannosaurusBabyModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.Chest = Torso.getChild("Chest");
		this.Neck = Torso.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.TailBase = Torso.getChild("TailBase");
		this.Tail = TailBase.getChild("Tail");
		this.RArm = Torso.getChild("RArm");
		this.LArm = Torso.getChild("LArm");
		this.LLeg = root.getChild("LLeg");
		this.LFoot = LLeg.getChild("LFoot");
		this.RLeg = root.getChild("RLeg");
		this.RFoot = RLeg.getChild("RFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, -1.0F));

		PartDefinition Chest = Torso.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 13).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(24, 0).addBox(-1.5F, -6.0F, -2.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -5.0F, 0.1047F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(21, 10).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.1F, -1.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(35, 11).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition TailBase = Torso.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.1F, 6.0F));

		PartDefinition Tail = TailBase.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(22, 17).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 6.0F));

		PartDefinition RArm = Torso.addOrReplaceChild("RArm", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, 0.0F, -1.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, 3.9F, -3.5F, 0.1396F, 0.0F, -0.1047F));

		PartDefinition LArm = Torso.addOrReplaceChild("LArm", CubeListBuilder.create().texOffs(0, -2).mirror().addBox(0.0F, 0.0F, -1.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1F, 3.9F, -3.5F, 0.1396F, 0.0F, 0.1047F));

		PartDefinition LLeg = partdefinition.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(18, 17).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 10.5F, 2.0F));

		PartDefinition LFoot = LLeg.addOrReplaceChild("LFoot", CubeListBuilder.create().texOffs(36, 0).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.5F, 2.0F));

		PartDefinition RLeg = partdefinition.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(18, 17).mirror().addBox(-1.5F, -1.5F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 10.5F, 2.0F));

		PartDefinition RFoot = RLeg.addOrReplaceChild("RFoot", CubeListBuilder.create().texOffs(36, 0).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.5F, 2.0F));

		return LayerDefinition.create(meshdefinition, 58, 35);
	}

	@Override
	public void setupAnim(Tyrannosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		int sleepProgress = entity.getSleepTicks();
		int wakingProgress = entity.getWakingTicks();
		if (!entity.isWakingUp() && !entity.isFallingAsleep()) {
			if (!entity.isAsleep()) {
				resetModel();
			} else {
				this.LFoot.xRot = -0.8761552978169589F;
				this.Head.xRot = 0.41887902047863906F;
				this.Head.yRot = -1.0471975511965976F;
				this.RFoot.xRot = -0.8639379797371932F;
				this.RFoot.yRot = -0.17453292519943295F;
				this.RFoot.zRot = -0.17453292519943295F;
				this.Neck.xRot = 0.41887902047863906F;
				this.Neck.yRot = -1.0471975511965976F;
				this.RLeg.xRot = -0.6981317007977318F;
				this.RLeg.yRot = 0.3490658503988659F;
				this.Chest.xRot = 0.17453292519943295F;
				this.Chest.yRot = -0.5235987755982988F;
				this.Torso.xRot = -0.17453292519943295F;
				this.Tail.xRot = 0.24434609527920614F;
				this.Tail.yRot = 0.41887902047863906F;
				this.Tail.zRot = 0.17453292519943295F;
				this.LLeg.xRot = -0.6981317007977318F;
				this.LLeg.yRot = -0.5235987755982988F;
				this.RArm.xRot = 0.7330382858376184F;
				this.RArm.yRot = -0.5235987755982988F;
				this.RArm.zRot = 0.24434609527920614F;
				this.TailBase.xRot = -0.17453292519943295F;
				this.TailBase.yRot = 0.593411945678072F;
				this.LArm.xRot = 0.6283185307179586F;
				this.LArm.yRot = -0.5235987755982988F;
				this.LArm.zRot = -0.24434609527920614F;
				this.Torso.y = 15.6F;
				this.Tail.x = 0;
				this.Chest.x = 2;
				this.Chest.y = 1;
				this.Chest.z = -3;
				this.Neck.x = 1.5F;
				this.Neck.y = 4;
				this.Neck.z = -2;
				this.Head.y = -7;
				this.Head.z = -1.5F;
				this.LArm.x = 2.9F;
				this.LArm.z = -0.7F;
				this.RArm.x = -0.8F;
				this.RArm.z = -2F;
				this.LLeg.x = 3;
				this.LLeg.y = 18.5F;
				this.LFoot.y = 5.1F;
				this.LFoot.z = 2.4F;
				this.RLeg.x = -3;
				this.RLeg.y = 18.5F;
				this.RFoot.y = 5.1F;
				this.RFoot.z = 2.4F;
			}
		}
		if (wakingProgress != 0) {
			//LFoot
//			this.LFoot.y = 5.4F;
//			this.LFoot.z = 2;
			if (this.LFoot.y < 5.4F) this.LFoot.y += 0.15;
			if (this.LFoot.z > 2F) this.LFoot.z -= 0.15;
			if (this.LFoot.xRot < 0) this.LFoot.xRot += 0.05;
			//Head
//			this.Head.x = 0;
//			this.Head.y = -5.1F;
			if (this.Head.y < 0F) this.Head.y += 0.15;
			if (this.Head.z > -5.1F) this.Head.z -= 0.15;
			if (this.Head.xRot > 0) this.Head.xRot -= 0.05;
			if (this.Head.yRot < 0) this.Head.yRot += 0.05;
			//RFoot
//			this.RFoot.y = 5.4F;
//			this.RFoot.z = 2;
			if (this.RFoot.y < 5.4F) this.RFoot.y += 0.15;
			if (this.RFoot.z > 2F) this.RFoot.z -= 0.15;
			if (this.RFoot.xRot < 0) this.RFoot.xRot += 0.05;
			if (this.RFoot.yRot < 0) this.RFoot.yRot += 0.05;
			if (this.RFoot.zRot < 0) this.RFoot.zRot += 0.05;
			//Neck
//			this.Neck.x = 0;
//			this.Neck.y = 3;
//			this.Neck.z = -5;
//			this.Neck.xRot = 0.1047F;
			if (this.Neck.x > 0) this.Neck.x -= 0.15;
			if (this.Neck.y > 3) this.Neck.y -= 0.15;
			if (this.Neck.z > -5F) this.Neck.z -= 0.15;
			if (this.Neck.xRot > 0.1047F) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot < 0) this.Neck.yRot += 0.05;
			//RLeg
//			this.RLeg.x = 2.5F;
//			this.RLeg.y = 10.5F;
			if (this.RLeg.x < 2.5F) this.RLeg.x += 0.15;
			if (this.RLeg.y > 10.5) this.RLeg.y -= 0.15;
			if (this.RLeg.xRot < 0) this.RLeg.xRot += 0.05;
			if (this.RLeg.yRot > 0) this.RLeg.yRot -= 0.05;
			//Chest
//			this.Chest.x = 0;
//			this.Chest.y = 0;
//			this.Chest.z = -5;
			if (this.Chest.x > 0) this.Chest.x -= 0.15;
			if (this.Chest.y > 0) this.Chest.y -= 0.15;
			if (this.Chest.z > -5) this.Chest.z -= 0.15;
			if (this.Chest.xRot > 0) this.Chest.xRot -= 0.05;
			if (this.Chest.yRot < 0) this.Chest.yRot += 0.05;
			//Torso
//			this.Torso.y = 8;
			if (this.Torso.y > 8) this.Torso.y -= 0.15;
			if (this.Torso.xRot < 0) this.Torso.xRot += 0.05;
			//Tail
			if (this.Tail.xRot > 0) this.Tail.xRot -= 0.05;
			if (this.Tail.yRot > 0) this.Tail.yRot -= 0.05;
			if (this.Tail.zRot > 0) this.Tail.zRot -= 0.05;
			//LLeg
//			this.LLeg.x = -2.5F;
//			this.LLeg.y = 10.5F;
			if (this.LLeg.x > -2.5) this.LLeg.x -= 0.15;
			if (this.LLeg.y > 10.5) this.LLeg.y -= 0.15;
			if (this.LLeg.xRot < 0) this.LLeg.xRot += 0.05;
			if (this.LLeg.yRot < 0) this.LLeg.yRot += 0.05;
			//RArm
//			this.RArm.x = 2.1F;
//			this.RArm.z = -3.5F;
//			this.RArm.xRot = 0.1396F;
			if (this.RArm.x < 2.1F) this.RArm.x += 0.15;
			if (this.RArm.z > -3.5) this.RArm.z -= 0.15;
			if (this.RArm.xRot > 0.1396F) this.RArm.xRot -= 0.05;
			if (this.RArm.yRot < 0) this.RArm.yRot += 0.05;
			if (this.RArm.zRot > 0) this.RArm.zRot -= 0.05;
			//TailBase
//			this.TailBase.xRot = -0.04555309164612875F;
			if (this.TailBase.xRot < -0.04555309164612875F) this.TailBase.xRot += 0.05;
			if (this.TailBase.yRot > 0) this.TailBase.yRot -= 0.05;
			//LArm
//			this.LArm.x = -2.1F;
//			this.LArm.z = -3.5F;
//			this.LArm.xRot = 0.1396F;
//			this.LArm.zRot = 0.1047F;
			if (this.LArm.x > -2.1F) this.LArm.x -= 0.15;
			if (this.LArm.z > -3.5) this.LArm.z -= 0.15;
			if (this.LArm.xRot > 0.1396F) this.LArm.xRot -= 0.05;
			if (this.LArm.yRot < 0) this.LArm.yRot += 0.05;
			if (this.LArm.zRot < 0.1047F) this.LArm.zRot += 0.05;
		}
		if (entity.isAsleep()) {
			if (sleepProgress != 0) {
				//LFoot
//				this.LFoot.y = 5.4F;
//				this.LFoot.z = 2;
				if (this.LFoot.y > 5.1F) this.LFoot.y -= 0.15;
				if (this.LFoot.z < 2.4F) this.LFoot.z += 0.15;
				if (this.LFoot.xRot > -0.8761552978169589F) this.LFoot.xRot -= 0.05;
				//Head
//				this.Head.x = 0;
//				this.Head.y = -5.1F;
				if (this.Head.y > -7F) this.Head.y -= 0.15;
				if (this.Head.z < -1.5F) this.Head.z += 0.15;
				if (this.Head.xRot < 0.41887902047863906F) this.Head.xRot += 0.05;
				if (this.Head.yRot > -1.0471975511965976F) this.Head.yRot -= 0.05;
				//RFoot
//				this.RFoot.y = 5.4F;
//				this.RFoot.z = 2;
				if (this.RFoot.y > 5.1F) this.RFoot.y -= 0.15;
				if (this.RFoot.z < 2.4F) this.RFoot.z += 0.15;
				if (this.RFoot.xRot > -0.8639379797371932F) this.RFoot.xRot -= 0.05;
				if (this.RFoot.yRot > -0.17453292519943295F) this.RFoot.yRot -= 0.05;
				if (this.RFoot.zRot > -0.17453292519943295F) this.RFoot.zRot -= 0.05;
				//Neck
//				this.Neck.x = 0;
//				this.Neck.y = 3;
//				this.Neck.z = -5;
//				this.Neck.xRot = 0.1047F;
				if (this.Neck.x < 1.5F) this.Neck.x += 0.15;
				if (this.Neck.y < 4) this.Neck.y += 0.15;
				if (this.Neck.z < -2F) this.Neck.z += 0.15;
				if (this.Neck.xRot < 0.41887902047863906F) this.Neck.xRot += 0.05;
				if (this.Neck.yRot > -1.0471975511965976F) this.Neck.yRot -= 0.05;
				//RLeg
//				this.RLeg.x = 2.5F;
//				this.RLeg.y = 10.5F;
				if (this.RLeg.x > -3F) this.RLeg.x -= 0.15;
				if (this.RLeg.y < 18.5) this.RLeg.y += 0.15;
				if (this.RLeg.xRot > -0.6981317007977318F) this.RLeg.xRot -= 0.05;
				if (this.RLeg.yRot < 0.3490658503988659F) this.RLeg.yRot += 0.05;
				//Chest
//				this.Chest.x = 0;
//				this.Chest.y = 0;
//				this.Chest.z = -5;
				if (this.Chest.x < 2) this.Chest.x += 0.15;
				if (this.Chest.y < 1) this.Chest.y += 0.15;
				if (this.Chest.z < -3) this.Chest.z += 0.15;
				if (this.Chest.xRot < 0.17453292519943295F) this.Chest.xRot += 0.05;
				if (this.Chest.yRot > -0.5235987755982988F) this.Chest.yRot -= 0.05;
				//Torso
//				this.Torso.y = 8;
				if (this.Torso.y < 15.6) this.Torso.y += 0.15;
				if (this.Torso.xRot > -0.17453292519943295F) this.Torso.xRot -= 0.05;
				//Tail
				if (this.Tail.xRot < 0.24434609527920614F) this.Tail.xRot += 0.05;
				if (this.Tail.yRot < 0.41887902047863906F) this.Tail.yRot += 0.05;
				if (this.Tail.zRot < 0.17453292519943295F) this.Tail.zRot += 0.05;
				//LLeg
//				this.LLeg.x = -2.5F;
//				this.LLeg.y = 10.5F;
				if (this.LLeg.x < 3) this.LLeg.x += 0.15;
				if (this.LLeg.y < 18.5) this.LLeg.y += 0.15;
				if (this.LLeg.xRot > -0.6981317007977318F) this.LLeg.xRot -= 0.05;
				if (this.LLeg.yRot > -0.5235987755982988F) this.LLeg.yRot -= 0.05;
				//RArm
//				this.RArm.x = 2.1F;
//				this.RArm.z = -3.5F;
//				this.RArm.xRot = 0.1396F;
				if (this.RArm.x > -0.8F) this.RArm.x -= 0.15;
				if (this.RArm.z < -2) this.RArm.z += 0.15;
				if (this.RArm.xRot < 0.7330382858376184F) this.RArm.xRot += 0.05;
				if (this.RArm.yRot > -0.5235987755982988F) this.RArm.yRot -= 0.05;
				if (this.RArm.zRot < 0.24434609527920614F) this.RArm.zRot += 0.05;
				//TailBase
//				this.TailBase.xRot = -0.04555309164612875F;
				if (this.TailBase.xRot > -0.17453292519943295F) this.TailBase.xRot -= 0.05;
				if (this.TailBase.yRot < 0.593411945678072F) this.TailBase.yRot += 0.05;
				//LArm
//				this.LArm.x = -2.1F;
//				this.LArm.z = -3.5F;
//				this.LArm.xRot = 0.1396F;
//				this.LArm.zRot = 0.1047F;
				if (this.LArm.x < 2.9F) this.LArm.x += 0.15;
				if (this.LArm.z < -0.7) this.LArm.z += 0.15;
				if (this.LArm.xRot < 0.6283185307179586F) this.LArm.xRot += 0.05;
				if (this.LArm.yRot > -0.5235987755982988F) this.LArm.yRot -= 0.05;
				if (this.LArm.zRot > -0.24434609527920614F) this.LArm.zRot -= 0.05;
			}
		} else {
			float speed = 0.8f;
			float degree = 1.0f;
			this.Neck.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.25F;
			this.Chest.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.01F * limbSwingAmount;
			this.Torso.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount;
			this.TailBase.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount - 0.15F;
			this.Tail.xRot = Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.1F;
			this.TailBase.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.2F * limbSwingAmount;
			this.Tail.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.25F * limbSwingAmount;
			this.Head.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.1F;
			this.LArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
			this.RArm.xRot = Mth.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.25F;
			this.LLeg.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount - 0.05F;
			this.LFoot.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.05F;
			this.RLeg.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount - 0.05F;
			this.RFoot.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + 0.05F;
			if (entity.isInWater()) {
				this.LLeg.y = 19;
				this.RLeg.y = 19;
				this.Torso.y = 16;
				this.Torso.xRot = -0.125F;
				this.TailBase.xRot = 0.0625F;
				this.Tail.xRot = 0.0625F;
				this.Neck.xRot = 0.125F;
				this.LLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LFoot.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RFoot.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RArm.xRot = 0.125F;
				this.LArm.xRot = 0.125F;
				this.TailBase.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.LFoot.xRot = 0;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.RFoot.xRot = 0;
		this.RFoot.yRot = 0;
		this.RFoot.zRot = -0;
		this.Neck.xRot = 0.1047F;
		this.Neck.yRot = 0;
		this.RLeg.xRot = 0;
		this.RLeg.yRot = 0;
		this.Chest.xRot = 0;
		this.Chest.yRot = 0;
		this.Torso.xRot = 0;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Tail.zRot = 0;
		this.LLeg.xRot = 0;
		this.LLeg.yRot = 0;
		this.RArm.xRot = 0.1396F;
		this.RArm.yRot = 0;
		this.RArm.zRot = -0.1047F;
		this.TailBase.y = 1.3F;
		this.TailBase.xRot = -0.04555309164612875F;
		this.TailBase.yRot = 0;
		this.LArm.xRot = 0.1396F;
		this.LArm.yRot = 0;
		this.LArm.zRot = 0.1047F;
		this.Torso.y = 8;
		this.Tail.x = 0;
		this.Chest.x = 0;
		this.Chest.y = 0;
		this.Chest.z = -5;
		this.Neck.x = 0;
		this.Neck.y = 3;
		this.Neck.z = -5;
		this.Head.x = 0;
		this.Head.y = -5.1F;
		this.Head.z = -1F;
		this.LArm.x = -2.1F;
		this.LArm.z = -3.5F;
		this.RArm.x = 2.1F;
		this.RArm.z = -3.5F;
		this.LLeg.x = -2.5F;
		this.LLeg.y = 10.5F;
		this.LFoot.y = 5.4F;
		this.LFoot.z = 2;
		this.RLeg.x = 2.5F;
		this.RLeg.y = 10.5F;
		this.RFoot.y = 5.4F;
		this.RFoot.z = 2;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
