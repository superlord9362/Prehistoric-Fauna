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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Edmontosaurus;

public class EdmontosaurusJuvenileModel extends EntityModel<Edmontosaurus> {
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Body1;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Body2;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;

	public EdmontosaurusJuvenileModel(ModelPart root) {
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.Body1 = root.getChild("Body1");
		this.Neck = this.Body1.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Body2 = this.Body1.getChild("Body2");
		this.Tail1 = this.Body2.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.RightThigh = root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.LeftThigh = root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(38, 79).addBox(0.0F, -2.0F, -2.0F, 3.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 5.0F, -11.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(52, 79).addBox(-3.0F, -2.0F, -2.0F, 3.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 5.0F, -11.0F));

		PartDefinition Body1 = partdefinition.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(76, 0).addBox(-6.0F, -5.0F, -6.0F, 12.0F, 18.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(106, 30).addBox(0.0F, -6.0F, -6.0F, 0.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -10.0F));

		PartDefinition Neck = Body1.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(1, 116).addBox(-3.0F, -4.0F, -11.0F, 5.0F, 9.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(128, 43).addBox(-0.5F, -5.0F, -6.0F, 0.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 3.0F, -6.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(76, 30).addBox(-4.0F, -2.01F, -3.0F, 7.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -11.0F));

		PartDefinition Beak = Head.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(100, 127).addBox(-3.0F, -3.0F, -6.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(122, 127).addBox(-4.0F, -1.0F, -7.0F, 7.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -3.0F));

		PartDefinition Body2 = Body1.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -7.0F, -4.0F, 14.0F, 20.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(106, 78).addBox(0.0F, -8.0F, -4.0F, 0.0F, 1.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 10.0F));

		PartDefinition Tail1 = Body2.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(68, 44).addBox(-4.0F, -4.9249F, -0.7445F, 8.0F, 12.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(38, 114).addBox(0.0F, -5.9249F, -0.7445F, 0.0F, 1.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 20.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 44).addBox(-3.0039F, -2.8544F, -0.7518F, 6.0F, 7.0F, 28.0F, new CubeDeformation(0.0F))
		.texOffs(106, 103).addBox(0.0F, -3.8544F, 1.2482F, 0.0F, 1.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.8805F, 19.9914F, 0.087F, 0.0F, 0.0F));

		PartDefinition RightThigh = partdefinition.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(68, 78).addBox(-1.0F, -8.0F, -5.0F, 5.0F, 22.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -2.0F, 8.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(82, 114).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 14.0F, 6.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(38, 104).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.1F));

		PartDefinition LeftThigh = partdefinition.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 79).addBox(-4.0F, -8.0F, -5.0F, 5.0F, 22.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -2.0F, 8.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(124, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 14.0F, 6.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(124, 16).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.1F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Edmontosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick) * 2.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				//RightArm
				this.RightArm.y = Mth.lerp(sleepProgress, 5, 20);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.3962634015954636F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.13962634015954636F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.13962634015954636F);
				//LeftArm
				this.LeftArm.y = Mth.lerp(sleepProgress, 5, 18);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.2330382858376184F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.4575712110370513F);
				//Body1
				this.Body1.y = Mth.lerp(sleepProgress, -5, 9);
				this.Body1.xRot = Mth.lerp(sleepProgress, 0, 0.17453292519943295F);
				//Neck
				this.Neck.y = Mth.lerp(sleepProgress, 0, 1.5F);
				this.Neck.z = Mth.lerp(sleepProgress, -6, -4);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.5235987755982988F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -0.3490658503988659F);
				//Head
				this.Head.xRot = Mth.lerp(sleepProgress, 0, -0.4974188368183839F);
				//Body2
				this.Body2.z = Mth.lerp(sleepProgress, 10, 8);
				this.Body2.xRot = Mth.lerp(sleepProgress, 0, -0.17453292519943295F);
				this.Body2.yRot = Mth.lerp(sleepProgress, 0, 0.3490658503988659F);
				//Tail1
				this.Tail1.z = Mth.lerp(sleepProgress, 19, 16.5F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.1309F, -0.5585053606381855F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, 0.41887902047863906F);
				//Tail2
				this.Tail2.y = Mth.lerp(sleepProgress, -1.8805F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.087F, 0.41887902047863906F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, 0.593411945678072F);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0, 0.10471975511965977F);
				//RightThigh
				this.RightThigh.x = Mth.lerp(sleepProgress, 5, 9);
				this.RightThigh.y = Mth.lerp(sleepProgress, -2, 11);
				this.RightThigh.z = Mth.lerp(sleepProgress, 8, 4);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.7330382858376184F);
				//RightLeg
				this.RightLeg.y = Mth.lerp(sleepProgress, 14, 10.9F);
				this.RightLeg.z = Mth.lerp(sleepProgress, 6, 4F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.8377580409572781F);
				//RightFoot
				this.RightFoot.z = Mth.lerp(sleepProgress, 0.1F, 1F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
				//LeftThigh
				this.LeftThigh.x = Mth.lerp(sleepProgress, -5, -3);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -2, 10);
				this.LeftThigh.z = Mth.lerp(sleepProgress, 7, 7);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.7330382858376184F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.5585053606381855F);
				//LeftLeg
				this.LeftLeg.y = Mth.lerp(sleepProgress, 14, 10.9F);
				this.LeftLeg.z = Mth.lerp(sleepProgress, 6, 4F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.8377580409572781F);
				//LeftFoot
				this.LeftFoot.z = Mth.lerp(sleepProgress, 0.1F, 1F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5707963267948966F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				//RightArm
				this.RightArm.y = Mth.lerp(sleepProgress, 20, 5);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.3962634015954636F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.13962634015954636F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.13962634015954636F, 0);
				//LeftArm
				this.LeftArm.y = Mth.lerp(sleepProgress, 18, 5);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.2330382858376184F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.4575712110370513F, 0);
				//Body1
				this.Body1.y = Mth.lerp(sleepProgress, 9, -5);
				this.Body1.xRot = Mth.lerp(sleepProgress, 0.17453292519943295F, 0);
				//Neck
				this.Neck.y = Mth.lerp(sleepProgress, 1.5F, 0);
				this.Neck.z = Mth.lerp(sleepProgress, -4, -6);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.5235987755982988F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, -0.3490658503988659F, 0);
				//Head
				this.Head.xRot = Mth.lerp(sleepProgress, -0.4974188368183839F, 0);
				//Body2
				this.Body2.z = Mth.lerp(sleepProgress, 8, 10);
				this.Body2.xRot = Mth.lerp(sleepProgress, -0.17453292519943295F, 0);
				this.Body2.yRot = Mth.lerp(sleepProgress, 0.3490658503988659F, 0);
				//Tail1
				this.Tail1.z = Mth.lerp(sleepProgress, 16.5F, 19);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.5585053606381855F, -0.1309F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0.41887902047863906F, 0);
				//Tail2
				this.Tail2.y = Mth.lerp(sleepProgress, 0, -1.8805F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.41887902047863906F, 0.087F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0.593411945678072F, 0);
				this.Tail2.zRot = Mth.lerp(sleepProgress, 0.10471975511965977F, 0);
				//RightThigh
				this.RightThigh.x = Mth.lerp(sleepProgress, 9, 5);
				this.RightThigh.y = Mth.lerp(sleepProgress, 11, -2);
				this.RightThigh.z = Mth.lerp(sleepProgress, 4, 8);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.7330382858376184F, 0);
				//RightLeg
				this.RightLeg.y = Mth.lerp(sleepProgress, 10.9F, 14F);
				this.RightLeg.z = Mth.lerp(sleepProgress, 4, 6F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.8377580409572781F, 0);
				//RightFoot
				this.RightFoot.z = Mth.lerp(sleepProgress, 1F, 0.1F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
				//LeftThigh
				this.LeftThigh.x = Mth.lerp(sleepProgress, -3, -5);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -10, -2);
				this.LeftThigh.z = Mth.lerp(sleepProgress, 7, 7);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.7330382858376184F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.5585053606381855F, 0);
				//LeftLeg
				this.LeftLeg.y = Mth.lerp(sleepProgress, 10.9F, 14F);
				this.LeftLeg.z = Mth.lerp(sleepProgress, 4, 6F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.8377580409572781F, 0);
				//LeftFoot
				this.LeftFoot.z = Mth.lerp(sleepProgress, 1F, 0.1F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5707963267948966F, 0);
			} else {
				this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount + attackProgress * (float) Math.toRadians(15F);
				this.RightArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount + attackProgress * (float) Math.toRadians(15F);
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + attackProgress * (float) Math.toRadians(7F);
				this.RightLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.RightFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + attackProgress * (float) Math.toRadians(7F);
				this.LeftLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
				this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
				this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F);
				this.Head.xRot = attackProgress * (float) Math.toRadians(25F);
				this.Body1.z = -10.0F + attackProgress * -8F;
				this.RightArm.z = -11.0F + attackProgress * -6F;
				this.LeftArm.z = -11.0F + attackProgress * -6F;
				this.RightThigh.z = 8.0F + attackProgress * -6F;
				this.LeftThigh.z = 8.0F + attackProgress * -6F;
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
					this.Body1.xRot = 0.2F;
					this.LeftArm.zRot = -0.2F;
					this.RightArm.zRot = 0.2F;
				}
				if (entity.isInWater()) {
					this.Body1.y = 17;
					this.LeftThigh.y = 17;
					this.RightThigh.y = 17;
					this.LeftArm.y = 24;
					this.RightArm.y = 24;
					this.LeftThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.RightFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.RightArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Neck.xRot = -0.125F;
					this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
					this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.RightArm.y = 5;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.LeftArm.y = 5;
		this.LeftArm.xRot = 0;
		this.LeftArm.zRot = 0;
		this.Body1.y = -5;
		this.Body1.xRot = 0;
		this.Neck.y = 0;
		this.Neck.z = -6;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Head.xRot = 0;
		this.Body2.z = 10;
		this.Body2.xRot = 0;
		this.Body2.yRot = 0;
		this.Tail1.z = 19;
		this.Tail1.xRot = -0.1309F;
		this.Tail1.yRot = 0;
		this.Tail2.y = -1.8805F;
		this.Tail2.xRot = 0.087F;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.RightThigh.x = 5;
		this.RightThigh.y = -2;
		this.RightThigh.z = 8;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightLeg.y = 14;
		this.RightLeg.z = 6;
		this.RightLeg.xRot = 0;
		this.RightFoot.z = 0.1F;
		this.RightFoot.xRot = 0;
		this.LeftThigh.x = -5;
		this.LeftThigh.y = -2;
		this.LeftThigh.z = 7;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftLeg.y = 14;
		this.LeftLeg.z = 6F;
		this.LeftLeg.xRot = 0;
		this.LeftFoot.z = 0.1F;
		this.LeftFoot.xRot = 0;
	}

	public void sleepPose() {
		//RightArm
		this.RightArm.y = 20;
		this.RightArm.xRot = -1.3962634015954636F;
		this.RightArm.yRot = 0.13962634015954636F;
		this.RightArm.zRot = -0.13962634015954636F;
		//LeftArm
		this.LeftArm.y = 18;
		this.LeftArm.xRot = -1.2330382858376184F;
		this.LeftArm.zRot = -0.4575712110370513F;
		//Body1
		this.Body1.y = 9;
		this.Body1.xRot = 0.17453292519943295F;
		//Neck
		this.Neck.y = 1.5F;
		this.Neck.z = -4;
		this.Neck.xRot = 0.5235987755982988F;
		this.Neck.yRot = -0.3490658503988659F;
		//Head
		this.Head.xRot = -0.4974188368183839F;
		//Body2
		this.Body2.z = 8;
		this.Body2.xRot = -0.17453292519943295F;
		this.Body2.yRot = 0.3490658503988659F;
		//Tail1
		this.Tail1.z = 16.5F;
		this.Tail1.xRot = -0.5585053606381855F;
		this.Tail1.yRot = 0.41887902047863906F;
		//Tail2
		this.Tail2.y = 0;
		this.Tail2.xRot = 0.41887902047863906F;
		this.Tail2.yRot = 0.593411945678072F;
		this.Tail2.zRot = 0.10471975511965977F;
		//RightThigh
		this.RightThigh.x = 9;
		this.RightThigh.y = 11;
		this.RightThigh.z = 4;
		this.RightThigh.xRot = -0.7330382858376184F;
		//RightLeg
		this.RightLeg.y = 10.9F;
		this.RightLeg.z = 4F;
		this.RightLeg.xRot = -0.8377580409572781F;
		//RightFoot
		this.RightFoot.z = 1F;
		this.RightFoot.xRot = 1.5707963267948966F;
		//LeftThigh
		this.LeftThigh.x = -3;
		this.LeftThigh.y = 10;
		this.LeftThigh.z = 7;
		this.LeftThigh.xRot = -0.7330382858376184F;
		this.LeftThigh.yRot = 0.5585053606381855F;
		//LeftLeg
		this.LeftLeg.y = 10.9F;
		this.LeftLeg.z = 4F;
		this.LeftLeg.xRot = -0.8377580409572781F;
		//LeftFoot
		this.LeftFoot.z = 1F;
		this.LeftFoot.xRot = 1.5707963267948966F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
