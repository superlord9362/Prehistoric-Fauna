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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Apoclion;

public class ApoclionModel extends EntityModel<Apoclion> {
	private final ModelPart Body;
	private final ModelPart Chest;
	private final ModelPart Head;
	private final ModelPart RightAntenna;
	private final ModelPart LeftAntenna;
	private final ModelPart LeftLegFront;
	private final ModelPart LeftLegMiddle;
	private final ModelPart LeftLegBack;
	private final ModelPart RightLegFront;
	private final ModelPart RightLegMiddle;
	private final ModelPart RightLegBack;

	public ApoclionModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Chest = Body.getChild("Chest");
		this.LeftLegBack = Chest.getChild("LeftLegBack");
		this.LeftLegMiddle = Chest.getChild("LeftLegMiddle");
		this.LeftLegFront = Chest.getChild("LeftLegFront");
		this.RightLegBack = Chest.getChild("RightLegBack");
		this.RightLegMiddle = Chest.getChild("RightLegMiddle");
		this.RightLegFront = Chest.getChild("RightLegFront");
		this.Head = Chest.getChild("Head");
		this.LeftAntenna = Head.getChild("LeftAntenna");
		this.RightAntenna = Head.getChild("RightAntenna");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 2).addBox(-1.0F, -1.2F, -1.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Chest = Body.addOrReplaceChild("Chest", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.7F, -1.0F));

		PartDefinition Head = Chest.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(6, 6).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition LeftAntenna = Head.addOrReplaceChild("LeftAntenna", CubeListBuilder.create().texOffs(-2, 0).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2F, -1.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition RightAntenna = Head.addOrReplaceChild("RightAntenna", CubeListBuilder.create().texOffs(-2, 0).mirror().addBox(0.0F, 0.0F, -1.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.2F, -1.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition RightLegFront = Chest.addOrReplaceChild("RightLegFront", CubeListBuilder.create().texOffs(6, 3).mirror().addBox(-1.6F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.7F, 0.5F, -1.5F, 0.0F, -0.3054F, -0.1309F));

		PartDefinition LeftLegFront = Chest.addOrReplaceChild("LeftLegFront", CubeListBuilder.create().texOffs(6, 3).addBox(-0.4F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 0.5F, -1.5F, 0.0F, 0.3054F, 0.1309F));

		PartDefinition RightLegMiddle = Chest.addOrReplaceChild("RightLegMiddle", CubeListBuilder.create().texOffs(6, 3).mirror().addBox(-1.6F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.7F, 0.5F, -0.4F, 0.0F, 0.0F, -0.1309F));

		PartDefinition LeftLegMiddle = Chest.addOrReplaceChild("LeftLegMiddle", CubeListBuilder.create().texOffs(6, 3).addBox(-0.4F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 0.5F, -0.4F, 0.0F, 0.0F, 0.1309F));

		PartDefinition RightLegBack = Chest.addOrReplaceChild("RightLegBack", CubeListBuilder.create().texOffs(6, 3).mirror().addBox(-1.6F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.7F, 0.5F, 0.7F, 0.0F, 0.3054F, -0.1309F));

		PartDefinition LeftLegBack = Chest.addOrReplaceChild("LeftLegBack", CubeListBuilder.create().texOffs(6, 3).addBox(-0.4F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 0.5F, 0.7F, 0.0F, -0.3054F, 0.1309F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(Apoclion entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}