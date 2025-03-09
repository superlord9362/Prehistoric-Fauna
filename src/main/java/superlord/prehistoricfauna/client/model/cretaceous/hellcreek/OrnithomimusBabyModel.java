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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ornithomimus;

public class OrnithomimusBabyModel extends EntityModel<Ornithomimus> {
	private final ModelPart Body;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Head;
	private final ModelPart Tail;
	private final ModelPart LeftWing;
	private final ModelPart RightWing;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public OrnithomimusBabyModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck1 = Body.getChild("Neck1");
		this.Neck2 = Neck1.getChild("Neck2");
		this.Head = Neck2.getChild("Head");
		this.Tail = Body.getChild("Tail");
		this.LeftWing = Body.getChild("LeftWing");
		this.RightWing = Body.getChild("RightWing");
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

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -8.0F, 4.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, -0.5F));

		PartDefinition Neck1 = Body.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(33, 20).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(22, 29).addBox(-1.0F, 2.0F, -5.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -8.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(35, 8).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -4.0F));

		PartDefinition Head = Neck2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(1, 6).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.01F))
		.texOffs(35, 14).addBox(-0.5F, 0.0F, -5.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition RightWing = Body.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(0, -4).mirror().addBox(0.0F, 0.0F, -2.5F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.0F, -5.5F, 0.0F, 0.0F, -0.2182F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(19, 0).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(32, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 2.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(25, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(19, 0).mirror().addBox(-1.0F, -1.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(32, 0).mirror().addBox(-0.5F, 0.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 2.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(25, 0).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition LeftWing = Body.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(0, -4).addBox(0.0F, 0.0F, -2.5F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -5.5F, 0.0F, 0.0F, 0.2182F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(18, 4).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 19).addBox(-1.0F, 2.0F, 3.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 3.0F));

		return LayerDefinition.create(meshdefinition, 49, 36);
	}

	@Override
	public void setupAnim(Ornithomimus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
				this.Body.y = Mth.lerp(sleepProgress, 15, 19.5F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.10471975511965977F);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0, 0.55929251589567215F);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 0, 1.2117821049859852F);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0, 0.2350958549041681F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, 0.2F);
				this.Tail.z = Mth.lerp(sleepProgress, 3, 2.5F);
				this.Tail.xRot = Mth.lerp(sleepProgress, 0, -0.24434609527920614F);
				this.Tail.yRot = Mth.lerp(sleepProgress, 0, -0.3490658503988659F);
				this.RightThigh.y = Mth.lerp(sleepProgress, 0, -0.5F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, -0.7330382858376184F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, -0.24434609527920614F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -0.7877580409572781F);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 0, 1.607963267948966F);
				this.LeftThigh.y = Mth.lerp(sleepProgress, 0, -0.5F);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, 0, -0.7330382858376184F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, 0.24434609527920614F);	
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -0.7877580409572781F);	
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 0, 1.607963267948966F);
				this.RightWing.xRot = Mth.lerp(sleepProgress, 0, 0.7066764186984569F);
				this.RightWing.yRot = Mth.lerp(sleepProgress, 0, 0.99547687289441354F);
				this.LeftWing.xRot = Mth.lerp(sleepProgress, 0, 0.7932595164970201F);
				this.LeftWing.yRot = Mth.lerp(sleepProgress, 0, -0.99547687289441354F);
			} else sleepingModel();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.Body.y = Mth.lerp(sleepProgress, 19.5F, 15);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.10471975511965977F, 0);
				this.Neck1.xRot = Mth.lerp(sleepProgress, 0.55929251589567215F, 0);
				this.Neck1.yRot = Mth.lerp(sleepProgress, 1.2117821049859852F, 0);
				this.Neck1.zRot = Mth.lerp(sleepProgress, 0.2350958549041681F, 0);
				this.Head.xRot = Mth.lerp(sleepProgress, 0.2F, 0);
				this.Tail.z = Mth.lerp(sleepProgress, 2.5F, 3);
				this.Tail.xRot = Mth.lerp(sleepProgress, -0.24434609527920614F, 0);
				this.Tail.yRot = Mth.lerp(sleepProgress, -0.3490658503988659F, 0);
				this.RightThigh.y = Mth.lerp(sleepProgress, -0.5F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, -0.7330382858376184F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, -0.24434609527920614F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -0.7877580409572781F, 0);
				this.RightFoot.xRot = Mth.lerp(sleepProgress, 1.607963267948966F, 0);
				this.LeftThigh.y = Mth.lerp(sleepProgress, -0.5F, 0);
				this.LeftThigh.xRot = Mth.lerp(sleepProgress, -0.7330382858376184F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0.24434609527920614F, 0);	
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -0.7877580409572781F, 0);	
				this.LeftFoot.xRot = Mth.lerp(sleepProgress, 1.607963267948966F, 0);
				this.RightWing.xRot = Mth.lerp(sleepProgress, 0.7066764186984569F, 0);
				this.RightWing.yRot = Mth.lerp(sleepProgress, 0.99547687289441354F, 0);
				this.LeftWing.xRot = Mth.lerp(sleepProgress, 0.7932595164970201F, 0);
				this.LeftWing.yRot = Mth.lerp(sleepProgress, -0.99547687289441354F, 0);
			} else {
				this.Neck1.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + (Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float) Math.toRadians(25F);
				this.Body.xRot = /**Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))*/ + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
				this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
				this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
				this.Neck2.xRot = Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount + attackProgress * (float) Math.toRadians(-25F);
				this.RightWing.xRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.LeftWing.xRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
				this.RightThigh.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount;
				this.RightFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount;
				this.LeftFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.3F * limbSwingAmount;
				this.Neck1.yRot = netHeadYaw * ((float) Math.PI / 180F);
				if (entity.isInWater()) {
//					this.RightThigh.y = 20;
//					this.LeftThigh.y = 20;
					this.Body.y = 20;
					this.Body.xRot = -0.25F;
					this.Tail.xRot = 0.125F;
					this.Neck1.xRot = 0.5F;
					this.RightThigh.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftThigh.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightLeg.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.LeftLeg.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
					this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
					this.LeftWing.xRot = 0.25F;
					this.RightWing.xRot = 0.25F;
					this.RightWing.zRot = -1.5F + Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.LeftWing.zRot = 1.5F - Math.abs(-1F * Mth.sin(0.15F * ageInTicks / 2));
					this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				}
			}
		}
	}
	
	public void resetModel() {
		this.Body.y = 15F;
		this.Body.xRot = 0;
		this.Neck1.z = -8F;
		this.Neck1.xRot = 0;
		this.Neck1.yRot = 0;
		this.Neck1.zRot = 0;
		this.Neck2.x = 0;
		this.Neck2.z = -4;
		this.Neck2.xRot = 0;
		this.Neck2.yRot = 0;
		this.Neck2.zRot = 0;
		this.Head.xRot = 0;
		this.Tail.z = 3.0F;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.LeftThigh.x = -2F;
		this.LeftThigh.y = 0F;
		this.LeftThigh.z = 0F;
		this.LeftThigh.xRot = 0;
		this.LeftThigh.yRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftFoot.z = 0.0F;
		this.LeftFoot.xRot = 0;
		this.RightThigh.x = 2F;
		this.RightThigh.y = 0F;
		this.RightThigh.z = 0F;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.RightLeg.xRot = 0;
		this.RightFoot.z = 0.0F;
		this.RightFoot.xRot = 0;
		this.LeftWing.xRot = 0F;
		this.LeftWing.yRot = 0F;
		this.LeftWing.zRot = 0.2182F;
		this.RightWing.xRot = 0F;
		this.RightWing.yRot = 0F;
		this.RightWing.zRot = -0.2182F;
	}
	
	public void sleepingModel() {
		this.Body.y = 19.5F;
		this.Body.xRot = -0.10471975511965977F;
		this.Neck1.xRot = 0.55929251589567215F;
		this.Neck1.yRot = 1.2117821049859852F;
		this.Neck1.zRot = 0.2350958549041681F;
		this.Head.xRot = 0.2F;
		this.Tail.z = 2.5F;
		this.Tail.xRot = -0.24434609527920614F;
		this.Tail.yRot = -0.3490658503988659F;
		this.RightThigh.x = 2;
		this.RightThigh.y = -0.5F;
		this.RightThigh.xRot = -0.7330382858376184F;
		this.RightThigh.yRot = -0.24434609527920614F;
		this.RightLeg.xRot = -0.7877580409572781F;
		this.RightFoot.z = 0;
		this.RightFoot.xRot = 1.607963267948966F;
		this.LeftThigh.x = -2;
		this.LeftThigh.y = -0.5F;
		this.LeftThigh.xRot = -0.7330382858376184F;
		this.LeftThigh.yRot = 0.24434609527920614F;	
		this.LeftLeg.xRot = -0.7877580409572781F;	
		this.LeftFoot.z = -0.0F;
		this.LeftFoot.xRot = 1.607963267948966F;
		this.RightWing.xRot = 0.7066764186984569F;
		this.RightWing.yRot = 0.99547687289441354F;
		this.LeftWing.xRot = 0.7932595164970201F;
		this.LeftWing.yRot = -0.99547687289441354F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}