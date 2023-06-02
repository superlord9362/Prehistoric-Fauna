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
import superlord.prehistoricfauna.common.entity.jurassic.morrison.Allosaurus;

public class AllosaurusModel extends EntityModel<Allosaurus> {
	private final ModelPart LeftLeg1;
	private final ModelPart LeftLeg2;
	private final ModelPart LeftFoot;
	private final ModelPart RightLeg1;
	private final ModelPart RightLeg2;
	private final ModelPart RightFoot;
	private final ModelPart Body1;
	private final ModelPart Body2;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Neck;
	private final ModelPart Head1;
	private final ModelPart Jaw1;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;

	public AllosaurusModel(ModelPart root) {
		this.LeftLeg1 = root.getChild("LeftLeg1");
		this.LeftLeg2 = LeftLeg1.getChild("LeftLeg2");
		this.LeftFoot = LeftLeg2.getChild("LeftFoot");
		this.RightLeg1 = root.getChild("RightLeg1");
		this.RightLeg2 = RightLeg1.getChild("RightLeg2");
		this.RightFoot = RightLeg2.getChild("RightFoot");
		this.Body1 = root.getChild("Body1");
		this.Body2 = Body1.getChild("Body2");
		this.Neck = Body2.getChild("Neck");
		this.Head1 = Neck.getChild("Head1");
		this.Jaw1 = Head1.getChild("Jaw1");
		this.Tail1 = Body1.getChild("Tail1");
		this.Tail2 = Tail1.getChild("Tail2");
		this.LeftArm = Body2.getChild("LeftArm");
		this.RightArm = Body2.getChild("RightArm");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeftLeg1 = partdefinition.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, -3.0F, -6.0F, 8.0F, 22.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -13.5F, 3.0F, -0.1F, 0.0F, 0.0F));

		PartDefinition LeftLeg2 = LeftLeg1.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(44, 0).addBox(-3.5F, 0.0F, -3.0F, 7.0F, 20.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 15.0F, 6.0F, 0.1F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLeg2.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(72, 0).addBox(-4.0F, 0.0F, -11.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 2.0F));

		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(96, 0).addBox(0.0F, -3.0F, -6.0F, 8.0F, 22.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -13.5F, 3.0F, -0.1F, 0.0F, 0.0F));

		PartDefinition RightLeg2 = RightLeg1.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(140, 0).addBox(-3.5F, 1.0F, -3.0F, 7.0F, 20.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 14.0F, 6.0F, 0.1F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLeg2.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(168, 0).addBox(-4.0F, 1.0F, -11.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 2.0F));

		PartDefinition Body1 = partdefinition.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(144, 14).addBox(-7.5F, -5.0F, -11.0F, 15.0F, 23.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 3.0F));

		PartDefinition Body2 = Body1.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(0, 59).addBox(-8.5F, -5.0F, -18.0F, 17.0F, 20.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -11.0F));

		PartDefinition Neck = Body2.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(210, 49).addBox(-3.5F, -21.0F, -12.0F, 7.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, -13.0F, 0.35F, 0.0F, 0.0F));

		PartDefinition Head1 = Neck.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(198, 22).addBox(-5.0F, -7.0F, -7.0F, 10.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, -9.0F, -0.2F, 0.0F, 0.0F));

		PartDefinition Jaw1 = Head1.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(37, 29).addBox(-5.0F, 0.0F, -7.0F, 10.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head1_1 = Jaw1.addOrReplaceChild("Head1_1", CubeListBuilder.create().texOffs(222, 36).addBox(-4.0F, -5.0F, -5.0F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Jaw2 = Jaw1.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(0, 36).addBox(-3.5F, -1.0F, -12.0F, 7.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -7.0F));

		PartDefinition LowerTeeth = Jaw2.addOrReplaceChild("LowerTeeth", CubeListBuilder.create().texOffs(52, 59).addBox(-2.0F, -1.5F, 0.0F, 4.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -11.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition LowerTeeth_1 = LowerTeeth.addOrReplaceChild("LowerTeeth_1", CubeListBuilder.create().texOffs(64, 69).addBox(-1.5F, -1.5F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Snout = Head1.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(84, 59).addBox(-3.5F, -2.0F, -9.0F, 7.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -7.0F));

		PartDefinition Snout2 = Snout.addOrReplaceChild("Snout2", CubeListBuilder.create().texOffs(226, 0).addBox(-3.5F, -2.0F, -3.0F, 7.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -9.0F));

		PartDefinition CrestLeft = Snout.addOrReplaceChild("CrestLeft", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-0.5F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -2.0F, 0.0F));

		PartDefinition CrestRight = Snout.addOrReplaceChild("CrestRight", CubeListBuilder.create().texOffs(30, 0).addBox(0.0F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -2.0F, 0.0F));

		PartDefinition UpperTeeth = Snout.addOrReplaceChild("UpperTeeth", CubeListBuilder.create().texOffs(136, 61).addBox(-2.5F, -1.5F, 0.0F, 5.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -11.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition RightArm = Body2.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(206, 0).addBox(0.0F, -2.0F, -3.0F, 4.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 11.5F, -12.0F, 0.15F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body2.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(181, 61).mirror().addBox(-3.0F, -2.0F, -3.0F, 4.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, 11.5F, -12.0F, 0.15F, 0.0F, 0.0F));

		PartDefinition Tail1 = Body1.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(40, 14).addBox(-5.0F, -4.0F, -3.0F, 10.0F, 13.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 13.0F, -0.05F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(79, 36).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 8.0F, 45.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 29.0F, 0.05F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 250, 125);
	}

	@Override
	public void setupAnim(Allosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 1.0f;
		float walkDegree = 0.5f;
		float idleSpeed = 1.0f;
		float idleDegree = 1.0f;
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress = entity.getMeleeProgress(partialTick);
		float leftOrRight = entity.getMeleeDirection() ? 1.0F : -1.0F;
		resetModel();
		if (entity.isAsleep()) {
			this.Body2.xRot = 0.0781907508222411F;
			this.RightLeg2.xRot = -0.8991936386169619F;
			this.RightLeg2.yRot = -0.5082398928281348F;
			this.RightLeg2.zRot = 0.46914448828868976F;
			this.LeftLeg2.xRot = -0.8600982340775168F;
			this.LeftLeg2.y = 13.0F;
			this.Tail1.xRot = -0.4300491170387584F;
			this.Tail1.yRot = 0.19547687289441354F;
			this.Head1.y = -15;
			this.Head1.z = -7;
			this.Head1.xRot = -1.7201964681550337F;
			this.Head1.yRot = 0.03909537541112055F;
			this.Head1.zRot = -0.0781907508222411F;
			this.LeftLeg1.x = 1;
			this.LeftLeg1.y = 10;
			this.LeftLeg1.xRot = -0.7428121536172364F;
			this.LeftLeg1.yRot = 0.23457224414434488F;
			this.LeftFoot.z = -3F;
			this.LeftFoot.xRot = 1.602910321115726F;
			this.Neck.y = -4.0F;
			this.Neck.xRot = 1.681101130194616F;
			this.Neck.yRot = 0.03909537541112055F;
			this.Neck.zRot = 0.27366763203903305F;
			this.Tail2.xRot = -0.19547687289441354F;
			this.Tail2.yRot = 0.3909537457888271F;
			this.Body1.y = 6.0F;
			this.Body1.xRot = 0.0781907508222411F;
			this.Body1.zRot = -0.46914448828868976F;
			this.RightFoot.z = -3.0F;
			this.RightFoot.xRot = 1.4465288361160007F;
			this.RightFoot.yRot = 0.27366763203903305F;
			this.LeftArm.xRot = -1.4856243072344728F;
			this.LeftArm.yRot = 0.3909537457888271F;
			this.LeftArm.zRot = 0.3513347637790725F;
			this.RightArm.xRot = -0.35185837453889574F;
			this.RightArm.zRot = -0.4300491170387584F;
			this.RightLeg1.x = 3;
			this.RightLeg1.y = 9;
			this.RightLeg1.xRot = -0.547160727158125F;
			this.RightLeg1.yRot = -0.35185837453889574F;
			this.RightLeg1.zRot = -0.3909537457888271F;
		} else {
			this.Neck.xRot = (Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount + 0.35F) + (headPitch * ((float) Math.PI / 180F)) + attackProgress * (float)Math.toRadians(30F);
			this.Body2.xRot = Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.01F * limbSwingAmount;
			this.Body1.xRot = Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3)) + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount;
			this.Tail1.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.1F * limbSwingAmount - 0.05F;
			this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5)) + Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.15F * limbSwingAmount + 0.05F;
			this.Tail1.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 0.6F * limbSwingAmount;
			this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5) + Mth.cos(limbSwing * walkSpeed * 0.15F) * walkDegree * 1.0F * limbSwingAmount;
			this.Head1.xRot = Mth.cos(-1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.25F * limbSwingAmount - 0.2F + attackProgress * (float)Math.toRadians(-40F);
			this.Jaw1.xRot = attackProgress * (float) Math.toRadians(25F);
			this.Neck.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
			this.Head1.zRot = attackProgress * leftOrRight * (float) Math.toRadians(15F);
			this.RightArm.xRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
			this.LeftArm.xRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3)) + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.2F * limbSwingAmount + 0.15F;
			this.RightLeg1.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.6F * limbSwingAmount - 0.05F;
			this.RightLeg2.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.4F * limbSwingAmount + 0.05F;
			this.RightFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * 0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * 0.3F * limbSwingAmount;
			this.LeftLeg1.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.6F * limbSwingAmount - 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.6F * limbSwingAmount - 0.05F;
			this.LeftLeg2.xRot = Mth.cos(1.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.4F * limbSwingAmount + 0.05F + Mth.cos(1.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.4F * limbSwingAmount + 0.05F;
			this.LeftFoot.xRot = Mth.cos(2.0F + limbSwing * idleSpeed * 0.3F) * idleDegree * -0.3F * limbSwingAmount + Mth.cos(2.0F + limbSwing * walkSpeed * 0.3F) * walkDegree * -0.3F * limbSwingAmount;
			this.Neck.yRot = netHeadYaw * ((float) Math.PI / 180F);
			if (entity.isInWater()) {
				this.RightLeg1.y = 20;
				this.LeftLeg1.y = 20;
				this.Body1.y = 17;
				this.Body1.xRot = -0.125F;
				this.Tail1.xRot = 0.0625F;
				this.Tail2.xRot = 0.0625F;
				this.Neck.xRot = 0.25F;
				this.RightLeg1.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg1.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftArm.xRot = 0.125F;
				this.RightArm.xRot = 0.125F;
				this.RightLeg2.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.LeftLeg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.RightFoot.xRot = 0.5F - (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.LeftFoot.xRot = 0.5F + (0.3F * Mth.sin(0.2F * ageInTicks / 1.5F));
				this.Tail1.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
			}
		}
	}

	public void resetModel() {
		this.Body2.xRot = 0;
		this.RightLeg2.xRot = 0;
		this.RightLeg2.yRot = 0;
		this.RightLeg2.zRot = 0;
		this.LeftLeg2.xRot = 0;
		this.LeftLeg2.y = 14.0F;
		this.Tail1.xRot = 0;
		this.Tail1.yRot = 0;
		this.Head1.y = -14;
		this.Head1.z = -9;
		this.Head1.xRot = 0;
		this.Head1.yRot = 0;
		this.Head1.zRot = 0;
		this.LeftLeg1.x = -3.0F;
		this.LeftLeg1.y = -13.5F;
		this.LeftLeg1.xRot = 0;
		this.LeftLeg1.yRot = 0;
		this.LeftFoot.z = 2.0F;
		this.LeftFoot.xRot = 0;
		this.Neck.y = 9.0F;
		this.Neck.z = -13.0F;
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Body1.y = -16.0F;
		this.Body1.xRot = 0;
		this.Body1.zRot = 0;
		this.RightFoot.z = 2.0F;
		this.RightFoot.xRot = 0;
		this.RightFoot.yRot = 0;
		this.LeftArm.xRot = 0;
		this.LeftArm.yRot = 0;
		this.LeftArm.zRot = 0;
		this.RightArm.xRot = 0;
		this.RightArm.zRot = 0;
		this.RightLeg1.x = 3.0F;
		this.RightLeg1.y = -13.5F;
		this.RightLeg1.xRot = 0;
		this.RightLeg1.yRot = 0;
		this.RightLeg1.zRot = 0;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LeftLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}