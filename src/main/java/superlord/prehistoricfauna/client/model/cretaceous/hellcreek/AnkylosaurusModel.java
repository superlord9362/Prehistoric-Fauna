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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Ankylosaurus;

public class AnkylosaurusModel extends EntityModel<Ankylosaurus> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head1;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart TailClub;
	private final ModelPart LeftFrontLeg;
	private final ModelPart RightFrontLeg;
	private final ModelPart RightHindLeg1;
	private final ModelPart RightHindLeg2;
	private final ModelPart RightHindLeg3;
	private final ModelPart LeftHindLeg1;
	private final ModelPart LeftHindLeg2;
	private final ModelPart LeftHindLeg3;

	public AnkylosaurusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Head1 = Neck.getChild("Head1");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.TailClub = Tail2.getChild("TailClub");
		this.RightFrontLeg = Body.getChild("RightFrontLeg");
		this.LeftFrontLeg = Body.getChild("LeftFrontLeg");
		this.LeftHindLeg1 = Body.getChild("LeftHindLeg1");
		this.LeftHindLeg2 = LeftHindLeg1.getChild("LeftHindLeg2");
		this.LeftHindLeg3 = LeftHindLeg2.getChild("LeftHindLeg3");
		this.RightHindLeg1 = Body.getChild("RightHindLeg1");
		this.RightHindLeg2 = RightHindLeg1.getChild("RightHindLeg2");
		this.RightHindLeg3 = RightHindLeg2.getChild("RightHindLeg3");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-15.5F, -9.0F, -34.0F, 31.0F, 22.0F, 52.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 12.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 79).addBox(-6.0F, -3.0F, -4.0F, 12.0F, 13.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 18.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(45, 87).addBox(-2.5F, -3.0F, -5.0F, 5.0F, 6.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 17.0F));

		PartDefinition TailClub = Tail2.addOrReplaceChild("TailClub", CubeListBuilder.create().texOffs(94, 85).addBox(-5.5F, -4.0F, 0.0F, 11.0F, 8.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 21.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(121, 16).addBox(-5.0F, -6.0F, -12.0F, 10.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -34.0F));

		PartDefinition Head1 = Neck.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(152, 97).addBox(-7.0F, -5.0F, -12.0F, 14.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.1F, -12.0F));

		PartDefinition Spike1 = Head1.addOrReplaceChild("Spike1", CubeListBuilder.create().texOffs(0, 33).addBox(-1.0F, -3.0F, 0.0F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -3.0F, 0.0F, 0.0911F, -0.2731F, 0.0F));

		PartDefinition Spike1_1 = Head1.addOrReplaceChild("Spike1_1", CubeListBuilder.create().texOffs(0, 33).addBox(-4.0F, -3.0F, 0.0F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -3.0F, 0.0F, 0.0911F, 0.2731F, 0.0F));

		PartDefinition Spike4 = Head1.addOrReplaceChild("Spike4", CubeListBuilder.create().texOffs(29, 32).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 2.0F, -2.0F, 0.0F, 0.9105F, 0.0F));

		PartDefinition Head2 = Head1.addOrReplaceChild("Head2", CubeListBuilder.create().texOffs(200, 93).addBox(-5.5F, -3.0F, -3.0F, 11.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -12.0F));

		PartDefinition Spike3 = Head1.addOrReplaceChild("Spike3", CubeListBuilder.create().texOffs(29, 32).addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 2.0F, -2.0F, 0.0F, -0.9105F, 0.0F));

		PartDefinition RightHindLeg1 = Body.addOrReplaceChild("RightHindLeg1", CubeListBuilder.create().texOffs(190, 33).mirror().addBox(-5.0F, -4.0F, -8.0F, 10.0F, 19.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(13.0F, 0.0F, 8.0F));

		PartDefinition RightHindLeg2 = RightHindLeg1.addOrReplaceChild("RightHindLeg2", CubeListBuilder.create().texOffs(200, 0).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 3.0F));

		PartDefinition RightHindLeg3 = RightHindLeg2.addOrReplaceChild("RightHindLeg3", CubeListBuilder.create().texOffs(157, 0).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 3.0F));

		PartDefinition RightFrontLeg = Body.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, -3.0F, -4.0F, 7.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(13.0F, 6.0F, -26.0F));

		PartDefinition LeftHindLeg1 = Body.addOrReplaceChild("LeftHindLeg1", CubeListBuilder.create().texOffs(190, 33).addBox(-5.0F, -4.0F, -8.0F, 10.0F, 19.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.0F, 0.0F, 8.0F));

		PartDefinition LeftHindLeg2 = LeftHindLeg1.addOrReplaceChild("LeftHindLeg2", CubeListBuilder.create().texOffs(200, 0).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 3.0F));

		PartDefinition LeftHindLeg3 = LeftHindLeg2.addOrReplaceChild("LeftHindLeg3", CubeListBuilder.create().texOffs(157, 0).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 3.0F));

		PartDefinition LeftFrontLeg = Body.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -3.0F, -4.0F, 7.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.0F, 6.0F, -26.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(Ankylosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		if (entity.getWakingTicks() >= 31 && entity.getFallingAsleepTicks() >= 31) {
			if (entity.isAsleep()) {
				sleepPose();
			} else {
				resetModel();
				this.LeftFrontLeg.xRot = -Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.RightFrontLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.RightHindLeg1.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.RightHindLeg2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.RightHindLeg3.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount;
				this.LeftHindLeg1.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.LeftHindLeg2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.LeftHindLeg3.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount;
				this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount) + attackProgress * leftOrRight * (float)Math.toRadians(-15);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount) + attackProgress * leftOrRight * (float)Math.toRadians(-25);
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
				this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F);
				this.Head1.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.05F);
				this.Body.yRot = attackProgress * leftOrRight * (float)Math.toRadians(-200);
				this.Tail1.zRot = attackProgress * leftOrRight * (float)Math.toRadians(15);
				this.Body.z = 12.0F + attackProgress * -22;
				if (entity.isEating() || entity.isTuberDigging()) {
					this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
					this.Body.xRot = 0.1F;
					this.LeftHindLeg1.xRot = -0.1F;
					this.RightHindLeg1.xRot = -0.1F;
					this.RightFrontLeg.xRot = -0.1F;
					this.LeftFrontLeg.xRot = -0.1F;
					this.RightFrontLeg.zRot = 0.3F;
					this.LeftFrontLeg.zRot = -0.3F;
				}
			}
		}
		if (entity.getWakingTicks() < 31) {
			//Body
//			this.Body.y = 1;
			if (this.Body.y > 1) this.Body.y -= 0.15;
			if (this.Body.xRot < -0.03909537541112055F) this.Body.xRot += 0.05;
			//Head1
//			this.Head1.y = -1;
			if (this.Head1.y < -1F) this.Body.y -= 0.15;
			if (this.Head1.xRot < 0.3186971254089062F) this.Head1.xRot += 0.05;
			if (this.Head1.yRot > 0) this.Head1.yRot -= 0.05;
			if (this.Head1.zRot < 0) this.Head1.zRot += 0.05;
			//RightHindLeg3
			if (this.RightHindLeg3.xRot > 0) this.RightHindLeg3.xRot -= 0.05;
			//LeftHindLeg1
			if (this.LeftHindLeg1.yRot < 0) this.LeftHindLeg1.yRot += 0.05;
			//RightHindLeg1
			if (this.RightHindLeg1.xRot > 0) this.RightHindLeg1.xRot -= 0.05;
			if (this.RightHindLeg1.yRot > 0) this.RightHindLeg1.yRot -= 0.05;
			//RightFrontLeg
//			this.RightFrontLeg.x = -14F;
			if (this.RightFrontLeg.x < -14F) this.RightFrontLeg.x += 0.15;
			if (this.RightFrontLeg.xRot < 0) this.RightFrontLeg.xRot += 0.05;
			if (this.RightFrontLeg.yRot < 0) this.RightFrontLeg.yRot += 0.05;
			if (this.RightFrontLeg.zRot < 0) this.RightFrontLeg.zRot += 0.05;
			//Tail2
			if (this.Tail2.xRot < 0.13665927909957545F) this.Tail2.xRot += 0.05;
			if (this.Tail2.yRot < 0) this.Tail2.yRot += 0.05;
			//RightHindLeg2
			if (this.RightHindLeg2.xRot < 0) this.RightHindLeg2.xRot += 0.05;
			if (this.RightHindLeg2.yRot > 0) this.RightHindLeg2.yRot -= 0.05;
			if (this.RightHindLeg2.zRot > 0) this.RightHindLeg2.zRot -= 0.05;
			//LeftHindLeg3
			if (this.LeftHindLeg3.xRot > 0) this.LeftHindLeg3.xRot -= 0.05;
			//LeftFrontLeg
//			this.LeftFrontLeg.x = 14F;
			if (this.LeftFrontLeg.x > 14F) this.LeftFrontLeg.x -= 0.15;
			if (this.LeftFrontLeg.xRot < 0) this.LeftFrontLeg.xRot += 0.05;
			if (this.LeftFrontLeg.yRot > 0) this.LeftFrontLeg.yRot -= 0.05;
			if (this.LeftFrontLeg.zRot > 0) this.LeftFrontLeg.zRot -= 0.05;
			//LeftHindLeg2
			if (this.LeftHindLeg2.xRot < 0) this.LeftHindLeg2.xRot += 0.05;
			if (this.LeftHindLeg2.yRot < 0) this.LeftHindLeg2.yRot += 0.05;
			//Neck
			if (this.Neck.xRot > -0.18203784630933073F) this.Neck.xRot -= 0.05;
			if (this.Neck.yRot > 0) this.Neck.yRot -= 0.05;
			if (this.Neck.zRot < 0) this.Neck.zRot += 0.05;
			//Tail1
			if (this.Tail1.xRot >  -0.2275909337942703F) this.Tail1.xRot -= 0.05;
			if (this.Tail1.yRot < 0) this.Tail1.yRot += 0.05;
		}
		if (entity.getFallingAsleepTicks() < 31) {
			//Body
//			this.Body.y = 1;
			if (this.Body.y < 9) this.Body.y += 0.15;
			if (this.Body.xRot > -0.03909537541112055F) this.Body.xRot -= 0.05;
			//Head1
//			this.Head1.y = -1;
			if (this.Head1.y > -1.5F) this.Body.y += 0.15;
			if (this.Head1.xRot > 0.02827433396553192F) this.Head1.xRot -= 0.05;
			if (this.Head1.yRot < 0.11728612207217244F) this.Head1.yRot += 0.05;
			if (this.Head1.zRot > -0.11746065899211351F) this.Head1.zRot -= 0.05;
			//RightHindLeg3
			if (this.RightHindLeg3.xRot < 1.5645131308350726F) this.RightHindLeg3.xRot += 0.05;
			//LeftHindLeg1
			if (this.LeftHindLeg1.yRot > -0.15707963267948966F) this.LeftHindLeg1.yRot -= 0.05;
			//RightHindLeg1
			if (this.RightHindLeg1.xRot < 0.017453292519943295F) this.RightHindLeg1.xRot += 0.05;
			if (this.RightHindLeg1.yRot < 0.15707963267948966F) this.RightHindLeg1.yRot += 0.05;
			//RightFrontLeg
//			this.RightFrontLeg.x = -14F;
			if (this.RightFrontLeg.x > -16.75F) this.RightFrontLeg.x -= 0.15;
			if (this.RightFrontLeg.xRot > -0.8208283259076444F) this.RightFrontLeg.xRot -= 0.05;
			if (this.RightFrontLeg.yRot > -0.3909537457888271F) this.RightFrontLeg.yRot -= 0.05;
			if (this.RightFrontLeg.zRot > -0.31293754020890546F) this.RightFrontLeg.zRot -= 0.05;
			//Tail2
			if (this.Tail2.xRot > 0.03263765709551775F) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot > -0.11728612207217244F) this.Tail2.yRot -= 0.05;
			//RightHindLeg2
			if (this.RightHindLeg2.xRot > -1.5317009888344788F) this.RightHindLeg2.xRot -= 0.05;
			if (this.RightHindLeg2.yRot < 0.33021629580890766F) this.RightHindLeg2.yRot += 0.05;
			if (this.RightHindLeg2.zRot < 0.017453292519943295F) this.RightHindLeg2.zRot += 0.05;
			//LeftHindLeg3
			if (this.LeftHindLeg3.xRot < 1.5247196451948906F) this.LeftHindLeg3.xRot += 0.05;
			//LeftFrontLeg
//			this.LeftFrontLeg.x = 14F;
			if (this.LeftFrontLeg.x < 14.5F) this.LeftFrontLeg.x += 0.15;
			if (this.LeftFrontLeg.xRot > -0.8990190684075072F) this.LeftFrontLeg.xRot -= 0.05;
			if (this.LeftFrontLeg.yRot < 0.31293754020890546F) this.LeftFrontLeg.yRot += 0.05;
			if (this.LeftFrontLeg.zRot < 0.07644542323472245F) this.LeftFrontLeg.zRot += 0.05;
			//LeftHindLeg2
			if (this.LeftHindLeg2.xRot > -1.5247196451948906F) this.LeftHindLeg2.xRot -= 0.05;
			if (this.LeftHindLeg2.yRot > -0.2738421523142173F) this.LeftHindLeg2.yRot -= 0.05;
			//Neck
			if (this.Neck.xRot < 0.3862413488189591F) this.Neck.xRot += 0.05;
			if (this.Neck.yRot < 0.11728612207217244F) this.Neck.yRot += 0.05;
			if (this.Neck.zRot > -0.1563815016444822F) this.Neck.zRot -= 0.05;
			//Tail1
			if (this.Tail1.xRot < -0.18901915665940536F) this.Tail1.xRot += 0.05;
			if (this.Tail1.yRot > -0.27366763203903305F) this.Tail1.yRot -= 0.05;
		}
	}
	
	public void resetModel() {
		this.Head1.xRot = 0.3186971254089062F;
		this.Head1.yRot = 0;
		this.Head1.zRot = 0;
		this.TailClub.xRot = 0;
		this.TailClub.yRot = 0;
		this.RightHindLeg3.xRot = 0;
		this.LeftHindLeg1.yRot = 0;
		this.RightHindLeg1.xRot = 0;
		this.RightHindLeg1.yRot = 0;
		this.Body.xRot = 0;
		this.RightFrontLeg.xRot = 0;
		this.RightFrontLeg.yRot = 0;
		this.RightFrontLeg.zRot = 0;
		this.Tail2.xRot = 0.13665927909957545F;
		this.Tail2.yRot = 0;
		this.RightHindLeg2.xRot = 0;
		this.RightHindLeg2.yRot = 0;
		this.RightHindLeg2.zRot = 0;
		this.LeftHindLeg3.xRot = 0;
		this.LeftFrontLeg.xRot = 0;
		this.LeftFrontLeg.yRot = 0;
		this.LeftFrontLeg.zRot = 0;
		this.LeftHindLeg2.xRot = 0;
		this.LeftHindLeg2.yRot = 0;
		this.Neck.xRot = -0.18203784630933073F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Tail1.xRot = -0.2275909337942703F;
		this.Tail1.yRot = 0;
		this.Body.y = 1;
		this.Head1.y = -1;
		this.RightFrontLeg.x = -14F;
		this.LeftFrontLeg.x = 14F;
		this.Body.xRot = 0F;
		this.LeftHindLeg1.xRot = -0F;
		this.RightHindLeg1.xRot = -0F;
		this.RightFrontLeg.xRot = -0F;
		this.LeftFrontLeg.xRot = -0F;
		this.RightFrontLeg.zRot = 0F;
		this.LeftFrontLeg.zRot = -0F;
	}
	
	public void sleepPose() {
		this.Body.y = 9;
		this.Head1.xRot = 0.02827433396553192F;
		this.Head1.yRot = 0.11728612207217244F;
		this.Head1.zRot = -0.11746065899211351F;
		this.RightHindLeg3.xRot = 1.5645131308350726F;
		this.LeftHindLeg1.yRot = -0.15707963267948966F;
		this.RightHindLeg1.xRot = 0.017453292519943295F;
		this.RightHindLeg1.yRot = 0.15707963267948966F;
		this.Body.xRot = -0.03909537541112055F;
		this.RightFrontLeg.xRot = -0.8208283259076444F;
		this.RightFrontLeg.yRot = -0.3909537457888271F;
		this.RightFrontLeg.zRot = -0.31293754020890546F;
		this.Tail2.xRot = 0.03263765709551775F;
		this.Tail2.yRot = -0.11728612207217244F;
		this.RightHindLeg2.xRot = -1.5317009888344788F;
		this.RightHindLeg2.yRot = 0.33021629580890766F;
		this.RightHindLeg2.zRot = 0.017453292519943295F;
		this.LeftHindLeg3.xRot = 1.5247196451948906F;
		this.LeftFrontLeg.xRot = -0.8990190684075072F;
		this.LeftFrontLeg.yRot = 0.31293754020890546F;
		this.LeftFrontLeg.zRot = 0.07644542323472245F;
		this.LeftHindLeg2.xRot = -1.5247196451948906F;
		this.LeftHindLeg2.yRot = -0.2738421523142173F;
		this.Neck.xRot = 0.3862413488189591F;
		this.Neck.yRot = 0.11728612207217244F;
		this.Neck.zRot = -0.1563815016444822F;
		this.Tail1.xRot = -0.18901915665940536F;
		this.Tail1.yRot = -0.27366763203903305F;
		this.Head1.y = -1.5F;
		this.RightFrontLeg.x = -16.75F; 
		this.LeftFrontLeg.x = 14.5F; 
		this.RightHindLeg1.xRot = 0;
		this.LeftHindLeg1.xRot = 0;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}