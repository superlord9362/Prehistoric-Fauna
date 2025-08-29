package superlord.prehistoricfauna.client.model.jurassic.shaximiao;

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
import superlord.prehistoricfauna.common.entity.jurassic.shaximiao.Rhipidoblattina;

public class RhipidoblattinaModel<T extends Rhipidoblattina> extends EntityModel<T> {
	private final ModelPart Body;
	private final ModelPart Head;
	private final ModelPart LeftAntenna;
	private final ModelPart RightAntenna;
	private final ModelPart LeftLeg1;
	private final ModelPart RightLeg1;
	private final ModelPart LeftLeg2;
	private final ModelPart RightLeg2;
	private final ModelPart LeftLeg3;
	private final ModelPart RightLeg3;

	public RhipidoblattinaModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Head = this.Body.getChild("Head");
		this.LeftAntenna = this.Head.getChild("LeftAntenna");
		this.RightAntenna = this.Head.getChild("RightAntenna");
		this.LeftLeg1 = this.Body.getChild("LeftLeg1");
		this.RightLeg1 = this.Body.getChild("RightLeg1");
		this.LeftLeg2 = this.Body.getChild("LeftLeg2");
		this.RightLeg2 = this.Body.getChild("RightLeg2");
		this.LeftLeg3 = this.Body.getChild("LeftLeg3");
		this.RightLeg3 = this.Body.getChild("RightLeg3");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 4).addBox(-1.5F, -0.5F, -3.75F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(13, 9).addBox(-1.0F, 0.5F, -0.75F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition Thorax = Body.addOrReplaceChild("Thorax", CubeListBuilder.create().texOffs(0, 10).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.001F))
		.texOffs(-7, 18).addBox(-2.0F, 0.5F, 0.0F, 4.0F, 0.0F, 7.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(0.0F, -0.25F, -0.75F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.25F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.75F, 0.2182F, 0.0F, 0.0F));

		PartDefinition LeftAntenna = Head.addOrReplaceChild("LeftAntenna", CubeListBuilder.create().texOffs(8, 0).addBox(-0.5F, 0.0F, -6.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -1.25F, -0.6109F, 0.0F, 0.0F));

		PartDefinition RightAntenna = Head.addOrReplaceChild("RightAntenna", CubeListBuilder.create().texOffs(15, 0).mirror().addBox(-3.0F, 0.0F, -6.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.0F, -1.25F, -0.6109F, 0.0F, 0.0F));

		PartDefinition LeftLeg1 = Body.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(12, 18).addBox(0.0F, 0.0F, -2.75F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.0F, -3.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition RightLeg1 = Body.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(21, 18).mirror().addBox(-4.0F, 0.0F, -3.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 1.0F, -2.75F, 0.0F, 0.0F, -0.2618F));

		PartDefinition LeftLeg2 = Body.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(12, 22).addBox(0.0F, 0.0F, -1.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition RightLeg2 = Body.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(21, 22).mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 1.0F, -2.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition LeftLeg3 = Body.addOrReplaceChild("LeftLeg3", CubeListBuilder.create().texOffs(10, 26).addBox(-1.0F, 0.0F, 0.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition RightLeg3 = Body.addOrReplaceChild("RightLeg3", CubeListBuilder.create().texOffs(19, 26).mirror().addBox(-3.0F, 0.0F, 0.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 1.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition cube_r1 = RightLeg3.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(19, 26).mirror().addBox(-3.0F, 0.0F, 0.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Rhipidoblattina entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 3.0f;
		float walkDegree = 2.0f;
		this.LeftLeg3.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount)) + 0.2618F;
		this.RightLeg3.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount)) - 0.2618F;
		this.LeftLeg2.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 5) * walkDegree * 0.5F * limbSwingAmount)) + 0.2618F;
		this.RightLeg2.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 15) * walkDegree * 0.5F * limbSwingAmount)) - 0.2618F;
		this.LeftLeg1.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount)) + 0.2618F;
		this.RightLeg1.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount)) - 0.2618F;
		this.LeftLeg3.xRot = -(Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLeg3.xRot = Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount;
		this.LeftLeg2.xRot = -(Mth.cos(limbSwing * walkSpeed + 5) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLeg2.xRot = Mth.cos(limbSwing * walkSpeed + 15) * walkDegree * 0.5F * limbSwingAmount;
		this.LeftLeg1.xRot = -(Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount);
		this.RightLeg1.xRot = Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount;
		this.RightAntenna.xRot = -0.15F * (Mth.sin(0.075F * ageInTicks + 1)) - 0.6109F;
		this.LeftAntenna.xRot = -0.15F * Mth.sin(0.075F * ageInTicks) - 0.6109F;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}