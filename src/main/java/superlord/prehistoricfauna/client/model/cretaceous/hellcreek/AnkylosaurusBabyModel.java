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

public class AnkylosaurusBabyModel extends EntityModel<Ankylosaurus> {
	private final ModelPart Torso;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail;
	private final ModelPart Tail2;
	private final ModelPart Club;
	private final ModelPart RArm;
	private final ModelPart LArm;
	private final ModelPart RLeg;
	private final ModelPart RFoot;
	private final ModelPart LLeg;
	private final ModelPart LFoot;

	public AnkylosaurusBabyModel(ModelPart root) {
		this.Torso = root.getChild("Torso");
		this.Neck = Torso.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.Tail = Torso.getChild("Tail");
		this.Tail2 = Tail.getChild("Tail2");
		this.Club = Tail2.getChild("Club");
		this.RArm = root.getChild("RArm");
		this.LArm = root.getChild("LArm");
		this.RLeg = root.getChild("RLeg");
		this.RFoot = RLeg.getChild("RFoot");
		this.LLeg = root.getChild("LLeg");
		this.LFoot = LLeg.getChild("LFoot");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, 0.0F, -8.0F, 11.0F, 8.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, -1.0F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 33).addBox(-2.5F, -1.0F, -5.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -8.0F, 0.0698F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(39, 0).addBox(-2.5F, -1.0F, -5.0F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.01F, 0.0F, 0.0F)), PartPose.offset(0.0F, -1.0F, -3.0F));

		PartDefinition RHorn = Head.addOrReplaceChild("RHorn", CubeListBuilder.create().texOffs(30, 25).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 0.0F, -1.0F));

		PartDefinition LHorn = Head.addOrReplaceChild("LHorn", CubeListBuilder.create().texOffs(30, 25).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, -1.0F));

		PartDefinition LHornBottom = Head.addOrReplaceChild("LHornBottom", CubeListBuilder.create().texOffs(47, 11).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 1.5F, -1.0F));

		PartDefinition RHornBottom = Head.addOrReplaceChild("RHornBottom", CubeListBuilder.create().texOffs(47, 11).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 1.5F, -1.0F));

		PartDefinition Beak = Head.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(39, 11).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition Tail = Torso.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(38, 25).addBox(-2.5F, -1.5F, -1.0F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 9.0F, -0.0349F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(16, 25).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 6.0F));

		PartDefinition Club = Tail2.addOrReplaceChild("Club", CubeListBuilder.create().texOffs(0, 25).addBox(-2.5F, -1.5F, 0.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 7.0F));

		PartDefinition RArm = partdefinition.addOrReplaceChild("RArm", CubeListBuilder.create().texOffs(22, 36).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 18.0F, -6.5F));

		PartDefinition LArm = partdefinition.addOrReplaceChild("LArm", CubeListBuilder.create().texOffs(22, 36).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 18.0F, -6.5F));

		PartDefinition RLeg = partdefinition.addOrReplaceChild("RLeg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 14.0F, 3.5F));

		PartDefinition RFoot = RLeg.addOrReplaceChild("RFoot", CubeListBuilder.create().texOffs(37, 37).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 3.5F));

		PartDefinition LLeg = partdefinition.addOrReplaceChild("LLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 14.0F, 4.0F));

		PartDefinition LFoot = LLeg.addOrReplaceChild("LFoot", CubeListBuilder.create().texOffs(37, 37).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 3.0F));

		return LayerDefinition.create(meshdefinition, 63, 45);
	}

	@Override
	public void setupAnim(Ankylosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float speed = 0.9f;
		float degree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		this.Head.xRot = 0.3186971254089062F;
		this.Head.yRot = 0;
		this.Head.zRot = 0;
		this.Club.xRot = 0;
		this.Club.yRot = 0;
		this.LLeg.yRot = 0;
		this.RLeg.xRot = 0;
		this.RLeg.yRot = 0;
		this.Torso.xRot = 0;
		this.RArm.xRot = 0;
		this.RArm.yRot = 0;
		this.RArm.zRot = 0;
		this.Tail2.xRot = 0.13665927909957545F;
		this.Tail2.yRot = 0;
		this.RFoot.xRot = 0;
		this.RFoot.yRot = 0;
		this.RFoot.zRot = 0;
		this.LArm.xRot = 0;
		this.LArm.yRot = 0;
		this.LArm.zRot = 0;
		this.LFoot.xRot = 0;
		this.LFoot.yRot = 0;
		this.Neck.xRot = -0.18203784630933073F;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Tail.xRot = -0.2275909337942703F;
		this.Tail.yRot = 0;
		this.Torso.y = 12;
		this.Head.y = -1;
		this.RArm.y = 18.0F;
		this.LArm.y = 18.0F;
		this.LLeg.y = 14.0F;
		this.RLeg.y = 14.0F;
		if (entity.isAsleep()) {
			this.Torso.y = 15;
			this.RArm.y = 20.0F;
			this.LArm.y = 20.0F;
			this.LLeg.y = 17.0F;
			this.RLeg.y = 17.0F;
			this.Head.xRot = 0.02827433396553192F;
			this.Head.yRot = 0.11728612207217244F;
			this.Head.zRot = -0.11746065899211351F;
			this.LLeg.yRot = -0.15707963267948966F;
			this.RLeg.xRot = 0.017453292519943295F;
			this.RLeg.yRot = 0.15707963267948966F;
			this.Torso.xRot = -0.03909537541112055F;
			this.RArm.xRot = -0.8208283259076444F;
			this.RArm.yRot = -0.3909537457888271F;
			this.RArm.zRot = -0.31293754020890546F;
			this.Tail2.xRot = 0.03263765709551775F;
			this.Tail2.yRot = -0.11728612207217244F;
			this.RFoot.xRot = -1.5317009888344788F;
			this.RFoot.yRot = 0.33021629580890766F;
			this.RFoot.zRot = 0.017453292519943295F;
			this.LArm.xRot = -0.8990190684075072F;
			this.LArm.yRot = 0.31293754020890546F;
			this.LArm.zRot = 0.07644542323472245F;
			this.LFoot.xRot = -1.5247196451948906F;
			this.LFoot.yRot = -0.2738421523142173F;
			this.Neck.xRot = 0.3862413488189591F;
			this.Neck.yRot = 0.11728612207217244F;
			this.Neck.zRot = -0.1563815016444822F;
			this.Tail.xRot = -0.18901915665940536F;
			this.Tail.yRot = -0.27366763203903305F;
			this.Head.y = -1.5F;
			this.RLeg.xRot = 0;
			this.LLeg.xRot = 0;
		} else {
			this.Torso.xRot = 0F;
			this.LLeg.xRot = -0F;
			this.RLeg.xRot = -0F;
			this.RArm.xRot = -0F;
			this.LArm.xRot = -0F;
			this.RArm.zRot = 0F;
			this.LArm.zRot = -0F;
			this.LArm.xRot = -Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.RArm.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.RLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.RFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * 0.8F * limbSwingAmount;
			this.LLeg.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
			this.LFoot.xRot = Mth.cos(limbSwing * speed * 0.3F) * degree * -0.8F * limbSwingAmount;
			this.Tail.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount) + attackProgress * leftOrRight * (float)Math.toRadians(-15);
			this.Tail2.yRot = (-0.12F * Mth.sin(0.2F * ageInTicks / 5)) + (Mth.cos(limbSwing * speed * 0.15F) * degree * 0.35F * limbSwingAmount) + attackProgress * leftOrRight * (float)Math.toRadians(-25);
			this.Tail.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount - 0.15F);
			this.Tail2.xRot = (-Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.15F);
			this.Neck.xRot = (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(limbSwing * speed * 0.3F) * degree * 0.1F * limbSwingAmount + 0.15F);
			this.Head.xRot = (-Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + (Mth.cos(-1.0F + limbSwing * speed * 0.3F) * degree * 0.15F * limbSwingAmount + 0.05F);
			this.Torso.yRot = attackProgress * leftOrRight * (float)Math.toRadians(-200);
			this.Tail.zRot = attackProgress * leftOrRight * (float)Math.toRadians(15);
			this.Torso.z = -1.0F + attackProgress * -22;
			if (entity.isEating() || entity.isTuberDigging()) {
				this.Neck.xRot = Math.abs(Mth.sin(0.05F * ageInTicks) * 0.5F) + 0.25F;
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

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}