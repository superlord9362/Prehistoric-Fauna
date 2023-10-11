package superlord.prehistoricfauna.client.model.triassic.chinle;

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
import superlord.prehistoricfauna.common.entity.triassic.chinle.Trilophosaurus;

public class TrilophosaurusModel extends EntityModel<Trilophosaurus> {
	private final ModelPart RightArm;
	private final ModelPart RightHand;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart LeftArm;
	private final ModelPart LeftHand;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart TailBase;
	private final ModelPart TailEnd;

	public TrilophosaurusModel(ModelPart root) {
		this.RightArm = root.getChild("RightArm");
		this.RightHand = RightArm.getChild("RightHand");
		this.LeftLeg = root.getChild("LeftLeg");
		this.LeftFoot = LeftLeg.getChild("LeftFoot");
		this.LeftArm = root.getChild("LeftArm");
		this.LeftHand = LeftArm.getChild("LeftHand");
		this.RightLeg = root.getChild("RightLeg");
		this.RightFoot = RightLeg.getChild("RightFoot");
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.TailBase = Body.getChild("TailBase");
		this.TailEnd = TailBase.getChild("TailEnd");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 20.99F, -4.0F));

		PartDefinition RightHand = RightArm.addOrReplaceChild("RightHand", CubeListBuilder.create().texOffs(53, 27).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 3.01F, -1.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, -2.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 19.99F, 6.5F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(52, 16).addBox(-1.5F, 0.0F, -2.5F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 4.01F, -2.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 10).mirror().addBox(-1.0F, -2.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 20.89F, -4.0F));

		PartDefinition LeftHand = LeftArm.addOrReplaceChild("LeftHand", CubeListBuilder.create().texOffs(53, 27).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 3.01F, -1.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 19.99F, 6.5F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(52, 16).addBox(-1.5F, 0.0F, -2.5F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 4.01F, -2.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(14, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, -4.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(10, 0).addBox(-1.0F, -5.0F, -4.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 5).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.9F, -3.0F));

		PartDefinition Snoot = Head.addOrReplaceChild("Snoot", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition TailBase = Body.addOrReplaceChild("TailBase", CubeListBuilder.create().texOffs(38, 0).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.2F, 11.0F));

		PartDefinition TailEnd = TailBase.addOrReplaceChild("TailEnd", CubeListBuilder.create().texOffs(12, 19).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.01F, 9.3F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Trilophosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		int sleepProgress = entity.getSleepTicks();
		int wakingProgress = entity.getWakingTicks();
		if (!entity.isWakingUp() && !entity.isFallingAsleep()) {
			if (!entity.isAsleep()) {
				resetModel();
			} else {
				this.Neck.xRot = 0.7037167490777915F;
				this.Neck.yRot = -0.46914448828868976F;
				this.RightFoot.xRot = -0.11728612207217244F;
				this.RightFoot.yRot = 0.03909537541112055F;
				this.RightFoot.zRot = 1.2510520131558576F;
				this.RightHand.zRot =  1.3688617376654748F;
				this.LeftHand.zRot = -1.3683381601951652F;
				this.Body.y = 21.0F;
				this.RightArm.y = 23.89F;
				this.RightArm.xRot = -0.46914448828868976F;
				this.RightArm.yRot = 0.1563815016444822F;
				this.RightArm.zRot = -1.3683381601951652F;
				this.TailBase.xRot = -0.11728612207217244F;
				this.TailBase.yRot = 0.46914448828868976F;
				this.RightLeg.y = 22.99F;
				this.RightLeg.xRot = 0.35185837453889574F;
				this.RightLeg.zRot = -1.1728612040769677F;
				this.TailEnd.xRot = 0.0781907508222411F;
				this.TailEnd.yRot = 0.3909537457888271F;
				this.LeftLeg.y = 22.99F;
				this.LeftLeg.xRot = 0.35185837453889574F;
				this.LeftLeg.zRot = 1.1728612040769677F;
				this.LeftArm.y = 22.99F;
				this.LeftArm.xRot = -0.46914448828868976F;
				this.LeftArm.yRot = -0.1563815016444822F;
				this.LeftArm.zRot = 1.3683381601951652F;
				this.LeftFoot.xRot = -0.11728612207217244F;
				this.LeftFoot.yRot = 0.03909537541112055F;
				this.LeftFoot.zRot = -1.2510520131558576F;
			}
		}
		if (wakingProgress != 0) {
			//Neck
			if (this.Neck.xRot > 0.7037167490777915F) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot < -0.46914448828868976F) this.Neck.yRot += 0.05;
			//RightFoot
			if (this.RightFoot.xRot < -0.11728612207217244F) this.RightFoot.xRot += 0.05;
			if (this.RightFoot.yRot > 0.03909537541112055F) this.RightFoot.yRot -= 0.05;
			if (this.RightFoot.zRot > 1.2510520131558576F) this.RightFoot.zRot -= 0.05;
			//RightHand 
			if (this.RightHand.zRot > 1.3688617376654748F) this.RightHand.zRot -= 0.05;
			//LeftHand
			if (this.LeftHand.zRot < -1.3683381601951652F) this.LeftHand.zRot += 0.05;
			//Body
//			this.Body.y = 18.0F;
			if (this.Body.y > 21) this.Body.y -= 0.15;
			//RightArm
//			this.RightArm.y = 20.89F;
			if (this.RightArm.y > 23.89) this.RightArm.y -= 0.15;
			if (this.RightArm.xRot < -0.46914448828868976F) this.RightArm.xRot += 0.05;
			if (this.RightArm.yRot > 0.1563815016444822F) this.RightArm.yRot -= 0.05;
			if (this.RightArm.zRot < -1.3683381601951652F) this.RightArm.zRot += 0.05;
			//TailBase
//			this.TailBase.xRot = -0.27366763203903305F;
			if (this.TailBase.xRot > -0.11728612207217244F) this.TailBase.xRot -= 0.05;
			if (this.TailBase.yRot > 0.46914448828868976F) this.TailBase.yRot -= 0.05;
			//RightLeg
//			this.RightLeg.y = 19.99F;
			if (this.RightLeg.y > 22.99) this.RightLeg.y -= 0.15;
			if (this.RightLeg.xRot > 0.35185837453889574F) this.RightLeg.xRot -= 0.05;
			if (this.RightLeg.yRot < -1.1728612040769677F) this.RightLeg.yRot += 0.05;
			//TailEnd
//			this.TailEnd.xRot = 0.11728612207217244F;
			if (this.TailEnd.xRot < 0.0781907508222411F) this.TailEnd.xRot += 0.05;
			if (this.TailEnd.yRot > 0.46914448828868976F) this.TailEnd.yRot -= 0.05;
			//LeftLeg
//			this.LeftLeg.y = 19.99F;
			if (this.LeftLeg.y > 22.99) this.LeftLeg.y -= 0.15;
			if (this.LeftLeg.xRot > 0.35185837453889574F) this.LeftLeg.xRot -= 0.05;
			if (this.LeftLeg.yRot > 1.1728612040769677F) this.LeftLeg.yRot -= 0.05;
			//LeftArm
//			this.LeftArm.y = 20.99F;
			if (this.LeftArm.y > 22.99) this.LeftArm.y -= 0.15;
			if (this.LeftArm.xRot < -0.46914448828868976F) this.LeftArm.xRot += 0.05;
			if (this.LeftArm.yRot < -0.1563815016444822F) this.LeftArm.yRot += 0.05;
			if (this.LeftArm.zRot > 1.3683381601951652F) this.LeftArm.zRot -= 0.05;
			//LeftFoot
			if (this.LeftFoot.xRot < -0.11728612207217244F) this.LeftFoot.xRot += 0.05;
			if (this.LeftFoot.yRot > 0.03909537541112055F) this.LeftFoot.yRot -= 0.05;
			if (this.LeftFoot.zRot < -1.2510520131558576F) this.LeftFoot.zRot += 0.05;
		}
		if (entity.isAsleep()) {
			if (sleepProgress != 0) {
				//Neck
				if (this.Neck.xRot < 0.7037167490777915F) this.Neck.xRot += 0.05;
				if (this.Neck.yRot > -0.46914448828868976F) this.Neck.yRot -= 0.05;
				//RightFoot
				if (this.RightFoot.xRot > -0.11728612207217244F) this.RightFoot.xRot -= 0.05;
				if (this.RightFoot.yRot < 0.03909537541112055F) this.RightFoot.yRot += 0.05;
				if (this.RightFoot.zRot < 1.2510520131558576F) this.RightFoot.zRot += 0.05;
				//RightHand 
				if (this.RightHand.zRot < 1.3688617376654748F) this.RightHand.zRot += 0.05;
				//LeftHand
				if (this.LeftHand.zRot > -1.3683381601951652F) this.LeftHand.zRot -= 0.05;
				//Body
//				this.Body.y = 18.0F;
				if (this.Body.y < 21) this.Body.y += 0.15;
				//RightArm
//				this.RightArm.y = 20.89F;
				if (this.RightArm.y < 23.89) this.RightArm.y += 0.15;
				if (this.RightArm.xRot > -0.46914448828868976F) this.RightArm.xRot -= 0.05;
				if (this.RightArm.yRot < 0.1563815016444822F) this.RightArm.yRot += 0.05;
				if (this.RightArm.zRot > -1.3683381601951652F) this.RightArm.zRot -= 0.05;
				//TailBase
//				this.TailBase.xRot = -0.27366763203903305F;
				if (this.TailBase.xRot < -0.11728612207217244F) this.TailBase.xRot += 0.05;
				if (this.TailBase.yRot < 0.46914448828868976F) this.TailBase.yRot += 0.05;
				//RightLeg
//				this.RightLeg.y = 19.99F;
				if (this.RightLeg.y < 22.99) this.RightLeg.y += 0.15;
				if (this.RightLeg.xRot < 0.35185837453889574F) this.RightLeg.xRot += 0.05;
				if (this.RightLeg.yRot > -1.1728612040769677F) this.RightLeg.yRot -= 0.05;
				//TailEnd
//				this.TailEnd.xRot = 0.11728612207217244F;
				if (this.TailEnd.xRot > 0.0781907508222411F) this.TailEnd.xRot -= 0.05;
				if (this.TailEnd.yRot < 0.46914448828868976F) this.TailEnd.yRot += 0.05;
				//LeftLeg
//				this.LeftLeg.y = 19.99F;
				if (this.LeftLeg.y < 22.99) this.LeftLeg.y += 0.15;
				if (this.LeftLeg.xRot < 0.35185837453889574F) this.LeftLeg.xRot += 0.05;
				if (this.LeftLeg.yRot < 1.1728612040769677F) this.LeftLeg.yRot += 0.05;
				//LeftArm
//				this.LeftArm.y = 20.99F;
				if (this.LeftArm.y < 22.99) this.LeftArm.y += 0.15;
				if (this.LeftArm.xRot > -0.46914448828868976F) this.LeftArm.xRot -= 0.05;
				if (this.LeftArm.yRot > -0.1563815016444822F) this.LeftArm.yRot -= 0.05;
				if (this.LeftArm.zRot < 1.3683381601951652F) this.LeftArm.zRot += 0.05;
				//LeftFoot
				if (this.LeftFoot.xRot > -0.11728612207217244F) this.LeftFoot.xRot -= 0.05;
				if (this.LeftFoot.yRot < 0.03909537541112055F) this.LeftFoot.yRot += 0.05;
				if (this.LeftFoot.zRot > -1.2510520131558576F) this.LeftFoot.zRot -= 0.05;
			}
		} else {
			this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.RightLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.TailBase.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.TailEnd.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.TailBase.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.TailEnd.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)));
			this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;		this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.75F) + 0.5F;
			}
			if (entity.isInWater()) {
				this.RightArm.xRot = 1.25F;
				this.RightArm.yRot = 0.25F;
				this.LeftArm.xRot = 1.25F;
				this.LeftArm.yRot = -0.25F;
				this.LeftLeg.xRot = 1.25F;
				this.LeftLeg.yRot = -0.25F + (0.25F * Mth.sin(0.25F * ageInTicks / 1F));
				this.RightLeg.xRot = 1.25F;
				this.RightLeg.yRot = 0.25F + (0.25F * Mth.sin(0.25F * ageInTicks / 1F));
				this.TailBase.yRot = 0.25F * Mth.sin(0.25F * ageInTicks / 1F);
				this.TailEnd.yRot = 0.25F * Mth.sin(0.25F * ageInTicks / 1F);
				this.RightHand.zRot =  1.3688617376654748F;
				this.LeftHand.zRot = -1.3683381601951652F;
				this.RightFoot.xRot = -0.11728612207217244F;
				this.RightFoot.yRot = 0.03909537541112055F;
				this.RightFoot.zRot = 1.2510520131558576F;
				this.LeftFoot.xRot = -0.11728612207217244F;
				this.LeftFoot.yRot = 0.03909537541112055F;
				this.LeftFoot.zRot = -1.2510520131558576F;
			}
		}
	}

	public void resetModel() {
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.RightFoot.xRot = 0;
		this.RightFoot.yRot = 0;
		this.RightFoot.zRot = 0;
		this.RightHand.zRot = 0;
		this.LeftHand.zRot = 0;
		this.Body.y = 18.0F;
		this.RightArm.y = 20.89F;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.TailBase.xRot = -0.27366763203903305F;
		this.TailBase.yRot = 0;
		this.RightLeg.y = 19.99F;
		this.RightLeg.xRot = 0;
		this.RightLeg.zRot = 0;
		this.TailEnd.xRot = 0.11728612207217244F;
		this.TailEnd.yRot = 0;
		this.LeftLeg.y = 19.99F;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.zRot = 0;
		this.LeftArm.y = 20.99F;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.LeftFoot.xRot = 0;
		this.LeftFoot.yRot = 0;
		this.LeftFoot.zRot = 0;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}