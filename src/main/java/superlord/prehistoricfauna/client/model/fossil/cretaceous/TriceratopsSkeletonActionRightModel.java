package superlord.prehistoricfauna.client.model.fossil.cretaceous;

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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.TriceratopsSkeleton;

public class TriceratopsSkeletonActionRightModel extends EntityModel<TriceratopsSkeleton> {
	private final ModelPart RightHindLeg1;
	private final ModelPart LeftHindLeg1;
	private final ModelPart Body;
	private final ModelPart LeftFrontLeg;
	private final ModelPart RightFrontLeg;

	public TriceratopsSkeletonActionRightModel(ModelPart root) {
		this.RightHindLeg1 = root.getChild("RightHindLeg1");
		this.LeftHindLeg1 = root.getChild("LeftHindLeg1");
		this.Body = root.getChild("Body");
		this.LeftFrontLeg = root.getChild("LeftFrontLeg");
		this.RightFrontLeg = root.getChild("RightFrontLeg");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightHindLeg1 = partdefinition.addOrReplaceChild("RightHindLeg1", CubeListBuilder.create().texOffs(197, 1).addBox(-2.0F, -3.0F, -4.0F, 6.0F, 25.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -12.0F, 14.0F, -0.3491F, -0.3491F, 0.0F));

		PartDefinition RightHindLeg2 = RightHindLeg1.addOrReplaceChild("RightHindLeg2", CubeListBuilder.create().texOffs(190, 60).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, 9.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition RightHindLeg3 = RightHindLeg2.addOrReplaceChild("RightHindLeg3", CubeListBuilder.create().texOffs(157, 0).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 3.0F));

		PartDefinition LeftHindLeg1 = partdefinition.addOrReplaceChild("LeftHindLeg1", CubeListBuilder.create().texOffs(197, 1).mirror().addBox(-4.0F, -3.0F, -4.0F, 6.0F, 25.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, -11.0F, 13.0F, 0.3491F, 0.3491F, 0.3491F));

		PartDefinition LeftHindLeg2 = LeftHindLeg1.addOrReplaceChild("LeftHindLeg2", CubeListBuilder.create().texOffs(190, 60).mirror().addBox(-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 19.0F, 9.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition LeftHindLeg3 = LeftHindLeg2.addOrReplaceChild("LeftHindLeg3", CubeListBuilder.create().texOffs(157, 0).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 3.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -5.0F, -24.0F, 24.0F, 25.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, 4.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(110, 6).addBox(0.0F, -4.0F, -13.0F, 0.0F, 11.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -1.0F, -20.0F, -0.3491F, -0.3491F, 0.0F));

		PartDefinition Head1 = Neck.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(0, 130).addBox(-6.0F, -3.0F, -12.0F, 12.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.0F, -16.0F, 0.5009F, 0.0F, 0.1745F));

		PartDefinition Snout = Head1.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 168).addBox(-4.0F, 0.0F, -14.0F, 8.0F, 9.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -12.0F));

		PartDefinition Beak = Snout.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(0, 204).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -14.0F));

		PartDefinition nasalhorn = Snout.addOrReplaceChild("nasalhorn", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -5.0F, -3.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -12.0F, 0.6374F, 0.0F, 0.0F));

		PartDefinition LTeeth = Snout.addOrReplaceChild("LTeeth", CubeListBuilder.create().texOffs(1, 193).addBox(-0.5F, 0.0F, -6.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 9.0F, 0.0F));

		PartDefinition RTeeth = Snout.addOrReplaceChild("RTeeth", CubeListBuilder.create().texOffs(1, 193).addBox(-0.5F, 0.0F, -6.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 9.0F, 0.0F));

		PartDefinition Frill = Head1.addOrReplaceChild("Frill", CubeListBuilder.create().texOffs(58, 127).addBox(-14.0F, -23.0F, -5.0F, 28.0F, 22.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, -3.0F, -0.5918F, 0.0F, 0.0F));

		PartDefinition horn1_1 = Head1.addOrReplaceChild("horn1_1", CubeListBuilder.create().texOffs(60, 165).addBox(-2.0F, -4.0F, -20.0F, 3.0F, 4.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9F, -1.0F, -12.0F, -0.7285F, -0.182F, 0.0F));

		PartDefinition horn1 = Head1.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(60, 165).addBox(-1.0F, -4.0F, -20.0F, 3.0F, 4.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9F, -1.0F, -12.0F, -0.7285F, 0.182F, 0.0F));

		PartDefinition Head11 = Head1.addOrReplaceChild("Head11", CubeListBuilder.create().texOffs(79, 196).addBox(-4.0F, -4.0F, -12.0F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.0F, 0.1F, 0.5236F, 0.0F, 0.0F));

		PartDefinition Head111 = Head11.addOrReplaceChild("Head111", CubeListBuilder.create().texOffs(27, 188).addBox(-4.0F, -3.0F, -14.0F, 8.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -12.0F));

		PartDefinition CervicalRibs = Neck.addOrReplaceChild("CervicalRibs", CubeListBuilder.create().texOffs(14, 74).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -12.0F));

		PartDefinition part27 = Body.addOrReplaceChild("part27", CubeListBuilder.create().texOffs(91, 31).addBox(0.0F, 0.0F, 0.0F, 0.0F, 29.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, -24.0F));

		PartDefinition Body1 = Body.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(134, 28).addBox(-13.0F, -5.0F, -24.0F, 26.0F, 25.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LPelvis = Body.addOrReplaceChild("LPelvis", CubeListBuilder.create().texOffs(138, 115).addBox(0.0F, 0.0F, -12.0F, 0.0F, 23.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, 11.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition RPelvis = Body.addOrReplaceChild("RPelvis", CubeListBuilder.create().texOffs(138, 115).mirror().addBox(0.0F, 0.0F, -12.0F, 0.0F, 23.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 0.0F, 11.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition CaudalVertebrae = Body.addOrReplaceChild("CaudalVertebrae", CubeListBuilder.create().texOffs(0, 90).addBox(-0.1F, -2.5F, 0.0F, 0.0F, 10.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 19.0F, -0.384F, 0.3491F, 0.0F));

		PartDefinition CaudalRibs = CaudalVertebrae.addOrReplaceChild("CaudalRibs", CubeListBuilder.create().texOffs(5, 82).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition CaudalVertebrae2 = CaudalVertebrae.addOrReplaceChild("CaudalVertebrae2", CubeListBuilder.create().texOffs(88, 77).addBox(0.1F, -2.0F, -3.0F, 0.0F, 9.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 20.0F, 0.2443F, 0.3491F, 0.0F));

		PartDefinition CaudalRibs2 = CaudalVertebrae2.addOrReplaceChild("CaudalRibs2", CubeListBuilder.create().texOffs(14, 74).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftFrontLeg = partdefinition.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(220, 75).mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 27.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -2.0F, -14.0F, -0.6981F, -0.1745F, 0.3491F));

		PartDefinition RightFrontLeg = partdefinition.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(220, 75).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 27.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -3.0F, -14.0F, 0.0F, 0.1745F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(TriceratopsSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightHindLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftHindLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}