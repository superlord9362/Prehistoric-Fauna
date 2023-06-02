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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.AllosaurusSkeleton;

public class AllosaurusSkeletonRetroModel extends EntityModel<AllosaurusSkeleton> {
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg1;
	private final ModelPart Ilium;

	public AllosaurusSkeletonRetroModel(ModelPart root) {
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg1 = root.getChild("RightLeg1");
		this.Ilium = root.getChild("Ilium");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-8.0F, -3.0F, -6.0F, 8.0F, 22.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -11.3F, 3.0F, -0.6981F, 0.1745F, 0.0F));

		PartDefinition LeftLeg2 = LeftLeg.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-3.5F, 0.0F, -3.0F, 7.0F, 20.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 14.0F, 4.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLeg2.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(72, 0).addBox(-4.0F, 0.0F, -11.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 3.0F));

		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(96, 0).mirror().addBox(0.0F, -3.0F, -6.0F, 8.0F, 22.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, -11.3F, 3.0F, -0.6981F, -0.1745F, 0.0F));

		PartDefinition RightLeg2 = RightLeg1.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(140, 0).mirror().addBox(-3.5F, 0.0F, -3.0F, 7.0F, 20.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 14.0F, 4.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLeg2.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(168, 0).addBox(-4.0F, 0.0F, -11.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 3.0F));

		PartDefinition Ilium = partdefinition.addOrReplaceChild("Ilium", CubeListBuilder.create().texOffs(144, 14).addBox(-7.0F, -5.0F, -11.0F, 14.0F, 23.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.5F, 3.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition CaudalVertebrae1 = Ilium.addOrReplaceChild("CaudalVertebrae1", CubeListBuilder.create().texOffs(40, 14).addBox(0.0F, -4.0F, -3.0F, 0.0F, 13.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 13.0F, -0.2094F, 0.0698F, 0.0F));

		PartDefinition CaudalRibs1 = CaudalVertebrae1.addOrReplaceChild("CaudalRibs1", CubeListBuilder.create().texOffs(41, 14).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 0.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition CaudalVertebrae2 = CaudalVertebrae1.addOrReplaceChild("CaudalVertebrae2", CubeListBuilder.create().texOffs(79, 39).addBox(0.0F, -3.0F, 0.0F, 0.0F, 9.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.4F, 27.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition CaudalRibs2 = CaudalVertebrae2.addOrReplaceChild("CaudalRibs2", CubeListBuilder.create().texOffs(81, 38).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition Ribcage = Ilium.addOrReplaceChild("Ribcage", CubeListBuilder.create().texOffs(0, 59).addBox(-8.0F, -3.0F, -18.0F, 16.0F, 18.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -11.0F));

		PartDefinition RightArm = Ribcage.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(205, 0).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5F, 11.5F, -13.0F, 0.5236F, 0.2793F, 0.0F));

		PartDefinition CervicalRibs = Ribcage.addOrReplaceChild("CervicalRibs", CubeListBuilder.create().texOffs(210, 49).addBox(-3.5F, -8.8F, -15.0F, 7.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -18.0F, 0.733F, 0.0698F, 0.2793F));

		PartDefinition CervicalVertebrae = CervicalRibs.addOrReplaceChild("CervicalVertebrae", CubeListBuilder.create().texOffs(187, 78).addBox(0.0F, -12.0F, -9.0F, 0.0F, 13.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -2.0F));

		PartDefinition Head1 = CervicalRibs.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(198, 22).addBox(-4.5F, -2.0F, -7.0F, 9.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -11.0F, 0.0698F, 0.0F, -0.1396F));

		PartDefinition Jaw1 = Head1.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(37, 29).addBox(-4.0F, 0.0F, -7.0F, 8.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition Jaw2 = Jaw1.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(2, 37).addBox(-2.5F, -1.0F, -11.0F, 5.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -7.0F));

		PartDefinition LowerTeeth = Jaw2.addOrReplaceChild("LowerTeeth", CubeListBuilder.create().texOffs(52, 59).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -11.0F));

		PartDefinition Snout = Head1.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(84, 59).addBox(-3.0F, -2.0F, -9.0F, 6.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -7.0F));

		PartDefinition CrestLeft = Snout.addOrReplaceChild("CrestLeft", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -2.0F, 0.0F));

		PartDefinition Snout2 = Snout.addOrReplaceChild("Snout2", CubeListBuilder.create().texOffs(226, 0).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -9.0F));

		PartDefinition UpperTeeth = Snout.addOrReplaceChild("UpperTeeth", CubeListBuilder.create().texOffs(136, 63).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -12.0F));

		PartDefinition CrestRight = Snout.addOrReplaceChild("CrestRight", CubeListBuilder.create().texOffs(30, 0).addBox(0.0F, -2.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -2.0F, 0.0F));

		PartDefinition LeftArm = Ribcage.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(181, 61).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.5F, 11.5F, -13.0F, 0.5236F, -0.2793F, 0.0F));

		PartDefinition PelvicGirdle = Ribcage.addOrReplaceChild("PelvicGirdle", CubeListBuilder.create().texOffs(8, 101).addBox(-8.5F, -4.0F, -18.0F, 17.0F, 19.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ThoracicVertebrae = Ribcage.addOrReplaceChild("ThoracicVertebrae", CubeListBuilder.create().texOffs(107, 74).addBox(0.0F, -5.0F, -19.0F, 0.0F, 6.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Sacrum = Ilium.addOrReplaceChild("Sacrum", CubeListBuilder.create().texOffs(209, 14).addBox(-7.0F, 0.0F, -11.0F, 14.0F, 0.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition LowerPelvis = Sacrum.addOrReplaceChild("LowerPelvis", CubeListBuilder.create().texOffs(106, 81).addBox(0.0F, -5.0F, 0.0F, 0.0F, 23.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -9.0F));

		return LayerDefinition.create(meshdefinition, 250, 250);
	}

	@Override
	public void setupAnim(AllosaurusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ilium.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
