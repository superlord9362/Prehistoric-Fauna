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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Gargoyleosaurus;

public class GargoyleosaurusModel extends EntityModel<Gargoyleosaurus> {
	private final ModelPart root;
	private final ModelPart Body;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;

	public GargoyleosaurusModel(ModelPart root) {
		this.root = root.getChild("root");
		this.Body = this.root.getChild("Body");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.Tail1 = this.Body.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.Neck = this.Body.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.LeftThigh = this.root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.RightThigh = this.root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 14.5F, -16.0F));

		PartDefinition Body = root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-10.5F, -2.5F, -12.0F, 21.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-5.5F, -4.5F, -12.0F, 11.0F, 8.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 19.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(54, 60).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 3.5F, -10.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(54, 60).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 3.5F, -10.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(53, 15).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(46, 40).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 4.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 55).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 40).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(54, 29).addBox(-2.0F, -1.0F, -6.0F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(46, 49).addBox(-7.0F, 0.0F, -6.0F, 14.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, -12.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(69, 56).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(70, 62).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -6.0F));

		PartDefinition LeftThigh = root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(42, 70).mirror().addBox(-3.0F, -1.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 1.0F, 19.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(46, 64).mirror().addBox(-1.5F, 3.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(42, 57).mirror().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 4.5F, -1.0F));

		PartDefinition RightThigh = root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(42, 70).addBox(-1.0F, -1.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 1.0F, 19.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(46, 64).addBox(-1.5F, 3.0F, -1.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(42, 57).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 4.5F, -1.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Gargoyleosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		float sleepProgress = entity.getSleepProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.root.y = Mth.lerp(sleepProgress, 14.5F, 19.5F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0, 0.02827433396553192F);
				this.Head.yRot = Mth.lerp(sleepProgress, 0, 0.11728612207217244F);
				this.Head.zRot = Mth.lerp(sleepProgress, 0, -0.11746065899211351F);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, 0, -0.15707963267948966F);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0, 0.017453292519943295F);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0, 0.15707963267948966F);
				this.Body.xRot = Mth.lerp(sleepProgress, 0, -0.03909537541112055F);
				this.RightArm.xRot = Mth.lerp(sleepProgress, 0, -1.5208283259076444F);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0, 0.3909537457888271F);
				this.RightArm.zRot = Mth.lerp(sleepProgress, 0, -0.31293754020890546F);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.13665927909957545F, 0.03263765709551775F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, 0, -0.11728612207217244F);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, 0, -1.5317009888344788F);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0, 0.33021629580890766F);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0, 0.017453292519943295F);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, 0, -1.3990190684075072F);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, 0, -0.31293754020890546F);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0, 0.07644542323472245F);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, 0, -1.5247196451948906F);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, 0, -0.2738421523142173F);
				this.Neck.xRot = Mth.lerp(sleepProgress, -0.18203784630933073F, 0.3862413488189591F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0, 0.11728612207217244F);
				this.Neck.zRot = Mth.lerp(sleepProgress, 0, -0.1563815016444822F);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.2275909337942703F, -0.18901915665940536F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, 0, -0.27366763203903305F);
			} else sleepPose();
		} else {
			if (sleepProgress != 0 && entity.getEntityData().get(DinosaurEntity.SLEEP_TICK) > 0) {
				this.root.y = Mth.lerp(sleepProgress, 19.5F, 14.5F);
				this.Head.xRot = Mth.lerp(sleepProgress, 0.02827433396553192F, 0);
				this.Head.yRot = Mth.lerp(sleepProgress, 0.11728612207217244F, 0);
				this.Head.zRot = Mth.lerp(sleepProgress, -0.11746065899211351F, 0);
				this.LeftThigh.yRot = Mth.lerp(sleepProgress, -0.15707963267948966F, 0);
				this.RightThigh.xRot = Mth.lerp(sleepProgress, 0.017453292519943295F, 0);
				this.RightThigh.yRot = Mth.lerp(sleepProgress, 0.15707963267948966F, 0);
				this.Body.xRot = Mth.lerp(sleepProgress, -0.03909537541112055F, 0);
				this.RightArm.xRot = Mth.lerp(sleepProgress, -1.5208283259076444F, 0);
				this.RightArm.yRot = Mth.lerp(sleepProgress, 0.3909537457888271F, 0);
				this.RightArm.zRot = Mth.lerp(sleepProgress, -0.31293754020890546F, 0);
				this.Tail2.xRot = Mth.lerp(sleepProgress, 0.03263765709551775F, 0.13665927909957545F);
				this.Tail2.yRot = Mth.lerp(sleepProgress, -0.11728612207217244F, 0);
				this.RightLeg.xRot = Mth.lerp(sleepProgress, -1.5317009888344788F, 0);
				this.RightLeg.yRot = Mth.lerp(sleepProgress, 0.33021629580890766F, 0);
				this.RightLeg.zRot = Mth.lerp(sleepProgress, 0.017453292519943295F, 0);
				this.LeftArm.xRot = Mth.lerp(sleepProgress, -1.3990190684075072F, 0);
				this.LeftArm.yRot = Mth.lerp(sleepProgress, -0.31293754020890546F, 0);
				this.LeftArm.zRot = Mth.lerp(sleepProgress, 0.07644542323472245F, 0);
				this.LeftLeg.xRot = Mth.lerp(sleepProgress, -1.5247196451948906F, 0);
				this.LeftLeg.yRot = Mth.lerp(sleepProgress, -0.2738421523142173F, 0);
				this.Neck.xRot = Mth.lerp(sleepProgress, 0.3862413488189591F, -0.18203784630933073F);
				this.Neck.yRot = Mth.lerp(sleepProgress, 0.11728612207217244F, 0);
				this.Neck.zRot = Mth.lerp(sleepProgress, -0.1563815016444822F, 0);
				this.Tail1.xRot = Mth.lerp(sleepProgress, -0.18901915665940536F, -0.2275909337942703F);
				this.Tail1.yRot = Mth.lerp(sleepProgress, -0.27366763203903305F, 0);
			} else {
				this.LeftArm.xRot = -Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.RightArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.RightThigh.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.RightLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
				this.LeftThigh.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.LeftLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
				this.Tail1.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount) + attackProgress * leftOrRight * (float)Math.toRadians(-15);
				this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount) + attackProgress * leftOrRight * (float)Math.toRadians(-25);
				this.Tail1.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
				this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
				this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F);
//				this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.05F);
				this.Body.yRot = attackProgress * leftOrRight * (float)Math.toRadians(-200);
				this.Tail1.zRot = attackProgress * leftOrRight * (float)Math.toRadians(15);
				this.Body.z = 19.0F + attackProgress * -22;
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
	}

	public void resetModel() {
		this.root.y = 14.5F;
		this.Head.xRot = 0;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.LeftThigh.yRot = 0;
		this.RightThigh.xRot = 0;
		this.RightThigh.yRot = 0;
		this.Body.xRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.yRot = 0;
		this.RightArm.zRot = 0;
		this.Tail2.xRot = 0.13665927909957545F;
		this.Tail2.yRot = 0;
		this.RightLeg.xRot = 0;
		this.RightLeg.yRot = 0;
		this.RightLeg.zRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.LeftLeg.xRot = 0;
		this.LeftLeg.yRot = 0;
		this.Neck.xRot = -0.18203784630933073F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Tail1.xRot = -0.2275909337942703F;
		this.Tail1.yRot = 0;
		this.Body.y = 1;
		this.Head.y = 0;
		this.RightArm.x = -3F;
		this.LeftArm.x = 3F;
		this.Body.xRot = 0F;
		this.LeftThigh.xRot = -0F;
		this.RightThigh.xRot = -0F;
		this.RightArm.xRot = -0F;
		this.LeftArm.xRot = -0F;
		this.RightArm.zRot = 0F;
		this.LeftArm.zRot = -0F;
	}

	public void sleepPose() {
		this.root.y = 19.5F;
		this.Head.xRot = 0.02827433396553192F;
		this.Head.yRot = 0.11728612207217244F;
		this.Head.zRot = -0.11746065899211351F;
		this.LeftThigh.yRot = -0.15707963267948966F;
		this.RightThigh.xRot = 0.017453292519943295F;
		this.RightThigh.yRot = 0.15707963267948966F;
		this.Body.xRot = -0.03909537541112055F;
		this.RightArm.xRot = -1.5208283259076444F;
		this.RightArm.yRot = 0.3909537457888271F;
		this.RightArm.zRot = -0.31293754020890546F;
		this.Tail2.xRot = 0.03263765709551775F;
		this.Tail2.yRot = -0.11728612207217244F;
		this.RightLeg.xRot = -1.5317009888344788F;
		this.RightLeg.yRot = 0.33021629580890766F;
		this.RightLeg.zRot = 0.017453292519943295F;
		this.LeftArm.xRot = -1.3990190684075072F;
		this.LeftArm.yRot = -0.31293754020890546F;
		this.LeftArm.zRot = 0.07644542323472245F;
		this.LeftLeg.xRot = -1.5247196451948906F;
		this.LeftLeg.yRot = -0.2738421523142173F;
		this.Neck.xRot = 0.3862413488189591F;
		this.Neck.yRot = 0.11728612207217244F;
		this.Neck.zRot = -0.1563815016444822F;
		this.Tail1.xRot = -0.18901915665940536F;
		this.Tail1.yRot = -0.27366763203903305F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
