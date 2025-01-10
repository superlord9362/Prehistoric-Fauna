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

public class YutyrannusSkeletonSubduedModel extends EntityModel<YutyrannusSkeleton> {
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart Body;

	public YutyrannusSkeletonSubduedModel(ModelPart root) {
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.Body = root.getChild("Body");
	}

	@SuppressWarnings("unused")
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(24, 46).addBox(-1.0F, -1.8827F, -2.9239F, 5.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 16.5F, 1.0F, -1.1781F, -0.1745F, 3.1416F));

		PartDefinition RightLeg3 = RightLeg.addOrReplaceChild("RightLeg3", CubeListBuilder.create().texOffs(5, 70).mirror().addBox(-4.5F, -1.8827F, -2.0761F, 5.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 12.0F, 4.0F, 2.3562F, 0.0F, 0.0F));

		PartDefinition RightFoot2 = RightLeg3.addOrReplaceChild("RightFoot2", CubeListBuilder.create().texOffs(1, 93).addBox(-3.0F, 0.665F, -7.0137F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 13.5F, -1.0F, 0.5585F, 0.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(22, 44).mirror().addBox(-4.0665F, -1.8769F, -2.9239F, 5.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 16.5F, 1.0F, -1.1603F, 0.3352F, -3.0712F));

		PartDefinition LeftLeg2 = LeftLeg.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(5, 70).addBox(-0.5665F, -2.4239F, -2.6231F, 5.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 11.0F, 4.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLeg2.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(1, 93).mirror().addBox(-3.0665F, -0.8868F, -7.0802F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 14.5F, -1.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(69, 3).addBox(-5.7788F, -30.4379F, -7.0F, 8.0F, 8.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(-9, 2).addBox(-5.7788F, -28.4379F, -6.0F, 8.0F, 0.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(28, 76).addBox(-1.7788F, -31.4379F, -9.0F, 0.0F, 6.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 1.0F, 0.0F, 0.0F, -3.0718F));

		PartDefinition PubisIschium_r1 = Body.addOrReplaceChild("PubisIschium_r1", CubeListBuilder.create().texOffs(32, 85).mirror().addBox(6.1301F, -24.7522F, -7.0F, 0.0F, 13.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 1.0F, -1.0F, 0.0F, 0.0F, -0.3126F));

		PartDefinition PubisIschium_r2 = Body.addOrReplaceChild("PubisIschium_r2", CubeListBuilder.create().texOffs(32, 85).addBox(-9.5153F, -23.6582F, -7.0F, 0.0F, 13.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 1.0F, -1.0F, 0.0F, 0.0F, 0.3126F));

		PartDefinition CaudalVertebrae1 = Body.addOrReplaceChild("CaudalVertebrae1", CubeListBuilder.create().texOffs(50, 5).addBox(0.0439F, -2.5886F, 0.0567F, 0.0F, 11.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -28.0F, 9.0F, -0.1745F, 0.2793F, 0.0F));

		PartDefinition CaudalRibs1 = CaudalVertebrae1.addOrReplaceChild("CaudalRibs1", CubeListBuilder.create().texOffs(165, 27).addBox(-6.0261F, -25.4052F, -4.2884F, 8.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(2.07F, 26.8166F, 4.3452F));

		PartDefinition CaudalVertebrae2 = CaudalVertebrae1.addOrReplaceChild("CaudalVertebrae2", CubeListBuilder.create().texOffs(29, -5).addBox(0.0015F, -4.4585F, -0.002F, 0.0F, 8.0F, 41.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.07F, 2.9675F, 19.5952F, 0.3491F, 0.3491F, 0.0F));

		PartDefinition CaudalRibs2 = CaudalVertebrae2.addOrReplaceChild("CaudalRibs2", CubeListBuilder.create().texOffs(171, 11).addBox(-3.9985F, -26.4388F, -12.038F, 4.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 24.9803F, 13.036F));

		PartDefinition Torso = Body.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(28, 67).mirror().addBox(-1.6997F, -2.4395F, -17.9607F, 0.0F, 7.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).mirror().addBox(-6.6997F, -0.4395F, -18.9607F, 10.0F, 16.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -28.0F, -7.0F, 0.0376F, 0.1783F, -0.0793F));

		PartDefinition PectoralGirdle = Torso.addOrReplaceChild("PectoralGirdle", CubeListBuilder.create().texOffs(65, 51).addBox(-7.6997F, -26.4395F, -15.9607F, 12.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 28.0F, -2.0F));

		PartDefinition RightArm = PectoralGirdle.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 8.5F, -12.0F, 0.2793F, 0.1745F, 0.0698F));

		PartDefinition Arm_r1 = RightArm.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(1, 49).mirror().addBox(12.8682F, -19.8955F, 5.4203F, 4.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.8378F));

		PartDefinition LeftArm = PectoralGirdle.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, 8.5F, -12.0F, 0.2793F, -0.1745F, -0.0698F));

		PartDefinition Arm_r2 = LeftArm.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(1, 49).addBox(-19.1515F, -17.4576F, 6.0517F, 4.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.8378F));

		PartDefinition Neck = Torso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(43, 65).addBox(-1.9302F, -12.0541F, -4.0347F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(106, 65).addBox(-4.4302F, -10.0541F, -6.0347F, 5.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 5.0F, -20.0F, 0.9034F, 0.2651F, 0.2298F));

		PartDefinition Skull = Neck.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(111, 15).addBox(-4.9302F, -17.8615F, 13.9954F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(111, 30).addBox(-4.9302F, -11.8615F, 13.9954F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0869F, -20.4985F, 0.1396F, 0.0F, 0.0F));

		PartDefinition Jaw1 = Skull.addOrReplaceChild("Jaw1", CubeListBuilder.create().texOffs(111, 39).addBox(-4.4302F, -0.4942F, -4.0237F, 5.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(135, 33).addBox(-3.4302F, -1.4942F, -14.0237F, 3.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 18.25F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Snout = Skull.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(135, 6).addBox(-3.9302F, -17.8615F, 8.9954F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -5.0F));

		PartDefinition NasalCrest = Snout.addOrReplaceChild("NasalCrest", CubeListBuilder.create().texOffs(160, 6).addBox(-2.9302F, -18.8615F, 18.9954F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -8.0F));

		PartDefinition UpperTeeth = Snout.addOrReplaceChild("UpperTeeth", CubeListBuilder.create().texOffs(161, 35).addBox(-3.9302F, -17.8615F, 20.9954F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -12.0F));

		PartDefinition CrestRight = Snout.addOrReplaceChild("CrestRight", CubeListBuilder.create().texOffs(111, 52).mirror().addBox(-1.9302F, -18.8615F, 16.9954F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -2.0F, 0.0F));

		PartDefinition CrestLeft = Snout.addOrReplaceChild("CrestLeft", CubeListBuilder.create().texOffs(111, 52).addBox(-2.9302F, -18.8615F, 16.9954F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 250, 250);
	}

	@Override
	public void setupAnim(YutyrannusSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}