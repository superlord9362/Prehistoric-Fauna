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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Triceratops;

public class TriceratopsModel extends EntityModel<Triceratops> {
	private final ModelPart RightHindLeg1;
	private final ModelPart RightHindLeg2;
	private final ModelPart RightHindLeg3;
	private final ModelPart LeftHindLeg1;
	private final ModelPart LeftHindLeg2;
	private final ModelPart LeftHindLeg3;
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head1;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart LeftFrontLeg;
	private final ModelPart RightFrontLeg;

	public TriceratopsModel(ModelPart root) {
		this.RightHindLeg1 = root.getChild("RightHindLeg1");
		this.RightHindLeg2 = RightHindLeg1.getChild("RightHindLeg2");
		this.RightHindLeg3 = RightHindLeg2.getChild("RightHindLeg3");
		this.LeftHindLeg1 = root.getChild("LeftHindLeg1");
		this.LeftHindLeg2 = LeftHindLeg1.getChild("LeftHindLeg2");
		this.LeftHindLeg3 = LeftHindLeg2.getChild("LeftHindLeg3");
		this.Body = root.getChild("Body");
		this.LeftFrontLeg = root.getChild("LeftFrontLeg");
		this.RightFrontLeg = root.getChild("RightFrontLeg");
		this.Neck = Body.getChild("Neck");
		this.Head1 = Neck.getChild("Head1");
		this.Tail1 = Body.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightHindLeg1 = partdefinition.addOrReplaceChild("RightHindLeg1", CubeListBuilder.create().texOffs(190, 0).addBox(-4.0F, -5.0F, -8.0F, 8.0F, 25.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, -10.0F, 10.0F));

		PartDefinition RightHindLeg2 = RightHindLeg1.addOrReplaceChild("RightHindLeg2", CubeListBuilder.create().texOffs(190, 50).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 19.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 6.0F));

		PartDefinition RightHindLeg3 = RightHindLeg2.addOrReplaceChild("RightHindLeg3", CubeListBuilder.create().texOffs(157, 0).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 1.0F));

		PartDefinition LeftHindLeg1 = partdefinition.addOrReplaceChild("LeftHindLeg1", CubeListBuilder.create().texOffs(190, 0).addBox(-4.0F, -5.0F, -8.0F, 8.0F, 25.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, -10.0F, 10.0F));

		PartDefinition LeftHindLeg2 = LeftHindLeg1.addOrReplaceChild("LeftHindLeg2", CubeListBuilder.create().texOffs(190, 50).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 19.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 6.0F));

		PartDefinition LeftHindLeg3 = LeftHindLeg2.addOrReplaceChild("LeftHindLeg3", CubeListBuilder.create().texOffs(157, 0).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 1.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -8.0F, -24.0F, 24.0F, 31.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 4.0F, 0.0221F, 0.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(98, 0).addBox(-5.0F, -5.0F, -16.0F, 10.0F, 19.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -22.0F, 0.0721F, 0.0F, 0.0F));

		PartDefinition Head1 = Neck.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(0, 130).addBox(-6.0F, -3.0F, -12.0F, 12.0F, 18.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.4779F, 0.0F, 0.0F));

		PartDefinition Crest = Head1.addOrReplaceChild("Crest", CubeListBuilder.create().texOffs(58, 127).addBox(-14.0F, -23.0F, -5.0F, 28.0F, 25.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, -3.0F, -0.5918F, 0.0F, 0.0F));

		PartDefinition horn1 = Head1.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(60, 165).addBox(-1.0F, -4.0F, -20.0F, 3.0F, 4.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9F, -1.0F, -12.0F, -0.7285F, 0.182F, 0.0F));

		PartDefinition Snout = Head1.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 169).addBox(-4.0F, 0.0F, -14.0F, 8.0F, 13.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -12.0F));

		PartDefinition Beak = Snout.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(0, 204).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -14.0F));

		PartDefinition nasalhorn = Snout.addOrReplaceChild("nasalhorn", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -5.0F, -3.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -12.0F, 0.6374F, 0.0F, 0.0F));

		PartDefinition horn1_1 = Head1.addOrReplaceChild("horn1_1", CubeListBuilder.create().texOffs(60, 165).addBox(-2.0F, -4.0F, -20.0F, 3.0F, 4.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9F, -1.0F, -12.0F, -0.7285F, -0.182F, 0.0F));

		PartDefinition Saddle = Body.addOrReplaceChild("Saddle", CubeListBuilder.create().texOffs(112, 172).addBox(-12.0F, -8.0F, -24.0F, 24.0F, 31.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Chest3 = Saddle.addOrReplaceChild("Chest3", CubeListBuilder.create().texOffs(215, 163).addBox(-3.0F, 0.0F, -3.0F, 3.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, -2.0F, -15.0F));

		PartDefinition Chest4 = Saddle.addOrReplaceChild("Chest4", CubeListBuilder.create().texOffs(215, 163).mirror().addBox(0.0F, 0.0F, -3.0F, 3.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.0F, -2.0F, -15.0F));

		PartDefinition Saddle2 = Saddle.addOrReplaceChild("Saddle2", CubeListBuilder.create().texOffs(141, 143).addBox(-14.0F, -4.0F, -4.0F, 28.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 14.0F));

		PartDefinition Chest1 = Saddle.addOrReplaceChild("Chest1", CubeListBuilder.create().texOffs(207, 182).addBox(-6.0F, 0.0F, -6.0F, 6.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, -11.0F, 8.0F));

		PartDefinition Chest2 = Saddle.addOrReplaceChild("Chest2", CubeListBuilder.create().texOffs(207, 182).mirror().addBox(0.0F, 0.0F, -6.0F, 6.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.0F, -11.0F, 8.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 77).addBox(-6.0F, -3.0F, -2.0F, 12.0F, 13.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 19.0F, -0.3302F, -0.1155F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(82, 77).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 8.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 19.0F, 0.1198F, -0.1155F, 0.0F));

		PartDefinition quills = Tail1.addOrReplaceChild("quills", CubeListBuilder.create().texOffs(48, 77).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 2.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -1.0F));

		PartDefinition LeftFrontLeg = partdefinition.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(220, 75).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 27.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, -3.0F, -14.0F));

		PartDefinition RightFrontLeg = partdefinition.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(220, 75).mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 27.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(11.0F, -3.0F, -14.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Triceratops entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 1.0f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick) * 2.0F;
		int sleepProgress = entity.getSleepingTicks();
		int wakingProgress = entity.getWakingUpTicks();
		if (!entity.isWakingUp() && !entity.isFallingAsleep()) {
			if (!entity.isSleeping()) {
				resetModel();
			} else {
				this.LeftHindLeg3.xRot = 1.5707963267948966F;
				this.RightFrontLeg.xRot = -1.2915436464758039F;
				this.RightFrontLeg.yRot = -0.3490658503988659F;
				this.Tail2.xRot = 0.16929693411449862F;
				this.Tail2.yRot = 0.35185837453889574F;
				this.Tail2.zRot = 0.1563815016444822F;
				this.RightHindLeg1.xRot = -0.8726646259971648F;
				this.RightHindLeg1.yRot = 0.23457224414434488F;
				this.Neck.xRot = 0.27366763203903305F;
				this.Neck.yRot = -0.5473352640780661F;
				this.LeftHindLeg1.xRot = -0.8726646259971648F;
				this.LeftHindLeg1.yRot = -0.23457224414434488F;
				this.RightHindLeg3.xRot = 1.5707963267948966F;
				this.Head1.xRot = -0.007330382629510778F;
				this.LeftHindLeg2.xRot =-0.6981317007977318F;
				this.Tail1.xRot = -0.5141739816585629F;
				this.Tail1.yRot = 0.35185837453889574F;
				this.LeftFrontLeg.xRot = -1.0557496272471145F;
				this.LeftFrontLeg.yRot = -0.03909537541112055F;
				this.LeftFrontLeg.zRot = -0.4300491170387584F;
				this.RightHindLeg2.xRot = -0.6981317007977318F;
				this.Body.y = 1;
				this.LeftHindLeg1.y = 4;
				this.LeftHindLeg1.z = 14;
				this.LeftHindLeg2.y = 15.3F;
				this.LeftHindLeg2.z = 8;
				this.LeftHindLeg3.y = 15;
				this.LeftHindLeg3.z = 1;
				this.RightHindLeg1.y = 4;
				this.RightHindLeg1.z = 14;
				this.RightHindLeg2.y = 15.3F;
				this.RightHindLeg2.z = 8;
				this.RightHindLeg3.y = 15;
				this.RightHindLeg3.z = 1;
				this.RightFrontLeg.y = 12;
				this.LeftFrontLeg.y = 12;
			}
		}
		if (wakingProgress != 0) {
			//LeftHindLeg3
//			this.LeftHindLeg3.y = 14;
			if (this.LeftHindLeg3.y > 14) this.LeftHindLeg3.y -= 0.15;
			if (this.LeftHindLeg3.xRot > 0) this.LeftHindLeg3.xRot -= 0.05;
			//RightFrontLeg
//			this.RightFrontLeg.y = -3;
			if (this.RightFrontLeg.y > -3) this.RightFrontLeg.y -= 0.15;
			if (this.RightFrontLeg.xRot < 0) this.RightFrontLeg.xRot += 0.05;
			if (this.RightFrontLeg.yRot < 0) this.RightFrontLeg.yRot += 0.05;
			//Tail2
			if (this.Tail2.xRot > 0) this.Tail2.xRot -= 0.05;
			if (this.Tail2.yRot > 0) this.Tail2.yRot -= 0.05;
			if (this.Tail2.zRot > 0) this.Tail2.zRot -= 0.05;
			//RightHindLeg1
//			this.RightHindLeg1.y = -10;
//			this.RightHindLeg1.z = 10;
			if (this.RightHindLeg1.y > -10) this.RightHindLeg1.y -= 0.15;
			if (this.RightHindLeg1.z > 10) this.RightHindLeg1.z -= 0.15;
			if (this.RightHindLeg1.xRot < 0) this.RightHindLeg1.xRot += 0.05;
			if (this.RightHindLeg1.yRot > 0) this.RightHindLeg1.yRot -= 0.05;
			//Neck
			if (this.Neck.xRot > 0) this.RightHindLeg1.xRot -= 0.05;
			if (this.Neck.yRot < 0) this.RightHindLeg1.yRot += 0.05;
			//LeftHindLeg1
//			this.LeftHindLeg1.y = -10;
//			this.LeftHindLeg1.z = 10;
			if (this.LeftHindLeg1.y > -10) this.LeftHindLeg1.y -= 0.15;
			if (this.LeftHindLeg1.z > 10) this.LeftHindLeg1.z -= 0.15;
			if (this.LeftHindLeg1.xRot < 0) this.LeftHindLeg1.xRot += 0.05;
			if (this.LeftHindLeg1.yRot < 0) this.LeftHindLeg1.yRot += 0.05;
			//RightHindLeg3
//			this.RightHindLeg3.y = 14;
			if (this.RightHindLeg3.y > 14) this.RightHindLeg3.y -= 0.15;
			if (this.RightHindLeg3.xRot > 0) this.RightHindLeg3.xRot -= 0.05;
			//Head
			if (this.Head1.xRot < 0) this.Head1.xRot += 0.05;
			//LeftHindLeg2
//			this.LeftHindLeg2.y = 17;
//			this.LeftHindLeg2.z = 6;
			if (this.LeftHindLeg2.y < 17) this.LeftHindLeg2.y += 0.15;
			if (this.LeftHindLeg2.z > 6) this.LeftHindLeg2.z -= 0.15;
			if (this.LeftHindLeg2.xRot < 0) this.LeftHindLeg2.xRot += 0.05;
			//Tail1
			if (this.Tail1.xRot < 0) this.Tail1.xRot += 0.05;
			if (this.Tail1.yRot > 0) this.Tail1.yRot -= 0.05;
			//LeftFrontLeg
//			this.LeftFrontLeg.y = -3;
			if (this.LeftFrontLeg.y > -3) this.LeftFrontLeg.y -= 0.15;
			if (this.LeftFrontLeg.xRot < 0) this.LeftFrontLeg.xRot += 0.05;
			if (this.LeftFrontLeg.yRot < 0) this.LeftFrontLeg.yRot += 0.05;
			if (this.LeftFrontLeg.zRot < 0) this.LeftFrontLeg.zRot += 0.05;
			//RightHindLeg2
//			this.RightHindLeg2.y = 17;
//			this.RightHindLeg2.z = 6;
			if (this.RightHindLeg2.y < 17) this.RightHindLeg2.y += 0.15;
			if (this.RightHindLeg2.z > 6) this.RightHindLeg2.z -= 0.15;
			if (this.RightHindLeg2.xRot < 0) this.RightHindLeg2.xRot += 0.05;
			//Body
//			this.Body.y = -14;
			if (this.Body.y > -14) this.Body.y -= 0.15;
		}
		if (entity.isSleeping()) {
			if (sleepProgress != 0) {
				//LeftHindLeg3
//				this.LeftHindLeg3.y = 14;
				if (this.LeftHindLeg3.y < 15) this.LeftHindLeg3.y += 0.15;
				if (this.LeftHindLeg3.xRot < 1.5707963267948966F) this.LeftHindLeg3.xRot += 0.05;
				//RightFrontLeg
//				this.RightFrontLeg.y = -3;
				if (this.RightFrontLeg.y < 12) this.RightFrontLeg.y += 0.15;
				if (this.RightFrontLeg.xRot > -1.2915436464758039F) this.RightFrontLeg.xRot -= 0.05;
				if (this.RightFrontLeg.yRot > -0.3490658503988659F) this.RightFrontLeg.yRot -= 0.05;
				//Tail2
				if (this.Tail2.xRot < 0.16929693411449862F) this.Tail2.xRot += 0.05;
				if (this.Tail2.yRot < 0.35185837453889574F) this.Tail2.yRot += 0.05;
				if (this.Tail2.zRot < 0.1563815016444822F) this.Tail2.zRot += 0.05;
				//RightHindLeg1
//				this.RightHindLeg1.y = -10;
//				this.RightHindLeg1.z = 10;
				if (this.RightHindLeg1.y < 4) this.RightHindLeg1.y += 0.15;
				if (this.RightHindLeg1.z < 14) this.RightHindLeg1.z += 0.15;
				if (this.RightHindLeg1.xRot > -0.8726646259971648F) this.RightHindLeg1.xRot -= 0.05;
				if (this.RightHindLeg1.yRot < 0.23457224414434488F) this.RightHindLeg1.yRot += 0.05;
				//Neck
				if (this.Neck.xRot < 0.27366763203903305F) this.RightHindLeg1.xRot += 0.05;
				if (this.Neck.yRot > -0.5473352640780661F) this.RightHindLeg1.yRot -= 0.05;
				//LeftHindLeg1
//				this.LeftHindLeg1.y = -10;
//				this.LeftHindLeg1.z = 10;
				if (this.LeftHindLeg1.y < 4) this.LeftHindLeg1.y += 0.15;
				if (this.LeftHindLeg1.z < 14) this.LeftHindLeg1.z += 0.15;
				if (this.LeftHindLeg1.xRot > -0.8726646259971648F) this.LeftHindLeg1.xRot -= 0.05;
				if (this.LeftHindLeg1.yRot > -0.23457224414434488F) this.LeftHindLeg1.yRot -= 0.05;
				//RightHindLeg3
//				this.RightHindLeg3.y = 14;
				if (this.RightHindLeg3.y < 15) this.RightHindLeg3.y += 0.15;
				if (this.RightHindLeg3.xRot < 1.5707963267948966F) this.RightHindLeg3.xRot += 0.05;
				//Head
				if (this.Head1.xRot > -0.007330382629510778F) this.Head1.xRot -= 0.05;
				//LeftHindLeg2
//				this.LeftHindLeg2.y = 17;
//				this.LeftHindLeg2.z = 6;
				if (this.LeftHindLeg2.y > 15.3) this.LeftHindLeg2.y -= 0.15;
				if (this.LeftHindLeg2.z < 8) this.LeftHindLeg2.z += 0.15;
				if (this.LeftHindLeg2.xRot > -0.6981317007977318F) this.LeftHindLeg2.xRot -= 0.05;
				//Tail1
				if (this.Tail1.xRot > -0.5141739816585629F) this.Tail1.xRot -= 0.05;
				if (this.Tail1.yRot < 0.35185837453889574F) this.Tail1.yRot += 0.05;
				//LeftFrontLeg
//				this.LeftFrontLeg.y = -3;
				if (this.LeftFrontLeg.y < 12) this.LeftFrontLeg.y += 0.15;
				if (this.LeftFrontLeg.xRot > -1.0557496272471145F) this.LeftFrontLeg.xRot -= 0.05;
				if (this.LeftFrontLeg.yRot > -0.03909537541112055F) this.LeftFrontLeg.yRot -= 0.05;
				if (this.LeftFrontLeg.zRot > -0.4300491170387584F) this.LeftFrontLeg.zRot -= 0.05;
				//RightHindLeg2
//				this.RightHindLeg2.y = 17;
//				this.RightHindLeg2.z = 6;
				if (this.RightHindLeg2.y > 15.3) this.RightHindLeg2.y -= 0.15;
				if (this.RightHindLeg2.z < 8) this.RightHindLeg2.z += 0.15;
				if (this.RightHindLeg2.xRot > -0.6981317007977318F) this.RightHindLeg2.xRot -= 0.05;
				//Body
//				this.Body.y = -14;
				if (this.Body.y < 1) this.Body.y += 0.15;
			}
		} else {
			this.RightFrontLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount + attackProgress * (float) Math.toRadians(15F);
			this.LeftFrontLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount + attackProgress * (float) Math.toRadians(15F);
			this.LeftHindLeg1.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * 0.4F * limbSwingAmount + attackProgress * (float) Math.toRadians(7F);
			this.LeftHindLeg2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
			this.LeftHindLeg3.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
			this.RightHindLeg1.xRot = Mth.cos(1.0F + limbSwing * speed * 0.3F) * degree * -0.4F * limbSwingAmount + attackProgress * (float) Math.toRadians(7F);
			this.RightHindLeg2.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.3F * limbSwingAmount;
			this.RightHindLeg3.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.3F * limbSwingAmount;
			this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.05F * limbSwingAmount);
			this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(-1.0F + limbSwing * speed * 0.15F) * degree * 0.15F * limbSwingAmount);
			this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.3F);
			this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
			this.Body.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3));
			this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.05F);
			this.Head1.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.05F * limbSwingAmount + 0.5F) + attackProgress * (float) Math.toRadians(25F);
			this.Body.z = 4.0F + attackProgress * -8F;
			this.RightFrontLeg.z = -14.0F + attackProgress * -6F;
			this.LeftFrontLeg.z = -14.0F + attackProgress * -6F;
			this.RightHindLeg1.z = 10.0F + attackProgress * -6F;
			this.LeftHindLeg1.z = 10.0F + attackProgress * -6F;
			if (entity.isEating()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.25F) + 0.15F;
				this.Body.xRot = 0.1F;
			}
			if (entity.isInWater()) {
				this.Body.y = 8;
				this.LeftHindLeg1.y = 12;
				this.RightHindLeg1.y = 12;
				this.LeftFrontLeg.y = 19;
				this.RightFrontLeg.y = 19;
				this.LeftHindLeg1.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightHindLeg1.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightFrontLeg.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftFrontLeg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftHindLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightHindLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftHindLeg3.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.RightHindLeg3.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.Neck.xRot = -0.35F;
				this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}
	
	public void resetModel() {
		this.RightFrontLeg.xRot = 0;
		this.RightFrontLeg.yRot = 0;
		this.Head1.xRot = 0;
		this.LeftFrontLeg.xRot = 0;
		this.LeftFrontLeg.yRot = 0;
		this.LeftFrontLeg.zRot = 0;
		this.LeftHindLeg3.zRot = 0;
		this.RightHindLeg1.xRot = 0;
		this.RightHindLeg1.yRot = 0;
		this.LeftHindLeg1.xRot = 0;
		this.LeftHindLeg1.yRot = 0;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.RightHindLeg2.xRot = 0;
		this.RightHindLeg2.zRot = 0;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Tail2.zRot = 0;
		this.LeftHindLeg2.xRot = 0;
		this.LeftHindLeg2.zRot = 0;
		this.Body.y = -14;
		this.LeftHindLeg1.y = -10;
		this.LeftHindLeg1.z = 10;
		this.LeftHindLeg2.y = 17;
		this.LeftHindLeg2.z = 6;
		this.LeftHindLeg3.y = 14;
		this.RightHindLeg1.y = -10;
		this.RightHindLeg1.z = 10;
		this.RightHindLeg2.y = 17;
		this.RightHindLeg2.z = 6;
		this.RightHindLeg3.y = 14;
		this.RightFrontLeg.y = -3;
		this.LeftFrontLeg.y = -3;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightHindLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftHindLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}