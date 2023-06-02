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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.PlesiohadrosSkeleton;

public class PlesiohadrosSkeletonDashRightModel extends EntityModel<PlesiohadrosSkeleton> {
	private final ModelPart Ribs;
	private final ModelPart ThighL;
	private final ModelPart ThighR;
	private final ModelPart LegFrontR;
	private final ModelPart LegFrontL;

	public PlesiohadrosSkeletonDashRightModel(ModelPart root) {
		this.Ribs = root.getChild("Ribs");
		this.ThighL = root.getChild("ThighL");
		this.ThighR = root.getChild("ThighR");
		this.LegFrontR = root.getChild("LegFrontR");
		this.LegFrontL = root.getChild("LegFrontL");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Ribs = partdefinition.addOrReplaceChild("Ribs", CubeListBuilder.create().texOffs(0, 50).addBox(-5.0F, -5.0F, -6.0F, 10.0F, 18.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.3F, -12.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition ThoracicVertebrae = Ribs.addOrReplaceChild("ThoracicVertebrae", CubeListBuilder.create().texOffs(106, 53).addBox(0.0F, 0.0F, 0.0F, 0.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -7.0F));

		PartDefinition PectoralGirdle = Ribs.addOrReplaceChild("PectoralGirdle", CubeListBuilder.create().texOffs(159, 19).addBox(-5.5F, -5.0F, -6.0F, 11.0F, 15.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition Pelvis = Ribs.addOrReplaceChild("Pelvis", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, -8.0F, 0.0F, 13.0F, 6.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 9.3F, -0.0873F, 0.1745F, 0.0F));

		PartDefinition CaudalVertebrae = Pelvis.addOrReplaceChild("CaudalVertebrae", CubeListBuilder.create().texOffs(62, 31).addBox(0.0F, -1.0F, 0.0F, 0.0F, 9.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 22.0F, 0.1955F, -0.4887F, 0.0F));

		PartDefinition CaudalRibs = CaudalVertebrae.addOrReplaceChild("CaudalRibs", CubeListBuilder.create().texOffs(56, 32).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition TailTip = CaudalVertebrae.addOrReplaceChild("TailTip", CubeListBuilder.create().texOffs(34, 70).addBox(0.0F, -2.0F, -4.0F, 0.0F, 6.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 20.0F, 0.0782F, -0.3491F, 0.0F));

		PartDefinition TailTip_1 = TailTip.addOrReplaceChild("TailTip_1", CubeListBuilder.create().texOffs(41, 74).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition PosteriorRibs = Pelvis.addOrReplaceChild("PosteriorRibs", CubeListBuilder.create().texOffs(-1, 114).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition SacralVertebrae = Pelvis.addOrReplaceChild("SacralVertebrae", CubeListBuilder.create().texOffs(21, 5).addBox(0.0F, 0.0F, 0.0F, 0.0F, 22.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -1.0F));

		PartDefinition Neck = Ribs.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(125, 47).addBox(0.0F, -2.0F, -8.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition CervicalRibs = Neck.addOrReplaceChild("CervicalRibs", CubeListBuilder.create().texOffs(123, 39).addBox(-2.0F, 0.0F, -7.0F, 4.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(56, 0).addBox(-3.0F, -1.5F, -8.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.6F, -7.5F, 0.4887F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(151, 0).addBox(-2.5F, -1.0F, -8.0F, 5.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Jaw_1 = Jaw.addOrReplaceChild("Jaw_1", CubeListBuilder.create().texOffs(180, 0).addBox(-1.5F, 0.0F, -4.99F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -8.0F));

		PartDefinition Beak = Head.addOrReplaceChild("Beak", CubeListBuilder.create().texOffs(85, 0).addBox(-2.0F, -3.0F, -5.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.5F, -8.0F));

		PartDefinition Beak_1 = Beak.addOrReplaceChild("Beak_1", CubeListBuilder.create().texOffs(229, 3).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition Nose = Beak.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(48, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -1.0F));

		PartDefinition Jugal = Head.addOrReplaceChild("Jugal", CubeListBuilder.create().texOffs(199, 2).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.5F, -4.0F));

		PartDefinition ThighL = partdefinition.addOrReplaceChild("ThighL", CubeListBuilder.create().texOffs(98, 4).mirror().addBox(-2.0F, -1.5F, -3.0F, 5.0F, 15.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5F, -2.5F, 9.0F, 0.0F, 0.2793F, 0.0F));

		PartDefinition LegBackL = ThighL.addOrReplaceChild("LegBackL", CubeListBuilder.create().texOffs(130, 0).mirror().addBox(-2.0F, -1.0F, -1.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.25F, 13.5F, 3.0F, 0.192F, 0.0F, 0.0F));

		PartDefinition FeetL = LegBackL.addOrReplaceChild("FeetL", CubeListBuilder.create().texOffs(130, 20).addBox(-2.5F, 0.0F, -4.01F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.0F, -0.5F, -0.192F, 0.0F, 0.0F));

		PartDefinition ThighR = partdefinition.addOrReplaceChild("ThighR", CubeListBuilder.create().texOffs(98, 4).addBox(-3.0F, -1.5F, -3.0F, 5.0F, 15.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -1.5F, 8.5F, -0.5061F, -0.2793F, 0.0F));

		PartDefinition LegBackR = ThighR.addOrReplaceChild("LegBackR", CubeListBuilder.create().texOffs(130, 0).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 12.5F, 4.5F, -0.4304F, 0.0F, 0.0F));

		PartDefinition FeetR = LegBackR.addOrReplaceChild("FeetR", CubeListBuilder.create().texOffs(130, 20).mirror().addBox(-2.5F, 0.0F, -4.0F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 1.117F, 0.0F, 0.0F));

		PartDefinition LegFrontR = partdefinition.addOrReplaceChild("LegFrontR", CubeListBuilder.create().texOffs(89, 70).addBox(0.0F, -1.0F, -2.0F, 3.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, -16.0F, 0.8727F, 0.0F, 0.0F));

		PartDefinition LegFrontL = partdefinition.addOrReplaceChild("LegFrontL", CubeListBuilder.create().texOffs(89, 70).mirror().addBox(-3.0F, -1.0F, -2.0F, 3.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 0.0F, -16.0F, 0.733F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(PlesiohadrosSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Ribs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		ThighL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		ThighR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LegFrontR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LegFrontL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
