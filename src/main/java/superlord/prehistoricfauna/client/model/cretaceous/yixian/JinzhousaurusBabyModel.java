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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Jinzhousaurus;

@SuppressWarnings("unused")
public class JinzhousaurusBabyModel extends EntityModel<Jinzhousaurus> {
	private final ModelPart Body;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart Tail;
	private final ModelPart Neck;
	private final ModelPart Head;

	public JinzhousaurusBabyModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftThigh = this.Body.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = this.Body.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.Tail = this.Body.getChild("Tail");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -7.0F, -1.0F, 6.0F, 7.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(18, 24).addBox(-2.0F, -8.0F, 0.0F, 0.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 19.0F, -4.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(23, 1).mirror().addBox(0.0F, 5.0F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -2.0F, 1.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(23, 1).addBox(0.0F, 5.0F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -2.0F, 1.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -3.0F, 7.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(18, 18).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 4.0F, 2.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(21, 0).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 18).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -3.0F, 7.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(18, 18).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 4.0F, 2.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(21, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(2, 18).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 24).addBox(0.0F, -2.0F, 1.0F, 0.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -5.0F, 10.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(23, 1).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 7).addBox(0.0F, -3.0F, -4.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -4.0F, -1.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(18, 18).addBox(-2.0F, -2.01F, -7.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(28, 26).addBox(-1.0F, -2.0F, -9.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 26).addBox(-1.5F, 0.0F, -9.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 41, 34);
	}

	@Override
	public void setupAnim(Jinzhousaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick) * 2.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 19, 23F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.15F, 0.2235987755982988F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, -0.3490658503988659F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.7330382858376184F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.2585053606381855F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.3330382858376184F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.2075712110370513F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.2962634015954636F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.13962634015954636F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.13962634015954636F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.9377580409572781F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.9377580409572781F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, 0.07453292519943295F);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.15F, -0.4585053606381855F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, 0.41887902047863906F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.58F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.58F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.7330382858376184F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.2585053606381855F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 23, 19F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.2235987755982988F, 0.15F);
				this.Neck.yRot = Mth.lerp(sleepProgress, -0.3490658503988659F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.7330382858376184F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.2585053606381855F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.3330382858376184F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.2075712110370513F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.2962634015954636F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.13962634015954636F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.13962634015954636F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.9377580409572781F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.9377580409572781F, 0);
				this.Body.xRot = Mth.lerp(sleepProgress, 0.07453292519943295F, 0);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.4585053606381855F, -0.15F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0.41887902047863906F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.58F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.58F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.7330382858376184F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.2585053606381855F, 0);
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
				if (entity.isEating()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
					this.Body.xRot = 0.2F;
					this.LeftArm.zRot = -0.2F;
					this.RightArm.zRot = 0.2F;
				}
				if (entity.isInWater()) {
					this.Body.y = 21;
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
	}

	public void resetModel() {
		//Neck
		this.Neck.y = -4F;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		//RightThigh
		this.RightThigh.x = 1F;
		this.RightThigh.y = -3F;
		this.RightThigh.z = 7;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		//Head
		//		this.Head.xRot = 0;
		//LeftArm
		this.LeftArm.y = -2;
		this.LeftArm.z = 1F;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		//LeftLeg
		this.LeftLeg.y = 4F;
		this.LeftLeg.xRot = 0;
		//RightArm
		this.RightArm.y = -2;
		this.RightArm.z = 1F;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		//RightLeg
		this.RightLeg.y = 4F;
		this.RightLeg.xRot = 0;
		//Body
		this.Body.y = 19F;
		this.Body.xRot = 0;
		//Tail
		//0.0F, -3.75F, 2.0F
		this.Tail.y = -5F;
		this.Tail.z = 10F;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		//LeftThigh
		//-2.0F, -9.5F, -3.0F
		this.LeftThigh.x = -5F;
		this.LeftThigh.y = -3F;
		this.LeftThigh.z = 7;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;

		this.LeftFoot.xRot = 0F;
		this.RightFoot.xRot = 0F;
	}

	public void sleepPose() {
		this.Body.y = 23F;
		this.Neck.xRot = 0.2235987755982988F;
		this.Neck.yRot = -0.3490658503988659F;
		this.RightThigh.xRot = -0.7330382858376184F;
		this.RightThigh.yRot = -0.2585053606381855F;
		this.LeftArm.xRot = -1.3330382858376184F;
		this.LeftArm.yRot = -0.2075712110370513F;
		this.RightArm.xRot = -1.2962634015954636F;
		this.RightArm.yRot = 0.13962634015954636F;
		this.RightArm.zRot = -0.13962634015954636F;
		this.RightLeg.xRot = -0.9377580409572781F;
		this.LeftLeg.xRot = -0.9377580409572781F;
		this.Body.xRot = 0.07453292519943295F;
		this.Tail.xRot = -0.4585053606381855F;
		this.Tail.yRot = 0.41887902047863906F;
		this.LeftFoot.xRot = 1.58F;
		this.RightFoot.xRot = 1.58F;
		this.LeftThigh.xRot = -0.7330382858376184F;
		this.LeftThigh.yRot = 0.2585053606381855F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}