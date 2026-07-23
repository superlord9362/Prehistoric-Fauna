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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.KayentavenatorSkeleton;

public class KayentavenatorSkeletonAttackingModel extends EntityModel<KayentavenatorSkeleton> {
	private final ModelPart Root;

	public KayentavenatorSkeletonAttackingModel(ModelPart root) {
		this.Root = root.getChild("Root");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 6.5F, 0.5F, -0.6109F, 0.0F, 0.0F));

		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(38, 40).addBox(-2.0F, -2.5F, -2.5F, 4.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.6623F, -0.0862F, -0.0695F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(44, 60).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.5F, 3.5F, 0.1309F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(55, 53).addBox(-2.5F, 0.0F, -6.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(38, 40).mirror().addBox(-2.0F, -2.5F, -2.5F, 4.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.0F, -1.0472F, 0.1396F, 0.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(44, 60).mirror().addBox(-1.5F, 0.0F, 0.0F, 3.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 7.5F, 3.5F, 0.3054F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(55, 53).mirror().addBox(-1.5F, 0.0F, -6.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -15.0F, 6.0F, 9.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(34, -22).addBox(0.0F, -3.0F, -15.0F, 0.0F, 4.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(35, 6).addBox(-3.5F, -1.0F, -15.0F, 7.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(80, 0).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -0.5F, -0.1658F, 0.0358F, -0.0502F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(58, 74).addBox(0.0F, 0.0F, -4.5F, 0.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.0F, 0.5F, 0.0F, 0.0F, 0.3002F));

		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(58, 74).mirror().addBox(0.0F, 0.0F, -4.5F, 0.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 1.0F, 0.5F, 0.0F, 0.0F, -0.3002F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(23, 39).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 5.0F, -10.5F, 0.1385F, -0.4058F, -1.0246F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(23, 39).mirror().addBox(-1.0F, -1.0F, -1.5F, 2.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 5.0F, -10.5F, -0.2122F, 0.4623F, 0.7745F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(68, 10).addBox(0.0F, -1.9664F, -2.1305F, 0.0F, 7.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(49, 60).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 7.0F, 0.307F, -0.1641F, 0.0854F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(31, 2).addBox(0.0F, -1.95F, 0.0F, 0.0F, 5.0F, 31.0F, new CubeDeformation(0.0F))
		.texOffs(70, 60).addBox(-1.0F, -0.75F, 0.0F, 2.0F, 0.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0086F, 11.8695F, 0.279F, -0.3592F, -0.0101F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(4, 34).addBox(0.0F, -7.0F, -4.0F, 0.0F, 13.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.5F, -6.0F, -3.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -15.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(1, 63).addBox(-1.5F, -0.9882F, -10.0019F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(20, 72).addBox(-1.5F, 2.0118F, -10.0019F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.001F))
		.texOffs(2, 54).addBox(-2.0F, -0.9882F, -3.0019F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -4.0F, 0.8465F, 0.0F, 0.0F));

		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(19, 56).addBox(-2.0F, 2.649F, -3.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -5.1372F, -6.7519F, 0.0436F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(27, 82).addBox(-1.0F, -1.001F, -8.7509F, 2.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(1, 85).addBox(-2.0F, -0.001F, -1.7509F, 4.0F, 2.0F, 3.0F, new CubeDeformation(-0.001F))
		.texOffs(1, 75).addBox(-1.0F, -0.001F, -8.7509F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0128F, -1.2509F, 0.6981F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 104, 90);
	}

	@Override
	public void setupAnim(KayentavenatorSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}