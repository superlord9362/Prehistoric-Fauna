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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.AnkylosaurusSkeleton;

public class AnkylosaurusSkeletonActionRightModel extends EntityModel<AnkylosaurusSkeleton>  {
	private final ModelPart RightHindLeg1;
	private final ModelPart LeftHindLeg1;
	private final ModelPart Body;
	private final ModelPart LeftFrontLeg;
	private final ModelPart RightFrontLeg;

	public AnkylosaurusSkeletonActionRightModel(ModelPart root) {
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

		PartDefinition RightHindLeg1 = partdefinition.addOrReplaceChild("RightHindLeg1", CubeListBuilder.create().texOffs(190, 33).addBox(-8.0F, 0.0F, -7.0F, 10.0F, 19.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(16.0F, -1.5F, 22.0F));

		PartDefinition RightHindLeg2 = RightHindLeg1.addOrReplaceChild("RightHindLeg2", CubeListBuilder.create().texOffs(201, 8).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 4.0F));

		PartDefinition RightHindLeg3 = RightHindLeg2.addOrReplaceChild("RightHindLeg3", CubeListBuilder.create().texOffs(157, 0).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition LeftHindLeg1 = partdefinition.addOrReplaceChild("LeftHindLeg1", CubeListBuilder.create().texOffs(190, 33).mirror().addBox(-2.0F, 0.0F, -7.0F, 10.0F, 18.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-16.0F, -1.5F, 22.0F));

		PartDefinition LeftHindLeg2 = LeftHindLeg1.addOrReplaceChild("LeftHindLeg2", CubeListBuilder.create().texOffs(201, 8).mirror().addBox(-3.0F, 0.0F, -2.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 17.0F, 4.0F));

		PartDefinition LeftHindLeg3 = LeftHindLeg2.addOrReplaceChild("LeftHindLeg3", CubeListBuilder.create().texOffs(157, 0).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-15.5F, -8.0F, -34.0F, 31.0F, 20.0F, 52.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 9.0F, 0.1564F, 0.0F, 0.0F));

		PartDefinition Vertebrae_Body = Body.addOrReplaceChild("Vertebrae_Body", CubeListBuilder.create().texOffs(84, 158).addBox(0.0F, -8.0F, -34.0F, 0.0F, 24.0F, 52.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(121, 142).addBox(-5.0F, -6.0F, -12.0F, 10.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -34.0F, -0.1955F, 0.0F, 0.0F));

		PartDefinition Head1 = Neck.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(152, 97).addBox(-7.0F, -5.0F, -12.0F, 14.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -12.0F, 0.0F, 0.2737F, 0.0F));

		PartDefinition Head2 = Head1.addOrReplaceChild("Head2", CubeListBuilder.create().texOffs(200, 93).addBox(-5.5F, -3.0F, -3.0F, 11.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -12.0F));

		PartDefinition Spike4 = Head1.addOrReplaceChild("Spike4", CubeListBuilder.create().texOffs(29, 32).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 2.0F, -2.0F, 0.0F, 0.9105F, 0.0F));

		PartDefinition Spike1 = Head1.addOrReplaceChild("Spike1", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-1.0F, -3.0F, 0.0F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -3.0F, 0.0F, 0.0911F, -0.2731F, 0.0F));

		PartDefinition Spike3 = Head1.addOrReplaceChild("Spike3", CubeListBuilder.create().texOffs(29, 32).addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 2.0F, -2.0F, 0.0F, -0.9105F, 0.0F));

		PartDefinition Spike1_1 = Head1.addOrReplaceChild("Spike1_1", CubeListBuilder.create().texOffs(0, 33).addBox(-4.0F, -3.0F, 0.0F, 5.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -3.0F, 0.0F, 0.0911F, 0.2731F, 0.0F));

		PartDefinition Neck_1 = Neck.addOrReplaceChild("Neck_1", CubeListBuilder.create().texOffs(103, 103).mirror().addBox(0.0F, -6.0F, -12.0F, 0.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition PectoralGirdle = Body.addOrReplaceChild("PectoralGirdle", CubeListBuilder.create().texOffs(169, 140).addBox(-16.0F, -8.0F, -34.0F, 32.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.01F, -0.5F));

		PartDefinition Osteoderms_Body = Body.addOrReplaceChild("Osteoderms_Body", CubeListBuilder.create().texOffs(0, 126).addBox(-16.5F, -8.0F, -34.0F, 33.0F, 14.0F, 53.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -1.0F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 76).addBox(-6.0F, -2.0F, 1.0F, 12.0F, 0.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 18.0F, -0.0391F, -0.1564F, 0.0F));

		PartDefinition Tail1_1 = Tail1.addOrReplaceChild("Tail1_1", CubeListBuilder.create().texOffs(0, 206).addBox(-6.0F, -3.0F, -4.0F, 12.0F, 13.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition Tail1_2 = Tail1.addOrReplaceChild("Tail1_2", CubeListBuilder.create().texOffs(13, 81).addBox(0.0F, -1.0F, 0.0F, 0.0F, 11.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(45, 87).addBox(0.0F, -1.0F, -5.0F, 0.0F, 9.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 16.5F, 0.0F, -0.2346F, 0.0F));

		PartDefinition Tail2_1 = Tail2.addOrReplaceChild("Tail2_1", CubeListBuilder.create().texOffs(45, 214).addBox(-2.5F, -3.0F, -5.0F, 5.0F, 6.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, 0.0F));

		PartDefinition TailClub = Tail2.addOrReplaceChild("TailClub", CubeListBuilder.create().texOffs(94, 85).addBox(-5.5F, -4.0F, 0.0F, 11.0F, 8.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 21.0F));

		PartDefinition LeftFrontLeg = partdefinition.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, -3.0F, 0.0F, 6.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-15.5F, 7.0F, -21.0F, 0.0F, 0.2737F, 0.0782F));

		PartDefinition RightFrontLeg = partdefinition.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, 0.0F, 6.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.5F, 7.0F, -21.0F, 0.0F, -0.2737F, -0.0782F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(AnkylosaurusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

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
