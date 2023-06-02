package superlord.prehistoricfauna.client.model.fossil.jurassic;

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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.ScelidosaurusSkeleton;

public class ScelidosaurusSkeletonWalkingModel extends EntityModel<ScelidosaurusSkeleton> {
	private final ModelPart LegLeft;
	private final ModelPart Body;
	private final ModelPart LegRight;

	public ScelidosaurusSkeletonWalkingModel(ModelPart root) {
		this.LegLeft = root.getChild("LegLeft");
		this.Body = root.getChild("Body");
		this.LegRight = root.getChild("LegRight");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LegLeft = partdefinition.addOrReplaceChild("LegLeft", CubeListBuilder.create().texOffs(44, 33).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 10.5F, 8.0F, 0.1745F, -0.1745F, 0.0F));

		PartDefinition Leg2Left = LegLeft.addOrReplaceChild("Leg2Left", CubeListBuilder.create().texOffs(44, 47).mirror().addBox(-1.5F, 0.0F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.4F, 7.5F, 2.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition FootLeft = Leg2Left.addOrReplaceChild("FootLeft", CubeListBuilder.create().texOffs(42, 57).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.9F, -1.5F, -0.3491F, 0.0F, 0.0F));

		PartDefinition part24_1 = LegLeft.addOrReplaceChild("part24_1", CubeListBuilder.create().texOffs(44, 108).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.1F, -0.1F, -3.1F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -3.0F, -19.0F, 9.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 8.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(44, 5).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 3.0F, -0.1396F, 0.2094F, 0.0F));

		PartDefinition Tail_1 = Tail.addOrReplaceChild("Tail_1", CubeListBuilder.create().texOffs(49, 5).addBox(0.0F, -1.0F, 0.0F, 0.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition Tail2 = Tail_1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(65, 5).addBox(-1.5F, 0.0F, 1.0F, 3.0F, 0.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 9.0F, -0.1396F, 0.2094F, 0.0F));

		PartDefinition Tail2_1 = Tail2.addOrReplaceChild("Tail2_1", CubeListBuilder.create().texOffs(66, 5).addBox(0.0F, -1.0F, 0.0F, 0.0F, 4.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition part27 = Tail2_1.addOrReplaceChild("part27", CubeListBuilder.create().texOffs(25, 127).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -0.5F, 1.0F));

		PartDefinition part31 = part27.addOrReplaceChild("part31", CubeListBuilder.create().texOffs(122, 20).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -0.5F, 0.0F));

		PartDefinition part28 = Tail2_1.addOrReplaceChild("part28", CubeListBuilder.create().texOffs(67, 109).addBox(-3.0F, 0.0F, -5.0F, 6.0F, 0.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 1.0F));

		PartDefinition part25 = Tail.addOrReplaceChild("part25", CubeListBuilder.create().texOffs(43, 78).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition part26 = part25.addOrReplaceChild("part26", CubeListBuilder.create().texOffs(106, 99).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, 0.0F, 0.0F, 0.0F, -0.0017F));

		PartDefinition part30 = part26.addOrReplaceChild("part30", CubeListBuilder.create().texOffs(0, 120).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -2.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 32).addBox(-1.5F, -2.0F, -6.0F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -19.0F, -0.1745F, 0.3491F, 0.0F));

		PartDefinition Neck_2 = Neck.addOrReplaceChild("Neck_2", CubeListBuilder.create().texOffs(0, 32).addBox(-1.5F, -2.0F, -6.0F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Neck_1 = Neck.addOrReplaceChild("Neck_1", CubeListBuilder.create().texOffs(0, 107).addBox(-3.0F, -1.0F, -7.0F, 3.0F, 5.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offset(1.5F, -1.3F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 44).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -6.0F, 0.3142F, 0.1745F, -0.0698F));

		PartDefinition part21 = Head.addOrReplaceChild("part21", CubeListBuilder.create().texOffs(14, 48).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(0, 52).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

		PartDefinition Body_3 = Body.addOrReplaceChild("Body_3", CubeListBuilder.create().texOffs(0, 75).addBox(-5.0F, -3.0F, -19.0F, 10.0F, 10.0F, 22.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition part29 = Body_3.addOrReplaceChild("part29", CubeListBuilder.create().texOffs(111, 39).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -5.0F, -18.0F));

		PartDefinition part22 = Body_3.addOrReplaceChild("part22", CubeListBuilder.create().texOffs(71, 75).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 0.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.5F, -19.0F));

		PartDefinition Body_2 = Body.addOrReplaceChild("Body_2", CubeListBuilder.create().texOffs(113, 1).addBox(-5.0F, -3.0F, -19.0F, 10.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition ArmLeft = Body.addOrReplaceChild("ArmLeft", CubeListBuilder.create().texOffs(28, 34).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, -16.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition part23_1 = ArmLeft.addOrReplaceChild("part23_1", CubeListBuilder.create().texOffs(28, 109).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offset(1.1F, 0.0F, -1.0F));

		PartDefinition Body_1 = Body.addOrReplaceChild("Body_1", CubeListBuilder.create().texOffs(51, 37).addBox(0.0F, -4.0F, -19.0F, 0.0F, 10.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ArmRight = Body.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(28, 34).mirror().addBox(-1.0F, 0.0F, -1.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 2.0F, -16.0F, 0.5585F, 0.0F, -0.1745F));

		PartDefinition part23 = ArmRight.addOrReplaceChild("part23", CubeListBuilder.create().texOffs(28, 109).mirror().addBox(-3.0F, 0.0F, 0.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offset(1.9F, 0.0F, -1.0F));

		PartDefinition LegRight = partdefinition.addOrReplaceChild("LegRight", CubeListBuilder.create().texOffs(44, 33).mirror().addBox(-2.0F, 0.0F, -3.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 11.5F, 8.5F, -0.5236F, 0.1745F, 0.0F));

		PartDefinition part24 = LegRight.addOrReplaceChild("part24", CubeListBuilder.create().texOffs(44, 108).mirror().addBox(-4.0F, 0.0F, 0.0F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.9F, -0.1F, -3.1F));

		PartDefinition Leg2Right = LegRight.addOrReplaceChild("Leg2Right", CubeListBuilder.create().texOffs(44, 47).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.4F, 7.5F, 3.0F));

		PartDefinition FootRight = Leg2Right.addOrReplaceChild("FootRight", CubeListBuilder.create().texOffs(42, 57).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -1.5F, 0.5236F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 160, 150);
	}

	@Override
	public void setupAnim(ScelidosaurusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LegLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LegRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
