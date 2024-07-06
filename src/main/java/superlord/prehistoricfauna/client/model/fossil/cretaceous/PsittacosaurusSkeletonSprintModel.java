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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.PsittacosaurusSkeleton;

public class PsittacosaurusSkeletonSprintModel extends EntityModel<PsittacosaurusSkeleton> {
	private final ModelPart Body;
	private final ModelPart rightthigh;
	private final ModelPart leftthigh;

	public PsittacosaurusSkeletonSprintModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.rightthigh = root.getChild("rightthigh");
		this.leftthigh = root.getChild("leftthigh");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(5, 2).addBox(-3.0F, 0.0F, -8.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.5F, 1.0F, -0.3491F, 0.0F, -0.1396F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(4, 22).addBox(0.0F, -1.0F, 0.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.2793F, -0.384F, 0.0F));

		PartDefinition Tail_1 = Tail.addOrReplaceChild("Tail_1", CubeListBuilder.create().texOffs(0, 22).addBox(-2.5F, 0.0F, 0.0F, 4.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tail_End = Tail.addOrReplaceChild("Tail_End", CubeListBuilder.create().texOffs(27, 21).addBox(0.0F, -1.0F, 0.0F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, 0.1745F, -0.384F, 0.0F));

		PartDefinition Tail_End_1 = Tail_End.addOrReplaceChild("Tail_End_1", CubeListBuilder.create().texOffs(25, 21).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -4.0F, -3.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.8727F, -0.384F, -0.0524F));

		PartDefinition beak = Head.addOrReplaceChild("beak", CubeListBuilder.create().texOffs(25, 0).addBox(-2.5F, -1.0F, -6.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -1.0F, -0.2443F, 0.0F, 0.1745F));

		PartDefinition beak_1 = beak.addOrReplaceChild("beak_1", CubeListBuilder.create().texOffs(47, 0).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -6.0F));

		PartDefinition jugalhorns = beak.addOrReplaceChild("jugalhorns", CubeListBuilder.create().texOffs(39, 18).addBox(-3.5F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -4.0F));

		PartDefinition leftarm = Body.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(30, 40).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 4.5F, -6.0F, 0.6283F, -0.4887F, 0.0F));

		PartDefinition rightarm = Body.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(39, 40).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 4.5F, -6.0F, 0.8727F, 0.3491F, 0.0F));

		PartDefinition Body_1 = Body.addOrReplaceChild("Body_1", CubeListBuilder.create().texOffs(33, 40).addBox(0.0F, -1.1F, -3.0F, 0.0F, 6.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.0F));

		PartDefinition Body_2 = Body.addOrReplaceChild("Body_2", CubeListBuilder.create().texOffs(16, 16).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

		PartDefinition Body_3 = Body.addOrReplaceChild("Body_3", CubeListBuilder.create().texOffs(18, 51).addBox(-3.5F, 0.0F, -4.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -4.1F));

		PartDefinition rightthigh = partdefinition.addOrReplaceChild("rightthigh", CubeListBuilder.create().texOffs(15, 37).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 15.0F, 2.0F, -0.9076F, -0.3491F, -0.1745F));

		PartDefinition rightleg = rightthigh.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(10, 53).mirror().addBox(-0.5F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 6.0F, 2.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition rightleg_1 = rightleg.addOrReplaceChild("rightleg_1", CubeListBuilder.create().texOffs(7, 58).mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 4.0F, 0.0F, 2.4086F, 0.0F, 0.0F));

		PartDefinition leftthigh = partdefinition.addOrReplaceChild("leftthigh", CubeListBuilder.create().texOffs(0, 37).mirror().addBox(-2.0F, -1.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 15.4F, 1.5F, 0.384F, 0.1745F, 0.0F));

		PartDefinition leftleg = leftthigh.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(3, 53).addBox(-1.5F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 6.0F, 2.0F));

		PartDefinition leftleg_1 = leftleg.addOrReplaceChild("leftleg_1", CubeListBuilder.create().texOffs(0, 58).mirror().addBox(-1.5F, 0.0F, -3.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 4.0F, 0.0F, -0.384F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 59, 61);
	}

	@Override
	public void setupAnim(PsittacosaurusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightthigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftthigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}