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
import superlord.prehistoricfauna.common.entity.cretaceous.hellcreek.Cephaloleichnites;

public class CephaloleichnitesModel extends EntityModel<Cephaloleichnites> {
		private final ModelPart Head;
		private final ModelPart RightAntenna;
		private final ModelPart LeftAntenna;
		private final ModelPart Body;
		private final ModelPart LeftLegFront;
		private final ModelPart LeftLegMiddle;
		private final ModelPart LeftLegBack;
		private final ModelPart RightLegFront;
		private final ModelPart RightLegMiddle;
		private final ModelPart RightLegBack;

	public CephaloleichnitesModel(ModelPart root) {
		this.Head = root.getChild("Head");
		this.RightAntenna = Head.getChild("RightAntenna");
		this.LeftAntenna = Head.getChild("LeftAntenna");
		this.Body = Head.getChild("Body");
		this.LeftLegFront = Body.getChild("LeftLegFront");
		this.LeftLegMiddle = Body.getChild("LeftLegMiddle");
		this.LeftLegBack = Body.getChild("LeftLegBack");
		this.RightLegFront = Body.getChild("RightLegFront");
		this.RightLegMiddle = Body.getChild("RightLegMiddle");
		this.RightLegBack = Body.getChild("RightLegBack");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 1).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.6F, -2.0F));

		PartDefinition Body = Head.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(2, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition LeftLegFront = Body.addOrReplaceChild("LeftLegFront", CubeListBuilder.create().texOffs(10, 3).addBox(-0.5F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -0.5F, 0.0F, 0.4363F, 0.2618F));

		PartDefinition RightLegFront = Body.addOrReplaceChild("RightLegFront", CubeListBuilder.create().texOffs(10, 3).addBox(-1.5F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, -0.5F, 0.0F, -0.4363F, -0.2618F));

		PartDefinition RightLegMiddle = Body.addOrReplaceChild("RightLegMiddle", CubeListBuilder.create().texOffs(10, 3).addBox(-1.5F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.5F, 0.0F, 0.0F, -0.2618F));

		PartDefinition LeftLegMiddle = Body.addOrReplaceChild("LeftLegMiddle", CubeListBuilder.create().texOffs(10, 3).addBox(-0.5F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.2618F));

		PartDefinition LeftLegBack = Body.addOrReplaceChild("LeftLegBack", CubeListBuilder.create().texOffs(10, 3).addBox(-0.5F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 1.5F, 0.0F, -0.4363F, 0.2618F));

		PartDefinition RightLegBack = Body.addOrReplaceChild("RightLegBack", CubeListBuilder.create().texOffs(10, 3).addBox(-1.5F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 1.5F, 0.0F, 0.4363F, -0.2618F));

		PartDefinition LeftAntenna = Head.addOrReplaceChild("LeftAntenna", CubeListBuilder.create().texOffs(11, -2).addBox(0.4F, -2.6F, -1.25F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -1.0F, 0.6109F, -0.1745F, 0.0F));

		PartDefinition RightAntenna = Head.addOrReplaceChild("RightAntenna", CubeListBuilder.create().texOffs(11, -2).addBox(-0.4F, -2.6F, -1.25F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -1.0F, 0.6109F, 0.1745F, 0.0F));

		return LayerDefinition.create(meshdefinition, 15, 5);
	}

	@Override
	public void setupAnim(Cephaloleichnites entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 3.0f;
		float walkDegree = 2.0f;
		this.LeftLegBack.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount)) + 0.1767F;
		this.RightLegBack.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount)) - 0.1767F;
		this.LeftLegMiddle.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 5) * walkDegree * 0.5F * limbSwingAmount)) + 0.1767F;
		this.RightLegMiddle.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 15) * walkDegree * 0.5F * limbSwingAmount)) - 0.1767F;
		this.LeftLegFront.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount)) + 0.1767F;
		this.RightLegFront.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount)) - 0.1767F;
		this.LeftLegBack.xRot = -(Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLegBack.xRot = Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount;
		this.LeftLegMiddle.xRot = -(Mth.cos(limbSwing * walkSpeed + 5) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLegMiddle.xRot = Mth.cos(limbSwing * walkSpeed + 15) * walkDegree * 0.5F * limbSwingAmount;
		this.LeftLegFront.xRot = -(Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLegFront.xRot = Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount;
		this.RightAntenna.xRot = -0.15F * (Mth.sin(0.075F * ageInTicks + 1)) + 0.6109F;
		this.LeftAntenna.xRot = -0.15F * Mth.sin(0.075F * ageInTicks) + 0.6109F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}