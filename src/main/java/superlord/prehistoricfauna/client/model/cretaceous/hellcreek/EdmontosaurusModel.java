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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Edmontosaurus;

public class EdmontosaurusModel extends EntityModel<Edmontosaurus> {
	private final ModelPart Hips;
	private final ModelPart Chest;
	private final ModelPart Neck;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart Tail1;
	private final ModelPart Tail2;

	public EdmontosaurusModel(ModelPart root) {
		this.Hips = root.getChild("Hips");
		this.Chest = Hips.getChild("Chest");
		this.Neck = Chest.getChild("Neck");
		this.RightArm = Chest.getChild("RightArm");
		this.LeftArm = Chest.getChild("LeftArm");
		this.RightThigh = Hips.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
		this.LeftThigh = Hips.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
		this.Tail1 = Hips.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createHipsLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Hips = partdefinition.addOrReplaceChild("Hips", CubeListBuilder.create().texOffs(106, 39).addBox(-12.5F, -39.0F, -1.0F, 25.0F, 39.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition Chest = Hips.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(115, 134).addBox(-10.5F, -18.0F, -23.0F, 21.0F, 36.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.0F, 0.0F));

		PartDefinition Neck = Chest.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -8.0F, -21.0F, 11.0F, 16.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -22.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 37).addBox(-6.5F, -5.0F, -7.0F, 13.0F, 11.0F, 12.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -3.0F, -20.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(72, 176).addBox(-3.5F, -4.0F, -14.0F, 7.0F, 9.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -7.0F));

		PartDefinition Beak = Snout.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(180, 122).addBox(-10.0F, -7.0F, -1.0F, 11.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(4.75F, 7.0F, -14.0F));

		PartDefinition NeckDorsalSpines = Neck.addOrReplaceChild("NeckDorsalSpines", CubeListBuilder.create().texOffs(38, 23).addBox(1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -8.0F, -14.0F));

		PartDefinition LeftArm = Chest.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 79).mirror().addBox(0.0F, -9.0F, -5.0F, 7.0F, 44.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.5F, 14.0F, -16.0F));

		PartDefinition RightArm = Chest.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 79).addBox(-7.0F, -9.0F, -5.0F, 7.0F, 44.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, 14.0F, -16.0F));

		PartDefinition ChestDorsalSpines = Chest.addOrReplaceChild("ChestDorsalSpines", CubeListBuilder.create().texOffs(0, 38).addBox(0.0F, -20.0F, -23.0F, 0.0F, 2.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftThigh = Hips.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 157).addBox(-8.0F, -12.0F, -11.0F, 14.0F, 34.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(10.5F, -20.0F, 24.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(112, 0).addBox(-3.0F, -1.0F, -5.0F, 8.0F, 26.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 22.0F, 4.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(50, 157).addBox(-4.5F, 0.0F, -10.0F, 9.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 25.0F, 0.0F));

		PartDefinition RightThigh = Hips.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 157).addBox(-8.0F, -12.0F, -11.0F, 14.0F, 34.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.5F, -20.0F, 24.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(112, 0).addBox(-3.0F, -1.0F, -5.0F, 8.0F, 26.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 22.0F, 4.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(50, 157).addBox(-4.5F, 0.0F, -10.0F, 9.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 25.0F, 0.0F));

		PartDefinition Tail1 = Hips.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 79).addBox(-7.5F, -11.0F, -1.0F, 15.0F, 24.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -27.0F, 39.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -9.0F, -1.0F, 7.0F, 13.0F, 66.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 53.0F));

		PartDefinition Tail2DorsalSpines = Tail2.addOrReplaceChild("Tail2DorsalSpines", CubeListBuilder.create().texOffs(84, 57).addBox(1.0F, -2.0F, -1.0F, 0.0F, 2.0F, 61.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -9.0F, 2.0F));

		PartDefinition Tail1DorsalSpines = Tail1.addOrReplaceChild("Tail1DorsalSpines", CubeListBuilder.create().texOffs(84, 67).addBox(0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 53.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 1.0F));

		PartDefinition HipsDorsalSpines = Hips.addOrReplaceChild("HipsDorsalSpines", CubeListBuilder.create().texOffs(84, 84).addBox(0.0F, -41.0F, 0.0F, 0.0F, 2.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Edmontosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick) * 2.0F;
		int wakingProgress = entity.getWakingTicks();
		if (!entity.isWakingUp() && !entity.isFallingAsleep()) {
			if (!entity.isSleeping()) {
				resetModel();
			} else {
				this.LeftFoot.xRot = 1.5707963267948966F;
				this.RightArm.xRot = -1.2915436464758039F;
				this.RightArm.yRot = -0.3490658503988659F;
				this.Tail2.xRot = 0.16929693411449862F;
				this.Tail2.yRot = 0.35185837453889574F;
				this.Tail2.zRot = 0.1563815016444822F;
				this.RightThigh.xRot = -0.8726646259971648F;
				this.RightThigh.yRot = 0.23457224414434488F;
				this.Neck.xRot = 0.27366763203903305F;
				this.Neck.yRot = -0.5473352640780661F;
				this.LeftThigh.xRot = -0.8726646259971648F;
				this.LeftThigh.yRot = -0.23457224414434488F;
				this.RightFoot.xRot = 1.5707963267948966F;
				this.Neck.xRot = -0.007330382629510778F;
				this.LeftLeg.xRot =-0.6981317007977318F;
				this.Tail1.xRot = -0.5141739816585629F;
				this.Tail1.yRot = 0.35185837453889574F;
				this.LeftArm.xRot = -1.0557496272471145F;
				this.LeftArm.yRot = -0.03909537541112055F;
				this.LeftArm.zRot = -0.4300491170387584F;
				this.RightLeg.xRot = -0.6981317007977318F;
				this.Hips.y = 1;
				this.LeftThigh.y = 4;
				this.LeftThigh.z = 14;
				this.LeftLeg.y = 15.3F;
				this.LeftLeg.z = 8;
				this.LeftFoot.y = 15;
				this.LeftFoot.z = 1;
				this.RightThigh.y = 4;
				this.RightThigh.z = 14;
				this.RightLeg.y = 15.3F;
				this.RightLeg.z = 8;
				this.RightFoot.y = 15;
				this.RightFoot.z = 1;
				this.RightArm.y = 12;
				this.LeftArm.y = 12;
			}
		}
		if (wakingProgress != 0) {
			//LeftFoot
//			this.LeftFoot.y = 14;
			if (this.LeftFoot.y > 14) this.LeftFoot.y -= 0.15;
			if (this.LeftFoot.xRot > 0) this.LeftFoot.xRot -= 0.05;
			//RightArm
//			this.RightArm.y = -3;
			if (this.RightArm.y > -3) this.RightArm.y -= 0.15;
			if (this.RightArm.xRot < 0) this.RightArm.xRot += 0.05;
			if (this.RightArm.yRot < 0) this.RightArm.yRot += 0.05;
			//Tail2
			if (this.Tail2.xRot > 0) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot > 0) this.Tail2.yRot -= 0.05;
			if (this.Tail2.zRot > 0) this.Tail2.zRot -= 0.05;
			//RightThigh
//			this.RightThigh.y = -10;
//			this.RightThigh.z = 10;
			if (this.RightThigh.y > -10) this.RightThigh.y -= 0.15;
			if (this.RightThigh.z > 10) this.RightThigh.z -= 0.15;
			if (this.RightThigh.xRot < 0) this.RightThigh.xRot += 0.05;
			if (this.RightThigh.yRot > 0) this.RightThigh.yRot -= 0.05;
			//Neck
			if (this.Neck.xRot > 0) this.RightThigh.xRot -= 0.05;
			if (this.Neck.yRot < 0) this.RightThigh.yRot += 0.05;
			//LeftThigh
//			this.LeftThigh.y = -10;
//			this.LeftThigh.z = 10;
			if (this.LeftThigh.y > -10) this.LeftThigh.y -= 0.15;
			if (this.LeftThigh.z > 10) this.LeftThigh.z -= 0.15;
			if (this.LeftThigh.xRot < 0) this.LeftThigh.xRot += 0.05;
			if (this.LeftThigh.yRot < 0) this.LeftThigh.yRot += 0.05;
			//RightFoot
//			this.RightFoot.y = 14;
			if (this.RightFoot.y > 14) this.RightFoot.y -= 0.15;
			if (this.RightFoot.xRot > 0) this.RightFoot.xRot -= 0.05;
			//Head
			if (this.Neck.xRot < 0) this.Neck.xRot += 0.05;
			//LeftLeg
//			this.LeftLeg.y = 17;
//			this.LeftLeg.z = 6;
			if (this.LeftLeg.y < 17) this.LeftLeg.y += 0.15;
			if (this.LeftLeg.z > 6) this.LeftLeg.z -= 0.15;
			if (this.LeftLeg.xRot < 0) this.LeftLeg.xRot += 0.05;
			//Tail1
			if (this.Tail1.xRot < 0) this.Tail1.xRot += 0.05;
			if (this.Tail1.yRot > 0) this.Tail1.yRot -= 0.05;
			//LeftArm
//			this.LeftArm.y = -3;
			if (this.LeftArm.y > -3) this.LeftArm.y -= 0.15;
			if (this.LeftArm.xRot < 0) this.LeftArm.xRot += 0.05;
			if (this.LeftArm.yRot < 0) this.LeftArm.yRot += 0.05;
			if (this.LeftArm.zRot < 0) this.LeftArm.zRot += 0.05;
			//RightLeg
//			this.RightLeg.y = 17;
//			this.RightLeg.z = 6;
			if (this.RightLeg.y < 17) this.RightLeg.y += 0.15;
			if (this.RightLeg.z > 6) this.RightLeg.z -= 0.15;
			if (this.RightLeg.xRot < 0) this.RightLeg.xRot += 0.05;
			//Hips
//			this.Hips.y = -14;
			if (this.Hips.y > -14) this.Hips.y -= 0.15;
		}
		if (entity.isAsleep()) {
				//LeftFoot
//				this.LeftFoot.y = 14;
				if (this.LeftFoot.y < 15) this.LeftFoot.y += 0.15;
				if (this.LeftFoot.xRot < 1.5707963267948966F) this.LeftFoot.xRot += 0.05;
				//RightArm
//				this.RightArm.y = -3;
				if (this.RightArm.y < 12) this.RightArm.y += 0.15;
				if (this.RightArm.xRot > -1.2915436464758039F) this.RightArm.xRot -= 0.05;
				if (this.RightArm.yRot > -0.3490658503988659F) this.RightArm.yRot -= 0.05;
				//Tail2
				if (this.Tail2.xRot < 0.16929693411449862F) this.Tail2.xRot += 0.05;
				if (this.Tail2.yRot < 0.35185837453889574F) this.Tail2.yRot += 0.05;
				if (this.Tail2.zRot < 0.1563815016444822F) this.Tail2.zRot += 0.05;
				//RightThigh
//				this.RightThigh.y = -10;
//				this.RightThigh.z = 10;
				if (this.RightThigh.y < 4) this.RightThigh.y += 0.15;
				if (this.RightThigh.z < 14) this.RightThigh.z += 0.15;
				if (this.RightThigh.xRot > -0.8726646259971648F) this.RightThigh.xRot -= 0.05;
				if (this.RightThigh.yRot < 0.23457224414434488F) this.RightThigh.yRot += 0.05;
				//Neck
				if (this.Neck.xRot < 0.27366763203903305F) this.RightThigh.xRot += 0.05;
				if (this.Neck.yRot > -0.5473352640780661F) this.RightThigh.yRot -= 0.05;
				//LeftThigh
//				this.LeftThigh.y = -10;
//				this.LeftThigh.z = 10;
				if (this.LeftThigh.y < 4) this.LeftThigh.y += 0.15;
				if (this.LeftThigh.z < 24) this.LeftThigh.z += 0.15;
				if (this.LeftThigh.xRot > -0.8726646259971648F) this.LeftThigh.xRot -= 0.05;
				if (this.LeftThigh.yRot > -0.23457224414434488F) this.LeftThigh.yRot -= 0.05;
				//RightFoot
//				this.RightFoot.y = 14;
				if (this.RightFoot.y < 15) this.RightFoot.y += 0.15;
				if (this.RightFoot.xRot < 1.5707963267948966F) this.RightFoot.xRot += 0.05;
				//Head
				if (this.Neck.xRot > -0.007330382629510778F) this.Neck.xRot -= 0.05;
				//LeftLeg
//				this.LeftLeg.y = 17;
//				this.LeftLeg.z = 6;
				if (this.LeftLeg.y > 15.3) this.LeftLeg.y -= 0.15;
				if (this.LeftLeg.z < 8) this.LeftLeg.z += 0.15;
				if (this.LeftLeg.xRot > -0.6981317007977318F) this.LeftLeg.xRot -= 0.05;
				//Tail1
				if (this.Tail1.xRot > -0.5141739816585629F) this.Tail1.xRot -= 0.05;
				if (this.Tail1.yRot < 0.35185837453889574F) this.Tail1.yRot += 0.05;
				//LeftArm
//				this.LeftArm.y = -3;
				if (this.LeftArm.y < 12) this.LeftArm.y += 0.15;
				if (this.LeftArm.xRot > -1.0557496272471145F) this.LeftArm.xRot -= 0.05;
				if (this.LeftArm.yRot > -0.03909537541112055F) this.LeftArm.yRot -= 0.05;
				if (this.LeftArm.zRot > -0.4300491170387584F) this.LeftArm.zRot -= 0.05;
				//RightLeg
//				this.RightLeg.y = 17;
//				this.RightLeg.z = 6;
				if (this.RightLeg.y > 15.3) this.RightLeg.y -= 0.15;
				if (this.RightLeg.z < 8) this.RightLeg.z += 0.15;
				if (this.RightLeg.xRot > -0.6981317007977318F) this.RightLeg.xRot -= 0.05;
				//Hips
//				this.Hips.y = -7.0F;
				if (this.Hips.y > -12) this.Hips.y += 0.15;
		} else {
			this.RightArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount + attackProgress * (float) Math.toRadians(15F);
			this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount + attackProgress * (float) Math.toRadians(15F);
			this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + attackProgress * (float) Math.toRadians(7F);
			this.LeftLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
			this.LeftFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
			this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + attackProgress * (float) Math.toRadians(7F);
			this.RightLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
			this.RightFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
			this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.05F * limbSwingAmount);
			this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.15F * limbSwingAmount);
			this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount);
			this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount);
			this.Hips.xRot = 0;
			this.Neck.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.15F) + attackProgress * (float) Math.toRadians(25F);
			this.Hips.z = 4.0F + attackProgress * -8F;
			this.RightArm.z = -14.0F + attackProgress * -6F;
			this.LeftArm.z = -14.0F + attackProgress * -6F;
			this.RightThigh.z = 24.0F + attackProgress * -6F;
			this.LeftThigh.z = 24.0F + (attackProgress * -6F);
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.25F) + 0.15F;
				this.Hips.xRot = 0.1F;
			}
			if (entity.isInWater()) {
				this.Hips.y = 8;
				this.LeftThigh.y = 12;
				this.RightThigh.y = 12;
				this.LeftArm.y = 19;
				this.RightArm.y = 19;
				this.LeftThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.RightFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.Neck.xRot = -0.35F;
				this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}
	
	public void resetModel() {
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.Neck.xRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.LeftFoot.zRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.zRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.zRot = 0;
		this.Hips.y = -7.0F;
		this.LeftThigh.y = -20;
		this.LeftThigh.z = 24;
		this.LeftLeg.y = 22;
		this.LeftLeg.z = 4;
		this.LeftFoot.y = 25;
		this.RightThigh.y = -20;
		this.RightThigh.z = 24;
		this.RightLeg.y = 22;
		this.RightLeg.z = 4;
		this.RightFoot.y = 25;
		this.RightArm.y = 14;
		this.LeftArm.y = 14;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Hips.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}