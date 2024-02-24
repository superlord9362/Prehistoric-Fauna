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
import superlord.prehistoricfauna.common.entity.cretaceous.djadochta.Gobiulus;

public class GobiulusModel extends EntityModel<Gobiulus> {
	private final ModelPart Body2;
	private final ModelPart Body1;
	private final ModelPart Body3;
	private final ModelPart Body4;
	private final ModelPart Head;
	private final ModelPart LeftAntenna;
	private final ModelPart RightAntenna;
	private final ModelPart RightLeg1;
	private final ModelPart RightLeg2;
	private final ModelPart RightLeg3;
	private final ModelPart RightLeg4;
	private final ModelPart RightLeg5;
	private final ModelPart RightLeg6;
	private final ModelPart RightLeg7;
	private final ModelPart RightLeg8;
	private final ModelPart RightLeg9;
	private final ModelPart LeftLeg1;
	private final ModelPart LeftLeg2;
	private final ModelPart LeftLeg3;
	private final ModelPart LeftLeg4;
	private final ModelPart LeftLeg5;
	private final ModelPart LeftLeg6;
	private final ModelPart LeftLeg7;
	private final ModelPart LeftLeg8;
	private final ModelPart LeftLeg9;

	public GobiulusModel(ModelPart root) {
		this.Body3 = root.getChild("Body3");
		this.Body2 = Body3.getChild("Body2");
		this.Body1 = Body2.getChild("Body1");
		this.Head = Body1.getChild("Head");
		this.Body4 = Body3.getChild("Body4");
		this.LeftAntenna = Head.getChild("LeftAntenna");
		this.RightAntenna = Head.getChild("RightAntenna");
		this.RightLeg1 = Head.getChild("RightLeg1");
		this.RightLeg2 = Head.getChild("RightLeg2");
		this.LeftLeg1 = Head.getChild("LeftLeg1");
		this.LeftLeg2 = Head.getChild("LeftLeg2");
		this.RightLeg3 = Body1.getChild("RightLeg3");
		this.RightLeg4 = Body1.getChild("RightLeg4");
		this.LeftLeg3 = Body1.getChild("LeftLeg3");
		this.LeftLeg4 = Body1.getChild("LeftLeg4");
		this.RightLeg5 = Body2.getChild("RightLeg5");
		this.LeftLeg5 = Body2.getChild("LeftLeg5");
		this.RightLeg6 = Body3.getChild("RightLeg6");
		this.RightLeg7 = Body3.getChild("RightLeg7");
		this.LeftLeg6 = Body3.getChild("LeftLeg6");
		this.LeftLeg7 = Body3.getChild("LeftLeg7");
		this.RightLeg8 = Body4.getChild("RightLeg8");
		this.RightLeg9 = Body4.getChild("RightLeg9");
		this.LeftLeg8 = Body4.getChild("LeftLeg8");
		this.LeftLeg9 = Body4.getChild("LeftLeg9");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body3 = partdefinition.addOrReplaceChild("Body3", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -2.3F, 3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body4 = Body3.addOrReplaceChild("Body4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.3F, 6.0F));

		PartDefinition LeftLeg9 = Body4.addOrReplaceChild("LeftLeg9", CubeListBuilder.create().texOffs(0, 1).addBox(0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition RightLeg9 = Body4.addOrReplaceChild("RightLeg9", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 1.0F, 1.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition LeftLeg8 = Body4.addOrReplaceChild("LeftLeg8", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.0F, -0.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition RightLeg8 = Body4.addOrReplaceChild("RightLeg8", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 1.0F, -0.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition LeftLeg7 = Body3.addOrReplaceChild("LeftLeg7", CubeListBuilder.create().texOffs(0, 1).addBox(0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.3F, 4.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition RightLeg7 = Body3.addOrReplaceChild("RightLeg7", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -0.3F, 4.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition LeftLeg6 = Body3.addOrReplaceChild("LeftLeg6", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.3F, 2.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition RightLeg6 = Body3.addOrReplaceChild("RightLeg6", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -0.3F, 2.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Body2 = Body3.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(7, 2).addBox(-1.0F, -1.3F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 3.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LeftLeg5 = Body2.addOrReplaceChild("LeftLeg5", CubeListBuilder.create().texOffs(0, 1).addBox(0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.7F, -2.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition RightLeg5 = Body2.addOrReplaceChild("RightLeg5", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.7F, -2.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Body1 = Body2.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(7, 7).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.3F, -3.0F));

		PartDefinition Head = Body1.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition LeftAntenna = Head.addOrReplaceChild("LeftAntenna", CubeListBuilder.create().texOffs(5, 0).addBox(-0.5F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.8F, -3.0F, -0.1309F, -0.6109F, 0.0F));

		PartDefinition RightAntenna = Head.addOrReplaceChild("RightAntenna", CubeListBuilder.create().texOffs(9, 0).addBox(-1.5F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.8F, -3.0F, -0.1309F, 0.6109F, 0.0F));

		PartDefinition LeftLeg1 = Head.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(0, 1).addBox(0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.0F, -2.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition RightLeg1 = Head.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 1.0F, -2.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition LeftLeg2 = Head.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.0F, -0.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition RightLeg2 = Head.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 1.0F, -0.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition LeftLeg3 = Body1.addOrReplaceChild("LeftLeg3", CubeListBuilder.create().texOffs(0, 1).addBox(0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.0F, -2.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition RightLeg3 = Body1.addOrReplaceChild("RightLeg3", CubeListBuilder.create().texOffs(0, 1).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 1.0F, -2.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition LeftLeg4 = Body1.addOrReplaceChild("LeftLeg4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.0F, -0.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition RightLeg4 = Body1.addOrReplaceChild("RightLeg4", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 1.0F, -0.5F, 0.0F, 0.0F, -0.3927F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Gobiulus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walkSpeed = 3.0f;
		float walkDegree = 2.0f;
		this.LeftLeg1.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.5F) * walkDegree * limbSwingAmount)) + 0.3927F;
		this.RightLeg1.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.5F) * walkDegree * limbSwingAmount)) - 0.3927F;
		this.LeftLeg5.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.5F) * walkDegree * limbSwingAmount)) + 0.3927F;
		this.RightLeg5.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.5F) * walkDegree * limbSwingAmount)) - 0.3927F;
		this.LeftLeg9.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.5F) * walkDegree * limbSwingAmount)) + 0.3927F;
		this.RightLeg9.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.5F) * walkDegree * limbSwingAmount)) - 0.3927F;
		this.LeftLeg8.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.5F + 5) * walkDegree * limbSwingAmount)) + 0.3927F;
		this.RightLeg8.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.5F + 5) * walkDegree * limbSwingAmount)) - 0.3927F;
		this.LeftLeg6.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.5F + 5) * walkDegree * limbSwingAmount)) + 0.3927F;
		this.RightLeg6.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.5F + 5) * walkDegree * limbSwingAmount)) - 0.3927F;
		this.LeftLeg4.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.5F + 5) * walkDegree * limbSwingAmount)) + 0.3927F;
		this.RightLeg4.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.5F + 5) * walkDegree * limbSwingAmount)) - 0.3927F;
		this.LeftLeg2.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.5F + 5) * walkDegree * limbSwingAmount)) + 0.3927F;
		this.RightLeg2.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.5F + 5) * walkDegree * limbSwingAmount)) - 0.3927F;
		this.LeftLeg7.zRot = -Math.abs((Mth.cos(limbSwing * walkSpeed * 0.5F + 10) * walkDegree * limbSwingAmount)) + 0.3927F;
		this.RightLeg7.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.5F + 10) * walkDegree * limbSwingAmount)) - 0.3927F;
		this.LeftLeg3.zRot = Math.abs((Mth.cos(limbSwing * walkSpeed * 0.5F + 10) * walkDegree * limbSwingAmount)) + 0.3927F;
		this.RightLeg3.zRot = Math.abs(-(Mth.cos(limbSwing * walkSpeed * 0.5F + 10) * walkDegree * limbSwingAmount)) - 0.3927F;
		this.RightAntenna.xRot = -0.15F * (Mth.sin(0.075F * ageInTicks + 1));
		this.LeftAntenna.xRot = -0.15F * Mth.sin(0.075F * ageInTicks);
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F) / 8;
		this.Body1.yRot = netHeadYaw * ((float)Math.PI / 180F) / 4;
		this.Body2.yRot = netHeadYaw * ((float)Math.PI / 180F) / 2;
		this.Head.xRot = (headPitch * ((float)Math.PI / 180F)) / 8;
		this.Body1.xRot = (headPitch * ((float)Math.PI / 180F)) / 4;
		this.Body2.xRot = (headPitch * ((float)Math.PI / 180F)) / 2;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}