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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.TyrannosaurusSkeleton;

public class TyrannosaurusSkeletonStompingModel extends EntityModel<TyrannosaurusSkeleton> {
	private final ModelPart Sacrum;

	public TyrannosaurusSkeletonStompingModel(ModelPart root) {
		this.Sacrum = root.getChild("Sacrum");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Sacrum = partdefinition.addOrReplaceChild("Sacrum", CubeListBuilder.create().texOffs(-33, 0).addBox(-7.5F, -7.0F, -16.0F, 15.0F, 0.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -26.0F, 0.0F, -0.4538F, 0.0F, 0.0F));

		PartDefinition LeftLeg1 = Sacrum.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(152, 126).addBox(-7.0F, -7.0F, -9.0F, 10.0F, 30.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 6.0F, 3.0F, 0.733F, 0.1745F, 0.3142F));

		PartDefinition LeftLeg2 = LeftLeg1.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(212, 142).addBox(-3.5F, -8.5F, -0.75F, 7.0F, 30.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 23.5F, 4.0F, 0.1047F, 0.0F, 0.0F));

		PartDefinition LeftFeet = LeftLeg2.addOrReplaceChild("LeftFeet", CubeListBuilder.create().texOffs(101, 53).addBox(-4.0F, -1.0F, -13.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 22.0F, 2.0F, -0.3142F, 0.0F, -0.1745F));

		PartDefinition Body2 = Sacrum.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(146, 0).addBox(-11.0F, -4.0F, -23.0F, 22.0F, 26.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -16.0F, 0.0698F, 0.0F, 0.0F));

		PartDefinition RightArm = Body2.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(69, 0).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.5F, 20.0F, -15.0F, 0.9425F, -0.1745F, 0.5236F));

		PartDefinition Neck = Body2.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(9, 87).addBox(-5.0F, -14.0F, -12.0F, 10.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -23.01F, 0.4887F, -0.384F, 0.0349F));

		PartDefinition Head1 = Neck.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(0, 157).addBox(-7.0F, -4.0F, -11.0F, 14.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, -10.0F, 0.3142F, -0.2618F, 0.0349F));

		PartDefinition Jaw1 = Head1.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(0, 186).addBox(-7.0F, 0.0F, -11.0F, 14.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.01F, 0.0F, 0.5585F, 0.0F, 0.0F));

		PartDefinition Jaw2 = Jaw1.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(4, 211).addBox(-3.0F, 0.0F, -15.0F, 6.0F, 7.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -11.0F));

		PartDefinition Jaw3 = Jaw1.addOrReplaceChild("Jaw3", CubeListBuilder.create().texOffs(47, 181).addBox(-5.5F, -5.0F, 0.0F, 11.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -9.0F));

		PartDefinition Snout = Head1.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(57, 150).addBox(-3.5F, 0.0F, -16.0F, 7.0F, 9.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -11.0F));

		PartDefinition Snout_1 = Snout.addOrReplaceChild("Snout_1", CubeListBuilder.create().texOffs(57, 131).addBox(-3.5F, 0.0F, -16.0F, 7.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		PartDefinition NeckCenter = Neck.addOrReplaceChild("NeckCenter", CubeListBuilder.create().texOffs(216, 178).addBox(0.0F, -16.0F, -14.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0017F, 0.0F, 0.0F));

		PartDefinition ChestCenter = Body2.addOrReplaceChild("ChestCenter", CubeListBuilder.create().texOffs(73, 175).addBox(0.0F, 0.0F, 0.0F, 0.0F, 28.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -23.0F));

		PartDefinition LeftArm = Body2.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(69, 0).mirror().addBox(-1.0F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.5F, 20.0F, -15.0F, 0.9425F, 0.1745F, -0.5236F));

		PartDefinition PectoralGirdle = Body2.addOrReplaceChild("PectoralGirdle", CubeListBuilder.create().texOffs(62, 9).addBox(-12.0F, -3.0F, -17.0F, 24.0F, 25.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition SacralVertebrae = Sacrum.addOrReplaceChild("SacralVertebrae", CubeListBuilder.create().texOffs(139, 176).addBox(0.0F, 0.0F, 0.0F, 0.0F, 10.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -16.0F));

		PartDefinition PelvicPlaneL = SacralVertebrae.addOrReplaceChild("PelvicPlaneL", CubeListBuilder.create().texOffs(139, 187).addBox(0.0F, 0.0F, -14.0F, 0.0F, 25.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.4F, 9.0F, 14.0F, 0.0F, 0.0F, -0.3002F));

		PartDefinition PelvicPlaneR = SacralVertebrae.addOrReplaceChild("PelvicPlaneR", CubeListBuilder.create().texOffs(139, 187).mirror().addBox(0.0F, 0.0F, -14.0F, 0.0F, 25.0F, 33.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.4F, 9.0F, 14.0F, 0.0F, 0.0F, 0.3002F));

		PartDefinition Tail1 = Sacrum.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(17, 77).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.4F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 17.0F, 0.2094F, -0.2793F, 0.1047F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(92, 63).addBox(-2.5F, 0.0F, -1.0F, 6.0F, 0.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 46.0F, 0.1745F, -0.2793F, 0.1745F));

		PartDefinition Tail2Vert = Tail2.addOrReplaceChild("Tail2Vert", CubeListBuilder.create().texOffs(130, 192).addBox(0.0F, -2.0F, 0.0F, 0.0F, 11.0F, 53.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition TailVert = Tail1.addOrReplaceChild("TailVert", CubeListBuilder.create().texOffs(0, 189).addBox(0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition RightLeg1 = Sacrum.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(152, 126).mirror().addBox(-3.0F, -6.0F, -9.0F, 10.0F, 30.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 3.0F, 3.0F, -0.5236F, -0.1745F, -0.3491F));

		PartDefinition RightLeg2 = RightLeg1.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(212, 142).mirror().addBox(-3.5F, -8.0F, -1.0F, 7.0F, 30.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 24.0F, 4.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition RightFeet = RightLeg2.addOrReplaceChild("RightFeet", CubeListBuilder.create().texOffs(101, 53).addBox(-4.0F, -1.0F, -13.0F, 8.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 18.0F, 3.0F, 0.8727F, -0.1745F, 0.0F));

		PartDefinition Body1 = Sacrum.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(0, 33).addBox(-7.5F, -7.0F, -16.0F, 15.0F, 16.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(TyrannosaurusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Sacrum.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}