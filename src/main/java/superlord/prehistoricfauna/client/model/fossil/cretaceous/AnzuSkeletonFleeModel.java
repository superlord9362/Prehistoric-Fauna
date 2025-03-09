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
import superlord.prehistoricfauna.common.entity.fossil.cretaceous.AnzuSkeleton;

@SuppressWarnings("unused")
public class AnzuSkeletonFleeModel extends EntityModel<AnzuSkeleton> {
	private final ModelPart Body1;
	private final ModelPart Body2;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart Neck1;
	private final ModelPart Head;
	private final ModelPart Snout;
	private final ModelPart Jaw;
	private final ModelPart crest;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart LeftThigh;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public AnzuSkeletonFleeModel(ModelPart root) {
		this.Body1 = root.getChild("Body1");
		this.Body2 = this.Body1.getChild("Body2");
		this.LeftArm = this.Body2.getChild("LeftArm");
		this.RightArm = this.Body2.getChild("RightArm");
		this.Neck1 = this.Body2.getChild("Neck1");
		this.Head = this.Neck1.getChild("Head");
		this.Snout = this.Head.getChild("Snout");
		this.Jaw = this.Head.getChild("Jaw");
		this.crest = this.Head.getChild("crest");
		this.Tail1 = this.Body1.getChild("Tail1");
		this.Tail2 = this.Tail1.getChild("Tail2");
		this.LeftThigh = root.getChild("LeftThigh");
		this.LeftLeg = this.LeftThigh.getChild("LeftLeg");
		this.LeftFoot = this.LeftLeg.getChild("LeftFoot");
		this.RightThigh = root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body1 = partdefinition.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-4.0F, -4.0F, -7.0F, 8.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(46, 23).mirror().addBox(0.0F, -5.0F, -7.0F, 0.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -8.0F, -3.0F, -0.2793F, 0.0F, 0.1745F));

		PartDefinition hips_r1 = Body1.addOrReplaceChild("hips_r1", CubeListBuilder.create().texOffs(56, 89).addBox(0.0F, -1.0F, -7.0F, 0.0F, 18.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.2374F));

		PartDefinition hips_r2 = Body1.addOrReplaceChild("hips_r2", CubeListBuilder.create().texOffs(56, 89).mirror().addBox(0.0F, -1.0F, -7.0F, 0.0F, 18.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.2374F));

		PartDefinition Body2 = Body1.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-4.5F, 0.0F, -13.0F, 9.0F, 14.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(59, 29).mirror().addBox(-5.0F, 2.0F, -13.0F, 10.0F, 10.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(46, 20).mirror().addBox(0.0F, -1.0F, -14.0F, 0.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.0F, -7.0F, 0.1745F, 0.1745F, 0.0F));

		PartDefinition torso_r1 = Body2.addOrReplaceChild("torso_r1", CubeListBuilder.create().texOffs(15, 33).mirror().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, -12.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body2.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(91, 72).addBox(-2.5F, -1.0F, 0.0F, 3.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 9.0F, -11.0F, -0.3144F, 0.3706F, -0.8101F));

		PartDefinition RightArm = Body2.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(91, 72).mirror().addBox(-0.5F, -1.0F, 0.0F, 3.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 9.0F, -11.0F, -1.1882F, -0.3636F, 0.9228F));

		PartDefinition Neck1 = Body2.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(8, 63).mirror().addBox(0.0F, -11.0F, -9.0F, 0.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(27, 64).mirror().addBox(-1.5F, 0.0F, -7.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, -14.0F, 0.2705F, 0.3405F, -0.2317F));

		PartDefinition neck2_r1 = Neck1.addOrReplaceChild("neck2_r1", CubeListBuilder.create().texOffs(16, 59).mirror().addBox(-3.0F, -9.0F, -3.5F, 2.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.0F, -5.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Head = Neck1.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 101).mirror().addBox(-1.5F, -1.0F, -6.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -11.0F, -6.0F, -0.4551F, 0.3799F, -0.0594F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(21, 104).mirror().addBox(-1.0F, -37.0F, -39.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(8, 103).mirror().addBox(-1.0F, -36.0F, -39.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 39.0F, 29.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(1, 111).mirror().addBox(-0.5F, 0.0F, -10.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 3.0F, 0.0F, 0.5585F, 0.0F, 0.0F));

		PartDefinition crest = Head.addOrReplaceChild("crest", CubeListBuilder.create().texOffs(38, 95).mirror().addBox(0.0F, -44.0F, -38.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 38.0F, 29.0F));

		PartDefinition Tail1 = Body1.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(56, 0).mirror().addBox(0.0F, -2.0F, 0.0F, 0.0F, 8.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -3.0F, 8.0F, 0.194F, 0.3471F, -0.038F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(102, 0).mirror().addBox(0.0F, -2.0F, 0.0F, 0.0F, 8.0F, 22.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(116, 17).mirror().addBox(-1.5F, -1.0F, 0.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(119, 14).mirror().addBox(-1.5F, 0.0F, 6.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(121, 12).mirror().addBox(-0.5F, 1.0F, 10.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(121, 9).mirror().addBox(-0.5F, 2.0F, 12.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(121, 7).mirror().addBox(-0.5F, 3.0F, 14.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.0F, 15.0F, 0.2819F, 0.3887F, 0.0576F));

		PartDefinition LeftThigh = partdefinition.addOrReplaceChild("LeftThigh", CubeListBuilder.create().texOffs(118, 66).addBox(-5.0F, -2.0F, -5.0F, 6.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -5.5F, -2.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition LeftLeg = LeftThigh.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(127, 94).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 13.0F, 5.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(122, 112).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 17.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition RightThigh = partdefinition.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(118, 66).mirror().addBox(-1.0F, -2.0F, -5.0F, 6.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -5.0F, -2.0F, -0.8168F, 0.4517F, 0.1996F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(127, 94).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 13.0F, 5.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(122, 112).mirror().addBox(-2.0F, 0.0F, -5.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 17.0F, 0.0F, 2.618F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 150, 124);
	}

	@Override
	public void setupAnim(AnzuSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}