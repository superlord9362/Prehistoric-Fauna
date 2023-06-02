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

public class TriceratopsSkeletonChargingModel extends EntityModel<TriceratopsSkeleton> {
	private final ModelPart Saddle;
	private final ModelPart RightHindLeg1;
	private final ModelPart LeftHindLeg1;
	private final ModelPart Body;
	private final ModelPart LeftFrontLeg;
	private final ModelPart RightFrontLeg;

	public TriceratopsSkeletonChargingModel(ModelPart root) {
		this.Saddle = root.getChild("Saddle");
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

		PartDefinition Saddle = partdefinition.addOrReplaceChild("Saddle", CubeListBuilder.create().texOffs(112, 172).addBox(-12.0F, -8.0F, -24.0F, 24.0F, 31.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, 4.0F));

		PartDefinition Chest3 = Saddle.addOrReplaceChild("Chest3", CubeListBuilder.create().texOffs(215, 163).addBox(-3.0F, 0.0F, -3.0F, 3.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, -2.0F, -15.0F));

		PartDefinition Saddle2 = Saddle.addOrReplaceChild("Saddle2", CubeListBuilder.create().texOffs(141, 143).addBox(-14.0F, -4.0F, -4.0F, 28.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 14.0F));

		PartDefinition Chest1 = Saddle.addOrReplaceChild("Chest1", CubeListBuilder.create().texOffs(207, 182).addBox(-6.0F, 0.0F, -6.0F, 6.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-12.0F, -11.0F, 8.0F));

		PartDefinition Chest4 = Saddle.addOrReplaceChild("Chest4", CubeListBuilder.create().texOffs(215, 163).mirror().addBox(0.0F, 0.0F, -3.0F, 3.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.0F, -2.0F, -15.0F));

		PartDefinition Chest2 = Saddle.addOrReplaceChild("Chest2", CubeListBuilder.create().texOffs(207, 182).mirror().addBox(0.0F, 0.0F, -6.0F, 6.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(12.0F, -11.0F, 8.0F));

		PartDefinition RightHindLeg1 = partdefinition.addOrReplaceChild("RightHindLeg1", CubeListBuilder.create().texOffs(190, 0).addBox(-4.0F, -5.0F, -8.0F, 8.0F, 25.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -10.0F, 10.0F, 0.3519F, 0.0F, 0.0F));

		PartDefinition RightHindLeg2 = RightHindLeg1.addOrReplaceChild("RightHindLeg2", CubeListBuilder.create().texOffs(190, 50).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 19.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 17.0F, 6.0F, -0.3128F, 0.0F, 0.0F));

		PartDefinition RightHindLeg3 = RightHindLeg2.addOrReplaceChild("RightHindLeg3", CubeListBuilder.create().texOffs(157, 0).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.0F, 3.0F, 0.1955F, 0.0F, 0.0F));

		PartDefinition LeftHindLeg1 = partdefinition.addOrReplaceChild("LeftHindLeg1", CubeListBuilder.create().texOffs(190, 0).mirror().addBox(-4.0F, -5.0F, -8.0F, 8.0F, 25.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-11.0F, -10.0F, 10.0F));

		PartDefinition LeftHindLeg2 = LeftHindLeg1.addOrReplaceChild("LeftHindLeg2", CubeListBuilder.create().texOffs(190, 50).mirror().addBox(-3.0F, -4.0F, -2.0F, 6.0F, 19.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 17.0F, 6.0F));

		PartDefinition LeftHindLeg3 = LeftHindLeg2.addOrReplaceChild("LeftHindLeg3", CubeListBuilder.create().texOffs(157, 0).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 3.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -5.0F, -24.0F, 24.0F, 25.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 4.0F, 0.1955F, 0.0F, 0.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 77).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 13.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 19.0F, -0.3187F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(88, 77).addBox(0.0F, -2.0F, -3.0F, 0.0F, 8.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.3F, 19.0F, 0.0911F, 0.0F, 0.0F));

		PartDefinition caudalvertebrae = Tail1.addOrReplaceChild("caudalvertebrae", CubeListBuilder.create().texOffs(0, 90).addBox(0.0F, -2.5F, 0.0F, 0.0F, 9.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -1.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(109, 8).addBox(-1.0F, -4.0F, -13.0F, 2.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -22.0F));

		PartDefinition Head1 = Neck.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(0, 130).addBox(-6.0F, -3.0F, -12.0F, 12.0F, 18.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -16.0F, 0.6182F, 0.0F, 0.0F));

		PartDefinition horn1_1 = Head1.addOrReplaceChild("horn1_1", CubeListBuilder.create().texOffs(60, 165).addBox(-2.0F, -4.0F, -20.0F, 3.0F, 4.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9F, -1.0F, -12.0F, -0.7285F, -0.182F, 0.0F));

		PartDefinition Crest = Head1.addOrReplaceChild("Crest", CubeListBuilder.create().texOffs(58, 127).addBox(-14.0F, -23.0F, -5.0F, 28.0F, 25.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, -3.0F, -0.5918F, 0.0F, 0.0F));

		PartDefinition Snout = Head1.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 169).addBox(-4.0F, 0.0F, -14.0F, 8.0F, 13.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -12.0F));

		PartDefinition Beak = Snout.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(0, 204).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -14.0F));

		PartDefinition nasalhorn = Snout.addOrReplaceChild("nasalhorn", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -5.0F, -3.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -12.0F, 0.6374F, 0.0F, 0.0F));

		PartDefinition horn1 = Head1.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(60, 165).addBox(-1.0F, -4.0F, -20.0F, 3.0F, 4.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9F, -1.0F, -12.0F, -0.7285F, 0.182F, 0.0F));

		PartDefinition part27 = Body.addOrReplaceChild("part27", CubeListBuilder.create().texOffs(91, 31).addBox(0.0F, 0.0F, 0.0F, 0.0F, 29.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, -24.0F));

		PartDefinition LeftFrontLeg = partdefinition.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(220, 75).mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 27.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.0F, -3.0F, -14.0F, 0.3128F, 0.0F, 0.0F));

		PartDefinition RightFrontLeg = partdefinition.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(220, 75).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 27.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, -3.0F, -14.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(TriceratopsSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Saddle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightHindLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftHindLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
