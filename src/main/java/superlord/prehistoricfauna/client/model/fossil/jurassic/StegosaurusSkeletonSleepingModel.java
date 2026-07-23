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

@SuppressWarnings("unused")
public class StegosaurusSkeletonSleepingModel extends EntityModel<StegosaurusSkeleton> {
	private final ModelPart Body;
	private final ModelPart Neck;
	private final ModelPart Neck1;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart RightNeckPlates;
	private final ModelPart LeftNeckPlates;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart Tail;
	private final ModelPart Tail1;
	private final ModelPart LeftTail1Plates;
	private final ModelPart RightTail1Plates;
	private final ModelPart Tail2;
	private final ModelPart Tail21;
	private final ModelPart LeftThagomizers;
	private final ModelPart RightThagomizers;
	private final ModelPart LeftTail2Plates;
	private final ModelPart RightTail2Plates;
	private final ModelPart RightBackPlates;
	private final ModelPart LeftBackPlates;
	private final ModelPart Body1;

	public StegosaurusSkeletonSleepingModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Neck = this.Body.getChild("Neck");
		this.Neck1 = this.Neck.getChild("Neck1");
		this.Head = this.Neck.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
		this.RightNeckPlates = this.Neck.getChild("RightNeckPlates");
		this.LeftNeckPlates = this.Neck.getChild("LeftNeckPlates");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.LeftThigh = this.Body.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = this.Body.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
		this.Tail = this.Body.getChild("Tail");
		this.Tail1 = this.Tail.getChild("Tail1");
		this.LeftTail1Plates = this.Tail1.getChild("LeftTail1Plates");
		this.RightTail1Plates = this.Tail1.getChild("RightTail1Plates");
		this.Tail2 = this.Tail.getChild("Tail2");
		this.Tail21 = this.Tail2.getChild("Tail21");
		this.LeftThagomizers = this.Tail21.getChild("LeftThagomizers");
		this.RightThagomizers = this.Tail21.getChild("RightThagomizers");
		this.LeftTail2Plates = this.Tail21.getChild("LeftTail2Plates");
		this.RightTail2Plates = this.Tail21.getChild("RightTail2Plates");
		this.RightBackPlates = this.Body.getChild("RightBackPlates");
		this.LeftBackPlates = this.Body.getChild("LeftBackPlates");
		this.Body1 = this.Body.getChild("Body1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-11.5F, 4.0F, 0.0F, 23.0F, 22.0F, 45.0F, new CubeDeformation(0.0F))
		.texOffs(107, 113).addBox(-12.0F, 5.9F, -0.5F, 24.0F, 20.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, -21.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(87, 77).addBox(-3.5F, 0.0F, -19.0F, 7.0F, 10.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.259F, -0.4235F, -0.1084F));

		PartDefinition Neck1 = Neck.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(218, 6).addBox(0.0F, -5.0F, -19.0F, 0.0F, 5.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(91, 0).addBox(-3.5F, -1.5F, -9.0F, 7.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(98, 0).addBox(-3.5F, 2.5F, -9.0F, 7.0F, 0.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(91, 14).addBox(-2.0F, -1.5F, -15.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -19.0F, 0.415F, 0.1667F, 0.0444F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(91, 24).addBox(-3.0F, 0.0F, -8.0F, 6.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(91, 36).addBox(-2.0F, 0.0F, -14.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.5F, -1.0F));

		PartDefinition RightNeckPlates = Neck.addOrReplaceChild("RightNeckPlates", CubeListBuilder.create().texOffs(70, 101).mirror().addBox(2.0F, -10.0F, 0.0F, 0.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, -19.0F, 0.0F, 0.0F, 0.1047F));

		PartDefinition LeftNeckPlates = Neck.addOrReplaceChild("LeftNeckPlates", CubeListBuilder.create().texOffs(70, 113).addBox(0.0F, -10.0F, 0.0F, 0.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -18.0F, 0.0F, 0.0F, -0.1047F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -4.0F, -4.0F, 7.0F, 27.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 19.0F, 7.0F, 0.2164F, -0.0283F, -0.1776F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -4.0F, 7.0F, 27.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 19.0F, 7.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition LeftThigh = Body.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(0, 71).mirror().addBox(-2.0F, -3.0F, -2.0F, 9.0F, 21.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, 10.0F, 32.0F, -0.3054F, 0.0F, -0.1309F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 107).mirror().addBox(-3.0F, -1.0F, -4.0F, 6.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 17.0F, 6.0F, 0.5133F, 0.1084F, -0.1897F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(0, 130).mirror().addBox(-3.5F, 0.0F, -6.0F, 7.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 12.0F, 0.1F, 0.3155F, -0.2494F, -0.0804F));

		PartDefinition RightThigh = Body.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(0, 71).addBox(-7.0F, -3.0F, -2.0F, 9.0F, 21.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 10.0F, 32.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 107).addBox(-3.0F, -1.0F, -4.0F, 6.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 17.0F, 6.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(0, 130).addBox(-3.5F, 0.0F, -6.0F, 7.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 12.0F, 0.1F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.0F, 45.0F, -0.3396F, 0.0972F, -0.3994F));

		PartDefinition Tail1 = Tail.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(188, 52).addBox(0.0F, -5.0F, 0.0F, 0.0F, 10.0F, 34.0F, new CubeDeformation(0.0F))
		.texOffs(28, 73).addBox(-5.0F, -1.0F, 0.0F, 10.0F, 0.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition LeftTail1Plates = Tail1.addOrReplaceChild("LeftTail1Plates", CubeListBuilder.create().texOffs(138, 28).addBox(0.0F, -20.0F, 0.0F, 0.0F, 20.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.0F, 10.0F, 0.0F, 0.0F, -0.1047F));

		PartDefinition RightTail1Plates = Tail1.addOrReplaceChild("RightTail1Plates", CubeListBuilder.create().texOffs(120, 39).mirror().addBox(0.0F, -19.0F, 0.0F, 0.0F, 19.0F, 33.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -1.0F, -3.0F, 0.0F, 0.0F, 0.1047F));

		PartDefinition Tail2 = Tail.addOrReplaceChild("Tail2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.75F, 0.75F, 34.0F, -0.1495F, -0.2669F, -0.6188F));

		PartDefinition Tail21 = Tail2.addOrReplaceChild("Tail21", CubeListBuilder.create().texOffs(105, 7).addBox(0.0F, -1.0F, 0.0F, 0.0F, 5.0F, 30.0F, new CubeDeformation(0.0F))
		.texOffs(99, 7).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftThagomizers = Tail21.addOrReplaceChild("LeftThagomizers", CubeListBuilder.create().texOffs(41, 119).mirror().addBox(-21.0F, 0.0F, 0.0F, 21.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, 19.0F, 0.0F, 0.0F, 0.5585F));

		PartDefinition RightThagomizers = Tail21.addOrReplaceChild("RightThagomizers", CubeListBuilder.create().texOffs(41, 119).addBox(0.0F, 0.0F, 0.0F, 21.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 19.0F, 0.0F, 0.0F, -0.5585F));

		PartDefinition LeftTail2Plates = Tail21.addOrReplaceChild("LeftTail2Plates", CubeListBuilder.create().texOffs(166, 10).addBox(0.0F, -10.0F, 0.0F, 0.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 5.0F, 0.0F, 0.0F, -0.0698F));

		PartDefinition RightTail2Plates = Tail21.addOrReplaceChild("RightTail2Plates", CubeListBuilder.create().texOffs(166, 14).mirror().addBox(0.0F, -13.0F, 0.0F, 0.0F, 13.0F, 25.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0698F));

		PartDefinition RightBackPlates = Body.addOrReplaceChild("RightBackPlates", CubeListBuilder.create().texOffs(172, 77).mirror().addBox(0.0F, -22.0F, 0.0F, 0.0F, 22.0F, 42.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.1396F));

		PartDefinition LeftBackPlates = Body.addOrReplaceChild("LeftBackPlates", CubeListBuilder.create().texOffs(164, 50).addBox(0.0F, -22.0F, 0.0F, 0.0F, 22.0F, 46.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 4.0F, 3.0F, 0.0F, 0.0F, -0.1396F));

		PartDefinition Body1 = Body.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(166, -45).addBox(0.0F, 0.0F, 0.0F, 0.0F, 20.0F, 45.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

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