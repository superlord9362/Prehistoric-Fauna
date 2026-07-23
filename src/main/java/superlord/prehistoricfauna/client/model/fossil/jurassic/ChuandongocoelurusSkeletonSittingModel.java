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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.ChuandongocoelurusSkeleton;

public class ChuandongocoelurusSkeletonSittingModel extends EntityModel<ChuandongocoelurusSkeleton> {
	private final ModelPart Root;

	public ChuandongocoelurusSkeletonSittingModel(ModelPart root) {
		this.Root = root.getChild("Root");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Root = partdefinition.addOrReplaceChild("Root", CubeListBuilder.create(), PartPose.offset(0.0F, 12.5F, 0.5F));

		PartDefinition RightThigh = Root.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.5F, -1.5F, -0.6981F, -0.3491F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 4.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(-1, 31).addBox(-1.5F, 0.0F, -5.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition LeftThigh = Root.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(-2.0F, -1.0F, -2.0F, 3.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 2.5F, -1.5F, -0.6981F, 0.3491F, 0.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 27).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, 4.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(-1, 31).mirror().addBox(-1.5F, 0.0F, -5.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Body = Root.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(31, 0).addBox(-3.0F, -0.5F, -13.5F, 6.0F, 9.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(8, 43).addBox(-3.5F, 0.5F, -13.5F, 7.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(12, -17).addBox(0.0F, -1.5F, -13.5F, 0.0F, 4.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(38, 39).addBox(-2.0F, -2.5F, -4.5F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, -2).addBox(0.0F, 0.0F, -4.5F, 0.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.5F, 0.0F, 0.0F, 0.0F, 0.288F));

		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, -2).mirror().addBox(0.0F, 0.0F, -4.5F, 0.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 2.5F, 0.0F, 0.0F, 0.0F, -0.288F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(10, 24).addBox(-0.5F, -1.0F, -1.5F, 2.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 5.5F, -10.0F, 0.48F, 0.3491F, -0.5672F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(10, 24).mirror().addBox(-1.0F, -1.0F, -1.5F, 2.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, 5.5F, -10.0F, 0.48F, -0.3491F, 0.5672F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(0, 40).addBox(0.0F, -2.0F, 0.0F, 0.0F, 6.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(-16, 40).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 3.5F, -0.0873F, 0.2182F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(-2, 14).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 0.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, -0.1047F, 0.2618F, 0.0F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(41, 53).addBox(-1.5F, -7.0F, -4.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(55, 50).addBox(0.0F, -8.0F, -3.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, -13.5F, 0.0873F, 0.5672F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(63, 39).addBox(-2.0F, -1.5F, -4.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(61, 27).addBox(-1.0F, -3.5F, -11.0F, 2.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(63, 52).addBox(-1.0F, 1.5F, -10.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -6.6F, -3.0F, -0.1309F, 0.1309F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(63, 46).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(39, 25).addBox(-1.0F, 0.0F, -10.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(24, 29).addBox(-1.0F, -1.0F, -10.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.0F, 1.5F, 0.0F));

		return LayerDefinition.create(meshdefinition, 79, 62);
	}

	@Override
	public void setupAnim(ChuandongocoelurusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}