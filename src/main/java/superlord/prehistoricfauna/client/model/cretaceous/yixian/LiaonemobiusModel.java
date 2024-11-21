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
import superlord.prehistoricfauna.common.entity.cretaceous.yixian.Liaonemobius;

public class LiaonemobiusModel extends EntityModel<Liaonemobius> {
	private final ModelPart Body;
	private final ModelPart Head;
	private final ModelPart LeftAntenna;
	private final ModelPart RightAntenna;
	private final ModelPart LeftLeg1;
	private final ModelPart LeftLeg2;
	private final ModelPart LeftLeg3;
	private final ModelPart RightLeg1;
	private final ModelPart RightLeg2;
	private final ModelPart RightLeg3;

	public LiaonemobiusModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Head = this.Body.getChild("Head");
		this.LeftAntenna = this.Head.getChild("LeftAntenna");
		this.RightAntenna = this.Head.getChild("RightAntenna");
		this.LeftLeg1 = this.Body.getChild("LeftLeg1");
		this.LeftLeg2 = this.Body.getChild("LeftLeg2");
		this.LeftLeg3 = this.Body.getChild("LeftLeg3");
		this.RightLeg1 = this.Body.getChild("RightLeg1");
		this.RightLeg2 = this.Body.getChild("RightLeg2");
		this.RightLeg3 = this.Body.getChild("RightLeg3");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(1, 19).addBox(-1.5F, -2.0F, 1.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.3F, -3.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(12, 1).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftAntenna = Head.addOrReplaceChild("LeftAntenna", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, -0.5F, -5.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, 0.1F, -0.2618F, 0.1309F, 0.0F));

		PartDefinition RightAntenna = Head.addOrReplaceChild("RightAntenna", CubeListBuilder.create().texOffs(0, 8).mirror().addBox(0.0F, -0.5F, -5.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, -1.0F, 0.1F, -0.2618F, -0.1309F, 0.0F));

		PartDefinition LeftLeg1 = Body.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(14, 14).addBox(-2.3F, -0.3F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -1.0F, 2.0F, -0.3927F, -0.3927F, 0.3927F));

		PartDefinition LeftLeg2 = Body.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(14, 14).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -1.0F, 2.75F, 0.0F, 0.0F, 0.3927F));

		PartDefinition LeftLeg3 = Body.addOrReplaceChild("LeftLeg3", CubeListBuilder.create().texOffs(11, 8).addBox(-9.0F, 0.0F, 0.0F, 9.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.75F, 2.0F, 0.7854F, 0.9163F, 1.0036F));

		PartDefinition RightLeg1 = Body.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(14, 14).mirror().addBox(-0.7F, -0.3F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, -1.0F, 2.0F, -0.3927F, 0.3927F, -0.3927F));

		PartDefinition RightLeg2 = Body.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(14, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.75F, -1.0F, 2.75F, 0.0F, 0.0F, -0.3927F));

		PartDefinition RightLeg3 = Body.addOrReplaceChild("RightLeg3", CubeListBuilder.create().texOffs(11, 8).mirror().addBox(0.0F, 0.0F, 0.0F, 9.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -1.75F, 2.0F, 0.7854F, -0.9163F, -1.0036F));

		PartDefinition ButtSpikes = Body.addOrReplaceChild("ButtSpikes", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 5.75F, 0.2182F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Liaonemobius entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 3.0f;
		float walkDegree = 2.0f;
		this.RightAntenna.xRot = -0.15F * (Mth.sin(0.075F * ageInTicks + 1)) - 0.2618F;
		this.LeftAntenna.xRot = -0.15F * Mth.sin(0.075F * ageInTicks) - 0.2618F;
		if (entity.isUpsideDownNavigator) {
			this.LeftLeg3.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount)) + 1.0036F;
			this.RightLeg3.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount)) - 1.0036F;
			this.LeftLeg2.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed + 5) * walkDegree * 0.5F * limbSwingAmount)) + 0.1767F;
			this.RightLeg2.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 15) * walkDegree * 0.5F * limbSwingAmount)) - 0.1767F;
			this.LeftLeg1.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount)) + 0.3927F;
			this.RightLeg1.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount)) - 0.3927F;
			this.LeftLeg3.xRot = -(Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount) + 0.7854F;
			this.RightLeg3.xRot = Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount + 0.7854F;
			this.LeftLeg2.xRot = -(Mth.cos(limbSwing * walkSpeed + 5) * walkDegree * 0.5F * limbSwingAmount);
			this.RightLeg2.xRot = Mth.cos(limbSwing * walkSpeed + 15) * walkDegree * 0.5F * limbSwingAmount;
			this.LeftLeg1.xRot = -(Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount) - 0.3927F;
			this.RightLeg1.xRot = Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount - 0.3927F;
		} else {
			this.LeftLeg3.zRot = Math.abs((Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount)) + 1.0036F;
			this.RightLeg3.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount)) - 1.0036F;
			this.LeftLeg2.zRot = Math.abs((Mth.cos(limbSwing * walkSpeed + 5) * walkDegree * 0.5F * limbSwingAmount)) + 0.3927F;
			this.RightLeg2.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 15) * walkDegree * 0.5F * limbSwingAmount)) - 0.3927F;
			this.LeftLeg1.zRot = Math.abs((Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount)) + 0.1767F;
			this.RightLeg1.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount)) - 0.1767F;
			this.LeftLeg3.xRot = -(Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount) + 0.7854F;
			this.RightLeg3.xRot = Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount + 0.7854F;
			this.LeftLeg2.xRot = (Mth.cos(limbSwing * walkSpeed + 5) * walkDegree * 0.5F * limbSwingAmount);
			this.RightLeg2.xRot = Mth.cos(limbSwing * walkSpeed + 15) * walkDegree * 0.5F * limbSwingAmount;
			this.LeftLeg1.xRot = (Mth.cos(limbSwing * walkSpeed) * walkDegree * 0.5F * limbSwingAmount ) - 0.3927F;
			this.RightLeg1.xRot = Mth.cos(limbSwing * walkSpeed + 10) * walkDegree * 0.5F * limbSwingAmount - 0.3927F;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}