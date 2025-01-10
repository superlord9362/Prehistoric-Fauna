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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Udanoceratops;

public class UdanoceratopsBabyModel extends EntityModel<Udanoceratops> {
	private final ModelPart Body;
	private final ModelPart Head;
	private final ModelPart Tail;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public UdanoceratopsBabyModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Head = Body.getChild("Head");
		this.Tail = Body.getChild("Tail");
		this.LeftArm = Body.getChild("LeftArm");
		this.RightArm = Body.getChild("RightArm");
		this.LeftThigh = Body.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
		this.RightThigh = Body.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 10).addBox(-2.0F, -6.0F, -5.0F, 4.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 0.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -3.0F, -4.0F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 10).addBox(-1.5F, -2.0F, -6.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -5.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 26).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 5.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).mirror().addBox(-1.0F, 4.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, -1.0F, -3.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(-2.0F, 4.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -1.0F, -3.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(18, 7).addBox(0.0F, -1.0F, -1.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(18, 7).addBox(-1.0F, -1.0F, -1.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -2.0F, 2.5F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(38, 3).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 1.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(32, 0).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(18, 7).mirror().addBox(-1.0F, -1.0F, -1.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(18, 7).mirror().addBox(0.0F, -1.0F, -1.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -2.0F, 2.5F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(38, 3).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.0F, 1.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 2.0F, 0.0F));
		
		return LayerDefinition.create(meshdefinition, 57, 36);
	}

	@Override
	public void setupAnim(Udanoceratops entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick) * 2.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 21, 23);
				this.Tail.y = Mth.lerp(sleepProgress, -5, -4.5F);
				this.Head.z = Mth.lerp(sleepProgress, -5, -4F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, 0.15235987755982988F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, -0.3490658503988659F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.9330382858376184F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.2585053606381855F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.2330382858376184F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, -0.4575712110370513F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.6877580409572781F);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5877580409572781F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.3962634015954636F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.13962634015954636F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.13962634015954636F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.6877580409572781F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.5877580409572781F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, 0.057453292519943295F);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0, -0.5585053606381855F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, 0.41887902047863906F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.9330382858376184F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.2585053606381855F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 23, 21);
				this.Tail.y = Mth.lerp(sleepProgress, -4.5F, -5F);
				this.Head.z = Mth.lerp(sleepProgress, -4, -5F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0.15235987755982988F, 0);
				this.Head.yRot = Mth.lerp(sleepProgress, -0.3490658503988659F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.9330382858376184F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.2585053606381855F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.2330382858376184F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.4575712110370513F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.6877580409572781F, 0);
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.5877580409572781F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.3962634015954636F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.13962634015954636F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.13962634015954636F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.6877580409572781F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.5877580409572781F, 0);
				this.Body.xRot = Mth.lerp(sleepProgress, 0.057453292519943295F, 0);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.5585053606381855F, 0);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0.41887902047863906F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.9330382858376184F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.2585053606381855F, 0);
			} else {
				this.Head.xRot = 0;
				this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
				this.RightThigh.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
				this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
				this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
				this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
				this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
				this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount) + attackProgress * (float) Math.toRadians(25F);
				if (entity.isEating()) {
					this.Head.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.45F) + 0.15F;
				}
				if (entity.isInWater()) {
					this.Body.y = 9;
					this.Body.xRot = -0.125F;
					this.Tail.xRot = 0.0625F;
					this.LeftThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftArm.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightArm.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.Head.xRot = 0.125F;
					this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}
	
	public void resetModel() {
		this.Body.y = 21;
		this.Tail.y = -5;
		this.Head.z = -5;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.RightLeg.xRot = 0;
		this.Body.xRot = 0;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.LeftFoot.xRot = 0;
		this.RightFoot.xRot = 0;
	}

	public void sleepPose() {
		this.Body.y = 23;
		this.Tail.y = -4.5F;
		this.Head.z = -4F;
		this.Head.xRot = 0.15235987755982988F;
		this.Head.yRot = -0.3490658503988659F;
		this.LeftThigh.xRot = -0.9330382858376184F;
		this.LeftThigh.yRot = 0.2585053606381855F;
		this.LeftArm.xRot = -1.2330382858376184F;
		this.LeftArm.zRot = -0.4575712110370513F;
		this.LeftLeg.xRot = -0.6877580409572781F;
		this.LeftFoot.xRot = 1.5877580409572781F;
		this.RightArm.xRot = -1.3962634015954636F;
		this.RightArm.yRot = 0.13962634015954636F;
		this.RightArm.zRot = -0.13962634015954636F;
		this.RightLeg.xRot = -0.6877580409572781F;
		this.RightFoot.xRot = 1.5877580409572781F;
		this.Body.xRot = 0.057453292519943295F;
		this.Tail.xRot = -0.5585053606381855F;
		this.Tail.yRot = 0.41887902047863906F;
		this.RightThigh.xRot = -0.9330382858376184F;
		this.RightThigh.yRot = -0.2585053606381855F;
	}
	
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}