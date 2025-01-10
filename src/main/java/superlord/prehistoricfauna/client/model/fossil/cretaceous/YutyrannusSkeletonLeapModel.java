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

public class YutyrannusSkeletonLeapModel extends EntityModel<YutyrannusSkeleton> {
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg1;
	private final ModelPart Body;

	public YutyrannusSkeletonLeapModel(ModelPart root) {
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg1 = root.getChild("RightLeg1");
		this.Body = root.getChild("Body");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(22, 44).mirror().addBox(-4.0F, 2.25F, -2.0F, 5.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -6.5F, 1.0F, -0.5585F, 0.2793F, 0.0F));

		PartDefinition LeftLeg2 = LeftLeg.addOrReplaceChild("LeftLeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 11.0F, 7.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition Box_r1 = LeftLeg2.addOrReplaceChild("Box_r1", CubeListBuilder.create().texOffs(5, 70).addBox(-1.5F, 2.1622F, -1.8641F, 5.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.5F, -3.0F, -0.5585F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLeg2.addOrReplaceChild("LeftFoot", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 16.5F, -1.0F, -0.6109F, 0.0F, 0.0F));

		PartDefinition Box_r2 = LeftFoot.addOrReplaceChild("Box_r2", CubeListBuilder.create().texOffs(1, 93).mirror().addBox(-3.0F, 3.25F, -7.0F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.0F, -11.25F, 0.5585F, 0.0F, 0.0F));

		PartDefinition RightLeg1 = partdefinition.addOrReplaceChild("RightLeg1", CubeListBuilder.create().texOffs(22, 44).addBox(-1.5303F, 0.4332F, 0.8683F, 5.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -5.5F, 2.0F, -1.7943F, -0.5931F, -0.0676F));

		PartDefinition RightLeg2 = RightLeg1.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(5, 70).mirror().addBox(-4.7279F, 1.3671F, -0.7847F, 5.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 12.0F, 5.0F, 0.9076F, -0.0698F, 0.0698F));

		PartDefinition RightFoot = RightLeg2.addOrReplaceChild("RightFoot", CubeListBuilder.create(), PartPose.offset(-2.0F, 15.5F, -1.0F));

		PartDefinition Box_r3 = RightFoot.addOrReplaceChild("Box_r3", CubeListBuilder.create().texOffs(1, 93).addBox(-3.2279F, 3.102F, -6.9423F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(69, 3).addBox(-4.0F, -5.1195F, -6.8255F, 8.0F, 8.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(-9, 2).addBox(-4.0F, -3.1195F, -5.8255F, 8.0F, 0.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(28, 76).addBox(0.0F, -6.1195F, -8.8255F, 0.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, 0.0F, -0.5585F, 0.0F, 0.0F));

		PartDefinition PubisIschium_r1 = Body.addOrReplaceChild("PubisIschium_r1", CubeListBuilder.create().texOffs(32, 85).mirror().addBox(-0.9478F, 2.9327F, -5.9688F, 0.0F, 13.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -2.2016F, -1.8568F, 0.0F, 0.0F, -0.3126F));

		PartDefinition PubisIschium_r2 = Body.addOrReplaceChild("PubisIschium_r2", CubeListBuilder.create().texOffs(32, 85).addBox(0.9478F, 2.9327F, -5.9688F, 0.0F, 13.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -2.2016F, -1.8568F, 0.0F, 0.0F, 0.3126F));

		PartDefinition CaudalVertebrae1 = Body.addOrReplaceChild("CaudalVertebrae1", CubeListBuilder.create().texOffs(50, 5).addBox(0.3527F, -0.0088F, 0.7979F, 0.0F, 11.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.2016F, 8.1432F, -0.1047F, -0.3491F, 0.0F));

		PartDefinition CaudalRibs1 = CaudalVertebrae1.addOrReplaceChild("CaudalRibs1", CubeListBuilder.create().texOffs(165, 27).addBox(-3.6473F, 3.1421F, -2.2483F, 8.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.8491F, 3.0462F));

		PartDefinition CaudalVertebrae2 = CaudalVertebrae1.addOrReplaceChild("CaudalVertebrae2", CubeListBuilder.create().texOffs(29, -5).addBox(0.5885F, -1.3835F, -0.5368F, 0.0F, 8.0F, 41.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.5F, 20.0462F, 0.3142F, -0.3491F, 0.0F));

		PartDefinition CaudalRibs2 = CaudalVertebrae2.addOrReplaceChild("CaudalRibs2", CubeListBuilder.create().texOffs(171, 11).addBox(-1.4115F, 1.6675F, -12.5718F, 4.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.0509F, 13.0349F));

		PartDefinition Torso = Body.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(28, 67).mirror().addBox(0.2238F, 1.0791F, -17.9844F, 0.0F, 7.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(-4.7762F, 3.0791F, -18.9844F, 10.0F, 16.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -6.2016F, -6.8568F, 0.2793F, -0.0873F, 0.0436F));

		PartDefinition PectoralGirdle = Torso.addOrReplaceChild("PectoralGirdle", CubeListBuilder.create().texOffs(65, 51).addBox(-5.7762F, 2.0791F, -14.9844F, 12.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -3.0F));

		PartDefinition RightArm = PectoralGirdle.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 8.5F, -12.0F, 0.2793F, 0.1745F, 0.0698F));

		PartDefinition Arm_r1 = RightArm.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(1, 49).mirror().addBox(-2.892F, -0.8659F, -0.6433F, 4.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -0.3874F, 0.5236F, -0.1014F));

		PartDefinition LeftArm = PectoralGirdle.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, 8.5F, -12.0F, 0.9774F, -0.7679F, 0.1745F));

		PartDefinition Arm_r2 = LeftArm.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(1, 49).addBox(0.2487F, 0.8447F, -3.3665F, 4.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 4.0F, -1.0F, -1.9609F, 0.9443F, -0.7411F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(43, 65).addBox(0.7016F, -8.7209F, -7.2324F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(106, 65).addBox(-1.7984F, -6.7209F, -9.2324F, 5.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 4.0F, -21.0F, 1.3963F, -0.5236F, 0.0F));

		PartDefinition Skull = Neck.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(111, 15).addBox(-3.0181F, -1.3011F, -4.8318F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(111, 30).addBox(-3.0181F, 4.6989F, -4.8318F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, -8.0F, -6.25F, -0.9795F, -0.2961F, 0.2771F));

		PartDefinition Jaw1 = Skull.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(111, 39).addBox(-1.7128F, -0.0713F, -4.8722F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(135, 33).addBox(-0.7128F, -1.0713F, -14.8722F, 3.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3053F, 4.8317F, 0.1068F, 0.6283F, 0.0F, 0.0F));

		PartDefinition Snout = Skull.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(135, 6).addBox(-1.7128F, 1.3672F, -7.7917F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.3053F, -0.6683F, -7.0401F));

		PartDefinition NasalCrest = Snout.addOrReplaceChild("NasalCrest", CubeListBuilder.create().texOffs(160, 6).addBox(-0.7128F, 0.3672F, 2.2083F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -8.0F));

		PartDefinition UpperTeeth = Snout.addOrReplaceChild("UpperTeeth", CubeListBuilder.create().texOffs(161, 35).addBox(-1.7128F, 1.3672F, 4.2083F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -12.0F));

		PartDefinition CrestRight = Snout.addOrReplaceChild("CrestRight", CubeListBuilder.create().texOffs(111, 52).mirror().addBox(0.2872F, 0.3672F, 0.2083F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -2.0F, 0.0F));

		PartDefinition CrestLeft = Snout.addOrReplaceChild("CrestLeft", CubeListBuilder.create().texOffs(111, 52).addBox(-0.7128F, 0.3672F, 0.2083F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -2.0F, 0.0F));

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