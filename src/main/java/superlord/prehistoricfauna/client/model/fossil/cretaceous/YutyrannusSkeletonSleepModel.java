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

public class YutyrannusSkeletonSleepModel extends EntityModel<YutyrannusSkeleton> {
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg1;
	private final ModelPart Body;

	public YutyrannusSkeletonSleepModel(ModelPart root) {
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg1 = root.getChild("RightLeg1");
		this.Body = root.getChild("Body");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(23, 45).mirror().addBox(-5.0F, 8.0306F, 7.3514F, 5.0F, 15.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, -5.0F, -1.0F, -0.8029F, 0.8378F, 0.0F));

		PartDefinition LeftLeg2 = LeftLeg.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(5, 70).addBox(-1.5F, -0.75F, 13.75F, 5.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 11.25F, 6.25F, -0.7679F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLeg2.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(1, 93).mirror().addBox(-3.0F, -1.25F, -6.25F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 14.0F, 16.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(23, 45).addBox(-1.2756F, -1.0032F, -1.3871F, 5.0F, 15.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 7.5F, 0.0F, -0.8029F, -0.2094F, 0.0F));

		PartDefinition RightLeg2 = RightLeg1.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(5, 70).mirror().addBox(-4.5F, 0.0F, 12.0F, 5.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.7244F, 2.9663F, -0.7385F, -0.7679F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLeg2.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(2, 94).addBox(-3.0F, 14.0F, -4.0F, 6.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 16.0F, -1.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(69, 3).addBox(-4.0F, 7.8025F, -4.7426F, 8.0F, 8.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(-9, 2).addBox(-4.0F, 9.8025F, -3.7426F, 8.0F, 0.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(28, 76).addBox(0.0F, 6.8025F, -6.7426F, 0.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition PubisIschium_r1 = Body.addOrReplaceChild("PubisIschium_r1", CubeListBuilder.create().texOffs(32, 85).mirror().addBox(-3.9371F, 12.1821F, -4.7426F, 0.0F, 13.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 1.0F, -1.0F, 0.0F, 0.0F, -0.3126F));

		PartDefinition PubisIschium_r2 = Body.addOrReplaceChild("PubisIschium_r2", CubeListBuilder.create().texOffs(32, 85).addBox(3.9371F, 12.1821F, -4.7426F, 0.0F, 13.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 1.0F, -1.0F, 0.0F, 0.0F, 0.3126F));

		PartDefinition CaudalVertebrae1 = Body.addOrReplaceChild("CaudalVertebrae1", CubeListBuilder.create().texOffs(50, 5).addBox(0.9182F, 8.7724F, 5.1444F, 0.0F, 11.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 9.0F, -0.2443F, -0.4189F, 0.0F));

		PartDefinition CaudalRibs1 = CaudalVertebrae1.addOrReplaceChild("CaudalRibs1", CubeListBuilder.create().texOffs(165, 27).addBox(-3.0818F, 11.9233F, 2.0982F, 8.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.8491F, 3.0462F));

		PartDefinition CaudalVertebrae2 = CaudalVertebrae1.addOrReplaceChild("CaudalVertebrae2", CubeListBuilder.create().texOffs(29, -5).addBox(0.0141F, -3.8876F, -0.024F, 0.0F, 8.0F, 41.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9F, 14.25F, 25.1462F, 0.1396F, -0.5934F, 0.0F));

		PartDefinition CaudalRibs2 = CaudalVertebrae2.addOrReplaceChild("CaudalRibs2", CubeListBuilder.create().texOffs(171, 11).addBox(1.6121F, 11.4849F, -11.7172F, 4.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.598F, -12.3725F, 12.6932F));

		PartDefinition Torso = Body.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(28, 67).mirror().addBox(-1.1287F, 10.4908F, -22.4213F, 0.0F, 7.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 0).mirror().addBox(-6.1287F, 12.4908F, -23.4213F, 10.0F, 16.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -3.0F, -6.0F, 0.4189F, 0.5236F, 0.0F));

		PartDefinition PectoralGirdle = Torso.addOrReplaceChild("PectoralGirdle", CubeListBuilder.create().texOffs(65, 51).addBox(-7.1287F, 11.4908F, -19.4213F, 12.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -3.0F));

		PartDefinition RightArm = PectoralGirdle.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 8.5F, -12.0F, 0.2793F, 0.1745F, 0.0698F));

		PartDefinition Arm_r1 = RightArm.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(1, 49).mirror().addBox(-11.1767F, 2.6318F, 8.4314F, 4.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.25F, 0.0F, -1.7658F, -0.1758F, -0.7245F));

		PartDefinition LeftArm = PectoralGirdle.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, 8.5F, -12.0F, 0.3491F, -0.1745F, -0.0698F));

		PartDefinition Arm_r2 = LeftArm.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(1, 49).addBox(4.6655F, 0.6014F, 10.5904F, 4.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.8883F, 0.2351F, 0.6167F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(43, 65).addBox(0.0211F, -12.0267F, -5.0153F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(106, 65).addBox(-2.4789F, -10.0267F, -7.0153F, 5.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 15.5F, -21.0F, 1.0908F, 0.3491F, 0.1047F));

		PartDefinition Skull = Neck.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(111, 15).addBox(-2.9952F, -1.04F, -5.019F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(111, 30).addBox(-2.9952F, 4.96F, -5.019F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0711F, -11.0373F, -4.2848F, -0.9076F, 0.0698F, -0.3491F));

		PartDefinition Jaw1 = Skull.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(111, 39).addBox(-1.9722F, 12.4738F, -8.5571F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(135, 33).addBox(-0.9722F, 11.4738F, -18.5571F, 3.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.523F, -7.5038F, 3.6381F));

		PartDefinition Snout = Skull.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(135, 6).addBox(-1.4722F, 11.4638F, -13.6571F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.523F, -10.5038F, -1.3619F));

		PartDefinition NasalCrest = Snout.addOrReplaceChild("NasalCrest", CubeListBuilder.create().texOffs(160, 6).addBox(-0.4722F, 10.4638F, -3.6571F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -8.0F));

		PartDefinition UpperTeeth = Snout.addOrReplaceChild("UpperTeeth", CubeListBuilder.create().texOffs(161, 35).addBox(-1.4722F, 11.4638F, -1.6571F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -12.0F));

		PartDefinition CrestRight = Snout.addOrReplaceChild("CrestRight", CubeListBuilder.create().texOffs(111, 52).mirror().addBox(0.5278F, 10.4638F, -5.6571F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -2.0F, 0.0F));

		PartDefinition CrestLeft = Snout.addOrReplaceChild("CrestLeft", CubeListBuilder.create().texOffs(111, 52).addBox(-0.4722F, 10.4638F, -5.6571F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 250, 250);
	}

	@Override
	public void setupAnim(YutyrannusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}