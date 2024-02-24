package superlord.prehistoricfauna.client.model.cretaceous.djadochta;

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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.DermestidBeetle;

public class DermestidBeetleModel extends EntityModel<DermestidBeetle> {
	private final ModelPart Body;
	private final ModelPart Head;
	private final ModelPart RightAntenna;
	private final ModelPart LeftAntenna;
	private final ModelPart LeftLeg1;
	private final ModelPart LeftLeg2;
	private final ModelPart LeftLeg3;
	private final ModelPart RightLeg1;
	private final ModelPart RightLeg2;
	private final ModelPart RightLeg3;

	public DermestidBeetleModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Head = Body.getChild("Head");
		this.RightAntenna = Head.getChild("RightAntenna");
		this.LeftAntenna = Head.getChild("LeftAntenna");
		this.LeftLeg1 = Body.getChild("LeftLeg1");
		this.LeftLeg2 = Body.getChild("LeftLeg2");
		this.LeftLeg3 = Body.getChild("LeftLeg3");
		this.RightLeg1 = Body.getChild("RightLeg1");
		this.RightLeg2 = Body.getChild("RightLeg2");
		this.RightLeg3 = Body.getChild("RightLeg3");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 9).addBox(-1.5F, -2.0F, -1.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(10, 4).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -1.0F));

		PartDefinition RightAntenna = Head.addOrReplaceChild("RightAntenna", CubeListBuilder.create().texOffs(0, 4).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.2F, -0.8F, -0.1329F, -0.173F, 0.023F));

		PartDefinition LeftAntenna = Head.addOrReplaceChild("LeftAntenna", CubeListBuilder.create().texOffs(0, 4).mirror().addBox(0.0F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 0.2F, -0.8F, -0.1329F, 0.173F, -0.023F));

		PartDefinition RightLeg3 = Body.addOrReplaceChild("RightLeg3", CubeListBuilder.create().texOffs(5, 4).mirror().addBox(-1.8F, -0.2F, -0.7F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, 1.0F, -0.119F, 0.734F, -0.1767F));

		PartDefinition LeftLeg3 = Body.addOrReplaceChild("LeftLeg3", CubeListBuilder.create().texOffs(5, 4).addBox(-0.2F, -0.2F, -0.7F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 1.0F, -0.119F, -0.734F, 0.1767F));

		PartDefinition RightLeg2 = Body.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(5, 4).mirror().addBox(-2.0F, -0.2F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0115F, -0.1304F, -0.088F));

		PartDefinition LeftLeg2 = Body.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(5, 4).addBox(0.0F, -0.2F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0115F, 0.1304F, 0.088F));

		PartDefinition RightLeg1 = Body.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(5, 4).mirror().addBox(-2.0F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -0.2F, -1.0F, 0.0361F, -0.3911F, -0.0944F));

		PartDefinition LeftLeg1 = Body.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(5, 4).addBox(0.0F, 0.0F, -0.5F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.2F, -1.0F, 0.0361F, 0.3911F, 0.0944F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(DermestidBeetle entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 3.0f;
		float walkDegree = 2.0f;
		this.LeftLeg3.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount)) + 0.1767F;
		this.RightLeg3.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount)) - 0.1767F;
		this.LeftLeg2.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 5) * walkDegree * 0.5F * limbSwingAmount)) + 0.1767F;
		this.RightLeg2.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 15) * walkDegree * 0.5F * limbSwingAmount)) - 0.1767F;
		this.LeftLeg1.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount)) + 0.1767F;
		this.RightLeg1.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount)) - 0.1767F;
		this.LeftLeg3.xRot = -(Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLeg3.xRot = Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount;
		this.LeftLeg2.xRot = -(Mth.cos(limbSwing * walkSpeed + 5) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLeg2.xRot = Mth.cos(limbSwing * walkSpeed + 15) * walkDegree * 0.5F * limbSwingAmount;
		this.LeftLeg1.xRot = -(Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLeg1.xRot = Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount;
		this.RightAntenna.xRot = -0.15F * (Mth.sin(0.075F * ageInTicks + 1));
		this.LeftAntenna.xRot = -0.15F * Mth.sin(0.075F * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}