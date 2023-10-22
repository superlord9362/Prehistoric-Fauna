package superlord.prehistoricfauna.client.model.triassic.chinle;

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
import superlord.prehistoricfauna.common.entity.triassic.chinle.Poposaurus;

public class PoposaurusModel extends EntityModel<Poposaurus> {
	private final ModelPart Thigh_R;
	private final ModelPart Leg_R;
	private final ModelPart Foot_R;
	private final ModelPart Thigh_L;
	private final ModelPart Leg_L;
	private final ModelPart Foot_L;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Jaw_base;
	private final ModelPart Tail_1;
	private final ModelPart Tail_2;
	private final ModelPart Tail_3;
	private final ModelPart Arm_R;
	private final ModelPart Arm_L;

	public PoposaurusModel(ModelPart root) {
		this.Thigh_R = root.getChild("Thigh_R");
		this.Leg_R = Thigh_R.getChild("Leg_R");
		this.Foot_R = Leg_R.getChild("Foot_R");
		this.Thigh_L = root.getChild("Thigh_L");
		this.Leg_L = Thigh_L.getChild("Leg_L");
		this.Foot_L = Leg_L.getChild("Foot_L");
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.Jaw_base = Head.getChild("Jaw_base");
		this.Tail_1 = Body.getChild("Tail_1");
		this.Tail_2 = Tail_1.getChild("Tail_2");
		this.Tail_3 = Tail_2.getChild("Tail_3");
		this.Arm_L = Body.getChild("Arm_L");
		this.Arm_R = Body.getChild("Arm_R");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Thigh_R = partdefinition.addOrReplaceChild("Thigh_R", CubeListBuilder.create().texOffs(60, 40).addBox(0.0F, 0.0F, 0.0F, 4.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 3.0F, -1.0F, -0.05F, 0.0F, 0.0F));

		PartDefinition Leg_R = Thigh_R.addOrReplaceChild("Leg_R", CubeListBuilder.create().texOffs(85, 40).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 9.0F, 3.0F, 0.05F, 0.0F, 0.0F));

		PartDefinition Foot_R = Leg_R.addOrReplaceChild("Foot_R", CubeListBuilder.create().texOffs(39, 57).addBox(-2.0F, 0.0F, -6.0F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 2.0F));

		PartDefinition Thigh_L = partdefinition.addOrReplaceChild("Thigh_L", CubeListBuilder.create().texOffs(60, 40).mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 3.0F, -1.0F, -0.05F, 0.0F, 0.0F));

		PartDefinition Leg_L = Thigh_L.addOrReplaceChild("Leg_L", CubeListBuilder.create().texOffs(85, 40).mirror().addBox(-1.5F, -1.0F, 0.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 9.0F, 3.0F, 0.05F, 0.0F, 0.0F));

		PartDefinition Foot_L = Leg_L.addOrReplaceChild("Foot_L", CubeListBuilder.create().texOffs(39, 57).mirror().addBox(-2.0F, 0.0F, -6.0F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 10.0F, 2.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -3.0F, -20.0F, 9.0F, 11.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 1.0F));

		PartDefinition Arm_L = Body.addOrReplaceChild("Arm_L", CubeListBuilder.create().texOffs(45, 40).mirror().addBox(-2.0F, 0.0F, 0.0F, 2.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.5F, 5.0F, -16.0F));

		PartDefinition Arm_R = Body.addOrReplaceChild("Arm_R", CubeListBuilder.create().texOffs(45, 40).addBox(0.0F, 0.0F, 0.0F, 2.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 5.0F, -16.0F));

		PartDefinition Tail_1 = Body.addOrReplaceChild("Tail_1", CubeListBuilder.create().texOffs(0, 40).addBox(-3.0F, -5.0F, 0.0F, 6.0F, 8.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 7.0F));

		PartDefinition Tail_2 = Tail_1.addOrReplaceChild("Tail_2", CubeListBuilder.create().texOffs(0, 63).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 13.0F));

		PartDefinition Tail_3 = Tail_2.addOrReplaceChild("Tail_3", CubeListBuilder.create().texOffs(0, 89).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 16.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -9.0F, 4.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -18.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(50, 0).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, -9.0F));

		PartDefinition Jaw_base = Head.addOrReplaceChild("Jaw_base", CubeListBuilder.create().texOffs(50, 12).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition Throat = Jaw_base.addOrReplaceChild("Throat", CubeListBuilder.create().texOffs(1, 19).addBox(-2.01F, -2.0F, -4.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.9F, -0.01F));

		PartDefinition Jaw_tip = Jaw_base.addOrReplaceChild("Jaw_tip", CubeListBuilder.create().texOffs(75, 12).addBox(-1.5F, 0.0F, -7.0F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.0017F, 0.0F, 0.0F));

		PartDefinition Teeth_bot = Jaw_tip.addOrReplaceChild("Teeth_bot", CubeListBuilder.create().texOffs(98, 12).addBox(-1.0F, -1.0F, -6.7F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.2F));

		PartDefinition Snoot = Head.addOrReplaceChild("Snoot", CubeListBuilder.create().texOffs(75, 0).addBox(-1.5F, 0.0F, -7.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition Teeth_top = Snoot.addOrReplaceChild("Teeth_top", CubeListBuilder.create().texOffs(98, 0).addBox(-1.0F, 0.0F, -6.7F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.0017F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 120, 160);
	}

	@Override
	public void setupAnim(Poposaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		if (entity.getWakingTicks() >= 31 && entity.getFallingAsleepTicks() >= 31) {
			if (entity.isAsleep()) {
				sleepPose();
			} else {
				resetModel();
				this.Jaw_base.xRot = Math.abs(-0.025F * Mth.sin(0.1F * partialTick / 3)) + attackProgress * (float) Math.toRadians(25F);
				this.Arm_R.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.Arm_L.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
				this.Body.xRot = Mth.cos(limbSwing * speed * 0.1F) * degree * 0.15F * limbSwingAmount;
				this.Neck.xRot = Mth.cos(limbSwing * speed * 0.1F) * degree * -0.15F * limbSwingAmount;
				this.Tail_1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.2F * limbSwingAmount);
				this.Tail_2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Tail_2.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.25F * limbSwingAmount);
				this.Tail_3.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Tail_3.yRot = Mth.cos(limbSwing * speed * 0.15F) * degree * 0.25F * limbSwingAmount);
				this.Tail_1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Tail_2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.1F);
				this.Tail_3.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.1F);
				this.Thigh_R.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.6F * limbSwingAmount - 0.05F;
				this.Leg_R.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + 0.05F;
				this.Foot_R.xRot = Mth.cos(2.0F + limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.Thigh_L.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.6F * limbSwingAmount - 0.05F;
				this.Leg_L.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + 0.05F;
				this.Foot_L.xRot = Mth.cos(2.0F + limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.Neck.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
				this.Head.zRot = attackProgress * leftOrRight * (float) Math.toRadians(5F);
				if (entity.isInWater()) {
					this.Thigh_R.y = 21;
					this.Thigh_L.y = 21;
					this.Body.y = 20;
					this.Body.xRot = -0.25F;
					this.Tail_1.xRot = 0.125F;
					this.Tail_2.xRot = 0.125F;
					this.Neck.xRot = 0.25F;
					this.Thigh_R.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Thigh_L.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Leg_R.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Leg_L.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Foot_R.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.Foot_L.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.Arm_L.xRot = 0.25F;
					this.Arm_R.xRot = 0.25F;
					this.Tail_1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail_2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail_3.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Thigh_R
			//this.Thigh_R.x = 2;
			//this.Thigh_R.y = 3;
			//this.Thigh_R.z = -1;
			if (this.Thigh_R.x > 2) this.Thigh_R.x -= 0.15;
			if (this.Thigh_R.y > 3) this.Thigh_R.y -= 0.15;
			if (this.Thigh_R.z > -1) this.Thigh_R.z -= 0.15;
			if (this.Thigh_R.xRot < 0) this.Thigh_R.xRot += 0.05;
			if (this.Thigh_R.yRot < 0) this.Thigh_R.yRot += 0.05;
			//Foot_L
			//this.Foot_L.y = 10.0F;
			if (this.Foot_L.y < 10) this.Foot_L.y += 0.15;
			if (this.Foot_L.xRot > 0) this.Foot_L.xRot -= 0.05;
			if (this.Foot_L.zRot < 0) this.Foot_L.zRot += 0.05;
			//Arm_R
			//this.Arm_R.y = 5.0F;
			//this.Arm_R.z = -16.0F;
			if (this.Arm_R.y > 5) this.Arm_R.y -= 0.15;
			if (this.Arm_R.z > -16) this.Arm_R.z -= 0.15;
			if (this.Arm_R.xRot < 0) this.Arm_R.xRot += 0.05;
			if (this.Arm_R.zRot < 0) this.Arm_R.zRot += 0.05;
			//Leg_L
			//this.Leg_L.y = 9.0F;
			//this.Leg_L.z = 3.0F;
			if (this.Leg_L.y < 9) this.Leg_L.y += 0.15;
			if (this.Leg_L.z > 3) this.Leg_L.z -= 0.15;
			if (this.Leg_L.xRot < 0) this.Leg_L.xRot += 0.05;
			//Foot_R
			//this.Foot_R.y = 10.0F;
			if (this.Foot_R.y < 10) this.Foot_R.y += 0.15;
			if (this.Foot_R.xRot > 0) this.Foot_R.xRot -= 0.05;
			//Tail_3
			if (this.Tail_3.xRot < 0) this.Tail_3.xRot += 0.05;
			if (this.Tail_3.yRot > 0) this.Tail_3.yRot -= 0.05;
			if (this.Tail_3.zRot < 0) this.Tail_3.zRot += 0.05;
			//Neck
			//this.Neck.x = 0.0F;
			//this.Neck.y = -1.0F;
			if (this.Neck.x < 0) this.Neck.x += 0.15;
			if (this.Neck.y > -1) this.Neck.y -= 0.15;
			if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot < 0) this.Neck.yRot += 0.05;
			//Arm_L
			//this.Arm_L.y = 5.0F;
			//this.Arm_L.z = -16.0F;
			if (this.Arm_L.y > 5) this.Arm_L.y -= 0.15;
			if (this.Arm_L.z > -16) this.Arm_L.z -= 0.15;
			if (this.Arm_L.xRot < 0) this.Arm_L.xRot += 0.05;
			if (this.Arm_L.yRot < 0) this.Arm_L.yRot += 0.05;
			if (this.Arm_L.zRot > 0) this.Arm_L.zRot -= 0.05;
			//Body
			//this.Body.y = 3.0F;
			if (this.Body.y > 3) this.Body.y -= 0.15;
			if (this.Body.xRot < 0) this.Body.xRot += 0.05;
			if (this.Body.yRot > 0) this.Body.yRot -= 0.05;
			//Jaw_base
			if (this.Jaw_base.xRot > 0) this.Jaw_base.xRot -= 0.05;
			//Head
			//this.Head.y = -2.5F;
			//this.Head.z = -9.0F;
			if (this.Head.y > -2.5) this.Head.y -= 0.15;
			if (this.Head.z > -9) this.Head.z -= 0.15;
			if (this.Head.xRot < 0) this.Head.xRot += 0.05;
			if (this.Head.yRot < 0) this.Head.yRot += 0.05;
			if (this.Head.zRot > 0) this.Head.zRot -= 0.05;
			//Leg_R
			//this.Leg_R.y = 9.0F;
			//this.Leg_R.z = 3.0F;
			if (this.Leg_R.y < 9) this.Leg_R.y += 0.15;
			if (this.Leg_R.z > 3) this.Leg_R.z -= 0.15;
			if (this.Leg_R.xRot < 0) this.Leg_R.xRot += 0.05;
			//Tail1
			//this.Tail_1.x = 0.0F;
			//this.Tail_1.z = 7.0F;
			if (this.Tail_1.y < 0) this.Tail_1.y += 0.15;
			if (this.Tail_1.z < 7) this.Tail_1.z += 0.15;
			if (this.Tail_1.xRot < 0) this.Tail_1.xRot += 0.05;
			if (this.Tail_1.yRot > 0) this.Tail_1.yRot -= 0.05;
			if (this.Tail_1.zRot > 0) this.Tail_1.zRot -= 0.05;
			//Tail2
			if (this.Tail_2.xRot < 0) this.Tail_2.xRot += 0.05;
			if (this.Tail_2.yRot > 0) this.Tail_2.yRot -= 0.05;
			if (this.Tail_2.zRot < 0) this.Tail_2.zRot += 0.05;
			//Thigh_L
			//this.Thigh_L.x = -2.0F;
			//this.Thigh_L.y = 3.0F;
			//this.Thigh_L.z = -1.0F;
			if (this.Neck.x < -2) this.Thigh_L.x += 0.15;
			if (this.Thigh_L.y > 3) this.Thigh_L.y -= 0.15;
			if (this.Thigh_L.z > -1) this.Thigh_L.z -= 0.15;
			if (this.Thigh_L.xRot < 0) this.Thigh_L.xRot += 0.05;
			if (this.Thigh_L.yRot > 0) this.Thigh_L.yRot -= 0.05;
		}
		if (entity.getFallingAsleepTicks() < 31) {
			//Thigh_R
			//this.Thigh_R.x = 2;
			//this.Thigh_R.y = 3;
			//this.Thigh_R.z = -1;
			if (this.Thigh_R.x < 3) this.Thigh_R.x += 0.15;
			if (this.Thigh_R.y < 12) this.Thigh_R.y += 0.15;
			if (this.Thigh_R.z < 4) this.Thigh_R.z += 0.15;
			if (this.Thigh_R.xRot > -0.8726646259971648F) this.Thigh_R.xRot -= 0.05;
			if (this.Thigh_R.yRot > -0.3490658503988659F) this.Thigh_R.yRot -= 0.05;
			//Foot_L
			//this.Foot_L.y = 10.0F;
			if (this.Foot_L.y > 9) this.Foot_L.y -= 0.15;
			if (this.Foot_L.xRot < 1.5707963267948966F) this.Foot_L.xRot += 0.05;
			if (this.Foot_L.zRot > -0.0781907508222411F) this.Foot_L.zRot -= 0.05;
			//Arm_R
			//this.Arm_R.y = 5.0F;
			//this.Arm_R.z = -16.0F;
			if (this.Arm_R.y < 9) this.Arm_R.y += 0.15;
			if (this.Arm_R.z < -14) this.Arm_R.z += 0.15;
			if (this.Arm_R.xRot > -1.13376586611655F) this.Arm_R.xRot -= 0.05;
			if (this.Arm_R.zRot > -1.524545074985436F) this.Arm_R.zRot -= 0.05;
			//Leg_L
			//this.Leg_L.y = 9.0F;
			//this.Leg_L.z = 3.0F;
			if (this.Leg_L.y > 7) this.Leg_L.y -= 0.15;
			if (this.Leg_L.z < 5) this.Leg_L.z += 0.15;
			if (this.Leg_L.xRot > -0.6981317007977318F) this.Leg_L.xRot -= 0.05;
			//Foot_R
			//this.Foot_R.y = 10.0F;
			if (this.Foot_R.y > 9) this.Foot_R.y -= 0.15;
			if (this.Foot_R.xRot < 1.5707963267948966F) this.Foot_R.xRot += 0.05;
			//Tail_3
			if (this.Tail_3.xRot > -0.03490658503988659F) this.Tail_3.xRot -= 0.05;
			if (this.Tail_3.yRot < 0.35185837453889574F) this.Tail_3.yRot += 0.05;
			if (this.Tail_3.zRot > -0.0781907508222411F) this.Tail_3.zRot -= 0.05;
			//Neck
			//this.Neck.x = 0.0F;
			//this.Neck.y = -1.0F;
			if (this.Neck.x > -1) this.Neck.x -= 0.15;
			if (this.Neck.y < 1) this.Neck.y += 0.15;
			if (this.Neck.xRot < 0.5864306020384839F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot > -0.6646214111173737F) this.Neck.yRot -= 0.05;
			//Arm_L
			//this.Arm_L.y = 5.0F;
			//this.Arm_L.z = -16.0F;
			if (this.Arm_L.y < 7) this.Arm_L.y += 0.15;
			if (this.Arm_L.z < -15) this.Arm_L.z += 0.15;
			if (this.Arm_L.xRot > -1.0555751236166873F) this.Arm_L.xRot -= 0.05;
			if (this.Arm_L.yRot > -0.11728612207217244F) this.Arm_L.yRot -= 0.05;
			if (this.Arm_L.zRot < 1.2901473511162753F) this.Arm_L.zRot += 0.05;
			//Body
			//this.Body.y = 3.0F;
			if (this.Body.y < 16) this.Body.y += 0.15;
			if (this.Body.xRot > -0.03909537541112055F) this.Body.xRot -= 0.05;
			if (this.Body.yRot < 0.03909537541112055F) this.Body.yRot += 0.05;
			//Jaw_base
			if (this.Jaw_base.xRot < 0.3127630032889644F) this.Jaw_base.xRot += 0.05;
			//Head
			//this.Head.y = -2.5F;
			//this.Head.z = -9.0F;
			if (this.Head.y < -1.6) this.Head.y += 0.15;
			if (this.Head.z < -8) this.Head.z += 0.15;
			if (this.Head.xRot > -0.8600982340775168F) this.Head.xRot -= 0.05;
			if (this.Head.yRot > -0.3909537457888271F) this.Head.yRot -= 0.05;
			if (this.Head.zRot < 0.19547687289441354F) this.Head.zRot += 0.05;
			//Leg_R
			//this.Leg_R.y = 9.0F;
			//this.Leg_R.z = 3.0F;
			if (this.Leg_R.y > 7) this.Leg_R.y -= 0.15;
			if (this.Leg_R.z < 5) this.Leg_R.z += 0.15;
			if (this.Leg_R.xRot > -0.6981317007977318F) this.Leg_R.xRot -= 0.05;
			//Tail1
			//this.Tail_1.x = 0.0F;
			//this.Tail_1.z = 7.0F;
			if (this.Tail_1.y > -1) this.Tail_1.y -= 0.15;
			if (this.Tail_1.z > 5) this.Tail_1.z -= 0.15;
			if (this.Tail_1.xRot > -0.15707963267948966F) this.Tail_1.xRot -= 0.05;
			if (this.Tail_1.yRot < 0.5082398928281348F) this.Tail_1.yRot += 0.05;
			if (this.Tail_1.zRot < 0.0781907508222411F) this.Tail_1.zRot += 0.05;
			//Tail2
			if (this.Tail_2.xRot > -0.15707963267948966F) this.Tail_2.xRot -= 0.05;
			if (this.Tail_2.yRot < 0.5082398928281348F) this.Tail_2.yRot += 0.05;
			if (this.Tail_2.zRot > -0.19547687289441354F) this.Tail_2.zRot -= 0.05;
			//Thigh_L
			//this.Thigh_L.x = -2.0F;
			//this.Thigh_L.y = 3.0F;
			//this.Thigh_L.z = -1.0F;
			if (this.Neck.x > -2.7) this.Thigh_L.x -= 0.15;
			if (this.Thigh_L.y < 12) this.Thigh_L.y += 0.15;
			if (this.Thigh_L.z < 4.2) this.Thigh_L.z += 0.15;
			if (this.Thigh_L.xRot > -0.8726646259971648F) this.Thigh_L.xRot -= 0.05;
			if (this.Thigh_L.yRot < 0.3490658503988659F) this.Thigh_L.yRot += 0.05;
		}
	}

	public void resetModel() {
		this.Thigh_R.x = 2;
		this.Thigh_R.y = 3;
		this.Thigh_R.z = -1;
		this.Thigh_R.xRot = 0;
		this.Thigh_R.yRot = 0;
		this.Foot_L.y = 10.0F;
		this.Foot_L.xRot = 0;
		this.Foot_L.zRot = 0;
		this.Arm_R.y = 5.0F;
		this.Arm_R.z = -16.0F;
		this.Arm_R.xRot = 0;
		this.Arm_R.zRot = 0;
		this.Leg_L.y = 9.0F;
		this.Leg_L.z = 3.0F;
		this.Leg_L.xRot = 0;
		this.Foot_R.y = 10.0F;
		this.Foot_R.xRot = 0;
		this.Tail_3.xRot = 0;
		this.Tail_3.yRot = 0;
		this.Tail_3.zRot = 0;
		this.Neck.x = 0.0F;
		this.Neck.y = -1.0F;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Arm_L.y = 5.0F;
		this.Arm_L.z = -16.0F;
		this.Arm_L.xRot = 0;
		this.Arm_L.yRot = 0;
		this.Arm_L.zRot = 0;
		this.Body.y = 3.0F;
		this.Body.xRot = 0;
		this.Body.yRot = 0;
		this.Jaw_base.xRot = 0;
		this.Head.y = -2.5F;
		this.Head.z = -9.0F;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.Leg_R.y = 9.0F;
		this.Leg_R.z = 3.0F;
		this.Leg_R.xRot = 0;
		this.Tail_1.x = 0.0F;
		this.Tail_1.z = 7.0F;
		this.Tail_1.xRot = 0;
		this.Tail_1.yRot = 0;
		this.Tail_1.zRot = 0;
		this.Tail_2.xRot = 0;
		this.Tail_2.yRot = 0;
		this.Tail_2.zRot = 0;
		this.Thigh_L.x = -2.0F;
		this.Thigh_L.y = 3.0F;
		this.Thigh_L.z = -1.0F;
		this.Thigh_L.xRot = 0.0F;
		this.Thigh_L.yRot = 0.0F;
	}

	public void sleepPose() {
		this.Thigh_R.x = 3;
		this.Thigh_R.y = 12;
		this.Thigh_R.z = 4;
		this.Thigh_R.xRot = -0.8726646259971648F;
		this.Thigh_R.yRot = -0.3490658503988659F;
		this.Foot_L.y = 9.0F;
		this.Foot_L.xRot = 1.5707963267948966F;
		this.Foot_L.zRot = -0.0781907508222411F;
		this.Arm_R.y = 9.0F;
		this.Arm_R.z = -14.0F;
		this.Arm_R.xRot = -1.13376586611655F;
		this.Arm_R.zRot = -1.524545074985436F;
		this.Leg_L.y = 7.0F;
		this.Leg_L.z = 5.0F;
		this.Leg_L.xRot = -0.6981317007977318F;
		this.Foot_R.y = 9.0F;
		this.Foot_R.xRot = 1.5707963267948966F;
		this.Tail_3.xRot = -0.03490658503988659F;
		this.Tail_3.yRot = 0.35185837453889574F;
		this.Tail_3.zRot = -0.0781907508222411F;
		this.Neck.x = -1.0F;
		this.Neck.y = 1.0F;
		this.Neck.xRot = 0.5864306020384839F;
		this.Neck.yRot = -0.6646214111173737F;
		this.Arm_L.y = 7.0F;
		this.Arm_L.z = -15.0F;
		this.Arm_L.xRot = -1.0555751236166873F;
		this.Arm_L.yRot = -0.11728612207217244F;
		this.Arm_L.zRot = 1.2901473511162753F;
		this.Body.y = 16.0F;
		this.Body.xRot = -0.03909537541112055F;
		this.Body.yRot = 0.03909537541112055F;
		this.Jaw_base.xRot = 0.3127630032889644F;
		this.Head.y = -1.6F;
		this.Head.z = -8.0F;
		this.Head.xRot = -0.8600982340775168F;
		this.Head.yRot = -0.3909537457888271F;
		this.Head.zRot = 0.19547687289441354F;
		this.Leg_R.y = 7.0F;
		this.Leg_R.z = 5.0F;
		this.Leg_R.xRot = -0.6981317007977318F;
		this.Tail_1.x = -1.0F;
		this.Tail_1.z = 5.0F;
		this.Tail_1.xRot = -0.15707963267948966F;
		this.Tail_1.yRot = 0.5082398928281348F;
		this.Tail_1.zRot = 0.0781907508222411F;
		this.Tail_2.xRot = -0.03490658503988659F;
		this.Tail_2.yRot = 0.5082398928281348F;
		this.Tail_2.zRot = -0.19547687289441354F;
		this.Thigh_L.x = -2.7F;
		this.Thigh_L.y = 12.0F;
		this.Thigh_L.z = 4.2F;
		this.Thigh_L.xRot = -0.8726646259971648F;
		this.Thigh_L.yRot = 0.3490658503988659F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Thigh_R.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Thigh_L.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}