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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.YangchuanosaurusSkeleton;

public class YangchuanosaurusSkeletonStargazingModel extends EntityModel<YangchuanosaurusSkeleton> {
	private final ModelPart bone17;

	public YangchuanosaurusSkeletonStargazingModel(ModelPart root) {
		this.bone17 = root.getChild("bone17");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone17 = partdefinition.addOrReplaceChild("bone17", CubeListBuilder.create(), PartPose.offset(0.0F, 40.0F, 0.0F));

		PartDefinition body = bone17.addOrReplaceChild("body", CubeListBuilder.create().texOffs(89, 106).addBox(-6.5F, -7.5F, -8.5F, 13.0F, 12.0F, 23.0F, new CubeDeformation(0.0F))
		.texOffs(24, -24).addBox(0.0F, -6.5F, -8.5F, 0.0F, 9.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(76, 105).addBox(-6.5F, -2.5F, -7.5F, 13.0F, 0.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -37.5F, -3.5F, -0.5061F, 0.0F, 0.0F));

		PartDefinition pelvis_r1 = body.addOrReplaceChild("pelvis_r1", CubeListBuilder.create().texOffs(43, 113).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 18.0F, 23.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.5F, 1.5F, -8.5F, 0.0F, 0.0F, 0.3665F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(43, 113).addBox(0.0F, 0.0F, 0.0F, 0.0F, 18.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, 1.5F, -8.5F, 0.0F, 0.0F, -0.3665F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(89, 56).addBox(-7.0F, -1.0F, -25.0F, 14.0F, 20.0F, 26.0F, new CubeDeformation(0.0F))
		.texOffs(73, 2).addBox(-7.5F, -4.0F, -25.0F, 15.0F, 20.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(20, -17).addBox(0.0F, -5.0F, -26.0F, 0.0F, 8.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -8.5F, 0.0698F, 0.0F, 0.0F));

		PartDefinition left_arm = torso.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(14, 68).addBox(-3.0F, 0.0F, -3.0F, 4.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 10.0F, -18.0F, 0.4363F, 0.1745F, 0.0F));

		PartDefinition right_arm = torso.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(14, 68).mirror().addBox(-1.0F, 0.0F, -3.0F, 4.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, 10.0F, -18.0F, 0.4363F, -0.1745F, 0.0F));

		PartDefinition neck = torso.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(142, 0).addBox(-3.5F, -8.0F, -7.0F, 7.0F, 13.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(154, 13).addBox(0.0F, -9.0F, -7.0F, 0.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -25.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition skull = neck.addOrReplaceChild("skull", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.0F, -6.0F, -0.4712F, 0.0F, 0.0F));

		PartDefinition bone19 = skull.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(55, 77).addBox(-4.0F, -9.01F, -7.0F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(15, 27).addBox(-2.5F, -9.01F, -19.0F, 5.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(81, 67).addBox(-2.5F, -1.01F, -19.0F, 5.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition cube_r2 = bone19.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(86, 36).mirror().addBox(-0.5F, -1.0F, -10.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -9.01F, -7.0F, 0.0F, 0.0F, -0.2094F));

		PartDefinition cube_r3 = bone19.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(86, 36).addBox(-1.5F, -1.0F, -10.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -9.01F, -7.0F, 0.0F, 0.0F, 0.2094F));

		PartDefinition jaw = skull.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(66, 34).addBox(-3.0F, 0.0F, -6.99F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(134, 38).addBox(-2.0F, -1.0F, -18.99F, 4.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0349F, 0.0F, 0.0F));

		PartDefinition tail_base = body.addOrReplaceChild("tail_base", CubeListBuilder.create().texOffs(1, 58).addBox(-5.0F, 2.0F, 1.0F, 10.0F, 0.0F, 34.0F, new CubeDeformation(0.0F))
		.texOffs(1, 58).addBox(0.0F, -3.0F, -1.0F, 0.0F, 16.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 15.5F, 0.3054F, 0.1745F, 0.0F));

		PartDefinition tail_tip = tail_base.addOrReplaceChild("tail_tip", CubeListBuilder.create().texOffs(20, 20).addBox(-3.0F, 0.0F, 1.0F, 6.0F, 0.0F, 29.0F, new CubeDeformation(0.0F))
		.texOffs(1, 1).addBox(0.0F, -3.0F, 0.0F, 0.0F, 9.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 33.0F, 0.1571F, 0.2182F, 0.0F));

		PartDefinition right_leg = bone17.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(1, 108).mirror().addBox(-4.0F, 0.0F, -5.0F, 9.0F, 22.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.0F, -38.0F, -3.0F, -0.7854F, 0.1745F, 0.0F));

		PartDefinition bone9 = right_leg.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-3.0F, 0.0F, -1.5F, 6.0F, 21.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 17.0F, 6.5F, -0.6109F, 0.0F, 0.0F));

		PartDefinition bone10 = bone9.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(110, 35).mirror().addBox(-3.5F, 0.0F, -10.5F, 7.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 16.1318F, -0.924F, 1.4399F, 0.0F, 0.0F));

		PartDefinition left_leg = bone17.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(1, 108).addBox(-5.0F, 0.0F, -5.0F, 9.0F, 22.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -38.0F, -3.0F, -0.7854F, -0.1745F, 0.0F));

		PartDefinition bone6 = left_leg.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 0.0F, -1.5F, 6.0F, 21.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 17.0F, 6.5F, -0.6109F, 0.0F, 0.0F));

		PartDefinition bone5 = bone6.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(110, 35).addBox(-3.5F, 0.0F, -10.5F, 7.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.1318F, -0.924F, 1.4399F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 170, 154);
	}

	@Override
	public void setupAnim(YangchuanosaurusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

}
