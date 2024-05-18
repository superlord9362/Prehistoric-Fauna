package superlord.prehistoricfauna.client.model.cretaceous.yixian;

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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Cretaraneus;

public class CretaraneusModel extends EntityModel<Cretaraneus> {
	private final ModelPart Body;
	private final ModelPart LeftLeg4;
	private final ModelPart LeftLeg3;
	private final ModelPart LeftLeg2;
	private final ModelPart LeftLeg1;
	private final ModelPart RightLeg4;
	private final ModelPart RightLeg3;
	private final ModelPart RightLeg2;
	private final ModelPart RightLeg1;
	private final ModelPart LeftPedipalp;
	private final ModelPart RightPedipalp;

	public CretaraneusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.LeftLeg4 = Body.getChild("LeftLeg4");
		this.LeftLeg3 = Body.getChild("LeftLeg3");
		this.LeftLeg2 = Body.getChild("LeftLeg2");
		this.LeftLeg1 = Body.getChild("LeftLeg1");
		this.RightLeg4 = Body.getChild("RightLeg4");
		this.RightLeg3 = Body.getChild("RightLeg3");
		this.RightLeg2 = Body.getChild("RightLeg2");
		this.RightLeg1 = Body.getChild("RightLeg1");
		this.LeftPedipalp = Body.getChild("LeftPedipalp");
		this.RightPedipalp = Body.getChild("RightPedipalp");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 12).addBox(-1.5F, -3.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(11, 9).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition LeftLeg4 = Body.addOrReplaceChild("LeftLeg4", CubeListBuilder.create().texOffs(3, 20).addBox(0.0F, -4.0F, 0.0F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.0F, -1.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition LeftLeg3 = Body.addOrReplaceChild("LeftLeg3", CubeListBuilder.create().texOffs(3, 20).addBox(0.0F, -4.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.0F, -1.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition LeftLeg2 = Body.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(3, 26).addBox(0.0F, -4.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.0F, -1.5F, 0.0F, 0.0873F, 0.0F));

		PartDefinition LeftLeg1 = Body.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(3, 26).addBox(0.0F, -4.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.0F, -1.5F, 0.0F, 0.6981F, 0.0F));

		PartDefinition RightLeg1 = Body.addOrReplaceChild("RightLeg1", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -2.0F, -1.5F, 0.0F, -0.6981F, 0.0F));

		PartDefinition cube_r1 = RightLeg1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(3, 26).mirror().addBox(-11.5F, -6.0F, 0.5F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 2.0F, -0.5F, 0.0F, -0.0873F, 0.0F));

		PartDefinition RightLeg2 = Body.addOrReplaceChild("RightLeg2", CubeListBuilder.create(), PartPose.offset(-1.5F, -2.0F, -1.5F));

		PartDefinition cube_r2 = RightLeg2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(3, 26).mirror().addBox(-11.5F, -6.0F, 0.5F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 2.0F, -0.5F, 0.0F, -0.0873F, 0.0F));

		PartDefinition RightLeg3 = Body.addOrReplaceChild("RightLeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -2.0F, -1.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition cube_r3 = RightLeg3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(3, 20).mirror().addBox(-11.5F, -6.0F, 1.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 2.0F, -1.0F, 0.0F, -0.0873F, 0.0F));

		PartDefinition RightLeg4 = Body.addOrReplaceChild("RightLeg4", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -2.0F, -1.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition cube_r4 = RightLeg4.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(3, 20).mirror().addBox(-9.5F, -6.0F, 1.0F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, 2.0F, -1.0F, 0.0F, -0.0873F, 0.0F));

		PartDefinition LeftPedipalp = Body.addOrReplaceChild("LeftPedipalp", CubeListBuilder.create().texOffs(6, 10).addBox(0.0F, 0.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -3.0F, 0.6527F, -0.0531F, 0.0693F));

		PartDefinition RightPedipalp = Body.addOrReplaceChild("RightPedipalp", CubeListBuilder.create().texOffs(6, 10).mirror().addBox(0.0F, 0.0F, -2.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -2.0F, -3.0F, 0.6527F, 0.0531F, -0.0693F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Cretaraneus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 3.0f;
		float walkDegree = 2.0f;
		this.LeftLeg3.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount)) + 0.1767F;
		this.RightLeg3.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount)) - 0.1767F;
		this.LeftLeg2.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 5) * walkDegree * 0.5F * limbSwingAmount)) + 0.1767F;
		this.LeftLeg4.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 20) * walkDegree * 0.5F * limbSwingAmount)) + 0.1767F;
		this.RightLeg2.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 15) * walkDegree * 0.5F * limbSwingAmount)) - 0.1767F;
		this.RightLeg4.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 25) * walkDegree * 0.5F * limbSwingAmount)) - 0.1767F;
		this.LeftLeg1.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount)) + 0.1767F;
		this.RightLeg1.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount)) - 0.1767F;
		this.LeftLeg3.xRot = -(Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLeg3.xRot = Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount;
		this.LeftLeg2.xRot = -(Mth.cos(limbSwing * walkSpeed + 5) * walkDegree * 0.5F * limbSwingAmount);
		this.LeftLeg4.xRot = -(Mth.cos(limbSwing * walkSpeed + 20) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLeg2.xRot = Mth.cos(limbSwing * walkSpeed + 15) * walkDegree * 0.5F * limbSwingAmount;
		this.RightLeg4.xRot = Mth.cos(limbSwing * walkSpeed + 25) * walkDegree * 0.5F * limbSwingAmount;
		this.LeftLeg1.xRot = -(Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLeg1.xRot = Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount;
		this.RightPedipalp.xRot = -0.15F * (Mth.sin(0.075F * ageInTicks + 1)) + 0.6527F;
		this.LeftPedipalp.xRot = -0.15F * Mth.sin(0.075F * ageInTicks) + 0.6527F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}