package superlord.prehistoricfauna.client.model.jurassic.kayenta;

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
import superlord.prehistoricfauna.common.entity.jurassic.kayenta.Megapnosaurus;

public class MegapnosaurusModel extends EntityModel<Megapnosaurus> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Tail;
	private final ModelPart Tail2;
	private final ModelPart ArmRight;
	private final ModelPart ArmLeft;
	private final ModelPart Leg_1;
	private final ModelPart Leg2_1;
	private final ModelPart Leg;
	private final ModelPart Leg2;

	public MegapnosaurusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = Body.getChild("Neck");
		this.Head = Neck.getChild("Head");
		this.Tail = Body.getChild("Tail");
		this.Tail2 = Tail.getChild("Tail2");
		this.ArmRight = Body.getChild("ArmRight");
		this.ArmLeft = Body.getChild("ArmLeft");
		this.Leg_1 = root.getChild("Leg_1");
		this.Leg2_1 = Leg_1.getChild("Leg2_1");
		this.Leg = root.getChild("Leg");
		this.Leg2 = Leg.getChild("Leg2");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.0F, -10.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 3.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 17).addBox(-0.5F, -5.0F, -2.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -9.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 25).addBox(-0.5F, -1.0F, -4.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -2.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 32).addBox(-0.5F, -1.0F, -2.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -0.9F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(21, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 2.0F));

		PartDefinition Tail2 = Tail.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(36, 0).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 6.0F));

		PartDefinition ArmLeft = Body.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(42, 17).mirror().addBox(0.0F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.7F, 1.0F, -7.5F));

		PartDefinition ArmRight = Body.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(37, 17).mirror().addBox(-1.0F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.7F, 1.0F, -7.5F));

		PartDefinition Leg_1 = partdefinition.addOrReplaceChild("Leg_1", CubeListBuilder.create().texOffs(26, 17).mirror().addBox(0.0F, -2.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 15.5F, 2.5F));

		PartDefinition Leg2_1 = Leg_1.addOrReplaceChild("Leg2_1", CubeListBuilder.create().texOffs(27, 27).mirror().addBox(-2.0F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, 2.5F, 1.49F));

		PartDefinition Leg = partdefinition.addOrReplaceChild("Leg", CubeListBuilder.create().texOffs(14, 17).mirror().addBox(-2.0F, -2.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 15.5F, 2.5F));

		PartDefinition Leg2 = Leg.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(14, 27).mirror().addBox(-1.0F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, 2.5F, 1.49F));

		return LayerDefinition.create(meshdefinition, 80, 50);
	}

	@Override
	public void setupAnim(Megapnosaurus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float partialTick = ageInTicks - entity.tickCount;
		float attackProgress =  entity.getMeleeProgress(partialTick);
		resetModel();
		if (entity.isAsleep()) {
			this.Tail.xRot = -0.23457224414434488F;
			this.Tail.yRot = 0.3909537457888271F;
			this.Tail.z = 1.0F;
			this.Leg2_1.xRot = 1.407433498155583F;
			this.Leg2_1.x = 1.2F;
			this.Leg2_1.y = 4.5F;
			this.Leg2_1.z = 1.5F;
			this.Leg.xRot = -1.407433498155583F;
			this.Leg.yRot = 0.3909537457888271F;
			this.Leg.y = 22.5F;
			this.Leg.z = 2.2F;
			this.ArmRight.zRot = 1.1339404363260046F;
			this.ArmRight.y = 0.0F;
			this.ArmRight.z = -7.0F;
			this.Tail2.xRot = 0.11728612207217244F;
			this.Tail2.yRot = 0.6646214111173737F;
			this.Tail2.x = -0.3F;
			this.Tail2.y = 0.0F;
			this.Leg2.xRot = 1.407433498155583F;
			this.Leg2.x = -1.2F;
			this.Leg2.y = 4.5F;
			this.Leg2.z = 1.5F;
			this.ArmLeft.zRot = -1.13376586611655F;
			this.ArmLeft.y = 0.0F;
			this.ArmLeft.z = -7.0F;
			this.Leg_1.xRot = -1.407433498155583F;
			this.Leg_1.yRot = -0.3909537457888271F;
			this.Leg_1.y = 22.5F;
			this.Leg_1.z = 2.2F;
			this.Body.y = 22.0F;
			this.Neck.xRot = 0;
			this.Neck.yRot = -1.2901473511162753F;
			this.Neck.zRot = 0.3127630032889644F;
		} else {
			this.Leg_1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.Leg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
			this.Tail.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail2.yRot = -0.12F * Mth.sin(0.2F * ageInTicks / 5);
			this.Tail.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Tail2.xRot = -Math.abs(-0.05F * Mth.sin(0.1F * ageInTicks / 5));
			this.Neck.xRot = (headPitch * ((float)Math.PI / 180F)) + (Math.abs(-0.025F * Mth.sin(0.1F * ageInTicks / 3))) + attackProgress * (float) Math.toRadians(40F);
			this.ArmRight.zRot = Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.ArmLeft.zRot = -Math.abs(-0.05F * Mth.sin(0.15F * ageInTicks / 3));
			this.Neck.yRot = netHeadYaw * ((float)Math.PI / 180F);
			this.Head.xRot = attackProgress * (float) Math.toRadians(-15F);
			if (entity.isInWater()) {
				this.Leg_1.y = 22;
				this.Leg.y = 22;
				this.Body.y = 20;
				this.Body.xRot = -0.25F;
				this.Tail.xRot = 0.125F;
				this.Tail2.xRot = 0.125F;
				this.Neck.xRot = 0.25F;
				this.Leg_1.xRot = -0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Leg.xRot = 0.25F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.ArmLeft.xRot = 0.25F;
				this.ArmRight.xRot = 0.25F;
				this.Leg2_1.xRot = -0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Leg2.xRot = 0.3F * Mth.sin(0.2F * ageInTicks / 1.5F);
				this.Tail.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));
				this.Tail2.yRot = (Mth.cos(limbSwing * 2.6662F) * 1.4F * limbSwingAmount) + (0.0625F * Mth.sin(0.15F * ageInTicks / 1.5F));

			}
		}
	}

	public void resetModel() {
		this.Neck.xRot = 0;
		this.Neck.yRot = 0;
		this.Neck.zRot = 0;
		this.ArmRight.xRot = 0;
		this.ArmRight.yRot = 0;
		this.ArmRight.zRot = 0;
		this.ArmLeft.xRot = 0;
		this.ArmLeft.yRot = 0;
		this.ArmLeft.zRot = 0;
		this.Leg_1.xRot = 0;
		this.Leg_1.yRot = 0;
		this.Body.xRot = 0;
		this.Tail.xRot = 0;
		this.Tail.yRot = 0;
		this.Leg2_1.xRot = 0;
		this.Leg.xRot = 0;
		this.Leg.yRot = 0;
		this.ArmRight.zRot = 0;
		this.Tail2.xRot = 0;
		this.Tail2.yRot = 0;
		this.Leg2.xRot = 0;
		this.ArmLeft.zRot = 0;
		this.Body.y = 15.0F;
		this.Leg2.x = -1.5F;
		this.Leg2.y = 2.5F;
		this.Leg2.z = 1.49F;
		this.Leg_1.y = 15.5F;
		this.Leg_1.z = 2.5F;
		this.Leg2_1.x = 1.5F;
		this.Leg2_1.y = 2.5F;
		this.Leg2_1.z = 1.49F;
		this.Tail.z = 2.0F;
		this.Tail2.x = 0.0F;
		this.Tail2.y = -0.5F;
		this.ArmRight.y = 1.0F;
		this.ArmRight.z = -7.5F;
		this.Leg.y = 15.5F;
		this.Leg.z = 2.5F;
		this.ArmLeft.y = 1.0F;
		this.ArmLeft.z = -7.5F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
