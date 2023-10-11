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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Pinacosaurus;

public class PinacosaurusBabyModel extends EntityModel<Pinacosaurus> {
	private final ModelPart Torso;
	private final ModelPart RArm;
	private final ModelPart LArm;
	private final ModelPart RLeg;
	private final ModelPart LLeg;
	private final ModelPart Tail;
	private final ModelPart Head;

	public PinacosaurusBabyModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.RArm = Torso.getChild("RArm");
		this.LArm = Torso.getChild("LArm");
		this.RLeg = Torso.getChild("RLeg");
		this.LLeg = Torso.getChild("LLeg");
		this.Tail = Torso.getChild("Tail");
		this.Head = Torso.getChild("Head");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, 0.0F, -8.0F, 13.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition Head = Torso.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(42, 0).addBox(-2.5F, -1.0F, -9.0F, 5.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -8.0F, 0.0698F, 0.0F, 0.0F));

		PartDefinition LHorn = Head.addOrReplaceChild("LHorn", CubeListBuilder.create().texOffs(45, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -5.0F));

		PartDefinition RHorn = Head.addOrReplaceChild("RHorn", CubeListBuilder.create().texOffs(45, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -5.0F));

		PartDefinition HeadHorns = Head.addOrReplaceChild("HeadHorns", CubeListBuilder.create().texOffs(3, 62).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition Tail = Torso.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(0, 22).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 8.0F, -0.0349F, 0.0F, 0.0F));

		PartDefinition Club = Tail.addOrReplaceChild("Club", CubeListBuilder.create().texOffs(18, 22).addBox(-2.5F, 0.0F, -1.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 11.0F));

		PartDefinition TailSpines = Tail.addOrReplaceChild("TailSpines", CubeListBuilder.create().texOffs(-2, 36).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 1.0F));

		PartDefinition TorsoSpines = Torso.addOrReplaceChild("TorsoSpines", CubeListBuilder.create().texOffs(-16, 44).addBox(-9.5F, 0.0F, -7.0F, 19.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition RArm = Torso.addOrReplaceChild("RArm", CubeListBuilder.create().texOffs(36, 22).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 4.0F, -4.5F));

		PartDefinition LArm = Torso.addOrReplaceChild("LArm", CubeListBuilder.create().texOffs(36, 22).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 4.0F, -4.5F));

		PartDefinition RLeg = Torso.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(48, 22).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 2.0F, 4.5F));

		PartDefinition RLeg2 = RLeg.addOrReplaceChild("RLeg2", CubeListBuilder.create().texOffs(58, 13).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 2.5F));

		PartDefinition LLeg = Torso.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(48, 22).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 2.0F, 4.5F));

		PartDefinition LLeg2 = LLeg.addOrReplaceChild("LLeg2", CubeListBuilder.create().texOffs(58, 13).mirror().addBox(-1.5F, 0.0F, -4.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 2.5F));

		return LayerDefinition.create(meshdefinition, 72, 64);
	}

	@Override
	public void setupAnim(Pinacosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		int sleepProgress = entity.getSleepTicks();
		int wakingProgress = entity.getWakingTicks();
		if (!entity.isWakingUp() && !entity.isFallingAsleep()) {
			if (!entity.isAsleep()) {
				resetModel();
			} else {
				this.Torso.y = 17;
				this.LLeg.xRot =  0.034732052281134726F;
				this.LLeg.zRot = 0.291819038949227F;
				this.Head.xRot = -0.3511602601486451F;
				this.Tail.xRot = -0.4054399772487995F;
				this.Tail.yRot = -0.14608405639455457F;
				this.RArm.xRot = -1.3891074877464207F;
				this.RArm.yRot = -0.10995574620459413F;
				this.LArm.xRot = -1.2407545013269026F;
				this.LArm.yRot = 0.2553416715641412F;
				this.Torso.xRot = 0.1459095194746135F;
				this.RLeg.xRot = -0.036477379868653376F;
				this.RLeg.yRot = -5.235987638949542E-4F;
				this.RLeg.zRot = -0.291993575869168F;
				this.Head.xRot = 0.22287855346915916F;
			}
		}
		if (wakingProgress != 0) {
			//LLeg
			if (this.LLeg.xRot > 0) this.LLeg.xRot -= 0.05;
			if (this.LLeg.zRot > 0) this.LLeg.zRot -= 0.05;
			//RLeg
			if (this.RLeg.xRot < 0) this.RLeg.xRot += 0.05;
			if (this.RLeg.yRot < 0) this.RLeg.yRot += 0.05;
			if (this.RLeg.zRot < 0) this.RLeg.zRot += 0.05;
			//Head
			if (this.Head.xRot > 0) this.Head.xRot -= 0.05;
			//Tail
			if (this.Tail.xRot < 0) this.Tail.xRot += 0.05;
			if (this.Tail.yRot < 0) this.Tail.yRot += 0.05;
			//RArm
			if (this.RArm.xRot < 0) this.RArm.xRot += 0.05;
			if (this.RArm.yRot < 0) this.RArm.yRot += 0.05;
			//LArm
			if (this.LArm.xRot < 0) this.LArm.xRot += 0.05;
			if (this.LArm.yRot > 0) this.LArm.yRot -= 0.05;
			//Torso
			if (this.Torso.y > 15) this.Torso.y -= 0.15;
			if (this.Torso.xRot > 0) this.Torso.xRot -= 0.05;
		}
		if (entity.isAsleep()) {
			if (sleepProgress != 0) {
				//LLeg
				if (this.LLeg.xRot < 0.034732052281134726F) this.LLeg.xRot += 0.05;
				if (this.LLeg.zRot < 0.291819038949227F) this.LLeg.zRot += 0.05;
				//RLeg
				if (this.RLeg.xRot > -0.036477379868653376F) this.RLeg.xRot -= 0.05;
				if (this.RLeg.yRot > -5.235987638949542E-4F) this.RLeg.yRot -= 0.05;
				if (this.RLeg.zRot > -0.291993575869168F) this.RLeg.zRot -= 0.05;
				//Head
				if (this.Head.xRot < 0.22287855346915916F) this.Head.xRot += 0.05;
				//Tail
				if (this.Tail.xRot > -0.4054399772487995F) this.Tail.xRot -= 0.05;
				if (this.Tail.yRot > -0.14608405639455457F) this.Tail.yRot -= 0.05;
				//RArm
				if (this.RArm.xRot > -1.3891074877464207F) this.RArm.xRot -= 0.05;
				if (this.RArm.yRot > -0.10995574620459413F) this.RArm.yRot -= 0.05;
				//LArm
				if (this.LArm.xRot > -1.2407545013269026F) this.LArm.xRot -= 0.05;
				if (this.LArm.yRot < 0.2553416715641412F) this.LArm.yRot += 0.05;
				//Torso
				if (this.Torso.y < 17) this.Torso.y += 0.15;
				if (this.Torso.xRot < 0.1459095194746135F) this.Torso.xRot += 0.05;
			}
		} else {
			this.LArm.xRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.RArm.xRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
			this.RLeg.xRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.LLeg.xRot = Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
			this.Tail.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos((limbSwing / 3) * speed * 0.15F) * degree * 0.35F * limbSwingAmount) + attackProgress * leftOrRight * (float)Math.toRadians(-15);
			this.Head.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos((limbSwing / 3) * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F) + (headPitch * ((float) Math.PI / 180F));
			this.Head.yRot = (netHeadYaw * ((float) Math.PI / 180F));
			this.Torso.yRot = attackProgress * leftOrRight * (float)Math.toRadians(-200);
			this.Tail.zRot = attackProgress * leftOrRight * (float)Math.toRadians(15);
			this.Torso.z = 0 + attackProgress * -22;
			if (entity.isInWater()) {
				this.Head.xRot = -0.1F;
			}
			if (entity.isEating()) {
				this.Head.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
				this.Torso.xRot = 0.1F;
				this.LLeg.xRot = -0.1F;
				this.RLeg.xRot = -0.1F;
				this.RArm.xRot = -0.1F;
				this.LArm.xRot = -0.1F;
				this.RArm.zRot = 0.3F;
				this.LArm.zRot = -0.3F;
			}
		}
	}

	public void resetModel() {
		//LLeg
		this.LLeg.xRot =  0;
		this.LLeg.yRot = 0F;
		this.LLeg.zRot = 0;
		//RLeg
		this.RLeg.xRot = 0F;
		this.RLeg.yRot = 0F;
		this.RLeg.zRot = 0F;
		//Head
		this.Head.xRot = 0F;
		//Tail
		this.Tail.xRot = 0F;
		this.Tail.yRot = 0F;
		//RArm
		this.RArm.xRot = 0F;
		this.RArm.yRot = 0F;
		this.RArm.zRot = 0F;
		//LArm
		this.LArm.xRot = 0F;
		this.LArm.yRot = 0F;
		this.LArm.zRot = 0F;
		//Torso
		this.Torso.xRot = 0F;
		this.Torso.y = 15;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
