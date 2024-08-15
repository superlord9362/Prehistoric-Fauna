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

public class EdmontosaurusBabyModel extends EntityModel<Edmontosaurus> {
	private final ModelPart Bone;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Neck;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	@SuppressWarnings("unused")
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	@SuppressWarnings("unused")
	private final ModelPart RightFoot;
	private final ModelPart Tail;

	public EdmontosaurusBabyModel(ModelPart root) {
		this.Bone = root.getChild("Bone");
		this.Body = Bone.getChild("Body");
		this.LeftArm = Body.getChild("LeftArm");
		this.RightArm = Body.getChild("RightArm");
		this.Neck = Body.getChild("Neck");
		this.Tail = Body.getChild("Tail");
		this.LeftThigh = Bone.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
		this.RightThigh = Bone.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Bone = partdefinition.addOrReplaceChild("Bone", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 6.0F));

		PartDefinition Body = Bone.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(51, 27).addBox(-3.0F, -4.5F, -10.0F, 6.0F, 7.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(24, 44).addBox(0.0F, -5.5F, -10.0F, 0.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.5F, -1.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(30, 28).mirror().addBox(-1.0F, -0.5F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 1.0F, -9.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(30, 28).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 1.0F, -9.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(26, 0).addBox(-1.5F, -0.5F, -6.0F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(56, 6).addBox(0.0F, -2.5F, -4.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -10.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -1.0F, -6.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 9).mirror().addBox(-2.5F, 0.0F, -6.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(8, 9).addBox(0.5F, 0.0F, -6.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(20, 20).addBox(-2.5F, -2.0F, -3.5F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 1.4F, -3.5F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 26).addBox(-1.0F, -0.75F, 0.0F, 2.0F, 4.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(24, 44).addBox(0.0F, -1.75F, 0.0F, 0.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.75F, 2.0F));

		PartDefinition RightThigh = Bone.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-2.0F, -0.5F, -1.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -9.5F, -3.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(3, 36).mirror().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 6.5F, 3.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(-3, 33).mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition LeftThigh = Bone.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 19).addBox(-1.0F, -0.5F, -1.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -9.5F, -3.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(3, 36).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 6.5F, 3.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(-3, 33).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 100, 100);
	}

	@Override
	public void setupAnim(Edmontosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick) * 2.0F;
		resetModel();
		if (entity.isAsleep()) {
			sleepPose();
		} else {
			this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount + attackProgress * (float) Math.toRadians(15F);
			this.RightArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount + attackProgress * (float) Math.toRadians(15F);
			this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + attackProgress * (float) Math.toRadians(7F);
			this.RightLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
			this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + attackProgress * (float) Math.toRadians(7F);
			this.LeftLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
			this.Tail.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
			this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
			this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F);
//			this.Head.xRot = attackProgress * (float) Math.toRadians(25F);
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
				this.Body.xRot = 0.2F;
				this.LeftArm.zRot = -0.2F;
				this.RightArm.zRot = 0.2F;
			}
			if (entity.isInWater()) {
				this.Body.y = 17;
				this.LeftThigh.y = 17;
				this.RightThigh.y = 17;
				this.LeftArm.y = 24;
				this.RightArm.y = 24;
				this.LeftThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Neck.xRot = -0.125F;
				this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		//Neck
		this.Neck.y = -3F;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		//RightThigh
		this.RightThigh.x = 3F;
		this.RightThigh.y = -9.5F;
		this.RightThigh.z = -3;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		//Head
//		this.Head.xRot = 0;
		//LeftArm
		this.LeftArm.z = -9F;
		this.LeftArm.y = 1;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		//LeftLeg
		this.LeftLeg.y = 6.5F;
		this.LeftLeg.xRot = 0;
		//RightArm
		this.RightArm.z = -9F;
		this.RightArm.y = 1;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		//RightLeg
		this.RightLeg.y = 6.5F;
		this.RightLeg.xRot = 0;
		//Body
		this.Body.y = -7.5F;
		this.Body.xRot = 0;
		//Tail
		//0.0F, -3.75F, 2.0F
		this.Tail.y = -3.75F;
		this.Tail.z = 2.0F;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		//LeftThigh
		//-2.0F, -9.5F, -3.0F
		this.LeftThigh.x = -3F;
		this.LeftThigh.y = -9.5F;
		this.LeftThigh.z = -3;
		this.LeftThigh.xRot = 0;
		

		this.LeftFoot.xRot = 0F;
		this.RightFoot.xRot = 0F;
	}

	public void sleepPose() {
		//0.0F, -7.5F, -1.0F
		this.Body.y = -4.5F;
		this.LeftThigh.y = -7F;
		this.LeftThigh.x = 2;
		this.LeftThigh.z = -2.5F;
		this.RightThigh.y = -7F;
		this.RightThigh.x = -2;
		this.RightThigh.z = -2.5F;
		this.LeftArm.y = -0.5F;
		this.RightArm.y = -0.5F;
		this.LeftLeg.y = 6.5F;
		this.RightLeg.y = 6.5F;
		this.Tail.z = 1F;
		this.Neck.y = -3F;
		this.Neck.xRot = 0.1235987755982988F;
		this.Neck.yRot = -0.3490658503988659F;
		this.RightThigh.xRot = -0.7330382858376184F;
		this.RightThigh.yRot = 0.2585053606381855F;
//		this.Head.xRot = -0.4974188368183839F;
		this.LeftArm.xRot = -1.4330382858376184F;
		this.LeftArm.yRot = -0.2075712110370513F;
		this.RightArm.xRot = -1.3962634015954636F;
		this.RightArm.yRot = 0.13962634015954636F;
		this.RightArm.zRot = -0.13962634015954636F;
		this.RightLeg.xRot = -0.8377580409572781F;
		this.LeftLeg.xRot = -0.8377580409572781F;
		this.Body.xRot = 0.17453292519943295F;
		this.Tail.xRot = -0.5585053606381855F;
		this.Tail.yRot = 0.41887902047863906F;
		this.LeftFoot.xRot = 1.58F;
		this.RightFoot.xRot = 1.58F;
		this.LeftThigh.xRot = -0.7330382858376184F;
		this.LeftThigh.yRot = -0.2585053606381855F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}