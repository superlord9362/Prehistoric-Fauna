package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Plesiohadros;

public class PlesiohadrosBabyModel extends EntityModel<Plesiohadros> {
	private final ModelPart Torso;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart TailBase;
	private final ModelPart RForeleg;
	private final ModelPart LForeleg;
	private final ModelPart RLeg;
	private final ModelPart RLeg2;
	private final ModelPart LLeg;
	private final ModelPart LLeg2;

	public PlesiohadrosBabyModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.Neck = Torso.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.TailBase = Torso.getChild("TailBase");
		this.RForeleg = root.getChild("RForeleg");
		this.LForeleg = root.getChild("LForeleg");
		this.RLeg = root.getChild("RLeg");
		this.RLeg2 = RLeg.getChild("RLeg2");
		this.LLeg = root.getChild("LLeg");
		this.LLeg2 = LLeg.getChild("LLeg2");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, -6.0F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(21, 1).addBox(-1.0F, -1.5F, -5.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.0698F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(20, 18).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.6F, -3.0F));

		PartDefinition part5 = Head.addOrReplaceChild("part5", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -4.0F));

		PartDefinition TailBase = Torso.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(0, 26).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.1F, 11.0F));

		PartDefinition Spines_1 = TailBase.addOrReplaceChild("Spines_1", CubeListBuilder.create().texOffs(17, 17).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition Spines = Torso.addOrReplaceChild("Spines", CubeListBuilder.create().texOffs(17, 20).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.8F));

		PartDefinition RForeleg = partdefinition.addOrReplaceChild("RForeleg", CubeListBuilder.create().texOffs(12, 18).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 19.0F, -4.0F));

		PartDefinition LForeleg = partdefinition.addOrReplaceChild("LForeleg", CubeListBuilder.create().texOffs(12, 18).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 19.0F, -4.0F));

		PartDefinition RLeg = partdefinition.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, -2.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 17.0F, 2.0F));

		PartDefinition RLeg2 = RLeg.addOrReplaceChild("RLeg2", CubeListBuilder.create().texOffs(0, 29).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 2.0F));

		PartDefinition LLeg = partdefinition.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 17.0F, 2.0F));

		PartDefinition LLeg2 = LLeg.addOrReplaceChild("LLeg2", CubeListBuilder.create().texOffs(0, 29).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 39, 42);
	}

	@Override
	public void setupAnim(Plesiohadros entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick) * 2.0F;
		resetModel();
		if (entity.isAsleep()) {
			//Neck
			if (this.Neck.y < 2F) this.Neck.y += 0.15;
			if (this.Neck.xRot < 0.5235987755982988F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot > -0.3490658503988659F) this.Neck.yRot -= 0.05;
			//RLeg
			//this.RLeg.y = 19.5F;
			//this.RLeg.x = -3;
			//this.RLeg.z = -1;
			if (this.RLeg.x < -3F) this.RLeg.y += 0.15;
			if (this.RLeg.y < 19.5F) this.RLeg.y += 0.15;
			if (this.RLeg.z < -1F) this.RLeg.z += 0.15;
			if (this.RLeg.xRot > -0.7330382858376184F) this.RLeg.xRot -= 0.05;
			if (this.RLeg.yRot < 0.5585053606381855F) this.RLeg.yRot += 0.05;
			//Head
			if (this.Head.xRot > -0.4974188368183839F) this.Head.xRot -= 0.05;
			//LForeleg
			if (this.LForeleg.y < 22F) this.LForeleg.y += 0.15;
			if (this.LForeleg.xRot > -0.7330382858376184F) this.LForeleg.xRot -= 0.05;
			if (this.LForeleg.zRot > -0.9075712110370513F) this.LForeleg.zRot -= 0.05;
			//LLeg2
			if (this.LLeg2.y < 4F) this.LLeg2.y += 0.15;
			if (this.LLeg2.xRot > -0.8377580409572781F) this.LLeg2.xRot -= 0.05;
			//RForeleg
			if (this.RForeleg.y < 22F) this.RForeleg.y += 0.15;
			if (this.RForeleg.xRot > -1.3962634015954636F) this.RForeleg.xRot -= 0.05;
			if (this.RForeleg.yRot < 0.13962634015954636F) this.RForeleg.yRot += 0.05;
			if (this.RForeleg.zRot > -0.13962634015954636F) this.RForeleg.zRot -= 0.05;
			//RLeg2
			if (this.RLeg2.y < 4F) this.RLeg2.y += 0.15;
			if (this.RLeg2.xRot > -0.8377580409572781F) this.RLeg2.xRot -= 0.05;
			//Torso
			//this.Torso.y = 17;
			if (this.Torso.y < 17F) this.Torso.y += 0.15;
			if (this.Torso.xRot < 0.17453292519943295F) this.Torso.xRot += 0.05;
			//TailBase
			if (this.TailBase.z > 10.5F) this.TailBase.z -= 0.15;
			if (this.TailBase.xRot > -0.5585053606381855F) this.TailBase.xRot -= 0.05;
			if (this.TailBase.yRot < 0.41887902047863906F) this.TailBase.yRot += 0.05;
			//LLeg
			//this.LLeg.y = 19.5F;
			//this.LLeg.x = 3;
			//this.LLeg.z = -1;
			if (this.LLeg.x < 3F) this.LLeg.x += 0.15;
			if (this.LLeg.y < 19.5F) this.LLeg.y += 0.15;
			if (this.LLeg.z < -1F) this.LLeg.z += 0.15;
			if (this.LLeg.xRot > -0.7330382858376184F) this.LLeg.xRot -= 0.05;
			sleepPose();
		} else {
			this.LForeleg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount + attackProgress * (float) Math.toRadians(15F);
			this.RForeleg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount + attackProgress * (float) Math.toRadians(15F);
			this.RLeg.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + attackProgress * (float) Math.toRadians(7F);
			this.RLeg2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
			this.LLeg.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + attackProgress * (float) Math.toRadians(7F);
			this.LLeg2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
			this.TailBase.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount);
			this.TailBase.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
			this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F);
			this.Head.xRot = attackProgress * (float) Math.toRadians(25F);
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
				this.Torso.xRot = 0.2F;
				this.LForeleg.zRot = -0.2F;
				this.RForeleg.zRot = 0.2F;
			}
			if (entity.isInWater()) {
				this.Torso.y = 17;
				this.LLeg.y = 17;
				this.RLeg.y = 17;
				this.LForeleg.y = 24;
				this.RForeleg.y = 24;
				this.LLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RForeleg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LForeleg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Neck.xRot = -0.125F;
				this.TailBase.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Neck
			if (this.Neck.y > 2.5F) this.Neck.y -= 0.15;
			if (this.Neck.xRot > 0.0698F) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot < 0) this.Neck.yRot += 0.05;
			//RLeg
			if (this.RLeg.x > 2.5F) this.RLeg.y -= 0.15;
			if (this.RLeg.y > 17F) this.RLeg.y -= 0.15;
			if (this.RLeg.z > -2F) this.RLeg.z -= 0.15;
			if (this.RLeg.xRot < 0) this.RLeg.xRot += 0.05;
			if (this.RLeg.yRot > 0) this.RLeg.yRot -= 0.05;
			//Head
			if (this.Head.xRot < 0) this.Head.xRot += 0.05;
			//LForeleg
			if (this.LForeleg.y > 19F) this.LForeleg.y -= 0.15;
			if (this.LForeleg.xRot < 0) this.LForeleg.xRot += 0.05;
			if (this.LForeleg.zRot < 0) this.LForeleg.zRot += 0.05;
			//LLeg2
			if (this.LLeg2.y > 4F) this.LLeg2.y += 0.15;
			if (this.LLeg2.xRot < 0) this.LLeg2.xRot -= 0.05;
			//RForeleg
			if (this.RForeleg.y > 19F) this.RForeleg.y -= 0.15;
			if (this.RForeleg.xRot < 0) this.RForeleg.xRot += 0.05;
			if (this.RForeleg.yRot > 0) this.RForeleg.yRot -= 0.05;
			if (this.RForeleg.zRot < 0) this.RForeleg.zRot += 0.05;
			//RLeg2
			if (this.RLeg2.y > 4F) this.RLeg2.y -= 0.15;
			if (this.RLeg2.xRot < 0) this.RLeg2.xRot += 0.05;
			//Torso
			if (this.Torso.y > 13F) this.Torso.y -= 0.15;
			if (this.Torso.xRot > 0) this.Torso.xRot -= 0.05;
			//TailBase
			if (this.TailBase.z < 11.5F) this.TailBase.z += 0.15;
			if (this.TailBase.xRot < 0) this.TailBase.xRot += 0.05;
			if (this.TailBase.yRot > 0) this.TailBase.yRot -= 0.05;
			//LLeg
			if (this.LLeg.x > -2.5) this.LLeg.x -= 0.15;
			if (this.LLeg.y > 17) this.LLeg.y -= 0.15;
			if (this.LLeg.z > -2F) this.LLeg.z -= 0.15;
			if (this.LLeg.xRot < 0) this.LLeg.xRot += 0.05;
		}
	}

	public void resetModel() {
		//Neck
		this.Neck.y = 2.5F;
		this.Neck.xRot = 0.0698F;
		this.Neck.yRot = 0;
		//RLeg
		this.RLeg.x = 2.5F;
		this.RLeg.y = 17;
		this.RLeg.z = 2;
		this.RLeg.xRot = 0;
		this.RLeg.yRot = 0;
		//Head
		this.Head.xRot = 0;
		//LForeleg
		this.LForeleg.z = -4F;
		this.LForeleg.y = 19;
		this.LForeleg.xRot = 0;
		this.LForeleg.zRot = 0;
		//LLeg2
		this.LLeg2.y = 4;
		this.LLeg2.xRot = 0;
		//RForeleg
		this.RForeleg.z = -4F;
		this.RForeleg.y = 19;
		this.RForeleg.xRot = 0;
		this.RForeleg.yRot = 0;
		this.RForeleg.zRot = 0;
		//RLeg2
		this.RLeg2.y = 4;
		this.RLeg2.xRot = 0;
		//Torso
		this.Torso.y = 13;
		this.Torso.xRot = 0;
		//TailBase
		this.TailBase.y = 1.5F;
		this.TailBase.z = 11.5F;
		this.TailBase.xRot = 0;
		this.TailBase.yRot = 0;
		//LLeg
		this.LLeg.x = -2.5F;
		this.LLeg.y = 17;
		this.LLeg.z = 2;
		this.LLeg.xRot = 0;
	}

	public void sleepPose() {
		this.Torso.y = 17;
		this.LLeg.y = 19.5F;
		this.LLeg.x = 3;
		this.LLeg.z = -1;
		this.RLeg.y = 19.5F;
		this.RLeg.x = -3;
		this.RLeg.z = -1;
		this.LForeleg.y = 22;
		this.RForeleg.y = 22;
		this.LLeg2.y = 4F;
		this.RLeg2.y = 4;
		this.TailBase.z = 10.5F;
		this.Neck.y = 2F;
		this.Neck.xRot = 0.5235987755982988F;
		this.Neck.yRot = -0.3490658503988659F;
		this.RLeg.xRot = -0.7330382858376184F;
		this.RLeg.yRot = 0.5585053606381855F;
		this.Head.xRot = -0.4974188368183839F;
		this.LForeleg.xRot = -0.7330382858376184F;
		this.LForeleg.zRot = -0.9075712110370513F;
		this.RForeleg.xRot = -1.3962634015954636F;
		this.RForeleg.yRot = 0.13962634015954636F;
		this.RForeleg.zRot = -0.13962634015954636F;
		this.RLeg2.xRot = -0.8377580409572781F;
		this.LLeg2.xRot = -0.8377580409572781F;
		this.Torso.xRot = 0.17453292519943295F;
		this.TailBase.xRot = -0.5585053606381855F;
		this.TailBase.yRot = 0.41887902047863906F;
		this.LLeg.xRot = -0.7330382858376184F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RForeleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LForeleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}