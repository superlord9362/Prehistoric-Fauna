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

public class PinacosaurusModel extends EntityModel<Pinacosaurus> {
	private final ModelPart Body;
	private final ModelPart Body1;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart TailClub;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;

	public PinacosaurusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Body1 = Body.getChild("Body1");
		this.Neck = Body1.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.TailClub = Tail2.getChild("TailClub");
		this.LeftArm = Body1.getChild("LeftArm");
		this.RightArm = Body1.getChild("RightArm");
		this.RightThigh = Body.getChild("RightThigh");
		this.RightLeg = RightThigh.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
		this.LeftThigh = Body.getChild("LeftThigh");
		this.LeftLeg = LeftThigh.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0F, -5.0F, -31.0F, 26.0F, 12.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 24.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(75, 0).addBox(-3.0F, -1.0F, -5.0F, 6.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, -2.0F, -14.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(135, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 2.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(95, 0).mirror().addBox(-2.5F, 0.0F, -5.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 6.0F, 2.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(82, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -8.0F, -0.15F, 0.0F, 0.0F));

		PartDefinition TailSpikes = Tail1.addOrReplaceChild("TailSpikes", CubeListBuilder.create().texOffs(-2, 60).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.5F, 2.0F));

		PartDefinition TailSpikes2 = Tail1.addOrReplaceChild("TailSpikes2", CubeListBuilder.create().texOffs(48, 35).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(49, 35).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 14.0F, 0.15F, 0.0F, 0.0F));

		PartDefinition Tailspikes3 = Tail2.addOrReplaceChild("Tailspikes3", CubeListBuilder.create().texOffs(56, 52).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 0.0F));

		PartDefinition Tailspikes1 = Tail2.addOrReplaceChild("Tailspikes1", CubeListBuilder.create().texOffs(-14, 35).addBox(-6.5F, 0.0F, 0.0F, 13.0F, 0.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TailClub = Tail2.addOrReplaceChild("TailClub", CubeListBuilder.create().texOffs(0, 12).addBox(-2.5F, -1.5F, 0.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 26.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(75, 0).addBox(-3.0F, -1.0F, -5.0F, 6.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, -2.0F, -14.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(135, 0).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.0F, 2.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(95, 0).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 2.0F));

		PartDefinition Body1 = Body.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(142, 6).addBox(-8.0F, -4.0F, -9.0F, 16.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -31.0F));

		PartDefinition Neck = Body1.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(98, 19).addBox(-3.5F, -2.0F, -7.0F, 7.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -9.0F, 0.15F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(128, 25).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -5.0F, 0.05F, 0.0F, 0.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(183, 0).addBox(-2.5F, 0.0F, -3.0F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition RightCheekbone = Head.addOrReplaceChild("RightCheekbone", CubeListBuilder.create().texOffs(75, 0).mirror().addBox(0.0F, -0.5F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 3.0F, -2.0F, 0.0F, 0.1885F, 0.0F));

		PartDefinition RightOsteoderm = Head.addOrReplaceChild("RightOsteoderm", CubeListBuilder.create().texOffs(166, 0).addBox(0.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.5F, -2.0F, 0.1222F, 0.2443F, 0.0F));

		PartDefinition LeftOsteoderm = Head.addOrReplaceChild("LeftOsteoderm", CubeListBuilder.create().texOffs(166, 0).mirror().addBox(-2.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5F, 0.5F, -2.0F, 0.1222F, -0.2443F, 0.0F));

		PartDefinition LeftCheekbone = Head.addOrReplaceChild("LeftCheekbone", CubeListBuilder.create().texOffs(75, 0).addBox(-2.0F, -0.5F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 3.0F, -2.0F, 0.0F, -0.1885F, 0.0F));

		PartDefinition RightArm = Body1.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(156, 25).mirror().addBox(-3.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.5F, 3.0F, -5.0F));

		PartDefinition Body1spikes = Body1.addOrReplaceChild("Body1spikes", CubeListBuilder.create().texOffs(1, 100).addBox(-10.0F, 0.0F, -5.0F, 20.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, -1.0F));

		PartDefinition LeftArm = Body1.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(156, 25).mirror().addBox(-3.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.5F, 3.0F, -5.0F));

		PartDefinition BodySpikes = Body.addOrReplaceChild("BodySpikes", CubeListBuilder.create().texOffs(-26, 72).addBox(-16.0F, 0.0F, 0.0F, 32.0F, 0.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, -30.0F));

		return LayerDefinition.create(meshdefinition, 200, 200);
	}

	@Override
	public void setupAnim(Pinacosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		if (entity.isFallingAsleep() && !entity.isAsleep() && !entity.isWakingUp()) {
			this.transitionToSleepingPose();
		} else if (entity.isAsleep() && !entity.isWakingUp() && !entity.isFallingAsleep()) {
			this.setSleepingPose();
		}
		if (entity.isWakingUp() && !entity.isFallingAsleep() && !entity.isAsleep()) {
			if (!this.finishedResetingModel()) this.transitionToAwake();
		} 
		if (!entity.isWakingUp() && !entity.isFallingAsleep() && !entity.isAsleep()) {
			resetModel();
			this.LeftArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.RightArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
			this.RightThigh.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.RightLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.RightFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
			this.LeftThigh.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
			this.LeftLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
			this.LeftFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
			this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount) + attackProgress * leftOrRight * (float)Math.toRadians(-15);
			this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount) + attackProgress * leftOrRight * (float)Math.toRadians(-25);
			this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
			this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
			this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F) + (headPitch * ((float) Math.PI / 180F));
			this.Neck.yRot = (netHeadYaw * ((float) Math.PI / 180F));
			this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.05F);
			this.Body.yRot = attackProgress * leftOrRight * (float)Math.toRadians(-200);
			this.Tail1.zRot = attackProgress * leftOrRight * (float)Math.toRadians(15);
			this.Body.z = 24 + attackProgress * -22;
			if (entity.isInWater()) {
				this.Neck.xRot = -0.1F;
			}
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
				this.Body.xRot = 0.1F;
				this.LeftThigh.xRot = -0.1F;
				this.RightThigh.xRot = -0.1F;
				this.RightArm.xRot = -0.1F;
				this.LeftArm.xRot = -0.1F;
				this.RightArm.zRot = 0.3F;
				this.LeftArm.zRot = -0.3F;
			}
		}
	}

	public void resetModel() {
		this.LeftFoot.xRot = 0F;
		this.LeftFoot.yRot = 0F;
		this.LeftFoot.zRot = 0F;
		this.Tail2.xRot = 0F;
		this.Tail2.yRot = 0;
		this.RightFoot.xRot = 0;
		this.RightFoot.yRot = 0;
		this.RightFoot.zRot = 0;
		this.LeftThigh.xRot =  0;
		this.LeftThigh.zRot = 0;
		this.RightLeg.xRot = 0F;
		this.RightLeg.yRot = 0F;
		this.RightLeg.zRot = 0F;
		this.Head.xRot = 0F;
		this.Tail1.xRot = 0F;
		this.Tail1.yRot = 0F;
		this.RightArm.xRot = 0F;
		this.RightArm.yRot = 0F;
		this.LeftArm.xRot = 0F;
		this.LeftArm.yRot = 0F;
		this.Body1.xRot = 0F;
		this.RightThigh.xRot = 0F;
		this.RightThigh.yRot = 0F;
		this.RightThigh.zRot = 0F;
		this.LeftLeg.xRot = 0F;
		this.LeftLeg.yRot = 0F;
		this.LeftLeg.zRot = 0;
		this.TailClub.xRot = 0;
		this.TailClub.yRot = 0;
		this.Neck.xRot = 0;
		this.Body.y = 11;
		this.Body.xRot = 0;
		this.RightArm.zRot = 0F;
		this.LeftArm.zRot = 0F;
	}

	public void setSleepingPose() {
		this.Body.y = 17;
		this.LeftFoot.xRot = 1.0220648339363292F;
		this.LeftFoot.yRot = -0.5473352640780661F;
		this.LeftFoot.zRot = -0.2911209245589763F;
		this.Tail2.xRot = 0.3324852091891143F;
		this.Tail2.yRot = -0.07295475973730675F;
		this.RightFoot.xRot = 1.1320205634961664F;
		this.RightFoot.yRot = 0.9847147320172677F;
		this.RightFoot.zRot = 0.6213371870783705F;
		this.LeftThigh.xRot =  0.034732052281134726F;
		this.LeftThigh.zRot = -0.291819038949227F;
		this.RightLeg.xRot = -0.5483824523081988F;
		this.RightLeg.yRot = -3.4906584259663615E-4F;
		this.RightLeg.zRot = 0.1830850345394635F;
		this.Head.xRot = -0.3511602601486451F;
		this.Tail1.xRot = -0.4054399772487995F;
		this.Tail1.yRot = -0.14608405639455457F;
		this.RightArm.xRot = -1.3891074877464207F;
		this.RightArm.yRot = -0.10995574620459413F;
		this.LeftArm.xRot = -1.2407545013269026F;
		this.LeftArm.yRot = 0.2553416715641412F;
		this.Body1.xRot = 0.1459095194746135F;
		this.RightThigh.xRot = -0.036477379868653376F;
		this.RightThigh.yRot = -5.235987638949542E-4F;
		this.RightThigh.zRot = 0.291993575869168F;
		this.LeftLeg.xRot = -0.8028514559173915F;
		this.LeftLeg.yRot = -0.007330382629510778F;
		this.LeftLeg.zRot = 0.07278023113974408F;
		this.Neck.xRot = 0.22287855346915916F;
	}

	public boolean finishedResetingModel() {
		return this.LeftFoot.xRot <= 0
				&& this.LeftFoot.yRot >= 0
				&& this.LeftFoot.zRot >= 0
				&& this.Tail2.xRot <= 0
				&& this.Tail2.yRot >= 0
				&& this.RightFoot.xRot <= 0
				&& this.RightFoot.yRot <= 0
				&& this.RightFoot.zRot <= 0
				&& this.LeftThigh.xRot <= 0
				&& this.LeftThigh.zRot >= 0
				&& this.RightLeg.xRot >= 0
				&& this.RightLeg.yRot >= 0
				&& this.RightLeg.zRot <= 0
				&& this.Head.xRot >= 0
				&& this.Tail1.xRot >= 0
				&& this.Tail1.yRot >= 0
				&& this.RightArm.xRot >= 0
				&& this.RightArm.yRot >= 0
				&& this.LeftArm.xRot >= 0
				&& this.LeftArm.yRot <= 0
				&& this.Body1.xRot <= 0
				&& this.RightThigh.xRot >= 0
				&& this.RightThigh.yRot >= 0
				&& this.RightThigh.zRot <= 0
				&& this.LeftLeg.xRot >= 0
				&& this.LeftLeg.yRot >= 0
				&& this.LeftLeg.zRot <= 0
				&& this.Neck.xRot <= 0
				&& this.Body.y <= 11;
	}

	public void transitionToSleepingPose() {
		//LeftFoot
		if (this.LeftFoot.xRot < 1.0220648339363292F) this.LeftFoot.xRot += 0.05;
		if (this.LeftFoot.yRot > -0.5473352640780661F) this.LeftFoot.yRot -= 0.05;
		if (this.LeftFoot.zRot > -0.2911209245589763F) this.LeftFoot.zRot -= 0.05;
		//Tail2
		if (this.Tail2.xRot < 0.3324852091891143F) this.Tail2.xRot += 0.05;
		if (this.Tail2.yRot > -0.07295475973730675F) this.Tail2.yRot -= 0.05;
		//RightFoot
		if (this.RightFoot.xRot < 1.1320205634961664F) this.RightFoot.xRot += 0.05;
		if (this.RightFoot.yRot < 0.9847147320172677F) this.RightFoot.yRot += 0.05;
		if (this.RightFoot.zRot < 0.6213371870783705F) this.RightFoot.zRot += 0.05;
		//LeftThigh
		if (this.LeftThigh.xRot < 0.034732052281134726F) this.LeftThigh.xRot += 0.05;
		if (this.LeftThigh.zRot > -0.291819038949227F) this.LeftThigh.zRot -= 0.05;
		//RightLeg
		if (this.RightLeg.xRot > -0.5483824523081988F) this.RightLeg.xRot -= 0.05;
		if (this.RightLeg.yRot > -3.4906584259663615E-4F) this.RightLeg.yRot -= 0.05;
		if (this.RightLeg.zRot < 0.1830850345394635F) this.RightLeg.zRot += 0.05;
		//Head
		if (this.Head.xRot > -0.3511602601486451F) this.Head.xRot -= 0.05;
		//Tail1
		if (this.Tail1.xRot > -0.4054399772487995F) this.Tail1.xRot -= 0.05;
		if (this.Tail1.yRot > -0.14608405639455457F) this.Tail1.yRot -= 0.05;
		//RightArm
		if (this.RightArm.xRot > -1.3891074877464207F) this.RightArm.xRot -= 0.05;
		if (this.RightArm.yRot > -0.10995574620459413F) this.RightArm.yRot -= 0.05;
		//LeftArm
		if (this.LeftArm.xRot > -1.2407545013269026F) this.LeftArm.xRot -= 0.05;
		if (this.LeftArm.yRot < 0.2553416715641412F) this.LeftArm.yRot += 0.05;
		//Body1
		if (this.Body1.xRot < 0.1459095194746135F) this.Body1.xRot += 0.05;
		//RightThigh
		if (this.RightThigh.xRot > -0.036477379868653376F) this.RightThigh.xRot -= 0.05;
		if (this.RightThigh.yRot > -5.235987638949542E-4F) this.RightThigh.yRot -= 0.05;
		if (this.RightThigh.zRot < 0.291993575869168F) this.RightThigh.zRot += 0.05;
		//LeftLeg
		if (this.LeftLeg.xRot > -0.8028514559173915F) this.LeftLeg.xRot -= 0.05;
		if (this.LeftLeg.yRot > -0.007330382629510778F) this.LeftLeg.yRot -= 0.05;
		if (this.LeftLeg.zRot < 0.07278023113974408F) this.LeftLeg.zRot += 0.05;
		//Neck
		if (this.Neck.xRot < 0.22287855346915916F) this.Neck.xRot += 0.05;
		//Body
		if (this.Body.y < 17) this.Body.y += 0.15;
	}

	public boolean finishedSleepingPose() {
		return this.LeftFoot.xRot >= 1.0220648339363292F  
				&& this.LeftFoot.yRot <= -0.5473352640780661F 
				&& this.LeftFoot.zRot <= -0.2911209245589763F
				&& this.Tail2.xRot >= 0.3324852091891143F 
				&& this.Tail2.yRot <= -0.07295475973730675F
				&& this.RightFoot.xRot >= 1.1320205634961664F 
				&& this.RightFoot.yRot >= 0.9847147320172677F 
				&& this.RightFoot.zRot >= 0.6213371870783705F
				&& this.LeftThigh.xRot >= 0.034732052281134726F
				&& this.LeftThigh.zRot <= -0.291819038949227F
				&& this.RightLeg.xRot <= -0.5483824523081988F
				&& this.RightLeg.yRot <= -3.4906584259663615E-4F
				&& this.RightLeg.zRot >= 0.1830850345394635F
				&& this.Head.xRot <= -0.3511602601486451F
				&& this.Tail1.xRot <= -0.4054399772487995F
				&& this.Tail1.yRot <= -0.14608405639455457F 
				&& this.RightArm.xRot <= -1.3891074877464207F
				&& this.RightArm.yRot <= -0.10995574620459413F
				&& this.LeftArm.xRot <= -1.2407545013269026F
				&& this.LeftArm.yRot >= 0.2553416715641412F
				&& this.Body1.xRot >= 0.1459095194746135F
				&& this.RightThigh.xRot <= -0.036477379868653376F
				&& this.RightThigh.yRot <= -5.235987638949542E-4F
				&& this.RightThigh.zRot >= 0.291993575869168F
				&& this.LeftLeg.xRot <= -0.8028514559173915F
				&& this.LeftLeg.yRot <= -0.007330382629510778F
				&& this.LeftLeg.zRot >= 0.07278023113974408F
				&& this.Neck.xRot >= 0.22287855346915916F
				&& this.Body.y >= 17;
	}

	public void transitionToAwake() {
		//LeftFoot
		if (this.LeftFoot.xRot > 0) this.LeftFoot.xRot -= 0.05;
		if (this.LeftFoot.yRot < 0) this.LeftFoot.yRot += 0.05;
		if (this.LeftFoot.zRot < 0) this.LeftFoot.zRot += 0.05;
		//Tail2
		if (this.Tail2.xRot > 0) this.Tail2.xRot -= 0.05;
		if (this.Tail2.yRot < 0) this.Tail2.yRot += 0.05;
		//RightFoot
		if (this.RightFoot.xRot > 0) this.RightFoot.xRot -= 0.05;
		if (this.RightFoot.yRot > 0) this.RightFoot.yRot -= 0.05;
		if (this.RightFoot.zRot > 0) this.RightFoot.zRot -= 0.05;
		//LeftThigh
		if (this.LeftThigh.xRot > 0) this.LeftThigh.xRot -= 0.05;
		if (this.LeftThigh.zRot < 0) this.LeftThigh.zRot += 0.05;
		//RightLeg
		if (this.RightLeg.xRot < 0) this.RightLeg.xRot += 0.05;
		if (this.RightLeg.yRot < 0) this.RightLeg.yRot += 0.05;
		if (this.RightLeg.zRot > 0) this.RightLeg.zRot -= 0.05;
		//Head
		if (this.Head.xRot < 0) this.Head.xRot += 0.05;
		//Tail1
		if (this.Tail1.xRot < 0) this.Tail1.xRot += 0.05;
		if (this.Tail1.yRot < 0) this.Tail1.yRot += 0.05;
		//RightArm
		if (this.RightArm.xRot < 0) this.RightArm.xRot += 0.05;
		if (this.RightArm.yRot < 0) this.RightArm.yRot += 0.05;
		//LeftArm
		if (this.LeftArm.xRot < 0) this.LeftArm.xRot += 0.05;
		if (this.LeftArm.yRot > 0) this.LeftArm.yRot -= 0.05;
		//Body1
		if (this.Body1.xRot > 0) this.Body1.xRot -= 0.05;
		//RightThigh
		if (this.RightThigh.xRot < 0) this.RightThigh.xRot += 0.05;
		if (this.RightThigh.yRot < 0) this.RightThigh.yRot += 0.05;
		if (this.RightThigh.zRot > 0) this.RightThigh.zRot -= 0.05;
		//LeftLeg
		if (this.LeftLeg.xRot < 0) this.LeftLeg.xRot += 0.05;
		if (this.LeftLeg.yRot < 0) this.LeftLeg.yRot += 0.05;
		if (this.LeftLeg.zRot > 0) this.LeftLeg.zRot -= 0.05;
		//Neck
		if (this.Neck.xRot > 0) this.Neck.xRot -= 0.05;
		//Body
		if (this.Body.y > 11) this.Body.y -= 0.15;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
