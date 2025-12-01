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
import superlord.prehistoricfauna.common.entity.DinosaurEntity;
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Camptosaurus;

public class CamptosaurusBabyModel extends EntityModel<Camptosaurus> {
	private final ModelPart Body;
	private final ModelPart Neck;
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

	public CamptosaurusBabyModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Tail = this.Body.getChild("Tail");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftThigh = this.Body.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = this.Body.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(19, -10).addBox(0.0F, -3.0F, -2.0F, 0.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, -3.25F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 17).addBox(-1.0F, -5.0F, -3.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -2.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(11, 17).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, -4.0F, -3.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(29, 1).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(19, -8).addBox(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 8.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(1, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, -1.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(1, -2).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 2.0F, -1.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(46, 1).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 5.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(58, 4).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 2.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(56, 8).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(46, 1).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.0F, 5.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(58, 4).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 6.0F, 2.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(56, 8).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(Camptosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 1.0f;
		float walkDegree = 0.5f;
		float idleSpeed = 1.0f;
		float idleDegree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 15, 18F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.10471975511965977F);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0, 0.85929251589567215F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, 1.2117821049859852F);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0, 0.2350958549041681F);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0, -0.34434609527920614F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, -0.3490658503988659F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.7330382858376184F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, 0.24434609527920614F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.7877580409572781F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.607963267948966F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.7330382858376184F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.24434609527920614F);	
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.7877580409572781F);	
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.607963267948966F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, 0.1066764186984569F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0.0436F, 0.8066764186984569F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, 0.1932595164970201F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.0436F, -0.8932595164970201F);
			} else sleepingModel();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 18, 15F);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.10471975511965977F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.85929251589567215F, 0);
				this.Neck.yRot = Mth.lerp(sleepProgress, 1.2117821049859852F, 0);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0.2350958549041681F, 0);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.34434609527920614F, 0);
				this.Tail.yRot = Mth.lerp(sleepProgress, -0.3490658503988659F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.7330382858376184F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0.24434609527920614F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.7877580409572781F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.607963267948966F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.7330382858376184F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.24434609527920614F, 0);	
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.7877580409572781F, 0);	
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.607963267948966F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0.1066764186984569F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0.8066764186984569F, 0.0436F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0.1932595164970201F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, -0.8932595164970201F, -0.0436F);
			} else {
				this.Neck.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + (Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(25F);
				this.Body.xRot = /**Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))*/ + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
				this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
				this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
				this.RightArm.xRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.LeftArm.xRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount;
				this.RightFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.3F * limbSwingAmount;
				this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isInWater()) {
					//					this.RightThigh.y = 20;
					//					this.LeftThigh.y = 20;
					this.Body.y = 16;
					this.Body.xRot = -0.25F;
					this.Tail.xRot = 0.125F;
					this.Neck.xRot = 0.25F;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftArm.xRot = 0.25F;
					this.RightArm.xRot = 0.25F;
					this.RightArm.zRot = 1.5F - Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.LeftArm.zRot = -1.5F + Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}

	public void resetModel() {
		this.Body.y = 15F;
		this.Body.xRot = 0;
		this.Neck.z = -2F;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Head.xRot = 0;
		this.Tail.z = 8.0F;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.LeftThigh.x = 2F;
		this.LeftThigh.y = 0F;
		this.LeftThigh.z = 5F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftFoot.z = 0.0F;
		this.LeftFoot.xRot = 0;
		this.RightThigh.x = -2F;
		this.RightThigh.y = 0F;
		this.RightThigh.z = 5F;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightLeg.xRot = 0;
		this.RightFoot.z = 0.0F;
		this.RightFoot.xRot = 0;
		this.LeftArm.xRot = 0F;
		this.LeftArm.yRot = 0F;
		this.LeftArm.zRot = -0.2182F;
		this.RightArm.xRot = 0F;
		this.RightArm.yRot = 0F;
		this.RightArm.zRot = 0.2182F;
	}

	public void sleepingModel() {
		this.Body.y = 18F;
		this.Body.xRot = -0.10471975511965977F;
		this.Neck.xRot = 0.85929251589567215F;
		this.Neck.yRot = 1.2117821049859852F;
		this.Neck.zRot = 0.2350958549041681F;
		this.Tail.xRot = -0.34434609527920614F;
		this.Tail.yRot = -0.3490658503988659F;
		this.RightThigh.xRot = -0.7330382858376184F;
		this.RightThigh.yRot = 0.24434609527920614F;
		this.RightLeg.xRot = -0.7877580409572781F;
		this.RightFoot.xRot = 1.607963267948966F;
		this.LeftThigh.xRot = -0.7330382858376184F;
		this.LeftThigh.yRot = -0.24434609527920614F;	
		this.LeftLeg.xRot = -0.7877580409572781F;	
		this.LeftFoot.xRot = 1.607963267948966F;
		this.RightArm.xRot = 0.1066764186984569F;
		this.RightArm.zRot = 0.8066764186984569F;
		this.LeftArm.xRot = 0.1932595164970201F;
		this.LeftArm.zRot = -0.8932595164970201F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
