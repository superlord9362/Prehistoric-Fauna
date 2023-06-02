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
import superlord.prehistoricfauna.common.entity.fossil.triassic.SaurosuchusSkeleton;

public class SaurosuchusSkeletonSleepingModel extends EntityModel<SaurosuchusSkeleton> {
	private final ModelPart Body;

	public SaurosuchusSkeletonSleepingModel(ModelPart root) {
		this.Body = root.getChild("Body");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(11, 11).addBox(-6.0F, -7.0F, -21.0F, 12.0F, 12.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 6.0F));

		PartDefinition Body_1 = Body.addOrReplaceChild("Body_1", CubeListBuilder.create().texOffs(126, 26).addBox(0.0F, -7.0F, -21.0F, 0.0F, 13.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(101, 23).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 14.0F, -0.1745F, -0.6109F, 0.0F));

		PartDefinition osteos3 = Tail.addOrReplaceChild("osteos3", CubeListBuilder.create().texOffs(114, 93).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.1F, 0.0F));

		PartDefinition Tail2 = Tail.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, 0.0F, 1.0F, 4.0F, 0.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 20.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition Tail2_1 = Tail2.addOrReplaceChild("Tail2_1", CubeListBuilder.create().texOffs(2, 47).addBox(0.0F, -2.0F, -1.0F, 0.0F, 6.0F, 41.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition Tail_1 = Tail.addOrReplaceChild("Tail_1", CubeListBuilder.create().texOffs(109, 23).addBox(0.0F, -2.0F, 0.0F, 0.0F, 7.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Hips = Body.addOrReplaceChild("Hips", CubeListBuilder.create().texOffs(161, 77).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 8.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 1.0F));

		PartDefinition Arm = Body.addOrReplaceChild("Arm", CubeListBuilder.create().texOffs(-1, 0).mirror().addBox(-1.0F, 0.0F, -2.0F, 4.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 1.0F, -17.0F, -1.4926F, 0.0F, 0.0F));

		PartDefinition Thigh = Body.addOrReplaceChild("Thigh", CubeListBuilder.create().texOffs(62, 3).mirror().addBox(-3.0F, -2.0F, -2.0F, 5.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -1.0F, 6.0F, 1.4535F, -0.6981F, 0.0F));

		PartDefinition Calf = Thigh.addOrReplaceChild("Calf", CubeListBuilder.create().texOffs(20, 2).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 10.0F, 2.0F));

		PartDefinition Foot = Calf.addOrReplaceChild("Foot", CubeListBuilder.create().texOffs(99, 21).addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(97, -1).addBox(-3.0F, -1.0F, -8.0F, 6.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -21.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Neck_1 = Neck.addOrReplaceChild("Neck_1", CubeListBuilder.create().texOffs(180, 42).addBox(0.0F, -2.0F, -9.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Osteos2 = Neck.addOrReplaceChild("Osteos2", CubeListBuilder.create().texOffs(129, 104).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.1F, -7.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(133, 0).addBox(-3.5F, -1.5F, -8.0F, 7.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -8.0F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(163, 0).addBox(-2.0F, -3.0F, -8.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.5F, -8.0F));

		PartDefinition SnoutTeeth = Snout.addOrReplaceChild("SnoutTeeth", CubeListBuilder.create().texOffs(180, 6).addBox(-2.0F, -1.0F, -8.0F, 4.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(75, 12).addBox(-3.5F, 0.0F, -8.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.5F, 0.0F));

		PartDefinition JawSnout = Jaw.addOrReplaceChild("JawSnout", CubeListBuilder.create().texOffs(125, 13).addBox(-1.5F, -1.0F, -7.0F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -9.0F));

		PartDefinition JawTeeth = JawSnout.addOrReplaceChild("JawTeeth", CubeListBuilder.create().texOffs(142, 13).addBox(-1.0F, -1.0F, -7.0F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -1.0F, 0.01F));

		PartDefinition Arm_1 = Body.addOrReplaceChild("Arm_1", CubeListBuilder.create().texOffs(-1, 0).addBox(-3.0F, 0.0F, -2.0F, 4.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 1.0F, -17.0F, -1.4926F, -0.0394F, 0.0F));

		PartDefinition Thigh_1 = Body.addOrReplaceChild("Thigh_1", CubeListBuilder.create().texOffs(62, 3).addBox(-2.0F, -2.0F, -2.0F, 5.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.0F, 6.0F, 1.4535F, 0.6981F, 0.0F));

		PartDefinition Calf_1 = Thigh_1.addOrReplaceChild("Calf_1", CubeListBuilder.create().texOffs(20, 2).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 10.0F, 2.0F));

		PartDefinition Foot_1 = Calf_1.addOrReplaceChild("Foot_1", CubeListBuilder.create().texOffs(99, 21).mirror().addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition Osteos = Body.addOrReplaceChild("Osteos", CubeListBuilder.create().texOffs(95, 83).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, -18.5F));

		return LayerDefinition.create(meshdefinition, 200, 200);
	}

	@Override
	public void setupAnim(SaurosuchusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
