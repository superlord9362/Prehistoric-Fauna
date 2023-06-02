package superlord.prehistoricfauna.client.model.fossil.triassic;

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
import superlord.prehistoricfauna.common.entity.fossil.triassic.PostosuchusSkeleton;

public class PostosuchusSkeletonWalkingModel extends EntityModel<PostosuchusSkeleton> {
	private final ModelPart Thigh;
	private final ModelPart Thigh_1;
	private final ModelPart Body;

	public PostosuchusSkeletonWalkingModel(ModelPart root) {
		this.Thigh = root.getChild("Thigh");
		this.Thigh_1 = root.getChild("Thigh_1");
		this.Body = root.getChild("Body");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Thigh = partdefinition.addOrReplaceChild("Thigh", CubeListBuilder.create().texOffs(79, 1).addBox(-3.0F, -1.0F, -2.0F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 6.0F, 5.0F, 0.1047F, 0.2443F, 0.1396F));

		PartDefinition Calf = Thigh.addOrReplaceChild("Calf", CubeListBuilder.create().texOffs(82, 23).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 10.0F, -1.0F, 0.5585F, 0.0F, 0.0F));

		PartDefinition Foot = Calf.addOrReplaceChild("Foot", CubeListBuilder.create().texOffs(79, 39).mirror().addBox(-2.5F, 0.0F, -7.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 7.0F, 2.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition Thigh_1 = partdefinition.addOrReplaceChild("Thigh_1", CubeListBuilder.create().texOffs(79, 1).mirror().addBox(-2.0F, -1.0F, -2.0F, 5.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, 6.0F, 5.0F, -0.3491F, -0.1745F, 0.0F));

		PartDefinition Calf_1 = Thigh_1.addOrReplaceChild("Calf_1", CubeListBuilder.create().texOffs(82, 23).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 10.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Foot_1 = Calf_1.addOrReplaceChild("Foot_1", CubeListBuilder.create().texOffs(79, 39).addBox(-2.5F, 0.0F, -7.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 2.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.0F, -23.0F, 9.0F, 10.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 5.0F, -0.0349F, 0.0F, 0.0F));

		PartDefinition Arm_1 = Body.addOrReplaceChild("Arm_1", CubeListBuilder.create().texOffs(54, 46).mirror().addBox(-2.0F, 0.0F, -1.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 1.5F, -19.5F, 0.3491F, -0.1745F, 0.0F));

		PartDefinition Body_1 = Body.addOrReplaceChild("Body_1", CubeListBuilder.create().texOffs(136, 27).mirror().addBox(0.0F, -7.0F, -23.0F, 0.0F, 12.0F, 28.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(5, 0).addBox(0.0F, -2.5F, -8.0F, 0.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, -22.0F, 0.1396F, 0.1745F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(107, 3).addBox(-2.5F, -1.5F, -5.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.5F, 0.0698F, 0.1745F, 0.1396F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(160, 3).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.5F, 0.0F));

		PartDefinition JawSnout = Jaw.addOrReplaceChild("JawSnout", CubeListBuilder.create().texOffs(163, 11).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.99F));

		PartDefinition JawTeeth = JawSnout.addOrReplaceChild("JawTeeth", CubeListBuilder.create().texOffs(140, 3).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(127, 3).addBox(-1.5F, -4.0F, -7.0F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.5F, -5.0F));

		PartDefinition SnoutTeeth = Snout.addOrReplaceChild("SnoutTeeth", CubeListBuilder.create().texOffs(145, 3).addBox(-1.5F, -1.0F, -7.01F, 3.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.01F));

		PartDefinition Neck_1 = Neck.addOrReplaceChild("Neck_1", CubeListBuilder.create().texOffs(128, 33).addBox(-2.0F, 0.0F, -7.0F, 4.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(2, 46).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 5.0F, -0.1745F, 0.1745F, 0.0F));

		PartDefinition Tail_1 = Tail.addOrReplaceChild("Tail_1", CubeListBuilder.create().texOffs(8, 44).addBox(0.0F, -2.0F, 0.0F, 0.0F, 8.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tail2 = Tail.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 80).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 0.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 21.0F, 0.1047F, 0.1745F, 0.0F));

		PartDefinition Tail2_1 = Tail2.addOrReplaceChild("Tail2_1", CubeListBuilder.create().texOffs(6, 82).addBox(0.0F, -1.0F, 0.0F, 0.0F, 5.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body_2 = Body.addOrReplaceChild("Body_2", CubeListBuilder.create().texOffs(137, 78).addBox(-5.0F, -6.0F, -23.0F, 10.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm = Body.addOrReplaceChild("Arm", CubeListBuilder.create().texOffs(54, 46).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 1.5F, -19.5F, 0.3491F, 0.4887F, 0.0F));

		return LayerDefinition.create(meshdefinition, 200, 200);
	}

	@Override
	public void setupAnim(PostosuchusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Thigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Thigh_1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
