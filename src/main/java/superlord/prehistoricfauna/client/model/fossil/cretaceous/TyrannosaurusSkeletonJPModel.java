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

public class TyrannosaurusSkeletonJPModel extends EntityModel<TyrannosaurusSkeleton> {
	private final ModelPart Body1;

	public TyrannosaurusSkeletonJPModel(ModelPart root) {
		this.Body1 = root.getChild("Body1");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body1 = partdefinition.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -7.0F, -16.0F, 15.0F, 33.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -29.0F, 0.0F, -0.391F, -0.0063F, 0.0F));

		PartDefinition Tail1 = Body1.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(8, 69).addBox(-4.0F, 0.0F, 0.0F, 9.0F, 0.0F, 58.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 17.0F, -0.241F, -0.3519F, 0.0F));

		PartDefinition TailVert = Tail1.addOrReplaceChild("TailVert", CubeListBuilder.create().texOffs(0, 189).addBox(0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(92, 63).addBox(-3.5F, 2.0F, -5.0F, 6.0F, 0.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 50.0F, -0.0782F, -0.5864F, 0.0F));

		PartDefinition Tail2Vert = Tail2.addOrReplaceChild("Tail2Vert", CubeListBuilder.create().texOffs(130, 193).addBox(0.0F, 0.0F, 0.0F, 0.0F, 10.0F, 53.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.9F, -7.0F));

		PartDefinition Body2 = Body1.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(146, 0).addBox(-11.0F, -4.0F, -23.0F, 22.0F, 26.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -16.0F, 0.1173F, 0.2346F, 0.0F));

		PartDefinition RightArm = Body2.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(69, 0).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.1F, 19.0F, -13.0F, 0.2731F, 0.0F, 0.0F));

		PartDefinition Neck = Body2.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(167, 66).addBox(-5.0F, -21.0F, -13.0F, 10.0F, 29.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, -22.0F, 0.2346F, 0.43F, 0.2346F));

		PartDefinition Head1 = Neck.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(0, 157).addBox(-7.0F, -4.0F, -11.0F, 14.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.0F, -7.0F, -0.1955F, 0.391F, 0.0F));

		PartDefinition Snout = Head1.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(57, 150).addBox(-3.5F, 0.0F, -16.0F, 7.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -11.0F));

		PartDefinition Jaw1 = Head1.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(0, 186).addBox(-7.0F, 0.0F, -11.0F, 14.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.4691F, 0.0F, 0.0F));

		PartDefinition Jaw2 = Jaw1.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(4, 211).addBox(-3.0F, 0.0F, -15.0F, 6.0F, 7.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -11.0F));

		PartDefinition Jaw3 = Jaw1.addOrReplaceChild("Jaw3", CubeListBuilder.create().texOffs(47, 181).addBox(-5.5F, -5.0F, 0.0F, 11.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -9.0F));

		PartDefinition NeckCenter = Neck.addOrReplaceChild("NeckCenter", CubeListBuilder.create().texOffs(214, 180).addBox(0.0F, 0.0F, -16.0F, 0.0F, 29.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.0F, 3.0F, -0.0017F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body2.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(69, 0).mirror().addBox(-1.0F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.1F, 19.0F, -13.0F, 0.2731F, 0.0F, 0.0F));

		PartDefinition ChestCenter = Body2.addOrReplaceChild("ChestCenter", CubeListBuilder.create().texOffs(73, 175).addBox(0.0F, 0.0F, 0.0F, 0.0F, 28.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -23.0F, -0.0017F, 0.0F, 0.0F));

		PartDefinition LeftLeg1 = Body1.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(152, 126).addBox(-7.0F, -6.0F, -9.0F, 10.0F, 30.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 3.0F, 3.0F, -0.1173F, 0.391F, 0.1173F));

		PartDefinition LeftLeg2 = LeftLeg1.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(96, 72).mirror().addBox(-3.0F, -6.0F, -1.0F, 6.0F, 30.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 26.0F, 5.0F, -0.0391F, 0.1955F, 0.0782F));

		PartDefinition LeftFeet = LeftLeg2.addOrReplaceChild("LeftFeet", CubeListBuilder.create().texOffs(98, 50).addBox(-4.0F, -1.0F, -13.0F, 8.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 22.0F, 5.0F, 0.5864F, 0.0F, 0.0F));

		PartDefinition RightLeg1 = Body1.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(152, 126).mirror().addBox(-3.0F, -6.0F, -9.0F, 10.0F, 30.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 3.0F, 3.0F, 0.43F, 0.0F, -0.3128F));

		PartDefinition RightLeg2 = RightLeg1.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(212, 142).addBox(-3.0F, -8.0F, -1.0F, 6.0F, 30.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 26.0F, 5.0F, -0.1955F, 0.2737F, 0.1564F));

		PartDefinition RightFeet = RightLeg2.addOrReplaceChild("RightFeet", CubeListBuilder.create().texOffs(98, 50).addBox(-4.0F, -1.0F, -13.0F, 8.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, 5.0F, 0.1564F, -0.3519F, 0.1175F));

		PartDefinition HipCenter = Body1.addOrReplaceChild("HipCenter", CubeListBuilder.create().texOffs(139, 180).addBox(0.0F, 0.0F, 0.0F, 0.0F, 33.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, -16.0F, -0.0017F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(TyrannosaurusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
