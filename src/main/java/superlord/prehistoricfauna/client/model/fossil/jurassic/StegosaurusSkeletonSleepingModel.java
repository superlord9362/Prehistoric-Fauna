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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.StegosaurusSkeleton;

public class StegosaurusSkeletonSleepingModel extends EntityModel<StegosaurusSkeleton> {
	private final ModelPart Body;

	public StegosaurusSkeletonSleepingModel(ModelPart root) {
		this.Body = root.getChild("Body");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, 4.0F, 0.0F, 24.0F, 22.0F, 45.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, 8.0F, -21.0F, 0.0F, 0.0F, 1.4144F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(28, 73).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 0.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 45.0F, -0.1564F, 0.2346F, -0.3519F));

		PartDefinition LeftTail1Plates = Tail1.addOrReplaceChild("LeftTail1Plates", CubeListBuilder.create().texOffs(138, 28).addBox(0.0F, 0.0F, 0.0F, 0.0F, 20.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -20.0F, 10.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(95, 7).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 34.0F, 0.0782F, -0.1955F, -0.4691F));

		PartDefinition RightThagomizers = Tail2.addOrReplaceChild("RightThagomizers", CubeListBuilder.create().texOffs(41, 119).addBox(0.0F, 0.0F, 0.0F, 21.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 19.0F, 0.0F, 0.0F, -0.754F));

		PartDefinition RightTail2Plates = Tail2.addOrReplaceChild("RightTail2Plates", CubeListBuilder.create().texOffs(166, 14).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 13.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -13.0F, 0.0F));

		PartDefinition LeftThagomizers = Tail2.addOrReplaceChild("LeftThagomizers", CubeListBuilder.create().texOffs(41, 119).addBox(-21.0F, 0.0F, 0.0F, 21.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 19.0F, 0.0F, 0.0F, 0.754F));

		PartDefinition LeftTail2Plates = Tail2.addOrReplaceChild("LeftTail2Plates", CubeListBuilder.create().texOffs(166, 10).addBox(0.0F, 0.0F, 0.0F, 0.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -10.0F, 5.0F));

		PartDefinition Tail2_1 = Tail2.addOrReplaceChild("Tail2_1", CubeListBuilder.create().texOffs(101, 7).addBox(0.0F, -1.0F, 0.0F, 0.0F, 5.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightTail1Plates = Tail1.addOrReplaceChild("RightTail1Plates", CubeListBuilder.create().texOffs(120, 39).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 19.0F, 33.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -19.0F, -3.0F));

		PartDefinition Tail1_1 = Tail1.addOrReplaceChild("Tail1_1", CubeListBuilder.create().texOffs(188, 52).addBox(0.0F, -5.0F, 0.0F, 0.0F, 10.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition Body_1 = Body.addOrReplaceChild("Body_1", CubeListBuilder.create().texOffs(166, -45).addBox(0.0F, 0.0F, 0.0F, 0.0F, 20.0F, 45.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -4.0F, -4.0F, 7.0F, 27.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 19.0F, 7.0F, 0.0F, 0.0F, -0.5082F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -4.0F, 7.0F, 27.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 19.0F, 7.0F, 0.0F, 0.0F, 0.1564F));

		PartDefinition RightBackPlates = Body.addOrReplaceChild("RightBackPlates", CubeListBuilder.create().texOffs(106, 77).mirror().addBox(0.0F, 0.0F, 0.0F, 0.0F, 22.0F, 42.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -18.0F, 0.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 71).mirror().addBox(-2.0F, -3.0F, -2.0F, 9.0F, 21.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, 10.0F, 32.0F, -0.1173F, 0.0F, -0.391F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 107).mirror().addBox(-3.0F, -1.0F, -4.0F, 6.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 17.0F, 6.0F, 0.5473F, 0.0F, -0.3519F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(0, 130).addBox(-3.5F, 0.0F, -6.0F, 7.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 12.0F, 0.1F));

		PartDefinition LeftBackPlates = Body.addOrReplaceChild("LeftBackPlates", CubeListBuilder.create().texOffs(157, 50).addBox(0.0F, 0.0F, 0.0F, 0.0F, 22.0F, 46.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -18.0F, 3.0F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 71).addBox(-7.0F, -3.0F, -2.0F, 9.0F, 21.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 10.0F, 32.0F, -0.2737F, 0.0F, 0.1564F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 107).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 17.0F, 6.0F, 0.4691F, 0.0F, -0.0782F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(0, 130).mirror().addBox(-3.5F, 0.0F, -6.0F, 7.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 12.0F, 0.1F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(87, 77).addBox(-3.5F, 0.0F, -19.0F, 7.0F, 10.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0391F, -0.3519F, -0.2346F));

		PartDefinition Neck_1 = Neck.addOrReplaceChild("Neck_1", CubeListBuilder.create().texOffs(218, 5).addBox(0.0F, -5.0F, -19.0F, 0.0F, 5.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition LeftNeckPlates = Neck.addOrReplaceChild("LeftNeckPlates", CubeListBuilder.create().texOffs(70, 113).addBox(-2.0F, 0.0F, 0.0F, 0.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -10.0F, -18.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(93, 0).addBox(-3.5F, -1.5F, -9.0F, 7.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -19.0F, 0.0F, 0.2737F, -0.3128F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(97, 16).addBox(-2.0F, -3.0F, -6.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -9.0F));

		PartDefinition RightNeckPlates = Neck.addOrReplaceChild("RightNeckPlates", CubeListBuilder.create().texOffs(70, 101).mirror().addBox(2.0F, -10.0F, -18.0F, 0.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 0.0F, -3.0F));

		return LayerDefinition.create(meshdefinition, 256, 148);
	}

	@Override
	public void setupAnim(StegosaurusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
