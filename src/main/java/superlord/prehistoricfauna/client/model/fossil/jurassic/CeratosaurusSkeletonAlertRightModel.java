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
import superlord.prehistoricfauna.common.entity.fossil.jurassic.CeratosaurusSkeleton;

public class CeratosaurusSkeletonAlertRightModel extends EntityModel<CeratosaurusSkeleton> {
	private final ModelPart Body1;

	public CeratosaurusSkeletonAlertRightModel(ModelPart root) {
		this.Body1 = root.getChild("Body1");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body1 = partdefinition.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(155, 56).addBox(-6.0F, -5.0F, -30.0F, 12.0F, 12.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, -0.2737F, 0.0F, 0.0F));

		PartDefinition RightArm = Body1.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(73, 51).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 6.0F, -26.0F, 0.5864F, 0.0F, 0.0F));

		PartDefinition LeftLeg1 = Body1.addOrReplaceChild("LeftLeg1", CubeListBuilder.create().texOffs(76, 153).mirror().addBox(-6.0F, -4.0F, -6.0F, 6.0F, 17.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -1.0F, -5.0F, 0.2737F, 0.0F, 0.0F));

		PartDefinition LeftLeg2 = LeftLeg1.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(93, 192).mirror().addBox(-1.5F, -3.0F, -3.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, 12.0F, 5.0F));

		PartDefinition LeftFoot = LeftLeg2.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(80, 222).addBox(-2.0F, 0.0F, -7.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition RightLeg1 = Body1.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(128, 153).mirror().addBox(0.0F, -4.0F, -6.0F, 6.0F, 17.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -1.0F, -5.0F, 0.2737F, 0.0F, 0.0F));

		PartDefinition RightLeg2 = RightLeg1.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(126, 192).mirror().addBox(-2.5F, -3.0F, -3.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 12.0F, 5.0F));

		PartDefinition RightFoot = RightLeg2.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(126, 222).addBox(-3.0F, 0.0F, -7.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition TailVetebrae = Body1.addOrReplaceChild("TailVetebrae", CubeListBuilder.create().texOffs(169, 124).addBox(0.0F, -4.0F, 0.0F, 0.0F, 13.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 4.0F, 0.1564F, 0.0F, 0.0F));

		PartDefinition Tail1 = TailVetebrae.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(111, 43).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TailOsteoderms = TailVetebrae.addOrReplaceChild("TailOsteoderms", CubeListBuilder.create().texOffs(0, 16).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.1F, 0.0F));

		PartDefinition TailVertebrae2 = TailVetebrae.addOrReplaceChild("TailVertebrae2", CubeListBuilder.create().texOffs(177, 126).addBox(0.0F, -2.0F, 0.0F, 0.0F, 7.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 22.0F, 0.1173F, 0.0F, 0.0F));

		PartDefinition Tail2 = TailVertebrae2.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(92, 90).addBox(-3.5F, 0.0F, 0.0F, 6.0F, 0.0F, 35.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition Neck = Body1.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(4, 55).addBox(-3.0F, -13.0F, -4.0F, 6.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -30.0F, 0.1564F, 0.391F, 0.0F));

		PartDefinition Head1 = Neck.addOrReplaceChild("Head1", CubeListBuilder.create().texOffs(0, 94).addBox(-4.0F, -1.5F, -8.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, -4.0F, 0.0F, 0.6255F, 0.0F));

		PartDefinition Snout = Head1.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(37, 94).addBox(-2.5F, -1.0F, -9.0F, 5.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -8.0F));

		PartDefinition UpperTeeth = Snout.addOrReplaceChild("UpperTeeth", CubeListBuilder.create().texOffs(5, 152).addBox(-2.5F, 0.0F, -8.0F, 5.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -1.01F));

		PartDefinition CrestRight = Snout.addOrReplaceChild("CrestRight", CubeListBuilder.create().texOffs(16, 140).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -2.0F, 1.0F));

		PartDefinition SnoutHorn = Snout.addOrReplaceChild("SnoutHorn", CubeListBuilder.create().texOffs(0, 81).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -6.0F));

		PartDefinition CrestLeft = Snout.addOrReplaceChild("CrestLeft", CubeListBuilder.create().texOffs(0, 140).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -2.0F, 1.0F));

		PartDefinition Jaw1 = Head1.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(0, 119).addBox(-4.0F, 0.0F, -8.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.5F, 0.0F));

		PartDefinition Jaw2 = Jaw1.addOrReplaceChild("Jaw2", CubeListBuilder.create().texOffs(37, 119).addBox(-2.0F, -1.0F, -9.0F, 4.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -8.0F));

		PartDefinition LowerTeeth = Jaw2.addOrReplaceChild("LowerTeeth", CubeListBuilder.create().texOffs(47, 150).addBox(-2.0F, -1.0F, -8.0F, 4.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -0.99F));

		PartDefinition LeftArm = Body1.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(51, 51).mirror().addBox(-3.0F, -2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 6.0F, -26.0F, 0.5864F, 0.0F, 0.0F));

		PartDefinition BodyVertebrae = Body1.addOrReplaceChild("BodyVertebrae", CubeListBuilder.create().texOffs(171, 72).addBox(0.0F, -7.0F, -30.0F, 0.0F, 18.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BodyOsteoderms = BodyVertebrae.addOrReplaceChild("BodyOsteoderms", CubeListBuilder.create().texOffs(44, 4).mirror().addBox(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 30.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -6.1F, -26.0F));

		PartDefinition BodyRibcage = BodyVertebrae.addOrReplaceChild("BodyRibcage", CubeListBuilder.create().texOffs(155, 1).addBox(-5.5F, -6.0F, -30.0F, 11.0F, 15.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 250, 250);
	}

	@Override
	public void setupAnim(CeratosaurusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
