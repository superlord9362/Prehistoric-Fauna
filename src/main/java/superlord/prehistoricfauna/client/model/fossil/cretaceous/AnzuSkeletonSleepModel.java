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
public class AnzuSkeletonSleepModel extends EntityModel<AnzuSkeleton> {
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
	private final ModelPart RightThigh2;
	private final ModelPart RightLeg2;
	private final ModelPart RightFoot2;
	private final ModelPart RightThigh;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public AnzuSkeletonSleepModel(ModelPart root) {
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
		this.RightThigh2 = root.getChild("RightThigh2");
		this.RightLeg2 = this.RightThigh2.getChild("RightLeg2");
		this.RightFoot2 = this.RightLeg2.getChild("RightFoot2");
		this.RightThigh = root.getChild("RightThigh");
		this.RightLeg = this.RightThigh.getChild("RightLeg");
		this.RightFoot = this.RightLeg.getChild("RightFoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body1 = partdefinition.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(1, 1).mirror().addBox(-4.0F, -4.0F, -7.0F, 8.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(46, 23).mirror().addBox(0.0F, -5.0F, -7.0F, 0.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 7.0F, 3.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition hips_r1 = Body1.addOrReplaceChild("hips_r1", CubeListBuilder.create().texOffs(56, 89).addBox(0.0F, -1.0F, -7.0F, 0.0F, 18.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.2374F));

		PartDefinition hips_r2 = Body1.addOrReplaceChild("hips_r2", CubeListBuilder.create().texOffs(56, 89).mirror().addBox(0.0F, -1.0F, -7.0F, 0.0F, 18.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.2374F));

		PartDefinition Body2 = Body1.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(0, 33).mirror().addBox(-4.5F, 0.0F, -13.0F, 9.0F, 14.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(59, 29).mirror().addBox(-5.0F, 2.0F, -13.0F, 10.0F, 10.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(46, 20).mirror().addBox(0.0F, -1.0F, -14.0F, 0.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.0F, -7.0F, 0.1745F, -0.2618F, 0.1745F));

		PartDefinition torso_r1 = Body2.addOrReplaceChild("torso_r1", CubeListBuilder.create().texOffs(15, 33).mirror().addBox(-4.5F, 0.0F, 0.0F, 9.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, -12.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body2.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(91, 72).addBox(-2.5F, -1.0F, 0.0F, 3.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 9.0F, -11.0F, 0.1745F, 0.2443F, 0.3491F));

		PartDefinition RightArm = Body2.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(91, 72).mirror().addBox(-0.5F, -1.0F, 0.0F, 3.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 9.0F, -11.0F, 0.0F, -0.2443F, -0.5236F));

		PartDefinition Neck1 = Body2.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(8, 63).mirror().addBox(0.0F, -11.0F, -9.0F, 0.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(27, 64).mirror().addBox(-1.5F, 0.0F, -7.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, -14.0F, 0.1745F, -0.8727F, 0.3491F));

		PartDefinition neck2_r1 = Neck1.addOrReplaceChild("neck2_r1", CubeListBuilder.create().texOffs(16, 59).mirror().addBox(-3.0F, -9.0F, -3.5F, 2.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.0F, -5.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Head = Neck1.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 101).mirror().addBox(-1.5F, -1.0F, -6.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.4762F, -10.8694F, -7.0787F, 0.4363F, -1.3963F, -0.1745F));

		PartDefinition Snout = Head.addOrReplaceChild("Snout", CubeListBuilder.create().texOffs(21, 104).mirror().addBox(-1.0F, -37.0F, -39.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(8, 103).mirror().addBox(-1.0F, -36.0F, -39.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 39.0F, 29.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(1, 111).mirror().addBox(-0.5F, 0.0F, -10.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 3.0F, 0.0F));

		PartDefinition crest = Head.addOrReplaceChild("crest", CubeListBuilder.create().texOffs(38, 95).mirror().addBox(0.0F, -44.0F, -38.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 38.0F, 29.0F));

		PartDefinition Tail1 = Body1.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(52, 0).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(56, 0).mirror().addBox(0.0F, -2.0F, 0.0F, 0.0F, 8.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(52, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(56, 0).addBox(0.0F, -2.0F, 0.0F, 0.0F, 8.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 8.0F, -0.4887F, 0.5236F, 0.0F));

		PartDefinition Tail2 = Tail1.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(116, 17).mirror().addBox(-1.5F, -1.0F, 0.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(119, 14).mirror().addBox(-1.5F, 0.0F, 6.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(121, 12).mirror().addBox(-0.5F, 1.0F, 10.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(121, 9).mirror().addBox(-0.5F, 2.0F, 12.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(121, 7).mirror().addBox(-0.5F, 3.0F, 14.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(102, 0).addBox(0.0F, -2.0F, 0.0F, 0.0F, 8.0F, 22.0F, new CubeDeformation(0.0F))
				.texOffs(116, 17).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 0.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(119, 14).addBox(-1.5F, 0.0F, 6.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(121, 12).addBox(-0.5F, 1.0F, 10.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(121, 9).addBox(-0.5F, 2.0F, 12.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(121, 7).addBox(-0.5F, 3.0F, 14.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 15.0F, 0.4887F, 0.6109F, 0.0F));

		PartDefinition RightThigh2 = partdefinition.addOrReplaceChild("RightThigh2", CubeListBuilder.create().texOffs(118, 66).mirror().addBox(-1.0F, -2.0F, -5.0F, 6.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 10.8F, 5.0F, -0.6981F, 0.3491F, 0.0F));

		PartDefinition RightLeg2 = RightThigh2.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(127, 94).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 13.0F, 5.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition RightFoot2 = RightLeg2.addOrReplaceChild("RightFoot2", CubeListBuilder.create().texOffs(122, 112).mirror().addBox(-2.0F, 0.0F, -5.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 17.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition RightThigh = partdefinition.addOrReplaceChild("RightThigh", CubeListBuilder.create().texOffs(118, 66).addBox(-5.0F, -2.0F, -5.0F, 6.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 10.8F, 5.0F, -0.6981F, -0.3491F, 0.0F));

		PartDefinition RightLeg = RightThigh.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(127, 94).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 13.0F, 5.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(122, 112).addBox(-2.0F, 0.0F, -5.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 17.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 150, 124);
	}

	@Override
	public void setupAnim(AnzuSkeleton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightThigh2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightThigh.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}