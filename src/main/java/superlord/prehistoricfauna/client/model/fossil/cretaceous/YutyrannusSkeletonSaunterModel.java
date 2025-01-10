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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.YutyrannusSkeleton;

public class YutyrannusSkeletonSaunterModel extends EntityModel<YutyrannusSkeleton> {
 	private final ModelPart LeftLeg;
	private final ModelPart RightLeg1;
	private final ModelPart Ilium;

	public YutyrannusSkeletonSaunterModel(ModelPart root) {
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg1 = root.getChild("RightLeg1");
		this.Ilium = root.getChild("Ilium");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(22, 44).mirror().addBox(-4.0F, -0.5F, -2.0F, 5.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -3.0F, -1.0F, 0.3491F, 0.3491F, 0.2094F));

		PartDefinition LeftLeg2 = LeftLeg.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(5, 70).addBox(-0.5F, -1.0F, -3.0F, 5.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 12.5F, 7.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLeg2.addOrReplaceChild("LeftFoot", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 16.75F, -1.0F, 0.7086F, -0.1886F, -0.1104F));

		PartDefinition Box_r1 = LeftFoot.addOrReplaceChild("Box_r1", CubeListBuilder.create().texOffs(1, 93).mirror().addBox(-3.0F, 0.0F, -8.0F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.1781F, 0.0F, 0.0F));

		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(22, 44).addBox(-1.0F, -1.0F, -2.0F, 5.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -3.5F, 0.0F, -0.5236F, -0.3491F, 0.0F));

		PartDefinition RightLeg2 = RightLeg1.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(5, 70).mirror().addBox(-4.5F, -1.0F, -3.0F, 5.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 11.0F, 7.0F));

		PartDefinition RightFoot = RightLeg2.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(1, 93).addBox(-3.0F, -1.6F, -6.0F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 16.75F, -1.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition Ilium = partdefinition.addOrReplaceChild("Ilium", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.5F, 1.0F, 0.1396F, 0.0F, 0.0F));

		PartDefinition Sacrum = Ilium.addOrReplaceChild("Sacrum", CubeListBuilder.create().texOffs(69, 3).addBox(-4.0F, -1.0F, -7.0F, 8.0F, 8.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(-9, 2).addBox(-4.0F, 1.0F, -6.0F, 8.0F, 0.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(28, 76).addBox(0.0F, -2.0F, -9.0F, 0.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition PubisIschium_r1 = Sacrum.addOrReplaceChild("PubisIschium_r1", CubeListBuilder.create().texOffs(32, 85).mirror().addBox(0.0F, 0.0F, -7.0F, 0.0F, 13.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 5.0F, -1.0F, 0.0F, 0.0F, -0.3126F));

		PartDefinition PubisIschium_r2 = Sacrum.addOrReplaceChild("PubisIschium_r2", CubeListBuilder.create().texOffs(32, 85).addBox(0.0F, 0.0F, -7.0F, 0.0F, 13.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 5.0F, -1.0F, 0.0F, 0.0F, 0.3126F));

		PartDefinition CaudalVertebrae1 = Sacrum.addOrReplaceChild("CaudalVertebrae1", CubeListBuilder.create().texOffs(50, 5).addBox(0.0F, -3.1509F, 0.0462F, 0.0F, 11.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 9.0F, -0.2443F, -0.3491F, 0.0F));

		PartDefinition CaudalRibs1 = CaudalVertebrae1.addOrReplaceChild("CaudalRibs1", CubeListBuilder.create().texOffs(165, 27).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.8491F, 3.0462F));

		PartDefinition CaudalVertebrae2 = CaudalVertebrae1.addOrReplaceChild("CaudalVertebrae2", CubeListBuilder.create().texOffs(29, -5).addBox(0.0F, -4.0509F, 0.0349F, 0.0F, 8.0F, 41.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 20.0462F, 0.1745F, -0.3491F, 0.0F));

		PartDefinition CaudalRibs2 = CaudalVertebrae2.addOrReplaceChild("CaudalRibs2", CubeListBuilder.create().texOffs(171, 11).addBox(-2.0F, -1.0F, -12.0F, 4.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.0509F, 13.0349F));

		PartDefinition Body = Sacrum.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(28, 67).mirror().addBox(0.0F, -2.0F, -19.0F, 0.0F, 7.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(-5.0F, 0.0F, -20.0F, 10.0F, 16.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, -6.0F, 0.1047F, 0.1396F, 0.0698F));

		PartDefinition PectoralGirdle = Body.addOrReplaceChild("PectoralGirdle", CubeListBuilder.create().texOffs(65, 51).addBox(-6.0F, -1.0F, -16.0F, 12.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -3.0F));

		PartDefinition RightArm = PectoralGirdle.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(1, 49).mirror().addBox(-3.0F, 0.0F, 0.0F, 4.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, 7.5F, -13.0F, 0.384F, 0.0F, 0.1396F));

		PartDefinition LeftArm = PectoralGirdle.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(1, 49).addBox(-1.0F, -1.0F, -1.0F, 4.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 8.5F, -12.0F, 0.8727F, -0.3491F, 0.1745F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(43, 65).addBox(0.0F, -8.8F, -7.0F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(106, 65).addBox(-2.5F, -6.8F, -9.0F, 5.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -19.0F, 0.4538F, -0.2443F, 0.0F));

		PartDefinition Skull = Neck.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(111, 15).addBox(-3.0F, -1.0F, -5.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(111, 30).addBox(-3.0F, 5.0F, -5.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -7.0F, -0.384F, -0.1745F, 0.1745F));

		PartDefinition Jaw1 = Skull.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(111, 39).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(135, 33).addBox(-1.5F, -1.0F, -15.0F, 3.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Snout = Skull.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(135, 6).addBox(-2.0F, -1.0F, -10.0F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -5.0F));

		PartDefinition NasalCrest = Snout.addOrReplaceChild("NasalCrest", CubeListBuilder.create().texOffs(160, 6).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -8.0F));

		PartDefinition UpperTeeth = Snout.addOrReplaceChild("UpperTeeth", CubeListBuilder.create().texOffs(161, 35).addBox(-2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -12.0F));

		PartDefinition CrestRight = Snout.addOrReplaceChild("CrestRight", CubeListBuilder.create().texOffs(111, 52).mirror().addBox(0.0F, -2.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -2.0F, 0.0F));

		PartDefinition CrestLeft = Snout.addOrReplaceChild("CrestLeft", CubeListBuilder.create().texOffs(111, 52).addBox(-1.0F, -2.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 250, 250);
	}

	@Override
	public void setupAnim(YutyrannusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Ilium.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}